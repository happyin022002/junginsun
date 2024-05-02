/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOaddBkgXterVrfdWgtPty_DuuuummyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.19
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.04.19 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOaddBkgXterVrfdWgtPty_DuuuummyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public EBookingReceiptDBDAOaddBkgXterVrfdWgtPty_DuuuummyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOaddBkgXterVrfdWgtPty_DuuuummyRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("'' as XTER_SNDR_ID, '' as XTER_VGM_RQST_NO, '' as XTER_VGM_SEQ, '' as CNTR_NO, '' as CNTR_TPSZ_CD, '' as BKG_NO, '' as XTER_RQST_VIA_CD, '' as VGM_UPLD_STS_CD, '' as UPLD_USR_ID, '' as UPLD_DT, '' as UPLD_GDT, '' as RJCT_RSN_RMK, '' as RQST_DT, '' as RQST_DELT_FLG, '' as CUST_ID, '' as VGM_WGT, '' as VGM_WGT_UT_CD, '' as VGM_VRFY_DT, '' as VGM_DTMN_DT, '' as XTER_BKG_RQST_REF_NO, '' as XTER_SI_REF_NO, '' as VGM_MZD_TP_CD, '' as XTER_CNTR_SEAL_NO, '' as VGM_EDI_TP_CD, '' as SMT_DT, '' as SMT_NM, '' as SMT_ADDR, '' as SMT_CNTC_DESC, '' as SMT_EML, '' as SMT_PHN_NO, '' as CRE_USR_ID, '' as CRE_DT, '' as UPD_USR_ID, '' as UPD_DT " ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}