/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOBasicRegisterDBDAOFmsEmailAddressListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBasicRegisterDBDAOFmsEmailAddressListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * E-mail List Select
	  * </pre>
	  */
	public TCharterIOBasicRegisterDBDAOFmsEmailAddressListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBasicRegisterDBDAOFmsEmailAddressListRSQL").append("\n"); 
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
		query.append("SELECT EML_SEQ," ).append("\n"); 
		query.append("CNTC_PSON_NM," ).append("\n"); 
		query.append("CNTC_PSON_EML" ).append("\n"); 
		query.append("FROM FMS_SCR_EML_ADDR" ).append("\n"); 
		query.append("ORDER BY EML_SEQ" ).append("\n"); 

	}
}