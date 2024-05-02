/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOSearchReqCreationTargetEmptyCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2009.11.03 박연진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOSearchReqCreationTargetEmptyCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request Creation Target List (Empty Cntr) 조회
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOSearchReqCreationTargetEmptyCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOSearchReqCreationTargetEmptyCntrRSQL").append("\n"); 
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
		query.append("SELECT @[trsp_so_ofc_cty_cd] trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append(",trs_trsp_svc_ord_seq1.NEXTVAL  trsp_so_seq" ).append("\n"); 
		query.append(",TRIM(a.repo_pln_id)||'-'||TRIM(a.pln_yrwk)||'-'||TRIM(a.ref_id)||'-'||TRIM(TO_CHAR(a.ref_seq))||" ).append("\n"); 
		query.append("'='||TRIM(mst.rout_org_nod_cd)||'-'||TRIM(mst.rout_dest_nod_cd)||'-'||TRIM(TO_CHAR(mst.rout_seq))  key_value" ).append("\n"); 
		query.append(",mst.inlnd_rout_inv_bil_patt_cd rail_cmb_thru_tp_cd" ).append("\n"); 
		query.append(",'C' trsp_so_sts_cd" ).append("\n"); 
		query.append(",'W' trsp_rail_bil_tp_cd" ).append("\n"); 
		query.append(",a.fm_yd_cd fm_nod_cd" ).append("\n"); 
		query.append(",a.to_yd_cd to_nod_cd" ).append("\n"); 
		query.append(",a.vsl_cd" ).append("\n"); 
		query.append(",a.skd_voy_no" ).append("\n"); 
		query.append(",a.skd_dir_cd" ).append("\n"); 
		query.append(",a.vsl_lane_cd slan_cd" ).append("\n"); 
		query.append(",a.cntr_no eq_no" ).append("\n"); 
		query.append(",a.cntr_tpsz_cd eq_tpsz_cd" ).append("\n"); 
		query.append(",'M' cgo_tp_cd" ).append("\n"); 
		query.append(",mst.rout_org_nod_cd" ).append("\n"); 
		query.append(",mst.rout_dest_nod_cd" ).append("\n"); 
		query.append(",mst.rout_seq" ).append("\n"); 
		query.append(",mst.rout_pln_cd" ).append("\n"); 
		query.append(",mst.inlnd_rout_rmk" ).append("\n"); 
		query.append(",'SYSTEM' cre_ofc_cd" ).append("\n"); 
		query.append(",SYSDATE cre_dt" ).append("\n"); 
		query.append(",'SPP_IF' cre_usr_id" ).append("\n"); 
		query.append(",SYSDATE upd_dt" ).append("\n"); 
		query.append(",'SPP_IF' upd_usr_id" ).append("\n"); 
		query.append(",'' inter_rmk" ).append("\n"); 
		query.append(",'' spcl_instr_rmk" ).append("\n"); 
		query.append(",a.so_if_div_cd trsp_mty_cost_mod_cd" ).append("\n"); 
		query.append(",a.repo_pln_id" ).append("\n"); 
		query.append(",a.pln_yrwk" ).append("\n"); 
		query.append(",a.ref_seq" ).append("\n"); 
		query.append(",a.ref_id" ).append("\n"); 
		query.append(",a.so_rqst_dt trsp_mty_rqst_dt" ).append("\n"); 
		query.append(",a.eq_ctrl_ofc_cd" ).append("\n"); 
		query.append(",(SELECT MAX('Y')" ).append("\n"); 
		query.append("FROM trs_trsp_rail_edi_nod" ).append("\n"); 
		query.append("WHERE edi_rcv_nod_cd IN(a.fm_yd_cd, a.to_yd_cd)" ).append("\n"); 
		query.append("AND LENGTH(edi_rcv_vndr_abbr_nm) > 0) mtc_edi_ind_cd" ).append("\n"); 
		query.append("FROM eqr_repo_exe_so_if a" ).append("\n"); 
		query.append(",mst_container b" ).append("\n"); 
		query.append(",prd_inlnd_rout_mst mst" ).append("\n"); 
		query.append("WHERE a.cntr_no = b.cntr_no(+)" ).append("\n"); 
		query.append("AND a.fm_yd_cd = mst.rout_org_nod_cd(+)" ).append("\n"); 
		query.append("AND a.to_yd_cd = mst.rout_dest_nod_cd(+)" ).append("\n"); 
		query.append("AND mst.pctl_io_bnd_cd = 'M'" ).append("\n"); 
		query.append("AND NVL(mst.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("#if ($nodList.size() > 0)" ).append("\n"); 
		query.append("AND (mst.rout_org_nod_cd, mst.rout_dest_nod_cd, mst.rout_seq) IN (" ).append("\n"); 
		query.append("#foreach( ${keyMst} in ${nodList})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("('$keyMst.velParamField1','$keyMst.velParamField2','$keyMst.velParamField3')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$keyMst.velParamField1','$keyMst.velParamField2','$keyMst.velParamField3')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($RepoPlnList.size() > 0)" ).append("\n"); 
		query.append("AND (a.repo_pln_id, a.pln_yrwk, a.ref_id, a.ref_seq) IN (" ).append("\n"); 
		query.append("#foreach( ${keyRepoPln} in ${RepoPlnList})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("('$keyRepoPln.velParamField1','$keyRepoPln.velParamField2','$keyRepoPln.velParamField3','$keyRepoPln.velParamField4')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$keyRepoPln.velParamField1','$keyRepoPln.velParamField2','$keyRepoPln.velParamField3','$keyRepoPln.velParamField4')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}