/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PakistanManifestListDownloadDBDAOPakistanCNTRInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.31
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.08.31 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PakistanManifestListDownloadDBDAOPakistanCNTRInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PakistanCNTRInfoVO
	  * </pre>
	  */
	public PakistanManifestListDownloadDBDAOPakistanCNTRInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.integration").append("\n"); 
		query.append("FileName : PakistanManifestListDownloadDBDAOPakistanCNTRInfoVORSQL").append("\n"); 
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
		query.append("SELECT '' cntr_no" ).append("\n"); 
		query.append("     , '' bkg_no" ).append("\n"); 
		query.append("     , '' cntr_tpsz_cd" ).append("\n"); 
		query.append("     , '' cmdt_hs_cd" ).append("\n"); 
		query.append("     , '' cntr_mf_gds_desc" ).append("\n"); 
		query.append("     , '' cntr_seal_no" ).append("\n"); 
		query.append("     , '' pck_qty" ).append("\n"); 
		query.append("     , '' pck_nm" ).append("\n"); 
		query.append("     , '' cntr_mf_wgt" ).append("\n"); 
		query.append("     , '' wgt_ut_cd" ).append("\n"); 
		query.append("     , '' meas_qty" ).append("\n"); 
		query.append("     , '' meas_ut_cd" ).append("\n"); 
		query.append("     , '' imdg_un_no" ).append("\n"); 
		query.append("     , '' imdg_clss_cd" ).append("\n"); 
		query.append("     , '' soc_flg" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}