/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterCustForRejectEdiRSQL.java
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    XTER_CUST_TP_CD					    IBCS_TP     	  " ).append("\n"); 
		query.append("    , SCE_TOKEN_NL_FNC(NVL(CUST_NM,   ''), 1)	IBCS_NM1    	  " ).append("\n"); 
		query.append("    , SCE_TOKEN_NL_FNC(NVL(CUST_NM,   ''), 2)	IBCS_NM2    	  " ).append("\n"); 
		query.append("    , SCE_TOKEN_NL_FNC(NVL(CUST_ADDR, ''), 1)	IBCS_ADDR1  	  " ).append("\n"); 
		query.append("    , SCE_TOKEN_NL_FNC(NVL(CUST_ADDR, ''), 2)	IBCS_ADDR2  	  " ).append("\n"); 
		query.append("    , SCE_TOKEN_NL_FNC(NVL(CUST_ADDR, ''), 3)	IBCS_ADDR3  	  " ).append("\n"); 
		query.append("    , SCE_TOKEN_NL_FNC(NVL(CNTC_NM,   ''), 1)	IBCS_C_NM1  	  " ).append("\n"); 
		query.append("    , SCE_TOKEN_NL_FNC(NVL(CNTC_NM,   ''), 2)	IBCS_C_NM2  	  " ).append("\n"); 
		query.append("    , CNT_CD				            CNT_CD			" ).append("\n"); 
		query.append("    , DECODE(TO_CHAR(CUST_SEQ), '0', null, TO_CHAR(CUST_SEQ)) CUST_CD     	  " ).append("\n"); 
		query.append("    , LOC_CTNT			                IBCS_CUST_LOC    " ).append("\n"); 
		query.append("    , ST_NM				                IBCS_STREET      " ).append("\n"); 
		query.append("    , LOC_CD				            IBCS_LOC_CD      " ).append("\n"); 
		query.append("    , LOC_NM				            IBCS_LOC_NM      " ).append("\n"); 
		query.append("    , PST_CTNT				            IBCS_ZIP_CD      " ).append("\n"); 
		query.append("    , XTER_CUST_CNTC_TP_CD			    IBCS_C_TP        " ).append("\n"); 
		query.append("    , CNTC_PHN_NO_CTNT				    IBCS_C_TEL       " ).append("\n"); 
		query.append("    , CNTC_FAX_NO				        IBCS_C_FAX       " ).append("\n"); 
		query.append("    , CNTC_EML				            IBCS_C_EMAIL   " ).append("\n"); 
		query.append("  FROM BKG_XTER_CUST" ).append("\n"); 
		query.append(" WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("   AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("   AND XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("   AND XTER_CUST_TP_CD IN ('S','C','F','N','A','E','R','MS', 'ST', 'SF')" ).append("\n"); 

	}
}