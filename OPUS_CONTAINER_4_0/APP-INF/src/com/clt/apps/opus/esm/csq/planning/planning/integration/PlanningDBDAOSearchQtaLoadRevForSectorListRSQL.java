/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PlanningDBDAOSearchQtaLoadRevForSectorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_fnl_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_csq_mn_sctr_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.planning.integration").append("\n"); 
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
		query.append("SELECT A2.BSE_YR" ).append("\n"); 
		query.append("      ,A2.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00940' AND INTG_CD_VAL_CTNT = A2.OFC_VW_CD) AS OFC_VW_NM" ).append("\n"); 
		query.append("      ,A2.OFC_VW_CD" ).append("\n"); 
		query.append("      ,A2.TRD_CD" ).append("\n"); 
		query.append("      ,A2.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A2.RLANE_CD" ).append("\n"); 
		query.append("      ,A2.DIR_CD" ).append("\n"); 
		query.append("      ,A2.PF_GRP_CD" ).append("\n"); 
		query.append("      ,A2.FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,A2.RHQ_CD" ).append("\n"); 
		query.append("      ,A2.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A2.POL_CD" ).append("\n"); 
		query.append("      ,A2.POD_CD" ).append("\n"); 
		query.append("      ,A2.GID_LOD_QTY" ).append("\n"); 
		query.append("      ,A2.GID_GRS_RPB_REV" ).append("\n"); 
		query.append("      ,A2.LOD_QTY" ).append("\n"); 
		query.append("      ,A2.GRS_RPB_REV" ).append("\n"); 
		query.append("      ,DECODE(NVL(A4.PF_GRP_CD,'*'),'*','N','Y') USE_FLG" ).append("\n"); 
		query.append("      ,DECODE(NVL(A5.CSQ_MN_SCTR_FLG, 'N'), 'Y', 'Main', 'N', 'Sector') CSQ_MN_SCTR_FLG" ).append("\n"); 
		query.append("  FROM CSQ_SCTR_LANE_OFC A1" ).append("\n"); 
		query.append("      ,CSQ_SCTR_LOD_REV A2" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT DISTINCT BSE_TP_CD" ).append("\n"); 
		query.append("              ,BSE_YR" ).append("\n"); 
		query.append("              ,BSE_QTR_CD" ).append("\n"); 
		query.append("              ,RLANE_CD" ).append("\n"); 
		query.append("              ,PF_GRP_CD " ).append("\n"); 
		query.append("          FROM CSQ_SCTR_CFM_QTA" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND QTA_RLSE_VER_NO = SUBSTR(@[f_bse_yr],-2) || DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]) || '02'" ).append("\n"); 
		query.append("           AND BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("           AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("           AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("       ) A4" ).append("\n"); 
		query.append("      ,CSQ_SCTR_PAIR_MGMT A5" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD   = A2.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = A2.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.OFC_VW_CD   = A2.OFC_VW_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD    = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD      = A2.DIR_CD" ).append("\n"); 
		query.append("   AND A1.PF_GRP_CD   = A2.PF_GRP_CD" ).append("\n"); 
		query.append("   AND A1.RGN_OFC_CD  = A2.RGN_OFC_CD" ).append("\n"); 
		query.append("   AND A1.POL_CD      = A2.POL_CD" ).append("\n"); 
		query.append("   AND A1.POD_CD      = A2.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD   = A4.BSE_TP_CD(+)" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = A4.BSE_YR(+)" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = A4.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("   AND A1.RLANE_CD    = A4.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND A1.PF_GRP_CD   = A4.PF_GRP_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD  = A5.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR     = A5.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD = A5.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   = A5.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD     = A5.DIR_CD" ).append("\n"); 
		query.append("   AND A1.PF_GRP_CD  = A5.PF_GRP_CD" ).append("\n"); 
		query.append("   AND A1.POL_CD     = A5.POL_CD" ).append("\n"); 
		query.append("   AND A1.POD_CD     = A5.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.CSQ_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A2.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A2.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A2.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A2.OFC_VW_CD   = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A2.SUB_TRD_CD  = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("   AND A2.RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("   AND A2.DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("   AND A2.RHQ_CD      = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("   AND A2.RGN_OFC_CD  = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pf_grp_cd} != '' && ${f_pf_grp_cd} != 'All')" ).append("\n"); 
		query.append("   AND A2.PF_GRP_CD   = @[f_pf_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_fnl_bsa_capa} != '' && ${f_fnl_bsa_capa} != 'All')" ).append("\n"); 
		query.append("   AND A2.FNL_BSA_CAPA= @[f_fnl_bsa_capa]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')" ).append("\n"); 
		query.append("   AND A2.POL_CD      = @[f_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')" ).append("\n"); 
		query.append("   AND A2.POD_CD      = @[f_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_csq_mn_sctr_flg} != '' && ${f_csq_mn_sctr_flg} != 'All')" ).append("\n"); 
		query.append("AND NVL(A5.CSQ_MN_SCTR_FLG, 'N') = @[f_csq_mn_sctr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A2.BSE_YR" ).append("\n"); 
		query.append("      ,A2.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A2.OFC_VW_CD" ).append("\n"); 
		query.append("      ,A2.TRD_CD" ).append("\n"); 
		query.append("      ,A2.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A2.RLANE_CD" ).append("\n"); 
		query.append("      ,A2.DIR_CD" ).append("\n"); 
		query.append("      ,A2.PF_GRP_CD" ).append("\n"); 
		query.append("      ,A2.FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,A2.RHQ_CD" ).append("\n"); 
		query.append("      ,A2.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A1.POL_CALL_SEQ" ).append("\n"); 
		query.append("      ,A1.POD_CALL_SEQ" ).append("\n"); 

	}
}