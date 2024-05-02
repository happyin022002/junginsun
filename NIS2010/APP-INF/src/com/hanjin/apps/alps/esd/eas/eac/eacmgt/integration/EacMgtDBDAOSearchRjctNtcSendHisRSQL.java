/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchRjctNtcSendHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.26
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.11.26 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOSearchRjctNtcSendHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rejection Notice Send History 내역 조회
	  * </pre>
	  */
	public EacMgtDBDAOSearchRjctNtcSendHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_snd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_reg_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_snd_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchRjctNtcSendHisRSQL").append("\n"); 
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
		query.append("SELECT A.EAC_NO" ).append("\n"); 
		query.append("      ,B.NTC_HIS_SEQ" ).append("\n"); 
		query.append("      ,B.VNDR_SEQ" ).append("\n"); 
		query.append("      ,(SELECT X.VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = B.VNDR_SEQ) AS VNDR_NM" ).append("\n"); 
		query.append("      ,CASE WHEN B.EAC_EML_USE_FLG = 'Y' AND B.EAC_FAX_USE_FLG = 'Y' THEN 'All'" ).append("\n"); 
		query.append("            WHEN B.EAC_EML_USE_FLG = 'Y' THEN 'e-Mail'" ).append("\n"); 
		query.append("            WHEN B.EAC_FAX_USE_FLG = 'Y' THEN 'Fax'" ).append("\n"); 
		query.append("       END AS SND_TP_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(B.NTC_SND_DT,'YYYY-MM-DD HH24:MI:SS') AS NTC_SND_DT" ).append("\n"); 
		query.append("      ,B.CRE_USR_ID" ).append("\n"); 
		query.append("      ,B.CRE_OFC_CD" ).append("\n"); 
		query.append("      ,(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = A.AUDR_USR_ID) AS CRE_USR_NM" ).append("\n"); 
		query.append("      ,B.RCVR_FAX_NO" ).append("\n"); 
		query.append("      ,(SELECT COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00959',D.FAX_PROC_STS_CD) FROM DUAL) AS FAX_STS_NM" ).append("\n"); 
		query.append("      ,B.RCVR_EML" ).append("\n"); 
		query.append("      ,(SELECT COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00960',C.EML_PROC_STS_CD) FROM DUAL) AS EML_STS_NM      " ).append("\n"); 
		query.append("  FROM EAS_EXPN_AUD_CS_MGMT A" ).append("\n"); 
		query.append("      ,EAS_EXPN_AUD_CS_RJCT_HIS B" ).append("\n"); 
		query.append("      ,COM_EML_SND_INFO C" ).append("\n"); 
		query.append("      ,COM_FAX_SND_INFO D" ).append("\n"); 
		query.append(" WHERE A.EAC_NO = B.EAC_NO" ).append("\n"); 
		query.append("   AND B.EML_SND_NO = C.EML_SND_NO(+)" ).append("\n"); 
		query.append("   AND B.FAX_SND_NO = D.FAX_SND_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  -- RHQ (필수)" ).append("\n"); 
		query.append("  #if (${s_rhq_ofc_cd} != '') " ).append("\n"); 
		query.append("    #if(${s_rhq_ofc_cd} == 'SELADG')" ).append("\n"); 
		query.append("      AND A.AUDR_OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("      AND TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(AUDR_OFC_CD) = @[s_rhq_ofc_cd] -- RHQ" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  -- Audit Office" ).append("\n"); 
		query.append("  #if (${s_ofc_cd} != '') " ).append("\n"); 
		query.append("    AND A.AUDR_OFC_CD = @[s_ofc_cd] -- Audit Office" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  -- Auditor" ).append("\n"); 
		query.append("  #if (${s_eac_reg_usr_id} != '')" ).append("\n"); 
		query.append("    AND A.AUDR_USR_ID = @[s_eac_reg_usr_id]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  -- Send Type" ).append("\n"); 
		query.append("  #if ( ${s_snd_tp_cd} != '' )" ).append("\n"); 
		query.append("    #if ( ${s_snd_tp_cd} == 'F' )" ).append("\n"); 
		query.append("        AND B.EAC_FAX_USE_FLG = 'Y'" ).append("\n"); 
		query.append("    #elseif ( ${s_snd_tp_cd} == 'M' )" ).append("\n"); 
		query.append("        AND B.EAC_EML_USE_FLG = 'Y'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("  -- Send Date (필수)" ).append("\n"); 
		query.append("  AND TO_CHAR(B.NTC_SND_DT, 'YYYYMM') BETWEEN replace(@[s_snd_fm_dt],'-','') AND replace(@[s_snd_to_dt],'-','')" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("  -- Service Provider" ).append("\n"); 
		query.append("  #if ( ${s_vndr_seq} != '' )" ).append("\n"); 
		query.append("    AND B.VNDR_SEQ = @[s_vndr_seq]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("  -- Send Result" ).append("\n"); 
		query.append("  #if ( ${s_snd_rslt_cd} != '' )" ).append("\n"); 
		query.append("    #if ( ${s_snd_rslt_cd} == 'S' ) -- Mail, Fax 모두 성공일 경우" ).append("\n"); 
		query.append("      AND ((D.FAX_PROC_STS_CD = '5' OR D.FAX_PROC_STS_CD IS NULL) AND (C.EML_PROC_STS_CD = '3' OR C.EML_PROC_STS_CD IS NULL))" ).append("\n"); 
		query.append("    #elseif ( ${s_snd_rslt_cd} == 'F' )" ).append("\n"); 
		query.append("      AND (D.FAX_PROC_STS_CD <> '5' OR C.EML_PROC_STS_CD <> '3')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.EAC_NO DESC ,B.NTC_HIS_SEQ DESC" ).append("\n"); 

	}
}