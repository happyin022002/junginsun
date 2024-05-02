/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VoMakeDAOSearchFFSADateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.ffcommcalculation.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoMakeDAOSearchFFSADateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFFSADateVO
	  * </pre>
	  */
	public VoMakeDAOSearchFFSADateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.ffcommcalculation.vo").append("\n"); 
		query.append("FileName : VoMakeDAOSearchFFSADateVORSQL").append("\n"); 
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
		query.append("'' vsl_cd            " ).append("\n"); 
		query.append(",'' pre_feeder_check  " ).append("\n"); 
		query.append(",'' post_feeder_check " ).append("\n"); 
		query.append(",'' skd_voy_no        " ).append("\n"); 
		query.append(",'' rlane_cd          " ).append("\n"); 
		query.append(",'' vsl_seq           " ).append("\n"); 
		query.append(",'' vsl_pol_cd        " ).append("\n"); 
		query.append(",'' ar_ofc_cd         " ).append("\n"); 
		query.append(",'' skd_dir_cd        " ).append("\n"); 
		query.append(",'' slan_cd           " ).append("\n"); 
		query.append(",'' rlane_dir_cd      " ).append("\n"); 
		query.append(",'' vsl_pod_cd        " ).append("\n"); 
		query.append(",'' finc_ctrl_ofc_cd  " ).append("\n"); 
		query.append(",'' os_conti_cd       " ).append("\n"); 
		query.append(",'' vsl_pre_pst_cd    " ).append("\n"); 
		query.append(",'' sa_dt_div      " ).append("\n"); 
		query.append(",'' VPS_ETD_DT" ).append("\n"); 
		query.append(",'' VPS_ETA_DT" ).append("\n"); 
		query.append(",'' SINWA_TS_SA_DT" ).append("\n"); 
		query.append(",'' sa_dt_seq" ).append("\n"); 
		query.append(",'' ff_cust_seq_tmp" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}