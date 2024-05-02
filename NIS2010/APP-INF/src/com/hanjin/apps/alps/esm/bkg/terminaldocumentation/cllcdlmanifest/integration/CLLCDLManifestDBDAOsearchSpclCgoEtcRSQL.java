/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchSpclCgoEtcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.24 
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

public class CLLCDLManifestDBDAOsearchSpclCgoEtcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSpclCgoEtc
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchSpclCgoEtcRSQL(){
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
		query.append("FileName : CLLCDLManifestDBDAOsearchSpclCgoEtcRSQL").append("\n"); 
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
		query.append("SELECT E_CGO_TYPE," ).append("\n"); 
		query.append("  E_POD," ).append("\n"); 
		query.append("  E_MLB," ).append("\n"); 
		query.append("  E_CNTR_NO," ).append("\n"); 
		query.append("  E_TP," ).append("\n"); 
		query.append("  E_DETAIL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT E_CGO_TYPE," ).append("\n"); 
		query.append("      E_POD," ).append("\n"); 
		query.append("      E_MLB," ).append("\n"); 
		query.append("      E_CNTR_NO," ).append("\n"); 
		query.append("      E_TP," ).append("\n"); 
		query.append("      E_DETAIL" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT '<STOW>' E_CGO_TYPE," ).append("\n"); 
		query.append("          BV.POD_CD E_POD," ).append("\n"); 
		query.append("          DECODE(NVL(BV.POD_CD,' '), 'USSEA', DECODE(BV.SLAN_CD,'PSX',DECODE(DECODE(SUBSTR(NVL(BKG.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'ONE','SE1','SEA'),DECODE(SUBSTR(NVL(BKG.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC')), " ).append("\n"); 
		query.append("        							'USOAK', DECODE(BKG.BLCK_STWG_CD, 'OA1', 'OA1' , '', '', 'OAK'), " ).append("\n"); 
		query.append("        							'USLGB', DECODE(SUBSTR(NVL(BKG.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','7','SEV','T','TRS', 'LOC'), " ).append("\n"); 
		query.append("        							'CAVAN', DECODE(SUBSTR(NVL(BKG.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'') E_MLB," ).append("\n"); 
		query.append("          BC.CNTR_NO E_CNTR_NO," ).append("\n"); 
		query.append("          BC.CNTR_TPSZ_CD E_TP," ).append("\n"); 
		query.append("          BKG.STWG_CD E_DETAIL" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("           , BKG_VVD BV" ).append("\n"); 
		query.append("           , BKG_CONTAINER BC" ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("          AND BKG.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		  AND BV.VSL_CD     = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("		  AND BV.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("		  AND BV.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("		  AND BV.POL_CD     = @[in_pol_cd]" ).append("\n"); 
		query.append("		  AND SUBSTR(BV.POL_YD_CD, 6, 2) like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("#if (${in_by_type} != 'ALL' )" ).append("\n"); 
		query.append("		  AND DECODE(BV.POL_CD,BKG.POL_CD,'LOCAL','TS') = @[in_by_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND BC.CNTR_TPSZ_CD <> 'D7'" ).append("\n"); 
		query.append("          AND BC.CNTR_TPSZ_CD NOT LIKE 'A%'" ).append("\n"); 
		query.append("          AND BKG.STWG_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND BKG.STWG_CD <> 'INGU'   )" ).append("\n"); 
		query.append("    UNION ALL (" ).append("\n"); 
		query.append("        SELECT '<PC>' E_CGO_TYPE," ).append("\n"); 
		query.append("          BV.POD_CD E_POD," ).append("\n"); 
		query.append("          BKG.BLCK_STWG_CD E_MLB," ).append("\n"); 
		query.append("          BC.CNTR_NO E_CNTR_NO," ).append("\n"); 
		query.append("          BC.CNTR_TPSZ_CD E_TP," ).append("\n"); 
		query.append("          '' E_DETAIL" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("           , BKG_VVD BV" ).append("\n"); 
		query.append("           , BKG_CONTAINER BC" ).append("\n"); 
		query.append("           , MDM_COMMODITY CM" ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("          AND BKG.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("          AND BKG.CMDT_CD = CM.CMDT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		  AND BV.VSL_CD     = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("		  AND BV.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("		  AND BV.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("		  AND BV.POL_CD     = @[in_pol_cd]" ).append("\n"); 
		query.append("		  AND SUBSTR(BV.POL_YD_CD, 6, 2) like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("#if (${in_by_type} != 'ALL' )" ).append("\n"); 
		query.append("		  AND DECODE(BV.POL_CD,BKG.POL_CD,'LOCAL','TS') = @[in_by_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		  AND (	BKG.PRCT_FLG ='Y'" ).append("\n"); 
		query.append("        		or " ).append("\n"); 
		query.append("        		bkg.STWG_CD is null and CM.REP_IMDG_LVL_CD = 'P')" ).append("\n"); 
		query.append("			)        	" ).append("\n"); 
		query.append("         -- AND CM.REP_IMDG_LVL_CD = 'P'   )" ).append("\n"); 
		query.append("    UNION ALL (" ).append("\n"); 
		query.append("        SELECT '<TANK>' E_CGO_TYPE," ).append("\n"); 
		query.append("          BV.POD_CD E_POD," ).append("\n"); 
		query.append("          BKG.BLCK_STWG_CD E_MLB," ).append("\n"); 
		query.append("          BC.CNTR_NO E_CNTR_NO," ).append("\n"); 
		query.append("          BC.CNTR_TPSZ_CD E_TP," ).append("\n"); 
		query.append("          '' E_DETAIL" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("           , BKG_VVD BV" ).append("\n"); 
		query.append("           , BKG_CONTAINER BC" ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("          AND BKG.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		  AND BV.VSL_CD     = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("		  AND BV.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("		  AND BV.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("		  AND BV.POL_CD     = @[in_pol_cd]" ).append("\n"); 
		query.append("		  AND SUBSTR(BV.POL_YD_CD, 6, 2) like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("#if (${in_by_type} != 'ALL' )" ).append("\n"); 
		query.append("		  AND DECODE(BV.POL_CD,BKG.POL_CD,'LOCAL','TS') = @[in_by_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND BC.CNTR_TPSZ_CD in('T2', 'T4')            " ).append("\n"); 
		query.append("          AND BC.CNTR_NO NOT IN(" ).append("\n"); 
		query.append("            SELECT CNTR_NO" ).append("\n"); 
		query.append("            FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("            WHERE BC.BKG_NO = DG.BKG_NO" ).append("\n"); 
		query.append("              AND BC.CNTR_NO = DG.CNTR_NO) ) ) " ).append("\n"); 
		query.append("ORDER BY E_CGO_TYPE, E_POD, DECODE(E_MLB, 'LOC', '11', 'ONE', '12', 'TWO', '13', 'THR', '14', 'FOR', '15', 'FIV', '15.5', 'SEV', '15.7', 'HOT', '16', 'TRS', '17', '18')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("/***************************** 기본 조회 *****************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT E_CGO_TYPE," ).append("\n"); 
		query.append("  E_POD," ).append("\n"); 
		query.append("  E_BKG_BS," ).append("\n"); 
		query.append("  E_MLB," ).append("\n"); 
		query.append("  E_CNTR_NO," ).append("\n"); 
		query.append("  E_TP," ).append("\n"); 
		query.append("  E_DETAIL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT E_CGO_TYPE," ).append("\n"); 
		query.append("      E_POD," ).append("\n"); 
		query.append("      E_BKG_BS," ).append("\n"); 
		query.append("      E_MLB," ).append("\n"); 
		query.append("      E_CNTR_NO," ).append("\n"); 
		query.append("      E_TP," ).append("\n"); 
		query.append("      E_DETAIL" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT '<STOW>' E_CGO_TYPE," ).append("\n"); 
		query.append("          CLL.POD_CD E_POD," ).append("\n"); 
		query.append("          BKG.BLCK_STWG_CD AS E_BKG_BS," ).append("\n"); 
		query.append("          CLL.BLCK_STWG_CD E_MLB," ).append("\n"); 
		query.append("          CLL.CNTR_NO E_CNTR_NO," ).append("\n"); 
		query.append("          CLL.CNTR_TPSZ_CD E_TP," ).append("\n"); 
		query.append("          CLL.STWG_CD E_DETAIL" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_TML_KR_CLL CLL, BKG_BOOKING BKG" ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("          AND CLL.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("          AND CLL.POL_YD_CD like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("          AND CLL.VSL_CD = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("          AND CLL.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("          AND CLL.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("          AND CLL.POD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND CLL.CNTR_TPSZ_CD <> 'D7'" ).append("\n"); 
		query.append("          AND CLL.CNTR_TPSZ_CD NOT LIKE 'A%'" ).append("\n"); 
		query.append("          AND CLL.STWG_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND CLL.STWG_CD <> 'INGU' #if (${in_by_type} == 'TS' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IN ('TS', 'TT') #end #if (${in_by_type} == 'LOCAL' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IS NULL #end )" ).append("\n"); 
		query.append("    UNION ALL (" ).append("\n"); 
		query.append("        SELECT '<R/D>' E_CGO_TYPE," ).append("\n"); 
		query.append("          CLL.POD_CD E_POD," ).append("\n"); 
		query.append("          (SELECT BKG.BLCK_STWG_CD" ).append("\n"); 
		query.append("			 FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("		    WHERE BKG.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("			  AND ROWNUM=1) AS E_BKG_BS," ).append("\n"); 
		query.append("		  CLL.BLCK_STWG_CD E_MLB," ).append("\n"); 
		query.append("          CLL.CNTR_NO E_CNTR_NO," ).append("\n"); 
		query.append("          CLL.CNTR_TPSZ_CD E_TP," ).append("\n"); 
		query.append("          '' E_DETAIL" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_TML_KR_CLL CLL" ).append("\n"); 
		query.append("        WHERE CLL.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("          AND CLL.POL_YD_CD like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("          AND CLL.VSL_CD = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("          AND CLL.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("          AND CLL.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("          AND CLL.CLL_RMK1 LIKE '%RD%'" ).append("\n"); 
		query.append("          AND CLL.POD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND CLL.CNTR_TPSZ_CD <> 'D7' #if (${in_by_type} == 'TS' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IN ('TS', 'TT') #end #if (${in_by_type} == 'LOCAL' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IS NULL #end )" ).append("\n"); 
		query.append("    UNION ALL (" ).append("\n"); 
		query.append("        SELECT '<PC>' E_CGO_TYPE," ).append("\n"); 
		query.append("          CLL.POD_CD E_POD," ).append("\n"); 
		query.append("		 (SELECT BKG.BLCK_STWG_CD" ).append("\n"); 
		query.append("			FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("		   WHERE BKG.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("		     AND ROWNUM=1) AS E_BKG_BS," ).append("\n"); 
		query.append("          CLL.BLCK_STWG_CD E_MLB," ).append("\n"); 
		query.append("          CLL.CNTR_NO E_CNTR_NO," ).append("\n"); 
		query.append("          CLL.CNTR_TPSZ_CD E_TP," ).append("\n"); 
		query.append("          '' E_DETAIL" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_TML_KR_CLL CLL" ).append("\n"); 
		query.append("        WHERE CLL.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("          AND CLL.POL_YD_CD like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("          AND CLL.VSL_CD = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("          AND CLL.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("          AND CLL.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("          --AND CLL.STWG_CD = 'PC'" ).append("\n"); 
		query.append("		  AND (	CLL.STWG_CD = 'PC'" ).append("\n"); 
		query.append("        		or " ).append("\n"); 
		query.append("        		CLL.STWG_CD is null and CLL.KR_TML_PRCT_ID = 'P' )		  " ).append("\n"); 
		query.append("          AND CLL.POD_CD IS NOT NULL #if (${in_by_type} == 'TS' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IN ('TS'," ).append("\n"); 
		query.append("              'TT') #end #if (${in_by_type} == 'LOCAL' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IS NULL #end )" ).append("\n"); 
		query.append("    UNION ALL (" ).append("\n"); 
		query.append("        SELECT '<TANK>' E_CGO_TYPE," ).append("\n"); 
		query.append("          CLL.POD_CD E_POD," ).append("\n"); 
		query.append("		 (SELECT BKG.BLCK_STWG_CD" ).append("\n"); 
		query.append("            FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("           WHERE BKG.BKG_NO = CLL.BKG_NO" ).append("\n"); 
		query.append("             AND ROWNUM=1) AS E_BKG_BS," ).append("\n"); 
		query.append("          CLL.BLCK_STWG_CD E_MLB," ).append("\n"); 
		query.append("          CLL.CNTR_NO E_CNTR_NO," ).append("\n"); 
		query.append("          CLL.CNTR_TPSZ_CD E_TP," ).append("\n"); 
		query.append("          '' E_DETAIL" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_TML_KR_CLL CLL" ).append("\n"); 
		query.append("        WHERE CLL.POL_CD = @[in_pol_cd]" ).append("\n"); 
		query.append("          AND CLL.POL_YD_CD like @[in_pol_yd_cd]||'%'" ).append("\n"); 
		query.append("          AND CLL.VSL_CD = SUBSTR(@[in_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("          AND CLL.SKD_VOY_NO = SUBSTR(@[in_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("          AND CLL.SKD_DIR_CD = SUBSTR(@[in_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("          AND CLL.POD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND CLL.CNTR_TPSZ_CD in('T2', 'T4') #if (${in_by_type} == 'TS' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IN ('TS', 'TT') #end #if (${in_by_type} == 'LOCAL' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IS NULL #end" ).append("\n"); 
		query.append("          AND CLL.CNTR_NO NOT IN(" ).append("\n"); 
		query.append("            SELECT CNTR_NO" ).append("\n"); 
		query.append("            FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("            WHERE CLL.BKG_NO = DG.BKG_NO" ).append("\n"); 
		query.append("              AND CLL.CNTR_NO = DG.CNTR_NO) ) ) #if (${in_sort_type} == '4' )" ).append("\n"); 
		query.append("ORDER BY E_CGO_TYPE, DECODE(E_MLB, 'LOC', '11', 'ONE', '12', 'TWO', '13', 'THR', '14', 'FOR', '15', 'FIV', '15.5', 'SEV', '15.7', 'HOT', '16', 'TRS', '17', '18') #else" ).append("\n"); 
		query.append("ORDER BY E_CGO_TYPE, E_POD, E_BKG_BS, DECODE(E_MLB, 'LOC', '11', 'ONE', '12', 'TWO', '13', 'THR', '14', 'FOR', '15', 'FIV', '15.5', 'SEV', '15.7','HOT', '16', 'TRS', '17', '18') #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}