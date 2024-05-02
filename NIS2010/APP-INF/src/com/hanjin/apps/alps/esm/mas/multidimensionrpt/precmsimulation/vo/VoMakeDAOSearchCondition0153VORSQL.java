/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : VoMakeDAOSearchCondition0153VORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoMakeDAOSearchCondition0153VORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public VoMakeDAOSearchCondition0153VORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo").append("\n"); 
		query.append("FileName : VoMakeDAOSearchCondition0153VORSQL").append("\n"); 
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
		query.append("      	'' AS F_SPCL_RF,                           " ).append("\n"); 
		query.append("		'' AS F_MTY_RTN_YD_CHK,                    " ).append("\n"); 
		query.append("		'' AS F_CHSS_TERM,                         " ).append("\n"); 
		query.append("		'' AS F_COB_PROFIT_LV2,                    " ).append("\n"); 
		query.append("		'' AS F_CLT_OFC_CD,                        " ).append("\n"); 
		query.append("		'' AS F_SPCL_SOC,                          " ).append("\n"); 
		query.append("		'' AS F_SPCL_BB,                           " ).append("\n"); 
		query.append("		'' AS F_CMDT_CD,                           " ).append("\n"); 
		query.append("		'' AS F_POR_CD,                            " ).append("\n"); 
		query.append("		'' AS F_DEL_NODE,                          " ).append("\n"); 
		query.append("		'' AS F_SPCL_REVMT,                        " ).append("\n"); 
		query.append("		'' AS F_N_POD,                             " ).append("\n"); 
		query.append("		'' AS F_OFC_LVL,                           " ).append("\n"); 
		query.append("		'' AS F_END_PCTL_NO,                       " ).append("\n"); 
		query.append("		'' AS F_R_TERM,                            " ).append("\n"); 
		query.append("		'' AS F_COB_PROFIT_VW,                     " ).append("\n"); 
		query.append("		'' AS F_SPCL_AK,                           " ).append("\n"); 
		query.append("		'' AS F_ORGI_NODE,                         " ).append("\n"); 
		query.append("		'' AS F_PC_CREATION,                       " ).append("\n"); 
		query.append("		'' AS F_LANE4,                             " ).append("\n"); 
		query.append("		'' AS F_LANE2,                             " ).append("\n"); 
		query.append("		'' AS F_LANE3,                             " ).append("\n"); 
		query.append("		'' AS F_OUT_PARAM_NUMBER,                  " ).append("\n"); 
		query.append("		'' AS ERR_MSG,                             " ).append("\n"); 
		query.append("		'' AS F_PCTL_NO,                           " ).append("\n"); 
		query.append("		'' AS F_MTY_RTN_YD_NODE,                   " ).append("\n"); 
		query.append("		'' AS F_PORT2,                             " ).append("\n"); 
		query.append("		'' AS F_PORT1,                             " ).append("\n"); 
		query.append("		'' AS F_MTY_PKUP_YD_NODE,                  " ).append("\n"); 
		query.append("		'' AS F_PORT3,                             " ).append("\n"); 
		query.append("		'' AS F_VOID_QTY,                          " ).append("\n"); 
		query.append("		'' AS F_DEL_CD,                            " ).append("\n"); 
		query.append("		'' AS F_OUT_PARAM_VARCHAR,                 " ).append("\n"); 
		query.append("		'' AS F_CNTR_TPSZ_CD,                      " ).append("\n"); 
		query.append("		'' AS F_LANE1,                              " ).append("\n"); 
		query.append("		'' AS F_NODE_CD,                           " ).append("\n"); 
		query.append("		'' AS F_DEST_NODE,                         " ).append("\n"); 
		query.append("		'' AS F_SLS_OFC_CD,                        " ).append("\n"); 
		query.append("		'' AS F_N_POL,                             " ).append("\n"); 
		query.append("		'' AS F_USER_ID,                           " ).append("\n"); 
		query.append("		'' AS F_SPCL_DG,                           " ).append("\n"); 
		query.append("		'' AS F_PPD_OFC_CD,                        " ).append("\n"); 
		query.append("		'' AS F_POD_CD,                            " ).append("\n"); 
		query.append("		'' AS F_QTY,                               " ).append("\n"); 
		query.append("		'' AS F_POR_NODE,                          " ).append("\n"); 
		query.append("		'' AS F_COST_YRMON,                        " ).append("\n"); 
		query.append("		'' AS F_OFC_CD,                            " ).append("\n"); 
		query.append("		'' AS F_BKG_OFC_CD,                        " ).append("\n"); 
		query.append("		'' AS F_COB_PROFIT_LV,                     " ).append("\n"); 
		query.append("		'' AS F_D_TERM,                            " ).append("\n"); 
		query.append("		'' AS F_G_REV,                             " ).append("\n"); 
		query.append("		'' AS F_POL_CD,                            " ).append("\n"); 
		query.append("		'' AS ERROR_CODE,                          " ).append("\n"); 
		query.append("		'' AS F_START_PCTL_NO,                     " ).append("\n"); 
		query.append("		'' AS F_AGMT_SGN_OFC_CD,                   " ).append("\n"); 
		query.append("		'' AS F_MTY_RTN_YD_CD,                     " ).append("\n"); 
		query.append("		'' AS F_MTY_PKUP_YD_CD," ).append("\n"); 
		query.append("		'' AS CNTR_MT_DYS    , " ).append("\n"); 
		query.append("		'' AS TTL_DYS,     " ).append("\n"); 
		query.append("		'' AS MAS_RHQ,   " ).append("\n"); 
		query.append("		'' AS MAS_ECC    ," ).append("\n"); 
		query.append("		'' AS F_MTY_RTN_LST_CD," ).append("\n"); 
		query.append("		'' AS MAS_RCC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}