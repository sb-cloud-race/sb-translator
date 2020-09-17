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
        if("STORE_POWERUPS".equals(categoryName)){
            fillPowerupStore(arrayOfProductTrans);
        }
        return arrayOfProductTrans;
    }

    //<ProductTrans>
    //        <Currency>_NS</Currency>
    //        <Description>Increase your speed to catch up to the leader or escape the cops.</Description>
    //        <DurationMinute>0</DurationMinute>
    //        <Hash>-1681514783</Hash>
    //        <Icon>prod_powerup_stack_nos__</Icon>
    //        <Level>0</Level>
    //        <LongDescription>Increases your speed briefly to help catch up to the leader or escape the Cops</LongDescription>
    //        <Price>100.0000</Price>
    //        <Priority>31</Priority>
    //        <ProductId>SRV-POWERUP9</ProductId>
    //        <ProductTitle>NITROUS x15</ProductTitle>
    //        <ProductType>POWERUP</ProductType>
    //        <UseCount>15</UseCount>
    //    </ProductTrans>
    private void fillPowerupStore(ArrayOfProductTrans arrayOfProductTrans){
        ProductTrans productTrans = new ProductTrans();
        productTrans.setCurrency("_NS");
        productTrans.setDescription("Increase your speed to catch up to the leader or escape the cops.");
        productTrans.setDurationMinute(0);
        productTrans.setHash(-1681514783);
        productTrans.setIcon("prod_powerup_stack_nos__");
        productTrans.setLevel(0);
        productTrans.setLongDescription("Increases your speed briefly to help catch up to the leader or escape the Cops");
        productTrans.setPrice(100.0000);
        productTrans.setPriority(31);
        productTrans.setProductId("SRV-POWERUP9");
        productTrans.setProductTitle("NITROUS x15");
        productTrans.setProductType("POWERUP");
        productTrans.setUseCount(15);
        arrayOfProductTrans.getProductTrans().add(productTrans);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ArrayOfCategoryTrans categories() {
        return new ArrayOfCategoryTrans();
    }
}
