/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharteIOContractDAOSearchContractByInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.29 정윤태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGYOONTAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharteIOContractDAOSearchContractByInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharteIOContractDAOSearchContractByInvoiceRSQL
	  * </pre>
	  */
	public TCharteIOContractDAOSearchContractByInvoiceRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharteIOContractDAOSearchContractByInvoiceRSQL").append("\n"); 
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
		query.append("SELECT  FLET_CTRT_NO," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("VSL_ENG_NM," ).append("\n"); 
		query.append("FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("CUST_CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("OWNR_NM," ).append("\n"); 
		query.append("ACMM_RT_AMT," ).append("\n"); 
		query.append("FLET_BROG_RT_AMT," ).append("\n"); 
		query.append("ACMM_FLG," ).append("\n"); 
		query.append("BROG_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  FC.FLET_CTRT_NO," ).append("\n"); 
		query.append("FC.VSL_CD," ).append("\n"); 
		query.append("(SELECT VSL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE VSL_CD = FC.VSL_CD" ).append("\n"); 
		query.append("AND ROWNUM =1) VSL_ENG_NM," ).append("\n"); 
		query.append("DECODE(FC.FLET_CTRT_TP_CD,'TI','T/C In','TO','T/C Out','OW','Ownership') FLET_CTRT_TP_CD," ).append("\n"); 
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
		query.append("TO_CHAR(FC.ACMM_RT_AMT,'FM990.00') ACMM_RT_AMT," ).append("\n"); 
		query.append("TO_CHAR(FC.FLET_BROG_RT_AMT,'FM990.00') FLET_BROG_RT_AMT," ).append("\n"); 
		query.append("DECODE(FC.ACMM_RT_AMT,NULL,'N','Y') ACMM_FLG," ).append("\n"); 
		query.append("DECODE(FC.FLET_BROG_RT_AMT,NULL,'N','Y') BROG_FLG" ).append("\n"); 
		query.append("FROM  FMS_CONTRACT FC" ).append("\n"); 
		query.append("WHERE  FC.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND  ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}