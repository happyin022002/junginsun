/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearchOpmgFcstReference2CopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOsearchOpmgFcstReference2CopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OPMG Forecast 화면의 Reference 2 의 COP 데이터를 조회한다.
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOsearchOpmgFcstReference2CopRSQL(){
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
		params.put("repo_pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("w3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("w4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("w1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("w2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOsearchOpmgFcstReference2CopRSQL").append("\n"); 
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
		query.append("WITH LV_REPO_IN_WEEK AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT TO_DATE(A.WK_ST_DT, 'YYYYMMDD')      WK_ST_DT," ).append("\n"); 
		query.append("           TO_DATE(A.WK_END_DT,'YYYYMMDD')+21   WK_ED_DT  -- +4WEEK" ).append("\n"); 
		query.append("    FROM EQR_WK_PRD A" ).append("\n"); 
		query.append("    WHERE A.PLN_YR = SUBSTR(@[repo_pln_yrwk],1,4)  -- repo week 검색값" ).append("\n"); 
		query.append("    AND   A.PLN_WK = SUBSTR(@[repo_pln_yrwk],5,2)  -- repo week 검색값" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",LV_YD_LIST AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT /*+ use_nl(a b c) */ " ).append("\n"); 
		query.append("	       C.YD_CD" ).append("\n"); 
		query.append("	     , A.SCC_CD" ).append("\n"); 
		query.append("	FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("	    ,MDM_LOCATION B" ).append("\n"); 
		query.append("	    ,MDM_YARD C" ).append("\n"); 
		query.append("#if(${loc_grp_cd}=='L')" ).append("\n"); 
		query.append("	WHERE A.LCC_CD = @[loc_cd] -- LOC CODE" ).append("\n"); 
		query.append("#elseif(${loc_grp_cd}=='E')" ).append("\n"); 
		query.append("	WHERE A.ECC_CD = @[loc_cd] -- LOC CODE" ).append("\n"); 
		query.append("#elseif(${loc_grp_cd}=='S')" ).append("\n"); 
		query.append("	WHERE A.SCC_CD = @[loc_cd] -- LOC CODE" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND   A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("	AND   B.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 5 CODE" ).append("\n"); 
		query.append("      ,'COP I/B' NAME" ).append("\n"); 
		query.append("      ,'COP I/B' SUB_NAME" ).append("\n"); 
		query.append("      ,@[w1] W1_WK" ).append("\n"); 
		query.append("      ,@[w2] W2_WK" ).append("\n"); 
		query.append("      ,@[w3] W3_WK" ).append("\n"); 
		query.append("      ,@[w4] W4_WK" ).append("\n"); 
		query.append("      ,B.W1_D2" ).append("\n"); 
		query.append("      ,B.W1_D4" ).append("\n"); 
		query.append("      ,B.W1_D5" ).append("\n"); 
		query.append("      ,B.W1_D7 " ).append("\n"); 
		query.append("      ,B.W1_R2" ).append("\n"); 
		query.append("      ,B.W1_R5" ).append("\n"); 
		query.append("      ,B.W1_R9" ).append("\n"); 
		query.append("      ,B.W1_O2 " ).append("\n"); 
		query.append("      ,B.W1_S2" ).append("\n"); 
		query.append("      ,B.W1_O4" ).append("\n"); 
		query.append("      ,B.W1_S4" ).append("\n"); 
		query.append("      ,B.W1_F2 " ).append("\n"); 
		query.append("      ,B.W1_A2" ).append("\n"); 
		query.append("      ,B.W1_F4" ).append("\n"); 
		query.append("      ,B.W1_A4" ).append("\n"); 
		query.append("      ,B.W1_F5 " ).append("\n"); 
		query.append("      ,B.W1_O5  " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,B.W2_D2" ).append("\n"); 
		query.append("      ,B.W2_D4" ).append("\n"); 
		query.append("      ,B.W2_D5" ).append("\n"); 
		query.append("      ,B.W2_D7 " ).append("\n"); 
		query.append("      ,B.W2_R2" ).append("\n"); 
		query.append("      ,B.W2_R5" ).append("\n"); 
		query.append("      ,B.W2_R9" ).append("\n"); 
		query.append("      ,B.W2_O2 " ).append("\n"); 
		query.append("      ,B.W2_S2" ).append("\n"); 
		query.append("      ,B.W2_O4" ).append("\n"); 
		query.append("      ,B.W2_S4" ).append("\n"); 
		query.append("      ,B.W2_F2 " ).append("\n"); 
		query.append("      ,B.W2_A2" ).append("\n"); 
		query.append("      ,B.W2_F4" ).append("\n"); 
		query.append("      ,B.W2_A4" ).append("\n"); 
		query.append("      ,B.W2_F5 " ).append("\n"); 
		query.append("      ,B.W2_O5 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,B.W3_D2" ).append("\n"); 
		query.append("      ,B.W3_D4" ).append("\n"); 
		query.append("      ,B.W3_D5" ).append("\n"); 
		query.append("      ,B.W3_D7 " ).append("\n"); 
		query.append("      ,B.W3_R2" ).append("\n"); 
		query.append("      ,B.W3_R5" ).append("\n"); 
		query.append("      ,B.W3_R9" ).append("\n"); 
		query.append("      ,B.W3_O2 " ).append("\n"); 
		query.append("      ,B.W3_S2" ).append("\n"); 
		query.append("      ,B.W3_O4" ).append("\n"); 
		query.append("      ,B.W3_S4" ).append("\n"); 
		query.append("      ,B.W3_F2 " ).append("\n"); 
		query.append("      ,B.W3_A2" ).append("\n"); 
		query.append("      ,B.W3_F4" ).append("\n"); 
		query.append("      ,B.W3_A4" ).append("\n"); 
		query.append("      ,B.W3_F5 " ).append("\n"); 
		query.append("      ,B.W3_O5 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,B.W4_D2" ).append("\n"); 
		query.append("      ,B.W4_D4" ).append("\n"); 
		query.append("      ,B.W4_D5" ).append("\n"); 
		query.append("      ,B.W4_D7 " ).append("\n"); 
		query.append("      ,B.W4_R2" ).append("\n"); 
		query.append("      ,B.W4_R5" ).append("\n"); 
		query.append("      ,B.W4_R9" ).append("\n"); 
		query.append("      ,B.W4_O2 " ).append("\n"); 
		query.append("      ,B.W4_S2" ).append("\n"); 
		query.append("      ,B.W4_O4" ).append("\n"); 
		query.append("      ,B.W4_S4" ).append("\n"); 
		query.append("      ,B.W4_F2 " ).append("\n"); 
		query.append("      ,B.W4_A2" ).append("\n"); 
		query.append("      ,B.W4_F4" ).append("\n"); 
		query.append("      ,B.W4_A4" ).append("\n"); 
		query.append("      ,B.W4_F5 " ).append("\n"); 
		query.append("      ,B.W4_O5 " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- COP I/B --------------------------------------------------" ).append("\n"); 
		query.append("    SELECT 4 CODE" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'D2', CNTR_QTY))),0) W1_D2" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'D4', CNTR_QTY))),0) W1_D4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'D5', CNTR_QTY))),0) W1_D5" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'D7', CNTR_QTY))),0) W1_D7 " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'R2', CNTR_QTY))),0) W1_R2" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'R5', CNTR_QTY))),0) W1_R5" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'R9', CNTR_QTY))),0) W1_R9" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'O2', CNTR_QTY))),0) W1_O2 " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'S2', CNTR_QTY))),0) W1_S2" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'O4', CNTR_QTY))),0) W1_O4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'S4', CNTR_QTY))),0) W1_S4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'F2', CNTR_QTY))),0) W1_F2 " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'A2', CNTR_QTY))),0) W1_A2" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'F4', CNTR_QTY))),0) W1_F4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'A4', CNTR_QTY))),0) W1_A4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'F5', CNTR_QTY))),0) W1_F5 " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w1], DECODE(CNTR_TPSZ_CD, 'O5', CNTR_QTY))),0) W1_O5  " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'D2', CNTR_QTY))),0) W2_D2" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'D4', CNTR_QTY))),0) W2_D4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'D5', CNTR_QTY))),0) W2_D5" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'D7', CNTR_QTY))),0) W2_D7 " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'R2', CNTR_QTY))),0) W2_R2" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'R5', CNTR_QTY))),0) W2_R5" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'R9', CNTR_QTY))),0) W2_R9" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'O2', CNTR_QTY))),0) W2_O2 " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'S2', CNTR_QTY))),0) W2_S2" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'O4', CNTR_QTY))),0) W2_O4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'S4', CNTR_QTY))),0) W2_S4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'F2', CNTR_QTY))),0) W2_F2 " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'A2', CNTR_QTY))),0) W2_A2" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'F4', CNTR_QTY))),0) W2_F4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'A4', CNTR_QTY))),0) W2_A4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'F5', CNTR_QTY))),0) W2_F5 " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w2], DECODE(CNTR_TPSZ_CD, 'O5', CNTR_QTY))),0) W2_O5   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'D2', CNTR_QTY))),0) W3_D2" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'D4', CNTR_QTY))),0) W3_D4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'D5', CNTR_QTY))),0) W3_D5" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'D7', CNTR_QTY))),0) W3_D7 " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'R2', CNTR_QTY))),0) W3_R2" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'R5', CNTR_QTY))),0) W3_R5" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'R9', CNTR_QTY))),0) W3_R9" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'O2', CNTR_QTY))),0) W3_O2 " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'S2', CNTR_QTY))),0) W3_S2" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'O4', CNTR_QTY))),0) W3_O4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'S4', CNTR_QTY))),0) W3_S4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'F2', CNTR_QTY))),0) W3_F2 " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'A2', CNTR_QTY))),0) W3_A2" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'F4', CNTR_QTY))),0) W3_F4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'A4', CNTR_QTY))),0) W3_A4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'F5', CNTR_QTY))),0) W3_F5 " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w3], DECODE(CNTR_TPSZ_CD, 'O5', CNTR_QTY))),0) W3_O5   " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'D2', CNTR_QTY))),0) W4_D2" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'D4', CNTR_QTY))),0) W4_D4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'D5', CNTR_QTY))),0) W4_D5" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'D7', CNTR_QTY))),0) W4_D7 " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'R2', CNTR_QTY))),0) W4_R2" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'R5', CNTR_QTY))),0) W4_R5" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'R9', CNTR_QTY))),0) W4_R9" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'O2', CNTR_QTY))),0) W4_O2 " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'S2', CNTR_QTY))),0) W4_S2" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'O4', CNTR_QTY))),0) W4_O4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'S4', CNTR_QTY))),0) W4_S4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'F2', CNTR_QTY))),0) W4_F2 " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'A2', CNTR_QTY))),0) W4_A2" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'F4', CNTR_QTY))),0) W4_F4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'A4', CNTR_QTY))),0) W4_A4" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'F5', CNTR_QTY))),0) W4_F5 " ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(WEEK, @[w4], DECODE(CNTR_TPSZ_CD, 'O5', CNTR_QTY))),0) W4_O5             " ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          SELECT WEEK" ).append("\n"); 
		query.append("                ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                ,NVL(COUNT(1),0) CNTR_QTY " ).append("\n"); 
		query.append("          FROM" ).append("\n"); 
		query.append("          (      " ).append("\n"); 
		query.append("                 SELECT A.NOD_CD," ).append("\n"); 
		query.append("                        A.ESTM_DT ," ).append("\n"); 
		query.append("                        (SELECT PLN_YR||PLN_WK FROM EQR_WK_PRD WHERE TO_CHAR(A.ESTM_DT, 'YYYYMMDD') BETWEEN WK_ST_DT AND WK_END_DT) WEEK," ).append("\n"); 
		query.append("                        A.COP_NO," ).append("\n"); 
		query.append("                        A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                        A.BKG_NO," ).append("\n"); 
		query.append("                        A.CNTR_NO" ).append("\n"); 
		query.append("                 FROM (    " ).append("\n"); 
		query.append("                          SELECT A.NOD_CD," ).append("\n"); 
		query.append("                                 A.COP_NO," ).append("\n"); 
		query.append("                                 B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                 B.BKG_NO," ).append("\n"); 
		query.append("                                 B.CNTR_NO," ).append("\n"); 
		query.append("                                 A.ESTM_DT" ).append("\n"); 
		query.append("                          FROM  LV_YD_LIST Y" ).append("\n"); 
		query.append("                               ,LV_REPO_IN_WEEK F " ).append("\n"); 
		query.append("                               ,SCE_COP_DTL A" ).append("\n"); 
		query.append("                               ,SCE_COP_HDR B " ).append("\n"); 
		query.append("                          WHERE A.COP_NO      = B.COP_NO" ).append("\n"); 
		query.append("                          AND   A.ACT_CD      = 'MITYAD'                  -- 하드코딩, (MG : I/B Empty Container Returned)" ).append("\n"); 
		query.append("                          AND   A.ACT_STS_CD IN     ('N','C','F')         -- 하드코딩, C : CURRENT, N : NEXT" ).append("\n"); 
		query.append("                          AND   B.COP_STS_CD NOT IN ('X', 'O')            -- 하드코딩, Cancel, Orphand" ).append("\n"); 
		query.append("                          AND   A.ESTM_DT  BETWEEN  F.WK_ST_DT-30.0 AND F.WK_ED_DT + 20.99999    --+,-30일, 하드코딩" ).append("\n"); 
		query.append("                          AND   Y.YD_CD = A.NOD_CD" ).append("\n"); 
		query.append("                      ) A" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("         GROUP BY WEEK" ).append("\n"); 
		query.append("                 ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append(") B" ).append("\n"); 

	}
}