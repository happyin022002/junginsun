/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PlanningDBDAOSearchQtaLoadRevForAddSectorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.02.15 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAOSearchQtaLoadRevForAddSectorListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [QTA Set up for IAS Sector by Head Office] 데이터를 조회한다.
	  * [CHM-201639787] SQM Planning 도중 & Planning 완료 후 노선, P/F Group, Sector 추가 로직 Process 변경
	  * </pre>
	  */
	public PlanningDBDAOSearchQtaLoadRevForAddSectorListRSQL(){
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
		params.put("f_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_ias_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOSearchQtaLoadRevForAddSectorListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A1.BSE_TP_CD" ).append("\n"); 
		query.append("      , A1.BSE_YR" ).append("\n"); 
		query.append("      , A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      , A1.RLANE_CD" ).append("\n"); 
		query.append("      , A1.TRD_CD" ).append("\n"); 
		query.append("      , A1.DIR_CD" ).append("\n"); 
		query.append("      , A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      , A1.PF_GRP_CD" ).append("\n"); 
		query.append("      , A1.RHQ_CD" ).append("\n"); 
		query.append("      , A1.RGN_OFC_CD" ).append("\n"); 
		query.append("      , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03218' AND INTG_CD_VAL_CTNT = A2.IAS_RGN_CD) IAS_RGN_CD" ).append("\n"); 
		query.append("      , A1.POL_CD" ).append("\n"); 
		query.append("      , A1.POD_CD" ).append("\n"); 
		query.append("   FROM SQM_SCTR_LANE_OFC A1" ).append("\n"); 
		query.append("      , MAS_LANE_RGST A2" ).append("\n"); 
		query.append("      , ( SELECT DISTINCT B1.DIR_CD" ).append("\n"); 
		query.append("              , B1.RLANE_CD" ).append("\n"); 
		query.append("              , B1.BSA_CAPA" ).append("\n"); 
		query.append("              , B1.PF_GRP_CD" ).append("\n"); 
		query.append("           FROM (SELECT A1.DIR_CD" ).append("\n"); 
		query.append("                      , A1.RLANE_CD" ).append("\n"); 
		query.append("                      , A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                      , A1.PF_GRP_CD" ).append("\n"); 
		query.append("                      , MAX(A2.RANGE_BSA)+9 AS BSA_CAPA" ).append("\n"); 
		query.append("                   FROM ( SELECT DISTINCT S1.RLANE_CD" ).append("\n"); 
		query.append("                              , S1.DIR_CD" ).append("\n"); 
		query.append("                              , S1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                              , S2.PF_GRP_CD" ).append("\n"); 
		query.append("                           FROM SQM_QTA_TGT_VVD S1" ).append("\n"); 
		query.append("                              , SQM_SCTR_PF_GRP S2" ).append("\n"); 
		query.append("                          WHERE 1               = 1" ).append("\n"); 
		query.append("                            AND S1.BSE_TP_CD    = S2.BSE_TP_CD" ).append("\n"); 
		query.append("                            AND S1.BSE_YR       = S2.BSE_YR" ).append("\n"); 
		query.append("                            AND S1.BSE_QTR_CD   = S2.BSE_QTR_CD" ).append("\n"); 
		query.append("                            AND S1.TRD_CD       = S2.TRD_CD" ).append("\n"); 
		query.append("                            AND S1.RLANE_CD     = S2.RLANE_CD" ).append("\n"); 
		query.append("                            AND S1.PF_SVC_TP_CD = S2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                            AND S1.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                            AND S1.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("                            AND S1.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                            AND S1.TRD_CD       = 'IAS'" ).append("\n"); 
		query.append("                            AND S1.RLANE_CD     = @[f_rlane_cd]" ).append("\n"); 
		query.append("                            AND S1.DIR_CD       = @[f_dir_cd]" ).append("\n"); 
		query.append("                        ) A1" ).append("\n"); 
		query.append("                      , ( SELECT DISTINCT RLANE_CD" ).append("\n"); 
		query.append("                              , DIR_CD" ).append("\n"); 
		query.append("                              , FNL_BSA_CAPA" ).append("\n"); 
		query.append("                              , FNL_BSA_CAPA - 9 AS RANGE_BSA" ).append("\n"); 
		query.append("                           FROM SQM_QTA_TGT_VVD" ).append("\n"); 
		query.append("                          WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                            AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                            AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                            AND TRD_CD     = 'IAS'" ).append("\n"); 
		query.append("                            AND RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("                            AND DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("                        ) A2" ).append("\n"); 
		query.append("                  WHERE 1                = 1" ).append("\n"); 
		query.append("                    AND A1.DIR_CD        = A2.DIR_CD" ).append("\n"); 
		query.append("                    AND A1.RLANE_CD      = A2.RLANE_CD" ).append("\n"); 
		query.append("                    AND A1.FNL_BSA_CAPA >= A2.RANGE_BSA" ).append("\n"); 
		query.append("               GROUP BY A1.DIR_CD" ).append("\n"); 
		query.append("                      , A1.RLANE_CD" ).append("\n"); 
		query.append("                      , A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                      , A1.PF_GRP_CD" ).append("\n"); 
		query.append("                ) B1" ).append("\n"); 
		query.append("        ) C3" ).append("\n"); 
		query.append("  WHERE 1              =1" ).append("\n"); 
		query.append("    AND A1.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("    AND A1.TRD_CD      = A2.TRD_CD" ).append("\n"); 
		query.append("    AND A1.SUB_TRD_CD  = A2.SUB_TRD_CD" ).append("\n"); 
		query.append("    AND A1.RLANE_CD    = A2.RLANE_CD" ).append("\n"); 
		query.append("    AND A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("    AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("    AND A1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("    AND A1.SUB_TRD_CD  = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("    AND A1.RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("    AND A1.DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("    AND A1.OFC_VW_CD   = SUBSTR(@[f_ofc_vw_cd], 0, 1)" ).append("\n"); 
		query.append("    #if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')" ).append("\n"); 
		query.append("    AND A2.IAS_RGN_CD  = @[f_ias_rgn_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("    AND A1.RHQ_CD      = @[f_rhq_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("    AND A1.RGN_OFC_CD  = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')" ).append("\n"); 
		query.append("    AND A1.POL_CD      = @[f_pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')" ).append("\n"); 
		query.append("    AND A1.POD_CD      = @[f_pod_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND NOT EXISTS" ).append("\n"); 
		query.append("        (SELECT 1" ).append("\n"); 
		query.append("           FROM SQM_SCTR_LOD_REV SR" ).append("\n"); 
		query.append("          WHERE SR.BSE_TP_CD  = A1.BSE_TP_CD" ).append("\n"); 
		query.append("            AND SR.BSE_YR     = A1.BSE_YR" ).append("\n"); 
		query.append("            AND SR.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND SR.OFC_VW_CD  = A1.OFC_VW_CD" ).append("\n"); 
		query.append("            AND SR.RLANE_CD   = A1.RLANE_CD" ).append("\n"); 
		query.append("            AND SR.DIR_CD     = A1.DIR_CD" ).append("\n"); 
		query.append("            AND SR.POL_CD     = A1.POL_CD" ).append("\n"); 
		query.append("            AND SR.POD_CD     = A1.POD_CD" ).append("\n"); 
		query.append("            AND SR.RHQ_CD     = A1.RHQ_CD" ).append("\n"); 
		query.append("            AND SR.RGN_OFC_CD = A1.RGN_OFC_CD" ).append("\n"); 
		query.append("            AND SR.PF_GRP_CD  = A1.PF_GRP_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND A1.RLANE_CD    = C3.RLANE_CD" ).append("\n"); 
		query.append("    AND A1.DIR_CD      = C3.DIR_CD" ).append("\n"); 
		query.append("    AND A1.PF_GRP_CD   = C3.PF_GRP_CD" ).append("\n"); 
		query.append("ORDER BY RHQ_CD" ).append("\n"); 
		query.append("      , RGN_OFC_CD" ).append("\n"); 
		query.append("      , POL_CD" ).append("\n"); 
		query.append("      , POD_CD" ).append("\n"); 

	}
}