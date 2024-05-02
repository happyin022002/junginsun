/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchOftChnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.04.19 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchOftChnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchOftChnRSQL
	  * 2011.03.16 이일민 [SRM-201114344] C/A 면제 로직 변경
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchOftChnRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchOftChnRSQL").append("\n"); 
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
		query.append("SELECT NVL(DECODE(COUNT(*), 0, 'N', 'Y'), 'N') CHN_FLG " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT K1.RT_SEQ        K1_RT_SEQ," ).append("\n"); 
		query.append("           K1.FRT_TERM_CD   K1_FRT_TERM_CD," ).append("\n"); 
		query.append("           K1.CGO_CATE_CD   K1_CGO_CATE_CD," ).append("\n"); 
		query.append("           K1.CHG_CD        K1_CHG_CD,   " ).append("\n"); 
		query.append("           K1.CURR_CD       K1_CURR_CD," ).append("\n"); 
		query.append("           K1.RAT_UT_CD     K1_RAT_UT_CD," ).append("\n"); 
		query.append("           K1.RAT_AS_QTY    K1_RAT_AS_QTY," ).append("\n"); 
		query.append("           K1.CHG_UT_AMT    K1_CHG_UT_AMT," ).append("\n"); 
		query.append("           K1.TRF_ITM_NO    K1_TRF_ITM_NO, " ).append("\n"); 
		query.append("           K1.CHG_AMT       K1_CHG_AMT, " ).append("\n"); 
		query.append("           K1.RCV_TERM_CD   K1_RCV_TERM_CD, " ).append("\n"); 
		query.append("           K1.DE_TERM_CD    K1_DE_TERM_CD, " ).append("\n"); 
		query.append("           K1.N3PTY_RCV_OFC_CD      K1_N3PTY_RCV_OFC_CD, " ).append("\n"); 
		query.append("           K1.N3PTY_CUST_CNT_CD     K1_N3PTY_CUST_CNT_CD, " ).append("\n"); 
		query.append("           K1.N3PTY_CUST_SEQ        K1_N3PTY_CUST_SEQ, " ).append("\n"); 
		query.append("           K1.FRT_INCL_XCLD_DIV_CD  K1_FRT_INCL_XCLD_DIV_CD, " ).append("\n"); 
		query.append("           K1.PRN_HDN_FLG           K1_PRN_HDN_FLG," ).append("\n"); 
		query.append("           K2.RT_SEQ        K2_RT_SEQ," ).append("\n"); 
		query.append("           K2.FRT_TERM_CD   K2_FRT_TERM_CD," ).append("\n"); 
		query.append("           K2.CGO_CATE_CD   K2_CGO_CATE_CD," ).append("\n"); 
		query.append("           K2.CHG_CD        K2_CHG_CD," ).append("\n"); 
		query.append("           K2.CURR_CD       K2_CURR_CD," ).append("\n"); 
		query.append("           K2.RAT_UT_CD     K2_RAT_UT_CD," ).append("\n"); 
		query.append("           K2.RAT_AS_QTY    K2_RAT_AS_QTY," ).append("\n"); 
		query.append("           K2.CHG_UT_AMT    K2_CHG_UT_AMT," ).append("\n"); 
		query.append("           K2.TRF_ITM_NO    K2_TRF_ITM_NO, " ).append("\n"); 
		query.append("           K2.CHG_AMT       K2_CHG_AMT, " ).append("\n"); 
		query.append("           K2.RCV_TERM_CD   K2_RCV_TERM_CD, " ).append("\n"); 
		query.append("           K2.DE_TERM_CD    K2_DE_TERM_CD, " ).append("\n"); 
		query.append("           K2.N3PTY_RCV_OFC_CD      K2_N3PTY_RCV_OFC_CD, " ).append("\n"); 
		query.append("           K2.N3PTY_CUST_CNT_CD     K2_N3PTY_CUST_CNT_CD, " ).append("\n"); 
		query.append("           K2.N3PTY_CUST_SEQ        K2_N3PTY_CUST_SEQ, " ).append("\n"); 
		query.append("           K2.FRT_INCL_XCLD_DIV_CD  K2_FRT_INCL_XCLD_DIV_CD, " ).append("\n"); 
		query.append("           K2.PRN_HDN_FLG           K2_PRN_HDN_FLG" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT RT_SEQ, FRT_TERM_CD, CGO_CATE_CD, CHG_CD, CURR_CD, RAT_UT_CD, RAT_AS_QTY, CHG_UT_AMT," ).append("\n"); 
		query.append("                   TRF_ITM_NO, CHG_AMT, RCV_TERM_CD, DE_TERM_CD, N3PTY_RCV_OFC_CD, N3PTY_CUST_CNT_CD, N3PTY_CUST_SEQ, FRT_INCL_XCLD_DIV_CD, PRN_HDN_FLG" ).append("\n"); 
		query.append("              FROM BKG_CHG_RT HIS" ).append("\n"); 
		query.append("             WHERE HIS.BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("               AND HIS.CHG_CD          = 'OFT'" ).append("\n"); 
		query.append("            ) K1 FULL OUTER JOIN (" ).append("\n"); 
		query.append("            SELECT RT_SEQ, FRT_TERM_CD, CGO_CATE_CD, CHG_CD, CURR_CD, RAT_UT_CD, RAT_AS_QTY, CHG_UT_AMT," ).append("\n"); 
		query.append("                   TRF_ITM_NO, CHG_AMT, RCV_TERM_CD, DE_TERM_CD, N3PTY_RCV_OFC_CD, N3PTY_CUST_CNT_CD, N3PTY_CUST_SEQ, FRT_INCL_XCLD_DIV_CD, PRN_HDN_FLG" ).append("\n"); 
		query.append("              FROM BKG_CHG_RT_HIS HIS" ).append("\n"); 
		query.append("             WHERE HIS.BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("               AND HIS.CORR_NO         = 'TMP0000001'" ).append("\n"); 
		query.append("               AND HIS.CHG_CD          = 'OFT'" ).append("\n"); 
		query.append("            ) K2" ).append("\n"); 
		query.append("      ON K1.RT_SEQ = K2.RT_SEQ )" ).append("\n"); 
		query.append("WHERE (   NVL(K1_RT_SEQ, 0) != NVL(K2_RT_SEQ,0 )" ).append("\n"); 
		query.append("       OR NVL(K1_CGO_CATE_CD, ' ') != NVL(K2_CGO_CATE_CD, ' ')" ).append("\n"); 
		query.append("       OR NVL(K1_CHG_CD, ' ') != NVL(K2_CHG_CD, ' ')" ).append("\n"); 
		query.append("       OR NVL(K1_CURR_CD, ' ') != NVL(K2_CURR_CD, ' ')" ).append("\n"); 
		query.append("       OR NVL(K1_RAT_UT_CD, ' ') != NVL(K2_RAT_UT_CD, ' ')" ).append("\n"); 
		query.append("       OR NVL(K1_RAT_AS_QTY, 0) != NVL(K2_RAT_AS_QTY, 0)" ).append("\n"); 
		query.append("       OR NVL(K1_CHG_UT_AMT, 0) != NVL(K2_CHG_UT_AMT, 0)" ).append("\n"); 
		query.append("       OR NVL(K1_TRF_ITM_NO, ' ') != NVL(K2_TRF_ITM_NO, ' ')" ).append("\n"); 
		query.append("       OR NVL(K1_CHG_AMT, 0) != NVL(K2_CHG_AMT, 0)" ).append("\n"); 
		query.append("       OR NVL(K1_RCV_TERM_CD, ' ') != NVL(K2_RCV_TERM_CD, ' ')" ).append("\n"); 
		query.append("       OR NVL(K1_DE_TERM_CD, ' ') != NVL(K2_DE_TERM_CD, ' ')" ).append("\n"); 
		query.append("       OR NVL(K1_FRT_INCL_XCLD_DIV_CD, ' ') != NVL(K1_FRT_INCL_XCLD_DIV_CD, ' '))" ).append("\n"); 
		query.append("  AND NOT EXISTS (SELECT BKG_NO" ).append("\n"); 
		query.append("                    FROM BKG_CHG_RT_HIS" ).append("\n"); 
		query.append("                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                     AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                     AND CHG_CD = 'DIV'" ).append("\n"); 
		query.append("                   MINUS" ).append("\n"); 
		query.append("				  SELECT BKG_NO" ).append("\n"); 
		query.append("                    FROM BKG_CHG_RT" ).append("\n"); 
		query.append("                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                     AND CHG_CD = 'DIV'" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("  AND NOT EXISTS (SELECT BKG_NO" ).append("\n"); 
		query.append("                    FROM BKG_CHG_RT_HIS" ).append("\n"); 
		query.append("                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                     AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                     AND CHG_CD = 'DVC'" ).append("\n"); 
		query.append("                   MINUS" ).append("\n"); 
		query.append("				  SELECT BKG_NO" ).append("\n"); 
		query.append("                    FROM BKG_CHG_RT" ).append("\n"); 
		query.append("                   WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                     AND CHG_CD = 'DVC'" ).append("\n"); 
		query.append("                   )" ).append("\n"); 

	}
}