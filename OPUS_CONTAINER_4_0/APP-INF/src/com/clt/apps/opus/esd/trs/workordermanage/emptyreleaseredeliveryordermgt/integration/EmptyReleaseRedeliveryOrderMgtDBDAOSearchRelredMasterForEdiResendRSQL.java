/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchRelredMasterForEdiResendRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.30
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.09.30 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchRelredMasterForEdiResendRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RELRED EDI 재발송을 위한 Master 정보 조회
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchRelredMasterForEdiResendRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("issue_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchRelredMasterForEdiResendRSQL").append("\n"); 
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
		query.append("SELECT ORD.CRE_OFC_CD AS I_OFFICE" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RLS', 'O', 'I' ) AS BD" ).append("\n"); 
		query.append("	  ,ORD.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RLS', 'OUT', 'IN') AS BD_DISP" ).append("\n"); 
		query.append("	  ,ORD.BKG_NO" ).append("\n"); 
		query.append("	  ,ORD.BL_NO" ).append("\n"); 
		query.append("      ,ORD.TRSP_CRR_MOD_CD AS MODE_CD" ).append("\n"); 
		query.append("      ,DECODE(ORD.TRSP_COST_DTL_MOD_CD, 'ER', 'R', 'CF', 'S', DECODE(ORD.TRSP_SO_TP_CD, 'Y', 'C', 'S')) AS TYPE_CD" ).append("\n"); 
		query.append("      ,DECODE(ORD.TRSP_COST_DTL_MOD_CD, 'ER', 'MT REPO', 'CF', 'S/T', DECODE(ORD.TRSP_SO_TP_CD, 'Y', 'C/H', 'S/T')) AS TYPE_DISP" ).append("\n"); 
		query.append("      ,ORD.POL_CD AS POL" ).append("\n"); 
		query.append("      ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = ORD.POL_CD) AS POL_DESC" ).append("\n"); 
		query.append("      ,ORD.POD_CD AS POD" ).append("\n"); 
		query.append("      ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = ORD.POD_CD) AS POD_DESC" ).append("\n"); 
		query.append("      ,NVL2(ORD.DOR_NOD_CD, DZ.LOC_CD, TD.LOC_CD) AS DEST" ).append("\n"); 
		query.append("      ,NVL2(ORD.DOR_NOD_CD, DLD.LOC_NM, TLD.LOC_NM) AS DEST_DESC" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RLS', ORD.FM_NOD_CD, ORD.TO_NOD_CD) AS EMPTY_CY" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RLS', YD.YD_NM, TD.YD_NM) AS MTY_CY_DESC" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RLS', ORD.FM_NOD_CD, ORD.TO_NOD_CD) AS ORG_EMPTY_CY" ).append("\n"); 
		query.append("      ,MV.VNDR_SEQ AS S_P" ).append("\n"); 
		query.append("      ,MV.VNDR_LGL_ENG_NM AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(ORD.N1ST_NOD_PLN_DT, 'YYYYMMDD') AS PD_DATE_DISP" ).append("\n"); 
		query.append("      ,TO_CHAR(ORD.N1ST_NOD_PLN_DT, 'YYYYMMDD') AS PD_DATE" ).append("\n"); 
		query.append("      ,ORD.EQ_NO AS CNTR_NO" ).append("\n"); 
		query.append("      ,ORD.EQ_NO AS EQ_NO" ).append("\n"); 
		query.append("      ,ORD.EQ_TPSZ_CD AS TP" ).append("\n"); 
		query.append("      ,'C' AS CB" ).append("\n"); 
		query.append("      ,'' AS EMPTY_DEST" ).append("\n"); 
		query.append("	  ,DECODE(@[type], 'RLS', TD.YD_NM, YD.YD_NM) AS YD_NM" ).append("\n"); 
		query.append("	  ,DECODE(@[type], 'RLS', TD.FAX_NO, YD.FAX_NO) AS FAX_NO" ).append("\n"); 
		query.append("	  ,DECODE(@[type], 'RLS', TD.YD_EML, YD.YD_EML) AS EMAIL" ).append("\n"); 
		query.append("      ,'' AS OFFICE" ).append("\n"); 
		query.append("      ,'' AS USER_ID" ).append("\n"); 
		query.append("      ,'' AS ISSUE_DT" ).append("\n"); 
		query.append("      ,'' AS FAX_EMAIL_RST" ).append("\n"); 
		query.append("      ,ORD.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("      ,ORD.BL_NO AS BL_NO" ).append("\n"); 
		query.append("      ,BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,ORD.REF_ID AS EPP_REF" ).append("\n"); 
		query.append("      ,ORD.TRSP_WO_OFC_CTY_CD || ORD.TRSP_WO_SEQ AS WO_NO" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(REPLACE(REPLACE(RTRIM(TRO.SPCL_INSTR_RMK), CHR(10), ''), CHR(13), ''), CHR(34), ''), CHR(9), ' ') AS SPCL_INST" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(REPLACE(REPLACE(SUBSTR(RTRIM(S.CUST_NM), 1, 50), CHR(10), ''), CHR(13), ''), CHR(34), ''), CHR(9), ' ') AS SHPR" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(REPLACE(REPLACE(SUBSTR(RTRIM(C.CUST_NM), 1, 50), CHR(10), ''), CHR(13), ''), CHR(34), ''), CHR(9), ' ') AS CNEE" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(REPLACE(REPLACE(SUBSTR(RTRIM(C.CUST_NM), 1, 50), CHR(10), ''), CHR(13), ''), CHR(34), ''), CHR(9), ' ') AS NTFY" ).append("\n"); 
		query.append("      ,@[issue_flag] AS STATUS" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RLS', ORD.FM_NOD_CD) AS EQREL" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RLS', LD.LOC_CD) AS EQREL_LOC" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RLS', LD.LOC_NM) AS EQREL_NAME" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RDV', ORD.TO_NOD_CD) AS EQRES" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RDV', TLD.LOC_CD) AS EQRES_LOC" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RDV', TLD.LOC_NM) AS EQRES_NAME" ).append("\n"); 
		query.append("      ,VSL.CALL_SGN_NO AS VSL_CALL" ).append("\n"); 
		query.append("      ,VSL.LLOYD_NO AS VSL_LOYD" ).append("\n"); 
		query.append("      ,VSL.VSL_ENG_NM AS VSL_NAME" ).append("\n"); 
		query.append("      ,DECODE(ORD.TRSP_BND_CD, 'O', ETD.OB_CSSM_VOY_NO, 'I', ETA.IB_CSSM_VOY_NO, '') AS CONSORT_VOY" ).append("\n"); 
		query.append("      ,TO_CHAR(ETD.VPS_ETD_DT, 'YYYYMMDDHH24MM') AS VVD_ETD" ).append("\n"); 
		query.append("      ,TO_CHAR(ETA.VPS_ETA_DT, 'YYYYMMDDHH24MM') AS VVD_ETA" ).append("\n"); 
		query.append("      ,'C' AS HAUL_TYPE" ).append("\n"); 
		query.append("      ,'' AS SHIP_OPR" ).append("\n"); 
		query.append("      ,BK.DCGO_FLG AS DR_IND" ).append("\n"); 
		query.append("      ,BK.RC_FLG AS RF_IND" ).append("\n"); 
		query.append("      ,BK.AWK_CGO_FLG AS AK_IND" ).append("\n"); 
		query.append("      ,TRO.CNTR_PKUP_DT" ).append("\n"); 
		query.append("      ,TRO.CNTR_RTN_YD_CD" ).append("\n"); 
		query.append("      ,ORD.TRSP_SO_TP_CD" ).append("\n"); 
		query.append("      ,ORD.CGO_TP_CD" ).append("\n"); 
		query.append("      ,ORD.TRSP_SO_OFC_CTY_CD AS SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,ORD.TRSP_SO_SEQ AS SO_SEQ" ).append("\n"); 
		query.append("      ,ORD.CRE_OFC_CD AS STK_OFC_CD" ).append("\n"); 
		query.append("      ,'' AS STK_JB_SEQ" ).append("\n"); 
		query.append("      ,'' AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,'' AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,'' AS FAX_SND_NO" ).append("\n"); 
		query.append("      ,@[type] AS TYPE" ).append("\n"); 
		query.append("      ,'' AS SPCL_INST" ).append("\n"); 
		query.append("      ,'' AS SEND_KEY" ).append("\n"); 
		query.append("	  ,'D' AS STK_ISS_CD" ).append("\n"); 
		query.append("	  ,ORD.CRE_OFC_CD AS USER_OFC" ).append("\n"); 
		query.append("      ,CASE" ).append("\n"); 
		query.append("         WHEN ORD.TRSP_SO_TP_CD = 'M' THEN" ).append("\n"); 
		query.append("           CASE" ).append("\n"); 
		query.append("             WHEN @[type] = 'RLS'" ).append("\n"); 
		query.append("             THEN 'MTRELORD'" ).append("\n"); 
		query.append("             ELSE 'MTRESORD'" ).append("\n"); 
		query.append("           END" ).append("\n"); 
		query.append("         WHEN ORD.TRSP_COST_DTL_MOD_CD = 'DR' THEN" ).append("\n"); 
		query.append("           CASE" ).append("\n"); 
		query.append("             WHEN @[type] = 'RLS'" ).append("\n"); 
		query.append("             THEN 'MTRELORD'" ).append("\n"); 
		query.append("             ELSE 'MTRESORD'" ).append("\n"); 
		query.append("           END" ).append("\n"); 
		query.append("         ELSE" ).append("\n"); 
		query.append("           CASE" ).append("\n"); 
		query.append("             WHEN @[type] = 'RLS'" ).append("\n"); 
		query.append("             THEN 'FULLRELORD'" ).append("\n"); 
		query.append("             ELSE 'FULLRESORD'" ).append("\n"); 
		query.append("           END" ).append("\n"); 
		query.append("       END AS MSG_ID" ).append("\n"); 
		query.append("      ,ORD.TRSP_BND_CD AS TRSP_BND_CD" ).append("\n"); 
		query.append("      ,ORD.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD ORD" ).append("\n"); 
		query.append("      ,BKG_BOOKING      BK" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER     S" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER     C" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER     N" ).append("\n"); 
		query.append("      ,BKG_EUR_TRO      TRO" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR     VSL" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD ETD" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD ETA" ).append("\n"); 
		query.append("      ,MDM_YARD         YD" ).append("\n"); 
		query.append("      ,MDM_LOCATION     LD" ).append("\n"); 
		query.append("      ,MDM_YARD         TD" ).append("\n"); 
		query.append("	  ,MDM_LOCATION     TLD" ).append("\n"); 
		query.append("      ,MDM_ZONE         DZ" ).append("\n"); 
		query.append("      ,MDM_LOCATION     DLD" ).append("\n"); 
		query.append("      ,MDM_VENDOR       MV" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND ORD.TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND ORD.TRSP_WO_SEQ = @[trsp_wo_seq]" ).append("\n"); 
		query.append("   AND ORD.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("   AND ORD.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("   AND ORD.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("   AND ORD.BKG_NO = N.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'S' = S.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND 'C' = C.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND 'N' = N.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND ORD.BKG_NO = TRO.BKG_NO(+)" ).append("\n"); 
		query.append("   AND ORD.TRSP_BND_CD = TRO.IO_BND_CD(+)" ).append("\n"); 
		query.append("   AND ORD.TRO_SEQ = TRO.TRO_SEQ(+)" ).append("\n"); 
		query.append("   AND 'C' = TRO.TRO_PROC_CD(+)" ).append("\n"); 
		query.append("   AND 'C' = TRO.HLG_TP_CD(+)" ).append("\n"); 
		query.append("   AND 'N' = TRO.CNTR_CFM_FLG(+)" ).append("\n"); 
		query.append("   AND 'N' = TRO.CXL_FLG(+)" ).append("\n"); 
		query.append("   AND ORD.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND ORD.VSL_CD = VSL.VSL_CD(+)" ).append("\n"); 
		query.append("   AND ORD.VSL_CD = ETD.VSL_CD(+)" ).append("\n"); 
		query.append("   AND ORD.SKD_VOY_NO = ETD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND ORD.SKD_DIR_CD = ETD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND ORD.POL_CD = ETD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND ORD.VSL_CD = ETA.VSL_CD(+)" ).append("\n"); 
		query.append("   AND ORD.SKD_VOY_NO = ETA.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND ORD.SKD_DIR_CD = ETA.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND ORD.POD_CD = ETA.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND ORD.FM_NOD_CD = YD.YD_CD" ).append("\n"); 
		query.append("   AND YD.LOC_CD = LD.LOC_CD" ).append("\n"); 
		query.append("   AND ORD.TO_NOD_CD = TD.YD_CD" ).append("\n"); 
		query.append("   AND TD.LOC_CD = TLD.LOC_CD" ).append("\n"); 
		query.append("   AND ORD.DOR_NOD_CD = DZ.ZN_CD(+)" ).append("\n"); 
		query.append("   AND DZ.LOC_CD = DLD.LOC_CD(+)" ).append("\n"); 
		query.append("   AND ORD.VNDR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("--   AND (ORD.CGO_TP_CD = 'M' OR (ORD.CGO_TP_CD = 'F' AND ORD.TRSP_COST_DTL_MOD_CD IN ('DR', 'CN', 'CF')))" ).append("\n"); 
		query.append("   AND ORD.TRSP_SO_TP_CD IN('Y', 'M')" ).append("\n"); 
		query.append("   AND ORD.CONTI_CD = 'E'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- 2015.07.30 CHAN WOO PARK" ).append("\n"); 
		query.append("-- COST_MD : EMPTY REPO / CNT_CD : CHILE CASE 추가" ).append("\n"); 
		query.append("SELECT ORD.CRE_OFC_CD AS I_OFFICE" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RLS', 'O', 'I' ) AS BD" ).append("\n"); 
		query.append("	  ,ORD.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RLS', 'OUT', 'IN') AS BD_DISP" ).append("\n"); 
		query.append("	  ,ORD.BKG_NO" ).append("\n"); 
		query.append("	  ,ORD.BL_NO" ).append("\n"); 
		query.append("      ,ORD.TRSP_CRR_MOD_CD AS MODE_CD" ).append("\n"); 
		query.append("      ,DECODE(ORD.TRSP_COST_DTL_MOD_CD, 'ER', 'R', 'CF', 'S', DECODE(ORD.TRSP_SO_TP_CD, 'Y', 'C', 'S')) AS TYPE_CD" ).append("\n"); 
		query.append("      ,DECODE(ORD.TRSP_COST_DTL_MOD_CD, 'ER', 'MT REPO', 'CF', DECODE(ORD.TRSP_SO_TP_CD, 'Y', 'C/H', 'S/T')) AS TYPE_DISP" ).append("\n"); 
		query.append("      ,ORD.POL_CD AS POL" ).append("\n"); 
		query.append("      ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = ORD.POL_CD) AS POL_DESC" ).append("\n"); 
		query.append("      ,ORD.POD_CD AS POD" ).append("\n"); 
		query.append("      ,(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = ORD.POD_CD) AS POD_DESC" ).append("\n"); 
		query.append("      ,NVL2(ORD.DOR_NOD_CD, DZ.LOC_CD, TD.LOC_CD) AS DEST" ).append("\n"); 
		query.append("      ,NVL2(ORD.DOR_NOD_CD, DLD.LOC_NM, TLD.LOC_NM) AS DEST_DESC" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RLS', ORD.FM_NOD_CD, ORD.TO_NOD_CD) AS EMPTY_CY" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RLS', YD.YD_NM, TD.YD_NM) AS MTY_CY_DESC" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RLS', ORD.FM_NOD_CD, ORD.TO_NOD_CD) AS ORG_EMPTY_CY" ).append("\n"); 
		query.append("      ,MV.VNDR_SEQ AS S_P" ).append("\n"); 
		query.append("      ,MV.VNDR_LGL_ENG_NM AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(ORD.N1ST_NOD_PLN_DT, 'YYYYMMDD') AS PD_DATE_DISP" ).append("\n"); 
		query.append("      ,TO_CHAR(ORD.N1ST_NOD_PLN_DT, 'YYYYMMDD') AS PD_DATE" ).append("\n"); 
		query.append("      ,ORD.EQ_NO AS CNTR_NO" ).append("\n"); 
		query.append("      ,ORD.EQ_NO AS EQ_NO" ).append("\n"); 
		query.append("      ,ORD.EQ_TPSZ_CD AS TP" ).append("\n"); 
		query.append("      ,'C' AS CB" ).append("\n"); 
		query.append("      ,'' AS EMPTY_DEST" ).append("\n"); 
		query.append("	  ,DECODE(@[type], 'RLS', TD.YD_NM, YD.YD_NM) AS YD_NM" ).append("\n"); 
		query.append("	  ,DECODE(@[type], 'RLS', TD.FAX_NO, YD.FAX_NO) AS FAX_NO" ).append("\n"); 
		query.append("	  ,DECODE(@[type], 'RLS', TD.YD_EML, YD.YD_EML) AS EMAIL" ).append("\n"); 
		query.append("      ,'' AS OFFICE" ).append("\n"); 
		query.append("      ,'' AS USER_ID" ).append("\n"); 
		query.append("      ,'' AS ISSUE_DT" ).append("\n"); 
		query.append("      ,'' AS FAX_EMAIL_RST" ).append("\n"); 
		query.append("      ,ORD.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("      ,ORD.BL_NO AS BL_NO" ).append("\n"); 
		query.append("      ,BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,ORD.REF_ID AS EPP_REF" ).append("\n"); 
		query.append("      ,ORD.TRSP_WO_OFC_CTY_CD || ORD.TRSP_WO_SEQ AS WO_NO" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(REPLACE(REPLACE(RTRIM(TRO.SPCL_INSTR_RMK), CHR(10), ''), CHR(13), ''), CHR(34), ''), CHR(9), ' ') AS SPCL_INST" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(REPLACE(REPLACE(SUBSTR(RTRIM(S.CUST_NM), 1, 50), CHR(10), ''), CHR(13), ''), CHR(34), ''), CHR(9), ' ') AS SHPR" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(REPLACE(REPLACE(SUBSTR(RTRIM(C.CUST_NM), 1, 50), CHR(10), ''), CHR(13), ''), CHR(34), ''), CHR(9), ' ') AS CNEE" ).append("\n"); 
		query.append("      ,REPLACE(REPLACE(REPLACE(REPLACE(SUBSTR(RTRIM(C.CUST_NM), 1, 50), CHR(10), ''), CHR(13), ''), CHR(34), ''), CHR(9), ' ') AS NTFY" ).append("\n"); 
		query.append("      ,@[issue_flag] AS STATUS" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RLS', ORD.FM_NOD_CD) AS EQREL" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RLS', LD.LOC_CD) AS EQREL_LOC" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RLS', LD.LOC_NM) AS EQREL_NAME" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RDV', ORD.TO_NOD_CD) AS EQRES" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RDV', TLD.LOC_CD) AS EQRES_LOC" ).append("\n"); 
		query.append("      ,DECODE(@[type], 'RDV', TLD.LOC_NM) AS EQRES_NAME" ).append("\n"); 
		query.append("      ,VSL.CALL_SGN_NO AS VSL_CALL" ).append("\n"); 
		query.append("      ,VSL.LLOYD_NO AS VSL_LOYD" ).append("\n"); 
		query.append("      ,VSL.VSL_ENG_NM AS VSL_NAME" ).append("\n"); 
		query.append("      ,DECODE(ORD.TRSP_BND_CD, 'O', ETD.OB_CSSM_VOY_NO, 'I', ETA.IB_CSSM_VOY_NO, '') AS CONSORT_VOY" ).append("\n"); 
		query.append("      ,TO_CHAR(ETD.VPS_ETD_DT, 'YYYYMMDDHH24MM') AS VVD_ETD" ).append("\n"); 
		query.append("      ,TO_CHAR(ETA.VPS_ETA_DT, 'YYYYMMDDHH24MM') AS VVD_ETA" ).append("\n"); 
		query.append("      ,'C' AS HAUL_TYPE" ).append("\n"); 
		query.append("      ,'' AS SHIP_OPR" ).append("\n"); 
		query.append("      ,BK.DCGO_FLG AS DR_IND" ).append("\n"); 
		query.append("      ,BK.RC_FLG AS RF_IND" ).append("\n"); 
		query.append("      ,BK.AWK_CGO_FLG AS AK_IND" ).append("\n"); 
		query.append("      ,TRO.CNTR_PKUP_DT" ).append("\n"); 
		query.append("      ,TRO.CNTR_RTN_YD_CD" ).append("\n"); 
		query.append("      ,ORD.TRSP_SO_TP_CD" ).append("\n"); 
		query.append("      ,ORD.CGO_TP_CD" ).append("\n"); 
		query.append("      ,ORD.TRSP_SO_OFC_CTY_CD AS SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,ORD.TRSP_SO_SEQ AS SO_SEQ" ).append("\n"); 
		query.append("      ,ORD.CRE_OFC_CD AS STK_OFC_CD" ).append("\n"); 
		query.append("      ,'' AS STK_JB_SEQ" ).append("\n"); 
		query.append("      ,'' AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,'' AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,'' AS FAX_SND_NO" ).append("\n"); 
		query.append("      ,@[type] AS TYPE" ).append("\n"); 
		query.append("      ,'' AS SPCL_INST" ).append("\n"); 
		query.append("      ,'' AS SEND_KEY" ).append("\n"); 
		query.append("	  ,'D' AS STK_ISS_CD" ).append("\n"); 
		query.append("	  ,ORD.CRE_OFC_CD AS USER_OFC" ).append("\n"); 
		query.append("      ,CASE" ).append("\n"); 
		query.append("         WHEN ORD.TRSP_SO_TP_CD = 'M' THEN" ).append("\n"); 
		query.append("           CASE" ).append("\n"); 
		query.append("             WHEN @[type] = 'RLS'" ).append("\n"); 
		query.append("             THEN 'MTRELORD'" ).append("\n"); 
		query.append("             ELSE 'MTRESORD'" ).append("\n"); 
		query.append("           END" ).append("\n"); 
		query.append("         WHEN ORD.TRSP_COST_DTL_MOD_CD = 'DR' THEN" ).append("\n"); 
		query.append("           CASE" ).append("\n"); 
		query.append("             WHEN @[type] = 'RLS'" ).append("\n"); 
		query.append("             THEN 'MTRELORD'" ).append("\n"); 
		query.append("             ELSE 'MTRESORD'" ).append("\n"); 
		query.append("           END" ).append("\n"); 
		query.append("         ELSE" ).append("\n"); 
		query.append("           CASE" ).append("\n"); 
		query.append("             WHEN @[type] = 'RLS'" ).append("\n"); 
		query.append("             THEN 'FULLRELORD'" ).append("\n"); 
		query.append("             ELSE 'FULLRESORD'" ).append("\n"); 
		query.append("           END" ).append("\n"); 
		query.append("       END AS MSG_ID" ).append("\n"); 
		query.append("      ,ORD.TRSP_BND_CD AS TRSP_BND_CD" ).append("\n"); 
		query.append("      ,ORD.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD ORD" ).append("\n"); 
		query.append("	  ,TRS_TRSP_WRK_ORD_PRV_TMP T" ).append("\n"); 
		query.append("      ,BKG_BOOKING      BK" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER     S" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER     C" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER     N" ).append("\n"); 
		query.append("      ,BKG_EUR_TRO      TRO" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR     VSL" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD ETD" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD ETA" ).append("\n"); 
		query.append("      ,MDM_YARD         YD" ).append("\n"); 
		query.append("      ,MDM_LOCATION     LD" ).append("\n"); 
		query.append("      ,MDM_YARD         TD" ).append("\n"); 
		query.append("	  ,MDM_LOCATION     TLD" ).append("\n"); 
		query.append("      ,MDM_ZONE         DZ" ).append("\n"); 
		query.append("      ,MDM_LOCATION     DLD" ).append("\n"); 
		query.append("      ,MDM_VENDOR       MV" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND ORD.TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND ORD.TRSP_WO_SEQ = @[trsp_wo_seq]" ).append("\n"); 
		query.append("   AND ORD.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("   AND ORD.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("   AND ORD.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("   AND ORD.BKG_NO = N.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'S' = S.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND 'C' = C.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND 'N' = N.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND ORD.BKG_NO = TRO.BKG_NO(+)" ).append("\n"); 
		query.append("   AND ORD.TRSP_BND_CD = TRO.IO_BND_CD(+)" ).append("\n"); 
		query.append("   AND ORD.TRO_SEQ = TRO.TRO_SEQ(+)" ).append("\n"); 
		query.append("   AND 'C' = TRO.TRO_PROC_CD(+)" ).append("\n"); 
		query.append("   AND 'C' = TRO.HLG_TP_CD(+)" ).append("\n"); 
		query.append("   AND 'N' = TRO.CNTR_CFM_FLG(+)" ).append("\n"); 
		query.append("   AND 'N' = TRO.CXL_FLG(+)" ).append("\n"); 
		query.append("   AND ORD.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND ORD.VSL_CD = VSL.VSL_CD(+)" ).append("\n"); 
		query.append("   AND ORD.VSL_CD = ETD.VSL_CD(+)" ).append("\n"); 
		query.append("   AND ORD.SKD_VOY_NO = ETD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND ORD.SKD_DIR_CD = ETD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND ORD.POL_CD = ETD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND ORD.VSL_CD = ETA.VSL_CD(+)" ).append("\n"); 
		query.append("   AND ORD.SKD_VOY_NO = ETA.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND ORD.SKD_DIR_CD = ETA.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND ORD.POD_CD = ETA.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND ORD.FM_NOD_CD = YD.YD_CD" ).append("\n"); 
		query.append("   AND YD.LOC_CD = LD.LOC_CD" ).append("\n"); 
		query.append("   AND ORD.TO_NOD_CD = TD.YD_CD" ).append("\n"); 
		query.append("   AND TD.LOC_CD = TLD.LOC_CD" ).append("\n"); 
		query.append("   AND ORD.DOR_NOD_CD = DZ.ZN_CD(+)" ).append("\n"); 
		query.append("   AND DZ.LOC_CD = DLD.LOC_CD(+)" ).append("\n"); 
		query.append("   AND ORD.VNDR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("   AND ORD.CGO_TP_CD = 'M'" ).append("\n"); 
		query.append("   AND DECODE(@[type], 'RLS', LD.CNT_CD, TLD.CNT_CD) = 'CL'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}