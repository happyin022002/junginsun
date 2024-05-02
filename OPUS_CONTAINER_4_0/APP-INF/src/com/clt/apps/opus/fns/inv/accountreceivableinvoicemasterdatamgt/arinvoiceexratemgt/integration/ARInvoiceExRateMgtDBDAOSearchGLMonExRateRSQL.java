/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOSearchGLMonExRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.10.29 박정진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOSearchGLMonExRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GL_MON_XCH_RT 테이블에서 조회조건으로 select 한다.
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOSearchGLMonExRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOSearchGLMonExRateRSQL").append("\n"); 
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
		query.append("SELECT ACCT_XCH_RT_YRMON," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE ACCT_XCH_RT_YRMON BETWEEN @[from_yrmon] AND @[to_yrmon]" ).append("\n"); 
		query.append("#if ( ${curr_cd} != '')" ).append("\n"); 
		query.append("AND CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ACCT_XCH_RT_LVL = 1" ).append("\n"); 

	}
}