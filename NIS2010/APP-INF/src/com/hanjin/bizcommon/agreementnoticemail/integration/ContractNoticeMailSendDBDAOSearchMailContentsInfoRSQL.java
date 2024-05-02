/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContractNoticeMailSendDBDAOSearchMailContentsInfoRSQL.java
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

public class ContractNoticeMailSendDBDAOSearchMailContentsInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 메일에 전송할 데이터 조회
	  * </pre>
	  */
	public ContractNoticeMailSendDBDAOSearchMailContentsInfoRSQL(){
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
		query.append("FileName : ContractNoticeMailSendDBDAOSearchMailContentsInfoRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM SEQ" ).append("\n"); 
		query.append("      ,A.SYS_CD" ).append("\n"); 
		query.append("      ,A.AGMT_NO" ).append("\n"); 
		query.append("      ,A.VNDR_SEQ" ).append("\n"); 
		query.append("      ,B.VNDR_LGL_ENG_NM VNDR_NM" ).append("\n"); 
		query.append("	  ,A.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("      ,A.CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,A.CTRT_CRE_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append("      ,C.USR_NM  CRE_USR_NM" ).append("\n"); 
		query.append("      ,NVL(C.USE_FLG,'N') DELT_FLG" ).append("\n"); 
		query.append("      ,TO_CHAR(A.AGMT_EFF_DT,'YYYY-MM-DD') AGMT_EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.AGMT_EXP_DT,'YYYY-MM-DD') AGMT_EXP_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.CTRT_UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("  FROM COM_CTRT_NTC_INFO A" ).append("\n"); 
		query.append("      ,MDM_VENDOR B" ).append("\n"); 
		query.append("      ,COM_USER C" ).append("\n"); 
		query.append(" WHERE A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.CTRT_CRE_USR_ID = C.USR_ID(+)" ).append("\n"); 
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
		query.append("#if (${agmt_no}!='ALL' && ${agmt_no} !='')" ).append("\n"); 
		query.append("    AND A.AGMT_NO = @[agmt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}