/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDetTariffMgtDBDAODmtTariffTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.10.21 김태균
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

public class DemDetTariffMgtDBDAODmtTariffTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Copy Basic Tariff
	  * </pre>
	  */
	public DemDetTariffMgtDBDAODmtTariffTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAODmtTariffTypeRSQL").append("\n"); 
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
		query.append("'' CNT_CD" ).append("\n"); 
		query.append(",	'' SEL_DMDT_TRF_CD" ).append("\n"); 
		query.append(",	'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",	'' CVRG_CNT_CD" ).append("\n"); 
		query.append(",	'' CVRG_CONTI_CD" ).append("\n"); 
		query.append(",	'' CVRG_LOC_CD" ).append("\n"); 
		query.append(",	'' CVRG_RGN_CD" ).append("\n"); 
		query.append(",	'' CVRG_STE_CD" ).append("\n"); 
		query.append(",	'' CVRG_YD_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_CNT_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_LOC_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_RGN_CD" ).append("\n"); 
		query.append(",	'' ORG_DEST_STE_CD" ).append("\n"); 
		query.append(",	'' SVR_ID" ).append("\n"); 
		query.append(",	'' TRF_GRP_SEQ" ).append("\n"); 
		query.append(",	'' TRF_SEQ" ).append("\n"); 
		query.append(",	'' UI_CODE" ).append("\n"); 
		query.append(",	'' ALL_FLG" ).append("\n"); 
		query.append(",	'' DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(",	'' DMDT_CGO_TP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}