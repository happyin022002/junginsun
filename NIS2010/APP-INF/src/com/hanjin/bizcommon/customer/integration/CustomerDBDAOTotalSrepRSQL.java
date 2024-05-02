/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustomerDBDAOTotalSrepRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.customer.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;
/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */
public class CustomerDBDAOTotalSrepRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 총 카운트 조회
	  * </pre>
	  */
	public CustomerDBDAOTotalSrepRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.customer.integration").append("\n"); 
		query.append("FileName : CustomerDBDAOTotalSrepRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM MDM_SLS_REP" ).append("\n"); 

	}
}