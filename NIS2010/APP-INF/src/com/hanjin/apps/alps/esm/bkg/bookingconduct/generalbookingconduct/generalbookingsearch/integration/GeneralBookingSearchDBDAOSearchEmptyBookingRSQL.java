/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchEmptyBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.03 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchEmptyBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty Booking 정보 조회
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchEmptyBookingRSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchEmptyBookingRSQL").append("\n"); 
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
		query.append("select bk.bkg_no" ).append("\n"); 
		query.append(", bk.bl_no" ).append("\n"); 
		query.append(", bk.bl_no_tp" ).append("\n"); 
		query.append(", bk.bl_tp_cd" ).append("\n"); 
		query.append(", bk.vsl_cd" ).append("\n"); 
		query.append(", bk.skd_voy_no" ).append("\n"); 
		query.append(", bk.skd_dir_cd" ).append("\n"); 
		query.append(", bk.vsl_cd||bk.skd_voy_no||bk.skd_dir_cd bkg_trunk_vvd" ).append("\n"); 
		query.append(", bk.sls_rhq_cd" ).append("\n"); 
		query.append(", bk.mty_pkup_yd_cd org_yd_cd" ).append("\n"); 
		query.append(", rt.cgo_rcv_dt" ).append("\n"); 
		query.append(", to_char(cntr.cnmv_evnt_dt ,'yyyymmdd hh24:mi') cnmv_evnt_dt" ).append("\n"); 
		query.append(", to_char(bk.bkg_cre_dt, 'yyyy-mm-dd') bkg_cre_dt" ).append("\n"); 
		query.append(", bk.pol_cd bkg_pol_cd" ).append("\n"); 
		query.append(", bk.pod_cd bkg_pod_cd" ).append("\n"); 
		query.append(", bk.mty_bkg_sts_cd" ).append("\n"); 
		query.append(", bk.bkg_sts_cd" ).append("\n"); 
		query.append(", vvd.pol_cd" ).append("\n"); 
		query.append(", vvd.pod_cd" ).append("\n"); 
		query.append(", bk.split_flg" ).append("\n"); 
		query.append(", trim(bk.inter_rmk) inter_rmk" ).append("\n"); 
		query.append("from bkg_booking bk" ).append("\n"); 
		query.append(", bkg_vvd vvd" ).append("\n"); 
		query.append(", bkg_rate rt" ).append("\n"); 
		query.append(", bkg_container cntr" ).append("\n"); 
		query.append("where bk.bkg_no = rt.bkg_no(+)" ).append("\n"); 
		query.append("and   bk.bkg_no = cntr.bkg_no(+)" ).append("\n"); 
		query.append("and   bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("and   vvd.vsl_pre_pst_cd = 'T'" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND    bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    bk.bl_no = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and   bk.bkg_cgo_tp_cd = 'P'" ).append("\n"); 
		query.append("and   rownum = 1" ).append("\n"); 

	}
}