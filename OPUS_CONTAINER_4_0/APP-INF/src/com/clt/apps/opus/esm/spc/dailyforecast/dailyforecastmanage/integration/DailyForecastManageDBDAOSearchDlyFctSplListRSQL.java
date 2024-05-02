/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchDlyFctSplListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSearchDlyFctSplListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Forecast Input FileImport
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchDlyFctSplListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSearchDlyFctSplListRSQL").append("\n"); 
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
		query.append("SELECT FC.TRD_CD" ).append("\n"); 
		query.append("     , FC.SUB_TRD_CD" ).append("\n"); 
		query.append("     , FC.RLANE_CD" ).append("\n"); 
		query.append("     , FC.VSL_CD" ).append("\n"); 
		query.append("     , FC.SKD_VOY_NO" ).append("\n"); 
		query.append("     , FC.SKD_DIR_CD" ).append("\n"); 
		query.append("     , FC.VSL_CD || FC.SKD_VOY_NO || FC.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("     , FC.IOC_TS_CD" ).append("\n"); 
		query.append("     , FC.SREP_USR_ID" ).append("\n"); 
		query.append("     , FC.FCAST_CUST_TP_CD" ).append("\n"); 
		query.append("     , FC.CUST_CNT_CD" ).append("\n"); 
		query.append("     , FC.CUST_SEQ" ).append("\n"); 
		query.append("     , FC.POL_YD_CD" ).append("\n"); 
		query.append("     , FC.POD_YD_CD " ).append("\n"); 
		query.append("     , FC.FCAST_OFC_CD" ).append("\n"); 
		query.append("     , FC.FCAST_TTL_QTY" ).append("\n"); 
		query.append("     , FC.FCAST_40FT_HC_QTY" ).append("\n"); 
		query.append("     , FC.FCAST_45FT_HC_QTY" ).append("\n"); 
		query.append("     , FC.FCAST_RF_QTY" ).append("\n"); 
		query.append("     , FC.FCAST_TTL_WGT" ).append("\n"); 
		query.append("     , MC.CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("     , SUBSTR(MV.SLS_YRMON, 1, 4) AS SLS_YRMON " ).append("\n"); 
		query.append("     , MV.COST_WK " ).append("\n"); 
		query.append("     --20160203.ADD, 20160325.MOD" ).append("\n"); 
		query.append("     , FC.CTRT_NO" ).append("\n"); 
		query.append("     , FC.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("     , FC.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("     ,(SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = FC.CTRT_CUST_CNT_CD AND CUST_SEQ = FC.CTRT_CUST_SEQ) CTRT_CUST_NM" ).append("\n"); 
		query.append("  FROM SPC_DLY_FCAST_CUST FC" ).append("\n"); 
		query.append("     , COA_MON_VVD MV" ).append("\n"); 
		query.append("     , MDM_CUSTOMER MC " ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("       AND FC.CUST_CNT_CD = MC.CUST_CNT_CD " ).append("\n"); 
		query.append("       AND FC.CUST_SEQ = MC.CUST_SEQ " ).append("\n"); 
		query.append("       AND FC.TRD_CD = MV.TRD_CD " ).append("\n"); 
		query.append("       AND FC.RLANE_CD = MV.RLANE_CD " ).append("\n"); 
		query.append("       AND MV.IOC_CD = DECODE(FC.IOC_TS_CD, 'O', 'O', 'I') " ).append("\n"); 
		query.append("       AND FC.VSL_CD = MV.VSL_CD " ).append("\n"); 
		query.append("       AND FC.SKD_VOY_NO = MV.SKD_VOY_NO " ).append("\n"); 
		query.append("       AND FC.SKD_DIR_CD = MV.DIR_CD " ).append("\n"); 
		query.append("       AND FC.SUB_TRD_CD = MV.SUB_TRD_CD " ).append("\n"); 
		query.append("       AND " ).append("\n"); 
		query.append("       ( " ).append("\n"); 
		query.append("           MV.DELT_FLG IS NULL " ).append("\n"); 
		query.append("           OR MV.DELT_FLG = 'N' " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       AND MV.RLANE_CD <> 'RBCCO' " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       #if (${vvd} == '') " ).append("\n"); 
		query.append("       AND SUBSTR(MV.SLS_YRMON, 1, 4)||MV.COST_WK IN " ).append("\n"); 
		query.append("       (SELECT COST_YR||COST_WK " ).append("\n"); 
		query.append("         FROM " ).append("\n"); 
		query.append("              (SELECT P.COST_YR" ).append("\n"); 
		query.append("                   , P.COST_WK " ).append("\n"); 
		query.append("                FROM COA_WK_PRD P " ).append("\n"); 
		query.append("               WHERE P.COST_YR||P.COST_WK >= @[year]||@[week] " ).append("\n"); 
		query.append("            ORDER BY P.COST_YR||P.COST_WK " ).append("\n"); 
		query.append("              ) Z " ).append("\n"); 
		query.append("        WHERE ROWNUM <= @[duration] " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #if (${trade} != '') " ).append("\n"); 
		query.append("       AND FC.TRD_CD = @[trade] " ).append("\n"); 
		query.append("       #end  " ).append("\n"); 
		query.append("       #if (${lane} != '') " ).append("\n"); 
		query.append("       AND FC.RLANE_CD = @[lane] " ).append("\n"); 
		query.append("       #end  " ).append("\n"); 
		query.append("       #if (${subtrade} != '') " ).append("\n"); 
		query.append("       AND FC.SUB_TRD_CD = @[subtrade] " ).append("\n"); 
		query.append("       #end  " ).append("\n"); 
		query.append("       #if (${vvd} != '') " ).append("\n"); 
		query.append("       AND FC.VSL_CD = SUBSTR(@[vvd], 1, 4) " ).append("\n"); 
		query.append("       AND FC.SKD_VOY_NO = SUBSTR(@[vvd] , 5, 4) " ).append("\n"); 
		query.append("       AND FC.DIR_CD = SUBSTR(@[vvd], 9, 1) " ).append("\n"); 
		query.append("       #end  " ).append("\n"); 
		query.append("       #if (${bound} != '') " ).append("\n"); 
		query.append("       AND FC.DIR_CD = @[bound] " ).append("\n"); 
		query.append("       #end" ).append("\n"); 

	}
}