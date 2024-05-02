/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LseCommonDBDAOSearchChargeTpCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.lsecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LseCommonDBDAOSearchChargeTpCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LSE_RCV_CHG_TP_CD테이블에서 Charge Type Code 를 조회한다.
	  * </pre>
	  */
	public LseCommonDBDAOSearchChargeTpCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.lsecommon.lsecommon.integration ").append("\n"); 
		query.append("FileName : LseCommonDBDAOSearchChargeTpCdRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT LSE_RCV_CHG_TP_CD" ).append("\n"); 
		query.append("  FROM LSE_RNTL_COST_ACCT_ORD" ).append("\n"); 
		query.append(" ORDER BY LSE_RCV_CHG_TP_CD" ).append("\n"); 

	}
}