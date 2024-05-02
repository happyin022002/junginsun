/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOMdmCurrencyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.11.02 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOMdmCurrencyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MdmCurrencyVO Currency Code Select Query.
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOMdmCurrencyVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOMdmCurrencyVORSQL").append("\n"); 
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
		query.append("CURR_CD" ).append("\n"); 
		query.append(",	CURR_NM" ).append("\n"); 
		query.append(",	CURR_DESC" ).append("\n"); 
		query.append(",	CNT_CD" ).append("\n"); 
		query.append("FROM MDM_CURRENCY" ).append("\n"); 
		query.append("ORDER BY CURR_CD ASC" ).append("\n"); 

	}
}