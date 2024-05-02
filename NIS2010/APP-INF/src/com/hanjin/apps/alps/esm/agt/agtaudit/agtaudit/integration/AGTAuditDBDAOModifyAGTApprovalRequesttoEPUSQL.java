/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOModifyAGTApprovalRequesttoEPUSQL.java
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

public class AGTAuditDBDAOModifyAGTApprovalRequesttoEPUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyAGTApprovalRequesttoEP
	  * </pre>
	  */
	public AGTAuditDBDAOModifyAGTApprovalRequesttoEPUSQL(){
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
		query.append("FileName : AGTAuditDBDAOModifyAGTApprovalRequesttoEPUSQL").append("\n"); 
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
		query.append("UPDATE AGT_AGN_COMM" ).append("\n"); 
		query.append("SET COMM_PROC_STS_CD  = 'IC'," ).append("\n"); 
		query.append("COMM_PROC_STS_RSN = 'Approval Request Reject!'," ).append("\n"); 
		query.append("ACCL_FLG          = 'N'," ).append("\n"); 
		query.append("AC_IF_USR_ID      = NULL," ).append("\n"); 
		query.append("AC_IF_DT          = NULL," ).append("\n"); 
		query.append("AC_RQST_USR_ID    = NULL," ).append("\n"); 
		query.append("AC_RQST_USR_EML   = NULL," ).append("\n"); 
		query.append("AC_RQST_DT        = NULL," ).append("\n"); 
		query.append("COMM_APRO_NO      = NULL," ).append("\n"); 
		query.append("AC_APRO_USR_ID    = NULL," ).append("\n"); 
		query.append("AC_APRO_DT        = NULL," ).append("\n"); 
		query.append("ASA_NO            = NULL," ).append("\n"); 
		query.append("UPD_USR_ID        = 'AGT System'," ).append("\n"); 
		query.append("UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHERE CSR_NO            = @[csr_no]" ).append("\n"); 

	}
}