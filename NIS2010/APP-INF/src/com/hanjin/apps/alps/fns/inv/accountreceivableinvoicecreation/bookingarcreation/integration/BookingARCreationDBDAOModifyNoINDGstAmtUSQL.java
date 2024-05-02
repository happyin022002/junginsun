/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingARCreationDBDAOModifyNoINDGstAmtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOModifyNoINDGstAmtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify No IND Gst Amt
	  * </pre>
	  */
	public BookingARCreationDBDAOModifyNoINDGstAmtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_prcs_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOModifyNoINDGstAmtUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_CHG P  " ).append("\n"); 
		query.append("SET IDA_CGST_AMT = ROUND(DECODE(CURR_CD, 'USD', ROUND(CHG_AMT * @[usd_xch_rt], @[dp_prcs_knt]), 'INR', CHG_AMT, " ).append("\n"); 
		query.append("												ROUND(CHG_AMT * " ).append("\n"); 
		query.append("																(SELECT NVL(ROUND(A.USD_LOCL_XCH_RT/B.USD_LOCL_XCH_RT, 6), 0)" ).append("\n"); 
		query.append("																 FROM GL_MON_XCH_RT A, GL_MON_XCH_RT B, INV_AR_MN C" ).append("\n"); 
		query.append("															     WHERE A.ACCT_XCH_RT_YRMON = SUBSTR(C.SAIL_DT, 1, 6)" ).append("\n"); 
		query.append("																 AND A.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("																 AND A.CURR_CD = 'INR'" ).append("\n"); 
		query.append("																 AND A.ACCT_XCH_RT_YRMON = B.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("																 AND A.ACCT_XCH_RT_LVL = B.ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("																 AND B.CURR_CD = P.CURR_CD" ).append("\n"); 
		query.append("																 AND C.AR_IF_NO = P.AR_IF_NO)" ).append("\n"); 
		query.append("												, @[dp_prcs_knt])) * IDA_CGST_RTO / 100, @[dp_prcs_knt])" ).append("\n"); 
		query.append("  , IDA_SGST_AMT = ROUND(DECODE(CURR_CD, 'USD', ROUND(CHG_AMT * @[usd_xch_rt], @[dp_prcs_knt]), 'INR', CHG_AMT, " ).append("\n"); 
		query.append("												ROUND(CHG_AMT * " ).append("\n"); 
		query.append("																(SELECT NVL(ROUND(A.USD_LOCL_XCH_RT/B.USD_LOCL_XCH_RT, 6), 0)" ).append("\n"); 
		query.append("																 FROM GL_MON_XCH_RT A, GL_MON_XCH_RT B, INV_AR_MN C" ).append("\n"); 
		query.append("															     WHERE A.ACCT_XCH_RT_YRMON = SUBSTR(C.SAIL_DT, 1, 6)" ).append("\n"); 
		query.append("																 AND A.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("																 AND A.CURR_CD = 'INR'" ).append("\n"); 
		query.append("																 AND A.ACCT_XCH_RT_YRMON = B.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("																 AND A.ACCT_XCH_RT_LVL = B.ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("																 AND B.CURR_CD = P.CURR_CD" ).append("\n"); 
		query.append("																 AND C.AR_IF_NO = P.AR_IF_NO)" ).append("\n"); 
		query.append("												, @[dp_prcs_knt])) * IDA_SGST_RTO / 100, @[dp_prcs_knt])" ).append("\n"); 
		query.append("  , IDA_IGST_AMT = ROUND(DECODE(CURR_CD, 'USD', ROUND(CHG_AMT * @[usd_xch_rt], @[dp_prcs_knt]), 'INR', CHG_AMT, " ).append("\n"); 
		query.append("												ROUND(CHG_AMT * " ).append("\n"); 
		query.append("																(SELECT NVL(ROUND(A.USD_LOCL_XCH_RT/B.USD_LOCL_XCH_RT, 6), 0)" ).append("\n"); 
		query.append("																 FROM GL_MON_XCH_RT A, GL_MON_XCH_RT B, INV_AR_MN C" ).append("\n"); 
		query.append("															     WHERE A.ACCT_XCH_RT_YRMON = SUBSTR(C.SAIL_DT, 1, 6)" ).append("\n"); 
		query.append("																 AND A.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("																 AND A.CURR_CD = 'INR'" ).append("\n"); 
		query.append("																 AND A.ACCT_XCH_RT_YRMON = B.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("																 AND A.ACCT_XCH_RT_LVL = B.ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("																 AND B.CURR_CD = P.CURR_CD" ).append("\n"); 
		query.append("																 AND C.AR_IF_NO = P.AR_IF_NO)" ).append("\n"); 
		query.append("												, @[dp_prcs_knt])) * IDA_IGST_RTO / 100, @[dp_prcs_knt])" ).append("\n"); 
		query.append("  , IDA_UGST_AMT = ROUND(DECODE(CURR_CD, 'USD', ROUND(CHG_AMT * @[usd_xch_rt], @[dp_prcs_knt]), 'INR', CHG_AMT, " ).append("\n"); 
		query.append("												ROUND(CHG_AMT * " ).append("\n"); 
		query.append("																(SELECT NVL(ROUND(A.USD_LOCL_XCH_RT/B.USD_LOCL_XCH_RT, 6), 0)" ).append("\n"); 
		query.append("																 FROM GL_MON_XCH_RT A, GL_MON_XCH_RT B, INV_AR_MN C" ).append("\n"); 
		query.append("															     WHERE A.ACCT_XCH_RT_YRMON = SUBSTR(C.SAIL_DT, 1, 6)" ).append("\n"); 
		query.append("																 AND A.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("																 AND A.CURR_CD = 'INR'" ).append("\n"); 
		query.append("																 AND A.ACCT_XCH_RT_YRMON = B.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("																 AND A.ACCT_XCH_RT_LVL = B.ACCT_XCH_RT_LVL" ).append("\n"); 
		query.append("																 AND B.CURR_CD = P.CURR_CD" ).append("\n"); 
		query.append("																 AND C.AR_IF_NO = P.AR_IF_NO)" ).append("\n"); 
		query.append("												, @[dp_prcs_knt])) * IDA_UGST_RTO / 100, @[dp_prcs_knt])" ).append("\n"); 
		query.append("  , UPD_USR_ID = @[user_id]" ).append("\n"); 
		query.append("  , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE AR_IF_NO = @[ar_if_no]" ).append("\n"); 

	}
}