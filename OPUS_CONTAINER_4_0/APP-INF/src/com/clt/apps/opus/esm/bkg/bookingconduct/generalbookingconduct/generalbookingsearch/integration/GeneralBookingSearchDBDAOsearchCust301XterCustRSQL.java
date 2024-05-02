/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchCust301XterCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : jklim
*@LastVersion : 1.0
* 2015.04.06 jklim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jklim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchCust301XterCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCust301XterCust
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchCust301XterCustRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchCust301XterCustRSQL").append("\n"); 
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
		query.append("SELECT '{I_BKG_CUST'										           || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_TP:'			|| cust.XTER_CUST_TP_CD				   || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_NM1:'			|| BKG_TOKEN_NL_FNC(NVL(CUST_NM, ''), 1, '')	   || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_NM2:'			|| BKG_TOKEN_NL_FNC(NVL(CUST_NM, ''), 2, '')  	   || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_ADDR1:'			|| BKG_TOKEN_NL_FNC(NVL(CUST_ADDR, ''), 1, '')     || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_ADDR2:'			|| BKG_TOKEN_NL_FNC(NVL(CUST_ADDR, ''), 2, '')     || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_ADDR3:'			|| BKG_TOKEN_NL_FNC(NVL(CUST_ADDR, ''), 3, '')     || CHR(10)" ).append("\n"); 
		query.append("        ||'IBCS_ADDR4:'			|| BKG_TOKEN_NL_FNC(NVL(CUST_ADDR, ''), 4, '')     || CHR(10)" ).append("\n"); 
		query.append("        ||'IBCS_ADDR5:'			|| BKG_TOKEN_NL_FNC(NVL(CUST_ADDR, ''), 5, '')     || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_C_NM1:'			|| BKG_TOKEN_NL_FNC(NVL(cust.CNTC_NM, ''), 1, '')  || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_C_NM2:'			|| BKG_TOKEN_NL_FNC(NVL(cust.CNTC_NM, ''), 2, '')  || CHR(10)	" ).append("\n"); 
		query.append("		||'CNT_CD:'				|| cust.cnt_cd				           || CHR(10)" ).append("\n"); 
		query.append("		||'CUST_CD:'			|| decode(cust.CUST_SEQ,0,null,cust.CUST_SEQ) || CHR(10)" ).append("\n"); 
		query.append("		||'UN_CUST_CD:'			|| cust.UN_LOC_CD					   || CHR(10)	" ).append("\n"); 
		query.append("		||'PCC_CUST_CD:'		|| cust.PRNR_CUST_CD				   || CHR(10)	" ).append("\n"); 
		query.append("		||'PARTNER_REF_NO:'		|| cust.PRNR_REF_NO					   || CHR(10)	" ).append("\n"); 
		query.append("		||'IBCS_CUST_LOC:'		|| cust.LOC_CTNT			           || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_STREET:'		|| cust.ST_NM			               || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_LOC_CD:'		|| cust.LOC_CD	             		   || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_LOC_NM:'		|| cust.LOC_NM			               || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_ZIP_CD:'		|| cust.PST_CTNT			           || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_STATE_CD:'		|| cust.STE_CD				           || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_UNLOC_CD:'		|| cust.LOC_CD	   			           || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_C_TP:'		    || cust.XTER_CUST_CNTC_TP_CD	 	   || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_C_TEL:'		    || cust.CNTC_PHN_NO_CTNT			   || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_C_FAX:'		    || cust.CNTC_FAX_NO			           || CHR(10)" ).append("\n"); 
		query.append("		||'IBCS_C_EMAIL:'		|| cust.CNTC_EML			           || CHR(10)" ).append("\n"); 
		query.append("		|| '}I_BKG_CUST'											    I_BKG_CUST" ).append("\n"); 
		query.append("  FROM bkg_xter_rqst_mst mst, bkg_xter_cust cust" ).append("\n"); 
		query.append(" where mst.xter_sndr_id     = cust.xter_sndr_id" ).append("\n"); 
		query.append("   and mst.xter_rqst_no     = cust.xter_rqst_no" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq    = cust.xter_rqst_seq" ).append("\n"); 
		query.append("   AND MST.xter_sndr_id     = @[sender_id]" ).append("\n"); 
		query.append("   and MST.xter_rqst_no     = @[rqst_no]" ).append("\n"); 
		query.append("   and MST.xter_rqst_seq    = @[rqst_seq]" ).append("\n"); 

	}
}