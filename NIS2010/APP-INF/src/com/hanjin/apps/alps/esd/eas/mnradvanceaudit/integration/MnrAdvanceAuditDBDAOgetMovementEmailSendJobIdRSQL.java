/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOgetMovementEmailSendJobIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2016.04.26 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOgetMovementEmailSendJobIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 20160420 HongSeongPill max(job_id) + 1 값을 가져온다.
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOgetMovementEmailSendJobIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOgetMovementEmailSendJobIdRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(SYSDATE,'YYYYMMDD')||LPAD( (NVL(TO_NUMBER(SUBSTR(MAX(JB_ID),9,7)),0) + 1),7,'0' ) AS JB_ID" ).append("\n"); 
		query.append("FROM   EAS_MVMT_EML_SND_HIS " ).append("\n"); 
		query.append("WHERE  SUBSTR(JB_ID,0,8) = TO_CHAR(SYSDATE,'YYYYMMDD') " ).append("\n"); 

	}
}