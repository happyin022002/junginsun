/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchInventoryByStaydaysListDataRSQL.java
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

public class ChassisMgsetInventoryDBDAOsearchInventoryByStaydaysListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090728 1092 popup add
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchInventoryByStaydaysListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("group_value1",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchInventoryByStaydaysListDataRSQL").append("\n"); 
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
		query.append("A.EQ_NO," ).append("\n"); 
		query.append("A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("A.AGMT_LSTM_CD," ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("B.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.CHSS_MVMT_STS_CD," ).append("\n"); 
		query.append("D.LCC_CD," ).append("\n"); 
		query.append("C.SCC_CD," ).append("\n"); 
		query.append("A.CRNT_YD_CD," ).append("\n"); 
		query.append("A.ONH_DT," ).append("\n"); 
		query.append("A.CHSS_MVMT_DT," ).append("\n"); 
		query.append("TRUNC(SYSDATE - A.CHSS_MVMT_DT,0) AS LSDAYS" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_EQUIPMENT A," ).append("\n"); 
		query.append("CGM_EQ_STS_HIS t2," ).append("\n"); 
		query.append("#if (${atch_bare} != '')" ).append("\n"); 
		query.append("( SELECT A.EQ_NO FROM  CGM_EQ_ATCH_DTCH_HIS A" ).append("\n"); 
		query.append("WHERE A.DTCH_DT = TO_DATE('88881231','YYYYMMDD')" ).append("\n"); 
		query.append("GROUP BY A.EQ_NO" ).append("\n"); 
		query.append(") T8," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("MDM_VENDOR B," ).append("\n"); 
		query.append("MDM_LOCATION C," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("#if (${atch_bare} != '')" ).append("\n"); 
		query.append("AND A.EQ_NO= T8.EQ_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.CRNT_LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("AND A.EQ_NO = t2.EQ_NO" ).append("\n"); 
		query.append("AND A.eq_sts_seq= t2.eq_sts_seq" ).append("\n"); 
		query.append("AND C.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#if (${location} == 'RCC')" ).append("\n"); 
		query.append("AND D.RCC_CD = @[crnt_loc_cd]" ).append("\n"); 
		query.append("#elseif (${location} == 'LCC')" ).append("\n"); 
		query.append("AND D.LCC_CD = @[crnt_loc_cd]" ).append("\n"); 
		query.append("#elseif (${location} == 'SCC')" ).append("\n"); 
		query.append("AND D.SCC_CD = @[crnt_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${crnt_yd_cd} != '')" ).append("\n"); 
		query.append("AND A.CRNT_YD_CD IN ($crnt_yd_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${aciac_div_cd} != '')" ).append("\n"); 
		query.append("AND A.ACIAC_DIV_CD = @[aciac_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chss_pool_cd} != 'I')" ).append("\n"); 
		query.append("#if (${chss_pool_cd} == 'E')" ).append("\n"); 
		query.append("AND A.CHSS_POOL_CD IS NULL" ).append("\n"); 
		query.append("#elseif (${chss_pool_cd} == 'O')" ).append("\n"); 
		query.append("AND A.CHSS_POOL_CD IS NOT NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${include_np} != 'Y')" ).append("\n"); 
		query.append("AND A.AGMT_LSTM_CD <>'NP'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${staying_days} != '' && ${s_group1} == 'TotalColumn')" ).append("\n"); 
		query.append("AND A.CHSS_MVMT_DT < SYSDATE - TO_NUMBER(${staying_days})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inq_fm_dys} != '')" ).append("\n"); 
		query.append("#if(${inq_to_dys} != '')" ).append("\n"); 
		query.append("AND sysdate - A.CHSS_MVMT_DT between TO_NUMBER(${inq_fm_dys}) and TO_NUMBER(${inq_to_dys})+1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND sysdate - A.CHSS_MVMT_DT > TO_NUMBER(${inq_fm_dys})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND A.EQ_TPSZ_CD IN ($eq_tpsz_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("AND A.AGMT_LSTM_CD IN ($agmt_lstm_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND A.VNDR_SEQ IN ($vndr_seq)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chss_mvmt_sts_cd} != '')" ).append("\n"); 
		query.append("AND A.CHSS_MVMT_STS_CD IN ($chss_mvmt_sts_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${include_status_lst} == 'Y')" ).append("\n"); 
		query.append("AND t2.EQ_ASET_STS_CD = 'LST'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${include_out_gated} == 'Y')" ).append("\n"); 
		query.append("AND A.GATE_IO_CD = 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${atch_bare} == 'ATTACHED')" ).append("\n"); 
		query.append("AND	T8.EQ_NO IS NOT NULL" ).append("\n"); 
		query.append("#elseif (${atch_bare} == 'BARE')" ).append("\n"); 
		query.append("AND T8.EQ_NO IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dmg_snd} == 'DAMAGE')" ).append("\n"); 
		query.append("AND A.DMG_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${dmg_snd} == 'SOUND')" ).append("\n"); 
		query.append("AND ((A.DMG_FLG <> 'Y') or (A.DMG_FLG IS NULL))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${s3_gtotal} == 'GTOTAL' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if ( ${group1} == '1')" ).append("\n"); 
		query.append("AND A.EQ_TPSZ_CD = @[group_value1]" ).append("\n"); 
		query.append("#elseif (${group1} == '2')" ).append("\n"); 
		query.append("AND D.LCC_CD = @[group_value1]" ).append("\n"); 
		query.append("#elseif (${group1} == '3')" ).append("\n"); 
		query.append("AND A.ONH_OFC_CD = @[group_value1]" ).append("\n"); 
		query.append("#elseif (${group1} == '4')" ).append("\n"); 
		query.append("AND C.SCC_CD = @[group_value1]" ).append("\n"); 
		query.append("#elseif (${group1} == '5')" ).append("\n"); 
		query.append("AND A.CRNT_YD_CD = @[group_value1]" ).append("\n"); 
		query.append("#elseif (${group1} == '6')" ).append("\n"); 
		query.append("AND A.AGMT_LSTM_CD = @[group_value1]" ).append("\n"); 
		query.append("#elseif (${group1} == '7')" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = SUBSTR(@[group_value1], INSTR(@[group_value1],'(')+1, 6)" ).append("\n"); 
		query.append("#elseif (${group1} == '8')" ).append("\n"); 
		query.append("AND A.CHSS_MVMT_STS_CD = @[group_value1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}