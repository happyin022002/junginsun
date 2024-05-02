/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCPerformanceDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.24 
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

public class SCReportDBDAORsltSearchSCPerformanceDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sc performance detail
	  * </pre>
	  */
	public SCReportDBDAORsltSearchSCPerformanceDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd_txt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_obrd_dt_from",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_obrd_dt_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchSCPerformanceDetailListRSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("CH AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  CH.PROP_NO            ," ).append("\n"); 
		query.append("        CH.AMDT_SEQ           ," ).append("\n"); 
		query.append("        CH.SVC_SCP_CD         ," ).append("\n"); 
		query.append("        CH.GEN_SPCL_RT_TP_CD  ," ).append("\n"); 
		query.append("        CH.CMDT_HDR_SEQ       ," ).append("\n"); 
		query.append("        DECODE( ( SELECT COUNT(1) FROM PRI_SP_SCP_MN SM WHERE SM.PROP_NO = CH.PROP_NO AND SM.AMDT_SEQ = CH.AMDT_SEQ ), 1, 'Y', 'N' ) SGL_SCP_FLG" ).append("\n"); 
		query.append("FROM    PRI_SP_SCP_MN           SS  ," ).append("\n"); 
		query.append("        PRI_SP_SCP_RT_CMDT_HDR  CH" ).append("\n"); 
		query.append("/* 조회 조건 */" ).append("\n"); 
		query.append("WHERE   CH.PROP_NO            = SS.PROP_NO" ).append("\n"); 
		query.append("AND     CH.AMDT_SEQ           = SS.AMDT_SEQ" ).append("\n"); 
		query.append("AND     CH.SVC_SCP_CD         = SS.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     SS.PROP_NO            = ( SELECT PROP_NO FROM PRI_SP_HDR WHERE SC_NO = @[sc_no] )   -- S/C NO" ).append("\n"); 
		query.append("AND     SS.AMDT_SEQ           = (" ).append("\n"); 
		query.append("                                  SELECT  MAX(A.AMDT_SEQ)   /* 최신 AMDT_SEQ 를 대상으로 함 */" ).append("\n"); 
		query.append("                                  FROM    PRI_SP_MN A" ).append("\n"); 
		query.append("                                  WHERE   A.PROP_NO     = CH.PROP_NO" ).append("\n"); 
		query.append("                                  AND     A.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("AND     CH.SVC_SCP_CD         = @[svc_scp_cd]   -- SVC SCOPE CODE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gen_spcl_rt_tp_cd} != '')" ).append("\n"); 
		query.append("AND     CH.GEN_SPCL_RT_TP_CD  = @[gen_spcl_rt_tp_cd]     -- RATE TYPE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     CH.CMDT_HDR_SEQ       = NVL(@[cmdt_hdr_seq], CH.CMDT_HDR_SEQ)  -- Commodity Group & Actual Customer" ).append("\n"); 
		query.append(") ," ).append("\n"); 
		query.append("BU AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  CH.PROP_NO            ," ).append("\n"); 
		query.append("        CH.AMDT_SEQ           ," ).append("\n"); 
		query.append("        CH.SVC_SCP_CD         ," ).append("\n"); 
		query.append("        CH.GEN_SPCL_RT_TP_CD  ," ).append("\n"); 
		query.append("        CH.CMDT_HDR_SEQ       ," ).append("\n"); 
		query.append("        RC.CMDT_NM            ," ).append("\n"); 
		query.append("        RC.PRC_CMDT_DEF_CD    ," ).append("\n"); 
		query.append("        NVL(REPLACE(AC.ACT_CUST_NM, '^|^', ' / '), 'N/A')  ACT_CUST_NM ," ).append("\n"); 
		query.append("        NVL(AC.ACT_CUST_CD, 'N/A')  ACT_CUST_CD ," ).append("\n"); 
		query.append("        CH.SGL_SCP_FLG" ).append("\n"); 
		query.append("FROM    CH    ," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT  PROP_NO             ," ).append("\n"); 
		query.append("                AMDT_SEQ            ," ).append("\n"); 
		query.append("                SVC_SCP_CD          ," ).append("\n"); 
		query.append("                GEN_SPCL_RT_TP_CD   ," ).append("\n"); 
		query.append("                CMDT_HDR_SEQ        ," ).append("\n"); 
		query.append("                LTRIM(SYS_CONNECT_BY_PATH(CMDT_NM,' / '),' / ') CMDT_NM ," ).append("\n"); 
		query.append("                LTRIM(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD,' / '),' / ') PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("        FROM   (" ).append("\n"); 
		query.append("                SELECT  /*+ ORDERED */" ).append("\n"); 
		query.append("                        CH.PROP_NO            ," ).append("\n"); 
		query.append("                        CH.AMDT_SEQ           ," ).append("\n"); 
		query.append("                        CH.SVC_SCP_CD         ," ).append("\n"); 
		query.append("                        CH.GEN_SPCL_RT_TP_CD  ," ).append("\n"); 
		query.append("                        CH.CMDT_HDR_SEQ       ," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER ( PARTITION BY CH.PROP_NO, CH.AMDT_SEQ, CH.SVC_SCP_CD, CH.GEN_SPCL_RT_TP_CD, CH.CMDT_HDR_SEQ ORDER BY RC.CMDT_SEQ ) ROW_NUMBER  ," ).append("\n"); 
		query.append("                        COUNT(1) OVER ( PARTITION BY CH.PROP_NO, CH.AMDT_SEQ, CH.SVC_SCP_CD, CH.GEN_SPCL_RT_TP_CD, CH.CMDT_HDR_SEQ ) CNT  ," ).append("\n"); 
		query.append("                        RC.PRC_CMDT_DEF_CD    ," ).append("\n"); 
		query.append("                        DECODE(RC.PRC_CMDT_TP_CD, 'C', MC.CMDT_NM, 'G', GC.PRC_GRP_CMDT_DESC) CMDT_NM" ).append("\n"); 
		query.append("                FROM    CH                      ," ).append("\n"); 
		query.append("                        PRI_SP_SCP_RT_CMDT  RC  ," ).append("\n"); 
		query.append("                        MDM_COMMODITY       MC  ," ).append("\n"); 
		query.append("                        PRI_SP_SCP_GRP_CMDT GC" ).append("\n"); 
		query.append("                WHERE   MC.CMDT_CD(+)         = RC.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                AND     GC.PROP_NO(+)         = RC.PROP_NO" ).append("\n"); 
		query.append("                AND     GC.AMDT_SEQ(+)        = RC.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     GC.SVC_SCP_CD(+)      = RC.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND     GC.PRC_GRP_CMDT_CD(+) = RC.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                AND     RC.PROP_NO            = CH.PROP_NO" ).append("\n"); 
		query.append("                AND     RC.AMDT_SEQ           = CH.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     RC.SVC_SCP_CD         = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND     RC.GEN_SPCL_RT_TP_CD  = CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                AND     RC.CMDT_HDR_SEQ       = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND     RC.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        WHERE   LEVEL = CNT" ).append("\n"); 
		query.append("        START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("        CONNECT BY" ).append("\n"); 
		query.append("                PROP_NO           = PRIOR PROP_NO" ).append("\n"); 
		query.append("        AND     AMDT_SEQ          = PRIOR AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SVC_SCP_CD        = PRIOR SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     GEN_SPCL_RT_TP_CD = PRIOR GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        AND     CMDT_HDR_SEQ      = PRIOR CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND     ROW_NUMBER        = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("        ) RC  ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  PROP_NO             ," ).append("\n"); 
		query.append("                AMDT_SEQ            ," ).append("\n"); 
		query.append("                SVC_SCP_CD          ," ).append("\n"); 
		query.append("                GEN_SPCL_RT_TP_CD   ," ).append("\n"); 
		query.append("                CMDT_HDR_SEQ        ," ).append("\n"); 
		query.append("                LTRIM(SYS_CONNECT_BY_PATH(ACT_CUST_CD,' / '),' / ') ACT_CUST_CD ," ).append("\n"); 
		query.append("                LTRIM(SYS_CONNECT_BY_PATH(ACT_CUST_NM,'^|^'),'^|^') ACT_CUST_NM" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  /*+ ORDERED */" ).append("\n"); 
		query.append("                        CH.PROP_NO            ," ).append("\n"); 
		query.append("                        CH.AMDT_SEQ           ," ).append("\n"); 
		query.append("                        CH.SVC_SCP_CD         ," ).append("\n"); 
		query.append("                        CH.GEN_SPCL_RT_TP_CD  ," ).append("\n"); 
		query.append("                        CH.CMDT_HDR_SEQ       ," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER ( PARTITION BY CH.PROP_NO, CH.AMDT_SEQ, CH.SVC_SCP_CD, CH.GEN_SPCL_RT_TP_CD, CH.CMDT_HDR_SEQ ORDER BY AC.ACT_CUST_SEQ ) ROW_NUMBER  ," ).append("\n"); 
		query.append("                        COUNT(1) OVER ( PARTITION BY CH.PROP_NO, CH.AMDT_SEQ, CH.SVC_SCP_CD, CH.GEN_SPCL_RT_TP_CD, CH.CMDT_HDR_SEQ ) CNT  ," ).append("\n"); 
		query.append("                        AC.CUST_CNT_CD||LPAD(AC.CUST_SEQ, 6, '0') ACT_CUST_CD ," ).append("\n"); 
		query.append("                        MC.CUST_LGL_ENG_NM  ACT_CUST_NM" ).append("\n"); 
		query.append("                FROM    CH                          ," ).append("\n"); 
		query.append("                        PRI_SP_SCP_RT_ACT_CUST  AC  ," ).append("\n"); 
		query.append("                        MDM_CUSTOMER            MC" ).append("\n"); 
		query.append("                WHERE   MC.CUST_CNT_CD(+)     = AC.CUST_CNT_CD" ).append("\n"); 
		query.append("                AND     MC.CUST_SEQ(+)        = AC.CUST_SEQ" ).append("\n"); 
		query.append("                AND     MC.CNTR_DIV_FLG       = 'Y'" ).append("\n"); 
		query.append("                AND     AC.PROP_NO            = CH.PROP_NO" ).append("\n"); 
		query.append("                AND     AC.AMDT_SEQ           = CH.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     AC.SVC_SCP_CD         = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("                AND     AC.GEN_SPCL_RT_TP_CD  = CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                AND     AC.CMDT_HDR_SEQ       = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                AND     AC.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        WHERE   LEVEL   = CNT" ).append("\n"); 
		query.append("        START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("        CONNECT BY" ).append("\n"); 
		query.append("                PROP_NO           = PRIOR PROP_NO" ).append("\n"); 
		query.append("        AND     AMDT_SEQ          = PRIOR AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SVC_SCP_CD        = PRIOR SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     GEN_SPCL_RT_TP_CD = PRIOR GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("        AND     CMDT_HDR_SEQ      = PRIOR CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        AND     ROW_NUMBER        = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("        ) AC" ).append("\n"); 
		query.append("WHERE   RC.PROP_NO(+)           = CH.PROP_NO" ).append("\n"); 
		query.append("AND     RC.AMDT_SEQ(+)          = CH.AMDT_SEQ" ).append("\n"); 
		query.append("AND     RC.SVC_SCP_CD(+)        = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     RC.GEN_SPCL_RT_TP_CD(+) = CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND     RC.CMDT_HDR_SEQ(+)      = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND     AC.PROP_NO(+)           = CH.PROP_NO" ).append("\n"); 
		query.append("AND     AC.AMDT_SEQ(+)          = CH.AMDT_SEQ" ).append("\n"); 
		query.append("AND     AC.SVC_SCP_CD(+)        = CH.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     AC.GEN_SPCL_RT_TP_CD(+) = CH.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND     AC.CMDT_HDR_SEQ(+)      = CH.CMDT_HDR_SEQ" ).append("\n"); 
		query.append(") ," ).append("\n"); 
		query.append("TR AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/* PK : SLAN_CD, DIR_CD, FM_CONTI, TO_CONTI */" ).append("\n"); 
		query.append("SELECT  VSL_SLAN_CD, VSL_SLAN_DIR_CD, FM_CONTI_CD, TO_CONTI_CD, TRD_CD, SUB_TRD_CD, RLANE_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  RL.VSL_SLAN_CD, DL.VSL_SLAN_DIR_CD, DL.FM_CONTI_CD, DL.TO_CONTI_CD, DL.TRD_CD, DL.SUB_TRD_CD, DL.RLANE_CD," ).append("\n"); 
		query.append("        /* DELETE 되지 않고, I/O 가 정상적인 것이 우선 적용됨 */" ).append("\n"); 
		query.append("                ROW_NUMBER() OVER ( PARTITION BY RL.VSL_SLAN_CD, DL.VSL_SLAN_DIR_CD, DL.FM_CONTI_CD, DL.TO_CONTI_CD ORDER BY DL.DELT_FLG, DECODE(FM_CONTI_CD, TO_CONTI_CD, DECODE(IOC_CD, 'I', 1, 2), DECODE(IOC_CD, 'O', 1 ,2)) ) ROW_NUMBER" ).append("\n"); 
		query.append("        FROM    MDM_REV_LANE      RL  ," ).append("\n"); 
		query.append("                MDM_DTL_REV_LANE  DL" ).append("\n"); 
		query.append("        WHERE   DL.RLANE_CD   = RL.RLANE_CD" ).append("\n"); 
		query.append("        AND     RL.VSL_TP_CD  = 'C'" ).append("\n"); 
		query.append("        AND     DL.TRD_CD     LIKE @[trd_cd]      || '%' -- trade" ).append("\n"); 
		query.append("        AND     DL.SUB_TRD_CD LIKE @[sub_trd_cd]  || '%' -- sub trade" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   ROW_NUMBER  = 1" ).append("\n"); 
		query.append(") ," ).append("\n"); 
		query.append("BK AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  ROWNUM  BK_UQ_SEQ ," ).append("\n"); 
		query.append("        TRD_CD            ," ).append("\n"); 
		query.append("        SKD_DIR_CD        ," ).append("\n"); 
		query.append("        SUB_TRD_CD        ," ).append("\n"); 
		query.append("        SLAN_CD           ," ).append("\n"); 
		query.append("        VVD               ," ).append("\n"); 
		query.append("        SVC_SCP_CD        ," ).append("\n"); 
		query.append("        CMDT_CD           ," ).append("\n"); 
		query.append("        AGMT_ACT_CNT_CD   ," ).append("\n"); 
		query.append("        AGMT_ACT_CUST_SEQ ," ).append("\n"); 
		query.append("        USA_SVC_MOD_CD    ," ).append("\n"); 
		query.append("        POR_CD            ," ).append("\n"); 
		query.append("        POL_CD            ," ).append("\n"); 
		query.append("        POD_CD            ," ).append("\n"); 
		query.append("        DEL_CD            ," ).append("\n"); 
		query.append("        OP_CNTR_QTY       ," ).append("\n"); 
		query.append("        PRC_GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("        PRC_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  BK.SVC_SCP_CD         ," ).append("\n"); 
		query.append("                BK.CMDT_CD            ," ).append("\n"); 
		query.append("                BK.AGMT_ACT_CNT_CD    ," ).append("\n"); 
		query.append("                DECODE(BK.AGMT_ACT_CNT_CD, NULL, 0, BK.AGMT_ACT_CUST_SEQ) AGMT_ACT_CUST_SEQ ," ).append("\n"); 
		query.append("                TR.TRD_CD             ," ).append("\n"); 
		query.append("                BK.SKD_DIR_CD         ," ).append("\n"); 
		query.append("                TR.SUB_TRD_CD         ," ).append("\n"); 
		query.append("                BK.SLAN_CD            ," ).append("\n"); 
		query.append("                BK.VSL_CD||BK.SKD_VOY_NO||BK.SKD_DIR_CD VVD ," ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                WHEN  L3.CNT_CD IN ( 'US', 'CA' ) AND BK.POD_CD = BK.DEL_CD AND BK.DE_TERM_CD NOT IN ( 'D', 'H' ) THEN 'PO'" ).append("\n"); 
		query.append("                WHEN  L3.CNT_CD IN ( 'US', 'CA' ) THEN NVL(( SELECT SUBSTR(SVC_MOD_CD, 2, 2) FROM COA_USA_SVC_MOD A WHERE A.ORG_RGN_CD = L3.RGN_CD AND A.DEST_RGN_CD = L4.RGN_CD ), 'OT' )" ).append("\n"); 
		query.append("                WHEN  L2.CNT_CD IN ( 'US', 'CA' ) AND BK.POL_CD = BK.POR_CD AND BK.RCV_TERM_CD NOT IN ( 'D', 'H' ) THEN 'PO'" ).append("\n"); 
		query.append("                WHEN  L2.CNT_CD IN ( 'US', 'CA' ) THEN NVL(( SELECT SUBSTR(SVC_MOD_CD, 2, 2) FROM COA_USA_SVC_MOD A WHERE A.ORG_RGN_CD = L2.RGN_CD AND A.DEST_RGN_CD = L1.RGN_CD ), 'OT' )" ).append("\n"); 
		query.append("                END   USA_SVC_MOD_CD  , /* PO, LO, IP, ML, OT */" ).append("\n"); 
		query.append("                BK.POR_CD             ," ).append("\n"); 
		query.append("                BK.POL_CD             ," ).append("\n"); 
		query.append("                BK.POD_CD             ," ).append("\n"); 
		query.append("                BK.DEL_CD             ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  SUM( BQ.OP_CNTR_QTY * ( SELECT PRI_SC_FEU_CONV(BK.SVC_SCP_CD, BQ.CNTR_TPSZ_CD) FROM DUAL) )" ).append("\n"); 
		query.append("                FROM    BKG_QUANTITY  BQ" ).append("\n"); 
		query.append("                WHERE   BQ.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("                AND     BQ.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("                ) OP_CNTR_QTY         ," ).append("\n"); 
		query.append("                BR.PRC_GEN_SPCL_RT_TP_CD  ," ).append("\n"); 
		query.append("                BR.PRC_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("        FROM    BKG_BOOKING       BK  ," ).append("\n"); 
		query.append("                BKG_RATE          BR  ," ).append("\n"); 
		query.append("                BKG_VVD           BV  ," ).append("\n"); 
		query.append("                VSK_VSL_PORT_SKD  PS  ," ).append("\n"); 
		query.append("                MDM_LOCATION      L1  ," ).append("\n"); 
		query.append("                MDM_LOCATION      L2  ," ).append("\n"); 
		query.append("                MDM_LOCATION      L3  ," ).append("\n"); 
		query.append("                MDM_LOCATION      L4  ," ).append("\n"); 
		query.append("                TR" ).append("\n"); 
		query.append("        WHERE   BR.BKG_NO           = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     BV.BKG_NO           = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     NOT EXISTS  (" ).append("\n"); 
		query.append("                            SELECT  'X'" ).append("\n"); 
		query.append("                            FROM    BKG_VVD A" ).append("\n"); 
		query.append("                            WHERE   A.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("                            AND     A.VSL_PRE_PST_CD||A.VSL_SEQ < BV.VSL_PRE_PST_CD||BV.VSL_SEQ" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("        AND     PS.VSL_CD           = BV.VSL_CD" ).append("\n"); 
		query.append("        AND     PS.SKD_VOY_NO       = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND     PS.SKD_DIR_CD       = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND     PS.VPS_PORT_CD      = BV.POL_CD" ).append("\n"); 
		query.append("        AND     PS.CLPT_IND_SEQ     = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        AND     L1.LOC_CD           = BK.POR_CD" ).append("\n"); 
		query.append("        AND     L2.LOC_CD           = BK.POL_CD" ).append("\n"); 
		query.append("        AND     L3.LOC_CD           = BK.POD_CD" ).append("\n"); 
		query.append("        AND     L4.LOC_CD           = BK.DEL_CD" ).append("\n"); 
		query.append("        AND     TR.VSL_SLAN_CD      = BK.SLAN_CD" ).append("\n"); 
		query.append("        AND     TR.VSL_SLAN_DIR_CD  = BK.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND     TR.FM_CONTI_CD      = L2.CONTI_CD" ).append("\n"); 
		query.append("        AND     TR.TO_CONTI_CD      = L3.CONTI_CD" ).append("\n"); 
		query.append("        AND     BK.BKG_STS_CD       = 'F'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        /* 조회 조건 */" ).append("\n"); 
		query.append("        AND     BK.SC_NO        = @[sc_no]      -- sc_no" ).append("\n"); 
		query.append("        #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.SKD_DIR_CD   = @[skd_dir_cd] -- direction" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${slan_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.SLAN_CD      = @[slan_cd]    -- lane" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.VSL_CD       = @[vsl_cd]     -- vvd 1" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("        AND     BK.SKD_VOY_NO   = @[skd_voy_no] -- vvd 2" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${skd_dir_cd_txt} != '')" ).append("\n"); 
		query.append("        AND     BK.SKD_DIR_CD   = @[skd_dir_cd_txt] -- vvd3" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${por_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.POR_CD       = @[por_cd]     -- por" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${pol_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.POL_CD       =  @[pol_cd]     -- pol" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${pod_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.POD_CD       = @[pod_cd]     -- pod" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${del_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.DEL_CD       = @[del_cd]     -- del" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND     PS.VPS_ETD_DT <= TO_DATE(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC, SYSDATE, BK.POL_CD))" ).append("\n"); 
		query.append("        #if (${bl_obrd_dt_from} != '')" ).append("\n"); 
		query.append("        AND     PS.VPS_ETD_DT >= TO_DATE(@[bl_obrd_dt_from], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bl_obrd_dt_to} != '')" ).append("\n"); 
		query.append("        AND     PS.VPS_ETD_DT <= TO_DATE (@[bl_obrd_dt_to], 'YYYY-MM-DD') + 0.99999 /* 0.99999 는 23시 59분 59초를 의미 */  -- Period" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#if (${usa_svc_mod_cd} != '')" ).append("\n"); 
		query.append("WHERE   NVL(USA_SVC_MOD_CD, ' ') LIKE @[usa_svc_mod_cd] || '%' -- us mode" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") ," ).append("\n"); 
		query.append("R1 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  BK_UQ_SEQ          ," ).append("\n"); 
		query.append("        TRD_CD             ," ).append("\n"); 
		query.append("        SKD_DIR_CD         ," ).append("\n"); 
		query.append("        SUB_TRD_CD         ," ).append("\n"); 
		query.append("        SLAN_CD            ," ).append("\n"); 
		query.append("        VVD                ," ).append("\n"); 
		query.append("        CMDT_CD            ," ).append("\n"); 
		query.append("        USA_SVC_MOD_CD     ," ).append("\n"); 
		query.append("        POR_CD             ," ).append("\n"); 
		query.append("        POL_CD             ," ).append("\n"); 
		query.append("        POD_CD             ," ).append("\n"); 
		query.append("        DEL_CD             ," ).append("\n"); 
		query.append("        OP_CNTR_QTY        ," ).append("\n"); 
		query.append("        SVC_SCP_CD         ," ).append("\n"); 
		query.append("        GEN_SPCL_RT_TP_CD  ," ).append("\n"); 
		query.append("        CMDT_NM            ," ).append("\n"); 
		query.append("        ACT_CUST_NM" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  BK.BK_UQ_SEQ          ," ).append("\n"); 
		query.append("                BK.TRD_CD             ," ).append("\n"); 
		query.append("                BK.SKD_DIR_CD         ," ).append("\n"); 
		query.append("                BK.SUB_TRD_CD         ," ).append("\n"); 
		query.append("                BK.SLAN_CD            ," ).append("\n"); 
		query.append("                BK.VVD                ," ).append("\n"); 
		query.append("                BK.CMDT_CD            ," ).append("\n"); 
		query.append("                BK.USA_SVC_MOD_CD     ," ).append("\n"); 
		query.append("                BK.POR_CD             ," ).append("\n"); 
		query.append("                BK.POL_CD             ," ).append("\n"); 
		query.append("                BK.POD_CD             ," ).append("\n"); 
		query.append("                BK.DEL_CD             ," ).append("\n"); 
		query.append("                BK.OP_CNTR_QTY        ," ).append("\n"); 
		query.append("                BU.SVC_SCP_CD         ," ).append("\n"); 
		query.append("                BU.GEN_SPCL_RT_TP_CD  ," ).append("\n"); 
		query.append("                BU.CMDT_NM            ," ).append("\n"); 
		query.append("                BU.ACT_CUST_NM        ," ).append("\n"); 
		query.append("                ROW_NUMBER() OVER ( PARTITION BY BK.BK_UQ_SEQ" ).append("\n"); 
		query.append("                                    ORDER BY" ).append("\n"); 
		query.append("                                      DECODE(BU.GEN_SPCL_RT_TP_CD, BK.PRC_GEN_SPCL_RT_TP_CD, 1, 2)  ," ).append("\n"); 
		query.append("                                      DECODE(BU.CMDT_HDR_SEQ, BK.PRC_CMDT_HDR_SEQ, 1, 2)            ," ).append("\n"); 
		query.append("                                      DECODE(BU.ACT_CUST_CD, 'N/A', 2, 1)                           ," ).append("\n"); 
		query.append("                                      BU.GEN_SPCL_RT_TP_CD  ," ).append("\n"); 
		query.append("                                      BU.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                  ) ROW_NUMBER" ).append("\n"); 
		query.append("        FROM    BK  ," ).append("\n"); 
		query.append("                BU" ).append("\n"); 
		query.append("        WHERE   (   BU.SGL_SCP_FLG  = 'Y'" ).append("\n"); 
		query.append("                OR  BU.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        AND     EXISTS  (" ).append("\n"); 
		query.append("                        SELECT  'X'" ).append("\n"); 
		query.append("                        FROM    PRI_SP_SCP_RT_CMDT  RC" ).append("\n"); 
		query.append("                        WHERE   RC.PROP_NO            = BU.PROP_NO" ).append("\n"); 
		query.append("                        AND     RC.AMDT_SEQ           = BU.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND     RC.SVC_SCP_CD         = BU.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND     RC.GEN_SPCL_RT_TP_CD  = BU.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                        AND     RC.CMDT_HDR_SEQ       = BU.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                        AND     RC.PRC_CMDT_TP_CD     = 'C'" ).append("\n"); 
		query.append("                        AND     RC.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("                        AND     RC.PRC_CMDT_DEF_CD    = BK.CMDT_CD" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT  'X'" ).append("\n"); 
		query.append("                        FROM    PRI_SP_SCP_RT_CMDT  RC" ).append("\n"); 
		query.append("                        WHERE   RC.PROP_NO            = BU.PROP_NO" ).append("\n"); 
		query.append("                        AND     RC.AMDT_SEQ           = BU.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND     RC.SVC_SCP_CD         = BU.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND     RC.GEN_SPCL_RT_TP_CD  = BU.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                        AND     RC.CMDT_HDR_SEQ       = BU.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                        AND     RC.PRC_CMDT_TP_CD     = 'G'" ).append("\n"); 
		query.append("                        AND     RC.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("                        AND     EXISTS  (" ).append("\n"); 
		query.append("                                        SELECT  'X'" ).append("\n"); 
		query.append("                                        FROM    PRI_SP_SCP_GRP_CMDT     G ," ).append("\n"); 
		query.append("                                                PRI_SP_SCP_GRP_CMDT_DTL D" ).append("\n"); 
		query.append("                                        WHERE   D.PROP_NO         = G.PROP_NO" ).append("\n"); 
		query.append("                                        AND     D.AMDT_SEQ        = G.AMDT_SEQ" ).append("\n"); 
		query.append("                                        AND     D.SVC_SCP_CD      = G.SVC_SCP_CD" ).append("\n"); 
		query.append("                                        AND     D.GRP_CMDT_SEQ    = G.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("                                        AND     G.PROP_NO         = RC.PROP_NO" ).append("\n"); 
		query.append("                                        AND     G.AMDT_SEQ        = RC.AMDT_SEQ" ).append("\n"); 
		query.append("                                        AND     G.SVC_SCP_CD      = RC.SVC_SCP_CD" ).append("\n"); 
		query.append("                                        AND     G.PRC_GRP_CMDT_CD = RC.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                                        AND     D.PRC_CMDT_TP_CD  = 'C'" ).append("\n"); 
		query.append("                                        AND     D.SRC_INFO_CD     <> 'AD'" ).append("\n"); 
		query.append("                                        AND     D.PRC_CMDT_DEF_CD = BK.CMDT_CD" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("        AND     EXISTS  (" ).append("\n"); 
		query.append("                        SELECT  'X'" ).append("\n"); 
		query.append("                        FROM    DUAL" ).append("\n"); 
		query.append("                        WHERE   NOT EXISTS  (" ).append("\n"); 
		query.append("                                            SELECT  'X'" ).append("\n"); 
		query.append("                                            FROM    PRI_SP_SCP_RT_ACT_CUST  AC" ).append("\n"); 
		query.append("                                            WHERE   AC.PROP_NO            = BU.PROP_NO" ).append("\n"); 
		query.append("                                            AND     AC.AMDT_SEQ           = BU.AMDT_SEQ" ).append("\n"); 
		query.append("                                            AND     AC.SVC_SCP_CD         = BU.SVC_SCP_CD" ).append("\n"); 
		query.append("                                            AND     AC.GEN_SPCL_RT_TP_CD  = BU.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                                            AND     AC.CMDT_HDR_SEQ       = BU.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                                            AND     AC.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT  'X'" ).append("\n"); 
		query.append("                        FROM    PRI_SP_SCP_RT_ACT_CUST  AC" ).append("\n"); 
		query.append("                        WHERE   AC.PROP_NO            = BU.PROP_NO" ).append("\n"); 
		query.append("                        AND     AC.AMDT_SEQ           = BU.AMDT_SEQ" ).append("\n"); 
		query.append("                        AND     AC.SVC_SCP_CD         = BU.SVC_SCP_CD" ).append("\n"); 
		query.append("                        AND     AC.GEN_SPCL_RT_TP_CD  = BU.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("                        AND     AC.CMDT_HDR_SEQ       = BU.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("                        AND     AC.CUST_CNT_CD        = BK.AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append("                        AND     AC.CUST_SEQ           = BK.AGMT_ACT_CUST_SEQ" ).append("\n"); 
		query.append("                        AND     AC.SRC_INFO_CD       <> 'AD'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   ROW_NUMBER  = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  TRD_CD            ," ).append("\n"); 
		query.append("        SKD_DIR_CD        ," ).append("\n"); 
		query.append("        SUB_TRD_CD        ," ).append("\n"); 
		query.append("        #if (${chk_slan_cd} != '')" ).append("\n"); 
		query.append("        SLAN_CD           ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_vvd} != '')" ).append("\n"); 
		query.append("        VVD               ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_gen_spcl_rt_tp_cd} != '')" ).append("\n"); 
		query.append("        GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_cmdt_nm} != '')" ).append("\n"); 
		query.append("        CMDT_NM           ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_act_cust_nm} != '')" ).append("\n"); 
		query.append("        ACT_CUST_NM       ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_usa_svc_mod_cd} != '')" ).append("\n"); 
		query.append("        USA_SVC_MOD_CD    ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_por_cd} != '')" ).append("\n"); 
		query.append("        POR_CD            ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_pol_cd} != '')" ).append("\n"); 
		query.append("        POL_CD            ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_pod_cd} != '')" ).append("\n"); 
		query.append("        POD_CD            ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_del_cd} != '')" ).append("\n"); 
		query.append("        DEL_CD            ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        SVC_SCP_CD        ," ).append("\n"); 
		query.append("        SUM(OP_CNTR_QTY)  OP_CNTR_QTY ," ).append("\n"); 
		query.append("        /* param */" ).append("\n"); 
		query.append("        '' AS SC_NO                 ," ).append("\n"); 
		query.append("        '' AS VSL_CD                ," ).append("\n"); 
		query.append("        '' AS SKD_VOY_NO            ," ).append("\n"); 
		query.append("        '' AS BL_OBRD_DT_FROM       ," ).append("\n"); 
		query.append("        '' AS BL_OBRD_DT_TO         ," ).append("\n"); 
		query.append("        '' AS SKD_DIR_CD_TXT        ," ).append("\n"); 
		query.append("        '' AS CMDT_HDR_SEQ          ," ).append("\n"); 
		query.append("        '' AS CHK_SLAN_CD           ," ).append("\n"); 
		query.append("        '' AS CHK_VVD               ," ).append("\n"); 
		query.append("        '' AS CHK_GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("        '' AS CHK_CMDT_NM           ," ).append("\n"); 
		query.append("        '' AS CHK_ACT_CUST_NM       ," ).append("\n"); 
		query.append("        '' AS CHK_USA_SVC_MOD_CD    ," ).append("\n"); 
		query.append("        '' AS CHK_POR_CD            ," ).append("\n"); 
		query.append("        '' AS CHK_POL_CD            ," ).append("\n"); 
		query.append("        '' AS CHK_POD_CD            ," ).append("\n"); 
		query.append("        '' AS CHK_DEL_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  TRD_CD            ," ).append("\n"); 
		query.append("                SKD_DIR_CD        ," ).append("\n"); 
		query.append("                SUB_TRD_CD        ," ).append("\n"); 
		query.append("                SLAN_CD           ," ).append("\n"); 
		query.append("                VVD               ," ).append("\n"); 
		query.append("                CMDT_CD           ," ).append("\n"); 
		query.append("                USA_SVC_MOD_CD    ," ).append("\n"); 
		query.append("                POR_CD            ," ).append("\n"); 
		query.append("                POL_CD            ," ).append("\n"); 
		query.append("                POD_CD            ," ).append("\n"); 
		query.append("                DEL_CD            ," ).append("\n"); 
		query.append("                OP_CNTR_QTY       ," ).append("\n"); 
		query.append("                SVC_SCP_CD        ," ).append("\n"); 
		query.append("                GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                CMDT_NM           ," ).append("\n"); 
		query.append("                ACT_CUST_NM" ).append("\n"); 
		query.append("        FROM    R1" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  TRD_CD            ," ).append("\n"); 
		query.append("                SKD_DIR_CD        ," ).append("\n"); 
		query.append("                SUB_TRD_CD        ," ).append("\n"); 
		query.append("                SLAN_CD           ," ).append("\n"); 
		query.append("                VVD               ," ).append("\n"); 
		query.append("                CMDT_CD           ," ).append("\n"); 
		query.append("                USA_SVC_MOD_CD    ," ).append("\n"); 
		query.append("                POR_CD            ," ).append("\n"); 
		query.append("                POL_CD            ," ).append("\n"); 
		query.append("                POD_CD            ," ).append("\n"); 
		query.append("                DEL_CD            ," ).append("\n"); 
		query.append("                OP_CNTR_QTY       ," ).append("\n"); 
		query.append("                NULL  SVC_SCP_CD        ," ).append("\n"); 
		query.append("                NULL  GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("                NULL  CMDT_NM           ," ).append("\n"); 
		query.append("                NULL  ACT_CUST_NM" ).append("\n"); 
		query.append("        FROM    BK" ).append("\n"); 
		query.append("        WHERE   BK_UQ_SEQ NOT IN ( SELECT BK_UQ_SEQ FROM R1 )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("        TRD_CD            ," ).append("\n"); 
		query.append("        SKD_DIR_CD        ," ).append("\n"); 
		query.append("        SUB_TRD_CD        ," ).append("\n"); 
		query.append("        #if (${chk_slan_cd} != '')" ).append("\n"); 
		query.append("        SLAN_CD           ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_vvd} != '')" ).append("\n"); 
		query.append("        VVD               ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_gen_spcl_rt_tp_cd} != '')" ).append("\n"); 
		query.append("        GEN_SPCL_RT_TP_CD ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_cmdt_nm} != '')" ).append("\n"); 
		query.append("        CMDT_NM           ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_act_cust_nm} != '')" ).append("\n"); 
		query.append("        ACT_CUST_NM       ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_usa_svc_mod_cd} != '')" ).append("\n"); 
		query.append("        USA_SVC_MOD_CD    ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_por_cd} != '')" ).append("\n"); 
		query.append("        POR_CD            ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_pol_cd} != '')" ).append("\n"); 
		query.append("        POL_CD            ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_pod_cd} != '')" ).append("\n"); 
		query.append("        POD_CD            ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${chk_del_cd} != '')" ).append("\n"); 
		query.append("        DEL_CD            ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        SVC_SCP_CD" ).append("\n"); 

	}
}