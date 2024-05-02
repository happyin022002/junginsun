/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContractNoticeMailSendDBDAOSearchContractCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.agreementnoticemail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContractNoticeMailSendDBDAOSearchContractCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Notice할 AGMT 계약 건 수 조회
	  * </pre>
	  */
	public ContractNoticeMailSendDBDAOSearchContractCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.agreementnoticemail.integration").append("\n"); 
		query.append("FileName : ContractNoticeMailSendDBDAOSearchContractCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(A.AGMT_NO) AS CTRT_CNT           " ).append("\n"); 
		query.append("  FROM COM_CTRT_NTC_INFO A" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("#if (${sys_cd}!='')" ).append("\n"); 
		query.append("   AND A.SYS_CD = @[sys_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${ofc_tp_cd}=='HQ')" ).append("\n"); 
		query.append("   AND A.CTRT_OFC_CD IN ( SELECT OFC_CD" ).append("\n"); 
		query.append("						    FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("						   WHERE 1=1" ).append("\n"); 
		query.append("						     AND AR_HD_QTR_OFC_CD = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("							 AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("#elseif (${ofc_tp_cd}=='HO')" ).append("\n"); 
		query.append("	AND 1=1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND A.CTRT_OFC_CD = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_no}!='ALL' && ${agmt_no}!='')" ).append("\n"); 
		query.append("    AND A.AGMT_NO = @[agmt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}