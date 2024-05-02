/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialManifestDBDAODgBayRcvMsgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAODgBayRcvMsgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DgBayRcvMsgVO 생성을 위해 사용
	  * </pre>
	  */
	public SpecialManifestDBDAODgBayRcvMsgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration ").append("\n"); 
		query.append("FileName : SpecialManifestDBDAODgBayRcvMsgVORSQL").append("\n"); 
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
		query.append("''BAY_PLN_ID" ).append("\n"); 
		query.append(",''MSG_SNDR_CTNT" ).append("\n"); 
		query.append(",''VSL_CD" ).append("\n"); 
		query.append(",''VSL_VOY_DIR_NO" ).append("\n"); 
		query.append(",''EUR_DG_CALL_SGN_NO" ).append("\n"); 
		query.append(",''VSL_NM" ).append("\n"); 
		query.append(",''CRR_ID" ).append("\n"); 
		query.append(",''EUR_DG_DEP_PORT_CD" ).append("\n"); 
		query.append(",''EUR_DG_NXT_PORT_CD" ).append("\n"); 
		query.append(",''ETA_DT" ).append("\n"); 
		query.append(",''ETD_DT" ).append("\n"); 
		query.append(",''RCV_DT" ).append("\n"); 
		query.append(",''CRE_USR_ID" ).append("\n"); 
		query.append(",''CRE_DT" ).append("\n"); 
		query.append(",''UPD_USR_ID" ).append("\n"); 
		query.append(",''UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}