/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ScheduleSendManagementDBDAOCreateExchangeEdiSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleSendManagementDBDAOCreateExchangeEdiSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Seq 생성하기
	  * </pre>
	  */
	public ScheduleSendManagementDBDAOCreateExchangeEdiSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.integration").append("\n"); 
		query.append("FileName : ScheduleSendManagementDBDAOCreateExchangeEdiSeqRSQL").append("\n"); 
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
		query.append("SELECT SKD_EDI_RCV_SEQ.NEXTVAL FROM DUAL" ).append("\n"); 

	}
}