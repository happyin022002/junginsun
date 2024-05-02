/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOModifyBatchPaymentInvScheduleCompleteInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.28 
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

public class AccountPayableInvoiceDBDAOModifyBatchPaymentInvScheduleCompleteInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBatchPaymentInvScheduleCompleteInfo
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOModifyBatchPaymentInvScheduleCompleteInfoUSQL(){
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
		query.append("FileName : AccountPayableInvoiceDBDAOModifyBatchPaymentInvScheduleCompleteInfoUSQL").append("\n"); 
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
		query.append("UPDATE  SAP_PAY_SKD SPS" ).append("\n"); 
		query.append("SET     PAY_RMN_AMT = NVL(PAY_RMN_AMT, 0) - (SELECT  SSI2.PAY_AMT FROM SAP_SEL_INV SSI2 " ).append("\n"); 
		query.append("                                             WHERE   SSI2.PAY_BAT_SEQ = @[pay_bat_seq] AND SSI2.PAY_BAT_NM = @[pay_bat_nm] " ).append("\n"); 
		query.append("                                             AND     SSI2.INV_SEQ = SPS.INV_SEQ AND SSI2.PAY_NO = SPS.PAY_SKD_NO)" ).append("\n"); 
		query.append("      , PAY_STS_FLG = DECODE(NVL(PAY_RMN_AMT, 0) - (SELECT  SSI2.PAY_AMT FROM SAP_SEL_INV SSI2 " ).append("\n"); 
		query.append("                                                    WHERE   SSI2.PAY_BAT_SEQ = @[pay_bat_seq] AND SSI2.PAY_BAT_NM = @[pay_bat_nm] AND SSI2.INV_SEQ = SPS.INV_SEQ AND SSI2.PAY_NO = SPS.PAY_SKD_NO), " ).append("\n"); 
		query.append("                                             0, 'Y', PAY_GRS_AMT, 'N', 'P')" ).append("\n"); 
		query.append("      , PAY_BAT_RUN_SEQ = ''" ).append("\n"); 
		query.append("      , UPD_USR_ID	= @[usr_id]" ).append("\n"); 
		query.append("      , UPD_DT	= SYSDATE" ).append("\n"); 
		query.append("WHERE   (SPS.INV_SEQ, SPS.PAY_SKD_NO) IN (SELECT SSI.INV_SEQ" ).append("\n"); 
		query.append("                                                ,SSI.PAY_NO" ).append("\n"); 
		query.append("                                          FROM   SAP_SEL_INV SSI" ).append("\n"); 
		query.append("                                          WHERE  SSI.PAY_BAT_SEQ = @[pay_bat_seq]" ).append("\n"); 
		query.append("                                          AND    SSI.PAY_BAT_NM = @[pay_bat_nm])" ).append("\n"); 

	}
}