/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : StatusInquiryDBDAOSearchInformationOnPendingTPBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.04
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2013.06.04 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Shin Ja Young
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
	  * [SRM-201336161] [TPB] DXBBB 및 산하 점소들 전체의 Long pending TPB 현황 팝업 관련
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
		query.append("Path : com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.integration").append("\n"); 
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
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND c.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("AND c.n3pty_bil_tp_cd IN (SELECT n3pty_bil_tp_cd FROM TPB_N3RD_PTY_BIL_TP WHERE act_flg='Y' AND n3pty_bil_tp_cd!='JO')" ).append("\n"); 
		query.append("AND c.cxl_flg = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${user_id} == 'gcc003'|| ${user_id} == 'gcc014')" ).append("\n"); 
		query.append("AND NVL(c.ofc_cd,c.if_ofc_cd) IN ('JEDBA', 'DMNBA', 'THRBA', 'KWIBA', 'OMNBA', 'AUHBA', 'DOHBA', 'BAHBA', 'JORBA', 'IRQBA')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND NVL(c.ofc_cd,c.if_ofc_cd) IN (@[user_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#if (${user_id} == 'gcc003'|| ${user_id} == 'gcc014')" ).append("\n"); 
		query.append("AND A.OFC_CD IN ('JEDBA', 'DMNBA', 'THRBA', 'KWIBA', 'OMNBA', 'AUHBA', 'DOHBA', 'BAHBA', 'JORBA', 'IRQBA')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.OFC_CD IN (@[user_ofc_cd]) --- TPB OFFICE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--2009-06-25 O Wan-Ki      1.9 [S1V-09P-001] TPB Restructuring 2단계 (Invoice 부분) 보완개발 추가요청 처리." ).append("\n"); 
		query.append("AND A.cxl_flg IS NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("------ FOR INVOICE -------------------------" ).append("\n"); 
		query.append("SELECT  DECODE(cpy_no,0, NO1,1,NO2,2,NO3) no" ).append("\n"); 
		query.append(", DECODE(cpy_no,0, TITLE1, 1, TITLE2, 2, TITLE3) Title" ).append("\n"); 
		query.append(", DECODE(cpy_no,0, CNT1, 1, CNT2, 2, CNT3) CNT" ).append("\n"); 
		query.append(", DECODE(cpy_no,0, AMT1, 1, AMT2, 2, AMT3) AMT" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("2 no1" ).append("\n"); 
		query.append(",'For Invoicing' title1" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("SUM(CASE WHEN (C.OTS_STS_CD IN ('O', 'M', 'J'))" ).append("\n"); 
		query.append("AND (B.VNDR_CUST_DIV_CD IN ('V' , 'C'))" ).append("\n"); 
		query.append("THEN COUNT(0)  END) CNT1" ).append("\n"); 
		query.append(", SUM(CASE WHEN (C.OTS_STS_CD IN ('O', 'M', 'J'))" ).append("\n"); 
		query.append("AND (B.VNDR_CUST_DIV_CD IN ('V' , 'C'))" ).append("\n"); 
		query.append("THEN SUM( TPB_GET_USD_AMT_FNC( BAL_AMT, CURR_CD, CFM_DT ) ) END) AMT1" ).append("\n"); 
		query.append(", 3 no2" ).append("\n"); 
		query.append(",'For ERP I/F' title2" ).append("\n"); 
		query.append(", SUM(CASE WHEN  C.OTS_STS_CD = 'I'THEN COUNT(0) END) CNT2" ).append("\n"); 
		query.append(", SUM(CASE WHEN  C.OTS_STS_CD = 'I'THEN SUM( TPB_GET_USD_AMT_FNC( BAL_AMT, CURR_CD, CFM_DT ) ) END) AMT2" ).append("\n"); 
		query.append(", 4 no3" ).append("\n"); 
		query.append(",'For ROC Request' title3" ).append("\n"); 
		query.append(", SUM(CASE WHEN (C.OTS_STS_CD = 'O'" ).append("\n"); 
		query.append("AND B.VNDR_CUST_DIV_CD = 'S') THEN COUNT(0) END) CNT3" ).append("\n"); 
		query.append(", SUM(CASE WHEN (C.OTS_STS_CD = 'O'" ).append("\n"); 
		query.append("AND B.VNDR_CUST_DIV_CD = 'S') THEN SUM( TPB_GET_USD_AMT_FNC( BAL_AMT, CURR_CD, CFM_DT ) ) END) AMT3" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP B, TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND B.n3pty_bil_tp_cd IN (" ).append("\n"); 
		query.append("SELECT n3pty_bil_tp_cd" ).append("\n"); 
		query.append("FROM TPB_N3RD_PTY_BIL_TP" ).append("\n"); 
		query.append("WHERE act_flg = 'Y'" ).append("\n"); 
		query.append("AND n3pty_bil_tp_cd <> 'JO' )" ).append("\n"); 
		query.append("AND b.n3pty_no = c.n3pty_no" ).append("\n"); 
		query.append("AND C.ots_sts_lst_flg = 'Y'" ).append("\n"); 
		query.append("AND B.n3pty_delt_tp_cd IN ('N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${user_id} == 'gcc003'|| ${user_id} == 'gcc014')" ).append("\n"); 
		query.append("AND B.OFC_CD IN ('JEDBA', 'DMNBA', 'THRBA', 'KWIBA', 'OMNBA', 'AUHBA', 'DOHBA', 'BAHBA', 'JORBA', 'IRQBA')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND B.ofc_cd IN (@[user_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY C.OTS_STS_CD, B.VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append(") sub," ).append("\n"); 
		query.append("( select cpy_no   from com_cpy_no where cpy_no <3) cpy" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("#if (${user_id} == 'gcc003'|| ${user_id} == 'gcc014')" ).append("\n"); 
		query.append("AND STL_TO_CLT_CNG_OFC_CD IN ('JEDBA', 'DMNBA', 'THRBA', 'KWIBA', 'OMNBA', 'AUHBA', 'DOHBA', 'BAHBA', 'JORBA', 'IRQBA')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND STL_TO_CLT_CNG_OFC_CD IN (@[user_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND E.STL_APRO_DT IS NULL AND E.STL_RJCT_DT IS NULL" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("GROUP BY ROLLUP(TITLE)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY decode(title,'(Total)',6,sort)" ).append("\n"); 

	}
}