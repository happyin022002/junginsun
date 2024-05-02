/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ApprovalStepSendDBDAOCheckAproStepB4SendRSQL.java
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

public class ApprovalStepSendDBDAOCheckAproStepB4SendRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AproStep 대상 전송 전 DB에서의 전송 대기 가능 상태 조회
	  * </pre>
	  */
	public ApprovalStepSendDBDAOCheckAproStepB4SendRSQL(){
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
		query.append("Path : com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.integration ").append("\n"); 
		query.append("FileName : ApprovalStepSendDBDAOCheckAproStepB4SendRSQL").append("\n"); 
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
		query.append("SELECT NVL((" ).append("\n"); 
		query.append("SELECT L.EXE_STS_CD" ).append("\n"); 
		query.append("FROM COM_APRO_SND_LOG L" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND L.SND_LOG_SEQ = @[snd_log_seq]" ).append("\n"); 
		query.append("),'E') EXE_STS_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}