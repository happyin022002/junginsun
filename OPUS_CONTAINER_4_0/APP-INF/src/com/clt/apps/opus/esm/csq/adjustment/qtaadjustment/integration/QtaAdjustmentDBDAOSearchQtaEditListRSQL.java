/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchQtaEditListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.06 
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

public class QtaAdjustmentDBDAOSearchQtaEditListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Qta Edit]을 [조회] 합니다
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchQtaEditListRSQL(){
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
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_decimal_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_csq_cng_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchQtaEditListRSQL").append("\n"); 
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
		query.append("SELECT QTA.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,QTA.BSE_TP_CD" ).append("\n"); 
		query.append("      ,QTA.BSE_YR" ).append("\n"); 
		query.append("      ,QTA.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,DECODE(QTA.OFC_VW_CD,'L','Loading','Contract') OFC_VW_CD" ).append("\n"); 
		query.append("      ,QTA.QTA_TGT_CD" ).append("\n"); 
		query.append("      ,QTA.TRD_CD" ).append("\n"); 
		query.append("      ,QTA.DIR_CD" ).append("\n"); 
		query.append("      ,VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,QTA.RLANE_CD" ).append("\n"); 
		query.append("      ,VVD.BSE_WK" ).append("\n"); 
		query.append("      ,QTA.RHQ_CD" ).append("\n"); 
		query.append("      ,QTA.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,QTA.VSL_CD||QTA.SKD_VOY_NO||QTA.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      ,QTA.VSL_CD" ).append("\n"); 
		query.append("      ,QTA.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,QTA.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,QTA.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,QTA.LOD_QTY" ).append("\n"); 
		query.append("      ,CASE WHEN @[f_decimal_flg] = 'Y' THEN QTA.GRS_RPB_REV ELSE ROUND(QTA.GRS_RPB_REV) END GRS_RPB_REV" ).append("\n"); 
		query.append("      ,QTA.PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,QTA.RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,VVD.BSE_MON" ).append("\n"); 
		query.append("      ,VVD.FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,QTA.CSQ_CNG_TP_CD" ).append("\n"); 
		query.append("  FROM CSQ_CFM_QTA QTA" ).append("\n"); 
		query.append("      ,CSQ_CFM_TGT_VVD VVD" ).append("\n"); 
		query.append(" WHERE QTA.BSE_TP_CD                  = 'Q'" ).append("\n"); 
		query.append("   AND QTA.BSE_YR                     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND QTA.BSE_QTR_CD                 = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("   AND QTA.OFC_VW_CD                  = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("   AND QTA.QTA_TGT_CD                 = 'D'" ).append("\n"); 
		query.append("   AND SUBSTR(QTA.QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.TRD_CD                     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.RLANE_CD                   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_gubun} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.DIR_CD                     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.RHQ_CD                     = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.RGN_OFC_CD                 = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_to_mon} != '' && ${f_to_mon} != 'All')" ).append("\n"); 
		query.append("   AND VVD.BSE_MON                    = @[f_to_mon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_to_wk} != '' && ${f_to_wk} != 'All')" ).append("\n"); 
		query.append("   AND VVD.BSE_WK                     = @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '' )" ).append("\n"); 
		query.append("   AND QTA.VSL_CD                     = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_voy_no} != '' )" ).append("\n"); 
		query.append("   AND QTA.SKD_VOY_NO                 = @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_dir_cd} != '' )" ).append("\n"); 
		query.append("   AND QTA.SKD_DIR_CD                 = @[f_skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_csq_cng_tp_cd} != '' && ${f_csq_cng_tp_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.CSQ_CNG_TP_CD              = @[f_csq_cng_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND QTA.QTA_RLSE_VER_NO            = VVD.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("   AND QTA.BSE_TP_CD                  = VVD.BSE_TP_CD" ).append("\n"); 
		query.append("   AND QTA.BSE_YR                     = VVD.BSE_YR" ).append("\n"); 
		query.append("   AND QTA.BSE_QTR_CD                 = VVD.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND QTA.QTA_TGT_CD                 = VVD.QTA_TGT_CD" ).append("\n"); 
		query.append("   AND QTA.TRD_CD                     = VVD.TRD_CD" ).append("\n"); 
		query.append("   AND QTA.RLANE_CD                   = VVD.RLANE_CD" ).append("\n"); 
		query.append("   AND QTA.DIR_CD                     = VVD.DIR_CD  " ).append("\n"); 
		query.append("   AND QTA.VSL_CD                     = VVD.VSL_CD" ).append("\n"); 
		query.append("   AND QTA.SKD_VOY_NO                 = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND QTA.SKD_DIR_CD                 = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append(" ORDER BY  QTA.TRD_CD" ).append("\n"); 
		query.append("          ,QTA.CONV_DIR_CD" ).append("\n"); 
		query.append("          ,VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("          ,QTA.RLANE_CD" ).append("\n"); 
		query.append("          ,VVD.BSE_WK" ).append("\n"); 
		query.append("          ,QTA.VSL_CD||QTA.SKD_VOY_NO||QTA.SKD_DIR_CD" ).append("\n"); 
		query.append("          ,QTA.RHQ_CD" ).append("\n"); 
		query.append("          ,QTA.RGN_OFC_CD" ).append("\n"); 

	}
}