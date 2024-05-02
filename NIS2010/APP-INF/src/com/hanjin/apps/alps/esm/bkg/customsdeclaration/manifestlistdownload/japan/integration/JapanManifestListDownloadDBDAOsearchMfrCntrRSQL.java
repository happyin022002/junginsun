/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchMfrCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchMfrCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMfrCntr
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchMfrCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_number",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchMfrCntrRSQL").append("\n"); 
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
		query.append("	BL_NO||BL_SPLIT_NO BL_NO," ).append("\n"); 
		query.append("	CNTR_NO,         " ).append("\n"); 
		query.append("	CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	CNTR_SEAL_NO,    " ).append("\n"); 
		query.append("	CNTR_SEAL_NO2,    " ).append("\n"); 
		query.append("	CNTR_SEAL_NO3,    " ).append("\n"); 
		query.append("	CNTR_SEAL_NO4,    " ).append("\n"); 
		query.append("	CNTR_SEAL_NO5,    " ).append("\n"); 
		query.append("	CNTR_SEAL_NO6,     " ).append("\n"); 
		query.append("	'U' VALUE1," ).append("\n"); 
		query.append("	PRT_FLG," ).append("\n"); 
		query.append("	RCV_TERM_CD,    " ).append("\n"); 
		query.append("	DE_TERM_CD," ).append("\n"); 
		query.append("	FULL_MTY_CD,  " ).append("\n"); 
		query.append("	JP_CNTR_OWNR_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_CSTMS_JP_BL_CNTR" ).append("\n"); 
		query.append("WHERE BL_NO       = SUBSTR(@[bl_number],1,12)" ).append("\n"); 
		query.append("AND BL_SPLIT_NO = NVL(SUBSTR(@[bl_number],13,2), '  ')  " ).append("\n"); 
		query.append("AND JP_CSTMS_CNTR_STS_CD  = 'A'" ).append("\n"); 

	}
}