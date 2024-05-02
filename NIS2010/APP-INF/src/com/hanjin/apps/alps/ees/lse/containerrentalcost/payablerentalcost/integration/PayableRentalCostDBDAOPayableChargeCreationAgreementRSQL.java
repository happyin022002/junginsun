/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PayableRentalCostDBDAOPayableChargeCreationAgreementRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOPayableChargeCreationAgreementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payable Rental Creation Master Data Search
	  * </pre>
	  */
	public PayableRentalCostDBDAOPayableChargeCreationAgreementRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOPayableChargeCreationAgreementRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN AA.CHG_SEQ IS NULL THEN 'N'                                               /* No Charge Creation */" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 CASE WHEN AA.LSE_PAY_RNTL_STS_CD IN ('A','I') THEN AA.LSE_PAY_RNTL_STS_CD /* Charge Invoice Create */" ).append("\n"); 
		query.append("                      WHEN AA.INV_NO  IS NOT NULL AND AA.IF_RGST_NO IS NULL THEN 'C'       /* Charge Creation And Lessor Imvoice Import */" ).append("\n"); 
		query.append("                      WHEN AA.INV_NO  IS NULL THEN 'H'                                     /* Only Hanjin Charge Creation */" ).append("\n"); 
		query.append("                      ELSE 'N'" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("       END AS CHG_STS_CD" ).append("\n"); 
		query.append("     , AA.AGMT_CTY_CD || LPAD(AA.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("     , AA.AGMT_LST_VER_SEQ" ).append("\n"); 
		query.append("     , AA.LSTM_CD" ).append("\n"); 
		query.append("     , AA.LSE_CTRT_NO" ).append("\n"); 
		query.append("     , AA.REF_NO" ).append("\n"); 
		query.append("     , TO_CHAR(AA.EFF_DT, 'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(AA.EXP_DT, 'YYYYMMDD') AS EXP_DT" ).append("\n"); 
		query.append("     , CASE WHEN AA.CHG_SEQ IS NULL THEN AA.LSSR_INV_NO ELSE AA.INV_NO END INV_NO" ).append("\n"); 
		query.append("     , AA.TTL_COST_AMT AS HJS_TTL_CHG_AMT" ).append("\n"); 
		query.append("     --, CASE WHEN AA.LSE_PAY_RNTL_STS_CD IN ('A','I') THEN NVL(AA.LR_COST_AMT, 0) ELSE NVL(AA.LSSR_TTL_AMT, 0) END AS INV_TTL_CHG_AMT" ).append("\n"); 
		query.append("     , CASE WHEN AA.LSE_PAY_RNTL_STS_CD IS NOT NULL THEN NVL(AA.LR_COST_AMT, 0) ELSE NVL(AA.LSSR_TTL_AMT, 0) END AS INV_TTL_CHG_AMT" ).append("\n"); 
		query.append("     , AA.CR_TTL_AMT" ).append("\n"); 
		query.append("     , CASE WHEN AA.LSE_PAY_RNTL_STS_CD IN ('A','I') THEN NVL(AA.PAY_RNTL_COST_AMT, 0) ELSE NVL(AA.LSSR_TTL_AMT, 0) END AS PAY_RNTL_COST_AMT" ).append("\n"); 
		query.append("     , AA.CURR_CD" ).append("\n"); 
		query.append("     , CASE WHEN AA.INV_NO IS NULL THEN 'N' ELSE 'Y' END AS INV_FIL_FLG" ).append("\n"); 
		query.append("     , AA.CRE_DT" ).append("\n"); 
		query.append("     , AA.CRE_USR_ID" ).append("\n"); 
		query.append("     , AA.IF_RGST_NO" ).append("\n"); 
		query.append("     , AA.AGMT_CTY_CD" ).append("\n"); 
		query.append("     , AA.AGMT_SEQ" ).append("\n"); 
		query.append("     , AA.CHG_SEQ" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.AGMT_CTY_CD" ).append("\n"); 
		query.append("             , A.AGMT_SEQ" ).append("\n"); 
		query.append("             , A.CHG_COST_YRMON" ).append("\n"); 
		query.append("             , A.AGMT_LST_VER_SEQ" ).append("\n"); 
		query.append("             , A.LSTM_CD" ).append("\n"); 
		query.append("             , A.VNDR_SEQ" ).append("\n"); 
		query.append("             , A.REF_NO" ).append("\n"); 
		query.append("             , A.LSE_CTRT_NO" ).append("\n"); 
		query.append("             , A.EFF_DT" ).append("\n"); 
		query.append("             , A.EXP_DT" ).append("\n"); 
		query.append("             , A.CURR_CD" ).append("\n"); 
		query.append("             , B.CHG_SEQ" ).append("\n"); 
		query.append("             , B.TTL_COST_AMT" ).append("\n"); 
		query.append("             , B.CR_TTL_AMT" ).append("\n"); 
		query.append("             , B.LR_COST_AMT" ).append("\n"); 
		query.append("             , B.PAY_RNTL_COST_AMT" ).append("\n"); 
		query.append("             , B.INV_NO" ).append("\n"); 
		query.append("             , B.IF_RGST_NO" ).append("\n"); 
		query.append("             , B.LSE_PAY_RNTL_STS_CD" ).append("\n"); 
		query.append("             , TO_CHAR(B.CRE_DT, 'YYYYMMDD') AS CRE_DT" ).append("\n"); 
		query.append("             , B.CRE_USR_ID" ).append("\n"); 
		query.append("             , C.INV_NO AS LSSR_INV_NO" ).append("\n"); 
		query.append("             , SUM(C.TTL_COST_AMT) AS LSSR_TTL_AMT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                 SELECT B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                      , B.AGMT_SEQ" ).append("\n"); 
		query.append("                      , P.COST_YRMON AS CHG_COST_YRMON" ).append("\n"); 
		query.append("                      , B.AGMT_LST_VER_SEQ" ).append("\n"); 
		query.append("                      , B.LSTM_CD" ).append("\n"); 
		query.append("                      , B.VNDR_SEQ" ).append("\n"); 
		query.append("                      , B.REF_NO" ).append("\n"); 
		query.append("                      , B.LSE_CTRT_NO" ).append("\n"); 
		query.append("                      , B.LST_EFF_DT AS EFF_DT" ).append("\n"); 
		query.append("                      , B.LST_EXP_DT AS EXP_DT" ).append("\n"); 
		query.append("                      , B.CURR_CD" ).append("\n"); 
		query.append("                   FROM LSE_AGREEMENT B" ).append("\n"); 
		query.append("                      , ( SELECT @[cost_yrmon] AS COST_YRMON, @[vndr_seq] AS VNDR_SEQ, @[lstm_cd] AS LSTM_CD FROM DUAL ) P" ).append("\n"); 
		query.append("                  WHERE B.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("#if ( ${lstm_cd} != '' )" ).append("\n"); 
		query.append("                    AND B.LSTM_CD        = P.LSTM_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                    AND B.LSTM_CD IN ('LT','ST','OF','MI','SI','SO')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    AND B.VNDR_SEQ = P.VNDR_SEQ" ).append("\n"); 
		query.append("                    AND EXISTS ( SELECT 'X' " ).append("\n"); 
		query.append("                                   FROM MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("                                      , MST_CNTR_STS_HIS E" ).append("\n"); 
		query.append("                                 WHERE A.AGMT_CTY_CD = B.AGMT_CTY_CD " ).append("\n"); 
		query.append("                                   AND A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("                                   AND A.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("                                   AND A.CNTR_STS_CD IN ('LSI','DII')" ).append("\n"); 
		query.append("                                   AND A.CNTR_STS_EVNT_DT <= LAST_DAY(TO_DATE(P.COST_YRMON, 'RRRRMM'))+0.9999" ).append("\n"); 
		query.append("                                   AND A.CNTR_NO      = E.CNTR_NO(+)" ).append("\n"); 
		query.append("                                   AND A.CNTR_STS_SEQ = E.PRNR_STS_SEQ(+)" ).append("\n"); 
		query.append("                                   AND CASE WHEN TO_CHAR(A.CNTR_STS_EVNT_DT, 'YYYYMM') = P.COST_YRMON THEN TO_DATE(P.COST_YRMON,'RRRRMM') +1" ).append("\n"); 
		query.append("                                              ELSE NVL(E.CNTR_STS_EVNT_DT, SYSDATE)" ).append("\n"); 
		query.append("                                         END >= TO_DATE(P.COST_YRMON,'RRRRMM')  " ).append("\n"); 
		query.append("                                   AND ROWNUM >= 1 )" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("             )                   A" ).append("\n"); 
		query.append("           , LSE_PAY_RNTL_CHG    B" ).append("\n"); 
		query.append("           , LSE_PAY_RNTL_CHG_CO C" ).append("\n"); 
		query.append("        WHERE A.AGMT_CTY_CD    = B.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("          AND A.AGMT_SEQ       = B.AGMT_SEQ(+)" ).append("\n"); 
		query.append("          AND A.CHG_COST_YRMON = B.CHG_COST_YRMON(+)" ).append("\n"); 
		query.append("          AND A.AGMT_CTY_CD    = C.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("          AND A.AGMT_SEQ       = C.AGMT_SEQ(+)" ).append("\n"); 
		query.append("          AND A.CHG_COST_YRMON = C.CO_COST_YRMON(+)" ).append("\n"); 
		query.append("        GROUP BY A.AGMT_CTY_CD" ).append("\n"); 
		query.append("               , A.AGMT_SEQ" ).append("\n"); 
		query.append("               , A.CHG_COST_YRMON" ).append("\n"); 
		query.append("               , A.AGMT_LST_VER_SEQ" ).append("\n"); 
		query.append("               , A.LSTM_CD" ).append("\n"); 
		query.append("               , A.VNDR_SEQ" ).append("\n"); 
		query.append("               , A.REF_NO" ).append("\n"); 
		query.append("               , A.LSE_CTRT_NO" ).append("\n"); 
		query.append("               , A.EFF_DT" ).append("\n"); 
		query.append("               , A.EXP_DT" ).append("\n"); 
		query.append("               , A.CURR_CD" ).append("\n"); 
		query.append("               , B.CHG_SEQ" ).append("\n"); 
		query.append("               , B.TTL_COST_AMT" ).append("\n"); 
		query.append("               , B.CR_TTL_AMT" ).append("\n"); 
		query.append("               , B.LR_COST_AMT" ).append("\n"); 
		query.append("               , B.PAY_RNTL_COST_AMT" ).append("\n"); 
		query.append("               , B.INV_NO" ).append("\n"); 
		query.append("               , B.IF_RGST_NO" ).append("\n"); 
		query.append("               , B.LSE_PAY_RNTL_STS_CD" ).append("\n"); 
		query.append("               , TO_CHAR(B.CRE_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("               , B.CRE_USR_ID" ).append("\n"); 
		query.append("               , C.INV_NO" ).append("\n"); 
		query.append("       ) AA" ).append("\n"); 
		query.append(" ORDER BY AGMT_NO" ).append("\n"); 

	}
}