/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSASpecialManifestDBDAOPSACntrBaseInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.11.15 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOPSACntrBaseInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSASpecialManifestDBDAOPSACntrBaseInfoRSQL
	  * </pre>
	  */
	public PSASpecialManifestDBDAOPSACntrBaseInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOPSACntrBaseInfoRSQL").append("\n"); 
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
		query.append("'' cntrts_cd" ).append("\n"); 
		query.append(",'' sub_id_type" ).append("\n"); 
		query.append(",'' sub_address2" ).append("\n"); 
		query.append(",'' b_bkg_id_type" ).append("\n"); 
		query.append(",'' sub_address3" ).append("\n"); 
		query.append(",'' sub_address1" ).append("\n"); 
		query.append(",'' pod_bkg_loc" ).append("\n"); 
		query.append(",'' b_bkg_id" ).append("\n"); 
		query.append(",'' sub_mode" ).append("\n"); 
		query.append(",'' sub_authorized" ).append("\n"); 
		query.append(",'' bl_no" ).append("\n"); 
		query.append(",'' pod_bkg_loc_type" ).append("\n"); 
		query.append(",'' sub_contact" ).append("\n"); 
		query.append(",'' sub_means_type" ).append("\n"); 
		query.append(",'' sub_phone" ).append("\n"); 
		query.append(",'' vvd_cd" ).append("\n"); 
		query.append(",'' sub_nation" ).append("\n"); 
		query.append(",'' d_type" ).append("\n"); 
		query.append(",'' sub_party_type" ).append("\n"); 
		query.append(",'' l_bkg_id_type" ).append("\n"); 
		query.append(",'' port_cd" ).append("\n"); 
		query.append(",'' bkg_date_type" ).append("\n"); 
		query.append(",'' sub_name" ).append("\n"); 
		query.append(",'' iso" ).append("\n"); 
		query.append(",'' sub_id" ).append("\n"); 
		query.append(",'' sub_vvd" ).append("\n"); 
		query.append(",'' bkg_date" ).append("\n"); 
		query.append(",'' sub_ref" ).append("\n"); 
		query.append(",'' sub_party_id" ).append("\n"); 
		query.append(",'' pol_bkg_loc_type" ).append("\n"); 
		query.append(",'' sub_fax" ).append("\n"); 
		query.append(",'' sub_license" ).append("\n"); 
		query.append(",'' sub_ssr" ).append("\n"); 
		query.append(",'' cntr_no" ).append("\n"); 
		query.append(",'' sub_address5" ).append("\n"); 
		query.append(",'' pol_bkg_loc" ).append("\n"); 
		query.append(",'' imex" ).append("\n"); 
		query.append(",'' sub_address4" ).append("\n"); 
		query.append(",'' l_bkg_id" ).append("\n"); 
		query.append(",'' p_bound_cd" ).append("\n"); 
		query.append(",'' p_pol_cd" ).append("\n"); 
		query.append(",'' p_pod_cd" ).append("\n"); 
		query.append(",'' usr_id" ).append("\n"); 
		query.append(",'' msg_snd_no" ).append("\n"); 
		query.append(",'' BKG_CGO_TP_CD" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}