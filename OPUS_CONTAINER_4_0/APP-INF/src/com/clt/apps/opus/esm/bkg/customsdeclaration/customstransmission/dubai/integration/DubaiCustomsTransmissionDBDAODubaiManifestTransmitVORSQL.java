/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DubaiCustomsTransmissionDBDAODubaiManifestTransmitVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.25 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiCustomsTransmissionDBDAODubaiManifestTransmitVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DubaiManifestTransmitVO 생성을 위해 사용
	  * </pre>
	  */
	public DubaiCustomsTransmissionDBDAODubaiManifestTransmitVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.integration").append("\n"); 
		query.append("FileName : DubaiCustomsTransmissionDBDAODubaiManifestTransmitVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	 '' VVD" ).append("\n"); 
		query.append("	,'' VSL_CD" ).append("\n"); 
		query.append("	,'' SKD_VOY_NO" ).append("\n"); 
		query.append("	,'' SKD_DIR_CD" ).append("\n"); 
		query.append("	,'' CLPT_SEQ" ).append("\n"); 
		query.append("	,'' POL_CD" ).append("\n"); 
		query.append("	,'' POD_CD" ).append("\n"); 
		query.append("	,'' BL_NO" ).append("\n"); 
		query.append("	,'' CNTR_NO" ).append("\n"); 
		query.append("    ,'' FLAT_FILE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}