/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustMainDBDAOAddCustCodeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.26 
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

public class CustMainDBDAOAddCustCodeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cust Main Create
	  * </pre>
	  */
	public CustMainDBDAOAddCustCodeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOAddCustCodeCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_CUSTOMER(" ).append("\n"); 
		query.append("   CUST_CNT_CD" ).append("\n"); 
		query.append(",  CUST_SEQ" ).append("\n"); 
		query.append(",  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",  CUST_RGST_NO" ).append("\n"); 
		query.append(",  NMD_CUST_FLG" ).append("\n"); 
		query.append(",  LOC_CD" ).append("\n"); 
		query.append(",  OFC_CD" ).append("\n"); 
		query.append(",  SREP_CD" ).append("\n"); 
		query.append(",  RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append(",  CTS_NO" ).append("\n"); 
		query.append(",  CUST_GRP_ID" ).append("\n"); 
		query.append(",  PRF_SVC_DESC" ).append("\n"); 
		query.append(",  PRF_SVC_DTL_DESC" ).append("\n"); 
		query.append(",  CMPT_DESC" ).append("\n"); 
		query.append(",  SPCL_REQ_DESC" ).append("\n"); 
		query.append(",  PRF_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",  CRNT_VOL_KNT" ).append("\n"); 
		query.append(",  NEW_KEY_ACCT_FLG" ).append("\n"); 
		query.append(",  RGN_ACCT_FLG" ).append("\n"); 
		query.append(",  CUST_RMK" ).append("\n"); 
		query.append(",  BKG_ALT_RSN" ).append("\n"); 
		query.append(",  bkg_alt_fm_dt" ).append("\n"); 
		query.append(",  bkg_alt_to_dt" ).append("\n"); 
		query.append(",  BKG_ALT_MSG" ).append("\n"); 
		query.append(",  NVOCC_HJS_SCAC_CD" ).append("\n"); 
		query.append(",  NVOCC_BD_NO" ).append("\n"); 
		query.append(",  NVOCC_LIC_NO" ).append("\n"); 
		query.append(",  NVOCC_BD_AMT" ).append("\n"); 
		query.append(",  NVOCC_BD_ST_EFF_DT" ).append("\n"); 
		query.append(",  NVOCC_BD_END_EFF_DT" ).append("\n"); 
		query.append(",  CRE_USR_ID" ).append("\n"); 
		query.append(",  CRE_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append(",  DELT_FLG" ).append("\n"); 
		query.append(",  CRM_ROW_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SUBSTR(MCR.LOC_CD,1,2)" ).append("\n"); 
		query.append(",  NVL((SELECT MAX(CUST_SEQ) + 1 FROM MDM_CUSTOMER MC WHERE MC.CUST_CNT_CD = SUBSTR(MCR.LOC_CD,1,2)),1)" ).append("\n"); 
		query.append(",  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",  CUST_RGST_NO" ).append("\n"); 
		query.append(",  NMD_CUST_FLG" ).append("\n"); 
		query.append(",  LOC_CD" ).append("\n"); 
		query.append(",  OFC_CD" ).append("\n"); 
		query.append(",  SREP_CD" ).append("\n"); 
		query.append(",  RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append(",  CTS_NO" ).append("\n"); 
		query.append(",  CUST_GRP_ID" ).append("\n"); 
		query.append(",  PRF_SVC_DESC" ).append("\n"); 
		query.append(",  PRF_SVC_DTL_DESC" ).append("\n"); 
		query.append(",  CMPT_DESC" ).append("\n"); 
		query.append(",  SPCL_REQ_DESC" ).append("\n"); 
		query.append(",  PRF_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",  CRNT_VOL_KNT" ).append("\n"); 
		query.append(",  NEW_KEY_ACCT_FLG" ).append("\n"); 
		query.append(",  RGN_ACCT_FLG" ).append("\n"); 
		query.append(",  CUST_RMK" ).append("\n"); 
		query.append(",  BKG_ALT_RSN" ).append("\n"); 
		query.append(",  bkg_alt_fm_dt" ).append("\n"); 
		query.append(",  bkg_alt_to_dt" ).append("\n"); 
		query.append(",  BKG_ALT_MSG" ).append("\n"); 
		query.append(",  NVOCC_HJS_SCAC_CD" ).append("\n"); 
		query.append(",  NVOCC_BD_NO" ).append("\n"); 
		query.append(",  NVOCC_LIC_NO" ).append("\n"); 
		query.append(",  NVOCC_BD_AMT" ).append("\n"); 
		query.append(",  NVOCC_BD_ST_EFF_DT" ).append("\n"); 
		query.append(",  NVOCC_BD_END_EFF_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append(",  UPD_USR_ID" ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append(",  'N'" ).append("\n"); 
		query.append(",  'I-'||MCR.MDM_CUSTOMER_RQST_SEQ" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER_RQST MCR" ).append("\n"); 
		query.append("WHERE MCR.MDM_CUSTOMER_RQST_SEQ = @[rqst_no]" ).append("\n"); 
		query.append("AND MCR.MST_RQST_STS_CD = 'P'" ).append("\n"); 
		query.append("AND MCR.GRP_INDIV_DIV = 'I'" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                FROM MDM_CUSTOMER MC " ).append("\n"); 
		query.append("                WHERE MC.CRM_ROW_ID = MCR.GRP_INDIV_DIV||'-'||MCR.MDM_CUSTOMER_RQST_SEQ" ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}