/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialManifestDBDAODgReceiveHistoryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.14 
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

public class SpecialManifestDBDAODgReceiveHistoryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DgReceiveHistoryVO 생성을 위해 사용
	  * </pre>
	  */
	public SpecialManifestDBDAODgReceiveHistoryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration ").append("\n"); 
		query.append("FileName : SpecialManifestDBDAODgReceiveHistoryVORSQL").append("\n"); 
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
		query.append(",''MSG_RCV_NO" ).append("\n"); 
		query.append(",''RCV_LOG_SEQ" ).append("\n"); 
		query.append(",''ORG_MSG_RCVR_NO" ).append("\n"); 
		query.append(",''ORG_MSG_TP_ID" ).append("\n"); 
		query.append(",''MSG_FUNC_ID" ).append("\n"); 
		query.append(",''EDI_SND_MSG_NM" ).append("\n"); 
		query.append(",''ACK_KND_ID" ).append("\n"); 
		query.append(",''ACK_RCV_STS_CD" ).append("\n"); 
		query.append(",''ACK_DT" ).append("\n"); 
		query.append(",''APRO_DT" ).append("\n"); 
		query.append(",''CSTMS_PHN_NO" ).append("\n"); 
		query.append(",''CSTMS_FAX_NO" ).append("\n"); 
		query.append(",''CNTR_NO" ).append("\n"); 
		query.append(",''BL_NO" ).append("\n"); 
		query.append(",''SCR_FILE_NO" ).append("\n"); 
		query.append(",''MSG_ACPT_REF_NO" ).append("\n"); 
		query.append(",''CRE_USR_ID" ).append("\n"); 
		query.append(",''CRE_DT" ).append("\n"); 
		query.append(",''UPD_USR_ID" ).append("\n"); 
		query.append(",''UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}