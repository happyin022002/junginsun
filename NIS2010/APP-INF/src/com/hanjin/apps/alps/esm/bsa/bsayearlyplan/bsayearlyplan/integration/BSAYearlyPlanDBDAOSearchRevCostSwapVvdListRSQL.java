/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BSAYearlyPlanDBDAOSearchRevCostSwapVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAYearlyPlanDBDAOSearchRevCostSwapVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public BSAYearlyPlanDBDAOSearchRevCostSwapVvdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtfmmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txttomonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtvslCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coblane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtyear",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txttoweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobdir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtskdVoyNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtdirCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtfmweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobtrade",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.integration").append("\n"); 
		query.append("FileName : BSAYearlyPlanDBDAOSearchRevCostSwapVvdListRSQL").append("\n"); 
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
		query.append("SELECT MIN(DECODE(D.CRR_CD, '', 'I', 'R')) FLAG," ).append("\n"); 
		query.append("#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("  SUBSTR(A.COST_YRMON, 0, 4) ||'-'|| A.COST_WK AS COST_YRWK," ).append("\n"); 
		query.append("#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  SUBSTR(A.SLS_YRMON, 0, 4) ||'-'|| A.COST_WK AS COST_YRWK," ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  C.TRD_CD," ).append("\n"); 
		query.append("  A.SUB_TRD_CD," ).append("\n"); 
		query.append("  A.SLAN_CD," ).append("\n"); 
		query.append("  C.RLANE_CD," ).append("\n"); 
		query.append("  DECODE(C.BSA_OP_CD, 'J', 'JO', 'SC') VSL_LANE_TP_CD," ).append("\n"); 
		query.append("  DECODE(C.BSA_OP_CD, 'J', '0', '1') TYPE_FLG," ).append("\n"); 
		query.append("  C.VSL_CD," ).append("\n"); 
		query.append("  C.SKD_VOY_NO," ).append("\n"); 
		query.append("  C.SKD_DIR_CD," ).append("\n"); 
		query.append("  C.VOP_CD," ).append("\n"); 
		query.append("  C.CRR_CD," ).append("\n"); 
		query.append("  DECODE(C.VOP_CD, 'SML', '0', '1') VOP_FLG," ).append("\n"); 
		query.append("  C.VSL_CAPA," ).append("\n"); 
		query.append("  C.VSL_CAPA," ).append("\n"); 
		query.append("  C.BSA_CAPA," ).append("\n"); 
		query.append("  C.FNL_HJS_BSA_CAPA," ).append("\n"); 
		query.append("  C.CO_BSA_CAPA," ).append("\n"); 
		query.append("  C.HJS_BSA_RTO*100 AS HJS_BSA_RTO," ).append("\n"); 
		query.append("  C.CHTR_BSA_RTO*100 AS CHTR_BSA_RTO," ).append("\n"); 
		query.append("  C.EXPN_BZC_CHTR_AMT," ).append("\n"); 
		query.append("  C.EXPN_SUB_CHTR_AMT," ).append("\n"); 
		query.append("  C.EXPN_CRS_CHTR_AMT," ).append("\n"); 
		query.append("  C.EXPN_BZC_CHTR_AMT+C.EXPN_SUB_CHTR_AMT+C.EXPN_CRS_CHTR_AMT AS EXPN_TOT," ).append("\n"); 
		query.append("  C.INCM_BZC_CHTR_AMT," ).append("\n"); 
		query.append("  C.INCM_SUB_CHTR_AMT," ).append("\n"); 
		query.append("  C.INCM_CRS_CHTR_AMT," ).append("\n"); 
		query.append("  C.INCM_BZC_CHTR_AMT+C.INCM_SUB_CHTR_AMT+C.INCM_CRS_CHTR_AMT INCM_TOT," ).append("\n"); 
		query.append("#foreach( ${keys} in ${keyList}) " ).append("\n"); 
		query.append("  NVL(SUM(DECODE(D.BSA_OP_JB_CD, SUBSTR('${keys}', 4, 6), DECODE(D.CRR_CD, SUBSTR('${keys}', 1, 3), D.CRR_PERF_AMT))), 0) ${keys}," ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  C.IOC_CD," ).append("\n"); 
		query.append("  C.BSA_OP_CD" ).append("\n"); 
		query.append("FROM MAS_MON_VVD_YRY_PLN A,  " ).append("\n"); 
		query.append("     MAS_LANE_RGST B,  " ).append("\n"); 
		query.append("     BSA_BUD_VVD_MST C,  " ).append("\n"); 
		query.append("     BSA_BUD_VVD_CRR_PERF D" ).append("\n"); 
		query.append("     --,MDM_VSL_CNTR F" ).append("\n"); 
		query.append("WHERE A.TRD_CD 		= C.TRD_CD" ).append("\n"); 
		query.append("  AND A.RLANE_CD 	= C.RLANE_CD" ).append("\n"); 
		query.append("  AND A.IOC_CD 		= C.IOC_CD" ).append("\n"); 
		query.append("  AND A.VSL_CD 		= C.VSL_CD" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO 	= C.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND A.DIR_CD 		= C.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND A.TRD_CD 		= B.TRD_CD" ).append("\n"); 
		query.append("  AND A.RLANE_CD 	= B.RLANE_CD" ).append("\n"); 
		query.append("  AND A.DIR_CD 		= B.DIR_CD" ).append("\n"); 
		query.append("  AND A.IOC_CD 		= B.IOC_CD" ).append("\n"); 
		query.append("  AND C.TRD_CD 		= D.TRD_CD(+)" ).append("\n"); 
		query.append("  AND C.RLANE_CD 	= D.RLANE_CD(+)" ).append("\n"); 
		query.append("  AND C.VSL_CD 		= D.VSL_CD(+)" ).append("\n"); 
		query.append("  AND C.SKD_VOY_NO 	= D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("  AND C.SKD_DIR_CD 	= D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("  --AND A.VSL_CD 		= F.VSL_CD(+)" ).append("\n"); 
		query.append("  AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("  AND D.CRR_CD(+) != 'SML'" ).append("\n"); 
		query.append("#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("  AND A.COST_YRMON BETWEEN @[txtyear]||@[txtfmmonth] AND @[txtyear]||@[txttomonth] " ).append("\n"); 
		query.append("#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  AND A.SLS_YRMON LIKE @[txtyear] || '%'" ).append("\n"); 
		query.append("  AND A.COST_WK BETWEEN @[txtfmweek] AND @[txttoweek] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cobtrade} != '')" ).append("\n"); 
		query.append("  AND C.TRD_CD = @[cobtrade] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${coblane} != '')" ).append("\n"); 
		query.append("  AND C.RLANE_CD = @[coblane] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cobdir} != '')" ).append("\n"); 
		query.append("  AND C.SKD_DIR_CD = @[cobdir] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cobioc} != '')" ).append("\n"); 
		query.append("  AND C.IOC_CD = @[cobioc] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${txtvslCd} != '')" ).append("\n"); 
		query.append("  AND C.VSL_CD = @[txtvslCd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${txtskdVoyNo} != '')" ).append("\n"); 
		query.append("  AND C.SKD_VOY_NO = @[txtskdVoyNo] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${txtdirCd_cd} != '')" ).append("\n"); 
		query.append("  AND C.SKD_DIR_CD = @[txtdirCd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("    #if (${chkprd} == 'M')" ).append("\n"); 
		query.append("	  A.COST_YRMON, 	" ).append("\n"); 
		query.append("	#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  	  A.SLS_YRMON," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("      A.COST_WK, " ).append("\n"); 
		query.append("      C.TRD_CD, " ).append("\n"); 
		query.append("      A.SUB_TRD_CD, " ).append("\n"); 
		query.append("	  A.SLAN_CD, " ).append("\n"); 
		query.append("	  C.RLANE_CD, " ).append("\n"); 
		query.append("	  C.BSA_OP_CD, " ).append("\n"); 
		query.append("	  C.VSL_CD, " ).append("\n"); 
		query.append("	  C.SKD_VOY_NO, " ).append("\n"); 
		query.append("	  C.SKD_DIR_CD, " ).append("\n"); 
		query.append("	  C.VOP_CD, " ).append("\n"); 
		query.append("	  C.CRR_CD, " ).append("\n"); 
		query.append("	  C.VSL_CAPA, " ).append("\n"); 
		query.append("	  C.BSA_CAPA, " ).append("\n"); 
		query.append("	  C.FNL_HJS_BSA_CAPA, " ).append("\n"); 
		query.append("	  C.CO_BSA_CAPA, " ).append("\n"); 
		query.append("	  C.HJS_BSA_RTO, " ).append("\n"); 
		query.append("	  C.CHTR_BSA_RTO, " ).append("\n"); 
		query.append("	  C.EXPN_BZC_CHTR_AMT, " ).append("\n"); 
		query.append("	  C.EXPN_SUB_CHTR_AMT, " ).append("\n"); 
		query.append("	  C.EXPN_CRS_CHTR_AMT, " ).append("\n"); 
		query.append("	  C.INCM_BZC_CHTR_AMT, " ).append("\n"); 
		query.append("	  C.INCM_SUB_CHTR_AMT, " ).append("\n"); 
		query.append("	  C.INCM_CRS_CHTR_AMT, " ).append("\n"); 
		query.append("	  C.IOC_CD, " ).append("\n"); 
		query.append("	  C.BSA_OP_CD" ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("  #if (${chkprd} == 'M')" ).append("\n"); 
		query.append("  	SUBSTR(A.COST_YRMON, 0, 4) ||'-'|| A.COST_WK," ).append("\n"); 
		query.append("  #elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  	  SUBSTR(A.SLS_YRMON, 0, 4) ||'-'|| A.COST_WK," ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("      C.TRD_CD, " ).append("\n"); 
		query.append("      A.SUB_TRD_CD, " ).append("\n"); 
		query.append("      A.SLAN_CD, " ).append("\n"); 
		query.append("      C.RLANE_CD, " ).append("\n"); 
		query.append("      C.BSA_OP_CD" ).append("\n"); 

	}
}