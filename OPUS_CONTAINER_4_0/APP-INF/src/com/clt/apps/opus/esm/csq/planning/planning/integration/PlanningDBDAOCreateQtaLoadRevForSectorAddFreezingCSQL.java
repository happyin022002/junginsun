/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PlanningDBDAOCreateQtaLoadRevForSectorAddFreezingCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAOCreateQtaLoadRevForSectorAddFreezingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [QTA Set up for IAS Sector by Head Office_Add Freezing] 의 [확정데이터]를 생성한다.
	  * </pre>
	  */
	public PlanningDBDAOCreateQtaLoadRevForSectorAddFreezingCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOCreateQtaLoadRevForSectorAddFreezingCSQL").append("\n"); 
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
		query.append("INSERT INTO CSQ_SCTR_CFM_QTA(QTA_RLSE_VER_NO, BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, RLANE_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, RGN_OFC_CD, POL_CD, POD_CD, PF_GRP_CD, TRD_CD, SUB_TRD_CD, RHQ_CD, AQ_CD, FNL_BSA_CAPA, LOD_QTY, GRS_RPB_REV, PA_CM_UC_AMT, RA_CM_UC_AMT, POL_CALL_SEQ, POD_CALL_SEQ, CSQ_CNG_TP_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("       SUBSTR(@[bse_yr], 3, 2) || C1.BSE_QTR_CD || '02' AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,C1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,C1.BSE_YR" ).append("\n"); 
		query.append("      ,C1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,C1.OFC_VW_CD" ).append("\n"); 
		query.append("      ,C1.RLANE_CD" ).append("\n"); 
		query.append("      ,C1.DIR_CD" ).append("\n"); 
		query.append("      ,C4.VSL_CD" ).append("\n"); 
		query.append("      ,C4.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,C4.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,C1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,C1.POL_CD" ).append("\n"); 
		query.append("      ,C1.POD_CD" ).append("\n"); 
		query.append("      ,C1.PF_GRP_CD" ).append("\n"); 
		query.append("      ,C1.TRD_CD" ).append("\n"); 
		query.append("      ,C1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,C1.RHQ_CD" ).append("\n"); 
		query.append("      ,NVL((SELECT N3RD_PRNT_OFC_CD FROM CSQ_ORGANIZATION_V WHERE OFC_CD = C1.RGN_OFC_CD),'') AS AQ_CD" ).append("\n"); 
		query.append("      ,C4.FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,C2.LOD_QTY" ).append("\n"); 
		query.append("      ,C2.GRS_RPB_REV" ).append("\n"); 
		query.append("      ,C3.PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,C3.RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,C1.POL_CALL_SEQ" ).append("\n"); 
		query.append("      ,C1.POD_CALL_SEQ" ).append("\n"); 
		query.append("      ,'I'        AS CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("      ,@[usr_id]  AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE    AS CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id]  AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE    AS UPD_DT" ).append("\n"); 
		query.append("  FROM CSQ_SCTR_LANE_OFC  C1" ).append("\n"); 
		query.append("      ,CSQ_SCTR_LOD_REV   C2" ).append("\n"); 
		query.append("      ,CSQ_SCTR_PAIR_COST C3" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("               B1.BSE_TP_CD" ).append("\n"); 
		query.append("              ,B1.BSE_YR" ).append("\n"); 
		query.append("              ,B1.BSE_QTR_CD" ).append("\n"); 
		query.append("              ,B1.TRD_CD" ).append("\n"); 
		query.append("              ,B1.RLANE_CD" ).append("\n"); 
		query.append("              ,B1.DIR_CD" ).append("\n"); 
		query.append("              ,B1.PF_GRP_CD" ).append("\n"); 
		query.append("              ,B1.VSL_CD" ).append("\n"); 
		query.append("              ,B1.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,B1.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,B1.BSE_MON" ).append("\n"); 
		query.append("              ,B1.BSE_WK" ).append("\n"); 
		query.append("              ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,B1.IOC_CD" ).append("\n"); 
		query.append("              ,B1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("              ,MAX(B2.RANGE_BSA)+9 AS BSA_CAPA --차이가 0~9 사이일 경우 큰 BSA를 대표로 그룹핑한다." ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT A1.BSE_TP_CD" ).append("\n"); 
		query.append("                      ,A1.BSE_YR" ).append("\n"); 
		query.append("                      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("                      ,A1.TRD_CD" ).append("\n"); 
		query.append("                      ,A1.RLANE_CD" ).append("\n"); 
		query.append("                      ,A1.DIR_CD" ).append("\n"); 
		query.append("                      ,A1.PF_GRP_CD" ).append("\n"); 
		query.append("                      ,A1.VSL_CD" ).append("\n"); 
		query.append("                      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("                      ,A1.BSE_MON" ).append("\n"); 
		query.append("                      ,A1.BSE_WK" ).append("\n"); 
		query.append("                      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                      ,A1.IOC_CD" ).append("\n"); 
		query.append("                      ,A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                      ,A1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                  FROM CSQ_SCTR_ADD_TGT_VVD A1" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND A1.BSE_TP_CD       = @[bse_tp_cd]" ).append("\n"); 
		query.append("                   AND A1.BSE_YR          = @[bse_yr]" ).append("\n"); 
		query.append("                   AND A1.BSE_QTR_CD      = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("                   AND A1.TRD_CD          = @[trd_cd]" ).append("\n"); 
		query.append("                   AND A1.RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("                   AND A1.PF_GRP_CD       = @[pf_grp_cd]" ).append("\n"); 
		query.append("                   AND A1.DIR_CD          = NVL(@[dir_cd], A1.DIR_CD)" ).append("\n"); 
		query.append("                 ORDER BY A1.DIR_CD, A1.RLANE_CD,A1.FNL_BSA_CAPA DESC" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT DISTINCT RLANE_CD, DIR_CD, FNL_BSA_CAPA, FNL_BSA_CAPA - 9 AS RANGE_BSA" ).append("\n"); 
		query.append("                  FROM CSQ_SCTR_ADD_TGT_VVD" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND BSE_TP_CD       = @[bse_tp_cd]" ).append("\n"); 
		query.append("                   AND BSE_YR          = @[bse_yr]" ).append("\n"); 
		query.append("                   AND BSE_QTR_CD      = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("                   AND TRD_CD          = @[trd_cd]" ).append("\n"); 
		query.append("                   AND RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("                   AND PF_GRP_CD       = @[pf_grp_cd]" ).append("\n"); 
		query.append("                   AND DIR_CD          = NVL(@[dir_cd], DIR_CD)" ).append("\n"); 
		query.append("                 ORDER BY DIR_CD, RLANE_CD, FNL_BSA_CAPA DESC  " ).append("\n"); 
		query.append("               ) B2" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND B1.DIR_CD        = B2.DIR_CD" ).append("\n"); 
		query.append("           AND B1.RLANE_CD      = B2.RLANE_CD" ).append("\n"); 
		query.append("           AND B1.FNL_BSA_CAPA >= B2.RANGE_BSA" ).append("\n"); 
		query.append("         GROUP BY B1.BSE_TP_CD" ).append("\n"); 
		query.append("                 ,B1.BSE_YR" ).append("\n"); 
		query.append("                 ,B1.BSE_QTR_CD" ).append("\n"); 
		query.append("                 ,B1.TRD_CD" ).append("\n"); 
		query.append("                 ,B1.RLANE_CD" ).append("\n"); 
		query.append("                 ,B1.DIR_CD" ).append("\n"); 
		query.append("                 ,B1.PF_GRP_CD" ).append("\n"); 
		query.append("                 ,B1.VSL_CD" ).append("\n"); 
		query.append("                 ,B1.SKD_VOY_NO" ).append("\n"); 
		query.append("                 ,B1.SKD_DIR_CD" ).append("\n"); 
		query.append("                 ,B1.BSE_MON" ).append("\n"); 
		query.append("                 ,B1.BSE_WK" ).append("\n"); 
		query.append("                 ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("                 ,B1.IOC_CD" ).append("\n"); 
		query.append("                 ,B1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("         ORDER BY B1.DIR_CD, B1.RLANE_CD,B1.FNL_BSA_CAPA DESC,  B1.BSE_MON,  B1.BSE_WK       " ).append("\n"); 
		query.append("       ) C4" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND C1.BSE_TP_CD   = @[bse_tp_cd]" ).append("\n"); 
		query.append("   AND C1.BSE_YR      = @[bse_yr]" ).append("\n"); 
		query.append("   AND C1.BSE_QTR_CD  = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("   AND C1.TRD_CD      = @[trd_cd]" ).append("\n"); 
		query.append("   AND C1.RLANE_CD    = @[rlane_cd]" ).append("\n"); 
		query.append("   AND C1.PF_GRP_CD   = @[pf_grp_cd]" ).append("\n"); 
		query.append("   AND C1.DIR_CD      = NVL(@[dir_cd], C1.DIR_CD)" ).append("\n"); 
		query.append("   AND C1.CSQ_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND C1.BSE_TP_CD   = C2.BSE_TP_CD" ).append("\n"); 
		query.append("   AND C1.BSE_YR      = C2.BSE_YR" ).append("\n"); 
		query.append("   AND C1.BSE_QTR_CD  = C2.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND C1.OFC_VW_CD   = C2.OFC_VW_CD" ).append("\n"); 
		query.append("   AND C1.RLANE_CD    = C2.RLANE_CD" ).append("\n"); 
		query.append("   AND C1.DIR_CD      = C2.DIR_CD" ).append("\n"); 
		query.append("   AND C1.PF_GRP_CD   = C2.PF_GRP_CD" ).append("\n"); 
		query.append("   AND C1.RGN_OFC_CD  = C2.RGN_OFC_CD" ).append("\n"); 
		query.append("   AND C1.POL_CD      = C2.POL_CD" ).append("\n"); 
		query.append("   AND C1.POD_CD      = C2.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND C1.BSE_TP_CD   = C3.BSE_TP_CD" ).append("\n"); 
		query.append("   AND C1.BSE_YR      = C3.BSE_YR" ).append("\n"); 
		query.append("   AND C1.BSE_QTR_CD  = C3.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND C1.RLANE_CD    = C3.RLANE_CD" ).append("\n"); 
		query.append("   AND C1.DIR_CD      = C3.DIR_CD" ).append("\n"); 
		query.append("   AND C1.POL_CD      = C3.POL_CD" ).append("\n"); 
		query.append("   AND C1.POD_CD      = C3.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND C2.BSE_TP_CD    = C4.BSE_TP_CD" ).append("\n"); 
		query.append("   AND C2.BSE_YR       = C4.BSE_YR" ).append("\n"); 
		query.append("   AND C2.BSE_QTR_CD   = C4.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND C2.TRD_CD       = C4.TRD_CD" ).append("\n"); 
		query.append("   AND C2.RLANE_CD     = C4.RLANE_CD" ).append("\n"); 
		query.append("   AND C2.DIR_CD       = C4.DIR_CD" ).append("\n"); 
		query.append("   AND C2.FNL_BSA_CAPA = C4.BSA_CAPA" ).append("\n"); 
		query.append("   AND C2.PF_GRP_CD    = C4.PF_GRP_CD" ).append("\n"); 
		query.append("ORDER BY QTA_RLSE_VER_NO,OFC_VW_CD,RLANE_CD,DIR_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,PF_GRP_CD,AQ_CD,RGN_OFC_CD,POL_CALL_SEQ,POD_CALL_SEQ" ).append("\n"); 

	}
}