/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchSamsungAREDIMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.10.15 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchSamsungAREDIMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * message no로  생성된  삼성전자의 EDI 전송할 정보를 조회한다.
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchSamsungAREDIMainRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchSamsungAREDIMainRSQL").append("\n"); 
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
		query.append("SELECT A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("A.CUST_CNT_CD," ).append("\n"); 
		query.append("A.CUST_SEQ," ).append("\n"); 
		query.append("A.MSG_NM," ).append("\n"); 
		query.append("A.MSG_NO," ).append("\n"); 
		query.append("A.INV_XCH_RT," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(MIN(A.SAIL_ARR_DT), 'YYYYMMDD'), 'YYYY-MM-DD') SAIL_ARR_DT," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(A.BIL_DT, 'YYYYMMDD'), 'YYYY-MM-DD') BIL_DT," ).append("\n"); 
		query.append("A.BIL_USD_AMT," ).append("\n"); 
		query.append("A.BIL_KRW_AMT," ).append("\n"); 
		query.append("MIN(A.INV_MSG_FUNC_CD) INV_MSG_FUNC_CD," ).append("\n"); 
		query.append("D.LOCL_NM," ).append("\n"); 
		query.append("DECODE(B.INDIV_CORP_DIV_CD, 'C', CASE WHEN LENGTH(B.CUST_RGST_NO) = 10 THEN SUBSTR(B.CUST_RGST_NO, 0, 3)||'-'||SUBSTR(B.CUST_RGST_NO, 4, 2)||'-'||SUBSTR(B.CUST_RGST_NO, 6, 5) ELSE B.CUST_RGST_NO END, 'P', CASE WHEN LENGTH(B.CUST_RGST_NO) = 13 THEN SUBSTR(B.CUST_RGST_NO, 0, 6) ||'-'||SUBSTR(B.CUST_RGST_NO, 7, 13) ELSE B.CUST_RGST_NO END) CUST_RGST_NO," ).append("\n"); 
		query.append("CASE WHEN A.CUST_CNT_CD = 'KR' AND A.CUST_SEQ = '38221' THEN '1248100998' ELSE '8504187111' END E_SIGN," ).append("\n"); 
		query.append("D.LOCL_ADDR1," ).append("\n"); 
		query.append("D.LOCL_ADDR2," ).append("\n"); 
		query.append("D.OWNR_NM," ).append("\n"); 
		query.append("A.SREP_NM," ).append("\n"); 
		query.append("A.RCVR_PHN_NO," ).append("\n"); 
		query.append("A.EDI_HDR_RMK," ).append("\n"); 
		query.append("A.SND_FLG" ).append("\n"); 
		query.append("FROM INV_AR_EDI_GERP_HDR A," ).append("\n"); 
		query.append("MDM_CUSTOMER B," ).append("\n"); 
		query.append("MDM_CUST_ADDR C," ).append("\n"); 
		query.append("MDM_CR_CUST D," ).append("\n"); 
		query.append("MDM_CUST_CNTC_PNT E" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ = B.CUST_SEQ (+)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = C.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ = C.CUST_SEQ (+)" ).append("\n"); 
		query.append("AND C.PRMRY_CHK_FLG (+) = 'Y'" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = D.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ = D.CUST_SEQ (+)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD = E.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ = E.CUST_SEQ (+)" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.MSG_ID = @[msg_id]" ).append("\n"); 
		query.append("AND A.MSG_NO = @[msg_no]" ).append("\n"); 
		query.append("GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CUST_CNT_CD, A.CUST_SEQ, A.MSG_NM, A.MSG_NO, A.INV_XCH_RT, A.BIL_DT, A.BIL_USD_AMT, A.BIL_KRW_AMT, D.LOCL_NM, B.CUST_RGST_NO, B.INDIV_CORP_DIV_CD, D.LOCL_ADDR1, D.LOCL_ADDR2, D.OWNR_NM, A.SREP_NM, A.RCVR_PHN_NO, A.EDI_HDR_RMK, A.SND_FLG" ).append("\n"); 

	}
}