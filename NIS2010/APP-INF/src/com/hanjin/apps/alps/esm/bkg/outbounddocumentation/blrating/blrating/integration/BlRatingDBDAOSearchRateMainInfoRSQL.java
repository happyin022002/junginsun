/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOSearchRateMainInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.29 
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

public class BlRatingDBDAOSearchRateMainInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 운임 메인 데이터를 조회한다.
	  * 2013.01.28 김진주 [CHM-201322629] [오토레이팅 보완] TXS surcharge 로직 추가 (=WSC 동일)
	  * [CHM-201533686] PCT 1일 이후 운임 변경 시 승인 PROCESS 추가 (OFT 변경가능 여부를 체크함.
	  *                            PCT+1일 이후에는 승인을 받아야 OFT 변경, Autorating 결과 저장 가능하며
	  *                            승인은 1회에 한해 사용 가능(CA도 Save 버튼 누르면 사용한 것으로 간주. CA Confirm 아님) 
	  * </pre>
	  */
	public BlRatingDBDAOSearchRateMainInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("caflag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchRateMainInfoRSQL").append("\n"); 
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
		query.append("#if (${caflag} == 'Y') " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	BKG.BKG_NO" ).append("\n"); 
		query.append("	,BKG.BL_NO||DECODE(BKG.BL_TP_CD,'W','W',DECODE((select OBL_SRND_FLG from BKG_BL_ISS_HIS where BKG_NO = BKG.BKG_NO AND CORR_NO ='TMP0000001'), 'Y', 'S', ''))  AS BL_NO" ).append("\n"); 
		query.append("	,CASE WHEN RT_APLY_DT IS NOT NULL THEN TO_CHAR(RATE.RT_APLY_DT, 'YYYY-MM-DD') 	" ).append("\n"); 
		query.append("	 ELSE BKG_REV_APLY_DT_PKG.BKG_GET_CHG_RT_APLY_DT_FNC (@[bkg_no], @[caflag])   " ).append("\n"); 
		query.append("     END RT_APLY_DT" ).append("\n"); 
		query.append("	,RATE.AUD_STS_CD AUD_STS_CD" ).append("\n"); 
		query.append("	,RATE.RT_BL_TP_CD RT_BL_TP_CD" ).append("\n"); 
		query.append("        ,RATE.RT_BL_TP_CD RT_BL_TP_CD_OLD" ).append("\n"); 
		query.append("	,BL.MST_CVRD_BL_NO AS MST_CVRD_BL" ).append("\n"); 
		query.append("	,BL.COBIZ_AUTH_NO" ).append("\n"); 
		query.append("	,BKG.BL_TP_CD" ).append("\n"); 
		query.append("	,RATE.FRT_TERM_CD" ).append("\n"); 
		query.append("    ,BKG.REP_CMDT_CD" ).append("\n"); 
		query.append("    ,(SELECT REP_CMDT_NM FROM MDM_REP_CMDT WHERE REP_CMDT_CD=BKG.REP_CMDT_CD) REP_CMDT_NM" ).append("\n"); 
		query.append("    ,BKG.CMDT_CD" ).append("\n"); 
		query.append("    ,(SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD=BKG.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append("    ,BKG.TAA_NO" ).append("\n"); 
		query.append("    ,RATE.TRF_LNR_ITM_NO" ).append("\n"); 
		query.append("	,BKG.POR_CD" ).append("\n"); 
		query.append("	,BKG.POL_CD" ).append("\n"); 
		query.append("	,BKG.POD_CD" ).append("\n"); 
		query.append("	,BKG.DEL_CD" ).append("\n"); 
		query.append("	,BKG.PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("	,BKG.PST_RLY_PORT_CD" ).append("\n"); 
		query.append("	,(SELECT CUST_NM FROM BKG_CUST_HIS WHERE BKG_NO=BKG.BKG_NO AND CORR_NO='TMP0000001' AND BKG_CUST_TP_CD= 'E') CUST_NM" ).append("\n"); 
		query.append("	,BKG.RCV_TERM_CD" ).append("\n"); 
		query.append("	,BKG.DE_TERM_CD" ).append("\n"); 
		query.append("	,BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("	,(SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01720' AND INTG_CD_VAL_CTNT = BKG.ORG_TRNS_MOD_CD) ORG_TRNS_MOD_CD" ).append("\n"); 
		query.append("	,(SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01720' AND INTG_CD_VAL_CTNT = BKG.DEST_TRNS_MOD_CD) DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("	,RATE.PRC_RT_MTCH_PATT_CD" ).append("\n"); 
		query.append("	,RATE.PRC_GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("	,RATE.PRC_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	,RATE.PRC_ROUT_SEQ" ).append("\n"); 
		query.append("	,CASE WHEN BKG.POR_CD = BKG.DEL_CD AND BKG.SVC_SCP_CD IS NULL " ).append("\n"); 
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
		query.append("	(" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("        SUBSTR (MAX (SYS_CONNECT_BY_PATH (SVC_SCP_CD, '$')), 2)   AS SVC_SCP_CD" ).append("\n"); 
		query.append("	FROM    (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("			ROWNUM AS RID, T.* " ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("		SELECT DISTINCT SVC_SCP_CD FROM ( " ).append("\n"); 
		query.append("		  SELECT A.SVC_SCP_CD||'-'||A.SVC_SCP_NM  AS SVC_SCP_CD ,'A' A" ).append("\n"); 
		query.append("		  FROM MDM_SVC_SCP  A, BKG_BKG_HIS B " ).append("\n"); 
		query.append("			WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("			AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("			AND B.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("			AND B.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("		  UNION" ).append("\n"); 
		query.append("          SELECT a.svc_scp_cd ||'-'||c.svc_scp_nm as SVC_SCP_CD ,'B' B" ).append("\n"); 
		query.append("          FROM mdm_svc_scp_lmt a" ).append("\n"); 
		query.append("              ,mdm_svc_scp_lmt b" ).append("\n"); 
		query.append("              ,mdm_svc_scp c" ).append("\n"); 
		query.append("         WHERE a.svc_scp_cd = b.svc_scp_cd" ).append("\n"); 
		query.append("           AND a.svc_scp_cd = c.svc_scp_cd" ).append("\n"); 
		query.append("           AND c.delt_flg = 'N'" ).append("\n"); 
		query.append("           AND a.org_dest_cd = 'O'" ).append("\n"); 
		query.append("           AND a.delt_flg = 'N'" ).append("\n"); 
		query.append("		   AND a.svc_scp_ind_flg ='Y'" ).append("\n"); 
		query.append("           AND a.rgn_cd IN (SELECT rgn_cd" ).append("\n"); 
		query.append("                             FROM mdm_location" ).append("\n"); 
		query.append("							 WHERE loc_cd = (select POR_CD from BKG_BKG_HIS where BKG_NO =@[bkg_no] AND CORR_NO='TMP0000001')) -- BKG POR_CD" ).append("\n"); 
		query.append("           AND b.org_dest_cd = 'D'" ).append("\n"); 
		query.append("           AND b.delt_flg = 'N'" ).append("\n"); 
		query.append("		   AND b.svc_scp_ind_flg ='Y'" ).append("\n"); 
		query.append("           AND b.rgn_cd IN (SELECT rgn_cd" ).append("\n"); 
		query.append("                            FROM mdm_location" ).append("\n"); 
		query.append("							WHERE loc_cd = (select DEL_CD from BKG_BKG_HIS where BKG_NO =@[bkg_no] AND CORR_NO='TMP0000001') ) -- BKG DEL_CD" ).append("\n"); 
		query.append("			ORDER BY A)" ).append("\n"); 
		query.append("		) T" ).append("\n"); 
		query.append("	)   " ).append("\n"); 
		query.append("	START WITH  RID =  1" ).append("\n"); 
		query.append("	CONNECT BY PRIOR RID + 1 = RID   " ).append("\n"); 
		query.append("    ) END SVC_SCP_CD " ).append("\n"); 
		query.append("	,BKG.RFA_NO" ).append("\n"); 
		query.append("	,'' RP_PROP_STS_CD" ).append("\n"); 
		query.append("	,BL.CSTMS_DESC" ).append("\n"); 
		query.append("	,SUBSTR(BKG.SC_NO,0,3) AS SC_NO1" ).append("\n"); 
		query.append("	,SUBSTR(BKG.SC_NO,4) AS SC_NO2" ).append("\n"); 
		query.append("	,'' SP_PROP_STS_CD" ).append("\n"); 
		query.append("	,BL.ACT_WGT" ).append("\n"); 
		query.append("	,BL.WGT_UT_CD" ).append("\n"); 
		query.append("	,BL.MEAS_QTY" ).append("\n"); 
		query.append("	,BL.MEAS_UT_CD" ).append("\n"); 
		query.append("	,	CASE" ).append("\n"); 
		query.append("		WHEN DCGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("		WHEN RC_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("		WHEN AWK_CGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("		WHEN BB_CGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("		ELSE 'N'" ).append("\n"); 
		query.append("	END SPECIAL" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("		SELECT DECODE(RATE.RT_INTER_RMK||RATE.DIFF_RMK||RATE.DOC_INTER_RMK, '', 'N', 'Y') " ).append("\n"); 
		query.append("			FROM BKG_RT_HIS RATE" ).append("\n"); 
		query.append("			WHERE RATE.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("			AND RATE.CORR_NO ='TMP0000001'" ).append("\n"); 
		query.append("		) RMARK_YN" ).append("\n"); 
		query.append("		,CASE" ).append("\n"); 
		query.append("		WHEN BKG.RFA_NO != ' ' THEN 'Y'" ).append("\n"); 
		query.append("		ELSE 'N'" ).append("\n"); 
		query.append("	END RFA_YN" ).append("\n"); 
		query.append("	,BKG.BKG_STS_CD AS BKG_STS_CD" ).append("\n"); 
		query.append("	,BKG.SC_NO AS SC_NO_OLD" ).append("\n"); 
		query.append("	,BKG.RFA_NO AS RFA_NO_OLD" ).append("\n"); 
		query.append("	,BKG.TAA_NO AS TAA_NO_OLD" ).append("\n"); 
		query.append("	,RATE.BKG_RT_WHF_EXPT_CD" ).append("\n"); 
		query.append("	,RATE.DHF_LOC_CD" ).append("\n"); 
		query.append("	,RATE.DDC_CURR_CD" ).append("\n"); 
		query.append("	,RATE.DHF_CURR_CD" ).append("\n"); 
		query.append("	,BKG.SVC_SCP_CD AS BKG_SVC_SCP_CD" ).append("\n"); 
		query.append("	,BKG.HNGR_FLG	AS HNGR_FLG" ).append("\n"); 
		query.append("	,BKG.RC_FLG	AS RC_FLG" ).append("\n"); 
		query.append("	,(SELECT MAX(CASE WHEN CNTR_VOL_QTY < 1 THEN 'Y' ELSE 'N' END) FROM BKG_CNTR_HIS" ).append("\n"); 
		query.append("       WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	   AND   CORR_NO ='TMP0000001') CNTR_PRT_FLG" ).append("\n"); 
		query.append("    ,NVL((SELECT 'Y' FROM (" ).append("\n"); 
		query.append("                       SELECT SUM(OP_CNTR_QTY) FROM BKG_QTY_DTL_HIS WHERE CORR_NO ='TMP0000001' AND BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("                              AND 'CRD' = (SELECT BKG_REV_APLY_DT_PKG.BKG_GET_APLY_DT_CHK_FNC(@[bkg_no],@[caflag]) FROM DUAL) " ).append("\n"); 
		query.append("                       MINUS" ).append("\n"); 
		query.append("                       SELECT SUM(CNTR_VOL_QTY) FROM BKG_CNTR_HIS WHERE  CORR_NO ='TMP0000001' AND BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("                              AND 'CRD' = (SELECT BKG_REV_APLY_DT_PKG.BKG_GET_APLY_DT_CHK_FNC(@[bkg_no],@[caflag]) FROM DUAL) " ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                    WHERE ROWNUM = 1),'N') AS VOL_DIFF_FLG --Y 일때 Application Date Red 표시" ).append("\n"); 
		query.append("  ,NVL((SELECT 'Y' FROM PRI_SCG_RT RT " ).append("\n"); 
		query.append("        WHERE RT.SVC_SCP_CD = BKG.SVC_SCP_CD " ).append("\n"); 
		query.append("        AND RT.DELT_FLG ='N' " ).append("\n"); 
		query.append("        AND RT.SCG_RQST_PROC_CD = 'A'" ).append("\n"); 
		query.append("        AND NVL(RATE.RT_APLY_DT,RT.EFF_DT) BETWEEN RT.EFF_DT AND RT.EXP_DT " ).append("\n"); 
		query.append("        AND CHG_CD ='WSC' AND ROWNUM = 1 ),'N') WSC_FLG" ).append("\n"); 
		query.append("  ,NVL((SELECT 'Y' FROM PRI_SCG_RT RT " ).append("\n"); 
		query.append("        WHERE RT.SVC_SCP_CD = BKG.SVC_SCP_CD " ).append("\n"); 
		query.append("        AND RT.DELT_FLG ='N' " ).append("\n"); 
		query.append("        AND RT.SCG_RQST_PROC_CD = 'A'" ).append("\n"); 
		query.append("        AND NVL(RATE.RT_APLY_DT,RT.EFF_DT) BETWEEN RT.EFF_DT AND RT.EXP_DT " ).append("\n"); 
		query.append("        AND CHG_CD ='CDR' AND ROWNUM = 1 ),'N') CDR_FLG" ).append("\n"); 
		query.append("  ,NVL((SELECT 'Y' FROM PRI_SCG_RT RT " ).append("\n"); 
		query.append("        WHERE RT.SVC_SCP_CD = BKG.SVC_SCP_CD " ).append("\n"); 
		query.append("        AND RT.DELT_FLG ='N' " ).append("\n"); 
		query.append("        AND RT.SCG_RQST_PROC_CD = 'A'" ).append("\n"); 
		query.append("        AND NVL(RATE.RT_APLY_DT,RT.EFF_DT) BETWEEN RT.EFF_DT AND RT.EXP_DT " ).append("\n"); 
		query.append("        AND CHG_CD ='TXS' AND ROWNUM = 1 ),'N') TXS_FLG" ).append("\n"); 
		query.append("  ,NVL((SELECT 'Y' FROM PRI_SCG_RT RT " ).append("\n"); 
		query.append("        WHERE RT.SVC_SCP_CD = BKG.SVC_SCP_CD " ).append("\n"); 
		query.append("        AND RT.DELT_FLG ='N' " ).append("\n"); 
		query.append("        AND RT.SCG_RQST_PROC_CD = 'A'" ).append("\n"); 
		query.append("        AND NVL(RATE.RT_APLY_DT,RT.EFF_DT) BETWEEN RT.EFF_DT AND RT.EXP_DT " ).append("\n"); 
		query.append("        AND CHG_CD ='RWT' AND ROWNUM = 1 ),'N') RWT_FLG" ).append("\n"); 
		query.append("  ,NVL((SELECT 'Y' FROM BKG_CNTR_HIS WHERE BKG_NO = BKG.BKG_NO AND CORR_NO ='TMP0000001' AND NVL(CNTR_WGT,0) = 0 AND CNTR_VOL_QTY = 1 AND ROWNUM = 1 ),'N') CNTR_WGT_CMPL_FLG" ).append("\n"); 
		query.append("  ,CASE WHEN (SELECT ATTR_CTNT1 USE_FLG FROM BKG_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'CHG_AMD_AUTH_USE') = 'N' THEN 'Y' -- Switch. Hard Coding값이 N이면 승인없이 변경 가능" ).append("\n"); 
		query.append("        WHEN TRUNC(BKG.PORT_CLZ_DT) + 1 > GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, BKG.POR_CD) THEN 'Y'" ).append("\n"); 
		query.append("        ELSE NVL((SELECT CHG_AMD_RQST_STS_CD" ).append("\n"); 
		query.append("                      FROM BKG_CHG_AMD_AUTH A" ).append("\n"); 
		query.append("                      WHERE A.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                      AND A.CHG_AMD_SEQ = (SELECT MAX(CHG_AMD_SEQ) FROM BKG_CHG_AMD_AUTH I WHERE I.BKG_NO = A.BKG_NO)" ).append("\n"); 
		query.append("                      AND A.AUTH_USE_FLG = 'N'),'N')" ).append("\n"); 
		query.append("   END OFT_AMDABL_FLG" ).append("\n"); 
		query.append("  ,(SELECT NVL(SUM(CHG_AMT),0)" ).append("\n"); 
		query.append("    FROM BKG_CHG_RT_HIS" ).append("\n"); 
		query.append("    WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("    AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("    AND CHG_CD = 'OFT'" ).append("\n"); 
		query.append("    ) OLD_OFT_AMT" ).append("\n"); 
		query.append("  ,RATE.MST_RFA_ROUT_ID" ).append("\n"); 
		query.append("  ,RATE.DOC_INTER_RMK" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	BKG_BKG_HIS BKG, BKG_BL_DOC_HIS BL, BKG_RT_HIS RATE, MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	BKG.BKG_NO = BL.BKG_NO(+)" ).append("\n"); 
		query.append("	AND BKG.CORR_NO = BL.CORR_NO(+)" ).append("\n"); 
		query.append("	AND BKG.CORR_NO = RATE.CORR_NO(+)" ).append("\n"); 
		query.append("	AND BKG.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("	AND BL.CORR_NO(+) = 'TMP0000001'" ).append("\n"); 
		query.append("	AND RATE.CORR_NO(+) = 'TMP0000001'" ).append("\n"); 
		query.append("	AND BKG.BKG_NO = RATE.BKG_NO(+)" ).append("\n"); 
		query.append("	AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND BKG.POR_CD = L.LOC_CD" ).append("\n"); 
		query.append("	AND L.DELT_FLG ='N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    BKG.BKG_NO" ).append("\n"); 
		query.append("	,BKG.BL_NO||DECODE(BKG.BL_TP_CD,'W','W',DECODE((select OBL_SRND_FLG from BKG_BL_ISS where BKG_NO = BKG.BKG_NO), 'Y', 'S', ''))  AS BL_NO" ).append("\n"); 
		query.append("	,CASE WHEN RT_APLY_DT IS NOT NULL THEN TO_CHAR(RATE.RT_APLY_DT, 'YYYY-MM-DD') 	" ).append("\n"); 
		query.append("	 ELSE BKG_REV_APLY_DT_PKG.BKG_GET_CHG_RT_APLY_DT_FNC (@[bkg_no], @[caflag])   " ).append("\n"); 
		query.append("     END RT_APLY_DT" ).append("\n"); 
		query.append("    ,RATE.AUD_STS_CD AUD_STS_CD" ).append("\n"); 
		query.append("    ,RATE.RT_BL_TP_CD RT_BL_TP_CD" ).append("\n"); 
		query.append("    ,RATE.RT_BL_TP_CD RT_BL_TP_CD_OLD" ).append("\n"); 
		query.append("    ,BL.MST_CVRD_BL_NO AS MST_CVRD_BL" ).append("\n"); 
		query.append("	,BL.COBIZ_AUTH_NO" ).append("\n"); 
		query.append("    ,BKG.BL_TP_CD" ).append("\n"); 
		query.append("    ,RATE.FRT_TERM_CD" ).append("\n"); 
		query.append("    ,BKG.REP_CMDT_CD" ).append("\n"); 
		query.append("    ,(SELECT REP_CMDT_NM FROM MDM_REP_CMDT WHERE REP_CMDT_CD=BKG.REP_CMDT_CD) REP_CMDT_NM" ).append("\n"); 
		query.append("    ,BKG.CMDT_CD" ).append("\n"); 
		query.append("    ,(SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD=BKG.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append("    ,BKG.TAA_NO" ).append("\n"); 
		query.append("    ,RATE.TRF_LNR_ITM_NO" ).append("\n"); 
		query.append("    ,BKG.POR_CD" ).append("\n"); 
		query.append("    ,BKG.POL_CD" ).append("\n"); 
		query.append("    ,BKG.POD_CD" ).append("\n"); 
		query.append("    ,BKG.DEL_CD" ).append("\n"); 
		query.append("    ,BKG.PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("    ,BKG.PST_RLY_PORT_CD" ).append("\n"); 
		query.append("    ,(SELECT CUST_NM FROM BKG_CUSTOMER WHERE BKG_NO=BKG.BKG_NO AND BKG_CUST_TP_CD='E') CUST_NM" ).append("\n"); 
		query.append("    ,BKG.RCV_TERM_CD" ).append("\n"); 
		query.append("    ,BKG.DE_TERM_CD" ).append("\n"); 
		query.append("	,BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("	,(SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01720' AND INTG_CD_VAL_CTNT = BKG.ORG_TRNS_MOD_CD) ORG_TRNS_MOD_CD" ).append("\n"); 
		query.append("	,(SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01720' AND INTG_CD_VAL_CTNT = BKG.DEST_TRNS_MOD_CD) DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("	,RATE.PRC_RT_MTCH_PATT_CD" ).append("\n"); 
		query.append("	,RATE.PRC_GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("	,RATE.PRC_CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	,RATE.PRC_ROUT_SEQ" ).append("\n"); 
		query.append("    ,CASE WHEN BKG.POR_CD = BKG.DEL_CD AND BKG.SVC_SCP_CD IS NULL " ).append("\n"); 
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
		query.append("		 WHERE loc_cd = (select POR_CD from BKG_BOOKING where BKG_NO =@[bkg_no]))  -- BKG POR_CD" ).append("\n"); 
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
		query.append("    ) END SVC_SCP_CD " ).append("\n"); 
		query.append("    ,BKG.RFA_NO" ).append("\n"); 
		query.append("    ,'' RP_PROP_STS_CD" ).append("\n"); 
		query.append("    ,BL.CSTMS_DESC" ).append("\n"); 
		query.append("    ,SUBSTR(BKG.SC_NO,0,3) AS SC_NO1" ).append("\n"); 
		query.append("    ,SUBSTR(BKG.SC_NO,4) AS SC_NO2" ).append("\n"); 
		query.append("    ,'' SP_PROP_STS_CD" ).append("\n"); 
		query.append("    ,BL.ACT_WGT" ).append("\n"); 
		query.append("    ,BL.WGT_UT_CD" ).append("\n"); 
		query.append("    ,BL.MEAS_QTY" ).append("\n"); 
		query.append("    ,BL.MEAS_UT_CD" ).append("\n"); 
		query.append("    ,CASE " ).append("\n"); 
		query.append("        WHEN DCGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("        WHEN RC_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("        WHEN AWK_CGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("        WHEN BB_CGO_FLG='Y' THEN 'Y'" ).append("\n"); 
		query.append("        ELSE 'N'" ).append("\n"); 
		query.append("    END SPECIAL" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("		SELECT DECODE(RATE.RT_INTER_RMK||RATE.DIFF_RMK||RATE.DOC_INTER_RMK, '', 'N', 'Y') " ).append("\n"); 
		query.append("			FROM BKG_RATE RATE" ).append("\n"); 
		query.append("			WHERE RATE.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		) RMARK_YN" ).append("\n"); 
		query.append("    ,CASE " ).append("\n"); 
		query.append("        WHEN BKG.RFA_NO != ' ' THEN 'Y'" ).append("\n"); 
		query.append("        ELSE 'N'" ).append("\n"); 
		query.append("    END RFA_YN " ).append("\n"); 
		query.append(" ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append(" ,BKG.SC_NO AS SC_NO_OLD" ).append("\n"); 
		query.append(" ,BKG.RFA_NO AS RFA_NO_OLD" ).append("\n"); 
		query.append(" ,BKG.TAA_NO AS TAA_NO_OLD" ).append("\n"); 
		query.append(" ,RATE.BKG_RT_WHF_EXPT_CD" ).append("\n"); 
		query.append(" ,RATE.DHF_LOC_CD" ).append("\n"); 
		query.append(" ,RATE.DDC_CURR_CD" ).append("\n"); 
		query.append(" ,RATE.DHF_CURR_CD" ).append("\n"); 
		query.append(" ,BKG.SVC_SCP_CD AS BKG_SVC_SCP_CD" ).append("\n"); 
		query.append(" ,BKG.HNGR_FLG	AS HNGR_FLG" ).append("\n"); 
		query.append(" ,BKG.RC_FLG	AS RC_FLG" ).append("\n"); 
		query.append(" ,L.CONTI_CD" ).append("\n"); 
		query.append(" ,(SELECT MAX(CASE WHEN CNTR_VOL_QTY < 1 THEN 'Y' ELSE 'N' END) FROM BKG_CONTAINER" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]) CNTR_PRT_FLG" ).append("\n"); 
		query.append("-- ,BKG.CMDT_CD	AS CMDT_CD" ).append("\n"); 
		query.append(" ,NVL((SELECT 'Y' FROM (" ).append("\n"); 
		query.append("                    SELECT SUM(OP_CNTR_QTY) FROM BKG_QTY_DTL WHERE BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("						   AND 'CRD' = (SELECT BKG_REV_APLY_DT_PKG.BKG_GET_APLY_DT_CHK_FNC(@[bkg_no],@[caflag]) FROM DUAL)   " ).append("\n"); 
		query.append("                    MINUS" ).append("\n"); 
		query.append("                    SELECT SUM(CNTR_VOL_QTY) FROM BKG_CONTAINER WHERE BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("                           AND 'CRD' = (SELECT BKG_REV_APLY_DT_PKG.BKG_GET_APLY_DT_CHK_FNC(@[bkg_no],@[caflag]) FROM DUAL) " ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("                 WHERE ROWNUM = 1),'N') AS VOL_DIFF_FLG --Y 일때 Application Date Red 표시" ).append("\n"); 
		query.append("  ,NVL((SELECT 'Y' FROM PRI_SCG_RT RT " ).append("\n"); 
		query.append("        WHERE RT.SVC_SCP_CD = BKG.SVC_SCP_CD " ).append("\n"); 
		query.append("        AND RT.DELT_FLG ='N' " ).append("\n"); 
		query.append("        AND RT.SCG_RQST_PROC_CD = 'A'" ).append("\n"); 
		query.append("        AND NVL(RATE.RT_APLY_DT,RT.EFF_DT) BETWEEN RT.EFF_DT AND RT.EXP_DT " ).append("\n"); 
		query.append("        AND CHG_CD ='WSC' AND ROWNUM = 1 ),'N') WSC_FLG" ).append("\n"); 
		query.append("  ,NVL((SELECT 'Y' FROM PRI_SCG_RT RT " ).append("\n"); 
		query.append("        WHERE RT.SVC_SCP_CD = BKG.SVC_SCP_CD " ).append("\n"); 
		query.append("        AND RT.DELT_FLG ='N' " ).append("\n"); 
		query.append("        AND RT.SCG_RQST_PROC_CD = 'A'" ).append("\n"); 
		query.append("        AND NVL(RATE.RT_APLY_DT,RT.EFF_DT) BETWEEN RT.EFF_DT AND RT.EXP_DT " ).append("\n"); 
		query.append("        AND CHG_CD ='CDR' AND ROWNUM = 1 ),'N') CDR_FLG" ).append("\n"); 
		query.append("  ,NVL((SELECT 'Y' FROM PRI_SCG_RT RT " ).append("\n"); 
		query.append("        WHERE RT.SVC_SCP_CD = BKG.SVC_SCP_CD " ).append("\n"); 
		query.append("        AND RT.DELT_FLG ='N' " ).append("\n"); 
		query.append("        AND RT.SCG_RQST_PROC_CD = 'A'" ).append("\n"); 
		query.append("        AND NVL(RATE.RT_APLY_DT,RT.EFF_DT) BETWEEN RT.EFF_DT AND RT.EXP_DT " ).append("\n"); 
		query.append("        AND CHG_CD ='TXS' AND ROWNUM = 1 ),'N') TXS_FLG" ).append("\n"); 
		query.append("  ,NVL((SELECT 'Y' FROM PRI_SCG_RT RT " ).append("\n"); 
		query.append("        WHERE RT.SVC_SCP_CD = BKG.SVC_SCP_CD " ).append("\n"); 
		query.append("        AND RT.DELT_FLG ='N' " ).append("\n"); 
		query.append("        AND RT.SCG_RQST_PROC_CD = 'A'" ).append("\n"); 
		query.append("        AND NVL(RATE.RT_APLY_DT,RT.EFF_DT) BETWEEN RT.EFF_DT AND RT.EXP_DT " ).append("\n"); 
		query.append("        AND CHG_CD ='RWT' AND ROWNUM = 1 ),'N') RWT_FLG" ).append("\n"); 
		query.append("  ,NVL((SELECT 'Y' FROM BKG_CONTAINER WHERE BKG_NO = BKG.BKG_NO AND NVL(CNTR_WGT,0) = 0 AND CNTR_VOL_QTY = 1 AND ROWNUM = 1 ),'N') CNTR_WGT_CMPL_FLG" ).append("\n"); 
		query.append("  ,CASE WHEN (SELECT ATTR_CTNT1 USE_FLG FROM BKG_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'CHG_AMD_AUTH_USE') = 'N' THEN 'Y' -- Switch. Hard Coding값이 N이면 승인없이 변경 가능" ).append("\n"); 
		query.append("        WHEN TRUNC(BKG.PORT_CLZ_DT) + 1 > GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, BKG.POR_CD) THEN 'Y'" ).append("\n"); 
		query.append("        ELSE NVL((SELECT A.CHG_AMD_RQST_STS_CD" ).append("\n"); 
		query.append("                      FROM BKG_CHG_AMD_AUTH A" ).append("\n"); 
		query.append("                      WHERE A.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                      AND A.CHG_AMD_SEQ = (SELECT MAX(CHG_AMD_SEQ) FROM BKG_CHG_AMD_AUTH I WHERE I.BKG_NO = A.BKG_NO)" ).append("\n"); 
		query.append("                      AND A.AUTH_USE_FLG = 'N'),'N')" ).append("\n"); 
		query.append("   END OFT_AMDABL_FLG" ).append("\n"); 
		query.append("  ,(SELECT NVL(SUM(CHG_AMT),0)" ).append("\n"); 
		query.append("    FROM BKG_CHG_RT" ).append("\n"); 
		query.append("    WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("    AND CHG_CD = 'OFT'" ).append("\n"); 
		query.append("    ) OLD_OFT_AMT" ).append("\n"); 
		query.append("  ,RATE.MST_RFA_ROUT_ID" ).append("\n"); 
		query.append("  ,RATE.DOC_INTER_RMK" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    BKG_BOOKING BKG, BKG_BL_DOC BL, BKG_RATE RATE, MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    BKG.BKG_NO = BL.BKG_NO(+)" ).append("\n"); 
		query.append("    AND  BKG.BKG_NO = RATE.BKG_NO(+)" ).append("\n"); 
		query.append("    AND  BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND  BKG.POR_CD = L.LOC_CD" ).append("\n"); 
		query.append("	AND  L.DELT_FLG ='N'	" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}