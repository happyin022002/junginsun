/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkCostDBDAOSearchPortTariffDetailListRSQL.java
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

public class NetworkCostDBDAOSearchPortTariffDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.07.06 이석준 CHM-201111498-01
	  *                  터미널별 PSO 및 MAS Data 수정가능토록 조회 쿼리
	  * 2014.12.12 [관리회계TF] COA_MON_VVD 에서 SUB_TRD_CD != 'IP' 
	  * 2015.01.23 김시몬 [CHM-201533657] PM1,IMU 팬듈럼 Lane에 대해 100% Ratio적용, 운항통과료 100% Ratio적용
	  * 2015.02.23 김시몬 PORT_RATIO, CNL_RATIO 구할때 sum에서 max로 변경
	  * 2015.02.25 김시몬 하나의 월에 2개 주차로 동일 S.LANE /VVD가 존재할 경우 MAX 주차것으로 보여준다(2배로 보이지 않게)
	  * 2015.04.01 김시몬 [관리회계개선TF] PSG LANE 팬듈럼 처리 추가
	  * </pre>
	  */
	public NetworkCostDBDAOSearchPortTariffDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selrlane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearweek",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchPortTariffDetailListRSQL").append("\n"); 
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
		query.append("SELECT SLAN_CD" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , SKD_DIR_CD" ).append("\n"); 
		query.append("      , SUBSTR(YD_CD, 1, 5) PORT_CD" ).append("\n"); 
		query.append("      , SUBSTR(YD_CD, 6, 2) CY_CD" ).append("\n"); 
		query.append("      , MAX(CURR_CD) CURR_CD" ).append("\n"); 
		query.append("      , MAX(PORT_USD_AMT) PORT_USD_AMT" ).append("\n"); 
		query.append("      , MAX(PORT_PSO_AMT) KEEP (DENSE_RANK FIRST ORDER BY PORT_USD_AMT DESC) PORT_PSO_AMT" ).append("\n"); 
		query.append("      , PORT_RATIO * 100 || '%' PORT_RATIO" ).append("\n"); 
		query.append("      , MAX(CNL_USD_AMT) KEEP (DENSE_RANK FIRST ORDER BY PORT_USD_AMT DESC) CNL_USD_AMT" ).append("\n"); 
		query.append("      , MAX(CNL_PSO_AMT) CNL_PSO_AMT" ).append("\n"); 
		query.append("      , CNL_RATIO * 100 || '%' CNL_RATIO" ).append("\n"); 
		query.append("      , MAX(CRE_DT) KEEP (DENSE_RANK FIRST ORDER BY PORT_USD_AMT DESC) CRE_DT" ).append("\n"); 
		query.append("      , MAX(CLPT_SEQ) KEEP (DENSE_RANK FIRST ORDER BY PORT_USD_AMT DESC) CLPT_SEQ" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("        (SELECT SLAN_CD" ).append("\n"); 
		query.append("              , VSL_CD" ).append("\n"); 
		query.append("              , SKD_VOY_NO" ).append("\n"); 
		query.append("              , DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("              , TML_CD" ).append("\n"); 
		query.append("              , YD_CD" ).append("\n"); 
		query.append("              , CURRENCY AS CURR_CD" ).append("\n"); 
		query.append("              , PORT_USD_AMT" ).append("\n"); 
		query.append("              , PSO_PORT_AMT * PORT_RATIO AS PORT_PSO_AMT" ).append("\n"); 
		query.append("              , PORT_RATIO" ).append("\n"); 
		query.append("              , CNL_USD_AMT" ).append("\n"); 
		query.append("              , PSO_CNL_AMT * CNL_RATIO AS CNL_PSO_AMT" ).append("\n"); 
		query.append("              , CNL_RATIO" ).append("\n"); 
		query.append("              , CRE_USR_ID" ).append("\n"); 
		query.append("              , WRK_DT AS CRE_DT" ).append("\n"); 
		query.append("              , CLPT_SEQ" ).append("\n"); 
		query.append("           FROM" ).append("\n"); 
		query.append("                (SELECT A1.SLAN_CD" ).append("\n"); 
		query.append("                      , A1.VSL_CD" ).append("\n"); 
		query.append("                      , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , A1.DIR_CD" ).append("\n"); 
		query.append("                      , A5.TML_CD" ).append("\n"); 
		query.append("                      , A4.YD_CD" ).append("\n"); 
		query.append("                      , 'USD' CURRENCY" ).append("\n"); 
		query.append("                      , SUM((CASE WHEN SUBSTR(NVL(A4.YD_CD, A5.TML_CD), 1, 5) IN ('EGSUZ', 'PAPAC') THEN 0" ).append("\n"); 
		query.append("                                  ELSE A6.INV_USD_AMT END) ) PSO_PORT_AMT" ).append("\n"); 
		query.append("                      , SUM(A5.PORT_USD_AMT) PORT_USD_AMT" ).append("\n"); 
		query.append("                      , MAX(CASE WHEN SUBSTR(NVL(A4.YD_CD, A5.TML_CD), 1, 5) NOT IN ('EGSUZ', 'PAPAC') THEN " ).append("\n"); 
		query.append("                                      CASE WHEN A4.TURN_PORT_FLG = 'N' AND A4.TURN_PORT_IND_CD = 'N' THEN 1" ).append("\n"); 
		query.append("                                           WHEN A1.SLAN_CD IN ('IMU','PM1','PSG','HPM','CPM') THEN 1" ).append("\n"); 
		query.append("                                           ELSE 0.5" ).append("\n"); 
		query.append("                                      END" ).append("\n"); 
		query.append("                                 ELSE 0" ).append("\n"); 
		query.append("                            END) PORT_RATIO" ).append("\n"); 
		query.append("                      , SUM((CASE WHEN SUBSTR(NVL(A4.YD_CD, A5.TML_CD), 1, 5) IN ('EGSUZ', 'PAPAC') THEN A6.INV_USD_AMT " ).append("\n"); 
		query.append("                                  ELSE 0 END) ) PSO_CNL_AMT" ).append("\n"); 
		query.append("                      , SUM(A5.CNL_USD_AMT) CNL_USD_AMT" ).append("\n"); 
		query.append("                      , MAX(CASE WHEN SUBSTR(NVL(A4.YD_CD, A5.TML_CD), 1, 5) IN ('EGSUZ', 'PAPAC') THEN 1 -- 운항통과료는 100% 계산" ).append("\n"); 
		query.append("                                      --CASE WHEN A4.TURN_PORT_FLG = 'N' AND A4.TURN_PORT_IND_CD = 'N' THEN 1" ).append("\n"); 
		query.append("                                      --     ELSE 0.5" ).append("\n"); 
		query.append("                                      --END" ).append("\n"); 
		query.append("                                 ELSE 0" ).append("\n"); 
		query.append("                            END) CNL_RATIO" ).append("\n"); 
		query.append("                      , A6.WRK_DT" ).append("\n"); 
		query.append("                      , A6.WRK_SEQ" ).append("\n"); 
		query.append("                      , MIN(A4.CLPT_SEQ) CLPT_SEQ" ).append("\n"); 
		query.append("                      , LAST_VALUE (A6.WRK_DT IGNORE NULLS) OVER (PARTITION BY A1.VSL_CD, A1.SKD_VOY_NO, A1.DIR_CD ) LST_WRK_DT" ).append("\n"); 
		query.append("                      , LAST_VALUE (A6.WRK_SEQ IGNORE NULLS) OVER (PARTITION BY A1.VSL_CD, A1.SKD_VOY_NO, A1.DIR_CD ) LST_WRK_SEQ" ).append("\n"); 
		query.append("                      , A5.CRE_USR_ID" ).append("\n"); 
		query.append("                  FROM --MAS_MON_VVD A1" ).append("\n"); 
		query.append("                       (" ).append("\n"); 
		query.append("                        SELECT COST_YRMON,SLS_YRMON,COST_WK,TRD_CD,RLANE_CD,SLAN_CD,IOC_CD,VSL_CD,SKD_VOY_NO,DIR_CD,N1ST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("                          FROM MAS_MON_VVD A" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_yrtype} == 'W')" ).append("\n"); 
		query.append("                           AND SLS_YRMON LIKE SUBSTR(@[f_yearweek],1,4) || '%' AND COST_WK = SUBSTR(@[f_yearweek], 6,2)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                           AND COST_YRMON   = REPLACE(@[f_yearweek],'-')" ).append("\n"); 
		query.append("#end                             " ).append("\n"); 
		query.append("                           AND VSL_CD         = @[f_vsl_cd]" ).append("\n"); 
		query.append("                           AND SKD_VOY_NO     = @[f_skd_voy_no]" ).append("\n"); 
		query.append("                           AND DIR_CD         = @[f_dir_cd]    " ).append("\n"); 
		query.append("                           AND SLAN_CD        = @[f_slan_cd]  " ).append("\n"); 
		query.append("#if (${f_selrlane} != '' && ${f_selrlane} != 'All')" ).append("\n"); 
		query.append("                           AND RLANE_CD       = @[f_selrlane]" ).append("\n"); 
		query.append("#end                                                  " ).append("\n"); 
		query.append("                           AND SUB_TRD_CD    != 'IP'" ).append("\n"); 
		query.append("                           AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                           AND (COST_YRMON,SLAN_CD,IOC_CD,VSL_CD,SKD_VOY_NO,DIR_CD,COST_WK) " ).append("\n"); 
		query.append("                                  IN (SELECT COST_YRMON,SLAN_CD,IOC_CD,VSL_CD,SKD_VOY_NO,DIR_CD,MAX(COST_WK)" ).append("\n"); 
		query.append("                                        FROM MAS_MON_VVD" ).append("\n"); 
		query.append("                                       WHERE 1=1" ).append("\n"); 
		query.append("                                         AND VSL_CD         = @[f_vsl_cd]" ).append("\n"); 
		query.append("                                         AND SKD_VOY_NO     = @[f_skd_voy_no]" ).append("\n"); 
		query.append("                                         AND DIR_CD         = @[f_dir_cd]    " ).append("\n"); 
		query.append("                                         AND SLAN_CD        = @[f_slan_cd]  " ).append("\n"); 
		query.append("#if (${f_selrlane} != ''  && ${f_selrlane} != 'All')" ).append("\n"); 
		query.append("                                         AND RLANE_CD        = @[f_selrlane]" ).append("\n"); 
		query.append("#end                                         " ).append("\n"); 
		query.append("#if (${f_yrtype} == 'W')" ).append("\n"); 
		query.append("                                         AND SLS_YRMON LIKE SUBSTR(@[f_yearweek],1,4) || '%' AND COST_WK = SUBSTR(@[f_yearweek], 6,2)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                         AND COST_YRMON   = REPLACE(@[f_yearweek],'-')" ).append("\n"); 
		query.append("#end                                          " ).append("\n"); 
		query.append("                                         AND SUB_TRD_CD    != 'IP'" ).append("\n"); 
		query.append("                                         AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                                       GROUP BY COST_YRMON,SLAN_CD,IOC_CD,VSL_CD,SKD_VOY_NO,DIR_CD" ).append("\n"); 
		query.append("                                     )                   " ).append("\n"); 
		query.append("                        ) A1" ).append("\n"); 
		query.append("                      , MAS_VSL_RGST A2" ).append("\n"); 
		query.append("                      , MAS_LANE_RGST A3" ).append("\n"); 
		query.append("                      , VSK_VSL_PORT_SKD A4" ).append("\n"); 
		query.append("                      , MAS_PORT_TRF A5" ).append("\n"); 
		query.append("                      , PSO_TGT_VVD_EXPN A6" ).append("\n"); 
		query.append("                  WHERE NVL(A3.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                    AND A1.VSL_CD             = A2.VSL_CD" ).append("\n"); 
		query.append("                    AND A2.VOP_CD             = 'SML'" ).append("\n"); 
		query.append("                    AND A1.TRD_CD             = A3.TRD_CD" ).append("\n"); 
		query.append("                    AND A1.RLANE_CD           = A3.RLANE_CD" ).append("\n"); 
		query.append("                    AND A1.IOC_CD             = A3.IOC_CD" ).append("\n"); 
		query.append("                    AND A1.DIR_CD             = A3.DIR_CD" ).append("\n"); 
		query.append("                    AND A3.TRD_CD            <> 'COM'" ).append("\n"); 
		query.append("                    AND A3.SUB_TRD_CD        <> 'IP'" ).append("\n"); 
		query.append("                    AND A3.VSL_LANE_TP_CD    IN ('JO', 'SC')" ).append("\n"); 
		query.append("                    AND TO_CHAR(A1.N1ST_LODG_PORT_ETD_DT, 'YYYYMMDD') " ).append("\n"); 
		query.append("                        BETWEEN NVL(TO_CHAR(A2.VSL_APLY_FM_DT, 'YYYYMMDD'), '19000101') " ).append("\n"); 
		query.append("                            AND NVL(TO_CHAR(A2.VSL_APLY_TO_DT, 'YYYYMMDD'), '99991231')" ).append("\n"); 
		query.append("                    AND A1.VSL_CD                    = A4.VSL_CD" ).append("\n"); 
		query.append("                    AND A1.SKD_VOY_NO                = A4.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND A1.DIR_CD                    = A4.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND A1.SLAN_CD                   = A4.SLAN_CD" ).append("\n"); 
		query.append("                    AND NVL(A4.SKD_CNG_STS_CD, 'N') <> 'S'" ).append("\n"); 
		query.append("                    AND A4.SLAN_CD                   =A5.SLAN_CD(+)" ).append("\n"); 
		query.append("                    AND A4.VSL_CD                    =A5.VSL_CD(+)" ).append("\n"); 
		query.append("                    AND A4.SKD_VOY_NO                =A5.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                    AND A4.SKD_DIR_CD                =A5.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                    AND A4.YD_CD          = A5.TML_CD(+)" ).append("\n"); 
		query.append("                    AND A4.VSL_CD         = A6.VSL_CD(+)" ).append("\n"); 
		query.append("                    AND A4.SKD_VOY_NO     = A6.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                    AND A4.SKD_DIR_CD     = A6.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                    AND A4.YD_CD          =A6.YD_CD(+)" ).append("\n"); 
		query.append("                    AND A6.PSO_BZTP_CD(+) = '7' " ).append("\n"); 
		query.append("               GROUP BY A1.SLAN_CD" ).append("\n"); 
		query.append("                      , A1.VSL_CD" ).append("\n"); 
		query.append("                      , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , A1.DIR_CD" ).append("\n"); 
		query.append("                      , A4.YD_CD" ).append("\n"); 
		query.append("                      , A5.TML_CD" ).append("\n"); 
		query.append("                      , A6.WRK_DT" ).append("\n"); 
		query.append("                      , A6.WRK_SEQ" ).append("\n"); 
		query.append("                      , A1.VSL_CD" ).append("\n"); 
		query.append("                      , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , A1.DIR_CD" ).append("\n"); 
		query.append("                      , A5.CRE_USR_ID" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("          WHERE (WRK_DT IS NULL OR WRK_DT||WRK_SEQ = LST_WRK_DT||LST_WRK_SEQ)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("GROUP BY SLAN_CD" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , SKD_DIR_CD" ).append("\n"); 
		query.append("      , YD_CD" ).append("\n"); 
		query.append("      , PORT_RATIO" ).append("\n"); 
		query.append("      , CNL_RATIO" ).append("\n"); 
		query.append("ORDER BY CLPT_SEQ" ).append("\n"); 

	}
}