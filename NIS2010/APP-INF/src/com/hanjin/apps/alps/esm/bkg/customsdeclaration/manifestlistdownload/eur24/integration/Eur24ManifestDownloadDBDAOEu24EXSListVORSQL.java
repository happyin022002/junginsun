/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOEu24EXSListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.30
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.08.30 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOEu24EXSListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EXS Monitor화면용 (UI_BKG_1152) VO
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOEu24EXSListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOEu24EXSListVORSQL").append("\n"); 
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
		query.append("SELECT '' vvd" ).append("\n"); 
		query.append("     , '' lane" ).append("\n"); 
		query.append("     , '' eu_pol" ).append("\n"); 
		query.append("     , '' bkg_pol" ).append("\n"); 
		query.append("     , '' ofc_cd " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , '' bl_tot_cnt" ).append("\n"); 
		query.append("     , '' exs_snt_cnt" ).append("\n"); 
		query.append("     , '' exs_snt_accp" ).append("\n"); 
		query.append("     , '' exs_snt_rejt" ).append("\n"); 
		query.append("     , '' exs_snt_donl" ).append("\n"); 
		query.append("     , '' exs_snt_nrcv" ).append("\n"); 
		query.append("     , '' exs_snt_hold" ).append("\n"); 
		query.append("     , '' exs_snt_rels" ).append("\n"); 
		query.append("     , '' exs_unsnt_cnt" ).append("\n"); 
		query.append("     , '' exs_amd_cnt" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , '' sent_bl_cnt " ).append("\n"); 
		query.append("     , '' acc_bl_cnt " ).append("\n"); 
		query.append("     , '' rej_bl_cnt " ).append("\n"); 
		query.append("     , '' donld_bl_cnt " ).append("\n"); 
		query.append("     , '' nrcv_bl_cnt" ).append("\n"); 
		query.append("     , '' hold_bl_cnt" ).append("\n"); 
		query.append("     , '' rels_bl_cnt" ).append("\n"); 
		query.append("     , '' unsent_bl_cnt " ).append("\n"); 
		query.append("     , '' total_bl_cnt " ).append("\n"); 
		query.append("     , '' total_vvd_cnt" ).append("\n"); 
		query.append("     , '' total_amd_cnt" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , '' p_from_dt" ).append("\n"); 
		query.append("     , '' p_from_mt" ).append("\n"); 
		query.append("     , '' p_to_dt" ).append("\n"); 
		query.append("     , '' p_to_mt" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     , '' p_pol" ).append("\n"); 
		query.append("     , '' p_b_ofc_cd" ).append("\n"); 
		query.append("     , '' p_rhq_gb" ).append("\n"); 
		query.append("     , '' p_vvd" ).append("\n"); 
		query.append("     , '' cond_lane" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}