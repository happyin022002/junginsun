/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommApprovalDBDAOModifyACMOtherApprovalRequesttoEPUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.13
*@LastModifier :
*@LastVersion : 1.0
* 2012.08.13
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOModifyACMOtherApprovalRequesttoEPUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ModifyACMOtherApprovalRequesttoEP
	  * </pre>
	  */
	public AGNCommApprovalDBDAOModifyACMOtherApprovalRequesttoEPUSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration").append("\n");
		query.append("FileName : AGNCommApprovalDBDAOModifyACMOtherApprovalRequesttoEPUSQL").append("\n");
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
		query.append("UPDATE ACM_AGN_OTR_COMM" ).append("\n");
		query.append("       SET AC_STS_CD  = 'IC'," ).append("\n");
		query.append("           AC_PROC_DESC = 'Approval Reject!'," ).append("\n");
		query.append("           ACCL_FLG       = 'N'," ).append("\n");
		query.append("           IF_USR_ID      = NULL," ).append("\n");
		query.append("           IF_DT          = NULL," ).append("\n");
		query.append("           IF_GDT         = NULL," ).append("\n");
		query.append("           RQST_USR_ID    = NULL," ).append("\n");
		query.append("           RQST_DT        = NULL," ).append("\n");
		query.append("           RQST_GDT       = NULL," ).append("\n");
		query.append("           AUD_NO         = NULL," ).append("\n");
		query.append("           AUD_USR_ID     = NULL," ).append("\n");
		query.append("           AUD_DT         = NULL," ).append("\n");
		query.append("           AUD_GDT        = NULL," ).append("\n");
		query.append("           APRO_USR_ID    = NULL," ).append("\n");
		query.append("           APRO_DT        = NULL," ).append("\n");
		query.append("           APRO_GDT       = NULL," ).append("\n");
		query.append("           ASA_NO         = NULL," ).append("\n");
		query.append("           UPD_USR_ID     = 'ACM System'," ).append("\n");
		query.append("           UPD_DT         = SYSDATE" ).append("\n");
		query.append("     WHERE CSR_NO         = @[csr_no]" ).append("\n");

	}
}