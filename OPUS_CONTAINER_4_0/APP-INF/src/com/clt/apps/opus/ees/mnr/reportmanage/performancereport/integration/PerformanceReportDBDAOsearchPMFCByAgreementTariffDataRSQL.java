/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOsearchPMFCByAgreementTariffDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.12.23 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOsearchPMFCByAgreementTariffDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 - [EES_MNR_0236] MNR PFMC by Agreement/Tariff
	  * </pre>
	  */
	public PerformanceReportDBDAOsearchPMFCByAgreementTariffDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_cmpo_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_trf_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_rpr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_hd_qtr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOsearchPMFCByAgreementTariffDataRSQL").append("\n"); 
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
		query.append("SELECT A.TRF_NO" ).append("\n"); 
		query.append(", B.COST_GRP_CD" ).append("\n"); 
		query.append(", (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CC' AND MNR_CD_ID = B.COST_GRP_CD) AS COST_GRP_NM" ).append("\n"); 
		query.append(", B.EQ_CMPO_CD" ).append("\n"); 
		query.append(", B.EQ_RPR_CD" ).append("\n"); 
		query.append(", B.TRF_DIV_CD" ).append("\n"); 
		query.append(", C.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append(", A.RQST_OFC_CD" ).append("\n"); 
		query.append(", MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append(", (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ) AS VNDR_NM" ).append("\n"); 
		query.append(", B.RPR_LBR_HRS" ).append("\n"); 
		query.append(", DECODE(@[curr_cd], 'Y', 'USD', A.CURR_CD) CURR_CD" ).append("\n"); 
		query.append(", B.MTRL_RECO_AMT" ).append("\n"); 
		query.append(", MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), A.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', A.CURR_CD), B.MTRL_COST_AMT) MTRL_COST_AMT" ).append("\n"); 
		query.append(", A.MNR_TRF_STS_CD" ).append("\n"); 
		query.append(", (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00007' AND MNR_CD_ID = A.MNR_TRF_STS_CD) AS MNR_TRF_STS_NM" ).append("\n"); 
		query.append(", MNR_COMMON_PKG.MNR_CONV_AGMT_NO_FNC(D.AGMT_OFC_CTY_CD, D.AGMT_SEQ) AS AGMT_NO" ).append("\n"); 
		query.append(", DECODE(@[curr_cd], 'Y', 'USD', D.CURR_CD) AGMT_CURR_CD" ).append("\n"); 
		query.append(", MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(SYSDATE, 'YYYYMM'), D.CURR_CD, DECODE(@[curr_cd], 'Y', 'USD', D.CURR_CD), E.AGMT_RT_AMT) AGMT_RT_AMT" ).append("\n"); 
		query.append("FROM MNR_RPR_TRF_HDR A" ).append("\n"); 
		query.append(", MNR_RPR_TRF_DTL B" ).append("\n"); 
		query.append(", MDM_ORGANIZATION C" ).append("\n"); 
		query.append(", (SELECT    TRF_NO" ).append("\n"); 
		query.append(", MAX(AGMT_OFC_CTY_CD) AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(", MAX(AGMT_SEQ) AGMT_SEQ" ).append("\n"); 
		query.append(", MAX(AGMT_VER_NO) AGMT_VER_NO" ).append("\n"); 
		query.append(", MAX(CURR_CD) CURR_CD" ).append("\n"); 
		query.append("FROM MNR_AGMT_HDR" ).append("\n"); 
		query.append("WHERE AGMT_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND SYSDATE BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("GROUP BY TRF_NO" ).append("\n"); 
		query.append(")D" ).append("\n"); 
		query.append(", (SELECT AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(", AGMT_SEQ" ).append("\n"); 
		query.append(", AGMT_VER_NO" ).append("\n"); 
		query.append(", AGMT_RT_AMT" ).append("\n"); 
		query.append("FROM MNR_AGMT_RT" ).append("\n"); 
		query.append("WHERE MNR_RT_TP_CD = 'NR'" ).append("\n"); 
		query.append("AND COST_DTL_CD = 'NR'" ).append("\n"); 
		query.append("AND SUBSTR(COST_CD,0,4) = @[cost_grp_cd]" ).append("\n"); 
		query.append(")E" ).append("\n"); 
		query.append("WHERE A.TRF_NO           = B.TRF_NO" ).append("\n"); 
		query.append("AND A.RQST_OFC_CD      = C.OFC_CD" ).append("\n"); 
		query.append("AND A.TRF_NO           = D.TRF_NO(+)" ).append("\n"); 
		query.append("AND D.AGMT_OFC_CTY_CD  = E.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND D.AGMT_SEQ         = E.AGMT_SEQ" ).append("\n"); 
		query.append("AND D.AGMT_VER_NO      = E.AGMT_VER_NO" ).append("\n"); 
		query.append("AND A.MNR_TRF_KND_CD = 'LCL'" ).append("\n"); 
		query.append("AND B.COST_GRP_CD      = @[cost_grp_cd]" ).append("\n"); 
		query.append("AND C.AR_HD_QTR_OFC_CD = @[ar_hd_qtr_ofc_cd]" ).append("\n"); 
		query.append("#if (${rqst_ofc_cd} != 'A')" ).append("\n"); 
		query.append("AND A.RQST_OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_cmpo_cd} != '' && ${eq_cmpo_cd} != 'A')" ).append("\n"); 
		query.append("AND B.EQ_CMPO_CD = @[eq_cmpo_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_rpr_cd} != '' && ${eq_rpr_cd} != 'A')" ).append("\n"); 
		query.append("AND B.EQ_RPR_CD = @[eq_rpr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trf_div_cd} != '' && ${trf_div_cd} != 'A')" ).append("\n"); 
		query.append("AND B.TRF_DIV_CD = @[trf_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mnr_trf_sts_cd} != '' && ${mnr_trf_sts_cd} != 'A')" ).append("\n"); 
		query.append("AND A.MNR_TRF_STS_CD = @[mnr_trf_sts_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.MNR_TRF_STS_CD IN ('HE','HA')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.TRF_NO DESC" ).append("\n"); 

	}
}