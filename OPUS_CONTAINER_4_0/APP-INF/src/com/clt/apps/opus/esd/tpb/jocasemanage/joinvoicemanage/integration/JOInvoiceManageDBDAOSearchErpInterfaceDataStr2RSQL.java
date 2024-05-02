/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOInvoiceManageDBDAOSearchErpInterfaceDataStr2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.02.22 변종건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOInvoiceManageDBDAOSearchErpInterfaceDataStr2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchErpInterfaceDataStr2
	  * </pre>
	  */
	public JOInvoiceManageDBDAOSearchErpInterfaceDataStr2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_his_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.integration").append("\n"); 
		query.append("FileName : JOInvoiceManageDBDAOSearchErpInterfaceDataStr2RSQL").append("\n"); 
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
		query.append("SELECT  ----- GENERAL BILLING CASE" ).append("\n"); 
		query.append("@[ar_if_no] AS AR_IF_NO," ).append("\n"); 
		query.append("DTL.N3PTY_INV_RVIS_DTL_SEQ AS CHG_SEQ," ).append("\n"); 
		query.append("DECODE(DTL.N3PTY_BIL_TP_CD, 'JO','XXX', '3'||DTL.N3PTY_BIL_TP_CD) AS N3PTY_INV_CHG_TP_CD,   /* LIKE 3CC (GENERAL), 'XXX' ('JO' CASE) */" ).append("\n"); 
		query.append("NVL(DTL.INV_DTL_AMT,0) - NVL(DTL.REV_AMT,0) AS CHG_AMT," ).append("\n"); 
		query.append("COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01394',DECODE(DTL.N3PTY_BIL_TP_CD, 'JO','XXX', '3'||DTL.N3PTY_BIL_TP_CD)) AS CHG_FULL_NM,  /* ADDED CHARGE TYPE CODE NAME ... */" ).append("\n"); 
		query.append("HDR.CURR_CD AS CHG_CURR_CD," ).append("\n"); 
		query.append("DECODE(DTL.N3PTY_BIL_TP_CD, 'JO','954117',NULL) AS REV_ACCT_CD," ).append("\n"); 
		query.append("DECODE(OTS.N3PTY_EXPN_TP_CD, 'TES','954113', 'TRS','954113', 'MNR','954113',NULL) AS ACCT_CD,   /* ACCT_CD DECISION */" ).append("\n"); 
		query.append("NULL AS INV_IF_FLG," ).append("\n"); 
		query.append("NULL AS INV_IF_NO," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS INV_IF_DT," ).append("\n"); 
		query.append("INV.OFC_CD AS INV_IF_OFC_CD," ).append("\n"); 
		query.append("NULL AS CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS CRE_DT," ).append("\n"); 
		query.append("NULL AS UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS UPD_DT," ).append("\n"); 
		query.append("@[user_ofc_cd] USER_OFC_CD, @[user_id] USER_ID" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP OTS, TPB_INVOICE INV, TPB_INV_RVIS HDR, TPB_INV_RVIS_DTL DTL" ).append("\n"); 
		query.append("WHERE INV.N3PTY_INV_NO = HDR.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND INV.N3PTY_INV_NO = DTL.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND INV.N3PTY_INV_NO = OTS.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND HDR.N3PTY_INV_RVIS_SEQ = DTL.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("AND DTL.N3PTY_NO = OTS.N3PTY_NO" ).append("\n"); 
		query.append("AND OTS.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND INV.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND HDR.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND DTL.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND HDR.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND HDR.N3PTY_INV_RVIS_SEQ = @[s_n3pty_inv_his_seq]" ).append("\n"); 
		query.append("----- ----- -----" ).append("\n"); 
		query.append("UNION ALL -------" ).append("\n"); 
		query.append("----- ----- -----" ).append("\n"); 
		query.append("SELECT  ----- 'JO' BILLING CASE - REVENUE" ).append("\n"); 
		query.append("@[ar_if_no] AS AR_IF_NO," ).append("\n"); 
		query.append("( SELECT MAX(N3PTY_INV_RVIS_DTL_SEQ) FROM TPB_INV_RVIS_DTL AA WHERE AA.N3PTY_INV_NO = HDR.N3PTY_INV_NO AND AA.N3PTY_INV_RVIS_SEQ = HDR.N3PTY_INV_RVIS_SEQ ) + ROWNUM AS CHG_SEQ," ).append("\n"); 
		query.append("'TPC' AS N3PTY_INV_CHG_TP_CD,                              /* TPC (CASE 'JO' REVENUE) */" ).append("\n"); 
		query.append("NVL(DTL.REV_AMT,0) AS CHG_AMT," ).append("\n"); 
		query.append("COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01394','TPC') AS CHG_FULL_NM,   /* ADDED CHARGE TYPE CODE NAME ... */" ).append("\n"); 
		query.append("HDR.CURR_CD AS CHG_CURR_CD," ).append("\n"); 
		query.append("DECODE(DTL.N3PTY_BIL_TP_CD, 'JO','954117',NULL) AS REV_ACCT_CD," ).append("\n"); 
		query.append("DECODE(OTS.N3PTY_EXPN_TP_CD, 'TES','411915', 'TRS','411915', 'MNR','411915',NULL) AS ACCT_CD,   /* ACCT_CD DECISION */" ).append("\n"); 
		query.append("NULL AS INV_IF_FLG," ).append("\n"); 
		query.append("NULL AS INV_IF_NO," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS INV_IF_DT," ).append("\n"); 
		query.append("INV.OFC_CD AS INV_IF_OFC_CD," ).append("\n"); 
		query.append("NULL AS CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS CRE_DT," ).append("\n"); 
		query.append("NULL AS UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS UPD_DT," ).append("\n"); 
		query.append("@[user_ofc_cd] USER_OFC_CD, @[user_id] USER_ID" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP OTS, TPB_INVOICE INV, TPB_INV_RVIS HDR, TPB_INV_RVIS_DTL DTL" ).append("\n"); 
		query.append("WHERE INV.N3PTY_INV_NO = HDR.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND INV.N3PTY_INV_NO = DTL.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND INV.N3PTY_INV_NO = OTS.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND HDR.N3PTY_INV_RVIS_SEQ = DTL.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("AND DTL.N3PTY_NO = OTS.N3PTY_NO" ).append("\n"); 
		query.append("AND OTS.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND INV.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND HDR.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND DTL.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND HDR.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND HDR.N3PTY_INV_RVIS_SEQ = @[s_n3pty_inv_his_seq]" ).append("\n"); 
		query.append("AND DTL.N3PTY_BIL_TP_CD = 'JO'                          /* ONLY JO */" ).append("\n"); 
		query.append("AND ( DTL.REV_AMT IS NOT NULL AND DTL.REV_AMT != 0.0 )   /* REV_AMT IS NOT NULL AND NOT 0.0 ... */" ).append("\n"); 
		query.append("----- ----- -----" ).append("\n"); 
		query.append("UNION ALL -------" ).append("\n"); 
		query.append("----- ----- -----" ).append("\n"); 
		query.append("SELECT ----- TAX CASE" ).append("\n"); 
		query.append("@[ar_if_no] AS AR_IF_NO," ).append("\n"); 
		query.append("( SELECT MAX(N3PTY_INV_RVIS_DTL_SEQ) FROM TPB_INV_RVIS_DTL AA WHERE AA.N3PTY_INV_NO = HDR.N3PTY_INV_NO AND AA.N3PTY_INV_RVIS_SEQ = HDR.N3PTY_INV_RVIS_SEQ )    --- CHG_SEQ -- START" ).append("\n"); 
		query.append("+ ( SELECT COUNT(0) CNT" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP OTS1, TPB_INVOICE INV1, TPB_INV_RVIS HDR1, TPB_INV_RVIS_DTL DTL1" ).append("\n"); 
		query.append("WHERE INV1.N3PTY_INV_NO = HDR1.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND INV1.N3PTY_INV_NO = DTL1.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND INV1.N3PTY_INV_NO = OTS1.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND HDR1.N3PTY_INV_RVIS_SEQ = DTL1.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("AND DTL1.N3PTY_NO = OTS1.N3PTY_NO" ).append("\n"); 
		query.append("AND OTS1.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND INV1.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND HDR1.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND DTL1.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND HDR1.N3PTY_INV_NO = HDR.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND HDR1.N3PTY_INV_RVIS_SEQ = HDR.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("AND DTL1.N3PTY_BIL_TP_CD = 'JO'                             /* ONLY JO */" ).append("\n"); 
		query.append("AND ( DTL1.REV_AMT IS NOT NULL AND DTL1.REV_AMT != 0.0 )   /* REV_AMT IS NOT NULL AND NOT 01.0 1.1.1. */" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("+ ROWNUM AS CHG_SEQ,                                               --- CHG_SEQ -- END" ).append("\n"); 
		query.append("'TVA' AS AR_INV_CHG_TP_CD,                                         /* VAT CASE ... TVA */" ).append("\n"); 
		query.append("NVL(HDR.VAT_AMT,0) AS CHG_AMT," ).append("\n"); 
		query.append("COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01394','TVA') AS CHG_FULL_NM,   /* ADDED CHARGE TYPE CODE NAME */" ).append("\n"); 
		query.append("HDR.CURR_CD AS CHG_CURR_CD," ).append("\n"); 
		query.append("DECODE(DTL.N3PTY_BIL_TP_CD, 'JO','954117', NULL) AS REV_ACCT_CD," ).append("\n"); 
		query.append("'954117' AS ACCT_CD,      /* TVA CASE, '954117' */" ).append("\n"); 
		query.append("NULL AS INV_IF_FLG," ).append("\n"); 
		query.append("NULL AS INV_IF_NO," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS INV_IF_DT," ).append("\n"); 
		query.append("INV.OFC_CD AS INV_IF_OFC_CD," ).append("\n"); 
		query.append("NULL AS CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS CRE_DT," ).append("\n"); 
		query.append("NULL AS UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS UPD_DT," ).append("\n"); 
		query.append("@[user_ofc_cd] USER_OFC_CD, @[user_id] USER_ID" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP OTS, TPB_INVOICE INV, TPB_INV_RVIS HDR, TPB_INV_RVIS_DTL DTL" ).append("\n"); 
		query.append("WHERE INV.N3PTY_INV_NO = HDR.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND INV.N3PTY_INV_NO = DTL.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND INV.N3PTY_INV_NO = OTS.N3PTY_INV_NO" ).append("\n"); 
		query.append("AND HDR.N3PTY_INV_RVIS_SEQ = DTL.N3PTY_INV_RVIS_SEQ" ).append("\n"); 
		query.append("AND DTL.N3PTY_NO = OTS.N3PTY_NO" ).append("\n"); 
		query.append("AND OTS.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND INV.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND HDR.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND DTL.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND HDR.N3PTY_INV_NO = @[s_n3pty_inv_no]" ).append("\n"); 
		query.append("AND HDR.N3PTY_INV_RVIS_SEQ = @[s_n3pty_inv_his_seq]" ).append("\n"); 
		query.append("AND ( HDR.VAT_AMT IS NOT NULL AND HDR.VAT_AMT > 0.0 )     /* VAT_AMT IS VALID */" ).append("\n"); 
		query.append("AND DTL.N3PTY_INV_RVIS_DTL_SEQ = 1                        /* 한 행만... */" ).append("\n"); 

	}
}