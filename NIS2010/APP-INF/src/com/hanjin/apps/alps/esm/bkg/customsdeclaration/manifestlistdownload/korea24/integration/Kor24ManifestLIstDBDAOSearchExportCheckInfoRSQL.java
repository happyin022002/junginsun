/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Kor24ManifestLIstDBDAOSearchExportCheckInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.31
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.10.31 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestLIstDBDAOSearchExportCheckInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Download전의 Export Lic. No를 구한다.
	  * </pre>
	  */
	public Kor24ManifestLIstDBDAOSearchExportCheckInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n"); 
		query.append("FileName : Kor24ManifestLIstDBDAOSearchExportCheckInfoRSQL").append("\n"); 
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
		query.append("SELECT 'Y' BKG_CHECK" ).append("\n"); 
		query.append("FROM BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[a_bkg_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}