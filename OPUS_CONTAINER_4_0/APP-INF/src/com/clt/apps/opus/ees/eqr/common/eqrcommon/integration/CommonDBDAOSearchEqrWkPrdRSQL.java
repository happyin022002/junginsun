/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CommonDBDAOSearchEqrWkPrdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchEqrWkPrdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_EQR_0008 조회 쿼리
	  * </pre>
	  */
	public CommonDBDAOSearchEqrWkPrdRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchEqrWkPrdRSQL").append("\n"); 
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
		query.append("SELECT PLN_YR" ).append("\n"); 
		query.append("      ,PLN_WK" ).append("\n"); 
		query.append("      ,PLN_MON" ).append("\n"); 
		query.append("      ,WK_ST_DT" ).append("\n"); 
		query.append("      ,WK_END_DT" ).append("\n"); 
		query.append("  FROM EQR_WK_PRD" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${pln_yr} != '') " ).append("\n"); 
		query.append("AND PLN_YR = @[pln_yr] -- 변수처리, 4번 항목 조건 값 필수" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY PLN_YR, PLN_WK" ).append("\n"); 

	}
}