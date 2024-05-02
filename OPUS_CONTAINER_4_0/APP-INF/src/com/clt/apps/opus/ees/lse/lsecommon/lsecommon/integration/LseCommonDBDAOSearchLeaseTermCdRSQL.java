/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LseCommonDBDAOSearchLeaseTermCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.lsecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LseCommonDBDAOSearchLeaseTermCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LSE_RCV_CHG_TP_CD테이블에서 Lease Term Code를 조회한다.
	  * </pre>
	  */
	public LseCommonDBDAOSearchLeaseTermCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.lsecommon.lsecommon.integration").append("\n"); 
		query.append("FileName : LseCommonDBDAOSearchLeaseTermCdRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT LSTM_CD" ).append("\n"); 
		query.append("  FROM LSE_RNTL_COST_ACCT_ORD" ).append("\n"); 
		query.append(" ORDER BY LSTM_CD  " ).append("\n"); 

	}
}