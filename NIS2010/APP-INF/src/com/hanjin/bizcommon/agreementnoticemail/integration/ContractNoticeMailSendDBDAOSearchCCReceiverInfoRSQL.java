/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContractNoticeMailSendDBDAOSearchCCReceiverInfoRSQL.java
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

public class ContractNoticeMailSendDBDAOSearchCCReceiverInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 참조 메수신자 조회
	  * </pre>
	  */
	public ContractNoticeMailSendDBDAOSearchCCReceiverInfoRSQL(){
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
		query.append("FileName : ContractNoticeMailSendDBDAOSearchCCReceiverInfoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT B.USR_EML CC_ID" ).append("\n"); 
		query.append("      ,B.USR_NM CC_NM" ).append("\n"); 
		query.append("  FROM COM_CTRT_NTC_INFO A" ).append("\n"); 
		query.append("      ,COM_USER B" ).append("\n"); 
		query.append(" WHERE A.CTRT_UPD_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("   AND B.USE_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${sys_cd}!='')" ).append("\n"); 
		query.append("   AND A.SYS_CD = @[sys_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("   AND A.CTRT_OFC_CD = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("#if (${agmt_no}!='ALL' && ${agmt_no}!='')" ).append("\n"); 
		query.append("    AND A.AGMT_NO = @[agmt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}