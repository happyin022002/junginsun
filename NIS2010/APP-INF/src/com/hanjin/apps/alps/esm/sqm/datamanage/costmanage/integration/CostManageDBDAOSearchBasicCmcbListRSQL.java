/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CostManageDBDAOSearchBasicCmcbListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.11 
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

public class CostManageDBDAOSearchBasicCmcbListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic CMCB Data 를 조회
	  * 2015.10.19 김용습 [CHM-201538305] [CSR 전환건] Basic CMCB (CM Cost Per Box) / Basic CMCB for IAS Sector 화면 내 신규 칼럼 추가
	  * 2015.11.06 김용습 [선반영] RPB 계산시 0인 값은 제외하고 평균값 구하도록 함
	  * </pre>
	  */
	public CostManageDBDAOSearchBasicCmcbListRSQL(){
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
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOSearchBasicCmcbListRSQL").append("\n"); 
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
		query.append("SELECT A2.BSE_YR" ).append("\n"); 
		query.append("        ,A2.BSE_QTR_CD" ).append("\n"); 
		query.append("        ,A2.OFC_VW_CD" ).append("\n"); 
		query.append("        ,A2.TRD_CD" ).append("\n"); 
		query.append("        ,A2.RLANE_CD" ).append("\n"); 
		query.append("        ,A2.DIR_CD" ).append("\n"); 
		query.append("        ,A2.RHQ_CD" ).append("\n"); 
		query.append("        ,A2.RGN_OFC_CD" ).append("\n"); 
		query.append("        ,A2.GID_PA_CM_XCLD_EQ_UC_AMT" ).append("\n"); 
		query.append("        ,A2.GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,A2.GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,(SELECT AVG(CFM.GRS_RPB_REV) " ).append("\n"); 
		query.append("            FROM SQM_CFM_QTA CFM " ).append("\n"); 
		query.append("            WHERE CFM.QTA_RLSE_VER_NO = SUBSTR(A1.BSE_YR,-2)||DECODE(A1.BSE_TP_CD, 'Y', '00', A1.BSE_QTR_CD)||'01'" ).append("\n"); 
		query.append("            AND CFM.BSE_TP_CD = A1.BSE_TP_CD" ).append("\n"); 
		query.append("            AND CFM.BSE_YR = A1.BSE_YR" ).append("\n"); 
		query.append("            AND CFM.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND CFM.OFC_VW_CD = A1.OFC_VW_CD" ).append("\n"); 
		query.append("            AND CFM.QTA_TGT_CD = 'D'" ).append("\n"); 
		query.append("            AND CFM.TRD_CD = A1.TRD_CD" ).append("\n"); 
		query.append("            AND CFM.RLANE_CD = A1.RLANE_CD " ).append("\n"); 
		query.append("            AND CFM.DIR_CD = A1.DIR_CD" ).append("\n"); 
		query.append("            AND CFM.RHQ_CD = A1.RHQ_CD" ).append("\n"); 
		query.append("            AND CFM.RGN_OFC_CD = A1.RGN_OFC_CD" ).append("\n"); 
		query.append("            AND CFM.GRS_RPB_REV != 0) AS INITIAL_RPB" ).append("\n"); 
		query.append("        ,(SELECT AVG(CFM.GRS_RPB_REV - CFM.RA_CM_UC_AMT) " ).append("\n"); 
		query.append("            FROM SQM_CFM_QTA CFM " ).append("\n"); 
		query.append("            WHERE CFM.QTA_RLSE_VER_NO = SUBSTR(A1.BSE_YR,-2)||DECODE(A1.BSE_TP_CD, 'Y', '00', A1.BSE_QTR_CD)||'01'" ).append("\n"); 
		query.append("            AND CFM.BSE_TP_CD = A1.BSE_TP_CD" ).append("\n"); 
		query.append("            AND CFM.BSE_YR = A1.BSE_YR" ).append("\n"); 
		query.append("            AND CFM.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND CFM.OFC_VW_CD = A1.OFC_VW_CD" ).append("\n"); 
		query.append("            AND CFM.QTA_TGT_CD = 'D'" ).append("\n"); 
		query.append("            AND CFM.TRD_CD = A1.TRD_CD" ).append("\n"); 
		query.append("            AND CFM.RLANE_CD = A1.RLANE_CD " ).append("\n"); 
		query.append("            AND CFM.DIR_CD = A1.DIR_CD" ).append("\n"); 
		query.append("            AND CFM.RHQ_CD = A1.RHQ_CD" ).append("\n"); 
		query.append("            AND CFM.RGN_OFC_CD = A1.RGN_OFC_CD" ).append("\n"); 
		query.append("            AND CFM.GRS_RPB_REV != 0) AS INITIAL_CMPB_RA" ).append("\n"); 
		query.append("        ,A2.PA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,A2.RA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,(SELECT AVG(CFM.GRS_RPB_REV) " ).append("\n"); 
		query.append("            FROM SQM_CFM_QTA CFM " ).append("\n"); 
		query.append("            WHERE CFM.QTA_RLSE_VER_NO = SUBSTR(A1.BSE_YR,-2)||DECODE(A1.BSE_TP_CD, 'Y', '00', A1.BSE_QTR_CD)||'02'" ).append("\n"); 
		query.append("            AND CFM.BSE_TP_CD = A1.BSE_TP_CD" ).append("\n"); 
		query.append("            AND CFM.BSE_YR = A1.BSE_YR" ).append("\n"); 
		query.append("            AND CFM.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND CFM.OFC_VW_CD = A1.OFC_VW_CD" ).append("\n"); 
		query.append("            AND CFM.QTA_TGT_CD = 'D'" ).append("\n"); 
		query.append("            AND CFM.TRD_CD = A1.TRD_CD" ).append("\n"); 
		query.append("            AND CFM.RLANE_CD = A1.RLANE_CD " ).append("\n"); 
		query.append("            AND CFM.DIR_CD = A1.DIR_CD" ).append("\n"); 
		query.append("            AND CFM.RHQ_CD = A1.RHQ_CD" ).append("\n"); 
		query.append("            AND CFM.RGN_OFC_CD = A1.RGN_OFC_CD" ).append("\n"); 
		query.append("            AND CFM.GRS_RPB_REV != 0) AS CURRENT_RPB" ).append("\n"); 
		query.append("        ,(SELECT AVG(CFM.GRS_RPB_REV - CFM.RA_CM_UC_AMT) " ).append("\n"); 
		query.append("            FROM SQM_CFM_QTA CFM " ).append("\n"); 
		query.append("            WHERE CFM.QTA_RLSE_VER_NO = SUBSTR(A1.BSE_YR,-2)||DECODE(A1.BSE_TP_CD, 'Y', '00', A1.BSE_QTR_CD)||'02'" ).append("\n"); 
		query.append("            AND CFM.BSE_TP_CD = A1.BSE_TP_CD" ).append("\n"); 
		query.append("            AND CFM.BSE_YR = A1.BSE_YR" ).append("\n"); 
		query.append("            AND CFM.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND CFM.OFC_VW_CD = A1.OFC_VW_CD" ).append("\n"); 
		query.append("            AND CFM.QTA_TGT_CD = 'D'" ).append("\n"); 
		query.append("            AND CFM.TRD_CD = A1.TRD_CD" ).append("\n"); 
		query.append("            AND CFM.RLANE_CD = A1.RLANE_CD " ).append("\n"); 
		query.append("            AND CFM.DIR_CD = A1.DIR_CD" ).append("\n"); 
		query.append("            AND CFM.RHQ_CD = A1.RHQ_CD" ).append("\n"); 
		query.append("            AND CFM.RGN_OFC_CD = A1.RGN_OFC_CD" ).append("\n"); 
		query.append("            AND CFM.GRS_RPB_REV != 0) AS CURRENT_CMPB_RA" ).append("\n"); 
		query.append("    FROM SQM_QTA_LANE_OFC      A1" ).append("\n"); 
		query.append("        ,SQM_QTA_LANE_OFC_COST A2" ).append("\n"); 
		query.append("   WHERE A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("     AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND A1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("     AND A1.OFC_VW_CD   = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("     AND A1.TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("     AND A1.RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("     AND A1.DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("     AND A1.RGN_OFC_CD  = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("     AND A1.RHQ_CD      = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND A1.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("     AND A1.BSE_TP_CD   = A2.BSE_TP_CD" ).append("\n"); 
		query.append("     AND A1.BSE_YR      = A2.BSE_YR" ).append("\n"); 
		query.append("     AND A1.BSE_QTR_CD  = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("     AND A1.OFC_VW_CD   = A2.OFC_VW_CD" ).append("\n"); 
		query.append("     AND A1.TRD_CD      = A2.TRD_CD" ).append("\n"); 
		query.append("     AND A1.RLANE_CD    = A2.RLANE_CD" ).append("\n"); 
		query.append("     AND A1.DIR_CD      = A2.DIR_CD" ).append("\n"); 
		query.append("     AND A1.RHQ_CD      = A2.RHQ_CD" ).append("\n"); 
		query.append("     AND A1.RGN_OFC_CD  = A2.RGN_OFC_CD" ).append("\n"); 
		query.append("ORDER BY A2.BSE_YR" ).append("\n"); 
		query.append("        ,A2.BSE_QTR_CD" ).append("\n"); 
		query.append("        ,A2.OFC_VW_CD" ).append("\n"); 
		query.append("        ,A2.TRD_CD" ).append("\n"); 
		query.append("        ,A2.RLANE_CD" ).append("\n"); 
		query.append("        ,A2.DIR_CD" ).append("\n"); 
		query.append("        ,A2.RHQ_CD" ).append("\n"); 
		query.append("        ,A2.RGN_OFC_CD" ).append("\n"); 

	}
}