/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LeaseReportDBDAOSubLeaseOutContainerSummaryListRSQL.java
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

public class LeaseReportDBDAOSubLeaseOutContainerSummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sub Lease 자사장비 및 Mis Use 타사장비의 현황목록을 조회합니다.
	  * REF_NO 항목 추가
	  * </pre>
	  */
	public LeaseReportDBDAOSubLeaseOutContainerSummaryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_onh_auth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOSubLeaseOutContainerSummaryListRSQL").append("\n"); 
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
		query.append("WITH TEMP_DROP AS (" ).append("\n"); 
		query.append("    SELECT  /*+ ORDERED XXXXX*/   " ).append("\n"); 
		query.append("			B.RCC_CD, B.LCC_CD, B.SCC_CD, B.YD_CD, " ).append("\n"); 
		query.append("            SUBSTR(B.LOC_CD,1,2) AS CNTRY_CD, " ).append("\n"); 
		query.append("            B.CNTR_NO, B.CNTR_STS_CD, B.CNTR_STS_EVNT_DT, " ).append("\n"); 
		query.append("            B.AGMT_CTY_CD, B.AGMT_SEQ, C.VNDR_SEQ," ).append("\n"); 
		query.append("            SUBSTR(NVL(D.VNDR_ABBR_NM, D.VNDR_SEQ),0,8) AS VNDR_ABBR_NM," ).append("\n"); 
		query.append("            A.LSTM_CD, A.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("            B.CNTR_FULL_FLG, A.ONH_FREE_DYS         " ).append("\n"); 
		query.append("    FROM    MST_CONTAINER A," ).append("\n"); 
		query.append("            MST_CNTR_STS_HIS B, " ).append("\n"); 
		query.append("            LSE_AGREEMENT C," ).append("\n"); 
		query.append("            MDM_VENDOR D" ).append("\n"); 
		query.append("    WHERE   A.CNTR_NO = B.CNTR_NO     " ).append("\n"); 
		query.append("    AND     B.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("    AND     B.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("    AND     C.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("#if (${lst_sts_flg} == '01')" ).append("\n"); 
		query.append("    AND     B.CNTR_STS_SEQ = ( SELECT /*+ INDEX_DESC(SUB XAK1MST_CNTR_STS_HIS) */ " ).append("\n"); 
		query.append("                                                 SUB.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                                          FROM MST_CNTR_STS_HIS SUB" ).append("\n"); 
		query.append("                                         WHERE SUB.CNTR_NO               = A.CNTR_NO                                                                                          " ).append("\n"); 
		query.append("                                           AND SUB.CNTR_STS_CD           = A.CNTR_STS_CD" ).append("\n"); 
		query.append("                                           AND SUB.CNTR_LSTM_CNG_FLG     = 'N'" ).append("\n"); 
		query.append("                                           AND ROWNUM                    = 1)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND      B.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${cntr_sts_cd} == '(SB|MU)O' )" ).append("\n"); 
		query.append("	AND		B.CNTR_STS_CD IN('SBO','MUO')" ).append("\n"); 
		query.append("#elseif (${cntr_sts_cd} == '(SB|MU)I' )" ).append("\n"); 
		query.append("	AND		B.CNTR_STS_CD IN('SBI','MUI')" ).append("\n"); 
		query.append("#elseif (${cntr_sts_cd} != '' ) " ).append("\n"); 
		query.append("	AND		B.CNTR_STS_CD = @[cntr_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_soc_tp} == '03')" ).append("\n"); 
		query.append("	AND     A.LSTM_CD = 'SH'" ).append("\n"); 
		query.append("#elseif (${lstm_soc_tp} == '02')" ).append("\n"); 
		query.append("	AND     A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${loc_tp} == '2' && ${loc_cd} != '')" ).append("\n"); 
		query.append("	AND     B.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_tp} == '3' && ${loc_cd} != '')" ).append("\n"); 
		query.append("	AND     B.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_tp} == '4' && ${loc_cd} != '')" ).append("\n"); 
		query.append("	AND     B.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_tp} == '5' && ${loc_cd} != '')" ).append("\n"); 
		query.append("	AND     SUBSTR(B.LOC_CD,1,2) = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${str_evnt_dt} != '')" ).append("\n"); 
		query.append("	AND     B.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[str_evnt_dt],'YYYYMMDD') " ).append("\n"); 
		query.append("    AND     TO_DATE(@[end_evnt_dt],'YYYYMMDD') " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("    AND     B.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("    AND     B.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("    AND     C.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
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
		query.append("#if (${cntr_full_flg} != '')" ).append("\n"); 
		query.append("    AND     B.CNTR_FULL_FLG = @[cntr_full_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("    AND     A.LSTM_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    AND     A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_onh_auth_no} != '' && ${lst_sts_flg} == '01')" ).append("\n"); 
		query.append("	#if(${cntr_sts_cd} == '(SB|MU)O' || ${cntr_sts_cd} == 'SBO' || ${cntr_sts_cd} == 'MUO')" ).append("\n"); 
		query.append("		AND    A.CNTR_OFFH_AUTH_NO = @[cntr_onh_auth_no]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND    A.CNTR_AUTH_NO = @[cntr_onh_auth_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${cntr_onh_auth_no} != '' && ${lst_sts_flg} == '02')" ).append("\n"); 
		query.append("	#if(${cntr_sts_cd} == '(SB|MU)O' || ${cntr_sts_cd} == 'SBO' || ${cntr_sts_cd} == 'MUO')" ).append("\n"); 
		query.append("		AND    B.CNTR_OFFH_AUTH_NO = @[cntr_onh_auth_no]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND    B.CNTR_AUTH_NO = @[cntr_onh_auth_no] " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(")  " ).append("\n"); 
		query.append("SELECT  LOC_CD, LSTM_CD, VNDR_ABBR_NM, VNDR_SEQ, TPSZ_TOTAL," ).append("\n"); 
		query.append("        TPSZ_DP01, TPSZ_DP02, TPSZ_DP03, TPSZ_DP04, TPSZ_DP05, TPSZ_DP06," ).append("\n"); 
		query.append("        TPSZ_DP07, TPSZ_DP08, TPSZ_DP09, TPSZ_DP10, TPSZ_DP11, TPSZ_DP12," ).append("\n"); 
		query.append("        TPSZ_DP13, TPSZ_DP14, TPSZ_DP15, TPSZ_DP16, TPSZ_DP17, TPSZ_DP18," ).append("\n"); 
		query.append("        TPSZ_DP19, TPSZ_DP20, TPSZ_DP21, TPSZ_DP22, TPSZ_DP23, TPSZ_DP24," ).append("\n"); 
		query.append("        TPSZ_DP25, TPSZ_DP26, TPSZ_DP27, TPSZ_DP28, TPSZ_DP29, TPSZ_DP30" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("#if (${total_flg} != 'Y')" ).append("\n"); 
		query.append("		SELECT  NVL(A.LOC_CD, 'G.Total') AS LOC_CD, " ).append("\n"); 
		query.append("				CASE WHEN A.LSTM_CD IS NULL" ).append("\n"); 
		query.append("                     THEN NVL2(A.LOC_CD, 'Total','')" ).append("\n"); 
		query.append("                     ELSE A.LSTM_CD" ).append("\n"); 
		query.append("                END LSTM_CD," ).append("\n"); 
		query.append("                CASE WHEN A.VNDR_ABBR_NM IS NULL " ).append("\n"); 
		query.append("                     THEN NVL2(A.LSTM_CD, 'S.TTL','')" ).append("\n"); 
		query.append("                     ELSE A.VNDR_ABBR_NM " ).append("\n"); 
		query.append("                END  VNDR_ABBR_NM, A.VNDR_SEQ, A.TPSZ_TOTAL," ).append("\n"); 
		query.append("                A.TPSZ_DP01, A.TPSZ_DP02, A.TPSZ_DP03, A.TPSZ_DP04, A.TPSZ_DP05, A.TPSZ_DP06," ).append("\n"); 
		query.append("                A.TPSZ_DP07, A.TPSZ_DP08, A.TPSZ_DP09, A.TPSZ_DP10, A.TPSZ_DP11, A.TPSZ_DP12," ).append("\n"); 
		query.append("                A.TPSZ_DP13, A.TPSZ_DP14, A.TPSZ_DP15, A.TPSZ_DP16, A.TPSZ_DP17, A.TPSZ_DP18," ).append("\n"); 
		query.append("                A.TPSZ_DP19, A.TPSZ_DP20, A.TPSZ_DP21, A.TPSZ_DP22, A.TPSZ_DP23, A.TPSZ_DP24," ).append("\n"); 
		query.append("                A.TPSZ_DP25, A.TPSZ_DP26, A.TPSZ_DP27, A.TPSZ_DP28, A.TPSZ_DP29, A.TPSZ_DP30" ).append("\n"); 
		query.append("        FROM   (SELECT  A.LOC_CD, A.LSTM_CD, A.VNDR_SEQ, A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("                        SUM(DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT)) AS TPSZ_TOTAL," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 1 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP01," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 2 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP02,  " ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 3 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP03," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 4 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP04," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 5 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP05," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 6 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP06," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 7 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP07," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 8 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP08," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 9 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP09," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =10 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP10," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =11 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP11," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =12 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP12," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =13 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP13," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =14 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP14," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =15 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP15," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =16 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP16," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =17 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP17," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =18 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP18," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =19 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP19," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =20 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP20," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =21 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP21," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =22 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP22,  " ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =23 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP23," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =24 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP24," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =25 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP25," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =26 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP26," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =27 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP27," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =28 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP28," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =29 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP29," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =30 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP30 " ).append("\n"); 
		query.append("                FROM   (SELECT  Z.LSTM_CD, Z.VNDR_SEQ, Z.VNDR_ABBR_NM, Z.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	#if (${loc_tp} == '0')" ).append("\n"); 
		query.append("								Z.RCC_CD AS LOC_CD, " ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '1' || ${loc_tp} == '5')" ).append("\n"); 
		query.append("								Z.CNTRY_CD AS LOC_CD, " ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '2')" ).append("\n"); 
		query.append("								Z.LCC_CD AS LOC_CD, " ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '3')" ).append("\n"); 
		query.append("								Z.SCC_CD AS LOC_CD, " ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '4')" ).append("\n"); 
		query.append("								Z.YD_CD AS LOC_CD, " ).append("\n"); 
		query.append("	#end								" ).append("\n"); 
		query.append("                                COUNT(Z.CNTR_NO) CNTR_CNT" ).append("\n"); 
		query.append("                        FROM    TEMP_DROP Z" ).append("\n"); 
		query.append("                        GROUP BY Z.LSTM_CD, Z.VNDR_SEQ, Z.VNDR_ABBR_NM, Z.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("	#if (${loc_tp} == '0')" ).append("\n"); 
		query.append("								 Z.RCC_CD" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '1' || ${loc_tp} == '5')" ).append("\n"); 
		query.append("								 Z.CNTRY_CD" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '2')" ).append("\n"); 
		query.append("								 Z.LCC_CD" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '3')" ).append("\n"); 
		query.append("								 Z.SCC_CD" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == '4')" ).append("\n"); 
		query.append("								 Z.YD_CD" ).append("\n"); 
		query.append("	#end								" ).append("\n"); 
		query.append("                        ) A," ).append("\n"); 
		query.append("                       (SELECT  CNTR_TPSZ_CD, ROW_NUMBER() OVER(ORDER BY RPT_DP_SEQ) AS RPT_DP_SEQ  " ).append("\n"); 
		query.append("                        FROM    MDM_CNTR_TP_SZ) C       " ).append("\n"); 
		query.append("                WHERE   1 = 1" ).append("\n"); 
		query.append("                GROUP BY ROLLUP(A.LOC_CD, A.LSTM_CD, A.VNDR_SEQ, A.VNDR_ABBR_NM)  " ).append("\n"); 
		query.append("                ) A        " ).append("\n"); 
		query.append("        WHERE   (A.VNDR_ABBR_NM IS NOT NULL" ).append("\n"); 
		query.append("        OR      A.VNDR_SEQ IS NULL" ).append("\n"); 
		query.append("        OR      A.LSTM_CD IS NULL" ).append("\n"); 
		query.append("        OR      A.LOC_CD IS NULL)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        SELECT  A.LOC_CD, NVL(A.LSTM_CD, 'Total') AS LSTM_CD, 			" ).append("\n"); 
		query.append("                CASE WHEN A.VNDR_ABBR_NM IS NULL " ).append("\n"); 
		query.append("                     THEN NVL2(A.LSTM_CD, 'S.TTL','')" ).append("\n"); 
		query.append("                     ELSE A.VNDR_ABBR_NM " ).append("\n"); 
		query.append("                END  VNDR_ABBR_NM, A.VNDR_SEQ, A.TPSZ_TOTAL," ).append("\n"); 
		query.append("                A.TPSZ_DP01, A.TPSZ_DP02, A.TPSZ_DP03, A.TPSZ_DP04, A.TPSZ_DP05, A.TPSZ_DP06," ).append("\n"); 
		query.append("                A.TPSZ_DP07, A.TPSZ_DP08, A.TPSZ_DP09, A.TPSZ_DP10, A.TPSZ_DP11, A.TPSZ_DP12," ).append("\n"); 
		query.append("                A.TPSZ_DP13, A.TPSZ_DP14, A.TPSZ_DP15, A.TPSZ_DP16, A.TPSZ_DP17, A.TPSZ_DP18," ).append("\n"); 
		query.append("                A.TPSZ_DP19, A.TPSZ_DP20, A.TPSZ_DP21, A.TPSZ_DP22, A.TPSZ_DP23, A.TPSZ_DP24," ).append("\n"); 
		query.append("                A.TPSZ_DP25, A.TPSZ_DP26, A.TPSZ_DP27, A.TPSZ_DP28, A.TPSZ_DP29, A.TPSZ_DP30" ).append("\n"); 
		query.append("        FROM   (SELECT  'G.Total' AS LOC_CD, A.LSTM_CD, A.VNDR_SEQ, A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("                        SUM(DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT)) AS TPSZ_TOTAL," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 1 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP01," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 2 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP02,  " ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 3 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP03," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 4 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP04," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 5 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP05," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 6 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP06," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 7 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP07," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 8 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP08," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ = 9 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP09," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =10 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP10," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =11 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP11," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =12 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP12," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =13 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP13," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =14 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP14," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =15 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP15," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =16 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP16," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =17 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP17," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =18 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP18," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =19 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP19," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =20 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP20," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =21 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP21," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =22 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP22,  " ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =23 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP23," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =24 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP24," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =25 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP25," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =26 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP26," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =27 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP27," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =28 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP28," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =29 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP29," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =30 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.CNTR_CNT) END) TPSZ_DP30 " ).append("\n"); 
		query.append("                FROM   (SELECT  Z.LSTM_CD, Z.VNDR_SEQ, Z.VNDR_ABBR_NM, Z.CNTR_TPSZ_CD, COUNT(Z.CNTR_NO) CNTR_CNT" ).append("\n"); 
		query.append("                        FROM    TEMP_DROP Z" ).append("\n"); 
		query.append("                        GROUP BY Z.LSTM_CD, Z.VNDR_SEQ, Z.VNDR_ABBR_NM, Z.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                        ) A," ).append("\n"); 
		query.append("                        (SELECT  CNTR_TPSZ_CD, ROW_NUMBER() OVER(ORDER BY RPT_DP_SEQ) AS RPT_DP_SEQ  " ).append("\n"); 
		query.append("                        FROM    MDM_CNTR_TP_SZ) C       " ).append("\n"); 
		query.append("                WHERE   1 = 1" ).append("\n"); 
		query.append("                GROUP BY ROLLUP(A.LSTM_CD, A.VNDR_SEQ, A.VNDR_ABBR_NM)  " ).append("\n"); 
		query.append("                ) A        " ).append("\n"); 
		query.append("        WHERE   (A.VNDR_ABBR_NM IS NOT NULL" ).append("\n"); 
		query.append("        OR      A.VNDR_SEQ IS NULL" ).append("\n"); 
		query.append("        OR      A.LSTM_CD IS NULL" ).append("\n"); 
		query.append("        OR      A.LOC_CD IS NULL)" ).append("\n"); 
		query.append("        AND     A.LOC_CD IS NOT NULL" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("ORDER BY DECODE(LOC_CD, 'G.Total',1,0), LOC_CD, " ).append("\n"); 
		query.append("         DECODE(LSTM_CD, 'Total',1,0), LSTM_CD, VNDR_SEQ" ).append("\n"); 

	}
}