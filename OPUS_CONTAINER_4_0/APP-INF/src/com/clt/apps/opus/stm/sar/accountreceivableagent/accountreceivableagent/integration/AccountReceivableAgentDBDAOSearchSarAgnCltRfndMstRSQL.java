/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOSearchSarAgnCltRfndMstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAgentDBDAOSearchSarAgnCltRfndMstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select SAR_AGN_CLT_RFND_MST
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOSearchSarAgnCltRfndMstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("due_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asa_clt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration ").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOSearchSarAgnCltRfndMstRSQL").append("\n"); 
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
		query.append("    SELECT    ASA_NO" ).append("\n"); 
		query.append("              , BL_NO" ).append("\n"); 
		query.append("              , CHG_TP_CD" ).append("\n"); 
		query.append("              , ASA_CLT_SEQ" ).append("\n"); 
		query.append("              , AR_OFC_CD" ).append("\n"); 
		query.append("              , VVD_CD" ).append("\n"); 
		query.append("              , PORT_CD" ).append("\n"); 
		query.append("              , DUE_DT" ).append("\n"); 
		query.append("              , ASA_TP_CD" ).append("\n"); 
		query.append("              , USD_AMT" ).append("\n"); 
		query.append("              , ASA_XCH_RT1" ).append("\n"); 
		query.append("              , EQV_LOCL_AMT" ).append("\n"); 
		query.append("              , LOCL_AMT" ).append("\n"); 
		query.append("              , ASA_XCH_RT2" ).append("\n"); 
		query.append("              , CHG_USD_AMT" ).append("\n"); 
		query.append("              , TTL_AMT" ).append("\n"); 
		query.append("              , ASA_RMK" ).append("\n"); 
		query.append("              , EFF_DT" ).append("\n"); 
		query.append("              , AGN_CD" ).append("\n"); 
		query.append("              , SVC_SCP_CD" ).append("\n"); 
		query.append("              , IB_OB_CD" ).append("\n"); 
		query.append("              , ASA_CURR_CD" ).append("\n"); 
		query.append("              , SAIL_ARR_DT" ).append("\n"); 
		query.append("              , GL_YRMON" ).append("\n"); 
		query.append("              , LOCL_CURR_CD" ).append("\n"); 
		query.append("              , N3RD_CURR_CD1" ).append("\n"); 
		query.append("              , N3RD_AMT1" ).append("\n"); 
		query.append("              , N3RD_XCH_RT1" ).append("\n"); 
		query.append("              , N3RD_LOCL_AMT1" ).append("\n"); 
		query.append("              , N3RD_CURR_CD2" ).append("\n"); 
		query.append("              , N3RD_AMT2" ).append("\n"); 
		query.append("              , N3RD_XCH_RT2" ).append("\n"); 
		query.append("              , N3RD_LOCL_AMT2" ).append("\n"); 
		query.append("              , N3RD_CURR_CD3" ).append("\n"); 
		query.append("              , N3RD_AMT3" ).append("\n"); 
		query.append("              , N3RD_XCH_RT3" ).append("\n"); 
		query.append("              , N3RD_LOCL_AMT3" ).append("\n"); 
		query.append("              , N3RD_CURR_CD4" ).append("\n"); 
		query.append("              , N3RD_AMT4" ).append("\n"); 
		query.append("              , N3RD_XCH_RT4" ).append("\n"); 
		query.append("              , N3RD_LOCL_AMT4" ).append("\n"); 
		query.append("              , EQV_LOCL_AMT2" ).append("\n"); 
		query.append("              , APRO_FLG" ).append("\n"); 
		query.append("              , CRE_USR_ID" ).append("\n"); 
		query.append("              , CRE_DT" ).append("\n"); 
		query.append("              , UPD_USR_ID" ).append("\n"); 
		query.append("              , UPD_DT" ).append("\n"); 
		query.append("    FROM      SAR_AGN_CLT_RFND_MST" ).append("\n"); 
		query.append("    WHERE     1 = 1" ).append("\n"); 
		query.append("           #if( ${asa_no} != '')" ).append("\n"); 
		query.append("              AND ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${bl_no} != '')" ).append("\n"); 
		query.append("              AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${chg_tp_cd} != '')" ).append("\n"); 
		query.append("              AND CHG_TP_CD = @[chg_tp_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_clt_seq} != '')" ).append("\n"); 
		query.append("              AND ASA_CLT_SEQ = @[asa_clt_seq]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${ar_ofc_cd} != '')" ).append("\n"); 
		query.append("              AND AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${vvd_cd} != '')" ).append("\n"); 
		query.append("              AND VVD_CD = @[vvd_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${port_cd} != '')" ).append("\n"); 
		query.append("              AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${due_dt} != '')" ).append("\n"); 
		query.append("              AND DUE_DT = @[due_dt]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if( ${asa_tp_cd} != '')" ).append("\n"); 
		query.append("              AND ASA_TP_CD = @[asa_tp_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 

	}
}