/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOSqlNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.12 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOSqlNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 검색조건
	  * </pre>
	  */
	public DaoNameDAOSqlNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration").append("\n"); 
		query.append("FileName : DaoNameDAOSqlNameRSQL").append("\n"); 
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
		query.append("select ''  vsl_rgst_no," ).append("\n"); 
		query.append("'' vps_eta_dt ," ).append("\n"); 
		query.append("'' vps_eta_dt_time," ).append("\n"); 
		query.append("'' vps_etd_dt," ).append("\n"); 
		query.append("'' vps_etd_dt_time," ).append("\n"); 
		query.append("'' vsl_eng_nm," ).append("\n"); 
		query.append("'' vsl_rgst_cnt_cd," ).append("\n"); 
		query.append("'' cap_nm," ).append("\n"); 
		query.append("'' depature_port," ).append("\n"); 
		query.append("'' pod_cd," ).append("\n"); 
		query.append("''vsl_nm," ).append("\n"); 
		query.append("'' vsl_nm2," ).append("\n"); 
		query.append("'' vsl_auth_no," ).append("\n"); 
		query.append("'' vessel_reg_no," ).append("\n"); 
		query.append("'' vsl_cd," ).append("\n"); 
		query.append("'' skd_voy_no," ).append("\n"); 
		query.append("'' skd_dir_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}