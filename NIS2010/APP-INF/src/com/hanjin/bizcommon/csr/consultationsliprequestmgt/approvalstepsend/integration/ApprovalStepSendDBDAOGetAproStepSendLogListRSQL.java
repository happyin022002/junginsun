/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ApprovalStepSendDBDAOGetAproStepSendLogListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.13 
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

public class ApprovalStepSendDBDAOGetAproStepSendLogListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AproStep I/F 대상 LOG 조회
	  * </pre>
	  */
	public ApprovalStepSendDBDAOGetAproStepSendLogListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.integration").append("\n"); 
		query.append("FileName : ApprovalStepSendDBDAOGetAproStepSendLogListRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM COM_APRO_SND_LOG L" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND L.SRC_CTNT = @[src_ctnt]" ).append("\n"); 
		query.append("AND L.EXE_STS_CD = 'N'" ).append("\n"); 
		query.append("AND L.EXE_ACT_TP_CD = @[act_tp_cd]" ).append("\n"); 
		query.append("AND NVL(L.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM AP_INV_HDR A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.CSR_NO = L.CSR_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY L.SND_LOG_SEQ DESC" ).append("\n"); 

	}
}