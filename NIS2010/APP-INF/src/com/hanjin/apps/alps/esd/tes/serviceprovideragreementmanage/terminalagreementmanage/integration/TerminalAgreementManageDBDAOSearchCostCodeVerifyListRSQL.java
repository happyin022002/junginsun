/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchCostCodeVerifyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.09.08 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOSearchCostCodeVerifyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cost Code Verify Flag 조회
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchCostCodeVerifyListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration ").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchCostCodeVerifyListRSQL").append("\n"); 
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
		query.append("SELECT	com_auto_calc_flg" ).append("\n"); 
		query.append("||	'|'	||	tml_thrp_cost_cd_flg" ).append("\n"); 
		query.append("||	'|'	||	tml_io_bnd_flg" ).append("\n"); 
		query.append("||	'|'	||	tml_ioc_flg" ).append("\n"); 
		query.append("||	'|'	||	tml_aply_dt_flg" ).append("\n"); 
		query.append("||	'|'	||	tml_lane_flg" ).append("\n"); 
		query.append("||	'|'	||	tml_dcgo_aply_flg" ).append("\n"); 
		query.append("||	'|'	||	tml_tr_vol_flg" ).append("\n"); 
		query.append("||	'|'	||	tml_ovt_shft_flg" ).append("\n"); 
		query.append("||	'|'	||	tml_thc_flg" ).append("\n"); 
		query.append("||	'|'	||	sto_com_agmt_tp_flg" ).append("\n"); 
		query.append("||	'|'	||	sto_com_cmnc_tm_flg" ).append("\n"); 
		query.append("||	'|'	||	sto_free_dy_io_bnd_flg" ).append("\n"); 
		query.append("||	'|'	||	sto_free_dy_flg" ).append("\n"); 
		query.append("||	'|'	||	sto_free_dy_dcgo_tm_flg" ).append("\n"); 
		query.append("||	'|'	||	sto_free_dy_xcld_dt_flg" ).append("\n"); 
		query.append("||	'|'	||	sto_free_dy_dcgo_rt_flg" ).append("\n"); 
		query.append("||	'|'	||	sto_free_dy_tr_dy_flg" ).append("\n"); 
		query.append("||	'|'	||	sto_fp_calc_prd_flg" ).append("\n"); 
		query.append("||	'|'	||	sto_fp_teu_flg" ).append("\n"); 
		query.append("||	'|'	||	rt_cntr_tpsz_flg" ).append("\n"); 
		query.append("||	'|'	||	rt_teu_flg" ).append("\n"); 
		query.append("||	'|'	||	rt_bx_flg" ).append("\n"); 
		query.append("||	'|'	||	rt_mv_flg" ).append("\n"); 
		query.append("||	'|'	||	free_dy_cntr_tpsz_flg	VRFY_STRING" ).append("\n"); 
		query.append("FROM	TES_TML_AGMT_VRFY_MZD" ).append("\n"); 
		query.append("WHERE	lgs_cost_cd	= @[lgs_cost_cd]" ).append("\n"); 

	}
}