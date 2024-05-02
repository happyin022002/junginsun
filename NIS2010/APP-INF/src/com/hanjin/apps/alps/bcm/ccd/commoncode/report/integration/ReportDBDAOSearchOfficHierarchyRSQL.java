/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : ReportDBDAOSearchOfficHierarchyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.report.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReportDBDAOSearchOfficHierarchyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO 생성
	  * </pre>
	  */
	public ReportDBDAOSearchOfficHierarchyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.report.integration").append("\n"); 
		query.append("FileName : ReportDBDAOSearchOfficHierarchyRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("'' ofc_knd_cd" ).append("\n"); 
		query.append(",'' ofc_cd" ).append("\n"); 
		query.append(",'' ofc_lvl" ).append("\n"); 
		query.append(",'' ho" ).append("\n"); 
		query.append(",'' rhq" ).append("\n"); 
		query.append(",'' bb_aa" ).append("\n"); 
		query.append(",'' sub_bb" ).append("\n"); 
		query.append(",'' ofc_eng_nm" ).append("\n"); 
		query.append(",'' status" ).append("\n"); 
		query.append(",'' ofc_kind_cd" ).append("\n"); 
		query.append(",'' ofc_code_cd" ).append("\n"); 
		query.append(",'' status_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}