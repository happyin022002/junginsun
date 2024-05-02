/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchSpecialCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchSpecialCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSpecialCgo
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchSpecialCgoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchSpecialCgoRSQL").append("\n"); 
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
		query.append("#if (${in_spcl_cgo_type} == 'D') " ).append("\n"); 
		query.append("SELECT	" ).append("\n"); 
		query.append("	#if (${thai_ofc} == 'Y')" ).append("\n"); 
		query.append("	'Cls:'||NVL(IMDG_CLSS_CD,' ')||' UN:'||NVL(IMDG_UN_NO,' ')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	'Cls:'||NVL(IMDG_CLSS_CD,' ')||' UN:'||NVL(IMDG_UN_NO,' ')||DECODE(NVL(TRIM(HCDG_FLG), 'N'), 'Y', ' HCDG', '') SPCL_CGO_DESC" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("FROM	BKG_DG_CGO" ).append("\n"); 
		query.append("WHERE	BKG_NO       = @[in_bkg_no]" ).append("\n"); 
		query.append("AND	CNTR_NO      = @[in_cntr_no]" ).append("\n"); 
		query.append("AND	ROWNUM       = 1" ).append("\n"); 
		query.append("#elseif (${in_spcl_cgo_type} == 'R') " ).append("\n"); 
		query.append("SELECT	TO_CHAR(NVL(CDO_TEMP,0),9990.9)||'C'  SPCL_CGO_DESC" ).append("\n"); 
		query.append("FROM	BKG_RF_CGO" ).append("\n"); 
		query.append("WHERE	BKG_NO       = @[in_bkg_no]" ).append("\n"); 
		query.append("AND	CNTR_NO      = @[in_cntr_no]" ).append("\n"); 
		query.append("AND	ROWNUM       = 1" ).append("\n"); 
		query.append("#elseif (${in_spcl_cgo_type} == 'A') " ).append("\n"); 
		query.append("	#if (${thai_ofc} == 'Y')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("		'H:'||TO_CHAR(NVL(OVR_HGT,0))||'/'||" ).append("\n"); 
		query.append("		'W:'||TO_CHAR(NVL(OVR_LF_LEN, 0) + NVL(OVR_RT_LEN, 0))" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("SELECT	'F:'||TO_CHAR(NVL(OVR_FWRD_LEN,0))||'/'||" ).append("\n"); 
		query.append("		'B:'||TO_CHAR(NVL(OVR_BKWD_LEN,0))||'/'||" ).append("\n"); 
		query.append("		'H:'||TO_CHAR(NVL(OVR_HGT,0))||'/'||" ).append("\n"); 
		query.append("		'P:'||TO_CHAR(NVL(OVR_LF_LEN,0))||'/'||" ).append("\n"); 
		query.append("		'S:'||TO_CHAR(NVL(OVR_RT_LEN,0))  SPCL_CGO_DESC" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("FROM	BKG_AWK_CGO" ).append("\n"); 
		query.append("WHERE	BKG_NO       = @[in_bkg_no]" ).append("\n"); 
		query.append("AND	CNTR_NO      = @[in_cntr_no]" ).append("\n"); 
		query.append("AND	ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}