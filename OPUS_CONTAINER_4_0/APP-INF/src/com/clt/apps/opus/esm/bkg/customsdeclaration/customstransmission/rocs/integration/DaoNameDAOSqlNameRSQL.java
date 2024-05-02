/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DaoNameDAOSqlNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * select   
	  *  '' vsl_cd,
	  *  '' frm_crn_number,
	  *  '' msg_dt,
	  *  '' msg_tp,
	  *  ''  data_ctnt,
	  *  ''  skd_voy_no,
	  *  ''  skd_dir_cd,
	  *  ''   bl_no,
	  *  '' kind,
	  *  '' varj,
	  *  '' pod_cd,
	  *  ''  dif_char,
	  *  '' ofc_cd,
	  *  '' pol_cd,
	  *  '' bkg_no,
	  *   '' usert_id
	  * from dual
	  * </pre>
	  */
	public DaoNameDAOSqlNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.integration").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' vsl_cd," ).append("\n"); 
		query.append("'' frm_crn_number," ).append("\n"); 
		query.append("'' msg_dt," ).append("\n"); 
		query.append("'' msg_tp," ).append("\n"); 
		query.append("''  data_ctnt," ).append("\n"); 
		query.append("''  skd_voy_no," ).append("\n"); 
		query.append("''  skd_dir_cd," ).append("\n"); 
		query.append("''   bl_no," ).append("\n"); 
		query.append("'' kind," ).append("\n"); 
		query.append("'' varj," ).append("\n"); 
		query.append("'' pod_cd," ).append("\n"); 
		query.append("''  dif_char," ).append("\n"); 
		query.append("'' ofc_cd," ).append("\n"); 
		query.append("'' pol_cd," ).append("\n"); 
		query.append("'' bkg_no," ).append("\n"); 
		query.append("'' usert_id," ).append("\n"); 
		query.append("'' flag," ).append("\n"); 
		query.append("'' error_cd," ).append("\n"); 
		query.append("'' error_desc," ).append("\n"); 
		query.append("'' error_rff," ).append("\n"); 
		query.append("'' bl_dat_cfm_dt," ).append("\n"); 
		query.append("'' pre_rly_port_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}