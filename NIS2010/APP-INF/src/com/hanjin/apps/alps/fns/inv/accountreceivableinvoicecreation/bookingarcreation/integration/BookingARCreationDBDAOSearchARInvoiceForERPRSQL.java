/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchARInvoiceForERPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2014.12.15 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchARInvoiceForERPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOSearchARInvoiceForERPRSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchARInvoiceForERPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchARInvoiceForERPRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT 'FNS0120001' AS LIFID" ).append("\n"); 
		query.append("     , TO_CHAR (SYSDATE, 'YYYYMMDDHH24MISS') || SUBSTR (TO_CHAR (1 - SUBSTR (DBMS_UTILITY.get_time, -2), '09'), -2) || '0' AS SEQ" ).append("\n"); 
		query.append("     , C.TTL_CNT AS TOTAL_COUNT" ).append("\n"); 
		query.append("     , B.AR_IF_CHG_SEQ AS ROW_COUNT" ).append("\n"); 
		query.append("     , @[flag] AS FLAG" ).append("\n"); 
		query.append("     --, A.AR_IF_NO MAIN_IF_NO" ).append("\n"); 
		query.append("     --, DECODE(SIGN(TO_NUMBER(A.BL_INV_IF_DT) - TO_NUMBER('20100314')), -1, A.OLD_AR_IF_NO, A.AR_IF_NO) MAIN_IF_NO" ).append("\n"); 
		query.append("     --, DECODE(SIGN(TO_NUMBER(A.BL_INV_IF_DT) - TO_NUMBER('20100314')), -1, DECODE(A.OLD_AR_IF_NO, '', A.AR_IF_NO, A.OLD_AR_IF_NO), A.AR_IF_NO) MAIN_IF_NO" ).append("\n"); 
		query.append("     , DECODE(A.OLD_AR_IF_NO, '', A.AR_IF_NO, A.OLD_AR_IF_NO) MAIN_IF_NO" ).append("\n"); 
		query.append("     , A2.AR_IF_SER_NO MAIN_IF_SER" ).append("\n"); 
		query.append("     , A.BL_SRC_NO BL_NO" ).append("\n"); 
		query.append("     , A.BL_TP_CD BL_NO_TP" ).append("\n"); 
		query.append("     , A.BKG_NO BKG_NO" ).append("\n"); 
		query.append("     , A2.AR_INV_SRC_CD SOURCE" ).append("\n"); 
		query.append("     , A2.TJ_SRC_NM TRANS_TYP" ).append("\n"); 
		query.append("     --, D.INV_NO INV_NO " ).append("\n"); 
		query.append("     --, DECODE(B.INV_CLR_FLG, 'Y', 'SYS CLEAR',  D.INV_NO) INV_NO" ).append("\n"); 
		query.append("     --, DECODE(B.INV_CLR_FLG, 'Y', 'SYS CLEAR',  NVL(D.INV_NO, A.INV_SRC_NO)) INV_NO" ).append("\n"); 
		query.append("     --, DECODE(I.OTS_SMRY_CD, 'INV', D.INV_NO, DECODE(B.INV_CLR_FLG, 'Y', 'SYS CLEAR',  NVL(D.INV_NO, A.INV_SRC_NO))) INV_NO" ).append("\n"); 
		query.append("     , DECODE(I.OTS_SMRY_CD, 'INV', DECODE(B.INV_CLR_FLG, 'Y', 'SYS CLEAR', A.INV_NO), A.INV_NO) INV_NO" ).append("\n"); 
		query.append("     , A.BKG_CORR_NO CA_NO  " ).append("\n"); 
		query.append("     , TO_CHAR(A.BKG_CORR_DT, 'YYYYMMDD') CA_DT " ).append("\n"); 
		query.append("     , F.AR_HD_QTR_OFC_CD RHQ" ).append("\n"); 
		query.append("     , A2.ERP_IF_OFC_CD OFC" ).append("\n"); 
		query.append("     , A.ACT_CUST_CNT_CD ACT_CNTRY_CD" ).append("\n"); 
		query.append("     , LPAD(A.ACT_CUST_SEQ, 6, '0') ACT_CUST_CD" ).append("\n"); 
		query.append("     , A.INV_CUST_CNT_CD INV_CNTRY_CD" ).append("\n"); 
		query.append("     , LPAD(A.INV_CUST_SEQ, 6, '0') INV_CUST_CD" ).append("\n"); 
		query.append("     , A.VSL_CD VSL" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO VOY" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD DIR" ).append("\n"); 
		query.append("     , A.TRNK_VSL_CD||TRNK_SKD_VOY_NO||TRNK_SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append("     , A.REV_VSL_CD REV_VSL" ).append("\n"); 
		query.append("     , A.REV_SKD_VOY_NO REV_VOY" ).append("\n"); 
		query.append("     , A.REV_SKD_DIR_CD||REV_DIR_CD REV_DIR" ).append("\n"); 
		query.append("     , A.SAIL_ARR_DT SA_DT" ).append("\n"); 
		query.append("     , A.POR_CD POR" ).append("\n"); 
		query.append("     , A.POL_CD POL" ).append("\n"); 
		query.append("     , A.POD_CD POD" ).append("\n"); 
		query.append("     , A.DEL_CD DEL" ).append("\n"); 
		query.append("     , A.SVC_SCP_CD SCP" ).append("\n"); 
		query.append("     --, A.INV_SVC_SCP_CD SCP" ).append("\n"); 
		query.append("     , A.SLAN_CD LANE" ).append("\n"); 
		query.append("     , A.IO_BND_CD BND" ).append("\n"); 
		query.append("     , A.CUST_CR_FLG CREDIT_MK" ).append("\n"); 
		query.append("     , A.SREP_CD SLSMAN_CD" ).append("\n"); 
		query.append("     , A.DUE_DT DUE_DT" ).append("\n"); 
		query.append("     , (SELECT SUM(DECODE(xx.CURR_CD, 'USD', xx.CHG_AMT, 0))" ).append("\n"); 
		query.append("          FROM INV_AR_CHG XX" ).append("\n"); 
		query.append("         WHERE XX.AR_IF_NO =  @[if_no]" ).append("\n"); 
		query.append("           AND XX.AR_IF_SER_NO = A2.AR_IF_SER_NO ) USD_AMT  " ).append("\n"); 
		query.append("     , (SELECT SUM(DECODE(xx.CURR_CD, 'USD', 0, xx.CHG_AMT))" ).append("\n"); 
		query.append("          FROM INV_AR_CHG XX" ).append("\n"); 
		query.append("         WHERE XX.AR_IF_NO =  @[if_no]" ).append("\n"); 
		query.append("           AND XX.AR_IF_SER_NO = A2.AR_IF_SER_NO ) LCL_AMT  " ).append("\n"); 
		query.append("     , DECODE(A.WHF_FLG,'C',A.INV_RMK,A.WHF_DECL_NO) WHF_DEC_NO" ).append("\n"); 
		query.append("     , NULL CTT_DEC_NO" ).append("\n"); 
		query.append("     , A.ZN_IOC_CD ZONE_IOC" ).append("\n"); 
		query.append("     , A2.INV_ERP_IF_STS_CD IF_FLAG" ).append("\n"); 
		query.append("     , A2.ERP_IF_DT ERP_IF_DT" ).append("\n"); 
		query.append("     , A2.INV_COA_CO_CD INV_COA_COMPANY" ).append("\n"); 
		query.append("     , A2.INV_COA_RGN_CD INV_COA_REGION" ).append("\n"); 
		query.append("     , A2.INV_COA_CTR_CD INV_COA_CENTER" ).append("\n"); 
		query.append("     , A2.INV_COA_ACCT_CD INV_COA_ACCOUNT" ).append("\n"); 
		query.append("     , A2.INV_COA_INTER_CO_CD INV_COA_INTER_COMPANY" ).append("\n"); 
		query.append("     , A2.INV_COA_VSL_CD||A2.INV_COA_VOY_NO||A2.INV_COA_SKD_DIR_CD||A2.INV_COA_REV_DIR_CD INV_COA_VVD" ).append("\n"); 
		query.append("     , '000000' INV_COA_FUTURE1" ).append("\n"); 
		query.append("     , '000000' INV_COA_FUTURE2" ).append("\n"); 
		query.append("     , A.RLANE_CD REV_LANE" ).append("\n"); 
		query.append("     --, NVL(A.SC_NO, A.RFA_NO) CONT_NO" ).append("\n"); 
		query.append("     , CASE WHEN A.SC_NO IS NOT NULL THEN A.SC_NO " ).append("\n"); 
		query.append("            WHEN A.RFA_NO IS NOT NULL THEN A.RFA_NO" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("            (SELECT TAA_NO" ).append("\n"); 
		query.append("             FROM   BKG_BOOKING" ).append("\n"); 
		query.append("             WHERE  BKG_NO = (SELECT BL_SRC_NO FROM INV_AR_MN WHERE AR_IF_NO = @[if_no]))" ).append("\n"); 
		query.append("       END CONT_NO" ).append("\n"); 
		query.append("     , A.CR_TERM_DYS CREDIT_TERM" ).append("\n"); 
		query.append("     , A.SAIL_DT SAILING_DT" ).append("\n"); 
		query.append("     , A2.ERP_IF_GL_DT GL_DT" ).append("\n"); 
		query.append("     --, A.GL_EFF_DT GL_DT" ).append("\n"); 
		query.append("     --, A.XCH_RT_USD_TP_CD EX_RATE_TYPE  2010.05.12 Currency별 구분처리" ).append("\n"); 
		query.append("     , DECODE(A2.CURR_CD, A.LOCL_CURR_CD, A.XCH_RT_USD_TP_CD, 'USD', A.XCH_RT_USD_TP_CD, A.XCH_RT_N3RD_TP_CD) EX_RATE_TYPE" ).append("\n"); 
		query.append("     , A.XCH_RT_DT EX_RATE_CUST_DATE" ).append("\n"); 
		query.append("     , A.AP_AR_OFFST_NO SETOFF_NO  " ).append("\n"); 
		query.append("     , A.INV_REF_NO CUST_REF_NO" ).append("\n"); 
		query.append("     , SUBSTR(A.HJS_STF_CTNT,1,20) HJS_REF_NO" ).append("\n"); 
		query.append("     , A.TAX_XCH_RT TAX_EX_RATE" ).append("\n"); 
		query.append("     , A.AR_TAX_IND_CD TAX_IND" ).append("\n"); 
		query.append("     , A.OBRD_DT ONBOARD_DT" ).append("\n"); 
		query.append("     , LPAD(TO_CHAR(A.IF_SEQ), 5, '0') OBL_MK" ).append("\n"); 
		query.append("     , A.AR_CTY_CD CTY_CD" ).append("\n"); 
		query.append("     , A.SLS_OFC_CD SALES_OFC" ).append("\n"); 
		query.append("     , HJSEAI_PKG.h_encode(SUBSTR(A.INV_RMK, 1, 50), 'ERP', 'HJSKOR') RMK" ).append("\n"); 
		query.append("     , A2.CURR_CD CURR" ).append("\n"); 
		query.append("     , A.UPD_USR_ID USER_ID" ).append("\n"); 
		query.append("     , TO_CHAR(A.CRE_DT, 'YYYYMMDDHH24MISS') LOG_RGST_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.UPD_DT, 'YYYYMMDDHH24MISS') LOG_UPDT_DT" ).append("\n"); 
		query.append("     , A.ISS_DT ISS_DT" ).append("\n"); 
		query.append("     , A.SLP_NO SLIP_NO" ).append("\n"); 
		query.append("     , NULL JO_IND" ).append("\n"); 
		query.append("     --, B.AR_IF_NO DTL_IF_NO" ).append("\n"); 
		query.append("     --, DECODE(SIGN(TO_NUMBER(A.BL_INV_IF_DT) - TO_NUMBER('20100220')), -1, A.OLD_AR_IF_NO, A.AR_IF_NO) DTL_IF_NO" ).append("\n"); 
		query.append("     , DECODE(A.OLD_AR_IF_NO, '', A.AR_IF_NO, A.OLD_AR_IF_NO) DTL_IF_NO" ).append("\n"); 
		query.append("     , B.AR_IF_SER_NO DTL_IF_SER" ).append("\n"); 
		query.append("     , B.AR_IF_CHG_SEQ CHG_SEQ" ).append("\n"); 
		query.append("     , B.CHG_CD CHG_TYP" ).append("\n"); 
		query.append("     , B.REP_CHG_CD REP_CHG_TYP" ).append("\n"); 
		query.append("     , B.CURR_CD CHG_CUR" ).append("\n"); 
		query.append("     , B.INV_REV_TP_SRC_CD REV_TYP" ).append("\n"); 
		query.append("     , B.CHG_AMT CHG_AMT" ).append("\n"); 
		query.append("     , 0 TAX_AMT" ).append("\n"); 
		query.append("     , B.REV_COA_CO_CD REV_COA_COMPANY" ).append("\n"); 
		query.append("     , B.REV_COA_RGN_CD REV_COA_REGION" ).append("\n"); 
		query.append("     , B.REV_COA_CTR_CD REV_COA_CENTER" ).append("\n"); 
		query.append("     , B.REV_COA_ACCT_CD REV_COA_ACCOUNT" ).append("\n"); 
		query.append("     , B.REV_COA_INTER_CO_CD REV_COA_INTER_COMPANY" ).append("\n"); 
		query.append("     , B.REV_COA_VSL_CD||B.REV_COA_VOY_NO||B.REV_COA_SKD_DIR_CD||B.REV_COA_DIR_CD REV_COA_VVD" ).append("\n"); 
		query.append("     , '000000' REV_COA_FUTURE1" ).append("\n"); 
		query.append("     , '000000' REV_COA_FUTURE2" ).append("\n"); 
		query.append("     , B.CURR_CD ORI_CHG_CUR" ).append("\n"); 
		query.append("     , B.CHG_AMT ORI_CHG_AMT" ).append("\n"); 
		query.append("     , NULL REV_EFF_DT" ).append("\n"); 
		query.append("     , B.PER_TP_CD PER_TYP" ).append("\n"); 
		query.append("     , B.TRF_RT_AMT RATE" ).append("\n"); 
		query.append("     , B.RAT_AS_CNTR_QTY RATED_AS" ).append("\n"); 
		query.append("     , B.SOB_ID SOB_ID" ).append("\n"); 
		query.append("     , B.CHG_FULL_NM CHG_FULL_NM" ).append("\n"); 
		query.append("     , B.ACCT_CD ACCT" ).append("\n"); 
		query.append("     , '' CNTR_NO" ).append("\n"); 
		query.append("     , '' CNTR_TP_SZ" ).append("\n"); 
		query.append("     , A.RFA_NO" ).append("\n"); 
		query.append("     --, A.XCH_RT_N3RD_TP_CD THIRD_EX_RATE_TYPE" ).append("\n"); 
		query.append("     , '' THIRD_EX_RATE_TYPE " ).append("\n"); 
		query.append("     , A.WHF_DECL_CFM_DT WHF_DEC_DT" ).append("\n"); 
		query.append("     , A.WHF_DECL_VSL_CD||A.WHF_DECL_VOY_NO||A.WHF_DECL_DIR_CD WHF_DEC_VVD" ).append("\n"); 
		query.append("     , A.WHF_DECL_OFC_CD WHF_DEC_OFC" ).append("\n"); 
		query.append("     , A.WHF_MRN_NO WHF_MRN_NO" ).append("\n"); 
		query.append("     , A.WHF_NTC_NO WHF_NTC_NO" ).append("\n"); 
		query.append("     , DECODE(A.WHF_FLG, 'Y', 'WHF I/F', 'C', 'WHF I/F CANCEL', 'N', '') WHF_FLAG" ).append("\n"); 
		query.append("     , A.CSR_NO WHF_CSR_NO" ).append("\n"); 
		query.append("     , A.CTRT_OFC_CD CTRT_OFC_CD" ).append("\n"); 
		query.append("	 , DECODE(A.WHF_FLG, 'C', 'Y', 'N') WHF_DECL_CXL_FLG" ).append("\n"); 
		query.append("     , A.SI_REF_NO SI_REF_NO" ).append("\n"); 
		query.append("	 , (SELECT MAX(TO_CHAR(RT_APLY_DT,'YYYYMMDD')) FROM BKG_RATE WHERE BKG_NO = A.BKG_NO) AS RT_APLY_DT" ).append("\n"); 
		query.append("  FROM INV_AR_MN A, INV_AR_AMT A2, INV_AR_CHG B," ).append("\n"); 
		query.append("        (SELECT AR_IF_SER_NO, COUNT(CHG_SEQ) TTL_CNT" ).append("\n"); 
		query.append("           FROM INV_AR_CHG" ).append("\n"); 
		query.append("          WHERE AR_IF_NO = @[if_no]" ).append("\n"); 
		query.append("          GROUP BY AR_IF_SER_NO) C," ).append("\n"); 
		query.append("        MDM_ORGANIZATION F," ).append("\n"); 
		query.append("        (SELECT G.OTS_SMRY_CD OTS_SMRY_CD" ).append("\n"); 
		query.append("           FROM INV_AR_STUP_OFC G , INV_AR_MN H" ).append("\n"); 
		query.append("          WHERE H.AR_IF_NO = @[if_no]" ).append("\n"); 
		query.append("            AND G.AR_OFC_CD = H.AR_OFC_CD) I" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = @[if_no]" ).append("\n"); 
		query.append("  AND A.AR_IF_NO = A2.AR_IF_NO" ).append("\n"); 
		query.append("  AND A2.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("  AND A2.AR_IF_SER_NO = B.AR_IF_SER_NO" ).append("\n"); 
		query.append("  AND B.AR_IF_SER_NO = C.AR_IF_SER_NO " ).append("\n"); 
		query.append("  --AND A.AR_OFC_CD = F.OFC_CD" ).append("\n"); 
		query.append("  AND A2.ERP_IF_OFC_CD = F.OFC_CD" ).append("\n"); 
		query.append("ORDER BY A.AR_IF_NO, A2.AR_IF_SER_NO, B.CHG_SEQ" ).append("\n"); 

	}
}