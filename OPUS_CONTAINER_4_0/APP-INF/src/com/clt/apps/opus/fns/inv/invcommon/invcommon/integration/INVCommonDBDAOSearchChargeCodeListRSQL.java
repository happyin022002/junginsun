/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : INVCommonDBDAOSearchChargeCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2010.02.10 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.invcommon.invcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class INVCommonDBDAOSearchChargeCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchChargeCodeList
	  * </pre>
	  */
	public INVCommonDBDAOSearchChargeCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDBDAOSearchChargeCodeListRSQL").append("\n"); 
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
		query.append("SELECT ' ' CHG_CD, ' ' CHG_NM" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT CHG_CD, CHG_NM" ).append("\n"); 
		query.append("FROM MDM_CHARGE" ).append("\n"); 
		query.append("ORDER BY CHG_CD" ).append("\n"); 

	}
}