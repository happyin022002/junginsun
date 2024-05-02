/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOCheckManualARIFAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.19 
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

public class InvoiceIssueCollectionMgtDBDAOCheckManualARIFAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manual Invoice의 BIL_AMT - INV_CHG_AMT 값을 조회 한다.
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOCheckManualARIFAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOCheckManualARIFAmtRSQL").append("\n"); 
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
		query.append("SELECT INV_CURR_CD" ).append("\n"); 
		query.append("     , NVL(CASE" ).append("\n"); 
		query.append("             WHEN INV_CURR_CD IN ( 'KRW','JPY','BEF','DJF','ESP','GRD','ITL','LAK','MGF','MRO','MXP','PTE','SDD','MXN' ) THEN TRUNC( BIL_AMT*DECODE(INV_XCH_RT,-1,1,INV_XCH_RT), 0)" ).append("\n"); 
		query.append("             WHEN INV_CURR_CD IN ( 'TWD','IDR','VND' ) THEN ROUND( BIL_AMT*DECODE(INV_XCH_RT,-1,1,INV_XCH_RT), 0)" ).append("\n"); 
		query.append("             ELSE ROUND( BIL_AMT*DECODE(INV_XCH_RT,-1,1,INV_XCH_RT), 2)" ).append("\n"); 
		query.append("           END - INV_CHG_AMT, 0) AS M_AMT" ).append("\n"); 
		query.append("  FROM DMT_INV_MN" ).append("\n"); 
		query.append(" WHERE DMDT_INV_NO = @[invoice_no]" ).append("\n"); 
		query.append("   AND CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 

	}
}