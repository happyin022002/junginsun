/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOCreateProductCatalogForEurDrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 조용인
*@LastVersion : 1.0
* 2010.03.19 조용인
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author cho yong in
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOCreateProductCatalogForEurDrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 유럽지역 tro 재반영을 위한 prd 생성
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOCreateProductCatalogForEurDrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obPctlNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibPctlNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocnPctlNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("newPctlNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration ").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOCreateProductCatalogForEurDrCSQL").append("\n"); 
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
		query.append("INTO PRD_PROD_CTL_MST" ).append("\n"); 
		query.append("(PCTL_NO,MTY_PKUP_YD_CD,POR_CD,POR_NOD_CD,FULL_RTN_YD_CD,POL_CD,POL_NOD_CD,OB_ITCHG_CTNT,MCNTR_DOR_ARR_DUE_DT,BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("N1ST_TS_PORT_CD,N2ND_TS_PORT_CD,N3RD_TS_PORT_CD,TRNK_AVAL_SPC,TRNK_VSL_CD,TRNK_SKD_VOY_NO,TRNK_SKD_DIR_CD,N1ST_VSL_LODG_DUE_DT," ).append("\n"); 
		query.append("BKG_CGO_TP_CD,SHPR_CNT_CD,SHPR_SEQ,CNEE_CNT_CD,CNEE_SEQ,SC_NO,RFA_NO,REP_CMDT_CD,CMDT_CD,DG_CLSS_CD," ).append("\n"); 
		query.append("DG_SPCL_FLG,RF_SPCL_FLG,SPCL_AWK_CGO_FLG,BB_SPCL_FLG,RD_SPCL_FLG,HNGR_SPCL_FLG,SOC_FLG,EQ_SUBST_FLG,BKG_WGT,BKG_WGT_UT_CD," ).append("\n"); 
		query.append("SLS_OFC_CD,BKG_OFC_CD,SC_OFC_CD,RFA_OFC_CD,PRM_CUST_FLG," ).append("\n"); 
		query.append("POD_CD,FULL_PKUP_YD_CD,POD_NOD_CD,DEL_CD,DEL_NOD_CD,MTY_RTN_YD_CD,IB_ITCHG_CTNT,BKG_DE_TERM_CD," ).append("\n"); 
		query.append("TTL_TZTM_HRS, TTL_EXPN_AMT,CNST_FLG, ROUT_CNST_SEQ," ).append("\n"); 
		query.append("CRE_USR_ID, CRE_DT,UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(PCTL_NO,MTY_PKUP_YD_CD,POR_CD,POR_NOD_CD,FULL_RTN_YD_CD,POL_CD,POL_NOD_CD,OB_ITCHG_CTNT,MCNTR_DOR_ARR_DUE_DT,BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("N1ST_TS_PORT_CD,N2ND_TS_PORT_CD,N3RD_TS_PORT_CD,TRNK_AVAL_SPC,TRNK_VSL_CD,TRNK_SKD_VOY_NO,TRNK_SKD_DIR_CD,N1ST_VSL_LODG_DUE_DT," ).append("\n"); 
		query.append("BKG_CGO_TP_CD,SHPR_CNT_CD,SHPR_SEQ,CNEE_CNT_CD,CNEE_SEQ,SC_NO,RFA_NO,REP_CMDT_CD,CMDT_CD,DG_CLSS_CD," ).append("\n"); 
		query.append("DG_SPCL_FLG,RF_SPCL_FLG,SPCL_AWK_CGO_FLG,BB_SPCL_FLG,RD_SPCL_FLG,HNGR_SPCL_FLG,SOC_FLG,EQ_SUBST_FLG,BKG_WGT,BKG_WGT_UT_CD," ).append("\n"); 
		query.append("SLS_OFC_CD,BKG_OFC_CD,SC_OFC_CD,RFA_OFC_CD,PRM_CUST_FLG," ).append("\n"); 
		query.append("POD_CD,FULL_PKUP_YD_CD,POD_NOD_CD,DEL_CD,DEL_NOD_CD,MTY_RTN_YD_CD,IB_ITCHG_CTNT,BKG_DE_TERM_CD," ).append("\n"); 
		query.append("TTL_TZTM_HRS, TTL_EXPN_AMT,MCNST_FLG, ROUT_CNST_SEQ," ).append("\n"); 
		query.append("'System', SYSDATE,'System', SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN PCTL_SEQ > 0 THEN" ).append("\n"); 
		query.append("INTO PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("( PCTL_NO, PCTL_SEQ, ORG_NOD_CD, DEST_NOD_CD, NOD_LNK_DIV_CD, PCTL_IO_BND_CD, TRSP_MOD_CD," ).append("\n"); 
		query.append("PCTL_WTR_DIV_CD, ORG_NOD_TP_CD, DEST_NOD_TP_CD, MTY_YD_FLG, ARR_ST_DT, DEP_FSH_DT, TZ_DWLL_TM_HRS," ).append("\n"); 
		query.append("N1ST_VNDR_SEQ,N2ND_VNDR_SEQ, N3RD_VNDR_SEQ, VSL_SLAN_CD, CRR_CD, VSL_CD, SKD_VOY_NO," ).append("\n"); 
		query.append("INLND_ROUT_CMB_FLG, INLND_ROUT_INV_BIL_PATT_CD, SKD_DIR_CD, ROUT_ORG_NOD_CD,  ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("ROUT_SEQ, ORG_CLPT_IND_SEQ,DEST_CLPT_IND_SEQ," ).append("\n"); 
		query.append("RAIL_CRR_TP_CD,INLND_ROUT_INCL_STTL_FLG,TRSP_AGMT_OFC_CTY_CD,TRSP_AGMT_SEQ,AGMT_REF_NO," ).append("\n"); 
		query.append("CRE_USR_ID, CRE_DT,UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(PCTL_NO,PCTL_SEQ,ORG_NOD_CD,DEST_NOD_CD,NOD_LNK_DIV_CD,PCTL_IO_BND_CD,TRSP_MOD_CD," ).append("\n"); 
		query.append("PCTL_WTR_DIV_CD,ORG_NOD_TP_CD,DEST_NOD_TP_CD,MTY_YD_FLG,ARR_ST_DT,DEP_FSH_DT,TZ_DWLL_TM_HRS," ).append("\n"); 
		query.append("N1ST_VNDR_SEQ,N2ND_VNDR_SEQ,N3RD_VNDR_SEQ,VSL_SLAN_CD,CRR_CD,VSL_CD,SKD_VOY_NO," ).append("\n"); 
		query.append("INLND_ROUT_CMB_FLG,INLND_ROUT_INV_BIL_PATT_CD,SKD_DIR_CD,ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("ROUT_SEQ,ORG_CLPT_IND_SEQ,DEST_CLPT_IND_SEQ," ).append("\n"); 
		query.append("RAIL_CRR_TP_CD,INLND_ROUT_INCL_STTL_FLG,TRSP_AGMT_OFC_CTY_CD,TRSP_AGMT_SEQ,AGMT_REF_NO," ).append("\n"); 
		query.append("'System', SYSDATE,'System', SYSDATE)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("O.MTY_PKUP_YD_CD,O.POR_CD,O.POR_NOD_CD,O.FULL_RTN_YD_CD,O.POL_CD,O.POL_NOD_CD,O.OB_ITCHG_CTNT,O.MCNTR_DOR_ARR_DUE_DT,O.BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("OCN.N1ST_TS_PORT_CD,OCN.N2ND_TS_PORT_CD,OCN.N3RD_TS_PORT_CD,OCN.TRNK_AVAL_SPC,OCN.TRNK_VSL_CD,OCN.TRNK_SKD_VOY_NO,OCN.TRNK_SKD_DIR_CD,OCN.N1ST_VSL_LODG_DUE_DT," ).append("\n"); 
		query.append("OCN.BKG_CGO_TP_CD,OCN.SHPR_CNT_CD,OCN.SHPR_SEQ,OCN.CNEE_CNT_CD,OCN.CNEE_SEQ,OCN.SC_NO,OCN.RFA_NO,OCN.REP_CMDT_CD,OCN.CMDT_CD,OCN.DG_CLSS_CD," ).append("\n"); 
		query.append("OCN.DG_SPCL_FLG,OCN.RF_SPCL_FLG,OCN.SPCL_AWK_CGO_FLG,OCN.BB_SPCL_FLG,OCN.RD_SPCL_FLG,OCN.HNGR_SPCL_FLG,OCN.SOC_FLG,OCN.EQ_SUBST_FLG,OCN.BKG_WGT,OCN.BKG_WGT_UT_CD," ).append("\n"); 
		query.append("OCN.SLS_OFC_CD,OCN.BKG_OFC_CD,OCN.SC_OFC_CD,OCN.RFA_OFC_CD,OCN.PRM_CUST_FLG," ).append("\n"); 
		query.append("I.POD_CD,I.FULL_PKUP_YD_CD,I.POD_NOD_CD,I.DEL_CD,I.DEL_NOD_CD,I.MTY_RTN_YD_CD,I.IB_ITCHG_CTNT,I.BKG_DE_TERM_CD," ).append("\n"); 
		query.append("GREATEST(O.TTL_TZTM_HRS,I.TTL_TZTM_HRS,OCN.TTL_TZTM_HRS) TTL_TZTM_HRS," ).append("\n"); 
		query.append("GREATEST(O.TTL_EXPN_AMT,I.TTL_EXPN_AMT,OCN.TTL_EXPN_AMT) TTL_EXPN_AMT," ).append("\n"); 
		query.append("GREATEST(O.CNST_FLG,I.CNST_FLG,OCN.CNST_FLG) MCNST_FLG, GREATEST(O.ROUT_CNST_SEQ,I.ROUT_CNST_SEQ,OCN.ROUT_CNST_SEQ) ROUT_CNST_SEQ," ).append("\n"); 
		query.append("N.PCTL_NO,ROW_NUMBER() OVER (ORDER BY BND_ORD,PCTL_SEQ) PCTL_SEQ," ).append("\n"); 
		query.append("N.ORG_NOD_CD,N.DEST_NOD_CD,N.NOD_LNK_DIV_CD,N.PCTL_IO_BND_CD,N.TRSP_MOD_CD,N.PCTL_WTR_DIV_CD,N.ORG_NOD_TP_CD,N.DEST_NOD_TP_CD,N.MTY_YD_FLG,N.ARR_ST_DT,N.DEP_FSH_DT," ).append("\n"); 
		query.append("N.TZ_DWLL_TM_HRS,N.N1ST_VNDR_SEQ,N.N2ND_VNDR_SEQ,N.N3RD_VNDR_SEQ,N.VSL_SLAN_CD,N.CRR_CD,N.VSL_CD,N.SKD_VOY_NO,N.SKD_DIR_CD,N.GEN_AVAL_SPC,N.D7_AVAL_SPC,N.RF_AVAL_SPC," ).append("\n"); 
		query.append("N.INLND_ROUT_INV_BIL_PATT_CD,N.INLND_ROUT_CMB_FLG,N.ROUT_ORG_NOD_CD,N.ROUT_DEST_NOD_CD,N.ROUT_SEQ,N.CNST_FLG,N.ORG_CLPT_IND_SEQ,N.DEST_CLPT_IND_SEQ," ).append("\n"); 
		query.append("N.RAIL_CRR_TP_CD,N.INLND_ROUT_INCL_STTL_FLG,N.TRSP_AGMT_OFC_CTY_CD,N.TRSP_AGMT_SEQ,N.AGMT_REF_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT @[newPctlNo]||'0001' PCTL_NO,1 BND_ORD,PCTL_SEQ," ).append("\n"); 
		query.append("ORG_NOD_CD,DEST_NOD_CD,NOD_LNK_DIV_CD,PCTL_IO_BND_CD,TRSP_MOD_CD,PCTL_WTR_DIV_CD,ORG_NOD_TP_CD,DEST_NOD_TP_CD,MTY_YD_FLG,ARR_ST_DT,DEP_FSH_DT," ).append("\n"); 
		query.append("TZ_DWLL_TM_HRS,N1ST_VNDR_SEQ,N2ND_VNDR_SEQ,N3RD_VNDR_SEQ,VSL_SLAN_CD,CRR_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,GEN_AVAL_SPC,D7_AVAL_SPC,RF_AVAL_SPC," ).append("\n"); 
		query.append("INLND_ROUT_INV_BIL_PATT_CD,INLND_ROUT_CMB_FLG,ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ,CNST_FLG,ORG_CLPT_IND_SEQ,DEST_CLPT_IND_SEQ," ).append("\n"); 
		query.append("RAIL_CRR_TP_CD,INLND_ROUT_INCL_STTL_FLG,TRSP_AGMT_OFC_CTY_CD,TRSP_AGMT_SEQ,AGMT_REF_NO,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO = @[obPctlNo]" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='O'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT @[newPctlNo]||'0001' PCTL_NO,2 BND_ORD,PCTL_SEQ," ).append("\n"); 
		query.append("ORG_NOD_CD,DEST_NOD_CD,NOD_LNK_DIV_CD,PCTL_IO_BND_CD,TRSP_MOD_CD,PCTL_WTR_DIV_CD,ORG_NOD_TP_CD,DEST_NOD_TP_CD,MTY_YD_FLG,ARR_ST_DT,DEP_FSH_DT," ).append("\n"); 
		query.append("TZ_DWLL_TM_HRS,N1ST_VNDR_SEQ,N2ND_VNDR_SEQ,N3RD_VNDR_SEQ,VSL_SLAN_CD,CRR_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,GEN_AVAL_SPC,D7_AVAL_SPC,RF_AVAL_SPC," ).append("\n"); 
		query.append("INLND_ROUT_INV_BIL_PATT_CD,INLND_ROUT_CMB_FLG,ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ,CNST_FLG,ORG_CLPT_IND_SEQ,DEST_CLPT_IND_SEQ," ).append("\n"); 
		query.append("RAIL_CRR_TP_CD,INLND_ROUT_INCL_STTL_FLG,TRSP_AGMT_OFC_CTY_CD,TRSP_AGMT_SEQ,AGMT_REF_NO,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO = @[ocnPctlNo]" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT @[newPctlNo]||'0001' PCTL_NO,3 BND_ORD,PCTL_SEQ," ).append("\n"); 
		query.append("ORG_NOD_CD,DEST_NOD_CD,NOD_LNK_DIV_CD,PCTL_IO_BND_CD,TRSP_MOD_CD,PCTL_WTR_DIV_CD,ORG_NOD_TP_CD,DEST_NOD_TP_CD,MTY_YD_FLG,ARR_ST_DT,DEP_FSH_DT," ).append("\n"); 
		query.append("TZ_DWLL_TM_HRS,N1ST_VNDR_SEQ,N2ND_VNDR_SEQ,N3RD_VNDR_SEQ,VSL_SLAN_CD,CRR_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD,GEN_AVAL_SPC,D7_AVAL_SPC,RF_AVAL_SPC," ).append("\n"); 
		query.append("INLND_ROUT_INV_BIL_PATT_CD,INLND_ROUT_CMB_FLG,ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ,CNST_FLG,ORG_CLPT_IND_SEQ,DEST_CLPT_IND_SEQ," ).append("\n"); 
		query.append("RAIL_CRR_TP_CD,INLND_ROUT_INCL_STTL_FLG,TRSP_AGMT_OFC_CTY_CD,TRSP_AGMT_SEQ,AGMT_REF_NO,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO = @[ibPctlNo]" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='I'" ).append("\n"); 
		query.append(") N, PRD_PROD_CTL_MST O, PRD_PROD_CTL_MST OCN, PRD_PROD_CTL_MST I" ).append("\n"); 
		query.append("WHERE O.PCTL_NO =@[obPctlNo]" ).append("\n"); 
		query.append("AND OCN.PCTL_NO =@[ocnPctlNo]" ).append("\n"); 
		query.append("AND I.PCTL_NO =@[ibPctlNo]" ).append("\n"); 

	}
}