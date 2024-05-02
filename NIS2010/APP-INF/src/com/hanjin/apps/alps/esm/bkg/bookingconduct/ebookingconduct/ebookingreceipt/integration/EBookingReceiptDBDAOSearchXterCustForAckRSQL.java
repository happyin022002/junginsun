/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterCustForAckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.10
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.01.10 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterCustForAckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * auto confirm edi 중 customer 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterCustForAckRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOSearchXterCustForAckRSQL").append("\n"); 
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
		query.append("select '{I_BKG_CUST'                                         ||CHR(10)||" ).append("\n"); 
		query.append("       'IBCS_TP:'       || XTER_CUST_TP_CD                   ||CHR(10)||" ).append("\n"); 
		query.append("       'CNT_CD:'        || CNT_CD                            ||CHR(10)||" ).append("\n"); 
		query.append("       'CUST_CD:'       || DECODE(CUST_SEQ, '0', null, CUST_SEQ)||CHR(10)||" ).append("\n"); 
		query.append("       'IBCS_CUST_LOC:' || LOC_CTNT                          ||CHR(10)||" ).append("\n"); 
		query.append("       'IBCS_NM:'       || ScE_TOKEN_NL_FNC(cust_nm, 1)      ||CHR(10)||" ).append("\n"); 
		query.append("       'IBCS_NM1:'      || SCE_TOKEN_NL_FNC(cust_nm, 2)      ||CHR(10)||" ).append("\n"); 
		query.append("       'IBCS_ADDR:'     || SCE_TOKEN_NL_FNC(CUST_ADDR, 1)    ||CHR(10)||" ).append("\n"); 
		query.append("       'IBCS_ADDR1:'    || SCE_TOKEN_NL_FNC(CUST_ADDR, 2)    ||CHR(10)||" ).append("\n"); 
		query.append("       'IBCS_ADDR2:'    || SCE_TOKEN_NL_FNC(CUST_ADDR, 3)    ||CHR(10)||" ).append("\n"); 
		query.append("       'IBCS_ADDR3:'    || SCE_TOKEN_NL_FNC(CUST_ADDR, 4)    ||CHR(10)||" ).append("\n"); 
		query.append("       'IBCS_ADDR4:'    || SCE_TOKEN_NL_FNC(CUST_ADDR, 5)    ||CHR(10)||" ).append("\n"); 
		query.append("       'IBCS_STREET:'   || ST_NM                             ||CHR(10)||       " ).append("\n"); 
		query.append("       'IBCS_LOC_CD:'   || LOC_CD                            ||CHR(10)||	" ).append("\n"); 
		query.append("       'IBCS_LOC_NM:'   || LOC_NM                            ||CHR(10)||	" ).append("\n"); 
		query.append("       'IBCS_STATE:'    || STE_CD                            ||CHR(10)||	" ).append("\n"); 
		query.append("       'IBCS_ZIP_CD:'   || PST_CTNT                          ||CHR(10)||	" ).append("\n"); 
		query.append("       'IBCS_TEL_I_CD:' || PHN_INTL_NO                       ||CHR(10)||" ).append("\n"); 
		query.append("       'IBCS_TEL_A_CD:' || PHN_PFX_NO                        ||CHR(10)||" ).append("\n"); 
		query.append("       'IBCS_TEL_NUM:'  || PHN_NO                            ||CHR(10)||	" ).append("\n"); 
		query.append("       'IBCS_TEL_EXT:'  || PHN_XTN_NO                        ||CHR(10)||	" ).append("\n"); 
		query.append("       'IBCS_FAX_I_CD:' || FAX_INTL_NO                       ||CHR(10)||" ).append("\n"); 
		query.append("       'IBCS_FAX_A_CD:' || FAX_PFX_NO                        ||CHR(10)||" ).append("\n"); 
		query.append("       'IBCS_FAX_NUM:'  || FAX_NO1                           ||CHR(10)||	" ).append("\n"); 
		query.append("       'IBCS_EMAIL:'    || CUST_EML                          ||CHR(10)||	" ).append("\n"); 
		query.append("       'IBCS_C_TP:'     || XTER_CUST_CNTC_TP_CD              ||CHR(10)||	" ).append("\n"); 
		query.append("       'IBCS_C_NM:'     || CNTC_NM                           ||CHR(10)||	" ).append("\n"); 
		query.append("       'IBCS_C_TEL:'    || CNTC_PHN_NO_CTNT                  ||CHR(10)||	" ).append("\n"); 
		query.append("       'IBCS_C_FAX:'    || CNTC_FAX_NO                       ||CHR(10)||	" ).append("\n"); 
		query.append("       'IBCS_C_EMAIL:'  || CNTC_EML                          ||CHR(10)||	" ).append("\n"); 
		query.append("       'IBCS_LGSI_IND:' || SI_FLG                            ||CHR(10)||" ).append("\n"); 
		query.append("       'IBCS_SAMSAP_CD:'|| CUST_ERP_REF_NO                   ||CHR(10)||" ).append("\n"); 
		query.append("       '}I_BKG_CUST'                                         ||CHR(10)  FLAT_FILE" ).append("\n"); 
		query.append("  from bkg_xter_cust		" ).append("\n"); 
		query.append(" where XTER_SNDR_ID  = @[sender_id]" ).append("\n"); 
		query.append("   and xter_rqst_no  = @[rqst_no]" ).append("\n"); 
		query.append("   and xter_rqst_seq = @[rqst_seq]" ).append("\n"); 

	}
}