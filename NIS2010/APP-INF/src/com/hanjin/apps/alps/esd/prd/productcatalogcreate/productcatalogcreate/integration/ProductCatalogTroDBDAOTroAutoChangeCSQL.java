/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ProductCatalogTroDBDAOTroAutoChangeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.05.15 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogTroDBDAOTroAutoChangeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TroAutoChange
	  * </pre>
	  */
	public ProductCatalogTroDBDAOTroAutoChangeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rout_org",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sterm_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sd_term",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_t",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_cy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srf_cntr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sr_term",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prd_ctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cct",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rout_dest",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_prd_ctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_rout",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_rtn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_pu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sinclshtlso_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_t",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogTroDBDAOTroAutoChangeCSQL").append("\n"); 
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
		query.append("    INTO PRD_PROD_CTL_MST " ).append("\n"); 
		query.append("    (PCTL_NO, MTY_PKUP_YD_CD, POR_CD, POR_NOD_CD, POL_CD, N1ST_TS_PORT_CD, N2ND_TS_PORT_CD, N3RD_TS_PORT_CD, " ).append("\n"); 
		query.append("    POD_CD, DEL_CD, DEL_NOD_CD, MTY_RTN_YD_CD, OB_ITCHG_CTNT, IB_ITCHG_CTNT, FULL_RTN_YD_CD,POL_NOD_CD,POD_NOD_CD,FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("    N1ST_VSL_LODG_DUE_DT,BKG_RCV_TERM_CD, BKG_DE_TERM_CD,  CMDT_CD, BKG_OFC_CD,  SC_OFC_CD,CRE_USR_ID, CRE_DT,UPD_USR_ID, UPD_DT," ).append("\n"); 
		query.append("    MCNTR_DOR_ARR_DUE_DT,TRNK_AVAL_SPC,TRNK_VSL_CD,TRNK_SKD_VOY_NO,TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("    BKG_CGO_TP_CD,SHPR_CNT_CD,SHPR_SEQ,CNEE_CNT_CD,CNEE_SEQ,SC_NO,RFA_NO,REP_CMDT_CD,DG_CLSS_CD," ).append("\n"); 
		query.append("    DG_SPCL_FLG,RF_SPCL_FLG,SPCL_AWK_CGO_FLG,BB_SPCL_FLG,RD_SPCL_FLG,HNGR_SPCL_FLG,SOC_FLG,EQ_SUBST_FLG,BKG_WGT,BKG_WGT_UT_CD," ).append("\n"); 
		query.append("    SLS_OFC_CD,RFA_OFC_CD,PRM_CUST_FLG,TTL_TZTM_HRS, TTL_EXPN_AMT,CNST_FLG, ROUT_CNST_SEQ    " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VALUES " ).append("\n"); 
		query.append("    (PCTL_NO,NVL(MTPU_CY,MTY_PKUP_YD_CD),DECODE(@[io_bnd_cd],'O',SUBSTR(R_ORG2,1,5),POR_CD),DECODE(@[io_bnd_cd],'O',R_ORG2,POR_NOD_CD), POL_CD ,N1ST_TS_PORT_CD, N2ND_TS_PORT_CD,N3RD_TS_PORT_CD," ).append("\n"); 
		query.append("    POD_CD,DECODE(@[io_bnd_cd],'I',SUBSTR(R_DEST2,1,5),DEL_CD),DECODE(@[io_bnd_cd],'I',R_DEST2,DEL_NOD_CD),NVL(MTRTN_CY,MTY_RTN_YD_CD), " ).append("\n"); 
		query.append("    DECODE(@[io_bnd_cd],'O',INLND_CONTENT,OB_ITCHG_CTNT),DECODE(@[io_bnd_cd],'I',INLND_CONTENT,IB_ITCHG_CTNT)," ).append("\n"); 
		query.append("    NVL(FULL_RTN,FULL_RTN_YD_CD) ,DECODE(@[io_bnd_cd],'O',R_DEST2,POL_NOD_CD),DECODE(@[io_bnd_cd],'I',R_ORG2,POD_NOD_CD),NVL(FULL_PKUP,FULL_PKUP_YD_CD)," ).append("\n"); 
		query.append("    N1ST_VSL_LODG_DUE_DT ,@[sr_term], @[sd_term],CMDT_CD,BKG_OFC_CD,  SC_OFC_CD,NVL(@[cre_usr_id],'System'), SYSDATE,NVL(@[cre_usr_id],'System'), SYSDATE," ).append("\n"); 
		query.append("    MCNTR_DOR_ARR_DUE_DT,TRNK_AVAL_SPC,TRNK_VSL_CD,TRNK_SKD_VOY_NO,TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("    BKG_CGO_TP_CD,SHPR_CNT_CD,SHPR_SEQ,CNEE_CNT_CD,CNEE_SEQ,SC_NO,RFA_NO,REP_CMDT_CD,DG_CLSS_CD," ).append("\n"); 
		query.append("    DG_SPCL_FLG,RF_SPCL_FLG,SPCL_AWK_CGO_FLG,BB_SPCL_FLG,RD_SPCL_FLG,HNGR_SPCL_FLG,SOC_FLG,EQ_SUBST_FLG,BKG_WGT,BKG_WGT_UT_CD," ).append("\n"); 
		query.append("    SLS_OFC_CD,RFA_OFC_CD,PRM_CUST_FLG,TTL_TZTM_HRS, TTL_EXPN_AMT,MCNST_FLG, ROUT_CNST_SEQ " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("WHEN PCTL_SEQ > 0 THEN" ).append("\n"); 
		query.append("    INTO PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("    ( PCTL_NO, PCTL_SEQ, ORG_NOD_CD, DEST_NOD_CD, NOD_LNK_DIV_CD, PCTL_IO_BND_CD, TRSP_MOD_CD, " ).append("\n"); 
		query.append("    PCTL_WTR_DIV_CD, ORG_NOD_TP_CD, DEST_NOD_TP_CD, MTY_YD_FLG, ARR_ST_DT, DEP_FSH_DT, TZ_DWLL_TM_HRS, " ).append("\n"); 
		query.append("    N1ST_VNDR_SEQ,N2ND_VNDR_SEQ, N3RD_VNDR_SEQ, VSL_SLAN_CD, CRR_CD, VSL_CD, SKD_VOY_NO," ).append("\n"); 
		query.append("    INLND_ROUT_CMB_FLG, INLND_ROUT_INV_BIL_PATT_CD, SKD_DIR_CD, ROUT_ORG_NOD_CD,  ROUT_DEST_NOD_CD, " ).append("\n"); 
		query.append("    ROUT_SEQ, ORG_CLPT_IND_SEQ,DEST_CLPT_IND_SEQ,  " ).append("\n"); 
		query.append("    RAIL_CRR_TP_CD,INLND_ROUT_INCL_STTL_FLG,TRSP_AGMT_OFC_CTY_CD,TRSP_AGMT_SEQ,AGMT_REF_NO," ).append("\n"); 
		query.append("    CRE_USR_ID, CRE_DT,UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("    VALUES " ).append("\n"); 
		query.append("    (PCTL_NO,PCTL_SEQ,NODE_NEW1,NODE_NEW2,NODE_NEW_KIND,OI_BND_CD,TRSP_MOD_CD," ).append("\n"); 
		query.append("    WTR_DIV_CD,NODE1_TP,NODE2_TP,MTY_YD_FLG,ARR_ST_DT,DEP_FSH_DT,TZTM_DW_HRS," ).append("\n"); 
		query.append("    N1ST_VNDR_SEQ,N2ND_VNDR_SEQ,N3RD_VNDR_SEQ,VSL_SLAN_CD,CRR_CD,VSL_CD,VOY_NO," ).append("\n"); 
		query.append("    INLND_ROUT_CMB_FLG,INLND_ROUT_INV_BIL_PATT_CD,DIR_CD,ROUT_ORG,ROUT_DEST," ).append("\n"); 
		query.append("    ROUT_SEQ,ORG_CLPT_IND_SEQ,DEST_CLPT_IND_SEQ," ).append("\n"); 
		query.append("    RAIL_CRR_TYPE,INLND_ROUT_INCL_STTL_FLG,TRSP_AGMT_OFC_CTY_CD,TRSP_AGMT_SEQ,AGMT_REF_NO," ).append("\n"); 
		query.append("    NVL(@[cre_usr_id],'System'), SYSDATE,NVL(@[cre_usr_id],'System'), SYSDATE) " ).append("\n"); 
		query.append("SELECT N.PCTL_NO,N.PCTL_SEQ, " ).append("\n"); 
		query.append("N.NODE_NEW1,N.NODE_NEW2,N.NODE_NEW_KIND,N.OI_BND_CD,N.TRSP_MOD_CD,N.WTR_DIV_CD,N.NODE1_TP,N.NODE2_TP,N. MTY_YD_FLG," ).append("\n"); 
		query.append("N.ARR_ST_DT,N.DEP_FSH_DT,N.TZTM_DW_HRS,N.N1ST_VNDR_SEQ,N.N2ND_VNDR_SEQ,N.N3RD_VNDR_SEQ," ).append("\n"); 
		query.append("N.VSL_SLAN_CD,N.CRR_CD,N.VSL_CD,N.VOY_NO,N.DIR_CD,N.GEN_AVAL_SPC,N.D7_AVAL_SPC,N.RF_AVAL_SPC,N.MTPU_CY,N.MTRTN_CY,N.FULL_PKUP,N.FULL_RTN,INLND_CONTENT," ).append("\n"); 
		query.append("N.INLND_ROUT_INV_BIL_PATT_CD,N.INLND_ROUT_CMB_FLG,N.ROUT_ORG,N.ROUT_DEST,N.ROUT_SEQ,N.CNST_FLG," ).append("\n"); 
		query.append("N.ORG_CLPT_IND_SEQ,N.DEST_CLPT_IND_SEQ,N.RAIL_CRR_TYPE,N.INLND_ROUT_INCL_STTL_FLG,N.TRSP_AGMT_OFC_CTY_CD,N.TRSP_AGMT_SEQ,N.AGMT_REF_NO,N.R_ORG2,N.R_DEST2,N.R_SEQ2," ).append("\n"); 
		query.append("O.MTY_PKUP_YD_CD, O.POR_CD, O.POR_NOD_CD, O.POL_CD, O.N1ST_TS_PORT_CD, O.N2ND_TS_PORT_CD, O.N3RD_TS_PORT_CD, " ).append("\n"); 
		query.append("O.POD_CD, O.DEL_CD, O.DEL_NOD_CD, O.MTY_RTN_YD_CD, O.OB_ITCHG_CTNT, O.IB_ITCHG_CTNT, O.FULL_RTN_YD_CD,O.POL_NOD_CD,O.POD_NOD_CD,O.FULL_PKUP_YD_CD," ).append("\n"); 
		query.append("O.N1ST_VSL_LODG_DUE_DT,O.BKG_RCV_TERM_CD, O.BKG_DE_TERM_CD,  O.CMDT_CD, O.BKG_OFC_CD,  O.SC_OFC_CD," ).append("\n"); 
		query.append("O.MCNTR_DOR_ARR_DUE_DT,O.TRNK_AVAL_SPC,O.TRNK_VSL_CD,O.TRNK_SKD_VOY_NO,O.TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("O.BKG_CGO_TP_CD,O.SHPR_CNT_CD,O.SHPR_SEQ,O.CNEE_CNT_CD,O.CNEE_SEQ,O.SC_NO,O.RFA_NO,O.REP_CMDT_CD,O.DG_CLSS_CD," ).append("\n"); 
		query.append("O.DG_SPCL_FLG,O.RF_SPCL_FLG,O.SPCL_AWK_CGO_FLG,O.BB_SPCL_FLG,O.RD_SPCL_FLG,O.HNGR_SPCL_FLG,O.SOC_FLG,O.EQ_SUBST_FLG,O.BKG_WGT,O.BKG_WGT_UT_CD," ).append("\n"); 
		query.append("O.SLS_OFC_CD,O.RFA_OFC_CD,O.PRM_CUST_FLG,O.TTL_TZTM_HRS,O.TTL_EXPN_AMT,O.CNST_FLG MCNST_FLG,O.ROUT_CNST_SEQ " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT X.PCTL_NO,ROW_NUMBER() OVER (ORDER BY BND_ORD,PCTL_SEQ) PCTL_SEQ," ).append("\n"); 
		query.append("    FIRST_VALUE(CHK) OVER (PARTITION BY PCTL_NO ORDER BY CHK ) CHK," ).append("\n"); 
		query.append("    X.NODE_NEW1,X.NODE_NEW2,X.NODE_NEW_KIND,X.OI_BND_CD,X.TRSP_MOD_CD,X.WTR_DIV_CD,X.NODE1_TP,X.NODE2_TP,X. MTY_YD_FLG," ).append("\n"); 
		query.append("    X.ARR_ST_DT,X.DEP_FSH_DT,X.TZTM_DW_HRS,X.N1ST_VNDR_SEQ,X.N2ND_VNDR_SEQ,X.N3RD_VNDR_SEQ," ).append("\n"); 
		query.append("    X.VSL_SLAN_CD,X.CRR_CD,X.VSL_CD,X.VOY_NO,X.DIR_CD,X.GEN_AVAL_SPC,X.D7_AVAL_SPC,X.RF_AVAL_SPC,X.MTPU_CY,X.MTRTN_CY,X.FULL_PKUP,X.FULL_RTN,INLND_CONTENT," ).append("\n"); 
		query.append("    X.INLND_ROUT_INV_BIL_PATT_CD,X.INLND_ROUT_CMB_FLG,X.R_ORG2 ROUT_ORG,X.R_DEST2 ROUT_DEST,X.R_SEQ2 ROUT_SEQ,X.CNST_FLG," ).append("\n"); 
		query.append("    X.ORG_CLPT_IND_SEQ,X.DEST_CLPT_IND_SEQ,X.RAIL_CRR_TYPE,X.INLND_ROUT_INCL_STTL_FLG,X.TRSP_AGMT_OFC_CTY_CD,X.TRSP_AGMT_SEQ,X.AGMT_REF_NO," ).append("\n"); 
		query.append("    FIRST_VALUE(R_ORG2) OVER (ORDER BY CHK ROWS UNBOUNDED PRECEDING) R_ORG2," ).append("\n"); 
		query.append("    FIRST_VALUE(R_DEST2) OVER (ORDER BY CHK ROWS UNBOUNDED PRECEDING) R_DEST2," ).append("\n"); 
		query.append("    FIRST_VALUE(R_SEQ2) OVER (ORDER BY CHK ROWS UNBOUNDED PRECEDING) R_SEQ2" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("        @[new_prd_ctl_no]||'0001' PCTL_NO,ROW_NUMBER() OVER (ORDER BY GP1,F_NO2,L_N0,O1) PCTL_SEQ," ).append("\n"); 
		query.append("        DECODE(OI_BND_CD,'O',1,'T',2,'I',3) BND_ORD, '1' CHK," ).append("\n"); 
		query.append("        NODE_NEW1,NODE_NEW2,NODE_NEW_KIND,OI_BND_CD,TRSP_MOD_CD," ).append("\n"); 
		query.append("        DECODE(TRSP_MOD_CD,'WD','W','VD','V') WTR_DIV_CD,NODE1_TP,NODE2_TP, " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("         CASE" ).append("\n"); 
		query.append("         WHEN F_NO2 = 0  AND NODE_NEW_KIND = 'N' AND @[sr_term] <> 'S' THEN 'Y'" ).append("\n"); 
		query.append("         WHEN F_NO2 = 13 AND NODE_NEW_KIND = 'N' AND @[sd_term] <> 'S' THEN 'Y'" ).append("\n"); 
		query.append("         ELSE 'N' END" ).append("\n"); 
		query.append("         ) MTY_YD_FLG," ).append("\n"); 
		query.append("        (CASE WHEN @[io_bnd_cd] ='O' AND F_NO2 = 12  THEN TO_DATE(@[cct],'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY O1 DESC,L_N0 DESC,F_NO2 DESC  ) /24) +NVL(TZTM_DW_HRS,12)/24 " ).append("\n"); 
		query.append("              WHEN @[io_bnd_cd] ='O' AND F_NO2 <  12 THEN TO_DATE(@[cct],'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY O1 DESC,L_N0 DESC,F_NO2 DESC ) /24)  + DECODE(@[pm_f],'Y',3, 6)/24 " ).append("\n"); 
		query.append("              WHEN @[io_bnd_cd] ='I' THEN TO_DATE(@[pod_t],'YYYYMMDDHH24MISS') +(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY GP1,F_NO2,L_N0,O1  ) /24) -NVL(TZTM_DW_HRS,12)/24" ).append("\n"); 
		query.append("        END) " ).append("\n"); 
		query.append("        ARR_ST_DT," ).append("\n"); 
		query.append("        (CASE WHEN @[io_bnd_cd] ='O' AND F_NO2 = 12 THEN TO_DATE(@[pol_t],'YYYYMMDDHH24MISS') ---(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY O1 DESC,L_N0 DESC,F_NO2 DESC  ) /24) +TZTM_DW_HRS/24" ).append("\n"); 
		query.append("              WHEN @[io_bnd_cd] ='O' AND F_NO2 <  12 THEN TO_DATE(@[cct],'YYYYMMDDHH24MISS') -(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY O1 DESC,L_N0 DESC,F_NO2 DESC   ) /24) +NVL(TZTM_DW_HRS,12)/24 + DECODE(@[pm_f],'Y',3, 6)/24" ).append("\n"); 
		query.append("              WHEN @[io_bnd_cd] ='I' THEN TO_DATE(@[pod_t],'YYYYMMDDHH24MISS') +(SUM(TZTM_DW_HRS) OVER (PARTITION BY GP1,OI_BND_CD ORDER BY GP1,F_NO2,L_N0,O1  ) /24) " ).append("\n"); 
		query.append("        END) " ).append("\n"); 
		query.append("        DEP_FSH_DT," ).append("\n"); 
		query.append("        TZTM_DW_HRS," ).append("\n"); 
		query.append("        (CASE WHEN NODE_NEW_KIND = 'N' THEN N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("              WHEN NODE_NEW_KIND = 'L' AND F_NO2 =0 AND @[sr_term] = 'D' THEN  LEAD(N1ST_VNDR_SEQ, 1)" ).append("\n"); 
		query.append("                                       OVER ( PARTITION BY GP1,NODE_NEW_KIND ORDER BY GP1,F_NO2,L_N0,O1)" ).append("\n"); 
		query.append("              WHEN NODE_NEW_KIND = 'L' AND F_NO2 =12 AND @[sd_term] = 'D' THEN  LAG(N1ST_VNDR_SEQ, 1)" ).append("\n"); 
		query.append("                                       OVER ( PARTITION BY GP1,NODE_NEW_KIND ORDER BY GP1,F_NO2,L_N0,O1)" ).append("\n"); 
		query.append("              ELSE N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("        ) N1ST_VNDR_SEQ,        " ).append("\n"); 
		query.append("        N2ND_VNDR_SEQ,N3RD_VNDR_SEQ," ).append("\n"); 
		query.append("        '' VSL_SLAN_CD," ).append("\n"); 
		query.append("        '' CRR_CD," ).append("\n"); 
		query.append("        '' VSL_CD, " ).append("\n"); 
		query.append("        '' VOY_NO," ).append("\n"); 
		query.append("        '' DIR_CD," ).append("\n"); 
		query.append("        NULL GEN_AVAL_SPC," ).append("\n"); 
		query.append("        NULL D7_AVAL_SPC," ).append("\n"); 
		query.append("        NULL RF_AVAL_SPC," ).append("\n"); 
		query.append("        MTPU_CY,MTRTN_CY,FULL_PKUP_YD_CD FULL_PKUP,FULL_RTN_YD_CD FULL_RTN,INLND_CONTENT," ).append("\n"); 
		query.append("        INLND_ROUT_INV_BIL_PATT_CD,INLND_ROUT_CMB_FLG, " ).append("\n"); 
		query.append("        R_ORG2, R_DEST2, R_SEQ2," ).append("\n"); 
		query.append("        '' CNST_FLG," ).append("\n"); 
		query.append("        NULL ORG_CLPT_IND_SEQ," ).append("\n"); 
		query.append("        NULL DEST_CLPT_IND_SEQ," ).append("\n"); 
		query.append("        RAIL_CRR_TYPE, INLND_ROUT_INCL_STTL_FLG, TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ, AGMT_REF_NO        " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("             GP1,F_NO2,L_N0,O1,NODE_NEW1," ).append("\n"); 
		query.append("             NVL((SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = NODE_NEW1), (SELECT 'Y' FROM MDM_LSE_CO_YD WHERE LSE_CO_YD_CD = NODE_NEW1 AND F_NO2 = 13 AND @[io_bnd_cd] = 'I')) NODE1_TP," ).append("\n"); 
		query.append("--             (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = NODE_NEW1) NODE1_TP," ).append("\n"); 
		query.append("             DECODE(LENGTH(NODE_NEW2),7,NODE_NEW2,SUBSTR(NODE_NEW2,3,7))  NODE_NEW2," ).append("\n"); 
		query.append("             DECODE(LENGTH(NODE_NEW2),7,'N',SUBSTR(NODE_NEW2,18,1))  INLND_ROUT_CMB_FLG," ).append("\n"); 
		query.append("             DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,19,3))  INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("             DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,22,3))  RAIL_CRR_TYPE," ).append("\n"); 
		query.append("             DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,25,3))  TRSP_AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("             TO_NUMBER(DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,28,6)))  TRSP_AGMT_SEQ," ).append("\n"); 
		query.append("             DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,34,15))  AGMT_REF_NO," ).append("\n"); 
		query.append("             DECODE(LENGTH(NODE_NEW2),7,'',SUBSTR(NODE_NEW2,49,1))  INLND_ROUT_INCL_STTL_FLG," ).append("\n"); 
		query.append("             NVL((SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = DECODE(LENGTH(NODE_NEW2),7,NODE_NEW2,SUBSTR(NODE_NEW2,3,7)))" ).append("\n"); 
		query.append("                ,(SELECT 'Y' FROM MDM_LSE_CO_YD WHERE LSE_CO_YD_CD = DECODE(LENGTH(NODE_NEW2),7,NODE_NEW2,SUBSTR(NODE_NEW2,3,7)) AND (F_NO2 = 13 OR (F_NO2 = 12 AND L_N0 = 2 )) AND @[io_bnd_cd] = 'I' )) NODE2_TP," ).append("\n"); 
		query.append("--             (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = DECODE(LENGTH(NODE_NEW2),7,NODE_NEW2,SUBSTR(NODE_NEW2,3,7)))" ).append("\n"); 
		query.append("--              NODE2_TP," ).append("\n"); 
		query.append("             NODE_NEW_KIND,OI_BND_CD," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("                WHEN NODE_NEW_KIND='N' THEN 'X'" ).append("\n"); 
		query.append("                WHEN NODE_NEW_KIND='L' AND F_NO2 IN (0,12) THEN 'TD'" ).append("\n"); 
		query.append("                WHEN NODE_NEW_KIND='L' AND LENGTH(NODE_NEW2) > 7 THEN SUBSTR(NODE_NEW2,10,2)" ).append("\n"); 
		query.append("                ELSE 'TD'  END" ).append("\n"); 
		query.append("            ) TRSP_MOD_CD," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("                WHEN NODE_NEW_KIND='N' AND F_NO2 IN (1,12)" ).append("\n"); 
		query.append("                                   AND (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = NODE_NEW1) = 'Z' THEN" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                     SELECT CGO_HNDL_TM_HRS FROM MDM_ZONE WHERE ZN_CD = NODE_NEW1" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("                 WHEN NODE_NEW_KIND='N' AND F_NO2 = 1 AND @[sr_term] ='S' AND  R_SEQ2 = 0 AND" ).append("\n"); 
		query.append("                       (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = NODE_NEW1) <> 'Z' THEN 0" ).append("\n"); 
		query.append("                WHEN NODE_NEW_KIND='N' AND F_NO2 = 12 AND @[sd_term] ='S' AND  R_SEQ2 = 0 AND" ).append("\n"); 
		query.append("                       (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = NODE_NEW2) <> 'Z' THEN  0" ).append("\n"); 
		query.append("                 WHEN NODE_NEW_KIND='N' AND (SELECT NOD_TP_CD FROM PRD_NODE WHERE NOD_CD = NODE_NEW1) <> 'Z' THEN" ).append("\n"); 
		query.append("                 (" ).append("\n"); 
		query.append("                    SELECT DECODE(F_NO2,13,0,DECODE(F_NO2,0,0,DECODE(OI_BND_CD, 'T', 0, 'O', DECODE(@[spm_flg], 'Y', 3, 6), DECODE(@[spm_flg],'Y'," ).append("\n"); 
		query.append("                        DECODE(@[srf_cntr] ,'Y',NVL(DECODE(OI_BND_CD, 'O',OB_RF_MIN_DWLL_HRS,IB_RF_MIN_DWLL_HRS),3), NVL(DECODE(OI_BND_CD, 'O',OB_DRY_MIN_DWLL_HRS,IB_DRY_MIN_DWLL_HRS),6))," ).append("\n"); 
		query.append("                        DECODE(@[srf_cntr] ,'Y',NVL(DECODE(OI_BND_CD, 'O',OB_RF_AVG_DWLL_HRS,IB_RF_AVG_DWLL_HRS),3), NVL(DECODE(OI_BND_CD, 'O',OB_DRY_AVG_DWLL_HRS,IB_DRY_AVG_DWLL_HRS),6)) ))))" ).append("\n"); 
		query.append("                    FROM MDM_YARD WHERE YD_CD = NODE_NEW1" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("                WHEN  NODE_NEW_KIND='L' AND @[sr_term] = 'D' AND F_NO2 = 0   THEN" ).append("\n"); 
		query.append("                (SELECT TZTM_HRS FROM MDM_ZONE WHERE ZN_CD = NODE_NEW2 )" ).append("\n"); 
		query.append("                WHEN  NODE_NEW_KIND='L' AND @[sd_term] = 'D' AND F_NO2 = 12  THEN" ).append("\n"); 
		query.append("                (SELECT TZTM_HRS FROM MDM_ZONE WHERE ZN_CD = NODE_NEW1 )" ).append("\n"); 
		query.append("                WHEN  NODE_NEW_KIND='L' AND @[sr_term] NOT IN ( 'D','S' ) AND F_NO2 = 0   THEN 24" ).append("\n"); 
		query.append("                WHEN  NODE_NEW_KIND='L' AND @[sd_term] NOT IN ( 'D','S' ) AND F_NO2 = 12  THEN 24" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                 NVL((SELECT TZTM_HRS" ).append("\n"); 
		query.append("                    FROM PRD_INLND_EACH_LNK" ).append("\n"); 
		query.append("                   WHERE LNK_ORG_NOD_CD = NODE_NEW1" ).append("\n"); 
		query.append("                    AND LNK_DEST_NOD_CD = DECODE(LENGTH(NODE_NEW2),7,NODE_NEW2,SUBSTR(NODE_NEW2,3,7))" ).append("\n"); 
		query.append("                    AND TRSP_MOD_CD = DECODE(LENGTH(NODE_NEW2),7,'TD',SUBSTR(NODE_NEW2,10,2))" ).append("\n"); 
		query.append("                    ), 6)" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("            ) TZTM_DW_HRS," ).append("\n"); 
		query.append("           '' SLANE," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("                WHEN NODE_NEW_KIND='N' THEN" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("                    FROM MDM_YARD" ).append("\n"); 
		query.append("                    WHERE YD_CD = NODE_NEW1" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                WHEN NODE_NEW_KIND='L' AND LENGTH(NODE_NEW2) > 7 THEN TO_NUMBER(SUBSTR(NODE_NEW2,12,6))" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("            ) N1ST_VNDR_SEQ," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("                WHEN NODE_NEW_KIND='N' THEN" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT N2ND_VNDR_SEQ" ).append("\n"); 
		query.append("                    FROM MDM_YARD" ).append("\n"); 
		query.append("                    WHERE YD_CD = NODE_NEW1" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("             END" ).append("\n"); 
		query.append("             ) N2ND_VNDR_SEQ," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("                WHEN NODE_NEW_KIND='N' THEN" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT N3RD_VNDR_SEQ" ).append("\n"); 
		query.append("                    FROM MDM_YARD" ).append("\n"); 
		query.append("                    WHERE YD_CD = NODE_NEW1" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("             END" ).append("\n"); 
		query.append("             ) N3RD_VNDR_SEQ," ).append("\n"); 
		query.append("            '' DIR_CD,MTPU_CY,MTRTN_CY,FULL_PKUP_YD_CD,FULL_RTN_YD_CD,INLND_CONTENT," ).append("\n"); 
		query.append("            R_ORG2, R_DEST2, R_SEQ2 " ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                GP1,  F_N0 AS F_NO2, L_N0, O1," ).append("\n"); 
		query.append("                DECODE(LENGTH(NODE1),7,NODE1,SUBSTR(NODE1,3,7)) NODE_NEW1," ).append("\n"); 
		query.append("                (CASE L_N0 WHEN 1 THEN NODE1 WHEN 2 THEN LEAD(NODE1, 1, NULL) OVER (PARTITION BY GP1 ORDER BY GP1,F_N0,L_N0,O1) END ) NODE_NEW2," ).append("\n"); 
		query.append("                (CASE L_N0 WHEN 1 THEN 'N' WHEN 2 THEN 'L' END) NODE_NEW_KIND," ).append("\n"); 
		query.append("                @[io_bnd_cd] AS  OI_BND_CD,MTPU_CY,MTRTN_CY,FULL_PKUP_YD_CD,FULL_RTN_YD_CD,INLND_CONTENT," ).append("\n"); 
		query.append("                R_ORG2, R_DEST2, R_SEQ2" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT" ).append("\n"); 
		query.append("                    F_N0," ).append("\n"); 
		query.append("                    GP1," ).append("\n"); 
		query.append("                    NODE1, ROWNUM O1," ).append("\n"); 
		query.append("                    MTPU_CY,MTRTN_CY,FULL_PKUP_YD_CD,FULL_RTN_YD_CD,INLND_CONTENT," ).append("\n"); 
		query.append("                    R_ORG2," ).append("\n"); 
		query.append("                    R_DEST2," ).append("\n"); 
		query.append("                    R_SEQ2" ).append("\n"); 
		query.append("                    FROM" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                        SELECT F_N0," ).append("\n"); 
		query.append("                        GP1," ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        CASE F_N0" ).append("\n"); 
		query.append("                            WHEN 0 THEN MTPU_CY    WHEN 1 THEN R_ORG" ).append("\n"); 
		query.append("                            WHEN 2 THEN R_NODE01   WHEN 3 THEN R_NODE02   WHEN 4 THEN R_NODE03   WHEN 5 THEN R_NODE04" ).append("\n"); 
		query.append("                            WHEN 6 THEN R_NODE05   WHEN 7 THEN R_NODE06   WHEN 8 THEN R_NODE07   WHEN 9 THEN R_NODE08" ).append("\n"); 
		query.append("                            WHEN 10 THEN R_NODE09 WHEN 11 THEN R_NODE10  WHEN 12 THEN R_DEST WHEN 13 THEN MTRTN_CY" ).append("\n"); 
		query.append("                            ELSE 'N/A'" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                        ) NODE1,MTPU_CY,MTRTN_CY,FULL_PKUP_YD_CD,FULL_RTN_YD_CD,INLND_CONTENT," ).append("\n"); 
		query.append("                        R_ORG2,R_DEST2,R_SEQ2" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                            SELECT" ).append("\n"); 
		query.append("                            MTPU_CY," ).append("\n"); 
		query.append("                            ROUT_ORG_NOD_CD R_ORG," ).append("\n"); 
		query.append("                            R_NODE01," ).append("\n"); 
		query.append("                            R_NODE02," ).append("\n"); 
		query.append("                            R_NODE03," ).append("\n"); 
		query.append("                            R_NODE04," ).append("\n"); 
		query.append("                            R_NODE05," ).append("\n"); 
		query.append("                            R_NODE06," ).append("\n"); 
		query.append("                            R_NODE07," ).append("\n"); 
		query.append("                            R_NODE08," ).append("\n"); 
		query.append("                            R_NODE09," ).append("\n"); 
		query.append("                            R_NODE10," ).append("\n"); 
		query.append("                            DEL AS R_DEST," ).append("\n"); 
		query.append("                            MTRTN_CY," ).append("\n"); 
		query.append("                            FULL_PKUP_YD_CD,FULL_RTN_YD_CD,INLND_CONTENT," ).append("\n"); 
		query.append("                            ROUT_ORG_NOD_CD R_ORG2," ).append("\n"); 
		query.append("                            ROUT_DEST_NOD_CD R_DEST2," ).append("\n"); 
		query.append("                            ROUT_SEQ R_SEQ2," ).append("\n"); 
		query.append("                            ROWNUM GP1" ).append("\n"); 
		query.append("                            FROM" ).append("\n"); 
		query.append("                            (" ).append("\n"); 
		query.append("                                SELECT" ).append("\n"); 
		query.append("                                ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("                                ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("                                ROUT_SEQ," ).append("\n"); 
		query.append("                                FULL_PKUP_YD_CD,FULL_RTN_YD_CD," ).append("\n"); 
		query.append("                                ROUT_ORG_NOD_CD AS POD0," ).append("\n"); 
		query.append("                                DECODE(@[io_bnd_cd],'I','',DECODE(@[sr_term],'S',DECODE(ROUT_SEQ,0,'',ROUT_ORG_NOD_CD)," ).append("\n"); 
		query.append("                                      DECODE(@[smt_pu] ,'',MAX(DECODE(@[sr_term],'D',Z.REP_YD_CD , L.MTY_PKUP_YD_CD)),@[smt_pu] ))) MTPU_CY," ).append("\n"); 
		query.append("                                MAX(DECODE(ROUT_DTL_SEQ, 1 , DECODE(CNT, 1 , '', LNK_DEST_NOD_CD))) R_NODE01," ).append("\n"); 
		query.append("                                MAX(DECODE(ROUT_DTL_SEQ, 2 , DECODE(CNT, 2 , '', LNK_DEST_NOD_CD))) R_NODE02," ).append("\n"); 
		query.append("                                MAX(DECODE(ROUT_DTL_SEQ, 3 , DECODE(CNT, 3 , '', LNK_DEST_NOD_CD))) R_NODE03," ).append("\n"); 
		query.append("                                MAX(DECODE(ROUT_DTL_SEQ, 4 , DECODE(CNT, 4 , '', LNK_DEST_NOD_CD))) R_NODE04," ).append("\n"); 
		query.append("                                MAX(DECODE(ROUT_DTL_SEQ, 5 , DECODE(CNT, 5 , '', LNK_DEST_NOD_CD))) R_NODE05," ).append("\n"); 
		query.append("                                MAX(DECODE(ROUT_DTL_SEQ, 6 , DECODE(CNT, 6 , '', LNK_DEST_NOD_CD))) R_NODE06," ).append("\n"); 
		query.append("                                MAX(DECODE(ROUT_DTL_SEQ, 7 , DECODE(CNT, 7 , '', LNK_DEST_NOD_CD))) R_NODE07," ).append("\n"); 
		query.append("                                MAX(DECODE(ROUT_DTL_SEQ, 8 , DECODE(CNT, 8 , '', LNK_DEST_NOD_CD))) R_NODE08," ).append("\n"); 
		query.append("                                MAX(DECODE(ROUT_DTL_SEQ, 9 , DECODE(CNT, 9 , '', LNK_DEST_NOD_CD))) R_NODE09," ).append("\n"); 
		query.append("                                MAX(DECODE(ROUT_DTL_SEQ, 10, DECODE(CNT, 10, '', LNK_DEST_NOD_CD))) R_NODE10," ).append("\n"); 
		query.append("                                MAX(LNK_DEST_NOD_CD) DEL," ).append("\n"); 
		query.append("                                MAX(DECODE(CNT, 1, '', DECODE(CNT, 1 , '', DECODE(ROUT_DTL_SEQ, 1 , SUBSTR(LNK_DEST_NOD_CD,3,7))))) ||       " ).append("\n"); 
		query.append("                                MAX(DECODE(CNT, 1, '', DECODE(CNT, 2 , '', DECODE(ROUT_DTL_SEQ, 2 , '-'||SUBSTR(LNK_DEST_NOD_CD,3,7))))) ||  " ).append("\n"); 
		query.append("                                MAX(DECODE(CNT, 1, '', DECODE(CNT, 3 , '', DECODE(ROUT_DTL_SEQ, 3 , '-'||SUBSTR(LNK_DEST_NOD_CD,3,7))))) ||  " ).append("\n"); 
		query.append("                                MAX(DECODE(CNT, 1, '', DECODE(CNT, 4 , '', DECODE(ROUT_DTL_SEQ, 4 , '-'||SUBSTR(LNK_DEST_NOD_CD,3,7))))) ||  " ).append("\n"); 
		query.append("                                MAX(DECODE(CNT, 1, '', DECODE(CNT, 5 , '', DECODE(ROUT_DTL_SEQ, 5 , '-'||SUBSTR(LNK_DEST_NOD_CD,3,7))))) ||  " ).append("\n"); 
		query.append("                                MAX(DECODE(CNT, 1, '', DECODE(CNT, 6 , '', DECODE(ROUT_DTL_SEQ, 6 , '-'||SUBSTR(LNK_DEST_NOD_CD,3,7))))) ||  " ).append("\n"); 
		query.append("                                MAX(DECODE(CNT, 1, '', DECODE(CNT, 7 , '', DECODE(ROUT_DTL_SEQ, 7 , '-'||SUBSTR(LNK_DEST_NOD_CD,3,7))))) ||  " ).append("\n"); 
		query.append("                                MAX(DECODE(CNT, 1, '', DECODE(CNT, 8 , '', DECODE(ROUT_DTL_SEQ, 8 , '-'||SUBSTR(LNK_DEST_NOD_CD,3,7))))) ||  " ).append("\n"); 
		query.append("                                MAX(DECODE(CNT, 1, '', DECODE(CNT, 9 , '', DECODE(ROUT_DTL_SEQ, 9 , '-'||SUBSTR(LNK_DEST_NOD_CD,3,7))))) ||  " ).append("\n"); 
		query.append("                                MAX(DECODE(CNT, 1, '', DECODE(CNT, 10, '', DECODE(ROUT_DTL_SEQ, 10, '-'||SUBSTR(LNK_DEST_NOD_CD,3,7)))))     " ).append("\n"); 
		query.append("                                AS INLND_CONTENT," ).append("\n"); 
		query.append("                                DECODE(@[io_bnd_cd],'O','',DECODE(@[sd_term],'S',DECODE(ROUT_SEQ,0,'',ROUT_DEST_NOD_CD)," ).append("\n"); 
		query.append("                                     DECODE(@[smt_rtn] ,'',MAX(DECODE(@[sd_term],'D',Z.REP_YD_CD, L.EQ_RTN_YD_CD)),@[smt_rtn] ))) MTRTN_CY" ).append("\n"); 
		query.append("                                FROM" ).append("\n"); 
		query.append("                                (" ).append("\n"); 
		query.append("                                    SELECT M.ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("                                    M.ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("                                    M.ROUT_SEQ," ).append("\n"); 
		query.append("                                    M.PRIO_SEQ," ).append("\n"); 
		query.append("                                    M.FULL_PKUP_YD_CD, M.FULL_RTN_YD_CD," ).append("\n"); 
		query.append("                                    RPAD(D.ROUT_DTL_SEQ,2,' ')||D.LNK_DEST_NOD_CD||D.TRSP_MOD_CD||LPAD(NVL(D.VNDR_SEQ,0),6,0)||" ).append("\n"); 
		query.append("                                    NVL(D.INLND_ROUT_CMB_FLG,'N')||LPAD(NVL(M.INLND_ROUT_INV_BIL_PATT_CD,' '),3,' ') ||" ).append("\n"); 
		query.append("                                    RPAD(NVL(D.RAIL_CRR_TP_CD,' '),3,' ') || RPAD(NVL(D.TRSP_AGMT_OFC_CTY_CD,' '),3,' ') || LPAD(NVL(D.TRSP_AGMT_SEQ,0),6,0) ||" ).append("\n"); 
		query.append("                                    RPAD(NVL(D.AGMT_REF_NO,' '),15,' ') || RPAD(NVL(M.INLND_ROUT_INCL_STTL_FLG,' '),1,' ')" ).append("\n"); 
		query.append("                                     LNK_DEST_NOD_CD," ).append("\n"); 
		query.append("                                    D.ROUT_DTL_SEQ," ).append("\n"); 
		query.append("                                    COUNT(*) OVER (PARTITION BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ" ).append("\n"); 
		query.append("                                    ORDER BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ) AS CNT" ).append("\n"); 
		query.append("                                    FROM PRD_INLND_ROUT_MST M, PRD_INLND_ROUT_DTL D" ).append("\n"); 
		query.append("                                    WHERE (M.ROUT_ORG_NOD_CD,M.ROUT_DEST_NOD_CD ,M.ROUT_SEQ ) =" ).append("\n"); 
		query.append("                                       (" ).append("\n"); 
		query.append("                                        SELECT ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ" ).append("\n"); 
		query.append("                                        FROM" ).append("\n"); 
		query.append("                                           (" ).append("\n"); 
		query.append("                                            SELECT M1.ROUT_ORG_NOD_CD, M1.ROUT_DEST_NOD_CD,M1.ROUT_SEQ,@[trsp_mod_cd] TRSP_MODE,@[full_cy] FUL_CY," ).append("\n"); 
		query.append("                                                   ROW_NUMBER() OVER (ORDER BY DECODE(M1.ROUT_ORG_NOD_CD,@[inlnd_rout_org],1,2)" ).append("\n"); 
		query.append("                                                                             , DECODE(M1.ROUT_DEST_NOD_CD,@[inlnd_rout_dest],1,2)" ).append("\n"); 
		query.append("                                                                             , 1 -- FULL RTN CY (아래 배핑되므로 무시)" ).append("\n"); 
		query.append("                                                                             , 1 -- TRSP_MOD_CD (아래 매핑되므로 무시)" ).append("\n"); 
		query.append("                                                                             , DECODE(M1.INLND_ROUT_OPTM_FLG, 'Y', 1,2) " ).append("\n"); 
		query.append("                                                                             , DECODE(M1.INLND_ROUT_BKG_FLG, 'Y', 1, 2)" ).append("\n"); 
		query.append("                                                                             , DECODE(M1.INLND_ROUT_TMP_FLG, 'Y', 1, 2)" ).append("\n"); 
		query.append("                                                                             , M1.PRIO_SEQ" ).append("\n"); 
		query.append("                                                                             ) IRG_PRIO_SEQ," ).append("\n"); 
		query.append("                                                   DECODE(M1.ROUT_ORG_NOD_CD,@[inlnd_rout_org],1,2) ORG_RK," ).append("\n"); 
		query.append("                                                   DECODE(M1.ROUT_DEST_NOD_CD,@[inlnd_rout_dest],1,2) DEST_RK, NVL(M1.INLND_ROUT_TMP_FLG,'N'), M1.PRIO_SEQ " ).append("\n"); 
		query.append("                                            FROM PRD_INLND_ROUT_MST M1" ).append("\n"); 
		query.append("                                            WHERE M1.ROUT_ORG_NOD_CD LIKE DECODE(SUBSTR(@[new_prd_ctl_no], 1,1), 'H', @[inlnd_rout_org], DECODE(@[io_bnd_cd],'O',SUBSTR(@[inlnd_rout_org],1,5)||'%',@[inlnd_rout_org]))" ).append("\n"); 
		query.append("                                            AND M1.ROUT_DEST_NOD_CD LIKE DECODE(SUBSTR(@[new_prd_ctl_no], 1,1), 'H', @[inlnd_rout_dest], DECODE(@[io_bnd_cd],'I',SUBSTR(@[inlnd_rout_dest],1,5)||'%',@[inlnd_rout_dest]))" ).append("\n"); 
		query.append("                                            AND M1.INLND_ROUT_OPTM_FLG = DECODE(SUBSTR(@[new_prd_ctl_no], 1,1), 'H', 'Y', M1.INLND_ROUT_OPTM_FLG)" ).append("\n"); 
		query.append("                                            AND NVL(M1.PCTL_IO_BND_CD,@[io_bnd_cd]) = @[io_bnd_cd]" ).append("\n"); 
		query.append("                                            AND NVL(M1.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                            AND NVL(M1.INLND_ROUT_INCL_STTL_FLG,'N') = NVL(@[sinclshtlso_flg],NVL(M1.INLND_ROUT_INCL_STTL_FLG,'N'))" ).append("\n"); 
		query.append("                                            AND PRD_GET_INLND_ROUT_STR_FNC(ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ) LIKE REGEXP_REPLACE(@[sub_rout],'-...-','-')||'%'" ).append("\n"); 
		query.append("											AND NVL(FULL_RTN_YD_CD,'X') = NVL(DECODE(@[io_bnd_cd],'O',NVL(@[full_cy],NVL(FULL_RTN_YD_CD,'X')),NVL(FULL_RTN_YD_CD,'X')),'X')    --FULL CY??OUTBOUND?쇰븣??TRO ?곸쓽 FULL RETURN CY" ).append("\n"); 
		query.append("                                            AND NVL(FULL_PKUP_YD_CD,'X') = NVL(DECODE(@[io_bnd_cd],'I',NVL(@[full_cy],NVL(FULL_PKUP_YD_CD,'X')),NVL(FULL_PKUP_YD_CD,'X')),'X') --INBOUND?쇰븣??FULL PICKUP CY" ).append("\n"); 
		query.append("                                            AND NVL(TRSP_MOD_CD,'X') = NVL(DECODE(@[trsp_mod_cd],'AL',NVL(TRSP_MOD_CD,'X'),@[trsp_mod_cd]),NVL(TRSP_MOD_CD,'X'))  --TRNS MODE CODE : LIST - TD,RD,WD,TR,TW (援ъ＜ TRO ?곸쓽 TRANS MODE) " ).append("\n"); 
		query.append("                                            AND EXISTS" ).append("\n"); 
		query.append("											(SELECT 'X' FROM PRD_NODE N" ).append("\n"); 
		query.append("                                            WHERE N.NOD_CD = DECODE(@[io_bnd_cd] ,'I',M1.ROUT_DEST_NOD_CD,'O',M1.ROUT_ORG_NOD_CD)" ).append("\n"); 
		query.append("                                                AND DECODE(N.NOD_TP_CD,'Z','D',N.NOD_TP_CD) IN" ).append("\n"); 
		query.append("                                                     (DECODE(DECODE(@[io_bnd_cd],'O',@[sr_term],@[sd_term]),'D','D','')," ).append("\n"); 
		query.append("                                                      DECODE(DECODE(@[io_bnd_cd],'O',@[sr_term],@[sd_term]),'T','B','F','B','Y','B','S','B','')," ).append("\n"); 
		query.append("													  DECODE(DECODE(@[io_bnd_cd],'O',@[sr_term],@[sd_term]),'T','M','F','M','Y','M','S','M','')," ).append("\n"); 
		query.append("                                                      DECODE(DECODE(@[io_bnd_cd],'O',@[sr_term],@[sd_term]),'Y','Y','S','Y','')," ).append("\n"); 
		query.append("                                                      DECODE(DECODE(@[io_bnd_cd],'O',@[sr_term],@[sd_term]),'Y','R','S','R','')," ).append("\n"); 
		query.append("                                                      DECODE(DECODE(@[io_bnd_cd],'O',@[sr_term],@[sd_term]),'Y','P','') )  )" ).append("\n"); 
		query.append("                                            AND @[sterm_node] IS NULL                    " ).append("\n"); 
		query.append("                                            --ORDER BY 6,7,8,9" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                          WHERE IRG_PRIO_SEQ =1" ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                                    AND M.ROUT_ORG_NOD_CD =D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                                    AND M.ROUT_DEST_NOD_CD =D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                                    AND M.ROUT_SEQ =D.ROUT_SEQ" ).append("\n"); 
		query.append("                                ) M , MDM_ZONE Z, MDM_LOCATION L" ).append("\n"); 
		query.append("                                WHERE Z.ZN_CD(+) = DECODE(@[io_bnd_cd],'O',M.ROUT_ORG_NOD_CD,M.ROUT_DEST_NOD_CD)" ).append("\n"); 
		query.append("                                AND L.LOC_CD(+) = SUBSTR(DECODE(@[io_bnd_cd],'O',M.ROUT_ORG_NOD_CD,M.ROUT_DEST_NOD_CD),1,5)" ).append("\n"); 
		query.append("                                AND NVL(L.DELT_FLG(+),'N') = 'N'" ).append("\n"); 
		query.append("                                AND NVL(Z.DELT_FLG(+),'N') = 'N'" ).append("\n"); 
		query.append("                               GROUP BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ,FULL_PKUP_YD_CD,FULL_RTN_YD_CD" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                                WHERE DECODE(@[io_bnd_cd],'I','X',DECODE(NVL(@[sr_term],'S'),'S','S',MTPU_CY)) IS NOT NULL" ).append("\n"); 
		query.append("                                  AND DECODE(@[io_bnd_cd],'O','X',DECODE(NVL(@[sd_term],'S'),'S','S',MTRTN_CY)) IS NOT NULL" ).append("\n"); 
		query.append("                        )," ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                            SELECT CPY_NO F_N0 FROM COM_CPY_NO WHERE CPY_NO <=13" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                        WHERE 1 = CASE WHEN DECODE(@[io_bnd_cd], 'O', @[sr_term], @[sd_term]) IN ('D','Y') THEN DECODE(DECODE(@[io_bnd_cd], 'O',MTPU_CY, MTRTN_CY), NULL, 0, 1)" ).append("\n"); 
		query.append("                                       ELSE 1 END" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    WHERE NODE1 IS NOT NULL" ).append("\n"); 
		query.append("                )," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT CPY_NO L_N0 FROM COM_CPY_NO WHERE CPY_NO IN (1,2)" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                ORDER BY 1,2,3" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            WHERE (F_NO2 <> 13 OR L_N0 <> 2 )  AND NODE_NEW2 IS NOT NULL" ).append("\n"); 
		query.append("            ORDER BY 1,2,3" ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT   @[new_prd_ctl_no]||'0001',PCTL_SEQ,DECODE(PCTL_IO_BND_CD,'O',1,'T',2,'I',3) BND_ORD, '2' CHK," ).append("\n"); 
		query.append("        ORG_NOD_CD,DEST_NOD_CD,NOD_LNK_DIV_CD,PCTL_IO_BND_CD,TRSP_MOD_CD,PCTL_WTR_DIV_CD,ORG_NOD_TP_CD,DEST_NOD_TP_CD,MTY_YD_FLG,ARR_ST_DT,DEP_FSH_DT,TZ_DWLL_TM_HRS," ).append("\n"); 
		query.append("        N1ST_VNDR_SEQ,N2ND_VNDR_SEQ,N3RD_VNDR_SEQ,VSL_SLAN_CD,CRR_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,GEN_AVAL_SPC,D7_AVAL_SPC,RF_AVAL_SPC,NULL MT_PU,NULL MT_RTN,NULL FULL_PKUP, NULL FULL_RTN,NULL INLND_CONTENT," ).append("\n"); 
		query.append("        INLND_ROUT_INV_BIL_PATT_CD,INLND_ROUT_CMB_FLG,ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ," ).append("\n"); 
		query.append("        CNST_FLG,ORG_CLPT_IND_SEQ,DEST_CLPT_IND_SEQ,RAIL_CRR_TP_CD,INLND_ROUT_INCL_STTL_FLG,TRSP_AGMT_OFC_CTY_CD,TRSP_AGMT_SEQ,AGMT_REF_NO" ).append("\n"); 
		query.append("        FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("        WHERE 2 = DECODE(SUBSTR(@[new_prd_ctl_no],1,1), 'H', 1, 2)-- H로 해야함" ).append("\n"); 
		query.append("        AND PCTL_NO = @[prd_ctl_no]" ).append("\n"); 
		query.append("        AND PCTL_IO_BND_CD <> @[io_bnd_cd]" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT   @[new_prd_ctl_no]||'0001', DECODE(@[io_bnd_cd], 'I', 1, 'O', 999) PCTL_SEQ,1 BND_ORD, '2' CHK," ).append("\n"); 
		query.append("        DECODE(@[io_bnd_cd], 'O', @[inlnd_rout_dest], @[inlnd_rout_org]) ORG_NOD_CD,DECODE(@[io_bnd_cd], 'O', @[inlnd_rout_dest], @[inlnd_rout_org]) DEST_NOD_CD, 'L' NOD_LNK_DIV_CD, 'T' PCTL_IO_BND_CD, 'VD' TRSP_MOD_CD," ).append("\n"); 
		query.append("        NULL PCTL_WTR_DIV_CD, 'M' ORG_NOD_TP_CD, 'M' DEST_NOD_TP_CD, 'N' MTY_YD_FLG, SYSDATE - 1 ARR_ST_DT, SYSDATE DEP_FSH_DT,24 TZ_DWLL_TM_HRS," ).append("\n"); 
		query.append("        NULL N1ST_VNDR_SEQ,NULL N2ND_VNDR_SEQ,NULL N3RD_VNDR_SEQ, 'FDR' VSL_SLAN_CD,'HJS' CRR_CD,'HJXX' VSL_CD,'0001' SKD_VOY_NO,'E' SKD_DIR_CD,NULL GEN_AVAL_SPC,NULL D7_AVAL_SPC,NULL RF_AVAL_SPC,NULL MT_PU,NULL MT_RTN,NULL FULL_PKUP, NULL FULL_RTN,NULL INLND_CONTENT," ).append("\n"); 
		query.append("        NULL INLND_ROUT_INV_BIL_PATT_CD,NULL INLND_ROUT_CMB_FLG,NULL ROUT_ORG_NOD_CD,NULL ROUT_DEST_NOD_CD,NULL ROUT_SEQ," ).append("\n"); 
		query.append("        NULL CNST_FLG,NULL ORG_CLPT_IND_SEQ,NULL DEST_CLPT_IND_SEQ,NULL RAIL_CRR_TP_CD,NULL INLND_ROUT_INCL_STTL_FLG,NULL TRSP_AGMT_OFC_CTY_CD,NULL TRSP_AGMT_SEQ,NULL AGMT_REF_NO" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("        WHERE 1 = DECODE(SUBSTR(@[new_prd_ctl_no],1,1), 'H', 1, 2)-- H로 해야함" ).append("\n"); 
		query.append("        ORDER BY 1,3,2    " ).append("\n"); 
		query.append("    ) X" ).append("\n"); 
		query.append(") N, " ).append("\n"); 
		query.append(" ( SELECT PCTL_NO, MTY_PKUP_YD_CD, POR_CD, POR_NOD_CD, FULL_RTN_YD_CD, FULL_PKUP_YD_CD, POL_CD, POL_NOD_CD, N1ST_TS_PORT_CD, N2ND_TS_PORT_CD" ).append("\n"); 
		query.append("     , N3RD_TS_PORT_CD, POD_CD, POD_NOD_CD, DEL_CD, DEL_NOD_CD, MTY_RTN_YD_CD, TTL_TZTM_HRS, TTL_EXPN_AMT, TRNK_AVAL_SPC, OB_ITCHG_CTNT" ).append("\n"); 
		query.append("     , IB_ITCHG_CTNT, TRNK_VSL_CD, TRNK_SKD_VOY_NO, TRNK_SKD_DIR_CD, N1ST_VSL_LODG_DUE_DT, MCNTR_DOR_ARR_DUE_DT, CNST_FLG, BKG_CGO_TP_CD, BKG_RCV_TERM_CD, BKG_DE_TERM_CD" ).append("\n"); 
		query.append("     , SHPR_CNT_CD, SHPR_SEQ, CNEE_CNT_CD, CNEE_SEQ, SC_NO, RFA_NO, REP_CMDT_CD, CMDT_CD, DG_CLSS_CD, DG_SPCL_FLG" ).append("\n"); 
		query.append("     , RF_SPCL_FLG, SPCL_AWK_CGO_FLG, BB_SPCL_FLG, RD_SPCL_FLG, HNGR_SPCL_FLG, SOC_FLG, EQ_SUBST_FLG, BKG_WGT, BKG_WGT_UT_CD, SLS_OFC_CD" ).append("\n"); 
		query.append("     , BKG_OFC_CD, SC_OFC_CD, RFA_OFC_CD, PRM_CUST_FLG, ROUT_CNST_SEQ" ).append("\n"); 
		query.append("  FROM PRD_PROD_CTL_MST" ).append("\n"); 
		query.append("  WHERE PCTL_NO  = DECODE(SUBSTR(@[new_prd_ctl_no],1,1), 'H', '', @[prd_ctl_no]) -- H로 해야함" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("  SELECT @[prd_ctl_no] PCTL_NO" ).append("\n"); 
		query.append("     , CASE WHEN @[io_bnd_cd] = 'I' THEN NULL" ).append("\n"); 
		query.append("            WHEN @[sr_term] = 'D' THEN (SELECT REP_YD_CD FROM MDM_ZONE WHERE ZN_CD = @[inlnd_rout_org]) " ).append("\n"); 
		query.append("            ELSE (SELECT MTY_PKUP_YD_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(@[inlnd_rout_org], 1,5))" ).append("\n"); 
		query.append("       END MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("     , SUBSTR(DECODE(@[io_bnd_cd], 'O', @[inlnd_rout_org]),1,5) POR_CD       " ).append("\n"); 
		query.append("     , DECODE(@[io_bnd_cd], 'O', @[inlnd_rout_org]) POR_NOD_CD   " ).append("\n"); 
		query.append("     , DECODE(@[io_bnd_cd], 'O', @[inlnd_rout_org]) FULL_RTN_YD_CD" ).append("\n"); 
		query.append("     , DECODE(@[io_bnd_cd], 'O', @[inlnd_rout_org]) FULL_PKUP_YD_CD" ).append("\n"); 
		query.append("     , SUBSTR(DECODE(@[io_bnd_cd], 'O', @[inlnd_rout_dest]),1,5) POL_CD       " ).append("\n"); 
		query.append("     , DECODE(@[io_bnd_cd], 'O', @[inlnd_rout_dest]) POL_NOD_CD   " ).append("\n"); 
		query.append("     , '' N1ST_TS_PORT_CD" ).append("\n"); 
		query.append("     , '' N2ND_TS_PORT_CD" ).append("\n"); 
		query.append("     , '' N3RD_TS_PORT_CD" ).append("\n"); 
		query.append("     , SUBSTR(DECODE(@[io_bnd_cd], 'I',@[inlnd_rout_org]),1,5)  POD_CD       " ).append("\n"); 
		query.append("     , DECODE(@[io_bnd_cd], 'I', @[inlnd_rout_org])  POD_NOD_CD   " ).append("\n"); 
		query.append("     , SUBSTR(DECODE(@[io_bnd_cd], 'I', @[inlnd_rout_dest]),1,5)  DEL_CD       " ).append("\n"); 
		query.append("     , DECODE(@[io_bnd_cd], 'I', @[inlnd_rout_dest])  DEL_NOD_CD   " ).append("\n"); 
		query.append("     , CASE WHEN @[io_bnd_cd] = 'O' THEN NULL" ).append("\n"); 
		query.append("            WHEN @[sd_term] = 'D' THEN (SELECT REP_YD_CD FROM MDM_ZONE WHERE ZN_CD = @[inlnd_rout_dest]) " ).append("\n"); 
		query.append("            ELSE (SELECT EQ_RTN_YD_CD FROM MDM_LOCATION WHERE LOC_CD = SUBSTR(@[inlnd_rout_dest], 1,5))" ).append("\n"); 
		query.append("       END  MTY_RTN_YD_CD" ).append("\n"); 
		query.append("     , 0 TTL_TZTM_HRS " ).append("\n"); 
		query.append("     , 0 TTL_EXPN_AMT " ).append("\n"); 
		query.append("     , NULL TRNK_AVAL_SPC" ).append("\n"); 
		query.append("     , '' OB_ITCHG_CTNT" ).append("\n"); 
		query.append("     , '' IB_ITCHG_CTNT, '' TRNK_VSL_CD, '' TRNK_SKD_VOY_NO, '' TRNK_SKD_DIR_CD, NULL N1ST_VSL_LODG_DUE_DT, NULL MCNTR_DOR_ARR_DUE_DT, '' CNST_FLG, 'F' BKG_CGO_TP_CD, @[sr_term]  BKG_RCV_TERM_CD, @[sd_term] BKG_DE_TERM_CD" ).append("\n"); 
		query.append("     , '' SHPR_CNT_CD, NULL SHPR_SEQ, '' CNEE_CNT_CD, NULL CNEE_SEQ, '' SC_NO, '' RFA_NO, '' REP_CMDT_CD, '' CMDT_CD, '' DG_CLSS_CD, '' DG_SPCL_FLG  " ).append("\n"); 
		query.append("     , '' RF_SPCL_FLG, '' SPCL_AWK_CGO_FLG, '' BB_SPCL_FLG, '' RD_SPCL_FLG, '' HNGR_SPCL_FLG, '' SOC_FLG, '' EQ_SUBST_FLG, NULL BKG_WGT , '' BKG_WGT_UT_CD, '' SLS_OFC_CD   " ).append("\n"); 
		query.append("     , '' BKG_OFC_CD, '' SC_OFC_CD, '' RFA_OFC_CD, '' PRM_CUST_FLG, NULL ROUT_CNST_SEQ" ).append("\n"); 
		query.append("    from dual" ).append("\n"); 
		query.append("    WHERE 1 = DECODE(SUBSTR(@[new_prd_ctl_no],1,1), 'H', 1, 2)) O  -- H로 해야함" ).append("\n"); 
		query.append("WHERE O.PCTL_NO =@[prd_ctl_no]" ).append("\n"); 
		query.append("AND N.CHK =1" ).append("\n"); 

	}
}