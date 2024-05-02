/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FullCostDBDAOSearchLinkCostListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.fullcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FullCostDBDAOSearchLinkCostListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA_LNK_AVG_STND_COST, COA_COST_SRC_ACCT, COA_STND_ACCT 테이블의 데이터 조회(Empty)   
	  * </pre>
	  */
	public FullCostDBDAOSearchLinkCostListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_from",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.fullcost.integration").append("\n"); 
		query.append("FileName : FullCostDBDAOSearchLinkCostListVORSQL").append("\n"); 
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
		query.append("SELECT B1.LNK_FM_NOD_CD" ).append("\n"); 
		query.append("	    ,B1.LNK_TO_NOD_CD" ).append("\n"); 
		query.append("      ,'' COST_ACT_GRP_CD" ).append("\n"); 
		query.append("      ,'' GRP" ).append("\n"); 
		query.append("      ,SUM(B1.STND_COST_USD_AMT) COST" ).append("\n"); 
		query.append("      ,B2.STND_COST_CD" ).append("\n"); 
		query.append("      ,COA_GET_COM_NM_FNC('STND_COST_CD', B2.STND_COST_CD) STND_COST_NM" ).append("\n"); 
		query.append("      ,B2.COA_COST_SRC_CD" ).append("\n"); 
		query.append("      ,COA_GET_COM_NM_FNC('COA_COST_SRC_CD', B2.COA_COST_SRC_CD) COA_COST_SRC_CD_NM" ).append("\n"); 
		query.append("      ,DECODE(GROUPING(B2.COA_COST_SRC_CD), 1, 1, 2) LVL" ).append("\n"); 
		query.append("      ,'AVERAGE' COST_ASS_BSE_CD" ).append("\n"); 
		query.append("      ,B1.LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,DECODE(@[f_cost_loc_grp_cd], 'L','LCC', 'C','LOC', 'S','SCC', 'E','ECC', 'R','RCC', 'NOD') LOC_TYPE		--20160303.ADD" ).append("\n"); 
		query.append("      ,DECODE(GROUPING(B2.COA_COST_SRC_CD), 1, COA_GET_COM_NM_FNC('STND_COST_CD', B2.STND_COST_CD), COA_GET_COM_NM_FNC('COA_COST_SRC_CD', B2.COA_COST_SRC_CD)) COST_NM" ).append("\n"); 
		query.append("  FROM (SELECT LNK_FM_NOD_CD, LNK_TO_NOD_CD" ).append("\n"); 
		query.append("			        ,COA_COST_SRC_CD, LOCL_CURR_CD                                              " ).append("\n"); 
		query.append("              ,SUM(STND_COST_USD_AMT) STND_COST_USD_AMT                                               " ).append("\n"); 
		query.append("          FROM COA_LNK_AVG_STND_COST                                               " ).append("\n"); 
		query.append("         WHERE 1 = 1                                               " ).append("\n"); 
		query.append("           AND COST_LOC_GRP_CD = @[f_cost_loc_grp_cd]                                              " ).append("\n"); 
		query.append("           AND FULL_MTY_CD = @[f_full_mty_cd]                                                " ).append("\n"); 
		query.append("                                     " ).append("\n"); 
		query.append("           #if (${f_cost_loc_grp_cd} == 'N') " ).append("\n"); 
		query.append("           AND LNK_FM_NOD_CD LIKE @[f_from] || '%'" ).append("\n"); 
		query.append("           AND LNK_TO_NOD_CD LIKE @[f_to] || '%'" ).append("\n"); 
		query.append("         #else " ).append("\n"); 
		query.append("           AND LNK_FM_NOD_CD = NVL(COA_LOC_FNC(@[f_from], DECODE(@[f_cost_loc_grp_cd], 'L','LCC', 'C','LOC', 'S','SCC', 'E','ECC', 'R','RCC', 'NOD')), @[f_from]) --20160303.MOD" ).append("\n"); 
		query.append("           AND LNK_TO_NOD_CD = NVL(COA_LOC_FNC(@[f_to], DECODE(@[f_cost_loc_grp_cd], 'L','LCC', 'C','LOC', 'S','SCC', 'E','ECC', 'R','RCC', 'NOD')), @[f_to]) " ).append("\n"); 
		query.append("          #end  " ).append("\n"); 
		query.append("		                                              " ).append("\n"); 
		query.append("           #if (${f_cost_yrmon} != '') " ).append("\n"); 
		query.append("           AND COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("          #end    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           #if (${f_cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("           AND CNTR_TPSZ_CD = @[f_cntr_tpsz_cd] " ).append("\n"); 
		query.append("          #end                                                                                        " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("       GROUP BY LNK_FM_NOD_CD, LNK_TO_NOD_CD, COA_COST_SRC_CD, LOCL_CURR_CD) B1                                               " ).append("\n"); 
		query.append("     ,(SELECT DISTINCT A1.STND_COST_CD                                               " ).append("\n"); 
		query.append("                      ,A1.COA_COST_SRC_CD                                               " ).append("\n"); 
		query.append("                  FROM COA_COST_SRC_ACCT A1, COA_STND_ACCT A2                                               " ).append("\n"); 
		query.append("                 WHERE 1 = 1                                               " ).append("\n"); 
		query.append("                   AND A1.COST_SRC_SYS_CD = 'TRS'                                               " ).append("\n"); 
		query.append("                   AND A1.STND_COST_CD = A2.STND_COST_CD                                               " ).append("\n"); 
		query.append("              GROUP BY A1.STND_COST_CD, A1.COA_COST_SRC_CD) B2                                               " ).append("\n"); 
		query.append("  WHERE 1 = 1                                              " ).append("\n"); 
		query.append("    AND B1.COA_COST_SRC_CD = B2.COA_COST_SRC_CD                                               " ).append("\n"); 
		query.append("GROUP BY B1.LNK_FM_NOD_CD, B1.LNK_TO_NOD_CD, B2.STND_COST_CD, CUBE(B2.COA_COST_SRC_CD), B1.LOCL_CURR_CD" ).append("\n"); 

	}
}