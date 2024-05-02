/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnApprovalDBDAOModifyFFCmpnInfoSuccessUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnApprovalDBDAOModifyFFCmpnInfoSuccessUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyFFCmpnInfoSuccess
	  * </pre>
	  */
	public FFCmpnApprovalDBDAOModifyFFCmpnInfoSuccessUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.integration").append("\n"); 
		query.append("FileName : FFCmpnApprovalDBDAOModifyFFCmpnInfoSuccessUSQL").append("\n"); 
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
		query.append("UPDATE ACM_FF_CMPN A " ).append("\n"); 
		query.append("   SET FF_CMPN_STS_CD = 'IF', " ).append("\n"); 
		query.append("       FF_CMPN_RMK = 'Interface Success!', " ).append("\n"); 
		query.append("       ACCL_FLG = 'Y', " ).append("\n"); 
		query.append("       IF_USR_ID = 'ACM System'," ).append("\n"); 
		query.append("       IF_DT = (SELECT GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,LOC_CD) " ).append("\n"); 
		query.append("                     FROM MDM_ORGANIZATION WHERE OFC_CD = A.AP_OFC_CD), " ).append("\n"); 
		query.append("       IF_GDT = (SELECT GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,'GMT') " ).append("\n"); 
		query.append("                     FROM MDM_ORGANIZATION WHERE OFC_CD = A.AP_OFC_CD)," ).append("\n"); 
		query.append("       UPD_USR_ID = 'ACM System', " ).append("\n"); 
		query.append("       UPD_DT = SYSDATE " ).append("\n"); 
		query.append(" WHERE CSR_NO = @[csr_no]" ).append("\n"); 

	}
}