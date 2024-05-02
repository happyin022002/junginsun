/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchMnrQexeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 박명신	
*@LastVersion : 1.0
* 2009.10.28 박명신	
* 1.0 Creation	
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 박명신
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchMnrQexeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyMnrQexeData
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchMnrQexeDataRSQL(){
	}
	
	public GeneralCodeSearchMgtDBDAOsearchMnrQexeDataRSQL(String baseQuery){
		setQuery(baseQuery); 	 
		query.append("\n/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchMnrQexeDataRSQL").append("\n"); 
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
	public void setQuery(String baseQuery){
		query.append(baseQuery);  
	}
}