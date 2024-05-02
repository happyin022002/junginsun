/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOToDmtTariffTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.07.03 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOToDmtTariffTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Copy Basic Tariff
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOToDmtTariffTypeRSQL(){
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
		query.append("'' TO_CVRG_CNT_CD" ).append("\n"); 
		query.append(",	'' TO_CVRG_CONTI_CD" ).append("\n"); 
		query.append(",	'' TO_CVRG_LOC_CD" ).append("\n"); 
		query.append(",	'' TO_CVRG_RGN_CD" ).append("\n"); 
		query.append(",	'' TO_CVRG_STE_CD" ).append("\n"); 
		query.append(",	'' TO_CVRG_YD_CD" ).append("\n"); 
		query.append(",	'' TO_ORG_DEST_CNT_CD" ).append("\n"); 
		query.append(",	'' TO_ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append(",	'' TO_ORG_DEST_LOC_CD" ).append("\n"); 
		query.append(",	'' TO_ORG_DEST_RGN_CD" ).append("\n"); 
		query.append(",	'' TO_ORG_DEST_STE_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration ").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOToDmtTariffTypeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}