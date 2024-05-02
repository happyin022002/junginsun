/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOaddBkgXterSIBkgChgRateCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.09
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.09.09 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOaddBkgXterSIBkgChgRateCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgXterSIBkgChgRate
	  * </pre>
	  */
	public EBookingReceiptDBDAOaddBkgXterSIBkgChgRateCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOaddBkgXterSIBkgChgRateCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CHG_RT" ).append("\n"); 
		query.append("        (BKG_NO, RT_SEQ, DP_SEQ, FRT_TERM_CD, TRF_ITM_NO, " ).append("\n"); 
		query.append("        CGO_CATE_CD, IMDG_CLSS_CD, CHG_CD, CURR_CD, RAT_UT_CD," ).append("\n"); 
		query.append("        BKG_QTY, RAT_AS_QTY, CHG_UT_AMT, CHG_AMT, RCV_TERM_CD, " ).append("\n"); 
		query.append("        DE_TERM_CD, N3PTY_RCV_OFC_CD, N3PTY_CUST_CNT_CD, N3PTY_CUST_SEQ, FRT_INCL_XCLD_DIV_CD, " ).append("\n"); 
		query.append("        INV_STS_CD, PRN_HDN_FLG, AUTO_RAT_CD, APLY_XCH_RTO, AGMT_RAT_UT_CD, " ).append("\n"); 
		query.append("        NOTE_RT_SEQ, PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, " ).append("\n"); 
		query.append("        CMDT_HDR_SEQ, ROUT_SEQ, CRE_USR_ID, CRE_DT, UPD_USR_ID, " ).append("\n"); 
		query.append("        UPD_DT, FX_RT_FLG, SOC_FLG )" ).append("\n"); 
		query.append(" SELECT D.BKG_NO, D.REV_DTL_SEQ, DP_SEQ, FRT_TERM_CD, TRF_ITM_NO, " ).append("\n"); 
		query.append("        CGO_CATE_CD, IMDG_CLSS_CD, CHG_CD, CURR_CD, RAT_UT_CD, " ).append("\n"); 
		query.append("        BKG_QTY, RAT_AS_QTY, CHG_UT_AMT, CHG_AMT, RCV_TERM_CD, " ).append("\n"); 
		query.append("        DE_TERM_CD, N3PTY_RCV_OFC_CD, N3PTY_CUST_CNT_CD, N3PTY_CUST_SEQ, FRT_INCL_XCLD_DIV_CD, " ).append("\n"); 
		query.append("        INV_STS_CD, PRN_HDN_FLG, AUTO_RAT_CD, APLY_XCH_RTO, AGMT_RAT_UT_CD, " ).append("\n"); 
		query.append("        NOTE_RT_SEQ, PROP_NO, AMDT_SEQ, SVC_SCP_CD, GEN_SPCL_RT_TP_CD, " ).append("\n"); 
		query.append("        CMDT_HDR_SEQ, ROUT_SEQ, @[cre_usr_id], SYSDATE, @[upd_usr_id], " ).append("\n"); 
		query.append("        SYSDATE, FX_RT_FLG ,SOC_FLG " ).append("\n"); 
		query.append("   FROM BKG_REV_DTL D," ).append("\n"); 
		query.append("        BKG_REV_COST M" ).append("\n"); 
		query.append("  WHERE M.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("    AND M.REV_COST_SEQ = D.REV_COST_SEQ" ).append("\n"); 
		query.append("    AND M.SGL_REV_FLG  ='Y'" ).append("\n"); 
		query.append("    AND M.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND M.REV_COST_SEQ = (SELECT MAX(REV_COST_SEQ) FROM BKG_REV_COST WHERE BKG_NO =@[bkg_no])" ).append("\n"); 
		query.append("    AND NOT EXISTS (SELECT 1 FROM BKG_BOOKING WHERE M.BKG_NO = BKG_NO AND NVL(SUBSTR(RFA_NO,6,1),'X') = 'G')" ).append("\n"); 
		query.append("    AND NOT EXISTS (SELECT 1 FROM BKG_CHG_RT WHERE M.BKG_NO = BKG_NO)" ).append("\n"); 

	}
}