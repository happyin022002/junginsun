/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchOfcLvlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.04.25 이은섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author EUN-SUP LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSearchOfcLvlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELECT
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchOfcLvlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSearchOfcLvlListRSQL").append("\n"); 
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
		query.append("SELECT A.OFC_CD," ).append("\n"); 
		query.append("       A.OFC_APLY_FM_YRWK," ).append("\n"); 
		query.append("       A.OFC_APLY_TO_YRWK," ).append("\n"); 
		query.append("       A.OFC_TP_CD," ).append("\n"); 
		query.append("       A.OFC_ENG_NM," ).append("\n"); 
		query.append("       A.OFC_LOCL_NM," ).append("\n"); 
		query.append("       A.PRNT_OFC_CD," ).append("\n"); 
		query.append("       A.OFC_KND_CD," ).append("\n"); 
		query.append("       A.DELT_FLG," ).append("\n"); 
		query.append("       A.OFC_SLS_DELT_FLG," ).append("\n"); 
		query.append("       A.OFC_LVL," ).append("\n"); 
		query.append("       A.N1ST_PRNT_OFC_CD," ).append("\n"); 
		query.append("       A.N2ND_PRNT_OFC_CD," ).append("\n"); 
		query.append("       A.N3RD_PRNT_OFC_CD," ).append("\n"); 
		query.append("       A.N4TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("       A.N5TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("       A.N6TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("       A.N7TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("       A.SAQ_RGN_OFC_CD," ).append("\n"); 
		query.append("       A.SPC_SLS_OFC_CD," ).append("\n"); 
		query.append("       B.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("  FROM SPC_OFC_LVL A, com_intg_cd_dtl B" ).append("\n"); 
		query.append(" WHERE B.INTG_CD_ID = 'CD00675'" ).append("\n"); 
		query.append("   AND A.OFC_KND_CD = B.INTG_CD_VAL_CTNT(+)" ).append("\n"); 

	}
}