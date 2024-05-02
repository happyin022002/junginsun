/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHAuditTroAmanageDBDAOSqlNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.12.17 양봉준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CHAuditTroAmanageDBDAOSqlNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CHAuditTroAmanageDBDAO
	  * </pre>
	  */
	public CHAuditTroAmanageDBDAOSqlNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : CHAuditTroAmanageDBDAOSqlNameRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' fromsodate" ).append("\n"); 
		query.append(",'' somonth" ).append("\n"); 
		query.append(",'' bkgno" ).append("\n"); 
		query.append(",'' d_type" ).append("\n"); 
		query.append(",'' s_dtltype" ).append("\n"); 
		query.append(",'' blno" ).append("\n"); 
		query.append(",'' toinvdate" ).append("\n"); 
		query.append(",'' ctrl_ofc_cd" ).append("\n"); 
		query.append(",'' vvdno" ).append("\n"); 
		query.append(",'' tosodate" ).append("\n"); 
		query.append(",'' frominvdate" ).append("\n"); 
		query.append(",'' old_ofc_cd" ).append("\n"); 
		query.append(",'' s_type" ).append("\n"); 
		query.append(",'' ctrl_user_id" ).append("\n"); 
		query.append(",'' s_bnd" ).append("\n"); 
		query.append(",'' invmonth" ).append("\n"); 
		query.append(",'' sel_ofc_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}