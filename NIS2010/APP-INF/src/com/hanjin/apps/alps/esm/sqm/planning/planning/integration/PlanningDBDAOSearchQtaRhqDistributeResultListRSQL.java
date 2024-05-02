/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PlanningDBDAOSearchQtaRhqDistributeResultListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.07
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.10.07 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAOSearchQtaRhqDistributeResultListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ별 배부 결과 조회
	  * </pre>
	  */
	public PlanningDBDAOSearchQtaRhqDistributeResultListRSQL(){
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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_ob_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOSearchQtaRhqDistributeResultListRSQL").append("\n"); 
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
		query.append("SELECT V.BSE_TP_CD" ).append("\n"); 
		query.append("        ,V.BSE_YR" ).append("\n"); 
		query.append("        ,V.BSE_QTR_CD" ).append("\n"); 
		query.append("        ,DECODE(V.OB_DIV_CD, 'O', 'O/B', 'N.O/B') AS OB_DIV_CD" ).append("\n"); 
		query.append("        ,DECODE(V.OFC_VW_CD, 'C', 'CONTRACT', 'LOADING') AS OFC_VW_CD" ).append("\n"); 
		query.append("        ,V.TRD_CD" ).append("\n"); 
		query.append("        ,V.SUB_TRD_CD" ).append("\n"); 
		query.append("        ,V.RLANE_CD" ).append("\n"); 
		query.append("        ,V.CONV_DIR_CD" ).append("\n"); 
		query.append("        ,SUBSTR(C.HUL_BND_CD, 1, 1) || '/' || SUBSTR(C.HUL_BND_CD, 2) AS HUL_BND_CD" ).append("\n"); 
		query.append("        ,V.BSE_WK" ).append("\n"); 
		query.append("        ,V.VSL_CD || V.SKD_VOY_NO || V.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("        ,V.FNL_BSA_CAPA" ).append("\n"); 
		query.append("        ,V.RHQ_CD" ).append("\n"); 
		query.append("        ,SUM(V.OFC_QTY) AS RHQ_QTY" ).append("\n"); 
		query.append("        ,SUM(V.OFC_REV) AS RHQ_REV" ).append("\n"); 
		query.append("    FROM SQM_DAT_RLT      R" ).append("\n"); 
		query.append("        ,SQM_SIMULATION_V V" ).append("\n"); 
		query.append("        ,COA_LANE_RGST    C" ).append("\n"); 
		query.append("   WHERE R.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("     AND R.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND R.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("     AND R.OFC_VW_CD   = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("     AND R.TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("     AND V.RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("     AND V.CONV_DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} == 'on' && ${f_trd_dir} != '' && ${f_trd_dir} != 'All')" ).append("\n"); 
		query.append("     AND C.HUL_BND_CD  = @[f_trd_dir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ob_div_cd} != '' && ${f_ob_div_cd} != 'All')" ).append("\n"); 
		query.append("     AND R.OB_DIV_CD   = @[f_ob_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("     AND R.RHQ_CD      = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND R.BSE_TP_CD   = V.BSE_TP_CD" ).append("\n"); 
		query.append("     AND R.BSE_YR      = V.BSE_YR" ).append("\n"); 
		query.append("     AND R.BSE_QTR_CD  = V.BSE_QTR_CD" ).append("\n"); 
		query.append("     AND R.OFC_VW_CD   = V.OFC_VW_CD" ).append("\n"); 
		query.append("     AND R.TRD_CD      = V.TRD_CD" ).append("\n"); 
		query.append("     AND DECODE(UPPER(R.RLANE_CD), 'ALL', V.RLANE_CD, R.RLANE_CD) = V.RLANE_CD" ).append("\n"); 
		query.append("     AND R.CONV_DIR_CD = V.CONV_DIR_CD" ).append("\n"); 
		query.append("     AND R.RHQ_CD      = V.RHQ_CD" ).append("\n"); 
		query.append("     AND R.TEAM_CD     = (SELECT CASE WHEN @[f_usr_ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN R.TEAM_CD" ).append("\n"); 
		query.append("                                                                                                                                          ELSE @[f_usr_ofc_cd]" ).append("\n"); 
		query.append("                                  END TEAM_CD" ).append("\n"); 
		query.append("                            FROM DUAL)" ).append("\n"); 
		query.append("     AND V.TRD_CD      = C.TRD_CD" ).append("\n"); 
		query.append("     AND V.RLANE_CD    = C.RLANE_CD" ).append("\n"); 
		query.append("     AND V.SKD_DIR_CD  = C.DIR_CD" ).append("\n"); 
		query.append("GROUP BY V.BSE_TP_CD" ).append("\n"); 
		query.append("        ,V.BSE_YR" ).append("\n"); 
		query.append("        ,V.BSE_QTR_CD" ).append("\n"); 
		query.append("        ,V.OB_DIV_CD" ).append("\n"); 
		query.append("        ,V.OFC_VW_CD" ).append("\n"); 
		query.append("        ,V.TRD_CD" ).append("\n"); 
		query.append("        ,V.SUB_TRD_CD" ).append("\n"); 
		query.append("        ,V.RLANE_CD" ).append("\n"); 
		query.append("        ,V.CONV_DIR_CD" ).append("\n"); 
		query.append("        ,C.HUL_BND_CD" ).append("\n"); 
		query.append("        ,V.BSE_WK" ).append("\n"); 
		query.append("        ,V.VSL_CD || V.SKD_VOY_NO || V.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,V.FNL_BSA_CAPA" ).append("\n"); 
		query.append("        ,V.RHQ_CD" ).append("\n"); 
		query.append("ORDER BY V.TRD_CD" ).append("\n"); 
		query.append("        ,V.SUB_TRD_CD" ).append("\n"); 
		query.append("        ,V.RLANE_CD" ).append("\n"); 
		query.append("        ,V.CONV_DIR_CD" ).append("\n"); 
		query.append("        ,V.BSE_WK" ).append("\n"); 
		query.append("        ,V.RHQ_CD" ).append("\n"); 

	}
}