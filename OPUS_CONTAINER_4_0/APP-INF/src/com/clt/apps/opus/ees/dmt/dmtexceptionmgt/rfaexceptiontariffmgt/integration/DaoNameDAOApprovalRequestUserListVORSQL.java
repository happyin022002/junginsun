/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOApprovalRequestUserListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.14 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOApprovalRequestUserListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ApprovalRequestUserListVO
	  * </pre>
	  */
	public DaoNameDAOApprovalRequestUserListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : DaoNameDAOApprovalRequestUserListVORSQL").append("\n"); 
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
		query.append("SELECT  '' AS AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("'' AS OFC_CD," ).append("\n"); 
		query.append("'' AS USR_ID," ).append("\n"); 
		query.append("'' AS USR_NM" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}