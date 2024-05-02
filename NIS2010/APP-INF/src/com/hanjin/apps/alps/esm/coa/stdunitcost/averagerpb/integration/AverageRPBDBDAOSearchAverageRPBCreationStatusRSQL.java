/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AverageRPBDBDAOSearchAverageRPBCreationStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.averagerpb.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AverageRPBDBDAOSearchAverageRPBCreationStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAverageRPBCreationStatus
	  * </pre>
	  */
	public AverageRPBDBDAOSearchAverageRPBCreationStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rpb_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.averagerpb.integration").append("\n"); 
		query.append("FileName : AverageRPBDBDAOSearchAverageRPBCreationStatusRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(COST_SRC_FM_YRMON,0,4) ||'-'|| SUBSTR(COST_SRC_FM_YRMON,5) || ' ~ ' || SUBSTR(COST_SRC_TO_YRMON,0,4) ||'-'|| SUBSTR(COST_SRC_TO_YRMON,5)" ).append("\n"); 
		query.append("FROM COA_UT_COST_CRE_STS" ).append("\n"); 
		query.append("WHERE COST_YRMON = REPLACE(@[f_rpb_yrmon], '-', '')" ).append("\n"); 
		query.append("  AND CM_UC_CD = 'RPBC'" ).append("\n"); 

	}
}