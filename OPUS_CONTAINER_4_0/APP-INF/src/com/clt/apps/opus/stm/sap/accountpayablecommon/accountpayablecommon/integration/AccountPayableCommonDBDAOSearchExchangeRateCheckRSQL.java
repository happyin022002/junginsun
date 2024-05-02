/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchExchangeRateCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchExchangeRateCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * G/L Date 항목과 Currency 항목 입력이 필수적으로 입력된 상태에서 G/L Date가 Period Check상 이상이 없고, Currency 항목 Non KRW 인 경우에 환율 정보값 조회
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchExchangeRateCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value0",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("value2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchExchangeRateCheckRSQL").append("\n"); 
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
		query.append("SELECT  GDXR.ACCT_XCH_RT_DT AS VALUE0" ).append("\n"); 
		query.append("      , GDXR.ACCT_XCH_RT_LVL AS VALUE1" ).append("\n"); 
		query.append("      , GDXR.CONV_XCH_RT AS VALUE2" ).append("\n"); 
		query.append("      ,(SELECT DP_PRCS_KNT FROM MDM_CURRENCY MC WHERE MC.CURR_CD = @[value1] AND DELT_FLG = 'N' AND ROWNUM=1) AS VALUE3" ).append("\n"); 
		query.append("FROM    GL_DLY_XCH_RT GDXR" ).append("\n"); 
		query.append("WHERE   GDXR.ACCT_XCH_RT_DT = REPLACE(@[value0], '-', '') --SAP_INV_HDR.INV_XCH_DT" ).append("\n"); 
		query.append("AND     GDXR.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("AND     GDXR.FM_CURR_CD = @[value1] -- SAP_INV_HDR.INV_CURR_CD" ).append("\n"); 
		query.append("AND     GDXR.TO_CURR_CD = @[value2]  -- Functional Currency" ).append("\n"); 

	}
}