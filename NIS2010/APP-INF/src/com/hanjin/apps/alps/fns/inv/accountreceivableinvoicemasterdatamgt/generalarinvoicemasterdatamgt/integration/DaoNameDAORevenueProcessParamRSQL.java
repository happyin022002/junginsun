/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DaoNameDAORevenueProcessParamRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.12
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.05.12 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAORevenueProcessParamRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * paramVO
	  * </pre>
	  */
	public DaoNameDAORevenueProcessParamRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : DaoNameDAORevenueProcessParamRSQL").append("\n"); 
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
		query.append("select '' option_value" ).append("\n"); 
		query.append(", '' yrmon_fm" ).append("\n"); 
		query.append(", '' yrmon_to" ).append("\n"); 
		query.append(", '' del_cd" ).append("\n"); 
		query.append(", '' s_vvd_cd" ).append("\n"); 
		query.append(", '' s_slan_cd" ).append("\n"); 
		query.append(", '' s_rlane_cd" ).append("\n"); 
		query.append(", '' s_estm_bc_div_cd" ).append("\n"); 
		query.append(", '' s_estm_vvd_tp_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}