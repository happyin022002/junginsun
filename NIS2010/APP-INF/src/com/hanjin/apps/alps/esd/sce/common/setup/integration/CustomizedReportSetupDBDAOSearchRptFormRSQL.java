/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomizedReportSetupDBDAOSearchRptFormRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.setup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomizedReportSetupDBDAOSearchRptFormRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Master Column 조회
	  * </pre>
	  */
	public CustomizedReportSetupDBDAOSearchRptFormRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.common.setup.integration").append("\n"); 
		query.append("FileName : CustomizedReportSetupDBDAOSearchRptFormRSQL").append("\n"); 
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
		query.append("SELECT RPT_COL_DESC COLDESC1" ).append("\n"); 
		query.append("FROM SCE_USA_INLND_OP_RPT_COL" ).append("\n"); 

	}
}