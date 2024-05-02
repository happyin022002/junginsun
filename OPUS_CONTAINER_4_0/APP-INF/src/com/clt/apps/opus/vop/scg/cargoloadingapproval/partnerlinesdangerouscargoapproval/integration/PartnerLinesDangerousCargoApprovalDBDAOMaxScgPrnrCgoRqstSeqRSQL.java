/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAOMaxScgPrnrCgoRqstSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAOMaxScgPrnrCgoRqstSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 오라클 시퀀스 SCG_PRNR_CGO_RQST_SEQ.NEXTVAL를 조회한다.
	  * (SCG_PRNR_APRO_RQST_CGO의 unique no)
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAOMaxScgPrnrCgoRqstSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAOMaxScgPrnrCgoRqstSeqRSQL").append("\n"); 
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
		query.append("SELECT SCG_PRNR_CGO_RQST_SEQ.NEXTVAL FROM DUAL" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}