/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOsearchRailRampAutoAdjustLocationFullRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2009.10.12 박연진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOsearchRailRampAutoAdjustLocationFullRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail Billing Full Cntr Request (Rail Ramp)화면에 대한 조회
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOsearchRailRampAutoAdjustLocationFullRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration ").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOsearchRailRampAutoAdjustLocationFullRSQL").append("\n"); 
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
		query.append("SELECT x.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  /*+ ORDERED USE_NL(cop, act, mst, dtl, yd1, loc1, cnt1, yd2, loc2, cnt2, bkg, prd)*/" ).append("\n"); 
		query.append("mst.rout_org_nod_cd" ).append("\n"); 
		query.append(",mst.rout_dest_nod_cd" ).append("\n"); 
		query.append(",mst.rout_seq" ).append("\n"); 
		query.append(",mst.prio_seq" ).append("\n"); 
		query.append(",DECODE(act.pctl_io_bnd_cd, 'I', bkg.de_term_cd, 'O', bkg.rcv_term_cd, '') bkg_rcvde_term_cd" ).append("\n"); 
		query.append(",prd.nod_tp_cd" ).append("\n"); 
		query.append(",CASE WHEN DECODE(act.pctl_io_bnd_cd, 'I', bkg.de_term_cd, 'O', bkg.rcv_term_cd, '') = 'D'" ).append("\n"); 
		query.append("AND prd.nod_tp_cd = 'Z' THEN 'Y'" ).append("\n"); 
		query.append("WHEN DECODE(act.pctl_io_bnd_cd, 'I', bkg.de_term_cd, 'O', bkg.rcv_term_cd, '') <> 'D'" ).append("\n"); 
		query.append("AND prd.nod_tp_cd <> 'Z' THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END disp_flag" ).append("\n"); 
		query.append(",'' org_loc_cd" ).append("\n"); 
		query.append(",'' org_loc_nm" ).append("\n"); 
		query.append(",'' org_yd_cd" ).append("\n"); 
		query.append(",'' org_yd_nm" ).append("\n"); 
		query.append(",'' org_yd_addr" ).append("\n"); 
		query.append(",'' dest_loc_cd" ).append("\n"); 
		query.append(",'' dest_loc_nm" ).append("\n"); 
		query.append(",'' dest_yd_cd" ).append("\n"); 
		query.append(",'' dest_yd_nm" ).append("\n"); 
		query.append(",'' dest_yd_addr" ).append("\n"); 
		query.append("--                 ,MAX(DECODE(dtl.vndr_seq, 105475, 'Y', 105484, 'Y', 108386, 'Y', 'N')) block_vndr_flg" ).append("\n"); 
		query.append(",MAX(DECODE(dtl.vndr_seq, 105484, 'Y', 108386, 'Y', 'N')) block_vndr_flg" ).append("\n"); 
		query.append(",MAX(DECODE(dtl.vndr_seq, 119993, 'Y', 'N')) rail_bulk_vndr_flg" ).append("\n"); 
		query.append(",MAX(DECODE(mst.inlnd_rout_inv_bil_patt_cd, 'S2R', 'Y', 'S3R', 'Y', 'N')) bill_type_flg" ).append("\n"); 
		query.append(",'' embargo_flg" ).append("\n"); 
		query.append(",MAX(DECODE(dtl.rail_crr_tp_cd, 'TOI', 'Y', 'TRI', 'Y', 'N')) tofc_flg" ).append("\n"); 
		query.append(",MAX(DECODE(mst.wrs_full_cmdt_cd, null, 'N', 'Y')) wrs_full_flg" ).append("\n"); 
		query.append(",MAX(act.inv_bil_patt_div_flg) auto_irg_flg" ).append("\n"); 
		query.append("FROM sce_cop_hdr cop" ).append("\n"); 
		query.append(",PRD_PROD_CTL_ACT_GRP_DTL act" ).append("\n"); 
		query.append(",prd_inlnd_rout_mst mst" ).append("\n"); 
		query.append(",prd_inlnd_rout_dtl dtl" ).append("\n"); 
		query.append(",bkg_booking bkg" ).append("\n"); 
		query.append(",prd_node prd" ).append("\n"); 
		query.append("WHERE cop.pctl_no = act.pctl_no(+)" ).append("\n"); 
		query.append("AND cop.cop_sts_cd IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("AND 'P' = decode(cop.cop_no, cop.mst_cop_no,'P','X')" ).append("\n"); 
		query.append("AND SUBSTR(act.pctl_io_bnd_cd, 1, 1) = 'O'" ).append("\n"); 
		query.append("AND act.trsp_mod_cd = 'RD'" ).append("\n"); 
		query.append("AND act.trsp_so_sts_cd = 'P'" ).append("\n"); 
		query.append("AND cop.bkg_no = UPPER(@[bkg_no])" ).append("\n"); 
		query.append("AND mst.rout_org_nod_cd  = cop.por_nod_cd" ).append("\n"); 
		query.append("AND mst.rout_dest_nod_cd = (" ).append("\n"); 
		query.append("SELECT /*+ INDEX_ASC(a XPKSCE_COP_DTL) */" ).append("\n"); 
		query.append("a.nod_cd" ).append("\n"); 
		query.append("FROM sce_cop_dtl a" ).append("\n"); 
		query.append("WHERE a.cop_no = cop.cop_no" ).append("\n"); 
		query.append("AND a.act_cd IN('FLWMLO', 'FLVMLO')" ).append("\n"); 
		query.append("AND a.vsl_cd IS NOT NULL" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND mst.rout_org_nod_cd = dtl.rout_org_nod_cd(+)" ).append("\n"); 
		query.append("AND mst.rout_dest_nod_cd = dtl.rout_dest_nod_cd(+)" ).append("\n"); 
		query.append("AND mst.rout_seq = dtl.rout_seq(+)" ).append("\n"); 
		query.append("AND mst.pctl_io_bnd_cd != 'M'" ).append("\n"); 
		query.append("AND NVL(mst.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("AND mst.wrs_full_cmdt_cd IS NOT NULL" ).append("\n"); 
		query.append("AND cop.bkg_no = bkg.bkg_no" ).append("\n"); 
		query.append("AND mst.rout_org_nod_cd = prd.nod_cd" ).append("\n"); 
		query.append("GROUP BY mst.rout_org_nod_cd" ).append("\n"); 
		query.append(",mst.rout_dest_nod_cd" ).append("\n"); 
		query.append(",mst.rout_seq" ).append("\n"); 
		query.append(",mst.prio_seq" ).append("\n"); 
		query.append(",DECODE(act.pctl_io_bnd_cd, 'I', bkg.de_term_cd, 'O', bkg.rcv_term_cd, '')" ).append("\n"); 
		query.append(",prd.nod_tp_cd" ).append("\n"); 
		query.append(") x" ).append("\n"); 
		query.append("WHERE disp_flag = 'Y'" ).append("\n"); 
		query.append("ORDER BY x.rout_org_nod_cd, x.rout_dest_nod_cd, x.prio_seq, x.rout_seq" ).append("\n"); 

	}
}