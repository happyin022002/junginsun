/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeSalesOrgListVORSQL.java
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

public class SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeSalesOrgListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSpaceControlInquiryOfficeSalesOrgListVO
	  * 
	  * 2015.07.22. SKY[CLT-000042051-10] Virtual add call - VT_ADD_CALL_FLG IS  NULL  로직 추가
	  * 2016.04.20 Vessel Schedule 로직 추가
	  * 2016.05.12 SPC_GET_HC_RT_BSA_FNC : SKD_VOY_NO parm 추가
	  * 2016.07.12 SPC_BKG_V 제거
	  * 2016.07.19 #15529 AOC- JPN Issue cannot create BKG for T2 + Refeer
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeSalesOrgListVORSQL(){
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
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sales_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeSalesOrgListVORSQL").append("\n"); 
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
		query.append("WITH PARAM AS (" ).append("\n"); 
		query.append("    SELECT @[trade]        AS TRD_CD    ," ).append("\n"); 
		query.append("           @[subtrade]     AS SUB_TRD_CD," ).append("\n"); 
		query.append("           @[lane]         AS RLANE_CD  ," ).append("\n"); 
		query.append("           @[vsl_cd]       AS VSL_CD    ," ).append("\n"); 
		query.append("           @[skd_voy_no]   AS SKD_VOY_NO," ).append("\n"); 
		query.append("           @[skd_dir_cd]   AS SKD_DIR_CD," ).append("\n"); 
		query.append("           @[sales_office] AS OFC_CD" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", BASE AS (" ).append("\n"); 
		query.append("    SELECT /*+ ORDERED USE_NL(P V ACO) */" ).append("\n"); 
		query.append("           P.OFC_CD    ," ).append("\n"); 
		query.append("           P.TRD_CD    ," ).append("\n"); 
		query.append("           P.SUB_TRD_CD," ).append("\n"); 
		query.append("           P.RLANE_CD  ," ).append("\n"); 
		query.append("           P.VSL_CD    ," ).append("\n"); 
		query.append("           P.SKD_VOY_NO," ).append("\n"); 
		query.append("           P.SKD_DIR_CD," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 1, 4) AS COST_YR ," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 5, 2) AS COST_MON," ).append("\n"); 
		query.append("           V.COST_WK   ," ).append("\n"); 
		query.append("           NVL(ACO.CTRL_PORT_FLG   , 'N') AS CTRL_PORT," ).append("\n"); 
		query.append("           NVL(ACO.CTRL_WGT_FLG    , 'N') AS CTRL_WGT ," ).append("\n"); 
		query.append("           NVL(ACO.CTRL_40FT_HC_FLG, 'N') AS CTRL_40HC," ).append("\n"); 
		query.append("           NVL(ACO.CTRL_45FT_HC_FLG, 'N') AS CTRL_45HC," ).append("\n"); 
		query.append("           NVL(ACO.CTRL_53FT_FLG,    'N') AS CTRL_53FT," ).append("\n"); 
		query.append("           NVL(ACO.CTRL_RF_FLG     , 'N') AS CTRL_RF" ).append("\n"); 
		query.append("      FROM PARAM             P," ).append("\n"); 
		query.append("           COA_MON_VVD       V," ).append("\n"); 
		query.append("           SPC_ALOC_CTRL_OPT ACO" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("     WHERE V.TRD_CD          = P.TRD_CD" ).append("\n"); 
		query.append("       AND V.RLANE_CD        = P.RLANE_CD" ).append("\n"); 
		query.append("       AND V.VSL_CD          = P.VSL_CD" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO      = P.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND V.DIR_CD          = P.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND ACO.RLANE_CD  (+) = P.RLANE_CD" ).append("\n"); 
		query.append("       AND ACO.DIR_CD    (+) = P.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND ACO.VSL_CD    (+) = P.VSL_CD" ).append("\n"); 
		query.append("       AND ACO.SKD_VOY_NO(+) = P.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND ACO.SKD_DIR_CD(+) = P.SKD_DIR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VSL_PORT_SKD AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           V.COST_YR," ).append("\n"); 
		query.append("           V.COST_WK   ," ).append("\n"); 
		query.append("           V.TRD_CD    ," ).append("\n"); 
		query.append("           V.SUB_TRD_CD," ).append("\n"); 
		query.append("           V.RLANE_CD  ," ).append("\n"); 
		query.append("           V.VSL_CD    ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO," ).append("\n"); 
		query.append("           V.SKD_DIR_CD," ).append("\n"); 
		query.append("           V.OFC_CD    ," ).append("\n"); 
		query.append("           NVL(VPS.YD_CD, VPS.VPS_PORT_CD) AS PORT_CD," ).append("\n"); 
		query.append("           VPS.CLPT_SEQ         AS PORT_SEQ," ).append("\n"); 
		query.append("           MAX(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD), VPS.VSL_CD, VPS.SKD_VOY_NO, VPS.SKD_DIR_CD) AS MAX_SEQ," ).append("\n"); 
		query.append("           MIN(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD), VPS.VSL_CD, VPS.SKD_VOY_NO, VPS.SKD_DIR_CD) AS MIN_SEQ," ).append("\n"); 
		query.append("           VPS.CLPT_IND_SEQ  AS CLPT_IND_SEQ," ).append("\n"); 
		query.append("           V.CTRL_PORT," ).append("\n"); 
		query.append("           V.CTRL_WGT ," ).append("\n"); 
		query.append("           V.CTRL_40HC," ).append("\n"); 
		query.append("           V.CTRL_45HC," ).append("\n"); 
		query.append("           V.CTRL_53FT," ).append("\n"); 
		query.append("           V.CTRL_RF" ).append("\n"); 
		query.append("      FROM " ).append("\n"); 
		query.append("           VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("           BASE               V" ).append("\n"); 
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
		query.append("                 PL.VSL_CD        ," ).append("\n"); 
		query.append("                 PL.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                 PL.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                 PL.OFC_CD        ," ).append("\n"); 
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
		query.append("                 PD.CLPT_IND_SEQ   AS PD_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                 PL.CTRL_PORT," ).append("\n"); 
		query.append("                 PL.CTRL_WGT ," ).append("\n"); 
		query.append("                 PL.CTRL_40HC," ).append("\n"); 
		query.append("                 PL.CTRL_45HC," ).append("\n"); 
		query.append("                 PL.CTRL_53FT," ).append("\n"); 
		query.append("                 PL.CTRL_RF" ).append("\n"); 
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
		query.append("                 PL.VSL_CD        ," ).append("\n"); 
		query.append("                 PL.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                 PL.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                 PL.PORT_CD       ," ).append("\n"); 
		query.append("                 PD.PORT_CD       ," ).append("\n"); 
		query.append("                 PL.OFC_CD        ," ).append("\n"); 
		query.append("                 PL.PORT_CD       ," ).append("\n"); 
		query.append("                 PL.CLPT_IND_SEQ  ," ).append("\n"); 
		query.append("                 PD.CLPT_IND_SEQ  ," ).append("\n"); 
		query.append("                 PL.CTRL_PORT," ).append("\n"); 
		query.append("                 PL.CTRL_WGT ," ).append("\n"); 
		query.append("                 PL.CTRL_40HC," ).append("\n"); 
		query.append("                 PL.CTRL_45HC," ).append("\n"); 
		query.append("                 PL.CTRL_53FT," ).append("\n"); 
		query.append("                 PL.CTRL_RF" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("  SELECT DECODE(Z.IOC_TS_CD, 'O', 'OCN', 'I', 'IPC', 'T', 'T/S') AS IOC_TS_CD," ).append("\n"); 
		query.append("         Z.OFC_CD," ).append("\n"); 
		query.append("         Z.POL_CD," ).append("\n"); 
		query.append("         Z.POD_CD," ).append("\n"); 
		query.append("         ROUND(SUM(Z.BKG_QTA)) AS BKG_QTA," ).append("\n"); 
		query.append("         SUM(NVL(Z.FCT_VOL, 0) + NVL(Z.FCT_HC, 0) * SPC_GET_HC_RT_BSA_FNC(Z.TRD_CD ,Z.RLANE_CD ,Z.SKD_DIR_CD ,Z.VSL_CD, Z.SKD_VOY_NO,'D5') + NVL(Z.FCT_45, 0) * SPC_GET_HC_RT_BSA_FNC(Z.TRD_CD ,Z.RLANE_CD ,Z.SKD_DIR_CD ,Z.VSL_CD, Z.SKD_VOY_NO, 'D7') + NVL(Z.FCT_53, 0) * 2) AS FC_TTL_TEU," ).append("\n"); 
		query.append("         SUM(Z.FCT_VOL) AS FCT_VOL ," ).append("\n"); 
		query.append("         SUM(Z.FCT_HC)  AS FCT_HC  ," ).append("\n"); 
		query.append("         SUM(Z.FCT_45)  AS FCT_45  ," ).append("\n"); 
		query.append("         SUM(Z.FCT_53)  AS FCT_53  ," ).append("\n"); 
		query.append("         SUM(Z.FCT_RF)  AS FCT_RF  ," ).append("\n"); 
		query.append("         SUM(Z.FCT_WGT) AS FCT_WGT ," ).append("\n"); 
		query.append("         SUM(Z.ALC_VOL) AS ALC_VOL ," ).append("\n"); 
		query.append("         SUM(Z.ALC_20)  AS ALC_20  ," ).append("\n"); 
		query.append("         SUM(Z.ALC_40)  AS ALC_40  ," ).append("\n"); 
		query.append("         SUM(Z.ALC_HC)  AS ALC_HC  ," ).append("\n"); 
		query.append("         SUM(Z.ALC_45)  AS ALC_45  ," ).append("\n"); 
		query.append("         SUM(Z.ALC_53)  AS ALC_53  ," ).append("\n"); 
		query.append("         SUM(Z.ALC_RF)  AS ALC_RF  ," ).append("\n"); 
		query.append("         SUM(Z.ALC_WGT) AS ALC_WGT ," ).append("\n"); 
		query.append("         SUM(NVL(Z.FRM_20, 0) + NVL(Z.FRM_40, 0)*2 + NVL(Z.FRM_HC, 0) * SPC_GET_HC_RT_BSA_FNC(Z.TRD_CD ,Z.RLANE_CD ,Z.SKD_DIR_CD ,Z.VSL_CD, Z.SKD_VOY_NO,'D5') + NVL(Z.FRM_45, 0) * SPC_GET_HC_RT_BSA_FNC(Z.TRD_CD ,Z.RLANE_CD ,Z.SKD_DIR_CD ,Z.VSL_CD, Z.SKD_VOY_NO, 'D7') + NVL(Z.FRM_53, 0) * 2) AS FRM_VOL ," ).append("\n"); 
		query.append("         SUM(Z.FRM_20)  AS FRM_20  ," ).append("\n"); 
		query.append("         SUM(Z.FRM_40)  AS FRM_40  ," ).append("\n"); 
		query.append("         SUM(Z.FRM_HC)  AS FRM_HC  ," ).append("\n"); 
		query.append("         SUM(Z.FRM_45)  AS FRM_45  ," ).append("\n"); 
		query.append("         SUM(Z.FRM_53)  AS FRM_53  ," ).append("\n"); 
		query.append("         SUM(Z.FRM_RF)  AS FRM_RF  ," ).append("\n"); 
		query.append("         SUM(Z.FRM_WGT) AS FRM_WGT ," ).append("\n"); 
		query.append("         SUM(NVL(Z.WAT_20, 0) + NVL(Z.WAT_40, 0)*2 + NVL(Z.WAT_HC, 0) * SPC_GET_HC_RT_BSA_FNC(Z.TRD_CD ,Z.RLANE_CD ,Z.SKD_DIR_CD ,Z.VSL_CD, Z.SKD_VOY_NO,'D5') + NVL(Z.WAT_45, 0) * SPC_GET_HC_RT_BSA_FNC(Z.TRD_CD ,Z.RLANE_CD ,Z.SKD_DIR_CD ,Z.VSL_CD, Z.SKD_VOY_NO, 'D7') + NVL(Z.WAT_53, 0) * 2)  AS WAT_VOL ," ).append("\n"); 
		query.append("         SUM(Z.WAT_20)  AS WAT_20  ," ).append("\n"); 
		query.append("         SUM(Z.WAT_40)  AS WAT_40  ," ).append("\n"); 
		query.append("         SUM(Z.WAT_HC)  AS WAT_HC  ," ).append("\n"); 
		query.append("         SUM(Z.WAT_45)  AS WAT_45  ," ).append("\n"); 
		query.append("         SUM(Z.WAT_53)  AS WAT_53  ," ).append("\n"); 
		query.append("         SUM(Z.WAT_RF)  AS WAT_RF  ," ).append("\n"); 
		query.append("         SUM(Z.WAT_WGT) AS WAT_WGT ," ).append("\n"); 
		query.append("         MAX(CTRL_PORT) AS CTRL_PORT," ).append("\n"); 
		query.append("         3 - (GROUPING_ID(Z.POL_CD) + GROUPING_ID(Z.POD_CD)) AS LVL" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            -- QTA" ).append("\n"); 
		query.append("            SELECT DECODE(SUBSTR(T2.TRD_CD, 1, 1), 'I', 'I', 'O') AS IOC_TS_CD," ).append("\n"); 
		query.append("                   P.TRD_CD    ," ).append("\n"); 
		query.append("                   P.SUB_TRD_CD," ).append("\n"); 
		query.append("                   P.RLANE_CD  ," ).append("\n"); 
		query.append("                   P.VSL_CD    ," ).append("\n"); 
		query.append("                   P.SKD_VOY_NO," ).append("\n"); 
		query.append("                   P.SKD_DIR_CD," ).append("\n"); 
		query.append("                   T3.SAQ_RGN_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("                   T2.POL_CD         AS POL_CD," ).append("\n"); 
		query.append("                   T2.POD_CD         AS POD_CD," ).append("\n"); 
		query.append("                   (T2.LOD_QTY) AS BKG_QTA," ).append("\n"); 
		query.append("                   NULL AS FCT_VOL," ).append("\n"); 
		query.append("                   NULL AS FCT_HC ," ).append("\n"); 
		query.append("                   NULL AS FCT_45 ," ).append("\n"); 
		query.append("                   NULL AS FCT_53 ," ).append("\n"); 
		query.append("                   NULL AS FCT_RF ," ).append("\n"); 
		query.append("                   NULL AS FCT_WGT," ).append("\n"); 
		query.append("                   NULL AS ALC_VOL," ).append("\n"); 
		query.append("                   NULL AS ALC_20 ," ).append("\n"); 
		query.append("                   NULL AS ALC_40 ," ).append("\n"); 
		query.append("                   NULL AS ALC_HC ," ).append("\n"); 
		query.append("                   NULL AS ALC_45 ," ).append("\n"); 
		query.append("                   NULL AS ALC_53 ," ).append("\n"); 
		query.append("                   NULL AS ALC_RF ," ).append("\n"); 
		query.append("                   NULL AS ALC_WGT," ).append("\n"); 
		query.append("                   NULL AS FRM_VOL," ).append("\n"); 
		query.append("                   NULL AS FRM_20 ," ).append("\n"); 
		query.append("                   NULL AS FRM_40 ," ).append("\n"); 
		query.append("                   NULL AS FRM_HC ," ).append("\n"); 
		query.append("                   NULL AS FRM_45 ," ).append("\n"); 
		query.append("                   NULL AS FRM_53 ," ).append("\n"); 
		query.append("                   NULL AS FRM_RF ," ).append("\n"); 
		query.append("                   NULL AS FRM_WGT," ).append("\n"); 
		query.append("                   NULL AS WAT_VOL," ).append("\n"); 
		query.append("                   NULL AS WAT_20 ," ).append("\n"); 
		query.append("                   NULL AS WAT_40 ," ).append("\n"); 
		query.append("                   NULL AS WAT_HC ," ).append("\n"); 
		query.append("                   NULL AS WAT_45 ," ).append("\n"); 
		query.append("                   NULL AS WAT_53 ," ).append("\n"); 
		query.append("                   NULL AS WAT_RF ," ).append("\n"); 
		query.append("                   NULL AS WAT_WGT," ).append("\n"); 
		query.append("                   P.CTRL_PORT    ," ).append("\n"); 
		query.append("                   P.CTRL_WGT     ," ).append("\n"); 
		query.append("                   P.CTRL_40HC    ," ).append("\n"); 
		query.append("                   P.CTRL_45HC    ," ).append("\n"); 
		query.append("                   P.CTRL_53FT    ," ).append("\n"); 
		query.append("                   P.CTRL_RF" ).append("\n"); 
		query.append("              FROM SAQ_MON_QTA_RLSE T1," ).append("\n"); 
		query.append("                   SAQ_MON_CFM_QTA  T2," ).append("\n"); 
		query.append("                   SPC_OFC_LVL      T3," ).append("\n"); 
		query.append("                   BASE             P" ).append("\n"); 
		query.append("             WHERE T1.BSE_YR           = P.COST_YR" ).append("\n"); 
		query.append("               AND T1.BSE_QTR_CD       = CEIL(TO_NUMBER(P.COST_MON) / 3)||'Q'" ).append("\n"); 
		query.append("               AND T1.QTA_RLSE_STS_CD  = 'R'" ).append("\n"); 
		query.append("               AND T2.MQTA_RLSE_VER_NO = T1.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("               AND T2.BSE_YR           = T1.BSE_YR" ).append("\n"); 
		query.append("               AND T2.BSE_QTR_CD       = T1.BSE_QTR_CD " ).append("\n"); 
		query.append("               AND T2.QTA_TGT_CD       = 'T'" ).append("\n"); 
		query.append("               AND T2.TRD_CD           = P.TRD_CD" ).append("\n"); 
		query.append("               AND T2.RLANE_CD         = P.RLANE_CD" ).append("\n"); 
		query.append("               AND T2.DIR_CD           = P.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND T2.VSL_CD           = P.VSL_CD" ).append("\n"); 
		query.append("               AND T2.SKD_VOY_NO       = P.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND T2.SKD_DIR_CD       = P.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND T2.RGN_OFC_CD       = P.OFC_CD" ).append("\n"); 
		query.append("               AND T2.RGN_OFC_CD       = T3.OFC_CD" ).append("\n"); 
		query.append("               AND P.COST_YR || P.COST_WK BETWEEN T3.OFC_APLY_FM_YRWK AND T3.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            -- FORECAST" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                   Z.IOC_TS_CD ," ).append("\n"); 
		query.append("                   P.TRD_CD    ," ).append("\n"); 
		query.append("                   P.SUB_TRD_CD," ).append("\n"); 
		query.append("                   P.RLANE_CD  ," ).append("\n"); 
		query.append("                   P.VSL_CD    ," ).append("\n"); 
		query.append("                   P.SKD_VOY_NO," ).append("\n"); 
		query.append("                   P.SKD_DIR_CD," ).append("\n"); 
		query.append("                   Z.SLS_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("                   Z.POL_YD_CD  AS POL_CD," ).append("\n"); 
		query.append("                   Z.POD_YD_CD  AS POD_CD," ).append("\n"); 
		query.append("                   NULL              AS BKG_QTA," ).append("\n"); 
		query.append("                   Z.CFM_TTL_QTY     AS FCT_VOL," ).append("\n"); 
		query.append("                   Z.CFM_40FT_HC_QTY AS FCT_HC ," ).append("\n"); 
		query.append("                   Z.CFM_45FT_HC_QTY AS FCT_45 ," ).append("\n"); 
		query.append("                   Z.CFM_53FT_QTY    AS FCT_53 ," ).append("\n"); 
		query.append("                   Z.CFM_RF_QTY      AS FCT_RF ," ).append("\n"); 
		query.append("                   Z.CFM_TTL_WGT     AS FCT_WGT," ).append("\n"); 
		query.append("                   NULL AS ALC_VOL," ).append("\n"); 
		query.append("                   NULL AS ALC_20 ," ).append("\n"); 
		query.append("                   NULL AS ALC_40 ," ).append("\n"); 
		query.append("                   NULL AS ALC_HC ," ).append("\n"); 
		query.append("                   NULL AS ALC_45 ," ).append("\n"); 
		query.append("                   NULL AS ALC_53 ," ).append("\n"); 
		query.append("                   NULL AS ALC_RF ," ).append("\n"); 
		query.append("                   NULL AS ALC_WGT," ).append("\n"); 
		query.append("                   NULL AS FRM_VOL," ).append("\n"); 
		query.append("                   NULL AS FRM_20 ," ).append("\n"); 
		query.append("                   NULL AS FRM_40 ," ).append("\n"); 
		query.append("                   NULL AS FRM_HC ," ).append("\n"); 
		query.append("                   NULL AS FRM_45 ," ).append("\n"); 
		query.append("                   NULL AS FRM_53 ," ).append("\n"); 
		query.append("                   NULL AS FRM_RF ," ).append("\n"); 
		query.append("                   NULL AS FRM_WGT," ).append("\n"); 
		query.append("                   NULL AS WAT_VOL," ).append("\n"); 
		query.append("                   NULL AS WAT_20 ," ).append("\n"); 
		query.append("                   NULL AS WAT_40 ," ).append("\n"); 
		query.append("                   NULL AS WAT_HC ," ).append("\n"); 
		query.append("                   NULL AS WAT_45 ," ).append("\n"); 
		query.append("                   NULL AS WAT_53 ," ).append("\n"); 
		query.append("                   NULL AS WAT_RF ," ).append("\n"); 
		query.append("                   NULL AS WAT_WGT," ).append("\n"); 
		query.append("                   P.CTRL_PORT    ," ).append("\n"); 
		query.append("                   P.CTRL_WGT     ," ).append("\n"); 
		query.append("                   P.CTRL_40HC    ," ).append("\n"); 
		query.append("                   P.CTRL_45HC    ," ).append("\n"); 
		query.append("                   P.CTRL_53FT    ," ).append("\n"); 
		query.append("                   P.CTRL_RF" ).append("\n"); 
		query.append("              FROM VVD_POL_POD        P," ).append("\n"); 
		query.append("                   SPC_DLY_FCAST_CUST Z" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("             WHERE Z.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("               AND Z.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND Z.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("               AND Z.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND Z.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND Z.SLS_OFC_CD = P.OFC_CD" ).append("\n"); 
		query.append("               AND Z.TRD_CD     = P.TRD_CD" ).append("\n"); 
		query.append("               AND Z.SUB_TRD_CD = P.SUB_TRD_CD" ).append("\n"); 
		query.append("               AND Z.POL_YD_CD  = P.POL_CD" ).append("\n"); 
		query.append("               AND Z.POD_YD_CD  = P.POD_CD" ).append("\n"); 
		query.append("               AND NVL(Z.POL_IND_SEQ,1) = NVL(P.PL_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("               AND NVL(Z.POD_IND_SEQ,1) = NVL(P.PD_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            -- ALLOCATION" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                   DECODE(Z.TS_FLG, 'Y', 'T', Z.IOC_CD) AS IOC_TS_CD," ).append("\n"); 
		query.append("                   P.TRD_CD," ).append("\n"); 
		query.append("                   P.SUB_TRD_CD," ).append("\n"); 
		query.append("                   P.RLANE_CD," ).append("\n"); 
		query.append("                   P.VSL_CD," ).append("\n"); 
		query.append("                   P.SKD_VOY_NO," ).append("\n"); 
		query.append("                   P.SKD_DIR_CD," ).append("\n"); 
		query.append("                   Z.SLS_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("                   Z.POL_YD_CD  AS POL_CD," ).append("\n"); 
		query.append("                   Z.POD_YD_CD  AS POD_CD," ).append("\n"); 
		query.append("                   NULL AS BKG_QTA," ).append("\n"); 
		query.append("                   NULL AS FCT_VOL," ).append("\n"); 
		query.append("                   NULL AS FCT_HC ," ).append("\n"); 
		query.append("                   NULL AS FCT_45 ," ).append("\n"); 
		query.append("                   NULL AS FCT_53 ," ).append("\n"); 
		query.append("                   NULL AS FCT_RF ," ).append("\n"); 
		query.append("                   NULL AS FCT_WGT," ).append("\n"); 
		query.append("                   (Z.BKG_AVAL_TTL_QTY)     AS ALC_VOL," ).append("\n"); 
		query.append("                   (Z.BKG_AVAL_20FT_QTY)    AS ALC_20 ," ).append("\n"); 
		query.append("                   (Z.BKG_AVAL_40FT_QTY)    AS ALC_40 ," ).append("\n"); 
		query.append("                   (Z.BKG_AVAL_40FT_HC_QTY) AS ALC_HC ," ).append("\n"); 
		query.append("                   (Z.BKG_AVAL_45FT_HC_QTY) AS ALC_45 ," ).append("\n"); 
		query.append("                   (Z.BKG_AVAL_53FT_QTY)    AS ALC_53 ," ).append("\n"); 
		query.append("                   (Z.BKG_AVAL_RF_QTY)      AS ALC_RF ," ).append("\n"); 
		query.append("                   (Z.BKG_AVAL_TTL_WGT)     AS ALC_WGT," ).append("\n"); 
		query.append("                   NULL AS FRM_VOL," ).append("\n"); 
		query.append("                   NULL AS FRM_20 ," ).append("\n"); 
		query.append("                   NULL AS FRM_40 ," ).append("\n"); 
		query.append("                   NULL AS FRM_HC ," ).append("\n"); 
		query.append("                   NULL AS FRM_45 ," ).append("\n"); 
		query.append("                   NULL AS FRM_53 ," ).append("\n"); 
		query.append("                   NULL AS FRM_RF ," ).append("\n"); 
		query.append("                   NULL AS FRM_WGT," ).append("\n"); 
		query.append("                   NULL AS WAT_VOL," ).append("\n"); 
		query.append("                   NULL AS WAT_20 ," ).append("\n"); 
		query.append("                   NULL AS WAT_40 ," ).append("\n"); 
		query.append("                   NULL AS WAT_HC ," ).append("\n"); 
		query.append("                   NULL AS WAT_45 ," ).append("\n"); 
		query.append("                   NULL AS WAT_53 ," ).append("\n"); 
		query.append("                   NULL AS WAT_RF ," ).append("\n"); 
		query.append("                   NULL AS WAT_WGT," ).append("\n"); 
		query.append("                   P.CTRL_PORT    ," ).append("\n"); 
		query.append("                   P.CTRL_WGT     ," ).append("\n"); 
		query.append("                   P.CTRL_40HC    ," ).append("\n"); 
		query.append("                   P.CTRL_45HC    ," ).append("\n"); 
		query.append("                   P.CTRL_53FT    ," ).append("\n"); 
		query.append("                   P.CTRL_RF" ).append("\n"); 
		query.append("              FROM VVD_POL_POD      P," ).append("\n"); 
		query.append("                   SPC_ALOC_POL_POD Z" ).append("\n"); 
		query.append("             WHERE Z.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("               AND Z.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND Z.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("               AND Z.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND Z.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND Z.SLS_OFC_CD = P.OFC_CD" ).append("\n"); 
		query.append("               AND Z.TRD_CD     = P.TRD_CD" ).append("\n"); 
		query.append("               AND Z.SUB_TRD_CD = P.SUB_TRD_CD" ).append("\n"); 
		query.append("               AND Z.POL_YD_CD =  P.POL_CD" ).append("\n"); 
		query.append("               AND Z.POD_YD_CD  = P.POD_CD" ).append("\n"); 
		query.append("               AND NVL(Z.POL_IND_SEQ,1) = NVL(P.PL_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("               AND NVL(Z.POD_IND_SEQ,1) = NVL(P.PD_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("           SELECT" ).append("\n"); 
		query.append("                   IOC_TS_CD," ).append("\n"); 
		query.append("                   TRD_CD    ," ).append("\n"); 
		query.append("                   SUB_TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD  ," ).append("\n"); 
		query.append("                   VSL_CD    ," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD," ).append("\n"); 
		query.append("                   SLS_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("                   POL_CD," ).append("\n"); 
		query.append("                   POD_CD," ).append("\n"); 
		query.append("                   NULL AS BKG_QTA," ).append("\n"); 
		query.append("                   NULL AS FCT_VOL," ).append("\n"); 
		query.append("                   NULL AS FCT_HC ," ).append("\n"); 
		query.append("                   NULL AS FCT_45 ," ).append("\n"); 
		query.append("                   NULL AS FCT_53 ," ).append("\n"); 
		query.append("                   NULL AS FCT_RF ," ).append("\n"); 
		query.append("                   NULL AS FCT_WGT," ).append("\n"); 
		query.append("                   NULL AS ALC_VOL," ).append("\n"); 
		query.append("                   NULL AS ALC_20 ," ).append("\n"); 
		query.append("                   NULL AS ALC_40 ," ).append("\n"); 
		query.append("                   NULL AS ALC_HC ," ).append("\n"); 
		query.append("                   NULL AS ALC_45 ," ).append("\n"); 
		query.append("                   NULL AS ALC_53 ," ).append("\n"); 
		query.append("                   NULL AS ALC_RF ," ).append("\n"); 
		query.append("                   NULL AS ALC_WGT," ).append("\n"); 
		query.append("                   DECODE(BKG_STS_CD, 'F', BKG_TTL_QTY     ,0) AS FIRM_VOL," ).append("\n"); 
		query.append("                   DECODE(BKG_STS_CD, 'F', BKG_20FT_QTY    ,0) AS FIRM_20 ," ).append("\n"); 
		query.append("                   DECODE(BKG_STS_CD, 'F', BKG_40FT_QTY    ,0) AS FIRM_40 ," ).append("\n"); 
		query.append("                   DECODE(BKG_STS_CD, 'F', BKG_40FT_HC_QTY ,0) AS FIRM_HC ," ).append("\n"); 
		query.append("                   DECODE(BKG_STS_CD, 'F', BKG_45FT_HC_QTY ,0) AS FIRM_45 ," ).append("\n"); 
		query.append("                   DECODE(BKG_STS_CD, 'F', BKG_53FT_QTY    ,0) AS FIRM_53 ," ).append("\n"); 
		query.append("                   DECODE(BKG_STS_CD, 'F', BKG_RF_QTY      ,0) AS FIRM_RF ," ).append("\n"); 
		query.append("                   DECODE(BKG_STS_CD, 'F', BKG_TTL_WGT     ,0) AS FIRM_WGT," ).append("\n"); 
		query.append("                   DECODE(BKG_STS_CD, 'W', BKG_TTL_QTY     ,0) AS WAT_VOL ," ).append("\n"); 
		query.append("                   DECODE(BKG_STS_CD, 'W', BKG_20FT_QTY    ,0) AS WAT_20  ," ).append("\n"); 
		query.append("                   DECODE(BKG_STS_CD, 'W', BKG_40FT_QTY    ,0) AS WAT_40  ," ).append("\n"); 
		query.append("                   DECODE(BKG_STS_CD, 'W', BKG_40FT_HC_QTY ,0) AS WAT_HC  ," ).append("\n"); 
		query.append("                   DECODE(BKG_STS_CD, 'W', BKG_45FT_HC_QTY ,0) AS WAT_45  ," ).append("\n"); 
		query.append("                   DECODE(BKG_STS_CD, 'W', BKG_53FT_QTY    ,0) AS WAT_53  ," ).append("\n"); 
		query.append("                   DECODE(BKG_STS_CD, 'W', BKG_RF_QTY      ,0) AS WAT_RF  ," ).append("\n"); 
		query.append("                   DECODE(BKG_STS_CD, 'W', BKG_TTL_WGT     ,0) AS WAT_WGT ," ).append("\n"); 
		query.append("                   CTRL_PORT," ).append("\n"); 
		query.append("                   CTRL_WGT ," ).append("\n"); 
		query.append("                   CTRL_40HC," ).append("\n"); 
		query.append("                   CTRL_45HC," ).append("\n"); 
		query.append("                   CTRL_53FT," ).append("\n"); 
		query.append("                   CTRL_RF" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("                     TRD_CD              ," ).append("\n"); 
		query.append("                     SUB_TRD_CD          ," ).append("\n"); 
		query.append("                     RLANE_CD      		 ," ).append("\n"); 
		query.append("                     COST_YR             ," ).append("\n"); 
		query.append("                     COST_WK             ," ).append("\n"); 
		query.append("                     VSL_CD        		 ," ).append("\n"); 
		query.append("                     SKD_VOY_NO    		 ," ).append("\n"); 
		query.append("                     SKD_DIR_CD    		 ," ).append("\n"); 
		query.append("                     SLS_OFC_CD          ," ).append("\n"); 
		query.append("                     IOC_TS_CD           ," ).append("\n"); 
		query.append("                     POL_CD              ," ).append("\n"); 
		query.append("                     POD_CD              ," ).append("\n"); 
		query.append("                     BKG_STS_CD          ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0)) AS BKG_TTL_QTY    ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 15, 14), 0)) AS BKG_20FT_QTY   ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 29, 14), 0)) AS BKG_40FT_QTY   ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 43, 14), 0)) AS BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 57, 14), 0)) AS BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 71, 14), 0)) AS BKG_53FT_QTY   ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 85, 14), 0)) AS BKG_RF_QTY     ," ).append("\n"); 
		query.append("                     TO_NUMBER(NVL(SUBSTR(VAL, 99, 14), 0)) AS BKG_TTL_WGT    ," ).append("\n"); 
		query.append("                     CTRL_PORT," ).append("\n"); 
		query.append("                     CTRL_WGT ," ).append("\n"); 
		query.append("                     CTRL_40HC," ).append("\n"); 
		query.append("                     CTRL_45HC," ).append("\n"); 
		query.append("                     CTRL_53FT," ).append("\n"); 
		query.append("                     CTRL_RF" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                        SELECT  /*+ ORDERED USE_NL(VPP BV B D) USE_HASH(O) */" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                               VPP.TRD_CD        ," ).append("\n"); 
		query.append("                               VPP.SUB_TRD_CD    ," ).append("\n"); 
		query.append("                               VPP.RLANE_CD      ," ).append("\n"); 
		query.append("                               VPP.VSL_CD        ," ).append("\n"); 
		query.append("                               VPP.SKD_VOY_NO    ," ).append("\n"); 
		query.append("                               VPP.SKD_DIR_CD    ," ).append("\n"); 
		query.append("                               B.OB_SLS_OFC_CD AS SLS_OFC_CD ," ).append("\n"); 
		query.append("                               VPP.COST_YR       ," ).append("\n"); 
		query.append("                               VPP.COST_WK       ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                           DECODE(BV.VSL_PRE_PST_CD,'T', (SELECT   DECODE(B.FM_CONTI_CD,B.TO_CONTI_CD,'I','O')" ).append("\n"); 
		query.append("                                                         FROM MDM_REV_LANE A,  MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append("                                                         WHERE B.RLANE_CD = A.RLANE_CD" ).append("\n"); 
		query.append("                                                          AND B.RLANE_CD LIKE BV.SLAN_CD||'%'" ).append("\n"); 
		query.append("                                                          AND B.FM_CONTI_CD = (" ).append("\n"); 
		query.append("                                                                                SELECT MLOC.CONTI_CD" ).append("\n"); 
		query.append("                                                                                FROM MDM_LOCATION MLOC" ).append("\n"); 
		query.append("                                                                                WHERE MLOC.LOC_CD = BV.POL_CD " ).append("\n"); 
		query.append("                                                                              )" ).append("\n"); 
		query.append("                                                          AND B.TO_CONTI_CD = (" ).append("\n"); 
		query.append("                                                                                SELECT MLOC.CONTI_CD" ).append("\n"); 
		query.append("                                                                                FROM MDM_LOCATION MLOC" ).append("\n"); 
		query.append("                                                                                WHERE MLOC.LOC_CD = BV.POD_CD " ).append("\n"); 
		query.append("                                                                               )" ).append("\n"); 
		query.append("                                                          AND B.VSL_SLAN_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                          AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                          AND ROWNUM = 1 ),'T') AS IOC_TS_CD ," ).append("\n"); 
		query.append("                               VPP.POL_CD              ," ).append("\n"); 
		query.append("                               VPP.POD_CD              ," ).append("\n"); 
		query.append("                               B.BKG_STS_CD            ," ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("                               ) AS VAL ," ).append("\n"); 
		query.append("                               VPP.CTRL_PORT," ).append("\n"); 
		query.append("                               VPP.CTRL_WGT ," ).append("\n"); 
		query.append("                               VPP.CTRL_40HC," ).append("\n"); 
		query.append("                               VPP.CTRL_45HC," ).append("\n"); 
		query.append("                               VPP.CTRL_53FT," ).append("\n"); 
		query.append("                               VPP.CTRL_RF" ).append("\n"); 
		query.append("                         FROM  " ).append("\n"); 
		query.append("                               VVD_POL_POD VPP," ).append("\n"); 
		query.append("                               BKG_VVD     BV ," ).append("\n"); 
		query.append("                               BKG_BOOKING B  ," ).append("\n"); 
		query.append("                               SPC_OFC_LVL O  , " ).append("\n"); 
		query.append("                               BKG_BL_DOC  D" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND (VPP.TRD_CD,VPP.SUB_TRD_CD,VPP.RLANE_CD)  =  (" ).append("\n"); 
		query.append("                                                                                        SELECT   B.TRD_CD,B.SUB_TRD_CD ,B.RLANE_CD" ).append("\n"); 
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
		query.append("                           AND O.OFC_CD     = B.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("                           AND O.OFC_CD     = VPP.OFC_CD" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("             ) " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ) Z" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                         (Z.IOC_TS_CD, Z.OFC_CD, Z.POL_CD, Z.POD_CD)," ).append("\n"); 
		query.append("                         (Z.IOC_TS_CD, Z.OFC_CD, Z.POL_CD)," ).append("\n"); 
		query.append("                         (Z.IOC_TS_CD, Z.OFC_CD)" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("  HAVING SUBSTR(NVL(Z.POL_CD, ' '), 1, 5) <> '00000'" ).append("\n"); 
		query.append("ORDER BY DECODE(Z.IOC_TS_CD, 'O', 1, 'I', 2, 'T', 3)," ).append("\n"); 
		query.append("         Z.OFC_CD," ).append("\n"); 
		query.append("         NVL(Z.POL_CD, '0')," ).append("\n"); 
		query.append("         NVL(Z.POD_CD, '0')" ).append("\n"); 

	}
}