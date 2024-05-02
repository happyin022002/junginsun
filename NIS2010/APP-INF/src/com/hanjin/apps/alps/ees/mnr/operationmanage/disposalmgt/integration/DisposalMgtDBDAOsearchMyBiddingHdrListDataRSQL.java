/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchMyBiddingHdrListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.31
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchMyBiddingHdrListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 - EES_MNR_S304 화면 Header List 조회
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchMyBiddingHdrListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_ptal_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_st_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location_country_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("disp_st_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_ut_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchMyBiddingHdrListDataRSQL").append("\n"); 
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
		query.append("SELECT A.DISP_NO 		-- Bidding No" ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD,A.DISP_BULTN_DT,@[ofc_cd]) ,'YYYY-MM-DD') AS DISP_BULTN_DT        -- Posting Date" ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(),MAX(A.APRO_DT),@[ofc_cd]),'YYYY-MM-DD') AS APRO_DT" ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD,A.DISP_ST_DT,@[ofc_cd]),'YYYY-MM-DD HH24:MI:SS') AS DISP_ST_DT   -- Opening Time" ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD,A.DISP_END_DT,@[ofc_cd]),'YYYY-MM-DD HH24:MI:SS') AS DISP_END_DT   -- Opening Time" ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]),'YYYY-MM-DD HH24:MI:SS') AS DISP_LOCAL_DT    -- Time Left" ).append("\n"); 
		query.append(", CASE" ).append("\n"); 
		query.append("WHEN (GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, @[ofc_cd]) - GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])) <= 0 THEN '0  00:00:00'" ).append("\n"); 
		query.append("WHEN A.DISP_END_DT IS NULL THEN ''" ).append("\n"); 
		query.append("WHEN GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) - GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_ST_DT, @[ofc_cd])  > 0 THEN -- 현지시각에서 비딩이 시작되면" ).append("\n"); 
		query.append("TRUNC(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, @[ofc_cd]) - GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])) ||'  '||" ).append("\n"); 
		query.append("LPAD(FLOOR((MOD((GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, @[ofc_cd]) - GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])), 1)) * 24), 2, '0') ||':'||" ).append("\n"); 
		query.append("LPAD(FLOOR(MOD(((GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, @[ofc_cd]) - GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])) * 24 * 60), 60)), 2, '0') ||':'||" ).append("\n"); 
		query.append("LPAD(FLOOR(MOD(((GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, @[ofc_cd]) - GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])) * 24 * 60 * 60), 60)), 2, '0')" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("TRUNC(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, @[ofc_cd]) - GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])) ||'  '||" ).append("\n"); 
		query.append("LPAD(FLOOR((MOD((GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, @[ofc_cd]) - GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])), 1)) * 24), 2, '0') ||':'||" ).append("\n"); 
		query.append("LPAD(FLOOR(MOD(((GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, @[ofc_cd]) - GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])) * 24 * 60), 60)), 2, '0') ||':'||" ).append("\n"); 
		query.append("LPAD(FLOOR(MOD(((GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, @[ofc_cd]) - GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])) * 24 * 60 * 60), 60)), 2, '0')" ).append("\n"); 
		query.append("END LEFT_TIME      -- Pick-Up Period" ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD,A.DISP_PKUP_ST_DT,@[ofc_cd]),'YYYY-MM-DD') ||DECODE(A.DISP_PKUP_ST_DT,'','',' ~ ')||" ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD,A.DISP_PKUP_END_DT,@[ofc_cd]),'YYYY-MM-DD') AS DISP_PKUP_PERIOD     -- Bidding Status" ).append("\n"); 
		query.append(", (CASE WHEN GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD,A.DISP_ST_DT,@[ofc_cd]) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD,A.DISP_END_DT,@[ofc_cd]) AND A.DISP_STS_CD = 'HA' THEN 'O'" ).append("\n"); 
		query.append("WHEN GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) > GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, @[ofc_cd]) OR A.DISP_STS_CD IN ('HC','HE','HP') THEN 'C' END)  AS BIDDING_STATUS" ).append("\n"); 
		query.append(", A.CURR_CD" ).append("\n"); 
		query.append(", SUM(B.DISP_QTY)    AS DISP_QTY" ).append("\n"); 
		query.append(", SUM(B.DISP_QTY * B.DISP_UT_PRC) AS DISP_UT_PRC" ).append("\n"); 
		query.append(", D.PART_DISP_QTY" ).append("\n"); 
		query.append(", D.DISP_CFM_QTY" ).append("\n"); 
		query.append(", D.PART_UT_AMT" ).append("\n"); 
		query.append(", A.FILE_SEQ" ).append("\n"); 
		query.append(", A.MNR_DISP_RMK" ).append("\n"); 
		query.append(", B.DISP_UT_TP_CD" ).append("\n"); 
		query.append(", (SELECT MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD" ).append("\n"); 
		query.append("WHERE PRNT_CD_ID = 'CD00078'" ).append("\n"); 
		query.append("AND MNR_CD_ID = B.DISP_UT_TP_CD" ).append("\n"); 
		query.append(") AS DISP_UT_TP_NM" ).append("\n"); 
		query.append("FROM MNR_DISP_HDR A" ).append("\n"); 
		query.append(", MNR_DISP_DTL B" ).append("\n"); 
		query.append(", MNR_DISP_BUYR_PART C" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT F.DISP_NO" ).append("\n"); 
		query.append(", SUM(F.DISP_QTY) AS PART_DISP_QTY" ).append("\n"); 
		query.append(", SUM(F.DISP_CFM_QTY) AS DISP_CFM_QTY" ).append("\n"); 
		query.append(", SUM(F.PART_UT_AMT) AS PART_UT_AMT" ).append("\n"); 
		query.append("FROM MNR_DISP_BUYR_DTL_PART F" ).append("\n"); 
		query.append(", MNR_PARTNER G" ).append("\n"); 
		query.append("WHERE F.MNR_PRNR_CNT_CD = G.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("AND F.MNR_PRNR_SEQ = G.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("AND G.SP_PTAL_ID = @[sp_ptal_id]" ).append("\n"); 
		query.append("GROUP BY DISP_NO" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append(", MNR_PARTNER E" ).append("\n"); 
		query.append("WHERE A.DISP_NO 			= B.DISP_NO" ).append("\n"); 
		query.append("AND A.DISP_NO 			= C.DISP_NO" ).append("\n"); 
		query.append("AND A.DISP_NO = D.DISP_NO(+)" ).append("\n"); 
		query.append("AND C.MNR_PRNR_CNT_CD	= E.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("AND C.MNR_PRNR_SEQ    	= E.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("AND A.DISP_TP_CD = 'B'" ).append("\n"); 
		query.append("AND E.MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("AND E.MNR_PRNR_STS_CD = 'C'" ).append("\n"); 
		query.append("AND E.SP_PTAL_ID = @[sp_ptal_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${disp_st_dt_to} != '')" ).append("\n"); 
		query.append("AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_ST_DT, @[ofc_cd]) BETWEEN TO_DATE(@[disp_st_dt_fm], 'YYYY-MM-DD') AND TO_DATE(@[disp_st_dt_to], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${disp_no} != '')" ).append("\n"); 
		query.append("AND A.DISP_NO IN ( #foreach ($user_disp_no IN ${disp_no})" ).append("\n"); 
		query.append("#if($velocityCount < $disp_no.size())" ).append("\n"); 
		query.append("'$user_disp_no'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_disp_no'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_no} != '')" ).append("\n"); 
		query.append("AND B.EQ_NO IN ( #foreach ($user_eq_no IN ${eq_no})" ).append("\n"); 
		query.append("#if($velocityCount < $eq_no.size())" ).append("\n"); 
		query.append("'$user_eq_no'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_eq_no'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${result} != 'ALL')" ).append("\n"); 
		query.append("#if (${result} == 'P') -- Processing" ).append("\n"); 
		query.append("AND A.DISP_STS_CD = 'HA'" ).append("\n"); 
		query.append("AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_ST_DT, @[ofc_cd]) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, @[ofc_cd])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("-- Won/Lost" ).append("\n"); 
		query.append("#if (${result} == 'W')" ).append("\n"); 
		query.append("AND EXISTS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND NOT EXISTS" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM MNR_DISP_BUYR_DTL_PART" ).append("\n"); 
		query.append("WHERE MNR_DISP_CFM_STS_CD = 'C'" ).append("\n"); 
		query.append("AND DISP_NO = A.DISP_NO" ).append("\n"); 
		query.append("AND MNR_PRNR_CNT_CD = E.MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("AND MNR_PRNR_SEQ = E.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) > GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, @[ofc_cd]) OR A.DISP_STS_CD IN ('HC','HE','HP'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bidding_status} != 'ALL')" ).append("\n"); 
		query.append("#if (${bidding_status} == 'O') -- Open" ).append("\n"); 
		query.append("AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_ST_DT, @[ofc_cd]) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, @[ofc_cd])" ).append("\n"); 
		query.append("AND A.DISP_STS_CD = 'HA'" ).append("\n"); 
		query.append("#else  -- Close" ).append("\n"); 
		query.append("AND (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) > GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, @[ofc_cd]) OR A.DISP_STS_CD IN ('HC','HE','HP'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.DISP_STS_CD IN ('HA','HC','HE','HP')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_knd_cd} != 'ALL' && ${eq_knd_cd} != '')" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${disp_ut_tp_cd} != 'ALL' && ${disp_ut_tp_cd} != '')" ).append("\n"); 
		query.append("AND B.DISP_UT_TP_CD = @[disp_ut_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${location_type} != 'ALL'&& ${location_country_cd}!='')" ).append("\n"); 
		query.append("#if (${location_type} == 'L')" ).append("\n"); 
		query.append("AND SUBSTR(B.DISP_YD_CD,0,5)= @[location_country_cd]" ).append("\n"); 
		query.append("#elseif (${location_type} == 'C')" ).append("\n"); 
		query.append("AND SUBSTR(B.DISP_YD_CD,0,2)= @[location_country_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${program_id} == 'S301')" ).append("\n"); 
		query.append("AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]) BETWEEN GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_ST_DT, @[ofc_cd]) AND GLOBALDATE_PKG.TIME_CONV_OFC_FNC(A.RQST_OFC_CD, A.DISP_END_DT, @[ofc_cd])" ).append("\n"); 
		query.append("AND A.DISP_STS_CD = 'HA'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.DISP_NO" ).append("\n"); 
		query.append(", A.RQST_OFC_CD" ).append("\n"); 
		query.append(", A.DISP_BULTN_DT" ).append("\n"); 
		query.append(", A.APRO_DT" ).append("\n"); 
		query.append(", A.DISP_ST_DT" ).append("\n"); 
		query.append(", A.DISP_END_DT" ).append("\n"); 
		query.append(", A.DISP_PKUP_ST_DT" ).append("\n"); 
		query.append(", A.DISP_PKUP_END_DT" ).append("\n"); 
		query.append(", A.DISP_STS_CD" ).append("\n"); 
		query.append(", A.CURR_CD" ).append("\n"); 
		query.append(", D.PART_DISP_QTY" ).append("\n"); 
		query.append(", D.DISP_CFM_QTY" ).append("\n"); 
		query.append(", D.PART_UT_AMT" ).append("\n"); 
		query.append(", A.FILE_SEQ" ).append("\n"); 
		query.append(", A.MNR_DISP_RMK" ).append("\n"); 
		query.append(", B.DISP_UT_TP_CD" ).append("\n"); 
		query.append("ORDER BY A.DISP_END_DT DESC" ).append("\n"); 

	}
}