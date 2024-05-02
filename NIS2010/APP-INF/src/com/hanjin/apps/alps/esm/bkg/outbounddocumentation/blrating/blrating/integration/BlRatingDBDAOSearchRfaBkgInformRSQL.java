/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOSearchRfaBkgInformRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchRfaBkgInformRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG 데이터  조회
	  * </pre>
	  */
	public BlRatingDBDAOSearchRfaBkgInformRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchRfaBkgInformRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("	,BKG_CGO_TP_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(NVL(((SELECT MAX(CGO_RCV_DT) FROM BKG_CNTR_HIS WHERE BKG_NO = MAI.BKG_NO AND CORR_NO ='TMP0000001')),(SELECT RT_APLY_DT FROM BKG_RT_HIS WHERE BKG_NO=MAI.BKG_NO AND CORR_NO ='TMP0000001')),'YYYY-MM-DD') CNTR_CDR_DT" ).append("\n"); 
		query.append("	,CMDT_CD" ).append("\n"); 
		query.append("	,(SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = MAI.CMDT_CD )CMDT_NM" ).append("\n"); 
		query.append("	,(SELECT REP_CMDT_NM FROM MDM_REP_CMDT K WHERE K.REP_CMDT_CD = MAI.REP_CMDT_CD) REP_CMDT_NM" ).append("\n"); 
		query.append("	,REP_CMDT_CD" ).append("\n"); 
		query.append("	,ACT_WGT" ).append("\n"); 
		query.append("    ,WGT_UT_CD" ).append("\n"); 
		query.append("	,MEAS_QTY" ).append("\n"); 
		query.append("	,MEAS_UT_CD" ).append("\n"); 
		query.append("	,BKG_POR_CD" ).append("\n"); 
		query.append("	,BKG_POL_CD" ).append("\n"); 
		query.append("	,BKG_POD_CD" ).append("\n"); 
		query.append("	,DEL_CD" ).append("\n"); 
		query.append("	,VV_POL_CD" ).append("\n"); 
		query.append("	,VV_POD_CD" ).append("\n"); 
		query.append("	,RCV_TERM_CD" ).append("\n"); 
		query.append("	,DE_TERM_CD" ).append("\n"); 
		query.append("	,SPECIAL" ).append("\n"); 
		query.append("	,SVC_SCP_CD" ).append("\n"); 
		query.append("    ,BDR_CNG_FLG" ).append("\n"); 
		query.append("	,(SELECT FRT_TERM_CD FROM BKG_RT_HIS WHERE BKG_NO=MAI.BKG_NO AND CORR_NO ='TMP0000001') FRT_TERM_CD" ).append("\n"); 
		query.append("	,RFA_NO AS FRFA_NO" ).append("\n"); 
		query.append("    ,SLAN_CD" ).append("\n"); 
		query.append("    ,SREP_EML" ).append("\n"); 
		query.append("    ,DECODE(SREP_CD, MAI.OB_SREP_CD, '', (SELECT SREP_EML FROM MDM_SLS_REP WHERE SREP_CD = MAI.OB_SREP_CD)) OB_SREP_EML" ).append("\n"); 
		query.append("    ,(SELECT /*+ INDEX_DESC(P XPKPRI_SP_PROG)*/ USR_EML" ).append("\n"); 
		query.append("      FROM PRI_RP_PROG P, COM_USER U" ).append("\n"); 
		query.append("      WHERE (P.PROP_NO, P.AMDT_SEQ) IN (SELECT MN.PROP_NO" ).append("\n"); 
		query.append("                                             , MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("                                        FROM PRI_RP_MN MN, PRI_RP_HDR HDR" ).append("\n"); 
		query.append("                                        WHERE HDR.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("                                        AND   MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("										AND   MN.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("                                        GROUP BY MN.PROP_NO)" ).append("\n"); 
		query.append("        AND P.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("        AND P.PROG_USR_ID = U.USR_ID  " ).append("\n"); 
		query.append("        AND ROWNUM = 1  ) USR_EML " ).append("\n"); 
		query.append("     ,CASE WHEN BKG_POR_CD = DEL_CD AND SVC_SCP_CD IS NULL " ).append("\n"); 
		query.append("			THEN" ).append("\n"); 
		query.append("			( SELECT " ).append("\n"); 
		query.append("			      SUBSTR (MAX (SYS_CONNECT_BY_PATH (SVC_SCP_CD, '$')), 2)   AS SVC_SCP_CD" ).append("\n"); 
		query.append("			  FROM  (" ).append("\n"); 
		query.append("					  SELECT " ).append("\n"); 
		query.append("					  	ROWNUM AS RID, T.* " ).append("\n"); 
		query.append("					  FROM (" ).append("\n"); 
		query.append("				            SELECT A.SVC_SCP_CD||'-'||A.SVC_SCP_NM  AS SVC_SCP_CD " ).append("\n"); 
		query.append("							FROM MDM_SVC_SCP  A WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("				           ) T" ).append("\n"); 
		query.append("					)   " ).append("\n"); 
		query.append("				START WITH  RID =  1" ).append("\n"); 
		query.append("				CONNECT BY PRIOR RID + 1 = RID   " ).append("\n"); 
		query.append("			 )" ).append("\n"); 
		query.append("	 ELSE " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("        SUBSTR (MAX (SYS_CONNECT_BY_PATH (SVC_SCP_CD, '$')), 2)   AS SVC_SCP_CD" ).append("\n"); 
		query.append("	FROM    (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			ROWNUM AS RID, T.* " ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("         SELECT DISTINCT SVC_SCP_CD FROM (SELECT A.SVC_SCP_CD ||'-'||C.SVC_SCP_NM AS SVC_SCP_CD" ).append("\n"); 
		query.append("				,'A' A" ).append("\n"); 
		query.append("		 FROM BKG_BOOKING A,MDM_SVC_SCP C " ).append("\n"); 
		query.append("		 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		 AND A.svc_scp_cd = C.svc_scp_cd" ).append("\n"); 
		query.append("		 UNION" ).append("\n"); 
		query.append("		 SELECT a.svc_scp_cd ||'-'||c.svc_scp_nm as SVC_SCP_CD" ).append("\n"); 
		query.append("				,'B' B" ).append("\n"); 
		query.append("		 FROM mdm_svc_scp_lmt a" ).append("\n"); 
		query.append("			 ,mdm_svc_scp_lmt b" ).append("\n"); 
		query.append("			 ,mdm_svc_scp c" ).append("\n"); 
		query.append("		 WHERE a.svc_scp_cd = b.svc_scp_cd" ).append("\n"); 
		query.append("		 AND a.svc_scp_cd = c.svc_scp_cd" ).append("\n"); 
		query.append("		 AND c.delt_flg = 'N'" ).append("\n"); 
		query.append("		 AND a.org_dest_cd = 'O'" ).append("\n"); 
		query.append("		 AND a.delt_flg = 'N'" ).append("\n"); 
		query.append("		 AND a.svc_scp_ind_flg ='Y'" ).append("\n"); 
		query.append("		 AND a.rgn_cd IN (SELECT rgn_cd" ).append("\n"); 
		query.append("		 FROM mdm_location" ).append("\n"); 
		query.append("		 WHERE loc_cd = (select POR_CD from BKG_BOOKING where BKG_NO = @[bkg_no]))  -- BKG POR_CD" ).append("\n"); 
		query.append("		 AND b.org_dest_cd = 'D'" ).append("\n"); 
		query.append("		 AND b.delt_flg = 'N'" ).append("\n"); 
		query.append("	     AND b.svc_scp_ind_flg ='Y'" ).append("\n"); 
		query.append("		 AND b.rgn_cd IN (SELECT rgn_cd" ).append("\n"); 
		query.append("		 FROM mdm_location" ).append("\n"); 
		query.append("		 WHERE loc_cd = (select DEL_CD from BKG_BOOKING where BKG_NO =@[bkg_no]) ) -- BKG DEL_CD" ).append("\n"); 
		query.append("		 ORDER BY A)            " ).append("\n"); 
		query.append("		) T" ).append("\n"); 
		query.append("	)   " ).append("\n"); 
		query.append("	START WITH  RID =  1" ).append("\n"); 
		query.append("	CONNECT BY PRIOR RID + 1 = RID   " ).append("\n"); 
		query.append("    ) END SCP_CD  " ).append("\n"); 
		query.append("    ,BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_TP_FNC(BKG_NO, 'Y') APLY_TP" ).append("\n"); 
		query.append("    ,TO_CHAR(BKG_REV_APLY_DT_PKG.BKG_GET_CGO_RCV_DT_FNC(BKG_NO, 'Y'),'YYYYMMDD') CGO_RCV_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(BKG_REV_APLY_DT_PKG.BKG_GET_ETD_DT_FNC(BKG_NO, 'Y'),'YYYYMMDD') ETD_DT    " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		BKG.BKG_NO" ).append("\n"); 
		query.append("		,BKG_CGO_TP_CD" ).append("\n"); 
		query.append("        ,BKG.OB_SREP_CD " ).append("\n"); 
		query.append("		,CMDT_CD" ).append("\n"); 
		query.append("		,REP_CMDT_CD" ).append("\n"); 
		query.append("		,ACT_WGT" ).append("\n"); 
		query.append("        ,WGT_UT_CD" ).append("\n"); 
		query.append("		,MEAS_QTY" ).append("\n"); 
		query.append("		,MEAS_UT_CD" ).append("\n"); 
		query.append("		,BKG.POR_CD BKG_POR_CD" ).append("\n"); 
		query.append("		,BKG.POL_CD BKG_POL_CD" ).append("\n"); 
		query.append("		,BKG.POD_CD BKG_POD_CD" ).append("\n"); 
		query.append("		,BKG.DEL_CD" ).append("\n"); 
		query.append("		,RCV_TERM_CD" ).append("\n"); 
		query.append("		,DE_TERM_CD" ).append("\n"); 
		query.append("		,SVC_SCP_CD" ).append("\n"); 
		query.append("      	,BDR_CNG_FLG" ).append("\n"); 
		query.append("		,RFA_NO" ).append("\n"); 
		query.append("		, CASE " ).append("\n"); 
		query.append("			WHEN DCGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("			WHEN RC_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("			WHEN AWK_CGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("			WHEN BB_CGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("			ELSE 'N'" ).append("\n"); 
		query.append("		END SPECIAL " ).append("\n"); 
		query.append("		,BKG.PRE_RLY_PORT_CD VV_POL_CD" ).append("\n"); 
		query.append("		,BKG.PST_RLY_PORT_CD VV_POD_CD   " ).append("\n"); 
		query.append("        ,BKG.SLAN_CD" ).append("\n"); 
		query.append("        ,(SELECT S.SREP_EML" ).append("\n"); 
		query.append("            FROM PRI_RP_MN P, MDM_SLS_REP S" ).append("\n"); 
		query.append("           WHERE (P.PROP_NO, P.AMDT_SEQ) IN (SELECT MN.PROP_NO" ).append("\n"); 
		query.append("                                                  , MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("                                               FROM PRI_RP_MN MN, PRI_RP_HDR HDR" ).append("\n"); 
		query.append("                                              WHERE HDR.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("                                                AND   MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("                                                AND   MN.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("                                              GROUP BY MN.PROP_NO)" ).append("\n"); 
		query.append("             AND S.SREP_CD = P.PROP_SREP_CD ) SREP_EML" ).append("\n"); 
		query.append("        ,(SELECT S.SREP_CD" ).append("\n"); 
		query.append("            FROM PRI_RP_MN P, MDM_SLS_REP S" ).append("\n"); 
		query.append("           WHERE (P.PROP_NO, P.AMDT_SEQ) IN (SELECT MN.PROP_NO" ).append("\n"); 
		query.append("                                                  , MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("                                               FROM PRI_RP_MN MN, PRI_RP_HDR HDR" ).append("\n"); 
		query.append("                                              WHERE HDR.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("                                                AND   MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("                                                AND   MN.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("                                              GROUP BY MN.PROP_NO)" ).append("\n"); 
		query.append("             AND S.SREP_CD = P.PROP_SREP_CD ) SREP_CD" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("		BKG_BKG_HIS BKG, BKG_BL_DOC_HIS BL " ).append("\n"); 
		query.append("	WHERE " ).append("\n"); 
		query.append("		BKG.BKG_NO = BL.BKG_NO " ).append("\n"); 
		query.append("		AND BKG.CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("		AND BL.CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("		AND BKG.BKG_NO= @[bkg_no] " ).append("\n"); 
		query.append(") MAI" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append("	,BKG_CGO_TP_CD" ).append("\n"); 
		query.append("    ,TO_CHAR(NVL(((SELECT MAX(CGO_RCV_DT) FROM BKG_CONTAINER WHERE BKG_NO = MAI.BKG_NO)),(SELECT RT_APLY_DT FROM BKG_RATE WHERE BKG_NO=MAI.BKG_NO)),'YYYY-MM-DD') CNTR_CDR_DT" ).append("\n"); 
		query.append("	,CMDT_CD" ).append("\n"); 
		query.append("	,(SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = MAI.CMDT_CD )CMDT_NM" ).append("\n"); 
		query.append("	,(SELECT REP_CMDT_NM FROM MDM_REP_CMDT K WHERE K.REP_CMDT_CD = MAI.REP_CMDT_CD) REP_CMDT_NM" ).append("\n"); 
		query.append("	,REP_CMDT_CD" ).append("\n"); 
		query.append("	,ACT_WGT" ).append("\n"); 
		query.append("    ,WGT_UT_CD" ).append("\n"); 
		query.append("	,MEAS_QTY" ).append("\n"); 
		query.append("	,MEAS_UT_CD" ).append("\n"); 
		query.append("	,BKG_POR_CD" ).append("\n"); 
		query.append("	,BKG_POL_CD" ).append("\n"); 
		query.append("	,BKG_POD_CD" ).append("\n"); 
		query.append("	,DEL_CD" ).append("\n"); 
		query.append("	,VV_POL_CD" ).append("\n"); 
		query.append("	,VV_POD_CD" ).append("\n"); 
		query.append("	,RCV_TERM_CD" ).append("\n"); 
		query.append("	,DE_TERM_CD" ).append("\n"); 
		query.append("	,SPECIAL" ).append("\n"); 
		query.append("		,SVC_SCP_CD" ).append("\n"); 
		query.append("      	,BDR_CNG_FLG" ).append("\n"); 
		query.append("	,(SELECT FRT_TERM_CD FROM BKG_RATE WHERE BKG_NO=MAI.BKG_NO) FRT_TERM_CD" ).append("\n"); 
		query.append("	,RFA_NO AS FRFA_NO" ).append("\n"); 
		query.append("    ,SLAN_CD" ).append("\n"); 
		query.append("    ,SREP_EML" ).append("\n"); 
		query.append("    ,DECODE(SREP_CD, MAI.OB_SREP_CD, '', (SELECT SREP_EML FROM MDM_SLS_REP WHERE SREP_CD = MAI.OB_SREP_CD)) OB_SREP_EML" ).append("\n"); 
		query.append("    ,(SELECT /*+ INDEX_DESC(P XPKPRI_SP_PROG)*/ USR_EML" ).append("\n"); 
		query.append("      FROM PRI_RP_PROG P, COM_USER U" ).append("\n"); 
		query.append("      WHERE (P.PROP_NO, P.AMDT_SEQ) IN (SELECT MN.PROP_NO" ).append("\n"); 
		query.append("                                             , MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("                                        FROM PRI_RP_MN MN, PRI_RP_HDR HDR" ).append("\n"); 
		query.append("                                        WHERE HDR.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("                                        AND   MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("										AND   MN.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("                                        GROUP BY MN.PROP_NO)" ).append("\n"); 
		query.append("        AND P.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("        AND P.PROG_USR_ID = U.USR_ID  " ).append("\n"); 
		query.append("        AND ROWNUM = 1  ) USR_EML " ).append("\n"); 
		query.append("     ,CASE WHEN BKG_POR_CD = DEL_CD AND SVC_SCP_CD IS NULL " ).append("\n"); 
		query.append("			THEN" ).append("\n"); 
		query.append("			( SELECT " ).append("\n"); 
		query.append("			      SUBSTR (MAX (SYS_CONNECT_BY_PATH (SVC_SCP_CD, '$')), 2)   AS SVC_SCP_CD" ).append("\n"); 
		query.append("			  FROM  (" ).append("\n"); 
		query.append("					  SELECT " ).append("\n"); 
		query.append("					  	ROWNUM AS RID, T.* " ).append("\n"); 
		query.append("					  FROM (" ).append("\n"); 
		query.append("				            SELECT A.SVC_SCP_CD||'-'||A.SVC_SCP_NM  AS SVC_SCP_CD " ).append("\n"); 
		query.append("							FROM MDM_SVC_SCP  A WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("				           ) T" ).append("\n"); 
		query.append("					)   " ).append("\n"); 
		query.append("				START WITH  RID =  1" ).append("\n"); 
		query.append("				CONNECT BY PRIOR RID + 1 = RID   " ).append("\n"); 
		query.append("			 )" ).append("\n"); 
		query.append("	 ELSE " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("        SUBSTR (MAX (SYS_CONNECT_BY_PATH (SVC_SCP_CD, '$')), 2)   AS SVC_SCP_CD" ).append("\n"); 
		query.append("	FROM    (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			ROWNUM AS RID, T.* " ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("         SELECT DISTINCT SVC_SCP_CD FROM (SELECT A.SVC_SCP_CD ||'-'||C.SVC_SCP_NM AS SVC_SCP_CD" ).append("\n"); 
		query.append("				,'A' A" ).append("\n"); 
		query.append("		 FROM BKG_BOOKING A,MDM_SVC_SCP C " ).append("\n"); 
		query.append("		 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		 AND A.svc_scp_cd = C.svc_scp_cd" ).append("\n"); 
		query.append("		 UNION" ).append("\n"); 
		query.append("		 SELECT a.svc_scp_cd ||'-'||c.svc_scp_nm as SVC_SCP_CD" ).append("\n"); 
		query.append("				,'B' B" ).append("\n"); 
		query.append("		 FROM mdm_svc_scp_lmt a" ).append("\n"); 
		query.append("			 ,mdm_svc_scp_lmt b" ).append("\n"); 
		query.append("			 ,mdm_svc_scp c" ).append("\n"); 
		query.append("		 WHERE a.svc_scp_cd = b.svc_scp_cd" ).append("\n"); 
		query.append("		 AND a.svc_scp_cd = c.svc_scp_cd" ).append("\n"); 
		query.append("		 AND c.delt_flg = 'N'" ).append("\n"); 
		query.append("		 AND a.org_dest_cd = 'O'" ).append("\n"); 
		query.append("		 AND a.delt_flg = 'N'" ).append("\n"); 
		query.append("		 AND a.svc_scp_ind_flg ='Y'" ).append("\n"); 
		query.append("		 AND a.rgn_cd IN (SELECT rgn_cd" ).append("\n"); 
		query.append("		 FROM mdm_location" ).append("\n"); 
		query.append("		 WHERE loc_cd = (select POR_CD from BKG_BOOKING where BKG_NO = @[bkg_no]))  -- BKG POR_CD" ).append("\n"); 
		query.append("		 AND b.org_dest_cd = 'D'" ).append("\n"); 
		query.append("		 AND b.delt_flg = 'N'" ).append("\n"); 
		query.append("	     AND b.svc_scp_ind_flg ='Y'" ).append("\n"); 
		query.append("		 AND b.rgn_cd IN (SELECT rgn_cd" ).append("\n"); 
		query.append("		 FROM mdm_location" ).append("\n"); 
		query.append("		 WHERE loc_cd = (select DEL_CD from BKG_BOOKING where BKG_NO =@[bkg_no]) ) -- BKG DEL_CD" ).append("\n"); 
		query.append("		 ORDER BY A)            " ).append("\n"); 
		query.append("		) T" ).append("\n"); 
		query.append("	)   " ).append("\n"); 
		query.append("	START WITH  RID =  1" ).append("\n"); 
		query.append("	CONNECT BY PRIOR RID + 1 = RID   " ).append("\n"); 
		query.append("    ) END SCP_CD " ).append("\n"); 
		query.append("    ,BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_TP_FNC(BKG_NO, 'N') APLY_TP" ).append("\n"); 
		query.append("    ,TO_CHAR(BKG_REV_APLY_DT_PKG.BKG_GET_CGO_RCV_DT_FNC(BKG_NO, 'N'),'YYYYMMDD') CGO_RCV_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(BKG_REV_APLY_DT_PKG.BKG_GET_ETD_DT_FNC(BKG_NO, 'N'),'YYYYMMDD') ETD_DT     " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		BKG.BKG_NO" ).append("\n"); 
		query.append("		,BKG_CGO_TP_CD" ).append("\n"); 
		query.append("        ,BKG.OB_SREP_CD " ).append("\n"); 
		query.append("		,CMDT_CD" ).append("\n"); 
		query.append("		,REP_CMDT_CD" ).append("\n"); 
		query.append("		,ACT_WGT" ).append("\n"); 
		query.append("        ,WGT_UT_CD" ).append("\n"); 
		query.append("		,MEAS_QTY" ).append("\n"); 
		query.append("		,MEAS_UT_CD" ).append("\n"); 
		query.append("		,BKG.POR_CD BKG_POR_CD" ).append("\n"); 
		query.append("		,BKG.POL_CD BKG_POL_CD" ).append("\n"); 
		query.append("		,BKG.POD_CD BKG_POD_CD" ).append("\n"); 
		query.append("		,BKG.DEL_CD" ).append("\n"); 
		query.append("		,RCV_TERM_CD" ).append("\n"); 
		query.append("		,DE_TERM_CD" ).append("\n"); 
		query.append("		,SVC_SCP_CD" ).append("\n"); 
		query.append("      	,BDR_CNG_FLG" ).append("\n"); 
		query.append("		,RFA_NO" ).append("\n"); 
		query.append("		, CASE " ).append("\n"); 
		query.append("			WHEN DCGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("			WHEN RC_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("			WHEN AWK_CGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("			WHEN BB_CGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("			ELSE 'N'" ).append("\n"); 
		query.append("		END SPECIAL  " ).append("\n"); 
		query.append("		,BKG.PRE_RLY_PORT_CD VV_POL_CD" ).append("\n"); 
		query.append("		,BKG.PST_RLY_PORT_CD VV_POD_CD  " ).append("\n"); 
		query.append("        ,BKG.SLAN_CD" ).append("\n"); 
		query.append("        ,(SELECT S.SREP_EML" ).append("\n"); 
		query.append("            FROM PRI_RP_MN P, MDM_SLS_REP S" ).append("\n"); 
		query.append("           WHERE (P.PROP_NO, P.AMDT_SEQ) IN (SELECT MN.PROP_NO" ).append("\n"); 
		query.append("                                                  , MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("                                               FROM PRI_RP_MN MN, PRI_RP_HDR HDR" ).append("\n"); 
		query.append("                                              WHERE HDR.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("                                                AND   MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("                                                AND   MN.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("                                              GROUP BY MN.PROP_NO)" ).append("\n"); 
		query.append("             AND S.SREP_CD = P.PROP_SREP_CD ) SREP_EML" ).append("\n"); 
		query.append("        ,(SELECT S.SREP_CD" ).append("\n"); 
		query.append("            FROM PRI_RP_MN P, MDM_SLS_REP S" ).append("\n"); 
		query.append("           WHERE (P.PROP_NO, P.AMDT_SEQ) IN (SELECT MN.PROP_NO" ).append("\n"); 
		query.append("                                                  , MAX(MN.AMDT_SEQ) AMDT_SEQ" ).append("\n"); 
		query.append("                                               FROM PRI_RP_MN MN, PRI_RP_HDR HDR" ).append("\n"); 
		query.append("                                              WHERE HDR.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("                                                AND   MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("                                                AND   MN.PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("                                              GROUP BY MN.PROP_NO)" ).append("\n"); 
		query.append("             AND S.SREP_CD = P.PROP_SREP_CD ) SREP_CD" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("		BKG_BOOKING BKG, BKG_BL_DOC BL " ).append("\n"); 
		query.append("	WHERE " ).append("\n"); 
		query.append("		BKG.BKG_NO = BL.BKG_NO " ).append("\n"); 
		query.append("		AND BKG.BKG_NO= @[bkg_no] " ).append("\n"); 
		query.append(") MAI" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}