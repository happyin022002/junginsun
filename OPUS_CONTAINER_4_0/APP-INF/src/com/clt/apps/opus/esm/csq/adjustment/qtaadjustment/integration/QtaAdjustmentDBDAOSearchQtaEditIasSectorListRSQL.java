/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchQtaEditIasSectorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.11 
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

public class QtaAdjustmentDBDAOSearchQtaEditIasSectorListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qta Edit for IAS Sector을 조회 합니다.
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchQtaEditIasSectorListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_csq_mn_sctr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchQtaEditIasSectorListRSQL").append("\n"); 
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
		query.append("SELECT A1.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC AS NAME" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID  = 'CD00940'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = A1.OFC_VW_CD) OFC_VW_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A2.BSE_MON" ).append("\n"); 
		query.append("      ,A2.BSE_WK" ).append("\n"); 
		query.append("      ,A1.VSL_CD||A1.SKD_VOY_NO||A1.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      ,A2.FNL_BSA_CAPA " ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A1.POL_CD" ).append("\n"); 
		query.append("      ,A1.POD_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A1.LOD_QTY" ).append("\n"); 
		query.append("      ,A1.GRS_RPB_REV" ).append("\n"); 
		query.append("      ,A1.PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,A1.RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,A1.CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("	  ,DECODE(NVL(A4.CSQ_MN_SCTR_FLG, 'N'), 'Y', 'Main', 'N', 'Sector') CSQ_MN_SCTR_FLG" ).append("\n"); 
		query.append("  FROM CSQ_SCTR_CFM_QTA A1" ).append("\n"); 
		query.append("      ,CSQ_CFM_TGT_VVD A2" ).append("\n"); 
		query.append("      ,CSQ_SCTR_PAIR_MGMT A4" ).append("\n"); 
		query.append(" WHERE A1.BSE_TP_CD                  = 'Q'" ).append("\n"); 
		query.append("   AND A1.BSE_YR                     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD                 = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("   AND A1.OFC_VW_CD                  = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("   AND SUBSTR(A1.QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.SUB_TRD_CD                 = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RLANE_CD                   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.DIR_CD                     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RHQ_CD                     = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RGN_OFC_CD                 = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_to_mon} != '' && ${f_to_mon} != 'All')" ).append("\n"); 
		query.append("   AND A2.BSE_MON                    = @[f_to_mon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_to_wk} != '' && ${f_to_wk} != 'All')" ).append("\n"); 
		query.append("   AND A2.BSE_WK                     = @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '' )" ).append("\n"); 
		query.append("   AND A1.VSL_CD                     = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_voy_no} != '' )" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO                 = @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_dir_cd} != '' )" ).append("\n"); 
		query.append("   AND A1.SKD_DIR_CD                 = @[f_skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.POL_CD                 = @[f_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.POD_CD                 = @[f_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_csq_mn_sctr_flg} != '' && ${f_csq_mn_sctr_flg} != 'All')" ).append("\n"); 
		query.append("AND NVL(A4.CSQ_MN_SCTR_FLG, 'N') = @[f_csq_mn_sctr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A1.QTA_RLSE_VER_NO            = A2.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD                  = A2.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR                     = A2.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD                 = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD                     = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD                   = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD                     = A2.DIR_CD  " ).append("\n"); 
		query.append("   AND A1.VSL_CD                     = A2.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO                 = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A1.SKD_DIR_CD                 = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD  				 = A4.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR     				 = A4.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD 				 = A4.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   				 = A4.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD     				 = A4.DIR_CD" ).append("\n"); 
		query.append("   AND A1.PF_GRP_CD  				 = A4.PF_GRP_CD" ).append("\n"); 
		query.append("   AND A1.POL_CD     				 = A4.POL_CD" ).append("\n"); 
		query.append("   AND A1.POD_CD     				 = A4.POD_CD" ).append("\n"); 
		query.append(" ORDER BY  A1.TRD_CD" ).append("\n"); 
		query.append("          ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("          ,A1.RLANE_CD" ).append("\n"); 
		query.append("          ,A2.BSE_WK" ).append("\n"); 
		query.append("          ,A2.BSE_MON" ).append("\n"); 
		query.append("          ,A1.VSL_CD||A1.SKD_VOY_NO||A1.SKD_DIR_CD" ).append("\n"); 
		query.append("          ,A1.RHQ_CD" ).append("\n"); 
		query.append("          ,A1.RGN_OFC_CD" ).append("\n"); 

	}
}