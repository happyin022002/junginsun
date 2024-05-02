/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpensePlanDBDAOExpenseVerSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.30 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExpensePlanDBDAOExpenseVerSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 년도별 최대 버전번호를 조회한다.
	  * </pre>
	  */
	public ExpensePlanDBDAOExpenseVerSeqRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT  NVL(MAX(VER_SEQ),0) +1 AS VER_SEQ" ).append("\n"); 
		query.append("FROM    LSE_EQ_EXPN_PLN" ).append("\n"); 
		query.append("WHERE   PLN_YR = @[pln_yr]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.integration").append("\n"); 
		query.append("FileName : ExpensePlanDBDAOExpenseVerSeqRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}