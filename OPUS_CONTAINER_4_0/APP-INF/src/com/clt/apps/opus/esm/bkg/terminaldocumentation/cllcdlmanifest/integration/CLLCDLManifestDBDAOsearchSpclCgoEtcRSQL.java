/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchSpclCgoEtcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
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
		query.append("          CLL.POD_CD E_POD," ).append("\n"); 
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
		query.append("          AND CLL.STWG_CD <> 'INGU' " ).append("\n"); 
		query.append("#if (${in_by_type} == 'TS' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IN ('TS', 'TT') " ).append("\n"); 
		query.append("#elseif (${in_by_type} == 'LOCAL' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IS NULL " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    UNION ALL (" ).append("\n"); 
		query.append("        SELECT '<R/D>' E_CGO_TYPE," ).append("\n"); 
		query.append("          CLL.POD_CD E_POD," ).append("\n"); 
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
		query.append("          AND CLL.CLL_RMK2 LIKE '%RD%'" ).append("\n"); 
		query.append("          AND CLL.POD_CD IS NOT NULL" ).append("\n"); 
		query.append("          AND CLL.CNTR_TPSZ_CD <> 'D7' " ).append("\n"); 
		query.append("#if (${in_by_type} == 'TS' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IN ('TS', 'TT') " ).append("\n"); 
		query.append("#elseif (${in_by_type} == 'LOCAL' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IS NULL " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    UNION ALL (" ).append("\n"); 
		query.append("        SELECT '<PC>' E_CGO_TYPE," ).append("\n"); 
		query.append("          CLL.POD_CD E_POD," ).append("\n"); 
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
		query.append("		  AND (	CLL.STWG_CD = 'PC'" ).append("\n"); 
		query.append("        		or " ).append("\n"); 
		query.append("        		CLL.STWG_CD is null and CLL.KR_TML_PRCT_ID = 'P' )		  " ).append("\n"); 
		query.append("          AND CLL.POD_CD IS NOT NULL " ).append("\n"); 
		query.append("#if (${in_by_type} == 'TS')" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IN ('TS', 'TT') " ).append("\n"); 
		query.append("#elseif (${in_by_type} == 'LOCAL' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IS NULL " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    UNION ALL (" ).append("\n"); 
		query.append("        SELECT '<TANK>' E_CGO_TYPE," ).append("\n"); 
		query.append("          CLL.POD_CD E_POD," ).append("\n"); 
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
		query.append("          AND CLL.CNTR_TPSZ_CD in('T2', 'T4') " ).append("\n"); 
		query.append("#if (${in_by_type} == 'TS' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IN ('TS', 'TT') " ).append("\n"); 
		query.append("#elseif (${in_by_type} == 'LOCAL' )" ).append("\n"); 
		query.append("          AND CLL.KR_CLL_TS_CD IS NULL " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND CLL.CNTR_NO NOT IN(" ).append("\n"); 
		query.append("            SELECT CNTR_NO" ).append("\n"); 
		query.append("            FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("            WHERE CLL.BKG_NO = DG.BKG_NO" ).append("\n"); 
		query.append("              AND CLL.CNTR_NO = DG.CNTR_NO) ) ) " ).append("\n"); 
		query.append("#if (${in_sort_type} == '4' )" ).append("\n"); 
		query.append("ORDER BY E_CGO_TYPE, DECODE(E_MLB, 'LOC', '11', 'ONE', '12', 'TWO', '13', 'THR', '14', 'FOR', '15', 'FIV', '15.5', 'HOT', '16', 'TRS', '17', '18') " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY E_CGO_TYPE, E_POD, DECODE(E_MLB, 'LOC', '11', 'ONE', '12', 'TWO', '13', 'THR', '14', 'FOR', '15', 'FIV', '15.5','HOT', '16', 'TRS', '17', '18') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}