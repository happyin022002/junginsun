/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOsearchPodRoutDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.30
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.07.30 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjeong Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOsearchPodRoutDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPodRoutDesc
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOsearchPodRoutDescRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOsearchPodRoutDescRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(MAX(SYS_CONNECT_BY_PATH (POD_CD,';')),2)||';' AS POD_ROUT_DESC" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("    SELECT 	BKG_NO, POD_CD," ).append("\n"); 
		query.append("    		ROW_NUMBER() OVER(PARTITION BY BKG_NO ORDER BY BKG_NO, VSL_PRE_PST_CD, VSL_SEQ) RNUM" ).append("\n"); 
		query.append("    FROM   	BKG_VVD" ).append("\n"); 
		query.append("    WHERE  	1=1" ).append("\n"); 
		query.append("    AND    	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND		VSL_PRE_PST_CD||VSL_SEQ >= ( SELECT VSL_PRE_PST_CD||VSL_SEQ FROM BKG_VVD" ).append("\n"); 
		query.append("                                          WHERE BKG_NO 				= @[bkg_no]" ).append("\n"); 
		query.append("                                          AND 	POD_CD 				= @[bkg_pod_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                          AND 	VSL_CD 				= @[vsl_cd]" ).append("\n"); 
		query.append("                                          AND 	SKD_VOY_NO			= @[skd_voy_no]" ).append("\n"); 
		query.append("                                          AND 	SKD_DIR_CD			= @[skd_dir_cd])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY BKG_NO" ).append("\n"); 
		query.append("START WITH RNUM = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RNUM = RNUM - 1 AND PRIOR BKG_NO = BKG_NO" ).append("\n"); 

	}
}