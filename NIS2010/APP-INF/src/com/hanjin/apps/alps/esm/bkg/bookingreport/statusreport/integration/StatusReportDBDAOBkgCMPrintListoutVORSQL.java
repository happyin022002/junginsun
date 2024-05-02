/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusReportDBDAOBkgCMPrintListoutVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.10.13 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOBkgCMPrintListoutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public StatusReportDBDAOBkgCMPrintListoutVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOBkgCMPrintListoutVORSQL").append("\n"); 
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
		query.append("SELECT A.BL_NO" ).append("\n"); 
		query.append(",A.BKG_NO" ).append("\n"); 
		query.append(",A.BL_NO_TP" ).append("\n"); 
		query.append(",A.BL_TP_CD" ).append("\n"); 
		query.append(",A.OB_SREP_CD" ).append("\n"); 
		query.append(",A.POL_CD" ).append("\n"); 
		query.append(",A.RCV_TERM_CD" ).append("\n"); 
		query.append(",A.DE_TERM_CD" ).append("\n"); 
		query.append(",A.DOC_USR_ID" ).append("\n"); 
		query.append(",B.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(",B.PCK_QTY" ).append("\n"); 
		query.append(",B.CNTR_MF_WGT" ).append("\n"); 
		query.append(",B.MEAS_QTY" ).append("\n"); 
		query.append(",B.RD_CGO_FLG" ).append("\n"); 
		query.append(",B.DCGO_FLG" ).append("\n"); 
		query.append(",B.AWK_CGO_FLG" ).append("\n"); 
		query.append(",B.HNGR_FLG" ).append("\n"); 
		query.append(",B.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(",B.HAMO_TRF_CD" ).append("\n"); 
		query.append(",B.PO_NO" ).append("\n"); 
		query.append(",B.CMDT_HS_CD" ).append("\n"); 
		query.append(",C.ADV_SHTG_CD" ).append("\n"); 
		query.append(",C.CNTR_NO" ).append("\n"); 
		query.append(",C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",D.CNTR_SEAL_NO" ).append("\n"); 
		query.append(",E.CUST_CNT_CD" ).append("\n"); 
		query.append(",E.CUST_SEQ" ).append("\n"); 
		query.append(",E.CUST_NM" ).append("\n"); 
		query.append(",'' POD_CD" ).append("\n"); 
		query.append(",'' CNTC_PSON_NM" ).append("\n"); 
		query.append(",'' CNTC_PSON_FAX_NO" ).append("\n"); 
		query.append(",'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",'' MK_DESC" ).append("\n"); 
		query.append(",'' ACT_WGT" ).append("\n"); 
		query.append(",'' XPT_LIC_NO" ).append("\n"); 
		query.append(",'' TAB_TP" ).append("\n"); 
		query.append(",'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",'' PCK_TP_CD" ).append("\n"); 
		query.append(",'' CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("FROM BKG_BOOKING          A" ).append("\n"); 
		query.append(",BKG_CNTR_MF_DESC     B" ).append("\n"); 
		query.append(",BKG_CONTAINER        C" ).append("\n"); 
		query.append(",BKG_CNTR_SEAL_NO     D" ).append("\n"); 
		query.append(",BKG_CUSTOMER         E" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = E.BKG_NO" ).append("\n"); 

	}
}