/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTAuditDBDAOModifyAGTCommProcStsCdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.17
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.03.17 이정수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOModifyAGTCommProcStsCdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyAGTCommProcStsCd
	  * </pre>
	  */
	public AGTAuditDBDAOModifyAGTCommProcStsCdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration ").append("\n"); 
		query.append("FileName : AGTAuditDBDAOModifyAGTCommProcStsCdUSQL").append("\n"); 
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
		query.append("   UPDATE AGT_AGN_COMM A" ).append("\n"); 
		query.append("      SET A.COMM_PROC_STS_CD  = 'IF'," ).append("\n"); 
		query.append("          A.COMM_PROC_STS_RSN = 'Interface OK!'," ).append("\n"); 
		query.append("          A.AC_IF_DT          = SYSDATE" ).append("\n"); 
		query.append("    WHERE A.COMM_APRO_NO = @[inv_no]" ).append("\n"); 

	}
}