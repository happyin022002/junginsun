/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkCostDBDAOSearchBunkerTariffYmListRSQL.java
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

public class NetworkCostDBDAOSearchBunkerTariffYmListRSQL implements ISQLTemplate{

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
	public NetworkCostDBDAOSearchBunkerTariffYmListRSQL(){
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
		query.append("FileName : NetworkCostDBDAOSearchBunkerTariffYmListRSQL").append("\n"); 
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
		query.append("(" ).append("\n"); 
		query.append("         SELECT DECODE(B.VSL_CD||B.SKD_VOY_NO||B.DIR_CD, A.VSL_CD||A.SKD_VOY_NO||A.DIR_CD, 'R', 'I') FLAG" ).append("\n"); 
		query.append("              , A.SLS_YRMON" ).append("\n"); 
		query.append("              , A.COST_YRMON" ).append("\n"); 
		query.append("              , A.COST_WK" ).append("\n"); 
		query.append("              , A.SLAN_CD" ).append("\n"); 
		query.append("              , A.RLANE_CD" ).append("\n"); 
		query.append("              , A.DIR_CD" ).append("\n"); 
		query.append("              , A.VSL_CD" ).append("\n"); 
		query.append("              , A.SKD_VOY_NO" ).append("\n"); 
		query.append("              , A.TRD_CD" ).append("\n"); 
		query.append("              , A.SUB_TRD_CD" ).append("\n"); 
		query.append("              , NVL(B.FOIL_CSM, 0) FOIL_CSM" ).append("\n"); 
		query.append("              , NVL(B.FOIL_UC_AMT, 0) FOIL_UC_AMT" ).append("\n"); 
		query.append("              , NVL(B.DOIL_CSM, 0) DOIL_CSM" ).append("\n"); 
		query.append("              , NVL(B.DOIL_UC_AMT, 0) DOIL_UC_AMT" ).append("\n"); 
		query.append("           FROM" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                        SELECT DISTINCT A1.COST_YRMON" ).append("\n"); 
		query.append("                              , A1.SLS_YRMON" ).append("\n"); 
		query.append("                              , A1.COST_WK" ).append("\n"); 
		query.append("                              , A1.SLAN_CD" ).append("\n"); 
		query.append("                              , A1.RLANE_CD" ).append("\n"); 
		query.append("                              , A1.DIR_CD" ).append("\n"); 
		query.append("                              , A1.VSL_CD" ).append("\n"); 
		query.append("                              , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                              , A1.TRD_CD" ).append("\n"); 
		query.append("                              , A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                           FROM MAS_MON_VVD A1" ).append("\n"); 
		query.append("                              , MAS_VSL_RGST A2" ).append("\n"); 
		query.append("                              , MAS_LANE_RGST A3" ).append("\n"); 
		query.append("                          WHERE A1.TRD_CD          = A3.TRD_CD" ).append("\n"); 
		query.append("                            AND A1.RLANE_CD        = A3.RLANE_CD" ).append("\n"); 
		query.append("                            AND A1.IOC_CD          = A3.IOC_CD" ).append("\n"); 
		query.append("                            AND A1.DIR_CD          = A3.DIR_CD" ).append("\n"); 
		query.append("                            AND A1.COST_YRMON      =  @[sls_yrmon]||@[cost_wk]" ).append("\n"); 
		query.append("                            -- if 절 사용" ).append("\n"); 
		query.append("							#if (${slan_cd} != '')" ).append("\n"); 
		query.append("                                AND A1.SLAN_CD    =@[slan_cd]" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("                                AND A1.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("                            	AND A1.VSL_CD     = @[f_vsl_cd] " ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("                                AND A1.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("                                AND A1.DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("                            AND A3.TRD_CD         <> 'COM'" ).append("\n"); 
		query.append("                            AND A3.VSL_LANE_TP_CD IN ('JO', 'SC')" ).append("\n"); 
		query.append("                            AND A1.VSL_CD          = A2.VSL_CD" ).append("\n"); 
		query.append("                            AND A1.N1ST_LODG_PORT_ETD_DT BETWEEN A2.VSL_APLY_FM_DT AND A2.VSL_APLY_TO_DT" ).append("\n"); 
		query.append("                            AND A2.VOP_CD = 'SML'                     " ).append("\n"); 
		query.append("                            AND A1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND A2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            AND A3.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("              , MAS_BNK_TRF B" ).append("\n"); 
		query.append("          WHERE A.SLAN_CD    = B.SLAN_CD (+)" ).append("\n"); 
		query.append("            AND A.RLANE_CD   = B.RLANE_CD (+)" ).append("\n"); 
		query.append("            AND A.VSL_CD     = B.VSL_CD (+)" ).append("\n"); 
		query.append("            AND A.SKD_VOY_NO = B.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("            AND A.DIR_CD     = B.DIR_CD (+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" SELECT FLAG" ).append("\n"); 
		query.append("      , COST_STS" ).append("\n"); 
		query.append("      , COST_YRMON" ).append("\n"); 
		query.append("      , COST_WK" ).append("\n"); 
		query.append("      , SLAN_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 
		query.append("      , FOIL_CSM" ).append("\n"); 
		query.append("      , FOIL_UC_AMT" ).append("\n"); 
		query.append("      , DOIL_CSM" ).append("\n"); 
		query.append("      , DOIL_UC_AMT" ).append("\n"); 
		query.append("      , FOIL_ESTM_CSM_WGT" ).append("\n"); 
		query.append("      , DOIL_ESTM_CSM_WGT" ).append("\n"); 
		query.append("      , NVL(SUBSTR(FOIL_12_DESC, 1, INSTR(FOIL_12_DESC, '|', 1, 1) - 1), 0) LAST_FOIL_CSM" ).append("\n"); 
		query.append("      , NVL(SUBSTR(FOIL_12_DESC, INSTR(FOIL_12_DESC, '|', 1, 1) + 1 ), 'No data') LAST_FOIL_CSM_REF" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" SELECT D1.FLAG" ).append("\n"); 
		query.append("      , CASE WHEN NVL(D1.FOIL_CSM, 0) = 0 AND D1.FOIL_ESTM_CSM_WGT = 0 THEN 'N' " ).append("\n"); 
		query.append("             WHEN NVL(D1.FOIL_CSM, 0) = 0 AND D1.FOIL_ESTM_CSM_WGT > 0 THEN 'F' " ).append("\n"); 
		query.append("             WHEN NVL(D1.FOIL_CSM, 0) > 0 AND D1.FOIL_ESTM_CSM_WGT = 0 THEN 'C' " ).append("\n"); 
		query.append("             ELSE 'A' END AS COST_STS" ).append("\n"); 
		query.append("      , D1.COST_YRMON" ).append("\n"); 
		query.append("      , D1.SLS_YRMON" ).append("\n"); 
		query.append("      , D1.COST_WK" ).append("\n"); 
		query.append("      , D1.SLAN_CD" ).append("\n"); 
		query.append("      , D1.RLANE_CD" ).append("\n"); 
		query.append("      , D1.VSL_CD" ).append("\n"); 
		query.append("      , D1.SKD_VOY_NO" ).append("\n"); 
		query.append("      , D1.DIR_CD" ).append("\n"); 
		query.append("      , D1.FOIL_CSM" ).append("\n"); 
		query.append("      , D1.FOIL_UC_AMT" ).append("\n"); 
		query.append("      , D1.DOIL_CSM" ).append("\n"); 
		query.append("      , D1.DOIL_UC_AMT" ).append("\n"); 
		query.append("      , D1.FOIL_ESTM_CSM_WGT" ).append("\n"); 
		query.append("      , D1.DOIL_ESTM_CSM_WGT" ).append("\n"); 
		query.append("      , (SELECT MAS_GET_BNK_LTST_WK_FNC(SUBSTR(D1.SLS_YRMON,1,4),D1.COST_WK,D1.SLAN_CD,D1.RLANE_CD,D1.VSL_CD,D1.DIR_CD) FROM DUAL) FOIL_12_DESC" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("                 SELECT MIN(A.FLAG) FLAG" ).append("\n"); 
		query.append("                      , A.COST_YRMON" ).append("\n"); 
		query.append("                      , A.SLS_YRMON" ).append("\n"); 
		query.append("                      , A.COST_WK" ).append("\n"); 
		query.append("                      , A.SLAN_CD" ).append("\n"); 
		query.append("                      , A.RLANE_CD" ).append("\n"); 
		query.append("                      , A.DIR_CD" ).append("\n"); 
		query.append("                      , A.VSL_CD" ).append("\n"); 
		query.append("                      , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , A.TRD_CD" ).append("\n"); 
		query.append("                      , A.SUB_TRD_CD" ).append("\n"); 
		query.append("                      , MAX(B.FCM_ESTM_WRK_DT) FCM_ESTM_WRK_DT" ).append("\n"); 
		query.append("                      , MAX(B.FCM_ESTM_WRK_SEQ) KEEP(DENSE_RANK LAST ORDER BY B.FCM_ESTM_WRK_DT ) FCM_ESTM_WRK_SEQ" ).append("\n"); 
		query.append("                      , NVL(MIN(A.FOIL_CSM), 0) FOIL_CSM" ).append("\n"); 
		query.append("                      , NVL(MIN(A.FOIL_UC_AMT), 0) FOIL_UC_AMT" ).append("\n"); 
		query.append("                      , NVL(MIN(A.DOIL_CSM), 0) DOIL_CSM" ).append("\n"); 
		query.append("                      , NVL(MIN(A.DOIL_UC_AMT), 0) DOIL_UC_AMT" ).append("\n"); 
		query.append("                      , NVL(MIN(B.FOIL_ESTM_CSM_WGT) KEEP(DENSE_RANK LAST ORDER BY B.FCM_ESTM_WRK_DT, B.FCM_ESTM_WRK_SEQ), 0) FOIL_ESTM_CSM_WGT" ).append("\n"); 
		query.append("                      , NVL(MIN(B.DOIL_ESTM_CSM_WGT) KEEP(DENSE_RANK LAST ORDER BY B.FCM_ESTM_WRK_DT, B.FCM_ESTM_WRK_SEQ), 0) DOIL_ESTM_CSM_WGT" ).append("\n"); 
		query.append("                   FROM TMP_MON_VVD A" ).append("\n"); 
		query.append("                      , FCM_ESTM_WK_CSM_IF B" ).append("\n"); 
		query.append("                  WHERE A.SLS_YRMON  = B.BSE_YRMON(+)" ).append("\n"); 
		query.append("                    AND A.COST_WK    = B.BSE_WK(+)" ).append("\n"); 
		query.append("                    AND A.VSL_CD     = B.VSL_CD(+)" ).append("\n"); 
		query.append("                    AND A.SKD_VOY_NO = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                    AND A.DIR_CD     = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                    AND A.TRD_CD     = B.TRD_CD(+)" ).append("\n"); 
		query.append("                    AND A.SUB_TRD_CD = B.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("                    AND A.COST_YRMON =   @[sls_yrmon]||@[cost_wk]" ).append("\n"); 
		query.append("               GROUP BY A.COST_YRMON" ).append("\n"); 
		query.append("                      , A.SLS_YRMON" ).append("\n"); 
		query.append("                      , A.COST_WK" ).append("\n"); 
		query.append("                      , A.SLAN_CD" ).append("\n"); 
		query.append("                      , A.RLANE_CD" ).append("\n"); 
		query.append("                      , A.DIR_CD" ).append("\n"); 
		query.append("                      , A.VSL_CD" ).append("\n"); 
		query.append("                      , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , A.TRD_CD" ).append("\n"); 
		query.append("                      , A.SUB_TRD_CD" ).append("\n"); 
		query.append("        ) D1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY SLAN_CD" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , DIR_CD" ).append("\n"); 

	}
}