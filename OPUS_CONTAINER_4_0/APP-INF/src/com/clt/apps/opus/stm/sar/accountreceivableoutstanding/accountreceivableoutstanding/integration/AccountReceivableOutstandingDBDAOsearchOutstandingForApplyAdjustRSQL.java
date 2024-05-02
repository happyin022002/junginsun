/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOsearchOutstandingForApplyAdjustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.27 
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

public class AccountReceivableOutstandingDBDAOsearchOutstandingForApplyAdjustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Apply 및 Adjust 대상 OTS 정보 조회
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOsearchOutstandingForApplyAdjustRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOsearchOutstandingForApplyAdjustRSQL").append("\n"); 
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
		query.append("SELECT SOH.IF_NO" ).append("\n"); 
		query.append("	   , SOH.RHQ_CD" ).append("\n"); 
		query.append("	   , SOH.OTS_OFC_CD" ).append("\n"); 
		query.append("       , SOH.BL_NO" ).append("\n"); 
		query.append("       , SOH.INV_NO" ).append("\n"); 
		query.append("	   , SOH.OTS_HIS_SEQ" ).append("\n"); 
		query.append("       , SOH.CURR_CD" ).append("\n"); 
		query.append("       , SOH.OTS_SRC_CD" ).append("\n"); 
		query.append("	   , SOH.INV_OFC_CD" ).append("\n"); 
		query.append("	   , SOH.SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("	   , SOH.SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("	   , SOH.BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("	   , SOH.BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("	   , SOH.VSL_CD" ).append("\n"); 
		query.append("	   , SOH.SKD_VOY_NO" ).append("\n"); 
		query.append("	   , SOH.DIR_CD" ).append("\n"); 
		query.append("	   , SOH.SVC_SCP_CD" ).append("\n"); 
		query.append("	   , SOH.XCH_RT_TP_CD" ).append("\n"); 
		query.append("	   , SOH.LOCL_XCH_RT" ).append("\n"); 
		query.append("	   , SOH.USD_XCH_RT" ).append("\n"); 
		query.append("	   , SOH.BKG_IO_BND_CD" ).append("\n"); 
		query.append("	   , SOH.XCH_RT_DT" ).append("\n"); 
		query.append("	   , SOH.POL_CD" ).append("\n"); 
		query.append("	   , SOH.POD_CD" ).append("\n"); 
		query.append("       , SOC.CHG_TP_CD" ).append("\n"); 
		query.append("       , SOC.BAL_AMT CHG_BAL_AMT" ).append("\n"); 
		query.append("       , SOC.GL_DT" ).append("\n"); 
		query.append("       , SOC.TJ_SRC_NM" ).append("\n"); 
		query.append("       , SLD.DP_SEQ" ).append("\n"); 
		query.append("FROM SAR_OTS_CHG SOC," ).append("\n"); 
		query.append("     SAR_OTS_HIS SOH," ).append("\n"); 
		query.append("     SCO_LU_DTL SLD" ).append("\n"); 
		query.append("WHERE SOC.OTS_HIS_SEQ = SOH.OTS_HIS_SEQ" ).append("\n"); 
		query.append("AND SOC.TJ_SRC_NM = SLD.LU_CD" ).append("\n"); 
		query.append("AND SLD.LU_TP_CD = 'ACCT CTNT3'" ).append("\n"); 
		query.append("AND SOH.OTS_HIS_TP_CD = 'OTS'                   " ).append("\n"); 
		query.append("AND SOC.BAL_AMT <> 0    " ).append("\n"); 
		query.append("#if(${asa_flg} != '') " ).append("\n"); 
		query.append("	AND SOH.OTS_OFC_CD = @[ots_ofc_cd] " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND SOH.INV_OFC_CD = @[ots_ofc_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND SOH.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND SOH.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND SOC.BL_CURR_CD = @[bl_curr_cd] " ).append("\n"); 
		query.append("AND SOC.CHG_TP_CD = @[chg_tp_cd]" ).append("\n"); 
		query.append("ORDER BY SLD.DP_SEQ, " ).append("\n"); 
		query.append("         SOH.OTS_HIS_SEQ DESC" ).append("\n"); 

	}
}