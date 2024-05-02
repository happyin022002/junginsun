/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchVskActPortSkdEdiLogKeyValueRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.03.22 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOSearchVskActPortSkdEdiLogKeyValueRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVskActPortSkdEdiLogKeyValue
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchVskActPortSkdEdiLogKeyValueRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOSearchVskActPortSkdEdiLogKeyValueRSQL").append("\n"); 
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
		query.append("--SELECT  TO_CHAR(SYSDATE, 'YYYYMMDD') 	AS RCV_DT," ).append("\n"); 
		query.append("--		NVL(MAX(RCV_SEQ), 0) + 1		AS RCV_SEQ" ).append("\n"); 
		query.append("--FROM	VSK_ACT_PORT_SKD_EDI_LOG" ).append("\n"); 
		query.append("--WHERE   RCV_DT	BETWEEN	TO_DATE (TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD')" ).append("\n"); 
		query.append("--AND		TO_DATE (TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("SELECT  TO_CHAR(SYSDATE, 'YYYYMMDD') 	AS RCV_DT," ).append("\n"); 
		query.append("		VSK_RCV_SEQ.NEXTVAL		AS RCV_SEQ" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}