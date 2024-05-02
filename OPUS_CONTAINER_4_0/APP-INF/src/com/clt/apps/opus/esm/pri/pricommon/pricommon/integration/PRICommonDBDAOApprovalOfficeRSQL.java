/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PRICommonDBDAOApprovalOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2011.02.21 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOApprovalOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C Approval Office list
	  * </pre>
	  */
	public PRICommonDBDAOApprovalOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOApprovalOfficeRSQL").append("\n"); 
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
		query.append("SELECT   OFC_CD CD" ).append("\n"); 
		query.append("        ,OFC_ENG_NM NM" ).append("\n"); 
		query.append("FROM      table(COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC('000001','PRI'))" ).append("\n"); 

	}
}