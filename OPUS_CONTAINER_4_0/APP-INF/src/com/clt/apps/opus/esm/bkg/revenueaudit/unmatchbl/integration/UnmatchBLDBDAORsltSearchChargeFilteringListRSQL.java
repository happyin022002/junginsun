/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAORsltSearchChargeFilteringListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bill_type_n",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bill_type_m",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usa_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
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
		query.append("SELECT  DENSE_RANK() OVER ( ORDER BY BKG_NO, BKG_CTRT_TP_CD, BKG_RHQ_CD , BKG_OFC_CD , CTRT_NO , POR_CD	, POL_CD , POD_CD ,	DEL_CD , VPS_ETD_DT	 ) BKG_SEQ ," ).append("\n"); 
		query.append("        BKG_RHQ_CD            ," ).append("\n"); 
		query.append("        BKG_OFC_CD            ," ).append("\n"); 
		query.append("        BKG_NO                ," ).append("\n"); 
		query.append("        BL_NO                 ," ).append("\n"); 
		query.append("        BKG_CRE_DT            ," ).append("\n"); 
		query.append("        RT_APLY_DT            ," ).append("\n"); 
		query.append("        TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD') VPS_ETD_DT  ," ).append("\n"); 
		query.append("        VVD                   ," ).append("\n"); 
		query.append("        BKG_CTRT_TP_CD        ," ).append("\n"); 
		query.append("        BKG_CTRT_TP_NM        ," ).append("\n"); 
		query.append("        CTRT_NO               ," ).append("\n"); 
		query.append("        REP_CMDT_CD           ," ).append("\n"); 
		query.append("        CMDT_CD               ," ).append("\n"); 
		query.append("        CMDT_NM               ," ).append("\n"); 
		query.append("        CSTMS_DESC            ," ).append("\n"); 
		query.append("        DCGO_FLG              ," ).append("\n"); 
		query.append("        DECODE(DCGO_FLG     , 'Y', 'BOLD=''TRUE'';COLOR=''BLUE'';')  DCGO_FLG_PROP     ," ).append("\n"); 
		query.append("        RC_FLG                ," ).append("\n"); 
		query.append("        DECODE(RC_FLG       , 'Y', 'BOLD=''TRUE'';COLOR=''BLUE'';')  RC_FLG_PROP       ," ).append("\n"); 
		query.append("        AWK_CGO_FLG           ," ).append("\n"); 
		query.append("        DECODE(AWK_CGO_FLG  , 'Y', 'BOLD=''TRUE'';COLOR=''BLUE'';')  AWK_CGO_FLG_PROP  ," ).append("\n"); 
		query.append("        BB_CGO_FLG            ," ).append("\n"); 
		query.append("        DECODE(BB_CGO_FLG   , 'Y', 'BOLD=''TRUE'';COLOR=''BLUE'';')  BB_CGO_FLG_PROP   ," ).append("\n"); 
		query.append("        RD_CGO_FLG            ," ).append("\n"); 
		query.append("        DECODE(RD_CGO_FLG   , 'Y', 'BOLD=''TRUE'';COLOR=''BLUE'';')  RD_CGO_FLG_PROP   ," ).append("\n"); 
		query.append("        HNGR_FLG              ," ).append("\n"); 
		query.append("        DECODE(HNGR_FLG     , 'Y', 'BOLD=''TRUE'';COLOR=''BLUE'';')  HNGR_FLG_PROP     ," ).append("\n"); 
		query.append("        EQ_SUBST_FLG          ," ).append("\n"); 
		query.append("        DECODE(EQ_SUBST_FLG , 'Y', 'BOLD=''TRUE'';COLOR=''BLUE'';')  EQ_SUBST_FLG_PROP ," ).append("\n"); 
		query.append("        SVC_SCP_CD            ," ).append("\n"); 
		query.append("        POR_CD                ," ).append("\n"); 
		query.append("        POL_CD                ," ).append("\n"); 
		query.append("        POD_CD                ," ).append("\n"); 
		query.append("        DEL_CD                ," ).append("\n"); 
		query.append("        RCV_TERM_CD           ," ).append("\n"); 
		query.append("        DE_TERM_CD            ," ).append("\n"); 
		query.append("        USA_SVC_MOD_CD        ," ).append("\n"); 
		query.append("        ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02286' AND INTG_CD_VAL_CTNT = T.USA_SVC_MOD_CD ) USA_SVC_MOD_NM  ," ).append("\n"); 
		query.append("		REPLACE(S_CUST_NM,CHR(10),' ') S_CUST_NM		," ).append("\n"); 
		query.append("		REPLACE(C_CUST_NM,CHR(10),' ') C_CUST_NM		," ).append("\n"); 
		query.append("		REPLACE(N_CUST_NM,CHR(10),' ') N_CUST_NM		," ).append("\n"); 
		query.append("        CTRT_CUST_NM          ," ).append("\n"); 
		query.append("        CTRT_CUST_TP_CD       ," ).append("\n"); 
		query.append("        CTRT_CUST_VAL_SGM_NM  ," ).append("\n"); 
		query.append("        BDR_FLG               ," ).append("\n"); 
		query.append("        BKG_STS_CD            ," ).append("\n"); 
		query.append("        BKG_STS_NM            ," ).append("\n"); 
		query.append("        SPLIT_FLG             ," ).append("\n"); 
		query.append("        SPLIT_NM              ," ).append("\n"); 
		query.append("        CHARGE_FLG            ," ).append("\n"); 
		query.append("        CHARGE_NM             ," ).append("\n"); 
		query.append("        AUTO_RAT_FLG          ," ).append("\n"); 
		query.append("        ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02131' AND INTG_CD_VAL_CTNT = T.AUTO_RAT_FLG ) AUTO_RAT_NM  ," ).append("\n"); 
		query.append("        RT_BL_TP_CD           ," ).append("\n"); 
		query.append("        RT_BL_TP_NM           ," ).append("\n"); 
		query.append("		NVL(( SELECT COBIZ_AUTH_NO FROM BKG_BL_DOC WHERE BKG_NO = T.BKG_NO ),' ') INR_AUTH_NO  ," ).append("\n"); 
		query.append("        RATER_ID              ," ).append("\n"); 
		query.append("        NVL(RDN_NO, ' ')      RDN_NO      ," ).append("\n"); 
		query.append("        NVL(RDN_STS_NM , ' ') RDN_STS_NM  ," ).append("\n"); 
		query.append("        CHG_CD                ," ).append("\n"); 
		query.append("        CURR_CD               ," ).append("\n"); 
		query.append("        CHG_UT_AMT            ," ).append("\n"); 
		query.append("        RAT_AS_QTY            ," ).append("\n"); 
		query.append("        RAT_UT_CD             ," ).append("\n"); 
		query.append("        CHG_AMT               ," ).append("\n"); 
		query.append("        AUTO_RAT_CD           ," ).append("\n"); 
		query.append("        ''  SEARCH_DATE       ," ).append("\n"); 
		query.append("        ''  FROM_DT           ," ).append("\n"); 
		query.append("        ''  TO_DT             ," ).append("\n"); 
		query.append("        ''  CARGO_TYPE        ," ).append("\n"); 
		query.append("        ''  BILL_TYPE_N       ," ).append("\n"); 
		query.append("        ''  BILL_TYPE_M       ," ).append("\n"); 
		query.append("        ''  BILL_TYPE_C       ," ).append("\n"); 
		query.append("        ''  BILL_TYPE_B       ," ).append("\n"); 
		query.append("        ''  BKG_CUST_TP_CD    ," ).append("\n"); 
		query.append("        ''  CUST_CNT_CD       ," ).append("\n"); 
		query.append("        ''  CUST_SEQ          ," ).append("\n"); 
		query.append("        ''  CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  /*+ LEADING( BK ) */" ).append("\n"); 
		query.append("                ( SELECT A.OFC_CD FROM MDM_ORGANIZATION A WHERE A.OFC_TP_CD = 'HQ' START WITH A.OFC_CD = BK.BKG_OFC_CD CONNECT BY PRIOR A.PRNT_OFC_CD = A.OFC_CD ) BKG_RHQ_CD ," ).append("\n"); 
		query.append("                BK.BKG_OFC_CD     ," ).append("\n"); 
		query.append("                BK.BKG_NO         ," ).append("\n"); 
		query.append("                BK.BL_NO          ," ).append("\n"); 
		query.append("                TO_CHAR(BK.BKG_CRE_DT, 'YYYY-MM-DD')  BKG_CRE_DT  ," ).append("\n"); 
		query.append("                TO_CHAR(BR.RT_APLY_DT, 'YYYY-MM-DD')  RT_APLY_DT  ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  TO_DATE(PS.VPS_ETD_DT)" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                        SELECT  *" ).append("\n"); 
		query.append("                        FROM    (" ).append("\n"); 
		query.append("                                SELECT  BV.*  ," ).append("\n"); 
		query.append("                                        ROW_NUMBER() OVER ( PARTITION BY BKG_NO ORDER BY VSL_PRE_PST_CD, VSL_SEQ ) ROW_NUMBER" ).append("\n"); 
		query.append("                                FROM    BKG_VVD BV" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                        WHERE   ROW_NUMBER  = 1" ).append("\n"); 
		query.append("                        ) BV  ," ).append("\n"); 
		query.append("                        VSK_VSL_PORT_SKD  PS" ).append("\n"); 
		query.append("                WHERE   PS.VSL_CD       = BV.VSL_CD" ).append("\n"); 
		query.append("                AND     PS.SKD_VOY_NO   = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     PS.SKD_DIR_CD   = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     PS.VPS_PORT_CD  = BV.POL_CD" ).append("\n"); 
		query.append("                AND     PS.CLPT_IND_SEQ = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                AND     BV.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("                ) VPS_ETD_DT      ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD VVD   ," ).append("\n"); 
		query.append("                BR.BKG_CTRT_TP_CD ," ).append("\n"); 
		query.append("                ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01716' AND INTG_CD_VAL_CTNT = BR.BKG_CTRT_TP_CD ) BKG_CTRT_TP_NM  ," ).append("\n"); 
		query.append("                DECODE(BR.BKG_CTRT_TP_CD, 'S', BK.SC_NO, 'R', BK.RFA_NO, 'T', BK.TAA_NO)  CTRT_NO ," ).append("\n"); 
		query.append("                BK.REP_CMDT_CD    ," ).append("\n"); 
		query.append("                BK.CMDT_CD        ," ).append("\n"); 
		query.append("                ( SELECT A.CMDT_NM FROM MDM_COMMODITY A WHERE A.CMDT_CD = BK.CMDT_CD )  CMDT_NM ," ).append("\n"); 
		query.append("                BL.CSTMS_DESC     ," ).append("\n"); 
		query.append("                BK.DCGO_FLG       ," ).append("\n"); 
		query.append("                BK.RC_FLG         ," ).append("\n"); 
		query.append("                BK.AWK_CGO_FLG    ," ).append("\n"); 
		query.append("                BK.BB_CGO_FLG     ," ).append("\n"); 
		query.append("                BK.RD_CGO_FLG     ," ).append("\n"); 
		query.append("                BK.HNGR_FLG       ," ).append("\n"); 
		query.append("                BK.EQ_SUBST_FLG   ," ).append("\n"); 
		query.append("                BK.SVC_SCP_CD     ," ).append("\n"); 
		query.append("                BK.POR_CD         ," ).append("\n"); 
		query.append("                BK.POL_CD         ," ).append("\n"); 
		query.append("                BK.POD_CD         ," ).append("\n"); 
		query.append("                BK.DEL_CD         ," ).append("\n"); 
		query.append("                BK.RCV_TERM_CD    ," ).append("\n"); 
		query.append("                BK.DE_TERM_CD     ," ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                WHEN  L3.CNT_CD IN ( 'US', 'CA' ) AND BK.POD_CD = BK.DEL_CD AND BK.DE_TERM_CD NOT IN ( 'D', 'H' ) THEN 'PO'" ).append("\n"); 
		query.append("                WHEN  L3.CNT_CD IN ( 'US', 'CA' ) THEN NVL(( SELECT SUBSTR(SVC_MOD_CD, 1, 2) FROM COA_USA_SVC_MOD A WHERE A.ORG_RGN_CD = L3.RGN_CD AND A.DEST_RGN_CD = L4.RGN_CD ), 'OT')" ).append("\n"); 
		query.append("                WHEN  L2.CNT_CD IN ( 'US', 'CA' ) AND BK.POL_CD = BK.POR_CD AND BK.RCV_TERM_CD NOT IN ( 'D', 'H' ) THEN 'PO'" ).append("\n"); 
		query.append("                WHEN  L2.CNT_CD IN ( 'US', 'CA' ) THEN NVL(( SELECT SUBSTR(SVC_MOD_CD, 1, 2) FROM COA_USA_SVC_MOD A WHERE A.ORG_RGN_CD = L2.RGN_CD AND A.DEST_RGN_CD = L1.RGN_CD ), 'OT')" ).append("\n"); 
		query.append("                ELSE  'OT'" ).append("\n"); 
		query.append("                END   USA_SVC_MOD_CD  , -- PO, LO, IP, ML, OT" ).append("\n"); 
		query.append("                C1.CUST_NM  S_CUST_NM ," ).append("\n"); 
		query.append("                C2.CUST_NM  C_CUST_NM ," ).append("\n"); 
		query.append("                C3.CUST_NM  N_CUST_NM ," ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                WHEN BR.BKG_CTRT_TP_CD = 'S'" ).append("\n"); 
		query.append("                  THEN SC.CTRT_PTY_NM" ).append("\n"); 
		query.append("                WHEN BR.BKG_CTRT_TP_CD = 'R'" ).append("\n"); 
		query.append("                  THEN ( SELECT A.CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = RF.CUST_CNT_CD AND A.CUST_SEQ = RF.CUST_SEQ )" ).append("\n"); 
		query.append("                WHEN BR.BKG_CTRT_TP_CD = 'T'" ).append("\n"); 
		query.append("                  THEN ( SELECT A.CUST_LGL_ENG_NM FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = TA.CUST_CNT_CD AND A.CUST_SEQ = TA.CUST_SEQ )" ).append("\n"); 
		query.append("                END CTRT_CUST_NM    ," ).append("\n"); 
		query.append("                DECODE(BR.BKG_CTRT_TP_CD, 'S', SC.PRC_CTRT_CUST_TP_CD, 'R', RF.PRC_CTRT_CUST_TP_CD, 'T', TA.PRC_CTRT_CUST_TP_CD)  CTRT_CUST_TP_CD ," ).append("\n"); 
		query.append("                '' CTRT_CUST_VAL_SGM_NM  ," ).append("\n"); 
		query.append("                DECODE(BL.BDR_FLG, 'Y', 'Yes', 'No')  BDR_FLG ," ).append("\n"); 
		query.append("                BK.BKG_STS_CD     ," ).append("\n"); 
		query.append("                ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD00769' AND INTG_CD_VAL_CTNT = BK.BKG_STS_CD ) BKG_STS_NM  ," ).append("\n"); 
		query.append("                DECODE(BK.SPLIT_FLG, NULL, 'N', 'Y', 'S', BK.SPLIT_FLG) SPLIT_FLG   ," ).append("\n"); 
		query.append("                ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02376' AND INTG_CD_VAL_CTNT = DECODE(BK.SPLIT_FLG, NULL, 'N', 'Y', 'S', BK.SPLIT_FLG) ) SPLIT_NM  ," ).append("\n"); 
		query.append("                DECODE(BC.BKG_NO, NULL, 'N', 'C')                       CHARGE_FLG  ," ).append("\n"); 
		query.append("                ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02375' AND INTG_CD_VAL_CTNT = DECODE(BC.BKG_NO, NULL, 'N', 'C') ) CHARGE_NM  ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  MAX(DECODE(AUTO_RAT_CD, 'A', 'A', 'I', 'A', 'M'))" ).append("\n"); 
		query.append("                FROM    BKG_CHG_RT  A" ).append("\n"); 
		query.append("                WHERE   A.BKG_NO    = BK.BKG_NO" ).append("\n"); 
		query.append("                ) AUTO_RAT_FLG    ," ).append("\n"); 
		query.append("                BR.RT_BL_TP_CD    ," ).append("\n"); 
		query.append("                ( SELECT TRIM(REPLACE(INTG_CD_VAL_DP_DESC, 'B/L', '')) FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01639' AND INTG_CD_VAL_CTNT = BR.RT_BL_TP_CD )  RT_BL_TP_NM ," ).append("\n"); 
		query.append("                BC.CHG_CD         ," ).append("\n"); 
		query.append("                BC.CURR_CD        ," ).append("\n"); 
		query.append("                BC.CHG_UT_AMT     ," ).append("\n"); 
		query.append("                BC.RAT_AS_QTY     ," ).append("\n"); 
		query.append("                BC.RAT_UT_CD      ," ).append("\n"); 
		query.append("                BC.CHG_AMT        ," ).append("\n"); 
		query.append("                BC.AUTO_RAT_CD    ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  UPD_USR_ID" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                        SELECT  BKG_NO      ," ).append("\n"); 
		query.append("                                UPD_USR_ID  ," ).append("\n"); 
		query.append("                                ROW_NUMBER() OVER( PARTITION BY BKG_NO ORDER BY UPD_DT DESC ) ROW_NUMBER" ).append("\n"); 
		query.append("                        FROM    BKG_CHG_RT" ).append("\n"); 
		query.append("                        ) A" ).append("\n"); 
		query.append("                WHERE   A.BKG_NO      = BK.BKG_NO" ).append("\n"); 
		query.append("                AND     A.ROW_NUMBER  = 1" ).append("\n"); 
		query.append("                ) RATER_ID        ," ).append("\n"); 
		query.append("                RD.RDN_NO         ," ).append("\n"); 
		query.append("                ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01568' AND INTG_CD_VAL_CTNT = RD.RDN_STS_CD ) RDN_STS_NM" ).append("\n"); 
		query.append("        FROM    BKG_BOOKING   BK  ," ).append("\n"); 
		query.append("                MDM_LOCATION  L1  ," ).append("\n"); 
		query.append("                MDM_LOCATION  L2  ," ).append("\n"); 
		query.append("                MDM_LOCATION  L3  ," ).append("\n"); 
		query.append("                MDM_LOCATION  L4  ," ).append("\n"); 
		query.append("                BKG_RATE      BR  ," ).append("\n"); 
		query.append("                BKG_BL_DOC    BL  ," ).append("\n"); 
		query.append("                BKG_CHG_RT    BC  ," ).append("\n"); 
		query.append("                BKG_CUSTOMER  C1  ," ).append("\n"); 
		query.append("                BKG_CUSTOMER  C2  ," ).append("\n"); 
		query.append("                BKG_CUSTOMER  C3  ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  SH.SC_NO        ," ).append("\n"); 
		query.append("                        SM.AMDT_SEQ     ," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER ( PARTITION BY SH.SC_NO ORDER BY SM.AMDT_SEQ DESC ) ROW_NUMBER  ," ).append("\n"); 
		query.append("                        CP.CUST_CNT_CD  ," ).append("\n"); 
		query.append("                        CP.CUST_SEQ     ," ).append("\n"); 
		query.append("                        CT.PRC_CTRT_CUST_TP_CD  ," ).append("\n"); 
		query.append("                        CP.CTRT_CUST_VAL_SGM_CD ," ).append("\n"); 
		query.append("                        CP.CTRT_PTY_NM" ).append("\n"); 
		query.append("                FROM    PRI_SP_HDR          SH  ," ).append("\n"); 
		query.append("                        PRI_SP_MN           SM  ," ).append("\n"); 
		query.append("                        PRI_SP_CTRT_PTY     CP  ," ).append("\n"); 
		query.append("                        PRI_SP_CTRT_CUST_TP CT" ).append("\n"); 
		query.append("                WHERE   SM.PROP_NO            = SH.PROP_NO" ).append("\n"); 
		query.append("                AND     SM.PROP_STS_CD        = 'F'" ).append("\n"); 
		query.append("                AND     CP.PROP_NO            = SM.PROP_NO" ).append("\n"); 
		query.append("                AND     CP.AMDT_SEQ           = SM.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     CP.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("                AND     CT.PROP_NO            = CP.PROP_NO" ).append("\n"); 
		query.append("                AND     CT.AMDT_SEQ           = CP.AMDT_SEQ" ).append("\n"); 
		query.append("                AND     CT.PRC_CTRT_PTY_TP_CD = CP.PRC_CTRT_PTY_TP_CD" ).append("\n"); 
		query.append("                ) SC  ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  RH.RFA_NO       ," ).append("\n"); 
		query.append("                        RM.AMDT_SEQ     ," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER ( PARTITION BY RH.RFA_NO ORDER BY RM.AMDT_SEQ DESC )  ROW_NUMBER  ," ).append("\n"); 
		query.append("                        RM.CTRT_CUST_CNT_CD CUST_CNT_CD  ," ).append("\n"); 
		query.append("                        RM.CTRT_CUST_SEQ    CUST_SEQ     ," ).append("\n"); 
		query.append("                        RM.PRC_CTRT_CUST_TP_CD  " ).append("\n"); 
		query.append("                FROM    PRI_RP_HDR      RH  ," ).append("\n"); 
		query.append("                        PRI_RP_MN       RM" ).append("\n"); 
		query.append("                WHERE   RM.PROP_NO            = RH.PROP_NO" ).append("\n"); 
		query.append("                AND     RM.PROP_STS_CD        = 'A'" ).append("\n"); 
		query.append("                ) RF  ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  TH.TAA_NO       ," ).append("\n"); 
		query.append("                        TM.AMDT_SEQ     ," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER ( PARTITION BY TH.TAA_NO ORDER BY TM.AMDT_SEQ DESC )  ROW_NUMBER  ," ).append("\n"); 
		query.append("                        TM.CTRT_CUST_CNT_CD CUST_CNT_CD ," ).append("\n"); 
		query.append("                        TM.CTRT_CUST_SEQ    CUST_SEQ    ," ).append("\n"); 
		query.append("                        TM.PRC_CTRT_CUST_TP_CD  ," ).append("\n"); 
		query.append("                        TM.CTRT_CUST_VAL_SGM_CD" ).append("\n"); 
		query.append("                FROM    PRI_TAA_HDR     TH  ," ).append("\n"); 
		query.append("                        PRI_TAA_MN      TM" ).append("\n"); 
		query.append("                WHERE   TM.TAA_PROP_NO    = TH.TAA_PROP_NO" ).append("\n"); 
		query.append("                AND     TM.CFM_FLG        = 'Y'" ).append("\n"); 
		query.append("                ) TA  ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  BKG_NO      ," ).append("\n"); 
		query.append("                        RDN_NO      ," ).append("\n"); 
		query.append("                        RDN_STS_CD  ," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER ( PARTITION BY BKG_NO ORDER BY RDN_NO DESC )  ROW_NUMBER" ).append("\n"); 
		query.append("                FROM    BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("                ) RD  ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  OFC_CD" ).append("\n"); 
		query.append("                FROM  MDM_ORGANIZATION A" ).append("\n"); 
		query.append("                #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                WHERE OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${bkg_rhq_cd} != '')" ).append("\n"); 
		query.append("                START WITH  A.OFC_CD    = @[bkg_rhq_cd]" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                START WITH  A.OFC_CD    IN ( SELECT OFC_CD FROM MDM_ORGANIZATION WHERE OFC_TP_CD = 'HQ' )" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                CONNECT BY  PRIOR A.OFC_CD  = A.PRNT_OFC_CD" ).append("\n"); 
		query.append("                ) OG" ).append("\n"); 
		query.append("        WHERE   L1.LOC_CD     = BK.POR_CD" ).append("\n"); 
		query.append("        AND     L2.LOC_CD     = BK.POL_CD" ).append("\n"); 
		query.append("        AND     L3.LOC_CD     = BK.POD_CD" ).append("\n"); 
		query.append("        AND     L4.LOC_CD     = BK.DEL_CD" ).append("\n"); 
		query.append("        AND     BR.BKG_NO     = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     BL.BKG_NO     = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     BC.BKG_NO(+)  = BR.BKG_NO" ).append("\n"); 
		query.append("        AND     BC.FRT_INCL_XCLD_DIV_CD(+)  = 'N' -- 고정" ).append("\n"); 
		query.append("        AND     BC.CHG_AMT(+)               <> 0  -- 고정" ).append("\n"); 
		query.append("        AND     C1.BKG_NO(+)          = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     C1.BKG_CUST_TP_CD(+)  = 'S'" ).append("\n"); 
		query.append("        AND     C2.BKG_NO(+)          = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     C2.BKG_CUST_TP_CD(+)  = 'C'" ).append("\n"); 
		query.append("        AND     C3.BKG_NO(+)          = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     C3.BKG_CUST_TP_CD(+)  = 'N'" ).append("\n"); 
		query.append("        AND     SC.SC_NO(+)           = BK.SC_NO" ).append("\n"); 
		query.append("        AND     SC.ROW_NUMBER(+)      = 1" ).append("\n"); 
		query.append("        AND     RF.RFA_NO(+)          = BK.RFA_NO" ).append("\n"); 
		query.append("        AND     RF.ROW_NUMBER(+)      = 1" ).append("\n"); 
		query.append("        AND     TA.TAA_NO(+)          = BK.TAA_NO" ).append("\n"); 
		query.append("        AND     TA.ROW_NUMBER(+)      = 1" ).append("\n"); 
		query.append("        AND     RD.BKG_NO(+)          = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     RD.ROW_NUMBER(+)      = 1" ).append("\n"); 
		query.append("        AND     BK.BKG_OFC_CD = OG.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${search_date} == 'BKG')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if (${from_dt} != '')" ).append("\n"); 
		query.append("          AND      BK.BKG_CRE_DT >= TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if (${to_dt} != '')" ).append("\n"); 
		query.append("          AND      BK.BKG_CRE_DT <= TO_DATE (@[to_dt], 'YYYY-MM-DD') + 0.99999      /* 0.99999 는 23시 59분 59초를 의미 */" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #elseif (${search_date} == 'APPL')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if (${from_dt} != '')" ).append("\n"); 
		query.append("          AND      BR.RT_APLY_DT >= TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if (${to_dt} != '')" ).append("\n"); 
		query.append("          AND      BR.RT_APLY_DT <= TO_DATE (@[to_dt], 'YYYY-MM-DD') + 0.99999      /* 0.99999 는 23시 59분 59초를 의미 */" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${vvd} != '')" ).append("\n"); 
		query.append("        AND     BK.VSL_CD       = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("        AND     BK.SKD_VOY_NO   = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("        AND     BK.SKD_DIR_CD   = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${bl_no} != '')" ).append("\n"); 
		query.append("        AND     BK.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bkg_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("        AND     BR.BKG_CTRT_TP_CD   = @[bkg_ctrt_tp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bkg_ctrt_tp_cd} == 'S' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("        AND     BK.SC_NO          = @[ctrt_no]" ).append("\n"); 
		query.append("        #elseif (${bkg_ctrt_tp_cd} == 'R' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("        AND     BK.RFA_NO         = @[ctrt_no]" ).append("\n"); 
		query.append("        #elseif (${bkg_ctrt_tp_cd} == 'T' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("        AND     BK.TAA_NO         = @[ctrt_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		#if (${bkg_ctrt_tp_cd} == '' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("		AND 	(		BK.SC_NO          = @[ctrt_no]" ).append("\n"); 
		query.append("					OR	BK.RFA_NO         = @[ctrt_no]" ).append("\n"); 
		query.append("					OR	BK.TAA_NO         = @[ctrt_no]" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.CMDT_CD  = @[cmdt_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        /* cargo type : DG, RF, AK, BB, RD, HG */" ).append("\n"); 
		query.append("        #if (${cargo_type} == 'DG')" ).append("\n"); 
		query.append("        AND     BK.DCGO_FLG    = 'Y'" ).append("\n"); 
		query.append("        #elseif (${cargo_type} == 'RF')" ).append("\n"); 
		query.append("        AND     BK.RC_FLG      = 'Y'" ).append("\n"); 
		query.append("        #elseif (${cargo_type} == 'AK')" ).append("\n"); 
		query.append("        AND     BK.AWK_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("        #elseif (${cargo_type} == 'BB')" ).append("\n"); 
		query.append("        AND     BK.BB_CGO_FLG  = 'Y'" ).append("\n"); 
		query.append("        #elseif (${cargo_type} == 'RD')" ).append("\n"); 
		query.append("        AND     BK.RD_CGO_FLG  = 'Y'" ).append("\n"); 
		query.append("        #elseif (${cargo_type} == 'HG')" ).append("\n"); 
		query.append("        AND     BK.HNGR_FLG    = 'Y'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.SVC_SCP_CD  = @[svc_scp_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${por_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.POR_CD LIKE @[por_cd] || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${pol_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.POL_CD LIKE @[pol_cd] || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${pod_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.POD_CD LIKE @[pod_cd] || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${del_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.DEL_CD LIKE @[del_cd] || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${rcv_term_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.RCV_TERM_CD = @[rcv_term_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${de_term_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.DE_TERM_CD  = @[de_term_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${bkg_cust_tp_cd} == 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("          AND     C1.CUST_CNT_CD  = @[cust_cnt_cd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${cust_seq} != '')" ).append("\n"); 
		query.append("          AND     C1.CUST_SEQ     = @[cust_seq]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #elseif (${bkg_cust_tp_cd} == 'C')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("          AND     C2.CUST_CNT_CD  = @[cust_cnt_cd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${cust_seq} != '')" ).append("\n"); 
		query.append("          AND     C2.CUST_SEQ     = @[cust_seq]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #elseif (${bkg_cust_tp_cd} == 'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("          AND     C3.CUST_CNT_CD  = @[cust_cnt_cd]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${cust_seq} != '')" ).append("\n"); 
		query.append("          AND     C3.CUST_SEQ     = @[cust_seq]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${bdr_flg} != '')" ).append("\n"); 
		query.append("        AND     BL.BDR_FLG  = @[bdr_flg]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${bkg_sts_cd} != '')" ).append("\n"); 
		query.append("        AND     BK.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${split_flg} == 'S')" ).append("\n"); 
		query.append("        AND     BK.SPLIT_FLG = 'Y'" ).append("\n"); 
		query.append("        #elseif (${split_flg} == 'N')" ).append("\n"); 
		query.append("        AND     (BK.SPLIT_FLG IS NULL OR BK.SPLIT_FLG = 'N')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${charge_flg} == 'C')" ).append("\n"); 
		query.append("        AND     BC.BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("        #elseif(${charge_flg} == 'N')" ).append("\n"); 
		query.append("        AND     BC.BKG_NO IS NULL" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${chg_cd} != '')" ).append("\n"); 
		query.append("			#if (${charge_type} == 'RATED')" ).append("\n"); 
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
		query.append("					AND EXISTS ( SELECT 'Y' " ).append("\n"); 
		query.append("									 FROM BKG_CHG_RT A " ).append("\n"); 
		query.append("			            			 WHERE A.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("		              				   AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("	              				)" ).append("\n"); 
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
		query.append("        #if (${curr_cd} != '')" ).append("\n"); 
		query.append("        AND     BC.CURR_CD      = @[curr_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${rat_ut_cd} != '')" ).append("\n"); 
		query.append("        AND     BC.RAT_UT_CD      IN ( #foreach(${key} in ${rat_ut_list}) #if($velocityCount != 1) , #end '$key' #end )  -- MULTI" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${bill_type_n} != '' || ${bill_type_m} != '' || ${bill_type_c} != '' || ${bill_type_b} != '')" ).append("\n"); 
		query.append("        AND     BR.RT_BL_TP_CD IN (@[bill_type_n], @[bill_type_m], @[bill_type_c], @[bill_type_b])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        ) T" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${search_date} == 'ETD')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if (${from_dt} != '')" ).append("\n"); 
		query.append("  AND      VPS_ETD_DT >= TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if (${to_dt} != '')" ).append("\n"); 
		query.append("  AND      VPS_ETD_DT <= TO_DATE (@[to_dt], 'YYYY-MM-DD') + 0.99999      /* 0.99999 는 23시 59분 59초를 의미 */" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${usa_svc_mod_cd} != '')" ).append("\n"); 
		query.append("AND     USA_SVC_MOD_CD  = @[usa_svc_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_cust_tp_cd} == 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if (${cust_nm} != '')" ).append("\n"); 
		query.append("  AND     UPPER(S_CUST_NM)  LIKE '%' || UPPER(@[cust_nm]) || '%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${bkg_cust_tp_cd} == 'C')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if (${cust_nm} != '')" ).append("\n"); 
		query.append("  AND     UPPER(C_CUST_NM)  LIKE '%' || UPPER(@[cust_nm]) || '%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${bkg_cust_tp_cd} == 'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if (${cust_nm} != '')" ).append("\n"); 
		query.append("  AND     UPPER(N_CUST_NM)  LIKE '%' || UPPER(@[cust_nm]) || '%'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${auto_rat_flg} != '')" ).append("\n"); 
		query.append("AND     AUTO_RAT_FLG    = @[auto_rat_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("		BKG_NO		," ).append("\n"); 
		query.append("		BKG_CTRT_TP_CD	," ).append("\n"); 
		query.append("        BKG_RHQ_CD  ," ).append("\n"); 
		query.append("        BKG_OFC_CD  ," ).append("\n"); 
		query.append("		CTRT_NO		," ).append("\n"); 
		query.append("		POR_CD		," ).append("\n"); 
		query.append("		POL_CD		," ).append("\n"); 
		query.append("		POD_CD		," ).append("\n"); 
		query.append("		DEL_CD		," ).append("\n"); 
		query.append("		VPS_ETD_DT" ).append("\n"); 

	}
}