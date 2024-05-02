/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LaneSimulationDBDAOCreateTMLOPDysCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOCreateTMLOPDysCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TMLOPDys creatation
	  * </pre>
	  */
	public LaneSimulationDBDAOCreateTMLOPDysCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOCreateTMLOPDysCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_SIM_TML_OP_DYS" ).append("\n"); 
		query.append("(SIM_DT, SIM_NO, SECT_NO, TML_CD, VSL_DBL_CALL_SEQ, SKD_DIR_CD, TRD_CD, RLANE_CD, PORT_SEQ, IOC_CD, PORT_DYS, SEA_DYS, TTL_TZ_DYS, APLY_VOY_RTO, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("    	 SELECT @[f_sim_dt] SIM_DT " ).append("\n"); 
		query.append("    	       ,@[f_sim_no] SIM_NO " ).append("\n"); 
		query.append("    	       ,D1.SECT_NO " ).append("\n"); 
		query.append("    	       ,D1.TML_CD " ).append("\n"); 
		query.append("    	       ,D1.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("    	       ,D1.SKD_DIR_CD " ).append("\n"); 
		query.append("    	       ,D1.TRD_CD " ).append("\n"); 
		query.append("    	       ,D1.RLANE_CD " ).append("\n"); 
		query.append("    	       ,D1.SEQ " ).append("\n"); 
		query.append("    	       ,D1.IOC_CD " ).append("\n"); 
		query.append("    	       ,DECODE(D1.SEQ,1,ABS(NVL(D1.PORT_DYS,0) * D1.RTO)*0.5,ABS(NVL(D1.PORT_DYS,0) * D1.RTO)) PORT_DYS -- 첫포트의 PORT DAYS는 50%" ).append("\n"); 
		query.append("    	       ,ABS(NVL(D1.SEA_DYS,0) * DECODE(D1.TURN_PORT_IND_CD, 'F', 0 " ).append("\n"); 
		query.append("    	                                                             ,DECODE(D1.IS_SEA_DYS_100_PCT, 'Y', 1,D1.RTO) " ).append("\n"); 
		query.append("    	                                      ) " ).append("\n"); 
		query.append("    	           ) SEA_DYS " ).append("\n"); 
		query.append("    	       ,DECODE(D1.SEQ,1,ABS(NVL(D1.PORT_DYS,0) * D1.RTO)*0.5,ABS(NVL(D1.PORT_DYS,0) * D1.RTO)) " ).append("\n"); 
		query.append("    	       +ABS(NVL(D1.SEA_DYS,0) * DECODE(D1.TURN_PORT_IND_CD, 'F', 0 " ).append("\n"); 
		query.append("    	                                                             ,DECODE(D1.IS_SEA_DYS_100_PCT, 'Y', 1,D1.RTO) " ).append("\n"); 
		query.append("    	                                      ) " ).append("\n"); 
		query.append("    	           ) TOT_DYS " ).append("\n"); 
		query.append("    	       ,DECODE(D1.SEQ, 1, 0.5, D1.RTO) RTO " ).append("\n"); 
		query.append("    	       ,@[upd_usr_id] " ).append("\n"); 
		query.append("    	       ,SYSDATE " ).append("\n"); 
		query.append("    	       ,@[upd_usr_id] " ).append("\n"); 
		query.append("    	       ,SYSDATE " ).append("\n"); 
		query.append("    	   FROM ( " ).append("\n"); 
		query.append("    	         SELECT C1.SLAN_CD " ).append("\n"); 
		query.append("    	               ,C1.SECT_NO " ).append("\n"); 
		query.append("    	               ,C1.TRD_CD " ).append("\n"); 
		query.append("    	               ,C1.RLANE_CD " ).append("\n"); 
		query.append("    	               ,C1.SKD_DIR_CD " ).append("\n"); 
		query.append("    	               ,C1.TML_CD " ).append("\n"); 
		query.append("    	               ,C1.IOC_CD " ).append("\n"); 
		query.append("    	               ,C1.SEQ " ).append("\n"); 
		query.append("    	               ,C1.PORT_DYS " ).append("\n"); 
		query.append("    	               ,C1.SEA_DYS " ).append("\n"); 
		query.append("    	               ,C1.TURN_PORT_IND_CD " ).append("\n"); 
		query.append("    	               ,C1.TO_TURN_PORT_IND_CD " ).append("\n"); 
		query.append("    	               ,C1.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("    	               -- 1. 대륙이 바끼는 경우 운항일수 100% 적용 " ).append("\n"); 
		query.append("    	               -- 2. IMS 의 내륙이고 SUB CONTI 가 바끼는 경우 운항일수 100% 적용 " ).append("\n"); 
		query.append("    	               -- 3. ASIA <-> AUSTAILIA 구간인 경우 운항일수 100% 적용 " ).append("\n"); 
		query.append("    	               -- (!주의) AUSTAILIA 의 CONTI 는 'A' 이다. " ).append("\n"); 
		query.append("    	               --         SUB CONTI 'AO' 국가는 많지만 운항을 안하기 때문에 SUB CONTI 로만 조건가능함 " ).append("\n"); 
		query.append("    	               ,CASE WHEN (C1.FM_CONTI_CD <> C1.TO_CONTI_CD) " ).append("\n"); 
		query.append("    	                       OR (C1.TRD_CD = 'IMS' AND C1.FM_SCONTI_CD <> C1.TO_SCONTI_CD) " ).append("\n"); 
		query.append("    	                       OR (    C1.FM_CONTI_CD = 'A' " ).append("\n"); 
		query.append("    	                           AND C1.FM_SCONTI_CD <> C1.TO_SCONTI_CD " ).append("\n"); 
		query.append("    	                           AND (C1.FM_SCONTI_CD = 'AO' OR C1.TO_SCONTI_CD = 'AO') " ).append("\n"); 
		query.append("    	                          ) THEN 'Y' " ).append("\n"); 
		query.append("    	                     WHEN (C1.TURN_PORT_IND_CD = 'Y' AND C1.TO_TURN_PORT_IND_CD = 'N' AND C1.FM_CONTI_CD='A' AND C1.TO_CONTI_CD='A') THEN 'Y' " ).append("\n"); 
		query.append("    	                     WHEN (C1.IS_PRE_EGSUZ = 'Y' OR IS_PRE_PAPAC = 'Y') THEN 'Y' " ).append("\n"); 
		query.append("    	                     ELSE 'N' " ).append("\n"); 
		query.append("    	                END IS_SEA_DYS_100_PCT " ).append("\n"); 
		query.append("    	               ,DECODE(SIGN(C1.MIX_RTO) ,1, C1.MIX_RTO " ).append("\n"); 
		query.append("    	                                        ,DECODE(SIGN(C1.EGSUZ_RTO),1,C1.EGSUZ_RTO " ).append("\n"); 
		query.append("    	                                                                  ,DECODE(SIGN(C1.PNDLM_RTO), 1, C1.PNDLM_RTO, C1.OTHER_RTO) " ).append("\n"); 
		query.append("    	                                               ) " ).append("\n"); 
		query.append("    	                      ) RTO " ).append("\n"); 
		query.append("    	               ,DECODE(SIGN(C1.MIX_RTO) ,1, 'MIX_RTO' " ).append("\n"); 
		query.append("    	                                        ,DECODE(SIGN(C1.EGSUZ_RTO), 1, 'EGSUZ_RTO' " ).append("\n"); 
		query.append("    	                                                                  ,DECODE(SIGN(C1.PNDLM_RTO), 1, 'PNDLM_RTO', 'OTHER_RTO') " ).append("\n"); 
		query.append("    	                                               ) " ).append("\n"); 
		query.append("    	                      ) APPLY_RTO_NM " ).append("\n"); 
		query.append("    	           FROM ( " ).append("\n"); 
		query.append("    	                 SELECT B1.SLAN_CD " ).append("\n"); 
		query.append("    	                       ,B2.SECT_NO " ).append("\n"); 
		query.append("    	                       ,B2.TRD_CD " ).append("\n"); 
		query.append("    	                       ,B2.RLANE_CD " ).append("\n"); 
		query.append("    	                       ,B2.SKD_DIR_CD " ).append("\n"); 
		query.append("    	                       ,B1.TML_CD " ).append("\n"); 
		query.append("    	                       ,B1.SEQ " ).append("\n"); 
		query.append("    	                       ,B2.IOC_CD " ).append("\n"); 
		query.append("    	                       ,B1.PORT_DYS " ).append("\n"); 
		query.append("    	                       ,B1.SEA_DYS " ).append("\n"); 
		query.append("    	                       ,B1.TURN_PORT_IND_CD " ).append("\n"); 
		query.append("    	                       ,B1.TO_TURN_PORT_IND_CD " ).append("\n"); 
		query.append("    	                       ,B1.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("    	                       ,B1.FM_CONTI_CD " ).append("\n"); 
		query.append("    	                       ,B1.TO_CONTI_CD " ).append("\n"); 
		query.append("    	                       ,B1.FM_SCONTI_CD " ).append("\n"); 
		query.append("    	                       ,B1.TO_SCONTI_CD " ).append("\n"); 
		query.append("    	                       ,B2.FM_CNT " ).append("\n"); 
		query.append("    	                       ,B2.TO_CNT " ).append("\n"); 
		query.append("    	                       ,CASE WHEN (B1.SLAN_CD = 'MIX' OR B1.SLAN_CD = 'IMU') " ).append("\n"); 
		query.append("    	                              AND (B2.TRD_CD = 'TAS') " ).append("\n"); 
		query.append("    	                              AND (B1.FM_CONTI_CD = 'A' OR B1.PORT_CD = 'EGSUZ') THEN 'Y' " ).append("\n"); 
		query.append("    	                             ELSE 'N' " ).append("\n"); 
		query.append("    	                        END MIX_CASE " ).append("\n"); 
		query.append("    	                       -- MIX LANE에서 SAJED,AEKLF PORT는 APPLY RATIO 100% 적용 " ).append("\n"); 
		query.append("    	                       ,CASE WHEN (B1.SLAN_CD = 'MIX') " ).append("\n"); 
		query.append("    	                              AND (B1.PORT_CD = 'SAJED' OR B1.PORT_CD = 'AEKLF') THEN 1 " ).append("\n"); 
		query.append("    	                             ELSE 0 " ).append("\n"); 
		query.append("    	                        END MIX_RTO " ).append("\n"); 
		query.append("    	                       -- 수에즈/파나마 운하 APPLY RATIO 100% " ).append("\n"); 
		query.append("    	                       ,CASE WHEN (B1.PORT_CD = 'EGSUZ') THEN 1 " ).append("\n"); 
		query.append("    	                             ELSE 0 " ).append("\n"); 
		query.append("    	                        END EGSUZ_RTO " ).append("\n"); 
		query.append("    	                       ,CASE WHEN (B1.PORT_CD = 'PAPAC') THEN 1 " ).append("\n"); 
		query.append("    	                             ELSE 0 " ).append("\n"); 
		query.append("    	                        END PAPAC_RTO " ).append("\n"); 
		query.append("    	                       -- 대륙을 3개를 운항하는 VVD - APPLY RATIO 50% 적용 " ).append("\n"); 
		query.append("    	                       ,CASE WHEN (B1.PNDLM_CNT >= 3) THEN 0.5 " ).append("\n"); 
		query.append("    	                             ELSE 0 " ).append("\n"); 
		query.append("    	                        END PNDLM_RTO " ).append("\n"); 
		query.append("    	                       -- TURN_PORT_IND_CD 가 'Y' 이면 RATIO는 50% 아니면 100% 적용 " ).append("\n"); 
		query.append("    	                       -- TURN_PORT_IND_CD 가 'Y'->'N' 이면 RATIO는 100% 적용 " ).append("\n"); 
		query.append("    	                       ,CASE WHEN B1.TURN_PORT_IND_CD = 'N' THEN 1 " ).append("\n"); 
		query.append("    	                             ELSE 0.5 " ).append("\n"); 
		query.append("    	                        END OTHER_RTO " ).append("\n"); 
		query.append("    	                       ,CASE WHEN (B1.SKD_DIR_CD = 'E' " ).append("\n"); 
		query.append("    	                              AND LEAD(B1.PORT_CD) OVER(ORDER BY B1.SEQ) = 'EGSUZ') THEN 'Y' " ).append("\n"); 
		query.append("    	                             ELSE 'N' " ).append("\n"); 
		query.append("    	                        END IS_PRE_EGSUZ " ).append("\n"); 
		query.append("    	                       ,CASE WHEN (B1.SKD_DIR_CD = 'W' " ).append("\n"); 
		query.append("    	                              AND LEAD(B1.PORT_CD) OVER(ORDER BY B1.SEQ) = 'PAPAC') THEN 'Y' " ).append("\n"); 
		query.append("    	                             ELSE 'N' " ).append("\n"); 
		query.append("    	                        END IS_PRE_PAPAC " ).append("\n"); 
		query.append("    	                   FROM (-- TMNL 정보를 가지고 E/B, W/B 정보를 구분한다. " ).append("\n"); 
		query.append("    	                SELECT B1.SLAN_CD " ).append("\n"); 
		query.append("    	                      ,B1.TML_CD " ).append("\n"); 
		query.append("    	                      ,B1.PORT_CD " ).append("\n"); 
		query.append("    	                      ,B1.SKD_DIR_CD " ).append("\n"); 
		query.append("    	                      ,B1.SECT_NO " ).append("\n"); 
		query.append("    	                      ,ROW_NUMBER() OVER (ORDER BY B1.SECT_NO,B1.PORT_SEQ) SEQ " ).append("\n"); 
		query.append("    	                      ,ROW_NUMBER() OVER (PARTITION BY B1.SECT_NO ORDER BY B1.PORT_SEQ) PORT_SEQ " ).append("\n"); 
		query.append("    	                      ,B1.PORT_DYS " ).append("\n"); 
		query.append("    	                      ,B1.IOC_CD " ).append("\n"); 
		query.append("    	 				     ,DECODE(ROW_NUMBER() OVER(PARTITION BY SKD_DIR_CD ORDER BY SECT_NO, PORT_SEQ)," ).append("\n"); 
		query.append("    	 											   COUNT(*) OVER(PARTITION BY SKD_DIR_CD)," ).append("\n"); 
		query.append("    	 										       '0', SEA_DYS) SEA_DYS" ).append("\n"); 
		query.append("    	                      ,B1.TURN_PORT_IND_CD " ).append("\n"); 
		query.append("    	                      ,NVL(LEAD(B1.TURN_PORT_IND_CD) OVER(PARTITION BY B1.SKD_DIR_CD ORDER BY B1.SECT_NO,B1.PORT_SEQ),' ') AS TO_TURN_PORT_IND_CD " ).append("\n"); 
		query.append("    	                      ,B1.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("    	                      ,B1.CONTI_CD AS FM_CONTI_CD " ).append("\n"); 
		query.append("    	                      ,B1.SCONTI_CD AS FM_SCONTI_CD " ).append("\n"); 
		query.append("    	                      ,NVL(LEAD(B1.CONTI_CD) OVER(PARTITION BY B1.SKD_DIR_CD ORDER BY B1.SECT_NO,B1.PORT_SEQ),' ') AS TO_CONTI_CD -- NEXT PORT의 CONTI 정보를 조회 " ).append("\n"); 
		query.append("    	                      ,NVL(LEAD(B1.SCONTI_CD) OVER(PARTITION BY B1.SKD_DIR_CD ORDER BY B1.SECT_NO,B1.PORT_SEQ),' ') AS TO_SCONTI_CD -- NEXT PORT의 CONTI 정보를 조회 " ).append("\n"); 
		query.append("    	                      ,COUNT(DISTINCT B1.CONTI_CD) OVER() PNDLM_CNT " ).append("\n"); 
		query.append("    	                  FROM ( " ).append("\n"); 
		query.append("    	                         -- TURN_PORT_IND_CD = Y 인 PORT 정보일 경우 ROW를 하나 더 만들고 BOUND를 반대로 만들어 주고 SEQ + MAX_SEQ 해서 SEQ를 구해준다 " ).append("\n"); 
		query.append("    	                         SELECT /*+ LEADING(A1 A2 A4 A3) USE_NL(A1 A2) USE_HASH(A2) */" ).append("\n"); 
		query.append("                                        DISTINCT " ).append("\n"); 
		query.append("    	                                @[f_slan_cd] AS SLAN_CD " ).append("\n"); 
		query.append("    	                               ,DECODE(A3.NUM, 1, A1.TML_CD " ).append("\n"); 
		query.append("    	                                             , 2, A1.TML_CD " ).append("\n"); 
		query.append("    	                                       ) TML_CD " ).append("\n"); 
		query.append("    	                               ,DECODE(A3.NUM, 1, SUBSTR(A1.TML_CD,1,5) " ).append("\n"); 
		query.append("    	                                             , 2, SUBSTR(A1.TML_CD,1,5) " ).append("\n"); 
		query.append("    	                                       ) PORT_CD " ).append("\n"); 
		query.append("    	                               ,DECODE(A3.NUM, 1, DECODE(A1.TURN_PORT_IND_CD, 'Y', DECODE(A1.SKD_DIR_CD,'E','W','E') , A1.SKD_DIR_CD) " ).append("\n"); 
		query.append("    	                                             , 2, A1.SKD_DIR_CD " ).append("\n"); 
		query.append("    	                                       ) SKD_DIR_CD " ).append("\n"); 
		query.append("    	                               ,DECODE(A3.NUM, 1, DECODE(A1.TURN_PORT_IND_CD, 'Y', A1.PORT_SEQ+MAX(A1.PORT_SEQ)OVER(), A1.PORT_SEQ) " ).append("\n"); 
		query.append("    	                                             , 2, A1.PORT_SEQ " ).append("\n"); 
		query.append("    	                                       ) PORT_SEQ " ).append("\n"); 
		query.append("    	                               ,DECODE(A3.NUM, 1, DECODE(A1.TURN_PORT_IND_CD, 'Y', A4.OTR_SECT, A4.SECT_NO) " ).append("\n"); 
		query.append("    	                                             , 2, A4.SECT_NO " ).append("\n"); 
		query.append("    	                                       ) SECT_NO " ).append("\n"); 
		query.append("    	                               ,A1.PORT_DYS " ).append("\n"); 
		query.append("    	                               ,A1.SEA_DYS " ).append("\n"); 
		query.append("    	                               ,A4.IOC_CD " ).append("\n"); 
		query.append("    	                               ,A1.TURN_PORT_IND_CD " ).append("\n"); 
		query.append("    	                               ,A1.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("    	                               ,DECODE(@[f_slan_cd],'INX',DECODE(A2.CONTI_CD,'F','A',A2.CONTI_CD) " ).append("\n"); 
		query.append("    	                                            ,'RES',DECODE(A2.CONTI_CD,'F','A',A2.CONTI_CD) " ).append("\n"); 
		query.append("    	                                            ,DECODE(A2.CONTI_CD,'F','E',A2.CONTI_CD) " ).append("\n"); 
		query.append("    	                                       ) CONTI_CD " ).append("\n"); 
		query.append("    	                               ,A2.SCONTI_CD " ).append("\n"); 
		query.append("    	                           FROM COA_SIM_TML_INFO A1 " ).append("\n"); 
		query.append("    	                               ,( " ).append("\n"); 
		query.append("    	                                 SELECT SECT_NO " ).append("\n"); 
		query.append("    	                                       ,NVL(LEAD(SECT_NO) OVER(ORDER BY SECT_NO) -- NEXT ROW의 SECTION NUMBER 조회 " ).append("\n"); 
		query.append("    	                                           ,LAG(SECT_NO,1,0) OVER(ORDER BY SECT_NO) -- PREVIOUS ROW의 SECTION NUMBER 조회 " ).append("\n"); 
		query.append("    	                                           ) OTR_SECT -- E/B, W/B 각각 서로의 SECTION NUMBER 정보를 조회 " ).append("\n"); 
		query.append("    	                                       ,SKD_DIR_CD " ).append("\n"); 
		query.append("    	                                       ,IOC_CD " ).append("\n"); 
		query.append("    	                                   FROM( -- E/B, W/B 의 SECTION NUMBER의 최소값을 구한다. " ).append("\n"); 
		query.append("    	                                         SELECT MIN(SECT_NO) SECT_NO " ).append("\n"); 
		query.append("    	                                               ,SKD_DIR_CD " ).append("\n"); 
		query.append("    	                                               ,IOC_CD " ).append("\n"); 
		query.append("    	                                           FROM COA_SIM_SVC_LANE " ).append("\n"); 
		query.append("    	                                          WHERE SIM_DT = @[f_sim_dt] " ).append("\n"); 
		query.append("    	                                            AND SIM_NO = @[f_sim_no] " ).append("\n"); 
		query.append("    	                                          GROUP BY SKD_DIR_CD,IOC_CD " ).append("\n"); 
		query.append("    	                                        ) " ).append("\n"); 
		query.append("    	                                 ) A4 " ).append("\n"); 
		query.append("    	                               ,MDM_LOCATION A2 " ).append("\n"); 
		query.append("    	                               ,(SELECT CPY_NO NUM FROM COM_CPY_NO WHERE CPY_NO BETWEEN 1 AND 2) A3 " ).append("\n"); 
		query.append("    	                          WHERE 1=1 " ).append("\n"); 
		query.append("    	                            AND A1.SKD_DIR_CD = A4.SKD_DIR_CD " ).append("\n"); 
		query.append("    	                            AND substr(A1.TML_CD,1,5) = A2.LOC_CD " ).append("\n"); 
		query.append("    	                            AND A1.SIM_DT     = @[f_sim_dt] " ).append("\n"); 
		query.append("    	                            AND A1.SIM_NO     = @[f_sim_no] " ).append("\n"); 
		query.append("    	                         ) B1 " ).append("\n"); 
		query.append("    	                  ORDER BY B1.SECT_NO, B1.PORT_SEQ " ).append("\n"); 
		query.append("    	               ) B1 " ).append("\n"); 
		query.append("    	                       ,( -- TRAD, RLANE, BOUND 별 포트정보 " ).append("\n"); 
		query.append("    	                 SELECT DISTINCT A2.SECT_NO " ).append("\n"); 
		query.append("    	                       ,A2.TRD_CD " ).append("\n"); 
		query.append("    	                       ,A2.RLANE_CD " ).append("\n"); 
		query.append("    	                       ,A2.IOC_CD " ).append("\n"); 
		query.append("    	                       ,A1.SKD_DIR_CD " ).append("\n"); 
		query.append("                               ,CASE WHEN A1.IOC_CD = 'O' THEN LAG(A1.SEQ+1,1,1) OVER(ORDER BY A1.SECT_NO, A1.SEQ) " ).append("\n"); 
		query.append("                                     WHEN A1.IOC_CD = 'I' THEN MIN(A1.SEQ) OVER(PARTITION BY  A1.SKD_DIR_CD)" ).append("\n"); 
		query.append("                                END FM_CNT " ).append("\n"); 
		query.append("                               ,CASE WHEN A1.IOC_CD = 'O' THEN LEAD(A1.SEQ,1) OVER(ORDER BY A1.SECT_NO, A1.SEQ) " ).append("\n"); 
		query.append("                                     WHEN A1.IOC_CD = 'I' THEN MAX(A1.SEQ) OVER(PARTITION BY A1.SKD_DIR_CD) " ).append("\n"); 
		query.append("                               END TO_CNT " ).append("\n"); 
		query.append("                           FROM (-- TMNL 정보를 가지고 E/B, W/B 정보를 구분한다. " ).append("\n"); 
		query.append("    	                SELECT B1.SLAN_CD " ).append("\n"); 
		query.append("    	                      ,B1.TML_CD " ).append("\n"); 
		query.append("    	                      ,B1.PORT_CD " ).append("\n"); 
		query.append("    	                      ,B1.SKD_DIR_CD " ).append("\n"); 
		query.append("    	                      ,B1.SECT_NO " ).append("\n"); 
		query.append("    	                      ,ROW_NUMBER() OVER (ORDER BY B1.SECT_NO,B1.PORT_SEQ) SEQ " ).append("\n"); 
		query.append("    	                      ,ROW_NUMBER() OVER (PARTITION BY B1.SECT_NO ORDER BY B1.PORT_SEQ) PORT_SEQ " ).append("\n"); 
		query.append("    	                      ,B1.PORT_DYS " ).append("\n"); 
		query.append("    	                      ,B1.IOC_CD " ).append("\n"); 
		query.append("    	 				     ,DECODE(ROW_NUMBER() OVER(PARTITION BY SKD_DIR_CD ORDER BY SECT_NO, PORT_SEQ)," ).append("\n"); 
		query.append("    	 											   COUNT(*) OVER(PARTITION BY SKD_DIR_CD)," ).append("\n"); 
		query.append("    	 										       '0', SEA_DYS) SEA_DYS" ).append("\n"); 
		query.append("    	                      ,B1.TURN_PORT_IND_CD " ).append("\n"); 
		query.append("    	                      ,NVL(LEAD(B1.TURN_PORT_IND_CD) OVER(PARTITION BY B1.SKD_DIR_CD ORDER BY B1.SECT_NO,B1.PORT_SEQ),' ') AS TO_TURN_PORT_IND_CD " ).append("\n"); 
		query.append("    	                      ,B1.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("    	                      ,B1.CONTI_CD AS FM_CONTI_CD " ).append("\n"); 
		query.append("    	                      ,B1.SCONTI_CD AS FM_SCONTI_CD " ).append("\n"); 
		query.append("    	                      ,NVL(LEAD(B1.CONTI_CD) OVER(PARTITION BY B1.SKD_DIR_CD ORDER BY B1.SECT_NO,B1.PORT_SEQ),' ') AS TO_CONTI_CD -- NEXT PORT의 CONTI 정보를 조회 " ).append("\n"); 
		query.append("    	                      ,NVL(LEAD(B1.SCONTI_CD) OVER(PARTITION BY B1.SKD_DIR_CD ORDER BY B1.SECT_NO,B1.PORT_SEQ),' ') AS TO_SCONTI_CD -- NEXT PORT의 CONTI 정보를 조회 " ).append("\n"); 
		query.append("    	                      ,COUNT(DISTINCT B1.CONTI_CD) OVER() PNDLM_CNT " ).append("\n"); 
		query.append("    	                  FROM ( " ).append("\n"); 
		query.append("    	                         -- TURN_PORT_IND_CD = Y 인 PORT 정보일 경우 ROW를 하나 더 만들고 BOUND를 반대로 만들어 주고 SEQ + MAX_SEQ 해서 SEQ를 구해준다 " ).append("\n"); 
		query.append("    	                         SELECT /*+ LEADING(A1 A2 A4 A3) USE_NL(A1 A2) USE_HASH(A2) */" ).append("\n"); 
		query.append("                                        DISTINCT " ).append("\n"); 
		query.append("    	                                @[f_slan_cd] AS SLAN_CD " ).append("\n"); 
		query.append("    	                               ,DECODE(A3.NUM, 1, A1.TML_CD " ).append("\n"); 
		query.append("    	                                             , 2, A1.TML_CD " ).append("\n"); 
		query.append("    	                                       ) TML_CD " ).append("\n"); 
		query.append("    	                               ,DECODE(A3.NUM, 1, SUBSTR(A1.TML_CD,1,5) " ).append("\n"); 
		query.append("    	                                             , 2, SUBSTR(A1.TML_CD,1,5) " ).append("\n"); 
		query.append("    	                                       ) PORT_CD " ).append("\n"); 
		query.append("    	                               ,DECODE(A3.NUM, 1, DECODE(A1.TURN_PORT_IND_CD, 'Y', DECODE(A1.SKD_DIR_CD,'E','W','E') , A1.SKD_DIR_CD) " ).append("\n"); 
		query.append("    	                                             , 2, A1.SKD_DIR_CD " ).append("\n"); 
		query.append("    	                                       ) SKD_DIR_CD " ).append("\n"); 
		query.append("    	                               ,DECODE(A3.NUM, 1, DECODE(A1.TURN_PORT_IND_CD, 'Y', A1.PORT_SEQ+MAX(A1.PORT_SEQ)OVER(), A1.PORT_SEQ) " ).append("\n"); 
		query.append("    	                                             , 2, A1.PORT_SEQ " ).append("\n"); 
		query.append("    	                                       ) PORT_SEQ " ).append("\n"); 
		query.append("    	                               ,DECODE(A3.NUM, 1, DECODE(A1.TURN_PORT_IND_CD, 'Y', A4.OTR_SECT, A4.SECT_NO) " ).append("\n"); 
		query.append("    	                                             , 2, A4.SECT_NO " ).append("\n"); 
		query.append("    	                                       ) SECT_NO " ).append("\n"); 
		query.append("    	                               ,A1.PORT_DYS " ).append("\n"); 
		query.append("    	                               ,A1.SEA_DYS " ).append("\n"); 
		query.append("    	                               ,A4.IOC_CD " ).append("\n"); 
		query.append("    	                               ,A1.TURN_PORT_IND_CD " ).append("\n"); 
		query.append("    	                               ,A1.VSL_DBL_CALL_SEQ " ).append("\n"); 
		query.append("    	                               ,DECODE(@[f_slan_cd],'INX',DECODE(A2.CONTI_CD,'F','A',A2.CONTI_CD) " ).append("\n"); 
		query.append("    	                                            ,'RES',DECODE(A2.CONTI_CD,'F','A',A2.CONTI_CD) " ).append("\n"); 
		query.append("    	                                            ,DECODE(A2.CONTI_CD,'F','E',A2.CONTI_CD) " ).append("\n"); 
		query.append("    	                                       ) CONTI_CD " ).append("\n"); 
		query.append("    	                               ,A2.SCONTI_CD " ).append("\n"); 
		query.append("    	                           FROM COA_SIM_TML_INFO A1 " ).append("\n"); 
		query.append("    	                               ,( " ).append("\n"); 
		query.append("    	                                 SELECT SECT_NO " ).append("\n"); 
		query.append("    	                                       ,NVL(LEAD(SECT_NO) OVER(ORDER BY SECT_NO) -- NEXT ROW의 SECTION NUMBER 조회 " ).append("\n"); 
		query.append("    	                                           ,LAG(SECT_NO,1,0) OVER(ORDER BY SECT_NO) -- PREVIOUS ROW의 SECTION NUMBER 조회 " ).append("\n"); 
		query.append("    	                                           ) OTR_SECT -- E/B, W/B 각각 서로의 SECTION NUMBER 정보를 조회 " ).append("\n"); 
		query.append("    	                                       ,SKD_DIR_CD " ).append("\n"); 
		query.append("    	                                       ,IOC_CD " ).append("\n"); 
		query.append("    	                                   FROM( -- E/B, W/B 의 SECTION NUMBER의 최소값을 구한다. " ).append("\n"); 
		query.append("    	                                         SELECT MIN(SECT_NO) SECT_NO " ).append("\n"); 
		query.append("    	                                               ,SKD_DIR_CD " ).append("\n"); 
		query.append("    	                                               ,IOC_CD " ).append("\n"); 
		query.append("    	                                           FROM COA_SIM_SVC_LANE " ).append("\n"); 
		query.append("    	                                          WHERE SIM_DT = @[f_sim_dt] " ).append("\n"); 
		query.append("    	                                            AND SIM_NO = @[f_sim_no] " ).append("\n"); 
		query.append("    	                                          GROUP BY SKD_DIR_CD,IOC_CD " ).append("\n"); 
		query.append("    	                                        ) " ).append("\n"); 
		query.append("    	                                 ) A4 " ).append("\n"); 
		query.append("    	                               ,MDM_LOCATION A2 " ).append("\n"); 
		query.append("    	                               ,(SELECT CPY_NO NUM FROM COM_CPY_NO WHERE CPY_NO BETWEEN 1 AND 2) A3 " ).append("\n"); 
		query.append("    	                          WHERE 1=1 " ).append("\n"); 
		query.append("    	                            AND A1.SKD_DIR_CD = A4.SKD_DIR_CD " ).append("\n"); 
		query.append("    	                            AND substr(A1.TML_CD,1,5) = A2.LOC_CD" ).append("\n"); 
		query.append("    	                            AND A1.SIM_DT     = @[f_sim_dt] " ).append("\n"); 
		query.append("    	                            AND A1.SIM_NO     = @[f_sim_no] " ).append("\n"); 
		query.append("    	                         ) B1 " ).append("\n"); 
		query.append("    	                  ORDER BY B1.SECT_NO, B1.PORT_SEQ " ).append("\n"); 
		query.append("    	               ) A1 " ).append("\n"); 
		query.append("                               ,(-- 행당 서비스에 TRADE, RLANE, BOUND 별 FROM CONTI, TO CONTI 정보를 조회한다 " ).append("\n"); 
		query.append("    	               SELECT DISTINCT " ).append("\n"); 
		query.append("    	                      A1.TRD_CD " ).append("\n"); 
		query.append("    	                     ,A1.RLANE_CD " ).append("\n"); 
		query.append("    	                     ,A1.IOC_CD " ).append("\n"); 
		query.append("    	                     ,A1.VSL_SLAN_DIR_CD SKD_DIR_CD " ).append("\n"); 
		query.append("    	                     ,DECODE(@[f_slan_cd],'INX', DECODE(A1.FM_CONTI_CD,'F','A',A1.FM_CONTI_CD) " ).append("\n"); 
		query.append("    	                                  ,'RES', DECODE(A1.FM_CONTI_CD,'F','A',A1.FM_CONTI_CD) " ).append("\n"); 
		query.append("    	                                  ,DECODE(A1.FM_CONTI_CD,'F','E',A1.FM_CONTI_CD) " ).append("\n"); 
		query.append("    	                             ) FM_CONTI_CD " ).append("\n"); 
		query.append("    	                     ,DECODE(@[f_slan_cd],'INX', DECODE(A1.TO_CONTI_CD,'F','A',A1.TO_CONTI_CD) " ).append("\n"); 
		query.append("    	                                  ,'RES', DECODE(A1.TO_CONTI_CD,'F','A',A1.TO_CONTI_CD) " ).append("\n"); 
		query.append("    	                                  ,DECODE(A1.TO_CONTI_CD,'F','E',A1.TO_CONTI_CD) " ).append("\n"); 
		query.append("    	                             ) TO_CONTI_CD " ).append("\n"); 
		query.append("    	                     ,A2.SECT_NO " ).append("\n"); 
		query.append("                        FROM ( " ).append("\n"); 
		query.append("                              SELECT RLANE_CD, VSL_SLAN_DIR_CD, IOC_CD, FM_CONTI_CD, TO_CONTI_CD, TRD_CD, SUB_TRD_CD " ).append("\n"); 
		query.append("                                FROM MDM_DTL_REV_LANE " ).append("\n"); 
		query.append("                               WHERE DELT_FLG        = 'N' " ).append("\n"); 
		query.append("                               UNION ALL " ).append("\n"); 
		query.append("                              SELECT RLANE_CD, SKD_DIR_CD, IOC_CD, FM_CONTI_CD, TO_CONTI_CD, TRD_CD, SUB_TRD_CD " ).append("\n"); 
		query.append("                                FROM COA_SIM_DTL_REV_LANE " ).append("\n"); 
		query.append("                             ) A1 " ).append("\n"); 
		query.append("    	                     ,COA_SIM_SVC_LANE A2 " ).append("\n"); 
		query.append("    	                WHERE 1=1 " ).append("\n"); 
		query.append("    	                  AND A1.TRD_CD          = A2.TRD_CD " ).append("\n"); 
		query.append("    	                  AND A1.RLANE_CD        = A2.RLANE_CD " ).append("\n"); 
		query.append("    	                  AND A1.VSL_SLAN_DIR_CD = A2.SKD_DIR_CD " ).append("\n"); 
		query.append("    	                  AND A1.IOC_CD          = A2.IOC_CD " ).append("\n"); 
		query.append("    	                  AND A2.SIM_DT          = @[f_sim_dt] " ).append("\n"); 
		query.append("    	                  AND A2.SIM_NO          = @[f_sim_no] " ).append("\n"); 
		query.append("    	              ) A2 " ).append("\n"); 
		query.append("                          WHERE 1=1 " ).append("\n"); 
		query.append("                            AND A1.SKD_DIR_CD  = A2.SKD_DIR_CD(+) " ).append("\n"); 
		query.append("                            AND A1.FM_CONTI_CD = A2.FM_CONTI_CD(+) " ).append("\n"); 
		query.append("                            AND A1.TO_CONTI_CD = A2.TO_CONTI_CD(+) " ).append("\n"); 
		query.append("                            AND ((A1.FM_CONTI_CD <> A1.TO_CONTI_CD AND A1.IOC_CD = 'O') " ).append("\n"); 
		query.append("                             OR  (A1.IOC_CD = 'I')) " ).append("\n"); 
		query.append("    	                ) B2 " ).append("\n"); 
		query.append("    	                  WHERE 1=1 " ).append("\n"); 
		query.append("    	                    AND B1.SEQ    BETWEEN B2.FM_CNT AND B2.TO_CNT " ).append("\n"); 
		query.append("    	                    AND B2.TRD_CD IS NOT NULL " ).append("\n"); 
		query.append("    	                  ORDER BY B2.SECT_NO, B2.FM_CNT,B1.SEQ " ).append("\n"); 
		query.append("    	                 ) C1 " ).append("\n"); 
		query.append("    	          WHERE C1.MIX_CASE = 'N' " ).append("\n"); 
		query.append("    	        ) D1" ).append("\n"); 

	}
}