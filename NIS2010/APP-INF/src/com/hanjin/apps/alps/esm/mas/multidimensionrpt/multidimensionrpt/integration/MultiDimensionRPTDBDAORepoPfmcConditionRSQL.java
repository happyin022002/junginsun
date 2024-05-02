/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MultiDimensionRPTDBDAORepoPfmcConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.30
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.05.30 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAORepoPfmcConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 레포트 condition vo
	  * </pre>
	  */
	public MultiDimensionRPTDBDAORepoPfmcConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAORepoPfmcConditionRSQL").append("\n"); 
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
		query.append("	 ''  F_USA_MODE" ).append("\n"); 
		query.append("	,''  F_EXCL_STS" ).append("\n"); 
		query.append("	,''  F_SCH_MODE" ).append("\n"); 
		query.append("	,''  F_CHKPRD" ).append("\n"); 
		query.append("	,''  F_FM_MON" ).append("\n"); 
		query.append("	,''  F_DIR_CD" ).append("\n"); 
		query.append("	,''  F_R_CMDT" ).append("\n"); 
		query.append("	,''  F_SC" ).append("\n"); 
		query.append("	,''  F_RHQ_CD" ).append("\n"); 
		query.append("	,''  F_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,''  F_CHTBIZ" ).append("\n"); 
		query.append("	,''  STR_DISPLAY" ).append("\n"); 
		query.append("	,''  F_DEL" ).append("\n"); 
		query.append("	,''  F_SLS_OFC_CD" ).append("\n"); 
		query.append("	,''  F_VSL_CD" ).append("\n"); 
		query.append("	,''  F_PRO_VW" ).append("\n"); 
		query.append("	,''  F_PRO_OBJ" ).append("\n"); 
		query.append("	,''  F_OP_VIEW" ).append("\n"); 
		query.append("	,''  F_VVD2" ).append("\n"); 
		query.append("	,''  F_VVD3" ).append("\n"); 
		query.append("	,''  F_OFC_LVL" ).append("\n"); 
		query.append("	,''  F_COST_YRMON" ).append("\n"); 
		query.append("	,''  F_FM_WK" ).append("\n"); 
		query.append("	,''  F_BKG_NO" ).append("\n"); 
		query.append("	,''  F_POL" ).append("\n"); 
		query.append("	,''  F_VVD1" ).append("\n"); 
		query.append("	,''  F_SKD_DIR_CD" ).append("\n"); 
		query.append("	,''  F_OFC_VW" ).append("\n"); 
		query.append("	,''  F_TO_MON" ).append("\n"); 
		query.append("	,''  F_SKD_VOY_NO" ).append("\n"); 
		query.append("	,''  F_RFA" ).append("\n"); 
		query.append("	,''  F_POR" ).append("\n"); 
		query.append("	,''  F_OFC_CD" ).append("\n"); 
		query.append("	,''  F_TRD_CD" ).append("\n"); 
		query.append("	,''  F_TO_WK" ).append("\n"); 
		query.append("	,''  F_PRO_LVL" ).append("\n"); 
		query.append("	,''  F_ISKOREAN" ).append("\n"); 
		query.append("	,''  F_ISKOREAN_A" ).append("\n"); 
		query.append("	,''  F_CMDT" ).append("\n"); 
		query.append("	,''  F_RLANE_CD" ).append("\n"); 
		query.append("	,''  F_SHIPPER" ).append("\n"); 
		query.append("	,''  F_POD" ).append("\n"); 
		query.append("	,''  F_YEAR" ).append("\n"); 
		query.append("	,''  F_SLS_MON" ).append("\n"); 
		query.append("	,''  F_TAB" ).append("\n"); 
		query.append("	,''  F_SUB_TRD_CD" ).append("\n"); 
		query.append("	,''  F_TRD_DIR_CD" ).append("\n"); 
		query.append("	,''  F_IAS_RGN_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}