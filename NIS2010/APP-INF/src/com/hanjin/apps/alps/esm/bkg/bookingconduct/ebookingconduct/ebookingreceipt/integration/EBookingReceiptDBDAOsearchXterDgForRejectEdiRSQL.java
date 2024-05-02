/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterDgForRejectEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.03 전용진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Yong Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterDgForRejectEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterDgForRejectEdi
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterDgForRejectEdiRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration ").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterDgForRejectEdiRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("imdg_un_no		a_dg_unbr" ).append("\n"); 
		query.append(", imdg_clss_id	a_dg_clas" ).append("\n"); 
		query.append(", NULL			a_dg_desc" ).append("\n"); 
		query.append(", NULL			a_dg_phon" ).append("\n"); 
		query.append(", NULL			a_dg_page" ).append("\n"); 
		query.append(", NULL			a_dg_fpnt" ).append("\n"); 
		query.append(", NULL			a_dg_fpun" ).append("\n"); 
		query.append(", dcgo_rmk		a_dg_dg_remark" ).append("\n"); 
		query.append(", NULL			a_dg_emsno" ).append("\n"); 
		query.append(", NULL			a_dg_psacls" ).append("\n"); 
		query.append(", pck_grp_cd1	a_dg_pkggrp" ).append("\n"); 
		query.append(", NULL			a_dg_mfag1" ).append("\n"); 
		query.append(", NULL			a_dg_mfag2" ).append("\n"); 
		query.append(", NULL			a_dg_mar_poll" ).append("\n"); 
		query.append(", NULL			a_dg_label_cd" ).append("\n"); 
		query.append(", NULL			a_dg_label_desc" ).append("\n"); 
		query.append(", NULL			a_dg_d_pkg" ).append("\n"); 
		query.append(", NULL			a_dg_d_pkgunit" ).append("\n"); 
		query.append(", NULL			a_dg_nwgt" ).append("\n"); 
		query.append(", NULL			a_dg_nwgt_unit" ).append("\n"); 
		query.append(", NULL			a_dg_gwgt" ).append("\n"); 
		query.append(", NULL			a_dg_gwgt_unit" ).append("\n"); 
		query.append(", NULL			a_dg_mea" ).append("\n"); 
		query.append(", NULL			a_dg_mea_unit" ).append("\n"); 
		query.append(", NULL			a_dg_haz_cont" ).append("\n"); 
		query.append(", NULL			a_dg_stwg" ).append("\n"); 
		query.append(", NULL			a_dg_label" ).append("\n"); 
		query.append("from bkg_xter_dg_cgo" ).append("\n"); 
		query.append("where xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("and xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("and xter_rqst_seq= @[rqst_seq]" ).append("\n"); 

	}
}