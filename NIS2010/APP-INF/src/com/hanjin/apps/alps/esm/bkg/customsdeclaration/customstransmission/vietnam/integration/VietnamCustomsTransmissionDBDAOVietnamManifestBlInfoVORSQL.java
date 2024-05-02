/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VietnamCustomsTransmissionDBDAOVietnamManifestBlInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.24 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VietnamCustomsTransmissionDBDAOVietnamManifestBlInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VietnamManifestBlInfoVO
	  * </pre>
	  */
	public VietnamCustomsTransmissionDBDAOVietnamManifestBlInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration ").append("\n"); 
		query.append("FileName : VietnamCustomsTransmissionDBDAOVietnamManifestBlInfoVORSQL").append("\n"); 
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
		query.append("'' LOOP_IND," ).append("\n"); 
		query.append("'' BL_NO," ).append("\n"); 
		query.append("'' BKG_NO," ).append("\n"); 
		query.append("'' BL_IND," ).append("\n"); 
		query.append("'' BL_PKG," ).append("\n"); 
		query.append("'' BLPKG_UNIT," ).append("\n"); 
		query.append("'' BL_WGT," ).append("\n"); 
		query.append("'' BLWGT_UNIT," ).append("\n"); 
		query.append("'' BL_VOL," ).append("\n"); 
		query.append("'' BLVOL_UNIT," ).append("\n"); 
		query.append("'' BL_MEA," ).append("\n"); 
		query.append("'' BLMEA_UNIT," ).append("\n"); 
		query.append("'' COMMODITY_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}