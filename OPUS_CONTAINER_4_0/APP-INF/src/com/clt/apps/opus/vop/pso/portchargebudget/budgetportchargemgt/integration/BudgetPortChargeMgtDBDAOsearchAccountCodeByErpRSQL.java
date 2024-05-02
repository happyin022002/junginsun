/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOsearchAccountCodeByErpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOsearchAccountCodeByErpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP Account Code Search
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOsearchAccountCodeByErpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration ").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOsearchAccountCodeByErpRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT M.ACCT_CD" ).append("\n"); 
		query.append("     , M.ACCT_ENG_NM" ).append("\n"); 
		query.append("  FROM GL_ESTM_IF_ERP G" ).append("\n"); 
		query.append("     , MDM_ACCOUNT M" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND G.SYS_SRC_ID = 'PSO'" ).append("\n"); 
		query.append("   AND G.EXE_YRMON = REPLACE(@[exe_yrmon], '-', '') " ).append("\n"); 
		query.append("#if( ${sdt} != '' )" ).append("\n"); 
		query.append("   AND SUBSTR(G.ACT_DT,1,6) BETWEEN REPLACE(@[sdt], '-', '') AND REPLACE(@[edt], '-', '') " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("   AND G.ACCT_CD = M.ACCT_CD" ).append("\n"); 
		query.append(" ORDER BY 1" ).append("\n"); 

	}
}