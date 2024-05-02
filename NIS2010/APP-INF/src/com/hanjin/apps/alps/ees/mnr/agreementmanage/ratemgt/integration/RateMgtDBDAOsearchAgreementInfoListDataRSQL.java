/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RateMgtDBDAOsearchAgreementInfoListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RateMgtDBDAOsearchAgreementInfoListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * -------------------------------------------------------------------------------------------------------------------------------------------
	  * searchAgreementInfoListData
	  * 2014-03-21 Ticket No : CHM-201429420 Title : ALPS MNR-Agreement-Tariff-Agreement List에 Expiry Date 추가 요청 TD : Jonghee HAN DEV : JongHee HAN -> exp_dt Column 추가
	  * 2014-11-06 CSR ID : CHM-201432660 : ALPS MNR-AGMT_TARIFF 화면에서 GW-Contract Document와 ALPS MNR-AGMT와 Interface된 결과 값을 보여줄수 있도록 구현 : AA Chang Young Kim, DEV 이상근
	  * 2014-12-22 [CHM-201433304] CSR 승인 강화에 따른 ALPS MNR-AGMT에 GW Document Contract Link 관련 추가 요청 사항
	  * -------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public RateMgtDBDAOsearchAgreementInfoListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_eq_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_hd_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration").append("\n"); 
		query.append("FileName : RateMgtDBDAOsearchAgreementInfoListDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(MAX(A.AGMT_OFC_CD)) RHQ_OFC," ).append("\n"); 
		query.append("       MNR_COMMON_PKG.MNR_CONV_AGMT_NO_FNC(A.AGMT_OFC_CTY_CD, A.AGMT_SEQ) AGMT_NO," ).append("\n"); 
		query.append("	   MAX(A.DELT_FLG) DELT_FLG," ).append("\n"); 
		query.append("       MAX(A.AGMT_OFC_CD) AGMT_OFC_CD," ).append("\n"); 
		query.append("       MAX(D.MNR_CD_DP_DESC) MNR_CD_DP_DESC," ).append("\n"); 
		query.append("       MAX(A.AGMT_VER_NO) AGMT_VER_NO," ).append("\n"); 
		query.append("       MAX(A.AGMT_REF_NO) REF_NO," ).append("\n"); 
		query.append("	   MAX(MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.VNDR_SEQ)) VNDR_SEQ," ).append("\n"); 
		query.append("       MAX(A.TRF_NO) TRF_NO," ).append("\n"); 
		query.append("	   MAX(E.VNDR_LGL_ENG_NM) VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("       TO_CHAR(MAX(A.EFF_DT), 'yyyy-mm-dd') EFF_DT," ).append("\n"); 
		query.append("       TO_CHAR(MAX(A.EXP_DT), 'yyyy-mm-dd') EXP_DT," ).append("\n"); 
		query.append("       MAX(DECODE(SUBSTR(C.cost_cd, 5, 2), 'RC', DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) RP_CHK," ).append("\n"); 
		query.append("       MAX(DECODE(SUBSTR(C.cost_cd, 5, 2), 'CL', DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) CL_CHK," ).append("\n"); 
		query.append("       MAX(DECODE(SUBSTR(C.cost_cd, 5, 2), 'SV', DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) SV_CHK," ).append("\n"); 
		query.append("       MAX(DECODE(SUBSTR(C.cost_cd, 5, 2), 'PT', DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) PT_CHK,  " ).append("\n"); 
		query.append("       MAX(DECODE(SUBSTR(C.cost_cd, 5, 2), 'PR', DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) PR_CHK, " ).append("\n"); 
		query.append("       MAX(DECODE(SUBSTR(C.cost_cd, 5, 2), 'TP', DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) TP_CHK, " ).append("\n"); 
		query.append("       MAX(DECODE(SUBSTR(C.cost_cd, 5, 2), 'AD', DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) AD_CHK," ).append("\n"); 
		query.append("       MAX(DECODE(SUBSTR(C.cost_cd, 5, 2), 'OT', DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) OT_CHK,      " ).append("\n"); 
		query.append("	   MAX(DECODE(SUBSTR(C.cost_cd, 5, 2), 'PM', DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) PM_CHK," ).append("\n"); 
		query.append("	   MAX(DECODE(SUBSTR(C.cost_cd, 5, 2), 'HG', DECODE(SIGN(C.AGMT_RT_AMT), 1, 'Y', ''))) HG_CHK," ).append("\n"); 
		query.append("       NVL(MAX(A.FILE_ATCH_FLG), 'N') FILE_ATCH_FLG" ).append("\n"); 
		query.append("FROM  MNR_AGMT_HDR A, MNR_AGMT_APLY_OFC B, MNR_AGMT_RT C, MNR_GEN_CD D, MDM_VENDOR E" ).append("\n"); 
		query.append("WHERE A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   A.AGMT_SEQ        = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND   A.AGMT_VER_NO = B.AGMT_VER_NO" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ = E.VNDR_SEQ" ).append("\n"); 
		query.append("AND   B.AGMT_OFC_CTY_CD = C.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   B.AGMT_SEQ        = C.AGMT_SEQ" ).append("\n"); 
		query.append("AND   B.AGMT_VER_NO     = C.AGMT_VER_NO" ).append("\n"); 
		query.append("AND   A.EQ_KND_CD       = DECODE(@[agmt_eq_type], 'A', A.EQ_KND_CD, @[agmt_eq_type])" ).append("\n"); 
		query.append("AND   A.AGMT_DT BETWEEN TO_DATE(@[agmt_fm_dt], 'yyyy-mm-dd') AND TO_DATE(@[agmt_to_dt], 'yyyy-mm-dd')+0.99999" ).append("\n"); 
		query.append("AND   A.AGMT_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("AND   D.PRNT_CD_ID = 'CD00002'" ).append("\n"); 
		query.append("AND   D.MNR_CD_ID = A.EQ_KND_CD " ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ        = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cost_ofc_cd} != '')" ).append("\n"); 
		query.append("AND   B.AGMT_OFC_TP_CD = 'COST'" ).append("\n"); 
		query.append("AND   B.APLY_OFC_CD LIKE @[cost_ofc_cd]||'%%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ar_hd_qtr_cd} != '')" ).append("\n"); 
		query.append("AND   A.AGMT_OFC_CD IN ( select OFC_CD" ).append("\n"); 
		query.append("                         from mdm_organization" ).append("\n"); 
		query.append("                         where AR_HD_QTR_OFC_CD = @[ar_hd_qtr_cd]" ).append("\n"); 
		query.append("                         and ofc_cd LIKE @[agmt_ofc_cd]||'%%'" ).append("\n"); 
		query.append("                         and delt_flg = 'N'" ).append("\n"); 
		query.append("                       )   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND   A.AGMT_OFC_CD IN ( SELECT D.OFC_CD" ).append("\n"); 
		query.append("                         FROM   MNR_OFC_GEN_INFO D" ).append("\n"); 
		query.append("                         WHERE  D.UPPR_OFC_CD  =  @[agmt_ofc_cd]" ).append("\n"); 
		query.append("                         AND    D.MNR_GRP_TP_CD = 'OFC'" ).append("\n"); 
		query.append("                         AND    D.COST_CD       = 'MR'" ).append("\n"); 
		query.append("                         UNION ALL" ).append("\n"); 
		query.append("                         SELECT @[agmt_ofc_cd]" ).append("\n"); 
		query.append("                         FROM DUAL" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY MNR_COMMON_PKG.MNR_CONV_AGMT_NO_FNC(A.AGMT_OFC_CTY_CD, A.AGMT_SEQ)" ).append("\n"); 

	}
}