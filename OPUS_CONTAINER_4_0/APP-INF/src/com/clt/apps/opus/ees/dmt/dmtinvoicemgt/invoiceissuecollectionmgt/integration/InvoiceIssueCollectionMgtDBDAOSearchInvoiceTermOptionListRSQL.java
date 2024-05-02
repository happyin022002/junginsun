/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceTermOptionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchInvoiceTermOptionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Code 와 Tariff Type 으로 Credit Term 을 조회하는 쿼리
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchInvoiceTermOptionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issue_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceTermOptionListRSQL").append("\n"); 
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
		query.append("SELECT	CASE" ).append("\n"); 
		query.append("WHEN TERM_OPT.CR_TERM_DYS = 0 AND TERM_OPT.ISS_DT_PRN_FLG = 'Y' THEN TO_CHAR(TO_DATE(NVL(@[issue_dt], SYSDATE), 'YYYY-MM-DD'), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("WHEN TERM_OPT.CR_TERM_DYS = 0 AND TERM_OPT.ISS_DT_PRN_FLG = 'N' THEN '*******'" ).append("\n"); 
		query.append("WHEN TERM_OPT.CR_TERM_DYS > 0 THEN TO_CHAR(TO_DATE(NVL(@[issue_dt], SYSDATE), 'YYYY-MM-DD') + TERM_OPT.CR_TERM_DYS, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("END DUE_DT" ).append("\n"); 
		query.append(",	CASE" ).append("\n"); 
		query.append("WHEN TERM_OPT.ISS_DT_PRN_FLG = 'Y' THEN TO_CHAR(TERM_OPT.CR_TERM_DYS)" ).append("\n"); 
		query.append("WHEN TERM_OPT.ISS_DT_PRN_FLG = 'N' THEN ''" ).append("\n"); 
		query.append("END CR_TERM_DYS" ).append("\n"); 
		query.append(",	SH_OPT.DFLT_TAX_RTO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_CR_TERM_OPT TERM_OPT" ).append("\n"); 
		query.append(", 	DMT_CR_TERM_TRF_OPT TERM_TRF_OPT" ).append("\n"); 
		query.append(", 	DMT_OFC_SH_OPT SH_OPT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	TERM_OPT.OFC_CD 			= @[ofc_cd]" ).append("\n"); 
		query.append("AND	TERM_OPT.OFC_CD 			= TERM_TRF_OPT.OFC_CD" ).append("\n"); 
		query.append("AND TERM_OPT.CR_TERM_SEQ 		= TERM_TRF_OPT.CR_TERM_SEQ" ).append("\n"); 
		query.append("AND TERM_TRF_OPT.DMDT_TRF_CD 	= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND TERM_OPT.OFC_CD 			= SH_OPT.OFC_CD(+)" ).append("\n"); 

	}
}