/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchARRhqListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOsearchARRhqListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR RHQ List
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchARRhqListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOsearchARRhqListRSQL").append("\n"); 
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
		query.append("SELECT '' RHQ_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT A.AR_HD_QTR_OFC_CD RHQ_CD " ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A " ).append("\n"); 
		query.append("WHERE EXISTS" ).append("\n"); 
		query.append("(SELECT * FROM MDM_ORGANIZATION B" ).append("\n"); 
		query.append("         WHERE A.OFC_CD = B.AR_HD_QTR_OFC_CD)" ).append("\n"); 

	}
}