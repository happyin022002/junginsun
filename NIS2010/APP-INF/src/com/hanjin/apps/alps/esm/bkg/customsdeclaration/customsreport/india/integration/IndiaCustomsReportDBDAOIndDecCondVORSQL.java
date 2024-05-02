/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IndiaCustomsReportDBDAOIndDecCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaCustomsReportDBDAOIndDecCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IndDecCondVO 생성위해 사용
	  * </pre>
	  */
	public IndiaCustomsReportDBDAOIndDecCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.integration").append("\n"); 
		query.append("FileName : IndiaCustomsReportDBDAOIndDecCondVORSQL").append("\n"); 
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
		query.append("SELECT   ''FROM_DT" ).append("\n"); 
		query.append("		,''TO_DT" ).append("\n"); 
		query.append("		,''EXPORT_VVD" ).append("\n"); 
		query.append("		,''POL" ).append("\n"); 
		query.append("		,''TERMINAL_VAL" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}