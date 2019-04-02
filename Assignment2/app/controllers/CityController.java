package controllers;

import models.City;
import models.Country;
import play.mvc.With;

/**
 * @author Weichen Wang
 * @date 2019/4/1 - 3:37 PM
 * @description: ${description}
 */
@With(Secure.class)
@CRUD.For(City.class)
public class CityController {
}
