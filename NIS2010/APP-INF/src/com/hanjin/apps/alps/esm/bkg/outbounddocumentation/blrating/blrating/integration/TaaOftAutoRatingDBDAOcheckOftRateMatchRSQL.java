/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TaaOftAutoRatingDBDAOcheckOftRateMatchRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2014.12.17 김진주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TaaOftAutoRatingDBDAOcheckOftRateMatchRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Taa OFT계산결과를 체크한다.
	  *  - Autorating 결과 나오는 CNTR Volume과 Qty Detail상의 Volume이 일치하면 Success
	  *  - Autorating 결과 Rating Unit이 BL인 경우 무조건 Success
	  *  - Co-Biz BL인 경우 무조건 Success
	  * </pre>
	  */
	public TaaOftAutoRatingDBDAOcheckOftRateMatchRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : TaaOftAutoRatingDBDAOcheckOftRateMatchRSQL").append("\n"); 
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
		query.append("SELECT R.OFT_CMB_SEQ" ).append("\n"); 
		query.append("FROM (SELECT DISTINCT T.BKG_NO, T.OFT_CMB_SEQ, U.CNTR_SZ_CD, " ).append("\n"); 
		query.append("             SUM(T.RAT_AS_QTY) OVER (PARTITION BY T.OFT_CMB_SEQ, U.CNTR_SZ_CD ) QTY," ).append("\n"); 
		query.append("             SUM(T.RAT_AS_QTY) OVER (PARTITION BY T.OFT_CMB_SEQ) TTL_QTY" ).append("\n"); 
		query.append("        FROM BKG_AUTO_RT_OCN_FRT_TMP T, PRI_RAT_UT U" ).append("\n"); 
		query.append("       WHERE T.RAT_UT_CD = U.RAT_UT_CD" ).append("\n"); 
		query.append("       AND T.CHG_CD = 'OFT'" ).append("\n"); 
		query.append("       AND T.CNTR_TPSZ_CD  NOT LIKE 'Q%') R," ).append("\n"); 
		query.append("     (SELECT DISTINCT Q.BKG_NO, U.CNTR_SZ_CD, " ).append("\n"); 
		query.append("             SUM(Q.OP_CNTR_QTY) OVER (PARTITION BY U.CNTR_SZ_CD) QTY," ).append("\n"); 
		query.append("             SUM(Q.OP_CNTR_QTY) OVER (PARTITION BY Q.BKG_NO) TTL_QTY" ).append("\n"); 
		query.append("        FROM (SELECT BKG_NO, " ).append("\n"); 
		query.append("                     CASE WHEN CNTR_TPSZ_CD LIKE 'R%' AND DRY_CGO_FLG = 'Y' -- RD 인 경우만 예외처리  " ).append("\n"); 
		query.append("                                  THEN CNTR_TPSZ_CD  " ).append("\n"); 
		query.append("                          ELSE NVL(EQ_SUBST_CNTR_TPSZ_CD, CNTR_TPSZ_CD)  " ).append("\n"); 
		query.append("                     END CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                     OP_CNTR_QTY" ).append("\n"); 
		query.append("              FROM BKG_QTY_DTL" ).append("\n"); 
		query.append("              WHERE BKG_NO = @[bkg_no]) Q, " ).append("\n"); 
		query.append("              PRI_RAT_UT U" ).append("\n"); 
		query.append("       WHERE Q.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         AND Q.CNTR_TPSZ_CD = U.RAT_UT_CD" ).append("\n"); 
		query.append("         AND Q.CNTR_TPSZ_CD  NOT LIKE 'Q%'" ).append("\n"); 
		query.append("         AND @[ca_flg] = 'N'" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       UNION ALL " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       SELECT DISTINCT Q.BKG_NO, U.CNTR_SZ_CD, " ).append("\n"); 
		query.append("             SUM(Q.OP_CNTR_QTY) OVER (PARTITION BY U.CNTR_SZ_CD) QTY," ).append("\n"); 
		query.append("             SUM(Q.OP_CNTR_QTY) OVER (PARTITION BY Q.BKG_NO) TTL_QTY" ).append("\n"); 
		query.append("        FROM (SELECT BKG_NO, " ).append("\n"); 
		query.append("                     CASE WHEN CNTR_TPSZ_CD LIKE 'R%' AND DRY_CGO_FLG = 'Y' -- RD 인 경우만 예외처리  " ).append("\n"); 
		query.append("                                  THEN CNTR_TPSZ_CD  " ).append("\n"); 
		query.append("                          ELSE NVL(EQ_SUBST_CNTR_TPSZ_CD, CNTR_TPSZ_CD)  " ).append("\n"); 
		query.append("                     END CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                     OP_CNTR_QTY" ).append("\n"); 
		query.append("              FROM BKG_QTY_DTL_HIS" ).append("\n"); 
		query.append("              WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND CORR_NO = 'TMP0000001') Q, " ).append("\n"); 
		query.append("              PRI_RAT_UT U" ).append("\n"); 
		query.append("       WHERE Q.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         AND Q.CNTR_TPSZ_CD = U.RAT_UT_CD" ).append("\n"); 
		query.append("         AND Q.CNTR_TPSZ_CD  NOT LIKE 'Q%'" ).append("\n"); 
		query.append("         AND @[ca_flg] = 'Y'" ).append("\n"); 
		query.append("         ) Q" ).append("\n"); 
		query.append("WHERE R.CNTR_SZ_CD = Q.CNTR_SZ_CD" ).append("\n"); 
		query.append("AND R.QTY = Q.QTY" ).append("\n"); 
		query.append("AND R.TTL_QTY = Q.TTL_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT OFT_CMB_SEQ" ).append("\n"); 
		query.append("FROM BKG_AUTO_RT_OCN_FRT_TMP" ).append("\n"); 
		query.append("WHERE RAT_UT_CD = 'BL'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 1" ).append("\n"); 
		query.append("FROM BKG_RATE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND RT_BL_TP_CD = 'B'" ).append("\n"); 

	}
}