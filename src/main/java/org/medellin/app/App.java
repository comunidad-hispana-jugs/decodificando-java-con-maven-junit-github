package org.medellin.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.medellin.app.calculator.CalculatorClient;
import org.medellin.app.soccercup.SoccerCupClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );

        System.out.println( "Chose your demo : (C)alculator (S)occer Cup " );
        String demo = bufferedReader.readLine();


        switch ( demo ) {
            case "C": {
                CalculatorClient.main( null );
                break;
            }
            case "S": {
                SoccerCupClient.main( null );
                break;
            }
            default:
                System.err.println("Demo " + demo + " doesn't exist");
        }
    }
}
