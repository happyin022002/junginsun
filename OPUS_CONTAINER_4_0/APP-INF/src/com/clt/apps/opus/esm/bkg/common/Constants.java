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
=========================================================*/
package com.clt.apps.opus.esm.bkg.common;

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

    public static final String CMDT_DESC_ATTD_BR   = "\r\n"
												   + "OCEAN FREIGHT PREPAID \r\n"
												   + "DESTINATION CHARGES COLLECT PER LINE \r\n"
												   + "TARIFF AND OTHER CHARGES TO BE COLLECTED \r\n"
												   + "FROM THE PARTY WHO LAWFULLY DEMANDS \r\n"
												   + "DELIVERY OF THE CARGO WITHOUT PREJUDICE \r\n"
												   + "TO THE CARRIER'S RIGHTS AGAINST \r\n"
												   + "THE MERCHANT (SEE BACK ARTICLE 1(H)) AS \r\n"
												   + "SET OUT AT BACK ARTICLE 23(6) \r\n"
												   + "THESE COMMODITIES, TECHNOLOGY OR SOFTWARE \r\n"
												   + "WERE EXPORTED FROM THE UNITED STATES IN \r\n"
												   + "ACCORDANCE WITH THE EXPORT ADMINISTRATION \r\n"
												   + "REGULATIONS. DIVERSION CONTRARY TO \r\n"
												   + "U.S. LAW PROHIBITED. \r\n"
												   + "AS PER BRAZILIAN CUSTOMS REGULATIONS, \r\n"
												   + "THOSE CUSTOMS AUTHORITIES, MAY RELEASE CARGO \r\n"
												   + "WITHOUT PRODUCTION OF ORIGINAL MASTER \r\n"
												   + "BILL(S) OF LADING AND WITHOUT NOTIFYING \r\n"
												   + "CARRIERS. CARRIERS ARE NOT RESPONSIBLE \r\n"
												   + "FOR SUCH DELIVERY AND DO NOT ACCEPT ANY \r\n"
												   + "LIABILITY. \r\n";

    public static final String CMDT_DESC_ATTD_UY   = "\r\n"
                                                   + "* FREIGHT AND DEMURRAGE ARE CONSIDERED \r\n"
                                                   + "INDIVISIBLE OBLIGATIONS.THEREFORE,THE \r\n"
                                                   + "CARRIER IS NOT OBLIGED TO DELIVER THE \r\n"
                                                   + "CARGO UNTIL PAYMENT OF ALL AMOUNTS DUE. \r\n"
                                                   + "\r\n"
                                                   + "ALL EXPENSES AND RISK ARISING FROM THE \r\n"
                                                   + "NON-DELIVERY ALONGSIDE FOR DISPATCH \r\n"
                                                   + "CARGO(OR IF SUCH IS DECLARED BY \r\n"
                                                   + "AUTHORITIES WHEN SHIP IS READY TO\r\n"
                                                   + "DISCHARGE)TO BE FOR ACCOUNT OF THE\r\n"
                                                   + "MERCHANDISE.\r\n"
                                                   + "--------------------------------\r\n"
                                                   + "RULES AND CONDITIONS OF DEMURRAGE/\r\n"
                                                   + "DETENTION AS PER CARRIERS TARIFF.\r\n"
                                                   + "--------------------------------\r\n"
                                                   + "\r\n"
                                                   + "DESTINATION TERMINAL HANDLING CHARGES\r\n"
                                                   + "ARE PAYABLE BY CONSIGNEE.";
    
    public static final String CMDT_DESC_ATTD_MX   = "\r\n"
                                                   + "* CARRIER'S RESPONSIBILITY DURING INLAND\r\n"
                                                   + " TRANSPORTATION IN MEXICO TO BE IN\r\n"
                                                   + " ACCORDANCE WITH APPLICABLE MEXICAN LAW.";
    
    public static final String CMDT_DESC_ATTD_GT   = "\r\n"
                                                   + "* THE CARRIER SHALL HAVE NO LIABILITY \r\n"
                                                   + "WHATSOEVER ARISING OUT OF OR IN CONNECTION \r\n"
                                                   + "WITH THE ACTS OF ANY PERSON WHO UNLAWFULLY \r\n"
                                                   + ", BY THE USE OF FORCE OR THREATS OF ANY \r\n"
                                                   + "KIND,DAMAGES, SEIZES, OR EXERCISES CONTROL \r\n"
                                                   + "OVER THE GOODS, OVER ANY SUB-CONTRACTORS \r\n"
                                                   + "OR OVER ANY MEANS OF TRANSPORTATION OR \r\n"
                                                   + "STORAGE OF THE GOODS.";
    
    public static final String CMDT_DESC_ATTD_GR   = "\r\n"
		   										   + "WITHOUT PREJUDICE TO THE GENERAL TERMS \r\n"
		   										   + "AND CONDITIONS OF THE BILL OF LADING, \r\n"
		   										   + "EMPTY CONTAINERS SHALL BE RETURNED \r\n"
		   										   + "TO THE CARRIER IN GOOD ORDER AND CONDITION \r\n" 
		   										   + "AND LOADED ON A VESSEL OF CARRIER'S \r\n"
		   										   + "CHOICE BY THE MERCHANT/CARGO RECEIVERS \r\n" 
		   										   + "UNDER THEIR RESPONSIBILITY AND \r\n"
		   										   + "AT THEIR EXPENSE";
    
    public static final String CMDT_DESC_ATTD_EG   = "\r\n"
												   + "WITHOUT PREJUDICE TO THE GENERAL TERMS \r\n"
												   + "AND CONDITIONS OF THE BILL OF LADING, \r\n" 
												   + "EMPTY CONTAINERS SHALL BE RETURNED \r\n" 
												   + "TO THE CARRIER IN GOOD ORDER AND CONDITION \r\n"
												   + "AND LOADED ON A VESSEL OF CARRIER'S \r\n"
												   + "CHOICE BY THE MERCHANT/CARGO RECEIVERS \r\n"
												   + "UNDER THEIR RESPONSIBILITY AND \r\n" 
												   + "AT THEIR EXPENSE";
    
    /* Set mail size by one mail */
    public static final int EML_ATTACH_SIZE     = 10 * 100 * 1024;//1M 
        
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

	public static final List<String> SAMF_LIST = Arrays.asList(new String[]{"C1T0W","C1T0M","C1T0S","110AL","FSELC"});
}
