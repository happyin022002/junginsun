/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.27 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Woo-Seok
 * @see 
 * @since J2EE 1.4
 */

public class TCharIODeliveryScheduleDAOFmsNewBldSkdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NB Delivery Schedule Creation Select
	  * </pre>
	  */
	public TCharIODeliveryScheduleDAOFmsNewBldSkdRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd_size2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_de_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd_size1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_de_dt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "2,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select A.shp_de_seq," ).append("\n"); 
		query.append("A.shp_nm," ).append("\n"); 
		query.append("A.shp_bld_nm," ).append("\n"); 
		query.append("A.vsl_dznd_capa," ).append("\n"); 
		query.append("A.bse_14ton_vsl_capa," ).append("\n"); 
		query.append("A.rf_cntr_plg_qty," ).append("\n"); 
		query.append("A.shp_spd_qty," ).append("\n"); 
		query.append("A.flet_ctrt_dur_ctnt," ).append("\n"); 
		query.append("A.trd_hus_nm," ).append("\n"); 
		query.append("A.vsl_de_dt," ).append("\n"); 
		query.append("A.yd_seq," ).append("\n"); 
		query.append("B.shp_yd_nm," ).append("\n"); 
		query.append("A.ownr_seq," ).append("\n"); 
		query.append("C.ownr_nm" ).append("\n"); 
		query.append("from fms_new_bld_skd A," ).append("\n"); 
		query.append("fms_shp_yd B," ).append("\n"); 
		query.append("fms_owner C" ).append("\n"); 
		query.append("where A.yd_seq = B.yd_seq" ).append("\n"); 
		query.append("and A.ownr_seq = C.ownr_seq" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${period_flag} == 'date')" ).append("\n"); 
		query.append("and A.vsl_de_dt >= @[vsl_de_dt1]" ).append("\n"); 
		query.append("and A.vsl_de_dt <= @[vsl_de_dt2]" ).append("\n"); 
		query.append("#elseif (${period_flag} == 'month')" ).append("\n"); 
		query.append("and substr(A.vsl_de_dt,1,6) >= @[vsl_de_dt1]" ).append("\n"); 
		query.append("and substr(A.vsl_de_dt,1,6) <= @[vsl_de_dt2]" ).append("\n"); 
		query.append("#elseif (${period_flag} == 'year')" ).append("\n"); 
		query.append("and substr(A.vsl_de_dt,1,4) >= @[vsl_de_dt1]" ).append("\n"); 
		query.append("and substr(A.vsl_de_dt,1,4) <= @[vsl_de_dt2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${yd_seq} != '')" ).append("\n"); 
		query.append("and A.yd_seq = @[yd_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ownr_seq} != '')" ).append("\n"); 
		query.append("and A.ownr_seq = @[ownr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd_size_flag} == 'max')" ).append("\n"); 
		query.append("and A.vsl_dznd_capa >= @[vsl_cd_size1]" ).append("\n"); 
		query.append("and A.vsl_dznd_capa <= @[vsl_cd_size2]" ).append("\n"); 
		query.append("#elseif (${vsl_cd_size_flag} == '14ton')" ).append("\n"); 
		query.append("and A.bse_14ton_vsl_capa >= @[vsl_cd_size1]" ).append("\n"); 
		query.append("and A.bse_14ton_vsl_capa <= @[vsl_cd_size2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${shp_nm} != '')" ).append("\n"); 
		query.append("and lower(A.shp_nm) like '%' || lower(@[shp_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("order by A.shp_bld_nm" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.integration").append("\n"); 
		query.append("FileName : TCharIODeliveryScheduleDAOFmsNewBldSkdRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}