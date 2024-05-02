/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchCmpbChgRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.26 
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

public class EBookingReceiptDBDAOsearchCmpbChgRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchCmpbChgRtRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchCmpbChgRtRSQL").append("\n"); 
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
		query.append("SELECT D.CHG_CD," ).append("\n"); 
		query.append("         D.TRF_ITM_NO," ).append("\n"); 
		query.append("         D.CURR_CD," ).append("\n"); 
		query.append("         D.RAT_UT_CD," ).append("\n"); 
		query.append("         D.RAT_AS_QTY," ).append("\n"); 
		query.append("         D.CHG_UT_AMT," ).append("\n"); 
		query.append("         D.CHG_AMT," ).append("\n"); 
		query.append("         D.FRT_TERM_CD," ).append("\n"); 
		query.append("         D.SVC_SCP_CD," ).append("\n"); 
		query.append("         D.GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("         D.CMDT_HDR_SEQ," ).append("\n"); 
		query.append("         D.ROUT_SEQ," ).append("\n"); 
		query.append("         (SELECT MST_RFA_ROUT_ID" ).append("\n"); 
		query.append("            FROM BKG_REV_DTL" ).append("\n"); 
		query.append("           WHERE BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("             AND REV_COST_SEQ = M.REV_COST_SEQ" ).append("\n"); 
		query.append("             AND MST_RFA_ROUT_ID IS NOT NULL" ).append("\n"); 
		query.append("             AND ROWNUM = 1) AS MST_RFA_ROUT_ID" ).append("\n"); 
		query.append("  FROM BKG_REV_DTL D," ).append("\n"); 
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