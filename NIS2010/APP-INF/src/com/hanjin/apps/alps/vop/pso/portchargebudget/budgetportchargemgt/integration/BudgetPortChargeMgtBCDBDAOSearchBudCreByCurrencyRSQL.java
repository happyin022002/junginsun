/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BudgetPortChargeMgtBCDBDAOSearchBudCreByCurrencyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.20
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2012.08.20 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtBCDBDAOSearchBudCreByCurrencyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * History
	  * 2012.08.20 이혜민  CHM-201219078-01 사업계획 - 시나리오 연도 추가
	  * </pre>
	  */
	public BudgetPortChargeMgtBCDBDAOSearchBudCreByCurrencyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtBCDBDAOSearchBudCreByCurrencyRSQL").append("\n"); 
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
		query.append("SELECT A.BUD_SCNR_NO  SCNR_NO" ).append("\n"); 
		query.append(",A.LOCL_CURR_CD LOCL_CURR_CD" ).append("\n"); 
		query.append(",A.USD_XCH_RT   USD_XCH_RT" ).append("\n"); 
		query.append("FROM   PSO_BUD_XCH_RT A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.BUD_SCNR_NO IN (SELECT BUD_SCNR_NO" ).append("\n"); 
		query.append("FROM   PSO_BUD_TGT_VVD" ).append("\n"); 
		query.append("WHERE  BUD_YRMON BETWEEN @[start_dt] AND @[end_dt]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${scr_no} != '')" ).append("\n"); 
		query.append("AND    A.BUD_SCNR_NO = @[scr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.BUD_SCNR_NO, A.LOCL_CURR_CD" ).append("\n"); 

	}
}