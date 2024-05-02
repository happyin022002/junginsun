/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DailyForecastInquiryDBDAOSearchTSBookingNewListRSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastInquiryDBDAOSearchTSBookingNewListRSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * aaaa
	  * </pre>
	  */
	public DailyForecastInquiryDBDAOSearchTSBookingNewListRSQLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo").append("\n"); 
		query.append("FileName : DailyForecastInquiryDBDAOSearchTSBookingNewListRSQLRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       '' AS YRWK    " ).append("\n"); 
		query.append("      ,'' AS PRE_SLAN" ).append("\n"); 
		query.append("      ,'' AS PRE_VVD" ).append("\n"); 
		query.append("      ,'' AS PRE_ETB_DT" ).append("\n"); 
		query.append("      ,'' AS POST_SLAN" ).append("\n"); 
		query.append("      ,'' AS POST_VVD" ).append("\n"); 
		query.append("      ,'' AS POST_ETB_DT" ).append("\n"); 
		query.append("      ,'' AS TS_PORT" ).append("\n"); 
		query.append("      ,'' AS POL_CD" ).append("\n"); 
		query.append("      ,'' AS POD_CD" ).append("\n"); 
		query.append("      ,'' AS DEL_CD" ).append("\n"); 
		query.append("      ,'' AS SLS_OFC_CD" ).append("\n"); 
		query.append("      ,'' AS TSLAN_CD" ).append("\n"); 
		query.append("      ,'' AS VVD" ).append("\n"); 
		query.append("      ,'' AS LVL" ).append("\n"); 
		query.append("      ,'' AS BKG_TTL_QTY    " ).append("\n"); 
		query.append("      ,'' AS BKG_TTL_WGT    " ).append("\n"); 
		query.append("      ,'' AS BKG_20FT_QTY   " ).append("\n"); 
		query.append("      ,'' AS BKG_40FT_QTY   " ).append("\n"); 
		query.append("      ,'' AS BKG_40FT_HC_QTY" ).append("\n"); 
		query.append("      ,'' AS BKG_45FT_HC_QTY" ).append("\n"); 
		query.append("      ,'' AS BKG_RF20_QTY   " ).append("\n"); 
		query.append("      ,'' AS BKG_RF40_QTY     " ).append("\n"); 
		query.append("      ,'' AS BKG_DG_QTY     " ).append("\n"); 
		query.append("      ,'' AS BKG_AK_QTY" ).append("\n"); 
		query.append("      ,'' AS PRE_VVD1" ).append("\n"); 
		query.append("      ,'' AS PRE_LANE1" ).append("\n"); 
		query.append("      ,'' AS PRE_PORT1   " ).append("\n"); 
		query.append("      ,'' AS PRE_VVD1_ETB" ).append("\n"); 
		query.append("      ,'' AS T_VVD" ).append("\n"); 
		query.append("      ,'' AS T_LANE" ).append("\n"); 
		query.append("      ,'' AS T_PORT " ).append("\n"); 
		query.append("      ,'' AS T_POD   " ).append("\n"); 
		query.append("      ,'' AS T_VVD_ETB" ).append("\n"); 
		query.append("      ,'' AS POST_VVD2" ).append("\n"); 
		query.append("      ,'' AS POST_LANE2" ).append("\n"); 
		query.append("      ,'' AS POST_PORT2  " ).append("\n"); 
		query.append("      ,'' AS POST_VVD2_ETB" ).append("\n"); 
		query.append("      ,'' AS POST_VVD3" ).append("\n"); 
		query.append("      ,'' AS POST_LANE3" ).append("\n"); 
		query.append("      ,'' AS POST_PORT3  " ).append("\n"); 
		query.append("      ,'' AS POST_VVD3_ETB         " ).append("\n"); 
		query.append("      ,'' AS POST_VVD4" ).append("\n"); 
		query.append("      ,'' AS POST_LANE4" ).append("\n"); 
		query.append("	  ,'' AS DEL_ETB" ).append("\n"); 
		query.append("      ,'' AS TLANE     " ).append("\n"); 
		query.append("	  ,'' AS SORTBY" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}