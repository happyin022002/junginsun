/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOexecuteTariffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.06.18 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOexecuteTariffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * executeTariff
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOexecuteTariffRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
	}
	/**
	 * <pre>
	 * executeTariff
	 * </pre>
	 */
	public GeneralInvoiceAuditDBDAOexecuteTariffRSQL(String sql){
		setQuery(sql);
		
		params = new HashMap<String,String[]>();
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}
	/*SQL을 set한다. */
	public void setQuery(String sql){
		query.append(sql);
	}
	
	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOexecuteTariffRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}