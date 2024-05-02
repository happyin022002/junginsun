/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActivityDataDBDAOSearchSKDLogicListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.10.06 오현경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActivityDataDBDAOSearchSKDLogicListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSKDLogicList
	  * </pre>
	  */
	public ActivityDataDBDAOSearchSKDLogicListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_skd_lgc_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.integration").append("\n"); 
		query.append("FileName : ActivityDataDBDAOSearchSKDLogicListRSQL").append("\n"); 
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
		query.append("SELECT scsl.cop_skd_lgc_no" ).append("\n"); 
		query.append(", scsl.act_cd" ).append("\n"); 
		query.append(", ma.act_nm" ).append("\n"); 
		query.append(", scsl.cop_foml_cd" ).append("\n"); 
		query.append(", scsl.foml_tm_hrs" ).append("\n"); 
		query.append(", scsl.foml_pct_no" ).append("\n"); 
		query.append(", scsl.fm_eff_dt" ).append("\n"); 
		query.append(", scsl.to_eff_dt" ).append("\n"); 
		query.append(", '' srch_all" ).append("\n"); 
		query.append(", '' p_cop_skd_lgc_no" ).append("\n"); 
		query.append("FROM sce_cop_skd_lgc scsl," ).append("\n"); 
		query.append("mdm_activity ma" ).append("\n"); 
		query.append("WHERE scsl.act_cd = ma.act_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${srch_all} != 'Y')" ).append("\n"); 
		query.append("AND scsl.cop_skd_lgc_no = @[cop_skd_lgc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY scsl.cop_skd_lgc_no" ).append("\n"); 

	}
}