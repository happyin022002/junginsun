/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VietnamManifestListDownloadDBDAOVietnamManifestListBlInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.21
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.21 조원주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VietnamManifestListDownloadDBDAOVietnamManifestListBlInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VietnamManifestListBlInfoVO 만드는 쿼리
	  * </pre>
	  */
	public VietnamManifestListDownloadDBDAOVietnamManifestListBlInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.integration ").append("\n"); 
		query.append("FileName : VietnamManifestListDownloadDBDAOVietnamManifestListBlInfoVORSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("'' VSL_NM," ).append("\n"); 
		query.append("'' VSL_CALLSIGN," ).append("\n"); 
		query.append("'' ETD," ).append("\n"); 
		query.append("'' ETA," ).append("\n"); 
		query.append("'' SEQ," ).append("\n"); 
		query.append("'' VVD," ).append("\n"); 
		query.append("'' BKG_NO," ).append("\n"); 
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
		query.append("'' FRM_PORT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}