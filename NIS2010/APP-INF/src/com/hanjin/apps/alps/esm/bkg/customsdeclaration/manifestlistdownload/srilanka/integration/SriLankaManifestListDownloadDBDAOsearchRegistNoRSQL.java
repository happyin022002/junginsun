/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SriLankaManifestListDownloadDBDAOsearchRegistNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaManifestListDownloadDBDAOsearchRegistNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 스리랑카세관 Vessel Registration No 정보를 조회한다.
	  * </pre>
	  */
	public SriLankaManifestListDownloadDBDAOsearchRegistNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaManifestListDownloadDBDAOsearchRegistNoRSQL").append("\n"); 
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
		query.append("SELECT  NVL(VSL_AUTH_NO,' ') VSL_AUTH_NO,vsl_rgst_no" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_SRI_RCV_LOG" ).append("\n"); 
		query.append("WHERE   VSL_NM     = @[vsl_nm]  -- searchVsselName() 에서 조회한 값" ).append("\n"); 
		query.append("AND     SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND     SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND     SR_STS_CD = '1'" ).append("\n"); 
		query.append("AND     LK_CSTMS_RSPN_DIV_CD = 'M'" ).append("\n"); 

	}
}