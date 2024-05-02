/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOsearchArOtsDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.21 
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

public class AccountReceivableAdjustDBDAOsearchArOtsDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search AR OTS Detail
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOsearchArOtsDtlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOsearchArOtsDtlListRSQL").append("\n"); 
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
		query.append("    SELECT    RHQ_CD" ).append("\n"); 
		query.append("              , OTS_OFC_CD" ).append("\n"); 
		query.append("              , BL_NO" ).append("\n"); 
		query.append("              , INV_NO" ).append("\n"); 
		query.append("              , BL_CURR_CD" ).append("\n"); 
		query.append("              , INV_AMT" ).append("\n"); 
		query.append("              , INV_UPD_DT" ).append("\n"); 
		query.append("              , RCT_AMT" ).append("\n"); 
		query.append("              , RCT_UPD_DT" ).append("\n"); 
		query.append("              , ADJ_AMT" ).append("\n"); 
		query.append("              , ADJ_UPD_DT" ).append("\n"); 
		query.append("              , BAL_AMT" ).append("\n"); 
		query.append("              , BAL_UPD_DT" ).append("\n"); 
		query.append("              , WRTF_AMT" ).append("\n"); 
		query.append("              , WRTF_UPD_DT" ).append("\n"); 
		query.append("              , LOCL_XCH_RT" ).append("\n"); 
		query.append("              , USD_XCH_RT" ).append("\n"); 
		query.append("              , BAL_LOCL_AMT" ).append("\n"); 
		query.append("              , BAL_USD_AMT" ).append("\n"); 
		query.append("              , CRE_USR_ID" ).append("\n"); 
		query.append("              , CRE_DT" ).append("\n"); 
		query.append("              , UPD_USR_ID" ).append("\n"); 
		query.append("              , UPD_DT" ).append("\n"); 
		query.append("              , CHG_TP_CD" ).append("\n"); 
		query.append("    FROM      SAR_OTS_DTL" ).append("\n"); 
		query.append("    WHERE     1 = 1" ).append("\n"); 
		query.append("    #if(${rhq_cd} != '')" ).append("\n"); 
		query.append("      AND     RHQ_CD = @[rhq_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${ots_ofc_cd} != '')" ).append("\n"); 
		query.append("      AND     OTS_OFC_CD = @[ots_ofc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${bl_no} != '')" ).append("\n"); 
		query.append("	  AND     BL_NO = @[bl_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${inv_no} != '')" ).append("\n"); 
		query.append("	  AND     INV_NO = @[inv_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${bl_curr_cd} != '')" ).append("\n"); 
		query.append("	  AND     BL_CURR_CD = @[bl_curr_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${chg_tp_cd} != '')" ).append("\n"); 
		query.append("	  AND     CHG_TP_CD = @[chg_tp_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}