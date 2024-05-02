/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : WorkOrderInquiryDBDAOsearchSvcOrdHisListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderInquiryDBDAOsearchSvcOrdHisListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Service Order History
	  * </pre>
	  */
	public WorkOrderInquiryDBDAOsearchSvcOrdHisListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_no_a",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_knt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.integration").append("\n"); 
		query.append("FileName : WorkOrderInquiryDBDAOsearchSvcOrdHisListRSQL").append("\n"); 
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
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("SELECT RANK() OVER(PARTITION BY SOH.TRSP_SO_OFC_CTY_CD, SOH.TRSP_SO_SEQ ORDER BY SOH.TRSP_SO_OFC_CTY_CD, SOH.TRSP_SO_SEQ, SOH.TRSP_HIS_SEQ DESC) WO_ISS_KNT_RANK," ).append("\n"); 
		query.append("       WOH.TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("       WOH.TRSP_WO_SEQ," ).append("\n"); 
		query.append("       WOH.TRSP_WO_OFC_CTY_CD||WOH.TRSP_WO_SEQ AS TRSP_WO_NO," ).append("\n"); 
		query.append("       SOH.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("       SOH.TRSP_SO_SEQ," ).append("\n"); 
		query.append("       SOH.TRSP_SO_OFC_CTY_CD||SOH.TRSP_SO_SEQ AS TRSP_SO_NO," ).append("\n"); 
		query.append("       SO.CRE_OFC_CD," ).append("\n"); 
		query.append("       SO.EQ_NO," ).append("\n"); 
		query.append("       TO_CHAR ( SO.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') AS LOCL_CRE_DT," ).append("\n"); 
		query.append("       SO.DELT_FLG," ).append("\n"); 
		query.append("       SOH.UPD_USR_ID," ).append("\n"); 
		query.append("       (CASE WHEN SOH.RQST_SRC_SYS_CD = 'SPP' THEN 'SPP' ELSE (SELECT USR_NM FROM COM_USER D WHERE 1=1 AND USR_ID = SOH.UPD_USR_ID AND ROWNUM = 1) END) AS UPD_USR_NM," ).append("\n"); 
		query.append("       SO.TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("       WOH.WO_ISS_KNT," ).append("\n"); 
		query.append("       SOH.RQST_SRC_SYS_CD," ).append("\n"); 
		query.append("       SOH.TRSP_RJCT_RSN_CD," ).append("\n"); 
		query.append("       (CASE WHEN SOH.RQST_SRC_SYS_CD = 'SPP' AND SOH.TRSP_RJCT_RSN_CD = 'R' THEN (SELECT WO_RJCT_RSN FROM TRS_TRSP_WRK_ORD_RJCT_HIS WHERE 1=1 AND TRSP_SO_OFC_CTY_CD = SOH.TRSP_SO_OFC_CTY_CD AND TRSP_SO_SEQ = SOH.TRSP_SO_SEQ AND ROWNUM = 1) ELSE COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00957',SOH.TRSP_RJCT_RSN_CD) END) TRSP_RJCT_RSN_NM," ).append("\n"); 
		query.append("--       COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00957',SOH.TRSP_RJCT_RSN_CD) AS TRSP_RJCT_RSN_NM," ).append("\n"); 
		query.append("       DECODE(SO.DTN_USE_FLG, 'Y', '1', '0') DTN_USE_FLG," ).append("\n"); 
		query.append("       DECODE(SO.WO_BL_NO_ISS_FLG, 'Y', '1', '0') WO_BL_NO_ISS_FLG," ).append("\n"); 
		query.append("       (SELECT BKG.BLCK_STWG_CD FROM BKG_BOOKING BKG WHERE BKG.BKG_NO = NVL(SO.BKG_NO,SO.BL_NO)) AS BLCK_STWG" ).append("\n"); 
		query.append("  FROM TRS_TRSP_WRK_ORD_HIS WOH," ).append("\n"); 
		query.append("       TRS_TRSP_SO_HIS SOH," ).append("\n"); 
		query.append("       TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND WOH.TRSP_WO_OFC_CTY_CD = SUBSTR(@[wo_no_a], 1, 3)" ).append("\n"); 
		query.append("   AND WOH.TRSP_WO_SEQ = SUBSTR(@[wo_no_a], 4)" ).append("\n"); 
		query.append("   AND WOH.WO_ISS_KNT <= @[wo_iss_knt]" ).append("\n"); 
		query.append("   AND WOH.TRSP_WO_SEQ = SOH.TRSP_WO_SEQ" ).append("\n"); 
		query.append("   AND WOH.TRSP_WO_OFC_CTY_CD = SOH.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND SOH.TRSP_SO_SEQ = SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("   AND SOH.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND WOH.WO_ISS_KNT = NVL(SOH.WO_ISS_KNT, 1)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND WO_ISS_KNT_RANK = 1" ).append("\n"); 
		query.append(" ORDER BY TRSP_WO_OFC_CTY_CD, TRSP_WO_SEQ, TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ" ).append("\n"); 

	}
}