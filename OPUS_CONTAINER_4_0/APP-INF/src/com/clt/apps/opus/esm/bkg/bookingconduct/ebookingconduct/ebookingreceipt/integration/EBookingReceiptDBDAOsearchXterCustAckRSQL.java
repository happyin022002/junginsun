/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterCustAckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.01
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.07.01 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterCustAckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterCustAck
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterCustAckRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchXterCustAckRSQL").append("\n"); 
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
		query.append("SELECT	'{ACK_CUST_INFO' || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_TP:'           || cust.xter_cust_tp_cd                                                          || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_CUST_CD:'      || cust.cnt_cd||cust.cust_seq                                                    || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_UN_CUST_CD:'   || CUST.UN_LOC_CD                                                                || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_PCC_CUST_CD:'  || CUST.PRNR_CUST_CD                                                             || CHR(10)" ).append("\n"); 
		query.append("		 || 'IB_PARTNER_REF_NO:'  || CUST.PRNR_REF_NO                                                            || CHR(10) " ).append("\n"); 
		query.append("         || 'IB_NM1:'          || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(cust.cust_nm,   1, ''), '*', '-'), ':', '-')		  || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_NM2:'          || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(cust.cust_nm,   2, ''), '*', '-'), ':', '-')		  || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_ADDR:'         || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(cust.cust_addr, 1, ''), '*', '-'), ':', '-')	  	|| CHR(10)" ).append("\n"); 
		query.append("         || 'IB_ADDR1:'        || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(cust.cust_addr, 2, ''), '*', '-'), ':', '-')	  	|| CHR(10)" ).append("\n"); 
		query.append("         || 'IB_ADDR2:'        || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(cust.cust_addr, 3, ''), '*', '-'), ':', '-')	  	|| CHR(10)" ).append("\n"); 
		query.append("         || 'IB_ADDR3:'        || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(cust.cust_addr, 4, ''), '*', '-'), ':', '-')	  	|| CHR(10)   " ).append("\n"); 
		query.append("         || 'IB_ADDR4:'        || REPLACE(REPLACE(BKG_TOKEN_NL_FNC(cust.cust_addr, 5, ''), '*', '-'), ':', '-')	  	|| CHR(10)" ).append("\n"); 
		query.append("		 || 'IB_LOC_CD:'       || cust.LOC_CD                                                                   || CHR(10) " ).append("\n"); 
		query.append("         || 'IB_LOC_NM:'       || cust.loc_nm                                                                   || CHR(10)" ).append("\n"); 
		query.append("		 || 'IB_STREET:'       || cust.ST_NM                                                                    || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_STATE:'        || cust.ste_cd                                                                   || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_ZIP_CD:'       || cust.PST_CTNT                                                                 || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_CNT_CD:'       || cust.cnt_cd                                                                   || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_C_TP:'         || cust.XTER_CUST_CNTC_TP_CD                                                     || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_C_NM:'         || cust.CNTC_NM                                                                  || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_C_DEPT:'       || ''                                                                            || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_C_EMAIL:'      || cust.CNTC_EML                                                                 || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_C_PHON:'       || cust.CNTC_PHN_NO_CTNT                                                         || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_C_FAX:'        || cust.CNTC_FAX_NO                                                              || CHR(10)" ).append("\n"); 
		query.append("        || '}ACK_CUST_INFO'	AS CNTR_CUST_INFO" ).append("\n"); 
		query.append("  FROM bkg_xter_Rqst_mst mst, bkg_xter_cust cust" ).append("\n"); 
		query.append(" where mst.xter_sndr_id    = @[sender_id]" ).append("\n"); 
		query.append("   and mst.xter_rqst_no    = @[rqst_no]" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq   = @[rqst_seq]" ).append("\n"); 
		query.append("   and mst.xter_sndr_id    = cust.xter_sndr_id" ).append("\n"); 
		query.append("   and mst.xter_rqst_no    = cust.xter_rqst_no" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq   = cust.xter_rqst_seq" ).append("\n"); 

	}
}