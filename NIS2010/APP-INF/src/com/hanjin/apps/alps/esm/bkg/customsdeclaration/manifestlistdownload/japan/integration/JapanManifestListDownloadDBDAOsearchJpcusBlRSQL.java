/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchJpcusBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.08.20 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchJpcusBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchJpcusBl
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchJpcusBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchJpcusBlRSQL").append("\n"); 
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
		query.append("EDO_SND_STS_CD OFT_TP_CD" ).append("\n"); 
		query.append(",	CALL_SGN_NO" ).append("\n"); 
		query.append(",	ETA_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	BL_NO" ).append("\n"); 
		query.append(",	BL_SPLIT_NO" ).append("\n"); 
		query.append(",	JP_EDI_TRSM_STG_TP_CD" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	BKG_POR_CD" ).append("\n"); 
		query.append(",	BKG_POL_CD" ).append("\n"); 
		query.append(",	BKG_DEL_CD" ).append("\n"); 
		query.append(",	PST_RLY_POD_CD" ).append("\n"); 
		query.append(",	PST_VSL_CD" ).append("\n"); 
		query.append(",	PST_SKD_VOY_NO" ).append("\n"); 
		query.append(",	PST_SKD_DIR_CD" ).append("\n"); 
		query.append(",	SPLIT_FLG" ).append("\n"); 
		query.append(",	PCK_QTY" ).append("\n"); 
		query.append(",	PCK_TP_CD" ).append("\n"); 
		query.append(",	GRS_WGT" ).append("\n"); 
		query.append(",	NET_WGT" ).append("\n"); 
		query.append(",	WGT_UT_CD" ).append("\n"); 
		query.append(",	MEAS_QTY" ).append("\n"); 
		query.append(",	MEAS_UT_CD" ).append("\n"); 
		query.append(",	RCV_TERM_CD" ).append("\n"); 
		query.append(",	DE_TERM_CD" ).append("\n"); 
		query.append(",	DCGO_FLG" ).append("\n"); 
		query.append(",	BDR_FLG" ).append("\n"); 
		query.append(",	BDR_DT" ).append("\n"); 
		query.append(",	CA_DT" ).append("\n"); 
		query.append(",	CA_NO" ).append("\n"); 
		query.append(",	JP_BL_STS_CD" ).append("\n"); 
		query.append(",	IF_DT" ).append("\n"); 
		query.append(",	LOCL_TS_IND_CD LOCL_TS_FLG" ).append("\n"); 
		query.append(",	JP_CSTMS_TRNS_CD" ).append("\n"); 
		query.append(",	LMT_NO" ).append("\n"); 
		query.append(",	CY_OPR_ID CY_OPR_CD" ).append("\n"); 
		query.append(",	FULL_MTY_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CSTMS_JP_BL" ).append("\n"); 
		query.append("WHERE	BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND	BL_SPLIT_NO = NVL(@[bl_split_no],'  ')" ).append("\n"); 

	}
}