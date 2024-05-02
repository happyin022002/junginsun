/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOEurManifestListCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.09
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2014.01.09 김보배
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

public class Eur24ManifestDownloadDBDAOEurManifestListCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOEurManifestListCondVORSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOEurManifestListCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOEurManifestListCondVORSQL").append("\n"); 
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
		query.append("/* EurManifestListCondVO ManifestListCondVO " ).append("\n"); 
		query.append("import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  ' ' as P_data_cd" ).append("\n"); 
		query.append(", ' ' as P_error_cd" ).append("\n"); 
		query.append(", ' ' as P_b_ofc_cd" ).append("\n"); 
		query.append(", ' ' as P_s_ofc_cd" ).append("\n"); 
		query.append(", ' ' as P_b_staff" ).append("\n"); 
		query.append(", ' ' as P_vvd_cd" ).append("\n"); 
		query.append(", ' ' as P_pol_cd" ).append("\n"); 
		query.append(", ' ' as P_pol_yard_cd" ).append("\n"); 
		query.append(", ' ' as P_pod_cd" ).append("\n"); 
		query.append(", ' ' as P_pod_yard_cd" ).append("\n"); 
		query.append(", ' ' as p_ori_amd_cd" ).append("\n"); 
		query.append(", ' ' as p_bl_no" ).append("\n"); 
		query.append(", ' ' as p_send_yn" ).append("\n"); 
		query.append(", ' ' as p_ack_status" ).append("\n"); 
		query.append(", ' ' as p_lt" ).append("\n"); 
		query.append(", ' ' as p_search_pofe_yard_cd" ).append("\n"); 
		query.append(", ' ' as P_first_of_multi_pofe_cd" ).append("\n"); 
		query.append(", ' ' as p_type" ).append("\n"); 
		query.append(", ' ' as p_fi_vvd_cd" ).append("\n"); 
		query.append(", ' ' as p_fi_pol_cd" ).append("\n"); 
		query.append(", ' ' as p_fi_pol_yard_cd" ).append("\n"); 
		query.append(", ' ' as p_fi_pod_cd" ).append("\n"); 
		query.append(", ' ' as p_fi_pod_yard_cd" ).append("\n"); 
		query.append(", ' ' as p_fi_bl_no" ).append("\n"); 
		query.append(", ' ' as p_fi_lt" ).append("\n"); 
		query.append(", ' ' as p_fi_ack_status" ).append("\n"); 
		query.append(", ' ' as eu_1st_port_clpt_seq" ).append("\n"); 
		query.append("-- 140109 일치" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}