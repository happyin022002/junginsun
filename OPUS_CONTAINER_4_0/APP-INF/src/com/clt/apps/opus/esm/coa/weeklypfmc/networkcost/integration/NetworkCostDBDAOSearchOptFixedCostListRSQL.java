/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOSearchOptFixedCostListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchOptFixedCostListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History-------------------------------
	  * 2010.11.16 이행지 [CHM-201006375-01] Trunk IPC와 Ocean간 내부거래 신규 추가로 인한 계정 제외
	  * </pre>
	  */
	public NetworkCostDBDAOSearchOptFixedCostListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchOptFixedCostListRSQL").append("\n"); 
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
		query.append("     STND_COST_NM" ).append("\n"); 
		query.append("    ,STND_COST_CD" ).append("\n"); 
		query.append("   FROM COA_STND_ACCT" ).append("\n"); 
		query.append("  WHERE MGRP_COST_CD = 'OF'" ).append("\n"); 
		query.append("    --SJH.20141222.ADD : 54600002, 20150731.ADD : 54400010" ).append("\n"); 
		query.append("    AND STND_COST_CD NOT IN ('75000000','54350000','54400000','92200000','92100000','54600000','54600002','54400010')" ).append("\n"); 
		query.append(" ORDER BY ACCT_DP_SEQ" ).append("\n"); 

	}
}