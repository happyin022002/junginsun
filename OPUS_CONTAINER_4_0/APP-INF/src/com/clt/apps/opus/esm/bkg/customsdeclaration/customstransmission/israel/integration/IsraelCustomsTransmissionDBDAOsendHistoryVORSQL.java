/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IsraelCustomsTransmissionDBDAOsendHistoryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.20
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.20 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelCustomsTransmissionDBDAOsendHistoryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sendHistoryVO
	  * </pre>
	  */
	public IsraelCustomsTransmissionDBDAOsendHistoryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration ").append("\n"); 
		query.append("FileName : IsraelCustomsTransmissionDBDAOsendHistoryVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  '' AS CNT_CD " ).append("\n"); 
		query.append(", '' AS MSG_SND_NO" ).append("\n"); 
		query.append(", '' AS EDI_MSG_TP_ID" ).append("\n"); 
		query.append(", '' AS SND_DT" ).append("\n"); 
		query.append(", '' AS SND_GDT" ).append("\n"); 
		query.append(", '' AS SND_USR_ID" ).append("\n"); 
		query.append(", '' AS SND_USR_OFC_CD" ).append("\n"); 
		query.append(", '' AS MSG_FUNC_ID" ).append("\n"); 
		query.append(", '' AS BL_NO" ).append("\n"); 
		query.append(", '' AS VSL_CD" ).append("\n"); 
		query.append(", '' AS SKD_VOY_NO" ).append("\n"); 
		query.append(", '' AS SKD_DIR_CD" ).append("\n"); 
		query.append(", '' AS CSTMS_PORT_CD" ).append("\n"); 
		query.append(", '' AS EDI_SND_MSG_CTNT" ).append("\n"); 
		query.append(", '' AS CRE_USR_ID" ).append("\n"); 
		query.append(", '' AS CRE_DT" ).append("\n"); 
		query.append(", '' AS UPD_USR_ID" ).append("\n"); 
		query.append(", '' AS UPD_DT" ).append("\n"); 
		query.append(", '' AS UNLOAD_LOC_ETA" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}