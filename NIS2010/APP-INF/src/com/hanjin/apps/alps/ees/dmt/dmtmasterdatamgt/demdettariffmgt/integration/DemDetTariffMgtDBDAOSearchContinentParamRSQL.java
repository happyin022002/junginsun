/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchContinentParamRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.07.22 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchContinentParamRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic Tariff Detail(s) Inquiry Param
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchContinentParamRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchContinentParamRSQL").append("\n"); 
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
		query.append("'' cvrg_conti_cd" ).append("\n"); 
		query.append(",'' cvrg_cnt_cd" ).append("\n"); 
		query.append(",'' cvrg_rgn_cd" ).append("\n"); 
		query.append(",'' cvrg_loc_cd" ).append("\n"); 
		query.append(",'' cvrg_yd_cd" ).append("\n"); 
		query.append(",'' org_dest_conti_cd" ).append("\n"); 
		query.append(",'' org_dest_cnt_cd" ).append("\n"); 
		query.append(",'' org_dest_rgn_cd" ).append("\n"); 
		query.append(",'' org_dest_loc_cd" ).append("\n"); 
		query.append(",'' dmdt_trf_cd_in" ).append("\n"); 
		query.append(",'' dmdt_trf_cd_list" ).append("\n"); 
		query.append(",'' dmdt_cntr_cgo_list" ).append("\n"); 
		query.append(",'' dmdt_cntr_tp_cd_in" ).append("\n"); 
		query.append(",'' dmdt_cntr_tp_list" ).append("\n"); 
		query.append(",'' dmdt_cgo_tp_cd_in" ).append("\n"); 
		query.append(",'' dmdt_cgo_tp_list" ).append("\n"); 
		query.append(",'' validity1" ).append("\n"); 
		query.append(",'' validity2" ).append("\n"); 
		query.append(",'' validity3" ).append("\n"); 
		query.append(",'' ui_code" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}