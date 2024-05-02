/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchPrepaymentInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.07.10 정윤태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGYOONTAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchPrepaymentInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchPrepaymentInvoiceRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchPrepaymentInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppay_hir_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchPrepaymentInvoiceRSQL").append("\n"); 
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
		query.append("SELECT FI.FLET_CTRT_NO," ).append("\n"); 
		query.append("FC.VSL_CD," ).append("\n"); 
		query.append("(SELECT VSL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE VSL_CD = FC.VSL_CD" ).append("\n"); 
		query.append("AND ROWNUM =1) VSL_ENG_NM," ).append("\n"); 
		query.append("(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01513'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = FC.FLET_CTRT_TP_CD) FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("CASE WHEN FC.FLET_CTRT_TP_CD = 'TO' THEN" ).append("\n"); 
		query.append("(SELECT MV.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MV, FMS_OWNER FO" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = FC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST_SEQ = FC.CUST_SEQ" ).append("\n"); 
		query.append("AND MV.FLET_MGMT_OWNR_CUST_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR MV, FMS_OWNER FO" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = FC.VNDR_SEQ" ).append("\n"); 
		query.append("AND MV.FLET_MGMT_OWNR_VNDR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("END VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("FC.CUST_CNT_CD," ).append("\n"); 
		query.append("DECODE(FC.CUST_SEQ,NULL,FC.VNDR_SEQ,FC.CUST_SEQ) CUST_SEQ," ).append("\n"); 
		query.append("CASE WHEN FC.FLET_CTRT_TP_CD = 'TO' THEN" ).append("\n"); 
		query.append("(SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MV, FMS_OWNER FO" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = FC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST_SEQ = FC.CUST_SEQ" ).append("\n"); 
		query.append("AND MV.FLET_MGMT_OWNR_CUST_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR MV, FMS_OWNER FO" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = FC.VNDR_SEQ" ).append("\n"); 
		query.append("AND MV.FLET_MGMT_OWNR_VNDR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("END OWNR_NM," ).append("\n"); 
		query.append("TO_CHAR(FI.EFF_DT,'YYYY-MM-DD') EFF_DT," ).append("\n"); 
		query.append("TO_CHAR(FI.EFF_DT,'HH24:MI') FROM_TIME," ).append("\n"); 
		query.append("TO_CHAR(FI.EXP_DT,'YYYY-MM-DD') EXP_DT," ).append("\n"); 
		query.append("TO_CHAR(FI.EXP_DT,'HH24:MI') TO_TIME," ).append("\n"); 
		query.append("TO_CHAR(FI.INV_USD_DYS,'FM999,999.0000') INV_USD_DYS," ).append("\n"); 
		query.append("TO_CHAR(FC.ACMM_RT_AMT,'FM990.00') ACMM_RT_AMT," ).append("\n"); 
		query.append("TO_CHAR(FC.FLET_BROG_RT_AMT,'FM990.00') FLET_BROG_RT_AMT," ).append("\n"); 
		query.append("FI.ACMM_FLG," ).append("\n"); 
		query.append("FI.BROG_FLG," ).append("\n"); 
		query.append("FI.INV_SEQ" ).append("\n"); 
		query.append("FROM FMS_INVOICE FI, FMS_CONTRACT FC" ).append("\n"); 
		query.append("WHERE FC.FLET_CTRT_NO   = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND FI.PPAY_HIR_NO    = @[ppay_hir_no]" ).append("\n"); 
		query.append("AND FI.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_NO   = FI.FLET_CTRT_NO" ).append("\n"); 

	}
}