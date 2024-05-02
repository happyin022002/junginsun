/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchRHQPotnFigureInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOSearchRHQPotnFigureInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Portion Adjutment by RHQ 화면내 Figure Inquiry 팝업을 조회한다.
	  * (확정 이후에 변경된 Portion을 이용하여 Figure 를 조회한다.)
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchRHQPotnFigureInquiryListRSQL(){
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
		params.put("coa_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchRHQPotnFigureInquiryListRSQL").append("\n"); 
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
		query.append("-- CSQ_CNG_TP_CD <> 'I' 에 대해서 조회(그리드에 회색으로 표시)" ).append("\n"); 
		query.append("         SELECT A1.BSE_YR" ).append("\n"); 
		query.append("               ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("               ,DECODE(A2.OFC_VW_CD, 'C', 'Contract', 'L', 'Loading') AS OFC_VW_CD" ).append("\n"); 
		query.append("               ,A1.TRD_CD" ).append("\n"); 
		query.append("               ,A1.RLANE_CD" ).append("\n"); 
		query.append("               ,A1.DIR_CD" ).append("\n"); 
		query.append("               ,A2.CONV_DIR_CD" ).append("\n"); 
		query.append("               ,A1.SUB_TRD_CD" ).append("\n"); 
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
		query.append("               ,A2.CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("               ,@[f_gubun] AS GUBUN" ).append("\n"); 
		query.append("           FROM CSQ_CFM_TGT_VVD A1" ).append("\n"); 
		query.append("               ,CSQ_CFM_QTA A2" ).append("\n"); 
		query.append("               ,CSQ_DAT_RLT A3" ).append("\n"); 
		query.append("               ,CSQ_QTA_LANE_MGMT A4" ).append("\n"); 
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
		query.append("            AND A2.CONV_DIR_CD   = A3.CONV_DIR_CD" ).append("\n"); 
		query.append("            AND A2.RHQ_CD		 = A3.RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND A1.BSE_TP_CD     = A4.BSE_TP_CD" ).append("\n"); 
		query.append("            AND A1.BSE_YR        = A4.BSE_YR" ).append("\n"); 
		query.append("            AND A1.BSE_QTR_CD    = A4.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND A1.TRD_CD        = A4.TRD_CD" ).append("\n"); 
		query.append("            AND A1.RLANE_CD      = A4.RLANE_CD" ).append("\n"); 
		query.append("            AND A4.IAS_SCTR_FLG  = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND A2.CSQ_CNG_TP_CD <> 'I'" ).append("\n"); 
		query.append("            AND A1.QTA_RLSE_VER_NO = (SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                        FROM CSQ_QTA_RLSE_VER" ).append("\n"); 
		query.append("                                       WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                         AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                                         AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                                         AND CSQ_VER_STS_CD = 'R'" ).append("\n"); 
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
		query.append("               ,DECODE(A3.OB_DIV_CD, 'N', 'N.OB', 'O', 'OB') " ).append("\n"); 
		query.append("               ,A1.BSE_WK" ).append("\n"); 
		query.append("               ,A1.VSL_CD || A1.SKD_VOY_NO || A1.SKD_DIR_CD " ).append("\n"); 
		query.append("               ,A2.RHQ_CD" ).append("\n"); 
		query.append("               ,A2.CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- CSQ_CNG_TP_CD = 'I' 에 대해서 조회" ).append("\n"); 
		query.append("SELECT DISTINCT Q.BSE_YR" ).append("\n"); 
		query.append("      ,Q.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,DECODE(Q.OFC_VW_CD, 'C', 'Contract', 'L', 'Loading') AS OFC_VW_CD" ).append("\n"); 
		query.append("      ,Q.TRD_CD" ).append("\n"); 
		query.append("      ,Q.RLANE_CD" ).append("\n"); 
		query.append("      ,Q.DIR_CD" ).append("\n"); 
		query.append("      ,Q.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,Q.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,DECODE(Q.OB_DIV_CD, 'N', 'N.OB', 'O', 'OB') AS OB_DIV_CD" ).append("\n"); 
		query.append("      ,Q.BSE_WK" ).append("\n"); 
		query.append("      ,Q.VVD" ).append("\n"); 
		query.append("      ,Q.RHQ_CD" ).append("\n"); 
		query.append("#if (${f_gubun} == 'HO')" ).append("\n"); 
		query.append("      ,Q.RHQ_LOD_RTO * 100 AS LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,Q.RHQ_REV_RTO * 100 AS REV_POTN_RTO" ).append("\n"); 
		query.append("      ,Q.RHQ_QTY           AS LOD_QTY" ).append("\n"); 
		query.append("      ,Q.RHQ_REV           AS GRS_REV" ).append("\n"); 
		query.append("#elseif (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("      ,Q.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,Q.OFC_LOD_RTO  * 100  AS LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,Q.OFC_REV_RTO  * 100  AS REV_POTN_RTO" ).append("\n"); 
		query.append("      ,Q.LOD_QTY" ).append("\n"); 
		query.append("      ,Q.LOD_QTY * Q.GRS_RPB_REV AS GRS_REV" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,Q.CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("      ,@[f_gubun] AS GUBUN" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("              ,BSE_TP_CD " ).append("\n"); 
		query.append("              ,BSE_YR" ).append("\n"); 
		query.append("              ,BSE_QTR_CD" ).append("\n"); 
		query.append("              ,OFC_VW_CD" ).append("\n"); 
		query.append("              ,QTA_TGT_CD" ).append("\n"); 
		query.append("              ,TRD_CD" ).append("\n"); 
		query.append("              ,RLANE_CD" ).append("\n"); 
		query.append("              ,DIR_CD" ).append("\n"); 
		query.append("              ,BSE_WK" ).append("\n"); 
		query.append("              ,SUB_TRD_CD" ).append("\n"); 
		query.append("              ,OB_DIV_CD" ).append("\n"); 
		query.append("              ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("              ,VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("              ,RGN_OFC_CD" ).append("\n"); 
		query.append("              ,DECODE(BSE_YR||BSE_QTR_CD, '20141Q', DECODE(RGN_OFC_CD, 'SELBB', 'SELIB', 'TYOBB', 'TYOIB', RHQ_CD), RHQ_CD) AS RHQ_CD" ).append("\n"); 
		query.append("              ,AQ_CD" ).append("\n"); 
		query.append("              ,CONV_DIR_CD" ).append("\n"); 
		query.append("              ,LOD_QTY" ).append("\n"); 
		query.append("              ,DECODE(LOD_QTY, 0,0, OFC_REV/LOD_QTY) AS GRS_RPB_REV" ).append("\n"); 
		query.append("              ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("              ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("              ,OFC_LOD_RTO" ).append("\n"); 
		query.append("              ,OFC_REV_RTO" ).append("\n"); 
		query.append("              ,RHQ_LOD_RTO" ).append("\n"); 
		query.append("              ,RHQ_REV_RTO" ).append("\n"); 
		query.append("              ,'I' AS CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("              ,SUM(LOD_QTY) OVER (PARTITION BY BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, TRD_CD, RLANE_CD, CONV_DIR_CD, VSL_CD || SKD_VOY_NO || SKD_DIR_CD, RHQ_CD) AS RHQ_QTY" ).append("\n"); 
		query.append("              ,SUM(OFC_REV) OVER (PARTITION BY BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, TRD_CD, RLANE_CD, CONV_DIR_CD, VSL_CD || SKD_VOY_NO || SKD_DIR_CD, RHQ_CD) AS RHQ_REV" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                  SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                        ,BSE_TP_CD " ).append("\n"); 
		query.append("                        ,BSE_YR" ).append("\n"); 
		query.append("                        ,BSE_QTR_CD" ).append("\n"); 
		query.append("                        ,OFC_VW_CD" ).append("\n"); 
		query.append("                        ,QTA_TGT_CD" ).append("\n"); 
		query.append("                        ,TRD_CD" ).append("\n"); 
		query.append("                        ,RLANE_CD" ).append("\n"); 
		query.append("                        ,DIR_CD" ).append("\n"); 
		query.append("                        ,BSE_WK" ).append("\n"); 
		query.append("                        ,SUB_TRD_CD" ).append("\n"); 
		query.append("                        ,OB_DIV_CD" ).append("\n"); 
		query.append("                        ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("                        ,VSL_CD" ).append("\n"); 
		query.append("                        ,SKD_VOY_NO" ).append("\n"); 
		query.append("                        ,SKD_DIR_CD" ).append("\n"); 
		query.append("                        ,RGN_OFC_CD" ).append("\n"); 
		query.append("                        ,RHQ_CD" ).append("\n"); 
		query.append("                        ,AQ_CD" ).append("\n"); 
		query.append("                        ,CONV_DIR_CD" ).append("\n"); 
		query.append("#if (${f_gubun} == 'HO') " ).append("\n"); 
		query.append("                        ,DECODE(ROUND(ORG_LOD - VVD_LOD_SUM), 0, OFC_LOD, DECODE(RHQ_RNK, 1, DECODE(LOD_RNK, 1, OFC_LOD + ROUND(ORG_LOD - VVD_LOD_SUM), OFC_LOD), OFC_LOD)) LOD_QTY" ).append("\n"); 
		query.append("                        ,DECODE((ORG_REV - VVD_REV_SUM), 0, OFC_REV, DECODE(RHQ_RNK, 1, DECODE(LOD_RNK, 1, OFC_REV + (ORG_REV - VVD_REV_SUM), OFC_REV), OFC_REV)) OFC_REV" ).append("\n"); 
		query.append("#elseif (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("                        ,OFC_LOD AS LOD_QTY" ).append("\n"); 
		query.append("                        ,OFC_REV" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("                        ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("                        ,OFC_LOD_RTO" ).append("\n"); 
		query.append("                        ,OFC_REV_RTO" ).append("\n"); 
		query.append("                        ,RHQ_LOD_RTO" ).append("\n"); 
		query.append("                        ,RHQ_REV_RTO" ).append("\n"); 
		query.append("                        ,RHQ_QTY" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                            SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                  ,BSE_TP_CD" ).append("\n"); 
		query.append("                                  ,BSE_YR" ).append("\n"); 
		query.append("                                  ,BSE_QTR_CD" ).append("\n"); 
		query.append("                                  ,OFC_VW_CD" ).append("\n"); 
		query.append("                                  ,QTA_TGT_CD" ).append("\n"); 
		query.append("                                  ,TRD_CD" ).append("\n"); 
		query.append("                                  ,RLANE_CD" ).append("\n"); 
		query.append("                                  ,DIR_CD" ).append("\n"); 
		query.append("                                  ,BSE_WK" ).append("\n"); 
		query.append("                                  ,SUB_TRD_CD" ).append("\n"); 
		query.append("                                  ,OB_DIV_CD" ).append("\n"); 
		query.append("                                  ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("                                  ,VSL_CD" ).append("\n"); 
		query.append("                                  ,SKD_VOY_NO" ).append("\n"); 
		query.append("                                  ,SKD_DIR_CD" ).append("\n"); 
		query.append("                                  ,RGN_OFC_CD" ).append("\n"); 
		query.append("                                  ,RHQ_CD" ).append("\n"); 
		query.append("                                  ,NVL(( SELECT V.N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("                                       FROM CSQ_ORGANIZATION_V V" ).append("\n"); 
		query.append("                                      WHERE V.OFC_CD   = RGN_OFC_CD" ).append("\n"); 
		query.append("                                        AND V.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                   ),'') AS AQ_CD" ).append("\n"); 
		query.append("                                  ,CONV_DIR_CD" ).append("\n"); 
		query.append("                                  ,ROW_NUMBER() OVER (PARTITION BY BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, TRD_CD, RLANE_CD, CONV_DIR_CD, VSL_CD || SKD_VOY_NO || SKD_DIR_CD, RHQ_CD ORDER BY OFC_LOD DESC, RGN_OFC_CD) AS LOD_RNK" ).append("\n"); 
		query.append("                                  ,OFC_LOD as old_ofc_cd" ).append("\n"); 
		query.append("                                  ,ROUND(RHQ_QTY - RHQ_LOD_SUM) diff" ).append("\n"); 
		query.append("                                  -- OFFICE 별 물량에 RHQ 별 DIFF가 존재할 경우 LOAD RNK가 1인 것에 물량을 가감한다." ).append("\n"); 
		query.append("                                  ,DECODE(OFC_LOD_RTO, 0, 0, DECODE(LOD_RNK, 1, OFC_LOD + ROUND(RHQ_QTY - RHQ_LOD_SUM), OFC_LOD)) AS OFC_LOD" ).append("\n"); 
		query.append("                                  ,SUM(DECODE(OFC_LOD_RTO, 0, 0, DECODE(LOD_RNK, 1, OFC_LOD + ROUND(RHQ_QTY - RHQ_LOD_SUM), OFC_LOD))) OVER (PARTITION BY BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, TRD_CD, RLANE_CD, CONV_DIR_CD, VSL_CD, SKD_VOY_NO, RHQ_CD) AS RHQ_LOD_SUM" ).append("\n"); 
		query.append("                                  ,SUM(DECODE(OFC_LOD_RTO, 0, 0, DECODE(LOD_RNK, 1, OFC_LOD + ROUND(RHQ_QTY - RHQ_LOD_SUM), OFC_LOD))) OVER (PARTITION BY BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, TRD_CD, RLANE_CD, CONV_DIR_CD, VSL_CD, SKD_VOY_NO) AS VVD_LOD_SUM" ).append("\n"); 
		query.append("                                  -- OFFICE 별 물량에 존재할 경우 RHQ 별 REV DIFF가 존재할 경우 REV RNK가 1인 것에 물량을 가감한다." ).append("\n"); 
		query.append("                                  ,DECODE(DECODE(OFC_LOD_RTO, 0, 0, DECODE(LOD_RNK, 1, OFC_LOD + ROUND(RHQ_QTY - RHQ_LOD_SUM), OFC_LOD))" ).append("\n"); 
		query.append("                                         ,0, 0" ).append("\n"); 
		query.append("                                         ,DECODE(REV_RNK, 1, OFC_REV + (RHQ_REV - RHQ_REV_SUM), OFC_REV)) AS OFC_REV" ).append("\n"); 
		query.append("                                  ,SUM(DECODE(DECODE(OFC_LOD_RTO, 0, 0, DECODE(LOD_RNK, 1, OFC_LOD + ROUND(RHQ_QTY - RHQ_LOD_SUM), OFC_LOD))" ).append("\n"); 
		query.append("                                             ,0, 0" ).append("\n"); 
		query.append("                                             ,DECODE(REV_RNK, 1, OFC_REV + (RHQ_REV - RHQ_REV_SUM), OFC_REV))) OVER (PARTITION BY BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, TRD_CD, RLANE_CD, CONV_DIR_CD, VSL_CD, SKD_VOY_NO, RHQ_CD) AS RHQ_REV_SUM" ).append("\n"); 
		query.append("                                  ,SUM(DECODE(DECODE(OFC_LOD_RTO, 0, 0, DECODE(LOD_RNK, 1, OFC_LOD + ROUND(RHQ_QTY - RHQ_LOD_SUM), OFC_LOD))" ).append("\n"); 
		query.append("                                             ,0, 0" ).append("\n"); 
		query.append("                                             ,DECODE(REV_RNK, 1, OFC_REV + (RHQ_REV - RHQ_REV_SUM), OFC_REV))) OVER (PARTITION BY BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, TRD_CD, RLANE_CD, CONV_DIR_CD, VSL_CD, SKD_VOY_NO) AS VVD_REV_SUM" ).append("\n"); 
		query.append("                                  ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("                                  ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("                                  ,'I' AS CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("                                  ,RHQ_RNK" ).append("\n"); 
		query.append("                                  ,OFC_LOD_RTO" ).append("\n"); 
		query.append("                                  ,OFC_REV_RTO" ).append("\n"); 
		query.append("                                  ,RHQ_LOD_RTO" ).append("\n"); 
		query.append("                                  ,RHQ_REV_RTO" ).append("\n"); 
		query.append("                                  ,RHQ_QTY" ).append("\n"); 
		query.append("                                  ,RHQ_REV AS ORG_RHQ_REV" ).append("\n"); 
		query.append("                                  ,ORG_LOD" ).append("\n"); 
		query.append("                                  ,ORG_REV " ).append("\n"); 
		query.append("                              FROM (" ).append("\n"); 
		query.append("                                      SELECT SUBSTR(E1.BSE_YR,-2)||E1.BSE_QTR_CD||'02' AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                            ,E1.BSE_TP_CD" ).append("\n"); 
		query.append("                                            ,E1.BSE_YR" ).append("\n"); 
		query.append("                                            ,E1.BSE_QTR_CD" ).append("\n"); 
		query.append("                                            ,E1.OFC_VW_CD" ).append("\n"); 
		query.append("                                            ,E1.QTA_TGT_CD" ).append("\n"); 
		query.append("                                            ,E1.TRD_CD" ).append("\n"); 
		query.append("                                            ,E1.RLANE_CD" ).append("\n"); 
		query.append("                                            ,E1.DIR_CD" ).append("\n"); 
		query.append("                                            ,E1.BSE_WK" ).append("\n"); 
		query.append("                                            ,E1.SUB_TRD_CD" ).append("\n"); 
		query.append("                                            ,E1.OB_DIV_CD" ).append("\n"); 
		query.append("                                            ,E1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                                            ,E1.VSL_CD" ).append("\n"); 
		query.append("                                            ,E1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                            ,E1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                            ,E1.RGN_OFC_CD" ).append("\n"); 
		query.append("                                            ,E1.RHQ_CD" ).append("\n"); 
		query.append("                                            ,E1.CONV_DIR_CD" ).append("\n"); 
		query.append("                                            ,(E1.RHQ_QTY - SUM(ROUND(E1.RHQ_QTY * NVL(E3.LOD_POTN_RTO / 100, E1.OFC_LOD_RTO), 0)) OVER (PARTITION BY E1.BSE_TP_CD, E1.BSE_YR, E1.BSE_QTR_CD, E1.OFC_VW_CD, E1.TRD_CD, E1.RLANE_CD, E1.CONV_DIR_CD, E1.VSL_CD, E1.SKD_VOY_NO, E1.RHQ_CD)) AS RHQ_LOD_DIFF" ).append("\n"); 
		query.append("                                            ,ROUND(E1.RHQ_QTY * (NVL(E3.LOD_POTN_RTO / 100, E1.OFC_LOD_RTO)), 0) AS OFC_LOD" ).append("\n"); 
		query.append("                                            ,DECODE(RHQ_QTY, 0, 0, RHQ_REV * NVL(E3.REV_POTN_RTO / 100, E1.OFC_REV_RTO)) AS OFC_REV" ).append("\n"); 
		query.append("                                            ,SUM(ROUND(E1.RHQ_QTY * (NVL(E3.LOD_POTN_RTO / 100, E1.OFC_LOD_RTO)), 0)) OVER (PARTITION BY E1.BSE_TP_CD, E1.BSE_YR, E1.BSE_QTR_CD, E1.OFC_VW_CD, E1.TRD_CD, E1.RLANE_CD, E1.CONV_DIR_CD, E1.VSL_CD, E1.SKD_VOY_NO, E1.RHQ_CD) AS RHQ_LOD_SUM" ).append("\n"); 
		query.append("                                            ,SUM(DECODE(RHQ_QTY, 0, 0, RHQ_REV * NVL(E3.REV_POTN_RTO / 100, E1.OFC_REV_RTO))) OVER (PARTITION BY E1.BSE_TP_CD, E1.BSE_YR, E1.BSE_QTR_CD, E1.OFC_VW_CD, E1.TRD_CD, E1.RLANE_CD, E1.CONV_DIR_CD, E1.VSL_CD, E1.SKD_VOY_NO, E1.RHQ_CD) AS RHQ_REV_SUM" ).append("\n"); 
		query.append("                                            ,E2.PA_CM_UC_AMT" ).append("\n"); 
		query.append("                                            ,E2.RA_CM_UC_AMT" ).append("\n"); 
		query.append("                                            ,NVL(E3.LOD_POTN_RTO / 100, E1.OFC_LOD_RTO) AS OFC_LOD_RTO" ).append("\n"); 
		query.append("                                            ,NVL(E3.REV_POTN_RTO / 100, E1.OFC_REV_RTO) AS OFC_REV_RTO" ).append("\n"); 
		query.append("                                            ,E1.RHQ_LOD_RTO" ).append("\n"); 
		query.append("                                            ,E1.RHQ_REV_RTO" ).append("\n"); 
		query.append("                                            ,E1.RHQ_RNK" ).append("\n"); 
		query.append("                                            ,E1.RHQ_QTY" ).append("\n"); 
		query.append("                                            ,E1.RHQ_REV" ).append("\n"); 
		query.append("                                            ,E1.ORG_LOD" ).append("\n"); 
		query.append("                                            ,E1.ORG_REV" ).append("\n"); 
		query.append("                                            ,ROW_NUMBER() OVER (PARTITION BY E1.BSE_TP_CD, E1.BSE_YR, E1.BSE_QTR_CD, E1.OFC_VW_CD, E1.RHQ_CD, E1.TRD_CD, E1.DIR_CD, E1.RLANE_CD, E1.VSL_CD, E1.SKD_VOY_NO ORDER BY NVL(E3.LOD_POTN_RTO / 100, E1.OFC_LOD_RTO) DESC, E1.RGN_OFC_CD) AS LOD_RNK" ).append("\n"); 
		query.append("                                            ,ROW_NUMBER() OVER (PARTITION BY E1.BSE_TP_CD, E1.BSE_YR, E1.BSE_QTR_CD, E1.OFC_VW_CD, E1.RHQ_CD, E1.TRD_CD, E1.DIR_CD, E1.RLANE_CD, E1.VSL_CD, E1.SKD_VOY_NO ORDER BY NVL(E3.REV_POTN_RTO / 100, E1.OFC_REV_RTO) DESC, E1.RGN_OFC_CD) AS REV_RNK" ).append("\n"); 
		query.append("                                        FROM (" ).append("\n"); 
		query.append("                                              SELECT D2.BSE_TP_CD" ).append("\n"); 
		query.append("                                                    ,D2.BSE_YR" ).append("\n"); 
		query.append("                                                    ,D2.BSE_QTR_CD" ).append("\n"); 
		query.append("                                                    ,D2.OFC_VW_CD" ).append("\n"); 
		query.append("                                                    ,D1.QTA_STEP_CD" ).append("\n"); 
		query.append("                                                    ,D2.TRD_CD" ).append("\n"); 
		query.append("                                                    ,D2.RLANE_CD" ).append("\n"); 
		query.append("                                                    ,D1.DIR_CD" ).append("\n"); 
		query.append("                                                    ,D2.BSE_WK" ).append("\n"); 
		query.append("                                                    ,D2.SUB_TRD_CD" ).append("\n"); 
		query.append("                                                    ,D2.OB_DIV_CD" ).append("\n"); 
		query.append("                                                    ,D2.FNL_BSA_CAPA                                            " ).append("\n"); 
		query.append("                                                    ,D2.VSL_CD" ).append("\n"); 
		query.append("                                                    ,D2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                    ,D2.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                    ,D1.RGN_OFC_CD" ).append("\n"); 
		query.append("                                                    ,D2.RHQ_CD" ).append("\n"); 
		query.append("                                                    ,D2.CONV_DIR_CD" ).append("\n"); 
		query.append("                                                    ,D1.OFC_LOD_RTO" ).append("\n"); 
		query.append("                                                    ,D1.OFC_REV_RTO" ).append("\n"); 
		query.append("                                                    ,D2.RHQ_QTY" ).append("\n"); 
		query.append("                                                    ,D2.RHQ_REV" ).append("\n"); 
		query.append("                                                    ,D2.QTA_TGT_CD" ).append("\n"); 
		query.append("                                                    ,D2.RHQ_RNK" ).append("\n"); 
		query.append("                                                    ,D2.RHQ_LOD_RTO" ).append("\n"); 
		query.append("                                                    ,D2.RHQ_REV_RTO" ).append("\n"); 
		query.append("                                                    ,D2.ORG_LOD" ).append("\n"); 
		query.append("                                                    ,D2.ORG_REV" ).append("\n"); 
		query.append("                                                FROM (" ).append("\n"); 
		query.append("                                                      SELECT A1.BSE_TP_CD" ).append("\n"); 
		query.append("                                                            ,A1.BSE_YR" ).append("\n"); 
		query.append("                                                            ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("                                                            ,A1.OFC_VW_CD" ).append("\n"); 
		query.append("                                                            ,NVL(A2.QTA_STEP_CD, DECODE(A1.OFC_VW_CD, 'L', '03', DECODE(A4.OB_DIV_CD, 'N', '04', 'O', '05'))) AS QTA_STEP_CD" ).append("\n"); 
		query.append("                                                            ,A1.TRD_CD" ).append("\n"); 
		query.append("                                                            ,A1.DIR_CD" ).append("\n"); 
		query.append("                                                            ,NVL(A3.CONV_DIR_CD, A1.DIR_CD) AS CONV_DIR_CD" ).append("\n"); 
		query.append("                                                            ,A1.RLANE_CD" ).append("\n"); 
		query.append("                                                            ,A1.RHQ_CD" ).append("\n"); 
		query.append("                                                            ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("                                                            ,NVL(A2.LOD_POTN_RTO,0) / 100 AS OFC_LOD_RTO" ).append("\n"); 
		query.append("                                                            ,NVL(A2.REV_POTN_RTO,0) / 100 AS OFC_REV_RTO" ).append("\n"); 
		query.append("                                                        FROM CSQ_QTA_LANE_OFC A1" ).append("\n"); 
		query.append("                                                            ,CSQ_QTA_POTN_MGMT A2" ).append("\n"); 
		query.append("                                                            ,CSQ_DIR_CONV A3" ).append("\n"); 
		query.append("                                                            ,CSQ_DAT_RLT A4" ).append("\n"); 
		query.append("                                                            ,CSQ_QTA_LANE_MGMT A5" ).append("\n"); 
		query.append("                                                       WHERE 1=1" ).append("\n"); 
		query.append("                                                         AND A1.BSE_TP_CD   = A2.BSE_TP_CD(+)" ).append("\n"); 
		query.append("                                                         AND A1.BSE_YR      = A2.BSE_YR(+)" ).append("\n"); 
		query.append("                                                         AND A1.BSE_QTR_CD  = A2.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("                                                         AND A1.OFC_VW_CD   = A2.OFC_VW_CD(+)" ).append("\n"); 
		query.append("                                                         AND A1.TRD_CD      = A2.TRD_CD(+)" ).append("\n"); 
		query.append("                                                         AND A1.DIR_CD      = A2.DIR_CD(+)" ).append("\n"); 
		query.append("                                                         AND A1.RHQ_CD      = A2.RHQ_CD(+)" ).append("\n"); 
		query.append("                                                         AND A1.RLANE_CD    = A2.RLANE_CD(+)" ).append("\n"); 
		query.append("                                                         AND A1.RGN_OFC_CD  = A2.RGN_OFC_CD(+)" ).append("\n"); 
		query.append("                                                         " ).append("\n"); 
		query.append("                                                         AND A1.BSE_TP_CD   = A3.BSE_TP_CD(+)" ).append("\n"); 
		query.append("                                                         AND A1.BSE_YR      = A3.BSE_YR(+)" ).append("\n"); 
		query.append("                                                         AND A1.BSE_QTR_CD  = A3.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("                                                         AND A1.TRD_CD      = A3.TRD_CD(+)" ).append("\n"); 
		query.append("                                                         AND A1.RLANE_CD    = A3.RLANE_CD(+)" ).append("\n"); 
		query.append("                                                         AND A1.DIR_CD      = A3.DIR_CD(+)" ).append("\n"); 
		query.append("                                                         " ).append("\n"); 
		query.append("                                                         AND A1.BSE_TP_CD   = A4.BSE_TP_CD" ).append("\n"); 
		query.append("                                                         AND A1.BSE_YR      = A4.BSE_YR" ).append("\n"); 
		query.append("                                                         AND A1.BSE_QTR_CD  = A4.BSE_QTR_CD" ).append("\n"); 
		query.append("                                                         AND A1.OFC_VW_CD   = A4.OFC_VW_CD" ).append("\n"); 
		query.append("                                                         AND A1.TRD_CD      = A4.TRD_CD" ).append("\n"); 
		query.append("                                                         AND A1.RHQ_CD      = A4.RHQ_CD" ).append("\n"); 
		query.append("                                                         AND NVL(A3.CONV_DIR_CD, A1.DIR_CD) = A4.CONV_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                         AND A1.BSE_TP_CD     = A5.BSE_TP_CD" ).append("\n"); 
		query.append("                                                         AND A1.BSE_YR        = A5.BSE_YR" ).append("\n"); 
		query.append("                                                         AND A1.BSE_QTR_CD    = A5.BSE_QTR_CD" ).append("\n"); 
		query.append("                                                         AND A1.TRD_CD        = A5.TRD_CD" ).append("\n"); 
		query.append("                                                         AND A1.RLANE_CD      = A5.RLANE_CD" ).append("\n"); 
		query.append("                                                         AND A5.IAS_SCTR_FLG  = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                         AND A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                                         AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("                                                         AND A1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("                                                         AND A1.RHQ_CD      = (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN A1.RHQ_CD" ).append("\n"); 
		query.append("                                                                                      ELSE @[ofc_cd]" ).append("\n"); 
		query.append("                                                                                       END RHQ_CD" ).append("\n"); 
		query.append("                                                                                 FROM DUAL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ofc_vw_cd} != '' && ${f_ofc_vw_cd} != 'All')" ).append("\n"); 
		query.append("                                                         AND A1.OFC_VW_CD   = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                                                         AND A1.TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '' && ${rlane_cd} != 'All')" ).append("\n"); 
		query.append("                                                         AND A1.RLANE_CD    = @[rlane_cd] -- Adjustment by VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                                                         AND A1.RLANE_CD    IN (${f_rlane_cd})-- Portion Adjustment by HO/RHQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                                                         AND A1.DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_conv_dir_cd} != '' && ${f_conv_dir_cd} != 'All')" ).append("\n"); 
		query.append("                                                         AND NVL(A3.CONV_DIR_CD, A1.DIR_CD) = @[f_conv_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                         AND A1.CSQ_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("                                                         AND A2.QTA_STEP_CD(+) <> '02'" ).append("\n"); 
		query.append("                                                      ) D1" ).append("\n"); 
		query.append("                                                    ,(" ).append("\n"); 
		query.append("                                                      SELECT C1.BSE_TP_CD" ).append("\n"); 
		query.append("                                                            ,C1.BSE_YR" ).append("\n"); 
		query.append("                                                            ,C1.BSE_QTR_CD" ).append("\n"); 
		query.append("                                                            ,C1.OFC_VW_CD" ).append("\n"); 
		query.append("                                                            ,C1.QTA_TGT_CD" ).append("\n"); 
		query.append("                                                            ,C1.TRD_CD" ).append("\n"); 
		query.append("                                                            ,C1.SUB_TRD_CD" ).append("\n"); 
		query.append("                                                            ,C1.OB_DIV_CD" ).append("\n"); 
		query.append("                                                            ,C1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                                                            ,C1.RLANE_CD" ).append("\n"); 
		query.append("                                                            ,C1.CONV_DIR_CD" ).append("\n"); 
		query.append("                                                            ,C1.DIR_CD" ).append("\n"); 
		query.append("                                                            ,C1.BSE_WK" ).append("\n"); 
		query.append("                                                            ,C1.VSL_CD" ).append("\n"); 
		query.append("                                                            ,C1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                            ,C1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                            ,C1.RHQ_CD" ).append("\n"); 
		query.append("                                                            ,C1.LOAD_RNK AS RHQ_RNK" ).append("\n"); 
		query.append("                                                            ,DECODE(C1.LOAD_RNK, '1', C1.RHQ_QTY + (C1.ORG_VVD_BSA - C1.SUM_RHQ_QTY), C1.RHQ_QTY) AS RHQ_QTY" ).append("\n"); 
		query.append("                                                            ,C1.GRS_REV * C1.RHQ_REV_RTO AS RHQ_REV" ).append("\n"); 
		query.append("                                                            ,C1.RHQ_REV_RTO" ).append("\n"); 
		query.append("                                                            ,C1.RHQ_LOD_RTO" ).append("\n"); 
		query.append("                                                            ,C1.ORG_VVD_BSA AS ORG_LOD" ).append("\n"); 
		query.append("                                                            ,C1.GRS_REV AS ORG_REV" ).append("\n"); 
		query.append("                                                       FROM (" ).append("\n"); 
		query.append("                                                             SELECT B2.BSE_TP_CD" ).append("\n"); 
		query.append("                                                                   ,B2.BSE_YR" ).append("\n"); 
		query.append("                                                                   ,B2.BSE_QTR_CD" ).append("\n"); 
		query.append("                                                                   ,B2.OFC_VW_CD" ).append("\n"); 
		query.append("                                                                   ,B2.QTA_TGT_CD" ).append("\n"); 
		query.append("                                                                   ,B2.TRD_CD" ).append("\n"); 
		query.append("                                                                   ,B2.SUB_TRD_CD" ).append("\n"); 
		query.append("                                                                   ,B2.OB_DIV_CD" ).append("\n"); 
		query.append("                                                                   ,B2.FNL_BSA_CAPA                                                           " ).append("\n"); 
		query.append("                                                                   ,B2.RLANE_CD" ).append("\n"); 
		query.append("                                                                   ,B2.CONV_DIR_CD" ).append("\n"); 
		query.append("                                                                   ,B2.DIR_CD" ).append("\n"); 
		query.append("                                                                   ,B2.BSE_WK" ).append("\n"); 
		query.append("                                                                   ,SUBSTR(B1.APLY_FM_YRWK,-2) AS APLY_FM_WK" ).append("\n"); 
		query.append("                                                                   ,SUBSTR(B1.APLY_TO_YRWK,-2) AS APLY_TO_WK" ).append("\n"); 
		query.append("                                                                   ,B2.VSL_CD" ).append("\n"); 
		query.append("                                                                   ,B2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                   ,B2.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                   ,B2.RHQ_CD" ).append("\n"); 
		query.append("                                                                   ,NVL(B1.LOD_POTN_RTO,B2.RHQ_LOD_RTO) /100 AS RHQ_LOD_RTO" ).append("\n"); 
		query.append("                                                                   ,NVL(B1.REV_POTN_RTO,B2.RHQ_REV_RTO) /100 AS RHQ_REV_RTO" ).append("\n"); 
		query.append("                                                                   ,B2.GRS_REV" ).append("\n"); 
		query.append("                                                                   -- RHQ 별 물량을 구하기" ).append("\n"); 
		query.append("                                                                   ,B2.LOD_QTY AS ORG_VVD_BSA" ).append("\n"); 
		query.append("                                                                   ,ROUND(B2.LOD_QTY * NVL(NVL(B1.LOD_POTN_RTO,B2.RHQ_LOD_RTO),0)/100, 0) AS RHQ_QTY" ).append("\n"); 
		query.append("                                                                   ,SUM(ROUND(B2.LOD_QTY * NVL(NVL(B1.LOD_POTN_RTO,B2.RHQ_LOD_RTO),0)/100, 0)) OVER (PARTITION BY B2.OFC_VW_CD,B2.TRD_CD,B2.RLANE_CD,B2.CONV_DIR_CD,B2.VSL_CD || B2.SKD_VOY_NO || B2.SKD_DIR_CD) AS SUM_RHQ_QTY" ).append("\n"); 
		query.append("                                                                   ,ROW_NUMBER() OVER (PARTITION BY B2.OFC_VW_CD,B2.TRD_CD,B2.RLANE_CD,B2.CONV_DIR_CD,B2.VSL_CD || B2.SKD_VOY_NO || B2.SKD_DIR_CD ORDER BY NVL(B1.LOD_POTN_RTO,B2.RHQ_LOD_RTO) DESC, B1.RHQ_CD) LOAD_RNK" ).append("\n"); 
		query.append("                                                               FROM CSQ_CFM_QTA_POTN_MGMT B1" ).append("\n"); 
		query.append("                                                                   ,(" ).append("\n"); 
		query.append("                                                                     SELECT DISTINCT " ).append("\n"); 
		query.append("                                                                            A1.BSE_TP_CD" ).append("\n"); 
		query.append("                                                                           ,A1.BSE_YR" ).append("\n"); 
		query.append("                                                                           ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("                                                                           ,A5.OFC_VW_CD" ).append("\n"); 
		query.append("                                                                           ,NVL(A2.QTA_STEP_CD, '02') AS QTA_STEP_CD" ).append("\n"); 
		query.append("                                                                           ,A1.TRD_CD" ).append("\n"); 
		query.append("                                                                           ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                                                                           ,A1.RLANE_CD" ).append("\n"); 
		query.append("                                                                           ,A3.OB_DIV_CD" ).append("\n"); 
		query.append("                                                                           ,A1.FNL_BSA_CAPA " ).append("\n"); 
		query.append("                                                                           ,A1.CONV_DIR_CD" ).append("\n"); 
		query.append("                                                                           ,A1.DIR_CD" ).append("\n"); 
		query.append("                                                                           ,A1.BSE_WK" ).append("\n"); 
		query.append("                                                                           ,A1.VSL_CD" ).append("\n"); 
		query.append("                                                                           ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                           ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                           ,A5.RHQ_CD" ).append("\n"); 
		query.append("                                                                           ,NVL(A2.LOD_POTN_RTO, 0) AS RHQ_LOD_RTO" ).append("\n"); 
		query.append("                                                                           ,NVL(A2.REV_POTN_RTO, 0) AS RHQ_REV_RTO" ).append("\n"); 
		query.append("                                                                           ,A1.GRS_REV" ).append("\n"); 
		query.append("                                                                           ,A1.LOD_QTY" ).append("\n"); 
		query.append("                                                                           ,A1.QTA_TGT_CD" ).append("\n"); 
		query.append("                                                                       FROM CSQ_CFM_TGT_VVD A1" ).append("\n"); 
		query.append("                                                                           ,CSQ_QTA_POTN_MGMT A2" ).append("\n"); 
		query.append("                                                                           ,CSQ_DAT_RLT A3" ).append("\n"); 
		query.append("                                                                           ,CSQ_QTA_LANE_MGMT A4" ).append("\n"); 
		query.append("                                                                           ,CSQ_QTA_LANE_OFC A5" ).append("\n"); 
		query.append("                                                                      WHERE 1=1" ).append("\n"); 
		query.append("                                                                        AND A1.BSE_TP_CD     = A5.BSE_TP_CD" ).append("\n"); 
		query.append("                                                                        AND A1.BSE_YR        = A5.BSE_YR" ).append("\n"); 
		query.append("                                                                        AND A1.BSE_QTR_CD    = A5.BSE_QTR_CD" ).append("\n"); 
		query.append("                                                                        AND A1.TRD_CD        = A5.TRD_CD" ).append("\n"); 
		query.append("                                                                        AND A1.RLANE_CD      = A5.RLANE_CD" ).append("\n"); 
		query.append("                                                                        AND A1.DIR_CD        = A5.DIR_CD" ).append("\n"); 
		query.append("                                                                        AND A5.CSQ_ACT_FLG   = 'Y'" ).append("\n"); 
		query.append("                                                                        " ).append("\n"); 
		query.append("                                                                        AND A5.BSE_TP_CD     = A2.BSE_TP_CD(+)" ).append("\n"); 
		query.append("                                                                        AND A5.BSE_YR        = A2.BSE_YR(+)" ).append("\n"); 
		query.append("                                                                        AND A5.BSE_QTR_CD    = A2.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("                                                                        AND A5.OFC_VW_CD     = A2.OFC_VW_CD(+)" ).append("\n"); 
		query.append("                                                                        AND A5.TRD_CD        = A2.TRD_CD(+)" ).append("\n"); 
		query.append("                                                                        AND A5.RLANE_CD      = A2.RLANE_CD(+)" ).append("\n"); 
		query.append("                                                                        AND A5.DIR_CD        = A2.DIR_CD(+)" ).append("\n"); 
		query.append("                                                                        AND A5.RHQ_CD        = A2.RHQ_CD(+)" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                                                                        AND A5.BSE_TP_CD     = A3.BSE_TP_CD" ).append("\n"); 
		query.append("                                                                        AND A5.BSE_YR        = A3.BSE_YR" ).append("\n"); 
		query.append("                                                                        AND A5.BSE_QTR_CD    = A3.BSE_QTR_CD" ).append("\n"); 
		query.append("                                                                        AND A5.OFC_VW_CD     = A3.OFC_VW_CD" ).append("\n"); 
		query.append("                                                                        AND A5.TRD_CD        = A3.TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                                        AND A1.CONV_DIR_CD   = A3.CONV_DIR_CD" ).append("\n"); 
		query.append("                                                                        AND A5.RHQ_CD        = A3.RHQ_CD" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                                                                        AND A1.BSE_TP_CD     = A4.BSE_TP_CD" ).append("\n"); 
		query.append("                                                                        AND A1.BSE_YR        = A4.BSE_YR" ).append("\n"); 
		query.append("                                                                        AND A1.BSE_QTR_CD    = A4.BSE_QTR_CD" ).append("\n"); 
		query.append("                                                                        AND A1.TRD_CD        = A4.TRD_CD" ).append("\n"); 
		query.append("                                                                        AND A1.RLANE_CD      = A4.RLANE_CD" ).append("\n"); 
		query.append("                                                                        AND A4.IAS_SCTR_FLG  = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                                        AND A1.QTA_RLSE_VER_NO = (SELECT QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                                                                                    FROM CSQ_QTA_RLSE_VER" ).append("\n"); 
		query.append("                                                                                                   WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                                                                                     AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                                                                                                     AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                                                                                                     AND CSQ_VER_STS_CD = 'R'" ).append("\n"); 
		query.append("                                                                                                  )" ).append("\n"); 
		query.append("                                                                        AND A1.BSE_TP_CD     = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                                                        AND A1.BSE_YR        = @[f_bse_yr]" ).append("\n"); 
		query.append("                                                                        AND A1.BSE_QTR_CD    = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                                                                        AND A2.QTA_STEP_CD(+)= '02'" ).append("\n"); 
		query.append("#if (${f_gubun} == 'HO')" ).append("\n"); 
		query.append("                                                                        AND A3.TEAM_CD       = (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN A3.TEAM_CD" ).append("\n"); 
		query.append("                                                                                                            ELSE @[ofc_cd]" ).append("\n"); 
		query.append("                                                                                                       END TEAM_CD" ).append("\n"); 
		query.append("                                                                                                FROM DUAL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ofc_vw_cd} != '' && ${f_ofc_vw_cd} != 'All')" ).append("\n"); 
		query.append("                                                                        AND A5.OFC_VW_CD     = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                                        AND A1.QTA_TGT_CD    = 'D'" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                                                                        AND A1.TRD_CD        = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '' && ${rlane_cd} != 'All')" ).append("\n"); 
		query.append("                                                                        AND A1.RLANE_CD      = @[rlane_cd] -- Adjustment by VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                                                                        AND A1.RLANE_CD      IN (${f_rlane_cd})-- Portion Adjustment by HO/RHQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                                                                        AND A1.DIR_CD        = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_conv_dir_cd} != '' && ${f_conv_dir_cd} != 'All')" ).append("\n"); 
		query.append("                                                                        AND A1.CONV_DIR_CD   = @[f_conv_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${coa_vvd} != '')" ).append("\n"); 
		query.append("                                                                        AND A1.VSL_CD || A1.SKD_VOY_NO || A1.SKD_DIR_CD = @[coa_vvd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                                     ) B2" ).append("\n"); 
		query.append("                                                              WHERE 1=1" ).append("\n"); 
		query.append("                                                                AND B2.BSE_TP_CD     = B1.BSE_TP_CD(+)" ).append("\n"); 
		query.append("                                                                AND B2.BSE_YR        = B1.BSE_YR(+)" ).append("\n"); 
		query.append("                                                                AND B2.BSE_QTR_CD    = B1.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("                                                                AND B2.OFC_VW_CD     = B1.OFC_VW_CD(+)" ).append("\n"); 
		query.append("                                                                AND B2.QTA_STEP_CD   = B1.QTA_STEP_CD(+)" ).append("\n"); 
		query.append("                                                                AND B2.TRD_CD        = B1.TRD_CD(+)" ).append("\n"); 
		query.append("                                                                AND B2.RLANE_CD      = B1.RLANE_CD(+)" ).append("\n"); 
		query.append("                                                                AND B2.DIR_CD        = B1.DIR_CD(+)" ).append("\n"); 
		query.append("                                                                AND B2.RHQ_CD        = B1.RHQ_CD(+)" ).append("\n"); 
		query.append("                                                                AND B2.BSE_WK        BETWEEN SUBSTR(B1.APLY_FM_YRWK(+),-2) AND SUBSTR(B1.APLY_TO_YRWK(+),-2)" ).append("\n"); 
		query.append("                                                              ORDER BY B2.OFC_VW_CD, B2.BSE_WK, B2.RHQ_CD" ).append("\n"); 
		query.append("                                                             ) C1" ).append("\n"); 
		query.append("                                                      ) D2" ).append("\n"); 
		query.append("                                               WHERE 1=1" ).append("\n"); 
		query.append("                                                 AND D1.BSE_TP_CD   = D2.BSE_TP_CD" ).append("\n"); 
		query.append("                                                 AND D1.BSE_YR      = D2.BSE_YR" ).append("\n"); 
		query.append("                                                 AND D1.BSE_QTR_CD  = D2.BSE_QTR_CD" ).append("\n"); 
		query.append("                                                 AND D1.OFC_VW_CD   = D2.OFC_VW_CD" ).append("\n"); 
		query.append("                                                 AND D1.TRD_CD      = D2.TRD_CD" ).append("\n"); 
		query.append("                                                 AND D1.RLANE_CD    = D2.RLANE_CD" ).append("\n"); 
		query.append("                                                 AND D1.DIR_CD      = D2.DIR_CD" ).append("\n"); 
		query.append("                                                 AND D1.RHQ_CD      = D2.RHQ_CD" ).append("\n"); 
		query.append("                                              ) E1" ).append("\n"); 
		query.append("                                            ,CSQ_QTA_LANE_OFC_COST E2" ).append("\n"); 
		query.append("                                            ,CSQ_CFM_QTA_POTN_MGMT E3" ).append("\n"); 
		query.append("                                       WHERE 1=1" ).append("\n"); 
		query.append("                                         AND E1.BSE_TP_CD   = E2.BSE_TP_CD" ).append("\n"); 
		query.append("                                         AND E1.BSE_YR      = E2.BSE_YR" ).append("\n"); 
		query.append("                                         AND E1.BSE_QTR_CD  = E2.BSE_QTR_CD" ).append("\n"); 
		query.append("                                         AND E1.OFC_VW_CD   = E2.OFC_VW_CD" ).append("\n"); 
		query.append("                                         AND E1.TRD_CD      = E2.TRD_CD" ).append("\n"); 
		query.append("                                         AND E1.RLANE_CD    = E2.RLANE_CD" ).append("\n"); 
		query.append("                                         AND E1.DIR_CD      = E2.DIR_CD" ).append("\n"); 
		query.append("                                         AND E1.RHQ_CD      = E2.RHQ_CD" ).append("\n"); 
		query.append("                                         AND E1.RGN_OFC_CD  = E2.RGN_OFC_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                                         AND E1.BSE_TP_CD     = E3.BSE_TP_CD(+)" ).append("\n"); 
		query.append("                                         AND E1.BSE_YR        = E3.BSE_YR(+)" ).append("\n"); 
		query.append("                                         AND E1.BSE_QTR_CD    = E3.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("                                         AND E1.OFC_VW_CD     = E3.OFC_VW_CD(+)" ).append("\n"); 
		query.append("                                         AND E1.QTA_STEP_CD   = E3.QTA_STEP_CD(+)" ).append("\n"); 
		query.append("                                         AND E1.TRD_CD        = E3.TRD_CD(+)" ).append("\n"); 
		query.append("                                         AND E1.RLANE_CD      = E3.RLANE_CD(+)" ).append("\n"); 
		query.append("                                         AND E1.DIR_CD        = E3.DIR_CD(+)" ).append("\n"); 
		query.append("                                         AND E1.RHQ_CD        = E3.RHQ_CD(+)" ).append("\n"); 
		query.append("                                         AND E1.RGN_OFC_CD    = E3.RGN_OFC_CD(+)" ).append("\n"); 
		query.append("                                         AND E1.BSE_WK        BETWEEN SUBSTR(E3.APLY_FM_YRWK(+),-2) AND SUBSTR(E3.APLY_TO_YRWK(+),-2)" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                                       ORDER BY E1.OFC_VW_CD, E1.TRD_CD, E1.RLANE_CD, E1.CONV_DIR_CD, E1.VSL_CD, E1.SKD_VOY_NO, E1.SKD_DIR_CD, E1.RHQ_CD, E1.RGN_OFC_CD" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("       ) T" ).append("\n"); 
		query.append("WHERE NOT EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                     FROM CSQ_CFM_QTA C" ).append("\n"); 
		query.append("                    WHERE C.QTA_RLSE_VER_NO = T.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                      AND C.BSE_TP_CD       = T.BSE_TP_CD" ).append("\n"); 
		query.append("                      AND C.BSE_YR          = T.BSE_YR" ).append("\n"); 
		query.append("                      AND C.BSE_QTR_CD      = T.BSE_QTR_CD" ).append("\n"); 
		query.append("                      AND C.OFC_VW_CD       = T.OFC_VW_CD" ).append("\n"); 
		query.append("                      AND C.QTA_TGT_CD      = T.QTA_TGT_CD" ).append("\n"); 
		query.append("                      AND C.TRD_CD          = T.TRD_CD" ).append("\n"); 
		query.append("                      AND C.RLANE_CD        = T.RLANE_CD" ).append("\n"); 
		query.append("                      AND C.DIR_CD          = T.DIR_CD" ).append("\n"); 
		query.append("                      AND C.VSL_CD          = T.VSL_CD" ).append("\n"); 
		query.append("                      AND C.SKD_VOY_NO      = T.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND C.SKD_DIR_CD      = T.SKD_DIR_CD" ).append("\n"); 
		query.append("                      AND C.RGN_OFC_CD      = T.RGN_OFC_CD  " ).append("\n"); 
		query.append("                      AND C.CSQ_CNG_TP_CD   <> 'I')" ).append("\n"); 
		query.append("       ) Q" ).append("\n"); 
		query.append("ORDER BY BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,OFC_VW_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,BSE_WK" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("#if (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}