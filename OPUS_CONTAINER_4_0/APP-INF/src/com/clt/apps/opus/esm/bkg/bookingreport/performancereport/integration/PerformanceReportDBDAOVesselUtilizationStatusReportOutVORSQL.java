/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PerformanceReportDBDAOVesselUtilizationStatusReportOutVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOVesselUtilizationStatusReportOutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public PerformanceReportDBDAOVesselUtilizationStatusReportOutVORSQL(){
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
		params.put("etd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cmd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOVesselUtilizationStatusReportOutVORSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("FIN.*" ).append("\n"); 
		query.append(", MAX(COUNT_PORT_SEQ) OVER() AS MAX_PORT_SEQ" ).append("\n"); 
		query.append(", UTIL_E||'%' AS UTIL_E_PCT" ).append("\n"); 
		query.append(", UTIL_W||'%' AS UTIL_W_PCT" ).append("\n"); 
		query.append(", PORT_LOD_PCT_INT||'%' AS PORT_LOD_PCT" ).append("\n"); 
		query.append(", DECODE(CEIL(PORT_LOD_PCT_INT/80),2,'','1') AS UTIL_INDI" ).append("\n"); 
		query.append(", DECODE(SKD_DIR_CD ,'W',' ','N',' ',CASE WHEN UTIL_E < 70 THEN 'RED'" ).append("\n"); 
		query.append("                                   WHEN UTIL_E >= 70 AND UTIL_E < 90 THEN 'PURPLE'" ).append("\n"); 
		query.append("                                   ELSE 'BLUE'END" ).append("\n"); 
		query.append("         ) AS UTIL_E_COLOR" ).append("\n"); 
		query.append(", DECODE(SKD_DIR_CD ,'E',' ','S',' ', CASE WHEN UTIL_W < 70 THEN 'RED'" ).append("\n"); 
		query.append("                                    WHEN UTIL_W >= 70 AND UTIL_W < 90 THEN 'PURPLE'" ).append("\n"); 
		query.append("                                    ELSE 'BLUE'" ).append("\n"); 
		query.append("                                    END" ).append("\n"); 
		query.append("         ) AS UTIL_W_COLOR  " ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  SLAN_CD" ).append("\n"); 
		query.append(", VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", POL_YD_CD" ).append("\n"); 
		query.append(", FCMD as F_CMD" ).append("\n"); 
		query.append(", VVD_SEQ" ).append("\n"); 
		query.append(", PORT_SEQ" ).append("\n"); 
		query.append(", COUNT(VVD_SEQ) OVER(PARTITION BY ORDERBY,VVD_SEQ) AS COUNT_PORT_SEQ" ).append("\n"); 
		query.append(", BSA" ).append("\n"); 
		query.append(", ROUND((TTL_E+TTL_S)/DECODE(NVL(BSA,1),0,1,NVL(BSA,1))*100) AS UTIL_E" ).append("\n"); 
		query.append(", ROUND((TTL_W+TTL_N)/DECODE(NVL(BSA,1),0,1,NVL(BSA,1))*100) AS UTIL_W" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TTL_E+TTL_S,'99,990.9')) AS TTL_E" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TTL_W+TTL_N,'99,990.9')) AS TTL_W" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(", TRIM(TO_CHAR(SUB_TOT_LOD_LOCAL_E+SUB_TOT_LOD_LOCAL_S,'99,990.9')) AS SUB_TOT_LOD_LOCAL_E" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(SUB_TOT_LOD_TS_E+SUB_TOT_LOD_TS_S,'99,990.9')) AS SUB_TOT_LOD_TS_E" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(SUB_TOT_LOD_IPC_E+SUB_TOT_LOD_IPC_S,'99,990.9')) AS SUB_TOT_LOD_IPC_E" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(SUB_TOT_LOD_TPS_E+SUB_TOT_LOD_TPS_S,'99,990.9')) AS SUB_TOT_LOD_TPS_E" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(SUB_TOT_LOD_EUR_E+SUB_TOT_LOD_EUR_S,'99,990.9')) AS SUB_TOT_LOD_EUR_E" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(SUB_TOT_LOD_MTY_E+SUB_TOT_LOD_MTY_S,'99,990.9')) AS SUB_TOT_LOD_MTY_E" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(SUB_TOT_LOD_LOCAL_W+SUB_TOT_LOD_LOCAL_N,'99,990.9')) AS SUB_TOT_LOD_LOCAL_W" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(SUB_TOT_LOD_TS_W+SUB_TOT_LOD_TS_N,'99,990.9')) AS SUB_TOT_LOD_TS_W" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(SUB_TOT_LOD_IPC_W+SUB_TOT_LOD_IPC_N,'99,990.9')) AS SUB_TOT_LOD_IPC_W" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(SUB_TOT_LOD_TPS_W+SUB_TOT_LOD_TPS_N,'99,990.9')) AS SUB_TOT_LOD_TPS_W" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(SUB_TOT_LOD_EUR_W+SUB_TOT_LOD_EUR_N,'99,990.9')) AS SUB_TOT_LOD_EUR_W" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(SUB_TOT_LOD_MTY_W+SUB_TOT_LOD_MTY_N,'99,990.9')) AS SUB_TOT_LOD_MTY_W" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",DECODE(VPS_PORT_CD,'OTHERS',VPS_PORT_CD||'('||DECODE(POD_OTH,NULL,'','DIS:'||POD_OTH||'  ')||DECODE(POL_OTH,NULL,'','LOD:'||POL_OTH)||')',VPS_PORT_CD) AS VPS_PORT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", SUBSTR(VPS_ETA_DT,6) AS VPS_ETA_DT" ).append("\n"); 
		query.append(", SUBSTR(VPS_ETD_DT,6) AS VPS_ETD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* LOD부분은 첫번째 포트에서 이전배에서 로딩된 수량을 표시한다.*/" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(LOD_LOCAL, '99,990.9'))||DECODE(PORT_SEQ,1,DECODE(PRE_LOD_LOCAL,0,'','('||TRIM(TO_CHAR(PRE_LOD_LOCAL,'99,990.9'))||')'),'') AS LOD_LOCAL" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(LOD_TS, '99,990.9'))||DECODE(PORT_SEQ,1,DECODE(PRE_LOD_TS,0,'','('||TRIM(TO_CHAR(PRE_LOD_TS,'99,990.9'))||')'),'') AS LOD_TS" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(LOD_IPC, '99,990.9'))||DECODE(PORT_SEQ,1,DECODE(PRE_LOD_IPC,0,'','('||TRIM(TO_CHAR(PRE_LOD_IPC,'99,990.9'))||')'),'') AS LOD_IPC" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(LOD_TPS, '99,990.9'))||DECODE(PORT_SEQ,1,DECODE(PRE_LOD_TPS,0,'','('||TRIM(TO_CHAR(PRE_LOD_TPS,'99,990.9'))||')'),'') AS LOD_TPS" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(LOD_EUR, '99,990.9'))||DECODE(PORT_SEQ,1,DECODE(PRE_LOD_EUR,0,'','('||TRIM(TO_CHAR(PRE_LOD_EUR,'99,990.9'))||')'),'') AS LOD_EUR" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(LOD_MTY, '99,990.9'))||DECODE(PORT_SEQ,1,DECODE(PRE_LOD_MTY,0,'','('||TRIM(TO_CHAR(PRE_LOD_MTY,'99,990.9'))||')'),'') AS LOD_MTY" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(LOD_TTL, '99,990.9'))||DECODE(PORT_SEQ,1,DECODE(PRE_LOD_LOCAL+PRE_LOD_TS+PRE_LOD_MTY,0,'','('||TRIM(TO_CHAR(PRE_LOD_LOCAL+PRE_LOD_TS+PRE_LOD_MTY,'99,990.9'))||')'),'') AS LOD_TTL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" /* RAW DATA SHEET의 이전배 물량 표시: 첫번째 포트에서 이후 내릴 전배의 물량을 모두 더해주고, 두번째 포트 부터는 그 포트에서 내릴 이전배 물량을 마이너스로 표시한다.*/" ).append("\n"); 
		query.append(" /* 즉 첫번째 포트의 이전배 로딩 물량은 이후에 내릴 이전배 물량을 더한 합이 된다.*/" ).append("\n"); 
		query.append(", DECODE(PORT_SEQ,1, DECODE(PRE_LOD_LOCAL+PRE_LOD_TS+PRE_LOD_MTY,0,'', TRIM(TO_CHAR(PRE_LOD_LOCAL+PRE_LOD_TS+PRE_LOD_MTY,'99,990.9'))), " ).append("\n"); 
		query.append("                     DECODE(PRE_DIS_LOCAL+PRE_DIS_TS+PRE_DIS_MTY,0,'', '-'||TRIM(TO_CHAR(PRE_DIS_LOCAL+PRE_DIS_TS+PRE_DIS_MTY,'99,990.9'))) ) AS LAST_PORT_LOADING" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* 이전배에서 내린 수량을 표시한다.*/" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(DIS_LOCAL, '99,990.9'))||DECODE(PRE_DIS_LOCAL,0,'','('||TRIM(TO_CHAR(PRE_DIS_LOCAL,'99,990.9'))||')') AS DIS_LOCAL " ).append("\n"); 
		query.append(", TRIM(TO_CHAR(DIS_TS, '99,990.9'))||DECODE(PRE_DIS_TS,0,'','('||TRIM(TO_CHAR(PRE_DIS_TS,'99,990.9'))||')') AS DIS_TS " ).append("\n"); 
		query.append(", TRIM(TO_CHAR(DIS_IPC, '99,990.9'))||DECODE(PRE_DIS_IPC,0,'','('||TRIM(TO_CHAR(PRE_DIS_IPC,'99,990.9'))||')') AS DIS_IPC " ).append("\n"); 
		query.append(", TRIM(TO_CHAR(DIS_TPS, '99,990.9'))||DECODE(PRE_DIS_TPS,0,'','('||TRIM(TO_CHAR(PRE_DIS_TPS,'99,990.9'))||')') AS DIS_TPS " ).append("\n"); 
		query.append(", TRIM(TO_CHAR(DIS_EUR, '99,990.9'))||DECODE(PRE_DIS_EUR,0,'','('||TRIM(TO_CHAR(PRE_DIS_EUR,'99,990.9'))||')') AS DIS_EUR " ).append("\n"); 
		query.append(", TRIM(TO_CHAR(DIS_MTY, '99,990.9'))||DECODE(PRE_DIS_MTY,0,'','('||TRIM(TO_CHAR(PRE_DIS_MTY,'99,990.9'))||')') AS DIS_MTY " ).append("\n"); 
		query.append(", TRIM(TO_CHAR(DIS_TTL, '99,990.9'))||DECODE(PRE_DIS_LOCAL+PRE_DIS_TS+PRE_DIS_MTY,0,'','('||TRIM(TO_CHAR(PRE_DIS_LOCAL+PRE_DIS_TS+PRE_DIS_MTY,'99,990.9'))||')')  AS DIS_TTL " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(ROB_LOCAL,'99,990.9')) AS ROB_LOCAL" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(ROB_TS,'99,990.9')) AS ROB_TS" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(ROB_IPC,'99,990.9')) AS ROB_IPC" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(ROB_TPS,'99,990.9')) AS ROB_TPS" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(ROB_EUR,'99,990.9')) AS ROB_EUR" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(ROB_MTY,'99,990.9')) AS ROB_MTY" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(ROB_TOT,'99,990.9')) AS ROB_TOT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ROUND((ROB_TOT)/DECODE(BSA,0,1,BSA)*100) AS PORT_LOD_PCT_INT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TOT_LOD_LOCAL_E+TOT_LOD_LOCAL_S,'99,990.9')) AS TOT_LOD_LOCAL_E" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TOT_LOD_TS_E+TOT_LOD_TS_S,'99,990.9')) AS TOT_LOD_TS_E" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TOT_LOD_IPC_E+TOT_LOD_IPC_S,'99,990.9')) AS TOT_LOD_IPC_E" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TOT_LOD_TPS_E+TOT_LOD_TPS_S,'99,990.9')) AS TOT_LOD_TPS_E" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TOT_LOD_EUR_E+TOT_LOD_EUR_S,'99,990.9')) AS TOT_LOD_EUR_E" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TOT_LOD_MTY_E+TOT_LOD_MTY_S,'99,990.9')) AS TOT_LOD_MTY_E" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TOT_LOD_LOCAL_W+TOT_LOD_LOCAL_N,'99,990.9')) AS TOT_LOD_LOCAL_W" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TOT_LOD_TS_W+TOT_LOD_TS_N,'99,990.9')) AS TOT_LOD_TS_W" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TOT_LOD_IPC_W+TOT_LOD_IPC_N,'99,990.9')) AS TOT_LOD_IPC_W" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TOT_LOD_TPS_W+TOT_LOD_TPS_N,'99,990.9')) AS TOT_LOD_TPS_W" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TOT_LOD_EUR_W+TOT_LOD_EUR_N,'99,990.9')) AS TOT_LOD_EUR_W" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TOT_LOD_MTY_W+TOT_LOD_MTY_N,'99,990.9')) AS TOT_LOD_MTY_W" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TOT_BSA_E+TOT_BSA_S,'99,990.9')) AS TOT_BSA_E" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TOT_BSA_W+TOT_BSA_N,'99,990.9')) AS TOT_BSA_W  " ).append("\n"); 
		query.append(", ROUND((TOT_LOD_E+TOT_LOD_S)/DECODE(TOT_BSA_E+TOT_BSA_S,0,1,TOT_BSA_E+TOT_BSA_S)*100)||'%' AS TOT_LIFT_E_PCT" ).append("\n"); 
		query.append(", ROUND((TOT_LOD_W+TOT_LOD_N)/DECODE(TOT_BSA_W+TOT_BSA_N,0,1,TOT_BSA_W+TOT_BSA_N)*100)||'%' AS TOT_LIFT_W_PCT " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TOT_LOD_E+TOT_LOD_S,'99,990.9')) AS TOT_LOD_E" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(TOT_LOD_W+TOT_LOD_N,'99,990.9')) AS TOT_LOD_W" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        SUM(DECODE(SKD_DIR_CD, 'E', DECODE(PORT_SEQ, 1, SUB_TOT_LOD_LOCAL_E+SUB_TOT_LOD_TS_E+SUB_TOT_LOD_MTY_E, 0), 0)) OVER() AS TOT_LOD_E " ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD, 'W', DECODE(PORT_SEQ, 1, SUB_TOT_LOD_LOCAL_W+SUB_TOT_LOD_TS_W+SUB_TOT_LOD_MTY_W, 0), 0)) OVER() AS TOT_LOD_W " ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD, 'S', DECODE(PORT_SEQ, 1, SUB_TOT_LOD_LOCAL_S+SUB_TOT_LOD_TS_S+SUB_TOT_LOD_MTY_S, 0), 0)) OVER() AS TOT_LOD_S " ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD, 'N', DECODE(PORT_SEQ, 1, SUB_TOT_LOD_LOCAL_N+SUB_TOT_LOD_TS_N+SUB_TOT_LOD_MTY_N, 0), 0)) OVER() AS TOT_LOD_N " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'E',DECODE(PORT_SEQ,1,SUB_TOT_LOD_LOCAL_E,0),0)) OVER() AS TOT_LOD_LOCAL_E" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'E',DECODE(PORT_SEQ,1,SUB_TOT_LOD_TS_E,0),0)) OVER() AS TOT_LOD_TS_E" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'E',DECODE(PORT_SEQ,1,SUB_TOT_LOD_IPC_E,0),0)) OVER() AS TOT_LOD_IPC_E" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'E',DECODE(PORT_SEQ,1,SUB_TOT_LOD_TPS_E,0),0)) OVER() AS TOT_LOD_TPS_E" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'E',DECODE(PORT_SEQ,1,SUB_TOT_LOD_EUR_E,0),0)) OVER() AS TOT_LOD_EUR_E" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'E',DECODE(PORT_SEQ,1,SUB_TOT_LOD_MTY_E,0),0)) OVER() AS TOT_LOD_MTY_E" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'W',DECODE(PORT_SEQ,1,SUB_TOT_LOD_LOCAL_W,0),0)) OVER() AS TOT_LOD_LOCAL_W" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'W',DECODE(PORT_SEQ,1,SUB_TOT_LOD_TS_W,0),0)) OVER() AS TOT_LOD_TS_W" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'W',DECODE(PORT_SEQ,1,SUB_TOT_LOD_IPC_W,0),0)) OVER() AS TOT_LOD_IPC_W" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'W',DECODE(PORT_SEQ,1,SUB_TOT_LOD_TPS_W,0),0)) OVER() AS TOT_LOD_TPS_W" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'W',DECODE(PORT_SEQ,1,SUB_TOT_LOD_EUR_W,0),0)) OVER() AS TOT_LOD_EUR_W      " ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'W',DECODE(PORT_SEQ,1,SUB_TOT_LOD_MTY_W,0),0)) OVER() AS TOT_LOD_MTY_W" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'S',DECODE(PORT_SEQ,1,SUB_TOT_LOD_LOCAL_E,0),0)) OVER() AS TOT_LOD_LOCAL_S" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'S',DECODE(PORT_SEQ,1,SUB_TOT_LOD_TS_E,0),0)) OVER() AS TOT_LOD_TS_S" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'S',DECODE(PORT_SEQ,1,SUB_TOT_LOD_IPC_E,0),0)) OVER() AS TOT_LOD_IPC_S" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'S',DECODE(PORT_SEQ,1,SUB_TOT_LOD_TPS_E,0),0)) OVER() AS TOT_LOD_TPS_S" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'S',DECODE(PORT_SEQ,1,SUB_TOT_LOD_EUR_E,0),0)) OVER() AS TOT_LOD_EUR_S" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'S',DECODE(PORT_SEQ,1,SUB_TOT_LOD_MTY_E,0),0)) OVER() AS TOT_LOD_MTY_S" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'N',DECODE(PORT_SEQ,1,SUB_TOT_LOD_LOCAL_W,0),0)) OVER() AS TOT_LOD_LOCAL_N" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'N',DECODE(PORT_SEQ,1,SUB_TOT_LOD_TS_W,0),0)) OVER() AS TOT_LOD_TS_N" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'N',DECODE(PORT_SEQ,1,SUB_TOT_LOD_IPC_W,0),0)) OVER() AS TOT_LOD_IPC_N" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'N',DECODE(PORT_SEQ,1,SUB_TOT_LOD_TPS_W,0),0)) OVER() AS TOT_LOD_TPS_N" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'N',DECODE(PORT_SEQ,1,SUB_TOT_LOD_EUR_W,0),0)) OVER() AS TOT_LOD_EUR_N" ).append("\n"); 
		query.append("       ,SUM(DECODE(SKD_DIR_CD,'N',DECODE(PORT_SEQ,1,SUB_TOT_LOD_MTY_W,0),0)) OVER() AS TOT_LOD_MTY_N" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("	   ,SUB_TOT_LOD_LOCAL_E +SUB_TOT_LOD_TS_E+SUB_TOT_LOD_MTY_E AS TTL_E " ).append("\n"); 
		query.append("       ,SUB_TOT_LOD_LOCAL_S +SUB_TOT_LOD_TS_S+SUB_TOT_LOD_MTY_S AS TTL_S " ).append("\n"); 
		query.append("       ,SUB_TOT_LOD_LOCAL_W +SUB_TOT_LOD_TS_W+SUB_TOT_LOD_MTY_W AS TTL_W " ).append("\n"); 
		query.append("       ,SUB_TOT_LOD_LOCAL_N +SUB_TOT_LOD_TS_N+SUB_TOT_LOD_MTY_N AS TTL_N " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , SUM(DECODE(SKD_DIR_CD,'E',DECODE(PORT_SEQ,1,BSA,0),0)) OVER() AS TOT_BSA_E" ).append("\n"); 
		query.append("      , SUM(DECODE(SKD_DIR_CD,'W',DECODE(PORT_SEQ,1,BSA,0),0)) OVER() AS TOT_BSA_W" ).append("\n"); 
		query.append("      , SUM(DECODE(SKD_DIR_CD,'S',DECODE(PORT_SEQ,1,BSA,0),0)) OVER() AS TOT_BSA_S" ).append("\n"); 
		query.append("      , SUM(DECODE(SKD_DIR_CD,'N',DECODE(PORT_SEQ,1,BSA,0),0)) OVER() AS TOT_BSA_N" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("      , LOD_LOCAL + LOD_TS + LOD_MTY AS LOD_TTL " ).append("\n"); 
		query.append("      , DIS_LOCAL + DIS_TS + DIS_MTY AS DIS_TTL " ).append("\n"); 
		query.append("      , ROB_LOCAL + ROB_TS + ROB_MTY AS ROB_TOT " ).append("\n"); 
		query.append("      , ZZ.*" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("         SUM(NOW_LOCAL) OVER (PARTITION BY VVD_SEQ ORDER BY PORT_SEQ) ROB_LOCAL" ).append("\n"); 
		query.append("         ,SUM(NOW_TS) OVER (PARTITION BY VVD_SEQ ORDER BY PORT_SEQ) ROB_TS" ).append("\n"); 
		query.append("         ,SUM(NOW_IPC) OVER (PARTITION BY VVD_SEQ ORDER BY PORT_SEQ) ROB_IPC" ).append("\n"); 
		query.append("         ,SUM(NOW_TPS) OVER (PARTITION BY VVD_SEQ ORDER BY PORT_SEQ) ROB_TPS" ).append("\n"); 
		query.append("         ,SUM(NOW_EUR) OVER (PARTITION BY VVD_SEQ ORDER BY PORT_SEQ) ROB_EUR" ).append("\n"); 
		query.append("         ,SUM(NOW_MTY) OVER (PARTITION BY VVD_SEQ ORDER BY PORT_SEQ) ROB_MTY" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'E',LOD_LOCAL,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_LOCAL_E" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'E',LOD_TS,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_TS_E" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'E',LOD_IPC,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_IPC_E" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'E',LOD_TPS,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_TPS_E" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'E',LOD_EUR,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_EUR_E" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'E',LOD_MTY,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_MTY_E" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'W',LOD_LOCAL,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_LOCAL_W" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'W',LOD_TS,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_TS_W" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'W',LOD_IPC,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_IPC_W" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'W',LOD_TPS,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_TPS_W" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'W',LOD_EUR,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_EUR_W" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'W',LOD_MTY,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_MTY_W" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'S',LOD_LOCAL,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_LOCAL_S" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'S',LOD_TS,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_TS_S" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'S',LOD_IPC,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_IPC_S" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'S',LOD_TPS,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_TPS_S" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'S',LOD_EUR,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_EUR_S" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'S',LOD_MTY,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_MTY_S" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'N',LOD_LOCAL,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_LOCAL_N" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'N',LOD_TS,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_TS_N" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'N',LOD_IPC,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_IPC_N" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'N',LOD_TPS,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_TPS_N" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'N',LOD_EUR,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_EUR_N" ).append("\n"); 
		query.append("         ,SUM(DECODE(SKD_DIR_CD,'N',LOD_MTY,0)) OVER (PARTITION BY VVD_SEQ) SUB_TOT_LOD_MTY_N " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         ,YY.*" ).append("\n"); 
		query.append("         FROM ( /*YY*/" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                    SELECT " ).append("\n"); 
		query.append("                       /* 이전배의 Dis합이 첫번째 포트의 Lod에 더한다. 즉 이전배의 Lod부분은 첫번째 포트에서만 의미가 있다. */" ).append("\n"); 
		query.append("                       LOD_LOCAL +DECODE(PORT_SEQ,1, PRE_LOD_LOCAL,0) - DIS_LOCAL - PRE_DIS_LOCAL  AS NOW_LOCAL" ).append("\n"); 
		query.append("                      ,LOD_TS    +DECODE(PORT_SEQ,1, PRE_LOD_TS,0) - DIS_TS - PRE_DIS_TS  AS NOW_TS" ).append("\n"); 
		query.append("                      ,LOD_IPC   +DECODE(PORT_SEQ,1, PRE_LOD_IPC,0) - DIS_IPC - PRE_DIS_IPC  AS NOW_IPC" ).append("\n"); 
		query.append("                      ,LOD_TPS   +DECODE(PORT_SEQ,1, PRE_LOD_TPS,0) - DIS_TPS - PRE_DIS_TPS  AS NOW_TPS" ).append("\n"); 
		query.append("                      ,LOD_EUR   +DECODE(PORT_SEQ,1, PRE_LOD_EUR,0) - DIS_EUR - PRE_DIS_EUR  AS NOW_EUR" ).append("\n"); 
		query.append("                      ,LOD_MTY   +DECODE(PORT_SEQ,1, PRE_LOD_MTY,0) - DIS_MTY - PRE_DIS_MTY  AS NOW_MTY" ).append("\n"); 
		query.append("                      , K.*" ).append("\n"); 
		query.append("                    FROM ( /* K */" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                            SELECT " ).append("\n"); 
		query.append("                            /* VVD별 이전배 총 로딩 수에서 현재까지 내릴 수량을 빼서 LOD에 더한다." ).append("\n"); 
		query.append("                             * 예) 이전배 IPC총수량:100 포트 A  DIS = 0 >>  PRE_LOD_IPC = 100" ).append("\n"); 
		query.append("                             *                       포트 B  DIS = 50 >>  PRE_LOD_IPC = 100 - (0+50) = 50" ).append("\n"); 
		query.append("                             *                       포트 C  DIS = 50 >>  PRE_LOD_IPC = 100 - (0+50+50) = 0" ).append("\n"); 
		query.append("                             * 현재 첫포트 이외에는 PRE_LOD..를 사용하지 않는다." ).append("\n"); 
		query.append("                             */" ).append("\n"); 
		query.append("                            PRE_DIS_LOCAL_TOT - PRE_DIS_LOCAL_SUM AS PRE_LOD_LOCAL," ).append("\n"); 
		query.append("                            PRE_DIS_TS_TOT  - PRE_DIS_TS_SUM  AS PRE_LOD_TS," ).append("\n"); 
		query.append("                            PRE_DIS_IPC_TOT - PRE_DIS_IPC_SUM AS PRE_LOD_IPC," ).append("\n"); 
		query.append("                            PRE_DIS_TPS_TOT - PRE_DIS_TPS_SUM AS PRE_LOD_TPS," ).append("\n"); 
		query.append("                            PRE_DIS_EUR_TOT - PRE_DIS_EUR_SUM AS PRE_LOD_EUR," ).append("\n"); 
		query.append("                            PRE_DIS_MTY_TOT - PRE_DIS_MTY_SUM AS PRE_LOD_MTY," ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                            YYYY.*" ).append("\n"); 
		query.append("                            FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                SELECT " ).append("\n"); 
		query.append("                                SUM(PRE_DIS_LOCAL) OVER(PARTITION BY VVD_SEQ ) PRE_DIS_LOCAL_TOT," ).append("\n"); 
		query.append("                                SUM(PRE_DIS_LOCAL) OVER(PARTITION BY VVD_SEQ ORDER BY PORT_SEQ) AS PRE_DIS_LOCAL_SUM," ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                SUM(PRE_DIS_TS) OVER(PARTITION BY VVD_SEQ ) PRE_DIS_TS_TOT," ).append("\n"); 
		query.append("                                SUM(PRE_DIS_TS) OVER(PARTITION BY VVD_SEQ ORDER BY PORT_SEQ) AS PRE_DIS_TS_SUM," ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                SUM(PRE_DIS_IPC) OVER(PARTITION BY VVD_SEQ ) PRE_DIS_IPC_TOT," ).append("\n"); 
		query.append("                                SUM(PRE_DIS_IPC) OVER(PARTITION BY VVD_SEQ ORDER BY PORT_SEQ) AS PRE_DIS_IPC_SUM," ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                SUM(PRE_DIS_TPS) OVER(PARTITION BY VVD_SEQ ) PRE_DIS_TPS_TOT," ).append("\n"); 
		query.append("                                SUM(PRE_DIS_TPS) OVER(PARTITION BY VVD_SEQ ORDER BY PORT_SEQ) AS PRE_DIS_TPS_SUM," ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                SUM(PRE_DIS_EUR) OVER(PARTITION BY VVD_SEQ ) PRE_DIS_EUR_TOT," ).append("\n"); 
		query.append("                                SUM(PRE_DIS_EUR) OVER(PARTITION BY VVD_SEQ ORDER BY PORT_SEQ) AS PRE_DIS_EUR_SUM," ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                SUM(PRE_DIS_MTY) OVER(PARTITION BY VVD_SEQ ) PRE_DIS_MTY_TOT," ).append("\n"); 
		query.append("                                SUM(PRE_DIS_MTY) OVER(PARTITION BY VVD_SEQ ORDER BY PORT_SEQ) AS PRE_DIS_MTY_SUM," ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                YYY.*" ).append("\n"); 
		query.append("                                FROM (" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                            SELECT VVD_SEQ" ).append("\n"); 
		query.append("                                                 ,PORT_SEQ" ).append("\n"); 
		query.append("                                                 ,PRE_VVD" ).append("\n"); 
		query.append("												 ,ORDERBY" ).append("\n"); 
		query.append("                                                 ,VPS_PORT_CD,SLAN_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,POL_YD_CD,BSA,FCMD,VPS_ETA_DT,VPS_ETD_DT" ).append("\n"); 
		query.append("                                                 ,LOD_LOCAL,LOD_TS,LOD_IPC,LOD_TPS,LOD_EUR,LOD_MTY" ).append("\n"); 
		query.append("                                                 ,DIS_LOCAL,DIS_TS,DIS_IPC,DIS_TPS,DIS_EUR,DIS_MTY" ).append("\n"); 
		query.append("                                                  ,TO_NUMBER(NVL(BKG_GET_TOKEN_FNC(PRE_DIS,1),0)) AS PRE_DIS_LOCAL" ).append("\n"); 
		query.append("                                                  ,TO_NUMBER(NVL(BKG_GET_TOKEN_FNC(PRE_DIS,2),0)) AS PRE_DIS_TS" ).append("\n"); 
		query.append("                                                 ,TO_NUMBER(NVL(BKG_GET_TOKEN_FNC(PRE_DIS,3),0)) AS PRE_DIS_IPC" ).append("\n"); 
		query.append("                                                 ,TO_NUMBER(NVL(BKG_GET_TOKEN_FNC(PRE_DIS,4),0)) AS PRE_DIS_TPS" ).append("\n"); 
		query.append("                                                 ,TO_NUMBER(NVL(BKG_GET_TOKEN_FNC(PRE_DIS,5),0)) AS PRE_DIS_EUR" ).append("\n"); 
		query.append("                                                 ,TO_NUMBER(NVL(BKG_GET_TOKEN_FNC(PRE_DIS,6),0)) AS PRE_DIS_MTY" ).append("\n"); 
		query.append("                                                ,POL_OTH,POD_OTH" ).append("\n"); 
		query.append("                                                 FROM ( /*YY*/" ).append("\n"); 
		query.append("                                                        SELECT " ).append("\n"); 
		query.append("                                                          XX.*" ).append("\n"); 
		query.append("														 , MIN(VPS_ETA_DT) OVER(PARTITION BY VVD_SEQ) AS ORDERBY" ).append("\n"); 
		query.append("                                                         , CASE WHEN PORT_SEQ > 1 AND VPS_ETA_DT <= PRE_MAX_ETD_DT THEN BKG_0746_PRE_PORT_DIS_FNC(PRE_VVD,VPS_PORT_CD) END AS PRE_DIS" ).append("\n"); 
		query.append("                                                        FROM ( /*XX*/" ).append("\n"); 
		query.append("                                                        " ).append("\n"); 
		query.append("                                                                SELECT " ).append("\n"); 
		query.append("                                                                  TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE,1)) AS VVD_SEQ" ).append("\n"); 
		query.append("                                                                , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE,2)) AS PORT_SEQ" ).append("\n"); 
		query.append("                                                                , BKG_GET_TOKEN_FNC(COLUMN_VALUE,3) AS VPS_PORT_CD" ).append("\n"); 
		query.append("                                                                , BKG_GET_TOKEN_FNC(COLUMN_VALUE,4) AS SLAN_CD" ).append("\n"); 
		query.append("                                                                , BKG_GET_TOKEN_FNC(COLUMN_VALUE,5) AS VSL_CD" ).append("\n"); 
		query.append("                                                                , BKG_GET_TOKEN_FNC(COLUMN_VALUE,6) AS SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                , BKG_GET_TOKEN_FNC(COLUMN_VALUE,7) AS SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                , BKG_GET_TOKEN_FNC(COLUMN_VALUE,8) AS POL_YD_CD" ).append("\n"); 
		query.append("                                                                , BKG_GET_TOKEN_FNC(COLUMN_VALUE,9) AS PRE_VVD" ).append("\n"); 
		query.append("                                                                , BKG_GET_TOKEN_FNC(COLUMN_VALUE,10) AS PRE_MAX_ETD_DT" ).append("\n"); 
		query.append("                                                                , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE,11)) AS BSA" ).append("\n"); 
		query.append("                                                                , BKG_GET_TOKEN_FNC(COLUMN_VALUE,12) AS FCMD" ).append("\n"); 
		query.append("                                                                , BKG_GET_TOKEN_FNC(COLUMN_VALUE,13) AS VPS_ETA_DT" ).append("\n"); 
		query.append("                                                                , BKG_GET_TOKEN_FNC(COLUMN_VALUE,14) AS VPS_ETD_DT" ).append("\n"); 
		query.append("                                                                " ).append("\n"); 
		query.append("                                                                , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE,15)) AS LOD_LOCAL" ).append("\n"); 
		query.append("                                                                , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE,16)) AS LOD_TS" ).append("\n"); 
		query.append("                                                                , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE,17)) AS LOD_IPC" ).append("\n"); 
		query.append("                                                                , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE,18)) AS LOD_TPS" ).append("\n"); 
		query.append("                                                                , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE,19)) AS LOD_EUR" ).append("\n"); 
		query.append("                                                                , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE,20)) AS LOD_MTY" ).append("\n"); 
		query.append("                                                                " ).append("\n"); 
		query.append("                                                                , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE,21)) AS DIS_LOCAL" ).append("\n"); 
		query.append("                                                                , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE,22)) AS DIS_TS" ).append("\n"); 
		query.append("                                                                , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE,23)) AS DIS_IPC" ).append("\n"); 
		query.append("                                                                , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE,24)) AS DIS_TPS" ).append("\n"); 
		query.append("                                                                , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE,25)) AS DIS_EUR" ).append("\n"); 
		query.append("                                                                , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE,26)) AS DIS_MTY" ).append("\n"); 
		query.append("                                                                " ).append("\n"); 
		query.append("                                                                , BKG_GET_TOKEN_FNC(COLUMN_VALUE,25) AS POL_OTH" ).append("\n"); 
		query.append("                                                                , BKG_GET_TOKEN_FNC(COLUMN_VALUE,26) AS POD_OTH" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                                FROM TABLE(BKG_SPLIT_CLOB_FNC((" ).append("\n"); 
		query.append("                                                                            SELECT BKG_JOIN_FULL_CLOB_FNC(CURSOR(" ).append("\n"); 
		query.append("                                                                                    SELECT RESULT" ).append("\n"); 
		query.append("                                                                                    FROM (" ).append("\n"); 
		query.append("                                                                                        SELECT" ).append("\n"); 
		query.append("                                                                                                BKG_0746_LIST2_ALL_FNC(VVD,V_SEQ,PRE_VVD||','||PRE_MAX_ETD_DT||','||BSA||','||F_CMD,'@') AS RESULT" ).append("\n"); 
		query.append("                                                                                        FROM (" ).append("\n"); 
		query.append("                                                                                                SELECT " ).append("\n"); 
		query.append("                                                                                                   ROWNUM||'' AS V_SEQ" ).append("\n"); 
		query.append("                                                                                                   ,BKG_0746_PREVVD_FNC(VVD) AS PRE_VVD" ).append("\n"); 
		query.append("                                                                                                   , BKG_0746_PRE_MAX_ETD_DT_FNC(VVD) AS PRE_MAX_ETD_DT" ).append("\n"); 
		query.append("                                                                                                  , X.*" ).append("\n"); 
		query.append("                                                                                                FROM (" ).append("\n"); 
		query.append("                                                                                                       SELECT DISTINCT SKD.VSL_CD || SKD.SKD_VOY_NO || SKD.SKD_DIR_CD VVD ," ).append("\n"); 
		query.append("                                                                                                       (SELECT SUM(FNL_CO_BSA_CAPA) FNL_CO_BSA_CAPA" ).append("\n"); 
		query.append("                                                                                                        FROM   BSA_VVD_MST" ).append("\n"); 
		query.append("                                                                                                        WHERE  VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("                                                                                                        AND    SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                                        AND    SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("																										AND    SUBSTR(RLANE_CD ,1,3) = SKD.SLAN_CD" ).append("\n"); 
		query.append("                                                                                                        GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD) BSA ," ).append("\n"); 
		query.append("                                                                                                       @[f_cmd] F_CMD ," ).append("\n"); 
		query.append("                                                                                                       SKD.SLAN_CD" ).append("\n"); 
		query.append("                                                                                                FROM   (SELECT DISTINCT SKD.VSL_CD ," ).append("\n"); 
		query.append("                                                                                                               SKD.SKD_VOY_NO ," ).append("\n"); 
		query.append("                                                                                                               SKD.SKD_DIR_CD ," ).append("\n"); 
		query.append("                                                                                                               SKD.SLAN_CD" ).append("\n"); 
		query.append("                                                                                                        FROM   VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                                                                                                        WHERE  1 = 1" ).append("\n"); 
		query.append("                                                                                                        #if (${slan_cd} != '')" ).append("\n"); 
		query.append("                                                                                                            AND SKD.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("                                                                                                        #end " ).append("\n"); 
		query.append("                                                                                                        #if (${vvd} != '')" ).append("\n"); 
		query.append("                                                                                                           AND SKD.VSL_CD = SUBSTR(@[vvd],0,4)" ).append("\n"); 
		query.append("                                                                                                           AND SKD.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                                                                                                           AND SKD.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                                                                                                        #end                                                                          " ).append("\n"); 
		query.append("                                                                                                        #if (${etd_from_dt} != '' &&  ${dt_tp} == '0')" ).append("\n"); 
		query.append("                                                                                                            AND SKD.VPS_ETD_DT  BETWEEN TO_DATE(@[etd_from_dt] || '00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[etd_to_dt] || '23:59:59','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("                                                                                                        #end" ).append("\n"); 
		query.append("                                                                                                         ) SKD ," ).append("\n"); 
		query.append("                                                                                                       VSK_VSL_SKD VSL ," ).append("\n"); 
		query.append("                                                                                                       COA_MON_VVD COA" ).append("\n"); 
		query.append("                                                                                                WHERE  SKD.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("                                                                                                AND    SKD.SKD_VOY_NO = VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                                AND    SKD.SKD_DIR_CD = VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                                --AND    VSL.SKD_STS_CD <> 'CLO'" ).append("\n"); 
		query.append("                                                                                                AND    SKD.VSL_CD = COA.VSL_CD(+)" ).append("\n"); 
		query.append("                                                                                                AND    SKD.SKD_VOY_NO = COA.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                                                                                                AND    SKD.SKD_DIR_CD = COA.DIR_CD(+)" ).append("\n"); 
		query.append("                                                                                                AND    WKY_TGT_FLG(+) ='Y'" ).append("\n"); 
		query.append("                                                                                                #if (${trd_cd} != '')" ).append("\n"); 
		query.append("                                                                                                   AND COA.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("                                                                                                #end" ).append("\n"); 
		query.append("                                                                                                #if (${sub_trd_cd} != '')" ).append("\n"); 
		query.append("                                                                                                   AND COA.SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("                                                                                                #end" ).append("\n"); 
		query.append("                                                                                                #if (${vsl_slan_dir_cd} != '')" ).append("\n"); 
		query.append("                                                                                                   AND COA.DIR_CD = @[vsl_slan_dir_cd]" ).append("\n"); 
		query.append("                                                                                                #end" ).append("\n"); 
		query.append("                                                                                                #if (${cost_year} != '' &&  ${dt_tp} == '1')" ).append("\n"); 
		query.append("                                                                                                   AND COA.COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("                                                                                                #end" ).append("\n"); 
		query.append("                                                                                                #if (${cost_wk} != '' &&  ${dt_tp} == '1')" ).append("\n"); 
		query.append("                                                                                                   AND COA.COST_WK = @[cost_wk]" ).append("\n"); 
		query.append("                                                                                                #end                                                                " ).append("\n"); 
		query.append("                                                                                                ORDER BY SKD.VSL_CD || SKD.SKD_VOY_NO || SKD.SKD_DIR_CD " ).append("\n"); 
		query.append("                                                                                                      " ).append("\n"); 
		query.append("                                                                                                    ) X" ).append("\n"); 
		query.append("                                                                                                ) Y" ).append("\n"); 
		query.append("                                                                                        ) GROUP BY RESULT" ).append("\n"); 
		query.append("                                                                              ),'@') FROM DUAL /*JOIN*/" ).append("\n"); 
		query.append("                                                                        ) ,'@')) /*SPLIT*/" ).append("\n"); 
		query.append("                                                                ) XX" ).append("\n"); 
		query.append("                                                                " ).append("\n"); 
		query.append("                                                      ) YY" ).append("\n"); 
		query.append("                                    ) YYY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                  ) YYYY     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                              ) K         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              ) YY" ).append("\n"); 
		query.append("			WHERE DECODE(VPS_PORT_CD,'OTHERS',LOD_LOCAL+LOD_IPC+LOD_TPS+LOD_EUR+LOD_MTY+DIS_LOCAL+DIS_IPC+DIS_TPS+DIS_EUR+DIS_MTY,1) > 0" ).append("\n"); 
		query.append("        ) ZZ" ).append("\n"); 
		query.append("    ) XXX" ).append("\n"); 
		query.append("WHERE SLAN_CD > ' '" ).append("\n"); 
		query.append("ORDER BY  ORDERBY,VVD_SEQ ,PORT_SEQ" ).append("\n"); 
		query.append(") FIN" ).append("\n"); 

	}
}