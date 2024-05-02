/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LeaseTermDBDAOLeaseTermComboItemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.leaseterm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseTermDBDAOLeaseTermComboItemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Term Search
	  * </pre>
	  */
	public LeaseTermDBDAOLeaseTermComboItemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.lsecommon.leaseterm.integration").append("\n"); 
		query.append("FileName : LeaseTermDBDAOLeaseTermComboItemRSQL").append("\n"); 
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
		query.append("SELECT LSTM_CD, " ).append("\n"); 
		query.append("       LSTM_NM" ).append("\n"); 
		query.append("  FROM MST_LSE_TERM" ).append("\n"); 
		query.append(" ORDER BY DP_SEQ" ).append("\n"); 

	}
}