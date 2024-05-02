/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChargeCalculationReportDBDAODeleteInquiryByOfficeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationReportDBDAODeleteInquiryByOfficeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Delete Charge를 Summary조회한다.
	  * </pre>
	  */
	public ChargeCalculationReportDBDAODeleteInquiryByOfficeVORSQL(){
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
		params.put("grp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration").append("\n"); 
		query.append("FileName : ChargeCalculationReportDBDAODeleteInquiryByOfficeVORSQL").append("\n"); 
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
		query.append("SELECT		" ).append("\n"); 
		query.append("		#if (${ofc_flg} == 'O' && ${dt_flg} == 'F')" ).append("\n"); 
		query.append("			/*+ ORDERED INDEX(C XAK2DMT_CHG_CALC)*/" ).append("\n"); 
		query.append("		#elseif (${ofc_flg} == 'O' && ${dt_flg} != 'F')" ).append("\n"); 
		query.append("			/*+ ORDERED INDEX(C XAK6DMT_CHG_CALC)*/" ).append("\n"); 
		query.append("		#elseif (${ofc_flg} == 'R' && ${dt_flg} == 'F')" ).append("\n"); 
		query.append("			/*+ ORDERED INDEX(C XAK9DMT_CHG_CALC)*/" ).append("\n"); 
		query.append("		#elseif (${ofc_flg} == 'R' && ${dt_flg} != 'F')" ).append("\n"); 
		query.append("			/*+ ORDERED INDEX(C XAK15DMT_CHG_CALC_CHG_CALC)*/" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		DECODE(@[grp_flg], 'R', C.OFC_RHQ_CD, C.OFC_CD) AS OFC_CD," ).append("\n"); 
		query.append("		C.DMDT_CHG_DELT_RSN_CD AS DELT_RSN_CD," ).append("\n"); 
		query.append("		DECODE(C.DMDT_CHG_DELT_RSN_CD, 'OTH', 'Other', R.INTG_CD_VAL_DP_DESC) AS DELT_RSN_DESC,		" ).append("\n"); 
		query.append("		R.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("		SUM( DECODE( C.DMDT_TRF_CD, 'DMIF', 1, 0 ) ) DMIF_SUM," ).append("\n"); 
		query.append("		SUM( DECODE( C.DMDT_TRF_CD, 'DMOF', 1, 0 ) ) DMOF_SUM," ).append("\n"); 
		query.append("		SUM( DECODE( C.DMDT_TRF_CD, 'DTIC', 1, 0 ) ) DTIC_SUM," ).append("\n"); 
		query.append("		SUM( DECODE( C.DMDT_TRF_CD, 'DTOC', 1, 0 ) ) DTOC_SUM," ).append("\n"); 
		query.append("		SUM( DECODE( C.DMDT_TRF_CD, 'CTIC', 1, 0 ) ) CTIC_SUM," ).append("\n"); 
		query.append("		SUM( DECODE( C.DMDT_TRF_CD, 'CTOC', 1, 0 ) ) CTOC_SUM," ).append("\n"); 
		query.append("		COUNT(*) TTL_CNTR" ).append("\n"); 
		query.append("FROM	DMT_CHG_CALC	C," ).append("\n"); 
		query.append("		COM_INTG_CD_DTL	R" ).append("\n"); 
		query.append("WHERE	C.DMDT_CHG_STS_CD = 'D'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dt_flg} == 'F')" ).append("\n"); 
		query.append("AND		C.FM_MVMT_DT BETWEEN TO_DATE(REPLACE(@[fm_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND		C.UPD_DT BETWEEN TO_DATE(REPLACE(@[fm_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_flg} == 'O')" ).append("\n"); 
		query.append("AND		C.OFC_CD	IN (" ).append("\n"); 
		query.append("		#foreach( $an_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $ofc_cd_list.size()) '$an_ofc', #else '$an_ofc' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#elseif (${ofc_flg} == 'R' && ${ofc_cd} != 'All') " ).append("\n"); 
		query.append("AND		C.OFC_RHQ_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${del_cd} != 'All')" ).append("\n"); 
		query.append("AND		C.DMDT_CHG_DELT_RSN_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		C.DMDT_CHG_LOC_DIV_CD <> 'SZP'	-- 2010/03/19 추가" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		R.INTG_CD_ID = 'CD01965'" ).append("\n"); 
		query.append("AND		C.DMDT_CHG_DELT_RSN_CD  = R.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY	 DECODE(@[grp_flg], 'R', C.OFC_RHQ_CD, C.OFC_CD)" ).append("\n"); 
		query.append("			,C.DMDT_CHG_DELT_RSN_CD" ).append("\n"); 
		query.append("			,DECODE(C.DMDT_CHG_DELT_RSN_CD, 'OTH', 'Other', R.INTG_CD_VAL_DP_DESC)" ).append("\n"); 
		query.append("			,R.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("ORDER BY	 1" ).append("\n"); 
		query.append("			,R.INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}