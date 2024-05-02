/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ApprovalStepSendDBDAOLogAproCommErrMsgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalStepSendDBDAOLogAproCommErrMsgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 공통 Error table에 Error 남기기
	  * </pre>
	  */
	public ApprovalStepSendDBDAOLogAproCommErrMsgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_log_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_err_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.integration ").append("\n"); 
		query.append("FileName : ApprovalStepSendDBDAOLogAproCommErrMsgCSQL").append("\n"); 
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
		query.append("INSERT INTO COM_CSR_ERR_LOG (" ).append("\n"); 
		query.append("CSR_ERR_LOG_SEQ" ).append("\n"); 
		query.append(", CSR_ERR_TP_CD" ).append("\n"); 
		query.append(", ERR_LOG_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("COM_CSR_ERR_LOG_SEQ.NEXTVAL" ).append("\n"); 
		query.append(", @[csr_err_tp_cd] --CSR_ERR_TP_CD" ).append("\n"); 
		query.append(", SUBSTRB(@[err_log_rmk],1,4000) --ERR_LOG_RMK" ).append("\n"); 
		query.append(", 'SYSTEM' --CRE_USR_ID" ).append("\n"); 
		query.append(", SYSDATE --CRE_DT" ).append("\n"); 
		query.append(", 'SYSTEM' --UPD_USR_ID" ).append("\n"); 
		query.append(", SYSDATE --UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}