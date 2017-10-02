/**
 * Created by bejan on 13.02.2017.
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class excelToJava {

        public static ObservableList<Donator> readExcelData(String fileName) {
            final ObservableList<Donator> data = FXCollections.observableArrayList();

            try {
                //Create the input stream from the xlsx/xls file
                FileInputStream fis = new FileInputStream(fileName);

                //Create Workbook instance for xlsx/xls file input stream
                Workbook workbook = null;
                if(fileName.toLowerCase().endsWith("xlsx")){
                    workbook = new XSSFWorkbook(fis);
                }else if(fileName.toLowerCase().endsWith("xls")){
                    workbook = new HSSFWorkbook(fis);
                }

                //Get the number of sheets in the xlsx file
                int numberOfSheets = workbook.getNumberOfSheets();

                DataFormatter formatter = new DataFormatter();
                //loop through each of the sheets
                for(int i=0; i < numberOfSheets; i++){

                    //Get the nth sheet from the workbook
                    Sheet sheet = workbook.getSheetAt(i);

                    //every sheet has rows, iterate over them
                    Iterator<Row> rowIterator = sheet.iterator();
                    while (rowIterator.hasNext())
                    {

                        SimpleStringProperty address = new SimpleStringProperty();
                        SimpleStringProperty title = new SimpleStringProperty();
                        SimpleStringProperty firstname = new SimpleStringProperty();
                        SimpleStringProperty surname  = new SimpleStringProperty();
                        SimpleStringProperty street  = new SimpleStringProperty();
                        SimpleStringProperty postalcode  = new SimpleStringProperty();
                        SimpleStringProperty location  = new SimpleStringProperty();
                        SimpleStringProperty email  = new SimpleStringProperty();
                        SimpleStringProperty phone  = new SimpleStringProperty();
                        SimpleStringProperty where  = new SimpleStringProperty();
                        SimpleStringProperty howMuch  = new SimpleStringProperty();
                        SimpleStringProperty once  = new SimpleStringProperty();
                        SimpleStringProperty multiple  = new SimpleStringProperty();
                        SimpleStringProperty extra = new SimpleStringProperty();
                        //Get the row object
                        Row row = rowIterator.next();

                        //Every row has columns, get the column iterator and iterate over them
                        Iterator<Cell> cellIterator = row.cellIterator();

                        while (cellIterator.hasNext())
                        {
                            //Get the Cell object
                            Cell cell = cellIterator.next();
                            int columnIndex = cell.getColumnIndex();
                            //check the cell type and process accordingly
                            switch(columnIndex){
                                case 0:
                                    address.set(cell.getStringCellValue().trim());
                                    System.out.println(address);
                                    break;
                                case 1:
                                    title.set(cell.getStringCellValue().trim());
                                    System.out.println(title);
                                    break;
                                case 2:
                                   firstname.set(cell.getStringCellValue().trim());
                                    break;
                                case 3:
                                    surname.set(cell.getStringCellValue().trim());
                                    break;
                                case 4:
                                    street.set(formatter.formatCellValue(cell)) ;
                                    break;
                                case 5:
                                    postalcode.set(formatter.formatCellValue(cell));
                                    break;
                                case 6:
                                    location.set(cell.getStringCellValue().trim());
                                    break;
                                case 7:
                                    email.set(cell.getStringCellValue().trim());
                                    break;
                                case 8:
                                    phone.set(formatter.formatCellValue(cell));
                                    break;
                                case 9:
                                    where.set(cell.getStringCellValue().trim());
                                    break;
                                case 10:
                                    extra.set(cell.getStringCellValue().trim());
                                    break;
                                case 11:
                                    howMuch.set(formatter.formatCellValue(cell));
                                    break;
                                case 12:
                                    once.set(cell.getStringCellValue().trim());
                                    break;
                                case 13:
                                    multiple.set(cell.getStringCellValue().trim());
                                    break;

                            }
                        } //end of cell iterator
                        Donator donator = new Donator(address,title,firstname,surname,street,postalcode,location,email,phone,where,extra,howMuch,once,multiple);
                        data.add(donator);
                    } //end of rows iterator


                } //end of sheets for loop

                //close file input stream
                fis.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return data;
        }



    }
