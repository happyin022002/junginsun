/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : FICCostInterfaceDBDAOSearchTariffCodeMappingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.02
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.05.02 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FICCostInterfaceDBDAOSearchTariffCodeMappingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTariffCodeMapping 조회
	  * </pre>
	  */
	public FICCostInterfaceDBDAOSearchTariffCodeMappingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration ").append("\n"); 
		query.append("FileName : FICCostInterfaceDBDAOSearchTariffCodeMappingRSQL").append("\n"); 
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
		query.append("SELECT A1.TRF_PFX_CD ||'-'|| A1.TRF_NO AS TRF_CD" ).append("\n"); 
		query.append("      ,A2.TRF_NM" ).append("\n"); 
		query.append("      ,A1.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,DECODE(A1.ORG_DEST_TP_CD, 'O', 'Out bound', 'D', 'In bound') AS ORG_DEST_TP_CD" ).append("\n"); 
		query.append("      ,A1.COST_CNT_CD" ).append("\n"); 
		query.append("      ,A3.CNT_NM" ).append("\n"); 
		query.append("FROM PRI_PUB_TRF_SVC_SCP_MAPG A1" ).append("\n"); 
		query.append("    ,PRI_TARIFF A2" ).append("\n"); 
		query.append("    ,MDM_COUNTRY A3" ).append("\n"); 
		query.append("WHERE A1.TRF_PFX_CD = A2.TRF_PFX_CD" ).append("\n"); 
		query.append("  AND A1.TRF_NO = A2.TRF_NO" ).append("\n"); 
		query.append("  AND A2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("  AND A1.COST_CNT_CD = A3.CNT_CD" ).append("\n"); 
		query.append("  AND A3.DELT_FLG = 'N'" ).append("\n"); 

	}
}