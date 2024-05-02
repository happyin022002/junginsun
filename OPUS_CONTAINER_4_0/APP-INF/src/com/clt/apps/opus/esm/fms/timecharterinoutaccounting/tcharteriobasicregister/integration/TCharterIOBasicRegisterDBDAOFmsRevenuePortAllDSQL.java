/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOBasicRegisterDBDAOFmsRevenuePortAllDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.16 최우석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBasicRegisterDBDAOFmsRevenuePortAllDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Revenue Port Management Delete All
	  * </pre>
	  */
	public TCharterIOBasicRegisterDBDAOFmsRevenuePortAllDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBasicRegisterDBDAOFmsRevenuePortAllDSQL").append("\n"); 
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
		query.append("DELETE FROM FMS_BSE_PORT" ).append("\n"); 

	}
}