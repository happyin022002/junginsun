/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchAsaClearingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchAsaClearingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAsaClearingList
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchAsaClearingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchAsaClearingListRSQL").append("\n"); 
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
		query.append("SELECT  SID.ROWID                           AS ROW_ID " ).append("\n"); 
		query.append("	  , SIH.INV_SEQ                         AS INV_SEQ" ).append("\n"); 
		query.append("	  , SIH.INV_NO                          AS INV_NO" ).append("\n"); 
		query.append("	  , SID.DTRB_LINE_NO                    AS DTRB_LINE_NO" ).append("\n"); 
		query.append("	  , NVL(SIH.ATTR_CTNT5, SIH.ATTR_CTNT2) AS ASA_NO" ).append("\n"); 
		query.append("	  , SIH.INV_CURR_CD                     AS INV_CURR_CD" ).append("\n"); 
		query.append("	  , SIH.OFC_CD                          AS AP_OFFICE_CODE" ).append("\n"); 
		query.append("	  , SIH.LIAB_CD_CMB_SEQ                 AS LIAB_CD_CMB_SEQ" ).append("\n"); 
		query.append("	  , MO.OFC_CD                           AS ASA_OFFICE_CODE" ).append("\n"); 
		query.append("	  , SAM.AGN_CD                          AS ASA_AGENT_CODE" ).append("\n"); 
		query.append("	  , SAM.ASA_PRD_TO_DT                   AS ASA_PERIOD_TO" ).append("\n"); 
		query.append("	  , MO.REP_CUST_CNT_CD                  AS ASA_CUST_CNT_CD" ).append("\n"); 
		query.append("	  , MO.REP_CUST_SEQ                     AS ASA_CUST_SEQ" ).append("\n"); 
		query.append("	  , NVL(MO.ASA_CR_TERM_DYS,0)           AS ASA_CREDIT_TERM" ).append("\n"); 
		query.append("	  , SAM.CURR_CD                         AS ASA_CURRENCY_CODE" ).append("\n"); 
		query.append("	  , MO.LOC_CD                           AS ASA_LOCATION_CODE" ).append("\n"); 
		query.append("	  , MO.AR_HD_QTR_OFC_CD                 AS ASA_AR_HQ_OFFICE" ).append("\n"); 
		query.append("	  , SID.INV_DTRB_SEQ                    AS INV_DTRB_SEQ" ).append("\n"); 
		query.append("	  , SID.DTRB_AMT                        AS DTRB_AMT" ).append("\n"); 
		query.append("	  , SID.ACCTG_DT                        AS ACCOUNTING_DATE" ).append("\n"); 
		query.append("	  , SID.DTRB_CD_CMB_SEQ                 AS DTRB_CD_CMB_SEQ" ).append("\n"); 
		query.append("	  , SIH.AP_INV_SRC_CD                   AS SOURCE_CODE" ).append("\n"); 
		query.append("	  , MO.FINC_RGN_CD                      AS FINANCE_REGION_CD" ).append("\n"); 
		query.append("	  , MO.GL_CTR_CD                        AS GL_CENTER_CD" ).append("\n"); 
		query.append("	  , MO.AR_CURR_CD                       AS AR_CURR_CD" ).append("\n"); 
		query.append("	  , DECODE(SIH.AP_INV_SRC_CD, 'COMMISSION', 'ACM', 'AEP') AS ASA_EXPENSE_TYPE" ).append("\n"); 
		query.append("	  , (SELECT  ACCT_TP_CD FROM SAR_ACCT_MTX WHERE ACCT_CTNT1 ='REC' AND ACCT_CTNT2 ='STM AP' AND ACCT_CTNT3 ='AGENT' AND ROWNUM = 1) AS REP_TP_SRC_CD" ).append("\n"); 
		query.append("	  , (SELECT  ACCT_TP_CD FROM SAR_ACCT_MTX WHERE ACCT_CTNT1 ='REV' AND ACCT_CTNT2 ='STM AP' AND ACCT_CTNT3 = 'AGENT'" ).append("\n"); 
		query.append("	     AND ACCT_CTNT4 = 'ASA' AND ACCT_TP_CD = DECODE(SIH.AP_INV_SRC_CD, 'COMMISSION', 'ACM', 'AEP') AND ROWNUM = 1) AS CHG_TP_CD" ).append("\n"); 
		query.append("	  , TO_CHAR((TO_DATE(SAM.ASA_PRD_TO_DT, 'YYYYMMDD') + NVL(MO.ASA_CR_TERM_DYS, 0)), 'YYYYMMDD') AS DUE_DATE" ).append("\n"); 
		query.append("	  , 'O' AS BKG_IO_FLAG" ).append("\n"); 
		query.append("	  , 'SAP' || TO_CHAR(SYSDATE,'YYMMDD') || LPAD(SAR_OTS_IF_NO_SEQ.NEXTVAL, 4, '0') AS IF_NO" ).append("\n"); 
		query.append("	  , 'ASA'                               AS REV_TP_SRC_CD" ).append("\n"); 
		query.append("	  , SIH.UPD_USR_ID AS USR_ID" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("	  , SAP_INV_DTL SID" ).append("\n"); 
		query.append("	  , SAR_ASA_MST SAM" ).append("\n"); 
		query.append("	  , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("	  , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("WHERE   SIH.INV_SEQ = SID.INV_SEQ " ).append("\n"); 
		query.append("AND     SIH.ATTR_CATE_NM = 'INVOICES'" ).append("\n"); 
		query.append("AND     NVL(SIH.ATTR_CTNT5, SIH.ATTR_CTNT2) = SAM.ASA_NO" ).append("\n"); 
		query.append("AND     SAM.OFC_CD = MO.OFC_CD " ).append("\n"); 
		query.append("AND     SAM.ASA_FSH_DT IS NULL" ).append("\n"); 
		query.append("AND     SAM.CURR_CD = SIH.INV_CURR_CD" ).append("\n"); 
		query.append("AND     SIH.INV_AMT = 0" ).append("\n"); 
		query.append("AND     SID.DTRB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("AND     SLCC.SGM_CTNT4  = ( SELECT SLD.LU_CD " ).append("\n"); 
		query.append("				            FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD " ).append("\n"); 
		query.append("				            WHERE SLH.LU_APPL_CD = 'SAP' " ).append("\n"); 
		query.append("				            AND SLH.LU_TP_CD = 'ASA CLEARING ACCOUNT' " ).append("\n"); 
		query.append("				            AND SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("				            AND SLD.ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("				            AND ROWNUM = 1 )  " ).append("\n"); 
		query.append("AND     SID.ATTR_CTNT13 IS NULL" ).append("\n"); 
		query.append("#if (${inv_no} != '') " ).append("\n"); 
		query.append("AND     SIH.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}