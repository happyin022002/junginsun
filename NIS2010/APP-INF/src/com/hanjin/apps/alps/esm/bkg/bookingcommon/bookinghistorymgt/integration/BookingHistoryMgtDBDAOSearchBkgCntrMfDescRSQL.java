/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchBkgCntrMfDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.07 
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

public class BookingHistoryMgtDBDAOSearchBkgCntrMfDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchBkgCntrMfDescRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchBkgCntrMfDescRSQL(){
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
		query.append("FileName : BookingHistoryMgtDBDAOSearchBkgCntrMfDescRSQL").append("\n"); 
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
		query.append("SELECT A1.BKG_NO" ).append("\n"); 
		query.append(", A1.CNTR_MF_SEQ" ).append("\n"); 
		query.append(", A1.CNTR_NO" ).append("\n"); 
		query.append(", A1.PCK_QTY" ).append("\n"); 
		query.append(", A1.PCK_TP_CD" ).append("\n"); 
		query.append(", A1.CNTR_MF_WGT" ).append("\n"); 
		query.append(", A1.WGT_UT_CD" ).append("\n"); 
		query.append(", A1.MEAS_QTY" ).append("\n"); 
		query.append(", A1.MEAS_UT_CD" ).append("\n"); 
		query.append(", A1.DCGO_FLG" ).append("\n"); 
		query.append(", A1.BB_CGO_FLG" ).append("\n"); 
		query.append(", A1.AWK_CGO_FLG" ).append("\n"); 
		query.append(", A1.RC_FLG" ).append("\n"); 
		query.append(", A1.RD_CGO_FLG" ).append("\n"); 
		query.append(", A1.HNGR_FLG" ).append("\n"); 
		query.append(", A1.CNTR_MF_MK_DESC" ).append("\n"); 
		query.append(", A1.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(", A1.HBL_SEQ" ).append("\n"); 
		query.append(", A1.HAMO_TRF_CD" ).append("\n"); 
		query.append(", NVL( BKG_JOIN_FNC (CURSOR( SELECT CMDT.NCM_NO" ).append("\n"); 
		query.append("                               FROM BKG_CNTR_MF_DESC_DTL CMDT" ).append("\n"); 
		query.append("                              WHERE CMDT.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("                                AND   CMDT.CNTR_NO = A1.CNTR_NO" ).append("\n"); 
		query.append("								AND   CMDT.CNTR_MF_SEQ = A1.CNTR_MF_SEQ )" ).append("\n"); 
		query.append("                     ),A1.NCM_NO) AS NCM_NO                           " ).append("\n"); 
		query.append(", A1.PO_NO" ).append("\n"); 
		query.append(", A1.CNTR_MF_NO" ).append("\n"); 
		query.append(", A1.CSTMS_DECL_NO" ).append("\n"); 
		query.append(", A1.CRE_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(A1.CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append(", A1.UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(A1.UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append(", A1.CMDT_HS_CD" ).append("\n"); 
		query.append(", A1.WPM_TRT_CD" ).append("\n"); 
		query.append("  FROM BKG_CNTR_MF_DESC A1" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}