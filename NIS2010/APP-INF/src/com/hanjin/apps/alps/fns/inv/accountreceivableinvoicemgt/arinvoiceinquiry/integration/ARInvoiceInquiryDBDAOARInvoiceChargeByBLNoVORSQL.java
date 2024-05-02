/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOARInvoiceChargeByBLNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOARInvoiceChargeByBLNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOARInvoiceChargeByBLNoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOARInvoiceChargeByBLNoVORSQL").append("\n"); 
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
		query.append("SELECT CHG_CD" ).append("\n"); 
		query.append(", MNL_FLG" ).append("\n"); 
		query.append(", CASE WHEN RAT_AS_CNTR_QTY < 0 THEN RAT_AS_CNTR_QTY*-1 ELSE RAT_AS_CNTR_QTY END RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append(", CASE WHEN CHG_AMT < 0 THEN CASE WHEN TRF_RT_AMT > 0 THEN TRF_RT_AMT * -1" ).append("\n"); 
		query.append("ELSE TRF_RT_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE CASE WHEN TRF_RT_AMT < 0 THEN TRF_RT_AMT * -1" ).append("\n"); 
		query.append("ELSE TRF_RT_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END TRF_RT_AMT" ).append("\n"); 
		query.append(", PER_TP_CD" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", CHG_AMT" ).append("\n"); 
		query.append(", DP_PRCS_KNT" ).append("\n"); 
		query.append(", INV_XCH_RT" ).append("\n"); 
		query.append(", LOCL_CURR_CD" ).append("\n"); 
		query.append(", LOCAL_TOTAL" ).append("\n"); 
		query.append(", DP_PRCS_KNT DP_PRCS_KNT_LOCAL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT B.CHG_CD" ).append("\n"); 
		query.append(", B.MF_DIV_CD MNL_FLG" ).append("\n"); 
		query.append(", DECODE(B.PER_TP_CD, 'PC', RAT_AS_CNTR_QTY, SUM(CASE WHEN B.CHG_AMT > 0 THEN B.RAT_AS_CNTR_QTY ELSE B.RAT_AS_CNTR_QTY * -1 END)) RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append(", DECODE(B.PER_TP_CD, 'PC', SUM(CASE WHEN B.CHG_AMT > 0 THEN B.TRF_RT_AMT ELSE B.TRF_RT_AMT * -1 END),B.TRF_RT_AMT) TRF_RT_AMT" ).append("\n"); 
		query.append(", B.PER_TP_CD" ).append("\n"); 
		query.append(", B.CURR_CD" ).append("\n"); 
		query.append(", SUM(B.CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append(", D.DP_PRCS_KNT" ).append("\n"); 
		query.append(", B.INV_XCH_RT" ).append("\n"); 
		query.append(", A.LOCL_CURR_CD" ).append("\n"); 
		query.append(", ROUND(SUM(B.CHG_AMT)*B.INV_XCH_RT, E.DP_PRCS_KNT) LOCAL_TOTAL" ).append("\n"); 
		query.append(", E.DP_PRCS_KNT DP_PRCS_KNT_LOCAL" ).append("\n"); 
		query.append("FROM INV_AR_MN A" ).append("\n"); 
		query.append(", INV_AR_CHG B" ).append("\n"); 
		query.append(", MDM_CURRENCY D" ).append("\n"); 
		query.append(", MDM_CURRENCY E" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND D.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("AND E.CURR_CD = A.LOCL_CURR_CD" ).append("\n"); 
		query.append("#if (${bl_src_no} != '')" ).append("\n"); 
		query.append("AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = @[office]" ).append("\n"); 
		query.append("AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND B.CHG_AMT <> 0" ).append("\n"); 
		query.append("#if (${rev_type} == 'B')" ).append("\n"); 
		query.append("AND A.REV_TP_CD = 'B'" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'C')" ).append("\n"); 
		query.append("AND A.REV_TP_CD = 'C'" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'D')" ).append("\n"); 
		query.append("AND A.REV_TP_CD = 'M' AND A.REV_SRC_CD IN ('DM','DT')" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'M')" ).append("\n"); 
		query.append("AND A.REV_TP_CD = 'M' AND A.REV_SRC_CD NOT IN ('DM','DT')" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BC')" ).append("\n"); 
		query.append("AND A.REV_TP_CD IN ('B','C')" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BD')" ).append("\n"); 
		query.append("AND (A.REV_TP_CD = 'B' OR (A.REV_TP_CD = 'M' AND A.REV_SRC_CD IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BM')" ).append("\n"); 
		query.append("AND (A.REV_TP_CD = 'B' OR (A.REV_TP_CD = 'M' AND A.REV_SRC_CD NOT IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'CD')" ).append("\n"); 
		query.append("AND (A.REV_TP_CD = 'C' OR (A.REV_TP_CD = 'M' AND A.REV_SRC_CD IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'CM')" ).append("\n"); 
		query.append("AND (A.REV_TP_CD = 'C' OR (A.REV_TP_CD = 'M' AND A.REV_SRC_CD NOT IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'DM')" ).append("\n"); 
		query.append("AND A.REV_TP_CD = 'M'" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BCD')" ).append("\n"); 
		query.append("AND (A.REV_TP_CD IN ('B','C') OR (A.REV_TP_CD = 'M' AND A.REV_SRC_CD IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BCM')" ).append("\n"); 
		query.append("AND (A.REV_TP_CD IN ('B','C') OR (A.REV_TP_CD = 'M' AND A.REV_SRC_CD NOT IN ('DM','DT')))" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'BDM')" ).append("\n"); 
		query.append("AND A.REV_TP_CD IN ('B','M')" ).append("\n"); 
		query.append("#elseif (${rev_type} == 'CDM')" ).append("\n"); 
		query.append("AND A.REV_TP_CD IN ('C','M')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY B.CHG_CD, B.MF_DIV_CD, B.TRF_RT_AMT, RAT_AS_CNTR_QTY, DECODE(B.PER_TP_CD, 'PC', TO_CHAR(B.CHG_SEQ), B.PER_TP_CD), B.PER_TP_CD, B.CURR_CD, D.DP_PRCS_KNT, B.INV_XCH_RT, A.LOCL_CURR_CD, E.DP_PRCS_KNT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE CHG_AMT <> 0" ).append("\n"); 
		query.append("ORDER BY CHG_CD, MNL_FLG, CURR_CD, TRF_RT_AMT, PER_TP_CD" ).append("\n"); 

	}
}