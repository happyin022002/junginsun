/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UnmatchBLDBDAOSearchMultiRateBkgList1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.01 
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

public class UnmatchBLDBDAOSearchMultiRateBkgList1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Multi Rate BKG List for Audit(1) 조회
	  * </pre>
	  */
	public UnmatchBLDBDAOSearchMultiRateBkgList1RSQL(){
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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_pol_equals",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("t_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oft_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("multi_cntr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tpsz_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_del_equals",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgl_mlt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_upd_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sm_prime",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pls_zr_mnus_cd_1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_ins_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pls_zr_mnus_cd_2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pls_zr_mnus_cd_3",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOSearchMultiRateBkgList1RSQL").append("\n"); 
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
		query.append("SELECT  B.BKG_NO								AS  BKG_NO," ).append("\n"); 
		query.append("        B.SGL_MLT_CD                            AS  SGL_MLT_CD," ).append("\n"); 
		query.append("        B.OFT_CNT								AS  OFT_CNT," ).append("\n"); 
		query.append("        B.TPSZ_CNT								AS  TPSZ_CNT," ).append("\n"); 
		query.append("        B.RCT_RHQ_CD							AS  RCT_RHQ_CD," ).append("\n"); 
		query.append("        B.BKG_OFC_CD                            AS  BKG_OFC_CD," ).append("\n"); 
		query.append("        B.SVC_SCP_CD                            AS  SVC_SCP_CD," ).append("\n"); 
		query.append("        B.RT_APLY_DT                            AS  RT_APLY_DT," ).append("\n"); 
		query.append("        B.BKG_CRE_DT                            AS  BKG_CRE_DT," ).append("\n"); 
		query.append("        B.VPS_ETD_DT                            AS  VPS_ETD_DT," ).append("\n"); 
		query.append("        B.BDR_FLG                               AS  BDR_FLG," ).append("\n"); 
		query.append("        B.CTRT_TP_CD                            AS  BKG_CTRT_TP_CD," ).append("\n"); 
		query.append("        B.CTRT_NO                               AS  CTRT_NO," ).append("\n"); 
		query.append("        B.CMDT_CD                               AS  CMDT_CD," ).append("\n"); 
		query.append("        B.CMDT_NM_0								AS  CMDT_NM," ).append("\n"); 
		query.append("        B.PRC_CGO_TP_CD							AS  PRC_CGO_TP_CD," ).append("\n"); 
		query.append("        B.POR_CD								AS  POR_CD," ).append("\n"); 
		query.append("        B.POL_CD								AS  POL_CD," ).append("\n"); 
		query.append("        B.POD_CD								AS  POD_CD," ).append("\n"); 
		query.append("        B.DEL_CD								AS  DEL_CD," ).append("\n"); 
		query.append("        B.T_VVD									AS  T_VVD," ).append("\n"); 
		query.append("        B.POR_POL_EQUALS						AS  POR_POL_EQUALS," ).append("\n"); 
		query.append("        B.POD_DEL_EQUALS						AS  POD_DEL_EQUALS," ).append("\n"); 
		query.append("        B.MULTI_CNTR							AS  MULTI_CNTR," ).append("\n"); 
		query.append("        B.PRC_RT_MTCH_PATT_CD_1					AS  PRC_RT_MTCH_PATT_CD_1," ).append("\n"); 
		query.append("        B.CMDT_NM_1								AS  CMDT_NM_1," ).append("\n"); 
		query.append("        B.RAT_UT_CD_1							AS  RAT_UT_CD_1," ).append("\n"); 
		query.append("        B.PRC_CGO_TP_CD_1						AS  PRC_CGO_TP_CD_1," ).append("\n"); 
		query.append("        B.CALC_FRT_RT_AMT_1						AS  FNL_FRT_RT_AMT_1," ).append("\n"); 
		query.append("        B.NOTE_CTNT_1							AS  NOTE_CTNT_1," ).append("\n"); 
		query.append("        B.PRC_RT_MTCH_PATT_CD_2					AS  PRC_RT_MTCH_PATT_CD_2," ).append("\n"); 
		query.append("        B.CMDT_NM_2								AS  CMDT_NM_2," ).append("\n"); 
		query.append("        B.RAT_UT_CD_2							AS  RAT_UT_CD_2," ).append("\n"); 
		query.append("        B.PRC_CGO_TP_CD_2						AS  PRC_CGO_TP_CD_2," ).append("\n"); 
		query.append("        B.CALC_FRT_RT_AMT_2						AS  FNL_FRT_RT_AMT_2," ).append("\n"); 
		query.append("        B.NOTE_CTNT_2							AS  NOTE_CTNT_2," ).append("\n"); 
		query.append("        B.RAT_AS_QTY							AS  RAT_AS_QTY," ).append("\n"); 
		query.append("        B.CHG_UT_AMT							AS  CHG_UT_AMT," ).append("\n"); 
		query.append("        CASE	SIGN(B.CHG_UT_AMT - B.CALC_FRT_RT_AMT_1)" ).append("\n"); 
		query.append("            WHEN	1	THEN	'Plus'" ).append("\n"); 
		query.append("            WHEN    0	THEN    'Zero'" ).append("\n"); 
		query.append("            WHEN   -1	THEN    'Minus'" ).append("\n"); 
		query.append("        END										AS  PLS_ZR_MNUS_CD_1," ).append("\n"); 
		query.append("        CASE	SIGN(B.CHG_UT_AMT - B.CALC_FRT_RT_AMT_2)" ).append("\n"); 
		query.append("            WHEN    1	THEN    'Plus'" ).append("\n"); 
		query.append("            WHEN    0	THEN    'Zero'" ).append("\n"); 
		query.append("            WHEN   -1	THEN    'Minus'" ).append("\n"); 
		query.append("        END										AS  PLS_ZR_MNUS_CD_2," ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN    B.CMDT_NM_0 IN  (SELECT CMDT_NM FROM BKG_REV_OCN_FRT_MLT_RAT WHERE BKG_NO = B.BKG_NO)" ).append("\n"); 
		query.append("                THEN" ).append("\n"); 
		query.append("                    CASE    SIGN(B.CHG_UT_AMT - (" ).append("\n"); 
		query.append("                                                    SELECT  MAX(CALC_FRT_RT_AMT)" ).append("\n"); 
		query.append("                                                    FROM    BKG_REV_OCN_FRT_MLT_RAT" ).append("\n"); 
		query.append("                                                    WHERE   BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                    AND     CMDT_NM = B.CMDT_NM_0" ).append("\n"); 
		query.append("                                                    AND     RAT_UT_CD IN (" ).append("\n"); 
		query.append("                                                                            SELECT  RAT_UT_CD" ).append("\n"); 
		query.append("                                                                            FROM    BKG_CHG_RT" ).append("\n"); 
		query.append("                                                                            WHERE   BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                                            AND     CHG_CD = 'OFT'" ).append("\n"); 
		query.append("                                                                            AND     CHG_UT_AMT = (" ).append("\n"); 
		query.append("                                                                                                    SELECT  MAX(CHG_UT_AMT)" ).append("\n"); 
		query.append("                                                                                                    FROM    BKG_CHG_RT" ).append("\n"); 
		query.append("                                                                                                    WHERE   BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                                                                    AND     CHG_CD = 'OFT'))))" ).append("\n"); 
		query.append("                        WHEN    1	THEN    'Plus'" ).append("\n"); 
		query.append("                        WHEN    0	THEN    'Zero'" ).append("\n"); 
		query.append("                        WHEN   -1	THEN    'Minus'" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("        END										AS  PLS_ZR_MNUS_CD_3," ).append("\n"); 
		query.append("		B.PSA_NO                                AS  PSA_NO," ).append("\n"); 
		query.append("        B.SM_PRIME                              AS  SM_PRIME," ).append("\n"); 
		query.append("		B.ACT_CUST								AS	ACT_CUST," ).append("\n"); 
		query.append("        B.USR_UPD_CTNT							AS  USR_UPD_CTNT," ).append("\n"); 
		query.append("		B.USR_INS_AMT							AS	USR_INS_AMT," ).append("\n"); 
		query.append("        B.USR_UPD_CFM_FLG						AS  USR_UPD_CFM_FLG," ).append("\n"); 
		query.append("        B.CFM_DT								AS  CFM_DT," ).append("\n"); 
		query.append("        B.UPD_DT								AS  UPD_DT," ).append("\n"); 
		query.append("        B.UPD_USR_ID							AS  UPD_USR_ID," ).append("\n"); 
		query.append("        COUNT(1) OVER (PARTITION	BY	1)		AS	BL_CNT,	" ).append("\n"); 
		query.append("        ''										AS	DT_TYPE,			-- * DT_TYPE, FROM_DT, TO_DT :" ).append("\n"); 
		query.append("        ''										AS	FROM_DT,			-- 	날짜 검색에 필요한 변수를 VO에 담기위해 SELECT 할 때 가져온다..." ).append("\n"); 
		query.append("        ''										AS	TO_DT				-- 	안가져 오면 MultiRateBkgList1VO에 변수 추가 안됨." ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("            SELECT  A.RANK," ).append("\n"); 
		query.append("                    A.BKG_NO," ).append("\n"); 
		query.append("					CASE" ).append("\n"); 
		query.append("                        WHEN    A.OFT_CNT = 1   THEN    'S'" ).append("\n"); 
		query.append("                        WHEN    A.OFT_CNT >= 2" ).append("\n"); 
		query.append("                            THEN" ).append("\n"); 
		query.append("                                CASE" ).append("\n"); 
		query.append("                                    WHEN    A.OFT_CNT > (SELECT COUNT(DISTINCT RAT_UT_CD||PRC_CGO_TP_CD) FROM BKG_REV_OCN_FRT_MLT_RAT WHERE BKG_NO = A.BKG_NO)  THEN    'M'" ).append("\n"); 
		query.append("                                    WHEN    A.OFT_CNT = (SELECT COUNT(DISTINCT RAT_UT_CD||PRC_CGO_TP_CD) FROM BKG_REV_OCN_FRT_MLT_RAT WHERE BKG_NO = A.BKG_NO)  THEN    'S'" ).append("\n"); 
		query.append("                                END" ).append("\n"); 
		query.append("                    END                         AS  SGL_MLT_CD," ).append("\n"); 
		query.append("                    A.OFT_CNT," ).append("\n"); 
		query.append("                    A.TPSZ_CNT," ).append("\n"); 
		query.append("                    A.RCT_RHQ_CD," ).append("\n"); 
		query.append("                    A.BKG_OFC_CD," ).append("\n"); 
		query.append("                    A.SVC_SCP_CD," ).append("\n"); 
		query.append("                    A.RT_APLY_DT," ).append("\n"); 
		query.append("		            A.BKG_CRE_DT," ).append("\n"); 
		query.append("		            A.VPS_ETD_DT," ).append("\n"); 
		query.append("		            A.BDR_FLG," ).append("\n"); 
		query.append("                    A.CTRT_TP_CD," ).append("\n"); 
		query.append("                    A.CTRT_NO," ).append("\n"); 
		query.append("                    A.CMDT_CD," ).append("\n"); 
		query.append("                    A.CMDT_NM_0," ).append("\n"); 
		query.append("                    A.PRC_CGO_TP_CD," ).append("\n"); 
		query.append("                    A.POR_CD," ).append("\n"); 
		query.append("                    A.POL_CD," ).append("\n"); 
		query.append("                    A.POD_CD," ).append("\n"); 
		query.append("                    A.DEL_CD," ).append("\n"); 
		query.append("                    A.T_VVD," ).append("\n"); 
		query.append("                    A.POR_POL_EQUALS," ).append("\n"); 
		query.append("                    A.POD_DEL_EQUALS," ).append("\n"); 
		query.append("                    A.MULTI_CNTR," ).append("\n"); 
		query.append("                    A.PRC_RT_MTCH_PATT_CD_1," ).append("\n"); 
		query.append("                    A.CMDT_NM_1," ).append("\n"); 
		query.append("                    A.RAT_UT_CD_1," ).append("\n"); 
		query.append("                    A.PRC_CGO_TP_CD_1," ).append("\n"); 
		query.append("                    A.CALC_FRT_RT_AMT_1," ).append("\n"); 
		query.append("                    A.NOTE_CTNT_1," ).append("\n"); 
		query.append("                    A.PRC_RT_MTCH_PATT_CD_2," ).append("\n"); 
		query.append("                    A.CMDT_NM_2," ).append("\n"); 
		query.append("                    A.RAT_UT_CD_2," ).append("\n"); 
		query.append("                    A.PRC_CGO_TP_CD_2," ).append("\n"); 
		query.append("                    A.CALC_FRT_RT_AMT_2," ).append("\n"); 
		query.append("                    A.NOTE_CTNT_2," ).append("\n"); 
		query.append("		            A.RAT_AS_QTY," ).append("\n"); 
		query.append("                    CASE													-- 1st Per가 D7일 경우," ).append("\n"); 
		query.append("                        WHEN    A.RAT_UT_CD_1 = 'D7'						-- Charge 탭과 Auto-Rating의 Cargo Type이 맞지 않아" ).append("\n"); 
		query.append("                            THEN											-- CGO_CATE_CD는 비교하지 않고..." ).append("\n"); 
		query.append("                                (											-- 여러 개인 경우, 가장 큰 값 선택." ).append("\n"); 
		query.append("                                    SELECT  MAX(CHG_UT_AMT)" ).append("\n"); 
		query.append("                                    FROM    BKG_CHG_RT" ).append("\n"); 
		query.append("                                    WHERE   CHG_CD = 'OFT'" ).append("\n"); 
		query.append("                                    AND     BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                    AND     RAT_UT_CD = A.RAT_UT_CD_1)" ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                                (" ).append("\n"); 
		query.append("                                    SELECT  MAX(CHG_UT_AMT)" ).append("\n"); 
		query.append("                                    FROM    BKG_CHG_RT" ).append("\n"); 
		query.append("                                    WHERE   CHG_CD = 'OFT'" ).append("\n"); 
		query.append("                                    AND     BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                                    AND     RAT_UT_CD = A.RAT_UT_CD_1" ).append("\n"); 
		query.append("                                    AND     CGO_CATE_CD = A.PRC_CGO_TP_CD_1)" ).append("\n"); 
		query.append("                    END	AS  CHG_UT_AMT," ).append("\n"); 
		query.append("					A.PSA_NO," ).append("\n"); 
		query.append("                    A.SM_PRIME," ).append("\n"); 
		query.append("					A.ACT_CUST," ).append("\n"); 
		query.append("                    A.USR_UPD_CTNT," ).append("\n"); 
		query.append("					A.USR_INS_AMT," ).append("\n"); 
		query.append("                    A.USR_UPD_CFM_FLG," ).append("\n"); 
		query.append("                    A.CFM_DT," ).append("\n"); 
		query.append("                    A.UPD_DT," ).append("\n"); 
		query.append("		            A.UPD_USR_ID" ).append("\n"); 
		query.append("            FROM    (" ).append("\n"); 
		query.append("			            SELECT  MR.RANK," ).append("\n"); 
		query.append("        			            BB.BKG_NO," ).append("\n"); 
		query.append("        			            (SELECT COUNT(BKG_NO) FROM BKG_QUANTITY WHERE BKG_NO = BB.BKG_NO)						AS	TPSZ_CNT," ).append("\n"); 
		query.append("        			            (SELECT COUNT(BKG_NO) FROM BKG_REV_OCN_FRT_MLT_RAT WHERE BKG_NO = BB.BKG_NO)        	AS	OFT_CNT," ).append("\n"); 
		query.append("        			            (" ).append("\n"); 
		query.append("            		            	SELECT  A.OFC_CD" ).append("\n"); 
		query.append("            		            	FROM    MDM_ORGANIZATION A" ).append("\n"); 
		query.append("            		            	WHERE   A.OFC_TP_CD = 'HQ'" ).append("\n"); 
		query.append("            		            	START   WITH A.OFC_CD = BB.BKG_OFC_CD" ).append("\n"); 
		query.append("            		            	CONNECT BY PRIOR A.PRNT_OFC_CD = A.OFC_CD)											AS	RCT_RHQ_CD," ).append("\n"); 
		query.append("        			            BB.BKG_OFC_CD," ).append("\n"); 
		query.append("        			            BB.SVC_SCP_CD," ).append("\n"); 
		query.append("        			            TO_CHAR(BR.RT_APLY_DT, 'YYYY-MM-DD')													AS	RT_APLY_DT," ).append("\n"); 
		query.append("					            BB.BKG_CRE_DT," ).append("\n"); 
		query.append("					            (" ).append("\n"); 
		query.append("                                    SELECT  DISTINCT (" ).append("\n"); 
		query.append("                                        		SELECT  TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD HH24:MI:SS')	ETD" ).append("\n"); 
		query.append("                                        		FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                        		WHERE   VSL_CD = VVD1.VSL_CD" ).append("\n"); 
		query.append("                                        		AND     SKD_VOY_NO = VVD1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                        		AND     SKD_DIR_CD = VVD1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                        		AND     VPS_PORT_CD = VVD1.POL_CD" ).append("\n"); 
		query.append("                                        		AND     CLPT_IND_SEQ = VVD1.POL_CLPT_IND_SEQ)	ETD_DT" ).append("\n"); 
		query.append("                                    FROM    BKG_BOOKING		BK," ).append("\n"); 
		query.append("					            			BKG_VVD			VVD," ).append("\n"); 
		query.append("					            			BKG_VVD			VVD1," ).append("\n"); 
		query.append("					            			BKG_CONTAINER	CNTR," ).append("\n"); 
		query.append("					            			MDM_LOCATION	L" ).append("\n"); 
		query.append("                                    WHERE   BK.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                                    AND     BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                    AND     BK.POD_CD = VVD.POD_CD" ).append("\n"); 
		query.append("                                    AND     BK.BKG_NO = VVD1.BKG_NO" ).append("\n"); 
		query.append("                                    AND     BK.POL_CD = VVD1.POL_CD" ).append("\n"); 
		query.append("                                    AND     BK.BKG_NO = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("                                    AND     BK.POR_CD = L.LOC_CD" ).append("\n"); 
		query.append("                                    AND     L.DELT_FLG = 'N')															AS	VPS_ETD_DT," ).append("\n"); 
		query.append("					            DECODE(BD.BDR_FLG , 'N', 'N', 'Y', 'Y', 'N')											AS	BDR_FLG," ).append("\n"); 
		query.append("        			            DECODE(BR.BKG_CTRT_TP_CD, 'R', 'RFA', 'S', 'S/C', 'TAA')								AS	CTRT_TP_CD," ).append("\n"); 
		query.append("        			            DECODE(BR.BKG_CTRT_TP_CD, 'R', BB.RFA_NO, 'S', BB.SC_NO, BB.TAA_NO)						AS	CTRT_NO," ).append("\n"); 
		query.append("        			            BB.CMDT_CD," ).append("\n"); 
		query.append("        			            (SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = BB.CMDT_CD AND DELT_FLG = 'N')		AS	CMDT_NM_0," ).append("\n"); 
		query.append("        			            BB.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("        			            BB.POR_CD," ).append("\n"); 
		query.append("        			            BB.POL_CD," ).append("\n"); 
		query.append("        			            BB.POD_CD," ).append("\n"); 
		query.append("        			            BB.DEL_CD," ).append("\n"); 
		query.append("        			            BB.VSL_CD||BB.SKD_VOY_NO||BB.SKD_DIR_CD													AS	T_VVD," ).append("\n"); 
		query.append("					            DECODE(BB.POR_CD, BB.POL_CD, 'Y', 'N')													AS	POR_POL_EQUALS," ).append("\n"); 
		query.append("                                DECODE(BB.POD_CD, BB.DEL_CD, 'Y', 'N')													AS	POD_DEL_EQUALS," ).append("\n"); 
		query.append("        			            (" ).append("\n"); 
		query.append("            		            	SELECT  DECODE(COUNT(DISTINCT CNTR_TPSZ_CD), 1, 'N', 'Y')" ).append("\n"); 
		query.append("            		            	FROM    BKG_QTY_DTL " ).append("\n"); 
		query.append("            		            	WHERE   BKG_NO = BB.BKG_NO " ).append("\n"); 
		query.append("            		            	AND     CNTR_TPSZ_CD NOT LIKE 'Q%')													AS	MULTI_CNTR," ).append("\n"); 
		query.append("        			            MR.PRC_RT_MTCH_PATT_CD," ).append("\n"); 
		query.append("        			            MR.CMDT_NM," ).append("\n"); 
		query.append("        			            MR.RAT_UT_CD," ).append("\n"); 
		query.append("        			            MR.PRC_CGO_TP_CD," ).append("\n"); 
		query.append("        			            MR.CALC_FRT_RT_AMT," ).append("\n"); 
		query.append("        			            MR.NOTE_CTNT," ).append("\n"); 
		query.append("        			            CASE" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 1 THEN    MR.PRC_RT_MTCH_PATT_CD" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 2 THEN    LAG(MR.PRC_RT_MTCH_PATT_CD) OVER(ORDER BY BB.BKG_NO, MR.CALC_FRT_RT_AMT DESC)" ).append("\n"); 
		query.append("        			            END																						AS	PRC_RT_MTCH_PATT_CD_1," ).append("\n"); 
		query.append("        			            CASE" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 1 THEN    MR.CMDT_NM" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 2 THEN    LAG(MR.CMDT_NM) OVER(ORDER BY BB.BKG_NO, MR.CALC_FRT_RT_AMT DESC)" ).append("\n"); 
		query.append("        			            END																						AS	CMDT_NM_1," ).append("\n"); 
		query.append("        			            CASE" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 1 THEN    MR.RAT_UT_CD" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 2 THEN    LAG(MR.RAT_UT_CD) OVER(ORDER BY BB.BKG_NO, MR.CALC_FRT_RT_AMT DESC)" ).append("\n"); 
		query.append("        			            END																						AS	RAT_UT_CD_1," ).append("\n"); 
		query.append("        			            CASE" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 1 THEN    MR.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 2 THEN    LAG(MR.PRC_CGO_TP_CD) OVER(ORDER BY BB.BKG_NO, MR.CALC_FRT_RT_AMT DESC)" ).append("\n"); 
		query.append("        			            END																						AS	PRC_CGO_TP_CD_1," ).append("\n"); 
		query.append("        			            CASE" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 1 THEN    MR.CALC_FRT_RT_AMT" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 2 THEN    LAG(MR.CALC_FRT_RT_AMT) OVER(ORDER BY BB.BKG_NO, MR.CALC_FRT_RT_AMT DESC)" ).append("\n"); 
		query.append("        			            END																						AS	CALC_FRT_RT_AMT_1," ).append("\n"); 
		query.append("        			            CASE" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 1 THEN    MR.NOTE_CTNT" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 2 THEN    LAG(MR.NOTE_CTNT) OVER(ORDER BY BB.BKG_NO, MR.CALC_FRT_RT_AMT DESC)" ).append("\n"); 
		query.append("        			            END																						AS	NOTE_CTNT_1," ).append("\n"); 
		query.append("        			            CASE" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 1 THEN    NULL" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 2 THEN    MR.PRC_RT_MTCH_PATT_CD" ).append("\n"); 
		query.append("        			            END																						AS	PRC_RT_MTCH_PATT_CD_2," ).append("\n"); 
		query.append("        			            CASE" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 1 THEN    NULL" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 2 THEN    MR.CMDT_NM" ).append("\n"); 
		query.append("        			            END																						AS	CMDT_NM_2," ).append("\n"); 
		query.append("        			            CASE" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 1 THEN    NULL" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 2 THEN    MR.RAT_UT_CD" ).append("\n"); 
		query.append("        			            END																						AS	RAT_UT_CD_2," ).append("\n"); 
		query.append("        			            CASE" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 1 THEN    NULL" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 2 THEN    MR.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("        			            END																						AS	PRC_CGO_TP_CD_2," ).append("\n"); 
		query.append("        			            CASE" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 1 THEN    NULL" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 2 THEN    MR.CALC_FRT_RT_AMT" ).append("\n"); 
		query.append("        			            END																						AS	CALC_FRT_RT_AMT_2," ).append("\n"); 
		query.append("        			            CASE" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 1 THEN    NULL" ).append("\n"); 
		query.append("            		            	WHEN    MR.RANK = 2 THEN    MR.NOTE_CTNT" ).append("\n"); 
		query.append("        			            END																						AS	NOTE_CTNT_2," ).append("\n"); 
		query.append("					            MR.RAT_AS_QTY," ).append("\n"); 
		query.append("								CASE    SIGN((SELECT COUNT(DISTINCT PSA_NO) FROM BKG_DG_CGO WHERE BKG_NO = BB.BKG_NO AND CNTR_CGO_SEQ = '1') - 1)" ).append("\n"); 
		query.append("                                    WHEN    0                                                                                                       -- 개수가 1개이면" ).append("\n"); 
		query.append("                                        THEN    (SELECT DISTINCT PSA_NO FROM BKG_DG_CGO WHERE BKG_NO = BB.BKG_NO AND CNTR_CGO_SEQ = '1')" ).append("\n"); 
		query.append("                                    WHEN    1                                                                                                       -- 개수가 2개 이상이면" ).append("\n"); 
		query.append("                                        THEN    'M'" ).append("\n"); 
		query.append("                                END                                                                                 	AS  PSA_NO," ).append("\n"); 
		query.append("                                CASE    (SELECT STWG_CD FROM BKG_BOOKING WHERE BKG_NO = BB.BKG_NO)" ).append("\n"); 
		query.append("                                    WHEN    'OLBP'  THEN    'Y'" ).append("\n"); 
		query.append("                                    ELSE                    'N'" ).append("\n"); 
		query.append("                                END                                                                                 	AS  SM_PRIME," ).append("\n"); 
		query.append("								(SELECT AGMT_ACT_CNT_CD||AGMT_ACT_CUST_SEQ FROM BKG_BOOKING WHERE BKG_NO = BB.BKG_NO)   AS  ACT_CUST," ).append("\n"); 
		query.append("        			            MRU.USR_UPD_CTNT," ).append("\n"); 
		query.append("								MRU.USR_INS_AMT," ).append("\n"); 
		query.append("        			            MRU.USR_UPD_CFM_FLG," ).append("\n"); 
		query.append("        			            MRU.CFM_DT," ).append("\n"); 
		query.append("        			            MRU.UPD_DT," ).append("\n"); 
		query.append("					            MRU.UPD_USR_ID" ).append("\n"); 
		query.append("            			FROM    BKG_BOOKING								BB," ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("                                    SELECT  BKG_NO," ).append("\n"); 
		query.append("                                            RT_APLY_DT," ).append("\n"); 
		query.append("                                            BKG_CTRT_TP_CD" ).append("\n"); 
		query.append("                                    FROM    BKG_RATE" ).append("\n"); 
		query.append("									#if (${from_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("										#if (${dt_type} == 'APPL')" ).append("\n"); 
		query.append("                                    		WHERE   1 = 1" ).append("\n"); 
		query.append("                                    		AND     RT_APLY_DT >= TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                    		AND     RT_APLY_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("										#end" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("                                )                                       BR," ).append("\n"); 
		query.append("            					BKG_BL_DOC								BD,		-- BDR_FLG를 SELECT하기 위해 사용" ).append("\n"); 
		query.append("                    			(" ).append("\n"); 
		query.append("                        			SELECT  BKG_NO," ).append("\n"); 
		query.append("                                			DP_SEQ," ).append("\n"); 
		query.append("                                			OFT_CMB_SEQ," ).append("\n"); 
		query.append("                                			PRC_RT_MTCH_PATT_CD," ).append("\n"); 
		query.append("                                			RAT_UT_CD," ).append("\n"); 
		query.append("                                			PRC_CGO_TP_CD," ).append("\n"); 
		query.append("                                			RAT_AS_QTY," ).append("\n"); 
		query.append("                                			CURR_CD," ).append("\n"); 
		query.append("                                			CALC_FRT_RT_AMT," ).append("\n"); 
		query.append("                                			NOTE_CTNT," ).append("\n"); 
		query.append("                                			CMDT_NM," ).append("\n"); 
		query.append("                                			RANK()" ).append("\n"); 
		query.append("            									OVER(" ).append("\n"); 
		query.append("            											PARTITION	BY	BKG_NO" ).append("\n"); 
		query.append("            											ORDER		BY	CALC_FRT_RT_AMT	DESC," ).append("\n"); 
		query.append("            															DP_SEQ			ASC)	AS	RANK" ).append("\n"); 
		query.append("                        			FROM    BKG_REV_OCN_FRT_MLT_RAT)	MR," ).append("\n"); 
		query.append("                    			BKG_REV_OCN_FRT_MLT_RAT_USR				MRU" ).append("\n"); 
		query.append("            			WHERE   BB.BKG_NO = BR.BKG_NO" ).append("\n"); 
		query.append("            			AND     BB.BKG_NO = MR.BKG_NO" ).append("\n"); 
		query.append("            			AND     BB.BKG_NO = MRU.BKG_NO" ).append("\n"); 
		query.append("            			AND     BB.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("						AND     (" ).append("\n"); 
		query.append("            		            	SELECT  A.OFC_CD" ).append("\n"); 
		query.append("            		            	FROM    MDM_ORGANIZATION A" ).append("\n"); 
		query.append("            		            	WHERE   A.OFC_TP_CD = 'HQ'" ).append("\n"); 
		query.append("            		            	START   WITH A.OFC_CD = BB.BKG_OFC_CD" ).append("\n"); 
		query.append("            		            	CONNECT BY PRIOR A.PRNT_OFC_CD = A.OFC_CD) = @[rct_rhq_cd]" ).append("\n"); 
		query.append("            )   A" ).append("\n"); 
		query.append(")   B" ).append("\n"); 
		query.append("WHERE   ((B.OFT_CNT = 1 AND B.RANK = 1)	OR	(B.OFT_CNT >= 2 AND B.RANK = 2))	-- OFT개수가 1개면 RANK = 1, 2개 이상이면 RANK = 2 SELECT" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND	B.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${from_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("	#if (${dt_type} == 'BKG')" ).append("\n"); 
		query.append("		AND B.BKG_CRE_DT >= TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("		AND B.BKG_CRE_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#elseif (${dt_type} == 'ETD')" ).append("\n"); 
		query.append("		AND TO_DATE(B.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI:SS') >= TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("		AND TO_DATE(B.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI:SS') <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("	AND B.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${t_vvd} != '')" ).append("\n"); 
		query.append("	AND B.T_VVD LIKE '%'||@[t_vvd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("	AND B.CTRT_TP_CD = DECODE(@[bkg_ctrt_tp_cd], 'S', 'S/C'," ).append("\n"); 
		query.append("												 'R', 'RFA'," ).append("\n"); 
		query.append("													  'TAA')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ctrt_no} != '')" ).append("\n"); 
		query.append("	AND B.CTRT_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '')" ).append("\n"); 
		query.append("	AND B.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("	AND B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("	AND B.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("	AND B.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bdr_flg} != '')" ).append("\n"); 
		query.append("	AND B.BDR_FLG = @[bdr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_pol_equals} != '')" ).append("\n"); 
		query.append("	AND B.POR_POL_EQUALS = @[por_pol_equals]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_del_equals} != '')" ).append("\n"); 
		query.append("	AND B.POD_DEL_EQUALS = @[pod_del_equals]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${multi_cntr} != '')" ).append("\n"); 
		query.append("	AND B.MULTI_CNTR = @[multi_cntr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sm_prime} != '')" ).append("\n"); 
		query.append("	AND	B.SM_PRIME = @[sm_prime]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${usr_ins_amt} != '')" ).append("\n"); 
		query.append("	AND	DECODE(B.USR_INS_AMT, NULL, 'N'," ).append("\n"); 
		query.append("							  '',	'N'," ).append("\n"); 
		query.append("									'Y') = @[usr_ins_amt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sgl_mlt_cd} != '')" ).append("\n"); 
		query.append("	AND B.SGL_MLT_CD = @[sgl_mlt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${oft_cnt} != '')" ).append("\n"); 
		query.append("	AND DECODE(B.OFT_CNT, 1, '1'," ).append("\n"); 
		query.append("						  2, '2'," ).append("\n"); 
		query.append("							 (DECODE(SIGN(B.OFT_CNT - 2), 1, 'Over 2'))) = @[oft_cnt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tpsz_cnt} != '')" ).append("\n"); 
		query.append("	AND DECODE(B.TPSZ_CNT, 1, '1'," ).append("\n"); 
		query.append("						   2, '2'," ).append("\n"); 
		query.append("							  (DECODE(SIGN(B.TPSZ_CNT - 2), 1, 'Over 2'))) = @[tpsz_cnt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pls_zr_mnus_cd_1} != '')" ).append("\n"); 
		query.append("	AND DECODE(SIGN(B.CHG_UT_AMT - B.CALC_FRT_RT_AMT_1), 1, 'Plus'," ).append("\n"); 
		query.append("														 0, 'Zero'," ).append("\n"); 
		query.append("														-1, 'Minus') = @[pls_zr_mnus_cd_1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pls_zr_mnus_cd_2} != '')" ).append("\n"); 
		query.append("	AND DECODE(SIGN(B.CHG_UT_AMT - B.CALC_FRT_RT_AMT_2), 1, 'Plus'," ).append("\n"); 
		query.append("														 0, 'Zero'," ).append("\n"); 
		query.append("														-1, 'Minus') = @[pls_zr_mnus_cd_2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pls_zr_mnus_cd_3} != '')" ).append("\n"); 
		query.append("	AND DECODE(B.CMDT_NM_0,	B.CMDT_NM_1, DECODE(SIGN(B.CHG_UT_AMT - B.CALC_FRT_RT_AMT_1), 1, 'Plus'," ).append("\n"); 
		query.append("																						  0, 'Zero'," ).append("\n"); 
		query.append("																						 -1, 'Minus')," ).append("\n"); 
		query.append("							B.CMDT_NM_2, DECODE(SIGN(B.CHG_UT_AMT - B.CALC_FRT_RT_AMT_2), 1, 'Plus'," ).append("\n"); 
		query.append("																						  0, 'Zero'," ).append("\n"); 
		query.append("																						 -1, 'Minus')) = @[pls_zr_mnus_cd_3]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${usr_upd_cfm_flg} != '')" ).append("\n"); 
		query.append("	AND	B.USR_UPD_CFM_FLG = @[usr_upd_cfm_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER	BY	B.BKG_NO" ).append("\n"); 

	}
}