/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOsearchRailRampLocationFullRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOsearchRailRampLocationFullRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Billing Full Cntr Request (Rail Ramp)화면에 대한 조회
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOsearchRailRampLocationFullRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOsearchRailRampLocationFullRSQL").append("\n"); 
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
		query.append("select a.rout_org_nod_cd" ).append("\n"); 
		query.append(",a.rout_dest_nod_cd" ).append("\n"); 
		query.append(",a.rout_seq" ).append("\n"); 
		query.append(",a.pctl_io_bnd_cd" ).append("\n"); 
		query.append(",a.org_loc_cd" ).append("\n"); 
		query.append(",a.org_loc_nm" ).append("\n"); 
		query.append(",a.org_yd_cd" ).append("\n"); 
		query.append(",a.org_yd_nm" ).append("\n"); 
		query.append(",a.org_yd_addr" ).append("\n"); 
		query.append(",a.dest_loc_cd" ).append("\n"); 
		query.append(",a.dest_loc_nm" ).append("\n"); 
		query.append(",a.dest_yd_cd" ).append("\n"); 
		query.append(",a.dest_yd_nm" ).append("\n"); 
		query.append(",a.dest_yd_addr" ).append("\n"); 
		query.append(",a.block_vndr_flg" ).append("\n"); 
		query.append(",a.rail_bulk_vndr_flg" ).append("\n"); 
		query.append(",a.rail_ns_vndr_flg" ).append("\n"); 
		query.append(",a.bill_type_flg" ).append("\n"); 
		query.append(",a.embargo_flg" ).append("\n"); 
		query.append(",a.tofc_flg" ).append("\n"); 
		query.append(",a.wrs_full_flg" ).append("\n"); 
		query.append(",a.auto_irg_flg" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("rout_org_nod_cd" ).append("\n"); 
		query.append(",rout_dest_nod_cd" ).append("\n"); 
		query.append(",rout_seq" ).append("\n"); 
		query.append(",prio_seq" ).append("\n"); 
		query.append(",pctl_io_bnd_cd" ).append("\n"); 
		query.append(",org_loc_cd" ).append("\n"); 
		query.append(",org_loc_nm" ).append("\n"); 
		query.append(",org_yd_cd" ).append("\n"); 
		query.append(",org_yd_nm" ).append("\n"); 
		query.append(",org_yd_addr" ).append("\n"); 
		query.append(",dest_loc_cd" ).append("\n"); 
		query.append(",dest_loc_nm" ).append("\n"); 
		query.append(",dest_yd_cd" ).append("\n"); 
		query.append(",dest_yd_nm" ).append("\n"); 
		query.append(",dest_yd_addr" ).append("\n"); 
		query.append(",block_vndr_flg" ).append("\n"); 
		query.append(",rail_bulk_vndr_flg" ).append("\n"); 
		query.append(",rail_ns_vndr_flg" ).append("\n"); 
		query.append(",bill_type_flg" ).append("\n"); 
		query.append(",embargo_flg" ).append("\n"); 
		query.append(",tofc_flg" ).append("\n"); 
		query.append(",wrs_full_flg" ).append("\n"); 
		query.append(",auto_irg_flg" ).append("\n"); 
		query.append("--,max(rail_rout_multi_cnt) over() rail_rout_multi_cnt -- rail org/dest rout媛?媛곴컖 ?ㅻⅤ寃?珥?紐뉕굔?몄?(rail 援ш컙??multi ?몄? ?뺤씤)" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  /*+ ORDERED USE_NL(cop, act, mst, dtl, yd1, loc1, cnt1, yd2, loc2, cnt2)*/" ).append("\n"); 
		query.append("mst.rout_org_nod_cd      rout_org_nod_cd" ).append("\n"); 
		query.append(",mst.rout_dest_nod_cd     rout_dest_nod_cd" ).append("\n"); 
		query.append(",mst.rout_seq             rout_seq" ).append("\n"); 
		query.append(",mst.prio_seq             prio_seq" ).append("\n"); 
		query.append(",MAX(mst.pctl_io_bnd_cd)       pctl_io_bnd_cd" ).append("\n"); 
		query.append(",MAX(loc1.loc_cd)              org_loc_cd" ).append("\n"); 
		query.append(",MAX(loc1.loc_nm || ' ' || cnt1.cnt_nm) org_loc_nm" ).append("\n"); 
		query.append(",yd1.yd_cd org_yd_cd" ).append("\n"); 
		query.append(",MAX(yd1.yd_nm) org_yd_nm" ).append("\n"); 
		query.append(",MAX(yd1.yd_addr) org_yd_addr" ).append("\n"); 
		query.append(",MAX(loc2.loc_cd) dest_loc_cd" ).append("\n"); 
		query.append(",MAX(loc2.loc_nm || ' ' || cnt2.cnt_nm) dest_loc_nm" ).append("\n"); 
		query.append(",yd2.yd_cd dest_yd_cd" ).append("\n"); 
		query.append(",MAX(yd2.yd_nm) dest_yd_nm" ).append("\n"); 
		query.append(",MAX(yd2.yd_addr) dest_yd_addr" ).append("\n"); 
		query.append(",MAX(DECODE(dtl.vndr_seq, 105484, 'Y', 108386, 'Y', 'N')) block_vndr_flg" ).append("\n"); 
		query.append(",MAX(DECODE(dtl.vndr_seq, 119993, 'Y', 'N')) rail_bulk_vndr_flg" ).append("\n"); 
		query.append(",MAX(DECODE(dtl.vndr_seq, 108299, 'Y', 'N')) rail_ns_vndr_flg" ).append("\n"); 
		query.append(",MAX(DECODE(mst.inlnd_rout_inv_bil_patt_cd, 'S2R', 'Y', 'S3R', 'Y', 'N')) bill_type_flg" ).append("\n"); 
		query.append(",'' embargo_flg" ).append("\n"); 
		query.append(",MAX(DECODE(dtl.rail_crr_tp_cd, 'TOI', 'Y', 'TRI', 'Y', 'N')) tofc_flg" ).append("\n"); 
		query.append(",MAX(DECODE(mst.wrs_full_cmdt_cd, null, 'N', 'Y')) wrs_full_flg" ).append("\n"); 
		query.append(",MAX(act.inv_bil_patt_div_flg) auto_irg_flg" ).append("\n"); 
		query.append("-- ,rank() over(order by yd1.yd_cd, yd2.yd_cd) rail_rout_multi_cnt" ).append("\n"); 
		query.append("FROM sce_cop_hdr cop" ).append("\n"); 
		query.append(",PRD_PROD_CTL_ACT_GRP_DTL act" ).append("\n"); 
		query.append(",prd_inlnd_rout_mst mst" ).append("\n"); 
		query.append(",prd_inlnd_rout_dtl dtl" ).append("\n"); 
		query.append(",mdm_yard yd1" ).append("\n"); 
		query.append(",mdm_location loc1" ).append("\n"); 
		query.append(",mdm_country cnt1" ).append("\n"); 
		query.append(",mdm_yard yd2" ).append("\n"); 
		query.append(",mdm_location loc2" ).append("\n"); 
		query.append(",mdm_country cnt2" ).append("\n"); 
		query.append("WHERE cop.pctl_no = act.pctl_no(+)" ).append("\n"); 
		query.append("AND cop.cop_sts_cd IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("AND 'P' = decode(cop.cop_no, cop.mst_cop_no,'P','X')" ).append("\n"); 
		query.append("AND SUBSTR(act.pctl_io_bnd_cd, 1, 1) = 'O'" ).append("\n"); 
		query.append("AND act.trsp_mod_cd = 'RD'" ).append("\n"); 
		query.append("AND act.trsp_so_sts_cd = 'P'" ).append("\n"); 
		query.append("AND cop.bkg_no = UPPER(@[bkg_no])" ).append("\n"); 
		query.append("AND act.rout_org_nod_cd = mst.rout_org_nod_cd(+)" ).append("\n"); 
		query.append("AND act.rout_dest_nod_cd = mst.rout_dest_nod_cd(+)" ).append("\n"); 
		query.append("AND act.rout_seq = mst.rout_seq(+)" ).append("\n"); 
		query.append("AND mst.rout_org_nod_cd = dtl.rout_org_nod_cd(+)" ).append("\n"); 
		query.append("AND mst.rout_dest_nod_cd = dtl.rout_dest_nod_cd(+)" ).append("\n"); 
		query.append("AND mst.rout_seq = dtl.rout_seq(+)" ).append("\n"); 
		query.append("AND NVL(mst.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("AND SUBSTR(act.n1st_nod_cd, 1, 5) = loc1.loc_cd(+)" ).append("\n"); 
		query.append("AND loc1.cnt_cd = cnt1.cnt_cd(+)" ).append("\n"); 
		query.append("AND act.n1st_nod_cd = yd1.yd_cd(+)" ).append("\n"); 
		query.append("AND SUBSTR(DECODE(TRIM(NVL(act.n3rd_nod_cd, '')), '', act.n2nd_nod_cd," ).append("\n"); 
		query.append("DECODE(TRIM(NVL(act.n4th_nod_cd, '')), ''," ).append("\n"); 
		query.append("act.n3rd_nod_cd, act.n4th_nod_cd)), 1, 5) = loc2.loc_cd(+)" ).append("\n"); 
		query.append("AND loc2.cnt_cd = cnt2.cnt_cd(+)" ).append("\n"); 
		query.append("AND DECODE(TRIM(NVL(act.n3rd_nod_cd, '')), '', act.n2nd_nod_cd," ).append("\n"); 
		query.append("DECODE(TRIM(NVL(act.n4th_nod_cd, '')), ''," ).append("\n"); 
		query.append("act.n3rd_nod_cd, act.n4th_nod_cd)) = yd2.yd_cd(+)" ).append("\n"); 
		query.append("GROUP BY mst.rout_org_nod_cd" ).append("\n"); 
		query.append(",mst.rout_dest_nod_cd" ).append("\n"); 
		query.append(",mst.rout_seq" ).append("\n"); 
		query.append(",mst.prio_seq" ).append("\n"); 
		query.append(",yd1.yd_cd" ).append("\n"); 
		query.append(",yd2.yd_cd" ).append("\n"); 
		query.append("ORDER BY mst.rout_org_nod_cd,mst.rout_dest_nod_cd,mst.rout_seq, mst.prio_seq, yd1.yd_cd, yd2.yd_cd" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("order by wrs_full_flg desc, rout_org_nod_cd, rout_dest_nod_cd, prio_seq" ).append("\n"); 
		query.append(")a" ).append("\n"); 
		query.append("where rownum = 1" ).append("\n"); 

	}
}