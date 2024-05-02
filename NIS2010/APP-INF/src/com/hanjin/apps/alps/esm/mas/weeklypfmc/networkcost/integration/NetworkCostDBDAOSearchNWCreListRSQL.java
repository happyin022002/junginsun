/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkCostDBDAOSearchNWCreListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchNWCreListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchNWCreList SELECT
	  * </pre>
	  */
	public NetworkCostDBDAOSearchNWCreListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchNWCreListRSQL").append("\n"); 
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
		query.append("     STND_COST_CD                                       AS STND_COST_CD" ).append("\n"); 
		query.append("    ,STND_COST_NM                                       AS STND_COST_NM" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '53101000' THEN ''" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '53102000' THEN ''" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '53200000' THEN ''" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54100000' THEN 'OWN'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54250000' THEN 'OWN'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54300000' THEN 'OWN'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54200000' THEN 'OWN'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54150000' THEN 'OWN'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54450000' THEN 'OWN'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54180000' THEN 'OWN'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54550000' THEN 'OWN'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54350000' THEN 'CHT'" ).append("\n"); 
		query.append("           ELSE ''" ).append("\n"); 
		query.append("      END)                                              AS VSL_OSHP_CD" ).append("\n"); 
		query.append("    ,(CASE WHEN STND_COST_CD = '53101000' THEN 'SML'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '53102000' THEN 'SML'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '53200000' THEN 'SML'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54100000' THEN 'SML'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54250000' THEN 'SML'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54300000' THEN 'SML'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54200000' THEN 'SML'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54150000' THEN 'SML'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54450000' THEN 'SML'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54180000' THEN 'SML'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54550000' THEN 'SML'" ).append("\n"); 
		query.append("           WHEN STND_COST_CD = '54350000' THEN 'SML'" ).append("\n"); 
		query.append("           ELSE ''" ).append("\n"); 
		query.append("      END)                                              AS VOP_CD" ).append("\n"); 
		query.append("    ,'R'                                                AS CRE_STS_CD" ).append("\n"); 
		query.append("    ,'Y'                                                AS CRE_SLCT_FLG" ).append("\n"); 
		query.append("  FROM MAS_STND_ACCT_V" ).append("\n"); 
		query.append(" WHERE STND_COST_TP_CD = 'O'" ).append("\n"); 
		query.append("   AND MAS_COST_SRC_PRT_CD IN ('PA','CO')" ).append("\n"); 
		query.append("   AND MGRP_COST_CD in ('OV','OF')" ).append("\n"); 
		query.append("   AND STND_COST_CD NOT IN ('54400000','65000000')" ).append("\n"); 
		query.append(" ORDER BY STND_COST_CD" ).append("\n"); 

	}
}