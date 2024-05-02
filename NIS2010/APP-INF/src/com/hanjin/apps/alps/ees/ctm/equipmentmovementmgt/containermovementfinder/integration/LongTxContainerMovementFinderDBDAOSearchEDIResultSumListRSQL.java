/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LongTxContainerMovementFinderDBDAOSearchEDIResultSumListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.01.08 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongTxContainerMovementFinderDBDAOSearchEDIResultSumListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public LongTxContainerMovementFinderDBDAOSearchEDIResultSumListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gap_radio",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("source_radio",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : LongTxContainerMovementFinderDBDAOSearchEDIResultSumListRSQL").append("\n"); 
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
		query.append("SELECT   RCC," ).append("\n"); 
		query.append("CN," ).append("\n"); 
		query.append("LCC," ).append("\n"); 
		query.append("LOC," ).append("\n"); 
		query.append("YARD," ).append("\n"); 
		query.append("SUM (INIT_ERR_CNT) AS INT_ERR," ).append("\n"); 
		query.append("ROUND (SUM (INIT_ERR_CNT) / SUM (TTL_CNT) * 100, 1) AS INT_ERR_RATIO," ).append("\n"); 
		query.append("SUM (TTL_CNT) - SUM (INIT_ERR_CNT) AS INT_OK," ).append("\n"); 
		query.append("ROUND ((SUM (TTL_CNT) - SUM (INIT_ERR_CNT)) / SUM (TTL_CNT) * 100, 1) AS INT_OK_RATIO," ).append("\n"); 
		query.append("SUM (TTL_CNT) AS INT_TTL," ).append("\n"); 
		query.append("#if (${gap_radio} == '12')" ).append("\n"); 
		query.append("SUM (GAP_12) AS EDI_12H," ).append("\n"); 
		query.append("ROUND (SUM (GAP_12) / SUM (TTL_CNT), 1) * 100 AS EDI_12H_RATIO," ).append("\n"); 
		query.append("(SUM (GAP_24) + SUM (GAP_48) + SUM (GAP_OVER)) AS EDI_OVER," ).append("\n"); 
		query.append("ROUND ((SUM (GAP_24) + SUM (GAP_48) + SUM (GAP_OVER)) / SUM (TTL_CNT), 1) * 100 AS EDI_OVER_RATIO," ).append("\n"); 
		query.append("#elseif (${gap_radio} == '24')" ).append("\n"); 
		query.append("(SUM (GAP_12) + SUM (GAP_24)) AS EDI_24H," ).append("\n"); 
		query.append("ROUND ((SUM (GAP_12) + SUM (GAP_24)) / SUM (TTL_CNT), 1) * 100 AS EDI_24H_RATIO," ).append("\n"); 
		query.append("(SUM (GAP_48) + SUM (GAP_OVER)) AS EDI_OVER," ).append("\n"); 
		query.append("ROUND ((SUM (GAP_48) + SUM (GAP_OVER)) / SUM (TTL_CNT), 1) * 100 AS EDI_OVER_RATIO," ).append("\n"); 
		query.append("#elseif (${gap_radio} == '48')" ).append("\n"); 
		query.append("(SUM (GAP_12) + SUM (GAP_24) + SUM (GAP_48)) AS EDI_48H," ).append("\n"); 
		query.append("ROUND ((SUM (GAP_12) + SUM (GAP_24) + SUM (GAP_48)) / SUM (TTL_CNT), 1) * 100 AS EDI_48H_RATIO," ).append("\n"); 
		query.append("SUM (GAP_OVER) AS EDI_OVER," ).append("\n"); 
		query.append("ROUND (SUM (GAP_OVER) / SUM (TTL_CNT), 1) * 100 AS EDI_OVER_RATIO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SUM (GAP_12) AS EDI_12H," ).append("\n"); 
		query.append("ROUND (SUM (GAP_12) / SUM (TTL_CNT), 1) * 100 AS EDI_12H_RATIO," ).append("\n"); 
		query.append("SUM (GAP_24) AS EDI_24H," ).append("\n"); 
		query.append("ROUND (SUM (GAP_24) / SUM (TTL_CNT), 1) * 100 AS EDI_24H_RATIO," ).append("\n"); 
		query.append("SUM (GAP_48) AS EDI_48H," ).append("\n"); 
		query.append("ROUND (SUM (GAP_48) / SUM (TTL_CNT), 1) * 100 AS EDI_48H_RATIO," ).append("\n"); 
		query.append("SUM (GAP_OVER) AS EDI_OVER," ).append("\n"); 
		query.append("ROUND (SUM (GAP_OVER) / SUM (TTL_CNT), 1) * 100 AS EDI_OVER_RATIO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SUM (TTL_CNT) AS EDI_TTL," ).append("\n"); 
		query.append("@[p_date1] AS P_DATE1," ).append("\n"); 
		query.append("@[p_date2] AS P_DATE2," ).append("\n"); 
		query.append("@[gap_radio] AS GAP_RADIO," ).append("\n"); 
		query.append("@[source_radio] AS SOURCE_RADIO" ).append("\n"); 
		query.append("FROM (SELECT ME.RCC_CD AS RCC," ).append("\n"); 
		query.append("SUBSTR (EVNT_YD_CD, 1, 2) AS CN," ).append("\n"); 
		query.append("ME.LCC_CD AS LCC," ).append("\n"); 
		query.append("SUBSTR (EVNT_YD_CD, 1, 5) AS LOC," ).append("\n"); 
		query.append("EVNT_YD_CD AS YARD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN (RTY_KNT = 0 AND MVMT_EDI_RSLT_CD = 'N') OR (RTY_KNT > 0)" ).append("\n"); 
		query.append("THEN 1" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END AS INIT_ERR_CNT," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN (RTY_KNT = RTY_KNT)" ).append("\n"); 
		query.append("THEN 1" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END AS TTL_CNT," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN ROUND (CRE_LOCL_DT - EVNT_DT, 2) <= 0.5" ).append("\n"); 
		query.append("THEN 1" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END AS GAP_12," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN ROUND (CRE_LOCL_DT - EVNT_DT, 2) > 0.5 AND ROUND (CRE_LOCL_DT - EVNT_DT, 2) <= 1" ).append("\n"); 
		query.append("THEN 1" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END AS GAP_24," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN ROUND (CRE_LOCL_DT - EVNT_DT, 2) > 1 AND ROUND (CRE_LOCL_DT - EVNT_DT, 2) <= 2" ).append("\n"); 
		query.append("THEN 1" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END AS GAP_48," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN ROUND (CRE_LOCL_DT - EVNT_DT, 2) > 2" ).append("\n"); 
		query.append("THEN 1" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END AS GAP_OVER" ).append("\n"); 
		query.append("FROM CTM_MVMT_EDI_MSG," ).append("\n"); 
		query.append("MDM_LOCATION ML," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT ME" ).append("\n"); 
		query.append("WHERE IDX_CRE_LOCL_DT BETWEEN REPLACE (@[p_date1], '-', '') AND REPLACE (@[p_date2], '-', '')" ).append("\n"); 
		query.append("AND MVMT_EDI_RSLT_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("#if (${rcc_cd} == '' || ${rcc_cd} == 'ALL')" ).append("\n"); 
		query.append("AND MVMT_EDI_MSG_AREA_CD IN ('USA', 'SWA', 'KOR', 'EUR', 'CHN')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND MVMT_EDI_MSG_AREA_CD = (SELECT SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE CNT_CD = SUBSTR (@[rcc_cd], 0, 2)" ).append("\n"); 
		query.append("AND SUBSTR (SYS_AREA_GRP_ID, 0, 1) != 'D')" ).append("\n"); 
		query.append("AND ME.RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lcc_cd} != '')" ).append("\n"); 
		query.append("AND ME.LCC_CD = @[lcc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_yard2} != '')" ).append("\n"); 
		query.append("AND EVNT_YD_CD = @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("#elseif (${p_yard1} != '')" ).append("\n"); 
		query.append("AND EVNT_YD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${source_radio} == 'DOM')" ).append("\n"); 
		query.append("AND SUBSTR (EDI_MVMT_STS_CD, 0, 1) = 'C'" ).append("\n"); 
		query.append("#elseif (${source_radio} == 'ITN')" ).append("\n"); 
		query.append("AND SUBSTR (EDI_MVMT_STS_CD, 0, 1) != 'C'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ME.SCC_CD = ML.SCC_CD" ).append("\n"); 
		query.append("AND ML.LOC_CD = SUBSTR (EVNT_YD_CD, 0, 5)" ).append("\n"); 
		query.append("/*             AND MVMT_EDI_RMK = DECODE (MVMT_EDI_RSLT_CD, 'Y', 'OK.PROCESSED', MVMT_EDI_RMK)*/" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY RCC, CN, LCC, LOC, YARD" ).append("\n"); 
		query.append("#if (${rcc_cd} != '' && ${rcc_cd} != 'ALL')" ).append("\n"); 
		query.append("HAVING RCC IN (@[rcc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY RCC, CN, LCC, LOC, YARD" ).append("\n"); 

	}
}