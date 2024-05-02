/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOSearchPortTariffListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.24
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2015.03.24 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchPortTariffListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History-----------------------------------------------
	  * 2010.05.06 이행지 [CHM-201003663] Port tariff vessel class 변경
	  * 2010.05.20 이행지 M:2010-05, W:2010-18  => M:2010-07,W:2010-27 부터 VSL_CLSS_CAPA 적용하도록
	  * 2010.06.23 이행지 M:2010-07, W:2010-27  => M:2010-08,W:2010-31 부터 VSL_CLSS_CAPA 적용하도록
	  * 2010.07.29 이윤정 M:2010-08, W:2010-31  => M:2010-10,W:2010-40 부터 VSL_CLSS_CAPA 적용하도록[CHM-201005034]
	  * 2010.09.27 이행지 [CHM-201006114-01] VSL_CLSS_CAPA 적용삭제 
	  * </pre>
	  */
	public NetworkCostDBDAOSearchPortTariffListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_selrlane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchPortTariffListRSQL").append("\n"); 
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
		query.append("SELECT 0 AS CHK_FLAG" ).append("\n"); 
		query.append("      , COST_STS" ).append("\n"); 
		query.append("      , COST_YRMON" ).append("\n"); 
		query.append("      , COST_WK" ).append("\n"); 
		query.append("      , SLAN_CD" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , SKD_DIR_CD" ).append("\n"); 
		query.append("	  , HUL_BND_CD" ).append("\n"); 
		query.append("      , MAX(PSO_MAX_SEQ) PSO_MAX_SEQ" ).append("\n"); 
		query.append("      , SUM(TTL_EXP) PSO_COST_TTL_AMT" ).append("\n"); 
		query.append("      , SUM(PSO_TTL_EXP) PSO_COST_PSO_TTL_AMT" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("#if (${f_yrtype} == 'W')           " ).append("\n"); 
		query.append("         SELECT ( CASE WHEN MIN(NVL(A.PORT_USD_AMT, 0)+NVL(A.CNL_USD_AMT, 0)) OVER (PARTITION BY A.SLS_YRMON, A.COST_WK, A.SLAN_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD) <> 0" ).append("\n"); 
		query.append("                       THEN 'C' " ).append("\n"); 
		query.append("                       --VVD에 전체에 대해서 하나라도 COA DATA가 있는 경우" ).append("\n"); 
		query.append("                       WHEN MIN(NVL(A.PORT_USD_AMT, 0)+NVL(A.CNL_USD_AMT, 0)) OVER (PARTITION BY A.SLS_YRMON, A.COST_WK, A.SLAN_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD)= 0" ).append("\n"); 
		query.append("                            AND MAX(NVL( A.INV_USD_AMT, 0)) OVER (PARTITION BY A.SLS_YRMON, A.SLAN_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD) = 0" ).append("\n"); 
		query.append("                       THEN 'N'" ).append("\n"); 
		query.append("                       --해당 VVD에 대한 데이터가 COA, PSO 둘다 모두 한 건도 없는 경우" ).append("\n"); 
		query.append("                       ELSE DECODE(LAST_VALUE (A.SRC_PSO_BZTP_CD IGNORE NULLS) OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD, A.WRK_DT, A.WRK_SEQ ), 1, 'T', 2, 'E')" ).append("\n"); 
		query.append("                       --COA는 없고 PSO쪽만 있는 경우 WRK_DT나 WRK SEQ로 별로 가져와야 함" ).append("\n"); 
		query.append("                       END) COST_STS" ).append("\n"); 
		query.append("              , A.SLS_YRMON AS COST_YRMON" ).append("\n"); 
		query.append("              , A.COST_WK" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("         SELECT ( CASE WHEN MIN(NVL(A.PORT_USD_AMT, 0)+NVL(A.CNL_USD_AMT, 0)) OVER (PARTITION BY A.COST_YRMON, A.SLAN_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD) <> 0" ).append("\n"); 
		query.append("                       THEN 'C' " ).append("\n"); 
		query.append("                       --VVD에 전체에 대해서 하나라도 COA DATA가 있는 경우" ).append("\n"); 
		query.append("                       WHEN MIN(NVL(A.PORT_USD_AMT, 0)+NVL(A.CNL_USD_AMT, 0)) OVER (PARTITION BY A.COST_YRMON, A.SLAN_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD)= 0" ).append("\n"); 
		query.append("                            AND MAX(NVL( A.INV_USD_AMT, 0)) OVER (PARTITION BY A.COST_YRMON, A.SLAN_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD) = 0" ).append("\n"); 
		query.append("                       THEN 'N'" ).append("\n"); 
		query.append("                       --해당 VVD에 대한 데이터가 COA, PSO 둘다 모두 한 건도 없는 경우" ).append("\n"); 
		query.append("                       ELSE DECODE(LAST_VALUE (A.SRC_PSO_BZTP_CD IGNORE NULLS) OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD, A.WRK_DT, A.WRK_SEQ ), 1, 'T', 2, 'E')" ).append("\n"); 
		query.append("                       --COA는 없고 PSO쪽만 있는 경우 WRK_DT나 WRK SEQ로 별로 가져와야 함" ).append("\n"); 
		query.append("                       END) COST_STS" ).append("\n"); 
		query.append("              , A.COST_YRMON AS COST_YRMON" ).append("\n"); 
		query.append("              , '' AS COST_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              , A.SLAN_CD" ).append("\n"); 
		query.append("              , A.VSL_CD" ).append("\n"); 
		query.append("              , A.SKD_VOY_NO" ).append("\n"); 
		query.append("              , A.DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("			  , A.HUL_BND_CD" ).append("\n"); 
		query.append("              , A.TML_CD" ).append("\n"); 
		query.append("              , A.YD_CD" ).append("\n"); 
		query.append("              , A.WRK_DT" ).append("\n"); 
		query.append("              , A.WRK_SEQ" ).append("\n"); 
		query.append("                --, A.LST_WRK_DT" ).append("\n"); 
		query.append("                --, A.LST_WRK_SEQ" ).append("\n"); 
		query.append("              , MAX(A.WRK_DT|| A.WRK_SEQ) PSO_MAX_SEQ" ).append("\n"); 
		query.append("              , A.INV_USD_AMT" ).append("\n"); 
		query.append("              , A.CNL_USD_AMT" ).append("\n"); 
		query.append("              , A.PORT_USD_AMT" ).append("\n"); 
		query.append("#if (${f_yrtype} == 'W')  " ).append("\n"); 
		query.append("              , ( CASE WHEN MIN(NVL(A.INV_USD_AMT, 0)) OVER (PARTITION BY A.SLS_YRMON, A.COST_WK, A.SLAN_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD) = 0" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              , ( CASE WHEN MIN(NVL(A.INV_USD_AMT, 0)) OVER (PARTITION BY A.COST_YRMON, A.SLAN_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD) = 0" ).append("\n"); 
		query.append("#end                        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                       -- VVD별 WORK DATE/SEQ 별로 PSO 금액중 하나라도 ADD CALL 인 것을 찾아야 함" ).append("\n"); 
		query.append("                       THEN 0" ).append("\n"); 
		query.append("                       ELSE SUM( ( CASE WHEN SUBSTR(A.YD_CD, 1, 5) IN ('EGSUZ', 'PAPAC') THEN 0 ELSE NVL(A.INV_USD_AMT, 0) END) --PSO_PORT_AMT" ).append("\n"); 
		query.append("                                +( CASE WHEN SUBSTR(A.YD_CD, 1, 5) IN ('EGSUZ', 'PAPAC') THEN NVL(A.INV_USD_AMT, 0) ELSE 0 END) --PSO_CNL_AMT" ).append("\n"); 
		query.append("                                ) END) PSO_TTL_EXP" ).append("\n"); 
		query.append("#if (${f_yrtype} == 'W')" ).append("\n"); 
		query.append("              , ( CASE WHEN MIN(NVL(A.PORT_USD_AMT, 0)+NVL(A.CNL_USD_AMT, 0)) OVER (PARTITION BY A.SLS_YRMON, A.COST_WK, A.SLAN_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD) = 0" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              , ( CASE WHEN MIN(NVL(A.PORT_USD_AMT, 0)+NVL(A.CNL_USD_AMT, 0)) OVER (PARTITION BY A.COST_YRMON, A.SLAN_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD) = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                       -- VVD별로 COA 쪽에 YARD 하나라도 누락인 것을 찾아야함." ).append("\n"); 
		query.append("                       THEN 0 " ).append("\n"); 
		query.append("                       ELSE SUM(NVL(A.PORT_USD_AMT, 0)+NVL(A.CNL_USD_AMT, 0)) END) TTL_EXP" ).append("\n"); 
		query.append("           FROM (SELECT A1.COST_YRMON" ).append("\n"); 
		query.append("                      , A1.SLS_YRMON" ).append("\n"); 
		query.append("                      , A1.COST_WK" ).append("\n"); 
		query.append("                      , A1.SLAN_CD" ).append("\n"); 
		query.append("                      , A1.VSL_CD" ).append("\n"); 
		query.append("                      , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("                      , A1.DIR_CD" ).append("\n"); 
		query.append("				      , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03217' AND INTG_CD_VAL_CTNT = A3.HUL_BND_CD) HUL_BND_CD" ).append("\n"); 
		query.append("                      , A5.TML_CD" ).append("\n"); 
		query.append("                      , A4.YD_CD" ).append("\n"); 
		query.append("                      , A6.WRK_DT" ).append("\n"); 
		query.append("                      , A6.WRK_SEQ" ).append("\n"); 
		query.append("                      , A6.INV_USD_AMT" ).append("\n"); 
		query.append("                      , A5.PORT_USD_AMT" ).append("\n"); 
		query.append("                      , A5.CNL_USD_AMT" ).append("\n"); 
		query.append("                      , A6.SRC_PSO_BZTP_CD" ).append("\n"); 
		query.append("                   FROM COA_MON_VVD A1" ).append("\n"); 
		query.append("                      , COA_VSL_RGST A2" ).append("\n"); 
		query.append("                      , COA_LANE_RGST A3" ).append("\n"); 
		query.append("                      , VSK_VSL_PORT_SKD A4" ).append("\n"); 
		query.append("                      , COA_PORT_TRF A5" ).append("\n"); 
		query.append("                      , (                      " ).append("\n"); 
		query.append("                         SELECT VSL_CD" ).append("\n"); 
		query.append("                              , SKD_VOY_NO" ).append("\n"); 
		query.append("                              , SKD_DIR_CD" ).append("\n"); 
		query.append("                              , YD_CD" ).append("\n"); 
		query.append("                              , MAX(SRC_PSO_BZTP_CD) SRC_PSO_BZTP_CD" ).append("\n"); 
		query.append("                              , MAX(WRK_DT)  WRK_DT" ).append("\n"); 
		query.append("                              , MAX(WRK_SEQ) KEEP (DENSE_RANK FIRST ORDER BY WRK_DT DESC) WRK_SEQ" ).append("\n"); 
		query.append("                              , MAX(INV_USD_AMT) KEEP (DENSE_RANK FIRST ORDER BY WRK_DT DESC, WRK_SEQ DESC) INV_USD_AMT" ).append("\n"); 
		query.append("                           FROM PSO_TGT_VVD_EXPN" ).append("\n"); 
		query.append("                          WHERE PSO_BZTP_CD = '7'" ).append("\n"); 
		query.append("                         GROUP BY VSL_CD" ).append("\n"); 
		query.append("                              , SKD_VOY_NO" ).append("\n"); 
		query.append("                              , SKD_DIR_CD" ).append("\n"); 
		query.append("                              , YD_CD" ).append("\n"); 
		query.append("                      ) A6" ).append("\n"); 
		query.append("                  WHERE NVL(A1.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                    AND NVL(A3.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_yrtype} == 'W')" ).append("\n"); 
		query.append("                    AND A1.SLS_YRMON  LIKE @[f_year] || '%'" ).append("\n"); 
		query.append("                    AND A1.COST_WK         = @[f_fm_wk]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                    AND A1.COST_YRMON      = @[f_year]||@[f_fm_mon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_selslane} != '')" ).append("\n"); 
		query.append("                    AND A1.SLAN_CD         = @[f_selslane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_selrlane} != '')" ).append("\n"); 
		query.append("                    AND A1.RLANE_CD        = @[f_selrlane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    AND A1.VSL_CD          = nvl(@[f_vsl_cd], A1.VSL_CD)" ).append("\n"); 
		query.append("                    AND A1.SKD_VOY_NO      = nvl(@[f_skd_voy_no], A1.SKD_VOY_NO)" ).append("\n"); 
		query.append("                    AND A1.DIR_CD          = nvl(@[f_dir_cd], A1.DIR_CD)" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("                    AND A1.VSL_CD          = A2.VSL_CD" ).append("\n"); 
		query.append("                    AND A2.VOP_CD          = 'HJS'" ).append("\n"); 
		query.append("                    AND A1.TRD_CD          = A3.TRD_CD" ).append("\n"); 
		query.append("                    AND A1.RLANE_CD        = A3.RLANE_CD" ).append("\n"); 
		query.append("                    AND A1.IOC_CD          = A3.IOC_CD" ).append("\n"); 
		query.append("                    AND A1.DIR_CD          = A3.DIR_CD" ).append("\n"); 
		query.append("                    AND A3.TRD_CD         <> 'COM'" ).append("\n"); 
		query.append("                    AND A3.VSL_LANE_TP_CD IN ('JO', 'SC')" ).append("\n"); 
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
		query.append("                    AND A4.YD_CD                     =A5.TML_CD(+)" ).append("\n"); 
		query.append("                    AND A4.VSL_CD                    = A6.VSL_CD(+)" ).append("\n"); 
		query.append("                    AND A4.SKD_VOY_NO                = A6.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                    AND A4.SKD_DIR_CD                = A6.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                    AND A4.YD_CD                     =A6.YD_CD(+)" ).append("\n"); 
		query.append("					AND A1.SUB_TRD_CD <> 'IP'" ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("       GROUP BY ( CASE WHEN NVL(A.PORT_USD_AMT, 0)+NVL(A.CNL_USD_AMT, 0) <> 0 THEN 'C'" ).append("\n"); 
		query.append("                       WHEN NVL(A.PORT_USD_AMT, 0)+NVL(A.CNL_USD_AMT, 0) = 0 AND NVL(A.INV_USD_AMT, 0) = 0 THEN 'N'" ).append("\n"); 
		query.append("                       ELSE DECODE(A.SRC_PSO_BZTP_CD, 1, 'T', 2, 'E') END)" ).append("\n"); 
		query.append("#if (${f_yrtype} == 'W')" ).append("\n"); 
		query.append("              , A.SLS_YRMON" ).append("\n"); 
		query.append("              , A.COST_WK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              , A.COST_YRMON  " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("              , A.SLAN_CD" ).append("\n"); 
		query.append("              , A.VSL_CD" ).append("\n"); 
		query.append("              , A.SKD_VOY_NO" ).append("\n"); 
		query.append("              , A.DIR_CD" ).append("\n"); 
		query.append("			  , A.HUL_BND_CD" ).append("\n"); 
		query.append("              , A.PORT_USD_AMT" ).append("\n"); 
		query.append("              , A.CNL_USD_AMT" ).append("\n"); 
		query.append("              , A.TML_CD" ).append("\n"); 
		query.append("              , A.YD_CD" ).append("\n"); 
		query.append("              , A.WRK_DT" ).append("\n"); 
		query.append("              , A.WRK_SEQ" ).append("\n"); 
		query.append("              , A.INV_USD_AMT" ).append("\n"); 
		query.append("              , A.SRC_PSO_BZTP_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("  WHERE COST_STS IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY COST_STS" ).append("\n"); 
		query.append("      , COST_YRMON" ).append("\n"); 
		query.append("      , COST_WK" ).append("\n"); 
		query.append("      , SLAN_CD" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , SKD_DIR_CD" ).append("\n"); 
		query.append("      , HUL_BND_CD" ).append("\n"); 
		query.append("ORDER BY COST_YRMON" ).append("\n"); 
		query.append("      , COST_WK" ).append("\n"); 
		query.append("      , SLAN_CD" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO	  " ).append("\n"); 
		query.append("      , SKD_DIR_CD" ).append("\n"); 
		query.append("	  , HUL_BND_CD" ).append("\n"); 

	}
}