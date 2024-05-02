/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOModifyInvoiceInterfacePrepayApplyPayScheduleInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.16
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.05.16 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOModifyInvoiceInterfacePrepayApplyPayScheduleInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOModifyInvoiceInterfacePrepayApplyPayScheduleInfoUSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOModifyInvoiceInterfacePrepayApplyPayScheduleInfoUSQL(){
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
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppay_aply_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOModifyInvoiceInterfacePrepayApplyPayScheduleInfoUSQL").append("\n"); 
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
		query.append("   UPDATE  SAP_PAY_SKD" ).append("\n"); 
		query.append("   SET     PAY_RMN_AMT = PAY_RMN_AMT - @[ppay_aply_amt]" ).append("\n"); 
		query.append("         , PAY_STS_FLG = DECODE(PAY_RMN_AMT - @[ppay_aply_amt], 0, 'Y', PAY_GRS_AMT, 'N', 'P')" ).append("\n"); 
		query.append("         , UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("         , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("   WHERE   INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("   AND     PAY_SKD_NO = 1" ).append("\n"); 
		query.append("   AND     PAY_RMN_AMT <> 0" ).append("\n"); 

	}
}