/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FaxEmailEAIDAOGRWEmailNoticeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.faxemail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FaxEmailEAIDAOGRWEmailNoticeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 메일전송을 위해서 필요한 매개변수를 입출력하기 위해서 사용하는 VO 객체를 사용하기 위한 쿼리
	  * </pre>
	  */
	public FaxEmailEAIDAOGRWEmailNoticeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.faxemail.integration").append("\n"); 
		query.append("FileName : FaxEmailEAIDAOGRWEmailNoticeVORSQL").append("\n"); 
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
		query.append("SELECT	'' SENDER" ).append("\n"); 
		query.append(",	'' SUBJECT" ).append("\n"); 
		query.append(",	'' RECIPIENT" ).append("\n"); 
		query.append(",	'' TEXTCONTENT" ).append("\n"); 
		query.append(",	'' HTMLTEMPLATE" ).append("\n"); 
		query.append(",	'' DAR_NO" ).append("\n"); 
		query.append(",	'' VER_NO" ).append("\n"); 
		query.append(",	'' APVL_NO" ).append("\n"); 
		query.append(",	'' STATUS" ).append("\n"); 
		query.append(",	'' SC_NO" ).append("\n"); 
		query.append(",	'' RFA_NO" ).append("\n"); 
		query.append(",	'' PROP_NO" ).append("\n"); 
		query.append(",	'' BL_NO" ).append("\n"); 
		query.append(",	'' CUST_CD" ).append("\n"); 
		query.append(",	'' CUST_NM" ).append("\n"); 
		query.append(",	'' COMMENTS" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}