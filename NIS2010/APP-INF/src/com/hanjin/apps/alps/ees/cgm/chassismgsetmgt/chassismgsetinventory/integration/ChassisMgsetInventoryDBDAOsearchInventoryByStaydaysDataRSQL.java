/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchInventoryByStaydaysDataRSQL.java
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

public class ChassisMgsetInventoryDBDAOsearchInventoryByStaydaysDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchInventoryByStaydaysDataRSQL(){
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
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aciac_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchInventoryByStaydaysDataRSQL").append("\n"); 
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
		query.append("t1.EQ_TPSZ_CD AS GROUP1," ).append("\n"); 
		query.append("t7.DP_SEQ," ).append("\n"); 
		query.append("#elseif (${group1} == '2')" ).append("\n"); 
		query.append("t4.LCC_CD AS GROUP1," ).append("\n"); 
		query.append("#elseif (${group1} == '3')" ).append("\n"); 
		query.append("t1.ONH_OFC_CD AS GROUP1," ).append("\n"); 
		query.append("#elseif (${group1} == '4')" ).append("\n"); 
		query.append("t3.SCC_CD AS GROUP1," ).append("\n"); 
		query.append("#elseif (${group1} == '5')" ).append("\n"); 
		query.append("t1.CRNT_YD_CD AS GROUP1," ).append("\n"); 
		query.append("#elseif (${group1} == '6')" ).append("\n"); 
		query.append("t1.AGMT_LSTM_CD AS GROUP1," ).append("\n"); 
		query.append("t6.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("#elseif (${group1} == '7')" ).append("\n"); 
		query.append("t9.VNDR_ABBR_NM||' ('||t1.VNDR_SEQ||')' AS GROUP1," ).append("\n"); 
		query.append("#elseif (${group1} == '8')" ).append("\n"); 
		query.append("t1.CHSS_MVMT_STS_CD AS GROUP1," ).append("\n"); 
		query.append("t5.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("count(*) as chss_mvmt_dt_tot -- Total" ).append("\n"); 
		query.append("#if (${staying_days} != '')" ).append("\n"); 
		query.append(",NVL(sum( case when  sysdate - t1.chss_mvmt_dt >= TO_NUMBER(${staying_days}) THEN 1 END ),0) as chss_mvmt_dt_0_or_over" ).append("\n"); 
		query.append(",TO_CHAR(NVL((sum( case when  sysdate - t1.chss_mvmt_dt >= TO_NUMBER(${staying_days}) THEN 1 END ) /  count(*) * 100 ),0), 'FM999,990.00') || '%' as chss_mvmt_dt_0_or_over_rate" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",NVL(sum( case when  sysdate - t1.chss_mvmt_dt >= 0 THEN 1 END ),0) as chss_mvmt_dt_0_or_over" ).append("\n"); 
		query.append(",TO_CHAR(NVL((sum( case when  sysdate - t1.chss_mvmt_dt >= 0 THEN 1 END ) /  count(*) * 100 ),0), 'FM999,990.00') || '%' as chss_mvmt_dt_0_or_over_rate" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",NVL(sum( case when  sysdate - t1.chss_mvmt_dt between TO_NUMBER(${n1st_inq_fm_dys}) and TO_NUMBER(${n1st_inq_to_dys})+1 THEN 1 END ),0) as chss_mvmt_dt_today_15" ).append("\n"); 
		query.append(",TO_CHAR(NVL((sum( case when  sysdate - t1.chss_mvmt_dt between TO_NUMBER(${n1st_inq_fm_dys}) and TO_NUMBER(${n1st_inq_to_dys})+1 THEN 1 END ) / count(*) * 100),0), 'FM999,990.00') || '%' as chss_mvmt_dt_today_15_rate" ).append("\n"); 
		query.append(",NVL(sum( case when  sysdate - t1.chss_mvmt_dt between TO_NUMBER(${n2nd_inq_fm_dys}) and TO_NUMBER(${n2nd_inq_to_dys})+1 THEN 1 END ),0) as chss_mvmt_dt_16_30" ).append("\n"); 
		query.append(",TO_CHAR(NVL((sum( case when  sysdate - t1.chss_mvmt_dt between TO_NUMBER(${n2nd_inq_fm_dys}) and TO_NUMBER(${n2nd_inq_to_dys})+1 THEN 1 END ) / count(*) * 100),0), 'FM999,990.00') || '%' as chss_mvmt_dt_16_30_rate" ).append("\n"); 
		query.append(",NVL(sum( case when  sysdate - t1.chss_mvmt_dt between TO_NUMBER(${n3rd_inq_fm_dys}) and TO_NUMBER(${n3rd_inq_to_dys})+1 THEN 1 END ),0) as chss_mvmt_dt_31_50" ).append("\n"); 
		query.append(",TO_CHAR(NVL((sum( case when  sysdate - t1.chss_mvmt_dt between TO_NUMBER(${n3rd_inq_fm_dys}) and TO_NUMBER(${n3rd_inq_to_dys})+1 THEN 1 END ) / count(*) * 100),0), 'FM999,990.00') || '%' as chss_mvmt_dt_31_50_rate" ).append("\n"); 
		query.append(",NVL(sum( case when  sysdate - t1.chss_mvmt_dt between TO_NUMBER(${n4th_inq_fm_dys}) and TO_NUMBER(${n4th_inq_to_dys})+1 THEN 1 END ),0) as chss_mvmt_dt_51_100" ).append("\n"); 
		query.append(",TO_CHAR(NVL((sum( case when  sysdate - t1.chss_mvmt_dt between TO_NUMBER(${n4th_inq_fm_dys}) and TO_NUMBER(${n4th_inq_to_dys})+1 THEN 1 END ) / count(*) * 100),0), 'FM999,990.00') || '%' as chss_mvmt_dt_51_100_rate" ).append("\n"); 
		query.append(",NVL(sum( case when  sysdate - t1.chss_mvmt_dt between TO_NUMBER(${n5th_inq_fm_dys}) and TO_NUMBER(${n5th_inq_to_dys})+1 THEN 1 END ),0) as chss_mvmt_dt_101_180" ).append("\n"); 
		query.append(",TO_CHAR(NVL((sum( case when  sysdate - t1.chss_mvmt_dt between TO_NUMBER(${n5th_inq_fm_dys}) and TO_NUMBER(${n5th_inq_to_dys})+1 THEN 1 END ) / count(*) * 100),0), 'FM999,990.00') || '%' as chss_mvmt_dt_101_180_rate" ).append("\n"); 
		query.append(",NVL(sum( case when  sysdate - t1.chss_mvmt_dt > TO_NUMBER(${n5th_inq_to_dys})+1 THEN 1 END ),0) as chss_mvmt_dt_181_over" ).append("\n"); 
		query.append(",TO_CHAR(NVL((sum( case when  sysdate - t1.chss_mvmt_dt > TO_NUMBER(${n5th_inq_to_dys}) THEN 1 END ) / count(*) * 100),0), 'FM999,990.00') || '%' as chss_mvmt_dt_181_over_rate" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_EQUIPMENT t1" ).append("\n"); 
		query.append("#if (${atch_bare} != '')" ).append("\n"); 
		query.append(", ( SELECT A.EQ_NO FROM  CGM_EQ_ATCH_DTCH_HIS A" ).append("\n"); 
		query.append("WHERE A.DTCH_DT = TO_DATE('88881231','YYYYMMDD')" ).append("\n"); 
		query.append("GROUP BY A.EQ_NO" ).append("\n"); 
		query.append(") T8" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", CGM_EQ_STS_HIS t2" ).append("\n"); 
		query.append(", MDM_LOCATION t3" ).append("\n"); 
		query.append(", MDM_EQ_ORZ_CHT t4" ).append("\n"); 
		query.append(", COM_INTG_CD_DTL t5" ).append("\n"); 
		query.append(", COM_INTG_CD_DTL t6" ).append("\n"); 
		query.append(", CGM_EQ_TP_SZ t7" ).append("\n"); 
		query.append(", MDM_VENDOR t9" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("t1.VNDR_SEQ = t9.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND t1.EQ_NO = t2.EQ_NO" ).append("\n"); 
		query.append("#if (${atch_bare} != '')" ).append("\n"); 
		query.append("AND t1.EQ_NO= T8.EQ_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND t1.eq_sts_seq= t2.eq_sts_seq" ).append("\n"); 
		query.append("AND t1.CRNT_LOC_CD = t3.LOC_CD" ).append("\n"); 
		query.append("AND t3.SCC_CD = t4.SCC_CD" ).append("\n"); 
		query.append("AND t3.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND t4.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND t1.CHSS_MVMT_STS_CD = t5.INTG_CD_VAL_CTNT (+)" ).append("\n"); 
		query.append("AND 'CD02386' = t5.INTG_CD_ID (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND t1.AGMT_LSTM_CD = t6.INTG_CD_VAL_CTNT (+)" ).append("\n"); 
		query.append("AND 'CD01948' = t6.INTG_CD_ID (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND t1.EQ_TPSZ_CD = t7.EQ_TPSZ_CD (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND t1.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#if ( ${location} == 'RCC' )" ).append("\n"); 
		query.append("AND  t4.RCC_CD = (@[crnt_loc_cd])" ).append("\n"); 
		query.append("#elseif ( ${location} == 'LCC' )" ).append("\n"); 
		query.append("AND  t4.LCC_CD = (@[crnt_loc_cd])" ).append("\n"); 
		query.append("#elseif ( ${location} == 'SCC' )" ).append("\n"); 
		query.append("AND   t4.SCC_CD = (@[crnt_loc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crnt_yd_cd} != '')" ).append("\n"); 
		query.append("AND t1.CRNT_YD_CD IN ($crnt_yd_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${aciac_div_cd} != '')" ).append("\n"); 
		query.append("AND t1.ACIAC_DIV_CD = @[aciac_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chss_pool_cd} != 'I')" ).append("\n"); 
		query.append("#if (${chss_pool_cd} == 'E')" ).append("\n"); 
		query.append("AND t1.CHSS_POOL_CD IS NULL" ).append("\n"); 
		query.append("#elseif (${chss_pool_cd} == 'O')" ).append("\n"); 
		query.append("AND t1.CHSS_POOL_CD IS NOT NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND t1.CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${include_np} != 'Y')" ).append("\n"); 
		query.append("AND t1.AGMT_LSTM_CD <>'NP'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND t1.EQ_TPSZ_CD IN ($eq_tpsz_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("AND t1.AGMT_LSTM_CD IN ($agmt_lstm_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND t1.VNDR_SEQ IN ($vndr_seq)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chss_mvmt_sts_cd} != '')" ).append("\n"); 
		query.append("AND t1.CHSS_MVMT_STS_CD IN ($chss_mvmt_sts_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${include_status_lst} == 'Y')" ).append("\n"); 
		query.append("AND t2.EQ_ASET_STS_CD = 'LST'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${include_out_gated} == 'Y')" ).append("\n"); 
		query.append("AND t1.GATE_IO_CD = 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${atch_bare} == 'ATTACHED')" ).append("\n"); 
		query.append("AND	T8.EQ_NO IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${atch_bare} == 'BARE')" ).append("\n"); 
		query.append("AND T8.EQ_NO IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dmg_snd} == 'DAMAGE')" ).append("\n"); 
		query.append("AND t1.DMG_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${dmg_snd} == 'SOUND')" ).append("\n"); 
		query.append("AND ((t1.DMG_FLG <> 'Y') or (t1.DMG_FLG IS NULL))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${group1} != '')" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${group1} == '1')" ).append("\n"); 
		query.append("t1.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",t7.DP_SEQ" ).append("\n"); 
		query.append("#elseif (${group1} == '2')" ).append("\n"); 
		query.append("t4.LCC_CD" ).append("\n"); 
		query.append("#elseif (${group1} == '3')" ).append("\n"); 
		query.append("t1.ONH_OFC_CD" ).append("\n"); 
		query.append("#elseif (${group1} == '4')" ).append("\n"); 
		query.append("t3.SCC_CD" ).append("\n"); 
		query.append("#elseif (${group1} == '5')" ).append("\n"); 
		query.append("t1.CRNT_YD_CD" ).append("\n"); 
		query.append("#elseif (${group1} == '6')" ).append("\n"); 
		query.append("t1.AGMT_LSTM_CD" ).append("\n"); 
		query.append(",t6.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#elseif (${group1} == '7')" ).append("\n"); 
		query.append("t9.VNDR_ABBR_NM||' ('||t1.VNDR_SEQ||')'" ).append("\n"); 
		query.append("#elseif (${group1} == '8')" ).append("\n"); 
		query.append("t1.CHSS_MVMT_STS_CD" ).append("\n"); 
		query.append(",t5.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${group1} != '')" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${group1} == '1')" ).append("\n"); 
		query.append("--t1.EQ_TPSZ_CD" ).append("\n"); 
		query.append("t7.DP_SEQ" ).append("\n"); 
		query.append("#elseif (${group1} == '2')" ).append("\n"); 
		query.append("t4.LCC_CD" ).append("\n"); 
		query.append("#elseif (${group1} == '3')" ).append("\n"); 
		query.append("t1.ONH_OFC_CD" ).append("\n"); 
		query.append("#elseif (${group1} == '4')" ).append("\n"); 
		query.append("t3.SCC_CD" ).append("\n"); 
		query.append("#elseif (${group1} == '5')" ).append("\n"); 
		query.append("t1.CRNT_YD_CD" ).append("\n"); 
		query.append("#elseif (${group1} == '6')" ).append("\n"); 
		query.append("--t1.AGMT_LSTM_CD" ).append("\n"); 
		query.append("t6.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#elseif (${group1} == '7')" ).append("\n"); 
		query.append("t9.VNDR_ABBR_NM||' ('||t1.VNDR_SEQ||')'" ).append("\n"); 
		query.append("#elseif (${group1} == '8')" ).append("\n"); 
		query.append("--t1.CHSS_MVMT_STS_CD" ).append("\n"); 
		query.append("t5.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}