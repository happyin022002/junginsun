/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusAdjRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.21
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.12.21 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusAdjRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Estimate Performance Change Status Inquiry
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusAdjRSQL(){
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
		query.append("FileName : JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusAdjRSQL").append("\n"); 
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
		query.append("WITH ESTM AS (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	  EXE_YRMON" ).append("\n"); 
		query.append("	, REV_YRMON" ).append("\n"); 
		query.append("	, JO_CRR_CD" ).append("\n"); 
		query.append("	, VVD" ).append("\n"); 
		query.append("	, RLANE_CD" ).append("\n"); 
		query.append("	, JO_STL_JB_CD" ).append("\n"); 
		query.append("	, ACCT_CD" ).append("\n"); 
		query.append("	, ESTM1_BSA_QTY" ).append("\n"); 
		query.append("	, ESTM1_BSA_SLT_PRC" ).append("\n"); 
		query.append("	, ESTM1_AMT" ).append("\n"); 
		query.append("	, ESTM2_BSA_QTY" ).append("\n"); 
		query.append("	, ESTM2_BSA_SLT_PRC" ).append("\n"); 
		query.append("	, ESTM2_AMT" ).append("\n"); 
		query.append("	, CAL_AMT" ).append("\n"); 
		query.append("	, CHANGE_ITEM" ).append("\n"); 
		query.append("	, ADJ_ESTM1_BSA_QTY" ).append("\n"); 
		query.append("	, ADJ_ESTM1_BSA_SLT_PRC" ).append("\n"); 
		query.append("	, ADJ_ESTM1_AMT" ).append("\n"); 
		query.append("	, ADJ_ESTM2_BSA_QTY" ).append("\n"); 
		query.append("	, ADJ_ESTM2_BSA_SLT_PRC" ).append("\n"); 
		query.append("	, ADJ_ESTM2_AMT" ).append("\n"); 
		query.append("	, ADJ_CAL_AMT" ).append("\n"); 
		query.append("	, ADJ_CHANGE_ITEM" ).append("\n"); 
		query.append("	, ESTM_OPTION" ).append("\n"); 
		query.append("	, ADJ_RMK" ).append("\n"); 
		query.append("	, JB_EXE_YRMON" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			  A.EXE_YRMON" ).append("\n"); 
		query.append("			, A.REV_YRMON" ).append("\n"); 
		query.append("			, A.JO_CRR_CD" ).append("\n"); 
		query.append("			, A.VVD" ).append("\n"); 
		query.append("			, A.RLANE_CD" ).append("\n"); 
		query.append("			, DECODE(A.JO_STL_JB_CD, '101', 'JOINT OPERATION', '102', 'LEASE', '103', 'ADDITIONAL') JO_STL_JB_CD" ).append("\n"); 
		query.append("			, A.ACCT_CD" ).append("\n"); 
		query.append("			, A.BSA_QTY ESTM1_BSA_QTY" ).append("\n"); 
		query.append("			, A.BSA_SLT_PRC ESTM1_BSA_SLT_PRC" ).append("\n"); 
		query.append("			, ROUND(A.ESTM_AMT, 2) ESTM1_AMT" ).append("\n"); 
		query.append("			, B.BSA_QTY ESTM2_BSA_QTY" ).append("\n"); 
		query.append("			, B.BSA_SLT_PRC ESTM2_BSA_SLT_PRC" ).append("\n"); 
		query.append("			, ROUND(B.ESTM_AMT, 2) ESTM2_AMT" ).append("\n"); 
		query.append("			, NVL(ROUND(B.ESTM_AMT, 2), 0) - NVL(ROUND(A.ESTM_AMT, 2), 0)  CAL_AMT" ).append("\n"); 
		query.append("			, A.ADJ_BSA_QTY ADJ_ESTM1_BSA_QTY" ).append("\n"); 
		query.append("			, A.ADJ_BSA_SLT_PRC ADJ_ESTM1_BSA_SLT_PRC" ).append("\n"); 
		query.append("			, ROUND(A.ADJ_ESTM_AMT, 2) ADJ_ESTM1_AMT" ).append("\n"); 
		query.append("			, B.ADJ_BSA_QTY ADJ_ESTM2_BSA_QTY" ).append("\n"); 
		query.append("			, B.ADJ_BSA_SLT_PRC ADJ_ESTM2_BSA_SLT_PRC" ).append("\n"); 
		query.append("			, ROUND(B.ADJ_ESTM_AMT, 2) ADJ_ESTM2_AMT" ).append("\n"); 
		query.append("			, NVL(ROUND(B.ADJ_ESTM_AMT, 2), 0) - NVL(ROUND(A.ADJ_ESTM_AMT, 2), 0)  ADJ_CAL_AMT" ).append("\n"); 
		query.append("			, CASE WHEN A.BSA_QTY = B.BSA_QTY  AND A.BSA_SLT_PRC <> B.BSA_SLT_PRC  THEN 'Price'" ).append("\n"); 
		query.append("                        WHEN A.BSA_QTY <> B.BSA_QTY  AND A.BSA_SLT_PRC = B.BSA_SLT_PRC  THEN 'BSA'" ).append("\n"); 
		query.append("                        WHEN A.BSA_QTY <> B.BSA_QTY  AND A.BSA_SLT_PRC <> B.BSA_SLT_PRC  THEN 'BSA, Price'" ).append("\n"); 
		query.append("                        WHEN  NVL(B.BSA_QTY, 0) = 0    THEN 'C, V, BT'" ).append("\n"); 
		query.append("              END CHANGE_ITEM " ).append("\n"); 
		query.append("			, CASE WHEN A.ADJ_BSA_QTY = B.ADJ_BSA_QTY  AND A.ADJ_BSA_SLT_PRC <> B.ADJ_BSA_SLT_PRC  THEN 'Price'" ).append("\n"); 
		query.append("                        WHEN A.ADJ_BSA_QTY <> B.ADJ_BSA_QTY  AND A.ADJ_BSA_SLT_PRC = B.ADJ_BSA_SLT_PRC  THEN 'BSA'" ).append("\n"); 
		query.append("                        WHEN A.ADJ_BSA_QTY <> B.ADJ_BSA_QTY  AND A.ADJ_BSA_SLT_PRC <> B.ADJ_BSA_SLT_PRC  THEN 'BSA, Price'" ).append("\n"); 
		query.append("                        WHEN  NVL(B.ADJ_BSA_QTY, 0) = 0  AND NVL(A.ADJ_BSA_QTY, 0) <> 0 THEN 'C, V, BT'" ).append("\n"); 
		query.append("              END ADJ_CHANGE_ITEM " ).append("\n"); 
		query.append("			, DECODE(@[estm_option],'0','INI', '1','ADJ') ESTM_OPTION" ).append("\n"); 
		query.append("			, REPLACE(@[rev_yrmon],'-','') JB_EXE_YRMON" ).append("\n"); 
		query.append("			,(SELECT L.ADJ_RMK" ).append("\n"); 
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
		query.append("      ( SELECT 	  T.EXE_YRMON" ).append("\n"); 
		query.append("				, T.REV_YRMON" ).append("\n"); 
		query.append("				, T.JO_CRR_CD" ).append("\n"); 
		query.append("				, T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD||T.REV_DIR_CD VVD" ).append("\n"); 
		query.append("				, T.RLANE_CD" ).append("\n"); 
		query.append("				, T.ACCT_CD" ).append("\n"); 
		query.append("				, T.JO_STL_JB_CD" ).append("\n"); 
		query.append("				, T.BSA_QTY" ).append("\n"); 
		query.append("				, T.BSA_SLT_PRC" ).append("\n"); 
		query.append("                , T.ESTM_AMT	" ).append("\n"); 
		query.append("				, T.ADJ_BSA_QTY" ).append("\n"); 
		query.append("				, T.ADJ_BSA_SLT_PRC" ).append("\n"); 
		query.append("                , T.ACT_AMT + T.ADJ_ACCL_AMT AS ADJ_ESTM_AMT  --Actual + Adj. Accrual Cost		" ).append("\n"); 
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
		query.append("      ( SELECT 	  T.EXE_YRMON" ).append("\n"); 
		query.append("				, T.REV_YRMON" ).append("\n"); 
		query.append("				, T.JO_CRR_CD" ).append("\n"); 
		query.append("				, T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD||T.REV_DIR_CD VVD" ).append("\n"); 
		query.append("				, T.RLANE_CD" ).append("\n"); 
		query.append("				, T.ACCT_CD" ).append("\n"); 
		query.append("				, T.JO_STL_JB_CD" ).append("\n"); 
		query.append("				, T.BSA_QTY" ).append("\n"); 
		query.append("				, T.BSA_SLT_PRC" ).append("\n"); 
		query.append("				, T.ESTM_AMT" ).append("\n"); 
		query.append("				, T.ADJ_BSA_QTY" ).append("\n"); 
		query.append("				, T.ADJ_BSA_SLT_PRC" ).append("\n"); 
		query.append("                , T.ACT_AMT + T.ADJ_ACCL_AMT AS ADJ_ESTM_AMT  --Actual + Adj. Accrual Cost		" ).append("\n"); 
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
		query.append("      )  B" ).append("\n"); 
		query.append("	  , MDM_REV_LANE M" ).append("\n"); 
		query.append("	  WHERE 1 = 1" ).append("\n"); 
		query.append("		AND A.REV_YRMON		=  B.REV_YRMON (+)" ).append("\n"); 
		query.append("		#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("		AND A.JO_CRR_CD		=  @[jo_crr_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND A.JO_CRR_CD		=  B.JO_CRR_CD (+)" ).append("\n"); 
		query.append("		#if (${vvd} != '')" ).append("\n"); 
		query.append("		AND A.VVD			LIKE @[vvd]||'%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND A.VVD			=  B.VVD (+)" ).append("\n"); 
		query.append("		AND A.ACCT_CD		=  B.ACCT_CD (+)" ).append("\n"); 
		query.append("		#if (${jo_stl_jb_cd} != '')" ).append("\n"); 
		query.append("		AND A.JO_STL_JB_CD = @[jo_stl_jb_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND A.JO_STL_JB_CD	=  B.JO_STL_JB_CD (+)" ).append("\n"); 
		query.append("		#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("		AND A.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("		#end	" ).append("\n"); 
		query.append("		AND A.RLANE_CD		=  B.RLANE_CD (+)" ).append("\n"); 
		query.append("		AND M.RLANE_CD		=  A.RLANE_CD	-- Lane" ).append("\n"); 
		query.append("		#if (${trd_cd} != '')" ).append("\n"); 
		query.append("		AND M.REP_TRD_CD    = @[trd_cd]	-- Trade" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 	  A.EXE_YRMON" ).append("\n"); 
		query.append("				, A.REV_YRMON" ).append("\n"); 
		query.append("				, A.JO_CRR_CD" ).append("\n"); 
		query.append("				, A.VVD" ).append("\n"); 
		query.append("				, A.RLANE_CD" ).append("\n"); 
		query.append("				, DECODE(A.JO_STL_JB_CD, '101', 'JOINT OPERATION', '102', 'LEASE', '103', 'ADDITIONAL') JO_STL_JB_CD" ).append("\n"); 
		query.append("				, A.ACCT_CD" ).append("\n"); 
		query.append("				, B.BSA_QTY ESTM1_BSA_QTY" ).append("\n"); 
		query.append("				, B.BSA_SLT_PRC ESTM1_BSA_SLT_PRC" ).append("\n"); 
		query.append("				, ROUND(B.ESTM_AMT, 2) ESTM1_AMT" ).append("\n"); 
		query.append("				, A.BSA_QTY ESTM2_BSA_QTY" ).append("\n"); 
		query.append("				, A.BSA_SLT_PRC ESTM2_BSA_SLT_PRC" ).append("\n"); 
		query.append("				, ROUND(A.ESTM_AMT, 2) ESTM2_AMT" ).append("\n"); 
		query.append("				, NVL(ROUND(A.ESTM_AMT, 2), 0) - NVL(ROUND(B.ESTM_AMT, 2), 0)  CAL_AMT" ).append("\n"); 
		query.append("				, B.ADJ_BSA_QTY ADJ_ESTM1_BSA_QTY" ).append("\n"); 
		query.append("				, B.ADJ_BSA_SLT_PRC ADJ_ESTM1_BSA_SLT_PRC" ).append("\n"); 
		query.append("				, ROUND(B.ADJ_ESTM_AMT, 2) ADJ_ESTM1_AMT" ).append("\n"); 
		query.append("				, A.ADJ_BSA_QTY ADJ_ESTM2_BSA_QTY" ).append("\n"); 
		query.append("				, A.ADJ_BSA_SLT_PRC ADJ_ESTM2_BSA_SLT_PRC" ).append("\n"); 
		query.append("				, ROUND(A.ADJ_ESTM_AMT, 2) ADJ_ESTM2_AMT, NVL(ROUND(A.ADJ_ESTM_AMT, 2), 0) - NVL(ROUND(B.ADJ_ESTM_AMT, 2), 0) ADJ_CAL_AMT," ).append("\n"); 
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
		query.append("      ( SELECT 	  " ).append("\n"); 
		query.append("				T.EXE_YRMON" ).append("\n"); 
		query.append("			  , T.REV_YRMON" ).append("\n"); 
		query.append("			  , T.JO_CRR_CD" ).append("\n"); 
		query.append("			  , T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD||T.REV_DIR_CD VVD" ).append("\n"); 
		query.append("			  , T.RLANE_CD" ).append("\n"); 
		query.append("			  , T.ACCT_CD" ).append("\n"); 
		query.append("			  , T.JO_STL_JB_CD" ).append("\n"); 
		query.append("			  , T.BSA_QTY" ).append("\n"); 
		query.append("			  , T.BSA_SLT_PRC" ).append("\n"); 
		query.append("			  , T.ESTM_AMT" ).append("\n"); 
		query.append("			  , T.ADJ_BSA_QTY" ).append("\n"); 
		query.append("			  , T.ADJ_BSA_SLT_PRC" ).append("\n"); 
		query.append("              , T.ACT_AMT + T.ADJ_ACCL_AMT AS ADJ_ESTM_AMT  --Actual + Adj. Accrual Cost		" ).append("\n"); 
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
		query.append("      ( SELECT " ).append("\n"); 
		query.append("				T.EXE_YRMON" ).append("\n"); 
		query.append("			  , T.REV_YRMON" ).append("\n"); 
		query.append("			  , T.JO_CRR_CD" ).append("\n"); 
		query.append("			  , T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD||T.REV_DIR_CD VVD" ).append("\n"); 
		query.append("			  , T.RLANE_CD" ).append("\n"); 
		query.append("			  , T.ACCT_CD" ).append("\n"); 
		query.append("			  , T.JO_STL_JB_CD" ).append("\n"); 
		query.append("			  , T.BSA_QTY" ).append("\n"); 
		query.append("			  , T.BSA_SLT_PRC" ).append("\n"); 
		query.append("			  , T.ESTM_AMT" ).append("\n"); 
		query.append("			  , T.ADJ_BSA_QTY" ).append("\n"); 
		query.append("			  , T.ADJ_BSA_SLT_PRC" ).append("\n"); 
		query.append("              , T.ACT_AMT + T.ADJ_ACCL_AMT AS ADJ_ESTM_AMT  --Actual + Adj. Accrual Cost		" ).append("\n"); 
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
		query.append("      )  B" ).append("\n"); 
		query.append("	  , MDM_REV_LANE M" ).append("\n"); 
		query.append("	  WHERE 1 = 1" ).append("\n"); 
		query.append("	  	AND A.REV_YRMON		=  B.REV_YRMON (+)" ).append("\n"); 
		query.append("		#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("		AND A.JO_CRR_CD		=  @[jo_crr_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND A.JO_CRR_CD		=  B.JO_CRR_CD (+)" ).append("\n"); 
		query.append("		#if (${vvd} != '')" ).append("\n"); 
		query.append("		AND A.VVD			LIKE @[vvd]||'%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND A.VVD			=  B.VVD (+)" ).append("\n"); 
		query.append("		AND A.ACCT_CD		=  B.ACCT_CD (+)" ).append("\n"); 
		query.append("		#if (${jo_stl_jb_cd} != '')" ).append("\n"); 
		query.append("		AND A.JO_STL_JB_CD = @[jo_stl_jb_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND A.JO_STL_JB_CD	=  B.JO_STL_JB_CD (+)" ).append("\n"); 
		query.append("		#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("		AND A.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND A.RLANE_CD		=  B.RLANE_CD (+)" ).append("\n"); 
		query.append("		AND NVL(B.BSA_QTY  , 0)	= 0" ).append("\n"); 
		query.append("		AND M.RLANE_CD		=  A.RLANE_CD	-- Lane" ).append("\n"); 
		query.append("		#if (${trd_cd} != '')" ).append("\n"); 
		query.append("		AND M.REP_TRD_CD    = @[trd_cd]	-- Trade" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#if(${changed_option} == 'Y')" ).append("\n"); 
		query.append("		#if(${estm_option} == '0')" ).append("\n"); 
		query.append("			WHERE CHANGE_ITEM IS NOT NULL" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			WHERE ADJ_CHANGE_ITEM IS NOT NULL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT DISTINCT  " ).append("\n"); 
		query.append("	  REV_YRMON" ).append("\n"); 
		query.append("	, JO_CRR_CD" ).append("\n"); 
		query.append("	, VVD" ).append("\n"); 
		query.append("	, RLANE_CD" ).append("\n"); 
		query.append("	, JO_STL_JB_CD" ).append("\n"); 
		query.append("	, ACCT_CD" ).append("\n"); 
		query.append("	, ESTM1_BSA_QTY" ).append("\n"); 
		query.append("	, ESTM1_BSA_SLT_PRC" ).append("\n"); 
		query.append("	, ESTM1_AMT" ).append("\n"); 
		query.append("	, ESTM2_BSA_QTY" ).append("\n"); 
		query.append("	, ESTM2_BSA_SLT_PRC" ).append("\n"); 
		query.append("	, ESTM2_AMT" ).append("\n"); 
		query.append("	, CAL_AMT" ).append("\n"); 
		query.append("--	, CHANGE_ITEM" ).append("\n"); 
		query.append("	, ADJ_ESTM1_BSA_QTY" ).append("\n"); 
		query.append("	, ADJ_ESTM1_BSA_SLT_PRC" ).append("\n"); 
		query.append("	, ADJ_ESTM1_AMT" ).append("\n"); 
		query.append("	, ADJ_ESTM2_BSA_QTY" ).append("\n"); 
		query.append("	, ADJ_ESTM2_BSA_SLT_PRC" ).append("\n"); 
		query.append("	, ADJ_ESTM2_AMT" ).append("\n"); 
		query.append("	, ADJ_CAL_AMT" ).append("\n"); 
		query.append("--	, ADJ_CHANGE_ITEM" ).append("\n"); 
		query.append("	, ESTM_OPTION" ).append("\n"); 
		query.append("	, ADJ_RMK" ).append("\n"); 
		query.append("	, JB_EXE_YRMON" ).append("\n"); 
		query.append("FROM ESTM E" ).append("\n"); 
		query.append("ORDER BY REV_YRMON, JO_CRR_CD, VVD, RLANE_CD, ACCT_CD" ).append("\n"); 

	}
}