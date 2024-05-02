/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearchOpmgFcst3AvgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOsearchOpmgFcst3AvgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOpmgFcst3Avg
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOsearchOpmgFcst3AvgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOsearchOpmgFcst3AvgRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.WKY_SIM_TP_CD,'OF','OP','IF','MG','RO','Repo Out',WKY_SIM_TP_CD) WKY_SIM_TP_CD " ).append("\n"); 
		query.append("      ,A.DP_SEQ" ).append("\n"); 
		query.append("      ,ROUND(AVG(D2_QTY)) D2_QTY" ).append("\n"); 
		query.append("      ,ROUND(AVG(D4_QTY)) D4_QTY" ).append("\n"); 
		query.append("      ,ROUND(AVG(D5_QTY)) D5_QTY" ).append("\n"); 
		query.append("      ,ROUND(AVG(D7_QTY)) D7_QTY" ).append("\n"); 
		query.append("      ,ROUND(AVG(R2_QTY)) R2_QTY" ).append("\n"); 
		query.append("      ,ROUND(AVG(R5_QTY)) R5_QTY" ).append("\n"); 
		query.append("      ,ROUND(AVG(R9_QTY)) R9_QTY" ).append("\n"); 
		query.append("      ,ROUND(AVG(O2_QTY)) O2_QTY" ).append("\n"); 
		query.append("      ,ROUND(AVG(S2_QTY)) S2_QTY" ).append("\n"); 
		query.append("      ,ROUND(AVG(O4_QTY)) O4_QTY" ).append("\n"); 
		query.append("      ,ROUND(AVG(S4_QTY)) S4_QTY" ).append("\n"); 
		query.append("      ,ROUND(AVG(F2_QTY)) F2_QTY" ).append("\n"); 
		query.append("      ,ROUND(AVG(A2_QTY)) A2_QTY" ).append("\n"); 
		query.append("      ,ROUND(AVG(F4_QTY)) F4_QTY" ).append("\n"); 
		query.append("      ,ROUND(AVG(A4_QTY)) A4_QTY" ).append("\n"); 
		query.append("      ,ROUND(AVG(F5_QTY)) F5_QTY " ).append("\n"); 
		query.append("      ,ROUND(AVG(O5_QTY)) O5_QTY     " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(                " ).append("\n"); 
		query.append("    SELECT A.FCAST_YRWK" ).append("\n"); 
		query.append("          ,A.WKY_SIM_TP_CD" ).append("\n"); 
		query.append("          ,DECODE(A.WKY_SIM_TP_CD, 'OF', 1, 'IF', 2, 'RO', 3) DP_SEQ" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'D2',CNTR_QTY,0)) D2_QTY" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'D4',CNTR_QTY,0)) D4_QTY" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'D5',CNTR_QTY,0)) D5_QTY" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'D7',CNTR_QTY,0)) D7_QTY" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'R2',CNTR_QTY,0)) R2_QTY" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'R5',CNTR_QTY,0)) R5_QTY" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'R9',CNTR_QTY,0)) R9_QTY" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'O2',CNTR_QTY,0)) O2_QTY" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'S2',CNTR_QTY,0)) S2_QTY" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'O4',CNTR_QTY,0)) O4_QTY" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'S4',CNTR_QTY,0)) S4_QTY" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'F2',CNTR_QTY,0)) F2_QTY" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'A2',CNTR_QTY,0)) A2_QTY" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'F4',CNTR_QTY,0)) F4_QTY" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'A4',CNTR_QTY,0)) A4_QTY" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'F5',CNTR_QTY,0)) F5_QTY " ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,'O5',CNTR_QTY,0)) O5_QTY " ).append("\n"); 
		query.append("    FROM EQR_CTRL_MTY_WKY_SIM A" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("            SELECT W4, W2" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("    				SELECT  LAG(PLN_YR||PLN_WK,4)		OVER (ORDER BY PLN_YR,PLN_WK)	W4," ).append("\n"); 
		query.append("    				        LAG(PLN_YR||PLN_WK,3)		OVER (ORDER BY PLN_YR,PLN_WK)	W3," ).append("\n"); 
		query.append("    						LAG(PLN_YR||PLN_WK,2)		OVER (ORDER BY PLN_YR,PLN_WK)	W2," ).append("\n"); 
		query.append("    						PLN_YR||PLN_WK										        W0" ).append("\n"); 
		query.append("    				FROM	EQR_WK_PRD" ).append("\n"); 
		query.append("    			)" ).append("\n"); 
		query.append("    	    WHERE   W0  = @[repo_pln_yrwk] 	-- BALANCE REPO ID 입력값" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("         ) B" ).append("\n"); 
		query.append("    WHERE A.FCAST_YRWK BETWEEN B.W4 AND B.W2" ).append("\n"); 
		query.append("    AND   A.WKY_SIM_TP_CD IN ('OF', 'IF', 'RO') -- 하드코딩, OF : OP, IF : MG, RO : REPO OUT" ).append("\n"); 
		query.append("    AND   A.CFM_FLG         = 'Y'               -- 하드코딩, 과거값" ).append("\n"); 
		query.append("    AND   A.LOC_GRP_CD      = @[loc_grp_cd]     -- 변수처리" ).append("\n"); 
		query.append("    AND   A.LOC_CD          = @[loc_cd]         -- 변수처리" ).append("\n"); 
		query.append("--    AND   A.WKY_SIM_TP_CD   = 'OF'" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    GROUP BY A.FCAST_YRWK" ).append("\n"); 
		query.append("            ,A.WKY_SIM_TP_CD" ).append("\n"); 
		query.append(") A    " ).append("\n"); 
		query.append("GROUP BY A.WKY_SIM_TP_CD" ).append("\n"); 
		query.append("        ,A.DP_SEQ     " ).append("\n"); 
		query.append("ORDER BY A.DP_SEQ" ).append("\n"); 

	}
}