/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsManifestLIstDownloadDBDAOmodifyCRNUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.07.02 임재택
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

public class RocsManifestLIstDownloadDBDAOmodifyCRNUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * crn 정보 update
	  * </pre>
	  */
	public RocsManifestLIstDownloadDBDAOmodifyCRNUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_ltr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dem_free_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("brth_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_call_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE BKG_CSTMS_RTM_VSL" ).append("\n"); 
		query.append("SET	 DEM_FREE_DT = TO_DATE(@[dem_free_dt],'yyyy-mm-dd')," ).append("\n"); 
		query.append("BRTH_CTNT = @[brth_ctnt]," ).append("\n"); 
		query.append("NTFY_LTR_CTNT = @[ntfy_ltr_ctnt]," ).append("\n"); 
		query.append("UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE  VSL_CALL_REF_NO = @[vsl_call_ref_no]" ).append("\n"); 
		query.append("AND    VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND 	SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND 	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestLIstDownloadDBDAOmodifyCRNUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}