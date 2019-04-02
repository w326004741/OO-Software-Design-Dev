package controllers;

import models.Country;
import play.mvc.With;

/**
 * @author Weichen Wang
 * @date 2019/4/1 - 3:31 PM
 * @description: ${description}
 */
@With(Secure.class)
@CRUD.For(Country.class)
public class CountryController extends CRUD {
}
