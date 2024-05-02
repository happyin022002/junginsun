/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchPreviewDTRBListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 김진
*@LastVersion : 1.0
* 2009.08.20 김진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOSearchPreviewDTRBListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR DTRB 내역을 조회
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOSearchPreviewDTRBListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration ").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOSearchPreviewDTRBListRSQL").append("\n"); 
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
		query.append("SELECT 		CHART_OF_ACCOUNT 										PRE_CHART_OF_ACCOUNT" ).append("\n"); 
		query.append(",	ACCOUNT_NAME 										PRE_ACCOUNT_NAME" ).append("\n"); 
		query.append(",	TO_CHAR(TO_DATE(GL_DATE,'YYYYMMDD'),'YYYY/MM/DD') 	PRE_GL_DATE" ).append("\n"); 
		query.append(",	CITY PRE_CITY" ).append("\n"); 
		query.append(",	INVOICE_NO 											PRE_INV_NO" ).append("\n"); 
		query.append(",	DESCRIPTION 										PRE_DESC" ).append("\n"); 
		query.append(",	DEBIT 												PRE_DEBIT" ).append("\n"); 
		query.append(",	CREDIT 												PRE_CREDIT" ).append("\n"); 
		query.append("FROM 		(" ).append("\n"); 
		query.append("SELECT 		CHART_OF_ACCOUNT" ).append("\n"); 
		query.append(",	ACCOUNT_NAME" ).append("\n"); 
		query.append(",	GL_DATE" ).append("\n"); 
		query.append(",	CITY" ).append("\n"); 
		query.append(",	INVOICE_NO" ).append("\n"); 
		query.append(",	DESCRIPTION" ).append("\n"); 
		query.append(",	DEBIT" ).append("\n"); 
		query.append(",	CREDIT" ).append("\n"); 
		query.append("FROM		(" ).append("\n"); 
		query.append("SELECT 		D.DTRB_COA_CO_CD||'.'||D.DTRB_COA_RGN_CD||'.'||D.DTRB_COA_CTR_CD||'.'||D.DTRB_COA_ACCT_CD||'.'||D.DTRB_COA_INTER_CO_CD||'.'||D.DTRB_COA_VVD_CD CHART_OF_ACCOUNT" ).append("\n"); 
		query.append(",	(SELECT ACCT_ENG_NM FROM  MDM_ACCOUNT WHERE ACCT_CD = D.DTRB_COA_ACCT_CD) 	ACCOUNT_NAME" ).append("\n"); 
		query.append(",	H.GL_DT 																	GL_DATE" ).append("\n"); 
		query.append(",	D.ATTR_CTNT3 																CITY" ).append("\n"); 
		query.append(",	D.ATTR_CTNT1 																INVOICE_NO" ).append("\n"); 
		query.append(",	D.INV_DESC 																	DESCRIPTION" ).append("\n"); 
		query.append(",	SUM( ROUND(D.INV_AMT,2) ) 													DEBIT" ).append("\n"); 
		query.append(",	0 																			CREDIT" ).append("\n"); 
		query.append(",	D.LINE_NO 																	NO" ).append("\n"); 
		query.append("FROM   		AP_INV_HDR 		H" ).append("\n"); 
		query.append(",	AP_INV_DTRB 	D" ).append("\n"); 
		query.append("WHERE  		H.CSR_NO = @[CSR_NO]" ).append("\n"); 
		query.append("AND H.CSR_NO = D.CSR_NO" ).append("\n"); 
		query.append("GROUP BY 	D.DTRB_COA_CO_CD" ).append("\n"); 
		query.append(",	D.DTRB_COA_RGN_CD" ).append("\n"); 
		query.append(",	D.DTRB_COA_CTR_CD" ).append("\n"); 
		query.append(",	D.DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append(",	D.DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append(",	D.DTRB_COA_VVD_CD" ).append("\n"); 
		query.append(",	D.INV_DESC" ).append("\n"); 
		query.append(",	H.GL_DT" ).append("\n"); 
		query.append(",	D.ATTR_CTNT3" ).append("\n"); 
		query.append(",	D.ATTR_CTNT1" ).append("\n"); 
		query.append(",	D.LINE_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY 	INVOICE_NO	ASC" ).append("\n"); 
		query.append(",	NO 			ASC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 		COA_CO_CD||'.'||COA_RGN_CD||'.'||COA_CTR_CD||'.'||COA_ACCT_CD||'.'||COA_INTER_CO_CD||'.'||COA_VVD_CD CHART_OF_ACCOUNT" ).append("\n"); 
		query.append(",	(	SELECT 	ACCT_ENG_NM" ).append("\n"); 
		query.append("FROM   	MDM_ACCOUNT" ).append("\n"); 
		query.append("WHERE  	ACCT_CD = COA_ACCT_CD ) ACCOUNT_NAME" ).append("\n"); 
		query.append(",	TO_CHAR(TO_DATE(GL_DT,'YYYYMMDD'),'YYYY/MM/DD') 	GL_DATE" ).append("\n"); 
		query.append(",	'' 													CITY" ).append("\n"); 
		query.append(",	'' 													INVOICE_NO" ).append("\n"); 
		query.append(",	INV_DESC 											DESCRIPTION" ).append("\n"); 
		query.append(",	0 													DEBIT" ).append("\n"); 
		query.append(",	ROUND(H.CSR_AMT,2)			 						CREDIT" ).append("\n"); 
		query.append("FROM   		AP_INV_HDR H" ).append("\n"); 
		query.append("WHERE  		H.CSR_NO = @[CSR_NO]" ).append("\n"); 

	}
}