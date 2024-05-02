/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BkgCopManageDBDAOSearchOBCopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
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
		query.append("SELECT COP_NO, BKG_NO," ).append("\n"); 
		query.append("  ACT_STS_CD," ).append("\n"); 
		query.append("  AFT_PLN_DT PLAN_DT," ).append("\n"); 
		query.append("  A.VSL_CD VSL_CD," ).append("\n"); 
		query.append("  A.SKD_VOY_NO SKD_VOY_NO," ).append("\n"); 
		query.append("  A.SKD_DIR_CD SKD_DIR_CD," ).append("\n"); 
		query.append("  CLPT_IND_SEQ," ).append("\n"); 
		query.append("  MTY_PKUP_YD_CD," ).append("\n"); 
		query.append("  POR_NOD_CD," ).append("\n"); 
		query.append("  FULL_RTN_YD_CD," ).append("\n"); 
		query.append("  CNTR_NO," ).append("\n"); 
		query.append("  MST_COP_NO," ).append("\n"); 
		query.append("  MST_FLG," ).append("\n"); 
		query.append("  MST_COP_ORD," ).append("\n"); 
		query.append("  (SELECT BKG_NO FROM SCE_COP_HDR WHERE COP_NO = A.MST_COP_NO AND COP_STS_CD != 'X' AND ROWNUM = 1) AS MST_BKG_NO," ).append("\n"); 
		query.append("  CNTR_ORD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT D.COP_NO COP_NO, H.BKG_NO AS BKG_NO, H.MST_COP_NO," ).append("\n"); 
		query.append("	  DECODE(H.MST_COP_NO, H.COP_NO, 'Y', 'N') AS MST_FLG," ).append("\n"); 
		query.append("	  DECODE(H.MST_COP_NO, H.COP_NO, 0, 1) AS MST_COP_ORD," ).append("\n"); 
		query.append("	  DECODE(H.CNTR_NO, 'COMU0000000', 1, 0) AS CNTR_ORD," ).append("\n"); 
		query.append("      D.ACT_STS_CD ACT_STS_CD ," ).append("\n"); 
		query.append("	  P.MTY_PKUP_YD_CD," ).append("\n"); 
		query.append("	  P.POR_NOD_CD," ).append("\n"); 
		query.append("	  P.FULL_RTN_YD_CD," ).append("\n"); 
		query.append("      LEAD(D.PLN_DT, 1) OVER (PARTITION BY D.COP_NO ORDER BY D.COP_NO, D.COP_DTL_SEQ) AFT_PLN_DT ," ).append("\n"); 
		query.append("      LEAD(D.VSL_CD, 1) OVER (PARTITION BY D.COP_NO ORDER BY D.COP_NO, D.COP_DTL_SEQ) VSL_CD ," ).append("\n"); 
		query.append("      LEAD(D.SKD_VOY_NO, 1) OVER (PARTITION BY D.COP_NO ORDER BY D.COP_NO, D.COP_DTL_SEQ) SKD_VOY_NO ," ).append("\n"); 
		query.append("      LEAD(D.SKD_DIR_CD, 1) OVER (PARTITION BY D.COP_NO ORDER BY D.COP_NO, D.COP_DTL_SEQ) SKD_DIR_CD ," ).append("\n"); 
		query.append("      D.ACT_CD ," ).append("\n"); 
		query.append("      LEAD(D.CLPT_IND_SEQ, 1) OVER (PARTITION BY D.COP_NO  ORDER BY D.COP_NO, D.COP_DTL_SEQ) CLPT_IND_SEQ," ).append("\n"); 
		query.append("	  H.CNTR_NO" ).append("\n"); 
		query.append("    FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("      SCE_COP_DTL D," ).append("\n"); 
		query.append("	  PRD_PROD_CTL_MST P," ).append("\n"); 
		query.append("	  BKG_BOOKING B, 	" ).append("\n"); 
		query.append("#if (${area_conti_cd} == 'E') " ).append("\n"); 
		query.append("	  BKG_EUR_TRO TRO_HDR,  -- 구주" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${area_conti_cd} == 'X')" ).append("\n"); 
		query.append("		BKG_TRO_DTL TRO_DTL -- 구주가 아닐경우" ).append("\n"); 
		query.append("#elseif (${area_conti_cd} == 'E') " ).append("\n"); 
		query.append("		BKG_EUR_TRO_DTL TRO_DTL  -- 구주" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    WHERE H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND H.BKG_NO = TRO_DTL.BKG_NO" ).append("\n"); 
		query.append("	  AND H.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	  AND H.PCTL_NO = P.PCTL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${area_conti_cd} == 'E') " ).append("\n"); 
		query.append("	  AND TRO_HDR.BKG_NO = TRO_DTL.BKG_NO" ).append("\n"); 
		query.append("	  AND TRO_HDR.IO_BND_CD = TRO_DTL.IO_BND_CD" ).append("\n"); 
		query.append("	  AND TRO_HDR.TRO_SEQ = TRO_DTL.TRO_SEQ" ).append("\n"); 
		query.append("	  AND TRO_HDR.CNTR_TPSZ_CD = H.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND TRO_DTL.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("      AND TRO_DTL.TRO_SEQ = @[tro_seq]" ).append("\n"); 
		query.append("      AND TRO_DTL.TRO_SUB_SEQ = @[tro_sub_seq]" ).append("\n"); 
		query.append("#if (${area_conti_cd} == 'X')" ).append("\n"); 
		query.append("      --AND TRO_DTL.CNTR_TPSZ_CD = H.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      AND (CASE WHEN NVL(B.FLEX_HGT_FLG, 'N') = 'Y' AND H.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("																			  SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("																				FROM SCE_COP_CNTR_REPO_RULE" ).append("\n"); 
		query.append("																			   WHERE (CNTR_TPSZ_CD = TRO_DTL.CNTR_TPSZ_CD OR PROV_CNTR_TPSZ_CD = TRO_DTL.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("																				 AND NVL(ACT_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("																			  UNION ALL" ).append("\n"); 
		query.append("																			  SELECT TRO_DTL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("																				FROM DUAL" ).append("\n"); 
		query.append("																		  ) THEN  'TRUE'" ).append("\n"); 
		query.append("                WHEN NVL(B.FLEX_HGT_FLG, 'N') = 'N' AND TRO_DTL.CNTR_TPSZ_CD = H.CNTR_TPSZ_CD THEN 'TRUE'" ).append("\n"); 
		query.append("                ELSE 'FALSE'" ).append("\n"); 
		query.append("         END) = 'TRUE'" ).append("\n"); 
		query.append("	  AND NVL(TRO_DTL.RTN_TRO_FLG, 'N') = 'N' -- 'Y' 인건은 S/O 가 발생하지 않으며 한국지역에서만 생김" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("	  AND NVL(H.OB_TRO_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("      AND H.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("      AND D.ACT_CD IN ('FLWMLO','FLVMLO','FLWMDO','FLVMDO') " ).append("\n"); 
		query.append("      ) A" ).append("\n"); 
		query.append("WHERE A.ACT_CD IN ('FLWMLO','FLVMLO')" ).append("\n"); 
		query.append("ORDER BY MST_COP_ORD, CNTR_ORD" ).append("\n"); 

	}
}