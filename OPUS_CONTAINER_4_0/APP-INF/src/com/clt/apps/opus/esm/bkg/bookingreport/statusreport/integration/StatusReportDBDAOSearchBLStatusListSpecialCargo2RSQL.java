/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : StatusReportDBDAOSearchBLStatusListSpecialCargo2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchBLStatusListSpecialCargo2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchBLStatusListSpecialCargo2RSQL
	  * </pre>
	  */
	public StatusReportDBDAOSearchBLStatusListSpecialCargo2RSQL(){
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
		params.put("last_orderby",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("b_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("orderby",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBLStatusListSpecialCargo2RSQL").append("\n"); 
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
		query.append("/************** BREAK BULK **************/" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  ZZZ.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("         ${orderby_title_sql} ORDERBY_TITLE" ).append("\n"); 
		query.append("        , 0 AS TOTAL_TEU" ).append("\n"); 
		query.append("        , 0 AS TOTAL_FEU" ).append("\n"); 
		query.append("        , TRIM(TO_CHAR(ROUND(SUM(TO_NUMBER(GRS_WGT,'999,999,990.999')) OVER() /1000) ,'999,999,999')) TOTAL_WGT" ).append("\n"); 
		query.append("        , 0 AS TOTAL_MEA" ).append("\n"); 
		query.append("        ,ZZ.*" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("              COUNT(1) OVER() TOTAL_CNT" ).append("\n"); 
		query.append("    	    , COUNT(DISTINCT BKG_NO) OVER() TOTAL_BKG" ).append("\n"); 
		query.append("	        , COUNT(DISTINCT BL_NO) OVER() TOTAL_BL" ).append("\n"); 
		query.append("            , COUNT(DISTINCT POL_CD||POD_CD ) OVER() ORDERBY_CNT" ).append("\n"); 
		query.append("            , @[last_orderby] LAST_ORDERBY" ).append("\n"); 
		query.append("            , @[orderby] ORDERBY" ).append("\n"); 
		query.append("           , Z.*" ).append("\n"); 
		query.append("           /*Z Alias*/" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                    Y.*" ).append("\n"); 
		query.append("                /* Y */" ).append("\n"); 
		query.append("                FROM ( " ).append("\n"); 
		query.append("                        SELECT " ).append("\n"); 
		query.append("                                  0 AS D2" ).append("\n"); 
		query.append("                                , 0 AS Q4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                , 0 AS D4" ).append("\n"); 
		query.append("                                , 0 AS R2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                , 0 AS D5" ).append("\n"); 
		query.append("                                , 0 AS R4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                , 0 AS D7" ).append("\n"); 
		query.append("                                , 0 AS R5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                , 0 AS F2" ).append("\n"); 
		query.append("                                , 0 AS T2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                , 0 AS F4" ).append("\n"); 
		query.append("                                , 0 AS T4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                , 0 AS F5" ).append("\n"); 
		query.append("                                , 0 AS P2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                , 0 AS O2" ).append("\n"); 
		query.append("                                , 0 AS P4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                , 0 AS O4" ).append("\n"); 
		query.append("                                , 0 AS Z4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                , 0 AS Q2" ).append("\n"); 
		query.append("                                , 0 AS Z2" ).append("\n"); 
		query.append("                                , 0 AS TEU" ).append("\n"); 
		query.append("                                , 0 AS FEU" ).append("\n"); 
		query.append("                              /* Void(FEU)*/" ).append("\n"); 
		query.append("                             , DECODE(ROW_SEQ,1,( SELECT " ).append("\n"); 
		query.append("                                                     NVL(SUM(CNTR_VOL_QTY),0)" ).append("\n"); 
		query.append("                                                    FROM  BKG_CONTAINER" ).append("\n"); 
		query.append("                                                    WHERE  BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("                                                    AND    BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("                                 ,0) OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("                                /* Mea Dangerous Cargo 해당됨 */" ).append("\n"); 
		query.append("                                , 0 AS MEAS_QTY " ).append("\n"); 
		query.append("                             , X.*" ).append("\n"); 
		query.append("                            /*X Alias*/                               " ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("                            SELECT " ).append("\n"); 
		query.append("                                     DENSE_RANK() OVER( ORDER BY ${orderby} ,BKG_NO) AS NO" ).append("\n"); 
		query.append("                                   , ROW_NUMBER() OVER (PARTITION BY ${orderby} ,BKG_NO ORDER BY ${orderby} ,BKG_NO, CGO_SEQ)  ROW_SEQ" ).append("\n"); 
		query.append("								   , COUNT(DISTINCT BKG_NO) OVER (PARTITION BY ${orderby} )  AS BKG_CNT" ).append("\n"); 
		query.append("                                   , COUNT(DISTINCT BL_NO) OVER (PARTITION BY ${orderby} )  AS BL_CNT" ).append("\n"); 
		query.append("                                   , XX.*" ).append("\n"); 
		query.append("                              FROM (" ).append("\n"); 
		query.append("    /************************************* 스페셜 카고 타입별 쿼리 시작*************************************/" ).append("\n"); 
		query.append("                                SELECT " ).append("\n"); 
		query.append("                                 VB.SPLIT_FLG," ).append("\n"); 
		query.append("                                 VB.BKG_STS_CD AS BST_FLG," ).append("\n"); 
		query.append("                                 VB.BDR_FLG AS BDR_FLG" ).append("\n"); 
		query.append("                                 /* BKG_NO*/" ).append("\n"); 
		query.append("                                ,VB.BKG_NO AS BKG_NO " ).append("\n"); 
		query.append("                                 /* BL_NO */" ).append("\n"); 
		query.append("                                ,VB.BL_NO||VB.BL_TP_CD AS BL_NO" ).append("\n"); 
		query.append("                                , REPLACE(VB.SHPR_NAME,CHR(10),' ') AS SHPR_NAME" ).append("\n"); 
		query.append("                                , VB.CUST_TO_ORD_FLG AS CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                                , REPLACE(VB.CONSIGNEE_NAME,CHR(10),' ') AS CONSIGNEE_NAME" ).append("\n"); 
		query.append("                                , REPLACE(VB.NTFY_NAME,CHR(10),' ') AS NTFY_NAME" ).append("\n"); 
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
		query.append("                                /* RMK */" ).append("\n"); 
		query.append("                                , DECODE(VB.XTER_RMK,NULL,'N','Y')        AS REMARK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                , REPLACE(SUBSTR(VB.XTER_RMK,1,200),CHR(10),' ') AS REMARK_DETAIL" ).append("\n"); 
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
		query.append("                                /* DG */" ).append("\n"); 
		query.append("                                , VB.DCGO_FLG         AS DCGO_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                , VB.SOC_FLG          AS SOC_FLG" ).append("\n"); 
		query.append("                                , VB.EQ_SUBST_FLG     AS EQ_SUBST_FLG" ).append("\n"); 
		query.append("                                , VB.RD_CGO_FLG       AS RD_CGO_FLG" ).append("\n"); 
		query.append("                                , VB.SLAN_CD                AS SLAN_CD" ).append("\n"); 
		query.append("                                , TO_CHAR(VB.BKG_CRE_DT,'YYYY-MM-DD')  AS BKG_CRE_DT" ).append("\n"); 
		query.append("                                , NVL(DECODE(VB.SHIPPER,'0',' ',SUBSTR(VB.SHIPPER,1,2)||LTRIM(TO_CHAR(SUBSTR(VB.SHIPPER,3),'000000'))),' ')        AS SHIPPER" ).append("\n"); 
		query.append("                                , NVL(DECODE(VB.CONSIGNEE,'0',' ',SUBSTR(VB.CONSIGNEE,1,2)||LTRIM(TO_CHAR(SUBSTR(VB.CONSIGNEE,3),'000000'))),' ')  AS CONSIGNEE" ).append("\n"); 
		query.append("                                , NVL(DECODE(VB.NTFY,'0',' ',SUBSTR(VB.NTFY,1,2)||LTRIM(TO_CHAR(SUBSTR(VB.NTFY,3),'000000'))),' ') AS NTFY" ).append("\n"); 
		query.append("                                , NVL(DECODE(VB.FFDR,'0',' ',SUBSTR(VB.FFDR,1,2)||LTRIM(TO_CHAR(SUBSTR(VB.FFDR,3),'000000'))),' ') AS FFDR" ).append("\n"); 
		query.append("                                  /* RQ */" ).append("\n"); 
		query.append("                                , VB.SPCL_CGO_AUTH_KNT AS SPCL_CGO_AUTH_KNT" ).append("\n"); 
		query.append("                                 /* CNTR NO*/" ).append("\n"); 
		query.append("                                , ' ' AS CNTR_NO" ).append("\n"); 
		query.append("                                 /* T/S */" ).append("\n"); 
		query.append("                                 ,' ' AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                  /* Commodity */" ).append("\n"); 
		query.append("                                  ,(SELECT CMDT_NM FROM MDM_COMMODITY A" ).append("\n"); 
		query.append("                                   WHERE A.CMDT_CD = VB.CMDT_CD) AS BB_CMDT" ).append("\n"); 
		query.append("                                  /* Length */" ).append("\n"); 
		query.append("                                , BB.DIM_LEN AS DIM_LEN" ).append("\n"); 
		query.append("                                  /* Width */" ).append("\n"); 
		query.append("                                , BB.DIM_WDT AS DIM_WDT" ).append("\n"); 
		query.append("                                  /* Height */" ).append("\n"); 
		query.append("                                , BB.DIM_HGT AS DIM_HGT" ).append("\n"); 
		query.append("                                  /* Net */" ).append("\n"); 
		query.append("                                , BB.NET_WGT AS NET_WGT" ).append("\n"); 
		query.append("                                  /* WGT  */" ).append("\n"); 
		query.append("                                , TRIM(TO_CHAR(NVL(GRS_WGT,0) ,'999,999,990.999')) GRS_WGT" ).append("\n"); 
		query.append("                                  /* PKG */" ).append("\n"); 
		query.append("                                , BB.PCK_QTY||BB.PCK_TP_CD AS PKG" ).append("\n"); 
		query.append("                                  /* AT */" ).append("\n"); 
		query.append("                                ,  BB.SPCL_CGO_APRO_CD AS SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("                                , BB.BB_CGO_SEQ AS CGO_SEQ " ).append("\n"); 
		query.append("                                , BB.STWG_INSTR_DESC AS STOWAGE" ).append("\n"); 
		query.append("								, '' AS CNTR_VOL_QTY" ).append("\n"); 
		query.append("							    /****************** FOR SORT START *****************/" ).append("\n"); 
		query.append("                                , VB.DEL_CD" ).append("\n"); 
		query.append("                                , VB.POD_CD    AS ACTUAL_POD" ).append("\n"); 
		query.append("                                , VB.POL_CD    AS ACTUAL_POL" ).append("\n"); 
		query.append("                                , VB.BKG_STS_CD      AS BKG_STS_CD" ).append("\n"); 
		query.append("                                , VB.CHN_AGN_CD AS CHINA_AGENT_CD" ).append("\n"); 
		query.append("                                , (SELECT  CMDT_NM  FROM MDM_COMMODITY  WHERE CMDT_CD = VB.CMDT_CD)          AS CMDT_NM" ).append("\n"); 
		query.append("                                , REPLACE(VB.CONSIGNEE_NAME,CHR(10),' ') AS CNEE_NAME" ).append("\n"); 
		query.append("                                , VB.CTRT_OFC_CD     AS CTRT_OFC_CD" ).append("\n"); 
		query.append("                                , VB.CTRT_SREP_CD    AS CTRT_SREP_CD" ).append("\n"); 
		query.append("                                , ( SELECT EQ_CTRL_OFC_CD FROM MDM_LOCATION WHERE LOC_CD = VB.DEL_CD )      AS DEL_EQ_OFC" ).append("\n"); 
		query.append("                                , VB.DOC_USR_ID      AS DOC_USR_ID" ).append("\n"); 
		query.append("                                , VB.POR_CD          AS POR_CD" ).append("\n"); 
		query.append("                                , ( SELECT EQ_CTRL_OFC_CD FROM MDM_LOCATION WHERE LOC_CD = VB.POR_CD )      AS POR_EQ_OFC" ).append("\n"); 
		query.append("                                , NVL(VB.RFA_NO,' ') AS RFA_NO" ).append("\n"); 
		query.append("                                , SUBSTR(NVL(VB.SC_NO, ' '), 1, 8)        AS SC_NO" ).append("\n"); 
		query.append("                                , DECODE(VB.PRE_1_POL_CD,NULL,' ',NVL(VB.PRE_1_POL_CD,' ')," ).append("\n"); 
		query.append("                                        DECODE(VB.PRE_2_POL_CD,NULL,NVL(VB.PRE_1_POL_CD,' ')," ).append("\n"); 
		query.append("                                        DECODE(VB.PRE_3_POL_CD,NULL,NVL(VB.PRE_2_POL_CD,' ')," ).append("\n"); 
		query.append("                                         DECODE(VB.PRE_4_POL_CD,NULL,NVL(VB.PRE_3_POL_CD,' '),NVL(VB.PRE_4_POL_CD,' ')))))   AS SORT_PRE_POL" ).append("\n"); 
		query.append("                                , DECODE(VB.PRE_1_POD_CD, NULL,' '," ).append("\n"); 
		query.append("                                        DECODE(VB.PRE_2_POD_CD,NULL,NVL(VB.PRE_1_POD_CD,' ')," ).append("\n"); 
		query.append("                                         DECODE(VB.PRE_3_POD_CD,NULL,NVL(VB.PRE_2_POD_CD,' ')," ).append("\n"); 
		query.append("                                         DECODE(VB.PRE_4_POD_CD,NULL,NVL(VB.PRE_3_POD_CD,' '),NVL(VB.PRE_4_POD_CD,' ')))))   AS SORT_PRE_POD" ).append("\n"); 
		query.append("                                , DECODE(VB.POST_1_POL_CD,NULL,' '," ).append("\n"); 
		query.append("                                       DECODE(VB.POST_2_POL_CD,NULL,NVL(VB.POST_1_POL_CD,' ')," ).append("\n"); 
		query.append("                                         DECODE(VB.POST_3_POL_CD,NULL,NVL(VB.POST_2_POL_CD,' ')," ).append("\n"); 
		query.append("                                         DECODE(VB.POST_4_POL_CD,NULL,NVL(VB.POST_3_POL_CD,' '),NVL(VB.POST_4_POL_CD,' '))))) AS SORT_POST_POL" ).append("\n"); 
		query.append("                                , DECODE(VB.POST_1_POD_CD,NULL,' '," ).append("\n"); 
		query.append("                                         DECODE(VB.POST_2_POD_CD,NULL,NVL(VB.POST_1_POD_CD,' ')," ).append("\n"); 
		query.append("                                         DECODE(VB.POST_3_POD_CD,NULL,NVL(VB.POST_2_POD_CD,' ')," ).append("\n"); 
		query.append("                                         DECODE(VB.POST_4_POD_CD,NULL,NVL(VB.POST_3_POD_CD,' '),NVL(VB.POST_4_POD_CD,' '))))) AS SORT_POST_POD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                , DECODE(VB.PRE_2_VVD,NULL,VB.PRE_1_VVD," ).append("\n"); 
		query.append("                                         DECODE(VB.PRE_3_VVD,NULL,VB.PRE_2_VVD, DECODE(VB.PRE_4_VVD,NULL,VB.PRE_3_VVD,VB.PRE_4_VVD) ))   AS SORT_PRE_VVD" ).append("\n"); 
		query.append("                                         " ).append("\n"); 
		query.append("                                , DECODE(VB.POST_1_VVD,NULL,' ', " ).append("\n"); 
		query.append("                                        DECODE(VB.POST_2_VVD,NULL,VB.POST_1_VVD, " ).append("\n"); 
		query.append("                                        DECODE(VB.POST_3_VVD,NULL,VB.POST_2_VVD," ).append("\n"); 
		query.append("                                        DECODE(VB.POST_4_VVD,NULL,VB.POST_3_VVD,VB.POST_4_VVD)))) AS SORT_POST_VVD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                 , VB.TRUNK_POD        AS TRUNK_POD" ).append("\n"); 
		query.append("                                 , VB.TRUNK_POL        AS TRUNK_POL" ).append("\n"); 
		query.append("                              /****************** FOR SORT END *****************/ " ).append("\n"); 
		query.append("                                FROM " ).append("\n"); 
		query.append("									#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                                    	BKG_WORK_V VB, " ).append("\n"); 
		query.append("									#else" ).append("\n"); 
		query.append("										 BKG_VB_V VB," ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("								 BKG_BB_CGO BB" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND VB.BKG_NO = BB.BKG_NO(+)" ).append("\n"); 
		query.append("                                AND VB.BB_CGO_FLG ='Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                /***************** 조건 시작 *********************/" ).append("\n"); 
		query.append("                                             /* 1  vvd_cd   */" ).append("\n"); 
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
		query.append("                                            AND VB.SLAN_CD = @[lane_cd]" ).append("\n"); 
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
		query.append("                                             AND (SUBSTR(NVL(VB.por_nod_cd,' '),1,1) <> SUBSTR(NVL(VB.fnl_dest_cd,' '),1,1))" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("                                           /* 17 zone_cd IPT*/" ).append("\n"); 
		query.append("                                            #if (${zone_cd} == 'IPT') " ).append("\n"); 
		query.append("                                             AND (SUBSTR(NVL(VB.por_nod_cd,' '),1,1) = SUBSTR(NVL(VB.fnl_dest_cd,' '),1,1))" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("											 /* 17 zone_cd IPT*/" ).append("\n"); 
		query.append("                                            #if (${zone_cd} == 'DOM') " ).append("\n"); 
		query.append("                                             AND (SUBSTR(VB.por_cd,1,2) = SUBSTR(VB.del_cd,1,2))" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 18 deli_mode      */" ).append("\n"); 
		query.append("										   #if (${deli_mode} !='')" ).append("\n"); 
		query.append("	                                       		AND decode(NVL(VB.DEST_TRNS_MOD_CD, ' '),'T','1','R','2','A','4','F','3','B','3','E','5','U','5','*') IN (${deli_mode})" ).append("\n"); 
		query.append("										   #end" ).append("\n"); 
		query.append("											" ).append("\n"); 
		query.append("                                            /* 19 board_from_dt  */" ).append("\n"); 
		query.append("                                           #if (${board_from_dt} != '') " ).append("\n"); 
		query.append("                                            AND VB.DOC_BL_OBRD_DT >= TO_DATE(@[board_from_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("                                            /* 20 board_to_dt    */" ).append("\n"); 
		query.append("                                           #if (${board_to_dt} != '') " ).append("\n"); 
		query.append("                                            AND VB.DOC_BL_OBRD_DT <= TO_DATE(@[board_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
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
		query.append("                                             AND VB.BKG_OFC_CD = @[b_ofc_cd]" ).append("\n"); 
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
		query.append("                                            /* 38 dept_cd        */" ).append("\n"); 
		query.append("                                           #if (${dept_cd} != '') " ).append("\n"); 
		query.append("                                            " ).append("\n"); 
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
		query.append("                                             AND CTRT_OFC_CD   IN ( SELECT OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("                                                                     FROM   DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                                                                     WHERE @[c_ofc_cd] IN (OFC_N1ST_LVL_CD, OFC_N2ND_LVL_CD, OFC_N3RD_LVL_CD, OFC_N4TH_LVL_CD," ).append("\n"); 
		query.append("                                                                                                OFC_N5TH_LVL_CD, OFC_N6TH_LVL_CD, OFC_N7TH_LVL_CD, OFC_N8TH_LVL_CD)" ).append("\n"); 
		query.append("                                                                   )" ).append("\n"); 
		query.append("                                            #else" ).append("\n"); 
		query.append("                                             AND CTRT_OFC_CD = @[c_ofc_cd]" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("										 #if (${cust_tp_cd_s} != '' || ${cust_tp_cd_c} != '' || ${cust_tp_cd_n} != '' || ${cust_tp_cd_f} != '' || ${cust_tp_cd_a} != '')                                        " ).append("\n"); 
		query.append("   											  #if(${cust_cnt_cd} !='' && ${cust_seq} != '')" ).append("\n"); 
		query.append("												AND ( 1=2" ).append("\n"); 
		query.append("														#if (${cust_tp_cd_s} !='')" ).append("\n"); 
		query.append("															OR VB.SHIPPER = @[cust_cnt_cd]||@[cust_seq]" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("														#if (${cust_tp_cd_c} !='')" ).append("\n"); 
		query.append("															OR CONSIGNEE = @[cust_cnt_cd]||@[cust_seq]" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("														#if (${cust_tp_cd_n} !='')" ).append("\n"); 
		query.append("															OR NTFY = @[cust_cnt_cd]||@[cust_seq]" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("														#if (${cust_tp_cd_f} !='')" ).append("\n"); 
		query.append("															OR FFDR = @[cust_cnt_cd]||@[cust_seq]" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("														#if (${cust_tp_cd_a} !='')" ).append("\n"); 
		query.append("															/* 예비*/															" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("													)" ).append("\n"); 
		query.append("											   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   											  #if(${cust_nm} !='')" ).append("\n"); 
		query.append("												AND ( 1=2" ).append("\n"); 
		query.append("														#if (${cust_tp_cd_s} !='')" ).append("\n"); 
		query.append("															OR VB.SHPR_NAME LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("														#if (${cust_tp_cd_c} !='')" ).append("\n"); 
		query.append("															OR VB.CONSIGNEE_NAME LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("														#if (${cust_tp_cd_n} !='')" ).append("\n"); 
		query.append("															OR VB.NTFY_NAME LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("														#if (${cust_tp_cd_f} !='')" ).append("\n"); 
		query.append("															OR VB.FFDR_NAME LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("														#if (${cust_tp_cd_a} !='')" ).append("\n"); 
		query.append("															/* 예비*/" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("													)" ).append("\n"); 
		query.append("											   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										#end" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("                                            --AND XPT_IMP.AES_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            /* 94 aes_n          */" ).append("\n"); 
		query.append("                                           #if (${aes_n} != '') " ).append("\n"); 
		query.append("                                            --AND XPT_IMP.AES_TP_CD IS NULL" ).append("\n"); 
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
		query.append("                                            --AND XPT_IMP.CAED_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                            /* 99 caed_n         */" ).append("\n"); 
		query.append("                                           #if (${caed_n} != '') " ).append("\n"); 
		query.append("                                            --AND XPT_IMP.CAED_TP_CD IS NULL" ).append("\n"); 
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
		query.append("                                           #end                               " ).append("\n"); 
		query.append("                                                                " ).append("\n"); 
		query.append("                                /***************** 조건 끝 *********************/" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("   /************************************* 스페셜 카고 타입별 쿼리 끝************************************ */" ).append("\n"); 
		query.append("                             ) XX" ).append("\n"); 
		query.append("                            ) X" ).append("\n"); 
		query.append("                    ) Y" ).append("\n"); 
		query.append("              ) Z" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ) ZZ" ).append("\n"); 
		query.append(" ) ZZZ" ).append("\n"); 
		query.append(" ORDER BY NO, ROW_SEQ" ).append("\n"); 

	}
}