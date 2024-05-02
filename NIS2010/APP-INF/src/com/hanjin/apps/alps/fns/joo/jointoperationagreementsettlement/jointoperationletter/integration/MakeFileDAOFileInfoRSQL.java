/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MakeFileDAOFileInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.10.23 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeFileDAOFileInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MakeFileDAOFileInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.joocommon.common.integration").append("\n"); 
		query.append("FileName : MakeFileDAOFileInfoRSQL").append("\n"); 
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
		query.append("SELECT   ''JO_LTR_SEQ," ).append("\n"); 
		query.append("''FILE_SAV_ID," ).append("\n"); 
		query.append("''CRE_DT," ).append("\n"); 
		query.append("''CRE_USR_ID," ).append("\n"); 
		query.append("''USR_NM," ).append("\n"); 
		query.append("''FILE_NAME," ).append("\n"); 
		query.append("''EML_FILE_PATH_URL_CTNT" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}