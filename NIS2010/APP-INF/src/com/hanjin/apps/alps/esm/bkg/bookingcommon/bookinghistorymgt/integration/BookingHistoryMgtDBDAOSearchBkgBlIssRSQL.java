/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchBkgBlIssRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.23 
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

public class BookingHistoryMgtDBDAOSearchBkgBlIssRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchBkgBlIssRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchBkgBlIssRSQL(){
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
		query.append("FileName : BookingHistoryMgtDBDAOSearchBkgBlIssRSQL").append("\n"); 
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
		query.append(", BL_RDY_TP_CD" ).append("\n"); 
		query.append(", BL_RDY_FLG" ).append("\n"); 
		query.append(", BL_RDY_OFC_CD" ).append("\n"); 
		query.append(", BL_RDY_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(BL_RDY_DT, 'YYYY-MM-DD HH24:MI:SS') BL_RDY_DT" ).append("\n"); 
		query.append(", RQST_BL_TP_CD" ).append("\n"); 
		query.append(", OBL_RT_INCL_KNT" ).append("\n"); 
		query.append(", OBL_RT_XCLD_KNT" ).append("\n"); 
		query.append(", OBL_TTL_KNT" ).append("\n"); 
		query.append(", NON_NEGO_RT_INCL_KNT" ).append("\n"); 
		query.append(", NON_NEGO_RT_XCLD_KNT" ).append("\n"); 
		query.append(", CPY_TTL_KNT" ).append("\n"); 
		query.append(", RQST_ISS_PLC_NM" ).append("\n"); 
		query.append(", TO_CHAR(RQST_ISS_DT, 'YYYY-MM-DD HH24:MI:SS') RQST_ISS_DT" ).append("\n"); 
		query.append(", BL_DE_TO_CD" ).append("\n"); 
		query.append(", BL_DE_MZD_CD" ).append("\n"); 
		query.append(", BL_DOC_RQST_RMK" ).append("\n"); 
		query.append(", BL_ISS_KNT" ).append("\n"); 
		query.append(", BL_CPY_KNT" ).append("\n"); 
		query.append(", BL_PRN_VIA_CD" ).append("\n"); 
		query.append(", OBL_INET_FLG" ).append("\n"); 
		query.append(", TO_CHAR(OBL_INET_PRN_DT, 'YYYY-MM-DD HH24:MI:SS') OBL_INET_PRN_DT" ).append("\n"); 
		query.append(", OBL_PRN_FLG" ).append("\n"); 
		query.append(", TO_CHAR(CSTMS_CNTR_EXP_DT, 'YYYY-MM-DD HH24:MI:SS') CSTMS_CNTR_EXP_DT" ).append("\n"); 
		query.append(", TO_CHAR(OBL_ISS_DT, 'YYYY-MM-DD HH24:MI:SS') OBL_ISS_DT" ).append("\n"); 
		query.append(", OBL_ISS_OFC_CD" ).append("\n"); 
		query.append(", OBL_ISS_USR_ID" ).append("\n"); 
		query.append(", OBL_ISS_TP_CD" ).append("\n"); 
		query.append(", OBL_ISS_KNT" ).append("\n"); 
		query.append(", OBL_ISS_FLG" ).append("\n"); 
		query.append(", OBL_RLSE_FLG" ).append("\n"); 
		query.append(", OBL_SRND_FLG" ).append("\n"); 
		query.append(", OBL_RDEM_FLG" ).append("\n"); 
		query.append(", OBL_RDEM_OFC_CD" ).append("\n"); 
		query.append(", OBL_RDEM_USR_ID" ).append("\n"); 
		query.append(", OBL_RDEM_UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(OBL_RDEM_DT, 'YYYY-MM-DD HH24:MI:SS') OBL_RDEM_DT" ).append("\n"); 
		query.append(", OBL_RDEM_KNT" ).append("\n"); 
		query.append(", OTR_DOC_CGOR_FLG" ).append("\n"); 
		query.append(", BL_OTR_DOC_RCV_CD" ).append("\n"); 
		query.append(", OTR_DOC_RCV_OFC_CD" ).append("\n"); 
		query.append(", OTR_DOC_RCV_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(OTR_DOC_RCV_DT, 'YYYY-MM-DD HH24:MI:SS') OTR_DOC_RCV_DT" ).append("\n"); 
		query.append(", IBD_DOC_RCV_FLG" ).append("\n"); 
		query.append(", IBD_DOC_RCV_OFC_CD" ).append("\n"); 
		query.append(", IBD_DOC_RCV_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(IBD_DOC_RCV_DT, 'YYYY-MM-DD HH24:MI:SS') IBD_DOC_RCV_DT" ).append("\n"); 
		query.append(", CSTMS_ENTR_CD" ).append("\n"); 
		query.append(", CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append(", CSTMS_CLR_WH_NM" ).append("\n"); 
		query.append(", ORG_PPD_RCV_CD" ).append("\n"); 
		query.append(", ORG_PPD_RCV_UPD_OFC_CD" ).append("\n"); 
		query.append(", ORG_N3PTY_PPD_CD" ).append("\n"); 
		query.append(", ORG_N3PTY_PPD_UPD_OFC_CD" ).append("\n"); 
		query.append(", DEST_CLT_RCV_CD" ).append("\n"); 
		query.append(", DEST_CLT_RCV_UPD_OFC_CD" ).append("\n"); 
		query.append(", DEST_N3PTY_CLT_CD" ).append("\n"); 
		query.append(", DEST_N3PTY_CLT_UPD_OFC_CD" ).append("\n"); 
		query.append(", OBL_ISS_RMK" ).append("\n"); 
		query.append(", (SELECT WM_CONCAT(OBL_INTER_SER_NO) FROM BKG_INET_BL_PRN_AUTH WHERE BKG_NO = @[bkg_no] AND DELT_FLG = 'N') AS OBL_INTER_SER_NO" ).append("\n"); 
		query.append("  FROM BKG_BL_ISS" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}