/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOCreateProductCatalogInCludeReplaneCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.29 
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

public class ProductCatalogCreateDBDAOCreateProductCatalogInCludeReplaneCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateProductCatalogInCludeReplane
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOCreateProductCatalogInCludeReplaneCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("m_pu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_str",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_str",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_pol_dc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocn_str",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pc_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pol_dc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_t",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_spcl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pod_dc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pol_dc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_spcl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pm_f",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pod_dc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_pod_dc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_trsp_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("m_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pod_dc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocn_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_subst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hngr_spcl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_spcl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prm_cust_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_t",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_spcl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pol_dc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_trsp_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOCreateProductCatalogInCludeReplaneCSQL").append("\n"); 
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
		query.append("INSERT ALL" ).append("\n"); 
		query.append("WHEN PCTL_SEQ =1 THEN" ).append("\n"); 
		query.append("    INTO PRD_PROD_CTL_MST" ).append("\n"); 
		query.append("    (PCTL_NO, MTY_PKUP_YD_CD, POR_CD, POR_NOD_CD, POL_CD, N1ST_TS_PORT_CD, N2ND_TS_PORT_CD, N3RD_TS_PORT_CD," ).append("\n"); 
		query.append("    POD_CD, DEL_CD, DEL_NOD_CD, MTY_RTN_YD_CD, OB_ITCHG_CTNT, IB_ITCHG_CTNT, FULL_RTN_YD_CD,POL_NOD_CD,POD_NOD_CD,FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("    N1ST_VSL_LODG_DUE_DT,BKG_RCV_TERM_CD, BKG_DE_TERM_CD,  CMDT_CD, BKG_OFC_CD,  SC_OFC_CD,CRE_USR_ID, CRE_DT,UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append("    ,BKG_CGO_TP_CD, SHPR_CNT_CD, SHPR_SEQ," ).append("\n"); 
		query.append("    CNEE_CNT_CD, CNEE_SEQ, SC_NO, RFA_NO, DG_CLSS_CD, DG_SPCL_FLG, RF_SPCL_FLG," ).append("\n"); 
		query.append("    SPCL_AWK_CGO_FLG, BB_SPCL_FLG, RD_SPCL_FLG, HNGR_SPCL_FLG, SOC_FLG, EQ_SUBST_FLG," ).append("\n"); 
		query.append("    BKG_WGT, BKG_WGT_UT_CD, SLS_OFC_CD, RFA_OFC_CD, PRM_CUST_FLG," ).append("\n"); 
		query.append("    REP_CMDT_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VALUES" ).append("\n"); 
		query.append("    (PCTL_NO,MTPU_CY,@[por] , POR,@[pol] ,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("    NVL(@[pod],SUBSTR(POD_NODE,1,5)),@[del],DEL,MTRTN_CY,OUT_CONTENT,IN_CONTENT,FULL_RTN_YD_CD,POL1,POD_NODE,FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("    TO_DATE(N1ST_VSL_LODG_DUE_DT,'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("    ,@[rcv_t], @[del_t],@[com],@[bkg_ofc],@[sc_ofc],NVL(@[cre_usr_id],'System'), CRE_DT,NVL(@[cre_usr_id],'System'), UPD_DT" ).append("\n"); 
		query.append("	,@[cgo_tp],@[shpr_cnt_cd],@[shpr_seq]," ).append("\n"); 
		query.append("    @[cnee_cnt_cd],@[cnee_seq], @[sc_no], @[rfa_no], @[dg_clss_cd], @[dg_spcl_flg], @[rf_spcl_flg]," ).append("\n"); 
		query.append("    @[spcl_awk_cgo_flg], @[bb_spcl_flg], @[rd_spcl_flg], @[hngr_spcl_flg], @[soc_flg],@[eq_subst_flg]," ).append("\n"); 
		query.append("    @[bkg_wgt], @[bkg_wgt_ut_cd], @[sls_ofc_cd], @[rfa_ofc_cd], @[prm_cust_flg]," ).append("\n"); 
		query.append("    @[rep_cmdt_cd]" ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("WHEN PCTL_SEQ > 0 THEN" ).append("\n"); 
		query.append("    INTO PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("    ( PCTL_NO, PCTL_SEQ, ORG_NOD_CD, DEST_NOD_CD, NOD_LNK_DIV_CD, PCTL_IO_BND_CD, TRSP_MOD_CD," ).append("\n"); 
		query.append("    PCTL_WTR_DIV_CD, ORG_NOD_TP_CD, DEST_NOD_TP_CD, MTY_YD_FLG, ARR_ST_DT, DEP_FSH_DT, TZ_DWLL_TM_HRS," ).append("\n"); 
		query.append("    N1ST_VNDR_SEQ,N2ND_VNDR_SEQ, N3RD_VNDR_SEQ, VSL_SLAN_CD, CRR_CD, VSL_CD, SKD_VOY_NO," ).append("\n"); 
		query.append("    INLND_ROUT_CMB_FLG, INLND_ROUT_INV_BIL_PATT_CD, SKD_DIR_CD, ROUT_ORG_NOD_CD,  ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("    ROUT_SEQ, ORG_CLPT_IND_SEQ,DEST_CLPT_IND_SEQ," ).append("\n"); 
		query.append("    CRE_USR_ID, CRE_DT,UPD_USR_ID, UPD_DT ," ).append("\n"); 
		query.append("    RAIL_CRR_TP_CD,INLND_ROUT_INCL_STTL_FLG,TRSP_AGMT_OFC_CTY_CD,TRSP_AGMT_SEQ,AGMT_REF_NO )" ).append("\n"); 
		query.append("    VALUES" ).append("\n"); 
		query.append("    (PCTL_NO,PCTL_SEQ,NODE_NEW1,NODE_NEW2,NODE_NEW_KIND,OI_BND_CD,TRSP_MOD_CD," ).append("\n"); 
		query.append("    WTR_DIV_CD,NODE1_TP,NODE2_TP,MT_YD_FLG,A_TIME,D_TIME,TZTM_DW_HRS," ).append("\n"); 
		query.append("    N1ST_VNDR_SEQ,N2ND_VNDR_SEQ,N3RD_VNDR_SEQ,SLANE,CRR_CD,VSL_CD,VOY_NO," ).append("\n"); 
		query.append("    INLND_ROUT_CMB_FLG,INLND_ROUT_INV_BIL_PATT_CD,DIR_CD,ROUT_ORG,ROUT_DEST," ).append("\n"); 
		query.append("    ROUT_SEQ,ORG_PORT_SEQ,DST_PORT_SEQ," ).append("\n"); 
		query.append("    NVL(@[cre_usr_id],'System'), CRE_DT,NVL(@[cre_usr_id],'System'), UPD_DT," ).append("\n"); 
		query.append("    RAIL_CRR_TYPE,INLND_ROUT_INCL_STTL_FLG,TRSP_AGMT_OFC_CTY_CD,TRSP_AGMT_SEQ,AGMT_REF_NO)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[hd_pctl_no]	||lpad(gp1,4,0) pctl_no, ord pctl_seq," ).append("\n"); 
		query.append("NODE_NEW1,NODE_NEW2,NODE_NEW_KIND,OI_BND_CD, DECODE(NODE_NEW_KIND,'L',substr(trsp_mod_cd,1,2),'X') trsp_mod_cd," ).append("\n"); 
		query.append("decode(trsp_mod_cd,'WD','W','VD','V') WTR_DIV_CD," ).append("\n"); 
		query.append("NODE1_TP,NODE2_TP,OUT_CONTENT,IN_CONTENT,MTPU_CY,MTRTN_CY,POR,DEL,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN F_NO2 = 0  AND NODE_NEW_KIND = 'N' AND @[rcv_t] <> 'S' THEN 'Y'" ).append("\n"); 
		query.append("WHEN F_NO2 = 42 AND NODE_NEW_KIND = 'N' AND @[del_t] <> 'S' THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N' END" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("MT_YD_FLG," ).append("\n"); 
		query.append("(CASE WHEN A_TIME IS NOT NULL THEN A_TIME" ).append("\n"); 
		query.append("      WHEN F_NO2 = 13  THEN TO_DATE(CCT,'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD DESC  ) /24) +NVL(TZTM_DW_HRS,12)/24" ).append("\n"); 
		query.append("      WHEN F_NO2 < 13  THEN TO_DATE(CCT,'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD DESC  ) /24)  + DECODE(@[pm_f],'Y',3, 6)/24" ).append("\n"); 
		query.append("      WHEN F_NO2 >= 29  THEN TO_DATE(POD_T,'YYYYMMDDHH24MISS') +(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD  ) /24) -NVL(TZTM_DW_HRS,12)/24" ).append("\n"); 
		query.append("END)" ).append("\n"); 
		query.append("A_TIME," ).append("\n"); 
		query.append("(CASE WHEN D_TIME IS NOT NULL THEN D_TIME" ).append("\n"); 
		query.append("      WHEN F_NO2 = 13 THEN TO_DATE(POL_T,'YYYYMMDDHH24MISS') --TO_DATE(CCT,'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD DESC  ) /24) +TZTM_DW_HRS/24" ).append("\n"); 
		query.append("      WHEN F_NO2 < 13 THEN TO_DATE(CCT,'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD DESC  ) /24) +NVL(TZTM_DW_HRS,12)/24 + DECODE(@[pm_f],'Y',3, 6)/24" ).append("\n"); 
		query.append("      WHEN F_NO2 >= 29 THEN TO_DATE(POD_T,'YYYYMMDDHH24MISS') +(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD  ) /24)" ).append("\n"); 
		query.append("END)" ).append("\n"); 
		query.append("D_TIME," ).append("\n"); 
		query.append("ROUND((" ).append("\n"); 
		query.append("    (CASE WHEN D_TIME IS NOT NULL THEN D_TIME" ).append("\n"); 
		query.append("          WHEN F_NO2 = 13 THEN TO_DATE(POL_T,'YYYYMMDDHH24MISS') --TO_DATE(CCT,'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD DESC  ) /24) +TZTM_DW_HRS/24" ).append("\n"); 
		query.append("          WHEN F_NO2 < 13 THEN TO_DATE(CCT,'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD DESC  ) /24) +NVL(TZTM_DW_HRS,12)/24 + DECODE(@[pm_f],'Y',3, 6)/24" ).append("\n"); 
		query.append("          WHEN F_NO2 >= 29 THEN TO_DATE(POD_T,'YYYYMMDDHH24MISS') +(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD  ) /24)" ).append("\n"); 
		query.append("    END) -" ).append("\n"); 
		query.append("    (CASE WHEN A_TIME IS NOT NULL THEN A_TIME" ).append("\n"); 
		query.append("          WHEN F_NO2 = 13  THEN TO_DATE(CCT,'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD DESC  ) /24) +NVL(TZTM_DW_HRS,12)/24" ).append("\n"); 
		query.append("          WHEN F_NO2 < 13  THEN TO_DATE(CCT,'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD DESC  ) /24)  + DECODE(@[pm_f],'Y',3, 6)/24" ).append("\n"); 
		query.append("          WHEN F_NO2 >= 29  THEN TO_DATE(POD_T,'YYYYMMDDHH24MISS') +(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY ORD  ) /24) -NVL(TZTM_DW_HRS,12)/24" ).append("\n"); 
		query.append("    END)" ).append("\n"); 
		query.append(") *24)" ).append("\n"); 
		query.append("TZTM_DW_HRS ," ).append("\n"); 
		query.append("(CASE WHEN NODE_NEW_KIND = 'N' THEN N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("      WHEN NODE_NEW_KIND = 'L' AND F_NO2 =0 AND @[rcv_t] = 'D' THEN" ).append("\n"); 
		query.append("        LEAD(N1ST_VNDR_SEQ, 1) OVER ( PARTITION BY GP1,NODE_NEW_KIND ORDER BY F_NO2,L_N0)" ).append("\n"); 
		query.append("      WHEN NODE_NEW_KIND = 'L' AND F_NO2 =41 AND @[del_t] = 'D' THEN" ).append("\n"); 
		query.append("        LAG(N1ST_VNDR_SEQ, 1) OVER ( PARTITION BY GP1,NODE_NEW_KIND ORDER BY F_NO2,L_N0)" ).append("\n"); 
		query.append("      ELSE N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") N1ST_VNDR_SEQ," ).append("\n"); 
		query.append("N2ND_VNDR_SEQ,N3RD_VNDR_SEQ,SLANE," ).append("\n"); 
		query.append("CRR_CD," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("VOY_NO," ).append("\n"); 
		query.append("DIR_CD," ).append("\n"); 
		query.append("ORG_PORT_SEQ," ).append("\n"); 
		query.append("DST_PORT_SEQ," ).append("\n"); 
		query.append("INLND_ROUT_CMB_FLG,TRIM(INLND_ROUT_INV_BIL_PATT_CD) INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("ROUT_ORG,ROUT_DEST,ROUT_SEQ,FULL_RTN_YD_CD,POL1,POD_NODE,FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("@[cre_usr_cd] CRE_USR_ID, sysdate CRE_DT , @[cre_usr_cd] UPD_USR_ID, sysdate UPD_DT," ).append("\n"); 
		query.append("TRIM(RAIL_CRR_TYPE) RAIL_CRR_TYPE , TRIM(INLND_ROUT_INCL_STTL_FLG) INLND_ROUT_INCL_STTL_FLG," ).append("\n"); 
		query.append("TRIM(TRSP_AGMT_OFC_CTY_CD) TRSP_AGMT_OFC_CTY_CD, TRIM(TRSP_AGMT_SEQ) TRSP_AGMT_SEQ, TRIM(AGMT_REF_NO) AGMT_REF_NO" ).append("\n"); 
		query.append(",POL_T N1ST_VSL_LODG_DUE_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("     GP1,F_NO2,L_N0,O1,ROW_NUMBER() over (PARTITION BY GP1 ORDER BY F_NO2,L_N0,O1) ord," ).append("\n"); 
		query.append("     NODE_NEW1," ).append("\n"); 
		query.append("     NVL((SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = NODE_NEW1), (SELECT 'Y' FROM MDM_LSE_CO_YD WHERE LSE_CO_YD_CD = NODE_NEW1 AND F_NO2 = 42)) NODE1_TP," ).append("\n"); 
		query.append("     DECODE(LENGTH(NODE_NEW2),7,NODE_NEW2,SUBSTR(NODE_NEW2,3,7))  NODE_NEW2," ).append("\n"); 
		query.append("     NVL((SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = DECODE(LENGTH(NODE_NEW2),7,NODE_NEW2,SUBSTR(NODE_NEW2,3,7)))" ).append("\n"); 
		query.append("        ,(SELECT 'Y' FROM MDM_LSE_CO_YD WHERE LSE_CO_YD_CD = DECODE(LENGTH(NODE_NEW2),7,NODE_NEW2,SUBSTR(NODE_NEW2,3,7)) AND F_NO2 IN (41,42) )) NODE2_TP," ).append("\n"); 
		query.append("     NODE_NEW_KIND,OI_BND_CD,OUT_CONTENT,IN_CONTENT, MTPU_CY,MTRTN_CY,OB_ORG POR,IB_DEST DEL,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD,CCT," ).append("\n"); 
		query.append("    (CASE" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='L' AND F_NO2 IN ( 0,41) THEN 'TD'" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='L' AND F_NO2 = 1 AND @[rcv_t] ='S' AND OB_SEQ= 0 THEN 'TD'" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='L' AND F_NO2 = 29 AND @[del_t] IN ('S','T','F','Y') AND IB_SEQ= 0 THEN 'TD'" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='L' AND F_NO2 IN (13,18,23,28) THEN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT DECODE(VSL_SVC_TP_CD, 'O', 'WD', 'VD')" ).append("\n"); 
		query.append("            FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("            WHERE VSL_SLAN_CD = DECODE(F_NO2,13,N1ST_LANE_CD,18,N2ND_LANE_CD,23,N3RD_LANE_CD,28,N4TH_LANE_CD)" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("       WHEN NODE_NEW_KIND='L' AND LENGTH(NODE_NEW2) > 7 THEN SUBSTR(NODE_NEW2,10,2)" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("        NVL((" ).append("\n"); 
		query.append("           SELECT /*+ INDEX (M2 XAK1PRD_INLND_ROUT_MST) */" ).append("\n"); 
		query.append("           --D2.TRSP_MOD_CD" ).append("\n"); 
		query.append("            DISTINCT" ).append("\n"); 
		query.append("             CASE WHEN REGEXP_INSTR(@[ocn_str], NODE_NEW1 || '-..-.-...-' || NODE_NEW2 ) > 0 THEN" ).append("\n"); 
		query.append("                      DECODE(D2.TRSP_MOD_CD, SUBSTR(REGEXP_SUBSTR(@[ocn_str], NODE_NEW1 || '-..-.-...-' || NODE_NEW2), 9,2), D2.TRSP_MOD_CD ," ).append("\n"); 
		query.append("								 decode(REGEXP_INSTR(@[ocn_str], NODE_NEW1 || '-..-.-...-' || NODE_NEW2 ) , null, 'TD', 0, 'TD'" ).append("\n"); 
		query.append("					                     ,substr(@[ocn_str],  REGEXP_INSTR(@[ocn_str], NODE_NEW1 || '-..-.-...-' || NODE_NEW2 ) + 8, 2))" ).append("\n"); 
		query.append("                             )           " ).append("\n"); 
		query.append("                  ELSE" ).append("\n"); 
		query.append("                      FIRST_VALUE(D2.TRSP_MOD_CD) OVER(PARTITION BY M2.ROUT_ORG_NOD_CD, M2.ROUT_DEST_NOD_CD  ORDER BY DECODE(M2.INLND_ROUT_BKG_FLG,'Y',1,2) , M2.PRIO_SEQ,M2.ROUT_SEQ)" ).append("\n"); 
		query.append("             END " ).append("\n"); 
		query.append("           FROM PRD_INLND_ROUT_MST M2, PRD_INLND_ROUT_DTL D2" ).append("\n"); 
		query.append("           WHERE" ).append("\n"); 
		query.append("               M2.ROUT_ORG_NOD_CD = NODE_NEW1" ).append("\n"); 
		query.append("           AND M2.ROUT_DEST_NOD_CD = NODE_NEW2" ).append("\n"); 
		query.append("           AND M2.ROUT_ORG_NOD_CD = D2.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("           AND M2.ROUT_DEST_NOD_CD = D2.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("           AND M2.ROUT_SEQ = D2.ROUT_SEQ" ).append("\n"); 
		query.append("           AND M2.PCTL_IO_BND_CD = 'B'" ).append("\n"); 
		query.append("           AND NVL(M2.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("           AND D2.LNK_ORG_NOD_CD = NODE_NEW1" ).append("\n"); 
		query.append("           AND D2.LNK_DEST_NOD_CD = NODE_NEW2" ).append("\n"); 
		query.append("           AND D2.ROUT_DTL_SEQ = 1" ).append("\n"); 
		query.append("           --AND 'Y' = CASE WHEN REGEXP_INSTR([ocn_str], NODE_NEW1 || '-..-.-...-' || NODE_NEW2 ) > 0 THEN" ).append("\n"); 
		query.append("           --               DECODE(D2.TRSP_MOD_CD, SUBSTR(REGEXP_SUBSTR([ocn_str], NODE_NEW1 || '-..-.-...-' || NODE_NEW2), 9,2), 'Y','N')" ).append("\n"); 
		query.append("           --          ELSE DECODE(NVL(M2.INLND_ROUT_BKG_FLG, 'N'), 'N', 'N', DECODE(NVL(M2.INLND_ROUT_TMP_FLG, 'N'), 'N', 'Y', 'N'))" ).append("\n"); 
		query.append("           --          END" ).append("\n"); 
		query.append("           --AND ROWNUM = 1" ).append("\n"); 
		query.append("           ) , decode(REGEXP_INSTR(@[ocn_str], NODE_NEW1 || '-..-.-...-' || NODE_NEW2 ) , null, 'TD', 0, 'TD'" ).append("\n"); 
		query.append("                     ,substr(@[ocn_str],  REGEXP_INSTR(@[ocn_str], NODE_NEW1 || '-..-.-...-' || NODE_NEW2 ) + 8, 2)))" ).append("\n"); 
		query.append("    END) trsp_mod_cd," ).append("\n"); 
		query.append("    (CASE" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='N' AND F_NO2 IN (1,41) AND (SELECT NOD_TP_CD FROM PRD_NODE" ).append("\n"); 
		query.append("                                                        WHERE NOD_CD = NODE_NEW1) = 'Z' THEN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT CGO_HNDL_TM_HRS FROM MDM_ZONE WHERE ZN_CD = NODE_NEW1" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='N' AND F_NO2 = 1 AND @[rcv_t] ='S' AND OB_SEQ = 0 AND" ).append("\n"); 
		query.append("            (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = NODE_NEW1) <> 'Z' THEN" ).append("\n"); 
		query.append("        0" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='N' AND F_NO2 = 41 AND @[del_t] ='S' AND IB_SEQ = 0 AND" ).append("\n"); 
		query.append("            (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = NODE_NEW1) <> 'Z' THEN" ).append("\n"); 
		query.append("        0" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='N' AND (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = NODE_NEW1) <> 'Z' THEN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("--            SELECT DECODE(F_NO2,42,0,DECODE(F_NO2,0,0,DECODE(OI_BND_CD, 'T', 0, DECODE( _pm_f,'Y'," ).append("\n"); 
		query.append("--                                           3, 6)))) FROM DUAL" ).append("\n"); 
		query.append("            SELECT DECODE(F_NO2,42,0,DECODE(F_NO2,0,0,DECODE(OI_BND_CD, 'T', 0, NVL(DECODE(OI_BND_CD,'O'," ).append("\n"); 
		query.append("                                                                                        (SELECT" ).append("\n"); 
		query.append("                                                                                          CASE" ).append("\n"); 
		query.append("                                                                                            WHEN NODE_NEW_KIND = 'N'" ).append("\n"); 
		query.append("                                                                                            AND OI_BND_CD = 'O'" ).append("\n"); 
		query.append("                                                                                            --AND MTPU_CY <> NODE_NEW1 --IRG시작이 아니고" ).append("\n"); 
		query.append("                                                                                            AND F_NO2 > 1 -- MT 가 아니고 IRG시작이 아니고" ).append("\n"); 
		query.append("                                                                                            AND MIRG.HUB_NOD_CD <> NODE_NEW1 --HUB가 아니고" ).append("\n"); 
		query.append("                                                                                            AND MIRG.ROUT_DEST_NOD_CD <> NODE_NEW1 --IRG의 끝이 아니고                                                                                            " ).append("\n"); 
		query.append("                                                                                            AND INSTR(MIRG.TRSP_MOD_CD, 'R') > 0 --RD 를 포함하고" ).append("\n"); 
		query.append("                                                                                            AND (" ).append("\n"); 
		query.append("                                                                                            SELECT YD_FCTY_TP_RAIL_RMP_FLG" ).append("\n"); 
		query.append("                                                                                            FROM MDM_YARD" ).append("\n"); 
		query.append("                                                                                            WHERE YD_CD = NODE_NEW1) = 'Y' --RAIL RAMP 이고" ).append("\n"); 
		query.append("                                                                                            AND 'Y' = (" ).append("\n"); 
		query.append("                                                                                            SELECT 'Y'" ).append("\n"); 
		query.append("                                                                                            FROM MDM_COUNTRY CTRY ," ).append("\n"); 
		query.append("                                                                                              MDM_SUBCONTINENT CONT" ).append("\n"); 
		query.append("                                                                                            WHERE CTRY.CNT_CD = SUBSTR(NODE_NEW1, 1, 2)" ).append("\n"); 
		query.append("                                                                                              AND CTRY.SCONTI_CD = CONT.SCONTI_CD" ).append("\n"); 
		query.append("                                                                                              AND CONT.CONTI_CD = 'M') --미주이고" ).append("\n"); 
		query.append("                                                                                            THEN 24" ).append("\n"); 
		query.append("                                                                                          END" ).append("\n"); 
		query.append("                                                                                        FROM PRD_INLND_ROUT_MST MIRG" ).append("\n"); 
		query.append("                                                                                        WHERE 1=1 --M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("                                                                                        " ).append("\n"); 
		query.append("                                                                                        --AND  M.PCTL_NO = 'B1302190383194890001'" ).append("\n"); 
		query.append("                                                                                          AND OI_BND_CD = 'O'" ).append("\n"); 
		query.append("                                                                                          AND MIRG.ROUT_ORG_NOD_CD(+) =OB_ORG" ).append("\n"); 
		query.append("                                                                                          AND MIRG.ROUT_DEST_NOD_CD(+) = OB_DEST" ).append("\n"); 
		query.append("                                                                                          AND MIRG.ROUT_SEQ(+) = OB_SEQ" ).append("\n"); 
		query.append("                                                                                        --    ORDER BY GP1,F_NO2 ASC            " ).append("\n"); 
		query.append("                                                                                          ))" ).append("\n"); 
		query.append("                                                                                    ,DECODE(@[pm_f],'Y',3, 6))" ).append("\n"); 
		query.append("                                                            ))) FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHEN  NODE_NEW_KIND='L' AND @[rcv_t] = 'D' AND F_NO2 = 0   THEN" ).append("\n"); 
		query.append("        (SELECT TZTM_HRS FROM MDM_ZONE WHERE ZN_CD = NODE_NEW2 )" ).append("\n"); 
		query.append("        WHEN  NODE_NEW_KIND='L' AND @[del_t] = 'D' AND F_NO2 = 41  THEN" ).append("\n"); 
		query.append("        (SELECT TZTM_HRS FROM MDM_ZONE WHERE ZN_CD = NODE_NEW1 )" ).append("\n"); 
		query.append("        WHEN  NODE_NEW_KIND='L' AND @[rcv_t] =  'S' AND F_NO2 = 0   THEN 6" ).append("\n"); 
		query.append("        WHEN  NODE_NEW_KIND='L' AND @[rcv_t] =  'S' AND F_NO2 = 1  AND OB_SEQ = 0 THEN 6" ).append("\n"); 
		query.append("        WHEN  NODE_NEW_KIND='L' AND @[del_t] =  'S' AND F_NO2 = 41   THEN 6" ).append("\n"); 
		query.append("        WHEN  NODE_NEW_KIND='L' AND @[del_t] =  'S' AND F_NO2 = 29 AND IB_SEQ = 0 THEN 6" ).append("\n"); 
		query.append("        WHEN  NODE_NEW_KIND='L' AND @[rcv_t] NOT IN ( 'D','S' ) AND F_NO2 = 0   THEN 24" ).append("\n"); 
		query.append("        WHEN  NODE_NEW_KIND='L' AND @[del_t] NOT IN ( 'D','S' ) AND F_NO2 = 41  THEN 24" ).append("\n"); 
		query.append("        WHEN (F_NO2 =13 ) AND (NODE_NEW_KIND='L') THEN N1ST_TZTM_HRS" ).append("\n"); 
		query.append("        WHEN (F_NO2 =18 ) AND (NODE_NEW_KIND='L') THEN N2ND_TZTM_HRS" ).append("\n"); 
		query.append("        WHEN (F_NO2 =23 ) AND (NODE_NEW_KIND='L') THEN N3RD_TZTM_HRS" ).append("\n"); 
		query.append("        WHEN (F_NO2 =28 ) AND (NODE_NEW_KIND='L') THEN N4TH_TZTM_HRS" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='L' AND OI_BND_CD ='T' AND F_NO2 NOT IN (13,18,23,28) THEN 6" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("         NVL((SELECT TZTM_HRS" ).append("\n"); 
		query.append("            FROM PRD_INLND_EACH_LNK" ).append("\n"); 
		query.append("           WHERE lnk_org_nod_cd = NODE_NEW1" ).append("\n"); 
		query.append("            AND lnk_dest_nod_cd = DECODE(LENGTH(NODE_NEW2),7,NODE_NEW2,SUBSTR(NODE_NEW2,3,7))" ).append("\n"); 
		query.append("            AND TRSP_MOD_CD = DECODE(LENGTH(NODE_NEW2),7,'TD',SUBSTR(NODE_NEW2,10,2))" ).append("\n"); 
		query.append("            ),6)" ).append("\n"); 
		query.append("    END ) TZTM_DW_HRS," ).append("\n"); 
		query.append("    POLT1 POL_T," ).append("\n"); 
		query.append("    SUBSTR(TRIM(PODT1||PODT2||PODT3||PODT4),-14) POD_T ," ).append("\n"); 
		query.append("    A_TIME," ).append("\n"); 
		query.append("    D_TIME," ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='N' THEN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT TO_CHAR(N1ST_VNDR_SEQ)" ).append("\n"); 
		query.append("            FROM MDM_YARD" ).append("\n"); 
		query.append("            WHERE YD_CD = NODE_NEW1" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='L' AND F_NO2 IN (13,18,23,28) THEN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT TO_CHAR(VNDR_SEQ)" ).append("\n"); 
		query.append("            FROM PRD_FDR_LNK" ).append("\n"); 
		query.append("            WHERE VSL_SLAN_CD =DECODE(F_NO2,13,N1ST_LANE_CD,18,N2ND_LANE_CD,23,N3RD_LANE_CD,28,N4TH_LANE_CD)" ).append("\n"); 
		query.append("            AND LNK_ORG_LOC_CD = SUBSTR(NODE_NEW1,1,5)" ).append("\n"); 
		query.append("            AND LNK_DEST_LOC_CD = DECODE(LENGTH(NODE_NEW2),7,SUBSTR(NODE_NEW2,1,5),SUBSTR(NODE_NEW2,3,5))" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='L' AND LENGTH(NODE_NEW2) > 7 THEN DECODE(SUBSTR(NODE_NEW2,12,6),'N','',SUBSTR(NODE_NEW2,12,6))" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("           SELECT /*+ INDEX (M2 XAK1PRD_INLND_ROUT_MST) */" ).append("\n"); 
		query.append("           TO_CHAR(D2.VNDR_SEQ)" ).append("\n"); 
		query.append("           FROM PRD_INLND_ROUT_MST M2, PRD_INLND_ROUT_DTL D2" ).append("\n"); 
		query.append("           WHERE" ).append("\n"); 
		query.append("               M2.ROUT_ORG_NOD_CD = NODE_NEW1" ).append("\n"); 
		query.append("           AND M2.ROUT_DEST_NOD_CD = NODE_NEW2" ).append("\n"); 
		query.append("           AND M2.ROUT_ORG_NOD_CD = D2.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("           AND M2.ROUT_DEST_NOD_CD = D2.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("           AND M2.ROUT_SEQ = D2.ROUT_SEQ" ).append("\n"); 
		query.append("           AND M2.PCTL_IO_BND_CD = 'B'" ).append("\n"); 
		query.append("           AND NVL(M2.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("           AND D2.LNK_ORG_NOD_CD = NODE_NEW1" ).append("\n"); 
		query.append("           AND D2.LNK_DEST_NOD_CD = NODE_NEW2" ).append("\n"); 
		query.append("           AND D2.ROUT_DTL_SEQ = 1" ).append("\n"); 
		query.append("           AND 'Y' = CASE WHEN REGEXP_INSTR(@[ocn_str], NODE_NEW1 || '-..-.-...-' || NODE_NEW2 ) > 0 THEN" ).append("\n"); 
		query.append("                          DECODE(D2.TRSP_MOD_CD, SUBSTR(REGEXP_SUBSTR(@[ocn_str], NODE_NEW1 || '-..-.-...-' || NODE_NEW2), 9,2), 'Y','N')" ).append("\n"); 
		query.append("                     ELSE DECODE(NVL(M2.INLND_ROUT_BKG_FLG, 'N'), 'N', 'N', DECODE(NVL(M2.INLND_ROUT_TMP_FLG, 'N'), 'N', 'Y', 'N'))" ).append("\n"); 
		query.append("                     END" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    END ) N1ST_VNDR_SEQ," ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='N' THEN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT N2ND_VNDR_SEQ" ).append("\n"); 
		query.append("            FROM MDM_YARD" ).append("\n"); 
		query.append("            WHERE YD_CD = NODE_NEW1" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("     END ) N2ND_VNDR_SEQ," ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN NODE_NEW_KIND='N' THEN" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT N3RD_VNDR_SEQ" ).append("\n"); 
		query.append("            FROM MDM_YARD" ).append("\n"); 
		query.append("            WHERE YD_CD = NODE_NEW1" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("     END ) N3RD_VNDR_SEQ," ).append("\n"); 
		query.append("    (CASE" ).append("\n"); 
		query.append("        WHEN (F_NO2 =13 ) AND (NODE_NEW_KIND='L') THEN N1ST_LANE_CD" ).append("\n"); 
		query.append("        WHEN (F_NO2 =18 ) AND (NODE_NEW_KIND='L') THEN N2ND_LANE_CD" ).append("\n"); 
		query.append("        WHEN (F_NO2 =23 ) AND (NODE_NEW_KIND='L') THEN N3RD_LANE_CD" ).append("\n"); 
		query.append("        WHEN (F_NO2 =28 ) AND (NODE_NEW_KIND='L') THEN N4TH_LANE_CD" ).append("\n"); 
		query.append("    END ) SLANE," ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN F_NO2 IN (13,18,23,28) AND (NODE_NEW_KIND='L') THEN" ).append("\n"); 
		query.append("            SUBSTR(DECODE(F_NO2,13,VVD1,18,VVD2,23,VVD3,28,VVD4,NULL),1,4)" ).append("\n"); 
		query.append("    END ) VSL_CD," ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN F_NO2 IN (13,18,23,28) AND (NODE_NEW_KIND='L') THEN" ).append("\n"); 
		query.append("            SUBSTR(DECODE(F_NO2,13,VVD1,18,VVD2,23,VVD3,28,VVD4,NULL),5,4)" ).append("\n"); 
		query.append("    END ) VOY_NO," ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN F_NO2 IN (13,18,23,28) AND (NODE_NEW_KIND='L') THEN" ).append("\n"); 
		query.append("            SUBSTR(DECODE(F_NO2,13,VVD1,18,VVD2,23,VVD3,28,VVD4,NULL),9,1)" ).append("\n"); 
		query.append("    END ) DIR_CD," ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN F_NO2 IN (13,18,23,28) AND (NODE_NEW_KIND='L') THEN" ).append("\n"); 
		query.append("            DECODE(F_NO2,13,CRR1,18,CRR2,23,CRR3,28,CRR4,NULL)" ).append("\n"); 
		query.append("    END ) CRR_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN F_NO2 IN (13,18,23,28) AND (NODE_NEW_KIND='L') THEN" ).append("\n"); 
		query.append("            DECODE(F_NO2,13,POL_SEQ1,18,POL_SEQ2,23,POL_SEQ3,28,POL_SEQ4,NULL)" ).append("\n"); 
		query.append("    END ) ORG_PORT_SEQ," ).append("\n"); 
		query.append("    ( CASE" ).append("\n"); 
		query.append("        WHEN F_NO2 IN (13,18,23,28) AND (NODE_NEW_KIND='L') THEN" ).append("\n"); 
		query.append("            DECODE(F_NO2,13,POD_SEQ1,18,POD_SEQ2,23,POD_SEQ3,28,POD_SEQ4,NULL)" ).append("\n"); 
		query.append("    END ) DST_PORT_SEQ," ).append("\n"); 
		query.append("    DECODE(LENGTH(NODE_NEW2),7,'N',SUBSTR(NODE_NEW2,18,1))  INLND_ROUT_CMB_FLG," ).append("\n"); 
		query.append("    DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,19,3))  INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("    DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,22,3))  RAIL_CRR_TYPE," ).append("\n"); 
		query.append("    DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,25,3))  TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("    DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,28,6))  TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("    DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,34,15))  AGMT_REF_NO," ).append("\n"); 
		query.append("    DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,49,1))  INLND_ROUT_INCL_STTL_FLG," ).append("\n"); 
		query.append("    FULL_RTN_YD_CD,POL1,POD_NODE,FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("    DECODE(OI_BND_CD,'I',IB_ORG,'O',OB_ORG,'T',ORG_LOC_CD) ROUT_ORG," ).append("\n"); 
		query.append("    DECODE(OI_BND_CD,'I',IB_DEST,'O',OB_DEST,'T',DEST_LOC_CD) ROUT_DEST," ).append("\n"); 
		query.append("    DECODE(OI_BND_CD,'I',IB_SEQ,'O',OB_SEQ,'T',OCN_SEQ) ROUT_SEQ" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        GP1, F_NO2, L_N0, O1," ).append("\n"); 
		query.append("        ROW_NUMBER() over (PARTITION BY GP1, OI_BND_CD, NODE_NEW1, NODE_NEW2 ORDER BY F_NO2,L_N0,O1) O2,    -- Bound별, Link별 Ordering : for Ocean Shuttle S/O #2010.06.18 by sj" ).append("\n"); 
		query.append("        NODE_NEW1, NODE_NEW2, NODE_NEW_KIND, A_TIME, D_TIME, OI_BND_CD," ).append("\n"); 
		query.append("        N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD,CCT,POL1,POD_NODE," ).append("\n"); 
		query.append("        POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1," ).append("\n"); 
		query.append("        POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2," ).append("\n"); 
		query.append("        POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3," ).append("\n"); 
		query.append("        POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4," ).append("\n"); 
		query.append("        N1ST_TZTM_HRS ,N2ND_TZTM_HRS ,N3RD_TZTM_HRS ,N4TH_TZTM_HRS," ).append("\n"); 
		query.append("        OB_ORG, OB_DEST,OB_SEQ,OUT_CONTENT,MTPU_CY,FULL_RTN_YD_CD," ).append("\n"); 
		query.append("        IB_ORG, IB_DEST,IB_SEQ,IN_CONTENT,MTRTN_CY,DEL,FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("        ORG_LOC_CD, DEST_LOC_CD, OCN_SEQ" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("            GP1,  F_N0 AS F_NO2, L_N0, O1," ).append("\n"); 
		query.append("            (CASE LENGTH(NODE1) WHEN 7 THEN NODE1 ELSE SUBSTR(NODE1,3,7)  END ) NODE_NEW1," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("             CASE WHEN L_N0 = 1 THEN NODE1" ).append("\n"); 
		query.append("                  WHEN L_N0 = 2 AND F_N0 =41 AND @[del_t] = 'S' AND IB_SEQ =0 THEN ''" ).append("\n"); 
		query.append("                  WHEN L_N0 = 2 THEN LEAD(NODE1, 1, NULL) OVER (PARTITION BY GP1 ORDER BY GP1,F_N0,L_N0,O1)" ).append("\n"); 
		query.append("             END" ).append("\n"); 
		query.append("            ) NODE_NEW2," ).append("\n"); 
		query.append("            (CASE L_N0 WHEN 1 THEN 'N' WHEN 2 THEN 'L' END) NODE_NEW_KIND," ).append("\n"); 
		query.append("            ( CASE" ).append("\n"); 
		query.append("                WHEN F_N0 IN (13,18,23,28) AND (L_N0=2) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,13,POLT1,18,POLT2,23,POLT3,28,POLT4,NULL),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                WHEN F_N0 IN (18,23,28) AND (L_N0=1) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,13,POLT1,18,POLT2,23,POLT3,28,POLT4,NULL),'YYYYMMDDHH24MISS') -6/24 --CCT적용" ).append("\n"); 
		query.append("                WHEN F_N0 IN (14,19,24) AND (L_N0=2) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,14,PODT1,19,PODT2,24,PODT3,NULL),'YYYYMMDDHH24MISS') + 6/24" ).append("\n"); 
		query.append("                WHEN F_N0 IN (14,19,24) AND (L_N0=1) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,14,PODT1,19,PODT2,24,PODT3,NULL),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                WHEN F_N0 IN (15,20,25) AND (L_N0=1) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,15,PODT1,20,PODT2,25,PODT3,NULL),'YYYYMMDDHH24MISS') + 12/24" ).append("\n"); 
		query.append("                WHEN F_N0 IN (15,20,25) AND (L_N0=2) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,15,PODT1,20,PODT2,25,PODT3,NULL),'YYYYMMDDHH24MISS') + 18/24" ).append("\n"); 
		query.append("                WHEN F_N0 IN (16,21,26) AND (L_N0=1) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,16,PODT1,21,PODT2,26,PODT3,NULL),'YYYYMMDDHH24MISS') + 24/24" ).append("\n"); 
		query.append("                WHEN F_N0 IN (16,21,26) AND (L_N0=2) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,16,PODT1,21,PODT2,26,PODT3,NULL),'YYYYMMDDHH24MISS') + 30/24" ).append("\n"); 
		query.append("                WHEN F_N0 IN (17,22,27) AND (L_N0=1) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,17,PODT1,22,PODT2,27,PODT3,NULL),'YYYYMMDDHH24MISS') + 36/24" ).append("\n"); 
		query.append("                WHEN F_N0 IN (17,22,27) AND (L_N0=2) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,17,PODT1,22,PODT2,27,PODT3,NULL),'YYYYMMDDHH24MISS') + 42/24" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            END ) A_TIME," ).append("\n"); 
		query.append("            ( CASE" ).append("\n"); 
		query.append("                WHEN F_N0 IN (13,18,23,28) AND (L_N0=2) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,13,PODT1,18,PODT2,23,PODT3,28,PODT4,NULL),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                WHEN F_N0 IN (18,23,28) AND (L_N0=1) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,13,POLT1,18,POLT2,23,POLT3,28,POLT4,NULL),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                WHEN F_N0 IN (14,19,24) AND (L_N0=2) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,14,PODT1,19,PODT2,24,PODT3,NULL),'YYYYMMDDHH24MISS') + 12/24" ).append("\n"); 
		query.append("                WHEN F_N0 IN (14,19,24) AND (L_N0=1)  THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,14,PODT1,19,PODT2,24,PODT3,NULL),'YYYYMMDDHH24MISS') + 6/24" ).append("\n"); 
		query.append("                WHEN F_N0 IN (15,20,25) AND (L_N0=1) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,15,PODT1,20,PODT2,25,PODT3,NULL),'YYYYMMDDHH24MISS') + 18/24" ).append("\n"); 
		query.append("                WHEN F_N0 IN (15,20,25) AND (L_N0=2) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,15,PODT1,20,PODT2,25,PODT3,NULL),'YYYYMMDDHH24MISS') + 24/24" ).append("\n"); 
		query.append("                WHEN F_N0 IN (16,21,26) AND (L_N0=1) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,16,PODT1,21,PODT2,26,PODT3,NULL),'YYYYMMDDHH24MISS') + 30/24" ).append("\n"); 
		query.append("                WHEN F_N0 IN (16,21,26) AND (L_N0=2) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,16,PODT1,21,PODT2,26,PODT3,NULL),'YYYYMMDDHH24MISS') + 36/24" ).append("\n"); 
		query.append("                WHEN F_N0 IN (17,22,27) AND (L_N0=1) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,17,PODT1,22,PODT2,27,PODT3,NULL),'YYYYMMDDHH24MISS') + 42/24" ).append("\n"); 
		query.append("                WHEN F_N0 IN (17,22,27) AND (L_N0=2) THEN" ).append("\n"); 
		query.append("                    TO_DATE(DECODE(F_N0,17,PODT1,22,PODT2,27,PODT3,NULL),'YYYYMMDDHH24MISS') + 36/24" ).append("\n"); 
		query.append("            END ) D_TIME," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("                WHEN F_N0 <=12 OR (F_N0 = 13 AND L_N0 =1)  THEN 'O'" ).append("\n"); 
		query.append("                WHEN F_N0 >= 29  THEN 'I' ELSE 'T'" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("            ) OI_BND_CD," ).append("\n"); 
		query.append("            N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD,CCT,POL1,POD_NODE," ).append("\n"); 
		query.append("            POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1," ).append("\n"); 
		query.append("            POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2," ).append("\n"); 
		query.append("            POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3," ).append("\n"); 
		query.append("            POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4," ).append("\n"); 
		query.append("            N1ST_TZTM_HRS ,N2ND_TZTM_HRS ,N3RD_TZTM_HRS ,N4TH_TZTM_HRS," ).append("\n"); 
		query.append("            OB_ORG, OB_DEST,OB_SEQ,OUT_CONTENT,MTPU_CY,FULL_RTN_YD_CD," ).append("\n"); 
		query.append("            IB_ORG, IB_DEST,IB_SEQ,IN_CONTENT,MTRTN_CY,DEL,FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("            ORG_LOC_CD, DEST_LOC_CD, OCN_SEQ" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT C_POL,F_N0, GP1,NODE1,ROWNUM O1," ).append("\n"); 
		query.append("                N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("                N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS,CCT,POL1,POD_NODE,FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("                POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1," ).append("\n"); 
		query.append("                POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2," ).append("\n"); 
		query.append("                POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3," ).append("\n"); 
		query.append("                POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4," ).append("\n"); 
		query.append("                OB_ORG, OB_DEST,OB_SEQ,OUT_CONTENT,MTPU_CY,FULL_RTN_YD_CD," ).append("\n"); 
		query.append("                IB_ORG, IB_DEST,IB_SEQ,IN_CONTENT,MTRTN_CY,DEL," ).append("\n"); 
		query.append("                ORG_LOC_CD, DEST_LOC_CD,OCN_SEQ" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT" ).append("\n"); 
		query.append("                    GP1,F_N0," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    CASE F_N0" ).append("\n"); 
		query.append("                        WHEN 0 THEN MTPU_CY" ).append("\n"); 
		query.append("                        WHEN 1 THEN DECODE(@[rcv_t],'T','',DECODE(@[rcv_t],'F','',DECODE(@[por],@[pol],DECODE(OB_SEQ,0,DECODE(@[rcv_t],'D',OB_ORG,'S',OB_ORG,''),OB_ORG),OB_ORG)))" ).append("\n"); 
		query.append("                        WHEN 2 THEN OL_NODE01   WHEN 3 THEN OL_NODE02   WHEN 4 THEN OL_NODE03   WHEN 5 THEN OL_NODE04" ).append("\n"); 
		query.append("                        WHEN 6 THEN OL_NODE05   WHEN 7 THEN OL_NODE06   WHEN 8 THEN OL_NODE07   WHEN 9 THEN OL_NODE08" ).append("\n"); 
		query.append("                        WHEN 10 THEN OL_NODE09  WHEN 11 THEN OL_NODE10  WHEN 12 THEN NULL" ).append("\n"); 
		query.append("                        WHEN 13 THEN DECODE(@[rcv_t],'T',OB_ORG,DECODE(@[rcv_t],'F',OB_ORG,NVL(POL0,POL1)))  WHEN 14 THEN DECODE(POD1,POD_NODE,'',DECODE(POD1,POL2,DECODE(TS1_2,NULL,'',POD1),POD1)) --DECODE(POD1,POD_NODE,'',DECODE(POD1,POL2,'',POD1))" ).append("\n"); 
		query.append("                        WHEN 15 THEN TS1_2    WHEN 16 THEN TS1_3        WHEN 17 THEN TS1_4" ).append("\n"); 
		query.append("                        WHEN 18 THEN POL2     WHEN 19 THEN DECODE(POD2,POD_NODE,'',DECODE(POD2,POL3,DECODE(TS2_2,NULL,'',POD2),POD2))  --DECODE(POD2,POD_NODE,'',DECODE(POD2,POL3,'',POD2))" ).append("\n"); 
		query.append("                        WHEN 20 THEN TS2_2    WHEN 21 THEN TS2_3        WHEN 22 THEN TS2_4" ).append("\n"); 
		query.append("                        WHEN 23 THEN POL3     WHEN 24 THEN DECODE(POD3,POD_NODE,'',DECODE(POD3,POL4,DECODE(TS3_2,NULL,'',POD3),POD3))  --DECODE(POD3,POD_NODE,'',DECODE(POD3,POL4,'',POD3))" ).append("\n"); 
		query.append("                        WHEN 25 THEN TS3_2    WHEN 26 THEN TS3_3        WHEN 27 THEN TS3_4" ).append("\n"); 
		query.append("                        WHEN 28 THEN POL4     WHEN 29 THEN POD_NODE      WHEN 30 THEN NULL     WHEN 31 THEN IL_NODE01" ).append("\n"); 
		query.append("                        WHEN 32 THEN IL_NODE02  WHEN 33 THEN IL_NODE03  WHEN 34 THEN IL_NODE04  WHEN 35 THEN IL_NODE05" ).append("\n"); 
		query.append("                        WHEN 36 THEN IL_NODE06  WHEN 37 THEN IL_NODE07  WHEN 38 THEN IL_NODE08  WHEN 39 THEN IL_NODE09" ).append("\n"); 
		query.append("                        WHEN 40 THEN IL_NODE10" ).append("\n"); 
		query.append("                        WHEN 41 THEN DECODE(@[del_t],'T','',DECODE(@[del_t],'F','',DECODE(NVL(@[pod],SUBSTR(POD_NODE,1,5)),@[del],DECODE(IB_SEQ,0,DECODE(@[del_t],'D',DEL,'S',IB_DEST,''),DEL),DEL)))" ).append("\n"); 
		query.append("                        WHEN 42 THEN MTRTN_CY ELSE 'N/A'" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("                    ) NODE1, OUT_CONTENT,IN_CONTENT," ).append("\n"); 
		query.append("                    N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("                    N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS,CCT," ).append("\n"); 
		query.append("                    POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1," ).append("\n"); 
		query.append("                    POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2," ).append("\n"); 
		query.append("                    POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3," ).append("\n"); 
		query.append("                    POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4," ).append("\n"); 
		query.append("                    MTPU_CY,FULL_RTN_YD_CD," ).append("\n"); 
		query.append("                    OL_NODE01,OL_NODE02,OL_NODE03,OL_NODE04,OL_NODE05,OL_NODE06,OL_NODE07,OL_NODE08,OL_NODE09,OL_NODE10," ).append("\n"); 
		query.append("                    POL0 AS C_POL," ).append("\n"); 
		query.append("                    IL_NODE01,IL_NODE02,IL_NODE03,IL_NODE04,IL_NODE05,IL_NODE06,IL_NODE07,IL_NODE08,IL_NODE09,IL_NODE10," ).append("\n"); 
		query.append("                    DEL," ).append("\n"); 
		query.append("                    MTRTN_CY,POL1,POD_NODE,FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("                    OB_ORG,OB_DEST,OB_PRIO_SEQ,OB_SEQ," ).append("\n"); 
		query.append("                    IB_ORG,IB_DEST,IB_PRIO_SEQ,IB_SEQ," ).append("\n"); 
		query.append("                    ORG_LOC_CD,DEST_LOC_CD,OCN_SEQ" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                        OB_ORG,OB_DEST,OB_SEQ,OB_PRIO_SEQ,OB_CNT," ).append("\n"); 
		query.append("        			    (CASE WHEN @[rcv_t] = 'S' AND OB_SEQ = 0 THEN NULL" ).append("\n"); 
		query.append("        				  	  WHEN LENGTH(@[m_pu]) = 7 THEN @[m_pu]" ).append("\n"); 
		query.append("                              WHEN (SELECT MTY_PKUP_RTN_YD_CD FROM PRD_PKUP_RTN_YD" ).append("\n"); 
		query.append("                                        WHERE POR_DEL_CD = decode(POR_DEL_CD,'ALL',POR_DEL_CD, @[por])   " ).append("\n"); 
		query.append("                                        AND POL_POD_CD = decode(POL_POD_CD,'ALL',POL_POD_CD,  @[pol])" ).append("\n"); 
		query.append("                                        AND IO_BND_CD IN ('O','B')" ).append("\n"); 
		query.append("                                        AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                        AND SPCL_CGO_CD IN (  DECODE(NVL(@[dg_spcl_flg],'N'),'Y','DG','AL')," ).append("\n"); 
		query.append("                                                             DECODE(NVL(@[rf_spcl_flg],'N'),'Y','RF','AL')," ).append("\n"); 
		query.append("                                                             DECODE(NVL(@[rf_spcl_flg],'N')||NVL(@[dg_spcl_flg],'N')||NVL(@[spcl_awk_cgo_flg],'N'),'NNN','DR')," ).append("\n"); 
		query.append("															 DECODE(NVL(@[spcl_awk_cgo_flg] ,'N'),'Y','FO','AL')," ).append("\n"); 
		query.append("                                                             'AL')" ).append("\n"); 
		query.append("                                        AND VSL_SLAN_CD IN (N1ST_LANE_CD,'ALL')" ).append("\n"); 
		query.append("                                        AND ROWNUM =1) IS NOT NULL" ).append("\n"); 
		query.append("                                    THEN (SELECT MTY_PKUP_RTN_YD_CD" ).append("\n"); 
		query.append("                                        FROM (SELECT MTY_PKUP_RTN_YD_CD, VSL_SLAN_CD, DECODE(POR_DEL_CD,'ALL',10,0)+DECODE(POL_POD_CD,'ALL',10,0)+DECODE(VSL_SLAN_CD,'ALL',10,0)+DECODE(SPCL_CGO_CD,'AL',1,0) WGT" ).append("\n"); 
		query.append("                                              FROM PRD_PKUP_RTN_YD" ).append("\n"); 
		query.append("                                              WHERE POR_DEL_CD =decode(POR_DEL_CD,'ALL',POR_DEL_CD, @[por])   " ).append("\n"); 
		query.append("                                              AND POL_POD_CD =decode(POL_POD_CD,'ALL',POL_POD_CD,  @[pol])" ).append("\n"); 
		query.append("                                              AND IO_BND_CD IN ('O','B')" ).append("\n"); 
		query.append("                                              AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                              AND SPCL_CGO_CD IN ( DECODE(NVL(@[dg_spcl_flg],'N'),'Y','DG','AL')," ).append("\n"); 
		query.append("                                                                   DECODE(NVL(@[rf_spcl_flg],'N'),'Y','RF','AL')," ).append("\n"); 
		query.append("                                                                   DECODE(NVL(@[rf_spcl_flg],'N')||NVL(@[dg_spcl_flg],'N')||NVL(@[spcl_awk_cgo_flg],'N'),'NNN','DR')," ).append("\n"); 
		query.append("                                                                   DECODE(NVL(@[spcl_awk_cgo_flg] ,'N'),'Y','FO','AL')," ).append("\n"); 
		query.append("                                                                   'AL')" ).append("\n"); 
		query.append("                                              ORDER BY WGT" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                        WHERE VSL_SLAN_CD IN (N1ST_LANE_CD,'ALL')" ).append("\n"); 
		query.append("                                        AND ROWNUM =1)" ).append("\n"); 
		query.append("        				  	  WHEN @[rcv_t] ='D' THEN (SELECT Z.REP_YD_CD FROM MDM_ZONE Z WHERE Z.ZN_CD = OB_ORG AND NVL(Z.DELT_FLG,'N')='N')" ).append("\n"); 
		query.append("        				  	  ELSE (SELECT L.MTY_PKUP_YD_CD FROM MDM_LOCATION L WHERE L.LOC_CD =@[por] AND NVL(L.DELT_FLG,'N')='N')" ).append("\n"); 
		query.append("        			    END) MTPU_CY," ).append("\n"); 
		query.append("                        OB_ORG AS POR," ).append("\n"); 
		query.append("                        MAX(DECODE(OB_DTL_SEQ, 1 , DECODE(OB_CNT, 1 , '', OB_ROUT))) OL_NODE01," ).append("\n"); 
		query.append("                        MAX(DECODE(OB_DTL_SEQ, 2 , DECODE(OB_CNT, 2 , '', OB_ROUT))) OL_NODE02," ).append("\n"); 
		query.append("                        MAX(DECODE(OB_DTL_SEQ, 3 , DECODE(OB_CNT, 3 , '', OB_ROUT))) OL_NODE03," ).append("\n"); 
		query.append("                        MAX(DECODE(OB_DTL_SEQ, 4 , DECODE(OB_CNT, 4 , '', OB_ROUT))) OL_NODE04," ).append("\n"); 
		query.append("                        MAX(DECODE(OB_DTL_SEQ, 5 , DECODE(OB_CNT, 5 , '', OB_ROUT))) OL_NODE05," ).append("\n"); 
		query.append("                        MAX(DECODE(OB_DTL_SEQ, 6 , DECODE(OB_CNT, 6 , '', OB_ROUT))) OL_NODE06," ).append("\n"); 
		query.append("                        MAX(DECODE(OB_DTL_SEQ, 7 , DECODE(OB_CNT, 7 , '', OB_ROUT))) OL_NODE07," ).append("\n"); 
		query.append("                        MAX(DECODE(OB_DTL_SEQ, 8 , DECODE(OB_CNT, 8 , '', OB_ROUT))) OL_NODE08," ).append("\n"); 
		query.append("                        MAX(DECODE(OB_DTL_SEQ, 9 , DECODE(OB_CNT, 9 , '', OB_ROUT))) OL_NODE09," ).append("\n"); 
		query.append("                        MAX(DECODE(OB_DTL_SEQ, 10, DECODE(OB_CNT, 10, '', OB_ROUT))) OL_NODE10," ).append("\n"); 
		query.append("                        DECODE(OB_SEQ,0,NULL,MAX(OB_ROUT)) AS POL0 ," ).append("\n"); 
		query.append("                        MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 1 , '', DECODE(OB_DTL_SEQ, 1 , SUBSTR(OB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 2 , '', DECODE(OB_DTL_SEQ, 2 , '-'||SUBSTR(OB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 3 , '', DECODE(OB_DTL_SEQ, 3 , '-'||SUBSTR(OB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 4 , '', DECODE(OB_DTL_SEQ, 4 , '-'||SUBSTR(OB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 5 , '', DECODE(OB_DTL_SEQ, 5 , '-'||SUBSTR(OB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 6 , '', DECODE(OB_DTL_SEQ, 6 , '-'||SUBSTR(OB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 7 , '', DECODE(OB_DTL_SEQ, 7 , '-'||SUBSTR(OB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 8 , '', DECODE(OB_DTL_SEQ, 8 , '-'||SUBSTR(OB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 9 , '', DECODE(OB_DTL_SEQ, 9 , '-'||SUBSTR(OB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(OB_CNT, 1, '', DECODE(OB_CNT, 10, '', DECODE(OB_DTL_SEQ, 10, '-'||SUBSTR(OB_ROUT,3,7)))))" ).append("\n"); 
		query.append("                        AS OUT_CONTENT,FULL_RTN_YD_CD," ).append("\n"); 
		query.append("                        ORG_LOC_CD,DEST_LOC_CD,OCN_SEQ," ).append("\n"); 
		query.append("                        N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("                        N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS,CCT," ).append("\n"); 
		query.append("                        LNK_KNT," ).append("\n"); 
		query.append("                        POL1,POD1,TS1_2,TS1_3,TS1_4,POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1," ).append("\n"); 
		query.append("                        POL2,POD2,TS2_2,TS2_3,TS2_4,POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2," ).append("\n"); 
		query.append("                        POL3,POD3,TS3_2,TS3_3,TS3_4,POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3," ).append("\n"); 
		query.append("                        POL4,POD4,POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4," ).append("\n"); 
		query.append("                        POD_NODE," ).append("\n"); 
		query.append("                        CHECK_ROUT," ).append("\n"); 
		query.append("                        IB_ORG,IB_DEST,IB_SEQ,IB_PRIO_SEQ,IB_CNT," ).append("\n"); 
		query.append("                        MAX(DECODE(IB_DTL_SEQ, 1 , DECODE(IB_CNT, 1 , '', IB_ROUT))) IL_NODE01," ).append("\n"); 
		query.append("                        MAX(DECODE(IB_DTL_SEQ, 2 , DECODE(IB_CNT, 2 , '', IB_ROUT))) IL_NODE02," ).append("\n"); 
		query.append("                        MAX(DECODE(IB_DTL_SEQ, 3 , DECODE(IB_CNT, 3 , '', IB_ROUT))) IL_NODE03," ).append("\n"); 
		query.append("                        MAX(DECODE(IB_DTL_SEQ, 4 , DECODE(IB_CNT, 4 , '', IB_ROUT))) IL_NODE04," ).append("\n"); 
		query.append("                        MAX(DECODE(IB_DTL_SEQ, 5 , DECODE(IB_CNT, 5 , '', IB_ROUT))) IL_NODE05," ).append("\n"); 
		query.append("                        MAX(DECODE(IB_DTL_SEQ, 6 , DECODE(IB_CNT, 6 , '', IB_ROUT))) IL_NODE06," ).append("\n"); 
		query.append("                        MAX(DECODE(IB_DTL_SEQ, 7 , DECODE(IB_CNT, 7 , '', IB_ROUT))) IL_NODE07," ).append("\n"); 
		query.append("                        MAX(DECODE(IB_DTL_SEQ, 8 , DECODE(IB_CNT, 8 , '', IB_ROUT))) IL_NODE08," ).append("\n"); 
		query.append("                        MAX(DECODE(IB_DTL_SEQ, 9 , DECODE(IB_CNT, 9 , '', IB_ROUT))) IL_NODE09," ).append("\n"); 
		query.append("                        MAX(DECODE(IB_DTL_SEQ, 10, DECODE(IB_CNT, 10, '', IB_ROUT))) IL_NODE10," ).append("\n"); 
		query.append("                        MAX(DECODE(IB_SEQ,0,IB_DEST,IB_ROUT))  DEL," ).append("\n"); 
		query.append("                        MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 1 , '', DECODE(IB_DTL_SEQ, 1 , SUBSTR(IB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 2 , '', DECODE(IB_DTL_SEQ, 2 , '-'||SUBSTR(IB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 3 , '', DECODE(IB_DTL_SEQ, 3 , '-'||SUBSTR(IB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 4 , '', DECODE(IB_DTL_SEQ, 4 , '-'||SUBSTR(IB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 5 , '', DECODE(IB_DTL_SEQ, 5 , '-'||SUBSTR(IB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 6 , '', DECODE(IB_DTL_SEQ, 6 , '-'||SUBSTR(IB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 7 , '', DECODE(IB_DTL_SEQ, 7 , '-'||SUBSTR(IB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 8 , '', DECODE(IB_DTL_SEQ, 8 , '-'||SUBSTR(IB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 9 , '', DECODE(IB_DTL_SEQ, 9 , '-'||SUBSTR(IB_ROUT,3,7))))) ||" ).append("\n"); 
		query.append("                        MAX(DECODE(IB_CNT, 1, '', DECODE(IB_CNT, 10, '', DECODE(IB_DTL_SEQ, 10, '-'||SUBSTR(IB_ROUT,3,7)))))" ).append("\n"); 
		query.append("                        AS IN_CONTENT," ).append("\n"); 
		query.append("                        FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("        			    (CASE WHEN @[del_t] = 'S' AND IB_SEQ = 0 THEN NULL" ).append("\n"); 
		query.append("                              WHEN LENGTH(@[m_rt]) = 7 THEN @[m_rt]" ).append("\n"); 
		query.append("                              -- SELCOL 백선주대리요청으로 PRD_PKUP_RTN_YD 테이블에서 INBOUND 삭제로 인해(CHM-201004090)" ).append("\n"); 
		query.append("                              -- I/B 조건 원복 요청 , 박진영 대리 요청으로 원복 (CHM-201429679) 2014-04-14" ).append("\n"); 
		query.append("                              WHEN (SELECT MTY_PKUP_RTN_YD_CD FROM PRD_PKUP_RTN_YD" ).append("\n"); 
		query.append("                                        WHERE POR_DEL_CD = decode(POR_DEL_CD,'ALL',POR_DEL_CD,  @[del])   " ).append("\n"); 
		query.append("                                        AND POL_POD_CD = decode(POL_POD_CD,'ALL',POL_POD_CD,  SUBSTR(POD_NODE,1,5)) " ).append("\n"); 
		query.append("                                        AND IO_BND_CD IN ('I','B')" ).append("\n"); 
		query.append("                                        AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                        AND SPCL_CGO_CD IN ( DECODE(NVL(@[dg_spcl_flg],'N'),'Y','DG','AL')," ).append("\n"); 
		query.append("                                                             DECODE(NVL(@[rf_spcl_flg],'N'),'Y','RF','AL')," ).append("\n"); 
		query.append("                                                             DECODE(NVL(@[rf_spcl_flg],'N')||NVL(@[dg_spcl_flg],'N')||NVL(@[spcl_awk_cgo_flg],'N'),'NNN','DR')," ).append("\n"); 
		query.append("															 DECODE(NVL(@[spcl_awk_cgo_flg] ,'N'),'Y','FO','AL')," ).append("\n"); 
		query.append("                                                             'AL')" ).append("\n"); 
		query.append("                                        AND VSL_SLAN_CD IN( NVL(N4TH_LANE_CD,NVL(N3RD_LANE_CD,NVL(N2ND_LANE_CD,N1ST_LANE_CD))), 'ALL')" ).append("\n"); 
		query.append("                                        AND ROWNUM =1) IS NOT NULL" ).append("\n"); 
		query.append("                                  THEN (SELECT MTY_PKUP_RTN_YD_CD FROM PRD_PKUP_RTN_YD" ).append("\n"); 
		query.append("                                        WHERE POR_DEL_CD = decode(POR_DEL_CD,'ALL',POR_DEL_CD,  @[del]) " ).append("\n"); 
		query.append("                                        AND POL_POD_CD = decode(POL_POD_CD,'ALL',POL_POD_CD,  SUBSTR(POD_NODE,1,5)) " ).append("\n"); 
		query.append("                                        AND IO_BND_CD IN ('I','B')" ).append("\n"); 
		query.append("                                        AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                        AND SPCL_CGO_CD IN ( DECODE(NVL(@[dg_spcl_flg],'N'),'Y','DG','AL')," ).append("\n"); 
		query.append("                                                             DECODE(NVL(@[rf_spcl_flg],'N'),'Y','RF','AL')," ).append("\n"); 
		query.append("                                                             DECODE(NVL(@[rf_spcl_flg],'N')||NVL(@[dg_spcl_flg],'N')||NVL(@[spcl_awk_cgo_flg],'N'),'NNN','DR')," ).append("\n"); 
		query.append("															 DECODE(NVL(@[spcl_awk_cgo_flg] ,'N'),'Y','FO','AL')," ).append("\n"); 
		query.append("                                                             'AL')" ).append("\n"); 
		query.append("                                        AND VSL_SLAN_CD IN( NVL(N4TH_LANE_CD,NVL(N3RD_LANE_CD,NVL(N2ND_LANE_CD,N1ST_LANE_CD))),'ALL')" ).append("\n"); 
		query.append("                                        AND MTY_PKUP_RTN_YD_CD IN (" ).append("\n"); 
		query.append("                                                    SELECT FIRST_VALUE(MTY_PKUP_RTN_YD_CD ) OVER(ORDER BY (DECODE(POR_DEL_CD,'ALL',10,0)+DECODE(POL_POD_CD,'ALL',10,0)+DECODE(VSL_SLAN_CD,'ALL',10,0)+DECODE(SPCL_CGO_CD,'AL',1,0))  )" ).append("\n"); 
		query.append("                                                    FROM PRD_PKUP_RTN_YD" ).append("\n"); 
		query.append("                                                    WHERE POR_DEL_CD = decode(POR_DEL_CD,'ALL',POR_DEL_CD,  @[del]) " ).append("\n"); 
		query.append("                                                    AND POL_POD_CD = decode(POL_POD_CD,'ALL',POL_POD_CD,  SUBSTR(POD_NODE,1,5))" ).append("\n"); 
		query.append("                                                    AND IO_BND_CD IN ('I','B')" ).append("\n"); 
		query.append("                                                    AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                                    AND SPCL_CGO_CD IN ( DECODE(NVL(@[dg_spcl_flg],'N'),'Y','DG','AL')," ).append("\n"); 
		query.append("                                                             DECODE(NVL(@[rf_spcl_flg],'N'),'Y','RF','AL')," ).append("\n"); 
		query.append("                                                             DECODE(NVL(@[rf_spcl_flg],'N')||NVL(@[dg_spcl_flg],'N')||NVL(@[spcl_awk_cgo_flg],'N'),'NNN','DR')," ).append("\n"); 
		query.append("															 DECODE(NVL(@[spcl_awk_cgo_flg] ,'N'),'Y','FO','AL')," ).append("\n"); 
		query.append("                                                             'AL')" ).append("\n"); 
		query.append("                                                    AND VSL_SLAN_CD IN( NVL(N4TH_LANE_CD,NVL(N3RD_LANE_CD,NVL(N2ND_LANE_CD,N1ST_LANE_CD))),'ALL')                                        " ).append("\n"); 
		query.append("                                                   )" ).append("\n"); 
		query.append("                                        AND ROWNUM =1)" ).append("\n"); 
		query.append("        				  	  WHEN @[del_t] ='D' THEN (SELECT Z.REP_YD_CD FROM MDM_ZONE Z WHERE Z.ZN_CD = IB_DEST AND NVL(Z.DELT_FLG,'N') = 'N')" ).append("\n"); 
		query.append("        				  	  ELSE (SELECT L.EQ_RTN_YD_CD FROM MDM_LOCATION L WHERE L.LOC_CD =@[del] AND NVL(L.DELT_FLG,'N')='N')" ).append("\n"); 
		query.append("        			    END) MTRTN_CY," ).append("\n"); 
		query.append("                        RANK() OVER (ORDER BY  ORG_LOC_CD,DEST_LOC_CD,OCN_ROUT_PRIO_CD,OCN_SEQ, OB_ORG,OB_DEST,OB_SEQ," ).append("\n"); 
		query.append("                                    IB_ORG,IB_DEST,IB_SEQ,POL1,POD1,POL2, POD2,POL3,POD3,POL4,POD4) GP1" ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("                            SELECT" ).append("\n"); 
		query.append("                            OB_ORG,OB_DEST,OB_SEQ,ORG_ROUT,FULL_RTN_YD_CD," ).append("\n"); 
		query.append("                            RANK() OVER (PARTITION BY ORG_LOC_CD,DEST_LOC_CD,OCN_SEQ,OB_DEST ORDER BY FULL_RTN_PRIO_SEQ,OB_MODE_PRIO_SEQ,OB_OPTM_FLG,OB_BKG_FLG,OB_TMP_FLG,OB_PRIO_SEQ,OB_ROUT_SEQ) OB_RK," ).append("\n"); 
		query.append("                            OB_PRIO_SEQ," ).append("\n"); 
		query.append("                            RPAD(OD.ROUT_DTL_SEQ,2,' ')||OD.LNK_DEST_NOD_CD||OD.TRSP_MOD_CD||LPAD(NVL(OD.VNDR_SEQ,0),6,0)||" ).append("\n"); 
		query.append("                                   NVL(OD.INLND_ROUT_CMB_FLG,'N')||LPAD(NVL(OB_INLND_ROUT_INV_BIL_PATT_CD,' '),3,' ') ||" ).append("\n"); 
		query.append("                                   RPAD(NVL(OD.RAIL_CRR_TP_CD,' '),3,' ') || RPAD(NVL(OD.TRSP_AGMT_OFC_CTY_CD,' '),3,' ') || LPAD(NVL(OD.TRSP_AGMT_SEQ,0),6,0) ||" ).append("\n"); 
		query.append("                                   RPAD(NVL(OD.AGMT_REF_NO,' '),15,' ') || RPAD(NVL(OB_INLND_ROUT_INCL_STTL_FLG,' '),1,' ') OB_ROUT," ).append("\n"); 
		query.append("                            OD.ROUT_DTL_SEQ OB_DTL_SEQ," ).append("\n"); 
		query.append("    					    ------------------------------" ).append("\n"); 
		query.append("    					    OB_BKG_FLG,IB_BKG_FLG,OB_ROUT_SEQ,IB_ROUT_SEQ," ).append("\n"); 
		query.append("    					    -------------------------------" ).append("\n"); 
		query.append("                            COUNT(DISTINCT OD.ROUT_DTL_SEQ) OVER (PARTITION BY OB_ORG,OB_DEST,OB_SEQ) AS OB_CNT," ).append("\n"); 
		query.append("                            ORG_LOC_CD,DEST_LOC_CD,OCN_SEQ,LNK_KNT,OCN_ROUT_PRIO_CD," ).append("\n"); 
		query.append("                            N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("                            N1ST_TZTM_HRS ,N2ND_TZTM_HRS ,N3RD_TZTM_HRS ,N4TH_TZTM_HRS,CCT," ).append("\n"); 
		query.append("    						-- Feeder구간을BKG보다 TRS SO의 Yard를 우선으로 POL Yard 변경시" ).append("\n"); 
		query.append("    						-- TS구간이 이전 TS구간의 Yard와 중복되는 현상 제거를 위해" ).append("\n"); 
		query.append("    						-- 변경된 POL Yard와  TS구간을 비교하여 Null처리" ).append("\n"); 
		query.append("                            POL1,POD1," ).append("\n"); 
		query.append("                            DECODE(TS1_CNT, 1, DECODE(TS1_2, POL2, NULL, TS1_2), TS1_2) TS1_2," ).append("\n"); 
		query.append("                            DECODE(TS1_CNT, 2, DECODE(TS1_3, POL2, NULL, TS1_3), TS1_3) TS1_3," ).append("\n"); 
		query.append("                            DECODE(TS1_CNT, 3, DECODE(TS1_4, POL2, NULL, TS1_4), TS1_4) TS1_4," ).append("\n"); 
		query.append("                            POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1," ).append("\n"); 
		query.append("                            POL2,POD2," ).append("\n"); 
		query.append("                            DECODE(TS2_CNT, 1, DECODE(TS2_2, POL3, NULL, TS2_2), TS2_2) TS2_2," ).append("\n"); 
		query.append("                            DECODE(TS2_CNT, 2, DECODE(TS2_3, POL3, NULL, TS2_3), TS2_3) TS2_3," ).append("\n"); 
		query.append("                            DECODE(TS2_CNT, 3, DECODE(TS2_4, POL3, NULL, TS2_4), TS2_4) TS2_4," ).append("\n"); 
		query.append("                            POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2," ).append("\n"); 
		query.append("                            POL3,POD3," ).append("\n"); 
		query.append("                            DECODE(TS3_CNT, 1, DECODE(TS3_2, POL4, NULL, TS3_2), TS3_2) TS3_2," ).append("\n"); 
		query.append("                            DECODE(TS3_CNT, 2, DECODE(TS3_3, POL4, NULL, TS3_3), TS3_3) TS3_3," ).append("\n"); 
		query.append("                            DECODE(TS3_CNT, 3, DECODE(TS3_4, POL4, NULL, TS3_4), TS3_4) TS3_4," ).append("\n"); 
		query.append("                            POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3," ).append("\n"); 
		query.append("                            POL4,POD4,POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4," ).append("\n"); 
		query.append("                            POD_NODE," ).append("\n"); 
		query.append("                            CHECK_ROUT," ).append("\n"); 
		query.append("                            IB_ORG,IB_DEST,IB_PRIO_SEQ,IB_SEQ,DEST_ROUT,FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("                            RANK() OVER (PARTITION BY ORG_LOC_CD,DEST_LOC_CD,OCN_SEQ,IB_ORG ORDER BY IB_MODE_PRIO_SEQ,IB_OPTM_FLG,IB_BKG_FLG,IB_TMP_FLG,IB_PRIO_SEQ,IB_ROUT_SEQ ) IB_RK," ).append("\n"); 
		query.append("                            RPAD(ID.ROUT_DTL_SEQ,2,' ')||ID.LNK_DEST_NOD_CD||ID.TRSP_MOD_CD||LPAD(NVL(ID.VNDR_SEQ,0),6,0)||" ).append("\n"); 
		query.append("                            NVL(ID.INLND_ROUT_CMB_FLG,'N')||LPAD(NVL(IB_INLND_ROUT_INV_BIL_PATT_CD,' '),3,' ') ||" ).append("\n"); 
		query.append("                            RPAD(NVL(ID.RAIL_CRR_TP_CD,' '),3,' ') || RPAD(NVL(ID.TRSP_AGMT_OFC_CTY_CD,' '),3,' ') || LPAD(NVL(ID.TRSP_AGMT_SEQ,0),6,0) ||" ).append("\n"); 
		query.append("                            RPAD(NVL(ID.AGMT_REF_NO,' '),15,' ') || RPAD(NVL(IB_INLND_ROUT_INCL_STTL_FLG,' '),1,' ') IB_ROUT," ).append("\n"); 
		query.append("                            ID.ROUT_DTL_SEQ IB_DTL_SEQ," ).append("\n"); 
		query.append("                            COUNT(DISTINCT ID.ROUT_DTL_SEQ) OVER (PARTITION BY IB_ORG,IB_DEST,IB_SEQ) AS IB_CNT" ).append("\n"); 
		query.append("                            FROM" ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                                SELECT ROWNUM," ).append("\n"); 
		query.append("                                NVL(O.ROUT_ORG_NOD_CD,POL1) OB_ORG," ).append("\n"); 
		query.append("                                NVL(O.ROUT_DEST_NOD_CD,POL1) OB_DEST," ).append("\n"); 
		query.append("                                DECODE(NVL(@[f_rt],'X'),O.FULL_RTN_YD_CD,1,2) FULL_RTN_PRIO_SEQ," ).append("\n"); 
		query.append("                                NVL(O.FULL_RTN_YD_CD,POL1) FULL_RTN_YD_CD," ).append("\n"); 
		query.append("                                DECODE(SIGN(INSTR(O.TRSP_MOD_CD,NVL(@[ob_trsp_mode],'AL'))),1,1,2) OB_MODE_PRIO_SEQ," ).append("\n"); 
		query.append("                                PRD_GET_INLND_ROUT_STR_FNC(O.ROUT_ORG_NOD_CD,O.ROUT_DEST_NOD_CD,O.ROUT_SEQ) ORG_ROUT," ).append("\n"); 
		query.append("                                O.PRIO_SEQ OB_PRIO_SEQ," ).append("\n"); 
		query.append("                                NVL(O.ROUT_SEQ,0) OB_SEQ," ).append("\n"); 
		query.append("                                O.INLND_ROUT_INCL_STTL_FLG OB_INLND_ROUT_INCL_STTL_FLG," ).append("\n"); 
		query.append("                                O.INLND_ROUT_INV_BIL_PATT_CD OB_INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("    					        --------------" ).append("\n"); 
		query.append("    					        DECODE(O.INLND_ROUT_OPTM_FLG,'Y', 1, 2) OB_OPTM_FLG," ).append("\n"); 
		query.append("    					        DECODE(I.INLND_ROUT_OPTM_FLG,'Y', 1, 2) IB_OPTM_FLG," ).append("\n"); 
		query.append("    					        DECODE(NVL(O.INLND_ROUT_BKG_FLG,'N'), 'Y',1,2) OB_BKG_FLG," ).append("\n"); 
		query.append("    					        DECODE(NVL(I.INLND_ROUT_BKG_FLG,'N'), 'Y',1,2) IB_BKG_FLG," ).append("\n"); 
		query.append("    					        NVL(O.ROUT_SEQ,0) OB_ROUT_SEQ ," ).append("\n"); 
		query.append("    					        NVL(I.ROUT_SEQ,0) IB_ROUT_SEQ ," ).append("\n"); 
		query.append("                                NVL(O.INLND_ROUT_TMP_FLG,'N') OB_TMP_FLG," ).append("\n"); 
		query.append("                                NVL(I.INLND_ROUT_TMP_FLG,'N') IB_TMP_FLG," ).append("\n"); 
		query.append("    					        ----------------------" ).append("\n"); 
		query.append("                                T.ORG_LOC_CD,T.DEST_LOC_CD,T.ROUT_SEQ OCN_SEQ,T.LNK_KNT,T.OCN_ROUT_PRIO_CD," ).append("\n"); 
		query.append("                                T.N1ST_LANE_CD,T.N2ND_LANE_CD,T.N3RD_LANE_CD,T.N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("                                T.N1ST_TZTM_HRS,T.N2ND_TZTM_HRS,T.N3RD_TZTM_HRS,T.N4TH_TZTM_HRS,T.CCT," ).append("\n"); 
		query.append("                                T.POD_NODE," ).append("\n"); 
		query.append("                                T.POL1," ).append("\n"); 
		query.append("                                DECODE(T.OPR1, 1, T.TS1_1, T.POD1) POD1," ).append("\n"); 
		query.append("                                DECODE(T.OPR1, 1, T.TS1_2, T.TS1_1)  TS1_2," ).append("\n"); 
		query.append("                                DECODE(T.OPR1, 1, T.TS1_3, T.TS1_2)  TS1_3," ).append("\n"); 
		query.append("                                DECODE(T.OPR1, 1, T.TS1_4, T.TS1_3)  TS1_4," ).append("\n"); 
		query.append("                                DECODE(NULL, T.TS1_1, 0, T.TS1_2, 1, T.TS1_3, 2, T.TS1_4, 3, T.TS1_5, 4, 5) - NVL(OPR1,0) TS1_CNT," ).append("\n"); 
		query.append("                                T.POLT1,T.PODT1,T.VVD1,T.CRR1,T.POL_SEQ1,T.POD_SEQ1," ).append("\n"); 
		query.append("                                DECODE(T.POL2,NULL,NULL, DECODE(N2ND_SVC_TP,'O',NVL(SUBSTR(TRIM(T.TS1_1||T.TS1_2||T.TS1_3||T.TS1_4||T.TS1_5), -7),T.POL2),T.POL2)) POL2," ).append("\n"); 
		query.append("                                DECODE(T.OPR2, 1, T.TS2_1, T.POD2) POD2," ).append("\n"); 
		query.append("                                DECODE(T.OPR2, 1, T.TS2_2, T.TS2_1)  TS2_2," ).append("\n"); 
		query.append("                                DECODE(T.OPR2, 1, T.TS2_3, T.TS2_2)  TS2_3," ).append("\n"); 
		query.append("                                DECODE(T.OPR2, 1, T.TS2_4, T.TS2_3)  TS2_4," ).append("\n"); 
		query.append("                                DECODE(NULL, T.TS2_1, 0, T.TS2_2, 1, T.TS2_3, 2, T.TS2_4, 3, T.TS2_5, 4, 5) - NVL(OPR2,0) TS2_CNT," ).append("\n"); 
		query.append("                                T.POLT2,T.PODT2,T.VVD2,T.CRR2,T.POL_SEQ2,T.POD_SEQ2," ).append("\n"); 
		query.append("                                DECODE(T.POL3,NULL,NULL, DECODE(N3RD_SVC_TP,'O',NVL(SUBSTR(TRIM(T.TS2_1||T.TS2_2||T.TS2_3||T.TS2_4||T.TS2_5), -7),T.POL3),T.POL3)) POL3," ).append("\n"); 
		query.append("                                DECODE(T.OPR3, 1, T.TS3_1, T.POD3) POD3," ).append("\n"); 
		query.append("                                DECODE(T.OPR3, 1, T.TS3_2, T.TS3_1)  TS3_2," ).append("\n"); 
		query.append("                                DECODE(T.OPR3, 1, T.TS3_3, T.TS3_2)  TS3_3," ).append("\n"); 
		query.append("                                DECODE(T.OPR3, 1, T.TS3_4, T.TS3_3)  TS3_4," ).append("\n"); 
		query.append("                                DECODE(NULL, T.TS3_1, 0, T.TS3_2, 1, T.TS3_3, 2, T.TS3_4, 3, T.TS3_5, 4, 5) - NVL(OPR3,0) TS3_CNT," ).append("\n"); 
		query.append("                                T.POLT3,T.PODT3,T.VVD3,T.CRR3,T.POL_SEQ3,T.POD_SEQ3," ).append("\n"); 
		query.append("                                DECODE(T.POL4,NULL,NULL,DECODE(N4TH_SVC_TP,'O',NVL(SUBSTR(TRIM(T.TS3_1||T.TS3_2||T.TS3_3||T.TS3_4||T.TS3_5), -7),T.POL4),T.POL4)) POL4," ).append("\n"); 
		query.append("                                T.POD4,T.POLT4,T.PODT4,T.VVD4,T.CRR4,T.POL_SEQ4,T.POD_SEQ4," ).append("\n"); 
		query.append("                                T.CHECK_ROUT," ).append("\n"); 
		query.append("                                NVL(I.ROUT_ORG_NOD_CD,T.POD_NODE) IB_ORG," ).append("\n"); 
		query.append("                                NVL(I.ROUT_DEST_NOD_CD,T.POD_NODE) IB_DEST," ).append("\n"); 
		query.append("                                NVL(I.FULL_PKUP_YD_CD,T.POD_NODE) FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("                                DECODE(SIGN(INSTR(I.TRSP_MOD_CD,NVL(@[ib_trsp_mode],'AL'))),1,1,2) IB_MODE_PRIO_SEQ," ).append("\n"); 
		query.append("                                PRD_GET_INLND_ROUT_STR_FNC(I.ROUT_ORG_NOD_CD,I.ROUT_DEST_NOD_CD,I.ROUT_SEQ) DEST_ROUT," ).append("\n"); 
		query.append("                                I.PRIO_SEQ IB_PRIO_SEQ," ).append("\n"); 
		query.append("                                NVL(I.ROUT_SEQ,0) IB_SEQ," ).append("\n"); 
		query.append("                                I.INLND_ROUT_INCL_STTL_FLG IB_INLND_ROUT_INCL_STTL_FLG," ).append("\n"); 
		query.append("                                I.INLND_ROUT_INV_BIL_PATT_CD IB_INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("                                I.PCTL_IO_BND_CD," ).append("\n"); 
		query.append("                                (CASE WHEN NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                                               FROM BKG_TRO" ).append("\n"); 
		query.append("                                               WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                               AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                               AND CXL_FLG = 'N'" ).append("\n"); 
		query.append("                                               AND ROWNUM = 1),'N') = 'N'" ).append("\n"); 
		query.append("                                           AND NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                                               FROM BKG_EUR_TRO" ).append("\n"); 
		query.append("                                               WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                               AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                               AND CXL_FLG = 'N'" ).append("\n"); 
		query.append("                                               AND ROWNUM = 1),'N') = 'N'" ).append("\n"); 
		query.append("                                           AND NVL((SELECT 'Y' FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("                                               WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                               AND TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("                                               AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                               AND ROWNUM = 1),'N') = 'N'" ).append("\n"); 
		query.append("                                           AND NVL((SELECT 'Y' FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("                                               WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                               AND TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("                                               AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                               AND ROWNUM = 1),'N') = 'N'" ).append("\n"); 
		query.append("                                       THEN DECODE(NVL(O.INLND_ROUT_BKG_FLG,'N'),'Y',DECODE(NVL(O.INLND_ROUT_TMP_FLG,'N'),'N','Y','N'),'N')" ).append("\n"); 
		query.append("                                       ELSE 'Y'" ).append("\n"); 
		query.append("                                END) ORG_FLG_CHK," ).append("\n"); 
		query.append("                                (CASE WHEN NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                                               FROM BKG_TRO" ).append("\n"); 
		query.append("                                               WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                               AND IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                                               AND CXL_FLG = 'N'" ).append("\n"); 
		query.append("                                               AND ROWNUM = 1),'N') = 'N'" ).append("\n"); 
		query.append("                                           AND NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                                               FROM BKG_EUR_TRO" ).append("\n"); 
		query.append("                                               WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                               AND IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                                               AND CXL_FLG = 'N'" ).append("\n"); 
		query.append("                                               AND ROWNUM = 1),'N') = 'N'" ).append("\n"); 
		query.append("                                           AND NVL((SELECT 'Y' FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("                                               WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                               AND TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("                                               AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                               AND ROWNUM = 1),'N') = 'N'" ).append("\n"); 
		query.append("                                           AND NVL((SELECT 'Y' FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("                                               WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                               AND TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("                                               AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                               AND ROWNUM = 1),'N') = 'N'" ).append("\n"); 
		query.append("                                       THEN DECODE(NVL(I.INLND_ROUT_BKG_FLG,'N'),'Y',DECODE(NVL(I.INLND_ROUT_TMP_FLG,'N'),'N','Y','N'),'N')" ).append("\n"); 
		query.append("                                       ELSE 'Y'" ).append("\n"); 
		query.append("                                END) DEST_FLG_CHK," ).append("\n"); 
		query.append("                                (CASE WHEN O.ROUT_ORG_NOD_CD IS NULL AND LENGTH(@[por_n]) = 7 AND T.POL1 <> @[por_n] THEN 'X' -- IRG못찾고 POR NODE가 있으면서 POR NODE <> POL NODE면 실패 CHM-201112214" ).append("\n"); 
		query.append("                                      WHEN O.ROUT_ORG_NOD_CD IS NULL" ).append("\n"); 
		query.append("                                        AND @[por] = @[pol] AND @[rcv_t] = 'S' AND POL1_S ='Y' THEN 'Y'" ).append("\n"); 
		query.append("                                      WHEN O.ROUT_ORG_NOD_CD IS NULL" ).append("\n"); 
		query.append("                                        AND @[por] = @[pol] AND @[rcv_t] NOT IN ('D', 'S') THEN 'Y'" ).append("\n"); 
		query.append("                                      WHEN O.ROUT_ORG_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("                                        AND (SELECT 'X' FROM PRD_NODE N" ).append("\n"); 
		query.append("                                             WHERE N.NOD_CD = O.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                                               AND DECODE(N.NOD_TP_CD,'Z','D',N.NOD_TP_CD) IN (DECODE(@[rcv_t],'D','D','')," ).append("\n"); 
		query.append("                                                                                           DECODE(@[rcv_t],'T','B','F','B','Y','B','S','B','')," ).append("\n"); 
		query.append("                                                                                           DECODE(@[rcv_t],'T','M','F','M','Y','M','S','M','')," ).append("\n"); 
		query.append("                                                                                           DECODE(@[rcv_t],'Y','Y','S','Y','')," ).append("\n"); 
		query.append("                                                                                           DECODE(@[rcv_t],'Y','R','S','R','')," ).append("\n"); 
		query.append("                                                                                           DECODE(@[rcv_t],'Y','P','') )" ).append("\n"); 
		query.append("                                             ) = 'X'" ).append("\n"); 
		query.append("                                             AND NVL(O.PCTL_IO_BND_CD,'O')  IN ('O','B')" ).append("\n"); 
		query.append("                                             AND DECODE(@[rcv_t],'S','Y','X') =" ).append("\n"); 
		query.append("                                                                    NVL((SELECT DECODE(@[rcv_t],'S',YD_FCTY_TP_CFS_FLG,'X')" ).append("\n"); 
		query.append("                                                                         FROM MDM_YARD" ).append("\n"); 
		query.append("                                                                         WHERE YD_CD=O.ROUT_ORG_NOD_CD),'X')" ).append("\n"); 
		query.append("                                             AND O.ROUT_ORG_NOD_CD  LIKE DECODE(@[rcv_t],'F','','T',''," ).append("\n"); 
		query.append("                                                                                  DECODE(@[por_n],''," ).append("\n"); 
		query.append("                                                                                       DECODE(@[rcv_t],'D',(SELECT REP_ZN_CD FROM MDM_LOCATION L WHERE LOC_CD = @[por] AND NVL(L.DELT_FLG,'N')='N'),@[por]||'%')" ).append("\n"); 
		query.append("                                                                                  ,@[por_n])" ).append("\n"); 
		query.append("                                                                           )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                             THEN 'Y'" ).append("\n"); 
		query.append("                                      ELSE 'X'" ).append("\n"); 
		query.append("                                 END) ORG_CHECK," ).append("\n"); 
		query.append("                                 (CASE WHEN I.ROUT_DEST_NOD_CD IS NULL AND LENGTH(@[del_n]) = 7 AND T.POD_NODE <> @[del_n] THEN 'X' -- IRG못찾고 DEL NODE가 있으면서 POD NODE <> DEL NODE면 실패 CHM-201112214" ).append("\n"); 
		query.append("                                       WHEN I.ROUT_DEST_NOD_CD IS NULL" ).append("\n"); 
		query.append("                                        AND NVL(@[pod],SUBSTR( T.POD_NODE ,1,5)) = @[del] AND @[del_t] = 'S' AND POD_NODE_S ='Y' THEN 'Y'" ).append("\n"); 
		query.append("                                       WHEN I.ROUT_DEST_NOD_CD IS NULL" ).append("\n"); 
		query.append("                                        AND NVL(@[pod],SUBSTR( T.POD_NODE ,1,5)) = @[del] AND @[del_t] NOT IN ('D', 'S') THEN 'Y'" ).append("\n"); 
		query.append("                                       WHEN I.ROUT_DEST_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("                                        AND (SELECT 'X' FROM PRD_NODE N" ).append("\n"); 
		query.append("                                             WHERE N.NOD_CD = I.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                                               AND DECODE(N.NOD_TP_CD,'Z','D',N.NOD_TP_CD) IN (DECODE(@[del_t],'D','D','')," ).append("\n"); 
		query.append("                                                                                           DECODE(@[del_t],'T','B','F','B','Y','B','S','B','')," ).append("\n"); 
		query.append("                                                                                           DECODE(@[del_t],'T','M','F','M','Y','M','S','M','')," ).append("\n"); 
		query.append("                                                                                           DECODE(@[del_t],'Y','Y','S','Y','')," ).append("\n"); 
		query.append("                                                                                           DECODE(@[del_t],'Y','R','S','R','')," ).append("\n"); 
		query.append("                                                                                           DECODE(@[del_t],'Y','P','') )" ).append("\n"); 
		query.append("                                             ) = 'X'" ).append("\n"); 
		query.append("                                             AND NVL(I.PCTL_IO_BND_CD,'I') IN ('I','B')" ).append("\n"); 
		query.append("                                             AND DECODE(@[del_t],'S','Y','X') =" ).append("\n"); 
		query.append("                                                                    NVL((SELECT DECODE(@[del_t],'S',YD_FCTY_TP_CFS_FLG,'X')" ).append("\n"); 
		query.append("                                                                         FROM MDM_YARD" ).append("\n"); 
		query.append("                                                                         WHERE YD_CD=I.ROUT_DEST_NOD_CD),'X')" ).append("\n"); 
		query.append("                                             AND I.ROUT_DEST_NOD_CD  LIKE DECODE(@[del_t],'F','','T',''," ).append("\n"); 
		query.append("                                                                                  DECODE(@[del_n],''," ).append("\n"); 
		query.append("                                                                                       DECODE(@[del_t],'D',(SELECT REP_ZN_CD FROM MDM_LOCATION L WHERE LOC_CD = @[del] AND NVL(L.DELT_FLG,'N')='N'),@[del]||'%')" ).append("\n"); 
		query.append("                                                                                  ,@[del_n])" ).append("\n"); 
		query.append("                                                                           )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                             THEN 'Y'" ).append("\n"); 
		query.append("                                      ELSE 'X'" ).append("\n"); 
		query.append("                                 END) DEST_CHECK" ).append("\n"); 
		query.append("                                    FROM (" ).append("\n"); 
		query.append("                                    SELECT ROWNUM," ).append("\n"); 
		query.append("                                    -- 여기서 OCN STRING으로 비교한다." ).append("\n"); 
		query.append("                                    -- 완벽히 맞춰 줄 수 없기에 NODE만 맞춰준다." ).append("\n"); 
		query.append("                                    -- WHERE 절에도 모든 LOCATION이 존재하는 지 파악한다." ).append("\n"); 
		query.append("                                    --DECODE(SIGN(INSTR(O.TRSP_MOD_CD,SUBSTR(:sOBTrspMode,1,1))),1,1,2)" ).append("\n"); 
		query.append("                                    ORG_LOC_CD,DEST_LOC_CD,ROUT_SEQ,LNK_KNT,OCN_ROUT_PRIO_CD," ).append("\n"); 
		query.append("    								N1ST_SVC_TP,N2ND_SVC_TP, N3RD_SVC_TP,N4TH_SVC_TP," ).append("\n"); 
		query.append("                                    N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("                                    N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS,CCT," ).append("\n"); 
		query.append("                                    DECODE(N1ST_SVC_TP,'O'," ).append("\n"); 
		query.append("                                    	DECODE(DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POL1,1,5),1,1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POL1,1,5),1,1),7)),NULL,POL1," ).append("\n"); 
		query.append("                                           	   DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POL1,1,5),1,1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POL1,1,5),1,1),7))),POL1) POL1," ).append("\n"); 
		query.append("                                    (SELECT YD_FCTY_TP_CFS_FLG" ).append("\n"); 
		query.append("                                     FROM MDM_YARD" ).append("\n"); 
		query.append("                                     WHERE YD_CD=DECODE(N1ST_SVC_TP,'O'," ).append("\n"); 
		query.append("    												DECODE(DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POL1,1,5),1,1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POL1,1,5),1,1),7)),NULL,POL1," ).append("\n"); 
		query.append("                                           				   DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POL1,1,5),1,1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POL1,1,5),1,1),7))),POL1) ) POL1_S," ).append("\n"); 
		query.append("                                    POD1,--:ocn_str," ).append("\n"); 
		query.append("                                    DECODE(N1ST_SVC_TP, 'O', DECODE(DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD1,1,5),1,1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD1,1,5),1,1),7)), NULL, 0, 1)" ).append("\n"); 
		query.append("                                                      , DECODE(POD1,DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD1,1,5),1,1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD1,1,5),1,1),7)), 1, 0)) OPR1," ).append("\n"); 
		query.append("                                    DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD1,1,5),1,1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD1,1,5),1,1),7)) TS1_1," ).append("\n"); 
		query.append("                                    DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD1,1,5),1,2)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD1,1,5),1,2),7)) TS1_2," ).append("\n"); 
		query.append("                                    DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD1,1,5),1,3)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD1,1,5),1,3),7)) TS1_3," ).append("\n"); 
		query.append("                                    DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD1,1,5),1,4)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD1,1,5),1,4),7)) TS1_4," ).append("\n"); 
		query.append("                                    DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD1,1,5),1,5)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD1,1,5),1,5),7)) TS1_5," ).append("\n"); 
		query.append("                                    POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1," ).append("\n"); 
		query.append("                                    POL2," ).append("\n"); 
		query.append("                                    POD2," ).append("\n"); 
		query.append("                                    DECODE(N2ND_SVC_TP, 'O', DECODE(DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD2,1,5),1,1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD2,1,5),1,1),7)), NULL, 0, 1)" ).append("\n"); 
		query.append("                                                      , DECODE(POD2,DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD2,1,5),1,1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD2,1,5),1,1),7)), 1, 0)) OPR2," ).append("\n"); 
		query.append("                                    DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD2,1,5),1,1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD2,1,5),1,1),7)) TS2_1," ).append("\n"); 
		query.append("                                    DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD2,1,5),1,2)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD2,1,5),1,2),7)) TS2_2," ).append("\n"); 
		query.append("                                    DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD2,1,5),1,3)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD2,1,5),1,3),7)) TS2_3," ).append("\n"); 
		query.append("                                    DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD2,1,5),1,4)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD2,1,5),1,4),7)) TS2_4," ).append("\n"); 
		query.append("                                    DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD2,1,5),1,5)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD2,1,5),1,5),7)) TS2_5," ).append("\n"); 
		query.append("                                    POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2," ).append("\n"); 
		query.append("                                    POL3," ).append("\n"); 
		query.append("                                    POD3," ).append("\n"); 
		query.append("                                    DECODE(N3RD_SVC_TP, 'O', DECODE(DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD3,1,5),1,1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD3,1,5),1,1),7)), NULL, 0, 1)" ).append("\n"); 
		query.append("                                                      , DECODE(POD3,DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD3,1,5),1,1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD3,1,5),1,1),7)), 1, 0)) OPR3," ).append("\n"); 
		query.append("                                    DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD3,1,5),1,1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD3,1,5),1,1),7)) TS3_1," ).append("\n"); 
		query.append("                                    DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD3,1,5),1,2)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD3,1,5),1,2),7)) TS3_2," ).append("\n"); 
		query.append("                                    DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD3,1,5),1,3)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD3,1,5),1,3),7)) TS3_3," ).append("\n"); 
		query.append("                                    DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD3,1,5),1,4)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD3,1,5),1,4),7)) TS3_4," ).append("\n"); 
		query.append("                                    DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD3,1,5),1,5)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD3,1,5),1,5),7)) TS3_5," ).append("\n"); 
		query.append("                                    POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3," ).append("\n"); 
		query.append("                                    POL4," ).append("\n"); 
		query.append("                                    DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD4,1,5),-1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD4,1,5),-1),7),POD4) POD4," ).append("\n"); 
		query.append("                                    POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4," ).append("\n"); 
		query.append("                                    DECODE(DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD_NODE,1,5),-1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD_NODE,1,5),-1),7),POD_NODE),NULL,POD_NODE," ).append("\n"); 
		query.append("                                           DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD_NODE,1,5),-1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD_NODE,1,5),-1),7),POD_NODE)) POD_NODE," ).append("\n"); 
		query.append("                                    (SELECT YD_FCTY_TP_CFS_FLG" ).append("\n"); 
		query.append("                                     FROM MDM_YARD" ).append("\n"); 
		query.append("                                     WHERE YD_CD=DECODE(DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD_NODE,1,5),-1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD_NODE,1,5),-1),7),POD_NODE),NULL,POD_NODE," ).append("\n"); 
		query.append("                                           DECODE(SIGN(INSTR(@[ocn_str],SUBSTR(POD_NODE,1,5),-1)),1,SUBSTR(@[ocn_str],INSTR(@[ocn_str],SUBSTR(POD_NODE,1,5),-1),7),POD_NODE))) POD_NODE_S," ).append("\n"); 
		query.append("                                    (CASE WHEN POD_NODE IS NULL THEN 'X'" ).append("\n"); 
		query.append("                                          WHEN LNK_KNT = 4 AND ( POL4 IS NULL OR POD4 IS NULL OR POLT4 IS NULL OR PODT4 IS NULL" ).append("\n"); 
		query.append("                                                                OR ( N4TH_SVC_TP <> 'O' AND ( VVD4 IS NULL OR CRR4 IS NULL OR POL_SEQ4 IS NULL OR  POD_SEQ4 IS NULL) )" ).append("\n"); 
		query.append("                                                                OR ( POL3 IS NULL OR POD3 IS NULL OR POLT3 IS NULL OR PODT3 IS NULL )" ).append("\n"); 
		query.append("                                                                OR ( N3RD_SVC_TP <> 'O' AND ( VVD3 IS NULL OR CRR3 IS NULL OR POL_SEQ3 IS NULL OR  POD_SEQ3 IS NULL) )" ).append("\n"); 
		query.append("                                                                OR ( POL2 IS NULL OR POD2 IS NULL OR POLT2 IS NULL OR PODT2 IS NULL )" ).append("\n"); 
		query.append("                                                                OR ( N2ND_SVC_TP <> 'O' AND ( VVD2 IS NULL OR CRR2 IS NULL OR POL_SEQ2 IS NULL OR  POD_SEQ2 IS NULL) )" ).append("\n"); 
		query.append("                                                                OR ( POL1 IS NULL OR POD1 IS NULL OR POLT1 IS NULL OR PODT1 IS NULL )" ).append("\n"); 
		query.append("                                                                OR ( N1ST_SVC_TP <> 'O' AND ( VVD1 IS NULL OR CRR1 IS NULL OR POL_SEQ1 IS NULL OR  POD_SEQ1 IS NULL) ) )" ).append("\n"); 
		query.append("                                               THEN 'X'" ).append("\n"); 
		query.append("                                          WHEN LNK_KNT = 3 AND ( POL3 IS NULL OR POD3 IS NULL OR POLT3 IS NULL OR PODT3 IS NULL" ).append("\n"); 
		query.append("                                                                OR ( N3RD_SVC_TP <> 'O' AND ( VVD3 IS NULL OR CRR3 IS NULL OR POL_SEQ3 IS NULL OR  POD_SEQ3 IS NULL) )" ).append("\n"); 
		query.append("                                                                OR ( POL2 IS NULL OR POD2 IS NULL OR POLT2 IS NULL OR PODT2 IS NULL )" ).append("\n"); 
		query.append("                                                                OR ( N2ND_SVC_TP <> 'O' AND ( VVD2 IS NULL OR CRR2 IS NULL OR POL_SEQ2 IS NULL OR  POD_SEQ2 IS NULL) )" ).append("\n"); 
		query.append("                                                                OR ( POL1 IS NULL OR POD1 IS NULL OR POLT1 IS NULL OR PODT1 IS NULL )" ).append("\n"); 
		query.append("                                                                OR ( N1ST_SVC_TP <> 'O' AND ( VVD1 IS NULL OR CRR1 IS NULL OR POL_SEQ1 IS NULL OR  POD_SEQ1 IS NULL) ) )" ).append("\n"); 
		query.append("                                               THEN 'X'" ).append("\n"); 
		query.append("                                          WHEN LNK_KNT = 2 AND ( POL2 IS NULL OR POD2 IS NULL OR POLT2 IS NULL OR PODT2 IS NULL" ).append("\n"); 
		query.append("                                                                OR ( N2ND_SVC_TP <> 'O' AND ( VVD2 IS NULL OR CRR2 IS NULL OR POL_SEQ2 IS NULL OR  POD_SEQ2 IS NULL) )" ).append("\n"); 
		query.append("                                                                OR ( POL1 IS NULL OR POD1 IS NULL OR POLT1 IS NULL OR PODT1 IS NULL )" ).append("\n"); 
		query.append("                                                                OR ( N1ST_SVC_TP <> 'O' AND ( VVD1 IS NULL OR CRR1 IS NULL OR POL_SEQ1 IS NULL OR  POD_SEQ1 IS NULL) ) )" ).append("\n"); 
		query.append("                                               THEN 'X'" ).append("\n"); 
		query.append("                                          WHEN LNK_KNT = 1 AND ( POL1 IS NULL OR POD1 IS NULL OR POLT1 IS NULL OR PODT1 IS NULL" ).append("\n"); 
		query.append("                                                                OR ( N1ST_SVC_TP <> 'O' AND ( VVD1 IS NULL OR CRR1 IS NULL OR POL_SEQ1 IS NULL OR  POD_SEQ1 IS NULL) ) )" ).append("\n"); 
		query.append("                                               THEN 'X'" ).append("\n"); 
		query.append("                                        ELSE 'Y'" ).append("\n"); 
		query.append("                                    END ) CHECK_ROUT" ).append("\n"); 
		query.append("                                    ,(SELECT REP_ZN_CD FROM MDM_LOCATION L WHERE L.LOC_CD = @[por] AND NVL(L.DELT_FLG,'N')='N') OB_REP_ZN_CD --20100406" ).append("\n"); 
		query.append("                                    ,(SELECT REP_ZN_CD FROM MDM_LOCATION L WHERE L.LOC_CD = @[del] AND NVL(L.DELT_FLG,'N')='N') IB_REP_ZN_CD --20100406" ).append("\n"); 
		query.append("                                    FROM (" ).append("\n"); 
		query.append("                                        SELECT /*+ NO_MERGE(B)  */" ).append("\n"); 
		query.append("                                        ROWNUM, ORG_LOC_CD,DEST_LOC_CD,ROUT_SEQ,LNK_KNT,OCN_ROUT_PRIO_CD," ).append("\n"); 
		query.append("                                        N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("                                        N1ST_SVC_TP,N2ND_SVC_TP, N3RD_SVC_TP,N4TH_SVC_TP," ).append("\n"); 
		query.append("                                        N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'CCT'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CCT')+3,14))) CCT," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POL1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL1')+4,7))) POL1," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POD1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD1')+4,7))) POD1," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POLT1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POLT1')+5,14))) POLT1," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'PODT1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'PODT1')+5,14))) PODT1," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'VVD1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'VVD1')+4,9))) VVD1," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'CRR1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CRR1')+4,4))) CRR1," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL_SEQ1')+8,2))) POL_SEQ1," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD_SEQ1')+8,2))) POD_SEQ1," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POL2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL2')+4,7))) POL2," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POD2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD2')+4,7))) POD2," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POLT2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POLT2')+5,14))) POLT2," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'PODT2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'PODT2')+5,14))) PODT2," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'VVD2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'VVD2')+4,9))) VVD2," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'CRR2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CRR2')+4,4))) CRR2," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL_SEQ2')+8,2))) POL_SEQ2," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD_SEQ2')+8,2))) POD_SEQ2," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POL3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL3')+4,7))) POL3," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POD3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD3')+4,7))) POD3," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POLT3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POLT3')+5,14))) POLT3," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'PODT3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'PODT3')+5,14))) PODT3," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'VVD3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'VVD3')+4,9))) VVD3," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'CRR3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CRR3')+4,4))) CRR3," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL_SEQ3')+8,2))) POL_SEQ3," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD_SEQ3')+8,2))) POD_SEQ3," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POL4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL4')+4,7))) POL4," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POD4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD4')+4,7))) POD4," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POLT4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POLT4')+5,14))) POLT4," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'PODT4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'PODT4')+5,14))) PODT4," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'VVD4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'VVD4')+4,9))) VVD4," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'CRR4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'CRR4')+4,4))) CRR4," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POL_SEQ4')+8,2))) POL_SEQ4," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD_SEQ4')+8,2))) POD_SEQ4," ).append("\n"); 
		query.append("--                                        TRIM(DECODE(LNK_KNT,4,TRIM(DECODE(INSTR(SKD_STR,'POD4'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD4')+4,7)))," ).append("\n"); 
		query.append("--                                                       3,TRIM(DECODE(INSTR(SKD_STR,'POD3'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD3')+4,7)))," ).append("\n"); 
		query.append("--                                                       2,TRIM(DECODE(INSTR(SKD_STR,'POD2'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD2')+4,7)))," ).append("\n"); 
		query.append("--                                                       TRIM(DECODE(INSTR(SKD_STR,'POD1'),0,NULL,SUBSTR(SKD_STR,INSTR(SKD_STR,'POD1')+4,7))))) POD_NODE," ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'VVD1'),0,NULL,SUBSTR(SKD_STR, 1 +length('VVD1'),9 ))) VVD1," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'CRR1'),0,NULL,SUBSTR(SKD_STR, 14+length('CRR1'),4 ))) CRR1," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'CCT$'),0,NULL,SUBSTR(SKD_STR,  22+length('CCT$' ),14))) CCT," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POLT1'),0,NULL,SUBSTR(SKD_STR,63+length('POLT1'),14))) POLT1," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POL1'),0,NULL,SUBSTR(SKD_STR, 82+length('POL1'),7))) POL1," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ1'),0,NULL,SUBSTR(SKD_STR,93+length('POL_SEQ1'),2))) POL_SEQ1," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'PODT1'),0,NULL,SUBSTR(SKD_STR,103+length('PODT1'),14))) PODT1," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POD1'),0,NULL,SUBSTR(SKD_STR,122+length('POD1'),7))) POD1," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ1'),0,NULL,SUBSTR(SKD_STR,133+length('POD_SEQ1'),2))) POD_SEQ1,--" ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'VVD2'),0,NULL,SUBSTR(SKD_STR,143+length('VVD2'),9))) VVD2," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'CRR2'),0,NULL,SUBSTR(SKD_STR,156+length('CRR2'),4))) CRR2," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POLT2'),0,NULL,SUBSTR(SKD_STR,186+length('POLT2'),14))) POLT2," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POL2'),0,NULL,SUBSTR(SKD_STR,205+length('POL2'),7))) POL2," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ2'),0,NULL,SUBSTR(SKD_STR,216+length('POL_SEQ2'),2))) POL_SEQ2," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'PODT2'),0,NULL,SUBSTR(SKD_STR,226+length('PODT2'),14))) PODT2," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POD2'),0,NULL,SUBSTR(SKD_STR,245+length('POD2'),7))) POD2," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ2'),0,NULL,SUBSTR(SKD_STR,256+length('POD_SEQ2'),2))) POD_SEQ2,--" ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'VVD3'),0,NULL,SUBSTR(SKD_STR,266+length('VVD3'),9))) VVD3," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'CRR3'),0,NULL,SUBSTR(SKD_STR,279+length('CRR3'),4))) CRR3," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POLT3'),0,NULL,SUBSTR(SKD_STR,309+length('POLT3'),14))) POLT3," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POL3'),0,NULL,SUBSTR(SKD_STR,328+length('POL3'),7))) POL3," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ3'),0,NULL,SUBSTR(SKD_STR,339+length('POL_SEQ3'),2))) POL_SEQ3," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'PODT3'),0,NULL,SUBSTR(SKD_STR,349+length('PODT3'),14))) PODT3," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POD3'),0,NULL,SUBSTR(SKD_STR,368+length('POD3'),7))) POD3," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ3'),0,NULL,SUBSTR(SKD_STR,379+length('POD_SEQ3'),2))) POD_SEQ3, --" ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'VVD4'),0,NULL,SUBSTR(SKD_STR,389+length('VVD4'),9))) VVD4," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'CRR4'),0,NULL,SUBSTR(SKD_STR,402+length('CRR4'),4))) CRR4," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POLT4'),0,NULL,SUBSTR(SKD_STR,432+length('POLT4'),14))) POLT4," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POL4'),0,NULL,SUBSTR(SKD_STR,451+length('POL4'),7))) POL4," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POL_SEQ4'),0,NULL,SUBSTR(SKD_STR,462+length('POL_SEQ4'),2))) POL_SEQ4," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'PODT4'),0,NULL,SUBSTR(SKD_STR,472+length('PODT4'),14))) PODT4," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POD4'),0,NULL,SUBSTR(SKD_STR,491+length('POD4'),7))) POD4," ).append("\n"); 
		query.append("                                        TRIM(DECODE(INSTR(SKD_STR,'POD_SEQ4'),0,NULL,SUBSTR(SKD_STR,502+length('POD_SEQ4'),2))) POD_SEQ4,--" ).append("\n"); 
		query.append("                                        TRIM(DECODE(LNK_KNT,4,TRIM(DECODE(INSTR(SKD_STR,'POD4'),0,NULL,SUBSTR(SKD_STR,491+length('POD4'),7)))," ).append("\n"); 
		query.append("                                                       3,TRIM(DECODE(INSTR(SKD_STR,'POD3'),0,NULL,SUBSTR(SKD_STR,368+length('POD3'),7)))," ).append("\n"); 
		query.append("                                                       2,TRIM(DECODE(INSTR(SKD_STR,'POD2'),0,NULL,SUBSTR(SKD_STR,245+length('POD2'),7)))," ).append("\n"); 
		query.append("                                                       TRIM(DECODE(INSTR(SKD_STR,'POD1'),0,NULL,SUBSTR(SKD_STR,122+length('POD1'),7))))) POD_NODE," ).append("\n"); 
		query.append("----------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("                                        SKD_STR" ).append("\n"); 
		query.append("                                        FROM (" ).append("\n"); 
		query.append("                                            SELECT" ).append("\n"); 
		query.append("                                            ORG_LOC_CD,DEST_LOC_CD,ROUT_SEQ,LNK_KNT,OCN_ROUT_PRIO_CD," ).append("\n"); 
		query.append("                                            N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("                                            N1.VSL_SVC_TP_CD N1ST_SVC_TP," ).append("\n"); 
		query.append("                                            N2.VSL_SVC_TP_CD N2ND_SVC_TP," ).append("\n"); 
		query.append("                                            N3.VSL_SVC_TP_CD N3RD_SVC_TP," ).append("\n"); 
		query.append("                                            N4.VSL_SVC_TP_CD N4TH_SVC_TP," ).append("\n"); 
		query.append("                                            N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            PRD_GET_OCN_SKD_FNC(@[skd_date], @[skd_type], ORG_LOC_CD, DEST_LOC_CD," ).append("\n"); 
		query.append("                                                NVL(DECODE(N1.VSL_SVC_TP_CD, 'O',DECODE(@[vvd1],'',@[pol_n]),@[pol_n]),N1ST_POL_CD), @[n1st_pol_dc_seq]," ).append("\n"); 
		query.append("                                                NVL(DECODE(LNK_KNT,1,DECODE(N1.VSL_SVC_TP_CD, 'O',DECODE(@[vvd1], '',@[pod_n]),@[pod_n])),N1ST_POD_CD)," ).append("\n"); 
		query.append("                                                @[n1st_pod_dc_seq], N1ST_LANE_CD, N1ST_SKD_DIR_CD, N1.VSL_SVC_TP_CD, @[vvd1]," ).append("\n"); 
		query.append("                                                N2ND_POL_CD, @[n2nd_pol_dc_seq]," ).append("\n"); 
		query.append("                                                NVL(DECODE(LNK_KNT,2,DECODE(N2.VSL_SVC_TP_CD, 'O',DECODE(@[vvd2], '',@[pod_n]),@[pod_n])),N2ND_POD_CD)," ).append("\n"); 
		query.append("                                                @[n2nd_pod_dc_seq], N2ND_LANE_CD, N2ND_SKD_DIR_CD, N2.VSL_SVC_TP_CD, @[vvd2]," ).append("\n"); 
		query.append("                                                N3RD_POL_CD, @[n3rd_pol_dc_seq]," ).append("\n"); 
		query.append("                                                NVL(DECODE(LNK_KNT,3,DECODE(N3.VSL_SVC_TP_CD, 'O',DECODE(@[vvd3], '',@[pod_n]),@[pod_n])),N3RD_POD_CD)," ).append("\n"); 
		query.append("                                                @[n3rd_pod_dc_seq], N3RD_LANE_CD, N3RD_SKD_DIR_CD, N3.VSL_SVC_TP_CD, @[vvd3]," ).append("\n"); 
		query.append("                                                N4TH_POL_CD, @[n4th_pol_dc_seq]," ).append("\n"); 
		query.append("                                                NVL(DECODE(LNK_KNT,4,DECODE(N4.VSL_SVC_TP_CD, 'O',DECODE(@[vvd4], '',@[pod_n]),@[pod_n])),DEST_LOC_CD)," ).append("\n"); 
		query.append("                                                @[n4th_pod_dc_seq], N4TH_LANE_CD, N4TH_SKD_DIR_CD, N4.VSL_SVC_TP_CD, @[vvd4]," ).append("\n"); 
		query.append("                                            NVL(@[cgo_tp],'AL'),'N') SKD_STR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            FROM PRD_OCN_ROUT A,MDM_VSL_SVC_LANE N1,MDM_VSL_SVC_LANE N2,MDM_VSL_SVC_LANE N3,MDM_VSL_SVC_LANE N4" ).append("\n"); 
		query.append("                                            WHERE A.ORG_LOC_CD =@[pol]" ).append("\n"); 
		query.append("                                            AND A.DEST_LOC_CD IN (SELECT DISTINCT PORT_CD FROM PRD_HUB_LOC_MTCH" ).append("\n"); 
		query.append("                                                                 WHERE LOC_CD = @[del] AND PORT_CD = NVL(@[pod],PORT_CD))" ).append("\n"); 
		query.append("    										AND A.ROUT_SEQ = NVL(@[ocn_seq],A.ROUT_SEQ) -- 20100423 j 추가 CA Confirm시 single P/C 생성 위해" ).append("\n"); 
		query.append("                                            AND NVL(A.UPD_IND_CD,'S') IN ('C','U','S','T','A', 'G'," ).append("\n"); 
		query.append("                                                                           DECODE( SUBSTR(@[hd_pctl_no],0,1),'B','','V') )" ).append("\n"); 
		query.append("											and a.CUP_EXPT_FLG  = decode( nvl(@[pc_mode],'B'),'W','N', a.CUP_EXPT_FLG)" ).append("\n"); 
		query.append("                                            AND N1.VSL_SLAN_CD(+) = N1ST_LANE_CD" ).append("\n"); 
		query.append("                                            AND N2.VSL_SLAN_CD(+) = N2ND_LANE_CD" ).append("\n"); 
		query.append("                                            AND N3.VSL_SLAN_CD(+) = N3RD_LANE_CD" ).append("\n"); 
		query.append("                                            AND N4.VSL_SLAN_CD(+) = N4TH_LANE_CD" ).append("\n"); 
		query.append("                                            AND N1ST_POL_CD = NVL(@[pol1],N1ST_POL_CD)" ).append("\n"); 
		query.append("                                            AND N1ST_POD_CD = NVL(@[pod1],N1ST_POD_CD)" ).append("\n"); 
		query.append("                                            AND N1ST_LANE_CD IN ( NVL(@[lane1],N1ST_LANE_CD)," ).append("\n"); 
		query.append("                                                           (SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                        WHERE VSL_SLAN_CD = @[lane1]) )" ).append("\n"); 
		query.append("                                            AND NVL(N2ND_POL_CD,'X') = NVL(@[pol2],NVL(N2ND_POL_CD,'X'))" ).append("\n"); 
		query.append("                                            AND NVL(N2ND_POD_CD,'X') = NVL(@[pod2],NVL(N2ND_POD_CD,'X'))" ).append("\n"); 
		query.append("                                            AND NVL(N2ND_LANE_CD,'X') IN ( NVL(@[lane2],NVL(N2ND_LANE_CD,'X'))," ).append("\n"); 
		query.append("                                                          (SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                       WHERE VSL_SLAN_CD = @[lane2]) )" ).append("\n"); 
		query.append("                                            AND NVL(N3RD_POL_CD,'X') = NVL(@[pol3],NVL(N3RD_POL_CD,'X'))" ).append("\n"); 
		query.append("                                            AND NVL(N3RD_POD_CD,'X') = NVL(@[pod3],NVL(N3RD_POD_CD,'X'))" ).append("\n"); 
		query.append("                                            AND NVL(N3RD_LANE_CD,'X') IN ( NVL(@[lane3],NVL(N3RD_LANE_CD,'X'))," ).append("\n"); 
		query.append("                                                           (SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                        WHERE VSL_SLAN_CD = @[lane3]) )" ).append("\n"); 
		query.append("                                            AND NVL(N4TH_POL_CD,'X') = NVL(@[pol4],NVL(N4TH_POL_CD,'X'))" ).append("\n"); 
		query.append("                                            AND NVL(N4TH_POD_CD,'X') = NVL(@[pod4],NVL(N4TH_POD_CD,'X'))" ).append("\n"); 
		query.append("                                            AND NVL(N4TH_LANE_CD,'X') IN ( NVL(@[lane4],NVL(N4TH_LANE_CD,'X'))," ).append("\n"); 
		query.append("                                                           (SELECT DECODE(VSL_SVC_TP_CD,'O','FDR',VSL_SLAN_CD) FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                        WHERE VSL_SLAN_CD = @[lane4]) )" ).append("\n"); 
		query.append("                                            --REGEXP_SUBSTR(source, 표현식, 시작위치, 발생횟수, Matching Modifiers )" ).append("\n"); 
		query.append("                                            AND INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                                                      NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'[-%].{7}[-%]',1,1),2,5),ORG_LOC_CD)) > 0" ).append("\n"); 
		query.append("                                            AND INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                                                      NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'[-%].{7}[-%]',1,2),2,5),ORG_LOC_CD)) > 0" ).append("\n"); 
		query.append("                                            AND INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                                                      NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'[-%].{7}[-%]',1,3),2,5),ORG_LOC_CD)) > 0" ).append("\n"); 
		query.append("                                            AND INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                                                      NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'[-%].{7}[-%]',1,4),2,5),ORG_LOC_CD)) > 0" ).append("\n"); 
		query.append("                                            AND INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                                                      NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'[-%].{7}[-%]',1,5),2,5),ORG_LOC_CD)) > 0" ).append("\n"); 
		query.append("                                            AND INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                                                      NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'[-%].{7}[-%]',1,6),2,5),ORG_LOC_CD)) > 0" ).append("\n"); 
		query.append("                                            AND INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                                                      NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'[-%].{7}[-%]',1,7),2,5),ORG_LOC_CD)) > 0" ).append("\n"); 
		query.append("                                            AND INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                                                DECODE(NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,1),1,5),'X'),NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,1),18,5),'X'),ORG_LOC_CD," ).append("\n"); 
		query.append("                                                       SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,1),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,1),18,5))) > 0" ).append("\n"); 
		query.append("                                            AND INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                                                DECODE(NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,2),1,5),'X'),NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,2),18,5),'X'),ORG_LOC_CD," ).append("\n"); 
		query.append("                                                       SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,2),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,2),18,5))) > 0" ).append("\n"); 
		query.append("                                            AND INSTR(REGEXP_REPLACE(ORG_LOC_CD||'-'||N2ND_POL_CD||'-'||N3RD_POL_CD||'-'||N4TH_POL_CD||'-'||DEST_LOC_CD,'[-]{4}|[-]{3}|[-]{2}','-')," ).append("\n"); 
		query.append("                                                DECODE(NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,3),1,5),'X'),NVL(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,3),18,5),'X'),ORG_LOC_CD," ).append("\n"); 
		query.append("                                                       SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,3),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,3),18,5))) > 0" ).append("\n"); 
		query.append("                                            AND 'O' = NVL(DECODE(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,1),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,1),18,5)," ).append("\n"); 
		query.append("                                                                                 ORG_LOC_CD||'-'||N1ST_POD_CD,N1.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                                                 N2ND_POL_CD||'-'||N2ND_POD_CD,N2.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                                                 N3RD_POL_CD||'-'||N3RD_POD_CD,N3.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                                                 N4TH_POL_CD||'-'||DEST_LOC_CD,N4.VSL_SVC_TP_CD),'O')" ).append("\n"); 
		query.append("                                            AND 'O' = NVL(DECODE(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,2),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,2),18,5)," ).append("\n"); 
		query.append("                                                                                 ORG_LOC_CD||'-'||N1ST_POD_CD,N1.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                                                 N2ND_POL_CD||'-'||N2ND_POD_CD,N2.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                                                 N3RD_POL_CD||'-'||N3RD_POD_CD,N3.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                                                 N4TH_POL_CD||'-'||DEST_LOC_CD,N4.VSL_SVC_TP_CD),'O')" ).append("\n"); 
		query.append("                                            AND 'O' = NVL(DECODE(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,3),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,3),18,5)," ).append("\n"); 
		query.append("                                                                                 ORG_LOC_CD||'-'||N1ST_POD_CD,N1.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                                                 N2ND_POL_CD||'-'||N2ND_POD_CD,N2.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                                                 N3RD_POL_CD||'-'||N3RD_POD_CD,N3.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                                                 N4TH_POL_CD||'-'||DEST_LOC_CD,N4.VSL_SVC_TP_CD),'O')" ).append("\n"); 
		query.append("                                            AND 'O' = NVL(DECODE(SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,4),1,5)||'-'||SUBSTR(REGEXP_SUBSTR(@[ocn_str],'.{7}-WD-.-...-.{7}',1,4),18,5)," ).append("\n"); 
		query.append("                                                                                 ORG_LOC_CD||'-'||N1ST_POD_CD,N1.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                                                 N2ND_POL_CD||'-'||N2ND_POD_CD,N2.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                                                 N3RD_POL_CD||'-'||N3RD_POD_CD,N3.VSL_SVC_TP_CD," ).append("\n"); 
		query.append("                                                                                 N4TH_POL_CD||'-'||DEST_LOC_CD,N4.VSL_SVC_TP_CD),'O')" ).append("\n"); 
		query.append("                                            AND (  (SELECT (CASE WHEN" ).append("\n"); 
		query.append("                                                           (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("                                                                WHERE VSL_SLAN_CD =V.SLAN_CD ) = 'O' THEN 'FDR'" ).append("\n"); 
		query.append("                                                                     ELSE V.SLAN_CD" ).append("\n"); 
		query.append("                                                           END) SLAN_CD" ).append("\n"); 
		query.append("                                                   FROM VSK_VSL_PORT_SKD  V,VSK_VSL_PORT_SKD  V2" ).append("\n"); 
		query.append("                                                   WHERE V.VSL_CD= substr(@[vvd],1,4)" ).append("\n"); 
		query.append("                                                    and V.SKD_VOY_NO= substr(@[vvd],5,4)" ).append("\n"); 
		query.append("                                                    and V.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("                                                    and NVL(V.SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("                                                    AND V2.VSL_CD= substr(@[vvd],1,4)" ).append("\n"); 
		query.append("                                                    and V2.SKD_VOY_NO= substr(@[vvd],5,4)" ).append("\n"); 
		query.append("                                                    and V2.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("                                                    and NVL(V2.SKD_CNG_STS_CD,'N') <> 'S'" ).append("\n"); 
		query.append("                                                    AND V2.CLPT_SEQ > V.CLPT_SEQ" ).append("\n"); 
		query.append("                                                    AND ROWNUM=1 )      IN ( N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,'FDR')" ).append("\n"); 
		query.append("                                                OR NVL(@[vvd],'X') = 'X'" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                            AND NOT EXISTS" ).append("\n"); 
		query.append("                                            (" ).append("\n"); 
		query.append("                                               SELECT 'X' FROM PRD_MBGO_MGMT TT" ).append("\n"); 
		query.append("                                               WHERE SUBSTR (A.ORG_LOC_CD, 1, 2) = TT.FM_CNT_CD" ).append("\n"); 
		query.append("                                               AND A.TS_IND_CD = 'D'" ).append("\n"); 
		query.append("                                               AND SUBSTR (A.DEST_LOC_CD, 1, 2) = TT.TO_CNT_CD" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                        ) B" ).append("\n"); 
		query.append("                                    ) C" ).append("\n"); 
		query.append("                                 ) T , PRD_INLND_ROUT_MST O, PRD_INLND_ROUT_MST I" ).append("\n"); 
		query.append("                                WHERE T.CHECK_ROUT = 'Y'" ).append("\n"); 
		query.append("                                AND NVL(O.PCTL_IO_BND_CD(+),'O') = 'O' --20100407" ).append("\n"); 
		query.append("                                AND O.ROUT_ORG_NOD_CD(+)" ).append("\n"); 
		query.append("                                    LIKE CASE WHEN @[rcv_t] IN ('F', 'T') THEN 'X'" ).append("\n"); 
		query.append("                                              WHEN @[por_n] IS NOT NULL AND REPLACE(@[ob_str], '%', '') IS NULL THEN DECODE(@[por_n], T.POL1, 'X', @[por_n])" ).append("\n"); 
		query.append("                                              WHEN @[rcv_t] = 'D' THEN OB_REP_ZN_CD" ).append("\n"); 
		query.append("                                              WHEN @[rcv_t] = 'S' AND NVL(T.POL1_S, 'N') <> 'Y' THEN @[por] || '%'" ).append("\n"); 
		query.append("                                              WHEN @[por] = @[pol] THEN DECODE(REPLACE(@[ob_str], '%', ''), NULL, 'X', @[por] || '%')" ).append("\n"); 
		query.append("                                              ELSE @[por] || '%'" ).append("\n"); 
		query.append("                                         END" ).append("\n"); 
		query.append("                                AND O.ROUT_DEST_NOD_CD(+)= DECODE(@[rcv_t], 'F', 'X', 'T', 'X', T.POL1)" ).append("\n"); 
		query.append("                                AND NVL(O.TRSP_MOD_CD(+),'X') = DECODE ( NVL(@[ob_trsp_mode],'AL'), 'AL', NVL(O.TRSP_MOD_CD(+),'X') , @[ob_trsp_mode]  ) -- 2009.12.02 추가" ).append("\n"); 
		query.append("                                AND NVL(O.DELT_FLG(+),'N') <> 'Y'" ).append("\n"); 
		query.append("								---------------------------------------" ).append("\n"); 
		query.append("								and O.CUP_EXPT_FLG(+)  = decode( nvl(@[pc_mode],'B'),'W','N', O.CUP_EXPT_FLG(+))" ).append("\n"); 
		query.append("								---------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                AND NVL(I.PCTL_IO_BND_CD(+),'I') = 'I' --20100407" ).append("\n"); 
		query.append("                                AND I.ROUT_ORG_NOD_CD(+)= DECODE(@[del_t], 'F', 'X', 'T', 'X', T.POD_NODE)" ).append("\n"); 
		query.append("                                AND I.ROUT_DEST_NOD_CD(+)" ).append("\n"); 
		query.append("                                    LIKE CASE WHEN @[del_t] IN ('F', 'T') THEN 'X'" ).append("\n"); 
		query.append("                                              WHEN @[del_n] IS NOT NULL AND REPLACE(@[ib_str], '%', '') IS NULL THEN DECODE(@[del_n], T.POD_NODE, 'X', @[del_n])" ).append("\n"); 
		query.append("                                              WHEN @[del_t] = 'D' THEN IB_REP_ZN_CD" ).append("\n"); 
		query.append("                                              WHEN @[del_t] = 'S' AND NVL(T.POD_NODE_S, 'N') <> 'Y' THEN @[del] || '%'" ).append("\n"); 
		query.append("                                              WHEN NVL(@[pod], SUBSTR(T.POD_NODE, 1,5)) = @[del] THEN DECODE(REPLACE(@[ib_str], '%', ''), NULL, 'X', @[del] || '%')" ).append("\n"); 
		query.append("                                              ELSE @[del] || '%'" ).append("\n"); 
		query.append("                                         END" ).append("\n"); 
		query.append("    							AND NVL(I.TRSP_MOD_CD(+),'X') = DECODE ( NVL(@[ib_trsp_mode],'AL'), 'AL', NVL(I.TRSP_MOD_CD(+),'X') , @[ib_trsp_mode]  ) -- 2009.12.02 추가" ).append("\n"); 
		query.append("                                AND NVL(I.DELT_FLG(+),'N') <> 'Y'" ).append("\n"); 
		query.append("    							---------------------------------------" ).append("\n"); 
		query.append("								and I.CUP_EXPT_FLG(+)  = decode( nvl(@[pc_mode],'B'),'W','N', I.CUP_EXPT_FLG(+))" ).append("\n"); 
		query.append("								---------------------------------------" ).append("\n"); 
		query.append("                            ) ROUT, PRD_INLND_ROUT_DTL OD,PRD_INLND_ROUT_DTL ID" ).append("\n"); 
		query.append("                            WHERE ROUT.ORG_CHECK = 'Y'" ).append("\n"); 
		query.append("                            AND ROUT.DEST_CHECK ='Y'" ).append("\n"); 
		query.append("                            AND DECODE(OB_ROUT_SEQ,0,'Y',ROUT.ORG_FLG_CHK) = 'Y'" ).append("\n"); 
		query.append("                            AND DECODE(IB_ROUT_SEQ,0,'Y',ROUT.DEST_FLG_CHK) = 'Y'" ).append("\n"); 
		query.append("                            AND ROUT.OB_ORG =OD.ROUT_ORG_NOD_CD(+)" ).append("\n"); 
		query.append("                            AND ROUT.OB_DEST =OD.ROUT_DEST_NOD_CD(+)" ).append("\n"); 
		query.append("                            AND ROUT.OB_SEQ =OD.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                            AND ROUT.IB_ORG =ID.ROUT_ORG_NOD_CD(+)" ).append("\n"); 
		query.append("                            AND ROUT.IB_DEST =ID.ROUT_DEST_NOD_CD(+)" ).append("\n"); 
		query.append("                            AND ROUT.IB_SEQ =ID.ROUT_SEQ(+)" ).append("\n"); 
		query.append("                            AND NVL(ROUT.ORG_ROUT,'X') LIKE REGEXP_REPLACE(@[ob_str],'-...-','-')||'%'" ).append("\n"); 
		query.append("                            AND NVL(ROUT.DEST_ROUT,'X') LIKE REGEXP_REPLACE(@[ib_str],'-...-','-')||'%'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                    WHERE IB_RK =1 AND OB_RK= 1" ).append("\n"); 
		query.append("                    GROUP BY OB_ORG,OB_ORG,OB_DEST,OB_PRIO_SEQ,OB_SEQ,OB_CNT,FULL_RTN_YD_CD,FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("                    ORG_LOC_CD,DEST_LOC_CD,OCN_SEQ,LNK_KNT,OCN_ROUT_PRIO_CD," ).append("\n"); 
		query.append("                    N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD," ).append("\n"); 
		query.append("                    N1ST_TZTM_HRS,N2ND_TZTM_HRS,N3RD_TZTM_HRS,N4TH_TZTM_HRS,CCT," ).append("\n"); 
		query.append("                    POL1,POD1,TS1_2,TS1_3,TS1_4,POLT1,PODT1,VVD1,CRR1,POL_SEQ1,POD_SEQ1," ).append("\n"); 
		query.append("                    POL2,POD2,TS2_2,TS2_3,TS2_4,POLT2,PODT2,VVD2,CRR2,POL_SEQ2,POD_SEQ2," ).append("\n"); 
		query.append("                    POL3,POD3,TS3_2,TS3_3,TS3_4,POLT3,PODT3,VVD3,CRR3,POL_SEQ3,POD_SEQ3," ).append("\n"); 
		query.append("                    POL4,POD4,POLT4,PODT4,VVD4,CRR4,POL_SEQ4,POD_SEQ4," ).append("\n"); 
		query.append("                    POD_NODE,CHECK_ROUT," ).append("\n"); 
		query.append("                    IB_ORG,IB_DEST,IB_PRIO_SEQ,IB_SEQ,IB_CNT" ).append("\n"); 
		query.append("                    )," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    SELECT CPY_NO F_N0 FROM COM_CPY_NO WHERE CPY_NO <=42" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                WHERE 1 = CASE WHEN @[rcv_t] IN ('D','Y') THEN DECODE(MTPU_CY, NULL, 0, 1)" ).append("\n"); 
		query.append("                               ELSE 1 END" ).append("\n"); 
		query.append("                  AND 1 = CASE WHEN @[del_t] IN ('D','Y') THEN DECODE(MTRTN_CY, NULL, 0, 1)" ).append("\n"); 
		query.append("                               ELSE 1 END" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                WHERE TRIM(NODE1) IS NOT NULL" ).append("\n"); 
		query.append("            )," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT CPY_NO L_N0 FROM COM_CPY_NO WHERE CPY_NO IN (1,2)" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        ORDER BY 1,2,3" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHERE (F_NO2 <> 42 OR L_N0 <> 2 )" ).append("\n"); 
		query.append("    AND NODE_NEW2 IS NOT NULL" ).append("\n"); 
		query.append("    ORDER BY 1,2,3" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY GP1, ORD" ).append("\n"); 

	}
}