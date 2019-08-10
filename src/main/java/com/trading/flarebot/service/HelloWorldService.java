package com.trading.flarebot.service;

import com.trading.flarebot.experimental.ExchangeTicker;
import com.trading.flarebot.experimental.TickerSingleton;
import com.trading.flarebot.unifiedtradingview.constant.ExchangeConstant;
import com.trading.flarebot.unifiedtradingview.constant.SymbolConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author UNGERW
 */
@Component
@Path("/spring-docker/")
@Slf4j
public class HelloWorldService {

    @GET
    @Path("/hello")
    public Response test() {
        System.out.println("logged");
        log.info("Logged as info");
        log.warn("Logged as warn");
        log.error("Logged as error");
        log.debug("Logged as debug");
        Thread thread = new Thread(new ExchangeTicker(ExchangeConstant.BINANCE, SymbolConstant.BTCUSDT));
        thread.start();
        return Response.status(200).entity("Hello from Nitin jaiman "+ TickerSingleton.price).build();
    }

}
