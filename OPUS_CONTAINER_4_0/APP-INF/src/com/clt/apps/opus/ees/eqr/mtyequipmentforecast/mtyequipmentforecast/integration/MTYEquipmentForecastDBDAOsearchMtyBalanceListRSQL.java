/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MTYEquipmentForecastDBDAOsearchMtyBalanceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.27
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.09.27 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang HO Chae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTYEquipmentForecastDBDAOsearchMtyBalanceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 지점별로 향후 2~3 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력/수정/ 조회하며, MTY Balance를 예상하는 화면
	  * </pre>
	  */
	public MTYEquipmentForecastDBDAOsearchMtyBalanceListRSQL(){
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
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.integration").append("\n"); 
		query.append("FileName : MTYEquipmentForecastDBDAOsearchMtyBalanceListRSQL").append("\n"); 
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
		query.append("WITH LV_DUMMY_ITEM AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT LEVEL TP_CD, @[fcast_yrwk] FCAST_YRWK0, @[loc_cd] LOC_CD, " ).append("\n"); 
		query.append("           (SELECT /*+ INDEX_DESC(A XPKEQR_WK_PRD) */ PLN_YR||PLN_WK" ).append("\n"); 
		query.append("            FROM EQR_WK_PRD A" ).append("\n"); 
		query.append("            WHERE PLN_YR||PLN_WK < @[fcast_yrwk]" ).append("\n"); 
		query.append("            AND   ROWNUM = 1) INP_YRWK" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("    CONNECT BY LEVEL < =4" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", LV_DUMMY_WEEK AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT /*+ INDEX(A XPKEQR_WK_PRD) */ ROWNUM WK_SEQ,PLN_YR||PLN_WK AS FCAST_YRWK" ).append("\n"); 
		query.append("    FROM EQR_WK_PRD A" ).append("\n"); 
		query.append("    WHERE PLN_YR||PLN_WK >= @[fcast_yrwk]" ).append("\n"); 
		query.append("    AND   ROWNUM <=3" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", LV_DUMMY_FNL AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT A.TP_CD,A.FCAST_YRWK0, B.FCAST_YRWK,A.LOC_CD,A.INP_YRWK" ).append("\n"); 
		query.append("    FROM LV_DUMMY_ITEM A,LV_DUMMY_WEEK B" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",LV_YD_LIST AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT C.YD_CD, A.SCC_CD" ).append("\n"); 
		query.append("	FROM MDM_EQ_ORZ_CHT A,MDM_LOCATION B,MDM_YARD C" ).append("\n"); 
		query.append("	WHERE A.ECC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	AND   A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("	AND   B.LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    DP_SEQ" ).append("\n"); 
		query.append("    ,TITLE" ).append("\n"); 
		query.append("    ,ITEM" ).append("\n"); 
		query.append("    ,FCAST_YRWK0" ).append("\n"); 
		query.append("    ,TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,D2_FCAST_QTY+D4_FCAST_QTY+D5_FCAST_QTY+D7_FCAST_QTY+R2_FCAST_QTY+R5_FCAST_QTY+O2_FCAST_QTY+S2_FCAST_QTY+O4_FCAST_QTY+S4_FCAST_QTY+F2_FCAST_QTY+A2_FCAST_QTY+F4_FCAST_QTY+A4_FCAST_QTY+F5_FCAST_QTY   G_TOTAL" ).append("\n"); 
		query.append("    ,D2_FCAST_QTY+D4_FCAST_QTY+D5_FCAST_QTY+D7_FCAST_QTY   D_TOTAL" ).append("\n"); 
		query.append("    ,D2_FCAST_QTY D2_FCAST_QTY" ).append("\n"); 
		query.append("    ,D4_FCAST_QTY D4_FCAST_QTY" ).append("\n"); 
		query.append("    ,D5_FCAST_QTY D5_FCAST_QTY" ).append("\n"); 
		query.append("    ,D7_FCAST_QTY D7_FCAST_QTY" ).append("\n"); 
		query.append("    ,R2_FCAST_QTY+R5_FCAST_QTY+O2_FCAST_QTY+S2_FCAST_QTY+O4_FCAST_QTY+S4_FCAST_QTY+F2_FCAST_QTY+A2_FCAST_QTY+F4_FCAST_QTY+A4_FCAST_QTY+F5_FCAST_QTY S_TOTAL" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,R2_FCAST_QTY R2_FCAST_QTY   " ).append("\n"); 
		query.append("    ,R5_FCAST_QTY R5_FCAST_QTY " ).append("\n"); 
		query.append("    ,O2_FCAST_QTY O2_FCAST_QTY" ).append("\n"); 
		query.append("    ,S2_FCAST_QTY S2_FCAST_QTY " ).append("\n"); 
		query.append("    ,O4_FCAST_QTY O4_FCAST_QTY " ).append("\n"); 
		query.append("    ,S4_FCAST_QTY S4_FCAST_QTY  " ).append("\n"); 
		query.append("    ,F2_FCAST_QTY F2_FCAST_QTY " ).append("\n"); 
		query.append("    ,A2_FCAST_QTY A2_FCAST_QTY " ).append("\n"); 
		query.append("    ,F4_FCAST_QTY F4_FCAST_QTY " ).append("\n"); 
		query.append("    ,A4_FCAST_QTY A4_FCAST_QTY " ).append("\n"); 
		query.append("    ,F5_FCAST_QTY F5_FCAST_QTY" ).append("\n"); 
		query.append("  	,(SELECT /*+ INDEX_DESC(A XPKEQR_WK_PRD) */ PLN_YR||PLN_WK" ).append("\n"); 
		query.append("      FROM EQR_WK_PRD A" ).append("\n"); 
		query.append("      WHERE PLN_YR||PLN_WK < @[fcast_yrwk]" ).append("\n"); 
		query.append("      AND   ROWNUM = 1) INP_YRWK" ).append("\n"); 
		query.append("	,(SELECT @[loc_cd] LOC_CD FROM DUAL P) LOC_CD     " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        A.DP_SEQ" ).append("\n"); 
		query.append("        ,A.TITLE" ).append("\n"); 
		query.append("        ,A.ITEM" ).append("\n"); 
		query.append("        ,'' IMAGE_BUTTON" ).append("\n"); 
		query.append("        ,A.FCAST_YRWK0" ).append("\n"); 
		query.append("        ,A.TP_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , A.D2_FCAST_QTY" ).append("\n"); 
		query.append("        , A.D4_FCAST_QTY" ).append("\n"); 
		query.append("        , A.D5_FCAST_QTY" ).append("\n"); 
		query.append("        , A.D7_FCAST_QTY" ).append("\n"); 
		query.append("        , A.R2_FCAST_QTY" ).append("\n"); 
		query.append("        , A.R5_FCAST_QTY" ).append("\n"); 
		query.append("        , A.O2_FCAST_QTY" ).append("\n"); 
		query.append("        , A.S2_FCAST_QTY" ).append("\n"); 
		query.append("        , A.O4_FCAST_QTY" ).append("\n"); 
		query.append("        , A.S4_FCAST_QTY" ).append("\n"); 
		query.append("        , A.F2_FCAST_QTY" ).append("\n"); 
		query.append("        , A.A2_FCAST_QTY" ).append("\n"); 
		query.append("        , A.F4_FCAST_QTY" ).append("\n"); 
		query.append("        , A.A4_FCAST_QTY" ).append("\n"); 
		query.append("        , A.F5_FCAST_QTY" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT B.TP_CD DP_SEQ" ).append("\n"); 
		query.append("               ,DECODE(B.TP_CD, 1,'Sound MT','Damage MT') TITLE" ).append("\n"); 
		query.append("               ,DECODE(B.TP_CD, 1,'Sound MT','Damage MT') ITEM" ).append("\n"); 
		query.append("               ,B.FCAST_YRWK0" ).append("\n"); 
		query.append("               ,B.TP_CD" ).append("\n"); 
		query.append("               ,NVL(D2_FCAST_QTY,0) D2_FCAST_QTY" ).append("\n"); 
		query.append("               ,NVL(D4_FCAST_QTY,0) D4_FCAST_QTY" ).append("\n"); 
		query.append("               ,NVL(D5_FCAST_QTY,0) D5_FCAST_QTY" ).append("\n"); 
		query.append("               ,NVL(D7_FCAST_QTY,0) D7_FCAST_QTY" ).append("\n"); 
		query.append("               ,NVL(R2_FCAST_QTY,0) R2_FCAST_QTY" ).append("\n"); 
		query.append("               ,NVL(R5_FCAST_QTY,0) R5_FCAST_QTY" ).append("\n"); 
		query.append("               ,NVL(O2_FCAST_QTY,0) O2_FCAST_QTY" ).append("\n"); 
		query.append("               ,NVL(S2_FCAST_QTY,0) S2_FCAST_QTY" ).append("\n"); 
		query.append("               ,NVL(O4_FCAST_QTY,0) O4_FCAST_QTY" ).append("\n"); 
		query.append("               ,NVL(S4_FCAST_QTY,0) S4_FCAST_QTY" ).append("\n"); 
		query.append("               ,NVL(F2_FCAST_QTY,0) F2_FCAST_QTY" ).append("\n"); 
		query.append("               ,NVL(A2_FCAST_QTY,0) A2_FCAST_QTY" ).append("\n"); 
		query.append("               ,NVL(F4_FCAST_QTY,0) F4_FCAST_QTY" ).append("\n"); 
		query.append("               ,NVL(A4_FCAST_QTY,0) A4_FCAST_QTY" ).append("\n"); 
		query.append("               ,NVL(F5_FCAST_QTY,0) F5_FCAST_QTY" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("            (SELECT  A.DMG_FLG" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.CNTR_TPSZ_CD,'D2',CNTR_QTY,0)) D2_FCAST_QTY" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.CNTR_TPSZ_CD,'D4',CNTR_QTY,0)) D4_FCAST_QTY" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.CNTR_TPSZ_CD,'D5',CNTR_QTY,0)) D5_FCAST_QTY" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.CNTR_TPSZ_CD,'D7',CNTR_QTY,0)) D7_FCAST_QTY" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.CNTR_TPSZ_CD,'R2',CNTR_QTY,0)) R2_FCAST_QTY" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.CNTR_TPSZ_CD,'R5',CNTR_QTY,0)) R5_FCAST_QTY" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.CNTR_TPSZ_CD,'O2',CNTR_QTY,0)) O2_FCAST_QTY" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.CNTR_TPSZ_CD,'S2',CNTR_QTY,0)) S2_FCAST_QTY" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.CNTR_TPSZ_CD,'O4',CNTR_QTY,0)) O4_FCAST_QTY" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.CNTR_TPSZ_CD,'S4',CNTR_QTY,0)) S4_FCAST_QTY" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.CNTR_TPSZ_CD,'F2',CNTR_QTY,0)) F2_FCAST_QTY" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.CNTR_TPSZ_CD,'A2',CNTR_QTY,0)) A2_FCAST_QTY" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.CNTR_TPSZ_CD,'F4',CNTR_QTY,0)) F4_FCAST_QTY" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.CNTR_TPSZ_CD,'A4',CNTR_QTY,0)) A4_FCAST_QTY" ).append("\n"); 
		query.append("                     ,SUM(DECODE(A.CNTR_TPSZ_CD,'F5',CNTR_QTY,0)) F5_FCAST_QTY " ).append("\n"); 
		query.append("            FROM  CIM_ETC_INVT A" ).append("\n"); 
		query.append("            WHERE A.CO_CD (+)='O'" ).append("\n"); 
		query.append("            AND   A.INVT_USE_TP_CD(+) = '1'" ).append("\n"); 
		query.append("            AND   A.BSE_DT (+)= @[fcast_yrwk]" ).append("\n"); 
		query.append("            AND   A.LOC_CD(+) = @[loc_cd]" ).append("\n"); 
		query.append("            GROUP BY A.DMG_FLG), LV_DUMMY_ITEM  B" ).append("\n"); 
		query.append("        WHERE DECODE(DMG_FLG(+),'Y',2,1) = B.TP_CD" ).append("\n"); 
		query.append("        AND   B.TP_CD IN(1,2)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT   DECODE(A.DP_SEQ,1,3,2,4,3,8,4,9,5,16,7,20,9,27,11,31) DP_SEQ," ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                 DECODE(A.DP_SEQ,1,'Supply',2,'Supply',3,'Demand',4,'Demand'," ).append("\n"); 
		query.append("                                 5,'Supply',7,'Demand', 9,'Supply',11,'Demand') TITLE," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                 DECODE(A.DP_SEQ,1,'I/B FCST',2,'I/B Remaining (F~S)',3,'O/B FCST',4,'O/B Remaining (F~S)'," ).append("\n"); 
		query.append("                                 5,'I/B FCST',7,'O/B FCST', 9,'I/B FCST',11,'O/B FCST') ITEM" ).append("\n"); 
		query.append("                 ,A.FCAST_YRWK" ).append("\n"); 
		query.append("                 ,A.TP_CD" ).append("\n"); 
		query.append("                 ,A.D2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,A.D4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,A.D5_FCAST_QTY" ).append("\n"); 
		query.append("                 ,A.D7_FCAST_QTY" ).append("\n"); 
		query.append("                 ,A.R2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,A.R5_FCAST_QTY" ).append("\n"); 
		query.append("                 ,A.O2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,A.S2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,A.O4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,A.S4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,A.F2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,A.A2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,A.F4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,A.A4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,A.F5_FCAST_QTY                 " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            (SELECT " ).append("\n"); 
		query.append("                 ROW_NUMBER() OVER (ORDER BY B.FCAST_YRWK,B.TP_CD) DP_SEQ," ).append("\n"); 
		query.append("                 B.FCAST_YRWK0,1," ).append("\n"); 
		query.append("                 B.FCAST_YRWK," ).append("\n"); 
		query.append("                 B.TP_CD" ).append("\n"); 
		query.append("                 ,NVL(A.D2_FCAST_QTY,0) D2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,NVL(A.D4_FCAST_QTY,0) D4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,NVL(A.D5_FCAST_QTY,0) D5_FCAST_QTY" ).append("\n"); 
		query.append("                 ,NVL(A.D7_FCAST_QTY,0) D7_FCAST_QTY" ).append("\n"); 
		query.append("                 ,NVL(A.R2_FCAST_QTY,0) R2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,NVL(A.R5_FCAST_QTY,0) R5_FCAST_QTY" ).append("\n"); 
		query.append("                 ,NVL(A.O2_FCAST_QTY,0) O2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,NVL(A.S2_FCAST_QTY,0) S2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,NVL(A.O4_FCAST_QTY,0) O4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,NVL(A.S4_FCAST_QTY,0) S4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,NVL(A.F2_FCAST_QTY,0) F2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,NVL(A.A2_FCAST_QTY,0) A2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,NVL(A.F4_FCAST_QTY,0) F4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,NVL(A.A4_FCAST_QTY,0) A4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,NVL(A.F5_FCAST_QTY,0) F5_FCAST_QTY" ).append("\n"); 
		query.append("            FROM EQR_MTY_BAL_RPT A , LV_DUMMY_FNL B" ).append("\n"); 
		query.append("            WHERE A.CO_CD(+) = 'O'" ).append("\n"); 
		query.append("            AND   A.LOC_CD(+) = B.LOC_CD" ).append("\n"); 
		query.append("            AND   A.INP_YRWK(+) = B.INP_YRWK" ).append("\n"); 
		query.append("            AND   A.FCAST_YRWK(+) = B.FCAST_YRWK" ).append("\n"); 
		query.append("            AND   A.MTY_BAL_TP_CD(+) = B.TP_CD) A" ).append("\n"); 
		query.append("        WHERE A.FCAST_YRWK0 = A.FCAST_YRWK " ).append("\n"); 
		query.append("        OR    (A.FCAST_YRWK0 <> A.FCAST_YRWK  AND A.TP_CD IN(1,3))" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT DECODE(A.DP_SEQ,1,6,2,7,3,12,4,18,5,19,6,23,7,29,8,30,9,34) DP_SEQ" ).append("\n"); 
		query.append("              ,DECODE(A.TP_CD,1,'Supply',2,'Supply',4,'Demand') TITLE" ).append("\n"); 
		query.append("              ,DECODE(A.TP_CD,1,'OW&On-hire',2,'+ Others',4,'- Others') ITEM" ).append("\n"); 
		query.append("              ,A.FCAST_YRWK,A.TP_CD" ).append("\n"); 
		query.append("              ,A.D2_FCAST_QTY" ).append("\n"); 
		query.append("              ,A.D4_FCAST_QTY" ).append("\n"); 
		query.append("              ,A.D5_FCAST_QTY" ).append("\n"); 
		query.append("              ,A.D7_FCAST_QTY" ).append("\n"); 
		query.append("              ,A.R2_FCAST_QTY" ).append("\n"); 
		query.append("              ,A.R5_FCAST_QTY" ).append("\n"); 
		query.append("              ,A.O2_FCAST_QTY" ).append("\n"); 
		query.append("              ,A.S2_FCAST_QTY" ).append("\n"); 
		query.append("              ,A.O4_FCAST_QTY" ).append("\n"); 
		query.append("              ,A.S4_FCAST_QTY" ).append("\n"); 
		query.append("              ,A.F2_FCAST_QTY" ).append("\n"); 
		query.append("              ,A.A2_FCAST_QTY" ).append("\n"); 
		query.append("              ,A.F4_FCAST_QTY" ).append("\n"); 
		query.append("              ,A.A4_FCAST_QTY" ).append("\n"); 
		query.append("              ,A.F5_FCAST_QTY       " ).append("\n"); 
		query.append("        FROM(" ).append("\n"); 
		query.append("            SELECT   ROW_NUMBER() OVER (ORDER BY B.FCAST_YRWK,B.TP_CD) DP_SEQ" ).append("\n"); 
		query.append("                    ,B.FCAST_YRWK" ).append("\n"); 
		query.append("                    ,B.TP_CD" ).append("\n"); 
		query.append("                    ,NVL(SUM(A.D2_FCAST_QTY),0) D2_FCAST_QTY" ).append("\n"); 
		query.append("                    ,NVL(SUM(A.D4_FCAST_QTY),0) D4_FCAST_QTY" ).append("\n"); 
		query.append("                    ,NVL(SUM(A.D5_FCAST_QTY),0) D5_FCAST_QTY" ).append("\n"); 
		query.append("                    ,NVL(SUM(A.D7_FCAST_QTY),0) D7_FCAST_QTY" ).append("\n"); 
		query.append("                    ,NVL(SUM(A.R2_FCAST_QTY),0) R2_FCAST_QTY" ).append("\n"); 
		query.append("                    ,NVL(SUM(A.R5_FCAST_QTY),0) R5_FCAST_QTY" ).append("\n"); 
		query.append("                    ,NVL(SUM(A.O2_FCAST_QTY),0) O2_FCAST_QTY" ).append("\n"); 
		query.append("                    ,NVL(SUM(A.S2_FCAST_QTY),0) S2_FCAST_QTY" ).append("\n"); 
		query.append("                    ,NVL(SUM(A.O4_FCAST_QTY),0) O4_FCAST_QTY" ).append("\n"); 
		query.append("                    ,NVL(SUM(A.S4_FCAST_QTY),0) S4_FCAST_QTY" ).append("\n"); 
		query.append("                    ,NVL(SUM(A.F2_FCAST_QTY),0) F2_FCAST_QTY" ).append("\n"); 
		query.append("                    ,NVL(SUM(A.A2_FCAST_QTY),0) A2_FCAST_QTY" ).append("\n"); 
		query.append("                    ,NVL(SUM(A.F4_FCAST_QTY),0) F4_FCAST_QTY" ).append("\n"); 
		query.append("                    ,NVL(SUM(A.A4_FCAST_QTY),0) A4_FCAST_QTY" ).append("\n"); 
		query.append("                    ,NVL(SUM(A.F5_FCAST_QTY),0) F5_FCAST_QTY" ).append("\n"); 
		query.append("            FROM  EQR_MTY_BAL_RPT_OTR A , LV_DUMMY_FNL B" ).append("\n"); 
		query.append("            WHERE A.CO_CD(+) = 'O'" ).append("\n"); 
		query.append("            AND   A.LOC_CD(+) = B.LOC_CD" ).append("\n"); 
		query.append("            AND   A.INP_YRWK(+) = B.INP_YRWK" ).append("\n"); 
		query.append("            AND   A.FCAST_YRWK(+) = B.FCAST_YRWK" ).append("\n"); 
		query.append("            AND   A.MTY_BAL_OTR_TP_CD(+) = B.TP_CD" ).append("\n"); 
		query.append("            AND   B.TP_CD IN(1,2,4)" ).append("\n"); 
		query.append("            GROUP BY  B.FCAST_YRWK,B.TP_CD" ).append("\n"); 
		query.append("            ) A" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT    DP_SEQ" ).append("\n"); 
		query.append("                 ,'Demand', 'Repo In', A.FCAST_YRWK FCAST_YRWK0, 1" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'D2',CNTR_QTY,0)) D2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'D4',CNTR_QTY,0)) D4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'D5',CNTR_QTY,0)) D5_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'D7',CNTR_QTY,0)) D7_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'R2',CNTR_QTY,0)) R2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'R5',CNTR_QTY,0)) R5_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'O2',CNTR_QTY,0)) O2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'S2',CNTR_QTY,0)) S2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'O4',CNTR_QTY,0)) O4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'S4',CNTR_QTY,0)) S4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'F2',CNTR_QTY,0)) F2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'A2',CNTR_QTY,0)) A2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'F4',CNTR_QTY,0)) F4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'A4',CNTR_QTY,0)) A4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'F5',CNTR_QTY,0)) F5_FCAST_QTY" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("              SELECT DECODE(D.SEQ,1,5,2,17,3,28) DP_SEQ" ).append("\n"); 
		query.append("                    ,D.FCAST_YRWK" ).append("\n"); 
		query.append("                    ,A.CNTR_TPSZ_CD, SUM(A.CNTR_QTY) CNTR_QTY" ).append("\n"); 
		query.append("              FROM   LV_YD_LIST Y, EQR_MTY_REPO_LAND_IB_V A, (SELECT /*+ INDEX(A XPKEQR_WK_PRD) */ " ).append("\n"); 
		query.append("                                                                  ROWNUM AS SEQ,PLN_YR||PLN_WK, WK_ST_DT, WK_END_DT, @[fcast_yrwk] FCAST_YRWK , @[loc_cd] LOC_CD" ).append("\n"); 
		query.append("                                                              FROM EQR_WK_PRD A" ).append("\n"); 
		query.append("                                                              WHERE PLN_YR||PLN_WK >= @[fcast_yrwk]" ).append("\n"); 
		query.append("                                                              AND   PLN_YR >= SUBSTR(@[fcast_yrwk],1,4)" ).append("\n"); 
		query.append("                                                              AND   ROWNUM <=3) D" ).append("\n"); 
		query.append("              WHERE A.TO_ETA_DT BETWEEN TO_DATE(D.WK_ST_DT,'YYYYMMDD') AND TO_DATE(D.WK_END_DT,'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("              AND   A.TO_YD_CD= Y.YD_CD" ).append("\n"); 
		query.append("              AND   A.CNTR_QTY > 0" ).append("\n"); 
		query.append("              GROUP BY D.SEQ,D.FCAST_YRWK,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              UNION ALL" ).append("\n"); 
		query.append("            SELECT DECODE(D.SEQ,1,5,2,17,3,28) DP_SEQ" ).append("\n"); 
		query.append("                  ,D.FCAST_YRWK" ).append("\n"); 
		query.append("                  ,A.CNTR_TPSZ_CD, SUM(A.CNTR_QTY) CNTR_QTY" ).append("\n"); 
		query.append("            FROM   LV_YD_LIST Y, EQR_MTY_REPO_VSL_IB_V A,  (SELECT /*+ INDEX(A XPKEQR_WK_PRD) */ " ).append("\n"); 
		query.append("                                                                ROWNUM AS SEQ,PLN_YR||PLN_WK, WK_ST_DT, WK_END_DT, @[fcast_yrwk] FCAST_YRWK ,@[loc_cd] LOC_CD" ).append("\n"); 
		query.append("                                                            FROM EQR_WK_PRD A" ).append("\n"); 
		query.append("                                                            WHERE PLN_YR||PLN_WK >= @[fcast_yrwk]" ).append("\n"); 
		query.append("                                                            AND   PLN_YR >= SUBSTR(@[fcast_yrwk],1,4)" ).append("\n"); 
		query.append("                                                            AND   ROWNUM <=3) D--,LV_REPO_PLN_ID E" ).append("\n"); 
		query.append("            WHERE A.TO_ETA_DT BETWEEN TO_DATE(D.WK_ST_DT,'YYYYMMDD') AND TO_DATE(D.WK_END_DT,'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("			AND   DECODE(A.TYPE_CD,'P',A.TO_ECC_CD,'1') = DECODE(A.TYPE_CD,'P',@[loc_cd],'1')" ).append("\n"); 
		query.append("            AND   A.TO_YD_CD= Y.YD_CD" ).append("\n"); 
		query.append("            AND   A.CNTR_QTY > 0" ).append("\n"); 
		query.append("            --AND   DECODE(A.TYPE_CD,'1',A.REPO_PLN_ID,'1') >= DECODE(A.TYPE_CD,'1',E.REPO_PLN_ID,'0')" ).append("\n"); 
		query.append("            AND   DECODE(A.TYPE_CD,'P',A.REPO_PLN_ID,'1') = DECODE(A.TYPE_CD,'P',@[repo_pln_id],'1')" ).append("\n"); 
		query.append("            GROUP BY D.SEQ,D.FCAST_YRWK,A.CNTR_TPSZ_CD            " ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT   DECODE(LEVEL,1,5,2,17,3,28) DP_SEQ" ).append("\n"); 
		query.append("                    ,@[fcast_yrwk] FCAST_YRWK0" ).append("\n"); 
		query.append("                    ,'D2' CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    , 0 CNTR_QTY" ).append("\n"); 
		query.append("            FROM DUAL" ).append("\n"); 
		query.append("            CONNECT BY LEVEL <=3" ).append("\n"); 
		query.append("            ) A" ).append("\n"); 
		query.append("        GROUP BY DP_SEQ,FCAST_YRWK" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT    DP_SEQ" ).append("\n"); 
		query.append("                 ,'Demand', 'Repo Out', A.FCAST_YRWK FCAST_YRWK0, 1" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'D2',CNTR_QTY,0)) D2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'D4',CNTR_QTY,0)) D4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'D5',CNTR_QTY,0)) D5_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'D7',CNTR_QTY,0)) D7_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'R2',CNTR_QTY,0)) R2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'R5',CNTR_QTY,0)) R5_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'O2',CNTR_QTY,0)) O2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'S2',CNTR_QTY,0)) S2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'O4',CNTR_QTY,0)) O4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'S4',CNTR_QTY,0)) S4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'F2',CNTR_QTY,0)) F2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'A2',CNTR_QTY,0)) A2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'F4',CNTR_QTY,0)) F4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'A4',CNTR_QTY,0)) A4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'F5',CNTR_QTY,0)) F5_FCAST_QTY" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT /*+ ordered use_nl(D Y A) */  " ).append("\n"); 
		query.append("				   DECODE(D.SEQ,1,10,2,21,3,32) DP_SEQ" ).append("\n"); 
		query.append("                  ,D.FCAST_YRWK" ).append("\n"); 
		query.append("                  ,A.CNTR_TPSZ_CD, SUM(A.CNTR_QTY) CNTR_QTY" ).append("\n"); 
		query.append("            FROM  (SELECT /*+ INDEX(A XPKEQR_WK_PRD) */ " ).append("\n"); 
		query.append("                        ROWNUM AS SEQ,PLN_YR||PLN_WK, WK_ST_DT, WK_END_DT, @[fcast_yrwk] FCAST_YRWK , @[loc_cd] LOC_CD" ).append("\n"); 
		query.append("                   FROM EQR_WK_PRD A" ).append("\n"); 
		query.append("                   WHERE PLN_YR||PLN_WK >= @[fcast_yrwk]" ).append("\n"); 
		query.append("                   AND   PLN_YR >= SUBSTR(@[fcast_yrwk],1,4)" ).append("\n"); 
		query.append("                   AND   ROWNUM <=3) D, LV_YD_LIST Y, EQR_MTY_REPO_OB_V A" ).append("\n"); 
		query.append("            WHERE A.FM_ETD_DT BETWEEN TO_DATE(D.WK_ST_DT,'YYYYMMDD') AND TO_DATE(D.WK_END_DT,'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("            AND   A.FM_YD_CD= Y.YD_CD" ).append("\n"); 
		query.append("            AND   A.CNTR_QTY > 0" ).append("\n"); 
		query.append("            GROUP BY D.SEQ,D.FCAST_YRWK,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT   DECODE(LEVEL,1,10,2,21,3,32) DP_SEQ" ).append("\n"); 
		query.append("                    ,@[fcast_yrwk] FCAST_YRWK0" ).append("\n"); 
		query.append("                    ,'D2' CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    , 0 CNTR_QTY" ).append("\n"); 
		query.append("            FROM DUAL" ).append("\n"); 
		query.append("            CONNECT BY LEVEL <=3" ).append("\n"); 
		query.append("            ) A" ).append("\n"); 
		query.append("        GROUP BY DP_SEQ,FCAST_YRWK        " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT    DP_SEQ" ).append("\n"); 
		query.append("                 ,'Demand', 'Off-hire', A.FCAST_YRWK FCAST_YRWK0, 1" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'D2',CNTR_QTY,0)) D2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'D4',CNTR_QTY,0)) D4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'D5',CNTR_QTY,0)) D5_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'D7',CNTR_QTY,0)) D7_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'R2',CNTR_QTY,0)) R2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'R5',CNTR_QTY,0)) R5_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'O2',CNTR_QTY,0)) O2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'S2',CNTR_QTY,0)) S2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'O4',CNTR_QTY,0)) O4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'S4',CNTR_QTY,0)) S4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'F2',CNTR_QTY,0)) F2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'A2',CNTR_QTY,0)) A2_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'F4',CNTR_QTY,0)) F4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'A4',CNTR_QTY,0)) A4_FCAST_QTY" ).append("\n"); 
		query.append("                 ,SUM(DECODE(A.CNTR_TPSZ_CD,'F5',CNTR_QTY,0)) F5_FCAST_QTY" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            SELECT  DECODE(C.SEQ,1,11,2,22,3,33) DP_SEQ" ).append("\n"); 
		query.append("                   ,C.FCAST_YRWK" ).append("\n"); 
		query.append("                   ,A.CNTR_TPSZ_CD, COUNT(A.MTY_RTN_YD_CD) CNTR_QTY" ).append("\n"); 
		query.append("            FROM  LSE_AVAL_OFFH A, MDM_EQ_ORZ_CHT B, (SELECT /*+ INDEX(A XPKEQR_WK_PRD) */ " ).append("\n"); 
		query.append("                                                             ROWNUM AS SEQ,A.PLN_YR||A.PLN_WK, A.WK_ST_DT, A.WK_END_DT, @[fcast_yrwk] FCAST_YRWK ,@[loc_cd] LOC_CD" ).append("\n"); 
		query.append("                                                      FROM  EQR_WK_PRD A" ).append("\n"); 
		query.append("                                                      WHERE A.PLN_YR||A.PLN_WK >= @[fcast_yrwk]" ).append("\n"); 
		query.append("                                                      AND   A.PLN_YR >= SUBSTR(@[fcast_yrwk],1,4)" ).append("\n"); 
		query.append("                                                      AND   ROWNUM <=3) C  ,MST_CONTAINER D " ).append("\n"); 
		query.append("            WHERE A.OFFH_DUE_DT BETWEEN C.WK_ST_DT AND C.WK_END_DT" ).append("\n"); 
		query.append("            AND   A.OFFH_STS_CD = 'C'" ).append("\n"); 
		query.append("            AND   SUBSTR(A.MTY_RTN_YD_CD,1,5) = B.SCC_CD" ).append("\n"); 
		query.append("            AND   B.ECC_CD = C.LOC_CD" ).append("\n"); 
		query.append("            AND   A.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("            AND   D.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("            AND   D.IMDT_EXT_FLG = 'N'" ).append("\n"); 
		query.append("            AND   DECODE(A.CNTR_FULL_FLG,'Y','1',D.FULL_FLG)  = DECODE(A.CNTR_FULL_FLG,'Y','1','N')  -- OFF 대상 선정시 MTY 였다가 현재 FULL 로 바뀐 것은 제외" ).append("\n"); 
		query.append("            GROUP BY C.SEQ,C.FCAST_YRWK,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT   DECODE(LEVEL,1,11,2,22,3,33) DP_SEQ" ).append("\n"); 
		query.append("                    ,@[fcast_yrwk] FCAST_YRWK0" ).append("\n"); 
		query.append("                    ,'D2' CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                    , 0 CNTR_QTY" ).append("\n"); 
		query.append("            FROM DUAL" ).append("\n"); 
		query.append("            CONNECT BY LEVEL <=3" ).append("\n"); 
		query.append("            ) A" ).append("\n"); 
		query.append("        GROUP BY DP_SEQ,FCAST_YRWK    " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("            SELECT DECODE(WK_SEQ,1,13,2,24,3,35) DP_SEQ, 'MTY Balance', 'MTY Balance' ,'2000929' FCAST_YRWK0, 1" ).append("\n"); 
		query.append("                       ,0 D2_QTY" ).append("\n"); 
		query.append("                       ,0 D4_QTY" ).append("\n"); 
		query.append("                       ,0 D5_QTY" ).append("\n"); 
		query.append("                       ,0 D7_QTY" ).append("\n"); 
		query.append("                       ,0 R2_QTY" ).append("\n"); 
		query.append("                       ,0 R5_QTY" ).append("\n"); 
		query.append("                       ,0 O2_QTY" ).append("\n"); 
		query.append("                       ,0 S2_QTY" ).append("\n"); 
		query.append("                       ,0 O4_QTY" ).append("\n"); 
		query.append("                       ,0 S4_QTY" ).append("\n"); 
		query.append("                       ,0 F2_QTY" ).append("\n"); 
		query.append("                       ,0 A2_QTY" ).append("\n"); 
		query.append("                       ,0 F4_QTY" ).append("\n"); 
		query.append("                       ,0 A4_QTY" ).append("\n"); 
		query.append("                       ,0 F5_QTY" ).append("\n"); 
		query.append("            FROM LV_DUMMY_WEEK" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("            SELECT DECODE(WK_SEQ,2,14,3,25) DP_SEQ,FCAST_YRWK, FCAST_YRWK ,'2000929' FCAST_YRWK0, 1" ).append("\n"); 
		query.append("                       ,0 D2_QTY" ).append("\n"); 
		query.append("                       ,0 D4_QTY" ).append("\n"); 
		query.append("                       ,0 D5_QTY" ).append("\n"); 
		query.append("                       ,0 D7_QTY" ).append("\n"); 
		query.append("                       ,0 R2_QTY" ).append("\n"); 
		query.append("                       ,0 R5_QTY" ).append("\n"); 
		query.append("                       ,0 O2_QTY" ).append("\n"); 
		query.append("                       ,0 S2_QTY" ).append("\n"); 
		query.append("                       ,0 O4_QTY" ).append("\n"); 
		query.append("                       ,0 S4_QTY" ).append("\n"); 
		query.append("                       ,0 F2_QTY" ).append("\n"); 
		query.append("                       ,0 A2_QTY" ).append("\n"); 
		query.append("                       ,0 F4_QTY" ).append("\n"); 
		query.append("                       ,0 A4_QTY" ).append("\n"); 
		query.append("                       ,0 F5_QTY" ).append("\n"); 
		query.append("            FROM LV_DUMMY_WEEK" ).append("\n"); 
		query.append("            WHERE WK_SEQ > 1" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    	UNION ALL" ).append("\n"); 
		query.append("    		SELECT DECODE(WK_SEQ,2,15,3,26) DP_SEQ,'Estimated Sound MT', 'Estimated Sound MT' ,FCAST_YRWK, 1" ).append("\n"); 
		query.append("                       ,0 D2_QTY" ).append("\n"); 
		query.append("                       ,0 D4_QTY" ).append("\n"); 
		query.append("                       ,0 D5_QTY" ).append("\n"); 
		query.append("                       ,0 D7_QTY" ).append("\n"); 
		query.append("                       ,0 R2_QTY" ).append("\n"); 
		query.append("                       ,0 R5_QTY" ).append("\n"); 
		query.append("                       ,0 O2_QTY" ).append("\n"); 
		query.append("                       ,0 S2_QTY" ).append("\n"); 
		query.append("                       ,0 O4_QTY" ).append("\n"); 
		query.append("                       ,0 S4_QTY" ).append("\n"); 
		query.append("                       ,0 F2_QTY" ).append("\n"); 
		query.append("                       ,0 A2_QTY" ).append("\n"); 
		query.append("                       ,0 F4_QTY" ).append("\n"); 
		query.append("                       ,0 A4_QTY" ).append("\n"); 
		query.append("                       ,0 F5_QTY    		" ).append("\n"); 
		query.append("    		FROM LV_DUMMY_WEEK" ).append("\n"); 
		query.append("    		WHERE WK_SEQ > 1" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("    ORDER BY DP_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}