/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqBreakbulkDBDAOmakePriScqBbRoutCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.23
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.09.23 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqBreakbulkDBDAOmakePriScqBbRoutCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriScqBbRout and PriScqBbRoutCost
	  * </pre>
	  */
	public ScqBreakbulkDBDAOmakePriScqBbRoutCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration").append("\n"); 
		query.append("FileName : ScqBreakbulkDBDAOmakePriScqBbRoutCostRSQL").append("\n"); 
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
		query.append(" '' SCQ_RQST_NO" ).append("\n"); 
		query.append(",'' SCQ_VER_NO" ).append("\n"); 
		query.append(",'' ROUT_SEQ" ).append("\n"); 
		query.append(",'' ROUT_SEQ_VER_NO" ).append("\n"); 
		query.append(",'' ROUT_COST_SEQ" ).append("\n"); 
		query.append(",'' BB_CGO_TP_SEQ" ).append("\n"); 
		query.append(",'' COST_AMT" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append(",'' ROUT_TP_CD" ).append("\n"); 
		query.append(",'' ROUT_RMK" ).append("\n"); 
		query.append(",'' CFM_FLG" ).append("\n"); 
		query.append(",'' BB_CGO_DESC" ).append("\n"); 
		query.append(",'' LOCL_CURR_CD" ).append("\n"); 
		query.append(",'' LOCL_CURR_AMT" ).append("\n"); 
		query.append(",'' EX_RATE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}