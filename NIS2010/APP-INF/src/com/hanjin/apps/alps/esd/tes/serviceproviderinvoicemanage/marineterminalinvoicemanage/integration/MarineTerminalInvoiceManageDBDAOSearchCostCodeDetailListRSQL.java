/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchCostCodeDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchCostCodeDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCostCodeDetailList
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchCostCodeDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_wrk_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_vol_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchCostCodeDetailListRSQL").append("\n"); 
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
		query.append("/* Cost Code 별 detail 가져오는 쿼리 */" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("        'S'            AS calc_tp_cd" ).append("\n"); 
		query.append("       ,A.LGS_COST_CD  AS lgs_cost_cd" ).append("\n"); 
		query.append("       ,D.CNTR_TPSZ_CD AS cntr_tpsz_cd" ).append("\n"); 
		query.append("       ,A.IO_BND_CD    AS io_bnd_cd" ).append("\n"); 
		query.append("       ,@[dcgo_ind_cd] AS dcgo_ind_cd " ).append("\n"); 
		query.append("       ,''               AS rc_flg            /* Referer */" ).append("\n"); 
		query.append("       ,@[tml_wrk_dy_cd] AS tml_wrk_dy_cd     /* Apply Date */ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,DECODE(A.IOC_CD, 'I','IPC','S','Same','O','OCN') AS ioc_cd /* IPC */" ).append("\n"); 
		query.append("       ,DECODE(A.TML_TRNS_MOD_CD,'V','Mother','R','Rail','T','Truck','B','Barge','O','Other','S','Same','F','Feeder') AS tml_trns_mod_cd /* Mode */" ).append("\n"); 
		query.append("       ,A.LANE_CD      AS lane_cd" ).append("\n"); 
		query.append("       ,'1 ~ 99999'    AS tier               /* VOL. Tier*/" ).append("\n"); 
		query.append("       ,'1'           AS calc_vol_qty        /* Calculated\\nVol. */" ).append("\n"); 
		query.append("       ,'1'           AS rvis_vol_qty        /* Revised\\n Vol. */" ).append("\n"); 
		query.append("	   ,'1'           AS stay_days   " ).append("\n"); 
		query.append("       ,A.TML_AGMT_VOL_UT_CD AS vol_tr_ut_cd /* UOM */" ).append("\n"); 
		query.append("       ,D.AGMT_RT      AS ctrt_rt            /* Rate */" ).append("\n"); 
		query.append("       ,A.CURR_CD      AS curr_cd            /* AGMT Curr */" ).append("\n"); 
		query.append("       ,NVL('1',1) * NVL(D.AGMT_RT,0) AS inv_amt /* Amount */" ).append("\n"); 
		query.append("       /* VO Fields */" ).append("\n"); 
		query.append("       ,'' AS cost_code" ).append("\n"); 
		query.append("       ,'' AS agmt_ofc_cty_cd" ).append("\n"); 
		query.append("       ,'' AS agmt_seq" ).append("\n"); 
		query.append("       ,'' AS agmt_ver_no" ).append("\n"); 
		query.append("       ,'' AS yd_cd" ).append("\n"); 
		query.append("       ,'' AS vndr_seq      " ).append("\n"); 
		query.append("       ,'' AS eff_fm_dt" ).append("\n"); 
		query.append("       ,'' AS eff_to_dt" ).append("\n"); 
		query.append("       ,'' AS cre_ofc_cd" ).append("\n"); 
		query.append("       ,'' AS ctrt_ofc_cd" ).append("\n"); 
		query.append("       ,'' AS cre_dt" ).append("\n"); 
		query.append("       ,'' AS upd_dt" ).append("\n"); 
		query.append("	   ,100 AS portion" ).append("\n"); 
		query.append("	   , 1 AS inv_xch_rt" ).append("\n"); 
		query.append("	   , A.AGMT_DTL_RMK" ).append("\n"); 
		query.append("-- 비용지급 전표 결재 기능 - 3차 AGMT 정보 등록 (4347-10-15)" ).append("\n"); 
		query.append("		, @[agmt_ofc_cty_cd] AS TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		, TO_NUMBER(@[agmt_seq]) AS TML_AGMT_SEQ" ).append("\n"); 
		query.append("		, TO_NUMBER(REPLACE(@[agmt_ver_no],'.','')) AS TML_AGMT_VER_NO" ).append("\n"); 
		query.append("        , NVL((SELECT VOL_RT_CHK_FLG FROM TES_TML_SO_COST C WHERE C.LGS_COST_CD = A.LGS_COST_CD),'N') VOL_RT_CHK_FLG" ).append("\n"); 
		query.append("        , NVL((SELECT VOL_DUP_CHK_FLG FROM TES_TML_SO_COST C WHERE C.LGS_COST_CD = A.LGS_COST_CD),'N') VOL_DUP_CHK_FLG" ).append("\n"); 
		query.append("		, NVL((SELECT RMK_CHK_FLG FROM TES_TML_SO_COST C WHERE C.LGS_COST_CD = A.LGS_COST_CD),'N') RMK_CHK_FLG" ).append("\n"); 
		query.append("FROM TES_TML_AGMT_DTL A, " ).append("\n"); 
		query.append("  TES_TML_AGMT_APLY_DY B, " ).append("\n"); 
		query.append("  TES_TML_AGMT_DG_CGO_CLSS C, " ).append("\n"); 
		query.append("  (  SELECT A.TML_AGMT_OFC_CTY_CD, " ).append("\n"); 
		query.append("              A.TML_AGMT_SEQ, " ).append("\n"); 
		query.append("              A.TML_AGMT_VER_NO, " ).append("\n"); 
		query.append("              A.TML_AGMT_DTL_SEQ, " ).append("\n"); 
		query.append("              B.CNTR_APLY_TP_CD, " ).append("\n"); 
		query.append("              B.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("              A.LGS_COST_CD, " ).append("\n"); 
		query.append("              a.tml_agmt_vol_ut_cd, " ).append("\n"); 
		query.append("              DECODE(AGMT_RT,NULL,a.agmt_ut_rt,AGMT_RT) AGMT_RT " ).append("\n"); 
		query.append("    FROM TES_TML_AGMT_DTL A, " ).append("\n"); 
		query.append("      	(	SELECT * " ).append("\n"); 
		query.append("			FROM TES_TML_AGMT_TP_SZ" ).append("\n"); 
		query.append("			WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${rf_yn} == 'Y') " ).append("\n"); 
		query.append("		AND CNTR_TPSZ_CD  IN ('R2','R4','R5','R7','R8','R9')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		) B " ).append("\n"); 
		query.append("    WHERE A.TML_AGMT_OFC_CTY_CD = B.TML_AGMT_OFC_CTY_CD(+) " ).append("\n"); 
		query.append("      AND A.TML_AGMT_SEQ = B.TML_AGMT_SEQ(+) " ).append("\n"); 
		query.append("      AND A.TML_AGMT_VER_NO = B.TML_AGMT_VER_NO(+) " ).append("\n"); 
		query.append("      AND A.TML_AGMT_DTL_SEQ = B.TML_AGMT_DTL_SEQ(+) " ).append("\n"); 
		query.append("      AND A.TML_AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("      AND A.TML_AGMT_SEQ        = TO_NUMBER(@[agmt_seq])" ).append("\n"); 
		query.append("      AND A.TML_AGMT_VER_NO     = TO_NUMBER(REPLACE(@[agmt_ver_no],'.',''))" ).append("\n"); 
		query.append("      AND A.LGS_COST_CD         = @[cost_code]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ) D " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND A.TML_AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("  AND A.TML_AGMT_SEQ        = TO_NUMBER(@[agmt_seq])" ).append("\n"); 
		query.append("  AND A.TML_AGMT_VER_NO     = TO_NUMBER(REPLACE(@[agmt_ver_no],'.',''))" ).append("\n"); 
		query.append("  AND A.LGS_COST_CD         = @[cost_code]" ).append("\n"); 
		query.append("  AND A.TMP_SAV_FLG IS NULL " ).append("\n"); 
		query.append("  AND A.TML_AGMT_OFC_CTY_CD = B.TML_AGMT_OFC_CTY_CD(+) " ).append("\n"); 
		query.append("  AND A.TML_AGMT_OFC_CTY_CD = C.TML_AGMT_OFC_CTY_CD(+) " ).append("\n"); 
		query.append("  AND A.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD(+) " ).append("\n"); 
		query.append("  AND A.TML_AGMT_SEQ = B.TML_AGMT_SEQ(+) " ).append("\n"); 
		query.append("  AND A.TML_AGMT_SEQ = C.TML_AGMT_SEQ(+) " ).append("\n"); 
		query.append("  AND A.TML_AGMT_SEQ = D.TML_AGMT_SEQ(+) " ).append("\n"); 
		query.append("  AND A.TML_AGMT_VER_NO = B.TML_AGMT_VER_NO(+) " ).append("\n"); 
		query.append("  AND A.TML_AGMT_VER_NO = C.TML_AGMT_VER_NO(+) " ).append("\n"); 
		query.append("  AND A.TML_AGMT_VER_NO = D.TML_AGMT_VER_NO(+) " ).append("\n"); 
		query.append("  AND A.TML_AGMT_DTL_SEQ = B.TML_AGMT_DTL_SEQ(+) " ).append("\n"); 
		query.append("  AND A.TML_AGMT_DTL_SEQ = C.TML_AGMT_DTL_SEQ(+) " ).append("\n"); 
		query.append("  AND A.TML_AGMT_DTL_SEQ = D.TML_AGMT_DTL_SEQ(+) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${tml_agmt_vol_ut_cd} != 'ALL') " ).append("\n"); 
		query.append("	AND A.TML_AGMT_VOL_UT_CD = @[tml_agmt_vol_ut_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != 'ALL') " ).append("\n"); 
		query.append("	AND D.CNTR_TPSZ_CD =@[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--CHM-201641252 Semi-Update에서 DG Default Setting변경(All Type추가) - (4349-04-20)" ).append("\n"); 
		query.append("#if (${dcgo_ind_cd} == 'ALL') " ).append("\n"); 
		query.append("	AND ( C.DCGO_APLY_TP_CD IN ('R', 'D')" ).append("\n"); 
		query.append("	OR	(A.DCGO_APLY_TP_CD = 'N' OR A.DCGO_APLY_TP_CD IS NULL) )" ).append("\n"); 
		query.append("#elseif (${dcgo_ind_cd} == 'ALLDG') " ).append("\n"); 
		query.append("	AND C.DCGO_APLY_TP_CD IN ('R','D')" ).append("\n"); 
		query.append("#elseif (${dcgo_ind_cd} == 'N') " ).append("\n"); 
		query.append("   AND (A.DCGO_APLY_TP_CD = 'N' OR A.DCGO_APLY_TP_CD IS NULL) " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   AND DECODE(@[dcgo_ind_cd], '1',C.DCGO_N1ST_CLSS_FLG, '2',C.DCGO_N2ND_CLSS_FLG, '3',C.DCGO_N3RD_CLSS_FLG, '4',C.DCGO_N4TH_CLSS_FLG, '5',C.DCGO_N5TH_CLSS_FLG," ).append("\n"); 
		query.append("                              '6',C.DCGO_N6TH_CLSS_FLG, '7',C.DCGO_N7TH_CLSS_FLG, '8',C.DCGO_N8TH_CLSS_FLG, '9',C.DCGO_N9TH_CLSS_FLG) = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tml_wrk_dy_cd} != '') " ).append("\n"); 
		query.append("	AND DECODE(@[tml_wrk_dy_cd],  'HO',B.HOL_FLG, 'SA',B.SAT_FLG, 'SU',B.SUN_FLG, 'WD',B.WKDY_FLG) = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY LGS_COST_CD DESC, cntr_tpsz_cd, io_bnd_cd, dcgo_ind_cd, rc_flg, tml_wrk_dy_cd, ioc_cd, tml_trns_mod_cd, lane_cd, tier, calc_vol_qty, rvis_vol_qty, vol_tr_ut_cd, ctrt_rt, curr_cd" ).append("\n"); 

	}
}