package dk.sdu.se_f22.sharedlibrary.db;


import dk.sdu.se_f22.brandmodule.management.persistence.Persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * NOT SUPPORTED
 */
public class SeedDatabase {
    // public static void main(String[] args) {
    //     //------Seed the database-----------------------------------------------------------------------------

    //     //BIM-1
    //     Persistence bim1 = new Persistence(); bim1.seedDatabase();

    // }


    // private static void runSQLFromFile(Connection c, String SQLFileName) {
    //     try (FileReader fr = new FileReader(SQLFileName);
    //          BufferedReader br = new BufferedReader(fr);
    //          Statement stmt = c.createStatement();){

    //         String currentLine;
    //         String sqlCode = "";

    //         //Read the file one line at a time
    //         while((currentLine = br.readLine()) != null){
    //             //Safeguards commented code in -- format
    //             if(currentLine.contains("--")) continue;

    //             //Safeguards commented code in /* comment \n */ format
    //             if(currentLine.contains("/*")){
    //                 //Safeguards /* */ in same line
    //                 if(currentLine.contains("*/")) break;

    //                 String commentedLine;
    //                 while ((commentedLine = br.readLine()) != null){
    //                     if(commentedLine.contains("*/"))
    //                         break;
    //                 }
    //                 continue;
    //             }

    //             //Execute the sql-code
    //             if(currentLine.contains(";")) {
    //                 sqlCode += currentLine+"\n";
    //                 System.out.println("Printing sql code...");
    //                 System.out.println(sqlCode);
    //                 stmt.execute(sqlCode);
    //                 sqlCode = "";
    //                 continue;
    //             }
    //             sqlCode+=currentLine + "\n";
    //         }
    //     } catch (FileNotFoundException e) {e.printStackTrace();
    //     } catch (SQLException e) {e.printStackTrace();
    //     } catch (IOException e) {e.printStackTrace();

    //     }
    // }
}
