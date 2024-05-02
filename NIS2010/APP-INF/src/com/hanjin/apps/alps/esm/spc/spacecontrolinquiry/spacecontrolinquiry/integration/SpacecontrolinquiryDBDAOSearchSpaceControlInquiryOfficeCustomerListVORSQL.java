/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeCustomerListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.20
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.07.20 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeCustomerListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSpaceControlInquiryOfficeCustomerListVO
	  * - Lee Sang-Yong : [프로젝트] Ticket ID : CHM-201004171 53ft 추가
	  * 2011.07.05 [ CHM-201111880-01] 김종준control by HO 화면 보완 - IPC, TS 관련
	  * 2012.12.03 [CHM-201221639] 김시몬 R9와 동일하게 R8이 적용될 수 있도록 쿼리수정
	  * 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2013.09.24 [Trouble Shooting] 성수기 season 조회해 오는 부분 index 누락
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.03.05 김시몬 [선처리] BKG RFA NULL 관련 보완
	  * 2014.03.17 [CHM-20142960] SMP/Allocation control보완 요청 - SPC_GET_SMP_AMEND_FNC 적용
	  * 2014.05.22 [선반영] AES-SC관련 로직 추가
	  * 2015.07.16 Arie [CHM-201537094] MAS CMB 산출 로직 변경 적용 - dem/det 추가 CM = REV+DEM/DET-COST TTL
	  * 2015.09.16 이혜민 선반영 SPC_CONTI_CONV_FNC 태울때 SLAN_CD를 인자로 가져가던것 RLANE_CD로 수정 (RLANE_CD로 가져가야 제대로 펑션을 탐)
	  * 2016.07.05 CHM-201642241 VGM(BKG상 표시되는 또 다른 WGT 정보) 도입 관련 SPC 사항
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeCustomerListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sales_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquiryOfficeCustomerListVORSQL").append("\n"); 
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
		query.append("WITH PARAM AS (" ).append("\n"); 
		query.append("    SELECT P.TRD_CD," ).append("\n"); 
		query.append("           P.SUB_TRD_CD," ).append("\n"); 
		query.append("           P.RLANE_CD," ).append("\n"); 
		query.append("           P.VSL_CD," ).append("\n"); 
		query.append("           P.SKD_VOY_NO," ).append("\n"); 
		query.append("           P.SKD_DIR_CD," ).append("\n"); 
		query.append("           P.OFC_CD," ).append("\n"); 
		query.append("           P.CUST_TP_CD," ).append("\n"); 
		query.append("           SUBSTR(V.SLS_YRMON, 1, 4) AS COST_YR," ).append("\n"); 
		query.append("           V.COST_WK," ).append("\n"); 
		query.append("           V.IOC_CD," ).append("\n"); 
		query.append("           (SELECT /*+INDEX_DESC (M XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("            	   DECODE(DECODE(Q.DIR_CD, NULL, 'N', 'Y'), 'Y', COST_YRWK||'-'||VER_SEQ, '200001-1')" ).append("\n"); 
		query.append("              FROM SPC_MDL_VER_MST M" ).append("\n"); 
		query.append("             WHERE SUBSTR(V.SLS_YRMON, 1, 4)||V.COST_WK BETWEEN M.VER_ST_YRWK AND M.VER_END_YRWK" ).append("\n"); 
		query.append("               AND M.TRD_CD  = V.TRD_CD" ).append("\n"); 
		query.append("               AND M.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("               AND ROWNUM = 1) AS SEASON" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT @[trade]        AS TRD_CD    ," ).append("\n"); 
		query.append("                   @[subtrade]     AS SUB_TRD_CD," ).append("\n"); 
		query.append("                   @[lane]         AS RLANE_CD  ," ).append("\n"); 
		query.append("                   @[vsl_cd]       AS VSL_CD    ," ).append("\n"); 
		query.append("                   @[skd_voy_no]   AS SKD_VOY_NO," ).append("\n"); 
		query.append("                   @[skd_dir_cd]   AS SKD_DIR_CD," ).append("\n"); 
		query.append("                   @[sales_office] AS OFC_CD    ," ).append("\n"); 
		query.append("                   @[pol_pod]      AS CUST_TP_CD" ).append("\n"); 
		query.append("              FROM DUAL" ).append("\n"); 
		query.append("           ) P," ).append("\n"); 
		query.append("           MAS_MON_VVD    V," ).append("\n"); 
		query.append("           SPC_HD_HUL_MST Q" ).append("\n"); 
		query.append("     WHERE P.TRD_CD     = V.TRD_CD" ).append("\n"); 
		query.append("       AND P.SUB_TRD_CD = V.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND P.RLANE_CD   = V.RLANE_CD" ).append("\n"); 
		query.append("       AND P.VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("       AND P.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND P.SKD_DIR_CD = V.DIR_CD" ).append("\n"); 
		query.append("       AND V.TRD_CD     = Q.TRD_CD   (+)" ).append("\n"); 
		query.append("       AND V.RLANE_CD   = Q.RLANE_CD (+)" ).append("\n"); 
		query.append("       AND V.DIR_CD     = Q.DIR_CD   (+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", FCT_DATA AS (" ).append("\n"); 
		query.append("    SELECT ROW_NUMBER() OVER ( PARTITION BY DECODE(Z.POL_YD_CD, NULL, 1, 2) ORDER BY NVL(SUM(Z.CFM_TTL_QTY), 0) DESC) AS IDX," ).append("\n"); 
		query.append("           Z.CUST_CNT_CD," ).append("\n"); 
		query.append("           Z.CUST_SEQ   ," ).append("\n"); 
		query.append("           DECODE(Z.POL_YD_CD, NULL, 'POD', 'POL') AS FLG    ," ).append("\n"); 
		query.append("           NVL(Z.POL_YD_CD, Z.POD_YD_CD)           AS PORT_CD," ).append("\n"); 
		query.append("           -- SUBSTR(NVL(Z.POL_YD_CD, Z.POD_YD_CD), 1, 5) AS PORT_CD," ).append("\n"); 
		query.append("           Z.SLS_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("           Z.SC_NO," ).append("\n"); 
		query.append("           Z.RFA_NO," ).append("\n"); 
		query.append("           SUM(Z.CFM_TTL_QTY)     AS FCT_TEU," ).append("\n"); 
		query.append("           SUM(Z.CFM_40FT_HC_QTY) AS FCT_HC ," ).append("\n"); 
		query.append("           SUM(Z.CFM_45FT_HC_QTY) AS FCT_45 ," ).append("\n"); 
		query.append("           SUM(Z.CFM_53FT_QTY)    AS FCT_53 ," ).append("\n"); 
		query.append("           SUM(Z.CFM_RF_QTY)      AS FCT_RF ," ).append("\n"); 
		query.append("           SUM(Z.CFM_TTL_WGT)     AS FCT_WGT" ).append("\n"); 
		query.append("      FROM SPC_DLY_FCAST_CUST Z," ).append("\n"); 
		query.append("           PARAM              P" ).append("\n"); 
		query.append("     WHERE Z.RLANE_CD         = P.RLANE_CD" ).append("\n"); 
		query.append("       AND Z.DIR_CD           = P.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND Z.VSL_CD           = P.VSL_CD" ).append("\n"); 
		query.append("       AND Z.SKD_VOY_NO       = P.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND Z.SKD_DIR_CD       = P.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND Z.SLS_OFC_CD       = P.OFC_CD" ).append("\n"); 
		query.append("       AND Z.TRD_CD           = P.TRD_CD" ).append("\n"); 
		query.append("       AND Z.SUB_TRD_CD       = P.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND Z.FCAST_CUST_TP_CD = P.CUST_TP_CD" ).append("\n"); 
		query.append("       AND Z.POL_YD_CD<>'0000000'" ).append("\n"); 
		query.append("--       AND Z.IOC_TS_CD       <> 'T'" ).append("\n"); 
		query.append("--       AND NVL(Z.CFM_TTL_QTY, 0) + NVL(Z.CFM_TTL_WGT, 0) > 0 " ).append("\n"); 
		query.append("       AND NVL(Z.CFM_TTL_QTY, 0) + NVL(Z.CFM_40FT_HC_QTY, 0) + NVL(Z.CFM_45FT_HC_QTY, 0) + NVL(Z.CFM_53FT_QTY, 0) + NVL(Z.CFM_TTL_WGT, 0) + NVL(Z.CFM_RF_QTY,0)  > 0" ).append("\n"); 
		query.append("  GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                           (Z.CUST_CNT_CD, Z.CUST_SEQ, Z.SLS_OFC_CD, Z.SC_NO, Z.RFA_NO, Z.POL_YD_CD)," ).append("\n"); 
		query.append("                           (Z.CUST_CNT_CD, Z.CUST_SEQ, Z.SLS_OFC_CD, Z.SC_NO, Z.RFA_NO, Z.POD_YD_CD)" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", BKG_DATA AS (" ).append("\n"); 
		query.append("	 SELECT" ).append("\n"); 
		query.append("	     ROW_NUMBER() OVER ( PARTITION BY LVL.IDX ORDER BY SUM(NVL(BKG_TTL_QTY, 0)) DESC) AS IDX" ).append("\n"); 
		query.append("	    ,DECODE(P.CUST_TP_CD, 'S', SHPR_CNT_CD  , AGMT_CNT_CD  ) AS CUST_CNT_CD" ).append("\n"); 
		query.append("	    ,DECODE(P.CUST_TP_CD, 'S', SHPR_CUST_SEQ, AGMT_CUST_SEQ) AS CUST_SEQ   " ).append("\n"); 
		query.append("	    ,DECODE(LVL.IDX, 1, 'POL', 2, 'POD') AS FLG" ).append("\n"); 
		query.append("	    ,DECODE(LVL.IDX, 1, NVL(POL_YD_CD, POL_CD), 2, NVL(POD_YD_CD, POD_CD)) AS PORT_CD" ).append("\n"); 
		query.append("	    ,SLS_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("        ,SC_NO" ).append("\n"); 
		query.append("        ,RFA_NO" ).append("\n"); 
		query.append("	    ,SUM(FIRM_VOL)  FIRM_TEU" ).append("\n"); 
		query.append("	    ,SUM(FIRM_20)  FIRM_20" ).append("\n"); 
		query.append("	    ,SUM(FIRM_40)  FIRM_40" ).append("\n"); 
		query.append("	    ,SUM(FIRM_HC)  FIRM_HC" ).append("\n"); 
		query.append("	    ,SUM(FIRM_45)  FIRM_45" ).append("\n"); 
		query.append("	    ,SUM(FIRM_53)  FIRM_53" ).append("\n"); 
		query.append("	    ,SUM(FIRM_RF)  FIRM_RF" ).append("\n"); 
		query.append("	    ,SUM(FIRM_WGT)  FIRM_WGT" ).append("\n"); 
		query.append("	    ,SUM(WAT_VOL)  WAIT_TEU" ).append("\n"); 
		query.append("	    ,SUM(WAT_20 )  WAIT_20 " ).append("\n"); 
		query.append("	    ,SUM(WAT_40 )  WAIT_40 " ).append("\n"); 
		query.append("	    ,SUM(WAT_HC )  WAIT_HC " ).append("\n"); 
		query.append("	    ,SUM(WAT_45 )  WAIT_45 " ).append("\n"); 
		query.append("	    ,SUM(WAT_53 )  WAIT_53 " ).append("\n"); 
		query.append("	    ,SUM(WAT_RF )  WAIT_RF " ).append("\n"); 
		query.append("	    ,SUM(WAT_WGT)  WAIT_WGT " ).append("\n"); 
		query.append("		,NVL(SUM(BKG_VOL_VGM),0)  BKG_VOL_VGM " ).append("\n"); 
		query.append("	    ,NVL(SUM(BKG_WGT_VGM),0)  BKG_WGT_VGM 	    " ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	    SELECT" ).append("\n"); 
		query.append("	          POD_CD" ).append("\n"); 
		query.append("	        , POL_CD" ).append("\n"); 
		query.append("	        , POD_YD_CD" ).append("\n"); 
		query.append("	        , POL_YD_CD" ).append("\n"); 
		query.append("	    	, DECODE(BKG_STS_CD, 'F', TO_NUMBER(NVL(SUBSTR(VAL, 1, 14), 0)), 0)   AS FIRM_VOL" ).append("\n"); 
		query.append("	    	, DECODE(BKG_STS_CD, 'F', TO_NUMBER(NVL(SUBSTR(VAL, 15, 14), 0)), 0)  AS FIRM_20" ).append("\n"); 
		query.append("	    	, DECODE(BKG_STS_CD, 'F', TO_NUMBER(NVL(SUBSTR(VAL, 29, 14), 0)), 0)  AS FIRM_40" ).append("\n"); 
		query.append("	    	, DECODE(BKG_STS_CD, 'F', TO_NUMBER(NVL(SUBSTR(VAL, 43, 14), 0)), 0)  AS FIRM_HC" ).append("\n"); 
		query.append("	    	, DECODE(BKG_STS_CD, 'F', TO_NUMBER(NVL(SUBSTR(VAL, 57, 14), 0)), 0)  AS FIRM_45" ).append("\n"); 
		query.append("	    	, DECODE(BKG_STS_CD, 'F', TO_NUMBER(NVL(SUBSTR(VAL, 71, 14), 0)), 0)  AS FIRM_53" ).append("\n"); 
		query.append("	    	, DECODE(BKG_STS_CD, 'F', TO_NUMBER(NVL(SUBSTR(VAL, 85, 14), 0)), 0)  AS FIRM_RF" ).append("\n"); 
		query.append("	    	, DECODE(BKG_STS_CD, 'F', TO_NUMBER(NVL(SUBSTR(VAL, 99, 14), 0)), 0)  AS FIRM_WGT" ).append("\n"); 
		query.append("	    	, DECODE(BKG_STS_CD, 'W', TO_NUMBER(NVL(SUBSTR(VAL, 1, 14), 0)), 0)   AS WAT_VOL" ).append("\n"); 
		query.append("	    	, DECODE(BKG_STS_CD, 'W', TO_NUMBER(NVL(SUBSTR(VAL, 15, 14), 0)), 0)  AS WAT_20" ).append("\n"); 
		query.append("	    	, DECODE(BKG_STS_CD, 'W', TO_NUMBER(NVL(SUBSTR(VAL, 29, 14), 0)), 0)  AS WAT_40" ).append("\n"); 
		query.append("	    	, DECODE(BKG_STS_CD, 'W', TO_NUMBER(NVL(SUBSTR(VAL, 43, 14), 0)), 0)  AS WAT_HC" ).append("\n"); 
		query.append("	    	, DECODE(BKG_STS_CD, 'W', TO_NUMBER(NVL(SUBSTR(VAL, 57, 14), 0)), 0)  AS WAT_45" ).append("\n"); 
		query.append("	    	, DECODE(BKG_STS_CD, 'W', TO_NUMBER(NVL(SUBSTR(VAL, 71, 14), 0)), 0)  AS WAT_53" ).append("\n"); 
		query.append("	    	, DECODE(BKG_STS_CD, 'W', TO_NUMBER(NVL(SUBSTR(VAL, 85, 14), 0)), 0)  AS WAT_RF" ).append("\n"); 
		query.append("	    	, DECODE(BKG_STS_CD, 'W', TO_NUMBER(NVL(SUBSTR(VAL, 99, 14), 0)), 0)  AS WAT_WGT" ).append("\n"); 
		query.append("	        , TO_NUMBER(NVL(SUBSTR(AGMT_CD, 4), 0)) AS AGMT_CUST_SEQ " ).append("\n"); 
		query.append("	        , TO_NUMBER(NVL(SUBSTR(SHPR_CD, 3), 0)) AS SHPR_CUST_SEQ    " ).append("\n"); 
		query.append("	        , TO_NUMBER(NVL(SUBSTR(VAL , 1, 14), 0)) AS BKG_TTL_QTY " ).append("\n"); 
		query.append("	        , SUBSTR(AGMT_CD, 2, 2) AS AGMT_CNT_CD " ).append("\n"); 
		query.append("	        , SUBSTR(SHPR_CD, 1, 2) AS SHPR_CNT_CD " ).append("\n"); 
		query.append("	        , SLS_OFC_CD " ).append("\n"); 
		query.append("            , SC_NO" ).append("\n"); 
		query.append("            , RFA_NO,BKG_VOL_VGM,BKG_WGT_VGM" ).append("\n"); 
		query.append("	    FROM" ).append("\n"); 
		query.append("	    (" ).append("\n"); 
		query.append("	        SELECT B.BKG_STS_CD" ).append("\n"); 
		query.append("	    		, O.N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("	            , O.N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("	    		, O.N4TH_PRNT_OFC_CD" ).append("\n"); 
		query.append("	    		, BV.POL_YD_CD" ).append("\n"); 
		query.append("	    		, BV.POL_CD" ).append("\n"); 
		query.append("	    		, BV.POD_YD_CD" ).append("\n"); 
		query.append("	    		, BV.POD_CD" ).append("\n"); 
		query.append("	    		, B.DEL_NOD_CD" ).append("\n"); 
		query.append("	    		, B.DEL_CD" ).append("\n"); 
		query.append("	            , BV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("	            , M.OFC_CD" ).append("\n"); 
		query.append("                , SPC_GET_SMP_AMEND_FNC(M.TRD_CD, SUBSTR(M.SEASON, 1, 6), SUBSTR(M.SEASON, 8), B.SC_NO) AS SC_NO" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                --20140304 추가" ).append("\n"); 
		query.append("                , CASE WHEN M.TRD_CD = 'AES' AND DECODE(SUBSTR(B.RFA_NO, 1, 3), 'DUM', '', B.RFA_NO) IS NULL AND BC.CUST_CNT_CD = 'CN' AND B.SC_NO IS NULL THEN" ).append("\n"); 
		query.append("                      DECODE(SPC_GET_SMP_RFA_FNC('R',M.SEASON,  BC.CUST_CNT_CD||LPAD(BC.CUST_SEQ,6,'0'), B.POL_CD,B.POD_CD),'','','1'||SPC_GET_SMP_RFA_FNC('R',M.SEASON,  BC.CUST_CNT_CD||LPAD(BC.CUST_SEQ,6,'0'), B.POL_CD,B.POD_CD))" ).append("\n"); 
		query.append("                ELSE   " ).append("\n"); 
		query.append("                      SPC_GET_SMP_AMEND_FNC(M.TRD_CD, SUBSTR(M.SEASON, 1, 6), SUBSTR(M.SEASON, 8), DECODE(SUBSTR(B.RFA_NO, 1, 3), 'DUM', '', B.RFA_NO))" ).append("\n"); 
		query.append("                END AS RFA_NO" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("	    		, (SELECT  TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY), 'FM0000000000.000') " ).append("\n"); 
		query.append("	    				|| TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000') " ).append("\n"); 
		query.append("	    				|| TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '4', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000') " ).append("\n"); 
		query.append("	    				|| TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '5', Q.OP_CNTR_QTY, '9', Q.OP_CNTR_QTY, '8', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')	--R9,R8에 대해서 R5과 동일하게 HC으로 처리되도록 추가" ).append("\n"); 
		query.append("	    				|| TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '7', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')  " ).append("\n"); 
		query.append("	    				|| TO_CHAR(SUM(DECODE(Q.CNTR_TPSZ_CD, 'DW', Q.OP_CNTR_QTY, 'DX', Q.OP_CNTR_QTY, 0)) , 'FM0000000000.000')  " ).append("\n"); 
		query.append("	    				|| TO_CHAR(SUM(DECODE(SUBSTR(Q.CNTR_TPSZ_CD, 1, 1), 'R', Q.OP_CNTR_QTY - Q.EQ_SUBST_CGO_QTY, 0)), 'FM0000000000.000') " ).append("\n"); 
		query.append("	    				|| TO_CHAR((R.ACT_WGT * DECODE(R.ACT_WGT,'LBS', 0.00045, 0.001)) " ).append("\n"); 
		query.append("	    						+ SUM(Q.OP_CNTR_QTY * (SELECT TS.CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("	       												 FROM MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append("	      												WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD)) * 0.001, 'FM0000000000.000')" ).append("\n"); 
		query.append("	    	 		  FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("	        		 WHERE B.BKG_NO = Q.BKG_NO) VAL" ).append("\n"); 
		query.append("	            ,(" ).append("\n"); 
		query.append("	                SELECT NVL(C.CUST_CNT_CD, '  ')||C.CUST_SEQ SHPR_CD" ).append("\n"); 
		query.append("	                        FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append("	                        WHERE B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("	                          AND C.BKG_CUST_TP_CD = 'S' " ).append("\n"); 
		query.append("	            ) AS SHPR_CD" ).append("\n"); 
		query.append("	            ,DECODE(DECODE(NVL(B.RFA_NO, 'DUM00000001'), 'DUM00000001', 'X', B.RFA_NO)||DECODE(NVL(B.SC_NO, 'DUM00001'), 'DUM00001', 'X', B.SC_NO), 'XX', 'S', 'C')|| NVL(RTRIM(B.CTRT_CUST_CNT_CD), '  ')||B.CTRT_CUST_SEQ AS AGMT_CD" ).append("\n"); 
		query.append("	            ,M.CUST_TP_CD" ).append("\n"); 
		query.append("	            ,O.SPC_SLS_OFC_CD AS SLS_OFC_CD" ).append("\n"); 
		query.append("				,(" ).append("\n"); 
		query.append("				SELECT SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Z.CNTR_TPSZ_CD), '2', 1, 2)* Z.OP_CNTR_QTY) " ).append("\n"); 
		query.append("				FROM BKG_QUANTITY Z " ).append("\n"); 
		query.append("				WHERE Z.BKG_NO= B.BKG_NO AND OP_CNTR_QTY > 0 " ).append("\n"); 
		query.append("				AND EXISTS ( SELECT 1 FROM BKG_CONTAINER C WHERE C.BKG_NO= Z.BKG_NO AND VGM_WGT>0 AND VGM_WGT IS NOT NULL )" ).append("\n"); 
		query.append("				) AS BKG_VOL_VGM" ).append("\n"); 
		query.append("				,(SELECT SUM(NVL(Z.VGM_WGT,0) * DECODE(Z.VGM_WGT_UT_CD,'LBS',0.00045,0.001)) FROM BKG_CONTAINER Z WHERE Z.BKG_NO= B.BKG_NO AND VGM_WGT>0 AND VGM_WGT IS NOT NULL) AS BKG_WGT_VGM				" ).append("\n"); 
		query.append("	       FROM BKG_VVD              BV" ).append("\n"); 
		query.append("	    		, BKG_BOOKING        B" ).append("\n"); 
		query.append("	    		, PARAM              M" ).append("\n"); 
		query.append("	    		, BKG_BL_DOC         R" ).append("\n"); 
		query.append("	    		, MDM_DTL_REV_LANE   DRL" ).append("\n"); 
		query.append("	    		, MDM_REV_LANE       RL" ).append("\n"); 
		query.append("	    		, SPC_OFC_LVL        O" ).append("\n"); 
		query.append("	  	        , BKG_CUSTOMER       BC  --20140304 추가  " ).append("\n"); 
		query.append("	    	WHERE B.BKG_NO         = BV.BKG_NO" ).append("\n"); 
		query.append("	    	  AND B.BKG_NO         = R.BKG_NO" ).append("\n"); 
		query.append("	    	  AND B.BKG_STS_CD    IN ('W','F')" ).append("\n"); 
		query.append("	    	  AND B.BKG_CGO_TP_CD IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("	    	  AND M.VSL_CD         = BV.VSL_CD" ).append("\n"); 
		query.append("	    	  AND M.SKD_VOY_NO     = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("	    	  AND M.SKD_DIR_CD     = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	    	  AND RL.VSL_SLAN_CD   = BV.SLAN_CD" ).append("\n"); 
		query.append("	    	  AND O.OFC_CD = SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD)" ).append("\n"); 
		query.append("	    	  AND DRL.RLANE_CD        = M.RLANE_CD" ).append("\n"); 
		query.append("	    	  AND DRL.VSL_SLAN_DIR_CD = M.SKD_DIR_CD" ).append("\n"); 
		query.append("	    	  AND DRL.TRD_CD          = M.TRD_CD" ).append("\n"); 
		query.append("	    	  AND DRL.SUB_TRD_CD      = M.SUB_TRD_CD" ).append("\n"); 
		query.append("	    	  AND O.SPC_SLS_OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("	    	  AND DRL.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("	    	  AND DRL.RLANE_CD        = RL.RLANE_CD" ).append("\n"); 
		query.append("	    	  AND DRL.FM_CONTI_CD     = (SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, M.RLANE_CD, M.SKD_DIR_CD)" ).append("\n"); 
		query.append("	    								   FROM MDM_LOCATION L" ).append("\n"); 
		query.append("	    								  WHERE L.LOC_CD = BV.POL_CD )" ).append("\n"); 
		query.append("	    	  AND DRL.TO_CONTI_CD 	  = (SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, M.RLANE_CD, M.SKD_DIR_CD)" ).append("\n"); 
		query.append("	    								   FROM MDM_LOCATION L" ).append("\n"); 
		query.append("	    								  WHERE L.LOC_CD =  BV.POD_CD )" ).append("\n"); 
		query.append("	    	  AND RL.RLANE_CD  = M.RLANE_CD" ).append("\n"); 
		query.append("	    	  AND RL.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("	    	  AND RL.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("	    	  AND RL.RLANE_CD      <> 'RBCCO'" ).append("\n"); 
		query.append("	    	  AND B.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("	    	  AND DECODE(M.CUST_TP_CD, 'C', M.CUST_TP_CD, '1') = DECODE(M.CUST_TP_CD, 'C', 'C', '1')" ).append("\n"); 
		query.append("	    	  AND B.BKG_NO            = BC.BKG_NO  --20140304 추가" ).append("\n"); 
		query.append("              AND BC.BKG_CUST_TP_CD   = 'S'        --20140304 추가" ).append("\n"); 
		query.append("	    	  " ).append("\n"); 
		query.append("	    	  " ).append("\n"); 
		query.append("	    ) M" ).append("\n"); 
		query.append("	)    " ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("	  SELECT LEVEL AS IDX" ).append("\n"); 
		query.append("	    FROM DUAL" ).append("\n"); 
		query.append("	 CONNECT BY LEVEL <= 2" ).append("\n"); 
		query.append("	) LVL      " ).append("\n"); 
		query.append("	,PARAM     P" ).append("\n"); 
		query.append("	GROUP BY DECODE(CUST_TP_CD, 'S', SHPR_CNT_CD  , AGMT_CNT_CD  )," ).append("\n"); 
		query.append("	       DECODE(CUST_TP_CD, 'S', SHPR_CUST_SEQ, AGMT_CUST_SEQ)," ).append("\n"); 
		query.append("	       SLS_OFC_CD," ).append("\n"); 
		query.append("           SC_NO," ).append("\n"); 
		query.append("           RFA_NO," ).append("\n"); 
		query.append("	       LVL.IDX," ).append("\n"); 
		query.append("	       DECODE(LVL.IDX, 1, NVL(POL_YD_CD, POL_CD), 2, NVL(POD_YD_CD, POD_CD))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", SMP AS (" ).append("\n"); 
		query.append("    SELECT /*+INDEX_DESC (M XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("           T.TRD_CD," ).append("\n"); 
		query.append("           T.SUB_TRD_CD," ).append("\n"); 
		query.append("           T.RLANE_CD," ).append("\n"); 
		query.append("           DECODE(T.HH_FLG, 'Y', M.COST_YRWK||'-'||M.VER_SEQ, '200001-1') SEASON" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("             SELECT P.TRD_CD," ).append("\n"); 
		query.append("                    P.COST_YR," ).append("\n"); 
		query.append("                    P.COST_WK," ).append("\n"); 
		query.append("                    P.SUB_TRD_CD," ).append("\n"); 
		query.append("                    P.RLANE_CD," ).append("\n"); 
		query.append("                    DECODE(H.DIR_CD, NULL, 'N', 'Y') AS HH_FLG" ).append("\n"); 
		query.append("               FROM SPC_HD_HUL_MST H," ).append("\n"); 
		query.append("                    PARAM P" ).append("\n"); 
		query.append("              WHERE P.TRD_CD   = H.TRD_CD(+)" ).append("\n"); 
		query.append("                AND P.RLANE_CD = H.RLANE_CD(+)" ).append("\n"); 
		query.append("                AND P.SKD_DIR_CD   = H.DIR_CD(+)" ).append("\n"); 
		query.append("          ) T," ).append("\n"); 
		query.append("          SPC_MDL_VER_MST M" ).append("\n"); 
		query.append("     WHERE T.TRD_CD = M.TRD_CD" ).append("\n"); 
		query.append("       AND T.COST_YR||T.COST_WK BETWEEN M.VER_ST_YRWK AND M.VER_END_YRWK" ).append("\n"); 
		query.append("       AND M.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("       AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", WK_CMB AS (" ).append("\n"); 
		query.append("    SELECT T.RNUM," ).append("\n"); 
		query.append("           BAR.COST_YRWK," ).append("\n"); 
		query.append("           BAR.SLS_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("           BAR.TS_FLG," ).append("\n"); 
		query.append("           BAR.IOC_CD," ).append("\n"); 
		query.append("           BAR.POL_YD_CD," ).append("\n"); 
		query.append("           BAR.POD_YD_CD," ).append("\n"); 
		query.append("           BAR.CUST_CNT_CD," ).append("\n"); 
		query.append("           BAR.CUST_SEQ," ).append("\n"); 
		query.append("           SUM(BAR.BKG_REV) AS BKG_REV,NVL(SUM(BAR.DMDT_COM_AMT),0) AS DMDT_COM_AMT," ).append("\n"); 
		query.append("           SUM(BAR.ESTM_CM_COST_AMT) AS ESTM_CM_COST_AMT," ).append("\n"); 
		query.append("           SUM(BAR.BKG_TTL_QTY) AS BKG_TTL_QTY," ).append("\n"); 
		query.append("           SUM(BAR.USD_BKG_TTL_WGT) AS BKG_TTL_WGT" ).append("\n"); 
		query.append("     FROM SPC_BKG_AVG_REV   BAR," ).append("\n"); 
		query.append("          (SELECT DISTINCT DENSE_RANK() OVER (ORDER BY COST_YRWK) AS RNUM," ).append("\n"); 
		query.append("                  COST_YRWK" ).append("\n"); 
		query.append("             FROM SPC_BKG_AVG_REV" ).append("\n"); 
		query.append("          ) T," ).append("\n"); 
		query.append("          PARAM P  " ).append("\n"); 
		query.append("    WHERE BAR.COST_YRWK  = T.COST_YRWK" ).append("\n"); 
		query.append("      AND BAR.OFC_KND_CD = '4'" ).append("\n"); 
		query.append("      AND BAR.TRD_CD     = P.TRD_CD" ).append("\n"); 
		query.append("      AND BAR.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("      AND BAR.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND BAR.IOC_CD     = P.IOC_CD" ).append("\n"); 
		query.append("      AND BAR.SLS_OFC_CD = P.OFC_CD" ).append("\n"); 
		query.append("      --AND BAR.TRD_CD NOT IN ('IES', 'IMS')" ).append("\n"); 
		query.append("      AND CUST_CNT_CD    <> '00'" ).append("\n"); 
		query.append("      AND BAR.IOC_CD     = DECODE(P.IOC_CD, 'O', 'O', 'OT', 'O', 'I')" ).append("\n"); 
		query.append("      AND BAR.TS_FLG     = DECODE(P.IOC_CD, 'T', 'Y', 'TT', 'Y', 'N')" ).append("\n"); 
		query.append("      AND P.IOC_CD       <> 'E'" ).append("\n"); 
		query.append("    GROUP BY  T.RNUM," ).append("\n"); 
		query.append("              BAR.COST_YRWK," ).append("\n"); 
		query.append("              BAR.SLS_OFC_CD," ).append("\n"); 
		query.append("              BAR.TS_FLG," ).append("\n"); 
		query.append("              BAR.IOC_CD," ).append("\n"); 
		query.append("              BAR.POL_YD_CD," ).append("\n"); 
		query.append("              BAR.POD_YD_CD," ).append("\n"); 
		query.append("              BAR.CUST_CNT_CD," ).append("\n"); 
		query.append("              BAR.CUST_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ALL_DATA AS (" ).append("\n"); 
		query.append("    SELECT Z.FLG," ).append("\n"); 
		query.append("           Z.IDX," ).append("\n"); 
		query.append("           NVL(TRIM(Z.CUST_CNT_CD), 'XX') AS CUST_CNT_CD," ).append("\n"); 
		query.append("           NVL(Z.CUST_SEQ, '999999')      AS CUST_SEQ   ," ).append("\n"); 
		query.append("           Z.PORT_CD    ," ).append("\n"); 
		query.append("           Z.OFC_CD     ," ).append("\n"); 
		query.append("           Z.SC_NO      ," ).append("\n"); 
		query.append("           Z.RFA_NO     ," ).append("\n"); 
		query.append("           Z.FCT_TEU    ," ).append("\n"); 
		query.append("           Z.FCT_HC     ," ).append("\n"); 
		query.append("           Z.FCT_45     ," ).append("\n"); 
		query.append("           Z.FCT_53     ," ).append("\n"); 
		query.append("           Z.FCT_RF     ," ).append("\n"); 
		query.append("           Z.FCT_WGT    ," ).append("\n"); 
		query.append("           NULL FIRM_TEU," ).append("\n"); 
		query.append("           NULL FIRM_20 ," ).append("\n"); 
		query.append("           NULL FIRM_40 ," ).append("\n"); 
		query.append("           NULL FIRM_HC ," ).append("\n"); 
		query.append("           NULL FIRM_45 ," ).append("\n"); 
		query.append("           NULL FIRM_53 ," ).append("\n"); 
		query.append("           NULL FIRM_RF ," ).append("\n"); 
		query.append("           NULL FIRM_WGT," ).append("\n"); 
		query.append("           NULL WAIT_TEU," ).append("\n"); 
		query.append("           NULL WAIT_20 ," ).append("\n"); 
		query.append("           NULL WAIT_40 ," ).append("\n"); 
		query.append("           NULL WAIT_HC ," ).append("\n"); 
		query.append("           NULL WAIT_45 ," ).append("\n"); 
		query.append("           NULL WAIT_53 ," ).append("\n"); 
		query.append("           NULL WAIT_RF ," ).append("\n"); 
		query.append("           NULL WAIT_WGT, NULL BKG_VOL_VGM, NULL BKG_WGT_VGM" ).append("\n"); 
		query.append("      FROM FCT_DATA Z" ).append("\n"); 
		query.append("     WHERE IDX <= 50" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT Z.FLG," ).append("\n"); 
		query.append("           Z.IDX + 50 AS IDX," ).append("\n"); 
		query.append("           NVL(TRIM(Z.CUST_CNT_CD), 'XX') AS CUST_CNT_CD," ).append("\n"); 
		query.append("           DECODE(NVL(TRIM(Z.CUST_CNT_CD), 'XX'), 'XX',999999,Z.CUST_SEQ) AS CUST_SEQ," ).append("\n"); 
		query.append("           Z.PORT_CD   ," ).append("\n"); 
		query.append("           Z.OFC_CD    ," ).append("\n"); 
		query.append("           Z.SC_NO     ," ).append("\n"); 
		query.append("           Z.RFA_NO    ," ).append("\n"); 
		query.append("           NULL FCT_TEU," ).append("\n"); 
		query.append("           NULL FCT_HC ," ).append("\n"); 
		query.append("           NULL FCT_45 ," ).append("\n"); 
		query.append("           NULL FCT_53 ," ).append("\n"); 
		query.append("           NULL FCT_RF ," ).append("\n"); 
		query.append("           NULL FCT_WGT," ).append("\n"); 
		query.append("           Z.FIRM_TEU  ," ).append("\n"); 
		query.append("           Z.FIRM_20   ," ).append("\n"); 
		query.append("           Z.FIRM_40   ," ).append("\n"); 
		query.append("           Z.FIRM_HC   ," ).append("\n"); 
		query.append("           Z.FIRM_45   ," ).append("\n"); 
		query.append("           Z.FIRM_53   ," ).append("\n"); 
		query.append("           Z.FIRM_RF   ," ).append("\n"); 
		query.append("           Z.FIRM_WGT  ," ).append("\n"); 
		query.append("           Z.WAIT_TEU  ," ).append("\n"); 
		query.append("           Z.WAIT_20   ," ).append("\n"); 
		query.append("           Z.WAIT_40   ," ).append("\n"); 
		query.append("           Z.WAIT_HC   ," ).append("\n"); 
		query.append("           Z.WAIT_45   ," ).append("\n"); 
		query.append("           Z.WAIT_53   ," ).append("\n"); 
		query.append("           Z.WAIT_RF   ," ).append("\n"); 
		query.append("           Z.WAIT_WGT  ,BKG_VOL_VGM,BKG_WGT_VGM" ).append("\n"); 
		query.append("      FROM BKG_DATA Z" ).append("\n"); 
		query.append("     WHERE IDX <= 50" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT Z.FLG        ," ).append("\n"); 
		query.append("         Z.IDX AS ORD ," ).append("\n"); 
		query.append("         Z.CUST_CNT_CD," ).append("\n"); 
		query.append("         Z.CUST_SEQ   ," ).append("\n"); 
		query.append("         Z.CUST_CNT_CD||LTRIM(TO_CHAR(Z.CUST_SEQ, '000009')) AS CUST_CD," ).append("\n"); 
		query.append("         (SELECT NVL(CUST_ABBR_NM, CUST_LGL_ENG_NM)" ).append("\n"); 
		query.append("            FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("           WHERE CUST_CNT_CD = Z.CUST_CNT_CD" ).append("\n"); 
		query.append("             AND CUST_SEQ = Z.CUST_SEQ" ).append("\n"); 
		query.append("         ) AS CUST_NM," ).append("\n"); 
		query.append("         (SELECT RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("            FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("           WHERE CUST_CNT_CD = Z.CUST_CNT_CD " ).append("\n"); 
		query.append("             AND CUST_SEQ = Z.CUST_SEQ" ).append("\n"); 
		query.append("         ) AS RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("         Z.CUST_CTRL_CD," ).append("\n"); 
		query.append("         (SELECT SUM(RLANE_ADJ_QTY)" ).append("\n"); 
		query.append("            FROM SPC_MDL_CUST_REV_LANE R, SMP S" ).append("\n"); 
		query.append("           WHERE R.TRD_CD    = S.TRD_CD" ).append("\n"); 
		query.append("             AND R.COST_YRWK = SUBSTR(S.SEASON, 1, 6)" ).append("\n"); 
		query.append("             AND R.VER_SEQ   = SUBSTR(S.SEASON, 8)" ).append("\n"); 
		query.append("             AND R.SUB_TRD_CD = S.SUB_TRD_CD" ).append("\n"); 
		query.append("             AND R.RLANE_CD   = S.RLANE_CD" ).append("\n"); 
		query.append("             AND Z.OFC_CD = R.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("             AND R.CUST_CNT_CD = Z.CUST_CNT_CD" ).append("\n"); 
		query.append("             AND R.CUST_SEQ = Z.CUST_SEQ" ).append("\n"); 
		query.append("         ) AS SMP," ).append("\n"); 
		query.append("         -- 주차별 CMB" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("            SELECT ROUND((SUM(BAR.BKG_REV) + SUM(BAR.DMDT_COM_AMT) - SUM(BAR.ESTM_CM_COST_AMT)) / DECODE(SUM(BAR.BKG_TTL_QTY), 0, 1, SUM(BAR.BKG_TTL_QTY)))" ).append("\n"); 
		query.append("              FROM WK_CMB BAR" ).append("\n"); 
		query.append("             WHERE BAR.OFC_CD  = Z.OFC_CD" ).append("\n"); 
		query.append("               AND SUBSTR(Z.PORT_CD,1,5) = DECODE(Z.FLG, 'POL', BAR.POL_YD_CD, BAR.POD_YD_CD)" ).append("\n"); 
		query.append("               AND BAR.CUST_CNT_CD = Z.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND BAR.CUST_SEQ    = Z.CUST_SEQ" ).append("\n"); 
		query.append("               AND BAR.RNUM = 1" ).append("\n"); 
		query.append("         ) AS CMB1," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("            SELECT ROUND((SUM(BAR.BKG_REV) + SUM(BAR.DMDT_COM_AMT) - SUM(BAR.ESTM_CM_COST_AMT)) / DECODE(SUM(BAR.BKG_TTL_WGT), 0, 1, SUM(BAR.BKG_TTL_WGT)))" ).append("\n"); 
		query.append("              FROM WK_CMB BAR" ).append("\n"); 
		query.append("             WHERE BAR.OFC_CD  = Z.OFC_CD" ).append("\n"); 
		query.append("               AND SUBSTR(Z.PORT_CD,1,5) = DECODE(Z.FLG, 'POL', BAR.POL_YD_CD, BAR.POD_YD_CD)" ).append("\n"); 
		query.append("               AND BAR.CUST_CNT_CD = Z.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND BAR.CUST_SEQ    = Z.CUST_SEQ" ).append("\n"); 
		query.append("               AND BAR.RNUM = 1" ).append("\n"); 
		query.append("         ) AS CMB_WGT1," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("            SELECT ROUND((SUM(BAR.BKG_REV) + SUM(BAR.DMDT_COM_AMT) - SUM(BAR.ESTM_CM_COST_AMT)) / DECODE(SUM(BAR.BKG_TTL_QTY), 0, 1, SUM(BAR.BKG_TTL_QTY)))" ).append("\n"); 
		query.append("              FROM WK_CMB BAR" ).append("\n"); 
		query.append("             WHERE BAR.OFC_CD  = Z.OFC_CD" ).append("\n"); 
		query.append("               AND SUBSTR(Z.PORT_CD,1,5) = DECODE(Z.FLG, 'POL', BAR.POL_YD_CD, BAR.POD_YD_CD)" ).append("\n"); 
		query.append("               AND BAR.CUST_CNT_CD = Z.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND BAR.CUST_SEQ    = Z.CUST_SEQ" ).append("\n"); 
		query.append("               AND BAR.RNUM = 2" ).append("\n"); 
		query.append("         ) AS CMB2," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("            SELECT ROUND((SUM(BAR.BKG_REV) + SUM(BAR.DMDT_COM_AMT) - SUM(BAR.ESTM_CM_COST_AMT)) / DECODE(SUM(BAR.BKG_TTL_WGT), 0, 1, SUM(BAR.BKG_TTL_WGT)))" ).append("\n"); 
		query.append("              FROM WK_CMB BAR" ).append("\n"); 
		query.append("             WHERE BAR.OFC_CD  = Z.OFC_CD" ).append("\n"); 
		query.append("               AND SUBSTR(Z.PORT_CD,1,5) = DECODE(Z.FLG, 'POL', BAR.POL_YD_CD, BAR.POD_YD_CD)" ).append("\n"); 
		query.append("               AND BAR.CUST_CNT_CD = Z.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND BAR.CUST_SEQ    = Z.CUST_SEQ" ).append("\n"); 
		query.append("               AND BAR.RNUM = 2" ).append("\n"); 
		query.append("         ) AS CMB_WGT2," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("            SELECT ROUND((SUM(BAR.BKG_REV) + SUM(BAR.DMDT_COM_AMT) - SUM(BAR.ESTM_CM_COST_AMT)) / DECODE(SUM(BAR.BKG_TTL_QTY), 0, 1, SUM(BAR.BKG_TTL_QTY)))" ).append("\n"); 
		query.append("              FROM WK_CMB BAR" ).append("\n"); 
		query.append("             WHERE BAR.OFC_CD  = Z.OFC_CD" ).append("\n"); 
		query.append("               AND SUBSTR(Z.PORT_CD,1,5) = DECODE(Z.FLG, 'POL', BAR.POL_YD_CD, BAR.POD_YD_CD)" ).append("\n"); 
		query.append("               AND BAR.CUST_CNT_CD = Z.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND BAR.CUST_SEQ    = Z.CUST_SEQ" ).append("\n"); 
		query.append("               AND BAR.RNUM = 3" ).append("\n"); 
		query.append("         ) AS CMB3," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("            SELECT ROUND((SUM(BAR.BKG_REV) + SUM(BAR.DMDT_COM_AMT) - SUM(BAR.ESTM_CM_COST_AMT)) / DECODE(SUM(BAR.BKG_TTL_WGT), 0, 1, SUM(BAR.BKG_TTL_WGT)))" ).append("\n"); 
		query.append("              FROM WK_CMB BAR" ).append("\n"); 
		query.append("             WHERE BAR.OFC_CD  = Z.OFC_CD" ).append("\n"); 
		query.append("               AND SUBSTR(Z.PORT_CD,1,5) = DECODE(Z.FLG, 'POL', BAR.POL_YD_CD, BAR.POD_YD_CD)" ).append("\n"); 
		query.append("               AND BAR.CUST_CNT_CD = Z.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND BAR.CUST_SEQ    = Z.CUST_SEQ" ).append("\n"); 
		query.append("               AND BAR.RNUM = 3" ).append("\n"); 
		query.append("         ) AS CMB_WGT3," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("            SELECT ROUND((SUM(BAR.BKG_REV) + SUM(BAR.DMDT_COM_AMT) - SUM(BAR.ESTM_CM_COST_AMT)) / DECODE(SUM(BAR.BKG_TTL_QTY), 0, 1, SUM(BAR.BKG_TTL_QTY)))" ).append("\n"); 
		query.append("              FROM WK_CMB BAR" ).append("\n"); 
		query.append("             WHERE BAR.OFC_CD  = Z.OFC_CD" ).append("\n"); 
		query.append("               AND SUBSTR(Z.PORT_CD,1,5) = DECODE(Z.FLG, 'POL', BAR.POL_YD_CD, BAR.POD_YD_CD)" ).append("\n"); 
		query.append("               AND BAR.CUST_CNT_CD = Z.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND BAR.CUST_SEQ    = Z.CUST_SEQ" ).append("\n"); 
		query.append("               AND BAR.RNUM = 4" ).append("\n"); 
		query.append("         ) AS CMB4," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("            SELECT ROUND((SUM(BAR.BKG_REV) + SUM(BAR.DMDT_COM_AMT) - SUM(BAR.ESTM_CM_COST_AMT)) / DECODE(SUM(BAR.BKG_TTL_WGT), 0, 1, SUM(BAR.BKG_TTL_WGT)))" ).append("\n"); 
		query.append("              FROM WK_CMB BAR" ).append("\n"); 
		query.append("             WHERE BAR.OFC_CD  = Z.OFC_CD" ).append("\n"); 
		query.append("               AND SUBSTR(Z.PORT_CD,1,5) = DECODE(Z.FLG, 'POL', BAR.POL_YD_CD, BAR.POD_YD_CD)" ).append("\n"); 
		query.append("               AND BAR.CUST_CNT_CD = Z.CUST_CNT_CD" ).append("\n"); 
		query.append("               AND BAR.CUST_SEQ    = Z.CUST_SEQ" ).append("\n"); 
		query.append("               AND BAR.RNUM = 4" ).append("\n"); 
		query.append("         ) AS CMB_WGT4," ).append("\n"); 
		query.append("         Z.PORT_CD ," ).append("\n"); 
		query.append("         Z.OFC_CD  ," ).append("\n"); 
		query.append("         NVL(Z.FCT_TEU, 0) + NVL(Z.FCT_HC, 0) * 2 + NVL(Z.FCT_45, 0) * 2 + NVL(Z.FCT_53, 0) * 2 AS FC_TTL_TEU," ).append("\n"); 
		query.append("         Z.FCT_TEU ," ).append("\n"); 
		query.append("         Z.FCT_HC  ," ).append("\n"); 
		query.append("         Z.FCT_45  ," ).append("\n"); 
		query.append("         Z.FCT_53  ," ).append("\n"); 
		query.append("         Z.FCT_RF  ," ).append("\n"); 
		query.append("         Z.FCT_WGT ," ).append("\n"); 
		query.append("         Z.FIRM_TEU," ).append("\n"); 
		query.append("         Z.FIRM_20 ," ).append("\n"); 
		query.append("         Z.FIRM_40 ," ).append("\n"); 
		query.append("         Z.FIRM_HC ," ).append("\n"); 
		query.append("         Z.FIRM_45 ," ).append("\n"); 
		query.append("         Z.FIRM_53 ," ).append("\n"); 
		query.append("         Z.FIRM_RF ," ).append("\n"); 
		query.append("         Z.FIRM_WGT," ).append("\n"); 
		query.append("         Z.WAIT_TEU," ).append("\n"); 
		query.append("         Z.WAIT_20 ," ).append("\n"); 
		query.append("         Z.WAIT_40 ," ).append("\n"); 
		query.append("         Z.WAIT_HC ," ).append("\n"); 
		query.append("         Z.WAIT_45 ," ).append("\n"); 
		query.append("         Z.WAIT_53 ," ).append("\n"); 
		query.append("         Z.WAIT_RF ," ).append("\n"); 
		query.append("         Z.WAIT_WGT,NVL(BKG_VOL_VGM,0) AS BKG_VOL_VGM,NVL(BKG_WGT_VGM,0) AS BKG_WGT_VGM" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT ROW_NUMBER() OVER ( PARTITION BY Z.FLG ORDER BY MIN(Z.IDX)) AS IDX," ).append("\n"); 
		query.append("                   MIN(Z.IDX) AS IDX2," ).append("\n"); 
		query.append("                   Z.FLG        ," ).append("\n"); 
		query.append("                   Z.CUST_CNT_CD," ).append("\n"); 
		query.append("                   Z.CUST_SEQ   ," ).append("\n"); 
		query.append("                   NVL(T.CUST_CTRL_CD,'C') CUST_CTRL_CD," ).append("\n"); 
		query.append("                   Z.PORT_CD    ," ).append("\n"); 
		query.append("                   Z.OFC_CD     ," ).append("\n"); 
		query.append("                   SUM(Z.FCT_TEU)  AS FCT_TEU ," ).append("\n"); 
		query.append("                   SUM(Z.FCT_HC)   AS FCT_HC  ," ).append("\n"); 
		query.append("                   SUM(Z.FCT_45)   AS FCT_45  ," ).append("\n"); 
		query.append("                   SUM(Z.FCT_53)   AS FCT_53  ," ).append("\n"); 
		query.append("                   SUM(Z.FCT_RF)   AS FCT_RF  ," ).append("\n"); 
		query.append("                   SUM(Z.FCT_WGT)  AS FCT_WGT ," ).append("\n"); 
		query.append("                   SUM(Z.FIRM_TEU) AS FIRM_TEU," ).append("\n"); 
		query.append("                   SUM(Z.FIRM_20)  AS FIRM_20 ," ).append("\n"); 
		query.append("                   SUM(Z.FIRM_40)  AS FIRM_40 ," ).append("\n"); 
		query.append("                   SUM(Z.FIRM_HC)  AS FIRM_HC ," ).append("\n"); 
		query.append("                   SUM(Z.FIRM_45)  AS FIRM_45 ," ).append("\n"); 
		query.append("                   SUM(Z.FIRM_53)  AS FIRM_53 ,                   " ).append("\n"); 
		query.append("                   SUM(Z.FIRM_RF)  AS FIRM_RF ," ).append("\n"); 
		query.append("                   SUM(Z.FIRM_WGT) AS FIRM_WGT," ).append("\n"); 
		query.append("                   SUM(Z.WAIT_TEU) AS WAIT_TEU," ).append("\n"); 
		query.append("                   SUM(Z.WAIT_20)  AS WAIT_20 ," ).append("\n"); 
		query.append("                   SUM(Z.WAIT_40)  AS WAIT_40 ," ).append("\n"); 
		query.append("                   SUM(Z.WAIT_HC)  AS WAIT_HC ," ).append("\n"); 
		query.append("                   SUM(Z.WAIT_45)  AS WAIT_45 ," ).append("\n"); 
		query.append("                   SUM(Z.WAIT_53)  AS WAIT_53 ," ).append("\n"); 
		query.append("                   SUM(Z.WAIT_RF)  AS WAIT_RF ," ).append("\n"); 
		query.append("                   SUM(Z.WAIT_WGT) AS WAIT_WGT," ).append("\n"); 
		query.append("				   SUM(Z.BKG_VOL_VGM) AS BKG_VOL_VGM,   " ).append("\n"); 
		query.append("                   SUM(Z.BKG_WGT_VGM) AS BKG_WGT_VGM                " ).append("\n"); 
		query.append("              FROM ALL_DATA Z," ).append("\n"); 
		query.append("                   (SELECT DISTINCT --20130424 추가" ).append("\n"); 
		query.append("                           C.CUST_CNT_CD," ).append("\n"); 
		query.append("                           C.CUST_SEQ," ).append("\n"); 
		query.append("                           C.CUST_CTRL_CD," ).append("\n"); 
		query.append("                           C.SC_NO," ).append("\n"); 
		query.append("                           C.RFA_NO" ).append("\n"); 
		query.append("                      FROM SPC_MDL_CUST_CTRL C, SMP S" ).append("\n"); 
		query.append("                     WHERE C.TRD_CD    = S.TRD_CD" ).append("\n"); 
		query.append("                       AND C.COST_YRWK = SUBSTR(S.SEASON,1,6)" ).append("\n"); 
		query.append("                       AND C.VER_SEQ   = SUBSTR(S.SEASON,8)" ).append("\n"); 
		query.append("                   ) T" ).append("\n"); 
		query.append("             WHERE Z.CUST_CNT_CD = NVL(T.CUST_CNT_CD(+), DECODE(SUBSTR(NVL(Z.RFA_NO,' '),1,1),'1', Z.CUST_CNT_CD,T.CUST_CNT_CD(+)))" ).append("\n"); 
		query.append("               AND Z.CUST_SEQ    = NVL(T.CUST_SEQ(+),    DECODE(SUBSTR(NVL(Z.RFA_NO,' '),1,1),'1', Z.CUST_SEQ,   T.CUST_SEQ(+)))" ).append("\n"); 
		query.append("               AND NVL(Z.SC_NO, DECODE(SUBSTR(NVL(Z.RFA_NO,' '),1,1),'1',SUBSTR(Z.RFA_NO,2),NVL(Z.RFA_NO,' '))) = NVL(T.SC_NO(+), NVL(T.RFA_NO(+),' '))" ).append("\n"); 
		query.append("             --WHERE Z.CUST_CNT_CD = DECODE(--[trade], 'AES', DECODE(SUBSTR(NVL(Z.RFA_NO,' '),1,1),'1', Z.CUST_CNT_CD,T.CUST_CNT_CD(+)),T.CUST_CNT_CD(+))" ).append("\n"); 
		query.append("             --  AND Z.CUST_SEQ    = DECODE(--[trade], 'AES', DECODE(SUBSTR(NVL(Z.RFA_NO,' '),1,1),'1', Z.CUST_SEQ,   T.CUST_SEQ(+)),T.CUST_SEQ(+))" ).append("\n"); 
		query.append("             --  AND DECODE(--[trade], 'AES', DECODE(SUBSTR(NVL(Z.RFA_NO,' '),1,1),'1',SUBSTR(Z.RFA_NO,2),NVL(Z.RFA_NO,' ')), NVL(Z.SC_NO,' ')) = DECODE(--[trade], 'AES', NVL(T.RFA_NO(+),' '), NVL(T.SC_NO(+),' '))" ).append("\n"); 
		query.append("          GROUP BY Z.FLG        ," ).append("\n"); 
		query.append("                   Z.CUST_CNT_CD," ).append("\n"); 
		query.append("                   Z.CUST_SEQ   ," ).append("\n"); 
		query.append("                   NVL(T.CUST_CTRL_CD,'C')," ).append("\n"); 
		query.append("                   Z.PORT_CD    ," ).append("\n"); 
		query.append("                   Z.OFC_CD" ).append("\n"); 
		query.append("          ORDER BY Z.FLG," ).append("\n"); 
		query.append("                   IDX" ).append("\n"); 
		query.append("         ) Z" ).append("\n"); 
		query.append("ORDER BY FLG    ," ).append("\n"); 
		query.append("         IDX    ," ).append("\n"); 
		query.append("         CUST_CD," ).append("\n"); 
		query.append("         CUST_NM," ).append("\n"); 
		query.append("         PORT_CD," ).append("\n"); 
		query.append("         OFC_CD" ).append("\n"); 

	}
}