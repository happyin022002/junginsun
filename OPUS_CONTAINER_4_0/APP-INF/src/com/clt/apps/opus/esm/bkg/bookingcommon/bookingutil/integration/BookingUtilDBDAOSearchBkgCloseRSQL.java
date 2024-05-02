/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchBkgCloseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchBkgCloseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 vvd, pol이 close되었는지 확인하고 g/w 메일에 보여질 내용을 조회한다.
	  * </pre>
	  */
	public BookingUtilDBDAOSearchBkgCloseRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchBkgCloseRSQL").append("\n"); 
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
		query.append("select pre_vvd.bkg_no" ).append("\n"); 
		query.append(", pre_vvd.pre_vvd" ).append("\n"); 
		query.append(", pre_vvd.pre_pol_cd" ).append("\n"); 
		query.append(", pre_vvd.pre_pol_yd_cd" ).append("\n"); 
		query.append(", pre_vvd.pre_pod_cd" ).append("\n"); 
		query.append(", pre_vvd.pre_pod_yd_cd" ).append("\n"); 
		query.append(", new_vvd.new_vvd" ).append("\n"); 
		query.append(", new_vvd.por_cd" ).append("\n"); 
		query.append(", new_vvd.new_pol_cd" ).append("\n"); 
		query.append(", new_vvd.new_pol_yd_cd" ).append("\n"); 
		query.append(", new_vvd.new_pod_cd" ).append("\n"); 
		query.append(", new_vvd.new_pod_yd_cd" ).append("\n"); 
		query.append(", new_vvd.pod_cd" ).append("\n"); 
		query.append(", new_vvd.del_cd" ).append("\n"); 
		query.append(", close_vvd.close_vvd" ).append("\n"); 
		query.append(", close_vvd.close_pol_cd" ).append("\n"); 
		query.append(", close_vvd.close_pol_yd_cd" ).append("\n"); 
		query.append(", close_vvd.close_pod_cd" ).append("\n"); 
		query.append(", close_vvd.close_pod_yd_cd" ).append("\n"); 
		query.append(", BKG_JOIN_FNC( CURSOR(SELECT CNTR_TPSZ_CD||' X '||ltrim(TO_CHAR(NVL(OP_CNTR_QTY, 0),'990.99'))" ).append("\n"); 
		query.append("FROM BKG_QUANTITY old_qty" ).append("\n"); 
		query.append("WHERE pre_vvd.bkg_no = old_qty.bkg_no(+))) old_qty_vol" ).append("\n"); 
		query.append(", '' new_qty_vol" ).append("\n"); 
		query.append(", replace(BKG_JOIN_FNC(CURSOR(SELECT cntr_no" ).append("\n"); 
		query.append("FROM bkg_container cntr" ).append("\n"); 
		query.append("WHERE pre_vvd.bkg_no = cntr.bkg_no(+))), ',', ', ') cntr_list" ).append("\n"); 
		query.append(", '' new_cntr_list" ).append("\n"); 
		query.append("from (select 1 NO, bk.bkg_no, vvd.vsl_cd||vvd.skd_voy_no||vvd.skd_dir_Cd pre_vvd" ).append("\n"); 
		query.append(", vvd.pol_cd pre_pol_cd, vvd.pol_yd_cd pre_pol_yd_cd" ).append("\n"); 
		query.append(", vvd.pod_cd pre_pod_cd, vvd.pod_yd_cd pre_pod_yd_cd" ).append("\n"); 
		query.append("from bkg_booking bk, bkg_vvd vvd" ).append("\n"); 
		query.append("where bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("and bk.pol_cd = vvd.pol_cd" ).append("\n"); 
		query.append("and vvd.vsl_pre_pst_cd in ('S', 'T')" ).append("\n"); 
		query.append("and bk.bkg_no = @[bkg_no]) pre_vvd," ).append("\n"); 
		query.append("(select 1 NO, dtl.vsl_cd||dtl.skd_voy_no||dtl.skd_dir_Cd new_vvd" ).append("\n"); 
		query.append(", substr(dtl.org_nod_cd,  1, 5)  new_pol_cd" ).append("\n"); 
		query.append(", dtl.dest_nod_cd                new_pol_yd_cd" ).append("\n"); 
		query.append(", substr(dtl.dest_nod_cd,  1, 5) new_pod_cd" ).append("\n"); 
		query.append(", dtl.org_nod_cd                 new_pod_yd_cd" ).append("\n"); 
		query.append(", mst.por_cd" ).append("\n"); 
		query.append(", mst.pol_cd" ).append("\n"); 
		query.append(", mst.pod_cd" ).append("\n"); 
		query.append(", mst.del_cd" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl dtl, prd_prod_ctl_mst mst" ).append("\n"); 
		query.append("where mst.pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("and mst.pctl_no = dtl.pctl_no" ).append("\n"); 
		query.append("and (dtl.pctl_no, pctl_seq) =" ).append("\n"); 
		query.append("(select vvd.pctl_no, min(vvd.pctl_seq) pctl_seq" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl vvd" ).append("\n"); 
		query.append("where vvd.pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("and vvd.TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("group by vvd.pctl_no)) new_vvd," ).append("\n"); 
		query.append("(select 1 NO, old_new_vvd.vsl_cd||old_new_vvd.skd_voy_no||old_new_vvd.skd_dir_cd close_vvd" ).append("\n"); 
		query.append(", old_new_vvd.pol_cd    close_pol_cd" ).append("\n"); 
		query.append(", old_new_vvd.pol_yd_cd close_pol_yd_cd" ).append("\n"); 
		query.append(", old_new_vvd.pod_cd    close_pod_cd" ).append("\n"); 
		query.append(", old_new_vvd.pod_yd_cd close_pod_yd_cd" ).append("\n"); 
		query.append("from (select bk.bkg_no ref_no, vvd.vsl_cd, vvd.skd_voy_no, vvd.skd_dir_Cd" ).append("\n"); 
		query.append(", vvd.pol_cd, vvd.pol_yd_cd, vvd.pol_clpt_ind_seq" ).append("\n"); 
		query.append(", vvd.pod_cd, vvd.pod_yd_cd, vvd.pod_clpt_ind_seq" ).append("\n"); 
		query.append("from bkg_booking bk, bkg_vvd vvd" ).append("\n"); 
		query.append("where bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("and bk.pol_cd = vvd.pol_cd" ).append("\n"); 
		query.append("and vvd.vsl_pre_pst_cd in ('S', 'T')" ).append("\n"); 
		query.append("and bk.bkg_no =@[bkg_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("select pctl_no ref_no, dtl.vsl_cd, dtl.skd_voy_no, dtl.skd_dir_Cd" ).append("\n"); 
		query.append(", substr(dtl.org_nod_cd,  1, 5) pol_cd,  dtl.org_nod_cd  pol_yd_cd, ORG_CLPT_IND_SEQ  pol_clpt_ind_seq" ).append("\n"); 
		query.append(", substr(dtl.dest_nod_cd,  1, 5) pod_cd, dtl.dest_nod_cd pod_yd_cd, DEST_CLPT_IND_SEQ pod_clpt_ind_seq" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append("where (dtl.pctl_no, pctl_seq) =" ).append("\n"); 
		query.append("(select vvd.pctl_no, min(vvd.pctl_seq) pctl_seq" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl vvd" ).append("\n"); 
		query.append("where vvd.pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("and vvd.TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("group by vvd.pctl_no)" ).append("\n"); 
		query.append(") old_new_vvd, BKG_COFF_TM coff" ).append("\n"); 
		query.append("where coff.vsl_cd                        = old_new_vvd.vsl_cd" ).append("\n"); 
		query.append("and coff.skd_voy_no  = old_new_vvd.skd_voy_no" ).append("\n"); 
		query.append("and coff.skd_dir_cd  = old_new_vvd.skd_dir_cd" ).append("\n"); 
		query.append("and coff.pol_cd      = old_new_vvd.pol_cd" ).append("\n"); 
		query.append("and coff.clpt_ind_seq= old_new_vvd.pol_clpt_ind_seq" ).append("\n"); 
		query.append("and coff.bkg_ofc_cd  = @[ofc_cd]" ).append("\n"); 
		query.append("and coff.BKG_CLZ_STS_CD = 'C'" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 
		query.append(") close_vvd" ).append("\n"); 
		query.append("WHERE CLOSE_VVD.NO = PRE_VVD.NO(+)" ).append("\n"); 
		query.append("AND CLOSE_VVD.NO = NEW_VVD.NO(+)" ).append("\n"); 

	}
}