/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchIndiaGstRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.03.19 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchIndiaGstRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 인도 GST 관련 Tax 율
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchIndiaGstRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchIndiaGstRateRSQL").append("\n"); 
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
		query.append("SELECT /*+INDEX_DESC( A XPKTPB_IDA_TAX )+*/" ).append("\n"); 
		query.append("       A.EXPN_TAX  AS IDA_EXPN_TAX_RT," ).append("\n"); 
		query.append("       A.EDU_TAX   AS IDA_EDU_TAX_RT, " ).append("\n"); 
		query.append("       A.HIGH_EDU_TAX AS IDA_HIGH_EDU_TAX_RT," ).append("\n"); 
		query.append("       A.TAX_RGST_NO, A.SVC_CATE_RMK, A.PMNT_ACCT_NO" ).append("\n"); 
		query.append("FROM   TPB_IDA_TAX A" ).append("\n"); 
		query.append("WHERE  A.EFF_DT <= NVL(TO_DATE(@[iss_dt],'YYYYMMDD'), SYSDATE)" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}