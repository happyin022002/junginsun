/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOsearchContinentByErpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOsearchContinentByErpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP Continent Search.
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOsearchContinentByErpRSQL(){
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
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOsearchContinentByErpRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT M.CONTI_CD " ).append("\n"); 
		query.append("     , C.CONTI_NM AS CONTI_NM" ).append("\n"); 
		query.append("  FROM GL_ESTM_IF_ERP G" ).append("\n"); 
		query.append("     , MDM_LOCATION M" ).append("\n"); 
		query.append("     , MDM_CONTINENT C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND G.SYS_SRC_ID = 'PSO' " ).append("\n"); 
		query.append("   AND G.EXE_YRMON = REPLACE(@[exe_yrmon], '-', '') " ).append("\n"); 
		query.append("#if( ${sdt} != '' )" ).append("\n"); 
		query.append("   AND SUBSTR(G.ACT_DT,1,6) BETWEEN REPLACE(@[sdt], '-', '') AND REPLACE(@[edt], '-', '') " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if( ${acct_cd} != '' )" ).append("\n"); 
		query.append("   AND G.ACCT_CD = @[acct_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if( ${cost_cd} != '' )" ).append("\n"); 
		query.append("   AND G.ACCT_DTL_CD = @[cost_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${match_flag} == 'match' )" ).append("\n"); 
		query.append("   AND G.ACCL_AMT = 0 /*-- Matched*/" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if( ${match_flag} == 'unmatch' )" ).append("\n"); 
		query.append("  AND G.ACCL_AMT <> 0 /*-- UNMatched*/" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("   AND SUBSTR(G.COST_ACT_PLC_CD, 1,5) = M.LOC_CD" ).append("\n"); 
		query.append("   AND M.CONTI_CD = C.CONTI_CD" ).append("\n"); 
		query.append("   AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append(" ORDER BY 1" ).append("\n"); 

	}
}