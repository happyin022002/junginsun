/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOsearchBkgCstmsCndVslCrnNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOsearchBkgCstmsCndVslCrnNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgCstmsCndVslCrnNo
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOsearchBkgCstmsCndVslCrnNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvy_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOsearchBkgCstmsCndVslCrnNoRSQL").append("\n"); 
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
		query.append("SELECT    A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("		, A.CVY_REF_NO" ).append("\n"); 
		query.append("        ,(  SELECT DECODE(COUNT(*), 0, 'N','Y')" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_ADV_BL B" ).append("\n"); 
		query.append("            WHERE B.CNT_CD ='CA'" ).append("\n"); 
		query.append("            AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("            AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND ROWNUM =1" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          )AS DOWNLOAD_FLAG" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CND_VSL A" ).append("\n"); 
		query.append("WHERE A.CVY_REF_NO = @[cvy_ref_no]" ).append("\n"); 

	}
}