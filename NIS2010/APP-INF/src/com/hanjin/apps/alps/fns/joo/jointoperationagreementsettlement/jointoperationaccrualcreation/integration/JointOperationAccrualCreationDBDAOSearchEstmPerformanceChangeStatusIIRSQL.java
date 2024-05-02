/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusIIRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusIIRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FNS_JOO_0089 Estimate Performance Change Status Inquiry
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusIIRSQL(){
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
		query.append("FileName : JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusIIRSQL").append("\n"); 
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
		query.append("WITH GLVVD AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT A.EXE_YRMON" ).append("\n"); 
		query.append("			, A.REV_YRMON" ).append("\n"); 
		query.append("			, A.VSL_CD" ).append("\n"); 
		query.append("			, A.SKD_VOY_NO" ).append("\n"); 
		query.append("			, A.SKD_DIR_CD" ).append("\n"); 
		query.append("			, A.REV_DIR_CD" ).append("\n"); 
		query.append("			, A.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("			, A.VVD_TP" ).append("\n"); 
		query.append("			, A.ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("			, A.RLANE_CD" ).append("\n"); 
		query.append("			, A.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("		( --A" ).append("\n"); 
		query.append("			SELECT EXE_YRMON" ).append("\n"); 
		query.append("					, REV_YRMON" ).append("\n"); 
		query.append("					, VSL_CD" ).append("\n"); 
		query.append("					, SKD_VOY_NO" ).append("\n"); 
		query.append("					, SKD_DIR_CD" ).append("\n"); 
		query.append("					, REV_DIR_CD" ).append("\n"); 
		query.append("					, ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("					, VVD_TP" ).append("\n"); 
		query.append("					, ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("					, RLANE_CD" ).append("\n"); 
		query.append("					, ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("					, ROW_NUMBER() OVER (PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, RLANE_CD ORDER BY VVD_TP) AS VVD_CNT" ).append("\n"); 
		query.append("			FROM " ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					SELECT EXE_YRMON" ).append("\n"); 
		query.append("							, REV_YRMON" ).append("\n"); 
		query.append("							, VSL_CD" ).append("\n"); 
		query.append("							, SKD_VOY_NO" ).append("\n"); 
		query.append("							, SKD_DIR_CD" ).append("\n"); 
		query.append("							, REV_DIR_CD" ).append("\n"); 
		query.append("							, ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("							, ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("							, ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("							, RLANE_CD" ).append("\n"); 
		query.append("							, DECODE(ESTM_VVD_TP_CD, 'RV', '1', 'BV', '2', 'PV', '3') AS VVD_TP" ).append("\n"); 
		query.append("							, ROW_NUMBER() OVER (PARTITION BY EXE_YRMON, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, RLANE_CD ORDER BY ESTM_IOC_DIV_CD DESC) AS IO_CNT" ).append("\n"); 
		query.append("					FROM GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("					WHERE EXE_YRMON = REPLACE(@[exe_yrmon],'-','') -- exe_yrmon" ).append("\n"); 
		query.append("						AND ESTM_BC_DIV_CD = 'C'" ).append("\n"); 
		query.append("						AND ESTM_IOC_DIV_CD IN ('OO', 'IA', 'IE', 'IM')" ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("					SELECT REPLACE(@[exe_yrmon],'-','') AS EXE_YRMON -- exe_yrmon" ).append("\n"); 
		query.append("							, REV_YRMON" ).append("\n"); 
		query.append("							, VSL_CD" ).append("\n"); 
		query.append("							, SKD_VOY_NO" ).append("\n"); 
		query.append("							, SKD_DIR_CD" ).append("\n"); 
		query.append("							, REV_DIR_CD" ).append("\n"); 
		query.append("							, ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("							, ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("							, ESTM_VVD_HDR_ID" ).append("\n"); 
		query.append("							, RLANE_CD" ).append("\n"); 
		query.append("							, DECODE(ESTM_VVD_TP_CD, 'RV', '1', 'BV', '2', 'PV', '3') AS VVD_TP" ).append("\n"); 
		query.append("							, ROW_NUMBER() OVER (PARTITION BY EXE_YRMON, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, RLANE_CD ORDER BY ESTM_IOC_DIV_CD DESC) AS IO_CNT" ).append("\n"); 
		query.append("					FROM GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("					WHERE EXE_YRMON = DECODE(SUBSTR(REPLACE(@[exe_yrmon], '-', ''), 1, 4), SUBSTR(REPLACE(@[exe_yrmon], '-', ''), 1, 4), '99999', SUBSTR(REPLACE(@[exe_yrmon], '-', ''), 1, 4)||'12')    -- exe_yrmon" ).append("\n"); 
		query.append("						AND ESTM_BC_DIV_CD = 'C'" ).append("\n"); 
		query.append("						AND ESTM_IOC_DIV_CD IN ('OO', 'IA', 'IE', 'IM')" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			WHERE REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr], '-', '') AND REPLACE(@[rev_yrmon_to], '-', '') -- target to - from" ).append("\n"); 
		query.append("				AND IO_CNT = 1" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("		-- Inter/Ocean중 Ocean 값만 취하기 위해 join건다." ).append("\n"); 
		query.append("		, AR_ROUT_RNK B" ).append("\n"); 
		query.append("	WHERE A.VVD_CNT = 1" ).append("\n"); 
		query.append("		AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("		AND A.ESTM_IOC_DIV_CD = SUBSTR(B.ZN_IOC_CD, 1, 2)" ).append("\n"); 
		query.append("		--IA, IAO, IE, IEO, IM, IMO 가 있음" ).append("\n"); 
		query.append("		AND B.ZN_IOC_CD NOT IN ('IA', 'IE', 'IM')" ).append("\n"); 
		query.append("		AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT EXE_YRMON, REV_YRMON, JO_CRR_CD, VVD, RLANE_CD, JO_STL_JB_CD, ACCT_CD, " ).append("\n"); 
		query.append("		ESTM1_BSA_QTY, ESTM1_BSA_SLT_PRC, ESTM1_AMT, ESTM2_BSA_QTY, ESTM2_BSA_SLT_PRC, ESTM2_AMT, CAL_AMT, CHANGE_ITEM, " ).append("\n"); 
		query.append("		JB_EXE_YRMON" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("		SELECT A.EXE_YRMON, A.REV_YRMON, A.JO_CRR_CD, A.VVD, A.RLANE_CD, DECODE(A.JO_STL_JB_CD, '101', 'JOINT OPERATION', '102', 'LEASE', '103', 'ADDITIONAL') JO_STL_JB_CD, A.ACCT_CD," ).append("\n"); 
		query.append("			A.BSA_QTY ESTM1_BSA_QTY, A.BSA_SLT_PRC ESTM1_BSA_SLT_PRC, ROUND(A.ESTM_AMT, 2) ESTM1_AMT, B.BSA_QTY ESTM2_BSA_QTY, B.BSA_SLT_PRC ESTM2_BSA_SLT_PRC, ROUND(B.ESTM_AMT, 2) ESTM2_AMT, NVL(ROUND(B.ESTM_AMT, 2), 0) - NVL(ROUND(A.ESTM_AMT, 2), 0)  CAL_AMT," ).append("\n"); 
		query.append("			CASE WHEN A.BSA_QTY = B.BSA_QTY AND A.BSA_SLT_PRC <> B.BSA_SLT_PRC THEN 'Price'" ).append("\n"); 
		query.append("				WHEN A.BSA_QTY <> B.BSA_QTY AND A.BSA_SLT_PRC = B.BSA_SLT_PRC THEN 'BSA'" ).append("\n"); 
		query.append("				WHEN A.BSA_QTY <> B.BSA_QTY AND A.BSA_SLT_PRC <> B.BSA_SLT_PRC THEN 'BSA, Price'" ).append("\n"); 
		query.append("				WHEN  NVL(B.BSA_QTY, 0) = 0 THEN 'C, V, BT'" ).append("\n"); 
		query.append("			END CHANGE_ITEM ," ).append("\n"); 
		query.append("			REPLACE(@[exe_yrmon],'-','') JB_EXE_YRMON   -- exe_yrmon" ).append("\n"); 
		query.append("		FROM" ).append("\n"); 
		query.append("			( " ).append("\n"); 
		query.append("				SELECT T.EXE_YRMON, T.REV_YRMON, T.JO_CRR_CD, T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD||T.REV_DIR_CD  VVD, T.RLANE_CD," ).append("\n"); 
		query.append("						T.ACCT_CD, T.JO_STL_JB_CD, T.BSA_QTY, T.BSA_SLT_PRC, T.ESTM_AMT" ).append("\n"); 
		query.append("				FROM JOO_ESTM_ACT_RSLT T" ).append("\n"); 
		query.append("				WHERE 1 = 1" ).append("\n"); 
		query.append("					AND T.EXE_YRMON	= REPLACE(@[exe_yrmon],'-','')     -- FROM 년월		-- exe_yrmon" ).append("\n"); 
		query.append("					AND T.REV_YRMON	BETWEEN REPLACE(@[rev_yrmon_fr], '-', '') AND REPLACE(@[rev_yrmon_to], '-', '')     -- From ~ To" ).append("\n"); 
		query.append("					AND T.ACCT_CD IN ('510921', '411221')	-- Rev/Exp" ).append("\n"); 
		query.append("			)  A," ).append("\n"); 
		query.append("			( " ).append("\n"); 
		query.append("				SELECT A.COST_YRMON AS REV_YRMON, A.VSL_CD||A.SKD_VOY_NO||A.DIR_CD||D.REV_DIR_CD VVD," ).append("\n"); 
		query.append("					/* ,A.VSL_CD" ).append("\n"); 
		query.append("						,A.SKD_VOY_NO" ).append("\n"); 
		query.append("						,A.DIR_CD AS SKD_DIR_CD*/" ).append("\n"); 
		query.append("					A.RLANE_CD" ).append("\n"); 
		query.append("					, C.CRR_CD AS JO_CRR_CD" ).append("\n"); 
		query.append("					, CASE WHEN C.BSA_OP_JB_CD IN ('000','001')" ).append("\n"); 
		query.append("						THEN '101'" ).append("\n"); 
		query.append("						WHEN C.BSA_OP_JB_CD IN ('002','003')" ).append("\n"); 
		query.append("						THEN '102'" ).append("\n"); 
		query.append("						WHEN C.BSA_OP_JB_CD IN ('004','005')" ).append("\n"); 
		query.append("						THEN '103'" ).append("\n"); 
		query.append("					END AS JO_STL_JB_CD" ).append("\n"); 
		query.append("					, CASE WHEN C.BSA_OP_JB_CD IN ('001','002','004')" ).append("\n"); 
		query.append("						THEN 'R'" ).append("\n"); 
		query.append("						WHEN C.BSA_OP_JB_CD IN ('000','003','005')" ).append("\n"); 
		query.append("						THEN 'E'" ).append("\n"); 
		query.append("					END AS RE_DIVR_CD" ).append("\n"); 
		query.append("					,ROUND(C.SLT_PRC_CAPA, 2) AS BSA_SLT_PRC" ).append("\n"); 
		query.append("					,C.CRR_BSA_CAPA AS BSA_QTY" ).append("\n"); 
		query.append("					,ROUND(C.CRR_PERF_AMT, 2) AS ESTM_AMT" ).append("\n"); 
		query.append("				FROM MAS_MON_VVD A" ).append("\n"); 
		query.append("					,BSA_VVD_MST B" ).append("\n"); 
		query.append("					,BSA_VVD_CRR_PERF C" ).append("\n"); 
		query.append("					,GLVVD D" ).append("\n"); 
		query.append("				WHERE 1= 1 " ).append("\n"); 
		query.append("					AND A.VSL_CD			= B.VSL_CD" ).append("\n"); 
		query.append("					AND A.SKD_VOY_NO		= B.SKD_VOY_NO" ).append("\n"); 
		query.append("					AND A.DIR_CD			= B.SKD_DIR_CD" ).append("\n"); 
		query.append("					AND A.TRD_CD			= B.TRD_CD" ).append("\n"); 
		query.append("					AND A.RLANE_CD			= B.RLANE_CD" ).append("\n"); 
		query.append("					AND A.VSL_CD			= C.VSL_CD" ).append("\n"); 
		query.append("					AND A.SKD_VOY_NO		= C.SKD_VOY_NO" ).append("\n"); 
		query.append("					AND A.DIR_CD			= C.SKD_DIR_CD" ).append("\n"); 
		query.append("					AND A.TRD_CD			= C.TRD_CD" ).append("\n"); 
		query.append("					AND A.RLANE_CD			= C.RLANE_CD" ).append("\n"); 
		query.append("					AND C.BSA_OP_JB_CD IN ('000','001','002','003','004','005')" ).append("\n"); 
		query.append("					AND C.CRR_CD <> 'SML'" ).append("\n"); 
		query.append("					AND A.DELT_FLG			= 'N'" ).append("\n"); 
		query.append("					AND NOT(NVL(C.CRR_BSA_CAPA,0) = 0 AND NVL(C.SLT_PRC_CAPA,0) = 0 )" ).append("\n"); 
		query.append("					AND D.VSL_CD			= B.VSL_CD" ).append("\n"); 
		query.append("					AND D.SKD_VOY_NO		= B.SKD_VOY_NO" ).append("\n"); 
		query.append("					AND D.SKD_DIR_CD		= B.SKD_DIR_CD" ).append("\n"); 
		query.append("					AND D.RLANE_CD			= B.RLANE_CD" ).append("\n"); 
		query.append("					AND D.EXE_YRMON = REPLACE(@[exe_yrmon],'-','')   -- 추가" ).append("\n"); 
		query.append("					AND D.REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr], '-', '') AND REPLACE(@[rev_yrmon_to], '-', '')  -- 추가   FROM ~` tO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				)  B, " ).append("\n"); 
		query.append("			MDM_REV_LANE M" ).append("\n"); 
		query.append("		WHERE 1 = 1" ).append("\n"); 
		query.append("			AND A.REV_YRMON			= B.REV_YRMON (+)" ).append("\n"); 
		query.append("			#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("			AND A.JO_CRR_CD			=  @[jo_crr_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			AND A.JO_CRR_CD			= B.JO_CRR_CD (+)" ).append("\n"); 
		query.append("			#if (${vvd} != '')" ).append("\n"); 
		query.append("			AND A.VVD 				LIKE @[vvd]||'%'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			AND A.VVD				= B.VVD (+)" ).append("\n"); 
		query.append("			#if (${jo_stl_jb_cd} != '')" ).append("\n"); 
		query.append("			AND A.JO_STL_JB_CD 		= @[jo_stl_jb_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			AND A.JO_STL_JB_CD		= B.JO_STL_JB_CD (+)" ).append("\n"); 
		query.append("			#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("			AND A.RLANE_CD  		= @[rlane_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			AND A.RLANE_CD			= B.RLANE_CD (+)" ).append("\n"); 
		query.append("			AND M.RLANE_CD			= A.RLANE_CD	-- Lane" ).append("\n"); 
		query.append("			#if (${trd_cd} != '')" ).append("\n"); 
		query.append("			AND M.REP_TRD_CD    = @[trd_cd]	-- Trade" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			AND DECODE(A.ACCT_CD, '510921', 'E', 'R')  =   B.RE_DIVR_CD  (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT A.EXE_YRMON, A.REV_YRMON, A.JO_CRR_CD, A.VVD, A.RLANE_CD, DECODE(A.JO_STL_JB_CD, '101', 'JOINT OPERATION', '102', 'LEASE', '103', 'ADDITIONAL') JO_STL_JB_CD,  DECODE(A.RE_DIVR_CD, 'R', '411221','510921') ACCT_CD," ).append("\n"); 
		query.append("				B.BSA_QTY ESTM1_BSA_QTY, B.BSA_SLT_PRC ESTM1_BSA_SLT_PRC, ROUND(B.ESTM_AMT, 2) ESTM1_AMT, A.BSA_QTY ESTM2_BSA_QTY, A.BSA_SLT_PRC ESTM2_BSA_SLT_PRC, ROUND(A.ESTM_AMT, 2) ESTM2_AMT, NVL(ROUND(A.ESTM_AMT, 2), 0) - NVL(ROUND(B.ESTM_AMT, 2), 0)  CAL_AMT," ).append("\n"); 
		query.append("			CASE WHEN A.BSA_QTY = B.BSA_QTY AND A.BSA_SLT_PRC <> B.BSA_SLT_PRC THEN 'Price'" ).append("\n"); 
		query.append("				WHEN A.BSA_QTY <> B.BSA_QTY AND A.BSA_SLT_PRC = B.BSA_SLT_PRC THEN 'BSA'" ).append("\n"); 
		query.append("				WHEN A.BSA_QTY <> B.BSA_QTY AND A.BSA_SLT_PRC <> B.BSA_SLT_PRC THEN 'BSA, Price'" ).append("\n"); 
		query.append("				WHEN  NVL(B.BSA_QTY, 0) = 0 THEN 'C, V, BT'" ).append("\n"); 
		query.append("			END CHANGE_ITEM ," ).append("\n"); 
		query.append("			REPLACE(@[exe_yrmon],'-','') JB_EXE_YRMON   -- exe_yrmon" ).append("\n"); 
		query.append("		FROM" ).append("\n"); 
		query.append("			( " ).append("\n"); 
		query.append("				SELECT A.COST_YRMON AS EXE_YRMON, A.COST_YRMON AS REV_YRMON, A.VSL_CD||A.SKD_VOY_NO||A.DIR_CD||D.REV_DIR_CD VVD," ).append("\n"); 
		query.append("					/* ,A.VSL_CD" ).append("\n"); 
		query.append("					,A.SKD_VOY_NO" ).append("\n"); 
		query.append("					,A.DIR_CD AS SKD_DIR_CD*/" ).append("\n"); 
		query.append("					A.RLANE_CD" ).append("\n"); 
		query.append("					, C.CRR_CD AS JO_CRR_CD" ).append("\n"); 
		query.append("					, CASE WHEN C.BSA_OP_JB_CD IN ('000','001')" ).append("\n"); 
		query.append("							THEN '101'" ).append("\n"); 
		query.append("							WHEN C.BSA_OP_JB_CD IN ('002','003')" ).append("\n"); 
		query.append("							THEN '102'" ).append("\n"); 
		query.append("							WHEN C.BSA_OP_JB_CD IN ('004','005')" ).append("\n"); 
		query.append("							THEN '103'" ).append("\n"); 
		query.append("					END AS JO_STL_JB_CD" ).append("\n"); 
		query.append("					, CASE WHEN C.BSA_OP_JB_CD IN ('001','002','004')" ).append("\n"); 
		query.append("							THEN 'R'" ).append("\n"); 
		query.append("							WHEN C.BSA_OP_JB_CD IN ('000','003','005')" ).append("\n"); 
		query.append("							THEN 'E'" ).append("\n"); 
		query.append("					END AS RE_DIVR_CD" ).append("\n"); 
		query.append("					, ROUND(C.SLT_PRC_CAPA, 2) AS BSA_SLT_PRC" ).append("\n"); 
		query.append("					, C.CRR_BSA_CAPA AS BSA_QTY" ).append("\n"); 
		query.append("					, ROUND(C.CRR_PERF_AMT, 2) AS ESTM_AMT" ).append("\n"); 
		query.append("				FROM  MAS_MON_VVD A" ).append("\n"); 
		query.append("					, BSA_VVD_MST B" ).append("\n"); 
		query.append("					, BSA_VVD_CRR_PERF C" ).append("\n"); 
		query.append("					, GLVVD D" ).append("\n"); 
		query.append("				WHERE 1= 1 " ).append("\n"); 
		query.append("					AND A.VSL_CD			= B.VSL_CD" ).append("\n"); 
		query.append("		            AND A.SKD_VOY_NO		= B.SKD_VOY_NO" ).append("\n"); 
		query.append("		            AND A.DIR_CD			= B.SKD_DIR_CD" ).append("\n"); 
		query.append("		            AND A.TRD_CD			= B.TRD_CD" ).append("\n"); 
		query.append("		            AND A.RLANE_CD			= B.RLANE_CD" ).append("\n"); 
		query.append("		            AND A.VSL_CD			= C.VSL_CD" ).append("\n"); 
		query.append("		            AND A.SKD_VOY_NO		= C.SKD_VOY_NO" ).append("\n"); 
		query.append("		            AND A.DIR_CD			= C.SKD_DIR_CD" ).append("\n"); 
		query.append("		            AND A.TRD_CD			= C.TRD_CD" ).append("\n"); 
		query.append("		            AND A.RLANE_CD			= C.RLANE_CD" ).append("\n"); 
		query.append("		            AND C.BSA_OP_JB_CD IN ('000','001','002','003','004','005')" ).append("\n"); 
		query.append("		            AND C.CRR_CD <> 'SML'" ).append("\n"); 
		query.append("		            AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		            AND NOT(NVL(C.CRR_BSA_CAPA,0) = 0 AND NVL(C.SLT_PRC_CAPA,0) = 0 )" ).append("\n"); 
		query.append("		            AND D.VSL_CD			= B.VSL_CD" ).append("\n"); 
		query.append("		            AND D.SKD_VOY_NO		= B.SKD_VOY_NO" ).append("\n"); 
		query.append("		            AND D.SKD_DIR_CD		= B.SKD_DIR_CD" ).append("\n"); 
		query.append("		            AND D.RLANE_CD			= B.RLANE_CD" ).append("\n"); 
		query.append("					AND D.EXE_YRMON = REPLACE(@[exe_yrmon],'-','')   -- 추가" ).append("\n"); 
		query.append("					AND D.REV_YRMON BETWEEN REPLACE(@[rev_yrmon_fr], '-', '') AND REPLACE(@[rev_yrmon_to], '-', '')  -- 추가   FROM ~` tO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			) A" ).append("\n"); 
		query.append("			,(" ).append("\n"); 
		query.append("				SELECT T.EXE_YRMON, T.REV_YRMON, T.JO_CRR_CD, T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD||T.REV_DIR_CD VVD, T.RLANE_CD," ).append("\n"); 
		query.append("						T.ACCT_CD, T.JO_STL_JB_CD, T.BSA_QTY, T.BSA_SLT_PRC, T.ESTM_AMT" ).append("\n"); 
		query.append("				FROM JOO_ESTM_ACT_RSLT T" ).append("\n"); 
		query.append("				WHERE 1 = 1" ).append("\n"); 
		query.append("					AND T.EXE_YRMON	= REPLACE(@[exe_yrmon],'-','')	-- FROM 년월		  -- exe_yrmon" ).append("\n"); 
		query.append("			        AND T.REV_YRMON	BETWEEN REPLACE(@[rev_yrmon_fr], '-', '') AND REPLACE(@[rev_yrmon_to], '-', '') -- 추가   FROM ~` tO" ).append("\n"); 
		query.append("					AND T.ACCT_CD IN ('510921', '411221')	-- Rev/Exp" ).append("\n"); 
		query.append("			) B" ).append("\n"); 
		query.append("			, MDM_REV_LANE M" ).append("\n"); 
		query.append("		WHERE 1 = 1" ).append("\n"); 
		query.append("			--AND A.REV_YRMON		=  B.REV_YRMON (+)" ).append("\n"); 
		query.append("			#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("			AND A.JO_CRR_CD			=  @[jo_crr_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			AND A.JO_CRR_CD			= B.JO_CRR_CD (+)" ).append("\n"); 
		query.append("			#if (${vvd} != '')" ).append("\n"); 
		query.append("			AND A.VVD 				LIKE @[vvd]||'%'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			AND A.VVD				= B.VVD (+)" ).append("\n"); 
		query.append("			#if (${jo_stl_jb_cd} != '')" ).append("\n"); 
		query.append("			AND A.JO_STL_JB_CD 		= @[jo_stl_jb_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			AND A.JO_STL_JB_CD		= B.JO_STL_JB_CD (+)" ).append("\n"); 
		query.append("			#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("			AND A.RLANE_CD  		= @[rlane_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			AND A.RLANE_CD			=  B.RLANE_CD (+)" ).append("\n"); 
		query.append("			AND M.RLANE_CD			=  A.RLANE_CD	-- Lane" ).append("\n"); 
		query.append("			#if (${trd_cd} != '')" ).append("\n"); 
		query.append("			AND M.REP_TRD_CD    = @[trd_cd]	-- Trade" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			AND NVL(B.BSA_QTY  , 0)	= 0" ).append("\n"); 
		query.append("			AND DECODE(A.RE_DIVR_CD, 'R', '411221','510921')  =  B.ACCT_CD (+)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${re_divr_cd} != 'A')" ).append("\n"); 
		query.append("AND ACCT_CD = DECODE(@[re_divr_cd],'R','411221','E','510921')	-- Rev/Exp" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${changed_option} == 'Y')" ).append("\n"); 
		query.append("AND CHANGE_ITEM IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY REV_YRMON ASC, JO_CRR_CD ASC, VVD ASC, RLANE_CD ASC, ACCT_CD ASC" ).append("\n"); 

	}
}