/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOSearchMultiOfficeCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOSearchMultiOfficeCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * inquiry multi office code
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOSearchMultiOfficeCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration ").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOSearchMultiOfficeCodeListRSQL").append("\n"); 
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
		query.append("    A.OFC_CD" ).append("\n"); 
		query.append("  , A.OFC_BRNC_AGN_TP_CD" ).append("\n"); 
		query.append("FROM SCO_OFC_INFO A" ).append("\n"); 

	}
}