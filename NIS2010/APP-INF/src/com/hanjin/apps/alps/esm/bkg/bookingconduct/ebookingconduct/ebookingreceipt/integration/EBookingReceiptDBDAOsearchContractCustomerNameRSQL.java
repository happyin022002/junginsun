/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchContractCustomerNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.05 
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

public class EBookingReceiptDBDAOsearchContractCustomerNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchContractCustomerNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchContractCustomerNameRSQL").append("\n"); 
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
		query.append("SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    (SELECT D.CUST_LGL_ENG_NM FROM PRI_SP_HDR A ,PRI_SP_CTRT_PTY B ,PRI_SP_MN C ,MDM_CUSTOMER D WHERE A.PROP_NO = B.PROP_NO AND B.PROP_NO = C.PROP_NO AND B.AMDT_SEQ = C.AMDT_SEQ AND D.CUST_CNT_CD = B.CUST_CNT_CD AND D.CUST_SEQ = B.CUST_SEQ AND C.PROP_STS_CD = 'F' AND B.PRC_CTRT_PTY_TP_CD  = 'C' AND A.SC_NO = @[ctrt_no] ORDER BY C.AMDT_SEQ DESC) " ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    (SELECT D.CUST_LGL_ENG_NM FROM PRI_RP_HDR A ,PRI_RP_MN C ,MDM_CUSTOMER D WHERE A.PROP_NO = C.PROP_NO AND D.CUST_CNT_CD = C.CTRT_CUST_CNT_CD AND D.CUST_SEQ = C.CTRT_CUST_SEQ AND C.PROP_STS_CD = 'A' AND A.RFA_NO = @[ctrt_no] ORDER BY C.AMDT_SEQ DESC)" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    (SELECT D.CUST_LGL_ENG_NM FROM PRI_TAA_HDR A ,PRI_TAA_MN C ,MDM_CUSTOMER D WHERE A.TAA_PROP_NO = C.TAA_PROP_NO AND D.CUST_CNT_CD = C.CTRT_CUST_CNT_CD AND D.CUST_SEQ = C.CTRT_CUST_SEQ AND C.CFM_FLG = 'Y' AND A.TAA_NO = @[ctrt_no] ORDER BY C.AMDT_SEQ DESC) " ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}