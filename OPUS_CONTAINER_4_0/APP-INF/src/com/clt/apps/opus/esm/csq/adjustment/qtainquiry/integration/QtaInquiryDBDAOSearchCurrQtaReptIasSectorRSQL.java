/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaInquiryDBDAOSearchCurrQtaReptIasSectorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtainquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaInquiryDBDAOSearchCurrQtaReptIasSectorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * QTA Inquiry_Yearly, Quarterly Current QTA Report for IAS Sector List를 조회한다.
	  * </pre>
	  */
	public QtaInquiryDBDAOSearchCurrQtaReptIasSectorRSQL(){
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
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_csq_mn_sctr_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtainquiry.integration").append("\n"); 
		query.append("FileName : QtaInquiryDBDAOSearchCurrQtaReptIasSectorRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("      A1.BSE_YR" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC AS NAME" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID  = 'CD00940'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = A1.OFC_VW_CD) OFC_VW_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A3.BSE_MON" ).append("\n"); 
		query.append("#if (${f_chk_week} == 'W')      " ).append("\n"); 
		query.append("      ,A3.BSE_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_chk_vvd} == 'V' )      " ).append("\n"); 
		query.append("      ,A1.VSL_CD||A1.SKD_VOY_NO||A1.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,A3.TOT_BSA_CAPA" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '02')   " ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_lvl} == '03') " ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_chk_pair} == 'Y')" ).append("\n"); 
		query.append("      ,A1.POL_CD" ).append("\n"); 
		query.append("      ,A1.POD_CD" ).append("\n"); 
		query.append("      ,DECODE(NVL(A2.CSQ_MN_SCTR_FLG, 'N'), 'Y', 'Main', 'N', 'Sector') CSQ_MN_SCTR_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,SUM(A1.LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("      ,DECODE(SUM(A1.LOD_QTY),0,0, SUM(A1.LOD_QTY * A1.GRS_RPB_REV)/SUM(A1.LOD_QTY)) AS REV_RPB" ).append("\n"); 
		query.append("      ,SUM(A1.LOD_QTY * A1.GRS_RPB_REV) AS GRS_REV" ).append("\n"); 
		query.append("      ,SUM(A1.PA_CM_UC_AMT * A1.LOD_QTY) PA_CM_COST" ).append("\n"); 
		query.append("      ,SUM(A1.RA_CM_UC_AMT * A1.LOD_QTY) RA_CM_COST" ).append("\n"); 
		query.append("      ,DECODE(SUM(A1.LOD_QTY),0,0, (SUM(A1.PA_CM_UC_AMT * A1.LOD_QTY) / SUM(A1.LOD_QTY))) AS PA_CMCB" ).append("\n"); 
		query.append("      ,DECODE(SUM(A1.LOD_QTY),0,0, (SUM(A1.RA_CM_UC_AMT * A1.LOD_QTY) / SUM(A1.LOD_QTY))) AS RA_CMCB" ).append("\n"); 
		query.append("      ,SUM(A1.LOD_QTY * A1.GRS_RPB_REV) - SUM(A1.PA_CM_UC_AMT * A1.LOD_QTY) AS PA_CM" ).append("\n"); 
		query.append("      ,SUM(A1.LOD_QTY * A1.GRS_RPB_REV) - SUM(A1.RA_CM_UC_AMT * A1.LOD_QTY) AS RA_CM" ).append("\n"); 
		query.append("      ,DECODE(SUM(A1.LOD_QTY),0,0, (SUM(A1.LOD_QTY * A1.GRS_RPB_REV) - SUM(A1.PA_CM_UC_AMT*A1.LOD_QTY))/SUM(A1.LOD_QTY)) AS PA_CMPB" ).append("\n"); 
		query.append("      ,DECODE(SUM(A1.LOD_QTY),0,0, (SUM(A1.LOD_QTY * A1.GRS_RPB_REV) - SUM(A1.RA_CM_UC_AMT*A1.LOD_QTY))/SUM(A1.LOD_QTY)) AS RA_CMPB " ).append("\n"); 
		query.append("FROM CSQ_SCTR_CFM_QTA A1" ).append("\n"); 
		query.append("#if (${f_chk_pair} == 'Y')" ).append("\n"); 
		query.append("     ,CSQ_SCTR_PAIR_MGMT A2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     ,(SELECT BSE_TP_CD" ).append("\n"); 
		query.append("              ,BSE_YR" ).append("\n"); 
		query.append("              ,BSE_QTR_CD" ).append("\n"); 
		query.append("              ,TRD_CD" ).append("\n"); 
		query.append("              ,RLANE_CD" ).append("\n"); 
		query.append("              ,DIR_CD" ).append("\n"); 
		query.append("              ,VSL_CD" ).append("\n"); 
		query.append("              ,SKD_VOY_NO" ).append("\n"); 
		query.append("              ,SKD_DIR_CD" ).append("\n"); 
		query.append("#if(${f_chk_week} == 'W' && ${f_chk_vvd} == 'V')" ).append("\n"); 
		query.append("              ,SUM(FNL_BSA_CAPA) OVER (PARTITION BY BSE_YR, TRD_CD, SUB_TRD_CD, RLANE_CD, DIR_CD, BSE_MON, BSE_WK, VSL_CD || SKD_VOY_NO || SKD_DIR_CD) AS TOT_BSA_CAPA" ).append("\n"); 
		query.append("#elseif (${f_chk_week} == 'W')" ).append("\n"); 
		query.append("              ,SUM(FNL_BSA_CAPA) OVER (PARTITION BY BSE_YR, TRD_CD, SUB_TRD_CD, RLANE_CD, DIR_CD, BSE_MON, BSE_WK) AS TOT_BSA_CAPA" ).append("\n"); 
		query.append("#elseif (${f_chk_vvd} == 'V')" ).append("\n"); 
		query.append("              ,SUM(FNL_BSA_CAPA) OVER (PARTITION BY BSE_YR, TRD_CD, SUB_TRD_CD, RLANE_CD, DIR_CD, BSE_MON, VSL_CD || SKD_VOY_NO || SKD_DIR_CD) AS TOT_BSA_CAPA" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              ,SUM(FNL_BSA_CAPA) OVER (PARTITION BY BSE_YR, TRD_CD, SUB_TRD_CD, RLANE_CD, DIR_CD, BSE_MON) AS TOT_BSA_CAPA" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ,BSE_MON" ).append("\n"); 
		query.append("              ,SUB_TRD_CD" ).append("\n"); 
		query.append("#if(${f_chk_week} != 'W')" ).append("\n"); 
		query.append("              ,'' AS BSE_WK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              ,BSE_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        FROM CSQ_CFM_TGT_VVD" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND SUBSTR(QTA_RLSE_VER_NO, -2) = '02'" ).append("\n"); 
		query.append("        AND BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("        AND BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append("        AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("        AND SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("        AND RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_week} == 'W')" ).append("\n"); 
		query.append("#if (${f_fm_wk} != '' && ${f_to_wk} != '')" ).append("\n"); 
		query.append("        AND BSE_WK BETWEEN ${f_fm_wk} AND ${f_to_wk}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#if (${f_fm_mon} != '' && ${f_to_mon} != '')" ).append("\n"); 
		query.append("        AND BSE_MON BETWEEN ${f_fm_mon} AND ${f_to_mon}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("        AND DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) A3" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A1.QTA_RLSE_VER_NO = DECODE(@[f_bse_tp_cd], 'Y', SUBSTR(@[f_bse_yr], 3)||'0002', SUBSTR(@[f_bse_yr], 3)||@[f_bse_qtr_cd]||'02')" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("AND A1.BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("AND A1.OFC_VW_CD = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.DIR_CD   = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} != '01' && ${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RHQ_CD          = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '03' && ${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RGN_OFC_CD      = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.POL_CD = @[f_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.POD_CD = @[f_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_chk_pair} == 'Y')" ).append("\n"); 
		query.append("#if (${f_csq_mn_sctr_flg} != '' && ${f_csq_mn_sctr_flg} != 'All')" ).append("\n"); 
		query.append("AND NVL(A2.CSQ_MN_SCTR_FLG, 'N') = @[f_csq_mn_sctr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD  = A2.BSE_TP_CD" ).append("\n"); 
		query.append("AND A1.BSE_YR     = A2.BSE_YR" ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("AND A1.TRD_CD     = A2.TRD_CD" ).append("\n"); 
		query.append("AND A1.RLANE_CD   = A2.RLANE_CD" ).append("\n"); 
		query.append("AND A1.DIR_CD     = A2.DIR_CD" ).append("\n"); 
		query.append("AND A1.PF_GRP_CD  = A2.PF_GRP_CD" ).append("\n"); 
		query.append("AND A1.POL_CD     = A2.POL_CD" ).append("\n"); 
		query.append("AND A1.POD_CD     = A2.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD  = A3.BSE_TP_CD" ).append("\n"); 
		query.append("AND A1.BSE_YR     = A3.BSE_YR" ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD = A3.BSE_QTR_CD" ).append("\n"); 
		query.append("AND A1.TRD_CD     = A3.TRD_CD" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD = A3.SUB_TRD_CD" ).append("\n"); 
		query.append("AND A1.RLANE_CD   = A3.RLANE_CD" ).append("\n"); 
		query.append("AND A1.DIR_CD     = A3.DIR_CD" ).append("\n"); 
		query.append("AND A1.VSL_CD     = A3.VSL_CD" ).append("\n"); 
		query.append("AND A1.SKD_VOY_NO = A3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A1.SKD_DIR_CD = A3.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.OFC_VW_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A3.BSE_MON" ).append("\n"); 
		query.append("      ,A3.TOT_BSA_CAPA" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '02')   " ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_lvl} == '03') " ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_chk_pair} == 'Y')" ).append("\n"); 
		query.append("      ,A1.POL_CD" ).append("\n"); 
		query.append("      ,A1.POD_CD" ).append("\n"); 
		query.append("      ,A1.POL_CALL_SEQ" ).append("\n"); 
		query.append("      ,A1.POD_CALL_SEQ" ).append("\n"); 
		query.append("      ,CSQ_MN_SCTR_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_chk_vvd} == 'V' )" ).append("\n"); 
		query.append("      ,A1.VSL_CD||A1.SKD_VOY_NO||A1.SKD_DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_chk_week} == 'W')      " ).append("\n"); 
		query.append("      ,A3.BSE_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${excel_flg} == 'Y') " ).append("\n"); 
		query.append("HAVING SUM(A1.LOD_QTY) <> 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SUB_TRD_CD" ).append("\n"); 
		query.append("       , RLANE_CD" ).append("\n"); 
		query.append("       , DIR_CD" ).append("\n"); 
		query.append("#if (${f_chk_week} == 'W')      " ).append("\n"); 
		query.append("       , BSE_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       , BSE_MON" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '02')  " ).append("\n"); 
		query.append("	   , RHQ_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_lvl} == '03') " ).append("\n"); 
		query.append("       , RHQ_CD, RGN_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}