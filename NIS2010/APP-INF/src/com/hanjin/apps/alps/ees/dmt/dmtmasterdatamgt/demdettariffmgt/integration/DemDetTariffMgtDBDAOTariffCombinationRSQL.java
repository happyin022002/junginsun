/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOTariffCombinationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.06.24 김태균
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

public class DemDetTariffMgtDBDAOTariffCombinationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TariffCombination VO 생성
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOTariffCombinationRSQL(){
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
		query.append("SVR_ID" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	TRF_SEQ" ).append("\n"); 
		query.append(",	TRF_GRP_SEQ" ).append("\n"); 
		query.append(",	DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(",	DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID AS USR_ID" ).append("\n"); 
		query.append(",	CRE_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("FROM DMT_TRF_CMB" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration ").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOTariffCombinationRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}