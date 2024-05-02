/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOEACNtcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.08 백형인
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

public class EacMgtDBDAOEACNtcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rejection Notice 메일 발송 VO 생성
	  * </pre>
	  */
	public EacMgtDBDAOEACNtcVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOEACNtcVORSQL").append("\n"); 
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
		query.append("SELECT '' AS RD_PARAM" ).append("\n"); 
		query.append("     , '' AS RD_PATH" ).append("\n"); 
		query.append("     , '' AS NTC_CC_RCV_EML" ).append("\n"); 
		query.append("     , '' AS EAC_NO" ).append("\n"); 
		query.append("     , '' AS NTC_HIS_SEQ" ).append("\n"); 
		query.append("     , '' AS VNDR_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("     , '' AS EML_SUBJ_CTNT" ).append("\n"); 
		query.append("     , '' AS EML_CTNT" ).append("\n"); 
		query.append("     , '' AS EML_SND_DT" ).append("\n"); 
		query.append("     , '' AS RCVR_EML" ).append("\n"); 
		query.append("     , '' AS RCVR_NAME" ).append("\n"); 
		query.append("     , '' AS RCVR_PHN_NO" ).append("\n"); 
		query.append("     , '' AS RCVR_FAX_NO" ).append("\n"); 
		query.append("     , '' AS EAC_EML_USE_FLG" ).append("\n"); 
		query.append("     , '' AS EAC_FAX_USE_FLG" ).append("\n"); 
		query.append("     , '' AS EML_SND_NO" ).append("\n"); 
		query.append("     , '' AS FAX_SND_NO" ).append("\n"); 
		query.append("     , '' AS CRE_USR_ID" ).append("\n"); 
		query.append("     , '' AS CRE_DT" ).append("\n"); 
		query.append("     , '' AS UPD_USR_ID" ).append("\n"); 
		query.append("     , '' AS UPD_DT" ).append("\n"); 
		query.append("     , '' AS VNDR_SEQ" ).append("\n"); 
		query.append("     , '' AS N3PTY_SRC_NO" ).append("\n"); 
		query.append("     , '' AS N3PTY_SRC_DT" ).append("\n"); 
		query.append("     , '' AS CURR_CD" ).append("\n"); 
		query.append("     , '' AS INV_AMT" ).append("\n"); 
		query.append("     , '' AS INV_CNG_AMT" ).append("\n"); 
		query.append("     , '' AS INV_AUD_AMT" ).append("\n"); 
		query.append("     , '' AS INV_AUD_USD_AMT" ).append("\n"); 
		query.append("     , '' AS WO_NO_CTNT" ).append("\n"); 
		query.append("     , '' AS VVD_CD_CTNT" ).append("\n"); 
		query.append("     , '' AS BL_NO" ).append("\n"); 
		query.append("     , '' AS EAC_EXPN_TP_CD" ).append("\n"); 
		query.append("     , '' AS EAC_OFC_CD" ).append("\n"); 
		query.append("     , '' AS RD_NAME" ).append("\n"); 
		query.append("     , '' AS VNDR_EML" ).append("\n"); 
		query.append("     , '' AS PHN_NO" ).append("\n"); 
		query.append("     , '' AS FAX_NO" ).append("\n"); 
		query.append("     , '' AS USR_EML" ).append("\n"); 
		query.append("     , '' AS NTC_CC_RCV_EML" ).append("\n"); 
		query.append("     , '' AS SND_YN" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}