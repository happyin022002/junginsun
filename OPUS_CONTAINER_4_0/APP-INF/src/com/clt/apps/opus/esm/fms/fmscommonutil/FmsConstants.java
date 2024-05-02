/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PortChargeBudgetSC.java
 *@FileTitle : Lane/Port Expense Ratio Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.02.18
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.02.18 진마리아
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommonutil;
/**
 * 업무공통에서 사용하는 Constants.<br>
 * @author Hyung Choon_Roh
 * @see 
 * @since J2EE 1.4
 */
public class FmsConstants {
	
	//AP TAX CODE
	public static final String KEY_TAX_TYPE_CODE = "AP TAX CODE";
	/**
	 * Evidence Class E3 : AP 8% Vat
	 */
	public static final String KEY_EVIDENCE_CLASS_E3 = "E3";
	/**
	 * Evidence Class F0 : AP Tax Free
	 */
	public static final String KEY_EVIDENCE_CLASS_F0 = "F0";
	
	public static final int DEFAULT_SLP_SEQ_NO = 1;
	
	public static final String KEY_SLP_TP_CD_AP_07 = "07";
	public static final String KEY_SLP_TP_CD_AR_20 = "20";
	public static final String KEY_SLP_FUNC_CD_STANDARD = "S";
	public static final String KEY_SLP_FUNC_CD_PREPAYMENT = "P";
	
	
	public static final String DEFAULT_SEQ_NO_00001 = "00001";
	
	public static final String DEFAULT_SEQ_NO_0001 = "0001";
	
	public static final String DEFAULT_VSL_SLAN_CD = "COM";//2015.04.28 : COM > CNT 로 변경. > COM 재 변경.
	
	public static final String DEFAULT_AP_INV_HDR_SRC_CTNT = "FMS";
	public static final String DEFAULT_AP_INV_HDR_COA_CO_CD = "01";
	public static final String DEFAULT_AP_INV_HDR_COA_ACCT_CD = "210111";
	public static final String DEFAULT_AP_INV_HDR_COA_VVD_CD = "0000000000";
	public static final String DEFAULT_AP_INV_HDR_COA_INTER_CO_CD = "00";
	public static final String DEFAULT_AP_INV_HDR_COA_FTU_N1ST_CD = "000000";
	public static final String DEFAULT_AP_INV_HDR_COA_FTU_N2ND_CD = "000000";
	public static final String DEFAULT_AP_INV_HDR_APRO_FLG = "Y";
	public static final String DEFAULT_AP_INV_HDR_ATTR_CATE_NM = "Invoices";
	
	public static final String DEFAULT_AR_JO_REV_TP_CD_HIRE = "CDM";	//2015.11.10 Add
	public static final String DEFAULT_AR_JO_REV_TP_CD_OTHER = "OTH"; //2015.11.10 Add
	
	public static final String DEFAULT_AR_OTS_SRC_CD = "FMS";	 //2015.11.25
	public static final String DEFAULT_AR_TJ_SRC_NM = "SALAR";	 //2015.11.25
	public static final String DEFAULT_AR_REV_TP_SRC_CD = "CDM";	 //2015.11.25
	public static final String DEFAULT_AR_MODULE_KEY = "CDM";	 //2015.11.25
	public static final String DEFAULT_AR_CHG_CD = "CDM";	 //2015.11.25
	
	public static final String KEY_ALL = "ALL";
	public static final String KEY_ACCT_CD_CHARTERAGE = "C";
	public static final String KEY_ACCT_CD_OTHER = "O";
	
	public static final String KEY_FLET_CTRT_TP_CD_TI = "TI"; //2015.11.06 Add
	public static final String KEY_FLET_CTRT_TP_CD_TO = "TO"; //2015.11.06 Add
	
	public static final String KEY_ACCT_CD_DEBIT = "110811"; //2015.11.10 Add 차변계정.
	
	public static final String KEY_ACCT_CD_BY_HIRE_REVENUE = "411211";	//2015.11.10 Add Hire Revenue "954112" > "411211"
	public static final String KEY_ACCT_CD_BY_BUNKER = "411915";		//2015.11.10 Add Bunker "954111" > "411915"
	public static final String KEY_ACCT_CD_BY_BROKERAGE = "512641";	//2015.11.10 Add Brokerage 512641"
	
	public static final String KEY_FLET_SRC_TP_CD_01 = "01";	 //2015.11.10 Add 선급금 Prepayment's Selection 팝업 화면
	public static final String KEY_FLET_SRC_TP_CD_02 = "02";	 //2015.11.10 Add 운항정지비용 Offhire Expenses Selection 팝업 화면
	public static final String KEY_FLET_SRC_TP_CD_03 = "03";	 //2015.11.10 Add 용선주비용,    Account Management Selection 팝업 화면
	public static final String KEY_FLET_SRC_TP_CD_04 = "04";	 //2015.11.10 Add 본지점비용
	public static final String KEY_FLET_SRC_TP_CD_06 = "06";	 //2015.11.10 Add BOD, BOR Settlement Selection 팝업 화면
	public static final String KEY_FLET_SRC_TP_CD_10 = "10";	 //2015.11.10 Add 422011(O/A, OUTLAY COMM)
	public static final String KEY_FLET_SRC_TP_CD_11 = "11";	 //2015.11.10 Add 422011(Miscellaneous Income)
	public static final String KEY_FLET_SRC_TP_CD_20 = "20";	 //2015.11.10 Add VAT 존재시 951111(환대체), 111811(선급부가세), 951111(환대체), 580111(외환차손), 421211(외환차익)
	public static final String KEY_FLET_SRC_TP_CD_30 = "30";	 //2015.11.10 Add Prepayments Settlement ( ESM_FMS_0035 ) Save 시.
	public static final String KEY_FLET_SRC_TP_CD_40 = "40";	 //2015.11.10 Add 존재하지 않음.
	public static final String KEY_FLET_SRC_TP_CD_98 = "98";	 //2015.11.10 Add 메뉴얼 화면(Manual Slip ( ESM_FMS_0040 ))에서 Save 시.
	public static final String KEY_FLET_SRC_TP_CD_99 = "99";	 //2015.11.10 Add 메뉴얼, Payments Slip ( ESM_FMS_0021 ) Row Add 시.
	public static final String KEY_FLET_SRC_TP_CD_R1 = "R1";	 //2015.11.10 Add Reverse CSR for Sublet ( ESM_FMS_0033 ) 110811 , Sublet Revenue ( ESM_FMS_0032 ) 110811
	public static final String KEY_FLET_SRC_TP_CD_R6 = "R6";	 //2015.11.10 Add Reverse CSR for Sublet ( ESM_FMS_0033 ) 954112 , Sublet Revenue ( ESM_FMS_0032 ) 954112, 954111


	
	 

}
