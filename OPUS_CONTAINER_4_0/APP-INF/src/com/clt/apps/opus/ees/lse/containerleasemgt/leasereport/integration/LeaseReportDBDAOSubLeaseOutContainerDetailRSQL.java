/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LeaseReportDBDAOSubLeaseOutContainerDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseReportDBDAOSubLeaseOutContainerDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sub Lease 자사장비 및 Mis Use 타사장비의 상세내역을 조회합니다.
	  * 2010.12.01 박명신 [CHM-201007443-01] REF_NO 항목 추가
	  * 2010.12.13 신자영 [CHM-201007442-01] LT일때 Per-Diem LCC로 변경
	  * </pre>
	  */
	public LeaseReportDBDAOSubLeaseOutContainerDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_onh_auth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_free_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_full_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOSubLeaseOutContainerDetailRSQL").append("\n"); 
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
		query.append("SELECT  ROW_SEQ" ).append("\n"); 
		query.append("        , CNTR_NO, CNTR_STS_CD, CNTR_TPSZ_CD, LSTM_CD " ).append("\n"); 
		query.append("        , CNTR_STS_EVNT_DT, CNTR_RTN_EVNT_DT, RCC_CD, LCC_CD, SCC_CD, LOC_CD" ).append("\n"); 
		query.append("        , YD_CD, RTN_YD_CD, CNTRY_CD" ).append("\n"); 
		query.append("        , LSI_AGMT_CTY_CD, LSI_AGMT_SEQ, LSI_AGMT_NO, LSI_REF_NO" ).append("\n"); 
		query.append("        , AGMT_CTY_CD    , AGMT_SEQ    , AGMT_NO    , REF_NO" ).append("\n"); 
		query.append("        , APPROVAL_NO, VNDR_SEQ, VNDR_ABBR_NM, CNTR_FULL_FLG" ).append("\n"); 
		query.append("        , RNTL_CHG_FREE_DYS" ).append("\n"); 
		query.append("--        , TTL_USE_DYS" ).append("\n"); 
		query.append("		,DECODE(MST_COMMON_PKG.MST_HO_OFC_CHK_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append(" 				,'Y',TTL_USE_DYS " ).append("\n"); 
		query.append(" 				,'N','') AS TTL_USE_DYS" ).append("\n"); 
		query.append("--      , DECODE(SIGN(PDM_AMT), -1, 0, PDM_AMT) AS PDM_AMT" ).append("\n"); 
		query.append("		,DECODE(MST_COMMON_PKG.MST_HO_OFC_CHK_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append(" 				,'Y',DECODE(SIGN(PDM_AMT), -1, 0, PDM_AMT) " ).append("\n"); 
		query.append(" 				,'N','') AS PDM_AMT" ).append("\n"); 
		query.append("		, LON_AMT, LOF_AMT, DOC_AMT" ).append("\n"); 
		query.append("--      , NVL(DECODE(SIGN(PDM_AMT), -1, 0, PDM_AMT), 0) + LON_AMT + LOF_AMT + DOC_AMT AS TTL_AMT" ).append("\n"); 
		query.append("		,DECODE(MST_COMMON_PKG.MST_HO_OFC_CHK_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append(" 				,'Y',NVL(DECODE(SIGN(PDM_AMT), -1, 0, PDM_AMT), 0) + LON_AMT + LOF_AMT + DOC_AMT " ).append("\n"); 
		query.append(" 				,'N','') AS TTL_AMT" ).append("\n"); 
		query.append("FROM   (SELECT /*+ ORDERED */ " ).append("\n"); 
		query.append("               ROWNUM                                                                     AS ROW_SEQ" ).append("\n"); 
		query.append("               , B.CNTR_NO, B.CNTR_STS_CD, A.CNTR_TPSZ_CD, A.LSTM_CD" ).append("\n"); 
		query.append("               , B.RCC_CD, B.LCC_CD, B.SCC_CD, B.YD_CD, B.LOC_CD" ).append("\n"); 
		query.append("               , TO_CHAR(B.CNTR_STS_EVNT_DT,'YYYYMMDD')                                 AS CNTR_STS_EVNT_DT " ).append("\n"); 
		query.append("               , (SELECT /*+ INDEX_ASC(SUB XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                TO_CHAR(SUB.CNTR_STS_EVNT_DT,'YYYYMMDD')    " ).append("\n"); 
		query.append("                     FROM MST_CNTR_STS_HIS SUB" ).append("\n"); 
		query.append("                    WHERE B.CNTR_NO                   = SUB.CNTR_NO" ).append("\n"); 
		query.append("                       AND SUB.CNTR_STS_CD           = DECODE(B.CNTR_STS_CD, 'SBO', 'SBI', 'MUI')" ).append("\n"); 
		query.append("                        AND SUB.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("                         AND B.CNTR_STS_EVNT_DT     <= SUB.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("                         AND ROWNUM          = 1) AS CNTR_RTN_EVNT_DT              " ).append("\n"); 
		query.append("               , SUBSTR(B.LOC_CD,1,2)                                                     AS CNTRY_CD" ).append("\n"); 
		query.append("               , A.AGMT_CTY_CD AS LSI_AGMT_CTY_CD, A.AGMT_SEQ AS LSI_AGMT_SEQ, A.AGMT_CTY_CD||LPAD(A.AGMT_SEQ, 6, '0')     AS LSI_AGMT_NO, F.REF_NO AS LSI_REF_NO" ).append("\n"); 
		query.append("               , B.AGMT_CTY_CD                   , B.AGMT_SEQ                , B.AGMT_CTY_CD||LPAD(B.AGMT_SEQ, 6, '0')     AS AGMT_NO    , C.REF_NO" ).append("\n"); 
		query.append("#if (${cntr_sts_cd} == '(SB|MU)O' || ${cntr_sts_cd} == 'SBO' || ${cntr_sts_cd} == 'MUO')" ).append("\n"); 
		query.append("	#if (${lst_sts_flg} == '01')		" ).append("\n"); 
		query.append("	, A.CNTR_OFFH_AUTH_NO                                                    AS APPROVAL_NO" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	, B.CNTR_OFFH_AUTH_NO                                                    AS APPROVAL_NO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${lst_sts_flg} == '01')		" ).append("\n"); 
		query.append("	, A.CNTR_AUTH_NO                                                    AS APPROVAL_NO" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	, B.CNTR_AUTH_NO                                                    AS APPROVAL_NO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               , C.VNDR_SEQ, SUBSTR(NVL(D.VNDR_ABBR_NM, D.VNDR_SEQ),0,8)                 AS VNDR_ABBR_NM" ).append("\n"); 
		query.append("               , B.CNTR_FULL_FLG" ).append("\n"); 
		query.append("               , B.RNTL_CHG_FREE_DYS" ).append("\n"); 
		query.append("               , (SELECT /*+ INDEX_ASC(SUB XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                SUB.YD_CD" ).append("\n"); 
		query.append("                     FROM MST_CNTR_STS_HIS SUB" ).append("\n"); 
		query.append("                    WHERE B.CNTR_NO                   = SUB.CNTR_NO" ).append("\n"); 
		query.append("                       AND SUB.CNTR_STS_CD           = DECODE(B.CNTR_STS_CD, 'SBO', 'SBI', 'MUI')" ).append("\n"); 
		query.append("                        AND SUB.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("                         AND B.CNTR_STS_EVNT_DT     <= SUB.CNTR_STS_EVNT_DT " ).append("\n"); 
		query.append("                         AND ROWNUM          = 1) AS RTN_YD_CD                " ).append("\n"); 
		query.append("                 , TRUNC(NVL((SELECT /*+ INDEX_ASC(SUB XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                            SUB.CNTR_STS_EVNT_DT  " ).append("\n"); 
		query.append("                                   FROM MST_CNTR_STS_HIS SUB " ).append("\n"); 
		query.append("                                  WHERE B.CNTR_NO                   = SUB.CNTR_NO" ).append("\n"); 
		query.append("                                     AND SUB.CNTR_STS_CD           = DECODE(B.CNTR_STS_CD, 'SBO', 'SBI', 'MUI')" ).append("\n"); 
		query.append("                                     AND SUB.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("                                     AND B.CNTR_STS_EVNT_DT     <= SUB.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("                                      AND ROWNUM          = 1" ).append("\n"); 
		query.append("                                  ), TRUNC(SYSDATE)) - B.CNTR_STS_EVNT_DT)+1 AS TTL_USE_DYS                 " ).append("\n"); 
		query.append("              , ((TRUNC(NVL((SELECT /*+ INDEX_ASC(SUB XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                            SUB.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("                                   FROM MST_CNTR_STS_HIS SUB" ).append("\n"); 
		query.append("                                  WHERE B.CNTR_NO                   = SUB.CNTR_NO" ).append("\n"); 
		query.append("                                     AND SUB.CNTR_STS_CD           = DECODE(B.CNTR_STS_CD, 'SBO', 'SBI', 'MUI')" ).append("\n"); 
		query.append("                                     AND SUB.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("                                     AND B.CNTR_STS_EVNT_DT     <= SUB.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("                                      AND ROWNUM          = 1              " ).append("\n"); 
		query.append("                                 ),SYSDATE) - B.CNTR_STS_EVNT_DT  - NVL(B.RNTL_CHG_FREE_DYS , 0))) + 1)" ).append("\n"); 
		query.append("                * MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC(B.AGMT_CTY_CD, B.AGMT_SEQ, 'PDM', A.CNTR_TPSZ_CD, B.YD_CD) AS PDM_AMT" ).append("\n"); 
		query.append("               , NVL(B.CNTR_LFT_CHG_AMT,0) AS LON_AMT" ).append("\n"); 
		query.append("               , NVL((SELECT /*+ INDEX_ASC(SUB XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                SUB.CNTR_LFT_CHG_AMT" ).append("\n"); 
		query.append("                     FROM MST_CNTR_STS_HIS SUB" ).append("\n"); 
		query.append("                    WHERE B.CNTR_NO                   = SUB.CNTR_NO" ).append("\n"); 
		query.append("                       AND SUB.CNTR_STS_CD           = DECODE(B.CNTR_STS_CD, 'SBO', 'SBI', 'MUI')" ).append("\n"); 
		query.append("                        AND SUB.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("                         AND B.CNTR_STS_EVNT_DT     <= SUB.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("                         AND ROWNUM          = 1), 0)   AS LOF_AMT       " ).append("\n"); 
		query.append("                 , NVL((SELECT /*+ INDEX_ASC(SUB XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                SUB.CNTR_DRFF_CR_AMT" ).append("\n"); 
		query.append("                     FROM MST_CNTR_STS_HIS SUB" ).append("\n"); 
		query.append("                    WHERE B.CNTR_NO                   = SUB.CNTR_NO" ).append("\n"); 
		query.append("                       AND SUB.CNTR_STS_CD           = DECODE(B.CNTR_STS_CD, 'SBO', 'SBI', 'MUI')" ).append("\n"); 
		query.append("                        AND SUB.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("                         AND B.CNTR_STS_EVNT_DT     <= SUB.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("                         AND ROWNUM          = 1), 0)   AS DOC_AMT       " ).append("\n"); 
		query.append("        FROM    MST_CONTAINER    A," ).append("\n"); 
		query.append("                MST_CNTR_STS_HIS B," ).append("\n"); 
		query.append("                LSE_AGREEMENT    C," ).append("\n"); 
		query.append("                MDM_VENDOR       D," ).append("\n"); 
		query.append("                LSE_AGREEMENT    F" ).append("\n"); 
		query.append("#if (${cntr_sts_cd} == '(SB|MU)O' || ${cntr_sts_cd} == 'SBO' || ${cntr_sts_cd} == 'MUO')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              , MST_CNTR_STS_HIS E" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        WHERE   A.CNTR_NO      = B.CNTR_NO" ).append("\n"); 
		query.append("        AND     B.AGMT_CTY_CD  = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     B.AGMT_SEQ     = C.AGMT_SEQ" ).append("\n"); 
		query.append("        AND     C.VNDR_SEQ     = D.VNDR_SEQ" ).append("\n"); 
		query.append("        AND     A.AGMT_CTY_CD  = F.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     A.AGMT_SEQ     = F.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${cntr_sts_cd} == '(SB|MU)O' || ${cntr_sts_cd} == 'SBO' || ${cntr_sts_cd} == 'MUO')" ).append("\n"); 
		query.append("	#if (${lst_sts_flg} == '01')" ).append("\n"); 
		query.append("        AND     B.CNTR_STS_SEQ = ( SELECT /*+ INDEX_DESC(SUB XAK1MST_CNTR_STS_HIS) */ " ).append("\n"); 
		query.append("                                                 SUB.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                                     FROM MST_CNTR_STS_HIS SUB" ).append("\n"); 
		query.append("                                    WHERE SUB.CNTR_NO               = A.CNTR_NO" ).append("\n"); 
		query.append("                                      AND SUB.CNTR_STS_CD           = A.CNTR_STS_CD                                                                                       " ).append("\n"); 
		query.append("                                      AND SUB.CNTR_LSTM_CNG_FLG     = 'N'" ).append("\n"); 
		query.append("                                      AND ROWNUM                    = 1)" ).append("\n"); 
		query.append("		#if(${cntr_onh_auth_no} != '')" ).append("\n"); 
		query.append("			AND   A.CNTR_OFFH_AUTH_NO = @[cntr_onh_auth_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	    #if (${cntr_sts_cd} == '(SB|MU)O' )" ).append("\n"); 
		query.append("           AND		A.CNTR_STS_CD IN('SBO','MUO')" ).append("\n"); 
		query.append("	    #else" ).append("\n"); 
		query.append("           AND		A.CNTR_STS_CD = @[cntr_sts_cd]" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND     B.CNTR_LSTM_CNG_FLG  = 'N'" ).append("\n"); 
		query.append("		#if(${cntr_onh_auth_no} != '')" ).append("\n"); 
		query.append("			AND   B.CNTR_OFFH_AUTH_NO = @[cntr_onh_auth_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${cntr_sts_cd} == '(SB|MU)O' )" ).append("\n"); 
		query.append("        AND		B.CNTR_STS_CD IN('SBO','MUO')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("        AND		B.CNTR_STS_CD = @[cntr_sts_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${total_flg} != 'Y')" ).append("\n"); 
		query.append("		#if (${loc_tp} == '0' && ${loc_cd} != '')" ).append("\n"); 
		query.append("	        AND     B.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_tp} == '1' && ${loc_cd} != '')" ).append("\n"); 
		query.append("	        AND     SUBSTR(B.LOC_CD,1,2) = @[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_tp} == '2' && ${loc_cd} != '')" ).append("\n"); 
		query.append("	        AND     B.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_tp} == '3' && ${loc_cd} != '')" ).append("\n"); 
		query.append("	        AND     B.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_tp} == '4' && ${loc_cd} != '')" ).append("\n"); 
		query.append("	        AND     B.YD_CD LIKE @[loc_cd] || '%'" ).append("\n"); 
		query.append("		#elseif (${loc_tp} == '5' && ${loc_cd} != '')" ).append("\n"); 
		query.append("	        AND     SUBSTR(B.LOC_CD,1,2) = @[loc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	    #if     (${loc_tp} == '2' && ${loc_cd} != '')" ).append("\n"); 
		query.append("	        AND     B.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_tp} == '3' && ${loc_cd} != '')" ).append("\n"); 
		query.append("	        AND     B.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_tp} == '4' && ${loc_cd} != '')" ).append("\n"); 
		query.append("	        AND     B.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_tp} == '5' && ${loc_cd} != '')" ).append("\n"); 
		query.append("	        AND     SUBSTR(B.LOC_CD,1,2) = @[loc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${str_evnt_dt} != '')" ).append("\n"); 
		query.append("        AND     B.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[str_evnt_dt],'YYYYMMDD')  " ).append("\n"); 
		query.append("        AND 	TO_DATE(@[end_evnt_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("        AND     B.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("        AND     B.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cntr_full_flg} != '')" ).append("\n"); 
		query.append("        AND     B.CNTR_FULL_FLG = @[cntr_full_flg]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        AND     B.CNTR_NO             = E.CNTR_NO" ).append("\n"); 
		query.append("        AND     B.CNTR_STS_SEQ        = ( SELECT /*+ INDEX_DESC(SUB XAK1MST_CNTR_STS_HIS) */ " ).append("\n"); 
		query.append("                                                 SUB.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                                            FROM MST_CNTR_STS_HIS SUB" ).append("\n"); 
		query.append("                                           WHERE SUB.CNTR_NO               = A.CNTR_NO                                                                                          " ).append("\n"); 
		query.append("                                             AND SUB.CNTR_STS_CD           = SUBSTR(E.CNTR_STS_CD, 1, 2)||'O'" ).append("\n"); 
		query.append("                                             AND SUB.CNTR_LSTM_CNG_FLG     = 'N'" ).append("\n"); 
		query.append("                                             AND ROWNUM                    = 1)" ).append("\n"); 
		query.append("        AND     E.CNTR_LSTM_CNG_FLG   = 'N'" ).append("\n"); 
		query.append("	#if (${lst_sts_flg} == '01')" ).append("\n"); 
		query.append("		#if(${cntr_onh_auth_no} != '')" ).append("\n"); 
		query.append("			AND   A.CNTR_AUTH_NO = @[cntr_onh_auth_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    	AND     A.LST_STS_SEQ = E.CNTR_STS_SEQ" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if(${cntr_onh_auth_no} != '')" ).append("\n"); 
		query.append("			AND   B.CNTR_AUTH_NO = @[cntr_onh_auth_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cntr_sts_cd} == '(SB|MU)I' )" ).append("\n"); 
		query.append("		AND		E.CNTR_STS_CD IN('SBI','MUI')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND		E.CNTR_STS_CD = @[cntr_sts_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${loc_tp} == '0' && ${loc_cd} != '')" ).append("\n"); 
		query.append("        AND     E.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '1' && ${loc_cd} != '')" ).append("\n"); 
		query.append("        AND     SUBSTR(E.LOC_CD,1,2) = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '2' && ${loc_cd} != '')" ).append("\n"); 
		query.append("        AND     E.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '3' && ${loc_cd} != '')" ).append("\n"); 
		query.append("        AND     E.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '4' && ${loc_cd} != '')" ).append("\n"); 
		query.append("        AND     E.YD_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '5' && ${loc_cd} != '')" ).append("\n"); 
		query.append("        AND     SUBSTR(E.LOC_CD,1,2) = @[loc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${str_evnt_dt} != '')" ).append("\n"); 
		query.append("        AND     E.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[str_evnt_dt],'YYYYMMDD') AND 	TO_DATE(@[end_evnt_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("        AND     E.AGMT_CTY_CD 	= @[agmt_cty_cd]" ).append("\n"); 
		query.append("        AND     E.AGMT_SEQ    	= @[agmt_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cntr_full_flg} != '')" ).append("\n"); 
		query.append("        AND     E.CNTR_FULL_FLG = @[cntr_full_flg]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end		" ).append("\n"); 
		query.append("#if (${lstm_soc_tp} == '03')" ).append("\n"); 
		query.append("        AND     A.LSTM_CD = 'SH'" ).append("\n"); 
		query.append("#elseif (${lstm_soc_tp} == '02')" ).append("\n"); 
		query.append("        AND     A.LSTM_CD 			<> 'SH'" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("        AND     C.VNDR_SEQ 			= @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${onh_free_dys} != '')" ).append("\n"); 
		query.append("	AND @[onh_free_dys] <= DECODE(MST_COMMON_PKG.MST_HO_OFC_CHK_FNC(@[usr_ofc_cd])" ).append("\n"); 
		query.append(" 				,'Y', " ).append("\n"); 
		query.append("		TRUNC(NVL((SELECT /*+ INDEX_ASC(SUB XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                            SUB.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("                                   FROM MST_CNTR_STS_HIS SUB" ).append("\n"); 
		query.append("                                  WHERE B.CNTR_NO                   = SUB.CNTR_NO" ).append("\n"); 
		query.append("                                     AND SUB.CNTR_STS_CD           = DECODE(B.CNTR_STS_CD, 'SBO', 'SBI', 'MUI')" ).append("\n"); 
		query.append("                                     AND SUB.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("                                     AND B.CNTR_STS_EVNT_DT     <= SUB.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("                                      AND ROWNUM          = 1" ).append("\n"); 
		query.append("                                  ), TRUNC(SYSDATE)) - B.CNTR_STS_EVNT_DT)+1" ).append("\n"); 
		query.append(" 				,'N','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("        AND     A.LSTM_CD IN (" ).append("\n"); 
		query.append("   	#foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("   		#if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("   			'$key'," ).append("\n"); 
		query.append("   		#else" ).append("\n"); 
		query.append("   			'$key'" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("        AND     A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("   	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("   		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("   			'$key'," ).append("\n"); 
		query.append("   		#else" ).append("\n"); 
		query.append("   			'$key'" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${startno} != '') " ).append("\n"); 
		query.append("WHERE 	ROW_SEQ BETWEEN @[startno] AND @[endno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}