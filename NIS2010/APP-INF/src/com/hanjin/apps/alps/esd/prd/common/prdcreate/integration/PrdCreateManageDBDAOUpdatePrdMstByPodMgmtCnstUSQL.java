/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdatePrdMstByPodMgmtCnstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOUpdatePrdMstByPodMgmtCnstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1. Inland Route POD Management에서 정의한 Constraint를 적용한다.
	  * 2. 2011.07.04 이수진 [CHM-201111709] PRD > Network Constraint 관련 data upload 및 기능개선 요청
	  * </pre>
	  */
	public PrdCreateManageDBDAOUpdatePrdMstByPodMgmtCnstUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAOUpdatePrdMstByPodMgmtCnstUSQL").append("\n"); 
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
		query.append("-- match되는 경우에만 update하기 위해 사용한다." ).append("\n"); 
		query.append("MERGE INTO PRD_PROD_CTL_MST T" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("    SELECT PCTL_NO,SLAN_CD, POD_CD, DEL_CD ,BKG_DE_TERM_CD, TRSP_MOD_CD, BKG_RMK, DECODE(NVL(APLY_SVC_MOD_FLG, 'Y'), 'N', 'X', 'R') APLY_SVC_MOD_FLG" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT PCTL_NO, CNST.SLAN_CD, CNST.POD_CD, CNST.DEL_CD, BKG_DE_TERM_CD, TRSP_MOD_CD, BKG_RMK, APLY_SVC_MOD_FLG" ).append("\n"); 
		query.append("--                     , ROW_NUMBER() OVER (PARTITION BY PCTL_NO ORDER BY DECODE(BKG_DE_TERM_CD, 'A', 1, 0), DECODE(TRSP_MOD_CD, 'AL', 1, 0)) ODR" ).append("\n"); 
		query.append("                     , ROW_NUMBER() OVER (PARTITION BY PCTL_NO ORDER BY  " ).append("\n"); 
		query.append("                                                        DECODE(INSTR(NVL(PCTL_IMDG_CLSS_CTNT, NVL(COLUMN_VALUE,'XX')) ,NVL(COLUMN_VALUE,'XX') ) , 0, 999,0) ," ).append("\n"); 
		query.append("                                                        DECODE(APLY_SVC_MOD_FLG,'Y',1,0),DECODE(BKG_DE_TERM_CD, 'A', 1, 0), DECODE(TRSP_MOD_CD, 'AL', 1, 0)) ODR" ).append("\n"); 
		query.append("					 , COLUMN_VALUE BKG_IMDG -- 입력된 BKG IMDG" ).append("\n"); 
		query.append("                     , PCTL_IMDG_CLSS_CTNT -- POD_MGMT 에 등록된 IMDG " ).append("\n"); 
		query.append("                     -- BKG 에서 받은 IMDG 값들이 POD_MGMT 에 포함되는지 확인-- BKG 에서 받은 IMDG는 단건으로 분리하여 ROW별로 처리 한다." ).append("\n"); 
		query.append("					 , INSTR(NVL(PCTL_IMDG_CLSS_CTNT, NVL(COLUMN_VALUE,'XX')) ,NVL(COLUMN_VALUE,'XX') ) INSTR_VAL -- POD_IMDG 에 등록된 값중 BKG의 값이 있는 위치 INDEX" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT PCTL_NO, IO_BND_CD, POD_CD, DEL_CD, TERM_CD" ).append("\n"); 
		query.append("                  , SLAN_CD, FDR_SLAN_CD" ).append("\n"); 
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
		query.append("                    , MAX(VSL_FDR_SLAN_CD) FDR_SLAN_CD" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                    SELECT PMST.PCTL_NO, PDTL.PCTL_SEQ, PMST.POR_CD, PMST.POL_CD, PMST.POD_CD, PMST.DEL_CD , PMST.BKG_RCV_TERM_CD, PMST.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("                          , DECODE(PDTL.PCTL_IO_BND_CD, 'O','O','I','I'" ).append("\n"); 
		query.append("                                  , DECODE(PDTL.PCTL_SEQ, MIN(PDTL.PCTL_SEQ) OVER (PARTITION BY PMST.PCTL_NO, PDTL.PCTL_IO_BND_CD), 'O')" ).append("\n"); 
		query.append("                                  )  IO_BND_CD" ).append("\n"); 
		query.append("                          , PDTL.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                       , PDTL.PCTL_SEQ" ).append("\n"); 
		query.append("                        , SUBSTR(PDTL.TRSP_MOD_CD,1,1) TRSP_MOD" ).append("\n"); 
		query.append("                        , DECODE(PDTL.PCTL_IO_BND_CD, 'T', NULL, ROW_NUMBER() OVER (PARTITION BY PMST.PCTL_NO, PDTL.PCTL_IO_BND_CD ORDER BY PCTL_SEQ)) RN" ).append("\n"); 
		query.append("                        , PDTL.VSL_SLAN_CD, DECODE(MLAN.VSL_SVC_TP_CD, 'O', 'FDR') VSL_FDR_SLAN_CD" ).append("\n"); 
		query.append("                        , decode(pdtl.pctl_seq, min(pdtl.pctl_seq) over (partition by pmst.pctl_no), 'X'" ).append("\n"); 
		query.append("                                              , max(pdtl.pctl_seq) over (partition by pmst.pctl_no), 'X'" ).append("\n"); 
		query.append("                                              , 'Y' ) use_pctl" ).append("\n"); 
		query.append("                    FROM PRD_PROD_CTL_MST PMST" ).append("\n"); 
		query.append("                       , PRD_PROD_CTL_ROUT_DTL PDTL" ).append("\n"); 
		query.append("                       , MDM_VSL_SVC_LANE MLAN" ).append("\n"); 
		query.append("                    WHERE PMST.PCTL_NO LIKE DECODE(@[hd_pctl_no], NULL, NULL, @[hd_pctl_no] ||'%')" ).append("\n"); 
		query.append("                    AND PMST.PCTL_NO = PDTL.PCTL_NO" ).append("\n"); 
		query.append("                    AND PDTL.TRSP_MOD_CD <> 'X'" ).append("\n"); 
		query.append("                    AND PDTL.PCTL_IO_BND_CD IN ('O','T')" ).append("\n"); 
		query.append("                    AND MLAN.VSL_SLAN_CD(+) = PDTL.VSL_SLAN_CD" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT PMST.PCTL_NO, PDTL.PCTL_SEQ, PMST.POR_CD, PMST.POL_CD, PMST.POD_CD, PMST.DEL_CD , PMST.BKG_RCV_TERM_CD, PMST.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("                          , DECODE(PDTL.PCTL_IO_BND_CD, 'O','O','I','I'" ).append("\n"); 
		query.append("                                  , DECODE(PDTL.PCTL_SEQ, MAX(PDTL.PCTL_SEQ) OVER (PARTITION BY PMST.PCTL_NO, PDTL.PCTL_IO_BND_CD), 'I')" ).append("\n"); 
		query.append("                                  )  IO_BND_CD" ).append("\n"); 
		query.append("                          , PDTL.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                       , PDTL.PCTL_SEQ" ).append("\n"); 
		query.append("                        , SUBSTR(PDTL.TRSP_MOD_CD,1,1) TRSP_MOD" ).append("\n"); 
		query.append("                        , DECODE(PDTL.PCTL_IO_BND_CD, 'T', NULL, ROW_NUMBER() OVER (PARTITION BY PMST.PCTL_NO, PDTL.PCTL_IO_BND_CD ORDER BY PCTL_SEQ)) RN" ).append("\n"); 
		query.append("                        , PDTL.VSL_SLAN_CD, DECODE(MLAN.VSL_SVC_TP_CD, 'O', 'FDR') VSL_FDR_SLAN_CD" ).append("\n"); 
		query.append("                        , decode(pdtl.pctl_seq, min(pdtl.pctl_seq) over (partition by pmst.pctl_no), 'X'" ).append("\n"); 
		query.append("                                              , max(pdtl.pctl_seq) over (partition by pmst.pctl_no), 'X'" ).append("\n"); 
		query.append("                                              , 'Y' ) use_pctl" ).append("\n"); 
		query.append("                    FROM PRD_PROD_CTL_MST PMST" ).append("\n"); 
		query.append("                       , PRD_PROD_CTL_ROUT_DTL PDTL" ).append("\n"); 
		query.append("                       , MDM_VSL_SVC_LANE MLAN" ).append("\n"); 
		query.append("                    WHERE PMST.PCTL_NO LIKE DECODE(@[hd_pctl_no], NULL, NULL, @[hd_pctl_no] ||'%')" ).append("\n"); 
		query.append("                    AND PMST.PCTL_NO = PDTL.PCTL_NO" ).append("\n"); 
		query.append("                    AND PDTL.TRSP_MOD_CD <> 'X'" ).append("\n"); 
		query.append("                    AND PDTL.PCTL_IO_BND_CD IN ('I','T')" ).append("\n"); 
		query.append("                    AND MLAN.VSL_SLAN_CD(+) = PDTL.VSL_SLAN_CD" ).append("\n"); 
		query.append("                     ) " ).append("\n"); 
		query.append("                WHERE IO_BND_CD IS NOT NULL" ).append("\n"); 
		query.append("                GROUP BY PCTL_NO, IO_BND_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("           ) SUBX" ).append("\n"); 
		query.append("           , PRD_POD_MGMT CNST" ).append("\n"); 
		query.append("		   --, TABLE(SELECT BKG_SPLIT_FNC( _[imdg], ',') IMDG_TBL_STR FROM DUAL) BKG_IMDG" ).append("\n"); 
		query.append("           , TABLE(SELECT BKG_SPLIT_FNC(" ).append("\n"); 
		query.append("                            TO_CHAR(BKG_JOIN_CLOB_FNC( CURSOR(SELECT DISTINCT IMDG_CLSS_CD " ).append("\n"); 
		query.append("                                                          FROM BKG_DG_CGO DG " ).append("\n"); 
		query.append("                                                          WHERE DG.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                                                        AND DG.IMDG_CLSS_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                                                 AND NVL(DG.SPCL_CGO_APRO_CD, 'N') <> 'C' )" ).append("\n"); 
		query.append("                             )) ,',') IMDG_TBL_STR FROM DUAL) BKG_IMDG" ).append("\n"); 
		query.append("        WHERE INSTR(SUBX.SLAN_CD || ',' || SUBX.FDR_SLAN_CD || ',ALL', CNST.SLAN_CD) > 0" ).append("\n"); 
		query.append("          AND SUBX.IO_BND_CD = CNST.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("          AND SUBX.POD_CD    = DECODE(CNST.POD_CD, 'ALL', SUBX.POD_CD, CNST.POD_CD)" ).append("\n"); 
		query.append("          AND SUBX.DEL_CD    = DECODE(CNST.DEL_CD, 'ALL', SUBX.DEL_CD, CNST.DEL_CD)" ).append("\n"); 
		query.append("          AND SUBX.TERM_CD   = DECODE(CNST.BKG_DE_TERM_CD, 'A', SUBX.TERM_CD, CNST.BKG_DE_TERM_CD)" ).append("\n"); 
		query.append("          AND SUBX.TRSP_MOD  = DECODE(CNST.TRSP_MOD_CD, 'AL', SUBX.TRSP_MOD, CNST.TRSP_MOD_CD)" ).append("\n"); 
		query.append("          AND NVL(CNST.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    WHERE ODR = 1" ).append("\n"); 
		query.append("      AND INSTR_VAL > 0" ).append("\n"); 
		query.append("    ) S" ).append("\n"); 
		query.append("ON (S.PCTL_NO = T.PCTL_NO)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET T.CNST_FLG = DECODE(T.CNST_FLG, 'X', 'X', S.APLY_SVC_MOD_FLG)" ).append("\n"); 

	}
}