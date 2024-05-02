/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAODualRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAODualRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dual
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAODualRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAODualRSQL").append("\n"); 
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
		query.append("  '' BL_SRC_NO," ).append("\n"); 
		query.append("  '' TTL_AMT," ).append("\n"); 
		query.append("  '' RECEIPT," ).append("\n"); 
		query.append("  '' POD_CD," ).append("\n"); 
		query.append("  '' INV_NO," ).append("\n"); 
		query.append("  '' OFC_CD," ).append("\n"); 
		query.append("  '' ISS_DT," ).append("\n"); 
		query.append("  '' POL_CD," ).append("\n"); 
		query.append("  '' DUE_DT," ).append("\n"); 
		query.append("  '' EDI_SND_FLG," ).append("\n"); 
		query.append("  '' RECEIPT_DT," ).append("\n"); 
		query.append("  '' UPD_USR_ID," ).append("\n"); 
		query.append("  '' EDI_SND_DT," ).append("\n"); 
		query.append("  '' FLT_FILE_REF_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}