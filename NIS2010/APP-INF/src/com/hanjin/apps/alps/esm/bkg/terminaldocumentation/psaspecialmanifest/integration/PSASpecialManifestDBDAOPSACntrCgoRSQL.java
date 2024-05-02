/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSASpecialManifestDBDAOPSACntrCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.31
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.10.31 박성진
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

public class PSASpecialManifestDBDAOPSACntrCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSACntrCgoVO 생성을 위해 사용
	  * </pre>
	  */
	public PSASpecialManifestDBDAOPSACntrCgoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOPSACntrCgoRSQL").append("\n"); 
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
		query.append("'' flash" ).append("\n"); 
		query.append(",'' outpkg_desc" ).append("\n"); 
		query.append(",'' espn" ).append("\n"); 
		query.append(",'' imo_limit" ).append("\n"); 
		query.append(",'' inpkg_qty" ).append("\n"); 
		query.append(",'' prop_ship_nm" ).append("\n"); 
		query.append(",'' flash_unit" ).append("\n"); 
		query.append(",'' imo_comp" ).append("\n"); 
		query.append(",'' inpkg_tp" ).append("\n"); 
		query.append(",'' item_nbr" ).append("\n"); 
		query.append(",'' netwgt_unit" ).append("\n"); 
		query.append(",'' netwgt" ).append("\n"); 
		query.append(",'' un_nbr_seq" ).append("\n"); 
		query.append(",'' grosswgt" ).append("\n"); 
		query.append(",'' hcdg" ).append("\n"); 
		query.append(",'' imo_class" ).append("\n"); 
		query.append(",'' un_nbr" ).append("\n"); 
		query.append(",'' mfag" ).append("\n"); 
		query.append(",'' haz_cont" ).append("\n"); 
		query.append(",'' nw_explosive" ).append("\n"); 
		query.append(",'' cntrnbr" ).append("\n"); 
		query.append(",'' ems_nbr" ).append("\n"); 
		query.append(",'' outpkg_tp" ).append("\n"); 
		query.append(",'' sub_class4" ).append("\n"); 
		query.append(",'' sub_class3" ).append("\n"); 
		query.append(",'' pkg_group" ).append("\n"); 
		query.append(",'' imo_page" ).append("\n"); 
		query.append(",'' sub_class2" ).append("\n"); 
		query.append(",'' sub_class1" ).append("\n"); 
		query.append(",'' pollutant" ).append("\n"); 
		query.append(",'' pkg_desc" ).append("\n"); 
		query.append(",'' nw_exp_unit" ).append("\n"); 
		query.append(",'' grosswgt_unit" ).append("\n"); 
		query.append(",'' pkg_qty" ).append("\n"); 
		query.append(",'' outpkg_qty" ).append("\n"); 
		query.append(",'' pkg_tp" ).append("\n"); 
		query.append(",'' inpkg_desc" ).append("\n"); 
		query.append(",'' stowpos" ).append("\n"); 
		query.append(",'' vvd_cd" ).append("\n"); 
		query.append(",'' bkg_no" ).append("\n"); 
		query.append(",'' bl_no" ).append("\n"); 
		query.append(",'' pol_cd" ).append("\n"); 
		query.append(",'' pod_cd" ).append("\n"); 
		query.append(",'' cstms_port_cd" ).append("\n"); 
		query.append(",'' usr_id" ).append("\n"); 
		query.append(",'' msg_snd_no" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}