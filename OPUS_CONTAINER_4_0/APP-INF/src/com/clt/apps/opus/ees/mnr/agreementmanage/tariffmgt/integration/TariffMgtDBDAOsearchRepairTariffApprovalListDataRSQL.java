/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TariffMgtDBDAOsearchRepairTariffApprovalListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffMgtDBDAOsearchRepairTariffApprovalListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public TariffMgtDBDAOsearchRepairTariffApprovalListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("eff_dt_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration").append("\n"); 
		query.append("FileName : TariffMgtDBDAOsearchRepairTariffApprovalListDataRSQL").append("\n"); 
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
		query.append("SELECT B.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("     , A.RQST_OFC_CD" ).append("\n"); 
		query.append("     , A.TRF_NO" ).append("\n"); 
		query.append("     , A.EQ_KND_CD" ).append("\n"); 
		query.append("     , (SELECT MNR_CD_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00002' AND MNR_CD_ID = A.EQ_KND_CD) EQ_KND_NM" ).append("\n"); 
		query.append("     , MNR_COMMON_PKG.MNR_CONV_PARTNER_CD_FNC(A.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append("     , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ) VNDR_NM" ).append("\n"); 
		query.append("	 , C.DRY" ).append("\n"); 
		query.append("	 , C.REEFER_BOX" ).append("\n"); 
		query.append("	 , C.REEFER_UNIT" ).append("\n"); 
		query.append("	 , C.SPECIAL_DRY" ).append("\n"); 
		query.append("	 , C.CHASSIS" ).append("\n"); 
		query.append("	 , C.GENSET" ).append("\n"); 
		query.append("	 , C.TOTAL_RATIO" ).append("\n"); 
		query.append("     , TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("     , A.MNR_TRF_STS_CD" ).append("\n"); 
		query.append("     , (SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'CD00007' AND MNR_CD_ID = A.MNR_TRF_STS_CD) MNR_TRF_STS_NM" ).append("\n"); 
		query.append("     , TO_CHAR(A.MNR_TRF_STS_DT,'YYYY-MM-DD') MNR_TRF_STS_DT" ).append("\n"); 
		query.append("     , MNR_COMMON_PKG.MNR_CONV_AGMT_NO_FNC(D.AGMT_OFC_CTY_CD, D.AGMT_SEQ) AS AGMT_NO" ).append("\n"); 
		query.append("     , A.APRO_OFC_CD" ).append("\n"); 
		query.append("     , A.UPD_USR_ID  AS APRO_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(A.UPD_DT,'YYYY-MM-DD')  AS APRO_DT" ).append("\n"); 
		query.append("     , A.MNR_TRF_RMK" ).append("\n"); 
		query.append("  FROM MNR_RPR_TRF_HDR A" ).append("\n"); 
		query.append("     , MDM_ORGANIZATION B" ).append("\n"); 
		query.append("	 , (" ).append("\n"); 
		query.append("		SELECT A.TRF_NO," ).append("\n"); 
		query.append("		       SUM(DECODE(B.COST_GRP_CD, 'MRDR', DECODE(NVL(B.MTRL_COST_AMT,0), 0, 0, 1)))||MAX(DECODE(B.COST_GRP_CD, 'MRDR', '/'))||SUM(DECODE(B.COST_GRP_CD, 'MRDR', 1)) DRY," ).append("\n"); 
		query.append("		       SUM(DECODE(B.COST_GRP_CD, 'MRRF', DECODE(NVL(B.MTRL_COST_AMT,0), 0, 0, 1)))||MAX(DECODE(B.COST_GRP_CD, 'MRRF', '/'))||SUM(DECODE(B.COST_GRP_CD, 'MRRF', 1)) REEFER_BOX," ).append("\n"); 
		query.append("		       SUM(DECODE(B.COST_GRP_CD, 'MRRU', DECODE(NVL(B.MTRL_COST_AMT,0), 0, 0, 1)))||MAX(DECODE(B.COST_GRP_CD, 'MRRU', '/'))||SUM(DECODE(B.COST_GRP_CD, 'MRRU', 1)) REEFER_UNIT," ).append("\n"); 
		query.append("		       SUM(DECODE(B.COST_GRP_CD, 'MRDS', DECODE(NVL(B.MTRL_COST_AMT,0), 0, 0, 1)))||MAX(DECODE(B.COST_GRP_CD, 'MRDS', '/'))||SUM(DECODE(B.COST_GRP_CD, 'MRDS', 1)) SPECIAL_DRY," ).append("\n"); 
		query.append("		       SUM(DECODE(B.COST_GRP_CD, 'MRZS', DECODE(NVL(B.MTRL_COST_AMT,0), 0, 0, 1)))||MAX(DECODE(B.COST_GRP_CD, 'MRZS', '/'))||SUM(DECODE(B.COST_GRP_CD, 'MRZS', 1)) CHASSIS," ).append("\n"); 
		query.append("		       SUM(DECODE(B.COST_GRP_CD, 'MRGS', DECODE(NVL(B.MTRL_COST_AMT,0), 0, 0, 1)))||MAX(DECODE(B.COST_GRP_CD, 'MRGS', '/'))||SUM(DECODE(B.COST_GRP_CD, 'MRGS', 1)) GENSET," ).append("\n"); 
		query.append("		       SUM(DECODE(NVL(B.MTRL_COST_AMT,0), 0, 0, 1))||'/'||COUNT(*) TOTAL_RATIO " ).append("\n"); 
		query.append("		FROM MNR_RPR_TRF_DTL B" ).append("\n"); 
		query.append("		   , MNR_RPR_TRF_HDR A" ).append("\n"); 
		query.append("		WHERE A.TRF_NO = B.TRF_NO" ).append("\n"); 
		query.append("		AND A.MNR_TRF_KND_CD = 'LCL'" ).append("\n"); 
		query.append("		#if (${access_system} != 'SPP')" ).append("\n"); 
		query.append("   		AND A.MNR_TRF_STS_CD IN ('HR','HJ','HA','SR')" ).append("\n"); 
		query.append("   		#else" ).append("\n"); 
		query.append("   		AND A.MNR_TRF_STS_CD NOT IN ('HD','SD')" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 
		query.append("		GROUP BY A.TRF_NO" ).append("\n"); 
		query.append("		) C" ).append("\n"); 
		query.append("      , (SELECT TRF_NO" ).append("\n"); 
		query.append("             , MAX(AGMT_OFC_CTY_CD) AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("             , MAX(AGMT_SEQ) AGMT_SEQ" ).append("\n"); 
		query.append("         FROM MNR_AGMT_HDR " ).append("\n"); 
		query.append("        WHERE AGMT_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("          AND SYSDATE BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("        GROUP BY TRF_NO " ).append("\n"); 
		query.append("        )D" ).append("\n"); 
		query.append(" WHERE A.RQST_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("   AND A.TRF_NO      = C.TRF_NO" ).append("\n"); 
		query.append("   AND A.TRF_NO      = D.TRF_NO(+)" ).append("\n"); 
		query.append("   AND A.MNR_TRF_KND_CD = 'LCL'" ).append("\n"); 
		query.append("   #if (${access_system} != 'SPP')" ).append("\n"); 
		query.append("   AND A.MNR_TRF_STS_CD IN ('HR','HJ','HA','SR')" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("   AND A.MNR_TRF_STS_CD NOT IN ('HD','SD')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${ar_hd_qtr_ofc_cd} != 'A' && ${ar_hd_qtr_ofc_cd} != '') " ).append("\n"); 
		query.append("   AND B.AR_HD_QTR_OFC_CD = @[ar_hd_qtr_ofc_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if (${rqst_ofc_cd} != 'A' && ${rqst_ofc_cd} != '') " ).append("\n"); 
		query.append("   AND A.RQST_OFC_CD = @[rqst_ofc_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${eq_knd_cd} != 'A') " ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${mnr_trf_sts_cd} != 'A') " ).append("\n"); 
		query.append("   AND A.MNR_TRF_STS_CD = @[mnr_trf_sts_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${vndr_seq} != '') " ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${eff_dt_fr} != '' && ${eff_dt_to} != '') " ).append("\n"); 
		query.append("   AND TO_CHAR(A.EFF_DT, 'YYYY') BETWEEN @[eff_dt_fr] AND @[eff_dt_to]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY A.CRE_DT DESC, A.TRF_NO DESC" ).append("\n"); 

	}
}