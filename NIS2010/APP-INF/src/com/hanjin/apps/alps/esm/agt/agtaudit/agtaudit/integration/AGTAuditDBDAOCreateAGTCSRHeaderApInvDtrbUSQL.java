/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOCreateAGTCSRHeaderApInvDtrbUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.19 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOCreateAGTCSRHeaderApInvDtrbUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateAGTCSRHeaderApInvDtrb
	  * </pre>
	  */
	public AGTAuditDBDAOCreateAGTCSRHeaderApInvDtrbUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOCreateAGTCSRHeaderApInvDtrbUSQL").append("\n"); 
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
		query.append("UPDATE AP_INV_DTRB A" ).append("\n"); 
		query.append("SET INV_AMT" ).append("\n"); 
		query.append("= INV_AMT" ).append("\n"); 
		query.append("+" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("ROUND (X.CSR_AMT - SUM (Y.INV_AMT) ,2)" ).append("\n"); 
		query.append("FROM AP_INV_HDR X," ).append("\n"); 
		query.append("AP_INV_DTRB Y" ).append("\n"); 
		query.append("WHERE X.CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("AND X.CSR_NO = Y.CSR_NO" ).append("\n"); 
		query.append("GROUP BY X.CSR_AMT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("LINE_SEQ," ).append("\n"); 
		query.append("LINE_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LINE_SEQ," ).append("\n"); 
		query.append("LINE_NO" ).append("\n"); 
		query.append("FROM AP_INV_DTRB" ).append("\n"); 
		query.append("WHERE CSR_NO = A.CSR_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}