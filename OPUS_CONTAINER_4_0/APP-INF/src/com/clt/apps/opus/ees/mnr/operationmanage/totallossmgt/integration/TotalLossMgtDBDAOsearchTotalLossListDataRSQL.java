/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TotalLossMgtDBDAOsearchTotalLossListDataRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.31
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.05.31 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TotalLossMgtDBDAOsearchTotalLossListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchTotalLossListData
	  * </pre>
	  */
	public TotalLossMgtDBDAOsearchTotalLossListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("in_rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.integration").append("\n");
		query.append("FileName : TotalLossMgtDBDAOsearchTotalLossListDataRSQL").append("\n");
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
		query.append("A.TTL_LSS_NO" ).append("\n");
		query.append(",MAX(A.RQST_OFC_CD) RQST_OFC_CD" ).append("\n");
		query.append(",MAX(A.APRO_OFC_CD) APRO_OFC_CD" ).append("\n");
		query.append(",MAX(DECODE(A.RESPB_OFC_CD,null,A.RQST_OFC_CD,'',A.RQST_OFC_CD,A.RESPB_OFC_CD)) AS RESPB_OFC_CD" ).append("\n");
		query.append(",TO_CHAR(MAX(A.TTL_LSS_DT), 'yyyy-mm-dd') TTL_LSS_DT" ).append("\n");
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), MAX(A.RQST_DT),@[user_ofc_cd]), 'yyyy-mm-dd') RQST_DT" ).append("\n");
		query.append(",MAX(A.TTL_LSS_STS_CD) TTL_LSS_STS_CD" ).append("\n");
		query.append(",MAX(A.MNR_STS_REF_NO) MNR_STS_REF_NO" ).append("\n");
		query.append(",MAX(A.TTL_LSS_CMPL_CD) TTL_LSS_CMPL_CD" ).append("\n");
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),MAX(A.TTL_LSS_CFM_DT),@[user_ofc_cd]), 'yyyy-mm-dd') TTL_LSS_CFM_DT" ).append("\n");
		query.append(",MAX(A.TTL_LSS_CFM_ID) TTL_LSS_CFM_ID" ).append("\n");
		query.append(",MAX(A.TTL_LSS_RSN_CD) TTL_LSS_RSN_CD" ).append("\n");
		query.append(",MAX(A.TTL_LSS_DTL_RSN_CD) TTL_LSS_DTL_RSN_CD" ).append("\n");
		query.append(",MAX((SELECT MNR_CD_DP_DESC" ).append("\n");
		query.append("FROM MNR_GEN_CD" ).append("\n");
		query.append("WHERE PRNT_CD_ID=A.TTL_LSS_RSN_CD" ).append("\n");
		query.append("AND MNR_CD_ID=A.TTL_LSS_DTL_RSN_CD" ).append("\n");
		query.append(")) AS TTL_LSS_DTL_RSN_NM" ).append("\n");
		query.append(",MAX(A.TTL_LSS_RMK) TTL_LSS_RMK" ).append("\n");
		query.append(",MAX(A.FILE_SEQ) FILE_SEQ" ).append("\n");
		query.append(",MAX(A.CRE_USR_ID) CRE_USR_ID" ).append("\n");
		query.append(",TO_CHAR(MAX(A.CRE_DT), 'yyyy-mm-dd') CRE_DT" ).append("\n");
		query.append(",MAX(A.UPD_USR_ID) UPD_USR_ID" ).append("\n");
		query.append(",TO_CHAR(MAX(A.UPD_DT), 'yyyy-mm-dd') UPD_DT" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'DV', 1)) DV_EQ_QTY" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'DV', B.DPC_VAL_AMT)) DV_DV_VAL" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'DV', TTL_LSS_BIL_AMT)) DV_EXP" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'DV', B.DPC_VAL_AMT)) - SUM(DECODE(B.MNR_INV_TP_CD, 'DV', B.TTL_LSS_BIL_AMT)) DV_BAL" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'TP', 1)) TP_EQ_QTY" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'TP', B.DPC_VAL_AMT)) TP_DV_VAL" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'TP', TTL_LSS_BIL_AMT)) TP_EXP" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'TP', B.DPC_VAL_AMT)) - SUM(DECODE(B.MNR_INV_TP_CD, 'DV', B.TTL_LSS_BIL_AMT)) TP_BAL" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'DS', 1)) DS_EQ_QTY" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'DS', B.DPC_VAL_AMT)) DS_DV_VAL" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'DS', TTL_LSS_BIL_AMT)) DS_EXP" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'DS', B.DPC_VAL_AMT)) - SUM(DECODE(B.MNR_INV_TP_CD, 'DV', B.TTL_LSS_BIL_AMT)) DS_VAL" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'SC', 1)) SC_EQ_QTY" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'SC', B.DPC_VAL_AMT)) SC_DV_VAL" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'SC', TTL_LSS_INCM_AMT)) + SUM(DECODE(B.MNR_INV_TP_CD, 'SC', NVL(B.TTL_LSS_EXPN_AMT,0))) SC_EXP" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'SC', B.DPC_VAL_AMT)) - SUM(DECODE(B.MNR_INV_TP_CD, 'DV', B.TTL_LSS_BIL_AMT)) SC_VAL" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'IR', 1)) IR_EQ_QTY" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'IR', B.DPC_VAL_AMT)) IR_DV_VAL" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'IR', TTL_LSS_EXPN_AMT)) IR_EXP" ).append("\n");
		query.append(",SUM(DECODE(B.MNR_INV_TP_CD, 'IR', B.DPC_VAL_AMT)) - SUM(DECODE(B.MNR_INV_TP_CD, 'DV', B.TTL_LSS_BIL_AMT)) IR_VAL" ).append("\n");
		query.append("FROM MNR_TTL_LSS_RQST_HDR A, MNR_TTL_LSS_RQST_DTL B" ).append("\n");
		query.append("WHERE" ).append("\n");
		query.append("A.TTL_LSS_NO = B.TTL_LSS_NO(+)" ).append("\n");
		query.append("#if (${in_search_dt_tp} == 'R')" ).append("\n");
		query.append("AND A.RQST_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[in_st_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[in_end_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n");
		query.append("#elseif (${in_search_dt_tp} == 'T')" ).append("\n");
		query.append("AND A.TTL_LSS_DT BETWEEN TO_DATE(@[in_st_dt], 'yyyy-mm-dd') AND TO_DATE(@[in_end_dt], 'yyyy-mm-dd')+0.99999" ).append("\n");
		query.append("#elseif (${in_search_dt_tp} == 'C')" ).append("\n");
		query.append("AND A.TTL_LSS_CFM_DT BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd],TO_DATE(@[in_st_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], TO_DATE(@[in_end_dt], 'yyyy-mm-dd'),MNR_COMMON_PKG.MNR_GET_HOOFC_FNC())+0.99999" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${work_type} == 'collection')" ).append("\n");
		query.append("#if (${rhq_ofc_cd} != 'NYCNA')" ).append("\n");
		query.append("#if (${in_ofc_cd_tp} == 'R')" ).append("\n");
		query.append("AND (A.RQST_OFC_CD = @[in_rqst_ofc_cd]  OR A.RESPB_OFC_CD = @[in_rqst_ofc_cd])" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("AND A.APRO_OFC_CD = @[in_rqst_ofc_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("#if (${in_ofc_cd_tp} == 'R')" ).append("\n");
		query.append("AND (A.RQST_OFC_CD IN (SELECT OFC_CD" ).append("\n");
		query.append("FROM MNR_OFC_GEN_INFO" ).append("\n");
		query.append("WHERE COST_CD = 'RPRINV'" ).append("\n");
		query.append("AND MNR_GRP_TP_CD = 'OFC')" ).append("\n");
		query.append("OR A.RESPB_OFC_CD IN (SELECT OFC_CD" ).append("\n");
		query.append("FROM MNR_OFC_GEN_INFO" ).append("\n");
		query.append("WHERE COST_CD = 'RPRINV'" ).append("\n");
		query.append("AND MNR_GRP_TP_CD = 'OFC'))" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("AND (A.APRO_OFC_CD IN (SELECT OFC_CD" ).append("\n");
		query.append("FROM MNR_OFC_GEN_INFO" ).append("\n");
		query.append("WHERE COST_CD = 'RPRINV'" ).append("\n");
		query.append("AND MNR_GRP_TP_CD = 'OFC'))" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${in_status_tp} == 'P')" ).append("\n");
		query.append("AND A.TTL_LSS_STS_CD IN ('HA','HC')" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("AND A.TTL_LSS_STS_CD IN ('HE')" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#elseif (${work_type} == 'management')" ).append("\n");
		query.append("AND A.TTL_LSS_STS_CD IN ('HR')" ).append("\n");
		query.append("AND A.APRO_OFC_CD = @[in_rqst_ofc_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${in_ttl_lss_no} != '')" ).append("\n");
		query.append("AND A.TTL_LSS_NO IN (" ).append("\n");
		query.append("#foreach ($userTtlNo IN ${ttlNos})" ).append("\n");
		query.append("#if($velocityCount < $ttlNos.size())" ).append("\n");
		query.append("'$userTtlNo'," ).append("\n");
		query.append("#else" ).append("\n");
		query.append("'$userTtlNo'" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#end" ).append("\n");
		query.append(")" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${in_rqst_eq_no} != '')" ).append("\n");
		query.append("AND B.RQST_EQ_NO IN (" ).append("\n");
		query.append("#foreach ($user_eq_no IN ${eqNos})" ).append("\n");
		query.append("#if($velocityCount < $eqNos.size())" ).append("\n");
		query.append("'$user_eq_no'," ).append("\n");
		query.append("#else" ).append("\n");
		query.append("'$user_eq_no'" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#end" ).append("\n");
		query.append(")" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("GROUP BY A.TTL_LSS_NO" ).append("\n");

	}
}