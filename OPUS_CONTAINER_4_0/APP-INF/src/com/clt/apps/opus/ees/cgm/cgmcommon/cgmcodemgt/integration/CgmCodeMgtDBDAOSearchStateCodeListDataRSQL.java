/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchStateCodeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchStateCodeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkLocation
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchStateCodeListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchStateCodeListDataRSQL").append("\n"); 
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
		query.append("SELECT 	STE_CD AS CODE1," ).append("\n"); 
		query.append("		STE_NM AS DESC1" ).append("\n"); 
		query.append("FROM  MDM_STATE" ).append("\n"); 
		query.append("WHERE CNT_CD IN ('US', 'CA')" ).append("\n"); 
		query.append("  AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY STE_NM" ).append("\n"); 

	}
}