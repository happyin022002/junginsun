/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchAccountingExistsCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.14
*@LastModifier : ORKIM
*@LastVersion : 1.0
* 2014.05.14 ORKIM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ORKIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOSearchAccountingExistsCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 조건일자까지의 자료중 지불 Batch 작업중인 자료에 대해서 점검한 후 대상이 존재하는 경우에는 에러 처리
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchAccountingExistsCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("capture_period",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchAccountingExistsCheckRSQL").append("\n"); 
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
		query.append("SELECT  MIN(SSI.PAY_BAT_NM) AS PAY_BAT_NM" ).append("\n"); 
		query.append("      , MIN(SISC.OFC_CD) AS OFC_CD" ).append("\n"); 
		query.append("      , COUNT(SSI.PAY_BAT_NM) AS BATCH_CNT" ).append("\n"); 
		query.append("FROM    SAP_SEL_INV SSI" ).append("\n"); 
		query.append("      , SAP_INV_SEL_CRTE SISC" ).append("\n"); 
		query.append("WHERE   SISC.PAY_BAT_SEQ = SSI.PAY_BAT_SEQ" ).append("\n"); 
		query.append("AND     SISC.PAY_BAT_NM = SSI.PAY_BAT_NM" ).append("\n"); 
		query.append("AND     SISC.PAY_DT <= TO_DATE(@[capture_period],'YYYYMMDD')" ).append("\n"); 

	}
}