/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOsendLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOsendLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ssd
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOsendLogRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration ").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOsendLogRSQL").append("\n"); 
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
		query.append(" EUR_EDI_MSG_TP_ID,MSG_SND_NO,SND_DT,SND_GDT,SND_USR_ID,MSG_FUNC_ID,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,BL_NO,CSTMS_PORT_CD,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT,EDI_SND_MSG_CTNT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_EUR_SND" ).append("\n"); 

	}
}