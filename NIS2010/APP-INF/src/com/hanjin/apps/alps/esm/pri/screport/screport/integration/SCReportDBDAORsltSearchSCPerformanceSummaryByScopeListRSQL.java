/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCPerformanceSummaryByScopeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2015.08.20 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchSCPerformanceSummaryByScopeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s/c performance summary
	  * 2013.01.24 전윤주 [CHM-201322665] 1st VVD 확인 로직에서 FDR 제외
	  * </pre>
	  */
	public SCReportDBDAORsltSearchSCPerformanceSummaryByScopeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gamt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_cust_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("key_acct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_obrd_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_obrd_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchSCPerformanceSummaryByScopeListRSQL").append("\n"); 
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
		query.append("SELECT  RHQ_CD                ," ).append("\n"); 
		query.append("        PROP_APRO_OFC_CD      ," ).append("\n"); 
		query.append("        CTRT_CUST_SLS_OFC_CD  ," ).append("\n"); 
		query.append("        KEY_ACCT_FLG          ," ).append("\n"); 
		query.append("        SC_NO                 ," ).append("\n"); 
		query.append("        CTRT_PTY_NM           ," ).append("\n"); 
		query.append("        CTRT_CUST_SREP_CD     ," ).append("\n"); 
		query.append("        PRC_CTRT_CUST_TP_CD   , " ).append("\n"); 
		query.append("        SVC_SCP_CD            ," ).append("\n"); 
		query.append("        FNL_MQC_QTY           ," ).append("\n"); 
		query.append("        TO_CHAR(CTRT_EFF_DT,'YYYY-MM-DD') CTRT_EFF_DT , " ).append("\n"); 
		query.append("        TO_CHAR(CTRT_EXP_DT,'YYYY-MM-DD') CTRT_EXP_DT ," ).append("\n"); 
		query.append("        OP_CNTR_QTY           ," ).append("\n"); 
		query.append("        DECODE(FNL_MQC_QTY, 0, 0, OP_CNTR_QTY * 100 / FNL_MQC_QTY)  MQC_PERF    ," ).append("\n"); 
		query.append("        DECODE(FNL_MQC_QTY, 0, 0, OP_CNTR_QTY * 100 / ( FNL_MQC_QTY * FLOOR(LEAST(SYSDATE, CTRT_EXP_DT) - CTRT_EFF_DT + 1) / FLOOR(CTRT_EXP_DT - CTRT_EFF_DT + 1) ) )    PRO_RT_MQC_PERF" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  SC.*    ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  --SUM( BQ.OP_CNTR_QTY * ( SELECT PRI_SC_FEU_CONV(BK.SVC_SCP_CD, BQ.CNTR_TPSZ_CD) FROM DUAL) ) bl view detail 쿼리와 동일하게 맞춤" ).append("\n"); 
		query.append("                        SUM(TRIM(TO_CHAR(BQ.OP_CNTR_QTY * PRI_SC_FEU_CONV(BK.SVC_SCP_CD, BQ.CNTR_TPSZ_CD), '999,999,999,999,990.999')))" ).append("\n"); 
		query.append("                FROM    BKG_BOOKING       BK  ," ).append("\n"); 
		query.append("                        BKG_QUANTITY      BQ  ," ).append("\n"); 
		query.append("                        BKG_VVD           BV  ," ).append("\n"); 
		query.append("                        VSK_VSL_PORT_SKD  PS" ).append("\n"); 
		query.append("                WHERE   BQ.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("                AND     BV.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("                AND     NOT EXISTS  (" ).append("\n"); 
		query.append("                                    SELECT  'X'" ).append("\n"); 
		query.append("                                    FROM    BKG_VVD A" ).append("\n"); 
		query.append("                                    WHERE   A.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("                                    AND     A.VSL_CD IS NOT NULL --FDR 중에 VVD 명이 들어오지 않는 경우 제외" ).append("\n"); 
		query.append("                                    AND     A.VSL_PRE_PST_CD||A.VSL_SEQ < BV.VSL_PRE_PST_CD||BV.VSL_SEQ" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                AND     PS.VSL_CD       = BV.VSL_CD" ).append("\n"); 
		query.append("                AND     PS.SKD_VOY_NO   = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     PS.SKD_DIR_CD   = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     PS.VPS_PORT_CD  = BV.POL_CD" ).append("\n"); 
		query.append("                AND     PS.CLPT_IND_SEQ = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                AND     BK.SC_NO        = SC.SC_NO" ).append("\n"); 
		query.append("                AND     BK.BKG_STS_CD   = 'F'" ).append("\n"); 
		query.append("                AND     BK.SVC_SCP_CD   = DECODE(SC.SVC_SCP_CNT, 1, BK.SVC_SCP_CD, SC.SVC_SCP_CD)" ).append("\n"); 
		query.append("                AND     PS.VPS_ETD_DT   <= TO_DATE(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, BK.POL_CD))" ).append("\n"); 
		query.append("                #if (${bl_obrd_dt_from} != '')" ).append("\n"); 
		query.append("                AND     PS.VPS_ETD_DT   >= TO_DATE(@[bl_obrd_dt_from], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${bl_obrd_dt_to} != '')" ).append("\n"); 
		query.append("                AND     PS.VPS_ETD_DT   <= TO_DATE (@[bl_obrd_dt_to], 'YYYY-MM-DD') + 0.99999 /* 0.99999 는 23시 59분 59초를 의미 */  -- Period" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                AND     BQ.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                )   OP_CNTR_QTY" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  SH.SC_NO      ," ).append("\n"); 
		query.append("                        SM.AMDT_SEQ   ," ).append("\n"); 
		query.append("                        SS.SVC_SCP_CD ," ).append("\n"); 
		query.append("                        ( SELECT A.OFC_CD FROM MDM_ORGANIZATION A WHERE A.OFC_TP_CD = 'HQ' AND A.DELT_FLG = 'N' START WITH A.OFC_CD = SM.RESPB_SLS_OFC_CD CONNECT BY PRIOR A.PRNT_OFC_CD = A.OFC_CD ) RHQ_CD ," ).append("\n"); 
		query.append("                        SM.PROP_APRO_OFC_CD     , -- 추가" ).append("\n"); 
		query.append("                        SM.PROP_OFC_CD     CTRT_CUST_SLS_OFC_CD  ," ).append("\n"); 
		query.append("                        ( SELECT A.KEY_ACCT_FLG FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = NVL2(SM.REAL_CUST_CNT_CD, SM.REAL_CUST_CNT_CD, CP.CUST_CNT_CD) AND A.CUST_SEQ = NVL2(SM.REAL_CUST_CNT_CD, SM.REAL_CUST_SEQ, CP.CUST_SEQ) AND CNTR_DIV_FLG = 'Y' ) KEY_ACCT_FLG    ," ).append("\n"); 
		query.append("                        NVL2(SM.REAL_CUST_CNT_CD, (SELECT A.CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = SM.REAL_CUST_CNT_CD AND A.CUST_SEQ = SM.REAL_CUST_SEQ), CP.CTRT_PTY_NM) CTRT_PTY_NM ," ).append("\n"); 
		query.append("                        SM.RESPB_SREP_CD        CTRT_CUST_SREP_CD     ," ).append("\n"); 
		query.append("                        NVL2(SM.REAL_CUST_CNT_CD, SM.REAL_CUST_TP_CD, CT.PRC_CTRT_CUST_TP_CD) PRC_CTRT_CUST_TP_CD ," ).append("\n"); 
		query.append("                        DECODE(SQ.CNTR_LOD_UT_CD, 'T', SQ.FNL_MQC_QTY / 2, SQ.FNL_MQC_QTY)    FNL_MQC_QTY         ," ).append("\n"); 
		query.append("                        SD.CTRT_EFF_DT          ," ).append("\n"); 
		query.append("                        SD.CTRT_EXP_DT          ," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER ( PARTITION BY SH.SC_NO, SS.SVC_SCP_CD ORDER BY SM.AMDT_SEQ DESC ) ROW_NUMBER ," ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        SELECT  COUNT(DISTINCT A.SVC_SCP_CD)" ).append("\n"); 
		query.append("                        FROM    PRI_SP_SCP_MN A" ).append("\n"); 
		query.append("                        WHERE   A.PROP_NO   = SM.PROP_NO" ).append("\n"); 
		query.append("                        AND     A.AMDT_SEQ  = SM.AMDT_SEQ" ).append("\n"); 
		query.append("                        ) SVC_SCP_CNT" ).append("\n"); 
		query.append("                FROM    PRI_SP_HDR          SH  ," ).append("\n"); 
		query.append("                        PRI_SP_MN           SM  ," ).append("\n"); 
		query.append("                        PRI_SP_CTRT_PTY     CP  ," ).append("\n"); 
		query.append("                        PRI_SP_CTRT_CUST_TP CT  ," ).append("\n"); 
		query.append("                        PRI_SP_SCP_MN       SS  ," ).append("\n"); 
		query.append("                        PRI_SP_SCP_DUR      SD  ," ).append("\n"); 
		query.append("                        PRI_SP_SCP_MQC      SQ" ).append("\n"); 
		query.append("                WHERE   SM.PROP_NO            = SH.PROP_NO" ).append("\n"); 
		query.append("                AND     SM.PROP_STS_CD        = 'F'" ).append("\n"); 
		query.append("                AND     CP.PROP_NO            = SM.PROP_NO" ).append("\n"); 
		query.append("                AND     CP.AMDT_SEQ           = SM.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     CP.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("                AND     CT.PROP_NO            = CP.PROP_NO" ).append("\n"); 
		query.append("                AND     CT.AMDT_SEQ           = CP.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     CT.PRC_CTRT_PTY_TP_CD = CP.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("                AND     SS.PROP_NO            = SM.PROP_NO" ).append("\n"); 
		query.append("                AND     SS.AMDT_SEQ           = SM.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     SD.PROP_NO            = SS.PROP_NO" ).append("\n"); 
		query.append("                AND     SD.AMDT_SEQ           = SS.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     SD.SVC_SCP_CD         = SS.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND     SQ.PROP_NO            = SS.PROP_NO" ).append("\n"); 
		query.append("                AND     SQ.AMDT_SEQ           = SS.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     SQ.SVC_SCP_CD         = SS.SVC_SCP_CD" ).append("\n"); 
		query.append("                /* 조회 조건 */" ).append("\n"); 
		query.append("                #if (${sc_no} != '')" ).append("\n"); 
		query.append("                AND     SH.SC_NO LIKE @[sc_no] || '%'         -- S/C No" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${rf_flg} != '')" ).append("\n"); 
		query.append("                AND     SM.RF_FLG = @[rf_flg]               -- S/C Type" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${gamt_flg} != '')" ).append("\n"); 
		query.append("                AND     SM.GAMT_FLG = @[gamt_flg]               -- S/C Type" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${prc_ctrt_cust_tp_cd} != '')" ).append("\n"); 
		query.append("                AND     NVL2(SM.REAL_CUST_CNT_CD, SM.REAL_CUST_TP_CD, CT.PRC_CTRT_CUST_TP_CD) = @[prc_ctrt_cust_tp_cd]     -- Customer Type" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${rhq} != '')" ).append("\n"); 
		query.append("                AND     ( SELECT A.OFC_CD FROM MDM_ORGANIZATION A WHERE A.OFC_TP_CD = 'HQ' AND A.DELT_FLG = 'N' START WITH A.OFC_CD = SM.RESPB_SLS_OFC_CD CONNECT BY PRIOR A.PRNT_OFC_CD = A.OFC_CD ) = @[rhq]  -- RHQ" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${prop_apro_ofc_cd} != '')" ).append("\n"); 
		query.append("                AND     SM.PROP_APRO_OFC_CD   = @[prop_apro_ofc_cd]        -- Approval Office 추가" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${ctrt_cust_sls_ofc_cd} != '')" ).append("\n"); 
		query.append("                AND     SM.RESPB_SLS_OFC_CD   = @[ctrt_cust_sls_ofc_cd]    -- Contract Office" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${exp_dt} != '')" ).append("\n"); 
		query.append("                AND     SS.EFF_DT <= TO_DATE(@[exp_dt], 'YYYY-MM-DD')      -- S/C Effective Date (To)" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${eff_dt} != '')" ).append("\n"); 
		query.append("                AND     SS.EXP_DT >= TO_DATE(@[eff_dt], 'YYYY-MM-DD')      -- S/C Effective Date (From)" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("                AND    SS.SVC_SCP_CD    = @[svc_scp_cd] -- SVC Scope" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                ) SC" ).append("\n"); 
		query.append("        WHERE   ROW_NUMBER  = 1" ).append("\n"); 
		query.append("          #if (${key_acct_flg} != '') " ).append("\n"); 
		query.append("          AND KEY_ACCT_FLG = @[key_acct_flg]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        RHQ_CD               ," ).append("\n"); 
		query.append("        CTRT_CUST_SLS_OFC_CD ," ).append("\n"); 
		query.append("        KEY_ACCT_FLG         ," ).append("\n"); 
		query.append("        SC_NO                ," ).append("\n"); 
		query.append("        SVC_SCP_CD" ).append("\n"); 

	}
}