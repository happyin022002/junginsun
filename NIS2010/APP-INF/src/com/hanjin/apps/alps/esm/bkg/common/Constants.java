/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Constants.java
 *@FileTitle : Constants
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.26
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.05.26 이수빈
 * 1.0 Creation
 * History
 * 2011.03.03 조원주 [CHM-201109079] POD 가 JOAQJ 일 경우 M/D Description 에 tariff 조항 자동 표기 요청
 * 2011.10.19 정선용 [CHM-201113772-01] [삼성SDS] 신규 TP ID 셋업 요청
 * 2012.05.24 김기택 [CHM-201217780-01] POD 또는 DEL의 국가 코드가 DZ 일 경우 Tariff 강제 적용
 * 2012.06.04 김기택 [CHM-201217780-01] 요청사항 수정-> POR 또는 POL이 US 인 경우는 Tariff 미 적용
 * 2012.07.23 김기택 [CCHM-201218572-01] POD: BR인 B/L의 경우 현재 B/L 문구적용 삭제 
 * 2012.08.10 변종건 [CHM-201219520-01] [M&D] Automatic Clause 워딩 변경 (GR / EG)
 * 2012.10.26 김기택 [CHM-201220828-01] BR 향 화물의 BL상 특정 안내문구 추가 요청
 * 2013.09.10 길정권 [CHM-201326555] POD,DEL이 JOAQJ 일 경우 M/D Description 에 문구 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.common;

import java.util.Arrays;
import java.util.List;

/**
 * Booking 모듈에서 사용하는 상수를 정의한다.<br>
 * 
 * @author Lee Subin
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public final class Constants {
    
    /* Booking status */
    public static final String BKG_STATUS_WAITING  = "W";
    public static final String BKG_STATUS_ADVANCED = "A";
    public static final String BKG_STATUS_FIRM     = "F";
    public static final String BKG_STATUS_SPLIT    = "S";
    public static final String BKG_STATUS_CANCEL   = "X";
    
    
//    ATTENTION: Container demurrage tariffs and conditions applicable for the port of discharge, 
//    including the free time, can be obtained with local agents and are available at the carrier’s website, 
//    at www.smlines.com (local page Brasil). 
//    The tariffs of demurrage and the conditions to be applied (Statement of responsibility) 
//    are registered in the Documents Registry Notary Office in the city of Santos, under number 626.055 and number 632.100 respectively, 
//    and are regarded a legal part of this Bill of Lading.
    
    public static final String CMDT_DESC_ATTD_BR_OLD   = "\r\n"
										            + "       ATTENTION: Container demurrage tariffs \r\n"
										            + "       and conditions applicable for the port \r\n"
										            + "       of discharge, including the free time, \r\n"
										            + "       can be obtained with local agents and\r\n"
										            + "       are available at the carrier’s website, \r\n"
										            + "       at www.smlines.com (local page Brasil). \r\n"
										            + "\r\n"
										            + "       The tariffs of demurrage and the conditions \r\n"
										            + "       to be applied (Statement of responsibility)\r\n"
										            + "       are registered in the Documents Registry\r\n"
										            + "       Notary Office in the city of Santos,\r\n"
										            + "       under number 626.055 and number 632.100 \r\n"
										            + "       respectively, and are regarded a legal \r\n"
										            + "       part of this Bill of Lading.";
		    
    public static final String CMDT_DESC_ATTD_BR   = "\r\n"
										            + "       ATTENTION: Container demurrage tariffs \r\n"
										            + "       and conditions applicable for the port \r\n"
										            + "       of discharge, including the free time, \r\n"
										            + "       can be obtained with local agents and\r\n"
										            + "       are available at the carrier’s website, \r\n"
										            + "       at www.smlines.com (local page Brasil). \r\n"
										            + "\r\n"
										            + "       The tariffs of demurrage and the conditions \r\n"
										            + "       to be applied (Statement of responsibility)\r\n"
										            + "       are registered in the Documents Registry\r\n"
										            + "       Notary Office in the city of Santos,\r\n"
										            + "       under number 660.555 and number 632.100 \r\n"
										            + "       respectively, and are regarded a legal \r\n"
										            + "       part of this Bill of Lading.";
    public static final String CMDT_DESC_ATTD_BR_WEB   = "\r\n"
										            + "       ATTENTION: CONTAINER DEMURRAGE TARIFFS \r\n"
										            + "       AND CONDITIONS APPLICABLE FOR THE PORT \r\n"
										            + "       OF DISCHARGE, INCLUDING THE FREE TIME, \r\n"
										            + "       CAN BE OBTAINED WITH LOCAL AGENTS AND\r\n"
										            + "       ARE AVAILABLE AT THE CARRIER’S WEBSITE, \r\n"
										            + "       AT WWW.SMLINES.COM (LOCAL PAGE BRASIL). \r\n"
										            + "\r\n"
										            + "       THE TARIFFS OF DEMURRAGE AND THE CONDITION\r\n" 
										            + "S \r\n"
										            + "       TO BE APPLIED (STATEMENT OF RESPONSIBILITY\r\n" 
										            + ")\r\n"
										            + "       ARE REGISTERED IN THE DOCUMENTS REGISTRY\r\n"
										            + "       NOTARY OFFICE IN THE CITY OF SANTOS,\r\n"
										            + "       UNDER NUMBER 660.555 AND NUMBER 632.100 \r\n"
										            + "       RESPECTIVELY, AND ARE REGARDED A LEGAL \r\n"
										            + "       PART OF THIS BILL OF LADING.";
    
    public static final String CMDT_DESC_ATTD_UY   = "\r\n"
                                                   + "     * FREIGHT AND DEMURRAGE ARE CONSIDERED \r\n"
                                                   + "       INDIVISIBLE OBLIGATIONS.THEREFORE,THE \r\n"
                                                   + "       CARRIER IS NOT OBLIGED TO DELIVER THE \r\n"
                                                   + "       CARGO UNTIL PAYMENT OF ALL AMOUNTS DUE. \r\n"
                                                   + "\r\n"
                                                   + "       ALL EXPENSES AND RISK ARISING FROM THE \r\n"
                                                   + "       NON-DELIVERY ALONGSIDE FOR DISPATCH \r\n"
                                                   + "       CARGO(OR IF SUCH IS DECLARED BY \r\n"
                                                   + "       AUTHORITIES WHEN SHIP IS READY TO\r\n"
                                                   + "       DISCHARGE)TO BE FOR ACCOUNT OF THE\r\n"
                                                   + "       MERCHANDISE.\r\n"
                                                   + "       --------------------------------\r\n"
                                                   + "       RULES AND CONDITIONS OF DEMURRAGE/\r\n"
                                                   + "       DETENTION AS PER CARRIERS TARIFF.\r\n"
                                                   + "       --------------------------------\r\n"
                                                   + "\r\n"
                                                   + "       DESTINATION TERMINAL HANDLING CHARGES\r\n"
                                                   + "       ARE PAYABLE BY CONSIGNEE.";
    
    public static final String CMDT_DESC_ATTD_MX   = "\r\n"
                                                   + "     * CARRIER'S RESPONSIBILITY DURING INLAND\r\n"
                                                   + "       TRANSPORTATION IN MEXICO TO BE IN\r\n"
                                                   + "       ACCORDANCE WITH APPLICABLE MEXICAN LAW.";
    
    public static final String CMDT_DESC_ATTD_GT   = "\r\n"
                                                   + "     * THE CARRIER SHALL HAVE NO LIABILITY \r\n"
                                                   + "       WHATSOEVER ARISING OUT OF OR IN CONNECTION \r\n"
                                                   + "       WITH THE ACTS OF ANY PERSON WHO UNLAWFULLY \r\n"
                                                   + "       , BY THE USE OF FORCE OR THREATS OF ANY \r\n"
                                                   + "       KIND,DAMAGES, SEIZES, OR EXERCISES CONTROL \r\n"
                                                   + "       OVER THE GOODS, OVER ANY SUB-CONTRACTORS \r\n"
                                                   + "       OR OVER ANY MEANS OF TRANSPORTATION OR \r\n"
                                                   + "       STORAGE OF THE GOODS.";
    
    public static final String CMDT_DESC_ATTD_GR   = "\r\n"
		   										   + "       EMPTY CONTAINERS SHALL BE RETURNED \r\n"
		   										   + "       TO THE CARRIER DEPOT IN GOOD ORDER AND CONDITION";
    
    public static final String CMDT_DESC_ATTD_GR_WEB   = "\r\n"
												   + "       EMPTY CONTAINERS SHALL BE RETURNED \r\n"
												   + "       TO THE CARRIER DEPOT IN GOOD ORDER AND CON\r\n" 
												   + "DITION";
    
    public static final String CMDT_DESC_ATTD_EG   = "\r\n"
												   + "       EMPTY CONTAINERS SHALL BE RETURNED \r\n"
												   + "       TO THE CARRIER DEPOT IN GOOD ORDER AND CONDITION";
    
    public static final String CMDT_DESC_ATTD_EG_WEB   = "\r\n"
												   + "       EMPTY CONTAINERS SHALL BE RETURNED \r\n"
												   + "       TO THE CARRIER DEPOT IN GOOD ORDER AND CON\r\n" 
												   + "DITION";
									    
    public static final String CMDT_DESC_ATTD_SA   = "\r\n"
												   + "      EFFECTIVE 1ST FEB 2014, FREE TIME TARIFF WILL BE \r\n"
												   + "      CHANGED AS FOLLOWS: \r\n"
												   + "      FREE TIME : DRY/SPECIAL CONTAINER/REEFER - 15DAYS \r\n\r\n"
												   + "      DRY \r\n"
												   + "      1 - 15 DAYS     SAR 50/20' & SAR 100/40',45' \r\n"
												   + "      16 - 30 DAYS SAR 85/20' & SAR 170/40',45' \r\n"
												   + "      31 - 60 DAYS SAR 135/20' & SAR 220/40',45' \r\n"
												   + "      61ST DAY ONWARDS  SAR 225/20' & SAR 300/40',45' \r\n\r\n"
												   + "      REEFER \r\n"
												   + "      1 - 15 DAYS SAR 100/20'RF, SAR 200/40'RF \r\n"
												   + "      & SAR 200/R9 \r\n"
												   + "      16 - 30 DAYS SAR 170/20'RF, SAR 300/40'RF \r\n"
												   + "      & SAR 600/R9 \r\n"
												   + "      31 - 60 DAYS SAR 270/20'RF, SAR 400/40'RF \r\n"
												   + "      & SAR 1600/R9 \r\n"
												   + "      61ST DAY ONWARDS  SAR 350/20'RF, SAR 450/40'RF \r\n"
												   + "      & SAR 1800/R9 \r\n\r\n"
												   + "      SPECIAL CONTAINER \r\n"
												   + "      1 - 15 DAYS SAR 50/20' & SAR 100/40' \r\n"
												   + "      16 - 30 DAYS SAR 200/20' & SAR 300/40' \r\n"
												   + "      31 - 60 DAYS SAR 300/20' & SAR 400/40' \r\n"
												   + "      61ST DAY ONWARDS  SAR 400/20' & SAR 500/40' \r\n";



    /* Set Tariff for B/L Mark  */
    public static final String CMDT_DESC_ATTD_JOAQJ	= "\r\n"
    												+ "       << SM Line Tariff >> \r\n"
    												+ "       \r\n"
    												+ "       * Dry Cargo Free time \r\n"
    												+ "       15 Days Free time \r\n"
    												+ "       \r\n"
    												+ "       * Dry Cargo Tariff Rate \r\n"
    												+ "       USD 5 per TEU for First \r\n"
    												+ "       10 days after Free time \r\n"
    												+ "       USD 10 per TEU thereafter \r\n"
    												+ "       \r\n"
    												+ "       * Reefer Cargo Free Time \r\n"
    												+ "       6 Days Free Time \r\n"
    												+ "       \r\n"
    												+ "       * Reefer Cargo Tariff Rate \r\n"
    												+ "       USD 25 per Teu for First \r\n"
    												+ "       10 days after free time  \r\n"
    												+ "       USD 50 per Teu thereafter \r\n";
    
    
    /* Set Tariff for B/L Mark  */
    public static final String CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO	= "\r\n"
																	+ "       **IN CASE OF CONSOLIDATED CARGO \r\n"
																	+ "       (CARGO WITH VARIOUS RECEIVERS) \r\n"
																	+ "       AND OR CARGO IN TRANSIT/INTRANSIT \r\n"
																	+ "       TO IRAQ/ASEZA/ZARQA FREE ZONE  \r\n"
																	+ "       UNDER OWN RISK, ACCOUNT, COST  \r\n"
																	+ "       & RESPONSIBILITIES OF SHIPPER/RECEIVER WITHOUT \r\n"
																	+ "       ANY LIABILITY ON CARRIER AND/OR AGENTS** \r\n";
    
    public static final String CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO_WEB= "\r\n"
																	+ "       **IN CASE OF CONSOLIDATED CARGO \r\n"
																	+ "       (CARGO WITH RIOUS RECEIVERS) \r\n"
																	+ "       AND OR CARGO IN TRVAANSIT/INTRANSIT \r\n"
																	+ "       TO IRAQ/ASEZA/ZARQA FREE ZONE  \r\n"
																	+ "       UNDER OWN RISK, ACCOUNT, COST  \r\n"
																	+ "       & RESPONSIBILITIES OF SHIPPER/RECEIVER WIT\r\n"
																	+ "HOUT \r\n"
																	+ "       ANY LIABILITY ON CARRIER AND/OR AGENTS**";
    
    /* Set Tariff for B/L Mark */
    public static final String CMDT_DESC_ATTD_SY = "\r\n"
											    	+ "        a) Demurrage as per line tariff. \r\n"
													+ "        \r\n"
													+ "        b) LOCAL CHARGE OF US$10/20\" OR US$20/40\" \r\n"
													+ "        WILL BE DUE WHEN CONSIGNEE AT \r\n"
													+ "        THEIR RISK AND RESPONSIBILITY, \r\n"
													+ "        REQUIRE STRIPPING / DEVANNING OF FULL \r\n"
													+ "        CONTAINERS INSIDE PORT. \r\n";
    

    /* Set Tariff for B/L Mark */
    public static final String CMDT_DESC_ATTD_KHPNH	= "\r\n"
    												+ "CARGO IN TRANSIT TO CAMBODIA VIA CAT LAI - \r\n" 
    												+ "FREEPORT ZONE \r\n";
    
    /* Set Tariff for B/L Mark */ 
    public static final String CMDT_DESC_ATTD_DZ = "\r\n"
    												+ "        a) Demurrage as per line tariff: \r\n"
    												+ "        b) Demurrage tariffs at Algeria: \r\n"
													+ "        10 free days \r\n"
													+ "        From day 11th to 20th 16 usd / teu /day \r\n"
													+ "        From day 21st to 80th 32 usd / teu /day \r\n"
													+ "        From day 81st to 90th 96 usd / teu /day";

    public static final String CMDT_DESC_ATTD_DZ_DRY = "\r\n"
    												+ "DRY Cargo \r\n"
													+ "from day 1st to 15th, total days 15 : FREE TIME \r\n"
													+ "from day 16th to 25th, total days 10: usd 20 / TEU / DAY \r\n"
													+ "from day 26st to 80th, total days 55: usd 40 / TEU / DAY \r\n"
													+ "from day 81st to 90th, total days 10: usd 60 / TEU / DAY";
    
    public static final String CMDT_DESC_ATTD_DZ_SPCL = "\r\n"
    												+ "Special Cargo \r\n"
													+ "from day 1st to 15th, total days 15 : FREE TIME \r\n"
													+ "from day 16th to 25th, total days 10: usd 30 / TEU / DAY \r\n"
													+ "from day 26st to 80th, total days 55: usd 60 / TEU / DAY \r\n"
													+ "from day 81st to 90th, total days 10: usd 90 / TEU / DAY";
    
    
    public static final String CMDT_DESC_ATTD_US_DZ = "\r\n"
													+ "1. Demurrage \r\n"
													+ "Please refer to local terminal tariff. \r\n\r\n"
													+ "2. Detention \r\n"
													+ "A. General Detention for Algeria \r\n\r\n"
													+ "Free Time commences at time of movement date. \r\n"
													+ "There are no exclusions for Saturdays, Sundays or holidays\r\n"
													+ "for any container. \r\n" 
													+ "Rates below in USD: \r\n"
													+ "                    FREE   OVER      RATE PER DAY \r\n"
													+ "              QTY   DAYS   DAYS   20      40      HC \r\n"
													+ "DRY INCL. HAZ  1–    15    1–10   20.00   40.00   40.00 \r\n"
													+ "                           11-65  40.00   80.00   80.00 \r\n"
													+ "                           66 +   60.00   120.00  120.00 \r\n"
													+ "FLAT RACK/TANK 1–    15    1-10   30.00   60.00   60.00 \r\n"
													+ "OPEN TOP (INCL. OOG)       11-65  60.00   120.00  120.00 \r\n"
													+ "                           66 +   90.00   180.00  180.00 \r\n";
    
    
    public static final String CMDT_DESC_IRBND = "\r\n\"BANDAR ABBAS\" REFERS TO \"BANDAR ABBAS(SHAHID RAJAEE\r\n"
													+ "CONTAINER TERMINAL NO.II)\" \r\n";
	    
    public static final String CMDT_DESC_IRBND_WEB = "\r\n\"BANDAR ABBAS\" REFERS TO \"BANDAR ABBAS(SHAHID RAJ\r\n"
    											    +"AEE\r\n" 
													+ "CONTAINER TERMINAL NO.II)\"";										    
    
     /* Set mail size by one mail */   
    public static final int EML_ATTACH_SIZE     = 10 * 100 * 1024;//1M 
    
    public static final String BL_CLAUSE_POL = "VNSGN";  
    public static final String BL_CLAUSE_POD = "KHPNH";
    
    /**
     * CSTMS_DIV_ID 정의
     * 
	 * @author Lee Subin
	 * @see 각 DAO 클래스 참조
	 * @since J2EE 1.4
     */
	public class CstmsDivId {
		public static final String CTM = "CTM";       // 세관
		public static final String CLL = "CLL";       // CLL
		public static final String CDL = "CDL";       // CDL
	}

    /**
     * TRANS_MSG_TYPE 정의
     * 
	 * @author Lee Subin
	 * @see 각 DAO 클래스 참조
	 * @since J2EE 1.4
     */
	public class TransMsgType {
		public static final String ORIGINAL_POL = "9";       // Original Message (1차전송 : POL 지역)
		public static final String ORIGINAL_POD = "0";       // Other Data of Original Message (2차전송 : POD 지역)
		public static final String CHANGE = "5";       		 // Change Message (1차, 2차 전송 후 변경전송)
		public static final String DELETE = "3";	         // Delete Message (1차, 2차 전송 후 삭제전송)
	}
	
	/**
	 * 하드코딩 테이블의 하드코딩아이디를 상수화함.
	 * @author 김민정
	 * @see bkg_Hrd_cdg_desc 참조
	 * @since J2EE 1.4
	 */
	public class HrdCdgId {
		public static final String CND_CSTMS_CRR_CD	= "CND_CSTMS_CRR_CD";	//CANADA CUSTOMS CARRIER CODE
		public static final String CND_RESULT_CODE	= "CND_RESULT_CODE";	//CANADA CUSTOMS RESULT CODE
		public static final String CND_AN_TP_CD		= "CND_AN_TP_CD";		//CANADA ADVICE NOTES TYPE CODE
		public static final String TRSPT_TP_ID		= "TRSPT_TP_ID";		//
		public static final String SCR_ROLE_DEF		= "SCR_ROLE_DEF";		// SECURITY ROLE ENABLE / DISABLE FOR BKG/DOC
		public static final String CND_AVCNTC_OFC_SET = "CND_AVCNTC_OFC_SET";//CANADA ADVICE NOTES OFICE ADDRESS
		public static final String CND_VSL_CERTI_CD = "CND_VSL_CERTI_CD";	//CANADA VESSEL CERTIFICATION DATE CODE
	}

	public static final List<String> SAMF_LIST = Arrays.asList(new String[]{"C1T0X","C1T0W","C1T0M","C1T0S","C1T0P","C1T0D","110AL","FSELC","C1S0","T613","T614","T615","T612","T514","T515","T516","T517","T518","T621"});
}
