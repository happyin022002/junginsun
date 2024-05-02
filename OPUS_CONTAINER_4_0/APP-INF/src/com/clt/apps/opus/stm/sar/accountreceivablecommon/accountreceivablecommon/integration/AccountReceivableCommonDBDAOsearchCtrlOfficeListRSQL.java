/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchCtrlOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.09 
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

public class AccountReceivableCommonDBDAOsearchCtrlOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCtrlOfficeList
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchCtrlOfficeListRSQL(){
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
		query.append("FileName : AccountReceivableCommonDBDAOsearchCtrlOfficeListRSQL").append("\n"); 
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
		query.append("SELECT A.CTRL_OFC_CD" ).append("\n"); 
		query.append(" , MAX(A.OTS_CD) AS OTS_CD" ).append("\n"); 
		query.append(" , MAX(A.CHK_OFC_YN) AS CHK_OFC_YN" ).append("\n"); 
		query.append(" , MAX(DECODE(ISO.OTS_SMRY_CD, '', DECODE(SOI.OTS_CATE_CD, '', 'BL', SOI.OTS_CATE_CD), DECODE(ISO.OTS_SMRY_CD, 'CLR', 'BL', ISO.OTS_SMRY_CD))) AS OTS_SMRY_CD" ).append("\n"); 
		query.append(" , MAX(ARMO.AR_HD_QTR_OFC_CD) RHQ_CD" ).append("\n"); 
		query.append("FROM (SELECT DECODE(NVL(SOI.OTS_CD, 'ARO'), 'COU', SOI.REP_OTS_OFC_CD, ARMO.OFC_CD) CTRL_OFC_CD" ).append("\n"); 
		query.append("         , NVL(SOI.OTS_CD, 'ARO') OTS_CD" ).append("\n"); 
		query.append("         , ARMO.OFC_CD" ).append("\n"); 
		query.append("         , DECODE(ARMO.OFC_CD,@[ar_ofc_cd],'Y','N') CHK_OFC_YN" ).append("\n"); 
		query.append("      FROM MDM_ORGANIZATION ARMO" ).append("\n"); 
		query.append("         , SCO_OFC_INFO SOI" ).append("\n"); 
		query.append("     WHERE ARMO.OFC_CD = SOI.OFC_CD " ).append("\n"); 
		query.append("	   #if (${ofc_entr_lvl_cd} == 'BA' || ${ofc_entr_lvl_cd} == '')" ).append("\n"); 
		query.append("       AND ARMO.OFC_CD = @[ar_ofc_cd] " ).append("\n"); 
		query.append("       #elseif (${ofc_entr_lvl_cd} == 'HO' || ${ofc_entr_lvl_cd} =='HQ')" ).append("\n"); 
		query.append("       AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("              FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("             WHERE MO.OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("               AND MO.AR_HD_QTR_OFC_CD = ARMO.AR_HD_QTR_OFC_CD )" ).append("\n"); 
		query.append("       AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("              FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("             WHERE ARMO.OFC_CD = MO.AR_OFC_CD ) " ).append("\n"); 
		query.append("       #elseif (${ofc_entr_lvl_cd} == 'ALL')" ).append("\n"); 
		query.append("       AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("              FROM MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("             WHERE ARMO.OFC_CD = MO.AR_OFC_CD ) " ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append("       #if(${ofc_brnc_agn_tp_cd} != '')" ).append("\n"); 
		query.append("       AND SOI.OFC_BRNC_AGN_TP_CD = @[ofc_brnc_agn_tp_cd] " ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append("     ) A, " ).append("\n"); 
		query.append("     MDM_ORGANIZATION ARMO,   " ).append("\n"); 
		query.append("     INV_AR_STUP_OFC ISO," ).append("\n"); 
		query.append("     SCO_OFC_INFO  SOI " ).append("\n"); 
		query.append("WHERE A.CTRL_OFC_CD = ARMO.OFC_CD" ).append("\n"); 
		query.append("  AND ARMO.OFC_CD = ISO.AR_OFC_CD(+)" ).append("\n"); 
		query.append("  AND ARMO.OFC_CD = SOI.OFC_CD(+)  " ).append("\n"); 
		query.append("GROUP BY A.CTRL_OFC_CD" ).append("\n"); 

	}
}