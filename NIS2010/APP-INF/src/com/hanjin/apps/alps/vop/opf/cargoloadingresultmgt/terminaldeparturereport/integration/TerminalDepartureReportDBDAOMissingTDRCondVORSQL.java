/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOMissingTDRCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.04
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2011.01.04 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOMissingTDRCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.11.26 박희동 최초작성
	  * Missing TDR Inquiry 화면 조회조건 vo생성용 Query   
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOMissingTDRCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOMissingTDRCondVORSQL").append("\n"); 
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
		query.append("SELECT '' AS FR_DT," ).append("\n"); 
		query.append("       '' AS TO_DT," ).append("\n"); 
		query.append("       '' AS RHQ_OFC_CD," ).append("\n"); 
		query.append("       '' AS PORT_CD," ).append("\n"); 
		query.append("       '' AS SLAN_CD," ).append("\n"); 
		query.append("       '' AS CRR_CD," ).append("\n"); 
		query.append("       '' AS TDR_FLG," ).append("\n"); 
		query.append("       '' AS SVC_TP_CD," ).append("\n"); 
		query.append("       '' AS EX_TPR_FLG" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}