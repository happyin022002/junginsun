/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : INVCommonDBDAOSearchCurrencyCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.07.16 정휘택
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

public class INVCommonDBDAOSearchCurrencyCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * currency list
	  * </pre>
	  */
	public INVCommonDBDAOSearchCurrencyCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDBDAOSearchCurrencyCodeListRSQL").append("\n"); 
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
		query.append("SELECT CURR_CD" ).append("\n"); 
		query.append(", CURR_NM" ).append("\n"); 
		query.append(", DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM MDM_CURRENCY" ).append("\n"); 
		query.append("WHERE NVL(TO_EFF_DT,SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("AND DELT_FLG!='Y'" ).append("\n"); 
		query.append("ORDER BY CURR_CD" ).append("\n"); 

	}
}