/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustMainDBDAOSearchCrCustCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOSearchCrCustCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Credit Customer Search
	  * </pre>
	  */
	public CustMainDBDAOSearchCrCustCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOSearchCrCustCodeRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("   ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",  ACT_CUST_SEQ" ).append("\n"); 
		query.append(",  ACT_CUST_CNT_CD||TRIM(TO_CHAR(ACT_CUST_SEQ,'000000')) act_cust_cd" ).append("\n"); 
		query.append(",  CUST_RLSE_CTRL_FLG" ).append("\n"); 
		query.append(",  CR_FLG" ).append("\n"); 
		query.append(",  CR_CURR_CD" ).append("\n"); 
		query.append(",  CR_AMT" ).append("\n"); 
		query.append(",  CR_CLT_OFC_CD" ).append("\n"); 
		query.append(",  CR_CUST_RMK" ).append("\n"); 
		query.append(",  IB_CR_TERM_DYS" ).append("\n"); 
		query.append(",  OB_CR_TERM_DYS" ).append("\n"); 
		query.append(",  PAY_DIV_CD" ).append("\n"); 
		query.append(",  TO_CHAR(TO_DATE(CR_ST_DT,'YYYYMMDD'),'YYYY-MM-DD') CR_ST_DT" ).append("\n"); 
		query.append(",  TO_CHAR(TO_DATE(CR_END_DT,'YYYYMMDD'),'YYYY-MM-DD') CR_END_DT" ).append("\n"); 
		query.append(",  CR_CUST_TP_CD" ).append("\n"); 
		query.append(",  OB_EML" ).append("\n"); 
		query.append(",  IB_EML" ).append("\n"); 
		query.append(",  OB_PHN_NO" ).append("\n"); 
		query.append(",  IB_PHN_NO" ).append("\n"); 
		query.append(",  OB_FAX_NO" ).append("\n"); 
		query.append(",  IB_FAX_NO" ).append("\n"); 
		query.append(",  XCH_RT_DIV_CD" ).append("\n"); 
		query.append(",  CNG_INDIV_CD" ).append("\n"); 
		query.append(",  TO_CHAR(TO_DATE(DY_XCH_APLY_ST_DT,'YYYYMMDD'),'YYYY-MM-DD') DY_XCH_APLY_ST_DT" ).append("\n"); 
		query.append(",  ISS_DIV_CD" ).append("\n"); 
		query.append(",  BANK_ACCT_NO" ).append("\n"); 
		query.append(",  CNTC_PSON_NM" ).append("\n"); 
		query.append(",  CUST_CR_DUE_DT_DIV_CD" ).append("\n"); 
		query.append(",  OWNR_NM" ).append("\n"); 
		query.append(",  BZCT_NM" ).append("\n"); 
		query.append(",  BZTP_NM" ).append("\n"); 
		query.append(",  PAY_DT_DY1" ).append("\n"); 
		query.append(",  PAY_DT_DY2" ).append("\n"); 
		query.append(",  PAY_DT_DY3" ).append("\n"); 
		query.append(",  PAY_DT_DY4" ).append("\n"); 
		query.append(",  LOCL_NM" ).append("\n"); 
		query.append(",  LOCL_ADDR1" ).append("\n"); 
		query.append(",  LOCL_ADDR2" ).append("\n"); 
		query.append(",  LOCL_ADDR3" ).append("\n"); 
		query.append(",  LOCL_ADDR4" ).append("\n"); 
		query.append(",  LOCL_ZIP_CD" ).append("\n"); 
		query.append(",  BFR_CR_CLT_OFC_CD" ).append("\n"); 
		query.append(",  MCC.BFR_OFC_CNG_DT" ).append("\n"); 
		query.append(",  INV_DUE_DT_DP_FLG" ).append("\n"); 
		query.append(",  RISS_INV_FLG" ).append("\n"); 
		query.append(",  MCC.INV_ISS_CURR_TP_CD" ).append("\n"); 
		query.append(",  MCC.CRE_USR_ID" ).append("\n"); 
		query.append(",  TO_CHAR(MCC.CRE_DT,'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append(",  MCC.UPD_USR_ID" ).append("\n"); 
		query.append(",  TO_CHAR(MCC.UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append(",  MCC.DELT_FLG" ).append("\n"); 
		query.append(",  MC.CUST_CNT_CD" ).append("\n"); 
		query.append(",  TRIM(TO_CHAR(MC.CUST_SEQ,'000000')) CUST_SEQ" ).append("\n"); 
		query.append(",  MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",  MCC.KR_IB_OFC_CD" ).append("\n"); 
		query.append(",  AUTO_INV_IB_FLG" ).append("\n"); 
		query.append(",  AUTO_INV_IB_HJS_REF_NO" ).append("\n"); 
		query.append(",  AUTO_INV_IB_HJS_REF_PHN_NO" ).append("\n"); 
		query.append(",  AUTO_INV_IB_CUST_REF_NO_FLG" ).append("\n"); 
		query.append(",  AUTO_INV_IB_LOCL_CHG_FLG" ).append("\n"); 
		query.append(",  AUTO_INV_IB_EML" ).append("\n"); 
		query.append(",  AUTO_INV_OB_FLG" ).append("\n"); 
		query.append(",  AUTO_INV_OB_HJS_REF_NO" ).append("\n"); 
		query.append(",  AUTO_INV_OB_HJS_REF_PHN_NO" ).append("\n"); 
		query.append(",  AUTO_INV_OB_CUST_REF_NO_FLG" ).append("\n"); 
		query.append(",  AUTO_INV_OB_LOCL_CHG_FLG" ).append("\n"); 
		query.append(",  AUTO_INV_OB_EML" ).append("\n"); 
		query.append(",  MC.RFND_PSDO_VNDR_SEQ" ).append("\n"); 
		query.append(",  DECODE(MC.RFND_PSDO_VNDR_SEQ,NULL,'N','Y') RFND_PSDO_VNDR_FLG" ).append("\n"); 
		query.append("FROM  MDM_CUSTOMER MC" ).append("\n"); 
		query.append("      ,MDM_CR_CUST MCC" ).append("\n"); 
		query.append("WHERE MC.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND   MC.CUST_SEQ    = @[cust_seq]" ).append("\n"); 
		query.append("AND   MC.CUST_CNT_CD = MCC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND   MC.CUST_SEQ = MCC.CUST_SEQ(+)" ).append("\n"); 

	}
}