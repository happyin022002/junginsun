/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchCombinationSetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchCombinationSetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCombinationSet - Grid2
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchCombinationSetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchCombinationSetRSQL").append("\n"); 
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
		query.append("SELECT  DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT   INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE    INTG_CD_ID       = 'CD02053'" ).append("\n"); 
		query.append("AND      INTG_CD_VAL_CTNT = DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(")        AS DMDT_CNTR_TP_NM" ).append("\n"); 
		query.append(", DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT   INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE    INTG_CD_ID       = 'CD01963'" ).append("\n"); 
		query.append("AND      INTG_CD_VAL_CTNT = DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(")        AS DMDT_CGO_TP_NM" ).append("\n"); 
		query.append("FROM DMT_CMB_SET" ).append("\n"); 

	}
}