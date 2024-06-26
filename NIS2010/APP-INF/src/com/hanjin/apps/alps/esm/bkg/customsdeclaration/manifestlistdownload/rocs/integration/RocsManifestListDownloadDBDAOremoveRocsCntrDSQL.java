/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOremoveRocsCntrDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.19 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOremoveRocsCntrDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관 Manifest 신고용 Container 정보를 삭제한다.
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOremoveRocsCntrDSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE BKG_CSTMS_RTM_CNTR" ).append("\n"); 
		query.append("WHERE  VSL_CALL_REF_NO = @[frm_crn_number]" ).append("\n"); 
		query.append("AND    BKG_NO = @[bkg_no]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOremoveRocsCntrDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}