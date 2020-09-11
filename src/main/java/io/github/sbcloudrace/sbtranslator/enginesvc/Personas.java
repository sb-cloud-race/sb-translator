package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/personas")
public class Personas {

    @RequestMapping(value = "/{personaId}/carslots", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public CarSlotInfoTrans carslots(@PathVariable Long personaId) {
        ArrayOfOwnedCarTrans arrayOfOwnedCarTrans = new ArrayOfOwnedCarTrans();
        arrayOfOwnedCarTrans.getOwnedCarTrans().add(mockOwnedCar());

        CarSlotInfoTrans carSlotInfoTrans = new CarSlotInfoTrans();
        carSlotInfoTrans.setCarsOwnedByPersona(arrayOfOwnedCarTrans);
        carSlotInfoTrans.setDefaultOwnedCarIndex(0);
        carSlotInfoTrans.setObtainableSlots(new ArrayOfProductTrans());
        int carlimit = 10;
        carSlotInfoTrans.setOwnedCarSlotsCount(carlimit);
        ArrayOfProductTrans arrayOfProductTrans = new ArrayOfProductTrans();
        ProductTrans productTrans = new ProductTrans();
        productTrans.setBundleItems(new ArrayOfProductTrans());
        productTrans.setCategoryId("");
        productTrans.setCurrency("_NS");
        productTrans.setDescription("New car slot !!");
        productTrans.setDurationMinute(0);
        productTrans.setHash(-1143680669);
        productTrans.setIcon("128_cash");
        productTrans.setLevel(70);
        productTrans.setLongDescription("New car slot !");
        productTrans.setPrice(100.0000);
        productTrans.setPriority(0);
        productTrans.setProductId("SRV-GARAGESLOT");
        productTrans.setSecondaryIcon("");
        productTrans.setUseCount(1);
        productTrans.setVisualStyle("");
        productTrans.setWebIcon("");
        productTrans.setWebLocation("");
        arrayOfProductTrans.getProductTrans().add(productTrans);
        carSlotInfoTrans.setObtainableSlots(arrayOfProductTrans);
        return carSlotInfoTrans;
    }

    private OwnedCarTrans mockOwnedCar() {
//    <CustomCar>
//        <BaseCar>2020296126</BaseCar>
//        <CarClassHash>-2142411446</CarClassHash>
//        <Id>6473001</Id>
//        <IsPreset>true</IsPreset>
//        <Level>0</Level>
//        <Name>rtrx69</Name>
//        <Paints/>
//        <PerformanceParts/>
//        <PhysicsProfileHash>-2114067581</PhysicsProfileHash>
//        <Rating>763</Rating>
//        <ResalePrice>550000</ResalePrice>
//        <RideHeightDrop>0</RideHeightDrop>
//        <SkillModParts/>
//        <SkillModSlotCount>5</SkillModSlotCount>
//        <Version>0</Version>
//        <Vinyls/>
//        <VisualParts/>
//    </CustomCar>
//    <Durability>100</Durability>
//    <ExpirationDate i:nil="true"/>
//    <Heat>1</Heat>
//    <Id>3</Id>
//    <OwnershipType>PresetCar</OwnershipType>
        OwnedCarTrans ownedCarTrans = new OwnedCarTrans();
        CustomCarTrans customCarTrans = new CustomCarTrans();
        customCarTrans.setBaseCar(2020296126);
        customCarTrans.setCarClassHash(-2142411446);
        customCarTrans.setId(6473001);
        customCarTrans.setIsPreset(true);
        customCarTrans.setLevel(0);
        customCarTrans.setName("rtrx69");
        customCarTrans.setPaints(new ArrayOfCustomPaintTrans());
        customCarTrans.setPerformanceParts(new ArrayOfPerformancePartTrans());
        customCarTrans.setPhysicsProfileHash(-2114067581);
        customCarTrans.setRating(763);
        customCarTrans.setResalePrice(550000);
        customCarTrans.setRideHeightDrop(0);
        customCarTrans.setSkillModParts(new ArrayOfSkillModPartTrans());
        customCarTrans.setSkillModSlotCount(5);
        customCarTrans.setVersion(0);
        customCarTrans.setVinyls(new ArrayOfCustomVinylTrans());
        customCarTrans.setVisualParts(new ArrayOfVisualPartTrans());
        ownedCarTrans.setCustomCar(customCarTrans);
        ownedCarTrans.setDurability(100);
//        ownedCarTrans.setExpirationDate(null);
        ownedCarTrans.setHeat(1F);
        ownedCarTrans.setId(1L);
        return ownedCarTrans;
    }
}