/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterCustForRejectEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.19
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.05.19 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterCustForRejectEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterCustForRejectEdi
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterCustForRejectEdiRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterCustForRejectEdiRSQL").append("\n"); 
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
		query.append("    xter_cust_tp_cd					    ibcs_tp     	  " ).append("\n"); 
		query.append("    , BKG_TOKEN_NL_FNC(NVL(cust_nm,   ''), 1,'')	ibcs_nm1    	  " ).append("\n"); 
		query.append("    , BKG_TOKEN_NL_FNC(NVL(cust_nm,   ''), 2,'')	ibcs_nm2    	  " ).append("\n"); 
		query.append("    , BKG_TOKEN_NL_FNC(NVL(cust_addr, ''), 1,'')	ibcs_addr1  	  " ).append("\n"); 
		query.append("    , BKG_TOKEN_NL_FNC(NVL(cust_addr, ''), 2,'')	ibcs_addr2  	  " ).append("\n"); 
		query.append("    , BKG_TOKEN_NL_FNC(NVL(cust_addr, ''), 3,'')	ibcs_addr3  	  " ).append("\n"); 
		query.append("    , BKG_TOKEN_NL_FNC(NVL(cntc_nm,   ''), 1,'')	ibcs_c_nm1  	  " ).append("\n"); 
		query.append("    , BKG_TOKEN_NL_FNC(NVL(cntc_nm,   ''), 2,'')	ibcs_c_nm2  	  " ).append("\n"); 
		query.append("    , CNT_CD				            cnt_cd			" ).append("\n"); 
		query.append("    , TO_CHAR(CUST_seq)			        cust_cd     	  " ).append("\n"); 
		query.append("    , loc_ctnt			                ibcs_cust_loc    " ).append("\n"); 
		query.append("    , st_nm				                ibcs_street      " ).append("\n"); 
		query.append("    , loc_cd				            ibcs_loc_cd      " ).append("\n"); 
		query.append("    , loc_nm				            ibcs_loc_nm      " ).append("\n"); 
		query.append("    , pst_ctnt				            ibcs_zip_cd      " ).append("\n"); 
		query.append("    , XTER_CUST_CNTC_TP_CD			    ibcs_c_tp        " ).append("\n"); 
		query.append("    , cntc_phn_no_ctnt				    ibcs_c_tel       " ).append("\n"); 
		query.append("    , cntc_fax_no				        ibcs_c_fax       " ).append("\n"); 
		query.append("    , cntc_eml				            ibcs_c_email   " ).append("\n"); 
		query.append("    , BKG_TOKEN_NL_FNC(NVL(CUST_ADDR,   ''), 4,'')	IBCS_ADDR4  	  " ).append("\n"); 
		query.append("    , BKG_TOKEN_NL_FNC(NVL(CUST_ADDR,   ''), 5,'')	IBCS_ADDR5  	  " ).append("\n"); 
		query.append("    , UN_LOC_CD" ).append("\n"); 
		query.append("    , PRNR_CUST_CD" ).append("\n"); 
		query.append("    , PRNR_REF_NO" ).append("\n"); 
		query.append("    , STE_CD" ).append("\n"); 
		query.append("  FROM bkg_xter_cust" ).append("\n"); 
		query.append(" where xter_sndr_id  = @[sender_id]" ).append("\n"); 
		query.append("   and xter_rqst_no  = @[rqst_no]" ).append("\n"); 
		query.append("   and xter_rqst_seq = @[rqst_seq]" ).append("\n"); 

	}
}