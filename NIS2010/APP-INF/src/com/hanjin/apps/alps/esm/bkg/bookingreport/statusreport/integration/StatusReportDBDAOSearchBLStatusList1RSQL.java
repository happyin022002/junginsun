/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : StatusReportDBDAOSearchBLStatusList1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2018.05.02 
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

public class StatusReportDBDAOSearchBLStatusList1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchBLStatusList1RSQL
	  * * History
	  * 2012.03.26 김보배 [CHM-201216886] [BKG] [Booking Status Report] Vessel Name 아이템 조회결과 제한 제거
	  * 2012.04.06 김보배 [CHM-201217102] [BKG] [Booking Status Report] Item option 추가
	  * 2014.07.15 신선희 [CHM-201430931] [BKG] [Booking Status Report] FUMG_LOC_CD, SPCL_HIDE_LNR_FLG 컬럼추가
	  * 2014.09.19 신선희 [CHM-201432022] [BKG] [Booking Status Report] SI_CNTC_PSON_EML,SI_CNTC_PSON_PHN_NO 추가
	  * 2014.11.03 신선희 SPOT GUIDE RFA 조회조건 추가, ETB 출력 추가
	  * 2014.12.15 신선희 VEHICLE 조회조건 추가
	  * 2014.12.30 신선희 CTRT_CNG_TP_CD, PRE_SC_NO, PRE_RFA_NO, PRE_TAA_NO 추가
	  * 2015.01.20 신선희 RTRO_KND_CD 조회조건, 출력 추가
	  * 2015.06.22 COA_MON_VVD ==>MAS_MON_VVD,  COA_RGST_BKG ==>MAS_RGST_BKG 변경
	  * </pre>
	  */
	public StatusReportDBDAOSearchBLStatusList1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cargo_tp_f",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("non_rd_sts_f",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cargo_tp_r",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rct_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("board_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_sts_cd_s",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("certi_b",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("certi_a",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("l_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fv_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("orderby",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_sts_cd_f",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_sts_cd_a",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_sts_cd_f",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("b_staff_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_certi",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calling_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("curr_page",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rows_per_page",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_rd_sts_r",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_sts_cd_x",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBLStatusList1RSQL").append("\n"); 
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
		query.append("SELECT QQ.*, KK.RTRO_KND_CD_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("          ROWNUM RNUM" ).append("\n"); 
		query.append("        , ${orderby_title_sql} ORDERBY_TITLE" ).append("\n"); 
		query.append("        , TRIM(TO_CHAR(SUM(TEU) OVER() ,'999999990.99')) TOTAL_TEU" ).append("\n"); 
		query.append("        , TRIM(TO_CHAR(SUM(FEU) OVER() ,'999999990.99')) TOTAL_FEU" ).append("\n"); 
		query.append("        , TRIM(TO_CHAR(ROUND(SUM(BKG_ACTWGT_QTY) OVER() /1000) ,'999,999,999'))  TOTAL_WGT" ).append("\n"); 
		query.append("		, TRIM(TO_CHAR(SUM(BKG_MEA_QTY) OVER() ,'999,999,990.999')) TOTAL_MEA" ).append("\n"); 
		query.append("        ,ZZ.*" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("              COUNT(1) OVER() TOTAL_CNT" ).append("\n"); 
		query.append("    	    , COUNT(DISTINCT BKG_NO) OVER() TOTAL_BKG" ).append("\n"); 
		query.append("	        , COUNT(DISTINCT BL_NO) OVER() TOTAL_BL" ).append("\n"); 
		query.append("            , COUNT(DISTINCT ${orderby_select} ) OVER() ORDERBY_CNT" ).append("\n"); 
		query.append("            , @[last_orderby] LAST_ORDERBY" ).append("\n"); 
		query.append("            , @[orderby] ORDERBY" ).append("\n"); 
		query.append("            , '' ROWS_PER_PAGE" ).append("\n"); 
		query.append("            , '' CURR_PAGE" ).append("\n"); 
		query.append("            , Z.*" ).append("\n"); 
		query.append("            /*Z Alias*/" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                    SELECT Y.* ,COST_WK" ).append("\n"); 
		query.append("                    /*Y Alias*/" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                            SELECT" ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'D2',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_D2," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'D3',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_D3," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'D4',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_D4," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'D5',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_D5," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'D7',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_D7," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'D9',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_D9," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'DX',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_DX," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'R2',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_R2," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'R4',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_R4," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'R5',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_R5," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'R9',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_R9," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'F2',NVL(OP_CNTR_QTY,0),'A2',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_F2," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'F4',NVL(OP_CNTR_QTY,0),'A4',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_F4," ).append("\n"); 
		query.append("                                    --( SELECT SUM(DECODE(CNTR_TPSZ_CD,'F5',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_F5," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'F5',NVL(OP_CNTR_QTY,0),'A5',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_F5," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'T2',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_T2," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'T4',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_T4," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'P2',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_P2," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'P4',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_P4," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'O2',NVL(OP_CNTR_QTY,0),'S2',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_O2," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'O4',NVL(OP_CNTR_QTY,0),'S4',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_O4," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'O5',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_O5," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'O7',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_O7," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'Z2',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_Z2," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'Z4',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_Z4," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'Q2',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_Q2," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'Q4',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_Q4," ).append("\n"); 
		query.append("                                    ( SELECT SUM(DECODE(CNTR_TPSZ_CD,'Q5',NVL(OP_CNTR_QTY,0),0)) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) RD_TOTAL_Q5," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                    ( SELECT TRIM(TO_CHAR(SUM(DECODE(GREATEST('2', SUBSTR(CNTR_TPSZ_CD, 2, 1)), '2', NVL(OP_CNTR_QTY, 0), 0)) , '999999990.99')) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) TEU," ).append("\n"); 
		query.append("                                    ( SELECT TRIM(TO_CHAR(SUM(DECODE(GREATEST('2', SUBSTR(CNTR_TPSZ_CD, 2, 1)), '2', 0, NVL(OP_CNTR_QTY, 0))) , '999999990.99')) FROM BKG_QUANTITY WHERE BKG_NO = X.BKG_NO ) FEU," ).append("\n"); 
		query.append("                                    ( SELECT TRIM(TO_CHAR(SUM(DECODE(GREATEST('2', SUBSTR(CNTR_TPSZ_CD, 2, 1)), '2', 1, 0)) , '999999990.99')) FROM BKG_CONTAINER WHERE BKG_NO = X.BKG_NO ) ACTIVITY_TEU," ).append("\n"); 
		query.append("                                    ( SELECT TRIM(TO_CHAR(SUM(DECODE(GREATEST('2', SUBSTR(CNTR_TPSZ_CD, 2, 1)), '2', 0, 1)) , '999999990.99')) FROM BKG_CONTAINER WHERE BKG_NO = X.BKG_NO ) ACTIVITY_FEU" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                , ( SELECT /*+ index_desc (XPT_IMP XPKBKG_XPT_IMP_LIC) */ DECODE(XPT_IMP.AES_TP_CD,'AE',XPT_IMP.AES_INLND_TRNS_PFX_CTNT||XPT_IMP.AES_INLND_TRNS_NO," ).append("\n"); 
		query.append("                                                                   'PA',XPT_IMP.AES_PTA_PFX_CTNT||' '||XPT_IMP.AES_PTA_NO1||'-'||XPT_IMP.AES_PTA_NO2||' '||TO_CHAR(XPT_IMP.AES_PTA_DT,'MM/DD/YYYY')," ).append("\n"); 
		query.append("                                                                   'PU',XPT_IMP.AES_PTU_PFX_CTNT||' '||XPT_IMP.AES_PTU_NO||' '||TO_CHAR(XPT_IMP.AES_PTU_DT,'MM/DD/YYYY')," ).append("\n"); 
		query.append("                                                                   'DN',XPT_IMP.AES_DWN_PFX_CTNT||' '||XPT_IMP.AES_DWN_NO||' '||TO_CHAR(XPT_IMP.AES_DWN_DT,'MM/DD/YYYY')," ).append("\n"); 
		query.append("                                                                   'EX',DECODE(XPT_IMP.AES_EXPT_CTNT,'L',HARD.ATTR_CTNT7," ).append("\n"); 
		query.append("                                                                                                     'T',HARD.ATTR_CTNT6," ).append("\n"); 
		query.append("                                                                                                     'E',HARD.ATTR_CTNT5," ).append("\n"); 
		query.append("                                                                                                     'C',HARD.ATTR_CTNT4," ).append("\n"); 
		query.append("                                                                                                     'U',HARD.ATTR_CTNT3,XPT_IMP.AES_EXPT_CTNT,' '),' ')" ).append("\n"); 
		query.append("                                     FROM BKG_XPT_IMP_LIC XPT_IMP, BKG_HRD_CDG_CTNT HARD" ).append("\n"); 
		query.append("                                     WHERE XPT_IMP.BKG_NO    = X.BKG_NO" ).append("\n"); 
		query.append("                                     AND   XPT_IMP.IO_BND_CD ='O'" ).append("\n"); 
		query.append("                                     AND   XPT_IMP.CNT_CD = 'US'" ).append("\n"); 
		query.append("                                     AND   HARD.HRD_CDG_ID   = 'AES_COLUMN_NAME'" ).append("\n"); 
		query.append("                                     AND   ROWNUM = 1" ).append("\n"); 
		query.append("                                   ) AS AES_NO" ).append("\n"); 
		query.append("                                 , ( SELECT /*+ index_desc (XPT_IMP XPKBKG_XPT_IMP_LIC) */ DECODE(XPT_IMP.CAED_TP_CD,'CE', XPT_IMP.CAED_PFX_CTNT       ||XPT_IMP.CAED_NO1       ||XPT_IMP.CAED_NO2    ||XPT_IMP.CAED_NO3," ).append("\n"); 
		query.append("                                                                      'G7', XPT_IMP.G7_EDI_PFX_CTNT     ||XPT_IMP.G7_EDI_NO1     ||XPT_IMP.G7_EDI_NO2," ).append("\n"); 
		query.append("                                                                      'SM', XPT_IMP.MF_SMRY_RPT_PFX_CTNT||XPT_IMP.MF_SMRY_RPT_NO," ).append("\n"); 
		query.append("                                                                      'EX', XPT_IMP.B13A_XPT_PFX_CTNT   ||XPT_IMP.B13A_XPT_NO1   ||XPT_IMP.B13A_XPT_NO2 ||TO_CHAR(XPT_IMP.B13A_XPT_DT,'YYYYMMDDHHMM')," ).append("\n"); 
		query.append("                                                                      'IT', XPT_IMP.CGO_CTRL_PFX_CTNT   ||XPT_IMP.CGO_CTRL_NO," ).append("\n"); 
		query.append("                                                                      'ND', XPT_IMP.NDR_REF_PFX_CTNT    ||NDR_REF_ID,' ')" ).append("\n"); 
		query.append("                                     FROM BKG_XPT_IMP_LIC XPT_IMP" ).append("\n"); 
		query.append("                                     WHERE XPT_IMP.BKG_NO      = X.BKG_NO" ).append("\n"); 
		query.append("                                     AND   XPT_IMP.IO_BND_CD   ='O'" ).append("\n"); 
		query.append("                                     AND   XPT_IMP.CNT_CD = 'CA'" ).append("\n"); 
		query.append("                                     AND   ROWNUM = 1" ).append("\n"); 
		query.append("                                   ) AS CAED_NO" ).append("\n"); 
		query.append("                                 , ( SELECT MAX(NVL(VPS.SHP_CALL_NO,' '))" ).append("\n"); 
		query.append("                                      FROM  VSK_VSL_PORT_SKD VPS, BKG_VVD VVD" ).append("\n"); 
		query.append("                                      WHERE 1=1" ).append("\n"); 
		query.append("									  AND   X.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("									  AND   VVD.POL_CD LIKE 'MYPKG%'" ).append("\n"); 
		query.append("                                      AND   VVD.VSL_CD      = VPS.VSL_CD" ).append("\n"); 
		query.append("                                      AND   VVD.SKD_VOY_NO  = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      AND   VVD.SKD_DIR_CD  = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("									  AND   VVD.POL_CD 		= VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("                                      AND   CLPT_IND_SEQ ='1'" ).append("\n"); 
		query.append("                                  ) AS   SHP_CALL_NO /*CRN*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                 , ( SELECT VSL_ENG_NM FROM MDM_VSL_CNTR VSL, BKG_VVD VVD" ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("									 AND X.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("									 AND X.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("									 AND X.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                                     AND X.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                     AND X.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("									 AND VVD.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("									 AND ROWNUM = 1" ).append("\n"); 
		query.append("                                  ) AS VSL_ENG_NM  /*Vessel_name*/" ).append("\n"); 
		query.append("                                 , ( SELECT C.ECC_CD" ).append("\n"); 
		query.append("                                     FROM MDM_LOCATION A, MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("                                     WHERE 1 = 1" ).append("\n"); 
		query.append("                                     AND A.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("                                     AND A.LOC_CD like SUBSTR(ESTM_IB_MTY_RTN_YD_CD,0,5) || '%'" ).append("\n"); 
		query.append("                                     AND A.CNT_CD =  SUBSTR(ESTM_IB_MTY_RTN_YD_CD,0,2)" ).append("\n"); 
		query.append("                                     AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                                  ) ECC_CD" ).append("\n"); 
		query.append("                                  , X.*" ).append("\n"); 
		query.append("                                ,CASE " ).append("\n"); 
		query.append("                                     WHEN (SELECT COUNT(*) FROM BKG_BL_CERTI K WHERE K.BL_NO = X.BKG_NO AND K.BL_CERTI_STS_CD IN ('I') AND K.TMPLT_FLG = 'N') = 0 AND" ).append("\n"); 
		query.append("                                          (SELECT COUNT(*) FROM BKG_BL_CERTI K WHERE K.BL_NO = X.BL_NO  AND K.BL_CERTI_STS_CD = 'C' AND K.TMPLT_FLG = 'N') = 0 AND" ).append("\n"); 
		query.append("                                          NVL((SELECT 'Y' FROM BKG_IMG_STO K WHERE K.BKG_NO = X.BL_NO AND K.RIDR_TP_CD = 'K' AND ROWNUM =1 ),'N') != 'Y'" ).append("\n"); 
		query.append("                                     THEN 'N'" ).append("\n"); 
		query.append("                                     ELSE 'Y'" ).append("\n"); 
		query.append("                                END BL_CERTI     " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("                            /*X Alias*/" ).append("\n"); 
		query.append("                            FROM (" ).append("\n"); 
		query.append("                                    SELECT" ).append("\n"); 
		query.append("												#if (${vvd_cd} == '')" ).append("\n"); 
		query.append("													#if (${bkg_from_dt} != '')" ).append("\n"); 
		query.append("                                           				#if (${l_ofc_cd} != '')" ).append("\n"); 
		query.append("                                            				#if(${l_ofc_cd_sub} != '')" ).append("\n"); 
		query.append("                                             					/*+ NO_MERGE(VB DMT_OFC_LVL_V) USE_NL(VB MDM_LOCATION XPT_IMP) OPT_PARAM('_optimizer_skip_scan_enabled','FALSE') */" ).append("\n"); 
		query.append("                                            				#else" ).append("\n"); 
		query.append("                                             					/*+ NO_MERGE(VB) USE_NL(VB MDM_LOCATION XPT_IMP) OPT_PARAM('_optimizer_skip_scan_enabled','FALSE') */" ).append("\n"); 
		query.append("                                            				#end" ).append("\n"); 
		query.append("														#else" ).append("\n"); 
		query.append("															/*+ NO_MERGE(VB) USE_NL(VB MDM_LOCATION XPT_IMP) OPT_PARAM('_optimizer_skip_scan_enabled','FALSE') */" ).append("\n"); 
		query.append("                                           				#end" ).append("\n"); 
		query.append("            		                               #end" ).append("\n"); 
		query.append("												#end" ).append("\n"); 
		query.append("											  DISTINCT" ).append("\n"); 
		query.append("                                              VB.BKG_NO          AS BKG_NO" ).append("\n"); 
		query.append("                                            , VB.BL_NO||VB.BL_TP_CD AS BL_NO" ).append("\n"); 
		query.append("                                            , VB.BKG_STS_CD      AS BKG_STS_CD" ).append("\n"); 
		query.append("                                            , VB.BDR_FLG         AS BDR_FLG" ).append("\n"); 
		query.append("                                            , VB.SI_FLG          AS SI_FLG" ).append("\n"); 
		query.append("                                            , VB.BKG_OFC_CD      AS BKG_OFC_CD" ).append("\n"); 
		query.append("                                            , VB.CTRT_OFC_CD     AS CTRT_OFC_CD" ).append("\n"); 
		query.append("                                            , VB.OB_SLS_OFC_CD   AS OB_SLS_OFC_CD" ).append("\n"); 
		query.append("                                            , VB.EQ_CTRL_OFC_CD  AS BKG_CTRL_OFC_CD" ).append("\n"); 
		query.append("                                            , MDM_LOCATION.EQ_CTRL_OFC_CD AS EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	                                        , VB.INTER_RMK" ).append("\n"); 
		query.append("                                            , DECODE(VB.XTER_RMK,NULL,'N','Y')  AS REMARK" ).append("\n"); 
		query.append("											, DECODE(VB.INTER_RMK,NULL,'N','Y') AS INTER_REMARK" ).append("\n"); 
		query.append("											, DECODE(RA.RT_INTER_RMK,NULL,'N','Y') AS CHG_INTER_REMARK" ).append("\n"); 
		query.append("											, DECODE(RA.DIFF_RMK,NULL,'N','Y') AS CHG_XTER_REMARK" ).append("\n"); 
		query.append("                                            , SUBSTR(REPLACE(REPLACE(REPLACE(VB.XTER_RMK, CHR(13)||CHR(10), ' '),CHR(13),' '), CHR(10), ' '),1,200)  AS REMARK_DETAIL        " ).append("\n"); 
		query.append("											, SUBSTR(VB.INTER_RMK,1,200) AS INTER_REMARK_DETAIL" ).append("\n"); 
		query.append("											, SUBSTR(RA.RT_INTER_RMK,1,200) AS CHG_INTER_REMARK_DETAIL" ).append("\n"); 
		query.append("											, SUBSTR(RA.DIFF_RMK,1,200) AS CHG_XTER_REMARK_DETAIL" ).append("\n"); 
		query.append("											, CASE WHEN VB.BKG_CRE_DT >= TO_DATE('20141125','YYYYMMDD') THEN RA.OFT_MSS_FLG " ).append("\n"); 
		query.append("														WHEN SUBSTR(VB.SC_NO,1,3) = 'DUM' OR SUBSTR(VB.RFA_NO,1,3) = 'DUM' OR SUBSTR(VB.TAA_NO,1,3) = 'DUM' THEN 'Y' " ).append("\n"); 
		query.append("														WHEN RA.OFT_MSS_FLG = 'N' THEN 'N'" ).append("\n"); 
		query.append("														WHEN RA.OFT_MSS_FLG = 'Y' THEN NVL((SELECT 'N'" ).append("\n"); 
		query.append("																														FROM BKG_CHG_RT RT" ).append("\n"); 
		query.append("														  															    WHERE RT.BKG_NO = RA.BKG_NO" ).append("\n"); 
		query.append("																														AND ROWNUM = 1), 'Y')" ).append("\n"); 
		query.append("											  END AS RATE_CHK_STS" ).append("\n"); 
		query.append("                                            , VB.CMDT_CD         AS COMMODITY" ).append("\n"); 
		query.append("                                            , VB.CMDT_NM         AS CMDT_NM" ).append("\n"); 
		query.append("                                            , VB.REP_CMDT_CD     AS REP" ).append("\n"); 
		query.append("                                            /* TEU */" ).append("\n"); 
		query.append("                                            , VB.RCV_TERM_CD     AS RCV_TERM_CD" ).append("\n"); 
		query.append("                                            , VB.DE_TERM_CD      AS DE_TERM_CD" ).append("\n"); 
		query.append("                                            , VB.DOC_USR_ID      AS DOC_USR_ID" ).append("\n"); 
		query.append("                                            , VB.CTRT_SREP_CD    AS CTRT_SREP_CD" ).append("\n"); 
		query.append("                                            , VB.OB_SREP_CD      AS OB_SREP_CD" ).append("\n"); 
		query.append("        	                                , VB.FRT_TERM_CD	 AS FRT_TERM_CD" ).append("\n"); 
		query.append("                                            , VB.SC_NO           AS SC_NO" ).append("\n"); 
		query.append("                                            , NVL(VB.RFA_NO,' ') AS RFA_NO" ).append("\n"); 
		query.append("    	                                    , VB.TAA_NO" ).append("\n"); 
		query.append("                                            ,(SELECT XPT_IMP.AES_TP_CD FROM BKG_XPT_IMP_LIC XPT_IMP WHERE XPT_IMP.BKG_NO = VB.BKG_NO AND XPT_IMP.IO_BND_CD ='O' AND XPT_IMP.CNT_CD = 'US' AND ROWNUM = 1) ITN_TYPE" ).append("\n"); 
		query.append("                                            ,(SELECT XPT_IMP.CAED_TP_CD FROM BKG_XPT_IMP_LIC XPT_IMP WHERE XPT_IMP.BKG_NO = VB.BKG_NO AND XPT_IMP.IO_BND_CD ='O' AND XPT_IMP.CNT_CD = 'CA' AND ROWNUM = 1) CAED_TYPE" ).append("\n"); 
		query.append("                                            ,(SELECT DECODE(XPT_IMP.AES_TP_CD,NULL,'N','Y') FROM BKG_XPT_IMP_LIC XPT_IMP WHERE XPT_IMP.BKG_NO = VB.BKG_NO AND XPT_IMP.IO_BND_CD ='O' AND XPT_IMP.CNT_CD = 'US' AND ROWNUM = 1) ITN_FLG" ).append("\n"); 
		query.append("                                            ,(SELECT DECODE(XPT_IMP.CAED_TP_CD,NULL,'N','Y') FROM BKG_XPT_IMP_LIC XPT_IMP WHERE XPT_IMP.BKG_NO = VB.BKG_NO AND XPT_IMP.IO_BND_CD ='O' AND XPT_IMP.CNT_CD = 'CA' AND ROWNUM = 1) CAED_FLG" ).append("\n"); 
		query.append("                                         -- , XPT_IMP.AES_TP_CD	 AS ITN_TYPE" ).append("\n"); 
		query.append("                                         -- , XPT_IMP.CAED_TP_CD AS	CAED_TYPE" ).append("\n"); 
		query.append("                                         -- , DECODE(XPT_IMP.AES_TP_CD,NULL,'N','Y')  AS ITN_FLG" ).append("\n"); 
		query.append("                                         -- , DECODE(XPT_IMP.CAED_TP_CD,NULL,'N','Y') AS CAED_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            , TO_CHAR(VB.BKG_CRE_DT,'YYYY-MM-DD')  AS BKG_CRE_DT" ).append("\n"); 
		query.append("                                            , NVL(DECODE(VB.SHIPPER,'0',' ',SUBSTR(VB.SHIPPER,1,2)||LTRIM(TO_CHAR(SUBSTR(VB.SHIPPER,3),'000000'))),' ')        AS SHIPPER" ).append("\n"); 
		query.append("                                            , NVL(DECODE(VB.CONSIGNEE,'0',' ',SUBSTR(VB.CONSIGNEE,1,2)||LTRIM(TO_CHAR(SUBSTR(VB.CONSIGNEE,3),'000000'))),' ')  AS CONSIGNEE" ).append("\n"); 
		query.append("                                            , NVL(DECODE(VB.NTFY,'0',' ',SUBSTR(VB.NTFY,1,2)||LTRIM(TO_CHAR(SUBSTR(VB.NTFY,3),'000000'))),' ') AS NTFY" ).append("\n"); 
		query.append("                                            , NVL(DECODE(VB.FFDR,'0',' ',SUBSTR(VB.FFDR,1,2)||LTRIM(TO_CHAR(SUBSTR(VB.FFDR,3),'000000'))),' ') AS FFDR" ).append("\n"); 
		query.append("    										, VB.SHIPPER   AS SHIPPER_CD" ).append("\n"); 
		query.append("    										, VB.CONSIGNEE AS CONSIGNEE_CD" ).append("\n"); 
		query.append("                                            , REPLACE(VB.SHPR_NAME,CHR(13)||CHR(10),' ')      AS SHPR_NAME" ).append("\n"); 
		query.append("                                            , REPLACE(VB.CONSIGNEE_NAME,CHR(13)||CHR(10),' ') AS CNEE_NAME" ).append("\n"); 
		query.append("                                            , VB.NTFY_NAME       AS NTFY_NAME" ).append("\n"); 
		query.append("                                            , VB.ANTY_NAME       AS ANTY_NAME" ).append("\n"); 
		query.append("                                            , VB.FFDR_NAME       AS FFDR_NAME" ).append("\n"); 
		query.append("                                            , VB.EXPT_NAME       AS EXPT_NAME" ).append("\n"); 
		query.append("    										, VB.S_ADDR /* Shipper Address   */" ).append("\n"); 
		query.append("    										, VB.C_ADDR /* Consignee Address */" ).append("\n"); 
		query.append("    										, VB.N_ADDR /* Notify Address    */" ).append("\n"); 
		query.append("                                            , DECODE(VB.CUST_TO_ORD_FLG,'N',VB.CONSIGNEE_NAME,VB.NTFY_NAME) AS CUST_TO_ORD_NAME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            , VB.SLAN_CD         AS SLAN_CD" ).append("\n"); 
		query.append("                                            , VB.TRUNK_VVD       AS TRUNK_VVD" ).append("\n"); 
		query.append("                                            , VB.TRUNK_POL       AS TRUNK_POL" ).append("\n"); 
		query.append("                                            , VB.TRUNK_POD       AS TRUNK_POD" ).append("\n"); 
		query.append("                                            , VB.POR_CD          AS POR_CD" ).append("\n"); 
		query.append("                                            , VB.DEL_CD          AS DEL_CD" ).append("\n"); 
		query.append("                                            , VB.ORG_TRNS_SVC_MOD_CD    AS ORG_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append("                                            , VB.DEST_TRNS_SVC_MOD_CD   AS DEST_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append("											#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("											, VB.POR_NOD_CD             AS POR_NOD_CD" ).append("\n"); 
		query.append("											#else" ).append("\n"); 
		query.append("											, VB.POR_NODE               AS POR_NOD_CD" ).append("\n"); 
		query.append("											#end" ).append("\n"); 
		query.append("    										, VB.DEL_NOD_CD             AS DEL_NOD_CD" ).append("\n"); 
		query.append("                                            , VB.FNL_DEST_CD            AS FNL_DEST_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            , VB.KEY_POL_CD       AS POL_CD" ).append("\n"); 
		query.append("                                            , VB.KEY_POD_CD       AS POD_CD" ).append("\n"); 
		query.append("                                            , VB.PRE_1_VVD        AS PRE_1_VVD" ).append("\n"); 
		query.append("                                            , VB.PRE_2_VVD        AS PRE_2_VVD" ).append("\n"); 
		query.append("                                            , VB.PRE_3_VVD        AS PRE_3_VVD" ).append("\n"); 
		query.append("                                            , VB.PRE_4_VVD        AS PRE_4_VVD" ).append("\n"); 
		query.append("                                            , VB.POST_1_VVD       AS POST_1_VVD" ).append("\n"); 
		query.append("                                            , VB.POST_2_VVD       AS POST_2_VVD" ).append("\n"); 
		query.append("                                            , VB.POST_3_VVD       AS POST_3_VVD" ).append("\n"); 
		query.append("                                            , VB.POST_4_VVD       AS POST_4_VVD" ).append("\n"); 
		query.append("                                            , VB.PRE_1_POL_CD     AS PRE_1_POL_CD" ).append("\n"); 
		query.append("                                            , VB.PRE_2_POL_CD     AS PRE_2_POL_CD" ).append("\n"); 
		query.append("                                            , VB.PRE_3_POL_CD     AS PRE_3_POL_CD" ).append("\n"); 
		query.append("                                            , VB.PRE_4_POL_CD     AS PRE_4_POL_CD" ).append("\n"); 
		query.append("                                            , VB.PRE_1_POD_CD     AS PRE_1_POD_CD" ).append("\n"); 
		query.append("                                            , VB.PRE_2_POD_CD     AS PRE_2_POD_CD" ).append("\n"); 
		query.append("                                            , VB.PRE_3_POD_CD     AS PRE_3_POD_CD" ).append("\n"); 
		query.append("                                            , VB.PRE_4_POD_CD     AS PRE_4_POD_CD" ).append("\n"); 
		query.append("                                            , VB.POST_1_POL_CD    AS POST_1_POL_CD" ).append("\n"); 
		query.append("                                            , VB.POST_2_POL_CD    AS POST_2_POL_CD" ).append("\n"); 
		query.append("                                            , VB.POST_3_POL_CD    AS POST_3_POL_CD" ).append("\n"); 
		query.append("                                            , VB.POST_4_POL_CD    AS POST_4_POL_CD" ).append("\n"); 
		query.append("                                            , VB.POST_1_POD_CD    AS POST_1_POD_CD" ).append("\n"); 
		query.append("                                            , VB.POST_2_POD_CD    AS POST_2_POD_CD" ).append("\n"); 
		query.append("                                            , VB.POST_3_POD_CD    AS POST_3_POD_CD" ).append("\n"); 
		query.append("                                            , VB.POST_4_POD_CD    AS POST_4_POD_CD" ).append("\n"); 
		query.append("                                            , VB.KEY_POL_CD       AS KEY_POL_CD" ).append("\n"); 
		query.append("                                            , VB.KEY_POD_CD       AS KEY_POD_CD" ).append("\n"); 
		query.append("                                            , VB.KEY_VSL_CD       AS KEY_VSL_CD" ).append("\n"); 
		query.append("                                            , VB.KEY_SKD_VOY_NO   AS KEY_SKD_VOY_NO" ).append("\n"); 
		query.append("                                            , VB.KEY_SKD_DIR_CD   AS KEY_SKD_DIR_CD" ).append("\n"); 
		query.append("                                            , VB.KEY_VSL_CD       AS VSL_CD" ).append("\n"); 
		query.append("        	                                , VB.KEY_SKD_VOY_NO   AS SKD_VOY_NO" ).append("\n"); 
		query.append("    	                                    , VB.KEY_SKD_DIR_CD   AS SKD_DIR_CD" ).append("\n"); 
		query.append("	                                        , VB.KEY_POL_CD       AS VD_POL_CD" ).append("\n"); 
		query.append("                                            , VB.POL_CD           AS ACTUAL_POL" ).append("\n"); 
		query.append("                                            , VB.POD_CD           AS ACTUAL_POD" ).append("\n"); 
		query.append("    										, VB.ORG_SCONTI_CD    AS ORG_SVC_ROUTE" ).append("\n"); 
		query.append("                                            , VB.DEST_SCONTI_CD   AS DEST_SVC_ROUTE" ).append("\n"); 
		query.append("                                            , DECODE(VB.PRE_1_POL_CD,NULL,' ',NVL(VB.PRE_1_POL_CD,' ')," ).append("\n"); 
		query.append("                                                    DECODE(VB.PRE_2_POL_CD,NULL,NVL(VB.PRE_1_POL_CD,' ')," ).append("\n"); 
		query.append("                                                    DECODE(VB.PRE_3_POL_CD,NULL,NVL(VB.PRE_2_POL_CD,' ')," ).append("\n"); 
		query.append("                                                     DECODE(VB.PRE_4_POL_CD,NULL,NVL(VB.PRE_3_POL_CD,' '),NVL(VB.PRE_4_POL_CD,' ')))))   AS SORT_PRE_POL" ).append("\n"); 
		query.append("                                            , DECODE(VB.PRE_1_POD_CD, NULL,' '," ).append("\n"); 
		query.append("                                                    DECODE(VB.PRE_2_POD_CD,NULL,NVL(VB.PRE_1_POD_CD,' ')," ).append("\n"); 
		query.append("                                                     DECODE(VB.PRE_3_POD_CD,NULL,NVL(VB.PRE_2_POD_CD,' ')," ).append("\n"); 
		query.append("                                                     DECODE(VB.PRE_4_POD_CD,NULL,NVL(VB.PRE_3_POD_CD,' '),NVL(VB.PRE_4_POD_CD,' ')))))   AS SORT_PRE_POD" ).append("\n"); 
		query.append("                                            , DECODE(VB.POST_1_POL_CD,NULL,' '," ).append("\n"); 
		query.append("                                                   DECODE(VB.POST_2_POL_CD,NULL,NVL(VB.POST_1_POL_CD,' ')," ).append("\n"); 
		query.append("                                                     DECODE(VB.POST_3_POL_CD,NULL,NVL(VB.POST_2_POL_CD,' ')," ).append("\n"); 
		query.append("                                                     DECODE(VB.POST_4_POL_CD,NULL,NVL(VB.POST_3_POL_CD,' '),NVL(VB.POST_4_POL_CD,' '))))) AS SORT_POST_POL" ).append("\n"); 
		query.append("                                            , DECODE(VB.POST_1_POD_CD,NULL,' '," ).append("\n"); 
		query.append("                                                     DECODE(VB.POST_2_POD_CD,NULL,NVL(VB.POST_1_POD_CD,' ')," ).append("\n"); 
		query.append("                                                     DECODE(VB.POST_3_POD_CD,NULL,NVL(VB.POST_2_POD_CD,' ')," ).append("\n"); 
		query.append("                                                     DECODE(VB.POST_4_POD_CD,NULL,NVL(VB.POST_3_POD_CD,' '),NVL(VB.POST_4_POD_CD,' '))))) AS SORT_POST_POD" ).append("\n"); 
		query.append("                                            , DECODE(VB.PRE_2_VVD,NULL,VB.PRE_1_VVD," ).append("\n"); 
		query.append("                                                     DECODE(VB.PRE_3_VVD,NULL,VB.PRE_2_VVD, DECODE(VB.PRE_4_VVD,NULL,VB.PRE_3_VVD,VB.PRE_4_VVD) )) AS SORT_PRE_VVD" ).append("\n"); 
		query.append("                                            , DECODE(VB.POST_1_VVD,NULL,' '," ).append("\n"); 
		query.append("                                                    DECODE(VB.POST_2_VVD,NULL,VB.POST_1_VVD," ).append("\n"); 
		query.append("                                                    DECODE(VB.POST_3_VVD,NULL,VB.POST_2_VVD," ).append("\n"); 
		query.append("                                                    DECODE(VB.POST_4_VVD,NULL,VB.POST_3_VVD,VB.POST_4_VVD)))) AS SORT_POST_VVD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            , ( SELECT EQ_CTRL_OFC_CD FROM MDM_LOCATION WHERE LOC_CD = VB.POR_CD ) AS POR_EQ_OFC" ).append("\n"); 
		query.append("                                            , ( SELECT EQ_CTRL_OFC_CD FROM MDM_LOCATION WHERE LOC_CD = VB.DEL_CD ) AS DEL_EQ_OFC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            , VB.BKG_CLZ_FLG      AS BKG_CLZ_FLG" ).append("\n"); 
		query.append("                                            , VB.HNGR_FLG         AS HNGR_FLG" ).append("\n"); 
		query.append("                                            , VB.SOC_FLG          AS SOC_FLG" ).append("\n"); 
		query.append("                                            , VB.EQ_SUBST_FLG     AS EQ_SUBST_FLG" ).append("\n"); 
		query.append("                                            , VB.RD_CGO_FLG       AS RD_CGO_FLG" ).append("\n"); 
		query.append("                                            , VB.HOT_DE_FLG       AS HOT_DE_FLG" ).append("\n"); 
		query.append("                                            , DECODE(VB.DCGO_FLG,'N','',VB.DCGO_FLG)       AS DCGO_FLG" ).append("\n"); 
		query.append("                                            , DECODE(VB.RC_FLG,'N','',VB.RC_FLG)           AS RC_FLG" ).append("\n"); 
		query.append("                                            , DECODE(VB.AWK_CGO_FLG,'N','',VB.AWK_CGO_FLG) AS AWK_CGO_FLG" ).append("\n"); 
		query.append("                                            , DECODE(VB.BB_CGO_FLG,'N','',VB.BB_CGO_FLG)   AS BB_CGO_FLG" ).append("\n"); 
		query.append("                                            , DECODE(VB.FD_GRD_FLG,'N','',VB.FD_GRD_FLG)   AS FD_GRD_FLG" ).append("\n"); 
		query.append("                                            , DECODE(VB.PRCT_FLG,'N','',VB.PRCT_FLG)       AS PC" ).append("\n"); 
		query.append("										    , NVL(VB.PCK_QTY,0)   AS PCK_QTY" ).append("\n"); 
		query.append("                                            , VB.PCK_TP_CD        AS PCK_TP_CD" ).append("\n"); 
		query.append("                                            , TRIM(TO_CHAR(DECODE(NVL(VB.ACT_WGT,0),  0, DECODE(NVL(VB.WGT_UT_CD,0),'LBS',ROUND(NVL(VB.ACT_WGT,0)*0.4536,3),NVL(VB.ACT_WGT,0))," ).append("\n"); 
		query.append("                                                                       DECODE(NVL(VB.WGT_UT_CD,0),'LBS',ROUND(NVL(VB.ACT_WGT,0)*0.4536,3),NVL(VB.ACT_WGT,0)) ),'999999999.999')) AS BKG_ACTWGT_QTY" ).append("\n"); 
		query.append("                                            , TRIM(TO_CHAR(DECODE(NVL(VB.MEAS_UT_CD, 0),'CBF',ROUND (NVL(VB.MEAS_QTY,0)*0.02), NVL(VB.MEAS_QTY,0)),'999999990.999')) AS BKG_MEA_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            , VB.CSTMS_DESC       AS CSTMS_DESC" ).append("\n"); 
		query.append("                                            , VB.CHN_AGN_CD       AS CHINA_AGENT_CD" ).append("\n"); 
		query.append("                                            , VB.CNTC_PSON_NM     AS CONTACT" ).append("\n"); 
		query.append("    										, VB.CNTC_PSON_PHN_NO AS TEL" ).append("\n"); 
		query.append("            	                            , VB.CNTC_PSON_EML" ).append("\n"); 
		query.append("    										, VB.SI_CNTC_PSON_PHN_NO" ).append("\n"); 
		query.append("            	                            , VB.SI_CNTC_PSON_EML" ).append("\n"); 
		query.append("    										, VB.STWG_CD" ).append("\n"); 
		query.append("    										, VB.BLCK_STWG_CD AS BLCK_STWG_CD" ).append("\n"); 
		query.append("    										, VB.OFC_TEAM_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    										, (SELECT DECODE(MAX(DECODE(FRT_TERM_CD,'P','P',''))||MAX(DECODE(FRT_TERM_CD,'C','C',''))" ).append("\n"); 
		query.append("    										 		 ,'PC','P,C'" ).append("\n"); 
		query.append("    										 		 ,MAX(DECODE(FRT_TERM_CD,'P','P',''))||MAX(DECODE(FRT_TERM_CD,'C','C','')) )" ).append("\n"); 
		query.append("    										     FROM BKG_CHG_RT" ).append("\n"); 
		query.append("    										    WHERE BKG_NO = VB.BKG_NO)		AS CHG_TERM_CD" ).append("\n"); 
		query.append("                                            , (SELECT B.AGMT_ACT_CNT_CD||LPAD(B.AGMT_ACT_CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("                                                 FROM MDM_CUSTOMER ACT_CUST" ).append("\n"); 
		query.append("                                                WHERE ACT_CUST.CUST_CNT_CD = B.AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append("                                                  AND ACT_CUST.CUST_SEQ = B.AGMT_ACT_CUST_SEQ) ACT_CUST_CODE /* Actual Customer */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            ,  (SELECT ACT_CUST.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                                  FROM MDM_CUSTOMER ACT_CUST" ).append("\n"); 
		query.append("                                                 WHERE ACT_CUST.CUST_CNT_CD = B.AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append("                                                   AND ACT_CUST.CUST_SEQ = B.AGMT_ACT_CUST_SEQ) ACT_CUST_NAME /* Actual Customer */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            ,  (SELECT  COUNT(1) VVD_COUNT" ).append("\n"); 
		query.append("                                                FROM BKG_VVD" ).append("\n"); 
		query.append("                                                WHERE BKG_NO           = VB.BKG_NO" ).append("\n"); 
		query.append("                                                AND VSL_CD IS NOT NULL)VVD_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            ,  (SELECT   COUNT(1) SKD_COUNT" ).append("\n"); 
		query.append("                                                FROM VSK_VSL_PORT_SKD POL," ).append("\n"); 
		query.append("                                                     VSK_VSL_PORT_SKD POD," ).append("\n"); 
		query.append("                                                     BKG_VVD VVD" ).append("\n"); 
		query.append("                                                WHERE BKG_NO           = VB.BKG_NO" ).append("\n"); 
		query.append("                                                AND VVD.VSL_CD       = POL.VSL_CD" ).append("\n"); 
		query.append("                                                AND VVD.SKD_VOY_NO   = POL.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                AND VVD.SKD_DIR_CD   = POL.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                AND VVD.POL_CD       = POL.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                AND NVL(VVD.POL_CLPT_IND_SEQ, 1) = POL.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                AND NVL(POL.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                                                AND VVD.VSL_CD       = POD.VSL_CD" ).append("\n"); 
		query.append("                                                AND VVD.SKD_VOY_NO   = POD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                AND VVD.SKD_DIR_CD   = POD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                AND VVD.POD_CD       = POD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                AND NVL(VVD.POD_CLPT_IND_SEQ, 1) = POD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                AND NVL(POD.SKD_CNG_STS_CD, 'X') <> 'S') SKD_CNT" ).append("\n"); 
		query.append("											     ,(SELECT TO_CHAR(VVPS.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') VPS_ETB_DT" ).append("\n"); 
		query.append("                                                  FROM VSK_VSL_PORT_SKD VVPS" ).append("\n"); 
		query.append("                                                  WHERE VVPS.VSL_CD = SUBSTR(NVL(VB.PRE_1_VVD,VB.TRUNK_VVD),1,4)" ).append("\n"); 
		query.append("                                                  AND VVPS.SKD_VOY_NO = SUBSTR(NVL(VB.PRE_1_VVD,VB.TRUNK_VVD),5,4)" ).append("\n"); 
		query.append("                                                  AND VVPS.SKD_DIR_CD = SUBSTR(NVL(VB.PRE_1_VVD,VB.TRUNK_VVD),9,1)" ).append("\n"); 
		query.append("                                                  AND VVPS.YD_CD = B.POL_NOD_CD" ).append("\n"); 
		query.append("                                                  AND NVL(VVPS.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("                                                  AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                  ) ETB_DT                                                " ).append("\n"); 
		query.append("											     ,(SELECT TO_CHAR(VVPS.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') ETD" ).append("\n"); 
		query.append("                                                  FROM VSK_VSL_PORT_SKD VVPS" ).append("\n"); 
		query.append("                                                  WHERE VVPS.VSL_CD = SUBSTR(NVL(VB.PRE_1_VVD,VB.TRUNK_VVD),1,4)" ).append("\n"); 
		query.append("                                                  AND VVPS.SKD_VOY_NO = SUBSTR(NVL(VB.PRE_1_VVD,VB.TRUNK_VVD),5,4)" ).append("\n"); 
		query.append("                                                  AND VVPS.SKD_DIR_CD = SUBSTR(NVL(VB.PRE_1_VVD,VB.TRUNK_VVD),9,1)" ).append("\n"); 
		query.append("                                                  AND VVPS.YD_CD = B.POL_NOD_CD" ).append("\n"); 
		query.append("                                                  AND NVL(VVPS.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("                                                  AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                  ) SAIL_DT" ).append("\n"); 
		query.append("                                            ,B.ALOC_STS_CD" ).append("\n"); 
		query.append("                                            ,B.NON_RT_STS_CD" ).append("\n"); 
		query.append("                                            ,NVL(NVL(NVL(VB.PRE_RFA_NO,VB.PRE_SC_NO),VB.PRE_TAA_NO),' ') PRE_CONTRAT" ).append("\n"); 
		query.append("                                            ,NVL(NVL(NVL(VB.RFA_NO,VB.SC_NO),VB.TAA_NO),' ') NOW_CONTRAT" ).append("\n"); 
		query.append("                                            ,VB.PRE_SC_NO" ).append("\n"); 
		query.append("                                            ,VB.PRE_RFA_NO" ).append("\n"); 
		query.append("                                            ,VB.PRE_TAA_NO                                            " ).append("\n"); 
		query.append("                                            ,NVL(VB.RTRO_KND_CD,'') RTRO_KND_CD" ).append("\n"); 
		query.append("                                            ,VB.PCTL_NO" ).append("\n"); 
		query.append("                                            ,( SELECT DEST_NOD_CD " ).append("\n"); 
		query.append("                                               FROM   PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("                                               WHERE  DTL.PCTL_NO        = VB.PCTL_NO" ).append("\n"); 
		query.append("                                                 AND    DTL.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                 AND    DTL.MTY_YD_FLG     = 'Y'" ).append("\n"); 
		query.append("                                                 AND    PCTL_IO_BND_CD     = 'I'" ).append("\n"); 
		query.append("                                                 AND    ROWNUM = 1 ) ESTM_IB_MTY_RTN_YD_CD" ).append("\n"); 
		query.append("											,B.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("                                            ,TO_CHAR(B.MTY_PKUP_DT,'YYYY-MM-DD HH24:MI') MTY_PKUP_DT" ).append("\n"); 
		query.append("                                            ,MAS.IOC_CD" ).append("\n"); 
		query.append("                      						,CASE WHEN  (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = VB.POR_CD) <> (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = VB.DEL_CD) THEN 'O'" ).append("\n"); 
		query.append("                           						  WHEN  (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = VB.POR_CD) = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = VB.DEL_CD) THEN 'I'" ).append("\n"); 
		query.append("                      						 END IOC_CD2" ).append("\n"); 
		query.append("											,NVL((SELECT DBMS_LOB.SUBSTR(CMDT_DESC, 4000, 1) FROM BKG_BL_MK_DESC WHERE BKG_NO=B.BKG_NO AND MK_SEQ=1),'') AS A_CMDT_DESC" ).append("\n"); 
		query.append("											,NVL((SELECT DBMS_LOB.SUBSTR(CMDT_DESC, 4000, 4001) FROM BKG_BL_MK_DESC WHERE BKG_NO=B.BKG_NO AND MK_SEQ=1),'') AS B_CMDT_DESC" ).append("\n"); 
		query.append("                                            FROM" ).append("\n"); 
		query.append("												#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                                                 BKG_WORK_V VB," ).append("\n"); 
		query.append("												#else" ).append("\n"); 
		query.append("												(SELECT" ).append("\n"); 
		query.append("                                                      B.BKG_NO," ).append("\n"); 
		query.append("                                                      B.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("                                                      B.BL_NO," ).append("\n"); 
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
		query.append("                                                      B.ORG_TRNS_SVC_MOD_CD," ).append("\n"); 
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
		query.append("                                                      REPLACE(REPLACE(REPLACE(B.XTER_RMK, CHR(13)||CHR(10), ' '),CHR(13),' '), CHR(10), ' ')   XTER_RMK," ).append("\n"); 
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
		query.append("                                                      CNTC1.CNTC_PSON_PHN_NO SI_CNTC_PSON_PHN_NO," ).append("\n"); 
		query.append("                                                      CNTC1.CNTC_PSON_EML SI_CNTC_PSON_EML," ).append("\n"); 
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
		query.append("                                                      V1.POL_YD_CD PRE_1_POL_YD_CD," ).append("\n"); 
		query.append("                                                      V1.POD_YD_CD PRE_1_POD_YD_CD," ).append("\n"); 
		query.append("                                                      V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD PRE_2_VVD," ).append("\n"); 
		query.append("                                                      V2.POL_CD PRE_2_POL_cd," ).append("\n"); 
		query.append("                                                      V2.POD_CD PRE_2_POD_cd," ).append("\n"); 
		query.append("                                                      V2.POL_YD_CD PRE_2_POL_YD_CD," ).append("\n"); 
		query.append("                                                      V2.POD_YD_CD PRE_2_POD_YD_CD," ).append("\n"); 
		query.append("                                                      V3.VSL_CD||V3.SKD_VOY_NO||V3.SKD_DIR_CD PRE_3_VVD," ).append("\n"); 
		query.append("                                                      V3.POL_CD PRE_3_POL_CD," ).append("\n"); 
		query.append("                                                      V3.POD_CD PRE_3_POD_CD," ).append("\n"); 
		query.append("                                                      V3.POL_YD_CD PRE_3_POL_YD_CD," ).append("\n"); 
		query.append("                                                      V3.POD_YD_CD PRE_3_POD_YD_CD," ).append("\n"); 
		query.append("                                                      V4.VSL_CD||V4.SKD_VOY_NO||V4.SKD_DIR_CD PRE_4_VVD," ).append("\n"); 
		query.append("                                                      V4.POL_CD PRE_4_POL_CD," ).append("\n"); 
		query.append("                                                      V4.POD_CD PRE_4_POD_CD," ).append("\n"); 
		query.append("                                                      V4.POL_YD_CD PRE_4_POL_YD_CD," ).append("\n"); 
		query.append("                                                      V4.POD_YD_CD PRE_4_POD_YD_CD," ).append("\n"); 
		query.append("                                                      V5.VSL_CD||V5.SKD_VOY_NO||V5.SKD_DIR_CD POST_1_VVD," ).append("\n"); 
		query.append("                                                      V5.POL_CD POST_1_POL_CD," ).append("\n"); 
		query.append("                                                      V5.POD_CD POST_1_POD_CD," ).append("\n"); 
		query.append("                                                      V5.POL_YD_CD POST_1_POL_YD_CD," ).append("\n"); 
		query.append("                                                      V5.POD_YD_CD POST_1_POD_YD_CD," ).append("\n"); 
		query.append("                                                      V6.VSL_CD||V6.SKD_VOY_NO||V6.SKD_DIR_CD POST_2_VVD," ).append("\n"); 
		query.append("                                                      V6.POL_CD POST_2_POL_CD," ).append("\n"); 
		query.append("                                                      V6.POD_CD POST_2_POD_CD," ).append("\n"); 
		query.append("                                                      V6.POL_YD_CD POST_2_POL_YD_CD," ).append("\n"); 
		query.append("                                                      V6.POD_YD_CD POST_2_POD_YD_CD," ).append("\n"); 
		query.append("                                                      V7.VSL_CD||V7.SKD_VOY_NO||V7.SKD_DIR_CD POST_3_VVD," ).append("\n"); 
		query.append("                                                      V7.POL_CD POST_3_POL_CD," ).append("\n"); 
		query.append("                                                      V7.POD_CD POST_3_POD_CD," ).append("\n"); 
		query.append("                                                      V7.POL_YD_CD POST_3_POL_YD_CD," ).append("\n"); 
		query.append("                                                      V7.POD_YD_CD POST_3_POD_YD_CD," ).append("\n"); 
		query.append("                                                      V8.VSL_CD||V8.SKD_VOY_NO||V8.SKD_DIR_CD POST_4_VVD," ).append("\n"); 
		query.append("                                                      V8.POL_CD POST_4_POL_CD," ).append("\n"); 
		query.append("                                                      V8.POD_CD POST_4_POD_CD," ).append("\n"); 
		query.append("                                                      V8.POL_YD_CD POST_4_POL_YD_CD," ).append("\n"); 
		query.append("                                                      V8.POD_YD_CD POST_4_POD_YD_CD," ).append("\n"); 
		query.append("                                                      V9.POL_CD TRUNK_POL," ).append("\n"); 
		query.append("                                                      V9.POD_CD TRUNK_POD," ).append("\n"); 
		query.append("													  V9.SLAN_CD TRUNK_LANE," ).append("\n"); 
		query.append("                                                      DECODE(B.STOP_OFF_LOC_CD, NULL, 'N', 'Y') STOP_OFF_LOC_CD," ).append("\n"); 
		query.append("                                                      D.SPCL_CGO_AUTH_KNT," ).append("\n"); 
		query.append("                                                      B.RC_FLG," ).append("\n"); 
		query.append("                                                      B.DCGO_FLG," ).append("\n"); 
		query.append("                                                      B.PRCT_FLG," ).append("\n"); 
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
		query.append("                                                      B.DEST_TRNS_MOD_CD," ).append("\n"); 
		query.append("                                                      SR.OFC_TEAM_CD," ).append("\n"); 
		query.append("                                                      B.FUMG_LOC_CD," ).append("\n"); 
		query.append("                                                      B.SPCL_HIDE_LNR_FLG," ).append("\n"); 
		query.append("                                                      B.VEH_CMDT_FLG," ).append("\n"); 
		query.append("                                                      B.CTRT_CNG_TP_CD," ).append("\n"); 
		query.append("                                                      B.PRE_SC_NO," ).append("\n"); 
		query.append("                                                      B.PRE_RFA_NO," ).append("\n"); 
		query.append("                                                      B.PRE_TAA_NO," ).append("\n"); 
		query.append("                                                      B.RTRO_KND_CD," ).append("\n"); 
		query.append("                                                      B.PCTL_NO," ).append("\n"); 
		query.append("													  B.NON_DG_CHEM_FLG" ).append("\n"); 
		query.append("                                                    FROM BKG_BOOKING B ," ).append("\n"); 
		query.append("                                                      BKG_BL_DOC D," ).append("\n"); 
		query.append("                                                      BKG_CNTC_PSON CNTC," ).append("\n"); 
		query.append("                                                      BKG_CNTC_PSON CNTC1," ).append("\n"); 
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
		query.append("                                                      AND B.BKG_NO = CNTC1.BKG_NO(+)" ).append("\n"); 
		query.append("                                                      AND CNTC1.BKG_CNTC_PSON_TP_CD(+) ='SI'" ).append("\n"); 
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
		query.append("													  #if ($blck_stwg_arr.size() > 0)" ).append("\n"); 
		query.append("													  AND B.BLCK_STWG_CD IN (" ).append("\n"); 
		query.append("														#foreach($blck_stwg_cd IN ${blck_stwg_arr})" ).append("\n"); 
		query.append("															#if($velocityCount < $blck_stwg_arr.size()) '$blck_stwg_cd' ," ).append("\n"); 
		query.append("															#else 								   '$blck_stwg_cd'" ).append("\n"); 
		query.append("															#end" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("						 							  )" ).append("\n"); 
		query.append("													  #end" ).append("\n"); 
		query.append("                                                      )  VB," ).append("\n"); 
		query.append("												#end" ).append("\n"); 
		query.append("                                                 MDM_LOCATION," ).append("\n"); 
		query.append("                                                 BKG_XPT_IMP_LIC XPT_IMP," ).append("\n"); 
		query.append("                                                 BKG_BOOKING B," ).append("\n"); 
		query.append("												 BKG_RATE RA," ).append("\n"); 
		query.append("                                                 BKG_VVD BVD" ).append("\n"); 
		query.append("                                                 , MAS_RGST_BKG MAS" ).append("\n"); 
		query.append("                                           #if (${rct_rhq_cd} != '')" ).append("\n"); 
		query.append("                                                 ,(" ).append("\n"); 
		query.append("                                                  SELECT        OFC_CD ,A.PRNT_OFC_CD " ).append("\n"); 
		query.append("                                                  FROM         MDM_ORGANIZATION A" ).append("\n"); 
		query.append("                                                  START WITH A.OFC_CD = @[rct_rhq_cd]" ).append("\n"); 
		query.append("                                                  CONNECT BY           PRIOR A.OFC_CD = A.PRNT_OFC_CD  " ).append("\n"); 
		query.append("                                                  ) OG                                                                                                  " ).append("\n"); 
		query.append("                                           #end    " ).append("\n"); 
		query.append("                                            WHERE VB.DEL_CD     = MDM_LOCATION.LOC_CD" ).append("\n"); 
		query.append("                                            AND   VB.BKG_NO     = XPT_IMP.BKG_NO(+)" ).append("\n"); 
		query.append("										    AND   XPT_IMP.IO_BND_CD(+) ='O'" ).append("\n"); 
		query.append("                                            AND   VB.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("											AND   B.BKG_NO = RA.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("                                             /* 1  vvd_cd  HJOL0084E CNSHA */" ).append("\n"); 
		query.append("                                            AND     VB.KEY_VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                            AND     VB.KEY_SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                            AND     VB.KEY_SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                             	#if ($blck_stwg_arr.size() > 0)" ).append("\n"); 
		query.append("											  	AND B.BLCK_STWG_CD IN (" ).append("\n"); 
		query.append("													#foreach($blck_stwg_cd IN ${blck_stwg_arr})" ).append("\n"); 
		query.append("														#if($velocityCount < $blck_stwg_arr.size()) '$blck_stwg_cd' ," ).append("\n"); 
		query.append("														#else 								   '$blck_stwg_cd'" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("													#end" ).append("\n"); 
		query.append("				 							  	)" ).append("\n"); 
		query.append("											  	#end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            AND VB.KEY_VSL_CD = BVD.VSL_CD" ).append("\n"); 
		query.append("                                            AND VB.KEY_SKD_VOY_NO = BVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                            AND VB.KEY_SKD_DIR_CD = BVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                            AND VB.KEY_POL_CD = BVD.POL_CD" ).append("\n"); 
		query.append("                                            AND B.BKG_NO = BVD.BKG_NO" ).append("\n"); 
		query.append("										   #if (${rct_rhq_cd} != '')                                            " ).append("\n"); 
		query.append("                                            AND B.BKG_OFC_CD = OG.OFC_CD" ).append("\n"); 
		query.append("										   #end      " ).append("\n"); 
		query.append("                                           #if (${calling_seq} != '')" ).append("\n"); 
		query.append("                                            AND BVD.POL_CLPT_IND_SEQ = @[calling_seq]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${trunk_flag} != '')" ).append("\n"); 
		query.append("                                            /* 2  trunk_flag */" ).append("\n"); 
		query.append("                                            AND   VB.VSL_PRE_PST_CD ='T'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${lane_cd} != '')" ).append("\n"); 
		query.append("                                            /* 3 lane_cd */" ).append("\n"); 
		query.append("                                            AND VB.TRUNK_LANE = @[lane_cd]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${dir_cd} != '')" ).append("\n"); 
		query.append("                                            /* 4  dir_cd */" ).append("\n"); 
		query.append("                                            AND VB.SKD_DIR_CD IN (${dir_cd})" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${pol_cd} != '')" ).append("\n"); 
		query.append("                                            /* 5  pol_cd */" ).append("\n"); 
		query.append("												#if (${board_from_dt} != '')" ).append("\n"); 
		query.append("		                                            AND VB.DOC_POL_CD > ' '" ).append("\n"); 
		query.append("												#end" ).append("\n"); 
		query.append("													AND VB.KEY_POL_CD LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${pol_yard_cd} != '')" ).append("\n"); 
		query.append("                                            /* 6 pol_yard_cd */" ).append("\n"); 
		query.append("                                            AND SUBSTR(VB.KEY_POL_YD_CD,-2) = @[pol_yard_cd]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if ( ${pol_cd} != '' && ${pol_local} != '')" ).append("\n"); 
		query.append("                                            /* 7 pol_local */" ).append("\n"); 
		query.append("                                            AND VB.KEY_POL_CD = VB.POL_CD" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${pol_cd} != '' && ${pol_ts} != '')" ).append("\n"); 
		query.append("                                            /* 8 pol_ts */" ).append("\n"); 
		query.append("                                            AND VB.KEY_POL_CD <> VB.POL_CD" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${pod_cd} != '')" ).append("\n"); 
		query.append("                                            /* 9 pod_cd */" ).append("\n"); 
		query.append("                                            AND VB.KEY_POD_CD LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${pod_yard_cd} != '')" ).append("\n"); 
		query.append("                                            /* 10 pod_yard_cd*/" ).append("\n"); 
		query.append("                                            AND SUBSTR(VB.KEY_POD_YD_CD,-2) = @[pod_yard_cd]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${pod_local} != '')" ).append("\n"); 
		query.append("                                            /* 11 pod_local */" ).append("\n"); 
		query.append("	                                            AND VB.KEY_POD_CD = VB.POD_CD" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${pod_ts} != '')" ).append("\n"); 
		query.append("                                            /* 12 pod_ts */" ).append("\n"); 
		query.append("                                            AND VB.KEY_POD_CD <> VB.POD_CD" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${por_cd} != '')" ).append("\n"); 
		query.append("                                            /* 13 por_cd         */" ).append("\n"); 
		query.append("                                            AND VB.POR_CD LIKE @[por_cd]||'%'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${del_cd} != '')" ).append("\n"); 
		query.append("                                            /* 14 del_cd         */" ).append("\n"); 
		query.append("                                            AND VB.DEL_CD LIKE @[del_cd]||'%'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${r_term} != '')" ).append("\n"); 
		query.append("                                            /* 15 r_term         */" ).append("\n"); 
		query.append("                                            AND VB.RCV_TERM_CD IN (${r_term})" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${d_term} != '')" ).append("\n"); 
		query.append("                                            /* 16 d_term         */" ).append("\n"); 
		query.append("                                            AND VB.DE_TERM_CD IN (${d_term})" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           " ).append("\n"); 
		query.append("											/* 20160511 zone cd ocn,ipt를 mas를 사용 */" ).append("\n"); 
		query.append("										    AND B.BKG_NO = MAS.BKG_NO(+)" ).append("\n"); 
		query.append("										    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                            " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										   #if (${deli_mode} !='')" ).append("\n"); 
		query.append("                                            /* 18 deli_mode      */" ).append("\n"); 
		query.append("	                                       		AND decode(NVL(VB.DEST_TRNS_MOD_CD, ' '),'T','1','2','R','A','4','F','3','B','3','E','5','U','5','*') IN (${deli_mode})" ).append("\n"); 
		query.append("										   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										   #if (${board_from_dt} != '')" ).append("\n"); 
		query.append("											/* 19, 20 Pre1 ETD Date */" ).append("\n"); 
		query.append("											AND VB.BKG_NO" ).append("\n"); 
		query.append("											 IN ( SELECT DISTINCT BKG.BKG_NO" ).append("\n"); 
		query.append("                            						FROM BKG_VVD VVD, BKG_BOOKING BKG" ).append("\n"); 
		query.append("                           						   WHERE ( VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD,VVD.POL_CD,VVD.POL_CLPT_IND_SEQ ) IN" ).append("\n"); 
		query.append("                               						     ( SELECT A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.VPS_PORT_CD,A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                              								 FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                                							WHERE A.VPS_ETD_DT >= TO_DATE(@[board_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                  							  AND A.VPS_ETD_DT <= TO_DATE(@[board_to_dt], 'YYYY-MM-DD') +0.99999)" ).append("\n"); 
		query.append("													 AND VB.BKG_NO  = BKG.BKG_NO" ).append("\n"); 
		query.append("                           							 AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                           							 AND VVD.POL_CD = BKG.POL_CD" ).append("\n"); 
		query.append("                           							 AND ( VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ) IN ( ('S',1),('T',0) )" ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("										   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										   #if (${eta_from_dt} != '')" ).append("\n"); 
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
		query.append("                                           #if (${bkg_from_dt} != '')" ).append("\n"); 
		query.append("                                            /* 21 bkg_from_dt    */" ).append("\n"); 
		query.append("                                            AND VB.BKG_CRE_DT >= TO_DATE(@[bkg_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${bkg_to_dt} != '')" ).append("\n"); 
		query.append("                                            /* 22 bkg_to_dt      */" ).append("\n"); 
		query.append("                                            AND VB.BKG_CRE_DT <= TO_DATE(@[bkg_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${bkg_kind} != '')" ).append("\n"); 
		query.append("                                            /* 23 bkg_kind       */" ).append("\n"); 
		query.append("                                            AND DECODE(VB.XTER_BKG_RQST_CD,'NIS','OFF',VB.XTER_BKG_RQST_CD) IN (${bkg_kind})" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("											/* 24 b_ofc_cd       *//* 25 b_ofc_cd_sub   */" ).append("\n"); 
		query.append("										   #if(${usr_ofc_cd} == 'SZPSC' && ${b_ofc_cd} != '')" ).append("\n"); 
		query.append("											/* SZPSC 지역 사용자는 CAN 시작하는 BKG No 조회 추가 2018.01.08 이소연과장 요청 */" ).append("\n"); 
		query.append("												#if(${can_ofc_cd} == 'CANSO')" ).append("\n"); 
		query.append("												AND SUBSTR(VB.BKG_NO, 0, 3) = 'CAN'" ).append("\n"); 
		query.append("												#else" ).append("\n"); 
		query.append("											 	AND VB.BKG_OFC_CD IN ( ${b_ofc_cd} )" ).append("\n"); 
		query.append("                                            	#end" ).append("\n"); 
		query.append("										   #elseif (${b_ofc_cd} != '')" ).append("\n"); 
		query.append("                                            	#if(${b_ofc_cd_sub} != '')" ).append("\n"); 
		query.append("												/* 2010.04.22 수정 */" ).append("\n"); 
		query.append("											 	AND VB.BKG_OFC_CD IN ( ${b_ofc_cd_sub} )" ).append("\n"); 
		query.append("                                            	#else" ).append("\n"); 
		query.append("											 	AND VB.BKG_OFC_CD IN ( ${b_ofc_cd} )" ).append("\n"); 
		query.append("                                            	#end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${b_staff_id} != '')" ).append("\n"); 
		query.append("                                            /* 26 b_staff_id     */" ).append("\n"); 
		query.append("                                            AND VB.DOC_USR_ID = @[b_staff_id]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${ca_flag} != '')" ).append("\n"); 
		query.append("                                            /* 27 ca_flag        */" ).append("\n"); 
		query.append("                                            AND EXISTS ( SELECT  'Y' FROM BKG_CORRECTION" ).append("\n"); 
		query.append("														 WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("														 AND CORR_NO IS NOT NULL" ).append("\n"); 
		query.append("														 AND CORR_NO <> '0000000001')" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${agent_cd} != '')" ).append("\n"); 
		query.append("                                            /* 28 agent_cd       */" ).append("\n"); 
		query.append("                                            AND VB.CHN_AGN_CD = @[agent_cd]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${agent_cd_all} != '')" ).append("\n"); 
		query.append("                                            /* 29 agent_cd_all   */" ).append("\n"); 
		query.append("                                            AND VB.CHN_AGN_CD IS NOT NULL" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${eq_type} != '')" ).append("\n"); 
		query.append("                                            /* 30 eq_type BKG_QUANTITY  EXISTS 체크*/" ).append("\n"); 
		query.append("                                            AND EXISTS  ( SELECT 'Y'" ).append("\n"); 
		query.append("                                                          FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                                                          WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("                                                          AND   CNTR_TPSZ_CD IN (${eq_type})" ).append("\n"); 
		query.append("                                                         )" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("                                            /* 31 cmdt_cd MDM_COMMODITY   EXISTS 체크*/" ).append("\n"); 
		query.append("                                            /* 32 cmdt_nm - 체크안함 */" ).append("\n"); 
		query.append("                                            AND VB.CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${wgt_from} != '')" ).append("\n"); 
		query.append("                                            /* 33 wgt_from       */" ).append("\n"); 
		query.append("                                            AND VB.WGT_UT_CD = 'KGS'" ).append("\n"); 
		query.append("                                            AND VB.ACT_WGT >= (@[wgt_from] *'1000')" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${wgt_to} != '')" ).append("\n"); 
		query.append("                                            /* 34 wgt_to         */" ).append("\n"); 
		query.append("                                            AND VB.WGT_UT_CD = 'KGS'" ).append("\n"); 
		query.append("                                            AND VB.ACT_WGT <= (@[wgt_to] *'1000')" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${so_no} != '')" ).append("\n"); 
		query.append("                                            /* 35 so_no          */" ).append("\n"); 
		query.append("                                            AND VB.TWN_SO_NO = @[so_no]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${l_ofc_cd} != '')" ).append("\n"); 
		query.append("                                           /* 36 l_ofc_cd *//* 37 l_ofc_cd_sub */" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("                                           #if (${l_team_cd} != '')" ).append("\n"); 
		query.append("                                            /* 38 l_team_cd        */" ).append("\n"); 
		query.append("                                             AND VB.OFC_TEAM_CD = @[l_team_cd]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${l_rep_id} != '')" ).append("\n"); 
		query.append("                                            /* 39 l_rep_id       */" ).append("\n"); 
		query.append("                                            AND VB.OB_SREP_CD = @[l_rep_id]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${c_ofc_cd} != '')" ).append("\n"); 
		query.append("                                           /* 40 c_ofc_cd *//* 41 c_ofc_cd_sub */" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("                                           #if (${c_rep_id} != '')" ).append("\n"); 
		query.append("                                            /* 42 c_rep_id       */" ).append("\n"); 
		query.append("                                            AND VB.CTRT_SREP_CD = @[c_rep_id]" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${ctr_rfa_cd} == 'C')" ).append("\n"); 
		query.append("                                            #if (${ctr_rfa_no} != '')" ).append("\n"); 
		query.append("                                            /* 43 ctr_rfa_cd*/" ).append("\n"); 
		query.append("                                             AND VB.SC_NO = @[ctr_rfa_no]" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("                                           #elseif (${ctr_rfa_cd} == 'R')" ).append("\n"); 
		query.append("                                            #if (${ctr_rfa_no} != '')" ).append("\n"); 
		query.append("											/* 44 ctr_rfa_no*/" ).append("\n"); 
		query.append("                                             AND VB.RFA_NO = @[ctr_rfa_no]" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("                                           #elseif (${ctr_rfa_cd} == 'T')" ).append("\n"); 
		query.append("                                            #if (${ctr_rfa_no} != '')" ).append("\n"); 
		query.append("                                             AND VB.TAA_NO = @[ctr_rfa_no]" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${s_mode_ori} != '')" ).append("\n"); 
		query.append("                                            /* 45 s_mode_ori     */" ).append("\n"); 
		query.append("                                            AND VB.ORG_TRNS_SVC_MOD_CD IN (${s_mode_ori})" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${s_mode_dest} != '')" ).append("\n"); 
		query.append("                                            /* 46 s_mode_dest    */" ).append("\n"); 
		query.append("                                            AND VB.DEST_TRNS_SVC_MOD_CD IN (${s_mode_dest})" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${s_route_ori} != '')" ).append("\n"); 
		query.append("                                            /* 47 s_route_ori    */" ).append("\n"); 
		query.append("                                            AND VB.ORG_SCONTI_CD IN (${s_route_ori})" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${s_route_dest} != '')" ).append("\n"); 
		query.append("                                            /* 48 s_route_dest   */" ).append("\n"); 
		query.append("                                            AND VB.DEST_SCONTI_CD IN (${s_route_dest})" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${fv_vvd_cd} != '')" ).append("\n"); 
		query.append("                                            /* 50 fv_vvd_cd      */" ).append("\n"); 
		query.append("                                                 /* 49 fv_pre_pst_cd  */" ).append("\n"); 
		query.append("                                               #if (${fv_pre_pst_cd} == 'PR')" ).append("\n"); 
		query.append("                                                AND @[fv_vvd_cd] IN (VB.PRE_1_VVD, VB.PRE_2_VVD, VB.PRE_3_VVD, VB.PRE_4_VVD)" ).append("\n"); 
		query.append("                                               #elseif (${fv_pre_pst_cd} == 'PO')" ).append("\n"); 
		query.append("                                                AND @[fv_vvd_cd] IN ( VB.POST_1_VVD , VB.POST_2_VVD , VB.POST_3_VVD , VB.POST_4_VVD )" ).append("\n"); 
		query.append("                                               #end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${fv_pol_cd} != '')" ).append("\n"); 
		query.append("                                            /* 51 fv_pol_cd      *//* 52 fv_pol_yard_cd *//* 53 fv_pol_local */" ).append("\n"); 
		query.append("                                                 /* 49 fv_pre_pst_cd  */" ).append("\n"); 
		query.append("                                               #if (${fv_pre_pst_cd} == 'PR')" ).append("\n"); 
		query.append("                                                #if(${fv_pol_yard_cd} != '')" ).append("\n"); 
		query.append("                                                 AND @[fv_pol_cd]||@[fv_pol_yard_cd] IN ( VB.PRE_1_POL_YD_CD  , VB.PRE_2_POL_YD_CD  , VB.PRE_3_POL_YD_CD  , VB.PRE_4_POL_YD_CD)" ).append("\n"); 
		query.append("                                                #else" ).append("\n"); 
		query.append("                                                 AND @[fv_pol_cd] IN ( VB.PRE_1_POL_CD  , VB.PRE_2_POL_CD  , VB.PRE_3_POL_CD  , VB.PRE_4_POL_CD)" ).append("\n"); 
		query.append("                                                #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                 #if (${fv_pol_local} != '')" ).append("\n"); 
		query.append("                                                    AND VB.POL_CD = NVL( (SELECT @[fv_pol_cd] FROM DUAL" ).append("\n"); 
		query.append("                                                                          WHERE  @[fv_pol_cd] IN (VB.PRE_4_POL_CD, VB.PRE_3_POL_CD, VB.PRE_2_POL_CD ) )" ).append("\n"); 
		query.append("                                                                       , VB.PRE_1_POL_CD)" ).append("\n"); 
		query.append("                                                 #end" ).append("\n"); 
		query.append("                                               #elseif (${fv_pre_pst_cd} == 'PO')" ).append("\n"); 
		query.append("                                                #if(${fv_pol_yard_cd} != '')" ).append("\n"); 
		query.append("                                                 AND @[fv_pol_cd]||@[fv_pol_yard_cd] IN ( VB.POST_1_POL_YD_CD  , VB.POST_2_POL_YD_CD  , VB.POST_3_POL_YD_CD  , VB.POST_4_POL_YD_CD)" ).append("\n"); 
		query.append("                                                #else" ).append("\n"); 
		query.append("                                                 AND @[fv_pol_cd] IN ( VB.POST_1_POL_CD , VB.POST_2_POL_CD , VB.POST_3_POL_CD , VB.POST_4_POL_CD)" ).append("\n"); 
		query.append("                                                #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                 #if (${fv_pol_local} != '')" ).append("\n"); 
		query.append("                                                    AND VB.POL_CD = NVL( (SELECT @[fv_pol_cd] FROM DUAL" ).append("\n"); 
		query.append("                                                                          WHERE  @[fv_pol_cd] IN (VB.POST_4_POL_CD, VB.POST_3_POL_CD, VB.POST_2_POL_CD ) )" ).append("\n"); 
		query.append("                                                                       , VB.POST_1_POL_CD)" ).append("\n"); 
		query.append("                                                 #end" ).append("\n"); 
		query.append("                                               #end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${fv_pol_cd} == '' && ${fv_pol_yard_cd} != '')" ).append("\n"); 
		query.append("                                             #if (${fv_pre_pst_cd} == 'PR')" ).append("\n"); 
		query.append("                                                 AND @[fv_pol_yard_cd] IN ( SUBSTR(VB.PRE_1_POL_YD_CD,-2)  , SUBSTR(VB.PRE_2_POL_YD_CD,-2)  , SUBSTR(VB.PRE_3_POL_YD_CD,-2)  , SUBSTR(VB.PRE_4_POL_YD_CD,-2))" ).append("\n"); 
		query.append("                                               #elseif (${fv_pre_pst_cd} == 'PO')" ).append("\n"); 
		query.append("                                                 AND @[fv_pol_yard_cd] IN ( SUBSTR(VB.POST_1_POL_YD_CD,-2)  , SUBSTR(VB.POST_2_POL_YD_CD,-2)  , SUBSTR(VB.POST_3_POL_YD_CD,-2)  , SUBSTR(VB.POST_4_POL_YD_CD,-2))" ).append("\n"); 
		query.append("                                               #end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${fv_pod_cd} != '')" ).append("\n"); 
		query.append("                                            /* 54 fv_pod_cd      */ /* 55 fv_pod_yard_cd *//* 56 fv_pod_local   */" ).append("\n"); 
		query.append("                                                 /* 49 fv_pre_pst_cd  */" ).append("\n"); 
		query.append("                                               #if (${fv_pre_pst_cd} == 'PR')" ).append("\n"); 
		query.append("                                                #if(${fv_pod_yard_cd} != '')" ).append("\n"); 
		query.append("                                                 AND @[fv_pod_cd]||@[fv_pod_yard_cd] IN ( VB.PRE_1_POD_YD_CD  , VB.PRE_2_POD_YD_CD  , VB.PRE_3_POD_YD_CD  , VB.PRE_4_POD_YD_CD)" ).append("\n"); 
		query.append("                                                #else" ).append("\n"); 
		query.append("                                                 AND @[fv_pod_cd] IN ( VB.PRE_1_POD_CD  , VB.PRE_2_POD_CD  , VB.PRE_3_POD_CD  , VB.PRE_4_POD_CD)" ).append("\n"); 
		query.append("                                                #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                 #if (${fv_pol_local} != '')" ).append("\n"); 
		query.append("                                                    AND VB.POD_CD = NVL( (SELECT @[fv_pod_cd] FROM DUAL" ).append("\n"); 
		query.append("                                                                          WHERE  @[fv_pod_cd] IN (VB.PRE_4_POD_CD, VB.PRE_3_POD_CD, VB.PRE_2_POD_CD ) )" ).append("\n"); 
		query.append("                                                                       , VB.PRE_1_POD_CD)" ).append("\n"); 
		query.append("                                                 #end" ).append("\n"); 
		query.append("                                               #elseif (${fv_pre_pst_cd} == 'PO')" ).append("\n"); 
		query.append("                                                #if(${fv_pod_yard_cd} != '')" ).append("\n"); 
		query.append("                                                 AND @[fv_pod_cd]||@[fv_pod_yard_cd] IN ( VB.POST_1_POD_YD_CD  , VB.POST_2_POD_YD_CD  , VB.POST_3_POD_YD_CD  , VB.POST_4_POD_YD_CD)" ).append("\n"); 
		query.append("                                                #else" ).append("\n"); 
		query.append("                                                 AND @[fv_pod_cd] IN ( VB.POST_1_POD_CD , VB.POST_2_POD_CD , VB.POST_3_POD_CD , VB.POST_4_POD_CD)" ).append("\n"); 
		query.append("                                                #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                                 #if (${fv_pol_local} != '')" ).append("\n"); 
		query.append("                                                    AND VB.POD_CD = NVL( (SELECT @[fv_pod_cd] FROM DUAL" ).append("\n"); 
		query.append("                                                                          WHERE  @[fv_pod_cd] IN (VB.POST_4_POD_CD, VB.POST_3_POD_CD, VB.POST_2_POD_CD ) )" ).append("\n"); 
		query.append("                                                                       , VB.POST_1_POD_CD)" ).append("\n"); 
		query.append("                                                 #end" ).append("\n"); 
		query.append("                                               #end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${fv_pod_cd} == '' && ${fv_pod_yard_cd} != '')" ).append("\n"); 
		query.append("                                             #if (${fv_pre_pst_cd} == 'PR')" ).append("\n"); 
		query.append("                                                 AND @[fv_pod_yard_cd] IN ( SUBSTR(VB.PRE_1_POD_YD_CD,-2)  , SUBSTR(VB.PRE_2_POD_YD_CD,-2)  , SUBSTR(VB.PRE_3_POD_YD_CD,-2)  , SUBSTR(VB.PRE_4_POD_YD_CD,-2))" ).append("\n"); 
		query.append("                                               #elseif (${fv_pre_pst_cd} == 'PO')" ).append("\n"); 
		query.append("                                                 AND @[fv_pod_yard_cd] IN ( SUBSTR(VB.POST_1_POD_YD_CD,-2)  , SUBSTR(VB.POST_2_POD_YD_CD,-2)  , SUBSTR(VB.POST_3_POD_YD_CD,-2)  , SUBSTR(VB.POST_4_POD_YD_CD,-2))" ).append("\n"); 
		query.append("                                               #end" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										   #if (${cust_tp_cd_s} != '' || ${cust_tp_cd_c} != '' || ${cust_tp_cd_n} != '' || ${cust_tp_cd_f} != '' || ${cust_tp_cd_a} != '')" ).append("\n"); 
		query.append("                                            /* 57~61 cust_tp_cd_s,c,n,f,a*/" ).append("\n"); 
		query.append("   											  #if(${cust_cnt_cd} !='' && ${cust_seq} != '')" ).append("\n"); 
		query.append("											/* 63 cust_cnt_cd    *//* 64 cust_seq *//* 66 cust_tp_cd*/" ).append("\n"); 
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
		query.append("															/* 예비*/" ).append("\n"); 
		query.append("														#end" ).append("\n"); 
		query.append("													)" ).append("\n"); 
		query.append("											   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										#if (${sp_cargo_dg} !=''||${sp_cargo_rf} != ''||${sp_cargo_ak} != ''||${sp_cargo_bb} != ''||${sp_cargo_hg} != ''||${sp_cargo_soc} != ''||${sp_cargo_eq} != ''||${sp_cargo_rd} != ''||${sp_cargo_pm} != ''||${sp_cargo_pc} != ''||${sp_cargo_fg} != ''||${sp_cargo_hd} != ''||${sp_cargo_rb} != ''||${sp_cargo_fu} != ''||${sp_cargo_li} != ''||${sp_vehicle} != ''||${non_dg_chem_flg} != ''  )" ).append("\n"); 
		query.append("										/* 67 sp_cargo_dg  *//* 68 sp_cargo_rf    *//* 69 sp_cargo_ak *//* 70 sp_cargo_bb *//* 71 sp_cargo_hg    *//* 72 sp_cargo_soc   *//* 73 sp_cargo_eq    *//* 74 sp_cargo_rd    *//* 75 sp_cargo_pm    *//* 76 sp_cargo_pc    *//* 77 sp_cargo_fg    *//* 78 sp_cargo_hd    *//* 79 sp_cargo_rb    */" ).append("\n"); 
		query.append("										     AND ( 1=2" ).append("\n"); 
		query.append("										  #if (${sp_cargo_dg} != '')" ).append("\n"); 
		query.append("										  /* 67 sp_cargo_dg  */" ).append("\n"); 
		query.append("										  	OR VB.DCGO_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  #if (${sp_cargo_rf} != '')" ).append("\n"); 
		query.append("										  /* 68 sp_cargo_rf    */" ).append("\n"); 
		query.append("											OR VB.RC_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  #if (${sp_cargo_ak} != '')" ).append("\n"); 
		query.append("										  /* 69 sp_cargo_ak */" ).append("\n"); 
		query.append("											OR VB.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  #if (${sp_cargo_ak} != '')" ).append("\n"); 
		query.append("										  /* 69 sp_cargo_ak */" ).append("\n"); 
		query.append("										    OR VB.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  #if (${sp_cargo_bb} != '')" ).append("\n"); 
		query.append("										  /* 70 sp_cargo_bb */" ).append("\n"); 
		query.append("											OR VB.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  #if (${sp_cargo_hg} != '')" ).append("\n"); 
		query.append("										  /* 71 sp_cargo_hg    */" ).append("\n"); 
		query.append("										    OR VB.HNGR_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  #if (${sp_cargo_soc} != '')" ).append("\n"); 
		query.append("										  /* 72 sp_cargo_soc   */" ).append("\n"); 
		query.append("											OR VB.SOC_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  #if (${sp_cargo_eq} != '')" ).append("\n"); 
		query.append("										  /* 73 sp_cargo_eq    */" ).append("\n"); 
		query.append("										    OR VB.EQ_SUBST_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  #if (${sp_cargo_rd} != '')" ).append("\n"); 
		query.append("										  /* 74 sp_cargo_rd    */" ).append("\n"); 
		query.append("										    OR VB.RD_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  #if (${sp_cargo_pm} != '')" ).append("\n"); 
		query.append("										  /* 75 sp_cargo_pm    */" ).append("\n"); 
		query.append("										    OR VB.HOT_DE_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  #if (${sp_cargo_pc} != '')" ).append("\n"); 
		query.append("										  /* 76 sp_cargo_pc    */" ).append("\n"); 
		query.append("										    OR VB.PRCT_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  #if (${sp_cargo_fg} != '')" ).append("\n"); 
		query.append("										  /* 77 sp_cargo_fg    */" ).append("\n"); 
		query.append("										    OR VB.FD_GRD_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  #if (${sp_cargo_hd} != '')" ).append("\n"); 
		query.append("										  /* 78 sp_cargo_hd    */" ).append("\n"); 
		query.append("										    OR VB.SPCL_HIDE_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  #if (${sp_cargo_rb} != '')" ).append("\n"); 
		query.append("										  /* 79 sp_cargo_rb    */" ).append("\n"); 
		query.append("										    OR VB.RAIL_BLK_CD IS NOT NULL" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  #if (${sp_cargo_fu} != '')" ).append("\n"); 
		query.append("										  /* sp_cargo_fu    */" ).append("\n"); 
		query.append("										    OR VB.FUMG_LOC_CD IS NOT NULL" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										  #if (${sp_cargo_li} != '')" ).append("\n"); 
		query.append("										  /* sp_cargo_li    */" ).append("\n"); 
		query.append("										    OR VB.SPCL_HIDE_LNR_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("										   #if (${non_dg_chem_flg} != '')" ).append("\n"); 
		query.append("										  /* non_dg_chem_flg    */" ).append("\n"); 
		query.append("										    OR VB.NON_DG_CHEM_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end" ).append("\n"); 
		query.append("											" ).append("\n"); 
		query.append("										  #if (${sp_vehicle} != '')" ).append("\n"); 
		query.append("										  /* sp_vehicle    */" ).append("\n"); 
		query.append("										    OR VB.VEH_CMDT_FLG = 'Y'" ).append("\n"); 
		query.append("										  #end										  										  " ).append("\n"); 
		query.append("										  )" ).append("\n"); 
		query.append("										#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${cargo_tp_f} != '' || ${cargo_tp_p} != '' || ${cargo_tp_r} != '')" ).append("\n"); 
		query.append("                                            /* 80~82 cargo_tp_f,p,r     */" ).append("\n"); 
		query.append("                                            AND VB.BKG_CGO_TP_CD IN ( @[cargo_tp_f], @[cargo_tp_p], @[cargo_tp_r])" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${bkg_sts_cd_f} != '' || ${bkg_sts_cd_x} != '' || ${bkg_sts_cd_a} != '' || ${bkg_sts_cd_w} != '')" ).append("\n"); 
		query.append("                                            /* 83 bkg_sts_cd_f*//* 84 bkg_sts_cd_x*//* 85 bkg_sts_cd_a*//* 86 bkg_sts_cd_w*/" ).append("\n"); 
		query.append("                                            AND VB.BKG_STS_CD IN ( @[bkg_sts_cd_f], @[bkg_sts_cd_x], @[bkg_sts_cd_a], @[bkg_sts_cd_w])" ).append("\n"); 
		query.append("											#else /* 선택되지 않을경우 기본 STATUS */" ).append("\n"); 
		query.append("                                            AND  VB.BKG_STS_CD IN ('F', 'W', 'A')" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${non_sp_cargo} != '')" ).append("\n"); 
		query.append("                                            /* 87 non_sp_cargo   */" ).append("\n"); 
		query.append("                                            AND VB.WT_RSN_SPCL_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           #if (${holding} != '')" ).append("\n"); 
		query.append("                                            /* 88 holding*/" ).append("\n"); 
		query.append("                                            AND VB.WT_RSN_HLD_FLG = 'Y'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${bl_type_a} != '')" ).append("\n"); 
		query.append("                                            /* 89 bl_type_a      */" ).append("\n"); 
		query.append("                                            AND VB.ADV_SHTG_CD = 'A'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           #if (${bl_type_s} != '')" ).append("\n"); 
		query.append("                                            /* 90 bl_type_s      */" ).append("\n"); 
		query.append("                                            AND VB.ADV_SHTG_CD = 'S'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           #if (${rev} != '')" ).append("\n"); 
		query.append("                                            /* 91 rev            */" ).append("\n"); 
		query.append("                                            AND EXISTS ( SELECT 'Y' FROM BKG_CHG_RT WHERE BKG_NO = VB.BKG_NO)" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           #if (${non_rev} != '')" ).append("\n"); 
		query.append("                                            /* 92 non_rev        */" ).append("\n"); 
		query.append("                                            AND NOT EXISTS ( SELECT 'Y' FROM BKG_CHG_RT WHERE BKG_NO = VB.BKG_NO)" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${aes_y} != '')" ).append("\n"); 
		query.append("                                            /* 93 aes_y          */" ).append("\n"); 
		query.append("                                            AND XPT_IMP.AES_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("                                            AND XPT_IMP.CNT_CD = 'US'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           #if (${aes_n} != '')" ).append("\n"); 
		query.append("                                            /* 94 aes_n          */" ).append("\n"); 
		query.append("                                            AND NVL(XPT_IMP.AES_TP_CD, 'X') = 'X'" ).append("\n"); 
		query.append("                                            AND NVL(XPT_IMP.CNT_CD,'US') = 'US'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${stop_cargo} != '')" ).append("\n"); 
		query.append("                                            /* 95 stop_cargo     */" ).append("\n"); 
		query.append("                                            AND VB.STOP_CGO_FLG ='Y'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           #if (${ro_y} != '')" ).append("\n"); 
		query.append("                                            /* 96 ro_y           */" ).append("\n"); 
		query.append("											AND EXISTS ( SELECT 'Y'" ).append("\n"); 
		query.append("											             FROM BKG_ROLL_OVR WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("											             GROUP BY BKG_NO" ).append("\n"); 
		query.append("											             HAVING COUNT(BKG_NO) > @[ro_y]" ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${caed_y} != '')" ).append("\n"); 
		query.append("                                           /* 98 caed_y         */" ).append("\n"); 
		query.append("                                            AND XPT_IMP.CAED_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("                                            AND XPT_IMP.CNT_CD = 'CA'  " ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("                                           #if (${caed_n} != '')" ).append("\n"); 
		query.append("                                            /* 99 caed_n         */" ).append("\n"); 
		query.append("                                            AND NVL(XPT_IMP.CAED_TP_CD, 'X') = 'X'" ).append("\n"); 
		query.append("                                            AND NVL(XPT_IMP.CNT_CD,'CA') = 'CA'" ).append("\n"); 
		query.append("                                           #end                                           " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${certi_y} != '')" ).append("\n"); 
		query.append("                                            /* 101 certi_y        */" ).append("\n"); 
		query.append("                                            AND EXISTS ( SELECT 'Y' FROM BKG_IMG_STO WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("                                           							#if (${certi_d} != '' || ${certi_a} != '' || ${certi_b} != '' || ${certi_g} != '' || ${certi_c} != '')" ).append("\n"); 
		query.append("                                           							AND RIDR_TP_CD IN (@[certi_d], @[certi_a], @[certi_b], @[certi_g], @[certi_c])" ).append("\n"); 
		query.append("                                           							#end" ).append("\n"); 
		query.append("                                            						)" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${certi_n} != '')" ).append("\n"); 
		query.append("                                            /* 102 certi_n        */" ).append("\n"); 
		query.append("                                            AND NOT EXISTS ( SELECT 'Y' FROM BKG_IMG_STO WHERE BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("                                            								#if (${certi_d} != '' || ${certi_a} != '' || ${certi_b} != '' || ${certi_g} != '' || ${certi_c} != '')" ).append("\n"); 
		query.append("		                                           							AND RIDR_TP_CD IN (@[certi_d], @[certi_a], @[certi_b], @[certi_g], @[certi_c])" ).append("\n"); 
		query.append("		                                           							#end" ).append("\n"); 
		query.append("		                                            						)" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("										   #if (${rate_check} != '')" ).append("\n"); 
		query.append("											AND @[rate_check] =  (CASE WHEN VB.BKG_CRE_DT >= TO_DATE('20141125','YYYYMMDD') THEN RA.OFT_MSS_FLG " ).append("\n"); 
		query.append("																						WHEN SUBSTR(VB.SC_NO,1,3) = 'DUM' OR SUBSTR(VB.RFA_NO,1,3) = 'DUM' OR SUBSTR(VB.TAA_NO,1,3) = 'DUM' THEN 'Y' " ).append("\n"); 
		query.append("																						WHEN RA.OFT_MSS_FLG = 'N' THEN 'N'" ).append("\n"); 
		query.append("																						WHEN RA.OFT_MSS_FLG = 'Y' THEN NVL((SELECT 'N'" ).append("\n"); 
		query.append("																															FROM BKG_CHG_RT RT" ).append("\n"); 
		query.append("														  																	WHERE RT.BKG_NO = RA.BKG_NO" ).append("\n"); 
		query.append("																															AND ROWNUM = 1), 'Y') END )" ).append("\n"); 
		query.append("										   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${aloc_sts_cd_f} != '' || ${aloc_sts_cd_s} != '' )" ).append("\n"); 
		query.append("                                            /* 103 aloc_sts_cd_f*//* 104 aloc_sts_cd_s*/" ).append("\n"); 
		query.append("                                            AND B.ALOC_STS_CD IN (@[aloc_sts_cd_f], @[aloc_sts_cd_s])" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${non_rd_sts_f} != '' || ${non_rd_sts_r} != '' )" ).append("\n"); 
		query.append("                                            /* 105 non_rd_sts_f*//* 106 non_rd_sts_r*/" ).append("\n"); 
		query.append("                                            AND B.NON_RT_STS_CD IN (@[non_rd_sts_f], @[non_rd_sts_r])" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${spot_guide_rfa_no} != '')  " ).append("\n"); 
		query.append("                                            /* 107 spot_guide_rfa_no*/" ).append("\n"); 
		query.append("                                            AND SUBSTR(VB.RFA_NO,6,1) ='G'" ).append("\n"); 
		query.append("											AND SUBSTR(VB.RFA_NO,1,3) <> 'DUM'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("											#if (${master_rfa_no} != '')" ).append("\n"); 
		query.append("                                            /* 107 master_rfa_no*/" ).append("\n"); 
		query.append("                                            AND SUBSTR(VB.RFA_NO,6,1) ='M'" ).append("\n"); 
		query.append("											AND SUBSTR(VB.RFA_NO,1,3) <> 'DUM'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("											#if (${basic_rfa_no} != '')" ).append("\n"); 
		query.append("                                            /* 107 basic_rfa_no*/" ).append("\n"); 
		query.append("                                            AND SUBSTR(VB.RFA_NO,6,1) ='B'" ).append("\n"); 
		query.append("											AND SUBSTR(VB.RFA_NO,1,3) <> 'DUM'" ).append("\n"); 
		query.append("                                           #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                       " ).append("\n"); 
		query.append("                                           #if (${ctrt_cng_tp_cd} != '')" ).append("\n"); 
		query.append("                                            /* 108 ctrt_cng_tp_cd*/" ).append("\n"); 
		query.append("                                            AND VB.CTRT_CNG_TP_CD IN (${ctrt_cng_tp_cd})" ).append("\n"); 
		query.append("                                           #end                                           " ).append("\n"); 
		query.append("                                           " ).append("\n"); 
		query.append("                                           #if (${rtro_knd_cd} != '')" ).append("\n"); 
		query.append("                                            /* 109 rtro_knd_cd*/" ).append("\n"); 
		query.append("                                            AND VB.RTRO_KND_CD IN (${rtro_knd_cd})" ).append("\n"); 
		query.append("                                           #end     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                           #if (${web_upd_sts} == 'B')" ).append("\n"); 
		query.append("                                             #if (${web_sts_cd_a} != '' && ${web_sts_cd_m} != '')" ).append("\n"); 
		query.append("                                              AND B.SYS_UPLD_FLG in ('Y','N')" ).append("\n"); 
		query.append("                                              AND B.XTER_BKG_RQST_CD = 'WEB'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                             #elseif (${web_sts_cd_a} != '')" ).append("\n"); 
		query.append("                                              AND B.SYS_UPLD_FLG = 'Y'" ).append("\n"); 
		query.append("                                              AND B.XTER_BKG_RQST_CD = 'WEB'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                             #elseif (${web_sts_cd_m} != '')" ).append("\n"); 
		query.append("                                              AND B.SYS_UPLD_FLG = 'N'" ).append("\n"); 
		query.append("                                              AND B.XTER_BKG_RQST_CD = 'WEB'" ).append("\n"); 
		query.append("                                             #end     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				                         #elseif (${web_upd_sts} == 'S')" ).append("\n"); 
		query.append("				                           #if (${web_sts_cd_a} != '')" ).append("\n"); 
		query.append("				                           AND EXISTS( " ).append("\n"); 
		query.append("				                               SELECT 'Y'" ).append("\n"); 
		query.append("				                                 FROM BKG_XTER_RQST_MST A" ).append("\n"); 
		query.append("				                                WHERE A.BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("				                                  AND A.XTER_RQST_VIA_CD = 'WEB'" ).append("\n"); 
		query.append("				                                  AND A.DOC_TP_CD = 'S'" ).append("\n"); 
		query.append("				                                  AND A.SYS_UPLD_FLG = 'Y'/*AUTO*/" ).append("\n"); 
		query.append("				                               )" ).append("\n"); 
		query.append("				                           #elseif (${web_sts_cd_m} != '')" ).append("\n"); 
		query.append("				                           AND NOT EXISTS( " ).append("\n"); 
		query.append("				                               SELECT 'Y'" ).append("\n"); 
		query.append("				                                 FROM BKG_XTER_RQST_MST A" ).append("\n"); 
		query.append("				                                WHERE A.BKG_NO = VB.BKG_NO" ).append("\n"); 
		query.append("				                                  AND A.XTER_RQST_VIA_CD = 'WEB'" ).append("\n"); 
		query.append("				                                  AND A.DOC_TP_CD = 'S'" ).append("\n"); 
		query.append("				                                  AND A.SYS_UPLD_FLG = 'Y'/*AUTO*/" ).append("\n"); 
		query.append("				                                 )" ).append("\n"); 
		query.append("				                           #end" ).append("\n"); 
		query.append("				                         #end" ).append("\n"); 
		query.append("                                 ) X" ).append("\n"); 
		query.append("								 WHERE 1=1" ).append("\n"); 
		query.append("                                 #if(${bkg_sts_cd_i} != '')" ).append("\n"); 
		query.append("                                 AND VVD_CNT <> SKD_CNT" ).append("\n"); 
		query.append("                                 #end" ).append("\n"); 
		query.append("                                            #if (${zone_cd} == 'OCN')" ).append("\n"); 
		query.append("                                             /*17 zone_cd OCN*/" ).append("\n"); 
		query.append("                                             --AND (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = VB.POR_CD) <> (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = VB.DEL_CD)" ).append("\n"); 
		query.append("                                             AND NVL(IOC_CD ,IOC_CD2) = 'O'" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("                                            #if (${zone_cd} == 'IPT')" ).append("\n"); 
		query.append("                                             /* 17 zone_cd IPT*/" ).append("\n"); 
		query.append("                                             --AND (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = VB.POR_CD) = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = VB.DEL_CD)" ).append("\n"); 
		query.append("                                             AND NVL(IOC_CD ,IOC_CD2) = 'I'" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("                                            #if (${zone_cd} == 'DOM')" ).append("\n"); 
		query.append("											 /* 17 zone_cd IPT*/" ).append("\n"); 
		query.append("                                             AND (SUBSTR(por_cd,1,2) = SUBSTR(del_cd,1,2))" ).append("\n"); 
		query.append("                                            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                          ) Y" ).append("\n"); 
		query.append("                          ,MAS_RGST_BKG COA_BKG, MAS_MON_VVD COA_VVD" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                        AND Y.BKG_NO     = COA_BKG.BKG_NO(+)" ).append("\n"); 
		query.append("                        AND COA_BKG.TRD_CD = COA_VVD.TRD_CD(+)" ).append("\n"); 
		query.append("                        AND COA_BKG.RLANE_CD = COA_VVD.RLANE_CD(+)" ).append("\n"); 
		query.append("                        AND COA_BKG.IOC_CD = COA_VVD.IOC_CD(+)" ).append("\n"); 
		query.append("                        AND COA_BKG.VSL_CD = COA_VVD.VSL_CD(+)" ).append("\n"); 
		query.append("                        AND COA_BKG.SKD_VOY_NO = COA_VVD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                        AND COA_BKG.DIR_CD = COA_VVD.DIR_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         #if (${crn_no_flag} != '')" ).append("\n"); 
		query.append("                          /* 100 crn_no_flag    */  " ).append("\n"); 
		query.append("                          --AND NVL(SHP_CALL_NO, ' ') <> ' '" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         #if (${mty_rtn_ecc} != '')" ).append("\n"); 
		query.append("                           AND Y.ECC_CD IN  (${mty_rtn_ecc})" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        AND BL_CERTI = NVL(@[bl_certi],BL_CERTI)" ).append("\n"); 
		query.append("                   ) Z" ).append("\n"); 
		query.append("   			    ORDER BY ${orderby},BKG_NO" ).append("\n"); 
		query.append("	   )ZZ" ).append("\n"); 
		query.append(" ) QQ" ).append("\n"); 
		query.append(" , ( SELECT INTG_CD_VAL_DESC RTRO_KND_CD_NM, INTG_CD_VAL_CTNT RTRO_KND_CD FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03367' ) KK " ).append("\n"); 
		query.append("WHERE RNUM BETWEEN NVL(@[rows_per_page],50) * (NVL(@[curr_page],1) - 1) + 1" ).append("\n"); 
		query.append("           AND NVL(@[rows_per_page],50) *  NVL(@[curr_page],1)           " ).append("\n"); 
		query.append("           AND QQ.RTRO_KND_CD = KK.RTRO_KND_CD(+)" ).append("\n"); 

	}
}