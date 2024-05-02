/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchZPPoolEstimateAmtFromMASDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchZPPoolEstimateAmtFromMASDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * --Calculation 기능 Batch로 전환 -- 2015.10.30부로 사용치 않음
	  * [EES_CGM_1225] NP(ZP) Pool Chassis Estimated Expense Input : Calculation
	  * 
	  * 임동빈 부장님과의 협의 내용
	  * 01.
	  * METP(POOL_CD)의 USNYC(SCC_CD)는 USNYCM3(NODE_CD)를 제외하고
	  * NRPP(POOL_CD)의 USNYC(SCC_CD)는 USNYCM3(NODE_CD)만 포함한다.
	  * 02.
	  * HRCP는 HRPC의 모든 SCC를, TPSP는 LABP;LAGP;GACP의 모든 SCC를, TPNP는 PNWP;RPPN의 모든 SCC를, CICP는 BCCP;KACP의 모든 SCC 가지고 있음
	  * HRPC는 HRCP에, LABP;LAGP;GACP는 TPSP에, RPPN;PNWP는 TPNP에, BCCP;KACP는 CICP에 모든금액 귀속
	  * 따라서 HRPC, LABP, LAGP, GACP, RPPN, BCCP, KACP는 0으로 조회함
	  * GCCP는 GRPP의 SCC를 뺀 나머지 USLRD, USSAT로만 조회
	  * MWCP는 MWRP의 SCC를 뺀 나머지 USKCK, USMKC, USSTL로만 조회
	  * 03.
	  * USMIA - SACP Pool - USSAV 단가로 대체
	  * USPBF - MWCP Pool - USMEM 단가로 대체
	  * USLWS - TPNP Pool - USPDX 단가로 대체
	  * USTUS - TPSP Pool - USPHX 단가로 대체
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchZPPoolEstimateAmtFromMASDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchZPPoolEstimateAmtFromMASDataRSQL").append("\n"); 
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
		query.append("SELECT 'I' AS ibflag ," ).append("\n"); 
		query.append("  AA.MONTH AS MONTH ," ).append("\n"); 
		query.append("  AA.MONTH_NM AS MONTH_NM ," ).append("\n"); 
		query.append("  AA.MONTH AS ESTM_YRMON ," ).append("\n"); 
		query.append("  EE.AGMT_OFC_CTY_CD ," ).append("\n"); 
		query.append("  EE.AGMT_SEQ ," ).append("\n"); 
		query.append("  @[chss_pool_tp_cd] AS CHSS_POOL_TP_CD ," ).append("\n"); 
		query.append("  @[chss_pool_cd] AS CHSS_POOL_CD ," ).append("\n"); 
		query.append("  'USD' AS CURR_CD ," ).append("\n"); 
		query.append("#if(${chss_pool_cd} == 'HRPC' || ${chss_pool_cd} == 'LABP' || ${chss_pool_cd} == 'LAGP' || ${chss_pool_cd} == 'GACP' || ${chss_pool_cd} == 'RPPN' || ${chss_pool_cd} == 'KACP' || ${chss_pool_cd} == 'BCCP' || ${chss_pool_cd} == 'PNWP')" ).append("\n"); 
		query.append("-- HRCP는 HRPC의 모든 SCC를, TPSP는 LABP;LAGP;GACP의 모든 SCC를, TPNP는 PNWP;RPPN의 모든 SCC를, BCCP는 KACP;CICP의 모든 SCC 가지고 있음" ).append("\n"); 
		query.append("-- HRPC는 HRCP에, LABP;LAGP;GACP는 TPSP에, RPPN;PNWP는 TPNP에, KACP;CICP는 BCCP에 모든금액 귀속" ).append("\n"); 
		query.append("-- 따라서 HRPC, LABP, LAGP, GACP, RPPN, KACP, CICP는 0으로 조회함" ).append("\n"); 
		query.append("  0 AS ESTM_AMT ," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  NVL(BB.ESTM_AMT, 0) AS ESTM_AMT ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  NVL(CC.INV_SMRY_AMT, 0) AS INV_SMRY_AMT ," ).append("\n"); 
		query.append("  0 AS ESTM_AMT_FX_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT @[year] || LPAD(ROWNUM, 2, '0') MONTH ," ).append("\n"); 
		query.append("      DECODE (ROWNUM, 1, 'Jan', 2, 'Feb', 3, 'Mar', 4, 'Apr', 5, 'MAY', 6, 'Jun' , 7, 'Jul', 8, 'Aug', 9, 'Sep', 10, 'Oct', 11, 'Nov', 12, 'Dec') MONTH_NM" ).append("\n"); 
		query.append("    FROM DUAL A CONNECT BY LEVEL<='12') AA ," ).append("\n"); 
		query.append("   (" ).append("\n"); 
		query.append("    SELECT P.ESTM_YRMON" ).append("\n"); 
		query.append("         , MAX(P.CHSS_POOL_CD)" ).append("\n"); 
		query.append("         , MAX(P.ESTM_AMT) +" ).append("\n"); 
		query.append("         #if(${chss_pool_cd} == 'SACP' || ${chss_pool_cd} == 'MWCP' || ${chss_pool_cd} == 'TPNP' || ${chss_pool_cd} == 'TPSP') " ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            select nvl(sum(DD.COST_TTL_AMT), 0)" ).append("\n"); 
		query.append("              from MAS_DMDT_COST_RPT_BKG_DTL DD" ).append("\n"); 
		query.append("                 , MAS_BKG_EXPN_DTL EE" ).append("\n"); 
		query.append("             where 1=1" ).append("\n"); 
		query.append("               and DD.BKG_NO = EE.BKG_NO" ).append("\n"); 
		query.append("            #if(${chss_pool_cd} == 'SACP')" ).append("\n"); 
		query.append("            -- USMIA - SACP Pool - USSAV 단가로 대체" ).append("\n"); 
		query.append("               and MAS_LOC_FNC(DD.CNTR_FM_NOD_CD, 'SCC') = 'USMIA'" ).append("\n"); 
		query.append("            #elseif(${chss_pool_cd} == 'MWCP')" ).append("\n"); 
		query.append("            -- USPBF - MWCP Pool - USMEM 단가로 대체" ).append("\n"); 
		query.append("               and MAS_LOC_FNC(DD.CNTR_FM_NOD_CD, 'SCC') = 'USPBF'" ).append("\n"); 
		query.append("            #elseif(${chss_pool_cd} == 'TPNP')" ).append("\n"); 
		query.append("            -- USLWS - TPNP Pool - USPDX 단가로 대체" ).append("\n"); 
		query.append("               and MAS_LOC_FNC(DD.CNTR_FM_NOD_CD, 'SCC') = 'USLWS'" ).append("\n"); 
		query.append("            #elseif(${chss_pool_cd} == 'TPSP')" ).append("\n"); 
		query.append("            -- USTUS - TPSP Pool - USPHX 단가로 대체" ).append("\n"); 
		query.append("               and MAS_LOC_FNC(DD.CNTR_FM_NOD_CD, 'SCC') = 'USTUS'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("               and DD.ITM_NM like '%CHSS%'                                                                   -- MAS_DMT_COST_RPT_DTL_PRC의 chassis 비용 산출 기준" ).append("\n"); 
		query.append("--               and DD.CNTR_FM_NOD_CD like 'US%'" ).append("\n"); 
		query.append("--               and (MAS_LOC_FNC(DD.POR_CD, 'SCC') like 'US%' or MAS_LOC_FNC(DD.DEL_CD, 'SCC') like 'US%')" ).append("\n"); 
		query.append("               and EE.COST_YRMON = P.ESTM_YRMON" ).append("\n"); 
		query.append("           ) " ).append("\n"); 
		query.append("         #else 0" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("           AS ESTM_AMT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT E.COST_YRMON AS ESTM_YRMON" ).append("\n"); 
		query.append("             , MAX(A.CHSS_POOL_CD) AS CHSS_POOL_CD" ).append("\n"); 
		query.append("             , SUM(D.COST_TTL_AMT) AS ESTM_AMT" ).append("\n"); 
		query.append("        FROM CGM_AGREEMENT A" ).append("\n"); 
		query.append("           , CGM_AGMT_CPS_RT B" ).append("\n"); 
		query.append("           , MAS_DMDT_COST_RPT_BKG_DTL D" ).append("\n"); 
		query.append("           , MAS_BKG_EXPN_DTL E" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND A.AGMT_SEQ        = B.AGMT_SEQ" ).append("\n"); 
		query.append("        AND A.AGMT_VER_NO     = B.AGMT_VER_NO" ).append("\n"); 
		query.append("        AND A.EQ_KND_CD         = 'Z'" ).append("\n"); 
		query.append("        AND A.AGMT_LSTM_CD      = 'ZP'" ).append("\n"); 
		query.append("        AND A.LST_VER_FLG       = 'Y'" ).append("\n"); 
		query.append("        AND A.CHSS_POOL_CD      = @[chss_pool_cd]" ).append("\n"); 
		query.append("--     METP(POOL_CD)의 USNYC(SCC_CD)는 USNYCM3(NODE_CD)를 제외" ).append("\n"); 
		query.append("--     NRPP(POOL_CD)의 USNYC(SCC_CD)는 USNYCM3(NODE_CD)만 포함" ).append("\n"); 
		query.append("--     GCCP는 GRPP의 SCC를 뺀 나머지 USLRD, USSAT로만 조회" ).append("\n"); 
		query.append("--     MWCP는 MWRP의 SCC를 뺀 나머지 USKCK, USMKC, USSTL로만 조회" ).append("\n"); 
		query.append("    #if(${chss_pool_cd} == 'METP')" ).append("\n"); 
		query.append("        AND D.CNTR_FM_NOD_CD <> 'USNYCM3'" ).append("\n"); 
		query.append("    #elseif(${chss_pool_cd} == 'NRPP')" ).append("\n"); 
		query.append("        AND D.CNTR_FM_NOD_CD = 'USNYCM3'" ).append("\n"); 
		query.append("    #elseif(${chss_pool_cd} == 'GCCP')" ).append("\n"); 
		query.append("        AND MAS_LOC_FNC(D.CNTR_FM_NOD_CD, 'SCC') not in" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        select B.LOC_CD" ).append("\n"); 
		query.append("        FROM CGM_AGREEMENT A" ).append("\n"); 
		query.append("           , CGM_AGMT_CPS_RT B" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND A.AGMT_SEQ        = B.AGMT_SEQ" ).append("\n"); 
		query.append("        AND A.AGMT_VER_NO     = B.AGMT_VER_NO" ).append("\n"); 
		query.append("        AND A.EQ_KND_CD         = 'Z'" ).append("\n"); 
		query.append("        AND A.AGMT_LSTM_CD      = 'ZP'" ).append("\n"); 
		query.append("        AND A.LST_VER_FLG       = 'Y'" ).append("\n"); 
		query.append("        AND A.CHSS_POOL_CD      = 'GRPP'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #elseif(${chss_pool_cd} == 'MWCP')" ).append("\n"); 
		query.append("        AND MAS_LOC_FNC(D.CNTR_FM_NOD_CD, 'SCC') not in" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        select B.LOC_CD" ).append("\n"); 
		query.append("        FROM CGM_AGREEMENT A" ).append("\n"); 
		query.append("           , CGM_AGMT_CPS_RT B" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND A.AGMT_SEQ        = B.AGMT_SEQ" ).append("\n"); 
		query.append("        AND A.AGMT_VER_NO     = B.AGMT_VER_NO" ).append("\n"); 
		query.append("        AND A.EQ_KND_CD         = 'Z'" ).append("\n"); 
		query.append("        AND A.AGMT_LSTM_CD      = 'ZP'" ).append("\n"); 
		query.append("        AND A.LST_VER_FLG       = 'Y'" ).append("\n"); 
		query.append("        AND A.CHSS_POOL_CD      = 'MWRP'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        AND D.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("        AND MAS_LOC_FNC(D.CNTR_FM_NOD_CD, 'SCC') = B.LOC_CD" ).append("\n"); 
		query.append("        AND D.ITM_NM LIKE '%CHSS%'                                                                  -- MAS_DMT_COST_RPT_DTL_PRC의 chassis 비용 산출 기준" ).append("\n"); 
		query.append("--        AND D.CNTR_FM_NOD_CD LIKE 'US%'" ).append("\n"); 
		query.append("--        AND (MAS_LOC_FNC(D.POR_CD, 'SCC') LIKE 'US%' OR MAS_LOC_FNC(D.DEL_CD, 'SCC') LIKE 'US%')" ).append("\n"); 
		query.append("        AND E.COST_YRMON LIKE @[year] || '%'" ).append("\n"); 
		query.append("        GROUP BY E.COST_YRMON" ).append("\n"); 
		query.append("    ) P" ).append("\n"); 
		query.append("    GROUP BY P.ESTM_YRMON" ).append("\n"); 
		query.append("    ) BB," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT A.COST_YRMON, A.AGMT_OFC_CTY_CD, A.AGMT_SEQ, NVL(SUM(B.INV_TTL_AMT), 0) INV_SMRY_AMT " ).append("\n"); 
		query.append("    FROM CGM_PAY_INV A, AP_PAY_INV B, AP_INV_HDR C" ).append("\n"); 
		query.append("    WHERE A.INV_RGST_NO = B.INV_RGST_NO " ).append("\n"); 
		query.append("    AND B.CSR_NO = C.CSR_NO" ).append("\n"); 
		query.append("    AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND A.CHSS_MGST_INV_KND_CD = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("    AND A.COST_YRMON LIKE @[year] || '%'" ).append("\n"); 
		query.append("    AND A.CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("    AND B.INV_STS_CD IN ('D','P')" ).append("\n"); 
		query.append("    GROUP BY  A.COST_YRMON,A.AGMT_OFC_CTY_CD, A.AGMT_SEQ " ).append("\n"); 
		query.append("    ) CC" ).append("\n"); 
		query.append("    ," ).append("\n"); 
		query.append("    (SELECT AGMT_OFC_CTY_CD, AGMT_SEQ FROM CGM_AGREEMENT" ).append("\n"); 
		query.append("    WHERE CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("    AND AGMT_LSTM_CD = @[chss_pool_tp_cd]" ).append("\n"); 
		query.append("    AND ROWNUM=1" ).append("\n"); 
		query.append("    ) EE" ).append("\n"); 
		query.append("WHERE AA.MONTH = BB.ESTM_YRMON (+)" ).append("\n"); 
		query.append("AND AA.MONTH = CC.COST_YRMON(+)" ).append("\n"); 
		query.append("ORDER BY AA.MONTH" ).append("\n"); 

	}
}