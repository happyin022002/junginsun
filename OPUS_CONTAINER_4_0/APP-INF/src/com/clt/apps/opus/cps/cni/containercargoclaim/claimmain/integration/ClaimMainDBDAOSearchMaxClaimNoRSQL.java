/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ClaimMainDBDAOSearchMaxClaimNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.22 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchMaxClaimNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Claim No 생성시 최대값 가져오기
	  * </pre>
	  */
	public ClaimMainDBDAOSearchMaxClaimNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOSearchMaxClaimNoRSQL").append("\n"); 
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
		query.append("'CC' || TO_CHAR(SYSDATE,'YYYY') || LTRIM(TO_CHAR(TO_NUMBER((NVL(SUBSTR(MAX(CGO_CLM_NO),7,4),0))) + 1,'0009'))" ).append("\n"); 
		query.append("AS CGO_CLM_NO" ).append("\n"); 
		query.append("FROM  CNI_CGO_CLM" ).append("\n"); 
		query.append("WHERE CGO_CLM_NO LIKE 'CC' || TO_CHAR(SYSDATE,'YYYY') || '%'" ).append("\n"); 

	}
}