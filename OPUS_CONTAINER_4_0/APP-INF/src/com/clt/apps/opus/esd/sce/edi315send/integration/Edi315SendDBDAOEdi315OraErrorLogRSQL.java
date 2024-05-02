/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315SendDBDAOEdi315OraErrorLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.11.20 전병석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Byoung Suk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOEdi315OraErrorLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for edi315OraErrLog
	  * </pre>
	  */
	public Edi315SendDBDAOEdi315OraErrorLogRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOEdi315OraErrorLogRSQL").append("\n"); 
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
		query.append("''cntr_no," ).append("\n"); 
		query.append("''bkg_no," ).append("\n"); 
		query.append("''edi_sts," ).append("\n"); 
		query.append("''err_mgs," ).append("\n"); 
		query.append("''cre_usr_id," ).append("\n"); 
		query.append("''upd_usr_id" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}