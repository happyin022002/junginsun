/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchCodTsRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.10.07 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimByungKyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchCodTsRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cod ts route 조회
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchCodTsRouteRSQL(){
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
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchCodTsRouteRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("vsl_cd_seq" ).append("\n"); 
		query.append(",pol_cd" ).append("\n"); 
		query.append(",pol_yd_cd" ).append("\n"); 
		query.append(",pod_cd" ).append("\n"); 
		query.append(",pod_yd_cd" ).append("\n"); 
		query.append(",vvd" ).append("\n"); 
		query.append(",slan_cd" ).append("\n"); 
		query.append(",etd" ).append("\n"); 
		query.append(",etd_time" ).append("\n"); 
		query.append(",eta" ).append("\n"); 
		query.append(",eta_time" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select level seq" ).append("\n"); 
		query.append("from   dual" ).append("\n"); 
		query.append("connect by level <= 5" ).append("\n"); 
		query.append(") v1," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select VVD.BKG_NO" ).append("\n"); 
		query.append(", decode(vvd.vsl_pre_pst_cd,'S','PRE'||vvd.vsl_seq,'T','TRUNK','U','POST'||vvd.vsl_seq) vsl_cd_seq" ).append("\n"); 
		query.append(", vvd.vsl_seq" ).append("\n"); 
		query.append(", vvd.vsl_cd||vvd.skd_voy_no||vvd.skd_dir_cd vvd" ).append("\n"); 
		query.append(", substr(vvd.pol_yd_cd, 1, 5) pol_cd" ).append("\n"); 
		query.append(", substr(vvd.pol_yd_cd,6,2) pol_yd_cd" ).append("\n"); 
		query.append(", substr(vvd.pod_yd_cd, 1, 5) pod_cd" ).append("\n"); 
		query.append(", substr(vvd.pod_yd_cd,6,2) pod_yd_cd" ).append("\n"); 
		query.append(", vvd.slan_cd" ).append("\n"); 
		query.append(", to_char(vps_etd.vps_etd_dt,'yyyy-mm-dd') etd" ).append("\n"); 
		query.append(", to_char(vps_etd.vps_etd_dt,'hh24:mi') etd_time" ).append("\n"); 
		query.append(", to_char(vps_eta.vps_eta_dt,'yyyy-mm-dd') eta" ).append("\n"); 
		query.append(", to_char(vps_eta.vps_eta_dt,'hh24:mi') eta_time" ).append("\n"); 
		query.append(", rownum seq" ).append("\n"); 
		query.append("from bkg_cod_vvd vvd, vsk_vsl_port_skd vps_eta, vsk_vsl_port_skd vps_etd" ).append("\n"); 
		query.append("where vvd.vsl_cd                   = vps_etd.vsl_cd" ).append("\n"); 
		query.append("and vvd.skd_voy_no               = vps_etd.skd_voy_no" ).append("\n"); 
		query.append("and vvd.skd_dir_cd               = vps_etd.skd_dir_cd" ).append("\n"); 
		query.append("and substr(vvd.pol_yd_cd, 1, 5)  = vps_etd.vps_port_cd" ).append("\n"); 
		query.append("and nvl(vvd.pol_clpt_ind_seq,1)         = vps_etd.clpt_ind_seq" ).append("\n"); 
		query.append("and vvd.vsl_cd                   = vps_eta.vsl_cd" ).append("\n"); 
		query.append("and vvd.skd_voy_no               = vps_eta.skd_voy_no" ).append("\n"); 
		query.append("and vvd.skd_dir_cd               = vps_eta.skd_dir_cd" ).append("\n"); 
		query.append("and substr(vvd.pod_yd_cd, 1, 5)  = vps_eta.vps_port_cd" ).append("\n"); 
		query.append("and nvl(vvd.pod_clpt_ind_seq,1)         = vps_eta.clpt_ind_seq" ).append("\n"); 
		query.append("and vvd.bkg_no     = @[bkg_no]" ).append("\n"); 
		query.append("and vvd.cod_rqst_seq     = @[cod_rqst_seq]" ).append("\n"); 
		query.append("and vvd.vvd_op_cd  = @[op_cd]" ).append("\n"); 
		query.append("order by VVD.BKG_NO,vvd.vsl_pre_pst_cd, vvd.vsl_seq" ).append("\n"); 
		query.append(") v2" ).append("\n"); 
		query.append("where v1.seq = v2.seq(+)" ).append("\n"); 

	}
}