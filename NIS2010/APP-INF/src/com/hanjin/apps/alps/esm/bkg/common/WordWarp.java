/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : WordWarp.java
 *@FileTitle : Word Warp
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.29
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.23 김영출
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.common;

import org.apache.commons.lang.WordUtils;


/**
 * WordWarp<br>
 * 
 * @author Sarang
 * @see BLDocumentationBLBCImpl.searchMaxMfNo() 참조
 * @since J2EE 1.4
 */
public final class WordWarp {

    public static final String NL_REGEX = "[\\r]?[\\n]";
    public static final String NL_STR   = "\r\n";

    /**
     * wrap
     * 
     * @param String str
     * @param int cols
     * @return String
     */
    public static String wrap(String str, int cols) {
        if(str == null || str.length() == 0) return "";
        if(cols == 0) return str;

        StringBuffer sbuf = new StringBuffer();
        String[] arr = str.split(NL_REGEX);
        for(int i = 0; i < arr.length; i++) {
            if(i != 0) sbuf.append(NL_STR);
            if(arr[i].length() > cols) {
                for(int j = 0; j < arr[i].length(); j++){
                    if(j!=0 && j%cols == 0){
                        sbuf.append(NL_STR);
                    }
                    sbuf.append(arr[i].charAt(j));
                }
            } else {
                sbuf.append(arr[i]);
            }
        }

        return sbuf.toString();
    }
    
    /**
     * wrap2
     * 
     * @param String str
     * @param int cols
     * @return String
     */
    public static String wrap2(String str, int cols) {
        if(str == null || str.length() == 0) return "";
        if(cols == 0) return str;

        StringBuffer sbuf = new StringBuffer();
        String[] arr = str.split("\r\n");
    	for(String s : arr){
    		sbuf.append(WordUtils.wrap(s, cols, "\r\n", true));
    		sbuf.append("\r\n");
    	}
        return sbuf.toString();
    }

    /**
     * for debuging
     * 
     * @author KimYoungchul
     * @param args
     */
    public static void main(String[] args) {
//        String testText = "NO EEI REQUIRES AS PER 30.37 (A)\r\n"
//                        + "NCM: 9797\r\n"
//                        + "TARE WEIGHT: 2290 KGS\r\n"
//                        + "\r\n"
//                        + "     * FREIGHT AND DEMURRAGE ARE CONSIDERED INDIVISIBLE OBLIGATIONS.THEREFORE, THE CARRIER IS NOT OBLIGED TO DELIVER THE CARGO UNTIL PAYMENT OF ALL AMOUNTS DUE. \r\n"
//                        + "\r\n"
//                        + "       ALL EXPENSES AND RISK ARISING FROM THE NON-DELIVERY ALONGSIDE FOR DISPATCH CARGO(OR IF SUCH IS DECLARED BY AUTHORITIES WHEN SHIP IS READY TO DISCHARGE)TO BE FOR ACCOUNT OF THE MERCHANDISE.\r\n"
//                        + "       --------------------------------\r\n"
//                        + "       RULES AND CONDITIONS OF DEMURRAGE/DETENTION AS PER CARRIERS TARIFF.\r\n"
//                        + "       --------------------------------\r\n"
//                        + "\r\n"
//                        + "       DESTINATION TERMINAL HANDLING CHARGES ARE PAYABLE BY CONSIGNEE.\r\n"
//                        + "\r\n"
//                        + "       THE CARGO DESTINED TO BRAZIL MAY BE ONLY RELEASED AT THE PLACE OF DESTINATION AFTER PAYMENT OF THE ADDITIONAL TO THE FREIGHT FOR THE RENEWAL OF THE MERCHANT MARINE IN ACCORDANCE WITH THE BRAZIL LEGISLATION\r\n";

    	String testText = "SUBDIVISION : 840\r\n"
    			+"CONTRACT NO : 1519474C\r\n"
+"WAREHOUSE : BUENA PARK, CA\r\n"
+"(9705-5)\r\n"
+"LADIES WOVEN SHORTS\r\n"
+"(HTS # 620463)\r\n"
+"873 PCS, PART OF 01X40'DC\r\n"
+"++O/B TEXMA VINA CO., LTD.\r\n"
+"NO.32, 2A ROAD, BIEN HOA\r\n"
+"INDUSTRIAL ZONE II, DONG NAI,\r\n"
+"VIETNAM.\r\n"
+"THE GOODS REFERENCED IN THIS\r\n"
+"BILL OF LADING ARE SUBJECT TO\r\n"
+"THE LIEN OF WELLS FARGO BANK,\r\n"
+"NATIONAL ASSOCIATION, AS\r\n"
+"ADMINISTRATIVE AGENT.\r\n"
+"SHIPPER DECLARED ALL\r\n"
+"CONTAINER(S) CONTAIN NO WOOD\r\n"
+"PACKAGING MATERIAL\r\n"
+"+++TEL:310-343-6200\r\n"
+"FAX:310-649-1995\r\n"
+"\r\n"
    	+"1111111111111111111111111111111111111111111111111111\r\n"
    	+"22222222222222222222222222222222222\r\n";
        String result = WordWarp.wrap2(testText, 22);
        System.out.println(result);
    }
}
