/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VoDAONodLnkCostCodeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoDAONodLnkCostCodeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Node/Link U/C Adjustment 화면에서 사용하는 VO 쿼리
	  * </pre>
	  */
	public VoDAONodLnkCostCodeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo").append("\n"); 
		query.append("FileName : VoDAONodLnkCostCodeVORSQL").append("\n"); 
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
		query.append("       '' AS CO_CD" ).append("\n"); 
		query.append("      ,'' AS MAS_COST_SRC_CD" ).append("\n"); 
		query.append("      ,'' AS NOD_TTL_AMT" ).append("\n"); 
		query.append("      ,'' AS LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,'' AS TRD_CD" ).append("\n"); 
		query.append("      ,'' AS COST_ACT_GRP_CD" ).append("\n"); 
		query.append("      ,'' AS COST_VOL_CD" ).append("\n"); 
		query.append("      ,'' AS COST_FX_FLG" ).append("\n"); 
		query.append("      ,'' AS LNK_FM_NOD_CD" ).append("\n"); 
		query.append("      ,'' AS COST_YRMON" ).append("\n"); 
		query.append("      ,'' AS LNK_TTL_AMT" ).append("\n"); 
		query.append("      ,'' AS MAS_COST_SRC_CD_V" ).append("\n"); 
		query.append("      ,'' AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,'' AS NOD_TTL_QTY" ).append("\n"); 
		query.append("      ,'' AS NOD_CD" ).append("\n"); 
		query.append("      ,'' AS FULL_MTY_CD" ).append("\n"); 
		query.append("      ,'' AS LNK_TTL_QTY" ).append("\n"); 
		query.append("      ,'' AS COST_LOC_GRP_CD" ).append("\n"); 
		query.append("      ,'' AS STND_COST_USD_AMT" ).append("\n"); 
		query.append("      ,'' AS MTY_UC_AMT" ).append("\n"); 
		query.append("      ,'' AS LNK_TO_NOD_CD" ).append("\n"); 
		query.append("      ,'' AS STND_COST_CD" ).append("\n"); 
		query.append("      ,'' AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,'' AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,'' AS SLAN_CD" ).append("\n"); 
		query.append("      ,'' AS VNDR_SEQ" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}