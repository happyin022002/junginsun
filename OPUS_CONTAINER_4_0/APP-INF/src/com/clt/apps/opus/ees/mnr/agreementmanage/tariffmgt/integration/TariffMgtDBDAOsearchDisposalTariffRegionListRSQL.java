/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffMgtDBDAOsearchDisposalTariffRegionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.29
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.10.29 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
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
		params.put("p_trf_eff_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_trf_eff_qtr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration").append("\n"); 
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
		query.append("SELECT  TRF_EFF_YR, TRF_EFF_QTR_NO, MNR_DISP_TRF_SEQ, EQ_KND_CD, " ).append("\n"); 
		query.append("        EQ_TPSZ_CD, LOC_CD, CURR_CD, MNR_DISP_TRF_AMT, MNR_TRF_RMK, " ).append("\n"); 
		query.append("        CRE_OFC_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT," ).append("\n"); 
		query.append("		TRF_EFF_YR||TRF_EFF_QTR_NO||EQ_KND_CD||LOC_CD||EQ_TPSZ_CD AS COMPLEX_PK		" ).append("\n"); 
		query.append("FROM    MNR_DISP_TRF" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("#if (${p_trf_eff_yr} != '') " ).append("\n"); 
		query.append("AND		TRF_EFF_YR = @[p_trf_eff_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_trf_eff_qtr_no} != '') " ).append("\n"); 
		query.append("AND     TRF_EFF_QTR_NO = @[p_trf_eff_qtr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_eq_knd_cd} != '') " ).append("\n"); 
		query.append("AND     EQ_KND_CD = @[p_eq_knd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}