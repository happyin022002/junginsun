/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchSamsungARInvoiceMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.13 
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

public class AccountReceivableEDISendDBDAOSearchSamsungARInvoiceMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회조건  VVD 및  Customer에 해당하는  SHARC(AR_HD_QTR_OFC_CD) 인 EDI 전송가능한 대상 main 정보를 조회한다.
	  * INV_AR_MN 및 MDM_CUSTOMER 테이블에서 조회조건으로 조회함.
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchSamsungARInvoiceMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchSamsungARInvoiceMainRSQL").append("\n"); 
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
		query.append("  A.ACT_CUST_CNT_CD CUST_CNT_CD," ).append("\n"); 
		query.append("  A.ACT_CUST_SEQ CUST_SEQ," ).append("\n"); 
		query.append("  'FREINV' MSG_NM," ).append("\n"); 
		query.append("  '' MSG_NO," ).append("\n"); 
		query.append("  A.USD_XCH_RT INV_XCH_RT," ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(MAX(A.SAIL_ARR_DT), 'YYYYMMDD'), 'YYYY-MM-DD') SAIL_ARR_DT," ).append("\n"); 
		query.append("  TO_CHAR(SYSDATE, 'YYYY-MM-DD') BIL_DT," ).append("\n"); 
		query.append("  '9' INV_MSG_FUNC_CD," ).append("\n"); 
		query.append("  D.LOCL_NM," ).append("\n"); 
		query.append("  DECODE(B.INDIV_CORP_DIV_CD, 'C', CASE WHEN LENGTH(B.CUST_RGST_NO) = 10 THEN SUBSTR(B.CUST_RGST_NO, 0, 3)||'-'||SUBSTR(B.CUST_RGST_NO, 4, 2)||'-'||SUBSTR(B.CUST_RGST_NO, 6, 5) ELSE B.CUST_RGST_NO END, 'P', CASE WHEN LENGTH(B.CUST_RGST_NO) = 13 THEN SUBSTR(B.CUST_RGST_NO, 0, 6) ||'-'||SUBSTR(B.CUST_RGST_NO, 7, 13) ELSE B.CUST_RGST_NO END) CUST_RGST_NO," ).append("\n"); 
		query.append("  CASE WHEN A.ACT_CUST_CNT_CD = 'KR' AND A.ACT_CUST_SEQ = '38221' THEN '1248100998' ELSE '8504187111' END E_SIGN," ).append("\n"); 
		query.append("  D.LOCL_ADDR1," ).append("\n"); 
		query.append("  D.LOCL_ADDR2," ).append("\n"); 
		query.append("  D.OWNR_NM," ).append("\n"); 
		query.append("  F.SREP_NM," ).append("\n"); 
		query.append("  E.PHN_NO RCVR_PHN_NO," ).append("\n"); 
		query.append("  A.INV_RMK EDI_HDR_RMK," ).append("\n"); 
		query.append("  'N' SND_FLG," ).append("\n"); 
		query.append("  'Y' GERP_VAL_FLG" ).append("\n"); 
		query.append("FROM INV_AR_MN A," ).append("\n"); 
		query.append("  MDM_CUSTOMER B," ).append("\n"); 
		query.append("  MDM_CUST_ADDR C," ).append("\n"); 
		query.append("  MDM_CR_CUST D," ).append("\n"); 
		query.append("  MDM_CUST_CNTC_PNT E," ).append("\n"); 
		query.append("  MDM_SLS_REP F" ).append("\n"); 
		query.append("WHERE A.ACT_CUST_CNT_CD = B.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = B.CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_CNT_CD = C.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = C.CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND C.PRMRY_CHK_FLG (+) = 'Y'" ).append("\n"); 
		query.append("  AND A.ACT_CUST_CNT_CD = D.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = D.CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_CNT_CD = E.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = E.CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND B.SREP_CD = F.SREP_CD (+)" ).append("\n"); 
		query.append("  AND A.AR_OFC_CD IN (" ).append("\n"); 
		query.append("    SELECT OFC_CD" ).append("\n"); 
		query.append("    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("    WHERE AR_HD_QTR_OFC_CD IN ('SHARC','SELIB')" ).append("\n"); 
		query.append("      AND SUBSTR(LOC_CD, 1, 2) = 'KR'" ).append("\n"); 
		query.append("      AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("  AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("  AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("  AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("  AND A.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("  AND A.INV_TTL_LOCL_AMT > 0" ).append("\n"); 
		query.append("  AND A.AR_IF_NO = (" ).append("\n"); 
		query.append("    SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("    FROM INV_AR_MN" ).append("\n"); 
		query.append("    WHERE AR_OFC_CD IN (" ).append("\n"); 
		query.append("        SELECT OFC_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE AR_HD_QTR_OFC_CD IN ('SHARC','SELIB')" ).append("\n"); 
		query.append("          AND SUBSTR(LOC_CD, 1, 2) = 'KR'" ).append("\n"); 
		query.append("          AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("      AND ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("      AND ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("      AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("      AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("      AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("      AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("      AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("      AND INV_TTL_LOCL_AMT > 0)" ).append("\n"); 
		query.append("GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.USD_XCH_RT, A.SAIL_ARR_DT, D.LOCL_NM, B.CUST_RGST_NO, B.INDIV_CORP_DIV_CD, D.LOCL_ADDR1, D.LOCL_ADDR2, D.OWNR_NM, F.SREP_NM, E.PHN_NO, A.INV_RMK" ).append("\n"); 

	}
}