/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchKorCllTsListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchKorCllTsListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchKorCllTsList
	  * 2017.04.13 iylee Stowage Code='OLBP' 이면 Block Stowage Code = 'LBP'
	  * 2017.05.25 iylee Stowage Code='OLBS' 이면 Block Stowage Code = 'LBS'
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchKorCllTsListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_cntr_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchKorCllTsListRSQL").append("\n"); 
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
		query.append("	ROWNUM SEQ," ).append("\n"); 
		query.append("	VSL_CD," ).append("\n"); 
		query.append("	SKD_VOY_NO," ).append("\n"); 
		query.append("	SKD_DIR_CD," ).append("\n"); 
		query.append("	POL_CD," ).append("\n"); 
		query.append("	CNTR_NO," ).append("\n"); 
		query.append("	SUBSTR(BL_NO,2) BL_NO," ).append("\n"); 
		query.append("	SUBSTR(BKG_NO,2) BKG_NO, " ).append("\n"); 
		query.append("	CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	MTY_BKG_CD," ).append("\n"); 
		query.append("	SEAL_NO," ).append("\n"); 
		query.append("	BL_WGT," ).append("\n"); 
		query.append("	WGT_UT_CD," ).append("\n"); 
		query.append("	RCV_TERM_CD," ).append("\n"); 
		query.append("	TS_FLG," ).append("\n"); 
		query.append("	IMDG_CLSS_CD," ).append("\n"); 
		query.append("	IMDG_UN_NO," ).append("\n"); 
		query.append("	CDO_TEMP," ).append("\n"); 
		query.append("	CNTR_VENT_CD," ).append("\n"); 
		query.append("	HAMO_TRF_CD," ).append("\n"); 
		query.append("	CMDT_HS_CD," ).append("\n"); 
		query.append("	CLL_RMK1," ).append("\n"); 
		query.append("	CLL_RMK2," ).append("\n"); 
		query.append("	CLL_RMK3," ).append("\n"); 
		query.append("    NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD =  POD_CD  ), POD_CD ) POD_CD," ).append("\n"); 
		query.append("	BLCK_STWG_CD," ).append("\n"); 
		query.append("	TS_VSL_CD||TS_SKD_VOY_NO||TS_SKD_DIR_CD TS_VVD_CD," ).append("\n"); 
		query.append("	OVR_LEN_QTY," ).append("\n"); 
		query.append("	OVR_WGT_QTY," ).append("\n"); 
		query.append("	OVR_HGT_QTY," ).append("\n"); 
		query.append("	MIN_TEMP," ).append("\n"); 
		query.append("	MAX_TEMP," ).append("\n"); 
		query.append("	KR_TML_PRCT_ID," ).append("\n"); 
		query.append("	POD_YD_CD," ).append("\n"); 
		query.append("	POL_YD_CD," ).append("\n"); 
		query.append("	MRN_POLUT_FLG," ).append("\n"); 
		query.append("	STWG_CD," ).append("\n"); 
		query.append("	XTER_RMK," ).append("\n"); 
		query.append("	A_POD_CD," ).append("\n"); 
		query.append("	T_VSL_CD," ).append("\n"); 
		query.append("	BKG_POL_CD," ).append("\n"); 
		query.append("	'' VVD_CD_NM,	" ).append("\n"); 
		query.append("	'' POL_CD_PRINT," ).append("\n"); 
		query.append("	'' VPS_ETD," ).append("\n"); 
		query.append("	BC_CD," ).append("\n"); 
		query.append("    VGM_WGT," ).append("\n"); 
		query.append("	VGM_WGT_UT_CD ," ).append("\n"); 
		query.append("	VGM_VRFY_SIG_CTNT," ).append("\n"); 
		query.append("    VGM_MZD_TP_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	VSL_CD," ).append("\n"); 
		query.append("	SKD_VOY_NO," ).append("\n"); 
		query.append("	SKD_DIR_CD," ).append("\n"); 
		query.append("	POL_CD," ).append("\n"); 
		query.append("	CNTR_NO," ).append("\n"); 
		query.append("	BL_NO," ).append("\n"); 
		query.append("	BKG_NO," ).append("\n"); 
		query.append("	CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	MTY_BKG_CD," ).append("\n"); 
		query.append("	SEAL_NO," ).append("\n"); 
		query.append("	BL_WGT," ).append("\n"); 
		query.append("	WGT_UT_CD," ).append("\n"); 
		query.append("	RCV_TERM_CD," ).append("\n"); 
		query.append("	TS_FLG," ).append("\n"); 
		query.append("	DECODE(TS_FLG, 'TS', '2', 'TT', '3', '1') AA," ).append("\n"); 
		query.append("	IMDG_CLSS_CD," ).append("\n"); 
		query.append("	IMDG_UN_NO," ).append("\n"); 
		query.append("	CDO_TEMP," ).append("\n"); 
		query.append("	CNTR_VENT_CD," ).append("\n"); 
		query.append("	HAMO_TRF_CD," ).append("\n"); 
		query.append("	CMDT_HS_CD," ).append("\n"); 
		query.append("	SUBSTR(CLL_RMK, 1, INSTR(CLL_RMK,'|')-1) CLL_RMK1," ).append("\n"); 
		query.append("	SUBSTR(CLL_RMK, INSTR(CLL_RMK,'|')+1) CLL_RMK2," ).append("\n"); 
		query.append("	CLL_RMK3," ).append("\n"); 
		query.append("	DECODE(POD_CD,'USSEA',DECODE(VVD_SLAN_CD, 'PNH', DECODE(BC_CD, 'SE8', 'USSE8', DECODE(BLCK_STWG_CD,'ONE','USSE1','USSEA')), DECODE(BLCK_STWG_CD,'ONE','USSE1','USSEA'))" ).append("\n"); 
		query.append("				,'CAVAN',DECODE(BLCK_STWG_CD,'LOC','CAYVR','ONE','CAVA1','CAVAN')" ).append("\n"); 
		query.append("				,'CAPRR', DECODE(BC_CD, 'PR1', 'CAPR1', 'CAPRR'), POD_CD) POD_CD," ).append("\n"); 
		query.append("	DECODE(STWG_CD, 'OLBP', 'LBP', 'OLBS', 'LBS', 'OLBL', 'LBL', BLCK_STWG_CD) BLCK_STWG_CD," ).append("\n"); 
		query.append("	TS_VSL_CD," ).append("\n"); 
		query.append("	TS_SKD_VOY_NO," ).append("\n"); 
		query.append("	TS_SKD_DIR_CD," ).append("\n"); 
		query.append("	OVR_LEN_QTY," ).append("\n"); 
		query.append("	OVR_WGT_QTY," ).append("\n"); 
		query.append("	OVR_HGT_QTY," ).append("\n"); 
		query.append("	MIN_TEMP," ).append("\n"); 
		query.append("	MAX_TEMP," ).append("\n"); 
		query.append("	KR_TML_PRCT_ID," ).append("\n"); 
		query.append("	POD_YD_CD," ).append("\n"); 
		query.append("	POL_YD_CD," ).append("\n"); 
		query.append("	MRN_POLUT_FLG," ).append("\n"); 
		query.append("	STWG_CD," ).append("\n"); 
		query.append("	XTER_RMK," ).append("\n"); 
		query.append("	A_POD_CD," ).append("\n"); 
		query.append("	T_VSL_CD," ).append("\n"); 
		query.append("	BKG_POL_CD," ).append("\n"); 
		query.append("	BC_CD," ).append("\n"); 
		query.append("    VGM_WGT," ).append("\n"); 
		query.append("	VGM_WGT_UT_CD ," ).append("\n"); 
		query.append("	VGM_VRFY_SIG_CTNT," ).append("\n"); 
		query.append("    VGM_MZD_TP_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("SELECT	" ).append("\n"); 
		query.append("	MAX(T2.a01) CNTR_NO,		" ).append("\n"); 
		query.append("	MAX(T2.a02) CNTR_TPSZ_CD,		" ).append("\n"); 
		query.append("	MIN(T2.a03) SEAL_NO,		" ).append("\n"); 
		query.append("	MAX(T2.a04) WGT_UT_CD,		" ).append("\n"); 
		query.append("	MAX(TO_CHAR(DECODE(T2.a05,0,DECODE(T2.a46,0,T2.a47,T2.a46+T2.a47),T2.a05+T2.a47))) BL_WGT,	" ).append("\n"); 
		query.append("	MAX(T2.a12) TS_VSL_CD,		" ).append("\n"); 
		query.append("	MAX(T2.a13) TS_SKD_VOY_NO,	" ).append("\n"); 
		query.append("	MAX(T2.a14) TS_SKD_DIR_CD,		" ).append("\n"); 
		query.append("	MAX(T2.a15) RCV_TERM_CD,		" ).append("\n"); 
		query.append("	MAX(T2.a21) POL_CD,		" ).append("\n"); 
		query.append("	MAX(T2.a16) BKG_POL_CD,	" ).append("\n"); 
		query.append("	MAX(DECODE(T2.a06,'Y','Z'||T2.a17,'A'||T2.a17)) BL_NO,		" ).append("\n"); 
		query.append("	MAX(T2.a18) MTY_BKG_CD,		    	" ).append("\n"); 
		query.append("	MAX(DECODE(T2.a06,'Y','Z'||T2.a20,'A'||T2.a20)) BKG_NO,	" ).append("\n"); 
		query.append("	MAX(T2.a22) POD_CD," ).append("\n"); 
		query.append("	MAX(T2.a10) A_POD_CD,		" ).append("\n"); 
		query.append("	MAX(T2.a23) VSL_CD,		" ).append("\n"); 
		query.append("	MAX(T2.a24) SKD_VOY_NO,		 " ).append("\n"); 
		query.append("	MAX(T2.a25) SKD_DIR_CD,		" ).append("\n"); 
		query.append("	MAX(T2.a28) BLCK_STWG_CD," ).append("\n"); 
		query.append("	MAX(DECODE(T2.a31,NULL,'TS','TT')) TS_FLG," ).append("\n"); 
		query.append("	MAX(SUBSTR(T2.a32, 1, 5)) IMDG_UN_NO,	" ).append("\n"); 
		query.append("	MAX(T2.a59) CDO_TEMP,	" ).append("\n"); 
		query.append("	MAX(T1.IMDG_CLSS_CD) IMDG_CLSS_CD,	" ).append("\n"); 
		query.append("	MAX(T2.a39) CNTR_VENT_CD,	" ).append("\n"); 
		query.append("	MAX(CM.HAMO_TRF_CD) HAMO_TRF_CD," ).append("\n"); 
		query.append("	MAX(CM.CMDT_HS_CD) CMDT_HS_CD," ).append("\n"); 
		query.append("	MAX(T2.a41) OVR_LEN_QTY,	" ).append("\n"); 
		query.append("	MAX(T2.a43) OVR_HGT_QTY,		" ).append("\n"); 
		query.append("	MAX(T2.a44) OVR_WGT_QTY,		" ).append("\n"); 
		query.append("	MAX(T2.A50) KR_TML_PRCT_ID,		" ).append("\n"); 
		query.append("	MAX(T2.a51) POD_YD_CD,		" ).append("\n"); 
		query.append("	MAX(T2.a52) POL_YD_CD,	" ).append("\n"); 
		query.append("	MAX(T2.a53) MRN_POLUT_FLG, 	" ).append("\n"); 
		query.append("	MAX(T2.a54) STWG_CD, 		" ).append("\n"); 
		query.append("	MAX(T2.a55) XTER_RMK, 		" ).append("\n"); 
		query.append("	MAX('') MIN_TEMP, " ).append("\n"); 
		query.append("	MAX('') MAX_TEMP," ).append("\n"); 
		query.append("--	MAX(T2.a56) CLL_RMK1," ).append("\n"); 
		query.append("--	MAX(T2.a57) CLL_RMK2," ).append("\n"); 
		query.append("	MIN(T2.a99) CLL_RMK," ).append("\n"); 
		query.append("	MAX(T2.a58) CLL_RMK3," ).append("\n"); 
		query.append("	MAX('') T_VSL_CD," ).append("\n"); 
		query.append("	MAX(T2.BC_CD) BC_CD," ).append("\n"); 
		query.append("	MAX(T2.VVD_SLAN_CD) VVD_SLAN_CD," ).append("\n"); 
		query.append("    MAX(T2.VGM_WGT) VGM_WGT," ).append("\n"); 
		query.append("	MAX(T2.VGM_WGT_UT_CD) VGM_WGT_UT_CD ," ).append("\n"); 
		query.append("    MAX(T2.VGM_VRFY_SIG_CTNT)VGM_VRFY_SIG_CTNT ," ).append("\n"); 
		query.append("    MAX(T2.VGM_MZD_TP_CD) VGM_MZD_TP_CD" ).append("\n"); 
		query.append("FROM	BKG_DG_CGO T1,                       " ).append("\n"); 
		query.append("	(SELECT	BKG_CONTAINER.BKG_NO a101, BKG_CONTAINER.CNTR_NO a103," ).append("\n"); 
		query.append("		SUBSTR(BKG_CONTAINER.CNTR_NO,1,11) a01," ).append("\n"); 
		query.append("		SUBSTR(MAX(BKG_CONTAINER.CNTR_TPSZ_CD),1,4) a02," ).append("\n"); 
		query.append("		SUBSTR(MIN(BKG_CNTR_SEAL_NO.CNTR_SEAL_NO),1,10) a03," ).append("\n"); 
		query.append("		'K' a04," ).append("\n"); 
		query.append("		TO_CHAR(DECODE(SIGN(ROUND(MAX(DECODE(BKG_CONTAINER.WGT_UT_CD,'LBS',BKG_CONTAINER.CNTR_WGT * 0.45359,BKG_CONTAINER.CNTR_WGT)),0) - 90000),1, 90000, ROUND(MAX(DECODE(BKG_CONTAINER.WGT_UT_CD,'LBS',BKG_CONTAINER.CNTR_WGT * 0.45359,BKG_CONTAINER.CNTR_WGT)),0))) a05," ).append("\n"); 
		query.append("		SUBSTR(MAX(BKG_CONTAINER.DCGO_FLG),1,1) a06," ).append("\n"); 
		query.append("		SUBSTR(MAX(BKG_CONTAINER.RC_FLG),1,1) a07," ).append("\n"); 
		query.append("		SUBSTR(MAX(BKG_CONTAINER.AWK_CGO_FLG),1,1) a08," ).append("\n"); 
		query.append("		SUBSTR(MAX(BKG_CONTAINER.BB_CGO_FLG),1,1) a09," ).append("\n"); 
		query.append("		MAX(BKG_BOOKING.POD_CD) a10," ).append("\n"); 
		query.append("		SUBSTR(MAX(BKG_CONTAINER.BKG_NO),1,11) a11," ).append("\n"); 
		query.append("		MAX(A.VSL_CD) a12," ).append("\n"); 
		query.append("		MAX(A.SKD_VOY_NO) a13," ).append("\n"); 
		query.append("		MAX(A.SKD_DIR_CD) a14," ).append("\n"); 
		query.append("		SUBSTR(MAX(NVL(BKG_CONTAINER.RCV_TERM_CD,' ')||NVL(BKG_CONTAINER.DE_TERM_CD,' ')),1,2) a15," ).append("\n"); 
		query.append("		MAX(BKG_BOOKING.POL_CD) a16," ).append("\n"); 
		query.append("		SUBSTR(MAX(BKG_BOOKING.BL_NO),1,12) a17," ).append("\n"); 
		query.append("		MAX(BKG_BOOKING.BKG_CGO_TP_CD) a18," ).append("\n"); 
		query.append("		0 a19," ).append("\n"); 
		query.append("		SUBSTR(MAX(BKG_BOOKING.BKG_NO),1,13) a20," ).append("\n"); 
		query.append("		MAX(BKG_VVD.POL_CD) a21," ).append("\n"); 
		query.append("		MAX(BKG_VVD.POD_CD) a22," ).append("\n"); 
		query.append("		MAX(BKG_VVD.VSL_CD) a23," ).append("\n"); 
		query.append("		MAX(BKG_VVD.SKD_VOY_NO) a24," ).append("\n"); 
		query.append("		MAX(BKG_VVD.SKD_DIR_CD) a25," ).append("\n"); 
		query.append("		MAX(BKG_BOOKING.PRE_RLY_PORT_CD) a26," ).append("\n"); 
		query.append("		MAX( DECODE(NVL(BKG_VVD.POD_CD,' '), 'USSEA', DECODE(BKG_VVD.SLAN_CD,'PSX',DECODE(DECODE(SUBSTR(NVL(BKG_BOOKING.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'ONE','SE1','SEA'),DECODE(SUBSTR(NVL(BKG_BOOKING.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC')), " ).append("\n"); 
		query.append("							'USOAK', DECODE(BKG_BOOKING.BLCK_STWG_CD, 'OA1', 'OA1' ,'', '', 'OAK'), " ).append("\n"); 
		query.append("							'USLGB', DECODE(SUBSTR(NVL(BKG_BOOKING.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','7','SEV','T','TRS', 'LOC'), " ).append("\n"); 
		query.append("							'CAVAN', DECODE(SUBSTR(NVL(BKG_BOOKING.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'')) a28," ).append("\n"); 
		query.append("		SUBSTR(MAX(BKG_BOOKING.BKG_NO),1,11) a29," ).append("\n"); 
		query.append("		(SELECT MAX(YD_CD) FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("		      WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("		      AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("		      AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("			  AND VPS_PORT_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("		      AND YD_CD IN (SELECT YD_CD FROM VSK_VSL_PORT_SKD WHERE VSL_CD = @[in_vsl_cd] AND SKD_VOY_NO = @[in_skd_voy_no] AND SKD_DIR_CD = @[in_skd_dir_cd]) " ).append("\n"); 
		query.append("        ) a31," ).append("\n"); 
		query.append("		MAX(BKG_DG_CGO.IMDG_UN_NO) a32," ).append("\n"); 
		query.append("		MAX(BKG_DG_CGO.IMDG_CLSS_CD) a33," ).append("\n"); 
		query.append("		MAX(BKG_BOOKING.DEL_CD) a34," ).append("\n"); 
		query.append("		MAX(BKG_BOOKING.POR_CD) a35," ).append("\n"); 
		query.append("		SUBSTR(MAX(BKG_BOOKING.HOT_DE_FLG),1,3) a36," ).append("\n"); 
		query.append("		MAX(DECODE(BKG_BOOKING.BKG_CGO_TP_CD,'F','111','912')) a38," ).append("\n"); 
		query.append("		MAX(DECODE(BKG_RF_CGO.CNTR_VENT_TP_CD,'P',BKG_RF_CGO.VENT_RTO, 'C', BKG_RF_CGO.CBM_PER_HR_QTY,'')) a39," ).append("\n"); 
		query.append("		SUBSTR(MAX(BKG_AWK_CGO.OVR_FWRD_LEN),1,5) a41," ).append("\n"); 
		query.append("		SUBSTR(MAX(BKG_AWK_CGO.OVR_BKWD_LEN),1,5) a42," ).append("\n"); 
		query.append("		SUBSTR(MAX(BKG_AWK_CGO.OVR_HGT    ),1,5) a43," ).append("\n"); 
		query.append("		SUBSTR(MAX(BKG_AWK_CGO.OVR_LF_LEN    ),1,5) a44," ).append("\n"); 
		query.append("		SUBSTR(MAX(BKG_AWK_CGO.OVR_RT_LEN    ),1,5) a45," ).append("\n"); 
		query.append("		TO_CHAR(DECODE(SIGN(ROUND((MAX(DECODE(BKG_BL_DOC.WGT_UT_CD,'LBS',BKG_BL_DOC.ACT_WGT * 0.45359,BKG_BL_DOC.ACT_WGT)) / SUM(CEIL(BKG_QUANTITY.OP_CNTR_QTY))),0) - 90000), 1, 90000, ROUND((MAX(DECODE(BKG_BL_DOC.WGT_UT_CD,'LBS',BKG_BL_DOC.ACT_WGT * 0.45359,BKG_BL_DOC.ACT_WGT)) / SUM(CEIL(BKG_QUANTITY.OP_CNTR_QTY))),0))) a46," ).append("\n"); 
		query.append("		TO_CHAR(MAX(DECODE(NVL(S.TARE_WGT, 0), 0, DECODE(NVL(Z.CNTR_TPSZ_TARE_WGT, 0), 0, DECODE(N.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0), Z.CNTR_TPSZ_TARE_WGT), S.TARE_WGT))) a47," ).append("\n"); 
		query.append("		DECODE(trim(@[in_pol_cd]), 'KRINC', 'KRJCN', 'KRPYT', 'KRPTK', @[in_pol_cd]) a49	," ).append("\n"); 
		query.append("		CM.REP_IMDG_LVL_CD     a50," ).append("\n"); 
		query.append("		SUBSTR(BKG_VVD.POD_YD_CD,6,2) a51," ).append("\n"); 
		query.append("		SUBSTR(BKG_VVD.POL_YD_CD,6,2) a52," ).append("\n"); 
		query.append("		MAX(BKG_DG_CGO.MRN_POLUT_FLG) a53," ).append("\n"); 
		query.append("		MAX(NVL(BKG_BOOKING.STWG_CD, DECODE(BKG_BOOKING.PRCT_FLG,'Y','PC',''))) a54," ).append("\n"); 
		query.append("		MAX(BKG_BOOKING.XTER_RMK) a55," ).append("\n"); 
		query.append("		MAX(DECODE(SUBSTR(BKG_RF_CGO.CDO_TEMP,1,5) ,NULL,BKG_DG_CGO.IMDG_UN_NO,SUBSTR(BKG_RF_CGO.CDO_TEMP,1,5)||'C')) a56," ).append("\n"); 
		query.append("		MAX(DECODE(DECODE(BKG_RF_CGO.CNTR_VENT_TP_CD,'P',BKG_RF_CGO.VENT_RTO||'%', 'C', BKG_RF_CGO.CBM_PER_HR_QTY||' CMH',null),null,BKG_DG_CGO.IMDG_CLSS_CD,DECODE(BKG_RF_CGO.CNTR_VENT_TP_CD,'P',BKG_RF_CGO.VENT_RTO||'%', 'C', BKG_RF_CGO.CBM_PER_HR_QTY||' CMH',''))) a57," ).append("\n"); 
		query.append("		MAX((DECODE(SUBSTR(BKG_RF_CGO.CDO_TEMP,1,5) ,NULL,BKG_DG_CGO.IMDG_UN_NO,TRIM(SUBSTR(TO_CHAR(BKG_RF_CGO.CDO_TEMP,'90.90'),1,5)||'C')))||'|'||(DECODE(DECODE(BKG_RF_CGO.CNTR_VENT_TP_CD,'P',BKG_RF_CGO.VENT_RTO||'%', 'C', BKG_RF_CGO.CBM_PER_HR_QTY||' CMH',null),null,BKG_DG_CGO.IMDG_CLSS_CD,DECODE(BKG_RF_CGO.CNTR_VENT_TP_CD,'P',BKG_RF_CGO.VENT_RTO||'%', 'C', BKG_RF_CGO.CBM_PER_HR_QTY||' CMH','')))) a99," ).append("\n"); 
		query.append("		MAX(BKG_DG_CGO.IMDG_SUBS_RSK_LBL_CD1) a58," ).append("\n"); 
		query.append("		MAX(BKG_RF_CGO.CDO_TEMP) a59," ).append("\n"); 
		query.append("		MAX(BKG_BOOKING.BLCK_STWG_CD) BC_CD," ).append("\n"); 
		query.append("		MAX(BKG_VVD.SLAN_CD) VVD_SLAN_CD," ).append("\n"); 
		query.append("		MAX(DECODE(NVL(BKG_CONTAINER.VGM_WGT_UT_CD, 0), 'LBS', ROUND (NVL(BKG_CONTAINER.VGM_WGT, 0)*0.4536, 3), NVL(BKG_CONTAINER.VGM_WGT, 0))) VGM_WGT," ).append("\n"); 
		query.append("		'KGS' VGM_WGT_UT_CD," ).append("\n"); 
		query.append("		MAX(BKG_CONTAINER.VGM_VRFY_SIG_CTNT) VGM_VRFY_SIG_CTNT," ).append("\n"); 
		query.append("		MAX(BKG_CONTAINER.VGM_MZD_TP_CD) VGM_MZD_TP_CD" ).append("\n"); 
		query.append("	FROM	BKG_BOOKING," ).append("\n"); 
		query.append("		BKG_BL_DOC," ).append("\n"); 
		query.append("		BKG_CONTAINER," ).append("\n"); 
		query.append("		BKG_CNTR_SEAL_NO," ).append("\n"); 
		query.append("		BKG_QUANTITY," ).append("\n"); 
		query.append("		BKG_VVD," ).append("\n"); 
		query.append("		BKG_VVD A," ).append("\n"); 
		query.append("		BKG_RF_CGO," ).append("\n"); 
		query.append("		BKG_DG_CGO," ).append("\n"); 
		query.append("		BKG_AWK_CGO," ).append("\n"); 
		query.append("		MST_CONTAINER N," ).append("\n"); 
		query.append("		MST_CNTR_SPEC S," ).append("\n"); 
		query.append("		MDM_CNTR_TP_SZ Z," ).append("\n"); 
		query.append("		MDM_COMMODITY  CM" ).append("\n"); 
		query.append("	WHERE	( BKG_BOOKING.BKG_STS_CD <> 'X' AND BKG_BOOKING.BKG_STS_CD <> 'S' ) AND" ).append("\n"); 
		query.append("#if (${in_bkg_sts_cd}!= '') 			" ).append("\n"); 
		query.append("BKG_BOOKING.BKG_STS_CD = @[in_bkg_sts_cd] AND" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		BKG_BOOKING.BKG_CGO_TP_CD IN ('F','R') AND" ).append("\n"); 
		query.append("		( BKG_CONTAINER.BKG_NO = BKG_DG_CGO.BKG_NO(+) AND" ).append("\n"); 
		query.append("		BKG_CONTAINER.CNTR_NO = BKG_DG_CGO.CNTR_NO(+) ) AND" ).append("\n"); 
		query.append("		( BKG_CONTAINER.BKG_NO = BKG_RF_CGO.BKG_NO(+) AND" ).append("\n"); 
		query.append("		BKG_CONTAINER.CNTR_NO = BKG_RF_CGO.CNTR_NO(+) ) AND" ).append("\n"); 
		query.append("		( BKG_CONTAINER.BKG_NO = BKG_AWK_CGO.BKG_NO(+) AND" ).append("\n"); 
		query.append("		BKG_CONTAINER.CNTR_NO = BKG_AWK_CGO.CNTR_NO(+) ) AND" ).append("\n"); 
		query.append("		(BKG_CONTAINER.BKG_NO = BKG_CNTR_SEAL_NO.BKG_NO(+) AND" ).append("\n"); 
		query.append("		BKG_CONTAINER.CNTR_NO = BKG_CNTR_SEAL_NO.CNTR_NO(+) AND" ).append("\n"); 
		query.append("        BKG_CNTR_SEAL_NO.CNTR_SEAL_SEQ(+)=1) AND" ).append("\n"); 
		query.append("		 ( BKG_BOOKING.BKG_NO = BKG_VVD.BKG_NO ) AND" ).append("\n"); 
		query.append("		 ( BKG_BOOKING.BKG_NO = BKG_BL_DOC.BKG_NO ) AND" ).append("\n"); 
		query.append("		 ( BKG_BOOKING.BKG_NO = BKG_QUANTITY.BKG_NO(+) AND" ).append("\n"); 
		query.append("		BKG_QUANTITY.CNTR_TPSZ_CD != 'Q4' AND BKG_QUANTITY.CNTR_TPSZ_CD != 'Q2') AND" ).append("\n"); 
		query.append("		( BKG_BOOKING.BKG_NO = A.BKG_NO(+) ) AND" ).append("\n"); 
		query.append("		( BKG_BOOKING.BKG_NO = BKG_CONTAINER.BKG_NO" ).append("\n"); 
		query.append("#if (${in_cntr_cfm_flg}!= '') 			" ).append("\n"); 
		query.append("AND (BKG_CONTAINER.CNTR_CFM_FLG = @[in_cntr_cfm_flg]) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") AND" ).append("\n"); 
		query.append("		BKG_VVD.VSL_CD = @[in_vsl_cd] AND" ).append("\n"); 
		query.append("		BKG_VVD.SKD_VOY_NO = @[in_skd_voy_no]  AND" ).append("\n"); 
		query.append("		BKG_VVD.SKD_DIR_CD = @[in_skd_dir_cd]  AND" ).append("\n"); 
		query.append("		BKG_VVD.POL_CD = @[in_pol_cd] AND" ).append("\n"); 
		query.append("#if (${in_pol_yd_cd}!= '') 	" ).append("\n"); 
		query.append("		SUBSTR(BKG_VVD.POL_YD_CD,6,2) = @[in_pol_yd_cd] AND" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_pol_cnt_cd} == 'KR' ) " ).append("\n"); 
		query.append("		( A.POD_CD(+) = @[in_pol_cd]) AND" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		( A.POD_CD = @[in_pol_cd]) AND" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		( BKG_CONTAINER.CNTR_NO = N.CNTR_NO(+)) AND" ).append("\n"); 
		query.append("		( BKG_CONTAINER.CNTR_TPSZ_CD = Z.CNTR_TPSZ_CD(+)) AND" ).append("\n"); 
		query.append("		N.CNTR_SPEC_NO      =   S.CNTR_SPEC_NO(+) AND " ).append("\n"); 
		query.append("		N.CNTR_NO           =   BKG_CONTAINER.CNTR_NO AND " ).append("\n"); 
		query.append("		N.CNTR_TPSZ_CD          =   Z.CNTR_TPSZ_CD AND" ).append("\n"); 
		query.append("		BKG_BOOKING.CMDT_CD       =   CM.CMDT_CD    (+)" ).append("\n"); 
		query.append("	GROUP BY	" ).append("\n"); 
		query.append("			BKG_CONTAINER.BKG_NO, " ).append("\n"); 
		query.append("			BKG_CONTAINER.CNTR_NO, " ).append("\n"); 
		query.append("			--BKG_CONTAINER.CNTR_NO," ).append("\n"); 
		query.append("			CM.REP_IMDG_LVL_CD," ).append("\n"); 
		query.append("			SUBSTR(BKG_VVD.POD_YD_CD,6,2)," ).append("\n"); 
		query.append("			BKG_VVD.POL_YD_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD) T2," ).append("\n"); 
		query.append("		BKG_CNTR_MF_DESC CM" ).append("\n"); 
		query.append("WHERE	T2.a101 = T1.BKG_NO(+)" ).append("\n"); 
		query.append("AND	T2.a103 = T1.CNTR_NO(+)" ).append("\n"); 
		query.append("AND	T2.a32 = T1.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND T2.a101 = CM.BKG_NO (+)" ).append("\n"); 
		query.append("AND T2.a103 = CM.CNTR_NO (+)" ).append("\n"); 
		query.append("AND DECODE(@[in_pol_cd],T2.a16,'','TS') = 'TS'" ).append("\n"); 
		query.append("GROUP BY T2.a01" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${in_sort_type} == '' ) " ).append("\n"); 
		query.append("order by AA, BKG_POL_CD,POD_CD,BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_type} == '1' ) " ).append("\n"); 
		query.append("order by AA, BKG_POL_CD,POD_CD,BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_type} == '2' ) " ).append("\n"); 
		query.append("order by AA, BKG_POL_CD,POD_CD, A_POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_type} == '3' ) " ).append("\n"); 
		query.append("order by AA, TS_VSL_CD||TS_SKD_VOY_NO||TS_SKD_DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_type} == '4' ) " ).append("\n"); 
		query.append("order by AA, DECODE(BLCK_STWG_CD,'LOC','11','ONE','12','TWO','13','THR','14','FOR','15','FIV','15.5','SEV', '15.7','HOT','16','TRS','17', '18')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_type} == '5' ) " ).append("\n"); 
		query.append("order by AA, POD_CD, DECODE(BLCK_STWG_CD,'LOC','11','ONE','12','TWO','13','THR','14','FOR','15','FIV','15.5','SEV', '15.7','HOT','16','TRS','17', '18'), CNTR_TPSZ_CD, CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_type} == '6' ) " ).append("\n"); 
		query.append("order by CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_sort_type} == '7' ) " ).append("\n"); 
		query.append("order by TO_NUMBER(BL_WGT,'99990')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}