/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostManageDBDAOSearchBasicCmcbForIasSectorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostManageDBDAOSearchBasicCmcbForIasSectorListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic CMCB for IAS Sector List를 조회한다.
	  * 
	  * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2015.09.14 김용습 [CHM-201537774] Basic CMCB (CM Cost Per Box)와 Basic CMCB for IAS Sector 두 화면 내 신규 칼럼 추가 (sector lane-office에서 active된 사항을 보여주는 컬럼 추가)
	  * 2015.10.19 김용습 [CHM-201538305] Basic CMCB (CM Cost Per Box) / Basic CMCB for IAS Sector 화면 내 신규 칼럼 추가
	  * 2015.11.06 김용습 [선반영] RPB 계산시 0인 값은 제외하고 평균값 구하도록 함
	  * </pre>
	  */
	public CostManageDBDAOSearchBasicCmcbForIasSectorListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOSearchBasicCmcbForIasSectorListRSQL").append("\n"); 
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
		query.append("WITH BB AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT * FROM " ).append("\n"); 
		query.append("(SELECT BSE_TP_CD, BSE_YR, BSE_QTR_CD, RLANE_CD, DIR_CD, POL_CD, POD_CD, TRD_CD, SQM_ACT_FLG" ).append("\n"); 
		query.append("        FROM SQM_SCTR_LANE_OFC " ).append("\n"); 
		query.append("        GROUP BY BSE_TP_CD, BSE_YR, BSE_QTR_CD, RLANE_CD, DIR_CD, POL_CD, POD_CD, TRD_CD, SQM_ACT_FLG" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHERE SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("            AND BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("            AND BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append("            AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("            #if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("            AND DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("            AND RLANE_CD IN (${f_rlane_cd})" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')" ).append("\n"); 
		query.append("            AND POL_CD = @[f_pol_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')" ).append("\n"); 
		query.append("            AND POD_CD = @[f_pod_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		WHERE INTG_CD_ID = 'CD03218'" ).append("\n"); 
		query.append("		AND INTG_CD_VAL_CTNT = A2.IAS_RGN_CD) IAS_RGN_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.POL_CD" ).append("\n"); 
		query.append("      ,A1.POD_CD" ).append("\n"); 
		query.append("      ,A1.GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,A1.GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append("#if (${f_chk_rpb_cmpb} != '')" ).append("\n"); 
		query.append("      ,(SELECT MIN(GRS_RPB_REV) FROM SQM_SCTR_CFM_QTA CFM" ).append("\n"); 
		query.append("        WHERE CFM.QTA_RLSE_VER_NO = SUBSTR(A1.BSE_YR,-2)||DECODE(A1.BSE_QTR_CD, 'Y', '00', A1.BSE_QTR_CD)||'01'" ).append("\n"); 
		query.append("        AND CFM.BSE_TP_CD = A1.BSE_TP_CD" ).append("\n"); 
		query.append("        AND CFM.BSE_YR = A1.BSE_YR" ).append("\n"); 
		query.append("        AND CFM.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND CFM.TRD_CD = A1.TRD_CD" ).append("\n"); 
		query.append("        AND CFM.RLANE_CD = A1.RLANE_CD" ).append("\n"); 
		query.append("        AND CFM.DIR_CD = A1.DIR_CD" ).append("\n"); 
		query.append("        AND CFM.POL_CD = A1.POL_CD" ).append("\n"); 
		query.append("        AND CFM.POD_CD = A1.POD_CD" ).append("\n"); 
		query.append("        AND CFM.GRS_RPB_REV != 0) AS INITIAL_RPB" ).append("\n"); 
		query.append("      ,(SELECT MIN(GRS_RPB_REV)-MIN(RA_CM_UC_AMT) FROM SQM_SCTR_CFM_QTA CFM" ).append("\n"); 
		query.append("        WHERE CFM.QTA_RLSE_VER_NO = SUBSTR(A1.BSE_YR,-2)||DECODE(A1.BSE_QTR_CD, 'Y', '00', A1.BSE_QTR_CD)||'01'" ).append("\n"); 
		query.append("        AND CFM.BSE_TP_CD = A1.BSE_TP_CD" ).append("\n"); 
		query.append("        AND CFM.BSE_YR = A1.BSE_YR" ).append("\n"); 
		query.append("        AND CFM.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND CFM.TRD_CD = A1.TRD_CD" ).append("\n"); 
		query.append("        AND CFM.RLANE_CD = A1.RLANE_CD" ).append("\n"); 
		query.append("        AND CFM.DIR_CD = A1.DIR_CD" ).append("\n"); 
		query.append("        AND CFM.POL_CD = A1.POL_CD" ).append("\n"); 
		query.append("        AND CFM.POD_CD = A1.POD_CD" ).append("\n"); 
		query.append("        AND CFM.GRS_RPB_REV != 0) AS INITIAL_CMPB_RA" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,NVL(A1.PA_CM_UC_AMT, A1.GID_PA_CM_UC_AMT) PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,NVL(A1.RA_CM_UC_AMT, A1.GID_RA_CM_UC_AMT) RA_CM_UC_AMT" ).append("\n"); 
		query.append("#if (${f_chk_rpb_cmpb} != '')" ).append("\n"); 
		query.append("      ,(SELECT MIN(GRS_RPB_REV) FROM SQM_SCTR_CFM_QTA CFM" ).append("\n"); 
		query.append("        WHERE CFM.QTA_RLSE_VER_NO = SUBSTR(A1.BSE_YR,-2)||DECODE(A1.BSE_QTR_CD, 'Y', '00', A1.BSE_QTR_CD)||'02'" ).append("\n"); 
		query.append("        AND CFM.BSE_TP_CD = A1.BSE_TP_CD" ).append("\n"); 
		query.append("        AND CFM.BSE_YR = A1.BSE_YR" ).append("\n"); 
		query.append("        AND CFM.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND CFM.TRD_CD = A1.TRD_CD" ).append("\n"); 
		query.append("        AND CFM.RLANE_CD = A1.RLANE_CD" ).append("\n"); 
		query.append("        AND CFM.DIR_CD = A1.DIR_CD" ).append("\n"); 
		query.append("        AND CFM.POL_CD = A1.POL_CD" ).append("\n"); 
		query.append("        AND CFM.POD_CD = A1.POD_CD" ).append("\n"); 
		query.append("        AND CFM.GRS_RPB_REV != 0) AS CURRENT_RPB" ).append("\n"); 
		query.append("      ,(SELECT MIN(GRS_RPB_REV)-MIN(RA_CM_UC_AMT) FROM SQM_SCTR_CFM_QTA CFM" ).append("\n"); 
		query.append("        WHERE CFM.QTA_RLSE_VER_NO = SUBSTR(A1.BSE_YR,-2)||DECODE(A1.BSE_QTR_CD, 'Y', '00', A1.BSE_QTR_CD)||'02'" ).append("\n"); 
		query.append("        AND CFM.BSE_TP_CD = A1.BSE_TP_CD" ).append("\n"); 
		query.append("        AND CFM.BSE_YR = A1.BSE_YR" ).append("\n"); 
		query.append("        AND CFM.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND CFM.TRD_CD = A1.TRD_CD" ).append("\n"); 
		query.append("        AND CFM.RLANE_CD = A1.RLANE_CD" ).append("\n"); 
		query.append("        AND CFM.DIR_CD = A1.DIR_CD" ).append("\n"); 
		query.append("        AND CFM.POL_CD = A1.POL_CD" ).append("\n"); 
		query.append("        AND CFM.POD_CD = A1.POD_CD" ).append("\n"); 
		query.append("        AND CFM.GRS_RPB_REV != 0) AS CURRENT_CMPB_RA" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,B.SQM_ACT_FLG" ).append("\n"); 
		query.append("FROM SQM_SCTR_PAIR_COST A1, MAS_LANE_RGST A2, BB B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A1.TRD_CD = A2.TRD_CD" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD = A2.SUB_TRD_CD" ).append("\n"); 
		query.append("AND A1.RLANE_CD = A2.RLANE_CD" ).append("\n"); 
		query.append("AND A1.DIR_CD = A2.DIR_CD" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("AND A1.BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.RLANE_CD IN (${f_rlane_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.POL_CD = @[f_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.POD_CD = @[f_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')" ).append("\n"); 
		query.append("AND A2.IAS_RGN_CD = @[f_ias_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A1.TRD_CD       = B.TRD_CD (+)" ).append("\n"); 
		query.append("AND A1.RLANE_CD     = B.RLANE_CD (+)" ).append("\n"); 
		query.append("AND A1.DIR_CD       = B.DIR_CD (+)" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD    = B.BSE_TP_CD (+)" ).append("\n"); 
		query.append("AND A1.BSE_YR       = B.BSE_YR (+)" ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD   = B.BSE_QTR_CD (+)" ).append("\n"); 
		query.append("AND A1.RLANE_CD     = B.RLANE_CD (+)" ).append("\n"); 
		query.append("AND A1.POL_CD       = B.POL_CD (+)" ).append("\n"); 
		query.append("AND A1.POD_CD       = B.POD_CD (+)" ).append("\n"); 
		query.append("ORDER BY A1.RLANE_CD, A1.DIR_CD, A1.POL_CD, A1.POD_CD" ).append("\n"); 

	}
}