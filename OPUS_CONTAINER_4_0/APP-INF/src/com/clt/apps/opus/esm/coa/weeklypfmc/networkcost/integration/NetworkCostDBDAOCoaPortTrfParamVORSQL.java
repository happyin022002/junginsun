/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : NetworkCostDBDAOCoaPortTrfParamVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOCoaPortTrfParamVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO 생성 쿼리
	  * </pre>
	  */
	public NetworkCostDBDAOCoaPortTrfParamVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration ").append("\n"); 
		query.append("FileName : NetworkCostDBDAOCoaPortTrfParamVORSQL").append("\n"); 
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
		query.append("SELECT ''  PORT" ).append("\n"); 
		query.append("	, ''  UPD_DT" ).append("\n"); 
		query.append("	, ''  LOCL_CURR_CD" ).append("\n"); 
		query.append("	, ''  CRE_DT" ).append("\n"); 
		query.append("	, ''  CY" ).append("\n"); 
		query.append("	, ''  CNL_USD_AMT" ).append("\n"); 
		query.append("	, ''  TML_CD" ).append("\n"); 
		query.append("	, ''  PORT_USD_AMT" ).append("\n"); 
		query.append("	, ''  SKD_DIR_CD" ).append("\n"); 
		query.append("	, ''  LOCL_CNL_AMT" ).append("\n"); 
		query.append("	, ''  CRE_USR_ID" ).append("\n"); 
		query.append("	, ''  SLAN_CD" ).append("\n"); 
		query.append("	, ''  COST_YRMON" ).append("\n"); 
		query.append("	, ''  LOCL_PORT_AMT" ).append("\n"); 
		query.append("	, ''  VSL_CLSS_CAPA" ).append("\n"); 
		query.append("	, ''  UPD_USR_ID" ).append("\n"); 
		query.append("	, ''  UPLOAD_FLG" ).append("\n"); 
		query.append("     FROM DUAL" ).append("\n"); 

	}
}