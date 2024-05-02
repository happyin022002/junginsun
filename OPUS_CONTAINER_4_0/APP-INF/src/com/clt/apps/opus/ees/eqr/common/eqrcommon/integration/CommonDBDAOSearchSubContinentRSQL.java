/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommonDBDAOSearchSubContinentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchSubContinentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sub Continent Combo List
	  * </pre>
	  */
	public CommonDBDAOSearchSubContinentRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSubContinentRSQL").append("\n"); 
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
		query.append("SELECT ms.sconti_cd fm_conti_cd," ).append("\n"); 
		query.append("	ms.sconti_nm," ).append("\n"); 
		query.append("	m.conti_cd," ).append("\n"); 
		query.append("	m.conti_nm," ).append("\n"); 
		query.append("	(CASE " ).append("\n"); 
		query.append("		WHEN 'Y' = ms.delt_flg THEN 'Delete' " ).append("\n"); 
		query.append("		ELSE 'Active' " ).append("\n"); 
		query.append("	END) AS delt_flg" ).append("\n"); 
		query.append("FROM mdm_subcontinent ms left outer join mdm_continent m ON ms.conti_cd = m.conti_cd" ).append("\n"); 
		query.append("WHERE 1 = 1 ORDER BY ms.sconti_cd" ).append("\n"); 

	}
}