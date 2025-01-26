package com.imperionite.algo.initializers;

import com.imperionite.algo.entities.Stock;
import com.imperionite.algo.repositories.StockRepository;
import com.imperionite.algo.utils.DateUtils;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;

@Component
public class StockDataInitializer implements ApplicationRunner {

    private final StockRepository stockRepository;

    public StockDataInitializer(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        // Check if the user table is empty
        if (stockRepository.count() == 0) {
            // Load initial data
            List<Stock> stocks = Arrays.asList(
                    new Stock(LocalDate.parse("2/1/2023", DateUtils.formatter), "Old", "Honda", "142QVTSIUR", "On-hand"),
                    new Stock(LocalDate.parse("2/1/2023", DateUtils.formatter), "Old", "Honda", "PZCT1S00XE", "Sold"),
                    new Stock(LocalDate.parse("2/1/2023", DateUtils.formatter), "Old", "Honda", "4VBTV8YNM7", "Sold"),
                    new Stock(LocalDate.parse("2/1/2023", DateUtils.formatter), "Old", "Honda", "95AN3AWVF4", "On-hand"),
                    new Stock(LocalDate.parse("2/3/2023", DateUtils.formatter), "Old", "Kawasaki", "483QHIM661", "On-hand"),
                    new Stock(LocalDate.parse("2/3/2023", DateUtils.formatter), "Old", "Kymco", "SPHA17SSEE", "On-hand"),
                    new Stock(LocalDate.parse("2/3/2023", DateUtils.formatter), "Old", "kymco", "0AV7SWGX93", "Sold"),
                    new Stock(LocalDate.parse("2/4/2023", DateUtils.formatter), "Old", "Kymco", "QMUB6UYLKL", "Sold"),
                    new Stock(LocalDate.parse("2/4/2023", DateUtils.formatter), "Old", "Honda", "V96GMTFFEI", "Sold"),
                    new Stock(LocalDate.parse("2/5/2023", DateUtils.formatter), "Old", "Kawasaki", "4J8UA0FMVY", "Sold"),
                    new Stock(LocalDate.parse("2/5/2023", DateUtils.formatter), "Old", "Kawasaki", "A8BDL926FA", "Sold"),
                    new Stock(LocalDate.parse("2/5/2023", DateUtils.formatter), "Old", "Kawasaki", "X8G5ZZ7A69", "Sold"),
                    new Stock(LocalDate.parse("2/6/2023", DateUtils.formatter), "Old", "Honda", "TY5SU0WPDX", "On-hand"),
                    new Stock(LocalDate.parse("2/6/2023", DateUtils.formatter), "Old", "Honda", "5Q0EZG7WKB", "On-hand"),
                    new Stock(LocalDate.parse("2/6/2023", DateUtils.formatter), "Old", "Suzuki", "9XUOUOJ2XZ", "On-hand"),
                    new Stock(LocalDate.parse("2/6/2023", DateUtils.formatter), "Old", "Kymco", "YUL4UTC4FU", "On-hand"),
                    new Stock(LocalDate.parse("2/6/2023", DateUtils.formatter), "Old", "Kymco", "2ESQRHAXWG", "On-hand"),
                    new Stock(LocalDate.parse("2/7/2023", DateUtils.formatter), "Old", "Kymco", "J8JA99VWZE", "Sold"),
                    new Stock(LocalDate.parse("2/7/2023", DateUtils.formatter), "Old", "Kymco", "NS530HOT9H", "Sold"),
                    new Stock(LocalDate.parse("2/7/2023", DateUtils.formatter), "Old", "Suzuki", "URIA0XXM05", "Sold"),
                    new Stock(LocalDate.parse("2/7/2023", DateUtils.formatter), "Old", "Yamaha", "IDN93SI4KW", "Sold"),
                    new Stock(LocalDate.parse("2/7/2023", DateUtils.formatter), "Old", "Honda", "PVAWKD51CE", "Sold"),
                    new Stock(LocalDate.parse("2/7/2023", DateUtils.formatter), "Old", "Honda", "K4KHCQAU41", "Sold"),
                    new Stock(LocalDate.parse("2/8/2023", DateUtils.formatter), "Old", "Honda", "Z4NY5JGZZT", "Sold"),
                    new Stock(LocalDate.parse("2/8/2023", DateUtils.formatter), "Old", "Honda", "IRQACSKUNZ", "Sold"),
                    new Stock(LocalDate.parse("2/8/2023", DateUtils.formatter), "Old", "Yamaha", "TMZCTALNDL", "Sold"),
                    new Stock(LocalDate.parse("2/8/2023", DateUtils.formatter), "Old", "Yamaha", "DVFUIA0YVB", "Sold"),
                    new Stock(LocalDate.parse("2/8/2023", DateUtils.formatter), "Old", "Kymco", "4M793VVAHI", "On-hand"),
                    new Stock(LocalDate.parse("2/8/2023", DateUtils.formatter), "Old", "Suzuki", "5N7IQVJ2BA", "On-hand"),
                    new Stock(LocalDate.parse("3/6/2023", DateUtils.formatter), "New", "Susuki", "1R88BOJW8W", "On-hand"),
                    new Stock(LocalDate.parse("3/7/2023", DateUtils.formatter), "New", "Suzuki", "LAMH9Y1YD6", "On-hand"),
                    new Stock(LocalDate.parse("3/7/2023", DateUtils.formatter), "New", "Yamaha", "02G7NJCRGS", "On-hand"),
                    new Stock(LocalDate.parse("3/7/2023", DateUtils.formatter), "New", "Kawasaki", "392XSUBMUW", "On-hand")
            );

            stockRepository.saveAll(stocks);
            System.out.println("Database initialized with default stocks.");
        } else {
            System.out.println("Database already contains stocks");
        }
    }
}
