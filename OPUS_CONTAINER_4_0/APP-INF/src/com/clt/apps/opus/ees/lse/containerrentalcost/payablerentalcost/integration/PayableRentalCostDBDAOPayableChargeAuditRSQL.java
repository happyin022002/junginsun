/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PayableRentalCostDBDAOPayableChargeAuditRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.03.21 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOPayableChargeAuditRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payable Charge Audti 데이터 조회
	  * </pre>
	  */
	public PayableRentalCostDBDAOPayableChargeAuditRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOPayableChargeAuditRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       A.CHG_SEQ," ).append("\n"); 
		query.append("       A.CNTR_NO," ).append("\n"); 
		query.append("       A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       B.INV_NO," ).append("\n"); 
		query.append("       B.AGMT_CTY_CD || LPAD(B.AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("       C.LSE_CTRT_NO," ).append("\n"); 
		query.append("       A.LSE_PAY_CHG_TP_CD ," ).append("\n"); 
		query.append("       TO_CHAR(A.ONH_DT, 'YYYYMMDD') AS ONH_DT , " ).append("\n"); 
		query.append("       A.ONH_LOC_CD ," ).append("\n"); 
		query.append("       TO_CHAR(A.OFFH_DT, 'YYYYMMDD') AS OFFH_DT ," ).append("\n"); 
		query.append("       A.OFFH_LOC_CD ," ).append("\n"); 
		query.append("       A.COST_DYS ," ).append("\n"); 
		query.append("       A.CHG_FREE_DYS ," ).append("\n"); 
		query.append("       A.BIL_DYS ," ).append("\n"); 
		query.append("       A.PD_RT_AMT ," ).append("\n"); 
		query.append("       DECODE(D.CNTR_NO, NULL, DECODE(SIGN(A.TTL_COST_AMT), -1, 0, A.TTL_COST_AMT)" ).append("\n"); 
		query.append("                                , A.TTL_COST_AMT ) AS TTL_COST_AMT," ).append("\n"); 
		query.append("       DECODE(D.CNTR_NO, NULL, DECODE(NVL(A.CR_AMT, 0), 0, DECODE(SIGN(A.TTL_COST_AMT), -1, A.TTL_COST_AMT, 0), A.CR_AMT)" ).append("\n"); 
		query.append("                             , DECODE(A.CNTR_AUD_STS_CD, 'A', A.CR_AMT" ).append("\n"); 
		query.append("                                                            , DECODE(SIGN(D.TTL_COST_AMT), -1,  D.TTL_COST_AMT, 0))) AS CR_AMT," ).append("\n"); 
		query.append("       A.CR_NO ," ).append("\n"); 
		query.append("       DECODE(A.CNTR_AUD_STS_CD, 'A', TO_CHAR(A.DSCR_ONH_DT, 'YYYYMMDD'), TO_CHAR(D.ONH_DT, 'YYYYMMDD'))   AS DSCR_ONH_DT ," ).append("\n"); 
		query.append("       DECODE(A.CNTR_AUD_STS_CD, 'A', A.DSCR_ONH_LOC_CD, D.ONH_LOC_CD)                AS DSCR_ONH_LOC_CD," ).append("\n"); 
		query.append("       DECODE(A.CNTR_AUD_STS_CD, 'A', TO_CHAR(A.DSCR_OFFH_DT, 'YYYYMMDD'), TO_CHAR(D.OFFH_DT, 'YYYYMMDD')) AS DSCR_OFFH_DT ," ).append("\n"); 
		query.append("       DECODE(A.CNTR_AUD_STS_CD, 'A', A.DSCR_OFFH_LOC_CD, D.OFFH_LOC_CD)              AS DSCR_OFFH_LOC_CD," ).append("\n"); 
		query.append("       DECODE(A.CNTR_AUD_STS_CD, 'A', A.DSCR_RT_AMT, D.PD_RT_AMT)                     AS DSCR_RT_AMT," ).append("\n"); 
		query.append("       DECODE(A.CNTR_AUD_STS_CD, 'A', DECODE(SIGN(A.DSCR_COST_AMT), -1, 0, A.DSCR_COST_AMT)" ).append("\n"); 
		query.append("                                    , DECODE(SIGN(D.TTL_COST_AMT), -1, 0, D.TTL_COST_AMT)) AS DSCR_COST_AMT," ).append("\n"); 
		query.append("       A.AGMT_CTY_CD ," ).append("\n"); 
		query.append("       A.AGMT_SEQ ," ).append("\n"); 
		query.append("       A.DTL_SEQ ," ).append("\n"); 
		query.append("       B.CHG_COST_YRMON ," ).append("\n"); 
		query.append("       CASE WHEN A.CNTR_AUD_STS_CD = 'A' " ).append("\n"); 
		query.append("              THEN A.CNTR_AUD_STS_CD" ).append("\n"); 
		query.append("            WHEN D.CNTR_NO IS NULL" ).append("\n"); 
		query.append("              THEN 'H'" ).append("\n"); 
		query.append("            ELSE " ).append("\n"); 
		query.append("              CASE WHEN A.TTL_COST_AMT = D.TTL_COST_AMT" ).append("\n"); 
		query.append("                       AND A.PD_RT_AMT = DECODE(A.LSE_PAY_CHG_TP_CD, 'LON', A.PD_RT_AMT, 'LOF', A.PD_RT_AMT,D.PD_RT_AMT)" ).append("\n"); 
		query.append("                       AND A.ONH_DT = ( CASE WHEN TO_CHAR(A.ONH_DT+A.CHG_FREE_DYS, 'YYYYMM') = B.CHG_COST_YRMON " ).append("\n"); 
		query.append("                                             THEN D.ONH_DT" ).append("\n"); 
		query.append("                                             ELSE A.ONH_DT" ).append("\n"); 
		query.append("                                        END )" ).append("\n"); 
		query.append("                       AND NVL(A.OFFH_DT, TO_DATE('22001231', 'YYYYMMDD')) = NVL(D.OFFH_DT, TO_DATE('22001231', 'YYYYMMDD'))" ).append("\n"); 
		query.append("                   THEN 'C'" ).append("\n"); 
		query.append("                   ELSE 'D'" ).append("\n"); 
		query.append("              END " ).append("\n"); 
		query.append("       END AS CNTR_AUD_STS_CD," ).append("\n"); 
		query.append("--       A.PAY_CHG_STS_CD" ).append("\n"); 
		query.append("       CASE WHEN A.CNTR_AUD_STS_CD = 'A' " ).append("\n"); 
		query.append("              THEN A.PAY_CHG_STS_CD" ).append("\n"); 
		query.append("            WHEN D.CNTR_NO IS NULL" ).append("\n"); 
		query.append("              THEN 'H'" ).append("\n"); 
		query.append("            ELSE " ).append("\n"); 
		query.append("              CASE WHEN A.TTL_COST_AMT = D.TTL_COST_AMT" ).append("\n"); 
		query.append("                       AND A.PD_RT_AMT = DECODE(A.LSE_PAY_CHG_TP_CD, 'LON', A.PD_RT_AMT, 'LOF', A.PD_RT_AMT, D.PD_RT_AMT)" ).append("\n"); 
		query.append("                       AND A.ONH_DT = ( CASE WHEN TO_CHAR(A.ONH_DT+A.CHG_FREE_DYS, 'YYYYMM') = B.CHG_COST_YRMON " ).append("\n"); 
		query.append("                                             THEN D.ONH_DT" ).append("\n"); 
		query.append("                                             ELSE A.ONH_DT" ).append("\n"); 
		query.append("                                        END )" ).append("\n"); 
		query.append("                       AND NVL(A.OFFH_DT, TO_DATE('22001231', 'YYYYMMDD')) = NVL(D.OFFH_DT, TO_DATE('22001231', 'YYYYMMDD'))" ).append("\n"); 
		query.append("                   THEN 'C'" ).append("\n"); 
		query.append("                   ELSE 'D'" ).append("\n"); 
		query.append("              END " ).append("\n"); 
		query.append("       END AS PAY_CHG_STS_CD" ).append("\n"); 
		query.append("FROM   LSE_PAY_RNTL_CHG_CO D," ).append("\n"); 
		query.append("       LSE_AGREEMENT C," ).append("\n"); 
		query.append("       LSE_PAY_RNTL_CHG_DTL A ," ).append("\n"); 
		query.append("       LSE_PAY_RNTL_CHG B" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    D.LSE_PAY_CHG_TP_CD (+) = A.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("AND    D.CNTR_NO           (+) = A.CNTR_NO" ).append("\n"); 
		query.append("AND    D.AGMT_SEQ          (+) = A.AGMT_SEQ" ).append("\n"); 
		query.append("AND    D.AGMT_CTY_CD       (+) = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND    D.CO_COST_YRMON (+) = @[co_cost_yrmon]" ).append("\n"); 
		query.append("AND    A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND    A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND    A.CHG_SEQ     = B.CHG_SEQ" ).append("\n"); 
		query.append("AND    C.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND    C.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND    B.CHG_SEQ IN ( " ).append("\n"); 
		query.append("#foreach($key IN ${chg_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $chg_seq.size())" ).append("\n"); 
		query.append("         $key," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         $key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("AND    B.AGMT_SEQ IN (" ).append("\n"); 
		query.append("#foreach($key IN ${agmt_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $agmt_seq.size())" ).append("\n"); 
		query.append("         $key," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         $key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("AND    B.AGMT_CTY_CD = 'HHO'" ).append("\n"); 
		query.append("AND    B.CHG_COST_YRMON = @[co_cost_yrmon]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT /*+ USE_NL( A B C ) */" ).append("\n"); 
		query.append("       DISTINCT " ).append("\n"); 
		query.append("       NULL AS CHG_SEQ ," ).append("\n"); 
		query.append("       A.CNTR_NO ," ).append("\n"); 
		query.append("       NVL(C.CNTR_TPSZ_CD, 'XX') AS CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("       A.INV_NO ," ).append("\n"); 
		query.append("       A.AGMT_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO ," ).append("\n"); 
		query.append("       A.LSE_CTRT_NO ," ).append("\n"); 
		query.append("       A.LSE_PAY_CHG_TP_CD ," ).append("\n"); 
		query.append("       NULL AS ONH_DT ," ).append("\n"); 
		query.append("       NULL AS ONH_LOC_CD ," ).append("\n"); 
		query.append("       NULL AS OFFH_DT ," ).append("\n"); 
		query.append("       NULL AS OFFH_LOC_CD ," ).append("\n"); 
		query.append("       NULL AS COST_DYS ," ).append("\n"); 
		query.append("       NULL AS CHG_FREE_DYS ," ).append("\n"); 
		query.append("       NULL AS BIL_DYS ," ).append("\n"); 
		query.append("       NULL AS PD_RT_AMT ," ).append("\n"); 
		query.append("       NULL AS TTL_COST_AMT ," ).append("\n"); 
		query.append("       DECODE(SIGN(A.TTL_COST_AMT), -1, A.TTL_COST_AMT, 0) AS CR_AMT," ).append("\n"); 
		query.append("       NULL AS CR_NO ," ).append("\n"); 
		query.append("       TO_CHAR(A.ONH_DT,'YYYYMMDD') AS ONH_DT ," ).append("\n"); 
		query.append("       A.ONH_LOC_CD ," ).append("\n"); 
		query.append("       TO_CHAR(A.OFFH_DT,'YYYYMMDD') AS OFFH_DT ," ).append("\n"); 
		query.append("       A.OFFH_LOC_CD ," ).append("\n"); 
		query.append("       A.PD_RT_AMT ," ).append("\n"); 
		query.append("       DECODE(SIGN(A.TTL_COST_AMT), -1, 0, A.TTL_COST_AMT) AS TLL_COST_AMT," ).append("\n"); 
		query.append("       A.AGMT_CTY_CD ," ).append("\n"); 
		query.append("       A.AGMT_SEQ ," ).append("\n"); 
		query.append("       NULL AS DTL_SEQ ," ).append("\n"); 
		query.append("       A.CO_COST_YRMON AS CHG_COST_YRMON ," ).append("\n"); 
		query.append("       'L' AS CNTR_AUD_STS_CD ," ).append("\n"); 
		query.append("       'L' AS PAY_CHG_STS_CD" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT CO.AGMT_CTY_CD" ).append("\n"); 
		query.append("             , CO.AGMT_SEQ" ).append("\n"); 
		query.append("             , CO.CNTR_NO" ).append("\n"); 
		query.append("             , CO.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("        FROM   LSE_PAY_RNTL_CHG_CO CO" ).append("\n"); 
		query.append("        WHERE  CO_COST_YRMON = @[co_cost_yrmon]" ).append("\n"); 
		query.append("        AND    AGMT_SEQ IN (" ).append("\n"); 
		query.append("#foreach($key IN ${agmt_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $agmt_seq.size())" ).append("\n"); 
		query.append("         $key," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         $key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("        AND    AGMT_CTY_CD = 'HHO'" ).append("\n"); 
		query.append("        AND NOT EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                           FROM LSE_PAY_RNTL_CHG_DTL CHG" ).append("\n"); 
		query.append("                          WHERE CO.AGMT_CTY_CD = CHG.AGMT_CTY_CD" ).append("\n"); 
		query.append("                            AND CO.AGMT_SEQ    = CHG.AGMT_SEQ" ).append("\n"); 
		query.append("                            AND CO.CNTR_NO     = CHG.CNTR_NO" ).append("\n"); 
		query.append("                            AND CO.LSE_PAY_CHG_TP_CD = CHG.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                            AND CHG.CHG_SEQ  IN ( " ).append("\n"); 
		query.append("#foreach($key IN ${chg_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $chg_seq.size())" ).append("\n"); 
		query.append("         $key," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         $key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        ))" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("     , LSE_PAY_RNTL_CHG_CO A" ).append("\n"); 
		query.append("     , MST_CONTAINER       C" ).append("\n"); 
		query.append("WHERE  A.CNTR_NO = C.CNTR_NO(+)" ).append("\n"); 
		query.append("AND    A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND    A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND    CO_COST_YRMON = @[co_cost_yrmon]" ).append("\n"); 
		query.append("AND    A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND    A.LSE_PAY_CHG_TP_CD = B.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("AND    NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                     FROM LSE_PAY_RNTL_CHG_DTL SD" ).append("\n"); 
		query.append("                        , LSE_PAY_RNTL_CHG SH" ).append("\n"); 
		query.append("                    WHERE SD.LSE_PAY_CHG_TP_CD  = A.LSE_PAY_CHG_TP_CD" ).append("\n"); 
		query.append("                      AND SD.CNTR_NO            = A.CNTR_NO" ).append("\n"); 
		query.append("                      AND SD.AGMT_SEQ           = A.AGMT_SEQ" ).append("\n"); 
		query.append("                      AND SD.AGMT_CTY_CD        = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                      AND SD.PAY_CHG_STS_CD     = 'L'" ).append("\n"); 
		query.append("                      AND SH.CHG_COST_YRMON     = A.CO_COST_YRMON" ).append("\n"); 
		query.append("                      AND SD.AGMT_SEQ           = SH.AGMT_SEQ" ).append("\n"); 
		query.append("                      AND SD.AGMT_CTY_CD        = SH.AGMT_CTY_CD" ).append("\n"); 
		query.append("                      AND SD.CHG_SEQ            = SH.CHG_SEQ" ).append("\n"); 
		query.append("                      AND SH.CHG_SEQ IN ( " ).append("\n"); 
		query.append("                        #foreach($key IN ${chg_seq})" ).append("\n"); 
		query.append("                        #if($velocityCount < $chg_seq.size())" ).append("\n"); 
		query.append("                                 $key," ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                                 $key" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                                        ) " ).append("\n"); 
		query.append("                      AND SH.AGMT_SEQ IN (" ).append("\n"); 
		query.append("                        #foreach($key IN ${agmt_seq})" ).append("\n"); 
		query.append("                        #if($velocityCount < $agmt_seq.size())" ).append("\n"); 
		query.append("                                 $key," ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                                 $key" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                      AND SH.AGMT_CTY_CD     = 'HHO'" ).append("\n"); 
		query.append("                      AND SH.CHG_COST_YRMON  = @[co_cost_yrmon]" ).append("\n"); 
		query.append("                   )" ).append("\n"); 

	}
}