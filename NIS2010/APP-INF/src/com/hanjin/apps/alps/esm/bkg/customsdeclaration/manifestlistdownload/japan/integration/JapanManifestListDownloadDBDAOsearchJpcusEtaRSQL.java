/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchJpcusEtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchJpcusEtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchJpcusEta
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchJpcusEtaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchJpcusEtaRSQL").append("\n"); 
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
		query.append("	--NVL(TO_CHAR(ETA_DT,'YYYYMMDD'),' ') ETA_DT," ).append("\n"); 
		query.append("	TO_CHAR(SKD.ETA_DT,'YYYY-MM-DD') ETA_DT," ).append("\n"); 
		query.append("	--NVL(CALL_SGN_NO, ' ') CALL_SGN_NO" ).append("\n"); 
		query.append("	SKD.CALL_SGN_NO," ).append("\n"); 
		query.append("	VSL.CSTMS_MF_ID" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_VSL_SKD SKD," ).append("\n"); 
		query.append("	BKG_CSTMS_JP_VSL VSL" ).append("\n"); 
		query.append("WHERE SKD.VSL_CD        = @[in_vsl_cd]" ).append("\n"); 
		query.append("and SKD.SKD_VOY_NO = @[in_skd_voy_no]" ).append("\n"); 
		query.append("and SKD.SKD_DIR_CD    = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("and SKD.POD_CD    = @[in_pod_cd]" ).append("\n"); 
		query.append("AND SKD.VSL_CD = VSL.VSL_CD(+)" ).append("\n"); 
		query.append("AND SKD.SKD_VOY_NO = VSL.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND SKD.SKD_DIR_CD = VSL.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND SKD.POD_CD = VSL.POD_CD(+)" ).append("\n"); 

	}
}