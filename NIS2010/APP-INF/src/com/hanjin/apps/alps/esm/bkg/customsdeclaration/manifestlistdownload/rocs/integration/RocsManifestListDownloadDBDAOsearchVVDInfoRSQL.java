/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchVVDInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOsearchVVDInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS VVD 정보 조회
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchVVDInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOsearchVVDInfoRSQL").append("\n"); 
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
		query.append("SELECT SKD.VSL_CD||SKD.SKD_VOY_NO||SKD.SKD_DIR_CD VVD_NUMBER" ).append("\n"); 
		query.append("      , SKD.CLPT_IND_SEQ AS POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("      , TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD') VPS_ETA_DT" ).append("\n"); 
		query.append("      , VSL.VSL_ENG_NM" ).append("\n"); 
		query.append(" FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("     , MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append(" WHERE SKD.VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("   #if (${frm_pod_clpt_ind_seq} != '')" ).append("\n"); 
		query.append("   AND SKD.CLPT_IND_SEQ = @[frm_pod_clpt_ind_seq]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND SKD.VPS_PORT_CD = 'NLRTM'" ).append("\n"); 
		query.append("   AND SKD.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("   AND NVL(SKD.SKD_CNG_STS_CD, 'XX') !='S'" ).append("\n"); 

	}
}