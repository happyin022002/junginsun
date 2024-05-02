/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOsearchRetroactiveBLFilterListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOsearchRetroactiveBLFilterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 소급적용하여 Rating한 BKG Detail Report 조회
	  * </pre>
	  */
	public UnmatchBLDBDAOsearchRetroactiveBLFilterListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtro_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("req_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rtro_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOsearchRetroactiveBLFilterListRSQL").append("\n"); 
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
		query.append("BK AS(" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("	#if (${search_date} == 'APPL')" ).append("\n"); 
		query.append("        /*   +LEADING(BKG_RATE, BKG_BOOKING)*/" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("        (SELECT  OFC_CD " ).append("\n"); 
		query.append("         FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("         WHERE DELT_FLG = 'N' " ).append("\n"); 
		query.append("         AND OFC_TP_CD = 'HQ' " ).append("\n"); 
		query.append("         START WITH OFC_CD = B.BKG_OFC_CD" ).append("\n"); 
		query.append("         CONNECT BY PRIOR PRNT_OFC_CD = OFC_CD) RHQ_CD," ).append("\n"); 
		query.append("        (SELECT  OFC_CD " ).append("\n"); 
		query.append("         FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("         WHERE DELT_FLG = 'N' " ).append("\n"); 
		query.append("         AND OFC_TP_CD = 'HQ' " ).append("\n"); 
		query.append("         START WITH OFC_CD = B.CTRT_OFC_CD" ).append("\n"); 
		query.append("         CONNECT BY PRIOR PRNT_OFC_CD = OFC_CD) CTRT_RHQ_CD," ).append("\n"); 
		query.append("        B.BKG_NO," ).append("\n"); 
		query.append("        B.BKG_OFC_CD," ).append("\n"); 
		query.append("        B.CTRT_OFC_CD," ).append("\n"); 
		query.append("        B.OB_SLS_OFC_CD," ).append("\n"); 
		query.append("        B.OB_SREP_CD," ).append("\n"); 
		query.append("        B.POR_CD, " ).append("\n"); 
		query.append("        B.POL_CD," ).append("\n"); 
		query.append("        B.POD_CD," ).append("\n"); 
		query.append("        B.DEL_CD," ).append("\n"); 
		query.append("        B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD T_VVD," ).append("\n"); 
		query.append("        (SELECT MIN(VPS_ETD_DT)" ).append("\n"); 
		query.append("         FROM BKG_VVD BV, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("         WHERE BV.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("         AND BV.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("         AND BV.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND BV.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND BV.POL_cd = V.VPS_PORT_CD" ).append("\n"); 
		query.append("         AND BV.POL_CLPT_IND_SEQ = V.CLPT_IND_SEQ) ETD_DT," ).append("\n"); 
		query.append("        B.SVC_SCP_CD," ).append("\n"); 
		query.append("        R.BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("        B.RFA_NO, (SELECT PROP_NO FROM PRI_RP_HDR WHERE RFA_NO = B.RFA_NO) RFA_PROP_NO," ).append("\n"); 
		query.append("        B.SC_NO, (SELECT PROP_NO FROM PRI_SP_HDR WHERE SC_NO = B.SC_NO) SC_PROP_NO," ).append("\n"); 
		query.append("        B.TAA_NO, (SELECT PROP_NO FROM PRI_TAA_HDR WHERE TAA_NO = B.TAA_NO) TAA_PROP_NO, " ).append("\n"); 
		query.append("        T.TRF_ITM_NO," ).append("\n"); 
		query.append("        R.RT_APLY_DT," ).append("\n"); 
		query.append("        NVL(T.PROP_NO,  (SELECT PROP_NO FROM BKG_AUTO_RT_HIS WHERE BKG_NO = B.BKG_NO AND CHG_CD = 'OFT' AND ROWNUM =1)) PROP_NO," ).append("\n"); 
		query.append("        NVL(T.AMDT_SEQ, (SELECT AMDT_SEQ FROM BKG_AUTO_RT_HIS WHERE BKG_NO = B.BKG_NO AND CHG_CD = 'OFT'AND ROWNUM =1)) AMDT_SEQ," ).append("\n"); 
		query.append("        T.GEN_SPCL_RT_TP_CD," ).append("\n"); 
		query.append("        NVL(T.CMDT_HDR_SEQ,R.PRC_CMDT_HDR_SEQ) CMDT_HDR_SEQ," ).append("\n"); 
		query.append("        NVL(T.ROUT_SEQ,R.PRC_ROUT_SEQ) ROUT_SEQ," ).append("\n"); 
		query.append("        (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER M WHERE M.CUST_CNT_CD = S.CUST_CNT_CD AND M.CUST_SEQ = S.CUST_SEQ) SHPR_NM," ).append("\n"); 
		query.append("        S.CUST_CNT_CD||LPAD(S.CUST_SEQ,6,0) SHPR," ).append("\n"); 
		query.append("        (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER M WHERE M.CUST_CNT_CD = C.CUST_CNT_CD AND M.CUST_SEQ = C.CUST_SEQ) CNEE_NM," ).append("\n"); 
		query.append("        C.CUST_CNT_CD||LPAD(C.CUST_SEQ,6,0) CNEE," ).append("\n"); 
		query.append("        (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER M WHERE M.CUST_CNT_CD = N.CUST_CNT_CD AND M.CUST_SEQ = N.CUST_SEQ) NTFY_NM," ).append("\n"); 
		query.append("        N.CUST_CNT_CD||LPAD(N.CUST_SEQ,6,0) NTFY" ).append("\n"); 
		query.append("FROM 	BKG_BOOKING B, BKG_RATE R, " ).append("\n"); 
		query.append("#if (${search_date} == 'ETD')" ).append("\n"); 
		query.append("     	VSK_VSL_PORT_SKD VSK, BKG_VVD VVD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     	BKG_CHG_RT T," ).append("\n"); 
		query.append("     	BKG_CUSTOMER S, BKG_CUSTOMER C, BKG_CUSTOMER N," ).append("\n"); 
		query.append("     	(SELECT  OFC_CD" ).append("\n"); 
		query.append("      	 FROM  MDM_ORGANIZATION A" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append(" #if (${bkg_ofc_cd_sub} == 'N')" ).append("\n"); 
		query.append("      WHERE OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("      WHERE OFC_CD IN (SELECT  OFC_CD" ).append("\n"); 
		query.append("                       FROM    MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                       START WITH MO.OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("                       CONNECT BY PRIOR MO.OFC_CD = MO.PRNT_OFC_CD)" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      START WITH  A.OFC_CD    = @[bkg_rhq_cd]" ).append("\n"); 
		query.append("      CONNECT BY  PRIOR A.OFC_CD  = A.PRNT_OFC_CD) O" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("#if (${search_date} == 'ETD')" ).append("\n"); 
		query.append("AND     VSK.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("AND     VSK.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     VSK.SKD_DIR_cD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     VSK.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("AND     VSK.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND     VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD VVD2 WHERE VVD2.BKG_NO = B.BKG_NO)" ).append("\n"); 
		query.append("AND     VSK.VPS_ETD_DT >= TO_DATE(REPLACE(NVL(@[from_dt],'20000101'),'-',''), 'YYYY-MM-DD')  " ).append("\n"); 
		query.append("AND     VSK.VPS_ETD_DT <= TO_DATE(REPLACE(NVL(@[to_dt],'99991231'),'-',''), 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND     VVD.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${search_date} == 'BOOKING')" ).append("\n"); 
		query.append("AND B.BKG_CRE_DT BETWEEN TO_DATE(REPLACE(NVL(@[from_dt],'20000101'),'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(NVL(@[to_dt],'99991231'),'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${search_date} == 'APPL')" ).append("\n"); 
		query.append("AND R.RT_APLY_DT BETWEEN TO_DATE(REPLACE(NVL(@[from_dt],'20000101'),'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(NVL(@[to_dt],'99991231'),'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND B.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_NO = T.BKG_NO" ).append("\n"); 
		query.append("AND T.CHG_CD = 'OFT'" ).append("\n"); 
		query.append("AND B.BKG_STS_CD = 'F'" ).append("\n"); 
		query.append("AND B.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("AND B.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("AND S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND C.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND B.BKG_NO = N.BKG_NO" ).append("\n"); 
		query.append("AND N.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("#if(${ofc_tp_cd} == 'B')" ).append("\n"); 
		query.append("AND B.BKG_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND B.CTRT_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("AND B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("AND B.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND B.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("AND B.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${srep_cd} != '')" ).append("\n"); 
		query.append("AND B.CTRT_SREP_CD = @[srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} == 'S' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("AND B.SC_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#elseif (${bkg_ctrt_tp_cd} == 'R' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("AND B.RFA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#elseif (${bkg_ctrt_tp_cd} == 'T' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("AND B.TAA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_cust_tp_cd} == 'S')" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("	AND     S.CUST_CNT_CD =  @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_seq} != '')" ).append("\n"); 
		query.append("	AND     S.CUST_SEQ     = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${bkg_cust_tp_cd} == 'C')" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("	AND     C.CUST_CNT_CD  = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_seq} != '')" ).append("\n"); 
		query.append("	AND     C.CUST_SEQ     = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${bkg_cust_tp_cd} == 'N')" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("	AND     N.CUST_CNT_CD  = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_seq} != '')" ).append("\n"); 
		query.append("	AND     N.CUST_SEQ     = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  BK.RHQ_CD, bk.prop_no," ).append("\n"); 
		query.append("        BK.BKG_OFC_CD," ).append("\n"); 
		query.append("        BK.CTRT_RHQ_CD," ).append("\n"); 
		query.append("        BK.CTRT_OFC_CD," ).append("\n"); 
		query.append("        BK.OB_SLS_OFC_CD," ).append("\n"); 
		query.append("        BK.OB_SREP_CD," ).append("\n"); 
		query.append("        BK.BKG_NO," ).append("\n"); 
		query.append("        BK.T_VVD," ).append("\n"); 
		query.append("        TO_CHAR(BK.ETD_DT, 'YYYY-MM-DD') ETD_DT," ).append("\n"); 
		query.append("        TO_CHAR(BK.RT_APLY_DT, 'YYYY-MM-DD') RT_APLY_DT," ).append("\n"); 
		query.append("        TO_CHAR(PR.ACPT_DT, 'YYYY-MM-DD') RT_ACPT_DT," ).append("\n"); 
		query.append("        TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD)), 'YYYY-MM-DD') CONV_ACPT_DT," ).append("\n"); 
		query.append("        TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) - BK.RT_APLY_DT DAY_DIFF," ).append("\n"); 
		query.append("        (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID = 'CD01716'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = BK.BKG_CTRT_TP_CD) CTRT_TP," ).append("\n"); 
		query.append("        BK.RFA_NO CTRT_NO," ).append("\n"); 
		query.append("        BK.AMDT_SEQ," ).append("\n"); 
		query.append("        TO_CHAR(RM.CRE_DT, 'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("        TO_CHAR(MAX(RQ.PROG_DT), 'YYYY-MM-DD') REQ_DT," ).append("\n"); 
		query.append("        TO_CHAR(RS.EFF_DT, 'YYYY-MM-DD') EFF_DT," ).append("\n"); 
		query.append("        TO_CHAR(RS.EXP_DT, 'YYYY-MM-DD') EXP_DT," ).append("\n"); 
		query.append("        TO_CHAR(RM.PROP_APRO_DT, 'YYYY-MM-DD') APRO_DT," ).append("\n"); 
		query.append("        '' FILE_DT," ).append("\n"); 
		query.append("        RM.PROP_OFC_CD REQ_OFC," ).append("\n"); 
		query.append("        RM.PROP_SREP_CD REQ_SREP," ).append("\n"); 
		query.append("        RM.PROP_APRO_OFC_CD APRO_OFC," ).append("\n"); 
		query.append("        SUBSTR(MAX(TO_CHAR(RA.PROG_DT, 'YYYY-MM-DD')||RA.PROG_USR_ID), 11) APRO_USR," ).append("\n"); 
		query.append("        BK.SVC_SCP_CD," ).append("\n"); 
		query.append("        BK.POR_CD, " ).append("\n"); 
		query.append("        BK.POL_CD," ).append("\n"); 
		query.append("        BK.POD_CD," ).append("\n"); 
		query.append("        BK.DEL_CD," ).append("\n"); 
		query.append("        SHPR, SHPR_NM," ).append("\n"); 
		query.append("        CNEE, CNEE_NM," ).append("\n"); 
		query.append("        NTFY, NTFY_NM," ).append("\n"); 
		query.append("        (SELECT MC.CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("         FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("         WHERE RM.CTRT_CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("         AND RM.CTRT_CUST_SEQ = MC.CUST_SEQ) CTRT_PTY_NM," ).append("\n"); 
		query.append("        COUNT (DISTINCT BK.BKG_NO) OVER (PARTITION BY 1) BKG_CNT," ).append("\n"); 
		query.append("        COUNT (DISTINCT BK.RFA_NO||BK.AMDT_SEQ) OVER (PARTITION BY 1) CTRT_CNT" ).append("\n"); 
		query.append("FROM BK, PRI_RP_MN RM, PRI_RP_SCP_MN RS, pri_rp_scp_rt PR," ).append("\n"); 
		query.append("      PRI_RP_PROG RA, PRI_RP_PROG RQ" ).append("\n"); 
		query.append("WHERE BK.BKG_CTRT_TP_CD = 'R'" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("AND @[bkg_ctrt_tp_cd] = 'R'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("AND BK.RFA_PROP_NO = RM.PROP_NO" ).append("\n"); 
		query.append("AND BK.AMDT_SEQ = RM.AMDT_SEQ" ).append("\n"); 
		query.append("AND RM.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("AND RM.PROP_NO = RS.PROP_NO" ).append("\n"); 
		query.append("AND RM.AMDT_SEQ = RS.AMDT_SEQ" ).append("\n"); 
		query.append("AND RS.SVC_SCP_CD = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("AND RS.PROP_NO  = RA.PROP_NO" ).append("\n"); 
		query.append("AND RS.AMDT_SEQ =RA.AMDT_SEQ" ).append("\n"); 
		query.append("AND RA.PROP_STS_CD   = 'A'" ).append("\n"); 
		query.append("AND RS.PROP_NO  = RQ.PROP_NO" ).append("\n"); 
		query.append("AND RS.AMDT_SEQ =RQ.AMDT_SEQ" ).append("\n"); 
		query.append("AND RQ.PROP_STS_CD   = 'Q'" ).append("\n"); 
		query.append("AND BK.PROP_NO = PR.PROP_NO" ).append("\n"); 
		query.append("AND BK.AMDT_SEQ = PR.AMDT_SEQ" ).append("\n"); 
		query.append("AND BK.SVC_SCP_CD = PR.SVC_SCP_CD" ).append("\n"); 
		query.append("AND BK.CMDT_HDR_SEQ = PR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND BK.ROUT_SEQ = PR.ROUT_SEQ" ).append("\n"); 
		query.append("AND TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) > BK.RT_APLY_DT" ).append("\n"); 
		query.append("AND PR.RAT_UT_CD IN (SELECT CNTR_TPSZ_CD FROM BKG_QUANTITY WHERE BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("#if (${apro_ofc_cd} != '')" ).append("\n"); 
		query.append("AND RM.PROP_APRO_OFC_CD = @[apro_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${req_ofc_cd} != '')" ).append("\n"); 
		query.append("AND RM.PROP_OFC_CD = @[req_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${retroact_day} != 'W0')" ).append("\n"); 
		query.append("AND TO_NUMBER(NVL(TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',PR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(PR.ACPT_OFC_CD))) - BK.RT_APLY_DT,0)) BETWEEN TO_NUMBER(NVL(@[rtro_fm_dt],1)) AND TO_NUMBER(NVL(@[rtro_to_dt],7))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY BK.RHQ_CD, bk.prop_no," ).append("\n"); 
		query.append("        BK.BKG_OFC_CD," ).append("\n"); 
		query.append("        BK.CTRT_RHQ_CD," ).append("\n"); 
		query.append("        BK.CTRT_OFC_CD," ).append("\n"); 
		query.append("        BK.OB_SLS_OFC_CD," ).append("\n"); 
		query.append("        BK.OB_SREP_CD," ).append("\n"); 
		query.append("        BK.BKG_NO," ).append("\n"); 
		query.append("        BK.T_VVD," ).append("\n"); 
		query.append("        TO_CHAR(BK.ETD_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("        BK.RT_APLY_DT," ).append("\n"); 
		query.append("        PR.ACPT_DT, " ).append("\n"); 
		query.append("        PR.ACPT_OFC_CD, " ).append("\n"); 
		query.append("        BK.BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("        BK.RFA_NO," ).append("\n"); 
		query.append("        BK.AMDT_SEQ," ).append("\n"); 
		query.append("        TO_CHAR(RM.CRE_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("        TO_CHAR(RS.EFF_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("        TO_CHAR(RS.EXP_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("        TO_CHAR(RM.PROP_APRO_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("        RM.PROP_OFC_CD," ).append("\n"); 
		query.append("        RM.PROP_SREP_CD," ).append("\n"); 
		query.append("        RM.PROP_APRO_OFC_CD," ).append("\n"); 
		query.append("        BK.SVC_SCP_CD," ).append("\n"); 
		query.append("        BK.POR_CD, " ).append("\n"); 
		query.append("        BK.POL_CD," ).append("\n"); 
		query.append("        BK.POD_CD," ).append("\n"); 
		query.append("        BK.DEL_CD," ).append("\n"); 
		query.append("        SHPR, SHPR_NM," ).append("\n"); 
		query.append("        CNEE, CNEE_NM," ).append("\n"); 
		query.append("        NTFY, NTFY_NM," ).append("\n"); 
		query.append("        RM.CTRT_CUST_CNT_CD," ).append("\n"); 
		query.append("        RM.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  BK.RHQ_CD, bk.prop_no," ).append("\n"); 
		query.append("        BK.BKG_OFC_CD," ).append("\n"); 
		query.append("        BK.CTRT_RHQ_CD," ).append("\n"); 
		query.append("        BK.CTRT_OFC_CD," ).append("\n"); 
		query.append("        BK.OB_SLS_OFC_CD," ).append("\n"); 
		query.append("        BK.OB_SREP_CD," ).append("\n"); 
		query.append("        BK.BKG_NO," ).append("\n"); 
		query.append("        BK.T_VVD," ).append("\n"); 
		query.append("        TO_CHAR(BK.ETD_DT, 'YYYY-MM-DD') ETD_DT," ).append("\n"); 
		query.append("        TO_CHAR(BK.RT_APLY_DT, 'YYYY-MM-DD') RT_APLY_DT," ).append("\n"); 
		query.append("        TO_CHAR(SR.ACPT_DT, 'YYYY-MM-DD') RT_ACPT_DT," ).append("\n"); 
		query.append("        TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD)), 'YYYY-MM-DD') CONV_ACPT_DT," ).append("\n"); 
		query.append("        TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) - BK.RT_APLY_DT DAY_DIFF," ).append("\n"); 
		query.append("        (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID = 'CD01716'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = BK.BKG_CTRT_TP_CD) CTRT_TP," ).append("\n"); 
		query.append("        BK.SC_NO CTRT_NO," ).append("\n"); 
		query.append("        BK.AMDT_SEQ," ).append("\n"); 
		query.append("        TO_CHAR(SM.CRE_DT, 'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("        TO_CHAR(MAX(SQ.PROG_DT), 'YYYY-MM-DD') REQ_DT," ).append("\n"); 
		query.append("        TO_CHAR(SS.EFF_DT, 'YYYY-MM-DD') EFF_DT," ).append("\n"); 
		query.append("        TO_CHAR(SS.EXP_DT, 'YYYY-MM-DD') EXP_DT," ).append("\n"); 
		query.append("        TO_CHAR(SM.PROP_APRO_DT, 'YYYY-MM-DD') APRO_DT," ).append("\n"); 
		query.append("        TO_CHAR(SM.FILE_DT, 'YYYY-MM-DD') FILE_DT," ).append("\n"); 
		query.append("        SM.PROP_OFC_CD REQ_OFC," ).append("\n"); 
		query.append("        SM.PROP_SREP_CD REQ_SREP," ).append("\n"); 
		query.append("        SM.PROP_APRO_OFC_CD APRO_OFC," ).append("\n"); 
		query.append("        SUBSTR(MAX(TO_CHAR(SA.PROG_DT, 'YYYY-MM-DD')||SA.PROG_USR_ID), 11) APRO_USR," ).append("\n"); 
		query.append("        BK.SVC_SCP_CD," ).append("\n"); 
		query.append("        BK.POR_CD, " ).append("\n"); 
		query.append("        BK.POL_CD," ).append("\n"); 
		query.append("        BK.POD_CD," ).append("\n"); 
		query.append("        BK.DEL_CD," ).append("\n"); 
		query.append("        SHPR, SHPR_NM," ).append("\n"); 
		query.append("        CNEE, CNEE_NM," ).append("\n"); 
		query.append("        NTFY, NTFY_NM," ).append("\n"); 
		query.append("       (SELECT CTRT_PTY_NM" ).append("\n"); 
		query.append("        FROM PRI_SP_CTRT_PTY SC" ).append("\n"); 
		query.append("        WHERE SC.PROP_NO = SM.PROP_NO" ).append("\n"); 
		query.append("        AND SC.AMDT_SEQ = SM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND SC.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("        AND ROWNUM = 1) CTRT_PTY_NM," ).append("\n"); 
		query.append("        COUNT (DISTINCT BK.BKG_NO) OVER (PARTITION BY 1) BKG_CNT," ).append("\n"); 
		query.append("        COUNT (DISTINCT BK.SC_NO||BK.AMDT_SEQ) OVER (PARTITION BY 1) CTRT_CNT" ).append("\n"); 
		query.append("FROM BK, PRI_SP_MN SM, PRI_SP_SCP_MN SS, PRI_SP_SCP_RT SR," ).append("\n"); 
		query.append("      PRI_SP_PROG SA, PRI_SP_PROG SQ" ).append("\n"); 
		query.append("WHERE BK.BKG_CTRT_TP_CD = 'S'" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("AND @[bkg_ctrt_tp_cd] = 'S'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("AND BK.SC_PROP_NO = SM.PROP_NO" ).append("\n"); 
		query.append("AND BK.AMDT_SEQ = SM.AMDT_SEQ" ).append("\n"); 
		query.append("AND SM.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("AND SM.PROP_NO = SS.PROP_NO" ).append("\n"); 
		query.append("AND SM.AMDT_SEQ = SS.AMDT_SEQ" ).append("\n"); 
		query.append("AND SS.SVC_SCP_CD = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("AND SS.PROP_NO  = SA.PROP_NO" ).append("\n"); 
		query.append("AND SS.AMDT_SEQ =SA.AMDT_SEQ" ).append("\n"); 
		query.append("AND SA.PROP_STS_CD   = 'A'" ).append("\n"); 
		query.append("AND SS.PROP_NO  = SQ.PROP_NO" ).append("\n"); 
		query.append("AND SS.AMDT_SEQ =SQ.AMDT_SEQ" ).append("\n"); 
		query.append("AND SQ.PROP_STS_CD   = 'Q'" ).append("\n"); 
		query.append("AND BK.PROP_NO = SR.PROP_NO" ).append("\n"); 
		query.append("AND BK.AMDT_SEQ = SR.AMDT_SEQ" ).append("\n"); 
		query.append("AND BK.SVC_SCP_CD = SR.SVC_SCP_CD" ).append("\n"); 
		query.append("AND BK.GEN_SPCL_RT_TP_CD = SR.GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("AND BK.CMDT_HDR_SEQ = SR.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND BK.ROUT_SEQ = SR.ROUT_SEQ" ).append("\n"); 
		query.append("AND TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) > BK.RT_APLY_DT" ).append("\n"); 
		query.append("AND SR.RAT_UT_CD IN (SELECT CNTR_TPSZ_CD FROM BKG_QUANTITY WHERE BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("#if (${apro_ofc_cd} != '')" ).append("\n"); 
		query.append("AND SM.PROP_APRO_OFC_CD = @[apro_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${req_ofc_cd} != '')" ).append("\n"); 
		query.append("AND SM.PROP_OFC_CD = @[req_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${retroact_day} != 'W0')" ).append("\n"); 
		query.append("AND TO_NUMBER(NVL(TRUNC(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SR.ACPT_DT,GLOBALDATE_PKG.GET_LOCCD_FNC(SR.ACPT_OFC_CD))) - BK.RT_APLY_DT,0)) BETWEEN TO_NUMBER(NVL(@[rtro_fm_dt],1)) AND TO_NUMBER(NVL(@[rtro_to_dt],7))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY BK.RHQ_CD, bk.prop_no," ).append("\n"); 
		query.append("        BK.BKG_OFC_CD," ).append("\n"); 
		query.append("        BK.CTRT_RHQ_CD," ).append("\n"); 
		query.append("        BK.CTRT_OFC_CD," ).append("\n"); 
		query.append("        BK.OB_SLS_OFC_CD," ).append("\n"); 
		query.append("        BK.OB_SREP_CD," ).append("\n"); 
		query.append("        BK.BKG_NO," ).append("\n"); 
		query.append("        BK.T_VVD," ).append("\n"); 
		query.append("        TO_CHAR(BK.ETD_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("        BK.RT_APLY_DT," ).append("\n"); 
		query.append("        SR.ACPT_DT," ).append("\n"); 
		query.append("        SR.ACPT_OFC_CD," ).append("\n"); 
		query.append("        BK.BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("        BK.SC_NO," ).append("\n"); 
		query.append("        BK.AMDT_SEQ," ).append("\n"); 
		query.append("        TO_CHAR(SM.CRE_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("        TO_CHAR(SS.EFF_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("        TO_CHAR(SS.EXP_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("        TO_CHAR(SM.PROP_APRO_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("        TO_CHAR(SM.FILE_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("        SM.PROP_OFC_CD," ).append("\n"); 
		query.append("        SM.PROP_SREP_CD," ).append("\n"); 
		query.append("        SM.PROP_APRO_OFC_CD," ).append("\n"); 
		query.append("        BK.SVC_SCP_CD," ).append("\n"); 
		query.append("        BK.POR_CD, " ).append("\n"); 
		query.append("        BK.POL_CD," ).append("\n"); 
		query.append("        BK.POD_CD," ).append("\n"); 
		query.append("        BK.DEL_CD," ).append("\n"); 
		query.append("        SHPR, SHPR_NM," ).append("\n"); 
		query.append("        CNEE, CNEE_NM," ).append("\n"); 
		query.append("        NTFY, NTFY_NM," ).append("\n"); 
		query.append("        SM.PROP_NO," ).append("\n"); 
		query.append("        SM.AMDT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  DISTINCT BK.RHQ_CD, bk.prop_no, " ).append("\n"); 
		query.append("        BK.BKG_OFC_CD," ).append("\n"); 
		query.append("        BK.CTRT_RHQ_CD," ).append("\n"); 
		query.append("        BK.CTRT_OFC_CD," ).append("\n"); 
		query.append("        BK.OB_SLS_OFC_CD," ).append("\n"); 
		query.append("        BK.OB_SREP_CD," ).append("\n"); 
		query.append("        BK.BKG_NO," ).append("\n"); 
		query.append("        BK.T_VVD," ).append("\n"); 
		query.append("        TO_CHAR(BK.ETD_DT, 'YYYY-MM-DD') ETD_DT," ).append("\n"); 
		query.append("        TO_CHAR(BK.RT_APLY_DT, 'YYYY-MM-DD') RT_APLY_DT," ).append("\n"); 
		query.append("        TO_CHAR(NVL(TM.CFM_DT,TM.UPD_DT), 'YYYY-MM-DD') RT_ACPT_DT," ).append("\n"); 
		query.append("        TO_CHAR(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT), 'YYYY-MM-DD') CONV_ACPT_DT," ).append("\n"); 
		query.append("        TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) - BK.RT_APLY_DT DAY_DIFF," ).append("\n"); 
		query.append("        (SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID = 'CD01716'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = BK.BKG_CTRT_TP_CD) CTRT_TP," ).append("\n"); 
		query.append("        BK.TAA_NO CTRT_NO," ).append("\n"); 
		query.append("        BK.AMDT_SEQ," ).append("\n"); 
		query.append("        TO_CHAR(TM.CRE_DT, 'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("        '' REQ_DT," ).append("\n"); 
		query.append("        TO_CHAR(TR.EFF_DT, 'YYYY-MM-DD') EFF_DT," ).append("\n"); 
		query.append("        TO_CHAR(TR.EXP_DT, 'YYYY-MM-DD') EXP_DT," ).append("\n"); 
		query.append("        '' APRO_DT," ).append("\n"); 
		query.append("        '' FILE_DT," ).append("\n"); 
		query.append("        TR.TRI_RQST_OFC_CD REQ_OFC," ).append("\n"); 
		query.append("        TR.TRI_RQST_USR_ID REQ_SREP," ).append("\n"); 
		query.append("        TR.TRI_APRO_OFC_CD APRO_OFC," ).append("\n"); 
		query.append("        TR.TRI_APRO_USR_ID APRO_USR," ).append("\n"); 
		query.append("        BK.SVC_SCP_CD," ).append("\n"); 
		query.append("        BK.POR_CD, " ).append("\n"); 
		query.append("        BK.POL_CD," ).append("\n"); 
		query.append("        BK.POD_CD," ).append("\n"); 
		query.append("        BK.DEL_CD," ).append("\n"); 
		query.append("        SHPR, SHPR_NM," ).append("\n"); 
		query.append("        CNEE, CNEE_NM," ).append("\n"); 
		query.append("        NTFY, NTFY_NM," ).append("\n"); 
		query.append("        (SELECT MC.CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("         FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("         WHERE TM.CTRT_CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("         AND TM.CTRT_CUST_SEQ = MC.CUST_SEQ) CTRT_PTY_NM," ).append("\n"); 
		query.append("        COUNT (DISTINCT BK.BKG_NO) OVER (PARTITION BY 1) BKG_CNT," ).append("\n"); 
		query.append("        COUNT (DISTINCT BK.TAA_NO||BK.AMDT_SEQ) OVER (PARTITION BY 1) CTRT_CNT" ).append("\n"); 
		query.append("FROM BK, PRI_TAA_MN TM, PRI_TAA_TRI_LIST TL, PRI_TRI_MN TT, PRI_TRI_RT TR" ).append("\n"); 
		query.append("WHERE BK.BKG_CTRT_TP_CD = 'T'" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("AND @[bkg_ctrt_tp_cd] = 'T'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("AND BK.TAA_PROP_NO = TM.TAA_PROP_NO" ).append("\n"); 
		query.append("AND BK.AMDT_SEQ = TM.AMDT_SEQ" ).append("\n"); 
		query.append("AND BK.RT_APLY_DT BETWEEN TR.EFF_DT AND TR.EXP_DT" ).append("\n"); 
		query.append("AND TM.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("AND TM.TAA_PROP_NO = TL.TAA_PROP_NO" ).append("\n"); 
		query.append("AND TM.AMDT_SEQ = TL.AMDT_SEQ" ).append("\n"); 
		query.append("AND TL.TRI_PROP_NO = TT.TRI_PROP_NO" ).append("\n"); 
		query.append("AND TT.TRI_NO = BK.TRF_ITM_NO" ).append("\n"); 
		query.append("AND TL.TRI_PROP_NO = TR.TRI_PROP_NO " ).append("\n"); 
		query.append("AND TR.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("AND TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) > BK.RT_APLY_DT" ).append("\n"); 
		query.append("AND TR.RAT_UT_CD IN (SELECT CNTR_TPSZ_CD FROM BKG_QUANTITY WHERE BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("#if (${apro_ofc_cd} != '')" ).append("\n"); 
		query.append("AND TM.APRO_OFC = @[apro_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${req_ofc_cd} != '')" ).append("\n"); 
		query.append("AND TM.REQ_OFC = @[req_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${retroact_day} != 'W0')" ).append("\n"); 
		query.append("AND TO_NUMBER(NVL(TRUNC(NVL(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',TM.CFM_DT,BK.POL_CD),TM.UPD_DT)) - BK.RT_APLY_DT,0)) BETWEEN TO_NUMBER(NVL(@[rtro_fm_dt],1)) AND TO_NUMBER(NVL(@[rtro_to_dt],7))" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}