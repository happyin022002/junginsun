/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DoNotificationSettingDBDAOSearchDoNoticeSetPkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DoNotificationSettingDBDAOSearchDoNoticeSetPkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * D/O NOTIFICATION SET PK 생성
	  * </pre>
	  */
	public DoNotificationSettingDBDAOSearchDoNoticeSetPkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.integration").append("\n"); 
		query.append("FileName : DoNotificationSettingDBDAOSearchDoNoticeSetPkRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(SYSDATE,'YYYYMMDD')||LPAD( TRS_DO_NTFC_SET_SEQ.NEXTVAL,4,'0') DO_NTFC_SEQ" ).append("\n"); 
		query.append("  FROM DUAL  " ).append("\n"); 

	}
}