/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOReceivableInvoiceInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.05.12 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOReceivableInvoiceInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receivable Rental Invoice Charge I/F 현황을 조회합니다.
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOReceivableInvoiceInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_inv_if_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qty_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOReceivableInvoiceInquiryListRSQL").append("\n"); 
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
		query.append("SELECT  B.COST_YRMON, B.INV_NO, B.VNDR_SEQ, B.VNDR_ABBR_NM," ).append("\n"); 
		query.append("        TO_CHAR(B.INV_CRE_DT, 'YYYYMMDD') AS INV_CRE_DT," ).append("\n"); 
		query.append("		TO_CHAR(B.INV_ISS_DT, 'YYYYMMDD') AS INV_ISU_DT," ).append("\n"); 
		query.append("		TO_CHAR(B.INV_DUE_DT, 'YYYYMMDD') AS INV_DUE_DT," ).append("\n"); 
		query.append("        B.CURR_CD, B.INV_AMT, B.INV_CRE_OFC_CD," ).append("\n"); 
		query.append("		NVL2(A.SRC_IF_DT,'Y', B.CFM_FLG) AS CFM_FLG," ).append("\n"); 
		query.append("        CASE WHEN A.SRC_IF_DT IS NOT NULL THEN D.OFC_CURR_CD END OFC_CURR_CD," ).append("\n"); 
		query.append("        CASE WHEN A.SRC_IF_DT IS NOT NULL " ).append("\n"); 
		query.append("             THEN C.BAL_FRT_OFC_CURR_AMT + C.BAL_TAX_OFC_CURR_AMT + C.BAL_RSV_OFC_CURR_AMT " ).append("\n"); 
		query.append("        END ERP_LCL_AMT," ).append("\n"); 
		query.append("        CASE WHEN A.SRC_IF_DT IS NOT NULL " ).append("\n"); 
		query.append("             THEN C.BAL_FRT_USD_AMT + C.BAL_TAX_USD_AMT + C.BAL_RSV_USD_AMT" ).append("\n"); 
		query.append("        END ERP_USD_AMT," ).append("\n"); 
		query.append("        CASE WHEN A.SRC_IF_DT IS NOT NULL THEN D.OTS_STL_FLG END OTS_STL_FLG, " ).append("\n"); 
		query.append("        A.BL_INV_IF_FLG, A.IF_ERR_RSN," ).append("\n"); 
		query.append("       (SELECT    K.INV_ERP_IF_STS_CD  FROM INV_AR_AMT K" ).append("\n"); 
		query.append("        WHERE     K.AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("        AND     ROWNUM = 1) AS ERP_IF_STS," ).append("\n"); 
		query.append("       (SELECT    K.ERR_DESC FROM INV_AR_AMT K" ).append("\n"); 
		query.append("        WHERE     K.AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("        AND     ROWNUM = 1) AS ERP_IF_RSN," ).append("\n"); 
		query.append("        B.INV_CRE_USR_ID, A.SRC_IF_DT, A.SRC_IF_SEQ, A.GL_EFF_DT" ).append("\n"); 
		query.append("FROM    INV_AR_IF_MN A," ).append("\n"); 
		query.append("       (SELECT  A.COST_YRMON, A.VNDR_SEQ, A.VNDR_ABBR_NM, " ).append("\n"); 
		query.append("				A.INV_NO, A.INV_CRE_OFC_CD, A.CFM_FLG," ).append("\n"); 
		query.append("    	    	MIN(A.INV_CRE_DT) AS INV_CRE_DT," ).append("\n"); 
		query.append("				MIN(A.INV_ISS_DT) AS INV_ISS_DT," ).append("\n"); 
		query.append("				MIN(A.INV_DUE_DT) AS INV_DUE_DT," ).append("\n"); 
		query.append("    	    	MIN(A.CURR_CD) AS CURR_CD," ).append("\n"); 
		query.append("        		SUM(A.INV_AMT) AS INV_AMT," ).append("\n"); 
		query.append("        		MIN(A.SRC_IF_DT) AS SRC_IF_DT," ).append("\n"); 
		query.append("	        	MIN(A.SRC_IF_SEQ) AS SRC_IF_SEQ," ).append("\n"); 
		query.append("    	    	MIN(A.INV_CRE_USR_ID) AS INV_CRE_USR_ID" ).append("\n"); 
		query.append("		FROM    LSE_RCV_RNTL_CHG A" ).append("\n"); 
		query.append("		WHERE   1 = 1" ).append("\n"); 
		query.append("		AND     A.COST_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[qty_yrmon],'RRRRMM'), 1), 'RRRRMM')" ).append("\n"); 
		query.append("#if (${vndr_seq} != '' )" ).append("\n"); 
		query.append("		AND     A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != '' )" ).append("\n"); 
		query.append("		AND     A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		GROUP BY A.COST_YRMON, A.INV_NO, A.VNDR_SEQ, A.VNDR_ABBR_NM, A.INV_CRE_OFC_CD, A.CFM_FLG" ).append("\n"); 
		query.append("		) B," ).append("\n"); 
		query.append("        BKG_OTS_DTL C," ).append("\n"); 
		query.append("        BKG_OUTSTANDING D" ).append("\n"); 
		query.append("WHERE   B.SRC_IF_SEQ = A.SRC_IF_SEQ(+)" ).append("\n"); 
		query.append("AND     B.SRC_IF_DT = A.SRC_IF_DT(+)" ).append("\n"); 
		query.append("AND     B.INV_NO IS NOT NULL" ).append("\n"); 
		query.append("AND     A.BL_SRC_NO = D.CLT_BL_NO(+)" ).append("\n"); 
		query.append("AND     A.BL_SRC_NO = D.INV_NO(+)" ).append("\n"); 
		query.append("AND     D.CLT_BL_NO = C.CLT_BL_NO(+)" ).append("\n"); 
		query.append("AND     D.OFC_CD    = DECODE(C.OFC_CD(+), 'KOR', D.OFC_CD, 'SHA', D.OFC_CD, 'SZP', D.OFC_CD, 'USA', D.OFC_CD, C.OFC_CD(+))" ).append("\n"); 
		query.append("#if (${bl_inv_if_flg} != '' )" ).append("\n"); 
		query.append("AND     A.BL_INV_IF_FLG = @[bl_inv_if_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}