/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchVVDRegRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.07.15 임재택
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

public class RocsManifestListDownloadDBDAOsearchVVDRegRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 번호 체크
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchVVDRegRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : RocsManifestListDownloadDBDAOsearchVVDRegRSQL").append("\n"); 
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
		query.append("SELECT skd.VSL_CD||skd.SKD_VOY_NO||skd.SKD_DIR_CD vvd_number,to_char(VPS_ETA_DT,'YYYY-MM-DD') vps_eta_dt ,VSL_ENG_NM,VSL_CALL_REF_NO" ).append("\n"); 
		query.append("FROM  VSK_VSL_PORT_SKD skd, MDM_VSL_CNTR vsl, BKG_CSTMS_RTM_VSL mst" ).append("\n"); 
		query.append("WHERE skd.VSL_CD      =  @[vsl_cd]" ).append("\n"); 
		query.append("AND skd.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND skd.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND VPS_PORT_CD = 'NLRTM'" ).append("\n"); 
		query.append("AND skd.VSL_CD = vsl.VSL_CD" ).append("\n"); 
		query.append("AND skd.VSL_CD = mst.VSL_CD(+)" ).append("\n"); 
		query.append("AND skd.SKD_VOY_NO = mst.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND skd.SKD_DIR_CD = mst.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND VSL_CALL_REF_STS_CD(+) <> 'C'" ).append("\n"); 

	}
}