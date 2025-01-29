/* *****************************************************************************
 *  Name:              Fernando Rubio
 *  Coursera User ID:  99f10e17bd6b7e7f61d187b45df23273
 *  Last modified:     29/01/2025
 **************************************************************************** */

package test.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Write a Java program to analyze investor portfolios based on their stock trades. Each trade is
 * formatted as:
 * <p>
 * "trade_id, investor_id, stock_symbol, trade_type, quantity, price, timestamp"
 * <p>
 * Requirements:
 * <p>
 * Calculate the total investment value for each investor across all trades (sum of price × quantity
 * for all "buy" trades).
 * <p>
 * Determine the most frequently traded stock by each investor.
 * <p>
 * Identify investors with no trades (given a list of all investors).
 * <p>
 * Input:
 * <p>
 * List<String> trades: A list of trade strings.
 * <p>
 * List<String> investors: A list of unique investor IDs.
 * <p>
 * Output:
 * <p>
 * A report for each investor containing:
 * <p>
 * Total investment value.
 * <p>
 * Most frequently traded stock.
 * <p>
 * Note if the investor has made no trades.
 * <p>
 * <p>
 * public void analyzePortfolios(List<String> trades, List<String> investors) {    // TODO: code
 * here. }
 */
public class FnzTest {

    private static final String BUY_TRADE_TYPE = "buy";

    private static class TradeData {
        String tradeId;
        String investorId;
        String stockSymbol;
        String tradeType;
        int quantity;
        double price;
        String timestamp;

        TradeData(String tradeId, String investorId, String stockSymbol, String tradeType,
                  int quantity, double price, String timestamp) {
            this.tradeId = tradeId;
            this.investorId = investorId;
            this.stockSymbol = stockSymbol;
            this.tradeType = tradeType;
            this.quantity = quantity;
            this.price = price;
            this.timestamp = timestamp;
        }
    }

    public void analyzePortfolios(List<String> trades, List<String> investors) {
        // Parse trades into TradeData objects
        List<TradeData> tradeDataList = trades.stream().map(this::parseString).toList();

        Map<String, List<TradeData>> investorMap = new HashMap<>();

        // Initialize the map with empty lists for each investor
        for (String investor : investors) {
            investorMap.put(investor, new ArrayList<>());
        }

        // Populate the map with trade data
        for (TradeData trade : tradeDataList) {
            investorMap.get(trade.investorId).add(trade);
        }

        // Generate and print the report for each investor
        for (String investor : investors) {
            List<TradeData> tradesForInvestor = investorMap.get(investor);
            if (tradesForInvestor == null || tradesForInvestor.isEmpty()) {
                System.out.println("Trader: " + investor + " has no trades.");
            }
            else {
                double totalInvestment = tradesForInvestor.stream()
                                                          .filter(trade -> BUY_TRADE_TYPE.equalsIgnoreCase(
                                                                          trade.tradeType
                                                                  )
                                                          )
                                                          .mapToDouble(trade ->
                                                                               trade.quantity
                                                                                       * trade.price
                                                          )
                                                          .sum();

                Map<String, Long> stockFrequency = tradesForInvestor.stream()
                                                                    .collect(
                                                                            Collectors.groupingBy(
                                                                                    trade -> trade.stockSymbol,
                                                                                    Collectors.counting()
                                                                            )
                                                                    );

                String mostTradedStock = stockFrequency.entrySet().stream()
                                                       .max(Map.Entry.comparingByValue())
                                                       .map(Map.Entry::getKey)
                                                       .orElse("No trades");

                System.out.printf(
                        "Trader: %s, Most Traded Stock: %s, Total Investment Value: %.2f%n",
                        investor, mostTradedStock, totalInvestment);
            }
        }
    }

    private TradeData parseString(String trade) {
        // "trade_id,investor_id,stock_symbol,trade_type,quantity,price,timestamp"
        String[] tradeVector = trade.split(",");
        if (tradeVector.length != 7) {
            throw new IllegalArgumentException("Invalid trade format: " + trade);
        }
        return new TradeData(
                tradeVector[0].trim(),
                tradeVector[1].trim(),
                tradeVector[2].trim(),
                tradeVector[3].trim(),
                Integer.parseInt(tradeVector[4].trim()),
                Double.parseDouble(tradeVector[5].trim()),
                tradeVector[6].trim()
        );
    }

    public static void main(String[] args) {
        FnzTest test = new FnzTest();

        List<String> trades = Arrays.asList(
                "1,1001,AAPL,buy,10,150.00,2023-01-01T10:00:00",
                "2,1001,GOOG,buy,5,1200.00,2023-01-02T11:00:00",
                "3,1002,MSFT,buy,8,300.00,2023-01-01T12:00:00",
                "4,1001,AAPL,sell,5,155.00,2023-01-03T13:00:00",
                "5,1003,TSLA,buy,3,600.00,2023-01-02T14:00:00"
        );

        List<String> investors = Arrays.asList("1001", "1002", "1003", "1004");

        test.analyzePortfolios(trades, investors);
    }
}
