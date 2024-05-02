/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : VoMakeDAOEqCntrHldCostVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoMakeDAOEqCntrHldCostVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public VoMakeDAOEqCntrHldCostVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo").append("\n"); 
		query.append("FileName : VoMakeDAOEqCntrHldCostVORSQL").append("\n"); 
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
		query.append("      	'' AS COST_YRMON,                                  " ).append("\n"); 
		query.append("		'' AS TPSZ_CD,                               " ).append("\n"); 
		query.append("		'' AS TTL_DYS,                                             " ).append("\n"); 
		query.append("		'' AS SEA_DYS,                                " ).append("\n"); 
		query.append("		'' AS ORG_RAIL_DYS,                                " ).append("\n"); 
		query.append("		'' AS DEST_RAIL_DYS,                                          " ).append("\n"); 
		query.append("		'' AS FULL_DMT,                                        " ).append("\n"); 
		query.append("		'' AS MT_LAND,                                                " ).append("\n"); 
		query.append("		'' AS SUB_TOT,                                      " ).append("\n"); 
		query.append("		'' AS BOX_CNT,                                               " ).append("\n"); 
		query.append("		'' AS AVG_DYS,                                              " ).append("\n"); 
		query.append("		'' AS MT_SEA_DYS," ).append("\n"); 
		query.append("		'' AS DAY_A," ).append("\n"); 
		query.append("		'' AS DAY_B," ).append("\n"); 
		query.append("		'' AS DAY_C," ).append("\n"); 
		query.append("		'' AS ACCT_CD," ).append("\n"); 
		query.append("		'' AS ACCT_NM," ).append("\n"); 
		query.append("		'' AS TTL_COST_AMT," ).append("\n"); 
		query.append("		'' AS DAY_A_PCT," ).append("\n"); 
		query.append("		'' AS DAY_B_PCT," ).append("\n"); 
		query.append("		'' AS DAY_A_COST," ).append("\n"); 
		query.append("		'' AS DAY_B_COST," ).append("\n"); 
		query.append("		'' AS PDM_A," ).append("\n"); 
		query.append("		'' AS PDM_C     ,               " ).append("\n"); 
		query.append("		'' AS UPD_USR_ID," ).append("\n"); 
		query.append("		'' AS CRE_USR_ID," ).append("\n"); 
		query.append("		'' AS DYS_NORM, " ).append("\n"); 
		query.append("		'' AS HLD_UC_AMT_NORM," ).append("\n"); 
		query.append("		'' AS HLD_UC_AMT_NORM_ADJ " ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}