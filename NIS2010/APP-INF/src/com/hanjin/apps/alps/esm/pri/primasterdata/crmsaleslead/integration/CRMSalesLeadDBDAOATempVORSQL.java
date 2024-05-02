/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CRMSalesLeadDBDAOATempVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.14 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CRMSalesLeadDBDAOATempVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO생성을 위한 쿼리
	  * </pre>
	  */
	public CRMSalesLeadDBDAOATempVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.integration").append("\n"); 
		query.append("FileName : CRMSalesLeadDBDAOATempVORSQL").append("\n"); 
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
		query.append("SELECT '' SLS_LD_STS_CD" ).append("\n"); 
		query.append(",'' SLS_LD_NO_UP" ).append("\n"); 
		query.append(",'' SLS_LD_NO" ).append("\n"); 
		query.append(",'' PROP_NO" ).append("\n"); 
		query.append(",'' AMDT_SEQ" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' PROP_STS_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("/* CRMSalesLeadDBDAOPriCrmSlsLdVOUSQL 에서 사용 CstPriCrmSlsLdVO */" ).append("\n"); 

	}
}