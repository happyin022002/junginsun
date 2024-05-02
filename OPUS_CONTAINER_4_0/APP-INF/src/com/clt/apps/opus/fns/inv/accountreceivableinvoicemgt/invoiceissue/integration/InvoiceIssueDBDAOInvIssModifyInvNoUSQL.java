/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueDBDAOInvIssModifyInvNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.03.24 한동훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOInvIssModifyInvNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIssModifyInvNo
	  * </pre>
	  */
	public InvoiceIssueDBDAOInvIssModifyInvNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOInvIssModifyInvNoUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_ISS_NO" ).append("\n"); 
		query.append("   SET INV_MAX_SEQ = INV_MAX_SEQ+TO_NUMBER(@[inv_seq])" ).append("\n"); 
		query.append("     , UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("     , UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE INV_PFX_CD = @[inv_pfx_cd]" ).append("\n"); 

	}
}