/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearchMtyBalanceRepoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.10
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.04.10 김종준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOsearchMtyBalanceRepoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOsearchMtyBalanceRepoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOsearchMtyBalanceRepoListRSQL").append("\n"); 
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
		query.append("WITH LV_YD_LIST AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT C.YD_CD, A.SCC_CD,B.LOC_CD,A.ECC_CD" ).append("\n"); 
		query.append("FROM MDM_EQ_ORZ_CHT A,MDM_LOCATION B,MDM_YARD C" ).append("\n"); 
		query.append("WHERE A.ECC_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND   A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("AND   B.LOC_CD = C.LOC_CD " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append(", LV_AVAL_REPO AS(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("          GROUPING(A.TRSP_MOD_CD)||GROUPING(A.VVD)||GROUPING(A.FM_YD_CD)||GROUPING(A.FM_ETD_DT)||GROUPING(A.TO_YD_CD)||GROUPING(A.TO_ETA_DT) LVL " ).append("\n"); 
		query.append("         --,DECODE(A.TRSP_MOD_CD,'V','T/D VVD','R','Rail','W','Watar','T','Truck') TRSP_MOD_CD" ).append("\n"); 
		query.append("         ,DECODE(A.TRSP_MOD_CD,'V','1','R','4','W','2','T','3') TRSP_MOD_CD" ).append("\n"); 
		query.append("         ,A.VSL_SLAN_CD" ).append("\n"); 
		query.append("         ,A.VVD" ).append("\n"); 
		query.append("         ,FM_YD_CD" ).append("\n"); 
		query.append("         ,A.FM_ETD_DT" ).append("\n"); 
		query.append("         ,TO_YD_CD" ).append("\n"); 
		query.append("         ,A.TO_ETA_DT" ).append("\n"); 
		query.append("         ,SUM(DECODE(A.CNTR_TPSZ_CD,'D2',CNTR_QTY,0)) FCAST_QTY1 " ).append("\n"); 
		query.append("         ,SUM(DECODE(A.CNTR_TPSZ_CD,'D4',CNTR_QTY,0)) FCAST_QTY2 " ).append("\n"); 
		query.append("         ,SUM(DECODE(A.CNTR_TPSZ_CD,'D5',CNTR_QTY,0)) FCAST_QTY3 " ).append("\n"); 
		query.append("         ,SUM(DECODE(A.CNTR_TPSZ_CD,'D7',CNTR_QTY,0)) FCAST_QTY4 " ).append("\n"); 
		query.append("         ,SUM(DECODE(A.CNTR_TPSZ_CD,'R2',CNTR_QTY,0)) FCAST_QTY5 " ).append("\n"); 
		query.append("         ,SUM(DECODE(A.CNTR_TPSZ_CD,'R5',CNTR_QTY,0)) FCAST_QTY6 " ).append("\n"); 
		query.append("         ,SUM(DECODE(A.CNTR_TPSZ_CD,'O2',CNTR_QTY,0)) FCAST_QTY7 " ).append("\n"); 
		query.append("         ,SUM(DECODE(A.CNTR_TPSZ_CD,'S2',CNTR_QTY,0)) FCAST_QTY8 " ).append("\n"); 
		query.append("         ,SUM(DECODE(A.CNTR_TPSZ_CD,'O4',CNTR_QTY,0)) FCAST_QTY9 " ).append("\n"); 
		query.append("         ,SUM(DECODE(A.CNTR_TPSZ_CD,'S4',CNTR_QTY,0)) FCAST_QTY10" ).append("\n"); 
		query.append("         ,SUM(DECODE(A.CNTR_TPSZ_CD,'F2',CNTR_QTY,0)) FCAST_QTY11" ).append("\n"); 
		query.append("         ,SUM(DECODE(A.CNTR_TPSZ_CD,'A2',CNTR_QTY,0)) FCAST_QTY12" ).append("\n"); 
		query.append("         ,SUM(DECODE(A.CNTR_TPSZ_CD,'F4',CNTR_QTY,0)) FCAST_QTY13" ).append("\n"); 
		query.append("         ,SUM(DECODE(A.CNTR_TPSZ_CD,'A4',CNTR_QTY,0)) FCAST_QTY14" ).append("\n"); 
		query.append("         ,SUM(DECODE(A.CNTR_TPSZ_CD,'F5',CNTR_QTY,0)) FCAST_QTY15 " ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        #if (${repo_flag} == 'IN')" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                A.TRSP_MOD_CD" ).append("\n"); 
		query.append("               ,(SELECT V.VSL_SLAN_CD" ).append("\n"); 
		query.append("                 FROM VSK_VSL_SKD V" ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                 AND   A.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND   A.SKD_DIR_CD = V.SKD_DIR_CD) VSL_SLAN_CD" ).append("\n"); 
		query.append("               ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("               ,A.FM_YD_CD" ).append("\n"); 
		query.append("               ,TO_CHAR(A.FM_ETD_DT,'YYYYMMDD') FM_ETD_DT" ).append("\n"); 
		query.append("               ,A.TO_YD_CD" ).append("\n"); 
		query.append("               ,TO_CHAR(A.TO_ETA_DT,'YYYYMMDD') TO_ETA_DT" ).append("\n"); 
		query.append("               ,A.CNTR_QTY" ).append("\n"); 
		query.append("               ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            FROM   LV_YD_LIST Y, EQR_MTY_REPO_LAND_IB_V A, (SELECT /*+ INDEX(A XPKEQR_WK_PRD) */ " ).append("\n"); 
		query.append("                                                              ROWNUM AS SEQ,PLN_YR||PLN_WK, WK_ST_DT, WK_END_DT, @[fcast_yrwk] FCAST_YRWK ,@[loc_cd] LOC_CD" ).append("\n"); 
		query.append("                                                          FROM EQR_WK_PRD A" ).append("\n"); 
		query.append("                                                          WHERE PLN_YR = SUBSTR(@[fcast_yrwk],1,4)" ).append("\n"); 
		query.append("                                                          and   PLN_WK = SUBSTR(@[fcast_yrwk],5,2)" ).append("\n"); 
		query.append("                                                          ) D" ).append("\n"); 
		query.append("            WHERE A.TO_ETA_DT BETWEEN TO_DATE(D.WK_ST_DT,'YYYYMMDD') AND TO_DATE(D.WK_END_DT,'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("            AND   A.TO_YD_CD= Y.YD_CD" ).append("\n"); 
		query.append("            AND   A.CNTR_QTY > 0" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                A.TRSP_MOD_CD" ).append("\n"); 
		query.append("               ,(SELECT V.VSL_SLAN_CD" ).append("\n"); 
		query.append("                 FROM VSK_VSL_SKD V" ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                 AND   A.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND   A.SKD_DIR_CD = V.SKD_DIR_CD) VSL_SLAN_CD" ).append("\n"); 
		query.append("               ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("               ,A.FM_YD_CD" ).append("\n"); 
		query.append("               ,TO_CHAR(A.FM_ETD_DT,'YYYYMMDD') FM_ETD_DT" ).append("\n"); 
		query.append("               ,A.TO_YD_CD" ).append("\n"); 
		query.append("               ,TO_CHAR(A.TO_ETA_DT,'YYYYMMDD') TO_ETA_DT" ).append("\n"); 
		query.append("               ,A.CNTR_QTY" ).append("\n"); 
		query.append("               ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            FROM   LV_YD_LIST Y, EQR_MTY_REPO_VSL_IB_V A,  (SELECT /*+ INDEX(A XPKEQR_WK_PRD) */ " ).append("\n"); 
		query.append("                                                              ROWNUM AS SEQ,PLN_YR||PLN_WK, WK_ST_DT, WK_END_DT, @[fcast_yrwk] FCAST_YRWK ,@[loc_cd] LOC_CD" ).append("\n"); 
		query.append("                                                          FROM EQR_WK_PRD A" ).append("\n"); 
		query.append("                                                          WHERE PLN_YR = SUBSTR(@[fcast_yrwk],1,4)" ).append("\n"); 
		query.append("                                                          and   PLN_WK = SUBSTR(@[fcast_yrwk],5,2)" ).append("\n"); 
		query.append("                                                          ) D" ).append("\n"); 
		query.append("            WHERE A.TO_ETA_DT BETWEEN TO_DATE(D.WK_ST_DT,'YYYYMMDD') AND TO_DATE(D.WK_END_DT,'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("			AND   DECODE(A.TYPE_CD,'P',A.TO_ECC_CD,'1') = DECODE(A.TYPE_CD,'P',@[loc_cd],'1')" ).append("\n"); 
		query.append("            AND   A.TO_YD_CD= Y.YD_CD" ).append("\n"); 
		query.append("            AND   A.CNTR_QTY > 0" ).append("\n"); 
		query.append("            AND   DECODE(A.TYPE_CD,'P',A.REPO_PLN_ID,'1') = DECODE(A.TYPE_CD,'P',@[repo_pln_id],'1')" ).append("\n"); 
		query.append("        #elseif (${repo_flag} == 'OUT')" ).append("\n"); 
		query.append("            SELECT /*+ ordered use_nl(D Y A) */" ).append("\n"); 
		query.append("                A.TRSP_MOD_CD" ).append("\n"); 
		query.append("               ,(SELECT V.VSL_SLAN_CD" ).append("\n"); 
		query.append("                 FROM VSK_VSL_SKD V" ).append("\n"); 
		query.append("                 WHERE A.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                 AND   A.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND   A.SKD_DIR_CD = V.SKD_DIR_CD) VSL_SLAN_CD" ).append("\n"); 
		query.append("               ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("               ,A.FM_YD_CD" ).append("\n"); 
		query.append("               ,TO_CHAR(A.FM_ETD_DT,'YYYYMMDD') FM_ETD_DT" ).append("\n"); 
		query.append("               ,A.TO_YD_CD" ).append("\n"); 
		query.append("               ,TO_CHAR(A.TO_ETA_DT,'YYYYMMDD') TO_ETA_DT" ).append("\n"); 
		query.append("               ,A.CNTR_QTY" ).append("\n"); 
		query.append("               ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            FROM (SELECT /*+ INDEX(A XPKEQR_WK_PRD) */ " ).append("\n"); 
		query.append("                        ROWNUM AS SEQ,PLN_YR||PLN_WK, WK_ST_DT, WK_END_DT, @[fcast_yrwk] FCAST_YRWK , @[loc_cd] LOC_CD" ).append("\n"); 
		query.append("                  FROM EQR_WK_PRD A" ).append("\n"); 
		query.append("                  WHERE PLN_YR = SUBSTR(@[fcast_yrwk],1,4)" ).append("\n"); 
		query.append("                  and   PLN_WK = SUBSTR(@[fcast_yrwk],5,2)" ).append("\n"); 
		query.append("                  ) D, LV_YD_LIST Y, EQR_MTY_REPO_OB_V A" ).append("\n"); 
		query.append("            WHERE A.FM_ETD_DT BETWEEN TO_DATE(D.WK_ST_DT,'YYYYMMDD') AND TO_DATE(D.WK_END_DT,'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("            AND   A.FM_YD_CD= Y.YD_CD" ).append("\n"); 
		query.append("            AND   A.CNTR_QTY > 0    " ).append("\n"); 
		query.append("        #end                                    " ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("        GROUP BY ROLLUP(A.TRSP_MOD_CD,A.VSL_SLAN_CD,A.VVD,A.FM_YD_CD,A.FM_ETD_DT,A.TO_YD_CD,A.TO_ETA_DT)" ).append("\n"); 
		query.append("		#if (${repo_flag} == 'IN')" ).append("\n"); 
		query.append("			ORDER BY DECODE(A.TRSP_MOD_CD,'V','1','W','2','T','3','R','4'),  A.TO_ETA_DT" ).append("\n"); 
		query.append("		#elseif (${repo_flag} == 'OUT')" ).append("\n"); 
		query.append("			ORDER BY DECODE(A.TRSP_MOD_CD,'V','1','W','2','T','3','R','4'),  A.FM_ETD_DT" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("     A.LVL" ).append("\n"); 
		query.append("    ,A.TRSP_MOD_CD" ).append("\n"); 
		query.append("    ,A.VSL_SLAN_CD" ).append("\n"); 
		query.append("    ,A.VVD" ).append("\n"); 
		query.append("    ,A.FM_YD_CD" ).append("\n"); 
		query.append("    ,A.FM_ETD_DT" ).append("\n"); 
		query.append("    ,A.TO_YD_CD" ).append("\n"); 
		query.append("    ,A.TO_ETA_DT" ).append("\n"); 
		query.append("    ,(FCAST_QTY1+FCAST_QTY2+FCAST_QTY3+FCAST_QTY4+FCAST_QTY5+FCAST_QTY6+FCAST_QTY7+FCAST_QTY8+FCAST_QTY9+FCAST_QTY10+FCAST_QTY11+FCAST_QTY12+FCAST_QTY13+FCAST_QTY14+FCAST_QTY15) TOTAL" ).append("\n"); 
		query.append("    ,NVL(A.FCAST_QTY1,0)  FCAST_QTY1 " ).append("\n"); 
		query.append("    ,NVL(A.FCAST_QTY2 ,0) FCAST_QTY2  " ).append("\n"); 
		query.append("    ,NVL(A.FCAST_QTY3 ,0) FCAST_QTY3  " ).append("\n"); 
		query.append("    ,NVL(A.FCAST_QTY4 ,0) FCAST_QTY4  " ).append("\n"); 
		query.append("    ,NVL(A.FCAST_QTY5 ,0) FCAST_QTY5  " ).append("\n"); 
		query.append("    ,NVL(A.FCAST_QTY6 ,0) FCAST_QTY6  " ).append("\n"); 
		query.append("    ,NVL(A.FCAST_QTY7 ,0) FCAST_QTY7  " ).append("\n"); 
		query.append("    ,NVL(A.FCAST_QTY8 ,0) FCAST_QTY8  " ).append("\n"); 
		query.append("    ,NVL(A.FCAST_QTY9 ,0) FCAST_QTY9  " ).append("\n"); 
		query.append("    ,NVL(A.FCAST_QTY10,0) FCAST_QTY10 " ).append("\n"); 
		query.append("    ,NVL(A.FCAST_QTY11,0) FCAST_QTY11 " ).append("\n"); 
		query.append("    ,NVL(A.FCAST_QTY12,0) FCAST_QTY12 " ).append("\n"); 
		query.append("    ,NVL(A.FCAST_QTY13,0) FCAST_QTY13 " ).append("\n"); 
		query.append("    ,NVL(A.FCAST_QTY14,0) FCAST_QTY14 " ).append("\n"); 
		query.append("    ,NVL(A.FCAST_QTY15,0) FCAST_QTY15     " ).append("\n"); 
		query.append("FROM LV_AVAL_REPO A" ).append("\n"); 
		query.append("WHERE A.LVL IN ('000000','111111')" ).append("\n"); 

	}
}