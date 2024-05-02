/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOCheckAverageCostCreateBatchStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOCheckAverageCostCreateBatchStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckAverageCostCreateBatchStatus
	  * </pre>
	  */
	public CommonDBDAOCheckAverageCostCreateBatchStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_target_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOCheckAverageCostCreateBatchStatusRSQL").append("\n"); 
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
		query.append("SELECT COST_WK,COST_CRE_STS_CD" ).append("\n"); 
		query.append("  FROM COA_UT_COST_CRE_STS" ).append("\n"); 
		query.append(" WHERE 1=1   " ).append("\n"); 
		query.append("   AND COST_YRMON = REPLACE(@[f_target_yrmon],'-','')" ).append("\n"); 
		query.append("   AND COST_WK = ( SELECT COST_WK" ).append("\n"); 
		query.append("                     FROM COA_WK_PRD" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                      AND COST_YR = SUBSTR(@[f_target_yrmon],0,4)" ).append("\n"); 
		query.append("                      AND TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN SLS_FM_DT AND SLS_TO_DT )" ).append("\n"); 
		query.append("   AND CM_UC_CD = DECODE(@[f_cost_type],'acm_oth','ACMC','nod_full','NFCC','nod_empty','NMCC','nod_incen','NICC','trans_full','TFCC','trans_empty','TMCC','trans_incen','TICC','OTHC')" ).append("\n"); 

	}
}