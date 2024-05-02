/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : INVCommonDBDAOsearchPerTpCdListRSQL.java
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

public class INVCommonDBDAOsearchPerTpCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVCommonDBDAOsearchPerTpCdListRSQL
	  * </pre>
	  */
	public INVCommonDBDAOsearchPerTpCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.invcommon.invcommon.integration").append("\n"); 
		query.append("FileName : INVCommonDBDAOsearchPerTpCdListRSQL").append("\n"); 
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
		query.append("SELECT ' ' RAT_UT_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT RAT_UT_CD" ).append("\n"); 
		query.append("FROM PRI_RAT_UT" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY RAT_UT_CD" ).append("\n"); 

	}
}