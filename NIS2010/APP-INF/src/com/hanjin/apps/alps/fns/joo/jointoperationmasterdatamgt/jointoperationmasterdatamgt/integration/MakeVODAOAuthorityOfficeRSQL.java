/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MakeVODAOAuthorityOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.04.29 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVODAOAuthorityOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MakeVODAOAuthorityOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : MakeVODAOAuthorityOfficeRSQL").append("\n"); 
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
		query.append("'' JO_CRR_CD," ).append("\n"); 
		query.append("'' TRD_CD," ).append("\n"); 
		query.append("'' RLANE_CD," ).append("\n"); 
		query.append("'' VNDR_SEQ," ).append("\n"); 
		query.append("'' CRM_ROW_ID," ).append("\n"); 
		query.append("'' VNDR_LOCL_LANG_NM," ).append("\n"); 
		query.append("'' AUTH_OFC_CD," ).append("\n"); 
		query.append("'' JO_CRR_AUTH_CD," ).append("\n"); 
		query.append("'' CRE_DT," ).append("\n"); 
		query.append("'' CRE_USR_ID," ).append("\n"); 
		query.append("'' UPD_DT," ).append("\n"); 
		query.append("'' UPD_USR_ID," ).append("\n"); 
		query.append("'' DELT_FLG," ).append("\n"); 
		query.append("'' VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("'' AUTH_DELCHECK_YN" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}