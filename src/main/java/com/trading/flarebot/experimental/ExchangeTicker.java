package com.trading.flarebot.experimental;

import com.trading.flarebot.unifiedtradingview.ExchangeClientFactory;
import com.trading.flarebot.unifiedtradingview.UnifiedTradingViewClient;
import com.trading.flarebot.unifiedtradingview.constant.ExchangeConstant;
import com.trading.flarebot.unifiedtradingview.constant.SymbolConstant;
import com.trading.flarebot.unifiedtradingview.model.ClientMetadata;

public class ExchangeTicker implements Runnable {
    private String exchange;
    private String symbol;

    public ExchangeTicker(String exchange, String symbol) {
        this.exchange = exchange;
        this.symbol = symbol;
    }

    @Override
    public void run() {
        ClientMetadata clientMetadata = new ClientMetadata();
        clientMetadata.setExchangeName(ExchangeConstant.BINANCE);
        UnifiedTradingViewClient unifiedTradingViewClient = ExchangeClientFactory
                .getUnifiedTradingViewClient(clientMetadata);

        while (true) {
            System.out.println("ServerTime: " + unifiedTradingViewClient.getServerTime());
            System.out.println("Price: " + unifiedTradingViewClient.getPrice(SymbolConstant.BTCUSDT));
            TickerSingleton.price = unifiedTradingViewClient.getPrice(SymbolConstant.BTCUSDT).getPrice();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
