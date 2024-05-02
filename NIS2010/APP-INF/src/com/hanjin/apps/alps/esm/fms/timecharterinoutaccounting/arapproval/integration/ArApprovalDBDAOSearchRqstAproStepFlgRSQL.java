/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ArApprovalDBDAOSearchRqstAproStepFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.12.19 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArApprovalDBDAOSearchRqstAproStepFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GW에서 전송받은 결재 상태를 조회한다
	  * </pre>
	  */
	public ArApprovalDBDAOSearchRqstAproStepFlgRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.integration ").append("\n"); 
		query.append("FileName : ArApprovalDBDAOSearchRqstAproStepFlgRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    CASE WHEN CSR_APRO_CMPL_DT IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("         WHEN CSR_RJCT_DT IS NOT NULL THEN 'N'" ).append("\n"); 
		query.append("         WHEN CSR_APRO_STEP_ASGN_DT IS NOT NULL THEN 'P'" ).append("\n"); 
		query.append("         ELSE 'X'" ).append("\n"); 
		query.append("    END RQST_APRO_STEP_FLG" ).append("\n"); 
		query.append("FROM AR_INV_HDR " ).append("\n"); 
		query.append("WHERE CSR_NO = @[csr_no]" ).append("\n"); 

	}
}