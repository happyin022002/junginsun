/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchInvArIfChgDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.30
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2010.06.30 이주현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchInvArIfChgDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InterfaceMgtDBDAOsearchInvArIfChgDataRSQL
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchInvArIfChgDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchInvArIfChgDataRSQL").append("\n"); 
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
		query.append("'' AS UPD_DT," ).append("\n"); 
		query.append("1 AS SRC_IF_SEQ," ).append("\n"); 
		query.append("'XXX' AS REP_CHG_CD," ).append("\n"); 
		query.append("MRW.CURR_CD AS CURR_CD," ).append("\n"); 
		query.append("'BL' AS PER_TP_CD," ).append("\n"); 
		query.append("'CLARING_AR AND FA FOR RETIREMENT' AS CHG_FULL_NM," ).append("\n"); 
		query.append("'' AS CRE_DT," ).append("\n"); 
		query.append("#if (${cancel_yn} == 'Y')" ).append("\n"); 
		query.append("-1 * MRW.BZC_AMT AS TRF_RT_AMT," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MRW.BZC_AMT AS TRF_RT_AMT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), SYSDATE, @[user_ofc_cd]), 'YYYYMMDD') AS SRC_IF_DT," ).append("\n"); 
		query.append("'1' AS CHG_SEQ," ).append("\n"); 
		query.append("'EQD' AS CHG_CD," ).append("\n"); 
		query.append("MRW.CRE_USR_ID AS CRE_USR_ID," ).append("\n"); 
		query.append("'' AS TRF_NO," ).append("\n"); 
		query.append("#if (${cancel_yn} == 'Y')" ).append("\n"); 
		query.append("-1 * MRW.BZC_AMT AS CHG_AMT," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MRW.BZC_AMT AS CHG_AMT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("'1' AS RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("MRW.UPD_USR_ID AS UPD_USR_ID," ).append("\n"); 
		query.append("DECODE(MRW.VAT_AMT, 0, 'N', 'Y') AS TVA_FLG," ).append("\n"); 
		query.append("( SELECT MAX(DECODE(MRW.CURR_CD, MAR.AR_CURR_CD, 1, DECODE(MAR.AR_CURR_CD, A.CURR_CD, USD_LOCL_XCH_RT))) TO_USD_RT" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT A" ).append("\n"); 
		query.append("WHERE A.ACCT_XCH_RT_LVL   = 1" ).append("\n"); 
		query.append("AND   A.CURR_CD           IN (MRW.CURR_CD, MAR.AR_CURR_CD)" ).append("\n"); 
		query.append("AND   A.ACCT_XCH_RT_YRMON = TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(@[user_ofc_cd], SYSDATE, MNR_COMMON_PKG.MNR_GET_HOOFC_FNC()), 'YYYYMM')" ).append("\n"); 
		query.append("GROUP BY A.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append(") AS INV_XCH_RT," ).append("\n"); 
		query.append("'957112' AS CHG_RMK" ).append("\n"); 
		query.append("FROM MNR_RCV_INV_WRK MRW, MDM_ORGANIZATION MAR" ).append("\n"); 
		query.append("WHERE MRW.ISS_OFC_CD = MAR.OFC_CD" ).append("\n"); 
		query.append("AND   MAR.AR_OFC_CD   = MAR.OFC_CD" ).append("\n"); 
		query.append("AND   MRW.RCV_INV_SEQ = @[rcv_inv_seq]" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' AS UPD_DT," ).append("\n"); 
		query.append("1 AS SRC_IF_SEQ," ).append("\n"); 
		query.append("'SLC' AS REP_CHG_CD," ).append("\n"); 
		query.append("MRW.CHG_CURR_CD AS CURR_CD," ).append("\n"); 
		query.append("'BL' AS PER_TP_CD," ).append("\n"); 
		query.append("'V.A.T RECEIVED' AS CHG_FULL_NM," ).append("\n"); 
		query.append("'' AS CRE_DT," ).append("\n"); 
		query.append("#if (${cancel_yn} == 'Y')" ).append("\n"); 
		query.append("-1 * MRW.VAT_AMT AS TRF_RT_AMT," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MRW.VAT_AMT AS TRF_RT_AMT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYYMMDD') AS SRC_IF_DT," ).append("\n"); 
		query.append("'2' AS CHG_SEQ," ).append("\n"); 
		query.append("'TVA' AS CHG_CD," ).append("\n"); 
		query.append("MRW.CRE_USR_ID AS CRE_USR_ID," ).append("\n"); 
		query.append("'' AS TRF_NO," ).append("\n"); 
		query.append("#if (${cancel_yn} == 'Y')" ).append("\n"); 
		query.append("-1 * MRW.VAT_AMT AS CHG_AMT," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MRW.VAT_AMT AS CHG_AMT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("'1' AS RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("MRW.UPD_USR_ID AS UPD_USR_ID," ).append("\n"); 
		query.append("'N' AS TVA_FLG," ).append("\n"); 
		query.append("1   AS INV_XCH_RT," ).append("\n"); 
		query.append("'212111' AS CHG_RMK" ).append("\n"); 
		query.append("FROM MNR_RCV_INV_WRK MRW, MDM_ORGANIZATION MAR" ).append("\n"); 
		query.append("WHERE MRW.ISS_OFC_CD = MAR.OFC_CD" ).append("\n"); 
		query.append("AND   MAR.AR_OFC_CD   = MAR.OFC_CD" ).append("\n"); 
		query.append("AND   MRW.RCV_INV_SEQ = @[rcv_inv_seq]" ).append("\n"); 
		query.append("AND   MRW.VAT_AMT <> 0" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}