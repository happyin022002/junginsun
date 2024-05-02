/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOSearchAdjCostDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.04
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.12.04 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOSearchAdjCostDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOSearchAdjCostDtlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_chkprd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.integration").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOSearchAdjCostDtlListRSQL").append("\n"); 
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
		query.append("SELECT COST_YRMON" ).append("\n"); 
		query.append("      , COST_WK" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , IOC_CD" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , SUB_TRD_CD" ).append("\n"); 
		query.append("      , SLS_YRMON" ).append("\n"); 
		query.append("      , MCNTR_STVG_AMT AS MTY_CNTR_STVG_AMT" ).append("\n"); 
		query.append("      , DECODE(SUM(MCNTR_STVG_AMT) OVER (PARTITION BY DECODE(@[f_chkprd], 'M', COST_YRMON, COST_WK)),0,0" ).append("\n"); 
		query.append("                 ,ROUND(MCNTR_STVG_AMT / SUM(MCNTR_STVG_AMT) OVER (PARTITION BY DECODE(@[f_chkprd], 'M', COST_YRMON, COST_WK)) * 100, 13)) MTY_CNTR_STVG_RT" ).append("\n"); 
		query.append("      , MCNTR_TRSP_AMT AS MTY_CNTR_TRSP_AMT" ).append("\n"); 
		query.append("      , NVL(USA_DMST_SAV_CR_AMT,0) USA_DMST_SAV_CR_AMT" ).append("\n"); 
		query.append("	  , NVL(USA_DMST_REPO_AMT,0) USA_DMST_REPO_AMT" ).append("\n"); 
		query.append("      , (MCNTR_TRSP_AMT + NVL(USA_DMST_SAV_CR_AMT,0) - NVL(USA_DMST_REPO_AMT,0)) AS MTY_CNTR_TRSP_INCL_CR_AMT" ).append("\n"); 
		query.append("      , DECODE(SUM(MCNTR_TRSP_AMT + NVL(USA_DMST_SAV_CR_AMT,0)) OVER (PARTITION BY DECODE(@[f_chkprd], 'M', COST_YRMON, COST_WK)),0,0" ).append("\n"); 
		query.append("                  ,ROUND((MCNTR_TRSP_AMT + NVL(USA_DMST_SAV_CR_AMT,0)) / SUM(MCNTR_TRSP_AMT + NVL(USA_DMST_SAV_CR_AMT,0)) OVER (PARTITION BY DECODE(@[f_chkprd], 'M', COST_YRMON, COST_WK)) * 100, 13)) MTY_CNTR_TRSP_RT" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("      , MCNTR_STVG_ADJ_AMT AS MTY_CNTR_STVG_ADJ_AMT" ).append("\n"); 
		query.append("      , MCNTR_TRSP_ADJ_AMT AS MTY_CNTR_TRSP_ADJ_AMT" ).append("\n"); 
		query.append("      , MCNTR_STVG_FNL_AMT AS MTY_CNTR_STVG_FNL_AMT" ).append("\n"); 
		query.append("      , MCNTR_TRSP_FNL_AMT AS MTY_CNTR_TRSP_FNL_AMT" ).append("\n"); 
		query.append("	  , NVL(USA_DMST_SAV_CR_AMT,0) USA_DMST_SAV_CR_AMT2" ).append("\n"); 
		query.append("	  , NVL(USA_DMST_REPO_AMT,0) USA_DMST_REPO_AMT2" ).append("\n"); 
		query.append("      , (MCNTR_TRSP_FNL_AMT - NVL(USA_DMST_SAV_CR_AMT,0) + NVL(USA_DMST_REPO_AMT,0)) AS TRSP_XCLD_CR_FNL_AMT" ).append("\n"); 
		query.append("   FROM COA_MNL_ADJ_COST" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("#if(${f_chkprd} =='M')" ).append("\n"); 
		query.append("  AND COST_YRMON    BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]   " ).append("\n"); 
		query.append("#elseif (${f_chkprd} =='W')" ).append("\n"); 
		query.append("  AND SLS_YRMON     LIKE @[f_year]||'%'    " ).append("\n"); 
		query.append("  AND COST_WK       BETWEEN @[f_fm_wk] AND @[f_to_wk]   " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}