/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOaddCllMainForDownloadCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOaddCllMainForDownloadCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addCllMainForDownload
	  * </pre>
	  */
	public CLLCDLManifestDBDAOaddCllMainForDownloadCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tbn_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tbx_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_teu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_feu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOaddCllMainForDownloadCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_TML_CLL" ).append("\n"); 
		query.append("				(VSL_CD," ).append("\n"); 
		query.append("				SKD_VOY_NO," ).append("\n"); 
		query.append("				SKD_DIR_CD," ).append("\n"); 
		query.append("				PORT_CD," ).append("\n"); 
		query.append("				ETA_DT," ).append("\n"); 
		query.append("				ETD_DT," ).append("\n"); 
		query.append("				BKG_NO," ).append("\n"); 
		query.append("				CNTR_NO," ).append("\n"); 
		query.append("				BL_NO," ).append("\n"); 
		query.append("				BL_TP_CD," ).append("\n"); 
		query.append("				CRE_DT," ).append("\n"); 
		query.append("				UPD_DT," ).append("\n"); 
		query.append("				SND_DT," ).append("\n"); 
		query.append("				POR_CD," ).append("\n"); 
		query.append("				POL_CD," ).append("\n"); 
		query.append("				POD_CD," ).append("\n"); 
		query.append("				DEL_CD," ).append("\n"); 
		query.append("				SHPR_CNT_CD," ).append("\n"); 
		query.append("				SHPR_SEQ," ).append("\n"); 
		query.append("				SHPR_NM1," ).append("\n"); 
		query.append("				SHPR_NM2," ).append("\n"); 
		query.append("				SHPR_NM3," ).append("\n"); 
		query.append("				SHPR_NM4," ).append("\n"); 
		query.append("				SHPR_NM5," ).append("\n"); 
		query.append("				CNEE_CNT_CD," ).append("\n"); 
		query.append("				CNEE_SEQ," ).append("\n"); 
		query.append("				CNEE_NM1," ).append("\n"); 
		query.append("				CNEE_NM2," ).append("\n"); 
		query.append("				CNEE_NM3," ).append("\n"); 
		query.append("				CNEE_NM4," ).append("\n"); 
		query.append("				CNEE_NM5," ).append("\n"); 
		query.append("				NTFY_CNT_CD," ).append("\n"); 
		query.append("				NTFY_SEQ," ).append("\n"); 
		query.append("				NTFY_NM1," ).append("\n"); 
		query.append("				NTFY_NM2," ).append("\n"); 
		query.append("				NTFY_NM3," ).append("\n"); 
		query.append("				NTFY_NM4," ).append("\n"); 
		query.append("				NTFY_NM5," ).append("\n"); 
		query.append("				ANTFY_CNT_CD," ).append("\n"); 
		query.append("				ANTFY_SEQ," ).append("\n"); 
		query.append("				ANTFY_NM1," ).append("\n"); 
		query.append("				ANTFY_NM2," ).append("\n"); 
		query.append("				ANTFY_NM3," ).append("\n"); 
		query.append("				ANTFY_NM4," ).append("\n"); 
		query.append("				ANTFY_NM5," ).append("\n"); 
		query.append("				FF_CNT_CD," ).append("\n"); 
		query.append("				FF_CUST_SEQ," ).append("\n"); 
		query.append("				FF_NM1," ).append("\n"); 
		query.append("				FF_NM2," ).append("\n"); 
		query.append("				FF_NM3," ).append("\n"); 
		query.append("				FF_NM4," ).append("\n"); 
		query.append("				FF_NM5," ).append("\n"); 
		query.append("				CNTR_TPSZ_CD," ).append("\n"); 
		query.append("				SOC_FLG," ).append("\n"); 
		query.append("				FULL_MTY_CD," ).append("\n"); 
		query.append("				RCV_TERM_CD," ).append("\n"); 
		query.append("				DE_TERM_CD," ).append("\n"); 
		query.append("				PCK_TP_CD," ).append("\n"); 
		query.append("				PCK_QTY," ).append("\n"); 
		query.append("				WGT_TP_CD," ).append("\n"); 
		query.append("				CNTR_WGT," ).append("\n"); 
		query.append("				GRS_WGT_UT_CD," ).append("\n"); 
		query.append("				GRS_CNTR_WGT," ).append("\n"); 
		query.append("				CNTR_MEAS_UT_CD," ).append("\n"); 
		query.append("				MEAS_QTY," ).append("\n"); 
		query.append("				OVR_FWRD_LEN," ).append("\n"); 
		query.append("				OVR_BKWD_LEN," ).append("\n"); 
		query.append("				OVR_HGT," ).append("\n"); 
		query.append("				OVR_PORT_LEN," ).append("\n"); 
		query.append("				OVR_SD_LEN," ).append("\n"); 
		query.append("				OVR_WGT_UT_CD," ).append("\n"); 
		query.append("				OVR_CNTR_WGT," ).append("\n"); 
		query.append("				FDO_TEMP," ).append("\n"); 
		query.append("				CDO_TEMP," ).append("\n"); 
		query.append("				CNTR_VENT_RTO," ).append("\n"); 
		query.append("				CNTR_SEAL_NO," ).append("\n"); 
		query.append("				TS_CGO_CD," ).append("\n"); 
		query.append("				TARE_CNTR_WGT," ).append("\n"); 
		query.append("				TS_VVD_ID," ).append("\n"); 
		query.append("				TS_POL_CD," ).append("\n"); 
		query.append("				TS_POD_CD," ).append("\n"); 
		query.append("				CMDT_CD," ).append("\n"); 
		query.append("				CMDT_DESC," ).append("\n"); 
		query.append("				REP_CMDT_CD," ).append("\n"); 
		query.append("				REP_CMDT_DESC," ).append("\n"); 
		query.append("				CNTR_LODG_NO," ).append("\n"); 
		query.append("				TRNK_VVD_ID," ).append("\n"); 
		query.append("				CFM_FLG," ).append("\n"); 
		query.append("				TEU_CNTR_QTY," ).append("\n"); 
		query.append("				FEU_CNTR_QTY," ).append("\n"); 
		query.append("				RC_FLG," ).append("\n"); 
		query.append("				DCGO_FLG," ).append("\n"); 
		query.append("				AWK_CGO_FLG," ).append("\n"); 
		query.append("				BB_CGO_FLG," ).append("\n"); 
		query.append("				RD_CGO_FLG," ).append("\n"); 
		query.append("				LIST_RMK," ).append("\n"); 
		query.append("				BL_RMK," ).append("\n"); 
		query.append("				CRE_USR_ID," ).append("\n"); 
		query.append("				UPD_USR_ID," ).append("\n"); 
		query.append("				RC_SEQ," ).append("\n"); 
		query.append("				AWK_CGO_SEQ," ).append("\n"); 
		query.append("				VGM_WGT" ).append("\n"); 
		query.append("				#if (${pol_split_no} != '')" ).append("\n"); 
		query.append("        		,CLPT_IND_SEQ " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				,VGM_VRFY_SIG_CTNT" ).append("\n"); 
		query.append("                ,VGM_MZD_TP_CD" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			SELECT	V.VSL_CD," ).append("\n"); 
		query.append("					V.SKD_VOY_NO," ).append("\n"); 
		query.append("					V.SKD_DIR_CD," ).append("\n"); 
		query.append("					V.POL_CD," ).append("\n"); 
		query.append("					NVL(TO_DATE(@[vps_eta_dt],'YYYYMMDDHH24MI'),NULL)," ).append("\n"); 
		query.append("					NVL(TO_DATE(@[vps_etd_dt],'YYYYMMDDHH24MI'),NULL)," ).append("\n"); 
		query.append("					B.BKG_NO," ).append("\n"); 
		query.append("					NVL(C.CNTR_NO,@[tbx_seq])," ).append("\n"); 
		query.append("					NVL(B.BL_NO,' '),NVL(B.BL_TP_CD,' ')," ).append("\n"); 
		query.append("					SYSDATE," ).append("\n"); 
		query.append("					SYSDATE," ).append("\n"); 
		query.append("					NULL," ).append("\n"); 
		query.append("					NVL(B.POR_CD,' ')," ).append("\n"); 
		query.append("					NVL(B.POL_CD,' ')," ).append("\n"); 
		query.append("					NVL(B.POD_CD,' ')," ).append("\n"); 
		query.append("					NVL(B.DEL_CD,' ')," ).append("\n"); 
		query.append("					NVL(BCS.CUST_CNT_CD,' ')," ).append("\n"); 
		query.append("					BCS.CUST_SEQ," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCS.CUST_NM,1)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCS.CUST_NM,2)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,1)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,2)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCS.CUST_ADDR,3)," ).append("\n"); 
		query.append("					NVL(BCC.CUST_CNT_CD,' ')," ).append("\n"); 
		query.append("					BCC.CUST_SEQ," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCC.CUST_NM,1)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCC.CUST_NM,2)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,1)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,2)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCC.CUST_ADDR,3)," ).append("\n"); 
		query.append("					NVL(BCN.CUST_CNT_CD,' ')," ).append("\n"); 
		query.append("					BCN.CUST_SEQ," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCN.CUST_NM,1)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCN.CUST_NM,2)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,1)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,2)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCN.CUST_ADDR,3)," ).append("\n"); 
		query.append("					NVL(BCA.CUST_CNT_CD,' ')," ).append("\n"); 
		query.append("					BCA.CUST_SEQ," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCA.CUST_NM,1)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCA.CUST_NM,2)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCA.CUST_NM,3)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCA.CUST_NM,4)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCA.CUST_NM,5)," ).append("\n"); 
		query.append("					NVL(BCF.CUST_CNT_CD,' ')," ).append("\n"); 
		query.append("					BCF.CUST_SEQ," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCF.CUST_NM,1)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCF.CUST_NM,2)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCF.CUST_NM,3)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCF.CUST_NM,4)," ).append("\n"); 
		query.append("					SCE_TOKEN_NL_FNC(BCF.CUST_NM,5)," ).append("\n"); 
		query.append("					@[cntr_tpsz_cd]," ).append("\n"); 
		query.append("					NVL(C.SOC_FLG,' ')," ).append("\n"); 
		query.append("					DECODE(B.BKG_CGO_TP_CD,'F','F','M')," ).append("\n"); 
		query.append("					NVL(C.RCV_TERM_CD,' '),NVL(C.DE_TERM_CD,' ')," ).append("\n"); 
		query.append("					NVL(C.PCK_TP_CD,' ')," ).append("\n"); 
		query.append("					NVL(C.PCK_QTY, 0)," ).append("\n"); 
		query.append("					DECODE(C.WGT_UT_CD, NULL, DOC.WGT_UT_CD, C.WGT_UT_CD)," ).append("\n"); 
		query.append("					DECODE(NVL(C.CNTR_WGT,0), 0, ROUND(DOC.ACT_WGT / @[in_qty], 0), ROUND(C.CNTR_WGT,0))," ).append("\n"); 
		query.append("					DECODE(C.WGT_UT_CD, NULL, DOC.WGT_UT_CD, C.WGT_UT_CD)," ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("					ROUND(" ).append("\n"); 
		query.append("					(DECODE(NVL(C.CNTR_WGT,0),0,ROUND(nvl(DOC.ACT_WGT,0) * decode(substr(NVL(C.CNTR_TPSZ_CD,@[cntr_tpsz_cd]),2,1),'2',1,2) / NVL((SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,2)) FROM BKG_CONTAINER BC WHERE BC.BKG_NO = C.BKG_NO),1)),C.CNTR_WGT)" ).append("\n"); 
		query.append("					+ DECODE(NVL(DECODE(NVL(KKK.SPEC_TARE_WGT, 0), 0, DECODE(NVL(KKK.MDM_CNTR_TPSZ_TARE_WGT, 0), 0, DECODE(KKK.O_CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0), KKK.MDM_CNTR_TPSZ_TARE_WGT), KKK.SPEC_TARE_WGT  ),0),0,(SELECT CNTR_TPSZ_TARE_WGT FROM MDM_CNTR_TP_SZ WHERE CNTR_TPSZ_CD = @[cntr_tpsz_cd]), NVL(DECODE(NVL(KKK.SPEC_TARE_WGT, 0), 0, DECODE(NVL(KKK.MDM_CNTR_TPSZ_TARE_WGT, 0), 0, DECODE(KKK.O_CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0), KKK.MDM_CNTR_TPSZ_TARE_WGT), KKK.SPEC_TARE_WGT  ),0))) * DECODE(NVL(C.WGT_UT_CD, ' '), 'LBS',0.4536,1),2)," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					DECODE(C.MEAS_UT_CD, NULL, DOC.MEAS_UT_CD, C.MEAS_UT_CD)," ).append("\n"); 
		query.append("					DECODE(C.MEAS_QTY,NULL,ROUND(DOC.MEAS_QTY / @[in_qty], 0),C.MEAS_QTY)," ).append("\n"); 
		query.append("					NVL(A.OVR_FWRD_LEN,NULL)," ).append("\n"); 
		query.append("					NVL(A.OVR_BKWD_LEN,NULL)," ).append("\n"); 
		query.append("					NVL(A.OVR_HGT,NULL)," ).append("\n"); 
		query.append("					NVL(A.OVR_LF_LEN,NULL)," ).append("\n"); 
		query.append("					NVL(A.OVR_RT_LEN,NULL)," ).append("\n"); 
		query.append("					NVL(A.WGT_UT_CD,NULL)," ).append("\n"); 
		query.append("					NVL(A.GRS_WGT,0)," ).append("\n"); 
		query.append("					NVL(R.FDO_TEMP,NULL)," ).append("\n"); 
		query.append("					NVL(R.CDO_TEMP,NULL)," ).append("\n"); 
		query.append("					NVL(R.VENT_RTO,NULL)," ).append("\n"); 
		query.append("					NVL(( SELECT CNTR_SEAL_NO --NVL(MIN(CNTR_SEAL_NO),' ') " ).append("\n"); 
		query.append("					   FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("					   WHERE BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("					   AND CNTR_NO = C.CNTR_NO " ).append("\n"); 
		query.append("                       AND CNTR_SEAL_SEQ = 1),' ') AS CNTR_SEAL_NO," ).append("\n"); 
		query.append("					DECODE(B.POL_CD,V.POL_CD,'L','T')," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					DECODE(NVL(DECODE(NVL(KKK.SPEC_TARE_WGT, 0), 0, DECODE(NVL(KKK.MDM_CNTR_TPSZ_TARE_WGT, 0), 0, DECODE(KKK.O_CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0), KKK.MDM_CNTR_TPSZ_TARE_WGT), KKK.SPEC_TARE_WGT  ),0),0,(SELECT CNTR_TPSZ_TARE_WGT FROM MDM_CNTR_TP_SZ WHERE CNTR_TPSZ_CD = @[cntr_tpsz_cd]), NVL(DECODE(NVL(KKK.SPEC_TARE_WGT, 0), 0, DECODE(NVL(KKK.MDM_CNTR_TPSZ_TARE_WGT, 0), 0, DECODE(KKK.O_CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0), KKK.MDM_CNTR_TPSZ_TARE_WGT), KKK.SPEC_TARE_WGT  ),0))," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					T.VSL_CD||T.SKD_VOY_NO||T.SKD_DIR_CD," ).append("\n"); 
		query.append("					T.POL_CD," ).append("\n"); 
		query.append("					T.POD_CD," ).append("\n"); 
		query.append("					O.CMDT_CD," ).append("\n"); 
		query.append("					O.CMDT_NM," ).append("\n"); 
		query.append("					P.REP_CMDT_CD," ).append("\n"); 
		query.append("					P.REP_CMDT_NM," ).append("\n"); 
		query.append("					@[tbn_seq]," ).append("\n"); 
		query.append("					B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD," ).append("\n"); 
		query.append("					DECODE(C.CNTR_CFM_FLG,NULL,'N','Y','Y',C.MF_CFM_FLG)," ).append("\n"); 
		query.append("					NVL(@[in_teu],0)," ).append("\n"); 
		query.append("					NVL(@[in_feu],0)," ).append("\n"); 
		query.append("					NVL(C.RC_FLG,'N')," ).append("\n"); 
		query.append("					NVL(C.DCGO_FLG,'N')," ).append("\n"); 
		query.append("					NVL(C.AWK_CGO_FLG,'N')," ).append("\n"); 
		query.append("					NVL(C.BB_CGO_FLG,'N')," ).append("\n"); 
		query.append("					NVL(C.RD_CGO_FLG,'N')," ).append("\n"); 
		query.append("					substr(Translate(NVL(R.DIFF_RMK,' '),chr(13)||chr(10),' '),1,50)," ).append("\n"); 
		query.append("        			substr(Translate(NVL(B.XTER_RMK,' '),chr(13)||chr(10),' '),1,200)," ).append("\n"); 
		query.append("					@[in_usr_id]," ).append("\n"); 
		query.append("					@[in_usr_id]," ).append("\n"); 
		query.append("					R.RC_SEQ," ).append("\n"); 
		query.append("					A.AWK_CGO_SEQ," ).append("\n"); 
		query.append("					DECODE(NVL(C.VGM_WGT_UT_CD, 0), 'LBS', ROUND (NVL(C.VGM_WGT, 0)*0.4536, 3), NVL(C.VGM_WGT, 0)) VGM_WGT" ).append("\n"); 
		query.append("					#if (${pol_split_no} != '')" ).append("\n"); 
		query.append("					, V.POL_CLPT_IND_SEQ -- Add. 2015.02.09. CHM-201533845" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					,C.VGM_VRFY_SIG_CTNT" ).append("\n"); 
		query.append("                	,C.VGM_MZD_TP_CD" ).append("\n"); 
		query.append("			 FROM	BKG_BOOKING B," ).append("\n"); 
		query.append("					BKG_BL_DOC DOC," ).append("\n"); 
		query.append("					MDM_COMMODITY O," ).append("\n"); 
		query.append("					MDM_REP_CMDT P," ).append("\n"); 
		query.append("					BKG_VVD V," ).append("\n"); 
		query.append("					BKG_VVD T," ).append("\n"); 
		query.append("					BKG_CONTAINER C," ).append("\n"); 
		query.append("					BKG_RF_CGO R," ).append("\n"); 
		query.append("					BKG_AWK_CGO A," ).append("\n"); 
		query.append("					BKG_CUSTOMER BCS," ).append("\n"); 
		query.append("					BKG_CUSTOMER BCC," ).append("\n"); 
		query.append("					BKG_CUSTOMER BCN," ).append("\n"); 
		query.append("					BKG_CUSTOMER BCA," ).append("\n"); 
		query.append("					BKG_CUSTOMER BCF," ).append("\n"); 
		query.append("					( SELECT NVL(SPEC.TARE_WGT,0) SPEC_TARE_WGT, NVL(MDM.CNTR_TPSZ_TARE_WGT,0) MDM_CNTR_TPSZ_TARE_WGT," ).append("\n"); 
		query.append("					         NVL(O.CNTR_TPSZ_CD,'') O_CNTR_TPSZ_CD, O.CNTR_NO CNTR_NO, @[bkg_no] BKG_NO" ).append("\n"); 
		query.append("					FROM " ).append("\n"); 
		query.append("        			MST_CONTAINER    O," ).append("\n"); 
		query.append("        			MST_CNTR_SPEC    SPEC," ).append("\n"); 
		query.append("        			MDM_CNTR_TP_SZ   MDM" ).append("\n"); 
		query.append("					  WHERE 1=1" ).append("\n"); 
		query.append("            			 AND    O.CNTR_NO          = @[cntr_no]" ).append("\n"); 
		query.append("            			 AND    O.CNTR_SPEC_NO     = SPEC.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("            			 AND    O.CNTR_TPSZ_CD     = MDM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            			 AND    ROWNUM = 1 ) KKK" ).append("\n"); 
		query.append("			 WHERE	B.BKG_NO	= @[bkg_no]" ).append("\n"); 
		query.append("			 AND	B.BKG_NO	= DOC.BKG_NO" ).append("\n"); 
		query.append("			 AND	C.CNTR_NO(+)	= @[cntr_no]" ).append("\n"); 
		query.append("			 AND	B.BKG_NO	= C.BKG_NO(+)" ).append("\n"); 
		query.append("			 AND	B.BKG_NO	= V.BKG_NO(+)" ).append("\n"); 
		query.append("			 AND	@[in_pol_cd]	= V.POL_CD(+)" ).append("\n"); 
		query.append("			 #if (${pol_split_no} != '')" ).append("\n"); 
		query.append("			 AND    @[pol_split_no] = V.POL_CLPT_IND_SEQ(+) -- Add. 2015.02.09. CHM-201533845" ).append("\n"); 
		query.append("			 #end" ).append("\n"); 
		query.append("			 AND	B.BKG_NO	= T.BKG_NO(+)" ).append("\n"); 
		query.append("			 AND	@[in_pol_cd]	= T.POD_CD(+)" ).append("\n"); 
		query.append("			 AND	B.CMDT_CD	= O.CMDT_CD(+)" ).append("\n"); 
		query.append("			 AND	B.REP_CMDT_CD	= P.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("			 AND	C.BKG_NO	= R.BKG_NO(+)" ).append("\n"); 
		query.append("			 AND	C.CNTR_NO	= R.CNTR_NO(+)" ).append("\n"); 
		query.append("			 AND	C.BKG_NO	= A.BKG_NO(+)" ).append("\n"); 
		query.append("			 AND	C.CNTR_NO	= A.CNTR_NO(+)" ).append("\n"); 
		query.append("			 AND	B.BKG_NO	= BCS.BKG_NO" ).append("\n"); 
		query.append("			 AND	BCS.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("			 AND	B.BKG_NO	= BCC.BKG_NO" ).append("\n"); 
		query.append("			 AND	BCC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("			 AND	B.BKG_NO	= BCN.BKG_NO" ).append("\n"); 
		query.append("			 AND	BCN.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("			 AND	B.BKG_NO	= BCA.BKG_NO(+)" ).append("\n"); 
		query.append("			 AND	BCA.BKG_CUST_TP_CD (+) = 'A'" ).append("\n"); 
		query.append("			 AND	B.BKG_NO	= BCF.BKG_NO(+)" ).append("\n"); 
		query.append("			 AND	BCF.BKG_CUST_TP_CD (+) = 'F'" ).append("\n"); 
		query.append("			 AND    KKK.CNTR_NO(+) = @[cntr_no]" ).append("\n"); 
		query.append("			 AND    KKK.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("			 AND	ROWNUM = 1" ).append("\n"); 

	}
}