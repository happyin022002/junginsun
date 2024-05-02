/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOSearchCBFIFSTWGCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOSearchCBFIFSTWGCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnContainerBookingForecastMgtDBDAOSearchCBFIFSTWGCdList
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOSearchCBFIFSTWGCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOSearchCBFIFSTWGCdListRSQL").append("\n"); 
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
		query.append("SELECT  INTG_CD_VAL_CTNT AS STWG_CD" ).append("\n"); 
		query.append("        /*" ).append("\n"); 
		query.append("		, INTG_CD_ID AS STWG_CD" ).append("\n"); 
		query.append("        , INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("        , INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        , INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("        */" ).append("\n"); 
		query.append("FROM     COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE    INTG_CD_ID = 'CD02146'" ).append("\n"); 
		query.append("AND      (APLY_ST_DT <= TO_CHAR(SYSDATE, 'YYYYMMDD') AND APLY_END_DT >= TO_CHAR(SYSDATE, 'YYYYMMDD'))" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'PC' AS STWG_cD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}