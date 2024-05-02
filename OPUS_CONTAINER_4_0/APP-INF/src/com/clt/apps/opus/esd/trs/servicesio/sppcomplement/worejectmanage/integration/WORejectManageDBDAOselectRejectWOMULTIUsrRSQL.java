/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WORejectManageDBDAOselectRejectWOMULTIUsrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.11.05 양봉준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.worejectmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WORejectManageDBDAOselectRejectWOMULTIUsrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * selectRejectWOMULTIUsr
	  * </pre>
	  */
	public WORejectManageDBDAOselectRejectWOMULTIUsrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.sppcomplement.worejectmanage.integration").append("\n"); 
		query.append("FileName : WORejectManageDBDAOselectRejectWOMULTIUsrRSQL").append("\n"); 
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
		query.append("USR_ID, USR_EML" ).append("\n"); 
		query.append("FROM	COM_USER" ).append("\n"); 
		query.append("WHERE	USR_ID = 'SPP_IF'" ).append("\n"); 

	}
}