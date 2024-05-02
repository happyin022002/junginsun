/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchAsaIFTransYNRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.17 
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

public class AccountPayableInvoiceDBDAOSearchAsaIFTransYNRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAsaIFTransYN
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchAsaIFTransYNRSQL(){
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
		query.append("FileName : AccountPayableInvoiceDBDAOSearchAsaIFTransYNRSQL").append("\n"); 
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
		query.append("SELECT DECODE( COUNT(D.ATTR_CTNT13), 0, 'N', 'Y') AS TRANS_YN" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR H" ).append("\n"); 
		query.append("      , SAP_INV_DTL D" ).append("\n"); 
		query.append("      , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("WHERE   H.INV_SEQ = D.INV_SEQ" ).append("\n"); 
		query.append("AND     D.DTRB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("AND     H.INV_SEQ = TO_NUMBER (@[inv_seq])" ).append("\n"); 
		query.append("AND     SLCC.SGM_CTNT4    = ( SELECT SLD.LU_CD " ).append("\n"); 
		query.append("                            FROM SCO_LU_HDR SLH, SCO_LU_DTL SLD " ).append("\n"); 
		query.append("                            WHERE SLH.LU_APPL_CD = 'SAP' " ).append("\n"); 
		query.append("                            AND SLH.LU_TP_CD = 'ASA CLEARING ACCOUNT' " ).append("\n"); 
		query.append("                            AND SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("                            AND SLD.ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("                            AND ROWNUM = 1 )  " ).append("\n"); 
		query.append("AND     D.ATTR_CTNT13 = 'Y'" ).append("\n"); 

	}
}