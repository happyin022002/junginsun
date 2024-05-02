/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.18
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.04.18 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
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
		query.append("SELECT mst.VSL_CALL_REF_NO, mst.VSL_CD||mst.SKD_VOY_NO||mst.SKD_DIR_CD vvd_number, " ).append("\n"); 
		query.append("    MST.VSL_CD, MST.SKD_VOY_NO, MST.SKD_DIR_CD," ).append("\n"); 
		query.append("    vsl.VSL_ENG_NM, " ).append("\n"); 
		query.append("    to_char(skd.VPS_ETA_DT,'YYYY-MM-DD') vps_eta_dt, " ).append("\n"); 
		query.append("    to_char(skd.VPS_ETD_DT,'YYYY-MM-DD') vps_etd_dt" ).append("\n"); 
		query.append("	FROM  BKG_CSTMS_RTM_VSL mst, VSK_VSL_PORT_SKD skd, MDM_VSL_CNTR vsl" ).append("\n"); 
		query.append("	WHERE  (mst.VSL_CALL_REF_NO = @[frm_crn_number] " ).append("\n"); 
		query.append("    AND (mst.VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("    AND mst.SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("    AND mst.SKD_DIR_CD = @[skd_dir_cd]))" ).append("\n"); 
		query.append("	AND	 skd.VPS_PORT_CD = 'NLRTM'" ).append("\n"); 
		query.append("	AND	 skd.VSL_CD = vsl.VSL_CD" ).append("\n"); 
		query.append("	AND	 skd.VSL_CD = mst.VSL_CD" ).append("\n"); 
		query.append("	AND	 skd.SKD_VOY_NO = mst.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND	 skd.SKD_DIR_CD = mst.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND	 mst.VSL_CALL_REF_STS_CD NOT IN ('C','N')" ).append("\n"); 

	}
}