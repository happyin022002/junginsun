/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchCntrStdInfoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchCntrStdInfoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDM에 등록된 Container Creation 기준정보 조회
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchCntrStdInfoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchCntrStdInfoDataRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("    MAX(CASE INTG_CD_VAL_CTNT WHEN 'ST_OFC' THEN INTG_CD_VAL_DP_DESC END) AS OFC_CD," ).append("\n"); 
		query.append("    MAX(CASE INTG_CD_VAL_CTNT WHEN 'ST_LOC' THEN INTG_CD_VAL_DP_DESC END) AS LOC_CD," ).append("\n"); 
		query.append("    MAX(CASE INTG_CD_VAL_CTNT WHEN 'ST_RCC' THEN INTG_CD_VAL_DP_DESC END) AS RCC_CD," ).append("\n"); 
		query.append("    MAX(CASE INTG_CD_VAL_CTNT WHEN 'ST_LCC' THEN INTG_CD_VAL_DP_DESC END) AS LCC_CD," ).append("\n"); 
		query.append("    MAX(CASE INTG_CD_VAL_CTNT WHEN 'ST_ECC' THEN INTG_CD_VAL_DP_DESC END) AS ECC_CD," ).append("\n"); 
		query.append("    MAX(CASE INTG_CD_VAL_CTNT WHEN 'ST_SCC' THEN INTG_CD_VAL_DP_DESC END) AS SCC_CD," ).append("\n"); 
		query.append("    MAX(CASE INTG_CD_VAL_CTNT WHEN 'ST_YD' THEN INTG_CD_VAL_DP_DESC END)  AS YD_CD," ).append("\n"); 
		query.append("    MAX(CASE INTG_CD_VAL_CTNT WHEN 'ST_AREA' THEN INTG_CD_VAL_DP_DESC END)  AS AREA_CD" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID ='CD20014'" ).append("\n"); 

	}
}