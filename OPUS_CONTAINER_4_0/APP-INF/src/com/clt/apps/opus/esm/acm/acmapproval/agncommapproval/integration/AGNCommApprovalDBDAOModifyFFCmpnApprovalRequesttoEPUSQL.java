/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AGNCommApprovalDBDAOModifyFFCmpnApprovalRequesttoEPUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOModifyFFCmpnApprovalRequesttoEPUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyFFCmpnApprovalRequesttoEP
	  * </pre>
	  */
	public AGNCommApprovalDBDAOModifyFFCmpnApprovalRequesttoEPUSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration ").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOModifyFFCmpnApprovalRequesttoEPUSQL").append("\n"); 
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
		query.append("UPDATE ACM_FF_CMPN" ).append("\n"); 
		query.append("       SET FF_CMPN_STS_CD = 'IC'," ).append("\n"); 
		query.append("           FF_CMPN_RMK    = 'Approval Reject!'," ).append("\n"); 
		query.append("           ACCL_FLG       = 'N'," ).append("\n"); 
		query.append("           IF_USR_ID      = NULL," ).append("\n"); 
		query.append("           IF_DT          = NULL," ).append("\n"); 
		query.append("           IF_GDT         = NULL," ).append("\n"); 
		query.append("           APRO_USR_ID    = NULL," ).append("\n"); 
		query.append("           APRO_DT        = NULL," ).append("\n"); 
		query.append("           APRO_GDT       = NULL," ).append("\n"); 
		query.append("           UPD_USR_ID     = 'ACM System'," ).append("\n"); 
		query.append("           UPD_DT         = SYSDATE" ).append("\n"); 
		query.append("     WHERE CSR_NO         = @[csr_no]" ).append("\n"); 

	}
}