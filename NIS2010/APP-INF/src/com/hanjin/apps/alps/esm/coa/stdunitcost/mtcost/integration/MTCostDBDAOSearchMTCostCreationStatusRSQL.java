/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MTCostDBDAOSearchMTCostCreationStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTCostDBDAOSearchMTCostCreationStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ Repo Cost - M/B 기간을 조회한다.
	  * </pre>
	  */
	public MTCostDBDAOSearchMTCostCreationStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.integration ").append("\n"); 
		query.append("FileName : MTCostDBDAOSearchMTCostCreationStatusRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(TO_DATE(COST_SRC_FM_YRMON, 'YYYYMM'), 'YYYY-MM') || ' ~ ' || TO_CHAR(TO_DATE(COST_SRC_TO_YRMON, 'YYYYMM'), 'YYYY-MM')" ).append("\n"); 
		query.append("FROM COA_UT_COST_CRE_STS" ).append("\n"); 
		query.append("WHERE COST_YRMON = REPLACE(@[f_cost_yrmon], '-', '')" ).append("\n"); 
		query.append("  AND CM_UC_CD = 'EMPA'" ).append("\n"); 

	}
}