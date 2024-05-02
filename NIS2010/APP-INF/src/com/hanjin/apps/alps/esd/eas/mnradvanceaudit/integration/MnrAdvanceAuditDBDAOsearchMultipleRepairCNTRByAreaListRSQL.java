/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOsearchMultipleRepairCNTRByAreaListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.08
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOsearchMultipleRepairCNTRByAreaListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESD_EAS_0364
	  * Multiple Repair CNTR by Area 목록화면
	  * 동일 지역/업체/장비의 중복 견적/수리에 대한 목록
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOsearchMultipleRepairCNTRByAreaListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_start_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rpr_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOsearchMultipleRepairCNTRByAreaListRSQL").append("\n"); 
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
		query.append("WITH ROW_DATA AS (" ).append("\n"); 
		query.append("    SELECT   EQ_NO" ).append("\n"); 
		query.append("           , EQ_TPSZ_CD" ).append("\n"); 
		query.append("           , LSTM_CD" ).append("\n"); 
		query.append("           , OWNR_CO_CD" ).append("\n"); 
		query.append("           , CURR_CD" ).append("\n"); 
		query.append("           , ONH_DT" ).append("\n"); 
		query.append("           , USING_DAYS" ).append("\n"); 
		query.append("           , LOC_CD " ).append("\n"); 
		query.append("           , YD_CD" ).append("\n"); 
		query.append("           , VNDR_SEQ" ).append("\n"); 
		query.append("           , VNDR_NM" ).append("\n"); 
		query.append("           , VNDR_CNT" ).append("\n"); 
		query.append("           , LOC_CNT" ).append("\n"); 
		query.append("           , MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(MNR_INP_DT, CURR_CD, 'USD', COST_AMT ) AS CHG_COST_AMT" ).append("\n"); 
		query.append("           , MNR_COMMON_PKG.MNR_CAL_DV_FNC('U', EQ_NO, ONH_DT ) AS DV_VALUE" ).append("\n"); 
		query.append("    FROM     (" ).append("\n"); 
		query.append("               SELECT   B.EQ_NO" ).append("\n"); 
		query.append("                      , MAX(B.EQ_TPSZ_CD) EQ_TPSZ_CD" ).append("\n"); 
		query.append("                      , MAX(D.LSTM_CD) LSTM_CD" ).append("\n"); 
		query.append("                      , (" ).append("\n"); 
		query.append("                          SELECT   DECODE(INTG_CD_VAL_CTNT,'H','SM Line',INTG_CD_VAL_DP_DESC)" ).append("\n"); 
		query.append("                          FROM     COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("                          WHERE    1 = 1" ).append("\n"); 
		query.append("                          AND      INTG_CD_ID ='CD01047'" ).append("\n"); 
		query.append("                          AND      CD.INTG_CD_VAL_CTNT = D.OWNR_CO_CD" ).append("\n"); 
		query.append("                        ) OWNR_CO_CD" ).append("\n"); 
		query.append("                      , MAX(A.CURR_CD) CURR_CD" ).append("\n"); 
		query.append("                      , TO_CHAR(MAX(A.MNR_INP_DT), 'YYYYMM') AS MNR_INP_DT" ).append("\n"); 
		query.append("                      , SUM(B.COST_AMT) AS COST_AMT" ).append("\n"); 
		query.append("                      , TO_CHAR(MAX(D.ONH_DT), 'YYYYMMDD') ONH_DT" ).append("\n"); 
		query.append("                      , CASE WHEN MAX(E.CNTR_STS_CD) IN ('LSO', 'SBO', 'DIO', 'MUO', 'LST', 'SRO', 'SLD', 'SCR', 'DON', 'TLL') THEN TRUNC(MAX(E.CNTR_STS_EVNT_DT)) - TRUNC(MAX(D.ONH_DT))" ).append("\n"); 
		query.append("                             ELSE TRUNC(SYSDATE) - TRUNC(MAX(D.ONH_DT)) + 1" ).append("\n"); 
		query.append("                        END USING_DAYS" ).append("\n"); 
		query.append("                      , C.LOC_CD" ).append("\n"); 
		query.append("                      , B.YD_CD" ).append("\n"); 
		query.append("                      , A.VNDR_SEQ" ).append("\n"); 
		query.append("                      , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR V WHERE V.VNDR_SEQ = A.VNDR_SEQ) AS VNDR_NM" ).append("\n"); 
		query.append("                      , COUNT(1) OVER(PARTITION BY B.EQ_NO, C.LOC_CD, B.YD_CD, A.VNDR_SEQ) AS VNDR_CNT" ).append("\n"); 
		query.append("                      , COUNT(1) OVER(PARTITION BY B.EQ_NO, C.LOC_CD) AS LOC_CNT" ).append("\n"); 
		query.append("               FROM     MNR_ORD_DTL B" ).append("\n"); 
		query.append("                      , MNR_ORD_HDR A" ).append("\n"); 
		query.append("                      , MST_CONTAINER D" ).append("\n"); 
		query.append("                      , MST_CNTR_STS_HIS E" ).append("\n"); 
		query.append("                      , MDM_YARD C" ).append("\n"); 
		query.append("               WHERE    1 = 1" ).append("\n"); 
		query.append("               AND      A.MNR_ORD_OFC_CTY_CD = B.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("               AND      A.MNR_ORD_SEQ = B.MNR_ORD_SEQ " ).append("\n"); 
		query.append("               AND      B.YD_CD = C.YD_CD " ).append("\n"); 
		query.append("               AND      B.EQ_NO = D.CNTR_NO" ).append("\n"); 
		query.append("               AND      D.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("               AND      D.LST_STS_SEQ = E.CNTR_STS_SEQ" ).append("\n"); 
		query.append("               AND      A.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("               AND      A.EQ_KND_CD = 'U'" ).append("\n"); 
		query.append("               AND      B.EQ_NO IS NOT NULL" ).append("\n"); 
		query.append("               AND      A.MNR_WO_TP_CD IN ('EST', 'SPL')" ).append("\n"); 
		query.append("               AND      B.COST_CD != 'MRDRCL'" ).append("\n"); 
		query.append("               AND      A.MNR_INP_DT BETWEEN TO_DATE(@[s_start_dt] || '000000', 'YYYY-MM-DDHH24MISS') AND TO_DATE(@[s_end_dt] || '235959', 'YYYY-MM-DDHH24MISS')" ).append("\n"); 
		query.append("#if(${s_vndr_seq} != '')" ).append("\n"); 
		query.append("               AND      A.VNDR_SEQ = @[s_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_yd_cd} != '')" ).append("\n"); 
		query.append("               AND      C.YD_CD = @[s_loc_cd] || @[s_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_loc_cd} != '')" ).append("\n"); 
		query.append("               AND      C.LOC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_cnt_cd} != '')" ).append("\n"); 
		query.append("               AND      C.LOC_CD LIKE @[s_cnt_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       -- Country Code " ).append("\n"); 
		query.append("               GROUP BY B.EQ_NO" ).append("\n"); 
		query.append("                      , C.LOC_CD" ).append("\n"); 
		query.append("                      , B.YD_CD" ).append("\n"); 
		query.append("                      , A.VNDR_SEQ" ).append("\n"); 
		query.append("                      , D.OWNR_CO_CD" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT   DENSE_RANK() OVER(ORDER BY EQ_NO) SEQ" ).append("\n"); 
		query.append("       , EQ_NO" ).append("\n"); 
		query.append("       , EQ_TPSZ_CD" ).append("\n"); 
		query.append("       , LSTM_CD" ).append("\n"); 
		query.append("       , OWNR_CO_CD" ).append("\n"); 
		query.append("       , CURR_CD" ).append("\n"); 
		query.append("       , TO_CHAR(TO_DATE(ONH_DT, 'YYYYMMDD'), 'YYYY-MM-DD') ONH_DT" ).append("\n"); 
		query.append("       , USING_DAYS" ).append("\n"); 
		query.append("       , DV_VALUE" ).append("\n"); 
		query.append("       , LOC_CNT TTL_NO_OF_CASES" ).append("\n"); 
		query.append("       , LOC_CD" ).append("\n"); 
		query.append("       , SUM(CHG_COST_AMT) OVER(PARTITION BY EQ_NO) TTL_COST_AMT" ).append("\n"); 
		query.append("       , YD_CD" ).append("\n"); 
		query.append("       , VNDR_SEQ" ).append("\n"); 
		query.append("       , VNDR_NM" ).append("\n"); 
		query.append("       , VNDR_CNT NO_OF_CASES" ).append("\n"); 
		query.append("       , CHG_COST_AMT COST_AMT" ).append("\n"); 
		query.append("FROM     ROW_DATA" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      LOC_CNT > NVL(TO_NUMBER(@[s_rpr_cnt]), 3)" ).append("\n"); 
		query.append("ORDER BY EQ_NO" ).append("\n"); 
		query.append("       , LOC_CD" ).append("\n"); 
		query.append("       , YD_CD" ).append("\n"); 
		query.append("       , VNDR_SEQ" ).append("\n"); 

	}
}