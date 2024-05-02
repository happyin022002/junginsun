/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ACMSimulationDBDAOAddAcmSimCommChgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOAddAcmSimCommChgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAcmSimCommChg
	  * 
	  * 2014.05.09 박다은 [선반영] PRM Charge G.Rev 에서 surchrage 유무에 상관없이 공제되도록 로직 변경 요청
	  * </pre>
	  */
	public ACMSimulationDBDAOAddAcmSimCommChgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sa_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOAddAcmSimCommChgCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_SIM_COMM_CHG" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  @[sim_no]" ).append("\n"); 
		query.append(", M.BKG_NO" ).append("\n"); 
		query.append(", M.AGN_CD" ).append("\n"); 
		query.append(", M.IO_BND_CD" ).append("\n"); 
		query.append(", M.AC_TP_CD" ).append("\n"); 
		query.append(", @[max_ac_seq] AS AC_SEQ --> 임시" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY   M.BKG_NO, M.AGN_CD, M.IO_BND_CD, M.AC_TP_CD  ORDER BY M.CHG_CD ) AS AC_CHG_SEQ" ).append("\n"); 
		query.append(", M.REP_CHG_CD" ).append("\n"); 
		query.append(", M.CHG_CD" ).append("\n"); 
		query.append(", M.BKG_AGMT_UT_CD" ).append("\n"); 
		query.append(", M.CHG_DDCT_AMT" ).append("\n"); 
		query.append(", M.CURR_CD" ).append("\n"); 
		query.append(", M.CHG_DDCT_PAY_AMT" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("   SELECT A.BKG_NO," ).append("\n"); 
		query.append("     A.AGN_CD," ).append("\n"); 
		query.append("     A.IO_BND_CD," ).append("\n"); 
		query.append("     A.AC_TP_CD," ).append("\n"); 
		query.append("     ROW_NUMBER() OVER(PARTITION BY A.BKG_NO, A.AGN_CD, A.IO_BND_CD, A.AC_TP_CD, A.REP_CHG_CD, A.CHG_CD, A.BKG_AGMT_UT_CD ORDER BY A.AGMT_UT_ODR, A.BKG_AGMT_UT_CD DESC) AS RN," ).append("\n"); 
		query.append("     A.REP_CHG_CD," ).append("\n"); 
		query.append("     A.CHG_CD," ).append("\n"); 
		query.append("     A.BKG_AGMT_UT_CD," ).append("\n"); 
		query.append("     SUM(CASE WHEN ROUT_TRF_RT <> 0 AND CURR_CD = 'USD' THEN ROUT_TRF_RT * OFT / 100" ).append("\n"); 
		query.append("              WHEN ROUT_TRF_RT <> 0 AND CURR_CD <> 'USD' THEN ROUT_TRF_RT * OFT / 100 / USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("              WHEN ROUT_TRF_FX_AMT <> 0 AND CURR_CD = 'USD' AND BKG_AGMT_UT_CD = 'BL' THEN DECODE(RN0, 1, ROUT_TRF_FX_AMT, 0)" ).append("\n"); 
		query.append("              WHEN ROUT_TRF_FX_AMT <> 0 AND CURR_CD <> 'USD' AND BKG_AGMT_UT_CD = 'BL' THEN DECODE(RN0, 1, ROUT_TRF_FX_AMT, 0) / USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("              WHEN ROUT_TRF_FX_AMT <> 0 AND CURR_CD =  'USD' THEN ROUT_TRF_FX_AMT * OP_CNTR_QTY" ).append("\n"); 
		query.append("              WHEN ROUT_TRF_FX_AMT <> 0 AND CURR_CD <> 'USD' THEN ROUT_TRF_FX_AMT * OP_CNTR_QTY / USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("              ELSE 0" ).append("\n"); 
		query.append("         END " ).append("\n"); 
		query.append("     ) OVER(PARTITION BY A.BKG_NO, A.AGN_CD, A.IO_BND_CD, A.AC_TP_CD, A.REP_CHG_CD, A.CHG_CD, A.BKG_AGMT_UT_CD) AS CHG_DDCT_AMT," ).append("\n"); 
		query.append("     A.CURR_CD," ).append("\n"); 
		query.append("     SUM(CASE WHEN ROUT_TRF_RT <> 0 THEN ROUT_TRF_RT * OFT / 100" ).append("\n"); 
		query.append("              WHEN ROUT_TRF_FX_AMT <> 0 AND BKG_AGMT_UT_CD = 'BL' THEN DECODE(RN0, 1, ROUT_TRF_FX_AMT, 0)" ).append("\n"); 
		query.append("              WHEN ROUT_TRF_FX_AMT <> 0 THEN ROUT_TRF_FX_AMT * OP_CNTR_QTY " ).append("\n"); 
		query.append("              ELSE 0" ).append("\n"); 
		query.append("         END" ).append("\n"); 
		query.append("     ) OVER(PARTITION BY A.BKG_NO, A.AGN_CD, A.IO_BND_CD, A.AC_TP_CD, A.REP_CHG_CD, A.CHG_CD, A.BKG_AGMT_UT_CD) AS CHG_DDCT_PAY_AMT" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("      SELECT R.BKG_NO," ).append("\n"); 
		query.append("        (SELECT SUM(CASE WHEN BCR.CURR_CD = 'USD' THEN BCR.CHG_AMT" ).append("\n"); 
		query.append("                         WHEN XC2.USD_LOCL_XCH_RT = 0 THEN 0" ).append("\n"); 
		query.append("                         ELSE BCR.CHG_AMT / XC2.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("                ) AS OFT_USD" ).append("\n"); 
		query.append("         FROM BKG_CHG_RT BCR," ).append("\n"); 
		query.append("           GL_MON_XCH_RT XC2" ).append("\n"); 
		query.append("         WHERE BCR.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("           AND BCR.RAT_UT_CD = Q.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           AND BCR.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("           AND BCR.CHG_CD = 'OFT'" ).append("\n"); 
		query.append("           AND BCR.CURR_CD = XC2.CURR_CD" ).append("\n"); 
		query.append("           AND XC2.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("           AND XC2.ACCT_XCH_RT_YRMON = (CASE WHEN SUBSTR(@[sa_dt], 1, 6) > TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("                                               THEN TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(@[sa_dt], 1, 6), 'YYYYMM'), -1), 'YYYYMM')" ).append("\n"); 
		query.append("                                             ELSE SUBSTR(@[sa_dt], 1, 6)" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("        ) AS OFT," ).append("\n"); 
		query.append("        ROUT_TRF_RT," ).append("\n"); 
		query.append("        ROUT_TRF_FX_AMT," ).append("\n"); 
		query.append("        OP_CNTR_QTY," ).append("\n"); 
		query.append("        ROW_NUMBER() OVER(PARTITION BY R.CHG_CD, R.BKG_AGMT_UT_CD ORDER BY 1) AS RN0," ).append("\n"); 
		query.append("        ROW_NUMBER() OVER(PARTITION BY R.CHG_CD, R.BKG_AGMT_UT_CD ORDER BY T.AGMT_UT_ODR, Q.CNTR_TPSZ_CD DESC, DECODE(SPCL_CGO_CTNT, '  ', 0, 1) DESC) AS RN1," ).append("\n"); 
		query.append("        ROW_NUMBER() OVER(PARTITION BY R.CHG_CD, R.BKG_AGMT_UT_CD, Q.CNTR_TPSZ_CD ORDER BY T.AGMT_UT_ODR, DECODE(SPCL_CGO_CTNT, '  ', 0, 1) DESC) AS RN2," ).append("\n"); 
		query.append("        ROW_NUMBER() OVER(PARTITION BY R.CHG_CD, T.CNTR_TPSZ_CD ORDER BY T.AGMT_UT_ODR, Q.CNTR_TPSZ_CD DESC, DECODE(SPCL_CGO_CTNT, '  ', 0, 1) DESC) AS RN3," ).append("\n"); 
		query.append("        R.CURR_CD," ).append("\n"); 
		query.append("        R.BKG_AGMT_UT_CD," ).append("\n"); 
		query.append("        M.REP_CHG_CD," ).append("\n"); 
		query.append("        Q.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        C.*," ).append("\n"); 
		query.append("        G.USD_LOCL_XCH_RT," ).append("\n"); 
		query.append("        T.AGMT_UT_ODR" ).append("\n"); 
		query.append("      FROM ACM_SIM_COMM_CHG_REF R," ).append("\n"); 
		query.append("        ACM_SIM_AGMT_DTL D," ).append("\n"); 
		query.append("        ACM_SIM_AGMT_DTL_CHG C," ).append("\n"); 
		query.append("        MDM_CHARGE M," ).append("\n"); 
		query.append("        BKG_QUANTITY Q," ).append("\n"); 
		query.append("        BKG_BOOKING B," ).append("\n"); 
		query.append("        MDM_LOCATION MPOR," ).append("\n"); 
		query.append("        MDM_LOCATION MDEL," ).append("\n"); 
		query.append("        GL_MON_XCH_RT G," ).append("\n"); 
		query.append("        (SELECT DISTINCT '1' AS AGMT_UT_ODR," ).append("\n"); 
		query.append("           MPG.CNTR_TP AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("           MPG.CNTR_TP AS BKG_AGMT_UT_CD" ).append("\n"); 
		query.append("         FROM AGT_CNTR_PERTP_MPG_V MPG" ).append("\n"); 
		query.append("         WHERE MPG.CNTR_TP <> MPG.REP_TP" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT DISTINCT '2' AS AGMT_UT_ODR," ).append("\n"); 
		query.append("           MPG.CNTR_TP AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("           MPG.REP_TP AS BKG_AGMT_UT_CD" ).append("\n"); 
		query.append("         FROM AGT_CNTR_PERTP_MPG_V MPG" ).append("\n"); 
		query.append("         WHERE MPG.CNTR_TP <> MPG.REP_TP" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT DISTINCT '3' AS AGMT_UT_ODR," ).append("\n"); 
		query.append("           MPG.CNTR_TP AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("           MP2.REP_TP AS BKG_AGMT_UT_CD" ).append("\n"); 
		query.append("         FROM AGT_CNTR_PERTP_MPG_V MPG," ).append("\n"); 
		query.append("           AGT_CNTR_PERTP_MPG_V MP2" ).append("\n"); 
		query.append("         WHERE MPG.CNTR_TP <> MPG.REP_TP" ).append("\n"); 
		query.append("           AND MP2.CNTR_TP = MP2.REP_TP" ).append("\n"); 
		query.append("        ) T" ).append("\n"); 
		query.append("      WHERE B.BKG_NO = Q.BKG_NO" ).append("\n"); 
		query.append("        AND B.POR_CD = MPOR.LOC_CD" ).append("\n"); 
		query.append("        AND B.DEL_CD = MDEL.LOC_CD" ).append("\n"); 
		query.append("        AND C.AGN_AGMT_NO = @[agn_agmt_no]" ).append("\n"); 
		query.append("        AND C.AGN_AGMT_SEQ = @[agn_agmt_seq]" ).append("\n"); 
		query.append("        AND C.AC_TP_CD = @[ac_tp_cd]" ).append("\n"); 
		query.append("        AND C.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("        AND C.CHG_DIV_CD = 'C'" ).append("\n"); 
		query.append("        AND C.CHG_CD = R.CHG_CD" ).append("\n"); 
		query.append("        AND D.AGN_CD = C.AGN_CD" ).append("\n"); 
		query.append("        AND D.AGN_AGMT_NO = C.AGN_AGMT_NO" ).append("\n"); 
		query.append("        AND D.IO_BND_CD = C.IO_BND_CD" ).append("\n"); 
		query.append("        AND D.AC_TP_CD = C.AC_TP_CD" ).append("\n"); 
		query.append("        AND D.AGN_AGMT_SEQ = C.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("        -- RepChargeCD 하드코딩 삭제 요청 ([CHM-201221023] Rep Charge에 상관없이 모든 Charge가 Deduction 될 수 있도록 로직 변경 요청)" ).append("\n"); 
		query.append("        -- AND M.REP_CHG_CD IN ('BAF', 'CAF', 'CHC')" ).append("\n"); 
		query.append("        AND R.CURR_CD = G.CURR_CD" ).append("\n"); 
		query.append("        AND G.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("        AND G.ACCT_XCH_RT_YRMON = (CASE WHEN SUBSTR(@[sa_dt], 1, 6) > TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("                                          THEN TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(@[sa_dt], 1, 6), 'YYYYMM'), -1), 'YYYYMM')" ).append("\n"); 
		query.append("                                        ELSE SUBSTR(@[sa_dt], 1, 6)" ).append("\n"); 
		query.append("                                   END" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("        AND R.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        -- RepChargeCD 하드코딩 삭제 요청 ([CHM-201221023] Rep Charge에 상관없이 모든 Charge가 Deduction 될 수 있도록 로직 변경 요청) " ).append("\n"); 
		query.append("        -- AND R.CHG_CD = M.CHG_CD" ).append("\n"); 
		query.append("        AND R.CHG_CD = M.CHG_CD" ).append("\n"); 
		query.append("        AND R.BKG_AGMT_UT_CD = T.BKG_AGMT_UT_CD" ).append("\n"); 
		query.append("        AND Q.CNTR_TPSZ_CD = T.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        AND Q.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("        AND Q.BKG_NO IN (SELECT DISTINCT DOC.BKG_NO" ).append("\n"); 
		query.append("                         FROM BKG_BL_DOC DOC," ).append("\n"); 
		query.append("                           BKG_BOOKING BKG," ).append("\n"); 
		query.append("                           BKG_BOOKING BK2" ).append("\n"); 
		query.append("                         WHERE (BKG.BKG_NO = DOC.BKG_NO OR BKG.BL_NO = DOC.MST_CVRD_BL_NO)" ).append("\n"); 
		query.append("                           AND BK2.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("                           AND BK2.BL_NO_TP <> '9'" ).append("\n"); 
		query.append("                           AND BK2.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                           AND BKG.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("        AND NVL(R.SPCL_CGO_CTNT, '  ') IN ('  ', 'DR', CASE WHEN Q.DCGO_QTY > 0 THEN 'DG'" ).append("\n"); 
		query.append("                                                            WHEN Q.RC_QTY > 0 THEN 'RF'" ).append("\n"); 
		query.append("                                                            WHEN Q.BB_CGO_QTY > 0 THEN 'BB'" ).append("\n"); 
		query.append("                                                            WHEN Q.EQ_SUBST_CGO_QTY > 0 THEN 'RD'" ).append("\n"); 
		query.append("                                                            ELSE '  '" ).append("\n"); 
		query.append("                                                       END" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 
		query.append("        -- 아시아 -> 미주항, Outbound General, 계약요율의 계산방식이 Gross 일때 모든 Surcharge 공제" ).append("\n"); 
		query.append("        AND 'TRUE' IN (CASE WHEN EXISTS(SELECT 1" ).append("\n"); 
		query.append("                                        FROM DUAL" ).append("\n"); 
		query.append("                                        WHERE D.AC_TP_CD IN ('G', 'C')" ).append("\n"); 
		query.append("                                          AND D.REV_DIV_CD = 'G'" ).append("\n"); 
		query.append("                                          AND D.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                          AND MPOR.CONTI_CD = 'A'" ).append("\n"); 
		query.append("                                          AND MDEL.CONTI_CD = 'M'" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                              THEN 'TRUE'" ).append("\n"); 
		query.append("                            WHEN NOT EXISTS(SELECT 1" ).append("\n"); 
		query.append("                                            FROM BKG_CHG_RT BCR," ).append("\n"); 
		query.append("                                              AGT_CNTR_PERTP_MPG_V PET" ).append("\n"); 
		query.append("                                            WHERE BCR.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("                                              AND BCR.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                              AND (BCR.RAT_UT_CD = PET.REP_TP OR BCR.RAT_UT_CD = PET.CNTR_TP)" ).append("\n"); 
		query.append("                                              -- CFR rating되어 있으면 OTH, CFD rating되어 있으면 DTH 공제 제외 logic 추가. 2016.01.05 김상현" ).append("\n"); 
		query.append("                                              AND (CASE WHEN BCR.CHG_CD IN ('OTH', 'CYR', 'OPS', 'CFR') THEN 'OTH'" ).append("\n"); 
		query.append("                                                        WHEN BCR.CHG_CD IN ('DTH', 'CYC', 'CYD', 'DDC', 'DPS', 'CFD') THEN 'DTH'" ).append("\n"); 
		query.append("                                                        ELSE BCR.CHG_CD" ).append("\n"); 
		query.append("                                                   END" ).append("\n"); 
		query.append("                                                  ) IN (" ).append("\n"); 
		query.append("                                                   CASE WHEN R.CHG_CD IN ('OTH', 'CYR', 'OPS', 'CFR') THEN 'OTH'" ).append("\n"); 
		query.append("                                                        WHEN R.CHG_CD IN ('DTH', 'CYC', 'CYD', 'DDC', 'DPS', 'CFD') THEN 'DTH'" ).append("\n"); 
		query.append("                                                        ELSE R.CHG_CD" ).append("\n"); 
		query.append("                                                   END" ).append("\n"); 
		query.append("                                                  )" ).append("\n"); 
		query.append("                                           )" ).append("\n"); 
		query.append("                              THEN 'TRUE'" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("        -- S/C, RFA, TAA 계약이 2013년 1월 1일 이후 계약일 경우, 'IFC' 공제 제외." ).append("\n"); 
		query.append("        -- 2013년 1월 1일 이전 계약이면서 booking rating되어 있지 않으면 공제." ).append("\n"); 
		query.append("        AND 'TRUE' = CASE WHEN R.CHG_CD = 'IFC' AND TO_DATE('20130101', 'YYYYMMDD') < CASE WHEN B.RFA_NO IS NOT NULL" ).append("\n"); 
		query.append("                                                                                             THEN (SELECT EFF_DT FROM PRI_RP_MN" ).append("\n"); 
		query.append("                                                                                                   WHERE PROP_NO = (SELECT PROP_NO FROM PRI_RP_HDR WHERE RFA_NO = B.RFA_NO)" ).append("\n"); 
		query.append("                                                                                                     AND AMDT_SEQ = '0'" ).append("\n"); 
		query.append("                                                                                                  )" ).append("\n"); 
		query.append("                                                                                           WHEN B.SC_NO IS NOT NULL" ).append("\n"); 
		query.append("                                                                                             THEN (SELECT EFF_DT FROM PRI_SP_MN" ).append("\n"); 
		query.append("                                                                                                   WHERE PROP_NO = (SELECT PROP_NO FROM PRI_SP_HDR WHERE SC_NO = B.SC_NO)" ).append("\n"); 
		query.append("                                                                                                     AND AMDT_SEQ = '0'" ).append("\n"); 
		query.append("                                                                                                  )" ).append("\n"); 
		query.append("                                                                                           WHEN B.TAA_NO IS NOT NULL" ).append("\n"); 
		query.append("                                                                                             THEN (SELECT EFF_DT FROM PRI_TAA_MN" ).append("\n"); 
		query.append("                                                                                                   WHERE TAA_PROP_NO = (SELECT TAA_PROP_NO FROM PRI_TAA_HDR WHERE TAA_NO = B.TAA_NO)" ).append("\n"); 
		query.append("                                                                                                     AND AMDT_SEQ = '0'" ).append("\n"); 
		query.append("                                                                                                  )" ).append("\n"); 
		query.append("                                                                                           ELSE SYSDATE" ).append("\n"); 
		query.append("                                                                                      END" ).append("\n"); 
		query.append("                            THEN 'FALSE'" ).append("\n"); 
		query.append("                          WHEN R.CHG_CD = 'IFC' AND EXISTS(SELECT 1" ).append("\n"); 
		query.append("                                                               FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("                                                                 BKG_CHG_RT RT" ).append("\n"); 
		query.append("                                                               WHERE BKG.BKG_NO = RT.BKG_NO" ).append("\n"); 
		query.append("                                                                 AND RT.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                                 AND RT.CHG_CD = 'IFC'" ).append("\n"); 
		query.append("                                                                 AND TO_DATE('20130101', 'YYYYMMDD') > CASE WHEN BKG.RFA_NO IS NOT NULL" ).append("\n"); 
		query.append("                                                                                                              THEN (SELECT EFF_DT FROM PRI_RP_MN" ).append("\n"); 
		query.append("                                                                                                                    WHERE PROP_NO = (SELECT PROP_NO FROM PRI_RP_HDR WHERE RFA_NO = BKG.RFA_NO)" ).append("\n"); 
		query.append("                                                                                                                      AND AMDT_SEQ = '0'" ).append("\n"); 
		query.append("                                                                                                                   )" ).append("\n"); 
		query.append("                                                                                                            WHEN BKG.SC_NO IS NOT NULL" ).append("\n"); 
		query.append("                                                                                                              THEN (SELECT EFF_DT FROM PRI_SP_MN" ).append("\n"); 
		query.append("                                                                                                                    WHERE PROP_NO = (SELECT PROP_NO FROM PRI_SP_HDR WHERE SC_NO = BKG.SC_NO)" ).append("\n"); 
		query.append("                                                                                                                      AND AMDT_SEQ = '0'" ).append("\n"); 
		query.append("                                                                                                                   )" ).append("\n"); 
		query.append("                                                                                                            WHEN BKG.TAA_NO IS NOT NULL" ).append("\n"); 
		query.append("                                                                                                              THEN (SELECT EFF_DT FROM PRI_TAA_MN" ).append("\n"); 
		query.append("                                                                                                                    WHERE TAA_PROP_NO = (SELECT TAA_PROP_NO FROM PRI_TAA_HDR WHERE TAA_NO = BKG.TAA_NO)" ).append("\n"); 
		query.append("                                                                                                                      AND AMDT_SEQ = '0'" ).append("\n"); 
		query.append("                                                                                                                   )" ).append("\n"); 
		query.append("                                                                                                            ELSE SYSDATE" ).append("\n"); 
		query.append("                                                                                                       END" ).append("\n"); 
		query.append("                                                                 AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                            THEN 'FALSE'" ).append("\n"); 
		query.append("                          ELSE 'TRUE'" ).append("\n"); 
		query.append("                     END" ).append("\n"); 
		query.append("     ) A" ).append("\n"); 
		query.append("   WHERE RN3 = 1" ).append("\n"); 
		query.append("  ) M" ).append("\n"); 
		query.append("WHERE RN = 1" ).append("\n"); 

	}
}