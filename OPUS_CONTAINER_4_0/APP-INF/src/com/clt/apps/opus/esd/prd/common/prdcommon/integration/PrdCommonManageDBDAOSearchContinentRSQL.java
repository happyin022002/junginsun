/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdCommonManageDBDAOSearchContinentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.08.10 노승배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Noh Seung Bae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCommonManageDBDAOSearchContinentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchContinent
	  * </pre>
	  */
	public PrdCommonManageDBDAOSearchContinentRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcommon.integration").append("\n"); 
		query.append("FileName : PrdCommonManageDBDAOSearchContinentRSQL").append("\n"); 
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
		query.append("SELECT conti_cd conti_code, conti_nm conti_name FROM mdm_continent WHERE NVL( delt_flg,'N') <> 'Y'" ).append("\n"); 

	}
}