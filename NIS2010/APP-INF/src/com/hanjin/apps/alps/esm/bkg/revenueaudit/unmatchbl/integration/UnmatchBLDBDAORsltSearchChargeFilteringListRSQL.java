/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAORsltSearchChargeFilteringListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.23 
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

public class UnmatchBLDBDAORsltSearchChargeFilteringListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Charge Filtering
	  * </pre>
	  */
	public UnmatchBLDBDAORsltSearchChargeFilteringListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_gso_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bill_type_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bill_type_b",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("auto_rat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bill_type_n",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bill_type_m",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAORsltSearchChargeFilteringListRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("    DENSE_RANK() OVER ( ORDER BY BKG_NO, BKG_CTRT_TP_CD, BKG_RHQ_CD , BKG_OFC_CD , CTRT_NO , POR_CD	, POL_CD , POD_CD ,	DEL_CD , VPS_ETD_DT	 ) BKG_SEQ , -- <--" ).append("\n"); 
		query.append("    COUNT(DISTINCT BKG_NO) OVER () AS BL_CNT," ).append("\n"); 
		query.append("    COUNT(BKG_NO) OVER() AS ROW_CNT," ).append("\n"); 
		query.append("    BKG_RHQ_CD," ).append("\n"); 
		query.append("    BKG_OFC_CD," ).append("\n"); 
		query.append("    BKG_NO," ).append("\n"); 
		query.append("    BL_NO," ).append("\n"); 
		query.append("    BKG_CRE_DT," ).append("\n"); 
		query.append("    RT_APLY_DT," ).append("\n"); 
		query.append("    TO_CHAR(VPS_ETD_DT ,'YYYY-MM-DD') VPS_ETD_DT," ).append("\n"); 
		query.append("    TO_CHAR(VPS_ETA_DT ,'YYYY-MM-DD') VPS_ETA_DT," ).append("\n"); 
		query.append("    VVD," ).append("\n"); 
		query.append("    BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("    BKG_CTRT_TP_NM," ).append("\n"); 
		query.append("    CTRT_NO," ).append("\n"); 
		query.append("    REP_CMDT_CD," ).append("\n"); 
		query.append("    CMDT_CD," ).append("\n"); 
		query.append("    CMDT_NM," ).append("\n"); 
		query.append("    CSTMS_DESC," ).append("\n"); 
		query.append("    DCGO_FLG," ).append("\n"); 
		query.append("    RC_FLG," ).append("\n"); 
		query.append("	AWK_CGO_FLG," ).append("\n"); 
		query.append("    BB_CGO_FLG," ).append("\n"); 
		query.append("    RD_CGO_FLG," ).append("\n"); 
		query.append("    HNGR_FLG," ).append("\n"); 
		query.append("    EQ_SUBST_FLG," ).append("\n"); 
		query.append("    SVC_SCP_CD            ," ).append("\n"); 
		query.append("    POR_CD                ," ).append("\n"); 
		query.append("    POL_CD                ," ).append("\n"); 
		query.append("    POD_CD                ," ).append("\n"); 
		query.append("    DEL_CD                ," ).append("\n"); 
		query.append("    RCV_TERM_CD           ," ).append("\n"); 
		query.append("    DE_TERM_CD            ,  " ).append("\n"); 
		query.append("	REPLACE(S_CUST_NM,CHR(13)||CHR(10),' ') S_CUST_NM		," ).append("\n"); 
		query.append("	REPLACE(C_CUST_NM,CHR(13)||CHR(10),' ') C_CUST_NM		," ).append("\n"); 
		query.append("	REPLACE(N_CUST_NM,CHR(13)||CHR(10),' ') N_CUST_NM		," ).append("\n"); 
		query.append("	CASE " ).append("\n"); 
		query.append("	   WHEN BKG_CTRT_TP_CD = 'S' THEN BKG_GET_TOKEN_FNC(SC_INFO,7,',')" ).append("\n"); 
		query.append("	   WHEN BKG_CTRT_TP_CD = 'R' THEN (SELECT A.CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = BKG_GET_TOKEN_FNC(RF_INFO,3,',') AND A.CUST_SEQ = BKG_GET_TOKEN_FNC(RF_INFO,4,','))" ).append("\n"); 
		query.append("	   WHEN BKG_CTRT_TP_CD = 'T' THEN (SELECT A.CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = BKG_GET_TOKEN_FNC(TA_INFO,3,',') AND A.CUST_SEQ = BKG_GET_TOKEN_FNC(TA_INFO,4,','))" ).append("\n"); 
		query.append("    END CTRT_CUST_NM," ).append("\n"); 
		query.append("    DECODE(BKG_CTRT_TP_CD,'S' ,BKG_GET_TOKEN_FNC(SC_INFO,5,','), 'R', BKG_GET_TOKEN_FNC(RF_INFO,5,','), 'T', BKG_GET_TOKEN_FNC(TA_INFO,5,',')) CTRT_CUST_TP_CD," ).append("\n"); 
		query.append("    CASE " ).append("\n"); 
		query.append("        WHEN BKG_CTRT_TP_CD ='S' THEN  (SELECT  A.INTG_CD_VAL_DP_DESC FROM    COM_INTG_CD_DTL A WHERE A.INTG_CD_ID = 'CD00698' AND A.INTG_CD_VAL_CTNT = BKG_GET_TOKEN_FNC(SC_INFO,6,','))            " ).append("\n"); 
		query.append("        WHEN BKG_CTRT_TP_CD ='R' THEN  (SELECT  A.INTG_CD_VAL_DP_DESC FROM    COM_INTG_CD_DTL A WHERE A.INTG_CD_ID = 'CD00698' AND A.INTG_CD_VAL_CTNT = BKG_GET_TOKEN_FNC(RF_INFO,6,','))" ).append("\n"); 
		query.append("        WHEN BKG_CTRT_TP_CD ='T' THEN  (SELECT  A.INTG_CD_VAL_DP_DESC FROM    COM_INTG_CD_DTL A WHERE A.INTG_CD_ID = 'CD00698' AND A.INTG_CD_VAL_CTNT = BKG_GET_TOKEN_FNC(TA_INFO,6,','))" ).append("\n"); 
		query.append("    ELSE ''" ).append("\n"); 
		query.append("    END CTRT_CUST_VAL_SGM_NM,    " ).append("\n"); 
		query.append("    BDR_FLG               ," ).append("\n"); 
		query.append("    BKG_STS_CD            ," ).append("\n"); 
		query.append("    BKG_STS_NM            ," ).append("\n"); 
		query.append("    SPLIT_FLG             ," ).append("\n"); 
		query.append("    SPLIT_NM              ," ).append("\n"); 
		query.append("    CHARGE_FLG            ," ).append("\n"); 
		query.append("    CHARGE_NM             ," ).append("\n"); 
		query.append("    AUTO_RAT_FLG,       " ).append("\n"); 
		query.append("    ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02131' AND INTG_CD_VAL_CTNT = AUTO_RAT_FLG ) AUTO_RAT_NM  ," ).append("\n"); 
		query.append("    RT_BL_TP_NM," ).append("\n"); 
		query.append("    INR_AUTH_NO," ).append("\n"); 
		query.append("    RATER_ID," ).append("\n"); 
		query.append("    NVL(RDN_NO, ' ')      RDN_NO      ," ).append("\n"); 
		query.append("    NVL(RDN_STS_NM , ' ') RDN_STS_NM  ," ).append("\n"); 
		query.append("	AUTO_RAT_CD," ).append("\n"); 
		query.append("    CHG_CD                ," ).append("\n"); 
		query.append("    CURR_CD               ," ).append("\n"); 
		query.append("    CHG_UT_AMT            ," ).append("\n"); 
		query.append("    RAT_AS_QTY            ," ).append("\n"); 
		query.append("    RAT_UT_CD             ," ).append("\n"); 
		query.append("    CHG_AMT               ," ).append("\n"); 
		query.append("    ERR_BL_CD             ," ).append("\n"); 
		query.append("    ''  SEARCH_DATE       ," ).append("\n"); 
		query.append("    ''  FROM_DT           ," ).append("\n"); 
		query.append("    ''  TO_DT             ," ).append("\n"); 
		query.append("    ''  CARGO_TYPE        ," ).append("\n"); 
		query.append("    ''  BILL_TYPE_N       ," ).append("\n"); 
		query.append("    ''  BILL_TYPE_M       ," ).append("\n"); 
		query.append("    ''  BILL_TYPE_C       ," ).append("\n"); 
		query.append("    ''  BILL_TYPE_B       ," ).append("\n"); 
		query.append("    ''  BKG_CUST_TP_CD    ," ).append("\n"); 
		query.append("    ''  CUST_CNT_CD       ," ).append("\n"); 
		query.append("    ''  CUST_SEQ          ," ).append("\n"); 
		query.append("    ''  CUST_NM           ," ).append("\n"); 
		query.append("    FRT_TERM_CD " ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${search_date} == 'BOOKING')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${search_date} == 'APPL')" ).append("\n"); 
		query.append("	/*+ LEADING(BR) */" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		( SELECT A.OFC_CD FROM MDM_ORGANIZATION A WHERE A.OFC_TP_CD = 'HQ' START WITH A.OFC_CD = BK.BKG_OFC_CD CONNECT BY PRIOR A.PRNT_OFC_CD = A.OFC_CD ) BKG_RHQ_CD , -- param 같이" ).append("\n"); 
		query.append("         BK.BKG_OFC_CD , -- param 같이" ).append("\n"); 
		query.append("         BK.BKG_NO     ," ).append("\n"); 
		query.append("         BK.BL_NO      ," ).append("\n"); 
		query.append("		 TO_CHAR(BK.BKG_CRE_DT, 'YYYY-MM-DD')        AS BKG_CRE_DT ," ).append("\n"); 
		query.append("         TO_CHAR(BR.RT_APLY_DT, 'YYYY-MM-DD')        AS RT_APLY_DT ," ).append("\n"); 
		query.append("		 (" ).append("\n"); 
		query.append("                SELECT /*+ INDEX_ASC(BV XPKBKG_VVD) */ TO_DATE (PS.VPS_ETD_DT)" ).append("\n"); 
		query.append("                FROM    " ).append("\n"); 
		query.append("                        VSK_VSL_PORT_SKD  PS, BKG_VVD BV" ).append("\n"); 
		query.append("                WHERE   PS.VSL_CD       = BV.VSL_CD" ).append("\n"); 
		query.append("                AND     PS.SKD_VOY_NO   = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     PS.SKD_DIR_CD   = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     PS.VPS_PORT_CD  = BV.POL_CD" ).append("\n"); 
		query.append("                AND     PS.CLPT_IND_SEQ = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                AND     BV.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("                AND ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ) VPS_ETD_DT      ," ).append("\n"); 
		query.append("		 (" ).append("\n"); 
		query.append("                SELECT /*+ INDEX_DESC(BV XPKBKG_VVD) */ TO_DATE (PS.VPS_ETA_DT)" ).append("\n"); 
		query.append("                FROM    " ).append("\n"); 
		query.append("                        VSK_VSL_PORT_SKD  PS, BKG_VVD BV" ).append("\n"); 
		query.append("                WHERE   PS.VSL_CD       = BV.VSL_CD" ).append("\n"); 
		query.append("                AND     PS.SKD_VOY_NO   = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     PS.SKD_DIR_CD   = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     PS.VPS_PORT_CD  = BV.POD_CD" ).append("\n"); 
		query.append("                AND     PS.CLPT_IND_SEQ = BV.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                AND     BV.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("                AND ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ) VPS_ETA_DT      ," ).append("\n"); 
		query.append("		( SELECT TRIM(REPLACE(INTG_CD_VAL_DP_DESC, 'B/L', '')) FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01639' AND INTG_CD_VAL_CTNT = BR.RT_BL_TP_CD )  RT_BL_TP_NM ,                " ).append("\n"); 
		query.append("		 BK.CMDT_CD        ," ).append("\n"); 
		query.append("		( SELECT A.CMDT_NM FROM MDM_COMMODITY A WHERE A.CMDT_CD = BK.CMDT_CD )  CMDT_NM ," ).append("\n"); 
		query.append("        C1.CUST_NM  S_CUST_NM ," ).append("\n"); 
		query.append("        C2.CUST_NM  C_CUST_NM ," ).append("\n"); 
		query.append("        C3.CUST_NM  N_CUST_NM ," ).append("\n"); 
		query.append("		 DECODE(BL.BDR_FLG, 'Y', 'Yes', 'No')  BDR_FLG ," ).append("\n"); 
		query.append("		 ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00769' AND INTG_CD_VAL_CTNT = BK.BKG_STS_CD ) BKG_STS_NM  ," ).append("\n"); 
		query.append("         ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02376' AND INTG_CD_VAL_CTNT = DECODE(BK.SPLIT_FLG, NULL, 'N', 'Y', 'S', BK.SPLIT_FLG) ) SPLIT_NM  ," ).append("\n"); 
		query.append("         ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02375' AND INTG_CD_VAL_CTNT = DECODE(BC.BKG_NO, NULL, 'N', 'C') ) CHARGE_NM  ," ).append("\n"); 
		query.append("		 NVL(( SELECT COBIZ_AUTH_NO FROM BKG_BL_DOC WHERE BKG_NO = BK.BKG_NO ),' ') INR_AUTH_NO  ," ).append("\n"); 
		query.append("		 ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01716' AND INTG_CD_VAL_CTNT = BR.BKG_CTRT_TP_CD ) BKG_CTRT_TP_NM," ).append("\n"); 
		query.append("         NVL((SELECT  MAX(RDN_NO) RDN_NO" ).append("\n"); 
		query.append("		      FROM    BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("		      WHERE   BKG_NO = BK.BKG_NO), ' ') AS RDN_NO ," ).append("\n"); 
		query.append("         NVL((SELECT INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("              FROM COM_INTG_CD_DTL, BKG_REV_DR_NOTE A" ).append("\n"); 
		query.append("	          WHERE 1=1" ).append("\n"); 
		query.append("	            AND INTG_CD_ID = 'CD01568'" ).append("\n"); 
		query.append("	            AND INTG_CD_VAL_CTNT = A.RDN_STS_CD" ).append("\n"); 
		query.append("	            AND A.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("	            AND (A.RDN_NO, RVIS_SEQ ) IN  (SELECT RDN_NO, RVIS_SEQ FROM BKG_REV_DR_NOTE K" ).append("\n"); 
		query.append("                                                WHERE K.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                  AND K.CRE_DT = (SELECT MAX(CRE_DT) FROM BKG_REV_DR_NOTE P" ).append("\n"); 
		query.append("                                                                  WHERE 1=1" ).append("\n"); 
		query.append("                                                                    AND P.BKG_NO = K.BKG_NO" ).append("\n"); 
		query.append("                                                                    AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("                ),' ') RDN_STS_NM,  " ).append("\n"); 
		query.append("         BC.AUTO_RAT_CD," ).append("\n"); 
		query.append("         BK.EQ_SUBST_FLG," ).append("\n"); 
		query.append("         BL.CSTMS_DESC," ).append("\n"); 
		query.append("         BK.REP_CMDT_CD,   " ).append("\n"); 
		query.append("        (SELECT  MAX(DECODE(A.AUTO_RAT_CD, 'A', 'A', 'I', 'A', 'M'))" ).append("\n"); 
		query.append("        FROM    BKG_CHG_RT  A" ).append("\n"); 
		query.append("        WHERE   A.BKG_NO    = BK.BKG_NO" ).append("\n"); 
		query.append("        ) AUTO_RAT_FLG    ,   " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("         SELECT  UPD_USR_ID" ).append("\n"); 
		query.append("         FROM    (" ).append("\n"); 
		query.append("                 SELECT  BKG_NO      ," ).append("\n"); 
		query.append("                        UPD_USR_ID  ," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER( PARTITION BY BKG_NO ORDER BY UPD_DT DESC ) ROW_NUMBER" ).append("\n"); 
		query.append("                 FROM    BKG_CHG_RT" ).append("\n"); 
		query.append("                 ) A" ).append("\n"); 
		query.append("         WHERE   A.BKG_NO      = BK.BKG_NO" ).append("\n"); 
		query.append("         AND     A.ROW_NUMBER  = 1" ).append("\n"); 
		query.append("        ) RATER_ID        ," ).append("\n"); 
		query.append("         CASE" ).append("\n"); 
		query.append("         WHEN    BK.TAA_NO IS NOT NULL THEN  BK.TAA_NO" ).append("\n"); 
		query.append("         WHEN    BK.RFA_NO IS NOT NULL THEN  BK.RFA_NO" ).append("\n"); 
		query.append("         ELSE    BK.SC_NO" ).append("\n"); 
		query.append("         END                                         AS CTRT_NO    ," ).append("\n"); 
		query.append("         CASE" ).append("\n"); 
		query.append("            WHEN    BK.TAA_NO IS NOT NULL THEN  'T'" ).append("\n"); 
		query.append("            WHEN    BK.RFA_NO IS NOT NULL THEN  'R'" ).append("\n"); 
		query.append("            ELSE    'S'" ).append("\n"); 
		query.append("         END                                         AS CTRT_TP_CD ," ).append("\n"); 
		query.append("         BK.VSL_CD     , -- param 같이" ).append("\n"); 
		query.append("         BK.SKD_VOY_NO , -- param 같이" ).append("\n"); 
		query.append("         BK.SKD_DIR_CD , -- param 같이" ).append("\n"); 
		query.append("         BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD AS VVD        , -- param 같이" ).append("\n"); 
		query.append("		 BK.DCGO_FLG    ," ).append("\n"); 
		query.append("		 BK.RC_FLG      ," ).append("\n"); 
		query.append("		 BK.AWK_CGO_FLG ," ).append("\n"); 
		query.append("		 BK.BB_CGO_FLG  ," ).append("\n"); 
		query.append("		 BK.RD_CGO_FLG  ," ).append("\n"); 
		query.append("		 BK.HNGR_FLG    ," ).append("\n"); 
		query.append("         BK.RCV_TERM_CD   , -- param 같이" ).append("\n"); 
		query.append("         BK.DE_TERM_CD    , -- param 같이" ).append("\n"); 
		query.append("         BK.POR_CD        , -- param 같이" ).append("\n"); 
		query.append("         BK.POL_CD        , -- param 같이" ).append("\n"); 
		query.append("         BK.POD_CD        , -- param 같이" ).append("\n"); 
		query.append("         BK.DEL_CD        , -- param 같이" ).append("\n"); 
		query.append("         BR.RT_BL_TP_CD ," ).append("\n"); 
		query.append("         (SELECT TRIM(REPLACE(INTG_CD_VAL_DP_DESC, 'B/L', '')) FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01639' AND INTG_CD_VAL_CTNT = BR.RT_BL_TP_CD) AS BL_CVRD_TP_NM ," ).append("\n"); 
		query.append("		 BK.BKG_STS_CD    , -- param 같이" ).append("\n"); 
		query.append("         BC.CHG_CD        , -- param 같이" ).append("\n"); 
		query.append("		 DECODE(BC.CHG_CD , 'OFT' , 'AAA' , 'O/F' , 'AAB' , BC.CHG_CD)	DP_SEQ	," ).append("\n"); 
		query.append("         BC.RAT_UT_CD     ," ).append("\n"); 
		query.append("         BC.CURR_CD       ," ).append("\n"); 
		query.append("         BC.CHG_AMT       ," ).append("\n"); 
		query.append("	     BL.COBIZ_AUTH_NO ," ).append("\n"); 
		query.append("	     BC.CHG_UT_AMT    ," ).append("\n"); 
		query.append("	     BC.RAT_AS_QTY    ," ).append("\n"); 
		query.append("		 NULL AS REP_CHG_CD  , -- param" ).append("\n"); 
		query.append("	     NULL AS SEARCH_DATE , -- param" ).append("\n"); 
		query.append("	     NULL AS FROM_DT     , -- param" ).append("\n"); 
		query.append("	     NULL AS TO_DT       , -- param" ).append("\n"); 
		query.append("         NULL AS RFA_SC_NO   , -- param" ).append("\n"); 
		query.append("		 BK.SVC_SCP_CD       , -- param" ).append("\n"); 
		query.append("		 DECODE(BC.BKG_NO, NULL, 'N', 'C')                       AS CHARGE_FLG , -- param 같이" ).append("\n"); 
		query.append("	     DECODE(BK.SPLIT_FLG, NULL, 'N', 'Y', 'S', BK.SPLIT_FLG) AS SPLIT_FLG , -- param 같이" ).append("\n"); 
		query.append("	     NULL AS CARGO_TYPE  , -- param" ).append("\n"); 
		query.append("	     NULL AS BILL_TYPE_N , -- param  " ).append("\n"); 
		query.append("	     NULL AS BILL_TYPE_M , -- param  " ).append("\n"); 
		query.append("	     NULL AS BILL_TYPE_C , -- param" ).append("\n"); 
		query.append("	     NULL AS BILL_TYPE_B , -- param" ).append("\n"); 
		query.append("		 CASE" ).append("\n"); 
		query.append("         WHEN    BK.TAA_NO IS NOT NULL THEN  'T'" ).append("\n"); 
		query.append("         WHEN    BK.RFA_NO IS NOT NULL THEN  'R'" ).append("\n"); 
		query.append("         ELSE    'S'" ).append("\n"); 
		query.append("         END	 BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("         BC.FRT_TERM_CD," ).append("\n"); 
		query.append("		 (" ).append("\n"); 
		query.append("            SELECT  SH.SC_NO ||','|| SM.AMDT_SEQ ||','|| CP.CUST_CNT_CD ||','|| CP.CUST_SEQ ||','|| CT.PRC_CTRT_CUST_TP_CD ||','|| CP.CTRT_CUST_VAL_SGM_CD ||','|| CP.CTRT_PTY_NM" ).append("\n"); 
		query.append("            FROM    PRI_SP_HDR          SH  ," ).append("\n"); 
		query.append("                    PRI_SP_MN           SM  ," ).append("\n"); 
		query.append("                    PRI_SP_CTRT_PTY     CP  ," ).append("\n"); 
		query.append("                    PRI_SP_CTRT_CUST_TP CT" ).append("\n"); 
		query.append("            WHERE   SM.PROP_NO            = SH.PROP_NO" ).append("\n"); 
		query.append("            AND     SM.PROP_STS_CD        = 'F'" ).append("\n"); 
		query.append("            AND     CP.PROP_NO            = SM.PROP_NO" ).append("\n"); 
		query.append("            AND     CP.AMDT_SEQ           = SM.AMDT_SEQ" ).append("\n"); 
		query.append("            AND     CP.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("            AND     CT.PROP_NO            = CP.PROP_NO" ).append("\n"); 
		query.append("            AND     CT.AMDT_SEQ           = CP.AMDT_SEQ" ).append("\n"); 
		query.append("            AND     CT.PRC_CTRT_PTY_TP_CD = CP.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("            AND     SM.AMDT_SEQ = (SELECT MAX(AMDT_SEQ) FROM PRI_SP_MN WHERE PROP_NO = SM.PROP_NO)" ).append("\n"); 
		query.append("            AND     SH.SC_NO = BK.SC_NO" ).append("\n"); 
		query.append("         ) SC_INFO," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("            SELECT  RH.RFA_NO ||','|| RM.AMDT_SEQ ||','|| RM.CTRT_CUST_CNT_CD ||','|| RM.CTRT_CUST_SEQ ||','|| RM.PRC_CTRT_CUST_TP_CD ||','|| RM.CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("            FROM    PRI_RP_HDR      RH  ," ).append("\n"); 
		query.append("                    PRI_RP_MN       RM" ).append("\n"); 
		query.append("            WHERE   RM.PROP_NO            = RH.PROP_NO" ).append("\n"); 
		query.append("            AND     RM.PROP_STS_CD        = 'A'" ).append("\n"); 
		query.append("            AND     RM.AMDT_SEQ = (SELECT MAX(AMDT_SEQ) FROM PRI_RP_MN WHERE PROP_NO = RM.PROP_NO)" ).append("\n"); 
		query.append("            AND     RH.RFA_NO = BK.RFA_NO" ).append("\n"); 
		query.append("         ) RF_INFO  ," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("            SELECT  TH.TAA_NO ||','|| TM.AMDT_SEQ ||','|| TM.CTRT_CUST_CNT_CD ||','|| TM.CTRT_CUST_SEQ ||','|| TM.PRC_CTRT_CUST_TP_CD ||','|| TM.CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("            FROM    PRI_TAA_HDR     TH  ," ).append("\n"); 
		query.append("                    PRI_TAA_MN      TM" ).append("\n"); 
		query.append("            WHERE   TM.TAA_PROP_NO    = TH.TAA_PROP_NO" ).append("\n"); 
		query.append("            AND     TM.CFM_FLG        = 'Y'" ).append("\n"); 
		query.append("            AND     TM.AMDT_SEQ = (SELECT MAX(AMDT_SEQ) FROM PRI_TAA_MN WHERE TAA_PROP_NO = TM.TAA_PROP_NO) " ).append("\n"); 
		query.append("            AND     TH.TAA_NO = BK.TAA_NO" ).append("\n"); 
		query.append("         ) TA_INFO," ).append("\n"); 
		query.append("         NVL((" ).append("\n"); 
		query.append("            SELECT  DECODE(UB.REV_AUD_STS_CD,'U','Error','S','Settled','')" ).append("\n"); 
		query.append("            FROM    BKG_REV_UMCH_BKG UB" ).append("\n"); 
		query.append("            WHERE   UB.BKG_NO        = BK.BKG_NO" ).append("\n"); 
		query.append("            AND     UB.UMCH_BKG_SEQ  = (SELECT MAX(UMCH_BKG_SEQ) FROM BKG_REV_UMCH_BKG U WHERE U.BKG_NO = UB.BKG_NO)" ).append("\n"); 
		query.append("         ), 'Not Audited') ERR_BL_CD" ).append("\n"); 
		query.append("FROM     BKG_BOOKING BK  " ).append("\n"); 
		query.append("        ,BKG_RATE    BR  " ).append("\n"); 
		query.append("	    ,BKG_BL_DOC  BL  " ).append("\n"); 
		query.append("        ,BKG_CHG_RT  BC   " ).append("\n"); 
		query.append("        ,BKG_CUSTOMER  C1  " ).append("\n"); 
		query.append("        ,BKG_CUSTOMER  C2  " ).append("\n"); 
		query.append("        ,BKG_CUSTOMER  C3   " ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("      	 SELECT	OFC_CD " ).append("\n"); 
		query.append("      	 FROM	MDM_ORGANIZATION A" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("		 WHERE	OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_gso_cd} != '') " ).append("\n"); 
		query.append("      	 START WITH	A.OFC_CD		= @[bkg_gso_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      	 START WITH	A.OFC_CD		= @[bkg_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      	 CONNECT BY	PRIOR A.OFC_CD	= A.PRNT_OFC_CD  " ).append("\n"); 
		query.append("		 ) OG" ).append("\n"); 
		query.append("#if (${search_date} == 'ETD' || ${search_date} == 'ETA')" ).append("\n"); 
		query.append("		,VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("		,BKG_VVD VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE    1=1" ).append("\n"); 
		query.append("#if (${search_date} == 'ETD')" ).append("\n"); 
		query.append("AND      VSK.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("AND      VSK.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND      VSK.SKD_DIR_cD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND      VSK.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("AND      VSK.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND      VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD VVD2 WHERE VVD2.BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${from_dt} != '') " ).append("\n"); 
		query.append("   AND      VSK.VPS_ETD_DT >= TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if (${to_dt} != '') " ).append("\n"); 
		query.append("   AND      VSK.VPS_ETD_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999      /* 0.99999 는 23시 59분 59초를 의미 */" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND      VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${search_date} == 'ETA')" ).append("\n"); 
		query.append("AND      VSK.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("AND      VSK.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND      VSK.SKD_DIR_cD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND      VSK.VPS_PORT_CD = VVD.POD_CD" ).append("\n"); 
		query.append("AND      VSK.CLPT_IND_SEQ = VVD.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND      VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = ( SELECT MAX(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD VVD2 WHERE VVD2.BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${from_dt} != '') " ).append("\n"); 
		query.append("   AND      VSK.VPS_ETA_DT >= TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if (${to_dt} != '') " ).append("\n"); 
		query.append("   AND      VSK.VPS_ETA_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999      /* 0.99999 는 23시 59분 59초를 의미 */" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND      VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND		 BR.BKG_NO 		= BK.BKG_NO" ).append("\n"); 
		query.append("AND		 BL.BKG_NO 		= BK.BKG_NO" ).append("\n"); 
		query.append("AND      BC.BKG_NO	= BR.BKG_NO" ).append("\n"); 
		query.append("AND		 BK.BKG_OFC_CD	= OG.OFC_CD" ).append("\n"); 
		query.append("AND      C1.BKG_NO      = BK.BKG_NO" ).append("\n"); 
		query.append("AND      C1.BKG_CUST_TP_CD  = 'S'" ).append("\n"); 
		query.append("AND      C2.BKG_NO          = BK.BKG_NO" ).append("\n"); 
		query.append("AND      C2.BKG_CUST_TP_CD  = 'C'" ).append("\n"); 
		query.append("AND      C3.BKG_NO          = BK.BKG_NO" ).append("\n"); 
		query.append("AND      C3.BKG_CUST_TP_CD  = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${split_flg} == 'S') " ).append("\n"); 
		query.append("AND      BK.SPLIT_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${split_flg} == 'N')         " ).append("\n"); 
		query.append("AND     (BK.SPLIT_FLG IS NULL OR BK.SPLIT_FLG = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${charge_flg} == 'C') " ).append("\n"); 
		query.append("AND      BC.BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("#elseif(${charge_flg} == 'N') " ).append("\n"); 
		query.append("AND      BC.BKG_NO IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bill_type_n} != '' || ${bill_type_m} != '' || ${bill_type_c} != '' || ${bill_type_b} != '')" ).append("\n"); 
		query.append("AND      BR.RT_BL_TP_CD IN (@[bill_type_n],@[bill_type_m],@[bill_type_c],@[bill_type_b])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND      BC.FRT_INCL_XCLD_DIV_CD(+) = 'N'	-- 고정" ).append("\n"); 
		query.append("AND		 BC.CHG_AMT(+)				<> 0	-- 고정" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${search_date} == 'BKG') " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${from_dt} != '') " ).append("\n"); 
		query.append("	AND      BK.BKG_CRE_DT >= TO_DATE(@[from_dt], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${to_dt} != '')" ).append("\n"); 
		query.append("	AND      BK.BKG_CRE_DT <= TO_DATE (@[to_dt], 'YYYY-MM-DD') + 0.99999      /* 0.99999 는 23시 59분 59초를 의미 */" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${search_date} == 'APPL')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${from_dt} != '') " ).append("\n"); 
		query.append("	AND      BR.RT_APLY_DT >= TO_DATE(@[from_dt], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${to_dt} != '')" ).append("\n"); 
		query.append("	AND      BR.RT_APLY_DT <= TO_DATE (@[to_dt], 'YYYY-MM-DD') + 0.99999      /* 0.99999 는 23시 59분 59초를 의미 */" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${vvd} != '')" ).append("\n"); 
		query.append("	AND     BK.VSL_CD       = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("	AND     BK.SKD_VOY_NO   = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("	AND     BK.SKD_DIR_CD   = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rfa_sc_no} != '')" ).append("\n"); 
		query.append("	AND  CASE" ).append("\n"); 
		query.append("         WHEN    BK.TAA_NO IS NOT NULL THEN  BK.TAA_NO" ).append("\n"); 
		query.append("         WHEN    BK.RFA_NO IS NOT NULL THEN  BK.RFA_NO" ).append("\n"); 
		query.append("         ELSE    BK.SC_NO" ).append("\n"); 
		query.append("         END     = @[rfa_sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("AND      BK.SVC_SCP_CD  = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${por_cd} != '') " ).append("\n"); 
		query.append("AND      BK.POR_CD LIKE @[por_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("AND      BK.POL_CD LIKE @[pol_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("AND      BK.POD_CD LIKE @[pod_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${del_cd} != '') " ).append("\n"); 
		query.append("AND      BK.DEL_CD LIKE @[del_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rep_chg_cd} != '') " ).append("\n"); 
		query.append("AND      ( SELECT A.REP_CHG_CD FROM MDM_CHARGE A WHERE A.CHG_CD = BC.CHG_CD ) = @[rep_chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chg_cd} != '')" ).append("\n"); 
		query.append("			#if (${charge_type} == 'RATED')" ).append("\n"); 
		query.append("						AND BC.CRE_USR_ID = NVL(@[cre_usr_id],BC.CRE_USR_ID)" ).append("\n"); 
		query.append("				#if(${chg_cd1} != '')" ).append("\n"); 
		query.append("					#if(${charge_condition} == 'AND')" ).append("\n"); 
		query.append("						AND EXISTS ( SELECT 'Y' " ).append("\n"); 
		query.append("									 FROM BKG_CHG_RT A " ).append("\n"); 
		query.append("			            			 WHERE A.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("		              				   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("	              					)" ).append("\n"); 
		query.append("						AND EXISTS ( SELECT 'Y' " ).append("\n"); 
		query.append("									 FROM BKG_CHG_RT A " ).append("\n"); 
		query.append("	            					 WHERE A.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("	              					   AND A.CHG_CD = @[chg_cd1]" ).append("\n"); 
		query.append("	            					)" ).append("\n"); 
		query.append("						AND BC.CHG_CD IN ( @[chg_cd] , @[chg_cd1] )" ).append("\n"); 
		query.append("					#elseif(${charge_condition} == 'OR')" ).append("\n"); 
		query.append("						AND EXISTS ( SELECT 'Y' " ).append("\n"); 
		query.append("									 FROM BKG_CHG_RT A " ).append("\n"); 
		query.append("	            					 WHERE A.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("	              			  		   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("	              					 UNION ALL" ).append("\n"); 
		query.append("		            				 SELECT 'Y' " ).append("\n"); 
		query.append("								 	 FROM BKG_CHG_RT A " ).append("\n"); 
		query.append("            					 	 WHERE A.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("              					   	 AND A.CHG_CD = @[chg_cd1]  " ).append("\n"); 
		query.append("              						)" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#elseif(${chg_cd1} == '')" ).append("\n"); 
		query.append("					AND BC.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#elseif (${charge_type} == 'NOTRATED')" ).append("\n"); 
		query.append("				#if(${chg_cd1} != '')" ).append("\n"); 
		query.append("					#if(${charge_condition} == 'AND')" ).append("\n"); 
		query.append("						AND NOT EXISTS ( SELECT 'Y' " ).append("\n"); 
		query.append("										 FROM BKG_CHG_RT A " ).append("\n"); 
		query.append(" 								         WHERE A.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("              							 AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("              							 INTERSECT" ).append("\n"); 
		query.append("            							 SELECT 'Y' " ).append("\n"); 
		query.append("										 FROM BKG_CHG_RT A " ).append("\n"); 
		query.append("            							 WHERE A.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("              							 AND A.CHG_CD = @[chg_cd1] " ).append("\n"); 
		query.append("              							)" ).append("\n"); 
		query.append("					#elseif(${charge_condition} == 'OR')" ).append("\n"); 
		query.append("						AND NOT EXISTS ( SELECT 'Y' " ).append("\n"); 
		query.append("										 FROM BKG_CHG_RT A " ).append("\n"); 
		query.append(" 								         WHERE A.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("              							 AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("              							 UNION ALL" ).append("\n"); 
		query.append("            							 SELECT 'Y' " ).append("\n"); 
		query.append("										 FROM BKG_CHG_RT A " ).append("\n"); 
		query.append("            							 WHERE A.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("              							 AND A.CHG_CD = @[chg_cd1] " ).append("\n"); 
		query.append("              							)" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#elseif(${chg_cd1} == '')" ).append("\n"); 
		query.append("					AND NOT EXISTS ( SELECT 'Y' " ).append("\n"); 
		query.append("								 FROM BKG_CHG_RT A " ).append("\n"); 
		query.append("		            			 WHERE A.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("		         				   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("	           					)" ).append("\n"); 
		query.append("				#end			" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND     BK.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("AND     BR.BKG_CTRT_TP_CD   = @[bkg_ctrt_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} == 'S' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("AND     BK.SC_NO          = @[ctrt_no]" ).append("\n"); 
		query.append("#elseif (${bkg_ctrt_tp_cd} == 'R' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("AND     BK.RFA_NO         = @[ctrt_no]" ).append("\n"); 
		query.append("#elseif (${bkg_ctrt_tp_cd} == 'T' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("AND     BK.TAA_NO         = @[ctrt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} == '' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("AND 	(		BK.SC_NO          = @[ctrt_no]" ).append("\n"); 
		query.append("				OR	BK.RFA_NO         = @[ctrt_no]" ).append("\n"); 
		query.append("				OR	BK.TAA_NO         = @[ctrt_no]" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_cust_tp_cd} == 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("	AND     C1.CUST_CNT_CD  = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_seq} != '')" ).append("\n"); 
		query.append("	AND     C1.CUST_SEQ     = @[cust_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${bkg_cust_tp_cd} == 'C')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("	AND     C2.CUST_CNT_CD  = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_seq} != '')" ).append("\n"); 
		query.append("	AND     C2.CUST_SEQ     = @[cust_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${bkg_cust_tp_cd} == 'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("	AND     C3.CUST_CNT_CD  = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${cust_seq} != '')" ).append("\n"); 
		query.append("	AND     C3.CUST_SEQ     = @[cust_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("AND     BK.CMDT_CD  = @[cmdt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rcv_term_cd} != '') " ).append("\n"); 
		query.append("AND      BK.RCV_TERM_CD = @[rcv_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${de_term_cd} != '') " ).append("\n"); 
		query.append("AND      BK.DE_TERM_CD  = @[de_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* cargo type : DG, RF, AK, BB, RD, HG */" ).append("\n"); 
		query.append("#if (${cargo_type} == 'DG') " ).append("\n"); 
		query.append("AND     BK.DCGO_FLG    = 'Y'" ).append("\n"); 
		query.append("#elseif (${cargo_type} == 'RF') " ).append("\n"); 
		query.append("AND     BK.RC_FLG      = 'Y'" ).append("\n"); 
		query.append("#elseif (${cargo_type} == 'AK') " ).append("\n"); 
		query.append("AND     BK.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${cargo_type} == 'BB') " ).append("\n"); 
		query.append("AND     BK.BB_CGO_FLG  = 'Y'" ).append("\n"); 
		query.append("#elseif (${cargo_type} == 'RD') " ).append("\n"); 
		query.append("AND     BK.RD_CGO_FLG  = 'Y'" ).append("\n"); 
		query.append("#elseif (${cargo_type} == 'HG') " ).append("\n"); 
		query.append("AND     BK.HNGR_FLG    = 'Y'" ).append("\n"); 
		query.append("#elseif (${cargo_type} == 'ST') " ).append("\n"); 
		query.append("AND     BK.STOP_OFF_LOC_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bdr_flg} != '')" ).append("\n"); 
		query.append("AND     BL.BDR_FLG  = @[bdr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_sts_cd} != '') " ).append("\n"); 
		query.append("AND     BK.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${curr_cd} != '')" ).append("\n"); 
		query.append("AND     BC.CURR_CD      = @[curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rat_ut_cd} != '')" ).append("\n"); 
		query.append("AND     BC.RAT_UT_CD      IN ( #foreach(${key} in ${rat_ut_list}) #if($velocityCount != 1) , #end '$key' #end )  -- MULTI" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${auto_rat_flg} != '')" ).append("\n"); 
		query.append("AND     AUTO_RAT_FLG    = @[auto_rat_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_cust_tp_cd} == 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("AND     UPPER(S_CUST_NM)  LIKE '%' || UPPER(@[cust_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${bkg_cust_tp_cd} == 'C')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("AND     UPPER(C_CUST_NM)  LIKE '%' || UPPER(@[cust_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${bkg_cust_tp_cd} == 'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("AND     UPPER(N_CUST_NM)  LIKE '%' || UPPER(@[cust_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${err_bl_cd} == 'S')" ).append("\n"); 
		query.append("AND     ERR_BL_CD = 'Settled'" ).append("\n"); 
		query.append("#elseif (${err_bl_cd} == 'U')" ).append("\n"); 
		query.append("AND     ERR_BL_CD = 'Error'" ).append("\n"); 
		query.append("#elseif (${err_bl_cd} == 'N')" ).append("\n"); 
		query.append("AND     ERR_BL_CD = 'Not Audited'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("BKG_NO		," ).append("\n"); 
		query.append("BKG_CTRT_TP_CD	," ).append("\n"); 
		query.append("BKG_RHQ_CD  ," ).append("\n"); 
		query.append("BKG_OFC_CD  ," ).append("\n"); 
		query.append("CTRT_NO		," ).append("\n"); 
		query.append("POR_CD		," ).append("\n"); 
		query.append("POL_CD		," ).append("\n"); 
		query.append("POD_CD		," ).append("\n"); 
		query.append("DEL_CD		," ).append("\n"); 
		query.append("VPS_ETD_DT	," ).append("\n"); 
		query.append("DP_SEQ" ).append("\n"); 

	}
}