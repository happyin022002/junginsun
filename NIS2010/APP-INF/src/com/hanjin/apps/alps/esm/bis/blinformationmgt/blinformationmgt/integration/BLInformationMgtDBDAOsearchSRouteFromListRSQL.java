/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLInformationMgtDBDAOsearchSRouteFromListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLInformationMgtDBDAOsearchSRouteFromListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_0278 SRoute Combo Search
	  * </pre>
	  */
	public BLInformationMgtDBDAOsearchSRouteFromListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration").append("\n"); 
		query.append("FileName : BLInformationMgtDBDAOsearchSRouteFromListRSQL").append("\n"); 
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
		query.append("SELECT sconti_cd val," ).append("\n"); 
		query.append("       sconti_cd name" ).append("\n"); 
		query.append("  FROM mdm_subcontinent" ).append("\n"); 
		query.append(" WHERE delt_flg = 'N'" ).append("\n"); 
		query.append(" ORDER BY sconti_cd" ).append("\n"); 

	}
}