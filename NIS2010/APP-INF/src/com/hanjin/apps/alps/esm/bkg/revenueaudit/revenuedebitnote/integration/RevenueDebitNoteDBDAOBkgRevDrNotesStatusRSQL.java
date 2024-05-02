/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOBkgRevDrNotesStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAOBkgRevDrNotesStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDN STATUS LIST
	  * </pre>
	  */
	public RevenueDebitNoteDBDAOBkgRevDrNotesStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_iss_dt_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("respb_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_aud_tool_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rdn_iss_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rct_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOBkgRevDrNotesStatusRSQL").append("\n"); 
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
		query.append("SELECT  A2.ISS_OFC_CD" ).append("\n"); 
		query.append(",       A2.RCT_RHQ_CD" ).append("\n"); 
		query.append(",       A2.RCT_OFC_CD" ).append("\n"); 
		query.append(",       A2.RGN_OFC_CD" ).append("\n"); 
		query.append(",       A2.RESPB_RHQ_CD" ).append("\n"); 
		query.append(",       A2.RESPB_OFC_CD" ).append("\n"); 
		query.append(",       A2.SVC_SCP_CD" ).append("\n"); 
		query.append(",       A2.BKG_NO" ).append("\n"); 
		query.append(",       A2.BL_NO" ).append("\n"); 
		query.append(",       A2.INV_NO" ).append("\n"); 
		query.append(",       A2.VVD_CD" ).append("\n"); 
		query.append(",       A2.SC_RFA_NO" ).append("\n"); 
		query.append(",       A2.CTRT_PTY_NM" ).append("\n"); 
		query.append(",		A2.C_OFC_REP" ).append("\n"); 
		query.append(",       DECODE(A2.CTRT_TP_CD,'R','RFA','S','S/C','TAA') CTRT_TP_CD" ).append("\n"); 
		query.append(",       A2.RDN_NO" ).append("\n"); 
		query.append(",       A2.RDN_KND_CD" ).append("\n"); 
		query.append(",       A2.RVIS_SEQ" ).append("\n"); 
		query.append(",       A2.RDN_STS_CD" ).append("\n"); 
		query.append(",       A2.RDN_STS_NM" ).append("\n"); 
		query.append(",       A2.UMCH_TP_CD" ).append("\n"); 
		query.append(",       A2.UMCH_SUB_TP_CD" ).append("\n"); 
		query.append(",       A2.RDN_ISS_RSN_CD" ).append("\n"); 
		query.append(",       A2.USD_AMT" ).append("\n"); 
		query.append(",       A2.UMCH_RMK" ).append("\n"); 
		query.append(",       A2.BKG_CORR_NO" ).append("\n"); 
		query.append(",       A2.N3PTY_NO" ).append("\n"); 
		query.append(",       P1.RDN_RMK  OFFICE_RDN_RMK" ).append("\n"); 
		query.append(",       P2.RDN_RMK  RECEIVER_RDN_RMK" ).append("\n"); 
		query.append(",       A2.REV_AUD_TOOL_CD" ).append("\n"); 
		query.append(",       A2.REV_AUD_TOOL_NM" ).append("\n"); 
		query.append(",       A2.ATCH_EXIST" ).append("\n"); 
		query.append(",       TO_CHAR(A2.RDN_ISS_DT, 'YYYY-MM-DD')  RDN_ISS_DT" ).append("\n"); 
		query.append(",       ( SELECT TO_CHAR(MAX(A.CRE_DT),'YYYY-MM-DD') FROM BKG_REV_DR_NOTE_PROG A WHERE A.RDN_NO = A2.RDN_NO AND A.RVIS_SEQ = A2.RVIS_SEQ )  UPD_DT" ).append("\n"); 
		query.append(",       A2.CRE_USR_ID ISS_USR_ID" ).append("\n"); 
		query.append(",       CASE" ).append("\n"); 
		query.append("        WHEN  P1.RDN_STS_CD IN ( 'ST', 'CL', 'CV' ) THEN P1.CRE_USR_ID" ).append("\n"); 
		query.append("        ELSE  NULL" ).append("\n"); 
		query.append("        END STL_USR_ID" ).append("\n"); 
		query.append(",       CASE" ).append("\n"); 
		query.append("        WHEN P1.RDN_STS_CD IN ( 'ST', 'CL' ) THEN TRUNC(P1.CRE_DT) - TRUNC(A2.RDN_ISS_DT)" ).append("\n"); 
		query.append("        WHEN P1.RDN_STS_CD IN ( 'CR', 'CV' ) THEN TRUNC(A2.CR_CRE_DT) - TRUNC(A2.RDN_ISS_DT)" ).append("\n"); 
		query.append("        ELSE TRUNC(SYSDATE) - TRUNC(A2.RDN_ISS_DT)" ).append("\n"); 
		query.append("        END STL_PRD_DYS " ).append("\n"); 
		query.append(",       P2.CRE_USR_ID AS RECEIVER_USR_ID                                     --RDN_ISS_DT가 AC,RR,CR 인 경우의 유저 아이디" ).append("\n"); 
		query.append(",       ''  RDN_ISS_DT_FROM" ).append("\n"); 
		query.append(",       ''  RDN_ISS_DT_TO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  DN.ISS_OFC_CD                                                         --이슈오피스 코드" ).append("\n"); 
		query.append("        ,       DN.RCT_RHQ_CD                                                         --오피스 대분류" ).append("\n"); 
		query.append("        ,       DN.RCT_OFC_CD                                                         --오피스 소분류" ).append("\n"); 
		query.append("        ,       BK.SVC_SCP_CD                                                         --Scope" ).append("\n"); 
		query.append("        ,       DN.BKG_NO" ).append("\n"); 
		query.append("        ,       BK.BL_NO                                                              --BL NO" ).append("\n"); 
		query.append("        ,       DN.INV_NO" ).append("\n"); 
		query.append("        ,       DN.VVD_CD" ).append("\n"); 
		query.append("        ,       DECODE(BR.BKG_CTRT_TP_CD, 'S', BK.SC_NO, 'R', BK.RFA_NO, 'T', BK.TAA_NO)  SC_RFA_NO" ).append("\n"); 
		query.append("		,		BK.CTRT_OFC_CD || '/' || BK.CTRT_SREP_CD C_OFC_REP					  -- C.OFC/REP" ).append("\n"); 
		query.append("        ,       BR.BKG_CTRT_TP_CD CTRT_TP_CD                                          -- 계약 TYPE" ).append("\n"); 
		query.append("        ,       DN.RDN_NO" ).append("\n"); 
		query.append("        ,       DN.RVIS_SEQ" ).append("\n"); 
		query.append("        ,       DN.RDN_STS_CD                                                         --상태코드" ).append("\n"); 
		query.append("        ,       ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03402' AND   INTG_CD_VAL_CTNT = DN.RDN_KND_CD)        RDN_KND_CD" ).append("\n"); 
		query.append("        ,       ( SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01568' AND INTG_CD_VAL_CTNT = DN.RDN_STS_CD )            RDN_STS_NM" ).append("\n"); 
		query.append("        ,       ( SELECT UMCH_TP_DESC FROM BKG_REV_UMCH_TP WHERE UMCH_TP_CD = DN.UMCH_TP_CD )                                                 UMCH_TP_CD" ).append("\n"); 
		query.append("        ,       ( SELECT UMCH_SUB_TP_DESC FROM BKG_REV_UMCH_SUB_TP WHERE UMCH_TP_CD = DN.UMCH_TP_CD AND UMCH_SUB_TP_CD = DN.UMCH_SUB_TP_CD )  UMCH_SUB_TP_CD" ).append("\n"); 
		query.append("        ,       ( SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01567' AND INTG_CD_VAL_CTNT = DN.RDN_ISS_RSN_CD )        RDN_ISS_RSN_CD" ).append("\n"); 
		query.append("        ,       ( SELECT DECODE(COUNT(FILE_SAV_ID),0,'','O') FROM BKG_ATCH_FILE WHERE ATCH_FILE_LNK_ID = DN.ATCH_FILE_LNK_ID )               ATCH_EXIST" ).append("\n"); 
		query.append("        ,       DN.UMCH_RMK                                                           --Details" ).append("\n"); 
		query.append("        ,       DN.BKG_CORR_NO                                                        --CA NO" ).append("\n"); 
		query.append("        ,       DN.N3PTY_NO                                                           --TPB NO" ).append("\n"); 
		query.append("        ,       DN.RDN_ISS_DT                                                         --ISSUE DATE" ).append("\n"); 
		query.append("        ,       DN.RESPB_RHQ_CD" ).append("\n"); 
		query.append("        ,       DN.RESPB_OFC_CD" ).append("\n"); 
		query.append("        ,       DN.REV_AUD_TOOL_CD" ).append("\n"); 
		query.append("        ,       DN.CRE_USR_ID                                                         --처음 생성한 유저 아이디" ).append("\n"); 
		query.append("        ,       ( SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02371' AND INTG_CD_VAL_CTNT = DN.REV_AUD_TOOL_CD )       REV_AUD_TOOL_NM" ).append("\n"); 
		query.append("        ,       (" ).append("\n"); 
		query.append("                SELECT  SUM(ROUND(DA.DR_AMT / XR.USD_LOCL_XCH_RT, 2))" ).append("\n"); 
		query.append("                FROM    BKG_REV_DR_AMT  DA  ," ).append("\n"); 
		query.append("                        GL_MON_XCH_RT   XR" ).append("\n"); 
		query.append("                WHERE   XR.ACCT_XCH_RT_YRMON  = TO_CHAR(DN.RDN_ISS_DT, 'YYYYMM')" ).append("\n"); 
		query.append("                AND     XR.ACCT_XCH_RT_LVL    = '1'" ).append("\n"); 
		query.append("                AND     XR.CURR_CD            = DA.CURR_CD" ).append("\n"); 
		query.append("                AND     DA.RDN_NO             = DN.RDN_NO" ).append("\n"); 
		query.append("                AND     DA.RVIS_SEQ           = DN.RVIS_SEQ" ).append("\n"); 
		query.append("                )   USD_AMT" ).append("\n"); 
		query.append("        ,       DECODE(DN.RCT_OFC_CD,'PKGSA',RGN.INTG_CD_VAL_DP_DESC,'') AS RGN_OFC_CD" ).append("\n"); 
		query.append("        ,       CASE WHEN BR.BKG_CTRT_TP_CD = 'S' " ).append("\n"); 
		query.append("                         THEN (SELECT CTRT_PTY_NM" ).append("\n"); 
		query.append("                               FROM PRI_SP_CTRT_PTY SC, PRI_SP_MN SM, PRI_SP_HDR SH" ).append("\n"); 
		query.append("                               WHERE SH.SC_NO = BK.SC_NO" ).append("\n"); 
		query.append("                               AND SH.PROP_NO = SM.PROP_NO" ).append("\n"); 
		query.append("                               AND BR.RT_APLY_DT BETWEEN SM.EFF_DT AND SM.EXP_DT" ).append("\n"); 
		query.append("                               AND SC.PROP_NO = SM.PROP_NO" ).append("\n"); 
		query.append("                               AND SC.AMDT_SEQ = SM.AMDT_SEQ" ).append("\n"); 
		query.append("                               AND SC.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("                               AND ROWNUM = 1)" ).append("\n"); 
		query.append("                     WHEN BR.BKG_CTRT_TP_CD = 'R' " ).append("\n"); 
		query.append("                         THEN (SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                               FROM MDM_CUSTOMER MC, PRI_RP_HDR RH, PRI_RP_MN RM" ).append("\n"); 
		query.append("                               WHERE RH.RFA_NO = BK.RFA_NO" ).append("\n"); 
		query.append("                               AND RH.PROP_NO = RM.PROP_NO" ).append("\n"); 
		query.append("                               AND BR.RT_APLY_DT BETWEEN RM.EFF_DT AND RM.EXP_DT" ).append("\n"); 
		query.append("                               AND RM.CTRT_CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                               AND RM.CTRT_CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("                               AND ROWNUM = 1)" ).append("\n"); 
		query.append("                     ELSE (SELECT MC.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                               FROM MDM_CUSTOMER MC, PRI_TAA_HDR TH, PRI_TAA_MN TM" ).append("\n"); 
		query.append("                               WHERE TH.TAA_NO = BK.TAA_NO" ).append("\n"); 
		query.append("                               AND TH.TAA_PROP_NO = TM.TAA_PROP_NO" ).append("\n"); 
		query.append("                               AND BR.RT_APLY_DT BETWEEN TM.EFF_DT AND TM.EXP_DT" ).append("\n"); 
		query.append("                               AND TM.CTRT_CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                               AND TM.CTRT_CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("                               AND ROWNUM = 1)" ).append("\n"); 
		query.append("                     END CTRT_PTY_NM" ).append("\n"); 
		query.append("         ,      (SELECT MAX(CRE_DT) " ).append("\n"); 
		query.append("                   FROM BKG_REV_DR_NOTE_PROG " ).append("\n"); 
		query.append("                  WHERE DN.RDN_NO = RDN_NO " ).append("\n"); 
		query.append("                    AND DN.RVIS_SEQ = RVIS_SEQ " ).append("\n"); 
		query.append("                    AND RDN_STS_CD = 'CR') CR_CRE_DT         " ).append("\n"); 
		query.append("        FROM    BKG_REV_DR_NOTE DN  ," ).append("\n"); 
		query.append("                BKG_BOOKING     BK  ," ).append("\n"); 
		query.append("                BKG_RATE        BR  ," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT DISTINCT STP.BKG_OFC_CD" ).append("\n"); 
		query.append("                      ,COM.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                  FROM BKG_EML_ACCT_STUP STP" ).append("\n"); 
		query.append("                      ,COM_INTG_CD_DTL COM" ).append("\n"); 
		query.append("                 WHERE COM.INTG_CD_VAL_CTNT = STP.RGN_OFC_CD" ).append("\n"); 
		query.append("                   AND COM.INTG_CD_ID = 'CD02405'" ).append("\n"); 
		query.append("                   AND STP.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                )  RGN" ).append("\n"); 
		query.append("        WHERE   BK.BKG_NO(+) = DN.BKG_NO" ).append("\n"); 
		query.append("        AND     BR.BKG_NO(+) = BK.BKG_NO" ).append("\n"); 
		query.append("        AND     BK.BKG_OFC_CD = RGN.BKG_OFC_CD(+)" ).append("\n"); 
		query.append("        AND     ( DN.RDN_NO, DN.RVIS_SEQ )  IN  (" ).append("\n"); 
		query.append("                                                SELECT  RDN_NO        ," ).append("\n"); 
		query.append("                                                        MAX(RVIS_SEQ)" ).append("\n"); 
		query.append("                                                FROM    BKG_REV_DR_NOTE" ).append("\n"); 
		query.append("                                                GROUP BY" ).append("\n"); 
		query.append("                                                        RDN_NO" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND     DN.RCT_RHQ_CD   = NVL(@[rct_rhq_cd], DN.RCT_RHQ_CD)" ).append("\n"); 
		query.append("        AND     DN.RCT_OFC_CD   = NVL(@[rct_ofc_cd], DN.RCT_OFC_CD)" ).append("\n"); 
		query.append("        AND     DN.RESPB_RHQ_CD = NVL(@[respb_rhq_cd], DN.RESPB_RHQ_CD)" ).append("\n"); 
		query.append("        AND     DN.RESPB_OFC_CD = NVL(@[respb_ofc_cd], DN.RESPB_OFC_CD)       " ).append("\n"); 
		query.append("        AND     DN.RCT_OFC_CD IN (SELECT  OFC_CD" ).append("\n"); 
		query.append("                                    FROM    MDM_ORGANIZATION " ).append("\n"); 
		query.append("                                    WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                    START WITH OFC_CD = NVL(@[gso],OFC_CD)" ).append("\n"); 
		query.append("                                    CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD)" ).append("\n"); 
		query.append("        AND     DN.RDN_ISS_DT   >= NVL(TO_DATE(@[rdn_iss_dt_from], 'YYYY/MM/DD'), DN.RDN_ISS_DT)" ).append("\n"); 
		query.append("        AND     DN.RDN_ISS_DT   <= NVL(TO_DATE(@[rdn_iss_dt_to], 'YYYY/MM/DD') + 0.99999, DN.RDN_ISS_DT)" ).append("\n"); 
		query.append("        AND     DN.ISS_OFC_CD   = NVL(@[iss_ofc_cd], DN.ISS_OFC_CD)" ).append("\n"); 
		query.append("        AND     DN.RDN_NO       LIKE NVL(@[rdn_no], DN.RDN_NO) || '%'" ).append("\n"); 
		query.append("        AND     DN.REV_AUD_TOOL_CD  = NVL(@[rev_aud_tool_cd], DN.REV_AUD_TOOL_CD)" ).append("\n"); 
		query.append("#if ('All'!=${rdn_knd_cd} && ''!=${rdn_knd_cd})" ).append("\n"); 
		query.append("        AND     DN.RDN_KND_CD  IN( ${rdn_knd_cd} )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("        AND     BK.BL_NO        LIKE NVL(@[bl_no], BK.BL_NO) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} != '')" ).append("\n"); 
		query.append("        AND     BR.BKG_CTRT_TP_CD     = NVL(@[bkg_ctrt_tp_cd], BR.BKG_CTRT_TP_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ctrt_tp_cd} == 'S' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("        AND     BK.SC_NO          = @[ctrt_no]" ).append("\n"); 
		query.append("#elseif (${bkg_ctrt_tp_cd} == 'R' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("        AND     BK.RFA_NO         = @[ctrt_no]" ).append("\n"); 
		query.append("#elseif (${bkg_ctrt_tp_cd} == 'T' && ${ctrt_no} != '')" ).append("\n"); 
		query.append("        AND     BK.TAA_NO         = @[ctrt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("        AND     DN.INV_NO  = NVL(@[inv_no], DN.INV_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("        AND     DN.VVD_CD  = NVL(@[vvd_cd], DN.VVD_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        #if (${rdn_sts_cd} != '')" ).append("\n"); 
		query.append("        AND   DN.RDN_STS_CD     IN ( ${rdn_sts_cd} )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append(" 		#if ('All'!=${umch_tp_cd} && ''!=${umch_tp_cd})" ).append("\n"); 
		query.append("           AND DN.UMCH_TP_CD IN (${umch_tp_cd})" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        ) A2  ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  DP.RDN_NO" ).append("\n"); 
		query.append("        ,       DP.RVIS_SEQ" ).append("\n"); 
		query.append("        ,       DP.PROG_SEQ" ).append("\n"); 
		query.append("        ,       DP.RDN_STS_CD" ).append("\n"); 
		query.append("        ,       DP.RDN_RMK" ).append("\n"); 
		query.append("        ,       DP.CRE_USR_ID" ).append("\n"); 
		query.append("        ,       DP.CRE_DT" ).append("\n"); 
		query.append("        ,       ROW_NUMBER() OVER ( PARTITION BY DP.RDN_NO ORDER BY DP.RVIS_SEQ DESC, DP.PROG_SEQ DESC )  ROW_NUMBER" ).append("\n"); 
		query.append("        FROM    BKG_REV_DR_NOTE_PROG  DP" ).append("\n"); 
		query.append("        WHERE     DP.RDN_STS_CD IN ( 'IS', 'RV', 'ST', 'CL', 'CV', 'CR' )" ).append("\n"); 
		query.append("        ) P1  ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  DP.RDN_NO" ).append("\n"); 
		query.append("        ,       DP.RVIS_SEQ" ).append("\n"); 
		query.append("        ,       DP.PROG_SEQ" ).append("\n"); 
		query.append("        ,       DP.RDN_STS_CD" ).append("\n"); 
		query.append("        ,       DP.RDN_RMK" ).append("\n"); 
		query.append("        ,       DP.CRE_USR_ID" ).append("\n"); 
		query.append("        ,       ROW_NUMBER() OVER ( PARTITION BY DP.RDN_NO ORDER BY DP.RVIS_SEQ DESC, DP.PROG_SEQ DESC )  ROW_NUMBER" ).append("\n"); 
		query.append("        FROM    BKG_REV_DR_NOTE_PROG  DP" ).append("\n"); 
		query.append("        WHERE     DP.RDN_STS_CD IN ( 'AC', 'RR', 'CR' )" ).append("\n"); 
		query.append("        ) P2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   P1.RDN_NO(+)      = A2.RDN_NO" ).append("\n"); 
		query.append("AND     P1.ROW_NUMBER(+)  = 1" ).append("\n"); 
		query.append("AND     P2.RDN_NO(+)      = A2.RDN_NO" ).append("\n"); 
		query.append("AND     P2.ROW_NUMBER(+)  = 1" ).append("\n"); 
		query.append("--AND     A2.USD_AMT IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        A2.RDN_NO   DESC" ).append("\n"); 

	}
}