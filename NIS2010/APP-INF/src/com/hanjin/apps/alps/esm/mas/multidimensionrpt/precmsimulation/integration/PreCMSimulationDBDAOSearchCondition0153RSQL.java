/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PreCMSimulationDBDAOSearchCondition0153RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.11
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2014.08.11 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreCMSimulationDBDAOSearchCondition0153RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_MAS_0153 ( Pre CM/OP Simulation ) UI 를 위한 별도의 Search Condition VO 생성
	  * </pre>
	  */
	public PreCMSimulationDBDAOSearchCondition0153RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.integration").append("\n"); 
		query.append("FileName : PreCMSimulationDBDAOSearchCondition0153RSQL").append("\n"); 
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
		query.append("select '' F_SPCL_RF" ).append("\n"); 
		query.append("    , '' F_COB_PROFIT_LV2" ).append("\n"); 
		query.append("    , '' F_CLT_OFC_CD" ).append("\n"); 
		query.append("    , '' F_SPCL_SOC" ).append("\n"); 
		query.append("    , '' F_SPCL_BB" ).append("\n"); 
		query.append("    , '' F_CMDT_CD" ).append("\n"); 
		query.append("    , '' F_POR_CD" ).append("\n"); 
		query.append("    , '' F_DEL_NODE" ).append("\n"); 
		query.append("    , '' F_SPCL_REVMT" ).append("\n"); 
		query.append("    , '' F_N_POD" ).append("\n"); 
		query.append("    , '' F_OFC_LVL" ).append("\n"); 
		query.append("    , '' F_END_PCTL_NO" ).append("\n"); 
		query.append("    , '' F_R_TERM" ).append("\n"); 
		query.append("    , '' F_COB_PROFIT_VW" ).append("\n"); 
		query.append("    , '' F_SPCL_AK" ).append("\n"); 
		query.append("    , '' F_ORGI_NODE" ).append("\n"); 
		query.append("    , '' F_PC_CREATION" ).append("\n"); 
		query.append("    , '' F_LANE4" ).append("\n"); 
		query.append("    , '' F_LANE2" ).append("\n"); 
		query.append("    , '' F_LANE3" ).append("\n"); 
		query.append("    , '' F_OUT_PARAM_NUMBER" ).append("\n"); 
		query.append("    , '' F_PCTL_NO" ).append("\n"); 
		query.append("    , '' F_PORT2" ).append("\n"); 
		query.append("    , '' F_PORT1" ).append("\n"); 
		query.append("    , '' F_PORT3" ).append("\n"); 
		query.append("    , '' F_VOID_QTY" ).append("\n"); 
		query.append("    , '' F_DEL_CD" ).append("\n"); 
		query.append("    , '' F_OUT_PARAM_VARCHAR" ).append("\n"); 
		query.append("    , '' F_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    , '' F_LANE1" ).append("\n"); 
		query.append("    , '' F_NODE_CD" ).append("\n"); 
		query.append("    , '' F_DEST_NODE" ).append("\n"); 
		query.append("    , '' F_SLS_OFC_CD" ).append("\n"); 
		query.append("    , '' F_N_POL" ).append("\n"); 
		query.append("    , '' F_USER_ID" ).append("\n"); 
		query.append("    , '' F_SPCL_DG" ).append("\n"); 
		query.append("    , '' F_PPD_OFC_CD" ).append("\n"); 
		query.append("    , '' F_POD_CD" ).append("\n"); 
		query.append("    , '' F_QTY" ).append("\n"); 
		query.append("    , '' F_POR_NODE" ).append("\n"); 
		query.append("    , '' F_COST_YRMON" ).append("\n"); 
		query.append("    , '' F_OFC_CD" ).append("\n"); 
		query.append("    , '' F_BKG_OFC_CD" ).append("\n"); 
		query.append("    , '' F_COB_PROFIT_LV" ).append("\n"); 
		query.append("    , '' F_D_TERM" ).append("\n"); 
		query.append("    , '' F_G_REV" ).append("\n"); 
		query.append("    , '' F_POL_CD" ).append("\n"); 
		query.append("    , '' F_START_PCTL_NO" ).append("\n"); 
		query.append("    , '' F_AGMT_SGN_OFC_CD" ).append("\n"); 
		query.append("    , '' F_MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("    , '' F_MTY_PKUP_YD_NODE" ).append("\n"); 
		query.append("    , '' F_MTY_RTN_YD_CD" ).append("\n"); 
		query.append("    , '' F_MTY_RTN_YD_NODE" ).append("\n"); 
		query.append("    , '' ERR_MSG" ).append("\n"); 
		query.append("    , '' ERROR_CODE" ).append("\n"); 
		query.append("    , '' F_MTY_RTN_YD_CHK" ).append("\n"); 
		query.append(" from dual" ).append("\n"); 

	}
}