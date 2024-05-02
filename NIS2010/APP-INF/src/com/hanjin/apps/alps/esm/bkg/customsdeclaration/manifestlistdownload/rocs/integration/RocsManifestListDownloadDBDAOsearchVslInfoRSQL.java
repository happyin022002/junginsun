/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.10 
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

public class RocsManifestListDownloadDBDAOsearchVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관에 신고할 대상 Vessel ETA, ETD, Booking Count 정보를 조회한다.
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchVslInfoRSQL(){
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
		query.append("FileName : RocsManifestListDownloadDBDAOsearchVslInfoRSQL").append("\n"); 
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
		query.append("SELECT MST.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("       , MST.VSL_CD||MST.SKD_VOY_NO||MST.SKD_DIR_CD VVD_NUMBER" ).append("\n"); 
		query.append("       , MST.VSL_CD" ).append("\n"); 
		query.append("       , MST.SKD_VOY_NO" ).append("\n"); 
		query.append("       , MST.SKD_DIR_CD" ).append("\n"); 
		query.append("       , NVL(MST.POD_CLPT_IND_SEQ,'1') AS POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("       , VSL.VSL_ENG_NM" ).append("\n"); 
		query.append("       , to_char(skd.VPS_ETA_DT,'YYYY-MM-DD') vps_eta_dt" ).append("\n"); 
		query.append("       , to_char(skd.VPS_ETD_DT,'YYYY-MM-DD') vps_etd_dt" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_RTM_VSL MST" ).append("\n"); 
		query.append("       , VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("       , MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append(" WHERE SKD.VPS_PORT_CD = 'NLRTM'" ).append("\n"); 
		query.append("   AND SKD.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("   AND SKD.VSL_CD = MST.VSL_CD" ).append("\n"); 
		query.append("   AND SKD.SKD_VOY_NO = MST.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND SKD.SKD_DIR_CD = MST.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND SKD.CLPT_IND_SEQ = NVL(MST.POD_CLPT_IND_SEQ, '1')" ).append("\n"); 
		query.append("   AND NVL(SKD.SKD_CNG_STS_CD, 'XX') != 'S'" ).append("\n"); 
		query.append("   AND MST.VSL_CALL_REF_STS_CD NOT IN ('C','N')" ).append("\n"); 
		query.append("   AND MST.VSL_CALL_REF_NO = @[frm_crn_number] " ).append("\n"); 
		query.append("   AND MST.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND MST.SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("   AND MST.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   #if ( ${frm_pod_clpt_ind_seq} != '')" ).append("\n"); 
		query.append("   AND NVL(MST.POD_CLPT_IND_SEQ, '1') = @[frm_pod_clpt_ind_seq]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 

	}
}