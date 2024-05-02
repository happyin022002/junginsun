/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LogisticsRPTDBDAOSearchLgstConditionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LogisticsRPTDBDAOSearchLgstConditionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Logistics Report에서 공통으로 사용하는 VO
	  * 2014.08.13 박은주 [CHM-201431516]  Logistics PFMC Report - KPI 3 추가 및 화면변경 요청사항(KPI3추가)
	  * </pre>
	  */
	public LogisticsRPTDBDAOSearchLgstConditionVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.integration").append("\n"); 
		query.append("FileName : LogisticsRPTDBDAOSearchLgstConditionVORSQL").append("\n"); 
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
		query.append("SELECT '' F_CHKPRD" ).append("\n"); 
		query.append("      , '' F_CTRL_OFC_CD" ).append("\n"); 
		query.append("      , '' F_FM_MON" ).append("\n"); 
		query.append("      , '' F_FM_WK" ).append("\n"); 
		query.append("      , '' F_INCLD_MT" ).append("\n"); 
		query.append("      , '' F_INCLD_RMON" ).append("\n"); 
		query.append("      , '' F_INCLD_TML" ).append("\n"); 
		query.append("      , '' F_IN_OUT" ).append("\n"); 
		query.append("      , '' F_ISLANE_DISPLAY" ).append("\n"); 
		query.append("      , '' F_ISNODE_DISPLAY" ).append("\n"); 
		query.append("      , '' F_ISTPSZ_DISPLAY" ).append("\n"); 
		query.append("      , '' F_KPI_TYPE" ).append("\n"); 
		query.append("      , '' F_LGS_KPI_CD" ).append("\n"); 
		query.append("      , '' F_LGS_KPI_COST_GRP_CD" ).append("\n"); 
		query.append("      , '' F_LGS_MN_KPI_CD" ).append("\n"); 
		query.append("      , '' F_NOD_CD" ).append("\n"); 
		query.append("      , '' F_NOD_CD2" ).append("\n"); 
		query.append("      , '' F_NOD_CD3" ).append("\n"); 
		query.append("      , '' F_NOD_CD4" ).append("\n"); 
		query.append("      , '' F_REPORT" ).append("\n"); 
		query.append("      , '' F_RHQ_CD" ).append("\n"); 
		query.append("      , '' F_RLANE_CD" ).append("\n"); 
		query.append("      , '' F_SKD_DIR_CD" ).append("\n"); 
		query.append("      , '' F_SLS_MON" ).append("\n"); 
		query.append("      , '' F_SPLIT_MW" ).append("\n"); 
		query.append("      , '' F_TO_MON" ).append("\n"); 
		query.append("      , '' F_TO_WK" ).append("\n"); 
		query.append("      , '' F_TRD_CD" ).append("\n"); 
		query.append("      , '' F_YEAR" ).append("\n"); 
		query.append("      , '' S_CNTR_OFC_CD" ).append("\n"); 
		query.append("      , '' S_COST_WK2" ).append("\n"); 
		query.append("      , '' S_COST_YRMON2" ).append("\n"); 
		query.append("      , '' S_KPI_CD" ).append("\n"); 
		query.append("      , '' S_LGS_KPI_COST_GRP_CD" ).append("\n"); 
		query.append("      , '' S_LOAD" ).append("\n"); 
		query.append("      , '' S_RHQ_CD" ).append("\n"); 
		query.append("      , '' S_RLANE_CD" ).append("\n"); 
		query.append("      , '' S_SKD_DIR_CD" ).append("\n"); 
		query.append("      , '' S_TRD_CD" ).append("\n"); 
		query.append("      , '' F_EXCLD_CRR_HLG" ).append("\n"); 
		query.append("      , '' F_LGS_KPI3_CD" ).append("\n"); 
		query.append("   FROM DUAL" ).append("\n"); 

	}
}