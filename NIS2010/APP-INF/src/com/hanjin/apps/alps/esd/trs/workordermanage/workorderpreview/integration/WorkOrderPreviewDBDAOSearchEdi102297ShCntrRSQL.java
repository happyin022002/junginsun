/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi102297ShCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdi102297ShCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_102297_SH_CNTR
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi102297ShCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi102297ShCntrRSQL").append("\n"); 
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
		query.append("#if (${trsp_bnd_cd} == 'O' && ${trsp_cst_dtl_mod_cd} == 'DR')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT B.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT so.eq_no cntr_no" ).append("\n"); 
		query.append("        ,MAX(so.eq_tpsz_cd) cntr_tpsz" ).append("\n"); 
		query.append("        ,MAX('F') cntr_sts" ).append("\n"); 
		query.append("        ,MAX(NVL(so.bzc_amt,0)+NVL(so.nego_amt,0)+NVL(so.etc_add_amt,0)+NVL(so.toll_fee_amt,0)) cntr_amt" ).append("\n"); 
		query.append("        ,MAX(SUBSTR(trs_filter_spc_char_fnc(cntr_mf_gds_desc) ,1,100)) cntr_cmdt " ).append("\n"); 
		query.append("        ,so.bkg_no bkg_no" ).append("\n"); 
		query.append("        ,MAX(so.bl_no) bl_no" ).append("\n"); 
		query.append("--        ,MAX(DECODE(so.trsp_bnd_cd,'T',bv.pod_cd ,'O',bv.pod_cd,'I','')) next_port " ).append("\n"); 
		query.append("        ,DECODE(MAX(DECODE(so.trsp_bnd_cd,'T',bv.pod_cd ,'O',bv.pod_cd,'I','')),'JPTOY','JPTOS',MAX(DECODE(so.trsp_bnd_cd,'T',bv.pod_cd ,'O',bv.pod_cd,'I',''))) next_port " ).append("\n"); 
		query.append("--        ,NVL(trs_get_blck_stwg_cd_fnc(so.bkg_no), '   ') blk_stw" ).append("\n"); 
		query.append("        ,NVL(max(bk.blck_stwg_cd), '   ') as blk_stw" ).append("\n"); 
		query.append("--        ,MAX(so.del_cd) bkg_del" ).append("\n"); 
		query.append("        ,DECODE(MAX(so.del_cd),'JPTOY','JPTOS',MAX(so.del_cd)) bkg_del" ).append("\n"); 
		query.append("        ,MAX(DECODE(spcl_cgo_cntr_tp_cd,'AK','A','DG','D','RF','R','RD','Y')) cntr_spc" ).append("\n"); 
		query.append("        ,MAX(ROUND(DECODE(wgt_meas_ut_cd,'LBS',so.cntr_wgt/2.2,so.cntr_wgt) ,2)) cntr_wgt" ).append("\n"); 
		query.append("        ,MAX(DECODE(spcl_cgo_cntr_tp_cd" ).append("\n"); 
		query.append("            ,'DG','(Danger) / IMDG / '||dg.imdg_clss_cd||    ' /UN '||dg.imdg_un_no||' / PSA '||psa_no   " ).append("\n"); 
		query.append("            ,'RF', '(Reefer) / '||rf.cdo_temp||' / '||rf.vent_rto" ).append("\n"); 
		query.append("            ,'AK', DECODE(SUBSTR(so.eq_tpsz_cd, 1, 1),'D', '','(Awkward) /  Length '||ROUND(ak.ttl_dim_len)||' / Width ' ||ROUND(ak.ttl_dim_wdt)||' / VOID '||ak.ovr_void_slt_qty)" ).append("\n"); 
		query.append("        )) cntr_rmk" ).append("\n"); 
		query.append("    ,MAX(rf.cdo_temp) rf_temp_c" ).append("\n"); 
		query.append("    ,MAX(DECODE(vent_rto, 25,'Q',50,'H',0,'C')) rf_venti " ).append("\n"); 
		query.append("    ,NVL(MAX(vent_rto) ,0) rf_new_venti          " ).append("\n"); 
		query.append("    ,NVL(MAX(ROUND(ak.ttl_dim_len)),0) ak_ttl_dim_len" ).append("\n"); 
		query.append("    ,NVL(MAX(ROUND(ak.ttl_dim_wdt)),0) ak_ttl_dim_wdt " ).append("\n"); 
		query.append("    ,NVL(MAX(ROUND(ak.ttl_dim_hgt)),0) ak_ttl_dim_hgt" ).append("\n"); 
		query.append("    ,NVL(MAX(ak.ovr_void_slt_qty),0) ak_void   " ).append("\n"); 
		query.append("    ,NVL(MAX(dg.imdg_clss_cd),' ') dg_imo_class " ).append("\n"); 
		query.append("    ,NVL(MAX(dg.imdg_un_no),' ') dg_unno  " ).append("\n"); 
		query.append("    ,NVL(MAX(dg.psa_no),' ') dg_psa_class " ).append("\n"); 
		query.append("    ,NVL(MAX(dg.psa_no),' ') dg_psa " ).append("\n"); 
		query.append("FROM     bkg_vvd bv   " ).append("\n"); 
		query.append("        ,bkg_booking bk" ).append("\n"); 
		query.append("        ,bkg_cntr_mf_desc cm " ).append("\n"); 
		query.append("        ,mdm_yard yd" ).append("\n"); 
		query.append("        ,bkg_rf_cgo rf" ).append("\n"); 
		query.append("        ,bkg_dg_cgo dg" ).append("\n"); 
		query.append("        ,bkg_awk_cgo ak" ).append("\n"); 
		query.append("      ,BKG_TRO_SPCL_CGO_SEQ DG_SEQ" ).append("\n"); 
		query.append("      ,trs_spcl_cgo_pck_cd pck        " ).append("\n"); 
		query.append("        ,trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append("        ,trs_trsp_svc_ord so                                                                " ).append("\n"); 
		query.append("WHERE so.delt_flg <> 'Y'                                " ).append("\n"); 
		query.append("    AND wo.trsp_wo_ofc_cty_cd = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("    AND wo.trsp_wo_seq = @[trsp_wo_seq]" ).append("\n"); 
		query.append("    AND wo.trsp_wo_ofc_cty_cd = so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("    AND wo.trsp_wo_seq    = so.trsp_wo_seq" ).append("\n"); 
		query.append("    AND so.fm_nod_cd = yd.yd_cd" ).append("\n"); 
		query.append("    AND so.bkg_no = bk.bkg_no                         " ).append("\n"); 
		query.append("    AND so.bkg_no = bv.bkg_no                            " ).append("\n"); 
		query.append("    AND SUBSTR(so.fm_nod_cd ,1,5) =  DECODE(so.trsp_bnd_cd,'T',bv.pol_cd,'O',bv.pol_cd,bv.pod_cd)" ).append("\n"); 
		query.append("    AND so.bkg_no = rf.bkg_no(+)                      " ).append("\n"); 
		query.append("    AND so.eq_no = rf.cntr_no(+)" ).append("\n"); 
		query.append("    AND so.bkg_no = ak.bkg_no(+)" ).append("\n"); 
		query.append("    AND so.eq_no = ak.cntr_no(+)" ).append("\n"); 
		query.append("    AND so.bkg_no = dg.bkg_no(+)" ).append("\n"); 
		query.append("   AND dg.out_imdg_pck_cd1 = pck.spcl_cgo_pck_cd(+)" ).append("\n"); 
		query.append("   AND DG.DCGO_SEQ         = DG_SEQ.TRO_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("   AND SO.BKG_NO           = DG_SEQ.BKG_NO(+)" ).append("\n"); 
		query.append("   AND SO.TRO_SEQ          = DG_SEQ.TRO_SEQ(+)" ).append("\n"); 
		query.append("   AND SO.TRSP_BND_CD      = DG_SEQ.IO_BND_CD(+)" ).append("\n"); 
		query.append("--    AND so.eq_no = dg.cntr_no(+)" ).append("\n"); 
		query.append("    AND so.bkg_no = cm.bkg_no(+)" ).append("\n"); 
		query.append("    AND so.eq_no = cm.cntr_no(+)" ).append("\n"); 
		query.append("    AND cm.cntr_mf_seq(+) = 1" ).append("\n"); 
		query.append("     AND wo.hjl_no IS NULL" ).append("\n"); 
		query.append("     AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("GROUP BY so.eq_no,so.bkg_no" ).append("\n"); 
		query.append("ORDER BY so.eq_no" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT C.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT so.eq_no cntr_no" ).append("\n"); 
		query.append("        ,MAX(so.eq_tpsz_cd) cntr_tpsz" ).append("\n"); 
		query.append("        ,MAX('F') cntr_sts" ).append("\n"); 
		query.append("        ,MAX(NVL(So.bzc_amt,0) + NVL(so.nego_amt,0) + NVL(so.etc_add_amt,0) + NVL(so.toll_fee_amt,0)) cntr_amt" ).append("\n"); 
		query.append("        ,MAX(SUBSTR(trs_filter_spc_char_fnc(cntr_mf_gds_desc) ,1,100)) cntr_cmdt " ).append("\n"); 
		query.append("        ,so.bkg_no bkg_no" ).append("\n"); 
		query.append("        ,MAX(so.bl_no) bl_no" ).append("\n"); 
		query.append("--        ,MAX(DECODE(so.trsp_bnd_cd,'T',bv.pod_cd ,'O',bv.pod_cd,'I','')) next_port " ).append("\n"); 
		query.append("        ,DECODE(MAX(DECODE(so.trsp_bnd_cd,'T',bv.pod_cd ,'O',bv.pod_cd,'I','')),'JPTOY','JPTOS',MAX(DECODE(so.trsp_bnd_cd,'T',bv.pod_cd ,'O',bv.pod_cd,'I',''))) next_port " ).append("\n"); 
		query.append("--        ,NVL(trs_get_blck_stwg_cd_fnc(so.bkg_no), '   ') blk_stw" ).append("\n"); 
		query.append("        ,NVL(max(bk.blck_stwg_cd), '   ')  as blk_stw" ).append("\n"); 
		query.append("--        ,MAX(so.del_cd) bkg_del" ).append("\n"); 
		query.append("        ,DECODE(MAX(so.del_cd),'JPTOY','JPTOS',MAX(so.del_cd)) bkg_del " ).append("\n"); 
		query.append("        ,MAX(DECODE(spcl_cgo_cntr_tp_cd,'AK','A','DG','D','RF','R','RD','Y')) cntr_spc" ).append("\n"); 
		query.append("        ,MAX(ROUND(DECODE(wgt_meas_ut_cd,'LBS',so.cntr_wgt/2.2,so.cntr_wgt) ,2)) cntr_wgt" ).append("\n"); 
		query.append("        ,MAX(DECODE(spcl_cgo_cntr_tp_cd" ).append("\n"); 
		query.append("            ,'DG','(Danger) / IMDG / '||dg.imdg_clss_cd||    ' /UN '||dg.imdg_un_no||' / PSA '||psa_no   " ).append("\n"); 
		query.append("            ,'RF', '(Reefer) / '||rf.cdo_temp||' / '||rf.vent_rto" ).append("\n"); 
		query.append("            ,'AK', DECODE(SUBSTR(so.eq_tpsz_cd, 1, 1),'D', '','(Awkward) /  Length '||ROUND(ak.ttl_dim_len)||' / Width ' ||ROUND(ak.ttl_dim_wdt)||' / VOID '||ak.ovr_void_slt_qty)" ).append("\n"); 
		query.append("        )) cntr_rmk" ).append("\n"); 
		query.append("    ,MAX(rf.cdo_temp) rf_temp_c" ).append("\n"); 
		query.append("    ,MAX(DECODE(vent_rto, 25,'Q',50,'H',0,'C')) rf_venti " ).append("\n"); 
		query.append("    ,NVL(MAX(vent_rto) ,0) rf_new_venti         " ).append("\n"); 
		query.append("    ,NVL(MAX(ROUND(ak.ttl_dim_len)),0) ak_ttl_dim_len" ).append("\n"); 
		query.append("    ,NVL(MAX(ROUND(ak.ttl_dim_wdt)),0) ak_ttl_dim_wdt" ).append("\n"); 
		query.append("    ,NVL(MAX(ROUND(ak.ttl_dim_hgt)),0) ak_ttl_dim_hgt" ).append("\n"); 
		query.append("    ,NVL(MAX(ak.ovr_void_slt_qty),0) ak_void   " ).append("\n"); 
		query.append("    ,NVL(MAX(dg.imdg_clss_cd),' ') dg_imo_class " ).append("\n"); 
		query.append("    ,NVL(MAX(dg.imdg_un_no),' ') dg_unno " ).append("\n"); 
		query.append("    ,NVL(MAX(dg.psa_no),' ') dg_psa_class " ).append("\n"); 
		query.append("    ,NVL(MAX(dg.psa_no),' ') dg_psa " ).append("\n"); 
		query.append("FROM     bkg_vvd bv   " ).append("\n"); 
		query.append("        ,bkg_booking bk" ).append("\n"); 
		query.append("        ,bkg_cntr_mf_desc cm " ).append("\n"); 
		query.append("        ,mdm_yard yd" ).append("\n"); 
		query.append("        ,bkg_rf_cgo rf" ).append("\n"); 
		query.append("        ,bkg_dg_cgo dg" ).append("\n"); 
		query.append("        ,bkg_awk_cgo ak" ).append("\n"); 
		query.append("        ,trs_spcl_cgo_pck_cd pck" ).append("\n"); 
		query.append("        ,trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append("        ,trs_trsp_svc_ord so                                                                " ).append("\n"); 
		query.append("WHERE so.delt_flg <> 'Y'                                " ).append("\n"); 
		query.append("    AND wo.trsp_wo_ofc_cty_cd = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("    AND wo.trsp_wo_seq = @[trsp_wo_seq]" ).append("\n"); 
		query.append("    AND wo.trsp_wo_ofc_cty_cd = so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("    AND wo.trsp_wo_seq    = so.trsp_wo_seq" ).append("\n"); 
		query.append("    AND so.fm_nod_cd = yd.yd_cd" ).append("\n"); 
		query.append("    AND so.bkg_no = bk.bkg_no                         " ).append("\n"); 
		query.append("    AND so.bkg_no = bv.bkg_no                            " ).append("\n"); 
		query.append("    AND SUBSTR(so.fm_nod_cd ,1,5) =  DECODE(so.trsp_bnd_cd,'T',bv.pol_cd,'O',bv.pol_cd,bv.pod_cd)" ).append("\n"); 
		query.append("    AND so.bkg_no = rf.bkg_no(+)                      " ).append("\n"); 
		query.append("    AND so.eq_no = rf.cntr_no(+)" ).append("\n"); 
		query.append("    AND so.bkg_no = ak.bkg_no(+)" ).append("\n"); 
		query.append("    AND so.eq_no = ak.cntr_no(+)" ).append("\n"); 
		query.append("    AND so.bkg_no = dg.bkg_no(+)" ).append("\n"); 
		query.append("    AND so.eq_no = dg.cntr_no(+)" ).append("\n"); 
		query.append("    AND dg.out_imdg_pck_cd1 = pck.spcl_cgo_pck_cd(+)" ).append("\n"); 
		query.append("    AND so.bkg_no = cm.bkg_no(+)" ).append("\n"); 
		query.append("    AND so.eq_no = cm.cntr_no(+)" ).append("\n"); 
		query.append("    AND cm.cntr_mf_seq(+) = 1" ).append("\n"); 
		query.append("     AND wo.hjl_no IS NULL" ).append("\n"); 
		query.append("     AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("GROUP BY so.eq_no,so.bkg_no" ).append("\n"); 
		query.append("ORDER BY so.eq_no" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}