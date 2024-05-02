/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTmnlPerformVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOTmnlPerformVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    2015.08.17 김기원 CHM-201537021  조직코드 변경
	  * 2016.04.28 Arie Im CHM-201641178 아프리카 대륙 구주지역본부/동서남아지역본부 구분 로직 추가
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTmnlPerformVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_prod_rpt_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("carr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("target_lanes",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("target_ports",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTmnlPerformVORSQL").append("\n"); 
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
		query.append("SELECT DECODE(C2,3,'S.Total',RHQ)  AS RHQ," ).append("\n"); 
		query.append("       DECODE(C2,4,'S.Total',PORT) AS PORT," ).append("\n"); 
		query.append("       DECODE(C2,4,'',YARD) AS YARD," ).append("\n"); 
		query.append("       DECODE(C2,4,'',3,'',LANE) AS LANE," ).append("\n"); 
		query.append("       '' AS MONTH," ).append("\n"); 
		query.append("       TDR_QTY," ).append("\n"); 
		query.append("       TOT_MVS," ).append("\n"); 
		query.append("       WORK_GROSS," ).append("\n"); 
		query.append("       GANG_GROSS," ).append("\n"); 
		query.append("       TMNL_PROD," ).append("\n"); 
		query.append("       GANG_PROD," ).append("\n"); 
		query.append("       AVG_CLAN," ).append("\n"); 
		query.append("       BERTH_PROD" ).append("\n"); 
		query.append("FROM   (SELECT DECODE(C2,1,'Total',2,'Average per TDR',RHQ) AS RHQ, " ).append("\n"); 
		query.append("              C2," ).append("\n"); 
		query.append("              DECODE(PORT,'N',DECODE(C2,1,'',2,'Average per TDR',RHQ),NVL(PORT,DECODE(C2,3,'','')))  AS PORT," ).append("\n"); 
		query.append("              DECODE(YARD,'N',DECODE(C2,1,'',2,'',RHQ),NVL(YARD,DECODE(C2,3,'','')))  AS YARD," ).append("\n"); 
		query.append("              DECODE(LANE,'N',DECODE(C2,1,'',2,'',RHQ),NVL(LANE,DECODE(C2,3,'','')))  AS LANE," ).append("\n"); 
		query.append("              DECODE(C2,2,'',TDR_QTY) AS TDR_QTY," ).append("\n"); 
		query.append("              TOT_MVS," ).append("\n"); 
		query.append("              WORK_GROSS," ).append("\n"); 
		query.append("              GANG_GROSS," ).append("\n"); 
		query.append("              TMNL_PROD," ).append("\n"); 
		query.append("              GANG_PROD," ).append("\n"); 
		query.append("              AVG_CLAN," ).append("\n"); 
		query.append("              BERTH_PROD" ).append("\n"); 
		query.append("       FROM   " ).append("\n"); 
		query.append("       ( " ).append("\n"); 
		query.append("         /* Q1 */" ).append("\n"); 
		query.append("         SELECT RHQ," ).append("\n"); 
		query.append("                PORT," ).append("\n"); 
		query.append("                YARD," ).append("\n"); 
		query.append("                LANE," ).append("\n"); 
		query.append("                DECODE(C3,1,3,DECODE(C4,1,4,C2)) AS C2," ).append("\n"); 
		query.append("                TDR_QTY," ).append("\n"); 
		query.append("                TOT_MVS," ).append("\n"); 
		query.append("                WORK_GROSS," ).append("\n"); 
		query.append("                GANG_GROSS," ).append("\n"); 
		query.append("                DECODE(WORK_GROSS,0,0,ROUND(TOT_MVS/WORK_GROSS,2))     TMNL_PROD," ).append("\n"); 
		query.append("                DECODE(GANG_GROSS,0,0,ROUND(TOT_MVS/GANG_GROSS,2))     GANG_PROD," ).append("\n"); 
		query.append("                DECODE(WORK_GROSS,0,0,ROUND(GANG_GROSS/WORK_GROSS,2))  AVG_CLAN," ).append("\n"); 
		query.append("                BERTH_PROD" ).append("\n"); 
		query.append("                --ROUND(TOT_MVS/DECODE(WORK_GROSS,0,1,WORK_GROSS),2)    TMNL_PROD," ).append("\n"); 
		query.append("                --ROUND(TOT_MVS/DECODE(GANG_GROSS,0,1,GANG_GROSS),2)    GANG_PROD," ).append("\n"); 
		query.append("                --ROUND(GANG_GROSS/DECODE(WORK_GROSS,0,1,WORK_GROSS),2) AVG_CLAN" ).append("\n"); 
		query.append("         FROM   " ).append("\n"); 
		query.append("         ( " ).append("\n"); 
		query.append("           SELECT /*+ ORDERED */ R.POR_RHQ                   RHQ," ).append("\n"); 
		query.append("                  V.VPS_PORT_CD                              PORT," ).append("\n"); 
		query.append("                  V.YD_CD                                    YARD," ).append("\n"); 
		query.append("                  V.SLAN_CD                                  LANE," ).append("\n"); 
		query.append("                  GROUPING(R.POR_RHQ) P, GROUPING(V.VPS_PORT_CD) V, GROUPING(V.YD_CD) Y, GROUPING(V.SLAN_CD) L," ).append("\n"); 
		query.append("                  CASE" ).append("\n"); 
		query.append("                  WHEN GROUPING(R.POR_RHQ)=0 AND GROUPING(V.VPS_PORT_CD)=0 AND GROUPING(V.YD_CD)=0 AND GROUPING(V.SLAN_CD)=0 THEN 1" ).append("\n"); 
		query.append("                  ELSE 0" ).append("\n"); 
		query.append("                  END C1," ).append("\n"); 
		query.append("                  CASE" ).append("\n"); 
		query.append("                  WHEN GROUPING(R.POR_RHQ)=0 AND GROUPING(V.VPS_PORT_CD)=1 AND GROUPING(V.YD_CD)=1 AND GROUPING(V.SLAN_CD)=1 THEN 1" ).append("\n"); 
		query.append("                  ELSE 0" ).append("\n"); 
		query.append("                  END C3," ).append("\n"); 
		query.append("                  CASE" ).append("\n"); 
		query.append("                  WHEN GROUPING(R.POR_RHQ)=0 AND GROUPING(V.VPS_PORT_CD)=0 AND GROUPING(V.YD_CD)=1 AND GROUPING(V.SLAN_CD)=1 THEN 1" ).append("\n"); 
		query.append("                  ELSE 0" ).append("\n"); 
		query.append("                  END C4," ).append("\n"); 
		query.append("                  CASE" ).append("\n"); 
		query.append("                  WHEN GROUPING(R.POR_RHQ)=1 AND GROUPING(V.VPS_PORT_CD)=1 AND GROUPING(V.YD_CD)=1 AND GROUPING(V.SLAN_CD)=1 THEN 1" ).append("\n"); 
		query.append("                  ELSE 0" ).append("\n"); 
		query.append("                  END C2," ).append("\n"); 
		query.append("                  NVL(COUNT(T.VSL_CD||T.VOY_NO||T.DIR_CD),0) TDR_QTY," ).append("\n"); 
		query.append("                  NVL(SUM(T.MVS),0)                          TOT_MVS," ).append("\n"); 
		query.append("                  ROUND(SUM(NVL(TO_NUMBER(SUBSTR(T.GROSS_WORK,1,INSTR(T.GROSS_WORK,':')-1))+" ).append("\n"); 
		query.append("                  TO_NUMBER(SUBSTR(T.GROSS_WORK,INSTR(T.GROSS_WORK,':')+1)/60),0)),2) WORK_GROSS," ).append("\n"); 
		query.append("                  ROUND(SUM(NVL(TO_NUMBER(SUBSTR(T.GROSS_GANG,1,INSTR(T.GROSS_GANG,':')-1))+" ).append("\n"); 
		query.append("                  TO_NUMBER(SUBSTR(T.GROSS_GANG,INSTR(T.GROSS_GANG,':')+1)/60),0)),2) GANG_GROSS," ).append("\n"); 
		query.append("                  ROUND(AVG(CASE WHEN NVL((A.ACT_DEP_DT - A.ACT_BRTH_DT),0) = 0 " ).append("\n"); 
		query.append("                                    THEN T.MVS" ).append("\n"); 
		query.append("                                    ELSE NVL(T.MVS,0)/(NVL((A.ACT_DEP_DT - A.ACT_BRTH_DT),0) * 24)" ).append("\n"); 
		query.append("                               END" ).append("\n"); 
		query.append("                              ),2)  BERTH_PROD" ).append("\n"); 
		query.append("           FROM TDR_HEADER T, VSK_VSL_PORT_SKD V, VSK_ACT_PORT_SKD A," ).append("\n"); 
		query.append("                MDM_VSL_SVC_LANE L, OPF_TML_DEP_RPT_DTL D," ).append("\n"); 
		query.append("                ( " ).append("\n"); 
		query.append("                 SELECT distinct NVL(B.VSL_CD,A.VSL_CD) VSL_CD, NVL(B.CRR_CD,A.CRR_CD) CRR_CD," ).append("\n"); 
		query.append("                         NVL(B.EFF_DT, A.EFF_DT) EFF_DT," ).append("\n"); 
		query.append("                         NVL(B.EXP_DT, A.EXP_DT) EXP_DT" ).append("\n"); 
		query.append("                  FROM   (" ).append("\n"); 
		query.append("                           SELECT DECODE(V.VSL_CD,NULL,C.VSL_CD,V.VSL_CD)               VSL_CD," ).append("\n"); 
		query.append("                                  DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                  TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("                                  TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                           FROM   FMS_CONTRACT C, FMS_ID_VSL V" ).append("\n"); 
		query.append("                           WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_NO = V.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("                           AND    V.USE_FLG(+) = 'Y'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_TP_CD = 'TI'" ).append("\n"); 
		query.append("                           AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                    OR  REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                    OR  ( TO_CHAR(C.EFF_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(C.EXP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("                           UNION ALL" ).append("\n"); 
		query.append("                           SELECT C.VSL_CD     VSL_CD," ).append("\n"); 
		query.append("                                  DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                  TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("                                  TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                           FROM   FMS_CONTRACT C" ).append("\n"); 
		query.append("                           WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_TP_CD = 'TI'" ).append("\n"); 
		query.append("                           AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                    OR  REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                    OR  ( TO_CHAR(C.EFF_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(C.EXP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("                         ) A," ).append("\n"); 
		query.append("                         ( " ).append("\n"); 
		query.append("                           SELECT DECODE(V.VSL_CD,NULL,C.VSL_CD,V.VSL_CD)               VSL_CD," ).append("\n"); 
		query.append("                                  DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                  TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("                                  TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                           FROM   FMS_CONTRACT C, FMS_ID_VSL V" ).append("\n"); 
		query.append("                           WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_NO = V.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("                           AND    V.USE_FLG(+) = 'Y'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_TP_CD = 'TO'" ).append("\n"); 
		query.append("                           AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                    OR  REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                    OR  ( TO_CHAR(C.EFF_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(C.EXP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("                           UNION ALL" ).append("\n"); 
		query.append("                           SELECT C.VSL_CD     VSL_CD," ).append("\n"); 
		query.append("                                  DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                  TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("                                  TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                           FROM   FMS_CONTRACT C" ).append("\n"); 
		query.append("                           WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_TP_CD = 'TO'" ).append("\n"); 
		query.append("                           AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                    OR  REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                    OR  ( TO_CHAR(C.EFF_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(C.EXP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("                         ) B   " ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT distinct NVL(B.VSL_CD,A.VSL_CD) VSL_CD, NVL(B.CRR_CD,A.CRR_CD) CRR_CD," ).append("\n"); 
		query.append("                        NVL(B.EFF_DT, A.EFF_DT) EFF_DT," ).append("\n"); 
		query.append("                        NVL(B.EXP_DT, A.EXP_DT) EXP_DT" ).append("\n"); 
		query.append("                 FROM   (" ).append("\n"); 
		query.append("                          SELECT DECODE(V.VSL_CD,NULL,C.VSL_CD,V.VSL_CD)               VSL_CD," ).append("\n"); 
		query.append("                                 DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                 TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("                                 TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                          FROM   FMS_CONTRACT C, FMS_ID_VSL V" ).append("\n"); 
		query.append("                          WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_NO = V.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("                          AND    V.USE_FLG(+) = 'Y'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_TP_CD = 'OW'" ).append("\n"); 
		query.append("                          AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                   OR  REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                   OR  ( TO_CHAR(C.EFF_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(C.EXP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("                          UNION ALL" ).append("\n"); 
		query.append("                          SELECT C.VSL_CD     VSL_CD," ).append("\n"); 
		query.append("                                 DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                 TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("                                 TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                          FROM   FMS_CONTRACT C" ).append("\n"); 
		query.append("                          WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_TP_CD = 'OW'" ).append("\n"); 
		query.append("                          AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                   OR  REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                   OR  ( TO_CHAR(C.EFF_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(C.EXP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("                         ) A," ).append("\n"); 
		query.append("                          ( SELECT DECODE(V.VSL_CD,NULL,C.VSL_CD,V.VSL_CD)               VSL_CD," ).append("\n"); 
		query.append("                                 DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                 TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("                                 TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                          FROM   FMS_CONTRACT C, FMS_ID_VSL V" ).append("\n"); 
		query.append("                          WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_NO = V.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("                          AND    V.USE_FLG(+) = 'Y'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_TP_CD = 'TO'" ).append("\n"); 
		query.append("                          AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                   OR  REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                   OR  ( TO_CHAR(C.EFF_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(C.EXP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("                          UNION ALL" ).append("\n"); 
		query.append("                          SELECT C.VSL_CD     VSL_CD," ).append("\n"); 
		query.append("                                 DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                               TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("                                               TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                          FROM   FMS_CONTRACT C" ).append("\n"); 
		query.append("                          WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_TP_CD = 'TO'" ).append("\n"); 
		query.append("                          AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                   OR  REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                   OR  ( TO_CHAR(C.EFF_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(C.EXP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("                         ) B   " ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("                ) C," ).append("\n"); 
		query.append("                ( " ).append("\n"); 
		query.append("                  SELECT  LOC_CD, POR_RHQ, TP, VOP_PORT_FLG" ).append("\n"); 
		query.append("                  FROM    " ).append("\n"); 
		query.append("                   ( " ).append("\n"); 
		query.append("--                    SELECT LOC_CD, 'HAMRU' POR_RHQ, DECODE(VOP_PORT_RHQ_CD,NULL,'A','B') TP, VOP_PORT_FLG" ).append("\n"); 
		query.append("--                    FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--                    WHERE  DECODE(CONTI_CD, 'F', 'E', CONTI_CD) = 'E'" ).append("\n"); 
		query.append("--                    AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--                    AND    CALL_PORT_FLG      = 'Y'" ).append("\n"); 
		query.append("--                    --2010.07.28 EGAIS는 SINRS로 " ).append("\n"); 
		query.append("--					--2010.08.16 ZADUR는 HAMRU에서 SINRS으로 소속 변경됨" ).append("\n"); 
		query.append("--                    AND    LOC_CD NOT IN ('EGAIS','ZADUR','RUVVO')                  " ).append("\n"); 
		query.append("--                    UNION ALL" ).append("\n"); 
		query.append("--                    SELECT LOC_CD, 'NYCRA' POR_RHQ, DECODE(VOP_PORT_RHQ_CD,NULL,'A','B') TP, VOP_PORT_FLG" ).append("\n"); 
		query.append("--                    FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--                    WHERE  CONTI_CD           = 'M'" ).append("\n"); 
		query.append("--                    AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--                    AND    CALL_PORT_FLG      = 'Y'" ).append("\n"); 
		query.append("--                    UNION ALL" ).append("\n"); 
		query.append("--                    SELECT LOC_CD, DECODE(SCONTI_CD, 'AF', DECODE(CNT_CD,'KR','SELIB','JP','TYOIB','SHARC'), 'SINRS') POR_RHQ," ).append("\n"); 
		query.append("--                           DECODE(VOP_PORT_RHQ_CD,NULL,'A','B') TP, VOP_PORT_FLG" ).append("\n"); 
		query.append("--                    FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--                    --2010.07.28 EGAIS는 SINRS로 " ).append("\n"); 
		query.append("--					--2010.08.16 ZADUR는 HAMRU에서 SINRS으로 소속 변경됨" ).append("\n"); 
		query.append("--                    WHERE  (CONTI_CD          = 'A' OR LOC_CD = 'EGAIS' OR LOC_CD = 'ZADUR')" ).append("\n"); 
		query.append("--                    AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--                    AND    CALL_PORT_FLG      = 'Y' " ).append("\n"); 
		query.append("--					UNION ALL" ).append("\n"); 
		query.append("--					SELECT LOC_CD, 'VVOIA' POR_RHQ, DECODE(VOP_PORT_RHQ_CD,NULL,'A','B') TP, VOP_PORT_FLG" ).append("\n"); 
		query.append("--                    FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--                    WHERE  CONTI_CD = 'E'" ).append("\n"); 
		query.append("--                    AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--                    AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--                    AND    LOC_CD = 'RUVVO'" ).append("\n"); 
		query.append("                    SELECT L.LOC_CD, O.OFC_N3RD_LVL_CD POR_RHQ, DECODE(L.VOP_PORT_RHQ_CD,NULL,'A','B') TP, L.VOP_PORT_FLG FROM MDM_LOCATION L, MAS_OFC_LVL O WHERE L.EQ_CTRL_OFC_CD = O.OFC_CD AND L.CALL_PORT_FLG = 'Y' AND L.DELT_FLG = 'N' AND O.OFC_APLY_TO_YRMON ='999912' AND O.OFC_LVL < 9" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    WHERE   POR_RHQ = DECODE(SUBSTR(@[rhq], 1, 3), 'ALL', POR_RHQ, @[rhq]) " ).append("\n"); 
		query.append("                  ) R" ).append("\n"); 
		query.append("                  WHERE  T.VSL_CD       = V.VSL_CD" ).append("\n"); 
		query.append("                  AND    T.VOY_NO       = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND    T.DIR_CD       = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND    T.PORT_CD      = V.VPS_PORT_CD" ).append("\n"); 
		query.append("                  AND    T.CALL_IND     = V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  AND    V.VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("                  AND    V.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND    V.SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND    V.VPS_PORT_CD  = A.VPS_PORT_CD" ).append("\n"); 
		query.append("                  AND    V.CLPT_IND_SEQ = A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  AND    V.SLAN_CD      = L.VSL_SLAN_CD" ).append("\n"); 
		query.append("                  AND    V.VSL_CD       = C.VSL_CD(+)" ).append("\n"); 
		query.append("                  AND    V.VPS_PORT_CD  = R.LOC_CD" ).append("\n"); 
		query.append("                  AND    T.VSL_CD       = D.VSL_CD(+)" ).append("\n"); 
		query.append("                  AND    T.VOY_NO       = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                  AND    T.DIR_CD       = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                  AND    T.PORT_CD      = D.CLPT_CD(+)" ).append("\n"); 
		query.append("                  AND    T.CALL_IND     = D.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("                  AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(A.ACT_DEP_DT, 'yyyymm') AND TO_CHAR(A.ACT_DEP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                           OR REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(A.ACT_DEP_DT, 'yyyymm') AND TO_CHAR(A.ACT_DEP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                           OR ( TO_CHAR(A.ACT_DEP_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(A.ACT_DEP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("#if (${loc_cd} != '' && ${yd_cd} == 'All')" ).append("\n"); 
		query.append("                  AND    V.YD_CD        LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '' && ${yd_cd} != 'All')" ).append("\n"); 
		query.append("                  AND    V.YD_CD        LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end                          " ).append("\n"); 
		query.append("                  AND    R.POR_RHQ      = DECODE(@[rhq], 'ALL', R.POR_RHQ, @[rhq])" ).append("\n"); 
		query.append("#if (${target_lanes} != 'ALL')" ).append("\n"); 
		query.append("                  AND    L.TML_PROD_RPT_FLG LIKE @[target_lanes]||'%'                                                --Target Lanes Only 일경우 'Y', ALL일 경우 NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${target_ports} != 'ALL')" ).append("\n"); 
		query.append("                  AND    R.TP           LIKE @[target_ports]||'%'                                                    --Target Ports Only 일경우 'B', ALL일 경우 NULL" ).append("\n"); 
		query.append("                  AND    R.VOP_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tml_prod_rpt_rsn_cd} != '')" ).append("\n"); 
		query.append("                  AND    DECODE(D.TML_PROD_RPT_RSN_CD,NULL,'Y','N') = DECODE(@[tml_prod_rpt_rsn_cd],'N','Y','N')       --1Exclude fm TPR이 Check되었을 경우 'Y', Check되지 않았을 경우 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                  AND    DECODE(D.TML_PROD_RPT_RSN_CD,NULL,'Y','N') = DECODE('N','N','Y','N')       --2Exclude fm TPR이 Check되었을 경우 'Y', Check되지 않았을 경우 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${slan_cd} != 'ALL')" ).append("\n"); 
		query.append("                  AND    V.SLAN_CD      LIKE @[slan_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  AND    DECODE(@[carr_cd], NULL, 'N', DECODE(" ).append("\n"); 
		query.append("                               CASE" ).append("\n"); 
		query.append("                               WHEN TO_DATE(C.EFF_DT,'YYYYMMDD') <= TO_DATE(TO_CHAR(A.ACT_DEP_DT,'YYYYMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("                                    AND TO_DATE(C.EXP_DT,'YYYYMMDD') >= TO_DATE(TO_CHAR(A.ACT_DEP_DT,'YYYYMMDD'),'YYYYMMDD') THEN C.CRR_CD" ).append("\n"); 
		query.append("                               ELSE DECODE(C.CRR_CD,'SML','OTH',NULL,'OTH','SML')" ).append("\n"); 
		query.append("                               END, 'SML', 'SML', 'O')) = DECODE( @[carr_cd], NULL, 'N', 'SML', 'SML', 'O', 'O', '')" ).append("\n"); 
		query.append("                        GROUP BY CUBE( R.POR_RHQ, V.VPS_PORT_CD, V.YD_CD, V.SLAN_CD )               " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       WHERE C1 = 1 OR C2 = 1 OR C3 = 1 OR C4 = 1" ).append("\n"); 
		query.append("       /* Q1 */" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       /* Q2 */" ).append("\n"); 
		query.append("       SELECT 'AVG' RHQ," ).append("\n"); 
		query.append("              'N'   PORT," ).append("\n"); 
		query.append("              'N'   LANE," ).append("\n"); 
		query.append("              'N'   YARD," ).append("\n"); 
		query.append("              2    C2," ).append("\n"); 
		query.append("              0    TDR_QTY," ).append("\n"); 
		query.append("              ROUND(TOT_MVS/TDR_QTY,2)," ).append("\n"); 
		query.append("              ROUND(WORK_GROSS/TDR_QTY,2)," ).append("\n"); 
		query.append("              ROUND(GANG_GROSS/TDR_QTY,2)," ).append("\n"); 
		query.append("              DECODE(WORK_GROSS,0,0,ROUND((TOT_MVS/TDR_QTY) / (WORK_GROSS/TDR_QTY), 2))     TMNL_PROD," ).append("\n"); 
		query.append("              DECODE(GANG_GROSS,0,0,ROUND((TOT_MVS/TDR_QTY) / (GANG_GROSS/TDR_QTY), 2))     GANG_PROD," ).append("\n"); 
		query.append("              --ROUND((TOT_MVS/TDR_QTY) / DECODE((WORK_GROSS/TDR_QTY), 0, 1, (WORK_GROSS/TDR_QTY)), 2)             TMNL_PROD," ).append("\n"); 
		query.append("              --ROUND((TOT_MVS/TDR_QTY) / DECODE((GANG_GROSS/TDR_QTY), 0, 1, (GANG_GROSS/TDR_QTY)), 2)             GANG_PROD," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("                WHEN TOT_MVS=0 OR TDR_QTY=0 OR WORK_GROSS=0 OR GANG_GROSS=0 THEN 0" ).append("\n"); 
		query.append("                ELSE ROUND(((TOT_MVS/TDR_QTY) / (WORK_GROSS/TDR_QTY)) / ((TOT_MVS/TDR_QTY) / (GANG_GROSS/TDR_QTY)),2) " ).append("\n"); 
		query.append("              END AVG_CLAN," ).append("\n"); 
		query.append("              BERTH_PROD" ).append("\n"); 
		query.append("       FROM   " ).append("\n"); 
		query.append("       ( " ).append("\n"); 
		query.append("         SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("                NVL(COUNT(T.VSL_CD||T.VOY_NO||T.DIR_CD),0) TDR_QTY," ).append("\n"); 
		query.append("                NVL(SUM(T.MVS),0)                          TOT_MVS," ).append("\n"); 
		query.append("                ROUND(SUM(NVL(TO_NUMBER(SUBSTR(T.GROSS_WORK,1,INSTR(T.GROSS_WORK,':')-1))+" ).append("\n"); 
		query.append("                TO_NUMBER(SUBSTR(T.GROSS_WORK,INSTR(T.GROSS_WORK,':')+1)/60),0)),2) WORK_GROSS," ).append("\n"); 
		query.append("                ROUND(SUM(NVL(TO_NUMBER(SUBSTR(T.GROSS_GANG,1,INSTR(T.GROSS_GANG,':')-1))+" ).append("\n"); 
		query.append("                TO_NUMBER(SUBSTR(T.GROSS_GANG,INSTR(T.GROSS_GANG,':')+1)/60),0)),2) GANG_GROSS," ).append("\n"); 
		query.append("                ROUND(AVG(CASE WHEN NVL((A.ACT_DEP_DT - A.ACT_BRTH_DT),0) = 0 " ).append("\n"); 
		query.append("                                    THEN T.MVS" ).append("\n"); 
		query.append("                                    ELSE NVL(T.MVS,0)/(NVL((A.ACT_DEP_DT - A.ACT_BRTH_DT),0) * 24)" ).append("\n"); 
		query.append("                               END" ).append("\n"); 
		query.append("                              ),2)  BERTH_PROD" ).append("\n"); 
		query.append("         FROM TDR_HEADER T, VSK_VSL_PORT_SKD V, VSK_ACT_PORT_SKD A," ).append("\n"); 
		query.append("              MDM_VSL_SVC_LANE L, OPF_TML_DEP_RPT_DTL D," ).append("\n"); 
		query.append("         ( " ).append("\n"); 
		query.append("                 SELECT distinct NVL(B.VSL_CD,A.VSL_CD) VSL_CD, NVL(B.CRR_CD,A.CRR_CD) CRR_CD," ).append("\n"); 
		query.append("                                       NVL(B.EFF_DT, A.EFF_DT) EFF_DT," ).append("\n"); 
		query.append("                                       NVL(B.EXP_DT, A.EXP_DT) EXP_DT" ).append("\n"); 
		query.append("                  FROM   (" ).append("\n"); 
		query.append("                           SELECT DECODE(V.VSL_CD,NULL,C.VSL_CD,V.VSL_CD)               VSL_CD," ).append("\n"); 
		query.append("                                  DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                               TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("                                               TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                           FROM   FMS_CONTRACT C, FMS_ID_VSL V" ).append("\n"); 
		query.append("                           WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_NO = V.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("                           AND    V.USE_FLG(+) = 'Y'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_TP_CD = 'TI'" ).append("\n"); 
		query.append("                           AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                    OR  REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                    OR  ( TO_CHAR(C.EFF_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(C.EXP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("                           UNION ALL" ).append("\n"); 
		query.append("                           SELECT C.VSL_CD     VSL_CD," ).append("\n"); 
		query.append("                                  DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                               TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("                                               TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                           FROM   FMS_CONTRACT C" ).append("\n"); 
		query.append("                           WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_TP_CD = 'TI'" ).append("\n"); 
		query.append("                           AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                    OR  REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                    OR  ( TO_CHAR(C.EFF_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(C.EXP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("                         ) A," ).append("\n"); 
		query.append("                         ( " ).append("\n"); 
		query.append("                           SELECT DECODE(V.VSL_CD,NULL,C.VSL_CD,V.VSL_CD)               VSL_CD," ).append("\n"); 
		query.append("                                  DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                               TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("                                               TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                           FROM   FMS_CONTRACT C, FMS_ID_VSL V" ).append("\n"); 
		query.append("                           WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_NO = V.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("                           AND    V.USE_FLG(+) = 'Y'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_TP_CD = 'TO'" ).append("\n"); 
		query.append("                           AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                    OR  REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                    OR  ( TO_CHAR(C.EFF_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(C.EXP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("                           UNION ALL" ).append("\n"); 
		query.append("                           SELECT C.VSL_CD     VSL_CD," ).append("\n"); 
		query.append("                                  DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                               TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("                                               TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                           FROM   FMS_CONTRACT C" ).append("\n"); 
		query.append("                           WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                           AND    C.FLET_CTRT_TP_CD = 'TO'" ).append("\n"); 
		query.append("                           AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                    OR  REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                    OR  ( TO_CHAR(C.EFF_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(C.EXP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("                         ) B   " ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT distinct NVL(B.VSL_CD,A.VSL_CD) VSL_CD, NVL(B.CRR_CD,A.CRR_CD) CRR_CD," ).append("\n"); 
		query.append("                                       NVL(B.EFF_DT, A.EFF_DT) EFF_DT," ).append("\n"); 
		query.append("                                       NVL(B.EXP_DT, A.EXP_DT) EXP_DT" ).append("\n"); 
		query.append("                 FROM   (" ).append("\n"); 
		query.append("                          SELECT DECODE(V.VSL_CD,NULL,C.VSL_CD,V.VSL_CD)               VSL_CD," ).append("\n"); 
		query.append("                                 DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                  TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("                                  TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                          FROM   FMS_CONTRACT C, FMS_ID_VSL V" ).append("\n"); 
		query.append("                          WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_NO = V.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("                          AND    V.USE_FLG(+) = 'Y'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_TP_CD = 'OW'" ).append("\n"); 
		query.append("                          AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                   OR  REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                   OR  ( TO_CHAR(C.EFF_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(C.EXP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("                          UNION ALL" ).append("\n"); 
		query.append("                          SELECT C.VSL_CD     VSL_CD," ).append("\n"); 
		query.append("                                 DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                  TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("                                  TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                          FROM   FMS_CONTRACT C" ).append("\n"); 
		query.append("                          WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_TP_CD = 'OW'" ).append("\n"); 
		query.append("                          AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                   OR  REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                   OR  ( TO_CHAR(C.EFF_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(C.EXP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("                         ) A," ).append("\n"); 
		query.append("                          ( SELECT DECODE(V.VSL_CD,NULL,C.VSL_CD,V.VSL_CD)               VSL_CD," ).append("\n"); 
		query.append("                                 DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                  TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("                                  TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                          FROM   FMS_CONTRACT C, FMS_ID_VSL V" ).append("\n"); 
		query.append("                          WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_NO = V.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("                          AND    V.USE_FLG(+) = 'Y'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_TP_CD = 'TO'" ).append("\n"); 
		query.append("                          AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                   OR  REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                   OR  ( TO_CHAR(C.EFF_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(C.EXP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("                          UNION ALL" ).append("\n"); 
		query.append("                          SELECT C.VSL_CD     VSL_CD," ).append("\n"); 
		query.append("                                 DECODE(C.FLET_CTRT_TP_CD,'OW','SML','TI','SML','OTH') CRR_CD," ).append("\n"); 
		query.append("                                  TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT," ).append("\n"); 
		query.append("                                  TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("                          FROM   FMS_CONTRACT C" ).append("\n"); 
		query.append("                          WHERE  NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                          AND    C.FLET_CTRT_TP_CD = 'TO'" ).append("\n"); 
		query.append("                          AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                   OR  REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(C.EFF_DT, 'yyyymm') AND TO_CHAR(C.EXP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                   OR  ( TO_CHAR(C.EFF_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(C.EXP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("                         ) B   " ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("         ) C," ).append("\n"); 
		query.append("         ( " ).append("\n"); 
		query.append("           SELECT  LOC_CD, POR_RHQ, TP, VOP_PORT_FLG" ).append("\n"); 
		query.append("           FROM    ( " ).append("\n"); 
		query.append("--                     SELECT LOC_CD, 'HAMRU' POR_RHQ, DECODE(VOP_PORT_RHQ_CD,NULL,'A','B') TP, VOP_PORT_FLG" ).append("\n"); 
		query.append("--                     FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--                     WHERE  DECODE(CONTI_CD, 'F', 'E', CONTI_CD) = 'E'" ).append("\n"); 
		query.append("--                     AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--                     AND    CALL_PORT_FLG      = 'Y'" ).append("\n"); 
		query.append("--                     --2010.07.28 EGAIS는 SINRS로" ).append("\n"); 
		query.append("--					 --2010.08.16 ZADUR는 HAMRU에서 SINRS으로 소속 변경됨" ).append("\n"); 
		query.append("--                     AND    LOC_CD            NOT IN ('EGAIS','ZADUR','RUVVO')" ).append("\n"); 
		query.append("--                     UNION ALL" ).append("\n"); 
		query.append("--                     SELECT LOC_CD, 'NYCRA' POR_RHQ, DECODE(VOP_PORT_RHQ_CD,NULL,'A','B') TP, VOP_PORT_FLG" ).append("\n"); 
		query.append("--                     FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--                     WHERE  CONTI_CD           = 'M'" ).append("\n"); 
		query.append("--                     AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--                     AND    CALL_PORT_FLG      = 'Y'" ).append("\n"); 
		query.append("--                     UNION ALL" ).append("\n"); 
		query.append("--                     SELECT LOC_CD, DECODE(SCONTI_CD, 'AF', DECODE(CNT_CD,'KR','SELIB','JP','TYOIB','SHARC'), 'SINRS') POR_RHQ," ).append("\n"); 
		query.append("--                            DECODE(VOP_PORT_RHQ_CD,NULL,'A','B') TP, VOP_PORT_FLG" ).append("\n"); 
		query.append("--                     FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--                     --2010.07.28 EGAIS는 SINRS로" ).append("\n"); 
		query.append("--					 --2010.08.16 ZADUR는 HAMRU에서 SINRS으로 소속 변경됨" ).append("\n"); 
		query.append("--                     WHERE  (CONTI_CD          = 'A' OR LOC_CD = 'EGAIS' OR LOC_CD = 'ZADUR')" ).append("\n"); 
		query.append("--                     AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--                     AND    CALL_PORT_FLG      = 'Y' " ).append("\n"); 
		query.append("--					UNION ALL" ).append("\n"); 
		query.append("--					SELECT LOC_CD, 'VVOIA' POR_RHQ, DECODE(VOP_PORT_RHQ_CD,NULL,'A','B') TP, VOP_PORT_FLG" ).append("\n"); 
		query.append("--                    FROM   MDM_LOCATION" ).append("\n"); 
		query.append("--                    WHERE  CONTI_CD = 'E'" ).append("\n"); 
		query.append("--                    AND    NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("--                    AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("--                    AND    LOC_CD = 'RUVVO'" ).append("\n"); 
		query.append("                    SELECT L.LOC_CD, O.OFC_N3RD_LVL_CD POR_RHQ, DECODE(L.VOP_PORT_RHQ_CD,NULL,'A','B') TP, L.VOP_PORT_FLG FROM MDM_LOCATION L, MAS_OFC_LVL O WHERE L.EQ_CTRL_OFC_CD = O.OFC_CD AND L.CALL_PORT_FLG = 'Y' AND L.DELT_FLG = 'N' AND O.OFC_APLY_TO_YRMON ='999912' AND O.OFC_LVL < 9" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("           WHERE   POR_RHQ = DECODE(SUBSTR(@[rhq], 1, 3), 'ALL', POR_RHQ, @[rhq]) " ).append("\n"); 
		query.append("         ) R" ).append("\n"); 
		query.append("         WHERE  T.VSL_CD       = V.VSL_CD" ).append("\n"); 
		query.append("         AND    T.VOY_NO       = V.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND    T.DIR_CD       = V.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND    T.PORT_CD      = V.VPS_PORT_CD" ).append("\n"); 
		query.append("         AND    T.CALL_IND     = V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("         AND    V.VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("         AND    V.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND    V.SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND    V.VPS_PORT_CD  = A.VPS_PORT_CD" ).append("\n"); 
		query.append("         AND    V.CLPT_IND_SEQ = A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("         AND    V.SLAN_CD      = L.VSL_SLAN_CD" ).append("\n"); 
		query.append("         AND    V.VSL_CD       = C.VSL_CD(+)" ).append("\n"); 
		query.append("         AND    V.VPS_PORT_CD  = R.LOC_CD" ).append("\n"); 
		query.append("         AND    T.VSL_CD       = D.VSL_CD(+)" ).append("\n"); 
		query.append("         AND    T.VOY_NO       = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("         AND    T.DIR_CD       = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("         AND    T.PORT_CD      = D.CLPT_CD(+)" ).append("\n"); 
		query.append("         AND    T.CALL_IND     = D.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("         AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(A.ACT_DEP_DT, 'yyyymm') AND TO_CHAR(A.ACT_DEP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                  OR REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(A.ACT_DEP_DT, 'yyyymm') AND TO_CHAR(A.ACT_DEP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                  OR ( TO_CHAR(A.ACT_DEP_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(A.ACT_DEP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("#if (${loc_cd} != '' && ${yd_cd} == 'All')" ).append("\n"); 
		query.append("         AND    V.YD_CD        LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '' && ${yd_cd} != 'All')" ).append("\n"); 
		query.append("         AND    V.YD_CD        LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         AND    R.POR_RHQ      = DECODE(@[rhq], 'ALL', R.POR_RHQ, @[rhq])" ).append("\n"); 
		query.append("#if (${target_lanes} != 'ALL')" ).append("\n"); 
		query.append("         AND    L.TML_PROD_RPT_FLG LIKE @[target_lanes]||'%'                                                --Target Lanes Only 일경우 'Y', ALL일 경우 NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${target_ports} != 'ALL')" ).append("\n"); 
		query.append("         AND    R.TP           LIKE @[target_ports]||'%'                                                    --Target Ports Only 일경우 'B', ALL일 경우 NULL" ).append("\n"); 
		query.append("         AND    R.VOP_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tml_prod_rpt_rsn_cd} != '')" ).append("\n"); 
		query.append("         AND    DECODE(D.TML_PROD_RPT_RSN_CD,NULL,'Y','N') = DECODE(@[tml_prod_rpt_rsn_cd],'N','Y','N')       --Exclude fm TPR이 Check되었을 경우 'Y', Check되지 않았을 경우 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         AND    DECODE(D.TML_PROD_RPT_RSN_CD,NULL,'Y','N') = DECODE('N','N','Y','N')       --Exclude fm TPR이 Check되었을 경우 'Y', Check되지 않았을 경우 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         AND    DECODE(@[carr_cd], NULL, 'N', DECODE(" ).append("\n"); 
		query.append("                               CASE" ).append("\n"); 
		query.append("                               WHEN TO_DATE(C.EFF_DT,'YYYYMMDD') <= TO_DATE(TO_CHAR(A.ACT_DEP_DT,'YYYYMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("                                    AND TO_DATE(C.EXP_DT,'YYYYMMDD') >= TO_DATE(TO_CHAR(A.ACT_DEP_DT,'YYYYMMDD'),'YYYYMMDD') THEN C.CRR_CD" ).append("\n"); 
		query.append("                               ELSE DECODE(C.CRR_CD,'SML','OTH',NULL,'OTH','SML')" ).append("\n"); 
		query.append("                               END, 'SML', 'SML', 'O')) = DECODE(@[carr_cd], NULL, 'N', 'SML', 'SML', 'O', 'O', '')" ).append("\n"); 
		query.append("#if (${slan_cd} != 'ALL')" ).append("\n"); 
		query.append("         AND    V.SLAN_CD      LIKE @[slan_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY 1" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       /* Q2 */   " ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("     ORDER BY DECODE(C2,1,'YYYYY',2,'ZZZZZ',3,RHQ||'Z',RHQ), DECODE(C2,4,PORT||'Z',PORT), YARD, LANE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}