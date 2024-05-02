/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PickUpNoticeDBDAOsearchPkupNtcSendListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOsearchPkupNtcSendListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PickUp Notice를 발송(Success)한 대상및 미 발송(Fail or 누락)된 대상정보들을 조회 한다.
	  * </pre>
	  */
	public PickUpNoticeDBDAOsearchPkupNtcSendListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dt_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dt_mvmt_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tm_mvmt_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tm_mvmt_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dt_mvmt_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dt_s",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOsearchPkupNtcSendListRSQL").append("\n"); 
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
		query.append("-- PkupNtcSendListVO 생성" ).append("\n"); 
		query.append("SELECT PKUP_NTC.BKG_NO," ).append("\n"); 
		query.append("       PKUP_NTC.NTC_SEQ," ).append("\n"); 
		query.append("       DECODE(PKUP_NTC.PKUP_NTC_SND_STS_CD,'X','V','') AS PKUP_NTC_SND_STS_CD," ).append("\n"); 
		query.append("       '' MNL_FLG," ).append("\n"); 
		query.append("       PKUP_NTC.MNL_FLG AS MNL_FLG_SHOW," ).append("\n"); 
		query.append("       DECODE(PKUP_NTC.PKUP_NTC_TP_CD,'WO','MA',PKUP_NTC.PKUP_NTC_TP_CD) AS PKUP_NTC_TP_CD," ).append("\n"); 
		query.append("       PKUP_NTC.PKUP_NTC_FOM_CD," ).append("\n"); 
		query.append("       'EV1' AS PKUP_NTC_FOM_CD_SHOW," ).append("\n"); 
		query.append("       BKG.BL_NO," ).append("\n"); 
		query.append("       PKUP_NTC.CNTR_NO," ).append("\n"); 
		query.append("       CASE WHEN RAIL.TRSP_SO_OFC_CTY_CD IS NULL THEN CNTR.CNTR_WGT * DECODE(CNTR.WGT_UT_CD,'KGS',(1/0.453),1)" ).append("\n"); 
		query.append("            ELSE RAIL.CNTR_WGT * DECODE(RAIL.WGT_MEAS_UT_CD, 'KGS', (1/0.453), 1) END AS CNTR_WGT," ).append("\n"); 
		query.append("       DECODE(SIGN(CASE WHEN RAIL.TRSP_SO_OFC_CTY_CD IS NULL THEN CNTR.CNTR_WGT * DECODE(CNTR.WGT_UT_CD,'KGS',(1/0.453),1)" ).append("\n"); 
		query.append("                        ELSE RAIL.CNTR_WGT * DECODE(RAIL.WGT_MEAS_UT_CD, 'KGS', (1/0.453), 1) END" ).append("\n"); 
		query.append("                   - 45000),1,'Y','N') AS OVER_WGT_FLG," ).append("\n"); 
		query.append("       PKUP_NTC.RAIL_LOD_DT," ).append("\n"); 
		query.append("       PKUP_NO.PKUP_AVAL_DT," ).append("\n"); 
		query.append("       PKUP_NO.LST_FREE_DT," ).append("\n"); 
		query.append("       PKUP_NO.PKUP_NO," ).append("\n"); 
		query.append("       PKUP_NO.PKUP_YD_CD," ).append("\n"); 
		query.append("       PKUP_NO.RTN_YD_CD," ).append("\n"); 
		query.append("       NVL(NVL(US_CGO.FRT_CLT_FLG,PKUP_NTC.FRT_CLT_FLG)   ,'N') AS FRT_CLT_FLG," ).append("\n"); 
		query.append("       NVL(NVL(US_CGO.OBL_RDEM_FLG,PKUP_NTC.OBL_CLT_FLG)  ,'N') AS OBL_CLT_FLG," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (CASE WHEN SUBSTR(BKG.DEL_CD,1,2) = 'CA' THEN 'Y' -- 'CA' 인 경우 C Status 를 'Y' 로 고정" ).append("\n"); 
		query.append("			 WHEN SUBSTR(BKG.POD_CD,1,2) = 'CA' THEN                  " ).append("\n"); 
		query.append("                  (SELECT SUBSTR(MAX(LPAD(CSTMS_SEQ,12,'0')||CSTMS_CLR_CD),-1)" ).append("\n"); 
		query.append("                     FROM BKG_CSTMS_ADV_CNTR_RSLT CN_RSLT" ).append("\n"); 
		query.append("                    WHERE CNT_CD  = 'US'" ).append("\n"); 
		query.append("                      AND BL_NO   = BKG.BL_NO" ).append("\n"); 
		query.append("                      AND CN_RSLT.CNTR_NO LIKE SUBSTR(PKUP_NTC.CNTR_NO,1,LENGTH(PKUP_NTC.CNTR_NO)-1)||'%')" ).append("\n"); 
		query.append("             ELSE NVL(NVL(US_CGO.CSTMS_CLR_CD,PKUP_NTC.CSTMS_CLR_FLG),'N')" ).append("\n"); 
		query.append("        END) AS CSTMS_CLR_FLG," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       US_CGO.CSTMS_DSPO_CD AS CSTMS_CLR_CD," ).append("\n"); 
		query.append("--       DECODE(US_CGO.FRT_CLT_FLG||US_CGO.OBL_RDEM_FLG||US_CGO.CSTMS_CLR_CD,'YYY','Y','N') AS FOC_FLG," ).append("\n"); 
		query.append("       NVL(DECODE(PKUP_NO.LST_FREE_DT,NULL,DECODE(PKUP_NO.PKUP_AVAL_DT,NULL,NULL,'NT'),'NF'),PKUP_NTC.EDI_322_MVMT_CD) AS EDI_322_MVMT_CD," ).append("\n"); 
		query.append("       PKUP_NO.PKUP_UPD_DT AS PKUP_NO_UPLD_DT," ).append("\n"); 
		query.append("       CASE WHEN PKUP_NO.PKUP_UPD_USR_ID = 'BAT_BKG_019' THEN 'EDI'" ).append("\n"); 
		query.append("            ELSE PKUP_NO.PKUP_UPD_USR_ID END AS        PKUP_NO_UPLD_USR_ID," ).append("\n"); 
		query.append("       CASE WHEN PKUP_NO.PKUP_UPD_USR_ID IS NULL THEN NULL" ).append("\n"); 
		query.append("            WHEN PKUP_NO.PKUP_UPD_USR_ID IN ('SYSTEM', 'BAT_BKG_019') THEN 'Auto' " ).append("\n"); 
		query.append("            ELSE 'Manual' END AS PKUP_NO_UPLD_VIA," ).append("\n"); 
		query.append("       '' AS PKUP_NO_UPLD_RAIL_CO," ).append("\n"); 
		query.append("       RAIL.POD_CD," ).append("\n"); 
		query.append("       CSTMS.CSTMS_LOC_CD AS IBD_TRSP_HUB_CD," ).append("\n"); 
		query.append("       RAIL.DEL_CD," ).append("\n"); 
		query.append("       LOC.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("       DECODE(@[usr_ofc_cd], LOC.EQ_CTRL_OFC_CD,'Y','N') AS PKUP_YD_CD_FLG," ).append("\n"); 
		query.append("       RAIL.NVOCC_FILE_NO," ).append("\n"); 
		query.append("       BKG.DE_TERM_CD," ).append("\n"); 
		query.append("       PKUP_NTC.DOR_TRKR_WO_FLG," ).append("\n"); 
		query.append("       CASE WHEN RAIL.TRSP_SO_OFC_CTY_CD IS NULL THEN 'No Rail Billing'" ).append("\n"); 
		query.append("            ELSE RAIL.POD_CD||' - <Rail> - '||SUBSTR(RAIL.TO_NOD_CD, 1, 5)||" ).append("\n"); 
		query.append("                 CASE WHEN SUBSTR(RAIL.TO_NOD_CD, 1, 5) <> RAIL.DEL_CD THEN ' - <Truck(DR)> - ' || RAIL.DEL_CD END" ).append("\n"); 
		query.append("       END AS ROUT_GID_DESC," ).append("\n"); 
		query.append("       RAIL.VSL_CD || RAIL.SKD_VOY_NO || RAIL.SKD_DIR_CD AS VVD_ID," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       CASE WHEN AUTO_SND_STOP_FLG = 'Y' AND AUTO_SND_RESM_FLG = 'N' THEN 'Stopped'" ).append("\n"); 
		query.append("            WHEN NULLIF(GRT_FAX_SND_DT,TO_DATE('0001-01-01','YYYY-MM-DD')) IS NOT NULL AND" ).append("\n"); 
		query.append("                 NULLIF(GRT_EML_SND_DT,TO_DATE('0001-01-01','YYYY-MM-DD')) IS NOT NULL THEN 'Both'" ).append("\n"); 
		query.append("            WHEN NULLIF(GRT_FAX_SND_DT,TO_DATE('0001-01-01','YYYY-MM-DD')) IS NOT NULL AND" ).append("\n"); 
		query.append("                 NULLIF(GRT_EML_SND_DT,TO_DATE('0001-01-01','YYYY-MM-DD')) IS NULL THEN 'Faxed'" ).append("\n"); 
		query.append("            WHEN NULLIF(GRT_FAX_SND_DT,TO_DATE('0001-01-01','YYYY-MM-DD')) IS NULL AND" ).append("\n"); 
		query.append("                 NULLIF(GRT_EML_SND_DT,TO_DATE('0001-01-01','YYYY-MM-DD')) IS NOT NULL THEN 'Emailed'" ).append("\n"); 
		query.append("            ELSE 'Nil'" ).append("\n"); 
		query.append("       END AS SND_STS_DESC ," ).append("\n"); 
		query.append("       NULLIF(GREATEST(GRT_FAX_SND_DT),TO_DATE('0001-01-01','YYYY-MM-DD')) AS FAX_SND_DT," ).append("\n"); 
		query.append("       NULLIF(GREATEST(GRT_EML_SND_DT),TO_DATE('0001-01-01','YYYY-MM-DD')) AS EML_SND_DT," ).append("\n"); 
		query.append("       NULLIF(GREATEST(GRT_FAX_SND_DT, GRT_EML_SND_DT),TO_DATE('0001-01-01','YYYY-MM-DD')) AS SND_DT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       CASE WHEN NULLIF(GREATEST(GRT_FAX_SND_DT, GRT_EML_SND_DT),TO_DATE('0001-01-01','YYYY-MM-DD')) IS NULL THEN 'N'" ).append("\n"); 
		query.append("            ELSE 'Y' END AS SND_YN," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       CASE NULLIF(GREATEST(GRT_FAX_SND_DT, GRT_EML_SND_DT),TO_DATE('0001-01-01','YYYY-MM-DD'))" ).append("\n"); 
		query.append("            WHEN C1_FAX_SND_DT THEN DECODE(C1_FAX_SND_USR_ID,'BAT_BKG_015','Auto',C1_FAX_SND_USR_ID)" ).append("\n"); 
		query.append("            WHEN C2_FAX_SND_DT THEN DECODE(C2_FAX_SND_USR_ID,'BAT_BKG_015','Auto',C2_FAX_SND_USR_ID)" ).append("\n"); 
		query.append("            WHEN B1_FAX_SND_DT THEN DECODE(B1_FAX_SND_USR_ID,'BAT_BKG_015','Auto',B1_FAX_SND_USR_ID)" ).append("\n"); 
		query.append("            WHEN B2_FAX_SND_DT THEN DECODE(B2_FAX_SND_USR_ID,'BAT_BKG_015','Auto',B2_FAX_SND_USR_ID)" ).append("\n"); 
		query.append("            WHEN AN_FAX_SND_DT THEN DECODE(AN_FAX_SND_USR_ID,'BAT_BKG_015','Auto',AN_FAX_SND_USR_ID)" ).append("\n"); 
		query.append("            WHEN C1_EML_SND_DT THEN DECODE(C1_EML_SND_USR_ID,'BAT_BKG_015','Auto',C1_EML_SND_USR_ID)" ).append("\n"); 
		query.append("            WHEN C2_EML_SND_DT THEN DECODE(C2_EML_SND_USR_ID,'BAT_BKG_015','Auto',C2_EML_SND_USR_ID)" ).append("\n"); 
		query.append("            WHEN B1_EML_SND_DT THEN DECODE(B1_EML_SND_USR_ID,'BAT_BKG_015','Auto',B1_EML_SND_USR_ID)" ).append("\n"); 
		query.append("            WHEN B2_EML_SND_DT THEN DECODE(B2_EML_SND_USR_ID,'BAT_BKG_015','Auto',B2_EML_SND_USR_ID)" ).append("\n"); 
		query.append("            WHEN AN_EML_SND_DT THEN DECODE(AN_EML_SND_USR_ID,'BAT_BKG_015','Auto',AN_EML_SND_USR_ID)" ).append("\n"); 
		query.append("            ELSE NULL" ).append("\n"); 
		query.append("       END AS SND_USR_ID," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       CASE WHEN C1_FAX_SND_DT IS NULL AND " ).append("\n"); 
		query.append("                 C2_FAX_SND_DT IS NULL AND " ).append("\n"); 
		query.append("                 B1_FAX_SND_DT IS NULL AND " ).append("\n"); 
		query.append("                 B2_FAX_SND_DT IS NULL AND " ).append("\n"); 
		query.append("                 AN_FAX_SND_DT IS NULL AND" ).append("\n"); 
		query.append("                 C1_EML_SND_DT IS NULL AND " ).append("\n"); 
		query.append("                 C2_EML_SND_DT IS NULL AND " ).append("\n"); 
		query.append("                 B1_EML_SND_DT IS NULL AND " ).append("\n"); 
		query.append("                 B2_EML_SND_DT IS NULL AND " ).append("\n"); 
		query.append("                 AN_EML_SND_DT IS NULL THEN 'N'              " ).append("\n"); 
		query.append("            WHEN NULLIF(LEAST(NVL(C1_FAX_NTC_SND_RSLT_CD,'9'), NVL(C2_FAX_NTC_SND_RSLT_CD,'9'), NVL(B1_FAX_NTC_SND_RSLT_CD,'9'), " ).append("\n"); 
		query.append("                              NVL(B2_FAX_NTC_SND_RSLT_CD,'9'), NVL(AN_FAX_NTC_SND_RSLT_CD,'9')),'9') = '6' OR" ).append("\n"); 
		query.append("                 NULLIF(LEAST(NVL(C1_EML_NTC_SND_RSLT_CD,'9'), NVL(C2_EML_NTC_SND_RSLT_CD,'9'), NVL(B1_EML_NTC_SND_RSLT_CD,'9'), " ).append("\n"); 
		query.append("                              NVL(B2_EML_NTC_SND_RSLT_CD,'9'), NVL(AN_EML_NTC_SND_RSLT_CD,'9')),'9') = '4' THEN 'F'              " ).append("\n"); 
		query.append("            WHEN GREATEST(NVL(C1_FAX_NTC_SND_RSLT_CD,'0'), NVL(C2_FAX_NTC_SND_RSLT_CD,'0'), NVL(B1_FAX_NTC_SND_RSLT_CD,'0'), " ).append("\n"); 
		query.append("                          NVL(B2_FAX_NTC_SND_RSLT_CD,'0'), NVL(AN_FAX_NTC_SND_RSLT_CD,'0')) IN ('5') OR                   " ).append("\n"); 
		query.append("                 GREATEST(NVL(C1_EML_NTC_SND_RSLT_CD,'0'), NVL(C2_EML_NTC_SND_RSLT_CD,'0'), NVL(B1_EML_NTC_SND_RSLT_CD,'0'), " ).append("\n"); 
		query.append("                          NVL(B2_EML_NTC_SND_RSLT_CD,'0'), NVL(AN_EML_NTC_SND_RSLT_CD,'0')) IN ('3') THEN 'S'" ).append("\n"); 
		query.append("            ELSE 'P' END AS SND_PROC_STS_CD       ," ).append("\n"); 
		query.append("       GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',PKUP_NTC.AUTO_SND_STOP_DT,USR_ORG.LOC_CD ) AS AUTO_SND_STOP_DT," ).append("\n"); 
		query.append("       PKUP_NTC.AUTO_SND_STOP_USR_ID," ).append("\n"); 
		query.append("       GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',PKUP_NTC.AUTO_SND_RESM_DT,USR_ORG.LOC_CD ) AS AUTO_SND_RESM_DT," ).append("\n"); 
		query.append("       PKUP_NTC.AUTO_SND_RESM_USR_ID," ).append("\n"); 
		query.append("       PKUP_NTC.BKG_CUST_TP_CD," ).append("\n"); 
		query.append("       PKUP_NTC.CUST_CNT_CD," ).append("\n"); 
		query.append("       PKUP_NTC.CUST_SEQ," ).append("\n"); 
		query.append("       PKUP_NTC.CUST_CNT_CD||DECODE(PKUP_NTC.CUST_CNT_CD,'','',LPAD(PKUP_NTC.CUST_SEQ,6,'0')) AS CUST_CD," ).append("\n"); 
		query.append("       PKUP_NTC.CUST_NM," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       PKUP_BKG.C1_FAX_NO_CHK," ).append("\n"); 
		query.append("       PKUP_BKG.C1_FAX_NO              ," ).append("\n"); 
		query.append("       PKUP_BKG.C1_FAX_SND_DT          ," ).append("\n"); 
		query.append("       PKUP_BKG.C1_FAX_SND_USR_ID      ," ).append("\n"); 
		query.append("       PKUP_BKG.C1_FAX_NTC_SND_ID      ," ).append("\n"); 
		query.append("       DECODE(NVL(PKUP_BKG.C1_FAX_NTC_SND_RSLT_CD,'9'),'5','S','6','F','9','N','P' ) AS C1_FAX_NTC_SND_RSLT," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       PKUP_BKG.C2_FAX_NO_CHK," ).append("\n"); 
		query.append("       PKUP_BKG.C2_FAX_NO              ," ).append("\n"); 
		query.append("       PKUP_BKG.C2_FAX_SND_DT          ," ).append("\n"); 
		query.append("       PKUP_BKG.C2_FAX_SND_USR_ID      ," ).append("\n"); 
		query.append("       PKUP_BKG.C2_FAX_NTC_SND_ID      ," ).append("\n"); 
		query.append("       DECODE(NVL(PKUP_BKG.C2_FAX_NTC_SND_RSLT_CD,'9'),'5','S','6','F','9','N','P' ) AS C2_FAX_NTC_SND_RSLT," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       PKUP_BKG.B1_FAX_NO_CHK," ).append("\n"); 
		query.append("       PKUP_BKG.B1_FAX_NO              ," ).append("\n"); 
		query.append("       PKUP_BKG.B1_FAX_SND_DT          ," ).append("\n"); 
		query.append("       PKUP_BKG.B1_FAX_SND_USR_ID      ," ).append("\n"); 
		query.append("       PKUP_BKG.B1_FAX_NTC_SND_ID      ," ).append("\n"); 
		query.append("       DECODE(NVL(PKUP_BKG.B1_FAX_NTC_SND_RSLT_CD,'9'),'5','S','6','F','9','N','P' ) AS B1_FAX_NTC_SND_RSLT," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       PKUP_BKG.B2_FAX_NO_CHK," ).append("\n"); 
		query.append("       PKUP_BKG.B2_FAX_NO              ," ).append("\n"); 
		query.append("       PKUP_BKG.B2_FAX_SND_DT          ," ).append("\n"); 
		query.append("       PKUP_BKG.B2_FAX_SND_USR_ID      ," ).append("\n"); 
		query.append("       PKUP_BKG.B2_FAX_NTC_SND_ID      ," ).append("\n"); 
		query.append("       DECODE(NVL(PKUP_BKG.B2_FAX_NTC_SND_RSLT_CD,'9'),'5','S','6','F','9','N','P' ) AS B2_FAX_NTC_SND_RSLT," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       PKUP_BKG.AN_FAX_NO_CHK," ).append("\n"); 
		query.append("       PKUP_BKG.AN_FAX_NO              ," ).append("\n"); 
		query.append("       PKUP_BKG.AN_FAX_SND_DT          ," ).append("\n"); 
		query.append("       PKUP_BKG.AN_FAX_SND_USR_ID      ," ).append("\n"); 
		query.append("       PKUP_BKG.AN_FAX_NTC_SND_ID      ," ).append("\n"); 
		query.append("       DECODE(NVL(PKUP_BKG.AN_FAX_NTC_SND_RSLT_CD,'9'),'5','S','6','F','9','N','P' ) AS AN_FAX_NTC_SND_RSLT," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       PKUP_BKG.C1_NTC_EML_CHK," ).append("\n"); 
		query.append("       PKUP_BKG.C1_NTC_EML             ," ).append("\n"); 
		query.append("       PKUP_BKG.C1_EML_SND_DT          ," ).append("\n"); 
		query.append("       PKUP_BKG.C1_EML_SND_USR_ID      ," ).append("\n"); 
		query.append("       PKUP_BKG.C1_EML_NTC_SND_ID      ," ).append("\n"); 
		query.append("       DECODE(NVL(C1_EML_NTC_SND_RSLT_CD,'9'),'3','S','4','F','9','N','P' ) AS C1_EML_NTC_SND_RSLT," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       PKUP_BKG.C2_NTC_EML_CHK," ).append("\n"); 
		query.append("       PKUP_BKG.C2_NTC_EML             ," ).append("\n"); 
		query.append("       PKUP_BKG.C2_EML_SND_DT          ," ).append("\n"); 
		query.append("       PKUP_BKG.C2_EML_SND_USR_ID      ," ).append("\n"); 
		query.append("       PKUP_BKG.C2_EML_NTC_SND_ID      ," ).append("\n"); 
		query.append("       DECODE(NVL(C2_EML_NTC_SND_RSLT_CD,'9'),'3','S','4','F','9','N','P' ) AS C2_EML_NTC_SND_RSLT," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       PKUP_BKG.B1_NTC_EML_CHK," ).append("\n"); 
		query.append("       PKUP_BKG.B1_NTC_EML             ," ).append("\n"); 
		query.append("       PKUP_BKG.B1_EML_SND_DT          ," ).append("\n"); 
		query.append("       PKUP_BKG.B1_EML_SND_USR_ID      ," ).append("\n"); 
		query.append("       PKUP_BKG.B1_EML_NTC_SND_ID      ," ).append("\n"); 
		query.append("       DECODE(NVL(B1_EML_NTC_SND_RSLT_CD,'9'),'3','S','4','F','9','N','P' ) AS B1_EML_NTC_SND_RSLT," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       PKUP_BKG.B2_NTC_EML_CHK," ).append("\n"); 
		query.append("       PKUP_BKG.B2_NTC_EML             ," ).append("\n"); 
		query.append("       PKUP_BKG.B2_EML_SND_DT          ," ).append("\n"); 
		query.append("       PKUP_BKG.B2_EML_SND_USR_ID      ," ).append("\n"); 
		query.append("       PKUP_BKG.B2_EML_NTC_SND_ID      ," ).append("\n"); 
		query.append("       DECODE(NVL(B2_EML_NTC_SND_RSLT_CD,'9'),'3','S','4','F','9','N','P' ) AS B2_EML_NTC_SND_RSLT," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       PKUP_BKG.AN_NTC_EML_CHK," ).append("\n"); 
		query.append("       PKUP_BKG.AN_NTC_EML             ," ).append("\n"); 
		query.append("       PKUP_BKG.AN_EML_SND_DT          ," ).append("\n"); 
		query.append("       PKUP_BKG.AN_EML_SND_USR_ID      ," ).append("\n"); 
		query.append("       PKUP_BKG.AN_EML_NTC_SND_ID      ," ).append("\n"); 
		query.append("       DECODE(NVL(AN_EML_NTC_SND_RSLT_CD,'9'),'3','S','4','F','9','N','P' ) AS AN_EML_NTC_SND_RSLT,      		   " ).append("\n"); 
		query.append("                               " ).append("\n"); 
		query.append("       PKUP_NTC.DIFF_RMK," ).append("\n"); 
		query.append("       PKUP_NTC.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("       PKUP_NTC.TRSP_SO_SEQ," ).append("\n"); 
		query.append("       PKUP_NTC.ECLZ_OBL_CPY_FLG," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       IBD.FREE_TRD_ZN_FLG     AS FREE_TRD_ZN_FLG," ).append("\n"); 
		query.append("       (CASE WHEN IBD.DIR_DE_FLG = ' ' THEN 'N/A' ELSE NVL(IBD.DIR_DE_FLG,'N') END) AS DIR_DE_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.BKG_NO, A.CNTR_NO, A.BKG_CUST_TP_CD, A.NTC_SEQ,                                                                                " ).append("\n"); 
		query.append("               '' AS C1_FAX_NO_CHK,                                                                                                 " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C1',C.FAX_NO)) AS C1_FAX_NO,                                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C1',NVL(C.FAX_SND_DT,COM_FAX.FAX_SND_LOCL_DT))) AS C1_FAX_SND_DT," ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C1',C.FAX_SND_USR_ID)) AS C1_FAX_SND_USR_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C1',C.FAX_NTC_SND_ID)) AS C1_FAX_NTC_SND_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C1',NVL(C.FAX_NTC_SND_RSLT_CD,COM_FAX.FAX_PROC_STS_CD))) AS C1_FAX_NTC_SND_RSLT_CD,      " ).append("\n"); 
		query.append("                                                                                                     " ).append("\n"); 
		query.append("               '' AS C2_FAX_NO_CHK,                                                                               " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C2',C.FAX_NO)) AS C2_FAX_NO,                                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C2',NVL(C.FAX_SND_DT,COM_FAX.FAX_SND_LOCL_DT))) AS C2_FAX_SND_DT,                        " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C2',C.FAX_SND_USR_ID)) AS C2_FAX_SND_USR_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C2',C.FAX_NTC_SND_ID)) AS C2_FAX_NTC_SND_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C2',NVL(C.FAX_NTC_SND_RSLT_CD,COM_FAX.FAX_PROC_STS_CD))) AS C2_FAX_NTC_SND_RSLT_CD,      " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               '' AS B1_FAX_NO_CHK,                                                                               " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B1',C.FAX_NO)) AS B1_FAX_NO,                                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B1',NVL(C.FAX_SND_DT,COM_FAX.FAX_SND_LOCL_DT))) AS B1_FAX_SND_DT,                        " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B1',C.FAX_SND_USR_ID)) AS B1_FAX_SND_USR_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B1',C.FAX_NTC_SND_ID)) AS B1_FAX_NTC_SND_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B2',NVL(C.FAX_NTC_SND_RSLT_CD,COM_FAX.FAX_PROC_STS_CD))) AS B1_FAX_NTC_SND_RSLT_CD,      " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               '' AS B2_FAX_NO_CHK,                                                                               " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B2',C.FAX_NO)) AS B2_FAX_NO,                                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B2',NVL(C.FAX_SND_DT,COM_FAX.FAX_SND_LOCL_DT))) AS B2_FAX_SND_DT,                        " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B2',C.FAX_SND_USR_ID)) AS B2_FAX_SND_USR_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B2',C.FAX_NTC_SND_ID)) AS B2_FAX_NTC_SND_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B2',NVL(C.FAX_NTC_SND_RSLT_CD,COM_FAX.FAX_PROC_STS_CD))) AS B2_FAX_NTC_SND_RSLT_CD,      " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               '' AS AN_FAX_NO_CHK,                                                                               " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'AN',C.FAX_NO)) AS AN_FAX_NO,                                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'AN',NVL(C.FAX_SND_DT,COM_FAX.FAX_SND_LOCL_DT))) AS AN_FAX_SND_DT,                        " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'AN',C.FAX_SND_USR_ID)) AS AN_FAX_SND_USR_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'AN',C.FAX_NTC_SND_ID)) AS AN_FAX_NTC_SND_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'AN',NVL(C.FAX_NTC_SND_RSLT_CD,COM_FAX.FAX_PROC_STS_CD))) AS AN_FAX_NTC_SND_RSLT_CD,      " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               '' AS C1_NTC_EML_CHK,                                                                              " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C1',C.NTC_EML)) AS C1_NTC_EML,                              " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C1',NVL(C.EML_SND_DT,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', COM_MAIL.EML_DT, NVL(ORG.LOC_CD,DECODE(A.EDI_322_MVMT_CD,'RL',D.POD_CD,D.DEL_CD)))))) AS C1_EML_SND_DT," ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C1',C.EML_SND_USR_ID)) AS C1_EML_SND_USR_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C1',C.EML_NTC_SND_ID)) AS C1_EML_NTC_SND_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C1',NVL(C.EML_NTC_SND_RSLT_CD,COM_MAIL.EML_PROC_STS_CD))) AS C1_EML_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               '' AS C2_NTC_EML_CHK,                                                                              " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C2',C.NTC_EML)) AS C2_NTC_EML,                              " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C2',NVL(C.EML_SND_DT,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', COM_MAIL.EML_DT, NVL(ORG.LOC_CD,DECODE(A.EDI_322_MVMT_CD,'RL',D.POD_CD,D.DEL_CD)))))) AS C2_EML_SND_DT,                        " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C2',C.EML_SND_USR_ID)) AS C2_EML_SND_USR_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C2',C.EML_NTC_SND_ID)) AS C2_EML_NTC_SND_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'C2',NVL(C.EML_NTC_SND_RSLT_CD,COM_MAIL.EML_PROC_STS_CD))) AS C2_EML_NTC_SND_RSLT_CD,      " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               '' AS B1_NTC_EML_CHK,                                                                              " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B1',C.NTC_EML)) AS B1_NTC_EML,                              " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B1',NVL(C.EML_SND_DT,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', COM_MAIL.EML_DT, NVL(ORG.LOC_CD,DECODE(A.EDI_322_MVMT_CD,'RL',D.POD_CD,D.DEL_CD)))))) AS B1_EML_SND_DT,                        " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B1',C.EML_SND_USR_ID)) AS B1_EML_SND_USR_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B1',C.EML_NTC_SND_ID)) AS B1_EML_NTC_SND_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B1',NVL(C.EML_NTC_SND_RSLT_CD,COM_MAIL.EML_PROC_STS_CD))) AS B1_EML_NTC_SND_RSLT_CD,      " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               '' AS B2_NTC_EML_CHK,                                                                              " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B2',C.NTC_EML)) AS B2_NTC_EML,                              " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B2',NVL(C.EML_SND_DT,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', COM_MAIL.EML_DT, NVL(ORG.LOC_CD,DECODE(A.EDI_322_MVMT_CD,'RL',D.POD_CD,D.DEL_CD)))))) AS B2_EML_SND_DT,                        " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B2',C.EML_SND_USR_ID)) AS B2_EML_SND_USR_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B2',C.EML_NTC_SND_ID)) AS B2_EML_NTC_SND_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'B2',NVL(C.EML_NTC_SND_RSLT_CD,COM_MAIL.EML_PROC_STS_CD))) AS B2_EML_NTC_SND_RSLT_CD,      " ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               '' AS AN_NTC_EML_CHK,                                                                              " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'AN',C.NTC_EML)) AS AN_NTC_EML,                              " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'AN',NVL(C.EML_SND_DT,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', COM_MAIL.EML_DT, NVL(ORG.LOC_CD,DECODE(A.EDI_322_MVMT_CD,'RL',D.POD_CD,D.DEL_CD)))))) AS AN_EML_SND_DT,                        " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'AN',C.EML_SND_USR_ID)) AS AN_EML_SND_USR_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'AN',C.EML_NTC_SND_ID)) AS AN_EML_NTC_SND_ID,                " ).append("\n"); 
		query.append("               MAX(DECODE(C.CUST_CNTC_TP_CD,'AN',NVL(C.EML_NTC_SND_RSLT_CD,COM_MAIL.EML_PROC_STS_CD))) AS AN_EML_NTC_SND_RSLT_CD,      " ).append("\n"); 
		query.append("                                                                                                                  " ).append("\n"); 
		query.append("               MAX(" ).append("\n"); 
		query.append("               GREATEST(NVL(DECODE(C.CUST_CNTC_TP_CD,'C1',NVL(C.FAX_SND_DT,COM_FAX.FAX_SND_LOCL_DT)),NULL_DT),                   " ).append("\n"); 
		query.append("                        NVL(DECODE(C.CUST_CNTC_TP_CD,'C2',NVL(C.FAX_SND_DT,COM_FAX.FAX_SND_LOCL_DT)),NULL_DT),                   " ).append("\n"); 
		query.append("                        NVL(DECODE(C.CUST_CNTC_TP_CD,'B1',NVL(C.FAX_SND_DT,COM_FAX.FAX_SND_LOCL_DT)),NULL_DT),                   " ).append("\n"); 
		query.append("                        NVL(DECODE(C.CUST_CNTC_TP_CD,'B2',NVL(C.FAX_SND_DT,COM_FAX.FAX_SND_LOCL_DT)),NULL_DT),                   " ).append("\n"); 
		query.append("                        NVL(DECODE(C.CUST_CNTC_TP_CD,'AN',NVL(C.FAX_SND_DT,COM_FAX.FAX_SND_LOCL_DT)),NULL_DT))) AS GRT_FAX_SND_DT," ).append("\n"); 
		query.append("               MAX(                                                                                                   " ).append("\n"); 
		query.append("               GREATEST(NVL(DECODE(C.CUST_CNTC_TP_CD,'C1',NVL(C.EML_SND_DT,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', COM_MAIL.EML_DT, NVL(ORG.LOC_CD,DECODE(A.EDI_322_MVMT_CD,'RL',D.POD_CD,D.DEL_CD))))),NULL_DT), " ).append("\n"); 
		query.append("                        NVL(DECODE(C.CUST_CNTC_TP_CD,'C2',NVL(C.EML_SND_DT,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', COM_MAIL.EML_DT, NVL(ORG.LOC_CD,DECODE(A.EDI_322_MVMT_CD,'RL',D.POD_CD,D.DEL_CD))))),NULL_DT),                   " ).append("\n"); 
		query.append("                        NVL(DECODE(C.CUST_CNTC_TP_CD,'B1',NVL(C.EML_SND_DT,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', COM_MAIL.EML_DT, NVL(ORG.LOC_CD,DECODE(A.EDI_322_MVMT_CD,'RL',D.POD_CD,D.DEL_CD))))),NULL_DT),                   " ).append("\n"); 
		query.append("                        NVL(DECODE(C.CUST_CNTC_TP_CD,'B2',NVL(C.EML_SND_DT,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', COM_MAIL.EML_DT, NVL(ORG.LOC_CD,DECODE(A.EDI_322_MVMT_CD,'RL',D.POD_CD,D.DEL_CD))))),NULL_DT),                   " ).append("\n"); 
		query.append("                        NVL(DECODE(C.CUST_CNTC_TP_CD,'AN',NVL(C.EML_SND_DT,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', COM_MAIL.EML_DT, NVL(ORG.LOC_CD,DECODE(A.EDI_322_MVMT_CD,'RL',D.POD_CD,D.DEL_CD))))),NULL_DT))) AS GRT_EML_SND_DT," ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("               ROW_NUMBER() OVER (PARTITION BY A.BKG_NO,A.CNTR_NO, A.BKG_CUST_TP_CD ORDER BY NVL(A.EXP_SND_KR_DT,TO_DATE('0001-01-01','YYYY-MM-DD')) DESC, A.NTC_SEQ DESC) RNUM" ).append("\n"); 
		query.append("#if(${sch_tp_cd} == 'DATE' && ${dt_tp_cd} == 'SENT')" ).append("\n"); 
		query.append("          FROM BKG_PKUP_NTC      A" ).append("\n"); 
		query.append("              ,BKG_PKUP_NTC_DTL  C          " ).append("\n"); 
		query.append("              ,COM_FAX_SND_INFO  COM_FAX" ).append("\n"); 
		query.append("              ,COM_EML_SND_INFO  COM_MAIL" ).append("\n"); 
		query.append("              ,BKG_BOOKING       D" ).append("\n"); 
		query.append("              ,MDM_ORGANIZATION  ORG" ).append("\n"); 
		query.append("              ,COM_USER          USR" ).append("\n"); 
		query.append("              ,( SELECT TO_DATE('0001-01-01','YYYY-MM-DD') AS NULL_DT" ).append("\n"); 
		query.append("                   FROM DUAL)" ).append("\n"); 
		query.append("         WHERE A.EXP_SND_DT     >= TO_DATE(@[dt_s], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("           AND A.EXP_SND_DT     < TO_DATE(@[dt_e], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("           AND C.BKG_NO(+)      = A.BKG_NO                                                                           " ).append("\n"); 
		query.append("           AND C.NTC_SEQ(+)     = A.NTC_SEQ     " ).append("\n"); 
		query.append("           AND C.FAX_NTC_SND_ID = COM_FAX.FAX_SND_NO(+)" ).append("\n"); 
		query.append("           AND C.EML_NTC_SND_ID = COM_MAIL.EML_SND_NO(+) " ).append("\n"); 
		query.append("           AND A.BKG_NO         = D.BKG_NO" ).append("\n"); 
		query.append("           AND USR.USR_ID(+)    = C.EML_SND_USR_ID" ).append("\n"); 
		query.append("           AND ORG.OFC_CD(+)    = USR.OFC_CD" ).append("\n"); 
		query.append("           AND A.PKUP_NTC_TP_CD <> 'TO'" ).append("\n"); 
		query.append("           AND A.PKUP_NTC_SND_STS_CD != 'X'" ).append("\n"); 
		query.append("      GROUP BY A.BKG_NO, A.CNTR_NO, A.BKG_CUST_TP_CD, A.NTC_SEQ, A.EXP_SND_KR_DT   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${sch_tp_cd} == 'MVMT')" ).append("\n"); 
		query.append("          FROM BKG_PKUP_NTC      A" ).append("\n"); 
		query.append("              ,BKG_PKUP_NTC_DTL  C          " ).append("\n"); 
		query.append("              ,COM_FAX_SND_INFO  COM_FAX" ).append("\n"); 
		query.append("              ,COM_EML_SND_INFO  COM_MAIL" ).append("\n"); 
		query.append("              ,BKG_BOOKING       D" ).append("\n"); 
		query.append("              ,MDM_ORGANIZATION  ORG" ).append("\n"); 
		query.append("              ,COM_USER          USR" ).append("\n"); 
		query.append("              ,( SELECT TO_DATE('0001-01-01','YYYY-MM-DD') AS NULL_DT" ).append("\n"); 
		query.append("                   FROM DUAL)" ).append("\n"); 
		query.append("         WHERE A.PKUP_NTC_EVNT_DT >= TO_DATE(@[dt_mvmt_s]||' '||@[tm_mvmt_s], 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("           AND A.PKUP_NTC_EVNT_DT < TO_DATE(@[dt_mvmt_e]||' '||@[tm_mvmt_e], 'YYYY-MM-DD HH24:MI') + 1" ).append("\n"); 
		query.append("           AND C.BKG_NO(+)       = A.BKG_NO                                                                           " ).append("\n"); 
		query.append("           AND C.NTC_SEQ(+)      = A.NTC_SEQ     " ).append("\n"); 
		query.append("           AND C.FAX_NTC_SND_ID = COM_FAX.FAX_SND_NO(+)" ).append("\n"); 
		query.append("           AND C.EML_NTC_SND_ID = COM_MAIL.EML_SND_NO(+) " ).append("\n"); 
		query.append("           AND A.BKG_NO         = D.BKG_NO" ).append("\n"); 
		query.append("           AND USR.USR_ID(+)    = C.EML_SND_USR_ID" ).append("\n"); 
		query.append("           AND ORG.OFC_CD(+)    = USR.OFC_CD" ).append("\n"); 
		query.append("           AND A.PKUP_NTC_TP_CD <> 'TO'" ).append("\n"); 
		query.append("           AND A.PKUP_NTC_SND_STS_CD != 'X'" ).append("\n"); 
		query.append("      GROUP BY A.BKG_NO, A.CNTR_NO, A.BKG_CUST_TP_CD, A.NTC_SEQ, A.EXP_SND_KR_DT   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${sch_tp_cd} == 'DATE' && ${dt_tp_cd} == 'UPLOAD')" ).append("\n"); 
		query.append("          FROM BKG_PKUP_NTC         A                                                                             " ).append("\n"); 
		query.append("              ,BKG_PKUP_NTC_PKUP_NO B                                                                             " ).append("\n"); 
		query.append("              ,BKG_PKUP_NTC_DTL     C          " ).append("\n"); 
		query.append("              ,COM_FAX_SND_INFO     COM_FAX" ).append("\n"); 
		query.append("              ,COM_EML_SND_INFO     COM_MAIL" ).append("\n"); 
		query.append("              ,BKG_BOOKING          D" ).append("\n"); 
		query.append("              ,MDM_ORGANIZATION     ORG" ).append("\n"); 
		query.append("              ,COM_USER             USR" ).append("\n"); 
		query.append("              ,( SELECT TO_DATE('0001-01-01','YYYY-MM-DD') AS NULL_DT" ).append("\n"); 
		query.append("                   FROM DUAL)" ).append("\n"); 
		query.append("         WHERE B.BKG_NO         = A.BKG_NO                                                                           " ).append("\n"); 
		query.append("           AND B.CNTR_NO        = A.CNTR_NO                                                                          " ).append("\n"); 
		query.append("           AND B.PKUP_UPD_DT    >= TO_DATE(@[dt_s], 'YYYY-MM-DD')                                               " ).append("\n"); 
		query.append("           AND B.PKUP_UPD_DT    < TO_DATE(@[dt_e], 'YYYY-MM-DD') + 1                                                                                                                     " ).append("\n"); 
		query.append("           AND C.BKG_NO(+)      = A.BKG_NO                                                                           " ).append("\n"); 
		query.append("           AND C.NTC_SEQ(+)     = A.NTC_SEQ     " ).append("\n"); 
		query.append("           AND C.FAX_NTC_SND_ID = COM_FAX.FAX_SND_NO(+)" ).append("\n"); 
		query.append("           AND C.EML_NTC_SND_ID = COM_MAIL.EML_SND_NO(+) " ).append("\n"); 
		query.append("           AND A.BKG_NO         = D.BKG_NO" ).append("\n"); 
		query.append("           AND USR.USR_ID(+)    = C.EML_SND_USR_ID" ).append("\n"); 
		query.append("           AND ORG.OFC_CD(+)    = USR.OFC_CD" ).append("\n"); 
		query.append("           AND A.PKUP_NTC_TP_CD <> 'TO'" ).append("\n"); 
		query.append("           AND A.PKUP_NTC_SND_STS_CD != 'X'" ).append("\n"); 
		query.append("      GROUP BY A.BKG_NO, A.CNTR_NO, A.BKG_CUST_TP_CD, A.NTC_SEQ, A.EXP_SND_KR_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${sch_tp_cd} == 'DATE' && ${dt_tp_cd} == 'ATA')" ).append("\n"); 
		query.append("            FROM BKG_PKUP_NTC      A" ).append("\n"); 
		query.append("                ,VSK_VSL_PORT_SKD  B" ).append("\n"); 
		query.append("                ,BKG_PKUP_NTC_DTL  C" ).append("\n"); 
		query.append("                ,BKG_BOOKING       D       " ).append("\n"); 
		query.append("                ,COM_FAX_SND_INFO  COM_FAX" ).append("\n"); 
		query.append("                ,COM_EML_SND_INFO  COM_MAIL" ).append("\n"); 
		query.append("                ,MDM_ORGANIZATION  ORG" ).append("\n"); 
		query.append("                ,COM_USER          USR" ).append("\n"); 
		query.append("                ,( SELECT TO_DATE('0001-01-01','YYYY-MM-DD') AS NULL_DT" ).append("\n"); 
		query.append("                     FROM DUAL)" ).append("\n"); 
		query.append("           WHERE D.BKG_NO         = A.BKG_NO" ).append("\n"); 
		query.append("             AND D.VSL_CD         = B.VSL_CD" ).append("\n"); 
		query.append("             AND D.SKD_VOY_NO     = B.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND D.SKD_DIR_CD     = B.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND B.VPS_ETA_DT     >= TO_DATE(@[dt_s], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("             AND B.VPS_ETA_DT     <  TO_DATE(@[dt_e], 'YYYY-MM-DD') + 1" ).append("\n"); 
		query.append("             AND C.BKG_NO(+)      = A.BKG_NO                                                                           " ).append("\n"); 
		query.append("             AND C.NTC_SEQ(+)     = A.NTC_SEQ    " ).append("\n"); 
		query.append("             AND C.FAX_NTC_SND_ID = COM_FAX.FAX_SND_NO(+)" ).append("\n"); 
		query.append("             AND C.EML_NTC_SND_ID = COM_MAIL.EML_SND_NO(+) " ).append("\n"); 
		query.append("             AND USR.USR_ID(+)    = C.EML_SND_USR_ID" ).append("\n"); 
		query.append("             AND ORG.OFC_CD(+)    = USR.OFC_CD" ).append("\n"); 
		query.append("             AND A.PKUP_NTC_TP_CD <> 'TO'" ).append("\n"); 
		query.append("             AND A.PKUP_NTC_SND_STS_CD != 'X'" ).append("\n"); 
		query.append("      GROUP BY A.BKG_NO, A.CNTR_NO, A.BKG_CUST_TP_CD, A.NTC_SEQ, A.EXP_SND_KR_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${sch_tp_cd} == 'BL')" ).append("\n"); 
		query.append("          FROM BKG_PKUP_NTC         A                                                                           " ).append("\n"); 
		query.append("              ,BKG_PKUP_NTC_DTL     C          " ).append("\n"); 
		query.append("              ,COM_FAX_SND_INFO     COM_FAX" ).append("\n"); 
		query.append("              ,COM_EML_SND_INFO     COM_MAIL" ).append("\n"); 
		query.append("              ,BKG_BOOKING          D" ).append("\n"); 
		query.append("              ,MDM_ORGANIZATION     ORG" ).append("\n"); 
		query.append("              ,COM_USER             USR" ).append("\n"); 
		query.append("              ,( SELECT TO_DATE('0001-01-01','YYYY-MM-DD') AS NULL_DT" ).append("\n"); 
		query.append("                   FROM DUAL)" ).append("\n"); 
		query.append("         WHERE D.BKG_NO         = A.BKG_NO" ).append("\n"); 
		query.append("           AND D.BL_NO          = @[bl_no]                                                                                                               " ).append("\n"); 
		query.append("           AND C.BKG_NO(+)      = A.BKG_NO                                                                           " ).append("\n"); 
		query.append("           AND C.NTC_SEQ(+)     = A.NTC_SEQ     " ).append("\n"); 
		query.append("           AND C.FAX_NTC_SND_ID = COM_FAX.FAX_SND_NO(+)" ).append("\n"); 
		query.append("           AND C.EML_NTC_SND_ID = COM_MAIL.EML_SND_NO(+) " ).append("\n"); 
		query.append("           AND USR.USR_ID(+)    = C.EML_SND_USR_ID" ).append("\n"); 
		query.append("           AND ORG.OFC_CD(+)    = USR.OFC_CD" ).append("\n"); 
		query.append("           AND A.PKUP_NTC_TP_CD <> 'TO'" ).append("\n"); 
		query.append("           AND A.PKUP_NTC_SND_STS_CD != 'X'" ).append("\n"); 
		query.append("      GROUP BY A.BKG_NO, A.CNTR_NO, A.BKG_CUST_TP_CD, A.NTC_SEQ, A.EXP_SND_KR_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("       ) PKUP_BKG," ).append("\n"); 
		query.append("       BKG_PKUP_NTC          PKUP_NTC," ).append("\n"); 
		query.append("       BKG_PKUP_NTC_PKUP_NO  PKUP_NO ," ).append("\n"); 
		query.append("       BKG_BOOKING           BKG     ," ).append("\n"); 
		query.append("       TRS_TRSP_RAIL_BIL_ORD RAIL    ," ).append("\n"); 
		query.append("       BKG_CGO_RLSE          US_CGO  ," ).append("\n"); 
		query.append("       MDM_LOCATION          LOC     ," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_BL      CSTMS   ," ).append("\n"); 
		query.append("       MDM_ORGANIZATION      USR_ORG ," ).append("\n"); 
		query.append("       BKG_CONTAINER         CNTR    ," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_IBD     IBD" ).append("\n"); 
		query.append(" WHERE PKUP_BKG.RNUM = 1" ).append("\n"); 
		query.append("   AND PKUP_BKG.NTC_SEQ        = PKUP_BKG.NTC_SEQ" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND PKUP_BKG.BKG_NO         = PKUP_NTC.BKG_NO" ).append("\n"); 
		query.append("   AND PKUP_BKG.NTC_SEQ        = PKUP_NTC.NTC_SEQ" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND PKUP_NTC.BKG_NO         = PKUP_NO.BKG_NO" ).append("\n"); 
		query.append("   AND PKUP_NTC.CNTR_NO        = PKUP_NO.CNTR_NO   " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND PKUP_NTC.BKG_NO         = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND PKUP_NTC.TRSP_SO_OFC_CTY_CD = RAIL.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND PKUP_NTC.TRSP_SO_SEQ    = RAIL.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND BKG.BL_NO               = US_CGO.BL_NO(+)" ).append("\n"); 
		query.append("   AND BKG.DEL_CD              = LOC.LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND DECODE(SUBSTR(BKG.DEL_CD,1,2),'US','PHXSA',LOC.EQ_CTRL_OFC_CD) = PKUP_NO.OFC_CD" ).append("\n"); 
		query.append("   AND USR_ORG.OFC_CD(+)       = @[usr_ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND BKG.BL_NO               = CSTMS.BL_NO(+)" ).append("\n"); 
		query.append("   AND CSTMS.CNT_CD(+)         = 'US'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND PKUP_BKG.BKG_NO         = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("   AND PKUP_BKG.CNTR_NO        = CNTR.CNTR_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND IBD.CNT_CD(+)         = 'US'" ).append("\n"); 
		query.append("   AND BKG.BL_NO        = IBD.BL_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${eq_ofc_cd} != '')" ).append("\n"); 
		query.append(" AND LOC.EQ_CTRL_OFC_CD = @[eq_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${upd_usr_id} != '')" ).append("\n"); 
		query.append(" AND PKUP_NO.PKUP_UPD_USR_ID = DECODE(@[upd_usr_id],'EDI','BAT_BKG_019',@[upd_usr_id])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${snd_sts_cd} != '')" ).append("\n"); 
		query.append(" AND CASE " ).append("\n"); 
		query.append("     WHEN LEAST(NVL(C1_FAX_NTC_SND_RSLT_CD,'9'), NVL(C2_FAX_NTC_SND_RSLT_CD,'9'), NVL(B1_FAX_NTC_SND_RSLT_CD,'9'), " ).append("\n"); 
		query.append("                       NVL(B2_FAX_NTC_SND_RSLT_CD,'9'), NVL(AN_FAX_NTC_SND_RSLT_CD,'9')) = '9' AND" ).append("\n"); 
		query.append("          LEAST(NVL(C1_EML_NTC_SND_RSLT_CD,'9'), NVL(C2_EML_NTC_SND_RSLT_CD,'9'), NVL(B1_EML_NTC_SND_RSLT_CD,'9'), " ).append("\n"); 
		query.append("                       NVL(B2_EML_NTC_SND_RSLT_CD,'9'), NVL(AN_EML_NTC_SND_RSLT_CD,'9')) = '9' THEN 'N'              " ).append("\n"); 
		query.append("     WHEN NULLIF(LEAST(NVL(C1_FAX_NTC_SND_RSLT_CD,'9'), NVL(C2_FAX_NTC_SND_RSLT_CD,'9'), NVL(B1_FAX_NTC_SND_RSLT_CD,'9'), " ).append("\n"); 
		query.append("                       NVL(B2_FAX_NTC_SND_RSLT_CD,'9'), NVL(AN_FAX_NTC_SND_RSLT_CD,'9')),'9') = '6' OR" ).append("\n"); 
		query.append("          NULLIF(LEAST(NVL(C1_EML_NTC_SND_RSLT_CD,'9'), NVL(C2_EML_NTC_SND_RSLT_CD,'9'), NVL(B1_EML_NTC_SND_RSLT_CD,'9'), " ).append("\n"); 
		query.append("                       NVL(B2_EML_NTC_SND_RSLT_CD,'9'), NVL(AN_EML_NTC_SND_RSLT_CD,'9')),'9') = '4' THEN 'F'              " ).append("\n"); 
		query.append("     WHEN GREATEST(NVL(C1_FAX_NTC_SND_RSLT_CD,'0'), NVL(C2_FAX_NTC_SND_RSLT_CD,'0'), NVL(B1_FAX_NTC_SND_RSLT_CD,'0'), " ).append("\n"); 
		query.append("                   NVL(B2_FAX_NTC_SND_RSLT_CD,'0'), NVL(AN_FAX_NTC_SND_RSLT_CD,'0')) IN ('5') OR                   " ).append("\n"); 
		query.append("          GREATEST(NVL(C1_EML_NTC_SND_RSLT_CD,'0'), NVL(C2_EML_NTC_SND_RSLT_CD,'0'), NVL(B1_EML_NTC_SND_RSLT_CD,'0'), " ).append("\n"); 
		query.append("                   NVL(B2_EML_NTC_SND_RSLT_CD,'0'), NVL(AN_EML_NTC_SND_RSLT_CD,'0')) IN ('3') THEN 'S'" ).append("\n"); 
		query.append("	#if(${snd_sts_cd} == 'Y')" ).append("\n"); 
		query.append("		ELSE 'P' END IN ('F','S','P')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		ELSE 'P' END = @[snd_sts_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ntc_tp_cd} != '')" ).append("\n"); 
		query.append("    #if(${ntc_tp_cd} == 'MA')" ).append("\n"); 
		query.append(" AND PKUP_NTC.PKUP_NTC_TP_CD IN ('MA','WO')" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append(" AND PKUP_NTC.PKUP_NTC_TP_CD = @[ntc_tp_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${foc_tp_cd} == 'C')" ).append("\n"); 
		query.append(" AND US_CGO.FRT_CLT_FLG||US_CGO.OBL_RDEM_FLG||US_CGO.CSTMS_CLR_CD = 'YYY'" ).append("\n"); 
		query.append("#elseif(${foc_tp_cd} == 'N')" ).append("\n"); 
		query.append(" AND US_CGO.FRT_CLT_FLG||US_CGO.OBL_RDEM_FLG||US_CGO.CSTMS_CLR_CD <> 'YYY'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ow_flag} != '')" ).append("\n"); 
		query.append(" AND CASE WHEN RAIL.TRSP_SO_OFC_CTY_CD IS NULL THEN CNTR.CNTR_WGT * DECODE(CNTR.WGT_UT_CD,'KGS',(1/0.453),1)" ).append("\n"); 
		query.append("          ELSE RAIL.CNTR_WGT * DECODE(RAIL.WGT_MEAS_UT_CD, 'KGS', (1/0.453), 1) END > 45000" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${contact_flag} != '')" ).append("\n"); 
		query.append(" AND (PKUP_BKG.C1_FAX_NO IS NULL AND" ).append("\n"); 
		query.append("      PKUP_BKG.C2_FAX_NO IS NULL AND" ).append("\n"); 
		query.append("      PKUP_BKG.B1_FAX_NO IS NULL AND" ).append("\n"); 
		query.append("      PKUP_BKG.B2_FAX_NO IS NULL AND" ).append("\n"); 
		query.append("      PKUP_BKG.AN_FAX_NO IS NULL AND" ).append("\n"); 
		query.append("      PKUP_BKG.C1_NTC_EML IS NULL AND" ).append("\n"); 
		query.append("      PKUP_BKG.C2_NTC_EML IS NULL AND" ).append("\n"); 
		query.append("      PKUP_BKG.B1_NTC_EML IS NULL AND" ).append("\n"); 
		query.append("      PKUP_BKG.B2_NTC_EML IS NULL AND" ).append("\n"); 
		query.append("      PKUP_BKG.AN_NTC_EML IS NULL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${stop_flag} != '')" ).append("\n"); 
		query.append(" AND DECODE(PKUP_NTC.AUTO_SND_STOP_FLG||PKUP_NTC.AUTO_SND_RESM_FLG,'YN','Y','N') = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${rail_co_cd} == 'B')" ).append("\n"); 
		query.append("AND BKG.POD_CD LIKE 'CA%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${mvmt_cd} != '')" ).append("\n"); 
		query.append("AND NVL(DECODE(PKUP_NO.LST_FREE_DT,NULL,DECODE(PKUP_NO.PKUP_AVAL_DT,NULL,NULL,'NT'),'NF'),PKUP_NTC.EDI_322_MVMT_CD) = @[mvmt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}