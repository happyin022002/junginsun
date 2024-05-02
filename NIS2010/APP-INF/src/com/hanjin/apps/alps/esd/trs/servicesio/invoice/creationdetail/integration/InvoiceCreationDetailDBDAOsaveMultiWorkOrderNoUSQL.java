/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceCreationDetailDBDAOsaveMultiWorkOrderNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2015.03.19 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceCreationDetailDBDAOsaveMultiWorkOrderNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Multi Invoice SO 테이블 업데이트
	  * </pre>
	  */
	public InvoiceCreationDetailDBDAOsaveMultiWorkOrderNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_inv_calc_lgc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_inv_act_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration").append("\n"); 
		query.append("FileName : InvoiceCreationDetailDBDAOsaveMultiWorkOrderNoUSQL").append("\n"); 
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
		query.append("update trs_trsp_svc_ord b" ).append("\n"); 
		query.append("       set b.inv_no = @[inv_no]" ).append("\n"); 
		query.append("       ,b.inv_vndr_seq = @[inv_vndr_seq]" ).append("\n"); 
		query.append("       ,b.inv_curr_cd = @[inv_curr_cd]" ).append("\n"); 
		query.append("       ,b.trsp_inv_calc_lgc_tp_cd = @[trsp_inv_calc_lgc_tp_cd]" ).append("\n"); 
		query.append("       ,b.inv_xch_rt = to_number(@[inv_xch_rt])" ).append("\n"); 
		query.append("       ,b.trsp_inv_act_sts_cd = @[trsp_inv_act_sts_cd]" ).append("\n"); 
		query.append("       ,b.inv_bzc_amt = case when @[inv_curr_cd] in ('KRW','JPY','TWD') then round(((nvl(b.bzc_amt,0) + nvl(b.nego_amt,0) + nvl(b.fuel_scg_amt,0)+ nvl(b.scg_vat_amt,0) + nvl(b.ovr_wgt_scg_amt,0) + nvl(b.etc_add_amt,0) + nvl(b.toll_fee_amt,0)) * @[inv_xch_rt]),0)" ).append("\n"); 
		query.append("                        else round(((nvl(b.bzc_amt,0) + nvl(b.nego_amt,0) + nvl(b.fuel_scg_amt,0) + nvl(b.scg_vat_amt,0) + nvl(b.ovr_wgt_scg_amt,0) + nvl(b.etc_add_amt,0) + nvl(b.toll_fee_amt,0)) * @[inv_xch_rt]),2)" ).append("\n"); 
		query.append("                        end" ).append("\n"); 
		query.append(" 	   ,b.locl_upd_dt = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((select ofc_cd from mdm_vendor where vndr_seq = @[wo_vndr_seq]))" ).append("\n"); 
		query.append("where (b.trsp_wo_ofc_cty_cd,b.trsp_wo_seq) in (select trsp_wo_ofc_cty_cd,trsp_wo_seq" ).append("\n"); 
		query.append("                                                 from trs_trsp_wrk_ord a" ).append("\n"); 
		query.append("                                                where a.trsp_wo_ofc_cty_cd = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("                                                  and a.trsp_wo_seq = @[trsp_wo_seq]" ).append("\n"); 
		query.append("                                                  and a.wo_vndr_seq = @[wo_vndr_seq]" ).append("\n"); 
		query.append("                                                  and NVL(a.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("                                                  AND NVL(a.inter_use_flg, 'N') != 'Y')" ).append("\n"); 
		query.append("  and b.eq_no is not null" ).append("\n"); 
		query.append("  and NVL(b.delt_flg, 'N') = 'N'" ).append("\n"); 

	}
}