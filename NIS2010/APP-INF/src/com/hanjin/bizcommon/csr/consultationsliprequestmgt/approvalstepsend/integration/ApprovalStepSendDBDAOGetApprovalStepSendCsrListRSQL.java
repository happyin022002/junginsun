/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ApprovalStepSendDBDAOGetApprovalStepSendCsrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.16 
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

public class ApprovalStepSendDBDAOGetApprovalStepSendCsrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ApprovalStep 전송 대상 CSR 조회
	  * </pre>
	  */
	public ApprovalStepSendDBDAOGetApprovalStepSendCsrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lmt_knt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.consultationsliprequestmgt.approvalstepsend.integration").append("\n"); 
		query.append("FileName : ApprovalStepSendDBDAOGetApprovalStepSendCsrListRSQL").append("\n"); 
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
		query.append("SELECT /*+ USE_HASH(H) */" ).append("\n"); 
		query.append("H.*" ).append("\n"); 
		query.append("FROM AP_INV_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.IF_FLG IS NOT NULL" ).append("\n"); 
		query.append("AND H.IF_DT IS NOT NULL" ).append("\n"); 
		query.append("AND H.SRC_CTNT = @[src_ctnt]" ).append("\n"); 
		query.append("AND NVL(H.CSR_APRO_TP_CD,'AL') = 'AL'" ).append("\n"); 
		query.append("AND H.IF_DT >=  CASE" ).append("\n"); 
		query.append("                WHEN @[cfm_dt] IS NOT NULL AND LENGTH(TRIM(SUBSTR(REPLACE(@[cfm_dt],'-',''),1,8))) = 8" ).append("\n"); 
		query.append("                THEN TO_DATE(SUBSTR(REPLACE(@[cfm_dt],'-',''),1,8),'YYYYMMDD') " ).append("\n"); 
		query.append("                ELSE SYSDATE - 2" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("    SELECT /*+ UNNEST */ 'X'" ).append("\n"); 
		query.append("    FROM COM_APRO_SND_LOG L" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND L.SND_LOG_SEQ > 0" ).append("\n"); 
		query.append("    AND L.CSR_NO = H.CSR_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ROWNUM <= @[lmt_knt]" ).append("\n"); 
		query.append("ORDER BY H.IF_DT DESC" ).append("\n"); 

	}
}