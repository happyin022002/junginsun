/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchPopPayBatchNameListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.26 
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

public class AccountPayableCommonDBDAOSearchPopPayBatchNameListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조건을 기준으로 등록되어 있는 Payment Batch Name 정보 조회, 일괄 지불한 내역 파악
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchPopPayBatchNameListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edate",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sdate",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchPopPayBatchNameListRSQL").append("\n"); 
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
		query.append("SELECT A.PAY_BAT_NM," ).append("\n"); 
		query.append("       A.PAY_DT," ).append("\n"); 
		query.append("       A.PAY_STS_CD" ).append("\n"); 
		query.append("  FROM SAP_INV_SEL_CRTE A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${pay_bat_nm} != '')" ).append("\n"); 
		query.append("   AND UPPER(A.PAY_BAT_NM) like '%' || UPPER(@[pay_bat_nm]) || '%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${sdate} != '')" ).append("\n"); 
		query.append("   AND A.PAY_DT >= TO_DATE( NVL( @[sdate], '1900-01-01'), 'YYYY-MM-DD' )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${edate} != '')" ).append("\n"); 
		query.append("   AND A.PAY_DT <  TO_DATE( NVL( @[edate], '9999-12-31'), 'YYYY-MM-DD' )+0.99999" ).append("\n"); 
		query.append("#end " ).append("\n"); 

	}
}