/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GenExpenseDBDAORemoveGeneralExpense4DSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.genexpense.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GenExpenseDBDAORemoveGeneralExpense4DSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * @SJH.20141229.ADD
	  * </pre>
	  */
	public GenExpenseDBDAORemoveGeneralExpense4DSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_capa4",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.genexpense.integration").append("\n"); 
		query.append("FileName : GenExpenseDBDAORemoveGeneralExpense4DSQL").append("\n"); 
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
		query.append("DELETE " ).append("\n"); 
		query.append("  FROM COA_OWN_VSL_DLY_HIR" ).append("\n"); 
		query.append("WHERE COST_YRMON     = @[cost_yrmon4]  " ).append("\n"); 
		query.append("  AND VSL_CD         = 'XXXX'" ).append("\n"); 
		query.append("  AND VSL_CLSS_CAPA  = @[vsl_clss_capa4]" ).append("\n"); 
		query.append("  AND STND_COST_CD   = '75000000' " ).append("\n"); 

	}
}