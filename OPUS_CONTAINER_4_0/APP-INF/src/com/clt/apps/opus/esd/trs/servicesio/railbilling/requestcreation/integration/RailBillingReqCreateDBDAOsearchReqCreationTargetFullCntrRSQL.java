/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOsearchReqCreationTargetFullCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2011.05.09 박연진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOsearchReqCreationTargetFullCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request Creation Target List (Full Cntr) Search SQL
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOsearchReqCreationTargetFullCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_full_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_full_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.integration").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOsearchReqCreationTargetFullCntrRSQL").append("\n"); 
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
		query.append("SELECT /*+ leading(a b)*/" ).append("\n"); 
		query.append("'WRS' trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append(",trs_trsp_svc_ord_seq1.NEXTVAL  trsp_so_seq" ).append("\n"); 
		query.append(",h.inlnd_rout_inv_bil_patt_cd rail_cmb_thru_tp_cd" ).append("\n"); 
		query.append(",'C' trsp_so_sts_cd" ).append("\n"); 
		query.append(",'W' trsp_rail_bil_tp_cd" ).append("\n"); 
		query.append(",'' ibd_ipi_locl_ind_cd" ).append("\n"); 
		query.append("--,d.ibd_ipi_locl_ind_cd" ).append("\n"); 
		query.append(",@[fm_full_nod_cd] fm_full_nod_cd" ).append("\n"); 
		query.append(",@[to_full_nod_cd] to_full_nod_cd" ).append("\n"); 
		query.append(",@[fm_nod_cd] fm_nod_cd" ).append("\n"); 
		query.append(",@[to_nod_cd] to_nod_cd" ).append("\n"); 
		query.append(",c.vsl_cd" ).append("\n"); 
		query.append(",c.skd_voy_no" ).append("\n"); 
		query.append(",c.skd_dir_cd" ).append("\n"); 
		query.append(",c.slan_cd" ).append("\n"); 
		query.append(",a.cntr_no eq_no" ).append("\n"); 
		query.append(",a.cntr_tpsz_cd eq_tpsz_cd" ).append("\n"); 
		query.append(",'O' trsp_bnd_cd" ).append("\n"); 
		query.append(",c.bkg_no" ).append("\n"); 
		query.append(",c.bl_no" ).append("\n"); 
		query.append(",e.cntr_wgt" ).append("\n"); 
		query.append(",'LBS' wgt_meas_ut_cd" ).append("\n"); 
		query.append(",'F' cgo_tp_cd" ).append("\n"); 
		query.append(",m.pck_tp_cd" ).append("\n"); 
		query.append(",m.pck_qty" ).append("\n"); 
		query.append(",c.cmdt_cd" ).append("\n"); 
		query.append(",NULL stnd_cmdt_no" ).append("\n"); 
		query.append(",a.cop_no" ).append("\n"); 
		query.append(",b.cost_act_grp_seq" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN c.DCGO_FLG       = 'Y' THEN 'DG'" ).append("\n"); 
		query.append("WHEN c.RC_FLG           = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("WHEN c.AWK_CGO_FLG    	= 'Y' THEN 'AK'" ).append("\n"); 
		query.append("WHEN c.BB_CGO_FLG       = 'Y' THEN 'BB'" ).append("\n"); 
		query.append("WHEN c.SPCL_HIDE_FLG         = 'Y' THEN 'HD'" ).append("\n"); 
		query.append("WHEN c.RAIL_BLK_CD        is not null   THEN 'RB'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END spcl_cgo_cntr_tp_cd" ).append("\n"); 
		query.append(",'' ibd_cstms_clr_loc_cd" ).append("\n"); 
		query.append("--,d.ibd_cstms_clr_loc_cd" ).append("\n"); 
		query.append(",c.pod_cd" ).append("\n"); 
		query.append(",SUBSTR(a.por_nod_cd, 1, 5) por_cd" ).append("\n"); 
		query.append(",c.pol_cd" ).append("\n"); 
		query.append(",c.del_cd" ).append("\n"); 
		query.append(",a.por_nod_cd" ).append("\n"); 
		query.append(",a.del_nod_cd" ).append("\n"); 
		query.append(",f.scc_cd del_scc_cd" ).append("\n"); 
		query.append(",c.usa_cstms_file_cd nvocc_file_no" ).append("\n"); 
		query.append("--,e.cntr_seal_no" ).append("\n"); 
		query.append(",(select CNTR_SEAL_NO from BKG_CNTR_SEAL_NO where bkg_no = a.bkg_no and cntr_no = a.cntr_no and rownum = 1) cntr_seal_no" ).append("\n"); 
		query.append(",b.cost_act_grp_cd act_grp_cd" ).append("\n"); 
		query.append(",TO_CHAR(b.n1st_nod_pln_dt, 'YYYYMMDDHH24MISS')n1st_nod_pln_dt" ).append("\n"); 
		query.append(",TO_CHAR(b.lst_nod_pln_dt, 'YYYYMMDDHH24MISS') lst_nod_pln_dt" ).append("\n"); 
		query.append(",c.bkg_cgo_tp_cd" ).append("\n"); 
		query.append(",@[rout_org_nod_cd] rout_org_nod_cd  -- b.rout_org_nod_cd" ).append("\n"); 
		query.append(",@[rout_dest_nod_cd] rout_dest_nod_cd -- b.rout_dest_nod_cd" ).append("\n"); 
		query.append(",@[rout_seq] rout_seq         -- b.rout_seq" ).append("\n"); 
		query.append(",b.ctrl_ofc_cd" ).append("\n"); 
		query.append(",h.rout_pln_cd" ).append("\n"); 
		query.append(",h.inlnd_rout_rmk" ).append("\n"); 
		query.append(",'SYSTEM' cre_ofc_cd" ).append("\n"); 
		query.append(",SYSDATE cre_dt" ).append("\n"); 
		query.append(",'SPP_IF' cre_usr_id" ).append("\n"); 
		query.append(",SYSDATE upd_dt" ).append("\n"); 
		query.append(",'SPP_IF' upd_usr_id" ).append("\n"); 
		query.append(",REPLACE(REPLACE(REPLACE(k.cust_lgl_eng_nm, CHR(13) || CHR(10), ' '), CHR(34), ' '), CHR(9), ' ') shpr_cust_nm" ).append("\n"); 
		query.append(",i.cust_cnt_cd" ).append("\n"); 
		query.append(",i.cust_seq" ).append("\n"); 
		query.append(",(SELECT MAX('Y')" ).append("\n"); 
		query.append("FROM trs_trsp_rail_edi_nod" ).append("\n"); 
		query.append("WHERE edi_rcv_nod_cd IN ( @[fm_nod_cd] , @[to_nod_cd]) -- fm_nod_cd, to_nod_cd" ).append("\n"); 
		query.append("AND LENGTH(edi_rcv_vndr_abbr_nm) > 0) mtc_edi_ind_cd" ).append("\n"); 
		query.append(",DECODE(b.pctl_io_bnd_cd, 'I', c.de_term_cd, 'O', c.rcv_term_cd, '') bkg_rcvde_term_cd" ).append("\n"); 
		query.append(",a.pol_nod_cd" ).append("\n"); 
		query.append(",a.pod_nod_cd" ).append("\n"); 
		query.append(",c.sc_no" ).append("\n"); 
		query.append("FROM sce_cop_hdr a" ).append("\n"); 
		query.append(",SCE_PLN_SO_LIST b" ).append("\n"); 
		query.append(",bkg_booking c" ).append("\n"); 
		query.append("--,edi_usa_ib_cgo_rlse d" ).append("\n"); 
		query.append(",bkg_container e" ).append("\n"); 
		query.append(",mdm_location f" ).append("\n"); 
		query.append(",prd_inlnd_rout_mst h" ).append("\n"); 
		query.append(",bkg_customer i" ).append("\n"); 
		query.append(",mdm_location j" ).append("\n"); 
		query.append(",mdm_customer k" ).append("\n"); 
		query.append(",bkg_bl_doc m" ).append("\n"); 
		query.append("WHERE a.cop_no = b.cop_no(+)" ).append("\n"); 
		query.append("AND a.cop_sts_cd IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("--AND 'P' = decode(a.cop_no,a.mst_cop_no, 'P','X')" ).append("\n"); 
		query.append("AND b.TRSP_SO_STS_CD='P'" ).append("\n"); 
		query.append("AND a.bkg_no = c.bkg_no" ).append("\n"); 
		query.append("--AND c.bl_no = d.bl_no(+)" ).append("\n"); 
		query.append("AND a.bkg_no = e.bkg_no(+)" ).append("\n"); 
		query.append("AND a.cntr_no = e.cntr_no(+)" ).append("\n"); 
		query.append("AND c.del_cd = f.loc_cd(+)" ).append("\n"); 
		query.append("AND SUBSTR(@[fm_nod_cd], 1, 5) = j.loc_cd  -- fm_nod_cd" ).append("\n"); 
		query.append("AND j.conti_cd = 'M'" ).append("\n"); 
		query.append("AND @[rout_org_nod_cd] = h.rout_org_nod_cd  -- rout_org_nod_cd" ).append("\n"); 
		query.append("AND @[rout_dest_nod_cd] = h.rout_dest_nod_cd -- rout_dest_nod_cd" ).append("\n"); 
		query.append("AND @[rout_seq] = h.rout_seq         -- rout_seq" ).append("\n"); 
		query.append("AND a.bkg_no = i.bkg_no" ).append("\n"); 
		query.append("AND i.bkg_cust_tp_cd(+) = 'S'" ).append("\n"); 
		query.append("AND i.cust_cnt_cd = k.cust_cnt_cd(+)" ).append("\n"); 
		query.append("AND i.cust_seq = k.cust_seq(+)" ).append("\n"); 
		query.append("AND a.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("AND a.cop_no IN (" ).append("\n"); 
		query.append("#foreach( ${key1} in ${actGrpKey})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$key1.velParamField1'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$key1.velParamField1'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND h.pctl_io_bnd_cd != 'M'" ).append("\n"); 
		query.append("AND NVL(h.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("AND SUBSTR(b.pctl_io_bnd_cd, 1, 1) = 'O'" ).append("\n"); 
		query.append("#if ($actGrpKey.size() > 0)" ).append("\n"); 
		query.append("AND (b.cop_no, b.cost_act_grp_seq) IN (" ).append("\n"); 
		query.append("#foreach( ${key2} in ${actGrpKey})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("('$key2.velParamField1','$key2.velParamField2')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$key2.velParamField1','$key2.velParamField2')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND nvl(k.NMD_CUST_FLG(+),'N') = 'N'" ).append("\n"); 
		query.append("AND c.bkg_no = m.bkg_no(+)" ).append("\n"); 

	}
}