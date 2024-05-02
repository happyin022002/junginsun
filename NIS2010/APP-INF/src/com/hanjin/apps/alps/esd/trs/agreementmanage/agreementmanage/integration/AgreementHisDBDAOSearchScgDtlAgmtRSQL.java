/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AgreementHisDBDAOSearchScgDtlAgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementHisDBDAOSearchScgDtlAgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Inquiry Surcharge 조회
	  * </pre>
	  */
	public AgreementHisDBDAOSearchScgDtlAgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_trsp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rt_tp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("way",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_bdl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("basic_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("effective_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_sz",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementHisDBDAOSearchScgDtlAgmtRSQL").append("\n"); 
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
		query.append("TRSP_AGMT_EQ_TP_CD||TRSP_AGMT_EQ_SZ_CD AS EQ_TP_SZ" ).append("\n"); 
		query.append(",@[basic_rt] BZC_RT" ).append("\n"); 
		query.append("#if (${effective_date} == '')" ).append("\n"); 
		query.append(",TRS_GET_AGMT_SCG_CALC_FNC (" ).append("\n"); 
		query.append("@[rail_svc_tp_cd] ,'FU' ,@[way],@[agmt_trsp_tp_cd] , @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append(",@[trsp_agmt_seq]  ,@[trsp_agmt_rt_tp_ser_no], @[vndr_seq] ,nvl(globaldate_pkg.time_local_ofc_fnc(@[ctrt_ofc_cd]),sysdate),@[eq_knd_cd]" ).append("\n"); 
		query.append(",TRSP_AGMT_EQ_TP_CD||TRSP_AGMT_EQ_SZ_CD ,@[cgo_tp_cd] ,@[fm_nod_cd] ,@[via_nod_cd] ,@[dor_nod_cd]" ).append("\n"); 
		query.append(",@[to_nod_cd] , @[trsp_agmt_bdl_qty] , @[wgt_meas_ut_cd] , NULL, @[basic_rt]" ).append("\n"); 
		query.append(",@[curr_cd],NULL,'N'" ).append("\n"); 
		query.append(") FUEL_SCG_RT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",TRS_GET_AGMT_SCG_CALC_FNC (" ).append("\n"); 
		query.append("@[rail_svc_tp_cd] ,'FU' ,@[way],@[agmt_trsp_tp_cd] , @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append(",@[trsp_agmt_seq]  ,@[trsp_agmt_rt_tp_ser_no], @[vndr_seq] ,nvl(globaldate_pkg.time_local_ofc_fnc(@[ctrt_ofc_cd]),TO_DATE(@[effective_date],'YYYY-MM-DD')),@[eq_knd_cd]" ).append("\n"); 
		query.append(",TRSP_AGMT_EQ_TP_CD||TRSP_AGMT_EQ_SZ_CD ,@[cgo_tp_cd] ,@[fm_nod_cd] ,@[via_nod_cd] ,@[dor_nod_cd]" ).append("\n"); 
		query.append(",@[to_nod_cd] , @[trsp_agmt_bdl_qty] , @[wgt_meas_ut_cd] , NULL, @[basic_rt]" ).append("\n"); 
		query.append(",@[curr_cd],NULL,'N'" ).append("\n"); 
		query.append(") FUEL_SCG_RT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${effective_date} == '')" ).append("\n"); 
		query.append(",TRS_GET_AGMT_SCG_CALC_FNC (" ).append("\n"); 
		query.append("@[rail_svc_tp_cd] ,'OW' ,@[way],@[agmt_trsp_tp_cd] , @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append(",@[trsp_agmt_seq]  ,@[trsp_agmt_rt_tp_ser_no], @[vndr_seq] ,nvl(globaldate_pkg.time_local_ofc_fnc(@[ctrt_ofc_cd]),sysdate),@[eq_knd_cd]" ).append("\n"); 
		query.append(",TRSP_AGMT_EQ_TP_CD||TRSP_AGMT_EQ_SZ_CD ,@[cgo_tp_cd] ,@[fm_nod_cd] ,@[via_nod_cd] ,@[dor_nod_cd]" ).append("\n"); 
		query.append(",@[to_nod_cd] , @[trsp_agmt_bdl_qty] , @[wgt_meas_ut_cd] , 999999, @[basic_rt]" ).append("\n"); 
		query.append(",@[curr_cd],NULL,'N'" ).append("\n"); 
		query.append(") OW_SCG_RT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",TRS_GET_AGMT_SCG_CALC_FNC (" ).append("\n"); 
		query.append("@[rail_svc_tp_cd] ,'OW' ,@[way],@[agmt_trsp_tp_cd] , @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append(",@[trsp_agmt_seq]  ,@[trsp_agmt_rt_tp_ser_no], @[vndr_seq] ,nvl(globaldate_pkg.time_local_ofc_fnc(@[ctrt_ofc_cd]),TO_DATE(@[effective_date],'YYYY-MM-DD')),@[eq_knd_cd]" ).append("\n"); 
		query.append(",TRSP_AGMT_EQ_TP_CD||TRSP_AGMT_EQ_SZ_CD ,@[cgo_tp_cd] ,@[fm_nod_cd] ,@[via_nod_cd] ,@[dor_nod_cd]" ).append("\n"); 
		query.append(",@[to_nod_cd] , @[trsp_agmt_bdl_qty] , @[wgt_meas_ut_cd] , 999999, @[basic_rt]" ).append("\n"); 
		query.append(",@[curr_cd],NULL,'N'" ).append("\n"); 
		query.append(") OW_SCG_RT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${effective_date} == '')" ).append("\n"); 
		query.append(",TRS_GET_AGMT_SCG_CALC_FNC (" ).append("\n"); 
		query.append("@[rail_svc_tp_cd] ,'HZ' ,@[way],@[agmt_trsp_tp_cd] , @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append(",@[trsp_agmt_seq]  ,@[trsp_agmt_rt_tp_ser_no], @[vndr_seq] ,nvl(globaldate_pkg.time_local_ofc_fnc(@[ctrt_ofc_cd]),sysdate),@[eq_knd_cd]" ).append("\n"); 
		query.append(",TRSP_AGMT_EQ_TP_CD||TRSP_AGMT_EQ_SZ_CD ,@[cgo_tp_cd] ,@[fm_nod_cd] ,@[via_nod_cd] ,@[dor_nod_cd]" ).append("\n"); 
		query.append(",@[to_nod_cd] , @[trsp_agmt_bdl_qty] , @[wgt_meas_ut_cd] , NULL, @[basic_rt]" ).append("\n"); 
		query.append(",@[curr_cd],'DG','N'" ).append("\n"); 
		query.append(") DG_SCG_RT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",TRS_GET_AGMT_SCG_CALC_FNC (" ).append("\n"); 
		query.append("@[rail_svc_tp_cd] ,'HZ' ,@[way],@[agmt_trsp_tp_cd] , @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append(",@[trsp_agmt_seq]  ,@[trsp_agmt_rt_tp_ser_no], @[vndr_seq] ,nvl(globaldate_pkg.time_local_ofc_fnc(@[ctrt_ofc_cd]),TO_DATE(@[effective_date],'YYYY-MM-DD')),@[eq_knd_cd]" ).append("\n"); 
		query.append(",TRSP_AGMT_EQ_TP_CD||TRSP_AGMT_EQ_SZ_CD ,@[cgo_tp_cd] ,@[fm_nod_cd] ,@[via_nod_cd] ,@[dor_nod_cd]" ).append("\n"); 
		query.append(",@[to_nod_cd] , @[trsp_agmt_bdl_qty] , @[wgt_meas_ut_cd] , NULL, @[basic_rt]" ).append("\n"); 
		query.append(",@[curr_cd],'DG','N'" ).append("\n"); 
		query.append(") DG_SCG_RT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${effective_date} == '')" ).append("\n"); 
		query.append(",TRS_GET_AGMT_SCG_CALC_FNC (" ).append("\n"); 
		query.append("@[rail_svc_tp_cd] ,'TL' ,@[way],@[agmt_trsp_tp_cd] , @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append(",@[trsp_agmt_seq]  ,@[trsp_agmt_rt_tp_ser_no], @[vndr_seq] ,nvl(globaldate_pkg.time_local_ofc_fnc(@[ctrt_ofc_cd]),sysdate),@[eq_knd_cd]" ).append("\n"); 
		query.append(",TRSP_AGMT_EQ_TP_CD||TRSP_AGMT_EQ_SZ_CD ,@[cgo_tp_cd] ,@[fm_nod_cd] ,@[via_nod_cd] ,@[dor_nod_cd]" ).append("\n"); 
		query.append(",@[to_nod_cd] , @[trsp_agmt_bdl_qty] , @[wgt_meas_ut_cd] , NULL, @[basic_rt]" ).append("\n"); 
		query.append(",@[curr_cd],NULL,'N'" ).append("\n"); 
		query.append(") TTL_SCG_RT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",TRS_GET_AGMT_SCG_CALC_FNC (" ).append("\n"); 
		query.append("@[rail_svc_tp_cd] ,'TL' ,@[way],@[agmt_trsp_tp_cd] , @[trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append(",@[trsp_agmt_seq]  ,@[trsp_agmt_rt_tp_ser_no], @[vndr_seq] ,nvl(globaldate_pkg.time_local_ofc_fnc(@[ctrt_ofc_cd]),TO_DATE(@[effective_date],'YYYY-MM-DD')),@[eq_knd_cd]" ).append("\n"); 
		query.append(",TRSP_AGMT_EQ_TP_CD||TRSP_AGMT_EQ_SZ_CD ,@[cgo_tp_cd] ,@[fm_nod_cd] ,@[via_nod_cd] ,@[dor_nod_cd]" ).append("\n"); 
		query.append(",@[to_nod_cd] , @[trsp_agmt_bdl_qty] , @[wgt_meas_ut_cd] , NULL, @[basic_rt]" ).append("\n"); 
		query.append(",@[curr_cd],NULL,'N'" ).append("\n"); 
		query.append(") TTL_SCG_RT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM TRS_AGMT_EQ_TP_RULE T" ).append("\n"); 
		query.append("WHERE TRSP_AGMT_RULE_TP_CD = 'X'" ).append("\n"); 
		query.append("AND TRSP_AGMT_EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_tp} != 'AL')" ).append("\n"); 
		query.append("AND TRSP_AGMT_EQ_TP_CD = @[eq_tp]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_sz} != 'AL')" ).append("\n"); 
		query.append("#if (${eq_knd_cd} != 'G')" ).append("\n"); 
		query.append("AND TRSP_AGMT_EQ_SZ_CD = @[eq_sz]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}