/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorManifestListDBDAOBkgCstmsKrDgCgoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.07
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.06.07 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOBkgCstmsKrDgCgoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgCstmsKrDgCgoVO
	  * </pre>
	  */
	public KorManifestListDBDAOBkgCstmsKrDgCgoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOBkgCstmsKrDgCgoVORSQL").append("\n"); 
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
		query.append("SELECT  '' IB_SEQ" ).append("\n"); 
		query.append(",'' JOB" ).append("\n"); 
		query.append(",'' MSN_NO" ).append("\n"); 
		query.append(",'' SND_CHK" ).append("\n"); 
		query.append(",'' IO_BND_CD" ).append("\n"); 
		query.append(",'' BL_NO" ).append("\n"); 
		query.append(",'' NET_WEIGHT" ).append("\n"); 
		query.append(",'' VVD" ).append("\n"); 
		query.append(",'' POD_CD" ).append("\n"); 
		query.append(",'' SUBSTANCE" ).append("\n"); 
		query.append(",'' BKG_NO" ).append("\n"); 
		query.append(",'' POL_CD" ).append("\n"); 
		query.append(",'' CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append(",'' CERTI_NO" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append(",'' USER_ID" ).append("\n"); 
		query.append(",'' CNTR_SEQ" ).append("\n"); 
		query.append(",'' CERTI_SEQ_NO" ).append("\n"); 
		query.append(",'' MAX_VVD_SEQ" ).append("\n"); 
		query.append(",'' IMDG_UN_NO" ).append("\n"); 
		query.append(",'' IMDG_CLSS_CD" ).append("\n"); 
		query.append(",'' IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}