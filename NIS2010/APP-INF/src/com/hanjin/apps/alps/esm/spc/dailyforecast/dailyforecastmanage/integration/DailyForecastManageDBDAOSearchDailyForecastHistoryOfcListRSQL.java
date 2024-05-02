/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchDailyForecastHistoryOfcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * Lee Sang-Yong : [프로젝트] Ticket ID : CHM-201004171 53ft 추가
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2013-08-12 선처리 조회 속도개선
	  * 2014.07.30 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청
	  * 2015.10.21 이혜민 조회 속도개선 쿼리 튜닝
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
		params.put("salesOffice",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
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
		query.append("SELECT TRD_CD, " ).append("\n"); 
		query.append("       SUB_TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD  ," ).append("\n"); 
		query.append("       SKD_DIR_CD, " ).append("\n"); 
		query.append("       IOC_CD    ," ).append("\n"); 
		query.append("       SLS_OFC_CD," ).append("\n"); 
		query.append("       BSE_WK    ," ).append("\n"); 
		query.append("       VVD       ," ).append("\n"); 
		query.append("       BSE_DT    ," ).append("\n"); 
		query.append("       CUST_CTRL_CD," ).append("\n"); 
		query.append("       CASE WHEN GROUPING_ID(USA_BKG_MOD_CD) = 1 THEN '-' ELSE DECODE(USA_BKG_MOD_CD, 'OTH', 'OTHERS', 'OTH ', 'OTHERS', USA_BKG_MOD_CD) END USA_BKG_MOD_CD," ).append("\n"); 
		query.append("       POL_CD    , " ).append("\n"); 
		query.append("       POD_CD    ," ).append("\n"); 
		query.append("       DECODE(GROUPING_ID(POD_CD), 1,  NULL, 'OTHERS') DEST_LOC_CD," ).append("\n"); 
		query.append("       SUM(FCAST_TTL_TEU_QTY ) AS FCAST_TTL_TEU_QTY ," ).append("\n"); 
		query.append("       SUM(FCAST_LOD_QTY     ) AS FCAST_LOD_QTY     ," ).append("\n"); 
		query.append("       SUM(FCAST_20FT_DRY_QTY ) AS FCAST_20FT_DRY_QTY ," ).append("\n"); 
		query.append("       SUM(FCAST_40FT_DRY_QTY ) AS FCAST_40FT_DRY_QTY ," ).append("\n"); 
		query.append("       SUM(FCAST_40FT_HC_QTY ) AS FCAST_40FT_HC_QTY ," ).append("\n"); 
		query.append("       SUM(FCAST_45FT_HC_QTY ) AS FCAST_45FT_HC_QTY ," ).append("\n"); 
		query.append("       SUM(FCAST_53FT_QTY    ) AS FCAST_53FT_QTY    ," ).append("\n"); 
		query.append("       SUM(FCAST_RF_QTY      ) AS FCAST_RF_QTY      ," ).append("\n"); 
		query.append("       SUM(FCAST_RD_QTY      ) AS FCAST_RD_QTY      ," ).append("\n"); 
		query.append("       SUM(FCAST_TTL_WGT     ) AS FCAST_TTL_WGT     ," ).append("\n"); 
		query.append("       SUM(CFCAST_TTL_TEU_QTY) AS CFCAST_TTL_TEU_QTY," ).append("\n"); 
		query.append("       SUM(CFCAST_LOD_QTY    ) AS CFCAST_LOD_QTY    ," ).append("\n"); 
		query.append("       SUM(CFCAST_40FT_HC_QTY) AS CFCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("       SUM(CFCAST_45FT_HC_QTY) AS CFCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("       SUM(CFCAST_53FT_QTY   ) AS CFCAST_53FT_QTY   ," ).append("\n"); 
		query.append("       SUM(CFCAST_RF_QTY     ) AS CFCAST_RF_QTY     ," ).append("\n"); 
		query.append("       SUM(CFCAST_TTL_WGT    ) AS CFCAST_TTL_WGT    ," ).append("\n"); 
		query.append("       SUM(ALOC_TTL_QTY      ) AS ALOC_TTL_QTY      ," ).append("\n"); 
		query.append("       SUM(ALOC_20FT_DRY_QTY  ) AS ALOC_20FT_DRY_QTY  ," ).append("\n"); 
		query.append("       SUM(ALOC_40FT_DRY_QTY  ) AS ALOC_40FT_DRY_QTY  ," ).append("\n"); 
		query.append("       SUM(ALOC_40FT_HC_QTY  ) AS ALOC_40FT_HC_QTY  ," ).append("\n"); 
		query.append("       SUM(ALOC_45FT_HC_QTY  ) AS ALOC_45FT_HC_QTY  ," ).append("\n"); 
		query.append("       SUM(ALOC_53FT_QTY     ) AS ALOC_53FT_QTY     ," ).append("\n"); 
		query.append("       SUM(ALOC_RF_QTY       ) AS ALOC_RF_QTY       ," ).append("\n"); 
		query.append("       SUM(ALOC_RD_QTY       ) AS ALOC_RD_QTY       ," ).append("\n"); 
		query.append("       SUM(ALOC_TTL_WGT      ) AS ALOC_TTL_WGT      ,         " ).append("\n"); 
		query.append("       SUM(BKG_TTL_TEU_QTY   ) AS BKG_TTL_TEU_QTY   ," ).append("\n"); 
		query.append("       SUM(BKG_20FT_QTY      ) AS BKG_20FT_QTY      ," ).append("\n"); 
		query.append("       SUM(BKG_40FT_QTY      ) AS BKG_40FT_QTY      ," ).append("\n"); 
		query.append("       SUM(BKG_20FT_DRY_QTY   ) AS BKG_20FT_DRY_QTY   ," ).append("\n"); 
		query.append("       SUM(BKG_40FT_DRY_QTY   ) AS BKG_40FT_DRY_QTY   ," ).append("\n"); 
		query.append("       SUM(BKG_40FT_HC_QTY   ) AS BKG_40FT_HC_QTY   ," ).append("\n"); 
		query.append("       SUM(BKG_45FT_HC_QTY   ) AS BKG_45FT_HC_QTY   ," ).append("\n"); 
		query.append("       SUM(BKG_53FT_QTY      ) AS BKG_53FT_QTY      ," ).append("\n"); 
		query.append("       SUM(BKG_RF_QTY        ) AS BKG_RF_QTY        ," ).append("\n"); 
		query.append("       SUM(BKG_RD_QTY        ) AS BKG_RD_QTY        ," ).append("\n"); 
		query.append("       SUM(BKG_TTL_WGT       ) AS BKG_TTL_WGT       ," ).append("\n"); 
		query.append("--       DECODE(A.POL_CD, '', 1, DECODE(A.POD_CD, '', 2, 3)) AS LVL" ).append("\n"); 
		query.append("       4-(GROUPING_ID(USA_BKG_MOD_CD) +  GROUPING_ID(POL_CD) + GROUPING_ID(POD_CD)) AS LVL" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT /*+ LEADING(D V A ) */  A.TRD_CD     AS TRD_CD    ," ).append("\n"); 
		query.append("           A.SUB_TRD_CD AS SUB_TRD_CD," ).append("\n"); 
		query.append("           A.RLANE_CD   AS RLANE_CD  ," ).append("\n"); 
		query.append("           A.SKD_DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("           DECODE(A.IOC_TS_CD, 'O', 'OCN', 'I', 'IPC', 'TS') AS IOC_CD    ," ).append("\n"); 
		query.append("           DECODE(A.SLS_OFC_CD, '', '+', A.SLS_OFC_CD)       AS SLS_OFC_CD," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK              AS BSE_WK    ," ).append("\n"); 
		query.append("           V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD                  AS VVD       ," ).append("\n"); 
		query.append("           A.BSE_DT                                          AS BSE_DT    ," ).append("\n"); 
		query.append("           NVL(A.CUST_CTRL_CD, 'C') AS CUST_CTRL_CD," ).append("\n"); 
		query.append("           DECODE(A.POL_YD_CD, '', '+', A.POL_YD_CD)         AS POL_CD    ," ).append("\n"); 
		query.append("           DECODE(A.POD_YD_CD, '', '+', A.POD_YD_CD)         AS POD_CD    ," ).append("\n"); 
		query.append("           (NVL(A.FCAST_20FT_QTY, 0) + NVL(A.FCAST_40FT_QTY, 0) * 2 + NVL(A.FCAST_40FT_HC_QTY, 0) * 2 + NVL(A.FCAST_45FT_HC_QTY, 0) * 2 + NVL(A.FCAST_53FT_QTY, 0) * 2) AS FCAST_TTL_TEU_QTY," ).append("\n"); 
		query.append("           (NVL(A.FCAST_20FT_QTY, 0) + NVL(A.FCAST_40FT_QTY, 0) * 2)     AS FCAST_LOD_QTY    ," ).append("\n"); 
		query.append("           (A.FCAST_40FT_HC_QTY)      AS FCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("           (A.FCAST_45FT_HC_QTY)      AS FCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("           (A.FCAST_53FT_QTY)         AS FCAST_53FT_QTY   ," ).append("\n"); 
		query.append("           (A.FCAST_RF_QTY)           AS FCAST_RF_QTY     ," ).append("\n"); 
		query.append("           (A.FCAST_TTL_WGT)          AS FCAST_TTL_WGT    ," ).append("\n"); 
		query.append("           (NVL(A.CTRT_FCAST_TTL_QTY, 0) + NVL(A.CTRT_FCAST_40FT_HC_QTY, 0) * 2 + NVL(A.CTRT_FCAST_45FT_HC_QTY, 0) * 2 + NVL(A.CTRT_FCAST_53FT_QTY, 0) * 2) AS CFCAST_TTL_TEU_QTY," ).append("\n"); 
		query.append("           (A.CTRT_FCAST_TTL_QTY)     AS CFCAST_LOD_QTY    ," ).append("\n"); 
		query.append("           (A.CTRT_FCAST_40FT_HC_QTY) AS CFCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("           (A.CTRT_FCAST_45FT_HC_QTY) AS CFCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("           (A.CTRT_FCAST_53FT_QTY)    AS CFCAST_53FT_QTY   ," ).append("\n"); 
		query.append("           (A.CTRT_FCAST_RF_QTY)      AS CFCAST_RF_QTY     ," ).append("\n"); 
		query.append("           (A.CTRT_FCAST_TTL_WGT)     AS CFCAST_TTL_WGT    ," ).append("\n"); 
		query.append("           (A.ALOC_TTL_QTY)           AS ALOC_TTL_QTY     ," ).append("\n"); 
		query.append("           (A.ALOC_40FT_HC_QTY)       AS ALOC_40FT_HC_QTY ," ).append("\n"); 
		query.append("           (A.ALOC_45FT_HC_QTY)       AS ALOC_45FT_HC_QTY ," ).append("\n"); 
		query.append("           (A.ALOC_53FT_QTY)          AS ALOC_53FT_QTY    ," ).append("\n"); 
		query.append("           (A.ALOC_RF_QTY)            AS ALOC_RF_QTY      ," ).append("\n"); 
		query.append("           (A.ALOC_TTL_WGT)           AS ALOC_TTL_WGT     ,         " ).append("\n"); 
		query.append("           (NVL(A.BKG_20FT_QTY, 0) + NVL(A.BKG_40FT_QTY, 0) * 2 + NVL(A.BKG_40FT_HC_QTY, 0) * 2 + NVL(A.BKG_45FT_HC_QTY, 0) * 2 + NVL(A.BKG_53FT_QTY, 0) * 2) AS BKG_TTL_TEU_QTY," ).append("\n"); 
		query.append("           (A.BKG_20FT_QTY)           AS BKG_20FT_QTY     ," ).append("\n"); 
		query.append("           (A.BKG_40FT_QTY)           AS BKG_40FT_QTY ," ).append("\n"); 
		query.append("           (A.BKG_40FT_HC_QTY)        AS BKG_40FT_HC_QTY ," ).append("\n"); 
		query.append("           (A.BKG_45FT_HC_QTY)        AS BKG_45FT_HC_QTY ," ).append("\n"); 
		query.append("           (A.BKG_53FT_QTY)           AS BKG_53FT_QTY    ," ).append("\n"); 
		query.append("           (A.BKG_RF_QTY)             AS BKG_RF_QTY      ," ).append("\n"); 
		query.append("           (A.BKG_TTL_WGT)            AS BKG_TTL_WGT     " ).append("\n"); 
		query.append("           ,DECODE(A.USA_BKG_MOD_CD, 'OTH', 'OTHERS', A.USA_BKG_MOD_CD) USA_BKG_MOD_CD" ).append("\n"); 
		query.append("--           ,DECODE(A.DEST_LOC_CD, 'XXXXX', 'OTHERS', A.DEST_LOC_CD) DEST_LOC_CD  " ).append("\n"); 
		query.append("           ,NVL(A.FCAST_20FT_DRY_QTY, 0) FCAST_20FT_DRY_QTY" ).append("\n"); 
		query.append("           ,NVL(A.FCAST_40FT_DRY_QTY, 0) FCAST_40FT_DRY_QTY        " ).append("\n"); 
		query.append("           ,NVL(A.FCAST_RD_QTY, 0) FCAST_RD_QTY" ).append("\n"); 
		query.append("           ,NVL(A.BKG_20FT_DRY_QTY, 0) BKG_20FT_DRY_QTY" ).append("\n"); 
		query.append("           ,NVL(A.BKG_40FT_DRY_QTY, 0) BKG_40FT_DRY_QTY" ).append("\n"); 
		query.append("           ,NVL(A.BKG_RD_QTY, 0) BKG_RD_QTY" ).append("\n"); 
		query.append("           ,NVl(A.ALOC_20FT_DRY_QTY, 0) ALOC_20FT_DRY_QTY" ).append("\n"); 
		query.append("           ,NVl(A.ALOC_40FT_DRY_QTY, 0)  ALOC_40FT_DRY_QTY " ).append("\n"); 
		query.append("           ,NVl(A.ALOC_RD_QTY, 0) ALOC_RD_QTY" ).append("\n"); 
		query.append("            --FCAST_20FT_DRY_QTY, FCAST_40FT_DRY_QTY, FCAST_RD_QTY, BKG_20FT_DRY_QTY, BKG_40FT_DRY_QTY, BKG_RD_QTY, ALOC_20FT_DRY_QTY, ALOC_40FT_DRY_QTY, ALOC_RD_QTY            " ).append("\n"); 
		query.append("      FROM SPC_DLY_FCAST_SLS_REP_HIS A," ).append("\n"); 
		query.append("           MAS_MON_VVD               V," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT /*+ NO_MERGE */ TO_CHAR(TO_DATE('20130413','YYYYMMDD') +LEVEL-1,'YYYYMMDD') AS D_DT" ).append("\n"); 
		query.append("            FROM   DUAL" ).append("\n"); 
		query.append("            CONNECT BY LEVEL <= ( SYSDATE +1 ) - TO_DATE('20130413','YYYYMMDD') " ).append("\n"); 
		query.append("           )  D" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("    #if (${vvd} != '')" ).append("\n"); 
		query.append("       AND V.VSL_CD     = @[vslcd]" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO = @[skdvoyno]" ).append("\n"); 
		query.append("       AND V.DIR_CD     = @[skddircd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vvd} == '')" ).append("\n"); 
		query.append("    	#if (${trade} != '')" ).append("\n"); 
		query.append("       AND V.TRD_CD     = @[trade]" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	#if (${subTrade} != '')" ).append("\n"); 
		query.append("       AND V.SUB_TRD_CD = @[subTrade]" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	#if (${lane} != '')" ).append("\n"); 
		query.append("       AND V.RLANE_CD   = @[lane]" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	#if (${bound} != '')" ).append("\n"); 
		query.append("       AND V.DIR_CD     = @[bound]" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vvd} == '')" ).append("\n"); 
		query.append("       AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK  IN ( SELECT /*+ INDEX(P XPKMAS_WK_PRD) */" ).append("\n"); 
		query.append("                                                               P.COST_YR||P.COST_WK" ).append("\n"); 
		query.append("                                                          FROM MAS_WK_PRD P" ).append("\n"); 
		query.append("                                                         WHERE P.COST_YR||P.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("                                                           AND ROWNUM <= @[duration] )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       AND A.IOC_TS_CD  = @[ioc]" ).append("\n"); 
		query.append("    #if (${salesOffice} != '' && ${subOffice} == '')" ).append("\n"); 
		query.append("       AND A.SLS_RGN_OFC_CD = @[salesOffice]" ).append("\n"); 
		query.append("       AND A.OFC_KND_CD     = '3'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if ((${subOffice} != '' && ${salesOffice} == '') || (${subOffice} != '' && ${salesOffice} != ''))" ).append("\n"); 
		query.append("       AND A.SLS_OFC_CD = @[subOffice]" ).append("\n"); 
		query.append("       AND A.OFC_KND_CD     = '4'" ).append("\n"); 
		query.append("       AND A.SREP_CD       != '00000' -- 20130523 추가 SMK" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND A.RLANE_CD    = V.RLANE_CD" ).append("\n"); 
		query.append("       AND A.TRD_CD      = V.TRD_CD" ).append("\n"); 
		query.append("       AND A.SUB_TRD_CD  = V.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND A.VSL_CD      = V.VSL_CD" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO  = V.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD  = V.DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND A.CTRT_CUST_CNT_CD = '00'" ).append("\n"); 
		query.append("       AND A.CTRT_CUST_SEQ    = 0" ).append("\n"); 
		query.append("       --AND A.BSE_DT >= '20130413'" ).append("\n"); 
		query.append("       AND A.BSE_DT = D.D_DT" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT A.TRD_CD     AS TRD_CD    ," ).append("\n"); 
		query.append("           A.SUB_TRD_CD AS SUB_TRD_CD," ).append("\n"); 
		query.append("           A.RLANE_CD   AS RLANE_CD  ," ).append("\n"); 
		query.append("           A.SKD_DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("           DECODE(A.IOC_TS_CD, 'O', 'OCN', 'I', 'IPC', 'TS') AS IOC_CD    ," ).append("\n"); 
		query.append("           DECODE(A.SLS_OFC_CD, '', '+', A.SLS_OFC_CD)       AS SLS_OFC_CD," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK              AS BSE_WK    ," ).append("\n"); 
		query.append("           V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD                  AS VVD       ," ).append("\n"); 
		query.append("           A.BSE_DT                                          AS BSE_DT    ," ).append("\n"); 
		query.append("          'C' AS CUST_CTRL_CD," ).append("\n"); 
		query.append("           DECODE(A.POL_YD_CD, '', '+', A.POL_YD_CD)         AS POL_CD    ," ).append("\n"); 
		query.append("           DECODE(A.POD_YD_CD, '', '+', A.POD_YD_CD)         AS POD_CD    ," ).append("\n"); 
		query.append("           NVL(A.FCAST_LOD_QTY, 0) + NVL(A.FCAST_40FT_HC_QTY, 0) * 2 + NVL(A.FCAST_45FT_HC_QTY, 0) * 2 + NVL(A.FCAST_53FT_QTY, 0) * 2 AS FCAST_TTL_TEU_QTY," ).append("\n"); 
		query.append("           NVL(A.FCAST_LOD_QTY, 0)     AS FCAST_LOD_QTY    ," ).append("\n"); 
		query.append("           A.FCAST_40FT_HC_QTY      AS FCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("           A.FCAST_45FT_HC_QTY      AS FCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("           A.FCAST_53FT_QTY         AS FCAST_53FT_QTY   ," ).append("\n"); 
		query.append("           A.FCAST_RF_QTY           AS FCAST_RF_QTY     ," ).append("\n"); 
		query.append("           A.FCAST_TTL_WGT          AS FCAST_TTL_WGT    ," ).append("\n"); 
		query.append("           0 AS CFCAST_TTL_TEU_QTY," ).append("\n"); 
		query.append("           0 AS CFCAST_LOD_QTY    ," ).append("\n"); 
		query.append("           0 AS CFCAST_40FT_HC_QTY," ).append("\n"); 
		query.append("           0 AS CFCAST_45FT_HC_QTY," ).append("\n"); 
		query.append("           0 AS CFCAST_53FT_QTY   ," ).append("\n"); 
		query.append("           0 AS CFCAST_RF_QTY     ," ).append("\n"); 
		query.append("           0 AS CFCAST_TTL_WGT    ," ).append("\n"); 
		query.append("           A.ALOC_LOD_QTY           AS ALOC_TTL_QTY     ," ).append("\n"); 
		query.append("           A.ALOC_40FT_HC_QTY       AS ALOC_40FT_HC_QTY ," ).append("\n"); 
		query.append("           A.ALOC_45FT_HC_QTY       AS ALOC_45FT_HC_QTY ," ).append("\n"); 
		query.append("           A.ALOC_53FT_QTY          AS ALOC_53FT_QTY    ," ).append("\n"); 
		query.append("           A.ALOC_RF_QTY            AS ALOC_RF_QTY      ," ).append("\n"); 
		query.append("           A.ALOC_TTL_WGT           AS ALOC_TTL_WGT     ,         " ).append("\n"); 
		query.append("           0 AS BKG_TTL_TEU_QTY," ).append("\n"); 
		query.append("           0 AS BKG_20FT_QTY     ," ).append("\n"); 
		query.append("           0 AS BKG_40FT_QTY ," ).append("\n"); 
		query.append("           0 AS BKG_40FT_HC_QTY ," ).append("\n"); 
		query.append("           0 AS BKG_45FT_HC_QTY ," ).append("\n"); 
		query.append("           0 AS BKG_53FT_QTY    ," ).append("\n"); 
		query.append("           0 AS BKG_RF_QTY      ," ).append("\n"); 
		query.append("           0 AS BKG_TTL_WGT" ).append("\n"); 
		query.append("           ,DECODE(A.USA_BKG_MOD_CD, 'OTH', 'OTHERS', A.USA_BKG_MOD_CD) USA_BKG_MOD_CD" ).append("\n"); 
		query.append("--           ,DECODE(A.DEST_LOC_CD, 'XXXXX', 'OTHERS', A.DEST_LOC_CD) DEST_LOC_CD  " ).append("\n"); 
		query.append("           ,NVl(A.FCAST_20FT_DRY_QTY, 0) FCAST_20FT_DRY_QTY" ).append("\n"); 
		query.append("           ,NVl(A.FCAST_40FT_DRY_QTY , 0) FCAST_40FT_DRY_QTY          " ).append("\n"); 
		query.append("           ,NVl(A.FCAST_RD_QTY, 0) FCAST_RD_QTY" ).append("\n"); 
		query.append("           ,0 BKG_20FT_DRY_QTY" ).append("\n"); 
		query.append("           ,0 BKG_40FT_DRY_QTY" ).append("\n"); 
		query.append("           ,0 BKG_RD_QTY" ).append("\n"); 
		query.append("           ,NVl(A.ALOC_20FT_DRY_QTY, 0) ALOC_20FT_DRY_QTY" ).append("\n"); 
		query.append("           ,NVl(A.ALOC_40FT_DRY_QTY, 0)  ALOC_40FT_DRY_QTY " ).append("\n"); 
		query.append("           ,NVl(A.ALOC_RD_QTY, 0) ALOC_RD_QTY" ).append("\n"); 
		query.append("            --FCAST_20FT_DRY_QTY, FCAST_40FT_DRY_QTY, FCAST_RD_QTY, ALOC_20FT_DRY_QTY, ALOC_40FT_DRY_QTY, ALOC_RD_QTY " ).append("\n"); 
		query.append("      FROM SPC_DLY_FCAST_HIS A," ).append("\n"); 
		query.append("           MAS_MON_VVD       V" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("    #if (${vvd} != '')" ).append("\n"); 
		query.append("       AND V.VSL_CD     = @[vslcd]" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO = @[skdvoyno]" ).append("\n"); 
		query.append("       AND V.DIR_CD     = @[skddircd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vvd} == '')" ).append("\n"); 
		query.append("    	#if (${trade} != '')" ).append("\n"); 
		query.append("       AND V.TRD_CD     = @[trade]" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	#if (${subTrade} != '')" ).append("\n"); 
		query.append("       AND V.SUB_TRD_CD = @[subTrade]" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	#if (${lane} != '')" ).append("\n"); 
		query.append("       AND V.RLANE_CD   = @[lane]" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	#if (${bound} != '')" ).append("\n"); 
		query.append("       AND V.DIR_CD     = @[bound]" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vvd} == '')" ).append("\n"); 
		query.append("       AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK  IN ( SELECT /*+ INDEX(P XPKMAS_WK_PRD) */" ).append("\n"); 
		query.append("                                                               P.COST_YR||P.COST_WK" ).append("\n"); 
		query.append("                                                          FROM MAS_WK_PRD P" ).append("\n"); 
		query.append("                                                         WHERE P.COST_YR||P.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("                                                           AND ROWNUM <= @[duration] )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       AND A.IOC_TS_CD  = @[ioc]" ).append("\n"); 
		query.append("    #if (${salesOffice} != '' && ${subOffice} == '')" ).append("\n"); 
		query.append("       AND A.SLS_RGN_OFC_CD = @[salesOffice]" ).append("\n"); 
		query.append("       AND A.OFC_KND_CD     = '3'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if ((${subOffice} != '' && ${salesOffice} == '') || (${subOffice} != '' && ${salesOffice} != ''))" ).append("\n"); 
		query.append("       AND A.SLS_OFC_CD = @[subOffice]" ).append("\n"); 
		query.append("       AND A.OFC_KND_CD     = '4'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       AND A.RLANE_CD    = V.RLANE_CD" ).append("\n"); 
		query.append("       AND A.TRD_CD      = V.TRD_CD" ).append("\n"); 
		query.append("       AND A.SUB_TRD_CD  = V.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND A.VSL_CD      = V.VSL_CD" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO  = V.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD  = V.DIR_CD" ).append("\n"); 
		query.append("       AND A.BSE_DT < '20130413'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("--                         (A.TRD_CD, A.SUB_TRD_CD,A.RLANE_CD, A.SKD_DIR_CD, BSE_WK, VVD, A.IOC_CD, A.BSE_DT, A.CUST_CTRL_CD, A.SLS_OFC_CD, USA_BKG_MOD_CD, POL_CD, POD_CD, DEST_LOC_CD)," ).append("\n"); 
		query.append("                         (A.TRD_CD, A.SUB_TRD_CD,A.RLANE_CD, A.SKD_DIR_CD, BSE_WK, VVD, A.IOC_CD, A.BSE_DT, A.CUST_CTRL_CD, A.SLS_OFC_CD, USA_BKG_MOD_CD, POL_CD, POD_CD)," ).append("\n"); 
		query.append("                         (A.TRD_CD, A.SUB_TRD_CD,A.RLANE_CD, A.SKD_DIR_CD, BSE_WK, VVD, A.IOC_CD, A.BSE_DT, A.CUST_CTRL_CD, A.SLS_OFC_CD, USA_BKG_MOD_CD, POL_CD)," ).append("\n"); 
		query.append("                         (A.TRD_CD, A.SUB_TRD_CD,A.RLANE_CD, A.SKD_DIR_CD, BSE_WK, VVD, A.IOC_CD, A.BSE_DT, A.CUST_CTRL_CD, A.SLS_OFC_CD, USA_BKG_MOD_CD)," ).append("\n"); 
		query.append("                         (A.TRD_CD, A.SUB_TRD_CD,A.RLANE_CD, A.SKD_DIR_CD, BSE_WK, VVD, A.IOC_CD, A.BSE_DT, A.CUST_CTRL_CD, A.SLS_OFC_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY A.TRD_CD    ," ).append("\n"); 
		query.append("          A.SUB_TRD_CD," ).append("\n"); 
		query.append("          A.RLANE_CD  ," ).append("\n"); 
		query.append("          A.SKD_DIR_CD," ).append("\n"); 
		query.append("          BSE_WK DESC," ).append("\n"); 
		query.append("          VVD           ," ).append("\n"); 
		query.append("          IOC_CD   ," ).append("\n"); 
		query.append("          SLS_OFC_CD  ," ).append("\n"); 
		query.append("          BSE_DT    DESC," ).append("\n"); 
		query.append("          CUST_CTRL_CD  ," ).append("\n"); 
		query.append("--          LVL           ," ).append("\n"); 
		query.append("		  USA_BKG_MOD_CD," ).append("\n"); 
		query.append("          NVL(POL_CD, 'zzzzz') DESC," ).append("\n"); 
		query.append("          NVL(POD_CD, 'zzzzz') DESC" ).append("\n"); 

	}
}