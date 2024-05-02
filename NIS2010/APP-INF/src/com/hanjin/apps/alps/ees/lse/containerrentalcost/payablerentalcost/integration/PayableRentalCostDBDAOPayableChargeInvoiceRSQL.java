/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PayableRentalCostDBDAOPayableChargeInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.15
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.07.15 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOPayableChargeInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payable Charge Creation : Audit가 완료된 Data들을 Invoice Creation 하기 위한 조회
	  * </pre>
	  */
	public PayableRentalCostDBDAOPayableChargeInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOPayableChargeInvoiceRSQL").append("\n"); 
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
		query.append("SELECT A.*" ).append("\n"); 
		query.append("     , B.LGS_COST_FULL_NM AS COST_NM" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("         SELECT A.CHG_SEQ" ).append("\n"); 
		query.append("              , C.INV_NO" ).append("\n"); 
		query.append("              , 'CNTC' || SUBSTR(C.CHG_COST_YRMON, 3, 4) || 'MM' AS VVD" ).append("\n"); 
		query.append("              , A.AGMT_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("              , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("              , A.AGMT_SEQ" ).append("\n"); 
		query.append("              , A.LSTM_CD" ).append("\n"); 
		query.append("              , A.LSE_CTRT_NO" ).append("\n"); 
		query.append("              , A.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("              , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , A.TTL_COST_AMT" ).append("\n"); 
		query.append("              , A.CR_AMT" ).append("\n"); 
		query.append("              , NVL(A.ACCT_CD, B.ACCT_CD) AS ACCT_CD" ).append("\n"); 
		query.append("              , NVL(A.COST_CD, B.COST_CD) AS COST_CD" ).append("\n"); 
		query.append("              , D.RPT_DP_SEQ" ).append("\n"); 
		query.append("         FROM   ( SELECT A.CHG_SEQ" ).append("\n"); 
		query.append("                       , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                       , A.AGMT_SEQ" ).append("\n"); 
		query.append("                       , A.LSTM_CD" ).append("\n"); 
		query.append("                       , A.LSE_CTRT_NO" ).append("\n"); 
		query.append("                       , A.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                       , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                       , A.TTL_COST_AMT" ).append("\n"); 
		query.append("                       , A.CR_AMT" ).append("\n"); 
		query.append("                       , B.ACCT_CD" ).append("\n"); 
		query.append("                       , B.COST_CD" ).append("\n"); 
		query.append("                  FROM   ( SELECT A.CHG_SEQ" ).append("\n"); 
		query.append("                                , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                , A.AGMT_SEQ" ).append("\n"); 
		query.append("                                , B.LSTM_CD" ).append("\n"); 
		query.append("                                , B.LSE_CTRT_NO" ).append("\n"); 
		query.append("                                , A.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                                , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                , SUM(A.DSCR_COST_AMT) AS TTL_COST_AMT" ).append("\n"); 
		query.append("                                , SUM(A.CR_AMT)       AS CR_AMT" ).append("\n"); 
		query.append("                           FROM   LSE_PAY_RNTL_CHG_DTL   A" ).append("\n"); 
		query.append("                                , LSE_AGREEMENT          B" ).append("\n"); 
		query.append("                           WHERE  A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                           AND    A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("                           AND    A.CNTR_AUD_STS_CD = 'A'" ).append("\n"); 
		query.append("                           AND    A.CHG_SEQ IN (" ).append("\n"); 
		query.append("#foreach($key IN ${chg_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $chg_seq.size())" ).append("\n"); 
		query.append("         $key," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         $key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                           GROUP  BY A.CHG_SEQ" ).append("\n"); 
		query.append("                                   , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                   , A.AGMT_SEQ" ).append("\n"); 
		query.append("                                   , B.LSTM_CD" ).append("\n"); 
		query.append("                                   , B.LSE_CTRT_NO" ).append("\n"); 
		query.append("                                   , A.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                                   , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                           ) A" ).append("\n"); 
		query.append("                         , (SELECT  LSE_RCV_CHG_TP_CD, ACCT_CD, LSTM_CD, COST_CD " ).append("\n"); 
		query.append("                            FROM    LSE_RNTL_COST_ACCT_ORD WHERE LSTM_CD = 'XX'" ).append("\n"); 
		query.append("                            UNION ALL" ).append("\n"); 
		query.append("                            SELECT  LSE_RCV_CHG_TP_CD, ACCT_CD, 'BX' , COST_CD" ).append("\n"); 
		query.append("                            FROM    LSE_RNTL_COST_ACCT_ORD WHERE LSTM_CD = 'XX'" ).append("\n"); 
		query.append("                            UNION ALL" ).append("\n"); 
		query.append("                            SELECT  LSE_RCV_CHG_TP_CD, ACCT_CD, LSTM_CD, COST_CD" ).append("\n"); 
		query.append("                            FROM   (SELECT  A.LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("                                            A.LSTM_CD AS ZZZ," ).append("\n"); 
		query.append("                                            A.ACCT_CD AS ACCT_CD," ).append("\n"); 
		query.append("                                            A.COST_CD," ).append("\n"); 
		query.append("                                            B.LSTM_CD AS LSTM_CD" ).append("\n"); 
		query.append("                                    FROM    LSE_RNTL_COST_ACCT_ORD A," ).append("\n"); 
		query.append("                                            MST_LSE_TERM B" ).append("\n"); 
		query.append("                                    WHERE   A.LSTM_CD IN('XX', B.LSTM_CD)" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                            WHERE  (LSE_RCV_CHG_TP_CD, ZZZ, LSTM_CD) NOT IN (SELECT A.LSE_RCV_CHG_TP_CD, 'XX', B.LSTM_CD" ).append("\n"); 
		query.append("                                                                             FROM   LSE_RNTL_COST_ACCT_ORD A," ).append("\n"); 
		query.append("                                                                                    MST_LSE_TERM B" ).append("\n"); 
		query.append("                                                                             WHERE  A.LSTM_CD = B.LSTM_CD)                                                                                                                                                                                          " ).append("\n"); 
		query.append("                            ) B   " ).append("\n"); 
		query.append("                  WHERE  A.LSTM_CD = B.LSTM_CD(+)" ).append("\n"); 
		query.append("                  AND    A.LSE_PAY_CHG_TP_CD = B.LSE_RCV_CHG_TP_CD(+)" ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("              , LSE_RNTL_COST_ACCT_ORD B" ).append("\n"); 
		query.append("              , LSE_PAY_RNTL_CHG C" ).append("\n"); 
		query.append("              , ( SELECT CNTR_TPSZ_CD, RPT_DP_SEQ FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("                  UNION" ).append("\n"); 
		query.append("                  SELECT 'BX', 990 AS RPT_DP_SEQ FROM DUAL" ).append("\n"); 
		query.append("                  UNION" ).append("\n"); 
		query.append("                  SELECT 'XX', 991 AS RPT_DP_SEQ FROM DUAL ) D" ).append("\n"); 
		query.append("         WHERE  NVL2(A.ACCT_CD, A.LSE_PAY_CHG_TP_CD, 'XXX')= B.LSE_RCV_CHG_TP_CD(+)" ).append("\n"); 
		query.append("		 AND    CASE WHEN A.ACCT_CD IS NULL AND A.LSTM_CD IN('ST','LT') " ).append("\n"); 
		query.append("                     THEN A.LSTM_CD ELSE 'XX' END = B.LSTM_CD(+)" ).append("\n"); 
		query.append("         AND    C.CHG_SEQ = A.CHG_SEQ" ).append("\n"); 
		query.append("         AND    D.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("     , TES_LGS_COST B" ).append("\n"); 
		query.append("WHERE  A.COST_CD = B.LGS_COST_CD(+)" ).append("\n"); 
		query.append("ORDER  BY A.INV_NO" ).append("\n"); 
		query.append("        , A.AGMT_NO" ).append("\n"); 
		query.append("        , A.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("        , A.RPT_DP_SEQ" ).append("\n"); 

	}
}