/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceProcessingAuditManageDBDAOSearchAuditStorageInvoiceCalculationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.invoiceprocessingauditmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceProcessingAuditManageDBDAOSearchAuditStorageInvoiceCalculationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Processing Audit Manage
	  * AuditStorageInvoiceCalculationList 조회
	  * </pre>
	  */
	public InvoiceProcessingAuditManageDBDAOSearchAuditStorageInvoiceCalculationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_inv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_cost_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.invoiceprocessingauditmanage.integration").append("\n"); 
		query.append("FileName : InvoiceProcessingAuditManageDBDAOSearchAuditStorageInvoiceCalculationListRSQL").append("\n"); 
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
		query.append("#if (${bkg_no} != '' or ${cntr_no} != '' ) " ).append("\n"); 
		query.append("SELECT	A.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		, A.TML_SO_SEQ" ).append("\n"); 
		query.append("		, A.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("		, A.INV_OFC_CD" ).append("\n"); 
		query.append("		, A.COST_OFC_CD" ).append("\n"); 
		query.append("		, A.INV_NO" ).append("\n"); 
		query.append("		, A.VNDR_SEQ" ).append("\n"); 
		query.append("		, A.YD_CD" ).append("\n"); 
		query.append("		, A.CALC_COST_GRP_CD" ).append("\n"); 
		query.append("		, A.CALC_TP_CD" ).append("\n"); 
		query.append("		, A.VSL_CD" ).append("\n"); 
		query.append("		, A.SKD_VOY_NO" ).append("\n"); 
		query.append("		, A.SKD_DIR_CD" ).append("\n"); 
		query.append("		, A.FINC_VSL_CD" ).append("\n"); 
		query.append("		, A.FINC_SKD_VOY_NO" ).append("\n"); 
		query.append("		, A.FINC_SKD_DIR_CD" ).append("\n"); 
		query.append("		, A.IOC_CD" ).append("\n"); 
		query.append("		, A.LANE_CD" ).append("\n"); 
		query.append("		, A.IO_BND_CD" ).append("\n"); 
		query.append("		, A.LGS_COST_CD" ).append("\n"); 
		query.append("		, A.LGS_COST_CD2" ).append("\n"); 
		query.append("		, A.ACCT_CD" ).append("\n"); 
		query.append("		, A.ATB_DT" ).append("\n"); 
		query.append("		, A.CNTR_NO" ).append("\n"); 
		query.append("		, A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, A.CALC_VOL_QTY" ).append("\n"); 
		query.append("		, A.FM_TR_VOL_VAL" ).append("\n"); 
		query.append("		, A.TO_TR_VOL_VAL" ).append("\n"); 
		query.append("		, A.RVIS_VOL_QTY" ).append("\n"); 
		query.append("		, A.DCGO_IND_CD" ).append("\n"); 
		query.append("		, A.STAY_DYS" ).append("\n"); 
		query.append("		, A.FREE_DYS" ).append("\n"); 
		query.append("		, A.PAY_DYS" ).append("\n"); 
		query.append("		, A.FREE_DY_XCLD_DYS" ).append("\n"); 
		query.append("		, A.OVR_DYS" ).append("\n"); 
		query.append("		, A.OVR_DYS2" ).append("\n"); 
		query.append("		, A.TML_WRK_DY_CD" ).append("\n"); 
		query.append("		, A.WRK_DT" ).append("\n"); 
		query.append("		, A.STK_VOL_QTY" ).append("\n"); 
		query.append("		, A.FP_TEU_QTY" ).append("\n"); 
		query.append("		, A.INV_VOL_QTY" ).append("\n"); 
		query.append("		, A.DIFF_VOL_QTY" ).append("\n"); 
		query.append("		, A.OVR_VOL_QTY" ).append("\n"); 
		query.append("		, A.VOL_TR_UT_CD" ).append("\n"); 
		query.append("		, A.CTRT_RT" ).append("\n"); 
		query.append("		, A.REF_VNDR_SEQ" ).append("\n"); 
		query.append("		, A.CALC_AMT" ).append("\n"); 
		query.append("		, A.INV_AMT" ).append("\n"); 
		query.append("		, A.TML_CRR_CD" ).append("\n"); 
		query.append("		, A.CALC_RMK" ).append("\n"); 
		query.append("		, A.N3PTY_FLG" ).append("\n"); 
		query.append("		, A.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		, A.TML_AGMT_SEQ" ).append("\n"); 
		query.append("		, A.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("		, A.CURR_CD" ).append("\n"); 
		query.append("		, A.INV_XCH_RT" ).append("\n"); 
		query.append("		, A.REV_YRMON" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		SELECT	  H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				, H.TML_SO_SEQ" ).append("\n"); 
		query.append("				, H.INV_OFC_CD" ).append("\n"); 
		query.append("				, H.COST_OFC_CD" ).append("\n"); 
		query.append("				, H.INV_NO" ).append("\n"); 
		query.append("				, H.VNDR_SEQ" ).append("\n"); 
		query.append("				, H.YD_CD" ).append("\n"); 
		query.append("				, D.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("				, D.CALC_COST_GRP_CD" ).append("\n"); 
		query.append("				, D.CALC_TP_CD" ).append("\n"); 
		query.append("				, D.VSL_CD" ).append("\n"); 
		query.append("				, D.SKD_VOY_NO" ).append("\n"); 
		query.append("				, D.SKD_DIR_CD" ).append("\n"); 
		query.append("				, D.FINC_VSL_CD" ).append("\n"); 
		query.append("				, D.FINC_SKD_VOY_NO" ).append("\n"); 
		query.append("				, D.FINC_SKD_DIR_CD" ).append("\n"); 
		query.append("				, D.IOC_CD" ).append("\n"); 
		query.append("				, D.LANE_CD" ).append("\n"); 
		query.append("				, D.IO_BND_CD" ).append("\n"); 
		query.append("				, D.LGS_COST_CD" ).append("\n"); 
		query.append("				, D.LGS_COST_CD AS LGS_COST_CD2" ).append("\n"); 
		query.append("				, D.ACCT_CD" ).append("\n"); 
		query.append("				, D.ATB_DT" ).append("\n"); 
		query.append("				, D.CNTR_NO" ).append("\n"); 
		query.append("				, D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				, D.CALC_VOL_QTY" ).append("\n"); 
		query.append("				, D.FM_TR_VOL_VAL" ).append("\n"); 
		query.append("				, D.TO_TR_VOL_VAL" ).append("\n"); 
		query.append("				, D.RVIS_VOL_QTY" ).append("\n"); 
		query.append("				, D.DCGO_IND_CD" ).append("\n"); 
		query.append("				, D.STAY_DYS" ).append("\n"); 
		query.append("				, D.FREE_DYS" ).append("\n"); 
		query.append("				, D.PAY_DYS" ).append("\n"); 
		query.append("				, D.FREE_DY_XCLD_DYS" ).append("\n"); 
		query.append("				, D.OVR_DYS" ).append("\n"); 
		query.append("				, D.OVR_DYS AS OVR_DYS2" ).append("\n"); 
		query.append("				, D.TML_WRK_DY_CD" ).append("\n"); 
		query.append("				, D.WRK_DT" ).append("\n"); 
		query.append("				, D.STK_VOL_QTY" ).append("\n"); 
		query.append("				, D.FP_TEU_QTY" ).append("\n"); 
		query.append("				, D.INV_VOL_QTY" ).append("\n"); 
		query.append("				, D.DIFF_VOL_QTY" ).append("\n"); 
		query.append("				, D.OVR_VOL_QTY" ).append("\n"); 
		query.append("				, D.VOL_TR_UT_CD" ).append("\n"); 
		query.append("				, D.CTRT_RT" ).append("\n"); 
		query.append("				, D.REF_VNDR_SEQ" ).append("\n"); 
		query.append("				, SUM(D.CALC_AMT) AS CALC_AMT" ).append("\n"); 
		query.append("				, SUM(D.INV_AMT) AS INV_AMT" ).append("\n"); 
		query.append("				, D.TML_CRR_CD" ).append("\n"); 
		query.append("				, D.CALC_RMK" ).append("\n"); 
		query.append("				, D.N3PTY_FLG" ).append("\n"); 
		query.append("				, D.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("				, D.TML_AGMT_SEQ" ).append("\n"); 
		query.append("				, D.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("				, DECODE(NVL(D.CURR_CD, 'N'), 'N', H.CURR_CD, D.CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("				, D.INV_XCH_RT" ).append("\n"); 
		query.append("				, D.REV_YRMON" ).append("\n"); 
		query.append("		FROM	TES_TML_SO_HDR H" ).append("\n"); 
		query.append("				, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("				, TES_LGS_COST LC" ).append("\n"); 
		query.append("				, TES_TML_SO_COST SC" ).append("\n"); 
		query.append("		WHERE	H.TML_SO_OFC_CTY_CD	= D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		AND		H.TML_SO_SEQ		= D.TML_SO_SEQ" ).append("\n"); 
		query.append("		AND		D.LGS_COST_CD		= LC.LGS_COST_CD" ).append("\n"); 
		query.append("		AND		D.LGS_COST_CD		= SC.LGS_COST_CD" ).append("\n"); 
		query.append("		AND		NVL(H.DELT_FLG, 'N')<> 'Y'" ).append("\n"); 
		query.append("		AND		H.TML_INV_STS_CD	<> 'R'" ).append("\n"); 
		query.append("		AND		H.TML_INV_RJCT_STS_CD	<> 'RJ'" ).append("\n"); 
		query.append("		AND		H.TML_INV_TP_CD		= @[tml_inv_tp_cd]" ).append("\n"); 
		query.append("		AND		D.CALC_COST_GRP_CD	= @[calc_cost_grp_cd]" ).append("\n"); 
		query.append("		#if (${yd_cd} != '') " ).append("\n"); 
		query.append("		AND		H.YD_CD				= @[yd_cd]" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("		AND		H.VNDR_SEQ			= @[vndr_seq]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${cost_ofc_cd} != '')" ).append("\n"); 
		query.append("			#if($sub_ofc_cd1.size() > 0)" ).append("\n"); 
		query.append("				AND     H.COST_OFC_CD IN (" ).append("\n"); 
		query.append("				#foreach($sub_ofc_cd1_num IN ${sub_ofc_cd1})" ).append("\n"); 
		query.append("					#if($velocityCount < $sub_ofc_cd1.size()) " ).append("\n"); 
		query.append("						'$sub_ofc_cd1_num', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						'$sub_ofc_cd1_num' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND		H.COST_OFC_CD = @[cost_ofc_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${inv_ofc_cd} != '')" ).append("\n"); 
		query.append("			#if($sub_ofc_cd2.size() > 0)" ).append("\n"); 
		query.append("				AND     H.INV_OFC_CD IN (" ).append("\n"); 
		query.append("				#foreach($sub_ofc_cd2_num IN ${sub_ofc_cd2})" ).append("\n"); 
		query.append("					#if($velocityCount < $sub_ofc_cd2.size()) " ).append("\n"); 
		query.append("						'$sub_ofc_cd2_num', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						'$sub_ofc_cd2_num' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND		H.INV_OFC_CD = @[inv_ofc_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${tml_inv_sts_cd} != '' )" ).append("\n"); 
		query.append("		AND		H.TML_INV_STS_CD	= @[tml_inv_sts_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${inv_date_type} == 'I') " ).append("\n"); 
		query.append("		AND		H.ISS_DT BETWEEN TO_DATE(REPLACE(@[fm_prd_dt], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt], '-'), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("		#elseif (${inv_date_type} == 'R') " ).append("\n"); 
		query.append("		AND		H.RCV_DT BETWEEN TO_DATE(REPLACE(@[fm_prd_dt], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt], '-'), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("		#elseif (${inv_date_type} == 'P') " ).append("\n"); 
		query.append("		AND		H.LOCL_UPD_DT BETWEEN TO_DATE(REPLACE(@[fm_prd_dt], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt], '-'), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("		#elseif (${inv_date_type} == 'A') " ).append("\n"); 
		query.append("		AND		D.ATB_DT BETWEEN TO_DATE(REPLACE(@[fm_prd_dt], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt], '-'), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${lgs_cost_subj_cd} != '')" ).append("\n"); 
		query.append("		AND		LC.LGS_COST_SUBJ_CD IN (" ).append("\n"); 
		query.append("		#foreach($lgs_cost_subj_cd_num IN ${lgs_cost_subj_cd})" ).append("\n"); 
		query.append("			#if($velocityCount < $lgs_cost_subj_cd.size())" ).append("\n"); 
		query.append("			'$lgs_cost_subj_cd_num', " ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			'$lgs_cost_subj_cd_num'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${cntr_sty_cd} != '')" ).append("\n"); 
		query.append("		AND		SC.CNTR_STY_CD IN (" ).append("\n"); 
		query.append("		#foreach($cntr_sty_cd_num IN ${cntr_sty_cd})" ).append("\n"); 
		query.append("			#if($velocityCount < $cntr_sty_cd.size())" ).append("\n"); 
		query.append("			'$cntr_sty_cd_num', " ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			'$cntr_sty_cd_num'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${inv_no} != '') " ).append("\n"); 
		query.append("		AND		H.INV_NO			= @[inv_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${vvd} != '') " ).append("\n"); 
		query.append("		AND		D.VSL_CD || D.SKD_VOY_NO || D.SKD_DIR_CD	= @[vvd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		#if (${lgs_cost_cd} != '' )" ).append("\n"); 
		query.append("		AND		D.LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		GROUP BY  H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				, H.TML_SO_SEQ" ).append("\n"); 
		query.append("				, H.INV_OFC_CD" ).append("\n"); 
		query.append("				, H.COST_OFC_CD" ).append("\n"); 
		query.append("				, H.INV_NO" ).append("\n"); 
		query.append("				, H.VNDR_SEQ" ).append("\n"); 
		query.append("				, H.YD_CD" ).append("\n"); 
		query.append("				, D.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("				, D.CALC_COST_GRP_CD" ).append("\n"); 
		query.append("				, D.CALC_TP_CD" ).append("\n"); 
		query.append("				, D.VSL_CD" ).append("\n"); 
		query.append("				, D.SKD_VOY_NO" ).append("\n"); 
		query.append("				, D.SKD_DIR_CD" ).append("\n"); 
		query.append("				, D.FINC_VSL_CD" ).append("\n"); 
		query.append("				, D.FINC_SKD_VOY_NO" ).append("\n"); 
		query.append("				, D.FINC_SKD_DIR_CD" ).append("\n"); 
		query.append("				, D.IOC_CD" ).append("\n"); 
		query.append("				, D.LANE_CD" ).append("\n"); 
		query.append("				, D.IO_BND_CD" ).append("\n"); 
		query.append("				, D.LGS_COST_CD" ).append("\n"); 
		query.append("				, D.ACCT_CD" ).append("\n"); 
		query.append("				, D.ATB_DT" ).append("\n"); 
		query.append("				, D.CNTR_NO" ).append("\n"); 
		query.append("				, D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				, D.CALC_VOL_QTY" ).append("\n"); 
		query.append("				, D.FM_TR_VOL_VAL" ).append("\n"); 
		query.append("				, D.TO_TR_VOL_VAL" ).append("\n"); 
		query.append("				, D.RVIS_VOL_QTY" ).append("\n"); 
		query.append("				, D.DCGO_IND_CD" ).append("\n"); 
		query.append("				, D.STAY_DYS" ).append("\n"); 
		query.append("				, D.FREE_DYS" ).append("\n"); 
		query.append("				, D.PAY_DYS" ).append("\n"); 
		query.append("				, D.FREE_DY_XCLD_DYS" ).append("\n"); 
		query.append("				, D.OVR_DYS" ).append("\n"); 
		query.append("				, D.TML_WRK_DY_CD" ).append("\n"); 
		query.append("				, D.WRK_DT" ).append("\n"); 
		query.append("				, D.STK_VOL_QTY" ).append("\n"); 
		query.append("				, D.FP_TEU_QTY" ).append("\n"); 
		query.append("				, D.INV_VOL_QTY" ).append("\n"); 
		query.append("				, D.DIFF_VOL_QTY" ).append("\n"); 
		query.append("				, D.OVR_VOL_QTY" ).append("\n"); 
		query.append("				, D.VOL_TR_UT_CD" ).append("\n"); 
		query.append("				, D.CTRT_RT" ).append("\n"); 
		query.append("				, D.REF_VNDR_SEQ" ).append("\n"); 
		query.append("				, D.TML_CRR_CD" ).append("\n"); 
		query.append("				, D.CALC_RMK" ).append("\n"); 
		query.append("				, D.N3PTY_FLG" ).append("\n"); 
		query.append("				, D.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("				, D.TML_AGMT_SEQ" ).append("\n"); 
		query.append("				, D.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("				, DECODE(NVL(D.CURR_CD, 'N'), 'N', H.CURR_CD, D.CURR_CD)" ).append("\n"); 
		query.append("				, D.INV_XCH_RT" ).append("\n"); 
		query.append("				, D.REV_YRMON		" ).append("\n"); 
		query.append("#if (${bkg_no} != '' or ${cntr_no} != '' ) 	" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("		SELECT	  H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				, H.TML_SO_SEQ" ).append("\n"); 
		query.append("				, D.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("				, C.CNTR_NO" ).append("\n"); 
		query.append("				, D.LGS_COST_CD	" ).append("\n"); 
		query.append("		FROM    TES_TML_SO_HDR H" ).append("\n"); 
		query.append("				, TES_TML_SO_CNTR_LIST C" ).append("\n"); 
		query.append("				, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("				, TES_LGS_COST LC" ).append("\n"); 
		query.append("				, TES_TML_SO_COST SC" ).append("\n"); 
		query.append("		WHERE	1	= 1" ).append("\n"); 
		query.append("		AND		H.TML_SO_OFC_CTY_CD	= C.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		AND		H.TML_SO_SEQ		= C.TML_SO_SEQ" ).append("\n"); 
		query.append("		AND		H.TML_SO_OFC_CTY_CD	= D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		AND		H.TML_SO_SEQ		= D.TML_SO_SEQ" ).append("\n"); 
		query.append("		AND		D.LGS_COST_CD		= LC.LGS_COST_CD" ).append("\n"); 
		query.append("		AND		D.LGS_COST_CD		= SC.LGS_COST_CD" ).append("\n"); 
		query.append("		AND		NVL(H.DELT_FLG, 'N')<> 'Y'" ).append("\n"); 
		query.append("		AND		H.TML_INV_STS_CD	<> 'R'" ).append("\n"); 
		query.append("		AND		H.TML_INV_RJCT_STS_CD	<> 'RJ'" ).append("\n"); 
		query.append("		AND		H.TML_INV_TP_CD		= @[tml_inv_tp_cd]" ).append("\n"); 
		query.append("		AND		C.VRFY_RSLT_IND_CD	= 'CO'" ).append("\n"); 
		query.append("		AND		D.CALC_TP_CD		= 'A'" ).append("\n"); 
		query.append("		AND		NVL(C.CNTR_TPSZ_CD, 'N') 	= NVL(D.CNTR_TPSZ_CD, 'N')" ).append("\n"); 
		query.append("		AND		DECODE(H.TML_INV_TP_CD, 'TM', NVL(C.IO_BND_CD, 'N'), 'ON', NVL(C.IO_BND_CD, 'N'), 'OF', 'N', 'ST', 'N')" ).append("\n"); 
		query.append("			  = DECODE(H.TML_INV_TP_CD, 'TM', NVL(D.IO_BND_CD, 'N'), 'ON', NVL(D.IO_BND_CD, 'N'), 'OF', 'N', 'ST', 'N')" ).append("\n"); 
		query.append("		AND		DECODE(H.TML_INV_TP_CD, 'TM', NVL(C.IOC_CD, 'N'), 'ON', NVL(C.IOC_CD, 'N'), 'OF', 'N', 'ST', 'N')" ).append("\n"); 
		query.append("			  = DECODE(H.TML_INV_TP_CD, 'TM', NVL(D.IOC_CD, 'N'), 'ON', NVL(D.IOC_CD, 'N'), 'OF', 'N', 'ST', 'N')" ).append("\n"); 
		query.append("		AND		DECODE(H.TML_INV_TP_CD, 'TM', NVL(C.LANE_CD, 'N'), 'ON', NVL(C.LANE_CD, 'N'), 'OF', 'N', 'ST', 'N')" ).append("\n"); 
		query.append("			  = DECODE(H.TML_INV_TP_CD, 'TM', NVL(D.LANE_CD, 'N'), 'ON', NVL(D.LANE_CD, 'N'), 'OF', 'N', 'ST', 'N')" ).append("\n"); 
		query.append("		AND		DECODE(H.TML_INV_TP_CD, 'TM', DECODE(C.BB_CGO_FLG, 'Y', 'BB', DECODE(C.LOCL_TS_IND_CD, 'T', DECODE(C.CNTR_STY_CD, 'F', 'TS', 'TM'), DECODE(C.CNTR_STY_CD, 'F', 'FL', 'MT'))), 'ON', DECODE(C.CNTR_STY_CD, 'F', 'F', 'M'), 'OF', DECODE(C.CNTR_STY_CD, 'F', 'FL', 'MT'), 'ST', DECODE(C.LOCL_TS_IND_CD, 'T', 'TS', DECODE(C.CNTR_STY_CD, 'F', 'FL', 'MT')))" ).append("\n"); 
		query.append("			  = DECODE(H.TML_INV_TP_CD, 'TM', SUBSTR(D.LGS_COST_CD, 5, 2), 'ON', SUBSTR(D.LGS_COST_CD, 6, 1), 'OF', SUBSTR(D.LGS_COST_CD, 5, 2), 'ST', SUBSTR(D.LGS_COST_CD, 5, 2))" ).append("\n"); 
		query.append("		AND		DECODE(H.TML_INV_TP_CD, 'TM', NVL(C.DCGO_CLSS_CD, 'N'), 'ON', NVL(C.DCGO_CLSS_CD, 'N'), 'OF', 'N', 'ST', 'N')" ).append("\n"); 
		query.append("			  = DECODE(H.TML_INV_TP_CD, 'TM', NVL(D.DCGO_IND_CD, 'N'), 'ON', NVL(D.DCGO_IND_CD, 'N'), 'OF', 'N', 'ST', 'N')" ).append("\n"); 
		query.append("		AND		DECODE(H.TML_INV_TP_CD, 'TM', DECODE(D.TML_TRNS_MOD_CD, '', 'S', 'S', 'S', NVL(C.TML_TRNS_MOD_CD, 'S')), 'N')" ).append("\n"); 
		query.append("			  = DECODE(H.TML_INV_TP_CD, 'TM', NVL(D.TML_TRNS_MOD_CD, 'S'), 'N')" ).append("\n"); 
		query.append("		AND		DECODE(H.TML_INV_TP_CD, 'TM', DECODE(SUBSTR(D.LGS_COST_CD, 5, 2), 'TS', 'F', 'N'), 'N')" ).append("\n"); 
		query.append("			  = DECODE(H.TML_INV_TP_CD, 'TM', DECODE(SUBSTR(D.LGS_COST_CD, 5, 2), 'TS', C.CNTR_STY_CD, 'N'), 'N')" ).append("\n"); 
		query.append("		#if (${yd_cd} != '') " ).append("\n"); 
		query.append("		AND		H.YD_CD				= @[yd_cd]" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("		AND		H.VNDR_SEQ			= @[vndr_seq]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${cost_ofc_cd} != '')" ).append("\n"); 
		query.append("			#if($sub_ofc_cd1.size() > 0)" ).append("\n"); 
		query.append("				AND     H.COST_OFC_CD IN (" ).append("\n"); 
		query.append("				#foreach($sub_ofc_cd1_num IN ${sub_ofc_cd1})" ).append("\n"); 
		query.append("					#if($velocityCount < $sub_ofc_cd1.size()) " ).append("\n"); 
		query.append("						'$sub_ofc_cd1_num', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						'$sub_ofc_cd1_num' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND		H.COST_OFC_CD = @[cost_ofc_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${inv_ofc_cd} != '')" ).append("\n"); 
		query.append("			#if($sub_ofc_cd2.size() > 0)" ).append("\n"); 
		query.append("				AND     H.INV_OFC_CD IN (" ).append("\n"); 
		query.append("				#foreach($sub_ofc_cd2_num IN ${sub_ofc_cd2})" ).append("\n"); 
		query.append("					#if($velocityCount < $sub_ofc_cd2.size()) " ).append("\n"); 
		query.append("						'$sub_ofc_cd2_num', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						'$sub_ofc_cd2_num' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				AND		H.INV_OFC_CD = @[inv_ofc_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${tml_inv_sts_cd} != '' )" ).append("\n"); 
		query.append("		AND		H.TML_INV_STS_CD	= @[tml_inv_sts_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${inv_date_type} == 'I') " ).append("\n"); 
		query.append("		AND		H.ISS_DT BETWEEN TO_DATE(REPLACE(@[fm_prd_dt], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt], '-'), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("		#elseif (${inv_date_type} == 'R') " ).append("\n"); 
		query.append("		AND		H.RCV_DT BETWEEN TO_DATE(REPLACE(@[fm_prd_dt], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt], '-'), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("		#elseif (${inv_date_type} == 'P') " ).append("\n"); 
		query.append("		AND		H.LOCL_UPD_DT BETWEEN TO_DATE(REPLACE(@[fm_prd_dt], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt], '-'), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("		#elseif (${inv_date_type} == 'A') " ).append("\n"); 
		query.append("		AND		C.ATB_DT BETWEEN TO_DATE(REPLACE(@[fm_prd_dt], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt], '-'), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${inv_no} != '') " ).append("\n"); 
		query.append("		AND		H.INV_NO			= @[inv_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${bkg_no} != '') " ).append("\n"); 
		query.append("		AND		C.BKG_NO			= @[bkg_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${cntr_no} != '') " ).append("\n"); 
		query.append("		AND		C.CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${vvd} != '') " ).append("\n"); 
		query.append("		AND		C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD	= @[vvd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${lgs_cost_subj_cd} != '')" ).append("\n"); 
		query.append("		AND		LC.LGS_COST_SUBJ_CD IN (" ).append("\n"); 
		query.append("		#foreach($lgs_cost_subj_cd_num IN ${lgs_cost_subj_cd})" ).append("\n"); 
		query.append("			#if($velocityCount < $lgs_cost_subj_cd.size())" ).append("\n"); 
		query.append("			'$lgs_cost_subj_cd_num', " ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			'$lgs_cost_subj_cd_num'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${cntr_sty_cd} != '')" ).append("\n"); 
		query.append("		AND		SC.CNTR_STY_CD IN (" ).append("\n"); 
		query.append("		#foreach($cntr_sty_cd_num IN ${cntr_sty_cd})" ).append("\n"); 
		query.append("			#if($velocityCount < $cntr_sty_cd.size())" ).append("\n"); 
		query.append("			'$cntr_sty_cd_num', " ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			'$cntr_sty_cd_num'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${lgs_cost_cd} != '' )" ).append("\n"); 
		query.append("		AND		D.LGS_COST_CD		= @[lgs_cost_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		GROUP BY H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				, H.TML_SO_SEQ" ).append("\n"); 
		query.append("				, D.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("				, C.CNTR_NO" ).append("\n"); 
		query.append("				, D.LGS_COST_CD	" ).append("\n"); 
		query.append("		) B" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		A.TML_SO_OFC_CTY_CD		= B.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND		A.TML_SO_SEQ			= B.TML_SO_SEQ" ).append("\n"); 
		query.append("AND		A.TML_SO_DTL_SEQ		= B.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("#if (${lgs_cost_cd} != '' )" ).append("\n"); 
		query.append("AND		A.LGS_COST_CD 			= @[lgs_cost_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY  A.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		, A.TML_SO_SEQ" ).append("\n"); 
		query.append("		, A.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("		, A.INV_OFC_CD" ).append("\n"); 
		query.append("		, A.COST_OFC_CD" ).append("\n"); 
		query.append("		, A.INV_NO" ).append("\n"); 
		query.append("		, A.VNDR_SEQ" ).append("\n"); 
		query.append("		, A.YD_CD" ).append("\n"); 
		query.append("		, A.CALC_COST_GRP_CD" ).append("\n"); 
		query.append("		, A.CALC_TP_CD" ).append("\n"); 
		query.append("		, A.VSL_CD" ).append("\n"); 
		query.append("		, A.SKD_VOY_NO" ).append("\n"); 
		query.append("		, A.SKD_DIR_CD" ).append("\n"); 
		query.append("		, A.FINC_VSL_CD" ).append("\n"); 
		query.append("		, A.FINC_SKD_VOY_NO" ).append("\n"); 
		query.append("		, A.FINC_SKD_DIR_CD" ).append("\n"); 
		query.append("		, A.IOC_CD" ).append("\n"); 
		query.append("		, A.LANE_CD" ).append("\n"); 
		query.append("		, A.IO_BND_CD" ).append("\n"); 
		query.append("		, A.LGS_COST_CD" ).append("\n"); 
		query.append("		, A.LGS_COST_CD2" ).append("\n"); 
		query.append("		, A.ACCT_CD" ).append("\n"); 
		query.append("		, A.ATB_DT" ).append("\n"); 
		query.append("		, A.CNTR_NO" ).append("\n"); 
		query.append("		, A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, A.CALC_VOL_QTY" ).append("\n"); 
		query.append("		, A.FM_TR_VOL_VAL" ).append("\n"); 
		query.append("		, A.TO_TR_VOL_VAL" ).append("\n"); 
		query.append("		, A.RVIS_VOL_QTY" ).append("\n"); 
		query.append("		, A.DCGO_IND_CD" ).append("\n"); 
		query.append("		, A.STAY_DYS" ).append("\n"); 
		query.append("		, A.FREE_DYS" ).append("\n"); 
		query.append("		, A.PAY_DYS" ).append("\n"); 
		query.append("		, A.FREE_DY_XCLD_DYS" ).append("\n"); 
		query.append("		, A.OVR_DYS" ).append("\n"); 
		query.append("		, A.OVR_DYS" ).append("\n"); 
		query.append("		, A.TML_WRK_DY_CD" ).append("\n"); 
		query.append("		, A.WRK_DT" ).append("\n"); 
		query.append("		, A.STK_VOL_QTY" ).append("\n"); 
		query.append("		, A.FP_TEU_QTY" ).append("\n"); 
		query.append("		, A.INV_VOL_QTY" ).append("\n"); 
		query.append("		, A.DIFF_VOL_QTY" ).append("\n"); 
		query.append("		, A.OVR_VOL_QTY" ).append("\n"); 
		query.append("		, A.VOL_TR_UT_CD" ).append("\n"); 
		query.append("		, A.CTRT_RT" ).append("\n"); 
		query.append("		, A.REF_VNDR_SEQ" ).append("\n"); 
		query.append("		, A.CALC_AMT" ).append("\n"); 
		query.append("		, A.INV_AMT" ).append("\n"); 
		query.append("		, A.TML_CRR_CD" ).append("\n"); 
		query.append("		, A.CALC_RMK" ).append("\n"); 
		query.append("		, A.N3PTY_FLG" ).append("\n"); 
		query.append("		, A.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		, A.TML_AGMT_SEQ" ).append("\n"); 
		query.append("		, A.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("		, A.CURR_CD" ).append("\n"); 
		query.append("		, A.INV_XCH_RT" ).append("\n"); 
		query.append("		, A.REV_YRMON" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}