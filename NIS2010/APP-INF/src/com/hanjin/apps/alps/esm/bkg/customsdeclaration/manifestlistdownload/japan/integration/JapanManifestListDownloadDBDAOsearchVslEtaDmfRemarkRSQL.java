/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchVslEtaDmfRemarkRSQL.java
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

public class JapanManifestListDownloadDBDAOsearchVslEtaDmfRemarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVslEtaDmfRemark
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchVslEtaDmfRemarkRSQL(){
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
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchVslEtaDmfRemarkRSQL").append("\n"); 
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
		query.append("    A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD IN_VVD_CD," ).append("\n"); 
		query.append("	A.POD_CD IN_POD_CD," ).append("\n"); 
		query.append("	TO_CHAR(A.ETA_DT,'YYYY-MM-DD') ETA_DT1," ).append("\n"); 
		query.append("	TO_CHAR(A.ETA_DT,'HH24MISS') ETA_DT2," ).append("\n"); 
		query.append("    TO_CHAR(A.ETB_DT,'YYYY-MM-DD') ETB_DT1," ).append("\n"); 
		query.append("	TO_CHAR(A.ETB_DT,'HH24MISS') ETB_DT2," ).append("\n"); 
		query.append("	A.ARR_YD_ID  ARR_YD_CD," ).append("\n"); 
		query.append("	NVL(B.LODG_WGT ,0) LODG_WGT," ).append("\n"); 
		query.append("	B.CSTMS_MF_ID IN_POD_CD_SPLIT,    " ).append("\n"); 
		query.append("	B.MF_RMK" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_VSL_SKD A, " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_VSL B" ).append("\n"); 
		query.append("WHERE A.VSL_CD        = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD    = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n"); 
		query.append("AND A.POD_CD = @[in_pod_cd]" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND A.POD_CD = B.POD_CD(+)" ).append("\n"); 

	}
}