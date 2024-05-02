/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOEACPersonnelConfigVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOEACPersonnelConfigVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Personnel Config 화면의 VO 생성쿼리
	  * </pre>
	  */
	public EacMgtDBDAOEACPersonnelConfigVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOEACPersonnelConfigVORSQL").append("\n"); 
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
		query.append("SELECT '' AS EAC_USR_ID" ).append("\n"); 
		query.append("     , '' AS EAC_USR_NM" ).append("\n"); 
		query.append("     , '' AS PHN_NO" ).append("\n"); 
		query.append("     , '' AS FAX_NO" ).append("\n"); 
		query.append("     , '' AS USR_EML" ).append("\n"); 
		query.append("     , '' AS NTC_CC_RCV_EML" ).append("\n"); 
		query.append("     , '' AS EXPN_AUD_SCP_DESC" ).append("\n"); 
		query.append("     , '' AS EML_SUBJ_CTNT" ).append("\n"); 
		query.append("     , '' AS EML_CTNT" ).append("\n"); 
		query.append("     , '' AS DELT_FLG" ).append("\n"); 
		query.append("     , '' AS CRE_USR_ID" ).append("\n"); 
		query.append("     , '' AS CRE_DT" ).append("\n"); 
		query.append("     , '' AS UPD_USR_ID" ).append("\n"); 
		query.append("     , '' AS UPD_DT " ).append("\n"); 
		query.append("     , '' AS S_RHQ_OFC_CD" ).append("\n"); 
		query.append("     , '' AS S_OFC_CD" ).append("\n"); 
		query.append("     , '' AS RHQ_OFC_CD" ).append("\n"); 
		query.append("     , '' AS OFC_CD" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}