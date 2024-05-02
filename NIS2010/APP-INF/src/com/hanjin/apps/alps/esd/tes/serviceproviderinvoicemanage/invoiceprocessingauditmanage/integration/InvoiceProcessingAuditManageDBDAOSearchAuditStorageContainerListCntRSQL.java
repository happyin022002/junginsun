/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceProcessingAuditManageDBDAOSearchAuditStorageContainerListCntRSQL.java
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

public class InvoiceProcessingAuditManageDBDAOSearchAuditStorageContainerListCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Processing Audit Manage
	  * AuditStorageContainerList 조회
	  * </pre>
	  */
	public InvoiceProcessingAuditManageDBDAOSearchAuditStorageContainerListCntRSQL(){
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
		params.put("vrfy_rslt_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : InvoiceProcessingAuditManageDBDAOSearchAuditStorageContainerListCntRSQL").append("\n"); 
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
		query.append("SELECT	COUNT(*) AS CNT" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT	  H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				, H.TML_SO_SEQ" ).append("\n"); 
		query.append("				, H.INV_OFC_CD" ).append("\n"); 
		query.append("				, H.COST_OFC_CD" ).append("\n"); 
		query.append("				, H.INV_NO" ).append("\n"); 
		query.append("				, H.VNDR_SEQ" ).append("\n"); 
		query.append("				, H.YD_CD" ).append("\n"); 
		query.append("				, C.BB_CGO_FLG" ).append("\n"); 
		query.append("				, C.WRK_DT" ).append("\n"); 
		query.append("				, C.CLM_DT" ).append("\n"); 
		query.append("				, C.RAIL_BIL_DT" ).append("\n"); 
		query.append("				, C.DSCR_RSN" ).append("\n"); 
		query.append("				, C.HNDL_RSLT_RMK" ).append("\n"); 
		query.append("				, C.CNTR_RMK" ).append("\n"); 
		query.append("				, C.CRE_USR_ID" ).append("\n"); 
		query.append("				, TO_CHAR(C.CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("				, C.UPD_USR_ID" ).append("\n"); 
		query.append("				, TO_CHAR(C.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("				, C.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("				, C.VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append("				, C.MODI_FLG" ).append("\n"); 
		query.append("				, C.DSCR_IND_CD" ).append("\n"); 
		query.append("				, C.TML_RVIS_IND_FLG" ).append("\n"); 
		query.append("				, C.IO_BND_CD" ).append("\n"); 
		query.append("				, C.IOC_CD" ).append("\n"); 
		query.append("				, C.LANE_CD" ).append("\n"); 
		query.append("				, C.ATB_DT" ).append("\n"); 
		query.append("				, C.CNTR_NO" ).append("\n"); 
		query.append("				, C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				, C.CNTR_STY_CD" ).append("\n"); 
		query.append("				, C.LOCL_TS_IND_CD" ).append("\n"); 
		query.append("				, C.SAM_LOCL_TS_IND_CD" ).append("\n"); 
		query.append("				, C.RCVDE_TERM_IND_CD" ).append("\n"); 
		query.append("				, C.PRE_YD_CD" ).append("\n"); 
		query.append("				, TO_CHAR(C.MVMT_GATE_IN_DT, 'YYYY-MM-DD HH24:MI') AS MVMT_GATE_IN_DT" ).append("\n"); 
		query.append("				, TO_CHAR(C.INV_GATE_IN_DT, 'YYYY-MM-DD HH24:MI') AS INV_GATE_IN_DT" ).append("\n"); 
		query.append("				, C.GATE_IN_TD_DYS" ).append("\n"); 
		query.append("				, TO_CHAR(C.MVMT_GATE_OUT_DT, 'YYYY-MM-DD HH24:MI') AS MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append("				, TO_CHAR(C.INV_GATE_OUT_DT, 'YYYY-MM-DD HH24:MI') AS INV_GATE_OUT_DT" ).append("\n"); 
		query.append("				, C.GATE_OUT_TD_DYS" ).append("\n"); 
		query.append("				, C.MVMT_STAY_DYS" ).append("\n"); 
		query.append("				, C.INV_STAY_DYS + 1 AS INV_STAY_DYS     -- 2012.07.30 장병용 부장 요청으로 +1 추가함..이유는 Verify시 Stay day 구할때 CMNC_HRMNT를 계산하지 않기 때문임..임시방편 인듯.." ).append("\n"); 
		query.append("				, C.STAY_DIFF_DYS" ).append("\n"); 
		query.append("				, C.AWK_CGO_FLG" ).append("\n"); 
		query.append("				, C.RC_FLG" ).append("\n"); 
		query.append("				, C.DCGO_CLSS_CD" ).append("\n"); 
		query.append("				, ROW_NUMBER() OVER (ORDER BY H.INV_OFC_CD" ).append("\n"); 
		query.append("				, H.COST_OFC_CD" ).append("\n"); 
		query.append("				, H.YD_CD" ).append("\n"); 
		query.append("				, H.VNDR_SEQ" ).append("\n"); 
		query.append("				, H.INV_NO" ).append("\n"); 
		query.append("				, C.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("				) AS NO" ).append("\n"); 
		query.append("		FROM	TES_TML_SO_HDR H" ).append("\n"); 
		query.append("				, TES_TML_SO_CNTR_LIST C" ).append("\n"); 
		query.append("		WHERE	H.TML_SO_OFC_CTY_CD	= C.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		AND		H.TML_SO_SEQ		= C.TML_SO_SEQ" ).append("\n"); 
		query.append("		AND		H.TML_INV_TP_CD		= @[tml_inv_tp_cd]" ).append("\n"); 
		query.append("		AND		C.VRFY_RSLT_IND_CD	= @[vrfy_rslt_ind_cd]" ).append("\n"); 
		query.append("		#if (${yd_cd} != '') " ).append("\n"); 
		query.append("		AND		H.YD_CD				= @[yd_cd]" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("		AND		H.VNDR_SEQ			= @[vndr_seq]" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("		#if (${tml_inv_sts_cd} != '' )" ).append("\n"); 
		query.append("		AND		H.TML_INV_STS_CD	= @[tml_inv_sts_cd]" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
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
		query.append("		#else " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${inv_no} != '') " ).append("\n"); 
		query.append("		AND		H.INV_NO			= @[inv_no]" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${bkg_no} != '') " ).append("\n"); 
		query.append("		AND		C.BKG_NO			= @[bkg_no]" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${cntr_no} != '') " ).append("\n"); 
		query.append("		AND		C.CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${vvd} != '') " ).append("\n"); 
		query.append("		AND		C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD	= @[vvd]" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		ORDER BY H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				, H.TML_SO_SEQ" ).append("\n"); 
		query.append("				, H.INV_OFC_CD" ).append("\n"); 
		query.append("				, H.COST_OFC_CD" ).append("\n"); 
		query.append("				, H.YD_CD" ).append("\n"); 
		query.append("				, H.VNDR_SEQ" ).append("\n"); 
		query.append("				, H.INV_NO" ).append("\n"); 
		query.append("				, C.DSCR_IND_CD" ).append("\n"); 
		query.append("				, C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				, C.CNTR_STY_CD" ).append("\n"); 
		query.append("		) A" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("		-- AUDIT 기능 보완 - Cost Calculated 항목 추가 (4347-10-08)" ).append("\n"); 
		query.append("		SELECT    TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				, TML_SO_SEQ" ).append("\n"); 
		query.append("				, TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("				, CNTR_NO" ).append("\n"); 
		query.append("				, SUBSTR( MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD, ',')), 2) AS LGS_COST_CD" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				 SELECT	  H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("						, H.TML_SO_SEQ" ).append("\n"); 
		query.append("						, C.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("						, C.CNTR_NO" ).append("\n"); 
		query.append("						, D.LGS_COST_CD	" ).append("\n"); 
		query.append("						, ROW_NUMBER() OVER(PARTITION BY H.TML_SO_OFC_CTY_CD, H.TML_SO_SEQ, C.CNTR_NO ORDER BY D.LGS_COST_CD) AS CNTR_COST" ).append("\n"); 
		query.append("				FROM    TES_TML_SO_HDR H" ).append("\n"); 
		query.append("						, TES_TML_SO_CNTR_LIST C" ).append("\n"); 
		query.append("						, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("						, TES_LGS_COST LC" ).append("\n"); 
		query.append("						, TES_TML_SO_COST SC" ).append("\n"); 
		query.append("				WHERE	1	= 1" ).append("\n"); 
		query.append("				AND		H.TML_SO_OFC_CTY_CD	= C.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				AND		H.TML_SO_SEQ		= C.TML_SO_SEQ" ).append("\n"); 
		query.append("				AND		H.TML_SO_OFC_CTY_CD	= D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				AND		H.TML_SO_SEQ		= D.TML_SO_SEQ" ).append("\n"); 
		query.append("				AND		D.LGS_COST_CD		= LC.LGS_COST_CD" ).append("\n"); 
		query.append("				AND		D.LGS_COST_CD		= SC.LGS_COST_CD" ).append("\n"); 
		query.append("				AND		NVL(H.DELT_FLG, 'N')	<> 'Y'" ).append("\n"); 
		query.append("				AND		H.TML_INV_TP_CD		= @[tml_inv_tp_cd]" ).append("\n"); 
		query.append("				AND		C.VRFY_RSLT_IND_CD	= @[vrfy_rslt_ind_cd]" ).append("\n"); 
		query.append("				AND		D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("--				AND		D.CALC_COST_GRP_CD    NOT IN ('SD','SP')" ).append("\n"); 
		query.append("				AND		NVL(C.CNTR_TPSZ_CD, 'N') 	= NVL(D.CNTR_TPSZ_CD, 'N')" ).append("\n"); 
		query.append("				AND		DECODE(H.TML_INV_TP_CD, 'TM', NVL(C.IO_BND_CD, 'N'), 'ON', NVL(C.IO_BND_CD, 'N'), 'OF', 'N', 'ST', 'N')" ).append("\n"); 
		query.append("						= DECODE(H.TML_INV_TP_CD, 'TM', NVL(D.IO_BND_CD, 'N'), 'ON', NVL(D.IO_BND_CD, 'N'), 'OF', 'N', 'ST', 'N')" ).append("\n"); 
		query.append("				AND		DECODE(H.TML_INV_TP_CD, 'TM', NVL(C.IOC_CD, 'N'), 'ON', NVL(C.IOC_CD, 'N'), 'OF', 'N', 'ST', 'N')" ).append("\n"); 
		query.append("						= DECODE(H.TML_INV_TP_CD, 'TM', NVL(D.IOC_CD, 'N'), 'ON', NVL(D.IOC_CD, 'N'), 'OF', 'N', 'ST', 'N')" ).append("\n"); 
		query.append("				AND		DECODE(H.TML_INV_TP_CD, 'TM', NVL(C.LANE_CD, 'N'), 'ON', NVL(C.LANE_CD, 'N'), 'OF', 'N', 'ST', 'N')" ).append("\n"); 
		query.append("						= DECODE(H.TML_INV_TP_CD, 'TM', NVL(D.LANE_CD, 'N'), 'ON', NVL(D.LANE_CD, 'N'), 'OF', 'N', 'ST', 'N')" ).append("\n"); 
		query.append("				AND		DECODE(H.TML_INV_TP_CD, 'TM', DECODE(C.BB_CGO_FLG, 'Y', 'BB', DECODE(C.LOCL_TS_IND_CD, 'T', DECODE(C.CNTR_STY_CD, 'F', 'TS', 'TM'), DECODE(C.CNTR_STY_CD, 'F', 'FL', 'MT'))), 'ON', DECODE(C.CNTR_STY_CD, 'F', 'F', 'M'), 'OF', DECODE(C.CNTR_STY_CD, 'F', 'FL', 'MT'), 'ST', DECODE(C.LOCL_TS_IND_CD, 'T', 'TS', DECODE(C.CNTR_STY_CD, 'F', 'FL', 'MT')))" ).append("\n"); 
		query.append("						= DECODE(H.TML_INV_TP_CD, 'TM', SUBSTR(D.LGS_COST_CD, 5, 2), 'ON', SUBSTR(D.LGS_COST_CD, 6, 1), 'OF', SUBSTR(D.LGS_COST_CD, 5, 2), 'ST', SUBSTR(D.LGS_COST_CD, 5, 2))" ).append("\n"); 
		query.append("				AND		DECODE(H.TML_INV_TP_CD, 'TM', NVL(C.DCGO_CLSS_CD, 'N'), 'ON', NVL(C.DCGO_CLSS_CD, 'N'), 'OF', 'N', 'ST', 'N')" ).append("\n"); 
		query.append("						= DECODE(H.TML_INV_TP_CD, 'TM', NVL(D.DCGO_IND_CD, 'N'), 'ON', NVL(D.DCGO_IND_CD, 'N'), 'OF', 'N', 'ST', 'N')" ).append("\n"); 
		query.append("				AND		DECODE(H.TML_INV_TP_CD, 'TM', DECODE(D.TML_TRNS_MOD_CD, '', 'S', 'S', 'S', NVL(C.TML_TRNS_MOD_CD, 'S')), 'N')" ).append("\n"); 
		query.append("						= DECODE(H.TML_INV_TP_CD, 'TM', NVL(D.TML_TRNS_MOD_CD, 'S'), 'N')" ).append("\n"); 
		query.append("				AND		DECODE(H.TML_INV_TP_CD, 'TM', DECODE(SUBSTR(D.LGS_COST_CD, 5, 2), 'TS', 'F', 'N'), 'N')" ).append("\n"); 
		query.append("						= DECODE(H.TML_INV_TP_CD, 'TM', DECODE(SUBSTR(D.LGS_COST_CD, 5, 2), 'TS', C.CNTR_STY_CD, 'N'), 'N')" ).append("\n"); 
		query.append("				#if (${yd_cd} != '') " ).append("\n"); 
		query.append("				AND		H.YD_CD				= @[yd_cd]" ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("				AND		H.VNDR_SEQ			= @[vndr_seq]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
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
		query.append("				#if (${tml_inv_sts_cd} != '' )" ).append("\n"); 
		query.append("				AND		H.TML_INV_STS_CD	= @[tml_inv_sts_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${inv_date_type} == 'I') " ).append("\n"); 
		query.append("				AND		H.ISS_DT BETWEEN TO_DATE(REPLACE(@[fm_prd_dt], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt], '-'), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("				#elseif (${inv_date_type} == 'R') " ).append("\n"); 
		query.append("				AND		H.RCV_DT BETWEEN TO_DATE(REPLACE(@[fm_prd_dt], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt], '-'), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("				#elseif (${inv_date_type} == 'P') " ).append("\n"); 
		query.append("				AND		H.LOCL_UPD_DT BETWEEN TO_DATE(REPLACE(@[fm_prd_dt], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt], '-'), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("				#elseif (${inv_date_type} == 'A') " ).append("\n"); 
		query.append("				AND		C.ATB_DT BETWEEN TO_DATE(REPLACE(@[fm_prd_dt], '-'), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_prd_dt], '-'), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${inv_no} != '') " ).append("\n"); 
		query.append("				AND		H.INV_NO			= @[inv_no]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${bkg_no} != '') " ).append("\n"); 
		query.append("				AND		C.BKG_NO			= @[bkg_no]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${cntr_no} != '') " ).append("\n"); 
		query.append("				AND		C.CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${vvd} != '') " ).append("\n"); 
		query.append("				AND		C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD	= @[vvd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${lgs_cost_subj_cd} != '')" ).append("\n"); 
		query.append("				AND		LC.LGS_COST_SUBJ_CD IN (" ).append("\n"); 
		query.append("				#foreach($lgs_cost_subj_cd_num IN ${lgs_cost_subj_cd})" ).append("\n"); 
		query.append("					#if($velocityCount < $lgs_cost_subj_cd.size())" ).append("\n"); 
		query.append("					'$lgs_cost_subj_cd_num', " ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("					'$lgs_cost_subj_cd_num'" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${cntr_sty_cd} != '')" ).append("\n"); 
		query.append("				AND		SC.CNTR_STY_CD IN (" ).append("\n"); 
		query.append("				#foreach($cntr_sty_cd_num IN ${cntr_sty_cd})" ).append("\n"); 
		query.append("					#if($velocityCount < $cntr_sty_cd.size())" ).append("\n"); 
		query.append("					'$cntr_sty_cd_num', " ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("					'$cntr_sty_cd_num'" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${lgs_cost_cd} != '' )" ).append("\n"); 
		query.append("				AND		D.LGS_COST_CD		= @[lgs_cost_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				GROUP BY H.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("						, H.TML_SO_SEQ" ).append("\n"); 
		query.append("						, C.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("						, C.CNTR_NO" ).append("\n"); 
		query.append("						, D.LGS_COST_CD	" ).append("\n"); 
		query.append("				) A	" ).append("\n"); 
		query.append("			START WITH CNTR_COST = 1" ).append("\n"); 
		query.append("			CONNECT BY PRIOR CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("			AND PRIOR CNTR_COST = CNTR_COST - 1" ).append("\n"); 
		query.append("		GROUP BY  TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				, TML_SO_SEQ" ).append("\n"); 
		query.append("				, TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("				, CNTR_NO" ).append("\n"); 
		query.append("		) B" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("#if (${lgs_cost_subj_cd} != '' or ${cntr_sty_cd} != '')" ).append("\n"); 
		query.append("AND		A.TML_SO_OFC_CTY_CD		= B.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND		A.TML_SO_SEQ			= B.TML_SO_SEQ" ).append("\n"); 
		query.append("AND		A.TML_SO_CNTR_LIST_SEQ	= B.TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("AND		A.CNTR_NO				= B.CNTR_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND		A.TML_SO_OFC_CTY_CD		= B.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND		A.TML_SO_SEQ			= B.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("AND		A.TML_SO_CNTR_LIST_SEQ	= B.TML_SO_CNTR_LIST_SEQ(+)" ).append("\n"); 
		query.append("AND		A.CNTR_NO				= B.CNTR_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lgs_cost_cd} != '' )" ).append("\n"); 
		query.append("AND		B.LGS_COST_CD LIKE '%' || @[lgs_cost_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}