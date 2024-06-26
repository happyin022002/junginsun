/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOmodifyAdjustReceiptNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOmodifyAdjustReceiptNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAR_TP_NO  테이블에 update
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOmodifyAdjustReceiptNoUSQL(){
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
		params.put("l_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aj_tj_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOmodifyAdjustReceiptNoUSQL").append("\n"); 
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
		query.append("UPDATE SAR_TP_NO " ).append("\n"); 
		query.append("SET TP_SEQ = TP_SEQ + 1" ).append("\n"); 
		query.append("	,UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("	,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE  AR_TJ_TP_CD = @[aj_tj_tp_cd]" ).append("\n"); 
		query.append("AND TP_OFC_CD = @[ofc_cd]  " ).append("\n"); 
		query.append("AND TP_CRE_DT = SUBSTR(TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT AR_OFC_CD                                           " ).append("\n"); 
		query.append("						   											FROM MDM_ORGANIZATION                                           " ).append("\n"); 
		query.append("						   											WHERE OFC_CD = @[l_ofc_cd]" ).append("\n"); 
		query.append("																)), 'YYYYMMDD')" ).append("\n"); 
		query.append("						,3,6)" ).append("\n"); 

	}
}