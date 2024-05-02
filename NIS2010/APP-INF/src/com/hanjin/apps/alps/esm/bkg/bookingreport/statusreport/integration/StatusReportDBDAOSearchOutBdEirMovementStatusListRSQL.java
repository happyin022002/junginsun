/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StatusReportDBDAOSearchOutBdEirMovementStatusListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.23 
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

public class StatusReportDBDAOSearchOutBdEirMovementStatusListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EIR Exchange & Customs Release Check Report 조회
	  * </pre>
	  */
	public StatusReportDBDAOSearchOutBdEirMovementStatusListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_bkg_rqst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_1_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_1_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eir_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_trns_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchOutBdEirMovementStatusListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DENSE_RANK() OVER( ORDER BY K.BKG_NO) DENSE_RANK," ).append("\n"); 
		query.append("DENSE_RANK() OVER( ORDER BY K.BKG_NO) DENSE_RANK2," ).append("\n"); 
		query.append("K.CNTR_RNUM," ).append("\n"); 
		query.append("K.BKG_RNUM," ).append("\n"); 
		query.append("K.BKG_NO," ).append("\n"); 
		query.append("K.ST," ).append("\n"); 
		query.append("K.SHPR_NM," ).append("\n"); 
		query.append("K.CNEE_NM," ).append("\n"); 
		query.append("K.POR_CD," ).append("\n"); 
		query.append("K.POD_CD," ).append("\n"); 
		query.append("K.RCV_TERM_CD," ).append("\n"); 
		query.append("K.DE_TERM_CD," ).append("\n"); 
		query.append("K.BKG_QTY," ).append("\n"); 
		query.append("K.BS," ).append("\n"); 
		query.append("K.EIR_FLG," ).append("\n"); 
		query.append("K.CNTR_NO," ).append("\n"); 
		query.append("DECODE(K.CURL_FLG,NULL,'N',K.CURL_FLG) CURL_FLG," ).append("\n"); 
		query.append("K.CURL_DT," ).append("\n"); 
		query.append("BKG_GET_TOKEN_FNC(K.MVMT_DATA_OP,1,',') OP_STS_CD," ).append("\n"); 
		query.append("BKG_GET_TOKEN_FNC(K.MVMT_DATA_OP,2,',') OP_ORG_YD_CD," ).append("\n"); 
		query.append("BKG_GET_TOKEN_FNC(K.MVMT_DATA_OP,3,',') OP_CNMV_EVNT_DT," ).append("\n"); 
		query.append("BKG_GET_TOKEN_FNC(K.MVMT_DATA_OC,1,',') OC_STS_CD," ).append("\n"); 
		query.append("BKG_GET_TOKEN_FNC(K.MVMT_DATA_OC,2,',') OC_ORG_YD_CD," ).append("\n"); 
		query.append("BKG_GET_TOKEN_FNC(K.MVMT_DATA_OC,3,',') OC_CNMV_EVNT_DT," ).append("\n"); 
		query.append("K.MOVE_STS," ).append("\n"); 
		query.append("K.STOW," ).append("\n"); 
		query.append("DG_UN_NO AS IMDG_UN_NO," ).append("\n"); 
		query.append("DG_IMDG AS IMDG_CLSS_CD," ).append("\n"); 
		query.append("BKG_GET_TOKEN_FNC(RF_CD, 1) AS CDO_TEMP," ).append("\n"); 
		query.append("BKG_GET_TOKEN_FNC(RF_CD, 2) AS CNTR_VENT_TP_CD," ).append("\n"); 
		query.append("BKG_GET_TOKEN_FNC(AWK_CD, 1) AS OVR_FWRD_LEN," ).append("\n"); 
		query.append("BKG_GET_TOKEN_FNC(AWK_CD, 2) AS OVR_BKWD_LEN," ).append("\n"); 
		query.append("BKG_GET_TOKEN_FNC(AWK_CD, 3) AS OVR_HGT," ).append("\n"); 
		query.append("COUNT(DISTINCT K.BKG_NO) OVER() BKG_TOTAL," ).append("\n"); 
		query.append("SUM(DECODE(BKG_RNUM,1,BKG_TOTAL_F,0)) OVER () ||' F' AS BKG_TOTAL_F," ).append("\n"); 
		query.append("COUNT(K.CNTR_NO) OVER() CNTR_TOTAL," ).append("\n"); 
		query.append("SUM(CNTR_TOTAL) OVER() ||' F' AS CNTR_TOTAL_F," ).append("\n"); 
		query.append("SUM(DECODE(EIR_FLG,'Y',1,0)) OVER() EIR_TOTAL_Y," ).append("\n"); 
		query.append("SUM(DECODE(EIR_FLG,'N',1,0)) OVER() EIR_TOTAL_N," ).append("\n"); 
		query.append("--SUM(DECODE(EIR_FLG,'Y',EIR_QTY_Y,0)) OVER() ||' F' AS EIR_TOT_Y" ).append("\n"); 
		query.append("CASE WHEN 1<= SUM(DECODE(EIR_FLG,'Y',EIR_QTY_Y,0)) OVER() THEN SUM(DECODE(EIR_FLG,'Y',EIR_QTY_Y,0)) OVER() ||' F'" ).append("\n"); 
		query.append("WHEN 0< SUM(DECODE(EIR_FLG,'Y',EIR_QTY_Y,0)) OVER() AND  SUM(DECODE(EIR_FLG,'Y',EIR_QTY_Y,0)) OVER() <1 THEN '0'|| SUM(DECODE(EIR_FLG,'Y',EIR_QTY_Y,0)) OVER() ||' F'" ).append("\n"); 
		query.append("ELSE SUM(DECODE(EIR_FLG,'A',EIR_QTY_N,0)) OVER() ||' F'" ).append("\n"); 
		query.append("END EIR_TOT_Y," ).append("\n"); 
		query.append("--SUM(DECODE(EIR_FLG,'N',EIR_QTY_N,0)) OVER() ||' F' AS EIR_TOT_N" ).append("\n"); 
		query.append("CASE WHEN 1<= SUM(DECODE(EIR_FLG,'N',EIR_QTY_N,0)) OVER() THEN SUM(DECODE(EIR_FLG,'N',EIR_QTY_N,0)) OVER() ||' F'" ).append("\n"); 
		query.append("WHEN 0< SUM(DECODE(EIR_FLG,'N',EIR_QTY_N,0)) OVER() AND  SUM(DECODE(EIR_FLG,'N',EIR_QTY_N,0)) OVER() <1 THEN '0'|| SUM(DECODE(EIR_FLG,'N',EIR_QTY_N,0)) OVER() ||' F'" ).append("\n"); 
		query.append("ELSE SUM(DECODE(EIR_FLG,'A',EIR_QTY_N,0)) OVER() ||' F'" ).append("\n"); 
		query.append("END EIR_TOT_N," ).append("\n"); 
		query.append("SUM(DECODE(CURL_FLG,'Y',1,0)) OVER() CURL_TOTAL_Y," ).append("\n"); 
		query.append("SUM(DECODE(CURL_FLG,'N',1,0)) OVER() CURL_TOTAL_N," ).append("\n"); 
		query.append("SUM(DECODE(K.CURL_DT,NULL,0,CURL_QTY_Y)) OVER() ||' F' AS CURL_TOT_Y," ).append("\n"); 
		query.append("SUM(DECODE(K.CURL_DT,NULL,CURL_QTY_N,0)) OVER() ||' F' AS CURL_TOT_N," ).append("\n"); 
		query.append("--SUM(CURL_QTY_Y) OVER() ||' F' AS CURL_TOT_Y," ).append("\n"); 
		query.append("--SUM(CURL_QTY_N) OVER() ||' F' AS CURL_TOT_N," ).append("\n"); 
		query.append("SUM(DECODE(K.MOVE_STS,'OP',1,0)) OVER() AS OP," ).append("\n"); 
		query.append("SUM(OP_TOT) OVER() ||' F' AS OP_TOT," ).append("\n"); 
		query.append("SUM(DECODE(K.MOVE_STS,'OC',1,0)) OVER() AS OC," ).append("\n"); 
		query.append("SUM(OC_TOT) OVER() ||' F' AS OC_TOT," ).append("\n"); 
		query.append("SUM(DECODE(K.MOVE_STS,'VL',1,0)) OVER() AS VL," ).append("\n"); 
		query.append("SUM(VL_TOT) OVER() ||' F' AS VL_TOT," ).append("\n"); 
		query.append("SUM(DECODE(K.MOVE_STS,'OP',0,'OC',0,'VL',0,1)) OVER() AS OT," ).append("\n"); 
		query.append("SUM(OT_TOT) OVER() ||' F' AS OT_TOT," ).append("\n"); 
		query.append("K.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("K.COP_NO," ).append("\n"); 
		query.append("K.BKG_NO AS CBKG_NO," ).append("\n"); 
		query.append("K.CNTR_VOL_QTY,  -- LSJ 추가" ).append("\n"); 
		query.append("K.CNTR_PRT_FLG  -- LSJ 추가" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_NUMBER() OVER (PARTITION BY A.BKG_NO, A.CNTR_NO ORDER BY A.BKG_NO, A.CNTR_NO) AS CNTR_RNUM," ).append("\n"); 
		query.append("ROW_NUMBER() OVER (PARTITION BY A.BKG_NO ORDER BY A.BKG_NO ) AS BKG_RNUM," ).append("\n"); 
		query.append("A.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("A.BKG_STS_CD AS ST," ).append("\n"); 
		query.append("REPLACE(A.SHPR_NAME,chr(13)||chr(10),' ') AS SHPR_NM," ).append("\n"); 
		query.append("REPLACE(A.CONSIGNEE_NAME,chr(13)||chr(10),' ') AS CNEE_NM," ).append("\n"); 
		query.append("A.POR_CD AS POR_CD," ).append("\n"); 
		query.append("A.POD_CD AS POD_CD," ).append("\n"); 
		query.append("A.RCV_TERM_CD AS RCV_TERM_CD," ).append("\n"); 
		query.append("A.DE_TERM_CD AS DE_TERM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("A.CNTR_VOL_QTY AS CNTR_VOL_QTY," ).append("\n"); 
		query.append("A.CNTR_PRT_FLG AS CNTR_PRT_FLG,  -- LSJ 추가" ).append("\n"); 
		query.append("BKG_JOIN_FNC(CURSOR(SELECT  J.CNTR_TPSZ_CD||'-'||TRIM(TO_CHAR(SUM(J.CNTR_VOL_QTY),'999990.99'))" ).append("\n"); 
		query.append("FROM BKG_CONTAINER J" ).append("\n"); 
		query.append("WHERE J.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("ORDER BY CNTR_TPSZ_CD)) AS BKG_QTY," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BLCK_STWG_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = A.BKG_NO) AS BS," ).append("\n"); 
		query.append("--DECODE(A.BKG_NO, NULL, 'N', 'Y') AS EIR_FLG," ).append("\n"); 
		query.append("NVL((SELECT 'Y' FROM BKG_OB_CHN_RCV_HIS B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND B.CHN_EDI_MSG_TP_ID = A.CHN_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("AND B.MSG_RCV_NO = A.MSG_RCV_NO" ).append("\n"); 
		query.append("AND B.RCV_LOG_SEQ = A.RCV_LOG_SEQ" ).append("\n"); 
		query.append("AND (B.EDI_RCV_MSG LIKE '%RCVEIR%' OR B.EDI_RCV_MSG LIKE '%CODECO%')" ).append("\n"); 
		query.append("),'N') AS EIR_FLG," ).append("\n"); 
		query.append("A.CNTR_NO AS CNTR_NO," ).append("\n"); 
		query.append("(	SELECT 'Y' FROM DUAL" ).append("\n"); 
		query.append("WHERE EXISTS (" ).append("\n"); 
		query.append("SELECT BK.BKG_NO, RCV.CNTR_NO, TO_CHAR(RCV.CGOR_DT,'YYYY-MM-DD HH24:MM') AS CGOR_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK, BKG_CONTAINER BC, BKG_OB_CHN_RCV RCV" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND RCV.CHN_EDI_MSG_TP_ID ='YTI'" ).append("\n"); 
		query.append("AND BC.BKG_NO = RCV.BKG_NO" ).append("\n"); 
		query.append("AND BC.CNTR_NO = RCV.CNTR_NO" ).append("\n"); 
		query.append("AND RCV.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND RCV.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND RCV.CGOR_DT IS NOT NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT BK.TO_BKG_NO, RCV.CNTR_NO, TO_CHAR(RCV.CGOR_DT,'YYYY-MM-DD HH24:MM') AS CGOR_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK, BKG_CONTAINER BC, BKG_OB_CHN_RCV RCV" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BK.TO_BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD = 'X'" ).append("\n"); 
		query.append("AND RCV.CHN_EDI_MSG_TP_ID ='YTI'" ).append("\n"); 
		query.append("AND BC.BKG_NO = RCV.BKG_NO" ).append("\n"); 
		query.append("AND BC.CNTR_NO = RCV.CNTR_NO" ).append("\n"); 
		query.append("AND RCV.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND RCV.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND RCV.CGOR_DT IS NOT NULL" ).append("\n"); 
		query.append(")) CURL_FLG," ).append("\n"); 
		query.append("COALESCE( (SELECT MAX(TO_CHAR(RCV.CGOR_DT,'YYYY-MM-DD HH24:MM')) AS CGOR_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK, BKG_CONTAINER BC, BKG_OB_CHN_RCV RCV" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND RCV.CHN_EDI_MSG_TP_ID ='YTI'" ).append("\n"); 
		query.append("AND BC.BKG_NO = RCV.BKG_NO" ).append("\n"); 
		query.append("AND BC.CNTR_NO = RCV.CNTR_NO" ).append("\n"); 
		query.append("AND RCV.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND RCV.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND RCV.CGOR_DT IS NOT NULL) ,(" ).append("\n"); 
		query.append("SELECT MAX(TO_CHAR(RCV.CGOR_DT,'YYYY-MM-DD HH24:MM')) AS CGOR_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK, BKG_CONTAINER BC, BKG_OB_CHN_RCV RCV" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BK.TO_BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD = 'X'" ).append("\n"); 
		query.append("AND RCV.CHN_EDI_MSG_TP_ID ='YTI'" ).append("\n"); 
		query.append("AND BC.BKG_NO = RCV.BKG_NO" ).append("\n"); 
		query.append("AND BC.CNTR_NO = RCV.CNTR_NO" ).append("\n"); 
		query.append("AND RCV.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND RCV.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND RCV.CGOR_DT IS NOT NULL), '' ) CURL_DT," ).append("\n"); 
		query.append("A.MVMT_STS_CD AS MOVE_STS," ).append("\n"); 
		query.append("BKG_JOIN_FNC(CURSOR (SELECT NVL(M.MVMT_STS_CD,'**')||','|| NVL(M.ORG_YD_CD,'*******')||','|| NVL(TO_CHAR(M.CNMV_EVNT_DT,'YYYY-MM-DD HH24:MM'),'****-**-** **:**')" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT M" ).append("\n"); 
		query.append("WHERE M.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND   M.CNMV_YR = A.CNMV_YR" ).append("\n"); 
		query.append("AND   M.CNMV_CYC_NO = A.CNMV_CYC_NO" ).append("\n"); 
		query.append("AND   M.MVMT_STS_CD IN ('OP')" ).append("\n"); 
		query.append("AND   M.CNMV_ID_NO = (SELECT MAX(CNMV_ID_NO)" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT Q" ).append("\n"); 
		query.append("WHERE Q.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("AND Q.CNMV_YR = M.CNMV_YR" ).append("\n"); 
		query.append("AND Q.CNMV_CYC_NO = M.CNMV_CYC_NO" ).append("\n"); 
		query.append("AND Q.MVMT_STS_CD IN ('OP')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("))MVMT_DATA_OP," ).append("\n"); 
		query.append("BKG_JOIN_FNC(CURSOR (SELECT NVL(M.MVMT_STS_CD,'**')||','|| NVL(M.ORG_YD_CD,'*******')||','|| NVL(TO_CHAR(M.CNMV_EVNT_DT,'YYYY-MM-DD HH24:MM'),'****-**-** **:**')" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT M" ).append("\n"); 
		query.append("WHERE M.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND   M.CNMV_YR = A.CNMV_YR" ).append("\n"); 
		query.append("AND   M.CNMV_CYC_NO = A.CNMV_CYC_NO" ).append("\n"); 
		query.append("AND   M.MVMT_STS_CD IN ('OC')" ).append("\n"); 
		query.append("AND   M.CNMV_ID_NO = (SELECT MAX(CNMV_ID_NO)" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT Q" ).append("\n"); 
		query.append("WHERE Q.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("AND Q.CNMV_YR = M.CNMV_YR" ).append("\n"); 
		query.append("AND Q.CNMV_CYC_NO = M.CNMV_CYC_NO" ).append("\n"); 
		query.append("AND Q.MVMT_STS_CD IN ('OC')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("))MVMT_DATA_OC," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT STWG_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = A.BKG_NO) AS STOW," ).append("\n"); 
		query.append("BKG_JOIN_FNC(CURSOR ((" ).append("\n"); 
		query.append("SELECT DG.IMDG_UN_NO" ).append("\n"); 
		query.append("FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("WHERE DG.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND DG.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1 ))) AS DG_UN_NO," ).append("\n"); 
		query.append("BKG_JOIN_FNC(CURSOR ((" ).append("\n"); 
		query.append("SELECT DG.IMDG_CLSS_CD" ).append("\n"); 
		query.append("FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("WHERE DG.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND DG.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1 ))) AS DG_IMDG," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT RF.CDO_TEMP||','||RF.CNTR_VENT_TP_CD" ).append("\n"); 
		query.append("FROM BKG_RF_CGO RF" ).append("\n"); 
		query.append("WHERE RF.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND RF.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1 ) AS RF_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT AWK.OVR_FWRD_LEN||','||AWK.OVR_BKWD_LEN||','||AWK.OVR_HGT" ).append("\n"); 
		query.append("FROM BKG_AWK_CGO AWK" ).append("\n"); 
		query.append("WHERE AWK.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND AWK.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1 ) AS AWK_CD," ).append("\n"); 
		query.append("(SELECT SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD,-1),'2',0.5 * QTY.OP_CNTR_QTY,QTY.OP_CNTR_QTY))" ).append("\n"); 
		query.append("FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append("WHERE QTY.BKG_NO = A.BKG_NO) AS BKG_TOTAL_F," ).append("\n"); 
		query.append("CASE WHEN SUBSTR(A.CNTR_TPSZ_CD,-1) = '2' THEN 0.5 * A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("ELSE A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("END  CNTR_TOTAL," ).append("\n"); 
		query.append("--EIR 수신 관련해서 EIR 은 CNTR_NO 가 전송되지 않기 때문에 RCVEIR 로 체크 하여 처리 한다" ).append("\n"); 
		query.append("CASE WHEN A.CNTR_NO IS NOT NULL AND SUBSTR(A.CNTR_TPSZ_CD,-1) = '2' THEN 0.5 * A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("WHEN A.CNTR_NO IS NOT NULL AND SUBSTR(A.CNTR_TPSZ_CD,-1) <> '2' THEN A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("ELSE  0" ).append("\n"); 
		query.append("END EIR_QTY_Y," ).append("\n"); 
		query.append("--EIR 수신 관련해서 EIR 은 CNTR_NO 가 전송되지 않기 때문에 RCVEIR 로 체크 하여 처리 한다" ).append("\n"); 
		query.append("CASE WHEN A.EIR_CNTR_NO IS NULL AND SUBSTR(A.CNTR_TPSZ_CD,-1) = '2' THEN 0.5 * A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("WHEN A.EIR_CNTR_NO IS NULL AND SUBSTR(A.CNTR_TPSZ_CD,-1) <> '2' THEN A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("ELSE  0" ).append("\n"); 
		query.append("END EIR_QTY_N," ).append("\n"); 
		query.append("--Split, Combine 관련하여 상단에서 WITH 절 BKG1,2 의 CGOR_DT 여부로 Customs 체크하여 처리 한다" ).append("\n"); 
		query.append("CASE WHEN A.CNTR_NO IS NOT NULL AND SUBSTR(A.CNTR_TPSZ_CD,-1) = '2' THEN 0.5 * A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("WHEN A.CNTR_NO IS NOT NULL AND SUBSTR(A.CNTR_TPSZ_CD,-1) <> '2' THEN A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("ELSE  0" ).append("\n"); 
		query.append("END CURL_QTY_Y," ).append("\n"); 
		query.append("--Split, Combine 관련하여 상단에서 WITH 절 BKG1,2 의 CGOR_DT 여부로 Customs 체크하여 처리 한다" ).append("\n"); 
		query.append("CASE WHEN A.CNTR_NO IS NOT NULL AND SUBSTR(A.CNTR_TPSZ_CD,-1) = '2' THEN 0.5 * A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("WHEN A.CNTR_NO IS NOT NULL AND SUBSTR(A.CNTR_TPSZ_CD,-1) <> '2' THEN A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("ELSE  0" ).append("\n"); 
		query.append("END CURL_QTY_N," ).append("\n"); 
		query.append("CASE WHEN A.MVMT_STS_CD ='OP' AND SUBSTR(A.CNTR_TPSZ_CD,-1) = '2' THEN 0.5 * A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("WHEN A.MVMT_STS_CD ='OP' AND SUBSTR(A.CNTR_TPSZ_CD,-1) <> '2' THEN A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("ELSE  0" ).append("\n"); 
		query.append("END OP_TOT," ).append("\n"); 
		query.append("CASE WHEN A.MVMT_STS_CD ='OC' AND SUBSTR(A.CNTR_TPSZ_CD,-1) = '2' THEN 0.5 * A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("WHEN A.MVMT_STS_CD ='OC' AND SUBSTR(A.CNTR_TPSZ_CD,-1) <> '2' THEN A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("ELSE  0" ).append("\n"); 
		query.append("END OC_TOT," ).append("\n"); 
		query.append("CASE WHEN A.MVMT_STS_CD ='VL' AND SUBSTR(A.CNTR_TPSZ_CD,-1) = '2' THEN 0.5 * A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("WHEN A.MVMT_STS_CD ='VL' AND SUBSTR(A.CNTR_TPSZ_CD,-1) <> '2' THEN A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("ELSE  0" ).append("\n"); 
		query.append("END VL_TOT," ).append("\n"); 
		query.append("CASE WHEN A.MVMT_STS_CD <>'OP' AND A.MVMT_STS_CD <>'OC' AND A.MVMT_STS_CD <>'VL' AND SUBSTR(A.CNTR_TPSZ_CD,-1) = '2' THEN 0.5 *A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("WHEN A.MVMT_STS_CD <>'OP' AND A.MVMT_STS_CD <>'OC' AND A.MVMT_STS_CD <>'VL' AND SUBSTR(A.CNTR_TPSZ_CD,-1) <> '2' THEN A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("ELSE  0" ).append("\n"); 
		query.append("END OT_TOT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT K.COP_NO" ).append("\n"); 
		query.append("FROM SCE_COP_HDR K,BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE K.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND   K.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND   K.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("AND   K.POD_NOD_CD = BK.POD_NOD_CD" ).append("\n"); 
		query.append("AND   K.DEL_NOD_CD = BK.DEL_NOD_CD" ).append("\n"); 
		query.append("AND   K.COP_STS_CD <> 'X') AS COP_NO" ).append("\n"); 
		query.append(",A.RNUM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VB.BKG_STS_CD," ).append("\n"); 
		query.append("VB.SHPR_NAME," ).append("\n"); 
		query.append("VB.CONSIGNEE_NAME," ).append("\n"); 
		query.append("VB.POR_CD," ).append("\n"); 
		query.append("VB.POD_CD," ).append("\n"); 
		query.append("VB.RCV_TERM_CD," ).append("\n"); 
		query.append("VB.DE_TERM_CD," ).append("\n"); 
		query.append("B.CNTR_VOL_QTY," ).append("\n"); 
		query.append("B.CNTR_PRT_FLG,  -- LSJ 추가" ).append("\n"); 
		query.append("B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("B.CNTR_NO," ).append("\n"); 
		query.append("B.CNMV_CYC_NO," ).append("\n"); 
		query.append("B.CNMV_YR," ).append("\n"); 
		query.append("MOVE.MVMT_STS_CD," ).append("\n"); 
		query.append("EIR.CGOR_DT," ).append("\n"); 
		query.append("NVL(EIR.CHN_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("NVL(DECODE(B.CNTR_PRT_FLG, 'Y'," ).append("\n"); 
		query.append("(SELECT A3.CHN_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("FROM BKG_CONTAINER A1, BKG_WORK_V A2, BKG_OB_CHN_RCV A3" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("AND A1.BKG_NO = A3.BKG_NO" ).append("\n"); 
		query.append("AND A2.KEY_VSL_CD = VB.KEY_VSL_CD" ).append("\n"); 
		query.append("AND A2.KEY_SKD_VOY_NO = VB.KEY_SKD_VOY_NO" ).append("\n"); 
		query.append("AND A2.KEY_SKD_DIR_CD = VB.KEY_SKD_DIR_CD" ).append("\n"); 
		query.append("AND A2.KEY_POL_CD = VB.KEY_POL_CD" ).append("\n"); 
		query.append("AND A1.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND A3.CHN_EDI_MSG_TP_ID ='SUN'),EIR.CHN_EDI_MSG_TP_ID),'NNN')" ).append("\n"); 
		query.append(") CHN_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("NVL(EIR.MSG_RCV_NO," ).append("\n"); 
		query.append("DECODE(B.CNTR_PRT_FLG, 'Y'," ).append("\n"); 
		query.append("(SELECT A3.MSG_RCV_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER A1, BKG_WORK_V A2, BKG_OB_CHN_RCV A3" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("AND A1.BKG_NO = A3.BKG_NO" ).append("\n"); 
		query.append("AND A2.KEY_VSL_CD = VB.KEY_VSL_CD" ).append("\n"); 
		query.append("AND A2.KEY_SKD_VOY_NO = VB.KEY_SKD_VOY_NO" ).append("\n"); 
		query.append("AND A2.KEY_SKD_DIR_CD = VB.KEY_SKD_DIR_CD" ).append("\n"); 
		query.append("AND A2.KEY_POL_CD = VB.KEY_POL_CD" ).append("\n"); 
		query.append("AND A1.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND A3.CHN_EDI_MSG_TP_ID ='SUN'),EIR.MSG_RCV_NO)" ).append("\n"); 
		query.append(") MSG_RCV_NO," ).append("\n"); 
		query.append("NVL(EIR.RCV_LOG_SEQ," ).append("\n"); 
		query.append("DECODE(B.CNTR_PRT_FLG, 'Y'," ).append("\n"); 
		query.append("(SELECT A3.RCV_LOG_SEQ" ).append("\n"); 
		query.append("FROM BKG_CONTAINER A1, BKG_WORK_V A2, BKG_OB_CHN_RCV A3" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("AND A1.BKG_NO = A3.BKG_NO" ).append("\n"); 
		query.append("AND A2.KEY_VSL_CD = VB.KEY_VSL_CD" ).append("\n"); 
		query.append("AND A2.KEY_SKD_VOY_NO = VB.KEY_SKD_VOY_NO" ).append("\n"); 
		query.append("AND A2.KEY_SKD_DIR_CD = VB.KEY_SKD_DIR_CD" ).append("\n"); 
		query.append("AND A2.KEY_POL_CD = VB.KEY_POL_CD" ).append("\n"); 
		query.append("AND A1.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND A3.CHN_EDI_MSG_TP_ID ='SUN'),EIR.RCV_LOG_SEQ)" ).append("\n"); 
		query.append(") RCV_LOG_SEQ," ).append("\n"); 
		query.append("-- 		   NVL(EIR.CHN_EDI_MSG_TP_ID,'NNN') CHN_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("--	       EIR.MSG_RCV_NO," ).append("\n"); 
		query.append("--	       EIR.RCV_LOG_SEQ," ).append("\n"); 
		query.append("VB.BKG_NO," ).append("\n"); 
		query.append("EIR.EIR_XCH_DT," ).append("\n"); 
		query.append("EIR.POL_NM," ).append("\n"); 
		query.append("EIR.POD_NM," ).append("\n"); 
		query.append("EIR.VVD_CD," ).append("\n"); 
		query.append("EIR.VVD_NM," ).append("\n"); 
		query.append("EIR.CSTMS_LOC_CD," ).append("\n"); 
		query.append("EIR.CNTR_NO EIR_CNTR_NO," ).append("\n"); 
		query.append("ROW_NUMBER() OVER (PARTITION BY VB.BKG_NO,B.CNTR_NO ORDER BY EIR.UPD_DT DESC)  AS RNUM" ).append("\n"); 
		query.append("FROM BKG_WORK_V VB," ).append("\n"); 
		query.append("BKG_CONTAINER B," ).append("\n"); 
		query.append("CTM_MOVEMENT MOVE," ).append("\n"); 
		query.append("BKG_OB_CHN_RCV EIR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VB.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND VB.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("AND B.CNTR_NO = MOVE.CNTR_NO(+)" ).append("\n"); 
		query.append("AND B.CNMV_YR = MOVE.CNMV_YR(+)" ).append("\n"); 
		query.append("AND B.CNMV_ID_NO = MOVE.CNMV_ID_NO(+)" ).append("\n"); 
		query.append("AND B.BKG_NO = EIR.BKG_NO(+)" ).append("\n"); 
		query.append("AND B.CNTR_NO = EIR.CNTR_NO(+)" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("AND   VB.KEY_VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND   VB.KEY_SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND   VB.KEY_SKD_DIR_CD =  SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_inc_sub} == 'Y')" ).append("\n"); 
		query.append("AND VB.BKG_OFC_CD IN (" ).append("\n"); 
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("FROM   MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("START WITH MO.OFC_CD = NVL(@[bkg_ofc_cd],VB.BKG_OFC_CD)" ).append("\n"); 
		query.append("CONNECT BY PRIOR MO.OFC_CD = MO.PRNT_OFC_CD)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("AND   VB.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_dt_fr} != '' || ${bkg_dt_fr} != '')" ).append("\n"); 
		query.append("AND VB.BKG_CRE_DT BETWEEN TO_DATE(@[bkg_dt_fr],'YYYY-MM-DD') AND TO_DATE(@[bkg_dt_to],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${bkg_dt_fr} != '')" ).append("\n"); 
		query.append("AND VB.BKG_CRE_DT <= TO_DATE(@[bkg_dt_to],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#elseif (${bkg_dt_to} != '')" ).append("\n"); 
		query.append("AND VB.BKG_CRE_DT >= TO_DATE(@[bkg_dt_fr],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND VB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND  VB.KEY_POL_CD  LIKE RTRIM(@[pol_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("AND  VB.POR_CD LIKE RTRIM(@[por_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rcv_term_cd} != '')" ).append("\n"); 
		query.append("AND B.RCV_TERM_CD = @[rcv_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${de_term_cd} != '')" ).append("\n"); 
		query.append("AND VB.DE_TERM_CD = @[de_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_yd_cd} != '')" ).append("\n"); 
		query.append("AND B.ORG_YD_CD LIKE  @[org_yd_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chk_lt_type} == 'L')" ).append("\n"); 
		query.append("AND  VB.KEY_POL_CD = VB.POL_CD	--L/T Local" ).append("\n"); 
		query.append("#elseif (${chk_lt_type} == 'T')" ).append("\n"); 
		query.append("AND  VB.KEY_POL_CD <> VB.POL_CD	--T/S" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_cfm_flg} != '')" ).append("\n"); 
		query.append("AND B.CNTR_CFM_FLG = @[cntr_cfm_flg]  --Booking Container의 Tab의 Confirm 정보" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} != '')" ).append("\n"); 
		query.append("AND VB.BKG_STS_CD = @[bkg_sts_cd]  	--예약 현황" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pre_1_vvd} != '')" ).append("\n"); 
		query.append("AND VB.PRE_1_VVD LIKE @[pre_1_vvd] || '%'	--pre_vvd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pre_1_pol_cd} != '')" ).append("\n"); 
		query.append("AND VB.PRE_1_POL_CD = @[pre_1_pol_cd]		--pre_pol" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${xter_bkg_rqst_cd} != '')" ).append("\n"); 
		query.append("AND VB.XTER_BKG_RQST_CD = @[xter_bkg_rqst_cd]	--BKG Kind" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnmv_sts_cd} == 'Y')" ).append("\n"); 
		query.append("AND B.CNMV_STS_CD = 'OC'	--O/C Status    Container Status가 OC인 항목 조회" ).append("\n"); 
		query.append("#elseif  (${cnmv_sts_cd} == 'N')" ).append("\n"); 
		query.append("AND B.CNMV_STS_CD != 'OC'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("AND VB.BKG_CGO_TP_CD = @[bkg_cgo_tp_cd]	 --화물 종류All, Full, Empty로 구분 (Cargo Type 코드 참고)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dest_trns_svc_mod_cd} != '')" ).append("\n"); 
		query.append("AND VB.DEST_TRNS_SVC_MOD_CD = @[dest_trns_svc_mod_cd]	--Service Mode" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--------------------------------------------------------------------------" ).append("\n"); 
		query.append("--1.'SHPR'" ).append("\n"); 
		query.append("#if (${cust_tp_cd} == 'S')" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' && ${cust_seq} == '')" ).append("\n"); 
		query.append("AND	  SUBSTR(VB.SHIPPER,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' && ${cust_seq} != '')" ).append("\n"); 
		query.append("AND	  VB.SHIPPER LIKE @[cust_cnt_cd] || @[cust_seq] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("AND	  VB.SHPR_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--2.'CNEE'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'C')" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' && ${cust_seq} == '')" ).append("\n"); 
		query.append("AND	  SUBSTR(VB.CONSIGNEE,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' && ${cust_seq} != '')" ).append("\n"); 
		query.append("AND	  VB.CONSIGNEE LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("AND	  VB.CONSIGNEE_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--3.'NTFY'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'N')" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' && ${cust_seq} == '')" ).append("\n"); 
		query.append("AND	  SUBSTR(VB.NTFY,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' && ${cust_seq} != '')" ).append("\n"); 
		query.append("AND	  VB.NTFY LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("AND	  VB.NTFY_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--4.'ANFY'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'A')" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' && ${cust_seq} == '')" ).append("\n"); 
		query.append("AND	  SUBSTR(VB.ANTY,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' && ${cust_seq} != '')" ).append("\n"); 
		query.append("AND	  VB.ANTY LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("AND	  VB.ANTY_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--5.'FWDR'" ).append("\n"); 
		query.append("#elseif (${cust_tp_cd} == 'F')" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' && ${cust_seq} == '')" ).append("\n"); 
		query.append("AND	  SUBSTR(VB.FFDR,1,2) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' && ${cust_seq} != '')" ).append("\n"); 
		query.append("AND	  VB.FFDR LIKE @[cust_cnt_cd] || @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("AND	  VB.FFDR_NAME LIKE   @[cust_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--6.'선택하지 않았을때..'" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' && ${cust_seq} == '')" ).append("\n"); 
		query.append("AND	  	(SUBSTR(VB.SHIPPER,1,2) = @[cust_cnt_cd] OR" ).append("\n"); 
		query.append("SUBSTR(VB.CONSIGNEE,1,2)= @[cust_cnt_cd] OR" ).append("\n"); 
		query.append("SUBSTR(VB.NTFY,1,2) = @[cust_cnt_cd] OR" ).append("\n"); 
		query.append("SUBSTR(VB.ANTY,1,2) = @[cust_cnt_cd] OR" ).append("\n"); 
		query.append("SUBSTR(VB.FFDR,1,2) = @[cust_cnt_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '' && ${cust_seq} != '')" ).append("\n"); 
		query.append("AND		(VB.SHIPPER = @[cust_cnt_cd] || @[cust_seq] OR" ).append("\n"); 
		query.append("VB.CONSIGNEE = @[cust_cnt_cd] || @[cust_seq] OR" ).append("\n"); 
		query.append("VB.NTFY = @[cust_cnt_cd]|| @[cust_seq] OR" ).append("\n"); 
		query.append("VB.ANTY = @[cust_cnt_cd]|| @[cust_seq] OR" ).append("\n"); 
		query.append("VB.FFDR = @[cust_cnt_cd]|| @[cust_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("AND		(VB.SHPR_NAME = @[cust_nm] OR" ).append("\n"); 
		query.append("VB.CONSIGNEE_NAME = @[cust_nm] OR" ).append("\n"); 
		query.append("VB.NTFY_NAME = @[cust_nm] OR" ).append("\n"); 
		query.append("VB.ANTY_NAME = @[cust_nm] OR" ).append("\n"); 
		query.append("VB.FFDR_NAME = @[cust_nm])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND RNUM = 1" ).append("\n"); 
		query.append("AND CHN_EDI_MSG_TP_ID IN ('SUN','YTI','NNN')" ).append("\n"); 
		query.append(") K" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${eir_flg} != '')" ).append("\n"); 
		query.append("AND EIR_FLG = @[eir_flg]  --EIR 접수 여부" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${curl_flg} != '')" ).append("\n"); 
		query.append("AND CURL_FLG = @[curl_flg]  --세관 통과 여부" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("order by BKG_NO,BKG_RNUM,CNTR_RNUM" ).append("\n"); 

	}
}