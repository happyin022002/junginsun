/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSRemarkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.10.16 문중철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mun Jung Cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchOTSRemarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE 생성 및 징수관리
	  * EES_DMT_4105
	  * Remark(s)
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchOTSRemarkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSRemarkRSQL").append("\n"); 
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
		query.append("DMDT_PAYR_OTS_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DMT_PAYR_INFO" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CUST_CNT_CD     =   DECODE(LENGTH(@[invno]), 8, NVL(SUBSTR(@[invno], 1, 2), CUST_CNT_CD), 6, CUST_CNT_CD, CUST_CNT_CD)" ).append("\n"); 
		query.append("AND     CUST_SEQ        =   DECODE(LENGTH(@[invno]), 8, NVL(SUBSTR(@[invno], 3, 6), CUST_SEQ), 6, @[invno], CUST_SEQ)" ).append("\n"); 

	}
}