/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchTempBkgRfCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchTempBkgRfCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchTempBkgRfCgoRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchTempBkgRfCgoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchTempBkgRfCgoRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(", RC_SEQ" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", PCK_TP_CD" ).append("\n"); 
		query.append(", PCK_QTY" ).append("\n"); 
		query.append(", NET_WGT" ).append("\n"); 
		query.append(", GRS_WGT" ).append("\n"); 
		query.append(", WGT_UT_CD" ).append("\n"); 
		query.append(", CMDT_CD" ).append("\n"); 
		query.append(", CMDT_DESC" ).append("\n"); 
		query.append(", FDO_TEMP" ).append("\n"); 
		query.append(", CDO_TEMP" ).append("\n"); 
		query.append(", CNTR_VENT_TP_CD" ).append("\n"); 
		query.append(", VENT_RTO" ).append("\n"); 
		query.append(", CBM_PER_HR_QTY" ).append("\n"); 
		query.append(", HUMID_NO" ).append("\n"); 
		query.append(", DIFF_RMK" ).append("\n"); 
		query.append(", RF_DCGO_SEQ" ).append("\n"); 
		query.append(", PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append(", VLTG_NO" ).append("\n"); 
		query.append(", CTRL_ATMS_FLG" ).append("\n"); 
		query.append(", MODI_ATMS_FLG" ).append("\n"); 
		query.append(", HUMID_CTRL_FLG" ).append("\n"); 
		query.append(", ATFC_ATMS_FLG" ).append("\n"); 
		query.append(", CNTR_DRN_CD" ).append("\n"); 
		query.append(", CLNG_TP_CD" ).append("\n"); 
		query.append(", TO_CHAR(RQST_DT, 'YYYY-MM-DD HH24:MI:SS') RQST_DT" ).append("\n"); 
		query.append(", RQST_USR_ID" ).append("\n"); 
		query.append(", SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append(", CNTR_VOL_QTY" ).append("\n"); 
		query.append("  FROM BKG_RF_CGO" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}