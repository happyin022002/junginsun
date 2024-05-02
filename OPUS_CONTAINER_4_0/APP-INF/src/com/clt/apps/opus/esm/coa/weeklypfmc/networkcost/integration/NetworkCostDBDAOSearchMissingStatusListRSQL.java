/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOSearchMissingStatusListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchMissingStatusListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMissingStatusList SELECT
	  * </pre>
	  */
	public NetworkCostDBDAOSearchMissingStatusListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchMissingStatusListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      #if (${cost_yrwk} == 'W')" ).append("\n"); 
		query.append("          SUBSTR(A1.COST_YRWK,1,4)||'-'||SUBSTR(A1.COST_YRWK,5,2)   AS COST_YRWK" ).append("\n"); 
		query.append("      #else" ).append("\n"); 
		query.append("          SUBSTR(A1.COST_YRWK,1,4)||'-'||A1.COST_MON                AS COST_YRWK" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("     ,A1.STND_COST_CD                                               AS STND_COST_CD" ).append("\n"); 
		query.append("     ,A2.STND_COST_NM                                               AS STND_COST_NM" ).append("\n"); 
		query.append("     ,A1.TRD_CD                                                     AS TRD_CD" ).append("\n"); 
		query.append("     ,A1.RLANE_CD                                                   AS RLANE_CD" ).append("\n"); 
		query.append("     ,A1.IOC_CD                                                     AS IOC_CD" ).append("\n"); 
		query.append("     ,A1.VSL_CD||A1.SKD_VOY_NO||A1.DIR_CD                           AS VVD_CD" ).append("\n"); 
		query.append("     ,TO_CHAR(A1.CRE_DT,'YYYY-MM-DD HH24:MI:SS')                    AS CRE_DT" ).append("\n"); 
		query.append("     ,A1.COST_CALC_RMK                                              AS COST_CALC_RMK" ).append("\n"); 
		query.append("FROM COA_MSS_STS   A1" ).append("\n"); 
		query.append("    ,COA_STND_ACCT A2" ).append("\n"); 
		query.append("WHERE A1.STND_COST_CD = A2.STND_COST_CD (+)" ).append("\n"); 
		query.append("    AND A1.PRC_NM = @[prc_nm]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${bsa_zr_flg} != '')" ).append("\n"); 
		query.append("        AND A1.BSA_ZR_FLG = 'N'			--SJH.20141112.MOD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${cost_yrwk} == 'W')" ).append("\n"); 
		query.append("        AND A1.COST_YRWK BETWEEN @[year]||@[fm_week] AND @[year]||@[to_week]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND SUBSTR(A1.COST_YRWK,1,4) || A1.COST_MON BETWEEN @[year]||@[fm_month] AND @[year]||@[to_month]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${trd_cd} != '')" ).append("\n"); 
		query.append("        AND A1.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("        AND A1.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("        AND A1.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("        AND A1.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${dir_cd} != '')" ).append("\n"); 
		query.append("        AND A1.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${stnd_cost_cd} != '')" ).append("\n"); 
		query.append("        AND A1.STND_COST_CD = @[stnd_cost_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY 1" ).append("\n"); 

	}
}