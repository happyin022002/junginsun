/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryByLocationLessorListDataRSQL.java
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

public class ChassisMgsetInventoryDBDAOsearchMGSInventoryByLocationLessorListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090915 2080 start
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchMGSInventoryByLocationLessorListDataRSQL(){
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
		params.put("s_crnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s2_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_group1_val",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryByLocationLessorListDataRSQL").append("\n"); 
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
		query.append("    A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("    A.AGMT_LSTM_CD," ).append("\n"); 
		query.append("    A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("    B.VNDR_LGL_ENG_NM VNDR_ABBR_NM," ).append("\n"); 
		query.append("    E.CHSS_NO," ).append("\n"); 
		query.append("    E.CNTR_NO," ).append("\n"); 
		query.append("    D.LCC_CD," ).append("\n"); 
		query.append("    C.SCC_CD," ).append("\n"); 
		query.append("    A.CRNT_YD_CD," ).append("\n"); 
		query.append("    NVL(F.CHSS_MVMT_STS_CD , G.CNMV_STS_CD) MVMT," ).append("\n"); 
		query.append("    NVL(F.CHSS_MVMT_DT , G.CNMV_DT) MVMT_DATE," ).append("\n"); 
		query.append("    NVL(TRUNC(SYSDATE - F.CHSS_MVMT_DT,0) , TRUNC(SYSDATE - CNMV_DT,0)) LSDAYS" ).append("\n"); 
		query.append("FROM    " ).append("\n"); 
		query.append("	CGM_EQUIPMENT A," ).append("\n"); 
		query.append("	MDM_VENDOR B," ).append("\n"); 
		query.append("	CGM_AGREEMENT BB," ).append("\n"); 
		query.append("    MDM_LOCATION C," ).append("\n"); 
		query.append("    MDM_EQ_ORZ_CHT D," ).append("\n"); 
		query.append("CGM_EQ_ATCH_DTCH_HIS E," ).append("\n"); 
		query.append("CGM_EQUIPMENT F," ).append("\n"); 
		query.append("MST_CONTAINER G" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = B.VNDR_SEQ (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND A.AGMT_OFC_CTY_CD = BB.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND A.AGMT_SEQ = BB.AGMT_SEQ" ).append("\n"); 
		query.append("    AND A.AGMT_VER_NO =  BB.AGMT_VER_NO" ).append("\n"); 
		query.append("    AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("    AND (A.AGMT_OFC_CTY_CD  || A.AGMT_SEQ ) = (BB.AGMT_OFC_CTY_CD  || BB.AGMT_SEQ )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND A.CRNT_LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("    AND C.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("    AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("    AND D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${s_location} == 'RCC')" ).append("\n"); 
		query.append("	AND D.RCC_CD = @[s_crnt_loc_cd]" ).append("\n"); 
		query.append("#elseif (${s_location} == 'LCC')" ).append("\n"); 
		query.append("	AND D.LCC_CD = @[s_crnt_loc_cd]" ).append("\n"); 
		query.append("#elseif (${s_location} == 'SCC')" ).append("\n"); 
		query.append("	AND D.SCC_CD = @[s_crnt_loc_cd]" ).append("\n"); 
		query.append("#elseif (${s_location} == 'ALL')" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("	AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("	AND A.EQ_NO = E.EQ_NO(+)" ).append("\n"); 
		query.append("AND E.DTCH_DT(+) = TO_DATE('88881231','YYYYMMDD')" ).append("\n"); 
		query.append("AND E.CHSS_NO = F.EQ_NO(+)" ).append("\n"); 
		query.append("AND E.CNTR_NO = G.CNTR_NO(+)" ).append("\n"); 
		query.append("                                       " ).append("\n"); 
		query.append("#if (${s_crnt_yd_cd} != '')" ).append("\n"); 
		query.append("	AND A.CRNT_YD_CD IN ($s_crnt_yd_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_vndr_seq} != '')" ).append("\n"); 
		query.append("	AND BB.VNDR_SEQ IN ($s_vndr_seq) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("#if (${s3_gtotal} == 'GTOTAL')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND A.VNDR_SEQ = @[s_group1_val]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s2_group1} != 'SubSum')" ).append("\n"); 
		query.append("#if (${s_location} == 'RCC')" ).append("\n"); 
		query.append("#if (${s2_loc_cd} != '')" ).append("\n"); 
		query.append("    AND D.RCC_CD = @[s2_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${s_location} == 'LCC')" ).append("\n"); 
		query.append("#if (${s2_loc_cd} != '')" ).append("\n"); 
		query.append("    AND D.LCC_CD = @[s2_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${s_location} == 'SCC')" ).append("\n"); 
		query.append("#if (${s2_loc_cd} != '')" ).append("\n"); 
		query.append("    AND D.SCC_CD = @[s2_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${s_location} == 'ALL')" ).append("\n"); 
		query.append("#if (${s2_loc_cd} != '')" ).append("\n"); 
		query.append("    AND A.CRNT_LOC_CD = @[s2_loc_cd]" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s2_eq_tpsz_cd} != '' && ${s2_eq_tpsz_cd} != 'TOTAL')" ).append("\n"); 
		query.append("AND A.EQ_TPSZ_CD = @[s2_eq_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}