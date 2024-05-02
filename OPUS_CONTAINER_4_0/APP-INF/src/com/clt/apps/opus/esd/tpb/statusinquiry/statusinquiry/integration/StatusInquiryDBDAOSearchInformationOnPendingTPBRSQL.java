/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StatusInquiryDBDAOSearchInformationOnPendingTPBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.01.14 변종건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusInquiryDBDAOSearchInformationOnPendingTPBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Information On Pending TPB
	  * </pre>
	  */
	public StatusInquiryDBDAOSearchInformationOnPendingTPBRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.integration").append("\n"); 
		query.append("FileName : StatusInquiryDBDAOSearchInformationOnPendingTPBRSQL").append("\n"); 
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
		query.append("SELECT title, cnt, amt" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT NVL(TITLE,'(Total)') title" ).append("\n"); 
		query.append(",NVL(SUM(CNT),0) cnt, NVL(SUM(AMT),0.00) amt, MAX(NO) sort" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("--		2009-04-09 O Wan0Ki      1.8 N200903170210, S/O Cancel Notice 추가." ).append("\n"); 
		query.append("------ FOR S/O Cancellation Notice -------------------------" ).append("\n"); 
		query.append("SELECT 0 no" ).append("\n"); 
		query.append(",'For Cancellation Notice' title" ).append("\n"); 
		query.append(",COUNT(0) CNT" ).append("\n"); 
		query.append(",SUM( TPB_GET_USD_AMT_FNC( c.if_amt, c.if_curr_cd, SYSDATE ) ) AMT" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL c" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT so_no, if_ofc_cd, src_if_seq_no, if_amt, ofc_cd" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL" ).append("\n"); 
		query.append("WHERE n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("AND cxl_flg IS NULL" ).append("\n"); 
		query.append(") d" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND c.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("AND c.n3pty_bil_tp_cd IN (SELECT n3pty_bil_tp_cd FROM TPB_N3RD_PTY_BIL_TP WHERE act_flg='Y' AND n3pty_bil_tp_cd!='JO')" ).append("\n"); 
		query.append("AND c.cxl_flg = 'Y'" ).append("\n"); 
		query.append("AND d.so_no = c.so_no" ).append("\n"); 
		query.append("AND d.if_ofc_cd = c.if_ofc_cd" ).append("\n"); 
		query.append("AND d.src_if_seq_no = c.src_if_seq_no" ).append("\n"); 
		query.append("AND d.if_amt = c.if_amt" ).append("\n"); 
		query.append("AND NVL(d.ofc_cd,c.if_ofc_cd) IN (@[user_ofc_cd])" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("------ FOR CONFIRMATION -------------------------" ).append("\n"); 
		query.append("SELECT 1 no" ).append("\n"); 
		query.append(",'For Confirmation' title" ).append("\n"); 
		query.append(",COUNT(0) CNT" ).append("\n"); 
		query.append(",SUM( TPB_GET_USD_AMT_FNC( IF_AMT, IF_CURR_CD, SYSDATE ) ) AMT" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.n3pty_delt_tp_cd IN ('N','S')" ).append("\n"); 
		query.append("AND A.n3pty_bil_tp_cd IN ( SELECT n3pty_bil_tp_cd FROM TPB_N3RD_PTY_BIL_TP WHERE act_flg = 'Y' AND n3pty_bil_tp_cd <> 'JO' )" ).append("\n"); 
		query.append("AND N3PTY_CFM_CD IN ('I','R')  -- 'N', 'Y'" ).append("\n"); 
		query.append("AND A.OFC_CD IN (@[user_ofc_cd]) --- TPB OFFICE" ).append("\n"); 
		query.append("--2009-06-25 O Wan-Ki      1.9 [S1V-09P-001] TPB Restructuring 2단계 (Invoice 부분) 보완개발 추가요청 처리." ).append("\n"); 
		query.append("AND A.cxl_flg IS NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("------ FOR INVOICE -------------------------" ).append("\n"); 
		query.append("SELECT 2 no" ).append("\n"); 
		query.append(",'For Invoicing' title" ).append("\n"); 
		query.append(",COUNT(0) CNT" ).append("\n"); 
		query.append(",SUM( TPB_GET_USD_AMT_FNC( BAL_AMT, CURR_CD, SYSDATE ) ) AMT" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP B, TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND B.n3pty_bil_tp_cd IN ( SELECT n3pty_bil_tp_cd FROM TPB_N3RD_PTY_BIL_TP WHERE act_flg = 'Y' AND n3pty_bil_tp_cd <> 'JO' )" ).append("\n"); 
		query.append("AND b.n3pty_no = c.n3pty_no" ).append("\n"); 
		query.append("AND C.ots_sts_lst_flg = 'Y'" ).append("\n"); 
		query.append("AND B.n3pty_delt_tp_cd IN ('N')" ).append("\n"); 
		query.append("AND C.OTS_STS_CD IN ('O','M','J')" ).append("\n"); 
		query.append("AND B.VNDR_CUST_DIV_CD IN ('V','C')" ).append("\n"); 
		query.append("AND B.ofc_cd IN (@[user_ofc_cd])" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("------ FOR ERP I/F -------------------------" ).append("\n"); 
		query.append("SELECT 3 no" ).append("\n"); 
		query.append(",'For ERP I/F' title" ).append("\n"); 
		query.append(",COUNT(0) CNT" ).append("\n"); 
		query.append(",SUM( TPB_GET_USD_AMT_FNC( BAL_AMT, CURR_CD, CFM_DT ) ) AMT" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP B, TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND B.n3pty_bil_tp_cd IN ( SELECT n3pty_bil_tp_cd FROM TPB_N3RD_PTY_BIL_TP WHERE act_flg = 'Y' AND n3pty_bil_tp_cd <> 'JO' )" ).append("\n"); 
		query.append("AND b.n3pty_no = c.n3pty_no" ).append("\n"); 
		query.append("AND C.ots_sts_lst_flg = 'Y'" ).append("\n"); 
		query.append("AND B.n3pty_delt_tp_cd IN ('N')" ).append("\n"); 
		query.append("AND C.OTS_STS_CD IN ('I')" ).append("\n"); 
		query.append("AND B.ofc_cd IN (@[user_ofc_cd])" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("------ FOR ROC -------------------------" ).append("\n"); 
		query.append("SELECT 4 no" ).append("\n"); 
		query.append(",'For ROC Request' title" ).append("\n"); 
		query.append(",COUNT(0) CNT" ).append("\n"); 
		query.append(",SUM( TPB_GET_USD_AMT_FNC( BAL_AMT, CURR_CD, CFM_DT ) ) AMT" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP B, TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND B.n3pty_bil_tp_cd IN ( SELECT n3pty_bil_tp_cd FROM TPB_N3RD_PTY_BIL_TP WHERE act_flg = 'Y' AND n3pty_bil_tp_cd <> 'JO' )" ).append("\n"); 
		query.append("AND b.n3pty_no = c.n3pty_no" ).append("\n"); 
		query.append("AND C.ots_sts_lst_flg = 'Y'" ).append("\n"); 
		query.append("AND B.n3pty_delt_tp_cd IN ('N')" ).append("\n"); 
		query.append("AND C.OTS_STS_CD IN ('O')" ).append("\n"); 
		query.append("AND B.VNDR_CUST_DIV_CD IN ('S')" ).append("\n"); 
		query.append("AND B.ofc_cd IN (@[user_ofc_cd])" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("------ FOR ROC APPROVAL -------------------------" ).append("\n"); 
		query.append("SELECT 5 no" ).append("\n"); 
		query.append(",'For ROC Approval' title" ).append("\n"); 
		query.append(",COUNT(0) CNT" ).append("\n"); 
		query.append(",SUM( TPB_GET_USD_AMT_FNC( BAL_AMT, CURR_CD, CFM_DT ) ) AMT" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP B, TPB_OTS_GRP_STS C, TPB_ADJ_STS E" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND b.n3pty_no = c.n3pty_no" ).append("\n"); 
		query.append("AND B.n3pty_no = E.n3pty_no" ).append("\n"); 
		query.append("AND B.n3pty_bil_tp_cd IN ( SELECT n3pty_bil_tp_cd FROM TPB_N3RD_PTY_BIL_TP WHERE act_flg = 'Y' AND n3pty_bil_tp_cd <> 'JO' )" ).append("\n"); 
		query.append("AND B.n3pty_delt_tp_cd IN ('N')" ).append("\n"); 
		query.append("AND C.ots_sts_lst_flg = 'Y'" ).append("\n"); 
		query.append("AND E.STL_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND C.OTS_STS_CD IN ('R')" ).append("\n"); 
		query.append("AND E.N3PTY_STL_TP_CD IN ('O')" ).append("\n"); 
		query.append("AND STL_TO_CLT_CNG_OFC_CD IN (@[user_ofc_cd])" ).append("\n"); 
		query.append("AND E.STL_APRO_DT IS NULL AND E.STL_RJCT_DT IS NULL" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("GROUP BY ROLLUP(TITLE)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY decode(title,'(Total)',6,sort)" ).append("\n"); 

	}
}