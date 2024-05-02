/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TCharterIOEstimatedDBDAOSearchEstimatedHireResultListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.13
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOEstimatedDBDAOSearchEstimatedHireResultListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharterIOEstimatedDBDAOSearchEstimatedHireResultListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_duration",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration").append("\n"); 
		query.append("FileName : TCharterIOEstimatedDBDAOSearchEstimatedHireResultListVORSQL").append("\n"); 
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
		query.append("SELECT 'I' ibflag," ).append("\n"); 
		query.append("@[to_duration] EXE_YRMON, A.REV_YRMON, A.REV_YRMON||A.FLET_CTRT_TP_CD SUBSUMCOL," ).append("\n"); 
		query.append("A.FLET_CTRT_NO, A.FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("A.RLANE_CD, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD," ).append("\n"); 
		query.append("A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD," ).append("\n"); 
		query.append("A.VST_DT, A.VED_DT," ).append("\n"); 
		query.append("B.HIRE_AMT," ).append("\n"); 
		query.append("B.EST_AMT," ).append("\n"); 
		query.append("NVL(C.ACT_AMT,0)+NVL(D.AMOUNT,0) ACT_AMT," ).append("\n"); 
		query.append("TO_CHAR(C.SLP_EXP_DT,'YYYYMMDD') SLP_EXP_DT, TO_CHAR(C.SLP_EFF_DT,'YYYYMMDD') SLP_EFF_DT," ).append("\n"); 
		query.append("C.EFF_DT," ).append("\n"); 
		query.append("DECODE(B.HIRE_EXP_DT-B.HIRE_EFF_DT, C.SLP_EXP_DT-C.SLP_EFF_DT, 0," ).append("\n"); 
		query.append("DECODE(NVL(C.ACT_AMT,0)+NVL(D.AMOUNT,0), 0,B.EST_AMT," ).append("\n"); 
		query.append("FMS_GET_ACCRUAL_FNC(A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD,A.REV_YRMON,A.VST_DT, A.VED_DT,A.FLET_CTRT_NO," ).append("\n"); 
		query.append("B.HIRE_AMT,B.EST_AMT,C.ACT_AMT+NVL(D.AMOUNT,0),(B.HIRE_EXP_DT-B.HIRE_EFF_DT)-(C.SLP_EXP_DT-C.SLP_EFF_DT),@[fr_duration],@[to_duration]))) ACC_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT DISTINCT A.REV_YRMON," ).append("\n"); 
		query.append("B.FLET_CTRT_NO, B.FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("A.RLANE_CD, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD," ).append("\n"); 
		query.append("A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD," ).append("\n"); 
		query.append("A.VST_DT, A.VED_DT" ).append("\n"); 
		query.append("FROM 	FMS_VVD A," ).append("\n"); 
		query.append("(SELECT VSL_CD, FLET_CTRT_NO, FLET_CTRT_TP_CD FROM FMS_CONTRACT" ).append("\n"); 
		query.append("WHERE FLET_CTRT_TP_CD = 'TI' AND FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%' AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT FI.VSL_CD, FC.FLET_CTRT_NO, FLET_CTRT_TP_CD FROM FMS_CONTRACT FC, FMS_ID_VSL FI" ).append("\n"); 
		query.append("WHERE FC.FLET_CTRT_NO = FI.FLET_CTRT_NO AND FC.FLET_CTRT_TP_CD = 'TI' AND FC.FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%' AND FC.FLET_CTRT_FACT_CD = 'ACT') B" ).append("\n"); 
		query.append("WHERE 	A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND 	A.REV_YRMON BETWEEN @[fr_duration] AND @[to_duration]" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, REV_YRMON," ).append("\n"); 
		query.append("FLET_CTRT_NO,  MIN(HIRE_EFF_DT) HIRE_EFF_DT,MAX(HIRE_EXP_DT) HIRE_EXP_DT," ).append("\n"); 
		query.append("MIN(HIRE_N1ST_AMT + HIRE_N2ND_AMT) HIRE_AMT," ).append("\n"); 
		query.append("SUM(DAYS*(HIRE_N1ST_AMT + HIRE_N2ND_AMT)) EST_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.REV_YRMON, A.FLET_CTRT_NO, A.HIRE_EFF_DT," ).append("\n"); 
		query.append("CASE WHEN A.RN = 1 AND A.CNT > 1 THEN A.HIRE_EXP_DT -1 ELSE A.HIRE_EXP_DT END AS HIRE_EXP_DT," ).append("\n"); 
		query.append("CASE WHEN A.RN = 1 AND A.CNT > 1 THEN A.HIRE_EXP_DT -1 ELSE A.HIRE_EXP_DT END - A.HIRE_EFF_DT + 1 AS DAYS," ).append("\n"); 
		query.append("A.HIRE_N1ST_AMT, A.HIRE_N2ND_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.REV_YRMON," ).append("\n"); 
		query.append("C.FLET_CTRT_NO," ).append("\n"); 
		query.append("CASE WHEN A.VST_DT >= TO_CHAR(C.EFF_DT,'YYYYMMDD') THEN TO_DATE(A.VST_DT, 'YYYYMMDD') ELSE TRUNC(C.EFF_DT) END HIRE_EFF_DT," ).append("\n"); 
		query.append("CASE WHEN A.VED_DT > TO_CHAR(C.EXP_DT,'YYYYMMDD') THEN TRUNC(C.EXP_DT)-1 ELSE TO_DATE(A.VED_DT, 'YYYYMMDD') END HIRE_EXP_DT," ).append("\n"); 
		query.append("ROW_NUMBER() OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.REV_YRMON, C.FLET_CTRT_NO, CASE WHEN A.VED_DT > TO_CHAR(C.EXP_DT,'YYYYMMDD') THEN TRUNC(C.EXP_DT)-1 ELSE TO_DATE(A.VED_DT, 'YYYYMMDD') END ORDER BY CASE WHEN A.VST_DT >= TO_CHAR(C.EFF_DT,'YYYYMMDD') THEN TO_DATE(A.VST_DT, 'YYYYMMDD') ELSE TRUNC(C.EFF_DT) END) AS RN," ).append("\n"); 
		query.append("COUNT(1) OVER(PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.REV_YRMON, C.FLET_CTRT_NO, CASE WHEN A.VED_DT > TO_CHAR(C.EXP_DT,'YYYYMMDD') THEN TRUNC(C.EXP_DT)-1 ELSE TO_DATE(A.VED_DT, 'YYYYMMDD') END) AS CNT," ).append("\n"); 
		query.append("CASE WHEN SUBSTR(TO_CHAR(FIRST_VALUE(C.EXP_DT) OVER(PARTITION BY C.FLET_CTRT_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD ORDER BY C.EXP_DT),'YYYYMMDDHH24MISS'),9,4) = '0000' AND C.HIR_CURR_N2ND_CD IS NULL THEN" ).append("\n"); 
		query.append("NVL(C.HIR_RT_N1ST_AMT/DECODE(C.HIR_CURR_N1ST_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE C.HIR_CURR_N1ST_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3')),0)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("FIRST_VALUE(NVL(C.HIR_RT_N1ST_AMT/DECODE(C.HIR_CURR_N1ST_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE C.HIR_CURR_N1ST_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3')),0))" ).append("\n"); 
		query.append("OVER(PARTITION BY C.FLET_CTRT_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, C.EXP_DT ORDER BY C.EXP_DT DESC)" ).append("\n"); 
		query.append("END HIRE_N1ST_AMT," ).append("\n"); 
		query.append("CASE WHEN SUBSTR(TO_CHAR(FIRST_VALUE(C.EXP_DT) OVER(PARTITION BY C.FLET_CTRT_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD ORDER BY C.EXP_DT),'YYYYMMDDHH24MISS'),9,4) = '0000' AND C.HIR_CURR_N2ND_CD IS NULL THEN" ).append("\n"); 
		query.append("NVL(C.HIR_RT_N2ND_AMT/DECODE(C.HIR_CURR_N2ND_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE C.HIR_CURR_N2ND_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3')),0)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("FIRST_VALUE(NVL(C.HIR_RT_N2ND_AMT/DECODE(C.HIR_CURR_N2ND_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE C.HIR_CURR_N2ND_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3')),0))" ).append("\n"); 
		query.append("OVER(PARTITION BY C.FLET_CTRT_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, C.EXP_DT ORDER BY C.EXP_DT DESC)" ).append("\n"); 
		query.append("END HIRE_N2ND_AMT" ).append("\n"); 
		query.append("FROM 	FMS_VVD A, (SELECT VSL_CD, FLET_CTRT_NO, FLET_CTRT_TP_CD FROM FMS_CONTRACT" ).append("\n"); 
		query.append("WHERE FLET_CTRT_TP_CD = 'TI' AND FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%' AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT FI.VSL_CD, FC.FLET_CTRT_NO, FLET_CTRT_TP_CD FROM FMS_CONTRACT FC, FMS_ID_VSL FI" ).append("\n"); 
		query.append("WHERE FC.FLET_CTRT_NO = FI.FLET_CTRT_NO AND FC.FLET_CTRT_TP_CD = 'TI' AND FC.FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%' AND FC.FLET_CTRT_FACT_CD = 'ACT') B," ).append("\n"); 
		query.append("FMS_HIRE C" ).append("\n"); 
		query.append("WHERE 	A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND 	B.FLET_CTRT_NO = C.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND 	A.VST_DT <= TO_CHAR(C.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("AND 	A.VED_DT >= TO_CHAR(C.EFF_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("AND 	A.REV_YRMON BETWEEN @[fr_duration] AND @[to_duration]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, REV_YRMON, FLET_CTRT_NO" ).append("\n"); 
		query.append(") B," ).append("\n"); 
		query.append("(SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.REV_YRMON," ).append("\n"); 
		query.append("B.FLET_CTRT_NO," ).append("\n"); 
		query.append("SUM(FS.CSR_AMT/DECODE(FS.CSR_CURR_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1)" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE FS.CSR_CURR_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON =  SUBSTR(FC.EFF_DT,1,6)  AND EX1.ACCT_XCH_RT_LVL = '3'))) ACT_AMT," ).append("\n"); 
		query.append("MIN(FS.VVD_EFF_DT) SLP_EFF_DT, MAX(FS.VVD_EXP_DT) SLP_EXP_DT, MAX(FC.EFF_DT) EFF_DT" ).append("\n"); 
		query.append("FROM FMS_VVD A, (SELECT VSL_CD, FLET_CTRT_NO" ).append("\n"); 
		query.append("FROM FMS_CONTRACT" ).append("\n"); 
		query.append("WHERE FLET_CTRT_TP_CD = 'TI'" ).append("\n"); 
		query.append("AND FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%'" ).append("\n"); 
		query.append("AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT FI.VSL_CD, FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("FROM FMS_CONTRACT FC, FMS_ID_VSL FI" ).append("\n"); 
		query.append("WHERE FC.FLET_CTRT_NO = FI.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_TP_CD = 'TI'" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%'" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_FACT_CD = 'ACT') B," ).append("\n"); 
		query.append("FMS_CONSULTATION FC, FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("WHERE 	A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND 	B.FLET_CTRT_NO = FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND 	A.VST_DT <= TO_CHAR(FS.VVD_EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("AND 	A.VED_DT >= TO_CHAR(FS.VVD_EFF_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("AND 	A.REV_YRMON BETWEEN @[fr_duration] AND @[to_duration]" ).append("\n"); 
		query.append("AND 	FC.SLP_TP_CD = FS.SLP_TP_CD" ).append("\n"); 
		query.append("AND 	FC.SLP_FUNC_CD = FS.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND 	FC.SLP_OFC_CD = FS.SLP_OFC_CD" ).append("\n"); 
		query.append("AND 	FC.SLP_ISS_DT = FS.SLP_ISS_DT" ).append("\n"); 
		query.append("AND 	FC.SLP_SER_NO = FS.SLP_SER_NO" ).append("\n"); 
		query.append("AND 	A.VSL_CD = FS.VSL_CD" ).append("\n"); 
		query.append("AND 	A.SKD_VOY_NO = FS.SKD_VOY_NO" ).append("\n"); 
		query.append("AND 	A.SKD_DIR_CD = FS.SKD_DIR_CD" ).append("\n"); 
		query.append("AND 	A.REV_DIR_CD = FS.REV_DIR_CD" ).append("\n"); 
		query.append("AND 	FS.ACCT_CD = '510911'" ).append("\n"); 
		query.append("AND 	FC.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("AND   FC.CXL_FLG = 'N'" ).append("\n"); 
		query.append("AND   SUBSTR(FC.EFF_DT,1,6) BETWEEN @[fr_duration] AND @[to_duration]" ).append("\n"); 
		query.append("AND 	NVL(FS.FLET_SRC_TP_CD,'%') LIKE DECODE(FS.SLP_FUNC_CD,'P','99','%')" ).append("\n"); 
		query.append("GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.REV_YRMON, B.FLET_CTRT_NO) C," ).append("\n"); 
		query.append("(SELECT VSL_CD,SKD_VOY_NO,SKD_DIR_CD,REV_DIR_CD, SUM(CSR_AMT) AMOUNT" ).append("\n"); 
		query.append("FROM FMS_ESTM_IF" ).append("\n"); 
		query.append("WHERE ACCT_CD = '510911'" ).append("\n"); 
		query.append("GROUP BY VSL_CD,SKD_VOY_NO,SKD_DIR_CD,REV_DIR_CD) D" ).append("\n"); 
		query.append("WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.REV_DIR_CD = B.REV_DIR_CD" ).append("\n"); 
		query.append("AND A.REV_YRMON = B.REV_YRMON" ).append("\n"); 
		query.append("AND A.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND A.VSL_CD = C.VSL_CD(+)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND A.REV_DIR_CD = C.REV_DIR_CD(+)" ).append("\n"); 
		query.append("AND A.REV_YRMON = C.REV_YRMON(+)" ).append("\n"); 
		query.append("AND A.FLET_CTRT_NO = C.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("AND A.VSL_CD = D.VSL_CD(+)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND A.REV_DIR_CD = D.REV_DIR_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'I' ibflag," ).append("\n"); 
		query.append("@[to_duration] EXE_YRMON, A.REV_YRMON, A.REV_YRMON||A.FLET_CTRT_TP_CD SUBSUMCOL," ).append("\n"); 
		query.append("A.FLET_CTRT_NO, A.FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("A.RLANE_CD, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD," ).append("\n"); 
		query.append("A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD," ).append("\n"); 
		query.append("A.VST_DT, A.VED_DT," ).append("\n"); 
		query.append("B.HIRE_AMT," ).append("\n"); 
		query.append("(C.ACT_APPR_YAMT + C.ACT_APPR_NAMT) EST_AMT," ).append("\n"); 
		query.append("(C.ACT_APPR_YAMT) ACT_AMT," ).append("\n"); 
		query.append("TO_CHAR(C.SLP_EXP_DT,'YYYYMMDD') SLP_EXP_DT,TO_CHAR(C.SLP_EFF_DT,'YYYYMMDD') SLP_EFF_DT," ).append("\n"); 
		query.append("C.EFF_DT," ).append("\n"); 
		query.append("(C.ACT_APPR_NAMT) ACC_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT DISTINCT A.REV_YRMON," ).append("\n"); 
		query.append("B.FLET_CTRT_NO, B.FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("A.RLANE_CD, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD," ).append("\n"); 
		query.append("A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD," ).append("\n"); 
		query.append("A.VST_DT, A.VED_DT" ).append("\n"); 
		query.append("FROM FMS_VVD A," ).append("\n"); 
		query.append("(SELECT VSL_CD, FLET_CTRT_NO, FLET_CTRT_TP_CD FROM FMS_CONTRACT" ).append("\n"); 
		query.append("WHERE FLET_CTRT_TP_CD = 'TO' AND FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%' AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT FI.VSL_CD, FC.FLET_CTRT_NO, FLET_CTRT_TP_CD FROM FMS_CONTRACT FC, FMS_ID_VSL FI" ).append("\n"); 
		query.append("WHERE FC.FLET_CTRT_NO = FI.FLET_CTRT_NO AND FC.FLET_CTRT_TP_CD = 'TO' AND FC.FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%' AND FC.FLET_CTRT_FACT_CD = 'ACT') B" ).append("\n"); 
		query.append("WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.REV_YRMON BETWEEN @[fr_duration] AND @[to_duration]" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, REV_YRMON," ).append("\n"); 
		query.append("FLET_CTRT_NO," ).append("\n"); 
		query.append("MIN(HIRE_N1ST_AMT + HIRE_N2ND_AMT) HIRE_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.REV_YRMON," ).append("\n"); 
		query.append("C.FLET_CTRT_NO," ).append("\n"); 
		query.append("NVL(C.HIR_RT_N1ST_AMT/DECODE(C.HIR_CURR_N1ST_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE C.HIR_CURR_N1ST_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3')),0) HIRE_N1ST_AMT," ).append("\n"); 
		query.append("NVL(C.HIR_RT_N2ND_AMT/DECODE(C.HIR_CURR_N2ND_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE C.HIR_CURR_N2ND_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3')),0) HIRE_N2ND_AMT" ).append("\n"); 
		query.append("FROM 	FMS_VVD A, (SELECT VSL_CD, FLET_CTRT_NO, FLET_CTRT_TP_CD FROM FMS_CONTRACT" ).append("\n"); 
		query.append("WHERE FLET_CTRT_TP_CD = 'TO' AND FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%' AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT FI.VSL_CD, FC.FLET_CTRT_NO, FLET_CTRT_TP_CD FROM FMS_CONTRACT FC, FMS_ID_VSL FI" ).append("\n"); 
		query.append("WHERE FC.FLET_CTRT_NO = FI.FLET_CTRT_NO AND FC.FLET_CTRT_TP_CD = 'TO' AND FC.FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%' AND FC.FLET_CTRT_FACT_CD = 'ACT') B," ).append("\n"); 
		query.append("FMS_HIRE C" ).append("\n"); 
		query.append("WHERE 	A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND 	B.FLET_CTRT_NO = C.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND A.VST_DT <= TO_CHAR(C.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("AND A.VED_DT >= TO_CHAR(C.EFF_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("AND A.REV_YRMON BETWEEN @[fr_duration] AND @[to_duration])" ).append("\n"); 
		query.append("GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, REV_YRMON," ).append("\n"); 
		query.append("FLET_CTRT_NO" ).append("\n"); 
		query.append(") B," ).append("\n"); 
		query.append("(SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.REV_YRMON," ).append("\n"); 
		query.append("B.FLET_CTRT_NO," ).append("\n"); 
		query.append("SUM(DECODE(FC.APRO_FLG,'Y',FS.INV_AMT,0)/DECODE(FS.CURR_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE FS.CURR_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3'))) ACT_APPR_YAMT," ).append("\n"); 
		query.append("SUM(DECODE(FC.APRO_FLG,'N',FS.INV_AMT,0)/DECODE(FS.CURR_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE FS.CURR_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3'))) ACT_APPR_NAMT," ).append("\n"); 
		query.append("MIN(FS.EFF_DT) SLP_EFF_DT, MAX(FS.EXP_DT) SLP_EXP_DT," ).append("\n"); 
		query.append("MAX(FC.EFF_DT) EFF_DT" ).append("\n"); 
		query.append("FROM FMS_VVD A, (SELECT VSL_CD, FLET_CTRT_NO FROM FMS_CONTRACT" ).append("\n"); 
		query.append("WHERE FLET_CTRT_TP_CD = 'TO' AND FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%' AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT FI.VSL_CD, FC.FLET_CTRT_NO FROM FMS_CONTRACT FC, FMS_ID_VSL FI" ).append("\n"); 
		query.append("WHERE FC.FLET_CTRT_NO = FI.FLET_CTRT_NO AND FC.FLET_CTRT_TP_CD = 'TO' AND FC.FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%' AND FC.FLET_CTRT_FACT_CD = 'ACT') B," ).append("\n"); 
		query.append("FMS_CONSULTATION FC, FMS_INV_DTL FS" ).append("\n"); 
		query.append("WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND B.FLET_CTRT_NO = FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND A.VST_DT <= TO_CHAR(FS.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("AND A.VED_DT >= TO_CHAR(FS.EFF_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("AND A.REV_YRMON BETWEEN @[fr_duration] AND @[to_duration]" ).append("\n"); 
		query.append("AND FC.SLP_TP_CD = FS.SLP_TP_CD" ).append("\n"); 
		query.append("AND FC.SLP_FUNC_CD = FS.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND FC.SLP_OFC_CD = FS.SLP_OFC_CD" ).append("\n"); 
		query.append("AND FC.SLP_ISS_DT = FS.SLP_ISS_DT" ).append("\n"); 
		query.append("AND FC.SLP_SER_NO = FS.SLP_SER_NO" ).append("\n"); 
		query.append("AND A.VSL_CD = FS.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = FS.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = FS.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.REV_DIR_CD = FS.REV_DIR_CD" ).append("\n"); 
		query.append("AND FS.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("AND FS.ACCT_CD = '510911'" ).append("\n"); 
		query.append("GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.REV_YRMON, B.FLET_CTRT_NO) C" ).append("\n"); 
		query.append("WHERE 	A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND 	A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND 	A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND 	A.REV_DIR_CD = B.REV_DIR_CD" ).append("\n"); 
		query.append("AND 	A.REV_YRMON = B.REV_YRMON" ).append("\n"); 
		query.append("AND 	A.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND 	A.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("AND 	A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("AND 	A.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("AND 	A.REV_DIR_CD = C.REV_DIR_CD" ).append("\n"); 
		query.append("AND 	A.REV_YRMON = C.REV_YRMON" ).append("\n"); 
		query.append("AND 	A.FLET_CTRT_NO = C.FLET_CTRT_NO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'I' ibflag," ).append("\n"); 
		query.append("@[to_duration] EXE_YRMON, A.REV_YRMON, A.REV_YRMON||A.FLET_CTRT_TP_CD SUBSUMCOL," ).append("\n"); 
		query.append("A.FLET_CTRT_NO, A.FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("A.RLANE_CD, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD," ).append("\n"); 
		query.append("A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD," ).append("\n"); 
		query.append("A.VST_DT, A.VED_DT," ).append("\n"); 
		query.append("B.HIRE_AMT," ).append("\n"); 
		query.append("-1*(C.ACT_APPR_YAMT + C.ACT_APPR_NAMT) EST_AMT," ).append("\n"); 
		query.append("-1*(D.ACT_AMT) ACT_AMT," ).append("\n"); 
		query.append("TO_CHAR(C.SLP_EXP_DT,'YYYYMMDD') SLP_EXP_DT,TO_CHAR(C.SLP_EFF_DT,'YYYYMMDD') SLP_EFF_DT," ).append("\n"); 
		query.append("C.EFF_DT," ).append("\n"); 
		query.append("-1*(C.ACT_APPR_NAMT) ACC_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT DISTINCT A.REV_YRMON," ).append("\n"); 
		query.append("B.FLET_CTRT_NO, B.FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("A.RLANE_CD, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD," ).append("\n"); 
		query.append("A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD," ).append("\n"); 
		query.append("A.VST_DT, A.VED_DT" ).append("\n"); 
		query.append("FROM FMS_VVD A," ).append("\n"); 
		query.append("(SELECT VSL_CD, FLET_CTRT_NO, FLET_CTRT_TP_CD FROM FMS_CONTRACT" ).append("\n"); 
		query.append("WHERE FLET_CTRT_TP_CD <> 'OW' AND FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%' AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT FI.VSL_CD, FC.FLET_CTRT_NO, FLET_CTRT_TP_CD FROM FMS_CONTRACT FC, FMS_ID_VSL FI" ).append("\n"); 
		query.append("WHERE FC.FLET_CTRT_NO = FI.FLET_CTRT_NO AND FC.FLET_CTRT_TP_CD <> 'OW' AND FC.FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%' AND FC.FLET_CTRT_FACT_CD = 'ACT') B" ).append("\n"); 
		query.append("WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.REV_YRMON BETWEEN @[fr_duration] AND @[to_duration]" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, REV_YRMON," ).append("\n"); 
		query.append("FLET_CTRT_NO," ).append("\n"); 
		query.append("MIN(HIRE_N1ST_AMT + HIRE_N2ND_AMT) HIRE_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.REV_YRMON," ).append("\n"); 
		query.append("C.FLET_CTRT_NO," ).append("\n"); 
		query.append("CASE WHEN SUBSTR(TO_CHAR(FIRST_VALUE(C.EXP_DT) OVER(PARTITION BY C.FLET_CTRT_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD ORDER BY C.EXP_DT),'YYYYMMDDHH24MISS'),9,4) = '0000' AND C.HIR_CURR_N2ND_CD IS NULL THEN" ).append("\n"); 
		query.append("NVL(C.HIR_RT_N1ST_AMT/DECODE(C.HIR_CURR_N1ST_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE C.HIR_CURR_N1ST_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3')),0)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("FIRST_VALUE(NVL(C.HIR_RT_N1ST_AMT/DECODE(C.HIR_CURR_N1ST_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE C.HIR_CURR_N1ST_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3')),0))" ).append("\n"); 
		query.append("OVER(PARTITION BY C.FLET_CTRT_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, C.EXP_DT ORDER BY C.EXP_DT DESC)" ).append("\n"); 
		query.append("END HIRE_N1ST_AMT," ).append("\n"); 
		query.append("CASE WHEN SUBSTR(TO_CHAR(FIRST_VALUE(C.EXP_DT) OVER(PARTITION BY C.FLET_CTRT_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD ORDER BY C.EXP_DT),'YYYYMMDDHH24MISS'),9,4) = '0000' AND C.HIR_CURR_N2ND_CD IS NULL THEN" ).append("\n"); 
		query.append("NVL(C.HIR_RT_N2ND_AMT/DECODE(C.HIR_CURR_N2ND_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE C.HIR_CURR_N2ND_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3')),0)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("FIRST_VALUE(NVL(C.HIR_RT_N2ND_AMT/DECODE(C.HIR_CURR_N2ND_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE C.HIR_CURR_N2ND_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3')),0))" ).append("\n"); 
		query.append("OVER(PARTITION BY C.FLET_CTRT_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, C.EXP_DT ORDER BY C.EXP_DT DESC)" ).append("\n"); 
		query.append("END HIRE_N2ND_AMT" ).append("\n"); 
		query.append("FROM 	FMS_VVD A, (SELECT VSL_CD, FLET_CTRT_NO, FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("FROM FMS_CONTRACT" ).append("\n"); 
		query.append("WHERE FLET_CTRT_TP_CD <> 'OW'" ).append("\n"); 
		query.append("AND FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%'" ).append("\n"); 
		query.append("AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT FI.VSL_CD, FC.FLET_CTRT_NO, FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("FROM FMS_CONTRACT FC, FMS_ID_VSL FI" ).append("\n"); 
		query.append("WHERE FC.FLET_CTRT_NO = FI.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_TP_CD <> 'OW'" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%'" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_FACT_CD = 'ACT') B," ).append("\n"); 
		query.append("FMS_HIRE C" ).append("\n"); 
		query.append("WHERE 	A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND 	B.FLET_CTRT_NO = C.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND   A.VST_DT <= TO_CHAR(C.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("AND   A.VED_DT >= TO_CHAR(C.EFF_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("AND   A.REV_YRMON BETWEEN @[fr_duration] AND @[to_duration])" ).append("\n"); 
		query.append("GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, REV_YRMON, FLET_CTRT_NO" ).append("\n"); 
		query.append(") B," ).append("\n"); 
		query.append("(SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.REV_YRMON,fc.slp_tp_cd||fc.slp_func_cd||fc.slp_ofc_cd||fc.slp_iss_dt||fc.slp_ser_no CSR_NO," ).append("\n"); 
		query.append("B.FLET_CTRT_NO, FC.EFF_DT,FS.EFF_DT SLP_EFF_DT, FS.EXP_DT SLP_EXP_DT,FS.EFF_DT EFF_DT2, FS.EXP_DT EXP_DT," ).append("\n"); 
		query.append("DECODE(FC.APRO_FLG,'Y',FS.INV_AMT,0)/DECODE(FS.CURR_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE FS.CURR_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3')) ACT_APPR_YAMT," ).append("\n"); 
		query.append("DECODE(FC.APRO_FLG,'Y',0,FS.INV_AMT)/DECODE(FS.CURR_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE FS.CURR_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3')) ACT_APPR_NAMT" ).append("\n"); 
		query.append("FROM 	FMS_VVD A, (SELECT VSL_CD, FLET_CTRT_NO" ).append("\n"); 
		query.append("FROM FMS_CONTRACT" ).append("\n"); 
		query.append("WHERE FLET_CTRT_TP_CD <> 'OW'" ).append("\n"); 
		query.append("AND FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%'" ).append("\n"); 
		query.append("AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT FI.VSL_CD, FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("FROM FMS_CONTRACT FC, FMS_ID_VSL FI" ).append("\n"); 
		query.append("WHERE FC.FLET_CTRT_NO = FI.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_TP_CD <> 'OW'" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%'" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_FACT_CD = 'ACT') B," ).append("\n"); 
		query.append("FMS_CONSULTATION FC, FMS_INV_DTL FS" ).append("\n"); 
		query.append("WHERE 	A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND 	B.FLET_CTRT_NO = FS.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND 	A.VST_DT <= TO_CHAR(FS.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("AND 	A.VED_DT >= TO_CHAR(FS.EFF_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("AND 	A.REV_YRMON BETWEEN @[fr_duration] AND @[to_duration]" ).append("\n"); 
		query.append("AND 	FC.SLP_TP_CD(+) = FS.SLP_TP_CD" ).append("\n"); 
		query.append("AND 	FC.SLP_FUNC_CD(+) = FS.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND 	FC.SLP_OFC_CD(+) = FS.SLP_OFC_CD" ).append("\n"); 
		query.append("AND 	FC.SLP_ISS_DT(+) = FS.SLP_ISS_DT" ).append("\n"); 
		query.append("AND 	FC.SLP_SER_NO(+) = FS.SLP_SER_NO" ).append("\n"); 
		query.append("AND 	A.VSL_CD = FS.VSL_CD" ).append("\n"); 
		query.append("AND 	A.SKD_VOY_NO = FS.SKD_VOY_NO" ).append("\n"); 
		query.append("AND 	A.SKD_DIR_CD = FS.SKD_DIR_CD" ).append("\n"); 
		query.append("AND 	A.REV_DIR_CD = FS.REV_DIR_CD" ).append("\n"); 
		query.append("AND 	FLET_ISS_TP_CD = 'OFF'" ).append("\n"); 
		query.append("AND 	FC.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("AND   FC.CXL_FLG = 'N'" ).append("\n"); 
		query.append("AND   SUBSTR(FC.EFF_DT,1,6) BETWEEN @[fr_duration] AND @[to_duration]" ).append("\n"); 
		query.append("AND 	FS.ACCT_CD = '510911'   ) C," ).append("\n"); 
		query.append("(SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.REV_YRMON, fc.slp_tp_cd||fc.slp_func_cd||fc.slp_ofc_cd||fc.slp_iss_dt||fc.slp_ser_no CSR_NO," ).append("\n"); 
		query.append("B.FLET_CTRT_NO, FS.VVD_EFF_DT, FS.VVD_EXP_DT," ).append("\n"); 
		query.append("DECODE(FC.APRO_FLG,'Y',FS.CSR_AMT,0)/DECODE(FS.CSR_CURR_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE FS.CSR_CURR_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = SUBSTR(FC.EFF_DT,1,6) AND EX1.ACCT_XCH_RT_LVL = '3')) ACT_AMT" ).append("\n"); 
		query.append("FROM   FMS_VVD A, (SELECT VSL_CD, FLET_CTRT_NO" ).append("\n"); 
		query.append("FROM FMS_CONTRACT" ).append("\n"); 
		query.append("WHERE FLET_CTRT_TP_CD <> 'OW'" ).append("\n"); 
		query.append("AND FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%'" ).append("\n"); 
		query.append("AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT FI.VSL_CD, FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("FROM FMS_CONTRACT FC, FMS_ID_VSL FI" ).append("\n"); 
		query.append("WHERE FC.FLET_CTRT_NO = FI.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_TP_CD <> 'OW'" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_TP_CD LIKE @[flet_ctrt_tp_cd]||'%'" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_FACT_CD = 'ACT') B," ).append("\n"); 
		query.append("FMS_CONSULTATION FC, FMS_CSUL_SLP FS" ).append("\n"); 
		query.append("WHERE 	A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND 	B.FLET_CTRT_NO = FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND 	A.VST_DT <= TO_CHAR(FS.VVD_EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("AND 	A.VED_DT >= TO_CHAR(FS.VVD_EFF_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("AND 	A.REV_YRMON BETWEEN @[fr_duration] AND @[to_duration]" ).append("\n"); 
		query.append("AND 	FC.SLP_TP_CD = FS.SLP_TP_CD" ).append("\n"); 
		query.append("AND 	FC.SLP_FUNC_CD = FS.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND 	FC.SLP_OFC_CD = FS.SLP_OFC_CD" ).append("\n"); 
		query.append("AND 	FC.SLP_ISS_DT = FS.SLP_ISS_DT" ).append("\n"); 
		query.append("AND 	FC.SLP_SER_NO = FS.SLP_SER_NO" ).append("\n"); 
		query.append("AND 	A.VSL_CD = FS.VSL_CD" ).append("\n"); 
		query.append("AND 	A.SKD_VOY_NO = FS.SKD_VOY_NO" ).append("\n"); 
		query.append("AND 	A.SKD_DIR_CD = FS.SKD_DIR_CD" ).append("\n"); 
		query.append("AND 	A.REV_DIR_CD = FS.REV_DIR_CD" ).append("\n"); 
		query.append("AND 	FS.SLP_FUNC_CD = 'P'" ).append("\n"); 
		query.append("AND 	FC.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("AND   FC.CXL_FLG = 'N'" ).append("\n"); 
		query.append("AND   SUBSTR(FC.EFF_DT,1,6) BETWEEN @[fr_duration] AND @[to_duration]" ).append("\n"); 
		query.append("AND 	FS.ACCT_CD = '510911') D" ).append("\n"); 
		query.append("WHERE 	A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND 	A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND 	A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND 	A.REV_DIR_CD = B.REV_DIR_CD" ).append("\n"); 
		query.append("AND 	A.REV_YRMON = B.REV_YRMON" ).append("\n"); 
		query.append("AND 	A.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND 	A.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("AND 	A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("AND 	A.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("AND 	A.REV_DIR_CD = C.REV_DIR_CD" ).append("\n"); 
		query.append("AND 	A.REV_YRMON = C.REV_YRMON" ).append("\n"); 
		query.append("AND 	A.FLET_CTRT_NO = C.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND 	C.VSL_CD = D.VSL_CD(+)" ).append("\n"); 
		query.append("AND 	C.SKD_VOY_NO = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND 	C.SKD_DIR_CD = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND 	C.REV_DIR_CD = D.REV_DIR_CD(+)" ).append("\n"); 
		query.append("AND 	C.REV_YRMON = D.REV_YRMON(+)" ).append("\n"); 
		query.append("AND 	C.FLET_CTRT_NO = D.FLET_CTRT_NO(+)" ).append("\n"); 
		query.append("AND   TO_CHAR(C.EFF_DT2, 'YYYYMMDD') = TO_CHAR(D.VVD_EFF_DT(+), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND   TO_CHAR(C.EXP_DT, 'YYYYMMDD') = TO_CHAR(D.VVD_EXP_DT(+), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND   C.CSR_NO  = D.CSR_NO(+)" ).append("\n"); 
		query.append("ORDER BY REV_YRMON, FLET_CTRT_TP_CD" ).append("\n"); 

	}
}