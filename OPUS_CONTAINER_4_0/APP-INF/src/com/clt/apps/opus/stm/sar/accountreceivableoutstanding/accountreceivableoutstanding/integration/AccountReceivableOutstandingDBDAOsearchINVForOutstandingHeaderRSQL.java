/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOsearchINVForOutstandingHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.01 
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

public class AccountReceivableOutstandingDBDAOsearchINVForOutstandingHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Outstanding Header를 생성하기 위한 Invoice 정보를 select
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOsearchINVForOutstandingHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOsearchINVForOutstandingHeaderRSQL").append("\n"); 
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
		query.append("SELECT B.AR_HD_QTR_OFC_CD RHQ_CD" ).append("\n"); 
		query.append("       , DECODE(NVL(D.OTS_CD, 'ARO'), 'COU', D.REP_OTS_OFC_CD, A.AR_OFC_CD) OTS_OFC_CD" ).append("\n"); 
		query.append("       , A.BL_SRC_NO BL_NO" ).append("\n"); 
		query.append("       , DECODE(C.OTS_SMRY_CD, 'INV', NVL(A.INV_NO, '**********'), '**********') INV_NO" ).append("\n"); 
		query.append("       , A.LOCL_CURR_CD OFC_CURR_CD" ).append("\n"); 
		query.append("       , 'INVAR' OTS_SRC_CD" ).append("\n"); 
		query.append("       , A.ACT_CUST_CNT_CD BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("       , A.ACT_CUST_SEQ BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("       , A.BKG_NO" ).append("\n"); 
		query.append("       , A.VSL_CD" ).append("\n"); 
		query.append("       , A.SKD_VOY_NO" ).append("\n"); 
		query.append("       , A.SKD_DIR_CD DIR_CD" ).append("\n"); 
		query.append("       , A.TRNK_VSL_CD||A.TRNK_SKD_VOY_NO||A.TRNK_SKD_DIR_CD TRNK_VVD_CD" ).append("\n"); 
		query.append("       , A.SVC_SCP_CD" ).append("\n"); 
		query.append("       , A.SLAN_CD LANE_CD" ).append("\n"); 
		query.append("       , A.SAIL_ARR_DT" ).append("\n"); 
		query.append("       , A.IO_BND_CD BKG_IO_BND_CD" ).append("\n"); 
		query.append("       , A.POR_CD" ).append("\n"); 
		query.append("       , A.POL_CD" ).append("\n"); 
		query.append("       , A.POD_CD" ).append("\n"); 
		query.append("       , A.DEL_CD" ).append("\n"); 
		query.append("       , A.SREP_CD CUST_SREP_CD" ).append("\n"); 
		query.append("       , A.DUE_DT" ).append("\n"); 
		query.append("       , A.INV_REF_NO BKG_REF_NO" ).append("\n"); 
		query.append("       , A.AP_AR_OFFST_NO" ).append("\n"); 
		query.append("       , A.CUST_CR_FLG CR_MK_FLG" ).append("\n"); 
		query.append("       , A.XCH_RT_USD_TP_CD XCH_RT_TP_CD" ).append("\n"); 
		query.append("       , A.ISS_DT INV_DT" ).append("\n"); 
		query.append("       , A.AR_OFC_CD CLT_OFC_CD" ).append("\n"); 
		query.append("       , A.SC_NO" ).append("\n"); 
		query.append("       , A.REV_TP_CD||A.REV_SRC_CD REV_TP_SRC_CD" ).append("\n"); 
		query.append("	   , A.INV_CUST_CNT_CD SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("	   , A.INV_CUST_SEQ SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("       , A.XCH_RT_N3RD_TP_CD" ).append("\n"); 
		query.append(" 	   , A.XCH_RT_DT" ).append("\n"); 
		query.append("	   , A.AR_IF_NO MAX_AR_IF_NO" ).append("\n"); 
		query.append("	   , A.SAIL_DT" ).append("\n"); 
		query.append("	   , A.UPD_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append("	   , A.UPD_USR_ID" ).append("\n"); 
		query.append("	   , DECODE(C.OTS_SMRY_CD, 'INV', A.INV_CURR_CD, '') INV_CURR_CD" ).append("\n"); 
		query.append("	   , DECODE(DECODE(C.OTS_SMRY_CD, 'INV', A.INV_CURR_CD, ''), '', '', DECODE(DECODE(C.OTS_SMRY_CD, 'INV', A.INV_CURR_CD, ''), A.LOCL_CURR_CD, 1, A.INV_LOCL_XCH_RT)) INV_LOCL_XCH_RT" ).append("\n"); 
		query.append("  	   , DECODE(DECODE(C.OTS_SMRY_CD, 'INV', A.INV_CURR_CD, ''), '', '', DECODE(DECODE(C.OTS_SMRY_CD, 'INV', A.INV_CURR_CD, ''), 'USD', 1, A.INV_USD_XCH_RT)) INV_USD_XCH_RT" ).append("\n"); 
		query.append("	   , A.AR_OFC_CD" ).append("\n"); 
		query.append("	   , NVL((SELECT DISTINCT 'N'" ).append("\n"); 
		query.append("              FROM INV_AR_MN IAM," ).append("\n"); 
		query.append("                   INV_AR_CHG IAC" ).append("\n"); 
		query.append("              WHERE IAM.AR_IF_NO = IAC.AR_IF_NO" ).append("\n"); 
		query.append("              AND IAM.AR_OFC_CD = A.AR_OFC_CD" ).append("\n"); 
		query.append("              AND IAM.BL_SRC_NO = A.BL_SRC_NO" ).append("\n"); 
		query.append("              AND IAM.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("              GROUP BY IAC.CURR_CD" ).append("\n"); 
		query.append("              HAVING SUM(IAC.CHG_AMT) <> 0), 'Y') BKG_STL_FLG" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("     MDM_ORGANIZATION B," ).append("\n"); 
		query.append("	 INV_AR_STUP_OFC C," ).append("\n"); 
		query.append("	 SCO_OFC_INFO D" ).append("\n"); 
		query.append("WHERE A.AR_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = C.AR_OFC_CD(+)" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = D.OFC_CD(+)" ).append("\n"); 
		query.append("AND C.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("AND A.AR_IF_NO = @[if_no]" ).append("\n"); 

	}
}