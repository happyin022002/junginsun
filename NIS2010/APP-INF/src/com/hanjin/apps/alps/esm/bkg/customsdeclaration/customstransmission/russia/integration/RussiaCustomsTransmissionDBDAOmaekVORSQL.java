/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RussiaCustomsTransmissionDBDAOmaekVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RussiaCustomsTransmissionDBDAOmaekVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Make VO
	  * </pre>
	  */
	public RussiaCustomsTransmissionDBDAOmaekVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration").append("\n"); 
		query.append("FileName : RussiaCustomsTransmissionDBDAOmaekVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("''pol_nm                    " ).append("\n"); 
		query.append(",''blpkgu                    " ).append("\n"); 
		query.append(",''bl_pod_eta_dt             " ).append("\n"); 
		query.append(",''bldel                     " ).append("\n"); 
		query.append(",''desc1                     " ).append("\n"); 
		query.append(",''goodno                                     " ).append("\n"); 
		query.append(",''bl_iss_dt                 " ).append("\n"); 
		query.append(",''bkg_pod_cd                " ).append("\n"); 
		query.append(",''blmea                     " ).append("\n"); 
		query.append(",''trans_ind                 " ).append("\n"); 
		query.append(",''issue_loc_name            " ).append("\n"); 
		query.append(",''bl_iss_loc_cd " ).append("\n"); 
		query.append(",''bl_iss_loc_nm             " ).append("\n"); 
		query.append(",''prflag                    " ).append("\n"); 
		query.append(",''bldelname                 " ).append("\n"); 
		query.append(",''cnee5                     " ).append("\n"); 
		query.append(",''cnee3                     " ).append("\n"); 
		query.append(",''cnee4                     " ).append("\n"); 
		query.append(",''del_cd                    " ).append("\n"); 
		query.append(",''cnee1                     " ).append("\n"); 
		query.append(",''cnee2                     " ).append("\n"); 
		query.append(",''loc_nm                    " ).append("\n"); 
		query.append(",''rd_term                   " ).append("\n"); 
		query.append(",''bkg_no                    " ).append("\n"); 
		query.append(",''por_nm                    " ).append("\n"); 
		query.append(",''boarddate                 " ).append("\n"); 
		query.append(",''blpod                     " ).append("\n"); 
		query.append(",''issuedate                 " ).append("\n"); 
		query.append(",''s_cust_addr               " ).append("\n"); 
		query.append(",''blnbr                     " ).append("\n"); 
		query.append(",''por_cd                    " ).append("\n"); 
		query.append(",''mark4                     " ).append("\n"); 
		query.append(",''mark3                     " ).append("\n"); 
		query.append(",''blpkg                     " ).append("\n"); 
		query.append(",''reefer_ind                " ).append("\n"); 
		query.append(",''vps_etb_dt                " ).append("\n"); 
		query.append(",''mark2                     " ).append("\n"); 
		query.append(",''blpod_eta                 " ).append("\n"); 
		query.append(",''blpor                     " ).append("\n"); 
		query.append(",''mark1                     " ).append("\n"); 
		query.append(",''c_cust_nm                 " ).append("\n"); 
		query.append(",''blpol                     " ).append("\n"); 
		query.append(",''n_cust_addr               " ).append("\n"); 
		query.append(",''mark5                                         " ).append("\n"); 
		query.append(",''c_cust_addr               " ).append("\n"); 
		query.append(",''cstms_desc                " ).append("\n"); 
		query.append(",''meas_qty                  " ).append("\n"); 
		query.append(",''reefer                    " ).append("\n"); 
		query.append(",''pck_qty                   " ).append("\n"); 
		query.append(",''n_cust_nm                 " ).append("\n"); 
		query.append(",''pck_tp_cd                 " ).append("\n"); 
		query.append(",''runit                     " ).append("\n"); 
		query.append(",''blpkgu_nm                 " ).append("\n"); 
		query.append(",''bkg_pol_cd                " ).append("\n"); 
		query.append(",''pod_nm                    " ).append("\n"); 
		query.append(",''s_cust_nm                 " ).append("\n"); 
		query.append(",''blpodname                 " ).append("\n"); 
		query.append(",''del_nm                                   " ).append("\n"); 
		query.append(",''issue_loc                 " ).append("\n"); 
		query.append(",''shpr2                     " ).append("\n"); 
		query.append(",''shpr1                     " ).append("\n"); 
		query.append(",''blwgt                     " ).append("\n"); 
		query.append(",''shpr5                     " ).append("\n"); 
		query.append(",''blporname                 " ).append("\n"); 
		query.append(",''blpolname                 " ).append("\n"); 
		query.append(",''shpr4                     " ).append("\n"); 
		query.append(",''act_wgt                   " ).append("\n"); 
		query.append(",''shpr3                     " ).append("\n"); 
		query.append(",''ntfy5                     " ).append("\n"); 
		query.append(",''ntfy4                     " ).append("\n"); 
		query.append(",''ntfy3                     " ).append("\n"); 
		query.append(",''ntfy2                     " ).append("\n"); 
		query.append(",''ntfy1                     " ).append("\n"); 
		query.append(",''bl_mk_desc    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         " ).append("\n"); 

	}
}