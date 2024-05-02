/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationReportDBDAODeleteInquiryByDeleteDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationReportDBDAODeleteInquiryByDeleteDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationReportDBDAODeleteInquiryByDeleteDateRSQL
	  * </pre>
	  */
	public ChargeCalculationReportDBDAODeleteInquiryByDeleteDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spec_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration").append("\n"); 
		query.append("FileName : ChargeCalculationReportDBDAODeleteInquiryByDeleteDateRSQL").append("\n"); 
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
		query.append("select  decode(@[grp_flg], 'R', T2.OFC_RHQ_CD, T2.OFC_CD) 	as OFC_CD" ).append("\n"); 
		query.append(",T1.DMDT_CHG_DELT_RSN_CD                          	as DELT_RSN_CD" ).append("\n"); 
		query.append(",T1.DMDT_CHG_DELT_SPEC_RSN_CD                          	as DELT_SPEC_RSN_CD" ).append("\n"); 
		query.append(",decode(T1.DMDT_CHG_DELT_RSN_CD, 'OTH', 'Other', T3.INTG_CD_VAL_DP_DESC) as DELT_RSN_DESC" ).append("\n"); 
		query.append(",T3.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append(",sum(decode(T2.DMDT_TRF_CD, 'DMIF', 1, 0))    		as DMIF_SUM" ).append("\n"); 
		query.append(",sum(decode(T2.DMDT_TRF_CD, 'DMOF', 1, 0))    		as DMOF_SUM" ).append("\n"); 
		query.append(",sum(decode(T2.DMDT_TRF_CD, 'DTIC', 1, 0))    		as DTIC_SUM" ).append("\n"); 
		query.append(",sum(decode(T2.DMDT_TRF_CD, 'DTOC', 1, 0))    		as DTOC_SUM" ).append("\n"); 
		query.append(",sum(decode(T2.DMDT_TRF_CD, 'CTIC', 1, 0))    		as CTIC_SUM" ).append("\n"); 
		query.append(",sum(decode(T2.DMDT_TRF_CD, 'CTOC', 1, 0))    		as CTOC_SUM" ).append("\n"); 
		query.append(",count(1) 											as TTL_CNTR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("from  DMT_CHG_DELT_RQST_APRO	T1" ).append("\n"); 
		query.append(",DMT_CHG_CALC            T2" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL			T3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("where  T1.DMDT_DELT_RQST_STS_CD in ('A', 'B', 'Q', 'H')	--// A:Approval(기존코드값 - TO-BE 사용되지 않음), B:BB Approval, Q:RHQ Approval, H:HO Approval" ).append("\n"); 
		query.append("and  T1.UPD_DT between to_date(replace(@[fm_dt], '-', ''), 'YYYYMMDD') and to_date(replace(@[to_dt], '-', ''), 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("and  T1.SYS_AREA_GRP_ID      = T2.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("and  T1.CNTR_NO              = T2.CNTR_NO" ).append("\n"); 
		query.append("and  T1.CNTR_CYC_NO          = T2.CNTR_CYC_NO" ).append("\n"); 
		query.append("and  T1.DMDT_TRF_CD          = T2.DMDT_TRF_CD" ).append("\n"); 
		query.append("and  T1.DMDT_CHG_LOC_DIV_CD  = T2.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("and  T1.CHG_SEQ              = T2.CHG_SEQ" ).append("\n"); 
		query.append("and  T1.CHG_OFC_CD           = T2.OFC_CD" ).append("\n"); 
		query.append("and  T1.DELT_SEQ             =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select  max(DELT_SEQ)" ).append("\n"); 
		query.append("from  DMT_CHG_DELT_RQST_APRO" ).append("\n"); 
		query.append("where  SYS_AREA_GRP_ID 	 = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("and  CNTR_NO              = T1.CNTR_NO" ).append("\n"); 
		query.append("and  CNTR_CYC_NO          = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("and  DMDT_TRF_CD          = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("and  DMDT_CHG_LOC_DIV_CD  = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("and  CHG_SEQ              = T1.CHG_SEQ" ).append("\n"); 
		query.append("and  CHG_OFC_CD           = T1.CHG_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("and  T2.DMDT_CHG_STS_CD      = 'D'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_flg} == 'O')" ).append("\n"); 
		query.append("and  T2.OFC_CD in" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#foreach( $an_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("#if($velocityCount < $ofc_cd_list.size()) '$an_ofc', #else '$an_ofc' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${ofc_flg} == 'R' && ${ofc_cd} != 'All')" ).append("\n"); 
		query.append("and  T2.OFC_RHQ_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${del_cd} != 'All')" ).append("\n"); 
		query.append("and  T1.DMDT_CHG_DELT_RSN_CD = @[del_cd]" ).append("\n"); 
		query.append("#if (${spec_cd} != 'All')" ).append("\n"); 
		query.append("and  T1.DMDT_CHG_DELT_SPEC_RSN_CD = @[spec_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and  T2.DMDT_CHG_LOC_DIV_CD <> 'SZP'	-- 2010/03/19 추가" ).append("\n"); 
		query.append("and  T3.INTG_CD_ID           = 'CD01965'" ).append("\n"); 
		query.append("and  T1.DMDT_CHG_DELT_RSN_CD = T3.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("group by decode(@[grp_flg], 'R', T2.OFC_RHQ_CD, T2.OFC_CD)" ).append("\n"); 
		query.append(",T1.DMDT_CHG_DELT_RSN_CD, T1.DMDT_CHG_DELT_SPEC_RSN_CD" ).append("\n"); 
		query.append(",decode(T1.DMDT_CHG_DELT_RSN_CD, 'OTH', 'Other', T3.INTG_CD_VAL_DP_DESC)" ).append("\n"); 
		query.append(",T3.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("order by 1" ).append("\n"); 
		query.append(",T3.INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}