/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TotalLossMgtDBDAOsearchTotalLossCLTDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TotalLossMgtDBDAOsearchTotalLossCLTDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTotalLossCLTData
	  * </pre>
	  */
	public TotalLossMgtDBDAOsearchTotalLossCLTDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_ttl_lss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : TotalLossMgtDBDAOsearchTotalLossCLTDataRSQL").append("\n"); 
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
		query.append("         A.TTL_LSS_NO" ).append("\n"); 
		query.append("        ,TO_CHAR(A.TTL_LSS_DTL_SEQ) TTL_LSS_DTL_SEQ" ).append("\n"); 
		query.append("        ,A.TTL_LSS_CLT_SEQ" ).append("\n"); 
		query.append("        , 'Manual' TYPE" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CLT_DT, 'yyyy-mm-dd') CLT_DT" ).append("\n"); 
		query.append("        ,A.TTL_LSS_CLT_TP_CD" ).append("\n"); 
		query.append("        ,A.CLT_OFC_CD" ).append("\n"); 
		query.append("        ,A.CLT_STL_FLG" ).append("\n"); 
		query.append("        ,A.CURR_CD" ).append("\n"); 
		query.append("        ,A.CLT_AMT" ).append("\n"); 
		query.append("        ,A.INV_PAY_MZD_CD" ).append("\n"); 
		query.append("        ,A.BANK_NM" ).append("\n"); 
		query.append("        ,A.BANK_ACCT_NO" ).append("\n"); 
		query.append("        ,A.MNR_BIL_TO_NM" ).append("\n"); 
		query.append("        ,A.CSR_NO" ).append("\n"); 
		query.append("        ,A.AR_CHK_NO" ).append("\n"); 
		query.append("        ,A.CHK_TRNS_NO" ).append("\n"); 
		query.append("        ,A.TTL_LSS_CLT_RMK" ).append("\n"); 
		query.append("        ,A.CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("        ,A.INV_NO" ).append("\n"); 
		query.append("        ,A.RQST_EQ_NO" ).append("\n"); 
		query.append("        ,A.EVID_NO" ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_CLT A" ).append("\n"); 
		query.append("WHERE A.TTL_LSS_NO = @[search_ttl_lss_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("         MTLR.TTL_LSS_NO" ).append("\n"); 
		query.append("        ,'' ASTTL_LSS_DTL_SEQ" ).append("\n"); 
		query.append("        ,1 AS  TTL_LSS_CLT_SEQ" ).append("\n"); 
		query.append("        , 'OTS' TYPE" ).append("\n"); 
		query.append("        ,TO_CHAR(BOD.CLT_LST_UPD_DT, 'yyyy-mm-dd') CLT_DT" ).append("\n"); 
		query.append("        ,'' TTL_LSS_CLT_TP_CD" ).append("\n"); 
		query.append("        ,BOD.OFC_CD  CLT_OFC_CD" ).append("\n"); 
		query.append("        ,'' CLT_STL_FLG" ).append("\n"); 
		query.append("        ,BOD.BL_CURR_CD CURR_CD" ).append("\n"); 
		query.append("        ,BOD.RCT_AMT CLT_AMT" ).append("\n"); 
		query.append("        ,'' INV_PAY_MZD_CD" ).append("\n"); 
		query.append("        ,'' BANK_NM" ).append("\n"); 
		query.append("        ,'' BANK_ACCT_NO" ).append("\n"); 
		query.append("        ,'' MNR_BIL_TO_NM" ).append("\n"); 
		query.append("        ,'' CSR_NO" ).append("\n"); 
		query.append("        ,'' AR_CHK_NO" ).append("\n"); 
		query.append("        ,'' CHK_TRNS_NO" ).append("\n"); 
		query.append("        ,'' TTL_LSS_CLT_RMK" ).append("\n"); 
		query.append("        ,BOD.CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(BOD.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append("        ,BOD.UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(BOD.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("        ,MDD.INV_NO" ).append("\n"); 
		query.append("		,'' RQST_EQ_NO" ).append("\n"); 
		query.append("        ,'' EVID_NO" ).append("\n"); 
		query.append("FROM MNR_TTL_LSS_RQST_DTL MTLR, MNR_DISP_DTL MDD, " ).append("\n"); 
		query.append("     (SELECT BL_NO," ).append("\n"); 
		query.append("            MAX(RCT_UPD_DT) CLT_LST_UPD_DT," ).append("\n"); 
		query.append("            MAX(OTS_OFC_CD) OFC_CD," ).append("\n"); 
		query.append("            MAX(BL_CURR_CD) BL_CURR_CD," ).append("\n"); 
		query.append("            SUM(RCT_AMT) RCT_AMT," ).append("\n"); 
		query.append("            MAX(CRE_USR_ID) CRE_USR_ID," ).append("\n"); 
		query.append("            MAX(CRE_DT) CRE_DT," ).append("\n"); 
		query.append("            MAX(UPD_USR_ID) UPD_USR_ID," ).append("\n"); 
		query.append("            MAX(UPD_DT) UPD_DT" ).append("\n"); 
		query.append("       FROM SAR_OTS_DTL" ).append("\n"); 
		query.append("      GROUP BY BL_NO) BOD" ).append("\n"); 
		query.append("WHERE MTLR.TTL_LSS_NO = @[search_ttl_lss_no]" ).append("\n"); 
		query.append("AND   MTLR.RQST_EQ_NO      = MDD.EQ_NO" ).append("\n"); 
		query.append("AND   MDD.INV_NO      = BOD.BL_NO" ).append("\n"); 
		query.append("AND   MTLR.MNR_INV_TP_CD = 'DS'" ).append("\n"); 
		query.append("GROUP BY MTLR.TTL_LSS_NO" ).append("\n"); 
		query.append("        ,TO_CHAR(BOD.CLT_LST_UPD_DT, 'yyyy-mm-dd')" ).append("\n"); 
		query.append("        ,BOD.OFC_CD" ).append("\n"); 
		query.append("        ,BOD.BL_CURR_CD" ).append("\n"); 
		query.append("        ,BOD.RCT_AMT " ).append("\n"); 
		query.append("        ,BOD.CRE_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(BOD.CRE_DT, 'yyyy-mm-dd')" ).append("\n"); 
		query.append("        ,BOD.UPD_USR_ID" ).append("\n"); 
		query.append("        ,TO_CHAR(BOD.UPD_DT, 'yyyy-mm-dd')" ).append("\n"); 
		query.append("        ,MDD.INV_NO" ).append("\n"); 

	}
}