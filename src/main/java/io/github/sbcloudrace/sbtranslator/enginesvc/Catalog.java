package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.ArrayOfCategoryTrans;
import io.github.sbcloudrace.sbtranslator.jaxb.http.ArrayOfProductTrans;
import io.github.sbcloudrace.sbtranslator.jaxb.http.ProductTrans;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/catalog")
public class Catalog {

    @RequestMapping(value = "/productsInCategory", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ArrayOfProductTrans productsInCategory(@RequestParam("categoryName") String categoryName) {
        ArrayOfProductTrans arrayOfProductTrans = new ArrayOfProductTrans();
        if ("STORE_POWERUPS".equals(categoryName)) {
            fillPowerupStore(arrayOfProductTrans);
        }
        if ("Starting_Cars".equals(categoryName)) {
            fillStartingCars(arrayOfProductTrans);
        }
        return arrayOfProductTrans;
    }

    private void fillStartingCars(ArrayOfProductTrans arrayOfProductTrans) {
        // <ProductTrans>
        //        <Currency>CASH</Currency>
        //        <DurationMinute>0</DurationMinute>
        //        <Hash>1342182250</Hash>
        //        <Icon>Black_64x64</Icon>
        //        <Level>1</Level>
        //        <Price>150000.0000</Price>
        //        <Priority>0</Priority>
        //        <ProductId>NFSW-NA:A37154B0</ProductId>
        //        <ProductTitle>BLACK</ProductTitle>
        //        <ProductType>PRESETCAR</ProductType>
        //        <UseCount>1</UseCount>
        //    </ProductTrans>
        ProductTrans productTrans = new ProductTrans();
        productTrans.setCurrency("CASH");
        productTrans.setDurationMinute(0);
//        mitsubishi eclipse gt
//        productTrans.setHash(1342182250);
//        nissan 240sx (s13)
        productTrans.setHash(1133182666);
        productTrans.setIcon("Black_64x64");
        productTrans.setPrice(0D);
        productTrans.setPriority(0);
        productTrans.setProductId("SBRW:001");
        productTrans.setProductTitle("BLACK");
        productTrans.setProductType("PRESETCAR");
        productTrans.setUseCount(1);
        arrayOfProductTrans.getProductTrans().add(productTrans);
    }

    private void fillPowerupStore(ArrayOfProductTrans arrayOfProductTrans) {
        // NITROUS
        arrayOfProductTrans.getProductTrans().add(createPowerUpProduct(-1681514783));
        // FLAT TIRES
        arrayOfProductTrans.getProductTrans().add(createPowerUpProduct(-537557654));
        // TRAFFIC MAGNET
        arrayOfProductTrans.getProductTrans().add(createPowerUpProduct(125509666));
        // INSTANT COOLDOWN
        arrayOfProductTrans.getProductTrans().add(createPowerUpProduct(-1692359144));
        // SHIELD
        arrayOfProductTrans.getProductTrans().add(createPowerUpProduct(-364944936));
        // SLINGSHOT
        arrayOfProductTrans.getProductTrans().add(createPowerUpProduct(2236629));
        // READY
        arrayOfProductTrans.getProductTrans().add(createPowerUpProduct(957701799));
        // JUGGERNAUT
        arrayOfProductTrans.getProductTrans().add(createPowerUpProduct(1805681994));
        // EMERGENCY EVADE
        arrayOfProductTrans.getProductTrans().add(createPowerUpProduct(-611661916));
        // TEAM EMERGENCY EVADE
        arrayOfProductTrans.getProductTrans().add(createPowerUpProduct(-1564932069));
        // ONE MORE LAP
        arrayOfProductTrans.getProductTrans().add(createPowerUpProduct(1627606782));
        // TEAM SLINGSHOT
        arrayOfProductTrans.getProductTrans().add(createPowerUpProduct(1113720384));
    }

    private ProductTrans createPowerUpProduct(int hash) {
        ProductTrans productTrans = new ProductTrans();
        productTrans.setCurrency("_NS");
        productTrans.setHash(hash);
        productTrans.setLevel(0);
        productTrans.setPrice(100.0000);
        productTrans.setProductId("SRV-POWERUPX");
        return productTrans;
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ArrayOfCategoryTrans categories() {
        return new ArrayOfCategoryTrans();
    }
}
