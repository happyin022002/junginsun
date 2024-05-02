/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialManifestDBDAOSearchEurDgSummaryExcelListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.05.03 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOSearchEurDgSummaryExcelListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur Dg Port를 Summary Excel 다운로드 하기위해 조회한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOSearchEurDgSummaryExcelListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOSearchEurDgSummaryExcelListRSQL").append("\n"); 
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
		query.append(" 'NVT'||' '||(SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE 1=1 AND VSL_CD LIKE A.VSL_CD || '%' AND DELT_FLG = 'N') AS POD_CD" ).append("\n"); 
		query.append(" ,'' AS CLASS_14" ).append("\n"); 
		query.append(" ,'Ports of Discharge Classes Summary' AS CLASS_21" ).append("\n"); 
		query.append(" ,'' AS CLASS_22" ).append("\n"); 
		query.append(" ,'' AS CLASS_30" ).append("\n"); 
		query.append(" ,'' AS CLASS_41" ).append("\n"); 
		query.append(" ,'POL'||' '||(SELECT LOC_NM FROM MDM_LOCATION WHERE A.POL_CD=LOC_CD) AS CLASS_42" ).append("\n"); 
		query.append(" ,'' AS CLASS_43" ).append("\n"); 
		query.append(" ,'' AS CLASS_51" ).append("\n"); 
		query.append(" ,'' AS CLASS_52" ).append("\n"); 
		query.append(" ,'' AS CLASS_61" ).append("\n"); 
		query.append(" ,'' AS CLASS_80" ).append("\n"); 
		query.append(" ,'' AS CLASS_90" ).append("\n"); 
		query.append(" ,'' AS TOTAL_BOOKINGS" ).append("\n"); 
		query.append(" FROM (SELECT EUR_DG.VSL_CD, EUR_DG.SKD_VOY_NO, EUR_DG.SKD_DIR_CD, EUR_DG.POL_CD" ).append("\n"); 
		query.append("      FROM BKG_CSTMS_EUR_DG EUR_DG, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("      AND EUR_DG.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("      AND EUR_DG.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("      AND EUR_DG.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 4)" ).append("\n"); 
		query.append("	  #if (${pol_cd} != '') " ).append("\n"); 
		query.append("      AND EUR_DG.PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("      ) A" ).append("\n"); 
		query.append("      WHERE ROWNUM=1" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" 'Voyage'||' '||A.OB_CSSM_VOY_NO AS POD_CD" ).append("\n"); 
		query.append(" ,'' AS CLASS_14" ).append("\n"); 
		query.append(" ,'' AS CLASS_21" ).append("\n"); 
		query.append(" ,'' AS CLASS_22" ).append("\n"); 
		query.append(" ,'' AS CLASS_30" ).append("\n"); 
		query.append(" ,'' AS CLASS_41" ).append("\n"); 
		query.append(" ,'Date'||' '||TO_CHAR(A.VPS_ETD_DT,'DD/MM/YY') AS CLASS_42" ).append("\n"); 
		query.append(" ,'' AS CLASS_43" ).append("\n"); 
		query.append(" ,'' AS CLASS_51" ).append("\n"); 
		query.append(" ,'' AS CLASS_52" ).append("\n"); 
		query.append(" ,'' AS CLASS_61" ).append("\n"); 
		query.append(" ,'' AS CLASS_80" ).append("\n"); 
		query.append(" ,'' AS CLASS_90" ).append("\n"); 
		query.append(" ,'' AS TOTAL_BOOKINGS" ).append("\n"); 
		query.append(" FROM (SELECT EUR_DG.VSL_CD, EUR_DG.SKD_VOY_NO, EUR_DG.SKD_DIR_CD, EUR_DG.POL_CD, EUR_DG.POD_CD, SKD.OB_CSSM_VOY_NO AS OB_CSSM_VOY_NO, SKD.VPS_ETD_DT AS VPS_ETD_DT" ).append("\n"); 
		query.append("      FROM BKG_CSTMS_EUR_DG EUR_DG, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("      AND EUR_DG.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("      AND EUR_DG.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("      AND EUR_DG.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 4)" ).append("\n"); 
		query.append("      AND SKD.VSL_CD=EUR_DG.VSL_CD" ).append("\n"); 
		query.append("      AND SKD.SKD_VOY_NO=EUR_DG.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND SKD.SKD_DIR_CD=EUR_DG.SKD_DIR_CD" ).append("\n"); 
		query.append("      #if (${pol_cd} != '') " ).append("\n"); 
		query.append("      AND EUR_DG.PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("      AND SKD.VPS_PORT_CD=EUR_DG.PORT_CD" ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("      ) A" ).append("\n"); 
		query.append("      WHERE ROWNUM=1" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" SELECT ' ' AS POD_CD, ' ' AS CLASS_14, '' AS CLASS_21, '' AS CLASS_22, '' AS CLASS_30, '' AS CLASS_41, '' AS CLASS_42, '' AS CLASS_43, '' AS CLASS_51, '' AS CLASS_52 ,'' AS CLASS_61, '' AS CLASS_80, '' AS CLASS_90, '' AS TOTAL_BOOKINGS" ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" SELECT 'PODs' AS POD_CD ,'1.4S' AS CLASS_14, '2.1' AS CLASS_21, '2.2' AS CLASS_22, '3' AS CLASS_30, '4.1' AS CLASS_41, '4.2' AS CLASS_42, '4.3' AS CLASS_43, '5.1' AS CLASS_51, '5.2' AS CLASS_52, '6.1' AS CLASS_61, '8' AS CLASS_80, '9' AS CLASS_90, 'Total(Kg)' AS TOTAL_BOOKINGS" ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(SELECT DECODE(GROUPING(RNUM),1,'TOTAL',MAX(POD_CD)) AS POD_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_14),MAX(CLASS_14))) AS CLASS_14" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_21),MAX(CLASS_21))) AS CLASS_21" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_22),MAX(CLASS_22))) AS CLASS_22" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_30),MAX(CLASS_30))) AS CLASS_30" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_41),MAX(CLASS_41))) AS CLASS_41" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_42),MAX(CLASS_42))) AS CLASS_42" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_43),MAX(CLASS_43))) AS CLASS_43" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_51),MAX(CLASS_51))) AS CLASS_51" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_52),MAX(CLASS_52))) AS CLASS_52" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_61),MAX(CLASS_61))) AS CLASS_61" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_80),MAX(CLASS_80))) AS CLASS_80" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_90),MAX(CLASS_90))) AS CLASS_90" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(TOTAL_BOOKINGS),MAX(TOTAL_BOOKINGS))) AS TOTAL_BOOKINGS" ).append("\n"); 
		query.append("FROM(SELECT A.*, ROWNUM AS RNUM" ).append("\n"); 
		query.append("FROM (WITH TEST_TABLE AS(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     NO " ).append("\n"); 
		query.append("     , CNTR_NO " ).append("\n"); 
		query.append("     , BL_NO " ).append("\n"); 
		query.append("     , G_WEIGHT " ).append("\n"); 
		query.append("     , CLS_SUB " ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT DENSE_RANK() OVER(ORDER BY EUR_DG.POL_CD,EUR_DG.POD_CD,EUR_DG.BL_NO, NVL(EUR_DG.CNTR_NO, ' ')) AS NO" ).append("\n"); 
		query.append("            , NVL(EUR_DG.CNTR_NO, ' ') AS CNTR_NO " ).append("\n"); 
		query.append("            , EUR_DG.VSL_CD AS VSL_CD  " ).append("\n"); 
		query.append("            , EUR_DG.BL_NO AS BL_NO " ).append("\n"); 
		query.append("            , TO_CHAR(NVL(EUR_DG.NET_WGT,0))|| ' ' || 'KGS' AS G_WEIGHT " ).append("\n"); 
		query.append("	        , TO_NUMBER(EUR_DG.IMDG_CLSS_CD) AS CLS_SUB" ).append("\n"); 
		query.append("            , EUR_DG.POD_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         FROM BKG_CSTMS_EUR_DG EUR_DG " ).append("\n"); 
		query.append("        WHERE 1=1 " ).append("\n"); 
		query.append("              AND EUR_DG.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("              AND EUR_DG.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("              AND EUR_DG.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 4)" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              #if (${list_type} == 'L') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD = 'L'" ).append("\n"); 
		query.append("              #end 			  " ).append("\n"); 
		query.append("			  #if (${list_type} == 'D') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD = 'D'" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("			  #if (${list_type} == 'T') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD = 'T'" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("			  #if (${list_type} == 'B') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD IN ('L','T')" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("			  #if (${list_type} == 'BE') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD IN ('L','T')" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("			  #if (${list_type} == 'SE') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD IN ('L','T')" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  #if (${pol_cd} != '') " ).append("\n"); 
		query.append("              AND EUR_DG.PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  #if (${pod_cd} != '') " ).append("\n"); 
		query.append("              AND EUR_DG.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		      #if (${crr_cd} != '') " ).append("\n"); 
		query.append("              AND EUR_DG.CGO_OPR_CD = @[crr_cd]" ).append("\n"); 
		query.append("              #end               " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("ORDER BY NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT POD_CD" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,1.4,RTRIM(G_WEIGHT,'KGS'),0)) AS CLASS_14" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,2.1,RTRIM(G_WEIGHT,'KGS'),0)) AS CLASS_21" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,2.2,RTRIM(G_WEIGHT,'KGS'),0)) AS CLASS_22" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,3,RTRIM(G_WEIGHT,'KGS'),0)) AS CLASS_30" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,4.1,RTRIM(G_WEIGHT,'KGS'),0)) AS CLASS_41" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,4.2,RTRIM(G_WEIGHT,'KGS'),0)) AS CLASS_42" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,4.3,RTRIM(G_WEIGHT,'KGS'),0)) AS CLASS_43" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,5.1,RTRIM(G_WEIGHT,'KGS'),0)) AS CLASS_51" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,5.2,RTRIM(G_WEIGHT,'KGS'),0)) AS CLASS_52" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,6.1,RTRIM(G_WEIGHT,'KGS'),0)) AS CLASS_61" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,8,RTRIM(G_WEIGHT,'KGS'),0)) AS CLASS_80" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,9,RTRIM(G_WEIGHT,'KGS'),0)) AS CLASS_90" ).append("\n"); 
		query.append("       ,SUM(RTRIM(G_WEIGHT,'KGS')) AS TOTAL_BOOKINGS" ).append("\n"); 
		query.append("FROM TEST_TABLE" ).append("\n"); 
		query.append("GROUP BY POD_CD" ).append("\n"); 
		query.append("ORDER BY POD_CD" ).append("\n"); 
		query.append(")A)B" ).append("\n"); 
		query.append("GROUP BY ROLLUP(RNUM)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT ' ' AS POD_CD, ' ' AS CLASS_14, '' AS CLASS_21, '' AS CLASS_22, '' AS CLASS_30, '' AS CLASS_41, '' AS CLASS_42, '' AS CLASS_43, '' AS CLASS_51, '' AS CLASS_52 ,'' AS CLASS_61, '' AS CLASS_80, '' AS CLASS_90, '' AS TOTAL_BOOKINGS" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'PODs' AS POD_CD ,'1.4S' AS CLASS_14, '2.1' AS CLASS_21, '2.2' AS CLASS_22, '3' AS CLASS_30, '4.1' AS CLASS_41, '4.2' AS CLASS_42, '4.3' AS CLASS_43, '5.1' AS CLASS_51, '5.2' AS CLASS_52, '6.1' AS CLASS_61, '8' AS CLASS_80, '9' AS CLASS_90, 'Total(Bookings)' AS TOTAL_BOOKINGS" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(SELECT DECODE(GROUPING(RNUM),1,'TOTAL',MAX(POD_CD)) AS POD_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_14),MAX(CLASS_14))) AS CLASS_14" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_21),MAX(CLASS_21))) AS CLASS_21" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_22),MAX(CLASS_22))) AS CLASS_22" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_30),MAX(CLASS_30))) AS CLASS_30" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_41),MAX(CLASS_41))) AS CLASS_41" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_42),MAX(CLASS_42))) AS CLASS_42" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_43),MAX(CLASS_43))) AS CLASS_43" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_51),MAX(CLASS_51))) AS CLASS_51" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_52),MAX(CLASS_52))) AS CLASS_52" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_61),MAX(CLASS_61))) AS CLASS_61" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_80),MAX(CLASS_80))) AS CLASS_80" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(CLASS_90),MAX(CLASS_90))) AS CLASS_90" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(GROUPING(RNUM),1,SUM(TOTAL_BOOKINGS),MAX(TOTAL_BOOKINGS))) AS TOTAL_BOOKINGS" ).append("\n"); 
		query.append("FROM(SELECT A.* , ROWNUM AS RNUM" ).append("\n"); 
		query.append("FROM(WITH TEST_TABLE AS(" ).append("\n"); 
		query.append("SELECT NO " ).append("\n"); 
		query.append("     , CNTR_NO " ).append("\n"); 
		query.append("     , BL_NO " ).append("\n"); 
		query.append("     , G_WEIGHT " ).append("\n"); 
		query.append("     , CLS_SUB " ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       (SELECT DENSE_RANK() OVER(ORDER BY EUR_DG.POL_CD,EUR_DG.POD_CD,EUR_DG.BL_NO, NVL(EUR_DG.CNTR_NO, ' ')) AS NO" ).append("\n"); 
		query.append("            , NVL(EUR_DG.CNTR_NO, ' ') AS CNTR_NO " ).append("\n"); 
		query.append("            , EUR_DG.VSL_CD AS VSL_CD  " ).append("\n"); 
		query.append("            , EUR_DG.BL_NO AS BL_NO " ).append("\n"); 
		query.append("            , TO_CHAR(NVL(EUR_DG.NET_WGT,0))|| ' ' || 'KGS' AS G_WEIGHT " ).append("\n"); 
		query.append("	        , TO_NUMBER(EUR_DG.IMDG_CLSS_CD) AS CLS_SUB" ).append("\n"); 
		query.append("            , EUR_DG.POD_CD " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("         FROM BKG_CSTMS_EUR_DG EUR_DG " ).append("\n"); 
		query.append("         WHERE 1=1 " ).append("\n"); 
		query.append("              AND EUR_DG.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("              AND EUR_DG.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("              AND EUR_DG.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 4)" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              #if (${list_type} == 'L') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD = 'L'" ).append("\n"); 
		query.append("              #end 			  " ).append("\n"); 
		query.append("			  #if (${list_type} == 'D') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD = 'D'" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("			  #if (${list_type} == 'T') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD = 'T'" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("			  #if (${list_type} == 'B') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD IN ('L','T')" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("			  #if (${list_type} == 'BE') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD IN ('L','T')" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("			  #if (${list_type} == 'SE') " ).append("\n"); 
		query.append("              AND EUR_DG.EUR_DG_DECL_TP_CD IN ('L','T')" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  #if (${pol_cd} != '') " ).append("\n"); 
		query.append("              AND EUR_DG.PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  #if (${pod_cd} != '') " ).append("\n"); 
		query.append("              AND EUR_DG.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("              #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		      #if (${crr_cd} != '') " ).append("\n"); 
		query.append("              AND EUR_DG.CGO_OPR_CD = @[crr_cd]" ).append("\n"); 
		query.append("              #end               " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("ORDER BY NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT POD_CD" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,1.4,1,0)) AS CLASS_14" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,2.1,1,0)) AS CLASS_21" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,2.2,1,0)) AS CLASS_22" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,3,1,0)) AS CLASS_30" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,4.1,1,0)) AS CLASS_41" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,4.2,1,0)) AS CLASS_42" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,4.3,1,0)) AS CLASS_43" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,5.1,1,0)) AS CLASS_51" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,5.2,1,0)) AS CLASS_52" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,6.1,1,0)) AS CLASS_61" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,8,1,0)) AS CLASS_80" ).append("\n"); 
		query.append("       ,SUM(DECODE(CLS_SUB,9,1,0)) AS CLASS_90" ).append("\n"); 
		query.append("       ,COUNT(BL_NO) AS TOTAL_BOOKINGS" ).append("\n"); 
		query.append("FROM TEST_TABLE" ).append("\n"); 
		query.append("GROUP BY POD_CD" ).append("\n"); 
		query.append("ORDER BY POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") A ) B" ).append("\n"); 
		query.append("GROUP BY ROLLUP(RNUM)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}