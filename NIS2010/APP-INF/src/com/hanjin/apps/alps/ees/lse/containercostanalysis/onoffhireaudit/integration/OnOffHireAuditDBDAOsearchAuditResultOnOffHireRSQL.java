/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OnOffHireAuditDBDAOsearchAuditResultOnOffHireRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2010.01.05 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jin Jun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnOffHireAuditDBDAOsearchAuditResultOnOffHireRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lessor 와 HJS를 비교하여 Concidence Discrepancy HJS Lessor 데이타를 추출한다.
	  * </pre>
	  */
	public OnOffHireAuditDBDAOsearchAuditResultOnOffHireRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_stdt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aud_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_enddt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containercostanalysis.onoffhireaudit.integration").append("\n"); 
		query.append("FileName : OnOffHireAuditDBDAOsearchAuditResultOnOffHireRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("H.AGMT_CTY_CD|| LTRIM(TO_CHAR(H.AGMT_SEQ,'000000')) AGMT_NO ," ).append("\n"); 
		query.append("H.AGMT_CTY_CD                   AGMT_CTY_CD," ).append("\n"); 
		query.append("H.AGMT_SEQ                      AGMT_SEQ," ).append("\n"); 
		query.append("H.LSTM_CD                       LSTM_CD ," ).append("\n"); 
		query.append("H.CNTR_NO                       CNTR_NO ," ).append("\n"); 
		query.append("H.CNTR_TPSZ_CD                  CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("TO_CHAR(H.ONH_DT , 'YYYYMMDD')  ONH_DT ," ).append("\n"); 
		query.append("H.ONH_LOC_CD                    ONH_LOC_CD ," ).append("\n"); 
		query.append("TO_CHAR(H.OFFH_DT ,'YYYYMMDD')  OFFH_DT ," ).append("\n"); 
		query.append("H.OFFH_LOC_CD                   OFFH_LOC_CD ," ).append("\n"); 
		query.append("TO_CHAR(L.LR_ONH_DT, 'YYYYMMDD')   LR_ONH_DT ," ).append("\n"); 
		query.append("L.LR_ONH_LOC_CD                    LR_ONH_LOC_CD ," ).append("\n"); 
		query.append("TO_CHAR(L.LR_OFFH_DT,'YYYYMMDD')   LR_OFFH_DT ," ).append("\n"); 
		query.append("L.LR_OFFH_LOC_CD                   LR_OFFH_LOC_CD ," ).append("\n"); 
		query.append("CASE WHEN H.AGMT_CTY_CD  = L.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND  H.AGMT_SEQ     = L.AGMT_SEQ" ).append("\n"); 
		query.append("AND  H.LSTM_CD      = L.LSTM_CD" ).append("\n"); 
		query.append("AND  H.CNTR_NO      = L.CNTR_NO" ).append("\n"); 
		query.append("AND  H.CNTR_TPSZ_CD = L.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND  H.REF_NO       = L.REF_NO" ).append("\n"); 
		query.append("#if (${agmt_seq} != \"\" )" ).append("\n"); 
		query.append("AND H.AGMT_CTY_CD   = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND H.AGMT_SEQ      = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${audit_tp} == \"N\" )" ).append("\n"); 
		query.append("AND  H.ONH_DT       = L.LR_ONH_DT" ).append("\n"); 
		query.append("AND  H.ONH_LOC_CD   = L.LR_ONH_LOC_CD" ).append("\n"); 
		query.append("#elseif (${audit_tp} == \"F\" )" ).append("\n"); 
		query.append("AND  H.OFFH_DT      = L.LR_OFFH_DT" ).append("\n"); 
		query.append("AND  H.OFFH_LOC_CD  = L.LR_OFFH_LOC_CD" ).append("\n"); 
		query.append("#elseif (${audit_tp} == \"A\" )" ).append("\n"); 
		query.append("AND  DECODE( H.ONH_DT     , ''  , '1' , H.ONH_DT)     = DECODE( L.LR_ONH_DT      , '' , '1' , L.LR_ONH_DT )" ).append("\n"); 
		query.append("AND  DECODE( H.ONH_LOC_CD , ''  , '1' , H.ONH_LOC_CD) = DECODE( L.LR_ONH_LOC_CD  , '' , '1' , L.LR_ONH_LOC_CD )" ).append("\n"); 
		query.append("AND  DECODE( H.OFFH_DT     , '' , '1' , H.OFFH_DT)    = DECODE( L.LR_OFFH_DT     , '' , '1' , L.LR_OFFH_DT )" ).append("\n"); 
		query.append("AND  DECODE( H.OFFH_LOC_CD , '' , '1' , H.OFFH_LOC_CD)= DECODE( L.LR_OFFH_LOC_CD , '' , '1' , L.LR_OFFH_LOC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("then 'C'" ).append("\n"); 
		query.append("WHEN H.AGMT_CTY_CD   = L.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND  H.AGMT_SEQ     = L.AGMT_SEQ" ).append("\n"); 
		query.append("AND  H.LSTM_CD      = L.LSTM_CD" ).append("\n"); 
		query.append("AND  H.CNTR_NO      = L.CNTR_NO" ).append("\n"); 
		query.append("AND  H.CNTR_TPSZ_CD = L.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND  H.REF_NO       = L.REF_NO" ).append("\n"); 
		query.append("#if (${audit_tp} == \"N\" )" ).append("\n"); 
		query.append("AND( H.ONH_DT  <> L.LR_ONH_DT  OR H.ONH_LOC_CD <> L.LR_ONH_LOC_CD )" ).append("\n"); 
		query.append("#elseif (${audit_tp} == \"F\" )" ).append("\n"); 
		query.append("AND( H.OFFH_DT <> L.LR_OFFH_DT OR H.OFFH_LOC_CD <> L.LR_OFFH_LOC_CD )" ).append("\n"); 
		query.append("#elseif (${audit_tp} == \"A\" )" ).append("\n"); 
		query.append("AND(( H.ONH_DT  <> L.LR_ONH_DT  OR H.ONH_LOC_CD <> L.LR_ONH_LOC_CD ) OR( H.OFFH_DT <> L.LR_OFFH_DT OR H.OFFH_LOC_CD <> L.LR_OFFH_LOC_CD ))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("then 'D'" ).append("\n"); 
		query.append("WHEN  L.CNTR_NO IS NULL  then 'H' else 'D' end  LSE_AUD_TP_CD ," ).append("\n"); 
		query.append("H.REF_NO REF_NO ," ).append("\n"); 
		query.append("L.ONF_HIR_STS_CD ," ).append("\n"); 
		query.append("L.AUDIT_TYPE ," ).append("\n"); 
		query.append("@[vndr_seq] VNDR_SEQ" ).append("\n"); 
		query.append("FROM (SELECT" ).append("\n"); 
		query.append("A.AGMT_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("A.LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_NO," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("A.ONH_DT," ).append("\n"); 
		query.append("A.ONH_LOC_CD," ).append("\n"); 
		query.append("A.OFFH_DT," ).append("\n"); 
		query.append("A.OFFH_LOC_CD," ).append("\n"); 
		query.append("A.LR_ONH_DT," ).append("\n"); 
		query.append("A.LR_ONH_LOC_CD," ).append("\n"); 
		query.append("A.LR_OFFH_DT," ).append("\n"); 
		query.append("A.LR_OFFH_LOC_CD," ).append("\n"); 
		query.append("A.ONF_HIR_STS_CD," ).append("\n"); 
		query.append("DECODE(A.ONF_HIR_STS_CD, 'A', 'ALL', 'F', 'OFF-HIRE', 'N', 'ON-HIRE') AUDIT_TYPE ," ).append("\n"); 
		query.append("A.LSE_AUD_TP_CD ," ).append("\n"); 
		query.append("A.REF_NO ," ).append("\n"); 
		query.append("A.VNDR_SEQ" ).append("\n"); 
		query.append("FROM LSE_ONF_HIR_AUD  A" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ       = @[vndr_seq]" ).append("\n"); 
		query.append("AND A.AUD_VER_SEQ    = @[aud_ver_seq]" ).append("\n"); 
		query.append("AND (A.LSE_AUD_TP_CD in('C' , 'D' , 'L' ) OR A.LSE_AUD_TP_CD IS NULL )) L ," ).append("\n"); 
		query.append("#if (${audit_tp} == \"F\" )" ).append("\n"); 
		query.append("--=HJS-DATA====================================OFF-HIRE=START" ).append("\n"); 
		query.append("( SELECT" ).append("\n"); 
		query.append("A.AGMT_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("B.LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_NO," ).append("\n"); 
		query.append("C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSI', A.CNTR_STS_EVNT_DT, 'DII', A.CNTR_STS_EVNT_DT, NULL) ONH_DT," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSI', A.SCC_CD, 'DII', A.SCC_CD, NULL) ONH_LOC_CD," ).append("\n"); 
		query.append("D.OFFH_DT," ).append("\n"); 
		query.append("D.OFFH_LOC_CD," ).append("\n"); 
		query.append("NULL LR_ONH_DT," ).append("\n"); 
		query.append("NULL LR_ONH_LOC_CD," ).append("\n"); 
		query.append("NULL LR_OFFH_DT," ).append("\n"); 
		query.append("NULL LR_OFFH_LOC_CD," ).append("\n"); 
		query.append("NULL ONF_HIR_STS_CD ," ).append("\n"); 
		query.append("NULL AUDIT_TYPE ," ).append("\n"); 
		query.append("NULL LSE_AUD_TP_CD ," ).append("\n"); 
		query.append("B.LSE_CTRT_NO REF_NO ," ).append("\n"); 
		query.append("NULL VNDR_SEQ" ).append("\n"); 
		query.append("FROM    MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO , CNTR_TPSZ_CD FROM MST_CONTAINER A ) C," ).append("\n"); 
		query.append("(SELECT A.CNTR_NO, A.PRNR_STS_SEQ, A.CNTR_STS_CD," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSO', A.CNTR_STS_EVNT_DT, 'DIO', A.CNTR_STS_EVNT_DT,'SRO', A.CNTR_STS_EVNT_DT, 'TLL', A.CNTR_STS_EVNT_DT, NULL) OFFH_DT," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSO', A.SCC_CD, 'DIO', A.SCC_CD,'SRO', A.SCC_CD, 'TLL', A.SCC_CD, NULL) OFFH_LOC_CD" ).append("\n"); 
		query.append("FROM MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO , CNTR_TPSZ_CD FROM MST_CONTAINER ) C" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND     A.CNTR_NO     = C.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD IN ('LSO','DIO','SRO','TLL')" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("AND     A.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[search_stdt], 'RRRRMMDD') AND TO_DATE(@[search_enddt], 'RRRRMMDD') -- 1.OFF-Hire 일때 조건" ).append("\n"); 
		query.append("AND     B.LSE_CTRT_NO = @[ref_no]" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${agmt_seq} != \"\" )" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD IN ('LSI','DII')" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ     = @[vndr_seq]" ).append("\n"); 
		query.append("AND     A.CNTR_NO      = D.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_SEQ = D.PRNR_STS_SEQ ) H" ).append("\n"); 
		query.append("#elseif (${audit_tp} == \"N\" )" ).append("\n"); 
		query.append("--=HJS-DATA====================================ON-HIRE=START" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("A.AGMT_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("B.LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_NO," ).append("\n"); 
		query.append("C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSI', A.CNTR_STS_EVNT_DT, 'DII', A.CNTR_STS_EVNT_DT, NULL) ONH_DT," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSI', A.SCC_CD, 'DII', A.SCC_CD, NULL) ONH_LOC_CD," ).append("\n"); 
		query.append("D.OFFH_DT," ).append("\n"); 
		query.append("D.OFFH_LOC_CD," ).append("\n"); 
		query.append("NULL LR_ONH_DT," ).append("\n"); 
		query.append("NULL LR_ONH_LOC_CD," ).append("\n"); 
		query.append("NULL LR_OFFH_DT," ).append("\n"); 
		query.append("NULL LR_OFFH_LOC_CD," ).append("\n"); 
		query.append("NULL ONF_HIR_STS_CD ," ).append("\n"); 
		query.append("NULL AUDIT_TYPE ," ).append("\n"); 
		query.append("NULL LSE_AUD_TP_CD ," ).append("\n"); 
		query.append("B.LSE_CTRT_NO REF_NO ," ).append("\n"); 
		query.append("NULL VNDR_SEQ" ).append("\n"); 
		query.append("FROM    MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO , CNTR_TPSZ_CD FROM MST_CONTAINER A ) C," ).append("\n"); 
		query.append("(SELECT A.CNTR_NO, A.PRNR_STS_SEQ, A.CNTR_STS_CD," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSO', A.CNTR_STS_EVNT_DT, 'DIO', A.CNTR_STS_EVNT_DT,'SRO', A.CNTR_STS_EVNT_DT, 'TLL', A.CNTR_STS_EVNT_DT, NULL) OFFH_DT," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSO', A.SCC_CD, 'DIO', A.SCC_CD,'SRO', A.SCC_CD, 'TLL', A.SCC_CD, NULL) OFFH_LOC_CD" ).append("\n"); 
		query.append("FROM MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO , CNTR_TPSZ_CD FROM MST_CONTAINER ) C" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND     A.CNTR_NO     = C.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD IN ('LSO','DIO','SRO','TLL')" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("AND B.LSE_CTRT_NO     = @[ref_no]" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${agmt_seq} != \"\" )" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD IN ('LSI','DII')" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ     = @[vndr_seq]" ).append("\n"); 
		query.append("AND     A.CNTR_NO      = D.CNTR_NO(+)" ).append("\n"); 
		query.append("AND     A.CNTR_STS_SEQ = D.PRNR_STS_SEQ(+)" ).append("\n"); 
		query.append("AND     A.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[search_stdt], 'RRRRMMDD') AND TO_DATE(@[search_enddt], 'RRRRMMDD')) H" ).append("\n"); 
		query.append("#elseif (${audit_tp} == \"A\" )" ).append("\n"); 
		query.append("--=HJS-DATA====================================ALL=START" ).append("\n"); 
		query.append("( SELECT" ).append("\n"); 
		query.append("A.AGMT_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("B.LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_NO," ).append("\n"); 
		query.append("C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSI', A.CNTR_STS_EVNT_DT, 'DII', A.CNTR_STS_EVNT_DT, NULL) ONH_DT," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSI', A.SCC_CD, 'DII', A.SCC_CD, NULL) ONH_LOC_CD," ).append("\n"); 
		query.append("D.OFFH_DT," ).append("\n"); 
		query.append("D.OFFH_LOC_CD," ).append("\n"); 
		query.append("NULL LR_ONH_DT," ).append("\n"); 
		query.append("NULL LR_ONH_LOC_CD," ).append("\n"); 
		query.append("NULL LR_OFFH_DT," ).append("\n"); 
		query.append("NULL LR_OFFH_LOC_CD," ).append("\n"); 
		query.append("NULL ONF_HIR_STS_CD ," ).append("\n"); 
		query.append("NULL AUDIT_TYPE ," ).append("\n"); 
		query.append("NULL LSE_AUD_TP_CD ," ).append("\n"); 
		query.append("B.LSE_CTRT_NO REF_NO ," ).append("\n"); 
		query.append("NULL VNDR_SEQ" ).append("\n"); 
		query.append("FROM    MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO , CNTR_TPSZ_CD FROM MST_CONTAINER A ) C," ).append("\n"); 
		query.append("(SELECT A.CNTR_NO, A.PRNR_STS_SEQ, A.CNTR_STS_CD," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSO', A.CNTR_STS_EVNT_DT, 'DIO', A.CNTR_STS_EVNT_DT,'SRO', A.CNTR_STS_EVNT_DT, 'TLL', A.CNTR_STS_EVNT_DT, NULL) OFFH_DT," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSO', A.SCC_CD, 'DIO', A.SCC_CD,'SRO', A.SCC_CD, 'TLL', A.SCC_CD, NULL) OFFH_LOC_CD" ).append("\n"); 
		query.append("FROM MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO , CNTR_TPSZ_CD FROM MST_CONTAINER ) C" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND     A.CNTR_NO     = C.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD IN ('LSO','DIO','SRO','TLL')" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("AND     A.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[search_stdt], 'RRRRMMDD') AND TO_DATE(@[search_enddt], 'RRRRMMDD') -- 1.OFF-Hire 일때 조건" ).append("\n"); 
		query.append("AND     B.LSE_CTRT_NO = @[ref_no]" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${agmt_seq} != \"\" )" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD IN ('LSI','DII')" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ     = @[vndr_seq]" ).append("\n"); 
		query.append("AND     A.CNTR_NO      = D.CNTR_NO  -- 1.OFF-Hire 일때 조건" ).append("\n"); 
		query.append("AND     A.CNTR_STS_SEQ = D.PRNR_STS_SEQ  -- 1.OFF-Hire 일때 조건" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.AGMT_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("B.LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_NO," ).append("\n"); 
		query.append("C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSI', A.CNTR_STS_EVNT_DT, 'DII', A.CNTR_STS_EVNT_DT, NULL) ONH_DT," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSI', A.SCC_CD, 'DII', A.SCC_CD, NULL) ONH_LOC_CD," ).append("\n"); 
		query.append("D.OFFH_DT," ).append("\n"); 
		query.append("D.OFFH_LOC_CD," ).append("\n"); 
		query.append("NULL LR_ONH_DT," ).append("\n"); 
		query.append("NULL LR_ONH_LOC_CD," ).append("\n"); 
		query.append("NULL LR_OFFH_DT," ).append("\n"); 
		query.append("NULL LR_OFFH_LOC_CD," ).append("\n"); 
		query.append("NULL ONF_HIR_STS_CD ," ).append("\n"); 
		query.append("NULL AUDIT_TYPE ," ).append("\n"); 
		query.append("NULL LSE_AUD_TP_CD ," ).append("\n"); 
		query.append("B.LSE_CTRT_NO REF_NO ," ).append("\n"); 
		query.append("NULL VNDR_SEQ" ).append("\n"); 
		query.append("FROM    MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO , CNTR_TPSZ_CD FROM MST_CONTAINER A ) C," ).append("\n"); 
		query.append("(SELECT A.CNTR_NO, A.PRNR_STS_SEQ, A.CNTR_STS_CD," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSO', A.CNTR_STS_EVNT_DT, 'DIO', A.CNTR_STS_EVNT_DT,'SRO', A.CNTR_STS_EVNT_DT, 'TLL', A.CNTR_STS_EVNT_DT, NULL) OFFH_DT," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSO', A.SCC_CD, 'DIO', A.SCC_CD,'SRO', A.SCC_CD, 'TLL', A.SCC_CD, NULL) OFFH_LOC_CD" ).append("\n"); 
		query.append("FROM MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO , CNTR_TPSZ_CD FROM MST_CONTAINER ) C" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND     A.CNTR_NO     = C.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD IN ('LSO','DIO','SRO','TLL')" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("AND B.LSE_CTRT_NO     = @[ref_no]" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${agmt_seq} != \"\" )" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD IN ('LSI','DII')" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("AND     A.CNTR_NO = D.CNTR_NO(+)" ).append("\n"); 
		query.append("AND     A.CNTR_STS_SEQ = D.PRNR_STS_SEQ(+)" ).append("\n"); 
		query.append("AND     A.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[search_stdt], 'RRRRMMDD') AND TO_DATE(@[search_enddt], 'RRRRMMDD')) H" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE H.AGMT_CTY_CD  = L.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("AND H.AGMT_SEQ     = L.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND H.LSTM_CD      = L.LSTM_CD(+)" ).append("\n"); 
		query.append("AND H.CNTR_NO      = L.CNTR_NO(+)" ).append("\n"); 
		query.append("AND H.CNTR_TPSZ_CD = L.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("AND H.REF_NO       = L.REF_NO(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("L.AGMT_CTY_CD|| LTRIM(TO_CHAR(L.AGMT_SEQ,'000000')) AGMT_NO ," ).append("\n"); 
		query.append("L.AGMT_CTY_CD                   AGMT_CTY_CD," ).append("\n"); 
		query.append("L.AGMT_SEQ                      AGMT_SEQ," ).append("\n"); 
		query.append("L.LSTM_CD                       LSTM_CD ," ).append("\n"); 
		query.append("L.CNTR_NO                       CNTR_NO ," ).append("\n"); 
		query.append("L.CNTR_TPSZ_CD                  CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("TO_CHAR(H.ONH_DT , 'YYYYMMDD')  ONH_DT ," ).append("\n"); 
		query.append("H.ONH_LOC_CD                    ONH_LOC_CD ," ).append("\n"); 
		query.append("TO_CHAR(H.OFFH_DT ,'YYYYMMDD')  OFFH_DT ," ).append("\n"); 
		query.append("H.OFFH_LOC_CD                   OFFH_LOC_CD ," ).append("\n"); 
		query.append("TO_CHAR(L.LR_ONH_DT, 'YYYYMMDD')   LR_ONH_DT ," ).append("\n"); 
		query.append("L.LR_ONH_LOC_CD                    LR_ONH_LOC_CD ," ).append("\n"); 
		query.append("TO_CHAR(L.LR_OFFH_DT,'YYYYMMDD')   LR_OFFH_DT ," ).append("\n"); 
		query.append("L.LR_OFFH_LOC_CD                   LR_OFFH_LOC_CD ," ).append("\n"); 
		query.append("'L' LSE_AUD_TP_CD ," ).append("\n"); 
		query.append("L.REF_NO REF_NO ," ).append("\n"); 
		query.append("L.ONF_HIR_STS_CD ," ).append("\n"); 
		query.append("L.AUDIT_TYPE ," ).append("\n"); 
		query.append("@[vndr_seq] VNDR_SEQ" ).append("\n"); 
		query.append("FROM (SELECT" ).append("\n"); 
		query.append("A.AGMT_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("A.LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_NO," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("A.ONH_DT," ).append("\n"); 
		query.append("A.ONH_LOC_CD," ).append("\n"); 
		query.append("A.OFFH_DT," ).append("\n"); 
		query.append("A.OFFH_LOC_CD," ).append("\n"); 
		query.append("A.LR_ONH_DT," ).append("\n"); 
		query.append("A.LR_ONH_LOC_CD," ).append("\n"); 
		query.append("A.LR_OFFH_DT," ).append("\n"); 
		query.append("A.LR_OFFH_LOC_CD," ).append("\n"); 
		query.append("A.ONF_HIR_STS_CD," ).append("\n"); 
		query.append("DECODE(A.ONF_HIR_STS_CD, 'A', 'ALL', 'F', 'OFF-HIRE', 'N', 'ON-HIRE') AUDIT_TYPE ," ).append("\n"); 
		query.append("A.LSE_AUD_TP_CD ," ).append("\n"); 
		query.append("A.REF_NO ," ).append("\n"); 
		query.append("A.VNDR_SEQ" ).append("\n"); 
		query.append("FROM LSE_ONF_HIR_AUD  A" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ       = @[vndr_seq]" ).append("\n"); 
		query.append("AND A.AUD_VER_SEQ    = @[aud_ver_seq]" ).append("\n"); 
		query.append("AND (A.LSE_AUD_TP_CD in('C' , 'D' , 'L' ) OR A.LSE_AUD_TP_CD IS NULL )) L ," ).append("\n"); 
		query.append("#if (${audit_tp} == \"F\" )" ).append("\n"); 
		query.append("--=HJS-DATA====================================OFF-HIRE=START" ).append("\n"); 
		query.append("( SELECT" ).append("\n"); 
		query.append("A.AGMT_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("B.LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_NO," ).append("\n"); 
		query.append("C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSI', A.CNTR_STS_EVNT_DT, 'DII', A.CNTR_STS_EVNT_DT, NULL) ONH_DT," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSI', A.SCC_CD, 'DII', A.SCC_CD, NULL) ONH_LOC_CD," ).append("\n"); 
		query.append("D.OFFH_DT," ).append("\n"); 
		query.append("D.OFFH_LOC_CD," ).append("\n"); 
		query.append("NULL LR_ONH_DT," ).append("\n"); 
		query.append("NULL LR_ONH_LOC_CD," ).append("\n"); 
		query.append("NULL LR_OFFH_DT," ).append("\n"); 
		query.append("NULL LR_OFFH_LOC_CD," ).append("\n"); 
		query.append("NULL ONF_HIR_STS_CD ," ).append("\n"); 
		query.append("NULL AUDIT_TYPE ," ).append("\n"); 
		query.append("NULL LSE_AUD_TP_CD ," ).append("\n"); 
		query.append("B.LSE_CTRT_NO REF_NO ," ).append("\n"); 
		query.append("NULL VNDR_SEQ" ).append("\n"); 
		query.append("FROM    MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO , CNTR_TPSZ_CD FROM MST_CONTAINER A ) C," ).append("\n"); 
		query.append("(SELECT A.CNTR_NO, A.PRNR_STS_SEQ, A.CNTR_STS_CD," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSO', A.CNTR_STS_EVNT_DT, 'DIO', A.CNTR_STS_EVNT_DT,'SRO', A.CNTR_STS_EVNT_DT, 'TLL', A.CNTR_STS_EVNT_DT, NULL) OFFH_DT," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSO', A.SCC_CD, 'DIO', A.SCC_CD,'SRO', A.SCC_CD, 'TLL', A.SCC_CD, NULL) OFFH_LOC_CD" ).append("\n"); 
		query.append("FROM MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO , CNTR_TPSZ_CD FROM MST_CONTAINER ) C" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND     A.CNTR_NO     = C.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD IN ('LSO','DIO','SRO','TLL')" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("AND     A.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[search_stdt], 'RRRRMMDD') AND TO_DATE(@[search_enddt], 'RRRRMMDD') -- 1.OFF-Hire 일때 조건" ).append("\n"); 
		query.append("AND     B.LSE_CTRT_NO = @[ref_no]" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${agmt_seq} != \"\" )" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD IN ('LSI','DII')" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ     = @[vndr_seq]" ).append("\n"); 
		query.append("AND     A.CNTR_NO      = D.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_SEQ = D.PRNR_STS_SEQ ) H" ).append("\n"); 
		query.append("#elseif (${audit_tp} == \"N\" )" ).append("\n"); 
		query.append("--=HJS-DATA====================================ON-HIRE=START" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("A.AGMT_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("B.LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_NO," ).append("\n"); 
		query.append("C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSI', A.CNTR_STS_EVNT_DT, 'DII', A.CNTR_STS_EVNT_DT, NULL) ONH_DT," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSI', A.SCC_CD, 'DII', A.SCC_CD, NULL) ONH_LOC_CD," ).append("\n"); 
		query.append("D.OFFH_DT," ).append("\n"); 
		query.append("D.OFFH_LOC_CD," ).append("\n"); 
		query.append("NULL LR_ONH_DT," ).append("\n"); 
		query.append("NULL LR_ONH_LOC_CD," ).append("\n"); 
		query.append("NULL LR_OFFH_DT," ).append("\n"); 
		query.append("NULL LR_OFFH_LOC_CD," ).append("\n"); 
		query.append("NULL ONF_HIR_STS_CD ," ).append("\n"); 
		query.append("NULL AUDIT_TYPE ," ).append("\n"); 
		query.append("NULL LSE_AUD_TP_CD ," ).append("\n"); 
		query.append("B.LSE_CTRT_NO REF_NO ," ).append("\n"); 
		query.append("NULL VNDR_SEQ" ).append("\n"); 
		query.append("FROM    MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO , CNTR_TPSZ_CD FROM MST_CONTAINER A ) C," ).append("\n"); 
		query.append("(SELECT A.CNTR_NO, A.PRNR_STS_SEQ, A.CNTR_STS_CD," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSO', A.CNTR_STS_EVNT_DT, 'DIO', A.CNTR_STS_EVNT_DT,'SRO', A.CNTR_STS_EVNT_DT, 'TLL', A.CNTR_STS_EVNT_DT, NULL) OFFH_DT," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSO', A.SCC_CD, 'DIO', A.SCC_CD,'SRO', A.SCC_CD, 'TLL', A.SCC_CD, NULL) OFFH_LOC_CD" ).append("\n"); 
		query.append("FROM MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO , CNTR_TPSZ_CD FROM MST_CONTAINER ) C" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND     A.CNTR_NO     = C.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD IN ('LSO','DIO','SRO','TLL')" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("AND B.LSE_CTRT_NO     = @[ref_no]" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${agmt_seq} != \"\" )" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD IN ('LSI','DII')" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ     = @[vndr_seq]" ).append("\n"); 
		query.append("AND     A.CNTR_NO      = D.CNTR_NO(+)" ).append("\n"); 
		query.append("AND     A.CNTR_STS_SEQ = D.PRNR_STS_SEQ(+)" ).append("\n"); 
		query.append("AND     A.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[search_stdt], 'RRRRMMDD') AND TO_DATE(@[search_enddt], 'RRRRMMDD')) H" ).append("\n"); 
		query.append("#elseif (${audit_tp} == \"A\" )" ).append("\n"); 
		query.append("--=HJS-DATA====================================ALL=START" ).append("\n"); 
		query.append("( SELECT" ).append("\n"); 
		query.append("A.AGMT_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("B.LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_NO," ).append("\n"); 
		query.append("C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSI', A.CNTR_STS_EVNT_DT, 'DII', A.CNTR_STS_EVNT_DT, NULL) ONH_DT," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSI', A.SCC_CD, 'DII', A.SCC_CD, NULL) ONH_LOC_CD," ).append("\n"); 
		query.append("D.OFFH_DT," ).append("\n"); 
		query.append("D.OFFH_LOC_CD," ).append("\n"); 
		query.append("NULL LR_ONH_DT," ).append("\n"); 
		query.append("NULL LR_ONH_LOC_CD," ).append("\n"); 
		query.append("NULL LR_OFFH_DT," ).append("\n"); 
		query.append("NULL LR_OFFH_LOC_CD," ).append("\n"); 
		query.append("NULL ONF_HIR_STS_CD ," ).append("\n"); 
		query.append("NULL AUDIT_TYPE ," ).append("\n"); 
		query.append("NULL LSE_AUD_TP_CD ," ).append("\n"); 
		query.append("B.LSE_CTRT_NO REF_NO ," ).append("\n"); 
		query.append("NULL VNDR_SEQ" ).append("\n"); 
		query.append("FROM    MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO , CNTR_TPSZ_CD FROM MST_CONTAINER A ) C," ).append("\n"); 
		query.append("(SELECT A.CNTR_NO, A.PRNR_STS_SEQ, A.CNTR_STS_CD," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSO', A.CNTR_STS_EVNT_DT, 'DIO', A.CNTR_STS_EVNT_DT,'SRO', A.CNTR_STS_EVNT_DT, 'TLL', A.CNTR_STS_EVNT_DT, NULL) OFFH_DT," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSO', A.SCC_CD, 'DIO', A.SCC_CD,'SRO', A.SCC_CD, 'TLL', A.SCC_CD, NULL) OFFH_LOC_CD" ).append("\n"); 
		query.append("FROM MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO , CNTR_TPSZ_CD FROM MST_CONTAINER ) C" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND     A.CNTR_NO     = C.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD IN ('LSO','DIO','SRO','TLL')" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("AND     A.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[search_stdt], 'RRRRMMDD') AND TO_DATE(@[search_enddt], 'RRRRMMDD') -- 1.OFF-Hire 일때 조건" ).append("\n"); 
		query.append("AND     B.LSE_CTRT_NO = @[ref_no]" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${agmt_seq} != \"\" )" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD IN ('LSI','DII')" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ     = @[vndr_seq]" ).append("\n"); 
		query.append("AND     A.CNTR_NO      = D.CNTR_NO  -- 1.OFF-Hire 일때 조건" ).append("\n"); 
		query.append("AND     A.CNTR_STS_SEQ = D.PRNR_STS_SEQ  -- 1.OFF-Hire 일때 조건" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.AGMT_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("B.LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_NO," ).append("\n"); 
		query.append("C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSI', A.CNTR_STS_EVNT_DT, 'DII', A.CNTR_STS_EVNT_DT, NULL) ONH_DT," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSI', A.SCC_CD, 'DII', A.SCC_CD, NULL) ONH_LOC_CD," ).append("\n"); 
		query.append("D.OFFH_DT," ).append("\n"); 
		query.append("D.OFFH_LOC_CD," ).append("\n"); 
		query.append("NULL LR_ONH_DT," ).append("\n"); 
		query.append("NULL LR_ONH_LOC_CD," ).append("\n"); 
		query.append("NULL LR_OFFH_DT," ).append("\n"); 
		query.append("NULL LR_OFFH_LOC_CD," ).append("\n"); 
		query.append("NULL ONF_HIR_STS_CD ," ).append("\n"); 
		query.append("NULL AUDIT_TYPE ," ).append("\n"); 
		query.append("NULL LSE_AUD_TP_CD ," ).append("\n"); 
		query.append("B.LSE_CTRT_NO REF_NO ," ).append("\n"); 
		query.append("NULL VNDR_SEQ" ).append("\n"); 
		query.append("FROM    MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO , CNTR_TPSZ_CD FROM MST_CONTAINER A ) C," ).append("\n"); 
		query.append("(SELECT A.CNTR_NO, A.PRNR_STS_SEQ, A.CNTR_STS_CD," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSO', A.CNTR_STS_EVNT_DT, 'DIO', A.CNTR_STS_EVNT_DT,'SRO', A.CNTR_STS_EVNT_DT, 'TLL', A.CNTR_STS_EVNT_DT, NULL) OFFH_DT," ).append("\n"); 
		query.append("DECODE(A.CNTR_STS_CD, 'LSO', A.SCC_CD, 'DIO', A.SCC_CD,'SRO', A.SCC_CD, 'TLL', A.SCC_CD, NULL) OFFH_LOC_CD" ).append("\n"); 
		query.append("FROM MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("LSE_AGREEMENT B," ).append("\n"); 
		query.append("(SELECT CNTR_NO , CNTR_TPSZ_CD FROM MST_CONTAINER ) C" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND     A.CNTR_NO     = C.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD IN ('LSO','DIO','SRO','TLL')" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("AND B.LSE_CTRT_NO     = @[ref_no]" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE   A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${agmt_seq} != \"\" )" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD IN ('LSI','DII')" ).append("\n"); 
		query.append("AND     B.VNDR_SEQ     = @[vndr_seq]" ).append("\n"); 
		query.append("AND     A.CNTR_NO      = D.CNTR_NO(+)" ).append("\n"); 
		query.append("AND     A.CNTR_STS_SEQ = D.PRNR_STS_SEQ(+)" ).append("\n"); 
		query.append("AND     A.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[search_stdt], 'RRRRMMDD') AND TO_DATE(@[search_enddt], 'RRRRMMDD')) H" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE L.AGMT_CTY_CD  = H.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("AND L.AGMT_SEQ     = H.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND L.LSTM_CD      = H.LSTM_CD(+)" ).append("\n"); 
		query.append("AND L.CNTR_NO      = H.CNTR_NO(+)" ).append("\n"); 
		query.append("AND L.CNTR_TPSZ_CD = H.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("AND L.REF_NO       = H.REF_NO(+)" ).append("\n"); 
		query.append("AND H.CNTR_NO IS NULL" ).append("\n"); 

	}
}