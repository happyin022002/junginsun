/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchSiTurnTimeSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchSiTurnTimeSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SI Turn Time Report - Summary를 조회한다.
	  * 2012.01.05 정선용 [CHM-201115236-01] DPCS S/I Turn Time Report 수정 요청
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchSiTurnTimeSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_amd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atnd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpcs_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tvvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchSiTurnTimeSummaryRSQL").append("\n"); 
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
		query.append("SELECT NVL(S.RGN_OFC_CD_DESC,'Total') RGN_OFC_CD," ).append("\n"); 
		query.append("       SUM(DISTINCT P.TTL_SR_CNT) TTL_SR,       " ).append("\n"); 
		query.append("       BKG_GET_CONV_INTVAL_TIME_FNC(SUM(IDL_TO_ID + ID_ACT_TM +IDL_TO_RD + RD_ACT_TM + IDL_TO_AD + AD_ACT_TM + IDL_TO_RR + IDL_TO_PN)" ).append("\n"); 
		query.append("        /SUM(DISTINCT P.TTL_SR_CNT),'HMS') TTL_TT," ).append("\n"); 
		query.append("       SUM(DISTINCT P.TTL_PIC_CNT) TTL_PIC, " ).append("\n"); 
		query.append("       BKG_GET_CONV_INTVAL_TIME_FNC(SUM(ID_BIZ_TM + RD_BIZ_TM + AD_BIZ_TM)/SUM(DISTINCT P.TTL_SR_CNT),'HMS') TTL_BIZ_TT," ).append("\n"); 
		query.append("       BKG_GET_CONV_INTVAL_TIME_FNC(SUM(ID_ACT_TM + RD_ACT_TM + AD_ACT_TM)/SUM(DISTINCT P.TTL_SR_CNT),'HMS') TTL_ACT_TT," ).append("\n"); 
		query.append("       BKG_GET_CONV_INTVAL_TIME_FNC(SUM(IDL_TO_ID + IDL_TO_RD + IDL_TO_AD + IDL_TO_RR + IDL_TO_PN)/SUM(DISTINCT P.TTL_SR_CNT),'HMS') TTL_IDL_TT," ).append("\n"); 
		query.append("       BKG_GET_CONV_INTVAL_TIME_FNC(SUM(ID_OVT + RD_OVT + AD_OVT)/SUM(DISTINCT P.TTL_SR_CNT),'HMS') TTL_OVT_TT," ).append("\n"); 
		query.append("       SUM(DISTINCT P.ID_SR_CNT) ID_SR_CNT,      " ).append("\n"); 
		query.append("       SUM(DISTINCT P.ID_USR_CNT)     ID_PIC," ).append("\n"); 
		query.append("       DECODE(SUM(ID_CNT),0,NULL,BKG_GET_CONV_INTVAL_TIME_FNC(SUM(IDL_TO_ID + ID_ACT_TM)/SUM(ID_CNT),'HMS')) ID_TT," ).append("\n"); 
		query.append("       DECODE(SUM(ID_CNT),0,NULL,BKG_GET_CONV_INTVAL_TIME_FNC(SUM(IDL_TO_ID)/SUM(ID_CNT),'HMS')) IDL_TO_ID," ).append("\n"); 
		query.append("       DECODE(SUM(ID_CNT),0,NULL,BKG_GET_CONV_INTVAL_TIME_FNC(SUM(ID_BIZ_TM)/SUM(ID_CNT),'HMS')) ID_BIZ_TM," ).append("\n"); 
		query.append("       DECODE(SUM(ID_CNT),0,NULL,BKG_GET_CONV_INTVAL_TIME_FNC(SUM(ID_ACT_TM)/SUM(ID_CNT),'HMS')) ID_ACT_TM," ).append("\n"); 
		query.append("       DECODE(SUM(ID_CNT),0,NULL,BKG_GET_CONV_INTVAL_TIME_FNC(SUM(ID_OVT)/SUM(ID_CNT),'HMS'))    ID_OVT, " ).append("\n"); 
		query.append("       SUM(DISTINCT P.RD_SR_CNT) RD_SR_CNT,          " ).append("\n"); 
		query.append("       SUM(DISTINCT P.RD_USR_CNT)     RD_PIC, " ).append("\n"); 
		query.append("       DECODE(SUM(RD_CNT),0,NULL,BKG_GET_CONV_INTVAL_TIME_FNC(SUM(IDL_TO_RD + RD_ACT_TM)/SUM(RD_CNT),'HMS')) RD_TT," ).append("\n"); 
		query.append("       DECODE(SUM(RD_CNT),0,NULL,BKG_GET_CONV_INTVAL_TIME_FNC(SUM(IDL_TO_RD)/SUM(RD_CNT),'HMS')) IDL_TO_RD," ).append("\n"); 
		query.append("       DECODE(SUM(RD_CNT),0,NULL,BKG_GET_CONV_INTVAL_TIME_FNC(SUM(RD_BIZ_TM)/SUM(RD_CNT),'HMS')) RD_BIZ_TM," ).append("\n"); 
		query.append("       DECODE(SUM(RD_CNT),0,NULL,BKG_GET_CONV_INTVAL_TIME_FNC(SUM(RD_ACT_TM)/SUM(RD_CNT),'HMS')) RD_ACT_TM," ).append("\n"); 
		query.append("       DECODE(SUM(RD_CNT),0,NULL,BKG_GET_CONV_INTVAL_TIME_FNC(SUM(RD_OVT)/SUM(RD_CNT),'HMS'))    RD_OVT," ).append("\n"); 
		query.append("       SUM(DISTINCT P.AD_SR_CNT) AD_SR_CNT,    " ).append("\n"); 
		query.append("       SUM(DISTINCT P.AD_USR_CNT)     AD_PIC,  " ).append("\n"); 
		query.append("       DECODE(SUM(AD_CNT),0,NULL,BKG_GET_CONV_INTVAL_TIME_FNC(SUM(IDL_TO_AD + AD_ACT_TM)/SUM(AD_CNT),'HMS')) AD_TT," ).append("\n"); 
		query.append("       DECODE(SUM(AD_CNT),0,NULL,BKG_GET_CONV_INTVAL_TIME_FNC(SUM(IDL_TO_AD)/SUM(AD_CNT),'HMS')) IDL_TO_AD," ).append("\n"); 
		query.append("       DECODE(SUM(AD_CNT),0,NULL,BKG_GET_CONV_INTVAL_TIME_FNC(SUM(AD_BIZ_TM)/SUM(AD_CNT),'HMS')) AD_BIZ_TM," ).append("\n"); 
		query.append("       DECODE(SUM(AD_CNT),0,NULL,BKG_GET_CONV_INTVAL_TIME_FNC(SUM(AD_ACT_TM)/SUM(AD_CNT),'HMS')) AD_ACT_TM," ).append("\n"); 
		query.append("       DECODE(SUM(AD_CNT),0,NULL,BKG_GET_CONV_INTVAL_TIME_FNC(SUM(AD_OVT)/SUM(AD_CNT),'HMS'))    AD_OVT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT  R.SR_NO, R.BKG_NO, R.SR_AMD_TP_CD, " ).append("\n"); 
		query.append("                R.SR_KND_CD, R.SR_AMD_SEQ, B.BKG_OFC_CD, S.RGN_OFC_CD," ).append("\n"); 
		query.append("                (SELECT C.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("                 FROM COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("                 WHERE C.INTG_CD_ID = 'CD02405'" ).append("\n"); 
		query.append("                 AND C.INTG_CD_VAL_CTNT = S.RGN_OFC_CD" ).append("\n"); 
		query.append("                 AND ROWNUM = 1) RGN_OFC_CD_DESC, " ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'ID',SR_WRK_TM_IDLE_HRS  + SR_OVT_IDLE_HRS,0)) IDL_TO_ID," ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'ID',BL_DOC_WRK_HRS,0)) ID_BIZ_TM," ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'ID',SR_PROC_HRS,0)) ID_ACT_TM," ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'ID',BL_DOC_OVT_HRS,0)) ID_OVT," ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'ID',1,0)) ID_CNT," ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'RD',SR_WRK_TM_IDLE_HRS  + SR_OVT_IDLE_HRS,0)) IDL_TO_RD," ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'RD',BL_DOC_WRK_HRS,0)) RD_BIZ_TM," ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'RD',SR_PROC_HRS,0)) RD_ACT_TM," ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'RD',BL_DOC_OVT_HRS,0)) RD_OVT," ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'RD',1,0)) RD_CNT," ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'AD',SR_WRK_TM_IDLE_HRS  + SR_OVT_IDLE_HRS,0)) IDL_TO_AD," ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'AD',BL_DOC_WRK_HRS,0)) AD_BIZ_TM," ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'AD',SR_PROC_HRS,0)) AD_ACT_TM," ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'AD',BL_DOC_OVT_HRS,0)) AD_OVT," ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'AD',1,0)) AD_CNT," ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'RR',SR_WRK_TM_IDLE_HRS  + SR_OVT_IDLE_HRS,0)) IDL_TO_RR," ).append("\n"); 
		query.append("                SUM(DECODE(H.SR_STS_CD,'PN',SR_WRK_TM_IDLE_HRS  + SR_OVT_IDLE_HRS,0)) IDL_TO_PN" ).append("\n"); 
		query.append("        FROM BKG_SR_CRNT_RQST R, BKG_BOOKING B, BKG_SR_HIS H," ).append("\n"); 
		query.append("             (SELECT BKG_OFC_CD, RGN_OFC_CD" ).append("\n"); 
		query.append("              FROM (SELECT DISTINCT BKG_OFC_CD, RGN_OFC_CD, delt_flg," ).append("\n"); 
		query.append("                           RANK() OVER (PARTITION BY BKG_OFC_CD ORDER BY DELT_FLG, RGN_OFC_CD) RNK" ).append("\n"); 
		query.append("                    FROM BKG_EML_ACCT_STUP)" ).append("\n"); 
		query.append("              WHERE RNK = 1) S" ).append("\n"); 
		query.append("#if (${sr_no} != '')" ).append("\n"); 
		query.append("        WHERE R.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${tvvd} != '')" ).append("\n"); 
		query.append("        WHERE R.BKG_NO IN (SELECT BKG_NO" ).append("\n"); 
		query.append("                           FROM BKG_BOOKING" ).append("\n"); 
		query.append("                           WHERE VSL_CD = SUBSTR(@[tvvd],1,4)" ).append("\n"); 
		query.append("                           AND SKD_VOY_NO = SUBSTR(@[tvvd],5,4)" ).append("\n"); 
		query.append("                           AND SKD_DIR_CD = SUBSTR(@[tvvd],9,1))" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("        WHERE R.FNT_OFC_TRNS_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.999999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${si_sts} == 'C')	" ).append("\n"); 
		query.append("        AND (NVL(R.BL_DOC_INP_FLG,'N') = 'Y' AND NVL(R.BL_RT_FLG,'N') = 'Y' AND NVL(R.BL_AUD_FLG,'N') = 'Y')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${si_sts} == 'P')	" ).append("\n"); 
		query.append("        AND (NVL(R.BL_DOC_INP_FLG,'N') <> 'Y' OR NVL(R.BL_RT_FLG,'N') <> 'Y' OR NVL(R.BL_AUD_FLG,'N') <> 'Y')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("        AND R.DPCS_OFC_CD = NVL(@[dpcs_ofc_cd],R.DPCS_OFC_CD)" ).append("\n"); 
		query.append("        AND S.RGN_OFC_CD = DECODE(@[rgn_ofc_cd], 'A',S.RGN_OFC_CD, @[rgn_ofc_cd])" ).append("\n"); 
		query.append("        AND B.BKG_OFC_CD = NVL(@[bkg_ofc_cd], B.BKG_OFC_CD)" ).append("\n"); 
		query.append("        AND R.SR_AMD_TP_CD = DECODE(@[sr_amd_tp_cd], 'L', R.SR_AMD_TP_CD, @[sr_amd_tp_cd])" ).append("\n"); 
		query.append("        AND H.ATND_USR_ID = NVL(@[atnd_usr_id], H.ATND_USR_ID)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND B.BKG_OFC_CD = S.BKG_OFC_CD" ).append("\n"); 
		query.append("        AND R.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("        AND R.SR_KND_CD = H.SR_KND_CD" ).append("\n"); 
		query.append("        AND R.SR_NO = H.SR_NO" ).append("\n"); 
		query.append("        AND R.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("        AND H.SR_STS_CD IN( 'ID', 'RD', 'AD', 'RR', 'PN')" ).append("\n"); 
		query.append("        GROUP BY R.SR_NO, R.BKG_NO, R.SR_AMD_TP_CD, R.SR_AMD_SEQ," ).append("\n"); 
		query.append("                R.SR_KND_CD, S.RGN_OFC_CD, B.BKG_OFC_CD, R.FNT_OFC_TRNS_DT) S, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (SELECT S.RGN_OFC_CD," ).append("\n"); 
		query.append("                COUNT(DISTINCT ATND_USR_ID) TTL_PIC_CNT, " ).append("\n"); 
		query.append("                COUNT(DISTINCT DECODE(H.SR_STS_CD,'ID',ATND_USR_ID, NULL))ID_USR_CNT, " ).append("\n"); 
		query.append("                COUNT(DISTINCT DECODE(H.SR_STS_CD,'RD',ATND_USR_ID, NULL))RD_USR_CNT, " ).append("\n"); 
		query.append("                COUNT(DISTINCT DECODE(H.SR_STS_CD,'AD',ATND_USR_ID, NULL))AD_USR_CNT," ).append("\n"); 
		query.append("                COUNT(DISTINCT H.SR_KND_CD||H.SR_NO||H.BKG_NO) TTL_SR_CNT," ).append("\n"); 
		query.append("                COUNT(DISTINCT DECODE(H.SR_STS_CD,'ID',H.SR_KND_CD||H.SR_NO||H.BKG_NO, NULL)) ID_SR_CNT," ).append("\n"); 
		query.append("                COUNT(DISTINCT DECODE(H.SR_STS_CD,'RD',H.SR_KND_CD||H.SR_NO||H.BKG_NO, NULL)) RD_SR_CNT," ).append("\n"); 
		query.append("                COUNT(DISTINCT DECODE(H.SR_STS_CD,'AD',H.SR_KND_CD||H.SR_NO||H.BKG_NO, NULL)) AD_SR_CNT " ).append("\n"); 
		query.append("        FROM BKG_SR_CRNT_RQST R, BKG_BOOKING B, BKG_SR_HIS H," ).append("\n"); 
		query.append("             (SELECT BKG_OFC_CD, RGN_OFC_CD" ).append("\n"); 
		query.append("              FROM (SELECT DISTINCT BKG_OFC_CD, RGN_OFC_CD, delt_flg," ).append("\n"); 
		query.append("                           RANK() OVER (PARTITION BY BKG_OFC_CD ORDER BY DELT_FLG, RGN_OFC_CD) RNK" ).append("\n"); 
		query.append("                    FROM BKG_EML_ACCT_STUP)" ).append("\n"); 
		query.append("              WHERE RNK = 1) S" ).append("\n"); 
		query.append("#if (${sr_no} != '')" ).append("\n"); 
		query.append("        WHERE R.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${tvvd} != '')" ).append("\n"); 
		query.append("        WHERE R.BKG_NO IN (SELECT BKG_NO" ).append("\n"); 
		query.append("                           FROM BKG_BOOKING" ).append("\n"); 
		query.append("                           WHERE VSL_CD = SUBSTR(@[tvvd],1,4)" ).append("\n"); 
		query.append("                           AND SKD_VOY_NO = SUBSTR(@[tvvd],5,4)" ).append("\n"); 
		query.append("                           AND SKD_DIR_CD = SUBSTR(@[tvvd],9,1))" ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("        WHERE R.FNT_OFC_TRNS_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.999999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${si_sts} == 'C')	" ).append("\n"); 
		query.append("        AND (NVL(R.BL_DOC_INP_FLG,'N') = 'Y' AND NVL(R.BL_RT_FLG,'N') = 'Y' AND NVL(R.BL_AUD_FLG,'N') = 'Y')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${si_sts} == 'P')	" ).append("\n"); 
		query.append("        AND (NVL(R.BL_DOC_INP_FLG,'N') <> 'Y' OR NVL(R.BL_RT_FLG,'N') <> 'Y' OR NVL(R.BL_AUD_FLG,'N') <> 'Y')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("        AND R.DPCS_OFC_CD = NVL(@[dpcs_ofc_cd],R.DPCS_OFC_CD)" ).append("\n"); 
		query.append("        AND S.RGN_OFC_CD = DECODE(@[rgn_ofc_cd], 'A',S.RGN_OFC_CD, @[rgn_ofc_cd])" ).append("\n"); 
		query.append("        AND B.BKG_OFC_CD = NVL(@[bkg_ofc_cd], B.BKG_OFC_CD)" ).append("\n"); 
		query.append("        AND R.SR_AMD_TP_CD = DECODE(@[sr_amd_tp_cd], 'L', R.SR_AMD_TP_CD, @[sr_amd_tp_cd])" ).append("\n"); 
		query.append("        AND H.ATND_USR_ID = NVL(@[atnd_usr_id], H.ATND_USR_ID)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND B.BKG_OFC_CD = S.BKG_OFC_CD" ).append("\n"); 
		query.append("        AND R.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("        AND R.SR_KND_CD = H.SR_KND_CD" ).append("\n"); 
		query.append("        AND R.SR_NO = H.SR_NO" ).append("\n"); 
		query.append("        AND R.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("        AND H.SR_STS_CD IN( 'ID', 'RD', 'AD')" ).append("\n"); 
		query.append("        GROUP BY S.RGN_OFC_CD) P" ).append("\n"); 
		query.append("WHERE S.RGN_OFC_CD = P.RGN_OFC_CD" ).append("\n"); 
		query.append("GROUP BY ROLLUP(S.RGN_OFC_CD_DESC)" ).append("\n"); 
		query.append("ORDER BY S.RGN_OFC_CD_DESC" ).append("\n"); 
		query.append("-- Summary는 VVD로 order 할 수 없음. S.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD," ).append("\n"); 

	}
}