/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchARActualPayerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.20 
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

public class InvoiceIssueCollectionMgtDBDAOSearchARActualPayerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation & Issue - Booking
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchARActualPayerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchARActualPayerRSQL").append("\n"); 
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
		query.append("SELECT A.ACT_CUST_CNT_CD||LPAD(A.ACT_CUST_SEQ,6,'0') AS ACT_CUST_CD" ).append("\n"); 
		query.append(", B.CUST_LGL_ENG_NM AS ACT_CUST_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT ACT_CUST_CNT_CD, ACT_CUST_SEQ" ).append("\n"); 
		query.append("FROM INV_AR_MN AR" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND IO_BND_CD = SUBSTR(@[dmdt_trf_cd],3,1)" ).append("\n"); 
		query.append("AND AR_IF_NO = (" ).append("\n"); 
		query.append("SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("FROM INV_AR_MN" ).append("\n"); 
		query.append("WHERE BKG_NO = AR.BKG_NO" ).append("\n"); 
		query.append("AND   IO_BND_CD = SUBSTR(@[dmdt_trf_cd],3,1)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("MDM_CUSTOMER B" ).append("\n"); 
		query.append("WHERE A.ACT_CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.ACT_CUST_SEQ = B.CUST_SEQ" ).append("\n"); 

	}
}