/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOSearchCHSInventoryGeneralDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.26
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.01.26 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOSearchCHSInventoryGeneralDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInventoryDB.SearchCHSInventoryGeneralData
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOSearchCHSInventoryGeneralDataRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOSearchCHSInventoryGeneralDataRSQL").append("\n"); 
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
		query.append("#if (${group1} == '1') " ).append("\n"); 
		query.append("	C.LCC_CD AS GROUP1," ).append("\n"); 
		query.append("#elseif (${group1} == '2') " ).append("\n"); 
		query.append("	A.ONH_OFC_CD AS GROUP1," ).append("\n"); 
		query.append("#elseif (${group1} == '3') " ).append("\n"); 
		query.append("	B.SCC_CD AS GROUP1," ).append("\n"); 
		query.append("#elseif (${group1} == '4') " ).append("\n"); 
		query.append("	A.CRNT_YD_CD AS GROUP1," ).append("\n"); 
		query.append("#elseif (${group1} == '5') " ).append("\n"); 
		query.append("	A.AGMT_LSTM_CD AS GROUP1," ).append("\n"); 
		query.append("	D.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("#elseif (${group1} == '6') " ).append("\n"); 
		query.append("	REPLACE(F.VNDR_ABBR_NM,'&','')||' ('||A.VNDR_SEQ||')' AS GROUP1," ).append("\n"); 
		query.append("	A.VNDR_SEQ ," ).append("\n"); 
		query.append("#elseif (${group1} == '7') " ).append("\n"); 
		query.append("	A.CHSS_MVMT_STS_CD AS GROUP1," ).append("\n"); 
		query.append("	E.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${group2} == '1') " ).append("\n"); 
		query.append("	C.LCC_CD AS GROUP2," ).append("\n"); 
		query.append("#elseif (${group2} == '2') " ).append("\n"); 
		query.append("	A.ONH_OFC_CD AS GROUP2," ).append("\n"); 
		query.append("#elseif (${group2} == '3') " ).append("\n"); 
		query.append("	B.SCC_CD AS GROUP2," ).append("\n"); 
		query.append("#elseif (${group2} == '4') " ).append("\n"); 
		query.append("	A.CRNT_YD_CD AS GROUP2," ).append("\n"); 
		query.append("#elseif (${group2} == '5') " ).append("\n"); 
		query.append("	A.AGMT_LSTM_CD AS GROUP2," ).append("\n"); 
		query.append("	D.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("#elseif (${group2} == '6') " ).append("\n"); 
		query.append("	REPLACE(F.VNDR_ABBR_NM,'&','')||' ('||A.VNDR_SEQ||')' AS GROUP2," ).append("\n"); 
		query.append("	A.VNDR_SEQ ," ).append("\n"); 
		query.append("#elseif (${group2} == '7') " ).append("\n"); 
		query.append("	A.CHSS_MVMT_STS_CD AS GROUP2," ).append("\n"); 
		query.append("	E.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${group3} == '1') " ).append("\n"); 
		query.append("	C.LCC_CD AS GROUP3," ).append("\n"); 
		query.append("#elseif (${group3} == '2') " ).append("\n"); 
		query.append("	A.ONH_OFC_CD AS GROUP3," ).append("\n"); 
		query.append("#elseif (${group3} == '3') " ).append("\n"); 
		query.append("	B.SCC_CD AS GROUP3," ).append("\n"); 
		query.append("#elseif (${group3} == '4') " ).append("\n"); 
		query.append("	A.CRNT_YD_CD AS GROUP3," ).append("\n"); 
		query.append("#elseif (${group3} == '5') " ).append("\n"); 
		query.append("	A.AGMT_LSTM_CD AS GROUP3," ).append("\n"); 
		query.append("	D.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("#elseif (${group3} == '6') " ).append("\n"); 
		query.append("	REPLACE(F.VNDR_ABBR_NM,'&','')||' ('||A.VNDR_SEQ||')' AS GROUP3," ).append("\n"); 
		query.append("    A.VNDR_SEQ ," ).append("\n"); 
		query.append("#elseif (${group3} == '7') " ).append("\n"); 
		query.append("	A.CHSS_MVMT_STS_CD AS GROUP3," ).append("\n"); 
		query.append("	E.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '1' THEN 1 END),0) AS EQ_TPSZ_CD1," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '2' THEN 1 END),0) AS EQ_TPSZ_CD2," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '3' THEN 1 END),0) AS EQ_TPSZ_CD3," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '4' THEN 1 END),0) AS EQ_TPSZ_CD4," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '5' THEN 1 END),0) AS EQ_TPSZ_CD5," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '6' THEN 1 END),0) AS EQ_TPSZ_CD6," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '7' THEN 1 END),0) AS EQ_TPSZ_CD7," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '8' THEN 1 END),0) AS EQ_TPSZ_CD8," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '9' THEN 1 END),0) AS EQ_TPSZ_CD9," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '10' THEN 1 END),0) AS EQ_TPSZ_CD10," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '11' THEN 1 END),0) AS EQ_TPSZ_CD11," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '12' THEN 1 END),0) AS EQ_TPSZ_CD12," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '13' THEN 1 END),0) AS EQ_TPSZ_CD13," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '14' THEN 1 END),0) AS EQ_TPSZ_CD14," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '15' THEN 1 END),0) AS EQ_TPSZ_CD15," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '16' THEN 1 END),0) AS EQ_TPSZ_CD16," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '17' THEN 1 END),0) AS EQ_TPSZ_CD17," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '18' THEN 1 END),0) AS EQ_TPSZ_CD18," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '19' THEN 1 END),0) AS EQ_TPSZ_CD19," ).append("\n"); 
		query.append("	NVL(SUM(CASE WHEN G.DP_SEQ = '20' THEN 1 END),0) AS EQ_TPSZ_CD20      " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    CGM_EQUIPMENT A," ).append("\n"); 
		query.append("    MDM_LOCATION B," ).append("\n"); 
		query.append("    MDM_EQ_ORZ_CHT C," ).append("\n"); 
		query.append("    COM_INTG_CD_DTL D," ).append("\n"); 
		query.append("    COM_INTG_CD_DTL E," ).append("\n"); 
		query.append("	MDM_VENDOR F," ).append("\n"); 
		query.append("	(SELECT EQ_TPSZ_CD,ROW_NUMBER() OVER (ORDER BY EQ_TPSZ_REP_CD,EQ_TPSZ_CD) DP_SEQ " ).append("\n"); 
		query.append("   	   FROM CGM_EQ_TP_SZ WHERE EQ_KND_CD = 'Z' GROUP BY EQ_TPSZ_REP_CD,EQ_TPSZ_CD) G" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	A.VNDR_SEQ = F.VNDR_SEQ(+)" ).append("\n"); 
		query.append("    AND A.CRNT_LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("    AND B.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("	AND A.EQ_TPSZ_CD = G.EQ_TPSZ_CD" ).append("\n"); 
		query.append("    AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("	AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#if (${location} == 'RCC')" ).append("\n"); 
		query.append("	AND C.RCC_CD = @[crnt_loc_cd]" ).append("\n"); 
		query.append("#elseif (${location} == 'LCC')" ).append("\n"); 
		query.append("	AND C.LCC_CD = @[crnt_loc_cd]" ).append("\n"); 
		query.append("#elseif (${location} == 'SCC')" ).append("\n"); 
		query.append("	AND C.SCC_CD = @[crnt_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND A.AGMT_LSTM_CD = D.INTG_CD_VAL_CTNT (+)" ).append("\n"); 
		query.append("    AND 'CD01948' = D.INTG_CD_ID (+)" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND A.CHSS_MVMT_STS_CD = E.INTG_CD_VAL_CTNT (+)" ).append("\n"); 
		query.append("    AND 'CD02386' = E.INTG_CD_ID (+)" ).append("\n"); 
		query.append("    " ).append("\n"); 
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
		query.append("	AND A.CHSS_MVMT_DT < SYSDATE - TO_NUMBER(${staying_days}) " ).append("\n"); 
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
		query.append("#if (${group1} != '') " ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${group1} == '1') " ).append("\n"); 
		query.append("	C.LCC_CD" ).append("\n"); 
		query.append("#elseif (${group1} == '2') " ).append("\n"); 
		query.append("	A.ONH_OFC_CD" ).append("\n"); 
		query.append("#elseif (${group1} == '3') " ).append("\n"); 
		query.append("	B.SCC_CD" ).append("\n"); 
		query.append("#elseif (${group1} == '4') " ).append("\n"); 
		query.append("	A.CRNT_YD_CD" ).append("\n"); 
		query.append("#elseif (${group1} == '5') " ).append("\n"); 
		query.append("	A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("	,D.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#elseif (${group1} == '6') " ).append("\n"); 
		query.append("	REPLACE(F.VNDR_ABBR_NM,'&','')||' ('||A.VNDR_SEQ||')'" ).append("\n"); 
		query.append("    ,A.VNDR_SEQ " ).append("\n"); 
		query.append("#elseif (${group1} == '7') " ).append("\n"); 
		query.append("	A.CHSS_MVMT_STS_CD" ).append("\n"); 
		query.append("	,E.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${group2} == '1') " ).append("\n"); 
		query.append("	, C.LCC_CD" ).append("\n"); 
		query.append("#elseif (${group2} == '2') " ).append("\n"); 
		query.append("	, A.ONH_OFC_CD" ).append("\n"); 
		query.append("#elseif (${group2} == '3') " ).append("\n"); 
		query.append("	, B.SCC_CD" ).append("\n"); 
		query.append("#elseif (${group2} == '4') " ).append("\n"); 
		query.append("	, A.CRNT_YD_CD" ).append("\n"); 
		query.append("#elseif (${group2} == '5') " ).append("\n"); 
		query.append("	, A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("	, D.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#elseif (${group2} == '6') " ).append("\n"); 
		query.append("	, REPLACE(F.VNDR_ABBR_NM,'&','')||' ('||A.VNDR_SEQ||')'" ).append("\n"); 
		query.append("	,A.VNDR_SEQ " ).append("\n"); 
		query.append("#elseif (${group2} == '7') " ).append("\n"); 
		query.append("	, A.CHSS_MVMT_STS_CD" ).append("\n"); 
		query.append("	, E.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${group3} == '1') " ).append("\n"); 
		query.append("	, C.LCC_CD" ).append("\n"); 
		query.append("#elseif (${group3} == '2') " ).append("\n"); 
		query.append("	, A.ONH_OFC_CD" ).append("\n"); 
		query.append("#elseif (${group3} == '3') " ).append("\n"); 
		query.append("	, B.SCC_CD" ).append("\n"); 
		query.append("#elseif (${group3} == '4') " ).append("\n"); 
		query.append("	, A.CRNT_YD_CD" ).append("\n"); 
		query.append("#elseif (${group3} == '5') " ).append("\n"); 
		query.append("	, A.AGMT_LSTM_CD " ).append("\n"); 
		query.append("	, D.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#elseif (${group3} == '6') " ).append("\n"); 
		query.append("	, REPLACE(F.VNDR_ABBR_NM,'&','')||' ('||A.VNDR_SEQ||')'" ).append("\n"); 
		query.append("	,A.VNDR_SEQ " ).append("\n"); 
		query.append("#elseif (${group3} == '7') " ).append("\n"); 
		query.append("	, A.CHSS_MVMT_STS_CD" ).append("\n"); 
		query.append("	, E.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${group1} != '') " ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${group1} == '1') " ).append("\n"); 
		query.append("	C.LCC_CD" ).append("\n"); 
		query.append("#elseif (${group1} == '2') " ).append("\n"); 
		query.append("	A.ONH_OFC_CD" ).append("\n"); 
		query.append("#elseif (${group1} == '3') " ).append("\n"); 
		query.append("	B.SCC_CD" ).append("\n"); 
		query.append("#elseif (${group1} == '4') " ).append("\n"); 
		query.append("	A.CRNT_YD_CD" ).append("\n"); 
		query.append("#elseif (${group1} == '5') " ).append("\n"); 
		query.append("	--A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("	D.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#elseif (${group1} == '6') " ).append("\n"); 
		query.append("	REPLACE(F.VNDR_ABBR_NM,'&','')||' ('||A.VNDR_SEQ||')'" ).append("\n"); 
		query.append("	,A.VNDR_SEQ " ).append("\n"); 
		query.append("#elseif (${group1} == '7') " ).append("\n"); 
		query.append("	--A.CHSS_MVMT_STS_CD" ).append("\n"); 
		query.append("	E.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${group2} == '1') " ).append("\n"); 
		query.append("	, C.LCC_CD" ).append("\n"); 
		query.append("#elseif (${group2} == '2') " ).append("\n"); 
		query.append("	, A.ONH_OFC_CD" ).append("\n"); 
		query.append("#elseif (${group2} == '3') " ).append("\n"); 
		query.append("	, B.SCC_CD" ).append("\n"); 
		query.append("#elseif (${group2} == '4') " ).append("\n"); 
		query.append("	, A.CRNT_YD_CD" ).append("\n"); 
		query.append("#elseif (${group2} == '5') " ).append("\n"); 
		query.append("	--, A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("	, D.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#elseif (${group2} == '6') " ).append("\n"); 
		query.append("	, REPLACE(F.VNDR_ABBR_NM,'&','')||' ('||A.VNDR_SEQ||')'" ).append("\n"); 
		query.append("	,A.VNDR_SEQ " ).append("\n"); 
		query.append("#elseif (${group2} == '7') " ).append("\n"); 
		query.append("	--, A.CHSS_MVMT_STS_CD" ).append("\n"); 
		query.append("	,E.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${group3} == '1') " ).append("\n"); 
		query.append("	, C.LCC_CD" ).append("\n"); 
		query.append("#elseif (${group3} == '2') " ).append("\n"); 
		query.append("	, A.ONH_OFC_CD" ).append("\n"); 
		query.append("#elseif (${group3} == '3') " ).append("\n"); 
		query.append("	, B.SCC_CD" ).append("\n"); 
		query.append("#elseif (${group3} == '4') " ).append("\n"); 
		query.append("	, A.CRNT_YD_CD" ).append("\n"); 
		query.append("#elseif (${group3} == '5') " ).append("\n"); 
		query.append("	--, A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("	, D.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#elseif (${group3} == '6') " ).append("\n"); 
		query.append("	, REPLACE(F.VNDR_ABBR_NM,'&','')||' ('||A.VNDR_SEQ||')'" ).append("\n"); 
		query.append("	,A.VNDR_SEQ " ).append("\n"); 
		query.append("#elseif (${group3} == '7') " ).append("\n"); 
		query.append("	--, A.CHSS_MVMT_STS_CD" ).append("\n"); 
		query.append("	,E.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}