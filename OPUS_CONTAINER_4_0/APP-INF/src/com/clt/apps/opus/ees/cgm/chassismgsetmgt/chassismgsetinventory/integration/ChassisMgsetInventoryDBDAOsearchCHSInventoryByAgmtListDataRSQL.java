/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchCHSInventoryByAgmtListDataRSQL.java
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

public class ChassisMgsetInventoryDBDAOsearchCHSInventoryByAgmtListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090729 1098 popup add
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchCHSInventoryByAgmtListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchCHSInventoryByAgmtListDataRSQL").append("\n"); 
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
		query.append("	CGM_AGREEMENT t2," ).append("\n"); 
		query.append("    MDM_VENDOR B," ).append("\n"); 
		query.append("    MDM_LOCATION C," ).append("\n"); 
		query.append("    MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("      A.AGMT_OFC_CTY_CD = t2.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("      AND A.AGMT_SEQ = t2.AGMT_SEQ" ).append("\n"); 
		query.append("	  AND A.AGMT_VER_NO = t2.AGMT_VER_NO" ).append("\n"); 
		query.append("      AND (A.AGMT_OFC_CTY_CD  || A.AGMT_SEQ ) = (t2.AGMT_OFC_CTY_CD  || t2.AGMT_SEQ )" ).append("\n"); 
		query.append("	  AND A.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("	  AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("      AND A.VNDR_SEQ = B.VNDR_SEQ (+)" ).append("\n"); 
		query.append("      AND A.CRNT_LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("      AND C.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  #if ( ${location} == 'RCC' )" ).append("\n"); 
		query.append("	  AND  D.RCC_CD = (@[crnt_loc_cd])" ).append("\n"); 
		query.append("	  #elseif ( ${location} == 'LCC' )" ).append("\n"); 
		query.append("	  AND  D.LCC_CD = (@[crnt_loc_cd])" ).append("\n"); 
		query.append("	  #elseif ( ${location} == 'SCC' )" ).append("\n"); 
		query.append("	  AND  D.SCC_CD = (@[crnt_loc_cd])" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("      AND D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("	  AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crnt_yd_cd} != '')" ).append("\n"); 
		query.append("	AND A.CRNT_YD_CD IN ($crnt_yd_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${include_np} != 'Y')" ).append("\n"); 
		query.append("	AND A.AGMT_LSTM_CD <>'NP'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_no} != '')" ).append("\n"); 
		query.append("	AND (t2.AGMT_OFC_CTY_CD,t2.AGMT_SEQ ) IN ($agmt_no) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("	AND t2.VNDR_SEQ IN ($vndr_seq)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("	AND A.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${s3_gtotal} == 'GTOTAL' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${group_value1} != '')" ).append("\n"); 
		query.append("	AND A.CRNT_LOC_CD = @[group_value1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s2_group1} == 'SubSum')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${group_value2} != '')" ).append("\n"); 
		query.append("  AND t2.AGMT_OFC_CTY_CD || LPAD(t2.AGMT_SEQ, 6, '0') = @[group_value2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${group_value3} != '')" ).append("\n"); 
		query.append("	AND t2.VNDR_SEQ = SUBSTR(@[group_value3], INSTR(@[group_value3],'(')+1, 6)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}