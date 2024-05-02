/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RocsManifestLIstDownloadDBDAOsearchCargoDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.22 
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

public class RocsManifestLIstDownloadDBDAOsearchCargoDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관 신고용 Container의 Cargo 정보를 조회한다.
	  * </pre>
	  */
	public RocsManifestLIstDownloadDBDAOsearchCargoDetailRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestLIstDownloadDBDAOsearchCargoDetailRSQL").append("\n"); 
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
		query.append("SELECT  VSL_CALL_REF_NO," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_MF_SEQ," ).append("\n"); 
		query.append("PCK_TP_CD," ).append("\n"); 
		query.append("PCK_QTY," ).append("\n"); 
		query.append("PCK_DESC," ).append("\n"); 
		query.append("CNTR_WGT_UT_CD," ).append("\n"); 
		query.append("CNTR_MF_WGT," ).append("\n"); 
		query.append("HAMO_TRF_CD," ).append("\n"); 
		query.append("CNTR_MF_DESC," ).append("\n"); 
		query.append("SUBSTR(NVL(CNTR_MF_DESC,''),0,30)   CNTR_MF_DESC2" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_RTM_CGO_MF" ).append("\n"); 
		query.append("WHERE  VSL_CALL_REF_NO = @[frm_crn_number]" ).append("\n"); 
		query.append("AND	BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}