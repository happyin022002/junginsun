/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOaddAdjustReceiptNoLocalCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.30 
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

public class AccountReceivableCommonDBDAOaddAdjustReceiptNoLocalCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addAdjustReceiptNoLocal
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOaddAdjustReceiptNoLocalCSQL(){
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aj_tj_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOaddAdjustReceiptNoLocalCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_TP_NO " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" AR_TJ_TP_CD " ).append("\n"); 
		query.append(",TP_OFC_CD " ).append("\n"); 
		query.append(",TP_CRE_DT " ).append("\n"); 
		query.append(",TP_SEQ " ).append("\n"); 
		query.append(",CRE_USR_ID " ).append("\n"); 
		query.append(",CRE_DT " ).append("\n"); 
		query.append(",UPD_USR_ID " ).append("\n"); 
		query.append(",UPD_DT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("   @[aj_tj_tp_cd], " ).append("\n"); 
		query.append("   @[ofc_cd]," ).append("\n"); 
		query.append("   '99999999'," ).append("\n"); 
		query.append("   NVL((SELECT MAX(TP_SEQ) FROM SAR_TP_NO WHERE AR_TJ_TP_CD = @[aj_tj_tp_cd] AND TP_OFC_CD = @[ofc_cd] GROUP BY AR_TJ_TP_CD,TP_OFC_CD),0) + 1," ).append("\n"); 
		query.append("   @[usr_id]," ).append("\n"); 
		query.append("   SYSDATE, " ).append("\n"); 
		query.append("   @[usr_id], " ).append("\n"); 
		query.append("   SYSDATE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}