/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOsearchOffsetAPPopupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.22 
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

public class AccountReceivableAdjustDBDAOsearchOffsetAPPopupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP Search Popup
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOsearchOffsetAPPopupListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_ots_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dt_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offst_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOsearchOffsetAPPopupListRSQL").append("\n"); 
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
		query.append("SELECT  SIH.OFC_CD                  AS OFC_CD   " ).append("\n"); 
		query.append("      , SIH.VNDR_NO                 AS VNDR_NO" ).append("\n"); 
		query.append("      , MV.VNDR_LGL_ENG_NM          AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      , SIH.INV_NO                  AS INV_NO   " ).append("\n"); 
		query.append("      , TO_CHAR(SIH.INV_DT ,'YYYY-MM-DD') AS INV_DT" ).append("\n"); 
		query.append("      , ''                          AS INV_DT_FM" ).append("\n"); 
		query.append("      , ''                          AS INV_DT_TO" ).append("\n"); 
		query.append("      , SIH.INV_CURR_CD             AS INV_CURR_CD" ).append("\n"); 
		query.append("      , SAR_GET_FMT_MASK_FNC(SIH.INV_CURR_CD,SIH.INV_AMT) AS INV_AMT" ).append("\n"); 
		query.append("      , SIH.INV_AMT                 AS ORG_INV_AMT" ).append("\n"); 
		query.append("      , 'AP'                        AS OFFST_TP_CD" ).append("\n"); 
		query.append("      , SIH.INV_XCH_DT " ).append("\n"); 
		query.append("      , SIH.INV_XCH_RT_TP_CD" ).append("\n"); 
		query.append("      , SIH.INV_SEQ" ).append("\n"); 
		query.append("      , SIH.GL_DT" ).append("\n"); 
		query.append("      , @[offst_curr_cd] AS OFFST_CURR_CD " ).append("\n"); 
		query.append("      , '' AS AP_XCH_RT" ).append("\n"); 
		query.append("      , (SELECT NVL(MC.DP_PRCS_KNT,0) FROM MDM_CURRENCY MC WHERE MC.CURR_CD = SIH.INV_CURR_CD) AS DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , MDM_VENDOR MV" ).append("\n"); 
		query.append("      , COM_USER CU" ).append("\n"); 
		query.append("      , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("WHERE   SIH.VNDR_NO = TO_CHAR(MV.VNDR_SEQ)" ).append("\n"); 
		query.append("AND     SIH.CRE_USR_ID = CU.USR_ID" ).append("\n"); 
		query.append("AND     SIH.OFC_CD = MO.OFC_CD " ).append("\n"); 
		query.append("AND     SIH.INV_SEQ IS NOT NULL" ).append("\n"); 
		query.append("--AND     (SIH.ATTR_CTNT15 <> 'Y' OR SIH.ATTR_CTNT15 IS NULL)" ).append("\n"); 
		query.append("--AND     SIH.ATTR_CTNT12 IS NOT NULL" ).append("\n"); 
		query.append("AND     ((SIH.ATTR_CTNT12 IS NOT NULL AND SIH.AP_INV_SRC_CD IN ('Manual Invoice Entry', 'AR')) OR (SIH.AP_INV_SRC_CD NOT IN ('Manual Invoice Entry', 'AR')))" ).append("\n"); 
		query.append("--AND     SIH.AP_APSTS_CD <> 'MANUALLY APPROVED'" ).append("\n"); 
		query.append("AND     SIH.INV_CXL_DT IS NULL" ).append("\n"); 
		query.append("AND     EXISTS (SELECT 'A' FROM SAP_INV_DTL SID WHERE SIH.INV_SEQ = SID.INV_SEQ AND SID.MTCH_STS_FLG = 'A')" ).append("\n"); 
		query.append("#if (${ots_cd} == 'COU')" ).append("\n"); 
		query.append("    AND  SIH.OFC_CD IN ( SELECT OFC_CD " ).append("\n"); 
		query.append("                         FROM   SCO_OFC_INFO SOI " ).append("\n"); 
		query.append("                         WHERE  SOI.REP_OTS_OFC_CD = @[rep_ots_ofc_cd]" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    AND  SIH.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_dt_fm} != '')   " ).append("\n"); 
		query.append("    AND SIH.INV_DT >= TO_DATE(@[inv_dt_fm], 'YYYYMMDD') " ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("#if (${inv_dt_to} != '')   " ).append("\n"); 
		query.append("    AND SIH.INV_DT < TO_DATE(@[inv_dt_to], 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${vndr_no} != '')" ).append("\n"); 
		query.append("	AND SIH.VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("	AND SIH.INV_NO IN (${inv_no})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${offst_curr_cd} != '')" ).append("\n"); 
		query.append("	AND SIH.INV_CURR_CD  = @[offst_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SIH.INV_DT DESC ,  SIH.VNDR_NO" ).append("\n"); 

	}
}