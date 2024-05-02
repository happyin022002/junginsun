/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAODemandNoteRDParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.12.21 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAODemandNoteRDParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DemandNoteRDParmVO
	  * </pre>
	  */
	public DaoNameDAODemandNoteRDParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.integration").append("\n"); 
		query.append("FileName : DaoNameDAODemandNoteRDParmVORSQL").append("\n"); 
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
		query.append("'' AS SVR_ID" ).append("\n"); 
		query.append(",'' AS CNTR_NO" ).append("\n"); 
		query.append(",'' AS CNTR_CYC_NO" ).append("\n"); 
		query.append(",'' AS DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' AS DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",'' AS CHG_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}