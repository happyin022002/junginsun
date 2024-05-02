/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueDBDAOremoveInvArIssDtlForSysClearDSQL.java
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

public class InvoiceIssueDBDAOremoveInvArIssDtlForSysClearDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Issue 동작 중에 Sys Clear 동작이 발생한 Detail 정보를 삭제한다.
	  * </pre>
	  */
	public InvoiceIssueDBDAOremoveInvArIssDtlForSysClearDSQL(){
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
		query.append("FileName : InvoiceIssueDBDAOremoveInvArIssDtlForSysClearDSQL").append("\n"); 
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
		query.append("MERGE INTO INV_AR_ISS_DTL T" ).append("\n"); 
		query.append("USING   (" ).append("\n"); 
		query.append("SELECT T1.AR_IF_NO AS AR_IF_NO" ).append("\n"); 
		query.append("FROM   INV_AR_MN T1, INV_AR_ISS_FTR T2" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    T1.AR_IF_NO          = T2.AR_IF_NO" ).append("\n"); 
		query.append("AND    T1.INV_CLR_FLG       = 'Y'" ).append("\n"); 
		query.append("AND    T2.INV_ISS_WRK_NO    = @[wrk_no]" ).append("\n"); 
		query.append("GROUP BY T1.AR_IF_NO" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append("ON      (T.AR_IF_NO = S.AR_IF_NO)" ).append("\n"); 
		query.append("WHEN MATCHED THEN UPDATE SET UPD_USR_ID = 'DELETE'" ).append("\n"); 
		query.append("DELETE WHERE (T.AR_IF_NO = S.AR_IF_NO)" ).append("\n"); 

	}
}