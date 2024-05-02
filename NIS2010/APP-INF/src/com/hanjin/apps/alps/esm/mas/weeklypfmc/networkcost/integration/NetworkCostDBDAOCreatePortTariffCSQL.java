/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkCostDBDAOCreatePortTariffCSQL.java
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

public class NetworkCostDBDAOCreatePortTariffCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History----------------------------------
	  * 2010.05.06 이행지 CHM-201003663-Port tariff vessel class 변경
	  * 2011.09.27 전윤주 CHM-201113589-01 - NEW_OP_DYS_FLG    = 'Y' 로 수정
	  * </pre>
	  */
	public NetworkCostDBDAOCreatePortTariffCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selclass",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selslane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOCreatePortTariffCSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_PORT_TRF(" ).append("\n"); 
		query.append("     COST_YRMON" ).append("\n"); 
		query.append("   , SLAN_CD" ).append("\n"); 
		query.append("   , SKD_DIR_CD" ).append("\n"); 
		query.append("   , VSL_CLSS_CAPA" ).append("\n"); 
		query.append("   , TML_CD" ).append("\n"); 
		query.append("   , LOCL_CURR_CD" ).append("\n"); 
		query.append("   , LOCL_PORT_AMT" ).append("\n"); 
		query.append("   , LOCL_CNL_AMT" ).append("\n"); 
		query.append("   , PORT_USD_AMT" ).append("\n"); 
		query.append("   , CNL_USD_AMT" ).append("\n"); 
		query.append("   , CRE_USR_ID" ).append("\n"); 
		query.append("   , CRE_DT" ).append("\n"); 
		query.append("   , UPD_USR_ID" ).append("\n"); 
		query.append("   , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     D2.COST_YRMON                                                          COST_YRMON" ).append("\n"); 
		query.append("    ,D2.SLAN_CD                                                             SLAN_CD" ).append("\n"); 
		query.append("    ,D2.DIR_CD                                                              DIR_CD" ).append("\n"); 
		query.append("    ,D2.VSL_CLSS_CAPA                                                       VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    ,NVL(D1.TML_CD, D2.TML_CD)                                              TML_CD" ).append("\n"); 
		query.append("    ,NVL(D1.LOCL_CURR_CD,D2.CURR_CD)                                        LOCL_CURR_CD" ).append("\n"); 
		query.append("    ,NVL(D1.LOCL_PORT_AMT, DECODE(D2.COST_CD, '53101000', D2.LCL_COST,0))   LOCL_PORT_AMT" ).append("\n"); 
		query.append("    ,NVL(D1.LOCL_CNL_AMT, DECODE(D2.COST_CD, '53102000', D2.LCL_COST,0))    LOCL_CNL_AMT" ).append("\n"); 
		query.append("    ,NVL(D1.PORT_USD_AMT, DECODE(D2.COST_CD, '53101000', D2.USD_COST,0))    PORT_USD_AMT" ).append("\n"); 
		query.append("    ,NVL(D1.CNL_USD_AMT, DECODE(D2.COST_CD, '53102000', D2.USD_COST,0))     CNL_USD_AMT" ).append("\n"); 
		query.append("    ,NVL(D1.CRE_USR_ID, @[cre_usr_id])                                      CRE_USR_ID" ).append("\n"); 
		query.append("    ,NVL(D1.CRE_DT, SYSDATE)                                                CRE_DT" ).append("\n"); 
		query.append("    ,NVL(D1.UPD_USR_ID, @[upd_usr_id])                                      UPD_USR_ID" ).append("\n"); 
		query.append("    ,NVL(D1.UPD_DT, SYSDATE)                                                UPD_DT" ).append("\n"); 
		query.append("  FROM MAS_PORT_TRF D1" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        /* 3 step ---------------------------------------------------------------*/" ).append("\n"); 
		query.append("        SELECT COST_YRMON              COST_YRMON" ).append("\n"); 
		query.append("              ,SLAN_CD                 SLAN_CD" ).append("\n"); 
		query.append("              ,DIR_CD                  DIR_CD" ).append("\n"); 
		query.append("              ,NVL(VSL_CLSS_CAPA, 0)   VSL_CLSS_CAPA" ).append("\n"); 
		query.append("              ,TML_CD                  TML_CD" ).append("\n"); 
		query.append("              ,CURR_CD                 CURR_CD" ).append("\n"); 
		query.append("              ,VSL_SIZE                VSL_SIZE" ).append("\n"); 
		query.append("              ,COST_CD                 COST_CD" ).append("\n"); 
		query.append("              ,LCL_COST                LCL_COST" ).append("\n"); 
		query.append("              ,USD_COST                USD_COST" ).append("\n"); 
		query.append("              ,C_COST                  C_COST" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                /* 2 step ----------------------------------------------------------------*/" ).append("\n"); 
		query.append("                SELECT C1.COST_YRMON                                    COST_YRMON" ).append("\n"); 
		query.append("                      ,C1.SLAN_CD                                       SLAN_CD" ).append("\n"); 
		query.append("                      ,C1.DIR_CD                                        DIR_CD" ).append("\n"); 
		query.append("                      ,C1.VSL_CLSS_CAPA                                 VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                      ,NVL(C2.TML_CD, C1.TML_CD)                        TML_CD -- 순위 pso, prd" ).append("\n"); 
		query.append("                      ,C1.TML_CD                                        PRD_TML_CD" ).append("\n"); 
		query.append("                      ,C2.TML_CD                                        PSO_TML_CD" ).append("\n"); 
		query.append("                       ,DECODE(C1.TML_CD, C2.TML_CD, C2.CURR_CD, 'XXX') TMP_CURR" ).append("\n"); 
		query.append("                       ,C2.CURR_CD                                      CURR_CD" ).append("\n"); 
		query.append("                       ,C2.VSL_SIZE                                     VSL_SIZE" ).append("\n"); 
		query.append("                       ,C2.COST_CD                                      COST_CD" ).append("\n"); 
		query.append("                       ,C2.LCL_COST                                     LCL_COST" ).append("\n"); 
		query.append("                       ,C2.USD_COST                                     USD_COST" ).append("\n"); 
		query.append("                       ,NVL(ABS(TO_NUMBER(C1.VSL_CLSS_CAPA) - TO_NUMBER(C2.VSL_SIZE)), 999) C_COST" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        /* 1 step ----------------------------------------------------------------*/" ).append("\n"); 
		query.append("                        /* 대상항차 기준으로 항비/운하통과료의 대상이 되는 port정보를 가져온다.*/" ).append("\n"); 
		query.append("                        SELECT DISTINCT B1.COST_YRMON" ).append("\n"); 
		query.append("                               ,B1.LOC_CD" ).append("\n"); 
		query.append("                               ,B5.YD_CD TML_CD" ).append("\n"); 
		query.append("                               ,B1.SLAN_CD" ).append("\n"); 
		query.append("                               ,B1.DIR_CD" ).append("\n"); 
		query.append("                               ,B1.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                           FROM" ).append("\n"); 
		query.append("                           (" ).append("\n"); 
		query.append("                            SELECT DISTINCT A1.COST_YRMON" ).append("\n"); 
		query.append("                                  ,A1.SLAN_CD" ).append("\n"); 
		query.append("                                  ,A1.DIR_CD" ).append("\n"); 
		query.append("                                  ,NVL(A3.VSL_CLSS_CAPA,0) VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                                  ,A2.LOC_CD" ).append("\n"); 
		query.append("                                  ,A5.YD_CD" ).append("\n"); 
		query.append("                              FROM MAS_MON_VVD A1" ).append("\n"); 
		query.append("                                  ,MAS_MON_VVD_PORT_OP_DYS A2" ).append("\n"); 
		query.append("                                  ,MAS_VSL_RGST A3" ).append("\n"); 
		query.append("                                  ,MAS_LANE_RGST A4" ).append("\n"); 
		query.append("                                  ,VSK_VSL_PORT_SKD A5" ).append("\n"); 
		query.append("                                 WHERE A1.TRD_CD           = A2.TRD_CD" ).append("\n"); 
		query.append("                                   AND A1.RLANE_CD         = A2.RLANE_CD" ).append("\n"); 
		query.append("                                   AND A1.IOC_CD           = DECODE(A2.LOC_CD, 'PAPAC', 'O', 'EGSUZ', 'O', A1.IOC_CD)" ).append("\n"); 
		query.append("                                   AND A1.VSL_CD           = A2.VSL_CD" ).append("\n"); 
		query.append("                                   AND A1.SKD_VOY_NO       = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND A1.DIR_CD           = A2.DIR_CD" ).append("\n"); 
		query.append("                                   AND A1.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("                                   AND A1.SLAN_CD          = A2.SLAN_CD" ).append("\n"); 
		query.append("                                   AND A2.VSL_CD           = A5.VSL_CD" ).append("\n"); 
		query.append("                                   AND A2.SKD_VOY_NO       = A5.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND A2.DIR_CD           = A5.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND A2.LOC_CD           = A5.VPS_PORT_CD" ).append("\n"); 
		query.append("                                   AND A2.VSL_DBL_CALL_SEQ = A5.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                   AND A2.CLPT_SEQ         = A5.CLPT_SEQ" ).append("\n"); 
		query.append("                                   AND A2.SLAN_CD          = A5.SLAN_CD" ).append("\n"); 
		query.append("   								   AND A2.NEW_OP_DYS_FLG    = 'Y' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_yrtype} == 'W')" ).append("\n"); 
		query.append("                                   AND A1.SLS_YRMON LIKE @[f_year] || '%'" ).append("\n"); 
		query.append("                                   AND A1.COST_WK = @[f_fm_wk]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                   AND A1.COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_selslane} != '')" ).append("\n"); 
		query.append("                                   AND A1.SLAN_CD = @[f_selslane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_selclass} != '')" ).append("\n"); 
		query.append("                                   AND A3.VSL_CLSS_CAPA = @[f_selclass]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                   AND A3.VSL_CD(+) = A1.VSL_CD" ).append("\n"); 
		query.append("                                   AND A3.VOP_CD    = 'SML'" ).append("\n"); 
		query.append("                                   AND A1.TRD_CD    = A4.TRD_CD" ).append("\n"); 
		query.append("                                   AND A1.RLANE_CD  = A4.RLANE_CD" ).append("\n"); 
		query.append("                                   AND A1.IOC_CD    = A4.IOC_CD" ).append("\n"); 
		query.append("                                   AND A1.DIR_CD    = A4.DIR_CD" ).append("\n"); 
		query.append("                                   AND A4.TRD_CD    <> 'COM'" ).append("\n"); 
		query.append("                                   AND A4.VSL_LANE_TP_CD IN('JO', 'SC')" ).append("\n"); 
		query.append("                                   AND TO_CHAR(A1.N1ST_LODG_PORT_ETD_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                       BETWEEN NVL(TO_CHAR(A3.VSL_APLY_FM_DT,'YYYYMMDD'),'19000101') AND NVL(TO_CHAR(A3.VSL_APLY_TO_DT,'YYYYMMDD'),'99991231')" ).append("\n"); 
		query.append("                                   AND NVL(A3.VSL_CLSS_CAPA,0) > 0" ).append("\n"); 
		query.append("                             MINUS" ).append("\n"); 
		query.append("                            SELECT COST_YRMON" ).append("\n"); 
		query.append("                                  ,SLAN_CD" ).append("\n"); 
		query.append("                                  ,SKD_DIR_CD" ).append("\n"); 
		query.append("                                  ,VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                                  ,SUBSTR(TML_CD, 1, 5) LOC_CD" ).append("\n"); 
		query.append("                                  ,TML_CD" ).append("\n"); 
		query.append("                              FROM MAS_PORT_TRF" ).append("\n"); 
		query.append("#if (${f_yrtype} == 'W')" ).append("\n"); 
		query.append("                                 WHERE COST_YRMON IN" ).append("\n"); 
		query.append("                                                   (SELECT DISTINCT SLS_YRMON" ).append("\n"); 
		query.append("                                                       FROM MAS_MON_VVD" ).append("\n"); 
		query.append("                                                      WHERE 1=1" ).append("\n"); 
		query.append("                                                        AND SLS_YRMON LIKE @[f_year] || '%'" ).append("\n"); 
		query.append("                                                        AND COST_WK = @[f_fm_wk])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                 WHERE COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_selslane} != '')" ).append("\n"); 
		query.append("                                   AND SLAN_CD = @[f_selslane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_selclass} != '')" ).append("\n"); 
		query.append("                                   AND VSL_CLSS_CAPA = @[f_selclass]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                               ) B1" ).append("\n"); 
		query.append("                               ,VSK_VSL_PORT_SKD B5" ).append("\n"); 
		query.append("                             WHERE B1.LOC_CD  = B5.VPS_PORT_CD" ).append("\n"); 
		query.append("                               AND B1.SLAN_CD = B5.SLAN_CD" ).append("\n"); 
		query.append("                               AND B1.DIR_CD  = B5.SKD_DIR_CD" ).append("\n"); 
		query.append("                               AND B1.YD_CD   = B5.YD_CD" ).append("\n"); 
		query.append("                         /*1 step ----------------------------------------------------------------*/" ).append("\n"); 
		query.append("                       ) C1" ).append("\n"); 
		query.append("                      ,(" ).append("\n"); 
		query.append("                        /*1 step ----------------------------------------------------------------*/" ).append("\n"); 
		query.append("                        SELECT   DECODE(SUBSTR(A1.TML_CD, 1, 5)" ).append("\n"); 
		query.append("                                       ,'EGSUZ', '53102000'" ).append("\n"); 
		query.append("                                       ,'PAPAC', '53102000'" ).append("\n"); 
		query.append("                                       ,DECODE(SUBSTR(A1.PORT_COST_CD, 1, 4), '5119', '53102000', '53101000')" ).append("\n"); 
		query.append("                                       ) COST_CD" ).append("\n"); 
		query.append("                                ,A1.COST_YR" ).append("\n"); 
		query.append("                                ,A2.ACCT_XCH_RT_YRMON   COST_YRMON" ).append("\n"); 
		query.append("                                ,A1.VSL_CLSS_CAPA      VSL_SIZE" ).append("\n"); 
		query.append("                                ,A1.TML_CD" ).append("\n"); 
		query.append("                                ,A1.CURR_CD" ).append("\n"); 
		query.append("                                ,NVL(SUM(A1.PORT_TRF_AMT), 0) LCL_COST" ).append("\n"); 
		query.append("                                ,NVL(A2.USD_LOCL_XCH_RT, 0)" ).append("\n"); 
		query.append("                                ,SUM(A1.PORT_TRF_AMT / DECODE(A1.CURR_CD, 'USD', 1, NVL(A2.USD_LOCL_XCH_RT, 0))) USD_COST" ).append("\n"); 
		query.append("                            FROM (" ).append("\n"); 
		query.append("                                  SELECT" ).append("\n"); 
		query.append("                                         AA1.YD_CD           TML_CD" ).append("\n"); 
		query.append("                                        ,AA2.ACCT_CD         PORT_COST_CD" ).append("\n"); 
		query.append("                                        ,AA1.BSE_YR          COST_YR" ).append("\n"); 
		query.append("									    ,AA1.CNTR_VSL_CLSS_CAPA     VSL_CLSS_CAPA " ).append("\n"); 
		query.append("                                        ,AA1.CURR_CD         CURR_CD" ).append("\n"); 
		query.append("                                        ,AA1.TTL_CHG_AMT     PORT_TRF_AMT" ).append("\n"); 
		query.append("                                        ,AA1.BSE_QTR_CD" ).append("\n"); 
		query.append("                                    FROM PSO_VSL_CLSS_TRF AA1" ).append("\n"); 
		query.append("                                        ,TES_LGS_COST AA2" ).append("\n"); 
		query.append("                                   WHERE AA1.LGS_COST_CD        = AA2.LGS_COST_CD" ).append("\n"); 
		query.append("#if (${f_selclass} != '')" ).append("\n"); 
		query.append("                                     AND AA1.CNTR_VSL_CLSS_CAPA = @[f_selclass]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                 ) A1" ).append("\n"); 
		query.append("                                ,GL_MON_XCH_RT A2" ).append("\n"); 
		query.append("                                ,   /* 경리환율 테이블은 mdm의 NIS 요건에 따라서 변경 가능 */" ).append("\n"); 
		query.append("                                 (SELECT DISTINCT COST_YR" ).append("\n"); 
		query.append("                                         ,DECODE(NO, 1, FM_MON, TO_MON) YR_MON" ).append("\n"); 
		query.append("                                         ,DECODE(NO, 1, SUBSTR(FM_MON,5,2), SUBSTR(TO_MON,5,2)) MON" ).append("\n"); 
		query.append("                                    FROM (SELECT COST_YR" ).append("\n"); 
		query.append("                                                ,COST_WK" ).append("\n"); 
		query.append("                                                ,SUBSTR(SLS_FM_DT, 1, 6) FM_MON" ).append("\n"); 
		query.append("                                                ,SUBSTR(SLS_TO_DT, 1, 6) TO_MON" ).append("\n"); 
		query.append("                                            FROM MAS_WK_PRD" ).append("\n"); 
		query.append("#if (${f_yrtype} == 'W')" ).append("\n"); 
		query.append("                                               WHERE COST_YR = @[f_year]" ).append("\n"); 
		query.append("                                                 AND COST_WK IN ( @[f_fm_wk] - 1, @[f_fm_wk] )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                               WHERE COST_YR = @[f_year]" ).append("\n"); 
		query.append("                                                 AND @[f_cost_yrmon] BETWEEN SUBSTR(SLS_FM_DT, 1, 6)" ).append("\n"); 
		query.append("                                                 AND SUBSTR(SLS_TO_DT, 1, 6)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                           )" ).append("\n"); 
		query.append("                                          ,(SELECT CPY_NO NO" ).append("\n"); 
		query.append("                                              FROM COM_CPY_NO" ).append("\n"); 
		query.append("                                             WHERE CPY_NO BETWEEN 1 AND 2" ).append("\n"); 
		query.append("                                           )" ).append("\n"); 
		query.append("                                  ) A3" ).append("\n"); 
		query.append("                          WHERE A1.COST_YR              = A3.COST_YR" ).append("\n"); 
		query.append("                            AND A1.CURR_CD              = A2.CURR_CD" ).append("\n"); 
		query.append("                            AND A2.ACCT_XCH_RT_LVL(+)   = '1'" ).append("\n"); 
		query.append("                            AND A2.ACCT_XCH_RT_YRMON(+) = A3.YR_MON" ).append("\n"); 
		query.append("                            AND A1.BSE_QTR_CD = CASE WHEN A3.MON = '01' OR A3.MON = '02' OR A3.MON = '03' THEN '1Q'" ).append("\n"); 
		query.append("                                                     WHEN A3.MON = '04' OR A3.MON = '05' OR A3.MON = '06' THEN '2Q'" ).append("\n"); 
		query.append("                                                     WHEN A3.MON = '07' OR A3.MON = '08' OR A3.MON = '09' THEN '3Q'" ).append("\n"); 
		query.append("                                                     WHEN A3.MON = '10' OR A3.MON = '11' OR A3.MON = '12' THEN '4Q'" ).append("\n"); 
		query.append("                                                 END" ).append("\n"); 
		query.append("                       GROUP BY DECODE(SUBSTR(A1.TML_CD, 1, 5)" ).append("\n"); 
		query.append("                                      ,'EGSUZ', '53102000'" ).append("\n"); 
		query.append("                                      ,'PAPAC', '53102000'" ).append("\n"); 
		query.append("                                      ,DECODE(SUBSTR(A1.PORT_COST_CD, 1, 4), '5119', '53102000', '53101000')" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                               ,A1.COST_YR" ).append("\n"); 
		query.append("                               ,A2.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("                               ,A1.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                               ,A1.TML_CD" ).append("\n"); 
		query.append("                               ,A1.CURR_CD" ).append("\n"); 
		query.append("                               ,NVL(A2.USD_LOCL_XCH_RT, 0)" ).append("\n"); 
		query.append("                        /* 1 step ----------------------------------------------------------------*/" ).append("\n"); 
		query.append("                      ) C2" ).append("\n"); 
		query.append("                WHERE C1.COST_YRMON     = C2.COST_YRMON" ).append("\n"); 
		query.append("                  AND C1.TML_CD         = C2.TML_CD" ).append("\n"); 
		query.append("                  AND C1.VSL_CLSS_CAPA  = C2.VSL_SIZE" ).append("\n"); 
		query.append("                 /* 2 step ----------------------------------------------------------------*/" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("       /* 3 step ----------------------------------------------------------------*/" ).append("\n"); 
		query.append("      ) D2" ).append("\n"); 
		query.append(" WHERE D2.COST_YRMON     = D1.COST_YRMON(+)" ).append("\n"); 
		query.append("   AND D2.TML_CD         = D1.TML_CD(+)" ).append("\n"); 
		query.append("   AND D2.VSL_CLSS_CAPA  = D1.VSL_CLSS_CAPA(+)" ).append("\n"); 
		query.append("   AND D2.SLAN_CD        = D1.SLAN_CD(+)" ).append("\n"); 
		query.append("   AND D2.DIR_CD         = D1.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND D2.CURR_CD        = D1.LOCL_CURR_CD(+)" ).append("\n"); 
		query.append("   AND D2.LCL_COST       <> 0" ).append("\n"); 
		query.append("ORDER BY D2.COST_YRMON" ).append("\n"); 
		query.append("       , D2.SLAN_CD" ).append("\n"); 
		query.append("       , D2.DIR_CD" ).append("\n"); 
		query.append("       , D2.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("       , D2.TML_CD" ).append("\n"); 
		query.append("       , D2.CURR_CD" ).append("\n"); 

	}
}