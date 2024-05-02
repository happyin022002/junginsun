/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Customer Seq 조회
	  * </pre>
	  */
	public USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.integration").append("\n"); 
		query.append("FileName : USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerNoRSQL").append("\n"); 
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
		query.append("SELECT	NVL(MAX(trsp_act_cust_no), 0) + 1 			trsp_act_cust_no" ).append("\n"); 
		query.append("FROM 		TRS_TRSP_USA_ACT_CUST" ).append("\n"); 

	}
}