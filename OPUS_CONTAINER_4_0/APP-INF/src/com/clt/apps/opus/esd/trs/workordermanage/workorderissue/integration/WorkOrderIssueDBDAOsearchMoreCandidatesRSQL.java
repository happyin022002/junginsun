/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderIssueDBDAOsearchMoreCandidatesRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		params.put("crr_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tp_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wgt_uom",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_vndr_prmry_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("via_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("     TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	,TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("    ,TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("    ,TRSP_AGMT_OFC_CTY_CD||TRSP_AGMT_SEQ AS AGMT_NO" ).append("\n"); 
		query.append("	,WAY_TYPE" ).append("\n"); 
		query.append("	,DECODE(VNDR_TP_CD, 'COM', 'NYK', VNDR_TP_CD) VNDR_TP_CD" ).append("\n"); 
		query.append("	,VNDR_SEQ" ).append("\n"); 
		query.append("	,VNDR_NM" ).append("\n"); 
		query.append("	,RJT_HIST" ).append("\n"); 
		query.append("    ,AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("    ,DECODE(TRSP_BND_CD, '0', NULL, TRSP_BND_CD) AS TRSP_BND_CD" ).append("\n"); 
		query.append("    ,SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("    ,DECODE(CMDT_GRP_CD, 'XXXX', NULL, CMDT_GRP_CD) CMDT_GRP_CD" ).append("\n"); 
		query.append("    ,TRSP_AGMT_EQ_TP_SZ_CD" ).append("\n"); 
		query.append("    ,USR_DEF_RMK" ).append("\n"); 
		query.append("	,CURR_CD" ).append("\n"); 
		query.append("	,BASIC_RATE" ).append("\n"); 
		query.append("	,WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("	,WTR_DE_TERM_CD" ).append("\n"); 
		query.append("    ,DECODE(TO_WGT, 999999.99, 'MAX', TO_WGT) TO_WGT" ).append("\n"); 
		query.append("    ,DECODE(WGT_MEAS_UT_CD, 'XXX', '', WGT_MEAS_UT_CD) WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("	,TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("	,TRSP_AGMT_RT_TP_NM" ).append("\n"); 
		query.append("	,CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("	,CUST_CD" ).append("\n"); 
		query.append("--  UI에서 선택한 것을 세팅하도록 변경 요청 2015.07.07" ).append("\n"); 
		query.append("	,0 AS FUEL_SCG_RT" ).append("\n"); 
		query.append("    ,0 AS VAT_SCG_RT" ).append("\n"); 
		query.append("	,TOT_AMOUNT" ).append("\n"); 
		query.append("	,TOT_USD_AMOUNT" ).append("\n"); 
		query.append("	,DECODE(SEQ_, 'ZZZZZZ', TO_CHAR(SEQ), SEQ_) SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT Y.*" ).append("\n"); 
		query.append("		  ,ROW_NUMBER() OVER(PARTITION BY SEQ_ ORDER BY VNDR_SEQ) SEQ " ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("			SELECT DISTINCT X.*" ).append("\n"); 
		query.append("			      ,(BASIC_RATE)    TOT_AMOUNT" ).append("\n"); 
		query.append("			      ,(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(CURR_CD, BASIC_RATE)) TOT_USD_AMOUNT" ).append("\n"); 
		query.append("			      ,CASE WHEN VNDR_SEQ = @[vndr_seq] AND TRSP_AGMT_OFC_CTY_CD = @[trsp_agmt_ofc_cty_cd] AND TRSP_AGMT_SEQ = @[trsp_agmt_seq]" ).append("\n"); 
		query.append("					    THEN 'Preset'" ).append("\n"); 
		query.append("					    ELSE 'ZZZZZZ'" ).append("\n"); 
		query.append("			       END SEQ_" ).append("\n"); 
		query.append("			  FROM TABLE( TRS_AGMT_RATE_MORE_PKG.GET_MORE_CANDIDATES_LIST_FNC(" ).append("\n"); 
		query.append("						      @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("						     ,@[trsp_so_seq]" ).append("\n"); 
		query.append("						     ,@[ctrl_ofc_cd]" ).append("\n"); 
		query.append("						     ,@[vndr_seq]" ).append("\n"); 
		query.append("						     ,@[basis_dt]" ).append("\n"); 
		query.append("						     ,NULL" ).append("\n"); 
		query.append("						     ,@[eq_knd_cd]" ).append("\n"); 
		query.append("						     ,@[eq_tp_sz_cd]" ).append("\n"); 
		query.append("						     ,@[cmb_tp_cd]" ).append("\n"); 
		query.append("						     ,@[cgo_tp_cd]" ).append("\n"); 
		query.append("						     ,@[bound_cd]" ).append("\n"); 
		query.append("						     ,@[crr_mod_cd]" ).append("\n"); 
		query.append("						     ,@[cost_mod_cd]" ).append("\n"); 
		query.append("						     ,NULL" ).append("\n"); 
		query.append("						     ,@[cmdt_cd]" ).append("\n"); 
		query.append("						     ,@[from_nod_cd]" ).append("\n"); 
		query.append("						     ,@[via_nod_cd]" ).append("\n"); 
		query.append("						     ,@[door_nod_cd]" ).append("\n"); 
		query.append("						     ,@[to_nod_cd]" ).append("\n"); 
		query.append("						     ,@[bundle_cnt]" ).append("\n"); 
		query.append("						     ,@[wgt_uom]" ).append("\n"); 
		query.append("						     ,@[wgt_qty]" ).append("\n"); 
		query.append("						     ,'N'" ).append("\n"); 
		query.append("						   )" ).append("\n"); 
		query.append("			        ) X" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("#if(${bound_cd} == 'T')" ).append("\n"); 
		query.append("                AND (X.TRSP_BND_CD IS NULL OR X.TRSP_BND_CD IN ('Y','0'))" ).append("\n"); 
		query.append("#else                     -- TRSP_BND_CD : not T(I,O,NULL)" ).append("\n"); 
		query.append("                AND (X.TRSP_BND_CD IS NULL OR X.TRSP_BND_CD IN ('N','0'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${fm_vndr_prmry_seq} != '')" ).append("\n"); 
		query.append("				AND VNDR_SEQ = @[fm_vndr_prmry_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${spcl_cgo_cntr_tp_cd} != '')" ).append("\n"); 
		query.append("                AND (X.SPCL_CGO_CNTR_TP_CD IS NULL OR X.SPCL_CGO_CNTR_TP_CD = @[spcl_cgo_cntr_tp_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			) Y" ).append("\n"); 
		query.append("	) T" ).append("\n"); 
		query.append("ORDER BY SEQ_, SEQ" ).append("\n"); 

	}
}