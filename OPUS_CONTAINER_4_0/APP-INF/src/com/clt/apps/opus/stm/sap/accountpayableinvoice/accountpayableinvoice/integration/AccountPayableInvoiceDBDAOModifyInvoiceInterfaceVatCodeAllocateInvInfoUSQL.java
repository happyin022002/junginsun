/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOModifyInvoiceInterfaceVatCodeAllocateInvInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOModifyInvoiceInterfaceVatCodeAllocateInvInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Front 에서 Interface되는 비용 전표중 국내 부가세를 갖는 경우에 한해서 해당 Vendor Invoice No을 갖는 비용에 Tax Code을 맵핑 처리
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOModifyInvoiceInterfaceVatCodeAllocateInvInfoUSQL(){
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
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOModifyInvoiceInterfaceVatCodeAllocateInvInfoUSQL").append("\n"); 
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
		query.append("SET     SID1.DTRB_VAT_CD = (WITH RESULT_VAT AS (SELECT  SID.DTRB_AMT" ).append("\n"); 
		query.append("                                                      , SID.INV_DTRB_SEQ" ).append("\n"); 
		query.append("                                                      , SID.ATTR_CTNT1 AS VNDR_INV_NO" ).append("\n"); 
		query.append("                                                      , SID.INV_SEQ" ).append("\n"); 
		query.append("                                                      , SID.DTRB_VAT_CD" ).append("\n"); 
		query.append("                                                FROM    SAP_INV_DTL SID" ).append("\n"); 
		query.append("                                                      , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("                                                WHERE   SID.INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("                                                AND     SID.LINE_TP_LU_CD = 'TAX'" ).append("\n"); 
		query.append("                                                AND     NVL(SID.RVS_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                                                AND     SID.DTRB_AMT <> 0" ).append("\n"); 
		query.append("                                                AND     SID.DTRB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ " ).append("\n"); 
		query.append("                                                AND     SLCC.SGM_CTNT4 IN (SELECT  SLD.LU_CD FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD " ).append("\n"); 
		query.append("                                                                           WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD AND SLH.LU_TP_CD = 'AP TAX ACCOUNT' AND NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("                                                                           AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE AND SLH.LU_APPL_CD = 'SAP'AND SLD.ATTR_CTNT1 = 'INTERNAL'))" ).append("\n"); 
		query.append("                              SELECT  RESULT_VAT.DTRB_VAT_CD" ).append("\n"); 
		query.append("                              FROM    RESULT_VAT" ).append("\n"); 
		query.append("                              WHERE   RESULT_VAT.INV_SEQ = SID1.INV_SEQ" ).append("\n"); 
		query.append("                              AND     RESULT_VAT.VNDR_INV_NO = SID1.ATTR_CTNT1)" ).append("\n"); 
		query.append("WHERE   SID1.INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("AND     SID1.DTRB_AMT <> 0" ).append("\n"); 
		query.append("AND     SID1.DTRB_VAT_CD IS NULL " ).append("\n"); 
		query.append("AND     SID1.LINE_TP_LU_CD = 'ITEM'" ).append("\n"); 
		query.append("AND     NOT EXISTS (SELECT  'A' FROM SAP_INV_DTL SID2, SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("                    WHERE   SID2.INV_DTRB_SEQ = SID1.INV_DTRB_SEQ" ).append("\n"); 
		query.append("                    AND     NVL(SID2.RVS_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                    AND     SID2.DTRB_AMT <> 0" ).append("\n"); 
		query.append("                    AND     SID2.DTRB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ " ).append("\n"); 
		query.append("                    AND     SLCC.SGM_CTNT4 IN (SELECT  SLD.LU_CD FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD " ).append("\n"); 
		query.append("                                               WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD AND SLH.LU_TP_CD = 'AP TAX ACCOUNT' AND NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("                                               AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE AND SLH.LU_APPL_CD = 'SAP'AND SLD.ATTR_CTNT1 = 'WITHHOLDING'))" ).append("\n"); 

	}
}