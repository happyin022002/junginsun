/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : QtaAdjustmentDBDAOCreateQtaEditOfficeAddIasSectorCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOCreateQtaEditOfficeAddIasSectorCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qta Edit Office Add for IAS Sector을 생성합니다.
	  * 
	  * *History
	  * 2014.06.26 이혜민 PAIR, Office는 같은데 POL_CALL_SEQ, POD_CALL_SEQ 가 달라 중복 데이터 insert 수정
	  * 2014.07.04 이혜민 SQM_SCTR_LANE_OFC 내 SQM_ACT_FLG='Y' 추가
	  * 2016.02.05 최성민 [CHM-201639787] SQM Planning 도중 & Planning 완료 후 노선, P/F Group, Sector 추가 로직 Process 변경
	  * 2016.04.11 최성민 [CHM-201640884] Sector Office Add 로직 수정
	  * 2016.04.22 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * </pre>
	  */
	public QtaAdjustmentDBDAOCreateQtaEditOfficeAddIasSectorCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOCreateQtaEditOfficeAddIasSectorCSQL").append("\n"); 
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
		query.append("MERGE INTO SQM_SCTR_CFM_QTA A1 USING " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SELECT DISTINCT A2.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      , A1.BSE_TP_CD" ).append("\n"); 
		query.append("      , A1.BSE_YR" ).append("\n"); 
		query.append("      , A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      , A1.OFC_VW_CD" ).append("\n"); 
		query.append("      , A1.RLANE_CD" ).append("\n"); 
		query.append("      , A1.DIR_CD" ).append("\n"); 
		query.append("      , A2.VSL_CD" ).append("\n"); 
		query.append("      , A2.SKD_VOY_NO" ).append("\n"); 
		query.append("      , A2.SKD_DIR_CD" ).append("\n"); 
		query.append("      , A1.RGN_OFC_CD" ).append("\n"); 
		query.append("      , A1.POL_CD" ).append("\n"); 
		query.append("      , A1.POD_CD" ).append("\n"); 
		query.append("        -- Adjustment by VVD for IAS 화면의 VVD 별 PF GRP 를 가져오고 없으면 TARGET VVD FIX 테이블에서 참조한다." ).append("\n"); 
		query.append("      , NVL(MAX(A4.PF_GRP_CD) OVER (PARTITION BY A4.RLANE_CD, A4.VSL_CD, A4.SKD_VOY_NO, A4.SKD_DIR_CD), QT.PF_GRP_CD) AS PF_GRP_CD" ).append("\n"); 
		query.append("      , A1.TRD_CD" ).append("\n"); 
		query.append("      , A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      , A1.RHQ_CD" ).append("\n"); 
		query.append("      , NVL((SELECT N3RD_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = A1.RGN_OFC_CD), '') AS AQ_CD" ).append("\n"); 
		query.append("      , A2.FNL_BSA_CAPA" ).append("\n"); 
		query.append("--      , A2.LOD_QTY" ).append("\n"); 
		query.append("      ,NVL((SELECT NVL(PLANNING.LOD_QTY, 0) FROM SQM_SCTR_LOD_REV PLANNING" ).append("\n"); 
		query.append("        WHERE PLANNING.BSE_TP_CD = A1.BSE_TP_CD" ).append("\n"); 
		query.append("        AND PLANNING.BSE_YR = A1.BSE_YR" ).append("\n"); 
		query.append("        AND PLANNING.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND PLANNING.OFC_VW_CD = A1.OFC_VW_CD" ).append("\n"); 
		query.append("        AND PLANNING.RLANE_CD = A1.RLANE_CD" ).append("\n"); 
		query.append("        AND PLANNING.DIR_CD = A1.DIR_CD" ).append("\n"); 
		query.append("        AND PLANNING.FNL_BSA_CAPA = A2.FNL_BSA_CAPA" ).append("\n"); 
		query.append("        AND PLANNING.PF_GRP_CD = NVL((SELECT MAX(CFM.PF_GRP_CD) FROM SQM_SCTR_CFM_QTA CFM" ).append("\n"); 
		query.append("                                        WHERE CFM.RLANE_CD = A1.RLANE_CD" ).append("\n"); 
		query.append("                                        AND CFM.VSL_CD = A2.VSL_CD" ).append("\n"); 
		query.append("                                        AND CFM.SKD_VOY_NO = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                        AND CFM.SKD_DIR_CD = A2.SKD_DIR_CD), QT.PF_GRP_CD)" ).append("\n"); 
		query.append("        AND PLANNING.RGN_OFC_CD = A1.RGN_OFC_CD" ).append("\n"); 
		query.append("        AND PLANNING.POL_CD = A1.POL_CD" ).append("\n"); 
		query.append("        AND PLANNING.POD_CD = A1.POD_CD" ).append("\n"); 
		query.append("        AND ROWNUM < 2), 0) AS LOD_QTY" ).append("\n"); 
		query.append("--      , A2.GRS_REV AS GRS_RPB_REV" ).append("\n"); 
		query.append("      ,NVL((SELECT NVL(PLANNING.GRS_RPB_REV, 0) FROM SQM_SCTR_LOD_REV PLANNING" ).append("\n"); 
		query.append("        WHERE PLANNING.BSE_TP_CD = A1.BSE_TP_CD" ).append("\n"); 
		query.append("        AND PLANNING.BSE_YR = A1.BSE_YR" ).append("\n"); 
		query.append("        AND PLANNING.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND PLANNING.OFC_VW_CD = A1.OFC_VW_CD" ).append("\n"); 
		query.append("        AND PLANNING.RLANE_CD = A1.RLANE_CD" ).append("\n"); 
		query.append("        AND PLANNING.DIR_CD = A1.DIR_CD" ).append("\n"); 
		query.append("        AND PLANNING.FNL_BSA_CAPA = A2.FNL_BSA_CAPA" ).append("\n"); 
		query.append("        AND PLANNING.PF_GRP_CD = NVL((SELECT MAX(CFM.PF_GRP_CD) FROM SQM_SCTR_CFM_QTA CFM" ).append("\n"); 
		query.append("                                        WHERE CFM.RLANE_CD = A1.RLANE_CD" ).append("\n"); 
		query.append("                                        AND CFM.VSL_CD = A2.VSL_CD" ).append("\n"); 
		query.append("                                        AND CFM.SKD_VOY_NO = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                        AND CFM.SKD_DIR_CD = A2.SKD_DIR_CD), QT.PF_GRP_CD)" ).append("\n"); 
		query.append("        AND PLANNING.RGN_OFC_CD = A1.RGN_OFC_CD" ).append("\n"); 
		query.append("        AND PLANNING.POL_CD = A1.POL_CD" ).append("\n"); 
		query.append("        AND PLANNING.POD_CD = A1.POD_CD" ).append("\n"); 
		query.append("        AND ROWNUM < 2), 0) AS GRS_RPB_REV" ).append("\n"); 
		query.append("      , A3.PA_CM_UC_AMT" ).append("\n"); 
		query.append("      , A3.RA_CM_UC_AMT" ).append("\n"); 
		query.append("      , MIN(A1.POL_CALL_SEQ) OVER (PARTITION BY A1.BSE_TP_CD, A1.BSE_YR, A1.BSE_QTR_CD, A1.OFC_VW_CD, A1.RLANE_CD, A1.DIR_CD, A1.RGN_OFC_CD, A1.POL_CD, A1.POD_CD, A1.TRD_CD, A1.SUB_TRD_CD) POL_CALL_SEQ" ).append("\n"); 
		query.append("      , MAX(A1.POD_CALL_SEQ) OVER (PARTITION BY A1.BSE_TP_CD, A1.BSE_YR, A1.BSE_QTR_CD, A1.OFC_VW_CD, A1.RLANE_CD, A1.DIR_CD, A1.RGN_OFC_CD, A1.POL_CD, A1.POD_CD, A1.TRD_CD, A1.SUB_TRD_CD) POD_CALL_SEQ" ).append("\n"); 
		query.append("      , 'I'       AS SQM_CNG_TP_CD" ).append("\n"); 
		query.append("      , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE   AS CRE_DT" ).append("\n"); 
		query.append("      , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE   AS UPD_DT" ).append("\n"); 
		query.append("   FROM SQM_SCTR_LANE_OFC A1" ).append("\n"); 
		query.append("      , SQM_CFM_TGT_VVD A2" ).append("\n"); 
		query.append("      , SQM_SCTR_PAIR_COST A3" ).append("\n"); 
		query.append("      , SQM_SCTR_CFM_QTA A4" ).append("\n"); 
		query.append("      , (SELECT QT.BSE_TP_CD" ).append("\n"); 
		query.append("              , QT.BSE_YR" ).append("\n"); 
		query.append("              , QT.BSE_QTR_CD" ).append("\n"); 
		query.append("              , QT.TRD_CD" ).append("\n"); 
		query.append("              , QT.RLANE_CD" ).append("\n"); 
		query.append("              , QT.DIR_CD" ).append("\n"); 
		query.append("              , QT.VSL_CD" ).append("\n"); 
		query.append("              , QT.SKD_VOY_NO" ).append("\n"); 
		query.append("              , QT.SKD_DIR_CD" ).append("\n"); 
		query.append("              , PG.PF_GRP_CD" ).append("\n"); 
		query.append("           FROM SQM_SCTR_PF_GRP PG" ).append("\n"); 
		query.append("              , SQM_QTA_TGT_VVD QT" ).append("\n"); 
		query.append("          WHERE PG.BSE_TP_CD    = QT.BSE_TP_CD" ).append("\n"); 
		query.append("            AND PG.BSE_YR       = QT.BSE_YR" ).append("\n"); 
		query.append("            AND PG.BSE_QTR_CD   = QT.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND PG.RLANE_CD     = QT.RLANE_CD" ).append("\n"); 
		query.append("            AND PG.PF_SVC_TP_CD = QT.PF_SVC_TP_CD" ).append("\n"); 
		query.append("            AND PG.RLANE_CD     = QT.RLANE_CD  " ).append("\n"); 
		query.append("          UNION            " ).append("\n"); 
		query.append("         SELECT QT.BSE_TP_CD" ).append("\n"); 
		query.append("              , QT.BSE_YR" ).append("\n"); 
		query.append("              , QT.BSE_QTR_CD" ).append("\n"); 
		query.append("              , QT.TRD_CD" ).append("\n"); 
		query.append("              , QT.RLANE_CD" ).append("\n"); 
		query.append("              , QT.DIR_CD" ).append("\n"); 
		query.append("              , QT.VSL_CD" ).append("\n"); 
		query.append("              , QT.SKD_VOY_NO" ).append("\n"); 
		query.append("              , QT.SKD_DIR_CD" ).append("\n"); 
		query.append("              , PG.PF_GRP_CD" ).append("\n"); 
		query.append("           FROM SQM_SCTR_PF_GRP PG" ).append("\n"); 
		query.append("              , SQM_SCTR_ADD_TGT_VVD QT" ).append("\n"); 
		query.append("          WHERE PG.BSE_TP_CD    = QT.BSE_TP_CD" ).append("\n"); 
		query.append("            AND PG.BSE_YR       = QT.BSE_YR" ).append("\n"); 
		query.append("            AND PG.BSE_QTR_CD   = QT.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND PG.RLANE_CD     = QT.RLANE_CD" ).append("\n"); 
		query.append("            AND PG.PF_GRP_CD    = QT.PF_GRP_CD" ).append("\n"); 
		query.append("            AND PG.RLANE_CD     = QT.RLANE_CD" ).append("\n"); 
		query.append("        ) QT" ).append("\n"); 
		query.append("  WHERE 1              =1" ).append("\n"); 
		query.append("    AND A1.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("    AND A1.BSE_TP_CD   = @[bse_tp_cd]" ).append("\n"); 
		query.append("    AND A1.BSE_YR      = @[bse_yr]" ).append("\n"); 
		query.append("    AND A1.BSE_QTR_CD  = @[bse_qtr_cd]" ).append("\n"); 
		query.append("    AND A1.OFC_VW_CD   = SUBSTR(@[ofc_vw_cd], 0 ,1)" ).append("\n"); 
		query.append("    AND A1.SUB_TRD_CD  = @[sub_trd_cd]" ).append("\n"); 
		query.append("    AND A1.RLANE_CD    = @[rlane_cd]" ).append("\n"); 
		query.append("    AND A1.DIR_CD      = @[dir_cd]" ).append("\n"); 
		query.append("    AND A1.POL_CD      = @[pol_cd]" ).append("\n"); 
		query.append("    AND A1.POD_CD      = @[pod_cd]" ).append("\n"); 
		query.append("    AND A1.RHQ_CD      = @[rhq_cd]" ).append("\n"); 
		query.append("    AND A1.RGN_OFC_CD  = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND SUBSTR(A2.QTA_RLSE_VER_NO, -2) = '02'" ).append("\n"); 
		query.append("    AND A1.BSE_TP_CD       = A2.BSE_TP_CD" ).append("\n"); 
		query.append("    AND A1.BSE_YR          = A2.BSE_YR" ).append("\n"); 
		query.append("    AND A1.BSE_QTR_CD      = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND A1.SUB_TRD_CD      = A2.SUB_TRD_CD" ).append("\n"); 
		query.append("    AND A1.RLANE_CD        = A2.RLANE_CD" ).append("\n"); 
		query.append("    AND A1.DIR_CD          = A2.DIR_CD" ).append("\n"); 
		query.append("    AND A1.BSE_TP_CD       = A3.BSE_TP_CD" ).append("\n"); 
		query.append("    AND A1.BSE_YR          = A3.BSE_YR" ).append("\n"); 
		query.append("    AND A1.BSE_QTR_CD      = A3.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND A1.SUB_TRD_CD      = A3.SUB_TRD_CD" ).append("\n"); 
		query.append("    AND A1.RLANE_CD        = A3.RLANE_CD" ).append("\n"); 
		query.append("    AND A1.DIR_CD          = A3.DIR_CD" ).append("\n"); 
		query.append("    AND A1.POL_CD          = A3.POL_CD" ).append("\n"); 
		query.append("    AND A1.POD_CD          = A3.POD_CD" ).append("\n"); 
		query.append("    AND A2.QTA_RLSE_VER_NO = A4.QTA_RLSE_VER_NO(+)" ).append("\n"); 
		query.append("    AND A2.BSE_TP_CD       = A4.BSE_TP_CD(+)" ).append("\n"); 
		query.append("    AND A2.BSE_YR          = A4.BSE_YR(+)" ).append("\n"); 
		query.append("    AND A2.BSE_QTR_CD      = A4.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("    AND A2.TRD_CD          = A4.TRD_CD(+)" ).append("\n"); 
		query.append("    AND A2.RLANE_CD        = A4.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND A2.DIR_CD          = A4.DIR_CD(+)" ).append("\n"); 
		query.append("    AND A2.VSL_CD          = A4.VSL_CD(+)" ).append("\n"); 
		query.append("    AND A2.SKD_VOY_NO      = A4.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND A2.SKD_DIR_CD      = A4.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("    AND A2.BSE_TP_CD       = QT.BSE_TP_CD(+)" ).append("\n"); 
		query.append("    AND A2.BSE_YR          = QT.BSE_YR(+)" ).append("\n"); 
		query.append("    AND A2.BSE_QTR_CD      = QT.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("    AND A2.TRD_CD          = QT.TRD_CD(+)" ).append("\n"); 
		query.append("    AND A2.RLANE_CD        = QT.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND A2.DIR_CD          = QT.DIR_CD(+)" ).append("\n"); 
		query.append("    AND A2.VSL_CD          = QT.VSL_CD(+)" ).append("\n"); 
		query.append("    AND A2.SKD_VOY_NO      = QT.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND A2.SKD_DIR_CD      = QT.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("    AND (A4.PF_GRP_CD = @[pf_grp_cd] OR QT.PF_GRP_CD = @[pf_grp_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") A2" ).append("\n"); 
		query.append("ON (    A1.QTA_RLSE_VER_NO = A2.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("	AND A1.BSE_TP_CD       = A2.BSE_TP_CD" ).append("\n"); 
		query.append("	AND A1.BSE_YR	       = A2.BSE_YR" ).append("\n"); 
		query.append("	AND A1.BSE_QTR_CD      = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("	AND A1.OFC_VW_CD       = A2.OFC_VW_CD" ).append("\n"); 
		query.append("	AND A1.RLANE_CD	       = A2.RLANE_CD" ).append("\n"); 
		query.append("	AND A1.DIR_CD	       = A2.DIR_CD" ).append("\n"); 
		query.append("	AND A1.VSL_CD	       = A2.VSL_CD" ).append("\n"); 
		query.append("	AND A1.SKD_VOY_NO      = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND A1.SKD_DIR_CD      = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND A1.RGN_OFC_CD      = A2.RGN_OFC_CD" ).append("\n"); 
		query.append("	AND A1.POL_CD	       = A2.POL_CD" ).append("\n"); 
		query.append("	AND A1.POD_CD	       = A2.POD_CD )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT (" ).append("\n"); 
		query.append("	  A1.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("	, A1.BSE_TP_CD" ).append("\n"); 
		query.append("	, A1.BSE_YR" ).append("\n"); 
		query.append("	, A1.BSE_QTR_CD" ).append("\n"); 
		query.append("	, A1.OFC_VW_CD" ).append("\n"); 
		query.append("	, A1.RLANE_CD" ).append("\n"); 
		query.append("	, A1.DIR_CD" ).append("\n"); 
		query.append("	, A1.VSL_CD" ).append("\n"); 
		query.append("	, A1.SKD_VOY_NO" ).append("\n"); 
		query.append("	, A1.SKD_DIR_CD" ).append("\n"); 
		query.append("	, A1.RGN_OFC_CD" ).append("\n"); 
		query.append("	, A1.POL_CD" ).append("\n"); 
		query.append("	, A1.POD_CD" ).append("\n"); 
		query.append("	, A1.PF_GRP_CD" ).append("\n"); 
		query.append("	, A1.TRD_CD" ).append("\n"); 
		query.append("	, A1.SUB_TRD_CD" ).append("\n"); 
		query.append("	, A1.RHQ_CD" ).append("\n"); 
		query.append("	, A1.AQ_CD" ).append("\n"); 
		query.append("	, A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("	, A1.LOD_QTY" ).append("\n"); 
		query.append("	, A1.GRS_RPB_REV" ).append("\n"); 
		query.append("	, A1.PA_CM_UC_AMT" ).append("\n"); 
		query.append("	, A1.RA_CM_UC_AMT" ).append("\n"); 
		query.append("	, A1.POL_CALL_SEQ" ).append("\n"); 
		query.append("	, A1.POD_CALL_SEQ" ).append("\n"); 
		query.append("	, A1.SQM_CNG_TP_CD" ).append("\n"); 
		query.append("	, A1.CRE_USR_ID" ).append("\n"); 
		query.append("	, A1.CRE_DT" ).append("\n"); 
		query.append("	, A1.UPD_USR_ID" ).append("\n"); 
		query.append("	, A1.UPD_DT )" ).append("\n"); 
		query.append("   VALUES (" ).append("\n"); 
		query.append("	  A2.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("	, A2.BSE_TP_CD" ).append("\n"); 
		query.append("	, A2.BSE_YR" ).append("\n"); 
		query.append("	, A2.BSE_QTR_CD" ).append("\n"); 
		query.append("	, A2.OFC_VW_CD" ).append("\n"); 
		query.append("	, A2.RLANE_CD" ).append("\n"); 
		query.append("	, A2.DIR_CD" ).append("\n"); 
		query.append("	, A2.VSL_CD" ).append("\n"); 
		query.append("	, A2.SKD_VOY_NO" ).append("\n"); 
		query.append("	, A2.SKD_DIR_CD" ).append("\n"); 
		query.append("	, A2.RGN_OFC_CD" ).append("\n"); 
		query.append("	, A2.POL_CD" ).append("\n"); 
		query.append("	, A2.POD_CD" ).append("\n"); 
		query.append("	, A2.PF_GRP_CD" ).append("\n"); 
		query.append("	, A2.TRD_CD" ).append("\n"); 
		query.append("	, A2.SUB_TRD_CD" ).append("\n"); 
		query.append("	, A2.RHQ_CD" ).append("\n"); 
		query.append("	, A2.AQ_CD" ).append("\n"); 
		query.append("	, A2.FNL_BSA_CAPA" ).append("\n"); 
		query.append("	, A2.LOD_QTY" ).append("\n"); 
		query.append("	, A2.GRS_RPB_REV" ).append("\n"); 
		query.append("	, A2.PA_CM_UC_AMT" ).append("\n"); 
		query.append("	, A2.RA_CM_UC_AMT" ).append("\n"); 
		query.append("	, A2.POL_CALL_SEQ" ).append("\n"); 
		query.append("	, A2.POD_CALL_SEQ" ).append("\n"); 
		query.append("	, A2.SQM_CNG_TP_CD" ).append("\n"); 
		query.append("	, A2.CRE_USR_ID" ).append("\n"); 
		query.append("	, A2.CRE_DT" ).append("\n"); 
		query.append("	, A2.UPD_USR_ID" ).append("\n"); 
		query.append("	, A2.UPD_DT )" ).append("\n"); 

	}
}