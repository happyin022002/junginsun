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
package com.clt.apps.opus.fns.joo.joocommonutil;

/**
 * 업무공통에서 사용하는 JooConstants<br>
 * @author Hyung Choon_Roh
 * @see 
 * @since J2EE 1.6
 */
public class JooConstants {
	
	/**
	 * Key Module ID : JOO
	 */
	public static final String KEY_MODULE_ID = "JOO";
	
	/**
	 * Key Slip Tp Cd 06 : 06
	 */
	public static final String KEY_SLIP_TP_CD_AP_06 = "06";
	/**
	 * Key Slip Tp Cd 18 : 18
	 */
	public static final String KEY_SLIP_TP_CD_AR_18 = "18";
	/**
	 * Key Slip Func Cd Standard S : S
	 */
	public static final String KEY_SLIP_FUNC_CD_S = "S";
	/**
	 * Key Slip Func Cd CREDIT C : C
	 */
	public static final String KEY_SLIP_FUNC_CD_C = "C";
	/**
	 * Key csr type CREDIT : CREDIT
	 */
	public static final String KEY_CSR_TP_CD_CREDIT = "CREDIT";
	/**
	 * Key csr type STANDARD : STANDARD
	 */
	public static final String KEY_CSR_TP_CD_STANDARD = "STANDARD";
	/**
	 * Key dr cr tp cd DR : DR
	 */
	public static final String KEY_DR_CR_TP_CD_DR = "DR";
	/**
	 * Key dr cr tp cd CR : CR
	 */
	public static final String KEY_DR_CR_TP_CD_CR = "CR";
	/**
	 * Key Approval kind type : CSR
	 */
	public static final String KEY_APPROVAL_KIND_TYPE_CSR = "CSR";
	/**
	 * Key Approval kind type : REV
	 */
	public static final String KEY_APPROVAL_KIND_TYPE_REV = "REV";
	
	/**
	 * Key Slip ID 18 : 18
	 */
	public static final String KEY_SLIP_ID_18 = "18";
	
	//AP TAX CODE
	public static final String KEY_TAX_TYPE_CODE = "AP TAX CODE";
	
	/**
	 * Default Value slp_ser_no : 0001
	 */
	public static final String DEFAULT_VALUE_SLP_SER_NO = "0001";
	/**
	 * Default Value tax_ser_no : 00001
	 */
	public static final String DEFAULT_VALUE_TAX_SER_NO = "00001";
	
	/**
	 * Evidence Class E3 : AP 8% Vat
	 */
	public static final String EVIDENCE_CLASS_E3 = "E3";
	/**
	 * Evidence Class F0 : AP Tax Free
	 */
	public static final String EVIDENCE_CLASS_F0 = "F0";
	
	/**
	 * Excel Download TP CD CNTRVVD : CNTRVVD
	 */
	public static final String BACKEND_JOB_PGM_FNS_JOO_0084 = "FNS_JOO_0084";
	
	/**
	 * Excel Download Standard Format : StandardFormat
	 */
	public static final String BACKEND_JOB_PGM_FNS_JOO_0084_01 = "FNS_JOO_0084_01";
	
	/**
	 * Excel Download TP CD CNTRVVD : CNTRVVD
	 */
	public static final String EXCEL_TP_CD_CNTRVVD = "CNTRVVD";
	
	public static final String KEY_COM_PPT_TPSZ = "TPSZ MAP";
	public static final String KEY_COM_PPT_TEU = "TEU CONVERSION";
	public static final String KEY_COM_PPT_VOID = "VOID CONVERSION";
	public static final String KEY_COM_PPT_OPTION = "OPTION";
	public static final String KEY_COM_PPT_DEFAULT_TPSZ = "DEFAULT TPSZ";
	public static final String KEY_COM_PPT_DEFAULT_LADEN = "F";
	public static final String KEY_COM_PPT_DEFAULT_EMPTY = "E";
	
	public static final String KEY_JO_STL_ITM_CD_SH  = "S/H" ;
	public static final String KEY_VOY_DAYS_CD_VVD  = "V" ;
	public static final String KEY_VOY_DAYS_CD_MONTH  = "M" ;
	public static final String KEY_CRE_FLG_BACKEND  = "B";
	
	public static final String KEY_JO_STL_ITM_CD_OPR  = "OPR";
	public static final String KEY_JO_MNU_NM_OPR  = "OPR";
	
	public static final String KEY_SH_OPTION_VVD  = "V";
	public static final String KEY_SH_OPTION_G6GA  = "G";
	public static final String KEY_SH_OPTION_PORT  = "P";
	/**
	 * Default vsl_slan_cd
	 */
	public static final String DEFAULT_VSL_SLAN_CD = "COM";//2015.04.28 ADD 
	

	public static final String KEY_RE_DIVR_CD_REVENUE  = "R";
	public static final String KEY_RE_DIVR_CD_EXPENSE  = "E";
	public static final String SPLIT_DATA_STRING  = "^";
	public static final String SPLIT_ROW_STRING  = "|";
	public static final String SPLIT_TAP_STRING  = "\t";
	
	public static final String KEY_OFFICE_GROUP_CD  = "000001";
	public static final String KEY_OFFICE_SUBSYS_CD  = "COM";
	
	public static final String KEY_COMBOITEM_FLG_CARRIER  = "CARRIER";
	public static final String KEY_COMBOITEM_FLG_TRADE  = "TRADE";
	public static final String KEY_COMBOITEM_FLG_RLANE  = "RLANE";
	public static final String KEY_COMBOITEM_FLG_AUTH_OFC  = "OFFICE";
	public static final String KEY_COMBOITEM_FLG_CSR_AUTH_OFC  = "CSR_OFFICE";
	public static final String KEY_SEARCH_TP_CD_CSR_APPROVAL  = "A";
	public static final String KEY_SEARCH_TP_CD_CSR_INQUIRY  = "I";
}
