/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchDPCSVolListOutVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.10.15 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchDPCSVolListOutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchDPCSVolListOutVORSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchDPCSVolListOutVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchDPCSVolListOutVORSQL").append("\n"); 
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
		query.append("/* Out VO */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("' ' seq_no" ).append("\n"); 
		query.append(", ' ' seq_no" ).append("\n"); 
		query.append(", ' ' queue" ).append("\n"); 
		query.append(", ' ' pic" ).append("\n"); 
		query.append(", ' ' sr_kind" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' bkg_no" ).append("\n"); 
		query.append(", ' ' vvd_cd" ).append("\n"); 
		query.append(", ' ' pol_cd" ).append("\n"); 
		query.append(", ' ' pod_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' sr_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' tot_staffs" ).append("\n"); 
		query.append(", ' ' tot_sr_vol" ).append("\n"); 
		query.append(", ' ' tot_sr_kind" ).append("\n"); 
		query.append(", ' ' tot_bkg_vol" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' tot_staffs_inputter" ).append("\n"); 
		query.append(", ' ' tot_sr_vol_inputter" ).append("\n"); 
		query.append(", ' ' tot_sr_kind_new" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' tot_staffs_rater" ).append("\n"); 
		query.append(", ' ' tot_sr_vol_rater" ).append("\n"); 
		query.append(", ' ' tot_sr_kind_amend" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' tot_staffs_auditor" ).append("\n"); 
		query.append(", ' ' tot_sr_vol_auditor" ).append("\n"); 
		query.append(", ' ' tot_sr_kind_bl_cnfm" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' tot_staffs_fofc" ).append("\n"); 
		query.append(", ' ' tot_sr_vol_fofc" ).append("\n"); 
		query.append(", ' ' tot_sr_kind_addition" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}