package controller;

import model.CurrencyDailyPrice;
import model.CurrencyInventory;
import persistence.CurrencyDailyPriceRepository;
import persistence.CurrencyInventoryRepository;

import java.util.List;

public class CurrencyDailyPriceController {
    CurrencyDailyPriceRepository dailyPriceRepository;
    CurrencyInventoryRepository currencyInventoryRepository;

    public CurrencyDailyPriceController() {
        dailyPriceRepository = new CurrencyDailyPriceRepository();
        currencyInventoryRepository = new CurrencyInventoryRepository();
    }

    public boolean addNewCurrencyDailyPrice(CurrencyDailyPrice currencyDailyPrice) {
        if(dailyPriceRepository.searchByCurrencyDailyPrice(currencyDailyPrice) != null) {
            dailyPriceRepository.save(currencyDailyPrice);
            return true;
        }else{
            return false;
        }
    }

    public void updateCurrencyDaily(CurrencyDailyPrice currencyDailyPrice) {
        //if() {
            //newPrice
            //oldPrice - old
            //update_in - date now()
            //currencyInventoryRepository.save()
        //}
        double oldPrice = 0;

        if(dailyPriceRepository.searchByCurrencyDailyPrice(currencyDailyPrice) != null){
            for (CurrencyDailyPrice curr: dailyPriceRepository.searchByCurrencyDailyPrice(currencyDailyPrice)) {
                if(currencyDailyPrice.getId() == curr.getId()) {
                    oldPrice = curr.getPrice();
                }
            }


            dailyPriceRepository.updateNewPrice(currencyDailyPrice);

            CurrencyInventory inventory = new CurrencyInventory();
            inventory.setOldPrice(oldPrice);
            inventory.setNewPrice(currencyDailyPrice.getPrice());
            //inventory.setUpdatedIn();
            currencyInventoryRepository.save(inventory);

        }
    }
}
