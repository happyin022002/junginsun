/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchNoINDTaxableChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.05 
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

public class BookingARCreationDBDAOSearchNoINDTaxableChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search No IND Taxable Chg
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchNoINDTaxableChgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchNoINDTaxableChgRSQL").append("\n"); 
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
		query.append("SELECT Q.AR_IF_NO" ).append("\n"); 
		query.append("     , P.IDA_GST_DIV_CD IND_GST_TP_CD" ).append("\n"); 
		query.append("     , (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = P.LOCL_CURR_CD) DP_PRCS_KNT" ).append("\n"); 
		query.append("     , P.USD_XCH_RT" ).append("\n"); 
		query.append("FROM (SELECT BL_SRC_NO, IDA_ISS_TP_CD, IDA_GST_DIV_CD, USD_XCH_RT, LOCL_CURR_CD" ).append("\n"); 
		query.append("      FROM INV_AR_MN" ).append("\n"); 
		query.append("      WHERE AR_IF_NO = (SELECT MAX(A.AR_IF_NO)" ).append("\n"); 
		query.append("                        FROM INV_AR_MN A," ).append("\n"); 
		query.append("                             INV_AR_ISS_DTL B" ).append("\n"); 
		query.append("                        WHERE B.AR_IF_NO = A.AR_IF_NO" ).append("\n"); 
		query.append("                        AND B.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("                        AND A.REV_TP_CD <> 'M')) P," ).append("\n"); 
		query.append("     INV_AR_MN Q," ).append("\n"); 
		query.append("     INV_AR_CHG R" ).append("\n"); 
		query.append("WHERE P.BL_SRC_NO = Q.BL_SRC_NO" ).append("\n"); 
		query.append("AND Q.AR_OFC_CD <> 'BOMSC'" ).append("\n"); 
		query.append("AND Q.AR_IF_NO = R.AR_IF_NO" ).append("\n"); 
		query.append("AND Q.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("AND Q.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("AND Q.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND R.CHG_CD IN ('CLN', 'CMF', 'DCH', 'DIH', 'DTH', 'ITR', 'MUC', 'NST')" ).append("\n"); 
		query.append("AND (P.IDA_ISS_TP_CD IN ('P', 'T') OR (P.IDA_ISS_TP_CD IN ('C', 'D') AND Q.IDA_INV_NO IS NULL))" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("            FROM (SELECT B.CURR_CD, SUM(B.CHG_AMT) TAXABLE_SUM, COUNT(DISTINCT B.CURR_CD) OVER() CURR_CNT" ).append("\n"); 
		query.append("                  FROM INV_AR_MN A," ).append("\n"); 
		query.append("                       INV_AR_CHG B," ).append("\n"); 
		query.append("                       INV_AR_ISS_DTL C" ).append("\n"); 
		query.append("                  WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("                  AND B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("                  AND B.CHG_SEQ = C.CHG_SEQ" ).append("\n"); 
		query.append("                  AND C.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("                  AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                  AND B.IDA_SAC_CD IS NOT NULL" ).append("\n"); 
		query.append("				  AND (B.IDA_CGST_AMT + B.IDA_SGST_AMT + B.IDA_IGST_AMT + B.IDA_UGST_AMT) <> 0" ).append("\n"); 
		query.append("                  GROUP BY B.CURR_CD) S," ).append("\n"); 
		query.append("                 (SELECT B.CURR_CD, SUM(DECODE(A.INV_DELT_DIV_CD, 'N', B.TRF_RT_AMT, B.TRF_RT_AMT * (-1))) GST_TRF_SUM, COUNT(DISTINCT B.CURR_CD) OVER() CURR_CNT" ).append("\n"); 
		query.append("                  FROM INV_AR_MN A," ).append("\n"); 
		query.append("                       INV_AR_CHG B," ).append("\n"); 
		query.append("                       INV_AR_ISS_DTL C" ).append("\n"); 
		query.append("                  WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("                  AND B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("                  AND B.CHG_SEQ = C.CHG_SEQ" ).append("\n"); 
		query.append("                  AND C.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("                  AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                  AND B.CHG_CD IN ('GST', 'STO')" ).append("\n"); 
		query.append("                  GROUP BY B.CURR_CD) T" ).append("\n"); 
		query.append("            WHERE (S.CURR_CD = T.CURR_CD AND S.TAXABLE_SUM <> T.GST_TRF_SUM)" ).append("\n"); 
		query.append("			OR S.CURR_CNT <> T.CURR_CNT)" ).append("\n"); 

	}
}