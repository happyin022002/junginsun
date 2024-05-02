/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquirySalesOrgListVORSQL.java
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

public class SpacecontrolinquiryDBDAOSearchSpaceControlInquirySalesOrgListVORSQL implements ISQLTemplate{

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
	public SpacecontrolinquiryDBDAOSearchSpaceControlInquirySalesOrgListVORSQL(){
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
		params.put("rhq_gso",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquirySalesOrgListVORSQL").append("\n"); 
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
		query.append("    SELECT P.OFC_CD    ," ).append("\n"); 
		query.append("           V.TRD_CD    ," ).append("\n"); 
		query.append("           V.SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.DIR_CD    ," ).append("\n"); 
		query.append("           V.IOC_CD    ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 1, 4) AS COST_YR," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 5, 2) AS COST_MON," ).append("\n"); 
		query.append("           V.COST_WK   ," ).append("\n"); 
		query.append("           P.DIV" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${user_ofc} == 'SHADSC')" ).append("\n"); 
		query.append("                     @[user_ofc] AS OFC_CD    ," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                     @[rhq_txt]  AS OFC_CD    ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     @[trade]    AS TRD_CD    ," ).append("\n"); 
		query.append("                     @[subtrade] AS SUB_TRD_CD," ).append("\n"); 
		query.append("                     @[lane]     AS RLANE_CD  ," ).append("\n"); 
		query.append("                     @[bound]    AS DIR_CD    ," ).append("\n"); 
		query.append("                     @[onc_ipc]  AS IOC_CD    ," ).append("\n"); 
		query.append("                     @[vvd]      AS VVD       ," ).append("\n"); 
		query.append("                     @[rhq_gso]  AS DIV" ).append("\n"); 
		query.append("                FROM DUAL" ).append("\n"); 
		query.append("           ) P," ).append("\n"); 
		query.append("           COA_MON_VVD V" ).append("\n"); 
		query.append("     WHERE V.TRD_CD     = P.TRD_CD" ).append("\n"); 
		query.append("       AND V.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("       AND V.IOC_CD     = P.IOC_CD" ).append("\n"); 
		query.append("       AND V.VSL_CD     = SUBSTR(P.VVD, 1, 4)" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO = SUBSTR(P.VVD, 5, 4)" ).append("\n"); 
		query.append("       AND V.DIR_CD     = SUBSTR(P.VVD, 9)" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", VSL_PORT_SKD AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           V.COST_YR," ).append("\n"); 
		query.append("           V.COST_WK   ," ).append("\n"); 
		query.append("           V.TRD_CD    ," ).append("\n"); 
		query.append("           V.SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.DIR_CD    ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.SKD_DIR_CD," ).append("\n"); 
		query.append("           V.IOC_CD," ).append("\n"); 
		query.append("           V.OFC_CD    ," ).append("\n"); 
		query.append("           V.DIV   ," ).append("\n"); 
		query.append("           NVL(VPS.YD_CD, VPS.VPS_PORT_CD) AS PORT_CD," ).append("\n"); 
		query.append("           VPS.CLPT_SEQ         AS PORT_SEQ," ).append("\n"); 
		query.append("           MAX(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD), VPS.VSL_CD, VPS.SKD_VOY_NO, VPS.SKD_DIR_CD) AS MAX_SEQ," ).append("\n"); 
		query.append("           MIN(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD), VPS.VSL_CD, VPS.SKD_VOY_NO, VPS.SKD_DIR_CD) AS MIN_SEQ," ).append("\n"); 
		query.append("           VPS.CLPT_IND_SEQ  AS CLPT_IND_SEQ" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("      FROM " ).append("\n"); 
		query.append("           VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("           PARAMS            V" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
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
		query.append("                 PL.TRD_CD        ," ).append("\n"); 
		query.append("                 PL.SUB_TRD_CD    ," ).append("\n"); 
		query.append("                 PL.RLANE_CD      ," ).append("\n"); 
		query.append("                 PL.DIR_CD        ," ).append("\n"); 
		query.append("                 PL.VSL_CD        ," ).append("\n"); 
		query.append("                 PL.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                 PL.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                 PL.IOC_CD        ," ).append("\n"); 
		query.append("                 PL.OFC_CD        ," ).append("\n"); 
		query.append("                 PL.DIV           ," ).append("\n"); 
		query.append("                 PL.PORT_CD       ," ).append("\n"); 
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
		query.append("                 PL.DIV       ," ).append("\n"); 
		query.append("                 PL.PORT_CD       ," ).append("\n"); 
		query.append("                 PL.CLPT_IND_SEQ  ," ).append("\n"); 
		query.append("                 PD.CLPT_IND_SEQ        " ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", QTA_DATA AS (" ).append("\n"); 
		query.append("    SELECT M.IOC_CD  AS IOC_TS_CD," ).append("\n"); 
		query.append("           DECODE(M.DIV, 'RHQ', NVL(D.AQ_CD,  D.RHQ_CD), ( SELECT O.SAQ_RGN_OFC_CD" ).append("\n"); 
		query.append("                                                             FROM SPC_OFC_LVL O" ).append("\n"); 
		query.append("                                                            WHERE O.OFC_CD = D.RGN_OFC_CD" ).append("\n"); 
		query.append("                                                              AND M.COST_YR || M.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK)) AS OFC_CD," ).append("\n"); 
		query.append("           (D.LOD_QTY) AS VOL," ).append("\n"); 
		query.append("           ((D.GRS_RPB_REV - D.CM_UC_AMT) * D.LOD_QTY) AS CM" ).append("\n"); 
		query.append("      FROM PARAMS           M," ).append("\n"); 
		query.append("           SAQ_MON_CFM_QTA  D," ).append("\n"); 
		query.append("           SAQ_MON_QTA_RLSE B" ).append("\n"); 
		query.append("     WHERE B.BSE_YR           = M.COST_YR" ).append("\n"); 
		query.append("       AND B.BSE_QTR_CD       = CEIL(TO_NUMBER(M.COST_MON) / 3)||'Q'" ).append("\n"); 
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
		query.append(")" ).append("\n"); 
		query.append(", FCST_DATA AS (" ).append("\n"); 
		query.append("    SELECT D.IOC_TS_CD AS IOC_TS_CD," ).append("\n"); 
		query.append("           DECODE(M.DIV, 'RHQ', NVL(D.SLS_AQ_CD, D.SLS_RHQ_CD), D.SLS_RGN_OFC_CD) AS OFC_CD," ).append("\n"); 
		query.append("           SUM(D.CFM_TTL_QTY)     AS VOL_TTL," ).append("\n"); 
		query.append("           SUM(D.CFM_40FT_HC_QTY) AS VOL_HC ," ).append("\n"); 
		query.append("           SUM(D.CFM_45FT_HC_QTY) AS VOL_45 ," ).append("\n"); 
		query.append("           SUM(D.CFM_53FT_QTY)    AS VOL_53 ," ).append("\n"); 
		query.append("           SUM(D.CFM_RF_QTY)      AS VOL_RF ," ).append("\n"); 
		query.append("           SUM(D.CFM_TTL_WGT)     AS WGT_TTL" ).append("\n"); 
		query.append("      FROM VVD_POL_POD        M," ).append("\n"); 
		query.append("           SPC_DLY_FCAST_CUST D" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND D.TRD_CD   = M.TRD_CD" ).append("\n"); 
		query.append("       AND D.SUB_TRD_CD = M.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND D.RLANE_CD   = M.RLANE_CD" ).append("\n"); 
		query.append("       AND D.DIR_CD     = M.DIR_CD" ).append("\n"); 
		query.append("       AND D.VSL_CD     = M.VSL_CD" ).append("\n"); 
		query.append("       AND D.SKD_VOY_NO = M.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND D.SKD_DIR_CD = M.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND D.IOC_CD     = M.IOC_CD" ).append("\n"); 
		query.append("       AND D.POL_YD_CD  = M.POL_CD" ).append("\n"); 
		query.append("       AND D.POD_YD_CD  = M.POD_CD" ).append("\n"); 
		query.append("       AND NVL(D.POL_IND_SEQ,1) = NVL(M.PL_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("       AND NVL(D.POD_IND_SEQ,1) = NVL(M.PD_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("       AND (M.OFC_CD IS NULL OR D.SLS_RHQ_CD = M.OFC_CD OR D.SLS_AQ_CD = M.OFC_CD)" ).append("\n"); 
		query.append("  GROUP BY DECODE(M.DIV, 'RHQ', NVL(D.SLS_AQ_CD, D.SLS_RHQ_CD), D.SLS_RGN_OFC_CD)," ).append("\n"); 
		query.append("           D.IOC_TS_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", ALOC_DATA AS (" ).append("\n"); 
		query.append("    SELECT DECODE(D.TS_FLG, 'Y', 'T', D.IOC_CD) AS IOC_TS_CD," ).append("\n"); 
		query.append("           DECODE(M.DIV, 'RHQ', NVL(D.SLS_AQ_CD, D.SLS_RHQ_CD), D.SLS_RGN_OFC_CD) AS OFC_CD," ).append("\n"); 
		query.append("           SUM(D.ASGN_TTL_QTY)     AS VOL_TTL," ).append("\n"); 
		query.append("           SUM(D.ASGN_40FT_HC_QTY) AS VOL_HC ," ).append("\n"); 
		query.append("           SUM(D.ASGN_45FT_HC_QTY) AS VOL_45 ," ).append("\n"); 
		query.append("           SUM(D.ASGN_53FT_QTY)    AS VOL_53 ," ).append("\n"); 
		query.append("           SUM(D.ASGN_RF_QTY)      AS VOL_RF ," ).append("\n"); 
		query.append("           SUM(D.ASGN_TTL_WGT)     AS WGT_TTL" ).append("\n"); 
		query.append("      FROM VVD_POL_POD      M," ).append("\n"); 
		query.append("           SPC_ALOC_POL_POD D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND D.TRD_CD   = M.TRD_CD" ).append("\n"); 
		query.append("       AND D.SUB_TRD_CD = M.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND D.RLANE_CD   = M.RLANE_CD" ).append("\n"); 
		query.append("       AND D.DIR_CD     = M.DIR_CD" ).append("\n"); 
		query.append("       AND D.VSL_CD     = M.VSL_CD" ).append("\n"); 
		query.append("       AND D.SKD_VOY_NO = M.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND D.SKD_DIR_CD = M.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND D.IOC_CD     = M.IOC_CD" ).append("\n"); 
		query.append("       AND D.POL_YD_CD  = M.POL_CD" ).append("\n"); 
		query.append("       AND D.POD_YD_CD  = M.POD_CD" ).append("\n"); 
		query.append("       AND NVL(D.POL_IND_SEQ,1) = NVL(M.PL_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("       AND NVL(D.POD_IND_SEQ,1) = NVL(M.PD_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("       AND DECODE(TS_FLG, 'Y', DECODE(D.RLANE_CD, 'IMUAE', 'O', D.IOC_CD), D.IOC_CD) = M.IOC_CD" ).append("\n"); 
		query.append("       AND D.SLS_RGN_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("       AND (M.OFC_CD IS NULL OR D.SLS_RHQ_CD = M.OFC_CD OR D.SLS_AQ_CD = M.OFC_CD) " ).append("\n"); 
		query.append("  GROUP BY DECODE(M.DIV, 'RHQ', NVL(D.SLS_AQ_CD, D.SLS_RHQ_CD), D.SLS_RGN_OFC_CD)," ).append("\n"); 
		query.append("           DECODE(D.TS_FLG, 'Y', 'T', D.IOC_CD)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", BKG_DATA AS (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("           TS_FLG  AS IOC_TS_CD," ).append("\n"); 
		query.append("           DECODE(DIV, 'RHQ', N2ND_PRNT_OFC_CD, N4TH_PRNT_OFC_CD) AS OFC_CD ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'F', BKG_TTL_QTY    , 0)) AS FRM_TTL," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'F', BKG_20FT_QTY   , 0)) AS FRM_20 ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'F', BKG_40FT_QTY   , 0)) AS FRM_40 ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'F', BKG_40FT_HC_QTY, 0)) AS FRM_HC ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'F', BKG_45FT_HC_QTY, 0)) AS FRM_45 ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'F', BKG_53FT_QTY,    0)) AS FRM_53 ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'F', BKG_RF_QTY     , 0)) AS FRM_RF ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'F', BKG_TTL_WGT    , 0)) AS FRM_WGT," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'W', BKG_TTL_QTY    , 0)) AS WAT_TTL," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'W', BKG_20FT_QTY   , 0)) AS WAT_20 ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'W', BKG_40FT_QTY   , 0)) AS WAT_40 ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'W', BKG_40FT_HC_QTY, 0)) AS WAT_HC ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'W', BKG_45FT_HC_QTY, 0)) AS WAT_45 ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'W', BKG_53FT_QTY,    0)) AS WAT_53 ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'W', BKG_RF_QTY     , 0)) AS WAT_RF ," ).append("\n"); 
		query.append("           SUM(DECODE(BKG_STS_CD, 'W', BKG_TTL_WGT    , 0)) AS WAT_WGT ," ).append("\n"); 
		query.append("           SUM(BKG_TTL_QTY)       AS BKG_TTL," ).append("\n"); 
		query.append("           SUM(BKG_20FT_QTY)      AS BKG_20 ," ).append("\n"); 
		query.append("           SUM(BKG_40FT_QTY)      AS BKG_40 ," ).append("\n"); 
		query.append("           SUM(BKG_40FT_HC_QTY)   AS BKG_HC ," ).append("\n"); 
		query.append("           SUM(BKG_45FT_HC_QTY)   AS BKG_45 ," ).append("\n"); 
		query.append("           SUM(BKG_53FT_QTY)      AS BKG_53 ," ).append("\n"); 
		query.append("           SUM(BKG_RF_QTY)        AS BKG_RF ," ).append("\n"); 
		query.append("           SUM(BKG_TTL_WGT)       AS BKG_WGT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
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
		query.append("                     POL_CD              ," ).append("\n"); 
		query.append("                     POD_CD              ," ).append("\n"); 
		query.append("                     DIV                 ," ).append("\n"); 
		query.append("                     N2ND_PRNT_OFC_CD    ," ).append("\n"); 
		query.append("                     N4TH_PRNT_OFC_CD    ," ).append("\n"); 
		query.append("                     TS_FLG              ," ).append("\n"); 
		query.append("                     BKG_STS_CD          ," ).append("\n"); 
		query.append("                     SUBSTR(SHPR_CD,1,2)   AS CUST_CNT_CD," ).append("\n"); 
		query.append("                     SUBSTR(SHPR_CD,3)     AS CUST_SEQ   ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0)) AS BKG_TTL_QTY    ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 15, 14), 0)) AS BKG_20FT_QTY   ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 29, 14), 0)) AS BKG_40FT_QTY   ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 43, 14), 0)) AS BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 57, 14), 0)) AS BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 71, 14), 0)) AS BKG_53FT_QTY   ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 85, 14), 0)) AS BKG_RF_QTY     ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 99, 14), 0)) AS BKG_TTL_WGT    " ).append("\n"); 
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
		query.append("                               VPP.DIV           ," ).append("\n"); 
		query.append("                               VPP.OFC_CD      AS BASE_RHQ_CD," ).append("\n"); 
		query.append("                               B.OB_SLS_OFC_CD AS SLS_OFC_CD ," ).append("\n"); 
		query.append("                               O.N2ND_PRNT_OFC_CD," ).append("\n"); 
		query.append("                               O.N4TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("                               VPP.COST_YR       ," ).append("\n"); 
		query.append("                               VPP.COST_WK       ," ).append("\n"); 
		query.append("                               VPP.IOC_CD        ," ).append("\n"); 
		query.append("                               DECODE(BV.VSL_PRE_PST_CD, 'T', VPP.IOC_CD, 'T') AS TS_FLG ," ).append("\n"); 
		query.append("                               VPP.POL_CD              ," ).append("\n"); 
		query.append("                               VPP.POD_CD              ," ).append("\n"); 
		query.append("                               B.BKG_STS_CD            ," ).append("\n"); 
		query.append("                               DECODE(DECODE(SUBSTR(NVL(B.RFA_NO, 'DUM'),1,3), 'DUM', 'X', B.RFA_NO)||DECODE(SUBSTR(NVL(B.SC_NO, 'DUM'),1,3), 'DUM', 'X', B.SC_NO), 'XX', 'S', 'C')|| NVL(RTRIM(B.CTRT_CUST_CNT_CD), '  ')||B.CTRT_CUST_SEQ AS AGMT_CD," ).append("\n"); 
		query.append("                               (SELECT C.CUST_CNT_CD||C.CUST_SEQ SHPR_CD" ).append("\n"); 
		query.append("                                  FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append("                                 WHERE B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                                   AND C.BKG_CUST_TP_CD = 'S' ) AS SHPR_CD," ).append("\n"); 
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
		query.append("                         FROM  " ).append("\n"); 
		query.append("                               VVD_POL_POD VPP," ).append("\n"); 
		query.append("                               BKG_VVD     BV ," ).append("\n"); 
		query.append("                               BKG_BOOKING B  ," ).append("\n"); 
		query.append("                               SPC_OFC_LVL O  , " ).append("\n"); 
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
		query.append("           ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        GROUP BY  " ).append("\n"); 
		query.append("                  TS_FLG ," ).append("\n"); 
		query.append("                  DECODE(DIV, 'RHQ',N2ND_PRNT_OFC_CD, N4TH_PRNT_OFC_CD)" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  SELECT DECODE(IOC_TS_CD, 'O', 'OCN', 'I', 'IPC', 'T', 'T/S') AS IOC_TS_CD," ).append("\n"); 
		query.append("         OFC_CD," ).append("\n"); 
		query.append("         ROUND(SUM(QTA_VOL)) AS QTA_VOL," ).append("\n"); 
		query.append("         SUM(NVL(FCT_VOL, 0) + NVL(FCT_HC, 0) * SPC_GET_HC_RT_BSA_FNC(@[trade] ,@[lane] ,@[bound] ,SUBSTR(@[vvd],1,4), SUBSTR(@[vvd],5,4), 'D5') + NVL(FCT_45, 0) * SPC_GET_HC_RT_BSA_FNC(@[trade] ,@[lane] ,@[bound] ,SUBSTR(@[vvd],1,4), SUBSTR(@[vvd],5,4), 'D7') + NVL(FCT_53, 0) * 2) AS FC_TTL_TEU," ).append("\n"); 
		query.append("         SUM(FCT_VOL) AS FCT_VOL," ).append("\n"); 
		query.append("         SUM(FCT_HC)  AS FCT_HC ," ).append("\n"); 
		query.append("         SUM(FCT_45)  AS FCT_45 ," ).append("\n"); 
		query.append("         SUM(FCT_53)  AS FCT_53 ," ).append("\n"); 
		query.append("         SUM(FCT_RF)  AS FCT_RF ," ).append("\n"); 
		query.append("         SUM(FCT_WGT) AS FCT_WGT," ).append("\n"); 
		query.append("         SUM(ALC_VOL) AS ALC_VOL," ).append("\n"); 
		query.append("         SUM(ALC_HC)  AS ALC_HC ," ).append("\n"); 
		query.append("         SUM(ALC_45)  AS ALC_45 ," ).append("\n"); 
		query.append("         SUM(ALC_53)  AS ALC_53 ," ).append("\n"); 
		query.append("         SUM(ALC_RF)  AS ALC_RF ," ).append("\n"); 
		query.append("         SUM(ALC_WGT) AS ALC_WGT," ).append("\n"); 
		query.append("         SUM(NVL(FRM_20, 0) + NVL(FRM_40, 0)*2 + NVL(FRM_HC, 0) * SPC_GET_HC_RT_BSA_FNC(@[trade] ,@[lane] ,@[bound] ,SUBSTR(@[vvd],1,4), SUBSTR(@[vvd],5,4), 'D5') + NVL(FRM_45, 0) * SPC_GET_HC_RT_BSA_FNC(@[trade] ,@[lane] ,@[bound] ,SUBSTR(@[vvd],1,4), SUBSTR(@[vvd],5,4), 'D7') + NVL(FRM_53, 0) * 2) AS FRM_VOL," ).append("\n"); 
		query.append("         SUM(FRM_20)  AS FRM_20 ," ).append("\n"); 
		query.append("         SUM(FRM_40)  AS FRM_40 ," ).append("\n"); 
		query.append("         SUM(FRM_HC)  AS FRM_HC ," ).append("\n"); 
		query.append("         SUM(FRM_45)  AS FRM_45 ," ).append("\n"); 
		query.append("         SUM(FRM_53)  AS FRM_53 ," ).append("\n"); 
		query.append("         SUM(FRM_RF)  AS FRM_RF ," ).append("\n"); 
		query.append("         SUM(FRM_WGT) AS FRM_WGT," ).append("\n"); 
		query.append("         SUM(NVL(WAT_20, 0) + NVL(WAT_40, 0) *2 + NVL(WAT_HC, 0) * SPC_GET_HC_RT_BSA_FNC(@[trade] ,@[lane] ,@[bound] ,SUBSTR(@[vvd],1,4), SUBSTR(@[vvd],5,4), 'D5') + NVL(WAT_45, 0) * SPC_GET_HC_RT_BSA_FNC(@[trade] ,@[lane] ,@[bound] ,SUBSTR(@[vvd],1,4), SUBSTR(@[vvd],5,4), 'D7') + NVL(WAT_53, 0) * 2) AS WAT_VOL," ).append("\n"); 
		query.append("         SUM(WAT_20)  AS WAT_20 ," ).append("\n"); 
		query.append("         SUM(WAT_40)  AS WAT_40 ," ).append("\n"); 
		query.append("         SUM(WAT_HC)  AS WAT_HC ," ).append("\n"); 
		query.append("         SUM(WAT_45)  AS WAT_45 ," ).append("\n"); 
		query.append("         SUM(WAT_53)  AS WAT_53 ," ).append("\n"); 
		query.append("         SUM(WAT_RF)  AS WAT_RF ," ).append("\n"); 
		query.append("         SUM(WAT_WGT) AS WAT_WGT," ).append("\n"); 
		query.append("         SUM(NVL(BKG_20, 0) + NVL(BKG_40, 0) *2 + NVL(BKG_HC, 0) * SPC_GET_HC_RT_BSA_FNC(@[trade] ,@[lane] ,@[bound] ,SUBSTR(@[vvd],1,4), SUBSTR(@[vvd],5,4), 'D5') + NVL(BKG_45, 0) * SPC_GET_HC_RT_BSA_FNC(@[trade] ,@[lane] ,@[bound] ,SUBSTR(@[vvd],1,4), SUBSTR(@[vvd],5,4), 'D7') + NVL(BKG_53, 0) * 2) AS BKG_VOL," ).append("\n"); 
		query.append("         SUM(BKG_20)  AS BKG_20 ," ).append("\n"); 
		query.append("         SUM(BKG_40)  AS BKG_40 ," ).append("\n"); 
		query.append("         SUM(BKG_HC)  AS BKG_HC ," ).append("\n"); 
		query.append("         SUM(BKG_45)  AS BKG_45 ," ).append("\n"); 
		query.append("         SUM(BKG_53)  AS BKG_53 ," ).append("\n"); 
		query.append("         SUM(BKG_RF)  AS BKG_RF ," ).append("\n"); 
		query.append("         SUM(BKG_WGT) AS BKG_WGT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT IOC_TS_CD," ).append("\n"); 
		query.append("                   OFC_CD   ," ).append("\n"); 
		query.append("                   VOL AS QTA_VOL," ).append("\n"); 
		query.append("                   DECODE(VOL, 0, 0, CM / VOL) AS QTA_CMB," ).append("\n"); 
		query.append("                   0    AS FCT_VOL," ).append("\n"); 
		query.append("                   0    AS FCT_HC ," ).append("\n"); 
		query.append("                   0    AS FCT_45 ," ).append("\n"); 
		query.append("                   0    AS FCT_53 ," ).append("\n"); 
		query.append("                   0    AS FCT_RF ," ).append("\n"); 
		query.append("                   0    AS FCT_WGT," ).append("\n"); 
		query.append("                   NULL AS ALC_VOL," ).append("\n"); 
		query.append("                   NULL AS ALC_HC ," ).append("\n"); 
		query.append("                   NULL AS ALC_45 ," ).append("\n"); 
		query.append("                   NULL AS ALC_53 ," ).append("\n"); 
		query.append("                   NULL AS ALC_RF ," ).append("\n"); 
		query.append("                   NULL AS ALC_WGT," ).append("\n"); 
		query.append("                   0    AS FRM_VOL," ).append("\n"); 
		query.append("                   0    AS FRM_20 ," ).append("\n"); 
		query.append("                   0    AS FRM_40 ," ).append("\n"); 
		query.append("                   0    AS FRM_HC ," ).append("\n"); 
		query.append("                   0    AS FRM_45 ," ).append("\n"); 
		query.append("                   0    AS FRM_53 ," ).append("\n"); 
		query.append("                   0    AS FRM_RF ," ).append("\n"); 
		query.append("                   0    AS FRM_WGT," ).append("\n"); 
		query.append("                   0    AS WAT_VOL," ).append("\n"); 
		query.append("                   0    AS WAT_20 ," ).append("\n"); 
		query.append("                   0    AS WAT_40 ," ).append("\n"); 
		query.append("                   0    AS WAT_HC ," ).append("\n"); 
		query.append("                   0    AS WAT_45 ," ).append("\n"); 
		query.append("                   0    AS WAT_53 ," ).append("\n"); 
		query.append("                   0    AS WAT_RF ," ).append("\n"); 
		query.append("                   0    AS WAT_WGT," ).append("\n"); 
		query.append("                   0    AS BKG_VOL," ).append("\n"); 
		query.append("                   0    AS BKG_20 ," ).append("\n"); 
		query.append("                   0    AS BKG_40 ," ).append("\n"); 
		query.append("                   0    AS BKG_HC ," ).append("\n"); 
		query.append("                   0    AS BKG_45 ," ).append("\n"); 
		query.append("                   0    AS BKG_53 ," ).append("\n"); 
		query.append("                   0    AS BKG_RF ," ).append("\n"); 
		query.append("                   0    AS BKG_WGT" ).append("\n"); 
		query.append("              FROM QTA_DATA" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT IOC_TS_CD," ).append("\n"); 
		query.append("                   OFC_CD   ," ).append("\n"); 
		query.append("                   0        ," ).append("\n"); 
		query.append("                   0        ," ).append("\n"); 
		query.append("                   VOL_TTL  ," ).append("\n"); 
		query.append("                   VOL_HC   ," ).append("\n"); 
		query.append("                   VOL_45   ," ).append("\n"); 
		query.append("                   VOL_53   ," ).append("\n"); 
		query.append("                   VOL_RF   ," ).append("\n"); 
		query.append("                   WGT_TTL  ," ).append("\n"); 
		query.append("                   NULL AS ALC_VOL," ).append("\n"); 
		query.append("                   NULL AS ALC_HC ," ).append("\n"); 
		query.append("                   NULL AS ALC_45 ," ).append("\n"); 
		query.append("                   NULL AS ALC_53 ," ).append("\n"); 
		query.append("                   NULL AS ALC_RF ," ).append("\n"); 
		query.append("                   NULL AS ALC_WGT," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0" ).append("\n"); 
		query.append("              FROM FCST_DATA" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT IOC_TS_CD," ).append("\n"); 
		query.append("                   OFC_CD   ," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   VOL_TTL," ).append("\n"); 
		query.append("                   VOL_HC ," ).append("\n"); 
		query.append("                   VOL_45 ," ).append("\n"); 
		query.append("                   VOL_53 ," ).append("\n"); 
		query.append("                   VOL_RF ," ).append("\n"); 
		query.append("                   WGT_TTL," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0" ).append("\n"); 
		query.append("              FROM ALOC_DATA" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT IOC_TS_CD," ).append("\n"); 
		query.append("                   OFC_CD   ," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   0," ).append("\n"); 
		query.append("                   NULL AS ALC_VOL," ).append("\n"); 
		query.append("                   NULL AS ALC_HC ," ).append("\n"); 
		query.append("                   NULL AS ALC_45 ," ).append("\n"); 
		query.append("                   NULL AS ALC_53 ," ).append("\n"); 
		query.append("                   NULL AS ALC_RF ," ).append("\n"); 
		query.append("                   NULL AS ALC_WGT," ).append("\n"); 
		query.append("                   FRM_TTL," ).append("\n"); 
		query.append("                   FRM_20 ," ).append("\n"); 
		query.append("                   FRM_40 ," ).append("\n"); 
		query.append("                   FRM_HC ," ).append("\n"); 
		query.append("                   FRM_45 ," ).append("\n"); 
		query.append("                   FRM_53 ," ).append("\n"); 
		query.append("                   FRM_RF ," ).append("\n"); 
		query.append("                   FRM_WGT," ).append("\n"); 
		query.append("                   WAT_TTL," ).append("\n"); 
		query.append("                   WAT_20 ," ).append("\n"); 
		query.append("                   WAT_40 ," ).append("\n"); 
		query.append("                   WAT_HC ," ).append("\n"); 
		query.append("                   WAT_45 ," ).append("\n"); 
		query.append("                   WAT_53 ," ).append("\n"); 
		query.append("                   WAT_RF ," ).append("\n"); 
		query.append("                   WAT_WGT," ).append("\n"); 
		query.append("                   BKG_TTL," ).append("\n"); 
		query.append("                   BKG_20 ," ).append("\n"); 
		query.append("                   BKG_40 ," ).append("\n"); 
		query.append("                   BKG_HC ," ).append("\n"); 
		query.append("                   BKG_45 ," ).append("\n"); 
		query.append("                   BKG_53 ," ).append("\n"); 
		query.append("                   BKG_RF ," ).append("\n"); 
		query.append("                   BKG_WGT" ).append("\n"); 
		query.append("              FROM BKG_DATA" ).append("\n"); 
		query.append("         ) Z" ).append("\n"); 
		query.append("GROUP BY IOC_TS_CD," ).append("\n"); 
		query.append("         OFC_CD" ).append("\n"); 
		query.append("ORDER BY IOC_TS_CD," ).append("\n"); 
		query.append("         OFC_CD" ).append("\n"); 

	}
}