/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TariffMgtDBDAOsearchDisposalTariffRegionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.11
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffMgtDBDAOsearchDisposalTariffRegionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 분기별 매각기준 가격정보 현황을 조회합니다.
	  * 
	  * 2012.09.11 조경완 [CHM-201220025-01] Location By 조회 조건 추가
	  * </pre>
	  */
	public TariffMgtDBDAOsearchDisposalTariffRegionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_trf_eff_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_trf_eff_qtr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.integration").append("\n"); 
		query.append("FileName : TariffMgtDBDAOsearchDisposalTariffRegionListRSQL").append("\n"); 
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
		query.append("MDF.TRF_EFF_YR," ).append("\n"); 
		query.append("MDF.TRF_EFF_QTR_NO," ).append("\n"); 
		query.append("MDF.MNR_DISP_TRF_SEQ," ).append("\n"); 
		query.append("MDF.EQ_KND_CD," ).append("\n"); 
		query.append("MDF.EQ_TPSZ_CD," ).append("\n"); 
		query.append("MDF.LOC_CD," ).append("\n"); 
		query.append("MDF.CURR_CD," ).append("\n"); 
		query.append("MDF.MNR_DISP_TRF_AMT," ).append("\n"); 
		query.append("MDF.MNR_TRF_RMK," ).append("\n"); 
		query.append("MDF.CRE_OFC_CD," ).append("\n"); 
		query.append("MDF.CRE_USR_ID," ).append("\n"); 
		query.append("MDF.CRE_DT," ).append("\n"); 
		query.append("MDF.UPD_USR_ID," ).append("\n"); 
		query.append("MDF.UPD_DT," ).append("\n"); 
		query.append("MDF.TRF_EFF_YR||MDF.TRF_EFF_QTR_NO||MDF.EQ_KND_CD||MDF.LOC_CD||MDF.EQ_TPSZ_CD AS COMPLEX_PK" ).append("\n"); 
		query.append("FROM MNR_DISP_TRF MDF," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT ML.LOC_CD," ).append("\n"); 
		query.append("ML.RGN_CD," ).append("\n"); 
		query.append("ML.SCC_CD," ).append("\n"); 
		query.append("ML.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("MEOC.LCC_CD," ).append("\n"); 
		query.append("MEOC.ECC_CD," ).append("\n"); 
		query.append("MEOC.RCC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION ML," ).append("\n"); 
		query.append("MDM_EQ_ORZ_CHT MEOC" ).append("\n"); 
		query.append("WHERE ML.SCC_CD = MEOC.SCC_CD" ).append("\n"); 
		query.append("#if (${p_loc_cd} != '')" ).append("\n"); 
		query.append("#if(${p_loc_tp} == 'RCC')" ).append("\n"); 
		query.append("AND MEOC.RCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("#elseif (${p_loc_tp} == 'LCC')" ).append("\n"); 
		query.append("AND MEOC.LCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND MEOC.SCC_CD = @[p_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") LOC" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND MDF.LOC_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("#if (${p_trf_eff_yr} != '')" ).append("\n"); 
		query.append("AND MDF.TRF_EFF_YR = @[p_trf_eff_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_trf_eff_qtr_no} != '')" ).append("\n"); 
		query.append("AND MDF.TRF_EFF_QTR_NO = @[p_trf_eff_qtr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_eq_knd_cd} != '')" ).append("\n"); 
		query.append("AND MDF.EQ_KND_CD = @[p_eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}