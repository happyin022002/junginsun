/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOCSTOPHistoryParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.08 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOCSTOPHistoryParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSTOPHistoryParmVO
	  * </pre>
	  */
	public DaoNameDAOCSTOPHistoryParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOCSTOPHistoryParmVORSQL").append("\n"); 
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
		query.append("SELECT '' SVR_ID" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append(",'' CNTR_CYC_NO" ).append("\n"); 
		query.append(",'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",'' CHG_SEQ" ).append("\n"); 
		query.append(",'' CSTOP_IDX" ).append("\n"); 
		query.append(",'' CSTOP_NO" ).append("\n"); 
		query.append(",'' OFC_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}