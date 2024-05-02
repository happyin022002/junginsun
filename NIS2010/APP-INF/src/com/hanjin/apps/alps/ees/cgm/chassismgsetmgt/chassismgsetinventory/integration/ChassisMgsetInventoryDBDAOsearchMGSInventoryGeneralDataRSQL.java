/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryGeneralDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.04 
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

public class ChassisMgsetInventoryDBDAOsearchMGSInventoryGeneralDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090909 2076 start
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchMGSInventoryGeneralDataRSQL(){
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
		params.put("aciac_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryGeneralDataRSQL").append("\n"); 
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
		query.append("#if (${group1} == '1')" ).append("\n"); 
		query.append("C.LCC_CD AS GROUP1 ," ).append("\n"); 
		query.append("#elseif (${group1} == '2')" ).append("\n"); 
		query.append("C.SCC_CD AS GROUP1 ," ).append("\n"); 
		query.append("#elseif (${group1} == '3')" ).append("\n"); 
		query.append("A.CRNT_YD_CD AS GROUP1 ," ).append("\n"); 
		query.append("#elseif (${group1} == '4')" ).append("\n"); 
		query.append("D.VNDR_ABBR_NM||' ('||A.VNDR_SEQ||')'  AS GROUP1 ," ).append("\n"); 
		query.append("#elseif (${group1} == '5')" ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0')||' ('||E.VNDR_ABBR_NM||')' AS GROUP1 ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("A.AGMT_LSTM_CD AS AGMT_LSTM_CD" ).append("\n"); 
		query.append(",D.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append(", count(*)												AS EQ_TPSZ_CD_TOTAL" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN A.EQ_TPSZ_CD = 'UMG' THEN 1 END),0) AS EQ_TPSZ_CD_UMG" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN A.EQ_TPSZ_CD = 'CLG' THEN 1 END),0) AS EQ_TPSZ_CD_CLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_EQUIPMENT A," ).append("\n"); 
		query.append("#if (${atch_bare} != '')" ).append("\n"); 
		query.append("( SELECT A.EQ_NO FROM  CGM_EQ_ATCH_DTCH_HIS A" ).append("\n"); 
		query.append("WHERE A.DTCH_DT = TO_DATE('88881231','YYYYMMDD')" ).append("\n"); 
		query.append("GROUP BY A.EQ_NO" ).append("\n"); 
		query.append(") T8," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("MDM_LOCATION B," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT C," ).append("\n"); 
		query.append("COM_INTG_CD_DTL D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${group1} == '4')" ).append("\n"); 
		query.append(", MDM_VENDOR D" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${group1} == '5')" ).append("\n"); 
		query.append(", MDM_VENDOR E" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.CRNT_LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("#if (${atch_bare} != '')" ).append("\n"); 
		query.append("AND A.EQ_NO= T8.EQ_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.AGMT_LSTM_CD = D.INTG_CD_VAL_CTNT (+)" ).append("\n"); 
		query.append("AND 'CD01948' = D.INTG_CD_ID (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${location} == 'RCC')" ).append("\n"); 
		query.append("AND C.RCC_CD = @[crnt_loc_cd]" ).append("\n"); 
		query.append("#elseif (${location} == 'LCC')" ).append("\n"); 
		query.append("AND C.LCC_CD = @[crnt_loc_cd]" ).append("\n"); 
		query.append("#elseif (${location} == 'SCC')" ).append("\n"); 
		query.append("AND C.SCC_CD = @[crnt_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${group1} == '4')" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${group1} == '5')" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = E.VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${crnt_yd_cd} != '')" ).append("\n"); 
		query.append("AND A.CRNT_YD_CD IN ($crnt_yd_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${aciac_div_cd} != '')" ).append("\n"); 
		query.append("AND A.ACIAC_DIV_CD = @[aciac_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND A.EQ_TPSZ_CD IN ($eq_tpsz_cd)" ).append("\n"); 
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
		query.append("#if (${disp_cd} == 'E')" ).append("\n"); 
		query.append("AND A.DISP_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${disp_cd} == 'O')" ).append("\n"); 
		query.append("AND A.DISP_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("#if (${group1} == '1')" ).append("\n"); 
		query.append("C.LCC_CD ," ).append("\n"); 
		query.append("#elseif (${group1} == '2')" ).append("\n"); 
		query.append("C.SCC_CD ," ).append("\n"); 
		query.append("#elseif (${group1} == '3')" ).append("\n"); 
		query.append("A.CRNT_YD_CD ," ).append("\n"); 
		query.append("#elseif (${group1} == '4')" ).append("\n"); 
		query.append("D.VNDR_ABBR_NM||' ('||A.VNDR_SEQ||')' ," ).append("\n"); 
		query.append("#elseif (${group1} == '5')" ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0')||' ('||E.VNDR_ABBR_NM||')'  ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("A.AGMT_LSTM_CD ," ).append("\n"); 
		query.append("D.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("#if (${group1} == '1')" ).append("\n"); 
		query.append("C.LCC_CD ASC ," ).append("\n"); 
		query.append("#elseif (${group1} == '2')" ).append("\n"); 
		query.append("C.SCC_CD ASC ," ).append("\n"); 
		query.append("#elseif (${group1} == '3')" ).append("\n"); 
		query.append("A.CRNT_YD_CD ASC ," ).append("\n"); 
		query.append("#elseif (${group1} == '4')" ).append("\n"); 
		query.append("D.VNDR_ABBR_NM||' ('||A.VNDR_SEQ||')' ASC ," ).append("\n"); 
		query.append("#elseif (${group1} == '5')" ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0')||' ('||E.VNDR_ABBR_NM||')' ASC ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--A.AGMT_LSTM_CD ASC" ).append("\n"); 
		query.append("D.INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}