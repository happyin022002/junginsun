/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DropOffInquiryDBDAOsearchDropOffInvoiceInquiryDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffInquiryDBDAOsearchDropOffInvoiceInquiryDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DropOff Invoice Inquiry Detail List
	  * </pre>
	  */
	public DropOffInquiryDBDAOsearchDropOffInvoiceInquiryDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.integration").append("\n"); 
		query.append("FileName : DropOffInquiryDBDAOsearchDropOffInvoiceInquiryDetailListRSQL").append("\n"); 
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
		query.append("SELECT G.TRO_IB_CFM_OFC_CD" ).append("\n"); 
		query.append("     , G.BKG_NO" ).append("\n"); 
		query.append("     , TO_CHAR(G.TRO_IB_CFM_DT, 'YYYY-MM-DD') TRO_IB_CFM_DT" ).append("\n"); 
		query.append("     , G.CNTR_NO" ).append("\n"); 
		query.append("     , G.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , G.DEL_CD" ).append("\n"); 
		query.append("     , G.CNTR_RTN_YD_CD" ).append("\n"); 
		query.append("     , TO_CHAR(G.CNTR_RTN_DT, 'YYYY-MM-DD') CNTR_RTN_DT" ).append("\n"); 
		query.append("     , G.CUST_CNT_CD" ).append("\n"); 
		query.append("     , G.CUST_SEQ" ).append("\n"); 
		query.append("     , G.CUST_CNT_CD || LPAD(G.CUST_SEQ, 6, 0) CUSTOMER " ).append("\n"); 
		query.append("     , (SELECT SUBSTR(C.CUST_LGL_ENG_NM, 1, 50)" ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER C" ).append("\n"); 
		query.append("         WHERE C.CUST_CNT_CD = G.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND C.CUST_SEQ = G.CUST_SEQ ) CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("     , G.SPCL_CUST_CNT_CD" ).append("\n"); 
		query.append("     , G.SPCL_CUST_SEQ" ).append("\n"); 
		query.append("     , G.SPCL_CUST_CNT_CD || LPAD(G.SPCL_CUST_SEQ, 6, 0) SPC_CUSTOMER" ).append("\n"); 
		query.append("     , (SELECT SUBSTR(C.CUST_LGL_ENG_NM, 1, 50)" ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER C" ).append("\n"); 
		query.append("         WHERE C.CUST_CNT_CD = G.SPCL_CUST_CNT_CD" ).append("\n"); 
		query.append("           AND C.CUST_SEQ = G.SPCL_CUST_SEQ ) SPCL_CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("     , (SELECT F.RFA_NO" ).append("\n"); 
		query.append("        FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("        WHERE F.DRP_OFF_CHG_TRF_SEQ = G.DRP_OFF_CHG_TRF_SPCL_SEQ ) RFA_NO" ).append("\n"); 
		query.append("     , (SELECT F.SC_NO" ).append("\n"); 
		query.append("        FROM DOD_DRP_OFF_CHG_TRF F" ).append("\n"); 
		query.append("        WHERE F.DRP_OFF_CHG_TRF_SEQ = G.DRP_OFF_CHG_TRF_SPCL_SEQ ) SC_NO" ).append("\n"); 
		query.append("     , G.CURR_CD" ).append("\n"); 
		query.append("     ,DECODE( NVL(G.GEN_TRF_AMT, 0), 0," ).append("\n"); 
		query.append("       (SELECT D.DRP_OFF_CHG_TRF_AMT" ).append("\n"); 
		query.append("          FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', G.DEL_CD)" ).append("\n"); 
		query.append("           AND D.CNTR_RTN_LOC_CD = SUBSTR(G.CNTR_RTN_YD_CD, 1, 5) -- To Be-RTN CY" ).append("\n"); 
		query.append("           AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(G.CNTR_RTN_YD_CD, 6, 2)) -- To Be-RTN CY" ).append("\n"); 
		query.append("           AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("           AND D.CNTR_TPSZ_CD = G.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           AND D.DRP_OFF_CHG_TRF_DIV_CD = 'G'" ).append("\n"); 
		query.append("           AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("           AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("           AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("           AND NVL(D.DEL_CD||D.CNTR_RTN_YD_SFX_CD, 1) = " ).append("\n"); 
		query.append("           		(SELECT NVL(MAX(D.DEL_CD)||MAX(D.CNTR_RTN_YD_SFX_CD), 1)" ).append("\n"); 
		query.append("                        FROM DOD_DRP_OFF_CHG_TRF D" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND DECODE(D.DEL_CD, NULL, '1', D.DEL_CD) = DECODE(D.DEL_CD, NULL, '1', B.POD_CD)" ).append("\n"); 
		query.append("                   AND D.CNTR_RTN_LOC_CD = SUBSTR(G.CNTR_RTN_YD_CD, 1, 5) -- To Be-RTN CY" ).append("\n"); 
		query.append("                   AND DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', D.CNTR_RTN_YD_SFX_CD) = DECODE(D.CNTR_RTN_YD_SFX_CD, NULL, '1', SUBSTR(G.CNTR_RTN_YD_CD, 6, 2)) -- To Be-RTN CY" ).append("\n"); 
		query.append("                   AND D.POL_CONTI_CD = SUBSTR(B.ORG_SCONTI_CD, 1, 1)" ).append("\n"); 
		query.append("                   AND D.CNTR_TPSZ_CD = G.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_DIV_CD = 'G'" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND D.DRP_OFF_CHG_TRF_EXPT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND B.POL_ETD_DT BETWEEN TO_DATE(D.DRP_OFF_CHG_TRF_EFF_DT, 'YYYYMMDD') + .0 AND TO_DATE(D.DRP_OFF_CHG_TRF_EXP_DT, 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("         ), G.GEN_TRF_AMT) GEN_TRF_AMT" ).append("\n"); 
		query.append("     , G.SPCL_TRF_AMT" ).append("\n"); 
		query.append("     , G.DC_AMT" ).append("\n"); 
		query.append("     , G.TTL_AMT" ).append("\n"); 
		query.append("     , G.SVC_FEE_AMT" ).append("\n"); 
		query.append("     , TO_CHAR(G.UPD_DT, 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("     , G.UPD_USR_ID" ).append("\n"); 
		query.append("     , (SELECT T.CXL_FLG" ).append("\n"); 
		query.append("        FROM BKG_EUR_TRO T" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND T.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("          AND T.CNTR_NO = G.CNTR_NO" ).append("\n"); 
		query.append("          AND T.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("          AND T.TRO_SEQ = (SELECT MAX(TT.TRO_SEQ)" ).append("\n"); 
		query.append("                            FROM BKG_EUR_TRO TT" ).append("\n"); 
		query.append("                            WHERE TT.BKG_NO = T.BKG_NO" ).append("\n"); 
		query.append("                              AND TT.CNTR_NO = T.CNTR_NO" ).append("\n"); 
		query.append("                              AND TT.IO_BND_CD = 'I')" ).append("\n"); 
		query.append("       ) CXL_FLG" ).append("\n"); 
		query.append("  FROM DOD_DRP_OFF_CHG G, BKG_BOOKING B" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND G.BKG_NO = @[s_bkg_no] --BKG_NO" ).append("\n"); 
		query.append("   AND G.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND G.DRP_OFF_CHG_MNL_FLG = DECODE(@[s_ind_cd], 'I', 'N', 'Y') --  INV : N,  MAN : Y" ).append("\n"); 

	}
}