/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VoMakeDAOSearchPortTariffListMasVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.12.17 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoMakeDAOSearchPortTariffListMasVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public VoMakeDAOSearchPortTariffListMasVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo").append("\n"); 
		query.append("FileName : VoMakeDAOSearchPortTariffListMasVORSQL").append("\n"); 
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
		query.append("      	'' AS VSL_CD,                                    " ).append("\n"); 
		query.append("		'' AS SLAN_CD,                                   " ).append("\n"); 
		query.append("		'' AS COST_YRMON,                                " ).append("\n"); 
		query.append("		'' AS PSO_COST_PSO_TTL_AMT,                      " ).append("\n"); 
		query.append("		'' AS COST_WK,                                   " ).append("\n"); 
		query.append("		'' AS PSO_COST_TTL_AMT,                          " ).append("\n"); 
		query.append("		'' AS CHK_FLAG,                                  " ).append("\n"); 
		query.append("		'' AS SKD_VOY_NO,                                " ).append("\n"); 
		query.append("		'' AS COST_STS,                                  " ).append("\n"); 
		query.append("		'' AS SKD_DIR_CD,                                " ).append("\n"); 
		query.append("		'' AS USER_ID,                                   " ).append("\n"); 
		query.append("		'' AS PSO_MAX_SEQ,                               " ).append("\n"); 
		query.append("		'' AS HUL_BND_CD                          " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}