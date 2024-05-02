/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PlanningDBDAOSearchQtaLoadRevForSectorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.18
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.03.18 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAOSearchQtaLoadRevForSectorListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [QTA Set up for IAS Sector by Head Office] 데이터를 조회한다.
	  * * History
	  * * 2016.01.28 최성민 [CHM-201639851] (Basic Data Creation for IAS Secotr 화면의 Creation 로직 변경)
	  * </pre>
	  */
	public PlanningDBDAOSearchQtaLoadRevForSectorListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sqm_mn_sctr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fnal_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ias_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOSearchQtaLoadRevForSectorListRSQL").append("\n"); 
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
		query.append("#if (${freezing_flg} == 'Y')" ).append("\n"); 
		query.append("SELECT '*'||OFC_VW_NM||'.'||RLANE_CD||'.'||DIR_CD||'.'||HUL_BND_CD||'.'||PF_GRP_CD||'.'||RHQ_CD||'.'||RGN_OFC_CD||'.'||POL_CD||'.'||POD_CD " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SELECT M1.BSE_YR" ).append("\n"); 
		query.append("        , M1.BSE_QTR_CD" ).append("\n"); 
		query.append("        , M1.OFC_VW_NM" ).append("\n"); 
		query.append("    #if (${excel_flg} != 'Y')" ).append("\n"); 
		query.append("        , M1.OFC_VW_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        , M1.TRD_CD" ).append("\n"); 
		query.append("        , M1.SUB_TRD_CD" ).append("\n"); 
		query.append("        , M1.IAS_RGN_CD" ).append("\n"); 
		query.append("        , M1.RLANE_CD" ).append("\n"); 
		query.append("        , M1.DIR_CD" ).append("\n"); 
		query.append("        , M1.HUL_BND_CD" ).append("\n"); 
		query.append("        , M1.PF_GRP_CD" ).append("\n"); 
		query.append("        , M1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("        , M1.RHQ_CD" ).append("\n"); 
		query.append("        , M1.RGN_OFC_CD" ).append("\n"); 
		query.append("        , M1.POL_CD" ).append("\n"); 
		query.append("        , M1.POD_CD" ).append("\n"); 
		query.append("        , M1.SQM_MN_SCTR_FLG" ).append("\n"); 
		query.append("        , DECODE(M1.PRE_LOD_QTY,    0,S1.PRE_LOD_QTY,     M1.PRE_LOD_QTY)     AS PRE_LOD_QTY" ).append("\n"); 
		query.append("        , DECODE(M1.PRE_GRS_RPB_REV,0,S1.PRE_GRS_RPB_REV, M1.PRE_GRS_RPB_REV) AS PRE_GRS_RPB_REV" ).append("\n"); 
		query.append("    #if (${excel_flg} == 'Y')" ).append("\n"); 
		query.append("        , NVL(DECODE(M1.PRE_LOD_QTY, 0,S1.PRE_LOD_QTY, M1.PRE_LOD_QTY), 0)* NVL(DECODE(M1.PRE_GRS_RPB_REV,0,S1.PRE_GRS_RPB_REV, M1.PRE_GRS_RPB_REV), 0)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        , M1.LOD_QTY" ).append("\n"); 
		query.append("        , M1.GRS_RPB_REV" ).append("\n"); 
		query.append("    #if (${excel_flg} == 'Y')" ).append("\n"); 
		query.append("        , M1.LOD_QTY * M1.GRS_RPB_REV" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        , M1.GID_LOD_QTY" ).append("\n"); 
		query.append("        , M1.GID_GRS_RPB_REV" ).append("\n"); 
		query.append("    #if (${excel_flg} == 'Y')" ).append("\n"); 
		query.append("        , M1.GID_LOD_QTY * M1.GID_GRS_RPB_REV" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${excel_flg} != 'Y')" ).append("\n"); 
		query.append("        , M1.USE_FLG" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("    SELECT A2.BSE_YR" ).append("\n"); 
		query.append("          ,A2.BSE_QTR_CD" ).append("\n"); 
		query.append("          ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00940' AND INTG_CD_VAL_CTNT = A2.OFC_VW_CD) AS OFC_VW_NM" ).append("\n"); 
		query.append("          ,A2.OFC_VW_CD" ).append("\n"); 
		query.append("          ,A2.TRD_CD" ).append("\n"); 
		query.append("          ,A2.SUB_TRD_CD" ).append("\n"); 
		query.append("          ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03218' AND INTG_CD_VAL_CTNT = A3.IAS_RGN_CD) AS IAS_RGN_CD" ).append("\n"); 
		query.append("          ,A2.RLANE_CD" ).append("\n"); 
		query.append("          ,A2.DIR_CD" ).append("\n"); 
		query.append("          ,DECODE(A3.HUL_BND_CD,'BH','B/H','H/H') HUL_BND_CD" ).append("\n"); 
		query.append("          ,A2.PF_GRP_CD OLD_PF_GRP_CD" ).append("\n"); 
		query.append("          , MAX(A2.PF_GRP_CD) OVER (PARTITION BY A2.RLANE_CD, A2.DIR_CD, A2.FNL_BSA_CAPA, A2.RGN_OFC_CD, A2.POL_CD, A2.POD_CD) MAX_PF_GRP_CD -- 중복 체크용" ).append("\n"); 
		query.append("          , WM_CONCAT(A2.PF_GRP_CD) OVER (PARTITION BY A2.RLANE_CD, A2.DIR_CD, A2.FNL_BSA_CAPA, A2.RGN_OFC_CD, A2.POL_CD, A2.POD_CD ORDER BY A2.PF_GRP_CD) PF_GRP_CD " ).append("\n"); 
		query.append("          ,A2.FNL_BSA_CAPA" ).append("\n"); 
		query.append("          ,A2.RHQ_CD" ).append("\n"); 
		query.append("          ,A2.RGN_OFC_CD" ).append("\n"); 
		query.append("          ,A2.POL_CD" ).append("\n"); 
		query.append("          ,A2.POD_CD" ).append("\n"); 
		query.append("          ,DECODE(NVL(A5.SQM_MN_SCTR_FLG, 'N'), 'Y', 'Main', 'N', 'Sector') SQM_MN_SCTR_FLG" ).append("\n"); 
		query.append("          , NVL(AA2.LOD_QTY, 0) PRE_LOD_QTY" ).append("\n"); 
		query.append("          , NVL(AA2.GRS_RPB_REV, 0) PRE_GRS_RPB_REV" ).append("\n"); 
		query.append("          ,A2.LOD_QTY" ).append("\n"); 
		query.append("          ,A2.GRS_RPB_REV" ).append("\n"); 
		query.append("          ,A2.GID_LOD_QTY" ).append("\n"); 
		query.append("          ,A2.GID_GRS_RPB_REV" ).append("\n"); 
		query.append("          ,DECODE(NVL(A4.PF_GRP_CD,'*'),'*','N','Y') USE_FLG " ).append("\n"); 
		query.append("          , A1.POL_CALL_SEQ" ).append("\n"); 
		query.append("          , A1.POD_CALL_SEQ" ).append("\n"); 
		query.append("          , A2.BSE_TP_CD" ).append("\n"); 
		query.append("          -- BSA RANK 순서로 전분기 데이터를 가져오기 위함" ).append("\n"); 
		query.append("          , ROW_NUMBER() OVER (PARTITION BY A2.BSE_TP_CD, A2.BSE_YR, A2.BSE_QTR_CD, A2.OFC_VW_CD, A2.RLANE_CD, A2.DIR_CD, A2.PF_GRP_CD, A2.RGN_OFC_CD, A2.POL_CD, A2.POD_CD ORDER BY A2.FNL_BSA_CAPA DESC) BSA_RANK" ).append("\n"); 
		query.append("      FROM SQM_SCTR_LANE_OFC A1" ).append("\n"); 
		query.append("          ,SQM_SCTR_LOD_REV A2" ).append("\n"); 
		query.append("          ,SQM_SCTR_LOD_REV AA2" ).append("\n"); 
		query.append("          ,MAS_LANE_RGST A3" ).append("\n"); 
		query.append("          ,(" ).append("\n"); 
		query.append("            SELECT DISTINCT BSE_TP_CD" ).append("\n"); 
		query.append("                  ,BSE_YR" ).append("\n"); 
		query.append("                  ,BSE_QTR_CD" ).append("\n"); 
		query.append("                  ,RLANE_CD" ).append("\n"); 
		query.append("                  ,PF_GRP_CD " ).append("\n"); 
		query.append("              FROM SQM_SCTR_CFM_QTA" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND QTA_RLSE_VER_NO = SUBSTR(@[f_bse_yr],-2) || DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]) || '02'" ).append("\n"); 
		query.append("               AND BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("               AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("               AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("           ) A4" ).append("\n"); 
		query.append("          ,SQM_SCTR_PAIR_MGMT A5" ).append("\n"); 
		query.append("          , (" ).append("\n"); 
		query.append("              SELECT DISTINCT TV.BSE_TP_CD, TV.BSE_YR, TV.BSE_QTR_CD, TV.RLANE_CD, TV.DIR_CD, PG.PF_GRP_CD " ).append("\n"); 
		query.append("                FROM SQM_QTA_TGT_VVD TV" ).append("\n"); 
		query.append("                   , SQM_SCTR_PF_GRP PG " ).append("\n"); 
		query.append("               WHERE TV.BSE_TP_CD    = PG.BSE_TP_CD" ).append("\n"); 
		query.append("                 AND TV.BSE_YR       = PG.BSE_YR" ).append("\n"); 
		query.append("                 AND TV.BSE_QTR_CD   = PG.BSE_QTR_CD" ).append("\n"); 
		query.append("                 AND TV.RLANE_CD     = PG.RLANE_CD" ).append("\n"); 
		query.append("                 AND TV.PF_SVC_TP_CD = PG.PF_SVC_TP_CD" ).append("\n"); 
		query.append("				UNION" ).append("\n"); 
		query.append("              SELECT DISTINCT TV.BSE_TP_CD, TV.BSE_YR, TV.BSE_QTR_CD, TV.RLANE_CD, TV.DIR_CD, PG.PF_GRP_CD " ).append("\n"); 
		query.append("                FROM SQM_SCTR_ADD_TGT_VVD TV" ).append("\n"); 
		query.append("                   , SQM_SCTR_PF_GRP PG " ).append("\n"); 
		query.append("               WHERE TV.BSE_TP_CD    = PG.BSE_TP_CD" ).append("\n"); 
		query.append("                 AND TV.BSE_YR       = PG.BSE_YR" ).append("\n"); 
		query.append("                 AND TV.BSE_QTR_CD   = PG.BSE_QTR_CD" ).append("\n"); 
		query.append("                 AND TV.RLANE_CD     = PG.RLANE_CD" ).append("\n"); 
		query.append("                 AND TV.PF_SVC_TP_CD = PG.PF_SVC_TP_CD" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("           ) A6 -- TARGET VVD.PF_SVC_TP_CD 에 존재하는 PF_GRP_CD만 거져오기 위함" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND A1.BSE_TP_CD   = A2.BSE_TP_CD" ).append("\n"); 
		query.append("       AND A1.BSE_YR      = A2.BSE_YR" ).append("\n"); 
		query.append("       AND A1.BSE_QTR_CD  = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND A1.OFC_VW_CD   = A2.OFC_VW_CD" ).append("\n"); 
		query.append("       AND A1.RLANE_CD    = A2.RLANE_CD" ).append("\n"); 
		query.append("       AND A1.DIR_CD      = A2.DIR_CD" ).append("\n"); 
		query.append("       AND A1.PF_GRP_CD   = A2.PF_GRP_CD" ).append("\n"); 
		query.append("       AND A1.RGN_OFC_CD  = A2.RGN_OFC_CD" ).append("\n"); 
		query.append("       AND A1.POL_CD      = A2.POL_CD" ).append("\n"); 
		query.append("       AND A1.POD_CD      = A2.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND AA2.BSE_TP_CD(+) = A2.BSE_TP_CD" ).append("\n"); 
		query.append("       AND AA2.BSE_YR(+)    = TO_CHAR(ADD_MONTHS(TO_DATE(A2.BSE_YR||DECODE(SUBSTR(A2.BSE_QTR_CD, 0, 1), '1', '01', '2', '04', '3', '07', '4', '10','1'),'YYYYMM'), -2), 'YYYY') -- 성능좋음       " ).append("\n"); 
		query.append("       AND AA2.BSE_QTR_CD(+)= TO_CHAR(ADD_MONTHS(TO_DATE(A2.BSE_YR||DECODE(SUBSTR(A2.BSE_QTR_CD, 0, 1), '1', '01', '2', '04', '3', '07', '4', '10','1'),'YYYYMM'), -2), 'Q')||'Q'    " ).append("\n"); 
		query.append("       AND AA2.OFC_VW_CD(+) = A2.OFC_VW_CD" ).append("\n"); 
		query.append("       AND AA2.RLANE_CD(+)  = A2.RLANE_CD" ).append("\n"); 
		query.append("       AND AA2.DIR_CD(+)    = A2.DIR_CD" ).append("\n"); 
		query.append("       AND AA2.FNL_BSA_CAPA(+) = A2.FNL_BSA_CAPA" ).append("\n"); 
		query.append("       AND AA2.PF_GRP_CD(+) = A2.PF_GRP_CD" ).append("\n"); 
		query.append("       AND AA2.RGN_OFC_CD(+)= A2.RGN_OFC_CD" ).append("\n"); 
		query.append("       AND AA2.POL_CD(+)    = A2.POL_CD" ).append("\n"); 
		query.append("       AND AA2.POD_CD(+)    = A2.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND A1.TRD_CD      = A3.TRD_CD" ).append("\n"); 
		query.append("       AND A1.RLANE_CD    = A3.RLANE_CD" ).append("\n"); 
		query.append("       AND A1.DIR_CD      = A3.DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND A1.BSE_TP_CD   = A4.BSE_TP_CD(+)" ).append("\n"); 
		query.append("       AND A1.BSE_YR      = A4.BSE_YR(+)" ).append("\n"); 
		query.append("       AND A1.BSE_QTR_CD  = A4.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("       AND A1.RLANE_CD    = A4.RLANE_CD(+)" ).append("\n"); 
		query.append("       AND A1.PF_GRP_CD   = A4.PF_GRP_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND A1.BSE_TP_CD  = A5.BSE_TP_CD" ).append("\n"); 
		query.append("       AND A1.BSE_YR     = A5.BSE_YR" ).append("\n"); 
		query.append("       AND A1.BSE_QTR_CD = A5.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND A1.RLANE_CD   = A5.RLANE_CD" ).append("\n"); 
		query.append("       AND A1.DIR_CD     = A5.DIR_CD" ).append("\n"); 
		query.append("       AND A1.PF_GRP_CD  = A5.PF_GRP_CD" ).append("\n"); 
		query.append("       AND A1.POL_CD     = A5.POL_CD" ).append("\n"); 
		query.append("       AND A1.POD_CD     = A5.POD_CD" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("       AND A1.BSE_TP_CD     = A6.BSE_TP_CD" ).append("\n"); 
		query.append("       AND A1.BSE_YR        = A6.BSE_YR" ).append("\n"); 
		query.append("       AND A1.BSE_QTR_CD    = A6.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND A1.RLANE_CD      = A6.RLANE_CD" ).append("\n"); 
		query.append("       AND A1.DIR_CD        = A6.DIR_CD" ).append("\n"); 
		query.append("       AND A1.PF_GRP_CD     = A6.PF_GRP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND A3.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("       AND A1.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("       AND A2.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("       AND A2.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("       AND A2.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("    #if (${excel_flg} != 'Y')" ).append("\n"); 
		query.append("       AND A2.OFC_VW_CD   = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("       AND A2.SUB_TRD_CD  = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')" ).append("\n"); 
		query.append("       AND A3.IAS_RGN_CD  = @[f_ias_rgn_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("       AND A2.RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_click} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("       AND A2.DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_click} == 'on' && ${f_hul_bnd_cd} != '' && ${f_hul_bnd_cd} != 'All')" ).append("\n"); 
		query.append("       AND A3.HUL_BND_CD  = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("       AND A2.RHQ_CD      = @[f_rhq_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("       AND A2.RGN_OFC_CD  = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_pf_grp_cd} != '' && ${f_pf_grp_cd} != 'All')" ).append("\n"); 
		query.append("       AND A2.PF_GRP_CD   = @[f_pf_grp_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_fnal_bsa_capa} != '' && ${f_fnal_bsa_capa} != 'All')" ).append("\n"); 
		query.append("       AND A2.FNL_BSA_CAPA= @[f_fnal_bsa_capa]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')" ).append("\n"); 
		query.append("       AND A2.POL_CD      = @[f_pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')" ).append("\n"); 
		query.append("       AND A2.POD_CD      = @[f_pod_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_sqm_mn_sctr_flg} != '' && ${f_sqm_mn_sctr_flg} != 'All')" ).append("\n"); 
		query.append("       AND NVL(A5.SQM_MN_SCTR_FLG, 'N') = @[f_sqm_mn_sctr_flg]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       and rownum < 100000000 -- 조회 속도 향상을 위해 넣음. 넣으면 훨씬 빨라짐." ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ) M1" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("         SELECT BSE_TP_CD" ).append("\n"); 
		query.append("              , @[f_bse_yr] BSE_YR" ).append("\n"); 
		query.append("              , DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]) BSE_QTR_CD" ).append("\n"); 
		query.append("              , OFC_VW_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("              , PF_GRP_CD" ).append("\n"); 
		query.append("              , RGN_OFC_CD" ).append("\n"); 
		query.append("              , POL_CD" ).append("\n"); 
		query.append("              , POD_CD" ).append("\n"); 
		query.append("              , LOD_QTY AS PRE_LOD_QTY" ).append("\n"); 
		query.append("              , GRS_RPB_REV AS PRE_GRS_RPB_REV" ).append("\n"); 
		query.append("              , ROW_NUMBER() OVER (PARTITION BY BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, RLANE_CD, DIR_CD, PF_GRP_CD, RGN_OFC_CD, POL_CD, POD_CD ORDER BY FNL_BSA_CAPA DESC) BSA_RANK" ).append("\n"); 
		query.append("              , COUNT(*) OVER (PARTITION BY BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, RLANE_CD, DIR_CD, PF_GRP_CD, RGN_OFC_CD, POL_CD, POD_CD ) MAX_BSA_RANK" ).append("\n"); 
		query.append("           FROM SQM_SCTR_LOD_REV R1" ).append("\n"); 
		query.append("          WHERE BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("            AND BSE_YR    = TO_CHAR(ADD_MONTHS(TO_DATE(@[f_bse_yr]||DECODE(SUBSTR(DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]), 0, 1), '1', '01', '2', '04', '3', '07', '4', '10','1'), 'YYYYMM'), -2), 'YYYY')" ).append("\n"); 
		query.append("            AND BSE_QTR_CD= TO_CHAR(ADD_MONTHS(TO_DATE(@[f_bse_yr]||DECODE(SUBSTR(DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]), 0, 1), '1', '01', '2','04', '3', '07', '4', '10', '1'), 'YYYYMM'), -2), 'Q')||'Q'" ).append("\n"); 
		query.append("           #if (${excel_flg} != 'Y')" ).append("\n"); 
		query.append("            AND OFC_VW_CD   = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("            AND SUB_TRD_CD  = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("            AND RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${f_click} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("            AND DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("            AND RHQ_CD      = @[f_rhq_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("            AND RGN_OFC_CD  = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${f_pf_grp_cd} != '' && ${f_pf_grp_cd} != 'All')" ).append("\n"); 
		query.append("            AND PF_GRP_CD   = @[f_pf_grp_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${f_fnal_bsa_capa} != '' && ${f_fnal_bsa_capa} != 'All')" ).append("\n"); 
		query.append("            AND FNL_BSA_CAPA= @[f_fnal_bsa_capa]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')" ).append("\n"); 
		query.append("            AND POL_CD      = @[f_pol_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')" ).append("\n"); 
		query.append("            AND POD_CD      = @[f_pod_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("         -- FNL_BSA_CAPA기준으로 가장작은 숫자에 해당하는 RANK에 10개를 만들어준다. 지난 분기보다 현재분기에 FNL_BSA_CAPA 갯수가 더 많을 수 있으므로" ).append("\n"); 
		query.append("         SELECT A.BSE_TP_CD" ).append("\n"); 
		query.append("              , A.BSE_YR" ).append("\n"); 
		query.append("              , A.BSE_QTR_CD" ).append("\n"); 
		query.append("              , A.OFC_VW_CD" ).append("\n"); 
		query.append("              , A.RLANE_CD" ).append("\n"); 
		query.append("              , A.DIR_CD" ).append("\n"); 
		query.append("              , A.PF_GRP_CD" ).append("\n"); 
		query.append("              , A.RGN_OFC_CD" ).append("\n"); 
		query.append("              , A.POL_CD" ).append("\n"); 
		query.append("              , A.POD_CD" ).append("\n"); 
		query.append("              , A.PRE_LOD_QTY" ).append("\n"); 
		query.append("              , A.PRE_GRS_RPB_REV" ).append("\n"); 
		query.append("              , B.BSA_RANK + A.MAX_BSA_RANK AS BSA_RANK" ).append("\n"); 
		query.append("              , A.MAX_BSA_RANK" ).append("\n"); 
		query.append("           FROM" ).append("\n"); 
		query.append("                (SELECT BSE_TP_CD" ).append("\n"); 
		query.append("                      , @[f_bse_yr] BSE_YR" ).append("\n"); 
		query.append("                      , DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]) BSE_QTR_CD" ).append("\n"); 
		query.append("                      , OFC_VW_CD" ).append("\n"); 
		query.append("                      , RLANE_CD" ).append("\n"); 
		query.append("                      , DIR_CD" ).append("\n"); 
		query.append("                      , PF_GRP_CD" ).append("\n"); 
		query.append("                      , RGN_OFC_CD" ).append("\n"); 
		query.append("                      , POL_CD" ).append("\n"); 
		query.append("                      , POD_CD" ).append("\n"); 
		query.append("                      , MAX(LOD_QTY) KEEP (DENSE_RANK LAST ORDER BY FNL_BSA_CAPA) AS PRE_LOD_QTY -- FNL_BSA_CAPA 기준으로 가장 큰숫자부터 RANK 정렬" ).append("\n"); 
		query.append("                      , MAX(GRS_RPB_REV) KEEP (DENSE_RANK LAST ORDER BY FNL_BSA_CAPA) AS PRE_GRS_RPB_REV" ).append("\n"); 
		query.append("                      , COUNT(*) AS MAX_BSA_RANK" ).append("\n"); 
		query.append("                   FROM SQM_SCTR_LOD_REV R1" ).append("\n"); 
		query.append("                  WHERE BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                    AND BSE_YR    = TO_CHAR(ADD_MONTHS(TO_DATE(@[f_bse_yr]||DECODE(SUBSTR(DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]), 0, 1), '1', '01', '2', '04', '3', '07', '4', '10','1'), 'YYYYMM'), -2), 'YYYY')" ).append("\n"); 
		query.append("                    AND BSE_QTR_CD= TO_CHAR(ADD_MONTHS(TO_DATE(@[f_bse_yr]||DECODE(SUBSTR(DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]), 0, 1), '1', '01', '2','04', '3', '07', '4', '10', '1'), 'YYYYMM'), -2), 'Q')||'Q'" ).append("\n"); 
		query.append("                   #if (${excel_flg} != 'Y')" ).append("\n"); 
		query.append("                    AND OFC_VW_CD   = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("                    AND SUB_TRD_CD  = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                    AND RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${f_click} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                    AND DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("                    AND RHQ_CD      = @[f_rhq_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("                    AND RGN_OFC_CD  = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${f_pf_grp_cd} != '' && ${f_pf_grp_cd} != 'All')" ).append("\n"); 
		query.append("                    AND PF_GRP_CD   = @[f_pf_grp_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${f_fnal_bsa_capa} != '' && ${f_fnal_bsa_capa} != 'All')" ).append("\n"); 
		query.append("                    AND FNL_BSA_CAPA= @[f_fnal_bsa_capa]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')" ).append("\n"); 
		query.append("                    AND POL_CD      = @[f_pol_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')" ).append("\n"); 
		query.append("                    AND POD_CD      = @[f_pod_cd]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("               GROUP BY BSE_TP_CD" ).append("\n"); 
		query.append("                      , BSE_YR" ).append("\n"); 
		query.append("                      , BSE_QTR_CD" ).append("\n"); 
		query.append("                      , OFC_VW_CD" ).append("\n"); 
		query.append("                      , RLANE_CD" ).append("\n"); 
		query.append("                      , DIR_CD" ).append("\n"); 
		query.append("                      , PF_GRP_CD" ).append("\n"); 
		query.append("                      , RGN_OFC_CD" ).append("\n"); 
		query.append("                      , POL_CD" ).append("\n"); 
		query.append("                      , POD_CD" ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("              , (SELECT LEVEL AS BSA_RANK FROM DUAL CONNECT BY LEVEL < 10) B" ).append("\n"); 
		query.append("        ) S1" ).append("\n"); 
		query.append("    WHERE M1.OLD_PF_GRP_CD = M1.MAX_PF_GRP_CD" ).append("\n"); 
		query.append("      AND S1.BSE_TP_CD(+)  = M1.BSE_TP_CD" ).append("\n"); 
		query.append("      AND S1.BSE_YR(+)     = M1.BSE_YR" ).append("\n"); 
		query.append("      AND S1.BSE_QTR_CD(+) = M1.BSE_QTR_CD" ).append("\n"); 
		query.append("      AND S1.OFC_VW_CD(+)  = M1.OFC_VW_CD" ).append("\n"); 
		query.append("      AND S1.RLANE_CD(+)   = M1.RLANE_CD" ).append("\n"); 
		query.append("      AND S1.DIR_CD(+)     = M1.DIR_CD" ).append("\n"); 
		query.append("      AND S1.PF_GRP_CD(+)  = M1.PF_GRP_CD" ).append("\n"); 
		query.append("      AND S1.BSA_RANK(+)   = M1.BSA_RANK" ).append("\n"); 
		query.append("      AND S1.RGN_OFC_CD(+) = M1.RGN_OFC_CD" ).append("\n"); 
		query.append("      AND S1.POL_CD(+)     = M1.POL_CD" ).append("\n"); 
		query.append("      AND S1.POD_CD(+)     = M1.POD_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append(" ORDER BY M1.BSE_YR" ).append("\n"); 
		query.append("        , M1.BSE_QTR_CD" ).append("\n"); 
		query.append("        , M1.OFC_VW_CD" ).append("\n"); 
		query.append("        , M1.TRD_CD" ).append("\n"); 
		query.append("        , M1.SUB_TRD_CD" ).append("\n"); 
		query.append("        , M1.IAS_RGN_CD" ).append("\n"); 
		query.append("        , M1.RLANE_CD" ).append("\n"); 
		query.append("        , M1.DIR_CD" ).append("\n"); 
		query.append("        , M1.HUL_BND_CD" ).append("\n"); 
		query.append("        , M1.PF_GRP_CD" ).append("\n"); 
		query.append("        , M1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("        , M1.RHQ_CD" ).append("\n"); 
		query.append("        , M1.RGN_OFC_CD" ).append("\n"); 
		query.append("        , M1.POL_CD" ).append("\n"); 
		query.append("        , M1.POL_CALL_SEQ" ).append("\n"); 
		query.append("        , M1.POD_CD" ).append("\n"); 
		query.append("        , M1.POD_CALL_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${freezing_flg} == 'Y')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE LOD_QTY != 0" ).append("\n"); 
		query.append("AND GRS_RPB_REV = 0" ).append("\n"); 
		query.append("ORDER BY OFC_VW_NM DESC,RLANE_CD, DIR_CD, HUL_BND_CD, PF_GRP_CD, RHQ_CD, RGN_OFC_CD, POL_CD, POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경" ).append("\n"); 
		query.append("* 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청" ).append("\n"); 
		query.append("* 2015.09.02 김용습 [CHM-201537817] [CSR 전환건] QTA Set up by Head Office for IAS Sector 화면 조회 속도 업그레이드 요청" ).append("\n"); 
		query.append("* 2015.09.17 김용습 [CHM-201537764] [CSR 전환건] QTA Set up by Head Office for IAS Sector 화면 내 Raw Data Export 버튼 신규 생성 " ).append("\n"); 
		query.append("* 2015.09.22 김용습 [CHM-201537819] [CSR 전환건] QTA Set up by Head Office for IAS Sector 화면 내 Freezing, Add-Freezing 버튼 Validation 추가" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}