/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnApprovalDBDAOAddSPCLCmpnCSRAPCSRNOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.02
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.07.02 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCLCmpnApprovalDBDAOAddSPCLCmpnCSRAPCSRNOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddSPCLCmpnCSRAPCSRNO
	  * </pre>
	  */
	public SPCLCmpnApprovalDBDAOAddSPCLCmpnCSRAPCSRNOCSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.integration ").append("\n"); 
		query.append("FileName : SPCLCmpnApprovalDBDAOAddSPCLCmpnCSRAPCSRNOCSQL").append("\n"); 
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
		query.append("/* AP_CSR_NO INSERT */" ).append("\n"); 
		query.append("INSERT INTO AP_CSR_NO(CSR_NO, CRE_USR_ID, CRE_DT) " ).append("\n"); 
		query.append("VALUES(@[csr_no], 'BRKG/FAC', SYSDATE)" ).append("\n"); 

	}
}