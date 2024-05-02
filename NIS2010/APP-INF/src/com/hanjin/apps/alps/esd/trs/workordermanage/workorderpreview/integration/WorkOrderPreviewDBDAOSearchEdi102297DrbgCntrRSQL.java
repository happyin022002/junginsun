/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi102297DrbgCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.26 
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

public class WorkOrderPreviewDBDAOSearchEdi102297DrbgCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_102297_DRBG_CNTR
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi102297DrbgCntrRSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi102297DrbgCntrRSQL").append("\n"); 
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
		query.append("SELECT B.cntr_no,B.cntr_tpsz,B.cntr_sts,B.cntr_cmdt,B.cntr_wgt,B.cntr_pkg,B.cntr_spc,B.spc_rmk" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT RPAD(so.eq_no, 11, ' ') cntr_no" ).append("\n"); 
		query.append("	,MAX(RPAD(so.eq_tpsz_cd, 2, ' ')) cntr_tpsz" ).append("\n"); 
		query.append("	,MAX('F') cntr_sts" ).append("\n"); 
		query.append("	,MAX(RPAD(NVL(trs_filter_spc_char_fnc(cm.cntr_mf_gds_desc) ,' '), 100, ' ')) cntr_cmdt " ).append("\n"); 
		query.append("	,so.bkg_no bkg_no" ).append("\n"); 
		query.append("	,MAX(RPAD(NVL(so.cntr_wgt,0), 12, ' ')) cntr_wgt" ).append("\n"); 
		query.append("	,MAX(RPAD(NVL(bc.pck_qty,0), 7, ' ')) cntr_pkg" ).append("\n"); 
		query.append("	,MAX(DECODE(spcl_cgo_cntr_tp_cd,'AK','A','DG','D','RF','R','RD','Y')) cntr_spc" ).append("\n"); 
		query.append("	,MAX(DECODE(spcl_cgo_cntr_tp_cd" ).append("\n"); 
		query.append("        ,'DG', '(Danger)/IMDG / '||(SELECT s2_dg.imdg_clss_cd||' /UN '||s2_dg.imdg_un_no||' / PSA '||s2_dg.psa_no" ).append("\n"); 
		query.append("                                      FROM bkg_dg_cgo s2_dg" ).append("\n"); 
		query.append("                                          ,bkg_tro_spcl_cgo_seq s2_tro" ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("                                       AND s2_tro.bkg_no    = so.bkg_no" ).append("\n"); 
		query.append("                                       AND s2_tro.tro_seq   = so.tro_seq" ).append("\n"); 
		query.append("                                       AND s2_tro.io_bnd_cd = so.trsp_bnd_cd" ).append("\n"); 
		query.append("                                       AND s2_dg.bkg_no     = so.bkg_no" ).append("\n"); 
		query.append("                                       AND s2_dg.dcgo_seq   = s2_tro.tro_spcl_cgo_seq" ).append("\n"); 
		query.append("                                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("		,'RF','(Reefer)/'||rf.cdo_temp||'/'||rf.vent_rto " ).append("\n"); 
		query.append("        ,'AK',DECODE(SUBSTR(so.eq_tpsz_cd, 1, 1), 'D', '','(Awkward) /  Length '||ROUND(ak.ttl_dim_len)||' / Width '||ROUND(ak.ttl_dim_wdt)||' / VOID '||ak.ovr_void_slt_qty) " ).append("\n"); 
		query.append("	)) spc_rmk" ).append("\n"); 
		query.append("FROM bkg_container bc" ).append("\n"); 
		query.append("	,bkg_awk_cgo ak" ).append("\n"); 
		query.append("	,bkg_rf_cgo rf" ).append("\n"); 
		query.append("	,bkg_cntr_mf_desc cm" ).append("\n"); 
		query.append("	,trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append("	,trs_trsp_svc_ord so" ).append("\n"); 
		query.append("WHERE so.delt_flg <> 'Y'" ).append("\n"); 
		query.append("   	AND wo.trsp_wo_ofc_cty_cd = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("   	AND wo.trsp_wo_seq	= @[trsp_wo_seq]" ).append("\n"); 
		query.append("	AND wo.trsp_wo_ofc_cty_cd = so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("	AND wo.trsp_wo_seq = so.trsp_wo_seq" ).append("\n"); 
		query.append("	AND so.bkg_no = bc.bkg_no(+)" ).append("\n"); 
		query.append("	AND so.eq_no = bc.cntr_no(+)" ).append("\n"); 
		query.append("	AND so.bkg_no = ak.bkg_no(+)" ).append("\n"); 
		query.append("	AND so.eq_no = ak.cntr_no(+)" ).append("\n"); 
		query.append("	AND so.bkg_no = rf.bkg_no(+)" ).append("\n"); 
		query.append("	AND so.eq_no = rf.cntr_no(+)" ).append("\n"); 
		query.append("	AND so.bkg_no = cm.bkg_no(+)" ).append("\n"); 
		query.append("	AND so.eq_no = cm.cntr_no(+)" ).append("\n"); 
		query.append("	AND cm.cntr_mf_seq(+) = 1  " ).append("\n"); 
		query.append("	AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("	AND wo.hjl_no IS NULL" ).append("\n"); 
		query.append("GROUP BY so.eq_no,so.bkg_no" ).append("\n"); 
		query.append("ORDER BY so.eq_no" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT C.cntr_no,C.cntr_tpsz,C.cntr_sts,C.cntr_cmdt,C.cntr_wgt,C.cntr_pkg,C.cntr_spc,C.spc_rmk" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT RPAD(so.eq_no, 11, ' ') cntr_no" ).append("\n"); 
		query.append("	,MAX(RPAD(so.eq_tpsz_cd, 2, ' ')) cntr_tpsz" ).append("\n"); 
		query.append("	,MAX('F') cntr_sts" ).append("\n"); 
		query.append("	,MAX(RPAD(NVL(trs_filter_spc_char_fnc(cm.cntr_mf_gds_desc) ,' '), 100, ' ')) cntr_cmdt " ).append("\n"); 
		query.append("	,so.bkg_no bkg_no" ).append("\n"); 
		query.append("	,MAX(RPAD(NVL(so.cntr_wgt,0), 12, ' ')) cntr_wgt" ).append("\n"); 
		query.append("	,MAX(RPAD(NVL(bc.pck_qty,0), 7, ' ')) cntr_pkg" ).append("\n"); 
		query.append("	,MAX(DECODE(spcl_cgo_cntr_tp_cd,'AK','A','DG','D','RF','R','RD','Y')) cntr_spc" ).append("\n"); 
		query.append("	,MAX(DECODE(spcl_cgo_cntr_tp_cd" ).append("\n"); 
		query.append("		,'DG','(Danger)/IMDG / '||dg.imdg_clss_cd||' /UN '||dg.imdg_un_no||' / PSA '||psa_no " ).append("\n"); 
		query.append("		,'RF','(Reefer)/'||rf.cdo_temp||'/'||rf.vent_rto " ).append("\n"); 
		query.append("        ,'AK',DECODE(SUBSTR(so.eq_tpsz_cd, 1, 1), 'D', '','(Awkward) /  Length '||ROUND(ak.ttl_dim_len)||' / Width '||ROUND(ak.ttl_dim_wdt)||' / VOID '||ak.ovr_void_slt_qty) " ).append("\n"); 
		query.append("	)) spc_rmk" ).append("\n"); 
		query.append("FROM bkg_container bc  " ).append("\n"); 
		query.append("	,bkg_dg_cgo dg" ).append("\n"); 
		query.append("	,bkg_awk_cgo ak" ).append("\n"); 
		query.append("	,bkg_rf_cgo rf" ).append("\n"); 
		query.append("	,bkg_cntr_mf_desc cm" ).append("\n"); 
		query.append("    ,trs_spcl_cgo_pck_cd pck" ).append("\n"); 
		query.append("	,trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append("	,trs_trsp_svc_ord so" ).append("\n"); 
		query.append("WHERE so.delt_flg <> 'Y'" ).append("\n"); 
		query.append("   	AND wo.trsp_wo_ofc_cty_cd = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("   	AND wo.trsp_wo_seq	= @[trsp_wo_seq]" ).append("\n"); 
		query.append("	AND wo.trsp_wo_ofc_cty_cd = so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("	AND wo.trsp_wo_seq = so.trsp_wo_seq" ).append("\n"); 
		query.append("	AND so.bkg_no = bc.bkg_no" ).append("\n"); 
		query.append("	AND so.eq_no = bc.cntr_no" ).append("\n"); 
		query.append("	AND so.bkg_no = dg.bkg_no(+)" ).append("\n"); 
		query.append("	AND so.eq_no = dg.cntr_no(+)" ).append("\n"); 
		query.append("	AND dg.out_imdg_pck_cd1 = pck.spcl_cgo_pck_cd(+)" ).append("\n"); 
		query.append("	AND so.bkg_no = ak.bkg_no(+)" ).append("\n"); 
		query.append("	AND so.eq_no = ak.cntr_no(+)" ).append("\n"); 
		query.append("	AND so.bkg_no = rf.bkg_no(+)" ).append("\n"); 
		query.append("	AND so.eq_no = rf.cntr_no(+)" ).append("\n"); 
		query.append("	AND so.bkg_no = cm.bkg_no(+)" ).append("\n"); 
		query.append("	AND so.eq_no = cm.cntr_no(+)" ).append("\n"); 
		query.append("	AND cm.cntr_mf_seq(+) = 1  " ).append("\n"); 
		query.append("	AND so.hjl_no IS NULL" ).append("\n"); 
		query.append("	AND wo.hjl_no IS NULL" ).append("\n"); 
		query.append("GROUP BY so.eq_no,so.bkg_no" ).append("\n"); 
		query.append("ORDER BY so.eq_no" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}