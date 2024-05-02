/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchCRNRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.15 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
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
	  * crn number 조회
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
		query.append("SELECT  VKG.VSL_CALL_REF_NO crn_number,VKG.VSL_CD,VKG.SKD_VOY_NO,VKG.SKD_DIR_CD," ).append("\n"); 
		query.append("TO_CHAR(VVD_ETA_DT,'yyyy-mm-dd') VVD_ETA_DT,VVD_NM," ).append("\n"); 
		query.append("VKG.VSL_CD||VKG.SKD_VOY_no||VKG.SKD_DIR_CD vvd_number" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_RTM_VSL VKG" ).append("\n"); 
		query.append("#if (${vsl_cd} == '' && ${frm_crn_number}!= '')" ).append("\n"); 
		query.append("WHERE   VKG.VSL_CALL_REF_NO       = @[frm_crn_number]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '' && ${frm_crn_number} == '')" ).append("\n"); 
		query.append("WHERE VKG.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '' && ${frm_crn_number} != '')" ).append("\n"); 
		query.append("WHERE VKG.VSL_CD                = @[vsl_cd]" ).append("\n"); 
		query.append("AND   VKG.VSL_CALL_REF_NO       = @[frm_crn_number]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no}!= '')" ).append("\n"); 
		query.append("AND VKG.SKD_VOY_no    = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd}!= '')" ).append("\n"); 
		query.append("AND VKG.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOsearchCRNRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}