/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ManualInputDBDAOSearchSceCopCntrRepoRuleRSQL.java
*@FileTitle : SCE_COP_CNTR_REPO_RULE Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.24
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.04.24 이준근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeJunKun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualInputDBDAOSearchSceCopCntrRepoRuleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSceCopCntrRepoRule
	  * </pre>
	  */
	public ManualInputDBDAOSearchSceCopCntrRepoRuleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.manualinput.integration").append("\n"); 
		query.append("FileName : ManualInputDBDAOSearchSceCopCntrRepoRuleRSQL").append("\n"); 
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
		query.append("SELECT  CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,CNTR_DP_SEQ" ).append("\n"); 
		query.append("       ,PROV_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,ACT_FLG" ).append("\n"); 
		query.append("       ,CNT_CD" ).append("\n"); 
		query.append("       ,LOC_CD" ).append("\n"); 
		query.append("       ,RGN_CD" ).append("\n"); 
		query.append("       ,CTR_CD" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT" ).append("\n"); 
		query.append("FROM SCE_COP_CNTR_REPO_RULE" ).append("\n"); 
		query.append("ORDER BY CNTR_DP_SEQ, CNTR_TPSZ_CD" ).append("\n"); 

	}
}