/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.09
*@LastModifier : 조병연
*@LastVersion : 1.0
* 2012.02.09 조병연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JO BYEANG YEAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FNS_JOO_0088 Estimate Performance Change Status Inquiry
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_option",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusRSQL").append("\n"); 
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
		query.append("SELECT EXE_YRMON, REV_YRMON, JO_CRR_CD, VVD, RLANE_CD, JO_STL_JB_CD, ACCT_CD, " ).append("\n"); 
		query.append("	ESTM1_BSA_QTY, ESTM1_BSA_SLT_PRC, ESTM1_AMT, ESTM2_BSA_QTY, ESTM2_BSA_SLT_PRC, ESTM2_AMT, CAL_AMT, CHANGE_ITEM, " ).append("\n"); 
		query.append("	ADJ_ESTM1_BSA_QTY, ADJ_ESTM1_BSA_SLT_PRC, ADJ_ESTM1_AMT, ADJ_ESTM2_BSA_QTY, ADJ_ESTM2_BSA_SLT_PRC, ADJ_ESTM2_AMT, ADJ_CAL_AMT, ADJ_CHANGE_ITEM, " ).append("\n"); 
		query.append("	ESTM_OPTION, ADJ_RMK, JB_EXE_YRMON" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.EXE_YRMON, A.REV_YRMON, A.JO_CRR_CD, A.VVD, A.RLANE_CD, DECODE(A.JO_STL_JB_CD, '101', 'JOINT OPERATION', '102', 'LEASE', '103', 'ADDITIONAL') JO_STL_JB_CD, A.ACCT_CD," ).append("\n"); 
		query.append("              A.BSA_QTY ESTM1_BSA_QTY, A.BSA_SLT_PRC ESTM1_BSA_SLT_PRC, ROUND(A.ESTM_AMT, 2) ESTM1_AMT, B.BSA_QTY ESTM2_BSA_QTY, B.BSA_SLT_PRC ESTM2_BSA_SLT_PRC, ROUND(B.ESTM_AMT, 2) ESTM2_AMT, NVL(ROUND(B.ESTM_AMT, 2), 0) - NVL(ROUND(A.ESTM_AMT, 2), 0)  CAL_AMT," ).append("\n"); 
		query.append("              A.ADJ_BSA_QTY ADJ_ESTM1_BSA_QTY, A.ADJ_BSA_SLT_PRC ADJ_ESTM1_BSA_SLT_PRC, ROUND(A.ADJ_ESTM_AMT, 2) ADJ_ESTM1_AMT, B.ADJ_BSA_QTY ADJ_ESTM2_BSA_QTY, B.ADJ_BSA_SLT_PRC ADJ_ESTM2_BSA_SLT_PRC, ROUND(B.ADJ_ESTM_AMT, 2) ADJ_ESTM2_AMT, NVL(ROUND(B.ADJ_ESTM_AMT, 2), 0) - NVL(ROUND(A.ADJ_ESTM_AMT, 2), 0)  ADJ_CAL_AMT," ).append("\n"); 
		query.append("              CASE WHEN A.BSA_QTY = B.BSA_QTY  AND A.BSA_SLT_PRC <> B.BSA_SLT_PRC  THEN 'Price'" ).append("\n"); 
		query.append("                        WHEN A.BSA_QTY <> B.BSA_QTY  AND A.BSA_SLT_PRC = B.BSA_SLT_PRC  THEN 'BSA'" ).append("\n"); 
		query.append("                        WHEN A.BSA_QTY <> B.BSA_QTY  AND A.BSA_SLT_PRC <> B.BSA_SLT_PRC  THEN 'BSA, Price'" ).append("\n"); 
		query.append("                        WHEN  NVL(B.BSA_QTY, 0) = 0    THEN 'C, V, BT'" ).append("\n"); 
		query.append("              END CHANGE_ITEM ," ).append("\n"); 
		query.append("              CASE WHEN A.ADJ_BSA_QTY = B.ADJ_BSA_QTY  AND A.ADJ_BSA_SLT_PRC <> B.ADJ_BSA_SLT_PRC  THEN 'Price'" ).append("\n"); 
		query.append("                        WHEN A.ADJ_BSA_QTY <> B.ADJ_BSA_QTY  AND A.ADJ_BSA_SLT_PRC = B.ADJ_BSA_SLT_PRC  THEN 'BSA'" ).append("\n"); 
		query.append("                        WHEN A.ADJ_BSA_QTY <> B.ADJ_BSA_QTY  AND A.ADJ_BSA_SLT_PRC <> B.ADJ_BSA_SLT_PRC  THEN 'BSA, Price'" ).append("\n"); 
		query.append("                        WHEN  NVL(B.ADJ_BSA_QTY, 0) = 0  AND NVL(A.ADJ_BSA_QTY, 0) <> 0 THEN 'C, V, BT'" ).append("\n"); 
		query.append("              END ADJ_CHANGE_ITEM ," ).append("\n"); 
		query.append("			  DECODE(@[estm_option],'0','INI', '1','ADJ') ESTM_OPTION, REPLACE(@[rev_yrmon],'-','') JB_EXE_YRMON," ).append("\n"); 
		query.append("              (SELECT L.ADJ_RMK" ).append("\n"); 
		query.append("               FROM JOO_ESTM_ACT_RSLT_ANAL L " ).append("\n"); 
		query.append("               WHERE L.EXE_YRMON		= REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 
		query.append("               AND  L.JB_EXE_YRMON		= REPLACE(@[rev_yrmon],'-','')" ).append("\n"); 
		query.append("			#if (${estm_option} != '')" ).append("\n"); 
		query.append("				AND  L.JO_ESTM_ANAL_ID	= DECODE(@[estm_option],'0','INI', '1','ADJ')	-- Initial Estimate(INI), Adjusted Estimate(ADJ)" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND  L.JO_ESTM_ANAL_ID	= 'INI'	-- Initial Estimate(INI), Adjusted Estimate(ADJ)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("               AND  A.REV_YRMON			= L.REV_YRMON" ).append("\n"); 
		query.append("               AND  A.JO_CRR_CD			= L.JO_CRR_CD" ).append("\n"); 
		query.append("               AND  A.VVD				= L.VSL_CD||L.SKD_VOY_NO||L.SKD_DIR_CD||L.REV_DIR_CD" ).append("\n"); 
		query.append("               AND  A.RLANE_CD			= L.RLANE_CD" ).append("\n"); 
		query.append("               AND  A.JO_STL_JB_CD		= L.JO_STL_JB_CD" ).append("\n"); 
		query.append("               AND  A.ACCT_CD			= L.ACCT_CD" ).append("\n"); 
		query.append("              ) ADJ_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("      ( SELECT T.EXE_YRMON, T.REV_YRMON, T.JO_CRR_CD, T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD||T.REV_DIR_CD VVD, T.RLANE_CD," ).append("\n"); 
		query.append("                      T.ACCT_CD, T.JO_STL_JB_CD, T.BSA_QTY, T.BSA_SLT_PRC, T.ESTM_AMT, T.ADJ_BSA_QTY, T.ADJ_BSA_SLT_PRC, T.ADJ_ESTM_AMT" ).append("\n"); 
		query.append("        FROM JOO_ESTM_ACT_RSLT T" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("        AND T.EXE_YRMON	= REPLACE(@[exe_yrmon],'-','')	-- FROM 년월		-- exe_yrmon" ).append("\n"); 
		query.append("		#if (${rev_yrmon_fr} == ${rev_yrmon_to})" ).append("\n"); 
		query.append("        AND T.REV_YRMON	= REPLACE(@[rev_yrmon_fr],'-','')" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("        AND T.REV_YRMON	BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND  REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${re_divr_cd} != 'A')" ).append("\n"); 
		query.append("		AND T.ACCT_CD = DECODE(@[re_divr_cd],'R','411221','E','510921')	-- Rev/Exp" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		AND T.ACCT_CD IN ('510921', '411221')	-- Rev/Exp" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("      )  A," ).append("\n"); 
		query.append("      ( SELECT T.EXE_YRMON, T.REV_YRMON, T.JO_CRR_CD, T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD||T.REV_DIR_CD VVD, T.RLANE_CD," ).append("\n"); 
		query.append("                      T.ACCT_CD, T.JO_STL_JB_CD, T.BSA_QTY, T.BSA_SLT_PRC, T.ESTM_AMT, T.ADJ_BSA_QTY, T.ADJ_BSA_SLT_PRC, T.ADJ_ESTM_AMT" ).append("\n"); 
		query.append("        FROM JOO_ESTM_ACT_RSLT T" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("        AND T.EXE_YRMON	= REPLACE(@[rev_yrmon],'-','')	-- TO 년월	-- rev_yrmon" ).append("\n"); 
		query.append("		#if (${rev_yrmon_fr} == ${rev_yrmon_to})" ).append("\n"); 
		query.append("        AND T.REV_YRMON	= REPLACE(@[rev_yrmon_fr],'-','')" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("        AND T.REV_YRMON	BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND  REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${re_divr_cd} != 'A')" ).append("\n"); 
		query.append("		AND T.ACCT_CD = DECODE(@[re_divr_cd],'R','411221','E','510921')	-- Rev/Exp" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		AND T.ACCT_CD IN ('510921', '411221')	-- Rev/Exp" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("      )  B, MDM_REV_LANE M" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.REV_YRMON		=  B.REV_YRMON (+)" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("AND A.JO_CRR_CD		=  @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.JO_CRR_CD		=  B.JO_CRR_CD (+)" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("AND A.VVD			LIKE @[vvd]||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.VVD			=  B.VVD (+)" ).append("\n"); 
		query.append("AND A.ACCT_CD		=  B.ACCT_CD (+)" ).append("\n"); 
		query.append("#if (${jo_stl_jb_cd} != '')" ).append("\n"); 
		query.append("AND A.JO_STL_JB_CD = @[jo_stl_jb_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.JO_STL_JB_CD	=  B.JO_STL_JB_CD (+)" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("AND A.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.RLANE_CD		=  B.RLANE_CD (+)" ).append("\n"); 
		query.append("AND M.RLANE_CD		=  A.RLANE_CD	-- Lane" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("AND M.REP_TRD_CD    = @[trd_cd]	-- Trade" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.EXE_YRMON, A.REV_YRMON, A.JO_CRR_CD, A.VVD, A.RLANE_CD, DECODE(A.JO_STL_JB_CD, '101', 'JOINT OPERATION', '102', 'LEASE', '103', 'ADDITIONAL') JO_STL_JB_CD, A.ACCT_CD," ).append("\n"); 
		query.append("              B.BSA_QTY ESTM1_BSA_QTY, B.BSA_SLT_PRC ESTM1_BSA_SLT_PRC, ROUND(B.ESTM_AMT, 2) ESTM1_AMT, A.BSA_QTY ESTM2_BSA_QTY, A.BSA_SLT_PRC ESTM2_BSA_SLT_PRC, ROUND(A.ESTM_AMT, 2) ESTM2_AMT, NVL(ROUND(A.ESTM_AMT, 2), 0) - NVL(ROUND(B.ESTM_AMT, 2), 0)  CAL_AMT," ).append("\n"); 
		query.append("              B.ADJ_BSA_QTY ADJ_ESTM1_BSA_QTY, B.ADJ_BSA_SLT_PRC ADJ_ESTM1_BSA_SLT_PRC, ROUND(B.ADJ_ESTM_AMT, 2) ADJ_ESTM1_AMT, A.ADJ_BSA_QTY ADJ_ESTM2_BSA_QTY, A.ADJ_BSA_SLT_PRC ADJ_ESTM2_BSA_SLT_PRC, ROUND(A.ADJ_ESTM_AMT, 2) ADJ_ESTM2_AMT, NVL(ROUND(A.ADJ_ESTM_AMT, 2), 0) - NVL(ROUND(B.ADJ_ESTM_AMT, 2), 0) ADJ_CAL_AMT," ).append("\n"); 
		query.append("              CASE WHEN NVL(B.BSA_QTY, 0) = 0    THEN 'C, V, BT'" ).append("\n"); 
		query.append("              END CHANGE_ITEM, " ).append("\n"); 
		query.append("              CASE WHEN NVL(B.ADJ_BSA_QTY, 0) = 0 AND NVL(A.ADJ_BSA_QTY, 0) <> 0   THEN 'C, V, BT'" ).append("\n"); 
		query.append("              END ADJ_CHANGE_ITEM, " ).append("\n"); 
		query.append("			  DECODE(@[estm_option],'0','INI', '1','ADJ') ESTM_OPTION , REPLACE(@[rev_yrmon],'-','') JB_EXE_YRMON," ).append("\n"); 
		query.append("              (SELECT L.ADJ_RMK" ).append("\n"); 
		query.append("               FROM JOO_ESTM_ACT_RSLT_ANAL L " ).append("\n"); 
		query.append("               WHERE L.EXE_YRMON		= REPLACE(@[exe_yrmon],'-','')" ).append("\n"); 
		query.append("               AND  L.JB_EXE_YRMON		= REPLACE(@[rev_yrmon],'-','')" ).append("\n"); 
		query.append("			#if (${estm_option} != '')" ).append("\n"); 
		query.append("				AND  L.JO_ESTM_ANAL_ID	= DECODE(@[estm_option],'0','INI', '1','ADJ')	-- Initial Estimate(INI), Adjusted Estimate(ADJ)" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND  L.JO_ESTM_ANAL_ID	= 'INI'	-- Initial Estimate(INI), Adjusted Estimate(ADJ)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("               AND  A.REV_YRMON			= L.REV_YRMON" ).append("\n"); 
		query.append("               AND  A.JO_CRR_CD			= L.JO_CRR_CD" ).append("\n"); 
		query.append("               AND  A.VVD				= L.VSL_CD||L.SKD_VOY_NO||L.SKD_DIR_CD||L.REV_DIR_CD" ).append("\n"); 
		query.append("               AND  A.RLANE_CD			= L.RLANE_CD" ).append("\n"); 
		query.append("               AND  A.JO_STL_JB_CD		= L.JO_STL_JB_CD" ).append("\n"); 
		query.append("               AND  A.ACCT_CD			= L.ACCT_CD" ).append("\n"); 
		query.append("              ) ADJ_RMK " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("      ( SELECT T.EXE_YRMON, T.REV_YRMON, T.JO_CRR_CD, T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD||T.REV_DIR_CD VVD, T.RLANE_CD," ).append("\n"); 
		query.append("                      T.ACCT_CD, T.JO_STL_JB_CD, T.BSA_QTY, T.BSA_SLT_PRC, T.ESTM_AMT, T.ADJ_BSA_QTY, T.ADJ_BSA_SLT_PRC, T.ADJ_ESTM_AMT" ).append("\n"); 
		query.append("        FROM JOO_ESTM_ACT_RSLT T" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("        AND T.EXE_YRMON	= REPLACE(@[rev_yrmon],'-','')	-- TO 년월	-- rev_yrmon" ).append("\n"); 
		query.append("		#if (${rev_yrmon_fr} == ${rev_yrmon_to})" ).append("\n"); 
		query.append("        AND T.REV_YRMON	= REPLACE(@[rev_yrmon_fr],'-','')" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("        AND T.REV_YRMON	BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND  REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${re_divr_cd} != 'A')" ).append("\n"); 
		query.append("		AND T.ACCT_CD = DECODE(@[re_divr_cd],'R','411221','E','510921')	-- Rev/Exp" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		AND T.ACCT_CD IN ('510921', '411221')	-- Rev/Exp" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("      )  A," ).append("\n"); 
		query.append("      ( SELECT T.EXE_YRMON, T.REV_YRMON, T.JO_CRR_CD, T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD||T.REV_DIR_CD VVD, T.RLANE_CD," ).append("\n"); 
		query.append("                      T.ACCT_CD, T.JO_STL_JB_CD, T.BSA_QTY, T.BSA_SLT_PRC, T.ESTM_AMT, T.ADJ_BSA_QTY, T.ADJ_BSA_SLT_PRC, T.ADJ_ESTM_AMT" ).append("\n"); 
		query.append("        FROM JOO_ESTM_ACT_RSLT T" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("        AND T.EXE_YRMON	= REPLACE(@[exe_yrmon],'-','')	-- FROM 년월		-- exe_yrmon" ).append("\n"); 
		query.append("		#if (${rev_yrmon_fr} == ${rev_yrmon_to})" ).append("\n"); 
		query.append("        AND T.REV_YRMON	= REPLACE(@[rev_yrmon_fr],'-','')" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("        AND T.REV_YRMON	BETWEEN REPLACE(@[rev_yrmon_fr],'-','') AND  REPLACE(@[rev_yrmon_to],'-','')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${re_divr_cd} != 'A')" ).append("\n"); 
		query.append("		AND T.ACCT_CD = DECODE(@[re_divr_cd],'R','411221','E','510921')	-- Rev/Exp" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		AND T.ACCT_CD IN ('510921', '411221')	-- Rev/Exp" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("      )  B, MDM_REV_LANE M" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.REV_YRMON		=  B.REV_YRMON (+)" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("AND A.JO_CRR_CD		=  @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.JO_CRR_CD		=  B.JO_CRR_CD (+)" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("AND A.VVD			LIKE @[vvd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.VVD			=  B.VVD (+)" ).append("\n"); 
		query.append("AND A.ACCT_CD		=  B.ACCT_CD (+)" ).append("\n"); 
		query.append("#if (${jo_stl_jb_cd} != '')" ).append("\n"); 
		query.append("AND A.JO_STL_JB_CD = @[jo_stl_jb_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.JO_STL_JB_CD	=  B.JO_STL_JB_CD (+)" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("AND A.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.RLANE_CD		=  B.RLANE_CD (+)" ).append("\n"); 
		query.append("AND NVL(B.BSA_QTY  , 0)	= 0" ).append("\n"); 
		query.append("AND M.RLANE_CD		=  A.RLANE_CD	-- Lane" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("AND M.REP_TRD_CD    = @[trd_cd]	-- Trade" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${changed_option} == 'Y')" ).append("\n"); 
		query.append("	#if(${estm_option} == '0')" ).append("\n"); 
		query.append("		WHERE CHANGE_ITEM IS NOT NULL" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		WHERE ADJ_CHANGE_ITEM IS NOT NULL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY REV_YRMON, JO_CRR_CD, VVD, RLANE_CD, ACCT_CD" ).append("\n"); 

	}
}