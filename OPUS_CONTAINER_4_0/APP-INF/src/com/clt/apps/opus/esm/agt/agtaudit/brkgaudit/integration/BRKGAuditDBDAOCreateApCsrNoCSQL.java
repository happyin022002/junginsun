/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BRKGAuditDBDAOCreateApCsrNoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOCreateApCsrNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ap_csr_no 테이블에 csr no 추가
	  * </pre>
	  */
	public BRKGAuditDBDAOCreateApCsrNoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOCreateApCsrNoCSQL").append("\n"); 
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
		query.append("INSERT INTO AP_CSR_NO(" ).append("\n"); 
		query.append("CSR_NO," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT)" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("@[csr_no]," ).append("\n"); 
		query.append("'BRKG/FAC'," ).append("\n"); 
		query.append("SYSDATE)" ).append("\n"); 

	}
}