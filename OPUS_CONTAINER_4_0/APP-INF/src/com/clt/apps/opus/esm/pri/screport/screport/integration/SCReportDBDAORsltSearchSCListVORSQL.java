/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchSCListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/C List Inquiry
	  * </pre>
	  */
	public SCReportDBDAORsltSearchSCListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rf_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchSCListVORSQL").append("\n"); 
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
		query.append("SELECT  SC_NO                 ," ).append("\n"); 
		query.append("        PROP_NO               ," ).append("\n"); 
		query.append("        AMDT_SEQ              ," ).append("\n"); 
		query.append("        SVC_SCP_CD            ," ).append("\n"); 
		query.append("        CTRT_PTY_NM           ," ).append("\n"); 
		query.append("        PRC_CTRT_CUST_TP_CD   ," ).append("\n"); 
		query.append("        FNL_MQC_QTY           ," ).append("\n"); 
		query.append("        PROP_APRO_OFC_CD      ," ).append("\n"); 
		query.append("        CTRT_CUST_SLS_OFC_CD  ," ).append("\n"); 
		query.append("        CTRT_CUST_SREP_CD     ," ).append("\n"); 
		query.append("        TO_CHAR(CTRT_EFF_DT, 'YYYY-MM-DD')    CTRT_EFF_DT ," ).append("\n"); 
		query.append("        TO_CHAR(CTRT_EXP_DT, 'YYYY-MM-DD')    CTRT_EXP_DT ," ).append("\n"); 
		query.append("        TO_CHAR(FILE_DT, 'YYYY-MM-DD')        FILE_DT     ," ).append("\n"); 
		query.append("        '' AS RF_FLG          , -- param" ).append("\n"); 
		query.append("        '' AS GAMT_FLG        , -- param" ).append("\n"); 
		query.append("        '' AS EFF_DT          , -- param" ).append("\n"); 
		query.append("        '' AS EXP_DT            -- param" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  SH.SC_NO      ," ).append("\n"); 
		query.append("                SH.PROP_NO    ," ).append("\n"); 
		query.append("                SM.AMDT_SEQ   ," ).append("\n"); 
		query.append("                SS.SVC_SCP_CD ," ).append("\n"); 
		query.append("                NVL2(SM.REAL_CUST_CNT_CD, (SELECT A.CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = SM.REAL_CUST_CNT_CD AND A.CUST_SEQ = SM.REAL_CUST_SEQ), CP.CTRT_PTY_NM) CTRT_PTY_NM ," ).append("\n"); 
		query.append("                NVL2(SM.REAL_CUST_CNT_CD, SM.REAL_CUST_TP_CD, CT.PRC_CTRT_CUST_TP_CD) PRC_CTRT_CUST_TP_CD ," ).append("\n"); 
		query.append("                DECODE(SQ.CNTR_LOD_UT_CD, 'T', SQ.FNL_MQC_QTY / 2, SQ.FNL_MQC_QTY)    FNL_MQC_QTY         ," ).append("\n"); 
		query.append("                SM.PROP_APRO_OFC_CD     ," ).append("\n"); 
		query.append("                SM.RESPB_SLS_OFC_CD     CTRT_CUST_SLS_OFC_CD  ," ).append("\n"); 
		query.append("                SM.RESPB_SREP_CD        CTRT_CUST_SREP_CD     ," ).append("\n"); 
		query.append("                SD.CTRT_EFF_DT          ," ).append("\n"); 
		query.append("                SD.CTRT_EXP_DT          ," ).append("\n"); 
		query.append("                SM.FILE_DT              ," ).append("\n"); 
		query.append("                ROW_NUMBER() OVER ( PARTITION BY SH.SC_NO, SS.SVC_SCP_CD ORDER BY SM.AMDT_SEQ DESC ) ROW_NUMBER" ).append("\n"); 
		query.append("        FROM    PRI_SP_HDR          SH  ," ).append("\n"); 
		query.append("                PRI_SP_MN           SM  ," ).append("\n"); 
		query.append("                PRI_SP_CTRT_PTY     CP  ," ).append("\n"); 
		query.append("                PRI_SP_CTRT_CUST_TP CT  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_MN       SS  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_DUR      SD  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_MQC      SQ" ).append("\n"); 
		query.append("        WHERE   SM.PROP_NO            = SH.PROP_NO" ).append("\n"); 
		query.append("        AND     SM.PROP_STS_CD        = 'F'" ).append("\n"); 
		query.append("        AND     CP.PROP_NO            = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     CP.AMDT_SEQ           = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     CP.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("        AND     CT.PROP_NO            = CP.PROP_NO" ).append("\n"); 
		query.append("        AND     CT.AMDT_SEQ           = CP.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     CT.PRC_CTRT_PTY_TP_CD = CP.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("        AND     SS.PROP_NO            = SM.PROP_NO" ).append("\n"); 
		query.append("        AND     SS.AMDT_SEQ           = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SD.PROP_NO            = SS.PROP_NO" ).append("\n"); 
		query.append("        AND     SD.AMDT_SEQ           = SS.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SD.SVC_SCP_CD         = SS.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     SQ.PROP_NO            = SS.PROP_NO" ).append("\n"); 
		query.append("        AND     SQ.AMDT_SEQ           = SS.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SQ.SVC_SCP_CD         = SS.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     SS.EFF_DT <= TO_DATE(@[exp_dt], 'YYYY-MM-DD')      -- S/C Effective Date (To)" ).append("\n"); 
		query.append("        AND     SS.EXP_DT >= TO_DATE(@[eff_dt], 'YYYY-MM-DD')      -- S/C Effective Date (From)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        /* 조회 조건 */" ).append("\n"); 
		query.append("        #if (${sc_no} != '')" ).append("\n"); 
		query.append("        AND     SH.SC_NO LIKE @[sc_no] || '%'         -- S/C No" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${rf_flg} != '')" ).append("\n"); 
		query.append("        AND     SM.RF_FLG = @[rf_flg]               -- S/C Type" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${gamt_flg} != '')" ).append("\n"); 
		query.append("        AND     SM.GAMT_FLG = @[gamt_flg]               -- S/C Type" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${prc_ctrt_cust_tp_cd} != '')" ).append("\n"); 
		query.append("        AND     NVL2(SM.REAL_CUST_CNT_CD, SM.REAL_CUST_TP_CD, CT.PRC_CTRT_CUST_TP_CD) = @[prc_ctrt_cust_tp_cd]     -- Customer Type" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${prop_apro_ofc_cd} != '')" ).append("\n"); 
		query.append("        AND     SM.PROP_APRO_OFC_CD   = @[prop_apro_ofc_cd]        -- Approval Office 추가" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${ctrt_cust_sls_ofc_cd} != '')" ).append("\n"); 
		query.append("        AND     SM.RESPB_SLS_OFC_CD   = @[ctrt_cust_sls_ofc_cd]    -- Contract Office" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("        AND    SS.SVC_SCP_CD    = @[svc_scp_cd] -- SVC Scope" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   ROW_NUMBER    = 1" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        SC_NO       ," ).append("\n"); 
		query.append("        AMDT_SEQ    ," ).append("\n"); 
		query.append("        SVC_SCP_CD" ).append("\n"); 

	}
}