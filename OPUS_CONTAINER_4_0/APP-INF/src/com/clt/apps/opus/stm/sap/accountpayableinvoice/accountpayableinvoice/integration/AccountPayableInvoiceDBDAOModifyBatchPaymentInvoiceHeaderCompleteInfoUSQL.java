/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOModifyBatchPaymentInvoiceHeaderCompleteInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.24 
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

public class AccountPayableInvoiceDBDAOModifyBatchPaymentInvoiceHeaderCompleteInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBatchPaymentInvoiceHeaderCompleteInfo
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOModifyBatchPaymentInvoiceHeaderCompleteInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_bat_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_bat_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOModifyBatchPaymentInvoiceHeaderCompleteInfoUSQL").append("\n"); 
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
		query.append("UPDATE  SAP_INV_HDR SIH" ).append("\n"); 
		query.append("SET     INV_PAY_AMT = NVL(INV_PAY_AMT,0) + (SELECT   SUM(SSI2.PAY_AMT)  FROM SAP_SEL_INV SSI2 " ).append("\n"); 
		query.append("                                             WHERE   SSI2.PAY_BAT_SEQ = @[pay_bat_seq] AND SSI2.PAY_BAT_NM = @[pay_bat_nm] " ).append("\n"); 
		query.append("                                             AND     SSI2.INV_SEQ = SIH.INV_SEQ)" ).append("\n"); 
		query.append("      , PAY_STS_FLG = DECODE(NVL(INV_PAY_AMT,0) + (SELECT   SUM(SSI2.PAY_AMT)  FROM SAP_SEL_INV SSI2 " ).append("\n"); 
		query.append("                                             WHERE   SSI2.PAY_BAT_SEQ = @[pay_bat_seq] AND SSI2.PAY_BAT_NM = @[pay_bat_nm] AND SSI2.INV_SEQ = SIH.INV_SEQ)," ).append("\n"); 
		query.append("                                             0, 'N', INV_AMT, 'Y', 'P')" ).append("\n"); 
		query.append("      , UPD_USR_ID	= @[usr_id]" ).append("\n"); 
		query.append("      , UPD_DT	= SYSDATE" ).append("\n"); 
		query.append("WHERE   SIH.INV_SEQ IN (SELECT DISTINCT SSI.INV_SEQ" ).append("\n"); 
		query.append("                        FROM   SAP_SEL_INV SSI" ).append("\n"); 
		query.append("                        WHERE  SSI.PAY_BAT_SEQ = @[pay_bat_seq]" ).append("\n"); 
		query.append("                        AND    SSI.PAY_BAT_NM = @[pay_bat_nm])" ).append("\n"); 

	}
}