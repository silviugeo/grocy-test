package com.endava.grocy.entity.location;

import com.endava.grocy.TestBaseClass;
import com.endava.grocy.model.EntityType;
import com.endava.grocy.model.Location;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.notNullValue;

public class CreateLocationTest extends TestBaseClass {

    @Test
    public void shouldCreateLocation(){
        //GIVEN
        Location location = dataProvider.getLocation();

        //WHEN
        Response response = entityClient.createEntity(EntityType.LOCATION, location);

        //THEN
        response.then().statusCode(HttpStatus.SC_OK)
                .body("created_object_id", notNullValue());
    }
}
