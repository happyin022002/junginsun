/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOupdateBkgXterXptLicNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOupdateBkgXterXptLicNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_XTER_XPT_LIC_NO Update
	  * </pre>
	  */
	public EBookingReceiptDBDAOupdateBkgXterXptLicNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOupdateBkgXterXptLicNoUSQL").append("\n"); 
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
		query.append("update BKG_XTER_XPT_LIC_NO" ).append("\n"); 
		query.append("set PCK_QTY = decode(CGO_DIVD_FLG, 'Y', null, PCK_QTY)" ).append("\n"); 
		query.append(", PCK_TP_CD = decode(CGO_DIVD_FLG, 'Y', null, PCK_TP_CD)" ).append("\n"); 
		query.append(", CNTR_WGT = decode(CGO_DIVD_FLG, 'Y', null, CNTR_WGT)" ).append("\n"); 
		query.append(", WGT_UT_CD = decode(CGO_DIVD_FLG, 'Y', null, WGT_UT_CD)" ).append("\n"); 
		query.append(", DIVD_PCK_QTY = decode(CGO_DIVD_FLG, 'Y', PCK_QTY, null)" ).append("\n"); 
		query.append(", DIVD_PCK_TP_CD = decode(CGO_DIVD_FLG, 'Y', PCK_TP_CD, null)" ).append("\n"); 
		query.append(", DIVD_WGT = decode(CGO_DIVD_FLG, 'Y', CNTR_WGT, null)" ).append("\n"); 
		query.append(", DIVD_WGT_UT_CD = decode(CGO_DIVD_FLG, 'Y', WGT_UT_CD, null)" ).append("\n"); 
		query.append("where XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("and XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("and XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 

	}
}