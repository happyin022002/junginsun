/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatusReportDBDAOBkgRptDownExcel1706RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOBkgRptDownExcel1706RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgRptDownExcel1706
	  * </pre>
	  */
	public StatusReportDBDAOBkgRptDownExcel1706RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("frt_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOBkgRptDownExcel1706RSQL").append("\n"); 
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
		query.append("#if (${sel_cols} != '') " ).append("\n"); 
		query.append("SELECT ${sel_cols}" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT *" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     '1' AS TEMP" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS BL_NO" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS BKG_OFC_CD" ).append("\n"); 
		query.append("    ,'BKG & B/L Info' AS OB_SLS_OFC_CD" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	ACT_WGT" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	WGT_UT_CD" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	MEAS_QTY" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	MEAS_UT_CD" ).append("\n"); 
		query.append("    ,'Cargo & Commodity' AS	REV_TON" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	SLAN_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	VSL_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	T_VVD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	TRD_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POR_CNT_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POR_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POR_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POL_CNT_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POL_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POL_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POD_CNT_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POD_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	POD_NM" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	DEL_CNT_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	DEL_CD" ).append("\n"); 
		query.append("    ,'Route & Schedule' AS	DEL_NM" ).append("\n"); 
		query.append("    ,'Charge' AS	CHG_CD" ).append("\n"); 
		query.append("    ,'Charge' AS	CHG_TP " ).append("\n"); 
		query.append("    ,'Charge' AS	TRF_ITM_NO" ).append("\n"); 
		query.append("    ,'Charge' AS	CURR_CD" ).append("\n"); 
		query.append("    ,'Charge' AS	CHG_TERM_CD" ).append("\n"); 
		query.append("    ,'Charge' AS	FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append("    ,'Charge' AS	CHG_UT_AMT" ).append("\n"); 
		query.append("    ,'Charge' AS	RAT_AS_QTY" ).append("\n"); 
		query.append("    ,'Charge' AS	RAT_UT_CD" ).append("\n"); 
		query.append("    ,'Charge' AS	CHG_AMT" ).append("\n"); 
		query.append("    ,'Charge' AS	CCT_CHG_AMT" ).append("\n"); 
		query.append("    ,'Charge' AS	PPD_CHG_AMT" ).append("\n"); 
		query.append("    ,'Charge' AS	CCT_XCH_RT" ).append("\n"); 
		query.append("    ,'Charge' AS	PPD_XCH_RT" ).append("\n"); 
		query.append("    ,'Charge' AS	PAY_OFC_CD" ).append("\n"); 
		query.append("    ,'Charge' AS	PAY_CUST" ).append("\n"); 
		query.append("    ,'Charge' AS	EXT_RMK_YN" ).append("\n"); 
		query.append("    ,'Charge' AS	EXT_RMK" ).append("\n"); 
		query.append("    ,'Charge' AS	INT_RMK_YN" ).append("\n"); 
		query.append("    ,'Charge' AS	INT_RMK" ).append("\n"); 
		query.append("    ,'0' AS DP_SEQ" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     '2' AS TEMP" ).append("\n"); 
		query.append("    ,'B/L Number' AS BL_NO" ).append("\n"); 
		query.append("    ,'Booking Office' AS BKG_OFC_CD" ).append("\n"); 
		query.append("    ,'Sales Office' AS OB_SLS_OFC_CD" ).append("\n"); 
		query.append("    ,'Weight' AS	ACT_WGT" ).append("\n"); 
		query.append("    ,'Weight Unit' AS	WGT_UT_CD" ).append("\n"); 
		query.append("    ,'Measure' AS	MEAS_QTY" ).append("\n"); 
		query.append("    ,'Measure Unit' AS	MEAS_UT_CD" ).append("\n"); 
		query.append("    ,'Revenue Ton' AS	REV_TON" ).append("\n"); 
		query.append("    ,'Trunk Lane' AS	SLAN_CD" ).append("\n"); 
		query.append("    ,'Trunk Vessel' AS	VSL_NM" ).append("\n"); 
		query.append("    ,'Trunk VVD' AS	T_VVD" ).append("\n"); 
		query.append("    ,'Trade Code' AS	TRD_CD" ).append("\n"); 
		query.append("    ,'POR Country' AS	POR_CNT_CD" ).append("\n"); 
		query.append("    ,'POR Code' AS	POR_CD" ).append("\n"); 
		query.append("    ,'POR Name' AS	POR_NM" ).append("\n"); 
		query.append("    ,'POL Country' AS	POL_CNT_CD" ).append("\n"); 
		query.append("    ,'POL Code' AS	POL_CD" ).append("\n"); 
		query.append("    ,'POL Name' AS	POL_NM" ).append("\n"); 
		query.append("    ,'POD Country' AS	POD_CNT_CD" ).append("\n"); 
		query.append("    ,'POD Code' AS	POD_CD" ).append("\n"); 
		query.append("    ,'POD Name' AS	POD_NM" ).append("\n"); 
		query.append("    ,'DEL Country' AS	DEL_CNT_CD" ).append("\n"); 
		query.append("    ,'DEL Code' AS	DEL_CD" ).append("\n"); 
		query.append("    ,'DEL Name' AS	DEL_NM" ).append("\n"); 
		query.append("    ,'Charge Code' AS	CHG_CD" ).append("\n"); 
		query.append("    ,'Charge Type' AS	CHG_TP " ).append("\n"); 
		query.append("    ,'Tariff Item No.' AS	TRF_ITM_NO" ).append("\n"); 
		query.append("    ,'Charge Currency' AS	CURR_CD" ).append("\n"); 
		query.append("    ,'Charge Term' AS	CHG_TERM_CD" ).append("\n"); 
		query.append("    ,'Inclusive/Normal' AS	FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append("    ,'Charge Rate' AS	CHG_UT_AMT" ).append("\n"); 
		query.append("    ,'Rated As' AS	RAT_AS_QTY" ).append("\n"); 
		query.append("    ,'Charge Per' AS	RAT_UT_CD" ).append("\n"); 
		query.append("    ,'Charge Amount' AS	CHG_AMT" ).append("\n"); 
		query.append("    ,'Collect' AS	CCT_CHG_AMT" ).append("\n"); 
		query.append("    ,'Prepaid' AS	PPD_CHG_AMT" ).append("\n"); 
		query.append("    ,'Exchange Rate (Collect)' AS	CCT_XCH_RT" ).append("\n"); 
		query.append("    ,'Exchange Rate (Prepaid)' AS	PPD_XCH_RT" ).append("\n"); 
		query.append("    ,'Payment Office' AS	PAY_OFC_CD" ).append("\n"); 
		query.append("    ,'Payer Code' AS	PAY_CUST" ).append("\n"); 
		query.append("    ,'Charge External Remark' AS	EXT_RMK_YN" ).append("\n"); 
		query.append("    ,'Charge External Remark Desc' AS	EXT_RMK" ).append("\n"); 
		query.append("    ,'Charge Internal Remark' AS	INT_RMK_YN" ).append("\n"); 
		query.append("    ,'Charge Internal Remark Desc' AS	INT_RMK" ).append("\n"); 
		query.append("    ,'0' AS DP_SEQ" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           '3' AS TEMP" ).append("\n"); 
		query.append("--BKG & B/L Info" ).append("\n"); 
		query.append("          ,BKG.BL_NO" ).append("\n"); 
		query.append("          ,BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("          ,BKG.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("--Cargo & Commodity" ).append("\n"); 
		query.append("          ,TRIM(TO_CHAR(DOC.ACT_WGT,'999,999,999,990.99')) AS ACT_WGT" ).append("\n"); 
		query.append("          ,DOC.WGT_UT_CD" ).append("\n"); 
		query.append("          ,TO_CHAR(DOC.MEAS_QTY) AS MEAS_QTY" ).append("\n"); 
		query.append("          ,DOC.MEAS_UT_CD" ).append("\n"); 
		query.append("          ,CASE WHEN NVL(DECODE(DOC.WGT_UT_CD,'LBS',0.453592,1) * DOC.ACT_WGT / 1000,0)" ).append("\n"); 
		query.append("                       > NVL(DECODE(DOC.WGT_UT_CD,'CBF',0.028317,1) * DOC.MEAS_QTY,0)" ).append("\n"); 
		query.append("                THEN TRIM(TO_CHAR(DECODE(DOC.WGT_UT_CD,'LBS',0.453592,1) * DOC.ACT_WGT / 1000,'999,999,999,990.99'))" ).append("\n"); 
		query.append("                ELSE TRIM(TO_CHAR(DECODE(DOC.WGT_UT_CD,'CBF',0.028317,1) * DOC.MEAS_QTY,'999,999,999,990.99'))" ).append("\n"); 
		query.append("            END REV_TON" ).append("\n"); 
		query.append("--Route & Schedule" ).append("\n"); 
		query.append("          ,BKG.SLAN_CD AS SLAN_CD" ).append("\n"); 
		query.append("          ,VSL.VSL_ENG_NM AS VSL_NM" ).append("\n"); 
		query.append("          ,BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD AS T_VVD" ).append("\n"); 
		query.append("--          ,COA_RLANE_TRD_CONV_FNC(VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD, VVD.SLAN_CD, VVD.POL_CD, VVD.POD_CD) AS TRD_CD" ).append("\n"); 
		query.append("          ,COA.TRD_CD" ).append("\n"); 
		query.append("          ,SUBSTR(BKG.POR_CD,1,2) AS POR_CNT_CD" ).append("\n"); 
		query.append("          ,BKG.POR_CD" ).append("\n"); 
		query.append("          ,POR.LOC_NM AS POR_NM" ).append("\n"); 
		query.append("          ,SUBSTR(BKG.POL_CD,1,2) AS POL_CNT_CD" ).append("\n"); 
		query.append("          ,BKG.POL_CD" ).append("\n"); 
		query.append("          ,POL.LOC_NM AS POL_NM" ).append("\n"); 
		query.append("          ,SUBSTR(BKG.POD_CD,1,2) AS POD_CNT_CD" ).append("\n"); 
		query.append("          ,BKG.POD_CD" ).append("\n"); 
		query.append("          ,POD.LOC_NM AS POD_NM" ).append("\n"); 
		query.append("          ,SUBSTR(BKG.DEL_CD,1,2) AS DEL_CNT_CD" ).append("\n"); 
		query.append("          ,BKG.DEL_CD" ).append("\n"); 
		query.append("          ,DEL.LOC_NM AS DEL_NM" ).append("\n"); 
		query.append("--Charge          " ).append("\n"); 
		query.append("          ,CHG.CHG_CD" ).append("\n"); 
		query.append("          ,CHG_DESC.INTG_CD_VAL_DP_DESC AS CHG_TP" ).append("\n"); 
		query.append("          ,CHG.TRF_ITM_NO" ).append("\n"); 
		query.append("          ,CHG.CURR_CD" ).append("\n"); 
		query.append("          ,CHG.FRT_TERM_CD AS CHG_TERM_CD" ).append("\n"); 
		query.append("          ,FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append("          ,TRIM(TO_CHAR(CHG.CHG_UT_AMT,'999,999,999,990.99')) AS CHG_UT_AMT" ).append("\n"); 
		query.append("          ,TO_CHAR(CHG.RAT_AS_QTY) AS RAT_AS_QTY" ).append("\n"); 
		query.append("          ,TO_CHAR(CHG.RAT_UT_CD) AS RAT_UT_CD" ).append("\n"); 
		query.append("          ,TRIM(TO_CHAR(CHG.CHG_AMT,'999,999,999,990.99')) AS CHG_AMT" ).append("\n"); 
		query.append("          ,TRIM(TO_CHAR(DECODE(CHG.FRT_TERM_CD, 'C', CHG.CHG_AMT, 0),'999,999,999,990.99')) AS CCT_CHG_AMT" ).append("\n"); 
		query.append("          ,TRIM(TO_CHAR(DECODE(CHG.FRT_TERM_CD, 'P', CHG.CHG_AMT, 0),'999,999,999,990.99')) AS PPD_CHG_AMT" ).append("\n"); 
		query.append("          ,(SELECT TO_CHAR(INV_XCH_RT)" ).append("\n"); 
		query.append("              FROM INV_AR_CHG AR_CHG" ).append("\n"); 
		query.append("             WHERE AR_IF_NO = (SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                                 FROM INV_AR_MN AR " ).append("\n"); 
		query.append("                                WHERE AR.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("                                  AND AR.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                                  AND AR.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                                  AND AR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                  AND AR.AR_OFC_CD = NVL(CHG.N3PTY_RCV_OFC_CD, RT.CLT_OFC_CD))" ).append("\n"); 
		query.append("               AND AR_CHG.CURR_CD = CHG.CURR_CD" ).append("\n"); 
		query.append("               AND CHG.FRT_TERM_CD = 'C'" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("           ) AS CCT_XCH_RT" ).append("\n"); 
		query.append("          ,(SELECT TO_CHAR(INV_XCH_RT)" ).append("\n"); 
		query.append("              FROM INV_AR_CHG AR_CHG" ).append("\n"); 
		query.append("             WHERE AR_IF_NO = (SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                                 FROM INV_AR_MN AR " ).append("\n"); 
		query.append("                                WHERE AR.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("                                  AND AR.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                                  AND AR.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                  AND AR.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                  AND AR.AR_OFC_CD = NVL(CHG.N3PTY_RCV_OFC_CD, RT.PPD_RCV_OFC_CD))" ).append("\n"); 
		query.append("               AND AR_CHG.CURR_CD = CHG.CURR_CD" ).append("\n"); 
		query.append("               AND CHG.FRT_TERM_CD = 'P'" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("           ) AS PPD_XCH_RT" ).append("\n"); 
		query.append("          ,NVL(CHG.N3PTY_RCV_OFC_CD, DECODE(CHG.FRT_TERM_CD, 'P', RT.PPD_RCV_OFC_CD,RT.CLT_OFC_CD)) AS PAY_OFC_CD" ).append("\n"); 
		query.append("          ,NVL(CHG.N3PTY_CUST_CNT_CD||LPAD(CHG.N3PTY_CUST_SEQ,6,'0'), DECODE(CHG.FRT_TERM_CD, 'P', RT.PPD_PAYR_CNT_CD||LPAD(RT.PPD_PAYR_CUST_SEQ,6,'0'),RT.CLT_PAYR_CNT_CD||LPAD(RT.CLT_PAYR_CUST_SEQ,6,'0'))) AS PAY_CUST" ).append("\n"); 
		query.append("          ,NVL2(RT.DIFF_RMK,'Y','N') EXT_RMK_YN" ).append("\n"); 
		query.append("          ,REPLACE(REPLACE(REPLACE(REPLACE(RT.DIFF_RMK,CHR(10),' '),CHR(9),' '),CHR(34),''),CHR(13),' ') AS EXT_RMK" ).append("\n"); 
		query.append("          ,NVL2(RT.RT_INTER_RMK,'Y','N') INT_RMK_YN" ).append("\n"); 
		query.append("          ,REPLACE(REPLACE(REPLACE(REPLACE(RT.RT_INTER_RMK,CHR(10),' '),CHR(9),' '),CHR(34),''),CHR(13),' ') AS INT_RMK" ).append("\n"); 
		query.append("          ,TO_CHAR(CHG.DP_SEQ) AS DP_SEQ" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("          ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("          ,BKG_CHG_RT CHG" ).append("\n"); 
		query.append("          ,MDM_CHARGE MDM_CHG" ).append("\n"); 
		query.append("          ,COM_INTG_CD_DTL CHG_DESC" ).append("\n"); 
		query.append("          ,BKG_RATE RT" ).append("\n"); 
		query.append("          ,MDM_LOCATION POR" ).append("\n"); 
		query.append("          ,MDM_LOCATION POL" ).append("\n"); 
		query.append("          ,MDM_LOCATION POD" ).append("\n"); 
		query.append("          ,MDM_LOCATION DEL" ).append("\n"); 
		query.append("          ,MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("          ,BKG_VVD VVD" ).append("\n"); 
		query.append("          ,COA_RGST_BKG COA" ).append("\n"); 
		query.append("     WHERE BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("       AND BKG.BKG_NO = CHG.BKG_NO" ).append("\n"); 
		query.append("       AND CHG.CHG_CD = MDM_CHG.CHG_CD" ).append("\n"); 
		query.append("       AND MDM_CHG.FRT_CHG_TP_CD = CHG_DESC.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("       AND CHG_DESC.INTG_CD_ID(+) = 'CD00630'" ).append("\n"); 
		query.append("       AND BKG.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("       AND BKG.POR_CD = POR.LOC_CD" ).append("\n"); 
		query.append("       AND BKG.POL_CD = POL.LOC_CD" ).append("\n"); 
		query.append("       AND BKG.POD_CD = POD.LOC_CD" ).append("\n"); 
		query.append("       AND BKG.DEL_CD = DEL.LOC_CD" ).append("\n"); 
		query.append("       AND BKG.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("       AND BKG.BKG_NO = COA.BKG_NO(+)" ).append("\n"); 
		query.append("    -- SEARCH OPTION" ).append("\n"); 
		query.append("       AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND BKG.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("	--===================================================================== 화면 조건절 start" ).append("\n"); 
		query.append("    #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("           AND VVD.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("           AND VVD.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("           AND VVD.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pol_cd} != '') " ).append("\n"); 
		query.append("	       AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("	 #if (${pol_local} != '')" ).append("\n"); 
		query.append("	       AND BKG.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${pod_cd} != '') " ).append("\n"); 
		query.append("           AND VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("     #if (${pod_local} != '')" ).append("\n"); 
		query.append("           AND BKG.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${por_cd} != '') " ).append("\n"); 
		query.append("           AND BKG.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${del_cd} != '') " ).append("\n"); 
		query.append("           AND BKG.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${ob_sls_ofc_cd} != '') " ).append("\n"); 
		query.append("    	   AND BKG.OB_SLS_OFC_CD = @[ob_sls_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("    	   AND BKG.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${trd_cd} != '') " ).append("\n"); 
		query.append("       	   AND COA.TRD_CD = @[trd_cd]--COA_RLANE_TRD_CONV_FNC(VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD, VVD.SLAN_CD, VVD.POL_CD, VVD.POD_CD)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	#if (${frt_chg_tp_cd} != '') " ).append("\n"); 
		query.append("    	   AND MDM_CHG.FRT_CHG_TP_CD = @[frt_chg_tp_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${sc_rfa_gbn} == 'S') " ).append("\n"); 
		query.append("     #if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("               AND BKG.SC_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("    #elseif (${sc_rfa_gbn} == 'R') " ).append("\n"); 
		query.append("     #if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("               AND BKG.RFA_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("    #elseif (${sc_rfa_gbn} == 'T') " ).append("\n"); 
		query.append("     #if (${sc_rfa_no} != '') " ).append("\n"); 
		query.append("               AND BKG.TAA_NO = @[sc_rfa_no]" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	--===================================================================== 화면 조건절 end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${orderby} == '') " ).append("\n"); 
		query.append("ORDER BY TEMP, BL_NO, TO_NUMBER(DP_SEQ)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY TEMP, ${orderby}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}