/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FullCostDBDAOSearchMonthNodeCostListVORSQL.java
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

public class FullCostDBDAOSearchMonthNodeCostListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  COA_NOD_AVG_STND_COST 테이블의 데이터 조회 (Empty)
	  * </pre>
	  */
	public FullCostDBDAOSearchMonthNodeCostListVORSQL(){
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
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.fullcost.integration").append("\n"); 
		query.append("FileName : FullCostDBDAOSearchMonthNodeCostListVORSQL").append("\n"); 
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
		query.append("SELECT '' COST_ACT_GRP_CD           " ).append("\n"); 
		query.append("      ,M.STND_COST_CD           " ).append("\n"); 
		query.append("      ,K.COA_COST_SRC_CD           " ).append("\n"); 
		query.append("      ,'' GRP           " ).append("\n"); 
		query.append("      ,COA_GET_COM_NM_FNC('STND_COST_CD', M.STND_COST_CD) STND_COST_NM        " ).append("\n"); 
		query.append("      ,COA_GET_COM_NM_FNC('COA_COST_SRC_CD', K.COA_COST_SRC_CD) COA_COST_SRC_CD_NM" ).append("\n"); 
		query.append("      ,K.LOCL_CURR_CD           " ).append("\n"); 
		query.append("      ,SUM(K.STND_COST_USD_AMT) COST           " ).append("\n"); 
		query.append("      ,DECODE(MAX(M.DG), 'Y', 'DG ', '') || DECODE(MAX(M.BB), 'Y', 'BB ', '') || DECODE(MAX(M.AK), 'Y', 'AK ', '') || DECODE(MAX(M.RF), 'Y', 'RF', '') SPCL" ).append("\n"); 
		query.append("      ,DECODE(GROUPING(K.COA_COST_SRC_CD), 1, 1, 2) LVL           " ).append("\n"); 
		query.append("      ,'AVERAGE' COST_ASS_BSE_CD              " ).append("\n"); 
		query.append("      ,DECODE(@[f_cost_loc_grp_cd], 'L','LCC', 'C','LOC', 'S','SCC', 'E','ECC', 'R','RCC', 'NOD') LOC_TYPE  	--20160303.ADD" ).append("\n"); 
		query.append("      ,DECODE(GROUPING(K.COA_COST_SRC_CD), 1,  COA_GET_COM_NM_FNC('STND_COST_CD', M.STND_COST_CD), COA_GET_COM_NM_FNC('COA_COST_SRC_CD', K.COA_COST_SRC_CD)) COST_NM" ).append("\n"); 
		query.append("  FROM (SELECT DISTINCT B.STND_COST_CD           " ).append("\n"); 
		query.append("               ,B.COA_COST_SRC_CD           " ).append("\n"); 
		query.append("               ,B.SPCL_CGO_DG_FLG DG           " ).append("\n"); 
		query.append("               ,B.SPCL_CGO_BB_FLG BB           " ).append("\n"); 
		query.append("               ,B.SPCL_CGO_AWK_FLG AK           " ).append("\n"); 
		query.append("               ,B.SPCL_CGO_RF_FLG RF           " ).append("\n"); 
		query.append("           FROM COA_COST_SRC_ACCT B, COA_STND_ACCT C           " ).append("\n"); 
		query.append("          WHERE 1 = 1 " ).append("\n"); 
		query.append("            AND B.COST_SRC_SYS_CD = 'TES'           " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("            #if (${f_spcl_cgo_dg_flg} == '') " ).append("\n"); 
		query.append("            AND B.SPCL_CGO_DG_FLG <> 'Y'" ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("            #if (${f_spcl_cgo_bb_flg} == '') " ).append("\n"); 
		query.append("            AND B.SPCL_CGO_BB_FLG <> 'Y'" ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("            #if (${f_spcl_cgo_awk_flg} == '') " ).append("\n"); 
		query.append("            AND B.SPCL_CGO_AWK_FLG <> 'Y'" ).append("\n"); 
		query.append("           #end " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("            #if (${f_spcl_cgo_rf_flg} == '') " ).append("\n"); 
		query.append("            AND B.SPCL_CGO_RF_FLG <> 'Y'" ).append("\n"); 
		query.append("           #end           " ).append("\n"); 
		query.append("            AND B.STND_COST_CD = C.STND_COST_CD           " ).append("\n"); 
		query.append("        GROUP BY B.STND_COST_CD           " ).append("\n"); 
		query.append("                 ,B.COA_COST_SRC_CD           " ).append("\n"); 
		query.append("                 ,B.SPCL_CGO_DG_FLG           " ).append("\n"); 
		query.append("                 ,B.SPCL_CGO_BB_FLG           " ).append("\n"); 
		query.append("                 ,B.SPCL_CGO_AWK_FLG           " ).append("\n"); 
		query.append("                 ,B.SPCL_CGO_RF_FLG" ).append("\n"); 
		query.append("         ) M           " ).append("\n"); 
		query.append("        ,(SELECT   D.COA_COST_SRC_CD           " ).append("\n"); 
		query.append("                  ,D.LOCL_CURR_CD           " ).append("\n"); 
		query.append("                  ,SUM(D.STND_COST_USD_AMT) STND_COST_USD_AMT           " ).append("\n"); 
		query.append("            FROM COA_NOD_AVG_STND_COST D           " ).append("\n"); 
		query.append("           WHERE 1 = 1      " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("             AND D.NOD_CD IN (" ).append("\n"); 
		query.append("            	   NVL(COA_LOC_FNC(@[nod_cd], DECODE(@[f_cost_loc_grp_cd], 'L','LCC', 'C','LOC', 'S','SCC','E','ECC', 'R','RCC', 'NOD')), @[nod_cd])	--20160303.ADD" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("             #if (${f_cost_yrmon} != '') " ).append("\n"); 
		query.append("             AND D.COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if (${f_full_mty_cd} != '') " ).append("\n"); 
		query.append("             AND D.FULL_MTY_CD = @[f_full_mty_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("             #if (${f_cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("             AND D.CNTR_TPSZ_CD = COA_UT_TPSZ_FNC((SELECT COST_UT_AMT_CD FROM COA_COST_SRC_ACCT WHERE COA_COST_SRC_CD = D.COA_COST_SRC_CD), REPLACE(@[f_cntr_tpsz_cd], 'RD', 'R'))" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("             AND D.COST_LOC_GRP_CD = @[f_cost_loc_grp_cd]" ).append("\n"); 
		query.append("        GROUP BY COA_COST_SRC_CD, LOCL_CURR_CD) K           " ).append("\n"); 
		query.append("  WHERE M.COA_COST_SRC_CD = K.COA_COST_SRC_CD           " ).append("\n"); 
		query.append("GROUP BY M.STND_COST_CD, CUBE(K.COA_COST_SRC_CD), K.LOCL_CURR_CD" ).append("\n"); 

	}
}