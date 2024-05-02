/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SalesRPTDBDAOsearchBkg0061ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOsearchBkg0061ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_COP_HDR, BKG_BOOKING, _BKG_INFO, _BKG_COST_DTL 테이블의 데이터 조회
	  * 
	  * 
	  * 1. 관련 Table : BKG Info
	  * 2. 조건 :  BKG INFo Table에서 조회 조건으로 where조건 구성
	  * 3. Route 정보만 넘김
	  * 
	  * 2012.03.12 김종준 [CHM-201216637-01] Inquiry by BKG 화면에 Bill Type Indicator 추가
	  * 2015.06.26 손진환 [CHM-201536375] Inquiry by BKG 상 Route 중복 건 수정
	  * 2015.12.18 김성욱 [CHM-201539370] [MAS] Inquiry by BKG 상 Route No. 조회 불가 건 조치
	  * 2015.12.30 김성욱 [CHM-201539370] [MAS] Inquiry by BKG 상 Route No. 조회 불가 건 조치- 수정
	  * </pre>
	  */
	public SalesRPTDBDAOsearchBkg0061ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOsearchBkg0061ListRSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("QTY AS ( " ).append("\n"); 
		query.append("     -- QTY물량 " ).append("\n"); 
		query.append("      SELECT A1.BKG_NO " ).append("\n"); 
		query.append("            ,A1.PCTL_NO " ).append("\n"); 
		query.append("            ,A1.COP_NO " ).append("\n"); 
		query.append("            ,A2.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("            ,SUM(A2.OP_CNTR_QTY)                          QTY " ).append("\n"); 
		query.append("            ,NVL(DECODE(A2.AWK_CGO_QTY,0, 'N', 'Y'), 'N') AWK_CGO_FLG " ).append("\n"); 
		query.append("            ,NVL(DECODE(A2.DCGO_QTY   ,0, 'N', 'Y'), 'N') DCGO_FLG " ).append("\n"); 
		query.append("            ,NVL(DECODE(A2.RC_QTY     ,0, 'N', 'Y'), 'N') RC_FLG " ).append("\n"); 
		query.append("            ,NVL(DECODE(A2.BB_CGO_QTY ,0, 'N', 'Y'), 'N') BB_CGO_FLG " ).append("\n"); 
		query.append("            ,NVL(DECODE(A2.SOC_QTY    ,0, 'N', 'Y'), 'N') SOC_FLG " ).append("\n"); 
		query.append("            ,DECODE(SUBSTR(A2.CNTR_TPSZ_CD,1,1),'R',DECODE(SUBSTR(A2.EQ_SUBST_CNTR_TPSZ_CD,1,1),'D','Y', 'N'), 'N') RD_CGO_FLG  " ).append("\n"); 
		query.append("            ,A3.FLEX_HGT_FLG " ).append("\n"); 
		query.append("            ,A3.RCV_TERM_CD " ).append("\n"); 
		query.append("            ,A3.DE_TERM_CD " ).append("\n"); 
		query.append("            -- [CHM-201327649] Container Confirm" ).append("\n"); 
		query.append("            ,NVL((SELECT 'Y' FROM BKG_DOC_PROC_SKD WHERE BKG_DOC_PROC_TP_CD ='CNTCFM'  AND DOC_PERF_DELT_FLG ='N'  AND BKG_NO = @[f_bkg_no]), 'N') AS CNTR_CFM_FLG" ).append("\n"); 
		query.append("        FROM SCE_COP_HDR  A1 " ).append("\n"); 
		query.append("            ,BKG_QUANTITY A2 " ).append("\n"); 
		query.append("            ,BKG_BOOKING  A3 " ).append("\n"); 
		query.append("       WHERE A1.BKG_NO = @[f_bkg_no] " ).append("\n"); 
		query.append("         AND A1.BKG_NO = A2.BKG_NO " ).append("\n"); 
		query.append("         AND A1.BKG_NO = A3.BKG_NO " ).append("\n"); 
		query.append("         AND A1.COP_NO = SCE_REP_COP_NO_FNC(A2.BKG_NO, A2.CNTR_TPSZ_CD) " ).append("\n"); 
		query.append("    GROUP BY A1.BKG_NO " ).append("\n"); 
		query.append("            ,A1.PCTL_NO " ).append("\n"); 
		query.append("            ,A1.COP_NO " ).append("\n"); 
		query.append("            ,A2.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("            ,NVL(DECODE(A2.AWK_CGO_QTY,0, 'N', 'Y'), 'N') " ).append("\n"); 
		query.append("            ,NVL(DECODE(A2.DCGO_QTY   ,0, 'N', 'Y'), 'N') " ).append("\n"); 
		query.append("            ,NVL(DECODE(A2.RC_QTY     ,0, 'N', 'Y'), 'N') " ).append("\n"); 
		query.append("            ,NVL(DECODE(A2.BB_CGO_QTY ,0, 'N', 'Y'), 'N') " ).append("\n"); 
		query.append("            ,NVL(DECODE(A2.SOC_QTY    ,0, 'N', 'Y'), 'N') " ).append("\n"); 
		query.append("            ,DECODE(SUBSTR(A2.CNTR_TPSZ_CD,1,1),'R',DECODE(SUBSTR(A2.EQ_SUBST_CNTR_TPSZ_CD,1,1),'D','Y', 'N') , 'N') " ).append("\n"); 
		query.append("            ,A3.FLEX_HGT_FLG " ).append("\n"); 
		query.append("            ,A3.RCV_TERM_CD " ).append("\n"); 
		query.append("            ,A3.DE_TERM_CD " ).append("\n"); 
		query.append("   ) " ).append("\n"); 
		query.append(",CNTR AS ( " ).append("\n"); 
		query.append("      -- CNTR물량 " ).append("\n"); 
		query.append("      SELECT A2.BKG_NO " ).append("\n"); 
		query.append("            ,A3.PCTL_NO " ).append("\n"); 
		query.append("            ,A3.COP_NO " ).append("\n"); 
		query.append("            ,A3.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("            ,SUM(A2.CNTR_VOL_QTY)     QTY " ).append("\n"); 
		query.append("            ,NVL(A2.AWK_CGO_FLG, 'N') AWK_CGO_FLG " ).append("\n"); 
		query.append("            ,NVL(A2.DCGO_FLG   , 'N') DCGO_FLG " ).append("\n"); 
		query.append("            ,NVL(A2.RC_FLG     , 'N') RC_FLG " ).append("\n"); 
		query.append("            ,NVL(A2.BB_CGO_FLG , 'N') BB_CGO_FLG " ).append("\n"); 
		query.append("            ,NVL(A2.SOC_FLG    , 'N') SOC_FLG " ).append("\n"); 
		query.append("            ,NVL(A2.RD_CGO_FLG , 'N') RD_CGO_FLG " ).append("\n"); 
		query.append("            ,A1.FLEX_HGT_FLG " ).append("\n"); 
		query.append("            ,A2.RCV_TERM_CD " ).append("\n"); 
		query.append("            ,A2.DE_TERM_CD " ).append("\n"); 
		query.append("            -- [CHM-201327649] Container Confirm" ).append("\n"); 
		query.append("            ,NVL((SELECT 'Y' FROM BKG_DOC_PROC_SKD WHERE BKG_DOC_PROC_TP_CD ='CNTCFM'  AND DOC_PERF_DELT_FLG ='N'  AND BKG_NO = @[f_bkg_no]), 'N') AS CNTR_CFM_FLG" ).append("\n"); 
		query.append("        FROM BKG_CONTAINER A2 " ).append("\n"); 
		query.append("            ,SCE_COP_HDR   A3 " ).append("\n"); 
		query.append("            ,BKG_BOOKING   A1 " ).append("\n"); 
		query.append("            ,( " ).append("\n"); 
		query.append("                SELECT COUNT(*) CNT " ).append("\n"); 
		query.append("                  FROM BKG_BOOKING " ).append("\n"); 
		query.append("                 WHERE BKG_NO             = @[f_bkg_no] " ).append("\n"); 
		query.append("                   AND NVL(BL_NO_TP,'0') <> '0' " ).append("\n"); 
		query.append("             ) A4 " ).append("\n"); 
		query.append("       WHERE A2.BKG_NO       = @[f_bkg_no] " ).append("\n"); 
		query.append("         AND A2.BKG_NO       = A3.BKG_NO " ).append("\n"); 
		query.append("         AND A3.CNTR_NO      = A2.CNTR_NO " ).append("\n"); 
		query.append("         AND A3.BKG_NO       = A1.BKG_NO " ).append("\n"); 
		query.append("         AND A3.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("         AND (     A4.CNT = 0 AND A3.COP_STS_CD   NOT IN ('X','M','O') -- 일반 BKG 일경우 " ).append("\n"); 
		query.append("               OR  A4.CNT > 0 AND A3.COP_STS_CD   NOT IN ('M','O')     -- Memo split의 원부킹 일경우 " ).append("\n"); 
		query.append("             ) " ).append("\n"); 
		query.append("    GROUP BY A2.BKG_NO " ).append("\n"); 
		query.append("            ,A3.PCTL_NO " ).append("\n"); 
		query.append("            ,A3.COP_NO " ).append("\n"); 
		query.append("            ,A3.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("            ,A2.AWK_CGO_FLG " ).append("\n"); 
		query.append("            ,NVL(A2.AWK_CGO_FLG, 'N') " ).append("\n"); 
		query.append("            ,NVL(A2.DCGO_FLG   , 'N') " ).append("\n"); 
		query.append("            ,NVL(A2.RC_FLG     , 'N') " ).append("\n"); 
		query.append("            ,NVL(A2.BB_CGO_FLG , 'N') " ).append("\n"); 
		query.append("            ,NVL(A2.SOC_FLG    , 'N') " ).append("\n"); 
		query.append("            ,NVL(A2.RD_CGO_FLG , 'N') " ).append("\n"); 
		query.append("            ,A1.FLEX_HGT_FLG " ).append("\n"); 
		query.append("            ,A2.RCV_TERM_CD " ).append("\n"); 
		query.append("            ,A2.DE_TERM_CD " ).append("\n"); 
		query.append("   ) " ).append("\n"); 
		query.append("         ,ROUTE AS ( " ).append("\n"); 
		query.append("                      SELECT D1.BKG_NO " ).append("\n"); 
		query.append("                            ,D1.COP_NO " ).append("\n"); 
		query.append("                            ,D1.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                            ,D2.COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("                            ,D1.SPCL_FLG " ).append("\n"); 
		query.append("                            ,D1.RCV_TERM_CD " ).append("\n"); 
		query.append("                            ,D1.DE_TERM_CD " ).append("\n"); 
		query.append("                            ,D1.QTY " ).append("\n"); 
		query.append("                            ,ROW_NUMBER() OVER (PARTITION BY D1.BKG_NO,D1.COP_NO,D1.CNTR_TPSZ_CD ORDER BY D2.COST_ACT_GRP_SEQ) RN " ).append("\n"); 
		query.append("                            ,    D2.COST_ACT_GRP_CD " ).append("\n"); 
		query.append("                              || NVL(D2.N1ST_NOD_CD, 'XXXXXXX') " ).append("\n"); 
		query.append("                              || NVL(D2.N2ND_NOD_CD, 'XXXXXXX') " ).append("\n"); 
		query.append("                              || NVL(D2.N3RD_NOD_CD, 'XXXXXXX') " ).append("\n"); 
		query.append("                              || NVL(D2.N4TH_NOD_CD, 'XXXXXXX') " ).append("\n"); 
		query.append("                              || NVL(D2.TRSP_MOD_CD, 'XX'     ) AS NOD -- QTY_CLASS " ).append("\n"); 
		query.append("                        FROM PRD_PROD_CTL_ACT_GRP_DTL D2, " ).append("\n"); 
		query.append("                             ( " ).append("\n"); 
		query.append("                                SELECT BKG_NO " ).append("\n"); 
		query.append("                                      ,PCTL_NO " ).append("\n"); 
		query.append("                                      ,CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                                      ,COP_NO " ).append("\n"); 
		query.append("                                      ,RCV_TERM_CD " ).append("\n"); 
		query.append("                                      ,DE_TERM_CD " ).append("\n"); 
		query.append("                                      ,NVL(MAX(CNTR_SPCL_FLG), MAX(BKG_SPCL_FLG)) AS SPCL_FLG -- CNTR의 Specail Flag를 우선시 한다. " ).append("\n"); 
		query.append("                                      ,MAX(BKG_SPCL_FLG) AS BKG_SPCL_FLG " ).append("\n"); 
		query.append("                                      ,SUM(ABS(CNTR_QTY)) + SUM(ABS(BKG_QTY)) AS QTY          -- 차이나는 물량이 마이너스 일수 있어서 절대값으로 처리 " ).append("\n"); 
		query.append("                                  FROM ( " ).append("\n"); 
		query.append("                                          SELECT BKG_NO " ).append("\n"); 
		query.append("                                                ,PCTL_NO " ).append("\n"); 
		query.append("                                                ,COP_NO " ).append("\n"); 
		query.append("                                                ,CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                                                ,SUM(QTY) AS CNTR_QTY  -- BKG_CONTRAINER 물량 " ).append("\n"); 
		query.append("                                                ,AWK_CGO_FLG||DCGO_FLG||RC_FLG||BB_CGO_FLG||SOC_FLG||RD_CGO_FLG AS CNTR_SPCL_FLG " ).append("\n"); 
		query.append("                                                ,0  AS BKG_QTY " ).append("\n"); 
		query.append("                                                ,'' AS BKG_SPCL_FLG " ).append("\n"); 
		query.append("                                                ,RCV_TERM_CD " ).append("\n"); 
		query.append("                                                ,DE_TERM_CD " ).append("\n"); 
		query.append("                                            FROM CNTR " ).append("\n"); 
		query.append("                                           --[CHM-201327649] flex_hgt_flg||cntr_cfm_flg <> 'YN' 경우 무조건 BKG 물량적용" ).append("\n"); 
		query.append("                                           WHERE flex_hgt_flg||cntr_cfm_flg <> 'YN'" ).append("\n"); 
		query.append("                                        GROUP BY BKG_NO " ).append("\n"); 
		query.append("                                                ,PCTL_NO " ).append("\n"); 
		query.append("                                                ,COP_NO " ).append("\n"); 
		query.append("                                                ,CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                                                ,AWK_CGO_FLG||DCGO_FLG||RC_FLG||BB_CGO_FLG||SOC_FLG||RD_CGO_FLG " ).append("\n"); 
		query.append("                                                ,RCV_TERM_CD " ).append("\n"); 
		query.append("                                                ,DE_TERM_CD " ).append("\n"); 
		query.append("                                          UNION ALL " ).append("\n"); 
		query.append("                                          SELECT C1.BKG_NO " ).append("\n"); 
		query.append("                                                ,C1.PCTL_NO " ).append("\n"); 
		query.append("                                                ,C1.COP_NO " ).append("\n"); 
		query.append("                                                ,C1.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                                                ,0      AS CNTR_QTY " ).append("\n"); 
		query.append("                                                ,''     AS CNTR_SPCL_FLG " ).append("\n"); 
		query.append("                                                ,C2.QTY AS BKG_QTY-- BKG_CONTRAINER? BKG_QTY_DTL차이 물량 " ).append("\n"); 
		query.append("                                                ,C1.AWK_CGO_FLG||C1.DCGO_FLG||C1.RC_FLG||C1.BB_CGO_FLG||C1.SOC_FLG||C1.RD_CGO_FLG AS BKG_SPCL_FLG " ).append("\n"); 
		query.append("                                                ,RCV_TERM_CD " ).append("\n"); 
		query.append("                                                ,DE_TERM_CD " ).append("\n"); 
		query.append("                                            FROM QTY C1 " ).append("\n"); 
		query.append("                                                ,( " ).append("\n"); 
		query.append("                                                        --Flex Height의 경우 D4, D5간의 혼용을 가능하도록 하기 위해서 도입한 개념으로 미주지역에서 발생하며" ).append("\n"); 
		query.append("                                                        --[CHM-201327649] BKG_BOOKING의 FLEX_HGT_FLG='Y'이면서 Container confirm 상태이면 CNTR물량 적용" ).append("\n"); 
		query.append("                                                        --[CHM-201327649] flex_hgt_flg||cntr_cfm_flg == 'YN' 경우 무조건 BKG 물량적용" ).append("\n"); 
		query.append("                                                         SELECT b1.bkg_no" ).append("\n"); 
		query.append("                                                              , DECODE(b1.flex_hgt_flg||b1.cntr_cfm_flg" ).append("\n"); 
		query.append("                                                                        , 'YY', decode(b1.cntr_tpsz_cd, 'D4', nvl(b2.cntr_tpsz_cd, b1.cntr_tpsz_cd), 'D5', nvl(b2.cntr_tpsz_cd, b1.cntr_tpsz_cd), b1.cntr_tpsz_cd) " ).append("\n"); 
		query.append("                                                                        , 'YN', b1.cntr_tpsz_cd" ).append("\n"); 
		query.append("                                                                        , b1.cntr_tpsz_cd ) AS cntr_tpsz_cd " ).append("\n"); 
		query.append("                                                              , DECODE(b1.flex_hgt_flg||b1.cntr_cfm_flg" ).append("\n"); 
		query.append("                                                                        , 'YY', DECODE(b1.cntr_tpsz_cd, 'D4', nvl(b2.qty, b1.qty), 'D5', nvl(b2.qty, b1.qty), b1.qty) - nvl(b2.qty, 0)" ).append("\n"); 
		query.append("                                                                        , 'YN', b1.qty" ).append("\n"); 
		query.append("                                                                        , b1.qty - nvl(b2.qty, 0) ) AS qty" ).append("\n"); 
		query.append("                                                           FROM (" ).append("\n"); 
		query.append("                                                                    SELECT bkg_no, cntr_tpsz_cd, flex_hgt_flg, SUM(qty) qty, cntr_cfm_flg " ).append("\n"); 
		query.append("                                                                      FROM qty " ).append("\n"); 
		query.append("                                                                     GROUP BY bkg_no, cntr_tpsz_cd, flex_hgt_flg, cntr_cfm_flg " ).append("\n"); 
		query.append("                                                                 ) B1" ).append("\n"); 
		query.append("                                                              , (" ).append("\n"); 
		query.append("                                                                    SELECT bkg_no, cntr_tpsz_cd, flex_hgt_flg, SUM(qty) qty, cntr_cfm_flg " ).append("\n"); 
		query.append("                                                                      FROM cntr " ).append("\n"); 
		query.append("                                                                     GROUP BY bkg_no, cntr_tpsz_cd, flex_hgt_flg, cntr_cfm_flg                                                                      " ).append("\n"); 
		query.append("                                                                ) B2                                                            " ).append("\n"); 
		query.append("                                                          WHERE b1.bkg_no = b2.bkg_no (+)" ).append("\n"); 
		query.append("                                                            AND DECODE(b1.flex_hgt_flg||b1.cntr_cfm_flg" ).append("\n"); 
		query.append("                                                                        , 'YY', decode(b1.cntr_tpsz_cd, 'D4', nvl(b2.cntr_tpsz_cd(+), b1.cntr_tpsz_cd), 'D5', nvl(b2.cntr_tpsz_cd(+), b1.cntr_tpsz_cd), b1.cntr_tpsz_cd) " ).append("\n"); 
		query.append("                                                                        , 'YN', b1.cntr_tpsz_cd" ).append("\n"); 
		query.append("                                                                        , b1.cntr_tpsz_cd ) = B2.cntr_tpsz_cd (+)" ).append("\n"); 
		query.append("                                                 ) C2 " ).append("\n"); 
		query.append("                                           WHERE C1.BKG_NO       = C2.BKG_NO " ).append("\n"); 
		query.append("                                             AND C1.CNTR_TPSZ_CD = C2.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                                             AND C2.QTY          > 0 " ).append("\n"); 
		query.append("                                       ) " ).append("\n"); 
		query.append("                              GROUP BY BKG_NO " ).append("\n"); 
		query.append("                                      ,PCTL_NO " ).append("\n"); 
		query.append("                                      ,CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                                      ,COP_NO " ).append("\n"); 
		query.append("                                      ,RCV_TERM_CD " ).append("\n"); 
		query.append("                                      ,DE_TERM_CD " ).append("\n"); 
		query.append("                             ) D1 " ).append("\n"); 
		query.append("                       WHERE D2.PCTL_NO = D1.PCTL_NO " ).append("\n"); 
		query.append("                    GROUP BY D1.BKG_NO " ).append("\n"); 
		query.append("                            ,D1.COP_NO " ).append("\n"); 
		query.append("                            ,D1.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                            ,D1.RCV_TERM_CD " ).append("\n"); 
		query.append("                            ,D1.DE_TERM_CD " ).append("\n"); 
		query.append("                            ,D2.COST_ACT_GRP_SEQ " ).append("\n"); 
		query.append("                            ,D1.SPCL_FLG " ).append("\n"); 
		query.append("                            ,    D2.COST_ACT_GRP_CD " ).append("\n"); 
		query.append("                              || NVL(D2.N1ST_NOD_CD, 'XXXXXXX') " ).append("\n"); 
		query.append("                              || NVL(D2.N2ND_NOD_CD, 'XXXXXXX') " ).append("\n"); 
		query.append("                              || NVL(D2.N3RD_NOD_CD, 'XXXXXXX') " ).append("\n"); 
		query.append("                              || NVL(D2.N4TH_NOD_CD, 'XXXXXXX') " ).append("\n"); 
		query.append("                              || NVL(D2.TRSP_MOD_CD, 'XX') " ).append("\n"); 
		query.append("                            ,D1.QTY" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append(")  " ).append("\n"); 
		query.append(", RDATA as (" ).append("\n"); 
		query.append("    SELECT A.BKG_NO " ).append("\n"); 
		query.append("           ,A.COP_NO PCTL_NO " ).append("\n"); 
		query.append("           ,A.CNTR_NO " ).append("\n"); 
		query.append("           ,A.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("           ,'ROUTE' || LPAD(TO_CHAR(B.GROUP_NO), 15, '0') AS COST_ROUT_NO " ).append("\n"); 
		query.append("       FROM SCE_COP_HDR A " ).append("\n"); 
		query.append("           ,( " ).append("\n"); 
		query.append("               SELECT BKG_NO " ).append("\n"); 
		query.append("                     ,COP_NO " ).append("\n"); 
		query.append("                     ,CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                     ,RCV_TERM_CD " ).append("\n"); 
		query.append("                     ,DE_TERM_CD " ).append("\n"); 
		query.append("                     ,SPCL_FLG  " ).append("\n"); 
		query.append("                     ,QTY " ).append("\n"); 
		query.append("                     ,DENSE_RANK() OVER(ORDER BY SUBSTR(MAX(SYS_CONNECT_BY_PATH(NOD,'-')),2)||SPCL_FLG) AS GROUP_NO " ).append("\n"); 
		query.append("                 FROM ROUTE " ).append("\n"); 
		query.append("                START WITH RN = 1 CONNECT BY PRIOR COP_NO       = COP_NO " ).append("\n"); 
		query.append("                                         AND PRIOR CNTR_TPSZ_CD = CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                                         AND PRIOR RN + 1       = RN " ).append("\n"); 
		query.append("             GROUP BY BKG_NO " ).append("\n"); 
		query.append("                     ,COP_NO " ).append("\n"); 
		query.append("                     ,CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                     ,RCV_TERM_CD " ).append("\n"); 
		query.append("                     ,DE_TERM_CD  " ).append("\n"); 
		query.append("                     ,SPCL_FLG " ).append("\n"); 
		query.append("                     ,QTY " ).append("\n"); 
		query.append("            ) B " ).append("\n"); 
		query.append("--           ,BKG_AWK_CGO C " ).append("\n"); 
		query.append("      WHERE 1=1 " ).append("\n"); 
		query.append("        AND A.BKG_NO    = B.BKG_NO " ).append("\n"); 
		query.append("        AND A.COP_NO    = B.COP_NO " ).append("\n"); 
		query.append("--        AND A.BKG_NO    = C.BKG_NO " ).append("\n"); 
		query.append("--        AND A.CNTR_NO   = C.CNTR_NO " ).append("\n"); 
		query.append("--        AND C.IN_GA_FLG = 'Y' " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", ROUT_DATA AS (" ).append("\n"); 
		query.append("        SELECT DISTINCT A1.BKG_NO" ).append("\n"); 
		query.append("          , NVL(B1.DCGO_FLG,'N')    SPCL_DG_CGO_FLG" ).append("\n"); 
		query.append("          , DECODE(SUBSTR(B1.CNTR_TPSZ_CD,1,1),'R', DECODE(B1.RC_FLG,'Y','Y', DECODE(A2.RC_FLG,'Y','Y','N')),'N')      SPCL_RC_FLG" ).append("\n"); 
		query.append("          , NVL(B1.AWK_CGO_FLG,'N') SPCL_AWK_CGO_FLG" ).append("\n"); 
		query.append("          , NVL(B1.BB_CGO_FLG,'N')  SPCL_BB_CGO_FLG" ).append("\n"); 
		query.append("          , A1.PCTL_NO" ).append("\n"); 
		query.append("          , A3.POR_CD" ).append("\n"); 
		query.append("          , A3.POL_CD" ).append("\n"); 
		query.append("          , A3.N1ST_TS_PORT_CD" ).append("\n"); 
		query.append("          , A3.N2ND_TS_PORT_CD" ).append("\n"); 
		query.append("          , A3.N3RD_TS_PORT_CD" ).append("\n"); 
		query.append("          , A3.POD_CD" ).append("\n"); 
		query.append("          , A3.DEL_NOD_CD" ).append("\n"); 
		query.append("          , A3.OB_ITCHG_CTNT" ).append("\n"); 
		query.append("          , A3.IB_ITCHG_CTNT" ).append("\n"); 
		query.append("          , A3.DEL_CD" ).append("\n"); 
		query.append("          , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          , A1.COP_NO" ).append("\n"); 
		query.append("          , ( NVL(B1.AWK_CGO_FLG,'N') ||" ).append("\n"); 
		query.append("              NVL(B1.DCGO_FLG,'N')    ||" ).append("\n"); 
		query.append("              DECODE(SUBSTR(B1.CNTR_TPSZ_CD,1,1),'R', DECODE(B1.RC_FLG,'Y','Y', DECODE(A2.RC_FLG,'Y','Y','N')),'N') ||" ).append("\n"); 
		query.append("              NVL(B1.BB_CGO_FLG,'N')  ||" ).append("\n"); 
		query.append("              NVL(B1.SOC_FLG,'N')     ||" ).append("\n"); 
		query.append("              DECODE(SUBSTR(B1.CNTR_TPSZ_CD,1,1),'R', DECODE(B1.RD_CGO_FLG, 'Y', DECODE(A2.RC_FLG,'Y','N', 'Y'), 'N'), 'N')" ).append("\n"); 
		query.append("            ) SPCL_FLG" ).append("\n"); 
		query.append("          , A3.TTL_TZTM_HRS" ).append("\n"); 
		query.append("          , COALESCE((SELECT COALESCE(B.MTY_PKUP_YD_CD, A.MTY_PKUP_YD_CD, A.POR_NOD_CD) OP_POR  " ).append("\n"); 
		query.append("                       FROM BKG_BOOKING A  " ).append("\n"); 
		query.append("                           ,(  " ).append("\n"); 
		query.append("                               SELECT BKG_NO  " ).append("\n"); 
		query.append("                                     ,ECC_CD  " ).append("\n"); 
		query.append("                                     ,MIN(ORG_YD_CD)   AS MTY_PKUP_YD_CD " ).append("\n"); 
		query.append("                                     ,COUNT(1)         AS CNT  " ).append("\n"); 
		query.append("                                     ,MIN(CNTR_DP_SEQ) AS SEQ  " ).append("\n"); 
		query.append("                                 FROM (  " ).append("\n"); 
		query.append("                                         SELECT A1.BKG_NO  " ).append("\n"); 
		query.append("                                               ,B1.CNTR_NO  " ).append("\n"); 
		query.append("                                               ,ROW_NUMBER() OVER (PARTITION BY B1.CNTR_NO ORDER BY B1.CNMV_EVNT_DT) AS RN  " ).append("\n"); 
		query.append("                                               ,B1.CNMV_EVNT_DT  " ).append("\n"); 
		query.append("                                               ,B1.ORG_YD_CD  " ).append("\n"); 
		query.append("                                               ,MAS_LOC_FNC (B1.ORG_YD_CD, 'ECC') AS ECC_CD  " ).append("\n"); 
		query.append("                                               ,ROW_NUMBER() OVER (ORDER BY A1.CNTR_DP_SEQ, B1.CNTR_NO) AS CNTR_DP_SEQ  " ).append("\n"); 
		query.append("                                           FROM BKG_CONTAINER A1  " ).append("\n"); 
		query.append("                                               ,CTM_MOVEMENT  B1  " ).append("\n"); 
		query.append("                                          WHERE 1=1  " ).append("\n"); 
		query.append("                                            AND A1.BKG_NO      = @[f_bkg_no]  " ).append("\n"); 
		query.append("                                            AND A1.CNTR_NO     = B1.CNTR_NO  " ).append("\n"); 
		query.append("                                            AND A1.CNMV_CYC_NO = B1.CNMV_CYC_NO  " ).append("\n"); 
		query.append("                                            AND B1.MVMT_STS_CD = 'OP'  " ).append("\n"); 
		query.append("                                      )  " ).append("\n"); 
		query.append("                                WHERE RN = 1  " ).append("\n"); 
		query.append("                             GROUP BY BKG_NO, ECC_CD  " ).append("\n"); 
		query.append("                             ORDER BY CNT DESC, SEQ  " ).append("\n"); 
		query.append("                            ) B  " ).append("\n"); 
		query.append("                      WHERE 1=1  " ).append("\n"); 
		query.append("                        AND A.BKG_NO = @[f_bkg_no]  " ).append("\n"); 
		query.append("                        AND A.BKG_NO = B.BKG_NO(+)  " ).append("\n"); 
		query.append("                        AND ROWNUM   = 1), A3.MTY_PKUP_YD_CD, A4.MTY_PKUP_YD_CD, A2.MTY_PKUP_YD_CD) MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("          , COALESCE(A3.MTY_RTN_YD_CD, A4.MTY_PKUP_YD_CD, A2.MTY_RTN_YD_CD) MTY_RTN_YD_CD" ).append("\n"); 
		query.append("          , B2.COST_ROUT_NO ROUT_NO" ).append("\n"); 
		query.append("  FROM   SCE_COP_HDR A1" ).append("\n"); 
		query.append("         , BKG_BOOKING A2" ).append("\n"); 
		query.append("         , PRD_PROD_CTL_MST A3" ).append("\n"); 
		query.append("         , MAS_RGST_BKG A4" ).append("\n"); 
		query.append("         , BKG_CONTAINER B1" ).append("\n"); 
		query.append("         , RDATA B2" ).append("\n"); 
		query.append("  WHERE  1 = 1" ).append("\n"); 
		query.append("  AND A1.BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("  AND A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("  AND A1.PCTL_NO = A3.PCTL_NO" ).append("\n"); 
		query.append("  AND A1.COP_STS_CD <> DECODE(A2.BKG_STS_CD,'S','Z','X')" ).append("\n"); 
		query.append("      AND A1.BKG_NO = A4.BKG_NO" ).append("\n"); 
		query.append("      AND B1.BKG_NO(+) = A1.BKG_NO" ).append("\n"); 
		query.append("      AND B1.CNTR_TPSZ_CD(+) = A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      AND B2.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("      AND B2.CNTR_TPSZ_CD = A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      AND B2.PCTL_NO = A1.COP_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", RESULT AS (" ).append("\n"); 
		query.append("SELECT  ' '                                                                                      PCTL_NO" ).append("\n"); 
		query.append("      , A1.BKG_NO" ).append("\n"); 
		query.append("--      , DECODE(A3.RNUM, 1, 'All', A2.COST_ROUT_NO) COST_ROUT_NO" ).append("\n"); 
		query.append("--	  , DECODE(A3.RNUM, 1, 'All', A2.ROUT_NO) COST_ROUT_NO2" ).append("\n"); 
		query.append("	  , A2.COST_ROUT_NO" ).append("\n"); 
		query.append("      , A2.ROUT_NO COST_ROUT_NO2" ).append("\n"); 
		query.append("      , MAS_LOC_FNC(A1.MTY_PKUP_YD_CD, 'LOC') AS MTY_PKUP_LOC" ).append("\n"); 
		query.append("      , MAS_LOC_FNC(A1.MTY_PKUP_YD_CD, 'ECC') AS MTY_PKUP_ECC" ).append("\n"); 
		query.append("      , A1.POR_CD" ).append("\n"); 
		query.append("      , A1.POL_CD" ).append("\n"); 
		query.append("      , A1.N1ST_TS_PORT_CD" ).append("\n"); 
		query.append("      , A1.N2ND_TS_PORT_CD" ).append("\n"); 
		query.append("      , A1.N3RD_TS_PORT_CD" ).append("\n"); 
		query.append("      , A1.POD_CD" ).append("\n"); 
		query.append("      , A1.DEL_CD" ).append("\n"); 
		query.append("      , MAS_LOC_FNC(A1.MTY_RTN_YD_CD, 'LOC') AS MTY_RTN_LOC" ).append("\n"); 
		query.append("      , MAS_LOC_FNC(A1.MTY_RTN_YD_CD, 'ECC') AS MTY_RTN_ECC" ).append("\n"); 
		query.append("      , A1.OB_ITCHG_CTNT" ).append("\n"); 
		query.append("      , A1.IB_ITCHG_CTNT" ).append("\n"); 
		query.append("      , A1.SPCL_DG_CGO_FLG" ).append("\n"); 
		query.append("      , A1.SPCL_RC_FLG" ).append("\n"); 
		query.append("      , A1.SPCL_AWK_CGO_FLG" ).append("\n"); 
		query.append("      , A1.SPCL_BB_CGO_FLG" ).append("\n"); 
		query.append("      , A2.SOC_FLG                                                                             SOC_FLG" ).append("\n"); 
		query.append("      , A2.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("      , A2.N1ST_RLANE_CD" ).append("\n"); 
		query.append("      , A2.N2ND_RLANE_CD" ).append("\n"); 
		query.append("      , A2.N3RD_RLANE_CD" ).append("\n"); 
		query.append("      , A2.N4TH_RLANE_CD" ).append("\n"); 
		query.append("      , A2.CLT_OFC_CD" ).append("\n"); 
		query.append("      , A2.SLS_OFC_CD" ).append("\n"); 
		query.append("      , A2.SHIPPER" ).append("\n"); 
		query.append("      , A2.IOC_CD" ).append("\n"); 
		query.append("      , A2.VVD" ).append("\n"); 
		query.append("      , A2.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("      , A2.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("      , A2.REP_CMDT_CD" ).append("\n"); 
		query.append("      , A2.SHPR_NM" ).append("\n"); 
		query.append("      , A2.RLANE_CD" ).append("\n"); 
		query.append("	  , NVL( A1.TTL_TZTM_HRS ,0) / 24  HRS" ).append("\n"); 
		query.append("      , A2.BKG_STS_CD" ).append("\n"); 
		query.append("      , A2.SLS_YRMON" ).append("\n"); 
		query.append("      , A2.COST_YRMON" ).append("\n"); 
		query.append("      , A2.COST_WK" ).append("\n"); 
		query.append("      , A2.BKG_CGO_WGT" ).append("\n"); 
		query.append("      , A2.BKG_WGT_TP_CD" ).append("\n"); 
		query.append("	  , MAS_GET_CD_NM_FNC('CD01639', NVL(RT_BL_TP_CD, 'X')) RT_BL_TP_NM" ).append("\n"); 
		query.append(" FROM     ROUT_DATA A1" ).append("\n"); 
		query.append("         , (SELECT DISTINCT A.BKG_NO" ).append("\n"); 
		query.append("				 , A.COST_ROUT_NO" ).append("\n"); 
		query.append("				 , 'ROUTE'||SUBSTR(A.COST_ROUT_NO, -1) ROUT_NO" ).append("\n"); 
		query.append("                 , A.RLANE_CD" ).append("\n"); 
		query.append("                 , A.N1ST_RLANE_CD" ).append("\n"); 
		query.append("                 , A.N2ND_RLANE_CD" ).append("\n"); 
		query.append("                 , A.N3RD_RLANE_CD" ).append("\n"); 
		query.append("                 , A.N4TH_RLANE_CD" ).append("\n"); 
		query.append("                 , NVL(A.AGMT_SGN_OFC_CD,A.SLS_OFC_CD) CLT_OFC_CD" ).append("\n"); 
		query.append("                 , A.SLS_OFC_CD" ).append("\n"); 
		query.append("                 , A.SHPR_CNT_CD" ).append("\n"); 
		query.append("                   ||A.SHPR_CUST_SEQ    SHIPPER" ).append("\n"); 
		query.append("                 , A.IOC_CD" ).append("\n"); 
		query.append("                 , A.VSL_CD" ).append("\n"); 
		query.append("                   ||A.SKD_VOY_NO" ).append("\n"); 
		query.append("                   ||A.DIR_CD VVD" ).append("\n"); 
		query.append("                 , A.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("                 , A.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("                 , A.REP_CMDT_CD" ).append("\n"); 
		query.append("                 , A.SHPR_NM" ).append("\n"); 
		query.append("                 , A.BKG_STS_CD" ).append("\n"); 
		query.append("                 , A.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                 , A.SOC_FLG" ).append("\n"); 
		query.append("                 , A.SLS_YRMON" ).append("\n"); 
		query.append("                 , A.COST_YRMON" ).append("\n"); 
		query.append("                 , A.COST_WK" ).append("\n"); 
		query.append("                 , A.BKG_CGO_WGT" ).append("\n"); 
		query.append("                 , A.BKG_WGT_TP_CD" ).append("\n"); 
		query.append("				 , A.RT_BL_TP_CD" ).append("\n"); 
		query.append("          FROM   MAS_BKG_EXPN_DTL A" ).append("\n"); 
		query.append("          WHERE  A.BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("          AND a.bl_no_tp      IN ('M','0')" ).append("\n"); 
		query.append("          AND A.BKG_STS_CD IN ('F','S','W')" ).append("\n"); 
		query.append("          AND A.BKG_CGO_TP_CD <> 'P') A2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("	AND A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("	AND A1.ROUT_NO = A2.COST_ROUT_NO" ).append("\n"); 
		query.append("GROUP BY  A1.BKG_NO" ).append("\n"); 
		query.append("          , A2.COST_ROUT_NO" ).append("\n"); 
		query.append("          , A2.ROUT_NO" ).append("\n"); 
		query.append("          , MAS_LOC_FNC(A1.MTY_PKUP_YD_CD, 'LOC')" ).append("\n"); 
		query.append("          , MAS_LOC_FNC(A1.MTY_PKUP_YD_CD, 'ECC') " ).append("\n"); 
		query.append("          , A1.POR_CD" ).append("\n"); 
		query.append("          , A1.POL_CD" ).append("\n"); 
		query.append("          , A1.N1ST_TS_PORT_CD" ).append("\n"); 
		query.append("          , A1.N2ND_TS_PORT_CD" ).append("\n"); 
		query.append("          , A1.N3RD_TS_PORT_CD" ).append("\n"); 
		query.append("          , A1.POD_CD" ).append("\n"); 
		query.append("          , A1.DEL_CD" ).append("\n"); 
		query.append("          , MAS_LOC_FNC(A1.MTY_RTN_YD_CD, 'LOC') " ).append("\n"); 
		query.append("          , MAS_LOC_FNC(A1.MTY_RTN_YD_CD, 'ECC') " ).append("\n"); 
		query.append("          , A1.OB_ITCHG_CTNT" ).append("\n"); 
		query.append("          , A1.IB_ITCHG_CTNT" ).append("\n"); 
		query.append("          , A1.SPCL_DG_CGO_FLG" ).append("\n"); 
		query.append("          , A1.SPCL_RC_FLG" ).append("\n"); 
		query.append("          , A1.SPCL_AWK_CGO_FLG" ).append("\n"); 
		query.append("          , A1.SPCL_BB_CGO_FLG" ).append("\n"); 
		query.append("          , A2.SOC_FLG          " ).append("\n"); 
		query.append("          , A2.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("          , A2.N1ST_RLANE_CD" ).append("\n"); 
		query.append("          , A2.N2ND_RLANE_CD" ).append("\n"); 
		query.append("          , A2.N3RD_RLANE_CD" ).append("\n"); 
		query.append("          , A2.N4TH_RLANE_CD" ).append("\n"); 
		query.append("          , A2.CLT_OFC_CD" ).append("\n"); 
		query.append("          , A2.SLS_OFC_CD" ).append("\n"); 
		query.append("          , A2.SHIPPER" ).append("\n"); 
		query.append("          , A2.IOC_CD" ).append("\n"); 
		query.append("          , A2.VVD" ).append("\n"); 
		query.append("          , A2.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("          , A2.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("          , A2.REP_CMDT_CD" ).append("\n"); 
		query.append("          , A2.SHPR_NM" ).append("\n"); 
		query.append("          , A2.RLANE_CD" ).append("\n"); 
		query.append("--          , a3.rnum" ).append("\n"); 
		query.append("          , A1.TTL_TZTM_HRS" ).append("\n"); 
		query.append("          , A2.BKG_STS_CD" ).append("\n"); 
		query.append("          , A2.SLS_YRMON" ).append("\n"); 
		query.append("          , A2.COST_YRMON" ).append("\n"); 
		query.append("          , A2.COST_WK" ).append("\n"); 
		query.append("          , A2.BKG_CGO_WGT" ).append("\n"); 
		query.append("          , A2.BKG_WGT_TP_CD" ).append("\n"); 
		query.append("          , MAS_GET_CD_NM_FNC('CD01639', NVL(RT_BL_TP_CD, 'X')) " ).append("\n"); 
		query.append("    ORDER BY COST_ROUT_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", ROUT_CNT AS (" ).append("\n"); 
		query.append("    SELECT COUNT(*) R_CNT " ).append("\n"); 
		query.append("    FROM RESULT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("--ALL용" ).append("\n"); 
		query.append("SELECT PCTL_NO" ).append("\n"); 
		query.append("      , BKG_NO" ).append("\n"); 
		query.append("--      , DECODE(A3.RNUM, 1, 'All', COST_ROUT_NO) COST_ROUT_NO" ).append("\n"); 
		query.append("--	  , DECODE(A3.RNUM, 1, 'All', ROUT_NO) COST_ROUT_NO2" ).append("\n"); 
		query.append("      , 'All' COST_ROUT_NO" ).append("\n"); 
		query.append("      , 'All' COST_ROUT_NO2" ).append("\n"); 
		query.append("      , MTY_PKUP_LOC" ).append("\n"); 
		query.append("      , MTY_PKUP_ECC" ).append("\n"); 
		query.append("--      , POR_CD -- ROUT가 1개 이상인 경우 BKG_BOOKING의 값 사용 으로 변경" ).append("\n"); 
		query.append("      , DECODE( (SELECT R_CNT FROM ROUT_CNT) , 1 , POR_CD , (SELECT POR_CD FROM BKG_BOOKING WHERE BKG_NO = @[f_bkg_no]) ) POR_CD" ).append("\n"); 
		query.append("      , POL_CD" ).append("\n"); 
		query.append("      , N1ST_TS_PORT_CD" ).append("\n"); 
		query.append("      , N2ND_TS_PORT_CD" ).append("\n"); 
		query.append("      , N3RD_TS_PORT_CD" ).append("\n"); 
		query.append("      , POD_CD" ).append("\n"); 
		query.append("--      , DEL_CD -- ROUT가 1개 이상인 경우 BKG_BOOKING의 값 사용 으로 변경" ).append("\n"); 
		query.append("      , DECODE( (SELECT R_CNT FROM ROUT_CNT) , 1 , DEL_CD , (SELECT DEL_CD FROM BKG_BOOKING WHERE BKG_NO = @[f_bkg_no]) ) DEL_CD" ).append("\n"); 
		query.append("      , MTY_RTN_LOC" ).append("\n"); 
		query.append("      , MTY_RTN_ECC" ).append("\n"); 
		query.append("      , OB_ITCHG_CTNT" ).append("\n"); 
		query.append("      , IB_ITCHG_CTNT" ).append("\n"); 
		query.append("      , SPCL_DG_CGO_FLG" ).append("\n"); 
		query.append("      , SPCL_RC_FLG" ).append("\n"); 
		query.append("      , SPCL_AWK_CGO_FLG" ).append("\n"); 
		query.append("      , SPCL_BB_CGO_FLG" ).append("\n"); 
		query.append("      , SOC_FLG" ).append("\n"); 
		query.append("      , BKG_CGO_TP_CD" ).append("\n"); 
		query.append("      , N1ST_RLANE_CD" ).append("\n"); 
		query.append("      , N2ND_RLANE_CD" ).append("\n"); 
		query.append("      , N3RD_RLANE_CD" ).append("\n"); 
		query.append("      , N4TH_RLANE_CD" ).append("\n"); 
		query.append("      , CLT_OFC_CD" ).append("\n"); 
		query.append("      , SLS_OFC_CD" ).append("\n"); 
		query.append("      , SHIPPER" ).append("\n"); 
		query.append("      , IOC_CD" ).append("\n"); 
		query.append("      , VVD" ).append("\n"); 
		query.append("      , BKG_DE_TERM_CD" ).append("\n"); 
		query.append("      , BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("      , REP_CMDT_CD" ).append("\n"); 
		query.append("      , SHPR_NM" ).append("\n"); 
		query.append("      , RLANE_CD" ).append("\n"); 
		query.append("--	  , NVL( decode( a3.rnum,1, max(TTL_TZTM_HRS) , TTL_TZTM_HRS ) ,0) / 24  HRS" ).append("\n"); 
		query.append("      , HRS" ).append("\n"); 
		query.append("      , BKG_STS_CD" ).append("\n"); 
		query.append("      , SLS_YRMON" ).append("\n"); 
		query.append("      , COST_YRMON" ).append("\n"); 
		query.append("      , COST_WK" ).append("\n"); 
		query.append("      , BKG_CGO_WGT" ).append("\n"); 
		query.append("      , BKG_WGT_TP_CD" ).append("\n"); 
		query.append("	  , RT_BL_TP_NM" ).append("\n"); 
		query.append("      FROM RESULT" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT * FROM RESULT" ).append("\n"); 

	}
}