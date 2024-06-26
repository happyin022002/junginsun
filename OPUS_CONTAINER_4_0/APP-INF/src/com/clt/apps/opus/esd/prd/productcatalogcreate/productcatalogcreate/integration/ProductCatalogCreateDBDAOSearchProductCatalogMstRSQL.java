/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchProductCatalogMstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.11.11 정선용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOSearchProductCatalogMstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchProductCatalogMst
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchProductCatalogMstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchProductCatalogMstRSQL").append("\n"); 
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
		query.append("PCTL_NO, MTY_PKUP_YD_CD, POR_CD, POR_NOD_CD, POL_CD, N1ST_TS_PORT_CD, N2ND_TS_PORT_CD, N3RD_TS_PORT_CD, POD_CD, DEL_CD, DEL_NOD_CD, MTY_RTN_YD_CD, TTL_TZTM_HRS, TTL_EXPN_AMT, TRNK_AVAL_SPC, OB_ITCHG_CTNT, IB_ITCHG_CTNT, TRNK_VSL_CD, TRNK_SKD_VOY_NO, TRNK_SKD_DIR_CD, TO_CHAR(N1ST_VSL_LODG_DUE_DT,'YYYYMMDD') N1ST_VSL_LODG_DUE_DT, MCNTR_DOR_ARR_DUE_DT, CNST_FLG, BKG_CGO_TP_CD, BKG_RCV_TERM_CD, BKG_DE_TERM_CD, SHPR_CNT_CD, SHPR_SEQ, CNEE_CNT_CD, CNEE_SEQ, SC_NO, RFA_NO, DG_CLSS_CD, DG_SPCL_FLG, RF_SPCL_FLG, SPCL_AWK_CGO_FLG, BB_SPCL_FLG, RD_SPCL_FLG, HNGR_SPCL_FLG, SOC_FLG, EQ_SUBST_FLG, BKG_WGT, BKG_WGT_UT_CD, SLS_OFC_CD, BKG_OFC_CD, SC_OFC_CD, RFA_OFC_CD, PRM_CUST_FLG, ROUT_CNST_SEQ, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, REP_CMDT_CD, CMDT_CD, FULL_RTN_YD_CD, POL_NOD_CD, POD_NOD_CD, FULL_PKUP_YD_CD" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST" ).append("\n"); 
		query.append("WHERE PCTL_NO =@[pctl_no]" ).append("\n"); 

	}
}