/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOCimTerritoryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.03.22 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOCimTerritoryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  EES_CTM_0428 : TerritoryList에 해당되는 값을 조회
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOCimTerritoryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOCimTerritoryVORSQL").append("\n"); 
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
		query.append("SELECT A.CNTR_STK_TERR_CD," ).append("\n"); 
		query.append("B.CNT_NM," ).append("\n"); 
		query.append("B.CNT_NM AS CNT_NM0," ).append("\n"); 
		query.append("A.CNT_CD," ).append("\n"); 
		query.append("A.OFC_CD," ).append("\n"); 
		query.append("A.UPD_USR_ID AS USR_ID," ).append("\n"); 
		query.append("TO_CHAR (A.CRE_DT, 'YYYY-MM-DD HH24:MI') AS CRE_DT," ).append("\n"); 
		query.append("TO_CHAR (A.UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT," ).append("\n"); 
		query.append("A.CNTR_STK_TERR_CD CNTR_STK_TERR_CD0," ).append("\n"); 
		query.append("A.CNT_CD AS CNT_CD0," ).append("\n"); 
		query.append("A.OFC_CD AS OFC_CD0" ).append("\n"); 
		query.append("FROM CIM_TERRITORY A," ).append("\n"); 
		query.append("MDM_COUNTRY B" ).append("\n"); 
		query.append("WHERE A.CO_CD IN ('A', 'H')" ).append("\n"); 
		query.append("AND A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY A.CNTR_STK_TERR_CD," ).append("\n"); 
		query.append("A.CNT_CD," ).append("\n"); 
		query.append("A.OFC_CD" ).append("\n"); 

	}
}