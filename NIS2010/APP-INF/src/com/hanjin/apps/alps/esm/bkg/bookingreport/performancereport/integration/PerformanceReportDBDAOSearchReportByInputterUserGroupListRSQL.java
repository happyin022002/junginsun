/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchReportByInputterUserGroupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchReportByInputterUserGroupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchReportByInputterUserGroupListRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchReportByInputterUserGroupListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atnd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpcs_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_mt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pfm_by_queue_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchReportByInputterUserGroupListRSQL").append("\n"); 
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
		query.append("SELECT ATND_USR_ID AS USER_ID, NAME AS USER_NM" ).append("\n"); 
		query.append("     ,HIS_COUNT --@" ).append("\n"); 
		query.append("     ,BKG_COUNT AS BL_CNT, ORI_SI_CNT AS TOT_ORI_SI_CNT" ).append("\n"); 
		query.append("    --,ORI_AVG_TIME AS AVG_ORI_TIME" ).append("\n"); 
		query.append("    ,(BKG_GET_CONV_INTVAL_TIME_FNC(ORI_AVG_TIME,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(ORI_AVG_TIME,'SS') AVG_ORI_TIME" ).append("\n"); 
		query.append("    ,USR_ORI_PNT AS TOT_ORI_POINT, ORI_E_CNT_TOT AS TOT_ORI_EDI_SI_CNT" ).append("\n"); 
		query.append("    --,ORI_E_TIME_TOT AS TOT_ORI_EDI_TIME" ).append("\n"); 
		query.append("    ,(BKG_GET_CONV_INTVAL_TIME_FNC(ORI_E_TIME_TOT,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(ORI_E_TIME_TOT,'SS') TOT_ORI_EDI_TIME" ).append("\n"); 
		query.append("    ,ORI_M_CNT_TOT AS tot_ori_email_si_cnt" ).append("\n"); 
		query.append("    --, ORI_M_TIME_TOT AS tot_ori_email_time" ).append("\n"); 
		query.append("    ,(BKG_GET_CONV_INTVAL_TIME_FNC(ORI_M_TIME_TOT,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(ORI_M_TIME_TOT,'SS') tot_ori_email_time" ).append("\n"); 
		query.append("    ,ORI_F_CNT_TOT AS tot_ori_fax_si_cnt" ).append("\n"); 
		query.append("    --, ORI_F_TIME_TOT AS tot_ori_fax_time" ).append("\n"); 
		query.append("    ,(BKG_GET_CONV_INTVAL_TIME_FNC(ORI_F_TIME_TOT,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(ORI_F_TIME_TOT,'SS') tot_ori_fax_time" ).append("\n"); 
		query.append("    ,ORI_S_CNT_TOT AS tot_ori_SEA_si_cnt --@" ).append("\n"); 
		query.append("    --, ORI_F_TIME_TOT AS tot_ori_fax_time" ).append("\n"); 
		query.append("    ,(BKG_GET_CONV_INTVAL_TIME_FNC(ORI_S_TIME_TOT,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(ORI_S_TIME_TOT,'SS') tot_ori_SEA_time --@" ).append("\n"); 
		query.append("    , AMD_CNT_ID AS tot_amend_cnt" ).append("\n"); 
		query.append("    --,AMD_TIME_ID AS tot_amend_time" ).append("\n"); 
		query.append("    ,(BKG_GET_CONV_INTVAL_TIME_FNC(AMD_TIME_ID,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(AMD_TIME_ID,'SS') tot_amend_time" ).append("\n"); 
		query.append("    --,AVG_AMD_TIME_ID AS tot_amend_avg_time" ).append("\n"); 
		query.append("    ,(BKG_GET_CONV_INTVAL_TIME_FNC(AVG_AMD_TIME_ID,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(AVG_AMD_TIME_ID,'SS') tot_amend_avg_time" ).append("\n"); 
		query.append("    ,USR_A_PNT AS tot_amend_point" ).append("\n"); 
		query.append("    ,R_H_CNT_ID AS tot_rider_hbl_cnt" ).append("\n"); 
		query.append("    ,(BKG_GET_CONV_INTVAL_TIME_FNC(R_H_TIME_ID,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(R_H_TIME_ID,'SS') tot_rider_hbl_time" ).append("\n"); 
		query.append("    ,(BKG_GET_CONV_INTVAL_TIME_FNC(AVG_R_H_TIME_ID,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(AVG_R_H_TIME_ID,'SS') tot_rider_hbl_avg_time" ).append("\n"); 
		query.append("    , R_H_PNT AS tot_rider_hbl_point" ).append("\n"); 
		query.append("    ,E_T_CNT_ID AS tot_order_cnt" ).append("\n"); 
		query.append("    --,E_T_TIME_ID AS tot_order_time" ).append("\n"); 
		query.append("    ,(BKG_GET_CONV_INTVAL_TIME_FNC(E_T_TIME_ID,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(E_T_TIME_ID,'SS') tot_order_time" ).append("\n"); 
		query.append("    --, AVG_E_T_TIME_ID AS tot_order_avg_time" ).append("\n"); 
		query.append("    ,(BKG_GET_CONV_INTVAL_TIME_FNC(AVG_E_T_TIME_ID,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(AVG_E_T_TIME_ID,'SS') tot_order_avg_time" ).append("\n"); 
		query.append("    ,F_M_HBL_CNT_TOT AS tot_hbl_mail_fax_cnt, CM_CNT_TOT AS tot_cm_cnt, CN_CNT_TOT AS tot_cntr_cnt" ).append("\n"); 
		query.append("    ,CSTMS_MF_TP_CD_CNT_TOT AS TOT_CSTMS_MF_TP_CD_CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT --RN_BY_ID," ).append("\n"); 
		query.append("        decode(RN_BY_ID,1,SUM(ORI_CNT) OVER(PARTITION BY ATND_USR_ID ),0) ORI_SI_CNT --> ORI S/I TOTAL" ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(HIS_CNT_NOT_DUP) OVER(PARTITION BY ATND_USR_ID ),0) HIS_COUNT --> HISTOY COUNT --★" ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,COUNT(DISTINCT BKG_NO) OVER(PARTITION BY ATND_USR_ID ),0) BKG_COUNT --> BKG COUNT --★" ).append("\n"); 
		query.append("        ,CASE WHEN SUM(ORI_in_time) OVER(PARTITION BY ATND_USR_ID ) = 0 OR SUM(ORI_CNT) OVER(PARTITION BY ATND_USR_ID ) = 0 THEN 0 " ).append("\n"); 
		query.append("              ELSE decode(RN_BY_ID,1,SUM(ORI_in_time) OVER(PARTITION BY ATND_USR_ID )/SUM(ORI_CNT) OVER(PARTITION BY ATND_USR_ID ),0) " ).append("\n"); 
		query.append("         END AS ORI_avg_time" ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(ORI_in_time) OVER(PARTITION BY ATND_USR_ID ) ,0)tot_ori_in_time" ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(HIS_O_PNT) OVER(PARTITION BY ATND_USR_ID ),0) AS USR_ORI_PNT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(ORI_E_CNT) OVER(PARTITION BY ATND_USR_ID ),0) AS ORI_E_CNT_TOT" ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(ORI_E_TIME) OVER(PARTITION BY ATND_USR_ID ),0) AS ORI_E_TIME_TOT" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(ORI_M_CNT) OVER(PARTITION BY ATND_USR_ID ),0) AS ORI_M_CNT_TOT    " ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(ORI_M_TIME) OVER(PARTITION BY ATND_USR_ID ),0) AS ORI_M_time_TOT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(ORI_F_CNT) OVER(PARTITION BY ATND_USR_ID ),0) AS ORI_F_CNT_TOT" ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(ORI_F_TIME) OVER(PARTITION BY ATND_USR_ID ),0) AS ORI_F_time_TOT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(ORI_S_CNT) OVER(PARTITION BY ATND_USR_ID ),0) AS ORI_S_CNT_TOT--★" ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(ORI_S_TIME) OVER(PARTITION BY ATND_USR_ID ),0) AS ORI_S_time_TOT--★" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        --TYPE A-" ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(AMD_CNT) OVER(PARTITION BY ATND_USR_ID ),0) AS AMD_CNT_id      " ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(AMD_TIME) OVER(PARTITION BY ATND_USR_ID ),0) AMD_TIME_ID" ).append("\n"); 
		query.append("        ,CASE WHEN decode(RN_BY_ID,1,SUM(AMD_CNT) OVER(PARTITION BY ATND_USR_ID ),0) = 0 OR decode(RN_BY_ID,1,SUM(AMD_TIME) OVER(PARTITION BY ATND_USR_ID ),0) = 0 THEN 0" ).append("\n"); 
		query.append("              ELSE decode(RN_BY_ID,1, (SUM(AMD_TIME) OVER(PARTITION BY ATND_USR_ID )/SUM(AMD_CNT) OVER(PARTITION BY ATND_USR_ID )) ,0) " ).append("\n"); 
		query.append("         END AVG_AMD_TIME_ID" ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(HIS_A_PNT) OVER(PARTITION BY ATND_USR_ID ),0) USR_A_PNT " ).append("\n"); 
		query.append("        --TYPE R&H-" ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(R_H_CNT) OVER(PARTITION BY ATND_USR_ID ),0) R_H_CNT_id      " ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(R_H_TIME) OVER(PARTITION BY ATND_USR_ID ),0) R_H_TIME_ID" ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(USR_BKG_R_H_PNT) OVER(PARTITION BY ATND_USR_ID ),0) R_H_PNT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,CASE WHEN decode(RN_BY_ID,1,SUM(R_H_CNT) OVER(PARTITION BY ATND_USR_ID ),0)= 0  OR decode(RN_BY_ID,1,SUM(R_H_TIME) OVER(PARTITION BY ATND_USR_ID ),0) = 0 THEN  0" ).append("\n"); 
		query.append("              ELSE decode(RN_BY_ID,1, (SUM(R_H_TIME) OVER(PARTITION BY ATND_USR_ID )/SUM(R_H_CNT) OVER(PARTITION BY ATND_USR_ID )) ,0)" ).append("\n"); 
		query.append("         END AVG_R_H_TIME_ID" ).append("\n"); 
		query.append("        --TYPE E&T-" ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(E_T_CNT) OVER(PARTITION BY ATND_USR_ID ),0) E_T_CNT_id      " ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(E_T_TIME) OVER(PARTITION BY ATND_USR_ID ),0) E_T_TIME_ID" ).append("\n"); 
		query.append("        ,CASE WHEN decode(RN_BY_ID,1,SUM(E_T_CNT) OVER(PARTITION BY ATND_USR_ID ),0) = 0 OR decode(RN_BY_ID,1,SUM(E_T_TIME) OVER(PARTITION BY ATND_USR_ID ),0) = 0 THEN 0 " ).append("\n"); 
		query.append("              ELSE decode(RN_BY_ID,1, (SUM(E_T_TIME) OVER(PARTITION BY ATND_USR_ID )/SUM(E_T_CNT) OVER(PARTITION BY ATND_USR_ID )) ,0)" ).append("\n"); 
		query.append("         END AVG_E_T_TIME_ID" ).append("\n"); 
		query.append("        ,(SELECT  USR_NM FROM COM_USER WHERE USR_ID = c.ATND_USR_ID) NAME" ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(F_M_HBL_CNT) OVER(PARTITION BY ATND_USR_ID ),0) F_M_HBL_CNT_TOT" ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(CM_CNT) OVER(PARTITION BY ATND_USR_ID ),0) CM_CNT_TOT" ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(CN_CNT) OVER(PARTITION BY ATND_USR_ID ),0) CN_CNT_TOT" ).append("\n"); 
		query.append("        ,decode(RN_BY_ID,1,SUM(CSTMS_MF_TP_CD_CNT) OVER(PARTITION BY ATND_USR_ID ),0) CSTMS_MF_TP_CD_CNT_TOT" ).append("\n"); 
		query.append("        ,C.*" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            -- ori('O') 이고" ).append("\n"); 
		query.append("            -- (ATND_USR_ID,A.BKG_NO,SR_STS_CD) 그룹별  (SR_AMD_SEQ,SR_HIS_SEQ ) order인 1번 " ).append("\n"); 
		query.append("            -- (USER, BKG_NO 별 HISTORY, ORIGINAL 이 아닌게 1번 일수 있음)" ).append("\n"); 
		query.append("            -- ==> user별 ori이고 bkg별 his가 제일 적은것 으로 중복 제거 (sr하나에 his 여러개일떄)" ).append("\n"); 
		query.append("            DECODE(SR_AMD_TP_CD,'O', DECODE(HIS_DUP_NM,1, 1,0),0 ) ORI_cnt --★" ).append("\n"); 
		query.append("            ,DECODE(HIS_DUP_NM,1,1,0) HIS_CNT_NOT_DUP--★" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ,DECODE(SR_KND_CD,'E',( DECODE(SR_AMD_TP_CD,'O', DECODE(HIS_DUP_NM,1, 1,0),0 )),0) ORI_E_cnt --★" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ,DECODE(SR_KND_CD,'F',( DECODE(SR_AMD_TP_CD,'O', DECODE(HIS_DUP_NM,1, 1,0),0 )),0) ORI_f_cnt --★" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ,DECODE(SR_KND_CD,'M',( DECODE(SR_AMD_TP_CD,'O', DECODE(HIS_DUP_NM,1, 1,0),0 )),0) ORI_M_cnt --★" ).append("\n"); 
		query.append("            ,DECODE(SR_KND_CD,'S',( DECODE(SR_AMD_TP_CD,'O', DECODE(HIS_DUP_NM,1, 1,0),0 )),0) ORI_S_cnt --★" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ,DECODE(HIS_DUP_NM ,1 , SR_PROC_HRS , 0)   ELAPSED_NOT_DUP --★" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ------------" ).append("\n"); 
		query.append("            ,CASE WHEN SR_AMD_TP_CD IN('O','N') THEN SR_PROC_HRS --to_number(INPUT_ELAPSED)" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("            END ORI_in_time" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ----------- 개별 time     " ).append("\n"); 
		query.append("            ----------- ori 이고 edi 인 his 모두 " ).append("\n"); 
		query.append("            ,DECODE(SR_KND_CD,'E',( DECODE(SR_AMD_TP_CD,'O', DECODE(HIS_DUP_NM,1, SR_PROC_HRS ,0),0 )),0) ORI_E_time --★            " ).append("\n"); 
		query.append("            ,DECODE(SR_KND_CD,'M',( DECODE(SR_AMD_TP_CD,'O', DECODE(HIS_DUP_NM,1, SR_PROC_HRS ,0),0 )),0) ORI_M_time --★            " ).append("\n"); 
		query.append("            ,DECODE(SR_KND_CD,'F',( DECODE(SR_AMD_TP_CD,'O', DECODE(HIS_DUP_NM,1, SR_PROC_HRS ,0),0 )),0) ORI_F_time --★            " ).append("\n"); 
		query.append("            ,DECODE(SR_KND_CD,'S',( DECODE(SR_AMD_TP_CD,'O', DECODE(HIS_DUP_NM,1, SR_PROC_HRS ,0),0 )),0) ORI_S_time --★            " ).append("\n"); 
		query.append("            ----TYPE A--------" ).append("\n"); 
		query.append("            ,DECODE(SR_AMD_TP_CD,'A', DECODE(HIS_DUP_NM,1, 1,0),0 ) AMD_cnt --★" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("            , DECODE(SR_AMD_TP_CD,'A', DECODE(HIS_DUP_NM,1, SR_PROC_HRS ,0),0 ) AMD_time--★                        " ).append("\n"); 
		query.append("            ----TYPE R&H--------" ).append("\n"); 
		query.append("            ,CASE WHEN SR_AMD_TP_CD IN ('R','H') AND HIS_DUP_NM= 1 THEN 1" ).append("\n"); 
		query.append("                  ELSE 0" ).append("\n"); 
		query.append("             END R_H_CNT --★  " ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("            ,CASE WHEN SR_AMD_TP_CD IN ('R','H') AND HIS_DUP_NM= 1 THEN SR_PROC_HRS --to_number(INPUT_ELAPSED)" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("            END R_H_time--★  " ).append("\n"); 
		query.append("            ----TYPE E,T (AES)--------" ).append("\n"); 
		query.append("            ,CASE WHEN HIS_DUP_NM = 1 AND SR_STS_CD = decode(@[pfm_by_queue_cd],'I','ID','A','AD')  AND SR_AMD_TP_CD IN ('E','C','I','T','B') THEN 1" ).append("\n"); 
		query.append("                  ELSE 0" ).append("\n"); 
		query.append("             END E_T_CNT --AES_CNT_ID  --★                 " ).append("\n"); 
		query.append("            ,CASE WHEN SR_AMD_TP_CD IN ('E','C','I','T','B') AND SR_STS_CD = decode(@[pfm_by_queue_cd],'I','ID','A','AD') AND HIS_DUP_NM = 1 THEN SR_PROC_HRS --to_number(INPUT_ELAPSED)" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("            END E_T_time                " ).append("\n"); 
		query.append("            --BKG_NO의 H/BL CNT---------------------" ).append("\n"); 
		query.append("            ,CASE WHEN SR_BKG_NM =1  --USER_SR_BKG_NM =1 --USER별로 SR_STS_CD,BKG 별 1번만 적용 로직(여기선 SR('ID')은 동일하므로 BKG별이됨)" ).append("\n"); 
		query.append("                   THEN ( SELECT NVL(MAX(HBL_SEQ),'0') FROM BKG_HBL WHERE BKG_NO = B.BKG_NO) " ).append("\n"); 
		query.append("                   ELSE 0" ).append("\n"); 
		query.append("            END F_M_HBL_CNT --H/BL        " ).append("\n"); 
		query.append("                   " ).append("\n"); 
		query.append("            ,CASE WHEN SR_BKG_NM =1 --USER별로 SR_STS_CD,BKG 별 1번만 적용 로직(여기선 SR은 동일하므로 BKG별이됨)" ).append("\n"); 
		query.append("                   THEN (SELECT COUNT(*) FROM BKG_CNTR_MF_DESC WHERE BKG_NO = B.BKG_NO)" ).append("\n"); 
		query.append("                   ELSE 0" ).append("\n"); 
		query.append("            END CM_CNT --CM CNT         " ).append("\n"); 
		query.append("            ,CASE WHEN SR_BKG_NM =1 --USER별로 SR_STS_CD,BKG 별 1번만 적용 로직(여기선 SR은 동일하므로 BKG별이됨)" ).append("\n"); 
		query.append("                   THEN (SELECT  COUNT(*) FROM BKG_CONTAINER WHERE BKG_NO = B.BKG_NO)" ).append("\n"); 
		query.append("                   ELSE 0" ).append("\n"); 
		query.append("            END CN_CNT --CN CNT        " ).append("\n"); 
		query.append("            -- point" ).append("\n"); 
		query.append("            --rn_bkg (전체대상 bkg rownum)" ).append("\n"); 
		query.append("            --SR_BKG_NM :   그룹 (A.BKG_NO,SR_STS_CD) 별(=sr_sts_cd는 한종류이므로 bkg 그룹별과 같음) , order (SR_AMD_SEQ,SR_HIS_SEQ )순 rownum " ).append("\n"); 
		query.append("            -- bkg별 기준:  rn_bkg (전체대상 bkg rownum) =1 인것에 각각 구하고 rn_by_id=1 에 모음. " ).append("\n"); 
		query.append("            ,'PPPPPP--------->>>>' PNT" ).append("\n"); 
		query.append("            -- HIS_DUP_NM 별 inputer점수 (history 별 점수, POINT표 점수)" ).append("\n"); 
		query.append("            ,case when HIS_DUP_NM = 1  and SR_STS_CD='ID' " ).append("\n"); 
		query.append("                  then " ).append("\n"); 
		query.append("                     NVL((SELECT  to_number(ATTR_CTNT5)" ).append("\n"); 
		query.append("                         FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                        WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                          and 'I' = SUBSTR(SR_STS_CD,0,1) --id,Rd" ).append("\n"); 
		query.append("                          AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1)" ).append("\n"); 
		query.append("                          AND ATTR_CTNT2 = b.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                          and b.SR_AMD_TP_CD in ('O','A','B','T','E','C','I')" ).append("\n"); 
		query.append("                          AND ATTR_CTNT3 = b.SR_AMD_TP_CD -- L All,O Original,A Amend,B BL Confim,T Addition,E AES,C CAED,I IE" ).append("\n"); 
		query.append("                        ),0) " ).append("\n"); 
		query.append("                   else 0" ).append("\n"); 
		query.append("              end i_BAS_PNT --IFA     --★           " ).append("\n"); 
		query.append("            ,CASE WHEN HIS_DUP_NM = 1 -- USER_SR_BKG_NM =1 -- HISTORY 별로 점수 주기로 해서 DUP =1에 점수 줌 --(X)SR_STS_CD,BKG 별 1번만 적용 로직(여기선 SR은 동일하므로 BKG별이됨)" ).append("\n"); 
		query.append("                   AND SR_AMD_TP_CD IN('O','N') " ).append("\n"); 
		query.append("                  THEN NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                            FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                           WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                             AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                             AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                             and b.SR_AMD_TP_CD ='O' --★  " ).append("\n"); 
		query.append("                             AND ATTR_CTNT3 = b.SR_AMD_TP_CD -- --★  " ).append("\n"); 
		query.append("                         ),0)" ).append("\n"); 
		query.append("                   ELSE 0" ).append("\n"); 
		query.append("            END HIS_O_PNT  --USR_BKG_O_PNT -- 위의 i_BAS_PNT 는 SR_AMD_TP_CD별로 다시 구분해야 해서 별도로 계산해서 SUM하기 편하게 " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ,CASE WHEN HIS_DUP_NM = 1 -- ★ USER_SR_BKG_NM =1 -- HISTORY 별로 점수 주기로 해서 DUP =1에 점수 줌  --SR_STS_CD,BKG,AMD_TP,AMD_SEQ 별 1번만 적용 로직(여기선 SR은 동일하므로 BKG,SR_NO별이됨)" ).append("\n"); 
		query.append("                   AND SR_AMD_TP_CD ='A'" ).append("\n"); 
		query.append("                  THEN NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                            FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                           WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                             AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                             AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                             and b.SR_AMD_TP_CD ='A' --★" ).append("\n"); 
		query.append("                             AND ATTR_CTNT3 = b.SR_AMD_TP_CD -- --★  " ).append("\n"); 
		query.append("                         ),0)" ).append("\n"); 
		query.append("                  ELSE 0" ).append("\n"); 
		query.append("            END HIS_A_PNT   --USR_BKG_A_PNT  " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("            ,0 USR_BKG_R_H_PNT  -- 'H'는 BKG_HBL 참조해서 구함." ).append("\n"); 
		query.append("            ,CASE  WHEN SR_BKG_NM =1 --BKG 별 1번만 적용 로직" ).append("\n"); 
		query.append("                     and SR_STS_CD ='ID' " ).append("\n"); 
		query.append("                     AND (SELECT NVL(MAX(HBL_SEQ),'0') FROM BKG_HBL WHERE BKG_NO = B.BKG_NO ) >= NVL((" ).append("\n"); 
		query.append("                                        SELECT ATTR_CTNT4 FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                                        WHERE HRD_CDG_ID ='DPCS_RPT_WGT'" ).append("\n"); 
		query.append("                                        AND ATTR_CTNT1 = 'I' --SUBSTR(CC.SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                        AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                        AND ATTR_CTNT3 = 'H'" ).append("\n"); 
		query.append("                                        ), '999') " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                    THEN  " ).append("\n"); 
		query.append("                        (SELECT  TO_NUMBER(ATTR_CTNT5 )" ).append("\n"); 
		query.append("                            FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                           WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                             AND ATTR_CTNT1 = 'I' --SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                             AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                             AND ATTR_CTNT3 = 'H' --" ).append("\n"); 
		query.append("                         ) * ((SELECT NVL(MAX(HBL_SEQ),'0') FROM BKG_HBL WHERE BKG_NO = B.BKG_NO ) - " ).append("\n"); 
		query.append("                                       (" ).append("\n"); 
		query.append("                                            SELECT ATTR_CTNT4 FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                                            WHERE HRD_CDG_ID ='DPCS_RPT_WGT'" ).append("\n"); 
		query.append("                                            AND ATTR_CTNT1 = 'I' --SUBSTR(CC.SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                            AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                            AND ATTR_CTNT3 = 'H'" ).append("\n"); 
		query.append("                                        )+1" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("                    ELSE 0" ).append("\n"); 
		query.append("              END AS HBL_PNT   --★                       " ).append("\n"); 
		query.append("             ,CASE WHEN SR_BKG_NM=1 --BKG 별 1번만 적용 로직" ).append("\n"); 
		query.append("                    and SR_STS_CD ='ID' " ).append("\n"); 
		query.append("                    AND (SELECT COUNT(1) FROM BKG_CNTR_MF_DESC WHERE BKG_NO = B.BKG_NO) >=  NVL((" ).append("\n"); 
		query.append("                                                                    SELECT ATTR_CTNT4 FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                                                                    WHERE HRD_CDG_ID ='DPCS_RPT_WGT'" ).append("\n"); 
		query.append("                                                                    AND ATTR_CTNT1 = 'I' --SUBSTR(CC.SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                                                    AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                                                    AND ATTR_CTNT3 = 'M'" ).append("\n"); 
		query.append("                                                                    ), '999') " ).append("\n"); 
		query.append("                    THEN   " ).append("\n"); 
		query.append("                        NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                            FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                           WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                             AND ATTR_CTNT1 = 'I' --SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                             AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                             AND ATTR_CTNT3 = 'M' --" ).append("\n"); 
		query.append("                         ),0) * ( (SELECT COUNT(1) FROM BKG_CNTR_MF_DESC WHERE BKG_NO = B.BKG_NO) - " ).append("\n"); 
		query.append("                                  (" ).append("\n"); 
		query.append("                                    SELECT ATTR_CTNT4 FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                                    WHERE HRD_CDG_ID ='DPCS_RPT_WGT'" ).append("\n"); 
		query.append("                                    AND ATTR_CTNT1 = 'I' --SUBSTR(CC.SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                    AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                    AND ATTR_CTNT3 = 'M'" ).append("\n"); 
		query.append("                                  ) +1" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                    ELSE 0" ).append("\n"); 
		query.append("               END AS CM_PNT   " ).append("\n"); 
		query.append("             ,CASE  WHEN SR_BKG_NM =1 --BKG 별 1번만 적용 로직" ).append("\n"); 
		query.append("                    and SR_STS_CD ='ID' " ).append("\n"); 
		query.append("                    AND (SELECT  COUNT(1) FROM BKG_CONTAINER WHERE BKG_NO = B.BKG_NO) >=  NVL((" ).append("\n"); 
		query.append("                                                                    SELECT ATTR_CTNT4 FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                                                                    WHERE HRD_CDG_ID ='DPCS_RPT_WGT'" ).append("\n"); 
		query.append("                                                                    AND ATTR_CTNT1 = 'I' --SUBSTR(CC.SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                                                    AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                                                    AND ATTR_CTNT3 = 'N'" ).append("\n"); 
		query.append("                                                                    ), '999') " ).append("\n"); 
		query.append("                    THEN   " ).append("\n"); 
		query.append("                        NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                            FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                           WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                             AND ATTR_CTNT1 = 'I' --SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                             AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                             AND ATTR_CTNT3 = 'N' --" ).append("\n"); 
		query.append("    --                         AND ATTR_CTNT4 = '5' --" ).append("\n"); 
		query.append("                         ),0) * ( (SELECT  COUNT(1) FROM BKG_CONTAINER WHERE BKG_NO = B.BKG_NO) - " ).append("\n"); 
		query.append("                                  (" ).append("\n"); 
		query.append("                                    SELECT ATTR_CTNT4 FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                                    WHERE HRD_CDG_ID ='DPCS_RPT_WGT'" ).append("\n"); 
		query.append("                                    AND ATTR_CTNT1 = 'I' --SUBSTR(CC.SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                    AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                    AND ATTR_CTNT3 = 'N'" ).append("\n"); 
		query.append("                                   ) +1" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                    ELSE 0" ).append("\n"); 
		query.append("               END AS CN_PNT " ).append("\n"); 
		query.append("            ,CASE WHEN SR_BKG_NM =1  AND CSTMS_MF_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("                   THEN  1" ).append("\n"); 
		query.append("                   ELSE 0" ).append("\n"); 
		query.append("                   END CSTMS_MF_TP_CD_CNT " ).append("\n"); 
		query.append("            ,B.* " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("                        SELECT /*+  ORDERED  */" ).append("\n"); 
		query.append("                        ATND_USR_ID," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER(PARTITION BY ATND_USR_ID ORDER BY ATND_USR_ID) RN_BY_ID, -- 1번에 total 구해서 둠." ).append("\n"); 
		query.append("                        H.SR_STS_CD,H.SR_HIS_SEQ" ).append("\n"); 
		query.append("                        -- SR_AMD_SEQ 가 가장낮은 HIS_DUP_NM 1번에 BKG_NO별 데이터를 모아두고 " ).append("\n"); 
		query.append("                        ,ROW_NUMBER() OVER (PARTITION BY A.SR_KND_CD, A.SR_NO, A.BKG_NO,SR_HIS_SEQ  ORDER BY SR_AMD_SEQ,SR_HIS_SEQ ) HIS_DUP_NM" ).append("\n"); 
		query.append("                        ,ROW_NUMBER() OVER (PARTITION BY A.SR_KND_CD,SR_STS_CD, A.SR_NO, A.BKG_NO,SR_HIS_SEQ  ORDER BY SR_AMD_SEQ,SR_HIS_SEQ ) HIS_DUP_NM2" ).append("\n"); 
		query.append("                        ,ROW_NUMBER() OVER (PARTITION BY A.BKG_NO,SR_STS_CD  ORDER BY SR_AMD_SEQ,SR_HIS_SEQ ) SR_BKG_NM" ).append("\n"); 
		query.append("                        -- sts,bkg 별 row, " ).append("\n"); 
		query.append("                        ,ROW_NUMBER() OVER (PARTITION BY ATND_USR_ID,A.BKG_NO,SR_STS_CD  ORDER BY SR_AMD_SEQ,SR_HIS_SEQ ) USER_SR_BKG_NM" ).append("\n"); 
		query.append("                        -- bkg,sr_no 별 row, sr_crnt_rqst 기준,  2이상이면 서로 다른 HISTORY가 2개이상이다는뜻 " ).append("\n"); 
		query.append("                        ,ROW_NUMBER() OVER (PARTITION BY ATND_USR_ID,SR_AMD_TP_CD,A.BKG_NO,A.SR_NO,SR_AMD_SEQ  ORDER BY SR_AMD_SEQ,SR_HIS_SEQ ) USER_SEQ_BKG_NM" ).append("\n"); 
		query.append("                        ,COUNT(DISTINCT A.RQST_RN) OVER (PARTITION BY A.BKG_NO ,SR_STS_CD) SI_CNT --해당 BKG에 SR_STS_CD의 RQST갯수-> S/I #" ).append("\n"); 
		query.append("                        ,ROW_NUMBER() OVER(PARTITION BY A.BKG_NO ORDER BY A.BKG_NO) RN_BKG" ).append("\n"); 
		query.append("                        ,COUNT(DISTINCT H.ATND_USR_ID) OVER (PARTITION BY A.BKG_NO,SR_STS_CD   ) STAFF_CNT" ).append("\n"); 
		query.append("                        ,COUNT(DISTINCT A.BKG_NO ) OVER (PARTITION BY SR_STS_CD) BKG_CNT_SR" ).append("\n"); 
		query.append("                        ,DECODE(DECODE(SUBSTR(RFA_NO,0,3),'DUM',NULL,RFA_NO),NULL,DECODE(SC_NO,NULL,DECODE(TAA_NO,NULL,NULL,'TAA'),'S/C'),'RFA') RATE_TYPE " ).append("\n"); 
		query.append("                        ------------------------" ).append("\n"); 
		query.append("                        ,count(distinct a.bkg_no) over (partition by H.ATND_USR_ID) bl_cnt_id" ).append("\n"); 
		query.append("                        ,COUNT(DISTINCT A.SR_NO) OVER(PARTITION BY H.ATND_USR_ID,A.BKG_NO,SR_AMD_TP_CD ) CNT_USER_AM_TP" ).append("\n"); 
		query.append("                        ------------------------" ).append("\n"); 
		query.append("                        ,A.RQST_RN,A.SRC,A.SR_KND_CD,A.SR_NO,A.BKG_NO,DECODE(A.SR_AMD_TP_CD,'N','O', A.SR_AMD_TP_CD) AS SR_AMD_TP_CD,A.SR_AMD_SEQ,A.SR_URG_CD" ).append("\n"); 
		query.append("                        ,A.SR_AMD_KND_CD,A.RCV_OFC_CD,A.DPCS_OFC_CD,A.SR_CRNT_STS_CD,A.SR_CRNT_INFO_CD,A.BL_DOC_INP_FLG" ).append("\n"); 
		query.append("                        ,A.BL_RT_FLG,A.BL_AUD_FLG,A.SR_WRK_STS_CD,A.BL_DRFT_FAX_OUT_FLG " ).append("\n"); 
		query.append("                        ,H.ST_DT, H.ST_GDT " ).append("\n"); 
		query.append("                        ,RFA_NO,B.TAA_NO,B.SC_NO, H.SR_PROC_HRS,G.DPCS_WRK_GRP_CD" ).append("\n"); 
		query.append("                        ,BKG_COM_INTG_CD_NM_FNC('CD02100',G.DPCS_WRK_GRP_CD) AS USER_GROUP" ).append("\n"); 
		query.append("                        ,NVL(BKG_COM_INTG_CD_NM_FNC('CD01577',A.SR_AMD_TP_CD),'ORIGINAL') AS SI_KIND --ORIGINAL:N(OLD),O(현재)" ).append("\n"); 
		query.append("                        ,NVL(BKG_GET_CONV_INTVAL_TIME_FNC(DECODE(SR_STS_CD,'ID',SR_PROC_HRS,NULL),'SS'),0) AS INPUT_ELAPSED  " ).append("\n"); 
		query.append("                        ,NVL(BKG_GET_CONV_INTVAL_TIME_FNC(DECODE(SR_STS_CD,'RD',SR_PROC_HRS,NULL),'SS'),0) AS RATE_ELAPSED      " ).append("\n"); 
		query.append("                        ,NVL(BKG_GET_CONV_INTVAL_TIME_FNC(DECODE(SR_STS_CD,'AD',SR_PROC_HRS,NULL),'SS'),0) AS QA_ELAPSED  " ).append("\n"); 
		query.append("                        ,NVL((SELECT CS.CSTMS_MF_TP_CD FROM   BKG_CSTMS_ADV_BL CS WHERE CS.BKG_NO = B.BKG_NO  AND CS.BL_NO = B.BL_NO AND ROWNUM = 1)," ).append("\n"); 
		query.append("                         (SELECT DECODE(R.ACK_RCV_STS_CD, 'A', 'ENS') " ).append("\n"); 
		query.append("                          FROM   BKG_CSTMS_EUR_BL      A" ).append("\n"); 
		query.append("                                ,BKG_CSTMS_ADV_EUR_RCV R" ).append("\n"); 
		query.append("                          WHERE  A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("                          AND    R.EUR_EDI_MSG_TP_ID = 'A' " ).append("\n"); 
		query.append("                          AND    A.MSG_SND_NO = R.MSG_RCV_NO " ).append("\n"); 
		query.append("                          AND	   R.ACK_RCV_STS_CD = 'A'" ).append("\n"); 
		query.append("                          AND    R.EDI_RCV_SEQ =  (SELECT MAX(R2.EDI_RCV_SEQ)" ).append("\n"); 
		query.append("                                        				FROM   BKG_CSTMS_ADV_EUR_RCV R2" ).append("\n"); 
		query.append("                                        				WHERE  R2.EUR_EDI_MSG_TP_ID = 'A' " ).append("\n"); 
		query.append("                                                		AND    R2.MSG_RCV_NO = R.MSG_RCV_NO" ).append("\n"); 
		query.append("                                                		--AND    R2.EDI_RCV_DT = R.EDI_RCV_DT" ).append("\n"); 
		query.append("                                                     )" ).append("\n"); 
		query.append("                          AND 	ROWNUM =1" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                        )  AS  CSTMS_MF_TP_CD" ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("                                /*" ).append("\n"); 
		query.append("                                * 해당 기간안에  ORIGINAL 을 포함된 RQST찾는다.NYC107621300" ).append("\n"); 
		query.append("                                * 찾은 ORIGINAL BKG에 해당하는 히스토리를 가져온다. (ID,RD,AD)" ).append("\n"); 
		query.append("                                */" ).append("\n"); 
		query.append("                                SELECT " ).append("\n"); 
		query.append("                                ROWNUM RQST_RN ," ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                BKG_COM_INTG_CD_NM_FNC('CD01581',R.SR_KND_CD) AS SRC" ).append("\n"); 
		query.append("                                ,SR_KND_CD,SR_NO, r.BKG_NO, SR_AMD_TP_CD, SR_AMD_SEQ, SR_URG_CD, SR_AMD_KND_CD, RCV_OFC_CD" ).append("\n"); 
		query.append("                                ,DPCS_OFC_CD, SR_CRNT_STS_CD, SR_CRNT_INFO_CD, BL_DOC_INP_FLG, BL_RT_FLG, BL_AUD_FLG,SR_WRK_STS_CD,BL_DRFT_FAX_OUT_FLG" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                                FROM BKG_SR_CRNT_RQST R" ).append("\n"); 
		query.append("                                WHERE  1=1" ).append("\n"); 
		query.append("                                AND R.DPCS_OFC_CD = NVL(@[dpcs_ofc_cd], R.DPCS_OFC_CD)" ).append("\n"); 
		query.append("                                AND (  1=2" ).append("\n"); 
		query.append("						        #if (${pfm_by_queue_cd} == 'I') " ).append("\n"); 
		query.append("                                  OR (BL_DOC_INP_DT >= TO_DATE(@[from_dt]||@[from_mt], 'YYYY-MM-DDHH24:MI')" ).append("\n"); 
		query.append("                                      AND  BL_DOC_INP_DT <= TO_DATE(@[to_dt]||@[to_mt], 'YYYY-MM-DDHH24:MI')+0.00068 ) " ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                                #if (${pfm_by_queue_cd} == 'R') " ).append("\n"); 
		query.append("                                  OR ( BL_RT_DT >= TO_DATE(@[from_dt]||@[from_mt], 'YYYY-MM-DDHH24:MI')" ).append("\n"); 
		query.append("                                      AND  BL_RT_DT <= TO_DATE(@[to_dt]||@[to_mt], 'YYYY-MM-DDHH24:MI')+0.00068 ) " ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                                #if (${pfm_by_queue_cd} == 'A') " ).append("\n"); 
		query.append("                                  OR ( BL_AUD_DT >= TO_DATE(@[from_dt]||@[from_mt], 'YYYY-MM-DDHH24:MI')" ).append("\n"); 
		query.append("                                      AND  BL_AUD_DT <=TO_DATE(@[to_dt]||@[to_mt], 'YYYY-MM-DDHH24:MI') +0.00068) " ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("                              ) A" ).append("\n"); 
		query.append("                            ,BKG_SR_HIS H" ).append("\n"); 
		query.append("                            ,BKG_DPCS_USR_GRP G" ).append("\n"); 
		query.append("                            ,BKG_BOOKING B" ).append("\n"); 
		query.append("                            ,BKG_RATE BR" ).append("\n"); 
		query.append("                        WHERE 1 = 1" ).append("\n"); 
		query.append("                          AND A.SR_KND_CD =  H.SR_KND_CD --FAX,EMAIL,EDI" ).append("\n"); 
		query.append("                          AND A.SR_NO =  H.SR_NO" ).append("\n"); 
		query.append("                          AND A.BKG_NO =  H.BKG_NO" ).append("\n"); 
		query.append("                          AND A.BKG_NO= B.BKG_NO" ).append("\n"); 
		query.append("                          AND A.BKG_NO= BR.BKG_NO" ).append("\n"); 
		query.append("                          AND B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD LIKE  DECODE(NVL(@[vvd_cd],''), '', '' ,@[vvd_cd])|| '%'" ).append("\n"); 
		query.append("                          AND H.ATND_USR_ID  = G.USR_ID(+)" ).append("\n"); 
		query.append("                          AND H.ATND_USR_ID = NVL(@[atnd_usr_id],H.ATND_USR_ID )" ).append("\n"); 
		query.append("        --                  AND H.SR_STS_CD IN ('ID','RD','AD')  " ).append("\n"); 
		query.append("                          AND H.SR_STS_CD = decode(@[pfm_by_queue_cd],'I','ID','R','RD','A','AD')" ).append("\n"); 
		query.append("                          AND EXISTS (SELECT 'Y' --DISTINCT RGN_OFC_CD " ).append("\n"); 
		query.append("                                FROM BKG_EML_ACCT_STUP S WHERE S.BKG_OFC_CD = B.BKG_OFC_CD AND S.RGN_OFC_CD = NVL(DECODE(@[region],'A','',@[region]),S.RGN_OFC_CD) AND ROWNUM = 1" ).append("\n"); 
		query.append("                             )    " ).append("\n"); 
		query.append("        )B                         " ).append("\n"); 
		query.append("    ) C    -- ORDER BY ATND_USR_ID,C.RN_BY_ID,C.BKG_NO" ).append("\n"); 
		query.append(") D           " ).append("\n"); 
		query.append("WHERE D.RN_BY_ID = 1" ).append("\n"); 

	}
}