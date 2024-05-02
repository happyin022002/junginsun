/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOAverageUCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOAverageUCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History------------------------------
	  * </pre>
	  */
	public NetworkCostDBDAOAverageUCRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOAverageUCRSQL").append("\n"); 
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
		query.append("	  , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03217' AND INTG_CD_VAL_CTNT = D.HUL_BND_CD) HUL_BND_CD" ).append("\n"); 
		query.append("      , A.AMT_01" ).append("\n"); 
		query.append("      , A.AMT_02" ).append("\n"); 
		query.append("      , A.AMT_03" ).append("\n"); 
		query.append("      , A.AMT_04" ).append("\n"); 
		query.append("      , A.AMT_05" ).append("\n"); 
		query.append("      , A.AMT_06" ).append("\n"); 
		query.append("      , A.AMT_07" ).append("\n"); 
		query.append("      , A.AMT_08" ).append("\n"); 
		query.append("      , A.AMT_09" ).append("\n"); 
		query.append("      , A.AMT_10" ).append("\n"); 
		query.append("      , A.AMT_11" ).append("\n"); 
		query.append("      , A.AMT_12" ).append("\n"); 
		query.append("      , A.AMT_13" ).append("\n"); 
		query.append("      , A.AMT_14" ).append("\n"); 
		query.append("      , (SELECT DECODE(MIN(OP_LANE_TP_CD),'LA','Lane Avg U/C','Other(OP1)')" ).append("\n"); 
		query.append("           FROM MAS_LANE_RGST" ).append("\n"); 
		query.append("          WHERE RLANE_CD  = A.RLANE_CD" ).append("\n"); 
		query.append("            AND DIR_CD    = A.DIR_CD" ).append("\n"); 
		query.append("            AND TRD_CD    = A.TRD_CD" ).append("\n"); 
		query.append("            AND RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("        ) OP_LANE_TP_CD" ).append("\n"); 
		query.append("      , B.UC_OWN_FREQ_NO" ).append("\n"); 
		query.append("      , B.UC_CHT_FREQ_NO" ).append("\n"); 
		query.append("      , B.UC_OTH_FREQ_NO" ).append("\n"); 
		query.append("      , C.FIX_OWN_FREQ_NO" ).append("\n"); 
		query.append("      , C.FIX_CHT_FREQ_NO" ).append("\n"); 
		query.append("      , C.FIX_OTH_FREQ_NO" ).append("\n"); 
		query.append("      , '' STND_COST_CD" ).append("\n"); 
		query.append("      , '' COST_USE_TP_CD" ).append("\n"); 
		query.append("      , '' CRE_USR_ID" ).append("\n"); 
		query.append("      , '' CRE_DT" ).append("\n"); 
		query.append("      , '' UPD_USR_ID" ).append("\n"); 
		query.append("      , '' UPD_DT" ).append("\n"); 
		query.append("      , '' F_COST_YRMON" ).append("\n"); 
		query.append("      , '' F_TRD_CD" ).append("\n"); 
		query.append("      , '' F_DIR_CD" ).append("\n"); 
		query.append("      , '' F_RLANE_CD" ).append("\n"); 
		query.append("      , '' F_FM_YRWK" ).append("\n"); 
		query.append("      , '' F_TO_YRWK" ).append("\n"); 
		query.append("      , '' VSL_OSHP_CD" ).append("\n"); 
		query.append("      , '' HJS_BSA_CAPA" ).append("\n"); 
		query.append("      , '' FREQ_NO" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("        (SELECT COST_YRMON" ).append("\n"); 
		query.append("              , TRD_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("              , SUM(DECODE(STND_COST_CD, '43102011', OP_UC_AMT, 0)) AS AMT_01" ).append("\n"); 
		query.append("              , SUM(DECODE(STND_COST_CD, '53101000', OP_UC_AMT, 0)) AS AMT_02" ).append("\n"); 
		query.append("              , SUM(DECODE(STND_COST_CD, '53102000', OP_UC_AMT, 0)) AS AMT_03" ).append("\n"); 
		query.append("              , SUM(DECODE(STND_COST_CD, '53200000', OP_UC_AMT, 0)) AS AMT_04" ).append("\n"); 
		query.append("              , SUM(DECODE(STND_COST_CD, '54100000', OP_UC_AMT, 0)) AS AMT_05" ).append("\n"); 
		query.append("              , SUM(DECODE(STND_COST_CD, '54250000', OP_UC_AMT, 0)) AS AMT_06" ).append("\n"); 
		query.append("              , SUM(DECODE(STND_COST_CD, '54300000', OP_UC_AMT, 0)) AS AMT_07" ).append("\n"); 
		query.append("              , SUM(DECODE(STND_COST_CD, '54200000', OP_UC_AMT, 0)) AS AMT_08" ).append("\n"); 
		query.append("              , SUM(DECODE(STND_COST_CD, '54150000', OP_UC_AMT, 0)) AS AMT_09" ).append("\n"); 
		query.append("              , SUM(DECODE(STND_COST_CD, '54450000', OP_UC_AMT, 0)) AS AMT_10" ).append("\n"); 
		query.append("              , SUM(DECODE(STND_COST_CD, '54180000', OP_UC_AMT, 0)) AS AMT_11" ).append("\n"); 
		query.append("              , SUM(DECODE(STND_COST_CD, '54550000', OP_UC_AMT, 0)) AS AMT_12" ).append("\n"); 
		query.append("              , SUM(DECODE(STND_COST_CD, '54350000', OP_UC_AMT, 0)) AS AMT_13" ).append("\n"); 
		query.append("              , SUM(DECODE(STND_COST_CD, '54400000', OP_UC_AMT, 0)) AS AMT_14" ).append("\n"); 
		query.append("           FROM MAS_OP_AVG_UT_COST" ).append("\n"); 
		query.append("          WHERE COST_YRMON     = @[f_cost_yrmon]" ).append("\n"); 
		query.append("            AND COST_USE_TP_CD = 'A'" ).append("\n"); 
		query.append(" #if (${f_trd_cd} != '')  	  " ).append("\n"); 
		query.append("            AND TRD_CD	       = @[f_trd_cd] " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${f_rlane_cd} != '') " ).append("\n"); 
		query.append("            AND RLANE_CD       = @[f_rlane_cd] " ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append(" #if (${f_dir_cd} != '') " ).append("\n"); 
		query.append("            AND DIR_CD         = @[f_dir_cd] " ).append("\n"); 
		query.append(" #end 		  " ).append("\n"); 
		query.append("                -- 검색조건" ).append("\n"); 
		query.append("       GROUP BY COST_YRMON" ).append("\n"); 
		query.append("              , TRD_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("      , (SELECT COST_YRMON" ).append("\n"); 
		query.append("              , TRD_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("              , MAX(DECODE(VSL_OSHP_CD, 'OWN', FREQ_NO, 0)) UC_OWN_FREQ_NO" ).append("\n"); 
		query.append("              , MAX(DECODE(VSL_OSHP_CD, 'CHT', FREQ_NO, 0)) UC_CHT_FREQ_NO" ).append("\n"); 
		query.append("              , MAX(DECODE(VSL_OSHP_CD, 'OTH', FREQ_NO, 0)) UC_OTH_FREQ_NO" ).append("\n"); 
		query.append("           FROM MAS_OP_AVG_VSL_TP_COST" ).append("\n"); 
		query.append("          WHERE COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append(" #if (${f_trd_cd} != '')  	  " ).append("\n"); 
		query.append("            AND TRD_CD	       = @[f_trd_cd] " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${f_rlane_cd} != '') " ).append("\n"); 
		query.append("            AND RLANE_CD       = @[f_rlane_cd] " ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append(" #if (${f_dir_cd} != '') " ).append("\n"); 
		query.append("            AND DIR_CD         = @[f_dir_cd] " ).append("\n"); 
		query.append(" #end 		  " ).append("\n"); 
		query.append("       GROUP BY COST_YRMON" ).append("\n"); 
		query.append("              , TRD_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 
		query.append("      , (SELECT COST_YRMON" ).append("\n"); 
		query.append("              , TRD_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , MAX(DECODE(VSL_OSHP_CD, 'OWN', FREQ_NO, 0)) FIX_OWN_FREQ_NO" ).append("\n"); 
		query.append("              , MAX(DECODE(VSL_OSHP_CD, 'CHT', FREQ_NO, 0)) FIX_CHT_FREQ_NO" ).append("\n"); 
		query.append("              , MAX(DECODE(VSL_OSHP_CD, 'OTH', FREQ_NO, 0)) FIX_OTH_FREQ_NO" ).append("\n"); 
		query.append("           FROM MAS_LANE_VSL_TP_FREQ" ).append("\n"); 
		query.append("          WHERE COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append(" #if (${f_trd_cd} != '')  	  " ).append("\n"); 
		query.append("            AND TRD_CD	       = @[f_trd_cd] " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${f_rlane_cd} != '') " ).append("\n"); 
		query.append("            AND RLANE_CD       = @[f_rlane_cd] " ).append("\n"); 
		query.append(" #end  " ).append("\n"); 
		query.append("       GROUP BY COST_YRMON" ).append("\n"); 
		query.append("              , TRD_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("        ) C," ).append("\n"); 
		query.append("        (SELECT TRD_CD, RLANE_CD, IOC_CD, DIR_CD, HUL_BND_CD FROM MAS_LANE_RGST) D" ).append("\n"); 
		query.append("  WHERE A.COST_YRMON = B.COST_YRMON(+)" ).append("\n"); 
		query.append("    AND A.TRD_CD     = B.TRD_CD(+)" ).append("\n"); 
		query.append("    AND A.RLANE_CD   = B.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND A.DIR_CD     = B.DIR_CD(+)" ).append("\n"); 
		query.append("    AND A.COST_YRMON = C.COST_YRMON(+)" ).append("\n"); 
		query.append("    AND A.TRD_CD     = C.TRD_CD(+)" ).append("\n"); 
		query.append("    AND A.RLANE_CD   = C.RLANE_CD(+)" ).append("\n"); 
		query.append("	AND A.TRD_CD          = D.TRD_CD" ).append("\n"); 
		query.append("    AND A.RLANE_CD        = D.RLANE_CD" ).append("\n"); 
		query.append("    --AND A.IOC_CD          = D.IOC_CD" ).append("\n"); 
		query.append("    AND A.DIR_CD          = D.DIR_CD    " ).append("\n"); 
		query.append("ORDER BY A.TRD_CD" ).append("\n"); 
		query.append("      , A.RLANE_CD" ).append("\n"); 
		query.append("      , A.DIR_CD" ).append("\n"); 

	}
}