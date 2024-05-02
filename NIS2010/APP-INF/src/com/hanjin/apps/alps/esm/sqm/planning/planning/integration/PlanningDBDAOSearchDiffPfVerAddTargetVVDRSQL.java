/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PlanningDBDAOSearchDiffPfVerAddTargetVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.21 
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

public class PlanningDBDAOSearchDiffPfVerAddTargetVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add-Creation시 Target VVD Fix를 하는데 PF Skd Group MGMT에서 생성된 PF SKD VER과 다른것이 있는지 조회한다.
	  * 
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2016.03.21 CHM-201640396 From Week / To Week 수정 시, RHQ가 두 개 이상이면 Validation 걸리는 로직 수정 요청 CSR
	  * </pre>
	  */
	public PlanningDBDAOSearchDiffPfVerAddTargetVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOSearchDiffPfVerAddTargetVVDRSQL").append("\n"); 
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
		query.append("SELECT A1.RLANE_CD||'-'||A1.PF_SKD_TP_CD AS DIFF_PF_VER" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    (    " ).append("\n"); 
		query.append("       SELECT DISTINCT" ).append("\n"); 
		query.append("              A1.TRD_CD" ).append("\n"); 
		query.append("             ,A1.RLANE_CD" ).append("\n"); 
		query.append("             ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("             ,A3.PF_SKD_TP_CD" ).append("\n"); 
		query.append("      FROM MAS_MON_VVD A1" ).append("\n"); 
		query.append("          ,BSA_VVD_MST A2" ).append("\n"); 
		query.append("          ,VSK_VSL_SKD A3" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND A1.RLANE_CD              = @[f_rlane_cd]" ).append("\n"); 
		query.append("       AND SUBSTR(A1.SLS_YRMON,0,4) = @[f_bse_yr]" ).append("\n"); 
		query.append("       AND SUBSTR(A1.COST_YRMON, 5) BETWEEN (CASE WHEN @[f_bse_qtr_cd] = '1Q' THEN '01' WHEN @[f_bse_qtr_cd] = '2Q' THEN '04' WHEN @[f_bse_qtr_cd] = '3Q' THEN '07' WHEN @[f_bse_qtr_cd] = '4Q' THEN '10' ELSE '01' END) " ).append("\n"); 
		query.append("                                              AND (CASE WHEN @[f_bse_qtr_cd] = '1Q' THEN '03' WHEN @[f_bse_qtr_cd] = '2Q' THEN '06' WHEN @[f_bse_qtr_cd] = '3Q' THEN '09' WHEN @[f_bse_qtr_cd] = '4Q' THEN '12' ELSE '12' END)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND A1.TRD_CD       = A2.TRD_CD(+)" ).append("\n"); 
		query.append("       AND A1.RLANE_CD     = A2.RLANE_CD(+)" ).append("\n"); 
		query.append("       AND A1.VSL_CD       = A2.VSL_CD(+)" ).append("\n"); 
		query.append("       AND A1.SKD_VOY_NO   = A2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("       AND A1.DIR_CD       = A2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND A1.VSL_CD       = A3.VSL_CD" ).append("\n"); 
		query.append("       AND A1.SKD_VOY_NO   = A3.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND A1.DIR_CD       = A3.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND A1.SLAN_CD      = A3.VSL_SLAN_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND A1.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("       AND A1.TRD_CD       = 'IAS'" ).append("\n"); 
		query.append("       AND A1.DIR_CD = (SELECT NVL(B.LANE_DIR_CD, A1.DIR_CD) FROM SQM_QTA_LANE_MGMT B WHERE B.TRD_CD = A1.TRD_CD AND B.RLANE_CD = A1.RLANE_CD)" ).append("\n"); 
		query.append("       ) A1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                       SELECT DISTINCT SUB_TRD_CD, RLANE_CD, PF_SVC_TP_CD" ).append("\n"); 
		query.append("                        FROM SQM_SCTR_PF_GRP" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                        AND BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                        AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                        AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                        AND RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("                        ) A2" ).append("\n"); 
		query.append("                WHERE A2.SUB_TRD_CD||A2.RLANE_CD||A2.PF_SVC_TP_CD =  A1.SUB_TRD_CD||A1.RLANE_CD||A1.PF_SKD_TP_CD)" ).append("\n"); 
		query.append("ORDER BY RLANE_CD , PF_SKD_TP_CD" ).append("\n"); 

	}
}