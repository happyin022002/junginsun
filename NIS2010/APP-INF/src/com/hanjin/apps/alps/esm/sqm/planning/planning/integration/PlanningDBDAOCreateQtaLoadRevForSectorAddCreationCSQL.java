/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PlanningDBDAOCreateQtaLoadRevForSectorAddCreationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAOCreateQtaLoadRevForSectorAddCreationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Add Creation] 를 [생성]한다.
	  * 
	  * * 2014.07.25 이혜민  QTA Set up by HO for IAS Sector_Add Creation 시 Bound 삽입 DIR_CD = [@dir_cd] 조건 추가
	  * </pre>
	  */
	public PlanningDBDAOCreateQtaLoadRevForSectorAddCreationCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOCreateQtaLoadRevForSectorAddCreationCSQL").append("\n"); 
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
		query.append("SELECT C1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,C1.BSE_YR" ).append("\n"); 
		query.append("      ,C1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,C1.OFC_VW_CD" ).append("\n"); 
		query.append("      ,C1.RLANE_CD" ).append("\n"); 
		query.append("      ,C1.DIR_CD" ).append("\n"); 
		query.append("      ,C3.BSA_CAPA" ).append("\n"); 
		query.append("      ,C1.PF_GRP_CD" ).append("\n"); 
		query.append("      ,C1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,C1.POL_CD" ).append("\n"); 
		query.append("      ,C1.POD_CD" ).append("\n"); 
		query.append("      ,C1.TRD_CD" ).append("\n"); 
		query.append("      ,C1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,C1.RHQ_CD" ).append("\n"); 
		query.append("      ,0 AS GID_LOD_QTY" ).append("\n"); 
		query.append("      ,0 AS GID_GRS_RPB_REV" ).append("\n"); 
		query.append("      ,0 AS LOD_QTY" ).append("\n"); 
		query.append("      ,0 AS GRS_RPB_REV" ).append("\n"); 
		query.append("      ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE     AS UPD_DT" ).append("\n"); 
		query.append("  FROM SQM_SCTR_LANE_OFC C1" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT DISTINCT" ).append("\n"); 
		query.append("               B1.DIR_CD" ).append("\n"); 
		query.append("              ,B1.RLANE_CD" ).append("\n"); 
		query.append("              ,B1.BSA_CAPA" ).append("\n"); 
		query.append("              ,B1.PF_GRP_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT A1.DIR_CD" ).append("\n"); 
		query.append("                      ,A1.RLANE_CD" ).append("\n"); 
		query.append("                      ,A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                      ,A1.PF_GRP_CD" ).append("\n"); 
		query.append("                      ,MAX(A2.RANGE_BSA)+9 AS BSA_CAPA" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT DISTINCT S1.RLANE_CD,S1.DIR_CD,S1.FNL_BSA_CAPA, S2.PF_GRP_CD" ).append("\n"); 
		query.append("#if (${f_c_cnt} == '0')" ).append("\n"); 
		query.append("                          FROM SQM_QTA_TGT_VVD S1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                          FROM SQM_SCTR_ADD_TGT_VVD S1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                              ,SQM_SCTR_PF_GRP S2" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND S1.BSE_TP_CD    = S2.BSE_TP_CD" ).append("\n"); 
		query.append("                           AND S1.BSE_YR       = S2.BSE_YR" ).append("\n"); 
		query.append("                           AND S1.BSE_QTR_CD   = S2.BSE_QTR_CD" ).append("\n"); 
		query.append("                           AND S1.TRD_CD       = S2.TRD_CD" ).append("\n"); 
		query.append("                           AND S1.RLANE_CD     = S2.RLANE_CD" ).append("\n"); 
		query.append("                           AND S1.PF_SVC_TP_CD = S2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                           AND S1.BSE_TP_CD    = @[bse_tp_cd]" ).append("\n"); 
		query.append("                           AND S1.BSE_YR       = @[bse_yr]" ).append("\n"); 
		query.append("                           AND S1.BSE_QTR_CD   = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("                           AND S1.TRD_CD       = 'IAS'" ).append("\n"); 
		query.append("                           AND S1.RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("                           AND S1.DIR_CD       = NVL(@[dir_cd], S1.DIR_CD)" ).append("\n"); 
		query.append("                           AND S2.PF_GRP_CD    = @[pf_grp_cd]" ).append("\n"); 
		query.append("                         ORDER BY DIR_CD, RLANE_CD,FNL_BSA_CAPA DESC" ).append("\n"); 
		query.append("                       ) A1" ).append("\n"); 
		query.append("                      ,(" ).append("\n"); 
		query.append("                        SELECT DISTINCT RLANE_CD, DIR_CD, FNL_BSA_CAPA, FNL_BSA_CAPA - 9 AS RANGE_BSA" ).append("\n"); 
		query.append("#if (${f_c_cnt} == '0')" ).append("\n"); 
		query.append("                          FROM SQM_QTA_TGT_VVD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                          FROM SQM_SCTR_ADD_TGT_VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         WHERE BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("                           AND BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("                           AND BSE_QTR_CD = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("                           AND TRD_CD     = 'IAS'" ).append("\n"); 
		query.append("                           AND RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("                           AND DIR_CD     = NVL(@[dir_cd], DIR_CD)" ).append("\n"); 
		query.append("                         ORDER BY DIR_CD, RLANE_CD, FNL_BSA_CAPA DESC" ).append("\n"); 
		query.append("                       ) A2" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND A1.DIR_CD        = A2.DIR_CD" ).append("\n"); 
		query.append("                   AND A1.RLANE_CD      = A2.RLANE_CD" ).append("\n"); 
		query.append("                   AND A1.FNL_BSA_CAPA >= A2.RANGE_BSA" ).append("\n"); 
		query.append("                 GROUP BY A1.DIR_CD" ).append("\n"); 
		query.append("                      ,A1.RLANE_CD" ).append("\n"); 
		query.append("                      ,A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                      ,A1.PF_GRP_CD" ).append("\n"); 
		query.append("                 ORDER BY A1.DIR_CD, A1.RLANE_CD,A1.FNL_BSA_CAPA DESC" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("       ) C3" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND C1.RLANE_CD   = C3.RLANE_CD" ).append("\n"); 
		query.append("   AND C1.DIR_CD     = C3.DIR_CD" ).append("\n"); 
		query.append("   AND C1.PF_GRP_CD  = C3.PF_GRP_CD" ).append("\n"); 
		query.append("   AND C1.BSE_TP_CD  = @[bse_tp_cd]" ).append("\n"); 
		query.append("   AND C1.BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("   AND C1.BSE_QTR_CD = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("   AND C1.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("   AND C1.PF_GRP_CD  = @[pf_grp_cd]" ).append("\n"); 
		query.append("   AND C1.DIR_CD     = NVL(@[dir_cd], C1.DIR_CD)" ).append("\n"); 

	}
}