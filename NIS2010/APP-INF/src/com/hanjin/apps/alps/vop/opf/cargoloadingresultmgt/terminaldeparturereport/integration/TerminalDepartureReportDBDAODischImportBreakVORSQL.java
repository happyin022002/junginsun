/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TerminalDepartureReportDBDAODischImportBreakVORSQL.java
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

public class TerminalDepartureReportDBDAODischImportBreakVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Import Breake
	  * 
	  * 1. 2012.12.11 [CHM-201221836] 이수진 TOR: Load/Discharge Vol 을 Bkg data에서 Import시 source 변경
	  *    1) GRS_WGT 계산수석 변경 : WGT_UT_CD 값에 따라 적용 
	  *       - 'KGS'인 경우 GRS_WGT 그래도 사용, 'LBS'인 경우 GRS_WGT * 0.453599 적용
	  * </pre>
	  */
	public TerminalDepartureReportDBDAODischImportBreakVORSQL(){
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
		query.append("FileName : TerminalDepartureReportDBDAODischImportBreakVORSQL").append("\n"); 
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
		query.append("SELECT POD_CD AS POD," ).append("\n"); 
		query.append("       MAX(DIM_LEN)               AS DML," ).append("\n"); 
		query.append("       SUM(DIM_WDT)               AS DMB," ).append("\n"); 
		query.append("       MAX(DIM_HGT)               AS DMH," ).append("\n"); 
		query.append("       ROUND(SUM(GRS_WGT)/1000,1) AS WEIGHT," ).append("\n"); 
		query.append("       'SML'                      AS OPR_CD," ).append("\n"); 
		query.append("       CNTR_NO" ).append("\n"); 
		query.append("FROM   ( SELECT V.POD_CD, K.DIM_LEN, K.DIM_WDT, K.DIM_HGT" ).append("\n"); 
		query.append("            ,   DECODE(K.WGT_UT_CD,'KGS',K.GRS_WGT,'LBS',K.GRS_WGT*0.453599,K.GRS_WGT) GRS_WGT          " ).append("\n"); 
		query.append("            ,   C.CNTR_NO" ).append("\n"); 
		query.append("         FROM   VSK_VSL_PORT_SKD S, BKG_VVD V, BKG_CONTAINER C, BKG_BOOKING B, BKG_BB_CGO K" ).append("\n"); 
		query.append("         WHERE  S.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("         AND    S.SKD_VOY_NO   = @[voy_no]" ).append("\n"); 
		query.append("         AND    S.SKD_DIR_CD   = @[dir_cd]" ).append("\n"); 
		query.append("         AND    S.YD_CD        = @[yd_cd]" ).append("\n"); 
		query.append("         AND    S.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("         AND    S.VSL_CD       = V.VSL_CD" ).append("\n"); 
		query.append("         AND    S.SKD_VOY_NO   = V.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND    S.SKD_DIR_CD   = V.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND    S.VPS_PORT_CD  = V.POD_CD" ).append("\n"); 
		query.append("         AND    S.CLPT_IND_SEQ = NVL(V.POD_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("         AND    V.BKG_NO       = C.BKG_NO" ).append("\n"); 
		query.append("         AND    V.BKG_NO       = B.BKG_NO" ).append("\n"); 
		query.append("         AND    NVL(B.BKG_STS_CD,'N') NOT IN ('X','A')" ).append("\n"); 
		query.append("         AND    C.BB_CGO_FLG   = 'Y'" ).append("\n"); 
		query.append("         AND    V.BKG_NO       = K.BKG_NO" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT V.POD_CD, K.DIM_LEN, K.DIM_WDT, K.DIM_HGT" ).append("\n"); 
		query.append("            ,   DECODE(K.WGT_UT_CD,'KGS',K.GRS_WGT,'LBS',K.GRS_WGT*0.453599,K.GRS_WGT) GRS_WGT      " ).append("\n"); 
		query.append("            ,   C.CNTR_NO" ).append("\n"); 
		query.append("         FROM   VSK_VSL_PORT_SKD S, BKG_VVD V, BKG_CONTAINER C, BKG_BOOKING B, BKG_BB_CGO K" ).append("\n"); 
		query.append("         WHERE  S.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("         AND    S.SKD_VOY_NO        = @[voy_no]" ).append("\n"); 
		query.append("         AND    S.SKD_DIR_CD        = @[dir_cd]" ).append("\n"); 
		query.append("         AND    S.YD_CD             = @[yd_cd]" ).append("\n"); 
		query.append("         AND    S.CLPT_IND_SEQ      = @[clpt_ind_seq]" ).append("\n"); 
		query.append("         AND    S.TURN_PORT_FLG     = 'Y'" ).append("\n"); 
		query.append("         AND    S.VSL_CD            = V.VSL_CD" ).append("\n"); 
		query.append("         AND    S.TURN_SKD_VOY_NO   = V.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND    S.TURN_SKD_DIR_CD   = V.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND    S.VPS_PORT_CD       = V.POD_CD" ).append("\n"); 
		query.append("         AND    S.TURN_CLPT_IND_SEQ = NVL(V.POD_CLPT_IND_SEQ,1)" ).append("\n"); 
		query.append("         AND    V.BKG_NO            = C.BKG_NO" ).append("\n"); 
		query.append("         AND    V.BKG_NO            = B.BKG_NO" ).append("\n"); 
		query.append("         AND    NVL(B.BKG_STS_CD,'N') NOT IN ('X','A')" ).append("\n"); 
		query.append("         AND    C.BB_CGO_FLG        = 'Y'" ).append("\n"); 
		query.append("         AND    V.BKG_NO            = K.BKG_NO " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("GROUP BY POD_CD, CNTR_NO" ).append("\n"); 
		query.append("ORDER BY OPR_CD, POD_CD, CNTR_NO" ).append("\n"); 

	}
}