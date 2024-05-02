/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueDBDAOremoveInvArIssForSysClearDSQL.java
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

public class InvoiceIssueDBDAOremoveInvArIssForSysClearDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Issue 동작 중에 Sys Clear 동작이 발생한  Issue 정보를 삭제한다.
	  * </pre>
	  */
	public InvoiceIssueDBDAOremoveInvArIssForSysClearDSQL(){
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
		query.append("FileName : InvoiceIssueDBDAOremoveInvArIssForSysClearDSQL").append("\n"); 
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
		query.append("MERGE INTO INV_AR_ISS T" ).append("\n"); 
		query.append("USING   (" ).append("\n"); 
		query.append("SELECT  INV_NO       -- 삭제 대상 Invoice 정보" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  T12.INV_NO, INV_IN_DEL_IF_CNT, COUNT(DISTINCT T12.AR_IF_NO) AS INV_IN_TTL_IF_CNT --Invoice 내에 포함된 있는 전체 A/R IF 갯수" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT T02.INV_NO, COUNT(DISTINCT T01.AR_IF_NO) AS INV_IN_DEL_IF_CNT             --Invoice 내에 포함된 Rollback 대상 A/R IF 갯수" ).append("\n"); 
		query.append("FROM   INV_AR_MN        T01" ).append("\n"); 
		query.append(", INV_AR_ISS_DTL T02" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    T01.AR_IF_NO     = T02.AR_IF_NO" ).append("\n"); 
		query.append("AND    T01.INV_CLR_FLG  = 'Y'" ).append("\n"); 
		query.append("AND    T01.AR_IF_NO IN (" ).append("\n"); 
		query.append("SELECT AR_IF_NO" ).append("\n"); 
		query.append("FROM   INV_AR_ISS_FTR" ).append("\n"); 
		query.append("WHERE  INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append("GROUP BY AR_IF_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY T02.INV_NO" ).append("\n"); 
		query.append(") T11, INV_AR_ISS_DTL T12" ).append("\n"); 
		query.append("WHERE   T11.INV_NO  = T12.INV_NO" ).append("\n"); 
		query.append("GROUP BY T12.INV_NO, INV_IN_DEL_IF_CNT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE  INV_IN_TTL_IF_CNT = INV_IN_DEL_IF_CNT    -- Invoice 내에 포함되여 있는 전체 A/F IF 개수와 Invocie 내 Sys Clear 갯수가 동일할 경우 삭제 대상이 됨" ).append("\n"); 
		query.append(") S" ).append("\n"); 
		query.append("ON      (T.INV_NO = S.INV_NO)" ).append("\n"); 
		query.append("WHEN MATCHED THEN UPDATE SET INV_ISS_RMK = 'DELETE'" ).append("\n"); 
		query.append("DELETE WHERE (T.INV_NO = S.INV_NO)" ).append("\n"); 

	}
}