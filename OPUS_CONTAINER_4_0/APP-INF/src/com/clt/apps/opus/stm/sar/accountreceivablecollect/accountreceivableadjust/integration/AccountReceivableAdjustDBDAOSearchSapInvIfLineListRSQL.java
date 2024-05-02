/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOSearchSapInvIfLineListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.05 
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

public class AccountReceivableAdjustDBDAOSearchSapInvIfLineListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Retrieve AP INTERFACE Line Info
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOSearchSapInvIfLineListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOSearchSapInvIfLineListRSQL").append("\n"); 
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
		query.append("#if(${sys_tp_cd} == 'ADJ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       1 AS INV_LINE_NO," ).append("\n"); 
		query.append("       'ITEM' AS LINE_TP_LU_CD," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       #if(${rvs_flg} == 'N')" ).append("\n"); 
		query.append("            SUM(SAD.ADJ_CRS_CURR_AMT) + MAX(SAH.GAIN_AND_LSS_AMT) AS DTRB_AMT," ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("            (-1) * (SUM(SAD.ADJ_CRS_CURR_AMT) + MAX(SAH.GAIN_AND_LSS_AMT)) AS DTRB_AMT," ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       @[ap_gl_dt] AS ACCTG_DT," ).append("\n"); 
		query.append("       SAH.AP_RMK AS DTRB_DESC," ).append("\n"); 
		query.append("       NULL AS DTRB_VAT_CD," ).append("\n"); 
		query.append("       'A' AS FNL_MTCH_STS_CD," ).append("\n"); 
		query.append("       MO.LOC_CD AS ATTR_CTNT3," ).append("\n"); 
		query.append("       'AR' AS IF_SRC_NM," ).append("\n"); 
		query.append("       SAH.AP_OFC_CD," ).append("\n"); 
		query.append("       '01' AS CO_CD," ).append("\n"); 
		query.append("       MO.FINC_RGN_CD AS CNT_CD," ).append("\n"); 
		query.append("       MO.AP_CTR_CD AS CTR_CD," ).append("\n"); 
		query.append("       DECODE(NVL(MV.INTER_CO_FLG,'N'), 'Y',NVL(MV.SUBS_CO_CD,'00'),'00') AS INTER_CO_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #if(${rvs_flg} == 'N')" ).append("\n"); 
		query.append("            SUM(SAD.ADJ_CRS_CURR_AMT) AS ADJ_CRS_CURR_AMT, " ).append("\n"); 
		query.append("            (-1) * MAX(SAH.GAIN_AND_LSS_AMT) AS GAIN_AND_LSS_AMT" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("            (-1) * SUM(SAD.ADJ_CRS_CURR_AMT) AS ADJ_CRS_CURR_AMT," ).append("\n"); 
		query.append("            MAX(SAH.GAIN_AND_LSS_AMT) AS GAIN_AND_LSS_AMT" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("FROM SAR_ADJ_HDR SAH, " ).append("\n"); 
		query.append("     SAR_ADJ_DTL SAD," ).append("\n"); 
		query.append("     MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("     MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE SAH.OTS_ADJ_SEQ = SAD.OTS_ADJ_SEQ" ).append("\n"); 
		query.append("AND SAH.ADJ_NO = @[adj_no]" ).append("\n"); 
		query.append("AND MO.OFC_CD = SAH.AP_OFC_CD" ).append("\n"); 
		query.append("AND MV.VNDR_SEQ = SAH.VNDR_NO " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY SAH.ADJ_NO,SAH.AP_RMK," ).append("\n"); 
		query.append("       MO.LOC_CD," ).append("\n"); 
		query.append("       SAH.AP_OFC_CD," ).append("\n"); 
		query.append("       MO.FINC_RGN_CD," ).append("\n"); 
		query.append("       MO.AP_CTR_CD," ).append("\n"); 
		query.append("       DECODE(NVL(MV.INTER_CO_FLG,'N'), 'Y',NVL(MV.SUBS_CO_CD,'00'),'00')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${sys_tp_cd} == 'OFF')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       1 AS INV_LINE_NO," ).append("\n"); 
		query.append("       'ITEM' AS LINE_TP_LU_CD," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       #if(${rvs_flg} == 'N')" ).append("\n"); 
		query.append("            -1 * SUM(SOM.OFFST_XCH_AMT) AS DTRB_AMT," ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("            SUM(SOM.OFFST_XCH_AMT) AS DTRB_AMT," ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       @[ap_gl_dt] AS ACCTG_DT," ).append("\n"); 
		query.append("       SOM.AP_RMK AS DTRB_DESC," ).append("\n"); 
		query.append("       NULL AS DTRB_VAT_CD," ).append("\n"); 
		query.append("       'A' AS FNL_MTCH_STS_CD," ).append("\n"); 
		query.append("       MO.LOC_CD AS ATTR_CTNT3," ).append("\n"); 
		query.append("       'AR' AS IF_SRC_NM," ).append("\n"); 
		query.append("       SOM.OFC_CD," ).append("\n"); 
		query.append("       '01' AS CO_CD," ).append("\n"); 
		query.append("       MO.FINC_RGN_CD AS CNT_CD," ).append("\n"); 
		query.append("       MO.AP_CTR_CD AS CTR_CD," ).append("\n"); 
		query.append("       DECODE(NVL(MV.INTER_CO_FLG,'N'), 'Y',NVL(MV.SUBS_CO_CD,'00'),'00') AS INTER_CO_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       #if(${rvs_flg} == 'N')" ).append("\n"); 
		query.append("            -1 * SUM(SOM.OFFST_XCH_AMT) AS ADJ_CRS_CURR_AMT" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("            SUM(SOM.OFFST_XCH_AMT) AS ADJ_CRS_CURR_AMT" ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append("FROM SAR_OFFST_MST SOM, " ).append("\n"); 
		query.append("     MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("     MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE SOM.AR_OFFST_NO = @[adj_no]" ).append("\n"); 
		query.append("AND MO.OFC_CD = SOM.OFC_CD" ).append("\n"); 
		query.append("AND MV.VNDR_SEQ = SOM.VNDR_NO " ).append("\n"); 
		query.append("AND SOM.OFFST_TP_CD = 'AP'" ).append("\n"); 
		query.append("AND MV.VNDR_SEQ = @[vndr_no]" ).append("\n"); 
		query.append("GROUP BY SOM.AR_OFFST_NO,SOM.AP_RMK," ).append("\n"); 
		query.append("       MO.LOC_CD," ).append("\n"); 
		query.append("       SOM.OFC_CD," ).append("\n"); 
		query.append("       MO.FINC_RGN_CD," ).append("\n"); 
		query.append("       MO.AP_CTR_CD," ).append("\n"); 
		query.append("       DECODE(NVL(MV.INTER_CO_FLG,'N'), 'Y',NVL(MV.SUBS_CO_CD,'00'),'00')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}