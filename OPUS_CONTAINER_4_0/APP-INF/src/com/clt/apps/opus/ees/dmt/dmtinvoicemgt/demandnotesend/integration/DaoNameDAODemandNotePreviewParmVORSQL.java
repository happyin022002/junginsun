/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAODemandNotePreviewParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.21 최성환
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

public class DaoNameDAODemandNotePreviewParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DemandNotePreviewParmVO
	  * </pre>
	  */
	public DaoNameDAODemandNotePreviewParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.integration").append("\n"); 
		query.append("FileName : DaoNameDAODemandNotePreviewParmVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' session_usr_id" ).append("\n"); 
		query.append(",'' session_ofc_cd" ).append("\n"); 
		query.append(",'' call_to_rd_tp" ).append("\n"); 
		query.append(",'' dmdt_trf_cd" ).append("\n"); 
		query.append(",'' dmdt_chg_sts_cd" ).append("\n"); 
		query.append(",'' bkg_no" ).append("\n"); 
		query.append(",'' payer_cd" ).append("\n"); 
		query.append(",'' ofc_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}