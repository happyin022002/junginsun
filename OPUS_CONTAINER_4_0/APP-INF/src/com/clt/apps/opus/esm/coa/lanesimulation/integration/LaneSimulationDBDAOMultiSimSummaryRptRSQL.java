/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOMultiSimSummaryRptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.11.18 윤진영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOMultiSimSummaryRptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 써머리 레포트 저장용 VO
	  * </pre>
	  */
	public LaneSimulationDBDAOMultiSimSummaryRptRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOMultiSimSummaryRptRSQL").append("\n"); 
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
		query.append("'' LDF_RTO" ).append("\n"); 
		query.append(",'' GRS_RPB_REV" ).append("\n"); 
		query.append(",'' SIM_DT" ).append("\n"); 
		query.append(",'' SIM_NO" ).append("\n"); 
		query.append(",'' SECT_NO" ).append("\n"); 
		query.append(",'' SIM_RPT_NO" ).append("\n"); 
		query.append(",'' BNK_COST_AMT" ).append("\n"); 
		query.append(",'' SIM_RMK" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",''  UPD_USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}