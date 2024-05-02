/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOReceivableRentalChargeDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.12
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.12.12 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOReceivableRentalChargeDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 계약번호별 Receivable Rental Charge Detail Creation 작업 대상목록을 조회한다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOReceivableRentalChargeDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_rntl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOReceivableRentalChargeDetailListRSQL").append("\n"); 
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
		query.append("WITH PARAM AS (" ).append("\n"); 
		query.append("    SELECT  @[agmt_cty_cd]      AS AGMT_CTY_CD," ).append("\n"); 
		query.append("            @[agmt_seq]         AS AGMT_SEQ," ).append("\n"); 
		query.append("            @[qty_yrmon]        AS QTY_YRMON," ).append("\n"); 
		query.append("            @[cost_yrmon]       AS COST_YRMON," ).append("\n"); 
		query.append("            TRUNC(LAST_DAY(TO_DATE(@[qty_yrmon], 'YYYYMM'))) AS BASE_DT," ).append("\n"); 
		query.append("            @[rcv_rntl_seq]     AS RCV_RNTL_SEQ," ).append("\n"); 
		query.append("            @[lstm_cd]          AS LSTM_CD" ).append("\n"); 
		query.append("    FROM    DUAL" ).append("\n"); 
		query.append("), TEMP_DROP02 AS (" ).append("\n"); 
		query.append("    SELECT  A.CNTR_TPSZ_CD, COUNT(A.CNTR_NO) AS CNTR_CNT" ).append("\n"); 
		query.append("    FROM    MST_CONTAINER A," ).append("\n"); 
		query.append("            MST_CNTR_STS_HIS B," ).append("\n"); 
		query.append("           (SELECT  /*+ INDEX(A XAK4MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                    A.CNTR_NO, A.CNTR_STS_SEQ, A.CNTR_STS_CD," ).append("\n"); 
		query.append("                    RANK() OVER(PARTITION BY A.CNTR_NO ORDER BY A.CNTR_STS_EVNT_DT DESC, A.CNTR_STS_SEQ DESC) AS RANK_NO" ).append("\n"); 
		query.append("            FROM    PARAM P," ).append("\n"); 
		query.append("                    MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("            WHERE   A.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("            AND     A.AGMT_SEQ     = P.AGMT_SEQ" ).append("\n"); 
		query.append("            AND     A.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("            AND    (A.CNTR_STS_CD IN ('MUO','SBO')" ).append("\n"); 
		query.append("            AND     A.CNTR_STS_EVNT_DT <= LAST_DAY(TO_DATE(P.QTY_YRMON,'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("            OR      A.CNTR_STS_CD IN ('MUI','SBI')" ).append("\n"); 
		query.append("            AND     A.CNTR_STS_EVNT_DT < TO_DATE(P.QTY_YRMON,'YYYYMM'))" ).append("\n"); 
		query.append("            ) C" ).append("\n"); 
		query.append("    WHERE   A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("    AND     B.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("    AND     B.CNTR_STS_SEQ = C.CNTR_STS_SEQ" ).append("\n"); 
		query.append("    AND     B.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("    AND     C.RANK_NO = 1" ).append("\n"); 
		query.append("    AND     C.CNTR_STS_CD IN('MUO','SBO')" ).append("\n"); 
		query.append("    GROUP BY A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("), TEMP_DROP01 AS (" ).append("\n"); 
		query.append("    SELECT  A.AGMT_CTY_CD, A.AGMT_SEQ, A.QTY_YRMON," ).append("\n"); 
		query.append("            A.COST_YRMON, A.RCV_RNTL_SEQ, A.LSTM_CD," ).append("\n"); 
		query.append("            A.CNTR_TPSZ_CD, A.LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("            A.CHG_RT_AMT, A.CL_DPP_FRDAY, A.AGMT_CHG_VAL, A.CNTR_CNT" ).append("\n"); 
		query.append("    FROM   (SELECT  P.AGMT_CTY_CD, P.AGMT_SEQ, P.QTY_YRMON," ).append("\n"); 
		query.append("                    P.COST_YRMON, P.RCV_RNTL_SEQ, P.LSTM_CD," ).append("\n"); 
		query.append("                    Z.CNTR_TPSZ_CD, Z.LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("                    Z.CHG_RT_AMT, Z.CL_DPP_FRDAY, Z.AGMT_CHG_VAL, T2.CNTR_CNT," ).append("\n"); 
		query.append("                    RANK() OVER(PARTITION BY Z.CNTR_TPSZ_CD, Z.LSE_RCV_CHG_TP_CD" ).append("\n"); 
		query.append("                                    ORDER BY Z.AGMT_CHG_VAL DESC) AS RANK_NO" ).append("\n"); 
		query.append("            FROM    TEMP_DROP02 T2, PARAM P," ).append("\n"); 
		query.append("                   (SELECT  A.AGMT_CTY_CD, A.AGMT_SEQ, A.CNTR_TPSZ_CD, A.CNTR_RNTL_CHG_TP_CD," ).append("\n"); 
		query.append("                            A.AGMT_CHG_DYS, B.DPP_TP_CD, A.AGMT_CHG_VAL," ).append("\n"); 
		query.append("                            CASE A.CNTR_RNTL_CHG_TP_CD" ).append("\n"); 
		query.append("                                WHEN 'PDGV' THEN 'PDM'" ).append("\n"); 
		query.append("                                ELSE 'DPP'" ).append("\n"); 
		query.append("                            END LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("                            CASE A.CNTR_RNTL_CHG_TP_CD" ).append("\n"); 
		query.append("                                WHEN 'PDGV' THEN N1ST_CHG_AMT" ).append("\n"); 
		query.append("                                ELSE N2ND_CHG_AMT" ).append("\n"); 
		query.append("                            END CHG_RT_AMT," ).append("\n"); 
		query.append("                            CASE WHEN A.CNTR_RNTL_CHG_TP_CD = 'DPPV' THEN A.AGMT_CHG_DYS" ).append("\n"); 
		query.append("                                 WHEN A.CNTR_RNTL_CHG_TP_CD = 'LDPV' AND B.DPP_TP_CD = 'L'" ).append("\n"); 
		query.append("                                 THEN A.AGMT_CHG_DYS" ).append("\n"); 
		query.append("                                 ELSE 0 END CL_DPP_FRDAY" ).append("\n"); 
		query.append("                    FROM    LSE_AGMT_RT_V A," ).append("\n"); 
		query.append("                            LSE_AGREEMENT B," ).append("\n"); 
		query.append("                                        PARAM P" ).append("\n"); 
		query.append("                    WHERE   A.AGMT_CTY_CD         = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                    AND     A.AGMT_SEQ            = B.AGMT_SEQ" ).append("\n"); 
		query.append("                    AND     B.AGMT_CTY_CD         = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("                    AND     B.AGMT_SEQ            = P.AGMT_SEQ" ).append("\n"); 
		query.append("                    AND     A.AGMT_VER_SEQ        = MST_COMMON_PKG.MST_AGMT_LST_VER_GET_FNC(P.AGMT_CTY_CD, P.AGMT_SEQ, P.BASE_DT)" ).append("\n"); 
		query.append("                    AND    (A.CNTR_RNTL_CHG_TP_CD = 'PDGV'" ).append("\n"); 
		query.append("                    OR      A.CNTR_RNTL_CHG_TP_CD = 'DPPV'" ).append("\n"); 
		query.append("                    AND     B.DPP_TP_CD = 'Y')" ).append("\n"); 
		query.append("                    ) Z" ).append("\n"); 
		query.append("          WHERE     Z.CNTR_TPSZ_CD = T2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            AND     Z.AGMT_CHG_VAL <= T2.CNTR_CNT" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("    WHERE   A.RANK_NO = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  COST_YRMON, AGMT_CTY_CD, AGMT_SEQ, RCV_RNTL_SEQ, LSTM_CD, CNTR_NO," ).append("\n"); 
		query.append("        CNTR_TPSZ_CD, ONH_DT, ONH_LOC_CD, OFFH_DT, OFFH_LOC_CD, BIL_FM_DT," ).append("\n"); 
		query.append("        BIL_TO_DT, TTL_DYS, FREE_DYS, BIL_DYS, LSE_RCV_CHG_TP_CD, CHG_RT_AMT," ).append("\n"); 
		query.append("        COST_AMT, PKUP_CHG_FLG, PKUP_CHG_AMT, LON_CHG_FLG, LOF_CHG_FLG, LFT_CHG_AMT, GTI_CHG_FLG, GTI_CHG_AMT, GTO_CHG_FLG, GTO_CHG_AMT" ).append("\n"); 
		query.append("FROM   (SELECT  A.COST_YRMON," ).append("\n"); 
		query.append("                A.AGMT_CTY_CD," ).append("\n"); 
		query.append("                A.AGMT_SEQ," ).append("\n"); 
		query.append("                A.RCV_RNTL_SEQ," ).append("\n"); 
		query.append("                A.LSTM_CD," ).append("\n"); 
		query.append("                A.RTN_CNTR_NO AS CNTR_NO," ).append("\n"); 
		query.append("                A.RTN_CNTR_TPSZ_CD AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                TO_CHAR(A.CNTR_STS_EVNT_DT,'YYYYMMDD') AS ONH_DT," ).append("\n"); 
		query.append("                A.LOC_CD AS ONH_LOC_CD," ).append("\n"); 
		query.append("                TO_CHAR(A.RTN_DT,'YYYYMMDD') AS OFFH_DT," ).append("\n"); 
		query.append("                A.RTN_LOC_CD AS OFFH_LOC_CD," ).append("\n"); 
		query.append("                CASE WHEN A.CNTR_STS_EVNT_DT > TO_DATE(A.QTY_YRMON,'YYYYMM')" ).append("\n"); 
		query.append("                     THEN TO_CHAR(A.CNTR_STS_EVNT_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                     ELSE TO_CHAR(TO_DATE(A.QTY_YRMON,'YYYYMM'),'YYYYMMDD')" ).append("\n"); 
		query.append("                END BIL_FM_DT," ).append("\n"); 
		query.append("                CASE WHEN A.RTN_DT < LAST_DAY(TO_DATE(A.QTY_YRMON,'YYYYMM'))" ).append("\n"); 
		query.append("                     THEN TO_CHAR(A.RTN_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                     ELSE TO_CHAR(LAST_DAY(TO_DATE(A.QTY_YRMON,'YYYYMM')),'YYYYMMDD')" ).append("\n"); 
		query.append("                END BIL_TO_DT," ).append("\n"); 
		query.append("                DECODE(A.LSE_RCV_CHG_TP_CD, 'PDM', A.TTL_DYS,  0) AS TTL_DYS," ).append("\n"); 
		query.append("                DECODE(A.LSE_RCV_CHG_TP_CD, 'PDM', A.FREE_DYS, 0) AS FREE_DYS," ).append("\n"); 
		query.append("                DECODE(A.LSE_RCV_CHG_TP_CD, 'PDM', A.PDM_DYS,  0) AS BIL_DYS," ).append("\n"); 
		query.append("                A.LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("                CASE WHEN A.LSE_RCV_CHG_TP_CD = 'PDM' THEN A.CHG_RT_AMT" ).append("\n"); 
		query.append("                     WHEN A.LSE_RCV_CHG_TP_CD = 'DPP' THEN A.AGMT_CHG_VAL" ).append("\n"); 
		query.append("                     ELSE 0 END CHG_RT_AMT," ).append("\n"); 
		query.append("                CASE WHEN A.LSE_RCV_CHG_TP_CD = 'PDM' THEN A.PDM_DYS * A.CHG_RT_AMT" ).append("\n"); 
		query.append("                     WHEN A.LSE_RCV_CHG_TP_CD = 'DPP' THEN A.AGMT_CHG_VAL" ).append("\n"); 
		query.append("                     ELSE DECODE(TO_CHAR(A.RTN_DT, 'YYYYMM'), A.QTY_YRMON, A.CHG_RT_AMT, 0)" ).append("\n"); 
		query.append("                     END COST_AMT," ).append("\n"); 
		query.append("                CASE WHEN A.QTY_YRMON = TO_CHAR(A.CNTR_STS_EVNT_DT,'YYYYMM')" ).append("\n"); 
		query.append("                      AND A.PKUP_CHG_AMT > 0 THEN 'PUC'" ).append("\n"); 
		query.append("                     WHEN A.QTY_YRMON = TO_CHAR(A.CNTR_STS_EVNT_DT,'YYYYMM')" ).append("\n"); 
		query.append("                      AND A.PKUP_CHG_AMT < 0 THEN 'PCR'" ).append("\n"); 
		query.append("                     ELSE 'NON' END PKUP_CHG_FLG," ).append("\n"); 
		query.append("                A.PKUP_CHG_AMT," ).append("\n"); 
		query.append("                CASE WHEN A.QTY_YRMON = TO_CHAR(A.CNTR_STS_EVNT_DT,'YYYYMM')" ).append("\n"); 
		query.append("                      AND A.LFT_CHG_AMT != 0 THEN 'LON'" ).append("\n"); 
		query.append("                     ELSE 'NON' END LON_CHG_FLG," ).append("\n"); 
		query.append("                CASE WHEN A.QTY_YRMON = TO_CHAR(A.RTN_DT,'YYYYMM')" ).append("\n"); 
		query.append("                      AND A.LFT_CHG_AMT != 0 THEN 'LOF'" ).append("\n"); 
		query.append("                     ELSE 'NON' END LOF_CHG_FLG," ).append("\n"); 
		query.append("                A.LFT_CHG_AMT," ).append("\n"); 
		query.append("                CASE WHEN A.QTY_YRMON = TO_CHAR(A.CNTR_STS_EVNT_DT,'YYYYMM')" ).append("\n"); 
		query.append("                      AND NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(A.AGMT_CTY_CD, A.AGMT_SEQ, 'GTI', A.RTN_CNTR_TPSZ_CD, A.LOC_CD, A.CNTR_STS_EVNT_DT), 0) != 0 THEN 'GTI'" ).append("\n"); 
		query.append("                     ELSE 'NON' END GTI_CHG_FLG," ).append("\n"); 
		query.append("                CASE WHEN A.QTY_YRMON = TO_CHAR(A.RTN_DT,'YYYYMM')" ).append("\n"); 
		query.append("                      AND NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(A.AGMT_CTY_CD, A.AGMT_SEQ, 'GTO', A.RTN_CNTR_TPSZ_CD, A.RTN_LOC_CD, A.CNTR_STS_EVNT_DT), 0) != 0 THEN 'GTO'" ).append("\n"); 
		query.append("                     ELSE 'NON' END GTO_CHG_FLG," ).append("\n"); 
		query.append("                NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(A.AGMT_CTY_CD, A.AGMT_SEQ, 'GTI', A.RTN_CNTR_TPSZ_CD, A.LOC_CD, A.CNTR_STS_EVNT_DT), 0) GTI_CHG_AMT," ).append("\n"); 
		query.append("                NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(A.AGMT_CTY_CD, A.AGMT_SEQ, 'GTO', A.RTN_CNTR_TPSZ_CD, A.RTN_LOC_CD, A.CNTR_STS_EVNT_DT), 0) GTO_CHG_AMT" ).append("\n"); 
		query.append("        FROM   (SELECT  B.AGMT_CTY_CD, B.AGMT_SEQ, B.QTY_YRMON," ).append("\n"); 
		query.append("                        B.COST_YRMON, B.RCV_RNTL_SEQ, B.LSTM_CD," ).append("\n"); 
		query.append("                        B.LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("                        NVL(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(B.AGMT_CTY_CD, B.AGMT_SEQ, B.LSE_RCV_CHG_TP_CD, B.RTN_CNTR_TPSZ_CD, A.YD_CD, P.BASE_DT), 0) AS CHG_RT_AMT," ).append("\n"); 
		query.append("                        B.AGMT_CHG_VAL," ).append("\n"); 
		query.append("                        B.RTN_CNTR_NO," ).append("\n"); 
		query.append("                        B.RTN_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                        A.CNTR_STS_CD," ).append("\n"); 
		query.append("                        A.CNTR_STS_EVNT_DT," ).append("\n"); 
		query.append("                        TO_CHAR(A.CNTR_STS_EVNT_DT,'YYYYMM') AS CNTR_STS_EVNT_YRMON," ).append("\n"); 
		query.append("                        SUBSTR(A.YD_CD,1,5) AS LOC_CD," ).append("\n"); 
		query.append("                        NVL(A.RNTL_CHG_FREE_DYS,0) AS FREE_DYS," ).append("\n"); 
		query.append("                        CASE WHEN TO_CHAR(A.CNTR_STS_EVNT_DT,'MM') = SUBSTR(B.QTY_YRMON,5,2)" ).append("\n"); 
		query.append("                             THEN B.RTN_DT - A.CNTR_STS_EVNT_DT +1" ).append("\n"); 
		query.append("                             ELSE B.RTN_DT - TO_DATE(B.QTY_YRMON,'YYYYMM') +1" ).append("\n"); 
		query.append("                        END TTL_DYS," ).append("\n"); 
		query.append("                        CASE WHEN TO_CHAR(A.CNTR_STS_EVNT_DT + NVL(A.RNTL_CHG_FREE_DYS,0) - 1,'MM') = SUBSTR(B.QTY_YRMON,5,2)" ).append("\n"); 
		query.append("                             THEN CASE SIGN(B.RTN_DT - (A.CNTR_STS_EVNT_DT + NVL(A.RNTL_CHG_FREE_DYS,0) -1))" ).append("\n"); 
		query.append("                                  WHEN 1 THEN B.RTN_DT - (A.CNTR_STS_EVNT_DT + NVL(A.RNTL_CHG_FREE_DYS,0)) +1" ).append("\n"); 
		query.append("                                  ELSE 0 END" ).append("\n"); 
		query.append("                             ELSE CASE SIGN(TO_DATE(B.QTY_YRMON,'YYYYMM') - (A.CNTR_STS_EVNT_DT + NVL(A.RNTL_CHG_FREE_DYS,0) - 1))" ).append("\n"); 
		query.append("                                  WHEN 1 THEN B.RTN_DT - TO_DATE(B.QTY_YRMON,'YYYYMM') +1" ).append("\n"); 
		query.append("                                  ELSE 0 END" ).append("\n"); 
		query.append("                        END PDM_DYS," ).append("\n"); 
		query.append("                        RTN_CNTR_STS_CD," ).append("\n"); 
		query.append("                        RTN_DT," ).append("\n"); 
		query.append("                        RTN_YRMON," ).append("\n"); 
		query.append("                        CASE WHEN TO_CHAR(A.CNTR_STS_EVNT_DT + B.CL_DPP_FRDAY,'MM') = SUBSTR(B.QTY_YRMON,5,2)" ).append("\n"); 
		query.append("                             THEN CASE SIGN(B.RTN_DT - A.CNTR_STS_EVNT_DT + B.CL_DPP_FRDAY -1)" ).append("\n"); 
		query.append("                                  WHEN 1 THEN B.RTN_DT - A.CNTR_STS_EVNT_DT + B.CL_DPP_FRDAY +1" ).append("\n"); 
		query.append("                                  ELSE 0 END" ).append("\n"); 
		query.append("                             ELSE CASE SIGN(TO_DATE(B.QTY_YRMON,'YYYYMM') - (A.CNTR_STS_EVNT_DT + B.CL_DPP_FRDAY - 1))" ).append("\n"); 
		query.append("                                  WHEN 1 THEN B.RTN_DT - TO_DATE(B.QTY_YRMON,'YYYYMM') +1" ).append("\n"); 
		query.append("                                  ELSE 0 END" ).append("\n"); 
		query.append("                        END DPP_DYS," ).append("\n"); 
		query.append("                        CASE WHEN TO_CHAR(A.CNTR_STS_EVNT_DT,'MM') = SUBSTR(B.QTY_YRMON,5,2)" ).append("\n"); 
		query.append("                             THEN NVL(B.CL_DPP_FRDAY,0)" ).append("\n"); 
		query.append("                             ELSE CASE SIGN(NVL(B.CL_DPP_FRDAY,0) - (TO_DATE(B.QTY_YRMON,'YYYYMM') - A.CNTR_STS_EVNT_DT))" ).append("\n"); 
		query.append("                                  WHEN 1 THEN NVL(B.CL_DPP_FRDAY,0) - (TO_DATE(B.QTY_YRMON,'YYYYMM') - A.CNTR_STS_EVNT_DT)" ).append("\n"); 
		query.append("                                  ELSE 0 END" ).append("\n"); 
		query.append("                        END DPP_FREE_DYS," ).append("\n"); 
		query.append("                        RTN_LOC_CD," ).append("\n"); 
		query.append("                        NVL(A.CNTR_PKUP_CHG_AMT,0) PKUP_CHG_AMT," ).append("\n"); 
		query.append("                        NVL(A.CNTR_LFT_CHG_AMT,0) LFT_CHG_AMT" ).append("\n"); 
		query.append("                FROM    MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("                       (SELECT  /*+ INDEX(A XAK4MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                DISTINCT A.CNTR_NO AS RTN_CNTR_NO," ).append("\n"); 
		query.append("                                B.CNTR_TPSZ_CD AS RTN_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                A.CNTR_STS_CD AS RTN_CNTR_STS_CD," ).append("\n"); 
		query.append("                                A.CNTR_STS_EVNT_DT AS RTN_DT," ).append("\n"); 
		query.append("                                TO_CHAR(A.CNTR_STS_EVNT_DT,'YYYYMM') AS RTN_YRMON," ).append("\n"); 
		query.append("                                SUBSTR(A.YD_CD,1,5) AS RTN_LOC_CD," ).append("\n"); 
		query.append("                                A.PRNR_STS_SEQ PARTN_SEQ," ).append("\n"); 
		query.append("                                T1.AGMT_CTY_CD, T1.AGMT_SEQ, T1.QTY_YRMON," ).append("\n"); 
		query.append("                                T1.COST_YRMON, T1.RCV_RNTL_SEQ, T1.LSTM_CD," ).append("\n"); 
		query.append("                                T1.LSE_RCV_CHG_TP_CD, T1.CHG_RT_AMT," ).append("\n"); 
		query.append("                                T1.AGMT_CHG_VAL, T1.CL_DPP_FRDAY," ).append("\n"); 
		query.append("                                (SELECT /*+ INDEX_DESC(SUB XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                          SUB.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                                   FROM MST_CNTR_STS_HIS SUB" ).append("\n"); 
		query.append("                                  WHERE B.CNTR_NO               = SUB.CNTR_NO" ).append("\n"); 
		query.append("                                      AND SUB.CNTR_STS_CD       = DECODE(A.CNTR_STS_CD, 'SBI', 'SBO', 'MUO')" ).append("\n"); 
		query.append("                                      AND SUB.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("                                      AND SUB.CNTR_STS_EVNT_DT <= A.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("                                      AND ROWNUM        = 1" ).append("\n"); 
		query.append("                                ) LNK_SEQ" ).append("\n"); 
		query.append("                        FROM    MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("                                MST_CONTAINER B," ).append("\n"); 
		query.append("                                TEMP_DROP01 T1" ).append("\n"); 
		query.append("                        WHERE   A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                        AND     A.AGMT_CTY_CD = T1.AGMT_CTY_CD" ).append("\n"); 
		query.append("                        AND     A.AGMT_SEQ    = T1.AGMT_SEQ" ).append("\n"); 
		query.append("                        AND     B.CNTR_TPSZ_CD = T1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                        AND     A.CNTR_STS_CD IN ('SBI', 'MUI')" ).append("\n"); 
		query.append("                        AND     A.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("                        AND     TO_CHAR(A.CNTR_STS_EVNT_DT, 'YYYYMM') = T1.QTY_YRMON" ).append("\n"); 
		query.append("                        ) B, PARAM P" ).append("\n"); 
		query.append("                WHERE   A.CNTR_NO = B.RTN_CNTR_NO" ).append("\n"); 
		query.append("                AND     A.CNTR_STS_SEQ = B.LNK_SEQ" ).append("\n"); 
		query.append("                AND     A.CNTR_STS_CD IN ('SBO','MUO')" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT  P.AGMT_CTY_CD AS AGMT_CTY_CD," ).append("\n"); 
		query.append("                        P.AGMT_SEQ AS AGMT_SEQ," ).append("\n"); 
		query.append("                        P.QTY_YRMON AS QTY_YRMON," ).append("\n"); 
		query.append("                        P.COST_YRMON AS COST_YRMON," ).append("\n"); 
		query.append("                        P.RCV_RNTL_SEQ AS RCV_RNTL_SEQ," ).append("\n"); 
		query.append("                        P.LSTM_CD AS LSTM_CD," ).append("\n"); 
		query.append("                        T1.LSE_RCV_CHG_TP_CD AS LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("                        NVL(MIN(MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(A.AGMT_CTY_CD, A.AGMT_SEQ, T1.LSE_RCV_CHG_TP_CD, B.CNTR_TPSZ_CD, A.YD_CD, P.BASE_DT)), 0) AS CHG_RT_AMT," ).append("\n"); 
		query.append("                        T1.AGMT_CHG_VAL AS AGMT_CHG_VAL," ).append("\n"); 
		query.append("                        A.CNTR_NO AS RTN_CNTR_NO," ).append("\n"); 
		query.append("                        MAX(B.CNTR_TPSZ_CD) AS RTN_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                        MAX(A.CNTR_STS_CD) AS CNTR_STS_CD," ).append("\n"); 
		query.append("                        MAX(A.CNTR_STS_EVNT_DT) AS CNTR_STS_EVNT_DT," ).append("\n"); 
		query.append("                        TO_CHAR(MAX(A.CNTR_STS_EVNT_DT),'YYYYMM') AS CNTR_STS_EVNT_YRMON," ).append("\n"); 
		query.append("                        MAX(SUBSTR(A.YD_CD,1,5)) AS LOC_CD," ).append("\n"); 
		query.append("                        MAX(NVL(A.RNTL_CHG_FREE_DYS,0)) AS FREE_DYS," ).append("\n"); 
		query.append("                        MAX(CASE WHEN TO_CHAR(A.CNTR_STS_EVNT_DT,'YYYYMM') = SUBSTR(T1.QTY_YRMON, 1, 6)" ).append("\n"); 
		query.append("                                 THEN LAST_DAY(TO_DATE(T1.QTY_YRMON,'YYYYMM')) - A.CNTR_STS_EVNT_DT +1" ).append("\n"); 
		query.append("                                 ELSE LAST_DAY(TO_DATE(T1.QTY_YRMON,'YYYYMM')) - TO_DATE(T1.QTY_YRMON,'YYYYMM') +1" ).append("\n"); 
		query.append("                            END) TTL_DYS," ).append("\n"); 
		query.append("                        MAX(CASE WHEN TO_CHAR(A.CNTR_STS_EVNT_DT + NVL(A.RNTL_CHG_FREE_DYS,0) - 1,'YYYYMM') = SUBSTR(T1.QTY_YRMON, 1, 6)" ).append("\n"); 
		query.append("                                 THEN LAST_DAY(TO_DATE(T1.QTY_YRMON,'YYYYMM')) - (A.CNTR_STS_EVNT_DT + NVL(A.RNTL_CHG_FREE_DYS,0)) +1" ).append("\n"); 
		query.append("                                 ELSE CASE SIGN(TO_DATE(T1.QTY_YRMON,'YYYYMM') - (A.CNTR_STS_EVNT_DT + NVL(A.RNTL_CHG_FREE_DYS,0) - 1))" ).append("\n"); 
		query.append("                                      WHEN 1 THEN LAST_DAY(TO_DATE(T1.QTY_YRMON,'YYYYMM')) - TO_DATE(T1.QTY_YRMON,'YYYYMM') +1" ).append("\n"); 
		query.append("                                      ELSE 0 END" ).append("\n"); 
		query.append("                            END) PDM_DYS," ).append("\n"); 
		query.append("                        NULL AS RTN_CNTR_STS_CD," ).append("\n"); 
		query.append("                        TO_DATE(NULL) AS RTN_DT," ).append("\n"); 
		query.append("                        NULL AS RTN_YRMON," ).append("\n"); 
		query.append("                        MAX(CASE WHEN TO_CHAR(A.CNTR_STS_EVNT_DT + T1.CL_DPP_FRDAY, 'YYYYMM') = SUBSTR(T1.QTY_YRMON, 1, 6)" ).append("\n"); 
		query.append("                                 THEN LAST_DAY(TO_DATE(T1.QTY_YRMON,'YYYYMM')) - A.CNTR_STS_EVNT_DT + T1.CL_DPP_FRDAY +1" ).append("\n"); 
		query.append("                                 ELSE CASE SIGN(TO_DATE(T1.QTY_YRMON,'YYYYMM') - (A.CNTR_STS_EVNT_DT + T1.CL_DPP_FRDAY - 1))" ).append("\n"); 
		query.append("                                      WHEN 1 THEN LAST_DAY(TO_DATE(T1.QTY_YRMON,'YYYYMM')) - TO_DATE(T1.QTY_YRMON,'YYYYMM') +1" ).append("\n"); 
		query.append("                                      ELSE 0 END" ).append("\n"); 
		query.append("                            END) DPP_DYS," ).append("\n"); 
		query.append("                        MAX(CASE WHEN TO_CHAR(A.CNTR_STS_EVNT_DT,'YYYYMM') = SUBSTR(T1.QTY_YRMON, 1, 6)" ).append("\n"); 
		query.append("                                 THEN NVL(T1.CL_DPP_FRDAY,0)" ).append("\n"); 
		query.append("                                 ELSE CASE SIGN(NVL(T1.CL_DPP_FRDAY,0) - (TO_DATE(T1.QTY_YRMON,'YYYYMM') - A.CNTR_STS_EVNT_DT))" ).append("\n"); 
		query.append("                                      WHEN 1 THEN NVL(T1.CL_DPP_FRDAY,0) - (TO_DATE(T1.QTY_YRMON,'YYYYMM') - A.CNTR_STS_EVNT_DT)" ).append("\n"); 
		query.append("                                      ELSE 0 END" ).append("\n"); 
		query.append("                            END) DPP_FREE_DYS," ).append("\n"); 
		query.append("                        NULL AS RTN_LOC_CD," ).append("\n"); 
		query.append("                        MAX(NVL(A.CNTR_PKUP_CHG_AMT,0)) PKUP_CHG_AMT," ).append("\n"); 
		query.append("                        MAX(NVL(A.CNTR_LFT_CHG_AMT,0)) LFT_CHG_AMT" ).append("\n"); 
		query.append("                FROM    PARAM P," ).append("\n"); 
		query.append("                        TEMP_DROP01 T1," ).append("\n"); 
		query.append("                        MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("                        MST_CONTAINER B," ).append("\n"); 
		query.append("                       (SELECT   /*+ INDEX(Z XAK4MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                 Z.CNTR_NO, Z.CNTR_STS_SEQ, Z.CNTR_STS_CD," ).append("\n"); 
		query.append("                                 RANK() OVER(PARTITION BY Z.CNTR_NO ORDER BY Z.CNTR_STS_EVNT_DT DESC, Z.CNTR_STS_SEQ DESC) AS RANK_NO" ).append("\n"); 
		query.append("                        FROM     PARAM P," ).append("\n"); 
		query.append("                                 MST_CNTR_STS_HIS Z" ).append("\n"); 
		query.append("                        WHERE    Z.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("                        AND      Z.AGMT_SEQ = P.AGMT_SEQ" ).append("\n"); 
		query.append("                        AND      Z.CNTR_STS_CD IN ('SBO','SBI','MUO','MUI')" ).append("\n"); 
		query.append("                        AND      Z.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("                        AND      TO_CHAR(Z.CNTR_STS_EVNT_DT, 'YYYYMM') <= P.QTY_YRMON" ).append("\n"); 
		query.append("                        ) C" ).append("\n"); 
		query.append("                WHERE   A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                AND     A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("                AND     A.CNTR_STS_SEQ = C.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                AND     A.AGMT_CTY_CD = T1.AGMT_CTY_CD" ).append("\n"); 
		query.append("                AND     A.AGMT_SEQ    = T1.AGMT_SEQ" ).append("\n"); 
		query.append("                AND     A.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("                AND     B.CNTR_TPSZ_CD = T1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                AND     C.RANK_NO = 1" ).append("\n"); 
		query.append("                AND     C.CNTR_STS_CD IN('SBO','MUO')" ).append("\n"); 
		query.append("                GROUP BY A.CNTR_NO, A.CNTR_STS_SEQ, T1.LSE_RCV_CHG_TP_CD, T1.CHG_RT_AMT, T1.AGMT_CHG_VAL" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("        WHERE   A.LSE_RCV_CHG_TP_CD = 'PDM'" ).append("\n"); 
		query.append("        OR      A.QTY_YRMON = TO_CHAR(A.RTN_DT,'YYYYMM')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE   LSE_RCV_CHG_TP_CD = 'PDM'" ).append("\n"); 
		query.append("OR      COST_AMT != 0" ).append("\n"); 

	}
}