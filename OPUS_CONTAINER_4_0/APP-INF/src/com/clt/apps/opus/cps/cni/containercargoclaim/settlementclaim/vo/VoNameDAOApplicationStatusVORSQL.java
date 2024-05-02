/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VoNameDAOApplicationStatusVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.16
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.02.16 이준범
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoNameDAOApplicationStatusVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Gw Approve 상태 VO
	  * </pre>
	  */
	public VoNameDAOApplicationStatusVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.vo").append("\n"); 
		query.append("FileName : VoNameDAOApplicationStatusVORSQL").append("\n"); 
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
		query.append("    '' CGO_CLM_NO" ).append("\n"); 
		query.append("   ,'' CLM_STL_APPL_DT" ).append("\n"); 
		query.append("   ,'' CLM_STL_APPL_USR_ID" ).append("\n"); 
		query.append("   ,'' CLM_STL_APPL_OFC_CD" ).append("\n"); 
		query.append("   ,'' CLM_STL_AUTH_DT" ).append("\n"); 
		query.append("   ,'' CLM_STL_AUTH_USR_ID" ).append("\n"); 
		query.append("   ,'' CLM_STL_AUTH_OFC_CD" ).append("\n"); 
		query.append("   ,'' CLM_STL_AUTH_CD" ).append("\n"); 
		query.append("   ,'' CLM_STL_AUTH_RMK" ).append("\n"); 
		query.append("   ,'' CLM_STL_AUTH_NO" ).append("\n"); 
		query.append("   ,'' CRE_USR_ID" ).append("\n"); 
		query.append("   ,'' CRE_DT    " ).append("\n"); 
		query.append("   ,'' UPD_USR_ID" ).append("\n"); 
		query.append("   ,'' UPD_DT    " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}