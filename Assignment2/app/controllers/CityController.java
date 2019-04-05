package controllers;

import models.City;
import models.Country;
import play.mvc.With;

/**
 * @author Weichen Wang
 * @date 2019/4/1 - 3:37 PM
 * @description: Manually create, update, and/or delete cities.
 * <p>
 * Requirements: 1. play dependencies (include play -> crud)
 * 2. imports CRUD route(*  /admin    module:crud)
 * 3. extend CRUD for you controller class
 * 4. Add Annotation: @CRUD.For(City.class)
 */
@With(Secure.class)
@CRUD.For(City.class)
public class CityController extends CRUD {
}
