/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpenseSummaryByOfficeDBDAOSearchHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.09.30 손은주(TRS)
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.expensesummary.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Eun ju Son(TRS)
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpenseSummaryByOfficeDBDAOSearchHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExpenseSummaryByOffice 조회조건
	  * </pre>
	  */
	public ExpenseSummaryByOfficeDBDAOSearchHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.expensesummary.integration").append("\n"); 
		query.append("FileName : ExpenseSummaryByOfficeDBDAOSearchHeaderRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("''	hid_period" ).append("\n"); 
		query.append(", ''	hid_from_date" ).append("\n"); 
		query.append(", ''	hid_to_date" ).append("\n"); 
		query.append(", ''	radio_office" ).append("\n"); 
		query.append(", ''	input_office" ).append("\n"); 
		query.append(", ''	sel_costmode" ).append("\n"); 
		query.append(", ''	sel_transmode" ).append("\n"); 
		query.append(", ''	sel_sotype" ).append("\n"); 
		query.append(", ''	sel_bkgterm" ).append("\n"); 
		query.append(", ''	sp_tp" ).append("\n"); 
		query.append(", ''	node_div" ).append("\n"); 
		query.append(", ''	hid_from_node" ).append("\n"); 
		query.append(", ''	hid_via_node" ).append("\n"); 
		query.append(", ''	hid_to_node" ).append("\n"); 
		query.append(", ''	hid_door_node" ).append("\n"); 
		query.append(", ''	combo_svc_provider_chld" ).append("\n"); 
		query.append(", ''	combo_svc_provider_prnt" ).append("\n"); 
		query.append(", ''	chk_prnt_provider" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}