/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeDBDAOsearchEqInterchangeSummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EqInterchangeDBDAOsearchEqInterchangeSummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ interchange pick-up off-hire 현황목록을 조회합니다.
	  * </pre>
	  */
	public EqInterchangeDBDAOsearchEqInterchangeSummaryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration").append("\n"); 
		query.append("FileName : EqInterchangeDBDAOsearchEqInterchangeSummaryListRSQL").append("\n"); 
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
		query.append("#if (${cntr_sts_cd} == 'OF')" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("RCC_CD," ).append("\n"); 
		query.append("LCC_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("AUTH_VOL OUT_VOL," ).append("\n"); 
		query.append("PICKUP_VOL IN_VOL," ).append("\n"); 
		query.append("OFF_HIRED_VOL," ).append("\n"); 
		query.append("AUTH_VOL - OFF_HIRED_VOL BALANCE," ).append("\n"); 
		query.append("LESSOR," ).append("\n"); 
		query.append("AGMT_NO," ).append("\n"); 
		query.append("AUTH_NO," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("S_DAYS," ).append("\n"); 
		query.append("TO_LOC_CD," ).append("\n"); 
		query.append("FM_LOC_CD," ).append("\n"); 
		query.append("AUTH_SEQ" ).append("\n"); 
		query.append("FROM  ( SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("               B.RCC_CD," ).append("\n"); 
		query.append("               B.LCC_CD," ).append("\n"); 
		query.append("               FM_LOC_CD," ).append("\n"); 
		query.append("               A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               G.LSE_ITCHG_AUTH_QTY AUTH_VOL," ).append("\n"); 
		query.append("               SUM(DECODE(B.CNTR_STS_CD,'LSI',1,0)) PICKUP_VOL," ).append("\n"); 
		query.append("               SUM(DECODE(E.CNTR_STS_CD,'LSO',1,0)) OFF_HIRED_VOL," ).append("\n"); 
		query.append("               G.VNDR_ABBR_NM LESSOR," ).append("\n"); 
		query.append("               B.AGMT_CTY_CD||LPAD(B.AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("               B.LSE_ITCHG_AUTH_NO AUTH_NO," ).append("\n"); 
		query.append("               B.LSE_ITCHG_AUTH_SEQ AUTH_SEQ," ).append("\n"); 
		query.append("               TO_CHAR(G.CRE_DT,'YYYYMMDD') CRE_DT," ).append("\n"); 
		query.append("               ROUND(SYSDATE - B.CNTR_STS_EVNT_DT) S_DAYS, --CURRENT_DAY_AUTH_DATE_CREATE_DATE," ).append("\n"); 
		query.append("               TO_LOC_CD," ).append("\n"); 
		query.append("               LSE_LOC_GRP_CD," ).append("\n"); 
		query.append("               LR_VNDR_SEQ" ).append("\n"); 
		query.append("          FROM MST_CONTAINER A," ).append("\n"); 
		query.append("               MST_CNTR_STS_HIS B," ).append("\n"); 
		query.append("               LSE_AGREEMENT C," ).append("\n"); 
		query.append("               MDM_VENDOR D," ).append("\n"); 
		query.append("               MST_CNTR_STS_HIS E," ).append("\n"); 
		query.append("               (SELECT A.LSE_ITCHG_RQST_NO " ).append("\n"); 
		query.append("                      ,A.LSTM_CD" ).append("\n"); 
		query.append("                      ,B.AGMT_SEQ" ).append("\n"); 
		query.append("                      ,A.LR_VNDR_SEQ" ).append("\n"); 
		query.append("                      ,(SELECT VNDR_LGL_ENG_NM  FROM MDM_VENDOR WHERE VNDR_SEQ = A.LR_VNDR_SEQ) vndr_abbr_nm" ).append("\n"); 
		query.append("                      ,A.RCC_CD" ).append("\n"); 
		query.append("                      ,A.LCC_CD" ).append("\n"); 
		query.append("                      ,A.FM_LOC_CD" ).append("\n"); 
		query.append("                      ,A.LSE_LOC_GRP_CD" ).append("\n"); 
		query.append("                      ,A.TO_LOC_CD " ).append("\n"); 
		query.append("                      ,A.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                      ,B.LSE_ITCHG_AUTH_QTY" ).append("\n"); 
		query.append("                      ,B.LSE_FREE_DYS" ).append("\n"); 
		query.append("                      ,B.PKUP_UT_AMT" ).append("\n"); 
		query.append("                      ,B.PKUP_CR_AMT" ).append("\n"); 
		query.append("                      ,B.LSE_ITCHG_AUTH_NO" ).append("\n"); 
		query.append("                      ,B.LSE_ITCHG_AUTH_SEQ" ).append("\n"); 
		query.append("                      ,A.LSE_ITCHG_RQST_SEQ" ).append("\n"); 
		query.append("                      ,B.CRE_DT CRE_DT" ).append("\n"); 
		query.append("                FROM LSE_EQ_ITCHG_RQST A, LSE_EQ_ITCHG B" ).append("\n"); 
		query.append("                WHERE A.LSE_ITCHG_AUTH_NO = B.LSE_ITCHG_AUTH_NO" ).append("\n"); 
		query.append("                AND A.LSE_ITCHG_AUTH_SEQ = B.LSE_ITCHG_AUTH_SEQ" ).append("\n"); 
		query.append("                AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                AND A.LSTM_CD ='OF'" ).append("\n"); 
		query.append("                ) G" ).append("\n"); 
		query.append("         WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("           AND B.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("           AND B.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("           AND G.LSE_ITCHG_AUTH_NO = B.LSE_ITCHG_AUTH_NO" ).append("\n"); 
		query.append("           AND B.CNTR_STS_CD = 'LSI'" ).append("\n"); 
		query.append("           AND A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("           AND B.CNTR_NO = E.CNTR_NO (+)" ).append("\n"); 
		query.append("           AND B.CNTR_STS_SEQ = E.PRNR_STS_SEQ (+)" ).append("\n"); 
		query.append("           AND C.LSTM_CD = 'OF'" ).append("\n"); 
		query.append("           AND G.LSE_ITCHG_AUTH_SEQ = B.LSE_ITCHG_AUTH_SEQ" ).append("\n"); 
		query.append("         GROUP BY B.RCC_CD," ).append("\n"); 
		query.append("               B.LCC_CD," ).append("\n"); 
		query.append("               A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               G.VNDR_ABBR_NM," ).append("\n"); 
		query.append("               B.AGMT_CTY_CD||LPAD(B.AGMT_SEQ, 6, '0')," ).append("\n"); 
		query.append("               B.LSE_ITCHG_AUTH_NO," ).append("\n"); 
		query.append("               B.LSE_ITCHG_AUTH_SEQ," ).append("\n"); 
		query.append("               LSE_ITCHG_AUTH_QTY," ).append("\n"); 
		query.append("               TO_CHAR(G.CRE_DT,'YYYYMMDD')," ).append("\n"); 
		query.append("               SYSDATE - B.CNTR_STS_EVNT_DT," ).append("\n"); 
		query.append("               LSE_LOC_GRP_CD," ).append("\n"); 
		query.append("               LR_VNDR_SEQ," ).append("\n"); 
		query.append("               TO_LOC_CD," ).append("\n"); 
		query.append("               FM_LOC_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${lst_sts_flg} == '02')" ).append("\n"); 
		query.append("AND OFF_HIRED_VOL <> 0" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${lstm_soc_tp} == '02' )" ).append("\n"); 
		query.append("AND AUTH_VOL - OFF_HIRED_VOL = 0" ).append("\n"); 
		query.append("	#elseif (${lstm_soc_tp} == '03' )" ).append("\n"); 
		query.append("AND AUTH_VOL - OFF_HIRED_VOL <> 0" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${loc_tp} == '1' && ${loc_cd} != '')" ).append("\n"); 
		query.append("AND RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '2' && ${loc_cd} != '')" ).append("\n"); 
		query.append("AND LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${loc_tp2} == '1' && ${loc_cd2} != '')" ).append("\n"); 
		query.append("AND LSE_LOC_GRP_CD = 'RCC' AND TO_LOC_CD = @[loc_cd2]" ).append("\n"); 
		query.append("	#elseif (${loc_tp2} == '2' && ${loc_cd2} != '')" ).append("\n"); 
		query.append("AND LSE_LOC_GRP_CD = 'LCC' AND TO_LOC_CD = @[loc_cd2]" ).append("\n"); 
		query.append("	#elseif (${loc_tp2} == '3' && ${loc_cd2} != '')" ).append("\n"); 
		query.append("AND LSE_LOC_GRP_CD = 'ECC' AND TO_LOC_CD = @[loc_cd2]" ).append("\n"); 
		query.append("	#elseif (${loc_tp2} == '4' && ${loc_cd2} != '')" ).append("\n"); 
		query.append("AND LSE_LOC_GRP_CD = 'SCC' AND TO_LOC_CD = @[loc_cd2]" ).append("\n"); 
		query.append("	#elseif (${loc_tp2} == '5' && ${loc_cd2} != '')" ).append("\n"); 
		query.append("AND LSE_LOC_GRP_CD = 'CN' AND TO_LOC_CD = @[loc_cd2]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${str_evnt_dt} != '')" ).append("\n"); 
		query.append("AND     CRE_DT BETWEEN TO_DATE(@[str_evnt_dt],'YYYYMMDD')  " ).append("\n"); 
		query.append("AND 	TO_DATE(@[end_evnt_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND     CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("   	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("   		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("   			'$key'," ).append("\n"); 
		query.append("   		#else" ).append("\n"); 
		query.append("   			'$key'" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND     LR_VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${cntr_sts_cd} == 'SO')" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("RCC_CD," ).append("\n"); 
		query.append("LCC_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("AUTH_VOL," ).append("\n"); 
		query.append("OUT_VOL," ).append("\n"); 
		query.append("IN_VOL," ).append("\n"); 
		query.append("AUTH_VOL - IN_VOL BALANCE," ).append("\n"); 
		query.append("LESSOR," ).append("\n"); 
		query.append("AGMT_NO," ).append("\n"); 
		query.append("AUTH_NO," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("S_DAYS," ).append("\n"); 
		query.append("TO_LOC_CD," ).append("\n"); 
		query.append("FM_LOC_CD," ).append("\n"); 
		query.append("AUTH_SEQ" ).append("\n"); 
		query.append("FROM  ( SELECT /*+ ORDERED */" ).append("\n"); 
		query.append("               B.RCC_CD," ).append("\n"); 
		query.append("               B.LCC_CD," ).append("\n"); 
		query.append("               FM_LOC_CD," ).append("\n"); 
		query.append("               A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               G.LSE_ITCHG_AUTH_QTY AUTH_VOL," ).append("\n"); 
		query.append("               SUM(DECODE(B.CNTR_STS_CD,'SBO',1,0)) OUT_VOL," ).append("\n"); 
		query.append("               SUM(DECODE(E.CNTR_STS_CD,'SBI',1,0)) IN_VOL," ).append("\n"); 
		query.append("               G.VNDR_ABBR_NM LESSOR," ).append("\n"); 
		query.append("               B.AGMT_CTY_CD||LPAD(B.AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("               B.LSE_ITCHG_AUTH_NO AUTH_NO," ).append("\n"); 
		query.append("               B.LSE_ITCHG_AUTH_SEQ AUTH_SEQ," ).append("\n"); 
		query.append("               TO_CHAR(G.CRE_DT,'YYYYMMDD') CRE_DT," ).append("\n"); 
		query.append("               ROUND(SYSDATE - B.CNTR_STS_EVNT_DT) S_DAYS, --CURRENT_DAY_AUTH_DATE_CREATE_DATE," ).append("\n"); 
		query.append("               TO_LOC_CD," ).append("\n"); 
		query.append("               LSE_LOC_GRP_CD," ).append("\n"); 
		query.append("               LR_VNDR_SEQ" ).append("\n"); 
		query.append("          FROM MST_CONTAINER A," ).append("\n"); 
		query.append("               MST_CNTR_STS_HIS B," ).append("\n"); 
		query.append("               LSE_AGREEMENT C," ).append("\n"); 
		query.append("               MDM_VENDOR D," ).append("\n"); 
		query.append("               MST_CNTR_STS_HIS E," ).append("\n"); 
		query.append("               (SELECT A.LSE_ITCHG_RQST_NO " ).append("\n"); 
		query.append("                      ,A.LSTM_CD" ).append("\n"); 
		query.append("                      ,B.AGMT_SEQ" ).append("\n"); 
		query.append("                      ,A.LR_VNDR_SEQ" ).append("\n"); 
		query.append("                      ,(SELECT VNDR_LGL_ENG_NM  FROM MDM_VENDOR WHERE VNDR_SEQ = A.LR_VNDR_SEQ) vndr_abbr_nm" ).append("\n"); 
		query.append("                      ,A.RCC_CD" ).append("\n"); 
		query.append("                      ,A.LCC_CD" ).append("\n"); 
		query.append("                      ,A.FM_LOC_CD" ).append("\n"); 
		query.append("                      ,A.LSE_LOC_GRP_CD" ).append("\n"); 
		query.append("                      ,A.TO_LOC_CD " ).append("\n"); 
		query.append("                      ,A.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                      ,B.LSE_ITCHG_AUTH_QTY" ).append("\n"); 
		query.append("                      ,B.LSE_FREE_DYS" ).append("\n"); 
		query.append("                      ,B.PKUP_UT_AMT" ).append("\n"); 
		query.append("                      ,B.PKUP_CR_AMT" ).append("\n"); 
		query.append("                      ,B.LSE_ITCHG_AUTH_NO" ).append("\n"); 
		query.append("                      ,B.LSE_ITCHG_AUTH_SEQ" ).append("\n"); 
		query.append("                      ,A.LSE_ITCHG_RQST_SEQ" ).append("\n"); 
		query.append("                      ,B.CRE_DT CRE_DT" ).append("\n"); 
		query.append("                FROM LSE_EQ_ITCHG_RQST A, LSE_EQ_ITCHG B" ).append("\n"); 
		query.append("                WHERE A.LSE_ITCHG_AUTH_NO = B.LSE_ITCHG_AUTH_NO" ).append("\n"); 
		query.append("                AND A.LSE_ITCHG_AUTH_SEQ = B.LSE_ITCHG_AUTH_SEQ" ).append("\n"); 
		query.append("                AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                AND A.LSTM_CD ='SO'" ).append("\n"); 
		query.append("                 ) G" ).append("\n"); 
		query.append("         WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("           AND B.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("           AND B.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("           AND C.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("           AND G.LSE_ITCHG_AUTH_NO = B.LSE_ITCHG_AUTH_NO" ).append("\n"); 
		query.append("         --  AND B.CNTR_STS_CD = 'SBI'" ).append("\n"); 
		query.append("           AND A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("           AND B.CNTR_NO = E.CNTR_NO (+)" ).append("\n"); 
		query.append("           AND B.CNTR_STS_SEQ = E.PRNR_STS_SEQ (+)" ).append("\n"); 
		query.append("           AND G.LSE_ITCHG_AUTH_SEQ = B.LSE_ITCHG_AUTH_SEQ" ).append("\n"); 
		query.append("         GROUP BY B.RCC_CD," ).append("\n"); 
		query.append("               B.LCC_CD," ).append("\n"); 
		query.append("               A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               G.VNDR_ABBR_NM," ).append("\n"); 
		query.append("               B.AGMT_CTY_CD||LPAD(B.AGMT_SEQ, 6, '0')," ).append("\n"); 
		query.append("               B.LSE_ITCHG_AUTH_NO," ).append("\n"); 
		query.append("               B.LSE_ITCHG_AUTH_SEQ," ).append("\n"); 
		query.append("               LSE_ITCHG_AUTH_QTY," ).append("\n"); 
		query.append("               TO_CHAR(G.CRE_DT,'YYYYMMDD')," ).append("\n"); 
		query.append("               SYSDATE - B.CNTR_STS_EVNT_DT," ).append("\n"); 
		query.append("               LSE_LOC_GRP_CD," ).append("\n"); 
		query.append("               LR_VNDR_SEQ," ).append("\n"); 
		query.append("               TO_LOC_CD," ).append("\n"); 
		query.append("               FM_LOC_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("	#if (${lst_sts_flg1} == '02')" ).append("\n"); 
		query.append("AND IN_VOL <> 0" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${lstm_soc_tp} == '02' )" ).append("\n"); 
		query.append("AND AUTH_VOL - IN_VOL = 0" ).append("\n"); 
		query.append("	#elseif (${lstm_soc_tp} == '03' )" ).append("\n"); 
		query.append("AND AUTH_VOL - IN_VOL <> 0" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${loc_tp} == '1' && ${loc_cd} != '')" ).append("\n"); 
		query.append("AND RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '2' && ${loc_cd} != '')" ).append("\n"); 
		query.append("AND LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${loc_tp2} == '1' && ${loc_cd2} != '')" ).append("\n"); 
		query.append("AND LSE_LOC_GRP_CD = 'RCC' AND TO_LOC_CD = @[loc_cd2]" ).append("\n"); 
		query.append("	#elseif (${loc_tp2} == '2' && ${loc_cd2} != '')" ).append("\n"); 
		query.append("AND LSE_LOC_GRP_CD = 'LCC' AND TO_LOC_CD = @[loc_cd2]" ).append("\n"); 
		query.append("	#elseif (${loc_tp2} == '3' && ${loc_cd2} != '')" ).append("\n"); 
		query.append("AND LSE_LOC_GRP_CD = 'ECC' AND TO_LOC_CD = @[loc_cd2]" ).append("\n"); 
		query.append("	#elseif (${loc_tp2} == '4' && ${loc_cd2} != '')" ).append("\n"); 
		query.append("AND LSE_LOC_GRP_CD = 'SCC' AND TO_LOC_CD = @[loc_cd2]" ).append("\n"); 
		query.append("	#elseif (${loc_tp2} == '5' && ${loc_cd2} != '')" ).append("\n"); 
		query.append("AND LSE_LOC_GRP_CD = 'CN' AND TO_LOC_CD = @[loc_cd2]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${str_evnt_dt} != '')" ).append("\n"); 
		query.append("AND     CRE_DT BETWEEN TO_DATE(@[str_evnt_dt],'YYYYMMDD')  " ).append("\n"); 
		query.append("AND 	TO_DATE(@[end_evnt_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND     CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("   	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("   		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("   			'$key'," ).append("\n"); 
		query.append("   		#else" ).append("\n"); 
		query.append("   			'$key'" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND     LR_VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}