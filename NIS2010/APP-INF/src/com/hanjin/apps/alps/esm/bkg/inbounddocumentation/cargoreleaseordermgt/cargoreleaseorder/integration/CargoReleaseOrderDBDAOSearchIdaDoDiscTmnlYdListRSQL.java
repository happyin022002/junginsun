/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchIdaDoDiscTmnlYdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.12
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2011.08.12 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchIdaDoDiscTmnlYdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI_BKG_0680조회화면의 COMBO 값 조회(India Cargo Release)
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchIdaDoDiscTmnlYdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchIdaDoDiscTmnlYdListRSQL").append("\n"); 
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
		query.append("select ATTR_CTNT1 AS IDA_DO_YD_CD," ).append("\n"); 
		query.append("  	   ATTR_CTNT2||ATTR_CTNT3||ATTR_CTNT4 AS IDA_DO_YD_NM" ).append("\n"); 
		query.append("from bkg_hrd_cdg_ctnt" ).append("\n"); 
		query.append("where HRD_CDG_ID = 'IDA_DO_YD_CD'" ).append("\n"); 
		query.append("order by HRD_CDG_ID_SEQ" ).append("\n"); 

	}
}