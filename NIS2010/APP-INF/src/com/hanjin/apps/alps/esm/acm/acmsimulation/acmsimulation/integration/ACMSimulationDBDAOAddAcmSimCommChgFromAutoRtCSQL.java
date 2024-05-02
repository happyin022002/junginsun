/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ACMSimulationDBDAOAddAcmSimCommChgFromAutoRtCSQL.java
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

public class ACMSimulationDBDAOAddAcmSimCommChgFromAutoRtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auto rating을 이용한 Surcharge 공제 항목 추출
	  * </pre>
	  */
	public ACMSimulationDBDAOAddAcmSimCommChgFromAutoRtCSQL(){
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
		query.append("FileName : ACMSimulationDBDAOAddAcmSimCommChgFromAutoRtCSQL").append("\n"); 
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
		query.append("SELECT @[sim_no]," ).append("\n"); 
		query.append("  M.BKG_NO," ).append("\n"); 
		query.append("  M.AGN_CD," ).append("\n"); 
		query.append("  M.IO_BND_CD," ).append("\n"); 
		query.append("  M.AC_TP_CD," ).append("\n"); 
		query.append("  @[max_ac_seq] AS AC_SEQ," ).append("\n"); 
		query.append("  ROW_NUMBER() OVER (PARTITION BY M.BKG_NO, M.AGN_CD, M.IO_BND_CD, M.AC_TP_CD ORDER BY M.CHG_CD) AS AC_CHG_SEQ," ).append("\n"); 
		query.append("  M.REP_CHG_CD," ).append("\n"); 
		query.append("  M.CHG_CD," ).append("\n"); 
		query.append("  M.BKG_AGMT_UT_CD," ).append("\n"); 
		query.append("  M.CHG_DDCT_AMT," ).append("\n"); 
		query.append("  M.CURR_CD," ).append("\n"); 
		query.append("  M.CHG_DDCT_PAY_AMT," ).append("\n"); 
		query.append("  @[usr_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  @[usr_id]," ).append("\n"); 
		query.append("  SYSDATE" ).append("\n"); 
		query.append("FROM (SELECT A.BKG_NO," ).append("\n"); 
		query.append("        A.AGN_CD," ).append("\n"); 
		query.append("        A.IO_BND_CD," ).append("\n"); 
		query.append("        A.AC_TP_CD," ).append("\n"); 
		query.append("        ROW_NUMBER() OVER (PARTITION BY A.BKG_NO, A.AGN_CD, A.IO_BND_CD, A.AC_TP_CD, A.REP_CHG_CD, A.CHG_CD, A.BKG_AGMT_UT_CD ORDER BY A.BKG_AGMT_UT_CD DESC ) AS RN," ).append("\n"); 
		query.append("        A.REP_CHG_CD," ).append("\n"); 
		query.append("        A.CHG_CD," ).append("\n"); 
		query.append("        A.BKG_AGMT_UT_CD," ).append("\n"); 
		query.append("        SUM(CASE WHEN ROUT_TRF_FX_AMT <> 0 AND CURR_CD = 'USD' THEN ROUT_TRF_FX_AMT" ).append("\n"); 
		query.append("                 WHEN ROUT_TRF_FX_AMT <> 0 AND CURR_CD <> 'USD' THEN ROUT_TRF_FX_AMT / USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("        ) OVER (PARTITION BY A.BKG_NO, A.AGN_CD, A.IO_BND_CD, A.AC_TP_CD, A.REP_CHG_CD, A.CHG_CD, A.BKG_AGMT_UT_CD) AS CHG_DDCT_AMT," ).append("\n"); 
		query.append("        A.CURR_CD," ).append("\n"); 
		query.append("        SUM(CASE WHEN ROUT_TRF_FX_AMT <> 0 THEN ROUT_TRF_FX_AMT" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("        ) OVER (PARTITION BY A.BKG_NO, A.AGN_CD, A.IO_BND_CD, A.AC_TP_CD, A.REP_CHG_CD, A.CHG_CD, A.BKG_AGMT_UT_CD) AS CHG_DDCT_PAY_AMT" ).append("\n"); 
		query.append("      FROM (SELECT R.BKG_NO," ).append("\n"); 
		query.append("              ROUT_TRF_RT," ).append("\n"); 
		query.append("              ROUT_TRF_FX_AMT," ).append("\n"); 
		query.append("              R.CURR_CD," ).append("\n"); 
		query.append("              R.BKG_AGMT_UT_CD," ).append("\n"); 
		query.append("              M.REP_CHG_CD," ).append("\n"); 
		query.append("              C.*," ).append("\n"); 
		query.append("              G.USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("            FROM ACM_SIM_COMM_CHG_REF R," ).append("\n"); 
		query.append("              ACM_SIM_AGMT_DTL D," ).append("\n"); 
		query.append("              ACM_SIM_AGMT_DTL_CHG C," ).append("\n"); 
		query.append("              MDM_CHARGE M," ).append("\n"); 
		query.append("              BKG_BOOKING B," ).append("\n"); 
		query.append("              MDM_LOCATION MPOR," ).append("\n"); 
		query.append("              MDM_LOCATION MDEL," ).append("\n"); 
		query.append("              GL_MON_XCH_RT G" ).append("\n"); 
		query.append("            WHERE B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("              AND B.POR_CD = MPOR.LOC_CD" ).append("\n"); 
		query.append("              AND B.DEL_CD = MDEL.LOC_CD" ).append("\n"); 
		query.append("              AND C.AGN_AGMT_NO = @[agn_agmt_no]" ).append("\n"); 
		query.append("              AND C.AGN_AGMT_SEQ = @[agn_agmt_seq]" ).append("\n"); 
		query.append("              AND C.AC_TP_CD = @[ac_tp_cd]" ).append("\n"); 
		query.append("              AND C.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("              AND C.CHG_DIV_CD = 'C'" ).append("\n"); 
		query.append("              AND C.CHG_CD = R.CHG_CD" ).append("\n"); 
		query.append("              AND D.AGN_CD = C.AGN_CD" ).append("\n"); 
		query.append("              AND D.AGN_AGMT_NO = C.AGN_AGMT_NO" ).append("\n"); 
		query.append("              AND D.IO_BND_CD = C.IO_BND_CD" ).append("\n"); 
		query.append("              AND D.AC_TP_CD = C.AC_TP_CD" ).append("\n"); 
		query.append("              AND D.AGN_AGMT_SEQ = C.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("              AND R.CURR_CD = G.CURR_CD" ).append("\n"); 
		query.append("              AND G.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("              AND G.ACCT_XCH_RT_YRMON = (CASE WHEN SUBSTR(@[sa_dt], 1, 6) > TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("                                                THEN TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR(@[sa_dt], 1, 6), 'YYYYMM'), -1), 'YYYYMM')" ).append("\n"); 
		query.append("                                              ELSE SUBSTR(@[sa_dt], 1, 6)" ).append("\n"); 
		query.append("                                         END" ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("              AND R.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND R.CHG_CD = M.CHG_CD" ).append("\n"); 
		query.append("              AND 'TRUE' IN (CASE WHEN EXISTS (SELECT 1 FROM DUAL" ).append("\n"); 
		query.append("                                               WHERE D.AC_TP_CD IN ('G', 'C')" ).append("\n"); 
		query.append("                                                 AND D.REV_DIV_CD = 'G'" ).append("\n"); 
		query.append("                                                 AND D.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                                 AND MPOR.CONTI_CD = 'A'" ).append("\n"); 
		query.append("                                                 AND MDEL.CONTI_CD = 'M'" ).append("\n"); 
		query.append("                                              ) " ).append("\n"); 
		query.append("                                    THEN 'TRUE'" ).append("\n"); 
		query.append("                                  WHEN NOT EXISTS (SELECT 1 FROM BKG_CHG_RT BCR, AGT_CNTR_PERTP_MPG_V PET" ).append("\n"); 
		query.append("                                                   WHERE BCR.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("                                                     AND BCR.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                     AND (BCR.RAT_UT_CD = PET.REP_TP OR BCR.RAT_UT_CD = PET.CNTR_TP)" ).append("\n"); 
		query.append("                                                     AND (CASE WHEN BCR.CHG_CD IN ('OTH', 'CYR', 'OPS') THEN 'OTH'" ).append("\n"); 
		query.append("                                                               WHEN BCR.CHG_CD IN ('DTH', 'CYC', 'CYD', 'DDC', 'DPS') THEN 'DTH'" ).append("\n"); 
		query.append("                                                               ELSE BCR.CHG_CD" ).append("\n"); 
		query.append("                                                          END" ).append("\n"); 
		query.append("                                                         )" ).append("\n"); 
		query.append("                                                         IN" ).append("\n"); 
		query.append("                                                         (CASE WHEN R.CHG_CD IN ('OTH', 'CYR', 'OPS') THEN 'OTH'" ).append("\n"); 
		query.append("                                                               WHEN R.CHG_CD IN ('DTH', 'CYC', 'CYD', 'DDC', 'DPS') THEN 'DTH'" ).append("\n"); 
		query.append("                                                               ELSE R.CHG_CD" ).append("\n"); 
		query.append("                                                          END" ).append("\n"); 
		query.append("                                                         )" ).append("\n"); 
		query.append("                                                  )" ).append("\n"); 
		query.append("                                    THEN 'TRUE'" ).append("\n"); 
		query.append("                             END" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("      ) A" ).append("\n"); 
		query.append(") M" ).append("\n"); 
		query.append("WHERE RN = 1" ).append("\n"); 

	}
}