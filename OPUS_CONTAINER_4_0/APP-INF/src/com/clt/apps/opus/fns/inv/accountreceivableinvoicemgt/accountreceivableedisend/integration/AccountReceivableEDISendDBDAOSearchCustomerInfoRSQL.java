/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchCustomerInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchCustomerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Customer Info
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchCustomerInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchCustomerInfoRSQL").append("\n"); 
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
		query.append("SELECT   DISTINCT" ).append("\n"); 
		query.append("         A.CUST_CNT_CD" ).append("\n"); 
		query.append("       , A.CUST_SEQ" ).append("\n"); 
		query.append("       , A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("       , A.CUST_LOCL_LANG_NM" ).append("\n"); 
		query.append("       , B.LOCL_ADDR1" ).append("\n"); 
		query.append("       , B.LOCL_ADDR2" ).append("\n"); 
		query.append("       , B.LOCL_ADDR3" ).append("\n"); 
		query.append("       , B.CNTC_PSON_NM" ).append("\n"); 
		query.append("       , C.PHN_NO" ).append("\n"); 
		query.append("       , C.FAX_NO" ).append("\n"); 
		query.append("       , C.CUST_EML" ).append("\n"); 
		query.append("       , B.LOCL_ADDR1||B.LOCL_ADDR2||B.LOCL_ADDR3||B.LOCL_ADDR4 ADDR   " ).append("\n"); 
		query.append("       , B.CTY_NM                                        " ).append("\n"); 
		query.append("       , B.ZIP_CD                                        " ).append("\n"); 
		query.append("       , A.CUST_RGST_NO 				 " ).append("\n"); 
		query.append("       , B.STE_CD " ).append("\n"); 
		query.append("#if (${edi_hdr_seq_list} != '')" ).append("\n"); 
		query.append("       , D.BKG_CUST_TP_CD AS IBCS_TP" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       , (SELECT MAX(BKG_CUST_TP_CD)" ).append("\n"); 
		query.append("          FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("          WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          AND CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("          AND CUST_SEQ = A.CUST_SEQ) IBCS_TP   " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("FROM MDM_CUSTOMER A," ).append("\n"); 
		query.append("     MDM_CUST_ADDR B," ).append("\n"); 
		query.append("     MDM_CUST_CNTC_PNT C " ).append("\n"); 
		query.append("#if (${edi_hdr_seq_list} != '')" ).append("\n"); 
		query.append("    ,( SELECT BK.BKG_NO, BK.CUST_CNT_CD, BK.CUST_SEQ, BK.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("       FROM BKG_CUSTOMER BK, INV_EDI_HDR IEH" ).append("\n"); 
		query.append("       WHERE IEH.EDI_HDR_SEQ IN (${edi_hdr_seq_list})" ).append("\n"); 
		query.append("       AND IEH.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("       AND BK.CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("       AND BK.CUST_SEQ IS NOT NULL       " ).append("\n"); 
		query.append("     )D    " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND B.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 
		query.append("AND C.CUST_CNTC_PNT_SEQ(+) = 1" ).append("\n"); 
		query.append("#if (${edi_hdr_seq_list} != '')" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = D.CUST_CNT_CD" ).append("\n"); 
		query.append("AND A.CUST_SEQ = D.CUST_SEQ       " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND A.CUST_SEQ = @[cust_seq]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}