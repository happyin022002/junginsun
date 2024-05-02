/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOApprovalRequestUserVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.14 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOApprovalRequestUserVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ApprovalRequestUserVO
	  * </pre>
	  */
	public DaoNameDAOApprovalRequestUserVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : DaoNameDAOApprovalRequestUserVORSQL").append("\n"); 
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
		query.append("'' cond_type" ).append("\n"); 
		query.append(",'' ar_hd_qtr_ofc_cd" ).append("\n"); 
		query.append(",'' ofc_cd" ).append("\n"); 
		query.append(",'' usr_nm" ).append("\n"); 
		query.append(",'' usr_id" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}