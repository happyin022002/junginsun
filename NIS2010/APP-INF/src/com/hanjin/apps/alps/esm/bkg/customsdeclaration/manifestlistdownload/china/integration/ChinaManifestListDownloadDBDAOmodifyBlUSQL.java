/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOmodifyBlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.31
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOmodifyBlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBl
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOmodifyBlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOmodifyBlUSQL").append("\n"); 
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
		query.append("UPDATE	BKG_CSTMS_CHN_BL BL" ).append("\n"); 
		query.append("SET	    BL.CHN_CSTMS_TRSP_MOD_CD = ( SELECT	DM.CHN_CSTMS_TRSP_MOD_CD" ).append("\n"); 
		query.append("                    				 FROM	BKG_CSTMS_CHN_DE_MOD DM" ).append("\n"); 
		query.append("                    				 WHERE	BL.BKG_POD_CD	=	DM.POD_CD" ).append("\n"); 
		query.append("                    				 AND	BL.DEL_CD		=	DM.DEL_CD" ).append("\n"); 
		query.append("                    				 AND	ROWNUM			=	1 )" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("AND ( #foreach($field_id in ${field_list}) " ).append("\n"); 
		query.append("      	#if($velocityCount > 1)" ).append("\n"); 
		query.append("      	OR #end      BL.BL_NO IN ( $field_id )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND	    EXISTS (	SELECT	'X'" ).append("\n"); 
		query.append("        			FROM	BKG_CSTMS_CHN_DE_MOD DM" ).append("\n"); 
		query.append("        			WHERE	BL.BKG_POD_CD	=	DM.POD_CD" ).append("\n"); 
		query.append("        			AND	    BL.DEL_CD		=	DM.DEL_CD" ).append("\n"); 
		query.append("        			AND	    ROWNUM			=	1 )" ).append("\n"); 

	}
}