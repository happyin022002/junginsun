/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ProductCatalogHinterlandDBDAOcreateFeederCatalogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.03 
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

public class ProductCatalogHinterlandDBDAOcreateFeederCatalogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * createFeederCatalog
	  * </pre>
	  */
	public ProductCatalogHinterlandDBDAOcreateFeederCatalogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cnee_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_subst_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("shpr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rf_spcl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_ofc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lnk_dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prm_cust_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_org_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ProductCatalogHinterlandDBDAOcreateFeederCatalogCSQL").append("\n"); 
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
		query.append("INSERT ALL " ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VALUES" ).append("\n"); 
		query.append("    (PCTL_NO,MTPU_CY,SUBSTR(POR, 1,5) , POR,SUBSTR(POL1, 1,5) ,N2ND_POL_CD, N3RD_POL_CD,N4TH_POL_CD, -- hinterland를 위해 일부 수정됨" ).append("\n"); 
		query.append("    SUBSTR(POD_NODE,1,5),SUBSTR(DEL,1,5),DEL,MTRTN_CY,OUT_CONTENT,IN_CONTENT,FULL_RTN_YD_CD,POL1,POD_NODE,FULL_PKUP_YD_CD, -- hinterland를 위해 일부 " ).append("\n"); 
		query.append("    TO_DATE(N1ST_VSL_LODG_DUE_DT,'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("    ,@[rcv_t], @[del_t],@[com],@[bkg_ofc],@[sc_ofc],NVL(@[cre_usr_id],'System'), CRE_DT,NVL(@[cre_usr_id],'System'), UPD_DT" ).append("\n"); 
		query.append("	,@[cgo_tp],@[shpr_cnt_cd],@[shpr_seq]," ).append("\n"); 
		query.append("    @[cnee_cnt_cd],@[cnee_seq], @[sc_no], @[rfa_no], @[dg_clss_cd], @[dg_spcl_flg], @[rf_spcl_flg]," ).append("\n"); 
		query.append("    @[spcl_awk_cgo_flg], @[bb_spcl_flg], @[rd_spcl_flg], @[hngr_spcl_flg], @[soc_flg],@[eq_subst_flg]," ).append("\n"); 
		query.append("    @[bkg_wgt], @[bkg_wgt_ut_cd], @[sls_ofc_cd], @[rfa_ofc_cd], @[prm_cust_flg]," ).append("\n"); 
		query.append("    @[rep_cmdt_cd]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
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
		query.append(")" ).append("\n"); 
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
		query.append("           D2.TRSP_MOD_CD" ).append("\n"); 
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
		query.append("            SELECT DECODE(F_NO2,42,0,DECODE(F_NO2,0,0,DECODE(OI_BND_CD, 'T', 0, DECODE(@[pm_f],'Y'," ).append("\n"); 
		query.append("                                           3, 6)))) FROM DUAL" ).append("\n"); 
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
		query.append("                    -- ##################### 가상테이블 입력 위치" ).append("\n"); 
		query.append("                select " ).append("\n"); 
		query.append("                       POL_N OB_ORG, POL_N OB_DEST, 0 OB_SEQ, NULL OB_PRIO_SEQ, 0 OB_CNT, POL_N MTPU_CY, POL_N POR" ).append("\n"); 
		query.append("                       ,NULL OL_NODE01, NULL OL_NODE02, NULL OL_NODE03, NULL OL_NODE04, NULL OL_NODE05, NULL OL_NODE06, NULL OL_NODE07, NULL OL_NODE08, NULL OL_NODE09, NULL OL_NODE10, NULL POL0, NULL OUT_CONTENT" ).append("\n"); 
		query.append("                       , POL_N FULL_RTN_YD_CD" ).append("\n"); 
		query.append("                       , SUBSTR(POL_N, 1,5) ORG_LOC_CD, SUBSTR(POD_N, 1,5) DEST_LOC_CD, 0 OCN_SEQ" ).append("\n"); 
		query.append("                       , N1ST_LANE_CD, N2ND_LANE_CD, NULL N3RD_LANE_CD, NULL N4TH_LANE_CD" ).append("\n"); 
		query.append("                       , SUBSTR(POL2_N,1,5) N2ND_POL_CD, NULL N3RD_POL_CD, NULL N4TH_POL_CD" ).append("\n"); 
		query.append("                       , N1ST_TZTM_HRS, N2ND_TZTM_HRS, 0 N3RD_TZTM_HRS, 0 N4TH_TZTM_HRS" ).append("\n"); 
		query.append("                       , TO_CHAR(TO_DATE(POLT1, 'YYYYMMDDHH24MISS') - 1, 'YYYYMMDD') || '1800' CCT, 2 LNK_KNT" ).append("\n"); 
		query.append("                       , POL_N  POL1, POL2_N POD1, NULL TS1_2, NULL TS1_3, NULL TS1_4, POLT1, PODT1, NULL VVD1, NULL CRR1, NULL POL_SEQ1, NULL POD_SEQ1" ).append("\n"); 
		query.append("                       , POL2_N POL2, POD_N  POD2, NULL TS2_2, NULL TS2_3, NULL TS2_4, POLT2, PODT2, NULL VVD2, NULL CRR2, NULL POL_SEQ2, NULL POD_SEQ2" ).append("\n"); 
		query.append("                       , NULL   POL3, NULL   POD3, NULL TS3_2, NULL TS3_3, NULL TS3_4, NULL POLT3, NULL PODT3, NULL VVD3, NULL CRR3, NULL POL_SEQ3, NULL POD_SEQ3" ).append("\n"); 
		query.append("                       , NULL   POL4, NULL   POD4, NULL POLT4, NULL PODT4, NULL VVD4, NULL CRR4, NULL POL_SEQ4, NULL POD_SEQ4" ).append("\n"); 
		query.append("                       , POD_N POD_NODE, 'Y' CHECK_ROUT, POD_N IB_ORG, POD_N IB_DEST, 0 IB_SEQ, NULL IB_PRIO_SEQ, NULL IB_CNT" ).append("\n"); 
		query.append("                       , NULL IL_NODE01, NULL IL_NODE02, NULL IL_NODE03, NULL IL_NODE04, NULL IL_NODE05, NULL IL_NODE06, NULL IL_NODE07, NULL IL_NODE08, NULL IL_NODE09, NULL IL_NODE10" ).append("\n"); 
		query.append("                       , POD_N DEL, NULL IN_CONTENT, POD_N FULL_PKUP_YD_CD, POD_N MTRTN_CY" ).append("\n"); 
		query.append("                       , ROW_NUMBER() OVER (ORDER BY CPY_NO) GP1" ).append("\n"); 
		query.append("                from (SELECT TZTM_HRS, VNDR_SEQ, PCTL_IO_BND_CD, CPY_NO, PRE_POST_FLG, POL_N, POL2_N, POD_N, N1ST_LANE_CD, N2ND_LANE_CD, N1ST_TZTM_HRS, N2ND_TZTM_HRS" ).append("\n"); 
		query.append("                   , DECODE(SIGN(INSTR(N1ST_SKD_STR, 'POLT')), 1, SUBSTR(N1ST_SKD_STR, INSTR(N1ST_SKD_STR, 'POLT') + 4, 14)" ).append("\n"); 
		query.append("                             , TO_CHAR(TO_DATE(SUBSTR(N2ND_SKD_STR, INSTR(N2ND_SKD_STR, 'POLT') + 4, 14), 'YYYYMMDDHH24MISS') - (6/24) - (24*30/24), 'YYYYMMDDHH24MISS')) POLT1" ).append("\n"); 
		query.append("                   , DECODE(SIGN(INSTR(N1ST_SKD_STR, 'PODT')), 1, SUBSTR(N1ST_SKD_STR, INSTR(N1ST_SKD_STR, 'PODT') + 4, 14)" ).append("\n"); 
		query.append("                             , TO_CHAR(TO_DATE(SUBSTR(N2ND_SKD_STR, INSTR(N2ND_SKD_STR, 'POLT') + 4, 14), 'YYYYMMDDHH24MISS') - (6/24), 'YYYYMMDDHH24MISS')) PODT1" ).append("\n"); 
		query.append("                   , DECODE(SIGN(INSTR(N2ND_SKD_STR, 'POLT')), 1, SUBSTR(N2ND_SKD_STR, INSTR(N2ND_SKD_STR, 'POLT') + 4, 14)" ).append("\n"); 
		query.append("                             , TO_CHAR(TO_DATE(SUBSTR(N1ST_SKD_STR, INSTR(N1ST_SKD_STR, 'POLT') + 4, 14), 'YYYYMMDDHH24MISS') + (6/24), 'YYYYMMDDHH24MISS')) POLT2" ).append("\n"); 
		query.append("                   , DECODE(SIGN(INSTR(N2ND_SKD_STR, 'PODT')), 1, SUBSTR(N2ND_SKD_STR, INSTR(N2ND_SKD_STR, 'PODT') + 4, 14)" ).append("\n"); 
		query.append("                             , TO_CHAR(TO_DATE(SUBSTR(N1ST_SKD_STR, INSTR(N1ST_SKD_STR, 'POLT') + 4, 14), 'YYYYMMDDHH24MISS') + (6/24) + (24*30/24), 'YYYYMMDDHH24MISS')) PODT2" ).append("\n"); 
		query.append("                   , N1ST_SKD_STR, N2ND_SKD_STR" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                    select --feeder lnk.lnk_org_loc_cd, flnk.lnk_dest_loc_cd," ).append("\n"); 
		query.append("                           polt.tml_cd pol_tml_cd, podt.tml_cd pod_tml_cd " ).append("\n"); 
		query.append("                         , flnk.vsl_slan_cd, flnk.skd_dir_cd, flnk.tztm_hrs" ).append("\n"); 
		query.append("                         , flnk.vndr_seq, flnk.pctl_io_bnd_cd" ).append("\n"); 
		query.append("                         , cpyn.cpy_no -- 1 pre 20, 2 pre 40, 3 post 20, 4 post 40" ).append("\n"); 
		query.append("                         , decode(cpyn.cpy_no, 1, 'PRE', 2, 'PRE', 'PST') pre_post_flg" ).append("\n"); 
		query.append("                         , DECODE(CPYN.CPY_NO, 1, polt.tml_cd, 2, polt.tml_cd, 'USLGBPT' ) POL_N" ).append("\n"); 
		query.append("                         , DECODE(CPYN.CPY_NO, 1, poDT.tml_cd, 2, poDT.tml_cd, polt.tml_cd ) POL2_N" ).append("\n"); 
		query.append("                         , DECODE(CPYN.CPY_NO, 3, podt.tml_cd, 4, podt.tml_cd,5, podt.tml_cd,6, podt.tml_cd, 'USLGBPT' ) POD_N" ).append("\n"); 
		query.append("                         , DECODE(CPYN.CPY_NO, 1, 'FDR', 2, 'FDR', 'CAX') N1ST_LANE_CD" ).append("\n"); 
		query.append("                         , DECODE(CPYN.CPY_NO, 3, 'FDR', 4, 'FDR', 5, 'FDR', 6, 'FDR', 'CAX') N2ND_LANE_CD" ).append("\n"); 
		query.append("                         , DECODE(CPYN.CPY_NO, 1, flnk.tztm_hrs, 2, flnk.tztm_hrs, 24*30) N1ST_TZTM_HRS" ).append("\n"); 
		query.append("                         , DECODE(CPYN.CPY_NO, 3, flnk.tztm_hrs, 4, flnk.tztm_hrs, 5, flnk.tztm_hrs, 6, flnk.tztm_hrs, 24*30) N2ND_TZTM_HRS" ).append("\n"); 
		query.append("                         , CASE WHEN CPYN.CPY_NO IN (1,2,3) THEN " ).append("\n"); 
		query.append("                                   'POLT' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS') || 'PODT' || TO_CHAR(SYSDATE + (TZTM_HRS/24), 'YYYYMMDDHH24MISS') || 'POL' || polt.tml_cd || 'POD' || poDT.tml_cd" ).append("\n"); 
		query.append("                                ELSE '' END AS N1ST_SKD_STR" ).append("\n"); 
		query.append("                         , CASE WHEN CPYN.CPY_NO IN (4,5,6) THEN " ).append("\n"); 
		query.append("                                   'POLT' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS') || 'PODT' || TO_CHAR(SYSDATE + (TZTM_HRS/24), 'YYYYMMDDHH24MISS') || 'POL' || polt.tml_cd || 'POD' || poDT.tml_cd" ).append("\n"); 
		query.append("                                ELSE '' END AS N2ND_SKD_STR" ).append("\n"); 
		query.append("                    from prd_fdr_lnk flnk" ).append("\n"); 
		query.append("                       , PRD_PORT_TML_MTX polt" ).append("\n"); 
		query.append("                       , PRD_PORT_TML_MTX podt" ).append("\n"); 
		query.append("                       , com_cpy_no cpyn" ).append("\n"); 
		query.append("                    where flnk.LNK_ORG_LOC_CD = SUBSTR(@[lnk_org_loc_cd],1,5)" ).append("\n"); 
		query.append("                      and flnk.LNK_DEST_LOC_CD = SUBSTR(@[lnk_dest_loc_cd],1,5)" ).append("\n"); 
		query.append("                      and flnk.vsl_slan_cd = 'FDR'" ).append("\n"); 
		query.append("                      and nvl(flnk.delt_flg, 'N')  = 'N'" ).append("\n"); 
		query.append("                      and flnk.lnk_org_loc_cd = polt.port_cd" ).append("\n"); 
		query.append("                      and flnk.VSL_SLAN_CD = polt.vsl_slan_cd" ).append("\n"); 
		query.append("                      and flnk.skd_dir_cd = polt.skd_dir_cd" ).append("\n"); 
		query.append("                      and flnk.lnk_DEST_loc_cd = podt.port_cd" ).append("\n"); 
		query.append("                      and flnk.VSL_SLAN_CD = podt.vsl_slan_cd" ).append("\n"); 
		query.append("                      and flnk.skd_dir_cd = podt.skd_dir_cd" ).append("\n"); 
		query.append("                      and cpyn.cpy_no in ( decode(flnk.PCTL_IO_BND_CD, 'B', 1, 'O', 1), decode(flnk.PCTL_IO_BND_CD, 'B', 2, 'O', 2), decode(flnk.PCTL_IO_BND_CD, 'B', 3, 'O', 3)" ).append("\n"); 
		query.append("                                         , decode(flnk.PCTL_IO_BND_CD, 'B', 4, 'I', 4), decode(flnk.PCTL_IO_BND_CD, 'B', 5, 'I', 5), decode(flnk.PCTL_IO_BND_CD, 'B', 6, 'I', 6))" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                     ) base" ).append("\n"); 
		query.append("                    -- ################# 가상테이블 입력 끝" ).append("\n"); 
		query.append("                    )," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    SELECT CPY_NO F_N0 FROM COM_CPY_NO WHERE CPY_NO IN ( 0,1,2, 13,14,15,16,17,18, 41,42) -- for hinterland FDR" ).append("\n"); 
		query.append("--                    SELECT CPY_NO F_N0 FROM COM_CPY_NO WHERE CPY_NO IN ( 13,14,15,16,17,18, 41) -- for hinterland FDR" ).append("\n"); 
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
		query.append(") " ).append("\n"); 
		query.append("ORDER BY GP1, ORD" ).append("\n"); 

	}
}