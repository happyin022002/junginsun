/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchSimDailyHireInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.15
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.11.15 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchSimDailyHireInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History------------------------------
	  * 2010.11.15 이행지 [CHM-201006375-01] [COA] Trunk IPC와 Ocean간 내부거래 신규 추가로 인해서
	  *                                                         기존로직에서 제외하도록 수정
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchSimDailyHireInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchSimDailyHireInfoRSQL").append("\n"); 
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
		query.append("SELECT STND_COST_NM, STND_COST_CD, SGRP_COST_CD " ).append("\n"); 
		query.append("	  FROM COA_STND_ACCT " ).append("\n"); 
		query.append("	 WHERE MGRP_COST_CD = 'OF' " ).append("\n"); 
		query.append("	   AND STND_COST_CD NOT IN ('54400000','92200000','92100000','54600000') " ).append("\n"); 
		query.append("  ORDER BY ACCT_DP_SEQ" ).append("\n"); 

	}
}