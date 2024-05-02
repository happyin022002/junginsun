/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusReportDBDAOSearchBLStatusListSummary1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchBLStatusListSummary1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchBLStatusListSummary1RSQL
	  * </pre>
	  */
	public StatusReportDBDAOSearchBLStatusListSummary1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd_f",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ro_y",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_rep_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("board_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctr_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cargo_tp_f",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd_a",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eta_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fv_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fv_pol_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cargo_tp_p",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("b_staff_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cargo_tp_r",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agent_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("board_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("l_team_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("certi_g",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fv_pod_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("certi_b",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("certi_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("certi_d",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("l_rep_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("certi_a",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("l_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd_w",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fv_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fv_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rate_check",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd_x",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBLStatusListSummary1RSQL").append("\n"); 
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
		query.append("                  SUM(F_BKG_QTY) OVER( PARTITION BY ORDERBY_TITLE ) AS SUB_F_BKG_QTY" ).append("\n"); 
		query.append("                , SUM(F_TEU)     OVER( PARTITION BY ORDERBY_TITLE ) AS SUB_F_TEU" ).append("\n"); 
		query.append("                , SUM(P_BKG_QTY) OVER( PARTITION BY ORDERBY_TITLE ) AS SUB_P_BKG_QTY" ).append("\n"); 
		query.append("                , SUM(P_TEU)     OVER( PARTITION BY ORDERBY_TITLE ) AS SUB_P_TEU" ).append("\n"); 
		query.append("                , SUM(R_BKG_QTY) OVER( PARTITION BY ORDERBY_TITLE ) AS SUB_R_BKG_QTY" ).append("\n"); 
		query.append("                , SUM(R_TEU)     OVER( PARTITION BY ORDERBY_TITLE ) AS SUB_R_TEU" ).append("\n"); 
		query.append("                , SUM(T_BKG_QTY) OVER( PARTITION BY ORDERBY_TITLE ) AS SUB_T_BKG_QTY" ).append("\n"); 
		query.append("                , SUM(T_TEU)     OVER( PARTITION BY ORDERBY_TITLE ) AS SUB_T_TEU" ).append("\n"); 
		query.append("                , SUM(BKG_CNT)   OVER( PARTITION BY ORDERBY_TITLE ) AS SUB_BKG_CNT" ).append("\n"); 
		query.append("                , SUM(F_BKG_QTY) OVER() AS GRD_F_BKG_QTY" ).append("\n"); 
		query.append("                , SUM(F_TEU)     OVER() AS GRD_F_TEU" ).append("\n"); 
		query.append("                , SUM(P_BKG_QTY) OVER() AS GRD_P_BKG_QTY" ).append("\n"); 
		query.append("                , SUM(P_TEU)     OVER() AS GRD_P_TEU" ).append("\n"); 
		query.append("                , SUM(R_BKG_QTY) OVER() AS GRD_R_BKG_QTY" ).append("\n"); 
		query.append("                , SUM(R_TEU)     OVER() AS GRD_R_TEU" ).append("\n"); 
		query.append("                , SUM(T_BKG_QTY) OVER() AS GRD_T_BKG_QTY" ).append("\n"); 
		query.append("                , SUM(T_TEU)     OVER() AS GRD_T_TEU" ).append("\n"); 
		query.append("                , SUM(BKG_CNT)   OVER() AS GRD_BKG_CNT   " ).append("\n"); 
		query.append("				, Y.*	" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("                    SUM(DECODE(BKG_CGO_TP_CD, 'F', 1, 0) * OP_CNTR_QTY)                  AS F_BKG_QTY" ).append("\n"); 
		query.append("                   ,SUM(DECODE(BKG_CGO_TP_CD, 'F'," ).append("\n"); 
		query.append("                        DECODE(SUBSTR(TP_SZ,-1),'2',OP_CNTR_QTY,OP_CNTR_QTY*2)" ).append("\n"); 
		query.append("                        ,0))                                                             AS F_TEU" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                   ,SUM(DECODE(BKG_CGO_TP_CD, 'P', 1, 0) * OP_CNTR_QTY)                  AS P_BKG_QTY" ).append("\n"); 
		query.append("                   ,SUM(DECODE(BKG_CGO_TP_CD, 'P'," ).append("\n"); 
		query.append("                        DECODE(SUBSTR(TP_SZ,-1),'2',OP_CNTR_QTY,OP_CNTR_QTY*2)" ).append("\n"); 
		query.append("                        ,0))                                                             AS P_TEU" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                   ,SUM(DECODE(BKG_CGO_TP_CD, 'R', 1, 0) * OP_CNTR_QTY)                  AS R_BKG_QTY" ).append("\n"); 
		query.append("                   ,SUM(DECODE(BKG_CGO_TP_CD, 'R'," ).append("\n"); 
		query.append("                        DECODE(SUBSTR(TP_SZ,-1),'2',OP_CNTR_QTY,OP_CNTR_QTY*2)" ).append("\n"); 
		query.append("                        ,0))                                                             AS R_TEU" ).append("\n"); 
		query.append("                             " ).append("\n"); 
		query.append("                  ,SUM(OP_CNTR_QTY)                                                      AS T_BKG_QTY" ).append("\n"); 
		query.append("                  ,SUM(" ).append("\n"); 
		query.append("                        DECODE(SUBSTR(TP_SZ,-1),'2',OP_CNTR_QTY,OP_CNTR_QTY*2)" ).append("\n"); 
		query.append("                        )                                                                AS T_TEU" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                  ,COUNT(DISTINCT BKG_NO )                                               AS BKG_CNT                 " ).append("\n"); 
		query.append("              , ORDERBY_TITLE" ).append("\n"); 
		query.append("			  , TP_SZ" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("				SELECT ${orderby_title_sql} AS ORDERBY_TITLE" ).append("\n"); 
		query.append("                       , K.*" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                    SELECT /*+ RULE */" ).append("\n"); 
		query.append("                           			 DISTINCT" ).append("\n"); 
		query.append("                           			 NVL(BKG_QTY.CNTR_TPSZ_CD, 'Not Match') AS TP_SZ" ).append("\n"); 
		query.append("                                   , VB.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                                   , BKG_QTY.OP_CNTR_QTY" ).append("\n"); 
		query.append("                                   , VB.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    /****************** FOR SORT START *****************/" ).append("\n"); 
		query.append("                                 , VB.SPLIT_FLG" ).append("\n"); 
		query.append("                                 , VB.BKG_STS_CD AS BST_FLG" ).append("\n"); 
		query.append("                                 , VB.BDR_FLG AS BDR_FLG" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                                 /* BL_NO */" ).append("\n"); 
		query.append("                                ,VB.BL_NO||VB.BL_TP_CD AS BL_NO" ).append("\n"); 
		query.append("                                , REPLACE(VB.SHPR_NAME,CHR(13)||CHR(10),' ') AS SHPR_NAME" ).append("\n"); 
		query.append("                                , VB.CUST_TO_ORD_FLG AS CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                                , REPLACE(VB.CONSIGNEE_NAME,CHR(13)||CHR(10),' ') AS CONSIGNEE_NAME" ).append("\n"); 
		query.append("                                , REPLACE(VB.NTFY_NAME,CHR(13)||CHR(10),' ') AS NTFY_NAME" ).append("\n"); 
		query.append("                                , VB.CMDT_CD         AS COMMODITY" ).append("\n"); 
		query.append("                                , VB.REP_CMDT_CD     AS REP" ).append("\n"); 
		query.append("                                , NVL(VB.PCK_QTY,0)     AS PCK_QTY" ).append("\n"); 
		query.append("                                , VB.PCK_TP_CD  AS PCK_TP_CD" ).append("\n"); 
		query.append("                                  /* R */" ).append("\n"); 
		query.append("                                , VB.RCV_TERM_CD     AS RCV_TERM_CD" ).append("\n"); 
		query.append("                                  /* D */" ).append("\n"); 
		query.append("                                , VB.DE_TERM_CD      AS DE_TERM_CD" ).append("\n"); 
		query.append("                                  /* BKG STF */" ).append("\n"); 
		query.append("                                , VB.DOC_USR_ID   AS BKG_STF" ).append("\n"); 
		query.append("                                  /* SREP */" ).append("\n"); 
		query.append("                                , VB.OB_SREP_CD AS OB_SREP_CD" ).append("\n"); 
		query.append("                                  /* BKG OFC */" ).append("\n"); 
		query.append("                                , VB.BKG_OFC_CD AS BKG_OFC_CD" ).append("\n"); 
		query.append("                                  /* S/OFC */" ).append("\n"); 
		query.append("                                , VB.OB_SLS_OFC_CD OB_SLS_OFC_CD" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("                                , VB.TRUNK_VVD TRUNK_VVD" ).append("\n"); 
		query.append("                                , VB.ORG_TRNS_SVC_MOD_CD    AS ORG_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append("                                , VB.DEST_TRNS_SVC_MOD_CD   AS DEST_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append("                                , VB.ORG_SCONTI_CD          AS ORG_SVC_ROUTE" ).append("\n"); 
		query.append("                                , VB.DEST_SCONTI_CD         AS DEST_SVC_ROUTE" ).append("\n"); 
		query.append("                                , VB.KEY_POL_CD           AS POL_CD" ).append("\n"); 
		query.append("                                , VB.KEY_POD_CD           AS POD_CD" ).append("\n"); 
		query.append("                                , VB.PRE_1_VVD        AS PRE_1_VVD" ).append("\n"); 
		query.append("                                , VB.PRE_2_VVD        AS PRE_2_VVD" ).append("\n"); 
		query.append("                                , VB.PRE_3_VVD        AS PRE_3_VVD" ).append("\n"); 
		query.append("                                , VB.PRE_4_VVD        AS PRE_4_VVD" ).append("\n"); 
		query.append("                                , VB.POST_1_VVD       AS POST_1_VVD" ).append("\n"); 
		query.append("                                , VB.POST_2_VVD       AS POST_2_VVD" ).append("\n"); 
		query.append("                                , VB.POST_3_VVD       AS POST_3_VVD" ).append("\n"); 
		query.append("                                , VB.POST_4_VVD       AS POST_4_VVD" ).append("\n"); 
		query.append("                                , VB.PRE_1_POL_CD     AS PRE_1_POL_CD" ).append("\n"); 
		query.append("                                , VB.PRE_2_POL_CD     AS PRE_2_POL_CD" ).append("\n"); 
		query.append("                                , VB.PRE_3_POL_CD     AS PRE_3_POL_CD" ).append("\n"); 
		query.append("                                , VB.PRE_4_POL_CD     AS PRE_4_POL_CD" ).append("\n"); 
		query.append("                                , VB.PRE_1_POD_CD     AS PRE_1_POD_CD" ).append("\n"); 
		query.append("                                , VB.PRE_2_POD_CD     AS PRE_2_POD_CD" ).append("\n"); 
		query.append("                                , VB.PRE_3_POD_CD     AS PRE_3_POD_CD" ).append("\n"); 
		query.append("                                , VB.PRE_4_POD_CD     AS PRE_4_POD_CD" ).append("\n"); 
		query.append("                                , VB.POST_1_POL_CD    AS POST_1_POL_CD" ).append("\n"); 
		query.append("                                , VB.POST_2_POL_CD    AS POST_2_POL_CD" ).append("\n"); 
		query.append("                                , VB.POST_3_POL_CD    AS POST_3_POL_CD" ).append("\n"); 
		query.append("                                , VB.POST_4_POL_CD    AS POST_4_POL_CD" ).append("\n"); 
		query.append("                                , VB.POST_1_POD_CD    AS POST_1_POD_CD" ).append("\n"); 
		query.append("                                , VB.POST_2_POD_CD    AS POST_2_POD_CD" ).append("\n"); 
		query.append("                                , VB.POST_3_POD_CD    AS POST_3_POD_CD" ).append("\n"); 
		query.append("                                , VB.POST_4_POD_CD    AS POST_4_POD_CD" ).append("\n"); 
		query.append("                                , VB.SI_FLG          AS SI_FLG" ).append("\n"); 
		query.append("                                , VB.BKG_CLZ_FLG      AS BKG_CLZ_FLG" ).append("\n"); 
		query.append("                                , VB.ANTY_NAME        AS ANTY_NAME" ).append("\n"); 
		query.append("                                , VB.FFDR_NAME        AS FFDR_NAME" ).append("\n"); 
		query.append("                                , VB.EXPT_NAME        AS EXPT_NAME" ).append("\n"); 
		query.append("                                , VB.HNGR_FLG         AS HNGR_FLG" ).append("\n"); 
		query.append("                                  /* AK */" ).append("\n"); 
		query.append("                                , VB.AWK_CGO_FLG      AS AWK_CGO_FLG" ).append("\n"); 
		query.append("                                  /* HT */" ).append("\n"); 
		query.append("                                , VB.HOT_DE_FLG       AS HOT_DE_FLG" ).append("\n"); 
		query.append("                                  /* RC */" ).append("\n"); 
		query.append("                                , VB.RC_FLG           AS RC_FLG" ).append("\n"); 
		query.append("                                  /* BB */" ).append("\n"); 
		query.append("                                , VB.BB_CGO_FLG       AS BB_CGO_FLG  " ).append("\n"); 
		query.append("                                , VB.SOC_FLG          AS SOC_FLG" ).append("\n"); 
		query.append("                                , VB.EQ_SUBST_FLG     AS EQ_SUBST_FLG" ).append("\n"); 
		query.append("                                /* RF */" ).append("\n"); 
		query.append("                                , VB.RD_CGO_FLG       AS RD_CGO_FLG" ).append("\n"); 
		query.append("                                /* DG */" ).append("\n"); 
		query.append("                                , VB.DCGO_FLG         AS DCGO_FLG" ).append("\n"); 
		query.append("                                , VB.SLAN_CD                AS SLAN_CD" ).append("\n"); 
		query.append("                                , TO_CHAR(VB.BKG_CRE_DT,'YYYY-MM-DD')  AS BKG_CRE_DT" ).append("\n"); 
		query.append("                                , NVL(DECODE(VB.SHIPPER,'0',' ',SUBSTR(VB.SHIPPER,1,2)||LTRIM(TO_CHAR(SUBSTR(VB.SHIPPER,3),'000000'))),' ')        AS SHIPPER" ).append("\n"); 
		query.append("                                , NVL(DECODE(VB.CONSIGNEE,'0',' ',SUBSTR(VB.CONSIGNEE,1,2)||LTRIM(TO_CHAR(SUBSTR(VB.CONSIGNEE,3),'000000'))),' ')  AS CONSIGNEE" ).append("\n"); 
		query.append("                                , NVL(DECODE(VB.NTFY,'0',' ',SUBSTR(VB.NTFY,1,2)||LTRIM(TO_CHAR(SUBSTR(VB.NTFY,3),'000000'))),' ') AS NTFY" ).append("\n"); 
		query.append("                                , NVL(DECODE(VB.FFDR,'0',' ',SUBSTR(VB.FFDR,1,2)||LTRIM(TO_CHAR(SUBSTR(VB.FFDR,3),'000000'))),' ') AS FFDR" ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                                    " ).append("\n"); 
		query.append("                                    , VB.DEL_CD" ).append("\n"); 
		query.append("                                    , VB.POD_CD    AS ACTUAL_POD" ).append("\n"); 
		query.append("                                    , VB.POL_CD    AS ACTUAL_POL" ).append("\n"); 
		query.append("                                    , VB.BKG_STS_CD      AS BKG_STS_CD" ).append("\n"); 
		query.append("                                    , VB.CHN_AGN_CD AS CHINA_AGENT_CD" ).append("\n"); 
		query.append("                                    , (SELECT  CMDT_NM  FROM MDM_COMMODITY  WHERE CMDT_CD = VB.CMDT_CD)          AS CMDT_NM" ).append("\n"); 
		query.append("                                    , REPLACE(VB.CONSIGNEE_NAME,CHR(13)||CHR(10),' ') AS CNEE_NAME" ).append("\n"); 
		query.append("                                    , VB.CTRT_OFC_CD     AS CTRT_OFC_CD" ).append("\n"); 
		query.append("                                    , VB.CTRT_SREP_CD    AS CTRT_SREP_CD" ).append("\n"); 
		query.append("                                    , ( SELECT EQ_CTRL_OFC_CD FROM MDM_LOCATION WHERE LOC_CD = VB.DEL_CD )      AS DEL_EQ_OFC" ).append("\n"); 
		query.append("                                    , VB.DOC_USR_ID      AS DOC_USR_ID" ).append("\n"); 
		query.append("                                    , VB.POR_CD          AS POR_CD" ).append("\n"); 
		query.append("                                    , ( SELECT EQ_CTRL_OFC_CD FROM MDM_LOCATION WHERE LOC_CD = VB.POR_CD )      AS POR_EQ_OFC" ).append("\n"); 
		query.append("                                    , NVL(VB.RFA_NO,' ') AS RFA_NO" ).append("\n"); 
		query.append("                                    , SUBSTR(NVL(VB.SC_NO, ' '), 1, 8)        AS SC_NO" ).append("\n"); 
		query.append("                                    , DECODE(VB.PRE_1_POL_CD,NULL,' ',NVL(VB.PRE_1_POL_CD,' ')," ).append("\n"); 
		query.append("                                            DECODE(VB.PRE_2_POL_CD,NULL,NVL(VB.PRE_1_POL_CD,' ')," ).append("\n"); 
		query.append("                                            DECODE(VB.PRE_3_POL_CD,NULL,NVL(VB.PRE_2_POL_CD,' ')," ).append("\n"); 
		query.append("                                             DECODE(VB.PRE_4_POL_CD,NULL,NVL(VB.PRE_3_POL_CD,' '),NVL(VB.PRE_4_POL_CD,' ')))))   AS SORT_PRE_POL" ).append("\n"); 
		query.append("                                    , DECODE(VB.PRE_1_POD_CD, NULL,' '," ).append("\n"); 
		query.append("                                            DECODE(VB.PRE_2_POD_CD,NULL,NVL(VB.PRE_1_POD_CD,' ')," ).append("\n"); 
		query.append("                                             DECODE(VB.PRE_3_POD_CD,NULL,NVL(VB.PRE_2_POD_CD,' ')," ).append("\n"); 
		query.append("                                             DECODE(VB.PRE_4_POD_CD,NULL,NVL(VB.PRE_3_POD_CD,' '),NVL(VB.PRE_4_POD_CD,' ')))))   AS SORT_PRE_POD" ).append("\n"); 
		query.append("                                    , DECODE(VB.POST_1_POL_CD,NULL,' '," ).append("\n"); 
		query.append("                                           DECODE(VB.POST_2_POL_CD,NULL,NVL(VB.POST_1_POL_CD,' ')," ).append("\n"); 
		query.append("                                             DECODE(VB.POST_3_POL_CD,NULL,NVL(VB.POST_2_POL_CD,' ')," ).append("\n"); 
		query.append("                                             DECODE(VB.POST_4_POL_CD,NULL,NVL(VB.POST_3_POL_CD,' '),NVL(VB.POST_4_POL_CD,' '))))) AS SORT_POST_POL" ).append("\n"); 
		query.append("                                    , DECODE(VB.POST_1_POD_CD,NULL,' '," ).append("\n"); 
		query.append("                                             DECODE(VB.POST_2_POD_CD,NULL,NVL(VB.POST_1_POD_CD,' ')," ).append("\n"); 
		query.append("                                             DECODE(VB.POST_3_POD_CD,NULL,NVL(VB.POST_2_POD_CD,' ')," ).append("\n"); 
		query.append("                                             DECODE(VB.POST_4_POD_CD,NULL,NVL(VB.POST_3_POD_CD,' '),NVL(VB.POST_4_POD_CD,' '))))) AS SORT_POST_POD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    , DECODE(VB.PRE_2_VVD,NULL,VB.PRE_1_VVD," ).append("\n"); 
		query.append("                                             DECODE(VB.PRE_3_VVD,NULL,VB.PRE_2_VVD, DECODE(VB.PRE_4_VVD,NULL,VB.PRE_3_VVD,VB.PRE_4_VVD) ))   AS SORT_PRE_VVD" ).append("\n"); 
		query.append("                                             " ).append("\n"); 
		query.append("                                    , DECODE(VB.POST_1_VVD,NULL,' ', " ).append("\n"); 
		query.append("                                            DECODE(VB.POST_2_VVD,NULL,VB.POST_1_VVD, " ).append("\n"); 
		query.append("                                            DECODE(VB.POST_3_VVD,NULL,VB.POST_2_VVD," ).append("\n"); 
		query.append("                                            DECODE(VB.POST_4_VVD,NULL,VB.POST_3_VVD,VB.POST_4_VVD)))) AS SORT_POST_VVD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                     , VB.TRUNK_POD        AS TRUNK_POD" ).append("\n"); 
		query.append("                                     , VB.TRUNK_POL        AS TRUNK_POL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                 ,  (SELECT  COUNT(1) VVD_COUNT" ).append("\n"); 
		query.append("                                     FROM BKG_VVD" ).append("\n"); 
		query.append("                                     WHERE BKG_NO           = VB.BKG_NO" ).append("\n"); 
		query.append("                                     AND VSL_CD IS NOT NULL)VVD_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                 ,  (SELECT   COUNT(1) SKD_COUNT" ).append("\n"); 
		query.append("                                     FROM VSK_VSL_PORT_SKD POL," ).append("\n"); 
		query.append("                                          VSK_VSL_PORT_SKD POD," ).append("\n"); 
		query.append("                                          BKG_VVD VVD" ).append("\n"); 
		query.append("                                     WHERE BKG_NO           = VB.BKG_NO" ).append("\n"); 
		query.append("                                     AND VVD.VSL_CD       = POL.VSL_CD" ).append("\n"); 
		query.append("                                     AND VVD.SKD_VOY_NO   = POL.SKD_VOY_NO" ).append("\n"); 
		query.append("                                     AND VVD.SKD_DIR_CD   = POL.SKD_DIR_CD" ).append("\n"); 
		query.append("                                     AND VVD.POL_CD       = POL.VPS_PORT_CD" ).append("\n"); 
		query.append("                                     AND NVL(VVD.POL_CLPT_IND_SEQ, 1) = POL.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                     AND NVL(POL.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                                     AND VVD.VSL_CD       = POD.VSL_CD" ).append("\n"); 
		query.append("                                     AND VVD.SKD_VOY_NO   = POD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                     AND VVD.SKD_DIR_CD   = POD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                     AND VVD.POD_CD       = POD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                     AND NVL(VVD.POD_CLPT_IND_SEQ, 1) = POD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                     AND NVL(POD.SKD_CNG_STS_CD, 'X') <> 'S') SKD_CNT" ).append("\n"); 
		query.append("                                  /****************** FOR SORT END *****************/                           " ).append("\n"); 
		query.append("                    FROM   BKG_QUANTITY BKG_QTY--BKG_QTY" ).append("\n"); 
		query.append("                          #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                			, BKG_WORK_V VB" ).append("\n"); 
		query.append("						  #else" ).append("\n"); 
		query.append("							, (SELECT " ).append("\n"); 
		query.append("                                                      B.BKG_NO," ).append("\n"); 
		query.append("                                                      B.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("                                                      B.BL_NO,     " ).append("\n"); 
		query.append("                                                      B.BL_TP_CD," ).append("\n"); 
		query.append("                                                      D.BL_OBRD_TP_CD BL_TP," ).append("\n"); 
		query.append("                                                      D.BL_OBRD_DT," ).append("\n"); 
		query.append("                                                      B.SI_FLG," ).append("\n"); 
		query.append("                                                      B.BKG_OFC_CD," ).append("\n"); 
		query.append("                                                      B.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("                                                      D.BKG_CLZ_FLG," ).append("\n"); 
		query.append("                                                      B.DOC_USR_ID," ).append("\n"); 
		query.append("                                                      B.OB_SLS_OFC_CD," ).append("\n"); 
		query.append("                                                      B.OB_SREP_CD," ).append("\n"); 
		query.append("                                                      B.CTRT_SREP_CD CTRT_SREP_CD," ).append("\n"); 
		query.append("                                                      B.RCV_TERM_CD," ).append("\n"); 
		query.append("                                                      B.DE_TERM_CD," ).append("\n"); 
		query.append("                                                      B.ORG_TRNS_SVC_MOD_CD,                          " ).append("\n"); 
		query.append("                                                      B.DEST_TRNS_SVC_MOD_CD," ).append("\n"); 
		query.append("                                                      B.ORG_SCONTI_CD," ).append("\n"); 
		query.append("                                                      B.DEST_SCONTI_CD," ).append("\n"); 
		query.append("                                                      B.BKG_STS_CD," ).append("\n"); 
		query.append("                                                      B.FM_BKG_NO," ).append("\n"); 
		query.append("                                                      B.SPLIT_RSN_CD," ).append("\n"); 
		query.append("                                                      B.ADV_SHTG_CD," ).append("\n"); 
		query.append("                                                      B.SPLIT_FLG," ).append("\n"); 
		query.append("                                                      (SELECT max(DOC_DTL.EVNT_DT)" ).append("\n"); 
		query.append("                                                         FROM BKG_DOC_PROC_SKD DOC_DTL" ).append("\n"); 
		query.append("                                                        WHERE DOC_DTL.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                          AND BKG_DOC_PROC_TP_CD = 'BKGHOT') HOT_DT ," ).append("\n"); 
		query.append("                                                      B.BKG_CRE_DT," ).append("\n"); 
		query.append("                                                      B.TWN_SO_NO," ).append("\n"); 
		query.append("                                                      B.REV_DIR_CD," ).append("\n"); 
		query.append("                                                      B.SLAN_CD," ).append("\n"); 
		query.append("                                                      B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD TRUNK_VVD," ).append("\n"); 
		query.append("                                                      B.VSL_CD," ).append("\n"); 
		query.append("                                                      B.SKD_VOY_NO," ).append("\n"); 
		query.append("                                                      B.SKD_DIR_CD," ).append("\n"); 
		query.append("                                                      B.POR_NOD_CD AS POR_NODE," ).append("\n"); 
		query.append("                                                      B.POR_CD," ).append("\n"); 
		query.append("                                                      B.POL_CD," ).append("\n"); 
		query.append("                                                      B.POD_CD," ).append("\n"); 
		query.append("                                                      B.DEL_CD," ).append("\n"); 
		query.append("                                                      B.DEL_NOD_CD," ).append("\n"); 
		query.append("                                                      B.FNL_DEST_CD," ).append("\n"); 
		query.append("                                                      DECODE ((" ).append("\n"); 
		query.append("                                                            SELECT DOC_DTL.DOC_PROC_SEQ" ).append("\n"); 
		query.append("                                                            FROM BKG_DOC_PROC_SKD DOC_DTL" ).append("\n"); 
		query.append("                                                            WHERE DOC_DTL.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                              AND BKG_DOC_PROC_TP_CD = 'CMCNTR'" ).append("\n"); 
		query.append("                                                              AND ROWNUM = 1 ), NULL, 'N', 'Y') BKG_CM_FRM ," ).append("\n"); 
		query.append("                                                      DECODE ((" ).append("\n"); 
		query.append("                                                            SELECT DOC_DTL.DOC_PROC_SEQ" ).append("\n"); 
		query.append("                                                            FROM BKG_DOC_PROC_SKD DOC_DTL" ).append("\n"); 
		query.append("                                                            WHERE DOC_DTL.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                              AND BKG_DOC_PROC_TP_CD = 'CNTCFM'" ).append("\n"); 
		query.append("                                                              AND ROWNUM = 1 ), NULL, 'N', 'Y') BKG_CM_FRM," ).append("\n"); 
		query.append("                                                      D.PCK_QTY," ).append("\n"); 
		query.append("                                                      D.PCK_TP_CD," ).append("\n"); 
		query.append("                                                      B.XTER_RMK," ).append("\n"); 
		query.append("                                                      D.MEAS_QTY," ).append("\n"); 
		query.append("                                                      D.MEAS_UT_CD," ).append("\n"); 
		query.append("                                                      D.BDR_FLG," ).append("\n"); 
		query.append("                                                      B.PRE_RLY_PORT_CD," ).append("\n"); 
		query.append("                                                      B.PST_RLY_PORT_CD," ).append("\n"); 
		query.append("                                                      D.ACT_WGT," ).append("\n"); 
		query.append("                                                      D.WGT_UT_CD," ).append("\n"); 
		query.append("                                                      B.CHN_AGN_CD," ).append("\n"); 
		query.append("                                                      D.BDR_CNG_FLG," ).append("\n"); 
		query.append("                                                      (SELECT max(DOC_DTL.EVNT_DT)" ).append("\n"); 
		query.append("                                                         FROM BKG_DOC_PROC_SKD DOC_DTL" ).append("\n"); 
		query.append("                                                        WHERE DOC_DTL.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                          AND BKG_DOC_PROC_TP_CD = 'CNTCFM' ) BKG_CGO_DT," ).append("\n"); 
		query.append("                                                      CNTC.CNTC_PSON_NM," ).append("\n"); 
		query.append("                                                      CNTC.CNTC_PSON_PHN_NO," ).append("\n"); 
		query.append("                                                      CNTC.CNTC_PSON_FAX_NO," ).append("\n"); 
		query.append("                                                      CNTC.CNTC_PSON_EML," ).append("\n"); 
		query.append("                                                      B.XTER_BKG_RQST_CD," ).append("\n"); 
		query.append("                                                      (SELECT FRT_TERM_CD" ).append("\n"); 
		query.append("                                                         FROM BKG_RATE R" ).append("\n"); 
		query.append("                                                        WHERE R.BKG_NO = B.BKG_NO) FRT_TERM_CD," ).append("\n"); 
		query.append("                                                      B.SC_NO," ).append("\n"); 
		query.append("                                                      B.RFA_NO," ).append("\n"); 
		query.append("                                                      B.TAA_NO," ).append("\n"); 
		query.append("                                                      B.CTRT_OFC_CD," ).append("\n"); 
		query.append("                                                      S.CUST_NM SHPR_NAME," ).append("\n"); 
		query.append("                                                      S.CUST_CNT_CD||S.CUST_SEQ SHIPPER," ).append("\n"); 
		query.append("                                                      S.CUST_NM," ).append("\n"); 
		query.append("                                                      S.CUST_ADDR S_ADDR," ).append("\n"); 
		query.append("                                                      S.BKG_CUST_TP_CD S_CUST_TP," ).append("\n"); 
		query.append("                                                      C.CUST_CNT_CD||C.CUST_SEQ CONSIGNEE," ).append("\n"); 
		query.append("                                                      C.CUST_NM CONSIGNEE_NAME," ).append("\n"); 
		query.append("                                                      C.CUST_ADDR C_ADDR," ).append("\n"); 
		query.append("                                                      B.CUST_TO_ORD_FLG," ).append("\n"); 
		query.append("                                                      F.CUST_CNT_CD||F.CUST_SEQ FFDR," ).append("\n"); 
		query.append("                                                      F.CUST_NM FFDR_NAME," ).append("\n"); 
		query.append("                                                      F.BKG_CUST_TP_CD S_CUST_TP," ).append("\n"); 
		query.append("                                                      N.CUST_CNT_CD||N.CUST_SEQ NTFY," ).append("\n"); 
		query.append("                                                      N.CUST_NM NTFY_NAME," ).append("\n"); 
		query.append("                                                      N.CUST_ADDR N_ADDR," ).append("\n"); 
		query.append("                                                      N.BKG_CUST_TP_CD N_CUST_TP," ).append("\n"); 
		query.append("                                                      (SELECT CUST_NM FROM BKG_CUSTOMER A WHERE A.BKG_CUST_TP_CD(+) ='A' AND B.BKG_NO = A.BKG_NO(+)) ANTY_NAME," ).append("\n"); 
		query.append("                                                      (SELECT CUST_NM FROM BKG_CUSTOMER A WHERE A.BKG_CUST_TP_CD(+) ='E' AND B.BKG_NO = A.BKG_NO(+)) EXPT_NAME," ).append("\n"); 
		query.append("                                                      VVD.VSL_CD KEY_VSL_CD," ).append("\n"); 
		query.append("                                                      VVD.SKD_VOY_NO KEY_SKD_VOY_NO," ).append("\n"); 
		query.append("                                                      VVD.SKD_DIR_CD KEY_SKD_DIR_CD," ).append("\n"); 
		query.append("                                                      VVD.POL_CD KEY_POL_CD," ).append("\n"); 
		query.append("                                                      VVD.POD_CD KEY_POD_CD," ).append("\n"); 
		query.append("                                                      VVD.POL_YD_CD KEY_POL_YD_CD," ).append("\n"); 
		query.append("                                                      VVD.POD_YD_CD KEY_POD_YD_CD," ).append("\n"); 
		query.append("													  D.POL_CD DOC_POL_CD," ).append("\n"); 
		query.append("													  D.POD_CD DOC_POD_CD," ).append("\n"); 
		query.append("                                                      VVD.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("                                                      V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD PRE_1_VVD," ).append("\n"); 
		query.append("                                                      V1.POL_CD PRE_1_POL_CD," ).append("\n"); 
		query.append("                                                      V1.POD_CD PRE_1_POD_CD," ).append("\n"); 
		query.append("                                                      V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD PRE_2_VVD," ).append("\n"); 
		query.append("                                                      V2.POL_CD PRE_2_POL_cd," ).append("\n"); 
		query.append("                                                      V2.POD_CD PRE_2_POD_cd," ).append("\n"); 
		query.append("                                                      V3.VSL_CD||V3.SKD_VOY_NO||V3.SKD_DIR_CD PRE_3_VVD," ).append("\n"); 
		query.append("                                                      V3.POL_CD PRE_3_POL_CD," ).append("\n"); 
		query.append("                                                      V3.POD_CD PRE_3_POD_CD," ).append("\n"); 
		query.append("                                                      V4.VSL_CD||V4.SKD_VOY_NO||V4.SKD_DIR_CD PRE_4_VVD," ).append("\n"); 
		query.append("                                                      V4.POL_CD PRE_4_POL_CD," ).append("\n"); 
		query.append("                                                      V4.POD_CD PRE_4_POD_CD," ).append("\n"); 
		query.append("                                                      V5.VSL_CD||V5.SKD_VOY_NO||V5.SKD_DIR_CD POST_1_VVD," ).append("\n"); 
		query.append("                                                      V5.POL_CD POST_1_POL_CD," ).append("\n"); 
		query.append("                                                      V5.POD_CD POST_1_POD_CD," ).append("\n"); 
		query.append("                                                      V6.VSL_CD||V6.SKD_VOY_NO||V6.SKD_DIR_CD POST_2_VVD," ).append("\n"); 
		query.append("                                                      V6.POL_CD POST_2_POL_CD," ).append("\n"); 
		query.append("                                                      V6.POD_CD POST_2_POD_CD," ).append("\n"); 
		query.append("                                                      V7.VSL_CD||V7.SKD_VOY_NO||V7.SKD_DIR_CD POST_3_VVD," ).append("\n"); 
		query.append("                                                      V7.POL_CD POST_3_POL_CD," ).append("\n"); 
		query.append("                                                      V7.POD_CD POST_3_POD_CD," ).append("\n"); 
		query.append("                                                      V8.VSL_CD||V8.SKD_VOY_NO||V8.SKD_DIR_CD POST_4_VVD," ).append("\n"); 
		query.append("                                                      V8.POL_CD POST_4_POL_CD," ).append("\n"); 
		query.append("                                                      V8.POD_CD POST_4_POD_CD," ).append("\n"); 
		query.append("                                                      V9.POL_CD TRUNK_POL," ).append("\n"); 
		query.append("                                                      V9.POD_CD TRUNK_POD," ).append("\n"); 
		query.append("													  V9.SLAN_CD TRUNK_LANE," ).append("\n"); 
		query.append("                                                      DECODE(B.STOP_OFF_LOC_CD, NULL, 'N', 'Y') STOP_OFF_LOC_CD," ).append("\n"); 
		query.append("                                                      D.SPCL_CGO_AUTH_KNT," ).append("\n"); 
		query.append("                                                      B.RC_FLG," ).append("\n"); 
		query.append("                                                      B.DCGO_FLG," ).append("\n"); 
		query.append("                                                      B.PRCT_FLG,    " ).append("\n"); 
		query.append("                                                      B.AWK_CGO_FLG," ).append("\n"); 
		query.append("                                                      B.RD_CGO_FLG," ).append("\n"); 
		query.append("                                                      B.BB_CGO_FLG," ).append("\n"); 
		query.append("                                                      B.HNGR_FLG," ).append("\n"); 
		query.append("                                                      B.SOC_FLG," ).append("\n"); 
		query.append("                                                      B.FD_GRD_FLG," ).append("\n"); 
		query.append("                                                      B.SPCL_HIDE_FLG," ).append("\n"); 
		query.append("                                                      B.EQ_SUBST_FLG," ).append("\n"); 
		query.append("                                                      B.RAIL_BLK_CD," ).append("\n"); 
		query.append("                                                      B.HOT_DE_FLG," ).append("\n"); 
		query.append("                                                      B.WT_RSN_SPCL_CGO_FLG," ).append("\n"); 
		query.append("                                                      B.WT_RSN_HLD_FLG," ).append("\n"); 
		query.append("                                                      B.AP_BROG_FLG," ).append("\n"); 
		query.append("                                                      B.STWG_CD," ).append("\n"); 
		query.append("                                                      B.BLCK_STWG_CD," ).append("\n"); 
		query.append("                                                      DECODE(nvl(B.STOP_OFF_LOC_CD, 'N'), 'N', 'N', 'Y') STOP_CGO_FLG," ).append("\n"); 
		query.append("                                                      B.CMDT_CD," ).append("\n"); 
		query.append("                                                      (SELECT CMDT_NM" ).append("\n"); 
		query.append("                                                         FROM MDM_COMMODITY M" ).append("\n"); 
		query.append("                                                        WHERE M.CMDT_CD = B.CMDT_CD) CMDT_NM," ).append("\n"); 
		query.append("                                                      B.REP_CMDT_CD," ).append("\n"); 
		query.append("                                                      D.CSTMS_DESC CSTMS_DESC," ).append("\n"); 
		query.append("                                                      B.INTER_RMK," ).append("\n"); 
		query.append("                                                      SR.OFC_TEAM_CD" ).append("\n"); 
		query.append("                                                    FROM BKG_BOOKING B ," ).append("\n"); 
		query.append("                                                      BKG_BL_DOC D," ).append("\n"); 
		query.append("                                                      BKG_CNTC_PSON CNTC," ).append("\n"); 
		query.append("                                                      BKG_CUSTOMER S," ).append("\n"); 
		query.append("                                                      BKG_CUSTOMER C," ).append("\n"); 
		query.append("                                                      BKG_CUSTOMER F," ).append("\n"); 
		query.append("                                                      BKG_CUSTOMER N," ).append("\n"); 
		query.append("                                                      BKG_VVD V1," ).append("\n"); 
		query.append("                                                      BKG_VVD V2," ).append("\n"); 
		query.append("                                                      BKG_VVD V3," ).append("\n"); 
		query.append("                                                      BKG_VVD V4," ).append("\n"); 
		query.append("                                                      BKG_VVD V5," ).append("\n"); 
		query.append("                                                      BKG_VVD V6," ).append("\n"); 
		query.append("                                                      BKG_VVD V7," ).append("\n"); 
		query.append("                                                      BKG_VVD V8," ).append("\n"); 
		query.append("                                                      BKG_VVD V9," ).append("\n"); 
		query.append("                                                      BKG_VVD VVD," ).append("\n"); 
		query.append("                                                      MDM_SLS_REP SR" ).append("\n"); 
		query.append("                                                    WHERE 1=1" ).append("\n"); 
		query.append("                                                      AND B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("                                                      AND B.BKG_NO = CNTC.BKG_NO(+)" ).append("\n"); 
		query.append("                                                      AND CNTC.BKG_CNTC_PSON_TP_CD(+) ='BK'" ).append("\n"); 
		query.append("                                                      AND C.BKG_CUST_TP_CD ='C'" ).append("\n"); 
		query.append("                                                      AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                                                      AND S.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("                                                      AND B.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("                                                      AND F.BKG_CUST_TP_CD(+) ='F'" ).append("\n"); 
		query.append("                                                      AND B.BKG_NO = F.BKG_NO(+)" ).append("\n"); 
		query.append("                                                      AND N.BKG_CUST_TP_CD(+) ='N'" ).append("\n"); 
		query.append("                                                      AND B.BKG_NO = N.BKG_NO(+)" ).append("\n"); 
		query.append("                                                      AND B.BKG_NO = V1.BKG_NO(+)" ).append("\n"); 
		query.append("                                                      AND V1.VSL_PRE_PST_CD(+) ='S'" ).append("\n"); 
		query.append("                                                      AND V1.VSL_SEQ(+) ='1'" ).append("\n"); 
		query.append("                                                      AND B.BKG_NO = V2.BKG_NO(+)" ).append("\n"); 
		query.append("                                                      AND V2.VSL_PRE_PST_CD(+) ='S'" ).append("\n"); 
		query.append("                                                      AND V2.VSL_SEQ(+) ='2'" ).append("\n"); 
		query.append("                                                      AND B.BKG_NO = V3.BKG_NO(+)" ).append("\n"); 
		query.append("                                                      AND V3.VSL_PRE_PST_CD(+) ='S'" ).append("\n"); 
		query.append("                                                      AND V3.VSL_SEQ(+) ='3'" ).append("\n"); 
		query.append("                                                      AND B.BKG_NO = V4.BKG_NO(+)" ).append("\n"); 
		query.append("                                                      AND V4.VSL_PRE_PST_CD(+) ='S'" ).append("\n"); 
		query.append("                                                      AND V4.VSL_SEQ(+) ='4'" ).append("\n"); 
		query.append("                                                      AND B.BKG_NO = V5.BKG_NO(+)" ).append("\n"); 
		query.append("                                                      AND V5.VSL_PRE_PST_CD(+) ='U'" ).append("\n"); 
		query.append("                                                      AND V5.VSL_SEQ(+) ='1'" ).append("\n"); 
		query.append("                                                      AND B.BKG_NO = V6.BKG_NO(+)" ).append("\n"); 
		query.append("                                                      AND V6.VSL_PRE_PST_CD(+) ='U'" ).append("\n"); 
		query.append("                                                      AND V6.VSL_SEQ(+) ='2'" ).append("\n"); 
		query.append("                                                      AND B.BKG_NO = V7.BKG_NO(+)" ).append("\n"); 
		query.append("                                                      AND V7.VSL_PRE_PST_CD(+) ='U'" ).append("\n"); 
		query.append("                                                      AND V7.VSL_SEQ(+) ='3'" ).append("\n"); 
		query.append("                                                      AND B.BKG_NO = V8.BKG_NO(+)" ).append("\n"); 
		query.append("                                                      AND V8.VSL_PRE_PST_CD(+) ='U'" ).append("\n"); 
		query.append("                                                      AND V8.VSL_SEQ(+) ='4'" ).append("\n"); 
		query.append("                                                      AND B.BKG_NO = V9.BKG_NO" ).append("\n"); 
		query.append("                                                      AND V9.VSL_PRE_PST_CD ='T'" ).append("\n"); 
		query.append("                                                      AND B.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                                      AND B.OB_SREP_CD = SR.SREP_CD(+)" ).append("\n"); 
		query.append("                                                      AND SR.OFC_CD(+) = 'SELSC' -- SELSC에 한해 L/TEAM 을 조회함" ).append("\n"); 
		query.append("                                                      ) VB" ).append("\n"); 
		query.append("						  #end" ).append("\n"); 
		query.append("						 ,MDM_LOCATION" ).append("\n"); 
		query.append("						 ,BKG_XPT_IMP_LIC XPT_IMP" ).append("\n"); 
		query.append("						 ,BKG_BOOKING B" ).append("\n"); 
		query.append("						 ,BKG_RATE RA" ).append("\n"); 
		query.append("                    WHERE  VB.BKG_NO = BKG_QTY.BKG_NO(+)" ).append("\n"); 
		query.append("                    AND    VB.DEL_CD     = MDM_LOCATION.LOC_CD" ).append("\n"); 
		query.append("                    AND    VB.BKG_NO     = XPT_IMP.BKG_NO(+)" ).append("\n"); 
		query.append("                    AND    XPT_IMP.IO_BND_CD(+) ='O'" ).append("\n"); 
		query.append("                    AND    VB.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                    AND    B.BKG_NO = RA.BKG_NO(+)                   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										 /***************** 조건 시작 *********************/" ).append("\n"); 
		query.append("                                             /* 1  vvd_cd  */" ).append("\n"); 
		query.append("                                           #if (${vvd_cd} != '') " ).append("\n"); 
		query.append("                                            AND     VB.KEY_VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                            AND     VB.KEY_SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                            AND     VB.KEY_SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            /* 2  trunk_flag */" ).append("\n"); 
		query.append("                                           #if (${trunk_flag} != '') " ).append("\n"); 
		query.append("                                            AND   VB.VSL_PRE_PST_CD ='T'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 3 lane_cd */" ).append("\n"); 
		query.append("                                           #if (${lane_cd} != '') " ).append("\n"); 
		query.append("                                            AND VB.TRUNK_LANE = @[lane_cd]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 4  dir_cd */        " ).append("\n"); 
		query.append("                                           #if (${dir_cd} != '') " ).append("\n"); 
		query.append("                                            AND VB.SKD_DIR_CD IN (${dir_cd})" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 5  pol_cd */" ).append("\n"); 
		query.append("                                           #if (${pol_cd} != '') " ).append("\n"); 
		query.append("												#if (${board_from_dt} != '')" ).append("\n"); 
		query.append("		                                            AND VB.DOC_POL_CD > ' ' " ).append("\n"); 
		query.append("												#end" ).append("\n"); 
		query.append("													AND VB.KEY_POL_CD LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 6 pol_yard_cd */" ).append("\n"); 
		query.append("                                           #if (${pol_yard_cd} != '') " ).append("\n"); 
		query.append("                                            AND SUBSTR(VB.KEY_POL_YD_CD,-2) = @[pol_yard_cd]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 7 pol_local */" ).append("\n"); 
		query.append("                                           #if ( ${pol_cd} != '' && ${pol_local} != '') " ).append("\n"); 
		query.append("                                            AND VB.KEY_POL_CD = VB.POL_CD" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 8 pol_ts */ " ).append("\n"); 
		query.append("                                           #if (${pol_cd} != '' && ${pol_ts} != '') " ).append("\n"); 
		query.append("                                            AND VB.KEY_POL_CD <> VB.POL_CD" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 9 pod_cd */" ).append("\n"); 
		query.append("                                           #if (${pod_cd} != '') " ).append("\n"); 
		query.append("                                            AND VB.KEY_POD_CD LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 10 pod_yard_cd*/" ).append("\n"); 
		query.append("                                           #if (${pod_yard_cd} != '') " ).append("\n"); 
		query.append("                                            AND SUBSTR(VB.KEY_POD_YD_CD,-2) = @[pod_yard_cd]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                             " ).append("\n"); 
		query.append("                                            /* 11 pod_local */" ).append("\n"); 
		query.append("                                           #if (${pod_local} != '') " ).append("\n"); 
		query.append("	                                            AND VB.KEY_POD_CD = VB.POD_CD" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 12 pod_ts */" ).append("\n"); 
		query.append("                                           #if (${pod_ts} != '') " ).append("\n"); 
		query.append("                                            AND VB.KEY_POD_CD <> VB.POD_CD" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 13 por_cd         */" ).append("\n"); 
		query.append("                                           #if (${por_cd} != '') " ).append("\n"); 
		query.append("                                            AND VB.POR_CD LIKE @[por_cd]||'%' " ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 14 del_cd         */" ).append("\n"); 
		query.append("                                           #if (${del_cd} != '') " ).append("\n"); 
		query.append("                                            AND VB.DEL_CD LIKE @[del_cd]||'%' " ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 15 r_term         */" ).append("\n"); 
		query.append("                                           #if (${r_term} != '') " ).append("\n"); 
		query.append("                                            AND VB.RCV_TERM_CD IN (${r_term})" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 16 d_term         */" ).append("\n"); 
		query.append("                                           #if (${d_term} != '') " ).append("\n"); 
		query.append("                                            AND VB.DE_TERM_CD IN (${d_term})" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                                                                   " ).append("\n"); 
		query.append("                                           /*17 zone_cd OCN*/" ).append("\n"); 
		query.append("                                            #if (${zone_cd} == 'OCN') " ).append("\n"); 
		query.append("                                             AND (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = VB.POR_CD) <> (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = VB.DEL_CD)" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("                                           /* 17 zone_cd IPT*/" ).append("\n"); 
		query.append("                                            #if (${zone_cd} == 'IPT') " ).append("\n"); 
		query.append("                                             AND (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = VB.POR_CD) = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = VB.DEL_CD)" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("											 /* 17 zone_cd IPT*/" ).append("\n"); 
		query.append("                                            #if (${zone_cd} == 'DOM') " ).append("\n"); 
		query.append("                                             AND (SUBSTR(VB.por_cd,1,2) = SUBSTR(VB.del_cd,1,2))" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 18 deli_mode      */" ).append("\n"); 
		query.append("										   #if (${deli_mode} !='')" ).append("\n"); 
		query.append("	                                       		AND decode(NVL(VB.DEST_TRNS_MOD_CD, ' '),'T','1','2','R','A','4','F','3','B','3','E','5','U','5','*') IN (${deli_mode})" ).append("\n"); 
		query.append("										   #end" ).append("\n"); 
		query.append("										" ).append("\n"); 
		query.append("										   /* 19, 20 Pre1 ETD Date */" ).append("\n"); 
		query.append("										   #if (${board_from_dt} != '') " ).append("\n"); 
		query.append("											AND VB.BKG_NO" ).append("\n"); 
		query.append("											 IN ( SELECT DISTINCT BKG.BKG_NO" ).append("\n"); 
		query.append("                            						FROM BKG_VVD VVD, BKG_BOOKING BKG" ).append("\n"); 
		query.append("                           						   WHERE ( VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD,VVD.POL_CD,VVD.POL_CLPT_IND_SEQ ) IN " ).append("\n"); 
		query.append("                               						     ( SELECT A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.VPS_PORT_CD,A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                              								 FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                                							WHERE A.VPS_ETD_DT >= TO_DATE(@[board_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                  							  AND A.VPS_ETD_DT <= TO_DATE(@[board_to_dt], 'YYYY-MM-DD') +0.99999)" ).append("\n"); 
		query.append("                                  							  AND VB.BKG_NO  = BKG.BKG_NO                           									  " ).append("\n"); 
		query.append("                                  							  AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                  							  AND VVD.POL_CD = BKG.POL_CD" ).append("\n"); 
		query.append("                                  							  AND ( VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ) IN ( ('S',1),('T',0) )" ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("										   #end " ).append("\n"); 
		query.append("                                            #if (${eta_from_dt} != '')" ).append("\n"); 
		query.append("											/* 19, 20 lst ETA Date */" ).append("\n"); 
		query.append("											AND VB.BKG_NO" ).append("\n"); 
		query.append("											 IN ( SELECT DISTINCT BKG.BKG_NO" ).append("\n"); 
		query.append("                            						FROM BKG_VVD VVD, BKG_BOOKING BKG" ).append("\n"); 
		query.append("                           						   WHERE ( VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD,VVD.POD_CD,VVD.POD_CLPT_IND_SEQ ) IN" ).append("\n"); 
		query.append("                               						     ( SELECT A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.VPS_PORT_CD,A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                              								 FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                                							WHERE A.VPS_ETA_DT >= TO_DATE(@[eta_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                  							  AND A.VPS_ETA_DT <= TO_DATE(@[eta_to_dt], 'YYYY-MM-DD') +0.99999)" ).append("\n"); 
		query.append("													 AND VB.BKG_NO  = BKG.BKG_NO" ).append("\n"); 
		query.append("                           							 AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                           							 AND VVD.POD_CD = BKG.POD_CD" ).append("\n"); 
		query.append("													 AND VVD.VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("													 AND (VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ) = (SELECT /*+ INDEX_DESC (VVD2 XPKBKG_VVD) */ VVD2.VSL_PRE_PST_CD, VVD2.VSL_SEQ" ).append("\n"); 
		query.append("																								 FROM BKG_VVD VVD2" ).append("\n"); 
		query.append("																								WHERE VVD2.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("																								  AND VVD2.VSL_PRE_PST_CD IN ('T','U')" ).append("\n"); 
		query.append("																								  AND ROWNUM = 1)" ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("										   #end" ).append("\n"); 
		query.append("                                            /* 21 bkg_from_dt    */" ).append("\n"); 
		query.append("                                           #if (${bkg_from_dt} != '') " ).append("\n"); 
		query.append("                                            AND VB.BKG_CRE_DT >= TO_DATE(@[bkg_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 22 bkg_to_dt      */" ).append("\n"); 
		query.append("                                           #if (${bkg_to_dt} != '') " ).append("\n"); 
		query.append("                                            AND VB.BKG_CRE_DT <= TO_DATE(@[bkg_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 23 bkg_kind       */" ).append("\n"); 
		query.append("                                           #if (${bkg_kind} != '') " ).append("\n"); 
		query.append("                                            AND VB.XTER_BKG_RQST_CD IN (${bkg_kind})" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("											/* 24 b_ofc_cd       *//* 25 b_ofc_cd_sub   */" ).append("\n"); 
		query.append("                                           #if (${b_ofc_cd} != '') " ).append("\n"); 
		query.append("                                            #if(${b_ofc_cd_sub} != '')" ).append("\n"); 
		query.append("											/* 2010.04.22 수정 */" ).append("\n"); 
		query.append("											 AND VB.BKG_OFC_CD IN ( ${b_ofc_cd_sub} )" ).append("\n"); 
		query.append("                                            #else" ).append("\n"); 
		query.append("											 AND VB.BKG_OFC_CD IN ( ${b_ofc_cd} )" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 26 b_staff_id     */" ).append("\n"); 
		query.append("                                           #if (${b_staff_id} != '') " ).append("\n"); 
		query.append("                                            AND VB.DOC_USR_ID = @[b_staff_id]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 27 ca_flag        */" ).append("\n"); 
		query.append("                                           #if (${ca_flag} != '') " ).append("\n"); 
		query.append("                                            AND EXISTS ( SELECT  'Y' FROM BKG_CORRECTION" ).append("\n"); 
		query.append("														 WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("														 AND CORR_NO IS NOT NULL" ).append("\n"); 
		query.append("														 AND CORR_NO <> '0000000001')" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 28 agent_cd       */" ).append("\n"); 
		query.append("                                           #if (${agent_cd} != '') " ).append("\n"); 
		query.append("                                            AND VB.CHN_AGN_CD = @[agent_cd]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 29 agent_cd_all   */" ).append("\n"); 
		query.append("                                           #if (${agent_cd_all} != '') " ).append("\n"); 
		query.append("                                            AND VB.CHN_AGN_CD IS NOT NULL" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 30 eq_type BKG_QUANTITY  EXISTS 체크*/" ).append("\n"); 
		query.append("                                           #if (${eq_type} != '') " ).append("\n"); 
		query.append("                                            AND EXISTS  ( SELECT 'Y'" ).append("\n"); 
		query.append("                                                          FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                                                          WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("                                                          AND   CNTR_TPSZ_CD IN (${eq_type})" ).append("\n"); 
		query.append("                                                         )" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                                         " ).append("\n"); 
		query.append("                                            /* 31 cmdt_cd MDM_COMMODITY   EXISTS 체크*/" ).append("\n"); 
		query.append("                                           #if (${cmdt_cd} != '') " ).append("\n"); 
		query.append("                                            AND VB.CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                                         " ).append("\n"); 
		query.append("                                            /* 32 cmdt_nm - 체크안함 */" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 33 wgt_from       */" ).append("\n"); 
		query.append("                                           #if (${wgt_from} != '') " ).append("\n"); 
		query.append("                                            AND VB.WGT_UT_CD = 'KGS'" ).append("\n"); 
		query.append("                                            AND VB.ACT_WGT >= (@[wgt_from] *'1000')" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 34 wgt_to         */" ).append("\n"); 
		query.append("                                           #if (${wgt_to} != '') " ).append("\n"); 
		query.append("                                            AND VB.WGT_UT_CD = 'KGS' " ).append("\n"); 
		query.append("                                            AND VB.ACT_WGT <= (@[wgt_to] *'1000')" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 35 so_no          */" ).append("\n"); 
		query.append("                                           #if (${so_no} != '') " ).append("\n"); 
		query.append("                                            AND VB.TWN_SO_NO = @[so_no]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                           /* 36 l_ofc_cd *//* 37 l_ofc_cd_sub */" ).append("\n"); 
		query.append("                                           #if (${l_ofc_cd} != '') " ).append("\n"); 
		query.append("                                            #if(${l_ofc_cd_sub} != '')" ).append("\n"); 
		query.append("                                             AND VB.OB_SLS_OFC_CD   IN ( SELECT OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("                                                                          FROM   DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                                                                          WHERE @[l_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("                                                                                                OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD)" ).append("\n"); 
		query.append("                                                                        )" ).append("\n"); 
		query.append("                                            #else" ).append("\n"); 
		query.append("                                             AND VB.OB_SLS_OFC_CD = @[l_ofc_cd]" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           " ).append("\n"); 
		query.append("                                            /* 38 l_team_cd        */" ).append("\n"); 
		query.append("                                           #if (${l_team_cd} != '') " ).append("\n"); 
		query.append("                                             AND VB.OFC_TEAM_CD = @[l_team_cd]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           " ).append("\n"); 
		query.append("                                            /* 39 l_rep_id       */" ).append("\n"); 
		query.append("                                           #if (${l_rep_id} != '') " ).append("\n"); 
		query.append("                                            AND VB.OB_SREP_CD = @[l_rep_id]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           " ).append("\n"); 
		query.append("                                           /* 40 c_ofc_cd *//* 41 c_ofc_cd_sub */" ).append("\n"); 
		query.append("                                           #if (${c_ofc_cd} != '') " ).append("\n"); 
		query.append("                                            #if(${c_ofc_cd_sub} != '')" ).append("\n"); 
		query.append("                                             AND VB.CTRT_OFC_CD   IN ( SELECT OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("                                                                     FROM   DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                                                                     WHERE @[c_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("                                                                                                OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD)" ).append("\n"); 
		query.append("                                                                   )" ).append("\n"); 
		query.append("                                            #else" ).append("\n"); 
		query.append("                                             AND VB.CTRT_OFC_CD = @[c_ofc_cd]" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           " ).append("\n"); 
		query.append("                                            /* 42 c_rep_id       */" ).append("\n"); 
		query.append("                                           #if (${c_rep_id} != '') " ).append("\n"); 
		query.append("                                            AND VB.CTRT_SREP_CD = @[c_rep_id]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           " ).append("\n"); 
		query.append("                                            /* 43 ctr_rfa_cd*//* 44 ctr_rfa_no*/" ).append("\n"); 
		query.append("                                           #if (${ctr_rfa_cd} == 'C') " ).append("\n"); 
		query.append("                                            #if (${ctr_rfa_no} != '') " ).append("\n"); 
		query.append("                                             AND VB.SC_NO = @[ctr_rfa_no]" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("                                           #elseif (${ctr_rfa_cd} == 'R') " ).append("\n"); 
		query.append("                                            #if (${ctr_rfa_no} != '') " ).append("\n"); 
		query.append("                                             AND VB.RFA_NO = @[ctr_rfa_no]" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("                                           #elseif (${ctr_rfa_cd} == 'T')" ).append("\n"); 
		query.append("                                            #if (${ctr_rfa_no} != '')" ).append("\n"); 
		query.append("                                             AND VB.TAA_NO = @[ctr_rfa_no]" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 45 s_mode_ori     */" ).append("\n"); 
		query.append("                                           #if (${s_mode_ori} != '') " ).append("\n"); 
		query.append("                                            AND VB.ORG_TRNS_SVC_MOD_CD IN (${s_mode_ori})" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 46 s_mode_dest    */" ).append("\n"); 
		query.append("                                           #if (${s_mode_dest} != '') " ).append("\n"); 
		query.append("                                            AND VB.DEST_TRNS_SVC_MOD_CD IN (${s_mode_dest})" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 47 s_route_ori    */" ).append("\n"); 
		query.append("                                           #if (${s_route_ori} != '') " ).append("\n"); 
		query.append("                                            AND VB.ORG_SCONTI_CD IN (${s_route_ori})" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 48 s_route_dest   */" ).append("\n"); 
		query.append("                                           #if (${s_route_dest} != '') " ).append("\n"); 
		query.append("                                            AND VB.DEST_SCONTI_CD IN(${s_route_dest})" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                           " ).append("\n"); 
		query.append("                                            /* 50 fv_vvd_cd      */" ).append("\n"); 
		query.append("                                                 /* 49 fv_pre_pst_cd  */" ).append("\n"); 
		query.append("                                           #if (${fv_vvd_cd} != '') " ).append("\n"); 
		query.append("                                               #if (${fv_pre_pst_cd} == 'PR') " ).append("\n"); 
		query.append("                                                AND @[fv_vvd_cd] IN (VB.PRE_1_VVD, VB.PRE_2_VVD, VB.PRE_3_VVD, VB.PRE_4_VVD)" ).append("\n"); 
		query.append("                                               #elseif (${fv_pre_pst_cd} == 'PO') " ).append("\n"); 
		query.append("                                                AND @[fv_vvd_cd] IN ( VB.POST_1_VVD , VB.POST_2_VVD , VB.POST_3_VVD , VB.POST_4_VVD )" ).append("\n"); 
		query.append("                                               #end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            /* 51 fv_pol_cd      *//* 52 fv_pol_yard_cd *//* 53 fv_pol_local */" ).append("\n"); 
		query.append("                                                 /* 49 fv_pre_pst_cd  */" ).append("\n"); 
		query.append("                                           #if (${fv_pol_cd} != '') " ).append("\n"); 
		query.append("                                               #if (${fv_pre_pst_cd} == 'PR') " ).append("\n"); 
		query.append("                                                #if(${fv_pol_yard_cd} != '')" ).append("\n"); 
		query.append("                                                 AND @[fv_pol_cd]||@[fv_pol_yard_cd] IN ( VB.PRE_1_POL_YD_CD  , VB.PRE_2_POL_YD_CD  , VB.PRE_3_POL_YD_CD  , VB.PRE_4_POL_YD_CD)" ).append("\n"); 
		query.append("                                                #else" ).append("\n"); 
		query.append("                                                 AND @[fv_pol_cd] IN ( VB.PRE_1_POL_CD  , VB.PRE_2_POL_CD  , VB.PRE_3_POL_CD  , VB.PRE_4_POL_CD)" ).append("\n"); 
		query.append("                                                #end" ).append("\n"); 
		query.append("                                                " ).append("\n"); 
		query.append("                                                 #if (${fv_pol_local} != '') " ).append("\n"); 
		query.append("                                                    AND VB.POL_CD = NVL( (SELECT @[fv_pol_cd] FROM DUAL " ).append("\n"); 
		query.append("                                                                          WHERE  @[fv_pol_cd] IN (VB.PRE_4_POL_CD, VB.PRE_3_POL_CD, VB.PRE_2_POL_CD ) )" ).append("\n"); 
		query.append("                                                                       , VB.PRE_1_POL_CD)" ).append("\n"); 
		query.append("                                                 #end                     " ).append("\n"); 
		query.append("                                               #elseif (${fv_pre_pst_cd} == 'PO') " ).append("\n"); 
		query.append("                                                #if(${fv_pol_yard_cd} != '')" ).append("\n"); 
		query.append("                                                 AND @[fv_pol_cd]||@[fv_pol_yard_cd] IN ( VB.POST_1_POL_YD_CD  , VB.POST_2_POL_YD_CD  , VB.POST_3_POL_YD_CD  , VB.POST_4_POL_YD_CD)" ).append("\n"); 
		query.append("                                                #else" ).append("\n"); 
		query.append("                                                 AND @[fv_pol_cd] IN ( VB.POST_1_POL_CD , VB.POST_2_POL_CD , VB.POST_3_POL_CD , VB.POST_4_POL_CD) " ).append("\n"); 
		query.append("                                                #end" ).append("\n"); 
		query.append("                                                " ).append("\n"); 
		query.append("                                                " ).append("\n"); 
		query.append("                                                 #if (${fv_pol_local} != '') " ).append("\n"); 
		query.append("                                                    AND VB.POL_CD = NVL( (SELECT @[fv_pol_cd] FROM DUAL " ).append("\n"); 
		query.append("                                                                          WHERE  @[fv_pol_cd] IN (VB.POST_4_POL_CD, VB.POST_3_POL_CD, VB.POST_2_POL_CD ) )" ).append("\n"); 
		query.append("                                                                       , VB.POST_1_POL_CD)" ).append("\n"); 
		query.append("                                                 #end" ).append("\n"); 
		query.append("                                               #end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           " ).append("\n"); 
		query.append("                                           #if (${fv_pol_cd} == '' && ${fv_pol_yard_cd} != '') " ).append("\n"); 
		query.append("                                             #if (${fv_pre_pst_cd} == 'PR') " ).append("\n"); 
		query.append("                                                 AND @[fv_pol_yard_cd] IN ( SUBSTR(VB.PRE_1_POL_YD_CD,-2)  , SUBSTR(VB.PRE_2_POL_YD_CD,-2)  , SUBSTR(VB.PRE_3_POL_YD_CD,-2)  , SUBSTR(VB.PRE_4_POL_YD_CD,-2))" ).append("\n"); 
		query.append("                                               #elseif (${fv_pre_pst_cd} == 'PO') " ).append("\n"); 
		query.append("                                                 AND @[fv_pol_yard_cd] IN ( SUBSTR(VB.POST_1_POL_YD_CD,-2)  , SUBSTR(VB.POST_2_POL_YD_CD,-2)  , SUBSTR(VB.POST_3_POL_YD_CD,-2)  , SUBSTR(VB.POST_4_POL_YD_CD,-2))" ).append("\n"); 
		query.append("                                               #end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           " ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 54 fv_pod_cd      */ /* 55 fv_pod_yard_cd *//* 56 fv_pod_local   */" ).append("\n"); 
		query.append("                                                 /* 49 fv_pre_pst_cd  */" ).append("\n"); 
		query.append("                                           #if (${fv_pod_cd} != '') " ).append("\n"); 
		query.append("                                               #if (${fv_pre_pst_cd} == 'PR') " ).append("\n"); 
		query.append("                                                #if(${fv_pod_yard_cd} != '')" ).append("\n"); 
		query.append("                                                 AND @[fv_pod_cd]||@[fv_pod_yard_cd] IN ( VB.PRE_1_POD_YD_CD  , VB.PRE_2_POD_YD_CD  , VB.PRE_3_POD_YD_CD  , VB.PRE_4_POD_YD_CD)" ).append("\n"); 
		query.append("                                                #else" ).append("\n"); 
		query.append("                                                 AND @[fv_pod_cd] IN ( VB.PRE_1_POD_CD  , VB.PRE_2_POD_CD  , VB.PRE_3_POD_CD  , VB.PRE_4_POD_CD)" ).append("\n"); 
		query.append("                                                #end" ).append("\n"); 
		query.append("                                                " ).append("\n"); 
		query.append("                                                 #if (${fv_pol_local} != '') " ).append("\n"); 
		query.append("                                                    AND VB.POD_CD = NVL( (SELECT @[fv_pod_cd] FROM DUAL " ).append("\n"); 
		query.append("                                                                          WHERE  @[fv_pod_cd] IN (VB.PRE_4_POD_CD, VB.PRE_3_POD_CD, VB.PRE_2_POD_CD ) )" ).append("\n"); 
		query.append("                                                                       , VB.PRE_1_POD_CD)" ).append("\n"); 
		query.append("                                                 #end                     " ).append("\n"); 
		query.append("                                               #elseif (${fv_pre_pst_cd} == 'PO') " ).append("\n"); 
		query.append("                                                #if(${fv_pod_yard_cd} != '')" ).append("\n"); 
		query.append("                                                 AND @[fv_pod_cd]||@[fv_pod_yard_cd] IN ( VB.POST_1_POD_YD_CD  , VB.POST_2_POD_YD_CD  , VB.POST_3_POD_YD_CD  , VB.POST_4_POD_YD_CD)" ).append("\n"); 
		query.append("                                                #else" ).append("\n"); 
		query.append("                                                 AND @[fv_pod_cd] IN ( VB.POST_1_POD_CD , VB.POST_2_POD_CD , VB.POST_3_POD_CD , VB.POST_4_POD_CD) " ).append("\n"); 
		query.append("                                                #end" ).append("\n"); 
		query.append("                                                " ).append("\n"); 
		query.append("                                                " ).append("\n"); 
		query.append("                                                 #if (${fv_pol_local} != '') " ).append("\n"); 
		query.append("                                                    AND VB.POD_CD = NVL( (SELECT @[fv_pod_cd] FROM DUAL " ).append("\n"); 
		query.append("                                                                          WHERE  @[fv_pod_cd] IN (VB.POST_4_POD_CD, VB.POST_3_POD_CD, VB.POST_2_POD_CD ) )" ).append("\n"); 
		query.append("                                                                       , VB.POST_1_POD_CD)" ).append("\n"); 
		query.append("                                                 #end" ).append("\n"); 
		query.append("                                               #end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           " ).append("\n"); 
		query.append("                                           #if (${fv_pod_cd} == '' && ${fv_pod_yard_cd} != '') " ).append("\n"); 
		query.append("                                             #if (${fv_pre_pst_cd} == 'PR') " ).append("\n"); 
		query.append("                                                 AND @[fv_pod_yard_cd] IN ( SUBSTR(VB.PRE_1_POD_YD_CD,-2)  , SUBSTR(VB.PRE_2_POD_YD_CD,-2)  , SUBSTR(VB.PRE_3_POD_YD_CD,-2)  , SUBSTR(VB.PRE_4_POD_YD_CD,-2))" ).append("\n"); 
		query.append("                                               #elseif (${fv_pre_pst_cd} == 'PO') " ).append("\n"); 
		query.append("                                                 AND @[fv_pod_yard_cd] IN ( SUBSTR(VB.POST_1_POD_YD_CD,-2)  , SUBSTR(VB.POST_2_POD_YD_CD,-2)  , SUBSTR(VB.POST_3_POD_YD_CD,-2)  , SUBSTR(VB.POST_4_POD_YD_CD,-2))" ).append("\n"); 
		query.append("                                               #end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            /* 57~61 cust_tp_cd_s,c,n,f,a*/" ).append("\n"); 
		query.append("											/* 63 cust_cnt_cd    *//* 64 cust_seq *//* 66 cust_tp_cd*/" ).append("\n"); 
		query.append("										 #if (${cust_tp_cd_s} != '' || ${cust_tp_cd_c} != '' || ${cust_tp_cd_n} != '' || ${cust_tp_cd_f} != '' || ${cust_tp_cd_a} != '')                                        " ).append("\n"); 
		query.append("   											  #if(${cust_cnt_cd} !='' && ${cust_seq} != '')" ).append("\n"); 
		query.append("												AND ( 1=2" ).append("\n"); 
		query.append("														#if (${cust_tp_cd_s} !='')" ).append("\n"); 
		query.append("															OR VB.SHIPPER = @[cust_cnt_cd]||TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("														#if (${cust_tp_cd_c} !='')" ).append("\n"); 
		query.append("															OR CONSIGNEE = @[cust_cnt_cd]||TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("														#if (${cust_tp_cd_n} !='')" ).append("\n"); 
		query.append("															OR NTFY = @[cust_cnt_cd]||TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("														#if (${cust_tp_cd_f} !='')" ).append("\n"); 
		query.append("															OR FFDR = @[cust_cnt_cd]||TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("														#if (${cust_tp_cd_a} !='')" ).append("\n"); 
		query.append("															/* 예비*/															" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("													)" ).append("\n"); 
		query.append("											   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										#end" ).append("\n"); 
		query.append("														" ).append("\n"); 
		query.append("										/* 67 sp_cargo_dg  *//* 68 sp_cargo_rf    *//* 69 sp_cargo_ak *//* 70 sp_cargo_bb *//* 71 sp_cargo_hg    *//* 72 sp_cargo_soc   *//* 73 sp_cargo_eq    *//* 74 sp_cargo_rd    *//* 75 sp_cargo_pm    *//* 76 sp_cargo_pc    *//* 77 sp_cargo_fg    *//* 78 sp_cargo_hd    *//* 79 sp_cargo_rb    */" ).append("\n"); 
		query.append("										#if (${sp_cargo_dg} !=''||${sp_cargo_rf} != ''||${sp_cargo_ak} != ''||${sp_cargo_bb} != ''||${sp_cargo_hg} != ''||${sp_cargo_soc} != ''||${sp_cargo_eq} != ''||${sp_cargo_rd} != ''||${sp_cargo_pm} != ''||${sp_cargo_pc} != ''||${sp_cargo_fg} != ''||${sp_cargo_hd} != ''||${sp_cargo_rb} != '')" ).append("\n"); 
		query.append("										     AND ( 1=2 " ).append("\n"); 
		query.append("										  /* 67 sp_cargo_dg  */" ).append("\n"); 
		query.append("										  #if (${sp_cargo_dg} != '') " ).append("\n"); 
		query.append("										  	OR VB.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  /* 68 sp_cargo_rf    */" ).append("\n"); 
		query.append("										  #if (${sp_cargo_rf} != '') " ).append("\n"); 
		query.append("											OR VB.RC_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  /* 69 sp_cargo_ak */" ).append("\n"); 
		query.append("										  #if (${sp_cargo_ak} != '') " ).append("\n"); 
		query.append("											OR VB.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  /* 69 sp_cargo_ak */" ).append("\n"); 
		query.append("										  #if (${sp_cargo_ak} != '') " ).append("\n"); 
		query.append("										    OR VB.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  /* 70 sp_cargo_bb */" ).append("\n"); 
		query.append("										  #if (${sp_cargo_bb} != '') " ).append("\n"); 
		query.append("											OR VB.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  /* 71 sp_cargo_hg    */" ).append("\n"); 
		query.append("										  #if (${sp_cargo_hg} != '') " ).append("\n"); 
		query.append("										    OR VB.HNGR_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  /* 72 sp_cargo_soc   */" ).append("\n"); 
		query.append("										  #if (${sp_cargo_soc} != '') " ).append("\n"); 
		query.append("											OR VB.SOC_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end	" ).append("\n"); 
		query.append("										  /* 73 sp_cargo_eq    */" ).append("\n"); 
		query.append("										  #if (${sp_cargo_eq} != '') " ).append("\n"); 
		query.append("										    OR VB.EQ_SUBST_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  /* 74 sp_cargo_rd    */" ).append("\n"); 
		query.append("										  #if (${sp_cargo_rd} != '') " ).append("\n"); 
		query.append("										    OR VB.RD_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  /* 75 sp_cargo_pm    */" ).append("\n"); 
		query.append("										  #if (${sp_cargo_pm} != '') " ).append("\n"); 
		query.append("										    OR VB.HOT_DE_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  /* 76 sp_cargo_pc    */" ).append("\n"); 
		query.append("										  #if (${sp_cargo_pc} != '') " ).append("\n"); 
		query.append("										    OR VB.PRCT_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  /* 77 sp_cargo_fg    */" ).append("\n"); 
		query.append("										  #if (${sp_cargo_fg} != '') " ).append("\n"); 
		query.append("										    OR VB.FD_GRD_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  /* 78 sp_cargo_hd    */" ).append("\n"); 
		query.append("										  #if (${sp_cargo_hd} != '') " ).append("\n"); 
		query.append("										    OR VB.SPCL_HIDE_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  /* 79 sp_cargo_rb    */" ).append("\n"); 
		query.append("										  #if (${sp_cargo_rb} != '') " ).append("\n"); 
		query.append("										    OR VB.RAIL_BLK_CD IS NOT NULL" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  )" ).append("\n"); 
		query.append("										#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            /* 80~82 cargo_tp_f,p,r     */" ).append("\n"); 
		query.append("                                           #if (${cargo_tp_f} != '' || ${cargo_tp_p} != '' || ${cargo_tp_r} != '') " ).append("\n"); 
		query.append("                                            AND VB.BKG_CGO_TP_CD IN ( @[cargo_tp_f], @[cargo_tp_p], @[cargo_tp_r]) " ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 83 bkg_sts_cd_f*//* 84 bkg_sts_cd_x*//* 85 bkg_sts_cd_a*//* 86 bkg_sts_cd_w*/" ).append("\n"); 
		query.append("                                           #if (${bkg_sts_cd_f} != '' || ${bkg_sts_cd_x} != '' || ${bkg_sts_cd_a} != '' || ${bkg_sts_cd_w} != '') " ).append("\n"); 
		query.append("                                            AND VB.BKG_STS_CD IN ( @[bkg_sts_cd_f], @[bkg_sts_cd_x], @[bkg_sts_cd_a], @[bkg_sts_cd_w]) " ).append("\n"); 
		query.append("											#else /* 선택되지 않을경우 기본 STATUS */" ).append("\n"); 
		query.append("                                            AND  VB.BKG_STS_CD IN ('F', 'W', 'A') " ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 87 non_sp_cargo   */" ).append("\n"); 
		query.append("                                           #if (${non_sp_cargo} != '') " ).append("\n"); 
		query.append("                                            AND VB.WT_RSN_SPCL_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            /* 88 holding*/" ).append("\n"); 
		query.append("                                           #if (${holding} != '') " ).append("\n"); 
		query.append("                                            AND VB.WT_RSN_HLD_FLG = 'Y'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 89 bl_type_a      */" ).append("\n"); 
		query.append("                                           #if (${bl_type_a} != '') " ).append("\n"); 
		query.append("                                            AND VB.ADV_SHTG_CD = 'A'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            /* 90 bl_type_s      */" ).append("\n"); 
		query.append("                                           #if (${bl_type_s} != '') " ).append("\n"); 
		query.append("                                            AND VB.ADV_SHTG_CD = 'S'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            /* 91 rev            */" ).append("\n"); 
		query.append("                                           #if (${rev} != '') " ).append("\n"); 
		query.append("                                            AND EXISTS ( SELECT 'Y' FROM BKG_CHG_RT WHERE BKG_NO = VB.BKG_NO) " ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            /* 92 non_rev        */" ).append("\n"); 
		query.append("                                           #if (${non_rev} != '') " ).append("\n"); 
		query.append("                                            AND NOT EXISTS ( SELECT 'Y' FROM BKG_CHG_RT WHERE BKG_NO = VB.BKG_NO)" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            /* 93 aes_y          */" ).append("\n"); 
		query.append("                                           #if (${aes_y} != '') " ).append("\n"); 
		query.append("                                            AND XPT_IMP.AES_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            /* 94 aes_n          */" ).append("\n"); 
		query.append("                                           #if (${aes_n} != '') " ).append("\n"); 
		query.append("                                            AND XPT_IMP.AES_TP_CD IS NULL" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            /* 95 stop_cargo     */" ).append("\n"); 
		query.append("                                           #if (${stop_cargo} != '') " ).append("\n"); 
		query.append("                                            AND VB.STOP_CGO_FLG ='Y'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            /* 96 ro_y           */" ).append("\n"); 
		query.append("                                           #if (${ro_y} != '') " ).append("\n"); 
		query.append("											AND EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("											             FROM BKG_ROLL_OVR WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("											             GROUP BY BKG_NO" ).append("\n"); 
		query.append("											             HAVING COUNT(BKG_NO) > @[ro_y]" ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 98 caed_y         */" ).append("\n"); 
		query.append("                                           #if (${caed_y} != '') " ).append("\n"); 
		query.append("                                            AND XPT_IMP.CAED_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            /* 99 caed_n         */" ).append("\n"); 
		query.append("                                           #if (${caed_n} != '') " ).append("\n"); 
		query.append("                                            AND XPT_IMP.CAED_TP_CD IS NULL" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 101 certi_y        */" ).append("\n"); 
		query.append("                                           #if (${certi_y} != '') " ).append("\n"); 
		query.append("                                            AND EXISTS ( SELECT 'Y' FROM BKG_IMG_STO WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("                                           							#if (${certi_d} != '' || ${certi_a} != '' || ${certi_b} != '' || ${certi_g} != '' || ${certi_c} != '')" ).append("\n"); 
		query.append("                                           							AND RIDR_TP_CD IN (@[certi_d], @[certi_a], @[certi_b], @[certi_g], @[certi_c])" ).append("\n"); 
		query.append("                                           							#end 	" ).append("\n"); 
		query.append("                                            						)" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           " ).append("\n"); 
		query.append("                                            /* 102 certi_n        */" ).append("\n"); 
		query.append("                                           #if (${certi_n} != '') " ).append("\n"); 
		query.append("                                            AND NOT EXISTS ( SELECT 'Y' FROM BKG_IMG_STO WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("                                            								#if (${certi_d} != '' || ${certi_a} != '' || ${certi_b} != '' || ${certi_g} != '' || ${certi_c} != '')" ).append("\n"); 
		query.append("		                                           							AND RIDR_TP_CD IN (@[certi_d], @[certi_a], @[certi_b], @[certi_g], @[certi_c])" ).append("\n"); 
		query.append("		                                           							#end 	" ).append("\n"); 
		query.append("		                                            						)	" ).append("\n"); 
		query.append("                                           #end     " ).append("\n"); 
		query.append("                                           #if (${rate_check} != '')" ).append("\n"); 
		query.append("											AND @[rate_check] = " ).append("\n"); 
		query.append("													CASE WHEN SUBSTR(VB.SC_NO,1,3) = 'DUM' OR SUBSTR(VB.RFA_NO,1,3) = 'DUM' OR SUBSTR(VB.TAA_NO,1,3) = 'DUM' THEN 'Y'" ).append("\n"); 
		query.append("                                                         WHEN RA.OFT_MSS_FLG = 'N' THEN 'N'" ).append("\n"); 
		query.append("														 WHEN RA.OFT_MSS_FLG = 'Y' THEN NVL((SELECT 'N' " ).append("\n"); 
		query.append("																								FROM BKG_CHG_RT RT " ).append("\n"); 
		query.append("																								WHERE RT.BKG_NO = RA.BKG_NO " ).append("\n"); 
		query.append("																								AND ROWNUM = 1), 'Y') END" ).append("\n"); 
		query.append("										   #end                            " ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                /***************** 조건 끝 *********************/" ).append("\n"); 
		query.append("				 ) K" ).append("\n"); 
		query.append("                 #if(${bkg_sts_cd_i} != '')" ).append("\n"); 
		query.append("                 WHERE VVD_CNT <> SKD_CNT " ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("            ) X" ).append("\n"); 
		query.append("           GROUP BY  ORDERBY_TITLE, TP_SZ" ).append("\n"); 
		query.append("  ) Y" ).append("\n"); 
		query.append("  ORDER BY ORDERBY_TITLE, TP_SZ" ).append("\n"); 

	}
}