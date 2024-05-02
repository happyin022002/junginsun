/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : WriteOffMgtDBDAOsearchWriteOffApprovalDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WriteOffMgtDBDAOsearchWriteOffApprovalDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public WriteOffMgtDBDAOsearchWriteOffApprovalDataRSQL(){
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
		params.put("in_end_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_st_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : WriteOffMgtDBDAOsearchWriteOffApprovalDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("MTLRH.TTL_LSS_NO," ).append("\n"); 
		query.append("MWRH.WRTF_NO" ).append("\n"); 
		query.append(",MAX(MWRH.WRTF_RQST_OFC_CD) RQST_OFC_CD" ).append("\n"); 
		query.append(",MAX(MWRH.WRTF_APRO_OFC_CD) APRO_OFC_CD" ).append("\n"); 
		query.append(",TO_CHAR(MAX(MTLRH.TTL_LSS_DT), 'yyyy-mm-dd') TTL_LSS_DT" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), MAX(MTLRH.RQST_DT),@[user_ofc_cd]), 'yyyy-mm-dd') RQST_DT" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), MAX(MWRH.WRTF_RQST_DT),@[user_ofc_cd]), 'yyyy-mm-dd') WRTF_RQST_DT" ).append("\n"); 
		query.append(",MAX(MTLRH.TTL_LSS_STS_CD) TTL_LSS_STS_CD" ).append("\n"); 
		query.append(",MAX(MWRH.WRTF_STS_CD) WRTF_STS_CD" ).append("\n"); 
		query.append(",MAX(MTLRH.MNR_STS_REF_NO) MNR_STS_REF_NO" ).append("\n"); 
		query.append(",MAX(MTLRH.TTL_LSS_CMPL_CD) TTL_LSS_CMPL_CD" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),MAX(MTLRH.TTL_LSS_CFM_DT),'PUSBO'), 'yyyy-mm-dd') TTL_LSS_CFM_DT" ).append("\n"); 
		query.append(",MAX(MTLRH.TTL_LSS_CFM_ID) TTL_LSS_CFM_ID" ).append("\n"); 
		query.append(",MAX(MTLRH.TTL_LSS_RSN_CD) TTL_LSS_RSN_CD" ).append("\n"); 
		query.append(",MAX(MTLRH.TTL_LSS_DTL_RSN_CD) TTL_LSS_DTL_RSN_CD" ).append("\n"); 
		query.append(",MAX((SELECT MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD" ).append("\n"); 
		query.append("WHERE MNR_CD_ID=TTL_LSS_RSN_CD" ).append("\n"); 
		query.append(")) AS TTL_LSS_RSN_NM" ).append("\n"); 
		query.append(",MAX((SELECT MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD" ).append("\n"); 
		query.append("WHERE PRNT_CD_ID=MTLRH.TTL_LSS_RSN_CD" ).append("\n"); 
		query.append("AND MNR_CD_ID=MTLRH.TTL_LSS_DTL_RSN_CD" ).append("\n"); 
		query.append(")) AS TTL_LSS_DTL_RSN_NM" ).append("\n"); 
		query.append(",MAX(MTLRH.TTL_LSS_RMK) TTL_LSS_RMK" ).append("\n"); 
		query.append(",MAX(MTLRH.FILE_SEQ) FILE_SEQ" ).append("\n"); 
		query.append(",MAX(MTLRH.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(MAX(MTLRH.CRE_DT), 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",MAX(MTLRH.UPD_USR_ID) UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(MAX(MTLRH.UPD_DT), 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append(",SUM(DECODE(MTLRD.MNR_INV_TP_CD, 'DV', 1)) DV_EQ_QTY" ).append("\n"); 
		query.append(",SUM(MTLRD.DPC_VAL_AMT) DV_DV_VAL" ).append("\n"); 
		query.append(",SUM(MTLRD.WRTF_CLT_AMT) WRTF_CLT_AMT" ).append("\n"); 
		query.append(",SUM(ROUND(MTLRD.DPC_VAL_AMT - NVL(MTLRD.WRTF_CLT_AMT, 0), 2)) AMT_LOSS" ).append("\n"); 
		query.append(",MAX(MTLRH.RESPB_OFC_CD) RESPB_OFC_CD" ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_HDR MTLRH, MNR_TTL_LSS_RQST_DTL MTLRD, MNR_WRTF_RQST_HDR MWRH" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND MTLRH.TTL_LSS_NO = MTLRD.TTL_LSS_NO(+)" ).append("\n"); 
		query.append("AND MTLRH.TTL_LSS_NO = MWRH.TTL_LSS_NO" ).append("\n"); 
		query.append("AND MTLRD.WRTF_NO = MWRH.WRTF_NO" ).append("\n"); 
		query.append("AND MTLRH.TTL_LSS_STS_CD = 'HA'" ).append("\n"); 
		query.append("AND MTLRD.MNR_INV_TP_CD = 'DV'" ).append("\n"); 
		query.append("AND MWRH.WRTF_STS_CD NOT IN ('RD', 'RS', 'BJ', 'QJ', 'OJ')" ).append("\n"); 
		query.append("#if(${in_st_dt} != '' && ${in_end_dt} != '')" ).append("\n"); 
		query.append("AND MWRH.WRTF_RQST_DT BETWEEN TO_DATE(@[in_st_dt], 'yyyy-mm-dd') AND TO_DATE(@[in_end_dt], 'yyyy-mm-dd')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ttl_lss_no} != '')" ).append("\n"); 
		query.append("AND MTLRH.TTL_LSS_NO = @[ttl_lss_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_rqst_eq_no} != '')" ).append("\n"); 
		query.append("AND MTLRH.TTL_LSS_NO IN (SELECT DISTINCT TTL_LSS_NO" ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_DTL" ).append("\n"); 
		query.append("WHERE RQST_EQ_NO = @[in_rqst_eq_no]" ).append("\n"); 
		query.append("#if(${eq_knd_cd} != ''&&${eq_knd_cd} != 'ALL')" ).append("\n"); 
		query.append("AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND @[apro_usr_id] = (SELECT DISTINCT APRO_USR_ID" ).append("\n"); 
		query.append("FROM MNR_APRO_STEP_HIS" ).append("\n"); 
		query.append("WHERE APRO_STEP_SEQ = (SELECT MIN(APRO_STEP_SEQ)" ).append("\n"); 
		query.append("FROM MNR_APRO_STEP_HIS" ).append("\n"); 
		query.append("WHERE WRTF_NO = MWRH.WRTF_NO" ).append("\n"); 
		query.append("AND APSTS_CD = 'W')" ).append("\n"); 
		query.append("AND WRTF_NO = MWRH.WRTF_NO )" ).append("\n"); 
		query.append("GROUP BY MTLRH.TTL_LSS_NO,MWRH.WRTF_NO" ).append("\n"); 
		query.append("ORDER BY MTLRH.TTL_LSS_NO,MWRH.WRTF_NO" ).append("\n"); 

	}
}