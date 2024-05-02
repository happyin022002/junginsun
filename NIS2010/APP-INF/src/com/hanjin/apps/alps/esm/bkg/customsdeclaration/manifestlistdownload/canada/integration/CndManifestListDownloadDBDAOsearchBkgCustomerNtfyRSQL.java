/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOsearchBkgCustomerNtfyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.16 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOsearchBkgCustomerNtfyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgCustomerNtfy
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOsearchBkgCustomerNtfyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOsearchBkgCustomerNtfyRSQL").append("\n"); 
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
		query.append("SELECT L.LOC_NM AS CUST_CTY_NM" ).append("\n"); 
		query.append("      ,L.CNT_CD AS CUST_CNT_CD" ).append("\n"); 
		query.append("      ,SUBSTR(L.STE_CD,1,2) AS CUST_STE_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING B" ).append("\n"); 
		query.append("      ,MDM_LOCATION L" ).append("\n"); 
		query.append(" WHERE B.DEL_CD = L.LOC_CD" ).append("\n"); 
		query.append("   AND B.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}