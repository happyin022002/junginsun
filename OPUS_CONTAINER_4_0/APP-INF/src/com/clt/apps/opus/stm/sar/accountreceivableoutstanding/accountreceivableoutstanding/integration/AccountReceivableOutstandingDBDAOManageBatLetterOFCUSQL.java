/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOManageBatLetterOFCUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOManageBatLetterOFCUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Batch running 시, E 로 update
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOManageBatLetterOFCUSQL(){
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
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOManageBatLetterOFCUSQL").append("\n"); 
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
		query.append("  AND BAT_PGM_NO = 'STM_SAR_B1005'" ).append("\n"); 

	}
}