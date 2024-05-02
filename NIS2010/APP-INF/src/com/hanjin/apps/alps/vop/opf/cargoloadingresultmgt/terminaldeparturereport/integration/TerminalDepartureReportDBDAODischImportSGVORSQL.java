/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TerminalDepartureReportDBDAODischImportSGVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
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

public class TerminalDepartureReportDBDAODischImportSGVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SC Import
	  * 
	  * 1. 2012.12.10 [CHM-201221836] 이수진 TOR: Load/Discharge Vol 을 Bkg data에서 Import시 source 변경
	  *    1) Vol 산정 기준 : 기존 BKG 단위에서 CNTR 단위로 변경
	  *    2) Weight 산정 기준 : 기존 Cargo 무게에서 Cargo 무게 + CNTR 무게 합으로 변경
	  * </pre>
	  */
	public TerminalDepartureReportDBDAODischImportSGVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAODischImportSGVORSQL").append("\n"); 
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
		query.append("SELECT 'SML'   OPR_CD " ).append("\n"); 
		query.append("   ,   POD_CD AS POD " ).append("\n"); 
		query.append("   ,   SUM(DECODE(DCGO_FLG, 'Y', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, 1, 0), 0))                         	DG_20_QTY" ).append("\n"); 
		query.append("   ,   ROUND( SUM(DECODE(DCGO_FLG, 'Y', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, CNTR_WGT, 0), 0))/1000, 1)  	DG_20_WGT " ).append("\n"); 
		query.append("   ,   SUM(DECODE(DCGO_FLG, 'Y', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, 0, 1), 0))                         	DG_40_QTY " ).append("\n"); 
		query.append("   ,   ROUND( SUM(DECODE(DCGO_FLG, 'Y', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, 0, CNTR_WGT), 0))/1000, 1)  	DG_40_WGT " ).append("\n"); 
		query.append("   ,   SUM(DECODE(RC_FLG, 'Y', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, 1, 0), 0))                           	RF_20_QTY " ).append("\n"); 
		query.append("   ,   ROUND( SUM(DECODE(RC_FLG, 'Y', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, CNTR_WGT, 0), 0))/1000, 1)    	RF_20_WGT " ).append("\n"); 
		query.append("   ,   SUM(DECODE(RC_FLG, 'Y', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, 0, 1), 0))                           	RF_40_QTY " ).append("\n"); 
		query.append("   ,   ROUND( SUM(DECODE(RC_FLG, 'Y', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, 0, CNTR_WGT), 0))/1000, 1)    	RF_40_WGT " ).append("\n"); 
		query.append("   ,   SUM(DECODE(AWK_CGO_FLG, 'Y', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, 1, 0), 0))                      	AK_20_QTY " ).append("\n"); 
		query.append("   ,   ROUND( SUM(DECODE(AWK_CGO_FLG, 'Y', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, CNTR_WGT, 0), 0))/1000, 1) AK_20_WGT " ).append("\n"); 
		query.append("   ,   SUM(DECODE(AWK_CGO_FLG, 'Y', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, 0, 1), 0))                      	AK_40_QTY " ).append("\n"); 
		query.append("   ,   ROUND( SUM(DECODE(AWK_CGO_FLG, 'Y', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), 2, 0, CNTR_WGT), 0))/1000, 1) AK_40_WGT" ).append("\n"); 
		query.append("FROM   ( " ).append("\n"); 
		query.append("        SELECT XX.POD_CD, XX.DCGO_FLG, XX.RC_FLG, XX.AWK_CGO_FLG, XX.CNTR_TPSZ_CD, XX.CNTR_NO" ).append("\n"); 
		query.append("           ,   XX.CNTR_WGT + (SELECT C.CNTR_TPSZ_TARE_WGT FROM MDM_CNTR_TP_SZ C WHERE C.CNTR_TPSZ_CD = XX.CNTR_TPSZ_CD)  CNTR_WGT" ).append("\n"); 
		query.append("        FROM (                     " ).append("\n"); 
		query.append("                 SELECT V.POD_CD,  C.DCGO_FLG,  C.RC_FLG,  C.AWK_CGO_FLG,  C.CNTR_TPSZ_CD,  C.CNTR_NO" ).append("\n"); 
		query.append("                    ,  	SUM(DECODE(C.WGT_UT_CD,'KGS',C.CNTR_WGT,'LBS',C.CNTR_WGT*0.453599,C.CNTR_WGT)) CNTR_WGT" ).append("\n"); 
		query.append("                 FROM   VSK_VSL_PORT_SKD S,  BKG_VVD V,  BKG_CONTAINER C,  BKG_BOOKING B" ).append("\n"); 
		query.append("                 WHERE  S.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("                 AND    S.SKD_VOY_NO   = @[voy_no]" ).append("\n"); 
		query.append("                 AND    S.SKD_DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("                 AND    S.YD_CD        = @[yd_cd]" ).append("\n"); 
		query.append("                 AND    S.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                 AND    S.VSL_CD       = V.VSL_CD" ).append("\n"); 
		query.append("                 AND    S.SKD_VOY_NO   = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND    S.SKD_DIR_CD   = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND    S.VPS_PORT_CD  = V.POD_CD" ).append("\n"); 
		query.append("                 AND    S.CLPT_IND_SEQ = NVL(V.POD_CLPT_IND_SEQ, 1)" ).append("\n"); 
		query.append("                 AND    V.BKG_NO       = C.BKG_NO" ).append("\n"); 
		query.append("                 AND    V.BKG_NO       = B.BKG_NO" ).append("\n"); 
		query.append("                 AND    NVL(B.BKG_STS_CD, 'N') NOT IN ('X', 'A')" ).append("\n"); 
		query.append("                 AND    DECODE(C.DCGO_FLG, 'Y', 'Y', DECODE(C.RC_FLG, 'Y', 'Y', DECODE(C.AWK_CGO_FLG, 'Y', 'Y', 'N'))) = 'Y'" ).append("\n"); 
		query.append("                 GROUP BY V.POD_CD,  C.DCGO_FLG,  C.RC_FLG,  C.AWK_CGO_FLG,  C.CNTR_TPSZ_CD,  C.CNTR_NO" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                 SELECT V.POD_CD,  C.DCGO_FLG,  C.RC_FLG,  C.AWK_CGO_FLG,  C.CNTR_TPSZ_CD,  C.CNTR_NO" ).append("\n"); 
		query.append("                 ,  	SUM(DECODE(C.WGT_UT_CD,'KGS',C.CNTR_WGT,'LBS',C.CNTR_WGT*0.453599,C.CNTR_WGT)) CNTR_WGT" ).append("\n"); 
		query.append("                 FROM   VSK_VSL_PORT_SKD S,  BKG_VVD V,  BKG_CONTAINER C,  BKG_BOOKING B" ).append("\n"); 
		query.append("                 WHERE  S.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("                 AND    S.SKD_VOY_NO        = @[voy_no]" ).append("\n"); 
		query.append("                 AND    S.SKD_DIR_CD        = @[dir_cd]" ).append("\n"); 
		query.append("                 AND    S.YD_CD             = @[yd_cd]" ).append("\n"); 
		query.append("                 AND    S.CLPT_IND_SEQ      = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                 AND    S.TURN_PORT_FLG     = 'Y'" ).append("\n"); 
		query.append("                 AND    S.VSL_CD            = V.VSL_CD" ).append("\n"); 
		query.append("                 AND    S.TURN_SKD_VOY_NO   = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND    S.TURN_SKD_DIR_CD   = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND    S.VPS_PORT_CD       = V.POD_CD" ).append("\n"); 
		query.append("                 AND    S.TURN_CLPT_IND_SEQ = NVL(V.POD_CLPT_IND_SEQ, 1)" ).append("\n"); 
		query.append("                 AND    V.BKG_NO            = C.BKG_NO" ).append("\n"); 
		query.append("                 AND    V.BKG_NO            = B.BKG_NO" ).append("\n"); 
		query.append("                 AND    NVL(B.BKG_STS_CD, 'N') NOT IN ('X', 'A')" ).append("\n"); 
		query.append("                 AND    DECODE(C.DCGO_FLG, 'Y', 'Y', DECODE(C.RC_FLG, 'Y', 'Y', DECODE(C.AWK_CGO_FLG, 'Y', 'Y', 'N'))) = 'Y' " ).append("\n"); 
		query.append("                 GROUP BY V.POD_CD,  C.DCGO_FLG,  C.RC_FLG,  C.AWK_CGO_FLG,  C.CNTR_TPSZ_CD,  C.CNTR_NO" ).append("\n"); 
		query.append("             )XX             " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("GROUP BY POD_CD" ).append("\n"); 
		query.append("ORDER BY OPR_CD, POD_CD" ).append("\n"); 

	}
}