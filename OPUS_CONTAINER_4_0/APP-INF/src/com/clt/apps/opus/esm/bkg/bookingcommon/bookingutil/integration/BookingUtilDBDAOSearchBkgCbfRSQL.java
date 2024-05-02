/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchBkgCbfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.04 
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

public class BookingUtilDBDAOSearchBkgCbfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBkgCbf
	  * 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
	  * </pre>
	  */
	public BookingUtilDBDAOSearchBkgCbfRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchBkgCbfRSQL").append("\n"); 
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
		query.append(", BKG_JOIN_FNC( CURSOR(SELECT CNTR_TPSZ_CD||' X '||ltrim(TO_CHAR(NVL(OP_CNTR_QTY, 0),'990.99'))" ).append("\n"); 
		query.append("FROM BKG_QUANTITY old_qty" ).append("\n"); 
		query.append("WHERE pre_vvd.bkg_no = old_qty.bkg_no(+))) old_qty_vol" ).append("\n"); 
		query.append(", '' new_qty_vol" ).append("\n"); 
		query.append(", replace(BKG_JOIN_FNC(CURSOR(SELECT cntr_no" ).append("\n"); 
		query.append("FROM bkg_container cntr" ).append("\n"); 
		query.append("WHERE pre_vvd.bkg_no = cntr.bkg_no(+))), ',', ', ') cntr_list" ).append("\n"); 
		query.append(", '' new_cntr_list" ).append("\n"); 
		query.append(", pre_vvd.pre_pol_yd_cd||pre_vvd.POL_CLPT_IND_SEQ AS PRE_YD_CD_SEQ" ).append("\n"); 
		query.append(", new_vvd.new_pol_yd_cd||new_vvd.ORG_CLPT_IND_SEQ AS NEW_YD_CD_SEQ" ).append("\n"); 
		query.append("from (select 1 NO, bk.bkg_no, vvd.vsl_cd||vvd.skd_voy_no||vvd.skd_dir_Cd pre_vvd" ).append("\n"); 
		query.append(", vvd.pol_cd pre_pol_cd, vvd.pol_yd_cd pre_pol_yd_cd" ).append("\n"); 
		query.append(", vvd.pod_cd pre_pod_cd, vvd.pod_yd_cd pre_pod_yd_cd" ).append("\n"); 
		query.append(", MIN(vvd.POL_CLPT_IND_SEQ) POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("from bkg_booking bk, bkg_vvd vvd" ).append("\n"); 
		query.append("where bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("and bk.pol_cd = vvd.pol_cd" ).append("\n"); 
		query.append("and vvd.vsl_pre_pst_cd in ('S', 'T')" ).append("\n"); 
		query.append("and bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("GROUP BY bk.bkg_no, vvd.vsl_cd||vvd.skd_voy_no||vvd.skd_dir_Cd" ).append("\n"); 
		query.append(", vvd.pol_cd, vvd.pol_yd_cd" ).append("\n"); 
		query.append(", vvd.pod_cd, vvd.pod_yd_cd) pre_vvd FULL OUTER JOIN" ).append("\n"); 
		query.append("(select 1 NO, dtl.vsl_cd||dtl.skd_voy_no||dtl.skd_dir_Cd new_vvd" ).append("\n"); 
		query.append(", substr(dtl.org_nod_cd,  1, 5)  new_pol_cd" ).append("\n"); 
		query.append(", dtl.org_nod_cd                 new_pol_yd_cd" ).append("\n"); 
		query.append(", substr(dtl.dest_nod_cd,  1, 5) new_pod_cd" ).append("\n"); 
		query.append(", dtl.dest_nod_cd                new_pod_yd_cd" ).append("\n"); 
		query.append(", mst.por_cd" ).append("\n"); 
		query.append(", mst.pol_cd" ).append("\n"); 
		query.append(", mst.pod_cd" ).append("\n"); 
		query.append(", mst.del_cd" ).append("\n"); 
		query.append(", dtl.ORG_CLPT_IND_SEQ" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl dtl, prd_prod_ctl_mst mst" ).append("\n"); 
		query.append("where mst.pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("and mst.pctl_no = dtl.pctl_no" ).append("\n"); 
		query.append("and (dtl.pctl_no, pctl_seq) =" ).append("\n"); 
		query.append("(select vvd.pctl_no, min(vvd.pctl_seq) pctl_seq" ).append("\n"); 
		query.append("from prd_prod_ctl_rout_dtl vvd" ).append("\n"); 
		query.append("where vvd.pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("and vvd.TRSP_MOD_CD in ('VD', 'WD')" ).append("\n"); 
		query.append("group by vvd.pctl_no)) new_vvd" ).append("\n"); 
		query.append("on pre_vvd.no = new_vvd.no" ).append("\n"); 

	}
}