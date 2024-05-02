/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOGrpBlDtListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOGrpBlDtListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GrpBlDtList
	  * 2011.04.11 이일민 [CHM-201109940-01] B/L Issue & Onboard date update 보완 요청
	  * 2011.04.25 이일민 [CHM-201110395] BL Issue & Onboard date update 화면 보완 요청
	  * </pre>
	  */
	public BLIssuanceDBDAOGrpBlDtListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_rdy_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunk_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunk_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trunk_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_rlse_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOGrpBlDtListRSQL").append("\n"); 
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
		query.append("select BKG_NO" ).append("\n"); 
		query.append("      ,BL_NO" ).append("\n"); 
		query.append("      ,bl_tp_cd" ).append("\n"); 
		query.append("      ,bl_rdy_tp_cd" ).append("\n"); 
		query.append("      ,CUST_CD" ).append("\n"); 
		query.append("      ,CUST_NM" ).append("\n"); 
		query.append("      ,CNEE_CD" ).append("\n"); 
		query.append("      ,CNEE_NM" ).append("\n"); 
		query.append("      ,FWDR_CD" ).append("\n"); 
		query.append("      ,FWDR_NM" ).append("\n"); 
		query.append("      ,BL_OBRD_TP_CD" ).append("\n"); 
		query.append("      ,BL_OBRD_DT" ).append("\n"); 
		query.append("      ,BL_OBRD_DT_SD" ).append("\n"); 
		query.append("      ,OBL_ISS_FLG" ).append("\n"); 
		query.append("      ,OBL_RLSE_FLG" ).append("\n"); 
		query.append("      ,OBL_ISS_DT" ).append("\n"); 
		query.append("      ,OBL_ISS_DT_SD" ).append("\n"); 
		query.append("      ,OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("      ,OBL_ISS_USR_ID" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,BL_RDY_FLG" ).append("\n"); 
		query.append("      ,credit_chk" ).append("\n"); 
		query.append("      ,CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("      ,FLG_RATE" ).append("\n"); 
		query.append("      ,FLG_MD" ).append("\n"); 
		query.append("      ,FLG_PPD" ).append("\n"); 
		query.append("      ,DO_ISS_DT" ).append("\n"); 
		query.append("      ,FLG_DO" ).append("\n"); 
		query.append("      ,BL_RCV_TP    " ).append("\n"); 
		query.append("      ,BL_RCV_AT" ).append("\n"); 
		query.append("      ,POL_ETD_DT" ).append("\n"); 
		query.append("      ,POL_ETA_DT" ).append("\n"); 
		query.append("      ,CGO_RCV_DT" ).append("\n"); 
		query.append("      ,OBL_SRND_FLG" ).append("\n"); 
		query.append("      ,BL_ISS_NO" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,DEL_CD" ).append("\n"); 
		query.append("      ,IR_BL_TYPE" ).append("\n"); 
		query.append("      ,IR_BL_TYPE1" ).append("\n"); 
		query.append("      ,OBL_ISS_RMK" ).append("\n"); 
		query.append("      ,ORG_PPD_RCV_CD" ).append("\n"); 
		query.append("      ,CNTC_PSON_EML      " ).append("\n"); 
		query.append("	  ,CASE WHEN MND>0 AND CNTR>0 AND CUST>0 THEN 'Y' ELSE 'N' END OB_INFO_ISS_RDY_FLG" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        SELECT T1.BKG_NO" ).append("\n"); 
		query.append("        ,      T1.BL_NO" ).append("\n"); 
		query.append("        ,      T1.BL_TP_CD" ).append("\n"); 
		query.append("        ,      T2.BL_RDY_TP_CD" ).append("\n"); 
		query.append("        ,      (SELECT CUST_CNT_CD||CUST_SEQ FROM BKG_CUSTOMER WHERE BKG_NO=T1.BKG_NO AND BKG_CUST_TP_CD='S') CUST_CD" ).append("\n"); 
		query.append("        ,      (SELECT REPLACE(REPLACE(CUST_NM, CHR(10), ''), CHR(13), ' ') FROM BKG_CUSTOMER WHERE BKG_NO=T1.BKG_NO AND BKG_CUST_TP_CD='S') CUST_NM" ).append("\n"); 
		query.append("        ,      (SELECT CUST_CNT_CD||CUST_SEQ FROM BKG_CUSTOMER WHERE BKG_NO=T1.BKG_NO AND BKG_CUST_TP_CD='C') CNEE_CD" ).append("\n"); 
		query.append("        ,      (SELECT REPLACE(REPLACE(CUST_NM, CHR(10), ''), CHR(13), ' ') FROM BKG_CUSTOMER WHERE BKG_NO=T1.BKG_NO AND BKG_CUST_TP_CD='C') CNEE_NM" ).append("\n"); 
		query.append("        ,      (SELECT CUST_CNT_CD||CUST_SEQ FROM BKG_CUSTOMER WHERE BKG_NO=T1.BKG_NO AND BKG_CUST_TP_CD='F') FWDR_CD" ).append("\n"); 
		query.append("        ,      (SELECT REPLACE(REPLACE(CUST_NM, CHR(10), ''), CHR(13), ' ') FROM BKG_CUSTOMER WHERE BKG_NO=T1.BKG_NO AND BKG_CUST_TP_CD='F') FWDR_NM" ).append("\n"); 
		query.append("        ,      T1.BL_OBRD_TP_CD" ).append("\n"); 
		query.append("        ,      TO_CHAR (T1.BL_OBRD_DT, 'YYYY-MM-DD') BL_OBRD_DT" ).append("\n"); 
		query.append("        ,      '' BL_OBRD_DT_SD" ).append("\n"); 
		query.append("        ,      NVL(T2.OBL_ISS_FLG,'N') OBL_ISS_FLG" ).append("\n"); 
		query.append("        ,      NVL(T2.OBL_RLSE_FLG,'N') OBL_RLSE_FLG" ).append("\n"); 
		query.append("        ,      TO_CHAR (T2.OBL_ISS_DT, 'YYYY-MM-DD') OBL_ISS_DT" ).append("\n"); 
		query.append("        ,      '' OBL_ISS_DT_SD" ).append("\n"); 
		query.append("        ,      T2.OBL_ISS_OFC_CD" ).append("\n"); 
		query.append("        ,      T2.OBL_ISS_USR_ID" ).append("\n"); 
		query.append("        ,      T2.CRE_USR_ID" ).append("\n"); 
		query.append("        ,      T2.UPD_USR_ID" ).append("\n"); 
		query.append("        ,      NVL(T2.BL_RDY_FLG,'N') BL_RDY_FLG" ).append("\n"); 
		query.append("        ,      '' credit_chk" ).append("\n"); 
		query.append("        ,      T1.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("        ,      CASE WHEN (" ).append("\n"); 
		query.append("                    SELECT COUNT(BKG_NO)" ).append("\n"); 
		query.append("                    FROM BKG_CHG_RT" ).append("\n"); 
		query.append("                    WHERE BKG_NO=T1.BKG_NO) > 0" ).append("\n"); 
		query.append("               OR (" ).append("\n"); 
		query.append("                    SELECT COUNT(BKG_NO)" ).append("\n"); 
		query.append("                    FROM BKG_RATE" ).append("\n"); 
		query.append("                    WHERE BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("                    AND RT_BL_TP_CD IN ('C', 'B')) > 0" ).append("\n"); 
		query.append("               OR (" ).append("\n"); 
		query.append("                    SELECT COUNT(BKG_NO)" ).append("\n"); 
		query.append("                    FROM BKG_BOOKING" ).append("\n"); 
		query.append("                    WHERE BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("                    AND CHN_AGN_CD IS NOT NULL) > 0 THEN 'Y' ELSE 'N' END FLG_RATE" ).append("\n"); 
		query.append("        ,	   CASE WHEN (" ).append("\n"); 
		query.append("                    SELECT COUNT(BKG_NO)" ).append("\n"); 
		query.append("                    FROM BKG_BL_MK_DESC" ).append("\n"); 
		query.append("                    WHERE BKG_NO=T1.BKG_NO" ).append("\n"); 
		query.append("                    AND CMDT_DESC IS NOT NULL) > 0 THEN 'Y' ELSE 'N' END FLG_MD" ).append("\n"); 
		query.append("        , 	   CASE WHEN (T2.ORG_PPD_RCV_CD = 'N' AND ( select count(BKG_NO) from BKG_CHG_RT where FRT_TERM_CD = 'P' and N3PTY_RCV_OFC_CD IS NULL AND BKG_NO=T1.BKG_NO ) > 0)  " ).append("\n"); 
		query.append("               OR (T2.ORG_N3PTY_PPD_CD = 'N' AND ( select count(BKG_NO) from BKG_CHG_RT where FRT_TERM_CD = 'P' and N3PTY_RCV_OFC_CD IS NOT NULL AND BKG_NO=T1.BKG_NO) > 0)   " ).append("\n"); 
		query.append("               THEN 'Y' ELSE 'N' END FLG_PPD " ).append("\n"); 
		query.append("        ,      CASE WHEN " ).append("\n"); 
		query.append("                    (SELECT EVNT_DT AS DO_ISSUE_DATE" ).append("\n"); 
		query.append("                    FROM BKG_DO_DTL DTL" ).append("\n"); 
		query.append("                    WHERE DTL.BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("                    AND DTL.RLSE_STS_CD = DECODE(SUBSTR(T1.DEL_CD, 1, 2), 'JP', 'D', 'R')" ).append("\n"); 
		query.append("                    AND ROWNUM = 1              " ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                    SELECT CGO.MRN_TML_EDI_LST_SND_DT AS DO_ISSUE_DATE" ).append("\n"); 
		query.append("                    FROM BKG_CGO_RLSE CGO," ).append("\n"); 
		query.append("                    BKG_CSTMS_ADV_BL AMS" ).append("\n"); 
		query.append("                WHERE AMS.BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("                AND CGO.FRT_CLT_FLG = 'Y'" ).append("\n"); 
		query.append("                AND CGO.OBL_RDEM_FLG = 'Y'" ).append("\n"); 
		query.append("                AND CGO.CSTMS_CLR_CD = 'Y'" ).append("\n"); 
		query.append("                AND CGO.BL_NO = AMS.BL_NO" ).append("\n"); 
		query.append("                AND AMS.CNT_CD = 'US' " ).append("\n"); 
		query.append("                AND ROWNUM = 1  ) IS NOT NULL THEN 'Y' ELSE 'N' END DO_ISS_DT" ).append("\n"); 
		query.append("        , 		CASE WHEN (SELECT (SELECT DO_NO FROM BKG_DO WHERE BKG_NO = DTL.BKG_NO  AND RLSE_SEQ= DTL.RLSE_SEQ ) AS DO_ISSUE_NO" ).append("\n"); 
		query.append("                    FROM BKG_DO_DTL DTL,BKG_BOOKING BKG" ).append("\n"); 
		query.append("                    WHERE DTL.BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("                    AND BKG.BKG_NO = DTL.BKG_NO" ).append("\n"); 
		query.append("                    AND ROWNUM = 1" ).append("\n"); 
		query.append("                    AND DTL.RLSE_STS_CD = DECODE(SUBSTR(BKG.DEL_CD, 1, 2), 'JP', 'D', 'R')) IS NOT NULL THEN 'Y' ELSE 'N' END AS FLG_DO" ).append("\n"); 
		query.append("        ,		CASE WHEN T2.OTR_DOC_CGOR_FLG = 'Y' THEN 'L' ELSE T1.BL_TP_CD END BL_RCV_TP" ).append("\n"); 
		query.append("        ,		CASE WHEN T2.OTR_DOC_CGOR_FLG = 'Y' THEN T2.OTR_DOC_RCV_OFC_CD ELSE T2.OBL_RDEM_OFC_CD END BL_RCV_AT" ).append("\n"); 
		query.append("        ,		TO_CHAR ((SELECT SKD.VPS_ETD_DT" ).append("\n"); 
		query.append("                    FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                    WHERE SKD.VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                    AND SKD.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND SKD.SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND SKD.VPS_PORT_CD = T1.POL_CD" ).append("\n"); 
		query.append("                    AND SKD.CLPT_IND_SEQ = T1.POL_CLPT_IND_SEQ ),'YYYY-MM-DD') AS POL_ETD_DT" ).append("\n"); 
		query.append("        ,		TO_CHAR ((SELECT SKD.VPS_ETA_DT" ).append("\n"); 
		query.append("                    FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                    WHERE SKD.VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("                    AND SKD.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND SKD.SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND SKD.VPS_PORT_CD = T1.POL_CD" ).append("\n"); 
		query.append("                    AND SKD.CLPT_IND_SEQ = T1.POL_CLPT_IND_SEQ ),'YYYY-MM-DD') AS POL_ETA_DT " ).append("\n"); 
		query.append("        ,		TO_CHAR ((SELECT MAX(CGO_RCV_DT) AS CGO_RCV_DT FROM BKG_CONTAINER" ).append("\n"); 
		query.append("                WHERE BKG_NO = T1.BKG_NO),'YYYY-MM-DD') AS CGO_RCV_DT" ).append("\n"); 
		query.append("        ,		NVL(T2.OBL_SRND_FLG,'N') AS OBL_SRND_FLG" ).append("\n"); 
		query.append("        ,       T2.BL_CPY_KNT AS BL_ISS_NO" ).append("\n"); 
		query.append("        ,       POD_CD" ).append("\n"); 
		query.append("        ,		DEL_CD" ).append("\n"); 
		query.append("        ,       NVL(T1.BL_TP_CD,'B') AS IR_BL_TYPE" ).append("\n"); 
		query.append("        ,       CASE WHEN T1.BL_TP_CD = 'W' THEN 'SWB'" ).append("\n"); 
		query.append("                     WHEN (SELECT MAX(N1ST_PRN_DT||N2ND_PRN_DT) " ).append("\n"); 
		query.append("                             FROM BKG_INET_BL_PRN_AUTH " ).append("\n"); 
		query.append("                            WHERE BKG_NO = T1.BKG_NO) is not null THEN 'Web OB/L'" ).append("\n"); 
		query.append("                    WHEN T2.OBL_RLSE_FLG = 'Y' THEN 'OB/L'" ).append("\n"); 
		query.append("                    ELSE 'B'" ).append("\n"); 
		query.append("                END AS IR_BL_TYPE1" ).append("\n"); 
		query.append("        ,       T2.OBL_ISS_RMK" ).append("\n"); 
		query.append("        ,       NVL(T2.ORG_PPD_RCV_CD,'N') AS ORG_PPD_RCV_CD" ).append("\n"); 
		query.append("        ,       (SELECT CNTC_PSON_EML FROM BKG_CNTC_PSON WHERE BKG_NO = T1.BKG_NO AND BKG_CNTC_PSON_TP_CD = 'SI') AS CNTC_PSON_EML  " ).append("\n"); 
		query.append("        ,       (SELECT     --A.BKG_NO BKG_NO, " ).append("\n"); 
		query.append("                                --DECODE((NVL(B.PCK_QTY, '0')||NVL(B.ACT_WGT, '0')||NVL(B.CSTMS_DESC, '*')), '00*', 0, 1) MND_CNT " ).append("\n"); 
		query.append("                                DECODE(NVL(B.CSTMS_DESC, '*'), '*', 0, 1) MND_CNT " ).append("\n"); 
		query.append("                     FROM       BKG_BOOKING A, BKG_BL_DOC B" ).append("\n"); 
		query.append("                     WHERE      A.BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("                     AND        A.BKG_NO = B.BKG_NO(+) ) MND" ).append("\n"); 
		query.append("        ,       (SELECT     --A.BKG_NO, " ).append("\n"); 
		query.append("                                NVL(COUNT(B.CNTR_NO), 0) CNTR_CNT" ).append("\n"); 
		query.append("                     FROM       BKG_BOOKING A, BKG_CONTAINER B" ).append("\n"); 
		query.append("                     WHERE      A.BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("                     AND        A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("                     GROUP BY   A.BKG_NO ) CNTR" ).append("\n"); 
		query.append("        ,       (SELECT     --A.BKG_NO, " ).append("\n"); 
		query.append("                                DECODE(NVL(CUST_NM, '*'), '*', 0, 1) CUST_CNT" ).append("\n"); 
		query.append("                     FROM       BKG_BOOKING A, BKG_CUSTOMER B" ).append("\n"); 
		query.append("                     WHERE      A.BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("                     AND        A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("                     AND        BKG_CUST_TP_CD(+) = 'C') CUST" ).append("\n"); 
		query.append("        FROM   (SELECT BKG_NO" ).append("\n"); 
		query.append("        ,              BL_NO" ).append("\n"); 
		query.append("        ,              BL_TP_CD" ).append("\n"); 
		query.append("        ,              BL_OBRD_TP_CD" ).append("\n"); 
		query.append("        ,              BL_OBRD_DT" ).append("\n"); 
		query.append("        ,              CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("        ,              DEL_CD" ).append("\n"); 
		query.append("        ,              VSL_CD" ).append("\n"); 
		query.append("        ,              SKD_VOY_NO" ).append("\n"); 
		query.append("        ,              SKD_DIR_CD" ).append("\n"); 
		query.append("        ,              POL_CD" ).append("\n"); 
		query.append("        ,              POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ,              VVD_SEQ" ).append("\n"); 
		query.append("        ,              POD_CD" ).append("\n"); 
		query.append("                FROM   (SELECT A.BKG_NO" ).append("\n"); 
		query.append("        ,                      A.BL_NO" ).append("\n"); 
		query.append("        ,                      A.BL_TP_CD" ).append("\n"); 
		query.append("        ,                      B.BL_OBRD_TP_CD" ).append("\n"); 
		query.append("        ,                      B.BL_OBRD_DT" ).append("\n"); 
		query.append("        ,                      ROW_NUMBER() OVER (PARTITION BY A.BKG_NO ORDER BY C.VSL_PRE_PST_CD || C.VSL_SEQ) AS NUM" ).append("\n"); 
		query.append("        ,                      A.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("        ,                      A.DEL_CD" ).append("\n"); 
		query.append("        ,                      C.VSL_CD" ).append("\n"); 
		query.append("        ,                      C.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,                      C.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,                      C.POL_CD" ).append("\n"); 
		query.append("        ,                      C.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ,                      C.VSL_PRE_PST_CD || C.VSL_SEQ  AS VVD_SEQ" ).append("\n"); 
		query.append("        ,                      A.POD_CD" ).append("\n"); 
		query.append("                        FROM   BKG_BOOKING A, BKG_BL_DOC B, BKG_VVD C" ).append("\n"); 
		query.append("                        WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                        AND    B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("        #if (${bkg_no} != '')" ).append("\n"); 
		query.append("                        AND    A.BKG_NO IN ( ${bkg_no} )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                        AND    A.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                        AND    A.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("                        AND    A.POL_CD = C.POL_CD" ).append("\n"); 
		query.append("        #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("                        AND    A.BKG_OFC_CD= @[bkg_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${rfa_no} != '')" ).append("\n"); 
		query.append("                        AND    A.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${sc_no} != '')" ).append("\n"); 
		query.append("                        AND    A.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${ob_srep_cd} != '')" ).append("\n"); 
		query.append("                        AND    A.OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bkg_from_dt} != '')" ).append("\n"); 
		query.append("            #if (${type_date} == 'B')" ).append("\n"); 
		query.append("                        AND A.BKG_CRE_DT >= TO_DATE(REPLACE(@[bkg_from_dt],'-',''),'RRRRMMDD')" ).append("\n"); 
		query.append("            #elseif (${type_date} == 'O')         " ).append("\n"); 
		query.append("                        AND B.BL_OBRD_DT >= TO_DATE(REPLACE(@[bkg_from_dt],'-',''),'RRRRMMDD')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bkg_to_dt} != '')" ).append("\n"); 
		query.append("            #if (${type_date} == 'B')" ).append("\n"); 
		query.append("                        AND A.BKG_CRE_DT < TO_DATE(REPLACE(@[bkg_to_dt],'-',''),'RRRRMMDD') + 1" ).append("\n"); 
		query.append("            #elseif (${type_date} == 'O')  " ).append("\n"); 
		query.append("                        AND B.BL_OBRD_DT < TO_DATE(REPLACE(@[bkg_to_dt],'-',''),'RRRRMMDD') + 1" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${shipper_cd} != '')" ).append("\n"); 
		query.append("            #if (${cust_seq} != '') " ).append("\n"); 
		query.append("                AND    EXISTS ( SELECT 'Y' FROM BKG_CUSTOMER WHERE BKG_NO = A.BKG_NO AND CUST_CNT_CD=@[cust_cnt_cd] AND CUST_SEQ=@[cust_seq] AND BKG_CUST_TP_CD='S' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("                AND    EXISTS ( SELECT 'Y' FROM BKG_CUSTOMER WHERE BKG_NO = A.BKG_NO AND CUST_CNT_CD=@[cust_cnt_cd] AND BKG_CUST_TP_CD='S' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${fwdr_cd} != '')" ).append("\n"); 
		query.append("            #if (${f_cust_seq} != '') " ).append("\n"); 
		query.append("                AND    EXISTS ( SELECT 'Y' FROM BKG_CUSTOMER WHERE BKG_NO = A.BKG_NO AND CUST_CNT_CD=@[f_cust_cnt_cd] AND CUST_SEQ=@[f_cust_seq] AND BKG_CUST_TP_CD='F' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("                AND    EXISTS ( SELECT 'Y' FROM BKG_CUSTOMER WHERE BKG_NO = A.BKG_NO AND CUST_CNT_CD=@[f_cust_cnt_cd] AND BKG_CUST_TP_CD='F' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cnee_cd} != '')" ).append("\n"); 
		query.append("            #if (${cnee_seq} != '') " ).append("\n"); 
		query.append("                AND    EXISTS ( SELECT 'Y' FROM BKG_CUSTOMER WHERE BKG_NO = A.BKG_NO AND CUST_CNT_CD=@[cnee_cd] AND CUST_SEQ=@[cnee_seq] AND BKG_CUST_TP_CD='C' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("            #else " ).append("\n"); 
		query.append("                AND    EXISTS ( SELECT 'Y' FROM BKG_CUSTOMER WHERE BKG_NO = A.BKG_NO AND CUST_CNT_CD=@[cnee_cd] AND BKG_CUST_TP_CD='C' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vvd} != '')" ).append("\n"); 
		query.append("                        AND    C.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                        AND    C.SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("                        AND    C.SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("                        AND    C.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("                        AND    C.POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${trunk_vvd} != '')" ).append("\n"); 
		query.append("                        AND    A.VSL_CD = @[trunk_vsl_cd]" ).append("\n"); 
		query.append("                        AND    A.SKD_VOY_NO = @[trunk_voy_no]" ).append("\n"); 
		query.append("                        AND    A.SKD_DIR_CD = @[trunk_dir_cd]                " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                        ORDER BY C.VSL_PRE_PST_CD, C.VSL_SEQ)" ).append("\n"); 
		query.append("                WHERE  NUM = 1) T1, BKG_BL_ISS T2" ).append("\n"); 
		query.append("        WHERE  T1.BKG_NO = T2.BKG_NO(+)" ).append("\n"); 
		query.append("        #if (${obl_iss_flg} == 'Y') " ).append("\n"); 
		query.append("        AND    @[obl_iss_flg] = T2.OBL_ISS_FLG " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${obl_rlse_flg} == 'Y')" ).append("\n"); 
		query.append("        AND    @[obl_rlse_flg] = T2.OBL_RLSE_FLG " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bl_rdy_flg} == 'Y')" ).append("\n"); 
		query.append("        AND    @[bl_rdy_flg] = T2.BL_RDY_FLG" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${obl_iss_flg} == 'N') " ).append("\n"); 
		query.append("        AND    (@[obl_iss_flg] = T2.OBL_ISS_FLG OR T2.BKG_NO IS NULL)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${obl_rlse_flg} == 'N')" ).append("\n"); 
		query.append("        AND    (@[obl_rlse_flg] = T2.OBL_RLSE_FLG OR T2.OBL_RLSE_FLG IS NULL)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${bl_rdy_flg} == 'N')" ).append("\n"); 
		query.append("        AND    (@[bl_rdy_flg] = T2.BL_RDY_FLG OR T2.BL_RDY_FLG IS NULL)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}