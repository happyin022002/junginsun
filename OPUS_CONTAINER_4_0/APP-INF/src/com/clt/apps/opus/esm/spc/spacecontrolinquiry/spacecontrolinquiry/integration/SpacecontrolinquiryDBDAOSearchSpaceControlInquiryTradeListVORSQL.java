/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquiryTradeListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOSearchSpaceControlInquiryTradeListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.04.20 Vessel Schedule 로직 추가 by 서관영
	  * 2016.05.12 SPC_GET_HC_RT_BSA_FNC : SKD_VOY_NO parm 추가
	  * 2016.07.05 SPC_BKG_V 제거하고 Booking 데이터 직접 핸들링
	  * 2016.07.19 #15529 AOC- JPN Issue cannot create BKG for T2 + Refeer
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSearchSpaceControlInquiryTradeListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("only_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_txt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onc_ipc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("week2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year2",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquiryTradeListVORSQL").append("\n"); 
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
		query.append("WITH PARAMS AS (" ).append("\n"); 
		query.append("    SELECT @[year]     AS YR_FR     ," ).append("\n"); 
		query.append("           @[week]     AS WK_FR     ," ).append("\n"); 
		query.append("           @[year2]    AS YR_TO     ," ).append("\n"); 
		query.append("           @[week2]    AS WK_TO     ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${user_ofc} == 'SHADSC')" ).append("\n"); 
		query.append("           @[user_ofc] AS OFC_CD    ," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           @[rhq_txt]  AS OFC_CD    ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           @[trade]    AS TRD_CD    ," ).append("\n"); 
		query.append("           @[subtrade] AS SUB_TRD_CD," ).append("\n"); 
		query.append("           @[lane]     AS RLANE_CD  ," ).append("\n"); 
		query.append("           @[bound]    AS DIR_CD    ," ).append("\n"); 
		query.append("           @[onc_ipc]  AS IOC_CD    ," ).append("\n"); 
		query.append("           @[only_vvd] AS VVD" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VVDS AS (" ).append("\n"); 
		query.append("    SELECT SUBSTR(V.SLS_YRMON, 1, 4) AS COST_YR," ).append("\n"); 
		query.append("           V.COST_WK   ," ).append("\n"); 
		query.append("           V.SLS_YRMON ," ).append("\n"); 
		query.append("           V.TRD_CD    ," ).append("\n"); 
		query.append("           V.SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.DIR_CD    ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("           V.IOC_CD    ," ).append("\n"); 
		query.append("           P.OFC_CD AS OFC_CD    ," ).append("\n"); 
		query.append("           SPC_GET_WK_VVD_BSA_FNC('VOL'    , RL.REP_TRD_CD, V.RLANE_CD, V.DIR_CD, SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK, V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD) AS BSA     ," ).append("\n"); 
		query.append("           SPC_GET_WK_VVD_BSA_FNC('VOL_LOD', RL.REP_TRD_CD, V.RLANE_CD, V.DIR_CD, SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK, V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD) AS LOADABLE" ).append("\n"); 
		query.append("      FROM MDM_REV_LANE RL," ).append("\n"); 
		query.append("           COA_MON_VVD  V ," ).append("\n"); 
		query.append("           PARAMS       P" ).append("\n"); 
		query.append("     WHERE RL.RLANE_CD = V.RLANE_CD" ).append("\n"); 
		query.append("       AND V.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("       AND V.IOC_CD     LIKE P.IOC_CD     || '%'" ).append("\n"); 
		query.append("       AND V.DIR_CD     LIKE P.DIR_CD     || '%'" ).append("\n"); 
		query.append("       AND V.RLANE_CD   LIKE P.RLANE_CD   || '%'" ).append("\n"); 
		query.append("       AND V.SUB_TRD_CD LIKE P.SUB_TRD_CD || '%'" ).append("\n"); 
		query.append("       AND V.TRD_CD   <> 'COM'" ).append("\n"); 
		query.append("       AND V.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("       AND V.TRD_CD LIKE P.TRD_CD || '%'" ).append("\n"); 
		query.append("       AND SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK BETWEEN YR_FR||WK_FR AND YR_TO||WK_TO" ).append("\n"); 
		query.append("       AND P.VVD IS NULL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT SUBSTR(V.SLS_YRMON, 1, 4) AS COST_YR," ).append("\n"); 
		query.append("           V.COST_WK   ," ).append("\n"); 
		query.append("           V.SLS_YRMON ," ).append("\n"); 
		query.append("           V.TRD_CD    ," ).append("\n"); 
		query.append("           V.SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.DIR_CD    ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("           V.IOC_CD," ).append("\n"); 
		query.append("           P.OFC_CD AS OFC_CD    ," ).append("\n"); 
		query.append("           SPC_GET_WK_VVD_BSA_FNC('VOL'    , RL.REP_TRD_CD, V.RLANE_CD, V.DIR_CD, SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK, V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD) AS BSA     ," ).append("\n"); 
		query.append("           SPC_GET_WK_VVD_BSA_FNC('VOL_LOD', RL.REP_TRD_CD, V.RLANE_CD, V.DIR_CD, SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK, V.VSL_CD||V.SKD_VOY_NO||V.DIR_CD) AS LOADABLE" ).append("\n"); 
		query.append("      FROM MDM_REV_LANE RL," ).append("\n"); 
		query.append("           COA_MON_VVD  V ," ).append("\n"); 
		query.append("           PARAMS       P " ).append("\n"); 
		query.append("      WHERE RL.RLANE_CD  = V.RLANE_CD" ).append("\n"); 
		query.append("       AND V.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("       AND V.DIR_CD     = SUBSTR(P.VVD, 9, 1)" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO = SUBSTR(P.VVD, 5, 4)" ).append("\n"); 
		query.append("       AND V.VSL_CD     = SUBSTR(P.VVD, 1, 4)" ).append("\n"); 
		query.append("       AND V.IOC_CD LIKE P.IOC_CD || '%'" ).append("\n"); 
		query.append("       AND P.VVD IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", VSL_PORT_SKD AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           V.COST_YR," ).append("\n"); 
		query.append("           V.COST_WK   ," ).append("\n"); 
		query.append("           V.SLS_YRMON ," ).append("\n"); 
		query.append("           V.TRD_CD    ," ).append("\n"); 
		query.append("           V.SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.DIR_CD    ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.SKD_DIR_CD," ).append("\n"); 
		query.append("           V.IOC_CD," ).append("\n"); 
		query.append("           V.OFC_CD    ," ).append("\n"); 
		query.append("           V. BSA      ," ).append("\n"); 
		query.append("           V.LOADABLE  ," ).append("\n"); 
		query.append("           NVL(VPS.YD_CD, VPS.VPS_PORT_CD) AS PORT_CD," ).append("\n"); 
		query.append("           VPS.CLPT_SEQ         AS PORT_SEQ," ).append("\n"); 
		query.append("           MAX(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD), VPS.VSL_CD, VPS.SKD_VOY_NO, VPS.SKD_DIR_CD) AS MAX_SEQ," ).append("\n"); 
		query.append("           MIN(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD), VPS.VSL_CD, VPS.SKD_VOY_NO, VPS.SKD_DIR_CD) AS MIN_SEQ," ).append("\n"); 
		query.append("           VPS.CLPT_IND_SEQ  AS CLPT_IND_SEQ" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("      FROM MDM_LOCATION      L  ," ).append("\n"); 
		query.append("           VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("           VVDS               V" ).append("\n"); 
		query.append("     WHERE L.LOC_CD       = VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("       AND VPS.VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("       AND VPS.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VPS.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND NVL(VPS.SKD_CNG_STS_CD,'1') <> 'S'" ).append("\n"); 
		query.append("       AND VPS.VT_ADD_CALL_FLG IS  NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", VVD_POL_POD AS (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          SELECT " ).append("\n"); 
		query.append("                 PL.COST_YR       ," ).append("\n"); 
		query.append("                 PL.COST_WK       ," ).append("\n"); 
		query.append("                 PL.SLS_YRMON     ," ).append("\n"); 
		query.append("                 PL.TRD_CD        ," ).append("\n"); 
		query.append("                 PL.SUB_TRD_CD    ," ).append("\n"); 
		query.append("                 PL.RLANE_CD      ," ).append("\n"); 
		query.append("                 PL.DIR_CD        ," ).append("\n"); 
		query.append("                 PL.VSL_CD        ," ).append("\n"); 
		query.append("                 PL.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                 PL.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                 PL.IOC_CD        ," ).append("\n"); 
		query.append("                 PL.OFC_CD        ," ).append("\n"); 
		query.append("                 PL. BSA          ," ).append("\n"); 
		query.append("                 PL.LOADABLE      ," ).append("\n"); 
		query.append("                 PL.PORT_CD         AS POL_CD    ," ).append("\n"); 
		query.append("                 MAX(PL.PORT_SEQ)   AS POL_SEQ   ," ).append("\n"); 
		query.append("                 PL.CLPT_IND_SEQ    AS PL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                 PD.PORT_CD         AS POD_CD    ," ).append("\n"); 
		query.append("                 (CASE" ).append("\n"); 
		query.append("                       WHEN MAX(PL.PORT_SEQ) < MAX(PD.MIN_SEQ) THEN MAX(PD.MIN_SEQ)" ).append("\n"); 
		query.append("                                                               ELSE CASE" ).append("\n"); 
		query.append("                                                                         WHEN MAX(PL.PORT_SEQ) > MAX(PD.MIN_SEQ) THEN MAX(PD.MAX_SEQ)" ).append("\n"); 
		query.append("                                                                     END" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("                 ) AS POD_SEQ," ).append("\n"); 
		query.append("                 PD.CLPT_IND_SEQ   AS PD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            FROM    " ).append("\n"); 
		query.append("                 VSL_PORT_SKD     PD ," ).append("\n"); 
		query.append("                 VSL_PORT_SKD     PL" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("             AND PD.TRD_CD       = PL.TRD_CD" ).append("\n"); 
		query.append("             AND PD.SUB_TRD_CD   = PL.SUB_TRD_CD" ).append("\n"); 
		query.append("             AND PD.RLANE_CD     = PL.RLANE_CD" ).append("\n"); 
		query.append("             AND PD.VSL_CD       = PL.VSL_CD" ).append("\n"); 
		query.append("             AND PD.SKD_VOY_NO   = PL.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND PD.SKD_DIR_CD   = PL.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND PD.PORT_CD      <> PL.PORT_CD" ).append("\n"); 
		query.append("             AND PD.PORT_SEQ      > PL.PORT_SEQ" ).append("\n"); 
		query.append("             AND (PL.PORT_SEQ = PL.MAX_SEQ  OR PD.PORT_SEQ < PL.MAX_SEQ )                     " ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("             GROUP BY " ).append("\n"); 
		query.append("                 PL.COST_YR       ," ).append("\n"); 
		query.append("                 PL.COST_WK       ," ).append("\n"); 
		query.append("                 PL.SLS_YRMON     ," ).append("\n"); 
		query.append("                 PL.TRD_CD        ," ).append("\n"); 
		query.append("                 PL.SUB_TRD_CD    ," ).append("\n"); 
		query.append("                 PL.RLANE_CD      ," ).append("\n"); 
		query.append("                 PL.DIR_CD        ," ).append("\n"); 
		query.append("                 PL.VSL_CD        ," ).append("\n"); 
		query.append("                 PL.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                 PL.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                 PL.IOC_CD        ," ).append("\n"); 
		query.append("                 PL.PORT_CD       ," ).append("\n"); 
		query.append("                 PD.PORT_CD       ," ).append("\n"); 
		query.append("                 PL.OFC_CD        ," ).append("\n"); 
		query.append("                 PL. BSA          ," ).append("\n"); 
		query.append("                 PL.LOADABLE      ," ).append("\n"); 
		query.append("                 PL.CLPT_IND_SEQ  ," ).append("\n"); 
		query.append("                 PD.CLPT_IND_SEQ        " ).append("\n"); 
		query.append("                 )            " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(", QTA_DATA AS (" ).append("\n"); 
		query.append("    SELECT M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           M.COST_YR   ," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.SKD_DIR_CD," ).append("\n"); 
		query.append("           M.IOC_CD    ," ).append("\n"); 
		query.append("           ROUND(SUM(D.LOD_QTY)) AS VOL," ).append("\n"); 
		query.append("           SUM((D.GRS_RPB_REV - D.CM_UC_AMT) * D.LOD_QTY) AS CM" ).append("\n"); 
		query.append("      FROM VVDS             M," ).append("\n"); 
		query.append("           SAQ_MON_CFM_QTA  D," ).append("\n"); 
		query.append("           SAQ_MON_QTA_RLSE B" ).append("\n"); 
		query.append("     WHERE B.BSE_YR           = M.COST_YR" ).append("\n"); 
		query.append("       AND B.BSE_QTR_CD       = CEIL(TO_NUMBER(SUBSTR(M.SLS_YRMON, 5, 2)) / 3)||'Q'" ).append("\n"); 
		query.append("       AND B.QTA_RLSE_STS_CD  = 'R'" ).append("\n"); 
		query.append("       AND D.MQTA_RLSE_VER_NO = B.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("       AND D.BSE_YR           = B.BSE_YR" ).append("\n"); 
		query.append("       AND D.BSE_QTR_CD       = B.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND D.QTA_TGT_CD       = 'T'" ).append("\n"); 
		query.append("       AND D.TRD_CD           = M.TRD_CD" ).append("\n"); 
		query.append("       AND D.RLANE_CD         = M.RLANE_CD" ).append("\n"); 
		query.append("       AND D.DIR_CD           = M.DIR_CD" ).append("\n"); 
		query.append("       AND D.VSL_CD           = M.VSL_CD" ).append("\n"); 
		query.append("       AND D.SKD_VOY_NO       = M.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND D.SKD_DIR_CD       = M.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND (M.OFC_CD IS NULL OR D.RHQ_CD = M.OFC_CD OR D.AQ_CD = M.OFC_CD)" ).append("\n"); 
		query.append("  GROUP BY M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           M.COST_YR   ," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.SKD_DIR_CD," ).append("\n"); 
		query.append("           M.IOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", FCST_DATA AS (" ).append("\n"); 
		query.append("    SELECT M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           M.COST_YR   ," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.SKD_DIR_CD," ).append("\n"); 
		query.append("           M.IOC_CD    ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           NVL(SUM(DECODE(D.IOC_TS_CD, 'T', 0, NVL(D.CFM_TTL_QTY, 0) + NVL(D.CFM_40FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(D.TRD_CD ,D.RLANE_CD ,D.DIR_CD ,D.VSL_CD, D.SKD_VOY_NO,'D5') + NVL(D.CFM_45FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(D.TRD_CD ,D.RLANE_CD ,D.DIR_CD ,D.VSL_CD, D.SKD_VOY_NO, 'D7') +  NVL(D.FCAST_53FT_QTY, 0) * 2)),0)  AS VOL," ).append("\n"); 
		query.append("           NVL(SUM(DECODE(D.IOC_TS_CD, 'T', 0, D.CFM_TTL_WGT)),0) AS WGT," ).append("\n"); 
		query.append("           NVL(SUM(DECODE(D.IOC_TS_CD, 'T', NVL(D.CFM_TTL_QTY, 0) + NVL(D.CFM_40FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(D.TRD_CD ,D.RLANE_CD ,D.DIR_CD ,D.VSL_CD, D.SKD_VOY_NO, 'D5') + NVL(D.CFM_45FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(D.TRD_CD ,D.RLANE_CD ,D.DIR_CD ,D.VSL_CD, D.SKD_VOY_NO, 'D7') +  NVL(D.FCAST_53FT_QTY, 0) * 2)),0)  AS FCT_TS_VOL," ).append("\n"); 
		query.append("           NVL(SUM(DECODE(D.IOC_TS_CD, 'T', D.CFM_TTL_WGT)),0) FCT_TS_WGT" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("      FROM VVD_POL_POD        M," ).append("\n"); 
		query.append("           SPC_DLY_FCAST_CUST D" ).append("\n"); 
		query.append("     WHERE D.TRD_CD     = M.TRD_CD" ).append("\n"); 
		query.append("       AND D.SUB_TRD_CD = M.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND D.RLANE_CD   = M.RLANE_CD" ).append("\n"); 
		query.append("       AND D.DIR_CD     = M.DIR_CD" ).append("\n"); 
		query.append("       AND D.VSL_CD     = M.VSL_CD" ).append("\n"); 
		query.append("       AND D.SKD_VOY_NO = M.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND D.SKD_DIR_CD = M.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND D.POL_YD_CD   = M.POL_CD" ).append("\n"); 
		query.append("       AND D.POD_YD_CD   = M.POD_CD" ).append("\n"); 
		query.append("       AND NVL(D.POL_IND_SEQ,1) = NVL(M.PL_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("       AND NVL(D.POD_IND_SEQ,1) = NVL(M.PD_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("       --AND D.IOC_TS_CD  = M.IOC_CD" ).append("\n"); 
		query.append("       AND (M.OFC_CD IS NULL OR D.SLS_RHQ_CD = M.OFC_CD OR D.SLS_AQ_CD = M.OFC_CD)" ).append("\n"); 
		query.append("  GROUP BY M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           M.COST_YR   ," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.SKD_DIR_CD," ).append("\n"); 
		query.append("           M.IOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", ALOC_DATA AS (" ).append("\n"); 
		query.append("    SELECT M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           M.COST_YR   ," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.SKD_DIR_CD," ).append("\n"); 
		query.append("           M.IOC_CD    ," ).append("\n"); 
		query.append("           SUM(DECODE(D.TS_FLG, 'N', D.ASGN_TTL_QTY)) AS VOL," ).append("\n"); 
		query.append("           SUM(DECODE(D.TS_FLG, 'N', D.ASGN_TTL_WGT)) AS WGT," ).append("\n"); 
		query.append("           SUM(DECODE(D.TS_FLG, 'Y', D.ASGN_TTL_QTY)) AS ALC_TS_VOL," ).append("\n"); 
		query.append("           SUM(DECODE(D.TS_FLG, 'Y', D.ASGN_TTL_WGT)) AS ALC_TS_WGT" ).append("\n"); 
		query.append("      FROM VVD_POL_POD      M," ).append("\n"); 
		query.append("           SPC_ALOC_POL_POD D" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("     WHERE D.TRD_CD     = M.TRD_CD" ).append("\n"); 
		query.append("       AND D.SUB_TRD_CD = M.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND D.RLANE_CD   = M.RLANE_CD" ).append("\n"); 
		query.append("       AND D.DIR_CD     = M.DIR_CD" ).append("\n"); 
		query.append("       AND D.VSL_CD     = M.VSL_CD" ).append("\n"); 
		query.append("       AND D.SKD_VOY_NO = M.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND D.SKD_DIR_CD = M.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND D.POL_YD_CD   = M.POL_CD" ).append("\n"); 
		query.append("       AND D.POD_YD_CD   = M.POD_CD" ).append("\n"); 
		query.append("       AND NVL(D.POL_IND_SEQ,1) = NVL(M.PL_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("       AND NVL(D.POD_IND_SEQ,1) = NVL(M.PD_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("       AND DECODE(TS_FLG, 'Y', DECODE(D.RLANE_CD, 'IMUAE', 'O', D.IOC_CD), D.IOC_CD) = M.IOC_CD" ).append("\n"); 
		query.append("       AND (M.OFC_CD IS NULL OR D.SLS_RHQ_CD = M.OFC_CD OR D.SLS_AQ_CD = M.OFC_CD)" ).append("\n"); 
		query.append("       AND DECODE(TS_FLG, 'N', '1', DECODE(M.OFC_CD, M.OFC_CD, '1', SLS_RHQ_CD)) = DECODE(TS_FLG, 'N', '1', DECODE(M.OFC_CD, M.OFC_CD, '1', SLS_OFC_CD))" ).append("\n"); 
		query.append("  GROUP BY M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           M.COST_YR   ," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.SKD_DIR_CD," ).append("\n"); 
		query.append("           M.IOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", BKG_DATA AS (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("           TRD_CD    ," ).append("\n"); 
		query.append("           SUB_TRD_CD," ).append("\n"); 
		query.append("           RLANE_CD  ," ).append("\n"); 
		query.append("           DIR_CD    ," ).append("\n"); 
		query.append("           COST_YR   ," ).append("\n"); 
		query.append("           COST_WK   ," ).append("\n"); 
		query.append("           VSL_CD    ," ).append("\n"); 
		query.append("           SKD_VOY_NO," ).append("\n"); 
		query.append("           SKD_DIR_CD," ).append("\n"); 
		query.append("           IOC_CD    ," ).append("\n"); 
		query.append("           SUM(DECODE(TS_FLG,'N',DECODE(BKG_STS_CD, 'F',BKG_TTL_QTY,0),0)) AS TTL_FIRM," ).append("\n"); 
		query.append("           SUM(DECODE(TS_FLG,'N',DECODE(BKG_STS_CD, 'W',BKG_TTL_QTY,0),0)) AS TTL_WAIT," ).append("\n"); 
		query.append("           SUM(DECODE(TS_FLG,'N',BKG_TTL_WGT,0)) AS WGT," ).append("\n"); 
		query.append("           SUM(DECODE(TS_FLG,'N',0,BKG_TTL_QTY)) AS BKG_TS_VOL," ).append("\n"); 
		query.append("           SUM(DECODE(TS_FLG,'N',0,BKG_TTL_WGT)) AS BKG_TS_WGT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                     TRD_CD              ," ).append("\n"); 
		query.append("                     SUB_TRD_CD          ," ).append("\n"); 
		query.append("                     RLANE_CD      		 ," ).append("\n"); 
		query.append("                     DIR_CD              ," ).append("\n"); 
		query.append("                     COST_YR             ," ).append("\n"); 
		query.append("                     COST_WK             ," ).append("\n"); 
		query.append("                     VSL_CD        		 ," ).append("\n"); 
		query.append("                     SKD_VOY_NO    		 ," ).append("\n"); 
		query.append("                     SKD_DIR_CD    		 ," ).append("\n"); 
		query.append("                     IOC_CD              ," ).append("\n"); 
		query.append("                     TS_FLG              ," ).append("\n"); 
		query.append("                     BKG_STS_CD          ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0)) AS BKG_TTL_QTY    ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 15, 14), 0)) AS BKG_20FT_QTY   ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 29, 14), 0)) AS BKG_40FT_QTY   ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 43, 14), 0)) AS BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 57, 14), 0)) AS BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 71, 14), 0)) AS BKG_53FT_QTY   ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 85, 14), 0)) AS BKG_RF_QTY     ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 99, 14), 0)) AS BKG_TTL_WGT" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                        SELECT /*+ ORDERED USE_NL(VPP BV B D) USE_HASH(O) */" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                               VPP.TRD_CD        ," ).append("\n"); 
		query.append("                               VPP.SUB_TRD_CD    ," ).append("\n"); 
		query.append("                               VPP.RLANE_CD      ," ).append("\n"); 
		query.append("                               VPP.DIR_CD        ," ).append("\n"); 
		query.append("                               VPP.VSL_CD        ," ).append("\n"); 
		query.append("                               VPP.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                               VPP.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                               VPP.OFC_CD      AS BASE_RHQ_CD," ).append("\n"); 
		query.append("                               B.OB_SLS_OFC_CD AS SLS_OFC_CD ," ).append("\n"); 
		query.append("                               VPP.COST_YR       ," ).append("\n"); 
		query.append("                               VPP.COST_WK       ," ).append("\n"); 
		query.append("                               VPP.IOC_CD        ," ).append("\n"); 
		query.append("                               DECODE(BV.VSL_PRE_PST_CD, 'T', 'N', 'Y') AS TS_FLG ," ).append("\n"); 
		query.append("                               VPP.POL_CD              ," ).append("\n"); 
		query.append("                               VPP.POD_CD              ," ).append("\n"); 
		query.append("                               B.BKG_STS_CD            ," ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                  SELECT" ).append("\n"); 
		query.append("                                            TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, '5', SPC_GET_HC_RT_BSA_FNC(VPP.TRD_CD ,VPP.RLANE_CD ,VPP.SKD_DIR_CD ,VPP.VSL_CD ,VPP.SKD_VOY_NO,'D5'), '7', SPC_GET_HC_RT_BSA_FNC(VPP.TRD_CD ,VPP.RLANE_CD ,VPP.SKD_DIR_CD ,VPP.VSL_CD ,VPP.SKD_VOY_NO,'D7'), 2) * Q.OP_CNTR_QTY), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '4', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '5', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '7', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), 'W', Q.OP_CNTR_QTY, 0) + DECODE(SAQ_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), 'X', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR(SUM(DECODE(SAQ_GET_CNTR_TP_FNC(Q.CNTR_TPSZ_CD), 'R', Q.OP_CNTR_QTY - Q.EQ_SUBST_CGO_QTY, 0) + DECODE(SAQ_GET_CNTR_TP_FNC(Q.CNTR_TPSZ_CD), 'T', Q.RC_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                         || TO_CHAR((D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001))" ).append("\n"); 
		query.append("                                                                 + SUM(Q.OP_CNTR_QTY * ( SELECT TS.CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("                                                                                           FROM MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append("                                                                                          WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD)) * 0.001, 'FM0000000000.000')" ).append("\n"); 
		query.append("                                    FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("                                   WHERE B.BKG_NO      = Q.BKG_NO" ).append("\n"); 
		query.append("                                     AND Q.OP_CNTR_QTY > 0" ).append("\n"); 
		query.append("                               ) AS VAL" ).append("\n"); 
		query.append("                         FROM  VVD_POL_POD VPP," ).append("\n"); 
		query.append("                               BKG_VVD     BV ," ).append("\n"); 
		query.append("                               BKG_BOOKING B  ," ).append("\n"); 
		query.append("                               SPC_OFC_LVL O  ," ).append("\n"); 
		query.append("                               BKG_BL_DOC  D" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND (VPP.TRD_CD,VPP.SUB_TRD_CD,VPP.RLANE_CD,VPP.IOC_CD)  =  (" ).append("\n"); 
		query.append("                                                                                        SELECT   B.TRD_CD,B.SUB_TRD_CD ,B.RLANE_CD, DECODE(B.FM_CONTI_CD,B.TO_CONTI_CD,'I','O')" ).append("\n"); 
		query.append("                                                                                        FROM MDM_REV_LANE A,  MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append("                                                                                        WHERE B.RLANE_CD = A.RLANE_CD" ).append("\n"); 
		query.append("                                                                                          AND B.RLANE_CD LIKE BV.SLAN_CD||'%'" ).append("\n"); 
		query.append("                                                                                          AND B.FM_CONTI_CD = (" ).append("\n"); 
		query.append("                                                                                                                SELECT MLOC.CONTI_CD" ).append("\n"); 
		query.append("                                                                                                                FROM MDM_LOCATION MLOC" ).append("\n"); 
		query.append("                                                                                                                WHERE MLOC.LOC_CD = BV.POL_CD " ).append("\n"); 
		query.append("                                                                                                              )" ).append("\n"); 
		query.append("                                                                                          AND B.TO_CONTI_CD = (" ).append("\n"); 
		query.append("                                                                                                                SELECT MLOC.CONTI_CD" ).append("\n"); 
		query.append("                                                                                                                FROM MDM_LOCATION MLOC" ).append("\n"); 
		query.append("                                                                                                                WHERE MLOC.LOC_CD = BV.POD_CD " ).append("\n"); 
		query.append("                                                                                                               )" ).append("\n"); 
		query.append("                                                                                          AND B.VSL_SLAN_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                          AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                                                          AND ROWNUM = 1 " ).append("\n"); 
		query.append("                                                                                      ) " ).append("\n"); 
		query.append("                           AND O.OFC_TP_CD     IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                           AND O.OFC_CD         = B.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("                           AND VPP.COST_YR || VPP.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                           AND B.BKG_STS_CD    IN ('W', 'F')" ).append("\n"); 
		query.append("                           AND B.BKG_CGO_TP_CD IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("                           AND B.BKG_NO         = BV.BKG_NO" ).append("\n"); 
		query.append("                           AND BV.VSL_CD        = VPP.VSL_CD" ).append("\n"); 
		query.append("                           AND BV.SKD_VOY_NO    = VPP.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND BV.SKD_DIR_CD    = VPP.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND BV.POL_YD_CD     = VPP.POL_CD                            " ).append("\n"); 
		query.append("                           AND BV.POD_YD_CD     = VPP.POD_CD                                                                                  " ).append("\n"); 
		query.append("                           AND B.BKG_NO         = D.BKG_NO" ).append("\n"); 
		query.append("                           AND NVL(VPP.PL_CLPT_IND_SEQ,'1') = NVL(BV.POL_CLPT_IND_SEQ,'1')" ).append("\n"); 
		query.append("                           AND NVL(VPP.PD_CLPT_IND_SEQ,'1') = NVL(BV.POD_CLPT_IND_SEQ,'1')" ).append("\n"); 
		query.append("                           AND (VPP.OFC_CD IS NULL OR VPP.OFC_CD = (SELECT N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("                                             FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("                                            WHERE OFC_CD = B.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("                                              AND VPP.COST_YR || VPP.COST_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK)" ).append("\n"); 
		query.append("                            OR VPP.OFC_CD = (SELECT N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("                                             FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("                                            WHERE OFC_CD = B.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("                                              AND VPP.COST_YR ||VPP.COST_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK))" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        GROUP BY TRD_CD    ," ).append("\n"); 
		query.append("                 SUB_TRD_CD," ).append("\n"); 
		query.append("                 RLANE_CD  ," ).append("\n"); 
		query.append("                 DIR_CD    ," ).append("\n"); 
		query.append("                 COST_YR   ," ).append("\n"); 
		query.append("                 COST_WK   ," ).append("\n"); 
		query.append("                 VSL_CD    ," ).append("\n"); 
		query.append("                 SKD_VOY_NO," ).append("\n"); 
		query.append("                 SKD_DIR_CD," ).append("\n"); 
		query.append("                 IOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  SELECT Z.TRD_CD    ," ).append("\n"); 
		query.append("         Z.SUB_TRD_CD," ).append("\n"); 
		query.append("         Z.RLANE_CD  ," ).append("\n"); 
		query.append("         Z.DIR_CD    ," ).append("\n"); 
		query.append("         Z.IOC_CD    ," ).append("\n"); 
		query.append("         Z.COST_YR||Z.COST_WK                 AS COST_WK," ).append("\n"); 
		query.append("         Z.VSL_CD||Z.SKD_VOY_NO||Z.SKD_DIR_CD AS VVD    ," ).append("\n"); 
		query.append("         V.BSA     ," ).append("\n"); 
		query.append("         V.LOADABLE," ).append("\n"); 
		query.append("         DECODE(V.BSA, 0, 100, SUM(FCT_VOL) / V.LOADABLE * 100) AS LF," ).append("\n"); 
		query.append("         SUM(QTA_VOL)             AS QTA_VOL ," ).append("\n"); 
		query.append("         SUM(QTA_CMB)             AS QTA_CMB ," ).append("\n"); 
		query.append("         NVL(SUM(FCT_VOL), 0)     AS FCT_VOL ," ).append("\n"); 
		query.append("         SUM(FCT_WGT)             AS FCT_WGT ," ).append("\n"); 
		query.append("         NVL(SUM(FCT_TS_VOL), 0)  AS FCT_TS_VOL ," ).append("\n"); 
		query.append("         SUM(FCT_TS_WGT)          AS FCT_TS_WGT ," ).append("\n"); 
		query.append("         SUM(ALC_VOL)             AS ALC_VOL ," ).append("\n"); 
		query.append("         SUM(ALC_WGT)             AS ALC_WGT ," ).append("\n"); 
		query.append("         SUM(ALC_TS_VOL)          AS ALC_TS_VOL  ," ).append("\n"); 
		query.append("         SUM(ALC_TS_WGT)          AS ALC_TS_WGT  ," ).append("\n"); 
		query.append("         NVL(SUM(BKG_FIRM), 0)    AS BKG_FIRM," ).append("\n"); 
		query.append("         NVL(SUM(BKG_WAIT), 0)    AS BKG_WAIT," ).append("\n"); 
		query.append("         NVL(SUM(BKG_FIRM + BKG_WAIT), 0) AS BKG_TTL ," ).append("\n"); 
		query.append("         SUM(BKG_WGT)             AS BKG_WGT ," ).append("\n"); 
		query.append("         NVL(SUM(BKG_TS_VOL), 0)  AS BKG_TS_VOL," ).append("\n"); 
		query.append("         SUM(BKG_TS_WGT)          AS BKG_TS_WGT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT TRD_CD    ," ).append("\n"); 
		query.append("                   SUB_TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD  ," ).append("\n"); 
		query.append("                   DIR_CD    ," ).append("\n"); 
		query.append("                   COST_YR   ," ).append("\n"); 
		query.append("                   COST_WK   ," ).append("\n"); 
		query.append("                   VSL_CD    ," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD," ).append("\n"); 
		query.append("                   IOC_CD    ," ).append("\n"); 
		query.append("                   VOL  AS QTA_VOL ," ).append("\n"); 
		query.append("                   DECODE(VOL, 0, 0, CM / VOL) AS QTA_CMB," ).append("\n"); 
		query.append("                   NULL AS FCT_VOL ," ).append("\n"); 
		query.append("                   NULL AS FCT_WGT ," ).append("\n"); 
		query.append("                   NULL AS FCT_TS_VOL ," ).append("\n"); 
		query.append("                   NULL AS FCT_TS_WGT ,                   " ).append("\n"); 
		query.append("                   NULL AS ALC_VOL ," ).append("\n"); 
		query.append("                   NULL AS ALC_WGT ," ).append("\n"); 
		query.append("                   NULL AS ALC_TS_VOL ," ).append("\n"); 
		query.append("                   NULL AS ALC_TS_WGT ," ).append("\n"); 
		query.append("                   NULL AS BKG_FIRM," ).append("\n"); 
		query.append("                   NULL AS BKG_WAIT," ).append("\n"); 
		query.append("                   NULL AS BKG_WGT ," ).append("\n"); 
		query.append("                   NULL AS BKG_TS_VOL ," ).append("\n"); 
		query.append("                   NULL AS BKG_TS_WGT" ).append("\n"); 
		query.append("              FROM QTA_DATA" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT TRD_CD    ," ).append("\n"); 
		query.append("                   SUB_TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD  ," ).append("\n"); 
		query.append("                   DIR_CD    ," ).append("\n"); 
		query.append("                   COST_YR   ," ).append("\n"); 
		query.append("                   COST_WK   ," ).append("\n"); 
		query.append("                   VSL_CD    ," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD," ).append("\n"); 
		query.append("                   IOC_CD    ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   VOL       ," ).append("\n"); 
		query.append("                   WGT       ," ).append("\n"); 
		query.append("                   FCT_TS_VOL AS FCT_TC_VOL ," ).append("\n"); 
		query.append("                   FCT_TS_WGT AS FCT_TC_WGT ," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   NULL AS ALC_TS_VOL  ," ).append("\n"); 
		query.append("                   NULL AS ALC_TS_WGT  ," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL     ," ).append("\n"); 
		query.append("                   NULL AS BKG_TS_VOL," ).append("\n"); 
		query.append("                   NULL AS BKG_TS_WGT" ).append("\n"); 
		query.append("              FROM FCST_DATA" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT TRD_CD    ," ).append("\n"); 
		query.append("                   SUB_TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD  ," ).append("\n"); 
		query.append("                   DIR_CD    ," ).append("\n"); 
		query.append("                   COST_YR   ," ).append("\n"); 
		query.append("                   COST_WK   ," ).append("\n"); 
		query.append("                   VSL_CD    ," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD," ).append("\n"); 
		query.append("                   IOC_CD    ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL AS FCT_TS_VOL ," ).append("\n"); 
		query.append("                   NULL AS FCT_TS_WGT ," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   VOL       ," ).append("\n"); 
		query.append("                   WGT       ," ).append("\n"); 
		query.append("                   ALC_TS_VOL AS ALC_TS_VOL  ," ).append("\n"); 
		query.append("                   ALC_TS_WGT AS ALC_TS_WGT  ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL," ).append("\n"); 
		query.append("                   NULL AS BKG_TS_VOL," ).append("\n"); 
		query.append("                   NULL AS BKG_TS_WGT " ).append("\n"); 
		query.append("              FROM ALOC_DATA" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT TRD_CD    ," ).append("\n"); 
		query.append("                   SUB_TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD  ," ).append("\n"); 
		query.append("                   DIR_CD    ," ).append("\n"); 
		query.append("                   COST_YR   ," ).append("\n"); 
		query.append("                   COST_WK   ," ).append("\n"); 
		query.append("                   VSL_CD    ," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD," ).append("\n"); 
		query.append("                   IOC_CD    ," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL AS FCT_TS_VOL ," ).append("\n"); 
		query.append("                   NULL AS FCT_TS_WGT ," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL      ," ).append("\n"); 
		query.append("                   NULL AS ALC_TS_VOL  ," ).append("\n"); 
		query.append("                   NULL AS ALC_TS_WGT  ," ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("                   TTL_FIRM  ," ).append("\n"); 
		query.append("                   TTL_WAIT  ," ).append("\n"); 
		query.append("                   WGT," ).append("\n"); 
		query.append("                   BKG_TS_VOL AS BKG_TS_VOL," ).append("\n"); 
		query.append("                   BKG_TS_WGT AS BKG_TS_WGT  " ).append("\n"); 
		query.append("              FROM BKG_DATA" ).append("\n"); 
		query.append("         ) Z," ).append("\n"); 
		query.append("         VVDS V" ).append("\n"); 
		query.append("   WHERE Z.TRD_CD     = V.TRD_CD" ).append("\n"); 
		query.append("     AND Z.SUB_TRD_CD = V.SUB_TRD_CD" ).append("\n"); 
		query.append("     AND Z.RLANE_CD   = V.RLANE_CD" ).append("\n"); 
		query.append("     AND Z.DIR_CD     = V.DIR_CD" ).append("\n"); 
		query.append("     AND Z.VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("     AND Z.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("     AND Z.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("     AND Z.IOC_CD     = V.IOC_CD" ).append("\n"); 
		query.append("GROUP BY Z.TRD_CD    ," ).append("\n"); 
		query.append("         Z.SUB_TRD_CD," ).append("\n"); 
		query.append("         Z.RLANE_CD  ," ).append("\n"); 
		query.append("         Z.DIR_CD    ," ).append("\n"); 
		query.append("         V.BSA       ," ).append("\n"); 
		query.append("         V.LOADABLE  ," ).append("\n"); 
		query.append("         Z.COST_YR   ," ).append("\n"); 
		query.append("         Z.COST_WK   ," ).append("\n"); 
		query.append("         Z.VSL_CD    ," ).append("\n"); 
		query.append("         Z.SKD_VOY_NO," ).append("\n"); 
		query.append("         Z.SKD_DIR_CD," ).append("\n"); 
		query.append("         Z.IOC_CD" ).append("\n"); 
		query.append("ORDER BY Z.TRD_CD    ," ).append("\n"); 
		query.append("         Z.SUB_TRD_CD," ).append("\n"); 
		query.append("         Z.RLANE_CD  ," ).append("\n"); 
		query.append("         Z.DIR_CD    ," ).append("\n"); 
		query.append("         Z.COST_YR   ," ).append("\n"); 
		query.append("         Z.COST_WK   ," ).append("\n"); 
		query.append("         Z.VSL_CD    ," ).append("\n"); 
		query.append("         Z.SKD_VOY_NO," ).append("\n"); 
		query.append("         Z.SKD_DIR_CD," ).append("\n"); 
		query.append("         Z.IOC_CD" ).append("\n"); 

	}
}