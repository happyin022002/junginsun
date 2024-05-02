/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOManageCancelAutoSettlementBatUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOManageCancelAutoSettlementBatUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Batch Running 일 경우, E 로 update 한다.
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOManageCancelAutoSettlementBatUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bat_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOManageCancelAutoSettlementBatUSQL").append("\n"); 
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
		query.append("UPDATE SCO_BAT_HIS" ).append("\n"); 
		query.append("   SET BAT_RSLT_CD = 'E'" ).append("\n"); 
		query.append("     , BAT_RSLT_DESC = 'Batch job is Running.'" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND BAT_SEQ = @[bat_seq]" ).append("\n"); 
		query.append("  AND PGM_SUB_SYS_CD = 'SAR'" ).append("\n"); 
		query.append("  AND BAT_PGM_NO = 'STM_SAR_B3003'" ).append("\n"); 

	}
}