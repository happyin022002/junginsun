/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchPrdConstraintRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOSearchPrdConstraintRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPrdConstraint
	  * 1. 2011.07.04 이수진 [CHM-201111709] PRD > Network Constraint 관련 data upload 및 기능개선 요청
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchPrdConstraintRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchPrdConstraintRSQL").append("\n"); 
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
		query.append("SELECT SVC_USE_FLG, ROUT, PORT_PNT_CD, ITEM, CNTR_TP_CD, CMDT_CD, RMK, CRE_OFC_CD, CRE_USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT  R.SVC_USE_FLG, R.POL_NOD_CD || '-' || R.POD_NOD_CD || '-' || R.TRNK_LANE_CD   ROUT," ).append("\n"); 
		query.append("     '' PORT_PNT_CD, '' ITEM, '' CNTR_TP_CD, '' CMDT_CD, ROUT_CNST_RMK RMK, R.CRE_OFC_CD, R.CRE_USR_ID" ).append("\n"); 
		query.append("          , ROW_NUMBER() OVER (PARTITION BY MST.PCTL_NO" ).append("\n"); 
		query.append("                               ORDER BY DECODE(R.TRNK_LANE_CD, 'ALL', 1, 0)" ).append("\n"); 
		query.append("                                      , DECODE(R.POL_NOD_CD, 'ALL', 1, 0)" ).append("\n"); 
		query.append("                                      , DECODE(R.POL_NOD_CD, 'ALL', 1, 0)" ).append("\n"); 
		query.append("                                     , R.ROUT_CNST_SEQ DESC ) RN" ).append("\n"); 
		query.append("    FROM PRD_ROUT_CNST R," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT  M.PCTL_NO, POL_CD," ).append("\n"); 
		query.append("                    MAX (DECODE (TS.RK, 1, TS.LANE_CD)) N1ST_LANE_CD, N1ST_TS_PORT_CD," ).append("\n"); 
		query.append("                    MAX (DECODE (TS.RK, 2, TS.LANE_CD)) N2ND_LANE_CD, N2ND_TS_PORT_CD," ).append("\n"); 
		query.append("                    MAX (DECODE (TS.RK, 3, TS.LANE_CD)) N3RD_LANE_CD," ).append("\n"); 
		query.append("                    POD_CD, DEL_NOD_CD," ).append("\n"); 
		query.append("                    (SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("                    FROM VSK_VSL_SKD V" ).append("\n"); 
		query.append("                    WHERE V.VSL_CD = TRNK_VSL_CD" ).append("\n"); 
		query.append("                    AND V.SKD_VOY_NO = TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND V.SKD_DIR_CD = TRNK_SKD_DIR_CD ) TRNK_LANE," ).append("\n"); 
		query.append("                    (SELECT /*+INDEX (D XPKPRD_PROD_CTL_ROUT_DTL) */" ).append("\n"); 
		query.append("                            ORG_NOD_CD" ).append("\n"); 
		query.append("                    FROM PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("                    WHERE PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("                    AND PCTL_IO_BND_CD = 'I' AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                AND MTY_YD_FLG = 'N'" ).append("\n"); 
		query.append("                 AND ROWNUM = 1" ).append("\n"); 
		query.append("                    ) POD_NOD" ).append("\n"); 
		query.append("             ,MAX (DECODE (TS.RK, 1, ORG_NOD_CD )) N1ST_ORG_NOD_CD, MAX (DECODE (TS.RK, 1, DEST_NOD_CD )) N1ST_DEST_NOD_CD" ).append("\n"); 
		query.append("             ,MAX (DECODE (TS.RK, 2, ORG_NOD_CD )) N2ND_ORG_NOD_CD, MAX (DECODE (TS.RK, 2, DEST_NOD_CD )) N2ND_DEST_NOD_CD" ).append("\n"); 
		query.append("             ,MAX (DECODE (TS.RK, 3, ORG_NOD_CD )) N3RD_ORG_NOD_CD, MAX (DECODE (TS.RK, 3, DEST_NOD_CD )) N3RD_DEST_NOD_CD" ).append("\n"); 
		query.append("            FROM PRD_PROD_CTL_MST M," ).append("\n"); 
		query.append("                 (SELECT PCTL_NO,ORG_NOD_CD,DEST_NOD_CD," ).append("\n"); 
		query.append("                         RANK () OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) RK, VSL_SLAN_CD LANE_CD" ).append("\n"); 
		query.append("                    FROM PRD_PROD_CTL_ROUT_DTL DTL, PRD_OCN_ROUT ROUT" ).append("\n"); 
		query.append("                   WHERE PCTL_NO = @[pctl_no] " ).append("\n"); 
		query.append("                     AND VSL_SLAN_CD IS NOT NULL" ).append("\n"); 
		query.append("                    AND  DTL.ROUT_ORG_NOD_CD = ROUT.ORG_LOC_CD" ).append("\n"); 
		query.append("                    AND     DTL.ROUT_DEST_NOD_CD = ROUT.DEST_LOC_CD" ).append("\n"); 
		query.append("                    AND     DTL.ROUT_SEQ = ROUT.ROUT_SEQ" ).append("\n"); 
		query.append("                 ) TS" ).append("\n"); 
		query.append("            WHERE M.PCTL_NO = @[pctl_no] AND M.PCTL_NO = TS.PCTL_NO(+)" ).append("\n"); 
		query.append("            GROUP BY M.PCTL_NO, POL_CD," ).append("\n"); 
		query.append("                     N1ST_TS_PORT_CD," ).append("\n"); 
		query.append("                     N2ND_TS_PORT_CD," ).append("\n"); 
		query.append("                     POD_CD," ).append("\n"); 
		query.append("                     DEL_NOD_CD," ).append("\n"); 
		query.append("                     TRNK_VSL_CD," ).append("\n"); 
		query.append("                     TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("                     TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("         ) MST" ).append("\n"); 
		query.append("    WHERE MST.TRNK_LANE = DECODE(R.TRNK_LANE_CD, 'ALL',MST.TRNK_LANE,R.TRNK_LANE_CD)" ).append("\n"); 
		query.append("    AND MST.POL_CD LIKE DECODE(R.POL_NOD_CD, 'ALL', MST.POL_CD, SUBSTR(R.POL_NOD_CD,1,5)||'%')" ).append("\n"); 
		query.append("    AND MST.N1ST_ORG_NOD_CD LIKE DECODE(LENGTH(R.POL_NOD_CD),7,R.POL_NOD_CD, MST.N1ST_ORG_NOD_CD)" ).append("\n"); 
		query.append("    AND MST.POD_NOD LIKE DECODE(R.POD_NOD_CD, 'ALL', MST.POD_CD, R.POD_NOD_CD) ||'%'" ).append("\n"); 
		query.append("    AND NVL(MST.DEL_NOD_CD, R.DEL_NOD_CD) LIKE NVL(R.DEL_NOD_CD, MST.DEL_NOD_CD)||'%'" ).append("\n"); 
		query.append("    AND NVL(MST.N1ST_TS_PORT_CD, ' ') = NVL(R.N1ST_TS_PORT_CD, NVL(MST.N1ST_TS_PORT_CD, ' '))" ).append("\n"); 
		query.append("    AND NVL(MST.N2ND_TS_PORT_CD, ' ') = NVL(R.N2ND_TS_PORT_CD, NVL(MST.N2ND_TS_PORT_CD, ' '))" ).append("\n"); 
		query.append("    AND NVL(MST.N1ST_LANE_CD, ' ') = NVL(R.N1ST_LANE_CD, NVL(MST.N1ST_LANE_CD, ' '))" ).append("\n"); 
		query.append("    AND NVL(MST.N2ND_LANE_CD, ' ') = NVL(R.N2ND_LANE_CD, NVL(MST.N2ND_LANE_CD, ' '))" ).append("\n"); 
		query.append("    AND NVL(MST.N3RD_LANE_CD, ' ') = NVL(R.N3RD_LANE_CD, NVL(MST.N3RD_LANE_CD, ' '))" ).append("\n"); 
		query.append("    AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("    ) M" ).append("\n"); 
		query.append("WHERE RN = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT APLY_SVC_MOD_FLG SVC_USE_FLG" ).append("\n"); 
		query.append("--    , '(' || SLAN_CD || ')-' ||  POD_CD " ).append("\n"); 
		query.append("--      || '-(' || DECODE(TRSP_MOD_CD, 'AL', 'ALL', (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00277' AND INTG_CD_VAL_CTNT = TRSP_MOD_CD))|| ')-' " ).append("\n"); 
		query.append("--      || DEL_CD || '-[' || DECODE(BKG_DE_TERM_CD, 'A', 'ALL', (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00765' AND INTG_CD_VAL_CTNT = BKG_DE_TERM_CD)) || ']'" ).append("\n"); 
		query.append("--      ROUT" ).append("\n"); 
		query.append("    , DEL_CD ROUT, POD_CD PORT_PNT_CD, 'POL/POD Constraint' ITEM, '' CNTR_TP_CD, '' CMDT_CD, BKG_RMK RMK, " ).append("\n"); 
		query.append("     (SELECT OFC_CD FROM COM_USER WHERE USR_ID = RSLT.CRE_USR_ID) CRE_OFC_CD ,CRE_USR_ID" ).append("\n"); 
		query.append("   -- PCTL_NO,SLAN_CD, POD_CD, DEL_CD ,BKG_DE_TERM_CD, TRSP_MOD_CD, BKG_RMK, DECODE(NVL(APLY_SVC_MOD_FLG, 'Y'), 'N', 'X', 'R') APLY_SVC_MOD_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT PCTL_NO, CNST.SLAN_CD, CNST.POD_CD, CNST.DEL_CD, BKG_DE_TERM_CD, TRSP_MOD_CD, BKG_RMK, APLY_SVC_MOD_FLG" ).append("\n"); 
		query.append("                     , ROW_NUMBER() OVER (PARTITION BY PCTL_NO, IO_BND_CD ORDER BY DECODE(BKG_DE_TERM_CD, 'A', 1, 0), DECODE(TRSP_MOD_CD, 'AL', 1, 0)) ODR" ).append("\n"); 
		query.append("             , CNST.CRE_USR_ID" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT PCTL_NO, IO_BND_CD, POD_CD, DEL_CD, TERM_CD" ).append("\n"); 
		query.append("                  , SLAN_CD" ).append("\n"); 
		query.append("                 , CASE WHEN SUBSTR(TRSP_MOD, 1,1) = 'T' AND REPLACE(TRSP_MOD, 'T', '') IS NULL THEN 'TD'" ).append("\n"); 
		query.append("                        WHEN REPLACE(TRSP_MOD, 'R', '') IS NULL THEN 'RD'" ).append("\n"); 
		query.append("                        WHEN SUBSTR(TRSP_MOD, 1,2) = 'TR' AND REPLACE(SUBSTR(TRSP_MOD, 3), 'R', '') IS NULL THEN 'RD'" ).append("\n"); 
		query.append("                        WHEN SUBSTR(TRSP_MOD, -2) = 'RT' THEN 'RT'" ).append("\n"); 
		query.append("                        WHEN REPLACE(TRSP_MOD, 'W', '') IS NULL THEN 'WD'" ).append("\n"); 
		query.append("                        WHEN SUBSTR(TRSP_MOD, 1,2) = 'TW' AND REPLACE(SUBSTR(TRSP_MOD, 3), 'W', '') IS NULL THEN 'WD'" ).append("\n"); 
		query.append("                        WHEN SUBSTR(TRSP_MOD, -2) = 'WT' THEN 'WT'" ).append("\n"); 
		query.append("                        WHEN INSTR(TRSP_MOD, 'WR') > 0 THEN 'WR'" ).append("\n"); 
		query.append("                   END TRSP_MOD" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                    SELECT PCTL_NO, IO_BND_CD" ).append("\n"); 
		query.append("                     , MAX(DECODE(IO_BND_CD, 'O', POL_CD, POD_CD)) POD_CD" ).append("\n"); 
		query.append("                     , MAX(DECODE(IO_BND_CD, 'O', POR_CD, DEL_CD)) DEL_CD" ).append("\n"); 
		query.append("                     , DECODE(MAX(DECODE(IO_BND_CD, 'O', BKG_RCV_TERM_CD, BKG_DE_TERM_CD)), 'D','D','Y') TERM_CD" ).append("\n"); 
		query.append("                     , MAX(DECODE(use_pctl, 'Y',DECODE(RN, 1, TRSP_MOD))) " ).append("\n"); 
		query.append("                      ||MAX(DECODE(use_pctl, 'Y',DECODE(RN, 2, TRSP_MOD)))" ).append("\n"); 
		query.append("                      ||MAX(DECODE(use_pctl, 'Y',DECODE(RN, 3, TRSP_MOD)))" ).append("\n"); 
		query.append("                      ||MAX(DECODE(use_pctl, 'Y',DECODE(RN, 4, TRSP_MOD)))" ).append("\n"); 
		query.append("                      ||MAX(DECODE(use_pctl, 'Y',DECODE(RN, 5, TRSP_MOD)))" ).append("\n"); 
		query.append("                      ||MAX(DECODE(use_pctl, 'Y',DECODE(RN, 6, TRSP_MOD)))" ).append("\n"); 
		query.append("                      ||MAX(DECODE(use_pctl, 'Y',DECODE(RN, 7, TRSP_MOD)))" ).append("\n"); 
		query.append("                      ||MAX(DECODE(use_pctl, 'Y',DECODE(RN, 8, TRSP_MOD)))" ).append("\n"); 
		query.append("                      ||MAX(DECODE(use_pctl, 'Y',DECODE(RN, 9, TRSP_MOD)))" ).append("\n"); 
		query.append("                      ||MAX(DECODE(use_pctl, 'Y',DECODE(RN,10, TRSP_MOD))) TRSP_MOD" ).append("\n"); 
		query.append("                    , MAX(VSL_SLAN_CD) SLAN_CD" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                    SELECT PMST.PCTL_NO, PDTL.PCTL_SEQ, PMST.POR_CD, PMST.POL_CD, PMST.POD_CD, PMST.DEL_CD , PMST.BKG_RCV_TERM_CD, PMST.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("                          , DECODE(PDTL.PCTL_IO_BND_CD, 'O','O','I','I'" ).append("\n"); 
		query.append("                                  , DECODE(PDTL.PCTL_SEQ, MIN(PDTL.PCTL_SEQ) OVER (PARTITION BY PMST.PCTL_NO, PDTL.PCTL_IO_BND_CD), 'O')" ).append("\n"); 
		query.append("                                  )  IO_BND_CD" ).append("\n"); 
		query.append("                          , PDTL.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                       , PDTL.PCTL_SEQ" ).append("\n"); 
		query.append("                        , SUBSTR(PDTL.TRSP_MOD_CD,1,1) TRSP_MOD" ).append("\n"); 
		query.append("                        , DECODE(PDTL.PCTL_IO_BND_CD, 'T', NULL, ROW_NUMBER() OVER (PARTITION BY PMST.PCTL_NO, PDTL.PCTL_IO_BND_CD ORDER BY PCTL_SEQ)) RN" ).append("\n"); 
		query.append("                        , PDTL.VSL_SLAN_CD" ).append("\n"); 
		query.append("                        , decode(pdtl.pctl_seq, min(pdtl.pctl_seq) over (partition by pmst.pctl_no), 'X'" ).append("\n"); 
		query.append("                                              , max(pdtl.pctl_seq) over (partition by pmst.pctl_no), 'X'" ).append("\n"); 
		query.append("                                              , 'Y' ) use_pctl" ).append("\n"); 
		query.append("                    FROM PRD_PROD_CTL_MST PMST" ).append("\n"); 
		query.append("                       , PRD_PROD_CTL_ROUT_DTL PDTL" ).append("\n"); 
		query.append("                    WHERE PMST.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                    AND PMST.PCTL_NO = PDTL.PCTL_NO" ).append("\n"); 
		query.append("                    AND PDTL.TRSP_MOD_CD <> 'X'" ).append("\n"); 
		query.append("                    AND PDTL.PCTL_IO_BND_CD IN ('O','T')" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT PMST.PCTL_NO, PDTL.PCTL_SEQ, PMST.POR_CD, PMST.POL_CD, PMST.POD_CD, PMST.DEL_CD , PMST.BKG_RCV_TERM_CD, PMST.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("                          , DECODE(PDTL.PCTL_IO_BND_CD, 'O','O','I','I'" ).append("\n"); 
		query.append("                                  , DECODE(PDTL.PCTL_SEQ, MAX(PDTL.PCTL_SEQ) OVER (PARTITION BY PMST.PCTL_NO, PDTL.PCTL_IO_BND_CD), 'I')" ).append("\n"); 
		query.append("                                  )  IO_BND_CD" ).append("\n"); 
		query.append("                          , PDTL.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                       , PDTL.PCTL_SEQ" ).append("\n"); 
		query.append("                        , SUBSTR(PDTL.TRSP_MOD_CD,1,1) TRSP_MOD" ).append("\n"); 
		query.append("                        , DECODE(PDTL.PCTL_IO_BND_CD, 'T', NULL, ROW_NUMBER() OVER (PARTITION BY PMST.PCTL_NO, PDTL.PCTL_IO_BND_CD ORDER BY PCTL_SEQ)) RN" ).append("\n"); 
		query.append("                        , PDTL.VSL_SLAN_CD" ).append("\n"); 
		query.append("                        , decode(pdtl.pctl_seq, min(pdtl.pctl_seq) over (partition by pmst.pctl_no), 'X'" ).append("\n"); 
		query.append("                                              , max(pdtl.pctl_seq) over (partition by pmst.pctl_no), 'X'" ).append("\n"); 
		query.append("                                              , 'Y' ) use_pctl" ).append("\n"); 
		query.append("                    FROM PRD_PROD_CTL_MST PMST" ).append("\n"); 
		query.append("                       , PRD_PROD_CTL_ROUT_DTL PDTL" ).append("\n"); 
		query.append("                    WHERE PMST.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                    AND PMST.PCTL_NO = PDTL.PCTL_NO" ).append("\n"); 
		query.append("                    AND PDTL.TRSP_MOD_CD <> 'X'" ).append("\n"); 
		query.append("                    AND PDTL.PCTL_IO_BND_CD IN ('I','T')" ).append("\n"); 
		query.append("                     ) " ).append("\n"); 
		query.append("                GROUP BY PCTL_NO, IO_BND_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("           ) SUBX" ).append("\n"); 
		query.append("           , PRD_POD_MGMT CNST" ).append("\n"); 
		query.append("        WHERE SUBX.SLAN_CD = DECODE(CNST.SLAN_CD, 'ALL', SUBX.SLAN_CD, CNST.SLAN_CD)" ).append("\n"); 
		query.append("          AND SUBX.IO_BND_CD = CNST.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("          AND SUBX.POD_CD    = DECODE(CNST.POD_CD, 'ALL', SUBX.POD_CD, CNST.POD_CD)" ).append("\n"); 
		query.append("          AND SUBX.DEL_CD    = DECODE(CNST.DEL_CD, 'ALL', SUBX.DEL_CD, CNST.DEL_CD)" ).append("\n"); 
		query.append("          AND SUBX.TERM_CD   = DECODE(CNST.BKG_DE_TERM_CD, 'A', SUBX.TERM_CD, CNST.BKG_DE_TERM_CD)" ).append("\n"); 
		query.append("          AND SUBX.TRSP_MOD  = DECODE(CNST.TRSP_MOD_CD, 'AL', SUBX.TRSP_MOD, CNST.TRSP_MOD_CD)" ).append("\n"); 
		query.append("          AND NVL(CNST.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("      ) RSLT" ).append("\n"); 
		query.append("WHERE ODR = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT  C.SVC_USE_FLG, C.LNK_ORG_NOD_CD||'-'||LNK_DEST_NOD_CD ROUT," ).append("\n"); 
		query.append("'' PORT_PNT_CD, PCTL_CNST_ITM_NM ITEM, C.CNTR_TP_CD, C.CMDT_CD, LNK_CNST_RMK RMK,C.CRE_OFC_CD, C.CRE_USR_ID" ).append("\n"); 
		query.append("FROM PRD_LNK_CNST_MGMT C," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT ORG_NOD_CD, DEST_NOD_CD,TRSP_MOD_CD,CNTR_TPSZ_CD,CMDT_CD,DEP_FSH_DT,ARR_ST_DT,M.CRE_DT" ).append("\n"); 
		query.append("    FROM PRD_PROD_CTL_MST M , PRD_PROD_CTL_ROUT_DTL D , PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("    WHERE M.PCTL_NO = @[pctl_no]--'B0909290000007060001'" ).append("\n"); 
		query.append("    AND M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("    AND M.PCTL_NO = Q.PCTL_NO" ).append("\n"); 
		query.append("    --AND PCTL_IO_BND_CD IN ('I','O')" ).append("\n"); 
		query.append("    AND NOD_LNK_DIV_CD='L'" ).append("\n"); 
		query.append(") P" ).append("\n"); 
		query.append("WHERE  P.ORG_NOD_CD LIKE C.LNK_ORG_NOD_CD||'%'" ).append("\n"); 
		query.append("AND P.DEST_NOD_CD LIKE C.LNK_DEST_NOD_CD||'%'" ).append("\n"); 
		query.append("AND P.TRSP_MOD_CD = DECODE(C.TRSP_MOD_CD, 'AL', P.TRSP_MOD_CD, C.TRSP_MOD_CD) -- Trans Mode가 'AL'로 들어갈 경우 " ).append("\n"); 
		query.append("AND NVL(C.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(C.CNTR_TP_CD, P.CNTR_TPSZ_CD) = DECODE(C.CNTR_TP_CD, NULL, P.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                                                DECODE(SUBSTR(P.CNTR_TPSZ_CD, 1, 1), 'T', 'T', 'O', 'S', 'F', 'S', 'D',P.CNTR_TPSZ_CD, 'R',P.CNTR_TPSZ_CD) " ).append("\n"); 
		query.append("		                                )  " ).append("\n"); 
		query.append("AND NVL(C.CMDT_CD,'X') = DECODE(C.CMDT_CD, NULL,'X',P.CMDT_CD)" ).append("\n"); 
		query.append("AND (						" ).append("\n"); 
		query.append("                -- 사용자 요청으로 PC생성일 기준으로 변경" ).append("\n"); 
		query.append("		TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= P.CRE_DT AND	 " ).append("\n"); 
		query.append("		P.CRE_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)		 " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT  C.SVC_USE_FLG, NOD_CD ROUT," ).append("\n"); 
		query.append("		DECODE(C.PORT_PNT_CD,'ALL',DECODE(C.NOD_CD,'ALL','ALL',P.PORT_PNT_CD),C.PORT_PNT_CD) PORT_PNT_CD, " ).append("\n"); 
		query.append("        PCTL_CNST_ITM_NM ITEM, C.CNTR_TP_CD, C.CMDT_CD, NOD_CNST_RMK RMK ,  C.CRE_OFC_CD, C.CRE_USR_ID" ).append("\n"); 
		query.append("FROM  PRD_NOD_CNST_MGMT C," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT ORG_NOD_CD,CNTR_TPSZ_CD,ARR_ST_DT,DEP_FSH_DT,CMDT_CD, " ).append("\n"); 
		query.append("           DECODE(PCTL_IO_BND_CD,'O',DECODE(SUBSTR(POR,1,5),SUBSTR(POL,1,5),'POR, POL',SUBSTR(ORG_NOD_CD,1,5),'POR',DECODE(MTY_YD_FLG,'Y','MTY','POL' ))," ).append("\n"); 
		query.append("                                 'I',DECODE(SUBSTR(POD,1,5),SUBSTR(DEL,1,5),'POD, DEL',SUBSTR(ORG_NOD_CD,1,5),'POD',DECODE(MTY_YD_FLG,'Y','MTY','DEL' )),'T/S') PORT_PNT_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT D.ORG_NOD_CD, " ).append("\n"); 
		query.append("               NVL(M.POR_NOD_CD,POR_CD) POR, NVL(M.POL_NOD_CD,POL_CD) POL, NVL(M.POD_NOD_CD,POD_CD) POD, NVL(M.DEL_NOD_CD,DEL_CD) DEL, " ).append("\n"); 
		query.append("               CNTR_TPSZ_CD, ARR_ST_DT, DEP_FSH_DT, CMDT_CD, PCTL_IO_BND_CD,MTY_YD_FLG" ).append("\n"); 
		query.append("        FROM PRD_PROD_CTL_ROUT_DTL D, PRD_PROD_CTL_MST M, PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("        WHERE D.PCTL_NO = @[pctl_no] --'B0909290000007060001'" ).append("\n"); 
		query.append("        AND D.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("        AND D.PCTL_NO = Q.PCTL_NO" ).append("\n"); 
		query.append("        --AND D.MTY_YD_FLG <> 'Y' --20100419 MT도 체크해야함." ).append("\n"); 
		query.append("        AND D.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("    ) J" ).append("\n"); 
		query.append(") P" ).append("\n"); 
		query.append("WHERE P.ORG_NOD_CD LIKE DECODE(C.NOD_CD,'ALL','%',C.NOD_CD||'%') " ).append("\n"); 
		query.append("AND NVL(C.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(C.CNTR_TP_CD,P.CNTR_TPSZ_CD)= DECODE(C.CNTR_TP_CD, NULL, P.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                            DECODE(SUBSTR(P.CNTR_TPSZ_CD, 1, 1), 'T', 'T', 'O', 'S', 'F', 'S'," ).append("\n"); 
		query.append("                                            'D',P.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                            'R',P.CNTR_TPSZ_CD))" ).append("\n"); 
		query.append("AND NVL(p.CMDT_CD,'X') = NVL(C.CMDT_CD, NVL(p.CMDT_CD,'X'))" ).append("\n"); 
		query.append("AND (NVL(C.port_pnt_cd, 'ALL') = 'ALL' OR " ).append("\n"); 
		query.append("    P.PORT_PNT_CD LIKE '%'||DECODE(C.port_pnt_cd,'TS','T/S',C.port_pnt_cd)||'%')" ).append("\n"); 

	}
}