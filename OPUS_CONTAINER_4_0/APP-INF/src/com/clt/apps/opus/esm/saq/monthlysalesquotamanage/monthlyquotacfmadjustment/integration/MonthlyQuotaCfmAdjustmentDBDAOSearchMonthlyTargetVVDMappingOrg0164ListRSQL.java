/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyTargetVVDMappingOrg0164ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyTargetVVDMappingOrg0164ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MonthlyTargetVVD의 데이타 모델에 해당되는 값을 불러온다.
	  * </pre>
	  */
	public MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyTargetVVDMappingOrg0164ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqtaRlseVerNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmBseWk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toBseWk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("quarter",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyTargetVVDMappingOrg0164ListRSQL").append("\n"); 
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
		query.append("WITH GRP_MAX AS (" ).append("\n"); 
		query.append("             SELECT V.RLANE_CD, MAX(V.BSA_GRP_CD) AS GRP_CD" ).append("\n"); 
		query.append("               FROM SAQ_MON_TGT_BSA_GRP V" ).append("\n"); 
		query.append("              WHERE V.BSE_YR = @[year]" ).append("\n"); 
		query.append("                AND V.TRD_CD = @[trade]" ).append("\n"); 
		query.append("                AND V.DIR_CD = @[bound]" ).append("\n"); 
		query.append("           GROUP BY V.RLANE_CD  )," ).append("\n"); 
		query.append("      GRP_CAPA AS (" ).append("\n"); 
		query.append("              SELECT V.RLANE_CD, V.FNL_BSA_CAPA, MIN(V.BSA_GRP_CD) AS GRP_CD" ).append("\n"); 
		query.append("                FROM SAQ_MON_TGT_BSA_GRP V" ).append("\n"); 
		query.append("               WHERE V.BSE_YR = @[year]" ).append("\n"); 
		query.append("                 AND V.TRD_CD = @[trade]" ).append("\n"); 
		query.append("                 AND V.DIR_CD = @[bound]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane} != '') " ).append("\n"); 
		query.append("                AND V.RLANE_CD =  @[lane]   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            GROUP BY V.RLANE_CD, V.FNL_BSA_CAPA  )," ).append("\n"); 
		query.append("      COA_MON_VVD_V AS (" ).append("\n"); 
		query.append("              SELECT V.TRD_CD    , V.RLANE_CD            , V.VSL_CD   ," ).append("\n"); 
		query.append("                     V.SKD_VOY_NO, V.DIR_CD              , V.SLS_YRMON," ).append("\n"); 
		query.append("                     V.COST_WK   , V.SUB_TRD_CD          , V.IOC_CD   ," ).append("\n"); 
		query.append("                     V.VVD_SEQ   , V.LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("                FROM COA_MON_VVD V" ).append("\n"); 
		query.append("               WHERE V.SLS_YRMON BETWEEN @[year]||@[month1] AND @[year]||@[month2]" ).append("\n"); 
		query.append("                 AND V.TRD_CD = @[trade]" ).append("\n"); 
		query.append("                 AND V.DIR_CD = @[bound]" ).append("\n"); 
		query.append("                 AND V.COST_WK BETWEEN NVL(@[fmBseWk], '01') AND NVL(@[toBseWk], '54')" ).append("\n"); 
		query.append("                 AND V.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append("                 AND V.SUB_TRD_CD <> 'IP'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane} != '')" ).append("\n"); 
		query.append("                 AND V.RLANE_CD =  @[lane]    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND (V.DELT_FLG IS NULL OR V.DELT_FLG = 'N')    )," ).append("\n"); 
		query.append("      EXCEPT_VVD AS (" ).append("\n"); 
		query.append("              SELECT CHKQTR_VVD.TRD_CD, CHKQTR_VVD.DIR_CD, CHKQTR_VVD.VSL_CD, CHKQTR_VVD.SKD_VOY_NO, CHKQTR_VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                FROM (                    -- 현분기에 없는 VVD" ).append("\n"); 
		query.append("                       SELECT TRD_CD, DIR_CD, VSL_CD, SKD_VOY_NO, DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("                         FROM COA_MON_VVD_V" ).append("\n"); 
		query.append("                        MINUS" ).append("\n"); 
		query.append("                       SELECT TRD_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                         FROM SAQ_MON_CFM_TGT_VVD" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                          AND MQTA_RLSE_VER_NO = @[mqtaRlseVerNo]" ).append("\n"); 
		query.append("                          AND TRD_CD           = @[trade]" ).append("\n"); 
		query.append("                          AND DIR_CD           = @[bound]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane} != '')" ).append("\n"); 
		query.append("                          AND RLANE_CD         = @[lane]   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     ) CHKQTR_VVD," ).append("\n"); 
		query.append("                     (                    -- 이전 분기 VVD" ).append("\n"); 
		query.append("                       SELECT TRD_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                         FROM SAQ_MON_CFM_TGT_VVD" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                          AND MQTA_RLSE_VER_NO = ( SELECT MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                                                     FROM SAQ_MON_QTA_RLSE" ).append("\n"); 
		query.append("                                                    WHERE 1=1" ).append("\n"); 
		query.append("                                                      AND BSE_YR     = DECODE(@[quarter], '4Q', @[year] -1, @[year])" ).append("\n"); 
		query.append("                                                      AND BSE_QTR_CD = DECODE(@[quarter], '1Q', '4Q'," ).append("\n"); 
		query.append("                                                                                 '2Q', '1Q'," ).append("\n"); 
		query.append("                                                                                 '3Q', '2Q'," ).append("\n"); 
		query.append("                                                                                 '4Q', '3Q' )" ).append("\n"); 
		query.append("                                                      AND QTA_RLSE_STS_CD    = 'R'                )" ).append("\n"); 
		query.append("                          AND TRD_CD           = @[trade]" ).append("\n"); 
		query.append("                          AND DIR_CD           = @[bound]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane} != '')" ).append("\n"); 
		query.append("                          AND RLANE_CD         = @[lane]                " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     ) PREQTR_VVD" ).append("\n"); 
		query.append("               WHERE 1=1" ).append("\n"); 
		query.append("               AND   CHKQTR_VVD.TRD_CD     = PREQTR_VVD.TRD_CD" ).append("\n"); 
		query.append("               AND   CHKQTR_VVD.DIR_CD     = PREQTR_VVD.DIR_CD" ).append("\n"); 
		query.append("               AND   CHKQTR_VVD.VSL_CD     = PREQTR_VVD.VSL_CD" ).append("\n"); 
		query.append("               AND   CHKQTR_VVD.SKD_VOY_NO = PREQTR_VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND   CHKQTR_VVD.SKD_DIR_CD = PREQTR_VVD.SKD_DIR_CD  )" ).append("\n"); 
		query.append("    SELECT A.TRD_CD      , A.RLANE_CD   , A.DIR_CD    ," ).append("\n"); 
		query.append("           A.VSL_CD      , A.SKD_VOY_NO , A.SKD_DIR_CD," ).append("\n"); 
		query.append("           A.SPRT_GRP_CD , NVL(GC.GRP_CD, '00') AS BSA_GRP_CD," ).append("\n"); 
		query.append("           A.GRP_MAX     , A.BSE_MON    , A.BSE_WK    ," ).append("\n"); 
		query.append("           A.SUB_TRD_CD  , A.IOC_CD     , A.VVD_SEQ   ," ).append("\n"); 
		query.append("           A.FNL_BSA_CAPA," ).append("\n"); 
		query.append("           TO_CHAR(A.FNL_BSA_CAPA, 'FM099999999990') AS STR_FNL_BSA_CAPA," ).append("\n"); 
		query.append("           A.ETD_DT" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("             SELECT V.TRD_CD     ," ).append("\n"); 
		query.append("                    V.RLANE_CD   ," ).append("\n"); 
		query.append("                    V.DIR_CD     ," ).append("\n"); 
		query.append("                    V.VSL_CD     ," ).append("\n"); 
		query.append("                    V.SKD_VOY_NO ," ).append("\n"); 
		query.append("                    V.DIR_CD  AS SKD_DIR_CD ," ).append("\n"); 
		query.append("                    'A'       AS SPRT_GRP_CD," ).append("\n"); 
		query.append("                    NVL(GC.GRP_CD, '00')                  AS BSA_GRP_CD," ).append("\n"); 
		query.append("                    NVL(TO_CHAR(GM.GRP_CD, 'FM00'), '00') AS GRP_MAX   ," ).append("\n"); 
		query.append("                    SUBSTR(V.SLS_YRMON, 5)                AS BSE_MON   ," ).append("\n"); 
		query.append("                    V.COST_WK AS BSE_WK," ).append("\n"); 
		query.append("                    V.SUB_TRD_CD ," ).append("\n"); 
		query.append("                    V.IOC_CD     ," ).append("\n"); 
		query.append("                    V.VVD_SEQ    ," ).append("\n"); 
		query.append("                    ROUND(NVL(M.FNL_CO_BSA_CAPA, 0)) AS FNL_BSA_CAPA," ).append("\n"); 
		query.append("                    TO_CHAR(V.LST_LODG_PORT_ETD_DT, 'YYYY/MM/DD HH24:MI:SS') AS ETD_DT," ).append("\n"); 
		query.append("                    V.LST_LODG_PORT_ETD_DT," ).append("\n"); 
		query.append("                    V.SLS_YRMON           ," ).append("\n"); 
		query.append("                    V.COST_WK" ).append("\n"); 
		query.append("               FROM COA_MON_VVD_V   V ," ).append("\n"); 
		query.append("                    BSA_VVD_MST M ," ).append("\n"); 
		query.append("                    GRP_CAPA        GC," ).append("\n"); 
		query.append("                    GRP_MAX         GM" ).append("\n"); 
		query.append("              WHERE V.TRD_CD     = M.TRD_CD(+)" ).append("\n"); 
		query.append("                AND V.RLANE_CD   = M.RLANE_CD(+)" ).append("\n"); 
		query.append("                AND V.VSL_CD     = M.VSL_CD(+)" ).append("\n"); 
		query.append("                AND V.SKD_VOY_NO = M.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                AND V.DIR_CD     = M.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                AND M.RLANE_CD   = GC.RLANE_CD(+)" ).append("\n"); 
		query.append("                AND ROUND(NVL(M.FNL_CO_BSA_CAPA, 0)) = GC.FNL_BSA_CAPA(+)" ).append("\n"); 
		query.append("                AND V.RLANE_CD   = GM.RLANE_CD(+)" ).append("\n"); 
		query.append("                AND NOT EXISTS ( SELECT VSL_CD, SKD_VOY_NO, DIR_CD" ).append("\n"); 
		query.append("                                   FROM EXCEPT_VVD" ).append("\n"); 
		query.append("                                  WHERE 1=1" ).append("\n"); 
		query.append("                                  AND   TRD_CD     = V.TRD_CD" ).append("\n"); 
		query.append("                                  AND   DIR_CD     = V.DIR_CD" ).append("\n"); 
		query.append("                                  AND   VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("                                  AND   SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                  AND   SKD_DIR_CD = V.DIR_CD" ).append("\n"); 
		query.append("                                 UNION" ).append("\n"); 
		query.append("                                 SELECT VSL_CD, SKD_VOY_NO, DIR_CD" ).append("\n"); 
		query.append("                                   FROM SAQ_MON_TGT_VVD" ).append("\n"); 
		query.append("                                  WHERE 1=1" ).append("\n"); 
		query.append("                                  AND   BSE_YR     = @[year]" ).append("\n"); 
		query.append("                                  AND   BSE_QTR_CD = @[quarter]" ).append("\n"); 
		query.append("                                  AND   TRD_CD     = v.trd_cd" ).append("\n"); 
		query.append("                                  AND   DIR_CD     = v.dir_cd" ).append("\n"); 
		query.append("                                  AND   VSL_CD     = v.vsl_cd" ).append("\n"); 
		query.append("                                  AND   SKD_VOY_NO = v.skd_voy_no" ).append("\n"); 
		query.append("                                  AND   SKD_DIR_CD = v.dir_cd" ).append("\n"); 
		query.append("                                  AND   DELT_FLG   = 'Y'             )            ) A," ).append("\n"); 
		query.append("          GRP_CAPA GC" ).append("\n"); 
		query.append("    WHERE A.RLANE_CD     = GC.RLANE_CD(+)" ).append("\n"); 
		query.append("      AND A.FNL_BSA_CAPA = GC.FNL_BSA_CAPA(+)" ).append("\n"); 
		query.append(" ORDER BY A.SUB_TRD_CD, A.RLANE_CD,A.SLS_YRMON,A.COST_WK, A.LST_LODG_PORT_ETD_DT" ).append("\n"); 

	}
}