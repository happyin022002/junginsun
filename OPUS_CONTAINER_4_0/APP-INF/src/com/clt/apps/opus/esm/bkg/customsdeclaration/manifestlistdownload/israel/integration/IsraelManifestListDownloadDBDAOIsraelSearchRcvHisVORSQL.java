/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IsraelManifestListDownloadDBDAOIsraelSearchRcvHisVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.11
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.09.11 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelManifestListDownloadDBDAOIsraelSearchRcvHisVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IsraelSearchRcvHisVO
	  * </pre>
	  */
	public IsraelManifestListDownloadDBDAOIsraelSearchRcvHisVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.integration").append("\n"); 
		query.append("FileName : IsraelManifestListDownloadDBDAOIsraelSearchRcvHisVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("  '' ack_knd_id" ).append("\n"); 
		query.append(", '' eur_ack_rcv_sts_cd" ).append("\n"); 
		query.append(", '' ack_dt" ).append("\n"); 
		query.append(", '' bl_no" ).append("\n"); 
		query.append(", '' vsl_cd" ).append("\n"); 
		query.append(", '' skd_voy_no" ).append("\n"); 
		query.append(", '' skd_dir_cd" ).append("\n"); 
		query.append(", '' vvd" ).append("\n"); 
		query.append(", '' eur_cstms_rjct_cd" ).append("\n"); 
		query.append(", '' rjct_rsn_rmk" ).append("\n"); 
		query.append(", '' rjct_dt" ).append("\n"); 
		query.append(", '' cstms_err_id" ).append("\n"); 
		query.append(", '' cstms_err_msg" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}