/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EQHoldingDBDAOSearchEQHldCostSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.12.24 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQHoldingDBDAOSearchEQHldCostSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ Holding Cost TPSZ별 구간 합계 조회
	  * </pre>
	  */
	public EQHoldingDBDAOSearchEQHldCostSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.integration").append("\n"); 
		query.append("FileName : EQHoldingDBDAOSearchEQHldCostSumRSQL").append("\n"); 
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
		query.append("SELECT @[f_cost_yrmon] COST_YRMON" ).append("\n"); 
		query.append("      ,TPSZ_CD" ).append("\n"); 
		query.append("      ,ROUND(TTL_DYS / BOX_CNT,2) TTL_DYS" ).append("\n"); 
		query.append("      ,ROUND(SEA_DYS / BOX_CNT,2) SEA_DYS" ).append("\n"); 
		query.append("      ,ROUND(ORG_RAIL_DYS / BOX_CNT,2) ORG_RAIL_DYS" ).append("\n"); 
		query.append("      ,ROUND(DEST_RAIL_DYS / BOX_CNT,2) DEST_RAIL_DYS" ).append("\n"); 
		query.append("      ,ROUND(FULL_DMT / BOX_CNT,2) FULL_DMT" ).append("\n"); 
		query.append("      ,ROUND(MT_LAND / BOX_CNT,2) MT_LAND" ).append("\n"); 
		query.append("      ,ROUND(SUB_TOT / BOX_CNT,2) SUB_TOT" ).append("\n"); 
		query.append("      ,ROUND(SUB_TOT / BOX_CNT,2) AVG_DYS" ).append("\n"); 
		query.append("      ,ROUND(90 - (ROUND(SUB_TOT / BOX_CNT,2)),2) MT_SEA_DYS" ).append("\n"); 
		query.append("      ,90 - ROUND(SEA_DYS / BOX_CNT,2) - ROUND(ORG_RAIL_DYS / BOX_CNT,2) - ROUND(DEST_RAIL_DYS / BOX_CNT,2) " ).append("\n"); 
		query.append("        - ROUND(MT_LAND / BOX_CNT,2) - ROUND(90 - (ROUND(SUB_TOT / BOX_CNT,2))) DAY_A   -- DMT 대응구간 : 90-SEA_DYS-ORG_RAIL_DYS-DEST_RAIL_DYS-MT_LAND-MT_SEA_DYS" ).append("\n"); 
		query.append("      ,ROUND(ORG_RAIL_DYS / BOX_CNT,2) + ROUND(DEST_RAIL_DYS / BOX_CNT,2) + ROUND(SEA_DYS / BOX_CNT,2)" ).append("\n"); 
		query.append("        + ROUND(MT_LAND / BOX_CNT,2) + ROUND(90 - (ROUND(SUB_TOT / BOX_CNT,2))) DAY_B   -- DMT 이외구간 : SEA_DYS+ORG_RAIL_DYS+DEST_RAIL_DYS+MT_LAND+MT_SEA_DYS" ).append("\n"); 
		query.append("      ,(ROUND(ORG_RAIL_DYS / BOX_CNT,2) + ROUND(DEST_RAIL_DYS / BOX_CNT,2) + ROUND(SEA_DYS / BOX_CNT,2)" ).append("\n"); 
		query.append("        + ROUND(MT_LAND / BOX_CNT,2) + ROUND(90 - (ROUND(SUB_TOT / BOX_CNT,2)))) - ROUND(90 - (ROUND(SUB_TOT / BOX_CNT,2))) DAY_C" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT TPSZ_CD" ).append("\n"); 
		query.append("              ,NVL(SUM(TTL_DYS),0) TTL_DYS" ).append("\n"); 
		query.append("              ,NVL(SUM(SEA_DYS),0) SEA_DYS" ).append("\n"); 
		query.append("              ,NVL(SUM(ORG_RAIL_DYS),0) ORG_RAIL_DYS" ).append("\n"); 
		query.append("              ,NVL(SUM(DEST_RAIL_DYS),0) DEST_RAIL_DYS" ).append("\n"); 
		query.append("              ,NVL(SUM(FULL_DMT),0) FULL_DMT" ).append("\n"); 
		query.append("              ,NVL(SUM(MT_LAND),0) MT_LAND" ).append("\n"); 
		query.append("              ,NVL(SUM(SUB_TOT),0) SUB_TOT" ).append("\n"); 
		query.append("              ,NVL(SUM(BOX_CNT),0) BOX_CNT" ).append("\n"); 
		query.append("          FROM MAS_CNTR_SECT_DAY_CALC" ).append("\n"); 
		query.append("          WHERE COST_YRMON BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(@[f_cost_yrmon],'YYYYMM'), -4),'YYYYMM') AND " ).append("\n"); 
		query.append("						TO_CHAR(ADD_MONTHS(TO_DATE(@[f_cost_yrmon],'YYYYMM'), -2),'YYYYMM')" ).append("\n"); 
		query.append("			#if (${f_cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("				AND TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("          GROUP BY TPSZ_CD" ).append("\n"); 
		query.append("          ORDER BY TPSZ_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}