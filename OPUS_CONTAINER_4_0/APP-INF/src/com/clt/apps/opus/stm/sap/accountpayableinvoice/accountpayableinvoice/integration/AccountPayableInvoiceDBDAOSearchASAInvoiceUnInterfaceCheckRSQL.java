/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchASAInvoiceUnInterfaceCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.03 
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

public class AccountPayableInvoiceDBDAOSearchASAInvoiceUnInterfaceCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR에서 ASA을 Finish하기 전에 해당 ASA 로 처리된 AP 전표의 존재 여부를 파악하기 위한 정보
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchASAInvoiceUnInterfaceCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchASAInvoiceUnInterfaceCheckRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(SIH.INV_SEQ)  AS UNINTERFACE_ASA" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , SAP_INV_DTL SID" ).append("\n"); 
		query.append("      , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("WHERE   SIH.INV_SEQ = SID.INV_SEQ" ).append("\n"); 
		query.append("AND     SIH.ATTR_CTNT2 = @[asa_no]" ).append("\n"); 
		query.append("AND     SIH.INV_AMT = 0" ).append("\n"); 
		query.append("AND     SIH.ATTR_CATE_NM = 'INVOICES'" ).append("\n"); 
		query.append("AND     SID.DTRB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("AND     SLCC.SGM_CTNT4  = ( SELECT  SLD.LU_CD " ).append("\n"); 
		query.append("                            FROM    SCO_LU_HDR SLH, SCO_LU_DTL SLD " ).append("\n"); 
		query.append("                            WHERE   SLH.LU_APPL_CD = 'SAP' " ).append("\n"); 
		query.append("                            AND     SLH.LU_TP_CD = 'ASA CLEARING ACCOUNT' " ).append("\n"); 
		query.append("                            AND     SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("                            AND     SLD.ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("                            AND     ROWNUM = 1 )" ).append("\n"); 
		query.append("AND     (SID.ATTR_CTNT13 IS NULL OR SID.ATTR_CTNT13 <> 'Y')" ).append("\n"); 
		query.append("AND     SIH.INV_CXL_DT IS NULL" ).append("\n"); 

	}
}