/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchChassisUnitCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchChassisUnitCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchChassisUnitCost
	  * 2015.03.26 컬럼 속성명 변경으로 수정()
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchChassisUnitCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_qtr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_qtr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_year",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchChassisUnitCostRSQL").append("\n"); 
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
		query.append("SELECT COST_YR," ).append("\n"); 
		query.append("       BSE_QTR_CD AS COST_QTR_CD," ).append("\n"); 
		query.append("	   COST_YR||'-'||BSE_QTR_CD AS COST_YR_QTR," ).append("\n"); 
		query.append("       DECODE(GID,1,'T',2,'S',COST_TP_CD) AS COST_TP_CD," ).append("\n"); 
		query.append("       DECODE(COST_TP_CD,'A','CY non exemted','C','CY exempted','D','Door Term','L','Live Reefer',DECODE(GID,1,'G.Total','S.Total')) AS COST_TP_NM," ).append("\n"); 
		query.append("       EFF_FM_YRMON," ).append("\n"); 
		query.append("       EFF_TO_YRMON," ).append("\n"); 
		query.append("       DECODE(GID,2,BKG_BX_STTL_QTY,BKG_BX_QTY) AS BKG_BX_QTY," ).append("\n"); 
		query.append("       DECODE(DECODE(GID,1,'',COST_TP_BX_RT),'',DECODE(GID,1,'',COST_TP_BX_RT),'0',DECODE(GID,1,'',COST_TP_BX_RT),DECODE(GID,1,'',COST_TP_BX_RT),DECODE(GID,1,'',COST_TP_BX_RT)||'%') AS COST_TP_BX_RT," ).append("\n"); 
		query.append("       DECODE(GID,2,'',DECODE(COST_TP_CD, '', 100, ROUND(RATIO_TO_REPORT(DECODE(COST_TP_CD,NULL,0,BKG_BX_QTY)) OVER(PARTITION BY COST_YR, BSE_QTR_CD) * 100,2))||'%') COST_TP_BX_RT_TTL," ).append("\n"); 
		query.append("       ESTM_AMT," ).append("\n"); 
		query.append("       ON_ST_UT_COST," ).append("\n"); 
		query.append("       DECODE(GID,1,COM_SUB_TTL) AS COM_SUB_TTL," ).append("\n"); 
		query.append("       COM_UT_COST," ).append("\n"); 
		query.append("       STND_UT_COST       " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT COST_YR," ).append("\n"); 
		query.append("               BSE_QTR_CD," ).append("\n"); 
		query.append("               COST_TP_CD," ).append("\n"); 
		query.append("               MIN(EFF_FM_YRMON) AS EFF_FM_YRMON," ).append("\n"); 
		query.append("               MAX(EFF_TO_YRMON) AS EFF_TO_YRMON," ).append("\n"); 
		query.append("               ROUND(SUM(BKG_BX_QTY),2) AS BKG_BX_QTY," ).append("\n"); 
		query.append("               ROUND(SUM(COST_TP_BX_RT) * 100,2) AS COST_TP_BX_RT," ).append("\n"); 
		query.append("               ROUND(SUM(ESTM_AMT),2) AS ESTM_AMT," ).append("\n"); 
		query.append("               ROUND(ON_ST_UC_AMT,2) AS ON_ST_UT_COST," ).append("\n"); 
		query.append("               ROUND(COM_SUB_TTL_AMT,2) AS COM_SUB_TTL," ).append("\n"); 
		query.append("               ROUND(COM_UC_AMT,2)  AS COM_UT_COST," ).append("\n"); 
		query.append("               ROUND(STND_UC_AMT,2) AS STND_UT_COST," ).append("\n"); 
		query.append("               ROUND(SUM(DECODE(COST_TP_CD,'A',0,BKG_BX_QTY)),2) AS BKG_BX_STTL_QTY," ).append("\n"); 
		query.append("               GROUPING_ID(COST_TP_CD) + GROUPING_ID(COM_SUB_TTL_AMT) as GID  -- GID=1 이면 전체 TOTAL, GID=2 이면 SUB TOTAL" ).append("\n"); 
		query.append("          FROM MAS_CHSS_UT_COST" ).append("\n"); 
		query.append("         WHERE COST_YR||BSE_QTR_CD BETWEEN SUBSTR(@[fr_year]||@[fr_qtr]||'Q',1,6)" ).append("\n"); 
		query.append("									AND 	SUBSTR(@[to_year]||@[to_qtr]||'Q',1,6)" ).append("\n"); 
		query.append("         GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                                 (COST_YR, BSE_QTR_CD,COST_TP_CD, ON_ST_UC_AMT,COM_SUB_TTL_AMT,COM_UC_AMT,STND_UC_AMT)," ).append("\n"); 
		query.append("                                 (COST_YR, BSE_QTR_CD,COM_SUB_TTL_AMT)," ).append("\n"); 
		query.append("                                 (COST_YR, BSE_QTR_CD)" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append(" ORDER BY COST_YR," ).append("\n"); 
		query.append("       BSE_QTR_CD," ).append("\n"); 
		query.append("       DECODE(GID,1,'T',2,'S',COST_TP_CD)" ).append("\n"); 

	}
}