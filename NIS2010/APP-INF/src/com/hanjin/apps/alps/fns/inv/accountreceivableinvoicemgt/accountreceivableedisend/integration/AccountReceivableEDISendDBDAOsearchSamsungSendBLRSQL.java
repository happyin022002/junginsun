/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOsearchSamsungSendBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOsearchSamsungSendBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Flate file작성시 사용할 실제 전송할 데이터 조회
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOsearchSamsungSendBLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOsearchSamsungSendBLRSQL").append("\n"); 
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
		query.append("#if (${rcrv_id} == 'FSELC') " ).append("\n"); 
		query.append("SELECT RPAD(A.SNDR_ID, 20, ' ')||RPAD(A.RCVR_ID, 20, ' ')||RPAD('FREINV', 10, ' ')||'INV'||TO_CHAR(SYSDATE, 'YYYYMMDDHHMMSS') HEADER," ).append("\n"); 
		query.append("  A.MSG_NO||B.BL_SRC_NO||TO_CHAR(SYSDATE, 'HH24MISS') MSG_NO," ).append("\n"); 
		query.append("  A.INV_MSG_FUNC_CD MSG_FUNC_CD," ).append("\n"); 
		query.append("  B.SR_INV_NO DOC_NO," ).append("\n"); 
		query.append("  TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS')) DOC_DATE," ).append("\n"); 
		query.append("  A.BIL_DT BILLING_DATE," ).append("\n"); 
		query.append("  NVL(B.DIV_CTNT,' ') DIV_TY_CD," ).append("\n"); 
		query.append("  NVL(B.DIV_NM,' ') DIV_CD_DESC," ).append("\n"); 
		query.append("  A.MSG_NO||B.BL_SRC_NO||TO_CHAR(SYSDATE, 'HH24MISS') RLYDOC_MSG_NO," ).append("\n"); 
		query.append("  B.SR_INV_NO RLYDOC_DOC_NO," ).append("\n"); 
		query.append("  TO_CHAR(SYSDATE, 'YYYYMMDD') RLYDOC_DOC_DATE," ).append("\n"); 
		query.append("  ' ' RLYDOC_DOC_NO1," ).append("\n"); 
		query.append("  'SMLM'||B.BL_SRC_NO RLYDOC_DOC_NO2," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT TO_CHAR(BL_OBRD_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("    FROM BKG_BL_DOC" ).append("\n"); 
		query.append("    WHERE BKG_NO = D.BKG_NO) ACTUAL_DATE," ).append("\n"); 
		query.append("  NVL(B.FCTRY_CTNT,' ') PLANT_CD," ).append("\n"); 
		query.append("  NVL(B.FCTRY_NM,' ') PLANT_DESC," ).append("\n"); 
		query.append("  NVL(A.EDI_HDR_RMK,' ') REMARK," ).append("\n"); 
		query.append("  'CA' CUSTOMER_TP_CD_CA," ).append("\n"); 
		query.append("  NVL(B.GERP_CRR_CTNT,' ') CUST_CD_CA," ).append("\n"); 
		query.append("  NVL(B.GERP_CRR_NM,' ') CUST_NAME_CA," ).append("\n"); 
		query.append("  'FW' CUSTOMER_TP_CD_FW," ).append("\n"); 
		query.append("  ' ' CUST_CD_FW," ).append("\n"); 
		query.append("  ' ' CUST_NAME_FW," ).append("\n"); 
		query.append("  'POR' LOC_TP_CD_POR," ).append("\n"); 
		query.append("  B.POR_CD LOC_CD_POR," ).append("\n"); 
		query.append("  L1.LOC_NM LOC_NAME_POR," ).append("\n"); 
		query.append("  L1.CNT_CD LOC_CNT_CD_POR," ).append("\n"); 
		query.append("  C1.CNT_NM LOC_CNT_NAME_POR," ).append("\n"); 
		query.append("  'POL' LOC_TP_CD_POL," ).append("\n"); 
		query.append("  B.POL_CD LOC_CD_POL," ).append("\n"); 
		query.append("  L2.LOC_NM LOC_NAME_POL," ).append("\n"); 
		query.append("  L2.CNT_CD LOC_CNT_CD_POL," ).append("\n"); 
		query.append("  C2.CNT_NM LOC_CNT_NAME_POL," ).append("\n"); 
		query.append("  'POD' LOC_TP_CD_POD," ).append("\n"); 
		query.append("  B.POD_CD LOC_CD_POD," ).append("\n"); 
		query.append("  L3.LOC_NM LOC_NAME_POD," ).append("\n"); 
		query.append("  L3.CNT_CD LOC_CNT_CD_POD," ).append("\n"); 
		query.append("  C3.CNT_NM LOC_CNT_NAME_POD," ).append("\n"); 
		query.append("  'DEL' LOC_TP_CD_DEL," ).append("\n"); 
		query.append("  B.DEL_CD LOC_CD_DEL," ).append("\n"); 
		query.append("  L4.LOC_NM LOC_NAME_DEL," ).append("\n"); 
		query.append("  L4.CNT_CD LOC_CNT_CD_DEL," ).append("\n"); 
		query.append("  C4.CNT_NM LOC_CNT_NAME_DEL," ).append("\n"); 
		query.append("  'T001' CS_MEA_CD," ).append("\n"); 
		query.append("  B.GRS_CNTR_WGT MEA_QTY," ).append("\n"); 
		query.append("  'KG' MEA_CD," ).append("\n"); 
		query.append("  B.MSG_ID MSG_ID_BL," ).append("\n"); 
		query.append("  B.MSG_NO MSG_NO_BL," ).append("\n"); 
		query.append("  B.BL_LINE_NO BL_LINE_NO_BL," ).append("\n"); 
		query.append("  B.BL_SRC_NO BL_SRC_NO_BL" ).append("\n"); 
		query.append("FROM INV_AR_EDI_GERP_HDR A," ).append("\n"); 
		query.append("  INV_AR_EDI_GERP_BL B," ).append("\n"); 
		query.append("  INV_AR_MN D," ).append("\n"); 
		query.append("  MDM_LOCATION L1," ).append("\n"); 
		query.append("  MDM_COUNTRY C1," ).append("\n"); 
		query.append("  MDM_LOCATION L2," ).append("\n"); 
		query.append("  MDM_COUNTRY C2," ).append("\n"); 
		query.append("  MDM_LOCATION L3," ).append("\n"); 
		query.append("  MDM_COUNTRY C3," ).append("\n"); 
		query.append("  MDM_LOCATION L4," ).append("\n"); 
		query.append("  MDM_COUNTRY C4" ).append("\n"); 
		query.append("WHERE A.MSG_ID = B.MSG_ID" ).append("\n"); 
		query.append("  AND A.MSG_NO = B.MSG_NO" ).append("\n"); 
		query.append("  AND B.BL_SRC_NO = D.BL_SRC_NO" ).append("\n"); 
		query.append("  AND A.CUST_CNT_CD = D.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("  AND A.CUST_SEQ = D.ACT_CUST_SEQ" ).append("\n"); 
		query.append("  AND L1.LOC_CD = B.POR_CD" ).append("\n"); 
		query.append("  AND L1.CNT_CD = C1.CNT_CD" ).append("\n"); 
		query.append("  AND L2.LOC_CD = B.POL_CD" ).append("\n"); 
		query.append("  AND L2.CNT_CD = C2.CNT_CD" ).append("\n"); 
		query.append("  AND L3.LOC_CD = B.POD_CD" ).append("\n"); 
		query.append("  AND L3.CNT_CD = C3.CNT_CD" ).append("\n"); 
		query.append("  AND L4.LOC_CD = B.DEL_CD" ).append("\n"); 
		query.append("  AND L4.CNT_CD = C4.CNT_CD" ).append("\n"); 
		query.append("  AND A.MSG_ID = @[msg_id]" ).append("\n"); 
		query.append("  AND A.MSG_NO = @[msg_no]" ).append("\n"); 
		query.append("  AND B.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT RPAD(A.SNDR_ID, 20, ' ')||RPAD(A.RCVR_ID, 20, ' ')||RPAD('FREINV', 10, ' ')||'INV'||TO_CHAR(SYSDATE, 'YYYYMMDDHHMMSS') HEADER," ).append("\n"); 
		query.append("  A.MSG_NO||B.BL_SRC_NO||TO_CHAR(SYSDATE, 'HH24MISS') MSG_NO," ).append("\n"); 
		query.append("  A.INV_MSG_FUNC_CD MSG_FUNC_CD," ).append("\n"); 
		query.append("  B.SR_INV_NO DOC_NO," ).append("\n"); 
		query.append("  TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS')) DOC_DATE," ).append("\n"); 
		query.append("  A.BIL_DT BILLING_DATE," ).append("\n"); 
		query.append("  NVL(B.DIV_CTNT,' ') DIV_TY_CD," ).append("\n"); 
		query.append("  NVL(B.DIV_NM,' ') DIV_CD_DESC," ).append("\n"); 
		query.append("  NVL(( SELECT /*+ INDEX_DESC( A XPKBKG_REFERENCE ) */" ).append("\n"); 
		query.append("               SUBSTR(CUST_REF_NO_CTNT ,1,50)" ).append("\n"); 
		query.append("        FROM BKG_REFERENCE  A" ).append("\n"); 
		query.append("        WHERE BKG_NO = D.BKG_NO " ).append("\n"); 
		query.append("        AND BKG_REF_TP_CD = 'SAMF' " ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("  ),' ') RLYDOC_MSG_NO," ).append("\n"); 
		query.append("  'SMLM'||B.BL_SRC_NO RLYDOC_DOC_NO," ).append("\n"); 
		query.append("  ' ' RLYDOC_DOC_DATE," ).append("\n"); 
		query.append("  ' ' RLYDOC_DOC_NO1," ).append("\n"); 
		query.append("  'SMLM'||B.BL_SRC_NO RLYDOC_DOC_NO2," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT TO_CHAR(BL_OBRD_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("    FROM BKG_BL_DOC" ).append("\n"); 
		query.append("    WHERE BKG_NO = D.BKG_NO) ACTUAL_DATE," ).append("\n"); 
		query.append("  NVL(B.FCTRY_CTNT,' ') PLANT_CD," ).append("\n"); 
		query.append("  NVL(B.FCTRY_NM,' ') PLANT_DESC," ).append("\n"); 
		query.append("  NVL(A.EDI_HDR_RMK,' ') REMARK," ).append("\n"); 
		query.append("  'CA' CUSTOMER_TP_CD_CA," ).append("\n"); 
		query.append("  NVL(B.GERP_CRR_CTNT,' ') CUST_CD_CA," ).append("\n"); 
		query.append("  NVL(B.GERP_CRR_NM,' ') CUST_NAME_CA," ).append("\n"); 
		query.append("  'FW' CUSTOMER_TP_CD_FW," ).append("\n"); 
		query.append("  ' ' CUST_CD_FW," ).append("\n"); 
		query.append("  ' ' CUST_NAME_FW," ).append("\n"); 
		query.append("  'POR' LOC_TP_CD_POR," ).append("\n"); 
		query.append("  B.POR_CD LOC_CD_POR," ).append("\n"); 
		query.append("  L1.LOC_NM LOC_NAME_POR," ).append("\n"); 
		query.append("  L1.CNT_CD LOC_CNT_CD_POR," ).append("\n"); 
		query.append("  C1.CNT_NM LOC_CNT_NAME_POR," ).append("\n"); 
		query.append("  'POL' LOC_TP_CD_POL," ).append("\n"); 
		query.append("  B.POL_CD LOC_CD_POL," ).append("\n"); 
		query.append("  L2.LOC_NM LOC_NAME_POL," ).append("\n"); 
		query.append("  L2.CNT_CD LOC_CNT_CD_POL," ).append("\n"); 
		query.append("  C2.CNT_NM LOC_CNT_NAME_POL," ).append("\n"); 
		query.append("  'POD' LOC_TP_CD_POD," ).append("\n"); 
		query.append("  B.POD_CD LOC_CD_POD," ).append("\n"); 
		query.append("  L3.LOC_NM LOC_NAME_POD," ).append("\n"); 
		query.append("  L3.CNT_CD LOC_CNT_CD_POD," ).append("\n"); 
		query.append("  C3.CNT_NM LOC_CNT_NAME_POD," ).append("\n"); 
		query.append("  'DEL' LOC_TP_CD_DEL," ).append("\n"); 
		query.append("  B.DEL_CD LOC_CD_DEL," ).append("\n"); 
		query.append("  L4.LOC_NM LOC_NAME_DEL," ).append("\n"); 
		query.append("  L4.CNT_CD LOC_CNT_CD_DEL," ).append("\n"); 
		query.append("  C4.CNT_NM LOC_CNT_NAME_DEL," ).append("\n"); 
		query.append("  'T001' CS_MEA_CD," ).append("\n"); 
		query.append("  B.GRS_CNTR_WGT MEA_QTY," ).append("\n"); 
		query.append("  'KG' MEA_CD," ).append("\n"); 
		query.append("  B.MSG_ID MSG_ID_BL," ).append("\n"); 
		query.append("  B.MSG_NO MSG_NO_BL," ).append("\n"); 
		query.append("  B.BL_LINE_NO BL_LINE_NO_BL," ).append("\n"); 
		query.append("  B.BL_SRC_NO BL_SRC_NO_BL" ).append("\n"); 
		query.append("FROM INV_AR_EDI_GERP_HDR A," ).append("\n"); 
		query.append("  INV_AR_EDI_GERP_BL B," ).append("\n"); 
		query.append("  INV_AR_MN D," ).append("\n"); 
		query.append("  MDM_LOCATION L1," ).append("\n"); 
		query.append("  MDM_COUNTRY C1," ).append("\n"); 
		query.append("  MDM_LOCATION L2," ).append("\n"); 
		query.append("  MDM_COUNTRY C2," ).append("\n"); 
		query.append("  MDM_LOCATION L3," ).append("\n"); 
		query.append("  MDM_COUNTRY C3," ).append("\n"); 
		query.append("  MDM_LOCATION L4," ).append("\n"); 
		query.append("  MDM_COUNTRY C4" ).append("\n"); 
		query.append("WHERE A.MSG_ID = B.MSG_ID" ).append("\n"); 
		query.append("  AND A.MSG_NO = B.MSG_NO" ).append("\n"); 
		query.append("  AND B.BL_SRC_NO = D.BL_SRC_NO" ).append("\n"); 
		query.append("  AND A.CUST_CNT_CD = D.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("  AND A.CUST_SEQ = D.ACT_CUST_SEQ" ).append("\n"); 
		query.append("  AND L1.LOC_CD = B.POR_CD" ).append("\n"); 
		query.append("  AND L1.CNT_CD = C1.CNT_CD" ).append("\n"); 
		query.append("  AND L2.LOC_CD = B.POL_CD" ).append("\n"); 
		query.append("  AND L2.CNT_CD = C2.CNT_CD" ).append("\n"); 
		query.append("  AND L3.LOC_CD = B.POD_CD" ).append("\n"); 
		query.append("  AND L3.CNT_CD = C3.CNT_CD" ).append("\n"); 
		query.append("  AND L4.LOC_CD = B.DEL_CD" ).append("\n"); 
		query.append("  AND L4.CNT_CD = C4.CNT_CD" ).append("\n"); 
		query.append("  AND A.MSG_ID = @[msg_id]" ).append("\n"); 
		query.append("  AND A.MSG_NO = @[msg_no]" ).append("\n"); 
		query.append("  AND B.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}