package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.ArrayOfCarClass;
import io.github.sbcloudrace.sbtranslator.jaxb.http.CarClass;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class CarClasses {

    @RequestMapping(value = "/carclasses", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ArrayOfCarClass carClasses() {
        ArrayOfCarClass arrayOfCarClass = new ArrayOfCarClass();
        CarClass carClass = new CarClass();
        carClass.setCarClassHash(-2142411446);
        carClass.setMaxRating((short) 999);
        carClass.setMinRating((short) 750);
        arrayOfCarClass.getCarClass().add(carClass);
        CarClass carClass2 = new CarClass();
        carClass2.setCarClassHash(-406473455);
        carClass2.setMaxRating((short) 599);
        carClass2.setMinRating((short) 500);
        arrayOfCarClass.getCarClass().add(carClass2);
        CarClass carClass3 = new CarClass();
        carClass3.setCarClassHash(-405837480);
        carClass3.setMaxRating((short) 749);
        carClass3.setMinRating((short) 600);
        arrayOfCarClass.getCarClass().add(carClass3);
        CarClass carClass4 = new CarClass();
        carClass4.setCarClassHash(415909161);
        carClass4.setMaxRating((short) 399);
        carClass4.setMinRating((short) 250);
        arrayOfCarClass.getCarClass().add(carClass4);
        CarClass carClass5 = new CarClass();
        carClass5.setCarClassHash(872416321);
        carClass5.setMaxRating((short) 249);
        carClass5.setMinRating((short) 0);
        arrayOfCarClass.getCarClass().add(carClass5);
        CarClass carClass6 = new CarClass();
        carClass6.setCarClassHash(1866825865);
        carClass6.setMaxRating((short) 499);
        carClass6.setMinRating((short) 400);
        arrayOfCarClass.getCarClass().add(carClass6);
        return arrayOfCarClass;
    }
}
