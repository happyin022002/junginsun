/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : IndiaManifestListDownloadDBDAOsearchVesselDetailAtVslRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.07
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2011.11.07 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaManifestListDownloadDBDAOsearchVesselDetailAtVslRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVesselDetailAtVsl - 운항쪽에서 조회
	  * </pre>
	  */
	public IndiaManifestListDownloadDBDAOsearchVesselDetailAtVslRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.integration").append("\n"); 
		query.append("FileName : IndiaManifestListDownloadDBDAOsearchVesselDetailAtVslRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    @[vvd_cd] VVD_CD" ).append("\n"); 
		query.append("    ,VSL_CD" ).append("\n"); 
		query.append("    ,'' SKD_VOY_NO" ).append("\n"); 
		query.append("    ,'' SKD_DIR_CD" ).append("\n"); 
		query.append("    ,@[pod_cd] POD_CD" ).append("\n"); 
		query.append("    ,'' IDA_DECL_VSL_NO" ).append("\n"); 
		query.append("    ,'' VSL_DECL_DT" ).append("\n"); 
		query.append("    ,VSL_ENG_NM VSL_NM" ).append("\n"); 
		query.append("    ,CALL_SGN_NO" ).append("\n"); 
		query.append("    ,'' IDA_LINE_NO" ).append("\n"); 
		query.append("    ,'' IDA_AGN_ID" ).append("\n"); 
		query.append("    ,VSL_RGST_CNT_CD CNT_CD" ).append("\n"); 
		query.append("    ,'' PORT_CD" ).append("\n"); 
		query.append("    ,'' ARR_DT" ).append("\n"); 
		query.append("    ,'' ARR_DT2" ).append("\n"); 
		query.append("    ,'' IBD_NO	-- TP Bond No" ).append("\n"); 
		query.append("    ,'' CRR_AGN_CD" ).append("\n"); 
		query.append("    ,'' IDA_MRN_LINE_OPR_CD  " ).append("\n"); 
		query.append("    ,'' IDA_CFS_ID" ).append("\n"); 
		query.append("    ,'' BD_AREA_CD -- Bond Code" ).append("\n"); 
		query.append("    ,'' IDA_VOY_NO" ).append("\n"); 
		query.append("    ,'' IDA_YR_NO" ).append("\n"); 
		query.append("    ,'' TRNS_OPR_ID" ).append("\n"); 
		query.append("    ,'' CRE_USR_ID" ).append("\n"); 
		query.append("    ,'' CRE_DT" ).append("\n"); 
		query.append("    ,'' UPD_USR_ID" ).append("\n"); 
		query.append("    ,'' UPD_DT" ).append("\n"); 
		query.append("    ,LLOYD_NO IDA_VSL_IMO_NO" ).append("\n"); 
		query.append("    ,'' IDA_CSTMS_HUS_NO" ).append("\n"); 
		query.append("    ,'' IDA_TML_OPR_NO	" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 

	}
}