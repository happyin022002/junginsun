/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchAlocStandbyReasonEqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.12 
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

public class GeneralBookingSearchDBDAOSearchAlocStandbyReasonEqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Allocation Stand by Reason 의 EQ & Commodity Restriction 을 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchAlocStandbyReasonEqRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOSearchAlocStandbyReasonEqRSQL").append("\n"); 
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
		query.append("SELECT (SELECT CICD.INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL CICD " ).append("\n"); 
		query.append("         WHERE CICD.INTG_CD_ID = 'CD03267' " ).append("\n"); 
		query.append("           AND CICD.INTG_CD_VAL_CTNT = TT.BKG_ALOC_TP_CD) TYPE" ).append("\n"); 
		query.append("       , MAX(DECODE(ALOC_FLAG,'POR','Y','N')) POR_FLAG" ).append("\n"); 
		query.append("       , MAX(DECODE(ALOC_FLAG,'POL','Y','N')) POL_FLAG" ).append("\n"); 
		query.append("       , MAX(DECODE(ALOC_FLAG,'POD','Y','N')) POD_FLAG" ).append("\n"); 
		query.append("       , MAX(DECODE(ALOC_FLAG,'DEL','Y','N')) DEL_FLAG" ).append("\n"); 
		query.append("       , MAX(DECODE(ALOC_FLAG,'TS','Y','N')) TS_PORT_FLAG" ).append("\n"); 
		query.append("       , MAX(DECODE(ALOC_FLAG,'OTHER','Y','N')) OTHER_FLAG" ).append("\n"); 
		query.append("       , MAX(CASE WHEN ALOC_FLAG = 'POR' THEN BKG_ALOC_RMK ELSE '' END) POR_REMARK" ).append("\n"); 
		query.append("       , MAX(CASE WHEN ALOC_FLAG = 'POL' THEN BKG_ALOC_RMK ELSE '' END) POL_REMARK" ).append("\n"); 
		query.append("       , MAX(CASE WHEN ALOC_FLAG = 'POD' THEN BKG_ALOC_RMK ELSE '' END) POD_REMARK" ).append("\n"); 
		query.append("       , MAX(CASE WHEN ALOC_FLAG = 'DEL' THEN BKG_ALOC_RMK ELSE '' END) DEL_REMARK" ).append("\n"); 
		query.append("       , MAX(CASE WHEN ALOC_FLAG = 'TS' THEN BKG_ALOC_RMK ELSE '' END) TS_PORT_REMARK" ).append("\n"); 
		query.append("       , MAX(CASE WHEN ALOC_FLAG = 'OTHER' THEN BKG_ALOC_RMK ELSE '' END) OTHER_REMARK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT 'E' BKG_ALOC_TP_CD, 'N' ALOC_FLAG, NULL BKG_ALOC_RMK FROM DUAL UNION ALL" ).append("\n"); 
		query.append("    SELECT 'M' BKG_ALOC_TP_CD, 'N' ALOC_FLAG, NULL BKG_ALOC_RMK FROM DUAL UNION ALL " ).append("\n"); 
		query.append("    SELECT 'E' BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("           ,CASE WHEN --BAM.POR_CD = BKG.POR_CD OR" ).append("\n"); 
		query.append("                      (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 5) LIKE '%'||BKG.POR_CD||'%' OR" ).append("\n"); 
		query.append("                      BAM.POR_NOD_CD = BKG.POR_NOD_CD OR" ).append("\n"); 
		query.append("                      BAM.BKG_POR_CNT_CD = SUBSTR(BKG.POR_CD,1,2) OR" ).append("\n"); 
		query.append("                      BAM.BKG_POR_SCC_CD = BKG.POR_SCC_CD THEN 'POR'" ).append("\n"); 
		query.append("                 WHEN --BAM.POL_CD = BKG.POL_CD OR" ).append("\n"); 
		query.append("                      (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 5) LIKE '%'||BKG.POL_CD||'%' OR" ).append("\n"); 
		query.append("                      BAM.BKG_POL_CNT_CD = SUBSTR(BKG.POL_CD,1,2) OR" ).append("\n"); 
		query.append("                      BAM.POL_NOD_CD = BKG.POL_NOD_CD THEN 'POL'" ).append("\n"); 
		query.append("                 WHEN --BAM.POD_CD = BKG.POD_CD OR" ).append("\n"); 
		query.append("                      (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 5) LIKE '%'||BKG.POD_CD||'%' OR" ).append("\n"); 
		query.append("                      BAM.BKG_POD_CNT_CD = SUBSTR(BKG.POD_CD,1,2) OR" ).append("\n"); 
		query.append("                      BAM.POD_NOD_CD = BKG.POD_NOD_CD THEN 'POD'" ).append("\n"); 
		query.append("                 WHEN --BAM.DEL_CD = BKG.DEL_CD OR" ).append("\n"); 
		query.append("                      (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 5) LIKE '%'||BKG.DEL_CD||'%' OR" ).append("\n"); 
		query.append("                      BAM.BKG_DEL_CNT_CD = SUBSTR(BKG.DEL_CD,1,2) OR" ).append("\n"); 
		query.append("                      BAM.DEL_NOD_CD = BKG.DEL_NOD_CD OR" ).append("\n"); 
		query.append("                      BKG_DEL_SCC_CD = BKG.DEL_SCC_CD THEN 'DEL'" ).append("\n"); 
		query.append("--                 WHEN BAM.N1ST_TS_POL_CD = BKG.VVD_POL_CD OR" ).append("\n"); 
		query.append("--                      BAM.N1ST_TS_POD_CD = BKG.VVD_POD_CD OR" ).append("\n"); 
		query.append("                 WHEN (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(LD.SB_LOC_CD) = 5) LIKE '%'||BKG.VVD_POL_CD||'%' OR" ).append("\n"); 
		query.append("                      (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(LD.SB_LOC_CD) = 5) LIKE '%'||BKG.VVD_POD_CD||'%' OR" ).append("\n"); 
		query.append("                      BAM.N1ST_TS_SLAN_CD = BKG.VVD_SLAN_CD OR" ).append("\n"); 
		query.append("                      BKG.VSL_PRE_PST_CD <> 'T' AND BAM.VSL_CD||BAM.SKD_VOY_NO||BAM.SKD_DIR_CD = BKG.VVD_VSL_CD||BKG.VVD_SKD_VOY_NO||BKG.VVD_SKD_DIR_CD THEN 'TS'" ).append("\n"); 
		query.append("                 WHEN BAM.TRNK_SLAN_CD = BKG.TRUNK_SLAN_CD OR" ).append("\n"); 
		query.append("                      BAM.TRNK_DIR_CD = BKG.TRUNK_SKD_DIR_CD OR" ).append("\n"); 
		query.append("                      BAM.OB_SLS_OFC_CD = BKG.OB_SLS_OFC_CD OR" ).append("\n"); 
		query.append("                      BAM.CNTR_TPSZ_CD = DECODE(BAM.CNTR_TPSZ_CD,'ALL','ALL',BKG.CNTR_TPSZ_CD) OR" ).append("\n"); 
		query.append("                      BKG.VSL_PRE_PST_CD = 'T' AND BAM.VSL_CD||BAM.SKD_VOY_NO||BAM.SKD_DIR_CD = BKG.VVD_VSL_CD||BKG.VVD_SKD_VOY_NO||BKG.VVD_SKD_DIR_CD THEN 'OTHER'" ).append("\n"); 
		query.append("                 ELSE 'N'" ).append("\n"); 
		query.append("                 END ALOC_FLAG" ).append("\n"); 
		query.append("           ,BAM.BKG_ALOC_RMK" ).append("\n"); 
		query.append("    FROM SPC_BKG_ALOC_MGMT BAM" ).append("\n"); 
		query.append("         ,(SELECT BB.SLAN_CD TRUNK_SLAN_CD" ).append("\n"); 
		query.append("                  ,BB.SKD_DIR_CD TRUNK_SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,BB.POR_CD" ).append("\n"); 
		query.append("                  ,POR_SCC.SCC_CD POR_SCC_CD" ).append("\n"); 
		query.append("                  ,BB.POR_NOD_CD" ).append("\n"); 
		query.append("                  ,BB.POL_CD" ).append("\n"); 
		query.append("                  ,BB.POL_NOD_CD" ).append("\n"); 
		query.append("                  ,BB.POD_CD" ).append("\n"); 
		query.append("                  ,BB.POD_NOD_CD" ).append("\n"); 
		query.append("                  ,BB.DEL_CD" ).append("\n"); 
		query.append("                  ,DEL_SCC.SCC_CD DEL_SCC_CD" ).append("\n"); 
		query.append("                  ,BB.DEL_NOD_CD" ).append("\n"); 
		query.append("                  ,BB.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("                  ,BB.SC_NO" ).append("\n"); 
		query.append("                  ,BB.RFA_NO" ).append("\n"); 
		query.append("                  ,BB.SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,BB.CMDT_CD" ).append("\n"); 
		query.append("                  ,BB.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                  ,BB.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("                  ,BV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                  ,BV.SLAN_CD VVD_SLAN_CD" ).append("\n"); 
		query.append("                  ,BV.VSL_CD VVD_VSL_CD" ).append("\n"); 
		query.append("                  ,BV.SKD_VOY_NO VVD_SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,BV.SKD_DIR_CD VVD_SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,BV.POL_CD VVD_POL_CD" ).append("\n"); 
		query.append("                  ,BV.POD_CD VVD_POD_CD" ).append("\n"); 
		query.append("                  ,BQ.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("                 ,BKG_QUANTITY BQ" ).append("\n"); 
		query.append("                 ,BKG_VVD BV" ).append("\n"); 
		query.append("                 ,BKG_OFC_LVL_V LVL " ).append("\n"); 
		query.append("                 ,MDM_LOCATION POR_SCC" ).append("\n"); 
		query.append("                 ,MDM_LOCATION DEL_SCC" ).append("\n"); 
		query.append("            WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND   BB.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("            AND   BV.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("            AND   BB.POR_CD = POR_SCC.LOC_CD" ).append("\n"); 
		query.append("            AND   BB.DEL_CD = DEL_SCC.LOC_CD" ).append("\n"); 
		query.append("            AND   BB.OB_SLS_OFC_CD = LVL.OFC_CD)  BKG" ).append("\n"); 
		query.append("    WHERE BAM.BKG_ALOC_TP_CD(+) = 'E'" ).append("\n"); 
		query.append("    AND   BAM.CNTR_TPSZ_CD(+) = DECODE(BAM.CNTR_TPSZ_CD(+),'ALL','ALL',BKG.CNTR_TPSZ_CD )" ).append("\n"); 
		query.append("    AND   NVL(BAM.TRNK_SLAN_CD(+),BKG.TRUNK_SLAN_CD) = BKG.TRUNK_SLAN_CD      -- T.LANE" ).append("\n"); 
		query.append("    AND   NVL(BAM.TRNK_DIR_CD(+),BKG.SKD_DIR_CD) = BKG.SKD_DIR_CD -- BD" ).append("\n"); 
		query.append("--    AND   NVL(BAM.POR_CD(+),BKG.POR_CD) = BKG.POR_CD " ).append("\n"); 
		query.append("	AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 5), BKG.POR_CD) LIKE '%'||BKG.POR_CD||'%'                      " ).append("\n"); 
		query.append("    AND   NVL(BAM.POR_NOD_CD(+),BKG.POR_NOD_CD) = BKG.POR_NOD_CD" ).append("\n"); 
		query.append("    AND   NVL(BAM.BKG_POR_SCC_CD(+),BKG.POR_SCC_CD) = BKG.POR_SCC_CD" ).append("\n"); 
		query.append("--    AND   NVL(BAM.POL_CD(+),BKG.POL_CD) = BKG.POL_CD" ).append("\n"); 
		query.append("	AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 5), BKG.POL_CD) LIKE '%'||BKG.POL_CD||'%'                      " ).append("\n"); 
		query.append("    AND   NVL(BAM.POD_NOD_CD(+),BKG.POD_NOD_CD) = BKG.POD_NOD_CD" ).append("\n"); 
		query.append("--    AND   NVL(BAM.POD_CD(+),BKG.POD_CD) = BKG.POD_CD" ).append("\n"); 
		query.append("	AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 5), BKG.POD_CD) LIKE '%'||BKG.POD_CD||'%'                      " ).append("\n"); 
		query.append("    AND   NVL(BAM.POD_NOD_CD(+),BKG.POD_NOD_CD) = BKG.POD_NOD_CD" ).append("\n"); 
		query.append("--    AND   NVL(BAM.DEL_CD(+),BKG.DEL_CD) = BKG.DEL_CD" ).append("\n"); 
		query.append("	AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 5), BKG.DEL_CD) LIKE '%'||BKG.DEL_CD||'%'                      " ).append("\n"); 
		query.append("    AND   NVL(BAM.DEL_NOD_CD(+),BKG.DEL_NOD_CD) = BKG.DEL_NOD_CD" ).append("\n"); 
		query.append("--    AND   NVL(BAM.N1ST_TS_POL_CD(+),BKG.VVD_POL_CD) = BKG.VVD_POL_CD" ).append("\n"); 
		query.append("--    AND   NVL(BAM.N1ST_TS_POD_CD(+),BKG.VVD_POD_CD) = BKG.VVD_POD_CD" ).append("\n"); 
		query.append("    AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(LD.SB_LOC_CD) = 5),BKG.VVD_POL_CD) = BKG.VVD_POL_CD" ).append("\n"); 
		query.append("    AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(LD.SB_LOC_CD) = 5),BKG.VVD_POD_CD) = BKG.VVD_POD_CD" ).append("\n"); 
		query.append("    AND   NVL(BAM.N1ST_TS_SLAN_CD(+),BKG.VVD_SLAN_CD) = BKG.VVD_SLAN_CD" ).append("\n"); 
		query.append("    AND   NVL(BAM.BKG_DEL_SCC_CD(+),BKG.DEL_SCC_CD) = BKG.DEL_SCC_CD" ).append("\n"); 
		query.append("    AND   NVL(BAM.OB_SLS_OFC_CD(+),BKG.OB_SLS_OFC_CD) = BKG.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("    AND   NVL(BAM.VSL_CD(+),BKG.VVD_VSL_CD) = BKG.VVD_VSL_CD" ).append("\n"); 
		query.append("    AND   NVL(BAM.SKD_VOY_NO(+),BKG.VVD_SKD_VOY_NO) = BKG.VVD_SKD_VOY_NO" ).append("\n"); 
		query.append("    AND   NVL(BAM.SKD_DIR_CD(+),BKG.VVD_SKD_DIR_CD) = BKG.VVD_SKD_DIR_CD " ).append("\n"); 
		query.append("--    AND   NVL(BAM.BKG_POR_CNT_CD(+),SUBSTR(BKG.POR_CD,1,2)) = SUBSTR(BKG.POR_CD,1,2)" ).append("\n"); 
		query.append("--    AND   NVL(BAM.BKG_POL_CNT_CD(+),SUBSTR(BKG.POL_CD,1,2)) = SUBSTR(BKG.POL_CD,1,2)" ).append("\n"); 
		query.append("--    AND   NVL(BAM.BKG_POD_CNT_CD(+),SUBSTR(BKG.POD_CD,1,2)) = SUBSTR(BKG.POD_CD,1,2)" ).append("\n"); 
		query.append("--    AND   NVL(BAM.BKG_DEL_CNT_CD(+),SUBSTR(BKG.DEL_CD,1,2)) = SUBSTR(BKG.DEL_CD,1,2) " ).append("\n"); 
		query.append("    AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.POR_CD,1,2)) LIKE '%'||SUBSTR(BKG.POR_CD,1,2)||'%'" ).append("\n"); 
		query.append("    AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.POL_CD,1,2)) LIKE '%'||SUBSTR(BKG.POL_CD,1,2)||'%'" ).append("\n"); 
		query.append("    AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.POD_CD,1,2)) LIKE '%'||SUBSTR(BKG.POD_CD,1,2)||'%'" ).append("\n"); 
		query.append("    AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.DEL_CD,1,2)) LIKE '%'||SUBSTR(BKG.DEL_CD,1,2)||'%'			  " ).append("\n"); 
		query.append("    AND BAM.SLS_RHQ_CD(+) = 'NYCRA'" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'M'" ).append("\n"); 
		query.append("           ,CASE WHEN --BAM.POR_CD = BKG.POR_CD OR" ).append("\n"); 
		query.append("                      (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 5) LIKE '%'||BKG.POR_CD||'%' OR" ).append("\n"); 
		query.append("                      BAM.POR_NOD_CD = BKG.POR_NOD_CD OR" ).append("\n"); 
		query.append("                      BAM.BKG_POR_CNT_CD = SUBSTR(BKG.POR_CD,1,2) OR" ).append("\n"); 
		query.append("                      BAM.BKG_POR_SCC_CD = BKG.POR_SCC_CD THEN 'POR'" ).append("\n"); 
		query.append("                 WHEN --BAM.POL_CD = BKG.POL_CD OR" ).append("\n"); 
		query.append("                      (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 5) LIKE '%'||BKG.POL_CD||'%' OR" ).append("\n"); 
		query.append("                      BAM.BKG_POL_CNT_CD = SUBSTR(BKG.POL_CD,1,2) OR" ).append("\n"); 
		query.append("                      BAM.POL_NOD_CD = BKG.POL_NOD_CD THEN 'POL'" ).append("\n"); 
		query.append("                 WHEN --BAM.POD_CD = BKG.POD_CD OR" ).append("\n"); 
		query.append("                      (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 5) LIKE '%'||BKG.POD_CD||'%' OR" ).append("\n"); 
		query.append("                      BAM.BKG_POD_CNT_CD = SUBSTR(BKG.POD_CD,1,2) OR" ).append("\n"); 
		query.append("                      BAM.POD_NOD_CD = BKG.POD_NOD_CD THEN 'POD'" ).append("\n"); 
		query.append("                 WHEN --BAM.DEL_CD = BKG.DEL_CD OR" ).append("\n"); 
		query.append("                      (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 5) LIKE '%'||BKG.DEL_CD||'%' OR" ).append("\n"); 
		query.append("                      BAM.BKG_DEL_CNT_CD = SUBSTR(BKG.DEL_CD,1,2) OR" ).append("\n"); 
		query.append("                      BAM.DEL_NOD_CD = BKG.DEL_NOD_CD OR" ).append("\n"); 
		query.append("                      BKG_DEL_SCC_CD = BKG.DEL_SCC_CD THEN 'DEL'" ).append("\n"); 
		query.append("--                 WHEN --BAM.N1ST_TS_POL_CD = BKG.VVD_POL_CD OR" ).append("\n"); 
		query.append("----                      BAM.N1ST_TS_POD_CD = BKG.VVD_POD_CD OR" ).append("\n"); 
		query.append("                 WHEN (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(LD.SB_LOC_CD) = 5) LIKE '%'||BKG.VVD_POL_CD||'%' OR" ).append("\n"); 
		query.append("                      (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(LD.SB_LOC_CD) = 5) LIKE '%'||BKG.VVD_POD_CD||'%' OR" ).append("\n"); 
		query.append("                      BAM.N1ST_TS_SLAN_CD = BKG.VVD_SLAN_CD OR" ).append("\n"); 
		query.append("                      BKG.VSL_PRE_PST_CD <> 'T' AND BAM.VSL_CD||BAM.SKD_VOY_NO||BAM.SKD_DIR_CD = BKG.VVD_VSL_CD||BKG.VVD_SKD_VOY_NO||BKG.VVD_SKD_DIR_CD THEN 'TS'" ).append("\n"); 
		query.append("                 WHEN BAM.TRNK_SLAN_CD = BKG.TRUNK_SLAN_CD OR" ).append("\n"); 
		query.append("                      BAM.TRNK_DIR_CD = BKG.TRUNK_SKD_DIR_CD OR" ).append("\n"); 
		query.append("                      BAM.OB_SLS_OFC_CD = BKG.OB_SLS_OFC_CD OR" ).append("\n"); 
		query.append("                      BAM.CNTR_TPSZ_CD = BKG.CNTR_TPSZ_CD OR" ).append("\n"); 
		query.append("--                      BAM.CMDT_CD = BKG.CMDT_CD OR " ).append("\n"); 
		query.append("                      (SELECT WM_CONCAT(CMDT.CMDT_CD) FROM SPC_BKG_ALOC_MGMT_CMDT_DTL CMDT WHERE CMDT.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ) LIKE '%'||BKG.CMDT_CD||'%' OR" ).append("\n"); 
		query.append("                      BAM.SCG_GRP_CMDT_SEQ = BKG.GRP_CMDT_CD OR " ).append("\n"); 
		query.append("                      BKG.VSL_PRE_PST_CD = 'T' AND BAM.VSL_CD||BAM.SKD_VOY_NO||BAM.SKD_DIR_CD = BKG.VVD_VSL_CD||BKG.VVD_SKD_VOY_NO||BKG.VVD_SKD_DIR_CD THEN 'OTHER'" ).append("\n"); 
		query.append("                 ELSE 'N'" ).append("\n"); 
		query.append("                 END ALOC_FLAG" ).append("\n"); 
		query.append("           ,BAM.BKG_ALOC_RMK" ).append("\n"); 
		query.append("    FROM SPC_BKG_ALOC_MGMT BAM" ).append("\n"); 
		query.append("         ,(SELECT BB.SLAN_CD TRUNK_SLAN_CD" ).append("\n"); 
		query.append("                  ,BB.SKD_DIR_CD TRUNK_SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,BB.POR_CD" ).append("\n"); 
		query.append("                  ,POR_SCC.SCC_CD POR_SCC_CD" ).append("\n"); 
		query.append("                  ,BB.POR_NOD_CD" ).append("\n"); 
		query.append("                  ,BB.POL_CD" ).append("\n"); 
		query.append("                  ,BB.POL_NOD_CD" ).append("\n"); 
		query.append("                  ,BB.POD_CD" ).append("\n"); 
		query.append("                  ,BB.POD_NOD_CD" ).append("\n"); 
		query.append("                  ,BB.DEL_CD" ).append("\n"); 
		query.append("                  ,DEL_SCC.SCC_CD DEL_SCC_CD" ).append("\n"); 
		query.append("                  ,BB.DEL_NOD_CD" ).append("\n"); 
		query.append("                  ,BB.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("                  ,BB.SC_NO" ).append("\n"); 
		query.append("                  ,BB.RFA_NO" ).append("\n"); 
		query.append("                  ,BB.SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,BB.CMDT_CD" ).append("\n"); 
		query.append("                  ,BB.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                  ,BB.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("                  ,BV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                  ,BV.SLAN_CD VVD_SLAN_CD" ).append("\n"); 
		query.append("                  ,BV.VSL_CD VVD_VSL_CD" ).append("\n"); 
		query.append("                  ,BV.SKD_VOY_NO VVD_SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,BV.SKD_DIR_CD VVD_SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,BV.POL_CD VVD_POL_CD" ).append("\n"); 
		query.append("                  ,BV.POD_CD VVD_POD_CD" ).append("\n"); 
		query.append("                  ,BQ.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  ,NVL((SELECT PSC.SCG_GRP_CMDT_SEQ" ).append("\n"); 
		query.append("                      FROM PRI_SCG_GRP_CMDT_DTL PSC" ).append("\n"); 
		query.append("                     WHERE PSC.SVC_SCP_CD = 'TPW'" ).append("\n"); 
		query.append("                       AND PSC.CHG_CD = 'GRI'" ).append("\n"); 
		query.append("                       AND PSC.CMDT_CD = BB.CMDT_CD" ).append("\n"); 
		query.append("                       AND ROWNUM = 1),9999) GRP_CMDT_CD" ).append("\n"); 
		query.append("             FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("                 ,BKG_QUANTITY BQ" ).append("\n"); 
		query.append("                 ,BKG_VVD BV" ).append("\n"); 
		query.append("                 ,BKG_OFC_LVL_V LVL " ).append("\n"); 
		query.append("                 ,MDM_LOCATION POR_SCC" ).append("\n"); 
		query.append("                 ,MDM_LOCATION DEL_SCC" ).append("\n"); 
		query.append("            WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND   BB.BKG_NO = BQ.BKG_NO" ).append("\n"); 
		query.append("            AND   BV.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("            AND   BB.POR_CD = POR_SCC.LOC_CD" ).append("\n"); 
		query.append("            AND   BB.DEL_CD = DEL_SCC.LOC_CD" ).append("\n"); 
		query.append("            AND   BB.OB_SLS_OFC_CD = LVL.OFC_CD)  BKG" ).append("\n"); 
		query.append("    WHERE BAM.BKG_ALOC_TP_CD(+) = 'M'" ).append("\n"); 
		query.append("--    AND   NVL(BAM.CMDT_CD(+),BKG.CMDT_CD) = BKG.CMDT_CD" ).append("\n"); 
		query.append("    AND   NVL((SELECT WM_CONCAT(CMDT.CMDT_CD) FROM SPC_BKG_ALOC_MGMT_CMDT_DTL CMDT WHERE CMDT.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ),BKG.CMDT_CD) LIKE '%'||BKG.CMDT_CD||'%'" ).append("\n"); 
		query.append("    AND   NVL(BAM.SCG_GRP_CMDT_SEQ(+),BKG.GRP_CMDT_CD) = BKG.GRP_CMDT_CD" ).append("\n"); 
		query.append("    AND   NVL(BAM.TRNK_SLAN_CD(+),BKG.TRUNK_SLAN_CD) = BKG.TRUNK_SLAN_CD      -- T.LANE" ).append("\n"); 
		query.append("    AND   NVL(BAM.TRNK_DIR_CD(+),BKG.SKD_DIR_CD) = BKG.SKD_DIR_CD -- BD" ).append("\n"); 
		query.append("--    AND   NVL(BAM.POR_CD(+),BKG.POR_CD) = BKG.POR_CD " ).append("\n"); 
		query.append("    AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 5), BKG.POR_CD) LIKE '%'||BKG.POR_CD||'%'" ).append("\n"); 
		query.append("    AND   NVL(BAM.POR_NOD_CD(+),BKG.POR_NOD_CD) = BKG.POR_NOD_CD" ).append("\n"); 
		query.append("    AND   NVL(BAM.BKG_POR_SCC_CD(+),BKG.POR_SCC_CD) = BKG.POR_SCC_CD" ).append("\n"); 
		query.append("--    AND   NVL(BAM.POL_CD(+),BKG.POL_CD) = BKG.POL_CD" ).append("\n"); 
		query.append("    AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 5), BKG.POL_CD) LIKE '%'||BKG.POL_CD||'%'" ).append("\n"); 
		query.append("    AND   NVL(BAM.POD_NOD_CD(+),BKG.POD_NOD_CD) = BKG.POD_NOD_CD" ).append("\n"); 
		query.append("--    AND   NVL(BAM.POD_CD(+),BKG.POD_CD) = BKG.POD_CD" ).append("\n"); 
		query.append("    AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 5), BKG.POD_CD) LIKE '%'||BKG.POD_CD||'%'" ).append("\n"); 
		query.append("    AND   NVL(BAM.POD_NOD_CD(+),BKG.POD_NOD_CD) = BKG.POD_NOD_CD" ).append("\n"); 
		query.append("--    AND   NVL(BAM.DEL_CD(+),BKG.DEL_CD) = BKG.DEL_CD" ).append("\n"); 
		query.append("    AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 5), BKG.DEL_CD) LIKE '%'||BKG.DEL_CD||'%'" ).append("\n"); 
		query.append("    AND   NVL(BAM.DEL_NOD_CD(+),BKG.DEL_NOD_CD) = BKG.DEL_NOD_CD" ).append("\n"); 
		query.append("--    AND   NVL(BAM.N1ST_TS_POL_CD(+),BKG.VVD_POL_CD) = BKG.VVD_POL_CD" ).append("\n"); 
		query.append("--    AND   NVL(BAM.N1ST_TS_POD_CD(+),BKG.VVD_POD_CD) = BKG.VVD_POD_CD" ).append("\n"); 
		query.append("    AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(LD.SB_LOC_CD) = 5), BKG.VVD_POL_CD) LIKE '%'||BKG.VVD_POL_CD||'%'" ).append("\n"); 
		query.append("    AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(LD.SB_LOC_CD) = 5), BKG.VVD_POD_CD) LIKE '%'||BKG.VVD_POD_CD||'%'" ).append("\n"); 
		query.append("    AND   NVL(BAM.N1ST_TS_SLAN_CD(+),BKG.VVD_SLAN_CD) = BKG.VVD_SLAN_CD" ).append("\n"); 
		query.append("    AND   NVL(BAM.BKG_DEL_SCC_CD(+),BKG.DEL_SCC_CD) = BKG.DEL_SCC_CD" ).append("\n"); 
		query.append("    AND   NVL(BAM.OB_SLS_OFC_CD(+),BKG.OB_SLS_OFC_CD) = BKG.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("    AND   NVL(BAM.CNTR_TPSZ_CD(+),BKG.CNTR_TPSZ_CD) = BKG.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    AND   NVL(BAM.VSL_CD(+),BKG.VVD_VSL_CD) = BKG.VVD_VSL_CD" ).append("\n"); 
		query.append("    AND   NVL(BAM.SKD_VOY_NO(+),BKG.VVD_SKD_VOY_NO) = BKG.VVD_SKD_VOY_NO" ).append("\n"); 
		query.append("    AND   NVL(BAM.SKD_DIR_CD(+),BKG.VVD_SKD_DIR_CD) = BKG.VVD_SKD_DIR_CD " ).append("\n"); 
		query.append("--    AND   NVL(BAM.BKG_POR_CNT_CD(+),SUBSTR(BKG.POR_CD,1,2)) = SUBSTR(BKG.POR_CD,1,2)" ).append("\n"); 
		query.append("--    AND   NVL(BAM.BKG_POL_CNT_CD(+),SUBSTR(BKG.POL_CD,1,2)) = SUBSTR(BKG.POL_CD,1,2)" ).append("\n"); 
		query.append("--    AND   NVL(BAM.BKG_POD_CNT_CD(+),SUBSTR(BKG.POD_CD,1,2)) = SUBSTR(BKG.POD_CD,1,2)" ).append("\n"); 
		query.append("--    AND   NVL(BAM.BKG_DEL_CNT_CD(+),SUBSTR(BKG.DEL_CD,1,2)) = SUBSTR(BKG.DEL_CD,1,2) " ).append("\n"); 
		query.append("    AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.POR_CD,1,2)) LIKE '%'||SUBSTR(BKG.POR_CD,1,2)||'%' " ).append("\n"); 
		query.append("    AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.POL_CD,1,2)) LIKE '%'||SUBSTR(BKG.POL_CD,1,2)||'%' " ).append("\n"); 
		query.append("    AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.POD_CD,1,2)) LIKE '%'||SUBSTR(BKG.POD_CD,1,2)||'%' " ).append("\n"); 
		query.append("    AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.DEL_CD,1,2)) LIKE '%'||SUBSTR(BKG.DEL_CD,1,2)||'%' " ).append("\n"); 
		query.append("    AND BAM.SLS_RHQ_CD(+) = 'NYCRA'" ).append("\n"); 
		query.append(") TT" ).append("\n"); 
		query.append("GROUP BY BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("ORDER BY BKG_ALOC_TP_CD" ).append("\n"); 

	}
}