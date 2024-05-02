/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchIndiaFiscalYearRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchIndiaFiscalYearRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchIndiaFiscalYearRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchIndiaFiscalYearRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchIndiaFiscalYearRSQL").append("\n"); 
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
		query.append("SELECT  SUBSTR(CURR_YYYYMM, 3) AS CRNT_YR_MON" ).append("\n"); 
		query.append("       ,CASE " ).append("\n"); 
		query.append("			WHEN CURR_YYYYMM BETWEEN FM_YYYYMM AND TO_YYYYMM THEN SUBSTR(FM_YYYYMM, 1, 4)" ).append("\n"); 
		query.append("			WHEN CURR_YYYYMM < FM_YYYYMM THEN TO_CHAR(TO_DATE(FM_YYYYMM, 'YYYYMM') - (INTERVAL '1' YEAR), 'YYYY')" ).append("\n"); 
		query.append("			WHEN CURR_YYYYMM > TO_YYYYMM THEN SUBSTR(TO_YYYYMM, 1, 4)" ).append("\n"); 
		query.append("		END FSC_YR" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("            SELECT  CURR_YYYYMM" ).append("\n"); 
		query.append("                   ,TO_CHAR(TO_DATE(SUBSTR(CURR_YYYYMM, 1, 4) || '04', 'YYYYMM'), 'YYYYMM') AS FM_YYYYMM" ).append("\n"); 
		query.append("                   ,TO_CHAR(TO_DATE(SUBSTR(CURR_YYYYMM, 1, 4) || '03', 'YYYYMM') + (INTERVAL '1' YEAR), 'YYYYMM') AS TO_YYYYMM" ).append("\n"); 
		query.append("              FROM  (" ).append("\n"); 
		query.append("                        SELECT  TO_CHAR(NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]), SYSDATE), 'YYYYMM') AS CURR_YYYYMM" ).append("\n"); 
		query.append("                          FROM  DUAL" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}