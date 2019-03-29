package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import exceptions.DataFormatException;
import play.mvc.Controller;
import play.mvc.With;

import models.*;

@With(Secure.class)
public class CustomLoader extends Controller {
    public static void loader() {
        render();
    }

    public static void uploadJSON(File jsonData, boolean clearData) {
        try {
            System.out.println(clearData);
            if (clearData) play.test.Fixtures.deleteDatabase();

            InputStream input = new FileInputStream(jsonData);
            populateDatabase(input);

            flash.success("File uploaded successfully and database updated");
        } catch (FileNotFoundException fe) {
            flash.error("Failed to locate the uploaded JSON file.");
            fe.printStackTrace();
        } catch (DataFormatException de) {
            flash.error("Data formating error: " + de.getMessage());
            de.printStackTrace();
        } catch (JSONException je) {
            flash.error("JSON library exception raised while loading the file. ");
            je.printStackTrace();
        }
        loader();
    }

    private static void populateDatabase(InputStream input)
            throws DataFormatException, FileNotFoundException, JSONException {

        // Parse the JSON file and make sure it's not completely broken.
        JSONTokener parser = new JSONTokener(input);
        JSONObject data = new JSONObject(parser);

        // Check if file has the key "customers"
        if (!data.has("customers"))
            throw new DataFormatException("No key 'customers', nothing I can do with these data.", data);

        // Load the array of customers
        JSONArray customersArray = data.getJSONArray("customers");

        // Check if the data for "customers" is a an array
        if (!(customersArray instanceof JSONArray))
            throw new DataFormatException("Key 'customer' must point to a JSON array.", data);


        // Loop through all countries
        for (int i = 0; i < customersArray.length(); i++) {
            JSONObject customerJSON = customersArray.getJSONObject(i);

            if (!(customerJSON.has("customerName") && customerJSON.get("customerName") instanceof String))
                throw new DataFormatException("All customer must be named.", data);

            if (!(customerJSON.has("customerNumber") && customerJSON.get("customerNumber") instanceof Integer))
                throw new DataFormatException("Missing number for customer " + customerJSON.get("name"), data);


            Integer customerNumber = customerJSON.getInt("customerNumber");
            String customerName = customerJSON.getString("customerName");

            // Check if there is already a customer with this number in database
            if (null != Customer.find("byCustomerNumber", customerNumber).first())
                throw new DataFormatException("There is already an existing customer with number " + customerNumber, data);


            Customer customer = new Customer(customerNumber, customerName);
            customer.save();

            // Scan the accounts of the current customer in JSON file
            if (customerJSON.has("accounts") && customerJSON.get("accounts") instanceof JSONArray) {

                JSONArray accountsArray = customerJSON.getJSONArray("accounts");

                for (int j = 0; j < accountsArray.length(); j++) {
                    JSONObject accountJSON = accountsArray.getJSONObject(j);

                    if (!accountJSON.has("accountNumber") && accountJSON.get("accountNumber") instanceof Integer)
                        throw new DataFormatException("Missing account number for customer " + customerName, data);

                    if (!accountJSON.has("isCurrentAccount") && accountJSON.get("isCurrentAccount") instanceof Boolean)
                        throw new DataFormatException("Missing account type for customer " + customerName, data);

                    Integer accountNumber = accountJSON.getInt("accountNumber");
                    Boolean currentAccount = accountJSON.getBoolean("isCurrentAccount");

                    if (null != Account.find("byAccountNumber", accountNumber).first()) {
                        throw new DataFormatException("There is already an existing account with number " + accountNumber, data);
                    }

                    // Create and save to database
                    Account account = new Account(accountNumber, currentAccount);
                    account.save();

                    customer.accounts.add(account);
                    customer.save();
                }
            }
        }
        // Now that we have all the countries, deal with borders
        if (data.has("related")) {
            JSONObject relationsJSON = data.getJSONObject("related");
            for (String k : relationsJSON.keySet()) {
                Integer customerNumber = Integer.parseInt(k);
                Customer c = Customer.find("byCustomerNumber", customerNumber).first();

                if (null == c)
                    throw new DataFormatException("There is no customer with number " + customerNumber, data);

                JSONArray relationsArray = relationsJSON.getJSONArray(k);

                for (int i = 0; i < relationsArray.length(); i++) {
                    Integer rCustomerNumber = relationsArray.getInt(i);

                    Customer cr = Customer.find("byCustomerNumber", rCustomerNumber).first();

                    if (null == cr)
                        throw new DataFormatException("There is no customer with number " + customerNumber, data);

                    c.related.add(cr);
                }

            }
        }
    }
}
