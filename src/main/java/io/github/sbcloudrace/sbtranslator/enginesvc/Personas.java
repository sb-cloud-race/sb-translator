package io.github.sbcloudrace.sbtranslator.enginesvc;

import io.github.sbcloudrace.sbtranslator.jaxb.http.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        OwnedCarTrans ownedCarTrans = new OwnedCarTrans();
        CustomCarTrans customCarTrans = new CustomCarTrans();
        customCarTrans.setBaseCar(22084480);
        customCarTrans.setCarClassHash(872416321);
        customCarTrans.setId(243);
        customCarTrans.setIsPreset(false);
        customCarTrans.setLevel(0);
        customCarTrans.setName("240sx");
        ArrayOfCustomPaintTrans arrayOfCustomPaintTrans = new ArrayOfCustomPaintTrans();
        mockCustomPaintTrans(arrayOfCustomPaintTrans,0);
        mockCustomPaintTrans(arrayOfCustomPaintTrans,3);
        mockCustomPaintTrans(arrayOfCustomPaintTrans,4);
        mockCustomPaintTrans(arrayOfCustomPaintTrans,5);
        mockCustomPaintTrans(arrayOfCustomPaintTrans,6);
        mockCustomPaintTrans(arrayOfCustomPaintTrans,7);
        customCarTrans.setPaints(arrayOfCustomPaintTrans);
        customCarTrans.setPerformanceParts(new ArrayOfPerformancePartTrans());
        customCarTrans.setPhysicsProfileHash(-1469109252);
        customCarTrans.setRating(224);
        customCarTrans.setResalePrice(0);
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
        ownedCarTrans.setId(243L);
        ownedCarTrans.setOwnershipType("CustomizedCar");
        return ownedCarTrans;
    }

    private void mockCustomPaintTrans(ArrayOfCustomPaintTrans arrayOfCustomPaintTrans, int slot) {
        CustomPaintTrans customPaintTrans = new CustomPaintTrans();
        customPaintTrans.setGroup(47885063);
        customPaintTrans.setHue(496032328);
        customPaintTrans.setSat(0);
        customPaintTrans.setSlot(slot);
        customPaintTrans.setVar(0);
        arrayOfCustomPaintTrans.getCustomPaintTrans().add(customPaintTrans);
    }

    @RequestMapping(value = "/inventory/objects", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public InventoryTrans inventoryObjects() {
        InventoryTrans inventoryTrans = new InventoryTrans();
        ArrayOfInventoryItemTrans arrayOfInventoryItemTrans = new ArrayOfInventoryItemTrans();
        arrayOfInventoryItemTrans.getInventoryItemTrans().add(getPowerUpInventory("nosshot", -1681514783, 1842996427L, "0x9bc61ee1"));
        arrayOfInventoryItemTrans.getInventoryItemTrans().add(getPowerUpInventory("runflattires", -537557654, 2876729160L, "0xdff5856a"));
        arrayOfInventoryItemTrans.getInventoryItemTrans().add(getPowerUpInventory("instantcooldown", -1692359144, 2876729162L, "0x9b20a618"));
        arrayOfInventoryItemTrans.getInventoryItemTrans().add(getPowerUpInventory("shield", -364944936, 2876729163L, "0xea3f61d8"));
        arrayOfInventoryItemTrans.getInventoryItemTrans().add(getPowerUpInventory("slingshot", 2236629, 2876729164L, "0x2220d5"));
        arrayOfInventoryItemTrans.getInventoryItemTrans().add(getPowerUpInventory("ready", 957701799, 2876729165L, "0x39155ea7"));
        arrayOfInventoryItemTrans.getInventoryItemTrans().add(getPowerUpInventory("juggernaut", 1805681994, 2876729166L, "0x6ba0854a"));
        arrayOfInventoryItemTrans.getInventoryItemTrans().add(getPowerUpInventory("emergencyevade", -611661916, 2876729167L, "0xdb8ac7a4"));
        arrayOfInventoryItemTrans.getInventoryItemTrans().add(getPowerUpInventory("team_emergencyevade", -1564932069, 2876729168L, "0xa2b9081b"));
        arrayOfInventoryItemTrans.getInventoryItemTrans().add(getPowerUpInventory("onemorelap", 1627606782, 2876729170L, "0x61034efe"));
        arrayOfInventoryItemTrans.getInventoryItemTrans().add(getPowerUpInventory("team_slingshot", 1113720384, 2876729171L, "0x42620640"));
        arrayOfInventoryItemTrans.getInventoryItemTrans().add(getPowerUpInventory("trafficmagnet", 125509666, 2880783203L, "0x77b2022"));
        inventoryTrans.setInventoryItems(arrayOfInventoryItemTrans);
        return inventoryTrans;
    }

    private InventoryItemTrans getPowerUpInventory(String tag, int hash, long invId, String strHash) {
        InventoryItemTrans inventoryItemTrans = new InventoryItemTrans();
        inventoryItemTrans.setEntitlementTag("nosshot");
        inventoryItemTrans.setHash(hash);
        inventoryItemTrans.setInventoryId(invId);
        inventoryItemTrans.setProductId("DO NOT USE ME");
        inventoryItemTrans.setRemainingUseCount(100L);
        inventoryItemTrans.setResellPrice(0.00);
        inventoryItemTrans.setStatus("ACTIVE");
        inventoryItemTrans.setStringHash(strHash);
        inventoryItemTrans.setVirtualItemType("powerup");
        return inventoryItemTrans;
    }

    @RequestMapping(value = "/{personaId}/defaultcar/{carId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void putDefaultCar(@PathVariable String personaId, @PathVariable String carId) {
    }

    @RequestMapping(value = "/{personaId}/cars", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public void postCars(@PathVariable String personaId) {
    }

    @RequestMapping(value = "/{personaId}/baskets", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public CommerceResultTrans baskets(@PathVariable String personaId, @RequestBody BasketTrans basketTrans) {
        CommerceResultTrans commerceResultTrans = new CommerceResultTrans();

        ArrayOfInventoryItemTrans arrayOfInventoryItemTrans = new ArrayOfInventoryItemTrans();
        arrayOfInventoryItemTrans.getInventoryItemTrans().add(new InventoryItemTrans());

        WalletTrans walletTrans = new WalletTrans();
        walletTrans.setBalance(0);
        walletTrans.setCurrency("CASH");

        ArrayOfWalletTrans arrayOfWalletTrans = new ArrayOfWalletTrans();
        arrayOfWalletTrans.getWalletTrans().add(walletTrans);

        commerceResultTrans.setWallets(arrayOfWalletTrans);
        commerceResultTrans.setCommerceItems(new ArrayOfCommerceItemTrans());
        commerceResultTrans.setInvalidBasket(new InvalidBasketTrans());
        commerceResultTrans.setInventoryItems(arrayOfInventoryItemTrans);

        String productId = basketTrans.getItems().getBasketItemTrans().get(0).getProductId();
        if ("SRV-GARAGESLOT".equals(productId) || "-1".equals(productId) || productId.contains("SRV-POWERUP") || productId.equals("SRV-THREVIVE")) {
            commerceResultTrans.setStatus(CommerceResultStatus.FAIL_INSUFFICIENT_FUNDS);
        } else {
            ArrayOfOwnedCarTrans arrayOfOwnedCarTrans = new ArrayOfOwnedCarTrans();
            arrayOfOwnedCarTrans.getOwnedCarTrans().add(mockOwnedCar());
            commerceResultTrans.setPurchasedCars(arrayOfOwnedCarTrans);
        }
        return commerceResultTrans;
    }

    @RequestMapping(value = "/{personaId}/defaultcar", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public OwnedCarTrans getDefaultCar(@PathVariable Long personaId) {
        return mockOwnedCar();
    }
}
