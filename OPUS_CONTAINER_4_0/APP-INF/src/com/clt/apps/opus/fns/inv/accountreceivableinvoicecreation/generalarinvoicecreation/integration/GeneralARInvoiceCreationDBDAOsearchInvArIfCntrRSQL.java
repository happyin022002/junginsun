/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchInvArIfCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.10
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.03.10 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOsearchInvArIfCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOsearchInvArIfCntrRSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchInvArIfCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchInvArIfCntrRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("I.SRC_IF_DT, I.SRC_IF_SEQ, I.CNTR_SEQ, " ).append("\n"); 
		query.append("   I.CNTR_NO, I.CNTR_TPSZ_CD, I.CRE_USR_ID, " ).append("\n"); 
		query.append("   I.CRE_DT, I.UPD_USR_ID, I.UPD_DT" ).append("\n"); 
		query.append("FROM INV_AR_IF_CNTR I" ).append("\n"); 
		query.append("WHERE SRC_IF_DT = @[src_if_dt]" ).append("\n"); 
		query.append("  AND SRC_IF_SEQ = @[src_if_seq]" ).append("\n"); 

	}
}