/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOImoComboRSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.01.26 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOImoComboRSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ImoComboRSQL조회
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOImoComboRSQLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration ").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOImoComboRSQLRSQL").append("\n"); 
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
		query.append("IMDG_CLSS_CD VAL" ).append("\n"); 
		query.append(",	IMDG_CLSS_CD_DESC NAME" ).append("\n"); 
		query.append("FROM SCG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("WHERE NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("ORDER BY IMDG_CLSS_CD" ).append("\n"); 

	}
}