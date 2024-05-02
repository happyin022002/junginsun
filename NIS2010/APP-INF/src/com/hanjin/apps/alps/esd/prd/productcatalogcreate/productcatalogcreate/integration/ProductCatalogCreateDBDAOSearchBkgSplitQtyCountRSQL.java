/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchBkgSplitQtyCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.28 
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

public class ProductCatalogCreateDBDAOSearchBkgSplitQtyCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBkgSplitQtyCount
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchBkgSplitQtyCountRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("parent_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchBkgSplitQtyCountRSQL").append("\n"); 
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
		query.append("-- PRD_BKG_COP_MAP기준으로 Container 개수를 구하되, Flex Height를 감안하여, Bkg_quantity값을 참조하여" ).append("\n"); 
		query.append("-- 남는 container quantity에 대해, bkg_quantity로 전이 시킨다." ).append("\n"); 
		query.append("SELECT DECODE(CPYT.F_N0, 0, CNTR_TPSZ_CD_1, CNTR_TPSZ_CD_2) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , MAX(DECODE(CPYT.F_N0, 0, OP_CNTR_QTY_1, OP_CNTR_QTY_2)) BKG_QTY" ).append("\n"); 
		query.append("     , MAX(DECODE(CPYT.F_N0, 0, CNTR_QTY_1 , CNTR_QTY_2)) PC_QTY" ).append("\n"); 
		query.append("     , MAX(DECODE(CPYT.F_N0, 0, ADJ_QTY_1, ADJ_QTY_2)) MOV_QTY" ).append("\n"); 
		query.append("     , MAX(DECODE(CPYT.F_N0, 0, OP_CNTR_QTY_1, OP_CNTR_QTY_2))" ).append("\n"); 
		query.append("         - MAX(DECODE(CPYT.F_N0, 0, CNTR_QTY_1 , CNTR_QTY_2))" ).append("\n"); 
		query.append("         - MAX(DECODE(CPYT.F_N0, 0, ADJ_QTY_1, ADJ_QTY_2))  CALC_QTY" ).append("\n"); 
		query.append("     , CEIL(MAX(DECODE(CPYT.F_N0, 0, OP_CNTR_QTY_1, OP_CNTR_QTY_2))" ).append("\n"); 
		query.append("         - MAX(DECODE(CPYT.F_N0, 0, CNTR_QTY_1 , CNTR_QTY_2))" ).append("\n"); 
		query.append("         - MAX(DECODE(CPYT.F_N0, 0, ADJ_QTY_1, ADJ_QTY_2)))  QTY -- 작업해야 할 일량이다" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT CNTR_TPSZ_CD_1" ).append("\n"); 
		query.append("         ,CNTR_QTY_1" ).append("\n"); 
		query.append("         ,OP_CNTR_QTY_1" ).append("\n"); 
		query.append("         , MORE_LESS_QTY_1" ).append("\n"); 
		query.append("         , CASE WHEN NVL(FLEX_HGT_FLG, 'N') = 'N' THEN 0" ).append("\n"); 
		query.append("                WHEN SIGN(MORE_LESS_QTY_1 * MORE_LESS_QTY_2) = -1 THEN-- 해당 값이 음수이면, 한쪽이 다른쪽으로 전달 가능" ).append("\n"); 
		query.append("                 CASE WHEN ABS(MORE_LESS_QTY_1) = ABS(MORE_LESS_QTY_2) THEN MORE_LESS_QTY_1 * -1 -- 절대값이 같으면 양수는 빼고, 음수는 더하고" ).append("\n"); 
		query.append("                       WHEN ABS(MORE_LESS_QTY_1) - ABS(MORE_LESS_QTY_2) > 0 THEN MORE_LESS_QTY_2" ).append("\n"); 
		query.append("                       ELSE MORE_LESS_QTY_1 * -1" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                ELSE 0 END ADJ_QTY_1" ).append("\n"); 
		query.append("         ,CNTR_TPSZ_CD_2" ).append("\n"); 
		query.append("         ,CNTR_QTY_2" ).append("\n"); 
		query.append("         ,OP_CNTR_QTY_2" ).append("\n"); 
		query.append("         , MORE_LESS_QTY_2" ).append("\n"); 
		query.append("         , CASE WHEN NVL(FLEX_HGT_FLG, 'N') = 'N' THEN 0" ).append("\n"); 
		query.append("                WHEN SIGN(MORE_LESS_QTY_1 * MORE_LESS_QTY_2) = -1 THEN-- 해당 값이 음수이면, 한쪽이 다른쪽으로 전달 가능" ).append("\n"); 
		query.append("                 CASE WHEN ABS(MORE_LESS_QTY_1) = ABS(MORE_LESS_QTY_2) THEN MORE_LESS_QTY_2 * -1 -- 절대값이 같으면 양수는 빼고, 음수는 더하고" ).append("\n"); 
		query.append("                       WHEN ABS(MORE_LESS_QTY_1) - ABS(MORE_LESS_QTY_2) > 0 THEN MORE_LESS_QTY_2 * -1" ).append("\n"); 
		query.append("                       ELSE MORE_LESS_QTY_1" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                ELSE 0 END ADJ_QTY_2" ).append("\n"); 
		query.append("--         , FLEX_HGT_FLG" ).append("\n"); 
		query.append("--         , GRP_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT FLEX_HGT_FLG, GRP_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , MAX(DECODE(GRP_CNTR_TPSZ_CD, CNTR_TPSZ_CD, CNTR_TPSZ_CD, NULL)) AS CNTR_TPSZ_CD_1" ).append("\n"); 
		query.append("             , NVL(MAX(DECODE(GRP_CNTR_TPSZ_CD, CNTR_TPSZ_CD,CNTR_QTY, 0)),0) AS CNTR_QTY_1  ----------- cop quantity 보존되어야함" ).append("\n"); 
		query.append("             , NVL(MAX(DECODE(GRP_CNTR_TPSZ_CD, CNTR_TPSZ_CD, OP_CNTR_QTY, 0)),0) AS OP_CNTR_QTY_1" ).append("\n"); 
		query.append("             , TRUNC(NVL(MAX(DECODE(GRP_CNTR_TPSZ_CD, CNTR_TPSZ_CD,CNTR_QTY, 0)),0) - NVL(MAX(DECODE(GRP_CNTR_TPSZ_CD, CNTR_TPSZ_CD, OP_CNTR_QTY, 0)),0)) MORE_LESS_QTY_1" ).append("\n"); 
		query.append("             , MAX(DECODE(GRP_CNTR_TPSZ_CD, CNTR_TPSZ_CD, NULL, CNTR_TPSZ_CD)) AS CNTR_TPSZ_CD_2" ).append("\n"); 
		query.append("             , NVL(MAX(DECODE(GRP_CNTR_TPSZ_CD, CNTR_TPSZ_CD, 0,CNTR_QTY)),0) AS CNTR_QTY_2  ----------- cop quantity 보존되어야함" ).append("\n"); 
		query.append("             , NVL(MAX(DECODE(GRP_CNTR_TPSZ_CD, CNTR_TPSZ_CD, 0,OP_CNTR_QTY)),0) AS OP_CNTR_QTY_2" ).append("\n"); 
		query.append("             , TRUNC(NVL(MAX(DECODE(GRP_CNTR_TPSZ_CD, CNTR_TPSZ_CD, 0,CNTR_QTY)),0) - NVL(MAX(DECODE(GRP_CNTR_TPSZ_CD, CNTR_TPSZ_CD, 0,OP_CNTR_QTY)),0)) MORE_LESS_QTY_2" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("				--prd_map 과 호환 table 조인 -> 호환 테이블 사용 안해도 같은 결과 라 뺌" ).append("\n"); 
		query.append("                SELECT BKGM.BKG_NO" ).append("\n"); 
		query.append("                         , BKGM.FLEX_HGT_FLG" ).append("\n"); 
		query.append("                         , CMAP.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                         , COUNT(1) AS CNTR_QTY" ).append("\n"); 
		query.append("--                         , SUM(NVL(BCNT.CNTR_VOL_QTY, 1)) CNTR_QTY -- CONTAINER 번호가 있을 경우에는 CONTAINER의 VOLUME QTY를 보도록 수정 (20100917 Park Mangeon)" ).append("\n"); 
		query.append("                         , 0 AS OP_CNTR_QTY" ).append("\n"); 
		query.append("                         , CMAP.CNTR_TPSZ_CD   GRP_CNTR_TPSZ_CD  --JSY(20121128)" ).append("\n"); 
		query.append("--JSY(20121128)          , DECODE(BKGM.FLEX_HGT_FLG, 'Y', GREATEST(MAX(CMAP.CNTR_TPSZ_CD), NVL(MAX(RPRL.PROV_CNTR_TPSZ_CD), ' ')), CMAP.CNTR_TPSZ_CD)  GRP_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    FROM (SELECT @[bkg_no] BKG_NO, NVL(@[flex_hgt_flg], FLEX_HGT_FLG) FLEX_HGT_FLG FROM BKG_BOOKING WHERE BKG_NO = @[parent_bkg_no] ) BKGM" ).append("\n"); 
		query.append("                      , PRD_BKG_COP_MAP CMAP" ).append("\n"); 
		query.append("--JSY(20121128)       , SCE_COP_CNTR_REPO_RULE RPRL" ).append("\n"); 
		query.append("--                      , BKG_CONTAINER BCNT" ).append("\n"); 
		query.append("                      WHERE CMAP.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                      AND CMAP.CRNT_FLG ='Y'" ).append("\n"); 
		query.append("                      AND NVL(CMAP.COP_OP_TP_CD,'N') <> 'X'" ).append("\n"); 
		query.append("                      AND CMAP.COP_MAPG_SEQ = @[mapg_seq]" ).append("\n"); 
		query.append("--JSY(20121128)       AND RPRL.PROV_CNTR_TPSZ_CD(+) = CMAP.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("--                      AND BCNT.BKG_NO(+) = CMAP.BKG_NO" ).append("\n"); 
		query.append("--                      AND BCNT.CNTR_NO(+) = CMAP.CNTR_NO" ).append("\n"); 
		query.append("                 GROUP BY  BKGM.BKG_NO" ).append("\n"); 
		query.append("                         , BKGM.FLEX_HGT_FLG" ).append("\n"); 
		query.append("                         , CMAP.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				SELECT " ).append("\n"); 
		query.append("                    BKG_NO,FLEX_HGT_FLG,t1.CNTR_TPSZ_CD,CNTR_QTY,OP_CNTR_QTY," ).append("\n"); 
		query.append("                    DECODE(FLEX_HGT_FLG, 'Y', GREATEST(t1.CNTR_TPSZ_CD, NVL(RPRL.PROV_CNTR_TPSZ_CD, ' ')), t1.CNTR_TPSZ_CD) GRP_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                FROM " ).append("\n"); 
		query.append("                    ( " ).append("\n"); 
		query.append("                    SELECT BKGM.BKG_NO" ).append("\n"); 
		query.append("                         , BKGM.FLEX_HGT_FLG" ).append("\n"); 
		query.append("                         , BQTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                         , 0 AS CNTR_QTY" ).append("\n"); 
		query.append("                         , CEIL(BQTY.OP_CNTR_QTY) OP_CNTR_QTY -- 올림 함수.CONTAINER각각에 대한 VOL_QTY가 들어오지 않기 때문에 어쩔수 없이 CEIL함 (기타 오류 가능성 있음) Park Mangeon 20101019" ).append("\n"); 
		query.append("                    --     , DECODE(BKGM.FLEX_HGT_FLG, 'Y', GREATEST(BQTY.CNTR_TPSZ_CD, NVL(RPRL.PROV_CNTR_TPSZ_CD, ' ')), BQTY.CNTR_TPSZ_CD) GRP_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    FROM (SELECT @[bkg_no] BKG_NO, NVL(@[flex_hgt_flg], FLEX_HGT_FLG) FLEX_HGT_FLG FROM BKG_BOOKING WHERE BKG_NO = @[parent_bkg_no] ) BKGM" ).append("\n"); 
		query.append("                      , (SELECT @[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append("                               , BKG_GET_TOKEN_FNC(COLUMN_VALUE, 1, '@') CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                               , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE, 2, '@')) OP_CNTR_QTY" ).append("\n"); 
		query.append("                            FROM TABLE(SELECT BKG_SPLIT_FNC(@[cntr_tpsz_qty], ',') CNTR_TPSZ_QTY_TBL_STR FROM DUAL )" ).append("\n"); 
		query.append("                         ) BQTY" ).append("\n"); 
		query.append("                      WHERE BQTY.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("                    ) T1," ).append("\n"); 
		query.append("                    SCE_COP_CNTR_REPO_RULE RPRL  " ).append("\n"); 
		query.append("                    WHERE  RPRL.CNTR_TPSZ_CD(+) = t1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("					--JSY(20121128) F.h 일 경우만 SCE_COP_CNTR_REPO_RULE 을 모두 참조하게 하고(호환 row 2개 이상 나올수 있음), " ).append("\n"); 
		query.append("                      AND RPRL.CNTR_DP_SEQ(+)=   DECODE(NVL(NVL(@[flex_hgt_flg], t1.FLEX_HGT_FLG), 'N') , 'N', 1 ,  RPRL.CNTR_DP_SEQ(+)   )  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("          GROUP BY FLEX_HGT_FLG, GRP_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("      ) CQTY" ).append("\n"); 
		query.append("     , (SELECT CPY_NO F_N0 FROM COM_CPY_NO WHERE CPY_NO <=1) CPYT" ).append("\n"); 
		query.append(" GROUP BY DECODE(CPYT.F_N0, 0, CNTR_TPSZ_CD_1, CNTR_TPSZ_CD_2)" ).append("\n"); 
		query.append("    HAVING DECODE(CPYT.F_N0, 0, CNTR_TPSZ_CD_1, CNTR_TPSZ_CD_2) IS NOT NULL" ).append("\n"); 
		query.append("--       AND MAX(DECODE(CPYT.F_N0, 0, CNTR_QTY_1 + ADJ_QTY_1, CNTR_QTY_2 + ADJ_QTY_2)) <> 0" ).append("\n"); 

	}
}