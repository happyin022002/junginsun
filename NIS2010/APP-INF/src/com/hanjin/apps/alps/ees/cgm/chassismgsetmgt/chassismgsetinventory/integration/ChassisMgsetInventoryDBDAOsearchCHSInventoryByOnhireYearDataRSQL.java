/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchCHSInventoryByOnhireYearDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.03.18 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOsearchCHSInventoryByOnhireYearDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090730 1100 start
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchCHSInventoryByOnhireYearDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("crnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aciac_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchCHSInventoryByOnhireYearDataRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#if (${group1} == '1')" ).append("\n"); 
		query.append("t4.LCC_CD AS GROUP1 ," ).append("\n"); 
		query.append("#elseif (${group1} == '2')" ).append("\n"); 
		query.append("t3.SCC_CD AS GROUP1 ," ).append("\n"); 
		query.append("#elseif (${group1} == '3')" ).append("\n"); 
		query.append("t1.CRNT_YD_CD AS GROUP1 ," ).append("\n"); 
		query.append("#elseif (${group1} == '4')" ).append("\n"); 
		query.append("t1.AGMT_LSTM_CD AS GROUP1 ," ).append("\n"); 
		query.append("t6.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("#elseif (${group1} == '5')" ).append("\n"); 
		query.append("t8.VNDR_ABBR_NM||' ('||t1.VNDR_SEQ||')' AS GROUP1 ," ).append("\n"); 
		query.append("#elseif (${group1} == '6')" ).append("\n"); 
		query.append("t1.CHSS_MVMT_STS_CD AS GROUP1 ," ).append("\n"); 
		query.append("t5.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("t1.EQ_TPSZ_CD AS EQ_TPSZ_CD" ).append("\n"); 
		query.append(",t7.DP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NVL(SUM( CASE WHEN" ).append("\n"); 
		query.append("TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) >= 0 THEN 1 END" ).append("\n"); 
		query.append("), 0) AS YEAR_TOTAL" ).append("\n"); 
		query.append(", NVL(SUM( CASE WHEN" ).append("\n"); 
		query.append("TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) >= 0" ).append("\n"); 
		query.append("AND TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) < 5 THEN 1 END" ).append("\n"); 
		query.append("), 0) AS YEAR_8" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NVL(SUM( CASE WHEN" ).append("\n"); 
		query.append("TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) >= 5" ).append("\n"); 
		query.append("AND TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) < 10 THEN 1 END" ).append("\n"); 
		query.append("), 0) AS YEAR_7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NVL(SUM( CASE WHEN" ).append("\n"); 
		query.append("TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) >= 10" ).append("\n"); 
		query.append("AND TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) < 15 THEN 1 END" ).append("\n"); 
		query.append("), 0) AS YEAR_6" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NVL(SUM( CASE WHEN" ).append("\n"); 
		query.append("TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) >= 15" ).append("\n"); 
		query.append("AND TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) < 20 THEN 1 END" ).append("\n"); 
		query.append("), 0) AS YEAR_5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NVL(SUM( CASE WHEN" ).append("\n"); 
		query.append("TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) >= 20" ).append("\n"); 
		query.append("AND TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) < 25 THEN 1 END" ).append("\n"); 
		query.append("), 0) AS YEAR_4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NVL(SUM( CASE WHEN" ).append("\n"); 
		query.append("TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) >= 25" ).append("\n"); 
		query.append("AND TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) < 30 THEN 1 END" ).append("\n"); 
		query.append("), 0) AS YEAR_3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", NVL(SUM( CASE WHEN" ).append("\n"); 
		query.append("TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) >= 30" ).append("\n"); 
		query.append("AND TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) < 35 THEN 1 END" ).append("\n"); 
		query.append("), 0) AS YEAR_2" ).append("\n"); 
		query.append(", NVL(SUM( CASE WHEN" ).append("\n"); 
		query.append("TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) >= 35  THEN 1 END" ).append("\n"); 
		query.append("), 0) AS YEAR_1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT t1" ).append("\n"); 
		query.append(", MDM_LOCATION t3" ).append("\n"); 
		query.append(", MDM_EQ_ORZ_CHT t4" ).append("\n"); 
		query.append(", COM_INTG_CD_DTL t5" ).append("\n"); 
		query.append(", COM_INTG_CD_DTL t6" ).append("\n"); 
		query.append(", CGM_EQ_TP_SZ t7" ).append("\n"); 
		query.append(", MDM_VENDOR t8" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("t1.VNDR_SEQ = t8.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND t1.CRNT_LOC_CD = t3.LOC_CD" ).append("\n"); 
		query.append("AND t3.SCC_CD = t4.SCC_CD" ).append("\n"); 
		query.append("AND t3.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND t4.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND t1.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND t1.CHSS_MVMT_STS_CD = t5.INTG_CD_VAL_CTNT (+)" ).append("\n"); 
		query.append("AND 'CD02386' = t5.INTG_CD_ID (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND t1.AGMT_LSTM_CD = t6.INTG_CD_VAL_CTNT (+)" ).append("\n"); 
		query.append("AND 'CD01948' = t6.INTG_CD_ID (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND t1.EQ_TPSZ_CD = t7.EQ_TPSZ_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crnt_loc_cd} != '')" ).append("\n"); 
		query.append("AND t1.CRNT_LOC_CD IN" ).append("\n"); 
		query.append("( 	SELECT AA.LOC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION AA, MDM_EQ_ORZ_CHT BB" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("AA.SCC_CD = BB.SCC_CD" ).append("\n"); 
		query.append("AND  AA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND  BB.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if ( ${location} == 'RCC' )" ).append("\n"); 
		query.append("AND  BB.RCC_CD = (@[crnt_loc_cd])" ).append("\n"); 
		query.append("#elseif ( ${location} == 'LCC' )" ).append("\n"); 
		query.append("AND  BB.LCC_CD = (@[crnt_loc_cd])" ).append("\n"); 
		query.append("#elseif ( ${location} == 'SCC' )" ).append("\n"); 
		query.append("AND  BB.SCC_CD = (@[crnt_loc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crnt_yd_cd} != '')" ).append("\n"); 
		query.append("AND t1.CRNT_YD_CD IN ($crnt_yd_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${aciac_div_cd} != '')" ).append("\n"); 
		query.append("AND t1.ACIAC_DIV_CD = @[aciac_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${include_np} != 'Y')" ).append("\n"); 
		query.append("AND t1.AGMT_LSTM_CD <>'NP'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND t1.EQ_TPSZ_CD IN ($eq_tpsz_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("AND t1.AGMT_LSTM_CD IN ($agmt_lstm_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND t1.VNDR_SEQ IN ($vndr_seq)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chss_mvmt_sts_cd} != '')" ).append("\n"); 
		query.append("AND t1.CHSS_MVMT_STS_CD IN ($chss_mvmt_sts_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("#if (${group1} == '1')" ).append("\n"); 
		query.append("t4.LCC_CD," ).append("\n"); 
		query.append("#elseif (${group1} == '2')" ).append("\n"); 
		query.append("t3.SCC_CD," ).append("\n"); 
		query.append("#elseif (${group1} == '3')" ).append("\n"); 
		query.append("t1.CRNT_YD_CD," ).append("\n"); 
		query.append("#elseif (${group1} == '4')" ).append("\n"); 
		query.append("t1.AGMT_LSTM_CD," ).append("\n"); 
		query.append("t6.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("#elseif (${group1} == '5')" ).append("\n"); 
		query.append("t8.VNDR_ABBR_NM||' ('||t1.VNDR_SEQ||')'," ).append("\n"); 
		query.append("#elseif (${group1} == '6')" ).append("\n"); 
		query.append("t1.CHSS_MVMT_STS_CD," ).append("\n"); 
		query.append("t5.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("t1.EQ_TPSZ_CD ," ).append("\n"); 
		query.append("t7.DP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("HAVING NVL(SUM( CASE WHEN" ).append("\n"); 
		query.append("TO_NUMBER(TO_CHAR(ADD_MONTHS(TO_DATE(@[onh_dt], 'YYYY'),0),'YYYY')) - TO_NUMBER(TO_CHAR(t1.ONH_DT,'YYYY')) >= 0 THEN 1 END" ).append("\n"); 
		query.append("), 0) > 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("#if (${group1} == '1')" ).append("\n"); 
		query.append("t4.LCC_CD," ).append("\n"); 
		query.append("#elseif (${group1} == '2')" ).append("\n"); 
		query.append("t3.SCC_CD," ).append("\n"); 
		query.append("#elseif (${group1} == '3')" ).append("\n"); 
		query.append("t1.CRNT_YD_CD," ).append("\n"); 
		query.append("#elseif (${group1} == '4')" ).append("\n"); 
		query.append("--t1.AGMT_LSTM_CD," ).append("\n"); 
		query.append("t6.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("#elseif (${group1} == '5')" ).append("\n"); 
		query.append("t8.VNDR_ABBR_NM||' ('||t1.VNDR_SEQ||')'," ).append("\n"); 
		query.append("#elseif (${group1} == '6')" ).append("\n"); 
		query.append("--t1.CHSS_MVMT_STS_CD," ).append("\n"); 
		query.append("t5.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--t1.EQ_TPSZ_CD" ).append("\n"); 
		query.append("t7.DP_SEQ" ).append("\n"); 

	}
}