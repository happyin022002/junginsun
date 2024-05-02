/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchBlPerfVolByRegionGroupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.14 
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

public class PerformanceReportDBDAOSearchBlPerfVolByRegionGroupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchBlPerfVolByRegionGroupListRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchBlPerfVolByRegionGroupListRSQL(){
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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : PerformanceReportDBDAOSearchBlPerfVolByRegionGroupListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    trunc(TOTAL_I_POINT/TOT_HIS_CNT,2)  AVG_POINT_ID,--★" ).append("\n"); 
		query.append("    trunc(TOTAL_R_POINT/TOT_HIS_CNT,2)  AVG_POINT_RA,--★" ).append("\n"); 
		query.append("    trunc(TOTAL_A_POINT/TOT_BKG_CNT,2)  AVG_POINT_QA" ).append("\n"); 
		query.append("    ,trunc(sum(TOTAL_I_POINT)over(partition by R_S_ROW)/ sum(TOT_HIS_CNT) over(partition by R_S_ROW),2) TOT_AVG_POINT" ).append("\n"); 
		query.append("    ,sum_STAFF --★" ).append("\n"); 
		query.append("    ,sum(TOT_SI_CNT) over(partition by R_S_ROW) sum_si" ).append("\n"); 
		query.append("    ,sum(TOT_BKG_CNT) over(partition by R_S_ROW) sum_bkg" ).append("\n"); 
		query.append("    ,sum(TOT_ORI_EDI_CNT) over(partition by R_S_ROW) sum_ori_e_si" ).append("\n"); 
		query.append("    ,sum(TOT_ORI_FAX_CNT) over(partition by R_S_ROW) sum_ori_f_si" ).append("\n"); 
		query.append("    ,sum(TOT_ORI_MAIL_CNT) over(partition by R_S_ROW) sum_ori_m_si" ).append("\n"); 
		query.append("	,(BKG_GET_CONV_INTVAL_TIME_FNC(TOT_ELAPSED,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(TOT_ELAPSED,'SS')  TOT_ELAPSED" ).append("\n"); 
		query.append("    ,BKG_GET_CONV_INTVAL_TIME_FNC((TOT_ELAPSED),'DD') TOT_ELAPSED_DD" ).append("\n"); 
		query.append("    ,BKG_GET_CONV_INTVAL_TIME_FNC((TOT_ELAPSED),'HH') TOT_ELAPSED_HH" ).append("\n"); 
		query.append("    ,BKG_GET_CONV_INTVAL_TIME_FNC((TOT_ELAPSED),'MM') TOT_ELAPSED_MM" ).append("\n"); 
		query.append("    ,BKG_GET_CONV_INTVAL_TIME_FNC((TOT_ELAPSED),'SS') TOT_ELAPSED_SS --★ " ).append("\n"); 
		query.append("    ,(BKG_GET_CONV_INTVAL_TIME_FNC(TOT_ELAPSED/sum_HIS_CNT,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(TOT_ELAPSED/sum_HIS_CNT,'SS')  tot_avg_elapsed" ).append("\n"); 
		query.append("    ,BKG_GET_CONV_INTVAL_TIME_FNC((TOT_ELAPSED/sum_HIS_CNT),'DD') tot_avg_elapsed_dd" ).append("\n"); 
		query.append("    ,BKG_GET_CONV_INTVAL_TIME_FNC((TOT_ELAPSED/sum_HIS_CNT),'HH') tot_avg_elapsed_hh" ).append("\n"); 
		query.append("    ,BKG_GET_CONV_INTVAL_TIME_FNC((TOT_ELAPSED/sum_HIS_CNT),'MM') tot_avg_elapsed_mm" ).append("\n"); 
		query.append("    ,BKG_GET_CONV_INTVAL_TIME_FNC((TOT_ELAPSED/sum_HIS_CNT),'SS') tot_avg_elapsed_ss --★  " ).append("\n"); 
		query.append("    ,E.* " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        TOT_G,REGION,REGION_D,SR_STS_CD,R_S_ROW,TOT_STAFF,sum_STAFF,TOT_SI_CNT,TOT_HIS_CNT,SUM_HIS_CNT" ).append("\n"); 
		query.append("        ,TOT_BKG_CNT,TOT_HBL_CNT,TOT_ORI_EDI_CNT,TOT_ORI_FAX_CNT,TOT_ELAPSED" ).append("\n"); 
		query.append("        ,TOT_ORI_SEN_cnt" ).append("\n"); 
		query.append("        ,TOT_ORI_MAIL_CNT,TOT_AMD_ID_CNT,TOT_AMD_AD_CNT,TOT_AMD_RD_CNT,TOT_HBL_IN_ID_CNT" ).append("\n"); 
		query.append("        ,TOT_HBL_IN_AD_CNT,TOT_HBL_IN_RD_CNT,TOT_AES_ID_CNT,TOT_AES_AD_CNT,TOT_AES_RD_CNT" ).append("\n"); 
		query.append("        ,TOT_BL_CFM_CNT_ID_CNT,TOT_BL_CFM_CNT_AD_CNT,TOT_BL_CFM_CNT_RD_CNT--TOT_I_PNT,TOT_R_PNT,TOT_Q_PNT" ).append("\n"); 
		query.append("        ,TOT_ADDI_CNT_ID_CNT,TOT_ADDI_CNT_RD_CNT,TOT_ADDI_CNT_AD_CNT" ).append("\n"); 
		query.append("        ,TOT_HBL_PNT,TOT_CM_PNT,TOT_CN_PNT,TOT_RFA_PNT,TOT_TAA_PNT,TOT_SC_PNT,TOT_SELF_PNT" ).append("\n"); 
		query.append("        ,DECODE(SR_STS_CD,'ID','Input','RD','Rate','AD','QA') GROUP_D" ).append("\n"); 
		query.append("        ,CASE WHEN R_S_ROW = 1 THEN  " ).append("\n"); 
		query.append("                    (TOT_I_BAS_PNT +TOT_HBL_PNT + TOT_CM_PNT + TOT_CN_PNT + TOT_RFA_PNT+ TOT_TAA_PNT + TOT_SC_PNT + TOT_SELF_PNT + TOT_PRE_PNT) " ).append("\n"); 
		query.append("              ELSE 0" ).append("\n"); 
		query.append("         END TOTAL_I_POINT" ).append("\n"); 
		query.append("        ,CASE WHEN R_S_ROW = 1 THEN  " ).append("\n"); 
		query.append("                    (TOT_I_BAS_PNT +TOT_HBL_PNT + TOT_CM_PNT + TOT_CN_PNT + TOT_RFA_PNT+ TOT_TAA_PNT + TOT_SC_PNT + TOT_SELF_PNT + TOT_PRE_PNT) " ).append("\n"); 
		query.append("              ELSE 0" ).append("\n"); 
		query.append("         END TOTAL_R_POINT    " ).append("\n"); 
		query.append("        ,CASE WHEN R_S_ROW = 1 THEN  " ).append("\n"); 
		query.append("                   (TOT_I_BAS_PNT +TOT_HBL_PNT + TOT_CM_PNT + TOT_CN_PNT + TOT_RFA_PNT+ TOT_TAA_PNT + TOT_SC_PNT + TOT_SELF_PNT + TOT_PRE_PNT) " ).append("\n"); 
		query.append("              ELSE 0" ).append("\n"); 
		query.append("         END TOTAL_A_POINT    " ).append("\n"); 
		query.append("        --,TOT_INPUT_ELAPSED,TOT_RATE_ELAPSED,TOT_QA_ELAPSED" ).append("\n"); 
		query.append("        ,(BKG_GET_CONV_INTVAL_TIME_FNC(TOT_INPUT_ELAPSED,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(TOT_INPUT_ELAPSED,'SS') TOT_INPUT_ELAPSED" ).append("\n"); 
		query.append("        ,(BKG_GET_CONV_INTVAL_TIME_FNC(TOT_RATE_ELAPSED,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(TOT_RATE_ELAPSED,'SS') TOT_RATE_ELAPSED" ).append("\n"); 
		query.append("        ,(BKG_GET_CONV_INTVAL_TIME_FNC(TOT_QA_ELAPSED,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(TOT_QA_ELAPSED,'SS') TOT_QA_ELAPSED" ).append("\n"); 
		query.append("        ,BKG_GET_CONV_INTVAL_TIME_FNC(TOT_INPUT_ELAPSED,'DD') TOT_TIME_DD" ).append("\n"); 
		query.append("        ,BKG_GET_CONV_INTVAL_TIME_FNC(TOT_INPUT_ELAPSED,'HH') TOT_TIME_HH" ).append("\n"); 
		query.append("        ,BKG_GET_CONV_INTVAL_TIME_FNC(TOT_INPUT_ELAPSED,'MM') TOT_TIME_MM" ).append("\n"); 
		query.append("        ,BKG_GET_CONV_INTVAL_TIME_FNC(TOT_INPUT_ELAPSED,'SS') TOT_TIME_SS --★" ).append("\n"); 
		query.append("        --,trunc(TOT_INPUT_ELAPSED/BKG_CNT_SR,2) as AVG_TIME_IN" ).append("\n"); 
		query.append("        --,trunc(TOT_RATE_ELAPSED/BKG_CNT_SR,2) as AVG_TIME_RA" ).append("\n"); 
		query.append("        --,trunc(TOT_QA_ELAPSED/BKG_CNT_SR,2) as AVG_TIME_QA" ).append("\n"); 
		query.append("        ,(BKG_GET_CONV_INTVAL_TIME_FNC(TOT_INPUT_ELAPSED/TOT_HIS_CNT,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(TOT_INPUT_ELAPSED/TOT_HIS_CNT,'SS') AVG_TIME_IN --★" ).append("\n"); 
		query.append("        ,(BKG_GET_CONV_INTVAL_TIME_FNC(TOT_RATE_ELAPSED/TOT_HIS_CNT,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(TOT_RATE_ELAPSED/TOT_HIS_CNT,'SS') AVG_TIME_ra --★" ).append("\n"); 
		query.append("        ,(BKG_GET_CONV_INTVAL_TIME_FNC(TOT_QA_ELAPSED/TOT_HIS_CNT,'')*60)+BKG_GET_CONV_INTVAL_TIME_FNC(TOT_QA_ELAPSED/TOT_HIS_CNT,'SS') AVG_TIME_qa --★" ).append("\n"); 
		query.append("        ,BKG_GET_CONV_INTVAL_TIME_FNC(TOT_INPUT_ELAPSED/TOT_HIS_CNT,'DD') AVG_TIME_DD" ).append("\n"); 
		query.append("        ,BKG_GET_CONV_INTVAL_TIME_FNC(TOT_INPUT_ELAPSED/TOT_HIS_CNT,'HH') AVG_TIME_HH" ).append("\n"); 
		query.append("        ,BKG_GET_CONV_INTVAL_TIME_FNC(TOT_INPUT_ELAPSED/TOT_HIS_CNT,'MM') AVG_TIME_MM" ).append("\n"); 
		query.append("        ,BKG_GET_CONV_INTVAL_TIME_FNC(TOT_INPUT_ELAPSED/TOT_HIS_CNT,'SS') AVG_TIME_SS --★" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            ROW_NUMBER() OVER (PARTITION BY REGION, SR_STS_CD ORDER BY REGION, SR_STS_CD) R_S_ROW" ).append("\n"); 
		query.append("            ,COUNT(DISTINCT ATND_USR_ID) OVER (PARTITION BY REGION, SR_STS_CD) TOT_STAFF" ).append("\n"); 
		query.append("            ,COUNT(DISTINCT ATND_USR_ID) OVER (PARTITION BY TOT_G) sum_STAFF--★ TOT_G" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ,SUM(HIS_CNT_BKG_GROUP) OVER (PARTITION BY REGION, SR_STS_CD) TOT_HIS_CNT" ).append("\n"); 
		query.append("            ,SUM(HIS_CNT_BKG_GROUP) OVER (PARTITION BY TOT_G) sum_HIS_CNT" ).append("\n"); 
		query.append("            ,SUM(SI_CNT_BKG_GROUP) OVER (PARTITION BY REGION, SR_STS_CD) TOT_SI_CNT" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            ,BKG_CNT_REASON_SR TOT_BKG_CNT" ).append("\n"); 
		query.append("            ,SUM(HBL_CNT) OVER (PARTITION BY REGION, SR_STS_CD) TOT_HBL_CNT" ).append("\n"); 
		query.append("            ,SUM(ORI_EDI_BKG) OVER (PARTITION BY REGION, SR_STS_CD) TOT_ORI_EDI_CNT" ).append("\n"); 
		query.append("            ,SUM(ORI_FAX_BKG) OVER (PARTITION BY REGION, SR_STS_CD) TOT_ORI_FAX_CNT" ).append("\n"); 
		query.append("            ,SUM(ORI_MAIL_BKG) OVER (PARTITION BY REGION, SR_STS_CD) TOT_ORI_MAIL_CNT" ).append("\n"); 
		query.append("            ,SUM(ORI_SEN_BKG) OVER (PARTITION BY REGION, SR_STS_CD) TOT_ORI_SEN_cnt" ).append("\n"); 
		query.append("            ---- 1 COL" ).append("\n"); 
		query.append("            ,SUM(AMD_CNT_ID) OVER (PARTITION BY REGION, SR_STS_CD) TOT_AMD_ID_CNT" ).append("\n"); 
		query.append("            ,SUM(AMD_CNT_AD) OVER (PARTITION BY REGION, SR_STS_CD) TOT_AMD_AD_CNT" ).append("\n"); 
		query.append("            ,SUM(AMD_CNT_RD) OVER (PARTITION BY REGION, SR_STS_CD) TOT_AMD_RD_CNT" ).append("\n"); 
		query.append("            ---- 1 COL" ).append("\n"); 
		query.append("            ,SUM(HBL_IN_CNT_ID) OVER (PARTITION BY REGION, SR_STS_CD) TOT_HBL_IN_ID_CNT" ).append("\n"); 
		query.append("            ,SUM(HBL_IN_CNT_AD) OVER (PARTITION BY REGION, SR_STS_CD) TOT_HBL_IN_AD_CNT" ).append("\n"); 
		query.append("            ,SUM(HBL_IN_CNT_RD) OVER (PARTITION BY REGION, SR_STS_CD) TOT_HBL_IN_RD_CNT" ).append("\n"); 
		query.append("            ---- 1 COL" ).append("\n"); 
		query.append("            ,SUM(AES_CNT_ID) OVER (PARTITION BY REGION, SR_STS_CD) TOT_AES_ID_CNT" ).append("\n"); 
		query.append("            ,SUM(AES_CNT_AD) OVER (PARTITION BY REGION, SR_STS_CD) TOT_AES_AD_CNT" ).append("\n"); 
		query.append("            ,SUM(AES_CNT_RD) OVER (PARTITION BY REGION, SR_STS_CD) TOT_AES_RD_CNT" ).append("\n"); 
		query.append("            ---- 1 COL" ).append("\n"); 
		query.append("            ,SUM(BL_CFM_CNT_ID) OVER (PARTITION BY REGION, SR_STS_CD) TOT_BL_CFM_CNT_ID_CNT" ).append("\n"); 
		query.append("            ,SUM(BL_CFM_CNT_AD) OVER (PARTITION BY REGION, SR_STS_CD) TOT_BL_CFM_CNT_AD_CNT" ).append("\n"); 
		query.append("            ,SUM(BL_CFM_CNT_RD) OVER (PARTITION BY REGION, SR_STS_CD) TOT_BL_CFM_CNT_RD_CNT" ).append("\n"); 
		query.append("            ,SUM(ADDI_CNT_ID) OVER (PARTITION BY REGION, SR_STS_CD) TOT_ADDI_CNT_ID_CNT" ).append("\n"); 
		query.append("            ,SUM(ADDI_CNT_RD) OVER (PARTITION BY REGION, SR_STS_CD) TOT_ADDI_CNT_RD_CNT" ).append("\n"); 
		query.append("            ,SUM(ADDI_CNT_AD) OVER (PARTITION BY REGION, SR_STS_CD) TOT_ADDI_CNT_AD_CNT" ).append("\n"); 
		query.append("            ---- 1 COL" ).append("\n"); 
		query.append("            ,SUM(i_BAS_PNT) OVER(PARTITION BY REGION, SR_STS_CD) TOT_I_BAS_PNT --BKG,SR별 , ID에만" ).append("\n"); 
		query.append("            ,SUM(HBL_PNT) OVER(PARTITION BY REGION, SR_STS_CD) TOT_HBL_PNT --BKG,SR별 , ID에만" ).append("\n"); 
		query.append("            ,SUM(CM_PNT) OVER(PARTITION BY REGION, SR_STS_CD) TOT_CM_PNT --BKG,SR별, ID에만" ).append("\n"); 
		query.append("            ,SUM(CN_PNT) OVER(PARTITION BY REGION, SR_STS_CD) TOT_CN_PNT --BKG,SR별, ID에만" ).append("\n"); 
		query.append("            ,SUM(RFA_PNT) OVER(PARTITION BY REGION, SR_STS_CD) TOT_RFA_PNT --BKG,SR별, RD에만" ).append("\n"); 
		query.append("            ,SUM(TAA_PNT) OVER(PARTITION BY REGION, SR_STS_CD) TOT_TAA_PNT --BKG,SR별, RD에만" ).append("\n"); 
		query.append("            ,SUM(SC_PNT) OVER(PARTITION BY REGION, SR_STS_CD) TOT_SC_PNT --BKG,SR별, RD에만" ).append("\n"); 
		query.append("            ,SUM(SELF_PNT) OVER(PARTITION BY REGION, SR_STS_CD) TOT_SELF_PNT --BKG,SR별, RD에만" ).append("\n"); 
		query.append("            ,SUM(PRE_PNT) OVER(PARTITION BY REGION, SR_STS_CD) TOT_PRE_PNT --BKG,SR별, RD에만" ).append("\n"); 
		query.append("            -- TIME" ).append("\n"); 
		query.append("            ,SUM(INPUT_ELAPSED_DUP) OVER (PARTITION BY REGION, SR_STS_CD) TOT_INPUT_ELAPSED --" ).append("\n"); 
		query.append("            ,SUM(RATE_ELAPSED_DUP) OVER (PARTITION BY REGION, SR_STS_CD) TOT_RATE_ELAPSED --" ).append("\n"); 
		query.append("            ,SUM(QA_ELAPSED_DUP) OVER (PARTITION BY REGION, SR_STS_CD) TOT_QA_ELAPSED --" ).append("\n"); 
		query.append("			,SUM(QA_ELAPSED_DUP) OVER (PARTITION BY TOT_G) TOT_ELAPSED --" ).append("\n"); 
		query.append("            ,C.*" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                '1' TOT_G" ).append("\n"); 
		query.append("                ,COUNT(DISTINCT B.BKG_NO) OVER(PARTITION BY   B.REGION, B.SR_STS_CD) BKG_CNT_REASON_SR" ).append("\n"); 
		query.append("                ,row_number() over(partition by b.region, b.sr_sts_cd order by b.region, b.sr_sts_cd) rn_reasion_sr_sts_cd" ).append("\n"); 
		query.append("                ,DECODE(SR_BKG_NM,1, STAFF_CNT, 0) AS STAFF_CNT_BKG_GROUP --★" ).append("\n"); 
		query.append("                ,DECODE(HIS_DUP_NM,1, 1, 0) AS his_CNT_BKG_GROUP --★" ).append("\n"); 
		query.append("                ,DECODE(SR_BKG_NM,1, SI_CNT, 0) AS SI_CNT_BKG_GROUP --★" ).append("\n"); 
		query.append("                ,CASE WHEN SR_BKG_NM =1 --SR_STS_CD,BKG 별 1번만 적용 로직" ).append("\n"); 
		query.append("                       THEN ( SELECT NVL(MAX(HBL_SEQ),'0') FROM BKG_HBL WHERE BKG_NO = B.BKG_NO) " ).append("\n"); 
		query.append("                       ELSE 0" ).append("\n"); 
		query.append("                 END HBL_CNT --H/BL                 " ).append("\n"); 
		query.append("                ,DECODE(B.SR_KND_CD,'E',( DECODE(SR_AMD_TP_CD,'O', DECODE(HIS_DUP_NM,1, 1,0),0 )),0) ORI_EDI_BKG --★" ).append("\n"); 
		query.append("                ,DECODE(B.SR_KND_CD,'F',( DECODE(SR_AMD_TP_CD,'O', DECODE(HIS_DUP_NM,1, 1,0),0 )),0) ORI_FAX_BKG --★             " ).append("\n"); 
		query.append("                ,DECODE(B.SR_KND_CD,'M',( DECODE(SR_AMD_TP_CD,'O', DECODE(HIS_DUP_NM,1, 1,0),0 )),0) ORI_MAIL_BKG --★" ).append("\n"); 
		query.append("                ,DECODE(B.SR_KND_CD,'S',( DECODE(SR_AMD_TP_CD,'O', DECODE(HIS_DUP_NM,1, 1,0),0 )),0) ORI_SEN_BKG --★" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                ,CASE WHEN HIS_DUP_NM = 1 AND SR_STS_CD ='ID' AND SR_AMD_TP_CD ='A' THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END AMD_CNT_ID --★                              " ).append("\n"); 
		query.append("                ,CASE WHEN HIS_DUP_NM = 1 AND SR_STS_CD ='AD' AND SR_AMD_TP_CD ='A' THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END AMD_CNT_AD                  " ).append("\n"); 
		query.append("                ,CASE WHEN HIS_DUP_NM = 1 AND SR_STS_CD ='RD'  AND SR_AMD_TP_CD ='A' THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END AMD_CNT_RD   " ).append("\n"); 
		query.append("                ,CASE WHEN HIS_DUP_NM = 1 AND SR_STS_CD ='ID'  AND SR_AMD_TP_CD ='H' THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END HBL_IN_CNT_ID  --★                     " ).append("\n"); 
		query.append("                ,CASE WHEN HIS_DUP_NM = 1 AND SR_STS_CD ='AD'  AND SR_AMD_TP_CD ='H' THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END HBL_IN_CNT_AD  --★   " ).append("\n"); 
		query.append("                ,CASE WHEN HIS_DUP_NM = 1 AND SR_STS_CD ='RD'  AND SR_AMD_TP_CD ='H' THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END HBL_IN_CNT_RD  --★                                             " ).append("\n"); 
		query.append("                ,CASE WHEN HIS_DUP_NM = 1 AND SR_STS_CD ='ID'  AND SR_AMD_TP_CD IN ('E','C','I') THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END AES_CNT_ID  --★    " ).append("\n"); 
		query.append("                ,CASE WHEN HIS_DUP_NM = 1 AND SR_STS_CD ='AD'  AND SR_AMD_TP_CD IN ('E','C','I') THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END AES_CNT_AD  --★     " ).append("\n"); 
		query.append("                ,CASE WHEN HIS_DUP_NM = 1 AND SR_STS_CD ='RD'  AND SR_AMD_TP_CD IN ('E','C','I') THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END AES_CNT_RD  --★ " ).append("\n"); 
		query.append("                ,CASE WHEN HIS_DUP_NM = 1 AND SR_STS_CD ='ID'  AND SR_AMD_TP_CD ='B' THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END BL_CFM_CNT_ID  --★                                        " ).append("\n"); 
		query.append("                ,CASE WHEN HIS_DUP_NM = 1 AND SR_STS_CD ='AD'  AND SR_AMD_TP_CD ='B' THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END BL_CFM_CNT_AD  --★  " ).append("\n"); 
		query.append("                ,CASE WHEN HIS_DUP_NM = 1 AND SR_STS_CD ='RD'  AND SR_AMD_TP_CD ='B' THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END BL_CFM_CNT_RD  --★     " ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                ,CASE WHEN HIS_DUP_NM = 1 AND SR_STS_CD ='ID'  AND SR_AMD_TP_CD NOT IN ('O','A','H','E','C','I','B') THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END ADDI_CNT_ID  --★    " ).append("\n"); 
		query.append("                ,CASE WHEN HIS_DUP_NM = 1 AND SR_STS_CD ='RD'  AND SR_AMD_TP_CD NOT IN ('O','A','H','E','C','I','B') THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END ADDI_CNT_RD  --★        " ).append("\n"); 
		query.append("                ,CASE WHEN HIS_DUP_NM = 1 AND SR_STS_CD ='AD'  AND SR_AMD_TP_CD NOT IN ('O','A','H','E','C','I','B') THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END ADDI_CNT_AD  --★                                                                " ).append("\n"); 
		query.append("                -- HIS_DUP_NM 별 inputer점수 (history 별 점수)" ).append("\n"); 
		query.append("                ,case when HIS_DUP_NM = 1  and SR_STS_CD='ID' " ).append("\n"); 
		query.append("                      then " ).append("\n"); 
		query.append("                         NVL((SELECT  to_number(ATTR_CTNT5)" ).append("\n"); 
		query.append("                             FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                            WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                              and 'I' = SUBSTR(SR_STS_CD,0,1) --id,Rd" ).append("\n"); 
		query.append("                              AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1)" ).append("\n"); 
		query.append("                              AND ATTR_CTNT2 = b.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                              and b.SR_AMD_TP_CD in ('O','A','B','T','E','C','I')" ).append("\n"); 
		query.append("                              AND ATTR_CTNT3 = b.SR_AMD_TP_CD -- L All,O Original,A Amend,B BL Confim,T Addition,E AES,C CAED,I IE" ).append("\n"); 
		query.append("                            ),0) " ).append("\n"); 
		query.append("                       else 0" ).append("\n"); 
		query.append("                  end i_BAS_PNT --IFA   " ).append("\n"); 
		query.append("                 ,CASE  WHEN SR_BKG_NM =1 --BKG 별 1번만 적용 로직" ).append("\n"); 
		query.append("                         and SR_STS_CD ='ID' " ).append("\n"); 
		query.append("                         AND (SELECT NVL(MAX(HBL_SEQ),'0') FROM BKG_HBL WHERE BKG_NO = B.BKG_NO ) >= NVL((" ).append("\n"); 
		query.append("                                            SELECT ATTR_CTNT4 FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                                            WHERE HRD_CDG_ID ='DPCS_RPT_WGT'" ).append("\n"); 
		query.append("                                            AND ATTR_CTNT1 = 'I' --SUBSTR(CC.SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                            AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                            AND ATTR_CTNT3 = 'H'" ).append("\n"); 
		query.append("                                            ), '999') " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                        THEN  " ).append("\n"); 
		query.append("                            (SELECT  TO_NUMBER(ATTR_CTNT5 )" ).append("\n"); 
		query.append("                                FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                               WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                                 AND ATTR_CTNT1 = 'I' --SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                 AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                 AND ATTR_CTNT3 = 'H' --" ).append("\n"); 
		query.append("                             ) * ((SELECT NVL(MAX(HBL_SEQ),'0') FROM BKG_HBL WHERE BKG_NO = B.BKG_NO ) - " ).append("\n"); 
		query.append("                                           (" ).append("\n"); 
		query.append("                                                SELECT ATTR_CTNT4 FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                                                WHERE HRD_CDG_ID ='DPCS_RPT_WGT'" ).append("\n"); 
		query.append("                                                AND ATTR_CTNT1 = 'I' --SUBSTR(CC.SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                                AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                                AND ATTR_CTNT3 = 'H'" ).append("\n"); 
		query.append("                                            )+1" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                   END AS HBL_PNT" ).append("\n"); 
		query.append("                 ,CASE WHEN SR_BKG_NM=1 --BKG 별 1번만 적용 로직" ).append("\n"); 
		query.append("                        and SR_STS_CD ='ID' " ).append("\n"); 
		query.append("                        AND (SELECT COUNT(1) FROM BKG_CNTR_MF_DESC WHERE BKG_NO = B.BKG_NO) >=  NVL((" ).append("\n"); 
		query.append("                                                                        SELECT ATTR_CTNT4 FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                                                                        WHERE HRD_CDG_ID ='DPCS_RPT_WGT'" ).append("\n"); 
		query.append("                                                                        AND ATTR_CTNT1 = 'I' --SUBSTR(CC.SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                                                        AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                                                        AND ATTR_CTNT3 = 'M'" ).append("\n"); 
		query.append("                                                                        ), '999') " ).append("\n"); 
		query.append("                        THEN   " ).append("\n"); 
		query.append("                            NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                                FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                               WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                                 AND ATTR_CTNT1 = 'I' --SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                 AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                 AND ATTR_CTNT3 = 'M' --" ).append("\n"); 
		query.append("                             ),0) * ( (SELECT COUNT(1) FROM BKG_CNTR_MF_DESC WHERE BKG_NO = B.BKG_NO) - " ).append("\n"); 
		query.append("                                      (" ).append("\n"); 
		query.append("                                        SELECT ATTR_CTNT4 FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                                        WHERE HRD_CDG_ID ='DPCS_RPT_WGT'" ).append("\n"); 
		query.append("                                        AND ATTR_CTNT1 = 'I' --SUBSTR(CC.SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                        AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                        AND ATTR_CTNT3 = 'M'" ).append("\n"); 
		query.append("                                      ) +1" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                   END AS CM_PNT   " ).append("\n"); 
		query.append("                 ,CASE  WHEN SR_BKG_NM =1 --BKG 별 1번만 적용 로직" ).append("\n"); 
		query.append("                        and SR_STS_CD ='ID' " ).append("\n"); 
		query.append("                        AND (SELECT  COUNT(1) FROM BKG_CONTAINER WHERE BKG_NO = B.BKG_NO) >=  NVL((" ).append("\n"); 
		query.append("                                                                        SELECT ATTR_CTNT4 FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                                                                        WHERE HRD_CDG_ID ='DPCS_RPT_WGT'" ).append("\n"); 
		query.append("                                                                        AND ATTR_CTNT1 = 'I' --SUBSTR(CC.SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                                                        AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                                                        AND ATTR_CTNT3 = 'N'" ).append("\n"); 
		query.append("                                                                        ), '999') " ).append("\n"); 
		query.append("                        THEN   " ).append("\n"); 
		query.append("                            NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                                FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                               WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                                 AND ATTR_CTNT1 = 'I' --SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                 AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                 AND ATTR_CTNT3 = 'N' --" ).append("\n"); 
		query.append("                             ),0) * ( (SELECT  COUNT(1) FROM BKG_CONTAINER WHERE BKG_NO = B.BKG_NO) - " ).append("\n"); 
		query.append("                                      (" ).append("\n"); 
		query.append("                                        SELECT ATTR_CTNT4 FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                                        WHERE HRD_CDG_ID ='DPCS_RPT_WGT'" ).append("\n"); 
		query.append("                                        AND ATTR_CTNT1 = 'I' --SUBSTR(CC.SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                        AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                        AND ATTR_CTNT3 = 'N'" ).append("\n"); 
		query.append("                                       ) +1" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                   END AS CN_PNT " ).append("\n"); 
		query.append("                 --RATER 의  S,X,R,D,P에대한 추가 점수" ).append("\n"); 
		query.append("                 ,CASE WHEN  SR_BKG_NM =1 --BKG 별 1번만 적용 로직" ).append("\n"); 
		query.append("                        AND 'RFA' = RATE_TYPE" ).append("\n"); 
		query.append("                        AND 'RD' = SR_STS_CD" ).append("\n"); 
		query.append("                       THEN  --ORIGINAL 조건 추가  " ).append("\n"); 
		query.append("                            NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                                FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                               WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                                 AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) --RD,AD,ID" ).append("\n"); 
		query.append("                                 AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                 AND ATTR_CTNT3 = 'F' --RFA" ).append("\n"); 
		query.append("                             ),0)" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                   END AS RFA_PNT      " ).append("\n"); 
		query.append("                 ,CASE WHEN SR_BKG_NM =1 --BKG 별 1번만 적용 로직 " ).append("\n"); 
		query.append("                        AND 'TAA' = RATE_TYPE" ).append("\n"); 
		query.append("                        AND 'RD' = SR_STS_CD" ).append("\n"); 
		query.append("                        THEN  --ORIGINAL 조건 추가  " ).append("\n"); 
		query.append("                            NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                                FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                               WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                                 AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                 AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                 AND ATTR_CTNT3 = 'X' --" ).append("\n"); 
		query.append("                             ),0)" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                   END AS TAA_PNT       " ).append("\n"); 
		query.append("                 ,CASE WHEN RN_BKG =1 --BKG 별 1번만 적용 로직" ).append("\n"); 
		query.append("                        AND 'S/C' =RATE_TYPE" ).append("\n"); 
		query.append("                        AND 'RD' = SR_STS_CD" ).append("\n"); 
		query.append("                        THEN  --ORIGINAL 조건 추가  " ).append("\n"); 
		query.append("                            NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                                FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                               WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                                 AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                 AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                 AND ATTR_CTNT3 = 'S' --" ).append("\n"); 
		query.append("                             ),0)" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                   END AS SC_PNT                  " ).append("\n"); 
		query.append("                 ,CASE WHEN SR_BKG_NM =1 --BKG 별 1번만 적용 로직" ).append("\n"); 
		query.append("                        AND 'RD' = SR_STS_CD" ).append("\n"); 
		query.append("                        AND (SELECT  AUD_STS_CD  FROM BKG_RATE WHERE BKG_NO = B.BKG_NO) = 'Y'" ).append("\n"); 
		query.append("                        THEN  --ORIGINAL 조건 추가  " ).append("\n"); 
		query.append("                            NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                                FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                               WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                                 AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                 AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                 AND ATTR_CTNT3 = 'D' --" ).append("\n"); 
		query.append("                             ),0)" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                   END AS SELF_PNT   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 ,CASE when SR_BKG_NM =1 --BKG 별 1번만 적용 로직" ).append("\n"); 
		query.append("                        AND (SELECT COUNT(1) FROM BKG_CHG_RT WHERE BKG_NO = B.BKG_NO) > 0 " ).append("\n"); 
		query.append("                        AND 'RD' = SR_STS_CD" ).append("\n"); 
		query.append("                       THEN  " ).append("\n"); 
		query.append("                            NVL((SELECT  TO_NUMBER(ATTR_CTNT5) " ).append("\n"); 
		query.append("                                FROM  BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("                               WHERE HRD_CDG_ID ='DPCS_RPT_WGT' " ).append("\n"); 
		query.append("                                 AND ATTR_CTNT1 = SUBSTR(SR_STS_CD,0,1) " ).append("\n"); 
		query.append("                                 AND ATTR_CTNT2 = B.SR_KND_CD -- M,E,F" ).append("\n"); 
		query.append("                                 AND ATTR_CTNT3 = 'P' --" ).append("\n"); 
		query.append("                             ),0)" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                   END AS PRE_PNT  " ).append("\n"); 
		query.append("                 ,CASE WHEN SR_BKG_NM =1 AND 'ID' = SR_STS_CD--BKG 별 1번만 적용 로직" ).append("\n"); 
		query.append("                       THEN (SELECT COUNT(*) FROM BKG_CNTR_MF_DESC WHERE BKG_NO = B.BKG_NO)" ).append("\n"); 
		query.append("                       ELSE 0" ).append("\n"); 
		query.append("                  END CM_CNT" ).append("\n"); 
		query.append("                 ,CASE WHEN SR_BKG_NM =1 AND 'ID' = SR_STS_CD--BKG 별 1번만 적용 로직" ).append("\n"); 
		query.append("                       THEN (SELECT  COUNT(1) FROM BKG_CONTAINER WHERE BKG_NO = B.BKG_NO)" ).append("\n"); 
		query.append("                       ELSE 0" ).append("\n"); 
		query.append("                  END CN_CNT" ).append("\n"); 
		query.append("                 ,DECODE(HIS_DUP_NM ,1 , SR_PROC_HRS , 0)   INPUT_ELAPSED_DUP        " ).append("\n"); 
		query.append("                 ,DECODE(HIS_DUP_NM ,1 , SR_PROC_HRS , 0)   RATE_ELAPSED_DUP" ).append("\n"); 
		query.append("                 ,DECODE(HIS_DUP_NM ,1 , SR_PROC_HRS , 0)   QA_ELAPSED_DUP" ).append("\n"); 
		query.append("                 ,BKG_COM_INTG_CD_NM_FNC('CD02405',REGION) AS REGION_D" ).append("\n"); 
		query.append("                 ,B.* " ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT /*+  INDEX(H XAK2BKG_SR_HIS)  */" ).append("\n"); 
		query.append("                BKG_JOIN_FNC(CURSOR(SELECT DISTINCT RGN_OFC_CD FROM BKG_EML_ACCT_STUP S WHERE S.BKG_OFC_CD = B.BKG_OFC_CD ),'')AS  REGION" ).append("\n"); 
		query.append("                ,H.SR_STS_CD,H.SR_HIS_SEQ" ).append("\n"); 
		query.append("                ,ROW_NUMBER() OVER (PARTITION BY A.SR_KND_CD,SR_STS_CD, A.SR_NO, A.BKG_NO,SR_HIS_SEQ  ORDER BY SR_AMD_SEQ,SR_HIS_SEQ ) HIS_DUP_NM" ).append("\n"); 
		query.append("                ,ROW_NUMBER() OVER (PARTITION BY A.BKG_NO,SR_STS_CD  ORDER BY SR_AMD_SEQ,SR_HIS_SEQ ) SR_BKG_NM" ).append("\n"); 
		query.append("                ,COUNT(DISTINCT A.BKG_NO||A.SR_NO) OVER (PARTITION BY A.BKG_NO ,SR_STS_CD) SI_CNT --해당 BKG에 SR_STS_CD의 RQST갯수-> S/I #" ).append("\n"); 
		query.append("                ,ROW_NUMBER() OVER(PARTITION BY A.BKG_NO ORDER BY A.BKG_NO) RN_BKG" ).append("\n"); 
		query.append("                ,COUNT(DISTINCT H.ATND_USR_ID) OVER (PARTITION BY A.BKG_NO,SR_STS_CD   ) STAFF_CNT --@@@" ).append("\n"); 
		query.append("                ,COUNT(DISTINCT A.BKG_NO ) OVER (PARTITION BY SR_STS_CD) BKG_CNT_SR" ).append("\n"); 
		query.append("                ,DECODE(DECODE(SUBSTR(RFA_NO,0,3),'DUM',NULL,RFA_NO),NULL,DECODE(SC_NO,NULL,DECODE(TAA_NO,NULL,NULL,'TAA'),'S/C'),'RFA') RATE_TYPE " ).append("\n"); 
		query.append("                --,A.RQST_RN" ).append("\n"); 
		query.append("                ,BKG_COM_INTG_CD_NM_FNC('CD01581',A.SR_KND_CD) AS SRC" ).append("\n"); 
		query.append("                ,A.SR_KND_CD,A.SR_NO,A.BKG_NO,DECODE(A.SR_AMD_TP_CD,'N','O', A.SR_AMD_TP_CD) AS SR_AMD_TP_CD,A.SR_AMD_SEQ,A.SR_URG_CD" ).append("\n"); 
		query.append("                ,A.SR_AMD_KND_CD,A.RCV_OFC_CD,A.DPCS_OFC_CD,A.SR_CRNT_STS_CD,A.SR_CRNT_INFO_CD,A.BL_DOC_INP_FLG" ).append("\n"); 
		query.append("                ,A.BL_RT_FLG,A.BL_AUD_FLG,A.SR_WRK_STS_CD,A.BL_DRFT_FAX_OUT_FLG " ).append("\n"); 
		query.append("                ,H.ST_DT, H.ST_GDT " ).append("\n"); 
		query.append("                ,H.ATND_USR_ID ,RFA_NO,B.TAA_NO,B.SC_NO, H.SR_PROC_HRS,G.DPCS_WRK_GRP_CD" ).append("\n"); 
		query.append("                ,BKG_COM_INTG_CD_NM_FNC('CD02100',G.DPCS_WRK_GRP_CD) AS USER_GROUP" ).append("\n"); 
		query.append("                ,NVL(BKG_COM_INTG_CD_NM_FNC('CD01577',A.SR_AMD_TP_CD),'ORIGINAL') AS SI_KIND --ORIGINAL:N(OLD),O(현재)" ).append("\n"); 
		query.append("                ,a.CRE_DT" ).append("\n"); 
		query.append("                FROM " ).append("\n"); 
		query.append("                 BKG_SR_CRNT_RQST A " ).append("\n"); 
		query.append("                ,BKG_SR_HIS H" ).append("\n"); 
		query.append("                ,BKG_DPCS_USR_GRP G" ).append("\n"); 
		query.append("                ,BKG_BOOKING B" ).append("\n"); 
		query.append("                ,BKG_RATE BR" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("                  AND A.SR_KND_CD =  H.SR_KND_CD --FAX,EMAIL,EDI" ).append("\n"); 
		query.append("                  AND A.SR_NO =  H.SR_NO" ).append("\n"); 
		query.append("                  AND A.BKG_NO =  H.BKG_NO" ).append("\n"); 
		query.append("                  AND A.BKG_NO= B.BKG_NO" ).append("\n"); 
		query.append("                  AND A.BKG_NO= BR.BKG_NO" ).append("\n"); 
		query.append("                  AND H.ATND_USR_ID  = G.USR_ID(+)" ).append("\n"); 
		query.append("                  AND A.DPCS_OFC_CD = NVL(@[dpcs_ofc_cd], A.DPCS_OFC_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("                  AND B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD LIKE RTRIM(@[vvd_cd])|| '%'		" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                  AND H.ATND_USR_ID  = G.USR_ID(+)" ).append("\n"); 
		query.append("                  AND H.ATND_USR_ID = NVL(@[atnd_usr_id],H.ATND_USR_ID )" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                  #if (${pfm_by_queue_cd} == 'A' || ${pfm_by_queue_cd} == '') " ).append("\n"); 
		query.append("                  AND H.SR_STS_CD IN ('ID','RD','AD')  " ).append("\n"); 
		query.append("                  #elseif (${pfm_by_queue_cd} != '') " ).append("\n"); 
		query.append("                  AND H.SR_STS_CD = @[pfm_by_queue_cd]" ).append("\n"); 
		query.append("                  #end" ).append("\n"); 
		query.append("                  AND H.ST_DT  >= TO_DATE(@[from_dt]||@[from_mt], 'YYYY-MM-DDHH24:MI')" ).append("\n"); 
		query.append("                  AND H.ST_DT  <= TO_DATE(@[to_dt]||@[to_mt], 'YYYY-MM-DDHH24:MI')+0.00068" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  AND EXISTS (SELECT 'Y' --DISTINCT RGN_OFC_CD " ).append("\n"); 
		query.append("                                FROM BKG_EML_ACCT_STUP S WHERE S.BKG_OFC_CD = B.BKG_OFC_CD AND S.RGN_OFC_CD = NVL(DECODE(@[region],'A','',@[region]),S.RGN_OFC_CD) AND ROWNUM = 1" ).append("\n"); 
		query.append("                             )  " ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("            ) B-- WHERE REGION ='J' AND SR_STS_CD='ID'" ).append("\n"); 
		query.append("        )C" ).append("\n"); 
		query.append("    ) D" ).append("\n"); 
		query.append(")E  " ).append("\n"); 
		query.append("WHERE R_S_ROW =1 " ).append("\n"); 
		query.append("AND REGION IS NOT NULL" ).append("\n"); 
		query.append("AND REGION <> 'A'" ).append("\n"); 
		query.append("ORDER BY REGION, DECODE(SR_STS_CD,'ID',1,'RD',2,'AD',3)" ).append("\n"); 

	}
}