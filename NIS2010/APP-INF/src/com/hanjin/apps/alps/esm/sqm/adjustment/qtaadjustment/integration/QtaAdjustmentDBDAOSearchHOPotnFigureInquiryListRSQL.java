/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchHOPotnFigureInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
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

public class QtaAdjustmentDBDAOSearchHOPotnFigureInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Portion Adjustment by H/O 내 Figure Inquiry팝업을 조회한다.
	  * 
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * * 2015.08.20 김용습 [CHM-201536994] Split24-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * 20160422 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchHOPotnFigureInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mas_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_gubun",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_conv_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_dir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchHOPotnFigureInquiryListRSQL").append("\n"); 
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
		query.append("-- SQM_CNG_TP_CD <> 'I' 에 대해서 조회(그리드에 회색으로 표시)" ).append("\n"); 
		query.append("         SELECT A1.BSE_YR" ).append("\n"); 
		query.append("               ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("               ,DECODE(A2.OFC_VW_CD, 'C', 'Contract', 'L', 'Loading') AS OFC_VW_CD" ).append("\n"); 
		query.append("               ,A1.TRD_CD" ).append("\n"); 
		query.append("               ,A1.RLANE_CD" ).append("\n"); 
		query.append("               ,A1.DIR_CD" ).append("\n"); 
		query.append("               ,A2.CONV_DIR_CD" ).append("\n"); 
		query.append("               ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("               ,SUBSTR(A4.HUL_BND_CD,0,1) || '/' || SUBSTR(A4.HUL_BND_CD, -1) AS HUL_BND_CD" ).append("\n"); 
		query.append("               ,DECODE(A3.OB_DIV_CD, 'N', 'N.OB', 'O', 'OB') AS OB_DIV_CD" ).append("\n"); 
		query.append("               ,A1.BSE_WK" ).append("\n"); 
		query.append("               ,A1.VSL_CD || A1.SKD_VOY_NO || A1.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("               ,A2.RHQ_CD" ).append("\n"); 
		query.append("#if (${f_gubun} == 'HO')" ).append("\n"); 
		query.append("               ,0 AS LOD_POTN_RTO" ).append("\n"); 
		query.append("               ,0 AS REV_POTN_RTO" ).append("\n"); 
		query.append("               ,SUM(A2.LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("               ,ROUND(SUM(A2.LOD_QTY * A2.GRS_RPB_REV)) AS GRS_REV" ).append("\n"); 
		query.append("#elseif (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("               ,A2.RGN_OFC_CD" ).append("\n"); 
		query.append("               ,0 AS LOD_POTN_RTO" ).append("\n"); 
		query.append("               ,0 AS REV_POTN_RTO" ).append("\n"); 
		query.append("               ,A2.LOD_QTY AS LOD_QTY" ).append("\n"); 
		query.append("               ,ROUND(A2.LOD_QTY * A2.GRS_RPB_REV) AS GRS_REV" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               ,A2.SQM_CNG_TP_CD" ).append("\n"); 
		query.append("               ,@[f_gubun] AS GUBUN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           FROM SQM_CFM_TGT_VVD   A1" ).append("\n"); 
		query.append("               ,SQM_CFM_QTA       A2" ).append("\n"); 
		query.append("               ,SQM_DAT_RLT       A3" ).append("\n"); 
		query.append("               ,MAS_LANE_RGST     A4" ).append("\n"); 
		query.append("               ,SQM_QTA_LANE_MGMT A5" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("            AND A1.QTA_RLSE_VER_NO = A2.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("            AND A1.BSE_TP_CD     = A2.BSE_TP_CD" ).append("\n"); 
		query.append("            AND A1.BSE_YR        = A2.BSE_YR" ).append("\n"); 
		query.append("            AND A1.BSE_QTR_CD    = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND A1.TRD_CD        = A2.TRD_CD" ).append("\n"); 
		query.append("            AND A1.RLANE_CD      = A2.RLANE_CD" ).append("\n"); 
		query.append("            AND A1.DIR_CD        = A2.DIR_CD" ).append("\n"); 
		query.append("            AND A1.VSL_CD        = A2.VSL_CD" ).append("\n"); 
		query.append("            AND A1.SKD_VOY_NO    = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND A1.SKD_DIR_CD    = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND A2.BSE_TP_CD     = A3.BSE_TP_CD" ).append("\n"); 
		query.append("            AND A2.BSE_YR        = A3.BSE_YR" ).append("\n"); 
		query.append("            AND A2.BSE_QTR_CD    = A3.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND A2.OFC_VW_CD     = A3.OFC_VW_CD" ).append("\n"); 
		query.append("            AND A2.TRD_CD        = A3.TRD_CD" ).append("\n"); 
		query.append("            AND A2.RLANE_CD      = DECODE(UPPER(A3.RLANE_CD),'ALL',A2.RLANE_CD, A3.RLANE_CD)" ).append("\n"); 
		query.append("            AND A2.CONV_DIR_CD   = A3.CONV_DIR_CD" ).append("\n"); 
		query.append("            AND DECODE(A2.BSE_YR||A2.BSE_QTR_CD, '20141Q', DECODE(A2.RGN_OFC_CD, 'SELSC', 'SELIB', 'TYOSC', 'TYOIB', A2.RHQ_CD), A2.RHQ_CD) = A3.RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND A1.RLANE_CD      = A4.RLANE_CD" ).append("\n"); 
		query.append("            AND A1.DIR_CD        = A4.DIR_CD" ).append("\n"); 
		query.append("            AND A1.TRD_CD        = A4.TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND A1.RLANE_CD      = A5.RLANE_CD" ).append("\n"); 
		query.append("            AND A1.TRD_CD        = A5.TRD_CD" ).append("\n"); 
		query.append("--            AND A5.IAS_SCTR_FLG IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND A2.SQM_CNG_TP_CD <> 'I'" ).append("\n"); 
		query.append("            AND A1.QTA_RLSE_VER_NO = (SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                        FROM SQM_QTA_RLSE_VER" ).append("\n"); 
		query.append("                                       WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                         AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                                         AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                                         AND SQM_VER_STS_CD = 'R'" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("            AND A1.BSE_TP_CD     = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("            AND A1.BSE_YR        = @[f_bse_yr]" ).append("\n"); 
		query.append("            AND A1.BSE_QTR_CD    = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_gubun} == 'HO')" ).append("\n"); 
		query.append("            AND A3.TEAM_CD       = (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN A3.TEAM_CD" ).append("\n"); 
		query.append("                                                ELSE @[ofc_cd]" ).append("\n"); 
		query.append("                                           END TEAM_CD" ).append("\n"); 
		query.append("                                      FROM DUAL)" ).append("\n"); 
		query.append("#elseif (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("            AND A3.RHQ_CD        = (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN A3.RHQ_CD" ).append("\n"); 
		query.append("                                                ELSE @[ofc_cd]" ).append("\n"); 
		query.append("                                           END RHQ_CD" ).append("\n"); 
		query.append("                                    FROM DUAL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ofc_vw_cd} != '' && ${f_ofc_vw_cd} != 'All')" ).append("\n"); 
		query.append("            AND A2.OFC_VW_CD     = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("            AND A1.TRD_CD        = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("            AND A1.RLANE_CD      IN (${f_rlane_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("            AND A1.DIR_CD        = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_conv_dir_cd} != '' && ${f_conv_dir_cd} != 'All')" ).append("\n"); 
		query.append("            AND A1.CONV_DIR_CD   = @[f_conv_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} == 'on' && ${f_trd_dir} != '' && ${f_trd_dir} != 'All')" ).append("\n"); 
		query.append("            AND A4.HUL_BND_CD    = @[f_trd_dir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_gubun} == 'HO')" ).append("\n"); 
		query.append("      GROUP BY " ).append("\n"); 
		query.append("                A1.BSE_YR" ).append("\n"); 
		query.append("               ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("               ,DECODE(A2.OFC_VW_CD, 'C', 'Contract', 'L', 'Loading') " ).append("\n"); 
		query.append("               ,A1.TRD_CD" ).append("\n"); 
		query.append("               ,A1.RLANE_CD" ).append("\n"); 
		query.append("               ,A1.DIR_CD" ).append("\n"); 
		query.append("               ,A2.CONV_DIR_CD" ).append("\n"); 
		query.append("               ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("               ,SUBSTR(A4.HUL_BND_CD,0,1) || '/' || SUBSTR(A4.HUL_BND_CD, -1) " ).append("\n"); 
		query.append("               ,DECODE(A3.OB_DIV_CD, 'N', 'N.OB', 'O', 'OB') " ).append("\n"); 
		query.append("               ,A1.BSE_WK" ).append("\n"); 
		query.append("               ,A1.VSL_CD || A1.SKD_VOY_NO || A1.SKD_DIR_CD " ).append("\n"); 
		query.append("               ,A2.RHQ_CD" ).append("\n"); 
		query.append("               ,A2.SQM_CNG_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- SQM_CNG_TP_CD = 'I' 에 대해서 조회" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       T.BSE_YR" ).append("\n"); 
		query.append("      ,T.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,DECODE(T.OFC_VW_CD, 'C', 'Contract', 'L', 'Loading') AS OFC_VW_CD" ).append("\n"); 
		query.append("      ,T.TRD_CD" ).append("\n"); 
		query.append("      ,T.RLANE_CD" ).append("\n"); 
		query.append("      ,T.DIR_CD" ).append("\n"); 
		query.append("      ,T.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,T.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(T.HUL_BND_CD,0,1) || '/' || SUBSTR(T.HUL_BND_CD, -1) AS HUL_BND_CD" ).append("\n"); 
		query.append("      ,DECODE(T.OB_DIV_CD, 'N', 'N.OB', 'O', 'OB') AS OB_DIV_CD" ).append("\n"); 
		query.append("      ,T.BSE_WK" ).append("\n"); 
		query.append("      ,T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,T.RHQ_CD" ).append("\n"); 
		query.append("      ,T.RHQ_LOD_RTO * 100 AS LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,T.RHQ_REV_RTO * 100 AS REV_POTN_RTO" ).append("\n"); 
		query.append("      ,T.RHQ_QTY           AS LOD_QTY" ).append("\n"); 
		query.append("      ,T.RHQ_REV           AS GRS_REV" ).append("\n"); 
		query.append("      ,T.SQM_CNG_TP_CD" ).append("\n"); 
		query.append("      ,@[f_gubun] AS GUBUN" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT SUBSTR(C1.BSE_YR,-2)||C1.BSE_QTR_CD||'02' AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("            ,C1.BSE_TP_CD" ).append("\n"); 
		query.append("            ,C1.BSE_YR" ).append("\n"); 
		query.append("            ,C1.BSE_QTR_CD" ).append("\n"); 
		query.append("            ,C1.OFC_VW_CD" ).append("\n"); 
		query.append("            ,C1.QTA_TGT_CD" ).append("\n"); 
		query.append("            ,C1.TRD_CD" ).append("\n"); 
		query.append("            ,C1.RLANE_CD" ).append("\n"); 
		query.append("            ,C1.DIR_CD" ).append("\n"); 
		query.append("            ,C1.CONV_DIR_CD" ).append("\n"); 
		query.append("            ,C1.SUB_TRD_CD" ).append("\n"); 
		query.append("            ,C1.HUL_BND_CD" ).append("\n"); 
		query.append("            ,C1.OB_DIV_CD" ).append("\n"); 
		query.append("            ,C1.BSE_WK" ).append("\n"); 
		query.append("            ,C1.VSL_CD" ).append("\n"); 
		query.append("            ,C1.SKD_VOY_NO" ).append("\n"); 
		query.append("            ,C1.SKD_DIR_CD" ).append("\n"); 
		query.append("            ,C1.RHQ_CD" ).append("\n"); 
		query.append("    --      ,C1.LOAD_RNK AS RHQ_RNK" ).append("\n"); 
		query.append("            ,C1.RHQ_LOD_RTO" ).append("\n"); 
		query.append("            ,C1.RHQ_REV_RTO" ).append("\n"); 
		query.append("            ,DECODE(C1.LOAD_RNK, '1', C1.RHQ_QTY + (C1.ORG_VVD_BSA - C1.SUM_RHQ_QTY), C1.RHQ_QTY) AS RHQ_QTY" ).append("\n"); 
		query.append("    --        ,DECODE(C1.LOAD_RNK, '1', C1.RHQ_REV + (C1.ORG_VVD_REV - C1.SUM_RHQ_REV), C1.RHQ_REV) AS RHQ_REV" ).append("\n"); 
		query.append("            ,C1.GRS_REV * C1.RHQ_REV_RTO AS RHQ_REV" ).append("\n"); 
		query.append("            ,'I'  AS SQM_CNG_TP_CD" ).append("\n"); 
		query.append("            ,@[f_gubun] AS GUBUN" ).append("\n"); 
		query.append("    --      ,C1.RHQ_REV_RTO" ).append("\n"); 
		query.append("    --      ,C1.RHQ_LOD_RTO" ).append("\n"); 
		query.append("    --      ,C1.ORG_VVD_BSA AS ORG_LOD" ).append("\n"); 
		query.append("    --      ,C1.ORG_VVD_REV AS ORG_REV" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("             SELECT B2.BSE_TP_CD" ).append("\n"); 
		query.append("                   ,B2.BSE_YR" ).append("\n"); 
		query.append("                   ,B2.BSE_QTR_CD" ).append("\n"); 
		query.append("                   ,B2.OFC_VW_CD" ).append("\n"); 
		query.append("                   ,B2.QTA_TGT_CD" ).append("\n"); 
		query.append("                   ,B2.TRD_CD" ).append("\n"); 
		query.append("                   ,B2.SUB_TRD_CD" ).append("\n"); 
		query.append("                   ,B2.HUL_BND_CD" ).append("\n"); 
		query.append("                   ,B2.OB_DIV_CD" ).append("\n"); 
		query.append("                   ,B2.FNL_BSA_CAPA                                                           " ).append("\n"); 
		query.append("                   ,B2.RLANE_CD" ).append("\n"); 
		query.append("                   ,B2.CONV_DIR_CD" ).append("\n"); 
		query.append("                   ,B2.DIR_CD" ).append("\n"); 
		query.append("                   ,B2.BSE_WK" ).append("\n"); 
		query.append("                   ,SUBSTR(B1.APLY_FM_YRWK,-2) AS APLY_FM_WK" ).append("\n"); 
		query.append("                   ,SUBSTR(B1.APLY_TO_YRWK,-2) AS APLY_TO_WK" ).append("\n"); 
		query.append("                   ,B2.VSL_CD" ).append("\n"); 
		query.append("                   ,B2.SKD_VOY_NO" ).append("\n"); 
		query.append("                   ,B2.SKD_DIR_CD" ).append("\n"); 
		query.append("                   ,B2.RHQ_CD" ).append("\n"); 
		query.append("                   ,NVL(B1.LOD_POTN_RTO,B2.RHQ_LOD_RTO) /100 AS RHQ_LOD_RTO" ).append("\n"); 
		query.append("                   ,NVL(B1.REV_POTN_RTO,B2.RHQ_REV_RTO) /100 AS RHQ_REV_RTO" ).append("\n"); 
		query.append("                   --RHQ 별 REV 구하기" ).append("\n"); 
		query.append("                   ,B2.GRS_REV" ).append("\n"); 
		query.append("    --               ,B2.GRS_REV AS ORG_VVD_REV" ).append("\n"); 
		query.append("    --               ,ROUND(B2.GRS_REV * NVL(NVL(B1.REV_POTN_RTO,B2.RHQ_REV_RTO),0)/100, 0) AS RHQ_REV" ).append("\n"); 
		query.append("    --               ,SUM(ROUND(B2.GRS_REV * NVL(NVL(B1.REV_POTN_RTO,B2.RHQ_REV_RTO),0)/100, 0)) OVER (PARTITION BY B2.OFC_VW_CD,B2.TRD_CD,B2.RLANE_CD,B2.CONV_DIR_CD,B2.VSL_CD || B2.SKD_VOY_NO || B2.SKD_DIR_CD) AS SUM_RHQ_REV" ).append("\n"); 
		query.append("                   -- RHQ 별 LOAD을 구하기" ).append("\n"); 
		query.append("                   ,B2.LOD_QTY AS ORG_VVD_BSA" ).append("\n"); 
		query.append("                   ,ROUND(B2.LOD_QTY * NVL(NVL(B1.LOD_POTN_RTO,B2.RHQ_LOD_RTO),0)/100, 0) AS RHQ_QTY" ).append("\n"); 
		query.append("                   ,SUM(ROUND(B2.LOD_QTY * NVL(NVL(B1.LOD_POTN_RTO,B2.RHQ_LOD_RTO),0)/100, 0)) OVER (PARTITION BY B2.OFC_VW_CD,B2.TRD_CD,B2.RLANE_CD,B2.CONV_DIR_CD,B2.VSL_CD || B2.SKD_VOY_NO || B2.SKD_DIR_CD) AS SUM_RHQ_QTY" ).append("\n"); 
		query.append("                   ,ROW_NUMBER() OVER (PARTITION BY B2.OFC_VW_CD,B2.TRD_CD,B2.RLANE_CD,B2.CONV_DIR_CD,B2.VSL_CD || B2.SKD_VOY_NO || B2.SKD_DIR_CD ORDER BY NVL(B1.LOD_POTN_RTO,B2.RHQ_LOD_RTO) DESC, B1.RHQ_CD) LOAD_RNK" ).append("\n"); 
		query.append("               FROM SQM_CFM_QTA_POTN_MGMT B1" ).append("\n"); 
		query.append("                   ,(" ).append("\n"); 
		query.append("                     SELECT DISTINCT " ).append("\n"); 
		query.append("                            A1.BSE_TP_CD" ).append("\n"); 
		query.append("                           ,A1.BSE_YR" ).append("\n"); 
		query.append("                           ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("                           ,A5.OFC_VW_CD" ).append("\n"); 
		query.append("                           ,NVL(A2.QTA_STEP_CD, '02') AS QTA_STEP_CD" ).append("\n"); 
		query.append("                           ,A1.TRD_CD" ).append("\n"); 
		query.append("                           ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                           ,A1.RLANE_CD" ).append("\n"); 
		query.append("                           ,A4.HUL_BND_CD" ).append("\n"); 
		query.append("                           ,A3.OB_DIV_CD" ).append("\n"); 
		query.append("                           ,A1.FNL_BSA_CAPA " ).append("\n"); 
		query.append("                           ,A1.CONV_DIR_CD" ).append("\n"); 
		query.append("                           ,A1.DIR_CD" ).append("\n"); 
		query.append("                           ,A1.BSE_WK" ).append("\n"); 
		query.append("                           ,A1.VSL_CD" ).append("\n"); 
		query.append("                           ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                           ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("                           ,A5.RHQ_CD" ).append("\n"); 
		query.append("                           ,NVL(A2.LOD_POTN_RTO, 0) AS RHQ_LOD_RTO" ).append("\n"); 
		query.append("                           ,NVL(A2.REV_POTN_RTO, 0) AS RHQ_REV_RTO" ).append("\n"); 
		query.append("                           ,A1.GRS_REV" ).append("\n"); 
		query.append("                           ,A1.LOD_QTY" ).append("\n"); 
		query.append("                           ,A1.QTA_TGT_CD" ).append("\n"); 
		query.append("                       FROM SQM_CFM_TGT_VVD     A1" ).append("\n"); 
		query.append("                           ,SQM_QTA_POTN_MGMT   A2" ).append("\n"); 
		query.append("                           ,SQM_DAT_RLT         A3" ).append("\n"); 
		query.append("                           ,MAS_LANE_RGST       A4" ).append("\n"); 
		query.append("                           ,SQM_QTA_LANE_OFC    A5" ).append("\n"); 
		query.append("                           ,SQM_QTA_LANE_MGMT   A6" ).append("\n"); 
		query.append("                      WHERE 1=1" ).append("\n"); 
		query.append("                        AND A1.BSE_TP_CD     = A5.BSE_TP_CD" ).append("\n"); 
		query.append("                        AND A1.BSE_YR        = A5.BSE_YR" ).append("\n"); 
		query.append("                        AND A1.BSE_QTR_CD    = A5.BSE_QTR_CD" ).append("\n"); 
		query.append("                        AND A1.TRD_CD        = A5.TRD_CD" ).append("\n"); 
		query.append("                        AND A1.RLANE_CD      = A5.RLANE_CD" ).append("\n"); 
		query.append("                        AND A1.DIR_CD        = A5.DIR_CD" ).append("\n"); 
		query.append("                        AND A5.SQM_ACT_FLG   = 'Y'" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        AND A5.BSE_TP_CD     = A2.BSE_TP_CD(+)" ).append("\n"); 
		query.append("                        AND A5.BSE_YR        = A2.BSE_YR(+)" ).append("\n"); 
		query.append("                        AND A5.BSE_QTR_CD    = A2.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("                        AND A5.OFC_VW_CD     = A2.OFC_VW_CD(+)" ).append("\n"); 
		query.append("                        AND A5.TRD_CD        = A2.TRD_CD(+)" ).append("\n"); 
		query.append("                        AND A5.RLANE_CD      = A2.RLANE_CD(+)" ).append("\n"); 
		query.append("                        AND A5.DIR_CD        = A2.DIR_CD(+)" ).append("\n"); 
		query.append("                        AND A5.RHQ_CD        = A2.RHQ_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        AND A5.BSE_TP_CD     = A3.BSE_TP_CD" ).append("\n"); 
		query.append("                        AND A5.BSE_YR        = A3.BSE_YR" ).append("\n"); 
		query.append("                        AND A5.BSE_QTR_CD    = A3.BSE_QTR_CD" ).append("\n"); 
		query.append("                        AND A5.OFC_VW_CD     = A3.OFC_VW_CD" ).append("\n"); 
		query.append("                        AND A5.TRD_CD        = A3.TRD_CD" ).append("\n"); 
		query.append("                        AND A5.RLANE_CD      = DECODE(UPPER(A3.RLANE_CD),'ALL',A5.RLANE_CD, A3.RLANE_CD)" ).append("\n"); 
		query.append("                        AND A1.CONV_DIR_CD   = A3.CONV_DIR_CD" ).append("\n"); 
		query.append("                        AND A5.RHQ_CD        = A3.RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        AND A1.RLANE_CD      = A4.RLANE_CD" ).append("\n"); 
		query.append("                        AND A1.DIR_CD        = A4.DIR_CD" ).append("\n"); 
		query.append("                        AND A1.TRD_CD        = A4.TRD_CD" ).append("\n"); 
		query.append("                        AND A1.IOC_CD        = A4.IOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        AND A1.RLANE_CD      = A6.RLANE_CD" ).append("\n"); 
		query.append("                        AND A1.TRD_CD        = A6.TRD_CD" ).append("\n"); 
		query.append("--                        AND A6.IAS_SCTR_FLG IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        AND A1.QTA_RLSE_VER_NO = (SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                                    FROM SQM_QTA_RLSE_VER" ).append("\n"); 
		query.append("                                                   WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                                     AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                                                     AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                                                     AND SQM_VER_STS_CD = 'R'" ).append("\n"); 
		query.append("                                                  )" ).append("\n"); 
		query.append("                        AND A1.BSE_TP_CD     = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                        AND A1.BSE_YR        = @[f_bse_yr]" ).append("\n"); 
		query.append("                        AND A1.BSE_QTR_CD    = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                        AND A2.QTA_STEP_CD(+)= '02'" ).append("\n"); 
		query.append("                        AND A3.TEAM_CD       = (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN A3.TEAM_CD" ).append("\n"); 
		query.append("                                                            ELSE @[ofc_cd]" ).append("\n"); 
		query.append("                                                       END TEAM_CD" ).append("\n"); 
		query.append("                                                FROM DUAL)" ).append("\n"); 
		query.append("#if (${f_ofc_vw_cd} != '' && ${f_ofc_vw_cd} != 'All')" ).append("\n"); 
		query.append("                        AND A5.OFC_VW_CD     = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        AND A1.QTA_TGT_CD    = 'D'" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                        AND A1.TRD_CD        = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '' && ${rlane_cd} != 'All')" ).append("\n"); 
		query.append("                		AND A1.RLANE_CD      = @[rlane_cd] -- Adjustment by VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                        AND A1.RLANE_CD      IN (${f_rlane_cd})-- Portion Adjustment by HO/RHQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                        AND A1.DIR_CD        = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_conv_dir_cd} != '' && ${f_conv_dir_cd} != 'All')              " ).append("\n"); 
		query.append("						AND A1.CONV_DIR_CD   = @[f_conv_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} == 'on' && ${f_trd_dir} != '' && ${f_trd_dir} != 'All')" ).append("\n"); 
		query.append("                        AND A4.HUL_BND_CD    = @[f_trd_dir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mas_vvd} != '')" ).append("\n"); 
		query.append("                        AND A1.VSL_CD || A1.SKD_VOY_NO || A1.SKD_DIR_CD = @[mas_vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                     ) B2" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("                AND B2.BSE_TP_CD     = B1.BSE_TP_CD(+)" ).append("\n"); 
		query.append("                AND B2.BSE_YR        = B1.BSE_YR(+)" ).append("\n"); 
		query.append("                AND B2.BSE_QTR_CD    = B1.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("                AND B2.OFC_VW_CD     = B1.OFC_VW_CD(+)" ).append("\n"); 
		query.append("                AND B2.QTA_STEP_CD   = B1.QTA_STEP_CD(+)" ).append("\n"); 
		query.append("                AND B2.TRD_CD        = B1.TRD_CD(+)" ).append("\n"); 
		query.append("                AND B2.RLANE_CD      = B1.RLANE_CD(+)" ).append("\n"); 
		query.append("                AND B2.DIR_CD        = B1.DIR_CD(+)" ).append("\n"); 
		query.append("                AND B2.RHQ_CD        = B1.RHQ_CD(+)" ).append("\n"); 
		query.append("                AND B2.BSE_WK        BETWEEN SUBSTR(B1.APLY_FM_YRWK(+),-2) AND SUBSTR(B1.APLY_TO_YRWK(+),-2)" ).append("\n"); 
		query.append("              ORDER BY B2.OFC_VW_CD, B2.BSE_WK, B2.RHQ_CD" ).append("\n"); 
		query.append("             ) C1" ).append("\n"); 
		query.append("       )T, SQM_CFM_QTA Q" ).append("\n"); 
		query.append("WHERE Q.QTA_RLSE_VER_NO = T.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("  AND Q.BSE_TP_CD       = T.BSE_TP_CD " ).append("\n"); 
		query.append("  AND Q.BSE_YR          = T.BSE_YR" ).append("\n"); 
		query.append("  AND Q.BSE_QTR_CD      = T.BSE_QTR_CD" ).append("\n"); 
		query.append("  AND Q.OFC_VW_CD       = T.OFC_VW_CD" ).append("\n"); 
		query.append("  AND Q.QTA_TGT_CD      = T.QTA_TGT_CD " ).append("\n"); 
		query.append("  AND Q.TRD_CD          = T.TRD_CD" ).append("\n"); 
		query.append("  AND Q.RLANE_CD        = T.RLANE_CD" ).append("\n"); 
		query.append("  AND Q.DIR_CD          = T.DIR_CD" ).append("\n"); 
		query.append("  AND Q.VSL_CD          = T.VSL_CD" ).append("\n"); 
		query.append("  AND Q.SKD_VOY_NO      = T.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND Q.SKD_DIR_CD      = T.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND Q.RHQ_CD          = T.RHQ_CD  " ).append("\n"); 
		query.append("  AND Q.SQM_CNG_TP_CD   = 'I'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,OFC_VW_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,BSE_WK" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 

	}
}