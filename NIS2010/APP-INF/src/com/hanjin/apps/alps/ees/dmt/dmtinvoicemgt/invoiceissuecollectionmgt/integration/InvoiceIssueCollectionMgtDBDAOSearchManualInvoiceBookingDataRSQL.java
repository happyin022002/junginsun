/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceBookingDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceBookingDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG No. 로 Booking 정보를 조회하는 쿼리
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceBookingDataRSQL(){
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
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceBookingDataRSQL").append("\n"); 
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
		query.append("SELECT	VVD_CD" ).append("\n"); 
		query.append(",	SC_NO" ).append("\n"); 
		query.append(",	RFA_NO" ).append("\n"); 
		query.append(",	POR_CD" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	DEL_CD" ).append("\n"); 
		query.append(",	RCV_TERM_CD" ).append("\n"); 
		query.append(",	DE_TERM_CD" ).append("\n"); 
		query.append(",	CASE" ).append("\n"); 
		query.append("WHEN (ACT_CNT_CD IS NULL OR ACT_CNT_CD = '00') AND (ACT_CUST_SEQ IS NULL OR ACT_CUST_SEQ = 0)" ).append("\n"); 
		query.append("THEN ''" ).append("\n"); 
		query.append("WHEN (ACT_CNT_CD IS NULL OR ACT_CNT_CD = '00') AND ACT_CUST_SEQ > 0" ).append("\n"); 
		query.append("THEN LPAD(ACT_CUST_SEQ, 6, '0')" ).append("\n"); 
		query.append("ELSE ACT_CNT_CD || LPAD(ACT_CUST_SEQ, 6, '0')" ).append("\n"); 
		query.append("END ACT_PAYR_CUST_CD" ).append("\n"); 
		query.append(",	CASE" ).append("\n"); 
		query.append("WHEN ACT_CNT_CD IS NULL OR ACT_CNT_CD = '00'" ).append("\n"); 
		query.append("THEN PARY_VNDR_NM" ).append("\n"); 
		query.append("ELSE PAYR_CUST_NM" ).append("\n"); 
		query.append("END ACT_PAYR_CUST_NM" ).append("\n"); 
		query.append(",	VNDR_SEQ" ).append("\n"); 
		query.append(",	VNDR_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT  DISTINCT CHG_CNTR.VSL_CD || CHG_CNTR.SKD_VOY_NO || CHG_CNTR.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append(",	CHG_CNTR.SC_NO" ).append("\n"); 
		query.append(",	CHG_CNTR.RFA_NO" ).append("\n"); 
		query.append(",	CHG_CNTR.POR_CD" ).append("\n"); 
		query.append(",   CHG_CNTR.POL_CD" ).append("\n"); 
		query.append(",   CHG_CNTR.POD_CD" ).append("\n"); 
		query.append(",   CHG_CNTR.DEL_CD" ).append("\n"); 
		query.append(",   CHG_CNTR.BKG_RCV_TERM_CD RCV_TERM_CD" ).append("\n"); 
		query.append(",   CHG_CNTR.BKG_DE_TERM_CD DE_TERM_CD" ).append("\n"); 
		query.append(",   CHG_CALC.ACT_CNT_CD" ).append("\n"); 
		query.append(",   CHG_CALC.ACT_CUST_SEQ" ).append("\n"); 
		query.append(",   DECODE(CHG_CALC.VNDR_SEQ, 0, '', CHG_CALC.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append(",   DECODE(CHG_CALC.VNDR_SEQ, 0, '', VENDOR.VNDR_LGL_ENG_NM) AS VNDR_NM" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("SELECT  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM    MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE   CUST_CNT_CD = CHG_CALC.ACT_CNT_CD" ).append("\n"); 
		query.append("AND CUST_SEQ = CHG_CALC.ACT_CUST_SEQ" ).append("\n"); 
		query.append(") PAYR_CUST_NM" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("SELECT  VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM    MDM_VENDOR" ).append("\n"); 
		query.append("WHERE   VNDR_SEQ = CHG_CALC.VNDR_SEQ" ).append("\n"); 
		query.append(") PARY_VNDR_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DMT_CHG_BKG_CNTR CHG_CNTR" ).append("\n"); 
		query.append(",   DMT_CHG_CALC CHG_CALC" ).append("\n"); 
		query.append(",   MDM_VENDOR VENDOR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   CHG_CNTR.SYS_AREA_GRP_ID =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("FROM    COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE   CNT_CD =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SUBSTR(@[dmdt_trf_cd], 2, 1) = 'M' AND SUBSTR(@[dmdt_trf_cd], 3, 1) = 'I'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.POD_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN SUBSTR(@[dmdt_trf_cd], 2, 1) = 'M' AND SUBSTR(@[dmdt_trf_cd], 3, 1) = 'O'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.POL_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN SUBSTR(@[dmdt_trf_cd], 2, 1) = 'T' AND SUBSTR(@[dmdt_trf_cd], 3, 1) = 'I'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.DEL_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN SUBSTR(@[dmdt_trf_cd], 2, 1) = 'T' AND SUBSTR(@[dmdt_trf_cd], 3, 1) = 'O'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.POR_CD, 0, 2)" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CHG_CNTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CHG_CNTR.SYS_AREA_GRP_ID = CHG_CALC.SYS_AREA_GRP_ID(+)" ).append("\n"); 
		query.append("AND CHG_CNTR.CNTR_NO = CHG_CALC.CNTR_NO(+)" ).append("\n"); 
		query.append("AND CHG_CNTR.CNTR_CYC_NO = CHG_CALC.CNTR_CYC_NO(+)" ).append("\n"); 
		query.append("AND CHG_CALC.DMDT_TRF_CD(+) = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND CHG_CALC.DMDT_CHG_LOC_DIV_CD(+) <> 'TSP'" ).append("\n"); 
		query.append("AND CHG_CALC.VNDR_SEQ = VENDOR.VNDR_SEQ(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}