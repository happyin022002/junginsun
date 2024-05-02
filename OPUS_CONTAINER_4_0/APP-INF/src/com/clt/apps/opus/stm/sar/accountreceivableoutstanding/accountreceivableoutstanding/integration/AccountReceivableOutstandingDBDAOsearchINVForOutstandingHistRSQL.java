/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOsearchINVForOutstandingHistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.14 
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

public class AccountReceivableOutstandingDBDAOsearchINVForOutstandingHistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Outstanding History를 생성하기 위한 Invoice 정보를 select
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOsearchINVForOutstandingHistRSQL(){
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
		query.append("FileName : AccountReceivableOutstandingDBDAOsearchINVForOutstandingHistRSQL").append("\n"); 
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
		query.append("SELECT A.AR_IF_NO||B.AR_IF_SER_NO IF_NO" ).append("\n"); 
		query.append("       , C.AR_HD_QTR_OFC_CD RHQ_CD" ).append("\n"); 
		query.append("       , DECODE(NVL(E.OTS_CD, 'ARO'), 'COU', E.REP_OTS_OFC_CD, A.AR_OFC_CD) OTS_OFC_CD" ).append("\n"); 
		query.append("       , A.BL_SRC_NO BL_NO" ).append("\n"); 
		query.append("       , DECODE(D.OTS_SMRY_CD, 'INV', NVL(A.INV_NO, '**********'), '**********') INV_NO" ).append("\n"); 
		query.append("       , B.CURR_CD" ).append("\n"); 
		query.append("       , 'OTS' OTS_HIS_TP_CD" ).append("\n"); 
		query.append("       , 'INVAR' OTS_SRC_CD" ).append("\n"); 
		query.append("       , A.GL_EFF_DT GL_DT" ).append("\n"); 
		query.append("       , NVL(SUM(B.CHG_AMT), 0) OTS_AMT" ).append("\n"); 
		query.append("       , A.AR_IF_NO REF_NO" ).append("\n"); 
		query.append("       , A.AR_OFC_CD INV_OFC_CD" ).append("\n"); 
		query.append("       , A.INV_RMK OTS_RMK" ).append("\n"); 
		query.append("       , A.INV_CUST_CNT_CD SHP_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("	   , A.INV_CUST_SEQ SHP_TO_CUST_SEQ" ).append("\n"); 
		query.append("       , A.ACT_CUST_CNT_CD BIL_TO_CUST_CNT_CD" ).append("\n"); 
		query.append("       , A.ACT_CUST_SEQ BIL_TO_CUST_SEQ" ).append("\n"); 
		query.append("       , A.VSL_CD" ).append("\n"); 
		query.append("       , A.SKD_VOY_NO" ).append("\n"); 
		query.append("       , A.SKD_DIR_CD DIR_CD" ).append("\n"); 
		query.append("       , A.SVC_SCP_CD" ).append("\n"); 
		query.append("       , DECODE(B.CURR_CD, A.LOCL_CURR_CD, A.XCH_RT_USD_TP_CD, 'USD', A.XCH_RT_USD_TP_CD, A.XCH_RT_N3RD_TP_CD) XCH_RT_TP_CD" ).append("\n"); 
		query.append("       , B.INV_XCH_RT LOCL_XCH_RT" ).append("\n"); 
		query.append("	   , B.USD_XCH_RT" ).append("\n"); 
		query.append("       , A.IO_BND_CD BKG_IO_BND_CD" ).append("\n"); 
		query.append("       , A.XCH_RT_DT" ).append("\n"); 
		query.append("       , A.POL_CD" ).append("\n"); 
		query.append("       , A.POD_CD" ).append("\n"); 
		query.append("	   , A.UPD_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append("	   , A.UPD_USR_ID" ).append("\n"); 
		query.append("	   , A.REV_TP_CD||A.REV_SRC_CD REV_TP_SRC_CD" ).append("\n"); 
		query.append("	   , A.REV_VSL_CD||A.REV_SKD_VOY_NO||A.REV_SKD_DIR_CD||A.REV_DIR_CD REV_VVD_CD" ).append("\n"); 
		query.append("	   , A.SAIL_DT" ).append("\n"); 
		query.append("	   , DECODE(D.OTS_SMRY_CD, 'INV', A.INV_CURR_CD, '') INV_CURR_CD" ).append("\n"); 
		query.append("	   , DECODE(DECODE(D.OTS_SMRY_CD, 'INV', A.INV_CURR_CD, ''), '', '', DECODE(DECODE(D.OTS_SMRY_CD, 'INV', A.INV_CURR_CD, ''), A.LOCL_CURR_CD, 1, A.INV_LOCL_XCH_RT)) INV_LOCL_XCH_RT" ).append("\n"); 
		query.append("  	   , DECODE(DECODE(D.OTS_SMRY_CD, 'INV', A.INV_CURR_CD, ''), '', '', DECODE(DECODE(D.OTS_SMRY_CD, 'INV', A.INV_CURR_CD, ''), 'USD', 1, A.INV_USD_XCH_RT)) INV_USD_XCH_RT" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("     INV_AR_CHG B," ).append("\n"); 
		query.append("     MDM_ORGANIZATION C," ).append("\n"); 
		query.append("	 INV_AR_STUP_OFC D," ).append("\n"); 
		query.append("	 SCO_OFC_INFO E" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = D.AR_OFC_CD(+)" ).append("\n"); 
		query.append("AND A.AR_OFC_CD = E.OFC_CD(+)" ).append("\n"); 
		query.append("AND D.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("AND A.AR_IF_NO = @[if_no]" ).append("\n"); 
		query.append("GROUP BY A.AR_IF_NO" ).append("\n"); 
		query.append("	   , B.AR_IF_SER_NO" ).append("\n"); 
		query.append("       , C.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("	   , E.OTS_CD" ).append("\n"); 
		query.append("       , E.REP_OTS_OFC_CD" ).append("\n"); 
		query.append("       , A.AR_OFC_CD" ).append("\n"); 
		query.append("       , A.BL_SRC_NO" ).append("\n"); 
		query.append("	   , D.OTS_SMRY_CD" ).append("\n"); 
		query.append("       , A.INV_NO" ).append("\n"); 
		query.append("       , B.CURR_CD" ).append("\n"); 
		query.append("       , A.GL_EFF_DT" ).append("\n"); 
		query.append("       , A.INV_RMK" ).append("\n"); 
		query.append("       , A.INV_CUST_CNT_CD" ).append("\n"); 
		query.append("	   , A.INV_CUST_SEQ" ).append("\n"); 
		query.append("       , A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("       , A.ACT_CUST_SEQ" ).append("\n"); 
		query.append("       , A.VSL_CD" ).append("\n"); 
		query.append("       , A.SKD_VOY_NO" ).append("\n"); 
		query.append("       , A.SKD_DIR_CD" ).append("\n"); 
		query.append("       , A.SVC_SCP_CD" ).append("\n"); 
		query.append("       , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("       , A.XCH_RT_USD_TP_CD" ).append("\n"); 
		query.append("       , A.XCH_RT_N3RD_TP_CD" ).append("\n"); 
		query.append("       , B.INV_XCH_RT" ).append("\n"); 
		query.append("	   , B.USD_XCH_RT" ).append("\n"); 
		query.append("       , A.IO_BND_CD" ).append("\n"); 
		query.append("       , A.XCH_RT_DT" ).append("\n"); 
		query.append("       , A.POL_CD" ).append("\n"); 
		query.append("       , A.POD_CD" ).append("\n"); 
		query.append("	   , A.UPD_USR_ID" ).append("\n"); 
		query.append("	   , A.REV_TP_CD" ).append("\n"); 
		query.append("	   , A.REV_SRC_CD" ).append("\n"); 
		query.append("	   , A.REV_VSL_CD" ).append("\n"); 
		query.append("	   , A.REV_SKD_VOY_NO" ).append("\n"); 
		query.append("	   , A.REV_SKD_DIR_CD" ).append("\n"); 
		query.append("	   , A.REV_DIR_CD" ).append("\n"); 
		query.append("	   , A.SAIL_DT" ).append("\n"); 
		query.append("	   , A.INV_CURR_CD" ).append("\n"); 
		query.append("	   , A.INV_LOCL_XCH_RT" ).append("\n"); 
		query.append("	   , A.INV_USD_XCH_RT" ).append("\n"); 
		query.append("ORDER BY B.AR_IF_SER_NO" ).append("\n"); 

	}
}