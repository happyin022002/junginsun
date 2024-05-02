/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOCreateTesInvoiceAuditBatchSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.09
*@LastModifier : yOnghO
*@LastVersion : 1.0
* 2016.03.09 yOnghO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOnghO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOCreateTesInvoiceAuditBatchSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manual(5분) Batch Max Sequence 조회
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOCreateTesInvoiceAuditBatchSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration ").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOCreateTesInvoiceAuditBatchSeqRSQL").append("\n"); 
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
		query.append("SELECT	MAX(NVL(AUTO_AUD_BAT_SEQ, 0)) + 1 AS MAX_SEQ" ).append("\n"); 
		query.append("FROM	EAS_AUTO_AUD_BAT" ).append("\n"); 

	}
}