/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesReinfoManageDAOCustomsCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.21
*@LastModifier : 이창원
*@LastVersion : 1.0
* 2011.06.21 이창원
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesReinfoManageDAOCustomsCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO생성1
	  * </pre>
	  */
	public SalesReinfoManageDAOCustomsCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.integration").append("\n"); 
		query.append("FileName : SalesReinfoManageDAOCustomsCustomerRSQL").append("\n"); 
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
		query.append("SELECT  '' PRIMARY_SREP_CD," ).append("\n"); 
		query.append("'' CUSTOMER_CODE," ).append("\n"); 
		query.append("'' CUST_CD," ).append("\n"); 
		query.append("'' CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("'' LOC_CD," ).append("\n"); 
		query.append("'' PHN_NO," ).append("\n"); 
		query.append("'' INDIV_CORP_DIV_CD," ).append("\n"); 
		query.append("'' SREP_PRMRY_FLG," ).append("\n"); 
		query.append("'' SREP_CD," ).append("\n"); 
		query.append("'' OFC_CD," ).append("\n"); 
		query.append("'' CUST_CNT_CD," ).append("\n"); 
		query.append("'' CUST_SEQ," ).append("\n"); 
		query.append("'' OFC_CD," ).append("\n"); 
		query.append("'' SREP_NM," ).append("\n"); 
		query.append("'' USR_ID," ).append("\n"); 
		query.append("'' USER_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}