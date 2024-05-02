/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOCommodityTariffRegionParamVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.03 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOCommodityTariffRegionParamVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Commodity Exception Tariff Inquiry
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOCommodityTariffRegionParamVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOCommodityTariffRegionParamVORSQL").append("\n"); 
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
		query.append("SELECT '' CVRG_CONTI_CD" ).append("\n"); 
		query.append(", '' CVRG_CNT_CD" ).append("\n"); 
		query.append(", '' CVRG_RGN_CD" ).append("\n"); 
		query.append(", '' CVRG_STE_CD" ).append("\n"); 
		query.append(", '' CVRG_LOC_CD" ).append("\n"); 
		query.append(", '' ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append(", '' ORG_DEST_CNT_CD" ).append("\n"); 
		query.append(", '' ORG_DEST_RGN_CD" ).append("\n"); 
		query.append(", '' ORG_DEST_STE_CD" ).append("\n"); 
		query.append(", '' DMDT_TRF_CD_IN" ).append("\n"); 
		query.append(", '' DMDT_TRF_CD_LIST" ).append("\n"); 
		query.append(", '' DMDT_TRF_CD" ).append("\n"); 
		query.append(", '' VALIDITY1" ).append("\n"); 
		query.append(", '' VALIDITY2" ).append("\n"); 
		query.append(", '' VALIDITY3" ).append("\n"); 
		query.append(", '' CFM_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}