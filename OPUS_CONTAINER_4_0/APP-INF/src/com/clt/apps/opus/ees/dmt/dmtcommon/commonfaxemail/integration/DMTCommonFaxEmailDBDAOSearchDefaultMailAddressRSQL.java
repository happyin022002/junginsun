/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCommonFaxEmailDBDAOSearchDefaultMailAddressRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonFaxEmailDBDAOSearchDefaultMailAddressRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Default Mail Address Search. 
	  * </pre>
	  */
	public DMTCommonFaxEmailDBDAOSearchDefaultMailAddressRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfaxemail.integration").append("\n"); 
		query.append("FileName : DMTCommonFaxEmailDBDAOSearchDefaultMailAddressRSQL").append("\n"); 
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
		query.append("SELECT 'shipinfobcc@na.nykline.com' AS DFT_EMAIL" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}