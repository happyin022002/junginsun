/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOSitProCargoManifestCondForEdiVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.19
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.11.19 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOSitProCargoManifestCondForEdiVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sit Pro화면에서 대상 조회
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOSitProCargoManifestCondForEdiVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOSitProCargoManifestCondForEdiVORSQL").append("\n"); 
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
		query.append("SELECT '' as VVD_CD," ).append("\n"); 
		query.append("       '' as POL_CD," ).append("\n"); 
		query.append("       '' as POD_CD," ).append("\n"); 
		query.append("       '' as POR_CD," ).append("\n"); 
		query.append("       '' as DEL_CD," ).append("\n"); 
		query.append("       '' as BKG_NO," ).append("\n"); 
		query.append("       '' as BL_NO," ).append("\n"); 
		query.append("       '' as BKG_OFC_CD," ).append("\n"); 
		query.append("       '' as BKG_STS_CD," ).append("\n"); 
		query.append("       '' as TS_SEARCH_FLAG," ).append("\n"); 
		query.append("       '' as BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       '' as p_pol_cd," ).append("\n"); 
		query.append("       '' as p_pol_yard_cd," ).append("\n"); 
		query.append("       '' as p_search_pofe_yard_cd," ).append("\n"); 
		query.append("       '' as p_option," ).append("\n"); 
		query.append("       '' as POL_YD_CD," ).append("\n"); 
		query.append("       '' as POD_YD_CD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}