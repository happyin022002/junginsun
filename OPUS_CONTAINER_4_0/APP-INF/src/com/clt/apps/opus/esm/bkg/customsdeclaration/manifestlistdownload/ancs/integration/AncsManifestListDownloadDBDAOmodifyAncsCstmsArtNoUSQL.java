/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOmodifyAncsCstmsArtNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.24
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOmodifyAncsCstmsArtNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SSR No 변경으로 인한 Article No 중복이 발생되는 경우, 중복된 Article No를 해당 SSR No의 Max Article No + 1을 하여 중복 방지
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOmodifyAncsCstmsArtNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOmodifyAncsCstmsArtNoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ANR_BL A" ).append("\n"); 
		query.append("SET VVD_SEQ =  NVL(" ).append("\n"); 
		query.append("                   (SELECT MAX(B.VVD_SEQ)" ).append("\n"); 
		query.append("                     FROM BKG_CSTMS_ANR_VVD A, BKG_CSTMS_ANR_BL B" ).append("\n"); 
		query.append("                    WHERE A.SVC_RQST_NO = @[svc_rqst_no]" ).append("\n"); 
		query.append("                      AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                      AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("               , 0) + ROWNUM" ).append("\n"); 
		query.append("WHERE (VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BKG_NO) IN (" ).append("\n"); 
		query.append("            SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BKG_NO" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_ANR_BL " ).append("\n"); 
		query.append("            WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("            AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("            AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}