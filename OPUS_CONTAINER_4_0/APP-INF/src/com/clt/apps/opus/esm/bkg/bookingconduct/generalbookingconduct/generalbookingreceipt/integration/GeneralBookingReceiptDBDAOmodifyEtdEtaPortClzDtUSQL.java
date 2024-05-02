/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyEtdEtaPortClzDtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOmodifyEtdEtaPortClzDtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyEtdEtaPortClzDtUSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyEtdEtaPortClzDtUSQL").append("\n"); 
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
		query.append("update bkg_booking" ).append("\n"); 
		query.append("set (POL_ETD_DT, POD_ETA_DT)" ).append("\n"); 
		query.append("= (SELECT VPS_ETD_DT, VPS_ETA_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(select vps_etd_dt" ).append("\n"); 
		query.append("from bkg_vvd vvd, vsk_vsl_port_skd skd" ).append("\n"); 
		query.append("where vvd.vsl_cd          = skd.vsl_cd" ).append("\n"); 
		query.append("and vvd.skd_voy_no      = skd.skd_voy_no" ).append("\n"); 
		query.append("and vvd.skd_dir_cd      = skd.skd_dir_cd" ).append("\n"); 
		query.append("and vvd.pol_cd          = skd.vps_port_cd" ).append("\n"); 
		query.append("and vvd.pol_CLPT_IND_SEQ= skd.CLPT_IND_SEQ" ).append("\n"); 
		query.append("and vvd.bkg_no          = @[bkg_no]" ).append("\n"); 
		query.append("and rownum =1" ).append("\n"); 
		query.append("order by bkg_no, vsl_pre_pst_cd)" ).append("\n"); 
		query.append(", (select vps_etA_dt" ).append("\n"); 
		query.append("from bkg_vvd vvd, vsk_vsl_port_skd skd" ).append("\n"); 
		query.append("where vvd.vsl_cd          = skd.vsl_cd" ).append("\n"); 
		query.append("and vvd.skd_voy_no      = skd.skd_voy_no" ).append("\n"); 
		query.append("and vvd.skd_dir_cd      = skd.skd_dir_cd" ).append("\n"); 
		query.append("and vvd.pod_cd          = skd.vps_port_cd" ).append("\n"); 
		query.append("and vvd.pod_CLPT_IND_SEQ= skd.CLPT_IND_SEQ" ).append("\n"); 
		query.append("and vvd.bkg_no          = @[bkg_no]" ).append("\n"); 
		query.append("and rownum =1" ).append("\n"); 
		query.append("order by bkg_no, vsl_pre_pst_cd desc)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 

	}
}