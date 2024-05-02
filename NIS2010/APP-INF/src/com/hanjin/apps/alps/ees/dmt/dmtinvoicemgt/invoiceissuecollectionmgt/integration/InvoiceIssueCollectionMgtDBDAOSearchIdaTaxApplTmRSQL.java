/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchIdaTaxApplTmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.02 
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

public class InvoiceIssueCollectionMgtDBDAOSearchIdaTaxApplTmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchIdaTaxApplTmRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchIdaTaxApplTmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchIdaTaxApplTmRSQL").append("\n"); 
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
		query.append("SELECT  CASE" ).append("\n"); 
		query.append("			--// INVOICE 생성 전" ).append("\n"); 
		query.append("			WHEN @[dmdt_inv_no] IS NULL THEN" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("				CASE" ).append("\n"); 
		query.append("					WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDDHH24MI'), 'YYYYMMDDHH24MI') - TO_DATE(ATTR_CTNT1, 'YYYYMMDDHH24MI') > 0 " ).append("\n"); 
		query.append("						THEN 'A' " ).append("\n"); 
		query.append("						ELSE 'B' " ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			--// CREDIT INVOICE 인 경우 원본 INVOICE 의 생성일자를 기준으로 구한다." ).append("\n"); 
		query.append("			WHEN (" ).append("\n"); 
		query.append("					SELECT  DMDT_INV_STS_CD" ).append("\n"); 
		query.append("					  FROM  DMT_INV_MN" ).append("\n"); 
		query.append("					 WHERE  DMDT_INV_NO = @[dmdt_inv_no]" ).append("\n"); 
		query.append("				 ) = 'C' THEN" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					SELECT  CASE" ).append("\n"); 
		query.append("								WHEN TO_DATE(TO_CHAR(T1.CRE_DT, 'YYYYMMDDHH24MI'), 'YYYYMMDDHH24MI') - TO_DATE(ATTR_CTNT1, 'YYYYMMDDHH24MI') > 0" ).append("\n"); 
		query.append("									THEN 'A'" ).append("\n"); 
		query.append("								ELSE 'B'" ).append("\n"); 
		query.append("							END" ).append("\n"); 
		query.append("					  FROM  DMT_INV_MN T1" ).append("\n"); 
		query.append("					 WHERE  T1.DMDT_INV_NO = " ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								SELECT  CR_INV_NO" ).append("\n"); 
		query.append("								  FROM  DMT_INV_MN" ).append("\n"); 
		query.append("								 WHERE  DMDT_INV_NO = @[dmdt_inv_no]" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			--// INVOICE 인 경우 생성일자를 기준으로 구한다.				" ).append("\n"); 
		query.append("			ELSE" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					SELECT  CASE" ).append("\n"); 
		query.append("								WHEN TO_DATE(TO_CHAR(T1.CRE_DT, 'YYYYMMDDHH24MI'), 'YYYYMMDDHH24MI') - TO_DATE(ATTR_CTNT1, 'YYYYMMDDHH24MI') > 0" ).append("\n"); 
		query.append("									THEN 'A'" ).append("\n"); 
		query.append("								ELSE 'B'" ).append("\n"); 
		query.append("							END" ).append("\n"); 
		query.append("					  FROM  DMT_INV_MN 			T1" ).append("\n"); 
		query.append("					 WHERE  T1.DMDT_INV_NO = @[dmdt_inv_no]" ).append("\n"); 
		query.append("				)			" ).append("\n"); 
		query.append("		END AS IDA_TAX_APPL_TM" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  FROM  DMT_HRD_CDG_CTNT" ).append("\n"); 
		query.append(" WHERE  HRD_CDG_ID = 'IDA_TAX_APPL_DT'" ).append("\n"); 

	}
}