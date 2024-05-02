/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PlanningDBDAOCreateQtaLoadRevForSectorAddCSQL.java
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

public class PlanningDBDAOCreateQtaLoadRevForSectorAddCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Add Creation] 를 [생성]한다.
	  * 
	  * * 2014.07.25 이혜민  QTA Set up by HO for IAS Sector_Add Creation 시 Bound 삽입 DIR_CD = [@dir_cd] 조건 추가
	  * [CHM-201639851] 2016.01.28 Basic Data Creation for IAS Secotr 화면의 Creation 로직 변경
	  * </pre>
	  */
	public PlanningDBDAOCreateQtaLoadRevForSectorAddCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOCreateQtaLoadRevForSectorAddCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SCTR_LOD_REV(BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, RLANE_CD, DIR_CD, FNL_BSA_CAPA, PF_GRP_CD, RGN_OFC_CD, POL_CD, POD_CD, TRD_CD, SUB_TRD_CD, RHQ_CD, GID_LOD_QTY, GID_GRS_RPB_REV, LOD_QTY, GRS_RPB_REV, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("SELECT DISTINCT A1.BSE_TP_CD" ).append("\n"); 
		query.append("      , A1.BSE_YR" ).append("\n"); 
		query.append("      , A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      , @[ofc_vw_cd] OFC_VW_CD" ).append("\n"); 
		query.append("      , A1.RLANE_CD" ).append("\n"); 
		query.append("      , A1.DIR_CD" ).append("\n"); 
		query.append("      , C3.BSA_CAPA FNL_BSA_CAPA" ).append("\n"); 
		query.append("      , A1.PF_GRP_CD" ).append("\n"); 
		query.append("      , A1.RGN_OFC_CD" ).append("\n"); 
		query.append("      , A1.POL_CD" ).append("\n"); 
		query.append("      , A1.POD_CD" ).append("\n"); 
		query.append("      , A1.TRD_CD" ).append("\n"); 
		query.append("      , A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      , A1.RHQ_CD" ).append("\n"); 
		query.append("      , 0 AS GID_LOD_QTY" ).append("\n"); 
		query.append("      , 0 AS GID_GRS_RPB_REV" ).append("\n"); 
		query.append("      , 0 AS LOD_QTY" ).append("\n"); 
		query.append("      , 0 AS GRS_RPB_REV" ).append("\n"); 
		query.append("      , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("      , @[cre_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE AS UPD_DT" ).append("\n"); 
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
		query.append("                            AND S1.BSE_TP_CD    = @[bse_tp_cd]" ).append("\n"); 
		query.append("                            AND S1.BSE_YR       = @[bse_yr]" ).append("\n"); 
		query.append("                            AND S1.BSE_QTR_CD   = @[bse_qtr_cd]" ).append("\n"); 
		query.append("                            AND S1.TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("                            AND S1.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("                            AND S1.DIR_CD       = @[dir_cd]" ).append("\n"); 
		query.append("                        ) A1" ).append("\n"); 
		query.append("                      , ( SELECT DISTINCT RLANE_CD" ).append("\n"); 
		query.append("                              , DIR_CD" ).append("\n"); 
		query.append("                              , FNL_BSA_CAPA" ).append("\n"); 
		query.append("                              , FNL_BSA_CAPA - 9 AS RANGE_BSA" ).append("\n"); 
		query.append("                           FROM SQM_QTA_TGT_VVD" ).append("\n"); 
		query.append("                          WHERE BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("                            AND BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("                            AND BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("                            AND TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("                            AND RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("                            AND DIR_CD     = @[dir_cd]" ).append("\n"); 
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
		query.append("    AND A1.BSE_TP_CD   = @[bse_tp_cd]" ).append("\n"); 
		query.append("    AND A1.BSE_YR      = @[bse_yr]" ).append("\n"); 
		query.append("    AND A1.BSE_QTR_CD  = @[bse_qtr_cd]" ).append("\n"); 
		query.append("    AND A1.RLANE_CD    = @[rlane_cd]" ).append("\n"); 
		query.append("    AND A1.DIR_CD      = @[dir_cd]" ).append("\n"); 
		query.append("    AND A1.OFC_VW_CD   = @[ofc_vw_cd]" ).append("\n"); 
		query.append("    AND A1.PF_GRP_CD   = @[pf_grp_cd]" ).append("\n"); 
		query.append("    AND A1.POL_CD      = @[pol_cd]" ).append("\n"); 
		query.append("    AND A1.POD_CD      = @[pod_cd]" ).append("\n"); 
		query.append("    AND A1.RHQ_CD      = @[rhq_cd]" ).append("\n"); 
		query.append("    AND A1.RGN_OFC_CD  = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("    AND A1.RLANE_CD    = C3.RLANE_CD" ).append("\n"); 
		query.append("    AND A1.DIR_CD      = C3.DIR_CD" ).append("\n"); 
		query.append("    AND A1.PF_GRP_CD   = C3.PF_GRP_CD" ).append("\n"); 
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
		query.append("ORDER BY RHQ_CD" ).append("\n"); 
		query.append("      , RGN_OFC_CD" ).append("\n"); 
		query.append("      , POL_CD" ).append("\n"); 
		query.append("      , POD_CD" ).append("\n"); 

	}
}