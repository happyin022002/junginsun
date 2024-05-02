/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOSearchOffSapInvNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.25 
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

public class AccountReceivableAdjustDBDAOSearchOffSapInvNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Setting INV NO of Offset, INV TYPE LOOKUP CODE
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOSearchOffSapInvNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("off_ap_hdr_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("off_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOSearchOffSapInvNoListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    CASE WHEN @[off_ap_hdr_amt] >= 0 THEN 'STANDARD'" ).append("\n"); 
		query.append("         WHEN @[off_ap_hdr_amt] < 0 THEN 'CREDIT'" ).append("\n"); 
		query.append("    END AS INV_TP_LU_CD," ).append("\n"); 
		query.append("    CASE WHEN @[off_ap_hdr_amt] >= 0 THEN" ).append("\n"); 
		query.append("            OPUSADM.SAP_GEN_INV_NUM_FNC ('02', 'S', @[usr_id], @[off_ofc_cd])" ).append("\n"); 
		query.append("         WHEN @[off_ap_hdr_amt] < 0 THEN" ).append("\n"); 
		query.append("            OPUSADM.SAP_GEN_INV_NUM_FNC ('02', 'C', @[usr_id], @[off_ofc_cd])" ).append("\n"); 
		query.append("    END AS INV_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    DUAL" ).append("\n"); 

	}
}