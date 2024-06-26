/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchCRNRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.26 
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

public class RocsManifestListDownloadDBDAOsearchCRNRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RTM VSL 에서 CRN정보를 찾아온다
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchCRNRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_crn_number",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : RocsManifestListDownloadDBDAOsearchCRNRSQL").append("\n"); 
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
		query.append("SELECT BKG.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("       , BKG.VSL_CD" ).append("\n"); 
		query.append("       , BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("       , BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("       , BKG.VVD_NM VSL_ENG_NM" ).append("\n"); 
		query.append("       , TO_CHAR(BKG.DEM_FREE_DT,'YYYY-MM-DD') DEM_FREE_DT" ).append("\n"); 
		query.append("       , BKG.BRTH_CTNT" ).append("\n"); 
		query.append("       , BKG.NTFY_LTR_CTNT" ).append("\n"); 
		query.append("       , BKG.CSTMS_DECL_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(BKG.CRE_DT,'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append("       , TO_CHAR(SKD.VPS_ETA_DT,'YYYY-MM-DD') VPS_ETA_DT" ).append("\n"); 
		query.append("       , (BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD) VVD_NUMBER" ).append("\n"); 
		query.append("       , NVL(BKG.POD_CLPT_IND_SEQ, '1') AS POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_RTM_VSL BKG" ).append("\n"); 
		query.append("       , VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${frm_crn_number}!= '') 	" ).append("\n"); 
		query.append("   AND BKG.VSL_CALL_REF_NO  = @[frm_crn_number] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '') 	" ).append("\n"); 
		query.append("   AND BKG.VSL_CD        = @[vsl_cd] " ).append("\n"); 
		query.append("   AND BKG.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND BKG.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("   #if (${frm_pod_clpt_ind_seq} != '')" ).append("\n"); 
		query.append("	 AND NVL(BKG.POD_CLPT_IND_SEQ, '1') = @[frm_pod_clpt_ind_seq]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND BKG.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("   AND BKG.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND BKG.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND NVL(BKG.POD_CLPT_IND_SEQ, '1') = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("   AND SKD.VPS_PORT_CD    = 'NLRTM'" ).append("\n"); 
		query.append("   AND NVL(SKD.SKD_CNG_STS_CD, 'XX') != 'S'" ).append("\n"); 
		query.append("  ORDER BY SKD.TURN_PORT_FLG" ).append("\n"); 

	}
}