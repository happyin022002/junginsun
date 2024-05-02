/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOGetReplanePatternRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOGetReplanePatternRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetReplanePattern
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOGetReplanePatternRSQL(){
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
		params.put("bkg_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_t",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_rcv_t",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_del_t",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_t",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("current_flag",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOGetReplanePatternRSQL").append("\n"); 
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
		query.append("WITH FH_QTY AS ( " ).append("\n"); 
		query.append("SELECT -- COMU0000000 중 tpsz가 다르지만 호환 가능한 것끼리 연결된다. (priority 4)" ).append("\n"); 
		query.append("       BKG_NO" ).append("\n"); 
		query.append("     , DECODE(SUBSTR(N4TH_MAP, 1,2)" ).append("\n"); 
		query.append("              , 'WK' , NVL(MAX(BKG_CNTR_TPSZ_CD), MAX(SCE_CNTR_TPSZ_CD)) -- BKG TPSZ을 우선 따라가도록 처리" ).append("\n"); 
		query.append("              , NVL(MAX(SCE_CNTR_TPSZ_CD), MAX(BKG_CNTR_TPSZ_CD))) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , NVL(MAX(DECODE(CNTR_NO, 'COMU0000000', NULL, CNTR_NO)), 'COMU0000000') CNTR_NO" ).append("\n"); 
		query.append("     , MAX(COP_NO) COP_NO" ).append("\n"); 
		query.append("     , MAX(OB_TRO_FLG) OB_TRO_FLG" ).append("\n"); 
		query.append("     , MAX(IB_TRO_FLG) IB_TRO_FLG" ).append("\n"); 
		query.append("     , DECODE(MAX(COP_DTL_SEQ), NULL, 'N', 'Y') OB_FSH_FLG" ).append("\n"); 
		query.append("     , DECODE(MAX(COP_DTL_SEQ), NULL, 'N', DECODE(MAX(COP_STS_CD), 'F', 'Y', 'N')) IB_FSH_FLG" ).append("\n"); 
		query.append("      , CASE WHEN MAX(DECODE(CNTR_NO, 'COMU0000000', NULL, CNTR_NO)) IS NOT NULL THEN NULL -- 반드시 생존해야할 데이터, bkg qty보다 많은것은 상관없음" ).append("\n"); 
		query.append("             WHEN MAX(SO_KNT) > 0 THEN NULL -- 반드시 생존해야할 데이터" ).append("\n"); 
		query.append("             WHEN GREATEST(NVL(MAX(OB_TRO_FLG), 'N'), NVL(MAX(IB_TRO_FLG), 'N')) = 'Y' THEN NULL -- 반드시 생존해야 할 데이터" ).append("\n"); 
		query.append("             WHEN MAX(SCE_CNTR_TPSZ_CD) IS NULL THEN 'C'" ).append("\n"); 
		query.append("             WHEN MAX(BKG_CNTR_TPSZ_CD) IS NULL AND NVL(MAX(SO_KNT),0) = 0 THEN 'X'" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END CALC_COP_OP_TP_CD" ).append("\n"); 
		query.append("     , NVL(MAX(SO_KNT),0) SO_KNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT -- COMU0000000 중 tpsz가 같은 것끼리 연결된다. (priority 3)" ).append("\n"); 
		query.append("       BKG_NO" ).append("\n"); 
		query.append("     , MAX(BKG_CNTR_TPSZ_CD) BKG_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , MAX(SCE_CNTR_TPSZ_CD) SCE_CNTR_TPSZ_CD -- 나중에 우선이 되어야 함" ).append("\n"); 
		query.append("     , NVL(MAX(DECODE(CNTR_NO, 'COMU0000000', NULL, CNTR_NO)), 'COMU0000000') CNTR_NO" ).append("\n"); 
		query.append("     , MAX(COP_NO) COP_NO" ).append("\n"); 
		query.append("     , MAX(OB_TRO_FLG) OB_TRO_FLG" ).append("\n"); 
		query.append("     , MAX(IB_TRO_FLG) IB_TRO_FLG" ).append("\n"); 
		query.append("     , MAX(COP_DTL_SEQ) COP_DTL_SEQ" ).append("\n"); 
		query.append("     , MAX(COP_STS_CD) COP_STS_CD" ).append("\n"); 
		query.append("     , MAX(SO_KNT) SO_KNT" ).append("\n"); 
		query.append("     , MAX(GRP_CNTR_TPSZ_CD) GRP_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , CASE WHEN MAX(SCE_CNTR_TPSZ_CD) IS NOT NULL AND MAX(BKG_CNTR_TPSZ_CD) IS NOT NULL THEN 'MTCH'|| LPAD(ROW_NUMBER() OVER (ORDER BY 1), 11, '0') --- match(PRIORITY 1,2,3)" ).append("\n"); 
		query.append("            WHEN MAX(SCE_CNTR_TPSZ_CD) IS NULL AND MAX(BKG_PROV_CNTR_TPSZ_CD) IS NULL THEN 'SKIP' || LPAD(ROW_NUMBER() OVER (ORDER BY 1), 11, '0') -- 호환 CONTAINER TPSZ 없음" ).append("\n"); 
		query.append("            ELSE 'WK' || NVL( MAX(SCE_CNTR_TPSZ_CD) , MAX(BKG_PROV_CNTR_TPSZ_CD)) || 'X' -- SCE에 CONTAINER 번호가 있는 CONTAINER TPSZ와 BKG에 있는 호환 CONTAINER TPSZ간 MAPPING" ).append("\n"); 
		query.append("                  || LPAD(ROW_NUMBER() OVER (PARTITION BY NVL(MAX(SCE_CNTR_TPSZ_CD), 'XX') ||NVL(MAX(BKG_CNTR_TPSZ_CD), 'XX')" ).append("\n"); 
		query.append("                                             ORDER BY GREATEST(NVL(MAX(OB_TRO_FLG), 'N'), NVL(MAX(IB_TRO_FLG), 'N')) desc, MAX(COP_NO)), 11, '0') -- TRO가 있는 것을 우선으로 mapping" ).append("\n"); 
		query.append("            END N4TH_MAP" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT -- sce Container 번호가 있는 것 mapping 되거나 남음 ( priority 2)" ).append("\n"); 
		query.append("       BKG_NO" ).append("\n"); 
		query.append("     , MAX(BKG_CNTR_TPSZ_CD) BKG_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , MAX(SCE_CNTR_TPSZ_CD) SCE_CNTR_TPSZ_CD -- 나중에 우선이 되어야 함" ).append("\n"); 
		query.append("     , MAX(BKG_PROV_CNTR_TPSZ_CD) BKG_PROV_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , MAX(SCE_PROV_CNTR_TPSZ_CD) SCE_PROV_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , NVL(MAX(DECODE(CNTR_NO, 'COMU0000000', NULL, CNTR_NO)), 'COMU0000000') CNTR_NO" ).append("\n"); 
		query.append("     , MAX(COP_NO) COP_NO" ).append("\n"); 
		query.append("     , MAX(OB_TRO_FLG) OB_TRO_FLG" ).append("\n"); 
		query.append("     , MAX(IB_TRO_FLG) IB_TRO_FLG" ).append("\n"); 
		query.append("     , MAX(COP_DTL_SEQ) COP_DTL_SEQ" ).append("\n"); 
		query.append("     , MAX(COP_STS_CD) COP_STS_CD" ).append("\n"); 
		query.append("     , MAX(SO_KNT) SO_KNT" ).append("\n"); 
		query.append("     , CASE WHEN MAX(SCE_CNTR_TPSZ_CD) IS NOT NULL AND MAX(BKG_CNTR_TPSZ_CD) IS NOT NULL THEN 'MTCH' else NVL(MAX(BKG_CNTR_TPSZ_CD), MAX(SCE_CNTR_TPSZ_CD)) || 'XX' END" ).append("\n"); 
		query.append("       || LPAD(ROW_NUMBER() OVER (PARTITION BY CASE WHEN MAX(SCE_CNTR_TPSZ_CD) IS NOT NULL AND MAX(BKG_CNTR_TPSZ_CD) IS NOT NULL THEN 'MTCH'" ).append("\n"); 
		query.append("                                            ELSE NVL(MAX(BKG_CNTR_TPSZ_CD) , 'XX') || nvl(MAX(SCE_CNTR_TPSZ_CD), 'XX') END" ).append("\n"); 
		query.append("                          order by GREATEST(NVL(MAX(OB_TRO_FLG), 'N'), NVL(MAX(IB_TRO_FLG), 'N')) desc, MAX(COP_NO)) -- TRO가 있는 것을 우선으로 mapping" ).append("\n"); 
		query.append("              , 11, '0') N3RD_MAP" ).append("\n"); 
		query.append("     , MAX(GRP_CNTR_TPSZ_CD) GRP_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM ( SELECT -- container 번호가 있으면서, bkg qty에 tpsz가 있는 것이 매핑 (full mapping priority 1)" ).append("\n"); 
		query.append("        NVL(SCEQ.BKG_NO, QTYQ.BKG_NO) BKG_NO" ).append("\n"); 
		query.append("      , NVL(SCEQ.CNTR_NO, QTYQ.CNTR_NO) CNTR_NO" ).append("\n"); 
		query.append("      , SCEQ.COP_NO" ).append("\n"); 
		query.append("      , SCEQ.OB_TRO_FLG" ).append("\n"); 
		query.append("      , SCEQ.IB_TRO_FLG" ).append("\n"); 
		query.append("      , SCEQ.COP_DTL_SEQ" ).append("\n"); 
		query.append("      , SCEQ.COP_STS_CD" ).append("\n"); 
		query.append("      , SCEQ.CNTR_TPSZ_CD  SCE_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , QTYQ.CNTR_TPSZ_CD  BKG_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , SCEQ.PROV_CNTR_TPSZ_CD SCE_PROV_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , QTYQ.PROV_CNTR_TPSZ_CD BKG_PROV_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , NVL( SCEQ.GRP_CNTR_TPSZ_CD, QTYQ.GRP_CNTR_TPSZ_CD ) GRP_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , CASE WHEN SCEQ.CNTR_TPSZ_CD IS NOT NULL AND QTYQ.CNTR_TPSZ_CD IS NOT NULL THEN 'MTCH' || LPAD(ROW_NUMBER() OVER (ORDER BY 1), 11, '0') --- match(PRIORITY 1)" ).append("\n"); 
		query.append("             WHEN QTYQ.CNTR_NO IS NULL AND REPLACE(SCEQ.CNTR_NO, 'COMU0000000') IS NULL THEN 'RMVE' || LPAD(ROW_NUMBER() OVER (ORDER BY 1), 11, '0') -- sce에 container번호가 없음" ).append("\n"); 
		query.append("             WHEN SCEQ.CNTR_TPSZ_CD IS NULL AND QTYQ.PROV_CNTR_TPSZ_CD IS NULL THEN 'SKIP' || LPAD(ROW_NUMBER() OVER (ORDER BY 1), 11, '0') -- 호환 CONTAINER TPSZ 없음" ).append("\n"); 
		query.append("             ELSE NVL( SCEQ.CNTR_TPSZ_CD, QTYQ.PROV_CNTR_TPSZ_CD ) || 'X' -- SCE에 CONTAINER 번호가 있는 CONTAINER TPSZ와 BKG에 있는 호환 CONTAINER TPSZ간 MAPPING" ).append("\n"); 
		query.append("                  || LPAD(ROW_NUMBER() OVER (PARTITION BY NVL(SCEQ.CNTR_TPSZ_CD, 'XX') ||NVL(QTYQ.CNTR_TPSZ_CD, 'XX') ORDER BY SCEQ.COP_NO), 11, '0')" ).append("\n"); 
		query.append("         END N2ND_MAP" ).append("\n"); 
		query.append("      , SCEQ.SO_KNT" ).append("\n"); 
		query.append("   FROM ( -- SCE 측" ).append("\n"); 
		query.append("           SELECT CHDR.BKG_NO" ).append("\n"); 
		query.append("                , NVL(@[flex_hgt_flg], BKGM.FLEX_HGT_FLG) AS FLEX_HGT_FLG" ).append("\n"); 
		query.append("                , NVL(BCNT.CNTR_TPSZ_CD, CHDR.CNTR_TPSZ_CD) CNTR_TPSZ_CD -- CONTAINER 우선" ).append("\n"); 
		query.append("                , NVL(CHDR.CNTR_NO, 'COMU0000000') CNTR_NO -- 다른 로직을 보면 CNTR_NO가 NULL이 되는 경우가 있는 듯 보여 해당과 같이처리함 (20101012 Park Mangeon)" ).append("\n"); 
		query.append("                , DECODE(NVL(@[flex_hgt_flg], BKGM.FLEX_HGT_FLG), 'Y', GREATEST(CHDR.CNTR_TPSZ_CD,  NVL(RPRL.PROV_CNTR_TPSZ_CD, ' ')),CHDR.CNTR_TPSZ_CD)  GRP_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                , RPRL.PROV_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                , CHDR.COP_NO" ).append("\n"); 
		query.append("                , CHDR.OB_TRO_FLG" ).append("\n"); 
		query.append("                , CHDR.IB_TRO_FLG" ).append("\n"); 
		query.append("                , CHDR.COP_STS_CD" ).append("\n"); 
		query.append("                , (SELECT /*+ INDEX_DESC (CDTL XPKSCE_COP_DTL) */ COP_DTL_SEQ" ).append("\n"); 
		query.append("                     FROM SCE_COP_DTL CDTL" ).append("\n"); 
		query.append("                    WHERE CDTL.COP_NO = CHDR.COP_NO" ).append("\n"); 
		query.append("                      AND CDTL.COP_DTL_SEQ >= 4000  -- 적어도 배는 타줘야~" ).append("\n"); 
		query.append("                      AND CDTL.ACT_DT < SYSDATE   --  이미 실행되었음" ).append("\n"); 
		query.append("                      AND ROWNUM = 1) COP_DTL_SEQ" ).append("\n"); 
		query.append("                , SO.SO_KNT" ).append("\n"); 
		query.append("                , NVL(BCNT.CNTR_VOL_QTY, 1) CNTR_VOL_QTY" ).append("\n"); 
		query.append("                , CASE WHEN REPLACE( CHDR.CNTR_NO, 'COMU0000000', '') IS NULL THEN 100000000 ELSE 0 END" ).append("\n"); 
		query.append("                 + ROW_NUMBER()" ).append("\n"); 
		query.append("                       OVER (PARTITION BY CHDR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                              ORDER BY CASE WHEN REPLACE( CHDR.CNTR_NO, 'COMU0000000', '') IS NOT NULL AND SO.SO_KNT > 0 THEN 1" ).append("\n"); 
		query.append("                                            WHEN REPLACE( CHDR.CNTR_NO, 'COMU0000000', '') IS NOT NULL THEN 2" ).append("\n"); 
		query.append("                                            WHEN SO.SO_KNT > 0 THEN 3" ).append("\n"); 
		query.append("                                            ELSE 4 END" ).append("\n"); 
		query.append("                                     , CHDR.COP_NO" ).append("\n"); 
		query.append("                       ) SCE_CNTR_ODR" ).append("\n"); 
		query.append("             FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append("                , SCE_COP_HDR CHDR" ).append("\n"); 
		query.append("                , SCE_COP_CNTR_REPO_RULE RPRL" ).append("\n"); 
		query.append("                , (" ).append("\n"); 
		query.append("                    SELECT COP_NO,COUNT(1) SO_KNT" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                        SELECT COP_NO,COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                        FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("                        WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        AND TRSP_SO_TP_CD <> 'S'" ).append("\n"); 
		query.append("                        AND NVL(RPLN_UMCH_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                        AND NVL(TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                        AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                        --BKG에서 REPLAN시 UNMATCH 건은 제외하고 생성하게 처리 20100409" ).append("\n"); 
		query.append("            	    	AND NVL(RPLN_UMCH_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        -- Rail So" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                        A.COP_NO,A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                        FROM TRS_TRSP_RAIL_BIL_ORD A" ).append("\n"); 
		query.append("                        WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            	    	AND NVL(A.TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                        AND NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                        ORDER BY 1,2" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                        GROUP BY COP_NO" ).append("\n"); 
		query.append("                     ) SO" ).append("\n"); 
		query.append("                 , BKG_CONTAINER BCNT" ).append("\n"); 
		query.append("            WHERE BKGM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND CHDR.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("              AND NVL(CHDR.COP_STS_CD,'N') <> 'X'" ).append("\n"); 
		query.append("              AND RPRL.CNTR_TPSZ_CD(+) = CHDR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              AND SO.COP_NO(+) = CHDR.COP_NO" ).append("\n"); 
		query.append("              AND BCNT.BKG_NO(+) = CHDR.BKG_NO" ).append("\n"); 
		query.append("              AND BCNT.CNTR_NO(+) = CHDR.CNTR_NO" ).append("\n"); 
		query.append("          ) SCEQ" ).append("\n"); 
		query.append("        FULL OUTER JOIN" ).append("\n"); 
		query.append("          ( -- BKG 측" ).append("\n"); 
		query.append("           SELECT BQTY.BKG_NO" ).append("\n"); 
		query.append("                , NVL(@[flex_hgt_flg], BKGM.FLEX_HGT_FLG) as FLEX_HGT_FLG" ).append("\n"); 
		query.append("                , BQTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                , 'COMU0000000' AS CNTR_NO" ).append("\n"); 
		query.append("                , DECODE(NVL(@[flex_hgt_flg], BKGM.FLEX_HGT_FLG), 'Y', GREATEST(BQTY.CNTR_TPSZ_CD,  NVL(RPRL.PROV_CNTR_TPSZ_CD, ' ')), BQTY.CNTR_TPSZ_CD) GRP_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                , RPRL.PROV_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                , ROW_NUMBER()OVER(PARTITION BY BQTY.CNTR_TPSZ_CD ORDER BY CPY_NO) AS QTY_CNTR_ODR" ).append("\n"); 
		query.append("             FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append("               , (SELECT @[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append("                       , BKG_GET_TOKEN_FNC(COLUMN_VALUE, 1, '@') CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                       , TO_NUMBER(BKG_GET_TOKEN_FNC(COLUMN_VALUE, 2, '@')) OP_CNTR_QTY" ).append("\n"); 
		query.append("                    FROM TABLE(SELECT BKG_SPLIT_FNC(@[cntr_tpsz_qty], ',') CNTR_TPSZ_QTY_TBL_STR FROM DUAL )" ).append("\n"); 
		query.append("                  ) BQTY" ).append("\n"); 
		query.append("               , COM_CPY_NO CPNO" ).append("\n"); 
		query.append("               , SCE_COP_CNTR_REPO_RULE RPRL" ).append("\n"); 
		query.append("           WHERE BKGM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             AND BQTY.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("             AND RPRL.CNTR_TPSZ_CD(+) = BQTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             AND CPNO.CPY_NO < BQTY.OP_CNTR_QTY" ).append("\n"); 
		query.append("         ) QTYQ" ).append("\n"); 
		query.append("       ON (   SCEQ.CNTR_TPSZ_CD = QTYQ.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          AND SCEQ.SCE_CNTR_ODR = QTYQ.QTY_CNTR_ODR" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("GROUP BY BKG_NO, N2ND_MAP" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY BKG_NO, N3RD_MAP" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY BKG_NO, N4TH_MAP" ).append("\n"); 
		query.append(") -- END OF FH_QTY" ).append("\n"); 
		query.append(", SO_INFO AS (	" ).append("\n"); 
		query.append("    SELECT /*+ LEADING(H) USE_NL(PU) USE_NL(RTN) */" ).append("\n"); 
		query.append("		  ROWNUM,H.COP_NO,H.CNTR_NO,H.CNTR_TPSZ_CD, SO_KNT," ).append("\n"); 
		query.append("          OB_TRO_FLG,IB_TRO_FLG,BC.POR_NOD_CD,BC.POL_YD_CD POL_NOD_CD, BKG.POR_NOD_CD POR_ZN_CD,BKG.DEL_NOD_CD," ).append("\n"); 
		query.append("        -- MIXED TERM 일때 BKG_CONTAINER 의 TERM 을 사용" ).append("\n"); 
		query.append("        -- NVL(RCV_TERM_CD,:rcv_t) RCV_TERM_CD,NVL(DE_TERM_CD,:del_t) DE_TERM_CD," ).append("\n"); 
		query.append("		  DECODE(@[bkg_rcv_t], 'M',  NVL(BC.RCV_TERM_CD,@[rcv_t]), @[rcv_t]) RCV_TERM_CD," ).append("\n"); 
		query.append("		  DECODE(@[bkg_del_t], 'M',  NVL(BC.DE_TERM_CD,@[del_t]), @[del_t]) DE_TERM_CD," ).append("\n"); 
		query.append("        --:rcv_t RCV_TERM_CD,:del_t DE_TERM_CD," ).append("\n"); 
		query.append("        --PU.NOD_CD MT_PU,RTN.NOD_CD MT_RTN,	=> DEL #2010.06.03 by sj" ).append("\n"); 
		query.append("          COUNT(H.COP_NO) OVER ( PARTITION BY PU.NOD_CD ) PU_CNT," ).append("\n"); 
		query.append("          COUNT(H.COP_NO) OVER ( PARTITION BY RTN.NOD_CD ) RTN_CNT," ).append("\n"); 
		query.append("          H.OB_FSH_FLG,H.IB_FSH_FLG, H.CALC_COP_OP_TP_CD" ).append("\n"); 
		query.append("    FROM FH_QTY H" ).append("\n"); 
		query.append("        , SCE_COP_DTL PU" ).append("\n"); 
		query.append("        , SCE_COP_DTL RTN" ).append("\n"); 
		query.append("        , BKG_CONTAINER BC" ).append("\n"); 
		query.append("        , BKG_BOOKING BKG" ).append("\n"); 
		query.append("    WHERE H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND H.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("    AND H.CNTR_NO = BC.CNTR_NO(+)" ).append("\n"); 
		query.append("    AND H.BKG_NO = BC.BKG_NO(+)" ).append("\n"); 
		query.append("--      AND NVL(H.COP_STS_CD,'N') <> 'X'" ).append("\n"); 
		query.append("    AND H.COP_NO = PU.COP_NO(+)" ).append("\n"); 
		query.append("    AND PU.ACT_CD(+) = 'MOTYDO'" ).append("\n"); 
		query.append("    AND PU.ACT_DT(+) IS NOT NULL" ).append("\n"); 
		query.append("    AND H.COP_NO = RTN.COP_NO(+)" ).append("\n"); 
		query.append("    AND RTN.ACT_CD(+) = 'MITYAD'" ).append("\n"); 
		query.append("    AND RTN.ACT_DT(+) IS NOT NULL" ).append("\n"); 
		query.append(")  -- END OF SO_INFO" ).append("\n"); 
		query.append(", ROUT_OUTPUT AS (" ).append("\n"); 
		query.append("    SELECT B.COP_NO,B.CNTR_NO,B.CNTR_TPSZ_CD, SO_KNT,NVL(OB_TRO_FLG,'N') OB_TRO_FLG, NVL(IB_TRO_FLG,'N') IB_TRO_FLG," ).append("\n"); 
		query.append("        POR_NOD_CD,POL_NOD_CD,RCV_TERM_CD,DE_TERM_CD," ).append("\n"); 
		query.append("        --NVL(MT_PU,FIRST_VALUE(MT_PU) OVER  (ORDER BY PU_CNT DESC ROWS UNBOUNDED PRECEDING)) MT_PU,	=> DEL #2010.06.03 by sj" ).append("\n"); 
		query.append("        --NVL(MT_RTN,FIRST_VALUE(MT_RTN) OVER  (ORDER BY RTN_CNT DESC ROWS UNBOUNDED PRECEDING)) MT_RTN,=> DEL #2010.06.03 by sj" ).append("\n"); 
		query.append("        (CASE WHEN (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(B.POR_ZN_CD,1,5)) ='E'" ).append("\n"); 
		query.append("               AND NVL((SELECT DOR_NOD_CD FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("                         WHERE COP_NO =B.COP_NO" ).append("\n"); 
		query.append("                           AND TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("                           AND TRSP_SO_TP_CD <> 'S'" ).append("\n"); 
		query.append("                           AND NVL(RPLN_UMCH_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                           AND NVL(TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                           AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                           AND DOR_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("						   AND ROWNUM = 1" ).append("\n"); 
		query.append("						),B.POR_ZN_CD) <> B.POR_ZN_CD" ).append("\n"); 
		query.append("              THEN PRD_GET_COP_NO_EUR_DR_STR_FNC (B.COP_NO,'O')" ).append("\n"); 
		query.append("              ELSE PRD_GET_COP_BND_SO_STR_FNC (B.COP_NO,'O')" ).append("\n"); 
		query.append("        END) OUT_BOUND," ).append("\n"); 
		query.append("        (CASE WHEN (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(B.DEL_NOD_CD,1,5)) ='E'" ).append("\n"); 
		query.append("               AND NVL((SELECT DOR_NOD_CD FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("                         WHERE COP_NO =B.COP_NO" ).append("\n"); 
		query.append("                           AND TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("                           AND TRSP_SO_TP_CD <> 'S'" ).append("\n"); 
		query.append("                           AND NVL(RPLN_UMCH_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                           AND NVL(TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                           AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                           AND DOR_NOD_CD IS NOT NULL " ).append("\n"); 
		query.append("						   AND ROWNUM = 1" ).append("\n"); 
		query.append("						),B.DEL_NOD_CD) <> B.DEL_NOD_CD" ).append("\n"); 
		query.append("              THEN PRD_GET_COP_NO_EUR_DR_STR_FNC (B.COP_NO,'I')" ).append("\n"); 
		query.append("              ELSE PRD_GET_COP_BND_SO_STR_FNC (B.COP_NO,'I')" ).append("\n"); 
		query.append("        END)  IN_BOUND," ).append("\n"); 
		query.append("        PRD_GET_COP_BND_SO_STR_FNC (B.COP_NO,'T') OCN," ).append("\n"); 
		query.append("        B.OB_FSH_FLG,B.IB_FSH_FLG, B.CALC_COP_OP_TP_CD" ).append("\n"); 
		query.append("    FROM SO_INFO B" ).append("\n"); 
		query.append(") -- END OF ROUT_OUTPUT" ).append("\n"); 
		query.append(", SUB_QUERY AS (" ).append("\n"); 
		query.append("    SELECT COP_NO,CNTR_NO,CNTR_TPSZ_CD,SO_KNT" ).append("\n"); 
		query.append("		 --MT_PU,MT_RTN,	=> DEL #2010.06.03 by sj" ).append("\n"); 
		query.append("		 , OB_TRO_FLG,IB_TRO_FLG,POR_NOD_CD,POL_NOD_CD,RCV_TERM_CD,DE_TERM_CD" ).append("\n"); 
		query.append("         , (CASE WHEN FULL_RK > 1 AND OUT_BOUND <> B_OUT_BOUND AND SIGN(INSTR(B_OUT_BOUND,OUT_BOUND)) = 1 THEN B_OUT_BOUND ELSE OUT_BOUND END) OUT_BOUND" ).append("\n"); 
		query.append("         , (CASE WHEN FULL_RK > 1 AND IN_BOUND <> B_IN_BOUND   AND SIGN(INSTR(B_IN_BOUND,IN_BOUND)) = 1   THEN B_IN_BOUND  ELSE IN_BOUND  END) IN_BOUND" ).append("\n"); 
		query.append("         , (CASE WHEN FULL_RK > 1 AND OCN <> B_OCN             AND SIGN(INSTR(B_OCN,OCN)) = 1             THEN B_OCN       ELSE OCN       END) OCN" ).append("\n"); 
		query.append("            --MT_PU||MT_RTN||OB_TRO_FLG||IB_TRO_FLG||NVL(POR_NOD_CD,'AAAAAAA')||NVL(POL_NOD_CD,'AAAAAAA')||RCV_TERM_CD||DE_TERM_CD||" ).append("\n"); 
		query.append("	     , OB_TRO_FLG||IB_TRO_FLG||NVL(POR_NOD_CD,'AAAAAAA')||NVL(POL_NOD_CD,'AAAAAAA')||RCV_TERM_CD||DE_TERM_CD" ).append("\n"); 
		query.append("           ||(CASE WHEN FULL_RK > 1 AND OUT_BOUND <> B_OUT_BOUND AND SIGN(INSTR(B_OUT_BOUND,OUT_BOUND)) = 1 THEN B_OUT_BOUND ELSE OUT_BOUND END)" ).append("\n"); 
		query.append("           ||(CASE WHEN FULL_RK > 1 AND IN_BOUND <> B_IN_BOUND   AND SIGN(INSTR(B_IN_BOUND,IN_BOUND)) = 1   THEN B_IN_BOUND  ELSE IN_BOUND  END)" ).append("\n"); 
		query.append("           ||(CASE WHEN FULL_RK > 1 AND OCN <> B_OCN             AND SIGN(INSTR(B_OCN,OCN)) = 1             THEN B_OCN       ELSE OCN       END)" ).append("\n"); 
		query.append("           AS FULL_ROUT" ).append("\n"); 
		query.append("         , COUNT(" ).append("\n"); 
		query.append("            --MT_PU||MT_RTN||OB_TRO_FLG||IB_TRO_FLG||NVL(POR_NOD_CD,'AAAAAAA')||NVL(POL_NOD_CD,'AAAAAAA')||RCV_TERM_CD||DE_TERM_CD||" ).append("\n"); 
		query.append("	        OB_TRO_FLG||IB_TRO_FLG||NVL(POR_NOD_CD,'AAAAAAA')||NVL(POL_NOD_CD,'AAAAAAA')||RCV_TERM_CD||DE_TERM_CD" ).append("\n"); 
		query.append("            ||(CASE WHEN FULL_RK > 1 AND OUT_BOUND <> B_OUT_BOUND AND SIGN(INSTR(B_OUT_BOUND,OUT_BOUND)) = 1 THEN B_OUT_BOUND ELSE OUT_BOUND END)" ).append("\n"); 
		query.append("            ||(CASE WHEN FULL_RK > 1 AND IN_BOUND <> B_IN_BOUND   AND SIGN(INSTR(B_IN_BOUND,IN_BOUND)) = 1   THEN B_IN_BOUND  ELSE IN_BOUND  END)" ).append("\n"); 
		query.append("            ||(CASE WHEN FULL_RK > 1 AND OCN <> B_OCN             AND SIGN(INSTR(B_OCN,OCN)) = 1             THEN B_OCN       ELSE OCN       END)" ).append("\n"); 
		query.append("            ) OVER (" ).append("\n"); 
		query.append("            PARTITION BY" ).append("\n"); 
		query.append("            --MT_PU||MT_RTN||OB_TRO_FLG||IB_TRO_FLG||NVL(POR_NOD_CD,'AAAAAAA')||NVL(POL_NOD_CD,'AAAAAAA')||RCV_TERM_CD||DE_TERM_CD||" ).append("\n"); 
		query.append("	        OB_TRO_FLG||IB_TRO_FLG||NVL(POR_NOD_CD,'AAAAAAA')||NVL(POL_NOD_CD,'AAAAAAA')||RCV_TERM_CD||DE_TERM_CD" ).append("\n"); 
		query.append("            ||(CASE WHEN FULL_RK > 1 AND OUT_BOUND <> B_OUT_BOUND AND SIGN(INSTR(B_OUT_BOUND,OUT_BOUND)) = 1 THEN B_OUT_BOUND ELSE OUT_BOUND END)" ).append("\n"); 
		query.append("            ||(CASE WHEN FULL_RK > 1 AND IN_BOUND <> B_IN_BOUND   AND SIGN(INSTR(B_IN_BOUND,IN_BOUND)) = 1   THEN B_IN_BOUND  ELSE IN_BOUND  END)" ).append("\n"); 
		query.append("            ||(CASE WHEN FULL_RK > 1 AND OCN <> B_OCN             AND SIGN(INSTR(B_OCN,OCN)) = 1             THEN B_OCN       ELSE OCN       END)" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("           AS FULL_RANK" ).append("\n"); 
		query.append("         , OB_FSH_FLG, IB_FSH_FLG, CALC_COP_OP_TP_CD" ).append("\n"); 
		query.append("    FROM   (" ).append("\n"); 
		query.append("           SELECT COP_NO,CNTR_NO,CNTR_TPSZ_CD,SO_KNT,OUT_BOUND,IN_BOUND,OCN,OB_TRO_FLG,IB_TRO_FLG,POR_NOD_CD,POL_NOD_CD,RCV_TERM_CD,DE_TERM_CD, FULL_RK" ).append("\n"); 
		query.append("                , MAX(DECODE(FULL_RK, 1, OUT_BOUND, NULL)) OVER () B_OUT_BOUND" ).append("\n"); 
		query.append("                , MAX(DECODE(FULL_RK, 1, IN_BOUND, NULL)) OVER () B_IN_BOUND" ).append("\n"); 
		query.append("                , MAX(DECODE(FULL_RK, 1, OCN, NULL)) OVER () B_OCN" ).append("\n"); 
		query.append("                , OB_FSH_FLG, IB_FSH_FLG, CALC_COP_OP_TP_CD" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("               SELECT COP_NO,CNTR_NO,CNTR_TPSZ_CD,SO_KNT,OUT_BOUND,IN_BOUND,OCN,OB_TRO_FLG,IB_TRO_FLG,POR_NOD_CD,POL_NOD_CD,RCV_TERM_CD,DE_TERM_CD" ).append("\n"); 
		query.append("                    , ROW_NUMBER() OVER (ORDER BY PATTERN_CNTS DESC, SIGN(SO_KNT) DESC , COP_NO DESC) FULL_RK -- PATTERN개수가 가장 많은 것의 가장 나중 COP 번호를 가진 것중 하나가 FULL_RK = 1이 된다. (Park Mangeon - 조용인 수석에게 확인 20100902, SO가 있는 것이 우선적으로 처리되도록 rank 처리" ).append("\n"); 
		query.append("                    , OB_FSH_FLG, IB_FSH_FLG, CALC_COP_OP_TP_CD" ).append("\n"); 
		query.append("               FROM (" ).append("\n"); 
		query.append("                     SELECT ROUT.COP_NO,ROUT.CNTR_NO,ROUT.CNTR_TPSZ_CD,ROUT.SO_KNT,ROUT.OUT_BOUND,ROUT.IN_BOUND,ROUT.OCN" ).append("\n"); 
		query.append("                             -- MT_PU,MT_RTN,=> DEL #2010.06.03 by sj" ).append("\n"); 
		query.append("               		      , OB_TRO_FLG,IB_TRO_FLG,POR_NOD_CD,POL_NOD_CD,RCV_TERM_CD,DE_TERM_CD" ).append("\n"); 
		query.append("                          , COUNT(1) OVER (PARTITION BY OB_TRO_FLG||IB_TRO_FLG||POR_NOD_CD||POL_NOD_CD||RCV_TERM_CD||DE_TERM_CD||ROUT.OUT_BOUND||ROUT.OCN||ROUT.IN_BOUND) PATTERN_CNTS" ).append("\n"); 
		query.append("                          , ROUT.OB_FSH_FLG,ROUT.IB_FSH_FLG, CALC_COP_OP_TP_CD" ).append("\n"); 
		query.append("                       FROM ROUT_OUTPUT ROUT" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append(") -- END OF SUB_QUERY" ).append("\n"); 
		query.append("SELECT NVL(H2.BKG_NO, @[bkg_no]) AS BKG_NO" ).append("\n"); 
		query.append("     , CASE WHEN CALC_COP_OP_TP_CD = 'C' THEN (SELECT B.PCTL_NO FROM BKG_BOOKING B WHERE B.BKG_NO = @[bkg_no] ) -- 신규는 booking의 pc 번호 사용" ).append("\n"); 
		query.append("            WHEN (P.OB_TRO_FLG = 'Y' OR P.IB_TRO_FLG = 'Y') AND NVL(P.CNTR_NO, 'COMU0000000') = 'COMU0000000' THEN (SELECT B.PCTL_NO FROM BKG_BOOKING B WHERE B.BKG_NO = @[bkg_no] ) -- 신규는 booking의 pc 번호 사용" ).append("\n"); 
		query.append("            ELSE NVL(H2.PCTL_NO, MAX(H2.PCTL_NO) OVER ())" ).append("\n"); 
		query.append("       END AS PCTL_NO" ).append("\n"); 
		query.append("     , CASE WHEN P.COP_NO IS NOT NULL THEN P.COP_NO" ).append("\n"); 
		query.append("            ELSE SCE_NEW_COP_NO_FNC(@[bkg_ofc]) END AS COP_NO" ).append("\n"); 
		query.append("     , @[mapg_seq] COP_MAPG_SEQ" ).append("\n"); 
		query.append("     , 'Y' CRNT_FLG" ).append("\n"); 
		query.append("     , NVL(CALC_COP_OP_TP_CD, @[current_flag]) COP_OP_TP_CD" ).append("\n"); 
		query.append("     , P.CNTR_NO" ).append("\n"); 
		query.append("     , 'REPLAN' BKG_OP_RMK" ).append("\n"); 
		query.append("     , P.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , SO_KNT  COP_SO_KNT" ).append("\n"); 
		query.append("     --, MT_PU,MT_RTN=> DEL #2010.06.03 by sj" ).append("\n"); 
		query.append("     , P.OB_TRO_FLG" ).append("\n"); 
		query.append("     , P.IB_TRO_FLG" ).append("\n"); 
		query.append("     , P.POR_NOD_CD" ).append("\n"); 
		query.append("     , P.POL_NOD_CD" ).append("\n"); 
		query.append("     , RCV_TERM_CD BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("     , DE_TERM_CD BKG_DE_TERM_CD" ).append("\n"); 
		query.append("     , OUT_BOUND OB_ITCHG_CTNT" ).append("\n"); 
		query.append("     , IN_BOUND IB_ITCHG_CTNT" ).append("\n"); 
		query.append("     , OCN OCN_ITCHG_CTNT" ).append("\n"); 
		query.append("     , DENSE_RANK() OVER ( ORDER BY  FULL_RANK DESC, FULL_ROUT ) COP_PATT_ORD_NO" ).append("\n"); 
		query.append("     , OB_FSH_FLG" ).append("\n"); 
		query.append("     , IB_FSH_FLG" ).append("\n"); 
		query.append(" FROM SUB_QUERY P" ).append("\n"); 
		query.append("    , SCE_COP_HDR H2" ).append("\n"); 
		query.append(" WHERE P.COP_NO = H2.COP_NO(+)" ).append("\n"); 

	}
}