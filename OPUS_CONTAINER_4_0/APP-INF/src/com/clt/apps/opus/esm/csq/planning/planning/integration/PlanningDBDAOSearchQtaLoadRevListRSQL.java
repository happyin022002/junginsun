/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PlanningDBDAOSearchQtaLoadRevListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.06 
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

public class PlanningDBDAOSearchQtaLoadRevListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [QTA Set up by Head Office (L/F & G.RPB)]을 [조회] 합니다
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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.planning.integration").append("\n"); 
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
		query.append("SELECT REV.BSE_TP_CD" ).append("\n"); 
		query.append("      ,REV.BSE_YR" ).append("\n"); 
		query.append("      ,REV.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,REV.OFC_VW_CD" ).append("\n"); 
		query.append("      ,REV.QTA_STEP_CD" ).append("\n"); 
		query.append("      ,REV.QTA_VER_NO" ).append("\n"); 
		query.append("      ,REV.TRD_CD" ).append("\n"); 
		query.append("      ,REV.RLANE_CD" ).append("\n"); 
		query.append("      ,REV.DIR_CD" ).append("\n"); 
		query.append("      ,REV.VSL_CD||REV.SKD_VOY_NO||REV.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      ,REV.VSL_CD" ).append("\n"); 
		query.append("      ,REV.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,REV.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,REV.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,REV.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,REV.FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,REV.LDF_RTO" ).append("\n"); 
		query.append("      ,REV.GRS_RPB_REV" ).append("\n"); 
		query.append("      ,REV.PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,REV.RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,VVD.BSE_WK" ).append("\n"); 
		query.append("  FROM CSQ_QTA_LOD_REV REV" ).append("\n"); 
		query.append("      ,CSQ_QTA_TGT_VVD VVD" ).append("\n"); 
		query.append(" WHERE REV.BSE_TP_CD  = VVD.BSE_TP_CD" ).append("\n"); 
		query.append("   AND REV.BSE_YR     = VVD.BSE_YR" ).append("\n"); 
		query.append("   AND REV.BSE_QTR_CD = VVD.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND REV.TRD_CD     = VVD.TRD_CD" ).append("\n"); 
		query.append("   AND REV.RLANE_CD   = VVD.RLANE_CD" ).append("\n"); 
		query.append("   AND REV.DIR_CD     = VVD.DIR_CD" ).append("\n"); 
		query.append("   AND REV.VSL_CD     = VVD.VSL_CD" ).append("\n"); 
		query.append("   AND REV.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND REV.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND REV.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND REV.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND SUBSTR(REV.QTA_VER_NO, 4, 6) = (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN SUBSTR(REV.QTA_VER_NO, 4, 6)" ).append("\n"); 
		query.append("                                                                                                                                                 ELSE @[ofc_cd]" ).append("\n"); 
		query.append("                                               END TEAM_CD" ).append("\n"); 
		query.append("                                         FROM DUAL)" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Y')" ).append("\n"); 
		query.append("   AND REV.BSE_QTR_CD = '00'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND REV.BSE_QTR_CD = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND REV.TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("   AND REV.CONV_DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("   AND REV.RLANE_CD  = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY REV.TRD_CD" ).append("\n"); 
		query.append("        ,REV.SUB_TRD_CD" ).append("\n"); 
		query.append("        ,REV.RLANE_CD" ).append("\n"); 
		query.append("        ,REV.CONV_DIR_CD" ).append("\n"); 
		query.append("        ,VVD.BSE_WK" ).append("\n"); 

	}
}