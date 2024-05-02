/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchSpclCgoDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.21 
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

public class CLLCDLManifestDBDAOsearchSpclCgoDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSpclCgoDtl
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchSpclCgoDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchSpclCgoDtlRSQL").append("\n"); 
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
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ROWNUM SEQ," ).append("\n"); 
		query.append("  CGO_TYPE," ).append("\n"); 
		query.append("  BKG_NO," ).append("\n"); 
		query.append("  BKG_NO2," ).append("\n"); 
		query.append("  TS," ).append("\n"); 
		query.append("  A_POL," ).append("\n"); 
		query.append("  A_POD," ).append("\n"); 
		query.append("  POL," ).append("\n"); 
		query.append("  POD," ).append("\n"); 
		query.append("  CS," ).append("\n"); 
		query.append("  CS2," ).append("\n"); 
		query.append("  CNTR_NO," ).append("\n"); 
		query.append("  TP," ).append("\n"); 
		query.append("  ROUND(WGT, 1) WGT," ).append("\n"); 
		query.append("  WGT_UNIT," ).append("\n"); 
		query.append("  CLASS_CD," ).append("\n"); 
		query.append("  UNNO," ).append("\n"); 
		query.append("  TEMP," ).append("\n"); 
		query.append("  VENT," ).append("\n"); 
		query.append("  REMARK," ).append("\n"); 
		query.append("  MP," ).append("\n"); 
		query.append("  SG," ).append("\n"); 
		query.append("  LQ," ).append("\n"); 
		query.append("  VO_ID," ).append("\n"); 
		query.append("  STOW," ).append("\n"); 
		query.append("  MTY_BKG_CD," ).append("\n"); 
		query.append("  CLPT_SEQ," ).append("\n"); 
		query.append("  BLCK_STWG_CD," ).append("\n"); 
		query.append("  BKG_BS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT CGO_TYPE," ).append("\n"); 
		query.append("      BKG_NO," ).append("\n"); 
		query.append("      BKG_NO BKG_NO2," ).append("\n"); 
		query.append("      TS," ).append("\n"); 
		query.append("      A_POL," ).append("\n"); 
		query.append("      A_POD," ).append("\n"); 
		query.append("      POL," ).append("\n"); 
		query.append("      POD," ).append("\n"); 
		query.append("      DECODE(CS, 0, '', CS) CS," ).append("\n"); 
		query.append("      DECODE(CS2, 0, '', CS2) CS2," ).append("\n"); 
		query.append("      CNTR_NO," ).append("\n"); 
		query.append("      TP," ).append("\n"); 
		query.append("      WGT," ).append("\n"); 
		query.append("      WGT_UNIT," ).append("\n"); 
		query.append("      CLASS_CD," ).append("\n"); 
		query.append("      UNNO," ).append("\n"); 
		query.append("      TEMP," ).append("\n"); 
		query.append("      VENT," ).append("\n"); 
		query.append("      REMARK," ).append("\n"); 
		query.append("      MP," ).append("\n"); 
		query.append("      SG," ).append("\n"); 
		query.append("      LQ," ).append("\n"); 
		query.append("      VO_ID," ).append("\n"); 
		query.append("      STOW," ).append("\n"); 
		query.append("      MTY_BKG_CD," ).append("\n"); 
		query.append("      CLPT_SEQ," ).append("\n"); 
		query.append("      BLCK_STWG_CD," ).append("\n"); 
		query.append("      BKG_BS" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT 'AK' CGO_TYPE," ).append("\n"); 
		query.append("          AWK.BKG_NO BKG_NO," ).append("\n"); 
		query.append("          CLL.KR_CLL_TS_CD TS," ).append("\n"); 
		query.append("          NVL((" ).append("\n"); 
		query.append("                SELECT UN_LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = BKG.POL_CD), BKG.POL_CD) A_POL," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--BKG.POL_CD A_POL," ).append("\n"); 
		query.append("          NVL((" ).append("\n"); 
		query.append("                SELECT UN_LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = BKG.POD_CD), BKG.POD_CD) A_POD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--BKG.POD_CD A_POD," ).append("\n"); 
		query.append("          NVL((" ).append("\n"); 
		query.append("                SELECT UN_LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = CLL.POL_CD), CLL.POL_CD) POL," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--CLL.POL_CD POL," ).append("\n"); 
		query.append("          NVL((" ).append("\n"); 
		query.append("                SELECT UN_LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = CLL.POD_CD), CLL.POD_CD) POD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--CLL.POD_CD POD," ).append("\n"); 
		query.append("          0 CS," ).append("\n"); 
		query.append("          0 CS2," ).append("\n"); 
		query.append("          AWK.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("          CLL.CNTR_TPSZ_CD TP," ).append("\n"); 
		query.append("          CLL.BL_WGT WGT," ).append("\n"); 
		query.append("          CLL.WGT_UT_CD WGT_UNIT," ).append("\n"); 
		query.append("          ' ' CLASS_CD," ).append("\n"); 
		query.append("          ' ' UNNO," ).append("\n"); 
		query.append("          ' ' TEMP," ).append("\n"); 
		query.append("          ' ' VENT," ).append("\n"); 
		query.append("          DECODE(NVL(AWK.OVR_FWRD_LEN, 0), 0, '', 'O.FWRD:'||AWK.OVR_FWRD_LEN||'  ')|| DECODE(NVL(AWK.OVR_BKWD_LEN, 0), 0, '', 'O.BKWD:'||AWK.OVR_BKWD_LEN||'  ')|| DECODE(NVL(AWK.OVR_HGT, 0), 0, '', 'O.HGT:'||AWK.OVR_HGT||'  ')|| DECODE(NVL(AWK.OVR_LF_LEN, 0), 0, '', 'O.LF:'||AWK.OVR_LF_LEN||'  ')|| DECODE(NVL(AWK.OVR_RT_LEN, 0), 0, '', 'O.RT:'||AWK.OVR_RT_LEN||'  ')|| DECODE(NVL(AWK.CRN_PST_STS_CD, '0'), '0', '', DECODE(CLL.CNTR_TPSZ_CD, 'A4', 'PS:'||AWK.CRN_PST_STS_CD||'  ', ''))|| DECODE(NVL(AWK.XTD_OVR_QTY, 0), 0, '', DECODE(CLL.CNTR_TPSZ_CD, 'A4', 'EH:'||AWK.XTD_OVR_QTY||'  ', '')) REMARK," ).append("\n"); 
		query.append("          ' ' MP," ).append("\n"); 
		query.append("          ' ' SG," ).append("\n"); 
		query.append("          ' ' LQ," ).append("\n"); 
		query.append("          TO_CHAR(AWK.OVR_VOID_SLT_QTY) VO_ID," ).append("\n"); 
		query.append("          CLL.STWG_CD STOW," ).append("\n"); 
		query.append("          CLL.MTY_BKG_CD MTY_BKG_CD," ).append("\n"); 
		query.append("          VPS.CLPT_SEQ CLPT_SEQ," ).append("\n"); 
		query.append("          CLL.BLCK_STWG_CD," ).append("\n"); 
		query.append("          BKG.BLCK_STWG_CD AS BKG_BS" ).append("\n"); 
		query.append("        FROM BKG_AWK_CGO AWK," ).append("\n"); 
		query.append("          BKG_BOOKING BKG," ).append("\n"); 
		query.append("          BKG_CSTMS_TML_KR_CLL CLL," ).append("\n"); 
		query.append("          VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("          MDM_LOCATION LO" ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO = AWK.BKG_NO" ).append("\n"); 
		query.append("          AND BKG.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("          AND AWK.CNTR_NO = CLL.CNTR_NO" ).append("\n"); 
		query.append("          AND CLL.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("          AND CLL.POL_YD_CD like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("          AND CLL.VSL_CD = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("          AND CLL.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("          AND CLL.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("          AND CLL.POD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND VPS.CLPT_IND_SEQ = '1' " ).append("\n"); 
		query.append("#if (${in_by_type} == 'TS' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IN ('TS','TT') " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${in_by_type} == 'LOCAL' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IS NULL " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND VPS.VSL_CD = CLL.VSL_CD" ).append("\n"); 
		query.append("          AND VPS.SKD_VOY_NO = CLL.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND VPS.SKD_DIR_CD = CLL.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n"); 
		query.append("          AND (CLL.POD_CD = LO.UN_LOC_CD" ).append("\n"); 
		query.append("              OR CLL.POD_CD = LO.LOC_CD)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'DG' CGO_TYPE," ).append("\n"); 
		query.append("          DG.BKG_NO BKG_NO," ).append("\n"); 
		query.append("          CLL.KR_CLL_TS_CD TS," ).append("\n"); 
		query.append("          NVL((" ).append("\n"); 
		query.append("                SELECT UN_LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = BKG.POL_CD), BKG.POL_CD) A_POL," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--BKG.POL_CD A_POL," ).append("\n"); 
		query.append("          NVL((" ).append("\n"); 
		query.append("                SELECT UN_LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = BKG.POD_CD), BKG.POD_CD) A_POD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--BKG.POD_CD A_POD," ).append("\n"); 
		query.append("          NVL((" ).append("\n"); 
		query.append("                SELECT UN_LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = CLL.POL_CD), CLL.POL_CD) POL," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--CLL.POL_CD POL," ).append("\n"); 
		query.append("          NVL((" ).append("\n"); 
		query.append("                SELECT UN_LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = CLL.POD_CD), CLL.POD_CD) POD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--CLL.POD_CD POD," ).append("\n"); 
		query.append("          DG.DG_CNTR_SEQ CS," ).append("\n"); 
		query.append("          DG.CNTR_CGO_SEQ CS2," ).append("\n"); 
		query.append("          DG.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("          CLL.CNTR_TPSZ_CD TP," ).append("\n"); 
		query.append("          CLL.BL_WGT WGT," ).append("\n"); 
		query.append("          CLL.WGT_UT_CD WGT_UNIT," ).append("\n"); 
		query.append("          DECODE(DG.IMDG_SUBS_RSK_LBL_CD1, NULL, DG.IMDG_CLSS_CD, DG.IMDG_CLSS_CD||'('||DG.IMDG_SUBS_RSK_LBL_CD1||')') CLASS_CD," ).append("\n"); 
		query.append("          DG.IMDG_UN_NO UNNO," ).append("\n"); 
		query.append("          ' ' TEMP," ).append("\n"); 
		query.append("          ' ' VENT," ).append("\n"); 
		query.append("          DG.DIFF_RMK REMARK," ).append("\n"); 
		query.append("          DG.MRN_POLUT_FLG    MP," ).append("\n"); 
		query.append("          DG.HZD_CTNT         SG," ).append("\n"); 
		query.append("          DG.IMDG_LMT_QTY_FLG LQ," ).append("\n"); 
		query.append("          ' ' VO_ID," ).append("\n"); 
		query.append("          CLL.STWG_CD STOW," ).append("\n"); 
		query.append("          CLL.MTY_BKG_CD MTY_BKG_CD," ).append("\n"); 
		query.append("          VPS.CLPT_SEQ CLPT_SEQ ," ).append("\n"); 
		query.append("          CLL.BLCK_STWG_CD," ).append("\n"); 
		query.append("          BKG.BLCK_STWG_CD AS BKG_BS" ).append("\n"); 
		query.append("        FROM BKG_DG_CGO DG," ).append("\n"); 
		query.append("          BKG_BOOKING BKG," ).append("\n"); 
		query.append("          BKG_CSTMS_TML_KR_CLL CLL," ).append("\n"); 
		query.append("          VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("          MDM_LOCATION LO" ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO = DG.BKG_NO" ).append("\n"); 
		query.append("          AND BKG.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("          AND DG.CNTR_NO = CLL.CNTR_NO" ).append("\n"); 
		query.append("          AND CLL.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("          AND CLL.POL_YD_CD like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("          AND CLL.VSL_CD = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("          AND CLL.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("          AND CLL.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("          AND CLL.POD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND VPS.CLPT_IND_SEQ = '1' " ).append("\n"); 
		query.append("#if (${in_by_type} == 'TS' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IN ('TS','TT') " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${in_by_type} == 'LOCAL' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IS NULL " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND VPS.VSL_CD = CLL.VSL_CD" ).append("\n"); 
		query.append("          AND VPS.SKD_VOY_NO = CLL.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND VPS.SKD_DIR_CD = CLL.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n"); 
		query.append("          AND (CLL.POD_CD = LO.UN_LOC_CD" ).append("\n"); 
		query.append("              OR CLL.POD_CD = LO.LOC_CD)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'RF' CGO_TYPE," ).append("\n"); 
		query.append("          RF.BKG_NO BKG_NO," ).append("\n"); 
		query.append("          CLL.KR_CLL_TS_CD TS," ).append("\n"); 
		query.append("          NVL((" ).append("\n"); 
		query.append("                SELECT UN_LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = BKG.POL_CD), BKG.POL_CD) A_POL," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--BKG.POL_CD A_POL," ).append("\n"); 
		query.append("          NVL((" ).append("\n"); 
		query.append("                SELECT UN_LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = BKG.POD_CD), BKG.POD_CD) A_POD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--BKG.POD_CD A_POD," ).append("\n"); 
		query.append("          NVL((" ).append("\n"); 
		query.append("                SELECT UN_LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = CLL.POL_CD), CLL.POL_CD) POL," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--CLL.POL_CD POL," ).append("\n"); 
		query.append("          NVL((" ).append("\n"); 
		query.append("                SELECT UN_LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = CLL.POD_CD), CLL.POD_CD) POD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--CLL.POD_CD POD," ).append("\n"); 
		query.append("          0 CS," ).append("\n"); 
		query.append("          0 CS2," ).append("\n"); 
		query.append("          RF.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("          CLL.CNTR_TPSZ_CD TP," ).append("\n"); 
		query.append("          CLL.BL_WGT WGT," ).append("\n"); 
		query.append("          CLL.WGT_UT_CD WGT_UNIT," ).append("\n"); 
		query.append("          ' ' CLASS_CD," ).append("\n"); 
		query.append("          ' ' UNNO," ).append("\n"); 
		query.append("          TO_CHAR(RF.CDO_TEMP, '90.0') TEMP," ).append("\n"); 
		query.append("          DECODE(RF.CNTR_VENT_TP_CD, 'P', RF.VENT_RTO||' %', 'C', RF.CBM_PER_HR_QTY||' CMH', '') VENT," ).append("\n"); 
		query.append("          RF.DIFF_RMK REMARK," ).append("\n"); 
		query.append("          ' ' MP," ).append("\n"); 
		query.append("          ' ' SG," ).append("\n"); 
		query.append("          ' ' LQ," ).append("\n"); 
		query.append("          ' ' VO_ID," ).append("\n"); 
		query.append("          CLL.STWG_CD STOW," ).append("\n"); 
		query.append("          CLL.MTY_BKG_CD MTY_BKG_CD ," ).append("\n"); 
		query.append("          VPS.CLPT_SEQ CLPT_SEQ," ).append("\n"); 
		query.append("          CLL.BLCK_STWG_CD," ).append("\n"); 
		query.append("          BKG.BLCK_STWG_CD AS BKG_BS" ).append("\n"); 
		query.append("        FROM BKG_RF_CGO RF," ).append("\n"); 
		query.append("          BKG_BOOKING BKG," ).append("\n"); 
		query.append("          BKG_CSTMS_TML_KR_CLL CLL," ).append("\n"); 
		query.append("          VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("          MDM_LOCATION LO" ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO = RF.BKG_NO" ).append("\n"); 
		query.append("          AND BKG.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("          AND RF.CNTR_NO = CLL.CNTR_NO" ).append("\n"); 
		query.append("          AND CLL.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("          AND CLL.POL_YD_CD like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("          AND CLL.VSL_CD = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("          AND CLL.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("          AND CLL.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("          AND CLL.POD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND VPS.CLPT_IND_SEQ = '1' " ).append("\n"); 
		query.append("#if (${in_by_type} == 'TS' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IN ('TS','TT') " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${in_by_type} == 'LOCAL' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IS NULL " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND VPS.VSL_CD = CLL.VSL_CD" ).append("\n"); 
		query.append("          AND VPS.SKD_VOY_NO = CLL.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND VPS.SKD_DIR_CD = CLL.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n"); 
		query.append("          AND (CLL.POD_CD = LO.UN_LOC_CD" ).append("\n"); 
		query.append("              OR CLL.POD_CD = LO.LOC_CD)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'BB' CGO_TYPE," ).append("\n"); 
		query.append("          CLL.BKG_NO BKG_NO," ).append("\n"); 
		query.append("          CLL.KR_CLL_TS_CD TS," ).append("\n"); 
		query.append("          NVL((" ).append("\n"); 
		query.append("                SELECT UN_LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = BKG.POL_CD), BKG.POL_CD) A_POL," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--BKG.POL_CD A_POL," ).append("\n"); 
		query.append("          NVL((" ).append("\n"); 
		query.append("                SELECT UN_LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = BKG.POD_CD), BKG.POD_CD) A_POD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--BKG.POD_CD A_POD," ).append("\n"); 
		query.append("          NVL((" ).append("\n"); 
		query.append("                SELECT UN_LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = CLL.POL_CD), CLL.POL_CD) POL," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--CLL.POL_CD POL," ).append("\n"); 
		query.append("          NVL((" ).append("\n"); 
		query.append("                SELECT UN_LOC_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE LOC_CD = CLL.POD_CD), CLL.POD_CD) POD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--CLL.POD_CD POD," ).append("\n"); 
		query.append("          0 CS," ).append("\n"); 
		query.append("          0 CS2," ).append("\n"); 
		query.append("          CLL.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("          CLL.CNTR_TPSZ_CD TP," ).append("\n"); 
		query.append("          CLL.BL_WGT WGT," ).append("\n"); 
		query.append("          CLL.WGT_UT_CD WGT_UNIT," ).append("\n"); 
		query.append("          ' ' CLASS_CD," ).append("\n"); 
		query.append("          ' ' UNNO," ).append("\n"); 
		query.append("          ' ' TEMP," ).append("\n"); 
		query.append("          ' ' VENT," ).append("\n"); 
		query.append("          ' ' REMARK," ).append("\n"); 
		query.append("          ' ' MP," ).append("\n"); 
		query.append("          ' ' SG," ).append("\n"); 
		query.append("          ' ' LQ," ).append("\n"); 
		query.append("          ' ' VO_ID," ).append("\n"); 
		query.append("          CLL.STWG_CD STOW," ).append("\n"); 
		query.append("          CLL.MTY_BKG_CD MTY_BKG_CD," ).append("\n"); 
		query.append("          VPS.CLPT_SEQ CLPT_SEQ," ).append("\n"); 
		query.append("          CLL.BLCK_STWG_CD," ).append("\n"); 
		query.append("          BKG.BLCK_STWG_CD AS BKG_BS" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("          BKG_CSTMS_TML_KR_CLL CLL," ).append("\n"); 
		query.append("          VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("          MDM_LOCATION LO" ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("          AND CLL.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("          AND CLL.POL_YD_CD like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("          AND CLL.VSL_CD = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("          AND CLL.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("          AND CLL.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("          AND CLL.POD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND CLL.CLL_RMK2 like 'BB%'" ).append("\n"); 
		query.append("          AND CLL.CNTR_TPSZ_CD NOT LIKE 'R%'" ).append("\n"); 
		query.append("          AND VPS.CLPT_IND_SEQ = '1' " ).append("\n"); 
		query.append("#if (${in_by_type} == 'TS' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IN ('TS','TT') " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${in_by_type} == 'LOCAL' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IS NULL " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND VPS.VSL_CD = CLL.VSL_CD" ).append("\n"); 
		query.append("          AND VPS.SKD_VOY_NO = CLL.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND VPS.SKD_DIR_CD = CLL.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n"); 
		query.append("          AND (CLL.POD_CD = LO.UN_LOC_CD" ).append("\n"); 
		query.append("              OR CLL.POD_CD = LO.LOC_CD) ) " ).append("\n"); 
		query.append("#if (${in_sort_type} == '1' )" ).append("\n"); 
		query.append("    ORDER BY POL, CLPT_SEQ, POD, DECODE(CGO_TYPE, 'DG', '1', 'RF', '2', 'AK', '3', '4'), BKG_NO, CS " ).append("\n"); 
		query.append("#elseif (${in_sort_type} == '2' )" ).append("\n"); 
		query.append("    ORDER BY CGO_TYPE, BKG_NO " ).append("\n"); 
		query.append("#elseif (${in_sort_type} == '3' )" ).append("\n"); 
		query.append("    ORDER BY CNTR_NO " ).append("\n"); 
		query.append("#elseif (${in_sort_type} == '4' )" ).append("\n"); 
		query.append("    ORDER BY POL, CLPT_SEQ, POD, DECODE(BLCK_STWG_CD, 'LOC', '11', 'ONE', '12', 'TWO', '13', 'THR', '14', 'FOR', '15', 'FIV', '15.5','HOT', '16', 'TRS', '17', '18'), BKG_NO " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}