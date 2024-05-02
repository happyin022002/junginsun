/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewSvcOrdFromTmpUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.06.23 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOAddWorkOrderPreviewSvcOrdFromTmpUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * trs_trsp_svc_ord_prv_tmp 의 데이터로 trsp_trsp_svc_ord update
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOAddWorkOrderPreviewSvcOrdFromTmpUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pkup_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_instr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtn_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_dflt_vndr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_wy_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_kgs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nomi_trkr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("etc_add_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_lbs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rjct_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fctry_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_wgt_scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_bl_no_iss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_frst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntc_pson_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOAddWorkOrderPreviewSvcOrdFromTmpUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("    WO_BL_NO_ISS_FLG        = @[wo_bl_no_iss_flg]" ).append("\n"); 
		query.append("    , DTN_USE_FLG           = @[dtn_use_flg] " ).append("\n"); 
		query.append("    , CURR_CD               = @[curr_cd] " ).append("\n"); 
		query.append("    , BZC_AMT               = @[bzc_amt] " ).append("\n"); 
		query.append("    , NEGO_AMT              = @[nego_amt] " ).append("\n"); 
		query.append("    , ETC_ADD_AMT           = @[etc_add_amt] " ).append("\n"); 
		query.append("    , FUEL_SCG_AMT          = @[fuel_scg_amt] " ).append("\n"); 
		query.append("    , OVR_WGT_SCG_AMT       = @[ovr_wgt_scg_amt] " ).append("\n"); 
		query.append("    , N3PTY_BIL_FLG         = @[n3pty_bil_flg]" ).append("\n"); 
		query.append("    , CUST_CNT_CD           = @[cust_cnt_cd] " ).append("\n"); 
		query.append("    , CUST_SEQ              = @[cust_seq] " ).append("\n"); 
		query.append("    , CUST_NOMI_TRKR_FLG    = @[cust_nomi_trkr_flg] " ).append("\n"); 
		query.append("    , TRSP_AGMT_RT_TP_CD    = @[trsp_agmt_rt_tp_cd] " ).append("\n"); 
		query.append("    , TRSP_AGMT_WY_TP_CD    = @[trsp_agmt_wy_tp_cd] " ).append("\n"); 
		query.append("    , TRSP_FRST_FLG         = @[trsp_frst_flg] " ).append("\n"); 
		query.append("    , TRSP_RJCT_RSN_CD      = @[trsp_rjct_rsn_cd] " ).append("\n"); 
		query.append("    , TRSP_DFLT_VNDR_FLG    = @[trsp_dflt_vndr_flg] " ).append("\n"); 
		query.append("    , N1ST_NOD_PLN_DT       = TO_DATE(@[n1st_nod_pln_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("    , LST_NOD_PLN_DT        = TO_DATE(@[lst_nod_pln_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("    , DOR_NOD_PLN_DT        = TO_DATE(@[dor_nod_pln_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("    , INTER_RMK             = DECODE(@[cgo_tp_cd], 'M', @[inter_rmk], '')" ).append("\n"); 
		query.append("    , SPCL_INSTR_RMK        = @[spcl_instr_rmk]" ).append("\n"); 
		query.append("    , FCTRY_NM              = @[fctry_nm]" ).append("\n"); 
		query.append("    , DOR_PST_CD            = @[dor_pst_cd]" ).append("\n"); 
		query.append("    , CNTC_PSON_PHN_NO      = @[cntc_pson_phn_no]" ).append("\n"); 
		query.append("    , CNTC_PSON_FAX_NO      = @[cntc_pson_fax_no]" ).append("\n"); 
		query.append("    , CNTC_PSON_NM          = @[cntc_pson_nm]" ).append("\n"); 
		query.append("    , VSL_CD = (" ).append("\n"); 
		query.append("                SELECT DECODE(VSL_CD, NULL, 'CNTC', VSL_CD)" ).append("\n"); 
		query.append("                FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("                WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                    AND TRSP_SO_SEQ = @[trsp_so_seq] )" ).append("\n"); 
		query.append("    , SKD_VOY_NO = (" ).append("\n"); 
		query.append("                    SELECT " ).append("\n"); 
		query.append("                        CASE WHEN A.TRSP_SO_TP_CD = 'O' AND A.CGO_TP_CD = 'F' " ).append("\n"); 
		query.append("                                THEN DECODE(A.VSL_CD, NULL, A.TRSP_OTR_COST_MON_DT, A.TRSP_OTR_COST_MON_DT) " ).append("\n"); 
		query.append("                        ELSE DECODE(A.VSL_CD, NULL, TO_CHAR(B.LOCL_CRE_DT, 'YYMM'), A.SKD_VOY_NO) " ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                    FROM TRS_TRSP_SVC_ORD A, TRS_TRSP_WRK_ORD B" ).append("\n"); 
		query.append("                    WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                        AND A.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("                        AND A.TRSP_WO_OFC_CTY_CD = B.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("                        AND A.TRSP_WO_SEQ = B.TRSP_WO_SEQ )" ).append("\n"); 
		query.append("    , SKD_DIR_CD = (" ).append("\n"); 
		query.append("                    SELECT DECODE(VSL_CD, NULL, 'M', SKD_DIR_CD)" ).append("\n"); 
		query.append("                    FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("                    WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                        AND TRSP_SO_SEQ = @[trsp_so_seq] ) " ).append("\n"); 
		query.append("    , N3PTY_BIL_BZC_AMT		= @[n3pty_bil_bzc_amt] " ).append("\n"); 
		query.append("    , N3PTY_VNDR_SEQ		= @[n3pty_vndr_seq] " ).append("\n"); 
		query.append("    , N3PTY_OFC_CD          = @[n3pty_ofc_cd] " ).append("\n"); 
		query.append("    , N3PTY_DESC            = @[n3pty_desc] " ).append("\n"); 
		query.append("    , N3PTY_CUST_SEQ        = @[n3pty_cust_seq] " ).append("\n"); 
		query.append("    , N3PTY_CUST_CNT_CD     = @[n3pty_cust_cnt_cd] " ).append("\n"); 
		query.append("    , N3PTY_BIL_TP_CD       = @[n3pty_bil_tp_cd] " ).append("\n"); 
		query.append("    , N3PTY_CURR_CD         = @[n3pty_curr_cd]" ).append("\n"); 
		query.append("    , WGT_MEAS_UT_CD        = @[wgt_meas_ut_cd] " ).append("\n"); 
		query.append("    , CNTR_KGS_WGT          = @[cntr_kgs_wgt] " ).append("\n"); 
		query.append("    , CNTR_LBS_WGT          = @[cntr_lbs_wgt] " ).append("\n"); 
		query.append("	, CNTR_WGT				= DECODE(@[wgt_meas_ut_cd], 'KGS', @[cntr_kgs_wgt], @[cntr_lbs_wgt])" ).append("\n"); 
		query.append("	, CNTR_PKUP_NO          = @[cntr_pkup_no] " ).append("\n"); 
		query.append("    , SCG_IND_CD            = @[scg_ind_cd]" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD    = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("    AND TRSP_SO_SEQ         = @[trsp_so_seq]" ).append("\n"); 

	}
}