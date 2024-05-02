/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BRKGAuditDBDAOSearchBRKGInfoForPrint2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOSearchBRKGInfoForPrint2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_0018 화면에 대한 보고서 출력
	  * </pre>
	  */
	public BRKGAuditDBDAOSearchBRKGInfoForPrint2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_csrno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOSearchBRKGInfoForPrint2RSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("ROWNUM DTL_SEQ," ).append("\n"); 
		query.append("DTL_CHT_ACCT," ).append("\n"); 
		query.append("DTL_ACCT_NM," ).append("\n"); 
		query.append("DTL_GL_DT," ).append("\n"); 
		query.append("DTL_CITY," ).append("\n"); 
		query.append("DTL_INV_NO," ).append("\n"); 
		query.append("REPLACE(DTL_DESC,'&','&amp;') AS DTL_DESC," ).append("\n"); 
		query.append("DTL_DEBIT," ).append("\n"); 
		query.append("DTL_CREDIT" ).append("\n"); 
		query.append("FROM (SELECT" ).append("\n"); 
		query.append("DECODE(A.DTRB_COA_ACCT_CD,'111821',2,1) AS NO," ).append("\n"); 
		query.append("A.DTRB_COA_CO_CD||'.'||A.DTRB_COA_RGN_CD||'.'||A.DTRB_COA_CTR_CD||'.'||A.DTRB_COA_ACCT_CD||'.'||A.DTRB_COA_INTER_CO_CD||'.'||A.DTRB_COA_VVD_CD AS DTL_CHT_ACCT," ).append("\n"); 
		query.append("(SELECT ACCT_ENG_NM FROM MDM_ACCOUNT WHERE ACCT_CD = A.DTRB_COA_ACCT_CD) AS DTL_ACCT_NM," ).append("\n"); 
		query.append("(SELECT TO_CHAR(TO_DATE(GL_DT,'YYYYMMDD'),'YYYY/MM/DD') FROM AP_INV_HDR WHERE CSR_NO = A.CSR_NO) AS DTL_GL_DT," ).append("\n"); 
		query.append("A.ATTR_CTNT3            AS DTL_CITY," ).append("\n"); 
		query.append("A.ATTR_CTNT1            AS DTL_INV_NO," ).append("\n"); 
		query.append("'BROKERAGE/'||A.BKG_NO AS DTL_DESC," ).append("\n"); 
		query.append("SUM(ROUND(A.INV_AMT,2)) AS DTL_DEBIT," ).append("\n"); 
		query.append("NULL                    AS DTL_CREDIT" ).append("\n"); 
		query.append("FROM AP_INV_DTRB A" ).append("\n"); 
		query.append("WHERE A.CSR_NO = @[h_csrno]" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("DECODE(A.DTRB_COA_ACCT_CD,'111821',2,1)," ).append("\n"); 
		query.append("A.DTRB_COA_CO_CD||'.'||A.DTRB_COA_RGN_CD||'.'||A.DTRB_COA_CTR_CD||'.'||A.DTRB_COA_ACCT_CD||'.'||A.DTRB_COA_INTER_CO_CD||'.'||A.DTRB_COA_VVD_CD," ).append("\n"); 
		query.append("A.DTRB_COA_ACCT_CD," ).append("\n"); 
		query.append("A.CSR_NO," ).append("\n"); 
		query.append("A.ATTR_CTNT3," ).append("\n"); 
		query.append("A.ATTR_CTNT1," ).append("\n"); 
		query.append("'BROKERAGE/'||A.BKG_NO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("9 AS NO," ).append("\n"); 
		query.append("A.COA_CO_CD||'.'||A.COA_RGN_CD||'.'||A.COA_CTR_CD||'.'||A.COA_ACCT_CD||'.'||A.COA_INTER_CO_CD||'.'||A.COA_VVD_CD AS DTL_CHT_ACCT," ).append("\n"); 
		query.append("(	SELECT" ).append("\n"); 
		query.append("ACCT_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_ACCOUNT" ).append("\n"); 
		query.append("WHERE ACCT_CD = A.COA_ACCT_CD" ).append("\n"); 
		query.append(") AS DTL_ACCT_NM," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(GL_DT,'YYYYMMDD'),'YYYY/MM/DD') AS DTL_GL_DT," ).append("\n"); 
		query.append("NULL                   AS DTL_CITY," ).append("\n"); 
		query.append("NULL                   AS DTL_INV_NO," ).append("\n"); 
		query.append("A.INV_DESC             AS DTL_DESC," ).append("\n"); 
		query.append("NULL                   AS DTL_DEBIT," ).append("\n"); 
		query.append("ROUND(A.CSR_AMT,2)     AS DTL_CREDIT" ).append("\n"); 
		query.append("FROM AP_INV_HDR A" ).append("\n"); 
		query.append("WHERE A.CSR_NO = @[h_csrno]" ).append("\n"); 
		query.append("ORDER BY NO ASC, DTL_CHT_ACCT ASC" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}