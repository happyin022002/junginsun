/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TCharteIOContractDAOSearchContractByPrepaymentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharteIOContractDAOSearchContractByPrepaymentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharteIOContractDAOSearchContractByPrepaymentRSQL
	  * </pre>
	  */
	public TCharteIOContractDAOSearchContractByPrepaymentRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharteIOContractDAOSearchContractByPrepaymentRSQL").append("\n"); 
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
		query.append("SELECT	FLET_CTRT_NO," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("VSL_ENG_NM," ).append("\n"); 
		query.append("FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("CUST_CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("OWNR_NM," ).append("\n"); 
		query.append("EFF_DT," ).append("\n"); 
		query.append("FROM_TIME," ).append("\n"); 
		query.append("CASE WHEN SIGN(HIRE_MAX_EXP_DT  - TO_DATE(REPLACE(EXP_DT,'-',''),'YYYYMMDDHH24MI')) > -1 THEN" ).append("\n"); 
		query.append("EXP_DT" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("TO_CHAR(HIRE_MAX_EXP_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("END EXP_DT," ).append("\n"); 
		query.append("TO_TIME," ).append("\n"); 
		query.append("CASE WHEN SIGN(HIRE_MAX_EXP_DT  - TO_DATE(REPLACE(EXP_DT,'-',''),'YYYYMMDDHH24MI')) > -1 THEN" ).append("\n"); 
		query.append("DECODE(EXP_DT,NULL,NULL,TO_CHAR(ROUND(TO_DATE(REPLACE(EXP_DT,'-','') || REPLACE(TO_TIME,':',''),'YYYYMMDDHH24MI') - TO_DATE(REPLACE(EFF_DT,'-','') || REPLACE(FROM_TIME,':',''),'YYYYMMDDHH24MI'),4),'FM999,999.0000'))" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("TO_CHAR(ROUND(HIRE_MAX_EXP_DT - TO_DATE(REPLACE(EFF_DT,'-','') || REPLACE(FROM_TIME,':',''),'YYYYMMDDHH24MI'),4),'FM999,999.0000')" ).append("\n"); 
		query.append("END INV_USD_DYS," ).append("\n"); 
		query.append("ACMM_RT_AMT," ).append("\n"); 
		query.append("FLET_BROG_RT_AMT," ).append("\n"); 
		query.append("ACMM_FLG," ).append("\n"); 
		query.append("BROG_FLG," ).append("\n"); 
		query.append("INV_SEQ," ).append("\n"); 
		query.append("PAY_HIR_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  FI.FLET_CTRT_NO," ).append("\n"); 
		query.append("FC.VSL_CD," ).append("\n"); 
		query.append("(SELECT VSL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE VSL_CD = FC.VSL_CD" ).append("\n"); 
		query.append("AND ROWNUM =1) VSL_ENG_NM," ).append("\n"); 
		query.append("(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01513'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = FC.FLET_CTRT_TP_CD) FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("CASE WHEN FC.FLET_CTRT_TP_CD = 'TO' THEN" ).append("\n"); 
		query.append("(SELECT MV.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MV, FMS_OWNER FO" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = FC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST_SEQ = FC.CUST_SEQ" ).append("\n"); 
		query.append("AND MV.FLET_MGMT_OWNR_CUST_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR MV, FMS_OWNER FO" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = FC.VNDR_SEQ" ).append("\n"); 
		query.append("AND MV.FLET_MGMT_OWNR_VNDR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("END VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("FC.CUST_CNT_CD," ).append("\n"); 
		query.append("DECODE(FC.CUST_SEQ,NULL,FC.VNDR_SEQ,FC.CUST_SEQ) CUST_SEQ," ).append("\n"); 
		query.append("CASE WHEN FC.OWNR_SEQ IS NULL THEN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE WHEN FC.FLET_CTRT_TP_CD = 'TO' THEN" ).append("\n"); 
		query.append("(SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MV, FMS_OWNER FO" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = FC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST_SEQ = FC.CUST_SEQ" ).append("\n"); 
		query.append("AND MV.FLET_MGMT_OWNR_CUST_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR MV, FMS_OWNER FO" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = FC.VNDR_SEQ" ).append("\n"); 
		query.append("AND MV.FLET_MGMT_OWNR_VNDR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("END )" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("FROM FMS_OWNER FO" ).append("\n"); 
		query.append("WHERE FC.OWNR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("END OWNR_NM," ).append("\n"); 
		query.append("TO_CHAR(FI.EXP_DT,'YYYY-MM-DD') EFF_DT," ).append("\n"); 
		query.append("TO_CHAR(FI.EXP_DT,'HH24:MI') FROM_TIME," ).append("\n"); 
		query.append("TO_CHAR(FC.ACMM_RT_AMT,'FM990.00') ACMM_RT_AMT," ).append("\n"); 
		query.append("TO_CHAR(FC.FLET_BROG_RT_AMT,'FM990.00') FLET_BROG_RT_AMT," ).append("\n"); 
		query.append("DECODE(FC.ACMM_RT_AMT,NULL,'N','Y') ACMM_FLG," ).append("\n"); 
		query.append("DECODE(FC.FLET_BROG_RT_AMT,NULL,'N','Y') BROG_FLG," ).append("\n"); 
		query.append("FI.INV_SEQ," ).append("\n"); 
		query.append("CASE WHEN FI.EXP_DT >=FP.EFF_DT AND FI.EXP_DT <= FP.EXP_DT AND FP.CTRT_PAY_TERM_CD = 'A' THEN" ).append("\n"); 
		query.append("DECODE(SIGN(TO_NUMBER(TO_CHAR(FI.EXP_DT,'DD'))-16),-1,TO_CHAR(FI.EXP_DT,'YYYY-MM') || '-16',TO_CHAR(ADD_MONTHS(FI.EXP_DT,1),'YYYY-MM') || '-01')" ).append("\n"); 
		query.append("WHEN FI.EXP_DT >=FP.EFF_DT AND FI.EXP_DT <= FP.EXP_DT AND FP.CTRT_PAY_TERM_CD = 'B' THEN" ).append("\n"); 
		query.append("CASE WHEN FP.EXP_DT >= FI.EXP_DT + 15 THEN" ).append("\n"); 
		query.append("TO_CHAR(FI.EXP_DT + 15,'YYYY-MM-DD')" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("TO_CHAR(FP.EXP_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("WHEN FI.EXP_DT >=FP.EFF_DT AND FI.EXP_DT <= FP.EXP_DT AND FP.CTRT_PAY_TERM_CD = 'C' THEN" ).append("\n"); 
		query.append("TO_CHAR(ADD_MONTHS(FI.EXP_DT,1),'YYYY-MM-DD')" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("NULL" ).append("\n"); 
		query.append("END EXP_DT," ).append("\n"); 
		query.append("CASE WHEN FI.EXP_DT >=FP.EFF_DT AND FI.EXP_DT <= FP.EXP_DT AND FP.CTRT_PAY_TERM_CD = 'A' THEN" ).append("\n"); 
		query.append("'00:00'" ).append("\n"); 
		query.append("WHEN FI.EXP_DT >=FP.EFF_DT AND FI.EXP_DT <= FP.EXP_DT AND FP.CTRT_PAY_TERM_CD = 'B' THEN" ).append("\n"); 
		query.append("TO_CHAR(FI.EXP_DT + 15,'HH24:MI')" ).append("\n"); 
		query.append("WHEN FI.EXP_DT >=FP.EFF_DT AND FI.EXP_DT <= FP.EXP_DT AND FP.CTRT_PAY_TERM_CD = 'C' THEN" ).append("\n"); 
		query.append("TO_CHAR(ADD_MONTHS(FI.EXP_DT,1),'HH24:MI')" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("NULL" ).append("\n"); 
		query.append("END TO_TIME," ).append("\n"); 
		query.append("(SELECT MAX(EXP_DT)" ).append("\n"); 
		query.append("FROM FMS_HIRE" ).append("\n"); 
		query.append("WHERE FLET_CTRT_NO = @[flet_ctrt_no]) HIRE_MAX_EXP_DT," ).append("\n"); 
		query.append("(SELECT NVL(MAX(PPAY_HIR_NO),0) +1" ).append("\n"); 
		query.append("FROM FMS_INVOICE" ).append("\n"); 
		query.append("WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND FLET_ISS_TP_CD = 'PRE') PAY_HIR_NO" ).append("\n"); 
		query.append("FROM  FMS_INVOICE FI, FMS_CONTRACT FC, FMS_PAY_TERM FP" ).append("\n"); 
		query.append("WHERE  FC.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND  FC.FLET_CTRT_NO = FI.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND  FC.FLET_CTRT_NO = FP.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND  FI.EXP_DT >= FP.EFF_DT" ).append("\n"); 
		query.append("AND  FI.EXP_DT < FP.EXP_DT" ).append("\n"); 
		query.append("AND  FI.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("AND  FI.PPAY_HIR_NO = (SELECT /*+ INDEX_DESC(FI XPKFMS_INVOICE) */ PPAY_HIR_NO" ).append("\n"); 
		query.append("FROM FMS_INVOICE FI" ).append("\n"); 
		query.append("WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 
		query.append("AND  0 != (SELECT COUNT(1)" ).append("\n"); 
		query.append("FROM FMS_INVOICE" ).append("\n"); 
		query.append("WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND FLET_ISS_TP_CD = 'PRE')" ).append("\n"); 
		query.append("AND  ROWNUM = 1" ).append("\n"); 
		query.append("ORDER BY FI.PPAY_HIR_NO DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	FLET_CTRT_NO," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("VSL_ENG_NM," ).append("\n"); 
		query.append("FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("CUST_CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("OWNR_NM," ).append("\n"); 
		query.append("EFF_DT," ).append("\n"); 
		query.append("FROM_TIME," ).append("\n"); 
		query.append("EXP_DT," ).append("\n"); 
		query.append("TO_TIME," ).append("\n"); 
		query.append("CASE WHEN EFF_DT IS NOT NULL THEN" ).append("\n"); 
		query.append("DECODE(EXP_DT,NULL,NULL,TO_CHAR(ROUND(TO_DATE(REPLACE(EXP_DT,'-','') || REPLACE(TO_TIME,':',''),'YYYYMMDDHH24MI') - TO_DATE(REPLACE(EFF_DT,'-','') || REPLACE(FROM_TIME,':',''),'YYYYMMDDHH24MI'),4),'FM999,999.0000'))" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("NULL" ).append("\n"); 
		query.append("END INV_USD_DYS," ).append("\n"); 
		query.append("ACMM_RT_AMT," ).append("\n"); 
		query.append("FLET_BROG_RT_AMT," ).append("\n"); 
		query.append("ACMM_FLG," ).append("\n"); 
		query.append("BROG_FLG," ).append("\n"); 
		query.append("INV_SEQ," ).append("\n"); 
		query.append("PAY_HIR_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT	FLET_CTRT_NO," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("VSL_ENG_NM," ).append("\n"); 
		query.append("FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("CUST_CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("OWNR_NM," ).append("\n"); 
		query.append("TO_CHAR(EFF_DT,'YYYY-MM-DD') EFF_DT," ).append("\n"); 
		query.append("TO_CHAR(EFF_DT,'HH24:MI') FROM_TIME," ).append("\n"); 
		query.append("CASE WHEN CTRT_PAY_TERM_CD = 'A' THEN" ).append("\n"); 
		query.append("DECODE(SIGN(TO_CHAR(EFF_DT,'DD')-'16'),-1,TO_CHAR(EFF_DT,'YYYY-MM') || '-16',TO_CHAR(ADD_MONTHS(EFF_DT,1),'YYYY-MM') || '-01')" ).append("\n"); 
		query.append("WHEN CTRT_PAY_TERM_CD = 'B' THEN" ).append("\n"); 
		query.append("TO_CHAR(EFF_DT + 15,'YYYY-MM-DD')" ).append("\n"); 
		query.append("WHEN CTRT_PAY_TERM_CD = 'C' THEN" ).append("\n"); 
		query.append("TO_CHAR(ADD_MONTHS(EFF_DT,1),'YYYY-MM-DD')" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("NULL" ).append("\n"); 
		query.append("END EXP_DT," ).append("\n"); 
		query.append("CASE WHEN CTRT_PAY_TERM_CD = 'A' THEN" ).append("\n"); 
		query.append("'00:00'" ).append("\n"); 
		query.append("WHEN CTRT_PAY_TERM_CD = 'B' THEN" ).append("\n"); 
		query.append("TO_CHAR(EFF_DT + 15,'HH24:MI')" ).append("\n"); 
		query.append("WHEN CTRT_PAY_TERM_CD = 'C' THEN" ).append("\n"); 
		query.append("TO_CHAR(ADD_MONTHS(EFF_DT,1),'HH24:MI')" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("NULL" ).append("\n"); 
		query.append("END TO_TIME," ).append("\n"); 
		query.append("ACMM_RT_AMT," ).append("\n"); 
		query.append("FLET_BROG_RT_AMT," ).append("\n"); 
		query.append("ACMM_FLG," ).append("\n"); 
		query.append("BROG_FLG," ).append("\n"); 
		query.append("INV_SEQ," ).append("\n"); 
		query.append("PAY_HIR_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  FC.FLET_CTRT_NO," ).append("\n"); 
		query.append("FC.VSL_CD," ).append("\n"); 
		query.append("(SELECT VSL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE VSL_CD = FC.VSL_CD" ).append("\n"); 
		query.append("AND ROWNUM =1) VSL_ENG_NM," ).append("\n"); 
		query.append("(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01513'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = FC.FLET_CTRT_TP_CD) FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("CASE WHEN FC.FLET_CTRT_TP_CD = 'TO' THEN" ).append("\n"); 
		query.append("(SELECT MV.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MV, FMS_OWNER FO" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = FC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST_SEQ = FC.CUST_SEQ" ).append("\n"); 
		query.append("AND MV.FLET_MGMT_OWNR_CUST_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR MV, FMS_OWNER FO" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = FC.VNDR_SEQ" ).append("\n"); 
		query.append("AND MV.FLET_MGMT_OWNR_VNDR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("END VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("FC.CUST_CNT_CD," ).append("\n"); 
		query.append("DECODE(FC.CUST_SEQ,NULL,FC.VNDR_SEQ,FC.CUST_SEQ) CUST_SEQ," ).append("\n"); 
		query.append("CASE WHEN FC.OWNR_SEQ IS NULL THEN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE WHEN FC.FLET_CTRT_TP_CD = 'TO' THEN" ).append("\n"); 
		query.append("(SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER MV, FMS_OWNER FO" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = FC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST_SEQ = FC.CUST_SEQ" ).append("\n"); 
		query.append("AND MV.FLET_MGMT_OWNR_CUST_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR MV, FMS_OWNER FO" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = FC.VNDR_SEQ" ).append("\n"); 
		query.append("AND MV.FLET_MGMT_OWNR_VNDR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("END )" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("(SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("FROM FMS_OWNER FO" ).append("\n"); 
		query.append("WHERE FC.OWNR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append("END OWNR_NM," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("TO_CHAR(FC.ACMM_RT_AMT,'FM990.00') ACMM_RT_AMT," ).append("\n"); 
		query.append("TO_CHAR(FC.FLET_BROG_RT_AMT,'FM990.00') FLET_BROG_RT_AMT," ).append("\n"); 
		query.append("DECODE(FC.ACMM_RT_AMT,NULL,'N','Y') ACMM_FLG," ).append("\n"); 
		query.append("DECODE(FC.FLET_BROG_RT_AMT,NULL,'N','Y') BROG_FLG," ).append("\n"); 
		query.append("NULL INV_SEQ," ).append("\n"); 
		query.append("FP.CTRT_PAY_TERM_CD CTRT_PAY_TERM_CD," ).append("\n"); 
		query.append("(SELECT EFF_DT" ).append("\n"); 
		query.append("FROM FMS_HIRE" ).append("\n"); 
		query.append("WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1) EFF_DT," ).append("\n"); 
		query.append("(SELECT NVL(MAX(PPAY_HIR_NO),0) +1" ).append("\n"); 
		query.append("FROM FMS_INVOICE" ).append("\n"); 
		query.append("WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND FLET_ISS_TP_CD = 'PRE') PAY_HIR_NO" ).append("\n"); 
		query.append("FROM  FMS_CONTRACT FC, FMS_PAY_TERM FP" ).append("\n"); 
		query.append("WHERE  FC.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND  FC.FLET_CTRT_NO = FP.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND  0 = (SELECT COUNT(1)" ).append("\n"); 
		query.append("FROM FMS_INVOICE" ).append("\n"); 
		query.append("WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND FLET_ISS_TP_CD = 'PRE')" ).append("\n"); 
		query.append("AND  ROWNUM = 1" ).append("\n"); 
		query.append("ORDER BY FP.EFF_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}