/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NetworkCostDBDAOSearchNWCreRStatusListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchNWCreRStatusListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchNWCreRStatusList SELECT
	  * </pre>
	  */
	public NetworkCostDBDAOSearchNWCreRStatusListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchNWCreRStatusListRSQL").append("\n"); 
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
		query.append("A.STND_COST_CD      AS STND_COST_CD" ).append("\n"); 
		query.append(",B.STND_COST_NM      AS STND_COST_NM" ).append("\n"); 
		query.append(",A.VSL_OSHP_CD       AS VSL_OSHP_CD" ).append("\n"); 
		query.append(",A.VOP_CD            AS VOP_CD" ).append("\n"); 
		query.append(",A.CRE_STS_CD        AS CRE_STS_CD" ).append("\n"); 
		query.append(",A.CRE_SLCT_FLG      AS CRE_SLCT_FLG" ).append("\n"); 
		query.append("FROM COA_NTWK_COST_CRE A" ).append("\n"); 
		query.append(",COA_STND_ACCT     B" ).append("\n"); 
		query.append("WHERE  A.STND_COST_CD = B.STND_COST_CD (+)" ).append("\n"); 
		query.append("ORDER BY STND_COST_CD" ).append("\n"); 

	}
}