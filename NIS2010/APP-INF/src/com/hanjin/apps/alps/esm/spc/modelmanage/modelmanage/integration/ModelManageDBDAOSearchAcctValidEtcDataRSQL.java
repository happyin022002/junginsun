/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : ModelManageDBDAOSearchAcctValidEtcDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.07
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.09.07 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOSearchAcctValidEtcDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_SPC_0095 : ONCHANGE
	  * Acct. Add 후 Account, SC, RFA 입력 시 해당 계약의 유효성 체크 및  MVC, C.OFC 조회해온다
	  * 
	  * 2015.12.29 이혜민 선반영 SMP 저장로직 변경 및 입력 날짜 기준 +30일(한달) 내 effective date를 보유한 RFA/SC시 import 가능토록 변경
	  * </pre>
	  */
	public ModelManageDBDAOSearchAcctValidEtcDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOSearchAcctValidEtcDataRSQL").append("\n"); 
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
		query.append("#if (${trade} == 'TPS' || ((${trade} == 'AES' || ${trade} == 'IAS') && (${sc_no} != '' || ${rfa_no} != '')))" ).append("\n"); 
		query.append("SELECT CUST_CD||'|'||CUST_GRP_ID||'|'||WK_MQC_QTY||'|'||CTRT_OFC_CD AS acctData" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("        SELECT DISTINCT" ).append("\n"); 
		query.append("               H.SC_NO" ).append("\n"); 
		query.append("             , '' AS RFA_NO" ).append("\n"); 
		query.append("             , DECODE(M.REAL_CUST_CNT_CD , NULL, D.CUST_CNT_CD||TO_CHAR(D.CUST_SEQ, 'FM000000') , M.REAL_CUST_CNT_CD||TO_CHAR(M.REAL_CUST_SEQ, 'FM000000') ) AS CUST_CD" ).append("\n"); 
		query.append("             , G.CUST_GRP_ID" ).append("\n"); 
		query.append("             , ROUND ( ( DECODE ( M.PROP_STS_CD, 'F', MQC.FNL_MQC_QTY, 'A', MQC.FNL_MQC_QTY, MQC.PROP_MQC_QTY ) / ( SD.CTRT_EXP_DT - SD.CTRT_EFF_DT ) ) * 7 * DECODE(MQC.CNTR_LOD_UT_CD, 'T', 1, 2), 0 ) AS WK_MQC_QTY" ).append("\n"); 
		query.append("             , (SELECT MAX(OFC_CD) AS CTRT_OFC_CD" ).append("\n"); 
		query.append("                FROM MDM_CUSTOMER M" ).append("\n"); 
		query.append("                WHERE M.CUST_CNT_CD = D.CUST_CNT_CD" ).append("\n"); 
		query.append("                AND   M.CUST_SEQ	= D.CUST_SEQ ) AS CTRT_OFC_CD" ).append("\n"); 
		query.append("          FROM PRI_SP_MN M" ).append("\n"); 
		query.append("             , PRI_SP_CTRT_PTY D" ).append("\n"); 
		query.append("             , PRI_SP_HDR H" ).append("\n"); 
		query.append("             , PRI_SP_MQC MQC" ).append("\n"); 
		query.append("             , PRI_SP_DUR SD" ).append("\n"); 
		query.append("             , MDM_CUSTOMER I" ).append("\n"); 
		query.append("             , MDM_CUST_PERF_GRP G" ).append("\n"); 
		query.append("         WHERE M.PROP_STS_CD        = 'F'" ).append("\n"); 
		query.append("           AND M.PROP_NO            = D.PROP_NO" ).append("\n"); 
		query.append("           AND M.AMDT_SEQ           = D.AMDT_SEQ" ).append("\n"); 
		query.append("           AND H.PROP_NO            = D.PROP_NO" ).append("\n"); 
		query.append("           AND M.PROP_NO            = MQC.PROP_NO" ).append("\n"); 
		query.append("           AND M.AMDT_SEQ           = MQC.AMDT_SEQ" ).append("\n"); 
		query.append("           AND M.PROP_NO            = SD.PROP_NO" ).append("\n"); 
		query.append("           AND M.AMDT_SEQ           = SD.AMDT_SEQ" ).append("\n"); 
		query.append("           AND I.CUST_CNT_CD        = D.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND I.CUST_SEQ           = D.CUST_SEQ" ).append("\n"); 
		query.append("           AND I.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("           AND I.CUST_GRP_ID        = G.CUST_GRP_ID(+)" ).append("\n"); 
		query.append("           AND D.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("           AND H.SC_NO              = NVL(@[sc_no], @[rfa_no])" ).append("\n"); 
		query.append("           AND M.AMDT_SEQ           = (SELECT MAX(AMDT_SEQ) FROM PRI_SP_MN K" ).append("\n"); 
		query.append("                                        WHERE K.PROP_NO = M.PROP_NO" ).append("\n"); 
		query.append("                                          AND K.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("                                          AND ( TRUNC(SYSDATE) BETWEEN K.EFF_DT AND K.EXP_DT" ).append("\n"); 
		query.append("                                             OR TRUNC(SYSDATE+30) BETWEEN K.EFF_DT AND K.EXP_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                OR (" ).append("\n"); 
		query.append("                                                         (SELECT TO_DATE(SLS_FM_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                            FROM MAS_WK_PRD" ).append("\n"); 
		query.append("                                                           WHERE COST_YR||COST_WK = (SELECT DECODE(COST_YRWK, '200001', TO_CHAR(SYSDATE, 'YYYYWW'), PERF_ST_YRWK)" ).append("\n"); 
		query.append("                                                                                       FROM SPC_MDL_VER_MST" ).append("\n"); 
		query.append("                                                                                      WHERE TRD_CD    = @[trade]" ).append("\n"); 
		query.append("                                                                                        AND COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("                                                                                        AND VER_SEQ   = @[ver_seq]   )" ).append("\n"); 
		query.append("                                                         ) < K.EXP_DT+1" ).append("\n"); 
		query.append("                                                     AND" ).append("\n"); 
		query.append("                                                         (SELECT TO_DATE(SLS_TO_DT, 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("                                                            FROM MAS_WK_PRD" ).append("\n"); 
		query.append("                                                           WHERE COST_YR||COST_WK = (SELECT DECODE(COST_YRWK, '200001', TO_CHAR(SYSDATE, 'YYYYWW'), PERF_END_YRWK)" ).append("\n"); 
		query.append("                                                                                       FROM SPC_MDL_VER_MST" ).append("\n"); 
		query.append("                                                                                      WHERE TRD_CD    = @[trade]" ).append("\n"); 
		query.append("                                                                                        AND COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("                                                                                        AND VER_SEQ   = @[ver_seq]   )" ).append("\n"); 
		query.append("                                                         ) > K.EFF_DT" ).append("\n"); 
		query.append("                                                   )" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT DISTINCT" ).append("\n"); 
		query.append("               '' AS SC_NO" ).append("\n"); 
		query.append("             , HDR.RFA_NO" ).append("\n"); 
		query.append("             , MN.CTRT_CUST_CNT_CD||TO_CHAR(MN.CTRT_CUST_SEQ, 'FM000000') AS CUST_CD" ).append("\n"); 
		query.append("             , G.CUST_GRP_ID" ).append("\n"); 
		query.append("             , ROUND(( MN.TGT_MVC_QTY / (DUR.CTRT_EXP_DT - DUR.CTRT_EFF_DT) * 7 * DECODE(NVL(MN.CNTR_LOD_UT_CD, 'T'), 'T', 1, 2)), 0) AS WK_MQC_QTY" ).append("\n"); 
		query.append("             , (SELECT MAX(OFC_CD) AS CTRT_OFC_CD" ).append("\n"); 
		query.append("                FROM MDM_CUSTOMER M" ).append("\n"); 
		query.append("                WHERE M.CUST_CNT_CD = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("                AND   M.CUST_SEQ	= MN.CTRT_CUST_SEQ ) AS CTRT_OFC_CD" ).append("\n"); 
		query.append("          FROM PRI_RP_HDR        HDR" ).append("\n"); 
		query.append("             , PRI_RP_MN         MN" ).append("\n"); 
		query.append("             , PRI_RP_DUR        DUR" ).append("\n"); 
		query.append("             , MDM_CUSTOMER      I" ).append("\n"); 
		query.append("             , MDM_CUST_PERF_GRP G" ).append("\n"); 
		query.append("         WHERE MN.PROP_NO          = HDR.PROP_NO" ).append("\n"); 
		query.append("           AND MN.PROP_NO          = DUR.PROP_NO" ).append("\n"); 
		query.append("           AND MN.AMDT_SEQ         = DUR.AMDT_SEQ" ).append("\n"); 
		query.append("        #if (${trade} == 'AES')" ).append("\n"); 
		query.append("           AND MN.RFA_CTRT_TP_CD   = 'C' -- AES 에서는 Contract 화주만 IAS는 상관없이 모든 화주에 대해서" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("           AND I.CUST_CNT_CD       = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("           AND I.CUST_SEQ          = MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("           AND I.DELT_FLG          = 'N'" ).append("\n"); 
		query.append("           AND I.CUST_GRP_ID       = G.CUST_GRP_ID(+)" ).append("\n"); 
		query.append("           AND HDR.RFA_NO          = @[rfa_no]" ).append("\n"); 
		query.append("           AND MN.AMDT_SEQ         = (SELECT MAX(AMDT_SEQ)" ).append("\n"); 
		query.append("                                        FROM PRI_RP_MN K" ).append("\n"); 
		query.append("                                       WHERE K.PROP_NO     = MN.PROP_NO" ).append("\n"); 
		query.append("                                         AND K.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("                                         AND (    TRUNC(SYSDATE) BETWEEN K.EFF_DT AND K.EXP_DT" ).append("\n"); 
		query.append("                                               OR TRUNC(SYSDATE+30) BETWEEN K.EFF_DT AND K.EXP_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                               OR (" ).append("\n"); 
		query.append("                                                        (SELECT TO_DATE(SLS_FM_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                                                           FROM MAS_WK_PRD" ).append("\n"); 
		query.append("                                                          WHERE COST_YR||COST_WK = (SELECT DECODE(COST_YRWK, '200001', TO_CHAR(SYSDATE, 'YYYYWW'), PERF_ST_YRWK)" ).append("\n"); 
		query.append("                                                                                      FROM SPC_MDL_VER_MST" ).append("\n"); 
		query.append("                                                                                     WHERE TRD_CD    = @[trade]" ).append("\n"); 
		query.append("                                                                                       AND COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("                                                                                       AND VER_SEQ   = @[ver_seq]   )" ).append("\n"); 
		query.append("                                                        ) < K.EXP_DT+1" ).append("\n"); 
		query.append("                                                    AND" ).append("\n"); 
		query.append("                                                        (SELECT TO_DATE(SLS_TO_DT,'YYYYMMDD')+1" ).append("\n"); 
		query.append("                                                           FROM MAS_WK_PRD" ).append("\n"); 
		query.append("                                                          WHERE COST_YR||COST_WK = (SELECT DECODE(COST_YRWK, '200001', TO_CHAR(SYSDATE, 'YYYYWW'), PERF_END_YRWK)" ).append("\n"); 
		query.append("                                                                                      FROM SPC_MDL_VER_MST" ).append("\n"); 
		query.append("                                                                                     WHERE TRD_CD    = @[trade]" ).append("\n"); 
		query.append("                                                                                       AND COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("                                                                                       AND VER_SEQ   = @[ver_seq]   )" ).append("\n"); 
		query.append("                                                        ) > K.EFF_DT" ).append("\n"); 
		query.append("                                                  )" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("     )                                     " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}