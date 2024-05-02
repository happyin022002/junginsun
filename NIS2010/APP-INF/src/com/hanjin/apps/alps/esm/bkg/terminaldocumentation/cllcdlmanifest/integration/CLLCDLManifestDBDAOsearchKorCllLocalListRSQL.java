/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchKorCllLocalListRSQL.java
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

public class CLLCDLManifestDBDAOsearchKorCllLocalListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchKorCllLocalList
	  * 2017.04.13 iylee Stowage Code='OLBP' 이면 Block Stowage Code = 'LBP'
	  * 2017.05.25 iylee Stowage Code='OLBS' 이면 Block Stowage Code = 'LBS'
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchKorCllLocalListRSQL(){
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
		params.put("in_bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchKorCllLocalListRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM SEQ," ).append("\n"); 
		query.append("  VSL_CD," ).append("\n"); 
		query.append("  SKD_VOY_NO," ).append("\n"); 
		query.append("  SKD_DIR_CD," ).append("\n"); 
		query.append("  POL_CD," ).append("\n"); 
		query.append("  CNTR_NO," ).append("\n"); 
		query.append("  SUBSTR(BL_NO, 2) BL_NO," ).append("\n"); 
		query.append("  SUBSTR(BKG_NO, 2) BKG_NO," ).append("\n"); 
		query.append("  CNTR_TPSZ_CD," ).append("\n"); 
		query.append("  MTY_BKG_CD," ).append("\n"); 
		query.append("  SEAL_NO," ).append("\n"); 
		query.append("  BL_WGT," ).append("\n"); 
		query.append("  WGT_UT_CD," ).append("\n"); 
		query.append("  RCV_TERM_CD," ).append("\n"); 
		query.append("  TS_FLG," ).append("\n"); 
		query.append("  IMDG_CLSS_CD," ).append("\n"); 
		query.append("  IMDG_UN_NO," ).append("\n"); 
		query.append("  CDO_TEMP," ).append("\n"); 
		query.append("  CNTR_VENT_CD," ).append("\n"); 
		query.append("  HAMO_TRF_CD," ).append("\n"); 
		query.append("  CMDT_HS_CD," ).append("\n"); 
		query.append("  CLL_RMK1," ).append("\n"); 
		query.append("  CLL_RMK2," ).append("\n"); 
		query.append("  CLL_RMK3," ).append("\n"); 
		query.append("  NVL((SELECT UN_LOC_CD FROM MDM_LOCATION WHERE LOC_CD =  POD_CD  ), POD_CD ) POD_CD," ).append("\n"); 
		query.append("  BLCK_STWG_CD," ).append("\n"); 
		query.append("  TS_VSL_CD||TS_SKD_VOY_NO||TS_SKD_DIR_CD TS_VVD_CD," ).append("\n"); 
		query.append("  OVR_LEN_QTY," ).append("\n"); 
		query.append("  OVR_WGT_QTY," ).append("\n"); 
		query.append("  OVR_HGT_QTY," ).append("\n"); 
		query.append("  MIN_TEMP," ).append("\n"); 
		query.append("  MAX_TEMP," ).append("\n"); 
		query.append("  KR_TML_PRCT_ID," ).append("\n"); 
		query.append("  POD_YD_CD," ).append("\n"); 
		query.append("  POL_YD_CD," ).append("\n"); 
		query.append("  MRN_POLUT_FLG," ).append("\n"); 
		query.append("  STWG_CD," ).append("\n"); 
		query.append("  XTER_RMK," ).append("\n"); 
		query.append("  A_POD_CD," ).append("\n"); 
		query.append("  T_VSL_CD," ).append("\n"); 
		query.append("  BKG_POL_CD," ).append("\n"); 
		query.append("  '' VVD_CD_NM," ).append("\n"); 
		query.append("  '' POL_CD_PRINT," ).append("\n"); 
		query.append("  '' VPS_ETD," ).append("\n"); 
		query.append("  BC_CD," ).append("\n"); 
		query.append("  VGM_WGT," ).append("\n"); 
		query.append("  VGM_WGT_UT_CD ," ).append("\n"); 
		query.append("  VGM_VRFY_SIG_CTNT," ).append("\n"); 
		query.append("  VGM_MZD_TP_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT VSL_CD," ).append("\n"); 
		query.append("      SKD_VOY_NO," ).append("\n"); 
		query.append("      SKD_DIR_CD," ).append("\n"); 
		query.append("      POL_CD," ).append("\n"); 
		query.append("      CNTR_NO," ).append("\n"); 
		query.append("      BL_NO," ).append("\n"); 
		query.append("      BKG_NO," ).append("\n"); 
		query.append("      CNTR_TPSZ_CD," ).append("\n"); 
		query.append("      MTY_BKG_CD," ).append("\n"); 
		query.append("      SEAL_NO," ).append("\n"); 
		query.append("      BL_WGT," ).append("\n"); 
		query.append("      WGT_UT_CD," ).append("\n"); 
		query.append("      RCV_TERM_CD," ).append("\n"); 
		query.append("      TS_FLG," ).append("\n"); 
		query.append("      IMDG_CLSS_CD," ).append("\n"); 
		query.append("      IMDG_UN_NO," ).append("\n"); 
		query.append("      CDO_TEMP," ).append("\n"); 
		query.append("      CNTR_VENT_CD," ).append("\n"); 
		query.append("	  HAMO_TRF_CD," ).append("\n"); 
		query.append("	  CMDT_HS_CD," ).append("\n"); 
		query.append("      SUBSTR(CLL_RMK, 1, INSTR(CLL_RMK, '|')-1) CLL_RMK1," ).append("\n"); 
		query.append("      SUBSTR(CLL_RMK, INSTR(CLL_RMK, '|')+1) CLL_RMK2," ).append("\n"); 
		query.append("      CLL_RMK3," ).append("\n"); 
		query.append("      DECODE(POD_CD, 'USSEA', DECODE(VVD_SLAN_CD, 'PNH', DECODE(BC_CD, 'SE8', 'USSE8', DECODE(BLCK_STWG_CD, 'ONE', 'USSE1', 'USSEA')) , DECODE(BLCK_STWG_CD, 'ONE', 'USSE1', 'USSEA'))" ).append("\n"); 
		query.append("				, 'CAVAN', DECODE(BLCK_STWG_CD, 'LOC', 'CAYVR', 'ONE', 'CAVA1', 'CAVAN')" ).append("\n"); 
		query.append("				, 'CAPRR', DECODE(BC_CD, 'PR1', 'CAPR1', 'CAPRR'), POD_CD) POD_CD," ).append("\n"); 
		query.append("      DECODE(STWG_CD, 'OLBP', 'LBP', 'OLBS', 'LBS', 'OLBL', 'LBL' ,BLCK_STWG_CD) BLCK_STWG_CD," ).append("\n"); 
		query.append("      TS_VSL_CD," ).append("\n"); 
		query.append("      TS_SKD_VOY_NO," ).append("\n"); 
		query.append("      TS_SKD_DIR_CD," ).append("\n"); 
		query.append("      OVR_LEN_QTY," ).append("\n"); 
		query.append("      OVR_WGT_QTY," ).append("\n"); 
		query.append("      OVR_HGT_QTY," ).append("\n"); 
		query.append("      MIN_TEMP," ).append("\n"); 
		query.append("      MAX_TEMP," ).append("\n"); 
		query.append("      KR_TML_PRCT_ID," ).append("\n"); 
		query.append("      POD_YD_CD," ).append("\n"); 
		query.append("      POL_YD_CD," ).append("\n"); 
		query.append("      MRN_POLUT_FLG," ).append("\n"); 
		query.append("      STWG_CD," ).append("\n"); 
		query.append("      XTER_RMK," ).append("\n"); 
		query.append("      A_POD_CD," ).append("\n"); 
		query.append("      T_VSL_CD," ).append("\n"); 
		query.append("      BKG_POL_CD," ).append("\n"); 
		query.append("	  BC_CD," ).append("\n"); 
		query.append("	  VGM_WGT," ).append("\n"); 
		query.append("      VGM_WGT_UT_CD ," ).append("\n"); 
		query.append("	  VGM_VRFY_SIG_CTNT," ).append("\n"); 
		query.append("      VGM_MZD_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT MAX(T2.a01) CNTR_NO," ).append("\n"); 
		query.append("          MAX(T2.a02) CNTR_TPSZ_CD," ).append("\n"); 
		query.append("          MIN(T2.a03) SEAL_NO," ).append("\n"); 
		query.append("          MAX(T2.a04) WGT_UT_CD," ).append("\n"); 
		query.append("          MAX(TO_CHAR(DECODE(T2.a05, 0, DECODE(T2.a46, 0, T2.a47, T2.a46+T2.a47), T2.a05+T2.a47))) BL_WGT," ).append("\n"); 
		query.append("          MAX(T2.a12) TS_VSL_CD," ).append("\n"); 
		query.append("          MAX(T2.a13) TS_SKD_VOY_NO," ).append("\n"); 
		query.append("          MAX(T2.a14) TS_SKD_DIR_CD," ).append("\n"); 
		query.append("          MAX(T2.a15) RCV_TERM_CD," ).append("\n"); 
		query.append("          MAX(T2.a16) POL_CD," ).append("\n"); 
		query.append("          MAX(T2.a16) BKG_POL_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--MAX(T2.a17) BL_NO," ).append("\n"); 
		query.append("          MAX(DECODE(T2.a06, 'Y', 'Z'||T2.a17, 'A'||T2.a17)) BL_NO," ).append("\n"); 
		query.append("          MAX(T2.a18) MTY_BKG_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--MAX(T2.a20) BKG_NO," ).append("\n"); 
		query.append("          MAX(DECODE(T2.a06, 'Y', 'Z'||T2.a20, 'A'||T2.a20)) BKG_NO," ).append("\n"); 
		query.append("          MAX(T2.a22) POD_CD," ).append("\n"); 
		query.append("          MAX(T2.a10) A_POD_CD," ).append("\n"); 
		query.append("          MAX(T2.a23) VSL_CD," ).append("\n"); 
		query.append("          MAX(T2.a24) SKD_VOY_NO," ).append("\n"); 
		query.append("          MAX(T2.a25) SKD_DIR_CD," ).append("\n"); 
		query.append("          MAX(T2.a28) BLCK_STWG_CD," ).append("\n"); 
		query.append("          MAX('') TS_FLG," ).append("\n"); 
		query.append("          MAX(SUBSTR(T2.a32, 1, 5)) IMDG_UN_NO," ).append("\n"); 
		query.append("          MAX(T2.a33) CDO_TEMP," ).append("\n"); 
		query.append("          MAX(T1.IMDG_CLSS_CD) IMDG_CLSS_CD," ).append("\n"); 
		query.append("          MAX(T2.a39) CNTR_VENT_CD," ).append("\n"); 
		query.append("		  MAX(CM.HAMO_TRF_CD) HAMO_TRF_CD," ).append("\n"); 
		query.append("		  MAX(CM.CMDT_HS_CD) CMDT_HS_CD," ).append("\n"); 
		query.append("          MAX(T2.a41) OVR_LEN_QTY," ).append("\n"); 
		query.append("          MAX(T2.a43) OVR_HGT_QTY," ).append("\n"); 
		query.append("          MAX(T2.a44) OVR_WGT_QTY," ).append("\n"); 
		query.append("          MAX(T2.A50) KR_TML_PRCT_ID," ).append("\n"); 
		query.append("          MAX(T2.a51) POD_YD_CD," ).append("\n"); 
		query.append("          MAX(T2.a52) POL_YD_CD," ).append("\n"); 
		query.append("          MAX(T2.a53) MRN_POLUT_FLG," ).append("\n"); 
		query.append("          MAX(T2.a54) STWG_CD," ).append("\n"); 
		query.append("          MAX(T2.a55) XTER_RMK," ).append("\n"); 
		query.append("          MAX('') MIN_TEMP," ).append("\n"); 
		query.append("          MAX('') MAX_TEMP," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--MAX(T2.a56) CLL_RMK1," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--MAX(T2.a57) CLL_RMK2," ).append("\n"); 
		query.append("          MIN(T2.a99) CLL_RMK," ).append("\n"); 
		query.append("          MAX(T2.a58) CLL_RMK3," ).append("\n"); 
		query.append("          MAX('') T_VSL_CD," ).append("\n"); 
		query.append("		  MAX(T2.BC_CD) BC_CD," ).append("\n"); 
		query.append("	      MAX(T2.VVD_SLAN_CD) VVD_SLAN_CD," ).append("\n"); 
		query.append("		  MAX(T2.VGM_WGT) VGM_WGT," ).append("\n"); 
		query.append("		  MAX(T2.VGM_WGT_UT_CD) VGM_WGT_UT_CD ," ).append("\n"); 
		query.append("		  MAX(T2.VGM_VRFY_SIG_CTNT)VGM_VRFY_SIG_CTNT ," ).append("\n"); 
		query.append("  		  MAX(T2.VGM_MZD_TP_CD) VGM_MZD_TP_CD" ).append("\n"); 
		query.append("        FROM BKG_DG_CGO T1," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT BC.BKG_NO a101," ).append("\n"); 
		query.append("              BC.CNTR_NO a103," ).append("\n"); 
		query.append("              SUBSTR(BC.CNTR_NO, 1, 11) a01," ).append("\n"); 
		query.append("              SUBSTR(MAX(BC.CNTR_TPSZ_CD), 1, 4) a02," ).append("\n"); 
		query.append("              SUBSTR(MIN(BCSN.CNTR_SEAL_NO), 1, 10) a03," ).append("\n"); 
		query.append("              'K' a04," ).append("\n"); 
		query.append("              TO_CHAR(DECODE(SIGN(ROUND(MAX(DECODE(BC.WGT_UT_CD, 'LBS', BC.CNTR_WGT * 0.45359, BC.CNTR_WGT)), 0) - 90000), 1, 90000, ROUND(MAX(DECODE(BC.WGT_UT_CD, 'LBS', BC.CNTR_WGT * 0.45359, BC.CNTR_WGT)), 0))) a05," ).append("\n"); 
		query.append("              SUBSTR(MAX(BC.DCGO_FLG), 1, 1) a06," ).append("\n"); 
		query.append("              SUBSTR(MAX(BC.RC_FLG), 1, 1) a07," ).append("\n"); 
		query.append("              SUBSTR(MAX(BC.AWK_CGO_FLG), 1, 1) a08," ).append("\n"); 
		query.append("              SUBSTR(MAX(BC.BB_CGO_FLG), 1, 1) a09," ).append("\n"); 
		query.append("              MAX(BB.POD_CD) a10," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--SUBSTR(MAX(BC.BKG_NO),1,11) a11," ).append("\n"); 
		query.append("              SUBSTR(MAX(BV2.VSL_CD), 1, 4) a12," ).append("\n"); 
		query.append("              SUBSTR(MAX(BV2.SKD_VOY_NO), -4) a13," ).append("\n"); 
		query.append("              SUBSTR(MAX(BV2.SKD_DIR_CD), 1, 1) a14," ).append("\n"); 
		query.append("              SUBSTR(MAX(NVL(BC.RCV_TERM_CD, ' ')||NVL(BC.DE_TERM_CD, ' ')), 1, 2) a15," ).append("\n"); 
		query.append("              MAX(BB.POL_CD) a16," ).append("\n"); 
		query.append("              SUBSTR(MAX(BB.BL_NO), 1, 12) a17," ).append("\n"); 
		query.append("              MAX(BB.BKG_CGO_TP_CD) a18," ).append("\n"); 
		query.append("              0 a19," ).append("\n"); 
		query.append("              SUBSTR(MAX(BB.BKG_NO), 1, 13) a20," ).append("\n"); 
		query.append("              SUBSTR(DECODE(MAX(BDC.IMDG_UN_NO), null, null, '', null, SUBSTR(MAX(BB.BKG_NO), 1, 13)||MAX(BDC.IMDG_UN_NO)), 1, 13) B01," ).append("\n"); 
		query.append("              MAX(BV1.POL_CD) a21," ).append("\n"); 
		query.append("              MAX(BV1.POD_CD) a22," ).append("\n"); 
		query.append("              SUBSTR(MAX(BV1.VSL_CD), 1, 4) a23," ).append("\n"); 
		query.append("              SUBSTR(MAX(BV1.SKD_VOY_NO), -4) a24," ).append("\n"); 
		query.append("              SUBSTR(MAX(BV1.SKD_DIR_CD), 1, 1) a25," ).append("\n"); 
		query.append("              MAX(BB.PRE_RLY_PORT_CD) a26," ).append("\n"); 
		query.append("              MAX(DECODE(NVL(BV1.POD_CD, ' '), 'USSEA', DECODE(BV1.SLAN_CD, 'PSX', DECODE(DECODE(SUBSTR(NVL(BB.BLCK_STWG_CD, 'LOC'), 3, 1), '1', 'ONE', '2', 'TWO', '3', 'THR', '4', 'FOR', '5', 'FIV', 'T', 'TRS', 'LOC'), 'ONE', 'SE1', 'SEA'), DECODE(SUBSTR(NVL(BB.BLCK_STWG_CD, 'LOC'), 3, 1), '1', 'ONE', '2', 'TWO', '3', 'THR', '4', 'FOR', '5', 'FIV', 'T', 'TRS', 'LOC')), 'USOAK', DECODE(BB.BLCK_STWG_CD, 'OA1', 'OA1' ,'', '', 'OAK'), 'USLGB', DECODE(SUBSTR(NVL(BB.BLCK_STWG_CD, 'LOC'), 3, 1), '1', 'ONE', '2', 'TWO', '3', 'THR', '4', 'FOR', '5', 'FIV', '7', 'SEV', 'T', 'TRS', 'LOC'), 'CAVAN', DECODE(SUBSTR(NVL(BB.BLCK_STWG_CD, 'LOC'), 3, 1), '1', 'ONE', '2', 'TWO', '3', 'THR', '4', 'FOR', '5', 'FIV', 'T', 'TRS', 'LOC'), '')) a28," ).append("\n"); 
		query.append("              SUBSTR(MAX(BB.BKG_NO), 1, 11) a29," ).append("\n"); 
		query.append("              substr(decode(MAX(BDC.IMDG_UN_NO), null, null, '', null, SUBSTR(MAX(BB.BKG_NO), 1, 11)||MAX(BDC.IMDG_UN_NO)), 1, 11) B02," ).append("\n"); 
		query.append("              '  ' a31," ).append("\n"); 
		query.append("              MAX(BDC.IMDG_UN_NO) a32," ).append("\n"); 
		query.append("              MAX(BRC.CDO_TEMP) a33," ).append("\n"); 
		query.append("              MAX(BB.DEL_CD) a34," ).append("\n"); 
		query.append("              MAX(BB.POR_CD) a35," ).append("\n"); 
		query.append("              SUBSTR(MAX(BB.HOT_DE_FLG), 1, 3) a36," ).append("\n"); 
		query.append("              MAX(DECODE(BB.BKG_CGO_TP_CD, 'F', '111', '912')) a38," ).append("\n"); 
		query.append("              MAX(DECODE(BRC.CNTR_VENT_TP_CD, 'P', BRC.VENT_RTO, 'C', BRC.CBM_PER_HR_QTY, '')) a39," ).append("\n"); 
		query.append("              SUBSTR(MAX(BAC.OVR_FWRD_LEN), 1, 5) a41," ).append("\n"); 
		query.append("              SUBSTR(MAX(BAC.OVR_BKWD_LEN), 1, 5) a42," ).append("\n"); 
		query.append("              SUBSTR(MAX(BAC.OVR_HGT), 1, 5) a43," ).append("\n"); 
		query.append("              SUBSTR(MAX(BAC.OVR_LF_LEN), 1, 5) a44," ).append("\n"); 
		query.append("              SUBSTR(MAX(BAC.OVR_RT_LEN), 1, 5) a45," ).append("\n"); 
		query.append("              TO_CHAR(DECODE(SIGN(ROUND((MAX(DECODE(BBD.WGT_UT_CD, 'LBS', BBD.ACT_WGT * 0.45359, BBD.ACT_WGT)) / SUM(CEIL(BQ.OP_CNTR_QTY))), 0) - 90000), 1, 90000, ROUND((MAX(DECODE(BBD.WGT_UT_CD, 'LBS', BBD.ACT_WGT * 0.45359, BBD.ACT_WGT)) / SUM(CEIL(BQ.OP_CNTR_QTY))), 0))) a46," ).append("\n"); 
		query.append("              TO_CHAR(MAX(DECODE(NVL(MCS.TARE_WGT, 0), 0, DECODE(NVL(MCTS.CNTR_TPSZ_TARE_WGT, 0), 0, DECODE(MC.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0), MCTS.CNTR_TPSZ_TARE_WGT), MCS.TARE_WGT))) a47," ).append("\n"); 
		query.append("              DECODE(trim(@[in_pol_cd]), 'KRINC', 'KRJCN', 'KRPYT', 'KRPTK', @[in_pol_cd]) a49 ," ).append("\n"); 
		query.append("              MDMC.REP_IMDG_LVL_CD a50," ).append("\n"); 
		query.append("              SUBSTR(BV1.POD_YD_CD, 6, 2) a51," ).append("\n"); 
		query.append("              SUBSTR(BV1.POL_YD_CD, 6, 2) a52," ).append("\n"); 
		query.append("              MAX(BDC.MRN_POLUT_FLG) a53," ).append("\n"); 
		query.append("              MAX(NVL(BB.STWG_CD, DECODE(BB.PRCT_FLG,'Y','PC',''))) a54," ).append("\n"); 
		query.append("              MAX(BB.XTER_RMK) a55," ).append("\n"); 
		query.append("              MAX(DECODE(SUBSTR(BRC.CDO_TEMP, 1, 5) , NULL, BDC.IMDG_UN_NO, SUBSTR(BRC.CDO_TEMP, 1, 5)||'C')) a56," ).append("\n"); 
		query.append("              MAX(DECODE(DECODE(BRC.CNTR_VENT_TP_CD, 'P', BRC.VENT_RTO||'%', 'C', BRC.CBM_PER_HR_QTY||' CMH', null), null, BDC.IMDG_CLSS_CD, DECODE(BRC.CNTR_VENT_TP_CD, 'P', BRC.VENT_RTO||'%', 'C', BRC.CBM_PER_HR_QTY||' CMH', ''))) a57," ).append("\n"); 
		query.append("              MAX((DECODE(SUBSTR(BRC.CDO_TEMP, 1, 5) , NULL, BDC.IMDG_UN_NO, TRIM(SUBSTR(TO_CHAR(BRC.CDO_TEMP, '90.90'), 1, 5)||'C')))||'|'||(DECODE(DECODE(BRC.CNTR_VENT_TP_CD, 'P', BRC.VENT_RTO||'%', 'C', BRC.CBM_PER_HR_QTY||' CMH', null), null, BDC.IMDG_CLSS_CD, DECODE(BRC.CNTR_VENT_TP_CD, 'P', BRC.VENT_RTO||'%', 'C', BRC.CBM_PER_HR_QTY||' CMH', '')))) a99," ).append("\n"); 
		query.append("              MAX(BDC.IMDG_SUBS_RSK_LBL_CD1) a58," ).append("\n"); 
		query.append("			  MAX(BB.BLCK_STWG_CD) BC_CD," ).append("\n"); 
		query.append("			  MAX(BV1.SLAN_CD) VVD_SLAN_CD," ).append("\n"); 
		query.append("			  MAX(DECODE(NVL(BC.VGM_WGT_UT_CD, 0), 'LBS', ROUND (NVL(BC.VGM_WGT, 0)*0.4536, 3), NVL(BC.VGM_WGT, 0))) VGM_WGT," ).append("\n"); 
		query.append("			'KGS' VGM_WGT_UT_CD," ).append("\n"); 
		query.append("			MAX(BC.VGM_VRFY_SIG_CTNT) VGM_VRFY_SIG_CTNT," ).append("\n"); 
		query.append("			MAX(BC.VGM_MZD_TP_CD) VGM_MZD_TP_CD" ).append("\n"); 
		query.append("            FROM    BKG_BOOKING BB,    BKG_BL_DOC BBD, BKG_CONTAINER BC,  BKG_CNTR_SEAL_NO BCSN, BKG_QUANTITY BQ, BKG_VVD BV1, BKG_VVD BV2, " ).append("\n"); 
		query.append("                    BKG_RF_CGO BRC,    BKG_DG_CGO BDC, BKG_AWK_CGO BAC,    MST_CONTAINER MC, MST_CNTR_SPEC MCS, MDM_CNTR_TP_SZ MCTS,  MDM_COMMODITY MDMC" ).append("\n"); 
		query.append("            WHERE (BB.BKG_STS_CD <> 'X'  AND BB.BKG_STS_CD <> 'S')" ).append("\n"); 
		query.append("              AND #if (${in_bkg_sts_cd}!= '') BB.BKG_STS_CD = @[in_bkg_sts_cd]" ).append("\n"); 
		query.append("              AND #end BB.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("              AND (BC.BKG_NO = BDC.BKG_NO(+) AND BC.CNTR_NO = BDC.CNTR_NO(+))" ).append("\n"); 
		query.append("              AND (BC.BKG_NO = BRC.BKG_NO(+) AND BC.CNTR_NO = BRC.CNTR_NO(+))" ).append("\n"); 
		query.append("              AND (BC.BKG_NO = BAC.BKG_NO(+) AND BC.CNTR_NO = BAC.CNTR_NO(+))" ).append("\n"); 
		query.append("              AND (BC.BKG_NO = BCSN.BKG_NO(+) AND BC.CNTR_NO = BCSN.CNTR_NO(+) AND BCSN.CNTR_SEAL_SEQ(+)=1)" ).append("\n"); 
		query.append("              AND (BB.BKG_NO = BV1.BKG_NO)" ).append("\n"); 
		query.append("              AND (BB.BKG_NO = BBD.BKG_NO)" ).append("\n"); 
		query.append("              AND (BB.BKG_NO = BQ.BKG_NO(+) AND BQ.CNTR_TPSZ_CD != 'Q4' AND BQ.CNTR_TPSZ_CD != 'Q2')" ).append("\n"); 
		query.append("              AND (BB.BKG_NO = BV2.BKG_NO(+))" ).append("\n"); 
		query.append("              AND (BB.BKG_NO = BC.BKG_NO #if (${in_cntr_cfm_flg}!= '') AND (BC.CNTR_CFM_FLG = @[in_cntr_cfm_flg]) #end)" ).append("\n"); 
		query.append("              AND BV1.VSL_CD = @[in_vsl_cd]" ).append("\n"); 
		query.append("              AND BV1.SKD_VOY_NO = @[in_skd_voy_no]" ).append("\n"); 
		query.append("              AND BV1.SKD_DIR_CD = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("              AND BV1.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("              AND #if (${in_pol_yd_cd}!= '') SUBSTR(BV1.POL_YD_CD, 6, 2) = @[in_pol_yd_cd]" ).append("\n"); 
		query.append("              AND #end #if (${in_pol_cnt_cd} == 'KR') (BV2.POD_CD(+) =@[in_pol_cd])" ).append("\n"); 
		query.append("              AND #else (BV2.POD_CD = @[in_pol_cd])" ).append("\n"); 
		query.append("              AND #end (BC.CNTR_NO = MC.CNTR_NO(+))" ).append("\n"); 
		query.append("              AND (BC.CNTR_TPSZ_CD = MCTS.CNTR_TPSZ_CD(+))" ).append("\n"); 
		query.append("              AND MC.CNTR_SPEC_NO = MCS.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("              AND MC.CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("              AND MC.CNTR_TPSZ_CD = MCTS.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              AND BB.CMDT_CD = MDMC.CMDT_CD (+)" ).append("\n"); 
		query.append("            GROUP BY BC.BKG_NO, BC.CNTR_NO," ).append("\n"); 
		query.append("--BC.CNTR_NO," ).append("\n"); 
		query.append("              MDMC.REP_IMDG_LVL_CD, SUBSTR(BV1.POD_YD_CD, 6, 2), BV1.POL_YD_CD) T2," ).append("\n"); 
		query.append("			  BKG_CNTR_MF_DESC CM" ).append("\n"); 
		query.append("        WHERE T2.a101 = T1.BKG_NO(+)" ).append("\n"); 
		query.append("          AND T2.a103 = T1.CNTR_NO(+)" ).append("\n"); 
		query.append("          AND T2.a32 = T1.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("		  AND T2.a101 = CM.BKG_NO (+)" ).append("\n"); 
		query.append("		  AND T2.a103 = CM.CNTR_NO (+)" ).append("\n"); 
		query.append("          AND DECODE(@[in_pol_cd], T2.a16, 'TT', 'TS') = 'TT'" ).append("\n"); 
		query.append("        GROUP BY T2.a01) #if (${in_sort_type} == '')" ).append("\n"); 
		query.append("    ORDER BY BKG_POL_CD, POD_CD, BKG_NO #end #if (${in_sort_type} == '1')" ).append("\n"); 
		query.append("    ORDER BY BKG_POL_CD, POD_CD, BKG_NO #end #if (${in_sort_type} == '2')" ).append("\n"); 
		query.append("    ORDER BY BKG_POL_CD, POD_CD, A_POD_CD #end #if (${in_sort_type} == '3')" ).append("\n"); 
		query.append("    ORDER BY TS_VSL_CD||TS_SKD_VOY_NO||TS_SKD_DIR_CD #end #if (${in_sort_type} == '4')" ).append("\n"); 
		query.append("    ORDER BY DECODE(BLCK_STWG_CD, 'LOC', '11', 'ONE', '12', 'TWO', '13', 'THR', '14', 'FOR', '15', 'FIV', '15.5','SEV', '15.7', 'HOT', '16', 'TRS', '17', '18') #end #if (${in_sort_type} == '5')" ).append("\n"); 
		query.append("    ORDER BY POD_CD, DECODE(BLCK_STWG_CD, 'LOC', '11', 'ONE', '12', 'TWO', '13', 'THR', '14', 'FOR', '15', 'FIV', '15.5','SEV', '15.7', 'HOT', '16', 'TRS', '17', '18'), CNTR_TPSZ_CD, CNTR_NO #end #if (${in_sort_type} == '6')" ).append("\n"); 
		query.append("    ORDER BY CNTR_NO #end #if (${in_sort_type} == '7')" ).append("\n"); 
		query.append("    ORDER BY TO_NUMBER(BL_WGT, '99990') #end)" ).append("\n"); 

	}
}