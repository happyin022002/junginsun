/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllCdlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCllCdlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCllCdl
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllCdlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pkup_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_ts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_hot_de_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_prct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_ts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_hngr_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCllCdlRSQL").append("\n"); 
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
		query.append("SELECT	" ).append("\n"); 
		query.append("--for order by, 컬럼추가시 이 사이에는 하지 말 것" ).append("\n"); 
		query.append("	CNTR_NO, " ).append("\n"); 
		query.append("	CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("    ( " ).append("\n"); 
		query.append("      	SELECT CNTR_SEAL_NO " ).append("\n"); 
		query.append("        FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("        WHERE BKG_NO = TB1.BKG_NO" ).append("\n"); 
		query.append("        AND CNTR_NO = TB1.CNTR_NO" ).append("\n"); 
		query.append("        AND CNTR_SEAL_SEQ > 0" ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("    ) CNTR_SEAL_NO," ).append("\n"); 
		query.append("	CNTR_WGT, " ).append("\n"); 
		query.append("    ROUND((round(nvl(ACT_WGT, 0) * decode(substr(CNTR_TPSZ_CD, 2, 1), '2', 1, 2) / TOT) + " ).append("\n"); 
		query.append("        NVL(CNTR_VOL_QTY, 1)* decode(nvl(mst_tare,0), 0, decode(nvl(mdm_tare,0), 0, 2500, mdm_tare), mst_tare))/1000) E_CNTR_WGT," ).append("\n"); 
		query.append("	PCK_QTY, " ).append("\n"); 
		query.append("	BKG_NO," ).append("\n"); 
		query.append("	BL_NO," ).append("\n"); 
		query.append("	POR_CD," ).append("\n"); 
		query.append("	A_POL_CD, " ).append("\n"); 
		query.append("	A_POD_CD," ).append("\n"); 
		query.append("	DEL_CD," ).append("\n"); 
		query.append("	BLCK_STWG_CD," ).append("\n"); 
		query.append("	RCV_TERM_CD," ).append("\n"); 
		query.append("	DE_TERM_CD," ).append("\n"); 
		query.append("	TS_CD,	" ).append("\n"); 
		query.append("	BKG_CGO_TP_CD," ).append("\n"); 
		query.append("	HOT_DE_FLG," ).append("\n"); 
		query.append("	VVD_CD,	" ).append("\n"); 
		query.append("	CUST_NM," ).append("\n"); 
		query.append("	SOC_FLG," ).append("\n"); 
		query.append("	STWG_CD," ).append("\n"); 
		query.append("	BLCK_STWG_HUB_LOC_CD," ).append("\n"); 
		query.append("	HAMO_TRF_CD," ).append("\n"); 
		query.append("--for order by, 컬럼추가시 이 사이에는 하지 말 것" ).append("\n"); 
		query.append("    OUT_VVD_CD," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT SEAL_KND_CD" ).append("\n"); 
		query.append("		FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("		WHERE BKG_NO = TB1.BKG_NO" ).append("\n"); 
		query.append("		AND CNTR_NO = TB1.CNTR_NO" ).append("\n"); 
		query.append("		AND CNTR_SEAL_SEQ > 0" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("	) SEAL_KND_CD," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT SEAL_PTY_TP_CD" ).append("\n"); 
		query.append("		FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("		WHERE BKG_NO = TB1.BKG_NO" ).append("\n"); 
		query.append("		AND CNTR_NO = TB1.CNTR_NO" ).append("\n"); 
		query.append("		AND CNTR_SEAL_SEQ > 0" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("	) SEAL_PTY_TP_CD," ).append("\n"); 
		query.append("   	VGM_WGT," ).append("\n"); 
		query.append("	SLAN_CD," ).append("\n"); 
		query.append("	CMDT_HS_CD," ).append("\n"); 
		query.append("	ROWNUM SEQ," ).append("\n"); 
		query.append("	CNTR_NO CNTR_NO2,   " ).append("\n"); 
		query.append("	PCK_TP_CD," ).append("\n"); 
		query.append("	POR_NOD_CD," ).append("\n"); 
		query.append("	POL_NOD_CD," ).append("\n"); 
		query.append("	POD_NOD_CD," ).append("\n"); 
		query.append("	DEL_NOD_CD," ).append("\n"); 
		query.append("	CUST_TO_ORD_FLG," ).append("\n"); 
		query.append("	POL_CD," ).append("\n"); 
		query.append("	POL_YD_CD," ).append("\n"); 
		query.append("	POD_CD," ).append("\n"); 
		query.append("	POD_YD_CD," ).append("\n"); 
		query.append("	MEAS_QTY,	" ).append("\n"); 
		query.append("	PRCT_FLG," ).append("\n"); 
		query.append("	DCGO_FLG," ).append("\n"); 
		query.append("	RC_FLG," ).append("\n"); 
		query.append("	AWK_CGO_FLG," ).append("\n"); 
		query.append("	HNGR_FLG," ).append("\n"); 
		query.append("	ORG_YD_CD," ).append("\n"); 
		query.append("	CNMV_EVNT_DT," ).append("\n"); 
		query.append("	PREVVD1, " ).append("\n"); 
		query.append("	PREVVD2, " ).append("\n"); 
		query.append("	PREVVD3, " ).append("\n"); 
		query.append("	PREVVD4," ).append("\n"); 
		query.append("	TRUNKVVD, " ).append("\n"); 
		query.append("	POSTVVD1, " ).append("\n"); 
		query.append("	POSTVVD2, " ).append("\n"); 
		query.append("	POSTVVD3, " ).append("\n"); 
		query.append("	POSTVVD4," ).append("\n"); 
		query.append("	PRE1POL, " ).append("\n"); 
		query.append("	PRE2POL, " ).append("\n"); 
		query.append("	PRE3POL, " ).append("\n"); 
		query.append("	PRE4POL, " ).append("\n"); 
		query.append("	POST1POL, " ).append("\n"); 
		query.append("	POST2POL, " ).append("\n"); 
		query.append("	POST3POL, " ).append("\n"); 
		query.append("	POST4POL," ).append("\n"); 
		query.append("	TO_CHAR(A_CNTR_WGT,'9,999,999.000') A_CNTR_WGT," ).append("\n"); 
		query.append("	RD_CGO_FLG," ).append("\n"); 
		query.append("	'' SPCL_CGO_DESC_TYPE," ).append("\n"); 
		query.append("	'' SPCL_CGO_DESC" ).append("\n"); 
		query.append("   ,POR_NM" ).append("\n"); 
		query.append("   ,APOL_NM" ).append("\n"); 
		query.append("   ,APOD_NM" ).append("\n"); 
		query.append("   ,BPOL_NM" ).append("\n"); 
		query.append("   ,BPOD_NM" ).append("\n"); 
		query.append("   ,DEL_NM" ).append("\n"); 
		query.append("   ,( SELECT DECODE(NVL(MAX(SO.BKG_NO), 'N'), 'N', 'N', 'Y') AS woFlg" ).append("\n"); 
		query.append("		FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("   			,TRS_TRSP_WRK_ORD WO" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("  		AND SO.TRSP_WO_OFC_CTY_CD = WO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("  		AND SO.TRSP_WO_SEQ = WO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("  		AND SO.TRSP_SO_STS_CD = 'I'" ).append("\n"); 
		query.append("  		AND NVL(SO.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("  		AND SO.BKG_NO = TB1.BKG_NO" ).append("\n"); 
		query.append("        AND SO.EQ_NO = TB1.CNTR_NO" ).append("\n"); 
		query.append("  		AND ROWNUM = 1" ).append("\n"); 
		query.append("		#if (${in_list_type} == 'L') " ).append("\n"); 
		query.append("  		AND SO.FM_NOD_CD LIKE TB1.POL_CD||'%'" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append(" 	    AND SO.TO_NOD_CD LIKE TB1.POD_CD||'%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    ) WO_FLG	 " ).append("\n"); 
		query.append("    , CSTMS_DESC	" ).append("\n"); 
		query.append("    , SUBSTR(PKUP_NOD_CD, 1, 5) PKUP_LOC_CD" ).append("\n"); 
		query.append("    , SUBSTR(PKUP_NOD_CD, 6) PKUP_NOD_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT	 " ).append("\n"); 
		query.append("	CNTR.CNTR_NO,  " ).append("\n"); 
		query.append("	#if (${in_including_type} == 'N' ) " ).append("\n"); 
		query.append("		MAX(CNTR.CNTR_TPSZ_CD) CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        MAX((SELECT SUM(ROUND(T_C.CNTR_WGT/1000,0)) FROM BKG_BOOKING T_B, BKG_CONTAINER T_C" ).append("\n"); 
		query.append("              WHERE T_B.BKG_NO = T_C.BKG_NO AND T_C.CNTR_NO = CNTR.CNTR_NO AND T_B.BKG_STS_CD<>'X'" ).append("\n"); 
		query.append("                AND (T_B.VSL_CD, T_B.SKD_VOY_NO, T_B.SKD_DIR_CD) IN (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM BKG_BOOKING TT WHERE TT.BKG_NO = BKG.BKG_NO))) CNTR_WGT," ).append("\n"); 
		query.append("        MAX((SELECT SUM(T_D.ACT_WGT) FROM BKG_BOOKING T_B, BKG_CONTAINER T_C, BKG_BL_DOC T_D" ).append("\n"); 
		query.append("              WHERE T_B.BKG_NO = T_C.BKG_NO AND T_B.BKG_NO = T_D.BKG_NO AND T_C.CNTR_NO = CNTR.CNTR_NO AND T_B.BKG_STS_CD<>'X'" ).append("\n"); 
		query.append("                AND (T_B.VSL_CD, T_B.SKD_VOY_NO, T_B.SKD_DIR_CD) IN (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM BKG_BOOKING TT WHERE TT.BKG_NO = BKG.BKG_NO))) ACT_WGT," ).append("\n"); 
		query.append("        MAX((SELECT SUM(T_C.PCK_QTY) FROM BKG_BOOKING T_B, BKG_CONTAINER T_C" ).append("\n"); 
		query.append("              WHERE T_B.BKG_NO = T_C.BKG_NO AND T_C.CNTR_NO = CNTR.CNTR_NO AND T_B.BKG_STS_CD<>'X'" ).append("\n"); 
		query.append("                AND (T_B.VSL_CD, T_B.SKD_VOY_NO, T_B.SKD_DIR_CD) IN (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM BKG_BOOKING TT WHERE TT.BKG_NO = BKG.BKG_NO))) PCK_QTY," ).append("\n"); 
		query.append("		MAX(CNTR.VGM_WGT) VGM_WGT," ).append("\n"); 
		query.append("		MAX(BKG.BKG_NO) BKG_NO," ).append("\n"); 
		query.append("		MAX(BKG.BL_NO||BKG.BL_TP_CD)  BL_NO," ).append("\n"); 
		query.append("		MAX(BKG.POR_CD) POR_CD," ).append("\n"); 
		query.append("		MAX(BKG.POL_CD)  A_POL_CD," ).append("\n"); 
		query.append("		MAX(BKG.POD_CD)  A_POD_CD," ).append("\n"); 
		query.append("		MAX(BKG.DEL_CD) DEL_CD," ).append("\n"); 
		query.append("		MAX(BKG.BLCK_STWG_CD) BLCK_STWG_CD," ).append("\n"); 
		query.append("		MAX(CNTR.RCV_TERM_CD) RCV_TERM_CD," ).append("\n"); 
		query.append("		MAX(CNTR.DE_TERM_CD) DE_TERM_CD," ).append("\n"); 
		query.append("	#if (${in_list_type} == 'L' ) 	" ).append("\n"); 
		query.append("		MAX(DECODE(BKG.POL_CD,VVD.POL_CD,'L','T'))  TS_CD,	" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		MAX(DECODE(BKG.POD_CD,VVD.POD_CD,'L','T'))  TS_CD,	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	MAX(BKG.BKG_CGO_TP_CD) BKG_CGO_TP_CD," ).append("\n"); 
		query.append("	MAX(BKG.HOT_DE_FLG) HOT_DE_FLG," ).append("\n"); 
		query.append("	#if (${in_list_type} == 'L' ) 	" ).append("\n"); 
		query.append("		MAX(PVVD.SLAN_CD) SLAN_CD," ).append("\n"); 
		query.append("		MAX(PVVD.VSL_CD||PVVD.SKD_VOY_NO||PVVD.SKD_DIR_CD)  VVD_CD,	" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		MAX(NVVD.SLAN_CD) SLAN_CD,	" ).append("\n"); 
		query.append("		MAX(NVVD.VSL_CD||NVVD.SKD_VOY_NO||NVVD.SKD_DIR_CD)  VVD_CD,	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_list_type} == 'L' ) " ).append("\n"); 
		query.append("		MAX(REPLACE(TRANSLATE(NVL(BCS.CUST_NM,' '),CHR(10),' '),'''',' '))  CUST_NM," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		MAX(DECODE(BKG.CUST_TO_ORD_FLG,'Y',REPLACE(TRANSLATE(NVL(BCN.CUST_NM,' '),CHR(10),' '),'''',' ')," ).append("\n"); 
		query.append("				  REPLACE(TRANSLATE(NVL(BCC.CUST_NM,' '),CHR(10),' '),'''',' '))) CUST_NM," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	MAX(CNTR.SOC_FLG) SOC_FLG," ).append("\n"); 
		query.append("	MAX(BKG.STWG_CD) STWG_CD," ).append("\n"); 
		query.append("    '' BLCK_STWG_HUB_LOC_CD," ).append("\n"); 
		query.append("	MAX(CM.HAMO_TRF_CD) HAMO_TRF_CD," ).append("\n"); 
		query.append("	MAX(CM.CMDT_HS_CD) CMDT_HS_CD,	" ).append("\n"); 
		query.append("    MAX((SELECT SUM(T_C.CNTR_VOL_QTY) FROM BKG_BOOKING T_B, BKG_CONTAINER T_C" ).append("\n"); 
		query.append("          WHERE T_B.BKG_NO = T_C.BKG_NO AND T_C.CNTR_NO = CNTR.CNTR_NO AND T_B.BKG_STS_CD<>'X'" ).append("\n"); 
		query.append("            AND (T_B.VSL_CD, T_B.SKD_VOY_NO, T_B.SKD_DIR_CD) IN (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM BKG_BOOKING TT WHERE TT.BKG_NO = BKG.BKG_NO))) CNTR_VOL_QTY," ).append("\n"); 
		query.append("	MAX((" ).append("\n"); 
		query.append("	    SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,2)) TOT " ).append("\n"); 
		query.append("	    FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("	    WHERE BC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("	))  TOT," ).append("\n"); 
		query.append("	MAX(CNTR.PCK_TP_CD) PCK_TP_CD," ).append("\n"); 
		query.append("	MAX(SUBSTR(BKG.POR_NOD_CD,6,2))  POR_NOD_CD," ).append("\n"); 
		query.append("	MAX(SUBSTR(BKG.POL_NOD_CD,6,2))  POL_NOD_CD," ).append("\n"); 
		query.append("	MAX(SUBSTR(BKG.POD_NOD_CD,6,2))  POD_NOD_CD," ).append("\n"); 
		query.append("	MAX(SUBSTR(BKG.DEL_NOD_CD,6,2)) DEL_NOD_CD," ).append("\n"); 
		query.append("	MAX(BKG.CUST_TO_ORD_FLG) CUST_TO_ORD_FLG," ).append("\n"); 
		query.append("	MAX(VVD.POL_CD) POL_CD," ).append("\n"); 
		query.append("	MAX(SUBSTR(VVD.POL_YD_CD,6,2)) POL_YD_CD," ).append("\n"); 
		query.append("	MAX(VVD.POD_CD) POD_CD," ).append("\n"); 
		query.append("	MAX(SUBSTR(VVD.POD_YD_CD,6,2)) POD_YD_CD," ).append("\n"); 
		query.append("    MAX((SELECT SUM(T_C.MEAS_QTY*1000) FROM BKG_BOOKING T_B, BKG_CONTAINER T_C" ).append("\n"); 
		query.append("          WHERE T_B.BKG_NO = T_C.BKG_NO AND T_C.CNTR_NO = CNTR.CNTR_NO AND T_B.BKG_STS_CD<>'X'" ).append("\n"); 
		query.append("            AND (T_B.VSL_CD, T_B.SKD_VOY_NO, T_B.SKD_DIR_CD) IN (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM BKG_BOOKING TT WHERE TT.BKG_NO = BKG.BKG_NO))) MEAS_QTY," ).append("\n"); 
		query.append("	MAX(BKG.PRCT_FLG) PRCT_FLG," ).append("\n"); 
		query.append("	MAX(CNTR.DCGO_FLG) DCGO_FLG," ).append("\n"); 
		query.append("	MAX(CNTR.RC_FLG) RC_FLG," ).append("\n"); 
		query.append("	MAX(CNTR.AWK_CGO_FLG) AWK_CGO_FLG," ).append("\n"); 
		query.append("	MAX(CNTR.HNGR_FLG) HNGR_FLG," ).append("\n"); 
		query.append("    MAX((SELECT SUM(T_C.CNTR_WGT) FROM BKG_BOOKING T_B, BKG_CONTAINER T_C" ).append("\n"); 
		query.append("          WHERE T_B.BKG_NO = T_C.BKG_NO AND T_C.CNTR_NO = CNTR.CNTR_NO AND T_B.BKG_STS_CD<>'X'" ).append("\n"); 
		query.append("            AND (T_B.VSL_CD, T_B.SKD_VOY_NO, T_B.SKD_DIR_CD) IN (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM BKG_BOOKING TT WHERE TT.BKG_NO = BKG.BKG_NO))) A_CNTR_WGT," ).append("\n"); 
		query.append("	#if (${in_list_type} == 'L' ) " ).append("\n"); 
		query.append("		MAX((SELECT	/*+ INDEX_DESC(CTM_MOVEMENT XAK12CTM_MOVEMENT) */" ).append("\n"); 
		query.append("			nvl(ORG_YD_CD,' ') ORG_YD_CD" ).append("\n"); 
		query.append("		FROM	CTM_MOVEMENT" ).append("\n"); 
		query.append("		WHERE	CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("		AND MVMT_STS_CD = 'OC'" ).append("\n"); 
		query.append("--		AND	CNMV_YR = to_char(sysdate,'YYYY')" ).append("\n"); 
		query.append("        AND CNMV_CYC_NO = CNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("		)) ORG_YD_CD," ).append("\n"); 
		query.append("		MAX((SELECT	/*+ INDEX_DESC(CTM_MOVEMENT XAK12CTM_MOVEMENT) */" ).append("\n"); 
		query.append("			to_char(CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI:SS') CNMV_EVNT_DT" ).append("\n"); 
		query.append("		FROM	CTM_MOVEMENT" ).append("\n"); 
		query.append("		WHERE	CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("		AND MVMT_STS_CD = 'OC'" ).append("\n"); 
		query.append("--		AND	CNMV_YR = to_char(sysdate,'YYYY')" ).append("\n"); 
		query.append("        AND CNMV_CYC_NO = CNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("		)) CNMV_EVNT_DT," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		MAX((SELECT	/*+ INDEX_DESC(CTM_MOVEMENT XAK12CTM_MOVEMENT) */" ).append("\n"); 
		query.append("			nvl(DEST_YD_CD,NVL(ORG_YD_CD,' ')) ORG_YD_CD" ).append("\n"); 
		query.append("		FROM	CTM_MOVEMENT" ).append("\n"); 
		query.append("		WHERE	CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("		AND MVMT_STS_CD = 'IC'" ).append("\n"); 
		query.append("--		AND	CNMV_YR = to_char(sysdate,'YYYY')" ).append("\n"); 
		query.append("        AND CNMV_CYC_NO = CNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("		)) ORG_YD_CD," ).append("\n"); 
		query.append("		MAX((SELECT	/*+ INDEX_DESC(CTM_MOVEMENT XAK12CTM_MOVEMENT) */" ).append("\n"); 
		query.append("			to_char(CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI:SS') CNMV_EVNT_DT" ).append("\n"); 
		query.append("		FROM	CTM_MOVEMENT" ).append("\n"); 
		query.append("		WHERE	CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("		AND MVMT_STS_CD = 'IC'" ).append("\n"); 
		query.append("--		AND	CNMV_YR = to_char(sysdate,'YYYY')" ).append("\n"); 
		query.append("        AND CNMV_CYC_NO = CNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("		AND ROWNUM =1" ).append("\n"); 
		query.append("		)) CNMV_EVNT_DT," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		CNTR.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("		ROUND(CNTR.CNTR_WGT/1000,0) CNTR_WGT," ).append("\n"); 
		query.append("		DOC.ACT_WGT," ).append("\n"); 
		query.append("		CNTR.PCK_QTY,	" ).append("\n"); 
		query.append("		CNTR.VGM_WGT,	 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		BKG.BKG_NO," ).append("\n"); 
		query.append("		BKG.BL_NO||BKG.BL_TP_CD BL_NO," ).append("\n"); 
		query.append("		BKG.POR_CD," ).append("\n"); 
		query.append("		BKG.POL_CD A_POL_CD," ).append("\n"); 
		query.append("		BKG.POD_CD A_POD_CD," ).append("\n"); 
		query.append("		BKG.DEL_CD," ).append("\n"); 
		query.append("		BKG.BLCK_STWG_CD," ).append("\n"); 
		query.append("		CNTR.RCV_TERM_CD," ).append("\n"); 
		query.append("		CNTR.DE_TERM_CD," ).append("\n"); 
		query.append("	#if (${in_list_type} == 'L' ) 	" ).append("\n"); 
		query.append("		DECODE(BKG.POL_CD,VVD.POL_CD,'L','T') TS_CD,	" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		DECODE(BKG.POD_CD,VVD.POD_CD,'L','T') TS_CD,	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	BKG.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("	BKG.HOT_DE_FLG," ).append("\n"); 
		query.append("	#if (${in_list_type} == 'L' ) 	" ).append("\n"); 
		query.append("		PVVD.SLAN_CD," ).append("\n"); 
		query.append("		PVVD.VSL_CD||PVVD.SKD_VOY_NO||PVVD.SKD_DIR_CD VVD_CD,	" ).append("\n"); 
		query.append("	#else	" ).append("\n"); 
		query.append("		NVVD.SLAN_CD," ).append("\n"); 
		query.append("		NVVD.VSL_CD||NVVD.SKD_VOY_NO||NVVD.SKD_DIR_CD VVD_CD,	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_list_type} == 'L' ) " ).append("\n"); 
		query.append("		REPLACE(TRANSLATE(NVL(BCS.CUST_NM,' '),CHR(10),' '),'''',' ') CUST_NM," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		DECODE(BKG.CUST_TO_ORD_FLG,'Y',REPLACE(TRANSLATE(NVL(BCN.CUST_NM,' '),CHR(10),' '),'''',' ')," ).append("\n"); 
		query.append("				  REPLACE(TRANSLATE(NVL(MAX(BCC.CUST_NM),' '),CHR(10),' '),'''',' ')) CUST_NM," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	CNTR.SOC_FLG," ).append("\n"); 
		query.append("	BKG.STWG_CD," ).append("\n"); 
		query.append("    '' BLCK_STWG_HUB_LOC_CD," ).append("\n"); 
		query.append("	CM.HAMO_TRF_CD," ).append("\n"); 
		query.append("	CM.CMDT_HS_CD," ).append("\n"); 
		query.append("	CNTR.CNTR_VOL_QTY," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	    SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,2)) TOT " ).append("\n"); 
		query.append("	    FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("	    WHERE BC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("	) TOT," ).append("\n"); 
		query.append("	CNTR.PCK_TP_CD," ).append("\n"); 
		query.append("	SUBSTR(BKG.POR_NOD_CD,6,2) POR_NOD_CD," ).append("\n"); 
		query.append("	SUBSTR(BKG.POL_NOD_CD,6,2) POL_NOD_CD," ).append("\n"); 
		query.append("	SUBSTR(BKG.POD_NOD_CD,6,2) POD_NOD_CD," ).append("\n"); 
		query.append("	SUBSTR(BKG.DEL_NOD_CD,6,2) DEL_NOD_CD," ).append("\n"); 
		query.append("	BKG.CUST_TO_ORD_FLG," ).append("\n"); 
		query.append("	VVD.POL_CD," ).append("\n"); 
		query.append("	SUBSTR(VVD.POL_YD_CD,6,2) POL_YD_CD," ).append("\n"); 
		query.append("	VVD.POD_CD," ).append("\n"); 
		query.append("	SUBSTR(VVD.POD_YD_CD,6,2) POD_YD_CD," ).append("\n"); 
		query.append("	CNTR.MEAS_QTY*1000 MEAS_QTY," ).append("\n"); 
		query.append("	BKG.PRCT_FLG," ).append("\n"); 
		query.append("	CNTR.DCGO_FLG," ).append("\n"); 
		query.append("	CNTR.RC_FLG," ).append("\n"); 
		query.append("	CNTR.AWK_CGO_FLG," ).append("\n"); 
		query.append("	CNTR.HNGR_FLG," ).append("\n"); 
		query.append("	MAX(CNTR.CNTR_WGT)  A_CNTR_WGT," ).append("\n"); 
		query.append("	#if (${in_list_type} == 'L' ) " ).append("\n"); 
		query.append("		(SELECT	/*+ INDEX_DESC(CTM_MOVEMENT XAK12CTM_MOVEMENT) */" ).append("\n"); 
		query.append("			nvl(ORG_YD_CD,' ') ORG_YD_CD" ).append("\n"); 
		query.append("		FROM	CTM_MOVEMENT" ).append("\n"); 
		query.append("		WHERE	CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("		AND MVMT_STS_CD = 'OC'" ).append("\n"); 
		query.append("--		AND	CNMV_YR = to_char(sysdate,'YYYY')" ).append("\n"); 
		query.append("        AND CNMV_CYC_NO = CNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("		) ORG_YD_CD," ).append("\n"); 
		query.append("		(SELECT	/*+ INDEX_DESC(CTM_MOVEMENT XAK12CTM_MOVEMENT) */" ).append("\n"); 
		query.append("			to_char(CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI:SS') CNMV_EVNT_DT" ).append("\n"); 
		query.append("		FROM	CTM_MOVEMENT" ).append("\n"); 
		query.append("		WHERE	CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("		AND MVMT_STS_CD = 'OC'" ).append("\n"); 
		query.append("--		AND	CNMV_YR = to_char(sysdate,'YYYY')" ).append("\n"); 
		query.append("        AND CNMV_CYC_NO = CNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("		) CNMV_EVNT_DT," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		(SELECT	/*+ INDEX_DESC(CTM_MOVEMENT XAK12CTM_MOVEMENT) */" ).append("\n"); 
		query.append("			nvl(DEST_YD_CD,NVL(ORG_YD_CD,' ')) ORG_YD_CD" ).append("\n"); 
		query.append("		FROM	CTM_MOVEMENT" ).append("\n"); 
		query.append("		WHERE	CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("		AND MVMT_STS_CD = 'IC'" ).append("\n"); 
		query.append("--		AND	CNMV_YR = to_char(sysdate,'YYYY')" ).append("\n"); 
		query.append("        AND CNMV_CYC_NO = CNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("		) ORG_YD_CD," ).append("\n"); 
		query.append("		(SELECT	/*+ INDEX_DESC(CTM_MOVEMENT XAK12CTM_MOVEMENT) */" ).append("\n"); 
		query.append("			to_char(CNMV_EVNT_DT,'YYYY-MM-DD HH24:MI:SS') CNMV_EVNT_DT" ).append("\n"); 
		query.append("		FROM	CTM_MOVEMENT" ).append("\n"); 
		query.append("		WHERE	CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("		AND MVMT_STS_CD = 'IC'" ).append("\n"); 
		query.append("--		AND	CNMV_YR = to_char(sysdate,'YYYY')" ).append("\n"); 
		query.append("        AND CNMV_CYC_NO = CNTR.CNMV_CYC_NO" ).append("\n"); 
		query.append("		AND ROWNUM =1" ).append("\n"); 
		query.append("		) CNMV_EVNT_DT," ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	TEMP.VVD_CD AS OUT_VVD_CD," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'S',DECODE(BKGVVD.VSL_SEQ,'1',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD))) PREVVD1," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'S',DECODE(BKGVVD.VSL_SEQ,'2',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD))) PREVVD2," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'S',DECODE(BKGVVD.VSL_SEQ,'3',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD))) PREVVD3," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'S',DECODE(BKGVVD.VSL_SEQ,'4',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD))) PREVVD4," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'S',DECODE(BKGVVD.VSL_SEQ,'1',BKGVVD.POL_CD))) PRE1POL," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'S',DECODE(BKGVVD.VSL_SEQ,'2',BKGVVD.POL_CD))) PRE2POL," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'S',DECODE(BKGVVD.VSL_SEQ,'3',BKGVVD.POL_CD))) PRE3POL," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'S',DECODE(BKGVVD.VSL_SEQ,'4',BKGVVD.POL_CD))) PRE4POL," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'T',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD)) TRUNKVVD," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'U',DECODE(BKGVVD.VSL_SEQ,'1',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD))) POSTVVD1," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'U',DECODE(BKGVVD.VSL_SEQ,'2',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD))) POSTVVD2," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'U',DECODE(BKGVVD.VSL_SEQ,'3',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD))) POSTVVD3," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'U',DECODE(BKGVVD.VSL_SEQ,'4',BKGVVD.VSL_CD||BKGVVD.SKD_VOY_NO||BKGVVD.SKD_DIR_CD))) POSTVVD4," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'U',DECODE(BKGVVD.VSL_SEQ,'1',BKGVVD.POL_CD))) POST1POL," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'U',DECODE(BKGVVD.VSL_SEQ,'2',BKGVVD.POL_CD))) POST2POL," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'U',DECODE(BKGVVD.VSL_SEQ,'3',BKGVVD.POL_CD))) POST3POL," ).append("\n"); 
		query.append("	MAX(DECODE(BKGVVD.VSL_PRE_PST_CD,'U',DECODE(BKGVVD.VSL_SEQ,'4',BKGVVD.POL_CD))) POST4POL" ).append("\n"); 
		query.append("   ,MAX(POR.LOC_NM) AS POR_NM" ).append("\n"); 
		query.append("   ,MAX(APOL.LOC_NM) AS APOL_NM" ).append("\n"); 
		query.append("   ,MAX(APOD.LOC_NM) AS APOD_NM" ).append("\n"); 
		query.append("   ,MAX(BPOL.LOC_NM) AS BPOL_NM" ).append("\n"); 
		query.append("   ,MAX(BPOD.LOC_NM) AS BPOD_NM" ).append("\n"); 
		query.append("   ,MAX(DEL.LOC_NM) AS DEL_NM" ).append("\n"); 
		query.append("   ,DECODE(SUBSTR(MAX(CNTR.CNTR_TPSZ_CD),1,1),'R',MAX(CNTR.RD_CGO_FLG),'N') AS RD_CGO_FLG--tank reefer 는 Y, Y 들어감" ).append("\n"); 
		query.append("--2013.02.19 장인호 추가" ).append("\n"); 
		query.append("   ,(select max(nvl(spec.tare_wgt, 0)) mst_wgt" ).append("\n"); 
		query.append("            from mst_container mst," ).append("\n"); 
		query.append("              mst_cntr_spec spec" ).append("\n"); 
		query.append("            where mst.cntr_no = cntr.CNTR_NO" ).append("\n"); 
		query.append("              and mst.cntr_spec_no = spec.cntr_spec_no ) mst_tare," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            select max(nvl(mdm.CNTR_TPSZ_TARE_WGT, 0)) mdm_wgt" ).append("\n"); 
		query.append("            from mdm_cntr_tp_sz mdm" ).append("\n"); 
		query.append("            where mdm.cntr_tpsz_cd = CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ) mdm_tare" ).append("\n"); 
		query.append("    , MAX(DOC.CSTMS_DESC) CSTMS_DESC" ).append("\n"); 
		query.append("    , MAX((SELECT /*+ ORDERED USE_NL(H D) INDEX_DESC(D XPKSCE_COP_DTL) */" ).append("\n"); 
		query.append("                D.NOD_CD" ).append("\n"); 
		query.append("         FROM SCE_COP_HDR H, SCE_COP_DTL D" ).append("\n"); 
		query.append("        WHERE H.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("          AND H.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("          AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("		  AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("          AND D.ACT_CD LIKE 'FI%DO' " ).append("\n"); 
		query.append("          AND SUBSTR(D.NOD_CD, 1, 2) IN ('US','CA')" ).append("\n"); 
		query.append("    	  AND ROWNUM = 1 " ).append("\n"); 
		query.append("	)) PKUP_NOD_CD" ).append("\n"); 
		query.append("	FROM	" ).append("\n"); 
		query.append("		BKG_BOOKING BKG, " ).append("\n"); 
		query.append("		BKG_CONTAINER CNTR, " ).append("\n"); 
		query.append("		BKG_BL_DOC DOC," ).append("\n"); 
		query.append("		BKG_VVD VVD, " ).append("\n"); 
		query.append("		BKG_VVD BKGVVD, " ).append("\n"); 
		query.append("	#if (${in_list_type} == 'L' ) " ).append("\n"); 
		query.append("		BKG_VVD PVVD, " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		BKG_CUSTOMER BCS, " ).append("\n"); 
		query.append("		BKG_CUSTOMER BCC, " ).append("\n"); 
		query.append("		BKG_CUSTOMER BCN, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		BKG_CNTR_MF_DESC CM," ).append("\n"); 
		query.append("		MDM_LOCATION MDM" ).append("\n"); 
		query.append("	#if (${in_list_type} == 'D' ) " ).append("\n"); 
		query.append("		, BKG_VVD NVVD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("        ,MDM_LOCATION POR" ).append("\n"); 
		query.append("        ,MDM_LOCATION APOL" ).append("\n"); 
		query.append("        ,MDM_LOCATION APOD" ).append("\n"); 
		query.append("        ,MDM_LOCATION BPOL" ).append("\n"); 
		query.append("        ,MDM_LOCATION BPOD" ).append("\n"); 
		query.append("        ,MDM_LOCATION DEL" ).append("\n"); 
		query.append("        ,(SELECT TRIM(COLUMN_VALUE) AS VVD_CD FROM table(BKG_SPLIT_FNC(@[in_vvd_cd],','))) TEMP " ).append("\n"); 
		query.append("	WHERE	VVD.VSL_CD = SUBSTR(TEMP.VVD_CD,1,4)" ).append("\n"); 
		query.append("	AND VVD.SKD_VOY_NO = SUBSTR(TEMP.VVD_CD,5,4)" ).append("\n"); 
		query.append("	AND VVD.SKD_DIR_CD = SUBSTR(TEMP.VVD_CD,9,1)" ).append("\n"); 
		query.append("	AND BKG.BKG_NO = BKGVVD.BKG_NO" ).append("\n"); 
		query.append("	AND BKG.BKG_STS_CD  <> 'S'" ).append("\n"); 
		query.append("#if(${pop_mode} == 'VGM')" ).append("\n"); 
		query.append("    AND BKG.BKG_NO IN (${bkg_no_list})" ).append("\n"); 
		query.append("	AND CNTR.VGM_WGT > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	AND BKG.POR_CD = POR.LOC_CD(+)" ).append("\n"); 
		query.append("	AND BKG.POL_CD = APOL.LOC_CD(+)" ).append("\n"); 
		query.append("	AND BKG.POD_CD = APOD.LOC_CD(+)" ).append("\n"); 
		query.append("	AND VVD.POL_CD = BPOL.LOC_CD(+)" ).append("\n"); 
		query.append("	AND VVD.POD_CD = BPOD.LOC_CD(+)" ).append("\n"); 
		query.append("	AND BKG.DEL_CD = DEL.LOC_CD(+)" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${in_list_type} == 'L' ) " ).append("\n"); 
		query.append("		AND VVD.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("		#if (${in_pol_yd_cd} != '' ) " ).append("\n"); 
		query.append("			AND SUBSTR(VVD.POL_YD_CD,6,2) = @[in_pol_yd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_pod_cd} != '' ) " ).append("\n"); 
		query.append("			AND VVD.POD_CD LIKE @[in_pod_cd]||'%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_pod_yd_cd} != '' ) " ).append("\n"); 
		query.append("			AND SUBSTR(VVD.POD_YD_CD,6,2) = @[in_pod_yd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_pol_ts} != '' ) " ).append("\n"); 
		query.append("			AND DECODE(BKG.POL_CD,VVD.POL_CD,'L','T') = @[in_pol_ts]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if (${in_pol_cd} != '' ) " ).append("\n"); 
		query.append("			AND VVD.POL_CD LIKE @[in_pol_cd]||'%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_pol_yd_cd} != '' ) " ).append("\n"); 
		query.append("			AND SUBSTR(VVD.POL_YD_CD,6,2) = @[in_pol_yd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND VVD.POD_CD = @[in_pod_cd]" ).append("\n"); 
		query.append("		#if (${in_pod_yd_cd} != '' ) " ).append("\n"); 
		query.append("			AND SUBSTR(VVD.POD_YD_CD,6,2) = @[in_pod_yd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_pod_ts} != '' ) " ).append("\n"); 
		query.append("			AND DECODE(BKG.POD_CD,VVD.POD_CD,'L','T') = @[in_pod_ts]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("	#if (${in_list_type} == 'L' ) " ).append("\n"); 
		query.append("		AND VVD.BKG_NO = PVVD.BKG_NO (+)" ).append("\n"); 
		query.append("		AND PVVD.POD_CD (+) = @[in_pol_cd]" ).append("\n"); 
		query.append("		AND PVVD.VSL_PRE_PST_CD(+) || PVVD.VSL_SEQ(+) < VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_list_type} == 'D' ) " ).append("\n"); 
		query.append("		AND VVD.BKG_NO = NVVD.BKG_NO (+)	" ).append("\n"); 
		query.append("		AND NVVD.POL_CD (+) = @[in_pod_cd]" ).append("\n"); 
		query.append("		AND NVVD.VSL_PRE_PST_CD(+) || NVVD.VSL_SEQ(+) > VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ" ).append("\n"); 
		query.append("		AND BKG.POD_CD <> 'XXXXX'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	AND BKG.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("	AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	AND BKG.BKG_NO = BCS.BKG_NO" ).append("\n"); 
		query.append("	AND BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("	AND BKG.BKG_NO = BCC.BKG_NO " ).append("\n"); 
		query.append("	AND BCC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("	AND BKG.BKG_NO = BCN.BKG_NO " ).append("\n"); 
		query.append("	AND BCN.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("	#if (${in_ofc_cd_type} == 'B' ) " ).append("\n"); 
		query.append("		#if (${in_ofc_cd} != '' ) " ).append("\n"); 
		query.append("			AND BKG.BKG_OFC_CD = @[in_ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if (${in_list_type} == 'L' ) " ).append("\n"); 
		query.append("			#if (${in_ofc_cd} != '' ) " ).append("\n"); 
		query.append("				AND BKG.OB_SLS_OFC_CD = @[in_ofc_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			#if (${in_ofc_cd} != '' ) " ).append("\n"); 
		query.append("				AND BKG.IB_SLS_OFC_CD = @[in_ofc_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_bkg_sts_cd} == 'A' )" ).append("\n"); 
		query.append("		AND NVL(BKG.BKG_STS_CD,' ') NOT IN ('X','A')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if (${in_bkg_sts_cd} != '' ) " ).append("\n"); 
		query.append("			AND BKG.BKG_STS_CD = @[in_bkg_sts_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_bkg_cgo_tp_cd} != '' && ${in_bkg_cgo_tp_cd} != 'A' ) " ).append("\n"); 
		query.append("		AND BKG.BKG_CGO_TP_CD IN (${in_bkg_cgo_tp_cd})" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_cntr_cfm_flg} != '' ) " ).append("\n"); 
		query.append("		AND CNTR.CNTR_CFM_FLG = @[in_cntr_cfm_flg]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_cntr_tpsz_cd} != '' ) " ).append("\n"); 
		query.append("		AND CNTR.CNTR_TPSZ_CD IN (${in_cntr_tpsz_cd})" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_por_cd} != '' ) " ).append("\n"); 
		query.append("		AND BKG.POR_CD LIKE @[in_por_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_del_cd} != '' ) " ).append("\n"); 
		query.append("		AND BKG.DEL_CD LIKE @[in_del_cd]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_rcv_term_cd} != '' ) " ).append("\n"); 
		query.append("		AND CNTR.RCV_TERM_CD IN (${in_rcv_term_cd})" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_de_term_cd} != '' ) " ).append("\n"); 
		query.append("		AND CNTR.DE_TERM_CD IN (${in_de_term_cd})" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_org_trns_svd_mod_cd} != '' ) " ).append("\n"); 
		query.append("		AND BKG.ORG_TRNS_SVC_MOD_CD IN (${in_org_trns_svd_mod_cd})" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_dest_trns_svc_mod_cd} != '' ) " ).append("\n"); 
		query.append("		AND BKG.DEST_TRNS_SVC_MOD_CD IN (${in_dest_trns_svc_mod_cd})" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${in_dcgo_flg} == '' && ${in_rc_flg} == '' && ${in_awk_cgo_flg} == '' && ${in_bb_cgo_flg} == '' && ${in_stwg_cd} == '' && ${in_hot_de_flg} == '' && ${in_rd_cgo_flg} == '' && ${in_soc_flg} == '' && ${in_prct_flg} == '' && ${in_hngr_flg} == '')" ).append("\n"); 
		query.append("		AND '1' = '1'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND ( '1' = '2' " ).append("\n"); 
		query.append("		#if (${in_dcgo_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.DCGO_FLG = @[in_dcgo_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_rc_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.RC_FLG = @[in_rc_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_awk_cgo_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.AWK_CGO_FLG = @[in_awk_cgo_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_bb_cgo_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.BB_CGO_FLG = @[in_bb_cgo_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_stwg_cd} != '' ) " ).append("\n"); 
		query.append("			OR BKG.STWG_CD IS NOT NULL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_hot_de_flg} != '' ) " ).append("\n"); 
		query.append("			OR BKG.HOT_DE_FLG = @[in_hot_de_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_rd_cgo_flg} != '' ) " ).append("\n"); 
		query.append("			OR (SUBSTR(CNTR.CNTR_TPSZ_CD,1,1)='R' AND CNTR.RD_CGO_FLG = @[in_rd_cgo_flg])" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_soc_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.SOC_FLG = @[in_soc_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_prct_flg} != '' ) " ).append("\n"); 
		query.append("			OR BKG.PRCT_FLG = @[in_prct_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${in_hngr_flg} != '' ) " ).append("\n"); 
		query.append("			OR CNTR.HNGR_FLG = @[in_hngr_flg]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	AND MDM.LOC_CD = BKG.DEL_CD" ).append("\n"); 
		query.append("	#if (${in_scc_cd} != '' ) " ).append("\n"); 
		query.append("		AND MDM.SCC_CD = @[in_scc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	--AND BKG.POD_CD = TBSD.BLCK_STWG_PORT_LOC_CD (+)" ).append("\n"); 
		query.append("	--AND BKG.DEL_CD = TBSD.BLCK_STWG_DEST_LOC_CD (+)" ).append("\n"); 
		query.append("	AND CNTR.BKG_NO = CM.BKG_NO (+)	" ).append("\n"); 
		query.append("	AND CNTR.CNTR_NO = CM.CNTR_NO (+)	" ).append("\n"); 
		query.append("	AND CM.CNTR_MF_SEQ (+) = 1	" ).append("\n"); 
		query.append("	#if (${in_including_type} == 'N' ) " ).append("\n"); 
		query.append("		GROUP BY TEMP.VVD_CD, CNTR.CNTR_NO, CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		GROUP BY TEMP.VVD_CD, CNTR.CNTR_NO, CNTR.CNTR_TPSZ_CD, CNTR.CNTR_WGT, DOC.ACT_WGT, CNTR.PCK_QTY,CNTR.VGM_WGT, BKG.BKG_NO, BKG.BL_NO||BKG.BL_TP_CD, " ).append("\n"); 
		query.append("			BKG.POR_CD, BKG.POL_CD, BKG.POD_CD, BKG.DEL_CD, BKG.BLCK_STWG_CD, CNTR.RCV_TERM_CD," ).append("\n"); 
		query.append("			CNTR.DE_TERM_CD, BKG.POL_CD, VVD.POL_CD, BKG.POD_CD, VVD.POD_CD, BKG.BKG_CGO_TP_CD, BKG.HOT_DE_FLG, " ).append("\n"); 
		query.append("		#if (${in_list_type} == 'L' ) 	" ).append("\n"); 
		query.append("			PVVD.SLAN_CD, PVVD.VSL_CD||PVVD.SKD_VOY_NO||PVVD.SKD_DIR_CD, BCS.CUST_NM," ).append("\n"); 
		query.append("		#else	" ).append("\n"); 
		query.append("			NVVD.SLAN_CD, NVVD.VSL_CD||NVVD.SKD_VOY_NO||NVVD.SKD_DIR_CD, BKG.CUST_TO_ORD_FLG, BCN.CUST_NM," ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("			CNTR.SOC_FLG, BKG.STWG_CD, CM.HAMO_TRF_CD, CM.CMDT_HS_CD, CNTR.CNTR_VOL_QTY, CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("			CNTR.PCK_TP_CD, BKG.POR_NOD_CD, BKG.POL_NOD_CD, BKG.POD_NOD_CD, BKG.DEL_NOD_CD, BKG.CUST_TO_ORD_FLG, VVD.POL_CD, " ).append("\n"); 
		query.append("			VVD.POL_YD_CD, VVD.POD_CD, VVD.POD_YD_CD, CNTR.MEAS_QTY, BKG.PRCT_FLG, CNTR.DCGO_FLG, CNTR.RC_FLG, CNTR.AWK_CGO_FLG, CNTR.HNGR_FLG," ).append("\n"); 
		query.append("		#if (${in_list_type} == 'L' ) " ).append("\n"); 
		query.append("			ORG_YD_CD, CNMV_EVNT_DT, CNMV_CYC_NO" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			DEST_YD_CD, ORG_YD_CD, CNMV_EVNT_DT, CNMV_CYC_NO" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(") TB1" ).append("\n"); 
		query.append("#if (${in_pkup_nod_cd} != '' ) " ).append("\n"); 
		query.append("WHERE PKUP_NOD_CD = @[in_pkup_nod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_order_by_type} == '' ) " ).append("\n"); 
		query.append("ORDER BY OUT_VVD_CD, POL_CD, POD_CD, CNTR_NO, BKG_NO" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("ORDER BY ${in_order_by_type}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}