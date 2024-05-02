/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SupplementSOManageDBDAOInsertSOMstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.08
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.07.08 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SupplementSOManageDBDAOInsertSOMstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 새로운 SO를 생성
	  * </pre>
	  */
	public SupplementSOManageDBDAOInsertSOMstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnt_trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_spl_so_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnt_trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc_add_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nego_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fuel_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spl_iss_rsn",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.integration").append("\n"); 
		query.append("FileName : SupplementSOManageDBDAOInsertSOMstCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_SVC_ORD " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("    PRNT_TRSP_SO_OFC_CTY_CD, " ).append("\n"); 
		query.append("    PRNT_TRSP_SO_SEQ, " ).append("\n"); 
		query.append("    EQ_KND_CD, " ).append("\n"); 
		query.append("    EQ_TPSZ_CD, " ).append("\n"); 
		query.append("    EQ_NO, " ).append("\n"); 
		query.append("    TRSP_BND_CD, " ).append("\n"); 
		query.append("    VNDR_SEQ, " ).append("\n"); 
		query.append("    TRSP_COST_DTL_MOD_CD, " ).append("\n"); 
		query.append("    TRSP_CRR_MOD_CD, " ).append("\n"); 
		query.append("    CGO_TP_CD, " ).append("\n"); 
		query.append("    CMDT_CD, " ).append("\n"); 
		query.append("    CNTR_WGT, " ).append("\n"); 
		query.append("    WGT_MEAS_UT_CD, " ).append("\n"); 
		query.append("    FM_NOD_CD, " ).append("\n"); 
		query.append("    TO_NOD_CD, " ).append("\n"); 
		query.append("    VIA_NOD_CD, " ).append("\n"); 
		query.append("    DOR_NOD_CD, " ).append("\n"); 
		query.append("    VSL_CD, " ).append("\n"); 
		query.append("    SKD_VOY_NO, " ).append("\n"); 
		query.append("    SKD_DIR_CD, " ).append("\n"); 
		query.append("    SLAN_CD, " ).append("\n"); 
		query.append("    FDR_VSL_CD, " ).append("\n"); 
		query.append("    FDR_SKD_VOY_NO, " ).append("\n"); 
		query.append("    FDR_SKD_DIR_CD, " ).append("\n"); 
		query.append("    ORG_BKG_NO, " ).append("\n"); 
		query.append("    BKG_NO, " ).append("\n"); 
		query.append("    BL_NO, " ).append("\n"); 
		query.append("    DOR_SVC_TP_CD, " ).append("\n"); 
		query.append("    DOR_DE_ADDR, " ).append("\n"); 
		query.append("    DTN_USE_FLG, " ).append("\n"); 
		query.append("    MLT_STOP_DE_FLG, " ).append("\n"); 
		query.append("    TRSP_PURP_RSN, " ).append("\n"); 
		query.append("    CMB_SO_RLT_STS_FLG, " ).append("\n"); 
		query.append("    TRSP_SO_CMB_TP_CD, " ).append("\n"); 
		query.append("    TRSP_SO_CMB_SEQ," ).append("\n"); 
		query.append("    CHSS_MGST_TRSP_TP_CD, " ).append("\n"); 
		query.append("    SPCL_INSTR_RMK, " ).append("\n"); 
		query.append("    INTER_RMK, " ).append("\n"); 
		query.append("    FCTRY_NM, " ).append("\n"); 
		query.append("    COP_NO, " ).append("\n"); 
		query.append("    COST_ACT_GRP_SEQ,  " ).append("\n"); 
		query.append("    TRSP_SO_OFC_CTY_CD, " ).append("\n"); 
		query.append("    TRSP_SO_SEQ, " ).append("\n"); 
		query.append("    TRSP_SO_TP_CD, " ).append("\n"); 
		query.append("    TRSP_SPL_SO_TP_CD, " ).append("\n"); 
		query.append("    TRSP_SO_STS_CD, " ).append("\n"); 
		query.append("    TRSP_AGMT_OFC_CTY_CD, " ).append("\n"); 
		query.append("    TRSP_AGMT_SEQ, " ).append("\n"); 
		query.append("    CUST_NOMI_TRKR_FLG, " ).append("\n"); 
		query.append("    CUST_CNT_CD, " ).append("\n"); 
		query.append("    CUST_SEQ, " ).append("\n"); 
		query.append("    TRSP_AGMT_WY_TP_CD, " ).append("\n"); 
		query.append("    TRSP_AGMT_RT_TP_CD, " ).append("\n"); 
		query.append("    CURR_CD, " ).append("\n"); 
		query.append("    BZC_AMT, " ).append("\n"); 
		query.append("    NEGO_AMT," ).append("\n"); 
		query.append("    FUEL_SCG_AMT, " ).append("\n"); 
		query.append("    ETC_ADD_AMT, " ).append("\n"); 
		query.append("    SPL_ISS_RSN, " ).append("\n"); 
		query.append("    LGS_COST_CD, " ).append("\n"); 
		query.append("    ACCT_CD, " ).append("\n"); 
		query.append("    DELT_FLG, " ).append("\n"); 
		query.append("    CRE_OFC_CD, " ).append("\n"); 
		query.append("    CRE_USR_ID, " ).append("\n"); 
		query.append("    CRE_DT, " ).append("\n"); 
		query.append("    UPD_USR_ID, " ).append("\n"); 
		query.append("    UPD_DT, " ).append("\n"); 
		query.append("    CNTR_KGS_WGT, " ).append("\n"); 
		query.append("    CNTR_LBS_WGT, " ).append("\n"); 
		query.append("	LOCL_CRE_DT, " ).append("\n"); 
		query.append("	LOCL_UPD_DT," ).append("\n"); 
		query.append("	EQ_ATCH_DT," ).append("\n"); 
		query.append("	CONTI_CD," ).append("\n"); 
		query.append("    SCG_IND_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  X.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("  X.TRSP_SO_SEQ," ).append("\n"); 
		query.append("  X.EQ_KND_CD," ).append("\n"); 
		query.append("  X.EQ_TPSZ_CD," ).append("\n"); 
		query.append("  X.EQ_NO," ).append("\n"); 
		query.append("  X.TRSP_BND_CD," ).append("\n"); 
		query.append("  X.VNDR_SEQ," ).append("\n"); 
		query.append("  X.TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("  X.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("  X.CGO_TP_CD," ).append("\n"); 
		query.append("  X.CMDT_CD," ).append("\n"); 
		query.append("  X.CNTR_WGT," ).append("\n"); 
		query.append("  X.WGT_MEAS_UT_CD," ).append("\n"); 
		query.append("  X.FM_NOD_CD," ).append("\n"); 
		query.append("  X.TO_NOD_CD," ).append("\n"); 
		query.append("  X.VIA_NOD_CD," ).append("\n"); 
		query.append("  X.DOR_NOD_CD," ).append("\n"); 
		query.append("  X.VSL_CD," ).append("\n"); 
		query.append("  X.SKD_VOY_NO," ).append("\n"); 
		query.append("  X.SKD_DIR_CD," ).append("\n"); 
		query.append("  X.SLAN_CD," ).append("\n"); 
		query.append("  X.FDR_VSL_CD," ).append("\n"); 
		query.append("  X.FDR_SKD_VOY_NO," ).append("\n"); 
		query.append("  X.FDR_SKD_DIR_CD," ).append("\n"); 
		query.append("  X.ORG_BKG_NO," ).append("\n"); 
		query.append("  X.BKG_NO," ).append("\n"); 
		query.append("  X.BL_NO," ).append("\n"); 
		query.append("  X.DOR_SVC_TP_CD," ).append("\n"); 
		query.append("  X.DOR_DE_ADDR," ).append("\n"); 
		query.append("  X.DTN_USE_FLG," ).append("\n"); 
		query.append("  X.MLT_STOP_DE_FLG," ).append("\n"); 
		query.append("  X.TRSP_PURP_RSN," ).append("\n"); 
		query.append("  X.CMB_SO_RLT_STS_FLG," ).append("\n"); 
		query.append("  X.TRSP_SO_CMB_TP_CD, " ).append("\n"); 
		query.append("  DECODE(X.TRSP_SO_CMB_TP_CD, 'BD', X.TRSP_SO_CMB_SEQ, NULL)," ).append("\n"); 
		query.append("  X.CHSS_MGST_TRSP_TP_CD," ).append("\n"); 
		query.append("  X.SPCL_INSTR_RMK," ).append("\n"); 
		query.append("  X.INTER_RMK," ).append("\n"); 
		query.append("  X.FCTRY_NM," ).append("\n"); 
		query.append("  X.COP_NO," ).append("\n"); 
		query.append("  X.COST_ACT_GRP_SEQ, " ).append("\n"); 
		query.append("  X.TRSP_SO_OFC_CTY_CD, 								" ).append("\n"); 
		query.append("  @[trsp_so_seq],        								" ).append("\n"); 
		query.append("  'S',                  								" ).append("\n"); 
		query.append("  @[trsp_spl_so_tp_cd], 								" ).append("\n"); 
		query.append("  'C', 													" ).append("\n"); 
		query.append("  @[trsp_agmt_ofc_cty_cd], 								" ).append("\n"); 
		query.append("  @[trsp_agmt_seq], 									" ).append("\n"); 
		query.append("  X.CUST_NOMI_TRKR_FLG, 								" ).append("\n"); 
		query.append("  X.CUST_CNT_CD, 										" ).append("\n"); 
		query.append("  X.CUST_SEQ, 											" ).append("\n"); 
		query.append("  '', 													" ).append("\n"); 
		query.append("  '', 													" ).append("\n"); 
		query.append("  @[curr_cd], 											" ).append("\n"); 
		query.append("  @[bzc_amt], 											" ).append("\n"); 
		query.append("  @[nego_amt], 											" ).append("\n"); 
		query.append("  @[fuel_scg_amt], 										" ).append("\n"); 
		query.append("  @[etc_add_amt], 										" ).append("\n"); 
		query.append("  @[spl_iss_rsn], 										" ).append("\n"); 
		query.append("  X.LGS_COST_CD," ).append("\n"); 
		query.append("  X.ACCT_CD," ).append("\n"); 
		query.append("  'N', 													" ).append("\n"); 
		query.append("  @[cre_ofc_cd], 										" ).append("\n"); 
		query.append("  @[cre_usr_id], 										" ).append("\n"); 
		query.append("  SYSDATE, 	 											" ).append("\n"); 
		query.append("  @[upd_usr_id], 										" ).append("\n"); 
		query.append("  SYSDATE, 												" ).append("\n"); 
		query.append("  X.CNTR_KGS_WGT, 										" ).append("\n"); 
		query.append("  X.CNTR_LBS_WGT, 										" ).append("\n"); 
		query.append("  GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), 	" ).append("\n"); 
		query.append("  GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])," ).append("\n"); 
		query.append("  NVL2(X.EQ_NO, SYSDATE, NULL) EQ_ATCH_DT," ).append("\n"); 
		query.append("  X.CONTI_CD," ).append("\n"); 
		query.append("  @[scg_ind_cd]" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD X" ).append("\n"); 
		query.append("WHERE X.TRSP_SO_OFC_CTY_CD = @[prnt_trsp_so_ofc_cty_cd] " ).append("\n"); 
		query.append("  	AND X.TRSP_SO_SEQ = @[prnt_trsp_so_seq]" ).append("\n"); 

	}
}