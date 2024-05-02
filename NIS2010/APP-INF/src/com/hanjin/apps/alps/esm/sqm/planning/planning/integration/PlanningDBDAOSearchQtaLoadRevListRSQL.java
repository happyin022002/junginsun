/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PlanningDBDAOSearchQtaLoadRevListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.27 
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

public class PlanningDBDAOSearchQtaLoadRevListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [QTA Set up by Head Office (L/F & G.RPB)]을 [조회] 합니다
	  * 
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * * 2016.07.04 [CHM-201642265] Planning IAS-IP Supply 에외처리
	  * </pre>
	  */
	public PlanningDBDAOSearchQtaLoadRevListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOSearchQtaLoadRevListRSQL").append("\n"); 
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
		query.append("SELECT BSE_TP_CD" ).append("\n"); 
		query.append("      , BSE_YR" ).append("\n"); 
		query.append("      , BSE_QTR_CD" ).append("\n"); 
		query.append("      , OFC_VW_CD" ).append("\n"); 
		query.append("      , QTA_STEP_CD" ).append("\n"); 
		query.append("      , QTA_VER_NO" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , VVD" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , SKD_DIR_CD" ).append("\n"); 
		query.append("      , CONV_DIR_CD" ).append("\n"); 
		query.append("      , SUB_TRD_CD" ).append("\n"); 
		query.append("      , FNL_BSA_CAPA" ).append("\n"); 
		query.append("      , LDF_RTO" ).append("\n"); 
		query.append("      , GRS_RPB_REV" ).append("\n"); 
		query.append("      , PA_CM_UC_AMT" ).append("\n"); 
		query.append("      , RA_CM_UC_AMT" ).append("\n"); 
		query.append("      , BSE_WK" ).append("\n"); 
		query.append("      , HUL_BND_CD" ).append("\n"); 
		query.append("      , PA_CM_U_AMT" ).append("\n"); 
		query.append("      , RA_CM_U_AMT" ).append("\n"); 
		query.append("      , LOD_QTY " ).append("\n"); 
		query.append("      , ROUND(GRS_RPB_REV * LOD_QTY, 0) AS G_REV    --|GRS_RPB_REV|*|LOAD|" ).append("\n"); 
		query.append("      , ROUND(PA_CM_UC_AMT * LOD_QTY, 0) AS PA_CM_C --|PA_CM_UC_AMT|*|LOAD|" ).append("\n"); 
		query.append("      , ROUND(RA_CM_UC_AMT * LOD_QTY, 0) AS RA_CM_C --|RA_CM_UC_AMT|*|LOAD|" ).append("\n"); 
		query.append("      , DECODE(LDF_RTO, 0, 0, DECODE(GRS_RPB_REV, 0, 0, ROUND(GRS_RPB_REV * LOD_QTY, 0) - ROUND(PA_CM_UC_AMT * LOD_QTY, 0))) AS PA_CM   --|G_REV|-|PA_CM_C|" ).append("\n"); 
		query.append("      , DECODE(LDF_RTO, 0, 0, DECODE(GRS_RPB_REV, 0, 0, ROUND(GRS_RPB_REV * LOD_QTY, 0) - ROUND(RA_CM_UC_AMT * LOD_QTY, 0))) AS RA_CM   --|G_REV|-|RA_CM_C|" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("         SELECT REV.BSE_TP_CD" ).append("\n"); 
		query.append("              , REV.BSE_YR" ).append("\n"); 
		query.append("              , REV.BSE_QTR_CD" ).append("\n"); 
		query.append("              , REV.OFC_VW_CD" ).append("\n"); 
		query.append("              , REV.QTA_STEP_CD" ).append("\n"); 
		query.append("              , REV.QTA_VER_NO" ).append("\n"); 
		query.append("              , REV.TRD_CD" ).append("\n"); 
		query.append("              , REV.RLANE_CD" ).append("\n"); 
		query.append("              , REV.DIR_CD" ).append("\n"); 
		query.append("              , REV.VSL_CD||REV.SKD_VOY_NO||REV.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("              , REV.VSL_CD" ).append("\n"); 
		query.append("              , REV.SKD_VOY_NO" ).append("\n"); 
		query.append("              , REV.SKD_DIR_CD" ).append("\n"); 
		query.append("              , REV.CONV_DIR_CD" ).append("\n"); 
		query.append("              , REV.SUB_TRD_CD" ).append("\n"); 
		query.append("              , REV.FNL_BSA_CAPA" ).append("\n"); 
		query.append("              , REV.LDF_RTO" ).append("\n"); 
		query.append("              , REV.GRS_RPB_REV" ).append("\n"); 
		query.append("              , REV.PA_CM_UC_AMT" ).append("\n"); 
		query.append("              , REV.RA_CM_UC_AMT" ).append("\n"); 
		query.append("              , VVD.BSE_WK" ).append("\n"); 
		query.append("              , DECODE(MAS.HUL_BND_CD, 'HH', 'H/H', 'B/H') AS HUL_BND_CD" ).append("\n"); 
		query.append("              , DECODE(REV.LDF_RTO, 0, 0, DECODE(REV.GRS_RPB_REV, 0, 0, REV.GRS_RPB_REV - REV.PA_CM_UC_AMT)) AS PA_CM_U_AMT" ).append("\n"); 
		query.append("              , DECODE(REV.LDF_RTO, 0, 0, DECODE(REV.GRS_RPB_REV, 0, 0, REV.GRS_RPB_REV - REV.RA_CM_UC_AMT)) AS RA_CM_U_AMT" ).append("\n"); 
		query.append("              , DECODE(REV.SUB_TRD_CD, 'IP', NVL(REV.LOD_QTY,0), REV.FNL_BSA_CAPA * REV.LDF_RTO * 0.01) AS LOD_QTY" ).append("\n"); 
		query.append("           FROM SQM_QTA_LOD_REV REV" ).append("\n"); 
		query.append("              , SQM_QTA_TGT_VVD VVD" ).append("\n"); 
		query.append("              , MAS_LANE_RGST MAS" ).append("\n"); 
		query.append("          WHERE REV.BSE_TP_CD  = VVD.BSE_TP_CD" ).append("\n"); 
		query.append("            AND REV.BSE_YR     = VVD.BSE_YR" ).append("\n"); 
		query.append("            AND REV.BSE_QTR_CD = VVD.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND REV.TRD_CD     = VVD.TRD_CD" ).append("\n"); 
		query.append("            AND REV.RLANE_CD   = VVD.RLANE_CD" ).append("\n"); 
		query.append("            AND REV.DIR_CD     = VVD.DIR_CD" ).append("\n"); 
		query.append("            AND REV.VSL_CD     = VVD.VSL_CD" ).append("\n"); 
		query.append("            AND REV.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND REV.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND REV.RLANE_CD   = MAS.RLANE_CD" ).append("\n"); 
		query.append("            AND REV.DIR_CD     = MAS.DIR_CD" ).append("\n"); 
		query.append("            AND REV.TRD_CD     = MAS.TRD_CD" ).append("\n"); 
		query.append("            AND MAS.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("            AND REV.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("            AND REV.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("            AND SUBSTR(REV.QTA_VER_NO, 4, 6) =" ).append("\n"); 
		query.append("                (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255' ) " ).append("\n"); 
		query.append("                             THEN SUBSTR(REV.QTA_VER_NO, 4, 6) ELSE @[ofc_cd] END TEAM_CD FROM DUAL ) " ).append("\n"); 
		query.append("        #if (${f_bse_tp_cd} == 'Y')" ).append("\n"); 
		query.append("            AND REV.BSE_QTR_CD = '00' " ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND REV.BSE_QTR_CD = @[f_bse_qtr_cd] " ).append("\n"); 
		query.append("        #end #if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("            AND REV.TRD_CD     = @[f_trd_cd] " ).append("\n"); 
		query.append("        #end #if (${f_click} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("            AND REV.CONV_DIR_CD = @[f_dir_cd] " ).append("\n"); 
		query.append("        #end #if (${f_click} == 'on' && ${f_trd_dir} != '' && ${f_trd_dir} != 'All')" ).append("\n"); 
		query.append("            AND MAS.HUL_BND_CD = @[f_trd_dir] " ).append("\n"); 
		query.append("        #end #if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("            AND REV.RLANE_CD   = @[f_rlane_cd] " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 
		query.append("      , SUB_TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , CONV_DIR_CD" ).append("\n"); 
		query.append("      , BSE_WK" ).append("\n"); 

	}
}