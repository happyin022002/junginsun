/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTmnlPerformInputPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOTmnlPerformInputPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTmnlPerformInputPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("manu_in_time",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTmnlPerformInputPortRSQL").append("\n"); 
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
		query.append("SELECT LANE," ).append("\n"); 
		query.append("       VVD," ).append("\n"); 
		query.append("       TO_CHAR(ETB,'yyyy-mm-dd hh24:mi') ETB," ).append("\n"); 
		query.append("       TO_CHAR(ETD,'yyyy-mm-dd hh24:mi') ETD," ).append("\n"); 
		query.append("       TO_CHAR(ATA,'yyyy-mm-dd hh24:mi') ATA," ).append("\n"); 
		query.append("       TO_CHAR(ATB,'yyyy-mm-dd hh24:mi') ATB," ).append("\n"); 
		query.append("       TO_CHAR(ATD,'yyyy-mm-dd hh24:mi') ATD," ).append("\n"); 
		query.append("       ARR_DELAY," ).append("\n"); 
		query.append("       ARR_WAIT," ).append("\n"); 
		query.append("       PORT_DELAY," ).append("\n"); 
		query.append("       PORT_WORK," ).append("\n"); 
		query.append("       DEP_DELAY," ).append("\n"); 
		query.append("       TUG_IN," ).append("\n"); 
		query.append("       TUG_OUT," ).append("\n"); 
		query.append("       CGO_FL," ).append("\n"); 
		query.append("       CGO_MT," ).append("\n"); 
		query.append("       RH_MVS," ).append("\n"); 
		query.append("       RH_RATIO," ).append("\n"); 
		query.append("       TOT_MVS," ).append("\n"); 
		query.append("       WORK_GROSS," ).append("\n"); 
		query.append("       WORK_NET," ).append("\n"); 
		query.append("       GANG_GROSS," ).append("\n"); 
		query.append("       GANG_NET," ).append("\n"); 
		query.append("       WORK_PRD_GROSS," ).append("\n"); 
		query.append("       WORK_PRD_NET," ).append("\n"); 
		query.append("       GANG_PRD_GROSS," ).append("\n"); 
		query.append("       GANG_PRD_NET" ).append("\n"); 
		query.append("FROM ( SELECT DECODE(C3,1,'G.Sum',LANE) LANE," ).append("\n"); 
		query.append("              DECODE(C2,1,'S.Sum',VVD) VVD," ).append("\n"); 
		query.append("              C1, C2, C3," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN ( C1=0 AND C2= 1 AND C3 = 0 ) OR C3 = 1 THEN NULL" ).append("\n"); 
		query.append("              ELSE ETB" ).append("\n"); 
		query.append("              END ETB," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN ( C1=0 AND C2= 1 AND C3 = 0 ) OR C3 = 1 THEN NULL" ).append("\n"); 
		query.append("              ELSE ETD" ).append("\n"); 
		query.append("              END ETD," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN ( C1=0 AND C2= 1 AND C3 = 0 ) OR C3 = 1 THEN NULL" ).append("\n"); 
		query.append("              ELSE ATA" ).append("\n"); 
		query.append("              END ATA," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN ( C1=0 AND C2= 1 AND C3 = 0 ) OR C3 = 1 THEN NULL" ).append("\n"); 
		query.append("              ELSE ATB" ).append("\n"); 
		query.append("              END ATB," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN ( C1=0 AND C2= 1 AND C3 = 0 ) OR C3 = 1 THEN NULL" ).append("\n"); 
		query.append("              ELSE ATD" ).append("\n"); 
		query.append("              END ATD," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN ( C1=0 AND C2= 1 AND C3 = 0 ) OR C3 = 1 THEN NULL" ).append("\n"); 
		query.append("              ELSE ARR_DELAY" ).append("\n"); 
		query.append("              END ARR_DELAY," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN ( C1=0 AND C2= 1 AND C3 = 0 ) OR C3 = 1 THEN NULL" ).append("\n"); 
		query.append("              ELSE ARR_WAIT" ).append("\n"); 
		query.append("              END ARR_WAIT," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN ( C1=0 AND C2= 1 AND C3 = 0 ) OR C3 = 1 THEN NULL" ).append("\n"); 
		query.append("              ELSE PORT_DELAY" ).append("\n"); 
		query.append("              END PORT_DELAY," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN ( C1=0 AND C2= 1 AND C3 = 0 ) OR C3 = 1 THEN NULL" ).append("\n"); 
		query.append("              ELSE PORT_WORK" ).append("\n"); 
		query.append("              END PORT_WORK," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN ( C1=0 AND C2= 1 AND C3 = 0 ) OR C3 = 1 THEN NULL" ).append("\n"); 
		query.append("              ELSE DEP_DELAY" ).append("\n"); 
		query.append("              END DEP_DELAY," ).append("\n"); 
		query.append("              TUG_IN," ).append("\n"); 
		query.append("              TUG_OUT," ).append("\n"); 
		query.append("              CGO_FL," ).append("\n"); 
		query.append("              CGO_MT," ).append("\n"); 
		query.append("              RH_MVS," ).append("\n"); 
		query.append("              RH_RATIO," ).append("\n"); 
		query.append("              TOT_MVS," ).append("\n"); 
		query.append("              WORK_GROSS," ).append("\n"); 
		query.append("              WORK_NET," ).append("\n"); 
		query.append("              GANG_GROSS," ).append("\n"); 
		query.append("              GANG_NET," ).append("\n"); 
		query.append("              WORK_PRD_GROSS," ).append("\n"); 
		query.append("              WORK_PRD_NET," ).append("\n"); 
		query.append("              GANG_PRD_GROSS," ).append("\n"); 
		query.append("              GANG_PRD_NET" ).append("\n"); 
		query.append("       FROM ( SELECT S.VSL_SLAN_CD                                                 LANE," ).append("\n"); 
		query.append("                     C.VVD," ).append("\n"); 
		query.append("                     MAX(R.PF_ETB_DT)                                              ETB," ).append("\n"); 
		query.append("                     MAX(R.PF_ETD_DT)                                              ETD," ).append("\n"); 
		query.append("                     MAX(C.ARR)                                                    ATA," ).append("\n"); 
		query.append("                     MAX(C.BRTH)                                                   ATB," ).append("\n"); 
		query.append("                     MAX(C.DEP)                                                    ATD," ).append("\n"); 
		query.append("                     CASE" ).append("\n"); 
		query.append("                     WHEN GROUPING(S.VSL_SLAN_CD)=0 AND GROUPING(C.VVD)=0 THEN 1" ).append("\n"); 
		query.append("                     ELSE 0" ).append("\n"); 
		query.append("                     END C1," ).append("\n"); 
		query.append("                     CASE" ).append("\n"); 
		query.append("                     WHEN GROUPING(S.VSL_SLAN_CD)=0 AND GROUPING(C.VVD)=1 THEN 1" ).append("\n"); 
		query.append("                     ELSE 0" ).append("\n"); 
		query.append("                     END C2," ).append("\n"); 
		query.append("                     CASE" ).append("\n"); 
		query.append("                     WHEN GROUPING(S.VSL_SLAN_CD)=1 AND GROUPING(C.VVD)=1 THEN 1" ).append("\n"); 
		query.append("                     ELSE 0" ).append("\n"); 
		query.append("                     END C3," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.ARR - R.PF_ETB_DT + (@[manu_in_time]/24),0)) * 24, 1)                             ARR_DELAY," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.BRTH - C.ARR - (@[manu_in_time]/24),0)) * 24, 1)                                  ARR_WAIT," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL((C.DEP - C.BRTH) - (R.PF_ETD_DT - R.PF_ETB_DT),0)) * 24, 1)                       PORT_DELAY," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL((C.DEP - C.BRTH),0)) * 24, 1)                                                     PORT_WORK," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL((C.DEP - R.PF_ETD_DT),0)) * 24, 1)                                                DEP_DELAY," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.ATUG,0)),1)                                                                     TUG_IN," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.DTUG,0)),1)                                                                     TUG_OUT," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.FL,0)),1)                                                                       CGO_FL," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.MT,0)),1)                                                                       CGO_MT," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.MVS,0)),1)                                                                      RH_MVS," ).append("\n"); 
		query.append("                     ROUND((SUM(NVL(C.MVS,0))/NVL((SUM(NVL(C.FL,0))+SUM(NVL(C.MT,0))+SUM(NVL(C.MVS,0))),1))*100,1)   RH_RATIO," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(C.FL,0))+SUM(NVL(C.MT,0))+SUM(NVL(C.MVS,0)),1)                                    TOT_MVS," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(TO_NUMBER(SUBSTR(T.GROSS_WORK,1,INSTR(T.GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(T.GROSS_WORK,INSTR(T.GROSS_WORK,':')+1)/60),0)),1) WORK_GROSS," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(TO_NUMBER(SUBSTR(T.NET_WORK,1,INSTR(T.NET_WORK,':')-1))+TO_NUMBER(SUBSTR(T.NET_WORK,INSTR(T.NET_WORK,':')+1)/60),0)),1)         WORK_NET," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(TO_NUMBER(SUBSTR(T.GROSS_GANG,1,INSTR(T.GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(T.GROSS_GANG,INSTR(T.GROSS_GANG,':')+1)/60),0)),1) GANG_GROSS," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(TO_NUMBER(SUBSTR(T.NET_GANG,1,INSTR(T.NET_GANG,':')-1))+TO_NUMBER(SUBSTR(T.NET_GANG,INSTR(T.NET_GANG,':')+1)/60),0)),1)         GANG_NET," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(T.GROSS_TML,0)),1)                              WORK_PRD_GROSS," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(T.NET_TML,0)),1)                                WORK_PRD_NET," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(T.GROSS_GC,0)),1)                               GANG_PRD_GROSS," ).append("\n"); 
		query.append("                     ROUND(SUM(NVL(T.NET_GC,0)),1)                                 GANG_PRD_NET" ).append("\n"); 
		query.append("              FROM   ( SELECT A.VVD," ).append("\n"); 
		query.append("                              A.CAL," ).append("\n"); 
		query.append("                              A.PORT," ).append("\n"); 
		query.append("                              A.STS," ).append("\n"); 
		query.append("                              A.ARR," ).append("\n"); 
		query.append("                              A.BRTH," ).append("\n"); 
		query.append("                              A.DEP," ).append("\n"); 
		query.append("                              A.ATUG," ).append("\n"); 
		query.append("                              A.DTUG," ).append("\n"); 
		query.append("                              A.ETD," ).append("\n"); 
		query.append("                              A.ETB," ).append("\n"); 
		query.append("                              A.FL," ).append("\n"); 
		query.append("                              A.MT," ).append("\n"); 
		query.append("                              B.MVS" ).append("\n"); 
		query.append("                       FROM   ( SELECT S.PORT_CD                    PORT," ).append("\n"); 
		query.append("                                       V.LANE                       LANE," ).append("\n"); 
		query.append("                                       S.VSL_CD||S.VOY_NO||S.DIR_CD VVD," ).append("\n"); 
		query.append("                                       M.CRR_CD                     OPR," ).append("\n"); 
		query.append("                                       V.CAL," ).append("\n"); 
		query.append("                                       V.STS," ).append("\n"); 
		query.append("                                       V.ARR," ).append("\n"); 
		query.append("                                       V.BRTH," ).append("\n"); 
		query.append("                                       V.DEP," ).append("\n"); 
		query.append("                                       V.ATUG," ).append("\n"); 
		query.append("                                       V.DTUG," ).append("\n"); 
		query.append("                                       V.ETD," ).append("\n"); 
		query.append("                                       V.ETB," ).append("\n"); 
		query.append("                                       SUM(DECODE(S.CNTR_TYPE,'E',0,QTY)) FL," ).append("\n"); 
		query.append("                                       SUM(DECODE(S.CNTR_TYPE,'E',QTY,0)) MT" ).append("\n"); 
		query.append("                                FROM   TDR_SUMMARY S, MDM_VSL_CNTR M," ).append("\n"); 
		query.append("                                       ( SELECT   A.VSL_CD          VSL, " ).append("\n"); 
		query.append("                                                  A.SKD_VOY_NO      VOY, " ).append("\n"); 
		query.append("                                                  A.SKD_DIR_CD      DIR, " ).append("\n"); 
		query.append("                                                  A.VPS_PORT_CD     LOC, " ).append("\n"); 
		query.append("                                                  A.CLPT_IND_SEQ    CAL, " ).append("\n"); 
		query.append("                                                  A.SLAN_CD         LANE," ).append("\n"); 
		query.append("                                                  B.PORT_SKD_STS_CD STS," ).append("\n"); 
		query.append("                                                  B.ACT_ARR_DT      ARR," ).append("\n"); 
		query.append("                                                  B.ACT_BRTH_DT     BRTH," ).append("\n"); 
		query.append("                                                  B.ACT_DEP_DT      DEP," ).append("\n"); 
		query.append("                                                  B.ARR_TUG_BOT_KNT ATUG," ).append("\n"); 
		query.append("                                                  B.DEP_TUG_BOT_KNT DTUG," ).append("\n"); 
		query.append("                                                  A.VPS_ETD_DT      ETD," ).append("\n"); 
		query.append("                                                  A.VPS_ETB_DT      ETB" ).append("\n"); 
		query.append("                                         FROM     VSK_VSL_PORT_SKD A, VSK_ACT_PORT_SKD B  " ).append("\n"); 
		query.append("                                         WHERE    A.VSL_CD          = B.VSL_CD " ).append("\n"); 
		query.append("                                         AND      A.SKD_VOY_NO      = B.SKD_VOY_NO " ).append("\n"); 
		query.append("                                         AND      A.SKD_DIR_CD      = B.SKD_DIR_CD " ).append("\n"); 
		query.append("                                         AND      A.VPS_PORT_CD     = B.VPS_PORT_CD " ).append("\n"); 
		query.append("                                         AND      A.CLPT_IND_SEQ    = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("                                         AND      A.SLAN_CD         LIKE @[slan_cd]||'%'                                  --:lane_cd" ).append("\n"); 
		query.append("#end                                         " ).append("\n"); 
		query.append("#if (${yd_cd} == 'All')" ).append("\n"); 
		query.append("                                         AND      A.YD_CD           LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND      A.YD_CD           LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end                                          " ).append("\n"); 
		query.append("                                         AND      B.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("                                         AND      B.ACT_DEP_DT      BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')              --:fm_dt" ).append("\n"); 
		query.append("                                                                    AND     TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD') + 0.99999 ) V  --:to_dt" ).append("\n"); 
		query.append("                                WHERE  S.VSL_CD   = V.VSL " ).append("\n"); 
		query.append("                                AND    S.VOY_NO   = V.VOY " ).append("\n"); 
		query.append("                                AND    S.DIR_CD   = V.DIR " ).append("\n"); 
		query.append("                                AND    S.PORT_CD  = V.LOC " ).append("\n"); 
		query.append("                                AND    S.CALL_IND = V.CAL" ).append("\n"); 
		query.append("                                AND    S.VSL_CD   = M.VSL_CD(+)" ).append("\n"); 
		query.append("                                AND    M.CRR_CD   = DECODE(@[carr_cd], COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(), @[carr_cd], M.CRR_CD)" ).append("\n"); 
		query.append("#if (${carr_cd} == 'O')" ).append("\n"); 
		query.append("                                AND    M.CRR_CD   <> COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()                              --:carr_cd('Other')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_cd} != '')" ).append("\n"); 
		query.append("                                AND    S.DIR_CD   LIKE @[dir_cd]||'%'                                                            --:dir_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                GROUP BY S.PORT_CD, V.LANE, S.VSL_CD||S.VOY_NO||S.DIR_CD, M.CRR_CD," ).append("\n"); 
		query.append("                                         V.CAL, V.STS, V.ARR, V.BRTH, V.DEP, V.ATUG, V.DTUG, V.ETD, V.ETB ) A," ).append("\n"); 
		query.append("                              ( SELECT C.PORT_CD                    PORT," ).append("\n"); 
		query.append("                                       V.LANE                       LANE," ).append("\n"); 
		query.append("                                       C.VSL_CD||C.VOY_NO||C.DIR_CD VVD," ).append("\n"); 
		query.append("                                       M.CRR_CD                     OPR," ).append("\n"); 
		query.append("                                       V.CAL," ).append("\n"); 
		query.append("                                       V.STS," ).append("\n"); 
		query.append("                                       V.ARR," ).append("\n"); 
		query.append("                                       V.BRTH," ).append("\n"); 
		query.append("                                       V.DEP," ).append("\n"); 
		query.append("                                       V.ATUG," ).append("\n"); 
		query.append("                                       V.DTUG," ).append("\n"); 
		query.append("                                       V.ETD," ).append("\n"); 
		query.append("                                       V.ETB," ).append("\n"); 
		query.append("                                       SUM(DECODE(C.SHIFT_TYPE,'B',1,0))+SUM(DECODE(C.SHIFT_TYPE,'Q',1,0)*2) MVS" ).append("\n"); 
		query.append("                                FROM   	TDR_CNTR_DETAIL C" ).append("\n"); 
		query.append("									, 	MDM_VSL_CNTR 	M" ).append("\n"); 
		query.append("									,	( SELECT   A.VSL_CD          VSL, " ).append("\n"); 
		query.append("                                                  A.SKD_VOY_NO      VOY, " ).append("\n"); 
		query.append("                                                  A.SKD_DIR_CD      DIR, " ).append("\n"); 
		query.append("                                                  A.VPS_PORT_CD     LOC, " ).append("\n"); 
		query.append("                                                  A.CLPT_IND_SEQ    CAL, " ).append("\n"); 
		query.append("                                                  A.SLAN_CD         LANE," ).append("\n"); 
		query.append("                                                  B.PORT_SKD_STS_CD STS," ).append("\n"); 
		query.append("                                                  B.ACT_ARR_DT      ARR," ).append("\n"); 
		query.append("                                                  B.ACT_BRTH_DT     BRTH," ).append("\n"); 
		query.append("                                                  B.ACT_DEP_DT      DEP," ).append("\n"); 
		query.append("                                                  B.ARR_TUG_BOT_KNT ATUG," ).append("\n"); 
		query.append("                                                  B.DEP_TUG_BOT_KNT DTUG," ).append("\n"); 
		query.append("                                                  A.VPS_ETD_DT      ETD," ).append("\n"); 
		query.append("                                                  A.VPS_ETB_DT      ETB" ).append("\n"); 
		query.append("                                         FROM     VSK_VSL_PORT_SKD A, VSK_ACT_PORT_SKD B  " ).append("\n"); 
		query.append("                                         WHERE    A.VSL_CD          = B.VSL_CD " ).append("\n"); 
		query.append("                                         AND      A.SKD_VOY_NO      = B.SKD_VOY_NO " ).append("\n"); 
		query.append("                                         AND      A.SKD_DIR_CD      = B.SKD_DIR_CD " ).append("\n"); 
		query.append("                                         AND      A.VPS_PORT_CD     = B.VPS_PORT_CD " ).append("\n"); 
		query.append("                                         AND      A.CLPT_IND_SEQ    = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("                                         AND      A.SLAN_CD         LIKE @[slan_cd]||'%'                                          --:lane_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${yd_cd} == 'All')" ).append("\n"); 
		query.append("                                         AND      A.YD_CD           LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND      A.YD_CD           LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                         AND      B.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("                                         AND      B.ACT_DEP_DT      BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')              --:fm_dt" ).append("\n"); 
		query.append("                                                                    AND     TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD') + 0.99999 ) V  --:to_dt" ).append("\n"); 
		query.append("                                WHERE  C.VSL_CD   = V.VSL " ).append("\n"); 
		query.append("                                AND    C.VOY_NO   = V.VOY " ).append("\n"); 
		query.append("                                AND    C.DIR_CD   = V.DIR " ).append("\n"); 
		query.append("                                AND    C.PORT_CD  = V.LOC " ).append("\n"); 
		query.append("                                AND    C.CALL_IND = V.CAL" ).append("\n"); 
		query.append("                                AND    TRIM(C.PRECELL) IS NOT NULL" ).append("\n"); 
		query.append("                                AND    C.VSL_CD   = M.VSL_CD(+)" ).append("\n"); 
		query.append("                                AND    M.CRR_CD   = DECODE(@[carr_cd], COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(), @[carr_cd], M.CRR_CD)" ).append("\n"); 
		query.append("#if (${carr_cd} == 'O')" ).append("\n"); 
		query.append("                                AND    M.CRR_CD   <> COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()                              --:carr_cd('Other')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_cd} != '')" ).append("\n"); 
		query.append("                                AND    C.DIR_CD   LIKE @[dir_cd]||'%'                                                            --:dir_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                GROUP BY C.PORT_CD, V.LANE, C.VSL_CD||C.VOY_NO||C.DIR_CD, M.CRR_CD," ).append("\n"); 
		query.append("                                         V.CAL, V.STS, V.ARR, V.BRTH, V.DEP, V.ATUG, V.DTUG, V.ETD, V.ETB ) B" ).append("\n"); 
		query.append("                       WHERE A.PORT     = B.PORT(+)" ).append("\n"); 
		query.append("                       AND   A.LANE     = B.LANE(+)" ).append("\n"); 
		query.append("                       AND   A.VVD      = B.VVD(+)" ).append("\n"); 
		query.append("                       AND   A.OPR      = B.OPR(+)" ).append("\n"); 
		query.append("                       AND   A.CAL      = B.CAL(+)" ).append("\n"); 
		query.append("                       AND   A.STS      = B.STS(+)" ).append("\n"); 
		query.append("                       AND   A.ARR      = B.ARR(+)" ).append("\n"); 
		query.append("                       AND   A.BRTH     = B.BRTH(+)" ).append("\n"); 
		query.append("                       AND   A.DEP      = B.DEP(+)" ).append("\n"); 
		query.append("                       AND   A.ATUG     = B.ATUG(+)" ).append("\n"); 
		query.append("                       AND   A.DTUG     = B.DTUG(+)" ).append("\n"); 
		query.append("                       AND   A.ETD      = B.ETD(+)" ).append("\n"); 
		query.append("                       AND   A.ETB      = B.ETB(+) ) C," ).append("\n"); 
		query.append("                     TDR_HEADER T, VSK_VSL_PORT_SKD R, VSK_VSL_SKD S" ).append("\n"); 
		query.append("              WHERE  SUBSTR(C.VVD,1,4) = T.VSL_CD(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,5,4) = T.VOY_NO(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,9,1) = T.DIR_CD(+)" ).append("\n"); 
		query.append("              AND    C.PORT            = T.PORT_CD(+)" ).append("\n"); 
		query.append("              AND    C.CAL             = T.CALL_IND(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,1,4) = R.VSL_CD(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,5,4) = R.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,9,1) = R.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("              AND    C.PORT            = R.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("              AND    C.CAL             = R.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,1,4) = S.VSL_CD" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,5,4) = S.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,9,1) = S.SKD_DIR_CD        " ).append("\n"); 
		query.append("              GROUP BY CUBE( S.VSL_SLAN_CD, C.VVD ) )" ).append("\n"); 
		query.append("       WHERE C1 = 1 OR C2 = 1 OR C3 = 1" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT DECODE(C3,1,'G.AVG',LANE) LANE," ).append("\n"); 
		query.append("              DECODE(C2,1,'S.AVG',VVD) VVD," ).append("\n"); 
		query.append("              C1, C2, C3," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN ( C1=0 AND C2= 1 AND C3 = 0 ) OR C3 = 1 THEN NULL" ).append("\n"); 
		query.append("              ELSE ETB" ).append("\n"); 
		query.append("              END ETB," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN ( C1=0 AND C2= 1 AND C3 = 0 ) OR C3 = 1 THEN NULL" ).append("\n"); 
		query.append("              ELSE ETD" ).append("\n"); 
		query.append("              END ETD," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN ( C1=0 AND C2= 1 AND C3 = 0 ) OR C3 = 1 THEN NULL" ).append("\n"); 
		query.append("              ELSE ATA" ).append("\n"); 
		query.append("              END ATA," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN ( C1=0 AND C2= 1 AND C3 = 0 ) OR C3 = 1 THEN NULL" ).append("\n"); 
		query.append("              ELSE ATB" ).append("\n"); 
		query.append("              END ATB," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN ( C1=0 AND C2= 1 AND C3 = 0 ) OR C3 = 1 THEN NULL" ).append("\n"); 
		query.append("              ELSE ATD" ).append("\n"); 
		query.append("              END ATD," ).append("\n"); 
		query.append("              ARR_DELAY," ).append("\n"); 
		query.append("              ARR_WAIT," ).append("\n"); 
		query.append("              PORT_DELAY," ).append("\n"); 
		query.append("              PORT_WORK," ).append("\n"); 
		query.append("              DEP_DELAY," ).append("\n"); 
		query.append("              TUG_IN," ).append("\n"); 
		query.append("              TUG_OUT," ).append("\n"); 
		query.append("              CGO_FL," ).append("\n"); 
		query.append("              CGO_MT," ).append("\n"); 
		query.append("              RH_MVS," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN ( C1=0 AND C2= 1 AND C3 = 0 ) OR C3 = 1 THEN NULL" ).append("\n"); 
		query.append("              ELSE RH_RATIO" ).append("\n"); 
		query.append("              END RH_RATIO," ).append("\n"); 
		query.append("              TOT_MVS," ).append("\n"); 
		query.append("              WORK_GROSS," ).append("\n"); 
		query.append("              WORK_NET," ).append("\n"); 
		query.append("              GANG_GROSS," ).append("\n"); 
		query.append("              GANG_NET," ).append("\n"); 
		query.append("              WORK_PRD_GROSS," ).append("\n"); 
		query.append("              WORK_PRD_NET," ).append("\n"); 
		query.append("              GANG_PRD_GROSS," ).append("\n"); 
		query.append("              GANG_PRD_NET" ).append("\n"); 
		query.append("       FROM ( SELECT S.VSL_SLAN_CD                                                 LANE," ).append("\n"); 
		query.append("                     C.VVD," ).append("\n"); 
		query.append("                     MAX(R.PF_ETB_DT)                                              ETB," ).append("\n"); 
		query.append("                     MAX(R.PF_ETD_DT)                                              ETD," ).append("\n"); 
		query.append("                     MAX(C.ARR)                                                    ATA," ).append("\n"); 
		query.append("                     MAX(C.BRTH)                                                   ATB," ).append("\n"); 
		query.append("                     MAX(C.DEP)                                                    ATD," ).append("\n"); 
		query.append("                     CASE" ).append("\n"); 
		query.append("                     WHEN GROUPING(S.VSL_SLAN_CD)=0 AND GROUPING(C.VVD)=0 THEN 1" ).append("\n"); 
		query.append("                     ELSE 0" ).append("\n"); 
		query.append("                     END C1," ).append("\n"); 
		query.append("                     CASE" ).append("\n"); 
		query.append("                     WHEN GROUPING(S.VSL_SLAN_CD)=0 AND GROUPING(C.VVD)=1 THEN 1" ).append("\n"); 
		query.append("                     ELSE 0" ).append("\n"); 
		query.append("                     END C2," ).append("\n"); 
		query.append("                     CASE" ).append("\n"); 
		query.append("                     WHEN GROUPING(S.VSL_SLAN_CD)=1 AND GROUPING(C.VVD)=1 THEN 1" ).append("\n"); 
		query.append("                     ELSE 0" ).append("\n"); 
		query.append("                     END C3," ).append("\n"); 
		query.append("                     ROUND(DECODE(SUM(DECODE(R.PF_ETB_DT,NULL,0,1)),0,0," ).append("\n"); 
		query.append("                       (SUM(NVL(C.ARR - R.PF_ETB_DT + (@[manu_in_time]/24),0)) * 24) / " ).append("\n"); 
		query.append("                        SUM(DECODE(R.PF_ETB_DT,NULL,0,1))),1)                                     ARR_DELAY," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(C.BRTH - C.ARR - (@[manu_in_time]/24),0)) * 24, 1)               ARR_WAIT," ).append("\n"); 
		query.append("                     ROUND(DECODE(SUM(DECODE(R.PF_ETB_DT,NULL,0,1)),0,0," ).append("\n"); 
		query.append("                       (SUM(NVL((C.DEP - C.BRTH) - (R.PF_ETD_DT - R.PF_ETB_DT),0)) * 24) / " ).append("\n"); 
		query.append("                        SUM(DECODE(R.PF_ETB_DT,NULL,0,1))),1)                                     PORT_DELAY," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL((C.DEP - C.BRTH),0)) * 24, 1)                                  PORT_WORK," ).append("\n"); 
		query.append("                     ROUND(DECODE(SUM(DECODE(R.PF_ETB_DT,NULL,0,1)),0,0," ).append("\n"); 
		query.append("                       (SUM(NVL((C.DEP - R.PF_ETD_DT),0)) * 24) / " ).append("\n"); 
		query.append("                        SUM(DECODE(R.PF_ETB_DT,NULL,0,1))),1)                                     DEP_DELAY," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(C.ATUG,0)),1)                                                  TUG_IN," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(C.DTUG,0)),1)                                                  TUG_OUT," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(C.FL,0)),1)                                                    CGO_FL," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(C.MT,0)),1)                                                    CGO_MT," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(C.MVS,0)),1)                                                   RH_MVS," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(C.MVS/NVL((NVL(C.FL,0)+NVL(C.MT,0)+NVL(C.MVS,0)),1),0))*100,1) RH_RATIO," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(C.FL,0)+NVL(C.MT,0)+NVL(C.MVS,0)),1)                           TOT_MVS," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(TO_NUMBER(SUBSTR(T.GROSS_WORK,1,INSTR(T.GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(T.GROSS_WORK,INSTR(T.GROSS_WORK,':')+1)/60),0)),1) WORK_GROSS," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(TO_NUMBER(SUBSTR(T.NET_WORK,1,INSTR(T.NET_WORK,':')-1))+TO_NUMBER(SUBSTR(T.NET_WORK,INSTR(T.NET_WORK,':')+1)/60),0)),1)         WORK_NET," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(TO_NUMBER(SUBSTR(T.GROSS_GANG,1,INSTR(T.GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(T.GROSS_GANG,INSTR(T.GROSS_GANG,':')+1)/60),0)),1) GANG_GROSS," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(TO_NUMBER(SUBSTR(T.NET_GANG,1,INSTR(T.NET_GANG,':')-1))+TO_NUMBER(SUBSTR(T.NET_GANG,INSTR(T.NET_GANG,':')+1)/60),0)),1)         GANG_NET," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(T.GROSS_TML,0)),1)                              WORK_PRD_GROSS," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(T.NET_TML,0)),1)                                WORK_PRD_NET," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(T.GROSS_GC,0)),1)                               GANG_PRD_GROSS," ).append("\n"); 
		query.append("                     ROUND(AVG(NVL(T.NET_GC,0)),1)                                 GANG_PRD_NET" ).append("\n"); 
		query.append("              FROM   ( SELECT A.VVD," ).append("\n"); 
		query.append("                              A.CAL," ).append("\n"); 
		query.append("                              A.PORT," ).append("\n"); 
		query.append("                              A.STS," ).append("\n"); 
		query.append("                              A.ARR," ).append("\n"); 
		query.append("                              A.BRTH," ).append("\n"); 
		query.append("                              A.DEP," ).append("\n"); 
		query.append("                              A.ATUG," ).append("\n"); 
		query.append("                              A.DTUG," ).append("\n"); 
		query.append("                              A.ETD," ).append("\n"); 
		query.append("                              A.ETB," ).append("\n"); 
		query.append("                              A.FL," ).append("\n"); 
		query.append("                              A.MT," ).append("\n"); 
		query.append("                              B.MVS" ).append("\n"); 
		query.append("                       FROM   ( SELECT S.PORT_CD                    PORT," ).append("\n"); 
		query.append("                                       V.LANE                       LANE," ).append("\n"); 
		query.append("                                       S.VSL_CD||S.VOY_NO||S.DIR_CD VVD," ).append("\n"); 
		query.append("                                       M.CRR_CD                     OPR," ).append("\n"); 
		query.append("                                       V.CAL," ).append("\n"); 
		query.append("                                       V.STS," ).append("\n"); 
		query.append("                                       V.ARR," ).append("\n"); 
		query.append("                                       V.BRTH," ).append("\n"); 
		query.append("                                       V.DEP," ).append("\n"); 
		query.append("                                       V.ATUG," ).append("\n"); 
		query.append("                                       V.DTUG," ).append("\n"); 
		query.append("                                       V.ETD," ).append("\n"); 
		query.append("                                       V.ETB," ).append("\n"); 
		query.append("                                       SUM(DECODE(S.CNTR_TYPE,'E',0,QTY)) FL," ).append("\n"); 
		query.append("                                       SUM(DECODE(S.CNTR_TYPE,'E',QTY,0)) MT" ).append("\n"); 
		query.append("                                FROM   TDR_SUMMARY S, MDM_VSL_CNTR M," ).append("\n"); 
		query.append("                                       ( SELECT   A.VSL_CD          VSL, " ).append("\n"); 
		query.append("                                                  A.SKD_VOY_NO      VOY, " ).append("\n"); 
		query.append("                                                  A.SKD_DIR_CD      DIR, " ).append("\n"); 
		query.append("                                                  A.VPS_PORT_CD     LOC, " ).append("\n"); 
		query.append("                                                  A.CLPT_IND_SEQ    CAL, " ).append("\n"); 
		query.append("                                                  A.SLAN_CD         LANE," ).append("\n"); 
		query.append("                                                  B.PORT_SKD_STS_CD STS," ).append("\n"); 
		query.append("                                                  B.ACT_ARR_DT      ARR," ).append("\n"); 
		query.append("                                                  B.ACT_BRTH_DT     BRTH," ).append("\n"); 
		query.append("                                                  B.ACT_DEP_DT      DEP," ).append("\n"); 
		query.append("                                                  B.ARR_TUG_BOT_KNT ATUG," ).append("\n"); 
		query.append("                                                  B.DEP_TUG_BOT_KNT DTUG," ).append("\n"); 
		query.append("                                                  A.VPS_ETD_DT      ETD," ).append("\n"); 
		query.append("                                                  A.VPS_ETB_DT      ETB" ).append("\n"); 
		query.append("                                         FROM     VSK_VSL_PORT_SKD A, VSK_ACT_PORT_SKD B  " ).append("\n"); 
		query.append("                                         WHERE    A.VSL_CD          = B.VSL_CD " ).append("\n"); 
		query.append("                                         AND      A.SKD_VOY_NO      = B.SKD_VOY_NO " ).append("\n"); 
		query.append("                                         AND      A.SKD_DIR_CD      = B.SKD_DIR_CD " ).append("\n"); 
		query.append("                                         AND      A.VPS_PORT_CD     = B.VPS_PORT_CD " ).append("\n"); 
		query.append("                                         AND      A.CLPT_IND_SEQ    = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("                                         AND      A.SLAN_CD         LIKE @[slan_cd]||'%'                                          --:lane_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${yd_cd} == 'All')" ).append("\n"); 
		query.append("                                         AND      A.YD_CD           LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND      A.YD_CD           LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                         AND      B.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("                                         AND      B.ACT_DEP_DT      BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')              --:fm_dt" ).append("\n"); 
		query.append("                                                                    AND     TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD') + 0.99999 ) V  --:to_dt" ).append("\n"); 
		query.append("                                WHERE  S.VSL_CD   = V.VSL " ).append("\n"); 
		query.append("                                AND    S.VOY_NO   = V.VOY " ).append("\n"); 
		query.append("                                AND    S.DIR_CD   = V.DIR " ).append("\n"); 
		query.append("                                AND    S.PORT_CD  = V.LOC " ).append("\n"); 
		query.append("                                AND    S.CALL_IND = V.CAL" ).append("\n"); 
		query.append("                                AND    S.VSL_CD   = M.VSL_CD(+)" ).append("\n"); 
		query.append("                                AND    M.CRR_CD   = DECODE(@[carr_cd], COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(), @[carr_cd], M.CRR_CD)" ).append("\n"); 
		query.append("#if (${carr_cd} == 'O')" ).append("\n"); 
		query.append("                                AND    M.CRR_CD   <> COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()                              --:carr_cd('Other')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_cd} != '')" ).append("\n"); 
		query.append("                                AND    S.DIR_CD   LIKE @[dir_cd]||'%'                                                            --:dir_cd" ).append("\n"); 
		query.append("#end                                " ).append("\n"); 
		query.append("                                GROUP BY S.PORT_CD, V.LANE, S.VSL_CD||S.VOY_NO||S.DIR_CD, M.CRR_CD," ).append("\n"); 
		query.append("                                         V.CAL, V.STS, V.ARR, V.BRTH, V.DEP, V.ATUG, V.DTUG, V.ETD, V.ETB ) A," ).append("\n"); 
		query.append("                              ( SELECT C.PORT_CD                    PORT," ).append("\n"); 
		query.append("                                       V.LANE                       LANE," ).append("\n"); 
		query.append("                                       C.VSL_CD||C.VOY_NO||C.DIR_CD VVD," ).append("\n"); 
		query.append("                                       M.CRR_CD                     OPR," ).append("\n"); 
		query.append("                                       V.CAL," ).append("\n"); 
		query.append("                                       V.STS," ).append("\n"); 
		query.append("                                       V.ARR," ).append("\n"); 
		query.append("                                       V.BRTH," ).append("\n"); 
		query.append("                                       V.DEP," ).append("\n"); 
		query.append("                                       V.ATUG," ).append("\n"); 
		query.append("                                       V.DTUG," ).append("\n"); 
		query.append("                                       V.ETD," ).append("\n"); 
		query.append("                                       V.ETB," ).append("\n"); 
		query.append("                                       SUM(DECODE(C.SHIFT_TYPE,'B',1,0))+SUM(DECODE(C.SHIFT_TYPE,'Q',1,0)*2) MVS" ).append("\n"); 
		query.append("                                FROM   TDR_CNTR_DETAIL C, MDM_VSL_CNTR M," ).append("\n"); 
		query.append("                                       ( SELECT   A.VSL_CD          VSL, " ).append("\n"); 
		query.append("                                                  A.SKD_VOY_NO      VOY, " ).append("\n"); 
		query.append("                                                  A.SKD_DIR_CD      DIR, " ).append("\n"); 
		query.append("                                                  A.VPS_PORT_CD     LOC, " ).append("\n"); 
		query.append("                                                  A.CLPT_IND_SEQ    CAL, " ).append("\n"); 
		query.append("                                                  A.SLAN_CD         LANE," ).append("\n"); 
		query.append("                                                  B.PORT_SKD_STS_CD STS," ).append("\n"); 
		query.append("                                                  B.ACT_ARR_DT      ARR," ).append("\n"); 
		query.append("                                                  B.ACT_BRTH_DT     BRTH," ).append("\n"); 
		query.append("                                                  B.ACT_DEP_DT      DEP," ).append("\n"); 
		query.append("                                                  B.ARR_TUG_BOT_KNT ATUG," ).append("\n"); 
		query.append("                                                  B.DEP_TUG_BOT_KNT DTUG," ).append("\n"); 
		query.append("                                                  A.VPS_ETD_DT      ETD," ).append("\n"); 
		query.append("                                                  A.VPS_ETB_DT      ETB" ).append("\n"); 
		query.append("                                         FROM     VSK_VSL_PORT_SKD A, VSK_ACT_PORT_SKD B  " ).append("\n"); 
		query.append("                                         WHERE    A.VSL_CD          = B.VSL_CD " ).append("\n"); 
		query.append("                                         AND      A.SKD_VOY_NO      = B.SKD_VOY_NO " ).append("\n"); 
		query.append("                                         AND      A.SKD_DIR_CD      = B.SKD_DIR_CD " ).append("\n"); 
		query.append("                                         AND      A.VPS_PORT_CD     = B.VPS_PORT_CD " ).append("\n"); 
		query.append("                                         AND      A.CLPT_IND_SEQ    = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("                                         AND      A.SLAN_CD         LIKE @[slan_cd]||'%'                                          --:lane_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${yd_cd} == 'All')" ).append("\n"); 
		query.append("                                         AND      A.YD_CD           LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND      A.YD_CD           LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end                                     " ).append("\n"); 
		query.append("                                         AND      B.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("                                         AND      B.ACT_DEP_DT      BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')              --:fm_dt" ).append("\n"); 
		query.append("                                                                    AND     TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD') + 0.99999 ) V  --:to_dt" ).append("\n"); 
		query.append("                                WHERE  C.VSL_CD   = V.VSL " ).append("\n"); 
		query.append("                                AND    C.VOY_NO   = V.VOY " ).append("\n"); 
		query.append("                                AND    C.DIR_CD   = V.DIR " ).append("\n"); 
		query.append("                                AND    C.PORT_CD  = V.LOC " ).append("\n"); 
		query.append("                                AND    C.CALL_IND = V.CAL" ).append("\n"); 
		query.append("                                AND    TRIM(C.PRECELL) IS NOT NULL" ).append("\n"); 
		query.append("                                AND    C.VSL_CD   = M.VSL_CD(+)" ).append("\n"); 
		query.append("                                AND    M.CRR_CD   = DECODE(@[carr_cd], COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(), @[carr_cd], M.CRR_CD)" ).append("\n"); 
		query.append("#if (${carr_cd} == 'O')" ).append("\n"); 
		query.append("                                AND    M.CRR_CD   <> COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()                              --:carr_cd('Other')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_cd} != '')" ).append("\n"); 
		query.append("                                AND    C.DIR_CD   LIKE @[dir_cd]||'%'                                                            --:dir_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                GROUP BY C.PORT_CD, V.LANE, C.VSL_CD||C.VOY_NO||C.DIR_CD, M.CRR_CD," ).append("\n"); 
		query.append("                                         V.CAL, V.STS, V.ARR, V.BRTH, V.DEP, V.ATUG, V.DTUG, V.ETD, V.ETB ) B" ).append("\n"); 
		query.append("                       WHERE A.PORT     = B.PORT(+)" ).append("\n"); 
		query.append("                       AND   A.LANE     = B.LANE(+)" ).append("\n"); 
		query.append("                       AND   A.VVD      = B.VVD(+)" ).append("\n"); 
		query.append("                       AND   A.OPR      = B.OPR(+)" ).append("\n"); 
		query.append("                       AND   A.CAL      = B.CAL(+)" ).append("\n"); 
		query.append("                       AND   A.STS      = B.STS(+)" ).append("\n"); 
		query.append("                       AND   A.ARR      = B.ARR(+)" ).append("\n"); 
		query.append("                       AND   A.BRTH     = B.BRTH(+)" ).append("\n"); 
		query.append("                       AND   A.DEP      = B.DEP(+)" ).append("\n"); 
		query.append("                       AND   A.ATUG     = B.ATUG(+)" ).append("\n"); 
		query.append("                       AND   A.DTUG     = B.DTUG(+)" ).append("\n"); 
		query.append("                       AND   A.ETD      = B.ETD(+)" ).append("\n"); 
		query.append("                       AND   A.ETB      = B.ETB(+) ) 	C" ).append("\n"); 
		query.append("					,	TDR_HEADER 						T" ).append("\n"); 
		query.append("					,	VSK_VSL_PORT_SKD 				R" ).append("\n"); 
		query.append("					,	VSK_VSL_SKD 					S" ).append("\n"); 
		query.append("              WHERE  SUBSTR(C.VVD,1,4) = T.VSL_CD(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,5,4) = T.VOY_NO(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,9,1) = T.DIR_CD(+)" ).append("\n"); 
		query.append("              AND    C.PORT            = T.PORT_CD(+)" ).append("\n"); 
		query.append("              AND    C.CAL             = T.CALL_IND(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,1,4) = R.VSL_CD(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,5,4) = R.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,9,1) = R.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("              AND    C.PORT            = R.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("              AND    C.CAL             = R.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,1,4) = S.VSL_CD" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,5,4) = S.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND    SUBSTR(C.VVD,9,1) = S.SKD_DIR_CD        " ).append("\n"); 
		query.append("              GROUP BY CUBE( S.VSL_SLAN_CD, C.VVD) )" ).append("\n"); 
		query.append("       WHERE ( C1 = 0 AND C2 = 0 AND C3 = 1 ) OR ( C1 = 0 AND C2 = 1 AND C3 = 0 ) )" ).append("\n"); 
		query.append("ORDER BY DECODE(LANE,'G.AVG','ZZZ','G.Sum','YYY',LANE), DECODE(VVD,'S.AVG','ZZZZZZZZZ','S.Sum','YYYYYYYYY',VVD), ETD" ).append("\n"); 

	}
}