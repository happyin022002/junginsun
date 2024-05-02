/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOModifyInvoiceSlipPrintFlagInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.24 
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

public class AccountPayableInvoiceDBDAOModifyInvoiceSlipPrintFlagInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyInvoiceSlipPrintFlagInfo
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOModifyInvoiceSlipPrintFlagInfoUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOModifyInvoiceSlipPrintFlagInfoUSQL").append("\n"); 
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
		query.append("SET     SIH.ATTR_CTNT12 = DECODE(SIH.ATTR_CTNT15, NULL, TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS')||':'||@[usr_id], SIH.ATTR_CTNT12)" ).append("\n"); 
		query.append("	  , SIH.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	  , SIH.UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("WHERE   SIH.INV_SEQ = @[inv_seq]" ).append("\n"); 

	}
}