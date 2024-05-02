/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MyanmarManifestListDownloadDBDAOMyanmarManifestListBlInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.15
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2012.11.15 윤태승
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yuntaeseung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MyanmarManifestListDownloadDBDAOMyanmarManifestListBlInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MyanmarManifestListBlInfoVO 만드는 쿼리
	  * </pre>
	  */
	public MyanmarManifestListDownloadDBDAOMyanmarManifestListBlInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.integration").append("\n"); 
		query.append("FileName : MyanmarManifestListDownloadDBDAOMyanmarManifestListBlInfoVORSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("'' VSL_NM," ).append("\n"); 
		query.append("'' VSL_CALLSIGN," ).append("\n"); 
		query.append("'' ETD," ).append("\n"); 
		query.append("'' ETA," ).append("\n"); 
		query.append("'' SEQ," ).append("\n"); 
		query.append("'' VVD," ).append("\n"); 
		query.append("'' BKG_NO," ).append("\n"); 
		query.append("'' BL_NO," ).append("\n"); 
		query.append("'' CNTR_NO," ).append("\n"); 
		query.append("'' CNTR_TPSZ_CD," ).append("\n"); 
		query.append("'' SF," ).append("\n"); 
		query.append("'' RD," ).append("\n"); 
		query.append("'' LS," ).append("\n"); 
		query.append("'' B_POR," ).append("\n"); 
		query.append("'' V_POL," ).append("\n"); 
		query.append("'' V_POD," ).append("\n"); 
		query.append("'' V_POD_CD," ).append("\n"); 
		query.append("'' B_DEL," ).append("\n"); 
		query.append("'' B_DEL_CD," ).append("\n"); 
		query.append("'' ACT_WGT," ).append("\n"); 
		query.append("'' WGT_UT_CD," ).append("\n"); 
		query.append("'' MEAS_QTY," ).append("\n"); 
		query.append("'' MEAS_UT_CD," ).append("\n"); 
		query.append("'' PCK_QTY," ).append("\n"); 
		query.append("'' PCK_TP_CD," ).append("\n"); 
		query.append("'' FREIGHT," ).append("\n"); 
		query.append("'' RF," ).append("\n"); 
		query.append("'' S_DATE," ).append("\n"); 
		query.append("'' COUNTING," ).append("\n"); 
		query.append("'' TPSZ_20_CHK," ).append("\n"); 
		query.append("'' TPSZ_40_CHK," ).append("\n"); 
		query.append("'' TPSZ_TOT_CHK," ).append("\n"); 
		query.append("'' FRM_POD_CD," ).append("\n"); 
		query.append("'' FRM_POL_CD," ).append("\n"); 
		query.append("'' FRM_PORT_CD," ).append("\n"); 
		query.append("'' CNEE," ).append("\n"); 
		query.append("'' CUST_NM," ).append("\n"); 
		query.append("'' TRSM_STS," ).append("\n"); 
		query.append("'' USR_ID," ).append("\n"); 
		query.append("'' POL_GUBUN," ).append("\n"); 
		query.append("'' DESCRIPTION2," ).append("\n"); 
		query.append("'' INPUT_POL_CD," ).append("\n"); 
		query.append("'' INPUT_POD_CD," ).append("\n"); 
		query.append("'' BL_KNT," ).append("\n"); 
		query.append("'' TTL_CNTR_KNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}