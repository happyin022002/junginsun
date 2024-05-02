/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyCargoClosingTimeByReplanUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyCargoClosingTimeByReplanUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cargo closing time을 계산하여 넣는다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyCargoClosingTimeByReplanUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyCargoClosingTimeByReplanUSQL").append("\n"); 
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
		query.append("update bkg_clz_tm" ).append("\n"); 
		query.append("   set CLZ_YD_CD = case when clz_tp_cd = 'F' then (SELECT ORG_NOD_CD" ).append("\n"); 
		query.append("													 from prd_prod_ctl_rout_dtl dtl " ).append("\n"); 
		query.append("												        , prd_prod_ctl_mst mst " ).append("\n"); 
		query.append("												        , sce_cop_hdr cop " ).append("\n"); 
		query.append("													where dtl.PCTL_IO_BND_CD = 'O' " ).append("\n"); 
		query.append("													  and dtl.TRSP_MOD_CD    = 'RD' " ).append("\n"); 
		query.append("													  and mst.pctl_no        = dtl.pctl_no " ).append("\n"); 
		query.append("													  and mst.pctl_no        = cop.pctl_no " ).append("\n"); 
		query.append("													  and cop.bkg_no         = @[bkg_no]" ).append("\n"); 
		query.append("													  and cop.COP_STS_CD     <> 'X'" ).append("\n"); 
		query.append("													  and dtl.pctl_seq = (select min(fst.pctl_seq)" ).append("\n"); 
		query.append("													                        from prd_prod_ctl_rout_dtl fst " ).append("\n"); 
		query.append("													                       where fst.pctl_no = mst.pctl_no " ).append("\n"); 
		query.append("													                         and fst.PCTL_IO_BND_CD = 'O'                         " ).append("\n"); 
		query.append("													                         and fst.TRSP_MOD_CD = 'RD')" ).append("\n"); 
		query.append("  													  and rownum = 1)" ).append("\n"); 
		query.append("						WHEN CLZ_TP_CD = 'O' THEN (SELECT ORG_NOD_CD" ).append("\n"); 
		query.append("													 from prd_prod_ctl_rout_dtl dtl " ).append("\n"); 
		query.append("												        , prd_prod_ctl_mst mst " ).append("\n"); 
		query.append("												        , sce_cop_hdr cop " ).append("\n"); 
		query.append("													where dtl.PCTL_IO_BND_CD = 'O' " ).append("\n"); 
		query.append("													  and dtl.TRSP_MOD_CD    = 'RD' " ).append("\n"); 
		query.append("													  and mst.pctl_no        = dtl.pctl_no " ).append("\n"); 
		query.append("													  and mst.pctl_no        = cop.pctl_no " ).append("\n"); 
		query.append("													  and cop.bkg_no         = @[bkg_no]  " ).append("\n"); 
		query.append("													  and cop.COP_STS_CD     <> 'X'" ).append("\n"); 
		query.append("													  and dtl.pctl_seq = (select max(fst.pctl_seq)" ).append("\n"); 
		query.append("													                        from prd_prod_ctl_rout_dtl fst " ).append("\n"); 
		query.append("													                       where fst.pctl_no = mst.pctl_no " ).append("\n"); 
		query.append("													                         and fst.PCTL_IO_BND_CD = 'O'                         " ).append("\n"); 
		query.append("													                         and fst.TRSP_MOD_CD = 'RD')" ).append("\n"); 
		query.append("  													  and rownum = 1)" ).append("\n"); 
		query.append("						WHEN CLZ_TP_CD = 'R' THEN (SELECT FULL_RTN_YD_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("						WHEN CLZ_TP_CD = 'T' THEN (SELECT pol_nod_cd     FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("						WHEN CLZ_TP_CD = 'D' THEN (SELECT pol_nod_cd     FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("						WHEN CLZ_TP_CD = 'E' THEN (SELECT pol_nod_cd     FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("						WHEN CLZ_TP_CD = 'M' THEN (SELECT mty_pkup_yd_cd FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("						ELSE '' END" ).append("\n"); 
		query.append("     , sys_set_dt = case when clz_tp_cd = 'F' then to_date(NVL(@[from_dt], TO_CHAR(SYS_SET_DT, 'YYYYMMDD')), 'yyyymmdd')" ).append("\n"); 
		query.append("                         when clz_tp_cd = 'O' then to_date(NVL(@[to_dt],   TO_CHAR(SYS_SET_DT, 'YYYYMMDD')), 'yyyymmdd')" ).append("\n"); 
		query.append("                         when clz_tp_cd = 'M' then (SELECT mty_pkup_dt FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                         when clz_tp_cd = 'T' then (select  PRD_COMMON_PKG.PRD_GET_CCT_BY_BKG_FNC(@[bkg_no])" ).append("\n"); 
		query.append("                                                     from (SELECT SKD.SLAN_CD SLAN_CD" ).append("\n"); 
		query.append("                                                                 , VVD.SKD_DIR_CD SLAN_DIR_CD" ).append("\n"); 
		query.append("                                                                 , CASE WHEN DCGO_FLG = 'Y' THEN 'DG'" ).append("\n"); 
		query.append("																		WHEN RC_FLG   = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("                                                                        WHEN DCGO_FLG = 'N' AND RC_FLG = 'N' AND AWK_CGO_FLG = 'N' AND BB_CGO_FLG = 'N' THEN 'DR'" ).append("\n"); 
		query.append("                                                                        ELSE 'AL' END CGO_TP_CD" ).append("\n"); 
		query.append("                                                                 , VPS_ETB_DT" ).append("\n"); 
		query.append("                                                                 , VPS_ETD_DT" ).append("\n"); 
		query.append("                                                                 , pol_nod_cd" ).append("\n"); 
		query.append("																 , NVL(VVD.POL_CLPT_IND_SEQ, 1) AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                                 , VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                                                               FROM BKG_BOOKING BK, BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                                                              WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                                                AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                                                                AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("																AND VVD.VSL_CD	   NOT IN ('COXX','COYY','COZZ')" ).append("\n"); 
		query.append("                                                                AND VVD.VSL_CD     = SKD.VSL_CD" ).append("\n"); 
		query.append("                                                                AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                AND VVD.POL_CD     = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                                AND NVL(VVD.POL_CLPT_IND_SEQ, 1) = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                                AND BK.BKG_NO      = @[bkg_no]) skd) " ).append("\n"); 
		query.append("                         when clz_tp_cd = 'R' then (CASE WHEN (SELECT /*+index_asc(scd XPKSCE_COP_DTL) */ decode(BK.POL_CD,SUBSTR(SCD.NOD_CD,1,5),'Y','N')" ).append("\n"); 
		query.append("                                                              FROM SCE_COP_HDR SCH" ).append("\n"); 
		query.append("                                                                   ,SCE_COP_DTL SCD" ).append("\n"); 
		query.append("                                                                   ,BKG_BOOKING BK" ).append("\n"); 
		query.append("                                                              WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                              AND SCH.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                              AND SCH.COP_NO = SCD.COP_NO" ).append("\n"); 
		query.append("                                                              AND SCD.ACT_CD LIKE 'F%AD'" ).append("\n"); 
		query.append("                                                              AND rownum = 1) = 'N' THEN" ).append("\n"); 
		query.append("                                                             (SELECT    NVL(PRD_GET_INLND_CCT_FNC(BK.PCTL_NO)" ).append("\n"); 
		query.append("                                                                 ,(SELECT /*+INDEX_DESC(DTL XPKPRD_PROD_CTL_ROUT_DTL)*/" ).append("\n"); 
		query.append("                                                                         DTL.ARR_ST_DT" ).append("\n"); 
		query.append("                                                                  FROM PRD_PROD_CTL_ROUT_DTL DTL, PRD_INLND_ROUT_MST O" ).append("\n"); 
		query.append("                                                                  WHERE DTL.PCTL_NO = BK.PCTL_NO" ).append("\n"); 
		query.append("                                                                  AND DTL.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                                                  AND DTL.ROUT_ORG_NOD_CD = O.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                                                                  AND DTL.ROUT_DEST_NOD_CD = O.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                                                                  AND DTL.ROUT_SEQ = O.ROUT_SEQ" ).append("\n"); 
		query.append("                                                                  AND DTL.ORG_NOD_CD = O.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("                                                                  AND DTL.ROUT_SEQ > 0" ).append("\n"); 
		query.append("                                                                  AND DTL.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                                  AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                                  UNION ALL" ).append("\n"); 
		query.append("                                                                  SELECT /*+INDEX_DESC(DTL XPKPRD_PROD_CTL_ROUT_DTL)*/" ).append("\n"); 
		query.append("                                                                       DTL.ARR_ST_DT" ).append("\n"); 
		query.append("                                                                  FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("                                                                  WHERE DTL.PCTL_NO = BK.PCTL_NO" ).append("\n"); 
		query.append("                                                                  AND DTL.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                                                  AND DTL.ROUT_SEQ = 0" ).append("\n"); 
		query.append("                                                                  AND ROWNUM = 1))" ).append("\n"); 
		query.append("                                                            FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("                                                            WHERE BK.BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                                                             " ).append("\n"); 
		query.append("                                                      ELSE" ).append("\n"); 
		query.append("                                                           (select PRD_COMMON_PKG.PRD_GET_CCT_BY_BKG_FNC(@[bkg_no])" ).append("\n"); 
		query.append("                                                              from (SELECT SKD.SLAN_CD SLAN_CD" ).append("\n"); 
		query.append("                                                                       , VVD.SKD_DIR_CD SLAN_DIR_CD" ).append("\n"); 
		query.append("                                                                       , CASE WHEN DCGO_FLG = 'Y' THEN 'DG'" ).append("\n"); 
		query.append("      																		  WHEN RC_FLG   = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("                                                                              WHEN DCGO_FLG = 'N' AND RC_FLG = 'N' AND AWK_CGO_FLG = 'N' AND BB_CGO_FLG = 'N' THEN 'DR'" ).append("\n"); 
		query.append("                                                                              ELSE 'AL' END CGO_TP_CD" ).append("\n"); 
		query.append("                                                                       , VPS_ETB_DT" ).append("\n"); 
		query.append("                                                                       , VPS_ETD_DT" ).append("\n"); 
		query.append("                                                                       , pol_nod_cd" ).append("\n"); 
		query.append("      																   , NVL(VVD.POL_CLPT_IND_SEQ, 1) AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                                       , VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                                                                     FROM BKG_BOOKING BK, BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                                                                    WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                                                      AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                                                                      AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("      																  AND VVD.VSL_CD	   NOT IN ('COXX','COYY','COZZ')" ).append("\n"); 
		query.append("                                                                      AND VVD.VSL_CD     = SKD.VSL_CD" ).append("\n"); 
		query.append("                                                                      AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                      AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                      AND VVD.POL_CD     = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                                      AND NVL(VVD.POL_CLPT_IND_SEQ, 1) = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                                      AND BK.BKG_NO      = @[bkg_no]) skd)" ).append("\n"); 
		query.append("                                                      END)" ).append("\n"); 
		query.append("						 WHEN CLZ_TP_CD = 'D' THEN (SELECT CASE WHEN XCLD_HOL_FLG = 'Y' THEN " ).append("\n"); 
		query.append("                                                                    NVL((SELECT MIN(HOL.HOL_DT) - 1 + (1/24*17)--연휴시작 전일 17시" ).append("\n"); 
		query.append("                                                                           FROM DMT_HOLIDAY HOL" ).append("\n"); 
		query.append(" 															              WHERE (HOL_YR,CNT_CD,RGN_CD,STE_CD,LOC_CD,HOL_DESC)" ).append("\n"); 
		query.append("														                          in (select HOL_YR,CNT_CD,RGN_CD,STE_CD,LOC_CD,HOL_DESC" ).append("\n"); 
		query.append("														                                from dmt_holiday 	" ).append("\n"); 
		query.append("														                               WHERE SUBSTR(DCT.POL_NOD_CD, 1, 2) = CNT_CD(+)" ).append("\n"); 
		query.append("															                             AND SUBSTR(DCT.POL_NOD_CD, 1, 5) = case when trim(hol.loc_cd) is null then SUBSTR(DCT.POL_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("											                                                             						 else HOL.LOC_CD end " ).append("\n"); 
		query.append("                     														            and hol_yr = to_char(DCT, 'yyyy')" ).append("\n"); 
		query.append("                    	      														    and to_char(HOL_DT, 'yyyymmdd') = to_char(DCT, 'yyyymmdd'))), DCT.DCT)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                                ELSE DCT.DCT END DCT" ).append("\n"); 
		query.append("                                                      FROM (SELECT CASE WHEN TRIM(TO_CHAR(DCT, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH')) = 'SUNDAY' AND XCLD_SUN_FLG ='Y' AND XCLD_SAT_FLG ='Y' AND XCLD_FRI_FLG = 'Y' THEN DCT - 3 " ).append("\n"); 
		query.append("																		WHEN TRIM(TO_CHAR(DCT, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH')) = 'SUNDAY' AND XCLD_SUN_FLG ='Y' AND XCLD_SAT_FLG ='Y' AND XCLD_FRI_FLG = 'N' THEN DCT - 2 " ).append("\n"); 
		query.append("																		WHEN TRIM(TO_CHAR(DCT, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH')) = 'SUNDAY' AND XCLD_SUN_FLG ='Y' AND XCLD_SAT_FLG ='N' THEN DCT - 1" ).append("\n"); 
		query.append("            															WHEN TRIM(TO_CHAR(DCT, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH')) = 'SATURDAY' AND XCLD_SAT_FLG ='Y' AND XCLD_FRI_FLG = 'Y' THEN DCT - 2 " ).append("\n"); 
		query.append("            															WHEN TRIM(TO_CHAR(DCT, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH')) = 'SATURDAY' AND XCLD_SAT_FLG ='Y' AND XCLD_FRI_FLG = 'N' THEN DCT - 1 " ).append("\n"); 
		query.append("            															WHEN TRIM(TO_CHAR(DCT, 'DAY', 'NLS_DATE_LANGUAGE=ENGLISH')) = 'FRIDAY' AND XCLD_FRI_FLG ='Y'   THEN DCT - 1" ).append("\n"); 
		query.append("       															    ELSE DCT END DCT" ).append("\n"); 
		query.append("                                                                 , POL_NOD_CD" ).append("\n"); 
		query.append("                                                                 , XCLD_HOL_FLG" ).append("\n"); 
		query.append("                                                              from (SELECT CASE WHEN DOC_CLZ_TP_CD = 'B' THEN BKG.etb + (ITVAL_HRS/24) --ETB" ).append("\n"); 
		query.append("                                                                                WHEN DOC_CLZ_TP_CD = 'D' THEN BKG.etd + (ITVAL_HRS/24) --ETD" ).append("\n"); 
		query.append("                                                                                WHEN DOC_CLZ_TP_CD = 'A' THEN BKG.eta + (ITVAL_HRS/24) --ETA" ).append("\n"); 
		query.append("																				WHEN DOC_CLZ_TP_CD = 'Y' AND DOC_CLZ_DY_CD = '1DA' THEN to_date(to_char(BKG.eta,'YYYY/MM/DD'),'YYYY/MM/DD')-1 + DOC_CLZ_DY_HRS/(24*60) --ETA - 1" ).append("\n"); 
		query.append("																				WHEN DOC_CLZ_TP_CD = 'Y' AND DOC_CLZ_DY_CD = '2DA' THEN to_date(to_char(BKG.eta,'YYYY/MM/DD'),'YYYY/MM/DD')-2 + DOC_CLZ_DY_HRS/(24*60) --ETA - 2" ).append("\n"); 
		query.append("																				WHEN DOC_CLZ_TP_CD = 'Y' AND DOC_CLZ_DY_CD = '3DA' THEN to_date(to_char(BKG.eta,'YYYY/MM/DD'),'YYYY/MM/DD')-3 + DOC_CLZ_DY_HRS/(24*60) --ETA - 3" ).append("\n"); 
		query.append("																				WHEN DOC_CLZ_TP_CD = 'Y' AND DOC_CLZ_DY_CD = '1DB' THEN to_date(to_char(BKG.etb,'YYYY/MM/DD'),'YYYY/MM/DD')-1 + DOC_CLZ_DY_HRS/(24*60) --ETB - 1 " ).append("\n"); 
		query.append("																				WHEN DOC_CLZ_TP_CD = 'Y' AND DOC_CLZ_DY_CD = '2DB' THEN to_date(to_char(BKG.etb,'YYYY/MM/DD'),'YYYY/MM/DD')-2 + DOC_CLZ_DY_HRS/(24*60) --ETB - 2 " ).append("\n"); 
		query.append("																				WHEN DOC_CLZ_TP_CD = 'Y' AND DOC_CLZ_DY_CD = '3DB' THEN to_date(to_char(BKG.etb,'YYYY/MM/DD'),'YYYY/MM/DD')-3 + DOC_CLZ_DY_HRS/(24*60) --ETB - 3 " ).append("\n"); 
		query.append("																				WHEN DOC_CLZ_TP_CD = 'Y' AND DOC_CLZ_DY_CD = '1DD' THEN to_date(to_char(BKG.etd,'YYYY/MM/DD'),'YYYY/MM/DD')-1 + DOC_CLZ_DY_HRS/(24*60) --ETD - 1 " ).append("\n"); 
		query.append("																				WHEN DOC_CLZ_TP_CD = 'Y' AND DOC_CLZ_DY_CD = '2DD' THEN to_date(to_char(BKG.etd,'YYYY/MM/DD'),'YYYY/MM/DD')-2 + DOC_CLZ_DY_HRS/(24*60) --ETD - 2 " ).append("\n"); 
		query.append("																				WHEN DOC_CLZ_TP_CD = 'Y' AND DOC_CLZ_DY_CD = '3DD' THEN to_date(to_char(BKG.etd,'YYYY/MM/DD'),'YYYY/MM/DD')-3 + DOC_CLZ_DY_HRS/(24*60) --ETD - 3 " ).append("\n"); 
		query.append("																				WHEN DOC_CLZ_TP_CD = 'Y' AND DOC_CLZ_DY_CD = 'MON' OR DOC_CLZ_DY_CD = 'TUE' OR DOC_CLZ_DY_CD = 'WED' OR DOC_CLZ_DY_CD = 'THU' OR DOC_CLZ_DY_CD = 'FRI' " ).append("\n"); 
		query.append("																							OR DOC_CLZ_DY_CD = 'SAT' OR DOC_CLZ_DY_CD = 'SUN' THEN " ).append("\n"); 
		query.append("																								( SELECT to_date(to_char(BKG.etd,'YYYY/MM/DD'),'YYYY/MM/DD')-CPY_NO + DOC_CLZ_DY_HRS/(24*60)  " ).append("\n"); 
		query.append("																								  FROM   COM_CPY_NO " ).append("\n"); 
		query.append("																								  WHERE  CPY_NO BETWEEN 1 AND 7" ).append("\n"); 
		query.append("																									 AND    DOC_CLZ_DY_CD = TO_CHAR(BKG.etd - CPY_NO , 'DY', 'NLS_DATE_LANGUAGE = ENGLISH') ) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                                           END  DCT" ).append("\n"); 
		query.append("                                                                         , CLZ_SET.XCLD_HOL_FLG" ).append("\n"); 
		query.append("                                                                         , CLZ_SET.XCLD_SUN_FLG" ).append("\n"); 
		query.append("                                                                         , CLZ_SET.XCLD_SAT_FLG" ).append("\n"); 
		query.append("                                                                         , CLZ_SET.XCLD_FRI_FLG" ).append("\n"); 
		query.append("                                                                         , BKG.POL_NOD_CD" ).append("\n"); 
		query.append("																         , decode(clz_set.VSL_SLAN_CD, '*', 2, 1) ORD1" ).append("\n"); 
		query.append("																         , decode(clz_set.DEST_CNT_CD, '*', 2, 1) ORD2   " ).append("\n"); 
		query.append("                                                                      FROM bkg_DOC_CLZ_SET clz_set, " ).append("\n"); 
		query.append("                                                                                (SELECT SKD.SLAN_CD SLAN_CD" ).append("\n"); 
		query.append("                                                                                         , SKD.VPS_ETB_DT etb" ).append("\n"); 
		query.append("                                                                                         , SKD.VPS_ETD_DT etd" ).append("\n"); 
		query.append("                                                                                         , SKD.vps_eta_dt eta" ).append("\n"); 
		query.append("                                                                                         , BK.pol_nod_cd" ).append("\n"); 
		query.append("                                                                                         , BK.pod_nod_cd" ).append("\n"); 
		query.append("                                                                                FROM BKG_BOOKING BK, BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                                                                                WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                                                                AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                                                                                AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("																				AND VVD.VSL_CD	   NOT IN ('COXX','COYY','COZZ')" ).append("\n"); 
		query.append("                                                                                AND VVD.VSL_CD     = SKD.VSL_CD" ).append("\n"); 
		query.append("                                                                                AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                AND VVD.POL_CD     = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                                                AND NVL(VVD.POL_CLPT_IND_SEQ, 1) = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                                                AND BK.BKG_NO      = @[bkg_no]) BKG" ).append("\n"); 
		query.append("                                                                     WHERE clz_set.YD_CD       like substr(BKG.pol_nod_cd, 1, 5)||'%'" ).append("\n"); 
		query.append("                                                                       AND clz_set.VSL_SLAN_CD = decode(clz_set.VSL_SLAN_CD, '*', clz_set.VSL_SLAN_CD, BKG.SLAN_CD)" ).append("\n"); 
		query.append("                                                                       and clz_set.DEST_CNT_CD = decode(clz_set.DEST_CNT_CD, '*', clz_set.DEST_CNT_CD, SUBSTR(BKG.POD_NOD_CD, 1, 2))" ).append("\n"); 
		query.append("                                                                       AND clz_set.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("																	 ORDER BY ORD1, ORD2" ).append("\n"); 
		query.append("                                                                    ) " ).append("\n"); 
		query.append("														     WHERE ROWNUM = 1	" ).append("\n"); 
		query.append("                                                            ) DCT)" ).append("\n"); 
		query.append("                    end    " ).append("\n"); 
		query.append("     , upd_dt = sysdate" ).append("\n"); 
		query.append("     , upd_usr_id = NVL(@[usr_id], 'SYSTEM')" ).append("\n"); 
		query.append(" where bkg_no = @[bkg_no]  " ).append("\n"); 
		query.append("   and clz_tp_cd in ('O', 'F', 'T', 'R', 'D', 'E', 'M')" ).append("\n"); 

	}
}