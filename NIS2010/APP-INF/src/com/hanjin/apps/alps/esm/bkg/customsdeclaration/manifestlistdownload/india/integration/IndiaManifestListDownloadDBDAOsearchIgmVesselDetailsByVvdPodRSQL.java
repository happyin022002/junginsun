/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : IndiaManifestListDownloadDBDAOsearchIgmVesselDetailsByVvdPodRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.20
*@LastModifier : 이경원
*@LastVersion : 1.0
* 2011.12.20 이경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee KyungWon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaManifestListDownloadDBDAOsearchIgmVesselDetailsByVvdPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchIgmVesselDetailsByVvdPod
	  * </pre>
	  */
	public IndiaManifestListDownloadDBDAOsearchIgmVesselDetailsByVvdPodRSQL(){
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
		query.append("FileName : IndiaManifestListDownloadDBDAOsearchIgmVesselDetailsByVvdPodRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("@[vvd_cd] VVD_CD" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",IDA_DECL_VSL_NO" ).append("\n"); 
		query.append(",TO_CHAR(VSL_DECL_DT, 'YYYYMMDD') VSL_DECL_DT" ).append("\n"); 
		query.append(",VSL_NM" ).append("\n"); 
		query.append(",CALL_SGN_NO" ).append("\n"); 
		query.append(",IDA_LINE_NO" ).append("\n"); 
		query.append(",IDA_AGN_ID	AS IDA_AGN_ID" ).append("\n"); 
		query.append(",CNT_CD" ).append("\n"); 
		query.append(",OTR_DCHG_YD_ID PORT_CD" ).append("\n"); 
		query.append(",TO_CHAR(ARR_DT, 'YYYYMMDD') ARR_DT" ).append("\n"); 
		query.append(",TO_CHAR(ARR_DT2, 'YYYYMMDD') ARR_DT2" ).append("\n"); 
		query.append(",IBD_NO	-- TP Bond No" ).append("\n"); 
		query.append(",CRR_AGN_ID AS CRR_AGN_CD" ).append("\n"); 
		query.append(",IDA_MRN_LINE_OPR_ID AS IDA_MRN_LINE_OPR_CD" ).append("\n"); 
		query.append(",IDA_CFS_ID" ).append("\n"); 
		query.append(",BD_AREA_CD	--Bond Code" ).append("\n"); 
		query.append(",IDA_VOY_NO" ).append("\n"); 
		query.append(",NVL(IDA_YR_NO, '')  IDA_YR_NO" ).append("\n"); 
		query.append(",TRNS_OPR_ID" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",IDA_VSL_IMO_NO" ).append("\n"); 
		query.append(",IDA_CSTMS_HUS_NO" ).append("\n"); 
		query.append(",IDA_TML_OPR_NO" ).append("\n"); 
		query.append(",IDA_PORT_GNTE_NO" ).append("\n"); 
		query.append(",IDA_PORT_GNTE_DT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_IDA_VSL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND VSL_CD 		= SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND	SKD_VOY_NO 	= SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND	SKD_DIR_CD 	= SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND	POD_CD		= @[pod_cd]" ).append("\n"); 

	}
}