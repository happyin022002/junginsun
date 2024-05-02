/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InboundNoticeBackEndDBDAOsearchJobStartDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InboundNoticeBackEndDBDAOsearchJobStartDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 작업시작시간으로 사용할 날자를 조회한다.
	  * </pre>
	  */
	public InboundNoticeBackEndDBDAOsearchJobStartDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : InboundNoticeBackEndDBDAOsearchJobStartDateRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS' ) SYSTEM_DATE" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}