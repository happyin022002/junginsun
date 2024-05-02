/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonCodeDBDAOSearchGetTesBillingCaseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchGetTesBillingCaseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchGetTesBillingCase
	  * </pre>
	  */
	public CommonCodeDBDAOSearchGetTesBillingCaseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchGetTesBillingCaseRSQL").append("\n"); 
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
		query.append("SELECT TPB_GET_N3PTY_BIL_TP_NM_FNC(N3PTY_BIL_TP_CD) AS V_TPB_CD," ).append("\n"); 
		query.append("       N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("  FROM TPB_N3RD_PTY_BIL_TP" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND N3PTY_BIL_TP_CD != 'JO'" ).append("\n"); 
		query.append("   AND ACT_FLG ='Y'" ).append("\n"); 
		query.append("   AND N3PTY_EXPN_TP_CD = 'TES'" ).append("\n"); 
		query.append("   AND N3PTY_IF_TP_CD <> 'R'    " ).append("\n"); 
		query.append(" ORDER BY N3PTY_BIL_TP_CD " ).append("\n"); 

	}
}