/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PlanningDBDAOUpdateQtaLoadRevForSectorAddBSAGroupUSQL.java
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

public class PlanningDBDAOUpdateQtaLoadRevForSectorAddBSAGroupUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [SQM_SCTR_ADD_TGT_VVD]의 BSA GROUP CAPA를 업데이트 한다.
	  * 
	  * * 2014.07.25 이혜민   QTA Set up by HO for IAS Sector_Add Creation 시 Bound 삽입 DIR_CD = [@dir_cd] 조건 추가
	  * </pre>
	  */
	public PlanningDBDAOUpdateQtaLoadRevForSectorAddBSAGroupUSQL(){
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
		query.append("FileName : PlanningDBDAOUpdateQtaLoadRevForSectorAddBSAGroupUSQL").append("\n"); 
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
		query.append("MERGE INTO SQM_SCTR_ADD_TGT_VVD X" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("               B1.BSE_TP_CD" ).append("\n"); 
		query.append("              ,B1.BSE_YR" ).append("\n"); 
		query.append("              ,B1.BSE_QTR_CD" ).append("\n"); 
		query.append("              ,B1.TRD_CD" ).append("\n"); 
		query.append("              ,B1.RLANE_CD" ).append("\n"); 
		query.append("              ,B1.DIR_CD" ).append("\n"); 
		query.append("              ,B1.PF_GRP_CD" ).append("\n"); 
		query.append("              ,B1.VSL_CD" ).append("\n"); 
		query.append("              ,B1.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,B1.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,B1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("              ,MAX(B2.RANGE_BSA)+9 AS BSA_CAPA --차이가 0~9 사이일 경우 큰 BSA를 대표로 그룹핑한다." ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT BSE_TP_CD" ).append("\n"); 
		query.append("                      ,BSE_YR" ).append("\n"); 
		query.append("                      ,BSE_QTR_CD" ).append("\n"); 
		query.append("                      ,TRD_CD" ).append("\n"); 
		query.append("                      ,RLANE_CD" ).append("\n"); 
		query.append("                      ,DIR_CD" ).append("\n"); 
		query.append("                      ,VSL_CD" ).append("\n"); 
		query.append("                      ,SKD_VOY_NO" ).append("\n"); 
		query.append("                      ,SKD_DIR_CD" ).append("\n"); 
		query.append("                      ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("                      ,pf_grp_cd" ).append("\n"); 
		query.append("                  FROM SQM_SCTR_ADD_TGT_VVD" ).append("\n"); 
		query.append("                 WHERE BSE_TP_CD       = @[bse_tp_cd]" ).append("\n"); 
		query.append("                   AND BSE_YR          = @[bse_yr]" ).append("\n"); 
		query.append("                   AND BSE_QTR_CD      = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("                   AND TRD_CD          = 'IAS'" ).append("\n"); 
		query.append("                   AND RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("                   AND PF_GRP_CD       = @[pf_grp_cd]" ).append("\n"); 
		query.append("                   AND DIR_CD          = NVL(@[dir_cd], DIR_CD)" ).append("\n"); 
		query.append("--                 ORDER BY DIR_CD, RLANE_CD, FNL_BSA_CAPA DESC" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT DISTINCT RLANE_CD, DIR_CD, FNL_BSA_CAPA, FNL_BSA_CAPA - 9 AS RANGE_BSA" ).append("\n"); 
		query.append("                  FROM SQM_SCTR_ADD_TGT_VVD" ).append("\n"); 
		query.append("                 WHERE BSE_TP_CD       = @[bse_tp_cd]" ).append("\n"); 
		query.append("                   AND BSE_YR          = @[bse_yr]" ).append("\n"); 
		query.append("                   AND BSE_QTR_CD      = DECODE(@[bse_tp_cd], 'Y', '00', @[bse_qtr_cd])" ).append("\n"); 
		query.append("                   AND TRD_CD          = 'IAS'" ).append("\n"); 
		query.append("                   AND RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("                   AND PF_GRP_CD       = @[pf_grp_cd]" ).append("\n"); 
		query.append("                   AND DIR_CD          = NVL(@[dir_cd], DIR_CD)" ).append("\n"); 
		query.append("--                 ORDER BY DIR_CD, RLANE_CD, FNL_BSA_CAPA DESC  " ).append("\n"); 
		query.append("               ) B2" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND B1.DIR_CD        = B2.DIR_CD" ).append("\n"); 
		query.append("           AND B1.RLANE_CD      = B2.RLANE_CD" ).append("\n"); 
		query.append("           AND B1.FNL_BSA_CAPA >= B2.RANGE_BSA" ).append("\n"); 
		query.append("         GROUP BY B1.BSE_TP_CD" ).append("\n"); 
		query.append("                 ,B1.BSE_YR" ).append("\n"); 
		query.append("                 ,B1.BSE_QTR_CD" ).append("\n"); 
		query.append("                 ,B1.TRD_CD" ).append("\n"); 
		query.append("                 ,B1.RLANE_CD" ).append("\n"); 
		query.append("                 ,B1.DIR_CD" ).append("\n"); 
		query.append("                 ,B1.PF_GRP_CD" ).append("\n"); 
		query.append("                 ,B1.VSL_CD" ).append("\n"); 
		query.append("                 ,B1.SKD_VOY_NO" ).append("\n"); 
		query.append("                 ,B1.SKD_DIR_CD" ).append("\n"); 
		query.append("                 ,B1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("         ORDER BY B1.DIR_CD, B1.RLANE_CD,B1.FNL_BSA_CAPA DESC   " ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("        X.BSE_TP_CD  = Y.BSE_TP_CD" ).append("\n"); 
		query.append("    AND X.BSE_YR     = Y.BSE_YR" ).append("\n"); 
		query.append("    AND X.BSE_QTR_CD = Y.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND X.TRD_CD     = Y.TRD_CD" ).append("\n"); 
		query.append("    AND X.RLANE_CD   = Y.RLANE_CD" ).append("\n"); 
		query.append("    AND X.VSL_CD     = Y.VSL_CD" ).append("\n"); 
		query.append("    AND X.SKD_VOY_NO = Y.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND X.SKD_DIR_CD = Y.SKD_DIR_CD" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE " ).append("\n"); 
		query.append("        SET GRP_BSA_CAPA = BSA_CAPA" ).append("\n"); 

	}
}