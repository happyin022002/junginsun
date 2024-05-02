/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchCRNExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.03 
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

public class RocsManifestListDownloadDBDAOsearchCRNExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력받은 CRN, VVD, POD Calling Seq가 ROTTERDAM Vessel 관리 테이블에 존재여부 확인
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchCRNExistRSQL(){
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
		query.append("FileName : RocsManifestListDownloadDBDAOsearchCRNExistRSQL").append("\n"); 
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
		query.append("SELECT RVSL.VSL_CALL_REF_NO" ).append("\n"); 
		query.append("	  , RVSL.VSL_CALL_REF_STS_CD" ).append("\n"); 
		query.append("      , RVSL.VSL_CD" ).append("\n"); 
		query.append("      , RVSL.SKD_VOY_NO" ).append("\n"); 
		query.append("      , RVSL.SKD_DIR_CD" ).append("\n"); 
		query.append("      , TO_CHAR(RVSL.VVD_ETA_DT,'yyyy-mm-dd') AS VPS_ETA_DT" ).append("\n"); 
		query.append("      , NVL(RVSL.POD_CLPT_IND_SEQ, '1') AS POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_RTM_VSL RVSL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if ( ${frm_crn_number} != '')" ).append("\n"); 
		query.append("AND RVSL.VSL_CALL_REF_NO = @[frm_crn_number]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${vsl_cd} != '')" ).append("\n"); 
		query.append("AND RVSL.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND RVSL.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND RVSL.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("	#if (${frm_pod_clpt_ind_seq} != '')" ).append("\n"); 
		query.append("	AND NVL(RVSL.POD_CLPT_IND_SEQ, '1') = @[frm_pod_clpt_ind_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}