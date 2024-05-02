/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOsearchCndVesselRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.08.10 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOsearchCndVesselRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCndVessel
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOsearchCndVesselRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOsearchCndVesselRSQL").append("\n"); 
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
		query.append("SELECT   VSL_CD" ).append("\n"); 
		query.append(",LLOYD_NO" ).append("\n"); 
		query.append(",VSL_RGST_CNT_CD" ).append("\n"); 
		query.append(",VSL_ENG_NM" ).append("\n"); 
		query.append(",RGST_PORT_CD" ).append("\n"); 
		query.append(",RGST_NO" ).append("\n"); 
		query.append(",TO_CHAR(RGST_DT, 'YYYY-MM-DD') AS RGST_DT" ).append("\n"); 
		query.append(",GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append(",NET_RGST_TONG_WGT" ).append("\n"); 
		query.append(",DWT_WGT" ).append("\n"); 
		query.append(",CRW_KNT" ).append("\n"); 
		query.append(",CALL_SGN_NO" ).append("\n"); 
		query.append(",LOA_LEN" ).append("\n"); 
		query.append(",TO_CHAR(VSL_SFT_CSTRU_CERTI_EXP_DT, 'YYYY-MM-DD') AS VSL_SFT_CSTRU_CERTI_EXP_DT" ).append("\n"); 
		query.append(",TO_CHAR(VSL_SFT_RDO_CERTI_EXP_DT, 'YYYY-MM-DD') AS VSL_SFT_RDO_CERTI_EXP_DT" ).append("\n"); 
		query.append(",TO_CHAR(VSL_SFT_EQ_CERTI_EXP_DT, 'YYYY-MM-DD') AS VSL_SFT_EQ_CERTI_EXP_DT" ).append("\n"); 
		query.append(",TO_CHAR(VSL_LOD_LINE_CERTI_EXP_DT, 'YYYY-MM-DD') AS VSL_LOD_LINE_CERTI_EXP_DT" ).append("\n"); 
		query.append(",TO_CHAR(VSL_DERAT_CERTI_EXP_DT, 'YYYY-MM-DD') AS VSL_DERAT_CERTI_EXP_DT" ).append("\n"); 
		query.append(",CRR_CD" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",'' AS EXPIRY_Dt" ).append("\n"); 
		query.append(",'' AS CERT_CD" ).append("\n"); 
		query.append("FROM   MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE	 VSL_CD = @[frm_vsl_cd]" ).append("\n"); 

	}
}