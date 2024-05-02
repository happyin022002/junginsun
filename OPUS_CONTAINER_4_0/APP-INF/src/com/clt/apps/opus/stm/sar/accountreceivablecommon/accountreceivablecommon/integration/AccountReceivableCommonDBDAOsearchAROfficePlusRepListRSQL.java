/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchAROfficePlusRepListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.05 
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

public class AccountReceivableCommonDBDAOsearchAROfficePlusRepListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAROfficePlusRepList
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchAROfficePlusRepListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_brnc_agn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOsearchAROfficePlusRepListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(SOI.OTS_CD, 'COU', SOI.REP_OTS_OFC_CD, SOI.OFC_CD) AS OTS_OFC_CD" ).append("\n"); 
		query.append("     , DECODE(ISO.OTS_SMRY_CD, '', DECODE(SOI.OTS_CATE_CD, '', 'BL', SOI.OTS_CATE_CD), DECODE(ISO.OTS_SMRY_CD, 'CLR', 'BL', ISO.OTS_SMRY_CD)) AS OTS_SMRY_CD" ).append("\n"); 
		query.append("     , ARMO.AR_HD_QTR_OFC_CD RHQ_CD" ).append("\n"); 
		query.append("     , SOI.REP_OTS_OFC_CD" ).append("\n"); 
		query.append("     , SOI.OTS_CD " ).append("\n"); 
		query.append("     , SOI.OFC_BRNC_AGN_TP_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION ARMO," ).append("\n"); 
		query.append("     INV_AR_STUP_OFC ISO," ).append("\n"); 
		query.append("     SCO_OFC_INFO  SOI," ).append("\n"); 
		query.append("     MDM_CURRENCY MC" ).append("\n"); 
		query.append("WHERE ARMO.OFC_CD = ISO.AR_OFC_CD" ).append("\n"); 
		query.append("AND   ARMO.OFC_CD = SOI.OFC_CD" ).append("\n"); 
		query.append("AND   ARMO.AR_CURR_CD = MC.CURR_CD" ).append("\n"); 
		query.append("#if (${ofc_entr_lvl_cd} == 'BA' || ${ofc_entr_lvl_cd} == '') " ).append("\n"); 
		query.append("    AND ARMO.OFC_CD = @[ar_ofc_cd]   " ).append("\n"); 
		query.append("#elseif (${ofc_entr_lvl_cd} == 'HO' || ${ofc_entr_lvl_cd} =='HQ')" ).append("\n"); 
		query.append("    AND EXISTS ( SELECT 'X' " ).append("\n"); 
		query.append("                 FROM   MDM_ORGANIZATION MO " ).append("\n"); 
		query.append("                 WHERE  MO.OFC_CD = @[ar_ofc_cd] " ).append("\n"); 
		query.append("			     AND    MO.AR_HD_QTR_OFC_CD = ARMO.AR_HD_QTR_OFC_CD ) " ).append("\n"); 
		query.append("    AND EXISTS ( SELECT 'X' " ).append("\n"); 
		query.append("                 FROM   MDM_ORGANIZATION MO " ).append("\n"); 
		query.append("                 WHERE  ARMO.OFC_CD = MO.AR_OFC_CD )" ).append("\n"); 
		query.append("#elseif (${ofc_entr_lvl_cd} == 'ALL')    " ).append("\n"); 
		query.append("	AND EXISTS ( SELECT 'X' " ).append("\n"); 
		query.append("                 FROM   MDM_ORGANIZATION MO " ).append("\n"); 
		query.append("                 WHERE  ARMO.OFC_CD = MO.AR_OFC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ofc_brnc_agn_tp_cd} != '')" ).append("\n"); 
		query.append("	AND SOI.OFC_BRNC_AGN_TP_CD = @[ofc_brnc_agn_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("     DECODE(SOI.OTS_CD, 'COU', SOI.REP_OTS_OFC_CD, SOI.OFC_CD)" ).append("\n"); 
		query.append("   , DECODE(ISO.OTS_SMRY_CD, '', DECODE(SOI.OTS_CATE_CD, '', 'BL', SOI.OTS_CATE_CD), DECODE(ISO.OTS_SMRY_CD, 'CLR', 'BL', ISO.OTS_SMRY_CD)) " ).append("\n"); 
		query.append("   , ARMO.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("   , SOI.REP_OTS_OFC_CD" ).append("\n"); 
		query.append("   , SOI.OTS_CD" ).append("\n"); 
		query.append("   , SOI.OFC_BRNC_AGN_TP_CD " ).append("\n"); 
		query.append("ORDER BY DECODE(SOI.OTS_CD, 'COU', SOI.REP_OTS_OFC_CD, SOI.OFC_CD)" ).append("\n"); 

	}
}