/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTerminalDepartureReportConditionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.27
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2011.01.27 박희동
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

public class TerminalDepartureReportDBDAOTerminalDepartureReportConditionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTerminalDepartureReportConditionVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTerminalDepartureReportConditionVORSQL").append("\n"); 
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
		query.append("    '' loc_cd" ).append("\n"); 
		query.append(",   '' yd_cd" ).append("\n"); 
		query.append(",   '' slan_cd" ).append("\n"); 
		query.append(",   '' from_date" ).append("\n"); 
		query.append(",   '' to_date" ).append("\n"); 
		query.append(",   '' opr_cd" ).append("\n"); 
		query.append(",   '' option_cd" ).append("\n"); 
		query.append(",   '' rhq" ).append("\n"); 
		query.append(",   '' vsl_cd" ).append("\n"); 
		query.append(",   '' manu_in_time" ).append("\n"); 
		query.append(",   '' dir_cd" ).append("\n"); 
		query.append(",   '' carr_cd" ).append("\n"); 
		query.append(",   '' tml_prod_rpt_rsn_cd" ).append("\n"); 
		query.append(",   '' group_by" ).append("\n"); 
		query.append(",   '' voy_no" ).append("\n"); 
		query.append(",   '' mishandlechk" ).append("\n"); 
		query.append(",   '' target_ports" ).append("\n"); 
		query.append(",   '' target_lanes" ).append("\n"); 
		query.append(",   '' CLPT_IND_SEQ" ).append("\n"); 
		query.append(",   '' page_no" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}