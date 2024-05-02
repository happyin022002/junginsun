/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VoMakeDAOSearchSADateVORSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.04
*@LastModifier :
*@LastVersion : 1.0
* 2012.06.04
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoMakeDAOSearchSADateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SearchSADateVO
	  * </pre>
	  */
	public VoMakeDAOSearchSADateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.vo").append("\n");
		query.append("FileName : VoMakeDAOSearchSADateVORSQL").append("\n");
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
		query.append("FROM DUAL" ).append("\n");

	}
}