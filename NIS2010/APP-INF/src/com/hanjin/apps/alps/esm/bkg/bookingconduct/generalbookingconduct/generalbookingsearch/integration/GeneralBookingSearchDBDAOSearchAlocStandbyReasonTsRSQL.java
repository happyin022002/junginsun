/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchAlocStandbyReasonTsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.16 
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

public class GeneralBookingSearchDBDAOSearchAlocStandbyReasonTsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Allocation Stand by Reason 의 T/S VVD BKG Status vs. Allocation 을 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchAlocStandbyReasonTsRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOSearchAlocStandbyReasonTsRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("WITH MST AS (" ).append("\n"); 
		query.append("    SELECT MT.BKG_ALOC_SEQ        " ).append("\n"); 
		query.append("         , MT.BKG_ALOC_TP_CD  " ).append("\n"); 
		query.append("         , MT.ALOC_SVC_CD" ).append("\n"); 
		query.append("         , MT.TRNK_SLAN_CD        " ).append("\n"); 
		query.append("         , MT.TRNK_DIR_CD        " ).append("\n"); 
		query.append("         , MT.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 2) POR_CNT_CD " ).append("\n"); 
		query.append("         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 5) POR_CD        " ).append("\n"); 
		query.append("         , MT.POR_NOD_CD        " ).append("\n"); 
		query.append("         , MT.BKG_POR_SCC_CD        " ).append("\n"); 
		query.append("         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 2) POL_CNT_CD  " ).append("\n"); 
		query.append("         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 5) POL_CD        " ).append("\n"); 
		query.append("         , MT.POL_NOD_CD              " ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         -- [2015.10.23] T/S PORT, T/S POL NODE, T/S POD NODE" ).append("\n"); 
		query.append("         , CASE WHEN (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' ) IS NOT NULL" ).append("\n"); 
		query.append("                THEN NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' AND LENGTH(LD.SB_LOC_CD) = 5 ), 'XXXXXXXX') " ).append("\n"); 
		query.append("                ELSE NULL END AS TS_ALL_LOC_CD                      " ).append("\n"); 
		query.append("         , CASE WHEN (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' ) IS NOT NULL" ).append("\n"); 
		query.append("                THEN NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' AND LENGTH(LD.SB_LOC_CD) = 7 ), 'XXXXXXXX') " ).append("\n"); 
		query.append("                ELSE NULL END AS TS_ALL_NOD_CD                                           " ).append("\n"); 
		query.append("         , MT.N1ST_TS_SLAN_CD" ).append("\n"); 
		query.append("         , MT.N1ST_TS_DIR_CD" ).append("\n"); 
		query.append("         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(LD.SB_LOC_CD) = 2) N1ST_TS_POL_CNT_CD        " ).append("\n"); 
		query.append("         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(LD.SB_LOC_CD) = 5) N1ST_TS_POL_CD  " ).append("\n"); 
		query.append("         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SLY' ) TS_POL_NOD_CD    " ).append("\n"); 
		query.append("         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(LD.SB_LOC_CD) = 2) N1ST_TS_POD_CNT_CD  " ).append("\n"); 
		query.append("         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(LD.SB_LOC_CD) = 5) N1ST_TS_POD_CD " ).append("\n"); 
		query.append("         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SDY') TS_POD_NOD_CD " ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 2) POD_CNT_CD" ).append("\n"); 
		query.append("         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 5) POD_CD        " ).append("\n"); 
		query.append("         , MT.POD_NOD_CD        " ).append("\n"); 
		query.append("         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 2) DEL_CNT_CD " ).append("\n"); 
		query.append("         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 5) DEL_CD        " ).append("\n"); 
		query.append("         , MT.DEL_NOD_CD        " ).append("\n"); 
		query.append("         , MT.BKG_DEL_SCC_CD        " ).append("\n"); 
		query.append("         , MT.SC_NO        " ).append("\n"); 
		query.append("         , MT.RFA_NO        " ).append("\n"); 
		query.append("         , MT.CTRT_CUST_CNT_CD        " ).append("\n"); 
		query.append("         , MT.CTRT_CUST_SEQ        " ).append("\n"); 
		query.append("         , MT.CUST_CNT_CD        " ).append("\n"); 
		query.append("         , MT.CUST_SEQ     " ).append("\n"); 
		query.append("         , (SELECT WM_CONCAT(LD.CNTR_TPSZ_CD) FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ) CNTR_TPSZ_CD        " ).append("\n"); 
		query.append("         , (SELECT WM_CONCAT(CMDT.CMDT_CD) FROM SPC_BKG_ALOC_MGMT_CMDT_DTL CMDT WHERE CMDT.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ) CMDT_CD        " ).append("\n"); 
		query.append("         , NVL(MT.ALOC_LOD_QTY, 0) ALOC_LOD_QTY" ).append("\n"); 
		query.append("         , NVL(MT.ALOC_LOD_QTY_RTO,100) ALOC_LOD_QTY_RTO   " ).append("\n"); 
		query.append("         , MT.VSL_CD        " ).append("\n"); 
		query.append("         , MT.SKD_VOY_NO        " ).append("\n"); 
		query.append("         , MT.SKD_DIR_CD        " ).append("\n"); 
		query.append("         , MT.SLS_RHQ_CD        " ).append("\n"); 
		query.append("         , MT.SCG_GRP_CMDT_SEQ          " ).append("\n"); 
		query.append("         , NVL(MT.CMPB_AMT, 0) CMPB_AMT " ).append("\n"); 
		query.append("         , MT.BKG_CTRL_TP_CD        " ).append("\n"); 
		query.append("         , MT.DCGO_FLG        " ).append("\n"); 
		query.append("         , MT.RD_CGO_FLG        " ).append("\n"); 
		query.append("         , MT.CRE_USR_ID        " ).append("\n"); 
		query.append("         , MT.CRE_DT        " ).append("\n"); 
		query.append("         , MT.UPD_USR_ID        " ).append("\n"); 
		query.append("         , MT.UPD_DT        " ).append("\n"); 
		query.append("         , MT.ALOC_APLY_FM_DT        " ).append("\n"); 
		query.append("         , MT.ALOC_APLY_TO_DT        " ).append("\n"); 
		query.append("         , MT.SUB_TRD_CD        " ).append("\n"); 
		query.append("         , MT.OFT_CHG_AMT        " ).append("\n"); 
		query.append("         , MT.RAPLY_CFM_FLG               " ).append("\n"); 
		query.append("         , MT.HUL_BND_CD" ).append("\n"); 
		query.append("         , ASGN_TTL_WGT" ).append("\n"); 
		query.append("         , NVL(MT.ASGN_WGT_RTO, 100) ASGN_WGT_RTO        " ).append("\n"); 
		query.append("         , CMPB_ONY_FLG                                 " ).append("\n"); 
		query.append("         , RVIS_CNTR_CUST_TP_CD						         " ).append("\n"); 
		query.append("         , NVL(MT.OP_CNTR_QTY, 0) AS CNTR_QTY " ).append("\n"); 
		query.append("         , MT.BKG_ALOC_RMK            " ).append("\n"); 
		query.append("    FROM  SPC_BKG_ALOC_MGMT MT      " ).append("\n"); 
		query.append("    WHERE MT.BKG_ALOC_TP_CD = 'S' " ).append("\n"); 
		query.append("    AND  MT.BKG_CTRL_TP_CD = 'S'" ).append("\n"); 
		query.append("    AND (MT.ALOC_USE_FLG IS NULL OR  MT.ALOC_USE_FLG = 'Y')        " ).append("\n"); 
		query.append("    AND MT.SLS_RHQ_CD = 'NYCRA'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", BKG AS (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" SELECT MB.VVD_SEQ" ).append("\n"); 
		query.append("      , MB.TRNK_SLAN_CD" ).append("\n"); 
		query.append("      , MB.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("      , MB.POR_CNT_CD" ).append("\n"); 
		query.append("      , MB.POR_CD" ).append("\n"); 
		query.append("      , MB.POR_SCC_CD" ).append("\n"); 
		query.append("      , MB.POR_NOD_CD" ).append("\n"); 
		query.append("      , MB.POL_CNT_CD" ).append("\n"); 
		query.append("      , MB.POL_CD" ).append("\n"); 
		query.append("      , MB.POL_NOD_CD" ).append("\n"); 
		query.append("      , MB.POD_CNT_CD" ).append("\n"); 
		query.append("      , MB.POD_CD" ).append("\n"); 
		query.append("      , MB.POD_NOD_CD" ).append("\n"); 
		query.append("      , MB.DEL_CNT_CD" ).append("\n"); 
		query.append("      , MB.DEL_CD" ).append("\n"); 
		query.append("      , MB.DEL_SCC_CD" ).append("\n"); 
		query.append("      , MB.DEL_NOD_CD" ).append("\n"); 
		query.append("      , MB.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("      , MB.SKD_DIR_CD" ).append("\n"); 
		query.append("      , MB.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("      , MB.VSL_SEQ" ).append("\n"); 
		query.append("      , MB.VVD_SLAN_CD" ).append("\n"); 
		query.append("      , MB.VVD_VSL_CD" ).append("\n"); 
		query.append("      , MB.VVD_SKD_VOY_NO" ).append("\n"); 
		query.append("      , MB.VVD_SKD_DIR_CD" ).append("\n"); 
		query.append("      , MB.VVD_VSL_CD||MB.VVD_SKD_VOY_NO||MB.VVD_SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      , MB.VVD_POL_CD" ).append("\n"); 
		query.append("      , MB.VVD_POL_NOD_CD" ).append("\n"); 
		query.append("      , MB.VVD_POD_CD" ).append("\n"); 
		query.append("      , MB.VVD_POD_NOD_CD" ).append("\n"); 
		query.append("      , MB.BKG_NO" ).append("\n"); 
		query.append("      , MB.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 1, NULL)) AS TS_POL_CNT_CD1" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 1, NULL)) AS TS_POL_CD1" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 1, NULL)) AS TS_POL_NOD_CD1" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 2, TS_POL_CNT_CD)) AS TS_POD_CNT_CD1" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 2, TS_POL_CD)) AS TS_POD_CD1" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 2, TS_POL_YD_CD)) AS TS_POD_NOD_CD1" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 2, TS_POL_CNT_CD)) AS TS_POL_CNT_CD2" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 2, TS_POL_CD)) AS TS_POL_CD2" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 2, TS_POL_YD_CD)) AS TS_POL_NOD_CD2" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 3, TS_POL_CNT_CD)) AS TS_POD_CNT_CD2" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 3, TS_POL_CD)) AS TS_POD_CD2" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 3, TS_POL_YD_CD)) AS TS_POD_NOD_CD2" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 3, TS_POL_CNT_CD)) AS TS_POL_CNT_CD3" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 3, TS_POL_CD)) AS TS_POL_CD3" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 3, TS_POL_YD_CD)) AS TS_POL_NOD_CD3" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 4, TS_POL_CNT_CD)) AS TS_POD_CNT_CD3" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 4, TS_POL_CD)) AS TS_POD_CD3" ).append("\n"); 
		query.append("      , MAX(DECODE(RK, 4, TS_POL_YD_CD)) AS TS_POD_NOD_CD3" ).append("\n"); 
		query.append("      , (SELECT SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY) FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("          WHERE Q.BKG_NO = MB.BKG_NO ) AS BKG_LOD_QTY --TEU(Load)" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("        SELECT (SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                  WHERE INTG_CD_ID = 'CD01233'" ).append("\n"); 
		query.append("                    AND INTG_CD_VAL_CTNT = BV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                    AND ROWNUM = 1 )||' '||BV.VSL_SEQ AS VVD_SEQ" ).append("\n"); 
		query.append("              , BB.SLAN_CD AS TRNK_SLAN_CD" ).append("\n"); 
		query.append("              , BB.SKD_DIR_CD AS TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("              , SUBSTR(BB.POR_CD, 1, 2) AS POR_CNT_CD" ).append("\n"); 
		query.append("              , BB.POR_CD" ).append("\n"); 
		query.append("              , (SELECT SCC_CD FROM MDM_LOCATION WHERE LOC_CD = BB.POR_CD ) AS POR_SCC_CD" ).append("\n"); 
		query.append("              , BB.POR_NOD_CD" ).append("\n"); 
		query.append("              , SUBSTR(BB.POL_CD, 1, 2) AS POL_CNT_CD" ).append("\n"); 
		query.append("              , BB.POL_CD" ).append("\n"); 
		query.append("              , BB.POL_NOD_CD" ).append("\n"); 
		query.append("              , SUBSTR(BB.POD_CD, 1, 2) AS POD_CNT_CD" ).append("\n"); 
		query.append("              , BB.POD_CD" ).append("\n"); 
		query.append("              , BB.POD_NOD_CD" ).append("\n"); 
		query.append("              , SUBSTR(BB.DEL_CD, 1, 2) AS DEL_CNT_CD" ).append("\n"); 
		query.append("              , BB.DEL_CD" ).append("\n"); 
		query.append("              , (SELECT SCC_CD FROM MDM_LOCATION WHERE LOC_CD = BB.DEL_CD ) AS DEL_SCC_CD" ).append("\n"); 
		query.append("              , BB.DEL_NOD_CD" ).append("\n"); 
		query.append("              , BB.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("              , BB.SC_NO" ).append("\n"); 
		query.append("              , BB.RFA_NO" ).append("\n"); 
		query.append("              , BB.SKD_DIR_CD" ).append("\n"); 
		query.append("              , BB.CMDT_CD" ).append("\n"); 
		query.append("              , BB.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("              , BB.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("              , BV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("              , BV.VSL_SEQ" ).append("\n"); 
		query.append("              , BV.SLAN_CD VVD_SLAN_CD" ).append("\n"); 
		query.append("              , BV.VSL_CD VVD_VSL_CD" ).append("\n"); 
		query.append("              , BV.SKD_VOY_NO VVD_SKD_VOY_NO" ).append("\n"); 
		query.append("              , BV.SKD_DIR_CD VVD_SKD_DIR_CD" ).append("\n"); 
		query.append("              , BV.POL_CD VVD_POL_CD" ).append("\n"); 
		query.append("              , BV.POL_YD_CD VVD_POL_NOD_CD" ).append("\n"); 
		query.append("              , BV.POD_CD VVD_POD_CD" ).append("\n"); 
		query.append("              , BV.POD_YD_CD VVD_POD_NOD_CD" ).append("\n"); 
		query.append("              , BB.BKG_NO" ).append("\n"); 
		query.append("              , BB.AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append("              , BB.AGMT_ACT_CUST_SEQ" ).append("\n"); 
		query.append("              , DENSE_RANK() OVER ( PARTITION BY TV.BKG_NO ORDER BY TV.VSL_PRE_PST_CD, TV.VSL_SEQ) AS RK" ).append("\n"); 
		query.append("              , TV.POL_CD TS_POL_CD" ).append("\n"); 
		query.append("              , TV.POL_YD_CD TS_POL_YD_CD" ).append("\n"); 
		query.append("              , TV.POD_CD TS_POD_CD" ).append("\n"); 
		query.append("              , TV.POD_YD_CD TS_POD_YD_CD" ).append("\n"); 
		query.append("              , SUBSTR(TV.POL_CD, 1, 2) AS TS_POL_CNT_CD" ).append("\n"); 
		query.append("              , SUBSTR(TV.POD_CD, 1, 2) AS TS_POD_CNT_CD" ).append("\n"); 
		query.append("              , LVL.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("           FROM BKG_VVD MV -- in_bkg_no" ).append("\n"); 
		query.append("              , BKG_VVD BV -- in_bkg_no의 SLAN||VVD 에 해당하는 BKG" ).append("\n"); 
		query.append("              , BKG_VVD TV -- T/S 를 구하기 위한 BKG" ).append("\n"); 
		query.append("              , BKG_BOOKING BB" ).append("\n"); 
		query.append("              , BKG_OFC_LVL_V LVL" ).append("\n"); 
		query.append("          WHERE MV.BKG_NO                 = @[bkg_no]" ).append("\n"); 
		query.append("            AND MV.VSL_PRE_PST_CD        <> 'T'" ).append("\n"); 
		query.append("            AND BV.BKG_NO                 = BB.BKG_NO" ).append("\n"); 
		query.append("            AND BB.BKG_NO                 = TV.BKG_NO" ).append("\n"); 
		query.append("            AND BB.BKG_STS_CD            <> 'X'" ).append("\n"); 
		query.append("            AND BB.BKG_CGO_TP_CD          = 'F'" ).append("\n"); 
		query.append("            AND (NVL(BB.ALOC_STS_CD, 'X') = 'F' OR BB.BKG_NO = MV.BKG_NO)" ).append("\n"); 
		query.append("            AND BV.VSL_PRE_PST_CD        <> 'T'" ).append("\n"); 
		query.append("            AND BV.SLAN_CD                = MV.SLAN_CD" ).append("\n"); 
		query.append("            AND BV.VSL_CD                 = MV.VSL_CD" ).append("\n"); 
		query.append("            AND BV.SKD_VOY_NO             = MV.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND BV.SKD_DIR_CD             = MV.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND BB.OB_SLS_OFC_CD          = LVL.OFC_CD" ).append("\n"); 
		query.append("        ) MB" ).append("\n"); 
		query.append("GROUP BY MB.VVD_SEQ" ).append("\n"); 
		query.append("      , MB.TRNK_SLAN_CD" ).append("\n"); 
		query.append("      , MB.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("      , MB.POR_CNT_CD" ).append("\n"); 
		query.append("      , MB.POR_CD" ).append("\n"); 
		query.append("      , MB.POR_SCC_CD" ).append("\n"); 
		query.append("      , MB.POR_NOD_CD" ).append("\n"); 
		query.append("      , MB.POL_CNT_CD" ).append("\n"); 
		query.append("      , MB.POL_CD" ).append("\n"); 
		query.append("      , MB.POL_NOD_CD" ).append("\n"); 
		query.append("      , MB.POD_CNT_CD" ).append("\n"); 
		query.append("      , MB.POD_CD" ).append("\n"); 
		query.append("      , MB.POD_NOD_CD" ).append("\n"); 
		query.append("      , MB.DEL_CNT_CD" ).append("\n"); 
		query.append("      , MB.DEL_CD" ).append("\n"); 
		query.append("      , MB.DEL_SCC_CD" ).append("\n"); 
		query.append("      , MB.DEL_NOD_CD" ).append("\n"); 
		query.append("      , MB.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("      , MB.SKD_DIR_CD" ).append("\n"); 
		query.append("      , MB.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("      , MB.VSL_SEQ" ).append("\n"); 
		query.append("      , MB.VVD_SLAN_CD" ).append("\n"); 
		query.append("      , MB.VVD_VSL_CD" ).append("\n"); 
		query.append("      , MB.VVD_SKD_VOY_NO" ).append("\n"); 
		query.append("      , MB.VVD_SKD_DIR_CD" ).append("\n"); 
		query.append("      , MB.VVD_POL_CD" ).append("\n"); 
		query.append("      , MB.VVD_POL_NOD_CD" ).append("\n"); 
		query.append("      , MB.VVD_POD_CD" ).append("\n"); 
		query.append("      , MB.VVD_POD_NOD_CD" ).append("\n"); 
		query.append("      , MB.BKG_NO" ).append("\n"); 
		query.append("      , MB.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT VVD_SEQ" ).append("\n"); 
		query.append("         , VVD" ).append("\n"); 
		query.append("         , SLAN_CD" ).append("\n"); 
		query.append("         , L_RHQ   " ).append("\n"); 
		query.append("         , ALOC_LOD_QTY" ).append("\n"); 
		query.append("         , TEU_TTL    " ).append("\n"); 
		query.append("         , BKG_CTRL_TP_CD    " ).append("\n"); 
		query.append("         , ALOC_LOD_QTY_RTO" ).append("\n"); 
		query.append("         , TS_RATIO" ).append("\n"); 
		query.append("         , BKG_ALOC_RMK" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("            SELECT BKG.VVD_SEQ" ).append("\n"); 
		query.append("                 , BKG.VVD" ).append("\n"); 
		query.append("                 , BKG.VVD_SLAN_CD SLAN_CD" ).append("\n"); 
		query.append("                 , BKG.OFC_N3RD_LVL_CD L_RHQ" ).append("\n"); 
		query.append("                 , MST.BKG_ALOC_SEQ" ).append("\n"); 
		query.append("                 , MST.ALOC_SVC_CD" ).append("\n"); 
		query.append("                 , MST.BKG_CTRL_TP_CD       " ).append("\n"); 
		query.append("                 , MST.ALOC_LOD_QTY" ).append("\n"); 
		query.append("                 , MST.ALOC_LOD_QTY_RTO" ).append("\n"); 
		query.append("                 , SUM(BKG.BKG_LOD_QTY) TEU_TTL    " ).append("\n"); 
		query.append("                 , MST.BKG_ALOC_RMK" ).append("\n"); 
		query.append("              , CASE WHEN NVL(MST.ALOC_LOD_QTY, 0) = 0 THEN 0" ).append("\n"); 
		query.append("                     ELSE ROUND(SUM(BKG.BKG_LOD_QTY) / MST.ALOC_LOD_QTY * 100, 1)" ).append("\n"); 
		query.append("                      END AS TS_RATIO" ).append("\n"); 
		query.append("               , MAX(DECODE(BKG.BKG_NO, @[bkg_no], 'Y')) SB_BKG_YN" ).append("\n"); 
		query.append("           FROM MST  " ).append("\n"); 
		query.append("              , BKG" ).append("\n"); 
		query.append("          WHERE NVL(MST.TRNK_SLAN_CD(+), BKG.TRNK_SLAN_CD) = BKG.TRNK_SLAN_CD" ).append("\n"); 
		query.append("            AND NVL(MST.VSL_CD(+),BKG.VVD_VSL_CD)          = BKG.VVD_VSL_CD       " ).append("\n"); 
		query.append("            AND NVL(MST.SKD_VOY_NO(+),BKG.VVD_SKD_VOY_NO)  = BKG.VVD_SKD_VOY_NO       " ).append("\n"); 
		query.append("            AND NVL(MST.SKD_DIR_CD(+),BKG.VVD_SKD_DIR_CD)  = BKG.VVD_SKD_DIR_CD  " ).append("\n"); 
		query.append("            -- POR/NODE" ).append("\n"); 
		query.append("            AND (NVL(MST.POR_CNT_CD,    NVL(BKG.POR_CNT_CD, '#@'))      LIKE '%'||NVL(BKG.POR_CNT_CD, '#@')||'%')" ).append("\n"); 
		query.append("            AND (NVL(MST.POR_CD,        NVL(BKG.POR_CD, '#@'))          LIKE '%'||NVL(BKG.POR_CD, '#@')||'%')" ).append("\n"); 
		query.append("            AND (NVL(MST.POR_NOD_CD,    NVL(BKG.POR_NOD_CD, '#@'))      LIKE '%'||NVL(BKG.POR_NOD_CD, '#@')||'%')" ).append("\n"); 
		query.append("            AND (NVL(MST.BKG_POR_SCC_CD,NVL(BKG.POR_SCC_CD, '#@'))      LIKE '%'||NVL(BKG.POR_SCC_CD, '#@')||'%')" ).append("\n"); 
		query.append("            -- POL/NODE" ).append("\n"); 
		query.append("            AND (NVL(MST.POL_CNT_CD,    NVL(BKG.POL_CNT_CD, '#@'))      LIKE '%'||NVL(BKG.POL_CNT_CD, '#@')||'%')" ).append("\n"); 
		query.append("            AND (NVL(MST.POL_CD,        NVL(BKG.POL_CD, '#@'))          LIKE '%'||NVL(BKG.POL_CD, '#@')||'%')" ).append("\n"); 
		query.append("            AND (NVL(MST.POL_NOD_CD,    NVL(BKG.POL_NOD_CD, '#@'))      LIKE '%'||NVL(BKG.POL_NOD_CD, '#@')||'%')" ).append("\n"); 
		query.append("            -- T/S -> T/S PORT" ).append("\n"); 
		query.append("            AND (NVL(MST.TS_ALL_LOC_CD, NVL(BKG.TS_POL_CD1, '#@'))      LIKE '%'||NVL(BKG.TS_POL_CD1, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.TS_ALL_LOC_CD,  NVL(BKG.TS_POL_CD2, '#@'))      LIKE '%'||NVL(BKG.TS_POL_CD2, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.TS_ALL_LOC_CD,  NVL(BKG.TS_POL_CD3, '#@'))      LIKE '%'||NVL(BKG.TS_POL_CD3, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.TS_ALL_LOC_CD,  NVL(BKG.TS_POD_CD1, '#@'))      LIKE '%'||NVL(BKG.TS_POD_CD1, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.TS_ALL_LOC_CD,  NVL(BKG.TS_POD_CD2, '#@'))      LIKE '%'||NVL(BKG.TS_POD_CD2, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.TS_ALL_LOC_CD,  NVL(BKG.TS_POD_CD3, '#@'))      LIKE '%'||NVL(BKG.TS_POD_CD3, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.TS_ALL_NOD_CD, NVL(BKG.TS_POL_NOD_CD1, '#@'))  LIKE '%'||NVL(BKG.TS_POL_NOD_CD1, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.TS_ALL_NOD_CD,  NVL(BKG.TS_POL_NOD_CD2, '#@'))  LIKE '%'||NVL(BKG.TS_POL_NOD_CD2, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.TS_ALL_NOD_CD,  NVL(BKG.TS_POL_NOD_CD3, '#@'))  LIKE '%'||NVL(BKG.TS_POL_NOD_CD3, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.TS_ALL_NOD_CD,  NVL(BKG.TS_POD_NOD_CD1, '#@'))  LIKE '%'||NVL(BKG.TS_POD_NOD_CD1, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.TS_ALL_NOD_CD,  NVL(BKG.TS_POD_NOD_CD2, '#@'))  LIKE '%'||NVL(BKG.TS_POD_NOD_CD2, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.TS_ALL_NOD_CD,  NVL(BKG.TS_POD_NOD_CD3, '#@'))  LIKE '%'||NVL(BKG.TS_POD_NOD_CD3, '#@')||'%')" ).append("\n"); 
		query.append("            -- T/S -> LANE" ).append("\n"); 
		query.append("            AND NVL(MST.N1ST_TS_SLAN_CD(+), BKG.VVD_SLAN_CD) = BKG.VVD_SLAN_CD" ).append("\n"); 
		query.append("            -- T/S -> BD" ).append("\n"); 
		query.append("            AND NVL(MST.N1ST_TS_DIR_CD(+), BKG.VVD_SKD_DIR_CD) = BKG.VVD_SKD_DIR_CD" ).append("\n"); 
		query.append("            -- T/S -> POL COUNTRY" ).append("\n"); 
		query.append("            AND (NVL(MST.N1ST_TS_POL_CNT_CD, NVL(BKG.TS_POL_CNT_CD1, '#@')) LIKE '%'||NVL(BKG.TS_POL_CNT_CD1, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.N1ST_TS_POL_CNT_CD,  NVL(BKG.TS_POL_CNT_CD2, '#@')) LIKE '%'||NVL(BKG.TS_POL_CNT_CD2, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.N1ST_TS_POL_CNT_CD,  NVL(BKG.TS_POL_CNT_CD3, '#@')) LIKE '%'||NVL(BKG.TS_POL_CNT_CD3, '#@')||'%')" ).append("\n"); 
		query.append("            -- T/S -> POL" ).append("\n"); 
		query.append("            AND (NVL(MST.N1ST_TS_POL_CD, NVL(BKG.TS_POL_CD1, '#@'))     LIKE '%'||NVL(BKG.TS_POL_CD1, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.N1ST_TS_POL_CD,  NVL(BKG.TS_POL_CD2, '#@'))     LIKE '%'||NVL(BKG.TS_POL_CD2, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.N1ST_TS_POL_CD,  NVL(BKG.TS_POL_CD3, '#@'))     LIKE '%'||NVL(BKG.TS_POL_CD3, '#@')||'%')" ).append("\n"); 
		query.append("            -- T/S -> POL NODE(LOC+00)" ).append("\n"); 
		query.append("            AND (NVL(MST.TS_POL_NOD_CD, NVL(BKG.TS_POL_NOD_CD1, '#@'))  LIKE '%'||NVL(BKG.TS_POL_NOD_CD1, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.TS_POL_NOD_CD,  NVL(BKG.TS_POL_NOD_CD2, '#@'))  LIKE '%'||NVL(BKG.TS_POL_NOD_CD2, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.TS_POL_NOD_CD,  NVL(BKG.TS_POL_NOD_CD3, '#@'))  LIKE '%'||NVL(BKG.TS_POL_NOD_CD3, '#@')||'%')" ).append("\n"); 
		query.append("            -- T/S -> POD COUNTRY" ).append("\n"); 
		query.append("            AND (NVL(MST.N1ST_TS_POD_CNT_CD, NVL(BKG.TS_POD_CNT_CD1, '#@')) LIKE '%'||NVL(BKG.TS_POD_CNT_CD1, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.N1ST_TS_POD_CNT_CD,  NVL(BKG.TS_POD_CNT_CD2, '#@')) LIKE '%'||NVL(BKG.TS_POD_CNT_CD2, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.N1ST_TS_POD_CNT_CD,  NVL(BKG.TS_POD_CNT_CD3, '#@')) LIKE '%'||NVL(BKG.TS_POD_CNT_CD3, '#@')||'%')" ).append("\n"); 
		query.append("            -- T/S -> POD" ).append("\n"); 
		query.append("            AND (NVL(MST.N1ST_TS_POD_CD, NVL(BKG.TS_POD_CD1, '#@'))     LIKE '%'||NVL(BKG.TS_POD_CD1, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.N1ST_TS_POD_CD,  NVL(BKG.TS_POD_CD2, '#@'))     LIKE '%'||NVL(BKG.TS_POD_CD2, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.N1ST_TS_POD_CD,  NVL(BKG.TS_POD_CD3, '#@'))     LIKE '%'||NVL(BKG.TS_POD_CD3, '#@')||'%')" ).append("\n"); 
		query.append("            -- T/S -> POD NODE(LOC+00)" ).append("\n"); 
		query.append("            AND (NVL(MST.TS_POD_NOD_CD, NVL(BKG.TS_POD_NOD_CD1, '#@'))  LIKE '%'||NVL(BKG.TS_POD_NOD_CD1, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.TS_POD_NOD_CD,  NVL(BKG.TS_POD_NOD_CD2, '#@'))  LIKE '%'||NVL(BKG.TS_POD_NOD_CD2, '#@')||'%'" ).append("\n"); 
		query.append("             OR NVL(MST.TS_POD_NOD_CD,  NVL(BKG.TS_POD_NOD_CD3, '#@'))  LIKE '%'||NVL(BKG.TS_POD_NOD_CD3, '#@')||'%')" ).append("\n"); 
		query.append("            -- POD/NODE" ).append("\n"); 
		query.append("            AND (NVL(MST.POD_CNT_CD,    NVL(BKG.POD_CNT_CD, '#@'))      LIKE '%'||NVL(BKG.POD_CNT_CD, '#@')||'%')" ).append("\n"); 
		query.append("            AND (NVL(MST.POD_CD,        NVL(BKG.POD_CD, '#@'))          LIKE '%'||NVL(BKG.POD_CD, '#@')||'%')" ).append("\n"); 
		query.append("            AND (NVL(MST.POD_NOD_CD,    NVL(BKG.POD_NOD_CD, '#@'))      LIKE '%'||NVL(BKG.POD_NOD_CD, '#@')||'%')" ).append("\n"); 
		query.append("            -- DEL/NODE" ).append("\n"); 
		query.append("            AND (NVL(MST.DEL_CNT_CD,    NVL(BKG.DEL_CNT_CD, '#@'))      LIKE '%'||NVL(BKG.DEL_CNT_CD, '#@')||'%')" ).append("\n"); 
		query.append("            AND (NVL(MST.DEL_CD,        NVL(BKG.DEL_CD, '#@'))          LIKE '%'||NVL(BKG.DEL_CD, '#@')||'%')" ).append("\n"); 
		query.append("            AND (NVL(MST.DEL_NOD_CD,    NVL(BKG.DEL_NOD_CD, '#@'))      LIKE '%'||NVL(BKG.DEL_NOD_CD, '#@')||'%')" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            AND NVL(MST.OB_SLS_OFC_CD(+), BKG.OB_SLS_OFC_CD)               = BKG.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("        GROUP BY   BKG.VVD_SEQ" ).append("\n"); 
		query.append("                 , BKG.VVD" ).append("\n"); 
		query.append("                 , BKG.VVD_SLAN_CD " ).append("\n"); 
		query.append("                 , BKG.OFC_N3RD_LVL_CD " ).append("\n"); 
		query.append("                 , MST.BKG_ALOC_SEQ" ).append("\n"); 
		query.append("                 , MST.ALOC_SVC_CD" ).append("\n"); 
		query.append("                 , MST.BKG_CTRL_TP_CD       " ).append("\n"); 
		query.append("                 , MST.ALOC_LOD_QTY" ).append("\n"); 
		query.append("                 , MST.ALOC_LOD_QTY_RTO" ).append("\n"); 
		query.append("                 , MST.BKG_ALOC_RMK" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("   WHERE SB_BKG_YN = 'Y'" ).append("\n"); 

	}
}