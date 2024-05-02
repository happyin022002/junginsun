/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchFntOfcEmlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.15 
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

public class EBookingReceiptDBDAOSearchFntOfcEmlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOSearchFntOfcEmlRSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchFntOfcEmlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_log_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchFntOfcEmlRSQL").append("\n"); 
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
		query.append("SELECT  CNTC_EML AS TO_EMAIL, --To" ).append("\n"); 
		query.append("        '[Return] '||EML_SUBJ_CTNT||EML_ORG_SUBJ_CTNT AS EML_SUBJ_CTNT, -- Subject" ).append("\n"); 
		query.append("        DECODE(H.ATTR_CTNT3,'','sitrans_test@smlines.com',H.ATTR_CTNT3 )  AS FROM_EMAIL--From" ).append("\n"); 
		query.append("FROM BKG_SR_FAX M, BKG_HRD_CDG_CTNT H" ).append("\n"); 
		query.append("WHERE 	m.SR_NO = @[sr_no]" ).append("\n"); 
		query.append("AND	m.FAX_LOG_REF_NO = @[fax_log_ref_no]" ).append("\n"); 
		query.append("AND M.SR_KND_CD = 'M'" ).append("\n"); 
		query.append("AND M.FAX_SVR_OFC_CD = H.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("AND H.HRD_CDG_ID(+) = 'SI_TRANS_MAIL'" ).append("\n"); 

	}
}