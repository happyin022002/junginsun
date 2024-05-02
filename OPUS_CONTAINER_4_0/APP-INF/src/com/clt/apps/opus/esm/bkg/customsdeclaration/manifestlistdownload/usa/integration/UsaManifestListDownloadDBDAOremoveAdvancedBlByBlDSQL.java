/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOremoveAdvancedBlByBlDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOremoveAdvancedBlByBlDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * removeAdvancedBlByBl
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOremoveAdvancedBlByBlDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOremoveAdvancedBlByBlDSQL").append("\n"); 
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
		query.append("DELETE FROM BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("AND ( #foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("#if($velocityCount > 1)" ).append("\n"); 
		query.append("OR #end      BL_NO IN ( $field_id )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}