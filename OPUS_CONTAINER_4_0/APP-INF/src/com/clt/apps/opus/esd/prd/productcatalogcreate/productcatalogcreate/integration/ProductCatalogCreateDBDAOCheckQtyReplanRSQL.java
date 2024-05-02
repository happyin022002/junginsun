/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOCheckQtyReplanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2011.02.24 김진주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimJinJoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOCheckQtyReplanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckQtyReplan
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOCheckQtyReplanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flex_hgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOCheckQtyReplanRSQL").append("\n"); 
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
		query.append("SELECT 'REJECT' RESULT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT NVL(@[flex_hgt_flg], BKGM.FLEX_HGT_FLG) FLEX_HGT_FLG" ).append("\n"); 
		query.append("         , DECODE(NVL(@[flex_hgt_flg], BKGM.FLEX_HGT_FLG), 'Y', GREATEST(TQTY.CNTR_TPSZ_CD, NVL(CMAP.PROV_CNTR_TPSZ_CD, ' ')), TQTY.CNTR_TPSZ_CD) GRP_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , TQTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , CMAP.PROV_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , TQTY.CNTR_ALL_FLG " ).append("\n"); 
		query.append("         , TQTY.CNTR_VOL_QTY" ).append("\n"); 
		query.append("         , TQTY.OP_CNTR_QTY" ).append("\n"); 
		query.append("         , CEIL(TQTY.OP_CNTR_QTY) CEIL_OP_CNTR_QTY" ).append("\n"); 
		query.append("    FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("            SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append("                 , NVL(SQTY.CNTR_TPSZ_CD, BQTY.CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                 , SQTY.CNTR_VOL_QTY" ).append("\n"); 
		query.append("                 , SQTY.CNTR_ALL_FLG" ).append("\n"); 
		query.append("                 , BQTY.OP_CNTR_QTY" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("            SELECT SHDR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                 , SUM(DECODE(BCNT.CNTR_NO, NULL, 1, BCNT.CNTR_VOL_QTY)) AS CNTR_VOL_QTY" ).append("\n"); 
		query.append("                 , MIN(DECODE(BCNT.CNTR_NO, NULL, 0, 1)) AS CNTR_ALL_FLG" ).append("\n"); 
		query.append("            FROM SCE_COP_HDR SHDR" ).append("\n"); 
		query.append("               , BKG_CONTAINER BCNT" ).append("\n"); 
		query.append("               , (SELECT count(1) CNTR_CNFM FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("                     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                       AND BKG_DOC_PROC_TP_CD = 'CNTCFM'" ).append("\n"); 
		query.append("                       AND DOC_PERF_DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1) CNFM" ).append("\n"); 
		query.append("            WHERE SHDR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND SHDR.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("            AND BCNT.BKG_NO(+) = SHDR.BKG_NO" ).append("\n"); 
		query.append("            AND BCNT.CNTR_NO(+) = SHDR.CNTR_NO" ).append("\n"); 
		query.append("--            AND EXISTS (SELECT 1" ).append("\n"); 
		query.append("--                         FROM SCE_PLN_SO_LIST" ).append("\n"); 
		query.append("--                        WHERE COP_NO = SHDR.COP_NO" ).append("\n"); 
		query.append("--                         AND TRSP_SO_STS_CD IN ('C','R','I','E','X', DECODE(BCNT.CNTR_NO, NULL, 'NOT MATCH', 'P'))" ).append("\n"); 
		query.append("--                         AND ROWNUM = 1 )" ).append("\n"); 
		query.append("            AND (( CNFM.CNTR_CNFM = 0" ).append("\n"); 
		query.append("                  AND EXISTS (SELECT 1" ).append("\n"); 
		query.append("                         FROM SCE_PLN_SO_LIST" ).append("\n"); 
		query.append("                        WHERE COP_NO = SHDR.COP_NO" ).append("\n"); 
		query.append("                         AND TRSP_SO_STS_CD IN ('C','R','I','E','X', DECODE(BCNT.CNTR_NO, NULL, 'NOT MATCH', 'P'))" ).append("\n"); 
		query.append("                         AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("                 OR" ).append("\n"); 
		query.append("                 ( CNFM.CNTR_CNFM = 1" ).append("\n"); 
		query.append("                  AND (BCNT.CNTR_NO <> 'COMU0000000'" ).append("\n"); 
		query.append("                      OR EXISTS (SELECT 1" ).append("\n"); 
		query.append("                                   FROM SCE_PLN_SO_LIST" ).append("\n"); 
		query.append("                                  WHERE COP_NO = SHDR.COP_NO" ).append("\n"); 
		query.append("                                    AND TRSP_SO_STS_CD IN ('C','R','I','E','X', DECODE(BCNT.CNTR_NO, NULL, 'NOT MATCH', 'P'))" ).append("\n"); 
		query.append("                                    AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                ))" ).append("\n"); 
		query.append("            GROUP BY SHDR.BKG_NO" ).append("\n"); 
		query.append("                   , SHDR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ) SQTY" ).append("\n"); 
		query.append("            FULL OUTER JOIN (" ).append("\n"); 
		query.append("            SELECT BKG_GET_TOKEN_FNC(COLUMN_VALUE, 1, '@') CNTR_TPSZ_CD " ).append("\n"); 
		query.append("              , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE, 2, '@')) OP_CNTR_QTY" ).append("\n"); 
		query.append("            FROM TABLE(SELECT BKG_SPLIT_FNC(@[cntr_tpsz_qty], ',') CNTR_TPSZ_QTY_TBL_STR FROM DUAL )" ).append("\n"); 
		query.append("            WHERE TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE, 2, '@')) > 0" ).append("\n"); 
		query.append("            ) BQTY" ).append("\n"); 
		query.append("            ON (  SQTY.CNTR_TPSZ_CD = BQTY.CNTR_TPSZ_CD )" ).append("\n"); 
		query.append("         ) TQTY" ).append("\n"); 
		query.append("       , SCE_COP_CNTR_REPO_RULE CMAP" ).append("\n"); 
		query.append("    WHERE BKGM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND TQTY.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("      AND CMAP.CNTR_TPSZ_CD(+) = TQTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("-- Parameter의 Bkg Qty가 변경되지 않았으면 Validation 하지 않는다 (김인수 수석, 전성진 수석 요청에 의해 처리) 20101207" ).append("\n"); 
		query.append("      AND 1 = NVL((SELECT DISTINCT(1)" ).append("\n"); 
		query.append("                     FROM (" ).append("\n"); 
		query.append("                           SELECT CNTR_TPSZ_CD, OP_CNTR_QTY, 0 PARAM_CNTR_QTY" ).append("\n"); 
		query.append("                             FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                            WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                           UNION ALL" ).append("\n"); 
		query.append("                           SELECT BKG_GET_TOKEN_FNC(COLUMN_VALUE, 1, '@') CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                , 0 AS OP_CNTR_QTY" ).append("\n"); 
		query.append("                                , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE, 2, '@')) PARAM_CNTR_QTY" ).append("\n"); 
		query.append("                             FROM TABLE(SELECT BKG_SPLIT_FNC(@[cntr_tpsz_qty], ',') CNTR_TPSZ_QTY_TBL_STR FROM DUAL )" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                   GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   HAVING SUM(OP_CNTR_QTY) <> SUM(PARAM_CNTR_QTY)" ).append("\n"); 
		query.append("                   ) " ).append("\n"); 
		query.append("                 ,0)" ).append("\n"); 
		query.append("-- Parameter의 Bkg Qty가 변경되지 않았으면 Validation 하지 않는다 - 끝" ).append("\n"); 
		query.append("-- TRO 및 SO가 하나도 없을 경우에는 검사하지 않고, CONTAINER Confirm이 있을 경우에는 TRO가 없더라도 검사한다." ).append("\n"); 
		query.append("      AND 1 = CASE" ).append("\n"); 
		query.append("              WHEN (SELECT count(1) FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("                     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                       AND BKG_DOC_PROC_TP_CD = 'CNTCFM'" ).append("\n"); 
		query.append("                       AND DOC_PERF_DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1 ) = 1 THEN 1-- CONTAINER CONFIRM 상태이면 검사" ).append("\n"); 
		query.append("              WHEN (SELECT COUNT(1) FROM SCE_COP_HDR" ).append("\n"); 
		query.append("                     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                       AND COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                       AND (IB_TRO_FLG = 'Y' OR OB_TRO_FLG = 'Y')" ).append("\n"); 
		query.append("                       AND ROWNUM = 1 ) = 1 THEN 1-- TRO가 존재하면 검사 (TRO가 존재할 시 QTY에 대한 규모는 상위 FULL OUTER JOIN에 사용되는 쿼리에서 검증)" ).append("\n"); 
		query.append("              WHEN (SELECT COUNT(1)" ).append("\n"); 
		query.append("                     FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("                    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                      AND TRSP_SO_TP_CD <> 'S'" ).append("\n"); 
		query.append("                      AND NVL(RPLN_UMCH_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                      AND NVL(TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                      AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                      --BKG에서 REPLAN시 UNMATCH 건은 제외하고 생성하게 처리 20100409" ).append("\n"); 
		query.append("            	      AND NVL(RPLN_UMCH_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                      AND ROWNUM = 1 ) = 1 THEN 1 -- SO가 존재하면 검사 (get replan pattern의 so_knt와 동일)" ).append("\n"); 
		query.append("              WHEN (SELECT COUNT(1)" ).append("\n"); 
		query.append("                      FROM TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("                     WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            	       AND NVL(A.TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                       AND NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1 ) = 1 THEN 1 -- SO가 존재하면 검사 (get replan pattern의 so_knt와 동일)" ).append("\n"); 
		query.append("              ELSE 0 END" ).append("\n"); 
		query.append("     ) SUBQ" ).append("\n"); 
		query.append("GROUP BY GRP_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("HAVING NVL(SUM(CNTR_VOL_QTY), 0) > NVL(SUM(CEIL_OP_CNTR_QTY),0)" ).append("\n"); 

	}
}