/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchPrdCnstRemarkRSQL.java
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

public class ProductCatalogCreateDBDAOSearchPrdCnstRemarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPrdCnstRemark
	  * 1. 2011.07.04 이수진 [CHM-201111709] PRD > Network Constraint 관련 data upload 및 기능개선 요청
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchPrdCnstRemarkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prdCtlNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnstFlg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchPrdCnstRemarkRSQL").append("\n"); 
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
		query.append("SELECT 'Inland : ' || CNST_RMK  CNST_RMK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT PCTL_NO, CNST.SLAN_CD, CNST.POD_CD, CNST.DEL_CD, BKG_DE_TERM_CD, TRSP_MOD_CD, BKG_RMK, APLY_SVC_MOD_FLG" ).append("\n"); 
		query.append("         , ROW_NUMBER() OVER (PARTITION BY PCTL_NO, IO_BND_CD ORDER BY DECODE(BKG_DE_TERM_CD, 'A', 1, 0), DECODE(TRSP_MOD_CD, 'AL', 1, 0)) ODR" ).append("\n"); 
		query.append("         , DECODE(CNST.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                  , 'O', 'Outbound '" ).append("\n"); 
		query.append("                         || '(BKG Term:' || DECODE(CNST.BKG_DE_TERM_CD, 'A', 'ALL', NULL, 'ALL', 'D', 'Door', 'C', 'CY') || ')' " ).append("\n"); 
		query.append("                         || ' ' || CNST.DEL_CD " ).append("\n"); 
		query.append("                         || '-(Trans Mode:' || DECODE(CNST.TRSP_MOD_CD, 'AL', 'ALL', NULL, 'ALL', CNST.TRSP_MOD_CD ) || ')-' " ).append("\n"); 
		query.append("                         || CNST.POD_CD || ' ' " ).append("\n"); 
		query.append("                         || '(First Lane:' || CNST.SLAN_CD || ')' " ).append("\n"); 
		query.append("                  , 'I', 'Inbound '" ).append("\n"); 
		query.append("                         || '(Last Lane:' || CNST.SLAN_CD || ')'  " ).append("\n"); 
		query.append("                         || ' ' || CNST.POD_CD " ).append("\n"); 
		query.append("                         || '-(Trans Mode:' || DECODE(CNST.TRSP_MOD_CD, 'AL', 'ALL', NULL, 'ALL', TRSP_MOD_CD ) || ')-'" ).append("\n"); 
		query.append("                         || CNST.DEL_CD || ' '" ).append("\n"); 
		query.append("                         || '(BKG Term:' || DECODE(CNST.BKG_DE_TERM_CD, 'A', 'ALL', NULL, 'ALL', 'D', 'Door', 'C', 'CY') || ')' " ).append("\n"); 
		query.append("                  , ''" ).append("\n"); 
		query.append("                 ) || CHR(10) ||" ).append("\n"); 
		query.append("                 'Remark : ' ||CNST.BKG_RMK|| CHR(10) ||" ).append("\n"); 
		query.append("                 'SVC : ' || NVL(CNST.APLY_SVC_MOD_FLG, 'Y') || CHR(10) ||" ).append("\n"); 
		query.append("                 DECODE( CNST.CRE_OFC_CD , NULL , NULL, 'Creation Office : ' || CNST.CRE_OFC_CD || CHR(10)) CNST_RMK -- FOR CONSTRAINT " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT PCTL_NO, IO_BND_CD, POD_CD, DEL_CD, TERM_CD" ).append("\n"); 
		query.append("              , SLAN_CD" ).append("\n"); 
		query.append("             , CASE WHEN SUBSTR(TRSP_MOD, 1,1) = 'T' AND REPLACE(TRSP_MOD, 'T', '') IS NULL THEN 'TD'" ).append("\n"); 
		query.append("                    WHEN REPLACE(TRSP_MOD, 'R', '') IS NULL THEN 'RD'" ).append("\n"); 
		query.append("                    WHEN SUBSTR(TRSP_MOD, 1,2) = 'TR' AND REPLACE(SUBSTR(TRSP_MOD, 3), 'R', '') IS NULL THEN 'RD'" ).append("\n"); 
		query.append("                    WHEN SUBSTR(TRSP_MOD, -2) = 'RT' THEN 'RT'" ).append("\n"); 
		query.append("                    WHEN REPLACE(TRSP_MOD, 'W', '') IS NULL THEN 'WD'" ).append("\n"); 
		query.append("                    WHEN SUBSTR(TRSP_MOD, 1,2) = 'TW' AND REPLACE(SUBSTR(TRSP_MOD, 3), 'W', '') IS NULL THEN 'WD'" ).append("\n"); 
		query.append("                    WHEN SUBSTR(TRSP_MOD, -2) = 'WT' THEN 'WT'" ).append("\n"); 
		query.append("                    WHEN INSTR(TRSP_MOD, 'WR') > 0 THEN 'WR'" ).append("\n"); 
		query.append("               END TRSP_MOD" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT PCTL_NO, IO_BND_CD" ).append("\n"); 
		query.append("                 , MAX(DECODE(IO_BND_CD, 'O', POL_CD, POD_CD)) POD_CD" ).append("\n"); 
		query.append("                 , MAX(DECODE(IO_BND_CD, 'O', POR_CD, DEL_CD)) DEL_CD" ).append("\n"); 
		query.append("                 , DECODE(MAX(DECODE(IO_BND_CD, 'O', BKG_RCV_TERM_CD, BKG_DE_TERM_CD)), 'D','D','Y') TERM_CD" ).append("\n"); 
		query.append("                 , MAX(DECODE(use_pctl, 'Y',DECODE(RN, 1, TRSP_MOD)))" ).append("\n"); 
		query.append("                  ||MAX(DECODE(use_pctl, 'Y',DECODE(RN, 2, TRSP_MOD)))" ).append("\n"); 
		query.append("                  ||MAX(DECODE(use_pctl, 'Y',DECODE(RN, 3, TRSP_MOD)))" ).append("\n"); 
		query.append("                  ||MAX(DECODE(use_pctl, 'Y',DECODE(RN, 4, TRSP_MOD)))" ).append("\n"); 
		query.append("                  ||MAX(DECODE(use_pctl, 'Y',DECODE(RN, 5, TRSP_MOD)))" ).append("\n"); 
		query.append("                  ||MAX(DECODE(use_pctl, 'Y',DECODE(RN, 6, TRSP_MOD)))" ).append("\n"); 
		query.append("                  ||MAX(DECODE(use_pctl, 'Y',DECODE(RN, 7, TRSP_MOD)))" ).append("\n"); 
		query.append("                  ||MAX(DECODE(use_pctl, 'Y',DECODE(RN, 8, TRSP_MOD)))" ).append("\n"); 
		query.append("                  ||MAX(DECODE(use_pctl, 'Y',DECODE(RN, 9, TRSP_MOD)))" ).append("\n"); 
		query.append("                  ||MAX(DECODE(use_pctl, 'Y',DECODE(RN,10, TRSP_MOD))) TRSP_MOD" ).append("\n"); 
		query.append("                , MAX(VSL_SLAN_CD) SLAN_CD" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT PMST.PCTL_NO, PDTL.PCTL_SEQ, PMST.POR_CD, PMST.POL_CD, PMST.POD_CD, PMST.DEL_CD , PMST.BKG_RCV_TERM_CD, PMST.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("                      , DECODE(PDTL.PCTL_IO_BND_CD, 'O','O','I','I'" ).append("\n"); 
		query.append("                              , DECODE(PDTL.PCTL_SEQ, MIN(PDTL.PCTL_SEQ) OVER (PARTITION BY PMST.PCTL_NO, PDTL.PCTL_IO_BND_CD), 'O')" ).append("\n"); 
		query.append("                              )  IO_BND_CD" ).append("\n"); 
		query.append("                      , PDTL.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                   , PDTL.PCTL_SEQ" ).append("\n"); 
		query.append("                    , SUBSTR(PDTL.TRSP_MOD_CD,1,1) TRSP_MOD" ).append("\n"); 
		query.append("                    , DECODE(PDTL.PCTL_IO_BND_CD, 'T', NULL, ROW_NUMBER() OVER (PARTITION BY PMST.PCTL_NO, PDTL.PCTL_IO_BND_CD ORDER BY PCTL_SEQ)) RN" ).append("\n"); 
		query.append("                    , PDTL.VSL_SLAN_CD" ).append("\n"); 
		query.append("                    , decode(pdtl.pctl_seq, min(pdtl.pctl_seq) over (partition by pmst.pctl_no), 'X'" ).append("\n"); 
		query.append("                                          , max(pdtl.pctl_seq) over (partition by pmst.pctl_no), 'X'" ).append("\n"); 
		query.append("                                          , 'Y' ) use_pctl" ).append("\n"); 
		query.append("                FROM PRD_PROD_CTL_MST PMST" ).append("\n"); 
		query.append("                   , PRD_PROD_CTL_ROUT_DTL PDTL" ).append("\n"); 
		query.append("                WHERE PMST.PCTL_NO = @[prdCtlNo]" ).append("\n"); 
		query.append("                AND PMST.PCTL_NO = PDTL.PCTL_NO" ).append("\n"); 
		query.append("                AND PDTL.TRSP_MOD_CD <> 'X'" ).append("\n"); 
		query.append("                AND PDTL.PCTL_IO_BND_CD IN ('O','T')" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT PMST.PCTL_NO, PDTL.PCTL_SEQ, PMST.POR_CD, PMST.POL_CD, PMST.POD_CD, PMST.DEL_CD , PMST.BKG_RCV_TERM_CD, PMST.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("                      , DECODE(PDTL.PCTL_IO_BND_CD, 'O','O','I','I'" ).append("\n"); 
		query.append("                              , DECODE(PDTL.PCTL_SEQ, MAX(PDTL.PCTL_SEQ) OVER (PARTITION BY PMST.PCTL_NO, PDTL.PCTL_IO_BND_CD), 'I')" ).append("\n"); 
		query.append("                              )  IO_BND_CD" ).append("\n"); 
		query.append("                      , PDTL.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                   , PDTL.PCTL_SEQ" ).append("\n"); 
		query.append("                    , SUBSTR(PDTL.TRSP_MOD_CD,1,1) TRSP_MOD" ).append("\n"); 
		query.append("                    , DECODE(PDTL.PCTL_IO_BND_CD, 'T', NULL, ROW_NUMBER() OVER (PARTITION BY PMST.PCTL_NO, PDTL.PCTL_IO_BND_CD ORDER BY PCTL_SEQ)) RN" ).append("\n"); 
		query.append("                    , PDTL.VSL_SLAN_CD" ).append("\n"); 
		query.append("                    , decode(pdtl.pctl_seq, min(pdtl.pctl_seq) over (partition by pmst.pctl_no), 'X'" ).append("\n"); 
		query.append("                                          , max(pdtl.pctl_seq) over (partition by pmst.pctl_no), 'X'" ).append("\n"); 
		query.append("                                          , 'Y' ) use_pctl" ).append("\n"); 
		query.append("                FROM PRD_PROD_CTL_MST PMST" ).append("\n"); 
		query.append("                   , PRD_PROD_CTL_ROUT_DTL PDTL" ).append("\n"); 
		query.append("                WHERE PMST.PCTL_NO = @[prdCtlNo]" ).append("\n"); 
		query.append("                AND PMST.PCTL_NO = PDTL.PCTL_NO" ).append("\n"); 
		query.append("                AND PDTL.TRSP_MOD_CD <> 'X'" ).append("\n"); 
		query.append("                AND PDTL.PCTL_IO_BND_CD IN ('I','T')" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            GROUP BY PCTL_NO, IO_BND_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("       ) SUBX" ).append("\n"); 
		query.append("       , PRD_POD_MGMT CNST" ).append("\n"); 
		query.append("    WHERE SUBX.SLAN_CD = DECODE(CNST.SLAN_CD, 'ALL', SUBX.SLAN_CD, CNST.SLAN_CD)" ).append("\n"); 
		query.append("      AND SUBX.IO_BND_CD = CNST.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("      AND SUBX.POD_CD    = DECODE(CNST.POD_CD, 'ALL', SUBX.POD_CD, CNST.POD_CD)" ).append("\n"); 
		query.append("      AND SUBX.DEL_CD    = DECODE(CNST.DEL_CD, 'ALL', SUBX.DEL_CD, CNST.DEL_CD)" ).append("\n"); 
		query.append("      AND SUBX.TERM_CD   = DECODE(CNST.BKG_DE_TERM_CD, 'A', SUBX.TERM_CD, CNST.BKG_DE_TERM_CD)" ).append("\n"); 
		query.append("      AND SUBX.TRSP_MOD  = DECODE(CNST.TRSP_MOD_CD, 'AL', SUBX.TRSP_MOD, CNST.TRSP_MOD_CD)" ).append("\n"); 
		query.append("      AND NVL(CNST.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("WHERE @[cnstFlg] IN ('A','X','O','P','R')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT 'Route : '|| CHR(10) ||" ).append("\n"); 
		query.append("     'POL : '||POL_CD|| CHR(10) ||" ).append("\n"); 
		query.append("     DECODE(N1ST_LANE_CD, NULL, NULL, 'N1ST_LANE_CD : '||N1ST_LANE_CD||CHR(10))||" ).append("\n"); 
		query.append("     DECODE(N1ST_TS_PORT_CD, NULL, NULL, 'N1ST_TS_PORT_CD : '||N1ST_TS_PORT_CD||CHR(10))||" ).append("\n"); 
		query.append("     DECODE(N2ND_LANE_CD, NULL, NULL, 'N2ND_LANE_CD : '||N2ND_LANE_CD||CHR(10))||" ).append("\n"); 
		query.append("     DECODE(N2ND_TS_PORT_CD, NULL, NULL, 'N2ND_TS_PORT_CD : '||N2ND_TS_PORT_CD||CHR(10))||" ).append("\n"); 
		query.append("     DECODE(N3RD_LANE_CD, NULL, NULL, 'N3RD_LANE_CD : '||N3RD_LANE_CD||CHR(10))||" ).append("\n"); 
		query.append("     'POD : '||POD_NOD_CD||CHR(10)||" ).append("\n"); 
		query.append("     'DEL : '||DEL_CD||CHR(10)||" ).append("\n"); 
		query.append("     'VVD : '|| VVD||CHR(10)||" ).append("\n"); 
		query.append("     'CMDT : '|| CMDT_CD || CHR(10)|| -- ADD FOR CONSTRAINT REMARK" ).append("\n"); 
		query.append("     'Remark : ' ||ROUT_CNST_RMK||CHR(10)|| " ).append("\n"); 
		query.append("     DECODE( SVC_USE_FLG , NULL ,NULL, 'SVC : ' || SVC_USE_FLG||CHR(10))||" ).append("\n"); 
		query.append("     DECODE( CRE_OFC_CD , NULL , NULL, 'Creation Office : ' || CRE_OFC_CD || CHR(10)) CNST_RMK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT POL_NOD_CD POL_CD, N1ST_TS_PORT_CD N1ST_TS_PORT_CD," ).append("\n"); 
		query.append("        N2ND_TS_PORT_CD N2ND_TS_PORT_CD, POD_NOD_CD POD_NOD_CD," ).append("\n"); 
		query.append("        DEL_NOD_CD DEL_CD, ROUT_CNST_RMK, SVC_USE_FLG SVC_USE_FLG," ).append("\n"); 
		query.append("        N1ST_LANE_CD N1ST_LANE_CD," ).append("\n"); 
		query.append("        N2ND_LANE_CD N2ND_LANE_CD," ).append("\n"); 
		query.append("        N3RD_LANE_CD N3RD_LANE_CD" ).append("\n"); 
		query.append("        , VSL_CD || SKD_VOY_NO || SKD_DIR_CD VVD, CMDT_CD -- ADD FOR CONSTRAINT REMARK" ).append("\n"); 
		query.append("        , CRE_OFC_CD CRE_OFC_CD    -- ADD CREATION OFFICE" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT MST.PCTL_NO, R.ROUT_CNST_SEQ ROUT_CNST_SEQ, DECODE(NVL(SVC_USE_FLG, 'Y'), 'N', 'X', 'R')    ROUT_CNST_FLG" ).append("\n"); 
		query.append("              , ROW_NUMBER() OVER (PARTITION BY MST.PCTL_NO" ).append("\n"); 
		query.append("                                   ORDER BY DECODE(R.TRNK_LANE_CD, 'ALL', 1, 0)" ).append("\n"); 
		query.append("                                          , DECODE(R.POL_NOD_CD, 'ALL', 1, 0)" ).append("\n"); 
		query.append("                                          , DECODE(R.POL_NOD_CD, 'ALL', 1, 0)" ).append("\n"); 
		query.append("                                         , R.ROUT_CNST_SEQ DESC ) RN" ).append("\n"); 
		query.append("              , R.*" ).append("\n"); 
		query.append("        FROM PRD_ROUT_CNST R," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT  M.PCTL_NO, POL_CD," ).append("\n"); 
		query.append("                    MAX (DECODE (TS.RK, 1, TS.LANE_CD)) N1ST_LANE_CD, N1ST_TS_PORT_CD," ).append("\n"); 
		query.append("                    MAX (DECODE (TS.RK, 2, TS.LANE_CD)) N2ND_LANE_CD, N2ND_TS_PORT_CD," ).append("\n"); 
		query.append("                    MAX (DECODE (TS.RK, 3, TS.LANE_CD)) N3RD_LANE_CD," ).append("\n"); 
		query.append("                    POD_CD, DEL_NOD_CD," ).append("\n"); 
		query.append("                    MAX (DECODE (TS.RK, 1, TS.VVD)) N1ST_VVD," ).append("\n"); 
		query.append("                    MAX (DECODE (TS.RK, 2, TS.VVD)) N2ND_VVD," ).append("\n"); 
		query.append("                    MAX (DECODE (TS.RK, 3, TS.VVD)) N3RD_VVD," ).append("\n"); 
		query.append("                    MAX (DECODE (TS.RK, 4, TS.VVD)) N4TH_VVD," ).append("\n"); 
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
		query.append("                   AND MTY_YD_FLG = 'N'" ).append("\n"); 
		query.append("                    AND ROWNUM = 1" ).append("\n"); 
		query.append("                    ) POD_NOD" ).append("\n"); 
		query.append("                   ,MAX (DECODE (TS.RK, 1, ORG_NOD_CD )) N1ST_ORG_NOD_CD, MAX (DECODE (TS.RK, 1, DEST_NOD_CD )) N1ST_DEST_NOD_CD" ).append("\n"); 
		query.append("                   ,MAX (DECODE (TS.RK, 2, ORG_NOD_CD )) N2ND_ORG_NOD_CD, MAX (DECODE (TS.RK, 2, DEST_NOD_CD )) N2ND_DEST_NOD_CD" ).append("\n"); 
		query.append("                   ,MAX (DECODE (TS.RK, 3, ORG_NOD_CD )) N3RD_ORG_NOD_CD, MAX (DECODE (TS.RK, 3, DEST_NOD_CD )) N3RD_DEST_NOD_CD" ).append("\n"); 
		query.append("                   ,MAX (M.CMDT_CD) CMDT_CD" ).append("\n"); 
		query.append("            FROM PRD_PROD_CTL_MST M," ).append("\n"); 
		query.append("                 (SELECT PCTL_NO,ORG_NOD_CD,DEST_NOD_CD, VSL_CD || SKD_VOY_NO || SKD_DIR_CD VVD," ).append("\n"); 
		query.append("                         RANK () OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) RK, VSL_SLAN_CD LANE_CD" ).append("\n"); 
		query.append("                    FROM PRD_PROD_CTL_ROUT_DTL DTL, PRD_OCN_ROUT ROUT" ).append("\n"); 
		query.append("                   WHERE PCTL_NO = @[prdCtlNo] AND VSL_SLAN_CD IS NOT NULL" ).append("\n"); 
		query.append("                    AND  DTL.ROUT_ORG_NOD_CD = ROUT.ORG_LOC_CD" ).append("\n"); 
		query.append("                    AND     DTL.ROUT_DEST_NOD_CD = ROUT.DEST_LOC_CD" ).append("\n"); 
		query.append("                    AND     DTL.ROUT_SEQ = ROUT.ROUT_SEQ" ).append("\n"); 
		query.append("                 ) TS" ).append("\n"); 
		query.append("            WHERE M.PCTL_NO = @[prdCtlNo] AND M.PCTL_NO = TS.PCTL_NO(+)" ).append("\n"); 
		query.append("            GROUP BY M.PCTL_NO, POL_CD," ).append("\n"); 
		query.append("                     N1ST_TS_PORT_CD," ).append("\n"); 
		query.append("                     N2ND_TS_PORT_CD," ).append("\n"); 
		query.append("                     POD_CD," ).append("\n"); 
		query.append("                     DEL_NOD_CD," ).append("\n"); 
		query.append("                     TRNK_VSL_CD," ).append("\n"); 
		query.append("                     TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("                     TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("            ) MST," ).append("\n"); 
		query.append("            PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("        WHERE MST.TRNK_LANE = DECODE(R.TRNK_LANE_CD, 'ALL',MST.TRNK_LANE,R.TRNK_LANE_CD)" ).append("\n"); 
		query.append("        AND MST.POL_CD LIKE DECODE(R.POL_NOD_CD, 'ALL', MST.POL_CD, SUBSTR(R.POL_NOD_CD,1,5)||'%')" ).append("\n"); 
		query.append("        AND MST.N1ST_ORG_NOD_CD LIKE DECODE(LENGTH(R.POL_NOD_CD),7,R.POL_NOD_CD, MST.N1ST_ORG_NOD_CD)" ).append("\n"); 
		query.append("        AND MST.POD_NOD LIKE DECODE(R.POD_NOD_CD, 'ALL', MST.POD_CD, R.POD_NOD_CD) ||'%'" ).append("\n"); 
		query.append("        AND NVL(MST.DEL_NOD_CD, R.DEL_NOD_CD) LIKE NVL(R.DEL_NOD_CD, MST.DEL_NOD_CD)||'%'" ).append("\n"); 
		query.append("        AND NVL(MST.N1ST_TS_PORT_CD, ' ') = NVL(R.N1ST_TS_PORT_CD, NVL(MST.N1ST_TS_PORT_CD, ' '))" ).append("\n"); 
		query.append("        AND NVL(MST.N2ND_TS_PORT_CD, ' ') = NVL(R.N2ND_TS_PORT_CD, NVL(MST.N2ND_TS_PORT_CD, ' '))" ).append("\n"); 
		query.append("        AND NVL(MST.N1ST_LANE_CD, ' ') = NVL(R.N1ST_LANE_CD, NVL(MST.N1ST_LANE_CD, ' '))" ).append("\n"); 
		query.append("        AND NVL(MST.N2ND_LANE_CD, ' ') = NVL(R.N2ND_LANE_CD, NVL(MST.N2ND_LANE_CD, ' '))" ).append("\n"); 
		query.append("        AND NVL(MST.N3RD_LANE_CD, ' ') = NVL(R.N3RD_LANE_CD, NVL(MST.N3RD_LANE_CD, ' '))" ).append("\n"); 
		query.append("        AND NVL(MST.CMDT_CD,'#')  = NVL(R.CMDT_CD, NVL(MST.CMDT_CD,'#'))" ).append("\n"); 
		query.append("        AND (   NVL(MST.N1ST_VVD, '#') = NVL(R.VSL_CD || R.SKD_VOY_NO || R.SKD_DIR_CD, NVL(MST.N1ST_VVD, '#'))" ).append("\n"); 
		query.append("             OR NVL(MST.N2ND_VVD, '#') = NVL(R.VSL_CD || R.SKD_VOY_NO || R.SKD_DIR_CD, NVL(MST.N2ND_VVD, '#'))" ).append("\n"); 
		query.append("             OR NVL(MST.N3RD_VVD, '#') = NVL(R.VSL_CD || R.SKD_VOY_NO || R.SKD_DIR_CD, NVL(MST.N3RD_VVD, '#'))" ).append("\n"); 
		query.append("             OR NVL(MST.N4TH_VVD, '#') = NVL(R.VSL_CD || R.SKD_VOY_NO || R.SKD_DIR_CD, NVL(MST.N4TH_VVD, '#'))" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("        AND MST.PCTL_NO = Q.PCTL_NO" ).append("\n"); 
		query.append("        AND NVL(R.CNTR_TP_CD, Q.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("            = DECODE(R.CNTR_TP_CD, NULL, Q.CNTR_TPSZ_CD, DECODE(SUBSTR(Q.CNTR_TPSZ_CD, 1, 1), 'T', 'T', 'O', 'S', 'F', 'S'," ).append("\n"); 
		query.append("                                                                --'D',DECODE(Q.CNTR_TPSZ_CD, 'D5', 'D5', 'D7', 'D7', Q.CNTR_TPSZ_CD)," ).append("\n"); 
		query.append("                                                                --'R',DECODE(Q.CNTR_TPSZ_CD, 'R2', 'R2', 'R5', 'R5', Q.CNTR_TPSZ_CD)) )" ).append("\n"); 
		query.append("                                                                'D',Q.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                                                'R',Q.CNTR_TPSZ_CD) )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE @[cnstFlg] IN ('A','X','O','P','R')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT 'Link : ' || LNK_ORG_NOD_CD || ' - ' || LNK_DEST_NOD_CD || CHR(10) ||" ).append("\n"); 
		query.append("    'ITEM : ' ||PCTL_CNST_ITM_NM || CHR(10) ||" ).append("\n"); 
		query.append("    DECODE( CNTR_TP_CD , NULL , NULL, 'CNTR TYPE : ' || CNTR_TP_CD || CHR(10)) ||" ).append("\n"); 
		query.append("    DECODE( VSL_SLAN_CD , NULL , NULL, 'LANE : ' || VSL_SLAN_CD || CHR(10)) || -- ADD FOR CONSTRAINT REMARK" ).append("\n"); 
		query.append("    DECODE( VVD , NULL , NULL, 'VVD : ' || VVD || CHR(10)) || -- ADD FOR CONSTRAINT REMARK" ).append("\n"); 
		query.append("    DECODE( CMDT_CD , NULL , NULL, 'CMDT : ' || CMDT_CD || CHR(10)) ||" ).append("\n"); 
		query.append("    DECODE( LNK_CNST_RMK , NULL , NULL, 'Remark : ' || LNK_CNST_RMK ||CHR(10)) ||" ).append("\n"); 
		query.append("    DECODE( SVC_USE_FLG , NULL , NULL, 'SVC : ' || SVC_USE_FLG || CHR(10)) ||  " ).append("\n"); 
		query.append("    DECODE( CRE_OFC_CD , NULL , NULL, 'Creation Office : ' || CRE_OFC_CD || CHR(10)) CNST_RMK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        C.LNK_ORG_NOD_CD LNK_ORG_NOD_CD ," ).append("\n"); 
		query.append("        C.LNK_DEST_NOD_CD LNK_DEST_NOD_CD," ).append("\n"); 
		query.append("        PCTL_CNST_ITM_NM PCTL_CNST_ITM_NM," ).append("\n"); 
		query.append("        C.CNTR_TP_CD CNTR_TP_CD ," ).append("\n"); 
		query.append("        C.VSL_SLAN_CD VSL_SLAN_CD, -- ADD FOR CONSTRAINT REMARK" ).append("\n"); 
		query.append("        C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD VVD,  -- ADD FOR CONSTRAINT REMARK" ).append("\n"); 
		query.append("        C.CMDT_CD CMDT_CD," ).append("\n"); 
		query.append("        C.LNK_CNST_RMK LNK_CNST_RMK," ).append("\n"); 
		query.append("        SVC_USE_FLG SVC_USE_FLG," ).append("\n"); 
		query.append("        C.CRE_OFC_CD CRE_OFC_CD    -- ADD CREATION OFFICE" ).append("\n"); 
		query.append("    FROM PRD_LNK_CNST_MGMT C, PRD_PROD_CTL_QTY Q , PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("    ,PRD_PROD_CTL_MST M" ).append("\n"); 
		query.append("    WHERE d.pctl_no = @[prdCtlNo]" ).append("\n"); 
		query.append("    AND M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("    AND D.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("    and D.PCTL_NO = Q.PCTL_NO" ).append("\n"); 
		query.append("    AND D.ORG_NOD_CD LIKE C.LNK_ORG_NOD_CD||'%'" ).append("\n"); 
		query.append("    AND D.DEST_NOD_CD LIKE C.LNK_DEST_NOD_CD||'%'" ).append("\n"); 
		query.append("    AND DECODE(D.TRSP_MOD_CD, 'VD', 'WD', D.TRSP_MOD_CD) = DECODE(C.TRSP_MOD_CD, 'AL' ,DECODE(D.TRSP_MOD_CD, 'VD', 'WD', D.TRSP_MOD_CD), C.TRSP_MOD_CD )" ).append("\n"); 
		query.append("    AND NVL(D.VSL_SLAN_CD, '#') = DECODE(C.VSL_SLAN_CD, NULL, NVL(D.VSL_SLAN_CD, '#'), C.VSL_SLAN_CD)" ).append("\n"); 
		query.append("    AND NVL(D.VSL_CD || D.SKD_VOY_NO || D.SKD_DIR_CD, '#') = DECODE(C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD, NULL, NVL(D.VSL_CD || D.SKD_VOY_NO || D.SKD_DIR_CD, '#'), C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD)" ).append("\n"); 
		query.append("    AND NVL(M.CMDT_CD,'X')  = NVL(C.CMDT_CD, NVL(M.CMDT_CD,'X'))" ).append("\n"); 
		query.append("    AND NVL(C.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("    AND NVL(C.CNTR_TP_CD, Q.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("       = DECODE(C.CNTR_TP_CD, NULL, Q.CNTR_TPSZ_CD, DECODE(SUBSTR(Q.CNTR_TPSZ_CD, 1, 1), 'T', 'T', 'O', 'S', 'F', 'S'," ).append("\n"); 
		query.append("                                                           --'D',DECODE(Q.CNTR_TPSZ_CD, 'D5', 'D5', 'D7', 'D7', Q.CNTR_TPSZ_CD)," ).append("\n"); 
		query.append("                                                           --'R',DECODE(Q.CNTR_TPSZ_CD, 'R2', 'R2', 'R5', 'R5', Q.CNTR_TPSZ_CD)) )" ).append("\n"); 
		query.append("                                                           'D',Q.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                                           'R',Q.CNTR_TPSZ_CD) )" ).append("\n"); 
		query.append("    AND (" ).append("\n"); 
		query.append("               -- 사용자 요청으로 PC생성일 기준으로 변경" ).append("\n"); 
		query.append("               TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= M.CRE_DT AND" ).append("\n"); 
		query.append("               M.CRE_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    AND D.ORG_NOD_CD = @[org_nod_cd]" ).append("\n"); 
		query.append("    AND D.DEST_NOD_CD = @[dest_nod_cd]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE @[cnstFlg] IN ('A','X','O','I','L')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT 'Location : ' || NOD_CD || DECODE(PORT_PNT_CD, 'ALL', '', ' : '||DECODE(PORT_PNT_CD,'TS','T/S',PORT_PNT_CD))|| CHR(10) ||" ).append("\n"); 
		query.append("    'ITEM : ' ||PCTL_CNST_ITM_NM || CHR(10) ||" ).append("\n"); 
		query.append("    DECODE( CNTR_TP_CD , NULL ,NULL, 'CNTR TYPE : ' || CNTR_TP_CD || CHR(10)) ||" ).append("\n"); 
		query.append("    DECODE( VSL_SLAN_CD , NULL ,NULL, 'LANE : ' || VSL_SLAN_CD || CHR(10)) || -- ADD FOR CONSTRAINT REMARK" ).append("\n"); 
		query.append("    DECODE( VVD , NULL ,NULL, 'VVD : '|| VVD|| CHR(10)) || -- ADD FOR CONSTRAINT REMARK" ).append("\n"); 
		query.append("    DECODE( CMDT_CD , NULL ,NULL, 'CMDT : ' || CMDT_CD|| CHR(10)) ||" ).append("\n"); 
		query.append("    DECODE( NOD_CNST_RMK , NULL ,NULL, 'Remark : ' || NOD_CNST_RMK|| CHR(10)) ||" ).append("\n"); 
		query.append("    DECODE( SVC_USE_FLG , NULL ,NULL, 'SVC : ' || SVC_USE_FLG|| CHR(10)) ||" ).append("\n"); 
		query.append("    DECODE( CRE_OFC_CD , NULL ,NULL, 'Creation Office : ' || CRE_OFC_CD) CNST_RMK " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        C.NOD_CD NOD_CD" ).append("\n"); 
		query.append("        ,C.PCTL_CNST_ITM_NM PCTL_CNST_ITM_NM" ).append("\n"); 
		query.append("        ,C.CNTR_TP_CD CNTR_TP_CD" ).append("\n"); 
		query.append("        ,C.VSL_SLAN_CD VSL_SLAN_CD -- ADD FOR CONSTRAINT REMARK" ).append("\n"); 
		query.append("        ,C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD VVD  -- ADD FOR CONSTRAINT REMARK" ).append("\n"); 
		query.append("        ,C.CMDT_CD CMDT_CD" ).append("\n"); 
		query.append("        ,C.NOD_CNST_RMK NOD_CNST_RMK" ).append("\n"); 
		query.append("        ,SVC_USE_FLG SVC_USE_FLG" ).append("\n"); 
		query.append("        ,D.PCTL_NO" ).append("\n"); 
		query.append("        ,C.PORT_PNT_CD, D.PCTL_SEQ" ).append("\n"); 
		query.append("        ,C.CRE_OFC_CD CRE_OFC_CD    -- ADD CREATION OFFICE" ).append("\n"); 
		query.append("            FROM PRD_NOD_CNST_MGMT C" ).append("\n"); 
		query.append("               , PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("                ,PRD_PROD_CTL_MST M" ).append("\n"); 
		query.append("               , (SELECT PCTL_NO, PCTL_SEQ, ORG_NOD_CD, NOD_LNK_DIV_CD, PCTL_IO_BND_CD, MTY_YD_FLG, ARR_ST_DT, DEP_FSH_DT" ).append("\n"); 
		query.append("                         , LEAD (VSL_SLAN_CD) OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) POL_SLAN_CD" ).append("\n"); 
		query.append("                         , LEAD (VSL_CD || SKD_VOY_NO || SKD_DIR_CD) OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) POL_VVD" ).append("\n"); 
		query.append("                         , LAG (VSL_SLAN_CD) OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) POD_SLAN_CD" ).append("\n"); 
		query.append("                         , LAG  (VSL_CD || SKD_VOY_NO || SKD_DIR_CD) OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) POD_VVD" ).append("\n"); 
		query.append("                    FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                    WHERE PCTL_NO = @[prdCtlNo]" ).append("\n"); 
		query.append("                     AND ORG_NOD_CD = @[nod_cd]) D" ).append("\n"); 
		query.append("             WHERE M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("             AND D.PCTL_NO = Q.PCTL_NO" ).append("\n"); 
		query.append("             AND D.ORG_NOD_CD LIKE DECODE(C.NOD_CD, 'ALL','%',C.NOD_CD||'%')" ).append("\n"); 
		query.append("             AND NVL(M.CMDT_CD,'X')  = NVL(C.CMDT_CD, NVL(M.CMDT_CD,'X'))" ).append("\n"); 
		query.append("             AND NVL(C.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("             AND NVL(C.CNTR_TP_CD, Q.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                = DECODE(C.CNTR_TP_CD, NULL, Q.CNTR_TPSZ_CD, DECODE(SUBSTR(Q.CNTR_TPSZ_CD, 1, 1), 'T', 'T', 'O', 'S', 'F', 'S'," ).append("\n"); 
		query.append("                                                                    --'D',DECODE(Q.CNTR_TPSZ_CD, 'D5', 'D5', 'D7', 'D7', Q.CNTR_TPSZ_CD)," ).append("\n"); 
		query.append("                                                                    --'R',DECODE(Q.CNTR_TPSZ_CD, 'R2', 'R2', 'R5', 'R5', Q.CNTR_TPSZ_CD)))" ).append("\n"); 
		query.append("                                                'D',Q.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                                'R',Q.CNTR_TPSZ_CD) )" ).append("\n"); 
		query.append("             AND (" ).append("\n"); 
		query.append("       	                -- 사용자 요청으로 PC생성일 기준으로 변경" ).append("\n"); 
		query.append("                        TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= M.CRE_DT AND" ).append("\n"); 
		query.append("                        M.CRE_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("             AND D.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("            -- NOD_LNK_DIV_CD = 'N' 인경우 (NODE 일경우엔) LANE 정보가 없는게 당연하다." ).append("\n"); 
		query.append("            -- AND NVL(C.VSL_SLAN_CD, '#') IN (D.POL_SLAN_CD, D.POD_SLAN_CD, DECODE(C.VSL_SLAN_CD, NULL, '#'))" ).append("\n"); 
		query.append("             AND NVL(C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD, '#') IN (D.POL_VVD, D.POD_VVD, DECODE(C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD, NULL, '#'))" ).append("\n"); 
		query.append("             ORDER BY DECODE(NVL(SVC_USE_FLG,'Y'),'N',1,2)" ).append("\n"); 
		query.append("     ) CC" ).append("\n"); 
		query.append("WHERE (" ).append("\n"); 
		query.append("          NVL(CC.port_pnt_cd, 'ALL') = 'ALL' OR" ).append("\n"); 
		query.append("          CC.port_pnt_cd IN (" ).append("\n"); 
		query.append("              (SELECT CASE" ).append("\n"); 
		query.append("                  WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                      WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                      AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                      AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                      AND MTY_YD_FLG = 'N'  ) THEN 'POR'" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("              FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("              WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("              AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("              and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("              AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("              )," ).append("\n"); 
		query.append("              (SELECT CASE" ).append("\n"); 
		query.append("                  WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                      WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                      AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                      AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                      AND MTY_YD_FLG = 'N'  ) THEN 'POL'" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("              FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("              WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("              AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("              and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("              AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("              )," ).append("\n"); 
		query.append("              (SELECT CASE" ).append("\n"); 
		query.append("                  WHEN PCTL_SEQ  IN (SELECT  PCTL_SEQ FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                      WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                      AND PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("                      AND NOD_LNK_DIV_CD = 'N'  ) THEN 'TS'" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("              FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("              WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("              AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("              and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("              AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("              )," ).append("\n"); 
		query.append("              (SELECT CASE" ).append("\n"); 
		query.append("                  WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                      WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                      AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                      AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                      AND MTY_YD_FLG = 'N'  ) THEN 'POD'" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("              FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("              WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("              AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("              and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("              AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("              )," ).append("\n"); 
		query.append("              (SELECT CASE" ).append("\n"); 
		query.append("                  WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                      WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                      AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                      AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                      AND MTY_YD_FLG = 'N'  ) THEN 'DEL'" ).append("\n"); 
		query.append("                  END" ).append("\n"); 
		query.append("              FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("              WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("              AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("              and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("              AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("AND @[cnstFlg] IN ('A','X','P','I','N')" ).append("\n"); 

	}
}