/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOEBookingControlMgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOEBookingControlMgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingControlMgmt
	  * </pre>
	  */
	public EBookingReceiptDBDAOEBookingControlMgmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOEBookingControlMgmtRSQL").append("\n"); 
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
		query.append("SELECT '' AS ROW_NUM," ).append("\n"); 
		query.append("       '' AS XTER_RQST_ACPT_CD," ).append("\n"); 
		query.append("       '' AS RQST_DT," ).append("\n"); 
		query.append("       '' AS BKG_UPLD_STS_CD," ).append("\n"); 
		query.append("       '' AS MDFY_XTER_RQST_NO," ).append("\n"); 
		query.append("       '' AS XTER_RQST_NO," ).append("\n"); 
		query.append("       '' AS XTER_RQST_SEQ," ).append("\n"); 
		query.append("       '' AS XTER_BKG_RQST_STS_CD," ).append("\n"); 
		query.append("       '' AS SH_NM," ).append("\n"); 
		query.append("       '' AS VVD," ).append("\n"); 
		query.append("       '' AS XTER_POR_CD," ).append("\n"); 
		query.append("       '' AS XTER_DEL_CD," ).append("\n"); 
		query.append("       '' AS DELIVERY," ).append("\n"); 
		query.append("       '' AS FRT_TERM," ).append("\n"); 
		query.append("       '' AS TEU," ).append("\n"); 
		query.append("       '' AS FEU," ).append("\n"); 
		query.append("       '' AS EST_WGT," ).append("\n"); 
		query.append("       '' AS BKG_NO," ).append("\n"); 
		query.append("       '' AS CN_NM," ).append("\n"); 
		query.append("       '' AS VSL_ENG_NM," ).append("\n"); 
		query.append("       '' AS HNDL_OFC_CD," ).append("\n"); 
		query.append("       '' AS DOC_TP_CD," ).append("\n"); 
		query.append("       '' AS XTER_RQST_VIA_CD," ).append("\n"); 
		query.append("       '' AS XTER_POL_CD," ).append("\n"); 
		query.append("       '' AS XTER_POD_CD," ).append("\n"); 
		query.append("       '' AS RQST_DEP_DT," ).append("\n"); 
		query.append("       '' AS SKD_VOY_NO," ).append("\n"); 
		query.append("       '' AS PO_NO," ).append("\n"); 
		query.append("       '' AS CNTC_EML," ).append("\n"); 
		query.append("       '' AS OFC_CD," ).append("\n"); 
		query.append("       '' AS UPLD_USR_ID," ).append("\n"); 
		query.append("       '' AS UPLD_USR_NM," ).append("\n"); 
		query.append("       '' AS UPLD_DT," ).append("\n"); 
		query.append("       '' AS XTER_SNDR_ID," ).append("\n"); 
		query.append("       '' AS VSL_CD," ).append("\n"); 
		query.append("       '' AS BKG_STS_CD," ).append("\n"); 
		query.append("       '' AS SNACCS_SPLIT_NO," ).append("\n"); 
		query.append("--------------------------------" ).append("\n"); 
		query.append("       '' AS RQST_FROM_DT," ).append("\n"); 
		query.append("       '' AS RQST_TO_DT," ).append("\n"); 
		query.append("       '' AS HNDL_OFC_CD," ).append("\n"); 
		query.append("       '' AS XTER_RQST_VIA_CD," ).append("\n"); 
		query.append("       '' AS CHN_AGN_CD," ).append("\n"); 
		query.append("       '' AS POL_CD," ).append("\n"); 
		query.append("       '' AS REJECT," ).append("\n"); 
		query.append("       '' AS CONFIRM," ).append("\n"); 
		query.append("       '' AS SC_NO," ).append("\n"); 
		query.append("       '' AS RFA_NO," ).append("\n"); 
		query.append("       '' AS POD_CD," ).append("\n"); 
		query.append("       '' AS BKG_POD_CD," ).append("\n"); 
		query.append("--------------------------------" ).append("\n"); 
		query.append("       '' AS SUM_TEU," ).append("\n"); 
		query.append("       '' AS SUM_FEU," ).append("\n"); 
		query.append("       '' AS SUM_TTL," ).append("\n"); 
		query.append("       '' AS SUM_WGT," ).append("\n"); 
		query.append("       '' AS SUM_ULD," ).append("\n"); 
		query.append("       '' AS SUM_UNU" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}