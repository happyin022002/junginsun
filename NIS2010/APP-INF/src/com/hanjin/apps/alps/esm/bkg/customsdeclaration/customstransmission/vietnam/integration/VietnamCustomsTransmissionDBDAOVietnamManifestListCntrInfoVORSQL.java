/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VietnamCustomsTransmissionDBDAOVietnamManifestListCntrInfoVORSQL.java
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

public class VietnamCustomsTransmissionDBDAOVietnamManifestListCntrInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VietnamManifestListCntrInfoVO 만드는 쿼리
	  * </pre>
	  */
	public VietnamCustomsTransmissionDBDAOVietnamManifestListCntrInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration ").append("\n"); 
		query.append("FileName : VietnamCustomsTransmissionDBDAOVietnamManifestListCntrInfoVORSQL").append("\n"); 
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
		query.append("'' CNTR_NBR  ," ).append("\n"); 
		query.append("'' CNTR_TYPE ," ).append("\n"); 
		query.append("'' CNTR_STATUS,  " ).append("\n"); 
		query.append("'' CNTR_FM_IND," ).append("\n"); 
		query.append("'' CNTR_G_WGT,    " ).append("\n"); 
		query.append("'' CNTR_G_WGT_UNIT," ).append("\n"); 
		query.append("'' CNTR_T_WGT," ).append("\n"); 
		query.append("'' CNTR_T_WGT_UNIT," ).append("\n"); 
		query.append("'' CNTR_TMP," ).append("\n"); 
		query.append("'' CGO_TMP_UNIT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}