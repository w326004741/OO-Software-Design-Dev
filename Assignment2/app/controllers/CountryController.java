package controllers;

import models.Country;
import play.mvc.With;

/**
 * @author Weichen Wang
 * @date 2019/4/1 - 3:31 PM
 * @description: Manually create, update, and/or delete cities.
 * <p>
 * Requirements: 1. play dependencies (include play -> crud)
 * 2. imports CRUD route(*  /admin    module:crud)
 * 3. extend CRUD for you controller class
 * 4. Add Annotation: @CRUD.For(Country.class)
 */
@With(Secure.class)
@CRUD.For(Country.class)
public class CountryController extends CRUD {
}
