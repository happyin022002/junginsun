/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseTermDBDAOLeaseTermComboItemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.07 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.leaseterm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.4
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
		query.append("SELECT LSTM_CD," ).append("\n"); 
		query.append("LSTM_NM" ).append("\n"); 
		query.append("FROM MST_LSE_TERM" ).append("\n"); 
		query.append("ORDER BY DP_SEQ" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.lsecommon.leaseterm.integration").append("\n"); 
		query.append("FileName : LeaseTermDBDAOLeaseTermComboItemRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}