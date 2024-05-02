/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearCNRInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.21
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.06.21 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOsearCNRInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * crn 정보를 가져온다
	  * * History
	  * 2012.06.20 김보배 [CHM-201218454] [BKG] [ROCS] 타 VVD에 기존재하는 CRN 생성 방지 Validation
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearCNRInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOsearCNRInfoRSQL").append("\n"); 
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
		query.append("SELECT  BKG.VSL_CALL_REF_NO,BKG.VSL_CD,BKG.SKD_VOY_NO,BKG.SKD_DIR_CD,VSL.VSL_ENG_NM," ).append("\n"); 
		query.append("TO_CHAR(BKG.DEM_FREE_DT,'YYYY-MM-DD') DEM_FREE_DT," ).append("\n"); 
		query.append("BKG.BRTH_CTNT,BKG.NTFY_LTR_CTNT,BKG.CSTMS_DECL_USR_ID,TO_CHAR(BKG.CRE_DT,'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("TO_CHAR(SKD.VPS_ETA_DT,'YYYY-MM-DD') VPS_ETA_DT," ).append("\n"); 
		query.append("(BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD) VVD_NUMBER" ).append("\n"); 
		query.append(" FROM BKG_CSTMS_RTM_VSL BKG,VSK_VSL_PORT_SKD SKD,MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${vsl_cd} == '' && ${frm_crn_number}!= '') 	" ).append("\n"); 
		query.append("              AND   BKG.VSL_CALL_REF_NO       = @[frm_crn_number] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '' && ${frm_crn_number} == '') 	" ).append("\n"); 
		query.append("              AND BKG.VSL_CD        = @[vsl_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '' && ${frm_crn_number} != '') " ).append("\n"); 
		query.append("              AND BKG.VSL_CD                = @[vsl_cd] " ).append("\n"); 
		query.append("              AND   BKG.VSL_CALL_REF_NO       = @[frm_crn_number] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no}!= '') " ).append("\n"); 
		query.append("              AND BKG.SKD_VOY_no    = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd}!= '') " ).append("\n"); 
		query.append("               AND BKG.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" AND   SKD.VPS_PORT_CD    = 'NLRTM'" ).append("\n"); 
		query.append(" AND   BKG.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append(" AND   BKG.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append(" AND   BKG.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append(" AND   BKG.VSL_CD = VSL.VSL_CD" ).append("\n"); 

	}
}