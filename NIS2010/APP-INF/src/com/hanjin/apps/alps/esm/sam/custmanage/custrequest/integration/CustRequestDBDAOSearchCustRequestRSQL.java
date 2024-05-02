/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustRequestDBDAOSearchCustRequestRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustRequestDBDAOSearchCustRequestRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Request search
	  * </pre>
	  */
	public CustRequestDBDAOSearchCustRequestRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.custrequest.integration").append("\n"); 
		query.append("FileName : CustRequestDBDAOSearchCustRequestRSQL").append("\n"); 
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
		query.append("SELECT MDM_CUSTOMER_RQST_SEQ RQST_NO" ).append("\n"); 
		query.append(",CRM_ROW_ID" ).append("\n"); 
		query.append(",CRM_ROW_ID AS CUST_ROW_ID" ).append("\n"); 
		query.append(",DECODE(GRP_INDIV_DIV,'G','A','P') CUST_STS_CD" ).append("\n"); 
		query.append(",GRP_INDIV_DIV" ).append("\n"); 
		query.append(",CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append(",CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",BZET_ADDR" ).append("\n"); 
		query.append(",CUST_RGST_NO" ).append("\n"); 
		query.append(",NMD_CUST_FLG" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",SREP_CD" ).append("\n"); 
		query.append(",RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append(",CTS_NO" ).append("\n"); 
		query.append(",CUST_GRP_ID" ).append("\n"); 
		query.append(",INTL_PHN_NO" ).append("\n"); 
		query.append(",PHN_NO" ).append("\n"); 
		query.append(",INTL_FAX_NO" ).append("\n"); 
		query.append(",FAX_NO" ).append("\n"); 
		query.append(",CUST_EML" ).append("\n"); 
		query.append(",CUST_URL" ).append("\n"); 
		query.append(",PRF_SVC_DESC" ).append("\n"); 
		query.append(",PRF_SVC_DTL_DESC" ).append("\n"); 
		query.append(",CMPT_DESC" ).append("\n"); 
		query.append(",SPCL_REQ_DESC" ).append("\n"); 
		query.append(",PRF_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",CRNT_VOL_KNT" ).append("\n"); 
		query.append(",NVL(NEW_KEY_ACCT_FLG,'N') NEW_KEY_ACCT_FLG" ).append("\n"); 
		query.append(",NVL(RGN_ACCT_FLG,'N') RGN_ACCT_FLG" ).append("\n"); 
		query.append(",CUST_RMK" ).append("\n"); 
		query.append(",BKG_ALT_RSN" ).append("\n"); 
		query.append(",  TO_CHAR(BKG_ALT_FM_DT, 'YYYY-MM-DD') BKG_ALT_FM_DT" ).append("\n"); 
		query.append(",  TO_CHAR(BKG_ALT_TO_DT, 'YYYY-MM-DD') BKG_ALT_TO_DT" ).append("\n"); 
		query.append(",BKG_ALT_MSG" ).append("\n"); 
		query.append(",BKG_ALT_CRE_USR_ID" ).append("\n"); 
		query.append(",BKG_ALT_CRE_DT" ).append("\n"); 
		query.append(",NVOCC_HJS_SCAC_CD" ).append("\n"); 
		query.append(",NVOCC_BD_NO" ).append("\n"); 
		query.append(",NVOCC_LIC_NO" ).append("\n"); 
		query.append(",NVL(NVOCC_BD_AMT,0) NVOCC_BD_AMT" ).append("\n"); 
		query.append(",NVOCC_BD_ST_EFF_DT" ).append("\n"); 
		query.append(",NVOCC_BD_END_EFF_DT" ).append("\n"); 
		query.append(",FRT_FWRD_FMC_NO" ).append("\n"); 
		query.append(",CTY_NM" ).append("\n"); 
		query.append(",STE_CD" ).append("\n"); 
		query.append(",ZIP_CD" ).append("\n"); 
		query.append(",NVL(MLT_TRD_ACCT_FLG,'N') MLT_TRD_ACCT_FLG" ).append("\n"); 
		query.append(",OTI_ORZ_NO" ).append("\n"); 
		query.append(",NVL(GLO_ACCT_FLG,'N') GLO_ACCT_FLG" ).append("\n"); 
		query.append(",KEY_ACCT_FLG" ).append("\n"); 
		query.append(",KEY_ACCT_ST_EFF_DT" ).append("\n"); 
		query.append(",KEY_ACCT_END_EFF_DT" ).append("\n"); 
		query.append(",KEY_ACCT_MGR_USR_ID" ).append("\n"); 
		query.append(",KEY_ACCT_MGR_USR_NM" ).append("\n"); 
		query.append(",PRF_REP_CMDT_CD" ).append("\n"); 
		query.append(",PRF_GRP_CMDT_CD" ).append("\n"); 
		query.append(",NVL(RF_ACCT_FLG,'N') RF_ACCT_FLG" ).append("\n"); 
		query.append(",CRM_ROW_ID" ).append("\n"); 
		query.append(",RQST_DT" ).append("\n"); 
		query.append(",EAI_IF_ID" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",CRM_ROW_ID CUST_CD" ).append("\n"); 
		query.append(",'1' Addr_Tp_Cd" ).append("\n"); 
		query.append(", CASE WHEN DELT_FLG = 'N' THEN 'Saved'" ).append("\n"); 
		query.append("       WHEN DELT_FLG = 'R' THEN 'Rejected'" ).append("\n"); 
		query.append("       WHEN MCR.GRP_INDIV_DIV = 'G' THEN NVL((SELECT 'Approved' FROM MDM_CUST_PERF_GRP MCPG WHERE MCPG.CUST_GRP_ID = MCR.CRM_ROW_ID AND ROWNUM = 1),'Requested' )" ).append("\n"); 
		query.append("       WHEN DELT_FLG = 'P' THEN NVL((SELECT 'Approved' FROM MDM_CUSTOMER MC WHERE MC.CRM_ROW_ID = MCR.CRM_ROW_ID AND ROWNUM = 1), 'Requested' )" ).append("\n"); 
		query.append("  ELSE 'Saved'" ).append("\n"); 
		query.append("  END RQST_STS" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER_RQST MCR" ).append("\n"); 
		query.append("WHERE MDM_CUSTOMER_RQST_SEQ = @[rqst_no]" ).append("\n"); 

	}
}