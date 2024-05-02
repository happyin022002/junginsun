/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOHPInPutVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.31
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.08.31 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOHPInPutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOHPInPutVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOHPInPutVORSQL").append("\n"); 
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
		query.append("SELECT '' OFC_CD," ).append("\n"); 
		query.append("	   '' VVD," ).append("\n"); 
		query.append("	   '' BL_SRC_NO," ).append("\n"); 
		query.append("		'' RETR_OPT," ).append("\n"); 
		query.append("'' FM_DT," ).append("\n"); 
		query.append("'' TO_DT," ).append("\n"); 
		query.append("'' ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("'' ACT_CUST_SEQ," ).append("\n"); 
		query.append("'' SENT_STAT," ).append("\n"); 
		query.append("'' CHANGE_TYPE," ).append("\n"); 
		query.append("'' INV_NO" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}