/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchMoreInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.21
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.02.21 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chloe Mijin SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOSearchMoreInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMoreInfo
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchMoreInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOSearchMoreInfoRSQL").append("\n"); 
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
		query.append("SELECT CUST.NVOCC_CO_SCAC_CD" ).append("\n"); 
		query.append("     , CUST.NVOCC_LIC_NO" ).append("\n"); 
		query.append("     , CUST.NVOCC_BD_NO" ).append("\n"); 
		query.append("     , CUST.NVOCC_BD_AMT" ).append("\n"); 
		query.append("     , CUST_SLA_FLG" ).append("\n"); 
		query.append("     , CUST.BKG_ALT_RSN" ).append("\n"); 
		query.append("     , CUST.BKG_ALT_MSG" ).append("\n"); 
		query.append("     , TO_CHAR(CUST.BKG_ALT_FM_DT, 'yyyy-mm-dd') AS BKG_ALT_FM_DT" ).append("\n"); 
		query.append("     , TO_CHAR(CUST.BKG_ALT_TO_DT, 'yyyy-mm-dd') AS BKG_ALT_TO_DT     " ).append("\n"); 
		query.append("     , CUST.SPCL_REQ_DESC     " ).append("\n"); 
		query.append("     , CUST.CMPT_DESC     " ).append("\n"); 
		query.append("     , CUST.PRF_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , CUST.CUST_RMK" ).append("\n"); 
		query.append("     , TO_CHAR(TO_DATE(CUST.NVOCC_BD_ST_EFF_DT, 'yyyy-mm-dd'), 'yyyy-mm-dd') AS NVOCC_BD_ST_EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(TO_DATE(CUST.NVOCC_BD_END_EFF_DT, 'yyyy-mm-dd'), 'yyyy-mm-dd') AS NVOCC_BD_END_EFF_DT " ).append("\n"); 
		query.append("     , CR.CR_AMT" ).append("\n"); 
		query.append("     , CR.CR_CLT_OFC_CD" ).append("\n"); 
		query.append("     , CR.IB_CR_TERM_DYS" ).append("\n"); 
		query.append("     , CR.OB_CR_TERM_DYS" ).append("\n"); 
		query.append("     , INFO.INDUS_TP_N1ST_DESC" ).append("\n"); 
		query.append("     , INFO.INDUS_TP_N2ND_DESC" ).append("\n"); 
		query.append("     , INFO.MJR_N1ST_TRD_CD" ).append("\n"); 
		query.append("	 , INFO.MJR_N2ND_TRD_CD" ).append("\n"); 
		query.append("     , INFO.PRF_N1ST_REP_CMDT_CD" ).append("\n"); 
		query.append("     , INFO.PRF_N2ND_REP_CMDT_CD" ).append("\n"); 
		query.append("     , INFO.YRY_VOL_QTY     " ).append("\n"); 
		query.append("     , CNTC.CUST_URL" ).append("\n"); 
		query.append("     , A.REP_CMDT_NM AS PRF_N1ST_CMDT_GRP_DTL" ).append("\n"); 
		query.append("     , B.REP_CMDT_NM AS PRF_N2ND_CMDT_GRP_DTL" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("   , MDM_CR_CUST CR" ).append("\n"); 
		query.append("   , SAM_CUST_OTR_INFO INFO" ).append("\n"); 
		query.append("   , MDM_CUST_CNTC_PNT CNTC" ).append("\n"); 
		query.append("   , MDM_REP_CMDT A " ).append("\n"); 
		query.append("   , MDM_REP_CMDT B" ).append("\n"); 
		query.append("   , ( SELECT MAX(CUST_CNTC_PNT_SEQ) SEQ" ).append("\n"); 
		query.append("         FROM MDM_CUST_CNTC_PNT" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("          AND CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 
		query.append("     )CNTC_SEQ" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND CUST.CUST_CNT_CD = CR.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("AND CUST.CUST_SEQ = CR.CUST_SEQ (+)" ).append("\n"); 
		query.append("AND CUST.CUST_CNT_CD = INFO.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("AND CUST.CUST_SEQ = INFO.CUST_SEQ (+)" ).append("\n"); 
		query.append("AND CUST.CUST_CNT_CD = CNTC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST.CUST_SEQ = CNTC.CUST_SEQ" ).append("\n"); 
		query.append("AND CNTC.CUST_CNTC_PNT_SEQ = CNTC_SEQ.SEQ" ).append("\n"); 
		query.append("AND CUST.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("AND CUST.CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 
		query.append("AND INFO.PRF_N1ST_REP_CMDT_CD  = A.REP_CMDT_CD (+)" ).append("\n"); 
		query.append("AND INFO.PRF_N2ND_REP_CMDT_CD  = B.REP_CMDT_CD (+)" ).append("\n"); 

	}
}