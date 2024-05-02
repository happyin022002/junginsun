/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRHeader2USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRHeader2USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifySPCLCmpnCSRHeader2
	  * </pre>
	  */
	public SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRHeader2USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.integration").append("\n"); 
		query.append("FileName : SPCLCmpnApprovalDBDAOModifySPCLCmpnCSRHeader2USQL").append("\n"); 
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
		query.append("/* AP_INV_HDR UPDATE */" ).append("\n"); 
		query.append("UPDATE AP_INV_HDR " ).append("\n"); 
		query.append("   SET IF_DT = SYSDATE, " ).append("\n"); 
		query.append("	   ACCT_XCH_RT_YRMON = SUBSTR(GL_DT,1,6)," ).append("\n"); 
		query.append("       CSR_USD_AMT = AP_COM_GET_USD_XCH_AMT_FNC(CSR_CURR_CD, CSR_AMT, SUBSTR(GL_DT,1,6))," ).append("\n"); 
		query.append("       IF_ERR_RSN = 'APPROVAL REQUEST!'" ).append("\n"); 
		query.append(" WHERE CSR_NO = @[csr_no] " ).append("\n"); 

	}
}