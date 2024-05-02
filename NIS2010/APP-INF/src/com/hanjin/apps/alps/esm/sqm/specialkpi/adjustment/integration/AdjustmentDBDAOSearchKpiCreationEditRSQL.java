/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AdjustmentDBDAOSearchKpiCreationEditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentDBDAOSearchKpiCreationEditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchKpiCreationEdit
	  * 2015.11.10 김성욱 [CHM-201538496] [CSR 전환건] KPI Creation & Edit 화면 보완 (Trade Direction 칼럼 추가)
	  * </pre>
	  */
	public AdjustmentDBDAOSearchKpiCreationEditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_bse_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_spcl_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_conv_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration").append("\n"); 
		query.append("FileName : AdjustmentDBDAOSearchKpiCreationEditRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("       A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A2.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD||A1.SKD_VOY_NO||A1.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,A2.BSE_MON" ).append("\n"); 
		query.append("      ,A2.BSE_WK" ).append("\n"); 
		query.append("      ,A2.FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A1.LOD_QTY" ).append("\n"); 
		query.append("      ,A1.GRS_RPB_REV" ).append("\n"); 
		query.append("      ,A1.PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,A1.RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,DECODE(MAS.HUL_BND_CD,'BH','B/H','H/H') HUL_BND_CD" ).append("\n"); 
		query.append("  FROM SQM_SPCL_CFM_QTA A1" ).append("\n"); 
		query.append("      ,SQM_SPCL_TGT_VVD A2" ).append("\n"); 
		query.append("      ,MAS_LANE_RGST MAS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND A1.BSE_TP_CD    = A2.BSE_TP_CD" ).append("\n"); 
		query.append("  AND A1.BSE_YR       = A2.BSE_YR" ).append("\n"); 
		query.append("  AND A1.BSE_QTR_CD   = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("  AND A1.TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("  AND A1.RLANE_CD     = A2.RLANE_CD" ).append("\n"); 
		query.append("  AND A1.VSL_CD       = A2.VSL_CD" ).append("\n"); 
		query.append("  AND A1.SKD_VOY_NO   = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND A1.SKD_DIR_CD   = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND A1.DIR_CD       = A2.DIR_CD" ).append("\n"); 
		query.append("  AND A2.BSE_TP_CD    = @[f_bse_tp_cd]    --필수" ).append("\n"); 
		query.append("  AND A2.BSE_YR       = @[f_bse_yr]       --필수" ).append("\n"); 
		query.append("  AND A1.SPCL_TGT_CD  = @[f_spcl_tgt_cd]  --필수" ).append("\n"); 
		query.append("#if(${f_bse_qtr_cd} != 'All')" ).append("\n"); 
		query.append("  AND A2.BSE_QTR_CD   = @[f_bse_qtr_cd]   --ALL 이 아닐때 필수" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rhq_cd} != 'All' && ${f_rhq_cd} != '' )" ).append("\n"); 
		query.append("  AND A1.RHQ_CD       = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_trd_cd} != 'All' && ${f_trd_cd} != '')" ).append("\n"); 
		query.append("  AND A1.TRD_CD       = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rlane_cd} != 'All' && ${f_rlane_cd} != '')" ).append("\n"); 
		query.append("  AND A1.RLANE_CD     = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_gubun} != 'on' && ${f_conv_dir_cd} != 'All')" ).append("\n"); 
		query.append("  AND A1.CONV_DIR_CD  = @[f_conv_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rgn_ofc_cd} != 'All' && ${f_rgn_ofc_cd} != '')" ).append("\n"); 
		query.append("  AND A1.RGN_OFC_CD   = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_bse_mon} != 'All' && ${f_bse_mon} != '')" ).append("\n"); 
		query.append("  AND A2.BSE_MON      = @[f_bse_mon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_vsl_cd} != '')" ).append("\n"); 
		query.append("  AND A1.VSL_CD       = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("  AND A1.SKD_VOY_NO   = @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_skd_dir_cd} != '')" ).append("\n"); 
		query.append("  AND A1.SKD_DIR_CD   = @[f_skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_gubun} == 'on' && ${f_trd_dir} != '' && ${f_trd_dir} != 'All')" ).append("\n"); 
		query.append("   AND MAS.HUL_BND_CD                 = @[f_trd_dir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND A2.RLANE_CD     = MAS.RLANE_CD" ).append("\n"); 
		query.append("  AND A2.DIR_CD       = MAS.DIR_CD" ).append("\n"); 
		query.append("  AND A2.TRD_CD       = MAS.TRD_CD" ).append("\n"); 
		query.append("  AND A2.IOC_CD       = MAS.IOC_CD" ).append("\n"); 
		query.append("ORDER BY BSE_QTR_CD, TRD_CD, SUB_TRD_CD, RLANE_CD, DIR_CD, A1.CONV_DIR_CD, BSE_WK, RHQ_CD, RGN_OFC_CD" ).append("\n"); 

	}
}