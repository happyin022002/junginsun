/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PreCMSimulationDBDAOSearchPreCMRemarkListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreCMSimulationDBDAOSearchPreCMRemarkListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    COA_MON_MISC_REV_PRE_TEU 테이블의 데이터 조회
	  * 2010.12.21 이윤정 [CHM-201007742-01] 미주 철도 냉동화물비용 반영요청
	  * 2011.01.11 이윤정 [CHM-201108216-01] NIBC, NOBC 요율 반영 로직 수정.TMFDFL 계정에 대해서 TMFDMT으로 변환하여 보여주는 부분을 제거.
	  * 2011.12.21 최윤성 [CHM-201115260-01] [COA] Pre CM/OP Simulation화면 U.I 변경요청 - LOC, NOD Chekc 로직 추가
	  * 2011.12.26 최윤성 [CSR전환중] [COA] Pre CM/OP Simulation화면 U.I변경건 Inquiry by BKG / Product Catalog Inquiry 동일 적용요청 - Full Transport Expense 조건 추가
	  * 2012.02.06 이석준 [CHM-201215969-01] CM2 적용
	  * 2012.07.30 최윤성 [CHM-201219111-01] AWK 에 대한 Remark 처리 조건 추가
	  * </pre>
	  */
	public PreCMSimulationDBDAOSearchPreCMRemarkListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cob_profit_lv",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cob_profit_vw",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.integration").append("\n"); 
		query.append("FileName : PreCMSimulationDBDAOSearchPreCMRemarkListRSQL").append("\n"); 
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
		query.append("SELECT	NOD_CD" ).append("\n"); 
		query.append("		,GRP" ).append("\n"); 
		query.append("		,STND_COST_CD" ).append("\n"); 
		query.append("		,DECODE(STND_COST_CD,'51701011','CM2 COST',STND_COST_NM) STND_COST_NM" ).append("\n"); 
		query.append("		,COA_COST_SRC_CD" ).append("\n"); 
		query.append("		,DECODE(STND_COST_CD,'51701011','CM2 COST('||COA_COST_SRC_NM||')',COA_COST_SRC_NM) COA_COST_SRC_NM" ).append("\n"); 
		query.append("		,AMT" ).append("\n"); 
		query.append("		,CTRT_RTN_FLG" ).append("\n"); 
		query.append("		,COST_CALC_RMK" ).append("\n"); 
		query.append("		,AVG_LVL_CHK" ).append("\n"); 
		query.append("		,VNDR" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	(	SELECT	'DEM/DET' NOD_CD" ).append("\n"); 
		query.append("				,2 COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("				,'' GRP" ).append("\n"); 
		query.append("				,'' STND_COST_CD" ).append("\n"); 
		query.append("				,'' STND_COST_NM" ).append("\n"); 
		query.append("				,'' COA_COST_SRC_CD" ).append("\n"); 
		query.append("				,'' COA_COST_SRC_NM" ).append("\n"); 
		query.append("				,ESTM_USD_TTL_AMT AMT" ).append("\n"); 
		query.append("				,DECODE(CTRT_RTN_FLG, 'Y', 'Contract', 'Average') CTRT_RTN_FLG" ).append("\n"); 
		query.append("				,REPLACE(COST_CALC_RMK, '>', '') COST_CALC_RMK" ).append("\n"); 
		query.append("				,'00' ACCT_DP_SEQ" ).append("\n"); 
		query.append("				,'N' AVG_LVL_CHK" ).append("\n"); 
		query.append("				,'' VNDR" ).append("\n"); 
		query.append("		FROM	COA_COM_COST_PARA" ).append("\n"); 
		query.append("		WHERE	PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("		AND		STND_COST_CD = '43201011'" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT	'Misc OP Rev' NOD_CD" ).append("\n"); 
		query.append("				,4 COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("				,'' GRP" ).append("\n"); 
		query.append("				,'' STND_COST_CD" ).append("\n"); 
		query.append("				,'' STND_COST_NM" ).append("\n"); 
		query.append("				,'' COA_COST_SRC_CD" ).append("\n"); 
		query.append("				,'' COA_COST_SRC_NM" ).append("\n"); 
		query.append("				,DECODE(IS_USE_TRD_UC, 'Y', TRD_UC_AMT * CNTR_TEU, RLANE_UC_AMT * CNTR_TEU) AMT" ).append("\n"); 
		query.append("				,'Average' CTRT_RTN_FLG" ).append("\n"); 
		query.append("				,CASE	WHEN IS_USE_TRD_UC = 'Y'" ).append("\n"); 
		query.append("						THEN 'MRI Trade ' || '('||TRD_CD||', '||DIR_CD||')' || ROUND(TRD_UC_AMT, 2) || '*' || CNTR_TEU || '(TEU)'" ).append("\n"); 
		query.append("						ELSE 'MRI Lane ' || '('||RLANE_CD||', '||DIR_CD||')' || ROUND(RLANE_UC_AMT, 2) || '*' || CNTR_TEU || '(TEU)'" ).append("\n"); 
		query.append("						END COST_CALC_RMK" ).append("\n"); 
		query.append("				,'00' ACCT_DP_SEQ" ).append("\n"); 
		query.append("				,'N' AVG_LVL_CHK" ).append("\n"); 
		query.append("				, VNDR" ).append("\n"); 
		query.append("		FROM " ).append("\n"); 
		query.append("			(	SELECT	A2.PCTL_NO" ).append("\n"); 
		query.append("						,A2.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("						,A2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("						,A2.CNTR_QTY" ).append("\n"); 
		query.append("						,DECODE(SUBSTR(A2.CNTR_TPSZ_CD, -1), '2', A2.CNTR_QTY, '3', A2.CNTR_QTY, A2.CNTR_QTY * 2) CNTR_TEU" ).append("\n"); 
		query.append("						,A3.REV_YRMON" ).append("\n"); 
		query.append("						,DECODE(NVL(A1.COST_ROUT_NO, 1), 1, A1.N1ST_TRD_CD, 2, A1.N2ND_TRD_CD, 3, A1.N3RD_TRD_CD, A1.N4TH_TRD_CD) TRD_CD --A3.TRD_CD" ).append("\n"); 
		query.append("						,DECODE(NVL(A1.COST_ROUT_NO, 1), 1, A1.N1ST_RLANE_CD, 2, A1.N2ND_RLANE_CD, 3, A1.N3RD_RLANE_CD, A1.N4TH_RLANE_CD) RLANE_CD --A3.RLANE_CD" ).append("\n"); 
		query.append("						,SUBSTR(DECODE(NVL(COST_ROUT_NO, 1), 1, A1.N1ST_FINC_VVD_CD, 2, A1.N2ND_FINC_VVD_CD, 3, A1.N3RD_FINC_VVD_CD, A1.N4TH_FINC_VVD_CD), -1) DIR_CD--A3.DIR_CD" ).append("\n"); 
		query.append("						,NVL(A3.TRD_UC_AMT, 0) TRD_UC_AMT" ).append("\n"); 
		query.append("						,NVL(A3.RLANE_UC_AMT, 0) RLANE_UC_AMT" ).append("\n"); 
		query.append("						,A3.IS_USE_TRD_UC" ).append("\n"); 
		query.append("						,'' VNDR" ).append("\n"); 
		query.append("				FROM	COA_COM_PARA A1" ).append("\n"); 
		query.append("						,COA_COM_COST_PARA A2" ).append("\n"); 
		query.append("					,(	SELECT	REV_YRMON" ).append("\n"); 
		query.append("								,TRD_CD" ).append("\n"); 
		query.append("								,RLANE_CD" ).append("\n"); 
		query.append("								,DIR_CD" ).append("\n"); 
		query.append("								,MAX(TRD_UC_AMT) TRD_UC_AMT" ).append("\n"); 
		query.append("								,MAX(RLANE_UC_AMT) RLANE_UC_AMT" ).append("\n"); 
		query.append("								,MAX(IS_USE_TRD_UC) IS_USE_TRD_UC" ).append("\n"); 
		query.append("						FROM " ).append("\n"); 
		query.append("							(	SELECT	REV_YRMON" ).append("\n"); 
		query.append("										,TRD_CD" ).append("\n"); 
		query.append("										,DIR_CD" ).append("\n"); 
		query.append("										,DECODE(RLANE_CD, 'XXXXX', NULL, RLANE_CD) RLANE_CD" ).append("\n"); 
		query.append("										,DECODE(RLANE_CD, 'XXXXX', ETC_UT_REV_AMT, 0) TRD_UC_AMT" ).append("\n"); 
		query.append("										,DECODE(RLANE_CD, 'XXXXX', 0, ETC_UT_REV_AMT) RLANE_UC_AMT" ).append("\n"); 
		query.append("										,CASE -- 단가가 100 이상이고 물량이 100 이하이면 TRD 단가 사용" ).append("\n"); 
		query.append("												WHEN ETC_UT_REV_AMT > 100 AND TRD_TTL_QTY < 100" ).append("\n"); 
		query.append("												THEN 'Y'" ).append("\n"); 
		query.append("												ELSE 'N'" ).append("\n"); 
		query.append("												END AS IS_USE_TRD_UC" ).append("\n"); 
		query.append("								FROM	COA_MON_MISC_REV_PRE_TEU" ).append("\n"); 
		query.append("								WHERE	REV_YRMON = COA_BZC_COST_YRMON_FNC('')" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						GROUP	BY REV_YRMON, TRD_CD, RLANE_CD, DIR_CD" ).append("\n"); 
		query.append("					) A3" ).append("\n"); 
		query.append("				WHERE	A1.PCTL_NO = A2.PCTL_NO" ).append("\n"); 
		query.append("				AND		A2.PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("				AND		a2.COA_COST_SRC_CD = '43201011'   --DEM/DET계정과 동일한 설정으로" ).append("\n"); 
		query.append("				AND		A3.REV_YRMON(+) = COA_BZC_COST_YRMON_FNC('')" ).append("\n"); 
		query.append("				AND		A3.TRD_CD(+) = DECODE(NVL(A1.COST_ROUT_NO, 1), 1, A1.N1ST_TRD_CD, 2, A1.N2ND_TRD_CD, 3, A1.N3RD_TRD_CD, A1.N4TH_TRD_CD )" ).append("\n"); 
		query.append("				AND		A3.RLANE_CD(+) = DECODE(NVL(A1.COST_ROUT_NO, 1)" ).append("\n"); 
		query.append("													,1, A1.N1ST_RLANE_CD" ).append("\n"); 
		query.append("													,2, A1.N2ND_RLANE_CD" ).append("\n"); 
		query.append("													,3, A1.N3RD_RLANE_CD" ).append("\n"); 
		query.append("													,A1.N4TH_RLANE_CD" ).append("\n"); 
		query.append("													)" ).append("\n"); 
		query.append("				AND		A3.DIR_CD(+) = SUBSTR(DECODE(NVL(COST_ROUT_NO, 1)" ).append("\n"); 
		query.append("													,1, A1.N1ST_FINC_VVD_CD" ).append("\n"); 
		query.append("													,2, A1.N2ND_FINC_VVD_CD" ).append("\n"); 
		query.append("													,3, A1.N3RD_FINC_VVD_CD" ).append("\n"); 
		query.append("													,A1.N4TH_FINC_VVD_CD ),-1) " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT	A4.NOD" ).append("\n"); 
		query.append("				,A1.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("				,COA_GET_COM_NM_FNC('cost_act_grp_cd', A1.COST_ACT_GRP_CD) GRP" ).append("\n"); 
		query.append("				,A1.STND_COST_CD" ).append("\n"); 
		query.append("				,A2.STND_COST_NM" ).append("\n"); 
		query.append("				,DECODE(A1.COA_COST_SRC_CD" ).append("\n"); 
		query.append("						,'92404011', A3.SLS_ACT_CD" ).append("\n"); 
		query.append("						,'65000000', A3.SLS_ACT_CD" ).append("\n"); 
		query.append("						,'65901011', A3.SLS_ACT_CD" ).append("\n"); 
		query.append("						,'65901021', A3.SLS_ACT_CD" ).append("\n"); 
		query.append("						,A1.COA_COST_SRC_CD ) COA_COST_SRC_CD -- 2011.01.11 이윤정 [CHM-201108216-01] TMFDFL 계정에 대해서 TMFDMT으로 변환하여 보여주는 부분을 제거." ).append("\n"); 
		query.append("				,DECODE(A1.COA_COST_SRC_CD" ).append("\n"); 
		query.append("						,'92404011', A3.SLS_ACT_CD_NM" ).append("\n"); 
		query.append("						,'65000000', A3.SLS_ACT_CD_NM" ).append("\n"); 
		query.append("						,'65901011', A3.SLS_ACT_CD_NM" ).append("\n"); 
		query.append("						,'65901021', A3.SLS_ACT_CD_NM" ).append("\n"); 
		query.append("						,'51102000', A2.STND_COST_NM   --MT의 경우 Standard name 으로" ).append("\n"); 
		query.append("						,'51302000', A2.STND_COST_NM   --MT의 경우 Standard name 으로				" ).append("\n"); 
		query.append("						,COA_GET_COM_NM_FNC('coa_cost_src_cd', A1.COA_COST_SRC_CD) ) COA_COST_SRC_NM -- 2011.01.11 이윤정 [CHM-201108216-01] TMFDFL 계정에 대해서 TMFDMT으로 변환하여 보여주는 부분을 제거." ).append("\n"); 
		query.append("				,DECODE(A1.COA_COST_SRC_CD" ).append("\n"); 
		query.append("						,'92404011', A3.SVC_TRNS_PRC_AMT" ).append("\n"); 
		query.append("						,'65000000', A3.SVC_TRNS_PRC_AMT" ).append("\n"); 
		query.append("						,'65901011', A3.SVC_TRNS_PRC_AMT" ).append("\n"); 
		query.append("						,'65901021', A3.SVC_TRNS_PRC_AMT" ).append("\n"); 
		query.append("						,DECODE(@[f_cob_profit_vw], 'P', A1.ESTM_USD_TTL_AMT, A1.RESPB_USD_TTL_AMT) ) AMT" ).append("\n"); 
		query.append("				,DECODE(A1.CTRT_RTN_FLG, 'Y', 'Contract', 'Average') CTRT_RTN_FLG" ).append("\n"); 
		query.append("				,CASE	WHEN REGEXP_LIKE(REPLACE(A1.COST_CALC_RMK,'(',''), '^>T[RE]S AVG-LOCSCOTAL') " ).append("\n"); 
		query.append("						THEN SUBSTR(A1.COST_CALC_RMK, 2, 20) || ' -> ' || ROUND(ESTM_USD_UC_AMT, 2) -- [CHM-201007742-01] 미주 철도 냉동화물비용 반영요청" ).append("\n"); 
		query.append("						WHEN REGEXP_LIKE(A1.COST_CALC_RMK, '^>T[RE]S AVG-')" ).append("\n"); 
		query.append("						THEN SUBSTR(A1.COST_CALC_RMK, 2, 12) || ' -> ' || ROUND(ESTM_USD_UC_AMT, 2)" ).append("\n"); 
		query.append("						WHEN REGEXP_LIKE(A1.COST_CALC_RMK, '^>AWK OOG-Qty')    -- 2012.07.30 최윤성 [CHM-201219111-01] AWK 에 대한 Remark 처리 조건 추가" ).append("\n"); 
		query.append("						THEN SUBSTR(A1.COST_CALC_RMK, 2, INSTR(A1.COST_CALC_RMK, '>T') + 10 ) || ' -> ' || ROUND(ESTM_USD_UC_AMT, 2)						" ).append("\n"); 
		query.append("						ELSE DECODE(A1.COA_COST_SRC_CD" ).append("\n"); 
		query.append("									,'51601011', SUBSTR(A1.COST_CALC_RMK, 2)   -- Volume Discount" ).append("\n"); 
		query.append("									,'92404011', A3.COST_CALC_RMK   --ABC/STP" ).append("\n"); 
		query.append("									,'65000000', A3.COST_CALC_RMK   --ABC/STP" ).append("\n"); 
		query.append("									,'65901011', A3.COST_CALC_RMK   --ABC/STP" ).append("\n"); 
		query.append("									,'65901021', A3.COST_CALC_RMK   --ABC/STP" ).append("\n"); 
		query.append("									,'92202011', REPLACE(REPLACE(A1.COST_CALC_RMK, ', RepoPOR', ', RepoPOR'), ', CNTREQ', ', CNTREQ')   --EMU EQ" ).append("\n"); 
		query.append("									,'92202012', REPLACE(A1.COST_CALC_RMK, ', Direction=', ', Direction=')   --EMU SIM" ).append("\n"); 
		query.append("									,REPLACE(A1.COST_CALC_RMK, '>TP', 'TP') )" ).append("\n"); 
		query.append("						END AS COST_CALC_RMK" ).append("\n"); 
		query.append("				,ACCT_DP_SEQ" ).append("\n"); 
		query.append("				,CASE WHEN REGEXP_LIKE(A1.COST_CALC_RMK, 'AVG-SCC|AVG-ECC|AVG-LCC|AVG-RCC') AND A2.SGRP_COST_CD = 'CVTR'" ).append("\n"); 
		query.append("									THEN 'Y'" ).append("\n"); 
		query.append("									ELSE 'N'" ).append("\n"); 
		query.append("				  END AS AVG_LVL_CHK" ).append("\n"); 
		query.append("				, DECODE(A1.CTRT_RTN_FLG,'Y', VNDR) VNDR" ).append("\n"); 
		query.append("		FROM	COA_COM_COST_PARA A1" ).append("\n"); 
		query.append("				,COA_STND_ACCT_V A2" ).append("\n"); 
		query.append("			,(	SELECT	B1.PCTL_NO" ).append("\n"); 
		query.append("						,DECODE(B1.RA_ACCT_CD" ).append("\n"); 
		query.append("								,'91401011', '92404011'" ).append("\n"); 
		query.append("								,'65901011', DECODE(@[f_cob_profit_vw], 'P', '65000000', '65901011')" ).append("\n"); 
		query.append("								,'65901021', DECODE(@[f_cob_profit_vw], 'P', '65000000', '65901021')" ).append("\n"); 
		query.append("								,B1.RA_ACCT_CD ) COA_COST_SRC_CD   --STP Income을 STP Cost로" ).append("\n"); 
		query.append("						,B1.COND_OFC_CD" ).append("\n"); 
		query.append("						,B1.SLS_ACT_CD" ).append("\n"); 
		query.append("						,B2.SLS_ACT_DESC SLS_ACT_CD_NM" ).append("\n"); 
		query.append("						,B1.SVC_TRNS_PRC_AMT" ).append("\n"); 
		query.append("						,B1.COST_CALC_RMK" ).append("\n"); 
		query.append("				FROM	COA_COM_SVC_TRNS_PRC_PARA B1, COA_OFC_ROUT_MAPG B2" ).append("\n"); 
		query.append("				WHERE	B1.SLS_ACT_CD = B2.SLS_ACT_CD" ).append("\n"); 
		query.append("				AND		B1.OFC_CLSS_CD = B2.OFC_CLSS_CD" ).append("\n"); 
		query.append("				AND		B2.COST_YRMON = COA_BZC_COST_YRMON_FNC('')" ).append("\n"); 
		query.append("				AND		PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("			) A3" ).append("\n"); 
		query.append("			,(	SELECT	DISTINCT COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("						,COST_ACT_GRP_CD" ).append("\n"); 
		query.append("						,N1ST_NOD_CD ORG_NOD_CD" ).append("\n"); 
		query.append("						,COALESCE(N4TH_NOD_CD, N3RD_NOD_CD, N2ND_NOD_CD) DEST_NOD_CD" ).append("\n"); 
		query.append("						,DECODE(N1ST_NOD_CD" ).append("\n"); 
		query.append("								,N2ND_NOD_CD, N1ST_NOD_CD" ).append("\n"); 
		query.append("								, DECODE(N1ST_NOD_CD, NULL, ' ', N1ST_NOD_CD)" ).append("\n"); 
		query.append("								|| DECODE(N2ND_NOD_CD, NULL, ' ', ' -> ' || N2ND_NOD_CD)" ).append("\n"); 
		query.append("								|| DECODE(N3RD_NOD_CD, NULL, ' ', ' -> ' || N3RD_NOD_CD)" ).append("\n"); 
		query.append("								|| DECODE(N4TH_NOD_CD, NULL, ' ', ' -> ' || N4TH_NOD_CD) ) NOD" ).append("\n"); 
		query.append("				FROM	COA_COM_COST_PARA" ).append("\n"); 
		query.append("				WHERE	PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("			) A4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              , (SELECT COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                      , COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                      , ORG_NOD_CD" ).append("\n"); 
		query.append("                      , DEST_NOD_CD" ).append("\n"); 
		query.append("                      , NOD" ).append("\n"); 
		query.append("                      , WM_CONCAT(DISTINCT  VNDR_SEQ) VNDR" ).append("\n"); 
		query.append("                   FROM ( SELECT DISTINCT COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                              , COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                              , N1ST_NOD_CD ORG_NOD_CD" ).append("\n"); 
		query.append("                              , COALESCE(N4TH_NOD_CD, N3RD_NOD_CD, N2ND_NOD_CD) DEST_NOD_CD" ).append("\n"); 
		query.append("                              , DECODE(N1ST_NOD_CD" ).append("\n"); 
		query.append("                                       , N2ND_NOD_CD" ).append("\n"); 
		query.append("                                       , N1ST_NOD_CD" ).append("\n"); 
		query.append("                                       , DECODE(N1ST_NOD_CD, NULL, ' ', N1ST_NOD_CD) " ).append("\n"); 
		query.append("                                         || DECODE(N2ND_NOD_CD, NULL, ' ', ' -> ' || N2ND_NOD_CD) " ).append("\n"); 
		query.append("                                         || DECODE(N3RD_NOD_CD, NULL, ' ', ' -> ' || N3RD_NOD_CD) " ).append("\n"); 
		query.append("                                         || DECODE(N4TH_NOD_CD, NULL, ' ', ' -> ' || N4TH_NOD_CD) ) NOD" ).append("\n"); 
		query.append("                              , DECODE(B.NO,1, N1ST_VNDR_SEQ,2,N2ND_VNDR_SEQ,3,N3RD_VNDR_SEQ,4,N4TH_VNDR_SEQ,5,N5TH_VNDR_SEQ) VNDR_SEQ" ).append("\n"); 
		query.append("                           FROM COA_COM_COST_PARA A" ).append("\n"); 
		query.append("                              , (SELECT LEVEL NO FROM dual CONNECT BY LEVEL <= 5) B" ).append("\n"); 
		query.append("                          WHERE PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                   GROUP BY COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                      , COST_ACT_GRP_CD" ).append("\n"); 
		query.append("                      , ORG_NOD_CD" ).append("\n"); 
		query.append("                      , DEST_NOD_CD" ).append("\n"); 
		query.append("                      , NOD" ).append("\n"); 
		query.append("                ) A5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		WHERE	A1.PCTL_NO = @[f_pctl_no]" ).append("\n"); 
		query.append("		AND		COA_COST_SRC_PRT_CD IN(DECODE(@[f_cob_profit_lv], 'C', 'CO', 'CO'), DECODE(@[f_cob_profit_vw], 'P', 'PA', 'RA'))   --COA_COST_SRC_PRT_CD:R,P" ).append("\n"); 
		query.append("		AND		STND_COST_TP_CD IN('C', DECODE(@[f_cob_profit_lv], 'C', 'C', 'M', 'C','O'))   --STND_COST_TP_CD:C,O" ).append("\n"); 
		query.append("		AND		A1.STND_COST_CD = A2.STND_COST_CD" ).append("\n"); 
		query.append("		AND		A2.PA_VW = 'BKG'" ).append("\n"); 
		query.append("#if (${f_cob_profit_lv} != 'M') " ).append("\n"); 
		query.append("		AND 	A1.STND_COST_CD <> '51701011'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		AND		A1.COA_COST_SRC_CD = A3.COA_COST_SRC_CD(+)" ).append("\n"); 
		query.append("		AND		A1.COST_ACT_GRP_SEQ = A4.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("		AND     A1.COST_ACT_GRP_SEQ = A5.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("		AND	(	A1.ESTM_USD_TTL_AMT <> 0 OR A1.RESPB_USD_TTL_AMT <> 0 OR A3.SVC_TRNS_PRC_AMT <> 0)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("ORDER	BY COST_ACT_GRP_SEQ, ACCT_DP_SEQ, 5, 9" ).append("\n"); 

	}
}