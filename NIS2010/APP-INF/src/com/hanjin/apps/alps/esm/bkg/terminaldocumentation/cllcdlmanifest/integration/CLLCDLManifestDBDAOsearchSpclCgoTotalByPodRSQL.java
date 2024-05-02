/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchSpclCgoTotalByPodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchSpclCgoTotalByPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSpclCgoTotalByPod
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchSpclCgoTotalByPodRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_by_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchSpclCgoTotalByPodRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_pgm_no} == 'ESM_BKG_0951') " ).append("\n"); 
		query.append("/**************************** ESM_BKG_0951에서 조회된 경우  *****************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT POD_CD," ).append("\n"); 
		query.append("  DG_20," ).append("\n"); 
		query.append("  DG_40," ).append("\n"); 
		query.append("  DG_45," ).append("\n"); 
		query.append("  RF_20," ).append("\n"); 
		query.append("  RF_40," ).append("\n"); 
		query.append("  RF_45," ).append("\n"); 
		query.append("  AK_20," ).append("\n"); 
		query.append("  AK_40," ).append("\n"); 
		query.append("  AK_45," ).append("\n"); 
		query.append("  '' BB2," ).append("\n"); 
		query.append("  '' BB4," ).append("\n"); 
		query.append("  '' BB45" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT BV.POD_CD POD_CD," ).append("\n"); 
		query.append("      COUNT(DISTINCT DG2.CNTR_NO) DG_20," ).append("\n"); 
		query.append("      COUNT(DISTINCT DG4.CNTR_NO) DG_40," ).append("\n"); 
		query.append("      COUNT(DISTINCT DG45.CNTR_NO) DG_45," ).append("\n"); 
		query.append("      COUNT(DISTINCT RF2.CNTR_NO) RF_20," ).append("\n"); 
		query.append("      COUNT(DISTINCT RF4.CNTR_NO) RF_40," ).append("\n"); 
		query.append("      COUNT(DISTINCT RF45.CNTR_NO) RF_45," ).append("\n"); 
		query.append("      COUNT(DISTINCT AWK2.CNTR_NO) AK_20," ).append("\n"); 
		query.append("      COUNT(DISTINCT AWK4.CNTR_NO) AK_40," ).append("\n"); 
		query.append("      COUNT(DISTINCT AWK45.CNTR_NO) AK_45" ).append("\n"); 
		query.append("    FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("         BKG_VVD BV, " ).append("\n"); 
		query.append("         BKG_CONTAINER BC," ).append("\n"); 
		query.append("         BKG_AWK_CGO AWK2, " ).append("\n"); 
		query.append("         BKG_AWK_CGO AWK4, " ).append("\n"); 
		query.append("         BKG_DG_CGO DG2, " ).append("\n"); 
		query.append("         BKG_DG_CGO DG4, " ).append("\n"); 
		query.append("         BKG_RF_CGO RF2, " ).append("\n"); 
		query.append("         BKG_RF_CGO RF4, " ).append("\n"); 
		query.append("         BKG_AWK_CGO AWK45, " ).append("\n"); 
		query.append("         BKG_DG_CGO DG45, " ).append("\n"); 
		query.append("         BKG_RF_CGO RF45" ).append("\n"); 
		query.append("    WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("      AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("      AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n"); 
		query.append("      AND BC.BKG_NO = AWK2.BKG_NO (+)" ).append("\n"); 
		query.append("      AND BC.CNTR_NO = AWK2.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(AWK2.CNTR_TPSZ_CD(+), 2, 1) = '2'" ).append("\n"); 
		query.append("      AND BC.BKG_NO = AWK4.BKG_NO (+)" ).append("\n"); 
		query.append("      AND BC.CNTR_NO = AWK4.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(AWK4.CNTR_TPSZ_CD(+), 2, 1) = '4'" ).append("\n"); 
		query.append("      AND BC.BKG_NO = AWK45.BKG_NO (+)" ).append("\n"); 
		query.append("      AND BC.CNTR_NO = AWK45.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(AWK45.CNTR_TPSZ_CD(+), 2, 1) NOT IN ('2', '4')" ).append("\n"); 
		query.append("      AND BC.BKG_NO = DG2.BKG_NO (+)" ).append("\n"); 
		query.append("      AND BC.CNTR_NO = DG2.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(DG2.CNTR_TPSZ_CD(+), 2, 1) = '2'" ).append("\n"); 
		query.append("      AND BC.BKG_NO = DG4.BKG_NO (+)" ).append("\n"); 
		query.append("      AND BC.CNTR_NO = DG4.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(DG4.CNTR_TPSZ_CD(+), 2, 1) = '4'" ).append("\n"); 
		query.append("      AND BC.BKG_NO = DG45.BKG_NO (+)" ).append("\n"); 
		query.append("      AND BC.CNTR_NO = DG45.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(DG45.CNTR_TPSZ_CD(+), 2, 1) NOT IN ('2','4')" ).append("\n"); 
		query.append("      AND BC.BKG_NO = RF2.BKG_NO (+)" ).append("\n"); 
		query.append("      AND BC.CNTR_NO = RF2.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(RF2.CNTR_TPSZ_CD(+), 2, 1) = '2'" ).append("\n"); 
		query.append("      AND BC.BKG_NO = RF4.BKG_NO (+)" ).append("\n"); 
		query.append("      AND BC.CNTR_NO = RF4.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(RF4.CNTR_TPSZ_CD(+), 2, 1) = '4'" ).append("\n"); 
		query.append("      AND BC.BKG_NO = RF45.BKG_NO (+)" ).append("\n"); 
		query.append("      AND BC.CNTR_NO = RF45.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(RF45.CNTR_TPSZ_CD(+), 2, 1) NOT IN ('2','4')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  AND BV.VSL_CD     = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("	  AND BV.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("	  AND BV.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("	  AND BV.POL_CD     = @[in_pol_cd]" ).append("\n"); 
		query.append("	  AND SUBSTR(BV.POL_YD_CD, 6, 2) like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("#if (${in_by_type} != 'ALL' )" ).append("\n"); 
		query.append("      AND DECODE(BV.POL_CD,BK.POL_CD,'LOCAL','TS') = @[in_by_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    GROUP BY BV.POD_CD ) AA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("/***************************** 기본 조회 *****************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT POD_CD," ).append("\n"); 
		query.append("  BKG_BS," ).append("\n"); 
		query.append("  DG_20," ).append("\n"); 
		query.append("  DG_40," ).append("\n"); 
		query.append("  DG_45," ).append("\n"); 
		query.append("  RF_20," ).append("\n"); 
		query.append("  RF_40," ).append("\n"); 
		query.append("  RF_45," ).append("\n"); 
		query.append("  AK_20," ).append("\n"); 
		query.append("  AK_40," ).append("\n"); 
		query.append("  AK_45," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT COUNT(CLL2.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_TML_KR_CLL CLL2" ).append("\n"); 
		query.append("        , BKG_BOOKING BKG2" ).append("\n"); 
		query.append("    WHERE CLL2.CLL_RMK1 like 'BB%'" ).append("\n"); 
		query.append("      AND CLL2.BKG_NO = BKG2.BKG_NO" ).append("\n"); 
		query.append("      AND BKG2.BLCK_STWG_CD = AA.BKG_BS" ).append("\n"); 
		query.append("      AND CLL2.CNTR_TPSZ_CD NOT LIKE 'R%'" ).append("\n"); 
		query.append("      AND SUBSTR(CLL2.CNTR_TPSZ_CD(+), 2, 1) = '2'" ).append("\n"); 
		query.append("      AND CLL2.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("      AND CLL2.POL_YD_CD like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("      AND CLL2.VSL_CD = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("      AND CLL2.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("      AND CLL2.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("      AND CLL2.POD_CD = AA.POD_CD #if (${in_by_type} == 'TS' )" ).append("\n"); 
		query.append("      AND CLL2.KR_CLL_TS_CD IN ('TS','TT') #elseif (${in_by_type} == 'LOCAL' )" ).append("\n"); 
		query.append("      AND CLL2.KR_CLL_TS_CD IS NULL #end ) BB2," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT COUNT(CLL2.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_TML_KR_CLL CLL2" ).append("\n"); 
		query.append(" , BKG_BOOKING BKG2" ).append("\n"); 
		query.append("    WHERE CLL2.CLL_RMK1 like 'BB%'" ).append("\n"); 
		query.append("      AND CLL2.BKG_NO = BKG2.BKG_NO" ).append("\n"); 
		query.append("      AND BKG2.BLCK_STWG_CD = AA.BKG_BS      " ).append("\n"); 
		query.append("      AND CLL2.CNTR_TPSZ_CD NOT LIKE 'R%'" ).append("\n"); 
		query.append("      AND SUBSTR(CLL2.CNTR_TPSZ_CD(+), 2, 1) = '4'" ).append("\n"); 
		query.append("      AND CLL2.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("      AND CLL2.POL_YD_CD like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("      AND CLL2.VSL_CD = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("      AND CLL2.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("      AND CLL2.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("      AND CLL2.POD_CD = AA.POD_CD #if (${in_by_type} == 'TS' )" ).append("\n"); 
		query.append("      AND CLL2.KR_CLL_TS_CD IN ('TS','TT') #elseif (${in_by_type} == 'LOCAL' )" ).append("\n"); 
		query.append("      AND CLL2.KR_CLL_TS_CD IS NULL #end ) BB4," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT COUNT(CLL2.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_TML_KR_CLL CLL2" ).append("\n"); 
		query.append(" , BKG_BOOKING BKG2" ).append("\n"); 
		query.append("    WHERE CLL2.CLL_RMK1 like 'BB%'" ).append("\n"); 
		query.append("      AND CLL2.BKG_NO = BKG2.BKG_NO" ).append("\n"); 
		query.append("      AND BKG2.BLCK_STWG_CD = AA.BKG_BS      " ).append("\n"); 
		query.append("      AND CLL2.CNTR_TPSZ_CD NOT LIKE 'R%'" ).append("\n"); 
		query.append("      AND SUBSTR(CLL2.CNTR_TPSZ_CD(+), 2, 1) NOT IN ('2', '4')" ).append("\n"); 
		query.append("      AND CLL2.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("      AND CLL2.POL_YD_CD like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("      AND CLL2.VSL_CD = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("      AND CLL2.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("      AND CLL2.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("      AND CLL2.POD_CD = AA.POD_CD #if (${in_by_type} == 'TS' )" ).append("\n"); 
		query.append("      AND CLL2.KR_CLL_TS_CD IN ('TS', 'TT') #elseif (${in_by_type} == 'LOCAL' )" ).append("\n"); 
		query.append("      AND CLL2.KR_CLL_TS_CD IS NULL #end ) BB45" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT CLL.POD_CD POD_CD," ).append("\n"); 
		query.append("      BKG.BLCK_STWG_CD AS BKG_BS," ).append("\n"); 
		query.append("      COUNT(DISTINCT DG2.CNTR_NO) DG_20," ).append("\n"); 
		query.append("      COUNT(DISTINCT DG4.CNTR_NO) DG_40," ).append("\n"); 
		query.append("      COUNT(DISTINCT DG45.CNTR_NO) DG_45," ).append("\n"); 
		query.append("      COUNT(DISTINCT RF2.CNTR_NO) RF_20," ).append("\n"); 
		query.append("      COUNT(DISTINCT RF4.CNTR_NO) RF_40," ).append("\n"); 
		query.append("      COUNT(DISTINCT RF45.CNTR_NO) RF_45," ).append("\n"); 
		query.append("      COUNT(DISTINCT AWK2.CNTR_NO) AK_20," ).append("\n"); 
		query.append("      COUNT(DISTINCT AWK4.CNTR_NO) AK_40," ).append("\n"); 
		query.append("      COUNT(DISTINCT AWK45.CNTR_NO) AK_45" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_TML_KR_CLL CLL" ).append("\n"); 
		query.append("        , BKG_BOOKING BKG" ).append("\n"); 
		query.append("        , BKG_AWK_CGO AWK2" ).append("\n"); 
		query.append("        , BKG_AWK_CGO AWK4" ).append("\n"); 
		query.append("        , BKG_DG_CGO DG2, BKG_DG_CGO DG4" ).append("\n"); 
		query.append("        , BKG_RF_CGO RF2, BKG_RF_CGO RF4" ).append("\n"); 
		query.append("        , BKG_AWK_CGO AWK45, BKG_DG_CGO DG45" ).append("\n"); 
		query.append("        , BKG_RF_CGO RF45" ).append("\n"); 
		query.append("    WHERE CLL.BKG_NO = AWK2.BKG_NO (+)" ).append("\n"); 
		query.append("      AND CLL.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("      AND CLL.CNTR_NO = AWK2.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(AWK2.CNTR_TPSZ_CD(+), 2, 1) = '2'" ).append("\n"); 
		query.append("      AND CLL.BKG_NO = AWK4.BKG_NO (+)" ).append("\n"); 
		query.append("      AND CLL.CNTR_NO = AWK4.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(AWK4.CNTR_TPSZ_CD(+), 2, 1) = '4'" ).append("\n"); 
		query.append("      AND CLL.BKG_NO = AWK45.BKG_NO (+)" ).append("\n"); 
		query.append("      AND CLL.CNTR_NO = AWK45.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(AWK45.CNTR_TPSZ_CD(+), 2, 1) NOT IN ('2', '4')" ).append("\n"); 
		query.append("      AND CLL.BKG_NO = DG2.BKG_NO (+)" ).append("\n"); 
		query.append("      AND CLL.CNTR_NO = DG2.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(DG2.CNTR_TPSZ_CD(+), 2, 1) = '2'" ).append("\n"); 
		query.append("      AND CLL.BKG_NO = DG4.BKG_NO (+)" ).append("\n"); 
		query.append("      AND CLL.CNTR_NO = DG4.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(DG4.CNTR_TPSZ_CD(+), 2, 1) = '4'" ).append("\n"); 
		query.append("      AND CLL.BKG_NO = DG45.BKG_NO (+)" ).append("\n"); 
		query.append("      AND CLL.CNTR_NO = DG45.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(DG45.CNTR_TPSZ_CD(+), 2, 1) NOT IN ('2','4')" ).append("\n"); 
		query.append("      AND CLL.BKG_NO = RF2.BKG_NO (+)" ).append("\n"); 
		query.append("      AND CLL.CNTR_NO = RF2.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(RF2.CNTR_TPSZ_CD(+), 2, 1) = '2'" ).append("\n"); 
		query.append("      AND CLL.BKG_NO = RF4.BKG_NO (+)" ).append("\n"); 
		query.append("      AND CLL.CNTR_NO = RF4.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(RF4.CNTR_TPSZ_CD(+), 2, 1) = '4'" ).append("\n"); 
		query.append("      AND CLL.BKG_NO = RF45.BKG_NO (+)" ).append("\n"); 
		query.append("      AND CLL.CNTR_NO = RF45.CNTR_NO (+)" ).append("\n"); 
		query.append("      AND SUBSTR(RF45.CNTR_TPSZ_CD(+), 2, 1) NOT IN ('2','4')" ).append("\n"); 
		query.append("      AND CLL.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("      AND CLL.POL_YD_CD like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("      AND CLL.VSL_CD = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("      AND CLL.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("      AND CLL.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("      AND CLL.POD_CD IS NOT NULL #if (${in_by_type} == 'TS' )" ).append("\n"); 
		query.append("      AND CLL.KR_CLL_TS_CD IN ('TS','TT') #elseif (${in_by_type} == 'LOCAL' )" ).append("\n"); 
		query.append("      AND CLL.KR_CLL_TS_CD IS NULL #end" ).append("\n"); 
		query.append("    GROUP BY CLL.POD_CD, BKG.BLCK_STWG_CD ) AA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}