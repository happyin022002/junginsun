/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaInlandCostManageDBDAOVerifyInlndCostTrfNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInlandCostManageDBDAOVerifyInlndCostTrfNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inland Cost Tariff No의 Validation Check
	  * </pre>
	  */
	public UsaInlandCostManageDBDAOVerifyInlndCostTrfNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.integration").append("\n"); 
		query.append("FileName : UsaInlandCostManageDBDAOVerifyInlndCostTrfNoRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(COUNT(1) - $trf_no_arr.size(),0,'N','Y') AS ERR_FLG" ).append("\n"); 
		query.append("FROM    AOC_USA_INLND_TRF_HDR" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trf_no_arr} != '')" ).append("\n"); 
		query.append("AND	    COST_TRF_NO IN (" ).append("\n"); 
		query.append("    #foreach ($trf_no_arr_num IN ${trf_no_arr})" ).append("\n"); 
		query.append("        #if($velocityCount < $trf_no_arr.size())" ).append("\n"); 
		query.append("          '$trf_no_arr_num'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          '$trf_no_arr_num'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}