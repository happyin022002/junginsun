/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchUsCustomsStatusNoticeInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchUsCustomsStatusNoticeInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUsCustomsStatusNoticeInfo
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchUsCustomsStatusNoticeInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchUsCustomsStatusNoticeInfoRSQL").append("\n"); 
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
		query.append("SELECT HNDL_OFC_CD" ).append("\n"); 
		query.append(", NVL(MAX(AUTO_SND_FLG),'Y') AUTO_SND_FLG_RADIO" ).append("\n"); 
		query.append(", NVL(MAX(HNDL_OFC_ADDR),' ') HNDL_OFC_ADDR" ).append("\n"); 
		query.append(", NVL(MAX(HNDL_OFC_EML),' ') HNDL_OFC_EML" ).append("\n"); 
		query.append(", NVL(MAX(NTC_MSG_TP_CD),' ') NTC_MSG_TP_CD" ).append("\n"); 
		query.append(", NVL(MAX(CSTMS_NTC_MSG),' ') CSTMS_NTC_MSG" ).append("\n"); 
		query.append(", NVL(MAX(CASE WHEN NTC_MSG_TP_CD = '1R' THEN CSTMS_NTC_MSG END),' ') CSTMS_NTC_MSG_1R" ).append("\n"); 
		query.append(", NVL(MAX(CASE WHEN NTC_MSG_TP_CD = '1S' THEN CSTMS_NTC_MSG END),' ') CSTMS_NTC_MSG_1S" ).append("\n"); 
		query.append(", MAX(CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append(", MAX(CRE_DT) CRE_DT" ).append("\n"); 
		query.append(", MAX(UPD_USR_ID) UPD_USR_ID" ).append("\n"); 
		query.append(", MAX(UPD_DT) UPD_DT" ).append("\n"); 
		query.append(", ' ' AUTO_SND_FLG" ).append("\n"); 
		query.append(", ' ' NTC_MSG_TP_CD_1R" ).append("\n"); 
		query.append(", ' ' NTC_MSG_TP_CD_1S" ).append("\n"); 
		query.append("FROM BKG_CSTMS_NTC_STUP" ).append("\n"); 
		query.append("WHERE HNDL_OFC_CD = @[hndl_ofc_cd]" ).append("\n"); 
		query.append("GROUP BY HNDL_OFC_CD" ).append("\n"); 

	}
}