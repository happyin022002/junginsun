/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VoMakeDAOVesselLayupVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.14 
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

public class VoMakeDAOVesselLayupVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public VoMakeDAOVesselLayupVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo").append("\n"); 
		query.append("FileName : VoMakeDAOVesselLayupVORSQL").append("\n"); 
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
		query.append("SELECT	'' AS MERGE_CD," ).append("\n"); 
		query.append("		'' AS F_YEARWEEK," ).append("\n"); 
		query.append("      	'' AS COST_YR,                                  " ).append("\n"); 
		query.append("		'' AS COST_WK,  " ).append("\n"); 
		query.append("		'' AS COST_YRMON,                             " ).append("\n"); 
		query.append("		'' AS RLANE_CD,                                             " ).append("\n"); 
		query.append("		'' AS VSL_CD,  " ).append("\n"); 
		query.append("		'' AS VSL_CD_TTL,                                 " ).append("\n"); 
		query.append("		'' AS STND_COST_CD,                                    " ).append("\n"); 
		query.append("		'' AS STND_COST_NM,                                          " ).append("\n"); 
		query.append("		'' AS SUN_COST_AMT,                                        " ).append("\n"); 
		query.append("		'' AS MON_COST_AMT,                                                " ).append("\n"); 
		query.append("		'' AS TUE_COST_AMT,                                      " ).append("\n"); 
		query.append("		'' AS WED_COST_AMT,                                               " ).append("\n"); 
		query.append("		'' AS THU_COST_AMT,                                              " ).append("\n"); 
		query.append("		'' AS FRI_COST_AMT,                                          " ).append("\n"); 
		query.append("		'' AS SAT_COST_AMT,                                               " ).append("\n"); 
		query.append("		'' AS TTL_AMT," ).append("\n"); 
		query.append("		'' AS DP_SEQ," ).append("\n"); 
		query.append("		'' AS USR_ID," ).append("\n"); 
		query.append("		'' AS WK_PERIOD                      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}