/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchBkgCorrectionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.12.21 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchBkgCorrectionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchBkgCorrectionRSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchBkgCorrectionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchBkgCorrectionRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(", CORR_NO" ).append("\n"); 
		query.append(", CA_RSN_CD" ).append("\n"); 
		query.append(", CORR_USR_ID" ).append("\n"); 
		query.append(", CORR_DT  --" ).append("\n"); 
		query.append(", RAT_FLG" ).append("\n"); 
		query.append(", EXPN_FLG" ).append("\n"); 
		query.append(", NEW_BKG_CRE_FLG" ).append("\n"); 
		query.append(", RCRE_MODI_FLG" ).append("\n"); 
		query.append(", BKG_CRE_MODI_FLG" ).append("\n"); 
		query.append(", CORR_CXL_FLG" ).append("\n"); 
		query.append(", OB_TRO_MODI_FLG" ).append("\n"); 
		query.append(", IB_TRO_MODI_FLG" ).append("\n"); 
		query.append(", BKG_SPLIT_MODI_FLG" ).append("\n"); 
		query.append(", COD_MODI_FLG" ).append("\n"); 
		query.append(", CXL_MODI_FLG" ).append("\n"); 
		query.append(", CA_RLY_PORT_MODI_FLG" ).append("\n"); 
		query.append(", DG_MODI_FLG" ).append("\n"); 
		query.append(", AWK_MODI_FLG" ).append("\n"); 
		query.append(", RF_MODI_FLG" ).append("\n"); 
		query.append(", BB_MODI_FLG" ).append("\n"); 
		query.append(", RD_MODI_FLG" ).append("\n"); 
		query.append(", HNGR_MODI_FLG" ).append("\n"); 
		query.append(", SOC_MODI_FLG" ).append("\n"); 
		query.append(", EQ_SUB_MODI_FLG" ).append("\n"); 
		query.append(", CUST_MODI_FLG" ).append("\n"); 
		query.append(", BL_MK_DESC_MODI_FLG" ).append("\n"); 
		query.append(", CNSL_MODI_FLG" ).append("\n"); 
		query.append(", BKG_CNTR_MODI_FLG" ).append("\n"); 
		query.append(", CNTR_MF_MODI_FLG" ).append("\n"); 
		query.append(", RT_MODI_FLG" ).append("\n"); 
		query.append(", BL_OBRD_CORR_FLG" ).append("\n"); 
		query.append(", RT_CORR_FLG" ).append("\n"); 
		query.append(", CHG_TERM_CORR_FLG" ).append("\n"); 
		query.append(", RCVDE_TERM_CORR_FLG" ).append("\n"); 
		query.append(", ROUT_CORR_FLG" ).append("\n"); 
		query.append(", CUST_CORR_FLG" ).append("\n"); 
		query.append(", QTY_CORR_FLG" ).append("\n"); 
		query.append(", MEAS_QTY_CORR_FLG" ).append("\n"); 
		query.append(", CMDT_CORR_FLG" ).append("\n"); 
		query.append(", TRNK_VSL_CORR_FLG" ).append("\n"); 
		query.append(", PRPST_VSL_CORR_FLG" ).append("\n"); 
		query.append(", CA_OTR_RSN_CORR_FLG" ).append("\n"); 
		query.append(", BND_CORR_FLG" ).append("\n"); 
		query.append(", BROG_GEN_CORR_FLG" ).append("\n"); 
		query.append(", BIS_SYS_IF_FLG" ).append("\n"); 
		query.append(", SCC_MODI_CD" ).append("\n"); 
		query.append(", BKG_CORR_RMK" ).append("\n"); 
		query.append(", CORR_OFC_CD" ).append("\n"); 
		query.append(", DOC_PERF_EXPT_CD" ).append("\n"); 
		query.append(", DOC_PERF_EXPT_DT" ).append("\n"); 
		query.append(", DIFF_RMK" ).append("\n"); 
		query.append(", CORR_NTC_OFC_CD1" ).append("\n"); 
		query.append(", CORR_READ_OFC_FLG1" ).append("\n"); 
		query.append(", CORR_NTC_OFC_CD2" ).append("\n"); 
		query.append(", CORR_READ_OFC_FLG2" ).append("\n"); 
		query.append(", CORR_NTC_OFC_CD3" ).append("\n"); 
		query.append(", CORR_READ_OFC_FLG3" ).append("\n"); 
		query.append(", CORR_NTC_OFC_CD4" ).append("\n"); 
		query.append(", CORR_READ_OFC_FLG4" ).append("\n"); 
		query.append(", CORR_NTC_OFC_CD5" ).append("\n"); 
		query.append(", CORR_READ_OFC_FLG5" ).append("\n"); 
		query.append(", CORR_NTC_OFC_CD6" ).append("\n"); 
		query.append(", CORR_READ_OFC_FLG6" ).append("\n"); 
		query.append(", CORR_NTC_OFC_CD7" ).append("\n"); 
		query.append(", CORR_READ_OFC_FLG7" ).append("\n"); 
		query.append(", CORR_NTC_OFC_CD8" ).append("\n"); 
		query.append(", CORR_READ_OFC_FLG8" ).append("\n"); 
		query.append(", IB_INTER_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", CORR_GDT" ).append("\n"); 
		query.append(", RDN_NO" ).append("\n"); 
		query.append(", RVIS_SEQ" ).append("\n"); 
		query.append(", RDN_ACPT_FLG" ).append("\n"); 
		query.append(", BKG_CMB_MODI_FLG" ).append("\n"); 
		query.append("FROM BKG_CORRECTION" ).append("\n"); 
		query.append("WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001' --addCaHistory : completeCA 이외확인할 것" ).append("\n"); 

	}
}