/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOcopyBkgXterCustCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.12 
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

public class EBookingReceiptDBDAOcopyBkgXterCustCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * copyBkgXterCust
	  * </pre>
	  */
	public EBookingReceiptDBDAOcopyBkgXterCustCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOcopyBkgXterCustCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_XTER_CUST" ).append("\n"); 
		query.append("(  xter_sndr_id,  xter_rqst_no,  xter_rqst_seq, xter_cust_tp_cd" ).append("\n"); 
		query.append(", CNT_CD, CUST_seq,	cust_nm,  	cust_ADDR" ).append("\n"); 
		query.append(", loc_cd" ).append("\n"); 
		query.append(", loc_nm" ).append("\n"); 
		query.append(", loc_ctnt" ).append("\n"); 
		query.append(", ste_cd,  	pst_ctnt" ).append("\n"); 
		query.append(", phn_intl_no,	phn_pfx_no,	phn_no,	phn_xtn_no" ).append("\n"); 
		query.append(", fax_intl_no,	phn_pfx_no,	faX_no1" ).append("\n"); 
		query.append(", cust_eml" ).append("\n"); 
		query.append(", xter_cust_cntc_tp_cd,	cntc_nm" ).append("\n"); 
		query.append(", cntc_phn_no,	cntc_fax_no, cntc_eml" ).append("\n"); 
		query.append(", si_flg" ).append("\n"); 
		query.append(", st_nm)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("xter_sndr_id,  xter_rqst_no,  xter_rqst_seq+1, xter_cust_tp_cd" ).append("\n"); 
		query.append(", CNT_CD, CUST_seq,	cust_nm,  	cust_ADDR" ).append("\n"); 
		query.append(", loc_cd" ).append("\n"); 
		query.append(", loc_nm" ).append("\n"); 
		query.append(", loc_ctnt" ).append("\n"); 
		query.append(", ste_cd,  	pst_ctnt" ).append("\n"); 
		query.append(", phn_intl_no,	phn_pfx_no,	phn_no,	phn_xtn_no" ).append("\n"); 
		query.append(", fax_intl_no,	phn_pfx_no,	faX_no1" ).append("\n"); 
		query.append(", cust_eml" ).append("\n"); 
		query.append(", xter_cust_cntc_tp_cd,	cntc_nm" ).append("\n"); 
		query.append(", cntc_phn_no,	cntc_fax_no, cntc_eml" ).append("\n"); 
		query.append(", si_flg" ).append("\n"); 
		query.append(", st_nm" ).append("\n"); 
		query.append("FROM	BKG_XTER_CUST" ).append("\n"); 
		query.append("WHERE	xter_rqst_no    = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND		xter_rqst_seq	= @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND     xter_sndr_id    = @[xter_sndr_id]" ).append("\n"); 

	}
}