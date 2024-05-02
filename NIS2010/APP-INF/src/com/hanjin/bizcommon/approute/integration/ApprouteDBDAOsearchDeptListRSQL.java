/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ApprouteDBDAOsearchDeptListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.11
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.10.11 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approute.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprouteDBDAOsearchDeptListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Department를 조회
	  * </pre>
	  */
	public ApprouteDBDAOsearchDeptListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approute.integration").append("\n"); 
		query.append("FileName : ApprouteDBDAOsearchDeptListRSQL").append("\n"); 
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
		query.append("SELECT LEVEL, OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("START WITH OFC_CD='SELHO'" ).append("\n"); 
		query.append("ORDER SIBLINGS BY OFC_CD" ).append("\n"); 

	}
}