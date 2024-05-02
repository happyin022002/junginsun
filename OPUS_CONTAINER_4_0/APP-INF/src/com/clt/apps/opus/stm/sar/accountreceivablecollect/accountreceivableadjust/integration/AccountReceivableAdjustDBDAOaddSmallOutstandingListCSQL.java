/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOaddSmallOutstandingListCSQL.java
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

public class AccountReceivableAdjustDBDAOaddSmallOutstandingListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addSmallOutstandingList
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOaddSmallOutstandingListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("backendjob_key",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bal_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOaddSmallOutstandingListCSQL").append("\n"); 
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
		query.append("INSERT INTO SAR_AUTO_STL_TMP " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" BAT_SEQ" ).append("\n"); 
		query.append(",ADJ_TP_CD" ).append("\n"); 
		query.append(",CLT_OFC_CD" ).append("\n"); 
		query.append(",RHQ_CD" ).append("\n"); 
		query.append(",OTS_OFC_CD" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",INV_NO" ).append("\n"); 
		query.append(",BL_CURR_CD" ).append("\n"); 
		query.append(",CHG_TP_CD" ).append("\n"); 
		query.append(",BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append(",BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append(",LOCL_VVD_CD" ).append("\n"); 
		query.append(",SAIL_ARR_DT" ).append("\n"); 
		query.append(",OTS_SRC_CD" ).append("\n"); 
		query.append(",OTS_RMK" ).append("\n"); 
		query.append(",BAL_AMT" ).append("\n"); 
		query.append(",BAL_LOCL_AMT" ).append("\n"); 
		query.append(",BAL_USD_AMT" ).append("\n"); 
		query.append(",OTS_TP_CD" ).append("\n"); 
		query.append(",MISC_LSS_LMT_AMT" ).append("\n"); 
		query.append(",MISC_INCM_LMT_AMT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT @[backendjob_key]," ).append("\n"); 
		query.append("       ADJ_TP_CD," ).append("\n"); 
		query.append("       CLT_OFC_CD," ).append("\n"); 
		query.append("       RHQ_CD," ).append("\n"); 
		query.append("       OTS_OFC_CD," ).append("\n"); 
		query.append("       BL_NO," ).append("\n"); 
		query.append("       INV_NO," ).append("\n"); 
		query.append("       BL_CURR_CD," ).append("\n"); 
		query.append("       CHG_TP_CD," ).append("\n"); 
		query.append("       BIL_TO_CUST_CNT_CD," ).append("\n"); 
		query.append("       BIL_TO_CUST_SEQ," ).append("\n"); 
		query.append("       LOCL_VVD_CD," ).append("\n"); 
		query.append("	   SAIL_ARR_DT,	" ).append("\n"); 
		query.append("       OTS_SRC_CD," ).append("\n"); 
		query.append("       OTS_RMK," ).append("\n"); 
		query.append("       OTS_BAL_AMT," ).append("\n"); 
		query.append("       OTS_BAL_LOCL_AMT," ).append("\n"); 
		query.append("       OTS_BAL_USD_AMT," ).append("\n"); 
		query.append("       OTS_TP_CD," ).append("\n"); 
		query.append("       MISC_LSS_LMT_AMT," ).append("\n"); 
		query.append("       MISC_INCM_LMT_AMT," ).append("\n"); 
		query.append("       @[cre_usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("       SYSDATE AS CRE_DT, " ).append("\n"); 
		query.append("       @[cre_usr_id] AS UPD_USR_ID," ).append("\n"); 
		query.append("       SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM  (" ).append("\n"); 
		query.append("            SELECT DECODE(SIGN(SUM(SOD.BAL_LOCL_AMT)),1,'AML','AMI') ADJ_TP_CD," ).append("\n"); 
		query.append("                   SOH.CLT_OFC_CD,  " ).append("\n"); 
		query.append("                   SOH.RHQ_CD," ).append("\n"); 
		query.append("                   SOH.OTS_OFC_CD," ).append("\n"); 
		query.append("                   SOH.BL_NO ," ).append("\n"); 
		query.append("                   SOH.INV_NO , " ).append("\n"); 
		query.append("                   SOD.BL_CURR_CD," ).append("\n"); 
		query.append("                   SOD.CHG_TP_CD," ).append("\n"); 
		query.append("                   SOH.BIL_TO_CUST_CNT_CD," ).append("\n"); 
		query.append("                   SOH.BIL_TO_CUST_SEQ," ).append("\n"); 
		query.append("                   SOH.VSL_CD||SOH.SKD_VOY_NO||SOH.DIR_CD  LOCL_VVD_CD ," ).append("\n"); 
		query.append("                   SOH.SAIL_ARR_DT," ).append("\n"); 
		query.append("                   SOH.OTS_SRC_CD," ).append("\n"); 
		query.append("                   SOH.OTS_RMK," ).append("\n"); 
		query.append("                   SUM(SOD.BAL_AMT) OTS_BAL_AMT," ).append("\n"); 
		query.append("                   SUM(SOD.BAL_LOCL_AMT) OTS_BAL_LOCL_AMT," ).append("\n"); 
		query.append("                   SUM(SOD.BAL_USD_AMT) OTS_BAL_USD_AMT," ).append("\n"); 
		query.append("                   SOH.OTS_TP_CD,         " ).append("\n"); 
		query.append("                   SOI.MISC_LSS_LMT_AMT," ).append("\n"); 
		query.append("                   SOI.MISC_INCM_LMT_AMT       " ).append("\n"); 
		query.append("            FROM SAR_OTS_HDR SOH," ).append("\n"); 
		query.append("                 SAR_OTS_DTL SOD," ).append("\n"); 
		query.append("                 SCO_OFC_INFO  SOI" ).append("\n"); 
		query.append("            WHERE SOH.RHQ_CD = SOD.RHQ_CD" ).append("\n"); 
		query.append("            AND SOH.OTS_OFC_CD = SOD.OTS_OFC_CD" ).append("\n"); 
		query.append("            AND SOH.BL_NO = SOD.BL_NO " ).append("\n"); 
		query.append("            AND SOH.INV_NO = SOD.INV_NO " ).append("\n"); 
		query.append("            AND  SOH.CLT_OFC_CD = SOI.OFC_CD" ).append("\n"); 
		query.append("            AND  SOH.CLT_OFC_CD IN (${multi_ofc_cd})" ).append("\n"); 
		query.append("            AND  SOH.OTS_RT_FLG = 'Y'" ).append("\n"); 
		query.append("            #if (${xcld_ots_tp_cd} != '')" ).append("\n"); 
		query.append("                AND  NVL(SOH.OTS_TP_CD, 'N') NOT IN (${xcld_ots_tp_cd})" ).append("\n"); 
		query.append("            #end  " ).append("\n"); 
		query.append("            #if (${xcld_ots_src_cd} != '')" ).append("\n"); 
		query.append("                AND  SOH.OTS_SRC_CD NOT IN (${xcld_ots_src_cd})" ).append("\n"); 
		query.append("            #end   " ).append("\n"); 
		query.append("            AND  SOH.SAIL_ARR_DT <= REPLACE(@[sail_arr_dt], '-', '')" ).append("\n"); 
		query.append("            AND ((NVL(SOI.OTS_CATE_CD, 'BL') = 'BL' AND SOH.INV_NO = '**********')" ).append("\n"); 
		query.append("                OR (NVL(SOI.OTS_CATE_CD, 'BL') = 'INV' AND SOH.INV_NO <> '**********'))" ).append("\n"); 
		query.append("            AND NOT EXISTS (" ).append("\n"); 
		query.append("                       SELECT 1" ).append("\n"); 
		query.append("                         FROM SAR_OTS_DTL ESOD" ).append("\n"); 
		query.append("                        WHERE SOH.RHQ_CD = SOD.RHQ_CD" ).append("\n"); 
		query.append("                          AND SOH.OTS_OFC_CD = ESOD.OTS_OFC_CD" ).append("\n"); 
		query.append("                          AND SOH.BL_NO = ESOD.BL_NO" ).append("\n"); 
		query.append("                          AND SOH.INV_NO = ESOD.INV_NO" ).append("\n"); 
		query.append("                          AND ESOD.BAL_UPD_DT >= TO_DATE(REPLACE(@[bal_upd_dt], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                          AND ROWNUM = 1)" ).append("\n"); 
		query.append("            GROUP BY " ).append("\n"); 
		query.append("                   SOH.CLT_OFC_CD, " ).append("\n"); 
		query.append("                   SOH.RHQ_CD, " ).append("\n"); 
		query.append("                   SOH.OTS_OFC_CD," ).append("\n"); 
		query.append("                   SOH.BL_NO ," ).append("\n"); 
		query.append("                   SOH.INV_NO , " ).append("\n"); 
		query.append("                   SOD.BL_CURR_CD," ).append("\n"); 
		query.append("                   SOD.CHG_TP_CD," ).append("\n"); 
		query.append("                   SOH.BIL_TO_CUST_CNT_CD," ).append("\n"); 
		query.append("                   SOH.BIL_TO_CUST_SEQ," ).append("\n"); 
		query.append("                   SOH.VSL_CD||SOH.SKD_VOY_NO||SOH.DIR_CD," ).append("\n"); 
		query.append("                   SOH.SAIL_ARR_DT," ).append("\n"); 
		query.append("                   SOH.OTS_SRC_CD," ).append("\n"); 
		query.append("                   SOH.OTS_RMK,                                               " ).append("\n"); 
		query.append("                   SOH.OTS_TP_CD," ).append("\n"); 
		query.append("                   SOI.MISC_LSS_LMT_AMT," ).append("\n"); 
		query.append("                   SOI.MISC_INCM_LMT_AMT      " ).append("\n"); 
		query.append("            HAVING " ).append("\n"); 
		query.append("                  (SUM(SOD.RCT_AMT) <> 0  OR SUM(SOD.ADJ_AMT) <> 0 )" ).append("\n"); 
		query.append("            AND   (SUM(SOD.BAL_USD_AMT) <> 0  OR SUM(SOD.BAL_LOCL_AMT) <> 0 )" ).append("\n"); 
		query.append("        )       " ).append("\n"); 
		query.append("        WHERE  OTS_BAL_USD_AMT BETWEEN MISC_LSS_LMT_AMT AND MISC_INCM_LMT_AMT" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}