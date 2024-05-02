/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOLoadImportTotalVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.21
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOLoadImportTotalVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * -------------------------------------------------------------------------------------------------------------------
	  * 1. 2012.12.03 CHM-201221299-01 이혜민 신규 장비 R8,R9 을 40’HC으로 분류하여 CBF 및 COD 메뉴에 반영
	  * 
	  * 2. 2012.12.11 [CHM-201221836] 이수진 TOR: Load/Discharge Vol 을 Bkg data에서 Import시 source 변경
	  *    1) Vol 산정 기준 : 기존 BKG 단위에서 CNTR 단위로 변경
	  *    2) Weight 산정 기준 : 기존 Cargo 무게에서 Cargo 무게 + CNTR 무게 합으로 변경
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOLoadImportTotalVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOLoadImportTotalVORSQL").append("\n"); 
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
		query.append("SELECT 'SML' OPR_CD" ).append("\n"); 
		query.append("   ,   POD_CD" ).append("\n"); 
		query.append("   ,   SUM(DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 1, NULL), NULL)) FULL_BO_20" ).append("\n"); 
		query.append("   ,   SUM(DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '3', 1, NULL), NULL)) FULL_BO_2H" ).append("\n"); 
		query.append("   ,   SUM(DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '4', 1, NULL), NULL)) FULL_BO_40" ).append("\n"); 
		query.append("   ,   SUM(DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '5', 1, CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE NULL END), NULL)) FULL_BO_4H" ).append("\n"); 
		query.append("   ,   SUM(DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '7', 1, NULL), NULL)) FULL_BO_45" ).append("\n"); 
		query.append("   ,   SUM(DECODE(BKG_CGO_TP_CD, 'F', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 'X', 1, NULL), NULL)) FULL_BO_DX" ).append("\n"); 
		query.append("   ,   SUM(DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 1, NULL))) ET_BO_20" ).append("\n"); 
		query.append("   ,   SUM(DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '3', 1, NULL))) ET_BO_2H" ).append("\n"); 
		query.append("   ,   SUM(DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '4', 1, NULL))) ET_BO_40" ).append("\n"); 
		query.append("   ,   SUM(DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '5', 1, CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN 1 ELSE NULL END))) ET_BO_4H" ).append("\n"); 
		query.append("   ,   SUM(DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '7', 1, NULL))) ET_BO_45" ).append("\n"); 
		query.append("   ,   SUM(DECODE(BKG_CGO_TP_CD, 'F', NULL, DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 'X', 1, NULL))) ET_BO_DX" ).append("\n"); 
		query.append("   ,   ROUND(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', CNTR_WGT, NULL)) / 1000,  1)   WT_20" ).append("\n"); 
		query.append("   ,   ROUND(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '3', CNTR_WGT, NULL)) / 1000,  1)   WT_2H" ).append("\n"); 
		query.append("   ,   ROUND(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '4', CNTR_WGT, NULL)) / 1000,  1)   WT_40" ).append("\n"); 
		query.append("   ,   ROUND(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '5', CNTR_WGT, CASE WHEN CNTR_TPSZ_CD IN ('R8', 'R9') THEN CNTR_WGT ELSE NULL END)) / 1000,  1)   WT_4H" ).append("\n"); 
		query.append("   ,   ROUND(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '7', CNTR_WGT, NULL)) / 1000,  1)   WT_45" ).append("\n"); 
		query.append("   ,   ROUND(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 'X', CNTR_WGT, NULL)) / 1000,  1)   WT_DX" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT XX.POD_CD, XX.BKG_CGO_TP_CD, XX.CNTR_TPSZ_CD, XX.CNTR_NO" ).append("\n"); 
		query.append("       ,   XX.CNTR_WGT + (SELECT C.CNTR_TPSZ_TARE_WGT FROM MDM_CNTR_TP_SZ C WHERE C.CNTR_TPSZ_CD = XX.CNTR_TPSZ_CD)  CNTR_WGT" ).append("\n"); 
		query.append("    FROM   (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT V.POD_CD, B.BKG_CGO_TP_CD, C.CNTR_TPSZ_CD, C.CNTR_NO" ).append("\n"); 
		query.append("           ,   SUM(DECODE(C.WGT_UT_CD,'KGS',C.CNTR_WGT,'LBS',C.CNTR_WGT*0.453599,C.CNTR_WGT)) CNTR_WGT " ).append("\n"); 
		query.append("        FROM   VSK_VSL_PORT_SKD S, BKG_VVD V, BKG_CONTAINER C, BKG_BOOKING B, MDM_LOCATION L, MDM_LOCATION D" ).append("\n"); 
		query.append("        WHERE  S.VSL_CD       = @[vsl_cd] " ).append("\n"); 
		query.append("        AND    S.SKD_VOY_NO   = @[voy_no] " ).append("\n"); 
		query.append("        AND    S.SKD_DIR_CD   = @[dir_cd] " ).append("\n"); 
		query.append("        AND    S.YD_CD        = @[yd_cd]" ).append("\n"); 
		query.append("        AND    S.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("        AND    S.VSL_CD       = V.VSL_CD" ).append("\n"); 
		query.append("        AND    S.SKD_VOY_NO   = V.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND    S.SKD_DIR_CD   = V.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND    S.VPS_PORT_CD  = V.POL_CD" ).append("\n"); 
		query.append("        AND    S.CLPT_IND_SEQ = NVL(V.POL_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("        AND    V.BKG_NO     = C.BKG_NO" ).append("\n"); 
		query.append("        AND    V.BKG_NO     = B.BKG_NO" ).append("\n"); 
		query.append("        AND    NVL(B.BKG_STS_CD,'N') IN ('F', 'W', 'A')" ).append("\n"); 
		query.append("        AND    V.POL_CD     = L.LOC_CD" ).append("\n"); 
		query.append("        AND    V.POD_CD     = D.LOC_CD        " ).append("\n"); 
		query.append("        #if (${status1} == 'LM') " ).append("\n"); 
		query.append("        AND    L.CONTI_CD   <> D.CONTI_CD" ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("        AND    L.CONTI_CD   = D.CONTI_CD" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        GROUP BY V.POD_CD, B.BKG_CGO_TP_CD, C.CNTR_TPSZ_CD, C.CNTR_NO" ).append("\n"); 
		query.append("           )XX" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("GROUP BY POD_CD" ).append("\n"); 

	}
}