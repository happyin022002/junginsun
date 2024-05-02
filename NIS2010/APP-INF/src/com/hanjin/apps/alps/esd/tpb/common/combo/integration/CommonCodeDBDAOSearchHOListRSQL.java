/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CommonCodeDBDAOSearchHOListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchHOListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchHOList
	  * </pre>
	  */
	public CommonCodeDBDAOSearchHOListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchHOListRSQL").append("\n"); 
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
		query.append("SELECT   OFC_CD" ).append("\n"); 
		query.append("       , OFC_CD AS OFC_CD2" ).append("\n"); 
		query.append("FROM     MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      OFC_CD IN (SELECT ATTR_CTNT1 AS OFC_CD FROM TPB_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'HO_OFC_CD')" ).append("\n"); 

	}
}