/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchSiTurnTimeDetailRSQL.java
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

public class PerformanceReportDBDAOSearchSiTurnTimeDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SI Turn Time Report - Detail 파트를 조회한다.
	  * 2012.01.05 정선용 [CHM-201115236-01] DPCS S/I Turn Time Report 수정 요청
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchSiTurnTimeDetailRSQL(){
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
		params.put("ord_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchSiTurnTimeDetailRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT DISTINCT R.SR_NO, R.BKG_NO, R.SR_AMD_TP_CD, " ).append("\n"); 
		query.append("        S.BKG_OFC_CD," ).append("\n"); 
		query.append("        B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD TVVD, " ).append("\n"); 
		query.append("        B.POL_CD, " ).append("\n"); 
		query.append("        B.POD_CD, " ).append("\n"); 
		query.append("        R.SR_KND_CD, " ).append("\n"); 
		query.append("        (SELECT COUNT(*) FROM BKG_CNTR_MF_DESC WHERE BKG_NO = B.BKG_NO) CM_CNT," ).append("\n"); 
		query.append("        (SELECT COUNT(*) FROM BKG_HBL WHERE BKG_NO = B.BKG_NO) HBL_CNT," ).append("\n"); 
		query.append("        TO_CHAR(R.FNT_OFC_TRNS_DT,'YYYY-MM-DD HH24:MI:SS') FNT_OFC_TRNS_DT," ).append("\n"); 
		query.append("        TO_CHAR(R.SR_DUE_DT,'YYYY-MM-DD HH24:MI:SS') SR_DUE_DT, " ).append("\n"); 
		query.append("        (SELECT C.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL C" ).append("\n"); 
		query.append("        WHERE C.INTG_CD_ID = 'CD02405'" ).append("\n"); 
		query.append("        AND C.INTG_CD_VAL_CTNT = S.RGN_OFC_CD" ).append("\n"); 
		query.append("        AND ROWNUM = 1) RGN_OFC_CD , " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        TO_CHAR(ID.SR_PROC_UPD_DT,'YYYY-MM-DD HH24:MI:SS')         ID_ST_DT, " ).append("\n"); 
		query.append("        TO_CHAR(ID.ST_DT,'YYYY-MM-DD HH24:MI:SS')                  ID_END_DT," ).append("\n"); 
		query.append("        BKG_GET_CONV_INTVAL_TIME_FNC(ID.BL_DOC_WRK_HRS,'HMS')      ID_BIZ_TM," ).append("\n"); 
		query.append("        BKG_GET_CONV_INTVAL_TIME_FNC(ID.SR_PROC_HRS,'HMS')         ID_ACT_TM," ).append("\n"); 
		query.append("        BKG_GET_CONV_INTVAL_TIME_FNC(ID.BL_DOC_OVT_HRS,'HMS')      ID_OVT," ).append("\n"); 
		query.append("		BKG_GET_CONV_INTVAL_TIME_FNC(ID.SR_WRK_TM_IDLE_HRS, 'HMS') ID_SR_WRK_TM_IDLE_HRS," ).append("\n"); 
		query.append("		BKG_GET_CONV_INTVAL_TIME_FNC(ID.SR_OVT_IDLE_HRS, 'HMS')    ID_SR_OVT_IDLE_HRS," ).append("\n"); 
		query.append("        BKG_GET_CONV_INTVAL_TIME_FNC(ID.SR_IDLE_HRS, 'HMS') 	   ID_SR_IDLE_HRS," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        TO_CHAR(RD.SR_PROC_UPD_DT,'YYYY-MM-DD HH24:MI:SS')         RD_ST_DT," ).append("\n"); 
		query.append("        TO_CHAR(RD.ST_DT,'YYYY-MM-DD HH24:MI:SS')                  RD_END_DT," ).append("\n"); 
		query.append("        BKG_GET_CONV_INTVAL_TIME_FNC(RD.BL_DOC_WRK_HRS,'HMS')      RD_BIZ_TM," ).append("\n"); 
		query.append("        BKG_GET_CONV_INTVAL_TIME_FNC(RD.SR_PROC_HRS,'HMS')         RD_ACT_TM," ).append("\n"); 
		query.append("        BKG_GET_CONV_INTVAL_TIME_FNC(RD.BL_DOC_OVT_HRS,'HMS')      RD_OVT," ).append("\n"); 
		query.append("		BKG_GET_CONV_INTVAL_TIME_FNC(RD.SR_WRK_TM_IDLE_HRS, 'HMS') RD_SR_WRK_TM_IDLE_HRS," ).append("\n"); 
		query.append("		BKG_GET_CONV_INTVAL_TIME_FNC(RD.SR_OVT_IDLE_HRS, 'HMS')    RD_SR_OVT_IDLE_HRS," ).append("\n"); 
		query.append("        BKG_GET_CONV_INTVAL_TIME_FNC(RD.SR_IDLE_HRS, 'HMS') 	   RD_SR_IDLE_HRS," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        TO_CHAR(AD.SR_PROC_UPD_DT,'YYYY-MM-DD HH24:MI:SS')         AD_ST_DT," ).append("\n"); 
		query.append("        TO_CHAR(AD.ST_DT,'YYYY-MM-DD HH24:MI:SS')                  AD_END_DT," ).append("\n"); 
		query.append("        BKG_GET_CONV_INTVAL_TIME_FNC(AD.BL_DOC_WRK_HRS,'HMS')      AD_BIZ_TM," ).append("\n"); 
		query.append("        BKG_GET_CONV_INTVAL_TIME_FNC(AD.SR_PROC_HRS,'HMS')         AD_ACT_TM," ).append("\n"); 
		query.append("        BKG_GET_CONV_INTVAL_TIME_FNC(AD.BL_DOC_OVT_HRS,'HMS')      AD_OVT," ).append("\n"); 
		query.append("		BKG_GET_CONV_INTVAL_TIME_FNC(AD.SR_WRK_TM_IDLE_HRS, 'HMS') AD_SR_WRK_TM_IDLE_HRS," ).append("\n"); 
		query.append("		BKG_GET_CONV_INTVAL_TIME_FNC(AD.SR_OVT_IDLE_HRS, 'HMS')    AD_SR_OVT_IDLE_HRS," ).append("\n"); 
		query.append("        BKG_GET_CONV_INTVAL_TIME_FNC(AD.SR_IDLE_HRS, 'HMS') 	   AD_SR_IDLE_HRS," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        TO_CHAR(PN.SR_PROC_UPD_DT,'YYYY-MM-DD HH24:MI:SS')         PN_ST_DT," ).append("\n"); 
		query.append("        TO_CHAR(PN.ST_DT,'YYYY-MM-DD HH24:MI:SS')                  PN_END_DT," ).append("\n"); 
		query.append("        BKG_GET_CONV_INTVAL_TIME_FNC(PN.BL_DOC_WRK_HRS,'HMS')      PN_BIZ_TM," ).append("\n"); 
		query.append("        BKG_GET_CONV_INTVAL_TIME_FNC(PN.SR_PROC_HRS,'HMS')         PN_ACT_TM," ).append("\n"); 
		query.append("        TO_CHAR(RR.SR_PROC_UPD_DT,'YYYY-MM-DD HH24:MI:SS')         RT_ST_DT," ).append("\n"); 
		query.append("        TO_CHAR(RT.ST_DT,'YYYY-MM-DD HH24:MI:SS')			       RT_END_DT," ).append("\n"); 
		query.append("        BKG_GET_CONV_INTVAL_TIME_FNC(RT.ST_DT - RR.SR_PROC_UPD_DT,'TM') RT_ACT_TM," ).append("\n"); 
		query.append("        (SELECT COUNT(DISTINCT HOL_DT)" ).append("\n"); 
		query.append("         FROM MDM_ORGANIZATION O, MDM_LOCATION L, DMT_HOLIDAY H" ).append("\n"); 
		query.append("         WHERE O.OFC_CD = B.BKG_OFC_CD" ).append("\n"); 
		query.append("         AND O.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("         AND HOL_YR = TO_CHAR(ID.SR_PROC_UPD_DT,'YYYY')" ).append("\n"); 
		query.append("         AND (H.CNT_CD = L.CNT_CD OR H.CNT_CD = ' ')" ).append("\n"); 
		query.append("         AND (H.RGN_CD = L.RGN_CD OR H.RGN_CD = ' ')" ).append("\n"); 
		query.append("         AND (H.STE_CD = L.STE_CD OR H.STE_CD = ' ')" ).append("\n"); 
		query.append("         AND (H.LOC_CD = L.LOC_CD OR H.LOC_CD = ' ')" ).append("\n"); 
		query.append("         AND ((HOL_DT BETWEEN TRUNC(ID.SR_PROC_UPD_DT) AND TRUNC(ID.ST_DT))" ).append("\n"); 
		query.append("            OR(HOL_DT BETWEEN TRUNC(RD.SR_PROC_UPD_DT) AND TRUNC(RD.ST_DT))" ).append("\n"); 
		query.append("            OR(HOL_DT BETWEEN TRUNC(AD.SR_PROC_UPD_DT) AND TRUNC(AD.ST_DT))" ).append("\n"); 
		query.append("            OR(HOL_DT BETWEEN TRUNC(R.RTN_DT) AND TRUNC(R.RTN_TO_RTN_END_DT))" ).append("\n"); 
		query.append("            OR(HOL_DT BETWEEN TRUNC(PN.SR_PROC_UPD_DT) AND TRUNC(PN.ST_DT)))) HOL_CNT," ).append("\n"); 
		query.append("        R.PND_FLG," ).append("\n"); 
		query.append("        R.SR_CRNT_INFO_CD," ).append("\n"); 
		query.append("        R.SR_CRNT_STS_CD," ).append("\n"); 
		query.append("        NVL(R.BL_DOC_INP_FLG,'N') BL_DOC_INP_FLG," ).append("\n"); 
		query.append("        NVL(R.BL_RT_FLG,'N') BL_RT_FLG," ).append("\n"); 
		query.append("        NVL(R.BL_AUD_FLG,'N') BL_AUD_FLG," ).append("\n"); 
		query.append("        NVL(R.BL_DRFT_FAX_OUT_FLG,'N') BL_DRFT_FAX_OUT_FLG," ).append("\n"); 
		query.append("        DECODE(R.SR_WRK_STS_CD,'T',NULL,SR_WRK_STS_CD) SR_WRK_STS_CD" ).append("\n"); 
		query.append("FROM BKG_SR_CRNT_RQST R, BKG_BOOKING B, BKG_SR_HIS ID, BKG_SR_HIS RD, BKG_SR_HIS AD, BKG_SR_HIS PN, BKG_SR_HIS RR, BKG_SR_HIS RT, " ).append("\n"); 
		query.append("     (SELECT DISTINCT BKG_OFC_CD, RGN_OFC_CD FROM BKG_EML_ACCT_STUP WHERE DELT_FLG = 'N') S" ).append("\n"); 
		query.append("#if (${sr_no} != '')" ).append("\n"); 
		query.append("WHERE  R.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${tvvd} != '')" ).append("\n"); 
		query.append("WHERE R.BKG_NO IN (SELECT BKG_NO" ).append("\n"); 
		query.append("                     FROM BKG_BOOKING" ).append("\n"); 
		query.append("                    WHERE VSL_CD = SUBSTR(@[tvvd],1,4)" ).append("\n"); 
		query.append("                      AND SKD_VOY_NO = SUBSTR(@[tvvd],5,4)" ).append("\n"); 
		query.append("                      AND SKD_DIR_CD = SUBSTR(@[tvvd],9,1))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE R.FNT_OFC_TRNS_DT BETWEEN TO_DATE(@[fm_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   #if (${si_sts} == 'C')		" ).append("\n"); 
		query.append("   AND (NVL(R.BL_DOC_INP_FLG,'N') = 'Y' AND NVL(R.BL_RT_FLG,'N') = 'Y' AND NVL(R.BL_AUD_FLG,'N') = 'Y')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${si_sts} == 'P')" ).append("\n"); 
		query.append("   AND (NVL(R.BL_DOC_INP_FLG,'N') <> 'Y' OR NVL(R.BL_RT_FLG,'N') <> 'Y' OR NVL(R.BL_AUD_FLG,'N') <> 'Y')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("AND R.DPCS_OFC_CD = NVL(@[dpcs_ofc_cd],R.DPCS_OFC_CD)" ).append("\n"); 
		query.append("AND R.SR_AMD_TP_CD = DECODE(@[sr_amd_tp_cd], 'L', R.SR_AMD_TP_CD, @[sr_amd_tp_cd])" ).append("\n"); 
		query.append("AND B.BKG_OFC_CD = NVL(@[bkg_ofc_cd], B.BKG_OFC_CD)" ).append("\n"); 
		query.append("AND S.RGN_OFC_CD = DECODE(@[rgn_ofc_cd], 'A',S.RGN_OFC_CD, @[rgn_ofc_cd])" ).append("\n"); 
		query.append("AND (ID.ATND_USR_ID = NVL(@[atnd_usr_id], ID.ATND_USR_ID)" ).append("\n"); 
		query.append("  OR RD.ATND_USR_ID = NVL(@[atnd_usr_id], RD.ATND_USR_ID)" ).append("\n"); 
		query.append("  OR AD.ATND_USR_ID = NVL(@[atnd_usr_id], AD.ATND_USR_ID)" ).append("\n"); 
		query.append("  OR PN.ATND_USR_ID = NVL(@[atnd_usr_id], PN.ATND_USR_ID)" ).append("\n"); 
		query.append("  OR RT.ATND_USR_ID = NVL(@[atnd_usr_id], RT.ATND_USR_ID))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND R.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_OFC_CD = S.BKG_OFC_CD" ).append("\n"); 
		query.append("AND R.SR_KND_CD = ID.SR_KND_CD(+)" ).append("\n"); 
		query.append("AND R.SR_NO = ID.SR_NO(+)" ).append("\n"); 
		query.append("AND R.BKG_NO = ID.BKG_NO(+)" ).append("\n"); 
		query.append("AND ID.SR_STS_CD(+) = 'ID'" ).append("\n"); 
		query.append("AND R.SR_KND_CD = RD.SR_KND_CD(+)" ).append("\n"); 
		query.append("AND R.SR_NO = RD.SR_NO(+)" ).append("\n"); 
		query.append("AND R.BKG_NO = RD.BKG_NO(+)" ).append("\n"); 
		query.append("AND RD.SR_STS_CD(+) = 'RD'" ).append("\n"); 
		query.append("AND R.SR_KND_CD = AD.SR_KND_CD(+)" ).append("\n"); 
		query.append("AND R.SR_NO = AD.SR_NO(+)" ).append("\n"); 
		query.append("AND R.BKG_NO = AD.BKG_NO(+)" ).append("\n"); 
		query.append("AND AD.SR_STS_CD(+) = 'AD'" ).append("\n"); 
		query.append("AND R.SR_KND_CD = PN.SR_KND_CD(+)" ).append("\n"); 
		query.append("AND R.SR_NO = PN.SR_NO(+)" ).append("\n"); 
		query.append("AND R.BKG_NO = PN.BKG_NO(+)" ).append("\n"); 
		query.append("AND PN.SR_STS_CD(+) = 'PN'" ).append("\n"); 
		query.append("AND R.SR_KND_CD = RR.SR_KND_CD(+)" ).append("\n"); 
		query.append("AND R.SR_NO = RR.SR_NO(+)" ).append("\n"); 
		query.append("AND R.BKG_NO = RR.BKG_NO(+)" ).append("\n"); 
		query.append("AND RR.SR_STS_CD(+) = 'RR'" ).append("\n"); 
		query.append("AND RR.SR_KND_CD = RT.SR_KND_CD(+)" ).append("\n"); 
		query.append("AND RR.SR_NO = RT.SR_NO(+)" ).append("\n"); 
		query.append("AND RR.BKG_NO = RT.BKG_NO(+)" ).append("\n"); 
		query.append("AND RT.SR_STS_CD(+) = 'RT'" ).append("\n"); 
		query.append("AND RR.SR_HIS_SEQ + 1 = RT.SR_HIS_SEQ(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY RGN_OFC_CD, DECODE(@[ord_tp], 'O', BKG_OFC_CD, 'V', TVVD, RGN_OFC_CD), BKG_NO, SR_NO" ).append("\n"); 

	}
}