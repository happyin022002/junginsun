/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CndCustomsTransmissionDBDAOCndCstmsManifestAmendmentCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.18
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.05.18 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndCustomsTransmissionDBDAOCndCstmsManifestAmendmentCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CndCstmsManifestAmendmentCondVO
	  * </pre>
	  */
	public CndCustomsTransmissionDBDAOCndCstmsManifestAmendmentCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndCustomsTransmissionDBDAOCndCstmsManifestAmendmentCondVORSQL").append("\n"); 
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
		query.append(" '' AS AI_TYPE" ).append("\n"); 
		query.append(",'' AS VVD_CD" ).append("\n"); 
		query.append(",'' AS POL_CD" ).append("\n"); 
		query.append(",'' AS POD_CD" ).append("\n"); 
		query.append(",'' AS SND_DT_FLG" ).append("\n"); 
		query.append(",'' AS S_SND_DT" ).append("\n"); 
		query.append(",'' AS E_SND_DT" ).append("\n"); 
		query.append(",'' AS FULL_MTY_CD" ).append("\n"); 
		query.append(",'' AS BKG_OFC_CD" ).append("\n"); 
		query.append(",'' AS DOC_USR_ID" ).append("\n"); 
		query.append(",'' AS OB_SREP_CD" ).append("\n"); 
		query.append(",'' AS BKG_NO" ).append("\n"); 
		query.append(",'' AS MBL_NO" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}