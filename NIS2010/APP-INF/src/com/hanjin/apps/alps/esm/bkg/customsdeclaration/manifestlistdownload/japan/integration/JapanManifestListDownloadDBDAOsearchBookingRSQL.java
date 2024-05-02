/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2011.05.09 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBooking
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchBookingRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchBookingRSQL").append("\n"); 
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
		query.append("SELECT BL_NO," ).append("\n"); 
		query.append("	   POR_CD," ).append("\n"); 
		query.append("	   POL_CD," ).append("\n"); 
		query.append("	   DEL_CD," ).append("\n"); 
		query.append("	   PCK_QTY," ).append("\n"); 
		query.append("	   PCK_TP_CD," ).append("\n"); 
		query.append("       CASE WHEN ACT_WGT>999999.999 THEN ROUND(ACT_WGT*0.001,3) ELSE ACT_WGT END as ACT_WGT," ).append("\n"); 
		query.append("	   CASE WHEN ACT_WGT>999999.999 THEN 'TNE' ELSE KGS END as KGS," ).append("\n"); 
		query.append("	   MEAS_QTY," ).append("\n"); 
		query.append("       CBM," ).append("\n"); 
		query.append("       RCV_TERM_CD," ).append("\n"); 
		query.append("       DE_TERM_CD," ).append("\n"); 
		query.append("       DCGO_FLG," ).append("\n"); 
		query.append("       BDR_FLG," ).append("\n"); 
		query.append("       BRD_DT," ).append("\n"); 
		query.append("       BDR_CNG_FLG," ).append("\n"); 
		query.append("       CMDT_CD," ).append("\n"); 
		query.append("       BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       BKG_CGO_TP_CD2," ).append("\n"); 
		query.append("       REP_CMDT_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(  " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	A.BL_NO,  " ).append("\n"); 
		query.append("	A.POR_CD,    " ).append("\n"); 
		query.append("	A.POL_CD,      " ).append("\n"); 
		query.append("	A.DEL_CD," ).append("\n"); 
		query.append("	B.PCK_QTY, " ).append("\n"); 
		query.append("	B.PCK_TP_CD," ).append("\n"); 
		query.append("	DECODE(B.WGT_UT_CD,'LBS',B.ACT_WGT*0.4536,NVL(B.ACT_WGT,0)) ACT_WGT,  " ).append("\n"); 
		query.append("  	'KGS' KGS," ).append("\n"); 
		query.append("	DECODE(B.MEAS_UT_CD,'CBF',B.MEAS_QTY*0.0283,NVL(B.MEAS_QTY,0)) MEAS_QTY," ).append("\n"); 
		query.append("	'CBM' CBM," ).append("\n"); 
		query.append("	A.RCV_TERM_CD,        " ).append("\n"); 
		query.append("	A.DE_TERM_CD,   " ).append("\n"); 
		query.append("	A.DCGO_FLG," ).append("\n"); 
		query.append("	B.BDR_FLG,         " ).append("\n"); 
		query.append("	TO_CHAR(B.BDR_DT,'yyyymmddhh24miss') BRD_DT," ).append("\n"); 
		query.append("	B.BDR_CNG_FLG,         " ).append("\n"); 
		query.append("	A.CMDT_CD,        " ).append("\n"); 
		query.append("	DECODE(A.BKG_CGO_TP_CD,'P','M','R','M','F') BKG_CGO_TP_CD," ).append("\n"); 
		query.append("	A.POD_CD,             " ).append("\n"); 
		query.append("	DECODE(A.BKG_CGO_TP_CD,'P','M','F') BKG_CGO_TP_CD2," ).append("\n"); 
		query.append("	A.REP_CMDT_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	BKG_BOOKING A, " ).append("\n"); 
		query.append("	BKG_BL_DOC B" ).append("\n"); 
		query.append("WHERE A.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND   A.BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}