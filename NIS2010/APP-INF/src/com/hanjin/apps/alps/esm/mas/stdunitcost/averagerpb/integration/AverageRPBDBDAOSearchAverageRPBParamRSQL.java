/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AverageRPBDBDAOSearchAverageRPBParamRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AverageRPBDBDAOSearchAverageRPBParamRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAverageRPBParam
	  * </pre>
	  */
	public AverageRPBDBDAOSearchAverageRPBParamRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_target_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.averagerpb.integration").append("\n"); 
		query.append("FileName : AverageRPBDBDAOSearchAverageRPBParamRSQL").append("\n"); 
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
		query.append("SELECT REPLACE(@[f_target_yrmon],'-','')||'#'||" ).append("\n"); 
		query.append("       REPLACE(@[f_to_yrwk],'-','')||'#'|| " ).append("\n"); 
		query.append("       SUBSTR(REPLACE(@[f_to_yrwk],'-',''),5) ||'#'||" ).append("\n"); 
		query.append("       TO_CHAR(COUNT(0)-1) AS BATCHPARAMS" ).append("\n"); 
		query.append("  FROM MAS_WK_PRD " ).append("\n"); 
		query.append(" WHERE COST_YR||COST_WK BETWEEN REPLACE(@[f_fm_yrwk],'-','') AND REPLACE(@[f_to_yrwk],'-','')" ).append("\n"); 

	}
}