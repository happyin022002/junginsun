/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpPerformanceComparisonDBDAOcomparisonCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.03
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2016.06.03 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpPerformanceComparisonDBDAOcomparisonCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회조건
	  * </pre>
	  */
	public SpPerformanceComparisonDBDAOcomparisonCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.integration").append("\n"); 
		query.append("FileName : SpPerformanceComparisonDBDAOcomparisonCondVORSQL").append("\n"); 
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
		query.append("SELECT '' HID_FROM_DATE" ).append("\n"); 
		query.append("     , '' HID_TO_DATE" ).append("\n"); 
		query.append("     , '' HID_FROM_NODE" ).append("\n"); 
		query.append("     , '' HID_VIA_NODE" ).append("\n"); 
		query.append("     , '' HID_TO_NODE" ).append("\n"); 
		query.append("     , '' HID_DOOR_NODE" ).append("\n"); 
		query.append("     , '' SEL_INPUT_OFFICE" ).append("\n"); 
		query.append("     , '' SEL_SOTYPE" ).append("\n"); 
		query.append("     , '' SEL_COSTMODE" ).append("\n"); 
		query.append("     , '' SEL_TRANSMODE" ).append("\n"); 
		query.append("     , '' SEL_BOUND" ).append("\n"); 
		query.append("     , '' SEL_BKGNO" ).append("\n"); 
		query.append("     , '' SEL_CNTRNO" ).append("\n"); 
		query.append("     , '' SEL_SONO" ).append("\n"); 
		query.append("     , '' SEL_WONO" ).append("\n"); 
		query.append("     , '' SEL_SPOPTION" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}