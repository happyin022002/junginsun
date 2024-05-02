/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ProductCatalogHinterlandDBDAOCopyRfPrdProdCtlMstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogHinterlandDBDAOCopyRfPrdProdCtlMstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ProductCatalogHinterlandDBDAOCopyRfPrdProdCtlMstCSQL
	  * </pre>
	  */
	public ProductCatalogHinterlandDBDAOCopyRfPrdProdCtlMstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogHinterlandDBDAOCopyRfPrdProdCtlMstCSQL").append("\n"); 
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
		query.append("INSERT INTO PRD_PROD_CTL_MST" ).append("\n"); 
		query.append("(PCTL_NO, MTY_PKUP_YD_CD, POR_CD, POR_NOD_CD, FULL_RTN_YD_CD, FULL_PKUP_YD_CD, POL_CD, POL_NOD_CD, N1ST_TS_PORT_CD, N2ND_TS_PORT_CD, N3RD_TS_PORT_CD, POD_CD, POD_NOD_CD, DEL_CD, DEL_NOD_CD, MTY_RTN_YD_CD, TTL_TZTM_HRS, TTL_EXPN_AMT, TRNK_AVAL_SPC, OB_ITCHG_CTNT, IB_ITCHG_CTNT, TRNK_VSL_CD, TRNK_SKD_VOY_NO, TRNK_SKD_DIR_CD, N1ST_VSL_LODG_DUE_DT, MCNTR_DOR_ARR_DUE_DT, CNST_FLG, BKG_CGO_TP_CD, BKG_RCV_TERM_CD, BKG_DE_TERM_CD, SHPR_CNT_CD, SHPR_SEQ, CNEE_CNT_CD, CNEE_SEQ, SC_NO, RFA_NO, REP_CMDT_CD, CMDT_CD, DG_CLSS_CD, DG_SPCL_FLG, RF_SPCL_FLG, SPCL_AWK_CGO_FLG, BB_SPCL_FLG, RD_SPCL_FLG, HNGR_SPCL_FLG, SOC_FLG, EQ_SUBST_FLG, BKG_WGT, BKG_WGT_UT_CD, SLS_OFC_CD, BKG_OFC_CD, SC_OFC_CD, RFA_OFC_CD, PRM_CUST_FLG, ROUT_CNST_SEQ, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT (@[hd_pctl_no] ||LPAD(TO_NUMBER(SUBSTR(@[max_pctl_no], -4))+TO_NUMBER(SUBSTR(PCTL_NO, -4)) ,4,'0')) PCTL_NO" ).append("\n"); 
		query.append("     , MTY_PKUP_YD_CD, POR_CD, POR_NOD_CD, FULL_RTN_YD_CD, FULL_PKUP_YD_CD, POL_CD, POL_NOD_CD, N1ST_TS_PORT_CD, N2ND_TS_PORT_CD, N3RD_TS_PORT_CD, POD_CD, POD_NOD_CD, DEL_CD, DEL_NOD_CD, MTY_RTN_YD_CD, TTL_TZTM_HRS, TTL_EXPN_AMT, TRNK_AVAL_SPC, OB_ITCHG_CTNT, IB_ITCHG_CTNT, TRNK_VSL_CD, TRNK_SKD_VOY_NO, TRNK_SKD_DIR_CD, N1ST_VSL_LODG_DUE_DT, MCNTR_DOR_ARR_DUE_DT, CNST_FLG, BKG_CGO_TP_CD, BKG_RCV_TERM_CD, BKG_DE_TERM_CD, SHPR_CNT_CD, SHPR_SEQ, CNEE_CNT_CD, CNEE_SEQ, SC_NO, RFA_NO, REP_CMDT_CD, CMDT_CD, DG_CLSS_CD, DG_SPCL_FLG, 'Y' RF_SPCL_FLG, SPCL_AWK_CGO_FLG, BB_SPCL_FLG, RD_SPCL_FLG, HNGR_SPCL_FLG, SOC_FLG, EQ_SUBST_FLG, BKG_WGT, BKG_WGT_UT_CD, SLS_OFC_CD, BKG_OFC_CD, SC_OFC_CD, RFA_OFC_CD, PRM_CUST_FLG, ROUT_CNST_SEQ, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST" ).append("\n"); 
		query.append("WHERE PCTL_NO LIKE DECODE(@[hd_pctl_no], NULL, NULL, @[hd_pctl_no] || '%')" ).append("\n"); 

	}
}