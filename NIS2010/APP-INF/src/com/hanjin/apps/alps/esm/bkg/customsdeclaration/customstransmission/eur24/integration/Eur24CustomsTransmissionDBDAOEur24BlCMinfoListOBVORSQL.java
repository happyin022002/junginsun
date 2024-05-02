/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOEur24BlCMinfoListOBVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.05
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.08.05 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOEur24BlCMinfoListOBVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOEur24BlCMinfoListOBVORSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOEur24BlCMinfoListOBVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOEur24BlCMinfoListOBVORSQL").append("\n"); 
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
		query.append("/* Eur24BlCMinfoListOB  VO */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" ' ' AS vsl_cd" ).append("\n"); 
		query.append(", ' ' AS handle_info" ).append("\n"); 
		query.append(", ' ' AS cre_dt" ).append("\n"); 
		query.append(", ' ' AS bl_no" ).append("\n"); 
		query.append(", ' ' AS pkg_count" ).append("\n"); 
		query.append(", ' ' AS cm_cntr_no" ).append("\n"); 
		query.append(", ' ' AS meas_qty" ).append("\n"); 
		query.append(", ' ' AS pck_qty" ).append("\n"); 
		query.append(", ' ' AS item_gross_wgt" ).append("\n"); 
		query.append(", ' ' AS pck_tp_cd" ).append("\n"); 
		query.append(", ' ' AS pkg_type" ).append("\n"); 
		query.append(", ' ' AS upd_usr_id" ).append("\n"); 
		query.append(", ' ' AS cstms_port_cd" ).append("\n"); 
		query.append(", ' ' AS handle_cd" ).append("\n"); 
		query.append(", ' ' AS upd_dt" ).append("\n"); 
		query.append(", ' ' AS undg_no" ).append("\n"); 
		query.append(", ' ' AS cm_ship_mark" ).append("\n"); 
		query.append(", ' ' AS skd_voy_no" ).append("\n"); 
		query.append(", ' ' AS tariff_cd" ).append("\n"); 
		query.append(", ' ' AS cntr_mf_mk_desc" ).append("\n"); 
		query.append(", ' ' AS skd_dir_cd" ).append("\n"); 
		query.append(", ' ' AS cntr_cgo_seq" ).append("\n"); 
		query.append(", ' ' AS cre_usr_id" ).append("\n"); 
		query.append(", ' ' AS cm_cntr_pkg" ).append("\n"); 
		query.append(", ' ' AS cntr_no" ).append("\n"); 
		query.append(", ' ' AS cntr_mf_gds_desc" ).append("\n"); 
		query.append(", ' ' AS piece_count" ).append("\n"); 
		query.append(", ' ' AS goods_desc" ).append("\n"); 
		query.append(", ' ' AS goods_item_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS cm_flag" ).append("\n"); 
		query.append(", ' ' AS mf_itm_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}