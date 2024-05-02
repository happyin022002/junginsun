/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfCgoClassRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfCgoClassRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfCgoClassRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfCgoClassRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO, A.BL_NO, A.WHF_BND_CD, A.CSTMS_DECL_TP_CD AS T," ).append("\n"); 
		query.append("       A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("       A.WHF_POL_CD AS POL_CD, A.WHF_POD_CD AS POD_CD," ).append("\n"); 
		query.append("       A.CMDT_CD," ).append("\n"); 
		query.append("       A.WGT_QTY / 1000 AS WGT_QTY," ).append("\n"); 
		query.append("       A.WGT_UT_CD," ).append("\n"); 
		query.append("       A.MEAS_QTY AS MEAS_QTY," ).append("\n"); 
		query.append("       A.MEAS_UT_CD," ).append("\n"); 
		query.append("       CASE WHEN A.CSTMS_DECL_TP_CD IN ('T', 'R') THEN 0" ).append("\n"); 
		query.append("            WHEN A.WFG_EXPT_CD IN ('S', 'D', 'X', 'I', 'J', 'K') THEN 0" ).append("\n"); 
		query.append("            WHEN A.WHF_RT_UPD_STS_CD = 'C' THEN X.WHF_RT_CNTR_WHF_AMT + NVL(CASE WHEN A.WFG_EXPT_CD = 'B' THEN X.WHF_RT_BLK_WHF_AMT END, 0)" ).append("\n"); 
		query.append("            ELSE A.WHF_AMT" ).append("\n"); 
		query.append("       END AS WHF_AMT," ).append("\n"); 
		query.append("	   CASE WHEN A.CSTMS_DECL_TP_CD IN ('T', 'R') THEN 0" ).append("\n"); 
		query.append("            WHEN A.WFG_EXPT_CD IN ('S', 'D', 'X', 'I', 'J', 'K') THEN 0" ).append("\n"); 
		query.append("            WHEN A.WHF_RT_UPD_STS_CD = 'C' THEN X.WHF_RT_CNTR_WHF_AMT + NVL(CASE WHEN A.WFG_EXPT_CD = 'B' THEN X.WHF_RT_BLK_WHF_AMT END, 0)" ).append("\n"); 
		query.append("            ELSE A.WHF_AMT" ).append("\n"); 
		query.append("       END AS WHF_AMT_TEMP,	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       A.WFG_EXPT_CD," ).append("\n"); 
		query.append("       Z.ATTR_CTNT4 AS WFG_EXPT_DESC," ).append("\n"); 
		query.append("       CASE WHEN (A.CUST_RGST_NO IS NULL OR (LENGTH(A.CUST_RGST_NO) = 10 AND A.CUST_RGST_NO <> 'XXXXXXXXXX')) AND LENGTH(M.CUST_RGST_NO) = 10 THEN " ).append("\n"); 
		query.append("                 SUBSTR(M.CUST_RGST_NO, 1, 3) || '-' || SUBSTR(M.CUST_RGST_NO, 4, 2) || '-' || SUBSTR(M.CUST_RGST_NO, 6, 5)" ).append("\n"); 
		query.append("            ELSE A.CUST_RGST_NO" ).append("\n"); 
		query.append("       END AS CUST_RGST_NO," ).append("\n"); 
		query.append("       L.CUST_NM," ).append("\n"); 
		query.append("       A.XPT_REF_NO," ).append("\n"); 
		query.append("       CASE WHEN A.WHF_RT_UPD_STS_CD = 'C' THEN DECODE(A.WHF_PCK_TP_CD,'CNT',0,X.WHF_RT_RTON_WGT)" ).append("\n"); 
		query.append("            ELSE A.RTON_WGT" ).append("\n"); 
		query.append("       END AS RTON_WGT," ).append("\n"); 
		query.append("       DECODE(A.WHF_RT_UPD_STS_CD, 'U', A.WHF_CNTR_20FT_QTY, X.WHF_CNTR_20FT_QTY) AS WHF_CNTR_20FT_QTY," ).append("\n"); 
		query.append("       DECODE(A.WHF_RT_UPD_STS_CD, 'U', A.WHF_CNTR_40FT_QTY, X.WHF_CNTR_40FT_QTY) AS WHF_CNTR_40FT_QTY," ).append("\n"); 
		query.append("       DECODE(A.WHF_RT_UPD_STS_CD, 'U', A.WHF_CNTR_45FT_QTY, X.WHF_CNTR_45FT_QTY) AS WHF_CNTR_45FT_QTY," ).append("\n"); 
		query.append("       DECODE(A.WHF_RT_UPD_STS_CD, 'U', A.WHF_BLK_20FT_QTY, X.WHF_BLK_20FT_QTY) AS WHF_BLK_20FT_QTY," ).append("\n"); 
		query.append("       DECODE(A.WHF_RT_UPD_STS_CD, 'U', A.WHF_BLK_40FT_QTY, X.WHF_BLK_40FT_QTY) AS WHF_BLK_40FT_QTY," ).append("\n"); 
		query.append("       DECODE(A.WHF_RT_UPD_STS_CD, 'U', A.WHF_BLK_45FT_QTY, X.WHF_BLK_45FT_QTY) AS WHF_BLK_45FT_QTY," ).append("\n"); 
		query.append("       DECODE(A.WHF_RT_UPD_STS_CD, 'U', A.BLK_WGT_QTY, X.BLK_WGT_QTY) AS BLK_WGT_QTY2," ).append("\n"); 
		query.append("	   DECODE(A.WHF_PCK_TP_CD,'CNT','0', DECODE(A.WHF_RT_UPD_STS_CD, 'U', A.BLK_WGT_QTY, X.BLK_WGT_QTY))  AS BLK_WGT_QTY," ).append("\n"); 
		query.append("       DECODE(A.WHF_RT_UPD_STS_CD, 'U', A.BLK_MEAS_QTY, X.BLK_MEAS_QTY) AS BLK_MEAS_QTY2," ).append("\n"); 
		query.append("       DECODE(A.WHF_PCK_TP_CD,'CNT','0', DECODE(A.WHF_RT_UPD_STS_CD, 'U', A.BLK_MEAS_QTY, X.BLK_MEAS_QTY)) AS BLK_MEAS_QTY," ).append("\n"); 
		query.append("       DECODE(A.WHF_RT_UPD_STS_CD, 'U', A.WHF_BKG_20FT_QTY, X.WHF_BKG_20FT_QTY) AS WHF_BKG_20FT_QTY," ).append("\n"); 
		query.append("       DECODE(A.WHF_RT_UPD_STS_CD, 'U', A.WHF_BKG_40FT_QTY, X.WHF_BKG_40FT_QTY) AS WHF_BKG_40FT_QTY," ).append("\n"); 
		query.append("       DECODE(A.WHF_RT_UPD_STS_CD, 'U', A.WHF_BKG_45FT_QTY, X.WHF_BKG_45FT_QTY) AS WHF_BKG_45FT_QTY," ).append("\n"); 
		query.append("       A.WHF_PCK_TP_CD," ).append("\n"); 
		query.append("       A1.WHF_RT," ).append("\n"); 
		query.append("       DECODE(A.WHF_RT_UPD_STS_CD, 'U', A.DC_FLG, DECODE(NVL(TRIM(WHF_VOL_DC_CD), '0'), '0', 'N', 'Y')) AS DC_FLG," ).append("\n"); 
		query.append("--     A.DC_FLG," ).append("\n"); 
		query.append("	   A.TAX_TEU_QTY," ).append("\n"); 
		query.append("       A.TAX_FEU_QTY," ).append("\n"); 
		query.append("       A.TAX_45FT_QTY," ).append("\n"); 
		query.append("       A.EXPT_TEU_QTY," ).append("\n"); 
		query.append("       A.EXPT_FEU_QTY," ).append("\n"); 
		query.append("       A.EXPT_45FT_QTY," ).append("\n"); 
		query.append("DECODE(A.WHF_RT_UPD_STS_CD, 'U', '', 'I') AS IBFLAG	" ).append("\n"); 
		query.append("  FROM ( SELECT B.VSL_CD," ).append("\n"); 
		query.append("          B.SKD_VOY_NO," ).append("\n"); 
		query.append("          B.SKD_DIR_CD," ).append("\n"); 
		query.append("          B.WHF_BND_CD," ).append("\n"); 
		query.append("          B.BKG_NO," ).append("\n"); 
		query.append("          B.BL_NO," ).append("\n"); 
		query.append("          NVL(C.UN_LOC_ID, B.WHF_POL_CD) AS WHF_POL_CD," ).append("\n"); 
		query.append("          NVL(D.UN_LOC_ID, B.WHF_POD_CD) AS WHF_POD_CD," ).append("\n"); 
		query.append("          B.CSTMS_DECL_TP_CD," ).append("\n"); 
		query.append("          NVL(B.WGT_QTY, 0) AS WGT_QTY," ).append("\n"); 
		query.append("          B.WGT_UT_CD," ).append("\n"); 
		query.append("          NVL(B.MEAS_QTY, 0) AS MEAS_QTY," ).append("\n"); 
		query.append("          B.MEAS_UT_CD," ).append("\n"); 
		query.append("          CASE WHEN F.CNTR_FULL_FLG = 'N' THEN 'D'" ).append("\n"); 
		query.append("               WHEN B.WFG_EXPT_CD IS NOT NULL THEN B.WFG_EXPT_CD" ).append("\n"); 
		query.append("               WHEN E.WHF_RT_EXIST_FLG = 'N' THEN G.BKG_RT_WHF_EXPT_CD" ).append("\n"); 
		query.append("          END AS WFG_EXPT_CD," ).append("\n"); 
		query.append("          NVL(B.CUST_RGST_NO, DECODE(E.WHF_RT_EXIST_FLG, 'N', G.WHF_SHPR_RGST_NO, NULL)) AS CUST_RGST_NO," ).append("\n"); 
		query.append("          NVL(B.RTON_WGT, 0) AS RTON_WGT," ).append("\n"); 
		query.append("          NVL(B.WHF_AMT, 0) AS WHF_AMT," ).append("\n"); 
		query.append("          NVL(B.CMDT_CD, '630700') AS CMDT_CD," ).append("\n"); 
		query.append("          H.CUST_NM AS XPT_REF_NO," ).append("\n"); 
		query.append("          I.DC_FLG," ).append("\n"); 
		query.append("		  I.TAX_TEU_QTY," ).append("\n"); 
		query.append("		  I.TAX_FEU_QTY," ).append("\n"); 
		query.append("		  I.TAX_45FT_QTY," ).append("\n"); 
		query.append("		  I.EXPT_TEU_QTY," ).append("\n"); 
		query.append("		  I.EXPT_FEU_QTY," ).append("\n"); 
		query.append("		  I.EXPT_45FT_QTY,	" ).append("\n"); 
		query.append("          I.TAX_TEU_QTY  + I.EXPT_TEU_QTY  AS WHF_CNTR_20FT_QTY," ).append("\n"); 
		query.append("          I.TAX_FEU_QTY  + I.EXPT_FEU_QTY  AS WHF_CNTR_40FT_QTY," ).append("\n"); 
		query.append("          I.TAX_45FT_QTY + I.EXPT_45FT_QTY AS WHF_CNTR_45FT_QTY," ).append("\n"); 
		query.append("          I.BLK_TEU_QTY  AS WHF_BLK_20FT_QTY," ).append("\n"); 
		query.append("          I.BLK_FEU_QTY  AS WHF_BLK_40FT_QTY," ).append("\n"); 
		query.append("          I.BLK_45FT_QTY AS WHF_BLK_45FT_QTY," ).append("\n"); 
		query.append("          I.CNTR_TPSZ_TEU_QTY AS WHF_BKG_20FT_QTY," ).append("\n"); 
		query.append("          I.CNTR_TPSZ_FEU_QTY AS WHF_BKG_40FT_QTY," ).append("\n"); 
		query.append("          I.CNTR_TPSZ_45FT_QTY AS WHF_BKG_45FT_QTY," ).append("\n"); 
		query.append("          NVL(I.KR_CSTMS_FRT_TP_CD, 'CNT') AS WHF_PCK_TP_CD," ).append("\n"); 
		query.append("          I.BB_CGO_WGT AS BLK_WGT_QTY," ).append("\n"); 
		query.append("          I.BLK_MEAS_QTY AS BLK_MEAS_QTY," ).append("\n"); 
		query.append("          I.RTON_WGT AS WHF_RT_RTON_WGT," ).append("\n"); 
		query.append("          I.NEW_CHG_AMT AS WHF_RT_WHF_AMT," ).append("\n"); 
		query.append("          CASE WHEN I.VSL_CD IS NULL THEN 'C' ELSE 'U' END AS WHF_RT_UPD_STS_CD" ).append("\n"); 
		query.append("     FROM ( SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.WHF_BND_CD, A.BL_NO, A.BKG_NO," ).append("\n"); 
		query.append("          A.WGT_QTY, A.MEAS_QTY," ).append("\n"); 
		query.append("          MAX(CHG_RT_SEQ) AS CHG_RT_SEQ" ).append("\n"); 
		query.append("     FROM BKG_KR_WHF_BL A, BKG_KR_WHF_RT B" ).append("\n"); 
		query.append("    WHERE A.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("      AND A.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("      AND A.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#if (${whf_bnd_cd} == 'II' || ${whf_bnd_cd} == 'IN' || ${whf_bnd_cd} == 'IT' || ${whf_bnd_cd} == 'IM')" ).append("\n"); 
		query.append("      AND A.WHF_POD_CD = @[port_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      AND A.WHF_POL_CD = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND A.WHF_BND_CD IN (DECODE(@[whf_bnd_cd], 'IN', 'II','ON', 'OO', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IT','ON', 'OT', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IM','ON', 'OM', @[whf_bnd_cd]))" ).append("\n"); 
		query.append("      AND A.WHF_BL_STS_CD <> 'D'" ).append("\n"); 
		query.append("      AND B.VSL_CD(+) = A.VSL_CD" ).append("\n"); 
		query.append("      AND B.SKD_VOY_NO(+) = A.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND B.SKD_DIR_CD(+) = A.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND B.WHF_BND_CD(+) = A.WHF_BND_CD" ).append("\n"); 
		query.append("      AND B.BL_NO(+) = A.BL_NO" ).append("\n"); 
		query.append("    GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.WHF_BND_CD, A.BL_NO, A.BKG_NO," ).append("\n"); 
		query.append("             A.WGT_QTY, A.MEAS_QTY ) A, BKG_KR_WHF_BL B, BKG_CSTMS_LOC C, BKG_CSTMS_LOC D," ).append("\n"); 
		query.append("          ( SELECT DECODE(COUNT(1), 1, 'Y', 'N') WHF_RT_EXIST_FLG" ).append("\n"); 
		query.append("     FROM DUAL" ).append("\n"); 
		query.append("    WHERE EXISTS (SELECT '*'" ).append("\n"); 
		query.append("                    FROM BKG_KR_WHF_RT A" ).append("\n"); 
		query.append("                   WHERE A.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                     AND A.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                     AND A.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                     AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                     AND A.WHF_BND_CD = DECODE(@[whf_bnd_cd], 'IN', 'II','ON','OO', @[whf_bnd_cd])) ) E, ( SELECT A.BL_NO, MIN(B.CNTR_FULL_FLG) AS CNTR_FULL_FLG" ).append("\n"); 
		query.append("     FROM ( SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.WHF_BND_CD, A.BL_NO, A.BKG_NO," ).append("\n"); 
		query.append("          A.WGT_QTY, A.MEAS_QTY," ).append("\n"); 
		query.append("          MAX(CHG_RT_SEQ) AS CHG_RT_SEQ" ).append("\n"); 
		query.append("     FROM BKG_KR_WHF_BL A, BKG_KR_WHF_RT B" ).append("\n"); 
		query.append("    WHERE A.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("      AND A.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("      AND A.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#if (${whf_bnd_cd} == 'II' || ${whf_bnd_cd} == 'IN' || ${whf_bnd_cd} == 'IT' || ${whf_bnd_cd} == 'IM')" ).append("\n"); 
		query.append("      AND A.WHF_POD_CD = @[port_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      AND A.WHF_POL_CD = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND A.WHF_BND_CD IN (DECODE(@[whf_bnd_cd], 'IN', 'II','ON', 'OO', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IT','ON', 'OT', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IM','ON', 'OM', @[whf_bnd_cd]))" ).append("\n"); 
		query.append("      AND A.WHF_BL_STS_CD <> 'D'" ).append("\n"); 
		query.append("      AND B.VSL_CD(+) = A.VSL_CD" ).append("\n"); 
		query.append("      AND B.SKD_VOY_NO(+) = A.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND B.SKD_DIR_CD(+) = A.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND B.WHF_BND_CD(+) = A.WHF_BND_CD" ).append("\n"); 
		query.append("      AND B.BL_NO(+) = A.BL_NO" ).append("\n"); 
		query.append("    GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.WHF_BND_CD, A.BL_NO, A.BKG_NO," ).append("\n"); 
		query.append("             A.WGT_QTY, A.MEAS_QTY ) A, BKG_KR_WHF_CNTR B" ).append("\n"); 
		query.append("    WHERE B.VSL_CD(+) = A.VSL_CD" ).append("\n"); 
		query.append("      AND B.SKD_VOY_NO(+) = A.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND B.SKD_DIR_CD(+) = A.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND B.BL_NO(+) = A.BL_NO" ).append("\n"); 
		query.append("    GROUP BY A.BL_NO ) F, BKG_RATE G, BKG_KR_WHF_CUST H," ).append("\n"); 
		query.append("          BKG_KR_WHF_RT I" ).append("\n"); 
		query.append("    WHERE B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("      AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND B.WHF_BND_CD = A.WHF_BND_CD" ).append("\n"); 
		query.append("      AND B.BL_NO = A.BL_NO" ).append("\n"); 
		query.append("      AND C.CNT_CD(+) = 'KR'" ).append("\n"); 
		query.append("      AND C.CSTMS_DIV_ID(+) = 'WHF'" ).append("\n"); 
		query.append("      AND C.LOC_CD(+) = B.WHF_POL_CD" ).append("\n"); 
		query.append("      AND C.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("      AND D.CNT_CD(+) = 'KR'" ).append("\n"); 
		query.append("      AND D.CSTMS_DIV_ID(+) = 'WHF'" ).append("\n"); 
		query.append("      AND D.LOC_CD(+) = B.WHF_POD_CD" ).append("\n"); 
		query.append("      AND D.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("      AND F.BL_NO(+) = B.BL_NO" ).append("\n"); 
		query.append("      AND G.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("      AND H.VSL_CD(+) = B.VSL_CD" ).append("\n"); 
		query.append("      AND H.SKD_VOY_NO(+) = B.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND H.SKD_DIR_CD(+) = B.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND H.BL_NO(+) = B.BL_NO" ).append("\n"); 
		query.append("      AND H.BKG_CUST_TP_CD(+) = 'E'" ).append("\n"); 
		query.append("      AND I.VSL_CD(+) = A.VSL_CD" ).append("\n"); 
		query.append("      AND I.SKD_VOY_NO(+) = A.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND I.SKD_DIR_CD(+) = A.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND I.WHF_BND_CD(+) = A.WHF_BND_CD" ).append("\n"); 
		query.append("      AND I.BL_NO(+) = A.BL_NO" ).append("\n"); 
		query.append("      AND I.CHG_RT_SEQ(+) = A.CHG_RT_SEQ ) A," ).append("\n"); 
		query.append("       BKG_BOOKING K," ).append("\n"); 
		query.append("       BKG_CUSTOMER L," ).append("\n"); 
		query.append("       MDM_CUSTOMER M," ).append("\n"); 
		query.append("       (SELECT DISTINCT T.VSL_CD, T.SKD_VOY_NO, T.SKD_DIR_CD, T.WHF_BND_CD, T.BL_NO," ).append("\n"); 
		query.append("               T.WHF_CNTR_20FT_QTY, T.WHF_CNTR_40FT_QTY, T.WHF_CNTR_45FT_QTY," ).append("\n"); 
		query.append("               T.WHF_BLK_20FT_QTY, T.WHF_BLK_40FT_QTY, T.WHF_BLK_45FT_QTY," ).append("\n"); 
		query.append("               T.WHF_BKG_20FT_QTY, T.WHF_BKG_40FT_QTY, T.WHF_BKG_45FT_QTY," ).append("\n"); 
		query.append("               CASE WHEN NVL(T.WHF_BLK_20FT_QTY + T.WHF_BLK_40FT_QTY + T.WHF_BLK_45FT_QTY, 0) <> 0 THEN T.BLK_WGT_QTY" ).append("\n"); 
		query.append("                    ELSE 0" ).append("\n"); 
		query.append("               END AS BLK_WGT_QTY," ).append("\n"); 
		query.append("               CASE WHEN NVL(T.WHF_BLK_20FT_QTY + T.WHF_BLK_40FT_QTY + T.WHF_BLK_45FT_QTY, 0) <> 0 THEN T.BLK_MEAS_QTY" ).append("\n"); 
		query.append("                    ELSE 0" ).append("\n"); 
		query.append("               END AS BLK_MEAS_QTY," ).append("\n"); 
		query.append("               T.RTON_WGT AS WHF_RT_RTON_WGT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   CASE WHEN @[port_cd] = 'KRPTK' THEN" ).append("\n"); 
		query.append("               		T.WHF_CNTR_20FT_QTY * ROUND(NVL(V.TEU_PRC, 0) * (1 - NVL(V.TEU_AMT_RT, 0)),0) +" ).append("\n"); 
		query.append("               		T.WHF_CNTR_40FT_QTY * ROUND(NVL(V.FEU_PRC, 0) * (1 - NVL(V.FEU_AMT_RT, 0)),0) +" ).append("\n"); 
		query.append("               		T.WHF_CNTR_45FT_QTY * ROUND(NVL(V.HC_PRC, 0) * (1 - NVL(V.HC_AMT_RT, 0)),0)" ).append("\n"); 
		query.append("			   ELSE" ).append("\n"); 
		query.append("               		ROUND(T.WHF_CNTR_20FT_QTY * NVL(V.TEU_PRC, 0) * (1 - NVL(V.TEU_AMT_RT, 0)) +" ).append("\n"); 
		query.append("               		T.WHF_CNTR_40FT_QTY * NVL(V.FEU_PRC, 0) * (1 - NVL(V.FEU_AMT_RT, 0)) +" ).append("\n"); 
		query.append("               		T.WHF_CNTR_45FT_QTY * NVL(V.HC_PRC, 0) * (1 - NVL(V.HC_AMT_RT, 0)),0)" ).append("\n"); 
		query.append("               END AS WHF_RT_CNTR_WHF_AMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               DECODE(T.WGT_MEAS_TP_CD, 'E', TRUNC(T.BLK_MEAS_QTY * 0.833 + 0.999, 0), TRUNC(T.BLK_WGT_QTY + 0.999, 0)) * NVL(W.TEU_PRC, 0) * (1 - NVL(W.TEU_AMT_RT, 0)) AS WHF_RT_BLK_WHF_AMT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               T.WGT_MEAS_TP_CD," ).append("\n"); 
		query.append("               U.WHF_VOL_DC_CD" ).append("\n"); 
		query.append("          FROM ( SELECT C.VSL_CD, C.SKD_VOY_NO, C.SKD_DIR_CD, C.WHF_BND_CD, C.BL_NO," ).append("\n"); 
		query.append("          C.WHF_CNTR_20FT_QTY, C.WHF_CNTR_40FT_QTY, C.WHF_CNTR_45FT_QTY," ).append("\n"); 
		query.append("          C.WHF_BLK_20FT_QTY, C.WHF_BLK_40FT_QTY, C.WHF_BLK_45FT_QTY," ).append("\n"); 
		query.append("          F.WHF_BKG_20FT_QTY, F.WHF_BKG_40FT_QTY, F.WHF_BKG_45FT_QTY," ).append("\n"); 
		query.append("          C.BLK_WGT_QTY," ).append("\n"); 
		query.append("          C.BLK_MEAS_QTY," ).append("\n"); 
		query.append("          C.RTON_WGT," ).append("\n"); 
		query.append("          C.WGT_MEAS_TP_CD" ).append("\n"); 
		query.append("     FROM (SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.WHF_BND_CD, A.BL_NO, " ).append("\n"); 
		query.append("                  SUM(CASE WHEN SUBSTR(B.CNTR_TPSZ_CD, 2, 1) = '2' AND B.RCV_TERM_CD NOT IN ('I', 'T') THEN DECODE(A.WHF_BND_CD,'OM',DECODE(B.CNTR_VOL_QTY,0,1,B.CNTR_VOL_QTY),'IM',DECODE(B.CNTR_VOL_QTY,0,1,B.CNTR_VOL_QTY),B.CNTR_VOL_QTY)" ).append("\n"); 
		query.append("                           ELSE 0" ).append("\n"); 
		query.append("                      END) AS WHF_CNTR_20FT_QTY," ).append("\n"); 
		query.append("                  SUM(CASE WHEN (SUBSTR(B.CNTR_TPSZ_CD, 2, 1) IN ('4', '5') OR B.CNTR_TPSZ_CD IN ('R8', 'R9')) AND B.RCV_TERM_CD NOT IN ('I', 'T') THEN DECODE(A.WHF_BND_CD,'OM',DECODE(B.CNTR_VOL_QTY,0,1,B.CNTR_VOL_QTY),'IM',DECODE(B.CNTR_VOL_QTY,0,1,B.CNTR_VOL_QTY),B.CNTR_VOL_QTY)" ).append("\n"); 
		query.append("                           ELSE 0" ).append("\n"); 
		query.append("                      END) AS WHF_CNTR_40FT_QTY," ).append("\n"); 
		query.append("                  SUM(CASE WHEN (SUBSTR(B.CNTR_TPSZ_CD, 2, 1) NOT IN ('2', '4', '5') AND B.CNTR_TPSZ_CD NOT IN ('R8', 'R9')) AND B.RCV_TERM_CD NOT IN ('I', 'T') THEN DECODE(A.WHF_BND_CD,'OM',DECODE(B.CNTR_VOL_QTY,0,1,B.CNTR_VOL_QTY),'IM',DECODE(B.CNTR_VOL_QTY,0,1,B.CNTR_VOL_QTY),B.CNTR_VOL_QTY)" ).append("\n"); 
		query.append("                           ELSE 0" ).append("\n"); 
		query.append("                      END) AS WHF_CNTR_45FT_QTY," ).append("\n"); 
		query.append("                  SUM(CASE WHEN SUBSTR(B.CNTR_TPSZ_CD, 2, 1) = '2' AND B.RCV_TERM_CD IN ('I', 'T') THEN B.CNTR_VOL_QTY" ).append("\n"); 
		query.append("                           ELSE 0" ).append("\n"); 
		query.append("                      END) AS WHF_BLK_20FT_QTY," ).append("\n"); 
		query.append("                  SUM(CASE WHEN (SUBSTR(B.CNTR_TPSZ_CD, 2, 1) IN ('4', '5') OR B.CNTR_TPSZ_CD IN ('R8', 'R9')) AND B.RCV_TERM_CD IN ('I', 'T') THEN B.CNTR_VOL_QTY" ).append("\n"); 
		query.append("                           ELSE 0" ).append("\n"); 
		query.append("                      END) AS WHF_BLK_40FT_QTY," ).append("\n"); 
		query.append("                  SUM(CASE WHEN (SUBSTR(B.CNTR_TPSZ_CD, 2, 1) NOT IN ('2', '4', '5') AND B.CNTR_TPSZ_CD NOT IN ('R8', 'R9')) AND B.RCV_TERM_CD IN ('I', 'T') THEN B.CNTR_VOL_QTY" ).append("\n"); 
		query.append("                           ELSE 0" ).append("\n"); 
		query.append("                      END) AS WHF_BLK_45FT_QTY," ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                  MAX(A.WGT_QTY) - SUM(DECODE(B.RCV_TERM_CD, 'I', 0, 'T', 0, TRUNC(B.CNTR_WGT / 1000, 3))) AS BLK_WGT_QTY," ).append("\n"); 
		query.append("                  MAX(A.MEAS_QTY) - SUM(DECODE(B.RCV_TERM_CD, 'I', 0, 'T', 0, A.MEAS_QTY)) AS BLK_MEAS_QTY," ).append("\n"); 
		query.append("                  CASE WHEN NVL(MAX(A.WGT_QTY) * 0.999, 0) < NVL(MAX(A.MEAS_QTY) * 0.883 + 0.999, 0) THEN MAX(A.MEAS_QTY)" ).append("\n"); 
		query.append("                       ELSE MAX(A.WGT_QTY)" ).append("\n"); 
		query.append("                  END AS RTON_WGT," ).append("\n"); 
		query.append("                  CASE WHEN NVL(MAX(A.WGT_QTY) * 0.999, 0) < NVL(MAX(A.MEAS_QTY) * 0.883 + 0.999, 0) THEN 'E'" ).append("\n"); 
		query.append("                       ELSE 'W'" ).append("\n"); 
		query.append("                  END AS WGT_MEAS_TP_CD" ).append("\n"); 
		query.append("             FROM ( SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.WHF_BND_CD, A.BL_NO, A.BKG_NO," ).append("\n"); 
		query.append("          A.WGT_QTY, A.MEAS_QTY," ).append("\n"); 
		query.append("          MAX(CHG_RT_SEQ) AS CHG_RT_SEQ" ).append("\n"); 
		query.append("     FROM BKG_KR_WHF_BL A, BKG_KR_WHF_RT B" ).append("\n"); 
		query.append("    WHERE A.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("      AND A.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("      AND A.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#if (${whf_bnd_cd} == 'II' || ${whf_bnd_cd} == 'IN' || ${whf_bnd_cd} == 'IT' || ${whf_bnd_cd} == 'IM')" ).append("\n"); 
		query.append("      AND A.WHF_POD_CD = @[port_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      AND A.WHF_POL_CD = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND A.WHF_BND_CD IN (DECODE(@[whf_bnd_cd], 'IN', 'II','ON', 'OO', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IT','ON', 'OT', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IM','ON', 'OM', @[whf_bnd_cd]))" ).append("\n"); 
		query.append("      AND A.WHF_BL_STS_CD <> 'D'" ).append("\n"); 
		query.append("      AND B.VSL_CD(+) = A.VSL_CD" ).append("\n"); 
		query.append("      AND B.SKD_VOY_NO(+) = A.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND B.SKD_DIR_CD(+) = A.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND B.WHF_BND_CD(+) = A.WHF_BND_CD" ).append("\n"); 
		query.append("      AND B.BL_NO(+) = A.BL_NO" ).append("\n"); 
		query.append("    GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.WHF_BND_CD, A.BL_NO, A.BKG_NO," ).append("\n"); 
		query.append("             A.WGT_QTY, A.MEAS_QTY ) A, NISADM.BKG_CONTAINER B" ).append("\n"); 
		query.append("            WHERE A.CHG_RT_SEQ IS NULL" ).append("\n"); 
		query.append("              AND B.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("            GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.WHF_BND_CD, A.BL_NO) C," ).append("\n"); 
		query.append("           (SELECT D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD, D.WHF_BND_CD, D.BL_NO, " ).append("\n"); 
		query.append("                  SUM(CASE WHEN SUBSTR(E.CNTR_TPSZ_CD, 2, 1) = '2' AND SUBSTR(E.CNTR_TPSZ_CD, 1, 1) <> 'Q' THEN E.OP_CNTR_QTY" ).append("\n"); 
		query.append("                           ELSE 0" ).append("\n"); 
		query.append("                      END) AS WHF_BKG_20FT_QTY," ).append("\n"); 
		query.append("                  SUM(CASE WHEN (SUBSTR(E.CNTR_TPSZ_CD, 2, 1) IN ('4', '5') OR  E.CNTR_TPSZ_CD IN ('R8', 'R9')) AND SUBSTR(E.CNTR_TPSZ_CD, 1, 1) <> 'Q' THEN E.OP_CNTR_QTY" ).append("\n"); 
		query.append("                           ELSE 0" ).append("\n"); 
		query.append("                      END) AS WHF_BKG_40FT_QTY," ).append("\n"); 
		query.append("                  SUM(CASE WHEN (SUBSTR(E.CNTR_TPSZ_CD, 2, 1) NOT IN ('2', '4', '5') AND  E.CNTR_TPSZ_CD NOT IN ('R8', 'R9')) AND SUBSTR(E.CNTR_TPSZ_CD, 1, 1) <> 'Q' THEN E.OP_CNTR_QTY" ).append("\n"); 
		query.append("                           ELSE 0" ).append("\n"); 
		query.append("                      END) AS WHF_BKG_45FT_QTY" ).append("\n"); 
		query.append("             FROM ( SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.WHF_BND_CD, A.BL_NO, A.BKG_NO," ).append("\n"); 
		query.append("          A.WGT_QTY, A.MEAS_QTY," ).append("\n"); 
		query.append("          MAX(CHG_RT_SEQ) AS CHG_RT_SEQ" ).append("\n"); 
		query.append("     FROM BKG_KR_WHF_BL A, BKG_KR_WHF_RT B" ).append("\n"); 
		query.append("    WHERE A.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("      AND A.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("      AND A.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#if (${whf_bnd_cd} == 'II' || ${whf_bnd_cd} == 'IN' || ${whf_bnd_cd} == 'IT' || ${whf_bnd_cd} == 'IM')" ).append("\n"); 
		query.append("      AND A.WHF_POD_CD = @[port_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      AND A.WHF_POL_CD = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND A.WHF_BND_CD IN (DECODE(@[whf_bnd_cd], 'IN', 'II','ON', 'OO', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IT','ON', 'OT', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IM','ON', 'OM', @[whf_bnd_cd]))" ).append("\n"); 
		query.append("      AND A.WHF_BL_STS_CD <> 'D'" ).append("\n"); 
		query.append("      AND B.VSL_CD(+) = A.VSL_CD" ).append("\n"); 
		query.append("      AND B.SKD_VOY_NO(+) = A.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND B.SKD_DIR_CD(+) = A.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND B.WHF_BND_CD(+) = A.WHF_BND_CD" ).append("\n"); 
		query.append("      AND B.BL_NO(+) = A.BL_NO" ).append("\n"); 
		query.append("    GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.WHF_BND_CD, A.BL_NO, A.BKG_NO," ).append("\n"); 
		query.append("             A.WGT_QTY, A.MEAS_QTY ) D, BKG_QUANTITY E" ).append("\n"); 
		query.append("            WHERE D.CHG_RT_SEQ IS NULL" ).append("\n"); 
		query.append("              AND E.BKG_NO(+) = D.BKG_NO" ).append("\n"); 
		query.append("            GROUP BY D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD, D.WHF_BND_CD, D.BL_NO) F" ).append("\n"); 
		query.append("    WHERE F.VSL_CD(+) = C.VSL_CD" ).append("\n"); 
		query.append("      AND F.SKD_VOY_NO(+) = C.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND F.SKD_DIR_CD(+) = C.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND F.WHF_BND_CD(+) = C.WHF_BND_CD" ).append("\n"); 
		query.append("      AND F.BL_NO(+) = C.BL_NO ) T, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    select U.WHF_VOL_DC_CD WHF_VOL_DC_CD," ).append("\n"); 
		query.append("      S.VPS_ETA_DT VPS_ETA_DT," ).append("\n"); 
		query.append("      S.VPS_ETD_DT VPS_ETD_DT" ).append("\n"); 
		query.append("    from BKG_KR_WHF_VOL U," ).append("\n"); 
		query.append("      VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("    WHERE U.VSL_CD(+) = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND U.SKD_VOY_NO(+) = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND U.SKD_DIR_CD(+) = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("      AND U.PORT_CD(+) = @[port_cd]" ).append("\n"); 
		query.append("      AND SUBSTR(U.WHF_BND_CD(+), 1, 1) = SUBSTR(@[whf_bnd_cd], 1, 1)" ).append("\n"); 
		query.append("      AND S.VSL_CD(+) = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND S.SKD_VOY_NO(+) = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND S.SKD_DIR_CD(+) = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("      AND s.VPS_PORT_CD(+) = @[port_cd]" ).append("\n"); 
		query.append("      and S.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 
		query.append("      AND ROWNUM =1 ) U" ).append("\n"); 
		query.append(", BKG_KR_WHF_PORT_RT V, BKG_KR_WHF_PORT_RT W" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  WHERE V.CNTR_BLK_DIV_CD(+) = 'C'" ).append("\n"); 
		query.append("  AND V.PORT_CD(+) = @[port_cd]" ).append("\n"); 
		query.append("  AND V.IO_BND_CD(+) = SUBSTR(@[whf_bnd_cd], 1, 1)" ).append("\n"); 
		query.append("  AND V.DC_RTO_NO(+) = U.WHF_VOL_DC_CD" ).append("\n"); 
		query.append("  AND W.CNTR_BLK_DIV_CD(+) = 'B'" ).append("\n"); 
		query.append("  AND W.PORT_CD(+) = @[port_cd]" ).append("\n"); 
		query.append("  AND W.IO_BND_CD(+) = SUBSTR(@[whf_bnd_cd], 1, 1)" ).append("\n"); 
		query.append("  AND W.DC_RTO_NO(+) = U.WHF_VOL_DC_CD" ).append("\n"); 
		query.append("  and decode( SUBSTR(@[whf_bnd_cd], 1, 1), 'I', U.VPS_ETA_DT, U.VPS_ETD_DT) between V.EFF_FM_DT(+) and V.EFF_TO_DT(+) + 0.99999" ).append("\n"); 
		query.append("  and decode( SUBSTR(@[whf_bnd_cd], 1, 1), 'I', U.VPS_ETA_DT, U.VPS_ETD_DT) between W.EFF_FM_DT(+) and W.EFF_TO_DT(+) + 0.99999" ).append("\n"); 
		query.append("  ) X," ).append("\n"); 
		query.append("       ( SELECT B.BKG_NO," ).append("\n"); 
		query.append("          SUM(CASE WHEN SUBSTR(C.CNTR_TPSZ_CD, 2, 1) = '2' THEN C.CNTR_VOL_QTY ELSE 0 END) AS BKG_CNTR_20FT_QTY," ).append("\n"); 
		query.append("          SUM(CASE WHEN SUBSTR(C.CNTR_TPSZ_CD, 2, 1) IN ('4', '5') OR C.CNTR_TPSZ_CD IN ('R8', 'R9') THEN C.CNTR_VOL_QTY ELSE 0 END) AS BKG_CNTR_40FT_QTY," ).append("\n"); 
		query.append("          SUM(CASE WHEN SUBSTR(C.CNTR_TPSZ_CD, 2, 1) NOT IN ('2', '4', '5') AND C.CNTR_TPSZ_CD NOT IN ('R8', 'R9') THEN C.CNTR_VOL_QTY ELSE 0 END) AS BKG_CNTR_45FT_QTY" ).append("\n"); 
		query.append("     FROM (SELECT DISTINCT A.BKG_NO" ).append("\n"); 
		query.append("             FROM ( SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.WHF_BND_CD, A.BL_NO, A.BKG_NO," ).append("\n"); 
		query.append("          A.WGT_QTY, A.MEAS_QTY," ).append("\n"); 
		query.append("          MAX(CHG_RT_SEQ) AS CHG_RT_SEQ" ).append("\n"); 
		query.append("     FROM BKG_KR_WHF_BL A, BKG_KR_WHF_RT B" ).append("\n"); 
		query.append("    WHERE A.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("      AND A.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("      AND A.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#if (${whf_bnd_cd} == 'II' || ${whf_bnd_cd} == 'IN' || ${whf_bnd_cd} == 'IT' || ${whf_bnd_cd} == 'IM')" ).append("\n"); 
		query.append("      AND A.WHF_POD_CD = @[port_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      AND A.WHF_POL_CD = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND A.WHF_BND_CD IN (DECODE(@[whf_bnd_cd], 'IN', 'II','ON', 'OO', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IT','ON', 'OT', @[whf_bnd_cd]), DECODE(@[whf_bnd_cd], 'IN', 'IM','ON', 'OM', @[whf_bnd_cd]))" ).append("\n"); 
		query.append("      AND A.WHF_BL_STS_CD <> 'D'" ).append("\n"); 
		query.append("      AND B.VSL_CD(+) = A.VSL_CD" ).append("\n"); 
		query.append("      AND B.SKD_VOY_NO(+) = A.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND B.SKD_DIR_CD(+) = A.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND B.WHF_BND_CD(+) = A.WHF_BND_CD" ).append("\n"); 
		query.append("      AND B.BL_NO(+) = A.BL_NO" ).append("\n"); 
		query.append("    GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.WHF_BND_CD, A.BL_NO, A.BKG_NO," ).append("\n"); 
		query.append("             A.WGT_QTY, A.MEAS_QTY ) A) B," ).append("\n"); 
		query.append("          BKG_CONTAINER C" ).append("\n"); 
		query.append("    WHERE C.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("    GROUP BY B.BKG_NO ) Y," ).append("\n"); 
		query.append("       BKG_HRD_CDG_CTNT Z," ).append("\n"); 
		query.append("       ( SELECT A.WHF_RT" ).append("\n"); 
		query.append("     FROM BKG_KR_WHF_VOL A" ).append("\n"); 
		query.append("    WHERE A.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("      AND A.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("      AND A.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("      AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("      AND A.WHF_BND_CD = DECODE(@[whf_bnd_cd], 'IN', 'II','ON','OO', @[whf_bnd_cd]) )  A1" ).append("\n"); 
		query.append(" WHERE K.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("   AND L.BKG_NO(+) = K.BKG_NO" ).append("\n"); 
		query.append("   AND L.BKG_CUST_TP_CD(+) = DECODE(SUBSTR(@[whf_bnd_cd], 1, 1), 'O', 'S', DECODE(K.CUST_TO_ORD_FLG, 'Y', 'N', 'C'))" ).append("\n"); 
		query.append("   AND M.CUST_CNT_CD(+) = L.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND M.CUST_SEQ(+) = L.CUST_SEQ" ).append("\n"); 
		query.append("   AND X.VSL_CD(+) = A.VSL_CD" ).append("\n"); 
		query.append("   AND X.SKD_VOY_NO(+) = A.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND X.SKD_DIR_CD(+) = A.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND X.WHF_BND_CD(+) = A.WHF_BND_CD" ).append("\n"); 
		query.append("   AND X.BL_NO(+) = A.BL_NO" ).append("\n"); 
		query.append("   AND Y.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("   AND Z.HRD_CDG_ID(+) = 'KR_WHF_EXEMPT_CD'" ).append("\n"); 
		query.append("   AND Z.ATTR_CTNT1(+) = A.WFG_EXPT_CD" ).append("\n"); 
		query.append(" ORDER BY A.WHF_BND_CD, A.BKG_NO" ).append("\n"); 

	}
}