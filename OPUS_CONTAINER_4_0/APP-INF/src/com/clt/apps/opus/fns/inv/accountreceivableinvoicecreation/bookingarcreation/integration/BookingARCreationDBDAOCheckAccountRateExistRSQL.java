/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationDBDAOCheckAccountRateExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.01 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOCheckAccountRateExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [] BookingARCreationDBDAO::checkAccountRateExist ( effDt ) return int
	  * </pre>
	  */
	public BookingARCreationDBDAOCheckAccountRateExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOCheckAccountRateExistRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("count(*) CNT" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT" ).append("\n"); 
		query.append("WHERE	ACCT_XCH_RT_YRMON = substr(REPLACE(@[eff_dt],'-',''),0,6)" ).append("\n"); 

	}
}