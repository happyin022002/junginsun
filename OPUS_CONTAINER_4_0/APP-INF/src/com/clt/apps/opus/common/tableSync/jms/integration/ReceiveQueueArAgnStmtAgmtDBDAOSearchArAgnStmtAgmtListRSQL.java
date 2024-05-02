/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueArAgnStmtAgmtDBDAOSearchArAgnStmtAgmtListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.10.23 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.common.tableSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueArAgnStmtAgmtDBDAOSearchArAgnStmtAgmtListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ar_agn_stmt_agmt 테이블 조회
	  * </pre>
	  */
	public ReceiveQueueArAgnStmtAgmtDBDAOSearchArAgnStmtAgmtListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.common.tableSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueArAgnStmtAgmtDBDAOSearchArAgnStmtAgmtListRSQL").append("\n"); 
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
		query.append("SELECT asa_rhq_cd" ).append("\n"); 
		query.append("FROM ar_agn_stmt_agmt" ).append("\n"); 
		query.append("WHERE asa_rhq_cd = @[asa_rhq_cd]" ).append("\n"); 
		query.append("AND asa_no = @[asa_no]" ).append("\n"); 

	}
}