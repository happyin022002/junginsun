/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchRDRDownloadListByLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2011.01.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchRDRDownloadListByLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * --------------------------------------------------------
	  * History
	  * 2011.01.11 김상수 [CHM-201007350-01] JOO - RDR Inquiry by Lane 기능 보완 요청
	  *                   1. 보완 대상
	  *                      가. 조회  Option
	  *                         - Region Multi 선택
	  *                         - Carrier 추가 - Multi 선택
	  *                      나. Remark Pop up 추가 - 일부 Data 저장 및 해당 컬럼에 반영 (계산 Logic 포함)
	  *                      다. Asjusted Allocation 컬럼 추가 (계산Logic 포함)
	  *                      라. Over Used 계산 Logic( Allocation 참조 컬럼을  Adjusted Allocation으로 변경
	  *                      마. 기타 : 컬럼별 계산 Logic 수정
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchRDRDownloadListByLaneRSQL(){
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
		params.put("pre_fr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pre_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchRDRDownloadListByLaneRSQL").append("\n"); 
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
		query.append("WITH PA AS (SELECT H.VSL_CD," ).append("\n"); 
		query.append("                   H.VOY_NO," ).append("\n"); 
		query.append("                   H.DIR_CD," ).append("\n"); 
		query.append("                   H.REGION," ).append("\n"); 
		query.append("                   H.PORT_CD," ).append("\n"); 
		query.append("                   K.VPS_ETD_DT," ).append("\n"); 
		query.append("                   H.REMARK," ).append("\n"); 
		query.append("                   @[vvd] VVD" ).append("\n"); 
		query.append("              FROM RDR_HEADER H," ).append("\n"); 
		query.append("                   VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("             WHERE K.VPS_ETD_DT BETWEEN TO_DATE (REPLACE (@[pre_fr], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                                    AND TO_DATE (REPLACE (@[pre_to], '-', ''), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("               AND H.REGION IN (${region})" ).append("\n"); 
		query.append("               AND K.SLAN_CD = @[rlane_cd]" ).append("\n"); 
		query.append("               AND H.VSL_CD = K.VSL_CD" ).append("\n"); 
		query.append("               AND H.VOY_NO = K.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND H.PORT_CD = K.VPS_PORT_CD" ).append("\n"); 
		query.append("               AND H.DIR_CD = K.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND K.CLPT_IND_SEQ = '1' --> 수정 : 조건수정" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT Z.VSL_CD," ).append("\n"); 
		query.append("       Z.VOY_NO," ).append("\n"); 
		query.append("       Z.DIR_CD," ).append("\n"); 
		query.append("       Z.VSL_CD || Z.VOY_NO || Z.DIR_CD VVD," ).append("\n"); 
		query.append("       Z.REGION," ).append("\n"); 
		query.append("       Z.PORT_CD," ).append("\n"); 
		query.append("       Z.OPR_CD," ).append("\n"); 
		query.append("       Z.VPS_ETD_DT," ).append("\n"); 
		query.append("       SUM (Z.ALC_ALLOC) ALC_ALLOC," ).append("\n"); 
		query.append("       SUM (Z.ALC_WGT) ALC_WGT," ).append("\n"); 
		query.append("       SUM (Z.SWAP_SLOT) SWAP_SLOT,                             /* Slot R TEU */" ).append("\n"); 
		query.append("       SUM (Z.SWAP_WGT) SWAP_WGT,                               /* Slot R WT */" ).append("\n"); 
		query.append("       NVL (R.JO_SLT_RLSE_CD, 'P') JO_SLT_RLSE_CD,              /* Slot R R/Option */" ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN R.JO_SLT_RLSE_CD = 'R' THEN" ).append("\n"); 
		query.append("               SUM (Z.ALC_ALLOC)" ).append("\n"); 
		query.append("          ELSE /* C, P, null (Default = P) */" ).append("\n"); 
		query.append("               SUM (Z.ALC_ALLOC) + SUM (Z.SWAP_SLOT)" ).append("\n"); 
		query.append("       END ADJUST_TEU,                                          /* Adjusted Allocation TEU */" ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN R.JO_SLT_RLSE_CD = 'R' THEN" ).append("\n"); 
		query.append("               SUM (Z.ALC_WGT)" ).append("\n"); 
		query.append("          ELSE /* C, P, null (Default = P) */" ).append("\n"); 
		query.append("               SUM (Z.ALC_WGT) + SUM (Z.SWAP_WGT)" ).append("\n"); 
		query.append("       END ADJUST_WT,                                           /* Adjusted Allocation WT */" ).append("\n"); 
		query.append("       SUM (Z.ACT_SLOT) + NVL (R.JO_VOID_TEU_QTY, 0) ACT_SLOT," ).append("\n"); 
		query.append("       SUM (Z.ACT_WGT) ACT_WGT," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN R.JO_SLT_RLSE_CD = 'R' THEN" ).append("\n"); 
		query.append("               (SUM (Z.ACT_SLOT) + NVL (R.JO_VOID_TEU_QTY, 0)) - SUM (Z.ALC_ALLOC)" ).append("\n"); 
		query.append("          ELSE /* C, P, null (Default = P) */" ).append("\n"); 
		query.append("               (SUM (Z.ACT_SLOT) + NVL (R.JO_VOID_TEU_QTY, 0)) - (SUM (Z.ALC_ALLOC) + SUM (Z.SWAP_SLOT))" ).append("\n"); 
		query.append("       END OVER_SLOT,                                           /* Over Used TEU */" ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN R.JO_SLT_RLSE_CD = 'R' THEN" ).append("\n"); 
		query.append("               SUM (Z.ACT_WGT) - SUM (Z.ALC_WGT)" ).append("\n"); 
		query.append("          ELSE /* C, P, null (Default = P) */" ).append("\n"); 
		query.append("               SUM (Z.ACT_WGT) - (SUM (Z.ALC_WGT) + SUM (Z.SWAP_WGT))" ).append("\n"); 
		query.append("       END OVER_WGT,                                            /* Over Used WT */" ).append("\n"); 
		query.append("       NVL (R.JO_SHRT_LEG_RMK_TEU_QTY, 0) JO_SHRT_LEG_RMK_TEU_QTY," ).append("\n"); 
		query.append("       NVL (R.JO_SHRT_LEG_RMK_WGT, 0) JO_SHRT_LEG_RMK_WGT," ).append("\n"); 
		query.append("       NVL (R.JO_SHRT_LEG_RMK_DIFF_QTY, 0) JO_SHRT_LEG_RMK_DIFF_QTY," ).append("\n"); 
		query.append("       SUM (Z.LOAD_20) LOAD_20," ).append("\n"); 
		query.append("       SUM (Z.BSA_HC20) BSA_HC20," ).append("\n"); 
		query.append("       SUM (Z.LOAD_40) LOAD_40," ).append("\n"); 
		query.append("       SUM (Z.BSA_HC40) BSA_HC40," ).append("\n"); 
		query.append("       SUM (Z.LOAD_45) LOAD_45," ).append("\n"); 
		query.append("       SUM (Z.BSA_45) BSA_45," ).append("\n"); 
		query.append("       SUM (Z.R_O) + NVL (R.JO_RF_OCN_QTY, 0) R_O," ).append("\n"); 
		query.append("       SUM (Z.R_I) + NVL (R.JO_RF_IPT_QTY, 0) R_I," ).append("\n"); 
		query.append("       SUM (Z.EMPTY_TEU) EMPTY_TEU," ).append("\n"); 
		query.append("       SUM (Z.EMPTY_WT) EMPTY_WT," ).append("\n"); 
		query.append("       NVL2 (MAX (Z.REMARK), 'Yes', 'No') REMARK," ).append("\n"); 
		query.append("       Z.REMARK REMARK_CONT," ).append("\n"); 
		query.append("       NVL (R.JO_RF_OCN_QTY, 0) JO_RF_OCN_QTY," ).append("\n"); 
		query.append("       NVL (R.JO_RF_IPT_QTY, 0) JO_RF_IPT_QTY," ).append("\n"); 
		query.append("       NVL (R.JO_VOID_TEU_QTY, 0) JO_VOID_TEU_QTY" ).append("\n"); 
		query.append("  FROM (SELECT /* 1.Allocation TEU & Allocation WT*/" ).append("\n"); 
		query.append("               H.VSL_CD," ).append("\n"); 
		query.append("               H.VOY_NO," ).append("\n"); 
		query.append("               H.DIR_CD," ).append("\n"); 
		query.append("               H.REGION," ).append("\n"); 
		query.append("               H.PORT_CD," ).append("\n"); 
		query.append("               A.OPR_CD," ).append("\n"); 
		query.append("               H.VPS_ETD_DT," ).append("\n"); 
		query.append("               NVL (SUM (A.BSA_SLOT), 0) + NVL (SUM (A.SWAP_SLOT), 0) ALC_ALLOC, /* Allocation TEU */" ).append("\n"); 
		query.append("               NVL (SUM (A.BSA_WGT), 0) + NVL (SUM (A.SWAP_WGT), 0) ALC_WGT,     /* Allocation WT */" ).append("\n"); 
		query.append("               NVL (SUM (A.SWAP_SLOT), 0) SWAP_SLOT,                             /* Slot Release TEU */" ).append("\n"); 
		query.append("               NVL (SUM (A.SWAP_WGT), 0) SWAP_WGT,                               /* Slot Release WT */" ).append("\n"); 
		query.append("               0 ACT_SLOT," ).append("\n"); 
		query.append("               0 ACT_WGT," ).append("\n"); 
		query.append("               0 LOAD_20," ).append("\n"); 
		query.append("               0 BSA_HC20," ).append("\n"); 
		query.append("               0 LOAD_40," ).append("\n"); 
		query.append("               0 BSA_HC40," ).append("\n"); 
		query.append("               0 LOAD_45," ).append("\n"); 
		query.append("               0 BSA_45," ).append("\n"); 
		query.append("               0 R_O," ).append("\n"); 
		query.append("               0 R_I," ).append("\n"); 
		query.append("               0 EMPTY_TEU," ).append("\n"); 
		query.append("               0 EMPTY_WT," ).append("\n"); 
		query.append("               NVL (MAX (H.REMARK), '') REMARK" ).append("\n"); 
		query.append("          FROM PA H," ).append("\n"); 
		query.append("               RDR_ALLOCATION A" ).append("\n"); 
		query.append("         WHERE H.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("           AND H.VOY_NO = A.VOY_NO" ).append("\n"); 
		query.append("           AND H.DIR_CD = A.DIR_CD" ).append("\n"); 
		query.append("           AND H.REGION = A.REGION" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("           AND H.VSL_CD || H.VOY_NO || H.DIR_CD LIKE H.VVD || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("           AND A.OPR_CD IN (${opr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY A.OPR_CD," ).append("\n"); 
		query.append("                 H.VSL_CD," ).append("\n"); 
		query.append("                 H.VOY_NO," ).append("\n"); 
		query.append("                 H.DIR_CD," ).append("\n"); 
		query.append("                 H.REGION," ).append("\n"); 
		query.append("                 H.PORT_CD," ).append("\n"); 
		query.append("                 H.VPS_ETD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT /* 2.ACTUAL USED, TEU, WT - 1)TEU 2) WT */" ).append("\n"); 
		query.append("               H.VSL_CD," ).append("\n"); 
		query.append("               H.VOY_NO," ).append("\n"); 
		query.append("               H.DIR_CD," ).append("\n"); 
		query.append("               H.REGION," ).append("\n"); 
		query.append("               H.PORT_CD," ).append("\n"); 
		query.append("               A.OPR_CD," ).append("\n"); 
		query.append("               H.VPS_ETD_DT," ).append("\n"); 
		query.append("               0 ALC_ALLOC," ).append("\n"); 
		query.append("               0 ALC_WGT," ).append("\n"); 
		query.append("               0 SWAP_SLOT," ).append("\n"); 
		query.append("               0 SWAP_WGT," ).append("\n"); 
		query.append("                    SUM (DECODE (A.TYPE, 'F', A.SLOT_QTY, 0)) +" ).append("\n"); 
		query.append("                    SUM (DECODE (A.TYPE, 'E', A.SLOT_QTY, 0)) +" ).append("\n"); 
		query.append("                    SUM (DECODE (A.TYPE, 'A', A.SLOT_QTY, 0)) +" ).append("\n"); 
		query.append("                    SUM (DECODE (A.TYPE, 'H', A.SLOT_QTY, 'L', A.SLOT_QTY, 0)) ACT_SLOT," ).append("\n"); 
		query.append("               SUM (A.WEIGHT) ACT_WGT," ).append("\n"); 
		query.append("               0 LOAD_20," ).append("\n"); 
		query.append("               0 BSA_HC20," ).append("\n"); 
		query.append("               0 LOAD_40," ).append("\n"); 
		query.append("               0 BSA_HC40," ).append("\n"); 
		query.append("               0 LOAD_45," ).append("\n"); 
		query.append("               0 BSA_45," ).append("\n"); 
		query.append("               0 R_O," ).append("\n"); 
		query.append("               0 R_I," ).append("\n"); 
		query.append("               SUM (DECODE (A.TYPE, 'E', A.SLOT_QTY, 0)) EMPTY_TEU," ).append("\n"); 
		query.append("               SUM (A.WEIGHT) EMPTY_WT," ).append("\n"); 
		query.append("               NVL (MAX (H.REMARK), '') REMARK" ).append("\n"); 
		query.append("          FROM PA H," ).append("\n"); 
		query.append("               RDR_UTILIZE A" ).append("\n"); 
		query.append("         WHERE H.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("           AND H.VOY_NO = A.VOY_NO" ).append("\n"); 
		query.append("           AND H.DIR_CD = A.DIR_CD" ).append("\n"); 
		query.append("           AND H.REGION = A.REGION" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("           AND H.VSL_CD || H.VOY_NO || H.DIR_CD LIKE H.VVD || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("           AND A.OPR_CD IN (${opr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY A.OPR_CD," ).append("\n"); 
		query.append("                 H.VSL_CD," ).append("\n"); 
		query.append("                 H.VOY_NO," ).append("\n"); 
		query.append("                 H.DIR_CD," ).append("\n"); 
		query.append("                 H.REGION," ).append("\n"); 
		query.append("                 H.PORT_CD," ).append("\n"); 
		query.append("                 H.VPS_ETD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT /* 3.RF - 1) R-O*/" ).append("\n"); 
		query.append("               H.VSL_CD," ).append("\n"); 
		query.append("               H.VOY_NO," ).append("\n"); 
		query.append("               H.DIR_CD," ).append("\n"); 
		query.append("               H.REGION," ).append("\n"); 
		query.append("               H.PORT_CD," ).append("\n"); 
		query.append("               M.OPR_CD," ).append("\n"); 
		query.append("               H.VPS_ETD_DT," ).append("\n"); 
		query.append("               0 ALC_ALLOC," ).append("\n"); 
		query.append("               0 ALC_WGT," ).append("\n"); 
		query.append("               0 SWAP_SLOT," ).append("\n"); 
		query.append("               0 SWAP_WGT," ).append("\n"); 
		query.append("               0 ACT_SLOT," ).append("\n"); 
		query.append("               0 ACT_WGT," ).append("\n"); 
		query.append("               0 LOAD_20," ).append("\n"); 
		query.append("               0 BSA_HC20," ).append("\n"); 
		query.append("               0 LOAD_40," ).append("\n"); 
		query.append("               0 BSA_HC40," ).append("\n"); 
		query.append("               0 LOAD_45," ).append("\n"); 
		query.append("               0 BSA_45," ).append("\n"); 
		query.append("               SUM (DECODE (M.CNTR_SIZE, '2', 1, '3', 1, 0)) + SUM (DECODE (M.CNTR_SIZE, '4', 1, 'H', 1, 'L', 1, 0)) R_O," ).append("\n"); 
		query.append("               0 R_I," ).append("\n"); 
		query.append("               0 EMPTY_TEU," ).append("\n"); 
		query.append("               0 EMPTY_WT," ).append("\n"); 
		query.append("               NVL (MAX (H.REMARK), '') REMARK" ).append("\n"); 
		query.append("          FROM PA H," ).append("\n"); 
		query.append("               RDR_CNTR_DETAIL M" ).append("\n"); 
		query.append("         WHERE H.VSL_CD = M.VSL_CD" ).append("\n"); 
		query.append("           AND H.VOY_NO = M.VOY_NO" ).append("\n"); 
		query.append("           AND H.DIR_CD = M.DIR_CD" ).append("\n"); 
		query.append("           AND M.TEMP IS NOT NULL" ).append("\n"); 
		query.append("           AND M.CARGO_TYPE != 'IR'" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("           AND H.VSL_CD || H.VOY_NO || H.DIR_CD LIKE H.VVD || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("           AND M.OPR_CD IN (${opr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY M.OPR_CD," ).append("\n"); 
		query.append("                 H.VSL_CD," ).append("\n"); 
		query.append("                 H.VOY_NO," ).append("\n"); 
		query.append("                 H.DIR_CD," ).append("\n"); 
		query.append("                 H.REGION," ).append("\n"); 
		query.append("                 H.PORT_CD," ).append("\n"); 
		query.append("                 H.VPS_ETD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        /*** R-O, 2.Internally ****/" ).append("\n"); 
		query.append("        SELECT H.VSL_CD," ).append("\n"); 
		query.append("               H.VOY_NO," ).append("\n"); 
		query.append("               H.DIR_CD," ).append("\n"); 
		query.append("               H.REGION," ).append("\n"); 
		query.append("               H.PORT_CD," ).append("\n"); 
		query.append("               S.OPR_CD," ).append("\n"); 
		query.append("               H.VPS_ETD_DT," ).append("\n"); 
		query.append("               0 ALC_ALLOC," ).append("\n"); 
		query.append("               0 ALC_WGT," ).append("\n"); 
		query.append("               0 SWAP_SLOT," ).append("\n"); 
		query.append("               0 SWAP_WGT," ).append("\n"); 
		query.append("               0 ACT_SLOT," ).append("\n"); 
		query.append("               0 ACT_WGT," ).append("\n"); 
		query.append("               0 LOAD_20," ).append("\n"); 
		query.append("               0 BSA_HC20," ).append("\n"); 
		query.append("               0 LOAD_40," ).append("\n"); 
		query.append("               0 BSA_HC40," ).append("\n"); 
		query.append("               0 LOAD_45," ).append("\n"); 
		query.append("               0 BSA_45," ).append("\n"); 
		query.append("               SUM (DECODE (S.CNTR_SIZE, '2', QTY, 0)) + SUM (DECODE (S.CNTR_SIZE, '4', QTY, 0)) R_O," ).append("\n"); 
		query.append("               0 R_I," ).append("\n"); 
		query.append("               0 EMPTY_TEU," ).append("\n"); 
		query.append("               0 EMPTY_WT," ).append("\n"); 
		query.append("               NVL (MAX (H.REMARK), '') REMARK" ).append("\n"); 
		query.append("          FROM PA H," ).append("\n"); 
		query.append("               RDR_SUMMARY S" ).append("\n"); 
		query.append("         WHERE H.VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("           AND H.VOY_NO = S.VOY_NO" ).append("\n"); 
		query.append("           AND H.DIR_CD = S.DIR_CD" ).append("\n"); 
		query.append("           AND H.REGION = S.REGION" ).append("\n"); 
		query.append("           AND H.VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("           AND H.VOY_NO = S.VOY_NO" ).append("\n"); 
		query.append("           AND H.DIR_CD = S.DIR_CD" ).append("\n"); 
		query.append("           AND H.REGION = S.REGION" ).append("\n"); 
		query.append("           AND S.CNTR_TYPE = 'T'" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("           AND H.VSL_CD || H.VOY_NO || H.DIR_CD LIKE H.VVD || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("           AND S.OPR_CD IN (${opr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY S.OPR_CD," ).append("\n"); 
		query.append("                 H.VSL_CD," ).append("\n"); 
		query.append("                 H.VOY_NO," ).append("\n"); 
		query.append("                 H.DIR_CD," ).append("\n"); 
		query.append("                 H.REGION," ).append("\n"); 
		query.append("                 H.PORT_CD," ).append("\n"); 
		query.append("                 H.VPS_ETD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT /* 3.RF - 1) R-I*/" ).append("\n"); 
		query.append("               H.VSL_CD," ).append("\n"); 
		query.append("               H.VOY_NO," ).append("\n"); 
		query.append("               H.DIR_CD," ).append("\n"); 
		query.append("               H.REGION," ).append("\n"); 
		query.append("               H.PORT_CD," ).append("\n"); 
		query.append("               M.OPR_CD," ).append("\n"); 
		query.append("               H.VPS_ETD_DT," ).append("\n"); 
		query.append("               0 ALC_ALLOC," ).append("\n"); 
		query.append("               0 ALC_WGT," ).append("\n"); 
		query.append("               0 SWAP_SLOT," ).append("\n"); 
		query.append("               0 SWAP_WGT," ).append("\n"); 
		query.append("               0 ACT_SLOT," ).append("\n"); 
		query.append("               0 ACT_WGT," ).append("\n"); 
		query.append("               0 LOAD_20," ).append("\n"); 
		query.append("               0 BSA_HC20," ).append("\n"); 
		query.append("               0 LOAD_40," ).append("\n"); 
		query.append("               0 BSA_HC40," ).append("\n"); 
		query.append("               0 LOAD_45," ).append("\n"); 
		query.append("               0 BSA_45," ).append("\n"); 
		query.append("               0 R_O," ).append("\n"); 
		query.append("               SUM (DECODE (M.CNTR_SIZE, '2', 1, '3', 1, 0)) + SUM (DECODE (M.CNTR_SIZE, '4', 1, 'H', 1, 'L', 1, 0)) R_I," ).append("\n"); 
		query.append("               0 EMPTY_TEU," ).append("\n"); 
		query.append("               0 EMPTY_WT," ).append("\n"); 
		query.append("               NVL (MAX (H.REMARK), '') REMARK" ).append("\n"); 
		query.append("          FROM PA H," ).append("\n"); 
		query.append("               RDR_CNTR_DETAIL M" ).append("\n"); 
		query.append("         WHERE H.VSL_CD = M.VSL_CD" ).append("\n"); 
		query.append("           AND H.VOY_NO = M.VOY_NO" ).append("\n"); 
		query.append("           AND H.DIR_CD = M.DIR_CD" ).append("\n"); 
		query.append("           AND M.TEMP IS NOT NULL" ).append("\n"); 
		query.append("           AND M.CARGO_TYPE = 'IR'" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("           AND H.VSL_CD || H.VOY_NO || H.DIR_CD LIKE H.VVD || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("           AND M.OPR_CD IN (${opr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY M.OPR_CD," ).append("\n"); 
		query.append("                 H.VSL_CD," ).append("\n"); 
		query.append("                 H.VOY_NO," ).append("\n"); 
		query.append("                 H.DIR_CD," ).append("\n"); 
		query.append("                 H.REGION," ).append("\n"); 
		query.append("                 H.PORT_CD," ).append("\n"); 
		query.append("                 H.VPS_ETD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT /* 3.RF - 1) R-I INTERNAL*/" ).append("\n"); 
		query.append("               H.VSL_CD," ).append("\n"); 
		query.append("               H.VOY_NO," ).append("\n"); 
		query.append("               H.DIR_CD," ).append("\n"); 
		query.append("               H.REGION," ).append("\n"); 
		query.append("               H.PORT_CD," ).append("\n"); 
		query.append("               S.OPR_CD," ).append("\n"); 
		query.append("               H.VPS_ETD_DT," ).append("\n"); 
		query.append("               0 ALC_ALLOC," ).append("\n"); 
		query.append("               0 ALC_WGT," ).append("\n"); 
		query.append("               0 SWAP_SLOT," ).append("\n"); 
		query.append("               0 SWAP_WGT," ).append("\n"); 
		query.append("               0 ACT_SLOT," ).append("\n"); 
		query.append("               0 ACT_WGT," ).append("\n"); 
		query.append("               0 LOAD_20," ).append("\n"); 
		query.append("               0 BSA_HC20," ).append("\n"); 
		query.append("               0 LOAD_40," ).append("\n"); 
		query.append("               0 BSA_HC40," ).append("\n"); 
		query.append("               0 LOAD_45," ).append("\n"); 
		query.append("               0 BSA_45," ).append("\n"); 
		query.append("               0 R_O," ).append("\n"); 
		query.append("               SUM (DECODE (S.CNTR_SIZE, '2', QTY, 0)) + SUM (DECODE (S.CNTR_SIZE, '4', QTY, 0)) R_I," ).append("\n"); 
		query.append("               0 EMPTY_TEU," ).append("\n"); 
		query.append("               0 EMPTY_WT," ).append("\n"); 
		query.append("               NVL (MAX (H.REMARK), '') REMARK" ).append("\n"); 
		query.append("          FROM PA H," ).append("\n"); 
		query.append("               RDR_SUMMARY S" ).append("\n"); 
		query.append("         WHERE H.VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("           AND H.VOY_NO = S.VOY_NO" ).append("\n"); 
		query.append("           AND H.DIR_CD = S.DIR_CD" ).append("\n"); 
		query.append("           AND H.VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("           AND H.VOY_NO = S.VOY_NO" ).append("\n"); 
		query.append("           AND H.DIR_CD = S.DIR_CD" ).append("\n"); 
		query.append("           AND H.REGION = S.REGION" ).append("\n"); 
		query.append("           AND S.CNTR_TYPE = 'I'" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("           AND H.VSL_CD || H.VOY_NO || H.DIR_CD LIKE H.VVD || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("           AND S.OPR_CD IN (${opr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY S.OPR_CD," ).append("\n"); 
		query.append("                 H.VSL_CD," ).append("\n"); 
		query.append("                 H.VOY_NO," ).append("\n"); 
		query.append("                 H.DIR_CD," ).append("\n"); 
		query.append("                 H.REGION," ).append("\n"); 
		query.append("                 H.PORT_CD," ).append("\n"); 
		query.append("                 H.VPS_ETD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        /* 4.20HC, 40HC, 45*/" ).append("\n"); 
		query.append("        SELECT --DISTINCT" ).append("\n"); 
		query.append("               H.VSL_CD," ).append("\n"); 
		query.append("               H.VOY_NO," ).append("\n"); 
		query.append("               H.DIR_CD," ).append("\n"); 
		query.append("               H.REGION," ).append("\n"); 
		query.append("               H.PORT_CD," ).append("\n"); 
		query.append("               DECODE (M.OPR_CD, NULL, B.OPR_CD, M.OPR_CD) OPR_CD," ).append("\n"); 
		query.append("               H.VPS_ETD_DT," ).append("\n"); 
		query.append("               0 ALC_ALLOC," ).append("\n"); 
		query.append("               0 ALC_WGT," ).append("\n"); 
		query.append("               0 SWAP_SLOT," ).append("\n"); 
		query.append("               0 SWAP_WGT," ).append("\n"); 
		query.append("               0 ACT_SLOT," ).append("\n"); 
		query.append("               0 ACT_WGT," ).append("\n"); 
		query.append("               SUM (DECODE (M.TYPE, 'F', M.SLOT_HC20, 'E', M.SLOT_HC20, 0)) LOAD_20," ).append("\n"); 
		query.append("               TO_NUMBER (NVL (B.HC20_QTY, 0)) BSA_HC20," ).append("\n"); 
		query.append("               SUM (NVL (M.SLOT_HC, 0)) LOAD_40," ).append("\n"); 
		query.append("               TO_NUMBER (NVL (B.HC_QTY, 0)) BSA_HC40," ).append("\n"); 
		query.append("               SUM (NVL (M.SLOT_45, 0)) LOAD_45," ).append("\n"); 
		query.append("               TO_NUMBER (NVL (B.QTY_45, 0)) BSA_45," ).append("\n"); 
		query.append("               0 R_O," ).append("\n"); 
		query.append("               0 R_I," ).append("\n"); 
		query.append("               0 EMPTY_TEU," ).append("\n"); 
		query.append("               0 EMPTY_WT," ).append("\n"); 
		query.append("               NVL (MAX (H.REMARK), '') REMARK" ).append("\n"); 
		query.append("          FROM PA H," ).append("\n"); 
		query.append("               RDR_BSA B," ).append("\n"); 
		query.append("               RDR_UTILIZE M" ).append("\n"); 
		query.append("         WHERE H.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("           AND H.VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("           AND H.DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("           AND H.REGION = B.REGION" ).append("\n"); 
		query.append("           AND H.VSL_CD = M.VSL_CD" ).append("\n"); 
		query.append("           AND H.VOY_NO = M.VOY_NO" ).append("\n"); 
		query.append("           AND H.DIR_CD = M.DIR_CD" ).append("\n"); 
		query.append("           AND H.REGION = M.REGION" ).append("\n"); 
		query.append("           AND DECODE (M.OPR_CD, NULL, 'N', B.OPR_CD) = NVL (M.OPR_CD, 'N')" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("           AND H.VSL_CD || H.VOY_NO || H.DIR_CD LIKE H.VVD || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("           AND M.OPR_CD IN (${opr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY M.OPR_CD," ).append("\n"); 
		query.append("                 B.OPR_CD," ).append("\n"); 
		query.append("                 NVL (B.HC20_RAT, 0)," ).append("\n"); 
		query.append("                 NVL (B.HC_RAT, 0)," ).append("\n"); 
		query.append("                 NVL (B.UN_RAT_45, 0)," ).append("\n"); 
		query.append("                 NVL (B.OV_RAT_45, 0)," ).append("\n"); 
		query.append("                 NVL (B.HC20_QTY, 0)," ).append("\n"); 
		query.append("                 NVL (B.HC_QTY, 0)," ).append("\n"); 
		query.append("                 NVL (B.QTY_45, 0)," ).append("\n"); 
		query.append("                 H.VSL_CD," ).append("\n"); 
		query.append("                 H.VOY_NO," ).append("\n"); 
		query.append("                 H.DIR_CD," ).append("\n"); 
		query.append("                 H.REGION," ).append("\n"); 
		query.append("                 H.PORT_CD," ).append("\n"); 
		query.append("                 H.VPS_ETD_DT) Z," ).append("\n"); 
		query.append("       JOO_RDR_VVD_CRR_RMK R" ).append("\n"); 
		query.append(" WHERE Z.VSL_CD = R.VSL_CD(+)" ).append("\n"); 
		query.append("   AND Z.VOY_NO = R.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND Z.DIR_CD = R.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND Z.REGION = R.JO_RGN_CD(+)" ).append("\n"); 
		query.append("   AND Z.PORT_CD = R.PORT_CD(+)" ).append("\n"); 
		query.append("   AND Z.OPR_CD = R.JO_CRR_CD(+)" ).append("\n"); 
		query.append(" GROUP BY Z.VSL_CD," ).append("\n"); 
		query.append("          Z.VOY_NO," ).append("\n"); 
		query.append("          Z.DIR_CD," ).append("\n"); 
		query.append("          Z.REGION," ).append("\n"); 
		query.append("          Z.PORT_CD," ).append("\n"); 
		query.append("          Z.OPR_CD," ).append("\n"); 
		query.append("          Z.VPS_ETD_DT," ).append("\n"); 
		query.append("          Z.REMARK," ).append("\n"); 
		query.append("          R.JO_SHRT_LEG_RMK_TEU_QTY," ).append("\n"); 
		query.append("          R.JO_SHRT_LEG_RMK_WGT," ).append("\n"); 
		query.append("          R.JO_SLT_RLSE_CD," ).append("\n"); 
		query.append("          R.JO_SHRT_LEG_RMK_DIFF_QTY," ).append("\n"); 
		query.append("          R.JO_RF_OCN_QTY," ).append("\n"); 
		query.append("          R.JO_RF_IPT_QTY," ).append("\n"); 
		query.append("          R.JO_VOID_TEU_QTY" ).append("\n"); 
		query.append(" ORDER BY Z.VSL_CD," ).append("\n"); 
		query.append("          Z.VOY_NO," ).append("\n"); 
		query.append("          Z.DIR_CD," ).append("\n"); 
		query.append("          Z.REGION," ).append("\n"); 
		query.append("          Z.PORT_CD," ).append("\n"); 
		query.append("          Z.OPR_CD," ).append("\n"); 
		query.append("          Z.VPS_ETD_DT" ).append("\n"); 

	}
}