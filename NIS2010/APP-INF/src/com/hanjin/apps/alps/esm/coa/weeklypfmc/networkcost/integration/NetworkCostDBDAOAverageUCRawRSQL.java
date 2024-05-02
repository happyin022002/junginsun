/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOAverageUCRawRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOAverageUCRawRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History------------------------------
	  * </pre>
	  */
	public NetworkCostDBDAOAverageUCRawRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOAverageUCRawRSQL").append("\n"); 
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
		query.append("SELECT A.COST_YRMON" ).append("\n"); 
		query.append("      , A.TRD_CD" ).append("\n"); 
		query.append("      , A.RLANE_CD" ).append("\n"); 
		query.append("      , A.DIR_CD" ).append("\n"); 
		query.append("      , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03217' AND INTG_CD_VAL_CTNT = D.HUL_BND_CD) HUL_BND_CD" ).append("\n"); 
		query.append("      , A.VSL_OSHP_CD" ).append("\n"); 
		query.append("      , A.FNL_HJS_BSA_CAPA HJS_BSA_CAPA" ).append("\n"); 
		query.append("      , A.FREQ_NO" ).append("\n"); 
		query.append("      , SUM(DECODE(STND_COST_CD, '43102011', NTWK_HIR_COST_AMT, 0)) AS AMT_01" ).append("\n"); 
		query.append("      , SUM(DECODE(STND_COST_CD, '53101000', NTWK_HIR_COST_AMT, 0)) AS AMT_02" ).append("\n"); 
		query.append("      , SUM(DECODE(STND_COST_CD, '53102000', NTWK_HIR_COST_AMT, 0)) AS AMT_03" ).append("\n"); 
		query.append("      , SUM(DECODE(STND_COST_CD, '53200000', NTWK_HIR_COST_AMT, 0)) AS AMT_04" ).append("\n"); 
		query.append("      , SUM(DECODE(STND_COST_CD, '54100000', NTWK_HIR_COST_AMT, 0)) AS AMT_05" ).append("\n"); 
		query.append("      , SUM(DECODE(STND_COST_CD, '54250000', NTWK_HIR_COST_AMT, 0)) AS AMT_06" ).append("\n"); 
		query.append("      , SUM(DECODE(STND_COST_CD, '54300000', NTWK_HIR_COST_AMT, 0)) AS AMT_07" ).append("\n"); 
		query.append("      , SUM(DECODE(STND_COST_CD, '54200000', NTWK_HIR_COST_AMT, 0)) AS AMT_08" ).append("\n"); 
		query.append("      , SUM(DECODE(STND_COST_CD, '54150000', NTWK_HIR_COST_AMT, 0)) AS AMT_09" ).append("\n"); 
		query.append("      , SUM(DECODE(STND_COST_CD, '54450000', NTWK_HIR_COST_AMT, 0)) AS AMT_10" ).append("\n"); 
		query.append("      , SUM(DECODE(STND_COST_CD, '54180000', NTWK_HIR_COST_AMT, 0)) AS AMT_11" ).append("\n"); 
		query.append("      , SUM(DECODE(STND_COST_CD, '54550000', NTWK_HIR_COST_AMT, 0)) AS AMT_12" ).append("\n"); 
		query.append("      , SUM(DECODE(STND_COST_CD, '54350000', NTWK_HIR_COST_AMT, 0)) AS AMT_13" ).append("\n"); 
		query.append("      , SUM(DECODE(STND_COST_CD, '54400000', NTWK_HIR_COST_AMT, 0)) AS AMT_14" ).append("\n"); 
		query.append("   FROM COA_OP_AVG_VSL_TP_COST A, (SELECT TRD_CD, RLANE_CD, IOC_CD, DIR_CD, HUL_BND_CD FROM COA_LANE_RGST) D" ).append("\n"); 
		query.append("  WHERE A.COST_YRMON     = @[f_cost_yrmon]" ).append("\n"); 
		query.append(" #if (${f_trd_cd} != '')  	  " ).append("\n"); 
		query.append("    AND A.TRD_CD	       = @[f_trd_cd] " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${f_rlane_cd} != '') " ).append("\n"); 
		query.append("    AND A.RLANE_CD       = @[f_rlane_cd] " ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append(" #if (${f_dir_cd} != '') " ).append("\n"); 
		query.append("    AND A.DIR_CD         = @[f_dir_cd] " ).append("\n"); 
		query.append(" #end 		  " ).append("\n"); 
		query.append("    -- 검색조건" ).append("\n"); 
		query.append("	AND A.TRD_CD          = D.TRD_CD" ).append("\n"); 
		query.append("    AND A.RLANE_CD        = D.RLANE_CD    " ).append("\n"); 
		query.append("    AND A.DIR_CD          = D.DIR_CD" ).append("\n"); 
		query.append("GROUP BY A.COST_YRMON" ).append("\n"); 
		query.append("      , A.TRD_CD" ).append("\n"); 
		query.append("      , A.RLANE_CD" ).append("\n"); 
		query.append("      , A.DIR_CD" ).append("\n"); 
		query.append("      , D.HUL_BND_CD" ).append("\n"); 
		query.append("      , A.VSL_OSHP_CD" ).append("\n"); 
		query.append("      , A.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("      , A.FREQ_NO" ).append("\n"); 
		query.append("ORDER BY A.COST_YRMON" ).append("\n"); 
		query.append("      , A.TRD_CD" ).append("\n"); 
		query.append("      , A.RLANE_CD" ).append("\n"); 
		query.append("      , A.DIR_CD" ).append("\n"); 
		query.append("      , A.VSL_OSHP_CD" ).append("\n"); 
		query.append("      , A.DIR_CD" ).append("\n"); 

	}
}