/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchSimpleSiBkgInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchSimpleSiBkgInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSimpleSiBkgInfoList
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchSimpleSiBkgInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchSimpleSiBkgInfoListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'I_BOOKING.IB_BKG_NO'||'#@'||BKG.BKG_NO||'@#'||                         -- 2.BOOKING NUMBER" ).append("\n"); 
		query.append("'I_BKG_CUST.S.IBCS_NM'||'#@'||SCE_TOKEN_NL_FNC(CUST_SHPR.CUST_NM, 1)||'@#'||                 -- 3.SHIPPER NAME" ).append("\n"); 
		query.append("'I_BKG_CUST.S.IBCS_NM1'||'#@'||SCE_TOKEN_NL_FNC(CUST_SHPR.CUST_NM, 2)||'@#'||                 -- 3.SHIPPER NAME1" ).append("\n"); 
		query.append("'I_BKG_CUST.S.IBCS_ADDR'||'#@'||SCE_TOKEN_NL_FNC(CUST_SHPR.CUST_ADDR, 1)||'@#'||             -- 3.SHIPPER ADDRESS IN DETAIL" ).append("\n"); 
		query.append("'I_BKG_CUST.S.IBCS_ADDR1'||'#@'||SCE_TOKEN_NL_FNC(CUST_SHPR.CUST_ADDR, 2)||'@#'||             -- 3.SHIPPER ADDRESS IN DETAIL1" ).append("\n"); 
		query.append("'I_BKG_CUST.S.IBCS_ADDR2'||'#@'||SCE_TOKEN_NL_FNC(CUST_SHPR.CUST_ADDR, 3)||'@#'||             -- 3.SHIPPER ADDRESS IN DETAIL2" ).append("\n"); 
		query.append("'I_BKG_CUST.S.EUR_CSTMS_ST_NM'||'#@'||CUST_SHPR.EUR_CSTMS_ST_NM||'@#'|| -- 3.SHIPPER STREET NAME OR PO BOX" ).append("\n"); 
		query.append("'I_BKG_CUST.S.IBCS_LOC_NM'||'#@'||CUST_SHPR.CUST_CTY_NM||'@#'||         -- 3.SHIPPER CITY NAME" ).append("\n"); 
		query.append("'I_BKG_CUST.S.IBCS_STATE'||'#@'||(SELECT STE_NM FROM MDM_STATE WHERE CNT_CD = CUST_SHPR.CUST_CNT_CD AND STE_CD = CUST_SHPR.CUST_STE_CD)||'@#'||          -- 3.SHIPPER STATE NAME" ).append("\n"); 
		query.append("'I_BKG_CUST.S.IBCS_CUST_LOC'||'#@'||(SELECT CNT_NM FROM MDM_COUNTRY WHERE CNT_CD = CUST_SHPR.CSTMS_DECL_CNT_CD)||'@#'|| -- 3.SHIPPER COUNTRY NAME" ).append("\n"); 
		query.append("'I_BKG_CUST.S.IBCS_ZIP_CD'||'#@'||CUST_SHPR.CUST_ZIP_ID||'@#'||         -- 3.SHIPPER ZIP CODE" ).append("\n"); 
		query.append("'I_BKG_CUST.S.EORI_NO'||'#@'||CUST_SHPR.EORI_NO||'@#'||                 -- 3.SHIPPER EORI NUMBER" ).append("\n"); 
		query.append("'I_BKG_CUST.C.IBCS_NM'||'#@'||SCE_TOKEN_NL_FNC(CUST_CNEE.CUST_NM, 1)||'@#'||                 -- 4.CONSIGNEE NAME" ).append("\n"); 
		query.append("'I_BKG_CUST.C.IBCS_NM1'||'#@'||SCE_TOKEN_NL_FNC(CUST_CNEE.CUST_NM, 2)||'@#'||                 -- 4.CONSIGNEE NAME1" ).append("\n"); 
		query.append("'I_BKG_CUST.C.IBCS_ADDR'||'#@'||SCE_TOKEN_NL_FNC(CUST_CNEE.CUST_ADDR, 1)||'@#'||             -- 4.CONSIGNEE ADDRESS IN DETAIL" ).append("\n"); 
		query.append("'I_BKG_CUST.C.IBCS_ADDR1'||'#@'||SCE_TOKEN_NL_FNC(CUST_CNEE.CUST_ADDR, 2)||'@#'||             -- 4.CONSIGNEE ADDRESS IN DETAIL1" ).append("\n"); 
		query.append("'I_BKG_CUST.C.IBCS_ADDR2'||'#@'||SCE_TOKEN_NL_FNC(CUST_CNEE.CUST_ADDR, 3)||'@#'||             -- 4.CONSIGNEE ADDRESS IN DETAIL2" ).append("\n"); 
		query.append("'I_BKG_CUST.C.EUR_CSTMS_ST_NM'||'#@'||CUST_CNEE.EUR_CSTMS_ST_NM||'@#'|| -- 4.CONSIGNEE STREET NAME OR PO BOX" ).append("\n"); 
		query.append("'I_BKG_CUST.C.IBCS_LOC_NM'||'#@'||CUST_CNEE.CUST_CTY_NM||'@#'||         -- 4.CONSIGNEE CITY NAME" ).append("\n"); 
		query.append("'I_BKG_CUST.C.IBCS_STATE'||'#@'||(SELECT STE_NM FROM MDM_STATE WHERE CNT_CD = CUST_CNEE.CUST_CNT_CD AND STE_CD = CUST_CNEE.CUST_STE_CD)||'@#'||          -- 4.CONSIGNEE STATE NAME" ).append("\n"); 
		query.append("'I_BKG_CUST.C.IBCS_CUST_LOC'||'#@'||(SELECT CNT_NM FROM MDM_COUNTRY WHERE CNT_CD = CUST_CNEE.CSTMS_DECL_CNT_CD)||'@#'|| -- 4.CONSIGNEE COUNTRY NAME" ).append("\n"); 
		query.append("'I_BKG_CUST.C.IBCS_ZIP_CD'||'#@'||CUST_CNEE.CUST_ZIP_ID||'@#'||         -- 4.CONSIGNEE ZIP CODE" ).append("\n"); 
		query.append("'I_BKG_CUST.C.EORI_NO'||'#@'||CUST_CNEE.EORI_NO||'@#'||                 -- 4.CONSIGNEE EORI NUMBER" ).append("\n"); 
		query.append("'I_BKG_CUST.N.IBCS_NM'||'#@'||SCE_TOKEN_NL_FNC(CUST_NTFY.CUST_NM, 1)||'@#'||                 -- 5.NOTIFY NAME" ).append("\n"); 
		query.append("'I_BKG_CUST.N.IBCS_NM1'||'#@'||SCE_TOKEN_NL_FNC(CUST_NTFY.CUST_NM, 2)||'@#'||                 -- 5.NOTIFY NAME1" ).append("\n"); 
		query.append("'I_BKG_CUST.N.IBCS_ADDR'||'#@'||SCE_TOKEN_NL_FNC(CUST_NTFY.CUST_ADDR, 1)||'@#'||             -- 5.NOTIFY ADDRESS IN DETAIL" ).append("\n"); 
		query.append("'I_BKG_CUST.N.IBCS_ADDR1'||'#@'||SCE_TOKEN_NL_FNC(CUST_NTFY.CUST_ADDR, 2)||'@#'||             -- 5.NOTIFY ADDRESS IN DETAIL1" ).append("\n"); 
		query.append("'I_BKG_CUST.N.IBCS_ADDR2'||'#@'||SCE_TOKEN_NL_FNC(CUST_NTFY.CUST_ADDR, 3)||'@#'||             -- 5.NOTIFY ADDRESS IN DETAIL2" ).append("\n"); 
		query.append("'I_BKG_CUST.N.EUR_CSTMS_ST_NM'||'#@'||CUST_NTFY.EUR_CSTMS_ST_NM||'@#'|| -- 5.NOTIFY STREET NAME OR PO BOX" ).append("\n"); 
		query.append("'I_BKG_CUST.N.IBCS_LOC_NM'||'#@'||CUST_NTFY.CUST_CTY_NM||'@#'||         -- 5.NOTIFY CITY NAME" ).append("\n"); 
		query.append("'I_BKG_CUST.N.IBCS_STATE'||'#@'||(SELECT STE_NM FROM MDM_STATE WHERE CNT_CD = CUST_NTFY.CUST_CNT_CD AND STE_CD = CUST_NTFY.CUST_STE_CD)||'@#'||          -- 5.NOTIFY STATE NAME" ).append("\n"); 
		query.append("'I_BKG_CUST.N.IBCS_CUST_LOC'||'#@'||(SELECT CNT_NM FROM MDM_COUNTRY WHERE CNT_CD = CUST_NTFY.CSTMS_DECL_CNT_CD)||'@#'|| -- 5.NOTIFY COUNTRY NAME" ).append("\n"); 
		query.append("'I_BKG_CUST.N.IBCS_ZIP_CD'||'#@'||CUST_NTFY.CUST_ZIP_ID||'@#'||         -- 5.NOTIFY ZIP CODE" ).append("\n"); 
		query.append("'I_BKG_CUST.N.EORI_NO'||'#@'||CUST_NTFY.EORI_NO||'@#'||                 -- 5.NOTIFY EORI NUMBER" ).append("\n"); 
		query.append("'I_BKG_CUST.F.IBCS_NM'||'#@'||(DECODE(SCE_TOKEN_NL_FNC(CUST_FFFY.CUST_NM, 1),NULL,'', SCE_TOKEN_NL_FNC(CUST_FFFY.CUST_NM, 1) || '|') ||" ).append("\n"); 
		query.append("DECODE(SCE_TOKEN_NL_FNC(CUST_FFFY.CUST_NM, 2),NULL,'', SCE_TOKEN_NL_FNC(CUST_FFFY.CUST_NM, 2) || '|') ||" ).append("\n"); 
		query.append("DECODE(SCE_TOKEN_NL_FNC(CUST_FFFY.CUST_NM, 3),NULL,'', SCE_TOKEN_NL_FNC(CUST_FFFY.CUST_NM, 3) || '|') ||" ).append("\n"); 
		query.append("DECODE(SCE_TOKEN_NL_FNC(CUST_FFFY.CUST_NM, 4),NULL,'', SCE_TOKEN_NL_FNC(CUST_FFFY.CUST_NM, 4) || '|') ||" ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(CUST_FFFY.CUST_NM, 5))||'@#'||                 -- 6.F/FORWARDER" ).append("\n"); 
		query.append("'I_BKG_CUST.A.IBCS_NM'||'#@'||(DECODE(SCE_TOKEN_NL_FNC(CUST_ANFY.CUST_NM, 1),NULL,'', SCE_TOKEN_NL_FNC(CUST_ANFY.CUST_NM, 1) || '|') ||" ).append("\n"); 
		query.append("DECODE(SCE_TOKEN_NL_FNC(CUST_ANFY.CUST_NM, 2),NULL,'', SCE_TOKEN_NL_FNC(CUST_ANFY.CUST_NM, 2) || '|') ||" ).append("\n"); 
		query.append("DECODE(SCE_TOKEN_NL_FNC(CUST_ANFY.CUST_NM, 3),NULL,'', SCE_TOKEN_NL_FNC(CUST_ANFY.CUST_NM, 3) || '|') ||" ).append("\n"); 
		query.append("DECODE(SCE_TOKEN_NL_FNC(CUST_ANFY.CUST_NM, 4),NULL,'', SCE_TOKEN_NL_FNC(CUST_ANFY.CUST_NM, 4) || '|') ||" ).append("\n"); 
		query.append("SCE_TOKEN_NL_FNC(CUST_ANFY.CUST_NM, 5))||'@#'||                 -- 7.A/Notify" ).append("\n"); 
		query.append("'I_BKG_CUST.E.IBCS_NM'||'#@'||CUST_EF.CUST_NM||'@#'||                     -- 8.Export Reference" ).append("\n"); 
		query.append("'I_BOOKING.IB_PO_NO'||'#@'||PO_REF.CUST_REF_NO_CTNT||'@#'||               -- 9.PO NUMBER(ONLY 1)" ).append("\n"); 
		query.append("'I_BKG_AES.IB_ITN'||'#@'||XPT_IMP_LIC.AES_INLND_TRNS_NO||'@#'||           -- 10.Export / Import Information-AES ITN" ).append("\n"); 
		query.append("'I_BKG_CAED.IB_CAED_NO1'||'#@'||XPT_IMP_LIC.CAED_NO1||'@#'||               -- 10.CAED NO1" ).append("\n"); 
		query.append("'I_BKG_CAED.IB_CAED_NO2'||'#@'||XPT_IMP_LIC.CAED_NO2||'@#'||               -- 10.CAED NO2" ).append("\n"); 
		query.append("'I_BKG_CAED.IB_CAED_NO3'||'#@'||XPT_IMP_LIC.CAED_NO3||'@#'||               -- 10.CAED NO3" ).append("\n"); 
		query.append("'I_BOOKING.TAX_CNT_CD'||'#@'||(SELECT CNT_NM FROM MDM_COUNTRY WHERE CNT_CD = XPT_IMP_LIC.TAX_CNT_CD)||'@#'||                                -- 10.TAX COUNTRY CODE" ).append("\n"); 
		query.append("'I_BOOKING.IBCS_SHPR_TAX_ID'||'#@'||XPT_IMP_LIC.IBCS_SHPR_TAX_ID||'@#'||    -- 10.TAX ID - SHIPPER(J31)" ).append("\n"); 
		query.append("'I_BOOKING.IBCS_CNEE_TAX_ID'||'#@'||XPT_IMP_LIC.IBCS_CNEE_TAX_ID||'@#'||    -- 10.TAX ID - CONSIGNEE(J32)" ).append("\n"); 
		query.append("'I_BOOKING.IBCS_NTFY_TAX_ID'||'#@'||XPT_IMP_LIC.IBCS_NTFY_TAX_ID||'@#'||    -- 10.TAX ID - NOTIFY(J33)" ).append("\n"); 
		query.append("'I_BOOKING.IB_PRE_VSL_NM'||'#@'||PRE_VSL_NM.VSL_ENG_NM||'@#'||            -- 11.PRE-CARRIAAGE BY" ).append("\n"); 
		query.append("'I_BOOKING.IB_VVD_NM'||'#@'||TRUNK_VSL_NM.VSL_ENG_NM||'@#'||              -- 12.VESSEL VOYAGE" ).append("\n"); 
		query.append("'I_BOOKING.IB_SKD_VOYAGE_NO'||'#@'||BKG.SKD_VOY_NO || BKG.SKD_DIR_CD||'@#'||-- 12.VESSEL VOYAGE VVD" ).append("\n"); 
		query.append("'I_BOOKING.IB_POR_NM'||'#@'||POR_LOC.LOC_NM||'@#'||                       -- 13.PLACE OF RECEIPT" ).append("\n"); 
		query.append("'I_BOOKING.IB_POL_NM'||'#@'||POL_LOC.LOC_NM||'@#'||                       -- 14.PORT OF LOADING" ).append("\n"); 
		query.append("'I_BOOKING.IB_POD_NM'||'#@'||POD_LOC.LOC_NM||'@#'||                       -- 15.PORT OF DISCHARGE" ).append("\n"); 
		query.append("'I_BOOKING.IB_DEL_NM'||'#@'||DEL_LOC.LOC_NM||'@#'||                       -- 16.PLACE OF DELIVERY" ).append("\n"); 
		query.append("'I_BOOKING.IB_FNLDST_NM'||'#@'||FNL_LOC.LOC_NM||'@#'||                    -- 17.FINAL DESTINATION" ).append("\n"); 
		query.append("'I_BKG_MARK.IBM_MARK'||'#@'||REPLACE((REPLACE(MK_DESC.MK_DESC, CHR(13), '')), CHR(10), '|')||'@#'||                       -- 18.MARK" ).append("\n"); 
		query.append("'I_BKG_DESC.IBD_DESC'||'#@'||REPLACE((REPLACE(MK_DESC.CMDT_DESC, CHR(13), '')), CHR(10), '|')||'@#'||                     -- 19.DESCRIPTION" ).append("\n"); 
		query.append("'I_BOOKING.IB_FRT_TERM'||'#@'||DECODE(RATE.FRT_TERM_CD, 'P', 'PREPAID', 'C', 'COLLECT')||'@#'||                   -- 20.FREIGHT TERM" ).append("\n"); 
		query.append("'I_BOOKING.IB_TP'||'#@'||DECODE(NVL(BKG.BL_TP_CD,'O'),'O','ORIGINAL','W','OB/L(Surrender)','S','OB/L(Surrender)') ||'@#'||                    -- 21.B/L TERM" ).append("\n"); 
		query.append("'I_BOOKING.IB_ISS_LOC'||'#@'||(SELECT LOC.LOC_NM FROM MDM_ORGANIZATION ORG,MDM_LOCATION LOC WHERE ORG.LOC_CD = LOC.LOC_CD AND ORG.OFC_CD = ISS.OBL_ISS_OFC_CD)||'@#'||                     -- 21-1.B/L ISSUE PLACE" ).append("\n"); 
		query.append("'I_BOOKING.IB_ORI_CNT'||'#@'||DECODE(ISS.NON_NEGO_RT_INCL_KNT, 0,'',ISS.NON_NEGO_RT_XCLD_KNT)||'@#'||    -- 21-2.NO. OF B/L ISSUE - RATE" ).append("\n"); 
		query.append("'I_BOOKING.IB_BL_UNRATE_CNT'||'#@'||DECODE(ISS.NON_NEGO_RT_XCLD_KNT, 0,'',ISS.NON_NEGO_RT_XCLD_KNT)||'@#'||-- 21-2.NO. OF B/L ISSUE - UNRATE" ).append("\n"); 
		query.append("'I_BOOKING.IB_XPT_MRN_NO'||'#@'||XPT_REF.CUST_REF_NO_CTNT||'@#'||         -- 22.EXPORT MRN NO" ).append("\n"); 
		query.append("--BKG.XTER_RMK IB_RMK1,                         -- 22.REMARK" ).append("\n"); 
		query.append("'I_BOOKING.IB_PKG_QTY'||'#@'||DOC.PCK_QTY||'@#'||                         -- 23.TOTAL PACKAGE" ).append("\n"); 
		query.append("'I_BOOKING.IB_PKG_CD'||'#@'||(SELECT PCK_NM FROM MDM_PCK_TP WHERE PCK_CD = DOC.PCK_TP_CD)||'@#'||                        -- 23.TOTAL PACKAGE CODE" ).append("\n"); 
		query.append("'I_BOOKING.IB_WGT_QTY'||'#@'||DOC.ACT_WGT||'@#'||                         -- 23.TOTAL WEIGHT" ).append("\n"); 
		query.append("'I_BOOKING.IB_WGT_TP'||'#@'||DOC.WGT_UT_CD||'@#'||                        -- 23.TOTAL WEIGHT CODE" ).append("\n"); 
		query.append("'I_BOOKING.IB_MEA_QTY'||'#@'||DOC.MEAS_QTY||'@#'||                        -- 23.TOTAL MEASURE" ).append("\n"); 
		query.append("'I_BOOKING.IB_MEA_TP'||'#@'||DOC.MEAS_UT_CD||'@#'||                        -- 23.TOTAL MEASURE CODE" ).append("\n"); 
		query.append("-- House B/L" ).append("\n"); 
		query.append("'HBL.I_BOOKING.IB_BL_NO'||'#@'||HBL.HBL_NO||'@#'||                                                                              -- 1.HOUSE B/L NO" ).append("\n"); 
		query.append("'HBL.I_BKG_CUST.S.IBCS_NM'||'#@'||HBL_CUST_SHPR.CUST_NM||'@#'||                                                                     -- 2.ACTUAL NAME" ).append("\n"); 
		query.append("'HBL.I_BKG_CUST.S.IBCS_ADDR'||'#@'||SCE_TOKEN_NL_FNC(HBL_CUST_SHPR.CUST_ADDR, 1)||'@#'||      -- 2.ACTUAL ADDRESS" ).append("\n"); 
		query.append("'HBL.I_BKG_CUST.S.IBCS_ADDR1'||'#@'||SCE_TOKEN_NL_FNC(HBL_CUST_SHPR.CUST_ADDR, 2)||'@#'||     -- 2.ACTUAL ADDRESS1" ).append("\n"); 
		query.append("'HBL.I_BKG_CUST.C.IBCS_NM'||'#@'||HBL_CUST_CNEE.CUST_NM||'@#'||                                                                     -- 3.ACTUAL CONSIGNEE NAME" ).append("\n"); 
		query.append("'HBL.I_BKG_CUST.C.IBCS_ADDR'||'#@'||SCE_TOKEN_NL_FNC(HBL_CUST_CNEE.CUST_ADDR, 1)||'@#'||      -- 3.ACTUAL CONSIGNEE ADDRESS" ).append("\n"); 
		query.append("'HBL.I_BKG_CUST.C.IBCS_ADDR1'||'#@'||SCE_TOKEN_NL_FNC(HBL_CUST_CNEE.CUST_ADDR, 2)||'@#'||     -- 3.ACTUAL CONSIGNEE ADDRESS1" ).append("\n"); 
		query.append("'HBL.I_BKG_CUST.N.IBCS_NM'||'#@'||HBL_CUST_NTFY.CUST_NM||'@#'||                                                                     -- 4.ACTUAL NOTIFY NAME" ).append("\n"); 
		query.append("'HBL.I_BKG_CUST.N.IBCS_ADDR'||'#@'||SCE_TOKEN_NL_FNC(HBL_CUST_NTFY.CUST_ADDR, 1)||'@#'||      -- 4.ACTUAL NOTIFY ADDRESS" ).append("\n"); 
		query.append("'HBL.I_BKG_CUST.N.IBCS_ADDR1'||'#@'||SCE_TOKEN_NL_FNC(HBL_CUST_NTFY.CUST_ADDR, 2)||'@#'||     -- 4.ACTUAL NOTIFY ADDRESS1" ).append("\n"); 
		query.append("'HBL.I_BOOKING.IB_ORG_NM'||'#@'||DOC.ORG_CNT_NM||'@#'||                                                                         -- 5.POINT AND COUNTRY OF ORIGIN" ).append("\n"); 
		query.append("'HBL.I_BKG_MARK.IBM_MARK'||'#@'||(" ).append("\n"); 
		query.append("SELECT MAX(LTRIM(SYS_CONNECT_BY_PATH(RSLT_STR,'|'),'|')) BL_MK_DESC" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SUBSTR(IN_STR, LEVEL, 23) RSLT_STR, ROWNUM RNUM" ).append("\n"); 
		query.append("FROM   (SELECT BL_MK_DESC IN_STR" ).append("\n"); 
		query.append("FROM BKG_HBL" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND HBL_SEQ = 1)" ).append("\n"); 
		query.append("CONNECT BY LEVEL <= LENGTH(IN_STR)+23" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH RNUM = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RNUM = RNUM-23" ).append("\n"); 
		query.append(")||'@#'||                                                                            -- 6.MARK" ).append("\n"); 
		query.append("'HBL.I_BKG_DESC.IBD_DESC'||'#@'||(" ).append("\n"); 
		query.append("SELECT MAX(LTRIM(SYS_CONNECT_BY_PATH(RSLT_STR,'|'),'|')) BL_MK_DESC" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SUBSTR(IN_STR, LEVEL, 49) RSLT_STR, ROWNUM RNUM" ).append("\n"); 
		query.append("FROM   (SELECT BL_GDS_DESC IN_STR" ).append("\n"); 
		query.append("FROM BKG_HBL" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND HBL_SEQ = 1)" ).append("\n"); 
		query.append("CONNECT BY LEVEL <= LENGTH(IN_STR)+49" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START WITH RNUM = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RNUM = RNUM-49" ).append("\n"); 
		query.append(")||'@#'   AS MAP_STR                                                                        -- 7.DESCRIPTION" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING BKG," ).append("\n"); 
		query.append("BKG_REFERENCE PO_REF," ).append("\n"); 
		query.append("BKG_REFERENCE XPT_REF," ).append("\n"); 
		query.append("BKG_VVD PRE_VVD," ).append("\n"); 
		query.append("MDM_VSL_CNTR PRE_VSL_NM," ).append("\n"); 
		query.append("MDM_VSL_CNTR TRUNK_VSL_NM," ).append("\n"); 
		query.append("MDM_LOCATION POR_LOC," ).append("\n"); 
		query.append("MDM_LOCATION POL_LOC," ).append("\n"); 
		query.append("MDM_LOCATION POD_LOC," ).append("\n"); 
		query.append("MDM_LOCATION DEL_LOC," ).append("\n"); 
		query.append("MDM_LOCATION FNL_LOC," ).append("\n"); 
		query.append("BKG_RATE RATE," ).append("\n"); 
		query.append("BKG_BL_DOC DOC," ).append("\n"); 
		query.append("BKG_BL_ISS ISS," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("MAX(AES_INLND_TRNS_NO) AES_INLND_TRNS_NO," ).append("\n"); 
		query.append("MAX(CAED_NO1) CAED_NO1," ).append("\n"); 
		query.append("MAX(CAED_NO2) CAED_NO2," ).append("\n"); 
		query.append("MAX(CAED_NO3) CAED_NO3," ).append("\n"); 
		query.append("MAX(DECODE(CNT_CD,'MX',CNT_CD,'TR',CNT_CD)) TAX_CNT_CD," ).append("\n"); 
		query.append("MAX(NVL(MX_SHPR_TAX_ID,TR_SHPR_TAX_ID)) IBCS_SHPR_TAX_ID," ).append("\n"); 
		query.append("MAX(NVL(MX_CNEE_TAX_ID,TR_CNEE_TAX_ID)) IBCS_CNEE_TAX_ID," ).append("\n"); 
		query.append("MAX(NVL(MX_NTFY_TAX_ID,TR_NTFY_TAX_ID)) IBCS_NTFY_TAX_ID" ).append("\n"); 
		query.append("FROM BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("GROUP BY BKG_NO" ).append("\n"); 
		query.append(") XPT_IMP_LIC," ).append("\n"); 
		query.append("BKG_BL_MK_DESC MK_DESC," ).append("\n"); 
		query.append("BKG_CUSTOMER CUST_SHPR," ).append("\n"); 
		query.append("BKG_CUSTOMER CUST_CNEE," ).append("\n"); 
		query.append("BKG_CUSTOMER CUST_NTFY," ).append("\n"); 
		query.append("BKG_CUSTOMER CUST_FFFY," ).append("\n"); 
		query.append("BKG_CUSTOMER CUST_ANFY," ).append("\n"); 
		query.append("BKG_CUSTOMER CUST_EF," ).append("\n"); 
		query.append("BKG_HBL HBL," ).append("\n"); 
		query.append("BKG_HBL_CUST HBL_CUST_SHPR," ).append("\n"); 
		query.append("BKG_HBL_CUST HBL_CUST_CNEE," ).append("\n"); 
		query.append("BKG_HBL_CUST HBL_CUST_NTFY" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG.BKG_NO = PO_REF.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'BKPO' = PO_REF.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = XPT_REF.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'XMRN' = XPT_REF.BKG_REF_TP_CD(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = PRE_VVD.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'S' = PRE_VVD.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("AND SUBSTR(PRE_VVD.VSL_CD, 1, 4) = PRE_VSL_NM.VSL_CD(+)" ).append("\n"); 
		query.append("AND SUBSTR(BKG.VSL_CD, 1, 4) = TRUNK_VSL_NM.VSL_CD(+)" ).append("\n"); 
		query.append("AND BKG.POR_CD = POR_LOC.LOC_CD(+)" ).append("\n"); 
		query.append("AND BKG.POL_CD = POL_LOC.LOC_CD(+)" ).append("\n"); 
		query.append("AND BKG.POD_CD = POD_LOC.LOC_CD(+)" ).append("\n"); 
		query.append("AND BKG.DEL_CD = DEL_LOC.LOC_CD(+)" ).append("\n"); 
		query.append("AND BKG.FNL_DEST_CD = FNL_LOC.LOC_CD(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = RATE.BKG_NO(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = XPT_IMP_LIC.BKG_NO(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = MK_DESC.BKG_NO(+)" ).append("\n"); 
		query.append("AND 1 = MK_DESC.MK_SEQ(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = CUST_SHPR.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'S' = CUST_SHPR.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = CUST_CNEE.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'C' = CUST_CNEE.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = CUST_NTFY.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'N' = CUST_NTFY.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = CUST_EF.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'E' = CUST_EF.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = CUST_ANFY.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'A' = CUST_ANFY.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = CUST_FFFY.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'F' = CUST_FFFY.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND HBL.BKG_NO(+) = BKG.BKG_NO" ).append("\n"); 
		query.append("AND HBL.HBL_SEQ(+) = 1" ).append("\n"); 
		query.append("AND HBL.BKG_NO = HBL_CUST_SHPR.BKG_NO(+)" ).append("\n"); 
		query.append("AND HBL.HBL_SEQ = HBL_CUST_SHPR.HBL_SEQ(+)" ).append("\n"); 
		query.append("AND 'S' = HBL_CUST_SHPR.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND HBL.BKG_NO = HBL_CUST_CNEE.BKG_NO(+)" ).append("\n"); 
		query.append("AND HBL.HBL_SEQ = HBL_CUST_CNEE.HBL_SEQ(+)" ).append("\n"); 
		query.append("AND 'C' = HBL_CUST_CNEE.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND HBL.BKG_NO = HBL_CUST_NTFY.BKG_NO(+)" ).append("\n"); 
		query.append("AND HBL.HBL_SEQ = HBL_CUST_NTFY.HBL_SEQ(+)" ).append("\n"); 
		query.append("AND 'N' = HBL_CUST_NTFY.BKG_CUST_TP_CD(+)" ).append("\n"); 

	}
}