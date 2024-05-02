/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PlanningDBDAOSearchQtaByRhqResultRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.07 
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

public class PlanningDBDAOSearchQtaByRhqResultRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trade-Lane-Reversed Bound-RHQ-Office별로 판매목표 Load 및 G.REV Portion을 Simulation
	  * 
	  * *[CHM-201431754] 이혜민 simulation_v를 RHQ, Office 단으로 나눠서 관리
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 20160422 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * </pre>
	  */
	public PlanningDBDAOSearchQtaByRhqResultRSQL(){
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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ob_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOSearchQtaByRhqResultRSQL").append("\n"); 
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
		query.append("        ,DECODE(V.OB_DIV_CD, 'N', 'N.OB', 'O/B') AS OB_DIV_CD" ).append("\n"); 
		query.append("        ,DECODE(V.OFC_VW_CD, 'C', 'CONTRACT', 'L', 'LOADING') AS OFC_VW_CD" ).append("\n"); 
		query.append("        ,V.TRD_CD" ).append("\n"); 
		query.append("        ,V.SUB_TRD_CD" ).append("\n"); 
		query.append("        ,V.RLANE_CD" ).append("\n"); 
		query.append("        ,V.CONV_DIR_CD" ).append("\n"); 
		query.append("        ,BSE_WK" ).append("\n"); 
		query.append("        ,V.VSL_CD || V.SKD_VOY_NO || V.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("        ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("        ,V.RHQ_CD" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 
		query.append("        ,OFC_QTY" ).append("\n"); 
		query.append("        ,OFC_REV" ).append("\n"); 
		query.append("        ,DECODE(C.HUL_BND_CD,'HH','H/H','B/H') AS HUL_BND_CD" ).append("\n"); 
		query.append("    FROM SQM_DAT_RLT      	  R" ).append("\n"); 
		query.append("        ,SQM_SIMULATION_V_OFC V" ).append("\n"); 
		query.append("        ,MAS_LANE_RGST        C" ).append("\n"); 
		query.append("   WHERE R.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("     AND R.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND R.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("     AND R.OFC_VW_CD   = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#if (${f_ob_div_cd} != '' && ${f_ob_div_cd} != 'All')" ).append("\n"); 
		query.append("     AND R.OB_DIV_CD   = @[f_ob_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("     AND V.RGN_OFC_CD  = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND R.BSE_TP_CD   = V.BSE_TP_CD" ).append("\n"); 
		query.append("     AND R.BSE_YR      = V.BSE_YR" ).append("\n"); 
		query.append("     AND R.BSE_QTR_CD  = V.BSE_QTR_CD" ).append("\n"); 
		query.append("     AND R.OFC_VW_CD   = V.OFC_VW_CD" ).append("\n"); 
		query.append("     AND R.TRD_CD      = V.TRD_CD" ).append("\n"); 
		query.append("     AND DECODE(UPPER(R.RLANE_CD), 'ALL', V.RLANE_CD, R.RLANE_CD) = V.RLANE_CD" ).append("\n"); 
		query.append("     AND R.CONV_DIR_CD = V.CONV_DIR_CD" ).append("\n"); 
		query.append("     AND R.RHQ_CD      = V.RHQ_CD" ).append("\n"); 
		query.append("     AND R.RHQ_CD      = (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN R.RHQ_CD " ).append("\n"); 
		query.append("                                                                                                                                    ELSE DECODE(@[ofc_cd], 'SELCMI', R.RHQ_CD, @[ofc_cd])" ).append("\n"); 
		query.append("                                  END RHQ_CD " ).append("\n"); 
		query.append("                            FROM DUAL)" ).append("\n"); 
		query.append("     AND V.TRD_CD      = C.TRD_CD" ).append("\n"); 
		query.append("     AND V.RLANE_CD    = C.RLANE_CD" ).append("\n"); 
		query.append("     AND V.SKD_DIR_CD  = C.DIR_CD" ).append("\n"); 
		query.append("ORDER BY OFC_VW_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,CONV_DIR_CD" ).append("\n"); 
		query.append("        ,VVD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 

	}
}