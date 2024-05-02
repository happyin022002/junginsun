/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SriLankaManifestListDownloadDBDAOsearchVsselNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaManifestListDownloadDBDAOsearchVsselNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Name을 조회한다.
	  * </pre>
	  */
	public SriLankaManifestListDownloadDBDAOsearchVsselNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaManifestListDownloadDBDAOsearchVsselNameRSQL").append("\n"); 
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
		query.append("#if(${ver_flg}=='O')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT NVL(VSL_ENG_NM,' ') vsl_eng_nm,VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("FROM   MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 	NVL(VSL.VSL_ENG_NM,' ') vsl_eng_nm," ).append("\n"); 
		query.append("		VSL.VSL_RGST_CNT_CD," ).append("\n"); 
		query.append("		VSL.LLOYD_NO," ).append("\n"); 
		query.append("		CARR.CRR_NM" ).append("\n"); 
		query.append("FROM   	MDM_VSL_CNTR VSL," ).append("\n"); 
		query.append("		MDM_CARRIER CARR" ).append("\n"); 
		query.append("WHERE 	VSL.CRR_CD = CARR.CRR_CD" ).append("\n"); 
		query.append("AND		VSL.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}