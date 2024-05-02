/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterRqstRejectEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.08 
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

public class EBookingReceiptDBDAOsearchXterRqstRejectEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterRqstRejectEdi
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterRqstRejectEdiRSQL(){
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : EBookingReceiptDBDAOsearchXterRqstRejectEdiRSQL").append("\n"); 
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
		query.append("SELECT	'IB_BKG_NO:'      ||substr(mst.bkg_no, 1, 11)                ||CHR(10)||" ).append("\n"); 
		query.append("'IB_BKG_NO_SPLIT:'||substr(mst.bkg_no, 11, 2)                ||CHR(10)||" ).append("\n"); 
		query.append("'IB_MSG_FLAG:'    ||mst.doc_tp_cd                            ||CHR(10)||" ).append("\n"); 
		query.append("'IB_C_DATE:'      ||TO_CHAR(mst.RQST_DT,'YYYYMMDDHH24MI')    ||CHR(10)||" ).append("\n"); 
		query.append("'IB_R_DATE:'      ||TO_CHAR(mst.UPLD_DT,'YYYYMMDDHH24MI')    ||CHR(10)||" ).append("\n"); 
		query.append("'IBCS_NM:'        ||SCE_TOKEN_NL_FNC(cust.CUST_NM, 1)                ||CHR(10)||" ).append("\n"); 
		query.append("'IBCS_NM1:'       ||SCE_TOKEN_NL_FNC(cust.CUST_NM, 2)                ||CHR(10)||" ).append("\n"); 
		query.append("'IBCS_ADDR:'      ||SCE_TOKEN_NL_FNC(cust.CUST_ADDR, 1)              ||CHR(10)||" ).append("\n"); 
		query.append("'IBCS_ADDR1:'     ||SCE_TOKEN_NL_FNC(cust.CUST_ADDR, 2)              ||CHR(10)||" ).append("\n"); 
		query.append("'IBCS_ADDR2:'     ||SCE_TOKEN_NL_FNC(cust.CUST_ADDR, 3)              ||CHR(10)||" ).append("\n"); 
		query.append("'IB_C_NM:'        ||com.USR_NM                               ||CHR(10)||" ).append("\n"); 
		query.append("'RESPONSE:'       ||REPLACE(NVL(mst.RJCT_RSN_RMK,' '),CHR(13)||CHR(10), ' ')||CHR(10) EDI_BODY" ).append("\n"); 
		query.append("FROM bkg_xter_Rqst_mst mst, bkg_xter_cust cust, com_user com" ).append("\n"); 
		query.append("where mst.xter_sndr_id     = @[sender_id]" ).append("\n"); 
		query.append("and mst.xter_rqst_no     = @[rqst_no]" ).append("\n"); 
		query.append("and mst.xter_rqst_seq    = @[rqst_seq]" ).append("\n"); 
		query.append("and mst.xter_sndr_id     = cust.xter_sndr_id" ).append("\n"); 
		query.append("and mst.xter_rqst_no     = cust.xter_rqst_no" ).append("\n"); 
		query.append("and mst.xter_rqst_seq    = cust.xter_rqst_seq" ).append("\n"); 
		query.append("and cust.xter_cust_tp_cd = 'S'" ).append("\n"); 
		query.append("and com.USR_ID	        = @[usr_id]" ).append("\n"); 

	}
}