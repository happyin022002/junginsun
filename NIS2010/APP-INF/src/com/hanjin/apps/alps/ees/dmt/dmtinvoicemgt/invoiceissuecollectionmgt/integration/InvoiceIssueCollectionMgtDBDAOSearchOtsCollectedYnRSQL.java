/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchOtsCollectedYnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.01 
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

public class InvoiceIssueCollectionMgtDBDAOSearchOtsCollectedYnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchOtsCollectedYnRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchOtsCollectedYnRSQL(){
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
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchOtsCollectedYnRSQL").append("\n"); 
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
		query.append("select  case " ).append("\n"); 
		query.append("            when max(T1.INV_AMT) <= sum(decode(T2.DMDT_INV_PAY_TP_CD, 'V', T2.INV_PAY_AMT * decode(T2.INV_CURR_CD, T1.INV_CURR_CD, 1, T1.INV_XCH_RT),0)) +" ).append("\n"); 
		query.append("                                    sum(decode(T2.DMDT_INV_PAY_TP_CD, 'M', T2.INV_PAY_AMT * decode(T2.INV_CURR_CD, T1.INV_CURR_CD, 1, T1.INV_XCH_RT),0)) " ).append("\n"); 
		query.append("                then 'Y' " ).append("\n"); 
		query.append("            else 'N' " ).append("\n"); 
		query.append("        end" ).append("\n"); 
		query.append("  from  DMT_INV_MN  			T1" ).append("\n"); 
		query.append("       ,DMT_INV_OTS_PAY_RCV 	T2 " ).append("\n"); 
		query.append(" where  T1.DMDT_INV_NO = @[dmdt_inv_no]" ).append("\n"); 
		query.append("   and  T1.DMDT_INV_NO = T2.DMDT_INV_NO" ).append("\n"); 
		query.append("group by T1.DMDT_INV_NO" ).append("\n"); 

	}
}