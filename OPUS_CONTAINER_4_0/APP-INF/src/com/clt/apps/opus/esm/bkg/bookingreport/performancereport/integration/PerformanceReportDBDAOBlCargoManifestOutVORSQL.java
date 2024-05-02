/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOBlCargoManifestOutVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.10.13 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOBlCargoManifestOutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOBlCargoManifestOutVORSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOBlCargoManifestOutVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOBlCargoManifestOutVORSQL").append("\n"); 
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
		query.append("/* Out VO */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'seq' seq_no" ).append("\n"); 
		query.append(", ' ' GROUP_TITLE" ).append("\n"); 
		query.append(", ' ' GROUP_TOTAL" ).append("\n"); 
		query.append(", ' ' TOTAL_PKG" ).append("\n"); 
		query.append(", ' ' TOTAL_KGS" ).append("\n"); 
		query.append(", ' ' TOTAL_LBS" ).append("\n"); 
		query.append(", ' ' HD_VVD_CD" ).append("\n"); 
		query.append(", ' ' HD_POL_POD" ).append("\n"); 
		query.append(", ' ' HD_POL_POD_CD" ).append("\n"); 
		query.append(", ' ' HD_ETA_ETD" ).append("\n"); 
		query.append(", ' ' HD_ETA_ETD_CD" ).append("\n"); 
		query.append(", ' ' HD_MODE_TYPE" ).append("\n"); 
		query.append(", ' ' PRE_POST_VVD" ).append("\n"); 
		query.append(", ' ' PRE_POST_POL_CD" ).append("\n"); 
		query.append(", ' ' PRE_POST_POL_YD_CD" ).append("\n"); 
		query.append(", ' ' PRE_POST_POD_CD" ).append("\n"); 
		query.append(", ' ' PRE_POST_POD_YD_CD" ).append("\n"); 
		query.append(", ' ' BKG_NO" ).append("\n"); 
		query.append(", ' ' BKG_CGO_TP_CD" ).append("\n"); 
		query.append(", ' ' BL_NO" ).append("\n"); 
		query.append(", ' ' POR_CD" ).append("\n"); 
		query.append(", ' ' POL_CD" ).append("\n"); 
		query.append(", ' ' POL_YD_CD" ).append("\n"); 
		query.append(", ' ' POD_CD" ).append("\n"); 
		query.append(", ' ' POD_YD_CD" ).append("\n"); 
		query.append(", ' ' DEL_CD" ).append("\n"); 
		query.append(", ' ' DEL_YD_CD" ).append("\n"); 
		query.append(", ' ' RD_CD1" ).append("\n"); 
		query.append(", ' ' RD_CD2" ).append("\n"); 
		query.append(", ' ' LT" ).append("\n"); 
		query.append(", ' ' EF" ).append("\n"); 
		query.append(", ' ' PKG1" ).append("\n"); 
		query.append(", ' ' PKG2" ).append("\n"); 
		query.append(", ' ' WGT1" ).append("\n"); 
		query.append(", ' ' WGT2" ).append("\n"); 
		query.append(", ' ' SO_NO" ).append("\n"); 
		query.append(", ' ' REP" ).append("\n"); 
		query.append(", ' ' AS_CD" ).append("\n"); 
		query.append(", ' ' DG" ).append("\n"); 
		query.append(", ' ' RF" ).append("\n"); 
		query.append(", ' ' AW" ).append("\n"); 
		query.append(", ' ' BB" ).append("\n"); 
		query.append(", ' ' BDR" ).append("\n"); 
		query.append(", ' ' CA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' MEAS_QTY" ).append("\n"); 
		query.append(", ' ' MEAS_UT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' LBS" ).append("\n"); 
		query.append(", ' ' KGS" ).append("\n"); 
		query.append(", ' ' CBF" ).append("\n"); 
		query.append(", ' ' CBM" ).append("\n"); 
		query.append(", ' ' PRE_POST" ).append("\n"); 
		query.append(", ' ' HEADER" ).append("\n"); 
		query.append(", ' ' GROUP_ETD_ETA" ).append("\n"); 
		query.append(", ' ' GROUP_POL_POD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", '' order_by_title" ).append("\n"); 
		query.append(", '' order_by" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}