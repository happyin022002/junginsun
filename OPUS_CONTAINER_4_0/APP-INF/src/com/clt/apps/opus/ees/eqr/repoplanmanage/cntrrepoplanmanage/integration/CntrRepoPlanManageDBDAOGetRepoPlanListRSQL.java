/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrRepoPlanManageDBDAOGetRepoPlanListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.22
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.01.22 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanManageDBDAOGetRepoPlanListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0045 컨테이너 이송 계획 목록 조회>
	  * Repo Plan Id 정보 조회
	  * 
	  * <Change History>
	  * 1	2009.08.17	Lee ByoungHun	최초작성
	  * 2.	2014.10.15	Un Joeng                NYK GAP Develope Work
	  * 3.     2015.02.04     Un Joeng                NYK Assembly 관련 수정작업
	  * </pre>
	  */
	public CntrRepoPlanManageDBDAOGetRepoPlanListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("repoEYearWeek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emt_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repoSYearWeek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanManageDBDAOGetRepoPlanListRSQL").append("\n"); 
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
		query.append("SELECT    WEEK" ).append("\n"); 
		query.append("        , REPO_PLN_ID" ).append("\n"); 
		query.append("        , REPO_PLN_RMK" ).append("\n"); 
		query.append("        , USR_ID" ).append("\n"); 
		query.append("		, USR_ID AS USRID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        #if (${cbx_ep_tp_cd} == 'Y')" ).append("\n"); 
		query.append("        , EP_TP_CD" ).append("\n"); 
		query.append("        , DAT_TP_CD" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("	 	#if (${cbx_rcc_cd} == 'Y')" ).append("\n"); 
		query.append("	 	, FM_RCC_CD" ).append("\n"); 
		query.append("		, TO_RCC_CD" ).append("\n"); 
		query.append("	 	#end" ).append("\n"); 
		query.append("	 	#if (${cbx_lcc_cd} == 'Y')" ).append("\n"); 
		query.append("	 	, FM_LCC_CD" ).append("\n"); 
		query.append("		, TO_LCC_CD" ).append("\n"); 
		query.append("	 	#end" ).append("\n"); 
		query.append("	 	#if (${cbx_ecc_cd} == 'Y')" ).append("\n"); 
		query.append("	 	, FM_ECC_CD" ).append("\n"); 
		query.append("		, TO_ECC_CD" ).append("\n"); 
		query.append("	 	#end" ).append("\n"); 
		query.append("	 	#if (${cbx_loc_cd} == 'Y')" ).append("\n"); 
		query.append("	 	, FM_LOC_CD" ).append("\n"); 
		query.append("		, TO_LOC_CD" ).append("\n"); 
		query.append("	 	#end" ).append("\n"); 
		query.append("	 	#if (${cbx_yard_cd} == 'Y')" ).append("\n"); 
		query.append("	 	, FM_YARD_CD" ).append("\n"); 
		query.append("		, TO_YARD_CD" ).append("\n"); 
		query.append("	 	#end" ).append("\n"); 
		query.append("	 	#if (${cbx_vvd_cd} == 'Y')" ).append("\n"); 
		query.append("	 	, VVD" ).append("\n"); 
		query.append("	 	#end" ).append("\n"); 
		query.append("	 	#if (${cbx_emt_bkg_no} == 'Y')" ).append("\n"); 
		query.append("	 	, BKG_NO" ).append("\n"); 
		query.append("	 	#end" ).append("\n"); 
		query.append("	 	#if (${cbx_ref_id} == 'Y')" ).append("\n"); 
		query.append("	 	, REF_ID" ).append("\n"); 
		query.append("	 	#end" ).append("\n"); 
		query.append("	 	#if (${cbx_so_no} == 'Y')" ).append("\n"); 
		query.append("	 	, SO_NO" ).append("\n"); 
		query.append("	 	#end" ).append("\n"); 
		query.append("        , REPO_PLN_DTRB_FLG" ).append("\n"); 
		query.append("        , AUTO" ).append("\n"); 
		query.append("        , MANUAL" ).append("\n"); 
		query.append("        , SCNR_ID" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("          SELECT  DISTINCT SUBSTR(ERP.REPO_PLN_ID,5,4)||'-'||SUBSTR(ERP.REPO_PLN_ID,9,2) WEEK" ).append("\n"); 
		query.append("                , ERP.REPO_PLN_ID" ).append("\n"); 
		query.append("                , ERPN.NO" ).append("\n"); 
		query.append("                , DECODE(ERPN.EP_TP_CD, NULL, 'BlankData', ERPN.EP_TP_CD)   AS EP_TP_CD" ).append("\n"); 
		query.append("                , DECODE(ERPN.DAT_TP_CD, NULL, 'BlankData', ERPN.DAT_TP_CD) AS DAT_TP_CD" ).append("\n"); 
		query.append("                , ERP.REPO_PLN_RMK REPO_PLN_RMK" ).append("\n"); 
		query.append("                , ERP.UPD_USR_ID USR_ID" ).append("\n"); 
		query.append("                , TO_CHAR(ERP.UPD_DT,'yyyy-mm-dd')||' '||TO_CHAR(ERP.UPD_DT,'HH24:MI') UPD_DT" ).append("\n"); 
		query.append("                , TO_CHAR(ERP.CRE_DT,'yyyy-mm-dd')||' '||TO_CHAR(ERP.CRE_DT,'HH24:MI') CRE_DT  " ).append("\n"); 
		query.append("                , MST_LOC_FNC(NVL (SUBSTR (ERPN.FM_YD_CD, 1, 5), ERPN.FM_LOC_CD), 'RCC') AS FM_RCC_CD" ).append("\n"); 
		query.append("                , MST_LOC_FNC(NVL (SUBSTR (ERPN.FM_YD_CD, 1, 5), ERPN.FM_LOC_CD), 'LCC') AS FM_LCC_CD  " ).append("\n"); 
		query.append("                , MST_LOC_FNC(NVL (SUBSTR (ERPN.FM_YD_CD, 1, 5), ERPN.FM_LOC_CD), 'ECC') AS FM_ECC_CD " ).append("\n"); 
		query.append("                , NVL(SUBSTR(ERPN.FM_YD_CD, 1, 5), ERPN.FM_LOC_CD) AS FM_LOC_CD" ).append("\n"); 
		query.append("                , ERPN.FM_YD_CD AS FM_YARD_CD" ).append("\n"); 
		query.append("                , MST_LOC_FNC(NVL (SUBSTR (ERPN.TO_YD_CD, 1, 5), ERPN.TO_LOC_CD), 'RCC') AS TO_RCC_CD " ).append("\n"); 
		query.append("                , MST_LOC_FNC(NVL (SUBSTR (ERPN.TO_YD_CD, 1, 5), ERPN.TO_LOC_CD), 'LCC') AS TO_LCC_CD" ).append("\n"); 
		query.append("                , MST_LOC_FNC(NVL (SUBSTR (ERPN.TO_YD_CD, 1, 5), ERPN.TO_LOC_CD), 'ECC') AS TO_ECC_CD  " ).append("\n"); 
		query.append("                , NVL(SUBSTR(ERPN.TO_YD_CD, 1, 5), ERPN.TO_LOC_CD) AS TO_LOC_CD" ).append("\n"); 
		query.append("                , ERPN.TO_YD_CD AS TO_YARD_CD" ).append("\n"); 
		query.append("                , ERPN.VVD AS VVD" ).append("\n"); 
		query.append("                , ERPN.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("                , ERPN.REF_ID AS REF_ID" ).append("\n"); 
		query.append("                , ESON.SO_NO AS SO_NO" ).append("\n"); 
		query.append("                , DECODE (ERP.REPO_PLN_DTRB_FLG, 'Y', 0, 1) REPO_PLN_DTRB_FLG" ).append("\n"); 
		query.append("                , DECODE (ERP.REPO_PLN_AUTO_GEN_FLG, 'Y', 0, 1) AUTO" ).append("\n"); 
		query.append("                , DECODE (ERP.REPO_PLN_AUTO_GEN_FLG, 'N', 0, 1) MANUAL" ).append("\n"); 
		query.append("                , ERP.SCNR_ID AS SCNR_ID" ).append("\n"); 
		query.append("        FROM EQR_EQ_REPO_PLN ERP" ).append("\n"); 
		query.append("             , (SELECT   'T.VVD PLN'       AS TYPE" ).append("\n"); 
		query.append("                        , 'T.VVD' AS EP_TP_CD" ).append("\n"); 
		query.append("                        , 'RepoPlan' AS DAT_TP_CD" ).append("\n"); 
		query.append("                        , 1                AS NO" ).append("\n"); 
		query.append("                        , VPLN.REPO_PLN_ID AS REPO_PLN_ID" ).append("\n"); 
		query.append("                        , VPLN.PLN_YRWK    AS PLN_YRWK" ).append("\n"); 
		query.append("                        , VPLN.PLN_SEQ     AS PLN_SEQ" ).append("\n"); 
		query.append("                        , VPLN.VSL_LANE_CD AS VSL_LANE_CD" ).append("\n"); 
		query.append("                        , VPLN.VSL_CD||VPLN.SKD_VOY_NO||VPLN.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                        , VPLN.FM_ECC_CD   AS FM_LOC_CD" ).append("\n"); 
		query.append("                        , VPLN.FM_YD_CD    AS FM_YD_CD" ).append("\n"); 
		query.append("                        , VPLN.TO_ECC_CD   AS TO_LOC_CD" ).append("\n"); 
		query.append("                        , VPLN.TO_YD_CD    AS TO_YD_CD" ).append("\n"); 
		query.append("                        , ''               AS REF_ID" ).append("\n"); 
		query.append("                        , ''               AS BKG_NO" ).append("\n"); 
		query.append("                FROM EQR_VSL_LDIS_PLN_COD_TMP VPLN" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND VPLN.PLN_YRWK BETWEEN @[repoSYearWeek] AND @[repoEYearWeek]" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT   'T.VVD EXE'       AS TYPE" ).append("\n"); 
		query.append("                        , 'T.VVD' AS EP_TP_CD" ).append("\n"); 
		query.append("                        , 'ExecPlan' AS DAT_TP_CD" ).append("\n"); 
		query.append("                        , 2                AS NO                " ).append("\n"); 
		query.append("                        , VEXE.REPO_PLN_ID AS REPO_PLN_ID" ).append("\n"); 
		query.append("                        , VEXE.PLN_YRWK    AS PLN_YRWK" ).append("\n"); 
		query.append("                        , VEXE.PLN_SEQ     AS PLN_SEQ" ).append("\n"); 
		query.append("                        , VEXE.VSL_LANE_CD AS VSL_LANE_CD" ).append("\n"); 
		query.append("                        , VEXE.VSL_CD||VEXE.SKD_VOY_NO||VEXE.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                        , ''               AS FM_LOC_CD" ).append("\n"); 
		query.append("                        , VEXE.FM_YD_CD    AS FM_YD_CD" ).append("\n"); 
		query.append("                        , ''               AS TO_LOC_CD" ).append("\n"); 
		query.append("                        , VEXE.TO_YD_CD    AS TO_YD_CD" ).append("\n"); 
		query.append("                        , VEXE.REF_ID      AS REF_ID" ).append("\n"); 
		query.append("                        , VEXE.MTY_BKG_NO  AS BKG_NO" ).append("\n"); 
		query.append("                FROM EQR_VSL_LODG_DCHG_EXE_PLN VEXE" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND VEXE.PLN_YRWK BETWEEN @[repoSYearWeek] AND @[repoEYearWeek]" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT   'TRS PLN'         AS TYPE" ).append("\n"); 
		query.append("                        , DECODE (TPLN.TRSP_MOD_CD,  'R', 'Rail',  'W', 'Water',  'Truck') AS EP_TP_CD" ).append("\n"); 
		query.append("                        , 'PlanRecord'     AS DAT_TP_CD" ).append("\n"); 
		query.append("                        , 3                AS NO                " ).append("\n"); 
		query.append("                        , TPLN.REPO_PLN_ID AS REPO_PLN_ID" ).append("\n"); 
		query.append("                        , TPLN.PLN_YRWK    AS PLN_YRWK" ).append("\n"); 
		query.append("                        , TPLN.PLN_SEQ     AS PLN_SEQ" ).append("\n"); 
		query.append("                        , ''               AS VSL_LANE_CD" ).append("\n"); 
		query.append("                        , ''               AS VVD" ).append("\n"); 
		query.append("                        , TPLN.FM_ECC_CD   AS FM_LOC_CD" ).append("\n"); 
		query.append("                        , ''               AS FM_YD_CD" ).append("\n"); 
		query.append("                        , TPLN.TO_ECC_CD   AS TO_LOC_CD" ).append("\n"); 
		query.append("                        , ''               AS TO_YD_CD" ).append("\n"); 
		query.append("                        , ''               AS REF_ID" ).append("\n"); 
		query.append("                        , ''               AS BKG_NO" ).append("\n"); 
		query.append("                FROM EQR_INLND_TRSP_PLN TPLN" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND TPLN.PLN_YRWK BETWEEN @[repoSYearWeek] AND @[repoEYearWeek]" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT   'TRS EXE'         AS TYPE" ).append("\n"); 
		query.append("                        , DECODE (TEXE.TRSP_MOD_CD,  'R', 'Rail',  'W', 'Water',  'Truck') AS EP_TP_CD" ).append("\n"); 
		query.append("                        , 'ExecRecord'     AS DAT_TP_CD" ).append("\n"); 
		query.append("                        , 4                AS NO                " ).append("\n"); 
		query.append("                        , TEXE.REPO_PLN_ID AS REPO_PLN_ID" ).append("\n"); 
		query.append("                        , TEXE.PLN_YRWK    AS PLN_YRWK" ).append("\n"); 
		query.append("                        , TEXE.PLN_SEQ     AS PLN_SEQ" ).append("\n"); 
		query.append("                        , TEXE.VSL_LANE_CD AS VSL_LANE_CD" ).append("\n"); 
		query.append("                        , TEXE.VSL_CD||TEXE.SKD_VOY_NO||TEXE.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                        , ''               AS FM_LOC_CD" ).append("\n"); 
		query.append("                        , TEXE.FM_YD_CD    AS FM_YD_CD" ).append("\n"); 
		query.append("                        , ''               AS TO_LOC_CD" ).append("\n"); 
		query.append("                        , TEXE.TO_YD_CD    AS TO_YD_CD" ).append("\n"); 
		query.append("                        , TEXE.REF_ID      AS REF_ID" ).append("\n"); 
		query.append("                        , TEXE.MTY_BKG_NO  AS BKG_NO" ).append("\n"); 
		query.append("                FROM EQR_INLND_TRSP_EXE_PLN TEXE" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND TEXE.PLN_YRWK BETWEEN @[repoSYearWeek] AND @[repoEYearWeek]" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT   'ONF PLN'         AS TYPE" ).append("\n"); 
		query.append("                        , DECODE (OPLN.ONF_HIR_DIV_CD, 'O', 'Onhire', 'Offhire') AS EP_TP_CD" ).append("\n"); 
		query.append("                        , 'PlanRecord'     AS DAT_TP_CD" ).append("\n"); 
		query.append("                        , 5                AS NO                " ).append("\n"); 
		query.append("                        , OPLN.REPO_PLN_ID AS REPO_PLN_ID" ).append("\n"); 
		query.append("                        , OPLN.PLN_YRWK    AS PLN_YRWK" ).append("\n"); 
		query.append("                        , OPLN.PLN_SEQ     AS PLN_SEQ" ).append("\n"); 
		query.append("                        , ''               AS VSL_LANE_CD" ).append("\n"); 
		query.append("                        , ''               AS VVD" ).append("\n"); 
		query.append("                        , OPLN.ECC_CD      AS FM_LOC_CD" ).append("\n"); 
		query.append("                        , ''               AS FM_YD_CD" ).append("\n"); 
		query.append("                        , OPLN.ECC_CD      AS TO_LOC_CD" ).append("\n"); 
		query.append("                        , ''               AS TO_YD_CD" ).append("\n"); 
		query.append("                        , ''               AS REF_ID" ).append("\n"); 
		query.append("                        , ''               AS BKG_NO" ).append("\n"); 
		query.append("                FROM EQR_ONF_HIR_PLN OPLN" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND OPLN.PLN_YRWK BETWEEN @[repoSYearWeek] AND @[repoEYearWeek]" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT   'ONF EXE'         AS TYPE" ).append("\n"); 
		query.append("                        , DECODE (OEXE.ONF_HIR_DIV_CD, 'O', 'Onhire', 'Offhire') AS EP_TP_CD" ).append("\n"); 
		query.append("                        , 'ExecRecord'     AS DAT_TP_CD" ).append("\n"); 
		query.append("                        , 6                AS NO                " ).append("\n"); 
		query.append("                        , OEXE.REPO_PLN_ID AS REPO_PLN_ID" ).append("\n"); 
		query.append("                        , OEXE.PLN_YRWK    AS PLN_YRWK" ).append("\n"); 
		query.append("                        , OEXE.PLN_SEQ     AS PLN_SEQ" ).append("\n"); 
		query.append("                        , ''               AS VSL_LANE_CD" ).append("\n"); 
		query.append("                        , ''               AS VVD" ).append("\n"); 
		query.append("                        , ''               AS FM_LOC_CD" ).append("\n"); 
		query.append("                        , OEXE.FM_YD_CD    AS FM_YD_CD" ).append("\n"); 
		query.append("                        , ''               AS TO_LOC_CD" ).append("\n"); 
		query.append("                        , OEXE.TO_YD_CD    AS TO_YD_CD" ).append("\n"); 
		query.append("                        , OEXE.REF_ID      AS REF_ID" ).append("\n"); 
		query.append("                        , ''               AS BKG_NO" ).append("\n"); 
		query.append("                FROM EQR_ONF_HIR_EXE_PLN OEXE" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND OEXE.PLN_YRWK BETWEEN @[repoSYearWeek] AND @[repoEYearWeek]" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT   'LCC EXE'         AS TYPE" ).append("\n"); 
		query.append("                        , 'LCCInternal'    AS EP_TP_CD" ).append("\n"); 
		query.append("                        , 'ExecRecord'     AS DAT_TP_CD" ).append("\n"); 
		query.append("                        , 7                AS NO               " ).append("\n"); 
		query.append("                        , LEXE.REPO_PLN_ID AS REPO_PLN_ID" ).append("\n"); 
		query.append("                        , LEXE.PLN_YRWK    AS PLN_YRWK" ).append("\n"); 
		query.append("                        , 0                AS PLN_SEQ" ).append("\n"); 
		query.append("                        , ''               AS VSL_LANE_CD" ).append("\n"); 
		query.append("                        , ''               AS VVD" ).append("\n"); 
		query.append("                        , ''               AS FM_LOC_CD" ).append("\n"); 
		query.append("                        , LEXE.FM_YD_CD    AS FM_YD_CD" ).append("\n"); 
		query.append("                        , ''               AS TO_LOC_CD" ).append("\n"); 
		query.append("                        , LEXE.TO_YD_CD    AS TO_YD_CD" ).append("\n"); 
		query.append("                        , LEXE.REF_ID      AS REF_ID" ).append("\n"); 
		query.append("                        , ''               AS BKG_NO" ).append("\n"); 
		query.append("                FROM EQR_ECC_INTER_EXE_PLN LEXE" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND LEXE.PLN_YRWK BETWEEN @[repoSYearWeek] AND @[repoEYearWeek]) ERPN" ).append("\n"); 
		query.append("         , (SELECT   TRK.REPO_PLN_ID AS REPO_PLN_ID" ).append("\n"); 
		query.append("                   , TRK.REF_ID      AS REF_ID" ).append("\n"); 
		query.append("                   , TRK.REF_SEQ     AS REF_SEQ" ).append("\n"); 
		query.append("                   , TRK.TRSP_SO_OFC_CTY_CD||TRIM(TO_CHAR(TRK.TRSP_SO_SEQ)) AS SO_NO" ).append("\n"); 
		query.append("            FROM TRS_TRSP_SVC_ORD TRK" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND TRK.REF_ID > ' '" ).append("\n"); 
		query.append("            AND TRK.PLN_YRWK BETWEEN @[repoSYearWeek] AND @[repoEYearWeek]" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT   TRL.REPO_PLN_ID AS REPO_PLN_ID" ).append("\n"); 
		query.append("                   , TRL.REF_ID      AS REF_ID" ).append("\n"); 
		query.append("                   , TRL.REF_SEQ     AS REF_SEQ           " ).append("\n"); 
		query.append("                   , TRL.TRSP_SO_OFC_CTY_CD||TRIM(TO_CHAR(TRL.TRSP_SO_SEQ)) AS SO_NO" ).append("\n"); 
		query.append("            FROM TRS_TRSP_RAIL_BIL_ORD TRL" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND TRL.REF_ID > ' '" ).append("\n"); 
		query.append("            AND TRL.PLN_YRWK BETWEEN @[repoSYearWeek] AND @[repoEYearWeek]) ESON" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND ERP.DELT_FLG = 'N'" ).append("\n"); 
		query.append("        AND SUBSTR (ERP.REPO_PLN_ID, 5, 6) BETWEEN @[repoSYearWeek] AND @[repoEYearWeek]" ).append("\n"); 
		query.append("        AND ERP.REPO_PLN_ID  = ERPN.REPO_PLN_ID(+)" ).append("\n"); 
		query.append("        AND ERPN.REPO_PLN_ID = ESON.REPO_PLN_ID(+)        " ).append("\n"); 
		query.append("        AND ERPN.REF_ID      = ESON.REF_ID(+)" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("	 #if (${repo_pln} != '' && ${repo_pln_seq} != '')" ).append("\n"); 
		query.append("	   AND ERP.REPO_PLN_ID = @[repo_pln]||'W'||@[repo_pln_seq]" ).append("\n"); 
		query.append("	 #elseif (${repo_pln} != '' && ${repo_pln_seq} == '')" ).append("\n"); 
		query.append("	   AND ERP.REPO_PLN_ID LIKE @[repo_pln]||'%'" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("	 #if ($arrLane.size() > 0)" ).append("\n"); 
		query.append("	    AND ERPN.VSL_LANE_CD IN(" ).append("\n"); 
		query.append("	    #foreach ($key in ${arrLane})" ).append("\n"); 
		query.append("		#if($velocityCount < $arrLane.size())" ).append("\n"); 
		query.append("		'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("	 #if (${vvd_cd} != '')" ).append("\n"); 
		query.append("	   AND ERPN.VVD = @[vvd_cd]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("	 #if (${emt_bkg_no} != '')" ).append("\n"); 
		query.append("	   AND ERPN.BKG_NO = @[emt_bkg_no]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 #if (${ref_id} != '')" ).append("\n"); 
		query.append("	   AND ERPN.REF_ID = @[ref_id]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 #if (${so_no} != '')" ).append("\n"); 
		query.append("	   AND ESON.SO_NO = @[so_no]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("	 #if (${usr_id} != '')" ).append("\n"); 
		query.append("	   AND ERP.UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 #if ($arrFmRcc.size() > 0)" ).append("\n"); 
		query.append("        AND MST_LOC_FNC(NVL (SUBSTR (ERPN.FM_YD_CD, 1, 5), ERPN.FM_LOC_CD), 'RCC') IN(" ).append("\n"); 
		query.append("	                                                                                   #foreach ($key in ${arrFmRcc})" ).append("\n"); 
		query.append("		                                                                                    #if($velocityCount < $arrFmRcc.size())" ).append("\n"); 
		query.append("		                                                                                       '$key'," ).append("\n"); 
		query.append("		                                                                                    #else" ).append("\n"); 
		query.append("		                                                                                       '$key'" ).append("\n"); 
		query.append("		                                                                                    #end" ).append("\n"); 
		query.append("	                                                                                     #end" ).append("\n"); 
		query.append("	                                                                                )" ).append("\n"); 
		query.append("	 #end	 " ).append("\n"); 
		query.append("	 #if ($arrFmLcc.size() > 0)" ).append("\n"); 
		query.append("        AND MST_LOC_FNC(NVL (SUBSTR (ERPN.FM_YD_CD, 1, 5), ERPN.FM_LOC_CD), 'LCC') IN(" ).append("\n"); 
		query.append("	                                                                                   #foreach ($key in ${arrFmLcc})" ).append("\n"); 
		query.append("		                                                                                    #if($velocityCount < $arrFmLcc.size())" ).append("\n"); 
		query.append("		                                                                                       '$key'," ).append("\n"); 
		query.append("		                                                                                    #else" ).append("\n"); 
		query.append("		                                                                                       '$key'" ).append("\n"); 
		query.append("		                                                                                    #end" ).append("\n"); 
		query.append("	                                                                                     #end" ).append("\n"); 
		query.append("	                                                                                )" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("	 #if ($arrFmEcc.size() > 0)" ).append("\n"); 
		query.append("        AND MST_LOC_FNC(NVL (SUBSTR (ERPN.FM_YD_CD, 1, 5), ERPN.FM_LOC_CD), 'ECC') IN(" ).append("\n"); 
		query.append("	                                                                                   #foreach ($key in ${arrFmEcc})" ).append("\n"); 
		query.append("		                                                                                    #if($velocityCount < $arrFmEcc.size())" ).append("\n"); 
		query.append("		                                                                                       '$key'," ).append("\n"); 
		query.append("		                                                                                    #else" ).append("\n"); 
		query.append("		                                                                                       '$key'" ).append("\n"); 
		query.append("		                                                                                    #end" ).append("\n"); 
		query.append("	                                                                                     #end" ).append("\n"); 
		query.append("	                                                                                )" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("	 #if ($arrFmLoc.size() > 0)" ).append("\n"); 
		query.append("	    AND NVL(SUBSTR(ERPN.FM_YD_CD, 1, 5), ERPN.FM_LOC_CD) IN (" ).append("\n"); 
		query.append("								    #foreach ($key in ${arrFmLoc})" ).append("\n"); 
		query.append("									#if($velocityCount < $arrFmLoc.size())" ).append("\n"); 
		query.append("									'$key'," ).append("\n"); 
		query.append("									#else" ).append("\n"); 
		query.append("									'$key'" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("								    #end" ).append("\n"); 
		query.append("								    )" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("	 #if (${fm_yard_cd} != '')" ).append("\n"); 
		query.append("	   AND ERPN.FM_YD_CD= @[fm_yard_cd]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("	 #if ($arrToRcc.size() > 0)" ).append("\n"); 
		query.append("        AND MST_LOC_FNC(NVL (SUBSTR (ERPN.TO_YD_CD, 1, 5), ERPN.TO_LOC_CD), 'RCC') IN(" ).append("\n"); 
		query.append("	                                                                                   #foreach ($key in ${arrToRcc})" ).append("\n"); 
		query.append("		                                                                                    #if($velocityCount < $arrToRcc.size())" ).append("\n"); 
		query.append("		                                                                                       '$key'," ).append("\n"); 
		query.append("		                                                                                    #else" ).append("\n"); 
		query.append("		                                                                                       '$key'" ).append("\n"); 
		query.append("		                                                                                    #end" ).append("\n"); 
		query.append("	                                                                                     #end" ).append("\n"); 
		query.append("	                                                                                )" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("	 #if ($arrToLcc.size() > 0)" ).append("\n"); 
		query.append("        AND MST_LOC_FNC(NVL (SUBSTR (ERPN.TO_YD_CD, 1, 5), ERPN.TO_LOC_CD), 'LCC') IN(" ).append("\n"); 
		query.append("	                                                                                   #foreach ($key in ${arrToLcc})" ).append("\n"); 
		query.append("		                                                                                    #if($velocityCount < $arrToLcc.size())" ).append("\n"); 
		query.append("		                                                                                       '$key'," ).append("\n"); 
		query.append("		                                                                                    #else" ).append("\n"); 
		query.append("		                                                                                       '$key'" ).append("\n"); 
		query.append("		                                                                                    #end" ).append("\n"); 
		query.append("	                                                                                     #end" ).append("\n"); 
		query.append("	                                                                                )" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("	 #if ($arrToEcc.size() > 0)" ).append("\n"); 
		query.append("        AND MST_LOC_FNC(NVL (SUBSTR (ERPN.TO_YD_CD, 1, 5), ERPN.TO_LOC_CD), 'ECC') IN(" ).append("\n"); 
		query.append("	                                                                                   #foreach ($key in ${arrToEcc})" ).append("\n"); 
		query.append("		                                                                                    #if($velocityCount < $arrToEcc.size())" ).append("\n"); 
		query.append("		                                                                                       '$key'," ).append("\n"); 
		query.append("		                                                                                    #else" ).append("\n"); 
		query.append("		                                                                                       '$key'" ).append("\n"); 
		query.append("		                                                                                    #end" ).append("\n"); 
		query.append("	                                                                                     #end" ).append("\n"); 
		query.append("	                                                                                )" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("	 #if ($arrToLoc.size() > 0)" ).append("\n"); 
		query.append("	    AND NVL(SUBSTR(ERPN.TO_YD_CD, 1, 5), ERPN.TO_LOC_CD) IN(" ).append("\n"); 
		query.append("								    #foreach ($key in ${arrToLoc})" ).append("\n"); 
		query.append("									#if($velocityCount < $arrToLoc.size())" ).append("\n"); 
		query.append("									'$key'," ).append("\n"); 
		query.append("									#else" ).append("\n"); 
		query.append("									'$key'" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("								    #end" ).append("\n"); 
		query.append("								    )" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 #if (${to_yard_cd} != '')" ).append("\n"); 
		query.append("	   AND ERPN.TO_YD_CD= @[to_yard_cd]" ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ORDER BY WEEK, REPO_PLN_ID, NO" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" GROUP BY  WEEK, REPO_PLN_ID, REPO_PLN_RMK, USR_ID, UPD_DT, CRE_DT	 	" ).append("\n"); 
		query.append("         , REPO_PLN_DTRB_FLG, AUTO, MANUAL, SCNR_ID" ).append("\n"); 
		query.append("         #if (${cbx_ep_tp_cd} == 'Y')" ).append("\n"); 
		query.append("         , NO" ).append("\n"); 
		query.append("         , EP_TP_CD" ).append("\n"); 
		query.append("         , DAT_TP_CD" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("		 #if (${cbx_rcc_cd} == 'Y')" ).append("\n"); 
		query.append("	 	 , FM_RCC_CD" ).append("\n"); 
		query.append("		 , TO_RCC_CD" ).append("\n"); 
		query.append("	 	 #end" ).append("\n"); 
		query.append("	 	 #if (${cbx_lcc_cd} == 'Y')" ).append("\n"); 
		query.append("	 	 , FM_LCC_CD" ).append("\n"); 
		query.append("		 , TO_LCC_CD" ).append("\n"); 
		query.append("	 	 #end" ).append("\n"); 
		query.append("	 	 #if (${cbx_ecc_cd} == 'Y')" ).append("\n"); 
		query.append("	 	 , FM_ECC_CD" ).append("\n"); 
		query.append("		 , TO_ECC_CD" ).append("\n"); 
		query.append("	 	 #end" ).append("\n"); 
		query.append("	 	 #if (${cbx_loc_cd} == 'Y')" ).append("\n"); 
		query.append("	 	 , FM_LOC_CD" ).append("\n"); 
		query.append("		 , TO_LOC_CD" ).append("\n"); 
		query.append("	 	 #end" ).append("\n"); 
		query.append("	 	 #if (${cbx_yard_cd} == 'Y')" ).append("\n"); 
		query.append("         , NO" ).append("\n"); 
		query.append("	 	 , FM_YARD_CD" ).append("\n"); 
		query.append("		 , TO_YARD_CD" ).append("\n"); 
		query.append("	 	 #end" ).append("\n"); 
		query.append("	 	 #if (${cbx_vvd_cd} == 'Y')" ).append("\n"); 
		query.append("	 	 , VVD" ).append("\n"); 
		query.append("	 	 #end" ).append("\n"); 
		query.append("	 	 #if (${cbx_emt_bkg_no} == 'Y')" ).append("\n"); 
		query.append("	 	 , BKG_NO" ).append("\n"); 
		query.append("	 	 #end" ).append("\n"); 
		query.append("	 	 #if (${cbx_ref_id} == 'Y')" ).append("\n"); 
		query.append("	 	 , REF_ID" ).append("\n"); 
		query.append("	 	 #end" ).append("\n"); 
		query.append("	 	 #if (${cbx_so_no} == 'Y')" ).append("\n"); 
		query.append("	 	 , SO_NO" ).append("\n"); 
		query.append("	 	 #end" ).append("\n"); 
		query.append(" ORDER BY WEEK, REPO_PLN_ID" ).append("\n"); 
		query.append("         #if (${cbx_ep_tp_cd} == 'Y')" ).append("\n"); 
		query.append("         , NO" ).append("\n"); 
		query.append("         #end" ).append("\n"); 

	}
}