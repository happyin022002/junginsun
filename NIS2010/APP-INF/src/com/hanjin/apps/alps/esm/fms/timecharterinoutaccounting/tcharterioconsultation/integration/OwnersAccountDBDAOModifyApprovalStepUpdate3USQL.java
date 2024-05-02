/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOModifyApprovalStepUpdate3USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOModifyApprovalStepUpdate3USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public OwnersAccountDBDAOModifyApprovalStepUpdate3USQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration ").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOModifyApprovalStepUpdate3USQL").append("\n"); 
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
		query.append("UPDATE AP_INV_HDR SET" ).append("\n"); 
		query.append("     ACT_XCH_RT = (SELECT T.LOCL_KRW_XCH_RT " ).append("\n"); 
		query.append("              		 FROM GL_MON_XCH_RT T, AP_INV_HDR A " ).append("\n"); 
		query.append("              		 WHERE T.ACCT_XCH_RT_LVL   = 1 " ).append("\n"); 
		query.append("              		 AND T.CURR_CD           = A.CSR_CURR_CD" ).append("\n"); 
		query.append("              		 AND T.ACCT_XCH_RT_YRMON = SUBSTR(A.GL_DT,1,6)" ).append("\n"); 
		query.append("                     AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("                    )   " ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	CSR_NO = @[csr_no]" ).append("\n"); 

	}
}