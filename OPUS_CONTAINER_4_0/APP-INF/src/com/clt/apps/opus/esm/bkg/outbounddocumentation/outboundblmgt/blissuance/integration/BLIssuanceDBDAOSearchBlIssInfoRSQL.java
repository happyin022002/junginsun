/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchBlIssInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchBlIssInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L Issue 정보 조회
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchBlIssInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchBlIssInfoRSQL").append("\n"); 
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
		query.append("  M.BKG_NO ," ).append("\n"); 
		query.append("  BL_NO||DECODE(M.BL_ISS_TP_CD,'W','W',DECODE(SURRENDER, 'Y', 'S', '')) AS BL_NO," ).append("\n"); 
		query.append("  TVVD ," ).append("\n"); 
		query.append("  BKG_STS ," ).append("\n"); 
		query.append("  BDR ," ).append("\n"); 
		query.append("  SHPR_NAME ," ).append("\n"); 
		query.append("  SHPR_ADDRESS ," ).append("\n"); 
		query.append("  F_FWD_NAME ," ).append("\n"); 
		query.append("  F_FWD_ADDRESS ," ).append("\n"); 
		query.append("  VESSEL_DIRECTION ," ).append("\n"); 
		query.append("  PRE_CARRIAGE_BY ," ).append("\n"); 
		query.append("  NVL(POR_CODE, NPOR_CODE) AS POR_CODE ," ).append("\n"); 
		query.append("  NVL(UPPER(POR_NAME), UPPER(NPOR_NAME)) AS POR_NAME ," ).append("\n"); 
		query.append("  NVL(POL_CODE, NPOL_CODE) AS POL_CODE ," ).append("\n"); 
		query.append("  NVL(UPPER(POL_NAME), UPPER(NPOL_NAME)) AS POL_NAME ," ).append("\n"); 
		query.append("  NVL(POD_CODE, NPOD_CODE) AS POD_CODE ," ).append("\n"); 
		query.append("  NVL(UPPER(POD_NAME), UPPER(NPOD_NAME)) AS POD_NAME ," ).append("\n"); 
		query.append("  NVL(DEL_CODE, NDEL_CODE) AS DEL_CODE ," ).append("\n"); 
		query.append("  NVL(UPPER(DEL_NAME), UPPER(NDEL_NAME)) AS DEL_NAME ," ).append("\n"); 
		query.append("  MOVE_TYPE ," ).append("\n"); 
		query.append("  FINAL_DEST ," ).append("\n"); 
		query.append("  PPD_CONFIRM ," ).append("\n"); 
		query.append("  TRD_PPD_CONFIRM ," ).append("\n"); 
		query.append("  CCT_CONFIRM ," ).append("\n"); 
		query.append("  TRD_CCT_CONFIRM ," ).append("\n"); 
		query.append("  BL_READY_CHECKBOX ," ).append("\n"); 
		query.append("  BL_READY_BY ," ).append("\n"); 
		query.append("  TO_CHAR(BL_READY_DATE, 'YYYY-MM-DD') BL_READY_DATE ," ).append("\n"); 
		query.append("  BL_READY_OFFICE ," ).append("\n"); 
		query.append("  BL_READY_TYPE ,  " ).append("\n"); 
		query.append("  ON_BOARD_TYPE ," ).append("\n"); 
		query.append("  TO_CHAR(ON_BOARD_DATE, 'YYYY-MM-DD') ON_BOARD_DATE ," ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  BL_PROOFBYSHIPPER_CHECKBOX," ).append("\n"); 
		query.append("  BL_PROOFBYSHIPPER_OFFICE," ).append("\n"); 
		query.append("  BL_PROOFBYSHIPPER_BY," ).append("\n"); 
		query.append("  BL_PROOFBYSHIPPER_DATE," ).append("\n"); 
		query.append(" (SELECT CNTC_PSON_EML FROM BKG_CNTC_PSON WHERE BKG_NO=@[bkg_no] AND BKG_CNTC_PSON_TP_CD = 'BL') AS CNTC_PSON_EML," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  BL_ISSUEBL_TYPE ," ).append("\n"); 
		query.append("  BL_ISSUE_NO ," ).append("\n"); 
		query.append("  BL_CPY_NO ," ).append("\n"); 
		query.append("  TO_CHAR(BL_ISSUE_DATE, 'YYYY-MM-DD') BL_ISSUE_DATE ," ).append("\n"); 
		query.append("  BL_ISSUE_RELEASE ," ).append("\n"); 
		query.append("  BL_ISSUE_AT ," ).append("\n"); 
		query.append("  BL_ISSUE_BY ," ).append("\n"); 
		query.append("  ISSUED ," ).append("\n"); 
		query.append("  RELEASED ," ).append("\n"); 
		query.append("  CUST_TO_ORD_FLG ," ).append("\n"); 
		query.append("--  CASE WHEN (" ).append("\n"); 
		query.append("--    select count(bkg_no)" ).append("\n"); 
		query.append("--    from BKG_CHG_RT" ).append("\n"); 
		query.append("--    where bkg_no=M.BKG_NO) > 0" ).append("\n"); 
		query.append("--  OR (" ).append("\n"); 
		query.append("--    select COUNT(bkg_no)" ).append("\n"); 
		query.append("--    from bkg_rate" ).append("\n"); 
		query.append("--    where bkg_no = M.BKG_NO" ).append("\n"); 
		query.append("--      and rt_bl_tp_cd in ('C'," ).append("\n"); 
		query.append("--          'B')) > 0" ).append("\n"); 
		query.append("--  OR (" ).append("\n"); 
		query.append("--    select COUNT(bkg_no)" ).append("\n"); 
		query.append("--    from bkg_booking" ).append("\n"); 
		query.append("--    where bkg_no = M.BKG_NO" ).append("\n"); 
		query.append("--      and chn_agn_cd is not null) > 0 THEN 'Y' ELSE 'N' END ISSUED_ENABLE ," ).append("\n"); 
		query.append("DECODE(ORG_PPD_RCV_UPD_OFC_CD,null,   " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("    SELECT PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("    FROM BKG_RATE" ).append("\n"); 
		query.append("    WHERE BKG_NO= @[bkg_no]),ORG_PPD_RCV_UPD_OFC_CD ) PPD_RCV_USER_OFFICE ," ).append("\n"); 
		query.append("  PPD_RCV_USER_ID ," ).append("\n"); 
		query.append("  PPD_RCV_DT ," ).append("\n"); 
		query.append("DECODE(ORG_N3PTY_PPD_UPD_OFC_CD,null, " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("    SELECT N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("    FROM BKG_CHG_RT" ).append("\n"); 
		query.append("    WHERE BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("      AND FRT_TERM_CD = 'P'" ).append("\n"); 
		query.append("      AND ROWNUM =1),ORG_N3PTY_PPD_UPD_OFC_CD) TRD_PPD_RCV_USER_OFFICE ," ).append("\n"); 
		query.append("  TRD_PPD_RCV_USER_ID ," ).append("\n"); 
		query.append("  TRD_PPD_RCV_DT ," ).append("\n"); 
		query.append("DECODE(DEST_CLT_RCV_UPD_OFC_CD,null, " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("    SELECT CLT_OFC_CD" ).append("\n"); 
		query.append("    FROM BKG_RATE" ).append("\n"); 
		query.append("    WHERE BKG_NO= @[bkg_no]),DEST_CLT_RCV_UPD_OFC_CD) CCT_RCV_USER_OFFICE ," ).append("\n"); 
		query.append("  CCT_RCV_USER_ID ," ).append("\n"); 
		query.append("  CCT_RCV_DT ," ).append("\n"); 
		query.append("DECODE(DEST_N3PTY_CLT_UPD_OFC_CD,null, " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("    SELECT N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("    FROM BKG_CHG_RT" ).append("\n"); 
		query.append("    WHERE BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("      AND FRT_TERM_CD = 'C'" ).append("\n"); 
		query.append("      AND ROWNUM =1),DEST_N3PTY_CLT_UPD_OFC_CD) TRD_CCT_RCV_USER_OFFICE ," ).append("\n"); 
		query.append("  TRD_CCT_RCV_USER_ID ," ).append("\n"); 
		query.append("  TRD_CCT_RCV_DT ," ).append("\n"); 
		query.append("  NVL(O_BLRECEIVE_TYPE, DECODE(NVL(O_BLRECEIVE_AT, '*'), '*', BL_ISSUEBL_TYPE, NVL(BL_ISSUEBL_TYPE, 'B'))) AS O_BLRECEIVE_TYPE ," ).append("\n"); 
		query.append("  O_BLRECEIVE_NO ," ).append("\n"); 
		query.append("  TO_CHAR(O_BLRECEIVE_DATE, 'YYYY-MM-DD') O_BLRECEIVE_DATE ," ).append("\n"); 
		query.append("  O_BLRECEIVE_AT ," ).append("\n"); 
		query.append("  O_BLRECEIVE_BY ," ).append("\n"); 
		query.append("  SURRENDER ," ).append("\n"); 
		query.append("  DO_ISSUE_NO ," ).append("\n"); 
		query.append("  TO_CHAR(DO_ISSUE_DATE, 'YYYY-MM-DD') DO_ISSUE_DATE ," ).append("\n"); 
		query.append("  DO_ISSUE_AT ," ).append("\n"); 
		query.append("  DO_ISSUE_BY ," ).append("\n"); 
		query.append("  PRINT_OPTION ," ).append("\n"); 
		query.append("  AUTH_FLAG ," ).append("\n"); 
		query.append("  INTERNET_AUTH ,  " ).append("\n"); 
		query.append("  DOC_REQUEST_FLAG ," ).append("\n"); 
		query.append("  OBL_PRN_FLG ," ).append("\n"); 
		query.append("  TO_CHAR(POL_ETD_DT, 'YYYY-MM-DD') POL_ETD_DT ," ).append("\n"); 
		query.append("  TO_CHAR(C.CGO_RCV_DT, 'YYYY-MM-DD') CGO_RCV_DT," ).append("\n"); 
		query.append("  CASE WHEN (" ).append("\n"); 
		query.append("    select count(bkg_no)" ).append("\n"); 
		query.append("    from BKG_CHG_RT" ).append("\n"); 
		query.append("    where bkg_no=M.BKG_NO) > 0" ).append("\n"); 
		query.append("  OR (" ).append("\n"); 
		query.append("    select COUNT(bkg_no)" ).append("\n"); 
		query.append("    from bkg_rate" ).append("\n"); 
		query.append("    where bkg_no = M.BKG_NO" ).append("\n"); 
		query.append("      and rt_bl_tp_cd in ('C', 'B')) > 0" ).append("\n"); 
		query.append("  OR (" ).append("\n"); 
		query.append("    select COUNT(bkg_no)" ).append("\n"); 
		query.append("    from bkg_booking" ).append("\n"); 
		query.append("    where bkg_no = M.BKG_NO" ).append("\n"); 
		query.append("      and chn_agn_cd is not null) > 0 THEN 'Y' ELSE 'N' END flg_rate ," ).append("\n"); 
		query.append("  CASE WHEN (" ).append("\n"); 
		query.append("    select count(c.bkg_no)" ).append("\n"); 
		query.append("    from bkg_bl_mk_desc C, BKG_BL_DOC B" ).append("\n"); 
		query.append("    where c.bkg_no = M.BKG_NO" ).append("\n"); 
		query.append("      and c.bkg_no = B.BKG_NO" ).append("\n"); 
		query.append("      and (B.PCK_QTY IS NOT NULL AND B.PCK_QTY  <> 0 )" ).append("\n"); 
		query.append("	  and (B.ACT_WGT IS NOT NULL AND B.ACT_WGT  <> 0 ) " ).append("\n"); 
		query.append("      and B.CSTMS_DESC IS not null) > 0 THEN 'Y' ELSE 'N' END flg_md ," ).append("\n"); 
		query.append("  PPD_CONFIRM AS flg_ppd ," ).append("\n"); 
		query.append("  CUST_TO_ORD_FLG AS flg_to_order ," ).append("\n"); 
		query.append("  CASE WHEN do_issue_no != ' ' THEN 'Y' ELSE 'N' END flg_do," ).append("\n"); 
		query.append("  OBL_ISS_RMK," ).append("\n"); 
		query.append("  INET_CTRL_PTY_NM," ).append("\n"); 
		query.append("  DECODE(INET_CTRL_PTY_NO,0,'', LPAD(INET_CTRL_PTY_NO,6,'0')) INET_CTRL_PTY_NO," ).append("\n"); 
		query.append("  INET_CTRL_PTY_CUST_NM," ).append("\n"); 
		query.append("  M.BL_ISS_TP_CD BL_ISS_TP_CD," ).append("\n"); 
		query.append("  NVL(M.BL_MV_TP_PRN_FLG,'Y') AS BL_MV_TP_PRN_FLG," ).append("\n"); 
		query.append("  NVL(M.RCV_DE_TERM_PRN_FLG,'Y') AS RCV_DE_TERM_PRN_FLG," ).append("\n"); 
		query.append("  M.RQST_BL_TP_CD RQST_BL_TP_CD," ).append("\n"); 
		query.append("  M.ISS_SAVE_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT BL.BKG_NO AS BKG_NO ," ).append("\n"); 
		query.append("      BL.BDR_FLG AS BDR ," ).append("\n"); 
		query.append("      BL.VSL_NM AS VESSEL_DIRECTION ," ).append("\n"); 
		query.append("      BL.PRE_VSL_NM AS PRE_CARRIAGE_BY ," ).append("\n"); 
		query.append("      BL.POR_CD AS POR_CODE ," ).append("\n"); 
		query.append("      BL.POR_NM AS POR_NAME ," ).append("\n"); 
		query.append("      BL.POL_CD AS POL_CODE ," ).append("\n"); 
		query.append("      BL.POL_NM AS POL_NAME ," ).append("\n"); 
		query.append("      BL.POD_CD AS POD_CODE ," ).append("\n"); 
		query.append("      BL.POD_NM AS POD_NAME ," ).append("\n"); 
		query.append("      BL.DEL_CD AS DEL_CODE ," ).append("\n"); 
		query.append("      BL.DEL_NM AS DEL_NAME ," ).append("\n"); 
		query.append("      BL.BL_MV_TP_NM AS MOVE_TYPE ," ).append("\n"); 
		query.append("      BL.FNL_DEST_NM AS FINAL_DEST ," ).append("\n"); 
		query.append("      ISS.ORG_PPD_RCV_CD AS PPD_CONFIRM ," ).append("\n"); 
		query.append("      ISS.ORG_N3PTY_PPD_CD AS TRD_PPD_CONFIRM ," ).append("\n"); 
		query.append("      ISS.DEST_CLT_RCV_CD AS CCT_CONFIRM ," ).append("\n"); 
		query.append("      ISS.DEST_N3PTY_CLT_CD AS TRD_CCT_CONFIRM ," ).append("\n"); 
		query.append("      ISS.BL_RDY_FLG AS BL_READY_CHECKBOX ," ).append("\n"); 
		query.append("      ISS.BL_RDY_USR_ID AS BL_READY_BY ," ).append("\n"); 
		query.append("      ISS.BL_RDY_DT AS BL_READY_DATE ," ).append("\n"); 
		query.append("      ISS.BL_RDY_OFC_CD AS BL_READY_OFFICE ," ).append("\n"); 
		query.append("      ISS.BL_RDY_TP_CD AS BL_READY_TYPE ," ).append("\n"); 
		query.append("	  ISS.ORG_PPD_RCV_UPD_OFC_CD," ).append("\n"); 
		query.append("	  ISS.ORG_N3PTY_PPD_UPD_OFC_CD," ).append("\n"); 
		query.append("	  ISS.DEST_CLT_RCV_UPD_OFC_CD," ).append("\n"); 
		query.append("	  ISS.DEST_N3PTY_CLT_UPD_OFC_CD," ).append("\n"); 
		query.append("      BL.BL_OBRD_TP_CD AS ON_BOARD_TYPE ," ).append("\n"); 
		query.append("      BL.BL_OBRD_DT AS ON_BOARD_DATE ," ).append("\n"); 
		query.append("	  ISS.BL_CPY_KNT AS BL_ISSUE_NO ," ).append("\n"); 
		query.append("      ISS.BL_CPY_NO AS BL_CPY_NO ," ).append("\n"); 
		query.append("      ISS.OBL_ISS_DT AS BL_ISSUE_DATE ," ).append("\n"); 
		query.append("      ISS.OBL_RLSE_FLG AS BL_ISSUE_RELEASE ," ).append("\n"); 
		query.append("      DECODE(ISS.OBL_ISS_OFC_CD, NULL, BKG.BKG_OFC_CD, ISS.OBL_ISS_OFC_CD) AS BL_ISSUE_AT , " ).append("\n"); 
		query.append("      ISS.OBL_ISS_USR_ID AS BL_ISSUE_BY ," ).append("\n"); 
		query.append("      ISS.OBL_ISS_FLG AS ISSUED ," ).append("\n"); 
		query.append("      ISS.OBL_RLSE_FLG AS RELEASED ," ).append("\n"); 
		query.append("      ISS.ORG_PPD_RCV_UPD_USR_ID AS PPD_RCV_USER_ID ," ).append("\n"); 
		query.append("      ISS.ORG_PPD_RCV_UPD_DT AS PPD_RCV_DT ," ).append("\n"); 
		query.append("      ISS.ORG_N3PTY_PPD_UPD_USR_ID AS TRD_PPD_RCV_USER_ID ," ).append("\n"); 
		query.append("      ISS.ORG_N3PTY_PPD_UPD_DT AS TRD_PPD_RCV_DT ," ).append("\n"); 
		query.append("      ISS.DEST_CLT_RCV_UPD_USR_ID AS CCT_RCV_USER_ID ," ).append("\n"); 
		query.append("      ISS.DEST_CLT_RCV_UPD_DT AS CCT_RCV_DT ," ).append("\n"); 
		query.append("      ISS.DEST_N3PTY_CLT_UPD_USR_ID AS TRD_CCT_RCV_USER_ID ," ).append("\n"); 
		query.append("      ISS.DEST_N3PTY_CLT_UPD_DT AS TRD_CCT_RCV_DT ," ).append("\n"); 
		query.append("      CASE WHEN ISS.OTR_DOC_CGOR_FLG = 'Y' THEN 'L' ELSE BKG.BL_TP_CD END O_BLRECEIVE_TYPE ," ).append("\n"); 
		query.append("      ISS.OBL_RDEM_KNT AS O_BLRECEIVE_NO ," ).append("\n"); 
		query.append("      CASE WHEN ISS.OTR_DOC_CGOR_FLG = 'Y' THEN ISS.OTR_DOC_RCV_DT ELSE ISS.OBL_RDEM_DT END O_BLRECEIVE_DATE ," ).append("\n"); 
		query.append("      CASE WHEN ISS.OTR_DOC_CGOR_FLG = 'Y' THEN ISS.OTR_DOC_RCV_OFC_CD ELSE ISS.OBL_RDEM_OFC_CD END O_BLRECEIVE_AT ," ).append("\n"); 
		query.append("      CASE WHEN ISS.OTR_DOC_CGOR_FLG = 'Y' THEN ISS.OTR_DOC_RCV_USR_ID ELSE ISS.OBL_RDEM_USR_ID END O_BLRECEIVE_BY ," ).append("\n"); 
		query.append("      ISS.OBL_SRND_FLG AS SURRENDER ," ).append("\n"); 
		query.append("      ISS.BL_PRF_SHPR_FLG AS BL_PROOFBYSHIPPER_CHECKBOX," ).append("\n"); 
		query.append("      ISS.BL_PRF_SHPR_OFC_CD AS BL_PROOFBYSHIPPER_OFFICE," ).append("\n"); 
		query.append("      ISS.BL_PRF_SHPR_USR_ID AS BL_PROOFBYSHIPPER_BY," ).append("\n"); 
		query.append("	  ISS.OBL_ISS_RMK," ).append("\n"); 
		query.append("      TO_CHAR(ISS.BL_PRF_SHPR_DT, 'YYYY-MM-DD') BL_PROOFBYSHIPPER_DATE ," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT DOT_PRN_FLG" ).append("\n"); 
		query.append("        FROM BKG_USR_DFLT_SET" ).append("\n"); 
		query.append("        WHERE USR_ID = @[usr_id] ) AS PRINT_OPTION ," ).append("\n"); 
		query.append("      CASE WHEN ISS.RQST_BL_TP_CD != NULL THEN 'Y' WHEN ISS.OBL_RT_INCL_KNT != NULL THEN 'Y' WHEN ISS.OBL_RT_XCLD_KNT != NULL THEN 'Y' WHEN ISS.OBL_TTL_KNT != NULL THEN 'Y' WHEN ISS.NON_NEGO_RT_INCL_KNT != NULL THEN 'Y' WHEN ISS.NON_NEGO_RT_XCLD_KNT != NULL THEN 'Y' WHEN ISS.CPY_TTL_KNT != NULL THEN 'Y' WHEN ISS.RQST_ISS_PLC_NM != NULL THEN 'Y' WHEN ISS.RQST_ISS_DT != NULL THEN 'Y' WHEN ISS.BL_DE_TO_CD != NULL THEN 'Y' WHEN ISS.BL_DE_MZD_CD != NULL THEN 'Y' WHEN ISS.BL_DOC_RQST_RMK != NULL THEN 'Y' ELSE 'N' END DOC_REQUEST_FLAG ," ).append("\n"); 
		query.append("            (SELECT CASE WHEN COUNT(USR_ID) > 0 THEN 'Y' ELSE 'N' END AUTH_FLAG" ).append("\n"); 
		query.append("               FROM BKG_INET_AUTH" ).append("\n"); 
		query.append("              WHERE USR_ID= @[usr_id] AND DELT_FLG='N') AUTH_FLAG ," ).append("\n"); 
		query.append("            ISS.OBL_INET_FLG AS INTERNET_AUTH ,      " ).append("\n"); 
		query.append("            DECODE(INET_FLG, 'Y', 'Y', ISS.OBL_PRN_FLG) OBL_PRN_FLG," ).append("\n"); 
		query.append("			ISS.INET_CTRL_PTY_NM," ).append("\n"); 
		query.append("			ISS.INET_CTRL_PTY_NO," ).append("\n"); 
		query.append("			(SELECT CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("			 FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("			 WHERE CUST_CNT_CD = ISS.INET_CTRL_PTY_NM " ).append("\n"); 
		query.append("			   AND CUST_SEQ = ISS.INET_CTRL_PTY_NO " ).append("\n"); 
		query.append("               AND ROWNUM =1 ) INET_CTRL_PTY_CUST_NM," ).append("\n"); 
		query.append("		ISS.BL_ISS_TP_CD AS BL_ISS_TP_CD," ).append("\n"); 
		query.append("        BL.BL_MV_TP_PRN_FLG," ).append("\n"); 
		query.append("        BL.RCV_DE_TERM_PRN_FLG," ).append("\n"); 
		query.append("		ISS.RQST_BL_TP_CD AS RQST_BL_TP_CD," ).append("\n"); 
		query.append("		DECODE(ISS.BKG_NO,NULL,'N','Y') ISS_SAVE_FLG" ).append("\n"); 
		query.append("    FROM BKG_BL_DOC BL," ).append("\n"); 
		query.append("      	 BKG_BL_ISS ISS," ).append("\n"); 
		query.append("		 BKG_BOOKING BKG," ).append("\n"); 
		query.append("		 (SELECT BKG.BKG_NO, DECODE(NVL(INET.BKG_NO, '*'), '*', 'N', 'Y') INET_FLG" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("                (SELECT BKG_NO, MAX(INFO_SEQ) INFO_SEQ" ).append("\n"); 
		query.append("                FROM BKG_INET_BL_PRN_AUTH" ).append("\n"); 
		query.append("                WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                AND N1ST_PRN_DT IS NOT NULL" ).append("\n"); 
		query.append("                GROUP BY BKG_NO) INET" ).append("\n"); 
		query.append("          WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND BKG.BKG_NO = INET.BKG_NO(+)" ).append("\n"); 
		query.append("          ) AUTH" ).append("\n"); 
		query.append("    WHERE BKG.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("	  AND BL.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("      AND BL.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND BKG.BKG_NO = AUTH.BKG_NO ) M ," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT *" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT BKG_NO ," ).append("\n"); 
		query.append("          BL_NO ," ).append("\n"); 
		query.append("		  BL_TP_CD ," ).append("\n"); 
		query.append("          VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS TVVD ," ).append("\n"); 
		query.append("          BKG_STS_CD AS BKG_STS ," ).append("\n"); 
		query.append("          BL_TP_CD AS BL_ISSUEBL_TYPE ," ).append("\n"); 
		query.append("          POR_CD AS NPOR_CODE," ).append("\n"); 
		query.append("          CUST_TO_ORD_FLG ," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT LOC_NM" ).append("\n"); 
		query.append("            FROM MDM_LOCATION" ).append("\n"); 
		query.append("            WHERE LOC_CD =POR_CD) AS NPOR_NAME ," ).append("\n"); 
		query.append("          POL_CD AS NPOL_CODE ," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT LOC_NM" ).append("\n"); 
		query.append("            FROM MDM_LOCATION" ).append("\n"); 
		query.append("            WHERE LOC_CD =POL_CD) AS NPOL_NAME ," ).append("\n"); 
		query.append("          POD_CD AS NPOD_CODE ," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT LOC_NM" ).append("\n"); 
		query.append("            FROM MDM_LOCATION" ).append("\n"); 
		query.append("            WHERE LOC_CD =POD_CD) AS NPOD_NAME ," ).append("\n"); 
		query.append("          DEL_CD AS NDEL_CODE ," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT LOC_NM" ).append("\n"); 
		query.append("            FROM MDM_LOCATION" ).append("\n"); 
		query.append("            WHERE LOC_CD =DEL_CD) AS NDEL_NAME ," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT SKD.VPS_ETD_DT" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD SKD," ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("                SELECT VSL_CD," ).append("\n"); 
		query.append("                  SKD_VOY_NO," ).append("\n"); 
		query.append("                  SKD_DIR_CD," ).append("\n"); 
		query.append("                  POL_CD," ).append("\n"); 
		query.append("                  POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                FROM BKG_VVD" ).append("\n"); 
		query.append("                WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  AND VSL_PRE_PST_CD||VSL_SEQ = (" ).append("\n"); 
		query.append("                    SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ)" ).append("\n"); 
		query.append("                    FROM BKG_VVD" ).append("\n"); 
		query.append("                    WHERE BKG_NO = @[bkg_no]) ) VVD" ).append("\n"); 
		query.append("            WHERE SKD.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("              AND SKD.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND SKD.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND SKD.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("              AND SKD.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ ) AS POL_ETD_DT" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("        WHERE BKG_NO = @[bkg_no] ) BKG," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT MAX(BKG_NO) BKG_NO," ).append("\n"); 
		query.append("          MAX(DECODE(BKG_CUST_TP_CD, 'S', CUST_NM, '')) AS SHPR_NAME," ).append("\n"); 
		query.append("          MAX(DECODE(BKG_CUST_TP_CD, 'S', CUST_ADDR, '')) AS SHPR_ADDRESS," ).append("\n"); 
		query.append("          MAX(DECODE(BKG_CUST_TP_CD, 'F', CUST_NM, '')) AS F_FWD_NAME," ).append("\n"); 
		query.append("          MAX(DECODE(BKG_CUST_TP_CD, 'F', CUST_ADDR, '')) AS F_FWD_ADDRESS" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT BKG_NO," ).append("\n"); 
		query.append("              BKG_CUST_TP_CD," ).append("\n"); 
		query.append("              CUST_NM ," ).append("\n"); 
		query.append("              CUST_ADDR" ).append("\n"); 
		query.append("            FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("            WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND BKG_CUST_TP_CD IN ('S'," ).append("\n"); 
		query.append("                  'F') ) ) CUS," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DTL.BKG_NO," ).append("\n"); 
		query.append("(SELECT DO_NO FROM BKG_DO WHERE BKG_NO = DTL.BKG_NO  AND RLSE_SEQ= DTL.RLSE_SEQ ) AS DO_ISSUE_NO," ).append("\n"); 
		query.append("EVNT_DT AS DO_ISSUE_DATE," ).append("\n"); 
		query.append("EVNT_OFC_CD AS DO_ISSUE_AT," ).append("\n"); 
		query.append("EVNT_USR_ID AS DO_ISSUE_BY" ).append("\n"); 
		query.append("FROM BKG_DO_DTL DTL," ).append("\n"); 
		query.append("  BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE DTL.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND BKG.BKG_NO = DTL.BKG_NO" ).append("\n"); 
		query.append("  AND DTL.RLSE_STS_CD = DECODE(SUBSTR(BKG.DEL_CD, 1, 2), 'JP', 'D', 'R')" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT BKG.BKG_NO," ).append("\n"); 
		query.append("  '' AS DO_ISSUE_NO," ).append("\n"); 
		query.append("  CGO.MRN_TML_EDI_LST_SND_DT AS DO_ISSUE_DATE," ).append("\n"); 
		query.append("  '' AS DO_ISSUE_AT," ).append("\n"); 
		query.append("  '' AS DO_ISSUE_BY" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("  BKG_CGO_RLSE CGO," ).append("\n"); 
		query.append("  BKG_CSTMS_ADV_BL AMS" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND BKG.BL_NO = CGO.BL_NO" ).append("\n"); 
		query.append("  AND CGO.FRT_CLT_FLG = 'Y'" ).append("\n"); 
		query.append("  AND CGO.OBL_RDEM_FLG = 'Y'" ).append("\n"); 
		query.append("  AND CGO.CSTMS_CLR_CD = 'Y'" ).append("\n"); 
		query.append("  AND CGO.BL_NO = AMS.BL_NO" ).append("\n"); 
		query.append("  AND AMS.CNT_CD = 'US'" ).append("\n"); 
		query.append(") DO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    WHERE BKG.BKG_NO = CUS.BKG_NO(+)" ).append("\n"); 
		query.append("      AND BKG.BKG_NO = DO.BKG_NO(+)" ).append("\n"); 
		query.append(") S," ).append("\n"); 
		query.append("(SELECT MAX(CGO_RCV_DT) AS CGO_RCV_DT FROM BKG_CONTAINER" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(") C" ).append("\n"); 

	}
}