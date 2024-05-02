/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOsearchAncsCstmsBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.12
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.10.12 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOsearchAncsCstmsBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * 1. 2010.12.28 경종윤 BKG_VVD.POD_CD = 'BEANR' 정보를 추가로 걸어 줌
	  * 2. 2011.01.11 이수진 [CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청
	  *    : MRN 정보 추가 (BKG_CSTMS_EUR_BL.MVMT_REF_NO)
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOsearchAncsCstmsBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOsearchAncsCstmsBlRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("VVD.LLOYD_TP_CD || VVD.LLOYD_NO AS LLOYD_CD," ).append("\n"); 
		query.append("VVD.SVC_RQST_NO," ).append("\n"); 
		query.append("(SEQ.SEQ+1) SEQUENCE," ).append("\n"); 
		query.append("SEQ.SEQ PREV_DOCNO," ).append("\n"); 
		query.append("BL.ACT_WGT," ).append("\n"); 
		query.append("BL.ACT_WGT_UT_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN LENGTH(BL.VVD_SEQ) = 1  THEN '000'||BL.VVD_SEQ " ).append("\n"); 
		query.append("WHEN LENGTH(BL.VVD_SEQ) = 2  THEN '00'||BL.VVD_SEQ" ).append("\n"); 
		query.append("WHEN LENGTH(BL.VVD_SEQ) = 3  THEN '0'||BL.VVD_SEQ" ).append("\n"); 
		query.append("WHEN LENGTH(BL.VVD_SEQ) = 4  THEN ''||BL.VVD_SEQ" ).append("\n"); 
		query.append("END AS VVD_SEQ," ).append("\n"); 
		query.append("(BL.BL_NO) BL_NO," ).append("\n"); 
		query.append("BL.PCK_QTY," ).append("\n"); 
		query.append("BL.PCK_TP_CD," ).append("\n"); 
		query.append("VVD.BRTH_DESC," ).append("\n"); 
		query.append("BL.POL_CD," ).append("\n"); 
		query.append("BL.PRE_RLY_PORT_CD," ).append("\n"); 
		query.append("BL.PST_RLY_PORT_CD," ).append("\n"); 
		query.append("BL.POR_CD," ).append("\n"); 
		query.append("BL.DEL_CD," ).append("\n"); 
		query.append("BL.SHPR_ADDR," ).append("\n"); 
		query.append("BL.CNEE_ADDR," ).append("\n"); 
		query.append("SUBSTR(TRANSLATE(NTFY.NTFY_NM, CHR(13) || CHR(10), ' '), 1, 45) AS NTFY_NAME," ).append("\n"); 
		query.append("NTFY.NTFY_ADDR," ).append("\n"); 
		query.append("NTFY.FAX_NO," ).append("\n"); 
		query.append("NTFY.NTFY_EML," ).append("\n"); 
		query.append("CM.CNTR_SEQ," ).append("\n"); 
		query.append("CM.PCK_QTY CM_PCK_QTY," ).append("\n"); 
		query.append("CM.PCK_TP_CD CM_PCK_TP_CD," ).append("\n"); 
		query.append("CM.CNTR_MF_DESC," ).append("\n"); 
		query.append("CM.CNTR_MF_WGT," ).append("\n"); 
		query.append("CM.WGT_UT_CD," ).append("\n"); 
		query.append("CM.CNTR_NO CM_CNTR_NO," ).append("\n"); 
		query.append("DECODE( CM.DECL_FLG, 'Y', 'T1', 'C' ) DECL_FLG," ).append("\n"); 
		query.append("CNTR.CNTR_NO," ).append("\n"); 
		query.append("CNTR.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("DECODE(BL.BKG_CGO_TP_CD, 'F', 'F', 'E') CNTR_FM," ).append("\n"); 
		query.append("(CNTR.ORG_RCV_TERM_CD||CNTR.DEST_DE_TERM_CD) AS RD_TERM," ).append("\n"); 
		query.append("(BL.BKG_NO) KIND," ).append("\n"); 
		query.append("NVL(BL.ANR_MSG_STS_CD, 'N')BL_ACK," ).append("\n"); 
		query.append("DECODE(NVL(BL.ANR_MSG_STS_CD, 'N'), 'A', 'Y', 'N' )BL_ACK2," ).append("\n"); 
		query.append("NVL(BL_LOG.SND_STS_CD, 'N') || NVL(BL_LOG.RCV_STS_CD, 'N') BL_LAST_EDI," ).append("\n"); 
		query.append("BL_EDI_SND_RCV_STS.ATTR_CTNT2 AS BL_LAST_EDI2," ).append("\n"); 
		query.append("NVL(CNTR.ANR_MSG_STS_CD, 'N')CNTR_ACK," ).append("\n"); 
		query.append("DECODE(NVL(CNTR.ANR_MSG_STS_CD, 'N'), 'A', 'Y', 'N' ) CNTR_ACK2," ).append("\n"); 
		query.append("NVL(CNTR_LOG.SND_STS_CD, 'N') || NVL(CNTR_LOG.RCV_STS_CD, 'N') CNTR_LAST_EDI," ).append("\n"); 
		query.append("CNTR_EDI_SND_RCV_STS.ATTR_CTNT2 AS CNTR_LAST_EDI2," ).append("\n"); 
		query.append("BL.POD_CD," ).append("\n"); 
		query.append("BL.BDR_FLG," ).append("\n"); 
		query.append("BL.BKG_NO," ).append("\n"); 
		query.append("BL.ANR_MSG_STS_CD," ).append("\n"); 
		query.append("CNTR.PCK_TP_CD CNTR_PCK_TP_CD," ).append("\n"); 
		query.append("CNTR.PCK_QTY CNTR_PCK_QTY," ).append("\n"); 
		query.append("CNTR.CNTR_WGT CNTR_WGT_QTY," ).append("\n"); 
		query.append("CNTR.WGT_UT_CD CNTR_WGT_UT_CD," ).append("\n"); 
		query.append("CNTR.ANR_MSG_STS_CD CNTR_ANR_MSG_STS_CD," ).append("\n"); 
		query.append("SUBSTR(TRANSLATE(CM.CNTR_MF_DESC, CHR(13) || CHR(10), ' '), 1, 45) AS MF_DESC," ).append("\n"); 
		query.append("VVD.SVC_RQST_NO || VVD.LLOYD_TP_CD || VVD.LLOYD_NO AS ANR_DECL_NO," ).append("\n"); 
		query.append("MSG_SEQ.MSG_SEQ," ).append("\n"); 
		query.append("BL_LOG.MSG_TP_CD," ).append("\n"); 
		query.append("'' shpr_name," ).append("\n"); 
		query.append("'' cnee_name," ).append("\n"); 
		query.append("EB.MVMT_REF_NO MRN_NO" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_BL BL," ).append("\n"); 
		query.append("BKG_CSTMS_ANR_CNTR CNTR," ).append("\n"); 
		query.append("BKG_CSTMS_ANR_CMDT CM," ).append("\n"); 
		query.append("BKG_CSTMS_ANR_NTFY NTFY," ).append("\n"); 
		query.append("( SELECT BB.BL_NO," ).append("\n"); 
		query.append("AA.EDI_SND_STS_CD AS SND_STS_CD," ).append("\n"); 
		query.append("BB.EDI_RCV_STS_CD AS RCV_STS_CD," ).append("\n"); 
		query.append("BB.MSG_TP_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_EDI_HIS AA," ).append("\n"); 
		query.append("BKG_CSTMS_ANR_BL_LOG BB," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT  C.MSG_TP_CD," ).append("\n"); 
		query.append("		C.ANR_DECL_NO," ).append("\n"); 
		query.append("		C.BL_NO," ).append("\n"); 
		query.append("	MAX(C.REF_SEQ) MAX_REF_SEQ" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_ANR_VVD A," ).append("\n"); 
		query.append("	BKG_CSTMS_ANR_EDI_HIS B," ).append("\n"); 
		query.append("	BKG_CSTMS_ANR_BL_LOG C," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVDINFO" ).append("\n"); 
		query.append("		FROM BKG_VVD A_VVD, BKG_CSTMS_ANR_BL B" ).append("\n"); 
		query.append("		WHERE B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("		AND A_VVD.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("		AND A_VVD.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("		AND A_VVD.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND A_VVD.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND A_VVD.POD_CD     = B.POD_CD" ).append("\n"); 
		query.append("	) D" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	WHERE A.VSL_CD   = SUBSTR( D.VVDINFO, 1, 4 )" ).append("\n"); 
		query.append("	AND A.SKD_VOY_NO = SUBSTR( D.VVDINFO, 5, 4 )" ).append("\n"); 
		query.append("	AND A.SKD_DIR_CD = SUBSTR( D.VVDINFO, 9, 1 )" ).append("\n"); 
		query.append("	AND B.MSG_TP_CD = 'C'" ).append("\n"); 
		query.append("	AND B.ANR_DECL_NO = A.SVC_RQST_NO || A.LLOYD_TP_CD || A.LLOYD_NO" ).append("\n"); 
		query.append("	AND C.MSG_TP_CD = B.MSG_TP_CD" ).append("\n"); 
		query.append("	AND C.ANR_DECL_NO = B.ANR_DECL_NO" ).append("\n"); 
		query.append("	AND C.REF_SEQ = B.REF_SEQ" ).append("\n"); 
		query.append("	AND C.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("	AND C.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND C.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("	GROUP BY C.MSG_TP_CD, C.ANR_DECL_NO, C.BL_NO) CC" ).append("\n"); 
		query.append("WHERE AA.MSG_TP_CD(+) = CC.MSG_TP_CD" ).append("\n"); 
		query.append("AND AA.ANR_DECL_NO(+) = CC.ANR_DECL_NO" ).append("\n"); 
		query.append("AND AA.REF_SEQ(+) = CC.MAX_REF_SEQ" ).append("\n"); 
		query.append("AND BB.MSG_TP_CD(+) = CC.MSG_TP_CD" ).append("\n"); 
		query.append("AND BB.ANR_DECL_NO(+) = CC.ANR_DECL_NO" ).append("\n"); 
		query.append("AND BB.REF_SEQ(+) = CC.MAX_REF_SEQ" ).append("\n"); 
		query.append("AND BB.BL_NO(+) = CC.BL_NO ) BL_LOG," ).append("\n"); 
		query.append("( SELECT  BB.BKG_NO," ).append("\n"); 
		query.append("	BB.CNTR_NO," ).append("\n"); 
		query.append("	AA.EDI_SND_STS_CD AS SND_STS_CD," ).append("\n"); 
		query.append("	BB.EDI_RCV_STS_CD AS RCV_STS_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_EDI_HIS AA," ).append("\n"); 
		query.append("     BKG_CSTMS_ANR_CNTR_LOG BB," ).append("\n"); 
		query.append("     (  SELECT C.MSG_TP_CD," ).append("\n"); 
		query.append("		C.ANR_DECL_NO," ).append("\n"); 
		query.append("		C.BKG_NO," ).append("\n"); 
		query.append("		C.CNTR_NO," ).append("\n"); 
		query.append("		MAX(C.REF_SEQ) MAX_REF_SEQ" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_ANR_VVD A," ).append("\n"); 
		query.append("	     BKG_CSTMS_ANR_EDI_HIS B," ).append("\n"); 
		query.append("	     BKG_CSTMS_ANR_CNTR_LOG C," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVDINFO" ).append("\n"); 
		query.append("			FROM BKG_VVD A_VVD, BKG_CSTMS_ANR_BL B" ).append("\n"); 
		query.append("			WHERE B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("			AND A_VVD.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("			AND A_VVD.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("			AND A_VVD.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND A_VVD.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND A_VVD.POD_CD     = B.POD_CD" ).append("\n"); 
		query.append("		) D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	WHERE A.VSL_CD = SUBSTR( D.VVDINFO, 1, 4 )" ).append("\n"); 
		query.append("	AND A.SKD_VOY_NO = SUBSTR( D.VVDINFO, 5, 4 )" ).append("\n"); 
		query.append("	AND A.SKD_DIR_CD = SUBSTR( D.VVDINFO, 9, 1 )" ).append("\n"); 
		query.append("	AND B.MSG_TP_CD = 'C'" ).append("\n"); 
		query.append("	AND B.ANR_DECL_NO = A.SVC_RQST_NO || A.LLOYD_TP_CD || A.LLOYD_NO" ).append("\n"); 
		query.append("	AND C.MSG_TP_CD = B.MSG_TP_CD" ).append("\n"); 
		query.append("	AND C.ANR_DECL_NO = B.ANR_DECL_NO" ).append("\n"); 
		query.append("	AND C.REF_SEQ = B.REF_SEQ" ).append("\n"); 
		query.append("	AND C.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("	AND C.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND C.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("	GROUP BY C.MSG_TP_CD, C.ANR_DECL_NO, C.BKG_NO, C.CNTR_NO) CC" ).append("\n"); 
		query.append("WHERE AA.MSG_TP_CD(+) = CC.MSG_TP_CD" ).append("\n"); 
		query.append("AND AA.ANR_DECL_NO(+) = CC.ANR_DECL_NO" ).append("\n"); 
		query.append("AND AA.REF_SEQ(+) = CC.MAX_REF_SEQ" ).append("\n"); 
		query.append("AND BB.MSG_TP_CD(+) = CC.MSG_TP_CD" ).append("\n"); 
		query.append("AND BB.ANR_DECL_NO(+) = CC.ANR_DECL_NO" ).append("\n"); 
		query.append("AND BB.REF_SEQ(+) = CC.MAX_REF_SEQ" ).append("\n"); 
		query.append("AND BB.BKG_NO(+) = CC.BKG_NO" ).append("\n"); 
		query.append("AND BB.CNTR_NO(+) = CC.CNTR_NO ) CNTR_LOG," ).append("\n"); 
		query.append("BKG_CSTMS_ANR_VVD VVD," ).append("\n"); 
		query.append("( SELECT NVL( MAX(REF_SEQ), 0) SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_EDI_HIS HIS," ).append("\n"); 
		query.append("     BKG_CSTMS_ANR_VVD VVD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVDINFO" ).append("\n"); 
		query.append("		FROM BKG_VVD A_VVD, BKG_CSTMS_ANR_BL B" ).append("\n"); 
		query.append("		WHERE B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("		AND A_VVD.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("		AND A_VVD.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("		AND A_VVD.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND A_VVD.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND A_VVD.POD_CD     = B.POD_CD" ).append("\n"); 
		query.append("	) D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE VVD.VSL_CD = SUBSTR( D.VVDINFO, 1, 4 )" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = SUBSTR( D.VVDINFO, 5, 4 )" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = SUBSTR( D.VVDINFO, 9, 1 )" ).append("\n"); 
		query.append("AND HIS.ANR_DECL_NO = VVD.SVC_RQST_NO || VVD.LLOYD_TP_CD || VVD.LLOYD_NO" ).append("\n"); 
		query.append("AND HIS.MSG_TP_CD = 'C' " ).append("\n"); 
		query.append(" ) SEQ," ).append("\n"); 
		query.append("( SELECT NVL(MAX(A.MSG_SEQ), 0) + 1 AS MSG_SEQ" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_ANR_EDI_MSG A," ).append("\n"); 
		query.append("         ( SELECT NVL( MAX(REF_SEQ), 0) SEQ," ).append("\n"); 
		query.append("                  ANR_DECL_NO" ).append("\n"); 
		query.append("           FROM BKG_CSTMS_ANR_EDI_HIS HIS," ).append("\n"); 
		query.append("                BKG_CSTMS_ANR_VVD VVD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVDINFO" ).append("\n"); 
		query.append("				FROM BKG_VVD A_VVD, BKG_CSTMS_ANR_BL B" ).append("\n"); 
		query.append("				WHERE B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("				AND A_VVD.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("				AND A_VVD.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("				AND A_VVD.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("				AND A_VVD.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("				AND A_VVD.POD_CD     = B.POD_CD" ).append("\n"); 
		query.append("			) D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           WHERE VVD.VSL_CD = SUBSTR( D.VVDINFO, 1, 4 )" ).append("\n"); 
		query.append("	   AND VVD.SKD_VOY_NO = SUBSTR( D.VVDINFO, 5, 4 )" ).append("\n"); 
		query.append("	   AND VVD.SKD_DIR_CD = SUBSTR( D.VVDINFO, 9, 1 )" ).append("\n"); 
		query.append("	   AND HIS.ANR_DECL_NO = VVD.SVC_RQST_NO || VVD.LLOYD_TP_CD || VVD.LLOYD_NO" ).append("\n"); 
		query.append("	   AND HIS.MSG_TP_CD = 'C'" ).append("\n"); 
		query.append("	   GROUP BY ANR_DECL_NO) HISINFO" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND A.MSG_TP_CD = 'C'" ).append("\n"); 
		query.append("    AND A.RCV_SND_DIV_CD = 'S'" ).append("\n"); 
		query.append("    AND A.ANR_DECL_NO = HISINFO.ANR_DECL_NO" ).append("\n"); 
		query.append("    AND A.REF_SEQ = HISINFO.SEQ  )MSG_SEQ," ).append("\n"); 
		query.append("( SELECT CNTR_NO," ).append("\n"); 
		query.append("SUM(CNTR_WGT) CNTR_WGT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ANR_CNTR, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVDINFO" ).append("\n"); 
		query.append("		FROM BKG_VVD A_VVD, BKG_CSTMS_ANR_BL B" ).append("\n"); 
		query.append("		WHERE B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("		AND A_VVD.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("		AND A_VVD.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("		AND A_VVD.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND A_VVD.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND A_VVD.POD_CD     = B.POD_CD" ).append("\n"); 
		query.append("	) D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR( D.VVDINFO, 1, 4 )" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR( D.VVDINFO, 5, 4 )" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR( D.VVDINFO, 9, 1 )" ).append("\n"); 
		query.append("GROUP BY CNTR_NO ) CNTR_WGT," ).append("\n"); 
		query.append("BKG_HRD_CDG_CTNT BL_EDI_SND_RCV_STS," ).append("\n"); 
		query.append("BKG_HRD_CDG_CTNT CNTR_EDI_SND_RCV_STS," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVDINFO" ).append("\n"); 
		query.append("	FROM BKG_VVD A_VVD, BKG_CSTMS_ANR_BL B" ).append("\n"); 
		query.append("	WHERE B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("	AND A_VVD.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("	AND A_VVD.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("	AND A_VVD.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND A_VVD.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND A_VVD.POD_CD     = B.POD_CD" ).append("\n"); 
		query.append(") D," ).append("\n"); 
		query.append("BKG_CSTMS_EUR_BL EB" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND BL.VSL_CD = SUBSTR( D.VVDINFO, 1, 4 )" ).append("\n"); 
		query.append("AND BL.SKD_VOY_NO = SUBSTR( D.VVDINFO, 5, 4 )" ).append("\n"); 
		query.append("AND BL.SKD_DIR_CD = SUBSTR( D.VVDINFO, 9, 1 )" ).append("\n"); 
		query.append("AND VVD.VSL_CD = BL.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = BL.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = BL.SKD_DIR_CD" ).append("\n"); 
		query.append("AND CNTR.VSL_CD(+) = BL.VSL_CD" ).append("\n"); 
		query.append("AND CNTR.SKD_VOY_NO(+) = BL.SKD_VOY_NO" ).append("\n"); 
		query.append("AND CNTR.SKD_DIR_CD(+) = BL.SKD_DIR_CD" ).append("\n"); 
		query.append("AND CNTR.BKG_NO(+) = BL.BKG_NO" ).append("\n"); 
		query.append("AND CM.VSL_CD(+) = CNTR.VSL_CD" ).append("\n"); 
		query.append("AND CM.SKD_VOY_NO(+) = CNTR.SKD_VOY_NO" ).append("\n"); 
		query.append("AND CM.SKD_DIR_CD(+) = CNTR.SKD_DIR_CD" ).append("\n"); 
		query.append("AND CM.BKG_NO(+) = CNTR.BKG_NO" ).append("\n"); 
		query.append("AND CM.CNTR_NO(+) = CNTR.CNTR_NO" ).append("\n"); 
		query.append("AND NTFY.BKG_NO(+) = BL.BKG_NO" ).append("\n"); 
		query.append("AND NTFY.NTFY_SEQ(+) = 1" ).append("\n"); 
		query.append("AND BL_LOG.BL_NO(+) = BL.BL_NO" ).append("\n"); 
		query.append("AND CNTR_LOG.BKG_NO(+) = CNTR.BKG_NO" ).append("\n"); 
		query.append("AND CNTR_LOG.CNTR_NO(+) = CNTR.CNTR_NO" ).append("\n"); 
		query.append("AND CNTR_WGT.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("AND BL_EDI_SND_RCV_STS.HRD_CDG_ID(+) = 'ANR_CSTMS_EDI_STS_CD'" ).append("\n"); 
		query.append("AND BL_EDI_SND_RCV_STS.ATTR_CTNT1(+) = NVL(BL_LOG.SND_STS_CD, 'N') || NVL(BL_LOG.RCV_STS_CD, 'N')" ).append("\n"); 
		query.append("AND CNTR_EDI_SND_RCV_STS.HRD_CDG_ID(+) = 'ANR_CSTMS_EDI_STS_CD'" ).append("\n"); 
		query.append("AND CNTR_EDI_SND_RCV_STS.ATTR_CTNT1(+) = NVL(CNTR_LOG.SND_STS_CD, 'N') || NVL(CNTR_LOG.RCV_STS_CD, 'N')" ).append("\n"); 
		query.append("AND BL.VSL_CD = EB.VSL_CD(+)" ).append("\n"); 
		query.append("AND BL.SKD_VOY_NO = EB.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND BL.SKD_DIR_CD = EB.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND BL.BL_NO = EB.BL_NO(+)" ).append("\n"); 
		query.append("AND BL.CSTMS_POD_CD = EB.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("ORDER BY BL.BL_NO" ).append("\n"); 

	}
}