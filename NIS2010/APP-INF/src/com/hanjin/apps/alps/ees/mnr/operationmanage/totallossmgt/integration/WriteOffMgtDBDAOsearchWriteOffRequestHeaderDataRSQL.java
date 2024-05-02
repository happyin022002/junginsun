/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : WriteOffMgtDBDAOsearchWriteOffRequestHeaderDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.30
*@LastModifier : 한종희
*@LastVersion : 1.0
* 2013.09.30 한종희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jonghee HAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WriteOffMgtDBDAOsearchWriteOffRequestHeaderDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013-09-30 CHM-201326903 Write-off request 신청 office 기준 변경 요청 by Jonghee HAN
	  * </pre>
	  */
	public WriteOffMgtDBDAOsearchWriteOffRequestHeaderDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : WriteOffMgtDBDAOsearchWriteOffRequestHeaderDataRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       MTLRH.TTL_LSS_NO," ).append("\n"); 
		query.append("       MTLRH.RESPB_OFC_CD," ).append("\n"); 
		query.append("       TO_CHAR(MTLRH.RQST_DT, 'YYYY-MM-DD') RQST_DT," ).append("\n"); 
		query.append("       (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'TR' AND MNR_CD_ID = MTLRH.TTL_LSS_RSN_CD) TTL_LSS_RSN_CD," ).append("\n"); 
		query.append("       (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'TRD' AND MNR_CD_ID = MTLRH.TTL_LSS_DTL_RSN_CD) TTL_LSS_DTL_RSN_CD," ).append("\n"); 
		query.append("       TO_CHAR(MTLRH.TTL_LSS_DT, 'YYYY-MM-DD') TTL_LSS_DT," ).append("\n"); 
		query.append("       MTLRD.WRTF_NO," ).append("\n"); 
		query.append("	   MTLRH.FILE_SEQ," ).append("\n"); 
		query.append("	   MTLRH.MNR_STS_REF_NO " ).append("\n"); 
		query.append("  FROM MNR_TTL_LSS_RQST_HDR MTLRH, MNR_TTL_LSS_RQST_DTL MTLRD" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND MTLRH.TTL_LSS_NO = MTLRD.TTL_LSS_NO" ).append("\n"); 
		query.append("   AND MTLRH.TTL_LSS_STS_CD = 'HA'" ).append("\n"); 
		query.append("   AND MTLRD.MNR_INV_TP_CD = 'DV'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("#if (${ttl_lss_no} != '')" ).append("\n"); 
		query.append("   AND MTLRH.TTL_LSS_NO = @[ttl_lss_no]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${in_rqst_eq_no} != '')" ).append("\n"); 
		query.append("   AND MTLRH.TTL_LSS_NO IN (SELECT DISTINCT TTL_LSS_NO " ).append("\n"); 
		query.append("							  FROM MNR_TTL_LSS_RQST_DTL " ).append("\n"); 
		query.append("							 WHERE RQST_EQ_NO = @[in_rqst_eq_no]" ).append("\n"); 
		query.append("							#if(${eq_knd_cd} != ''&&${eq_knd_cd} != 'ALL')" ).append("\n"); 
		query.append("							   AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND MTLRH.RESPB_OFC_CD = @[in_rqst_ofc_cd]" ).append("\n"); 

	}
}