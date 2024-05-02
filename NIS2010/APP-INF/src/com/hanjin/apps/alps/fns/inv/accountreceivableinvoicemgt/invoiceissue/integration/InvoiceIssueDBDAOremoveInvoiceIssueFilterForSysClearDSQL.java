/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueDBDAOremoveInvoiceIssueFilterForSysClearDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOremoveInvoiceIssueFilterForSysClearDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sys Clear 동작으로 먼저 Issue가 된 대상을 Filter 정보에서 삭제하여 ERP 전송을 방지한다.
	  * </pre>
	  */
	public InvoiceIssueDBDAOremoveInvoiceIssueFilterForSysClearDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOremoveInvoiceIssueFilterForSysClearDSQL").append("\n"); 
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
		query.append("DELETE FROM INV_AR_ISS_FTR T" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   AR_IF_NO IN (" ).append("\n"); 
		query.append("SELECT T.AR_IF_NO" ).append("\n"); 
		query.append("FROM   INV_AR_MN S" ).append("\n"); 
		query.append("WHERE  S.AR_IF_NO       = T.AR_IF_NO" ).append("\n"); 
		query.append("AND    S.INV_CLR_FLG    = 'Y'" ).append("\n"); 
		query.append("AND    T.INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append("GROUP BY T.AR_IF_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}