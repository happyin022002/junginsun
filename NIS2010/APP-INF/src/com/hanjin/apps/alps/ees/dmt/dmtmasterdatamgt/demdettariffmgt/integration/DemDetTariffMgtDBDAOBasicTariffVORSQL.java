/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOBasicTariffVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOBasicTariffVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO 생성
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOBasicTariffVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration ").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOBasicTariffVORSQL").append("\n"); 
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
		query.append("'' XCLD_SAT_FLG" ).append("\n"); 
		query.append(",'' XCLD_SUN_FLG" ).append("\n"); 
		query.append(",'' GRP_CFM_FLG" ).append("\n"); 
		query.append(",'' CRNT_CFM_FLG" ).append("\n"); 
		query.append(",'' DMDT_CHG_CMNC_TP_CD" ).append("\n"); 
		query.append(",'' CURR_CD" ).append("\n"); 
		query.append(",'' DMDT_TRF_GRP_TP_CD" ).append("\n"); 
		query.append(",'' BUTTON_MODE" ).append("\n"); 
		query.append(",'' DMDT_BZC_TRF_GRP_NM" ).append("\n"); 
		query.append(",'' SVR_ID" ).append("\n"); 
		query.append(",'' EFF_DT" ).append("\n"); 
		query.append(",'' RGN_CFM_FLG" ).append("\n"); 
		query.append(",'' USR_ID" ).append("\n"); 
		query.append(",'' EXP_DT" ).append("\n"); 
		query.append(",'' DMDT_BZC_TRF_GRP_NM2" ).append("\n"); 
		query.append(",'' DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(",'' EFF_DAY" ).append("\n"); 
		query.append(",'' USER_OFFICE" ).append("\n"); 
		query.append(",'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' DMDT_CNTR_TP_NM" ).append("\n"); 
		query.append(",'' CMNC_HR" ).append("\n"); 
		query.append(",'' DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(",'' RGN_CFM_SEQ" ).append("\n"); 
		query.append(",'' DMDT_CGO_TP_NM" ).append("\n"); 
		query.append(",'' OFC_CD" ).append("\n"); 
		query.append(",'' WKND2" ).append("\n"); 
		query.append(",'' WKND1" ).append("\n"); 
		query.append(",'' XCLD_HOL_FLG" ).append("\n"); 
		query.append(",'' DMDT_CHG_CMNC_TP_NM" ).append("\n"); 
		query.append(",'' TRF_GRP_SEQ" ).append("\n"); 
		query.append(",'' TRF_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}