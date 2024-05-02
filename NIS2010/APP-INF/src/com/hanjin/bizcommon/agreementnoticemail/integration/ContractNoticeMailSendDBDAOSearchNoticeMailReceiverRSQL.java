/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContractNoticeMailSendDBDAOSearchNoticeMailReceiverRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
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

public class ContractNoticeMailSendDBDAOSearchNoticeMailReceiverRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 계약종료 90일전 Notice mail을 받을 대상자 조회
	  * </pre>
	  */
	public ContractNoticeMailSendDBDAOSearchNoticeMailReceiverRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.agreementnoticemail.integration").append("\n"); 
		query.append("FileName : ContractNoticeMailSendDBDAOSearchNoticeMailReceiverRSQL").append("\n"); 
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
		query.append("SELECT A.SYS_CD" ).append("\n"); 
		query.append("      ,A.CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,A.OFC_TP_CD" ).append("\n"); 
		query.append("      ,A.AGMT_MAPG_NO  AGMT_NO" ).append("\n"); 
		query.append("      ,COM_NTC_USR_EML_CONCAT_FNC(A.SYS_CD, A.CTRT_OFC_CD, A.AGMT_NO) USR_EML_CTNT" ).append("\n"); 
		query.append("  FROM COM_CTRT_USR_MGMT A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND SYS_CD NOT IN ('TRS','TES')     " ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" SELECT A.SYS_CD" ).append("\n"); 
		query.append("      ,A.CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,A.OFC_TP_CD" ).append("\n"); 
		query.append("      ,A.AGMT_MAPG_NO  AGMT_NO" ).append("\n"); 
		query.append("      ,COM_NTC_USR_EML_CONCAT_FNC(A.SYS_CD, A.CTRT_OFC_CD, A.AGMT_NO) USR_EML_CTNT" ).append("\n"); 
		query.append("  FROM COM_CTRT_USR_MGMT A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND SYS_CD = 'TRS'" ).append("\n"); 
		query.append(" AND A.AGMT_MAPG_NO IN (select  A.AGMT_NO  FROM  COM_CTRT_NTC_INFO A WHERE A.SYS_CD ='TRS' AND A.EML_SND_FLG ='Y')  " ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" SELECT A.SYS_CD" ).append("\n"); 
		query.append("      ,A.CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,A.OFC_TP_CD" ).append("\n"); 
		query.append("      ,A.AGMT_MAPG_NO  AGMT_NO" ).append("\n"); 
		query.append("      ,COM_NTC_USR_EML_CONCAT_FNC(A.SYS_CD, A.CTRT_OFC_CD, A.AGMT_NO) USR_EML_CTNT" ).append("\n"); 
		query.append("  FROM COM_CTRT_USR_MGMT A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND SYS_CD = 'TRS'" ).append("\n"); 
		query.append(" AND AGMT_NO ='ALL'" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" SELECT A.SYS_CD" ).append("\n"); 
		query.append("      ,A.CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,A.OFC_TP_CD" ).append("\n"); 
		query.append("      ,A.AGMT_MAPG_NO  AGMT_NO" ).append("\n"); 
		query.append("      ,COM_NTC_USR_EML_CONCAT_FNC(A.SYS_CD, A.CTRT_OFC_CD, A.AGMT_NO) USR_EML_CTNT" ).append("\n"); 
		query.append("  FROM COM_CTRT_USR_MGMT A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND SYS_CD = 'TES'" ).append("\n"); 
		query.append(" AND A.AGMT_MAPG_NO IN (select  AGMT_NO FROM   COM_CTRT_NTC_INFO WHERE SYS_CD ='TES' AND EML_SND_FLG ='Y')  -- 새로추가된 agreement No 발송" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" SELECT A.SYS_CD" ).append("\n"); 
		query.append("      ,A.CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,A.OFC_TP_CD" ).append("\n"); 
		query.append("      ,A.AGMT_MAPG_NO  AGMT_NO" ).append("\n"); 
		query.append("      ,COM_NTC_USR_EML_CONCAT_FNC(A.SYS_CD, A.CTRT_OFC_CD, A.AGMT_NO) USR_EML_CTNT" ).append("\n"); 
		query.append("  FROM COM_CTRT_USR_MGMT A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND SYS_CD = 'TES'" ).append("\n"); 
		query.append(" AND AGMT_NO ='ALL'" ).append("\n"); 

	}
}