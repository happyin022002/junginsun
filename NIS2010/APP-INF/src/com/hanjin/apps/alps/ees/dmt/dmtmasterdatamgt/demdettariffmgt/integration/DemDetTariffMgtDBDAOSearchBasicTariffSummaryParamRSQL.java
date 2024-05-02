/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchBasicTariffSummaryParamRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.05.22 김태균
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

public class DemDetTariffMgtDBDAOSearchBasicTariffSummaryParamRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic Tariff Summary Inquiry
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchBasicTariffSummaryParamRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("'' svr_id" ).append("\n"); 
		query.append(",'' cnt_cd" ).append("\n"); 
		query.append(",'' conti_cd" ).append("\n"); 
		query.append(",'' dmdt_trf_cd_in" ).append("\n"); 
		query.append(",'' dmdt_trf_cd_list" ).append("\n"); 
		query.append(",'' dmdt_trf_grp_tp_cd1" ).append("\n"); 
		query.append(",'' dmdt_trf_grp_tp_cd2" ).append("\n"); 
		query.append(",'' validity1" ).append("\n"); 
		query.append(",'' validity2" ).append("\n"); 
		query.append(",'' validity3" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchBasicTariffSummaryParamRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}