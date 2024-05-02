/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AverageRPBDBDAOCheckAverageRPBCreateBatchStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.averagerpb.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AverageRPBDBDAOCheckAverageRPBCreateBatchStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckAverageRPBCreateBatchStatus
	  * 
	  * 20150108. 현재시점에서 과거내용을 수정할려고 하는경우 COST_WK로 인해
	  * UPDATE가 안됨. 하위는 변경내역
	  * -조건절에서 COST_WK 부분 삭제
	  * </pre>
	  */
	public AverageRPBDBDAOCheckAverageRPBCreateBatchStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_target_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.averagerpb.integration").append("\n"); 
		query.append("FileName : AverageRPBDBDAOCheckAverageRPBCreateBatchStatusRSQL").append("\n"); 
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
		query.append("   AND CM_UC_CD = 'RPBC'" ).append("\n"); 

	}
}