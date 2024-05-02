/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBoilerPlateGuidelineDBDAOPriSgBlplHdrInqYearRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.10.05 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCBoilerPlateGuidelineDBDAOPriSgBlplHdrInqYearRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Boiler Plate Inquiry Year 를 조회한다.
	  * </pre>
	  */
	public SCBoilerPlateGuidelineDBDAOPriSgBlplHdrInqYearRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.integration").append("\n"); 
		query.append("FileName : SCBoilerPlateGuidelineDBDAOPriSgBlplHdrInqYearRSQL").append("\n"); 
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
		query.append("SELECT BLPL_HDR_SEQ" ).append("\n"); 
		query.append(",BLPL_REF_YR" ).append("\n"); 
		query.append("FROM PRI_SG_BLPL_HDR" ).append("\n"); 
		query.append("ORDER BY BLPL_REF_YR DESC" ).append("\n"); 

	}
}