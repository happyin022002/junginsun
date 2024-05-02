/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchCHSInventoryByOnhireYearListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOsearchCHSInventoryByOnhireYearListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090730 1100 popup start
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchCHSInventoryByOnhireYearListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inq_fm_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inq_to_dys",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_group1_val",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchCHSInventoryByOnhireYearListDataRSQL").append("\n"); 
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
		query.append("    A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("    A.AGMT_LSTM_CD," ).append("\n"); 
		query.append("    A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("    B.VNDR_LGL_ENG_NM VNDR_ABBR_NM," ).append("\n"); 
		query.append("    A.CHSS_MVMT_STS_CD," ).append("\n"); 
		query.append("    D.LCC_CD," ).append("\n"); 
		query.append("    C.SCC_CD," ).append("\n"); 
		query.append("    A.CRNT_YD_CD," ).append("\n"); 
		query.append("    A.ONH_DT," ).append("\n"); 
		query.append("    A.CHSS_MVMT_DT," ).append("\n"); 
		query.append("    TRUNC(SYSDATE - A.CHSS_MVMT_DT,0) AS LSDAYS" ).append("\n"); 
		query.append("FROM    " ).append("\n"); 
		query.append("	CGM_EQUIPMENT A," ).append("\n"); 
		query.append("    CGM_EQ_STS_HIS t2," ).append("\n"); 
		query.append("    MDM_VENDOR B," ).append("\n"); 
		query.append("    MDM_LOCATION C," ).append("\n"); 
		query.append("    MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = B.VNDR_SEQ (+)" ).append("\n"); 
		query.append("      AND A.CRNT_LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("	  AND A.EQ_NO = t2.EQ_NO" ).append("\n"); 
		query.append("      AND A.eq_sts_seq= t2.eq_sts_seq" ).append("\n"); 
		query.append("      AND C.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("      AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("      AND D.DELT_FLG = 'N'" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#if (${include_np} != 'Y')" ).append("\n"); 
		query.append("	AND A.AGMT_LSTM_CD <>'NP'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inq_to_dys} != '')" ).append("\n"); 
		query.append("	#if(${inq_fm_dys} != '')" ).append("\n"); 
		query.append("        AND TO_CHAR(A.ONH_DT,'YYYY') >= @[inq_fm_dys] AND TO_CHAR(A.ONH_DT,'YYYY')<= @[inq_to_dys]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND TO_CHAR(A.ONH_DT,'YYYY')<= @[inq_to_dys]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("	AND A.EQ_TPSZ_CD IN ($agmt_lstm_cd)" ).append("\n"); 
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
		query.append("#if ( ${s3_gtotal} == 'GTOTAL' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${group1} == '1') " ).append("\n"); 
		query.append("	AND D.LCC_CD = @[group_value1]" ).append("\n"); 
		query.append("#elseif (${group1} == '2') " ).append("\n"); 
		query.append("	AND C.SCC_CD = @[group_value1]" ).append("\n"); 
		query.append("#elseif (${group1} == '3') " ).append("\n"); 
		query.append("	AND A.CRNT_YD_CD = @[group_value1]" ).append("\n"); 
		query.append("#elseif (${group1} == '4') " ).append("\n"); 
		query.append("	AND A.AGMT_LSTM_CD = @[group_value1]" ).append("\n"); 
		query.append("#elseif (${group1} == '5') " ).append("\n"); 
		query.append("	AND A.VNDR_SEQ = SUBSTR(@[group_value1], INSTR(@[group_value1],'(')+1, 6)" ).append("\n"); 
		query.append("#elseif (${group1} == '6') " ).append("\n"); 
		query.append("	AND A.CHSS_MVMT_STS_CD = @[group_value1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_group1_val} != '')" ).append("\n"); 
		query.append("	AND A.EQ_TPSZ_CD = @[s_group1_val]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}