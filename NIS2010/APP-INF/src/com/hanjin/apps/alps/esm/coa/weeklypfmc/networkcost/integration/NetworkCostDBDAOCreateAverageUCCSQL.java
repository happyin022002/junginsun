/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOCreateAverageUCCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.21
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.07.21 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOCreateAverageUCCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * --Average UC단가를 생성
	  * History-------------------------------
	  * 2010.11.08 이행지 [CHM-201006375-01] Trunk IPC와 Ocean간 내부거래 신규 추가로 인한 계정은 제외되어서 생성되도록 수정
	  *                          [CHM-201007231-01] - 생성로직에서 OP_LANE_TP_CD Group by에 포함되도록 수정
	  * </pre>
	  */
	public NetworkCostDBDAOCreateAverageUCCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOCreateAverageUCCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_OP_AVG_UT_COST" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	COST_YRMON" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , STND_COST_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , COST_USE_TP_CD" ).append("\n"); 
		query.append("      , OP_UC_AMT" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" SELECT COST_YRMON" ).append("\n"); 
		query.append("      , TRD_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , DECODE(B.NO, 1, '43102011', 2, '53101000', 3, '53102000', 4, '53200000', 5, '54100000'" ).append("\n"); 
		query.append("                   , 6, '54250000', 7, '54300000', 8, '54200000', 9, '54150000', 10 , '54450000'" ).append("\n"); 
		query.append("		   , 11, '54180000', 12, '54550000', 13, '54350000', 14, '54400000') STND_COST_CD" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , 'A' COST_USE_TP_CD" ).append("\n"); 
		query.append("      , DECODE(B.NO, 1, SPC_INCOME, 2, AMT_01, 3, AMT_02, 4, AMT_03, 5, AMT_04" ).append("\n"); 
		query.append("                   , 6, AMT_05, 7, AMT_06, 8, AMT_07, 9, AMT_08, 10 , AMT_09" ).append("\n"); 
		query.append("		   , 11, AMT_10, 12, AMT_11, 13, AMT_12, 14, AMT_13) OP_UC_AMT" ).append("\n"); 
		query.append("      , @[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE CRE_DT" ).append("\n"); 
		query.append("      , @[cre_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE UPD_DT" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        --5단계" ).append("\n"); 
		query.append("        --'Trade' / 'Lane' / 'BD별' 최종 단가를 생성. 이 단가는 2,3,4 계산 과정을 통해 해당 노선의 1Cycle에 대한 선박별 가중치가 반영되어 있는 단가." ).append("\n"); 
		query.append("        --이렇게 만들어진 해당 R.Month의 단가를 각 PFMC 주차 VVD의 BSA에 곱해주어 계정별 수입/비용 생성. 이후 과정 동일" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         SELECT COST_YRMON" ).append("\n"); 
		query.append("              , TRD_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("              , FREQ_NO" ).append("\n"); 
		query.append("              , HJS_BSA_CAPA" ).append("\n"); 
		query.append("              , DECODE(HJS_BSA_CAPA, 0, 0, SPC_INCOME / HJS_BSA_CAPA) AS SPC_INCOME" ).append("\n"); 
		query.append("              , DECODE(HJS_BSA_CAPA, 0, 0, AMT_01 / HJS_BSA_CAPA)     AS AMT_01" ).append("\n"); 
		query.append("              , DECODE(HJS_BSA_CAPA, 0, 0, AMT_02 / HJS_BSA_CAPA)     AS AMT_02" ).append("\n"); 
		query.append("              , DECODE(HJS_BSA_CAPA, 0, 0, AMT_03 / HJS_BSA_CAPA)     AS AMT_03" ).append("\n"); 
		query.append("              , DECODE(HJS_BSA_CAPA, 0, 0, AMT_04 / HJS_BSA_CAPA)     AS AMT_04" ).append("\n"); 
		query.append("              , DECODE(HJS_BSA_CAPA, 0, 0, AMT_05 / HJS_BSA_CAPA)     AS AMT_05" ).append("\n"); 
		query.append("              , DECODE(HJS_BSA_CAPA, 0, 0, AMT_06 / HJS_BSA_CAPA)     AS AMT_06" ).append("\n"); 
		query.append("              , DECODE(HJS_BSA_CAPA, 0, 0, AMT_07 / HJS_BSA_CAPA)     AS AMT_07" ).append("\n"); 
		query.append("              , DECODE(HJS_BSA_CAPA, 0, 0, AMT_08 / HJS_BSA_CAPA)     AS AMT_08" ).append("\n"); 
		query.append("              , DECODE(HJS_BSA_CAPA, 0, 0, AMT_09 / HJS_BSA_CAPA)     AS AMT_09" ).append("\n"); 
		query.append("              , DECODE(HJS_BSA_CAPA, 0, 0, AMT_10 / HJS_BSA_CAPA)     AS AMT_10" ).append("\n"); 
		query.append("              , DECODE(HJS_BSA_CAPA, 0, 0, AMT_11 / HJS_BSA_CAPA)     AS AMT_11" ).append("\n"); 
		query.append("              , DECODE(HJS_BSA_CAPA, 0, 0, AMT_12 / HJS_BSA_CAPA)     AS AMT_12" ).append("\n"); 
		query.append("              , DECODE(HJS_BSA_CAPA, 0, 0, AMT_13 / HJS_BSA_CAPA)     AS AMT_13" ).append("\n"); 
		query.append("           FROM" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                --4단계" ).append("\n"); 
		query.append("                --3번 계산 과정까지 하여," ).append("\n"); 
		query.append("                --1Cycle에 대한, 개별 노선들의 선박별 가중치 반영 작업을 완료.  Pivot을 통하여 mix 하는 과정임" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 SELECT COST_YRMON" ).append("\n"); 
		query.append("                      , TRD_CD" ).append("\n"); 
		query.append("                      , RLANE_CD" ).append("\n"); 
		query.append("                      , DIR_CD" ).append("\n"); 
		query.append("                      , SUM(FREQ_NO)      AS FREQ_NO" ).append("\n"); 
		query.append("                      , SUM(HJS_BSA_CAPA) AS HJS_BSA_CAPA" ).append("\n"); 
		query.append("                      , SUM(SPC_INCOME)   AS SPC_INCOME" ).append("\n"); 
		query.append("                      , SUM(AMT_01)       AS AMT_01" ).append("\n"); 
		query.append("                      , SUM(AMT_02)       AS AMT_02" ).append("\n"); 
		query.append("                      , SUM(AMT_03)       AS AMT_03" ).append("\n"); 
		query.append("                      , SUM(AMT_04)       AS AMT_04" ).append("\n"); 
		query.append("                      , SUM(AMT_05)       AS AMT_05" ).append("\n"); 
		query.append("                      , SUM(AMT_06)       AS AMT_06" ).append("\n"); 
		query.append("                      , SUM(AMT_07)       AS AMT_07" ).append("\n"); 
		query.append("                      , SUM(AMT_08)       AS AMT_08" ).append("\n"); 
		query.append("                      , SUM(AMT_09)       AS AMT_09" ).append("\n"); 
		query.append("                      , SUM(AMT_10)       AS AMT_10" ).append("\n"); 
		query.append("                      , SUM(AMT_11)       AS AMT_11" ).append("\n"); 
		query.append("                      , SUM(AMT_12)       AS AMT_12" ).append("\n"); 
		query.append("                      , SUM(AMT_13)       AS AMT_13" ).append("\n"); 
		query.append("                   FROM" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        --3단계" ).append("\n"); 
		query.append("                        --2번 계산 과정에서 1척당 비용을 구했으니, 기존에 입력해 두었던 선박척수 Table의 정보와 매칭하여" ).append("\n"); 
		query.append("                        --1 Cycle당 수입 / 비용을 구할 수가 있다." ).append("\n"); 
		query.append("                        --예를 들어, TPS-AWHTP노선의 경우 'OWN'과 'CHT' 두 Type의 선박이 투입되며, OWN 7척 / CHT 3척하여 총 10척이 1Cycle을 이룬다고 선박척수 Table에 입력해 놓음." ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         SELECT A.COST_YRMON" ).append("\n"); 
		query.append("                              , A.TRD_CD" ).append("\n"); 
		query.append("                              , A.RLANE_CD" ).append("\n"); 
		query.append("                              , A.DIR_CD" ).append("\n"); 
		query.append("                              , A.VSL_OSHP_CD" ).append("\n"); 
		query.append("                              , B.FREQ_NO" ).append("\n"); 
		query.append("                              , (A.HJS_BSA_CAPA * B.FREQ_NO) AS HJS_BSA_CAPA" ).append("\n"); 
		query.append("                              , (A.SPC_INCOME * B.FREQ_NO)   AS SPC_INCOME" ).append("\n"); 
		query.append("                              , (A.AMT_01 * B.FREQ_NO)       AS AMT_01" ).append("\n"); 
		query.append("                              , (A.AMT_02 * B.FREQ_NO)       AS AMT_02" ).append("\n"); 
		query.append("                              , (A.AMT_03 * B.FREQ_NO)       AS AMT_03" ).append("\n"); 
		query.append("                              , (A.AMT_04 * B.FREQ_NO)       AS AMT_04" ).append("\n"); 
		query.append("                              , (A.AMT_05 * B.FREQ_NO)       AS AMT_05" ).append("\n"); 
		query.append("                              , (A.AMT_06 * B.FREQ_NO)       AS AMT_06" ).append("\n"); 
		query.append("                              , (A.AMT_07 * B.FREQ_NO)       AS AMT_07" ).append("\n"); 
		query.append("                              , (A.AMT_08 * B.FREQ_NO)       AS AMT_08" ).append("\n"); 
		query.append("                              , (A.AMT_09 * B.FREQ_NO)       AS AMT_09" ).append("\n"); 
		query.append("                              , (A.AMT_10 * B.FREQ_NO)       AS AMT_10" ).append("\n"); 
		query.append("                              , (A.AMT_11 * B.FREQ_NO)       AS AMT_11" ).append("\n"); 
		query.append("                              , (A.AMT_12 * B.FREQ_NO)       AS AMT_12" ).append("\n"); 
		query.append("                              , (A.AMT_13 * B.FREQ_NO)       AS AMT_13" ).append("\n"); 
		query.append("                           FROM" ).append("\n"); 
		query.append("                                (" ).append("\n"); 
		query.append("                                --2단계" ).append("\n"); 
		query.append("                                --1번 계산 과정에서 확보한 확보한 해당 기간동안의 모든 수입 비용을 가지고" ).append("\n"); 
		query.append("                                --'Trade별' / 'Lane별' / 'Bound별' / 'Vessel Type별' 1척당 비용을 계산한다. 해당 기간 동안의 선박척수 (BSA가 0이 아닌 선박척수) 로 나누어 주면 됨" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                 SELECT COST_YRMON" ).append("\n"); 
		query.append("                                      , TRD_CD" ).append("\n"); 
		query.append("                                      , RLANE_CD" ).append("\n"); 
		query.append("                                      , DIR_CD" ).append("\n"); 
		query.append("                                      , VSL_OSHP_CD" ).append("\n"); 
		query.append("                                      , (HJS_BSA_CAPA / CNT) AS HJS_BSA_CAPA" ).append("\n"); 
		query.append("                                      , (CNT / CNT)          AS CNT" ).append("\n"); 
		query.append("                                      , (SPC_INCOME / CNT)   AS SPC_INCOME" ).append("\n"); 
		query.append("                                      , (AMT_01 / CNT)       AS AMT_01" ).append("\n"); 
		query.append("                                      , (AMT_02 / CNT)       AS AMT_02" ).append("\n"); 
		query.append("                                      , (AMT_03 / CNT)       AS AMT_03" ).append("\n"); 
		query.append("                                      , (AMT_04 / CNT)       AS AMT_04" ).append("\n"); 
		query.append("                                      , (AMT_05 / CNT)       AS AMT_05" ).append("\n"); 
		query.append("                                      , (AMT_06 / CNT)       AS AMT_06" ).append("\n"); 
		query.append("                                      , (AMT_07 / CNT)       AS AMT_07" ).append("\n"); 
		query.append("                                      , (AMT_08 / CNT)       AS AMT_08" ).append("\n"); 
		query.append("                                      , (AMT_09 / CNT)       AS AMT_09" ).append("\n"); 
		query.append("                                      , (AMT_10 / CNT)       AS AMT_10" ).append("\n"); 
		query.append("                                      , (AMT_11 / CNT)       AS AMT_11" ).append("\n"); 
		query.append("                                      , (AMT_12 / CNT)       AS AMT_12" ).append("\n"); 
		query.append("                                      , (AMT_13 / CNT)       AS AMT_13" ).append("\n"); 
		query.append("                                   FROM" ).append("\n"); 
		query.append("                                        (SELECT COST_YRMON" ).append("\n"); 
		query.append("                                              , TRD_CD" ).append("\n"); 
		query.append("                                              , RLANE_CD" ).append("\n"); 
		query.append("                                              , DIR_CD" ).append("\n"); 
		query.append("                                              , VSL_OSHP_CD" ).append("\n"); 
		query.append("                                              , SUM(FNL_HJS_BSA_CAPA) AS HJS_BSA_CAPA" ).append("\n"); 
		query.append("                                              -- 1cycle의 척수 " ).append("\n"); 
		query.append("                                              , COUNT(*) CNT" ).append("\n"); 
		query.append("                                              , SUM(SPC_INCOME) SPC_INCOME" ).append("\n"); 
		query.append("                                              , SUM(AMT_01 ) AS AMT_01" ).append("\n"); 
		query.append("                                              , SUM(AMT_02)  AS AMT_02" ).append("\n"); 
		query.append("                                              , SUM(AMT_03)  AS AMT_03" ).append("\n"); 
		query.append("                                              , SUM(AMT_04)  AS AMT_04" ).append("\n"); 
		query.append("                                              , SUM(AMT_05)  AS AMT_05" ).append("\n"); 
		query.append("                                              , SUM(AMT_06)  AS AMT_06" ).append("\n"); 
		query.append("                                              , SUM(AMT_07)  AS AMT_07" ).append("\n"); 
		query.append("                                              , SUM(AMT_08)  AS AMT_08" ).append("\n"); 
		query.append("                                              , SUM(AMT_09)  AS AMT_09" ).append("\n"); 
		query.append("                                              , SUM(AMT_10)  AS AMT_10" ).append("\n"); 
		query.append("                                              , SUM(AMT_11)  AS AMT_11" ).append("\n"); 
		query.append("                                              , SUM(AMT_12)  AS AMT_12" ).append("\n"); 
		query.append("                                              , SUM(AMT_13)  AS AMT_13" ).append("\n"); 
		query.append("                                           FROM" ).append("\n"); 
		query.append("                                                (" ).append("\n"); 
		query.append("                                                -- 1단계:" ).append("\n"); 
		query.append("                                                -- Create Lane Table에서 지정한 OP4 단가 생성 대상 노선들 (Lane Avg U/C) 의 / Create시 지정한 WK 에 해당하는 HJS Sales Cht/Out의 모든 Data를 긁어온다." ).append("\n"); 
		query.append("                                                -- 단, Final HJS BSA가 0인 VVD는 대상에서 제외한다. 비용이 들어있어도 제외한다. 그랬을 시 아래와 같은 모양새의  Data 확보 완료." ).append("\n"); 
		query.append("                                                -- 'Trade별' / 'Lane별' / 'Bound별' / Operator ('Vessel Type별')" ).append("\n"); 
		query.append("                                                -- '1번 계산 과정'의 하기 Raw Data를 OP4 단가 메인 화면의 Raw Data Down을 누르면 다운받을 수 있게 함. " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                 SELECT REPLACE(@[f_cost_yrmon],'-','') AS COST_YRMON" ).append("\n"); 
		query.append("                                                      , A.COST_WK" ).append("\n"); 
		query.append("                                                      , A.TRD_CD" ).append("\n"); 
		query.append("                                                      , A.RLANE_CD" ).append("\n"); 
		query.append("                                                      , A.VSL_CD" ).append("\n"); 
		query.append("                                                      , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                      , A.DIR_CD" ).append("\n"); 
		query.append("                                                      , NVL(V.VSL_OSHP_CD, 'OTH') VSL_OSHP_CD" ).append("\n"); 
		query.append("                                                      , B.FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("                                                      , NVL(B.INCM_BZC_CHTR_AMT, 0)+NVL(B.INCM_SUB_CHTR_AMT, 0)+NVL(B.INCM_CRS_CHTR_AMT, 0) AS SPC_INCOME --Space Charter Revenue" ).append("\n"); 
		query.append("                                                      , C.AMT_01" ).append("\n"); 
		query.append("                                                      , C.AMT_02" ).append("\n"); 
		query.append("                                                      , C.AMT_03" ).append("\n"); 
		query.append("                                                      , C.AMT_04" ).append("\n"); 
		query.append("                                                      , C.AMT_05" ).append("\n"); 
		query.append("                                                      , C.AMT_06" ).append("\n"); 
		query.append("                                                      , C.AMT_07" ).append("\n"); 
		query.append("                                                      , C.AMT_08" ).append("\n"); 
		query.append("                                                      , C.AMT_09" ).append("\n"); 
		query.append("                                                      , C.AMT_10" ).append("\n"); 
		query.append("                                                      , C.AMT_11" ).append("\n"); 
		query.append("                                                      , C.AMT_12" ).append("\n"); 
		query.append("                                                      , C.AMT_13" ).append("\n"); 
		query.append("                                                   FROM COA_MON_VVD A" ).append("\n"); 
		query.append("                                                      , BSA_VVD_MST B" ).append("\n"); 
		query.append("                                                      , (SELECT A1.TRD_CD                                                         AS TRD_CD" ).append("\n"); 
		query.append("                                                              , A1.RLANE_CD                                                       AS RLANE_CD" ).append("\n"); 
		query.append("                                                              , A1.IOC_CD                                                         AS IOC_CD" ).append("\n"); 
		query.append("                                                              , A1.VSL_CD                                                         AS VSL_CD" ).append("\n"); 
		query.append("                                                              , A1.SKD_VOY_NO                                                     AS SKD_VOY_NO" ).append("\n"); 
		query.append("                                                              , A1.DIR_CD                                                         AS DIR_CD" ).append("\n"); 
		query.append("                                                              , SUM(TS_UC_AMT)                                                    AS TS_UC_AMT" ).append("\n"); 
		query.append("                                                              , SUM(DECODE(A1.STND_COST_CD, '53101000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_01" ).append("\n"); 
		query.append("                                                              , SUM(DECODE(A1.STND_COST_CD, '53102000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_02" ).append("\n"); 
		query.append("                                                              , SUM(DECODE(A1.STND_COST_CD, '53200000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_03" ).append("\n"); 
		query.append("                                                              , SUM(DECODE(A1.STND_COST_CD, '54100000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_04" ).append("\n"); 
		query.append("                                                              , SUM(DECODE(A1.STND_COST_CD, '54250000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_05" ).append("\n"); 
		query.append("                                                              , SUM(DECODE(A1.STND_COST_CD, '54300000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_06" ).append("\n"); 
		query.append("                                                              , SUM(DECODE(A1.STND_COST_CD, '54200000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_07" ).append("\n"); 
		query.append("                                                              , SUM(DECODE(A1.STND_COST_CD, '54150000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_08" ).append("\n"); 
		query.append("                                                              , SUM(DECODE(A1.STND_COST_CD, '54450000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_09" ).append("\n"); 
		query.append("                                                              , SUM(DECODE(A1.STND_COST_CD, '54180000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_10" ).append("\n"); 
		query.append("                                                              , SUM(DECODE(A1.STND_COST_CD, '54550000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_11" ).append("\n"); 
		query.append("                                                              , SUM(DECODE(A1.STND_COST_CD, '54350000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_12" ).append("\n"); 
		query.append("                                                              , SUM(DECODE(A1.STND_COST_CD, '54400000', A1.NTWK_HIR_COST_AMT, 0)) AS AMT_13" ).append("\n"); 
		query.append("                                                           FROM COA_VVD_HIR A1" ).append("\n"); 
		query.append("                                                       GROUP BY A1.TRD_CD" ).append("\n"); 
		query.append("                                                              , A1.RLANE_CD" ).append("\n"); 
		query.append("                                                              , A1.IOC_CD" ).append("\n"); 
		query.append("                                                              , A1.VSL_CD" ).append("\n"); 
		query.append("                                                              , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                              , A1.DIR_CD" ).append("\n"); 
		query.append("                                                        ) C" ).append("\n"); 
		query.append("                                                      , COA_LANE_RGST R" ).append("\n"); 
		query.append("                                                      , COA_VSL_RGST V" ).append("\n"); 
		query.append("                                                  WHERE A.TRD_CD     = B.TRD_CD" ).append("\n"); 
		query.append("                                                    AND A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("                                                    AND A.IOC_CD     = B.IOC_CD" ).append("\n"); 
		query.append("                                                    AND A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("                                                    AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                    AND A.DIR_CD     = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                    AND A.TRD_CD     = C.TRD_CD" ).append("\n"); 
		query.append("                                                    AND A.RLANE_CD   = C.RLANE_CD" ).append("\n"); 
		query.append("                                                    AND A.IOC_CD     = C.IOC_CD" ).append("\n"); 
		query.append("                                                    AND A.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("                                                    AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                    AND A.DIR_CD     = C.DIR_CD" ).append("\n"); 
		query.append("                                                    AND A.TRD_CD     = R.TRD_CD" ).append("\n"); 
		query.append("                                                    AND A.RLANE_CD   = R.RLANE_CD" ).append("\n"); 
		query.append("                                                    AND A.IOC_CD     = R.IOC_CD" ).append("\n"); 
		query.append("                                                    AND A.DIR_CD     = R.DIR_CD" ).append("\n"); 
		query.append("                                                    AND R.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                                                    --   AND R.OP_LANE_TP_CD      = 'LA' -- Lane Avg U/C -> 배부시에 적용" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                    AND A.VSL_CD   = V.VSL_CD(+)" ).append("\n"); 
		query.append("                                                    AND V.LST_FLG(+)  = 'Y'" ).append("\n"); 
		query.append("                                                    AND V.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("                                                    AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                    AND SUBSTR(A.SLS_YRMON,1,4)||A.COST_WK BETWEEN REPLACE(@[f_fm_yrwk],'-','') AND REPLACE(@[f_to_yrwk],'-','')" ).append("\n"); 
		query.append("                                                    AND B.FNL_HJS_BSA_CAPA > 0" ).append("\n"); 
		query.append("                                                    AND A.SUB_TRD_CD <> 'IP'" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                                       GROUP BY COST_YRMON" ).append("\n"); 
		query.append("                                              , TRD_CD" ).append("\n"); 
		query.append("                                              , RLANE_CD" ).append("\n"); 
		query.append("                                              , DIR_CD" ).append("\n"); 
		query.append("                                              , VSL_OSHP_CD" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                ) A" ).append("\n"); 
		query.append("                              , COA_LANE_VSL_TP_FREQ B" ).append("\n"); 
		query.append("                          WHERE A.COST_YRMON  = B.COST_YRMON(+)" ).append("\n"); 
		query.append("                            AND A.TRD_CD      = B.TRD_CD(+)" ).append("\n"); 
		query.append("                            AND A.RLANE_CD    = B.RLANE_CD(+)" ).append("\n"); 
		query.append("                            AND A.VSL_OSHP_CD = B.VSL_OSHP_CD(+)" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("               GROUP BY COST_YRMON" ).append("\n"); 
		query.append("                      , TRD_CD" ).append("\n"); 
		query.append("                      , RLANE_CD" ).append("\n"); 
		query.append("                      , DIR_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("      , (SELECT LEVEL NO" ).append("\n"); 
		query.append("           FROM DUAL" ).append("\n"); 
		query.append("                CONNECT BY LEVEL <= 14" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 

	}
}