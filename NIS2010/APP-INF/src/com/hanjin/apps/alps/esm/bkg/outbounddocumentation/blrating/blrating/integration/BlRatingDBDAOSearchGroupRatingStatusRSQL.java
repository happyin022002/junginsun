/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOSearchGroupRatingStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchGroupRatingStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회한 운임으로 Group Rating 가능한 상태인지 확인
	  * </pre>
	  */
	public BlRatingDBDAOSearchGroupRatingStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchGroupRatingStatusRSQL").append("\n"); 
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
		query.append("SELECT CNTR_TPSZ_CD, RATE_CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT Q.CNTR_TPSZ_CD, Q.RCV_TERM_CD, Q.DE_TERM_CD, " ).append("\n"); 
		query.append("               Q.DRY_CGO_FLG, Q.AWK_CGO_FLG,  Q.DCGO_FLG, Q.RC_FLG," ).append("\n"); 
		query.append("               Q.BB_CGO_FLG, Q.SOC_FLG, COUNT(Q.CNTR_TPSZ_CD) RATE_CNT" ).append("\n"); 
		query.append("        FROM ( SELECT  T.BKG_NO, T.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                       T.RCV_TERM_CD, T.DE_TERM_CD, " ).append("\n"); 
		query.append("                       T.DRY_CGO_FLG, T.AWK_CGO_FLG, " ).append("\n"); 
		query.append("                       T.DCGO_FLG, T.RC_FLG," ).append("\n"); 
		query.append("                       T.BB_CGO_FLG, T.SOC_FLG" ).append("\n"); 
		query.append("               FROM BKG_AUTO_RT_OCN_FRT_TMP T, PRI_RAT_UT U" ).append("\n"); 
		query.append("               WHERE T.RAT_UT_CD = U.RAT_UT_CD" ).append("\n"); 
		query.append("                 AND T.CHG_CD = 'OFT') R," ).append("\n"); 
		query.append("             ( SELECT BKG_NO, " ).append("\n"); 
		query.append("                      CASE WHEN CNTR_TPSZ_CD LIKE 'R%' AND DRY_CGO_FLG = 'Y' -- RD 인 경우만 예외처리  " ).append("\n"); 
		query.append("                               THEN CNTR_TPSZ_CD  " ).append("\n"); 
		query.append("                           ELSE NVL(EQ_SUBST_CNTR_TPSZ_CD, CNTR_TPSZ_CD)  " ).append("\n"); 
		query.append("                           END CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                             RCV_TERM_CD, DE_TERM_CD, " ).append("\n"); 
		query.append("                      DRY_CGO_FLG, AWK_CGO_FLG, " ).append("\n"); 
		query.append("                      DCGO_FLG, RC_FLG," ).append("\n"); 
		query.append("                      BB_CGO_FLG, SOC_FLG" ).append("\n"); 
		query.append("               FROM BKG_QTY_DTL" ).append("\n"); 
		query.append("              WHERE BKG_NO = @[bkg_no]) Q" ).append("\n"); 
		query.append("        WHERE Q.CNTR_TPSZ_CD = R.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          AND Q.RCV_TERM_CD = R.RCV_TERM_CD" ).append("\n"); 
		query.append("          AND Q.DE_TERM_CD = R.DE_TERM_CD" ).append("\n"); 
		query.append("          AND Q.DRY_CGO_FLG = R.DRY_CGO_FLG" ).append("\n"); 
		query.append("          AND Q.AWK_CGO_FLG = R.AWK_CGO_FLG" ).append("\n"); 
		query.append("          AND Q.DCGO_FLG = R.DCGO_FLG" ).append("\n"); 
		query.append("          AND Q.RC_FLG = R.RC_FLG" ).append("\n"); 
		query.append("          AND Q.BB_CGO_FLG = R.BB_CGO_FLG" ).append("\n"); 
		query.append("          AND Q.SOC_FLG = R.SOC_FLG" ).append("\n"); 
		query.append("        GROUP BY Q.CNTR_TPSZ_CD, Q.RCV_TERM_CD, Q.DE_TERM_CD, " ).append("\n"); 
		query.append("                 Q.DRY_CGO_FLG, Q.AWK_CGO_FLG, Q.DCGO_FLG, Q.RC_FLG," ).append("\n"); 
		query.append("                 Q.BB_CGO_FLG, Q.SOC_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT CNTR_TPSZ_CD, RCV_TERM_CD, DE_TERM_CD, " ).append("\n"); 
		query.append("               DRY_CGO_FLG, AWK_CGO_FLG, DCGO_FLG, RC_FLG," ).append("\n"); 
		query.append("               BB_CGO_FLG, SOC_FLG, COUNT(CNTR_TPSZ_CD) RATE_CNT" ).append("\n"); 
		query.append("          FROM BKG_AUTO_RT_OCN_FRT_TMP" ).append("\n"); 
		query.append("         WHERE RAT_UT_CD = 'BL'" ).append("\n"); 
		query.append("         GROUP BY CNTR_TPSZ_CD, RCV_TERM_CD, DE_TERM_CD, " ).append("\n"); 
		query.append("                  DRY_CGO_FLG, AWK_CGO_FLG, DCGO_FLG, RC_FLG," ).append("\n"); 
		query.append("                  BB_CGO_FLG, SOC_FLG" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("ORDER BY RATE_CNT DESC" ).append("\n"); 

	}
}