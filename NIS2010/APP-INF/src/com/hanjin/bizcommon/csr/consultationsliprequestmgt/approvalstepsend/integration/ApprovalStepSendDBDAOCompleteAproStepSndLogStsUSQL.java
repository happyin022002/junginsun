/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ApprovalStepSendDBDAOCompleteAproStepSndLogStsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApprovalStepSendDBDAOCompleteAproStepSndLogStsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AproStep 전송 후 완료 표시하기
	  * </pre>
	  */
	public ApprovalStepSendDBDAOCompleteAproStepSndLogStsUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_log_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.integration").append("\n"); 
		query.append("FileName : ApprovalStepSendDBDAOCompleteAproStepSndLogStsUSQL").append("\n"); 
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
		query.append("UPDATE COM_APRO_SND_LOG A" ).append("\n"); 
		query.append("SET A.EXE_STS_CD = 'C', A.IF_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.SND_LOG_SEQ = @[snd_log_seq]" ).append("\n"); 

	}
}