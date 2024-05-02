/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : WeeklyCMDBDAOCoaEMUCreditListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.22
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2014.09.22 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOCoaEMUCreditListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EMU CREDIT Container Type 별, Credit Ratio/Credit Amount, OP/DEL 별로 검색 조회
	  * </pre>
	  */
	public WeeklyCMDBDAOCoaEMUCreditListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOCoaEMUCreditListVORSQL").append("\n"); 
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
		query.append("#if (${f_selclass} == 'RTO' ) " ).append("\n"); 
		query.append("-- DEL CREDIT RATIO" ).append("\n"); 
		query.append(" SELECT A.COST_YRMON" ).append("\n"); 
		query.append("      , C.CONTI_NM" ).append("\n"); 
		query.append("      , C.CNT_NM" ).append("\n"); 
		query.append("      , A.ECC_CD" ).append("\n"); 
		query.append("      , C.RCC_CD" ).append("\n"); 
		query.append("      , C.LCC_CD" ).append("\n"); 
		query.append("      , @[f_sts_cd] RULE_CD" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D2', A.EQ_REPO_CR_RTO * 100)) TPSZ_D2_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D3', A.EQ_REPO_CR_RTO * 100)) TPSZ_D3_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D4', A.EQ_REPO_CR_RTO * 100)) TPSZ_D4_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D5', A.EQ_REPO_CR_RTO * 100)) TPSZ_D5_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D7', A.EQ_REPO_CR_RTO * 100)) TPSZ_D7_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'R2', A.EQ_REPO_CR_RTO * 100)) TPSZ_R2_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'R5', A.EQ_REPO_CR_RTO * 100)) TPSZ_R5_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'R9', A.EQ_REPO_CR_RTO * 100)) TPSZ_R9_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'F2', A.EQ_REPO_CR_RTO * 100)) TPSZ_F2_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'F4', A.EQ_REPO_CR_RTO * 100)) TPSZ_F4_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'F5', A.EQ_REPO_CR_RTO * 100)) TPSZ_F5_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'O2', A.EQ_REPO_CR_RTO * 100)) TPSZ_O2_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'O4', A.EQ_REPO_CR_RTO * 100)) TPSZ_O4_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'O5', A.EQ_REPO_CR_RTO * 100)) TPSZ_O5_RTO" ).append("\n"); 
		query.append("   FROM COA_CNTR_REPO_SHTG_INFO A" ).append("\n"); 
		query.append("      , COA_CNTR_REPO_ROUT_ECC B" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("         SELECT B.ECC_CD" ).append("\n"); 
		query.append("              , B.RCC_CD" ).append("\n"); 
		query.append("              , B.LCC_CD" ).append("\n"); 
		query.append("              , C.CNT_CD" ).append("\n"); 
		query.append("              , C.CNT_NM" ).append("\n"); 
		query.append("              , D.CONTI_CD" ).append("\n"); 
		query.append("              , D.CONTI_NM" ).append("\n"); 
		query.append("           FROM MDM_LOCATION A" ).append("\n"); 
		query.append("              , MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("              , MDM_COUNTRY C" ).append("\n"); 
		query.append("              , MDM_CONTINENT D" ).append("\n"); 
		query.append("          WHERE A.SCC_CD   = B.SCC_CD" ).append("\n"); 
		query.append("            AND A.CNT_CD   = C.CNT_CD" ).append("\n"); 
		query.append("            AND A.CONTI_CD = D.CONTI_CD" ).append("\n"); 
		query.append("            AND B.ECC_CD LIKE C.CNT_CD || '%'" ).append("\n"); 
		query.append("            AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append("            AND A.DELT_FLG ='N'" ).append("\n"); 
		query.append("        ) C" ).append("\n"); 
		query.append("  WHERE A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("    AND A.ECC_CD     = B.ECC_CD" ).append("\n"); 
		query.append("    AND A.ECC_CD     = C.ECC_CD" ).append("\n"); 
		query.append("    AND A.CNTR_TPSZ_CD LIKE B.CNTR_TPSZ_CD||'%'" ).append("\n"); 
		query.append("    AND A.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("    AND A.CNTR_ORG_DEST_CD = DECODE(@[f_sts_cd],'DEL', 'D','O')  -- OP/DEL -> RATIO 일때는 DEL 동일" ).append("\n"); 
		query.append("    AND B.DEL_REPO_FLG     = DECODE(@[f_sts_cd],'DEL', 'Y','N')  -- OP/DEL -> RATIO 일때는 DEL 동일" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	AND A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("  		 #foreach($key IN ${list_cntr_tpsz_cd})" ).append("\n"); 
		query.append("  		  	#if($velocityCount < $list_cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("  				'$key', " ).append("\n"); 
		query.append("  			#else " ).append("\n"); 
		query.append("  				'$key' " ).append("\n"); 
		query.append("  			#end " ).append("\n"); 
		query.append("  		#end " ).append("\n"); 
		query.append("  		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_group} == 'ECC') " ).append("\n"); 
		query.append("    AND A.ECC_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'CONTI') " ).append("\n"); 
		query.append("    AND C.CONTI_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'CNT') " ).append("\n"); 
		query.append("    AND C.CNT_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'RCC') " ).append("\n"); 
		query.append("    AND C.RCC_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'LCC') " ).append("\n"); 
		query.append("    AND C.LCC_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND A.COST_YRMON = REPLACE(@[f_cost_yrmon],'-','')   -- MONTH" ).append("\n"); 
		query.append("    AND A.EQ_REPO_CR_RTO > 0" ).append("\n"); 
		query.append("  GROUP BY A.COST_YRMON" ).append("\n"); 
		query.append("      , C.CONTI_NM" ).append("\n"); 
		query.append("      , C.CNT_NM" ).append("\n"); 
		query.append("      , A.ECC_CD" ).append("\n"); 
		query.append("      , C.RCC_CD" ).append("\n"); 
		query.append("      , C.LCC_CD" ).append("\n"); 
		query.append("  ORDER BY C.CONTI_NM" ).append("\n"); 
		query.append("      , C.RCC_CD" ).append("\n"); 
		query.append("      , C.CNT_NM" ).append("\n"); 
		query.append("      , C.LCC_CD" ).append("\n"); 
		query.append("      , A.ECC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${f_sts_cd} == 'DEL' && ${f_selclass} == 'AMT' ) " ).append("\n"); 
		query.append(" -- POD CREDIT AMOUNT : DRY" ).append("\n"); 
		query.append(" SELECT A.COST_YRMON" ).append("\n"); 
		query.append("      , C.CONTI_NM" ).append("\n"); 
		query.append("      , C.CNT_NM" ).append("\n"); 
		query.append("      , A.ECC_CD" ).append("\n"); 
		query.append("      , C.RCC_CD" ).append("\n"); 
		query.append("      , C.LCC_CD" ).append("\n"); 
		query.append("      , @[f_sts_cd] RULE_CD" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D2', NVL(A.SIM_STVG_UC_AMT, 0))) TPSZ_D2_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D4', NVL(A.SIM_STVG_UC_AMT, 0))) TPSZ_D4_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D5', NVL(A.SIM_STVG_UC_AMT, 0))) TPSZ_D5_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D7', NVL(A.SIM_STVG_UC_AMT, 0))) TPSZ_D7_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'R2', NVL(A.SIM_STVG_UC_AMT, 0))) TPSZ_R2_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'R5', NVL(A.SIM_STVG_UC_AMT, 0))) TPSZ_R5_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'R9', NVL(A.SIM_STVG_UC_AMT, 0))) TPSZ_R9_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'F2', NVL(A.SIM_STVG_UC_AMT, 0))) TPSZ_F2_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'F4', NVL(A.SIM_STVG_UC_AMT, 0))) TPSZ_F4_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'F5', NVL(A.SIM_STVG_UC_AMT, 0))) TPSZ_F5_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'O2', NVL(A.SIM_STVG_UC_AMT, 0))) TPSZ_O2_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'O4', NVL(A.SIM_STVG_UC_AMT, 0))) TPSZ_O4_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'O5', NVL(A.SIM_STVG_UC_AMT, 0))) TPSZ_O5_AMT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("   FROM COA_MTY_ECC_UT_COST A" ).append("\n"); 
		query.append("      , COA_CNTR_REPO_ROUT_ECC B" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("         SELECT B.ECC_CD" ).append("\n"); 
		query.append("              , B.RCC_CD" ).append("\n"); 
		query.append("              , B.LCC_CD" ).append("\n"); 
		query.append("              , C.CNT_CD" ).append("\n"); 
		query.append("              , C.CNT_NM" ).append("\n"); 
		query.append("              , D.CONTI_CD" ).append("\n"); 
		query.append("              , D.CONTI_NM" ).append("\n"); 
		query.append("           FROM MDM_LOCATION A" ).append("\n"); 
		query.append("              , MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("              , MDM_COUNTRY C" ).append("\n"); 
		query.append("              , MDM_CONTINENT D" ).append("\n"); 
		query.append("          WHERE A.SCC_CD   = B.SCC_CD" ).append("\n"); 
		query.append("            AND A.CNT_CD   = C.CNT_CD" ).append("\n"); 
		query.append("            AND A.CONTI_CD = D.CONTI_CD" ).append("\n"); 
		query.append("            AND B.ECC_CD LIKE C.CNT_CD || '%'" ).append("\n"); 
		query.append("            AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append("            AND A.DELT_FLG ='N'" ).append("\n"); 
		query.append("        ) C" ).append("\n"); 
		query.append("  WHERE A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("    AND A.ECC_CD     = B.ECC_CD" ).append("\n"); 
		query.append("    AND A.CNTR_TPSZ_CD LIKE B.CNTR_TPSZ_CD || '%'" ).append("\n"); 
		query.append("    AND A.ECC_CD           = C.ECC_CD" ).append("\n"); 
		query.append("    AND A.COST_YRMON       = REPLACE(@[f_cost_yrmon],'-','')" ).append("\n"); 
		query.append("    AND A.CNTR_ORG_DEST_CD = 'D'" ).append("\n"); 
		query.append("    AND A.COST_LOC_GRP_CD  = 'E'" ).append("\n"); 
		query.append("    AND B.DEL_REPO_FLG     = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_group} == 'ECC') " ).append("\n"); 
		query.append("    AND A.ECC_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'CONTI') " ).append("\n"); 
		query.append("    AND C.CONTI_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'CNT') " ).append("\n"); 
		query.append("    AND C.CNT_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'RCC') " ).append("\n"); 
		query.append("    AND C.RCC_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'LCC') " ).append("\n"); 
		query.append("    AND C.LCC_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	AND A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("  		 #foreach($key IN ${list_cntr_tpsz_cd})" ).append("\n"); 
		query.append("  		  	#if($velocityCount < $list_cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("  				'$key', " ).append("\n"); 
		query.append("  			#else " ).append("\n"); 
		query.append("  				'$key' " ).append("\n"); 
		query.append("  			#end " ).append("\n"); 
		query.append("  		#end " ).append("\n"); 
		query.append("  		)" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("    AND NVL(A.SIM_STVG_UC_AMT, 0) > 0" ).append("\n"); 
		query.append("GROUP BY A.COST_YRMON" ).append("\n"); 
		query.append("      , C.CONTI_NM" ).append("\n"); 
		query.append("      , C.CNT_NM" ).append("\n"); 
		query.append("      , A.ECC_CD" ).append("\n"); 
		query.append("      , C.RCC_CD" ).append("\n"); 
		query.append("      , C.LCC_CD" ).append("\n"); 
		query.append("ORDER BY C.CONTI_NM" ).append("\n"); 
		query.append("      , C.RCC_CD" ).append("\n"); 
		query.append("      , C.CNT_NM" ).append("\n"); 
		query.append("      , C.LCC_CD" ).append("\n"); 
		query.append("      , A.ECC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${f_sts_cd} == 'OP' && ${f_selclass} == 'AMT' ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" -- OP CREDIT AMOUNT" ).append("\n"); 
		query.append(" SELECT A.COST_YRMON" ).append("\n"); 
		query.append("      , C.CONTI_NM" ).append("\n"); 
		query.append("      , C.CNT_NM" ).append("\n"); 
		query.append("      , A.ECC_CD" ).append("\n"); 
		query.append("      , C.RCC_CD" ).append("\n"); 
		query.append("      , C.LCC_CD" ).append("\n"); 
		query.append("      , @[f_sts_cd] RULE_CD" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D2', NVL(A.SIM_STVG_UC_AMT, 0) + NVL(A.SIM_TRSP_UC_AMT, 0))) TPSZ_D2_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D4', NVL(A.SIM_STVG_UC_AMT, 0) + NVL(A.SIM_TRSP_UC_AMT, 0))) TPSZ_D4_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D5', NVL(A.SIM_STVG_UC_AMT, 0) + NVL(A.SIM_TRSP_UC_AMT, 0))) TPSZ_D5_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D7', NVL(A.SIM_STVG_UC_AMT, 0) + NVL(A.SIM_TRSP_UC_AMT, 0))) TPSZ_D7_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'R2', NVL(A.SIM_STVG_UC_AMT, 0) + NVL(A.SIM_TRSP_UC_AMT, 0))) TPSZ_R2_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'R5', NVL(A.SIM_STVG_UC_AMT, 0) + NVL(A.SIM_TRSP_UC_AMT, 0))) TPSZ_R5_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'R9', NVL(A.SIM_STVG_UC_AMT, 0) + NVL(A.SIM_TRSP_UC_AMT, 0))) TPSZ_R9_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'F2', NVL(A.SIM_STVG_UC_AMT, 0) + NVL(A.SIM_TRSP_UC_AMT, 0))) TPSZ_F2_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'F4', NVL(A.SIM_STVG_UC_AMT, 0) + NVL(A.SIM_TRSP_UC_AMT, 0))) TPSZ_F4_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'F5', NVL(A.SIM_STVG_UC_AMT, 0) + NVL(A.SIM_TRSP_UC_AMT, 0))) TPSZ_F5_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'O2', NVL(A.SIM_STVG_UC_AMT, 0) + NVL(A.SIM_TRSP_UC_AMT, 0))) TPSZ_O2_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'O4', NVL(A.SIM_STVG_UC_AMT, 0) + NVL(A.SIM_TRSP_UC_AMT, 0))) TPSZ_O4_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'O5', NVL(A.SIM_STVG_UC_AMT, 0) + NVL(A.SIM_TRSP_UC_AMT, 0))) TPSZ_O5_AMT" ).append("\n"); 
		query.append("   FROM COA_MTY_ECC_UT_COST A" ).append("\n"); 
		query.append("      , COA_CNTR_REPO_ROUT_ECC B" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("         SELECT B.ECC_CD" ).append("\n"); 
		query.append("              , B.RCC_CD" ).append("\n"); 
		query.append("              , B.LCC_CD" ).append("\n"); 
		query.append("              , C.CNT_CD" ).append("\n"); 
		query.append("              , C.CNT_NM" ).append("\n"); 
		query.append("              , D.CONTI_CD" ).append("\n"); 
		query.append("              , D.CONTI_NM" ).append("\n"); 
		query.append("           FROM MDM_LOCATION A" ).append("\n"); 
		query.append("              , MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("              , MDM_COUNTRY C" ).append("\n"); 
		query.append("              , MDM_CONTINENT D" ).append("\n"); 
		query.append("          WHERE A.SCC_CD   = B.SCC_CD" ).append("\n"); 
		query.append("            AND A.CNT_CD   = C.CNT_CD" ).append("\n"); 
		query.append("            AND A.CONTI_CD = D.CONTI_CD" ).append("\n"); 
		query.append("            AND B.ECC_CD LIKE C.CNT_CD || '%'" ).append("\n"); 
		query.append("            AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append("            AND A.DELT_FLG ='N'" ).append("\n"); 
		query.append("        ) C" ).append("\n"); 
		query.append("  WHERE A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("    AND A.ECC_CD     = B.ECC_CD" ).append("\n"); 
		query.append("    AND A.CNTR_TPSZ_CD LIKE B.CNTR_TPSZ_CD || '%'" ).append("\n"); 
		query.append("    AND A.ECC_CD           = C.ECC_CD" ).append("\n"); 
		query.append("    AND A.COST_YRMON       = REPLACE(@[f_cost_yrmon],'-','')" ).append("\n"); 
		query.append("    AND A.CNTR_ORG_DEST_CD = 'O'" ).append("\n"); 
		query.append("    AND A.COST_LOC_GRP_CD  = 'E'" ).append("\n"); 
		query.append("    AND B.POR_REPO_FLG     = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_group} == 'ECC') " ).append("\n"); 
		query.append("    AND A.ECC_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'CONTI') " ).append("\n"); 
		query.append("    AND C.CONTI_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'CNT') " ).append("\n"); 
		query.append("    AND C.CNT_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'RCC') " ).append("\n"); 
		query.append("    AND C.RCC_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'LCC') " ).append("\n"); 
		query.append("    AND C.LCC_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	AND A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("  		 #foreach($key IN ${list_cntr_tpsz_cd})" ).append("\n"); 
		query.append("  		  	#if($velocityCount < $list_cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("  				'$key', " ).append("\n"); 
		query.append("  			#else " ).append("\n"); 
		query.append("  				'$key' " ).append("\n"); 
		query.append("  			#end " ).append("\n"); 
		query.append("  		#end " ).append("\n"); 
		query.append("  		)" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("    AND NVL(A.SIM_STVG_UC_AMT, 0) + NVL(A.SIM_TRSP_UC_AMT, 0) > 0" ).append("\n"); 
		query.append("GROUP BY A.COST_YRMON" ).append("\n"); 
		query.append("      , C.CONTI_NM" ).append("\n"); 
		query.append("      , C.CNT_NM" ).append("\n"); 
		query.append("      , A.ECC_CD" ).append("\n"); 
		query.append("      , C.RCC_CD" ).append("\n"); 
		query.append("      , C.LCC_CD" ).append("\n"); 
		query.append("ORDER BY C.CONTI_NM" ).append("\n"); 
		query.append("      , C.RCC_CD" ).append("\n"); 
		query.append("      , C.CNT_NM" ).append("\n"); 
		query.append("      , C.LCC_CD" ).append("\n"); 
		query.append("      , A.ECC_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${f_sts_cd} == 'DEL' && ${f_selclass} == 'TOT' ) " ).append("\n"); 
		query.append("-- CREDIT RATIO & AMOUNT" ).append("\n"); 
		query.append(" SELECT A.COST_YRMON" ).append("\n"); 
		query.append("      , C.CONTI_NM" ).append("\n"); 
		query.append("      , C.CNT_NM" ).append("\n"); 
		query.append("      , A.ECC_CD" ).append("\n"); 
		query.append("      , C.RCC_CD" ).append("\n"); 
		query.append("      , C.LCC_CD" ).append("\n"); 
		query.append("      , @[f_sts_cd] RULE_CD" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D2', A.EQ_REPO_CR_RTO * 100)) TPSZ_D2_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D3', A.EQ_REPO_CR_RTO * 100)) TPSZ_D3_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D4', A.EQ_REPO_CR_RTO * 100)) TPSZ_D4_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D5', A.EQ_REPO_CR_RTO * 100)) TPSZ_D5_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D7', A.EQ_REPO_CR_RTO * 100)) TPSZ_D7_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'R2', A.EQ_REPO_CR_RTO * 100)) TPSZ_R2_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'R5', A.EQ_REPO_CR_RTO * 100)) TPSZ_R5_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'R9', A.EQ_REPO_CR_RTO * 100)) TPSZ_R9_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'F2', A.EQ_REPO_CR_RTO * 100)) TPSZ_F2_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'F4', A.EQ_REPO_CR_RTO * 100)) TPSZ_F4_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'F5', A.EQ_REPO_CR_RTO * 100)) TPSZ_F5_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'O2', A.EQ_REPO_CR_RTO * 100)) TPSZ_O2_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'O4', A.EQ_REPO_CR_RTO * 100)) TPSZ_O4_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'O5', A.EQ_REPO_CR_RTO * 100)) TPSZ_O5_RTO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'D2', NVL(U.SIM_STVG_UC_AMT, 0))) TPSZ_D2_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'D4', NVL(U.SIM_STVG_UC_AMT, 0))) TPSZ_D4_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'D5', NVL(U.SIM_STVG_UC_AMT, 0))) TPSZ_D5_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'D7', NVL(U.SIM_STVG_UC_AMT, 0))) TPSZ_D7_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'R2', NVL(U.SIM_STVG_UC_AMT, 0))) TPSZ_R2_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'R5', NVL(U.SIM_STVG_UC_AMT, 0))) TPSZ_R5_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'R9', NVL(U.SIM_STVG_UC_AMT, 0))) TPSZ_R9_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'F2', NVL(U.SIM_STVG_UC_AMT, 0))) TPSZ_F2_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'F4', NVL(U.SIM_STVG_UC_AMT, 0))) TPSZ_F4_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'F5', NVL(U.SIM_STVG_UC_AMT, 0))) TPSZ_F5_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'O2', NVL(U.SIM_STVG_UC_AMT, 0))) TPSZ_O2_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'O4', NVL(U.SIM_STVG_UC_AMT, 0))) TPSZ_O4_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'O5', NVL(U.SIM_STVG_UC_AMT, 0))) TPSZ_O5_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   FROM COA_CNTR_REPO_SHTG_INFO A" ).append("\n"); 
		query.append("      , COA_CNTR_REPO_ROUT_ECC B" ).append("\n"); 
		query.append("      , COA_MTY_ECC_UT_COST U" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("         SELECT B.ECC_CD" ).append("\n"); 
		query.append("              , B.RCC_CD" ).append("\n"); 
		query.append("              , B.LCC_CD" ).append("\n"); 
		query.append("              , C.CNT_CD" ).append("\n"); 
		query.append("              , C.CNT_NM" ).append("\n"); 
		query.append("              , D.CONTI_CD" ).append("\n"); 
		query.append("              , D.CONTI_NM" ).append("\n"); 
		query.append("           FROM MDM_LOCATION A" ).append("\n"); 
		query.append("              , MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("              , MDM_COUNTRY C" ).append("\n"); 
		query.append("              , MDM_CONTINENT D" ).append("\n"); 
		query.append("          WHERE A.SCC_CD   = B.SCC_CD" ).append("\n"); 
		query.append("            AND A.CNT_CD   = C.CNT_CD" ).append("\n"); 
		query.append("            AND A.CONTI_CD = D.CONTI_CD" ).append("\n"); 
		query.append("            AND B.ECC_CD LIKE C.CNT_CD || '%'" ).append("\n"); 
		query.append("            AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append("            AND A.DELT_FLG ='N'" ).append("\n"); 
		query.append("        ) C" ).append("\n"); 
		query.append("  WHERE A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("    AND A.ECC_CD     = B.ECC_CD" ).append("\n"); 
		query.append("    AND A.ECC_CD     = C.ECC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND A.COST_YRMON = U.COST_YRMON" ).append("\n"); 
		query.append("    AND A.ECC_CD     = U.ECC_CD" ).append("\n"); 
		query.append("    AND A.CNTR_TPSZ_CD     = U.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    AND A.CNTR_ORG_DEST_CD = U.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("    AND U.COST_LOC_GRP_CD  = 'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND A.CNTR_TPSZ_CD LIKE B.CNTR_TPSZ_CD||'%'" ).append("\n"); 
		query.append("    AND A.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("    AND A.CNTR_ORG_DEST_CD = DECODE(@[f_sts_cd],'DEL', 'D','O')  -- OP/DEL -> RATIO 일때는 DEL 동일" ).append("\n"); 
		query.append("    AND B.DEL_REPO_FLG     = DECODE(@[f_sts_cd],'DEL', 'Y','N')  -- OP/DEL -> RATIO 일때는 DEL 동일" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	AND A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("  		 #foreach($key IN ${list_cntr_tpsz_cd})" ).append("\n"); 
		query.append("  		  	#if($velocityCount < $list_cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("  				'$key', " ).append("\n"); 
		query.append("  			#else " ).append("\n"); 
		query.append("  				'$key' " ).append("\n"); 
		query.append("  			#end " ).append("\n"); 
		query.append("  		#end " ).append("\n"); 
		query.append("  		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_group} == 'ECC') " ).append("\n"); 
		query.append("    AND A.ECC_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'CONTI') " ).append("\n"); 
		query.append("    AND C.CONTI_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'CNT') " ).append("\n"); 
		query.append("    AND C.CNT_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'RCC') " ).append("\n"); 
		query.append("    AND C.RCC_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'LCC') " ).append("\n"); 
		query.append("    AND C.LCC_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND A.COST_YRMON = REPLACE(@[f_cost_yrmon],'-','')   -- MONTH" ).append("\n"); 
		query.append("    AND A.EQ_REPO_CR_RTO > 0" ).append("\n"); 
		query.append("    AND NVL(U.SIM_STVG_UC_AMT, 0) + NVL(U.SIM_TRSP_UC_AMT, 0) > 0" ).append("\n"); 
		query.append("  GROUP BY A.COST_YRMON" ).append("\n"); 
		query.append("      , C.CONTI_NM" ).append("\n"); 
		query.append("      , C.CNT_NM" ).append("\n"); 
		query.append("      , A.ECC_CD" ).append("\n"); 
		query.append("      , C.RCC_CD" ).append("\n"); 
		query.append("      , C.LCC_CD" ).append("\n"); 
		query.append("  ORDER BY C.CONTI_NM" ).append("\n"); 
		query.append("      , C.RCC_CD" ).append("\n"); 
		query.append("      , C.CNT_NM" ).append("\n"); 
		query.append("      , C.LCC_CD" ).append("\n"); 
		query.append("      , A.ECC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${f_sts_cd} == 'OP' && ${f_selclass} == 'TOT' ) " ).append("\n"); 
		query.append("-- CREDIT RATIO & AMOUNT" ).append("\n"); 
		query.append(" SELECT A.COST_YRMON" ).append("\n"); 
		query.append("      , C.CONTI_NM" ).append("\n"); 
		query.append("      , C.CNT_NM" ).append("\n"); 
		query.append("      , A.ECC_CD" ).append("\n"); 
		query.append("      , C.RCC_CD" ).append("\n"); 
		query.append("      , C.LCC_CD" ).append("\n"); 
		query.append("      , @[f_sts_cd] RULE_CD" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D2', A.EQ_REPO_CR_RTO * 100)) TPSZ_D2_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D3', A.EQ_REPO_CR_RTO * 100)) TPSZ_D3_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D4', A.EQ_REPO_CR_RTO * 100)) TPSZ_D4_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D5', A.EQ_REPO_CR_RTO * 100)) TPSZ_D5_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'D7', A.EQ_REPO_CR_RTO * 100)) TPSZ_D7_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'R2', A.EQ_REPO_CR_RTO * 100)) TPSZ_R2_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'R5', A.EQ_REPO_CR_RTO * 100)) TPSZ_R5_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'R9', A.EQ_REPO_CR_RTO * 100)) TPSZ_R9_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'F2', A.EQ_REPO_CR_RTO * 100)) TPSZ_F2_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'F4', A.EQ_REPO_CR_RTO * 100)) TPSZ_F4_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'F5', A.EQ_REPO_CR_RTO * 100)) TPSZ_F5_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'O2', A.EQ_REPO_CR_RTO * 100)) TPSZ_O2_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'O4', A.EQ_REPO_CR_RTO * 100)) TPSZ_O4_RTO" ).append("\n"); 
		query.append("      , MAX(DECODE(A.CNTR_TPSZ_CD, 'O5', A.EQ_REPO_CR_RTO * 100)) TPSZ_O5_RTO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'D2', NVL(U.SIM_STVG_UC_AMT, 0) + NVL(U.SIM_TRSP_UC_AMT, 0))) TPSZ_D2_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'D4', NVL(U.SIM_STVG_UC_AMT, 0) + NVL(U.SIM_TRSP_UC_AMT, 0))) TPSZ_D4_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'D5', NVL(U.SIM_STVG_UC_AMT, 0) + NVL(U.SIM_TRSP_UC_AMT, 0))) TPSZ_D5_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'D7', NVL(U.SIM_STVG_UC_AMT, 0) + NVL(U.SIM_TRSP_UC_AMT, 0))) TPSZ_D7_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'R2', NVL(U.SIM_STVG_UC_AMT, 0) + NVL(U.SIM_TRSP_UC_AMT, 0))) TPSZ_R2_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'R5', NVL(U.SIM_STVG_UC_AMT, 0) + NVL(U.SIM_TRSP_UC_AMT, 0))) TPSZ_R5_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'R9', NVL(U.SIM_STVG_UC_AMT, 0) + NVL(U.SIM_TRSP_UC_AMT, 0))) TPSZ_R9_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'F2', NVL(U.SIM_STVG_UC_AMT, 0) + NVL(U.SIM_TRSP_UC_AMT, 0))) TPSZ_F2_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'F4', NVL(U.SIM_STVG_UC_AMT, 0) + NVL(U.SIM_TRSP_UC_AMT, 0))) TPSZ_F4_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'F5', NVL(U.SIM_STVG_UC_AMT, 0) + NVL(U.SIM_TRSP_UC_AMT, 0))) TPSZ_F5_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'O2', NVL(U.SIM_STVG_UC_AMT, 0) + NVL(U.SIM_TRSP_UC_AMT, 0))) TPSZ_O2_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'O4', NVL(U.SIM_STVG_UC_AMT, 0) + NVL(U.SIM_TRSP_UC_AMT, 0))) TPSZ_O4_AMT" ).append("\n"); 
		query.append("      , MAX(DECODE(U.CNTR_TPSZ_CD, 'O5', NVL(U.SIM_STVG_UC_AMT, 0) + NVL(U.SIM_TRSP_UC_AMT, 0))) TPSZ_O5_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   FROM COA_CNTR_REPO_SHTG_INFO A" ).append("\n"); 
		query.append("      , COA_CNTR_REPO_ROUT_ECC B" ).append("\n"); 
		query.append("      , COA_MTY_ECC_UT_COST U" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("         SELECT B.ECC_CD" ).append("\n"); 
		query.append("              , B.RCC_CD" ).append("\n"); 
		query.append("              , B.LCC_CD" ).append("\n"); 
		query.append("              , C.CNT_CD" ).append("\n"); 
		query.append("              , C.CNT_NM" ).append("\n"); 
		query.append("              , D.CONTI_CD" ).append("\n"); 
		query.append("              , D.CONTI_NM" ).append("\n"); 
		query.append("           FROM MDM_LOCATION A" ).append("\n"); 
		query.append("              , MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("              , MDM_COUNTRY C" ).append("\n"); 
		query.append("              , MDM_CONTINENT D" ).append("\n"); 
		query.append("          WHERE A.SCC_CD   = B.SCC_CD" ).append("\n"); 
		query.append("            AND A.CNT_CD   = C.CNT_CD" ).append("\n"); 
		query.append("            AND A.CONTI_CD = D.CONTI_CD" ).append("\n"); 
		query.append("            AND B.ECC_CD LIKE C.CNT_CD || '%'" ).append("\n"); 
		query.append("            AND B.DELT_FLG ='N'" ).append("\n"); 
		query.append("            AND A.DELT_FLG ='N'" ).append("\n"); 
		query.append("        ) C" ).append("\n"); 
		query.append("  WHERE A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("    AND A.ECC_CD     = B.ECC_CD" ).append("\n"); 
		query.append("    AND A.ECC_CD     = C.ECC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND A.COST_YRMON = U.COST_YRMON" ).append("\n"); 
		query.append("    AND A.ECC_CD     = U.ECC_CD" ).append("\n"); 
		query.append("    AND A.CNTR_TPSZ_CD     = U.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    AND A.CNTR_ORG_DEST_CD = U.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("    AND U.COST_LOC_GRP_CD  = 'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND A.CNTR_TPSZ_CD LIKE B.CNTR_TPSZ_CD||'%'" ).append("\n"); 
		query.append("    AND A.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("    AND A.CNTR_ORG_DEST_CD = DECODE(@[f_sts_cd],'DEL', 'D','O')  -- OP/DEL -> RATIO 일때는 DEL 동일" ).append("\n"); 
		query.append("    AND B.DEL_REPO_FLG     = DECODE(@[f_sts_cd],'DEL', 'Y','N')  -- OP/DEL -> RATIO 일때는 DEL 동일" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	AND A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("  		 #foreach($key IN ${list_cntr_tpsz_cd})" ).append("\n"); 
		query.append("  		  	#if($velocityCount < $list_cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("  				'$key', " ).append("\n"); 
		query.append("  			#else " ).append("\n"); 
		query.append("  				'$key' " ).append("\n"); 
		query.append("  			#end " ).append("\n"); 
		query.append("  		#end " ).append("\n"); 
		query.append("  		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_group} == 'ECC') " ).append("\n"); 
		query.append("    AND A.ECC_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'CONTI') " ).append("\n"); 
		query.append("    AND C.CONTI_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'CNT') " ).append("\n"); 
		query.append("    AND C.CNT_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'RCC') " ).append("\n"); 
		query.append("    AND C.RCC_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#elseif (${f_group} == 'LCC') " ).append("\n"); 
		query.append("    AND C.LCC_CD LIKE @[f_loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND A.COST_YRMON = REPLACE(@[f_cost_yrmon],'-','')   -- MONTH" ).append("\n"); 
		query.append("    AND A.EQ_REPO_CR_RTO > 0" ).append("\n"); 
		query.append("    AND NVL(U.SIM_STVG_UC_AMT, 0) + NVL(U.SIM_TRSP_UC_AMT, 0) > 0" ).append("\n"); 
		query.append("  GROUP BY A.COST_YRMON" ).append("\n"); 
		query.append("      , C.CONTI_NM" ).append("\n"); 
		query.append("      , C.CNT_NM" ).append("\n"); 
		query.append("      , A.ECC_CD" ).append("\n"); 
		query.append("      , C.RCC_CD" ).append("\n"); 
		query.append("      , C.LCC_CD" ).append("\n"); 
		query.append("  ORDER BY C.CONTI_NM" ).append("\n"); 
		query.append("      , C.RCC_CD" ).append("\n"); 
		query.append("      , C.CNT_NM" ).append("\n"); 
		query.append("      , C.LCC_CD" ).append("\n"); 
		query.append("      , A.ECC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}