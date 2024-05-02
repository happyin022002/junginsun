/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialManifestDBDAODgSendDtlHistoryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAODgSendDtlHistoryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DgSendDtlHistoryVO 생성을 위해 사용
	  * </pre>
	  */
	public SpecialManifestDBDAODgSendDtlHistoryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAODgSendDtlHistoryVORSQL").append("\n"); 
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
		query.append("''EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append(",''MSG_SND_NO" ).append("\n"); 
		query.append(",''EDI_RSPN_SEQ" ).append("\n"); 
		query.append(",''BL_NO" ).append("\n"); 
		query.append(",''CNTR_NO" ).append("\n"); 
		query.append(",''CNTR_CGO_SEQ" ).append("\n"); 
		query.append(",''DG_BL_REF_NO" ).append("\n"); 
		query.append(",''DG_ITM_REF_NO" ).append("\n"); 
		query.append(",''CRE_USR_ID" ).append("\n"); 
		query.append(",''CRE_DT" ).append("\n"); 
		query.append(",''UPD_USR_ID" ).append("\n"); 
		query.append(",''UPD_DT" ).append("\n"); 
		query.append(",''KEY_VAL" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}