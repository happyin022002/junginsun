/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchDailyForecastHistoryOfcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.13 
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

public class DailyForecastManageDBDAOSearchDailyForecastHistoryOfcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDailyForecastHistoryOfcList
	  * 2016.05.12 SPC_GET_HC_RT_BSA_FNC : SKD_VOY_NO parm 추가 
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchDailyForecastHistoryOfcListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skdvoyno",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("salesOffice",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofckndcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vslcd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skddircd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subTrade",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("subOffice",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSearchDailyForecastHistoryOfcListRSQL").append("\n"); 
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
		query.append("SELECT A.TRD_CD     AS TRD_CD    ," ).append("\n"); 
		query.append("         A.SUB_TRD_CD AS SUB_TRD_CD," ).append("\n"); 
		query.append("         A.RLANE_CD   AS RLANE_CD  ," ).append("\n"); 
		query.append("         A.SKD_DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("         DECODE(A.IOC_TS_CD, 'O', 'OCN', 'I', 'IPC', 'TS') AS IOC_CD    ," ).append("\n"); 
		query.append("         DECODE(A.SLS_OFC_CD, '', '+', A.SLS_OFC_CD)       AS SLS_OFC_CD," ).append("\n"); 
		query.append("         SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK              AS BSE_WK    ," ).append("\n"); 
		query.append("         V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD                  AS VVD       ," ).append("\n"); 
		query.append("         A.BSE_DT                                          AS BSE_DT    ," ).append("\n"); 
		query.append("         DECODE(A.POL_YD_CD, '', '+', A.POL_YD_CD)         AS POL_CD    ," ).append("\n"); 
		query.append("         DECODE(A.POD_YD_CD, '', '+', A.POD_YD_CD)         AS POD_CD    ," ).append("\n"); 
		query.append("         SUM(NVL(A.FCAST_LOD_QTY, 0) + NVL(A.FCAST_40FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(A.TRD_CD, A.RLANE_CD, A.DIR_CD, A.VSL_CD, A.SKD_VOY_NO,'D5') + NVL(A.FCAST_45FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(A.TRD_CD, A.RLANE_CD, A.DIR_CD, A.VSL_CD,A.SKD_VOY_NO, 'D7') + NVL(A.FCAST_53FT_QTY, 0) * 2) AS FCAST_TTL_TEU_QTY," ).append("\n"); 
		query.append("         SUM(A.FCAST_LOD_QTY)     AS FCAST_LOD_QTY    ," ).append("\n"); 
		query.append("         SUM(A.FCAST_40FT_HC_QTY) AS FCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("         SUM(A.FCAST_45FT_HC_QTY) AS FCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("         SUM(A.FCAST_53FT_QTY)    AS FCAST_53FT_QTY   ," ).append("\n"); 
		query.append("         SUM(A.FCAST_RF_QTY)      AS FCAST_RF_QTY     ," ).append("\n"); 
		query.append("         SUM(A.FCAST_TTL_WGT)     AS FCAST_TTL_WGT    ," ).append("\n"); 
		query.append("         SUM(A.ALOC_LOD_QTY)      AS ALOC_LOD_QTY     ," ).append("\n"); 
		query.append("         SUM(A.ALOC_40FT_HC_QTY)  AS ALOC_40FT_HC_QTY ," ).append("\n"); 
		query.append("         SUM(A.ALOC_45FT_HC_QTY)  AS ALOC_45FT_HC_QTY ," ).append("\n"); 
		query.append("         SUM(A.ALOC_53FT_QTY)     AS ALOC_53FT_QTY    ," ).append("\n"); 
		query.append("         SUM(A.ALOC_RF_QTY)       AS ALOC_RF_QTY      ," ).append("\n"); 
		query.append("         SUM(A.ALOC_TTL_WGT)      AS ALOC_TTL_WGT     ," ).append("\n"); 
		query.append("         DECODE(A.POL_YD_CD, '', 1, DECODE(A.POD_YD_CD, '', 2, 3)) AS LVL" ).append("\n"); 
		query.append("    FROM SPC_DLY_FCAST_HIS A," ).append("\n"); 
		query.append("         COA_MON_VVD       V" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("     AND V.VSL_CD     LIKE @[vslcd]    ||'%'" ).append("\n"); 
		query.append("     AND V.SKD_VOY_NO LIKE @[skdvoyno] ||'%'" ).append("\n"); 
		query.append("     AND V.DIR_CD     LIKE @[skddircd] ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND A.IOC_TS_CD  LIKE @[ioc]      ||'%'" ).append("\n"); 
		query.append("#if (${vvd} == '')" ).append("\n"); 
		query.append("     AND A.TRD_CD     LIKE @[trade]    ||'%'" ).append("\n"); 
		query.append("     AND A.SUB_TRD_CD LIKE @[subTrade] ||'%'" ).append("\n"); 
		query.append("     AND A.RLANE_CD   LIKE @[lane]     ||'%'" ).append("\n"); 
		query.append("     AND A.DIR_CD     LIKE @[bound]    ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${salesOffice} != '' && ${subOffice} == '')" ).append("\n"); 
		query.append("     AND A.SLS_OFC_CD = @[salesOffice]" ).append("\n"); 
		query.append("     AND A.OFC_KND_CD = @[ofckndcd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${subOffice} != '' && ${salesOffice} == '') || (${subOffice} != '' && ${salesOffice} != ''))" ).append("\n"); 
		query.append("     AND A.SLS_OFC_CD = @[subOffice]" ).append("\n"); 
		query.append("     AND A.OFC_KND_CD = @[ofckndcd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} == '')" ).append("\n"); 
		query.append("     AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK  IN ( SELECT COST_YR||COST_WK" ).append("\n"); 
		query.append("                                                         FROM (  SELECT P.COST_YR," ).append("\n"); 
		query.append("                                                                        P.COST_WK" ).append("\n"); 
		query.append("                                                                   FROM COA_WK_PRD P" ).append("\n"); 
		query.append("                                                                  WHERE P.COST_YR||P.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("                                                               ORDER BY P.COST_YR||P.COST_WK ) Z" ).append("\n"); 
		query.append("                                                        WHERE ROWNUM <= @[duration] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     AND A.FCAST_TP_CD = 'D'  " ).append("\n"); 
		query.append("     AND A.RLANE_CD    = V.RLANE_CD" ).append("\n"); 
		query.append("     AND A.TRD_CD      = V.TRD_CD" ).append("\n"); 
		query.append("     AND A.SUB_TRD_CD  = V.SUB_TRD_CD" ).append("\n"); 
		query.append("     AND A.VSL_CD      = V.VSL_CD" ).append("\n"); 
		query.append("     AND A.SKD_VOY_NO  = V.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND A.SKD_DIR_CD  = V.DIR_CD" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                         (A.TRD_CD, A.SUB_TRD_CD,A.RLANE_CD, A.SKD_DIR_CD, V.SLS_YRMON,V.COST_WK, V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD, A.IOC_TS_CD, A.BSE_DT, A.SLS_OFC_CD, POL_YD_CD, POD_YD_CD)," ).append("\n"); 
		query.append("                         (A.TRD_CD, A.SUB_TRD_CD,A.RLANE_CD, A.SKD_DIR_CD, V.SLS_YRMON,V.COST_WK, V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD, A.IOC_TS_CD, A.BSE_DT, A.SLS_OFC_CD, POL_YD_CD)," ).append("\n"); 
		query.append("                         (A.TRD_CD, A.SUB_TRD_CD,A.RLANE_CD, A.SKD_DIR_CD, V.SLS_YRMON,V.COST_WK, V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD, A.IOC_TS_CD, A.BSE_DT, A.SLS_OFC_CD)" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("ORDER BY A.TRD_CD    ," ).append("\n"); 
		query.append("         A.SUB_TRD_CD," ).append("\n"); 
		query.append("         A.RLANE_CD  ," ).append("\n"); 
		query.append("         A.SKD_DIR_CD," ).append("\n"); 
		query.append("         SUBSTR(V.SLS_YRMON,1,4)||V.COST_WK DESC," ).append("\n"); 
		query.append("         VVD           ," ).append("\n"); 
		query.append("         A.IOC_TS_CD   ," ).append("\n"); 
		query.append("         A.SLS_OFC_CD  ," ).append("\n"); 
		query.append("         BSE_DT    DESC," ).append("\n"); 
		query.append("         POL_YD_CD DESC," ).append("\n"); 
		query.append("         LVL           ," ).append("\n"); 
		query.append("         POD_YD_CD" ).append("\n"); 

	}
}