/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PlanningDBDAOSearchDiffPfVerAddTargetVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.06 
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

public class PlanningDBDAOSearchDiffPfVerAddTargetVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add-Creation시 Target VVD Fix를 하는데 PF Skd Group MGMT에서 생성된 PF SKD VER과 다른것이 있는지 조회한다.
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
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.planning.integration").append("\n"); 
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
		query.append("      FROM COA_MON_VVD A1" ).append("\n"); 
		query.append("          ,BSA_VVD_MST A2" ).append("\n"); 
		query.append("          ,VSK_VSL_SKD A3" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND A1.RLANE_CD              = @[f_rlane_cd]" ).append("\n"); 
		query.append("       AND SUBSTR(A1.SLS_YRMON,0,4) = @[f_bse_yr]" ).append("\n"); 
		query.append("       AND A1.COST_WK      BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
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
		query.append("       AND A1.TRD_CD       = @[f_trd_cd]" ).append("\n"); 
		query.append("       ) A1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                       SELECT DISTINCT SUB_TRD_CD, RLANE_CD, PF_SVC_TP_CD" ).append("\n"); 
		query.append("                        FROM CSQ_SCTR_PF_GRP" ).append("\n"); 
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