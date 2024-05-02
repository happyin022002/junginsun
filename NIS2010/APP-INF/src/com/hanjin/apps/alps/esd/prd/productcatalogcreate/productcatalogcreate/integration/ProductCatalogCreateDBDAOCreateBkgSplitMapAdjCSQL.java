/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOCreateBkgSplitMapAdjCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.14
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.14 
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

public class ProductCatalogCreateDBDAOCreateBkgSplitMapAdjCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container번호가 할당되지 않은, 모자라는 물량에 대해, 기존 데이터를 살리거나 신규 COP map정보를 생성한다.
	  * 2011.04.04 mgpark 한 세션중에 bkg_no가 2회 이상 호출되는 경우, 데이터가 다중 생성되는 것을 방지하기 위한 로직 추가
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOCreateBkgSplitMapAdjCSQL(){
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
		params.put("bkg_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_tpsz_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no_list",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("parent_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOCreateBkgSplitMapAdjCSQL").append("\n"); 
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
		query.append("MERGE INTO PRD_BKG_COP_MAP A" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT distinct DECODE(MAPG.MTCH_FLG, 'Y', CMAP.ROWID, NULL) AS ROW_ID" ).append("\n"); 
		query.append("         , CASE WHEN MAPG.MTCH_FLG = 'Y' THEN CMAP.PCTL_NO" ).append("\n"); 
		query.append("                ELSE (SELECT B.PCTL_NO FROM BKG_BOOKING B WHERE B.BKG_NO = @[parent_bkg_no] )-- 신규일 경우 BOOKING의 PC NO를 사용" ).append("\n"); 
		query.append("           END AS PCTL_NO -- key" ).append("\n"); 
		query.append("         , @[bkg_no] BKG_NO -- key" ).append("\n"); 
		query.append("         , CASE WHEN MAPG.MTCH_FLG = 'Y' THEN CMAP.COP_NO" ).append("\n"); 
		query.append("                ELSE SCE_NEW_COP_NO_FNC (@[bkg_ofc]) " ).append("\n"); 
		query.append("           END AS COP_NO -- key" ).append("\n"); 
		query.append("         , @[mapg_seq] COP_MAPG_SEQ -- key" ).append("\n"); 
		query.append("         , CMAP.CRNT_FLG" ).append("\n"); 
		query.append("         , CMAP.CNTR_NO" ).append("\n"); 
		query.append("         , MAPG.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , CASE WHEN MAPG.MTCH_FLG = 'Y' THEN DECODE(@[bkg_no],@[parent_bkg_no],'N','B')" ).append("\n"); 
		query.append("                ELSE 'C' END COP_OP_TP_CD" ).append("\n"); 
		query.append("         , CMAP.BKG_OP_RMK" ).append("\n"); 
		query.append("         , CMAP.OB_ITCHG_CTNT" ).append("\n"); 
		query.append("         , CMAP.IB_ITCHG_CTNT" ).append("\n"); 
		query.append("         , CMAP.OCN_ITCHG_CTNT" ).append("\n"); 
		query.append("         , CMAP.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("         , CMAP.MTY_RTN_YD_CD" ).append("\n"); 
		query.append("         , CMAP.POR_NOD_CD" ).append("\n"); 
		query.append("         , CMAP.POL_NOD_CD" ).append("\n"); 
		query.append("         , CMAP.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("         , CMAP.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("         , DECODE(MAPG.MTCH_FLG, 'Y', CMAP.OB_TRO_FLG, 'N') OB_TRO_FLG -- 신규는 초기화" ).append("\n"); 
		query.append("         , DECODE(MAPG.MTCH_FLG, 'Y', CMAP.IB_TRO_FLG, 'N') IB_TRO_FLG -- 신규는 초기화" ).append("\n"); 
		query.append("         , CMAP.COP_PATT_ORD_NO" ).append("\n"); 
		query.append("         , CASE WHEN MAPG.MTCH_FLG = 'Y' THEN" ).append("\n"); 
		query.append("                   (SELECT COUNT(*)" ).append("\n"); 
		query.append("                      FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("                     WHERE COP_NO = MAPG.COP_NO" ).append("\n"); 
		query.append("                       AND TRSP_SO_TP_CD <> 'S'" ).append("\n"); 
		query.append("                       AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                       AND NVL(RPLN_UMCH_FLG,'N') <> 'Y' -- 2010.04.09 추가 by j" ).append("\n"); 
		query.append("                       AND NVL(TRSP_FRST_FLG,'N') <> 'Y' )" ).append("\n"); 
		query.append("                  +(SELECT COUNT(*)" ).append("\n"); 
		query.append("                      FROM TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("                     WHERE A.COP_NO = MAPG.COP_NO" ).append("\n"); 
		query.append("                       AND NVL(A.TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                       AND NVL(A.DELT_FLG,'N') <> 'Y')" ).append("\n"); 
		query.append("                ELSE 0  -- 신규는 초기화 " ).append("\n"); 
		query.append("           END COP_SO_KNT" ).append("\n"); 
		query.append("         , CMAP.CRE_USR_ID" ).append("\n"); 
		query.append("         , CMAP.CRE_DT" ).append("\n"); 
		query.append("         , CMAP.UPD_USR_ID" ).append("\n"); 
		query.append("         , CMAP.UPD_DT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("          SELECT AQTY.TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("               , DECODE(PQTY.MTCH_CD, NULL, AQTY.PCTL_NO     , PQTY.PCTL_NO     ) PCTL_NO" ).append("\n"); 
		query.append("               , DECODE(PQTY.MTCH_CD, NULL, AQTY.BKG_NO      , PQTY.BKG_NO      ) BKG_NO" ).append("\n"); 
		query.append("               , DECODE(PQTY.MTCH_CD, NULL, AQTY.COP_NO      , PQTY.COP_NO      ) COP_NO" ).append("\n"); 
		query.append("               , DECODE(PQTY.MTCH_CD, NULL, AQTY.COP_MAPG_SEQ, PQTY.COP_MAPG_SEQ) COP_MAPG_SEQ" ).append("\n"); 
		query.append("               , DECODE(PQTY.MTCH_CD, NULL, 'N', 'Y') MTCH_FLG" ).append("\n"); 
		query.append("            FROM (--AQTY" ).append("\n"); 
		query.append("                  SELECT TPSZ_CD" ).append("\n"); 
		query.append("                       , ROW_NUMBER() OVER (PARTITION BY TPSZ_CD ORDER BY 1) TPSZ_SEQ" ).append("\n"); 
		query.append("                       , PCTL_NO,BKG_NO, COP_NO, COP_MAPG_SEQ" ).append("\n"); 
		query.append("                  FROM   ( -- 결과적으로 생성되어야 할 데이터의 양이다." ).append("\n"); 
		query.append("                          SELECT TPSZ_CD" ).append("\n"); 
		query.append("                               , ADJ_CNTR_QTY" ).append("\n"); 
		query.append("                          FROM  (" ).append("\n"); 
		query.append("                                 SELECT BKG_GET_TOKEN_FNC(COLUMN_VALUE, 1, '@') TPSZ_CD" ).append("\n"); 
		query.append("                                      , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE, 2, '@')) ADJ_CNTR_QTY" ).append("\n"); 
		query.append("--jsy" ).append("\n"); 
		query.append("--                                      , NVL((SELECT PROV_CNTR_TPSZ_CD FROM SCE_COP_CNTR_REPO_RULE RPRL WHERE RPRL.CNTR_TPSZ_CD = BKG_GET_TOKEN_FNC(COLUMN_VALUE, 1, '@'))" ).append("\n"); 
		query.append("--                                            , BKG_GET_TOKEN_FNC(COLUMN_VALUE, 1, '@') )" ).append("\n"); 
		query.append("--                                        AS PROV_TPSZ_CD" ).append("\n"); 
		query.append("                                 FROM  (TABLE(SELECT BKG_SPLIT_FNC(@[adj_tpsz_qty], ',') CNTR_TPSZ_QTY_TBL_STR FROM DUAL ))" ).append("\n"); 
		query.append("                                 WHERE TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE, 2, '@')) > 0" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                         ) AQTY" ).append("\n"); 
		query.append("                       , ( -- 신규로 추가할 데이터가 참조할 정보를 선택한다." ).append("\n"); 
		query.append("                          SELECT M.PCTL_NO" ).append("\n"); 
		query.append("                               , M.BKG_NO" ).append("\n"); 
		query.append("                               , M.COP_NO" ).append("\n"); 
		query.append("                               , M.COP_MAPG_SEQ" ).append("\n"); 
		query.append("                          FROM   PRD_BKG_COP_MAP M" ).append("\n"); 
		query.append("                          WHERE M.BKG_NO IN " ).append("\n"); 
		query.append("                                  ( SELECT COLUMN_VALUE AS BKG_NO " ).append("\n"); 
		query.append("                                    FROM TABLE(SELECT BKG_SPLIT_FNC(@[bkg_no_list], ',') BKG_NO_TBL_STR FROM DUAL ))" ).append("\n"); 
		query.append("                          AND    M.CRNT_FLG = 'Y'" ).append("\n"); 
		query.append("                          AND  ( M.COP_PATT_ORD_NO = 1" ).append("\n"); 
		query.append("                                OR  M.COP_PATT_ORD_NO IS NULL )" ).append("\n"); 
		query.append("                           AND ROWNUM =1" ).append("\n"); 
		query.append("                         ) PDAT" ).append("\n"); 
		query.append("                       , COM_CPY_NO CPNO" ).append("\n"); 
		query.append("                    WHERE CPNO.CPY_NO < AQTY.ADJ_CNTR_QTY" ).append("\n"); 
		query.append("               ) AQTY" ).append("\n"); 
		query.append("               ,( -- PC에서 살릴 수 있는 정보를 MAPPING한다. 가급적 요청된 SIZE TYPE을 감안하여 MAPPING 한다. (기존 데이터의 TPSZ가 변경될 수도 있다.)" ).append("\n"); 
		query.append("                 --JSY, F.H가 아니면 사용안함" ).append("\n"); 
		query.append("				 SELECT PCTL_NO" ).append("\n"); 
		query.append("                      , BKG_NO" ).append("\n"); 
		query.append("                      , COP_NO" ).append("\n"); 
		query.append("                      , COP_MAPG_SEQ" ).append("\n"); 
		query.append("                      , MTCH_CD" ).append("\n"); 
		query.append("                      , ROW_NUMBER() OVER (PARTITION BY MTCH_CD ORDER BY COP_NO ) MTCH_SEQ_old" ).append("\n"); 
		query.append("					  , ROW_NUMBER() OVER (PARTITION BY MTCH_CD ORDER BY decode( CNTR_TPSZ_CD,MTCH_CD, 1, 2 ) , COP_NO ) MTCH_SEQ --jsy" ).append("\n"); 
		query.append("                 FROM (" ).append("\n"); 
		query.append("                     SELECT PCTL_NO" ).append("\n"); 
		query.append("                          , BKG_NO" ).append("\n"); 
		query.append("                          , COP_NO" ).append("\n"); 
		query.append("                          , COP_MAPG_SEQ" ).append("\n"); 
		query.append("--확인용" ).append("\n"); 
		query.append("						  , CNTR_TPSZ_CD,TPSZ_CD1,TPSZ_CD2, QTY1,QTY2 --jsy" ).append("\n"); 
		query.append("--						  , ROW_NUMBER() OVER (PARTITION BY CNTR_TPSZ_CD,TPSZ_CD2 ORDER BY COP_NO) rn, --jsy " ).append("\n"); 
		query.append("--                        , ROW_NUMBER() OVER (PARTITION BY CNTR_TPSZ_CD ORDER BY COP_NO) rn2 --jsy" ).append("\n"); 
		query.append("                          -- 가급적 요청된 SIZE TYPE을 먼저 연결한 후, 호환 가능한 것으로 연결한다." ).append("\n"); 
		query.append("--jsy, TPSZ_CD2 추가 , qty가 2개 이상이면 복제된것을 포함해서 같은cop가 2개가 됨 , 다른 cop가 2개가 되야하는데," ).append("\n"); 
		query.append("                          , CASE WHEN QTY1 > 0 AND TPSZ_CD1 = CNTR_TPSZ_CD -- 입력된 type 이 PRD_BKG_COP_MAP의 type 과 같으면" ).append("\n"); 
		query.append("                                     AND ROW_NUMBER() OVER (PARTITION BY CNTR_TPSZ_CD,TPSZ_CD2 ORDER BY COP_NO) <= QTY1 THEN TPSZ_CD1" ).append("\n"); 
		query.append("                                 WHEN QTY2 > 0 AND TPSZ_CD2 = CNTR_TPSZ_CD  -- 호환 type(없으면 입력된 type) 이 PRD_BKG_COP_MAP의 type 과 같으면" ).append("\n"); 
		query.append("                                     AND ROW_NUMBER() OVER (PARTITION BY CNTR_TPSZ_CD,TPSZ_CD2 ORDER BY COP_NO) <= QTY2 THEN TPSZ_CD2" ).append("\n"); 
		query.append("                                 WHEN QTY1 > 0 AND TPSZ_CD2 = CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                     AND (ROW_NUMBER() OVER (PARTITION BY CNTR_TPSZ_CD,TPSZ_CD2 ORDER BY COP_NO) - NVL(QTY2,0)) <= QTY1 THEN TPSZ_CD1" ).append("\n"); 
		query.append("                                 WHEN QTY2 > 0 AND TPSZ_CD1 = CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                     AND (ROW_NUMBER() OVER (PARTITION BY CNTR_TPSZ_CD,TPSZ_CD2 ORDER BY COP_NO) - NVL(QTY1,0)) <= QTY2 THEN TPSZ_CD2" ).append("\n"); 
		query.append("                                 ELSE NULL END MTCH_CD" ).append("\n"); 
		query.append("						  , row_number() over(partition by COP_NO  order by m2.CNTR_TPSZ_CD,TPSZ_CD2 ) dup_rn --jsy 호환 dup 제거  " ).append("\n"); 
		query.append("                     FROM PRD_BKG_COP_MAP M2" ).append("\n"); 
		query.append("                         , ( -- 큰 TYPE으로 GROUP " ).append("\n"); 
		query.append("                          SELECT GREATEST(TPSZ_CD, NVL(PROV_TPSZ_CD, ' ')) GRP_TPSZ_CD" ).append("\n"); 
		query.append("-- 요청된 type 우선으로 cd1 , 호환가능 type로 cd2/ 입력된type 으로 사용할지 ,호환된 type으로 사용할지 " ).append("\n"); 
		query.append("                               , MIN(DECODE( TPSZ_CD, GREATEST(TPSZ_CD, NVL(PROV_TPSZ_CD, ' ')), PROV_TPSZ_CD, TPSZ_CD)) TPSZ_CD1" ).append("\n"); 
		query.append("                               , MAX(DECODE( TPSZ_CD, GREATEST(TPSZ_CD, NVL(PROV_TPSZ_CD, ' ')), NULL, ADJ_CNTR_QTY )) QTY1" ).append("\n"); 
		query.append("                               , MAX(DECODE( TPSZ_CD, GREATEST(TPSZ_CD, NVL(PROV_TPSZ_CD, ' ')), TPSZ_CD, PROV_TPSZ_CD)) TPSZ_CD2" ).append("\n"); 
		query.append("                               , MAX(DECODE( TPSZ_CD, GREATEST(TPSZ_CD, NVL(PROV_TPSZ_CD, ' ')), ADJ_CNTR_QTY, NULL)) QTY2" ).append("\n"); 
		query.append("                               , SUM(ADJ_CNTR_QTY) GRP_QTY" ).append("\n"); 
		query.append("                          FROM " ).append("\n"); 
		query.append("-- jsy" ).append("\n"); 
		query.append("                               ( --JSY 적용" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("                                    SELECT  " ).append("\n"); 
		query.append("                                    TPSZ_CD,ADJ_CNTR_QTY,NVL(PROV_CNTR_TPSZ_CD,TPSZ_CD) PROV_TPSZ_CD" ).append("\n"); 
		query.append("                                    FROM" ).append("\n"); 
		query.append("                                    (" ).append("\n"); 
		query.append("                                        SELECT " ).append("\n"); 
		query.append("                                           BKG_GET_TOKEN_FNC(COLUMN_VALUE, 1, '@') TPSZ_CD" ).append("\n"); 
		query.append("                                           , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE, 2, '@')) ADJ_CNTR_QTY" ).append("\n"); 
		query.append("                                           " ).append("\n"); 
		query.append("                                        FROM TABLE(SELECT BKG_SPLIT_FNC(@[adj_tpsz_qty], ',') CNTR_TPSZ_QTY_TBL_STR FROM DUAL )" ).append("\n"); 
		query.append("                                        WHERE TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE, 2, '@')) > 0" ).append("\n"); 
		query.append("                                    )BQTY" ).append("\n"); 
		query.append("                                    , SCE_COP_CNTR_REPO_RULE RPRL" ).append("\n"); 
		query.append("                                    WHERE RPRL.CNTR_TPSZ_CD(+) = BQTY.TPSZ_CD" ).append("\n"); 
		query.append("                                    AND 'Y' = NVL(NVL(@[flex_hgt_flg], (SELECT FLEX_HGT_FLG FROM BKG_BOOKING WHERE BKG_NO = @[parent_bkg_no])), 'N')" ).append("\n"); 
		query.append("                                                                 " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                         GROUP BY GREATEST(TPSZ_CD, NVL(PROV_TPSZ_CD, ' '))" ).append("\n"); 
		query.append("                            ) AQTY" ).append("\n"); 
		query.append("                     WHERE BKG_NO IN" ).append("\n"); 
		query.append("                            ( SELECT COLUMN_VALUE AS BKG_NO " ).append("\n"); 
		query.append("                              FROM TABLE(SELECT BKG_SPLIT_FNC(@[bkg_no_list], ',') BKG_NO_TBL_STR FROM DUAL ))" ).append("\n"); 
		query.append("                     AND M2.CRNT_FLG = 'Y'" ).append("\n"); 
		query.append("--                     AND M2.CNTR_NO = 'HJCU0000000'" ).append("\n"); 
		query.append("                     AND M2.COP_OP_TP_CD = 'X'" ).append("\n"); 
		query.append("                     AND M2.CNTR_TPSZ_CD IN ( AQTY.TPSZ_CD1 , TPSZ_CD2 )" ).append("\n"); 
		query.append("--                     AND (NVL(OB_TRO_FLG,'N') <> 'Y' or (NVL(OB_TRO_FLG,'N') = 'Y' and CNTR_NO = 'HJCU0000000'))" ).append("\n"); 
		query.append("--                     AND (NVL(IB_TRO_FLG,'N') <> 'Y' or (NVL(IB_TRO_FLG,'N') = 'Y' and CNTR_NO = 'HJCU0000000'))" ).append("\n"); 
		query.append("--                     AND POR_NOD_CD IS NULL" ).append("\n"); 
		query.append("--                     AND POL_NOD_CD IS NULL" ).append("\n"); 
		query.append("          	         AND ( CNTR_NO IS NULL" ).append("\n"); 
		query.append("                        OR CNTR_NO = 'SMCU0000000')" ).append("\n"); 
		query.append("                     AND  ( COP_PATT_ORD_NO = 1" ).append("\n"); 
		query.append("                        OR  COP_PATT_ORD_NO IS NULL )" ).append("\n"); 
		query.append("--                     AND NOT EXISTS" ).append("\n"); 
		query.append("--                     (SELECT 'X' FROM PRD_BKG_COP_MAP M3" ).append("\n"); 
		query.append("--                     WHERE M2.COP_NO = M3.COP_NO" ).append("\n"); 
		query.append("--                     AND M3.CRNT_FLG ='Y'" ).append("\n"); 
		query.append("--                     AND M3.COP_OP_TP_CD <> 'X')" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                 WHERE  MTCH_CD IS NOT NULL" ).append("\n"); 
		query.append("				   AND dup_rn= 1 --jsy" ).append("\n"); 
		query.append("                ) PQTY" ).append("\n"); 
		query.append("           WHERE PQTY.MTCH_CD(+) = AQTY.TPSZ_CD" ).append("\n"); 
		query.append("             AND PQTY.MTCH_SEQ(+) = AQTY.TPSZ_SEQ" ).append("\n"); 
		query.append("         ) MAPG" ).append("\n"); 
		query.append("       , PRD_BKG_COP_MAP CMAP" ).append("\n"); 
		query.append("    WHERE CMAP.PCTL_NO = MAPG.PCTL_NO" ).append("\n"); 
		query.append("      AND CMAP.BKG_NO = MAPG.BKG_NO" ).append("\n"); 
		query.append("      AND CMAP.COP_NO = MAPG.COP_NO" ).append("\n"); 
		query.append("      AND CMAP.COP_MAPG_SEQ = MAPG.COP_MAPG_SEQ" ).append("\n"); 
		query.append("      AND 0 = (SELECT COUNT(1) -- 2011.04.04 mgpark 한 세션중에 bkg_no가 2회 이상 호출되는 경우, 데이터가 다중 생성되는 것을 방지하기 위한 로직" ).append("\n"); 
		query.append("                 FROM PRD_BKG_COP_MAP" ).append("\n"); 
		query.append("                WHERE CRNT_FLG = 'Y'" ).append("\n"); 
		query.append("                  AND COP_OP_TP_CD in ('N', 'B')" ).append("\n"); 
		query.append("                  AND BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                  AND (CNTR_NO IS NULL OR CNTR_NO = 'SMCU0000000')" ).append("\n"); 
		query.append("                  AND ROWNUM = 1" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (A.ROWID = B.ROW_ID )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("      A.COP_OP_TP_CD = B.COP_OP_TP_CD" ).append("\n"); 
		query.append("    , A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    , A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    , A.COP_SO_KNT = B.COP_SO_KNT" ).append("\n"); 
		query.append("    , A.COP_MAPG_SEQ = B.COP_MAPG_SEQ" ).append("\n"); 
		query.append("    , A.UPD_USR_ID = 'SYSTEM2_U'" ).append("\n"); 
		query.append("    , A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (PCTL_NO, BKG_NO, COP_NO, COP_MAPG_SEQ, CRNT_FLG" ).append("\n"); 
		query.append("      , CNTR_NO, CNTR_TPSZ_CD, COP_OP_TP_CD, BKG_OP_RMK, OB_ITCHG_CTNT" ).append("\n"); 
		query.append("      , IB_ITCHG_CTNT, OCN_ITCHG_CTNT, MTY_PKUP_YD_CD, MTY_RTN_YD_CD, POR_NOD_CD" ).append("\n"); 
		query.append("      , POL_NOD_CD, BKG_RCV_TERM_CD, BKG_DE_TERM_CD, OB_TRO_FLG, IB_TRO_FLG" ).append("\n"); 
		query.append("      , COP_PATT_ORD_NO, COP_SO_KNT, CRE_USR_ID, CRE_DT, UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("VALUES (B.PCTL_NO, B.BKG_NO, B.COP_NO, B.COP_MAPG_SEQ, B.CRNT_FLG" ).append("\n"); 
		query.append("      , 'SMCU0000000', B.CNTR_TPSZ_CD, B.COP_OP_TP_CD, B.BKG_OP_RMK, B.OB_ITCHG_CTNT" ).append("\n"); 
		query.append("      , B.IB_ITCHG_CTNT, B.OCN_ITCHG_CTNT, B.MTY_PKUP_YD_CD, B.MTY_RTN_YD_CD, B.POR_NOD_CD" ).append("\n"); 
		query.append("      , B.POL_NOD_CD, B.BKG_RCV_TERM_CD, B.BKG_DE_TERM_CD, B.OB_TRO_FLG, B.IB_TRO_FLG" ).append("\n"); 
		query.append("      , B.COP_PATT_ORD_NO, B.COP_SO_KNT, B.CRE_USR_ID, B.CRE_DT, 'SYSTEM2_C'" ).append("\n"); 
		query.append("      , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}