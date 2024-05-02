/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOModifyInterfaceSAPUpstreamStandardPartialApplyInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOModifyInterfaceSAPUpstreamStandardPartialApplyInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Upstream모듈에서 온 Standard 비용 전표에 대해서 partial Apply건에 대한 Liability Rate 금액 처리
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOModifyInterfaceSAPUpstreamStandardPartialApplyInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOModifyInterfaceSAPUpstreamStandardPartialApplyInfoUSQL").append("\n"); 
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
		query.append("UPDATE  SAP_INV_DTL SID1" ).append("\n"); 
		query.append("SET     SID1.GLO_ATTR_CTNT1 = (WITH RESULT_AMT AS (SELECT  SID.DTRB_AMT" ).append("\n"); 
		query.append("                                                         , SID.DTRB_FUNC_AMT" ).append("\n"); 
		query.append("                                                         , SID.DTRB_XCH_DT" ).append("\n"); 
		query.append("                                                         , SID.DTRB_XCH_RT" ).append("\n"); 
		query.append("                                                         , SID.INV_DTRB_SEQ" ).append("\n"); 
		query.append("                                                         , SID.DTRB_LINE_NO" ).append("\n"); 
		query.append("                                                         , (SELECT  SUM(ABS(SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2 " ).append("\n"); 
		query.append("                                                            WHERE   SID2.INV_SEQ = @[inv_seq] AND SID2.LINE_TP_LU_CD = 'PREPAY' " ).append("\n"); 
		query.append("                                                            AND     NVL(SID2.RVS_FLG, 'N') = 'N') AS PREPAY_AMT" ).append("\n"); 
		query.append("                                                         , ROW_NUMBER() OVER (ORDER BY NVL(SID.DTRB_XCH_DT, TO_DATE(SID.ATTR_CTNT11, 'YYYYMMDD'))) AS ROW_NUM" ).append("\n"); 
		query.append("                                                   FROM    SAP_INV_DTL SID" ).append("\n"); 
		query.append("                                                   WHERE   SID.INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("                                                   AND     SID.LINE_TP_LU_CD <> 'PREPAY'" ).append("\n"); 
		query.append("                                                   AND     NVL(SID.RVS_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                                                   ORDER   BY NVL(SID.DTRB_XCH_DT, TO_DATE(SID.ATTR_CTNT11, 'YYYYMMDD')))" ).append("\n"); 
		query.append("                               SELECT  CASE WHEN RESULT_AMT.PREPAY_AMT >= RESULT_AMT.DTRB_AMT + NVL((SELECT  SUM(B.DTRB_AMT) FROM RESULT_AMT B " ).append("\n"); 
		query.append("                                                                                                     WHERE   B.ROW_NUM < RESULT_AMT.ROW_NUM), 0) " ).append("\n"); 
		query.append("                                                 THEN RESULT_AMT.DTRB_AMT" ).append("\n"); 
		query.append("                                            WHEN RESULT_AMT.PREPAY_AMT - NVL((SELECT  SUM(B.DTRB_AMT) FROM RESULT_AMT B " ).append("\n"); 
		query.append("                                                                              WHERE   B.ROW_NUM < RESULT_AMT.ROW_NUM), 0) > 0" ).append("\n"); 
		query.append("                                                 THEN RESULT_AMT.PREPAY_AMT - NVL((SELECT  SUM(B.DTRB_AMT) FROM RESULT_AMT B " ).append("\n"); 
		query.append("                                                                              WHERE   B.ROW_NUM < RESULT_AMT.ROW_NUM), 0)" ).append("\n"); 
		query.append("                                            ELSE NULL END CALCU_AMT" ).append("\n"); 
		query.append("                              FROM    RESULT_AMT" ).append("\n"); 
		query.append("                              WHERE   RESULT_AMT.INV_DTRB_SEQ = SID1.INV_DTRB_SEQ)" ).append("\n"); 
		query.append("WHERE   SID1.INV_SEQ = @[inv_seq]" ).append("\n"); 

	}
}