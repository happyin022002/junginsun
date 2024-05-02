/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EQHoldingDBDAOSearchEQCntrHldCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.12.22 최덕우
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

public class EQHoldingDBDAOSearchEQCntrHldCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ Holding Cost 조회(MAS용)
	  * </pre>
	  */
	public EQHoldingDBDAOSearchEQCntrHldCostRSQL(){
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
		query.append("FileName : EQHoldingDBDAOSearchEQCntrHldCostRSQL").append("\n"); 
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
		query.append("SELECT COST_YRMON" ).append("\n"); 
		query.append("      ,TPSZ_CD" ).append("\n"); 
		query.append("      ,TTL_DYS" ).append("\n"); 
		query.append("      ,SEA_DYS" ).append("\n"); 
		query.append("      ,ORG_RAIL_DYS" ).append("\n"); 
		query.append("      ,DEST_RAIL_DYS" ).append("\n"); 
		query.append("      ,FULL_DMT" ).append("\n"); 
		query.append("      ,MT_LAND" ).append("\n"); 
		query.append("      ,SUB_TOT" ).append("\n"); 
		query.append("      ,BOX_CNT" ).append("\n"); 
		query.append("      ,AVG_DYS" ).append("\n"); 
		query.append("      ,MT_SEA_DYS" ).append("\n"); 
		query.append("  FROM MAS_CNTR_SECT_DAY_CALC" ).append("\n"); 
		query.append("  WHERE COST_YRMON BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(@[f_cost_yrmon],'YYYYMM'), -4),'YYYYMM') AND " ).append("\n"); 
		query.append("			TO_CHAR(ADD_MONTHS(TO_DATE(@[f_cost_yrmon],'YYYYMM'), -2),'YYYYMM')" ).append("\n"); 
		query.append("	#if (${f_cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("		AND TPSZ_CD = @[f_cntr_tpsz_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("  ORDER BY TPSZ_CD, COST_YRMON" ).append("\n"); 

	}
}