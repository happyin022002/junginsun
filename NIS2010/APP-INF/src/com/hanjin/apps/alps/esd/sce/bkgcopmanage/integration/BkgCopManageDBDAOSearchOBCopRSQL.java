/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchOBCopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.18 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOSearchOBCopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주 지역은 BKG_EURO_TRO_DTL, 그 이외 지역은 BKG_TRO_DTL 을 참조하여 OUTBOUND 의 TRO 가 MAPPING 될 COP 정보를 조회한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOSearchOBCopRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("area_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_sub_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOSearchOBCopRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("  COP_NO" ).append("\n"); 
		query.append(", BKG_NO" ).append("\n"); 
		query.append(", ACT_STS_CD" ).append("\n"); 
		query.append(", AFT_PLN_DT PLAN_DT" ).append("\n"); 
		query.append(", A.VSL_CD VSL_CD" ).append("\n"); 
		query.append(", A.SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append(", A.SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append(", CLPT_IND_SEQ" ).append("\n"); 
		query.append(", MTY_PKUP_YD_CD" ).append("\n"); 
		query.append(", POR_NOD_CD" ).append("\n"); 
		query.append(", FULL_RTN_YD_CD" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", MST_COP_NO" ).append("\n"); 
		query.append(", MST_FLG" ).append("\n"); 
		query.append(", MST_COP_ORD" ).append("\n"); 
		query.append(", (SELECT BKG_NO FROM SCE_COP_HDR WHERE COP_NO = A.MST_COP_NO AND COP_STS_CD != 'X' AND ROWNUM = 1) AS MST_BKG_NO" ).append("\n"); 
		query.append(", CNTR_ORD" ).append("\n"); 
		query.append(", CNTR_TPSZ_ORD" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("      D.COP_NO" ).append("\n"); 
		query.append("    , H.BKG_NO" ).append("\n"); 
		query.append("    , H.MST_COP_NO" ).append("\n"); 
		query.append("    , DECODE(H.MST_COP_NO, H.COP_NO, 'Y', 'N') AS MST_FLG" ).append("\n"); 
		query.append("    , DECODE(H.MST_COP_NO, H.COP_NO, 0, 1) AS MST_COP_ORD" ).append("\n"); 
		query.append("    , DECODE(H.CNTR_NO, 'SMCU0000000', 1, 0) AS CNTR_ORD" ).append("\n"); 
		query.append("    , D.ACT_STS_CD" ).append("\n"); 
		query.append("    , P.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("    , P.POR_NOD_CD" ).append("\n"); 
		query.append("    , P.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("    , LEAD(D.PLN_DT, 1) OVER (PARTITION BY D.COP_NO ORDER BY D.COP_NO, D.COP_DTL_SEQ) AFT_PLN_DT" ).append("\n"); 
		query.append("    , LEAD(D.VSL_CD, 1) OVER (PARTITION BY D.COP_NO ORDER BY D.COP_NO, D.COP_DTL_SEQ) VSL_CD" ).append("\n"); 
		query.append("    , LEAD(D.SKD_VOY_NO, 1) OVER (PARTITION BY D.COP_NO ORDER BY D.COP_NO, D.COP_DTL_SEQ) SKD_VOY_NO" ).append("\n"); 
		query.append("    , LEAD(D.SKD_DIR_CD, 1) OVER (PARTITION BY D.COP_NO ORDER BY D.COP_NO, D.COP_DTL_SEQ) SKD_DIR_CD" ).append("\n"); 
		query.append("    , LEAD(D.CLPT_IND_SEQ, 1) OVER (PARTITION BY D.COP_NO ORDER BY D.COP_NO, D.COP_DTL_SEQ) CLPT_IND_SEQ" ).append("\n"); 
		query.append("    , D.ACT_CD" ).append("\n"); 
		query.append("    , H.CNTR_NO" ).append("\n"); 
		query.append("    , CNTR_TPSZ_ORD" ).append("\n"); 
		query.append("    , H.CNTR_TPSZ_CD    " ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("      SCE_COP_HDR H" ).append("\n"); 
		query.append("    , SCE_COP_DTL D" ).append("\n"); 
		query.append("    , PRD_PROD_CTL_MST P" ).append("\n"); 
		query.append("#if (${area_conti_cd} == 'E')" ).append("\n"); 
		query.append("    , (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          TD1.BKG_NO" ).append("\n"); 
		query.append("        , TD1.IO_BND_CD" ).append("\n"); 
		query.append("        , TD1.TRO_SEQ" ).append("\n"); 
		query.append("        , TD1.TRO_SUB_SEQ" ).append("\n"); 
		query.append("        , TH1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , '1' AS CNTR_TPSZ_ORD" ).append("\n"); 
		query.append("         FROM BKG_EUR_TRO TH1, BKG_EUR_TRO_DTL TD1" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND TD1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          AND TD1.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("          AND TD1.TRO_SEQ = @[tro_seq]" ).append("\n"); 
		query.append("          AND TD1.TRO_SUB_SEQ = @[tro_sub_seq]          " ).append("\n"); 
		query.append("          AND TH1.BKG_NO = TD1.BKG_NO" ).append("\n"); 
		query.append("          AND TH1.IO_BND_CD = TD1.IO_BND_CD" ).append("\n"); 
		query.append("          AND TH1.TRO_SEQ = TD1.TRO_SEQ" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          TD2.BKG_NO" ).append("\n"); 
		query.append("        , TD2.IO_BND_CD" ).append("\n"); 
		query.append("        , TD2.TRO_SEQ" ).append("\n"); 
		query.append("        , TD2.TRO_SUB_SEQ" ).append("\n"); 
		query.append("        , PROV_CNTR_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , '2' AS CNTR_TPSZ_ORD" ).append("\n"); 
		query.append("         FROM BKG_EUR_TRO TH2, BKG_EUR_TRO_DTL TD2, BKG_BOOKING B, SCE_COP_CNTR_REPO_RULE R" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND TD2.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          AND TD2.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("          AND TD2.TRO_SEQ = @[tro_seq]" ).append("\n"); 
		query.append("          AND TD2.TRO_SUB_SEQ = @[tro_sub_seq]" ).append("\n"); 
		query.append("          AND TH2.BKG_NO = TD2.BKG_NO" ).append("\n"); 
		query.append("          AND TH2.IO_BND_CD = TD2.IO_BND_CD" ).append("\n"); 
		query.append("          AND TH2.TRO_SEQ = TD2.TRO_SEQ" ).append("\n"); 
		query.append("          AND TH2.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("          AND B.FLEX_HGT_FLG = 'Y'" ).append("\n"); 
		query.append("          AND TH2.CNTR_TPSZ_CD = R.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ) T" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    , (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          T1.BKG_NO" ).append("\n"); 
		query.append("        , T1.IO_BND_CD" ).append("\n"); 
		query.append("        , T1.TRO_SEQ" ).append("\n"); 
		query.append("        , T1.TRO_SUB_SEQ" ).append("\n"); 
		query.append("        , T1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , '1' AS CNTR_TPSZ_ORD" ).append("\n"); 
		query.append("         FROM BKG_TRO_DTL T1" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND T1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          AND T1.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("          AND T1.TRO_SEQ = @[tro_seq]" ).append("\n"); 
		query.append("          AND T1.TRO_SUB_SEQ = @[tro_sub_seq]" ).append("\n"); 
		query.append("          AND NVL(T1.RTN_TRO_FLG,'N') = 'N' -- 'Y' 인건은 S/O 가 발생하지 않으며 한국지역에서만 생김" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("          T2.BKG_NO" ).append("\n"); 
		query.append("        , T2.IO_BND_CD" ).append("\n"); 
		query.append("        , T2.TRO_SEQ" ).append("\n"); 
		query.append("        , T2.TRO_SUB_SEQ" ).append("\n"); 
		query.append("        , PROV_CNTR_TPSZ_CD AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , '2' AS CNTR_TPSZ_ORD" ).append("\n"); 
		query.append("         FROM BKG_TRO_DTL T2, BKG_BOOKING B, SCE_COP_CNTR_REPO_RULE R" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND T2.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          AND T2.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("          AND T2.TRO_SEQ = @[tro_seq]" ).append("\n"); 
		query.append("          AND T2.TRO_SUB_SEQ = @[tro_sub_seq]               " ).append("\n"); 
		query.append("          AND T2.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("          AND B.FLEX_HGT_FLG = 'Y'" ).append("\n"); 
		query.append("          AND T2.CNTR_TPSZ_CD = R.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          AND NVL(T2.RTN_TRO_FLG,'N') = 'N' -- 'Y' 인건은 S/O 가 발생하지 않으며 한국지역에서만 생김" ).append("\n"); 
		query.append("      ) T" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    WHERE H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND H.BKG_NO = T.BKG_NO" ).append("\n"); 
		query.append("      AND H.PCTL_NO = P.PCTL_NO" ).append("\n"); 
		query.append("      AND H.CNTR_TPSZ_CD = T.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("      AND NOT EXISTS (SELECT 'X' FROM SCE_TRO_MAPG M WHERE 1=1 AND M.COP_NO = H.COP_NO AND AREA_CONTI_CD=@[area_conti_cd])" ).append("\n"); 
		query.append("      AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("      AND D.ACT_CD IN ('FLWMLO','FLVMLO','FLWMDO','FLVMDO')" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND A.ACT_CD IN ('FLWMLO','FLVMLO')" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("  MST_COP_ORD" ).append("\n"); 
		query.append(", CNTR_ORD" ).append("\n"); 
		query.append(", CNTR_TPSZ_ORD" ).append("\n"); 

	}
}