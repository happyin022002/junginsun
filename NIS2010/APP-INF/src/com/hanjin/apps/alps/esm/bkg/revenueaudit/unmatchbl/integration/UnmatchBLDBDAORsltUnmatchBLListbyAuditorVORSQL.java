/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : UnmatchBLDBDAORsltUnmatchBLListbyAuditorVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.13 
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

public class UnmatchBLDBDAORsltUnmatchBLListbyAuditorVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.08.21 변종건 [CHM-201219689-01] [BKG_OB]  Error B/L Inquiry by Auditor - SQL 튜닝 결과 반영
	  * </pre>
	  */
	public UnmatchBLDBDAORsltUnmatchBLListbyAuditorVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("contract_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gso",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("conti_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnl_stl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_aud_stl_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rater_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_aply_dt_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bdr_status_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAORsltUnmatchBLListbyAuditorVORSQL").append("\n"); 
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
		query.append("SELECT  BKG_NO" ).append("\n"); 
		query.append("      , UMCH_BKG_SEQ" ).append("\n"); 
		query.append("      , RT_APLY_DT" ).append("\n"); 
		query.append("      , RCT_RHQ_CD" ).append("\n"); 
		query.append("      , BKG_OFC_CD" ).append("\n"); 
		query.append("      , VVD_CD" ).append("\n"); 
		query.append("      , BL_NO" ).append("\n"); 
		query.append("      , SC_RFA_NO" ).append("\n"); 
		query.append("      , DECODE(CTRT_TP_CD, 'R', 'RFA', 'S', 'S/C', 'TAA')  CTRT_TP_CD" ).append("\n"); 
		query.append("      , BKG_GET_TOKEN_FNC(U1,1) UMCH_A" ).append("\n"); 
		query.append("      , BKG_GET_TOKEN_FNC(U1,2) UMCH_Al" ).append("\n"); 
		query.append("      , BKG_GET_TOKEN_FNC(U1,3) UMCH_All" ).append("\n"); 
		query.append("      , DECODE(REV_AUD_STS_CD,'S','',TRIM(TO_CHAR(sysdate - TO_DATE(N1ST_UMCH_FND_DT,'YYYY-MM-DD'),'999999'))) ERROR_LAPSE --추가" ).append("\n"); 
		query.append("      , BKG_GET_TOKEN_FNC(U1,4) UMCH_B" ).append("\n"); 
		query.append("      , BKG_GET_TOKEN_FNC(U1,5) UMCH_C" ).append("\n"); 
		query.append("      , BKG_GET_TOKEN_FNC(U1,6) UMCH_D" ).append("\n"); 
		query.append("      , BKG_GET_TOKEN_FNC(U1,7) UMCH_E" ).append("\n"); 
		query.append("      , BKG_GET_TOKEN_FNC(U1,8) UMCH_F" ).append("\n"); 
		query.append("      , BKG_GET_TOKEN_FNC(U1,9) UMCH_G" ).append("\n"); 
		query.append("      , BKG_CONTRACT" ).append("\n"); 
		query.append("      , DIFF_USD_AMT" ).append("\n"); 
		query.append("      , RDN_NO" ).append("\n"); 
		query.append("      , ( SELECT  INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("          FROM    COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                , BKG_REV_DR_NOTE A" ).append("\n"); 
		query.append("          WHERE   1 = 1" ).append("\n"); 
		query.append("          AND     INTG_CD_ID = 'CD01568'" ).append("\n"); 
		query.append("          AND     INTG_CD_VAL_CTNT = A.RDN_STS_CD" ).append("\n"); 
		query.append("          AND     A.RDN_NO = J.RDN_NO" ).append("\n"); 
		query.append("          AND     A.RVIS_SEQ = ( SELECT MAX(RVIS_SEQ) FROM BKG_REV_DR_NOTE K WHERE K.RDN_NO = A.RDN_NO )" ).append("\n"); 
		query.append("        ) RDN_STATUS" ).append("\n"); 
		query.append("      , ( SELECT  MIN (TO_CHAR(VSK.VPS_ETD_DT,'YYYY-MM-DD'))" ).append("\n"); 
		query.append("          FROM    BKG_VVD VVD, VSK_VSL_PORT_SKD VSK, BKG_BOOKING BK" ).append("\n"); 
		query.append("          WHERE   1 = 1" ).append("\n"); 
		query.append("          AND     VSK.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("          AND     VSK.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND     VSK.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND     VSK.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("          AND     VSK.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("          AND     VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("          AND     VVD.POL_CD = BK.POL_CD" ).append("\n"); 
		query.append("          AND     BK.BKG_NO = J.BKG_NO" ).append("\n"); 
		query.append("        ) POL_ETD" ).append("\n"); 
		query.append("      , REV_AUD_STS_CD" ).append("\n"); 
		query.append("      , REV_AUD_STS_NM" ).append("\n"); 
		query.append("      , REV_AUD_STL_KND_CD" ).append("\n"); 
		query.append("      , REV_AUD_STL_KND_NM" ).append("\n"); 
		query.append("      , MNL_STL_TP_CD MNL_STL_TP" ).append("\n"); 
		query.append("      , UMCH_RSN_RMK" ).append("\n"); 
		query.append("      , RGN_GRP_AVC_RMK" ).append("\n"); 
		query.append("      , REV_AUD_AMT" ).append("\n"); 
		query.append("      , RATER_ID" ).append("\n"); 
		query.append("      , BKG_CTRT_TP_CD" ).append("\n"); 
		query.append("      , AUTO_RAT_FLG" ).append("\n"); 
		query.append("      , N1ST_UMCH_FND_DT" ).append("\n"); 
		query.append("      , LST_UMCH_FND_DT" ).append("\n"); 
		query.append("      , REV_AUD_TP_CD" ).append("\n"); 
		query.append("      , REV_AUD_TP_NM" ).append("\n"); 
		query.append("      , UPD_DT" ).append("\n"); 
		query.append("      , UPD_USR_ID" ).append("\n"); 
		query.append("      , TO_CHAR(BDR_DT,'YYYY-MM-DD') BDR_DT" ).append("\n"); 
		query.append("      , SREP_CD" ).append("\n"); 
		query.append("      , DECODE(BDR_FLG, 'N', 'No', 'Y', 'Yes', 'No')  BDR_FLG" ).append("\n"); 
		query.append("      , STL_PRD" ).append("\n"); 
		query.append("      , ''  RT_APLY_DT_FROM" ).append("\n"); 
		query.append("      , ''  RT_APLY_DT_TO" ).append("\n"); 
		query.append("      , ''  UMCH_TP_CD" ).append("\n"); 
		query.append("      , ''  AUDIT_SEQ_CD" ).append("\n"); 
		query.append("      , ''  RCT_OFC_CD" ).append("\n"); 
		query.append("      , ''  BDR_STATUS_CD" ).append("\n"); 
		query.append("      , ''  CONTRACT_NO" ).append("\n"); 
		query.append("      , CASE WHEN ERR_CHG1 IS NOT NULL AND ERR_CHG2 IS NOT NULL THEN ERR_CHG1||','||ERR_CHG2" ).append("\n"); 
		query.append("             WHEN ERR_CHG1 IS NULL THEN ERR_CHG2" ).append("\n"); 
		query.append("             WHEN ERR_CHG2 IS NULL THEN ERR_CHG1" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END ERR_CHG" ).append("\n"); 
		query.append("      , TO_CHAR(PORT_CLZ_DT,'YYYY-MM-DD')  PORT_CLZ_DT" ).append("\n"); 
		query.append("      , SVC_SCP_CD" ).append("\n"); 
		query.append("      , POR_CD" ).append("\n"); 
		query.append("      , POL_CD" ).append("\n"); 
		query.append("      , POD_CD" ).append("\n"); 
		query.append("      , DEL_CD" ).append("\n"); 
		query.append("      , DECODE(MNL_STL_RQST_FLG,'Y',1,0) AS MNL_STL_RQST_FLG" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("          SELECT  UB.BKG_NO" ).append("\n"); 
		query.append("                , UB.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("                , BB.BDR_DT   BDR_DT" ).append("\n"); 
		query.append("                , BK.OB_SREP_CD SREP_CD" ).append("\n"); 
		query.append("                , TO_CHAR(BR.RT_APLY_DT,'YYYY-MM-DD') RT_APLY_DT" ).append("\n"); 
		query.append("                , (" ).append("\n"); 
		query.append("                    SELECT  A.OFC_CD" ).append("\n"); 
		query.append("                    FROM    MDM_ORGANIZATION A" ).append("\n"); 
		query.append("                    WHERE   A.OFC_TP_CD = 'HQ'" ).append("\n"); 
		query.append("                    START   WITH A.OFC_CD = BK.BKG_OFC_CD" ).append("\n"); 
		query.append("                    CONNECT BY PRIOR A.PRNT_OFC_CD = A.OFC_CD" ).append("\n"); 
		query.append("                  ) RCT_RHQ_CD                                       --RHQ" ).append("\n"); 
		query.append("                , BK.BKG_OFC_CD                                      --OFFICE" ).append("\n"); 
		query.append("                , BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD   VVD_CD     --VVD_CD" ).append("\n"); 
		query.append("                , BK.BL_NO                                       --BL_NO" ).append("\n"); 
		query.append("                , DECODE(BR.BKG_CTRT_TP_CD, 'S', BK.SC_NO, 'R', BK.RFA_NO, 'T', BK.TAA_NO)  SC_RFA_NO" ).append("\n"); 
		query.append("                , BR.BKG_CTRT_TP_CD CTRT_TP_CD                     -- 계약 TYPE" ).append("\n"); 
		query.append("                , ( SELECT  MAX(CASE WHEN UMCH_TP_CD = 'A'  THEN UMCH_TP_CD END)||','||" ).append("\n"); 
		query.append("                            MAX(CASE WHEN UMCH_TP_CD = 'A1' THEN UMCH_TP_CD END)||','||" ).append("\n"); 
		query.append("                            MAX(CASE WHEN UMCH_TP_CD = 'A2' THEN UMCH_TP_CD END)||','||" ).append("\n"); 
		query.append("                            MAX(CASE WHEN UMCH_TP_CD = 'B'  THEN UMCH_TP_CD END)||','||" ).append("\n"); 
		query.append("                            MAX(CASE WHEN UMCH_TP_CD = 'C'  THEN UMCH_TP_CD END)||','||" ).append("\n"); 
		query.append("                            MAX(CASE WHEN UMCH_TP_CD = 'D'  THEN UMCH_TP_CD END)||','||" ).append("\n"); 
		query.append("                            MAX(CASE WHEN UMCH_TP_CD = 'E'  THEN UMCH_TP_CD END)||','||" ).append("\n"); 
		query.append("                            MAX(CASE WHEN UMCH_TP_CD = 'F'  THEN UMCH_TP_CD END)||','||" ).append("\n"); 
		query.append("                            MAX(CASE WHEN UMCH_TP_CD = 'G'  THEN UMCH_TP_CD END)" ).append("\n"); 
		query.append("                    FROM    BKG_REV_UMCH_ITM  U1" ).append("\n"); 
		query.append("                    WHERE   1 = 1" ).append("\n"); 
		query.append("                    AND     U1.BKG_NO = UB.BKG_NO" ).append("\n"); 
		query.append("                    AND     U1.UMCH_BKG_SEQ = UB.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("                    GROUP BY BKG_NO, UMCH_BKG_SEQ" ).append("\n"); 
		query.append("                  ) U1" ).append("\n"); 
		query.append("                , ( SELECT BKG_REV_CTRT_ITM_LOG(UB.BKG_NO,UB.UMCH_BKG_SEQ) FROM DUAL ) BKG_CONTRACT" ).append("\n"); 
		query.append("                , UB.STL_MNL_DIFF_AMT DIFF_USD_AMT                   --DFF_USD_AMT" ).append("\n"); 
		query.append("                , (" ).append("\n"); 
		query.append("                    SELECT  MAX(A.RDN_NO)" ).append("\n"); 
		query.append("                    FROM    BKG_REV_DR_NOTE A" ).append("\n"); 
		query.append("                    WHERE   A.BKG_NO  = UB.BKG_NO" ).append("\n"); 
		query.append("                  ) RDN_NO                                       --최신 RDN_NO" ).append("\n"); 
		query.append("                , UB.REV_AUD_STS_CD                              --SETTLE CODE" ).append("\n"); 
		query.append("                , ( SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01570' AND INTG_CD_VAL_CTNT = UB.REV_AUD_STS_CD ) REV_AUD_STS_NM" ).append("\n"); 
		query.append("                , UB.REV_AUD_STL_KND_CD                                     --SETTLE DETAIL CODE" ).append("\n"); 
		query.append("                , ( SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02134' AND INTG_CD_VAL_CTNT = UB.REV_AUD_STL_KND_CD  ) REV_AUD_STL_KND_NM" ).append("\n"); 
		query.append("                , UB.MNL_STL_TP_CD                                     -- MANUAL SETTLE TYPE CODE" ).append("\n"); 
		query.append("                , UB.MNL_STL_RQST_FLG" ).append("\n"); 
		query.append("                , UB.UMCH_RSN_RMK                                            --RMK BY OFFICE" ).append("\n"); 
		query.append("                , UB.RGN_GRP_AVC_RMK                                         --RMK BY AUDITOR" ).append("\n"); 
		query.append("                , UB.REV_AUD_AMT" ).append("\n"); 
		query.append("                , NVL((" ).append("\n"); 
		query.append("                    SELECT  UPD_USR_ID" ).append("\n"); 
		query.append("                    FROM    (" ).append("\n"); 
		query.append("                              SELECT  BKG_NO" ).append("\n"); 
		query.append("                                    , UPD_USR_ID" ).append("\n"); 
		query.append("                                    , ROW_NUMBER() OVER( PARTITION BY BKG_NO ORDER BY UPD_DT DESC ) ROW_NUMBER" ).append("\n"); 
		query.append("                              FROM    BKG_CHG_RT" ).append("\n"); 
		query.append("                            ) A" ).append("\n"); 
		query.append("                    WHERE   A.BKG_NO    = UB.BKG_NO" ).append("\n"); 
		query.append("                    AND     ROW_NUMBER  = 1" ).append("\n"); 
		query.append("                  ),'N/A') RATER_ID                                       --RATER_ID" ).append("\n"); 
		query.append("                , BR.BKG_CTRT_TP_CD" ).append("\n"); 
		query.append("                , TO_CHAR(UB.N1ST_UMCH_FND_DT , 'YYYY-MM-DD') N1ST_UMCH_FND_DT" ).append("\n"); 
		query.append("                , TO_CHAR(UB.LST_UMCH_FND_DT  , 'YYYY-MM-DD') LST_UMCH_FND_DT" ).append("\n"); 
		query.append("                , UB.REV_AUD_TP_CD" ).append("\n"); 
		query.append("                , ( SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02164' AND INTG_CD_VAL_CTNT = UB.REV_AUD_TP_CD ) REV_AUD_TP_NM" ).append("\n"); 
		query.append("                , DECODE(UB.REV_AUD_STS_CD, 'S', TO_CHAR(UB.STL_DT,'YYYY-MM-DD')) UPD_DT" ).append("\n"); 
		query.append("                , DECODE(UB.REV_AUD_STS_CD, 'S', UB.STL_USR_ID)                   UPD_USR_ID" ).append("\n"); 
		query.append("                , NVL(BB.BDR_FLG, 'N')  BDR_FLG" ).append("\n"); 
		query.append("                , NVL((" ).append("\n"); 
		query.append("                    SELECT  MAX(DECODE(AUTO_RAT_CD, 'A', 'A', 'I', 'A', 'M'))" ).append("\n"); 
		query.append("                    FROM    BKG_CHG_RT  A" ).append("\n"); 
		query.append("                    WHERE   A.BKG_NO    = UB.BKG_NO" ).append("\n"); 
		query.append("                  ),'N') AUTO_RAT_FLG" ).append("\n"); 
		query.append("                , CASE WHEN UB.REV_AUD_STS_CD = 'S' AND UB.STL_DT < BK.PORT_CLZ_DT" ).append("\n"); 
		query.append("                            THEN NULL" ).append("\n"); 
		query.append("                       WHEN UB.REV_AUD_STS_CD = 'S' AND UB.N1ST_UMCH_FND_DT < BK.PORT_CLZ_DT " ).append("\n"); 
		query.append("                            THEN TRUNC(UB.STL_DT) - TRUNC(BK.PORT_CLZ_DT)" ).append("\n"); 
		query.append("                       WHEN UB.REV_AUD_STS_CD = 'S' AND UB.N1ST_UMCH_FND_DT > BK.PORT_CLZ_DT" ).append("\n"); 
		query.append("                            THEN TRUNC(UB.STL_DT) - TRUNC(UB.N1ST_UMCH_FND_DT)" ).append("\n"); 
		query.append("                       WHEN UB.REV_AUD_STS_CD = 'U' AND UB.N1ST_UMCH_FND_DT < BK.PORT_CLZ_DT" ).append("\n"); 
		query.append("                            THEN TRUNC(SYSDATE) - TRUNC(BK.PORT_CLZ_DT)" ).append("\n"); 
		query.append("                       WHEN UB.REV_AUD_STS_CD = 'U' AND UB.N1ST_UMCH_FND_DT > BK.PORT_CLZ_DT" ).append("\n"); 
		query.append("                            THEN TRUNC(SYSDATE) - TRUNC(UB.N1ST_UMCH_FND_DT)" ).append("\n"); 
		query.append("                  END STL_PRD" ).append("\n"); 
		query.append("                , REPLACE(REPLACE(BKG_JOIN_FNC(CURSOR( SELECT  BKG_GET_TOKEN_FNC(COLUMN_VALUE ,1,']')||']' COL" ).append("\n"); 
		query.append("                                                       FROM    TABLE(BKG_SPLIT_CLOB_FNC( ( SELECT  CTRT_ITM_LOG" ).append("\n"); 
		query.append("                                                                                           FROM    BKG_REV_UMCH_ITM" ).append("\n"); 
		query.append("                                                                                           WHERE   BKG_NO =UB.BKG_NO" ).append("\n"); 
		query.append("                                                                                           AND     UMCH_TP_CD IN ('E')" ).append("\n"); 
		query.append("                                                                                           AND     UMCH_BKG_SEQ = UB.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("                                                                                         ),CHR(10))" ).append("\n"); 
		query.append("                                                                    )" ).append("\n"); 
		query.append("                                                       WHERE   SUBSTR(COLUMN_VALUE,1,1) ='['" ).append("\n"); 
		query.append("                                                       AND     LENGTH(COLUMN_VALUE) =47" ).append("\n"); 
		query.append("                                                     )),']',''),'[','') ERR_CHG1" ).append("\n"); 
		query.append("                , REPLACE(REPLACE(BKG_JOIN_FNC(CURSOR( SELECT  BKG_GET_TOKEN_FNC(COLUMN_VALUE ,1,']')||']' COL" ).append("\n"); 
		query.append("                                                       FROM    TABLE(BKG_SPLIT_CLOB_FNC( ( SELECT  CTRT_ITM_LOG" ).append("\n"); 
		query.append("                                                                                           FROM    BKG_REV_UMCH_ITM" ).append("\n"); 
		query.append("                                                                                           WHERE   BKG_NO =UB.BKG_NO" ).append("\n"); 
		query.append("                                                                                           AND     UMCH_TP_CD IN ('F')" ).append("\n"); 
		query.append("                                                                                           AND     UMCH_BKG_SEQ = UB.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("                                                                                         ),CHR(10))" ).append("\n"); 
		query.append("                                                                    )" ).append("\n"); 
		query.append("                                                       WHERE SUBSTR(COLUMN_VALUE,1,1) ='['" ).append("\n"); 
		query.append("                                                     )),']',''),'[','') ERR_CHG2" ).append("\n"); 
		query.append("                , BK.PORT_CLZ_DT PORT_CLZ_DT   " ).append("\n"); 
		query.append("                , BK.SVC_SCP_CD   " ).append("\n"); 
		query.append("                , BK.POR_CD   " ).append("\n"); 
		query.append("                , BK.POL_CD   " ).append("\n"); 
		query.append("                , BK.POD_CD   " ).append("\n"); 
		query.append("                , BK.DEL_CD   " ).append("\n"); 
		query.append("          FROM    BKG_REV_UMCH_BKG  UB" ).append("\n"); 
		query.append("                , BKG_BOOKING       BK" ).append("\n"); 
		query.append("                , BKG_RATE          BR" ).append("\n"); 
		query.append("                , BKG_BL_DOC        BB" ).append("\n"); 
		query.append("                , MDM_LOCATION	    POR" ).append("\n"); 
		query.append("                , MDM_LOCATION	    DEL " ).append("\n"); 
		query.append("          WHERE   BK.BKG_NO       = UB.BKG_NO" ).append("\n"); 
		query.append("          AND     BR.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("          AND     BB.BKG_NO       = BK.BKG_NO" ).append("\n"); 
		query.append("		  AND     BK.POR_CD 		= POR.LOC_CD" ).append("\n"); 
		query.append("		  AND     BK.DEL_CD 		= DEL.LOC_CD" ).append("\n"); 
		query.append("		  AND     BK.BKG_CGO_TP_CD    = 'F'" ).append("\n"); 
		query.append("          AND     3 = (SELECT COUNT(*) FROM BKG_CUSTOMER WHERE BKG_NO = BK.BKG_NO AND BKG_CUST_TP_CD IN ('S', 'C', 'N'))" ).append("\n"); 
		query.append("		  AND     POR.CONTI_CD = NVL(@[conti_cd], POR.CONTI_CD)" ).append("\n"); 
		query.append("		  AND     DEL.CONTI_CD = NVL(@[conti_cd2], DEL.CONTI_CD)    " ).append("\n"); 
		query.append("    #if (${audit_seq_cd} == 'P')" ).append("\n"); 
		query.append("          AND EXISTS ( SELECT  'Y'" ).append("\n"); 
		query.append("                       FROM    BKG_REV_UMCH_ITM ITM" ).append("\n"); 
		query.append("                       WHERE   ITM.BKG_NO = UB.BKG_NO" ).append("\n"); 
		query.append("                       AND     ITM.UMCH_BKG_SEQ = UB.UMCH_BKG_SEQ" ).append("\n"); 
		query.append("                       AND     ITM.UMCH_BKG_SEQ = ( SELECT MAX(UMCH_BKG_SEQ) FROM BKG_REV_UMCH_ITM WHERE BKG_NO = ITM.BKG_NO ) " ).append("\n"); 
		query.append("                       AND     ROWNUM = 1" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${dt_type} == 'AUD') " ).append("\n"); 
		query.append("        #if (${rt_aply_dt_from} != '')" ).append("\n"); 
		query.append("          AND     UB.N1ST_UMCH_FND_DT >= TO_DATE(@[rt_aply_dt_from],'YYYY/MM/DD')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${rt_aply_dt_to} != '')" ).append("\n"); 
		query.append("          AND     UB.N1ST_UMCH_FND_DT <= TO_DATE(@[rt_aply_dt_to],'YYYY/MM/DD') + 0.99999" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("	#elseif (${dt_type} == 'PCT')  " ).append("\n"); 
		query.append("        #if (${rt_aply_dt_from} != '')     " ).append("\n"); 
		query.append("          AND BK.PORT_CLZ_DT >=  TO_DATE(@[rt_aply_dt_from],'yyyy-mm-dd')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${rt_aply_dt_to} != '') " ).append("\n"); 
		query.append("          AND BK.PORT_CLZ_DT <=  TO_DATE(@[rt_aply_dt_to],'yyyy-mm-dd') + 0.99999" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("	#elseif (${dt_type} == 'APL')  " ).append("\n"); 
		query.append("        #if (${rt_aply_dt_from} != '')     " ).append("\n"); 
		query.append("          AND BR.RT_APLY_DT >=  TO_DATE(@[rt_aply_dt_from],'yyyy-mm-dd')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${rt_aply_dt_to} != '') " ).append("\n"); 
		query.append("          AND BR.RT_APLY_DT <=  TO_DATE(@[rt_aply_dt_to],'yyyy-mm-dd') + 0.99999" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${stl_usr_id} != '')" ).append("\n"); 
		query.append("          AND     UB.STL_USR_ID         = @[stl_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${mnl_stl_tp_cd} != '')" ).append("\n"); 
		query.append("          AND     UB.MNL_STL_TP_CD      = @[mnl_stl_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND     UB.REV_AUD_STS_CD     = NVL(@[rev_aud_sts_cd], UB.REV_AUD_STS_CD)" ).append("\n"); 
		query.append("          AND     NVL(UB.REV_AUD_STL_KND_CD,'X') = NVL(@[rev_aud_stl_knd_cd], NVL(UB.REV_AUD_STL_KND_CD,'X'))" ).append("\n"); 
		query.append("          AND     BK.BKG_OFC_CD         = NVL(@[rct_ofc_cd], BK.BKG_OFC_CD)" ).append("\n"); 
		query.append("          AND     BK.BL_NO        		= NVL(@[bl_no], BK.BL_NO)" ).append("\n"); 
		query.append("          AND     BK.VSL_CD             = NVL(SUBSTR(@[vvd_cd],1,4), BK.VSL_CD)" ).append("\n"); 
		query.append("          AND     BK.SKD_VOY_NO         = NVL(SUBSTR(@[vvd_cd],5,4), BK.SKD_VOY_NO)" ).append("\n"); 
		query.append("          AND     BK.SKD_DIR_CD         = NVL(SUBSTR(@[vvd_cd],9,1), BK.SKD_DIR_CD)" ).append("\n"); 
		query.append("          AND     BK.POR_CD             LIKE NVL(@[por_cd], BK.POR_CD)||'%'" ).append("\n"); 
		query.append("          AND     BK.POL_CD             LIKE NVL(@[pol_cd], BK.POL_CD)||'%'" ).append("\n"); 
		query.append("          AND     BK.POD_CD             LIKE NVL(@[pod_cd], BK.POD_CD)||'%'" ).append("\n"); 
		query.append("          AND     BK.DEL_CD             LIKE NVL(@[del_cd], BK.DEL_CD)||'%'" ).append("\n"); 
		query.append("          AND     BR.BKG_CTRT_TP_CD     = NVL(@[bkg_ctrt_tp_cd], BR.BKG_CTRT_TP_CD) " ).append("\n"); 
		query.append("#if(${svc_scp_cd} != '')   " ).append("\n"); 
		query.append("          AND     BK.SVC_SCP_CD         = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND     BK.BKG_OFC_CD         IN(SELECT  OFC_CD" ).append("\n"); 
		query.append("                                           FROM    MDM_ORGANIZATION " ).append("\n"); 
		query.append("                                           START WITH OFC_CD = NVL(@[gso],OFC_CD)" ).append("\n"); 
		query.append("                                           CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD)" ).append("\n"); 
		query.append("        ) J" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${umch_tp_cd} == 'N')" ).append("\n"); 
		query.append("AND  ( BKG_GET_TOKEN_FNC(U1,1) = 'A' OR BKG_GET_TOKEN_FNC(U1,2) = 'A1' OR BKG_GET_TOKEN_FNC(U1,3) = 'A2' OR BKG_GET_TOKEN_FNC(U1,4) = 'B' OR BKG_GET_TOKEN_FNC(U1,5) = 'C' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${umch_tp_cd} == 'R') " ).append("\n"); 
		query.append("AND  ( BKG_GET_TOKEN_FNC(U1,6) = 'D' OR BKG_GET_TOKEN_FNC(U1,7) = 'E' OR BKG_GET_TOKEN_FNC(U1,8) = 'F' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${err_umch_tp_cd} == 'A')" ).append("\n"); 
		query.append("AND	 BKG_GET_TOKEN_FNC(U1,1) = 'A'" ).append("\n"); 
		query.append("#elseif (${err_umch_tp_cd} == 'A1')" ).append("\n"); 
		query.append("AND	 BKG_GET_TOKEN_FNC(U1,2) = 'A1'" ).append("\n"); 
		query.append("#elseif (${err_umch_tp_cd} == 'A2')" ).append("\n"); 
		query.append("AND	 BKG_GET_TOKEN_FNC(U1,3) = 'A2'" ).append("\n"); 
		query.append("#elseif (${err_umch_tp_cd} == 'B')" ).append("\n"); 
		query.append("AND	 BKG_GET_TOKEN_FNC(U1,4) = 'B'" ).append("\n"); 
		query.append("#elseif (${err_umch_tp_cd} == 'C')" ).append("\n"); 
		query.append("AND	 BKG_GET_TOKEN_FNC(U1,5) = 'C'" ).append("\n"); 
		query.append("#elseif (${err_umch_tp_cd} == 'D')" ).append("\n"); 
		query.append("AND	 BKG_GET_TOKEN_FNC(U1,6) = 'D'" ).append("\n"); 
		query.append("#elseif (${err_umch_tp_cd} == 'E')" ).append("\n"); 
		query.append("AND	 BKG_GET_TOKEN_FNC(U1,7) = 'E'" ).append("\n"); 
		query.append("#elseif (${err_umch_tp_cd} == 'F')" ).append("\n"); 
		query.append("AND	 BKG_GET_TOKEN_FNC(U1,8) = 'F'" ).append("\n"); 
		query.append("#elseif (${err_umch_tp_cd} == 'G')" ).append("\n"); 
		query.append("AND	 BKG_GET_TOKEN_FNC(U1,9) = 'G'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND  RCT_RHQ_CD      = NVL(@[rct_rhq_cd], RCT_RHQ_CD)" ).append("\n"); 
		query.append("AND  SC_RFA_NO       LIKE NVL(@[contract_no], SC_RFA_NO) || '%'" ).append("\n"); 
		query.append("AND  RATER_ID        LIKE NVL(@[rater_id], RATER_ID) || '%'" ).append("\n"); 
		query.append("AND  BDR_FLG         = NVL(@[bdr_status_cd], BDR_FLG)" ).append("\n"); 
		query.append("AND  AUTO_RAT_FLG    = NVL(@[auto_rat_flg], AUTO_RAT_FLG)" ).append("\n"); 
		query.append("AND NVL(ERR_CHG1||ERR_CHG2,'N') LIKE '%'|| NVL(@[chg_cd],NVL(ERR_CHG1||ERR_CHG2,'N')) || '%'" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        N1ST_UMCH_FND_DT" ).append("\n"); 
		query.append("      , LST_UMCH_FND_DT" ).append("\n"); 

	}
}