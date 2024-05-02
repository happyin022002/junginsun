/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : WorkOrderIssueDBDAOsearchMoreCandidatesRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOsearchMoreCandidatesRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMoreCandidates
	  * </pre>
	  */
	public WorkOrderIssueDBDAOsearchMoreCandidatesRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_uom",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("via_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmb_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("way_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bundle_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("basis_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("door_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tp_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOsearchMoreCandidatesRSQL").append("\n"); 
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
		query.append("SELECT X.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	  ,X.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("      ,X.TRSP_AGMT_OFC_CTY_CD||X.TRSP_AGMT_SEQ AGMT_NO" ).append("\n"); 
		query.append("	  ,X.WAY_TYPE" ).append("\n"); 
		query.append("	  ,X.VNDR_TP_CD" ).append("\n"); 
		query.append("	  ,X.VNDR_SEQ" ).append("\n"); 
		query.append("	  ,X.VNDR_NM" ).append("\n"); 
		query.append("	  ,X.RJT_HIST" ).append("\n"); 
		query.append("	  ,X.CURR_CD" ).append("\n"); 
		query.append("	  ,X.BASIC_RATE" ).append("\n"); 
		query.append("	  ,X.WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("	  ,X.WTR_DE_TERM_CD" ).append("\n"); 
		query.append("	  ,X.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("	  ,X.TRSP_AGMT_RT_TP_NM" ).append("\n"); 
		query.append("	  ,X.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("	  ,X.CUST_CD" ).append("\n"); 
		query.append("	  ,X.FUEL_SCG_RT" ).append("\n"); 
		query.append("	  ,X.VAT_SCG_RT" ).append("\n"); 
		query.append("	  ,X.TOLL_FEE_RT" ).append("\n"); 
		query.append("	  ,X.TRSP_AGMT_RT_SEQ" ).append("\n"); 
		query.append("	  ,X.CFM_FLG" ).append("\n"); 
		query.append("	  ,X.TRSP_AGMT_UPD_DT" ).append("\n"); 
		query.append("      ,(BASIC_RATE+NVL(FUEL_SCG_RT,0)+NVL(VAT_SCG_RT,0)+NVL(TOLL_FEE_RT,0))    TOT_AMOUNT" ).append("\n"); 
		query.append("      ,(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD, (BASIC_RATE+NVL(FUEL_SCG_RT,0)+NVL(VAT_SCG_RT,0)+NVL(TOLL_FEE_RT,0)))) TOT_USD_AMOUNT" ).append("\n"); 
		query.append("      ,CASE WHEN VNDR_SEQ = @[vndr_seq] THEN 'Preset'" ).append("\n"); 
		query.append("            ELSE " ).append("\n"); 
		query.append("            TO_CHAR(RANK() OVER(ORDER BY (TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD, (BASIC_RATE+NVL(FUEL_SCG_RT,0)+NVL(VAT_SCG_RT,0)+NVL(TOLL_FEE_RT,0)))) ASC))" ).append("\n"); 
		query.append("       END SEQ" ).append("\n"); 
		query.append("      ,NVL((SELECT HZD_MTRL_FLG" ).append("\n"); 
		query.append("	          FROM TRS_SPCL_CGO_AVAL_SVC_PROV" ).append("\n"); 
		query.append("    	     WHERE VNDR_SEQ = X.VNDR_SEQ" ).append("\n"); 
		query.append("        	   AND SO_CRE_OFC_CD = @[ctrl_ofc_cd]" ).append("\n"); 
		query.append("           	   AND ROWNUM =1 ),'N') HZD_MTRL_FLG" ).append("\n"); 
		query.append("      ,NVL((SELECT OVWT_TRI_AXL_FLG" ).append("\n"); 
		query.append("              FROM TRS_SPCL_CGO_AVAL_SVC_PROV" ).append("\n"); 
		query.append("             WHERE VNDR_SEQ = X.VNDR_SEQ" ).append("\n"); 
		query.append("               AND SO_CRE_OFC_CD = @[ctrl_ofc_cd]" ).append("\n"); 
		query.append("               AND ROWNUM =1 ),'N') OVWT_TRI_AXL_FLG" ).append("\n"); 
		query.append("	  ,X.EFF_FM_DT" ).append("\n"); 
		query.append("	  ,X.EFF_TO_DT" ).append("\n"); 
		query.append("      ,X.AGMT_REF_NO" ).append("\n"); 
		query.append("	  ,NVL((SELECT MAX(USR_NM) FROM COM_USER A WHERE A.USR_ID = X.TRSP_AGMT_UPD_USR_ID), X.TRSP_AGMT_UPD_USR_ID) TRSP_AGMT_UPD_USR_ID" ).append("\n"); 
		query.append("	  ,RANK() OVER(ORDER BY (TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD, (BASIC_RATE+NVL(FUEL_SCG_RT,0)+NVL(VAT_SCG_RT,0)+NVL(TOLL_FEE_RT,0)))) ASC) RANK_AMT" ).append("\n"); 
		query.append("  FROM TABLE( TRS_AGMT_RATE_MORE_PKG.GET_MORE_CANDIDATES_LIST_FNC(" ).append("\n"); 
		query.append("              @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("             ,@[trsp_so_seq]" ).append("\n"); 
		query.append("             ,@[ctrl_ofc_cd]" ).append("\n"); 
		query.append("             ,@[vndr_seq]" ).append("\n"); 
		query.append("             ,@[basis_dt]" ).append("\n"); 
		query.append("             ,@[way_tp_cd]" ).append("\n"); 
		query.append("             ,@[eq_knd_cd]" ).append("\n"); 
		query.append("             ,@[eq_tp_sz_cd]" ).append("\n"); 
		query.append("             ,@[cmb_tp_cd]" ).append("\n"); 
		query.append("             ,@[cgo_tp_cd]" ).append("\n"); 
		query.append("             ,@[bound_cd]" ).append("\n"); 
		query.append("             ,@[crr_mod_cd]" ).append("\n"); 
		query.append("             ,@[cost_mod_cd]" ).append("\n"); 
		query.append("             ,NULL" ).append("\n"); 
		query.append("             ,@[cmdt_cd]" ).append("\n"); 
		query.append("             ,@[from_nod_cd]" ).append("\n"); 
		query.append("             ,@[via_nod_cd]" ).append("\n"); 
		query.append("             ,@[door_nod_cd]" ).append("\n"); 
		query.append("             ,@[to_nod_cd]" ).append("\n"); 
		query.append("             ,@[bundle_cnt]" ).append("\n"); 
		query.append("             ,@[wgt_uom]" ).append("\n"); 
		query.append("             ,@[wgt_qty]" ).append("\n"); 
		query.append("             ,@[cust_cnt_cd]||@[cust_seq]" ).append("\n"); 
		query.append("             ,'N'" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("       ) X" ).append("\n"); 
		query.append("#if(${mlt_mor_ony_flg} == 'Y')" ).append("\n"); 
		query.append("	WHERE X.VNDR_TP_CD = 'HJS'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}