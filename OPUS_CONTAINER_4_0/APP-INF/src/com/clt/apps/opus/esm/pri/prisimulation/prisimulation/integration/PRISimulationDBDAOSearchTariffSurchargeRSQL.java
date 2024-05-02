/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRISimulationDBDAOSearchTariffSurchargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRISimulationDBDAOSearchTariffSurchargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PRISimulationDBDAOSearchTariffSurchargeRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration").append("\n"); 
		query.append("FileName : PRISimulationDBDAOSearchTariffSurchargeRSQL").append("\n"); 
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
		query.append("SELECT PCTL_NO" ).append("\n"); 
		query.append("      ,CHG_CD" ).append("\n"); 
		query.append("      ,PC_CHG" ).append("\n"); 
		query.append("      ,'1' AS APPLY" ).append("\n"); 
		query.append("      ,RAT_AS_QTY" ).append("\n"); 
		query.append("      ,PC" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(CNTR_SZ_CD, 2), '2', USD_AMT, 0)) AS D20" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(CNTR_SZ_CD, 2), '4', USD_AMT, 0)) AS D40" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(CNTR_SZ_CD, 2), '5', USD_AMT, 0)) AS D45" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(CNTR_SZ_CD, 2), '7', USD_AMT, 0)) AS D70" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(CNTR_SZ_CD, 2), '2', USD_TOT_AMT, 0)) AS D20_INIT" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(CNTR_SZ_CD, 2), '4', USD_TOT_AMT, 0)) AS D40_INIT" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(CNTR_SZ_CD, 2), '5', USD_TOT_AMT, 0)) AS D45_INIT" ).append("\n"); 
		query.append("      ,SUM(DECODE(SUBSTR(CNTR_SZ_CD, 2), '7', USD_TOT_AMT, 0)) AS D70_INIT" ).append("\n"); 
		query.append("      ,0 AS D20_TOT" ).append("\n"); 
		query.append("      ,0 AS D40_TOT" ).append("\n"); 
		query.append("      ,0 AS D45_TOT" ).append("\n"); 
		query.append("      ,0 AS D70_TOT" ).append("\n"); 
		query.append("      ,(SELECT SVC_SCP_CD FROM PRI_SIM_PARA MST WHERE A.PCTL_NO = MST.PCTL_NO) AS SVC_SCP_CD" ).append("\n"); 
		query.append("  FROM (SELECT CHG.PCTL_NO" ).append("\n"); 
		query.append("              ,CHG.CNTR_SZ_CD" ).append("\n"); 
		query.append("              ,CHG.CHG_CD" ).append("\n"); 
		query.append("              ,CHG.CURR_CD" ).append("\n"); 
		query.append("              ,CHG.RAT_UT_CD" ).append("\n"); 
		query.append("              ,CHG.CHG_AMT" ).append("\n"); 
		query.append("              ,ROUND(CHG.APLY_XCH_RTO * CHG.CHG_AMT,2) AS USD_AMT" ).append("\n"); 
		query.append("              ,ROUND(CHG.APLY_XCH_RTO * CHG.CHG_AMT,2) * 100 * (1 / CHG.RAT_AS_QTY) AS USD_TOT_AMT" ).append("\n"); 
		query.append("              ,CHG.RAT_AS_QTY" ).append("\n"); 
		query.append("              ,BKG_JOIN_FNC(CURSOR(SELECT BSE_CHG.CHG_CD FROM PRI_SCG_PCT_BSE_CHG BSE_CHG WHERE BSE_CHG.PCT_BSE_CD = PRF.PCT_BSE_CD),',') AS PC_CHG" ).append("\n"); 
		query.append("              ,(SELECT PATT_DESC FROM PRI_SCG_PCT_BSE BSE WHERE BSE.PCT_BSE_CD = PRF.PCT_BSE_CD) AS PC" ).append("\n"); 
		query.append("         FROM PRI_SIM_CHG_RT CHG" ).append("\n"); 
		query.append("             ,PRI_SCG_PRF PRF" ).append("\n"); 
		query.append("        WHERE CHG.PCTL_NO LIKE @[f_pctl_no]||'%'" ).append("\n"); 
		query.append("          AND CHG.SVC_SCP_CD = PRF.SVC_SCP_CD --CHG테이블에 SVC_SCP_CD 데이터 채워넣어주세영" ).append("\n"); 
		query.append("          AND CHG.RAT_UT_CD = 'PC'" ).append("\n"); 
		query.append("          AND CHG.CHG_CD = PRF.CHG_CD" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT CHG.PCTL_NO" ).append("\n"); 
		query.append("              ,CHG.CNTR_SZ_CD" ).append("\n"); 
		query.append("              ,CHG.CHG_CD" ).append("\n"); 
		query.append("              ,CHG.CURR_CD" ).append("\n"); 
		query.append("              ,CHG.RAT_UT_CD" ).append("\n"); 
		query.append("              ,CHG.CHG_AMT" ).append("\n"); 
		query.append("              ,ROUND(CHG.APLY_XCH_RTO * CHG.CHG_AMT,2) AS USD_AMT" ).append("\n"); 
		query.append("              ,0" ).append("\n"); 
		query.append("              ,NULL AS RAT_AS_QTY" ).append("\n"); 
		query.append("              ,NULL AS PC_CHG" ).append("\n"); 
		query.append("              ,'' AS PC" ).append("\n"); 
		query.append("          FROM PRI_SIM_CHG_RT CHG" ).append("\n"); 
		query.append("         WHERE CHG.PCTL_NO LIKE @[f_pctl_no]||'%'" ).append("\n"); 
		query.append("           AND CHG.RAT_UT_CD NOT IN ('PC','CM','MT')--CM,MT는 예외처리로 제외" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("GROUP BY PCTL_NO" ).append("\n"); 
		query.append("      ,CHG_CD" ).append("\n"); 
		query.append("      ,PC_CHG" ).append("\n"); 
		query.append("      ,RAT_AS_QTY" ).append("\n"); 
		query.append("      ,PC" ).append("\n"); 
		query.append("ORDER BY PCTL_NO" ).append("\n"); 
		query.append("        ,CHG_CD" ).append("\n"); 

	}
}