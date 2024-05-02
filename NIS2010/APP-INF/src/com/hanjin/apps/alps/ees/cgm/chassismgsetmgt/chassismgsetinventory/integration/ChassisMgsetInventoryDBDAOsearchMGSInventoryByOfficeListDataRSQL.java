/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryByOfficeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.11.25 조재성
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

public class ChassisMgsetInventoryDBDAOsearchMGSInventoryByOfficeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090911 2079 list
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchMGSInventoryByOfficeListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s1_inq_fm_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s1_inq_to_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_group1_val",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryByOfficeListDataRSQL").append("\n"); 
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
		query.append("DISTINCT A.EQ_NO," ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("A.AGMT_LSTM_CD," ).append("\n"); 
		query.append("A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("B.VNDR_ABBR_NM," ).append("\n"); 
		query.append("E.CHSS_NO," ).append("\n"); 
		query.append("E.CNTR_NO," ).append("\n"); 
		query.append("D.LCC_CD," ).append("\n"); 
		query.append("C.SCC_CD," ).append("\n"); 
		query.append("A.CRNT_YD_CD," ).append("\n"); 
		query.append("DECODE (A.EQ_TPSZ_CD, 'UMG', F.CHSS_MVMT_STS_CD , 'CLG', G.CNMV_STS_CD,'' ) MVMT," ).append("\n"); 
		query.append("DECODE (A.EQ_TPSZ_CD, 'UMG', F.CHSS_MVMT_DT , 'CLG', G.CNMV_DT,'' ) MVMT_DATE," ).append("\n"); 
		query.append("DECODE (A.EQ_TPSZ_CD, 'UMG', TRUNC(SYSDATE - F.CHSS_MVMT_DT,0) , 'CLG', TRUNC(SYSDATE - CNMV_DT,0),  G.CNMV_DT,'' ) LSDAYS" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CGM_EQUIPMENT A," ).append("\n"); 
		query.append("CGM_EQ_STS_HIS BB," ).append("\n"); 
		query.append("MDM_VENDOR B," ).append("\n"); 
		query.append("MDM_LOCATION C," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT D," ).append("\n"); 
		query.append("CGM_EQ_ATCH_DTCH_HIS E," ).append("\n"); 
		query.append("CGM_EQUIPMENT F," ).append("\n"); 
		query.append("MST_CONTAINER G" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = B.VNDR_SEQ (+)" ).append("\n"); 
		query.append("AND A.EQ_NO = BB.EQ_NO" ).append("\n"); 
		query.append("-- AND A.EQ_STS_SEQ = BB.EQ_STS_SEQ" ).append("\n"); 
		query.append("AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("AND BB.EQ_ASET_STS_CD = 'LSI'" ).append("\n"); 
		query.append("AND A.CRNT_LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("AND C.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${s_location} == 'RCC')" ).append("\n"); 
		query.append("AND D.RCC_CD = @[s_crnt_loc_cd]" ).append("\n"); 
		query.append("#elseif (${s_location} == 'LCC')" ).append("\n"); 
		query.append("AND D.LCC_CD = @[s_crnt_loc_cd]" ).append("\n"); 
		query.append("#elseif (${s_location} == 'SCC')" ).append("\n"); 
		query.append("AND D.SCC_CD = @[s_crnt_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.EQ_NO = E.EQ_NO(+)" ).append("\n"); 
		query.append("AND E.DTCH_DT(+) = TO_DATE('88881231','YYYYMMDD')" ).append("\n"); 
		query.append("AND E.CHSS_NO = F.EQ_NO(+)" ).append("\n"); 
		query.append("AND E.CNTR_NO = G.CNTR_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s1_inq_fm_dys} != '' && ${s1_inq_to_dys} != '')" ).append("\n"); 
		query.append("AND BB.STS_EVNT_DT BETWEEN TO_DATE(@[s1_inq_fm_dys], 'YYYYMMDD') AND TO_DATE(@[s1_inq_to_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("#elseif (${s1_inq_fm_dys} != '' && ${s1_inq_to_dys} == '')" ).append("\n"); 
		query.append("AND BB.STS_EVNT_DT >= TO_DATE(@[s1_inq_fm_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("#elseif (${s1_inq_fm_dys} == '' && ${s1_inq_to_dys} != '')" ).append("\n"); 
		query.append("AND BB.STS_EVNT_DT <= TO_DATE(@[s1_inq_to_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crnt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND B.STS_EVNT_OFC_CD IN ($crnt_ofc_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BB.STS_EVNT_DT =" ).append("\n"); 
		query.append("(	SELECT" ).append("\n"); 
		query.append("MAX(t2.STS_EVNT_DT)" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT t1, CGM_EQ_STS_HIS t2" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("t1.EQ_NO = t2.EQ_NO" ).append("\n"); 
		query.append("AND t1.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND t1.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("AND t2.EQ_ASET_STS_CD = 'LSI'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s1_inq_fm_dys} != '' && ${s1_inq_to_dys} != '')" ).append("\n"); 
		query.append("AND t2.STS_EVNT_DT BETWEEN TO_DATE(@[s1_inq_fm_dys], 'YYYYMMDD') AND TO_DATE(@[s1_inq_to_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("#elseif (${s1_inq_fm_dys} != '' && ${s1_inq_to_dys} == '')" ).append("\n"); 
		query.append("AND t2.STS_EVNT_DT >= TO_DATE(@[s1_inq_fm_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("#elseif (${s1_inq_fm_dys} == '' && ${s1_inq_to_dys} != '')" ).append("\n"); 
		query.append("AND t2.STS_EVNT_DT <= TO_DATE(@[s1_inq_to_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crnt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND t2.STS_EVNT_OFC_CD IN ($crnt_ofc_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND t1.EQ_NO = A.EQ_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s3_gtotal} == 'GTOTAL')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND BB.STS_EVNT_OFC_CD = @[s_group1_val]" ).append("\n"); 
		query.append("#if (${s2_group1} != 'SubSum')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s2_eq_tpsz_cd} == 'UMG')" ).append("\n"); 
		query.append("AND A.EQ_TPSZ_CD = 'UMG'" ).append("\n"); 
		query.append("#elseif(${s2_eq_tpsz_cd} == 'CLG')" ).append("\n"); 
		query.append("AND A.EQ_TPSZ_CD = 'CLG'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}