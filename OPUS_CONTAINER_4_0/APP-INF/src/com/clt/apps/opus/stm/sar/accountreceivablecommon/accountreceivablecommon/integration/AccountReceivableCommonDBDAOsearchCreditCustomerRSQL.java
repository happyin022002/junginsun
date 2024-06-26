/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchCreditCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOsearchCreditCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCreditCustomer
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchCreditCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_cust_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration ").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOsearchCreditCustomerRSQL").append("\n"); 
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
		query.append("	A.CUST_CNT_CD" ).append("\n"); 
		query.append(",   LPAD(A.CUST_SEQ,6,'0') CUST_SEQ" ).append("\n"); 
		query.append(",	A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",	A.CUST_LGL_ENG_NM as CUST_LGL_ENG_NM2" ).append("\n"); 
		query.append(",	A.CUST_RGST_NO" ).append("\n"); 
		query.append(",	A.CUST_RGST_NO AS CUST_RGST_NO2" ).append("\n"); 
		query.append(",	C.BZET_ADDR" ).append("\n"); 
		query.append(",	C.ZIP_CD" ).append("\n"); 
		query.append(",	D.PHN_NO" ).append("\n"); 
		query.append(",	D.FAX_NO" ).append("\n"); 
		query.append(",	A.OFC_CD" ).append("\n"); 
		query.append(",   I.CNT_CD" ).append("\n"); 
		query.append(",   J.STE_NM" ).append("\n"); 
		query.append(",   C.CTY_NM" ).append("\n"); 
		query.append(",	A.CUST_RMK" ).append("\n"); 
		query.append(",	B.CR_CURR_CD" ).append("\n"); 
		query.append(",	B.CR_AMT" ).append("\n"); 
		query.append(",   TO_CHAR(TO_DATE(B.CR_ST_DT,'YYYY-MM-DD'),'YYYY-MM-DD') CR_ST_DT" ).append("\n"); 
		query.append(",   TO_CHAR(TO_DATE(B.CR_END_DT,'YYYY-MM-DD'),'YYYY-MM-DD') CR_END_DT" ).append("\n"); 
		query.append(",	B.CR_CLT_OFC_CD" ).append("\n"); 
		query.append(",	B.IB_CR_TERM_DYS" ).append("\n"); 
		query.append(",	B.OB_CR_TERM_DYS" ).append("\n"); 
		query.append(",	B.CUST_RLSE_CTRL_FLG" ).append("\n"); 
		query.append(",	B.CNTC_PSON_NM" ).append("\n"); 
		query.append(",	B.XCH_RT_DIV_CD" ).append("\n"); 
		query.append(",	B.CNG_INDIV_CD" ).append("\n"); 
		query.append(",	B.ACT_CUST_CNT_CD||LPAD(B.ACT_CUST_SEQ,6,'0') ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",	B.ACT_CUST_SEQ" ).append("\n"); 
		query.append(",	B.OB_EML" ).append("\n"); 
		query.append(",	B.IB_EML" ).append("\n"); 
		query.append(",	B.CR_CUST_RMK" ).append("\n"); 
		query.append(",	DECODE(B.PAY_DIV_CD,'B','Bill','T','Transfer') PAY_DIV_CD" ).append("\n"); 
		query.append(",	B.BANK_ACCT_NO" ).append("\n"); 
		query.append(",	B.OWNR_NM" ).append("\n"); 
		query.append(",	A.CUST_RGST_NO AS TVA_NO" ).append("\n"); 
		query.append(",	B.BZCT_NM" ).append("\n"); 
		query.append(",	B.BZTP_NM" ).append("\n"); 
		query.append(",	B.LOCL_NM" ).append("\n"); 
		query.append(",    DECODE(A.INDIV_CORP_DIV_CD, NULL, '', A.INDIV_CORP_DIV_CD || ' : ' || DECODE(A.INDIV_CORP_DIV_CD,'C','Company','P','Private')) INDIV_CORP_DIV_CD" ).append("\n"); 
		query.append(",    DECODE(C.CUST_CNT_CD, 'TB', C.LOCL_ADDR1, B.LOCL_ADDR1) LOCL_ADDR1" ).append("\n"); 
		query.append(",    DECODE(C.CUST_CNT_CD, 'TB', C.LOCL_ADDR2, B.LOCL_ADDR2) LOCL_ADDR2" ).append("\n"); 
		query.append(",    DECODE(C.CUST_CNT_CD, 'TB', C.LOCL_ADDR3, B.LOCL_ADDR3) LOCL_ADDR3" ).append("\n"); 
		query.append(",    DECODE(C.CUST_CNT_CD, 'TB', C.LOCL_ADDR4, B.LOCL_ADDR4) LOCL_ADDR4" ).append("\n"); 
		query.append(",    DECODE(B.CR_CUST_TP_CD, NULL, '', B.CR_CUST_TP_CD || ' : ' || DECODE(B.CR_CUST_TP_CD,'F','Forwarder','G','대기업계열사','L','상장회사','O','Others','S','면방업체')) CR_CUST_TP_CD" ).append("\n"); 
		query.append("--,	B.KR_IB_OFC_CD" ).append("\n"); 
		query.append(",	B.LOCL_ZIP_CD" ).append("\n"); 
		query.append(",	NVL(B.OB_PHN_NO,B.IB_PHN_NO) OB_PHN_NO" ).append("\n"); 
		query.append(",	NVL(B.OB_FAX_NO,B.IB_FAX_NO) OB_FAX_NO" ).append("\n"); 
		query.append(",	'' CUST_SCR_DIV_CD" ).append("\n"); 
		query.append(",	'' CUST_SCR_LOCL_AMT" ).append("\n"); 
		query.append(",   '' SCR_ST_DT" ).append("\n"); 
		query.append(",   '' SCR_END_DT" ).append("\n"); 
		query.append(",	DECODE(B.ISS_DIV_CD,'I','INTERNET','P','PAPER','E','EDI','V','VIETNAM') ISS_DIV_CD" ).append("\n"); 
		query.append(",	B.CUST_CR_DUE_DT_DIV_CD" ).append("\n"); 
		query.append(",	B.PAY_DT_DY1" ).append("\n"); 
		query.append(",	B.PAY_DT_DY2" ).append("\n"); 
		query.append(",	B.PAY_DT_DY3" ).append("\n"); 
		query.append(",	B.PAY_DT_DY4" ).append("\n"); 
		query.append(",	A.DELT_FLG" ).append("\n"); 
		query.append(",	B.INV_DUE_DT_DP_FLG" ).append("\n"); 
		query.append("FROM    MDM_CUSTOMER A, MDM_CR_CUST B" ).append("\n"); 
		query.append("    , MDM_CUST_ADDR C, MDM_CUST_CNTC_PNT D" ).append("\n"); 
		query.append("    , MDM_COUNTRY I, MDM_STATE J" ).append("\n"); 
		query.append("WHERE   A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND     A.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND    A.CUST_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND     A.CUST_SEQ = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND    A.CUST_CNT_CD = D.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND     A.CUST_SEQ = D.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND     C.CNT_CD = I.CNT_CD(+)" ).append("\n"); 
		query.append("AND     C.CNT_CD = J.CNT_CD(+)" ).append("\n"); 
		query.append("AND     C.STE_CD = J.STE_CD(+)" ).append("\n"); 
		query.append("AND     C.PRMRY_CHK_FLG(+)='Y'" ).append("\n"); 
		query.append("--AND 	NVL(A.BLK_DIV_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(A.CNTR_DIV_FLG,'N') ='Y' --2010-06-04 김현화수석" ).append("\n"); 
		query.append("#if (${frm_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("AND     A.CUST_CNT_CD = UPPER(@[frm_cust_cnt_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${frm_cust_seq} != '')" ).append("\n"); 
		query.append("AND     A.CUST_SEQ = @[frm_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${frm_cust_rgst_no} != '' && ${frm_cust_seq} == '')" ).append("\n"); 
		query.append("AND     A.CUST_RGST_NO = REPLACE(@[frm_cust_rgst_no],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.CUST_CNT_CD" ).append("\n"); 
		query.append(",   LPAD(A.CUST_SEQ,6,'0')" ).append("\n"); 
		query.append(",    A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",    A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",    A.CUST_RGST_NO" ).append("\n"); 
		query.append(",    A.CUST_RGST_NO" ).append("\n"); 
		query.append(",    C.BZET_ADDR" ).append("\n"); 
		query.append(",    C.ZIP_CD" ).append("\n"); 
		query.append(",    D.PHN_NO" ).append("\n"); 
		query.append(",    D.FAX_NO" ).append("\n"); 
		query.append(",    A.OFC_CD" ).append("\n"); 
		query.append(",    I.CNT_CD" ).append("\n"); 
		query.append(",    J.STE_NM" ).append("\n"); 
		query.append(",    C.CTY_NM" ).append("\n"); 
		query.append(",    A.CUST_RMK" ).append("\n"); 
		query.append(",    B.CR_CURR_CD" ).append("\n"); 
		query.append(",    B.CR_AMT" ).append("\n"); 
		query.append(",   TO_CHAR(TO_DATE(B.CR_ST_DT,'YYYY-MM-DD'),'YYYY-MM-DD')" ).append("\n"); 
		query.append(",   TO_CHAR(TO_DATE(B.CR_END_DT,'YYYY-MM-DD'),'YYYY-MM-DD')" ).append("\n"); 
		query.append(",    B.CR_CLT_OFC_CD" ).append("\n"); 
		query.append(",    B.IB_CR_TERM_DYS" ).append("\n"); 
		query.append(",    B.OB_CR_TERM_DYS" ).append("\n"); 
		query.append(",    B.CUST_RLSE_CTRL_FLG" ).append("\n"); 
		query.append(",    B.CNTC_PSON_NM" ).append("\n"); 
		query.append(",    B.XCH_RT_DIV_CD" ).append("\n"); 
		query.append(",	 B.CNG_INDIV_CD" ).append("\n"); 
		query.append(",    B.ACT_CUST_CNT_CD||LPAD(B.ACT_CUST_SEQ,6,'0')" ).append("\n"); 
		query.append(",    B.ACT_CUST_SEQ" ).append("\n"); 
		query.append(",    B.OB_EML" ).append("\n"); 
		query.append(",    B.IB_EML" ).append("\n"); 
		query.append(",    B.CR_CUST_RMK" ).append("\n"); 
		query.append(",    DECODE(B.PAY_DIV_CD,'B','Bill','T','Transfer')" ).append("\n"); 
		query.append(",    B.BANK_ACCT_NO" ).append("\n"); 
		query.append(",    B.OWNR_NM" ).append("\n"); 
		query.append(",    A.CUST_RGST_NO" ).append("\n"); 
		query.append(",    B.BZCT_NM" ).append("\n"); 
		query.append(",    B.BZTP_NM" ).append("\n"); 
		query.append(",    B.LOCL_NM" ).append("\n"); 
		query.append(",    A.INDIV_CORP_DIV_CD" ).append("\n"); 
		query.append(",    DECODE(C.CUST_CNT_CD, 'TB', C.LOCL_ADDR1, B.LOCL_ADDR1)" ).append("\n"); 
		query.append(",    DECODE(C.CUST_CNT_CD, 'TB', C.LOCL_ADDR2, B.LOCL_ADDR2)" ).append("\n"); 
		query.append(",    DECODE(C.CUST_CNT_CD, 'TB', C.LOCL_ADDR3, B.LOCL_ADDR3)" ).append("\n"); 
		query.append(",    DECODE(C.CUST_CNT_CD, 'TB', C.LOCL_ADDR4, B.LOCL_ADDR4)" ).append("\n"); 
		query.append(",    B.CR_CUST_TP_CD" ).append("\n"); 
		query.append("--,    B.KR_IB_OFC_CD" ).append("\n"); 
		query.append(",    B.LOCL_ZIP_CD" ).append("\n"); 
		query.append(",    NVL(B.OB_PHN_NO,B.IB_PHN_NO)" ).append("\n"); 
		query.append(",    NVL(B.OB_FAX_NO,B.IB_FAX_NO)" ).append("\n"); 
		query.append(",    DECODE(B.ISS_DIV_CD,'I','INTERNET','P','PAPER','E','EDI','V','VIETNAM')" ).append("\n"); 
		query.append(",    B.CUST_CR_DUE_DT_DIV_CD" ).append("\n"); 
		query.append(",    B.PAY_DT_DY1" ).append("\n"); 
		query.append(",    B.PAY_DT_DY2" ).append("\n"); 
		query.append(",    B.PAY_DT_DY3" ).append("\n"); 
		query.append(",    B.PAY_DT_DY4" ).append("\n"); 
		query.append(",    A.DELT_FLG" ).append("\n"); 
		query.append(",	 B.INV_DUE_DT_DP_FLG" ).append("\n"); 

	}
}