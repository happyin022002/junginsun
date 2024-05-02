/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialManifestDBDAODgCargoCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAODgCargoCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DgCargoCondVO 생성을 위해 사용
	  * </pre>
	  */
	public SpecialManifestDBDAODgCargoCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration ").append("\n"); 
		query.append("FileName : SpecialManifestDBDAODgCargoCondVORSQL").append("\n"); 
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
		query.append("SELECT '' bkg_no" ).append("\n"); 
		query.append("    , '' vvd_cd" ).append("\n"); 
		query.append("    , '' cntr_no" ).append("\n"); 
		query.append("    , '' d_type" ).append("\n"); 
		query.append("    , '' port_cd" ).append("\n"); 
		query.append("    , '' bl_no" ).append("\n"); 
		query.append("    , '' cntr_cgo_seq" ).append("\n"); 
		query.append("    , '' call_gubun" ).append("\n"); 
		query.append("FROM DUAL " ).append("\n"); 

	}
}