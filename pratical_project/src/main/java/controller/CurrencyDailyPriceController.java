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
        if(dailyPriceRepository.searchByCurrencyDailyPrice(currencyDailyPrice) != null){
            currencyInventoryRepository.updateOldPriceWithCurrentNewPrice(currencyDailyPrice);
            currencyInventoryRepository.updateNewPrice(currencyDailyPrice);
            currencyInventoryRepository.updateUpdatedIn(currencyDailyPrice);
        }
    }
}
