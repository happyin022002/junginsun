/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VoMakeDAOMtyRepoTESTRSCostVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.28
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2015.05.28 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoMakeDAOMtyRepoTESTRSCostVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public VoMakeDAOMtyRepoTESTRSCostVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo").append("\n"); 
		query.append("FileName : VoMakeDAOMtyRepoTESTRSCostVORSQL").append("\n"); 
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
		query.append("SELECT	'' AS SLS_FM_DT,                            " ).append("\n"); 
		query.append("		'' AS MTY_TTL_CRE_IF_AMT,                   " ).append("\n"); 
		query.append("		'' AS MTY_TRSP_MNL_AMT,                     " ).append("\n"); 
		query.append("		'' AS MTY_TRSP_CRE_BSE_IF_AMT,              " ).append("\n"); 
		query.append("		'' AS MTY_TML_CRE_BSE_IF_AMT,               " ).append("\n"); 
		query.append("		'' AS MTY_TML_MNL_AMT,                      " ).append("\n"); 
		query.append("		'' AS COST_YRMON,                           " ).append("\n"); 
		query.append("		'' AS APLY_ADJ_PL_FLG,                      " ).append("\n"); 
		query.append("		'' AS MTY_TRSP_IF_AMT,                      " ).append("\n"); 
		query.append("		'' AS COST_WK,                              " ).append("\n"); 
		query.append("		'' AS USER_ID,                              " ).append("\n"); 
		query.append("		'' AS MTY_TTL_IF_AMT,                       " ).append("\n"); 
		query.append("		'' AS MTY_TML_IF_AMT,                       " ).append("\n"); 
		query.append("		'' AS SEL_FLG,                               " ).append("\n"); 
		query.append("		'' AS MTY_TTL_MNL_AMT,                       " ).append("\n"); 
		query.append("		'' AS COST_YR," ).append("\n"); 
		query.append("		'' AS REV_MON," ).append("\n"); 
		query.append("		'' AS MT_STEVE," ).append("\n"); 
		query.append("		'' AS MT_TRANS," ).append("\n"); 
		query.append("		'' AS TTL_AMT," ).append("\n"); 
		query.append("        '' AS mty_repo_cre_dt" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}