/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ApprovalDBDAOCheckDftAproStepYNRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.approval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalDBDAOCheckDftAproStepYNRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 디폴트 결재라인 검사
	  * </pre>
	  */
	public ApprovalDBDAOCheckDftAproStepYNRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.approval.integration ").append("\n"); 
		query.append("FileName : ApprovalDBDAOCheckDftAproStepYNRSQL").append("\n"); 
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
		query.append("SELECT NVL(V.AP_DFLT_APRO_STEP_FLG,'X') AP_DFLT_APRO_STEP_FLG " ).append("\n"); 
		query.append("FROM COM_AP_ACCT_VER V " ).append("\n"); 
		query.append("WHERE V.AP_ACCT_VER_NO = (SELECT MAX(M.AP_ACCT_VER_NO) FROM COM_AP_ACCT_VER M WHERE NVL(M.CFM_FLG,'N') = 'Y') " ).append("\n"); 

	}
}