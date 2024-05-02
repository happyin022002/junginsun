/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementRegistrationDBDAOAgreementListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementRegistrationDBDAOAgreementListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement List Search
	  * </pre>
	  */
	public AgreementRegistrationDBDAOAgreementListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("exp_from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_pay_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration").append("\n"); 
		query.append("FileName : AgreementRegistrationDBDAOAgreementListRSQL").append("\n"); 
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
		query.append("WITH PARAM" ).append("\n"); 
		query.append("AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("         , LA.AGMT_SEQ" ).append("\n"); 
		query.append("		, LA.LSE_PAY_TP_CD" ).append("\n"); 
		query.append("         , LA.LSTM_CD" ).append("\n"); 
		query.append("         , (SELECT SUBSTR(MC.CNTR_SPEC_NO, 1, 4)" ).append("\n"); 
		query.append("              FROM MST_CONTAINER MC" ).append("\n"); 
		query.append("             WHERE MC.AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("               AND MC.AGMT_SEQ    = LA.AGMT_SEQ" ).append("\n"); 
		query.append("               AND ROWNUM         = 1) AS YEAR_BUILT" ).append("\n"); 
		query.append("         , LA.SLB_FLG" ).append("\n"); 
		query.append("       FROM  LSE_AGREEMENT LA" ).append("\n"); 
		query.append("   WHERE  1 = 1" ).append("\n"); 
		query.append("#if ( ${ofc_cd} != '' )" ).append("\n"); 
		query.append("    AND  LA.OFC_CD        = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${lse_pay_tp_cd} != 'ALL' )" ).append("\n"); 
		query.append("    AND  LA.LSE_PAY_TP_CD = @[lse_pay_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${lstm_cd} != '' )" ).append("\n"); 
		query.append("       #if ( $lstm_cd_seq.size() > 1 )" ).append("\n"); 
		query.append("       AND    LA.LSTM_CD IN (" ).append("\n"); 
		query.append("             #foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("                    #if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("                                                                                      '$key'," ).append("\n"); 
		query.append("                    #else" ).append("\n"); 
		query.append("                                                                                      '$key'" ).append("\n"); 
		query.append("                    #end" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("                                                                                     )" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("        AND    LA.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${vndr_seq} != '' )" ).append("\n"); 
		query.append("      AND    LA.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND LA.LST_EXP_DT        BETWEEN TO_DATE(@[exp_from_dt], 'YYYYMMDD') AND TO_DATE(@[exp_to_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("     AND LA.LSTM_CD IN ('OW' , 'LP' , 'OL', 'LT', 'ST', 'OF', 'SI', 'SO', 'MI', 'MO', 'SH')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT MAX(LA.LSTM_CD) AS LSTM_CD" ).append("\n"); 
		query.append("     , MAX(NVL(SUBSTR (MV.VNDR_ABBR_NM, 0, 3), ' ')) AS VNDR_ABBR_NM" ).append("\n"); 
		query.append("     , LA.AGMT_CTY_CD || LPAD (LA.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("	, LA.LSE_PAY_TP_CD" ).append("\n"); 
		query.append("     , MAX(LA.REF_NO) AS REF_NO" ).append("\n"); 
		query.append("     , TO_CHAR (MAX(VER.EFF_DT), 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR (MAX(LA.LST_EXP_DT), 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("     , MIN((SELECT P.YEAR_BUILT FROM PARAM P WHERE P.AGMT_CTY_CD = LA.AGMT_CTY_CD AND P.AGMT_SEQ = LA.AGMT_SEQ AND ROWNUM = 1)) AS YEAR_BUILT" ).append("\n"); 
		query.append("     , TO_CHAR (MAX (LA.BLD_UP_DT), 'YYYY-MM-DD') AS EFFECTIVE_DT" ).append("\n"); 
		query.append("     , TO_CHAR (MAX (ADD_MONTHS (LA.LST_EXP_DT" ).append("\n"); 
		query.append("                               , (SELECT AR.AGMT_CHG_VAL" ).append("\n"); 
		query.append("                                    FROM LSE_AGMT_RT AR" ).append("\n"); 
		query.append("                                   WHERE AR.CNTR_RNTL_CHG_TP_CD = 'PNTV'" ).append("\n"); 
		query.append("                                     AND LA.AGMT_SEQ = AR.AGMT_SEQ" ).append("\n"); 
		query.append("                                     AND LA.AGMT_CTY_CD = AR.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                     AND ROWNUM = 1)))" ).append("\n"); 
		query.append("              , 'YYYY-MM-DD')" ).append("\n"); 
		query.append("          AS EXPIRY_DT" ).append("\n"); 
		query.append("     , MAX (LA.SLB_FLG) AS SLB_FLG" ).append("\n"); 
		query.append("     , MAX (LA.LSTM_CD) AS LEASE_TERM" ).append("\n"); 
		query.append("     , MAX (LA.LSE_PAY_TERM_DYS) AS PAYMENT_TERM" ).append("\n"); 
		query.append("     , MAX (LA.DPC_RTO) AS YEARLY_DEPR" ).append("\n"); 
		query.append("     , MAX (LA.MAX_DPC_RTO) AS MAX_DEPR" ).append("\n"); 
		query.append("     , SUBSTR(TYPE_NM, 4, 100) TYPE_NM" ).append("\n"); 
		query.append("     , SUB.EQ_LOC_TP_CD AS EQ_LOC_TP_CD" ).append("\n"); 
		query.append("     , SUB.LOC_CD AS LOC_CD" ).append("\n"); 
		query.append("     , 0 " ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("       +  SUM(DECODE(SUB.CNTR_TPSZ_CD, '$key', SUB.VAL, 0))" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("       AS TTL" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("#set ($col_name='CNTR'+$velocityCount+'_QTY')" ).append("\n"); 
		query.append("     , SUM(DECODE(SUB.CNTR_TPSZ_CD, '$key', SUB.VAL, 0)) AS $col_name" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("                 AGMT_CTY_CD" ).append("\n"); 
		query.append("               , AGMT_SEQ" ).append("\n"); 
		query.append("			  , LSE_PAY_TP_CD" ).append("\n"); 
		query.append("               , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("               , DECODE(LVL, 1, '01.Contract QTY', 2, '02.Off-hire QTY', 3, '03.Current QTY', '04.Replacement Value') TYPE_NM" ).append("\n"); 
		query.append("               , ' ' EQ_LOC_TP_CD" ).append("\n"); 
		query.append("               , ' ' LOC_CD" ).append("\n"); 
		query.append("               , SUM(DECODE(LVL, 1, CON_CNT" ).append("\n"); 
		query.append("                                      , 2, LSO_CNT" ).append("\n"); 
		query.append("                                      , 3, CURR_CNT" ).append("\n"); 
		query.append("                                      , 4, REP_CNT" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                      ) VAL" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                    SELECT" ).append("\n"); 
		query.append("                               AR.AGMT_CTY_CD" ).append("\n"); 
		query.append("                             , AR.AGMT_SEQ" ).append("\n"); 
		query.append("							, P.LSE_PAY_TP_CD" ).append("\n"); 
		query.append("                             , AR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , MIN (CNTR.ONH_DT) AS ONH_DT" ).append("\n"); 
		query.append("                             , COUNT (LSI.CNTR_STS_EVNT_DT) AS LSI_CNT" ).append("\n"); 
		query.append("                             , COUNT (LSO.CNTR_STS_EVNT_DT) AS LSO_CNT" ).append("\n"); 
		query.append("                             ,   COUNT (LSI.CNTR_STS_EVNT_DT)" ).append("\n"); 
		query.append("                               - COUNT (LSO.CNTR_STS_EVNT_DT)" ).append("\n"); 
		query.append("                                  AS CURR_CNT" ).append("\n"); 
		query.append("                             , MAX (AR.N1ST_CHG_AMT) AS REP_CNT" ).append("\n"); 
		query.append("                             , MAX (AR.AGMT_CHG_VAL) AS CON_CNT" ).append("\n"); 
		query.append("                          FROM LSE_AGMT_RT AR" ).append("\n"); 
		query.append("                             , MST_CNTR_STS_HIS LSI" ).append("\n"); 
		query.append("                             , MST_CNTR_STS_HIS LSO" ).append("\n"); 
		query.append("                             , MST_CONTAINER CNTR" ).append("\n"); 
		query.append("                             , PARAM P" ).append("\n"); 
		query.append("                         WHERE 1 = 1" ).append("\n"); 
		query.append("                           AND P.AGMT_SEQ    = AR.AGMT_SEQ" ).append("\n"); 
		query.append("                           AND P.AGMT_CTY_CD = AR.AGMT_CTY_CD" ).append("\n"); 
		query.append("                           AND AR.CNTR_RNTL_CHG_TP_CD = 'GENV'" ).append("\n"); 
		query.append("                           AND AR.AGMT_SEQ = CNTR.AGMT_SEQ(+)" ).append("\n"); 
		query.append("                           AND AR.AGMT_CTY_CD = CNTR.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("                           AND AR.CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("                           AND CNTR.AGMT_SEQ = LSI.AGMT_SEQ(+)" ).append("\n"); 
		query.append("                           AND CNTR.AGMT_CTY_CD = LSI.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("                           AND CNTR.CNTR_NO = LSI.CNTR_NO(+)" ).append("\n"); 
		query.append("                           AND LSI.CNTR_STS_CD(+) IN ('OWN', 'LSI', 'DII')" ).append("\n"); 
		query.append("                           AND LSI.CNTR_NO = LSO.CNTR_NO(+)" ).append("\n"); 
		query.append("                           AND LSI.CNTR_STS_SEQ = LSO.PRNR_STS_SEQ(+)" ).append("\n"); 
		query.append("                        GROUP BY AR.AGMT_CTY_CD" ).append("\n"); 
		query.append("                               , AR.AGMT_SEQ" ).append("\n"); 
		query.append("							, P.LSE_PAY_TP_CD" ).append("\n"); 
		query.append("                               , AR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   ) SUB" ).append("\n"); 
		query.append("             ,( SELECT LEVEL LVL FROM DUAL CONNECT BY LEVEL <= 4 ) LVL " ).append("\n"); 
		query.append("        GROUP BY AGMT_CTY_CD" ).append("\n"); 
		query.append("               , AGMT_SEQ" ).append("\n"); 
		query.append("			, LSE_PAY_TP_CD" ).append("\n"); 
		query.append("               , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("               , DECODE(LVL, 1, '01.Contract QTY', 2, '02.Off-hire QTY', 3, '03.Current QTY', '04.Replacement Value')" ).append("\n"); 
		query.append("        UNION ALL       " ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("                   AR.AGMT_CTY_CD   AS AGMT_CTY_CD" ).append("\n"); 
		query.append("                 , AR.AGMT_SEQ      AS AGMT_SEQ" ).append("\n"); 
		query.append("				, P.LSE_PAY_TP_CD AS LSE_PAY_TP_CD" ).append("\n"); 
		query.append("                 , AR.CNTR_TPSZ_CD    AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                 , '05.Per-Diem'         AS TYPE_NM" ).append("\n"); 
		query.append("                 , DECODE(P.LSTM_CD, 'LT', COMMCODE_PKG.GET_COMDTL_NAME_FNC ('CD30026', AR.EQ_LOC_TP_CD), 'No.') AS EQ_LOC_TP_CD" ).append("\n"); 
		query.append("                 , DECODE(P.LSTM_CD, 'LT', AR.LOC_CD, TO_CHAR(AGMT_CHG_VAL))  AS LOC_CD" ).append("\n"); 
		query.append("                 , MAX(N1ST_CHG_AMT) VAL" ).append("\n"); 
		query.append("              FROM PARAM P" ).append("\n"); 
		query.append("                 , LSE_AGMT_RT AR" ).append("\n"); 
		query.append("             WHERE 1 = 1" ).append("\n"); 
		query.append("               AND P.AGMT_SEQ    = AR.AGMT_SEQ" ).append("\n"); 
		query.append("               AND P.AGMT_CTY_CD = AR.AGMT_CTY_CD" ).append("\n"); 
		query.append("               AND AR.CNTR_RNTL_CHG_TP_CD = 'PDGV'" ).append("\n"); 
		query.append("            GROUP BY AR.AGMT_CTY_CD" ).append("\n"); 
		query.append("                   , AR.AGMT_SEQ" ).append("\n"); 
		query.append("				, P.LSE_PAY_TP_CD" ).append("\n"); 
		query.append("                   , AR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   , DECODE(P.LSTM_CD, 'LT', COMMCODE_PKG.GET_COMDTL_NAME_FNC ('CD30026', AR.EQ_LOC_TP_CD), 'No.')" ).append("\n"); 
		query.append("                   , DECODE(P.LSTM_CD, 'LT', AR.LOC_CD, TO_CHAR(AGMT_CHG_VAL))" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("                   AR.AGMT_CTY_CD   AS AGMT_CTY_CD" ).append("\n"); 
		query.append("                 , AR.AGMT_SEQ      AS AGMT_SEQ" ).append("\n"); 
		query.append("				, P.LSE_PAY_TP_CD AS LSE_PAY_TP_CD" ).append("\n"); 
		query.append("                 , AR.CNTR_TPSZ_CD    AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                 , DECODE(LVL, 1, '06.DPP coverage amt' , '07.DPP lumpsum rate')        AS TYPE_NM" ).append("\n"); 
		query.append("                 , COMMCODE_PKG.GET_COMDTL_NAME_FNC ('CD30026', AR.EQ_LOC_TP_CD) AS EQ_LOC_TP_CD" ).append("\n"); 
		query.append("                 , AR.LOC_CD  AS LOC_CD" ).append("\n"); 
		query.append("                 , MAX(DECODE(LVL, 1, AR.N1ST_CHG_AMT, AR.AGMT_CHG_VAL))" ).append("\n"); 
		query.append("              FROM PARAM P" ).append("\n"); 
		query.append("                 , LSE_AGMT_RT AR" ).append("\n"); 
		query.append("                 , ( SELECT LEVEL LVL FROM DUAL CONNECT BY LEVEL <= 2 ) LVL" ).append("\n"); 
		query.append("             WHERE 1 = 1" ).append("\n"); 
		query.append("               AND P.AGMT_SEQ    = AR.AGMT_SEQ" ).append("\n"); 
		query.append("               AND P.AGMT_CTY_CD = AR.AGMT_CTY_CD" ).append("\n"); 
		query.append("               AND AR.CNTR_RNTL_CHG_TP_CD = 'DPPV'" ).append("\n"); 
		query.append("            GROUP BY AR.AGMT_CTY_CD" ).append("\n"); 
		query.append("                   , AR.AGMT_SEQ" ).append("\n"); 
		query.append("				, P.LSE_PAY_TP_CD" ).append("\n"); 
		query.append("                   , AR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   , DECODE(LVL, 1, '06.DPP coverage amt' , '07.DPP lumpsum rate') " ).append("\n"); 
		query.append("                   , COMMCODE_PKG.GET_COMDTL_NAME_FNC ('CD30026', AR.EQ_LOC_TP_CD)" ).append("\n"); 
		query.append("                   , AR.LOC_CD" ).append("\n"); 
		query.append("       ) SUB, MDM_VENDOR MV, LSE_AGREEMENT LA, LSE_AGMT_VER VER" ).append("\n"); 
		query.append("WHERE LA.VNDR_SEQ    = MV.VNDR_SEQ" ).append("\n"); 
		query.append("AND   SUB.AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND   SUB.AGMT_SEQ    = LA.AGMT_SEQ" ).append("\n"); 
		query.append("AND   SUB.AGMT_CTY_CD = VER.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("AND   SUB.AGMT_SEQ = VER.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND   VER.AGMT_VER_SEQ(+) = 1" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND    SUB.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("       #foreach($key IN ${cntr_tpsz_cd_seq2})" ).append("\n"); 
		query.append("             #if($velocityCount < $cntr_tpsz_cd_seq2.size())" ).append("\n"); 
		query.append("                                                                                      '$key'," ).append("\n"); 
		query.append("             #else" ).append("\n"); 
		query.append("                                                                                      '$key'" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("                                                                                     )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("       LA.AGMT_CTY_CD || LPAD (LA.AGMT_SEQ, 6, '0')" ).append("\n"); 
		query.append("     , SUB.TYPE_NM" ).append("\n"); 
		query.append("	, LA.LSE_PAY_TP_CD" ).append("\n"); 
		query.append("     , SUB.EQ_LOC_TP_CD" ).append("\n"); 
		query.append("     , SUB.LOC_CD" ).append("\n"); 
		query.append("ORDER BY 2" ).append("\n"); 
		query.append("       , LA.AGMT_CTY_CD || LPAD (LA.AGMT_SEQ, 6, '0')" ).append("\n"); 
		query.append("       , SUB.TYPE_NM" ).append("\n"); 
		query.append("       , SUB.EQ_LOC_TP_CD" ).append("\n"); 
		query.append("       , SUB.LOC_CD" ).append("\n"); 

	}
}