/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOSearchCHSInventoryGeneralListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOSearchCHSInventoryGeneralListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2014.11.19 Chang Young Kim, CHM-201432568
	  * 2015.07.14 Chang Young Kim, CHM-201536892 증복건 제거
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOSearchCHSInventoryGeneralListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s2_eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s2_group2_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("group_value3",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("group_value2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s2_group1_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s2_group3_val",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ChassisMgsetInventoryDBDAOSearchCHSInventoryGeneralListDataRSQL").append("\n"); 
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
		query.append("    A.EQ_NO," ).append("\n"); 
		query.append("    MAX(A.EQ_TPSZ_CD) AS EQ_TPSZ_CD," ).append("\n"); 
		query.append("    MAX(A.AGMT_LSTM_CD) AS AGMT_LSTM_CD," ).append("\n"); 
		query.append("    (MAX(A.AGMT_OFC_CTY_CD) || MAX(LPAD(A.AGMT_SEQ, 6, '0'))) AS AGMT_NO," ).append("\n"); 
		query.append("    MAX(B.VNDR_ABBR_NM) AS VNDR_ABBR_NM," ).append("\n"); 
		query.append("    MAX(A.CHSS_MVMT_STS_CD) AS CHSS_MVMT_STS_CD," ).append("\n"); 
		query.append("    MAX(D.LCC_CD) AS LCC_CD," ).append("\n"); 
		query.append("    C.SCC_CD," ).append("\n"); 
		query.append("    A.CRNT_YD_CD," ).append("\n"); 
		query.append("	MAX(A.MFT_DT) AS MFT_DT," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT STS_EVNT_DT" ).append("\n"); 
		query.append("        FROM CGM_EQ_STS_HIS" ).append("\n"); 
		query.append("        WHERE EQ_NO = A.EQ_NO" ).append("\n"); 
		query.append("        AND EQ_ASET_STS_CD ='LSI'" ).append("\n"); 
		query.append("        AND ROWNUM =1" ).append("\n"); 
		query.append("    ) AS ONH_DT," ).append("\n"); 
		query.append("    MAX(A.ONH_DT) AS ACT_ONH_DT," ).append("\n"); 
		query.append("    MAX(A.CHSS_MVMT_DT) AS CHSS_MVMT_DT," ).append("\n"); 
		query.append("    MAX(TRUNC(SYSDATE - A.CHSS_MVMT_DT,0)) AS LSDAYS," ).append("\n"); 
		query.append("	MAX(E.CNTR_NO) AS CNTR_NO," ).append("\n"); 
		query.append("	MAX(E.MGST_NO) AS MGST_NO," ).append("\n"); 
		query.append("	CASE WHEN MAX(A.CHSS_MVMT_STS_CD) LIKE 'B%' THEN 'Y'" ).append("\n"); 
		query.append("     	 ELSE 'N' END BARE_FLG," ).append("\n"); 
		query.append("	MAX(A.DMG_FLG) AS DMG_FLG," ).append("\n"); 
		query.append("	MAX(A.DISP_FLG) AS DISP_FLG" ).append("\n"); 
		query.append("FROM    " ).append("\n"); 
		query.append("	CGM_EQUIPMENT A," ).append("\n"); 
		query.append("    MDM_VENDOR B," ).append("\n"); 
		query.append("    MDM_LOCATION C," ).append("\n"); 
		query.append("    MDM_EQ_ORZ_CHT D," ).append("\n"); 
		query.append("	CGM_CHSS_MVMT_HIS E" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = B.VNDR_SEQ (+)" ).append("\n"); 
		query.append("      AND A.CRNT_LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("      AND C.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("      AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("      AND D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("      AND A.EQ_NO = E.CHSS_NO(+)" ).append("\n"); 
		query.append("	  AND TO_CHAR(A.CHSS_MVMT_DT, 'YYYYMMDDHH24MI') = TO_CHAR(E.MVMT_DT(+), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	  AND A.CRNT_YD_CD = E.YD_CD(+)" ).append("\n"); 
		query.append("	  AND A.CHSS_MVMT_STS_CD = E.MVMT_STS_CD(+)" ).append("\n"); 
		query.append("	  AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#if (${location} == 'RCC')" ).append("\n"); 
		query.append("	AND D.RCC_CD = @[crnt_loc_cd]" ).append("\n"); 
		query.append("#elseif (${location} == 'LCC')" ).append("\n"); 
		query.append("	AND D.LCC_CD = @[crnt_loc_cd]" ).append("\n"); 
		query.append("#elseif (${location} == 'SCC')" ).append("\n"); 
		query.append("	AND D.SCC_CD = @[crnt_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${crnt_yd_cd} != '')" ).append("\n"); 
		query.append("	AND A.CRNT_YD_CD IN ($crnt_yd_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${aciac_div_cd} != '')" ).append("\n"); 
		query.append("	AND A.ACIAC_DIV_CD = @[aciac_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chss_pool_cd} != 'I')" ).append("\n"); 
		query.append("	#if (${chss_pool_cd} == 'E')" ).append("\n"); 
		query.append("		AND A.CHSS_POOL_CD IS NULL" ).append("\n"); 
		query.append("	#elseif (${chss_pool_cd} == 'O')" ).append("\n"); 
		query.append("		AND A.CHSS_POOL_CD IS NOT NULL" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND A.CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${include_np} != 'Y')" ).append("\n"); 
		query.append("	AND A.AGMT_LSTM_CD <>'NP'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${staying_days} != '')" ).append("\n"); 
		query.append("	AND A.CHSS_MVMT_DT < SYSDATE - TO_NUMBER(${staying_days})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("	AND A.EQ_TPSZ_CD IN ($eq_tpsz_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("	AND A.AGMT_LSTM_CD IN ($agmt_lstm_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("	AND A.VNDR_SEQ IN ($vndr_seq)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chss_mvmt_sts_cd} != '')" ).append("\n"); 
		query.append("	AND A.CHSS_MVMT_STS_CD IN ($chss_mvmt_sts_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s2_eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("	AND A.EQ_TPSZ_CD = @[s2_eq_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${group_value1} == 'Grand Total')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${group_value1} == 'SubSum')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s2_group1} == '1') " ).append("\n"); 
		query.append("	AND D.LCC_CD = @[s2_group1_val]" ).append("\n"); 
		query.append("#elseif (${s2_group1} == '2') " ).append("\n"); 
		query.append("	AND A.ONH_OFC_CD = @[s2_group1_val]" ).append("\n"); 
		query.append("#elseif (${s2_group1} == '3') " ).append("\n"); 
		query.append("	AND C.SCC_CD = @[s2_group1_val]" ).append("\n"); 
		query.append("#elseif (${s2_group1} == '4') " ).append("\n"); 
		query.append("	AND A.CRNT_YD_CD = @[s2_group1_val]" ).append("\n"); 
		query.append("#elseif (${s2_group1} == '5') " ).append("\n"); 
		query.append("	AND A.AGMT_LSTM_CD = @[s2_group1_val]" ).append("\n"); 
		query.append("#elseif (${s2_group1} == '6') " ).append("\n"); 
		query.append("	AND A.VNDR_SEQ = SUBSTR(@[s2_group1_val], INSTR(@[s2_group1_val],'(')+1, 6)" ).append("\n"); 
		query.append("#elseif (${s2_group1} == '7') " ).append("\n"); 
		query.append("	AND A.CHSS_MVMT_STS_CD = @[s2_group1_val]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s2_group2} == '1') " ).append("\n"); 
		query.append("	AND D.LCC_CD = @[s2_group2_val]" ).append("\n"); 
		query.append("#elseif (${s2_group2} == '2') " ).append("\n"); 
		query.append("	AND A.ONH_OFC_CD = @[s2_group2_val]" ).append("\n"); 
		query.append("#elseif (${s2_group2} == '3') " ).append("\n"); 
		query.append("	AND C.SCC_CD = @[s2_group2_val]" ).append("\n"); 
		query.append("#elseif (${s2_group2} == '4') " ).append("\n"); 
		query.append("	AND A.CRNT_YD_CD = @[s2_group2_val]" ).append("\n"); 
		query.append("#elseif (${s2_group2} == '5') " ).append("\n"); 
		query.append("	AND A.AGMT_LSTM_CD = @[s2_group2_val]" ).append("\n"); 
		query.append("#elseif (${s2_group2} == '6') " ).append("\n"); 
		query.append("	AND A.VNDR_SEQ = SUBSTR(@[s2_group2_val], INSTR(@[s2_group2_val],'(')+1, 6)" ).append("\n"); 
		query.append("#elseif (${s2_group2} == '7') " ).append("\n"); 
		query.append("	AND A.CHSS_MVMT_STS_CD = @[s2_group2_val]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s2_group3} == '1') " ).append("\n"); 
		query.append("	AND D.LCC_CD = @[s2_group3_val]" ).append("\n"); 
		query.append("#elseif (${s2_group3} == '2') " ).append("\n"); 
		query.append("	AND A.ONH_OFC_CD = @[s2_group3_val]" ).append("\n"); 
		query.append("#elseif (${s2_group3} == '3') " ).append("\n"); 
		query.append("	AND C.SCC_CD = @[s2_group3_val]" ).append("\n"); 
		query.append("#elseif (${s2_group3} == '4') " ).append("\n"); 
		query.append("	AND A.CRNT_YD_CD = @[s2_group3_val]" ).append("\n"); 
		query.append("#elseif (${s2_group3} == '5') " ).append("\n"); 
		query.append("	AND A.AGMT_LSTM_CD = @[s2_group3_val]" ).append("\n"); 
		query.append("#elseif (${s2_group3} == '6') " ).append("\n"); 
		query.append("	AND A.VNDR_SEQ = SUBSTR(@[s2_group3_val], INSTR(@[s2_group3_val],'(')+1, 6)" ).append("\n"); 
		query.append("#elseif (${s2_group3} == '7') " ).append("\n"); 
		query.append("	AND A.CHSS_MVMT_STS_CD = @[s2_group3_val]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${group1} == '1') " ).append("\n"); 
		query.append("	AND D.LCC_CD = @[group_value1]" ).append("\n"); 
		query.append("#elseif (${group1} == '2') " ).append("\n"); 
		query.append("	AND A.ONH_OFC_CD = @[group_value1]" ).append("\n"); 
		query.append("#elseif (${group1} == '3') " ).append("\n"); 
		query.append("	AND C.SCC_CD = @[group_value1]" ).append("\n"); 
		query.append("#elseif (${group1} == '4') " ).append("\n"); 
		query.append("	AND A.CRNT_YD_CD = @[group_value1]" ).append("\n"); 
		query.append("#elseif (${group1} == '5') " ).append("\n"); 
		query.append("	AND A.AGMT_LSTM_CD = @[group_value1]" ).append("\n"); 
		query.append("#elseif (${group1} == '6') " ).append("\n"); 
		query.append("	AND A.VNDR_SEQ = SUBSTR(@[group_value1], INSTR(@[group_value1],'(')+1, 6)" ).append("\n"); 
		query.append("#elseif (${group1} == '7') " ).append("\n"); 
		query.append("	AND A.CHSS_MVMT_STS_CD = @[group_value1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${group2} == '1') " ).append("\n"); 
		query.append("	AND D.LCC_CD = @[group_value2]" ).append("\n"); 
		query.append("#elseif (${group2} == '2') " ).append("\n"); 
		query.append("	AND A.ONH_OFC_CD = @[group_value2]" ).append("\n"); 
		query.append("#elseif (${group2} == '3') " ).append("\n"); 
		query.append("	AND C.SCC_CD = @[group_value2]" ).append("\n"); 
		query.append("#elseif (${group2} == '4') " ).append("\n"); 
		query.append("	AND A.CRNT_YD_CD = @[group_value2]" ).append("\n"); 
		query.append("#elseif (${group2} == '5') " ).append("\n"); 
		query.append("	AND A.AGMT_LSTM_CD = @[group_value2]" ).append("\n"); 
		query.append("#elseif (${group2} == '6') " ).append("\n"); 
		query.append("	AND A.VNDR_SEQ = SUBSTR(@[group_value2], INSTR(@[group_value2],'(')+1, 6)" ).append("\n"); 
		query.append("#elseif (${group2} == '7') " ).append("\n"); 
		query.append("	AND A.CHSS_MVMT_STS_CD = @[group_value2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${group3} == '1') " ).append("\n"); 
		query.append("	AND D.LCC_CD = @[group_value3]" ).append("\n"); 
		query.append("#elseif (${group3} == '2') " ).append("\n"); 
		query.append("	AND A.ONH_OFC_CD = @[group_value3]" ).append("\n"); 
		query.append("#elseif (${group3} == '3') " ).append("\n"); 
		query.append("	AND C.SCC_CD = @[group_value3]" ).append("\n"); 
		query.append("#elseif (${group3} == '4') " ).append("\n"); 
		query.append("	AND A.CRNT_YD_CD = @[group_value3]" ).append("\n"); 
		query.append("#elseif (${group3} == '5') " ).append("\n"); 
		query.append("	AND A.AGMT_LSTM_CD = @[group_value3]" ).append("\n"); 
		query.append("#elseif (${group3} == '6') " ).append("\n"); 
		query.append("	AND A.VNDR_SEQ = SUBSTR(@[group_value3], INSTR(@[group_value3],'(')+1, 6)" ).append("\n"); 
		query.append("#elseif (${group3} == '7') " ).append("\n"); 
		query.append("	AND A.CHSS_MVMT_STS_CD = @[group_value3]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.EQ_NO, C.SCC_CD, A.CRNT_YD_CD" ).append("\n"); 

	}
}