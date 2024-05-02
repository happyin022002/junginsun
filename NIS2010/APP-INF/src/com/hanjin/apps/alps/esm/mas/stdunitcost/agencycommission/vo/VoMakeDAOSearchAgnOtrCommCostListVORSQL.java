/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VoMakeDAOSearchAgnOtrCommCostListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.03
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.12.03 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoMakeDAOSearchAgnOtrCommCostListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public VoMakeDAOSearchAgnOtrCommCostListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.vo").append("\n"); 
		query.append("FileName : VoMakeDAOSearchAgnOtrCommCostListVORSQL").append("\n"); 
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
		query.append("      	'' AS OTR_COMM_TTL_AMT,                    " ).append("\n"); 
		query.append("		'' AS MAS_COST_SRC_CD_NM,                  " ).append("\n"); 
		query.append("		'' AS COST_YRMON,                          " ).append("\n"); 
		query.append("		'' AS MAS_COST_SRC_CD,                     " ).append("\n"); 
		query.append("		'' AS CNTR_TPSZ_CD,                        " ).append("\n"); 
		query.append("		'' AS BKG_TTL_QTY,                         " ).append("\n"); 
		query.append("		'' AS COMM_LOC_CD,                         " ).append("\n"); 
		query.append("		'' AS STND_COST_USD_AMT,  " ).append("\n"); 
		query.append("		'' AS DIV_STND                " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}