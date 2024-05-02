/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOEurCrnRcvMsgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.07
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.06.07 김보배
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

public class EurCustomsTransmissionDBDAOEurCrnRcvMsgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EurCrnRcvMsgVO 생성을 위해 사용
	  * * History
	  * * 2012.06.07 김보배 [CHM-201218012] [BKG] [Spain EXS] Previous Doc Ref#관련 Subplace 항목추가 (MEDCUSRPL F/File, EXS F/File, EXS BL inquiry screen)
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOEurCrnRcvMsgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOEurCrnRcvMsgVORSQL").append("\n"); 
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
		query.append("    '' AS CNT_CD, '' AS MSG_SND_OFC_CD, '' AS MF_NO, '' AS REF_GDS_ITM_NM, '' AS MSG_FUNC_ID, " ).append("\n"); 
		query.append("    '' AS MSG_SND_DT, '' AS POD_CD, '' AS CNTR_RGST_KNT, '' AS CRE_USR_ID, '' AS UPD_USR_ID, " ).append("\n"); 
		query.append("    '' AS BL_NO, '' AS F_MSG_FLAG, '' AS CRE_DT, '' AS PRE_VSL_DCHG_YD_NM, '' AS SEARCH_PREV_DOC_NO," ).append("\n"); 
		query.append("    '' AS PREV_DOC_NO, '' AS PREV_DOC_NOS, '' AS FIXED, '' AS CHK" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}