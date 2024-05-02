/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAODemandNotePreviewEtcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.12.08 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAODemandNotePreviewEtcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DemandNotePreviewEtcVO
	  * </pre>
	  */
	public DaoNameDAODemandNotePreviewEtcVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.integration").append("\n"); 
		query.append("FileName : DaoNameDAODemandNotePreviewEtcVORSQL").append("\n"); 
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
		query.append("SELECT '' AS VVD_CD" ).append("\n"); 
		query.append(",'' AS VVD_NM" ).append("\n"); 
		query.append(",'' AS ARR" ).append("\n"); 
		query.append(",'' AS DEP" ).append("\n"); 
		query.append(",'' AS BL_NO" ).append("\n"); 
		query.append(",'' AS BKG_NO" ).append("\n"); 
		query.append(",'' AS CMDT_CD" ).append("\n"); 
		query.append(",'' AS CMDT_NM" ).append("\n"); 
		query.append(",'' AS DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' AS DMDT_TRF_NM" ).append("\n"); 
		query.append(",'' AS BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",'' AS BKG_RCV_TERM_NM" ).append("\n"); 
		query.append(",'' AS BKG_DEL_TERM_CD" ).append("\n"); 
		query.append(",'' AS BKG_DEL_TERM_NM" ).append("\n"); 
		query.append(",'' AS POD" ).append("\n"); 
		query.append(",'' AS POD_NM" ).append("\n"); 
		query.append(",'' AS DEL" ).append("\n"); 
		query.append(",'' AS DEL_NM" ).append("\n"); 
		query.append(",'' AS TRUCKER" ).append("\n"); 
		query.append(",'' AS VNDR_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}