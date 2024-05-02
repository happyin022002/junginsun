/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RailInvoiceInquiryCorrectionDBDAOSearchUsRailInvoiceInquirySecondExcelFormRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceInquiryCorrectionDBDAOSearchUsRailInvoiceInquirySecondExcelFormRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RailInvoiceInquiryCorrectionDBDAOSearchUsRailInvoiceInquirySecondExcelForm
	  * </pre>
	  */
	public RailInvoiceInquiryCorrectionDBDAOSearchUsRailInvoiceInquirySecondExcelFormRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.integration").append("\n"); 
		query.append("FileName : RailInvoiceInquiryCorrectionDBDAOSearchUsRailInvoiceInquirySecondExcelFormRSQL").append("\n"); 
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
		query.append("SELECT A.TRSP_INV_AUD_STS_CD" ).append("\n"); 
		query.append("      ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00824', A.TRSP_INV_AUD_STS_CD) TRSP_INV_AUD_STS_NM" ).append("\n"); 
		query.append("      ,DECODE(A.INV_HLD_FLG, 'N', '0', 'Y', '1') INV_HLD_FLG" ).append("\n"); 
		query.append("      ,A.INV_NO" ).append("\n"); 
		query.append("      ,A.INV_VNDR_SEQ" ).append("\n"); 
		query.append("      ,C.VNDR_LGL_ENG_NM INV_VNDR_NM" ).append("\n"); 
		query.append("      ,A.WO_VNDR_SEQ" ).append("\n"); 
		query.append("      ,D.VNDR_LGL_ENG_NM WO_VNDR_NM" ).append("\n"); 
		query.append("      ,B.EQ_NO" ).append("\n"); 
		query.append("      ,B.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,B.CURR_CD" ).append("\n"); 
		query.append("      ,NVL(B.BZC_AMT, 0) BZC_AMT" ).append("\n"); 
		query.append("      ,NVL(B.FUEL_SCG_AMT, 0) FUEL_SCG_AMT" ).append("\n"); 
		query.append("      ,NVL(B.OVR_WGT_SCG_AMT, 0) OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append("      ,NVL(B.ETC_ADD_AMT, 0) ETC_ADD_AMT" ).append("\n"); 
		query.append("      ,NVL(B.BZC_AMT, 0) + NVL(B.FUEL_SCG_AMT, 0) + NVL(B.OVR_WGT_SCG_AMT, 0) + NVL(B.HZD_MTRL_SCG_AMT, 0) + NVL(B.ETC_ADD_AMT, 0) AS WO_TTL_AMT" ).append("\n"); 
		query.append("      ,B.INV_CURR_CD" ).append("\n"); 
		query.append("      ,NVL(B.INV_BZC_AMT, 0) INV_BZC_AMT" ).append("\n"); 
		query.append("      ,NVL(B.INV_BZC_AMT, 0) AS INV_TTL_AMT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.INV_ISS_DT, 'YYYY-MM-DD') INV_ISS_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.INV_RCV_DT, 'YYYY-MM-DD') INV_RCV_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.PAY_DT, 'YYYY-MM-DD') PAY_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(TO_DATE(E.GL_DT, 'YYYYMMDD'), 'YYYY-MM-DD') GL_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("      ,A.CSR_NO" ).append("\n"); 
		query.append("      ,A.INV_PAY_MZD_CD" ).append("\n"); 
		query.append("      ,A.INV_CHK_TRNS_NO" ).append("\n"); 
		query.append("      ,'' INV_REMARK" ).append("\n"); 
		query.append("      ,A.CRE_OFC_CD" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("  FROM TRS_TRSP_RAIL_INV_WRK A" ).append("\n"); 
		query.append("      ,TRS_TRSP_RAIL_INV_DTL B" ).append("\n"); 
		query.append("      ,MDM_VENDOR            C" ).append("\n"); 
		query.append("      ,MDM_VENDOR            D" ).append("\n"); 
		query.append("      ,AP_INV_HDR            E" ).append("\n"); 
		query.append(" WHERE A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("   AND A.INV_VNDR_SEQ = B.INV_VNDR_SEQ" ).append("\n"); 
		query.append("   AND A.INV_VNDR_SEQ = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.WO_VNDR_SEQ = D.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.CSR_NO = E.CSR_NO(+)" ).append("\n"); 
		query.append("   AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("   AND A.INV_VNDR_SEQ = @[inv_vndr_seq]" ).append("\n"); 

	}
}