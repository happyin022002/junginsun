/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BRKGAuditDBDAOModifyBrogCommProcStsCdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.03.18 이정수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BRKGAuditDBDAOModifyBrogCommProcStsCdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyBrogCommProcStsCd
	  * </pre>
	  */
	public BRKGAuditDBDAOModifyBrogCommProcStsCdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.integration").append("\n"); 
		query.append("FileName : BRKGAuditDBDAOModifyBrogCommProcStsCdUSQL").append("\n"); 
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
		query.append("UPDATE AGT_BROG_COMM A" ).append("\n"); 
		query.append("      SET A.COMM_PROC_STS_CD  = 'IF'," ).append("\n"); 
		query.append("          A.COMM_PROC_RSLT_RSN = 'Interface OK!'," ).append("\n"); 
		query.append("          A.BROG_IF_DT          = SYSDATE" ).append("\n"); 
		query.append("    WHERE A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 

	}
}