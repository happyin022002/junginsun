/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CMSummaryDBDAORsltPrsAmendmentSummaryChartTargetListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CMSummaryDBDAORsltPrsAmendmentSummaryChartTargetListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chart화면 grid에서 사용될 대상 목록을 조회한다.
	  * 
	  * * History
	  * 2015.06.26 CHM-201536492 Split05-주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public CMSummaryDBDAORsltPrsAmendmentSummaryChartTargetListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_prop_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_prop_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_smr_eff_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_ctrt_eff_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_prop_apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_smr_eff_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rfrc_exp_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rfrc_exp_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_ori_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rfrc_eff_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_ctrt_eff_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_pfmc_unit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_dest_rout_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rfrc_eff_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_smr_exp_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_ctrt_exp_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_ctrt_exp_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_smr_exp_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration").append("\n"); 
		query.append("FileName : CMSummaryDBDAORsltPrsAmendmentSummaryChartTargetListRSQL").append("\n"); 
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
		query.append("WITH VW_CONTRACT_DT AS (" ).append("\n"); 
		query.append("	SELECT  /*+ MATERIALIZE */ MIN(SLS_FM_DT) AS  SLS_FM_DT, MAX(SLS_TO_DT)  AS SLS_TO_DT" ).append("\n"); 
		query.append("	FROM MAS_WK_PRD" ).append("\n"); 
		query.append("	WHERE (COST_YR = @[frm_ctrt_eff_yr] AND COST_WK = @[frm_ctrt_eff_wk])" ).append("\n"); 
		query.append("		OR (COST_YR = @[frm_ctrt_exp_yr] AND COST_WK = @[frm_ctrt_exp_wk])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VW_CONTRACT_DT_LIST AS (" ).append("\n"); 
		query.append("	SELECT  /*+ MATERIALIZE */ COST_YR||substr(SLS_TO_DT,5,2) as COST_YRMON,COST_WK" ).append("\n"); 
		query.append("	FROM MAS_WK_PRD" ).append("\n"); 
		query.append("	WHERE (COST_YR  || COST_WK) >= (@[frm_ctrt_eff_yr] || @[frm_ctrt_eff_wk])  AND (COST_YR || COST_WK )<= (@[frm_ctrt_exp_yr] || @[frm_ctrt_exp_wk])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",VW_SUMMARY_DT AS (" ).append("\n"); 
		query.append("	SELECT  /*+ MATERIALIZE */ MIN(SLS_FM_DT)  AS  SLS_FM_DT, MAX(SLS_TO_DT)  AS SLS_TO_DT" ).append("\n"); 
		query.append("	FROM MAS_WK_PRD" ).append("\n"); 
		query.append("	WHERE (COST_YR = @[frm_smr_eff_yr] AND COST_WK = @[frm_smr_eff_wk])" ).append("\n"); 
		query.append("		OR (COST_YR = @[frm_smr_exp_yr] AND COST_WK = @[frm_smr_exp_wk])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",VW_REFERENCE_DT AS (" ).append("\n"); 
		query.append("	SELECT  /*+ MATERIALIZE */ MIN(SLS_FM_DT)  AS  SLS_FM_DT,  MAX(SLS_TO_DT)  AS SLS_TO_DT" ).append("\n"); 
		query.append("	FROM MAS_WK_PRD" ).append("\n"); 
		query.append("	WHERE  (COST_YR = @[frm_rfrc_eff_yr] AND COST_WK = @[frm_rfrc_eff_wk])" ).append("\n"); 
		query.append("		OR (COST_YR = @[frm_rfrc_exp_yr] AND COST_WK = @[frm_rfrc_exp_wk])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- SUMMARY에서 입력한 주차를 이용해 현재 날짜 이전 주차는 WK_TP : -1 , 현재 주차 : 0 , 미래주차 : 1" ).append("\n"); 
		query.append(", VW_SUMMARY_WEEK AS (" ).append("\n"); 
		query.append("	SELECT  /*+ MATERIALIZE */ SLS_FM_YRWK,SLS_FM_DT,SLS_TO_YRWK,SLS_TO_DT,WK_TP" ).append("\n"); 
		query.append("		,(SELECT COUNT(*) FROM MAS_WK_PRD PRD WHERE (PRD.COST_YR || PRD.COST_WK >= MN.SLS_FM_YRWK AND PRD.COST_YR || PRD.COST_WK <= MN.SLS_TO_YRWK) )+DECODE(WK_TP,1,1,0) AS TOT_WK -- ESTIMATE 조회시 현재주차도 미래주차에 포함시킨다." ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT MIN(COST_YR||COST_WK) AS SLS_FM_YRWK,MIN(SLS_FM_DT) AS  SLS_FM_DT,  MAX(COST_YR||COST_WK) AS SLS_TO_YRWK,MAX(SLS_TO_DT) AS SLS_TO_DT,WK_TP" ).append("\n"); 
		query.append("		FROM (		" ).append("\n"); 
		query.append("			SELECT COST_YR,COST_WK,SLS_FM_DT,SLS_TO_DT ," ).append("\n"); 
		query.append("			       CASE WHEN TO_CHAR(SYSDATE,'YYYYMMDD') <= SLS_TO_DT  AND TO_CHAR(SYSDATE,'YYYYMMDD') >= SLS_FM_DT" ).append("\n"); 
		query.append("						THEN 0" ).append("\n"); 
		query.append("						WHEN TO_CHAR(SYSDATE,'YYYYMMDD') > SLS_TO_DT   " ).append("\n"); 
		query.append("				    THEN -1" ).append("\n"); 
		query.append("				    ELSE 1" ).append("\n"); 
		query.append("			       END AS WK_TP" ).append("\n"); 
		query.append("			FROM MAS_WK_PRD " ).append("\n"); 
		query.append("			WHERE (COST_YR || COST_WK >= (@[frm_smr_eff_yr] || @[frm_smr_eff_wk]) AND COST_YR || COST_WK <= (@[frm_smr_exp_yr] || @[frm_smr_exp_wk]))	" ).append("\n"); 
		query.append("		)	" ).append("\n"); 
		query.append("		GROUP BY WK_TP" ).append("\n"); 
		query.append("	) MN" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--------------------------------------------------------" ).append("\n"); 
		query.append("-- 이하 RFA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", VW_RFA_PROP_KEY AS (" ).append("\n"); 
		query.append("	SELECT  /*+ MATERIALIZE */ DUR.PROP_NO , MAX(DUR.AMDT_SEQ) AS AMDT_SEQ" ).append("\n"); 
		query.append("	FROM PRI_RP_DUR DUR" ).append("\n"); 
		query.append("		, VW_CONTRACT_DT CDT" ).append("\n"); 
		query.append("	WHERE TO_CHAR(CTRT_EFF_DT,'YYYYMMDD') >= SLS_FM_DT" ).append("\n"); 
		query.append("		AND TO_CHAR(CTRT_EXP_DT,'YYYYMMDD') <= SLS_TO_DT" ).append("\n"); 
		query.append("                #if(${frm_contract_type} == 'B' || ${frm_contract_type} == 'R' )" ).append("\n"); 
		query.append("                        AND 1=1" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                        AND 1=0" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("	GROUP BY DUR.PROP_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" -- 데이터 SELECT시 조회 조건으로 이용될 KEY LIST" ).append("\n"); 
		query.append(", VW_RFA_KEY_LIST AS (" ).append("\n"); 
		query.append("	SELECT  /*+ MATERIALIZE LEADING(DT SR_CST_DTL) */ " ).append("\n"); 
		query.append("		 HDR.RFA_NO , PKEY.PROP_NO, PKEY.AMDT_SEQ" ).append("\n"); 
		query.append("		,SR_CST_DTL.PRS_YRMON, SR_CST_DTL.PRS_WK, SR_CST_DTL.PRC_CTRT_TP_CD, SR_CST_DTL.PRC_CTRT_NO" ).append("\n"); 
		query.append("		, SR_CST_DTL.SVC_SCP_CD, SR_CST_DTL.VSL_SLAN_DIR_CD, SR_CST_DTL.TRD_CD, SR_CST_DTL.SUB_TRD_CD" ).append("\n"); 
		query.append("		, SR_CST_DTL.RLANE_CD, SR_CST_DTL.PRC_CGO_TP_CD, SR_CST_DTL.ORG_LOC_TP_CD, SR_CST_DTL.ORG_LOC_DEF_CD,SR_CST_DTL. DEST_LOC_TP_CD, SR_CST_DTL.DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("		,SR_CST_DTL.TEU_FRT_REV, SR_CST_DTL.PRS_RESPB_CM_UC_AMT, SR_CST_DTL.PRS_PFIT_CM_UC_AMT, SR_CST_DTL.PRS_RESPB_OPFIT_UC_AMT, SR_CST_DTL.PRS_CRNT_LOD_QTY, SR_CST_DTL.PRS_RESPB_CMPB_AMT, SR_CST_DTL.PRS_PFIT_CMPB_AMT, SR_CST_DTL.PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("		VW_CONTRACT_DT_LIST  DT        " ).append("\n"); 
		query.append("		, PRI_RP_HDR HDR" ).append("\n"); 
		query.append("		, VW_RFA_PROP_KEY PKEY" ).append("\n"); 
		query.append("		, PRI_PRS_CTRT_SMRY SMRY" ).append("\n"); 
		query.append("		, PRI_PRS_CTRT_SMRY_COST_DTL SR_CST_DTL" ).append("\n"); 
		query.append("	WHERE HDR.PROP_NO  = PKEY.PROP_NO " ).append("\n"); 
		query.append("		AND HDR.RFA_NO = SMRY.PRC_CTRT_NO" ).append("\n"); 
		query.append("		AND SMRY.PRC_CTRT_TP_CD = 'R' -- RFA" ).append("\n"); 
		query.append("		AND SR_CST_DTL.PRS_YRMON = DT.COST_YRMON       " ).append("\n"); 
		query.append("		AND SR_CST_DTL.PRS_WK    = DT.COST_WK          " ).append("\n"); 
		query.append("		AND SMRY.PRS_YRMON = SR_CST_DTL.PRS_YRMON" ).append("\n"); 
		query.append("		AND SMRY.PRS_WK = SR_CST_DTL.PRS_WK" ).append("\n"); 
		query.append("		AND SMRY.PRC_CTRT_TP_CD = SR_CST_DTL.PRC_CTRT_TP_CD" ).append("\n"); 
		query.append("		AND SMRY.PRC_CTRT_NO = SR_CST_DTL.PRC_CTRT_NO" ).append("\n"); 
		query.append("		AND HDR.RFA_NO IS NOT NULL" ).append("\n"); 
		query.append("		AND SR_CST_DTL.TRD_CD = @[frm_trd_cd]" ).append("\n"); 
		query.append("		AND SR_CST_DTL.VSL_SLAN_DIR_CD = @[frm_dir_cd]" ).append("\n"); 
		query.append("		#if(${frm_sub_trd_cd} != '')" ).append("\n"); 
		query.append("			AND SR_CST_DTL.SUB_TRD_CD = @[frm_sub_trd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${frm_rlane_cd} != '')" ).append("\n"); 
		query.append("			AND SR_CST_DTL.RLANE_CD IN (" ).append("\n"); 
		query.append("			#foreach( ${key} in ${rlane_list}) " ).append("\n"); 
		query.append("				#if($velocityCount != 1 ) " ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				SELECT " ).append("\n"); 
		query.append("						 '$key' " ).append("\n"); 
		query.append("				FROM DUAL" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("			 " ).append("\n"); 
		query.append("		#if(${frm_customer_type} == 'B')" ).append("\n"); 
		query.append("					AND SMRY.PRS_CUST_TP_CD IN ('I','A','O')" ).append("\n"); 
		query.append("		#elseif(${frm_customer_type} == 'N')" ).append("\n"); 
		query.append("					AND SMRY.PRS_CUST_TP_CD IN ('N')" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("				AND SMRY.PRS_CUST_TP_CD IN ('I','A','O','N')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${frm_prop_ofc_cd} != '')" ).append("\n"); 
		query.append("					AND SMRY.PROP_OFC_CD = @[frm_prop_ofc_cd] -- REQUEST" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${frm_prop_srep_cd} != '')" ).append("\n"); 
		query.append("					AND SMRY.RESPB_SREP_CD = @[frm_prop_srep_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${frm_prop_apro_ofc_cd} != '')" ).append("\n"); 
		query.append("					AND SMRY.PROP_APRO_OFC_CD = @[frm_prop_apro_ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if( $cust_list.size() != 0 ) " ).append("\n"); 
		query.append("			AND (SMRY.CUST_CNT_CD , SMRY.CUST_SEQ) IN (" ).append("\n"); 
		query.append("			#foreach( ${key} in ${cust_list}) " ).append("\n"); 
		query.append("				#if($velocityCount != 1 ) " ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				SELECT " ).append("\n"); 
		query.append("						substr('$key',1,2),substr('$key',3)" ).append("\n"); 
		query.append("				FROM DUAL" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                #if(${frm_contract_type} == 'B' || ${frm_contract_type} == 'R' )" ).append("\n"); 
		query.append("                        AND 1=1" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                        AND 1=0" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- 기준이 되는 SC_NO를 조회 ( OUTER JOIN의 기준 데이터가 된다. )" ).append("\n"); 
		query.append(", VW_RFA_CONTRACT_KEY AS (" ).append("\n"); 
		query.append("	SELECT  /*+ MATERIALIZE */ DISTINCT RFA_NO , PROP_NO, AMDT_SEQ" ).append("\n"); 
		query.append("	FROM VW_RFA_KEY_LIST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--- 계약번호당 실적이 총 몇주차 인지 ESTIMATE에 쓰일 총 주차가 몇주차인지 계산한다." ).append("\n"); 
		query.append(", VW_RFA_TOT_WEEK_PER_RFA_NO AS (" ).append("\n"); 
		query.append("SELECT  /*+ MATERIALIZE */ PROP_NO , AMDT_SEQ,RFA_NO" ).append("\n"); 
		query.append("	,ACTUAL_WK_CNT" ).append("\n"); 
		query.append("	,DECODE(ESTIMATE_WK_CNT	,1,0,ESTIMATE_WK_CNT	) AS ESTIMATE_WK_CNT	-- 현재주차만 걸릴경우 제외시킨다." ).append("\n"); 
		query.append("	,REFER_WK_CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT /*+ ORDERED USE_NL(KLIST DUR) USE_HASH(KLIST PRD) */  " ).append("\n"); 
		query.append("		KLIST.PROP_NO , KLIST.AMDT_SEQ,KLIST.RFA_NO" ).append("\n"); 
		query.append("		, SUM(" ).append("\n"); 
		query.append("			CASE	WHEN TO_CHAR(SYSDATE,'YYYYMMDD') <= PRD.SLS_TO_DT  AND TO_CHAR(SYSDATE,'YYYYMMDD') >= PRD.SLS_FM_DT" ).append("\n"); 
		query.append("				THEN 0" ).append("\n"); 
		query.append("				WHEN TO_CHAR(SYSDATE,'YYYYMMDD') > PRD.SLS_TO_DT   AND  PRD.SLS_TO_DT >=  KLIST.SDT_SLS_FM_DT    -- SDT.SLS_FM_DT" ).append("\n"); 
		query.append("				THEN 1" ).append("\n"); 
		query.append("				ELSE 0" ).append("\n"); 
		query.append("		       END " ).append("\n"); 
		query.append("		  ) AS ACTUAL_WK_CNT" ).append("\n"); 
		query.append("		, SUM(" ).append("\n"); 
		query.append("			CASE	WHEN TO_CHAR(SYSDATE,'YYYYMMDD') <= PRD.SLS_TO_DT  AND TO_CHAR(SYSDATE,'YYYYMMDD') >= PRD.SLS_FM_DT" ).append("\n"); 
		query.append("				THEN 1" ).append("\n"); 
		query.append("				WHEN TO_CHAR(SYSDATE,'YYYYMMDD') > PRD.SLS_TO_DT  " ).append("\n"); 
		query.append("				THEN 0" ).append("\n"); 
		query.append("				WHEN   PRD.SLS_TO_DT <=  KLIST.SDT_SLS_TO_DT     --- SDT.SLS_TO_DT " ).append("\n"); 
		query.append("				THEN 1" ).append("\n"); 
		query.append("				ELSE 0" ).append("\n"); 
		query.append("			END " ).append("\n"); 
		query.append("		) AS ESTIMATE_WK_CNT	" ).append("\n"); 
		query.append("		, SUM(" ).append("\n"); 
		query.append("			CASE	WHEN TO_CHAR(SYSDATE,'YYYYMMDD') <= PRD.SLS_TO_DT  AND TO_CHAR(SYSDATE,'YYYYMMDD') >= PRD.SLS_FM_DT" ).append("\n"); 
		query.append("				THEN 0" ).append("\n"); 
		query.append("				WHEN TO_CHAR(SYSDATE,'YYYYMMDD') > PRD.SLS_TO_DT   AND  PRD.SLS_FM_DT >=  KLIST.RDT_SLS_FM_DT AND  PRD.SLS_FM_DT <= KLIST.RDT_SLS_TO_DT   -- RDT.SLS_FM_DT AND  PRD.SLS_FM_DT <= RDT.SLS_TO_DT" ).append("\n"); 
		query.append("				THEN 1" ).append("\n"); 
		query.append("				ELSE 0" ).append("\n"); 
		query.append("		       END " ).append("\n"); 
		query.append("		  ) AS REFER_WK_CNT" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	  --> 수정 : 인라인뷰로 묶음" ).append("\n"); 
		query.append("		 (	" ).append("\n"); 
		query.append("			SELECT  /*+ NO_MERGE ORDERED */" ).append("\n"); 
		query.append("				      SDT.SLS_FM_DT  SDT_SLS_FM_DT," ).append("\n"); 
		query.append("				      SDT.SLS_TO_DT  SDT_SLS_TO_DT," ).append("\n"); 
		query.append("				      RDT.SLS_FM_DT  RDT_SLS_FM_DT," ).append("\n"); 
		query.append("				      RDT.SLS_TO_DT  RDT_SLS_TO_DT," ).append("\n"); 
		query.append("				      KLIST.*," ).append("\n"); 
		query.append("				      1  HASH_JOIN_KEY" ).append("\n"); 
		query.append("			 FROM    VW_SUMMARY_DT       SDT" ).append("\n"); 
		query.append("				, VW_REFERENCE_DT     RDT" ).append("\n"); 
		query.append("				, VW_RFA_CONTRACT_KEY KLIST		" ).append("\n"); 
		query.append("		 )  KLIST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		, PRI_RP_DUR DUR" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("			SELECT  /*+ NO_MERGE */" ).append("\n"); 
		query.append("			     SLS_FM_DT, SLS_TO_DT," ).append("\n"); 
		query.append("			     1  HASH_JOIN_KEY" ).append("\n"); 
		query.append("			FROM   MAS_WK_PRD " ).append("\n"); 
		query.append("		 )  PRD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	WHERE DUR.PROP_NO = KLIST.PROP_NO" ).append("\n"); 
		query.append("		AND DUR.AMDT_SEQ = KLIST.AMDT_SEQ" ).append("\n"); 
		query.append("		AND KLIST.HASH_JOIN_KEY = PRD.HASH_JOIN_KEY   --> 수정 : HASH 조인으로 변경" ).append("\n"); 
		query.append("		AND (" ).append("\n"); 
		query.append("				(	TO_CHAR(DUR.CTRT_EFF_DT,'YYYYMMDD') >= PRD.SLS_FM_DT " ).append("\n"); 
		query.append("					AND TO_CHAR(DUR.CTRT_EFF_DT,'YYYYMMDD') <= PRD.SLS_TO_DT	 " ).append("\n"); 
		query.append("				)  OR (   " ).append("\n"); 
		query.append("					TO_CHAR(DUR.CTRT_EXP_DT,'YYYYMMDD') >= PRD.SLS_FM_DT " ).append("\n"); 
		query.append("					AND TO_CHAR(DUR.CTRT_EXP_DT,'YYYYMMDD') <= PRD.SLS_TO_DT " ).append("\n"); 
		query.append("				) OR (" ).append("\n"); 
		query.append("					TO_CHAR(DUR.CTRT_EFF_DT,'YYYYMMDD') <= PRD.SLS_FM_DT " ).append("\n"); 
		query.append("					AND TO_CHAR(DUR.CTRT_EXP_DT,'YYYYMMDD')>= PRD.SLS_TO_DT	 " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		) " ).append("\n"); 
		query.append("                #if(${frm_contract_type} == 'B' || ${frm_contract_type} == 'R' )" ).append("\n"); 
		query.append("                        AND 1=1" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                        AND 1=0" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 GROUP BY KLIST.PROP_NO , KLIST.AMDT_SEQ,KLIST.RFA_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- ACTUAL DATA 조회" ).append("\n"); 
		query.append("-- SUBSTR(SR_CST_DTL.PRS_YRMON,1,4)  || SR_CST_DTL.PRS_WK) 결합 INDEX 필요" ).append("\n"); 
		query.append(", VW_RFA_ACTUAL_VALUE AS (" ).append("\n"); 
		query.append("	SELECT  CKEY.RFA_NO" ).append("\n"); 
		query.append("		, CKEY.PRC_CTRT_NO " ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1) )      AS LOAD            -- Load(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_RESPB_CM_UC_AMT)   AS COST_CM_OFFICE  -- Office Profit/ CM -- Cost(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_PFIT_CM_UC_AMT)    AS COST_CM_TRADE   --Trade Profit/ CM   -- Cost(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_RESPB_OPFIT_UC_AMT) AS COST_OP_OFFICE -- Office Profit/ OP -- Cost(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_RESPB_CMPB_AMT * ( CKEY.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1))   ) / SUM(CKEY.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1) )     AS CMPB_OFFICE     -- Office Profit/ CM -- CMPB(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_PFIT_CMPB_AMT * ( CKEY.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1))   ) / SUM(CKEY.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1) )       AS CMPB_TRADE      -- Trade Profit/ CM  -- CMPB(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1) * CKEY.PRS_RESPB_CMPB_AMT) AS CM_OFFICE -- Office Profit/ CM -- CM(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_CRNT_LOD_QTY   / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1)  * CKEY.PRS_PFIT_CMPB_AMT) AS CM_TRADE   -- Trade Profit/ CM  -- CM(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_RESPB_OPB_AMT * ( CKEY.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1))   ) / SUM(CKEY.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1) )        AS OPB             -- Office Profit/ OP -- OPB(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_CRNT_LOD_QTY  * CKEY.PRS_RESPB_OPB_AMT) AS OP         -- OP(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.TEU_FRT_REV )         AS G_REV            -- Gross Revenue(Previous)" ).append("\n"); 
		query.append("		, MAX(WK_PER_SC.ACTUAL_WK_CNT) AS WEEK_CNT" ).append("\n"); 
		query.append("	FROM VW_RFA_KEY_LIST CKEY " ).append("\n"); 
		query.append("		, VW_SUMMARY_WEEK WK" ).append("\n"); 
		query.append("		, VW_RFA_TOT_WEEK_PER_RFA_NO WK_PER_SC" ).append("\n"); 
		query.append("	WHERE  CKEY.RFA_NO = WK_PER_SC.RFA_NO" ).append("\n"); 
		query.append("#if( ${frm_ori_rout_cd} != '' )" ).append("\n"); 
		query.append("		-- origin" ).append("\n"); 
		query.append("		AND CKEY.ORG_LOC_DEF_CD= @[frm_ori_rout_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${frm_dest_rout_cd} != '' )" ).append("\n"); 
		query.append("		-- DEST" ).append("\n"); 
		query.append("		AND CKEY.DEST_LOC_TP_CD= @[frm_dest_rout_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- BY CARGO TYPE" ).append("\n"); 
		query.append("#if (${crg_tp_str} != '' )" ).append("\n"); 
		query.append("		AND CKEY.PRC_CGO_TP_CD IN ( ${crg_tp_str} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		AND WK.WK_TP = -1" ).append("\n"); 
		query.append("		AND (SUBSTR(CKEY.PRS_YRMON,1,4)  || CKEY.PRS_WK) >= WK.SLS_FM_YRWK  AND (SUBSTR(CKEY.PRS_YRMON,1,4)  || CKEY.PRS_WK) <= WK.SLS_TO_YRWK  " ).append("\n"); 
		query.append("	GROUP BY CKEY.RFA_NO, CKEY.PRC_CTRT_NO " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VW_RFA_RESULT AS (" ).append("\n"); 
		query.append("	SELECT  A_SC_NO                              " ).append("\n"); 
		query.append("		, A1_LOAD                       " ).append("\n"); 
		query.append("		, A1_COST_CM_OFFICE     " ).append("\n"); 
		query.append("		, A1_COST_CM_TRADE      " ).append("\n"); 
		query.append("		, A1_COST_OP_OFFICE     " ).append("\n"); 
		query.append("		, A1_CMPB_OFFICE        " ).append("\n"); 
		query.append("		, A1_CMPB_TRADE         " ).append("\n"); 
		query.append("		, A1_CM_OFFICE          " ).append("\n"); 
		query.append("		, A1_CM_TRADE           " ).append("\n"); 
		query.append("		, A1_OPB                 " ).append("\n"); 
		query.append("		, A1_OP                  " ).append("\n"); 
		query.append("		, A1_G_REV               " ).append("\n"); 
		query.append("                , M.CTRT_CUST_CNT_CD || TO_CHAR(M.CTRT_CUST_SEQ,'FM000000') || ' - ' || CUST.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("                , M.PROP_OFC_CD" ).append("\n"); 
		query.append("                , M.TGT_MVC_QTY AS MQC_QTY" ).append("\n"); 
		query.append("                , M.CTRT_CUST_CNT_CD || TO_CHAR(M.CTRT_CUST_SEQ,'FM000000')  AS CUST_CD" ).append("\n"); 
		query.append("		, M.RESPB_SREP_CD" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT CKEY.RFA_NO AS SC_NO" ).append("\n"); 
		query.append("			, CKEY.PROP_NO" ).append("\n"); 
		query.append("			, CKEY.AMDT_SEQ" ).append("\n"); 
		query.append("			, CKEY.RFA_NO AS A_SC_NO" ).append("\n"); 
		query.append("			, AVALUE.LOAD	 AS A1_LOAD" ).append("\n"); 
		query.append("			, AVALUE.COST_CM_OFFICE	 AS A1_COST_CM_OFFICE" ).append("\n"); 
		query.append("			, AVALUE.COST_CM_TRADE	 AS A1_COST_CM_TRADE" ).append("\n"); 
		query.append("			, AVALUE.COST_OP_OFFICE	 AS A1_COST_OP_OFFICE" ).append("\n"); 
		query.append("			, AVALUE.CMPB_OFFICE	 AS A1_CMPB_OFFICE" ).append("\n"); 
		query.append("			, AVALUE.CMPB_TRADE	 AS A1_CMPB_TRADE" ).append("\n"); 
		query.append("			, AVALUE.CM_OFFICE	 AS A1_CM_OFFICE" ).append("\n"); 
		query.append("			, AVALUE.CM_TRADE	 AS A1_CM_TRADE" ).append("\n"); 
		query.append("			, AVALUE.OPB		AS A1_OPB" ).append("\n"); 
		query.append("			, AVALUE.OP		AS A1_OP" ).append("\n"); 
		query.append("			, AVALUE.G_REV		AS A1_G_REV" ).append("\n"); 
		query.append("			, AVALUE.WEEK_CNT	 AS A1_WEEK_CNT" ).append("\n"); 
		query.append("		FROM VW_RFA_CONTRACT_KEY CKEY" ).append("\n"); 
		query.append("			, VW_RFA_ACTUAL_VALUE AVALUE" ).append("\n"); 
		query.append("		WHERE CKEY.RFA_NO = AVALUE.RFA_NO(+)" ).append("\n"); 
		query.append("                #if(${frm_contract_type} == 'B' || ${frm_contract_type} == 'R' )" ).append("\n"); 
		query.append("                        AND 1=1" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                        AND 1=0" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	) MN" ).append("\n"); 
		query.append("	, PRI_RP_MN M" ).append("\n"); 
		query.append("        , MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("	WHERE" ).append("\n"); 
		query.append("		 MN.PROP_NO = M.PROP_NO" ).append("\n"); 
		query.append("		AND MN.AMDT_SEQ = M.AMDT_SEQ" ).append("\n"); 
		query.append("                AND CUST.CUST_CNT_CD = M.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                AND CUST.CUST_SEQ = M.CTRT_CUST_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--------------------------------------------------------" ).append("\n"); 
		query.append("-- 이하 SC" ).append("\n"); 
		query.append("-- 기준이 되는 PROP_NO를 조회" ).append("\n"); 
		query.append(", VW_PROP_KEY AS (" ).append("\n"); 
		query.append("	SELECT  /*+ MATERIALIZE */ DUR.PROP_NO , MAX(DUR.AMDT_SEQ) AS AMDT_SEQ" ).append("\n"); 
		query.append("	FROM PRI_SP_DUR DUR" ).append("\n"); 
		query.append("		, VW_CONTRACT_DT CDT" ).append("\n"); 
		query.append("	WHERE TO_CHAR(CTRT_EFF_DT,'YYYYMMDD') >= SLS_FM_DT" ).append("\n"); 
		query.append("		AND TO_CHAR(CTRT_EXP_DT,'YYYYMMDD') <= SLS_TO_DT" ).append("\n"); 
		query.append("                #if(${frm_contract_type} == 'B' || ${frm_contract_type} == 'S' )" ).append("\n"); 
		query.append("                        AND 1=1" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                        AND 1=0" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	GROUP BY DUR.PROP_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" -- 데이터 SELECT시 조회 조건으로 이용될 KEY LIST" ).append("\n"); 
		query.append(", VW_KEY_LIST AS (" ).append("\n"); 
		query.append("	SELECT  /*+ MATERIALIZE LEADING(DT SMRY HDR) FULL(HDR) */  HDR.SC_NO , PKEY.PROP_NO, PKEY.AMDT_SEQ" ).append("\n"); 
		query.append("		,SR_CST_DTL.PRS_YRMON, SR_CST_DTL.PRS_WK, SR_CST_DTL.PRC_CTRT_TP_CD, SR_CST_DTL.PRC_CTRT_NO" ).append("\n"); 
		query.append("		, SR_CST_DTL.SVC_SCP_CD, SR_CST_DTL.VSL_SLAN_DIR_CD, SR_CST_DTL.TRD_CD, SR_CST_DTL.SUB_TRD_CD" ).append("\n"); 
		query.append("		, SR_CST_DTL.RLANE_CD, SR_CST_DTL.PRC_CGO_TP_CD, SR_CST_DTL.ORG_LOC_TP_CD, SR_CST_DTL.ORG_LOC_DEF_CD,SR_CST_DTL. DEST_LOC_TP_CD, SR_CST_DTL.DEST_LOC_DEF_CD" ).append("\n"); 
		query.append("		,SR_CST_DTL.TEU_FRT_REV, SR_CST_DTL.PRS_RESPB_CM_UC_AMT, SR_CST_DTL.PRS_PFIT_CM_UC_AMT, SR_CST_DTL.PRS_RESPB_OPFIT_UC_AMT, SR_CST_DTL.PRS_CRNT_LOD_QTY, SR_CST_DTL.PRS_RESPB_CMPB_AMT, SR_CST_DTL.PRS_PFIT_CMPB_AMT, SR_CST_DTL.PRS_RESPB_OPB_AMT" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("		VW_CONTRACT_DT_LIST  DT         " ).append("\n"); 
		query.append("		, PRI_SP_HDR HDR" ).append("\n"); 
		query.append("		, VW_PROP_KEY PKEY" ).append("\n"); 
		query.append("		, PRI_PRS_CTRT_SMRY SMRY" ).append("\n"); 
		query.append("		, PRI_PRS_CTRT_SMRY_COST_DTL SR_CST_DTL" ).append("\n"); 
		query.append("	WHERE HDR.PROP_NO  = PKEY.PROP_NO " ).append("\n"); 
		query.append("		AND HDR.SC_NO = SMRY.PRC_CTRT_NO" ).append("\n"); 
		query.append("		AND SMRY.PRC_CTRT_TP_CD = 'S' -- S/C" ).append("\n"); 
		query.append("		AND SMRY.PRS_YRMON = DT.COST_YRMON     --> 수정 : 서브쿼리를 직접 조인으로 변경" ).append("\n"); 
		query.append("		AND SMRY.PRS_WK    = DT.COST_WK        --> 수정 : 서브쿼리를 직접 조인으로 변경" ).append("\n"); 
		query.append("		AND SMRY.PRS_YRMON = SR_CST_DTL.PRS_YRMON" ).append("\n"); 
		query.append("		AND SMRY.PRS_WK = SR_CST_DTL.PRS_WK" ).append("\n"); 
		query.append("		AND SMRY.PRC_CTRT_TP_CD = SR_CST_DTL.PRC_CTRT_TP_CD" ).append("\n"); 
		query.append("		AND SMRY.PRC_CTRT_NO = SR_CST_DTL.PRC_CTRT_NO" ).append("\n"); 
		query.append("		AND HDR.SC_NO IS NOT NULL" ).append("\n"); 
		query.append("		AND SR_CST_DTL.TRD_CD = @[frm_trd_cd]" ).append("\n"); 
		query.append("		AND SR_CST_DTL.VSL_SLAN_DIR_CD = @[frm_dir_cd]" ).append("\n"); 
		query.append("		#if(${frm_sub_trd_cd} != '')" ).append("\n"); 
		query.append("			AND SR_CST_DTL.SUB_TRD_CD = @[frm_sub_trd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${frm_rlane_cd} != '')" ).append("\n"); 
		query.append("			AND SR_CST_DTL.RLANE_CD IN (" ).append("\n"); 
		query.append("			#foreach( ${key} in ${rlane_list}) " ).append("\n"); 
		query.append("				#if($velocityCount != 1 ) " ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				SELECT " ).append("\n"); 
		query.append("						 '$key' " ).append("\n"); 
		query.append("				FROM DUAL" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("			 " ).append("\n"); 
		query.append("		#if(${frm_customer_type} == 'B')" ).append("\n"); 
		query.append("					AND SMRY.PRS_CUST_TP_CD IN ('I','A','O')" ).append("\n"); 
		query.append("		#elseif(${frm_customer_type} == 'N')" ).append("\n"); 
		query.append("					AND SMRY.PRS_CUST_TP_CD IN ('N')" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("				AND SMRY.PRS_CUST_TP_CD IN ('I','A','O','N')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${frm_prop_ofc_cd} != '')" ).append("\n"); 
		query.append("					AND SMRY.PROP_OFC_CD = @[frm_prop_ofc_cd] -- REQUEST" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${frm_prop_srep_cd} != '')" ).append("\n"); 
		query.append("					AND SMRY.RESPB_SREP_CD = @[frm_prop_srep_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${frm_prop_apro_ofc_cd} != '')" ).append("\n"); 
		query.append("					AND SMRY.PROP_APRO_OFC_CD = @[frm_prop_apro_ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if( $cust_list.size() != 0 ) " ).append("\n"); 
		query.append("			AND (SMRY.CUST_CNT_CD , SMRY.CUST_SEQ) IN (" ).append("\n"); 
		query.append("			#foreach( ${key} in ${cust_list}) " ).append("\n"); 
		query.append("				#if($velocityCount != 1 ) " ).append("\n"); 
		query.append("					UNION ALL" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				SELECT " ).append("\n"); 
		query.append("						substr('$key',1,2),substr('$key',3)" ).append("\n"); 
		query.append("				FROM DUAL" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                #if(${frm_contract_type} == 'B' || ${frm_contract_type} == 'S' )" ).append("\n"); 
		query.append("                        AND 1=1" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                        AND 1=0" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- 기준이 되는 SC_NO를 조회 ( OUTER JOIN의 기준 데이터가 된다. )" ).append("\n"); 
		query.append(", VW_CONTRACT_KEY AS (" ).append("\n"); 
		query.append("	SELECT  /*+ MATERIALIZE */ DISTINCT SC_NO , PROP_NO, AMDT_SEQ" ).append("\n"); 
		query.append("	FROM VW_KEY_LIST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--- 계약번호당 실적이 총 몇주차 인지 ESTIMATE에 쓰일 총 주차가 몇주차인지 계산한다." ).append("\n"); 
		query.append(", VW_TOT_WEEK_PER_SC_NO AS (" ).append("\n"); 
		query.append("SELECT  /*+ MATERIALIZE */ PROP_NO , AMDT_SEQ,SC_NO" ).append("\n"); 
		query.append("	,ACTUAL_WK_CNT" ).append("\n"); 
		query.append("	,DECODE(ESTIMATE_WK_CNT	,1,0,ESTIMATE_WK_CNT	) AS ESTIMATE_WK_CNT	-- 현재주차만 걸릴경우 제외시킨다." ).append("\n"); 
		query.append("	,REFER_WK_CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT /*+ ORDERED USE_NL(KLIST DUR) USE_HASH(KLIST PRD) */  " ).append("\n"); 
		query.append("		KLIST.PROP_NO , KLIST.AMDT_SEQ,KLIST.SC_NO" ).append("\n"); 
		query.append("		, SUM(" ).append("\n"); 
		query.append("			CASE	WHEN TO_CHAR(SYSDATE,'YYYYMMDD') <= PRD.SLS_TO_DT  AND TO_CHAR(SYSDATE,'YYYYMMDD') >= PRD.SLS_FM_DT" ).append("\n"); 
		query.append("				THEN 0" ).append("\n"); 
		query.append("				WHEN TO_CHAR(SYSDATE,'YYYYMMDD') > PRD.SLS_TO_DT   AND  PRD.SLS_TO_DT >=  KLIST.SDT_SLS_FM_DT --SDT.SLS_FM_DT" ).append("\n"); 
		query.append("				THEN 1" ).append("\n"); 
		query.append("				ELSE 0" ).append("\n"); 
		query.append("		       END " ).append("\n"); 
		query.append("		  ) AS ACTUAL_WK_CNT" ).append("\n"); 
		query.append("		, SUM(" ).append("\n"); 
		query.append("			CASE	WHEN TO_CHAR(SYSDATE,'YYYYMMDD') <= PRD.SLS_TO_DT  AND TO_CHAR(SYSDATE,'YYYYMMDD') >= PRD.SLS_FM_DT" ).append("\n"); 
		query.append("				THEN 1" ).append("\n"); 
		query.append("				WHEN TO_CHAR(SYSDATE,'YYYYMMDD') > PRD.SLS_TO_DT  " ).append("\n"); 
		query.append("				THEN 0" ).append("\n"); 
		query.append("				WHEN   PRD.SLS_TO_DT <=  KLIST.SDT_SLS_TO_DT   -- SDT.SLS_TO_DT " ).append("\n"); 
		query.append("				THEN 1" ).append("\n"); 
		query.append("				ELSE 0" ).append("\n"); 
		query.append("			END " ).append("\n"); 
		query.append("		) AS ESTIMATE_WK_CNT	" ).append("\n"); 
		query.append("		, SUM(" ).append("\n"); 
		query.append("			CASE	WHEN TO_CHAR(SYSDATE,'YYYYMMDD') <= PRD.SLS_TO_DT  AND TO_CHAR(SYSDATE,'YYYYMMDD') >= PRD.SLS_FM_DT" ).append("\n"); 
		query.append("				THEN 0" ).append("\n"); 
		query.append("				WHEN TO_CHAR(SYSDATE,'YYYYMMDD') > PRD.SLS_TO_DT   AND  PRD.SLS_FM_DT >=  KLIST.RDT_SLS_FM_DT AND  PRD.SLS_FM_DT <= KLIST.RDT_SLS_TO_DT    -- RDT.SLS_FM_DT AND  PRD.SLS_FM_DT <= RDT.SLS_TO_DT" ).append("\n"); 
		query.append("				THEN 1" ).append("\n"); 
		query.append("				ELSE 0" ).append("\n"); 
		query.append("		       END " ).append("\n"); 
		query.append("		  ) AS REFER_WK_CNT" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("	         (" ).append("\n"); 
		query.append("			 SELECT  /*+ NO_MERGE ORDERED */" ).append("\n"); 
		query.append("				      SDT.SLS_FM_DT  SDT_SLS_FM_DT," ).append("\n"); 
		query.append("				      SDT.SLS_TO_DT  SDT_SLS_TO_DT," ).append("\n"); 
		query.append("				      RDT.SLS_FM_DT  RDT_SLS_FM_DT," ).append("\n"); 
		query.append("				      RDT.SLS_TO_DT  RDT_SLS_TO_DT," ).append("\n"); 
		query.append("				      KLIST.*," ).append("\n"); 
		query.append("				      1  HASH_JOIN_KEY" ).append("\n"); 
		query.append("			  FROM    VW_SUMMARY_DT    SDT" ).append("\n"); 
		query.append("					, VW_REFERENCE_DT  RDT" ).append("\n"); 
		query.append("					, VW_CONTRACT_KEY  KLIST		" ).append("\n"); 
		query.append("		 )  KLIST 		" ).append("\n"); 
		query.append("		, PRI_SP_DUR DUR" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("			SELECT  /*+ NO_MERGE */" ).append("\n"); 
		query.append("			     SLS_FM_DT, SLS_TO_DT," ).append("\n"); 
		query.append("			     1  HASH_JOIN_KEY" ).append("\n"); 
		query.append("			  FROM   MAS_WK_PRD " ).append("\n"); 
		query.append("		 )  PRD 	    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	WHERE DUR.PROP_NO = KLIST.PROP_NO" ).append("\n"); 
		query.append("		AND DUR.AMDT_SEQ = KLIST.AMDT_SEQ" ).append("\n"); 
		query.append("		AND KLIST.HASH_JOIN_KEY = PRD.HASH_JOIN_KEY   " ).append("\n"); 
		query.append("		AND (" ).append("\n"); 
		query.append("				(	TO_CHAR(DUR.CTRT_EFF_DT,'YYYYMMDD') >= PRD.SLS_FM_DT " ).append("\n"); 
		query.append("					AND TO_CHAR(DUR.CTRT_EFF_DT,'YYYYMMDD') <= PRD.SLS_TO_DT	 " ).append("\n"); 
		query.append("				)  OR (   " ).append("\n"); 
		query.append("					TO_CHAR(DUR.CTRT_EXP_DT,'YYYYMMDD') >= PRD.SLS_FM_DT " ).append("\n"); 
		query.append("					AND TO_CHAR(DUR.CTRT_EXP_DT,'YYYYMMDD') <= PRD.SLS_TO_DT " ).append("\n"); 
		query.append("				) OR (" ).append("\n"); 
		query.append("					TO_CHAR(DUR.CTRT_EFF_DT,'YYYYMMDD') <= PRD.SLS_FM_DT " ).append("\n"); 
		query.append("					AND TO_CHAR(DUR.CTRT_EXP_DT,'YYYYMMDD')>= PRD.SLS_TO_DT	 " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		) " ).append("\n"); 
		query.append("                #if(${frm_contract_type} == 'B' || ${frm_contract_type} == 'S' )" ).append("\n"); 
		query.append("                        AND 1=1" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                        AND 1=0" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("	 GROUP BY KLIST.PROP_NO , KLIST.AMDT_SEQ,KLIST.SC_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- ACTUAL DATA 조회" ).append("\n"); 
		query.append("-- SUBSTR(SR_CST_DTL.PRS_YRMON,1,4)  || SR_CST_DTL.PRS_WK) 결합 INDEX 필요" ).append("\n"); 
		query.append(", VW_ACTUAL_VALUE AS (" ).append("\n"); 
		query.append("	SELECT  CKEY.SC_NO" ).append("\n"); 
		query.append("		, CKEY.PRC_CTRT_NO " ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1) )      AS LOAD            -- Load(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_RESPB_CM_UC_AMT)   AS COST_CM_OFFICE  -- Office Profit/ CM -- Cost(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_PFIT_CM_UC_AMT)    AS COST_CM_TRADE   --Trade Profit/ CM   -- Cost(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_RESPB_OPFIT_UC_AMT) AS COST_OP_OFFICE -- Office Profit/ OP -- Cost(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_RESPB_CMPB_AMT * ( CKEY.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1))   ) / SUM(CKEY.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1) )     AS CMPB_OFFICE     -- Office Profit/ CM -- CMPB(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_PFIT_CMPB_AMT * ( CKEY.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1))   ) / SUM(CKEY.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1) )       AS CMPB_TRADE      -- Trade Profit/ CM  -- CMPB(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1) * CKEY.PRS_RESPB_CMPB_AMT) AS CM_OFFICE -- Office Profit/ CM -- CM(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_CRNT_LOD_QTY   / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1)  * CKEY.PRS_PFIT_CMPB_AMT) AS CM_TRADE   -- Trade Profit/ CM  -- CM(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_RESPB_OPB_AMT * ( CKEY.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1))   ) / SUM(CKEY.PRS_CRNT_LOD_QTY  / DECODE(@[frm_pfmc_unit],'FEU',2,'TEU',1) )        AS OPB             -- Office Profit/ OP -- OPB(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.PRS_CRNT_LOD_QTY  * CKEY.PRS_RESPB_OPB_AMT) AS OP         -- OP(Previous)" ).append("\n"); 
		query.append("		, SUM(CKEY.TEU_FRT_REV )         AS G_REV            -- Gross Revenue(Previous)" ).append("\n"); 
		query.append("		, MAX(WK_PER_SC.ACTUAL_WK_CNT) AS WEEK_CNT" ).append("\n"); 
		query.append("	FROM VW_KEY_LIST CKEY " ).append("\n"); 
		query.append("		, VW_SUMMARY_WEEK WK" ).append("\n"); 
		query.append("		, VW_TOT_WEEK_PER_SC_NO WK_PER_SC" ).append("\n"); 
		query.append("	WHERE  CKEY.SC_NO = WK_PER_SC.SC_NO" ).append("\n"); 
		query.append("#if( ${frm_ori_rout_cd} != '' )" ).append("\n"); 
		query.append("		-- origin" ).append("\n"); 
		query.append("		AND CKEY.ORG_LOC_DEF_CD= @[frm_ori_rout_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${frm_dest_rout_cd} != '' )" ).append("\n"); 
		query.append("		-- DEST" ).append("\n"); 
		query.append("		AND CKEY.DEST_LOC_TP_CD= @[frm_dest_rout_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- BY CARGO TYPE" ).append("\n"); 
		query.append("#if (${crg_tp_str} != '' )" ).append("\n"); 
		query.append("		AND CKEY.PRC_CGO_TP_CD IN ( ${crg_tp_str} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		AND WK.WK_TP = -1" ).append("\n"); 
		query.append("		AND (SUBSTR(CKEY.PRS_YRMON,1,4)  || CKEY.PRS_WK) >= WK.SLS_FM_YRWK  AND (SUBSTR(CKEY.PRS_YRMON,1,4)  || CKEY.PRS_WK) <= WK.SLS_TO_YRWK  " ).append("\n"); 
		query.append("                #if(${frm_contract_type} == 'B' || ${frm_contract_type} == 'S' )" ).append("\n"); 
		query.append("                        AND 1=1" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                        AND 1=0" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("	GROUP BY CKEY.SC_NO, CKEY.PRC_CTRT_NO " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VW_RESULT AS (" ).append("\n"); 
		query.append("	SELECT  A_SC_NO                              " ).append("\n"); 
		query.append("		, A1_LOAD                       " ).append("\n"); 
		query.append("		, A1_COST_CM_OFFICE     " ).append("\n"); 
		query.append("		, A1_COST_CM_TRADE      " ).append("\n"); 
		query.append("		, A1_COST_OP_OFFICE     " ).append("\n"); 
		query.append("		, A1_CMPB_OFFICE        " ).append("\n"); 
		query.append("		, A1_CMPB_TRADE         " ).append("\n"); 
		query.append("		, A1_CM_OFFICE          " ).append("\n"); 
		query.append("		, A1_CM_TRADE           " ).append("\n"); 
		query.append("		, A1_OPB                 " ).append("\n"); 
		query.append("		, A1_OP                  " ).append("\n"); 
		query.append("		, A1_G_REV               " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, C.CUST_CNT_CD || TO_CHAR(C.CUST_SEQ,'FM000000') || ' - ' || C.CTRT_PTY_NM AS CUST_NM" ).append("\n"); 
		query.append("		, M.PROP_OFC_CD" ).append("\n"); 
		query.append("		, Q.FNL_MQC_QTY AS MQC_QTY" ).append("\n"); 
		query.append("		, C.CUST_CNT_CD || TO_CHAR(C.CUST_SEQ,'FM000000')  AS CUST_CD" ).append("\n"); 
		query.append("		, M.RESPB_SREP_CD" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT CKEY.SC_NO" ).append("\n"); 
		query.append("			, CKEY.PROP_NO" ).append("\n"); 
		query.append("			, CKEY.AMDT_SEQ" ).append("\n"); 
		query.append("			, CKEY.SC_NO AS A_SC_NO" ).append("\n"); 
		query.append("			, AVALUE.LOAD	 AS A1_LOAD" ).append("\n"); 
		query.append("			, AVALUE.COST_CM_OFFICE	 AS A1_COST_CM_OFFICE" ).append("\n"); 
		query.append("			, AVALUE.COST_CM_TRADE	 AS A1_COST_CM_TRADE" ).append("\n"); 
		query.append("			, AVALUE.COST_OP_OFFICE	 AS A1_COST_OP_OFFICE" ).append("\n"); 
		query.append("			, AVALUE.CMPB_OFFICE	 AS A1_CMPB_OFFICE" ).append("\n"); 
		query.append("			, AVALUE.CMPB_TRADE	 AS A1_CMPB_TRADE" ).append("\n"); 
		query.append("			, AVALUE.CM_OFFICE	 AS A1_CM_OFFICE" ).append("\n"); 
		query.append("			, AVALUE.CM_TRADE	 AS A1_CM_TRADE" ).append("\n"); 
		query.append("			, AVALUE.OPB		AS A1_OPB" ).append("\n"); 
		query.append("			, AVALUE.OP		AS A1_OP" ).append("\n"); 
		query.append("			, AVALUE.G_REV		AS A1_G_REV" ).append("\n"); 
		query.append("			, AVALUE.WEEK_CNT	 AS A1_WEEK_CNT" ).append("\n"); 
		query.append("		FROM VW_CONTRACT_KEY CKEY" ).append("\n"); 
		query.append("			, VW_ACTUAL_VALUE AVALUE" ).append("\n"); 
		query.append("		WHERE CKEY.SC_NO = AVALUE.SC_NO(+)" ).append("\n"); 
		query.append("                #if(${frm_contract_type} == 'B' || ${frm_contract_type} == 'S' )" ).append("\n"); 
		query.append("                        AND 1=1" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                        AND 1=0" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("	) MN" ).append("\n"); 
		query.append("	, PRI_SP_MN M" ).append("\n"); 
		query.append("	, PRI_SP_CTRT_PTY C" ).append("\n"); 
		query.append("	, PRI_SP_MQC Q" ).append("\n"); 
		query.append("	WHERE" ).append("\n"); 
		query.append("		 MN.PROP_NO = M.PROP_NO" ).append("\n"); 
		query.append("		AND MN.AMDT_SEQ = M.AMDT_SEQ" ).append("\n"); 
		query.append("		AND M.PROP_NO = C.PROP_NO " ).append("\n"); 
		query.append("		AND  M.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("		AND M.PROP_NO = Q.PROP_NO (+)" ).append("\n"); 
		query.append("		AND  M.AMDT_SEQ = Q.AMDT_SEQ(+)" ).append("\n"); 
		query.append("		AND C.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("                #if(${frm_contract_type} == 'B' || ${frm_contract_type} == 'S' )" ).append("\n"); 
		query.append("                        AND 1=1" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                        AND 1=0" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT TARGET_CODE" ).append("\n"); 
		query.append("	, CODE_TP_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT TARGET_CODE " ).append("\n"); 
		query.append("		, CASE WHEN @[grp_code] = 'PROP_OFC_CD' THEN" ).append("\n"); 
		query.append("				'A'" ).append("\n"); 
		query.append("				WHEN @[grp_code] = 'CUST_CD' THEN" ).append("\n"); 
		query.append("				'B'" ).append("\n"); 
		query.append("				WHEN @[grp_code] = 'RESPB_SREP_CD' THEN" ).append("\n"); 
		query.append("				'C'" ).append("\n"); 
		query.append("				ELSE" ).append("\n"); 
		query.append("				'D'" ).append("\n"); 
		query.append("		  END AS CODE_TP_CD" ).append("\n"); 
		query.append("		, RANK() OVER(ORDER BY ${rank_order} ) RN -- DESC 상위, ASC 하위" ).append("\n"); 
		query.append("		, COUNT(*) OVER () TOT_CNT" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			${grp_code} AS TARGET_CODE" ).append("\n"); 
		query.append("			,SUM(A1_LOAD) AS A1_LOAD" ).append("\n"); 
		query.append("			,DECODE(NVL(SUM(A1_LOAD),0),0,0, SUM(A1_OPB * A1_LOAD) / SUM(A1_LOAD) )  AS A1_OPB" ).append("\n"); 
		query.append("			,DECODE(NVL(SUM(A1_LOAD),0),0,0, SUM(A1_CMPB_OFFICE * A1_LOAD) / SUM(A1_LOAD) ) AS A1_CMPB_OFFICE" ).append("\n"); 
		query.append("			,DECODE(NVL(SUM(A1_LOAD),0),0,0, SUM(A1_CMPB_TRADE * A1_LOAD) / SUM(A1_LOAD)) AS A1_CMPB_TRADE" ).append("\n"); 
		query.append("			,SUM(A1_CM_OFFICE) AS A1_CM_OFFICE" ).append("\n"); 
		query.append("			,SUM(A1_CM_TRADE) AS A1_CM_TRADE" ).append("\n"); 
		query.append("			,SUM(A1_OP) AS A1_OP" ).append("\n"); 
		query.append("		FROM VW_RESULT " ).append("\n"); 
		query.append("		GROUP BY  ${grp_code}" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                --RFA" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			${grp_code} AS TARGET_CODE" ).append("\n"); 
		query.append("			,SUM(A1_LOAD) AS A1_LOAD" ).append("\n"); 
		query.append("			,DECODE(NVL(SUM(A1_LOAD),0),0,0, SUM(A1_OPB * A1_LOAD) / SUM(A1_LOAD) )  AS A1_OPB" ).append("\n"); 
		query.append("			,DECODE(NVL(SUM(A1_LOAD),0),0,0, SUM(A1_CMPB_OFFICE * A1_LOAD) / SUM(A1_LOAD) ) AS A1_CMPB_OFFICE" ).append("\n"); 
		query.append("			,DECODE(NVL(SUM(A1_LOAD),0),0,0, SUM(A1_CMPB_TRADE * A1_LOAD) / SUM(A1_LOAD)) AS A1_CMPB_TRADE" ).append("\n"); 
		query.append("			,SUM(A1_CM_OFFICE) AS A1_CM_OFFICE" ).append("\n"); 
		query.append("			,SUM(A1_CM_TRADE) AS A1_CM_TRADE" ).append("\n"); 
		query.append("			,SUM(A1_OP) AS A1_OP" ).append("\n"); 
		query.append("		FROM VW_RFA_RESULT " ).append("\n"); 
		query.append("		GROUP BY  ${grp_code}" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RN <= ${range_val}-- 보고싶은 RANGE" ).append("\n"); 
		query.append("ORDER BY  TARGET_CODE" ).append("\n"); 

	}
}