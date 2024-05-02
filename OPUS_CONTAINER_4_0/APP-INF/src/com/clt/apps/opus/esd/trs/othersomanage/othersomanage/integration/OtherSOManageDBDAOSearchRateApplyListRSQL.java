/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OtherSOManageDBDAOSearchRateApplyListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.06
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.07.06 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.othersomanage.othersomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OtherSOManageDBDAOSearchRateApplyListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for SO Other Rate Apply
	  * </pre>
	  */
	public OtherSOManageDBDAOSearchRateApplyListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_RTN_MSG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_BASIC_RT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_CUST_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_TRSP_AGMT_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_TRSP_AGMT_OFC_CTY_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_CUST_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_CTRL_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DATE + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_BASIS_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_CMB_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_TO_NOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_WGT_UOM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_EQ_KND_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_CUST_NOMI_TRKR_FLG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_CMDT_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_WAY_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_OVER_WGT_SCG_RT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_TRSP_AGMT_RT_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_WTR_DE_TERM_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_BUNDLE_CNT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_CUST_CNT_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_CUST_NOMI_TRKR_FLG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_WTR_RCV_TERM_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_EQ_TP_SZ_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_WAY_TYPE",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_CRR_MOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_DOOR_NOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_LOCAL_CURR_TOT_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_CGO_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_VIA_NOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_WGT_QTY",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_FROM_NOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_SP_TYPE",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_TTL_SCG_RT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_RAIL_SVC_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_CUST_CNT_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_LOCAL_CURR_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_USD_CURR_TOT_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_COST_MOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_RTN_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_SPCL_CGO_CNTR_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_FUEL_SCG_RT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_HZS_SCG_RT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PI_BOUND_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PO_TRSP_AGMT_RT_TP_NM",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.othersomanage.othersomanage.integration").append("\n"); 
		query.append("FileName : OtherSOManageDBDAOSearchRateApplyListRSQL").append("\n"); 
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
		query.append("{CALL TRS_AGMT_RATE_CC_PKG.GET_TRS_ALL_RATE_PRC(" ).append("\n"); 
		query.append(" 'TRS'                        /*  1   */" ).append("\n"); 
		query.append(",@[PI_CTRL_OFC_CD]            /*  2   */" ).append("\n"); 
		query.append(",@[PI_VNDR_SEQ]               /*  3   */" ).append("\n"); 
		query.append(",@[PI_BASIS_DT]               /*  4   */ " ).append("\n"); 
		query.append(",@[PI_WAY_TP_CD]              /*  5   */" ).append("\n"); 
		query.append(",@[PI_EQ_KND_CD]              /*  6   */" ).append("\n"); 
		query.append(",@[PI_EQ_TP_SZ_CD]            /*  7   */" ).append("\n"); 
		query.append(",@[PI_CMB_TP_CD]              /*  8   */" ).append("\n"); 
		query.append(",@[PI_CGO_TP_CD]              /*  9   */" ).append("\n"); 
		query.append(",@[PI_BOUND_CD]               /*  10   */" ).append("\n"); 
		query.append(",@[PI_CRR_MOD_CD]             /*  11   */" ).append("\n"); 
		query.append(",@[PI_COST_MOD_CD]            /*  12   */" ).append("\n"); 
		query.append(",@[PI_CUST_NOMI_TRKR_FLG]     /*  13   */" ).append("\n"); 
		query.append(",@[PI_CUST_CNT_CD]            /*  14   */" ).append("\n"); 
		query.append(",@[PI_CUST_SEQ]               /*  15   */" ).append("\n"); 
		query.append(",@[PI_RAIL_SVC_TP_CD]         /*  16   */      " ).append("\n"); 
		query.append(",@[PI_CMDT_CD]                /*  17   */ " ).append("\n"); 
		query.append(",@[PI_FROM_NOD_CD]            /*  18   */" ).append("\n"); 
		query.append(",@[PI_VIA_NOD_CD]             /*  19   */ " ).append("\n"); 
		query.append(",@[PI_DOOR_NOD_CD]            /*  20   */  " ).append("\n"); 
		query.append(",@[PI_TO_NOD_CD]              /*  21   */ " ).append("\n"); 
		query.append(",@[PI_BUNDLE_CNT]             /*  22   */" ).append("\n"); 
		query.append(",@[PI_WGT_UOM]                /*  23   */" ).append("\n"); 
		query.append(",@[PI_WGT_QTY]                /*  24   */" ).append("\n"); 
		query.append(",''                           /* pi_rcv_term */" ).append("\n"); 
		query.append(",''                           /* pi_de_term */" ).append("\n"); 
		query.append(",''                           /* pi_trsp_agmt_ofc_cty_cd */" ).append("\n"); 
		query.append(",''                           /* pi_trsp_agmt_seq */" ).append("\n"); 
		query.append(",@[PI_SPCL_CGO_CNTR_TP_CD]    /* pi_spcl_cgo_cd */" ).append("\n"); 
		query.append(",'N'                          /* pi_debug_flg */" ).append("\n"); 
		query.append("/* OUT PARAMETER */" ).append("\n"); 
		query.append(",@[PO_TRSP_AGMT_OFC_CTY_CD]   /*  1   */" ).append("\n"); 
		query.append(",@[PO_TRSP_AGMT_SEQ]          /*  2   */" ).append("\n"); 
		query.append(",@[PO_TRSP_AGMT_RT_TP_CD]     /*  3   */" ).append("\n"); 
		query.append(",@[PO_WAY_TYPE]               /*  4   */ " ).append("\n"); 
		query.append(",@[PO_TRSP_AGMT_RT_TP_NM]     /*  5   */" ).append("\n"); 
		query.append(",@[PO_SP_TYPE]                /*  6   */" ).append("\n"); 
		query.append(",@[PO_CUST_NOMI_TRKR_FLG]     /*  7   */ " ).append("\n"); 
		query.append(",@[PO_CUST_CNT_CD]            /*  8   */" ).append("\n"); 
		query.append(",@[PO_CUST_SEQ]               /*  9   */" ).append("\n"); 
		query.append(",@[PO_LOCAL_CURR_CD]          /*  10   */" ).append("\n"); 
		query.append(",@[PO_BASIC_RT]               /*  11   */" ).append("\n"); 
		query.append(",@[PO_FUEL_SCG_RT]            /*  12   */" ).append("\n"); 
		query.append(",@[PO_OVER_WGT_SCG_RT]        /*  13   */" ).append("\n"); 
		query.append(",@[PO_HZS_SCG_RT]             /*  NEW - USA RAIL ONLY */" ).append("\n"); 
		query.append(",@[PO_TTL_SCG_RT]             /*  NEW - USA RAIL ONLY */" ).append("\n"); 
		query.append(",@[PO_LOCAL_CURR_TOT_AMT]     /*  14   */" ).append("\n"); 
		query.append(",@[PO_USD_CURR_TOT_AMT]       /*  15   */" ).append("\n"); 
		query.append(",@[PO_WTR_RCV_TERM_CD]        /*  NEW - COA APPLY ONLY */" ).append("\n"); 
		query.append(",@[PO_WTR_DE_TERM_CD]         /*  NEW - COA APPLY ONLY */" ).append("\n"); 
		query.append(",@[PO_RTN_CD]                 /*  16   */" ).append("\n"); 
		query.append(",@[PO_RTN_MSG])}              /*  17   */" ).append("\n"); 

	}
}