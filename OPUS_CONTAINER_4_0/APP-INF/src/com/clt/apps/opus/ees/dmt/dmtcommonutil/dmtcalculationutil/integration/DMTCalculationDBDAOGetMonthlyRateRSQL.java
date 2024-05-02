/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DMTCalculationDBDAOGetMonthlyRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOGetMonthlyRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetMonthlyRate
	  * </pre>
	  */
	public DMTCalculationDBDAOGetMonthlyRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cur_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOGetMonthlyRateRSQL").append("\n"); 
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
		query.append("SELECT	USD_LOCL_XCH_RT	acct_rate					" ).append("\n"); 
		query.append("  FROM	GL_MON_XCH_RT" ).append("\n"); 
		query.append(" WHERE	ACCT_XCH_RT_YRMON		=	TO_CHAR(SYSDATE,'YYYYMM')" ).append("\n"); 
		query.append("   AND	ACCT_XCH_RT_LVL			=	'1'" ).append("\n"); 
		query.append("   AND	CURR_CD					=	@[cur_cd]" ).append("\n"); 

	}
}