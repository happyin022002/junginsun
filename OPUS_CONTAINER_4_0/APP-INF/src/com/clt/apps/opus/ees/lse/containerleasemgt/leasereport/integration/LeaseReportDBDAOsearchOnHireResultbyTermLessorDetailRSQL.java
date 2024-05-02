/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LeaseReportDBDAOsearchOnHireResultbyTermLessorDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.12
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.01.12 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseReportDBDAOsearchOnHireResultbyTermLessorDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 임차장비 임차실적 조회 (On-Hire Result by Lease Term/Lessor-Option)
	  * USED DAYS계산시 FREE DYAS 제외,RENTAL CHARGE계산로직 수정
	  *  Term Change 조건에 따른 조회로직 수정
	  *  "Including"  -> 해당월 LSI 로 시작, 짝 lso 가 찾기==> TERM CHANGE FLAG 무시
	  *  "Excluding" -> 해당월 LSI 가 T/C='N' 로 시작, 짝 lso 가 T/C='N' 만
	  *  "Only"       -> 해당월 LSI  T/C='N', LSO가 T/C='Y' , 실제 반납한 LSO(기준 LSI 보다 큰 LSO 이고 T/C='N')
	  *  LT일때 Per-Diem LCC로 변경
	  * </pre>
	  */
	public LeaseReportDBDAOsearchOnHireResultbyTermLessorDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_eddt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("detail_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("detail_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("term_change",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("company",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_stdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("detail_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOsearchOnHireResultbyTermLessorDetailRSQL").append("\n"); 
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
		query.append("         @[period_stdt] PERIOD_STDT" ).append("\n"); 
		query.append("        ,@[period_eddt] PERIOD_EDDT" ).append("\n"); 
		query.append("        ,@[company]  COMPANY" ).append("\n"); 
		query.append("        ,@[loc_cd] LOC_CD" ).append("\n"); 
		query.append("        ,@[loc_tp] LOC_TP" ).append("\n"); 
		query.append("        ,@[vndr_seq] VNDR_SEQ" ).append("\n"); 
		query.append("        ,@[detail_lstm_cd] DTL_LSTM_CD" ).append("\n"); 
		query.append("        ,@[detail_vndr_seq] DTL_VNDR_SEQ       " ).append("\n"); 
		query.append("        ,@[detail_cntr_tpsz_cd] DTL_CNTR_TP_SZ        " ).append("\n"); 
		query.append("        ,@[term_change] TERM_CHANGE  /* Including(NULL), Excluding('N'), Only('Y') */" ).append("\n"); 
		query.append("	FROM   DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT    ROW_SEQ" ).append("\n"); 
		query.append("        , CNTRNO" ).append("\n"); 
		query.append("        , TYSZ" ).append("\n"); 
		query.append("        , AGMT_NO" ).append("\n"); 
		query.append("        , TERM" ).append("\n"); 
		query.append("        , REF_NO" ).append("\n"); 
		query.append("        , CNMV_STS_CD" ).append("\n"); 
		query.append("        , CNTR_AUTH_NO" ).append("\n"); 
		query.append("        , OHDATE" ).append("\n"); 
		query.append("        , OHLOC" ).append("\n"); 
		query.append("        , FDAYS" ).append("\n"); 
		query.append("        , OFHDATE" ).append("\n"); 
		query.append("        , OFHLOC" ).append("\n"); 
		query.append("        , USEDDAYS" ).append("\n"); 
		query.append("        , MINOHDAYS" ).append("\n"); 
		query.append("        , TERM_CHANGE" ).append("\n"); 
		query.append("        , DII " ).append("\n"); 
		query.append("        , IMMEDIATELY" ).append("\n"); 
		query.append("        , NVL(RENTAL_CHARGE, 0 ) RENTAL_CHARGE" ).append("\n"); 
		query.append("        , NVL(LON, 0 ) LON" ).append("\n"); 
		query.append("        , NVL(PUC, 0 ) PUC" ).append("\n"); 
		query.append("        , NVL(PCR, 0 ) PCR" ).append("\n"); 
		query.append("        , NVL(LOF, 0 ) LOF" ).append("\n"); 
		query.append("        , NVL(DOC, 0 ) DOC" ).append("\n"); 
		query.append("        , NVL(DCR, 0 ) DCR" ).append("\n"); 
		query.append("        , NVL(ON_HIRE_DRAYAGE, 0 ) ON_HIRE_DRAYAGE" ).append("\n"); 
		query.append("        , NVL(OFF_HIRE_DRAYAGE, 0 ) OFF_HIRE_DRAYAGE" ).append("\n"); 
		query.append("        , NVL(M_R_COST, 0 ) M_R_COST" ).append("\n"); 
		query.append("        , NVL(DPP, 0 ) DPP" ).append("\n"); 
		query.append("        , NVL(RENTAL_CHARGE, 0 ) + NVL(LON, 0 ) + NVL(PUC, 0 ) - NVL(PCR, 0 ) + NVL(LOF, 0 ) + NVL(DOC, 0 ) - NVL(DCR, 0 ) + NVL(DPP, 0 ) + NVL(M_R_COST, 0 ) + NVL(ON_HIRE_DRAYAGE, 0 ) + NVL(OFF_HIRE_DRAYAGE, 0 ) AS G_TTL" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("/* CASE 1 */" ).append("\n"); 
		query.append("        SELECT  ROW_NUMBER() OVER(ORDER BY T13.CNTR_NO , T13.CNTR_TPSZ_CD) AS ROW_SEQ" ).append("\n"); 
		query.append("                , T10.CNTR_NO                                 AS CNTRNO" ).append("\n"); 
		query.append("                , T13.CNTR_TPSZ_CD                            AS TYSZ" ).append("\n"); 
		query.append("                , T10.AGMT_CTY_CD||LPAD(T10.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("                , T15.LSTM_CD                                 AS TERM" ).append("\n"); 
		query.append("                , T15.REF_NO                                  AS REF_NO" ).append("\n"); 
		query.append("                , T13.CNTR_AUTH_NO                            AS CNTR_AUTH_NO  " ).append("\n"); 
		query.append("                , T13.CNMV_STS_CD                             AS CNMV_STS_CD" ).append("\n"); 
		query.append("                , TO_CHAR(T10.CNTR_STS_EVNT_DT, 'YYYYMMDD')   AS OHDATE" ).append("\n"); 
		query.append("                , T10.YD_CD                                   AS OHLOC                " ).append("\n"); 
		query.append("                #if (${loc_tp} == 'R' ) " ).append("\n"); 
		query.append("				, T10.LCC_CD AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == 'L' ) " ).append("\n"); 
		query.append("                , T10.SCC_CD AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == 'S' ) " ).append("\n"); 
		query.append("                , T10.YD_CD  AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == '' ) " ).append("\n"); 
		query.append("                , T10.RCC_CD AS RCC" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                , T10.CNTR_LSTM_CNG_FLG                     AS TERM_CHANGE" ).append("\n"); 
		query.append("                , NVL(T10.RNTL_CHG_FREE_DYS , 0)            AS FDAYS" ).append("\n"); 
		query.append("                , TO_CHAR(T12.CNTR_STS_EVNT_DT, 'YYYYMMDD') AS OFHDATE" ).append("\n"); 
		query.append("                , T12.YD_CD                                 AS OFHLOC" ).append("\n"); 
		query.append("                , CASE WHEN ( T15.LSTM_CD = 'OW' OR T15.LSTM_CD = 'LP' OR T15.LSTM_CD = 'OL' ) THEN " ).append("\n"); 
		query.append("                        TRUNC(NVL(T12.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD'))) -  T10.CNTR_STS_EVNT_DT + 1" ).append("\n"); 
		query.append("                  ELSE " ).append("\n"); 
		query.append("                        TRUNC(NVL(T12.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD'))) -  T10.CNTR_STS_EVNT_DT + 1" ).append("\n"); 
		query.append("                  END                                       AS USEDDAYS" ).append("\n"); 
		query.append("                , NVL(T10.CNTR_MIN_ONH_DYS , 0 )            AS MINOHDAYS" ).append("\n"); 
		query.append("                , DECODE(T10.CNTR_STS_CD, 'DII', 'Y', 'N')  AS DII" ).append("\n"); 
		query.append("                , T13.IMDT_EXT_FLG                          AS IMMEDIATELY                " ).append("\n"); 
		query.append("                , NVL(GREATEST(" ).append("\n"); 
		query.append("            		  CASE WHEN T15.LSTM_CD IN('OW','LP','OL') " ).append("\n"); 
		query.append("                          THEN " ).append("\n"); 
		query.append("                               (TRUNC(NVL(T12.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - T10.CNTR_STS_EVNT_DT - NVL(T10.RNTL_CHG_FREE_DYS , 0 )) + 1 )" ).append("\n"); 
		query.append("                               * MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(T10.AGMT_CTY_CD, T10.AGMT_SEQ, 'PDM', T13.CNTR_TPSZ_CD, T10.YD_CD)" ).append("\n"); 
		query.append("                          ELSE  " ).append("\n"); 
		query.append("                               (TRUNC(NVL(T12.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - T10.CNTR_STS_EVNT_DT - NVL(T10.RNTL_CHG_FREE_DYS , 0 )) + 1 )" ).append("\n"); 
		query.append("                               * MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(T10.AGMT_CTY_CD, T10.AGMT_SEQ, 'PDM', T13.CNTR_TPSZ_CD, T10.YD_CD)" ).append("\n"); 
		query.append("                      END, 0), 0)                                                AS RENTAL_CHARGE" ).append("\n"); 
		query.append("            , NVL(T10.CNTR_LFT_CHG_AMT,0)                                        AS LON" ).append("\n"); 
		query.append("            , DECODE(SIGN(T10.CNTR_PKUP_CHG_AMT),  1,  T10.CNTR_PKUP_CHG_AMT, 0) AS PUC" ).append("\n"); 
		query.append("            , DECODE(SIGN(T10.CNTR_PKUP_CHG_AMT), -1, -T10.CNTR_PKUP_CHG_AMT, 0) AS PCR" ).append("\n"); 
		query.append("            , NVL(T12.CNTR_LFT_CHG_AMT,0)                                        AS LOF" ).append("\n"); 
		query.append("            , DECODE(SIGN(T12.CNTR_DRFF_CR_AMT),   1,  T12.CNTR_DRFF_CR_AMT,  0) AS DOC" ).append("\n"); 
		query.append("            , DECODE(SIGN(T12.CNTR_DRFF_CR_AMT),  -1, -T12.CNTR_DRFF_CR_AMT,  0) AS DCR" ).append("\n"); 
		query.append("            , ( SELECT  /*+ SO INDEX_DESC(XPKTRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("                        SO.NEGO_AMT" ).append("\n"); 
		query.append("                FROM    TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                WHERE   SO.EQ_NO                = T13.CNTR_NO" ).append("\n"); 
		query.append("                AND     SO.TRSP_COST_DTL_MOD_CD = 'CN' --CNTR S/T ON-HIRE" ).append("\n"); 
		query.append("                AND     ROWNUM                  = 1) AS ON_HIRE_DRAYAGE" ).append("\n"); 
		query.append("            , ( SELECT  /*+ SO INDEX_DESC(XPKTRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("                        SO.NEGO_AMT" ).append("\n"); 
		query.append("                FROM    TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                WHERE   SO.EQ_NO                = T13.CNTR_NO" ).append("\n"); 
		query.append("                AND     SO.TRSP_COST_DTL_MOD_CD = 'CF' --CNTR S/T OFF-HIRE" ).append("\n"); 
		query.append("                AND     ROWNUM                  = 1) AS OFF_HIRE_DRAYAGE" ).append("\n"); 
		query.append("            , ( SELECT  MNR_COMMON_PKG.MNR_GET_RPRCOST_FNC('U',  T13.CNTR_NO)" ).append("\n"); 
		query.append("                FROM    MNR_ORD_DTL OD," ).append("\n"); 
		query.append("                        MNR_ORD_HDR OH" ).append("\n"); 
		query.append("                WHERE   1=1" ).append("\n"); 
		query.append("                AND     OD.EQ_NO              = T13.CNTR_NO" ).append("\n"); 
		query.append("                AND     OD.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND     OD.MNR_ORD_SEQ        = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                GROUP BY T13.CNTR_NO ) AS M_R_COST" ).append("\n"); 
		query.append("            , (SELECT  RT.AGMT_CHG_VAL                                 " ).append("\n"); 
		query.append("               FROM    LSE_AGMT_RT RT,        " ).append("\n"); 
		query.append("                       LSE_AGREEMENT AM" ).append("\n"); 
		query.append("               WHERE   RT.AGMT_CTY_CD         = AM.AGMT_CTY_CD" ).append("\n"); 
		query.append("               AND     RT.AGMT_SEQ            = AM.AGMT_SEQ                              " ).append("\n"); 
		query.append("               AND     RT.CNTR_RNTL_CHG_TP_CD = 'DPPV'     " ).append("\n"); 
		query.append("               AND     AM.DPP_TP_CD           = 'Y'" ).append("\n"); 
		query.append("               AND     RT.AGMT_CTY_CD         = T12.AGMT_CTY_CD" ).append("\n"); 
		query.append("               AND     RT.AGMT_SEQ            = T12.AGMT_SEQ" ).append("\n"); 
		query.append("               AND     RT.CNTR_TPSZ_CD        = T13.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("               AND     TO_CHAR(T12.CNTR_STS_EVNT_DT, 'YYYYMMDD') BETWEEN PERIOD_STDT AND PERIOD_EDDT " ).append("\n"); 
		query.append("			   AND     ROWNUM                  = 1) AS DPP" ).append("\n"); 
		query.append("       FROM    (" ).append("\n"); 
		query.append("                SELECT  T01.CNTR_NO, T01.CNTR_STS_SEQ, T01.YD_CD, T01.AGMT_CTY_CD, T01.AGMT_SEQ, T01.CNTR_STS_EVNT_DT, T01.CNTR_STS_CD, T01.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("                	    , T01.RCC_CD, T01.LCC_CD, T01.SCC_CD, T01.CNTR_MIN_ONH_DYS, T01.RNTL_CHG_FREE_DYS, T01.CNTR_LFT_CHG_AMT, T01.CNTR_PKUP_CHG_AMT, " ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        SELECT /*+ INDEX_ASC(T02 XPKMST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                               CNTR_STS_SEQ" ).append("\n"); 
		query.append("                        FROM   MST_CNTR_STS_HIS T02" ).append("\n"); 
		query.append("                        WHERE  T01.CNTR_NO      = T02.CNTR_NO" ).append("\n"); 
		query.append("                        AND    T01.CNTR_STS_SEQ < T02.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                        AND    T02.CNTR_STS_CD  = 'LSO'" ).append("\n"); 
		query.append("                        AND    ROWNUM           = 1" ).append("\n"); 
		query.append("                        ) AS FST_CNTR_STS_SEQ" ).append("\n"); 
		query.append("                        , P.VNDR_SEQ, P.COMPANY, PERIOD_STDT, P.PERIOD_EDDT, P.DTL_CNTR_TP_SZ, P.LOC_CD" ).append("\n"); 
		query.append("                FROM    MST_CNTR_STS_HIS T01," ).append("\n"); 
		query.append("                        PARAM P" ).append("\n"); 
		query.append("                WHERE   1=1" ).append("\n"); 
		query.append("                AND     DECODE(NVL(TERM_CHANGE, 'I'), 'I', 'I')   = NVL(TERM_CHANGE, 'I')" ).append("\n"); 
		query.append("                #if (${dii} != '' )" ).append("\n"); 
		query.append("  			        		#if (${dii} == 'N' )" ).append("\n"); 
		query.append("                AND CNTR_STS_CD IN ('LSI','OWN')" ).append("\n"); 
		query.append("  			        		#elseif (${dii} == 'Y' ) " ).append("\n"); 
		query.append("                AND CNTR_STS_CD = 'DII'" ).append("\n"); 
		query.append("  			        		#end" ).append("\n"); 
		query.append("				        #else" ).append("\n"); 
		query.append("				        AND CNTR_STS_CD IN ('LSI','DII','OWN')" ).append("\n"); 
		query.append("				        #end" ).append("\n"); 
		query.append("                AND     T01.AGMT_SEQ      <> 999990                				" ).append("\n"); 
		query.append("                AND     CNTR_STS_EVNT_DT BETWEEN TO_DATE(P.PERIOD_STDT, 'YYYYMMDD') AND TO_DATE(P.PERIOD_EDDT, 'YYYYMMDD')                " ).append("\n"); 
		query.append("                ) T10," ).append("\n"); 
		query.append("                MST_CNTR_STS_HIS T12," ).append("\n"); 
		query.append("                MST_CONTAINER    T13," ).append("\n"); 
		query.append("                MDM_CNTR_TP_SZ   T14," ).append("\n"); 
		query.append("                LSE_AGREEMENT    T15," ).append("\n"); 
		query.append("                MDM_VENDOR       T17" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     T10.CNTR_NO             = T13.CNTR_NO" ).append("\n"); 
		query.append("        AND     T13.CNTR_TPSZ_CD        = T14.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        AND     T10.CNTR_NO             = T12.CNTR_NO      (+)  " ).append("\n"); 
		query.append("        AND     T10.FST_CNTR_STS_SEQ    = T12.CNTR_STS_SEQ (+)" ).append("\n"); 
		query.append("        AND     T10.AGMT_CTY_CD         = T15.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     T10.AGMT_SEQ            = T15.AGMT_SEQ" ).append("\n"); 
		query.append("        AND     T15.VNDR_SEQ            = T17.VNDR_SEQ" ).append("\n"); 
		query.append("        AND     T13.CO_CRE_FLG         = 'N'" ).append("\n"); 
		query.append("       	#if (${detail_lstm_cd} != '' ) " ).append("\n"); 
		query.append("        AND   T15.LSTM_CD = @[detail_lstm_cd] " ).append("\n"); 
		query.append("      	#end      " ).append("\n"); 
		query.append("      	#if (${detail_vndr_seq} != '' ) " ).append("\n"); 
		query.append("         AND   T15.VNDR_SEQ = @[detail_vndr_seq] " ).append("\n"); 
		query.append("      	#end            	" ).append("\n"); 
		query.append("      	#if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("        AND   T15.VNDR_SEQ = @[vndr_seq] " ).append("\n"); 
		query.append("      	#end            	" ).append("\n"); 
		query.append("        #if (${detail_cntr_tpsz_cd} != '' ) " ).append("\n"); 
		query.append("        AND     T13.CNTR_TPSZ_CD        = T10.DTL_CNTR_TP_SZ" ).append("\n"); 
		query.append("        #end   " ).append("\n"); 
		query.append("        #if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("		AND     T10.VNDR_SEQ            = T17.VNDR_SEQ" ).append("\n"); 
		query.append("		#end				" ).append("\n"); 
		query.append("		#if (${cntr_tpsz_cd_str} != '' )" ).append("\n"); 
		query.append("	    AND  T13.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("	        #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("	           '$key'," ).append("\n"); 
		query.append("	        #else" ).append("\n"); 
		query.append("	           '$key'" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("	                             #end )" ).append("\n"); 
		query.append("		     #end" ).append("\n"); 
		query.append("		#if (${company} != '' )" ).append("\n"); 
		query.append("		AND    T13.CNTR_USE_CO_CD = T10.COMPANY " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${lstm_cd_str} != '' ) " ).append("\n"); 
		query.append("		AND   T15.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("		     	                                 #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("		     	                                     '$key'," ).append("\n"); 
		query.append("		     	                                 #else" ).append("\n"); 
		query.append("		     	                                     '$key'" ).append("\n"); 
		query.append("		     	                                 #end" ).append("\n"); 
		query.append("		     	                             #end )" ).append("\n"); 
		query.append("		     		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/* CASE 2 */" ).append("\n"); 
		query.append("        SELECT  ROW_NUMBER() OVER(ORDER BY T13.CNTR_NO , T13.CNTR_TPSZ_CD) AS ROW_SEQ" ).append("\n"); 
		query.append("                , T10.CNTR_NO                                 AS CNTRNO" ).append("\n"); 
		query.append("                , T13.CNTR_TPSZ_CD                            AS TYSZ" ).append("\n"); 
		query.append("                , T10.AGMT_CTY_CD||LPAD(T10.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("                , T15.LSTM_CD                                 AS TERM" ).append("\n"); 
		query.append("                , T15.REF_NO                                  AS REF_NO" ).append("\n"); 
		query.append("                , T13.CNTR_AUTH_NO                            AS CNTR_AUTH_NO" ).append("\n"); 
		query.append("                , T13.CNMV_STS_CD                             AS CNMV_STS_CD" ).append("\n"); 
		query.append("                , TO_CHAR(T10.CNTR_STS_EVNT_DT, 'YYYYMMDD')   AS OHDATE" ).append("\n"); 
		query.append("                , T10.YD_CD                                   AS OHLOC" ).append("\n"); 
		query.append("                #if (${loc_tp} == 'R' ) " ).append("\n"); 
		query.append("				, T10.LCC_CD AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == 'L' ) " ).append("\n"); 
		query.append("                , T10.SCC_CD AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == 'S' ) " ).append("\n"); 
		query.append("                , T10.YD_CD  AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == '' ) " ).append("\n"); 
		query.append("                , T10.RCC_CD AS RCC" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                , T10.CNTR_LSTM_CNG_FLG                     AS TERM_CHANGE" ).append("\n"); 
		query.append("                , NVL(T10.RNTL_CHG_FREE_DYS , 0)            AS FDAYS" ).append("\n"); 
		query.append("                , TO_CHAR(T12.CNTR_STS_EVNT_DT, 'YYYYMMDD') AS OFHDATE" ).append("\n"); 
		query.append("                , T12.YD_CD                                 AS OFHLOC" ).append("\n"); 
		query.append("                , CASE WHEN ( T15.LSTM_CD = 'OW' OR T15.LSTM_CD = 'LP' OR T15.LSTM_CD = 'OL' ) THEN " ).append("\n"); 
		query.append("                        TRUNC(NVL(T12.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) -  T10.CNTR_STS_EVNT_DT) + 1" ).append("\n"); 
		query.append("                  ELSE " ).append("\n"); 
		query.append("                        TRUNC(NVL(T12.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) -  T10.CNTR_STS_EVNT_DT) + 1" ).append("\n"); 
		query.append("                  END                                       AS USEDDAYS" ).append("\n"); 
		query.append("                , NVL(T10.CNTR_MIN_ONH_DYS , 0 )            AS MINOHDAYS" ).append("\n"); 
		query.append("                , DECODE(T10.CNTR_STS_CD, 'DII', 'Y', 'N')  AS DII" ).append("\n"); 
		query.append("                , T13.IMDT_EXT_FLG                          AS IMMEDIATELY                " ).append("\n"); 
		query.append("                , NVL(GREATEST(" ).append("\n"); 
		query.append("            		  CASE WHEN T15.LSTM_CD IN('OW','LP','OL') " ).append("\n"); 
		query.append("                          THEN " ).append("\n"); 
		query.append("							   (TRUNC(NVL(T12.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - T10.CNTR_STS_EVNT_DT - NVL(T10.RNTL_CHG_FREE_DYS , 0 )) + 1 )" ).append("\n"); 
		query.append("                               * MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(T10.AGMT_CTY_CD, T10.AGMT_SEQ, 'PDM', T13.CNTR_TPSZ_CD, T10.YD_CD)" ).append("\n"); 
		query.append("                          ELSE  " ).append("\n"); 
		query.append("							   (TRUNC(NVL(T12.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - T10.CNTR_STS_EVNT_DT - NVL(T10.RNTL_CHG_FREE_DYS , 0 )) + 1 )" ).append("\n"); 
		query.append("                               * MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(T10.AGMT_CTY_CD, T10.AGMT_SEQ, 'PDM', T13.CNTR_TPSZ_CD, T10.YD_CD)" ).append("\n"); 
		query.append("                      END, 0), 0)                                                AS RENTAL_CHARGE" ).append("\n"); 
		query.append("            , NVL(T10.CNTR_LFT_CHG_AMT,0)                                        AS LON" ).append("\n"); 
		query.append("            , DECODE(SIGN(T10.CNTR_PKUP_CHG_AMT),  1,  T10.CNTR_PKUP_CHG_AMT, 0) AS PUC" ).append("\n"); 
		query.append("            , DECODE(SIGN(T10.CNTR_PKUP_CHG_AMT), -1, -T10.CNTR_PKUP_CHG_AMT, 0) AS PCR" ).append("\n"); 
		query.append("            , NVL(T12.CNTR_LFT_CHG_AMT,0)                                        AS LOF" ).append("\n"); 
		query.append("            , DECODE(SIGN(T12.CNTR_DRFF_CR_AMT),   1,  T12.CNTR_DRFF_CR_AMT,  0) AS DOC" ).append("\n"); 
		query.append("            , DECODE(SIGN(T12.CNTR_DRFF_CR_AMT),  -1, -T12.CNTR_DRFF_CR_AMT,  0) AS DCR" ).append("\n"); 
		query.append("            , ( SELECT  /*+ SO INDEX_DESC(XPKTRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("                        SO.NEGO_AMT" ).append("\n"); 
		query.append("                FROM    TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                WHERE   SO.EQ_NO                = T13.CNTR_NO" ).append("\n"); 
		query.append("                AND     SO.TRSP_COST_DTL_MOD_CD = 'CN' --CNTR S/T ON-HIRE" ).append("\n"); 
		query.append("                AND     ROWNUM                  = 1) AS ON_HIRE_DRAYAGE" ).append("\n"); 
		query.append("            , ( SELECT  /*+ SO INDEX_DESC(XPKTRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("                        SO.NEGO_AMT" ).append("\n"); 
		query.append("                FROM    TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                WHERE   SO.EQ_NO                = T13.CNTR_NO" ).append("\n"); 
		query.append("                AND     SO.TRSP_COST_DTL_MOD_CD = 'CF' --CNTR S/T OFF-HIRE" ).append("\n"); 
		query.append("                AND     ROWNUM                  = 1) AS OFF_HIRE_DRAYAGE" ).append("\n"); 
		query.append("            , ( SELECT  MNR_COMMON_PKG.MNR_GET_RPRCOST_FNC('U',  T13.CNTR_NO)" ).append("\n"); 
		query.append("                FROM    MNR_ORD_DTL OD," ).append("\n"); 
		query.append("                        MNR_ORD_HDR OH" ).append("\n"); 
		query.append("                WHERE   1=1" ).append("\n"); 
		query.append("                AND     OD.EQ_NO              = T13.CNTR_NO" ).append("\n"); 
		query.append("                AND     OD.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND     OD.MNR_ORD_SEQ        = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                GROUP BY T13.CNTR_NO ) AS M_R_COST" ).append("\n"); 
		query.append("            , (SELECT  RT.AGMT_CHG_VAL                                 " ).append("\n"); 
		query.append("               FROM    LSE_AGMT_RT RT,        " ).append("\n"); 
		query.append("                       LSE_AGREEMENT AM" ).append("\n"); 
		query.append("               WHERE   RT.AGMT_CTY_CD         = AM.AGMT_CTY_CD" ).append("\n"); 
		query.append("               AND     RT.AGMT_SEQ            = AM.AGMT_SEQ                              " ).append("\n"); 
		query.append("               AND     RT.CNTR_RNTL_CHG_TP_CD = 'DPPV'     " ).append("\n"); 
		query.append("               AND     AM.DPP_TP_CD           = 'Y'" ).append("\n"); 
		query.append("               AND     RT.AGMT_CTY_CD         = T12.AGMT_CTY_CD" ).append("\n"); 
		query.append("               AND     RT.AGMT_SEQ            = T12.AGMT_SEQ" ).append("\n"); 
		query.append("               AND     RT.CNTR_TPSZ_CD        = T13.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("               AND     TO_CHAR(T12.CNTR_STS_EVNT_DT, 'YYYYMMDD') BETWEEN PERIOD_STDT AND PERIOD_EDDT " ).append("\n"); 
		query.append("			   AND     ROWNUM                  = 1) AS DPP" ).append("\n"); 
		query.append("       FROM    (" ).append("\n"); 
		query.append("                SELECT  T01.CNTR_NO, T01.CNTR_STS_SEQ, T01.YD_CD, T01.AGMT_CTY_CD, T01.AGMT_SEQ, T01.CNTR_STS_EVNT_DT, T01.CNTR_STS_CD, T01.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("                	    , T01.RCC_CD, T01.LCC_CD, T01.SCC_CD, T01.CNTR_MIN_ONH_DYS, T01.RNTL_CHG_FREE_DYS, T01.CNTR_LFT_CHG_AMT, T01.CNTR_PKUP_CHG_AMT, " ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        SELECT /*+ INDEX_ASC(T02 XPKMST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                               CNTR_STS_SEQ" ).append("\n"); 
		query.append("                        FROM   MST_CNTR_STS_HIS T02" ).append("\n"); 
		query.append("                        WHERE  T01.CNTR_NO      = T02.CNTR_NO" ).append("\n"); 
		query.append("                        AND    T01.CNTR_STS_SEQ < T02.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                        AND    T02.CNTR_STS_CD  = 'LSO'" ).append("\n"); 
		query.append("                        AND    ROWNUM           = 1" ).append("\n"); 
		query.append("                        ) AS FST_CNTR_STS_SEQ" ).append("\n"); 
		query.append("                        , P.VNDR_SEQ, P.COMPANY, PERIOD_STDT, P.PERIOD_EDDT, P.DTL_CNTR_TP_SZ, P.LOC_CD" ).append("\n"); 
		query.append("                FROM    MST_CNTR_STS_HIS T01," ).append("\n"); 
		query.append("                        PARAM P" ).append("\n"); 
		query.append("                WHERE   1=1" ).append("\n"); 
		query.append("                AND     DECODE(TERM_CHANGE, 'N', 'N')   = TERM_CHANGE" ).append("\n"); 
		query.append("                #if (${dii} != '' )" ).append("\n"); 
		query.append("  			        		#if (${dii} == 'N' )" ).append("\n"); 
		query.append("                AND CNTR_STS_CD IN ('LSI','OWN')" ).append("\n"); 
		query.append("  			        		#elseif (${dii} == 'Y' ) " ).append("\n"); 
		query.append("                AND CNTR_STS_CD = 'DII'" ).append("\n"); 
		query.append("  			        		#end" ).append("\n"); 
		query.append("				        #else" ).append("\n"); 
		query.append("				        AND CNTR_STS_CD IN ('LSI','DII','OWN')" ).append("\n"); 
		query.append("				        #end" ).append("\n"); 
		query.append("                AND     T01.AGMT_SEQ      <> 999990                				" ).append("\n"); 
		query.append("                AND     CNTR_STS_EVNT_DT BETWEEN TO_DATE(P.PERIOD_STDT, 'YYYYMMDD') AND TO_DATE(P.PERIOD_EDDT, 'YYYYMMDD')                " ).append("\n"); 
		query.append("                ) T10," ).append("\n"); 
		query.append("                MST_CNTR_STS_HIS T12," ).append("\n"); 
		query.append("                MST_CONTAINER    T13," ).append("\n"); 
		query.append("                MDM_CNTR_TP_SZ   T14," ).append("\n"); 
		query.append("                LSE_AGREEMENT    T15," ).append("\n"); 
		query.append("                MDM_VENDOR       T17" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     T10.CNTR_NO             = T13.CNTR_NO" ).append("\n"); 
		query.append("        AND     T13.CNTR_TPSZ_CD        = T14.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        AND     T10.CNTR_NO             = T12.CNTR_NO      (+)  " ).append("\n"); 
		query.append("        AND     T10.FST_CNTR_STS_SEQ    = T12.CNTR_STS_SEQ (+)" ).append("\n"); 
		query.append("        AND     'N'                     = T10.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("        AND     'N'                     = NVL(T12.CNTR_LSTM_CNG_FLG,  'N')" ).append("\n"); 
		query.append("        AND     T10.AGMT_CTY_CD         = T15.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     T10.AGMT_SEQ            = T15.AGMT_SEQ" ).append("\n"); 
		query.append("        AND     T15.VNDR_SEQ            = T17.VNDR_SEQ" ).append("\n"); 
		query.append("        AND     T13.CO_CRE_FLG         = 'N'" ).append("\n"); 
		query.append("       	#if (${detail_lstm_cd} != '' ) " ).append("\n"); 
		query.append("        AND   T15.LSTM_CD = @[detail_lstm_cd] " ).append("\n"); 
		query.append("      	#end      " ).append("\n"); 
		query.append("      	#if (${detail_vndr_seq} != '' ) " ).append("\n"); 
		query.append("         AND   T15.VNDR_SEQ = @[detail_vndr_seq] " ).append("\n"); 
		query.append("      	#end            	" ).append("\n"); 
		query.append("      	#if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("        AND   T15.VNDR_SEQ = @[vndr_seq] " ).append("\n"); 
		query.append("      	#end " ).append("\n"); 
		query.append("        #if (${detail_cntr_tpsz_cd} != '' ) " ).append("\n"); 
		query.append("        AND     T13.CNTR_TPSZ_CD        = T10.DTL_CNTR_TP_SZ" ).append("\n"); 
		query.append("        #end   " ).append("\n"); 
		query.append("        #if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("		AND     T10.VNDR_SEQ            = T17.VNDR_SEQ" ).append("\n"); 
		query.append("		#end				" ).append("\n"); 
		query.append("		#if (${cntr_tpsz_cd_str} != '' )" ).append("\n"); 
		query.append("	    AND  T13.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("	        #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("	           '$key'," ).append("\n"); 
		query.append("	        #else" ).append("\n"); 
		query.append("	           '$key'" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("	                             #end )" ).append("\n"); 
		query.append("		     #end" ).append("\n"); 
		query.append("		#if (${company} != '' )" ).append("\n"); 
		query.append("		AND    T13.CNTR_USE_CO_CD = T10.COMPANY " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${lstm_cd_str} != '' ) " ).append("\n"); 
		query.append("		AND   T15.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("		     	                                 #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("		     	                                     '$key'," ).append("\n"); 
		query.append("		     	                                 #else" ).append("\n"); 
		query.append("		     	                                     '$key'" ).append("\n"); 
		query.append("		     	                                 #end" ).append("\n"); 
		query.append("		     	                             #end )" ).append("\n"); 
		query.append("		     		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/* CASE 3 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT  ROW_NUMBER() OVER(ORDER BY T10.CNTR_NO , T13.CNTR_TPSZ_CD) AS ROW_SEQ" ).append("\n"); 
		query.append("                , T10.CNTR_NO                                 AS CNTRNO" ).append("\n"); 
		query.append("                , T13.CNTR_TPSZ_CD                            AS TYSZ" ).append("\n"); 
		query.append("                , T10.AGMT_CTY_CD||LPAD(T10.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("                , T15.LSTM_CD                                 AS TERM" ).append("\n"); 
		query.append("                , T15.REF_NO                                  AS REF_NO" ).append("\n"); 
		query.append("                , T13.CNTR_AUTH_NO                            AS CNTR_AUTH_NO" ).append("\n"); 
		query.append("                , T13.CNMV_STS_CD                             AS CNMV_STS_CD" ).append("\n"); 
		query.append("                , TO_CHAR(T10.LSI_EVNT_DT, 'YYYYMMDD')   AS OHDATE" ).append("\n"); 
		query.append("                , T10.LSI_YD_CD                               AS OHLOC" ).append("\n"); 
		query.append("                #if (${loc_tp} == 'R' ) " ).append("\n"); 
		query.append("                , T10.LSI_LCC_CD AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == 'L' ) " ).append("\n"); 
		query.append("                , T10.LSI_SCC_CD AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == 'S' ) " ).append("\n"); 
		query.append("                , T10.LSI_YD_CD  AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == '' ) " ).append("\n"); 
		query.append("                , T10.LSI_RCC_CD AS RCC" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                , T10.CNTR_LSTM_CNG_FLG                     AS TERM_CHANGE" ).append("\n"); 
		query.append("                , NVL(T10.RNTL_CHG_FREE_DYS , 0)            AS FDAYS" ).append("\n"); 
		query.append("                , TO_CHAR(T10.LSO_EVNT_DT, 'YYYYMMDD')      AS OFHDATE" ).append("\n"); 
		query.append("                , T10.LSO_YD_CD                             AS OFHLOC" ).append("\n"); 
		query.append("                , CASE WHEN ( T15.LSTM_CD = 'OW' OR T15.LSTM_CD = 'LP' OR T15.LSTM_CD = 'OL' ) THEN " ).append("\n"); 
		query.append("                        TRUNC(NVL(T10.LSO_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) -  T10.LSI_EVNT_DT) + 1" ).append("\n"); 
		query.append("                  ELSE " ).append("\n"); 
		query.append("                        TRUNC(NVL(T10.LSO_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) -  T10.LSI_EVNT_DT) + 1" ).append("\n"); 
		query.append("                  END                                       AS USEDDAYS" ).append("\n"); 
		query.append("                , NVL(T10.LSI_MIN_ONH_DYS , 0 )             AS MINOHDAYS" ).append("\n"); 
		query.append("                , DECODE(T10.CNTR_STS_CD, 'DII', 'Y', 'N')  AS DII" ).append("\n"); 
		query.append("                , T13.IMDT_EXT_FLG                          AS IMMEDIATELY                " ).append("\n"); 
		query.append("                , NVL(GREATEST(" ).append("\n"); 
		query.append("            		  CASE WHEN T15.LSTM_CD IN('OW','LP','OL') " ).append("\n"); 
		query.append("                          THEN " ).append("\n"); 
		query.append("                              (TRUNC(NVL(T10.LSO_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - T10.LSI_EVNT_DT - NVL(T10.RNTL_CHG_FREE_DYS , 0 )) + 1 )" ).append("\n"); 
		query.append("                              * MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(T10.AGMT_CTY_CD, T10.AGMT_SEQ, 'PDM', T13.CNTR_TPSZ_CD, T10.YD_CD)" ).append("\n"); 
		query.append("                          ELSE  " ).append("\n"); 
		query.append("                              (TRUNC(NVL(T10.LSO_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE,'RRRR/MM/DD'),'RRRR/MM/DD')) - T10.LSI_EVNT_DT - NVL(T10.RNTL_CHG_FREE_DYS , 0 )) + 1 )" ).append("\n"); 
		query.append("                              * MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(T10.AGMT_CTY_CD, T10.AGMT_SEQ, 'PDM', T13.CNTR_TPSZ_CD, T10.YD_CD)" ).append("\n"); 
		query.append("                      END, 0), 0)                                              AS RENTAL_CHARGE" ).append("\n"); 
		query.append("            , NVL(T10.LSI_LFT_CHG_AMT,0)                                       AS LON" ).append("\n"); 
		query.append("            , DECODE(SIGN(T10.LSI_PKUP_CHG_AMT),  1,  T10.LSI_PKUP_CHG_AMT, 0) AS PUC" ).append("\n"); 
		query.append("            , DECODE(SIGN(T10.LSI_PKUP_CHG_AMT), -1, -T10.LSI_PKUP_CHG_AMT, 0) AS PCR            " ).append("\n"); 
		query.append("            , NVL(T10.LSO_LFT_CHG_AMT,0)                                       AS LOF            " ).append("\n"); 
		query.append("            , DECODE(SIGN(T10.LSO_DRFF_CR_AMT),   1,  T10.LSO_DRFF_CR_AMT,  0) AS DOC" ).append("\n"); 
		query.append("            , DECODE(SIGN(T10.LSO_DRFF_CR_AMT),  -1, -T10.LSO_DRFF_CR_AMT,  0) AS DCR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            , ( SELECT  /*+ SO INDEX_DESC(XPKTRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("                        SO.NEGO_AMT" ).append("\n"); 
		query.append("                FROM    TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                WHERE   SO.EQ_NO                = T13.CNTR_NO" ).append("\n"); 
		query.append("                AND     SO.TRSP_COST_DTL_MOD_CD = 'CN' --CNTR S/T ON-HIRE" ).append("\n"); 
		query.append("                AND     ROWNUM                  = 1) AS ON_HIRE_DRAYAGE" ).append("\n"); 
		query.append("            , ( SELECT  /*+ SO INDEX_DESC(XPKTRS_TRSP_SVC_ORD) */" ).append("\n"); 
		query.append("                        SO.NEGO_AMT" ).append("\n"); 
		query.append("                FROM    TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                WHERE   SO.EQ_NO                = T13.CNTR_NO" ).append("\n"); 
		query.append("                AND     SO.TRSP_COST_DTL_MOD_CD = 'CF' --CNTR S/T OFF-HIRE" ).append("\n"); 
		query.append("                AND     ROWNUM                  = 1) AS OFF_HIRE_DRAYAGE" ).append("\n"); 
		query.append("            , ( SELECT  MNR_COMMON_PKG.MNR_GET_RPRCOST_FNC('U',  T13.CNTR_NO)" ).append("\n"); 
		query.append("                FROM    MNR_ORD_DTL OD," ).append("\n"); 
		query.append("                        MNR_ORD_HDR OH" ).append("\n"); 
		query.append("                WHERE   1=1" ).append("\n"); 
		query.append("                AND     OD.EQ_NO              = T13.CNTR_NO" ).append("\n"); 
		query.append("                AND     OD.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND     OD.MNR_ORD_SEQ        = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                GROUP BY T13.CNTR_NO ) AS M_R_COST" ).append("\n"); 
		query.append("            , (SELECT  RT.AGMT_CHG_VAL                                 " ).append("\n"); 
		query.append("               FROM    LSE_AGMT_RT RT,        " ).append("\n"); 
		query.append("                       LSE_AGREEMENT AM" ).append("\n"); 
		query.append("               WHERE   RT.AGMT_CTY_CD         = AM.AGMT_CTY_CD" ).append("\n"); 
		query.append("               AND     RT.AGMT_SEQ            = AM.AGMT_SEQ                              " ).append("\n"); 
		query.append("               AND     RT.CNTR_RNTL_CHG_TP_CD = 'DPPV'     " ).append("\n"); 
		query.append("               AND     AM.DPP_TP_CD           = 'Y'" ).append("\n"); 
		query.append("               AND     RT.AGMT_CTY_CD         = T10.LSO_AGMT_CTY_CD" ).append("\n"); 
		query.append("               AND     RT.AGMT_SEQ            = T10.LSO_AGMT_SEQ" ).append("\n"); 
		query.append("               AND     RT.CNTR_TPSZ_CD        = T13.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("               AND     TO_CHAR(T10.LSO_EVNT_DT, 'YYYYMMDD') BETWEEN P_PERIOD_STDT AND P_PERIOD_EDDT " ).append("\n"); 
		query.append("				AND     ROWNUM                  = 1) AS DPP               " ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  T12.CNTR_NO, T12.YD_CD, T12.AGMT_CTY_CD, T12.AGMT_SEQ, T12.CNTR_STS_EVNT_DT AS LSI_EVNT_DT, T12.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                        , T12.CNTR_STS_CD, T12.CNTR_LSTM_CNG_FLG, T12.RCC_CD AS LSI_RCC_CD, T12.LCC_CD AS LSI_LCC_CD, T12.SCC_CD AS LSI_SCC_CD, T12.YD_CD AS LSI_YD_CD" ).append("\n"); 
		query.append("                        , T12.RNTL_CHG_FREE_DYS" ).append("\n"); 
		query.append("                        , T12.CNTR_MIN_ONH_DYS  AS LSI_MIN_ONH_DYS" ).append("\n"); 
		query.append("                        , T12.CNTR_LFT_CHG_AMT  AS LSI_LFT_CHG_AMT" ).append("\n"); 
		query.append("                        , T12.CNTR_PKUP_CHG_AMT AS LSI_PKUP_CHG_AMT" ).append("\n"); 
		query.append("                        , T11.VNDR_SEQ, T11.COMPANY, T11.P_LOC_TP, T11.P_LOC_CD" ).append("\n"); 
		query.append("                        , ROW_NUMBER(               ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS RN" ).append("\n"); 
		query.append("                        , LEAD(T12.RCC_CD           ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_RCC_CD                        " ).append("\n"); 
		query.append("                        , LEAD(T12.LCC_CD           ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_LCC_CD" ).append("\n"); 
		query.append("                        , LEAD(T12.SCC_CD           ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_SCC_CD" ).append("\n"); 
		query.append("                        , LEAD(T12.YD_CD            ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_YD_CD                        " ).append("\n"); 
		query.append("                        , LEAD(T12.CNTR_STS_CD      ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_STS_CD" ).append("\n"); 
		query.append("                        , LEAD(T12.AGMT_CTY_CD      ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_AGMT_CTY_CD" ).append("\n"); 
		query.append("                        , LEAD(T12.AGMT_SEQ         ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_AGMT_SEQ" ).append("\n"); 
		query.append("                        , LEAD(T12.CNTR_STS_EVNT_DT ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_EVNT_DT" ).append("\n"); 
		query.append("                        , LEAD(T12.CNTR_STS_SEQ     ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_STS_SEQ" ).append("\n"); 
		query.append("                        , LEAD(T12.CNTR_LSTM_CNG_FLG) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_LSTM_CHG_CD" ).append("\n"); 
		query.append("                        , LEAD(T12.CNTR_LFT_CHG_AMT ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_LFT_CHG_AMT" ).append("\n"); 
		query.append("                        , LEAD(T12.CNTR_DRFF_CR_AMT ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_DRFF_CR_AMT" ).append("\n"); 
		query.append("                        , P_PERIOD_STDT, P_PERIOD_EDDT, DTL_CNTR_TP_SZ" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                        SELECT T01.CNTR_NO," ).append("\n"); 
		query.append("                               T01.CNTR_STS_SEQ," ).append("\n"); 
		query.append("                               T01.YD_CD," ).append("\n"); 
		query.append("                               T01.AGMT_CTY_CD," ).append("\n"); 
		query.append("                               T01.AGMT_SEQ," ).append("\n"); 
		query.append("                               T01.CNTR_STS_EVNT_DT," ).append("\n"); 
		query.append("                               T01.CNTR_STS_CD," ).append("\n"); 
		query.append("                               T01.CNTR_LSTM_CNG_FLG," ).append("\n"); 
		query.append("                               T01.RCC_CD," ).append("\n"); 
		query.append("                               (SELECT /*+ INDEX_ASC(T03 XPKMST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                       CNTR_STS_SEQ" ).append("\n"); 
		query.append("                                FROM   MST_CNTR_STS_HIS T03" ).append("\n"); 
		query.append("                                WHERE  T02.CNTR_NO = T03.CNTR_NO" ).append("\n"); 
		query.append("                                AND    T02.CNTR_STS_SEQ < T03.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                                AND    T03.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("                                AND    T03.CNTR_STS_CD = 'LSO'" ).append("\n"); 
		query.append("                                AND    ROWNUM = 1 ) AS LSO_CNTR_STS_SEQ ," ).append("\n"); 
		query.append("                               P.VNDR_SEQ," ).append("\n"); 
		query.append("                               P.COMPANY,                               " ).append("\n"); 
		query.append("                               P.LOC_TP AS P_LOC_TP," ).append("\n"); 
		query.append("                               P.LOC_CD AS P_LOC_CD,							   " ).append("\n"); 
		query.append("                               P.PERIOD_STDT AS P_PERIOD_STDT, " ).append("\n"); 
		query.append("                               P.PERIOD_EDDT AS P_PERIOD_EDDT, " ).append("\n"); 
		query.append("                               P.DTL_CNTR_TP_SZ AS DTL_CNTR_TP_SZ" ).append("\n"); 
		query.append("                        FROM   MST_CNTR_STS_HIS T01," ).append("\n"); 
		query.append("                         /* LSI */" ).append("\n"); 
		query.append("                          MST_CNTR_STS_HIS T02," ).append("\n"); 
		query.append("                         /* LSI 이후 TERM CHANAGED LSO */" ).append("\n"); 
		query.append("                          PARAM P" ).append("\n"); 
		query.append("                        WHERE  1=1" ).append("\n"); 
		query.append("                        AND    DECODE(TERM_CHANGE, 'Y', 'Y') = TERM_CHANGE" ).append("\n"); 
		query.append("                        AND    T01.CNTR_NO = T02.CNTR_NO" ).append("\n"); 
		query.append("                        AND    T01.CNTR_STS_SEQ = T02.PRNR_STS_SEQ " ).append("\n"); 
		query.append("                    #if (${dii} != '' ) " ).append("\n"); 
		query.append("                       #if (${dii} == 'N' )" ).append("\n"); 
		query.append("                        AND    T01.CNTR_STS_CD IN ('LSI','OWN') " ).append("\n"); 
		query.append("                       #elseif (${dii} == 'Y' )" ).append("\n"); 
		query.append("                        AND    T01.CNTR_STS_CD = 'DII' " ).append("\n"); 
		query.append("                       #end " ).append("\n"); 
		query.append("                   #else" ).append("\n"); 
		query.append("                        AND    T01.CNTR_STS_CD IN ('LSI','DII','OWN') " ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                        AND    T02.CNTR_LSTM_CNG_FLG = 'Y'" ).append("\n"); 
		query.append("                        AND    T01.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("                        AND    T01.CNTR_STS_EVNT_DT BETWEEN TO_DATE(P.PERIOD_STDT, 'YYYYMMDD') AND TO_DATE(P.PERIOD_EDDT, 'YYYYMMDD') " ).append("\n"); 
		query.append("                        ) T11, MST_CNTR_STS_HIS T12                        " ).append("\n"); 
		query.append("                WHERE   T11.CNTR_NO         = T12.CNTR_NO" ).append("\n"); 
		query.append("                AND     T12.CNTR_STS_SEQ    IN (T11.CNTR_STS_SEQ, T11.LSO_CNTR_STS_SEQ)" ).append("\n"); 
		query.append("                )                T10," ).append("\n"); 
		query.append("                MST_CONTAINER    T13," ).append("\n"); 
		query.append("                MDM_CNTR_TP_SZ   T14," ).append("\n"); 
		query.append("                LSE_AGREEMENT    T15," ).append("\n"); 
		query.append("                MDM_VENDOR       T17" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     T10.CNTR_NO             = T13.CNTR_NO" ).append("\n"); 
		query.append("        AND     T13.CNTR_TPSZ_CD        = T14.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        AND     T10.AGMT_CTY_CD         = T15.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     T10.AGMT_SEQ            = T15.AGMT_SEQ" ).append("\n"); 
		query.append("        AND     T15.VNDR_SEQ            = T17.VNDR_SEQ" ).append("\n"); 
		query.append("        AND     T13.CO_CRE_FLG         = 'N'" ).append("\n"); 
		query.append("        AND     RN                      = 1" ).append("\n"); 
		query.append("        #if (${detail_lstm_cd} != '' ) " ).append("\n"); 
		query.append("        AND   T15.LSTM_CD = @[detail_lstm_cd] " ).append("\n"); 
		query.append("      	#end      " ).append("\n"); 
		query.append("      	#if (${detail_vndr_seq} != '' ) " ).append("\n"); 
		query.append("         AND   T15.VNDR_SEQ = @[detail_vndr_seq] " ).append("\n"); 
		query.append("      	#end            	" ).append("\n"); 
		query.append("      	#if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("        AND   T15.VNDR_SEQ = @[vndr_seq] " ).append("\n"); 
		query.append("      	#end " ).append("\n"); 
		query.append("        #if (${detail_cntr_tpsz_cd} != '' ) " ).append("\n"); 
		query.append("        AND     T13.CNTR_TPSZ_CD        = T10.DTL_CNTR_TP_SZ" ).append("\n"); 
		query.append("        #end      " ).append("\n"); 
		query.append("        #if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("		AND     T10.VNDR_SEQ            = T17.VNDR_SEQ" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${detail_agmt_seq} != '' && ${detail_agmt_cty_cd} != 'ZZ' )" ).append("\n"); 
		query.append("		AND T10.AGMT_CTY_CD     = P_AGMT_CTY_CD       " ).append("\n"); 
		query.append("		AND T10.AGMT_SEQ        = P_AGMT_SEQ" ).append("\n"); 
		query.append("		#end				" ).append("\n"); 
		query.append("		#if (${cntr_tpsz_cd_str} != '' )" ).append("\n"); 
		query.append("	    AND  T13.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("	                                     #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("	                                        '$key'," ).append("\n"); 
		query.append("	                                     #else" ).append("\n"); 
		query.append("	                                        '$key'" ).append("\n"); 
		query.append("	                                     #end" ).append("\n"); 
		query.append("	                                 #end )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${company} != '' )" ).append("\n"); 
		query.append("		AND T13.CNTR_USE_CO_CD = T10.COMPANY " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${lstm_cd_str} != '' ) " ).append("\n"); 
		query.append("		AND   T15.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("			                                 #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("			                                     '$key'," ).append("\n"); 
		query.append("			                                 #else" ).append("\n"); 
		query.append("			                                     '$key'" ).append("\n"); 
		query.append("			                                 #end" ).append("\n"); 
		query.append("			                             #end )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("#if (${startno} != '') " ).append("\n"); 
		query.append("AND 	ROW_SEQ BETWEEN @[startno] AND @[endno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}