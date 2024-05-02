/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LongTxContainerMovementFinderDBDAOSearchEDIErrorSumListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.04.23 김상수
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

public class LongTxContainerMovementFinderDBDAOSearchEDIErrorSumListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public LongTxContainerMovementFinderDBDAOSearchEDIErrorSumListRSQL(){
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
		query.append("FileName : LongTxContainerMovementFinderDBDAOSearchEDIErrorSumListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${data_radio} == 'RCC')" ).append("\n"); 
		query.append("RCC," ).append("\n"); 
		query.append("#elseif (${data_radio} == 'CN')" ).append("\n"); 
		query.append("RCC," ).append("\n"); 
		query.append("CN," ).append("\n"); 
		query.append("#elseif (${data_radio} == 'LCC')" ).append("\n"); 
		query.append("RCC," ).append("\n"); 
		query.append("CN," ).append("\n"); 
		query.append("LCC," ).append("\n"); 
		query.append("#elseif (${data_radio} == 'LOC')" ).append("\n"); 
		query.append("RCC," ).append("\n"); 
		query.append("CN," ).append("\n"); 
		query.append("LCC," ).append("\n"); 
		query.append("LOC," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("RCC," ).append("\n"); 
		query.append("CN," ).append("\n"); 
		query.append("LCC," ).append("\n"); 
		query.append("LOC," ).append("\n"); 
		query.append("YARD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SUM (CORR_ERR_CNT) AS CORR_ERR," ).append("\n"); 
		query.append("ROUND (SUM (CORR_ERR_CNT) / SUM (TTL_CNT) * 100, 1) AS CORR_ERR_RATIO," ).append("\n"); 
		query.append("SUM (TTL_CNT) - SUM (CORR_ERR_CNT) CORR_OK," ).append("\n"); 
		query.append("ROUND ((SUM (TTL_CNT) - SUM (CORR_ERR_CNT)) / SUM (TTL_CNT) * 100, 1) AS CORR_OK_RATIO," ).append("\n"); 
		query.append("SUM (TTL_CNT) AS CORR_TTL," ).append("\n"); 
		query.append("SUM (INIT_ERR_CNT) AS INIT_ERR," ).append("\n"); 
		query.append("ROUND (SUM (INIT_ERR_CNT) / SUM (TTL_CNT) * 100, 1) AS INIT_ERR_RATIO," ).append("\n"); 
		query.append("SUM (TTL_CNT) - SUM (INIT_ERR_CNT) AS INIT_OK," ).append("\n"); 
		query.append("ROUND ((SUM (TTL_CNT) - SUM (INIT_ERR_CNT)) / SUM (TTL_CNT) * 100, 1) AS INIT_OK_RATIO," ).append("\n"); 
		query.append("SUM (TTL_CNT) AS INIT_TTL," ).append("\n"); 
		query.append("@[p_date1] AS P_DATE1," ).append("\n"); 
		query.append("@[p_date2] AS P_DATE2," ).append("\n"); 
		query.append("@[source_radio] AS SOURCE_RADIO" ).append("\n"); 
		query.append("FROM (SELECT ME.RCC_CD AS RCC," ).append("\n"); 
		query.append("SUBSTR (EVNT_YD_CD, 0, 2) AS CN," ).append("\n"); 
		query.append("ME.LCC_CD AS LCC," ).append("\n"); 
		query.append("SUBSTR (EVNT_YD_CD, 0, 5) AS LOC," ).append("\n"); 
		query.append("EVNT_YD_CD AS YARD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN (RTY_KNT = 0 AND MVMT_EDI_RSLT_CD = 'N') OR (RTY_KNT > 0)" ).append("\n"); 
		query.append("THEN 1" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END AS INIT_ERR_CNT," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN (MVMT_EDI_RSLT_CD = 'N')" ).append("\n"); 
		query.append("THEN 1" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END AS CORR_ERR_CNT," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN (RTY_KNT = RTY_KNT)" ).append("\n"); 
		query.append("THEN 1" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END AS TTL_CNT" ).append("\n"); 
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
		query.append("#if (${data_radio} == 'RCC')" ).append("\n"); 
		query.append("GROUP BY RCC" ).append("\n"); 
		query.append("ORDER BY RCC" ).append("\n"); 
		query.append("#elseif (${data_radio} == 'CN')" ).append("\n"); 
		query.append("GROUP BY RCC, CN" ).append("\n"); 
		query.append("ORDER BY RCC, CN" ).append("\n"); 
		query.append("#elseif (${data_radio} == 'LCC')" ).append("\n"); 
		query.append("GROUP BY RCC, CN, LCC" ).append("\n"); 
		query.append("ORDER BY RCC, CN, LCC" ).append("\n"); 
		query.append("#elseif (${data_radio} == 'LOC')" ).append("\n"); 
		query.append("GROUP BY RCC, CN, LCC, LOC" ).append("\n"); 
		query.append("ORDER BY RCC, CN, LCC, LOC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("GROUP BY RCC, CN, LCC, LOC, YARD" ).append("\n"); 
		query.append("ORDER BY RCC, CN, LCC, LOC, YARD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}