/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkCostDBDAOSearchBunkerTariffYwListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchBunkerTariffYwListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBunkerTariffList SELECT
	  * 2010.09.08 이상용   [CHM-201005893] MIN 값이 아니라 SLS_YRMON 과 조인하도록 변경
	  * 2011.11.18 최윤성 [CHM-201110236-01] Bunker Fee 메뉴 컬럼 추가
	  *  - SLANE, RLANE, DIR, VSL CLASS CAPA 에 따른 해당 주차의 VESSEL 정보 제공
	  *    한주에 노선별 VVD정보는 하나만 오는 것이 일반적이나 그렇치 않은 경우가 존재하여
	  *    아래와 같이 CONNECT BY를 사용하여 동일 노선의 동일 사이즈의 VESSEL 코드를 조회 하도록 함
	  * [CHM-201215754-01] [MAS] Bunker Fee 화면 개발 건 쿼리 변경
	  * </pre>
	  */
	public NetworkCostDBDAOSearchBunkerTariffYwListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchBunkerTariffYwListRSQL").append("\n"); 
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
		query.append("WITH TMP_MON_VVD AS" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                -- before 12주차부터 현재 주차까지의 모든 데이터를 조회한다." ).append("\n"); 
		query.append("                -- before 12주차부터 before 1주차까지는 Ref - FO Cons 값을 구하기 위해서 사용" ).append("\n"); 
		query.append("                 SELECT DECODE(B.VSL_CD||B.SKD_VOY_NO||B.DIR_CD, A.VSL_CD||A.SKD_VOY_NO||A.DIR_CD, 'R', 'I') FLAG" ).append("\n"); 
		query.append("                      , A.COST_YRMON" ).append("\n"); 
		query.append("                      , A.COST_WK" ).append("\n"); 
		query.append("                      , A.SLAN_CD" ).append("\n"); 
		query.append("                      , A.RLANE_CD" ).append("\n"); 
		query.append("                      , A.DIR_CD" ).append("\n"); 
		query.append("                      , A.VSL_CD" ).append("\n"); 
		query.append("                      , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , A.TRD_CD" ).append("\n"); 
		query.append("                      , A.SUB_TRD_CD" ).append("\n"); 
		query.append("                      , NVL(B.FOIL_CSM, 0) FOIL_CSM" ).append("\n"); 
		query.append("                      , NVL(B.FOIL_UC_AMT, 0) FOIL_UC_AMT" ).append("\n"); 
		query.append("                      , NVL(B.DOIL_CSM, 0) DOIL_CSM" ).append("\n"); 
		query.append("                      , NVL(B.DOIL_UC_AMT, 0) DOIL_UC_AMT" ).append("\n"); 
		query.append("                      , A.PREV_WK_12" ).append("\n"); 
		query.append("                      , A.PREV_WK_1" ).append("\n"); 
		query.append("                   FROM" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                                SELECT DISTINCT A1.SLS_YRMON COST_YRMON" ).append("\n"); 
		query.append("                                      , A1.COST_WK" ).append("\n"); 
		query.append("                                      , A1.SLAN_CD" ).append("\n"); 
		query.append("                                      , A1.RLANE_CD" ).append("\n"); 
		query.append("                                      , A1.DIR_CD" ).append("\n"); 
		query.append("                                      , A1.VSL_CD" ).append("\n"); 
		query.append("                                      , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      , A1.TRD_CD" ).append("\n"); 
		query.append("                                      , A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                                      , A4.PREV_WK_12" ).append("\n"); 
		query.append("                                      , A4.PREV_WK_1" ).append("\n"); 
		query.append("                                   FROM MAS_MON_VVD A1" ).append("\n"); 
		query.append("                                      , MAS_VSL_RGST A2" ).append("\n"); 
		query.append("                                      , MAS_LANE_RGST A3" ).append("\n"); 
		query.append("                                      , (" ).append("\n"); 
		query.append("                                                 SELECT PREV_WK_12      -- before 12 weeks" ).append("\n"); 
		query.append("                                                      , PREV_WK_1       -- before 1 week" ).append("\n"); 
		query.append("                                                      , PREV_WK_0       -- current week" ).append("\n"); 
		query.append("                                                   FROM" ).append("\n"); 
		query.append("                                                        (" ).append("\n"); 
		query.append("                                                                 SELECT LAG (COST_YR || COST_WK, 12) OVER (ORDER BY COST_YR || COST_WK) AS PREV_WK_12" ).append("\n"); 
		query.append("                                                                      , LAG (COST_YR || COST_WK, 1) OVER (ORDER BY COST_YR || COST_WK) AS PREV_WK_1" ).append("\n"); 
		query.append("                                                                      , (@[sls_yrmon]||@[cost_wk]) PREV_WK_0" ).append("\n"); 
		query.append("                                                                   FROM MAS_WK_PRD" ).append("\n"); 
		query.append("                                                                  WHERE COST_YR || COST_WK <= @[sls_yrmon]||@[cost_wk]" ).append("\n"); 
		query.append("                                                               ORDER BY COST_YR || COST_WK DESC" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                                                  WHERE ROWNUM = 1" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                        A4" ).append("\n"); 
		query.append("                                  WHERE A1.TRD_CD          = A3.TRD_CD" ).append("\n"); 
		query.append("                                    AND A1.RLANE_CD        = A3.RLANE_CD" ).append("\n"); 
		query.append("                                    AND A1.IOC_CD          = A3.IOC_CD" ).append("\n"); 
		query.append("                                    AND A1.DIR_CD          = A3.DIR_CD" ).append("\n"); 
		query.append("                                    AND A3.TRD_CD         <> 'COM'" ).append("\n"); 
		query.append("                                    AND A3.VSL_LANE_TP_CD IN ('JO', 'SC')" ).append("\n"); 
		query.append("                                    AND A1.VSL_CD          = A2.VSL_CD" ).append("\n"); 
		query.append("                                    -- if 절 사용" ).append("\n"); 
		query.append("									#if (${slan_cd} != '')" ).append("\n"); 
		query.append("		                                AND A1.SLAN_CD    =@[slan_cd]" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("									#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("		                                AND A1.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("									#if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("		                            	AND A1.VSL_CD     = @[f_vsl_cd] " ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("									#if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("		                                AND A1.DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("                                    " ).append("\n"); 
		query.append("                                    AND A1.N1ST_LODG_PORT_ETD_DT BETWEEN A2.VSL_APLY_FM_DT AND A2.VSL_APLY_TO_DT" ).append("\n"); 
		query.append("                                    AND A2.VOP_CD = 'SML'" ).append("\n"); 
		query.append("                                    AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK BETWEEN A4.PREV_WK_12 AND A4.PREV_WK_0        ---여기도 분기                            " ).append("\n"); 
		query.append("                                    AND A1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                    AND A2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                    AND A3.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                    " ).append("\n"); 
		query.append("                        ) A" ).append("\n"); 
		query.append("                      , MAS_BNK_TRF B" ).append("\n"); 
		query.append("                  WHERE A.SLAN_CD    = B.SLAN_CD (+)" ).append("\n"); 
		query.append("                    AND A.RLANE_CD   = B.RLANE_CD (+)" ).append("\n"); 
		query.append("                    AND A.VSL_CD     = B.VSL_CD (+)" ).append("\n"); 
		query.append("                    AND A.SKD_VOY_NO = B.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("                    AND A.DIR_CD     = B.DIR_CD (+)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append(" SELECT A.FLAG              -- ibflag" ).append("\n"); 
		query.append("      , A.COST_STS          -- status" ).append("\n"); 
		query.append("      , A.COST_YRMON        -- yyyy-mm" ).append("\n"); 
		query.append("      , A.COST_WK           -- Week" ).append("\n"); 
		query.append("      , A.SLAN_CD           -- S.Lane" ).append("\n"); 
		query.append("      , A.RLANE_CD          -- R.Lane" ).append("\n"); 
		query.append("      , A.VSL_CD            -- Vessel Code" ).append("\n"); 
		query.append("      , A.SKD_VOY_NO        -- Voyage" ).append("\n"); 
		query.append("      , A.DIR_CD            -- DIR" ).append("\n"); 
		query.append("      , A.FOIL_CSM          -- FO-Cons" ).append("\n"); 
		query.append("      , A.FOIL_UC_AMT       -- FO-Unit Cost" ).append("\n"); 
		query.append("      , A.DOIL_CSM          -- DO-Cons" ).append("\n"); 
		query.append("      , A.DOIL_UC_AMT       -- DO-Unit Cost" ).append("\n"); 
		query.append("      , A.FOIL_ESTM_CSM_WGT -- Cons.(FCM)-FO Cons" ).append("\n"); 
		query.append("      , A.DOIL_ESTM_CSM_WGT -- Cons.(FCM)-DO Cons" ).append("\n"); 
		query.append("      , NVL(B.LAST_FOIL_CSM, 0) LAST_FOIL_CSM   -- Ref-FO Cons" ).append("\n"); 
		query.append("      , DECODE(NVL(B.LAST_FOIL_CSM, 0), 0, 'No data', B.LAST_FOIL_CSM_REF) LAST_FOIL_CSM_REF    -- Ref-YR_WK" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                 SELECT D1.FLAG" ).append("\n"); 
		query.append("                      , CASE WHEN NVL(D1.FOIL_CSM, 0) = 0 AND D1.FOIL_ESTM_CSM_WGT = 0 THEN 'N' " ).append("\n"); 
		query.append("                             WHEN NVL(D1.FOIL_CSM, 0) = 0 AND D1.FOIL_ESTM_CSM_WGT > 0 THEN 'F' " ).append("\n"); 
		query.append("                             WHEN NVL(D1.FOIL_CSM, 0) > 0 AND D1.FOIL_ESTM_CSM_WGT = 0 THEN 'C' " ).append("\n"); 
		query.append("                             ELSE 'A' END AS COST_STS" ).append("\n"); 
		query.append("                      , D1.COST_YRMON" ).append("\n"); 
		query.append("                      , D1.COST_WK" ).append("\n"); 
		query.append("                      , D1.SLAN_CD" ).append("\n"); 
		query.append("                      , D1.RLANE_CD" ).append("\n"); 
		query.append("                      , D1.VSL_CD" ).append("\n"); 
		query.append("                      , D1.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , D1.DIR_CD" ).append("\n"); 
		query.append("                      , D1.FOIL_CSM" ).append("\n"); 
		query.append("                      , D1.FOIL_UC_AMT" ).append("\n"); 
		query.append("                      , D1.DOIL_CSM" ).append("\n"); 
		query.append("                      , D1.DOIL_UC_AMT" ).append("\n"); 
		query.append("                      , D1.FOIL_ESTM_CSM_WGT" ).append("\n"); 
		query.append("                      , D1.DOIL_ESTM_CSM_WGT" ).append("\n"); 
		query.append("                   FROM" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                                 SELECT MIN(A.FLAG) FLAG" ).append("\n"); 
		query.append("                                      , A.COST_YRMON" ).append("\n"); 
		query.append("                                      , A.COST_WK" ).append("\n"); 
		query.append("                                      , A.SLAN_CD" ).append("\n"); 
		query.append("                                      , A.RLANE_CD" ).append("\n"); 
		query.append("                                      , A.DIR_CD" ).append("\n"); 
		query.append("                                      , A.VSL_CD" ).append("\n"); 
		query.append("                                      , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      , A.TRD_CD" ).append("\n"); 
		query.append("                                      , A.SUB_TRD_CD" ).append("\n"); 
		query.append("                                      , MAX(B.FCM_ESTM_WRK_DT) FCM_ESTM_WRK_DT" ).append("\n"); 
		query.append("                                      , MAX(B.FCM_ESTM_WRK_SEQ) KEEP(DENSE_RANK LAST ORDER BY B.FCM_ESTM_WRK_DT ) FCM_ESTM_WRK_SEQ" ).append("\n"); 
		query.append("                                      , NVL(MIN(A.FOIL_CSM), 0) FOIL_CSM" ).append("\n"); 
		query.append("                                      , NVL(MIN(A.FOIL_UC_AMT), 0) FOIL_UC_AMT" ).append("\n"); 
		query.append("                                      , NVL(MIN(A.DOIL_CSM), 0) DOIL_CSM" ).append("\n"); 
		query.append("                                      , NVL(MIN(A.DOIL_UC_AMT), 0) DOIL_UC_AMT" ).append("\n"); 
		query.append("                                      , NVL(MIN(B.FOIL_ESTM_CSM_WGT) KEEP(DENSE_RANK LAST ORDER BY B.FCM_ESTM_WRK_DT, B.FCM_ESTM_WRK_SEQ), 0) FOIL_ESTM_CSM_WGT" ).append("\n"); 
		query.append("                                      , NVL(MIN(B.DOIL_ESTM_CSM_WGT) KEEP(DENSE_RANK LAST ORDER BY B.FCM_ESTM_WRK_DT, B.FCM_ESTM_WRK_SEQ), 0) DOIL_ESTM_CSM_WGT" ).append("\n"); 
		query.append("                                   FROM TMP_MON_VVD A" ).append("\n"); 
		query.append("                                      , FCM_ESTM_WK_CSM_IF B" ).append("\n"); 
		query.append("                                  WHERE A.COST_YRMON = B.BSE_YRMON(+)" ).append("\n"); 
		query.append("                                    AND A.COST_WK    = B.BSE_WK(+)" ).append("\n"); 
		query.append("                                    AND A.VSL_CD     = B.VSL_CD(+)" ).append("\n"); 
		query.append("                                    AND A.SKD_VOY_NO = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                                    AND A.DIR_CD     = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                                    AND A.TRD_CD     = B.TRD_CD(+)" ).append("\n"); 
		query.append("                                    AND A.SUB_TRD_CD = B.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("                                    AND A.COST_YRMON LIKE @[sls_yrmon]||'%'" ).append("\n"); 
		query.append("                                    AND A.COST_WK = @[cost_wk]" ).append("\n"); 
		query.append("		                            -- if 절 사용" ).append("\n"); 
		query.append("									#if (${slan_cd} != '')" ).append("\n"); 
		query.append("		                                AND A.SLAN_CD    =@[slan_cd]" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("									#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("		                                AND A.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("									#if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("		                            	AND A.VSL_CD     = @[f_vsl_cd] " ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("									#if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("		                                AND A.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("									#if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("		                                AND A.DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("									#end                                    " ).append("\n"); 
		query.append("                               GROUP BY A.COST_YRMON" ).append("\n"); 
		query.append("                                      , A.COST_WK" ).append("\n"); 
		query.append("                                      , A.SLAN_CD" ).append("\n"); 
		query.append("                                      , A.RLANE_CD" ).append("\n"); 
		query.append("                                      , A.DIR_CD" ).append("\n"); 
		query.append("                                      , A.VSL_CD" ).append("\n"); 
		query.append("                                      , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      , A.TRD_CD" ).append("\n"); 
		query.append("                                      , A.SUB_TRD_CD" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                        D1" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("        -- Ref를 구하기 위한 쿼리: 최근 12주차 중에 가장 최근의 FO Cons 값을 조회" ).append("\n"); 
		query.append("      , (" ).append("\n"); 
		query.append("                 SELECT SLAN_CD" ).append("\n"); 
		query.append("                      , RLANE_CD" ).append("\n"); 
		query.append("                      , DIR_CD" ).append("\n"); 
		query.append("                      , VSL_CD" ).append("\n"); 
		query.append("                      , COST_YRMON" ).append("\n"); 
		query.append("                      , COST_WK" ).append("\n"); 
		query.append("                      , SKD_VOY_NO" ).append("\n"); 
		query.append("                      , LAST_FOIL_CSM" ).append("\n"); 
		query.append("                      , DECODE(LAST_FOIL_CSM, 0, 'No data', 'YR_'||SUBSTR( COST_YRMON, 0, 4)||'_WK_'||COST_WK)" ).append("\n"); 
		query.append("                        LAST_FOIL_CSM_REF" ).append("\n"); 
		query.append("                   FROM" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                                -- MAX(SKD_VOY_NO)로 최근 vvd정보를 조회" ).append("\n"); 
		query.append("                                 SELECT SLAN_CD" ).append("\n"); 
		query.append("                                      , RLANE_CD" ).append("\n"); 
		query.append("                                      , DIR_CD" ).append("\n"); 
		query.append("                                      , VSL_CD" ).append("\n"); 
		query.append("									  , MAX(COST_YRMON) KEEP(DENSE_RANK LAST ORDER BY SKD_VOY_NO ) COST_YRMON" ).append("\n"); 
		query.append("									  , MAX(COST_WK) KEEP(DENSE_RANK LAST ORDER BY SKD_VOY_NO ) COST_WK" ).append("\n"); 
		query.append("                                      , MAX(SKD_VOY_NO) SKD_VOY_NO" ).append("\n"); 
		query.append("                                      , NVL(MAX(FOIL_CSM) KEEP(DENSE_RANK LAST ORDER BY SKD_VOY_NO ), 0) LAST_FOIL_CSM" ).append("\n"); 
		query.append("                                   FROM TMP_MON_VVD" ).append("\n"); 
		query.append("                                  WHERE SUBSTR(COST_YRMON, 1, 4)||COST_WK BETWEEN PREV_WK_12 AND PREV_WK_1" ).append("\n"); 
		query.append("                               GROUP BY SLAN_CD" ).append("\n"); 
		query.append("                                      , RLANE_CD" ).append("\n"); 
		query.append("                                      , DIR_CD" ).append("\n"); 
		query.append("                                      , VSL_CD" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 
		query.append("  WHERE A.SLAN_CD  = B.SLAN_CD(+)" ).append("\n"); 
		query.append("    AND A.RLANE_CD = B.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND A.VSL_CD   = B.VSL_CD(+)" ).append("\n"); 
		query.append("    AND A.DIR_CD   = B.DIR_CD(+)" ).append("\n"); 
		query.append("ORDER BY SLAN_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 

	}
}