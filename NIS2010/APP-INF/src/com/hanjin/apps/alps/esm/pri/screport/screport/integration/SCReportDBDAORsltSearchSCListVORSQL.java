/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
		params.put("act_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("real_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("afil_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
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
		query.append("SELECT  M.SC_NO                 ," ).append("\n"); 
		query.append("        M.PROP_NO               ," ).append("\n"); 
		query.append("        M.AMDT_SEQ              ," ).append("\n"); 
		query.append("        M.SVC_SCP_CD            ," ).append("\n"); 
		query.append("        M.CTRT_PTY_NM           ," ).append("\n"); 
		query.append("        M.REAL_CUST_NM          ," ).append("\n"); 
		query.append("        #if (${act_cust_nm} != '' or ${fx_rt_flg} == 'N')" ).append("\n"); 
		query.append("        M.BLET_NO           	," ).append("\n"); 
		query.append("		M.GEN_SPCL_RT_TP_CD		," ).append("\n"); 
		query.append("		M.ACT_CUST_NM     ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        M.PRC_CTRT_CUST_TP_CD   ," ).append("\n"); 
		query.append("        M.FNL_MQC_QTY           ," ).append("\n"); 
		query.append("        M.TTL_MQC_QTY           ," ).append("\n"); 
		query.append("        M.PROP_APRO_OFC_CD      ," ).append("\n"); 
		query.append("        M.PROP_OFC_CD  ," ).append("\n"); 
		query.append("        M.CTRT_OFC ," ).append("\n"); 
		query.append("        M.AREA_GRP ," ).append("\n"); 
		query.append("        M.CTRT_CUST_SREP_CD     , " ).append("\n"); 
		query.append("        M.CTRT_EFF_DT ," ).append("\n"); 
		query.append("        M.CTRT_EXP_DT ," ).append("\n"); 
		query.append("        M.FILE_DT     ," ).append("\n"); 
		query.append("        M.LGCY_IF_FLG ," ).append("\n"); 
		query.append("        M.CONV_CFM_FLG ," ).append("\n"); 
		query.append("        M.RF_FLG          , -- param" ).append("\n"); 
		query.append("        M.GAMT_FLG        , -- param" ).append("\n"); 
		query.append("        M.EFF_DT          , -- param" ).append("\n"); 
		query.append("        M.EXP_DT          ,-- param" ).append("\n"); 
		query.append("        M.CUST_NM         ,-- param" ).append("\n"); 
		query.append("        NVL((SELECT 1" ).append("\n"); 
		query.append("               FROM PRI_SP_SCP_NOTE_CTNT  A,PRI_SC_NOTE_CONV B" ).append("\n"); 
		query.append("              WHERE A.PROP_NO          = M.PROP_NO" ).append("\n"); 
		query.append("                AND A.AMDT_SEQ         = M.AMDT_SEQ" ).append("\n"); 
		query.append("                AND A.SRC_INFO_CD      <> 'AD'" ).append("\n"); 
		query.append("                AND A.NOTE_CONV_MAPG_ID = B.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("                AND B.NOTE_CONV_CHG_CD = 'BUC'" ).append("\n"); 
		query.append("                AND B.RT_APPL_TP_CD IN ('F','I') -- FIX AMOUNT,INCLUDE " ).append("\n"); 
		query.append("                AND ROWNUM = 1),0) BUC_IND," ).append("\n"); 
		query.append("        NVL((SELECT 1" ).append("\n"); 
		query.append("               FROM PRI_SP_SCP_NOTE_CTNT  A,PRI_SC_NOTE_CONV B" ).append("\n"); 
		query.append("              WHERE A.PROP_NO          = M.PROP_NO" ).append("\n"); 
		query.append("                AND A.AMDT_SEQ         = M.AMDT_SEQ" ).append("\n"); 
		query.append("                AND A.SRC_INFO_CD      <> 'AD'" ).append("\n"); 
		query.append("                AND A.NOTE_CONV_MAPG_ID = B.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("                AND B.NOTE_CONV_CHG_CD = 'PSC'" ).append("\n"); 
		query.append("                AND B.RT_APPL_TP_CD ='N' -- NOT APPLICABLE" ).append("\n"); 
		query.append("                AND ROWNUM = 1),0) PSC_INCL_IND," ).append("\n"); 
		query.append("        NVL((SELECT 1" ).append("\n"); 
		query.append("               FROM PRI_SP_SCP_NOTE_CTNT  A,PRI_SC_NOTE_CONV B" ).append("\n"); 
		query.append("              WHERE A.PROP_NO          = M.PROP_NO" ).append("\n"); 
		query.append("                AND A.AMDT_SEQ         = M.AMDT_SEQ" ).append("\n"); 
		query.append("                AND A.SRC_INFO_CD      <> 'AD'" ).append("\n"); 
		query.append("                AND A.NOTE_CONV_MAPG_ID = B.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("                AND B.NOTE_CONV_CHG_CD = 'PSC'" ).append("\n"); 
		query.append("                AND B.RT_APPL_TP_CD <> 'N' -- NOT APPLICABLE" ).append("\n"); 
		query.append("                AND ROWNUM = 1),0) PSC_EXPT_IND," ).append("\n"); 
		query.append("        M.CHSS_EXPT_FLG, " ).append("\n"); 
		query.append("        M.GRI_APPL_FLG, " ).append("\n"); 
		query.append("		#if (${fx_rt_flg} == 'N')" ).append("\n"); 
		query.append("		FX_RT_FLG," ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        M.NEW_SCG_FLG" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("       FROM( " ).append("\n"); 
		query.append("                SELECT  L.SC_NO               ," ).append("\n"); 
		query.append("                        L.PROP_NO             ," ).append("\n"); 
		query.append("                        L.AMDT_SEQ            ," ).append("\n"); 
		query.append("                        L.SVC_SCP_CD          ," ).append("\n"); 
		query.append("                        L.CTRT_PTY_NM         ," ).append("\n"); 
		query.append("                        #if (${act_cust_nm} != ''  or ${fx_rt_flg} == 'N')" ).append("\n"); 
		query.append("                        SH.BLET_DP_SEQ    AS BLET_NO    , " ).append("\n"); 
		query.append("						SH.GEN_SPCL_RT_TP_CD  ," ).append("\n"); 
		query.append("						CUST_LGL_ENG_NM		 AS ACT_CUST_NM," ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        REAL_CUST_NM          ," ).append("\n"); 
		query.append("                        PRC_CTRT_CUST_TP_CD   ," ).append("\n"); 
		query.append("                        FNL_MQC_QTY           ," ).append("\n"); 
		query.append("                        TTL_MQC_QTY           ," ).append("\n"); 
		query.append("                        PROP_APRO_OFC_CD      ," ).append("\n"); 
		query.append("                        PROP_OFC_CD           ," ).append("\n"); 
		query.append("                        CTRT_OFC              ," ).append("\n"); 
		query.append("                        AREA_GRP              ," ).append("\n"); 
		query.append("                        CTRT_CUST_SREP_CD     , " ).append("\n"); 
		query.append("                        CTRT_EFF_DT           ," ).append("\n"); 
		query.append("                        CTRT_EXP_DT           ," ).append("\n"); 
		query.append("                        FILE_DT               ," ).append("\n"); 
		query.append("                        LGCY_IF_FLG           ," ).append("\n"); 
		query.append("                        CONV_CFM_FLG          ," ).append("\n"); 
		query.append("                        RF_FLG                , -- param" ).append("\n"); 
		query.append("                        GAMT_FLG              , -- param" ).append("\n"); 
		query.append("                        EFF_DT                , -- param" ).append("\n"); 
		query.append("                        EXP_DT                ,-- param" ).append("\n"); 
		query.append("                        CUST_NM               ,-- param" ).append("\n"); 
		query.append("                        CHSS_EXPT_FLG         , " ).append("\n"); 
		query.append("                        GRI_APPL_FLG          ," ).append("\n"); 
		query.append("						#if (${fx_rt_flg} == 'N') " ).append("\n"); 
		query.append("						SH.FX_RT_FLG," ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						NEW_SCG_FLG           " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT  SC_NO                 ," ).append("\n"); 
		query.append("                PROP_NO               ," ).append("\n"); 
		query.append("                AMDT_SEQ              ," ).append("\n"); 
		query.append("                SVC_SCP_CD            ," ).append("\n"); 
		query.append("                CTRT_PTY_NM           ," ).append("\n"); 
		query.append("                REAL_CUST_NM          ," ).append("\n"); 
		query.append("                PRC_CTRT_CUST_TP_CD   ," ).append("\n"); 
		query.append("                FNL_MQC_QTY           ," ).append("\n"); 
		query.append("                TTL_MQC_QTY           ," ).append("\n"); 
		query.append("                PROP_APRO_OFC_CD      ," ).append("\n"); 
		query.append("                PROP_OFC_CD           ," ).append("\n"); 
		query.append("                PRI_SUB_OFC_MATCH ( 1, PROP_OFC_CD ) AS CTRT_OFC ," ).append("\n"); 
		query.append("                PRI_SUB_OFC_MATCH ( 2, PROP_OFC_CD ) AS AREA_GRP ," ).append("\n"); 
		query.append("                CTRT_CUST_SREP_CD     , " ).append("\n"); 
		query.append("                TO_CHAR(CTRT_EFF_DT, 'YYYY-MM-DD')    CTRT_EFF_DT ," ).append("\n"); 
		query.append("                TO_CHAR(CTRT_EXP_DT, 'YYYY-MM-DD')    CTRT_EXP_DT ," ).append("\n"); 
		query.append("                TO_CHAR(FILE_DT, 'YYYY-MM-DD')        FILE_DT     ," ).append("\n"); 
		query.append("                DECODE(LGCY_IF_FLG, 'Y', 'Yes', 'No') LGCY_IF_FLG ," ).append("\n"); 
		query.append("                DECODE(CONV_CFM_FLG, 'Y', 'Yes', 'No') CONV_CFM_FLG ," ).append("\n"); 
		query.append("                '' AS RF_FLG          , -- param" ).append("\n"); 
		query.append("                '' AS GAMT_FLG        , -- param" ).append("\n"); 
		query.append("                '' AS EFF_DT          , -- param" ).append("\n"); 
		query.append("                '' AS EXP_DT          ,-- param" ).append("\n"); 
		query.append("                '' AS CUST_NM         ,-- param" ).append("\n"); 
		query.append("                CHSS_EXPT_FLG, " ).append("\n"); 
		query.append("                GRI_APPL_FLG, " ).append("\n"); 
		query.append("                NEW_SCG_FLG" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  /*+ INDEX ( SS XAK1PRI_SP_SCP_MN ) */" ).append("\n"); 
		query.append("                        SH.SC_NO      ," ).append("\n"); 
		query.append("                        SH.PROP_NO    ," ).append("\n"); 
		query.append("                        SM.AMDT_SEQ   ," ).append("\n"); 
		query.append("                        SS.SVC_SCP_CD ," ).append("\n"); 
		query.append("                        CP.CTRT_PTY_NM  CTRT_PTY_NM ," ).append("\n"); 
		query.append("                        (SELECT A.CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = SM.REAL_CUST_CNT_CD AND A.CUST_SEQ = SM.REAL_CUST_SEQ) AS REAL_CUST_NM," ).append("\n"); 
		query.append("                        NVL2(SM.REAL_CUST_CNT_CD, SM.REAL_CUST_TP_CD, CT.PRC_CTRT_CUST_TP_CD) PRC_CTRT_CUST_TP_CD ," ).append("\n"); 
		query.append("                        DECODE(SC.CNTR_LOD_UT_CD, 'T', SC.FNL_MQC_QTY / 2, SC.FNL_MQC_QTY)    TTL_MQC_QTY         ," ).append("\n"); 
		query.append("                        DECODE(SQ.CNTR_LOD_UT_CD, 'T', SQ.FNL_MQC_QTY / 2, SQ.FNL_MQC_QTY)    FNL_MQC_QTY         ," ).append("\n"); 
		query.append("                        SM.PROP_APRO_OFC_CD     ," ).append("\n"); 
		query.append("                        SM.PROP_OFC_CD          ," ).append("\n"); 
		query.append("                        SM.RESPB_SREP_CD        CTRT_CUST_SREP_CD     ," ).append("\n"); 
		query.append("                        SD.CTRT_EFF_DT          ," ).append("\n"); 
		query.append("                        SD.CTRT_EXP_DT          ," ).append("\n"); 
		query.append("                        SM.FILE_DT              ," ).append("\n"); 
		query.append("                        SM.LGCY_IF_FLG          ," ).append("\n"); 
		query.append("                        SM.CONV_CFM_FLG          ," ).append("\n"); 
		query.append("                        #if (${act_cust_nm} != '')" ).append("\n"); 
		query.append("                        NVL(( SELECT 1 FROM PRI_SP_SCP_RT_ACT_CUST SP, MDM_CUSTOMER MC" ).append("\n"); 
		query.append("                          WHERE SP.PROP_NO = SS.PROP_NO" ).append("\n"); 
		query.append("                                AND     SP.AMDT_SEQ = SS.AMDT_SEQ" ).append("\n"); 
		query.append("                                AND     SP.SVC_SCP_CD = SS.SVC_SCP_CD" ).append("\n"); 
		query.append("                                AND     SP.GEN_SPCL_RT_TP_CD = 'S'" ).append("\n"); 
		query.append("                                AND     SP.CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                                AND     SP.CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("                                AND     SP.SRC_INFO_CD  <>  'AD'" ).append("\n"); 
		query.append("                                AND     MC.CUST_LGL_ENG_NM LIKE '%' || @[act_cust_nm] || '%'" ).append("\n"); 
		query.append("                                AND     ROWNUM = 1), 0 ) ACT_CUST_IND ," ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                     SS.CHSS_EXPT_FLG, " ).append("\n"); 
		query.append("                     SS.GRI_APPL_FLG, " ).append("\n"); 
		query.append("                     SS.NEW_SCG_FLG," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER ( PARTITION BY SH.SC_NO, SS.SVC_SCP_CD ORDER BY SM.AMDT_SEQ DESC ) ROW_NUMBER" ).append("\n"); 
		query.append("                FROM    PRI_SP_HDR          SH  ," ).append("\n"); 
		query.append("                        PRI_SP_MN           SM  ," ).append("\n"); 
		query.append("                        PRI_SP_CTRT_PTY     CP  ," ).append("\n"); 
		query.append("                        PRI_SP_CTRT_CUST_TP CT  ," ).append("\n"); 
		query.append("                        PRI_SP_SCP_MN       SS  ," ).append("\n"); 
		query.append("                        PRI_SP_SCP_DUR      SD  ," ).append("\n"); 
		query.append("                        PRI_SP_SCP_MQC      SQ  ," ).append("\n"); 
		query.append("                        PRI_SP_MQC          SC" ).append("\n"); 
		query.append("                   #if (${afil_nm} != '')" ).append("\n"); 
		query.append("                       ,PRI_SP_AFIL         SA" ).append("\n"); 
		query.append("                       ,MDM_CUSTOMER        MC" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
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
		query.append("                AND     SC.PROP_NO            = SS.PROP_NO" ).append("\n"); 
		query.append("                AND     SC.AMDT_SEQ           = SS.AMDT_SEQ" ).append("\n"); 
		query.append("                #if (${afil_nm} != '')" ).append("\n"); 
		query.append("                AND     SM.PROP_NO            = SA.PROP_NO" ).append("\n"); 
		query.append("                AND     SM.AMDT_SEQ           = SA.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     SA.CUST_CNT_CD        = MC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("                AND     SA.CUST_SEQ           = MC.CUST_SEQ(+)" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                AND     SS.EFF_DT <= TO_DATE(@[exp_dt], 'YYYY-MM-DD')      -- S/C Effective Date (To)" ).append("\n"); 
		query.append("                AND     SS.EXP_DT >= TO_DATE(@[eff_dt], 'YYYY-MM-DD')      -- S/C Effective Date (From)" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                #if (${afil_nm} != '')" ).append("\n"); 
		query.append("                AND     MC.CUST_LGL_ENG_NM LIKE '%' || @[afil_nm] || '%'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                #if (${sc_no} != '')" ).append("\n"); 
		query.append("                AND     SH.SC_NO LIKE @[sc_no] || '%'         -- S/C No" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${rf_flg} != '')" ).append("\n"); 
		query.append("                AND     SM.RF_FLG = @[rf_flg]               -- S/C Type" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${gamt_flg} != '')" ).append("\n"); 
		query.append("                AND     SM.GAMT_FLG = @[gamt_flg]               -- S/C Type" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                #if (${prc_ctrt_cust_tp_cd} != '')" ).append("\n"); 
		query.append("                AND     NVL2(SM.REAL_CUST_CNT_CD, SM.REAL_CUST_TP_CD, CT.PRC_CTRT_CUST_TP_CD) = @[prc_ctrt_cust_tp_cd]     -- Customer Type" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${prop_apro_ofc_cd} != '')" ).append("\n"); 
		query.append("                AND     SM.PROP_APRO_OFC_CD   = @[prop_apro_ofc_cd]        -- Approval Office " ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                #if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("                AND    SS.SVC_SCP_CD    = @[svc_scp_cd] -- SVC Scope" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                #if (${cust_nm} != '')" ).append("\n"); 
		query.append("                AND    UPPER(CP.CTRT_PTY_NM) LIKE '%' || @[cust_nm] || '%'" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        WHERE   ROW_NUMBER    = 1" ).append("\n"); 
		query.append("        #if (${act_cust_nm} != '')" ).append("\n"); 
		query.append("          AND   ACT_CUST_IND = 1" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		#if (${real_cust_nm} != '')" ).append("\n"); 
		query.append("          AND   REAL_CUST_NM LIKE '%' || @[real_cust_nm] || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append(") L" ).append("\n"); 
		query.append("		        " ).append("\n"); 
		query.append("        #if (${act_cust_nm} != '' or ${fx_rt_flg} == 'N')" ).append("\n"); 
		query.append("            , PRI_SP_SCP_RT_ACT_CUST SP, MDM_CUSTOMER MC, PRI_SP_SCP_RT_CMDT_HDR SH" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND     L.PROP_NO = SH.PROP_NO" ).append("\n"); 
		query.append("        AND     L.AMDT_SEQ = SH.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     L.SVC_SCP_CD = SH.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     SH.PROP_NO = SP.PROP_NO(+)" ).append("\n"); 
		query.append("        AND     SH.AMDT_SEQ = SP.AMDT_SEQ(+)" ).append("\n"); 
		query.append("        AND     SH.SVC_SCP_CD = SP.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("        AND     SH.GEN_SPCL_RT_TP_CD = SP.GEN_SPCL_RT_TP_CD(+)" ).append("\n"); 
		query.append("        AND     SH.CMDT_HDR_SEQ = SP.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("        AND     SP.CUST_CNT_CD = MC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("        AND     SP.CUST_SEQ = MC.CUST_SEQ(+)" ).append("\n"); 
		query.append("        AND     SP.SRC_INFO_CD(+)  <>  'AD'" ).append("\n"); 
		query.append("		#if (${act_cust_nm} != '')" ).append("\n"); 
		query.append("        AND     MC.CUST_LGL_ENG_NM LIKE '%' || @[act_cust_nm] || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${fx_rt_flg} == 'N')" ).append("\n"); 
		query.append("		AND     SH.FX_RT_FLG = 'Y'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append(") M        " ).append("\n"); 
		query.append("        #if (${prop_ofc_cd} != '')" ).append("\n"); 
		query.append("        WHERE     M.CTRT_OFC = @[prop_ofc_cd] -- Contract Office" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        M.SC_NO       ," ).append("\n"); 
		query.append("        M.AMDT_SEQ    ," ).append("\n"); 
		query.append("        M.SVC_SCP_CD" ).append("\n"); 

	}
}