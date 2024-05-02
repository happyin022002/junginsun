/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PlanningDBDAOSearchQtaSetUpHeadOfficeListRSQL.java
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

public class PlanningDBDAOSearchQtaSetUpHeadOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 매년 또는 매분기 트래이드팀의 User들이  Out Bound (Loading only), In Bound (Contract, Loading)별 Trade-Lane-Bound-RHQ별로 판매목표 Load 및 G.REV Portion을 조회
	  * </pre>
	  */
	public PlanningDBDAOSearchQtaSetUpHeadOfficeListRSQL(){
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
		params.put("f_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_ob_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOSearchQtaSetUpHeadOfficeListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,DECODE(A1.OFC_VW_CD, 'L', 'Loading','C','Contract') AS OFC_VW_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A3.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,DECODE(A4.OB_DIV_CD, 'O', 'OB','N','N.OB') AS OB_DIV_CD" ).append("\n"); 
		query.append("      ,A3.RHQ_CD" ).append("\n"); 
		query.append("      ,NVL(A3.GID_LOD_POTN_RTO, 0) AS GID_LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,NVL(A3.LOD_POTN_RTO    , 0) AS LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,NVL(A3.GID_REV_POTN_RTO, 0) AS GID_REV_POTN_RTO" ).append("\n"); 
		query.append("      ,NVL(A3.REV_POTN_RTO    , 0) AS REV_POTN_RTO" ).append("\n"); 
		query.append("  FROM CSQ_QTA_LANE_OFC  A1" ).append("\n"); 
		query.append("      ,CSQ_QTA_POTN_MGMT A3" ).append("\n"); 
		query.append("      ,CSQ_DAT_RLT       A4" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A1.OFC_VW_CD   = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RHQ_CD      = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ob_div_cd} != '' && ${f_ob_div_cd} != 'All')" ).append("\n"); 
		query.append("   AND A4.OB_DIV_CD   = @[f_ob_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("   AND A3.CONV_DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD   = A3.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = A3.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = A3.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.OFC_VW_CD   = A3.OFC_VW_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD      = A3.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD    = A3.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD      = A3.DIR_CD" ).append("\n"); 
		query.append("   AND A1.RHQ_CD      = A3.RHQ_CD" ).append("\n"); 
		query.append("   AND A3.BSE_TP_CD   = A4.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A3.BSE_YR      = A4.BSE_YR" ).append("\n"); 
		query.append("   AND A3.BSE_QTR_CD  = A4.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A3.OFC_VW_CD   = A4.OFC_VW_CD" ).append("\n"); 
		query.append("   AND A3.TRD_CD      = A4.TRD_CD" ).append("\n"); 
		query.append("   AND A3.CONV_DIR_CD = A4.CONV_DIR_CD" ).append("\n"); 
		query.append("   AND A3.RHQ_CD      = A4.RHQ_CD" ).append("\n"); 
		query.append("   AND A1.CSQ_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A3.QTA_STEP_CD = '02'" ).append("\n"); 
		query.append("   AND SUBSTR(A3.QTA_VER_NO, 4, 6) = (SELECT CASE WHEN @[f_ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN SUBSTR(A3.QTA_VER_NO, 4, 6)" ).append("\n"); 
		query.append("                                                                                                                                                  ELSE @[f_ofc_cd]" ).append("\n"); 
		query.append("                                              END TEAM_CD" ).append("\n"); 
		query.append("                                        FROM DUAL)" ).append("\n"); 
		query.append("ORDER BY A1.TRD_CD" ).append("\n"); 
		query.append("        ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("        ,A1.RLANE_CD" ).append("\n"); 
		query.append("        ,A3.CONV_DIR_CD" ).append("\n"); 
		query.append("        ,A3.RHQ_CD" ).append("\n"); 

	}
}