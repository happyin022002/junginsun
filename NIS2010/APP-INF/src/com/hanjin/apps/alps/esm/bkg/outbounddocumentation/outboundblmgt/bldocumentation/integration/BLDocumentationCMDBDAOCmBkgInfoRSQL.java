/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCmBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCmBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCmBkgInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCmBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      A.BL_NO || NVL(A.BL_TP_CD, DECODE(E.OBL_SRND_FLG, 'Y', 'S', NULL)) AS BL_NO" ).append("\n"); 
		query.append(",      A.BL_TP_CD" ).append("\n"); 
		query.append(",      A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append(",      A.VSL_CD " ).append("\n"); 
		query.append(",      A.SKD_VOY_NO" ).append("\n"); 
		query.append(",      A.SKD_DIR_CD" ).append("\n"); 
		query.append(",      A.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",      A.POR_CD" ).append("\n"); 
		query.append(",      A.POL_CD" ).append("\n"); 
		query.append(",      A.POD_CD" ).append("\n"); 
		query.append(",      A.DEL_CD" ).append("\n"); 
		query.append(",      A.PRE_RLY_PORT_CD" ).append("\n"); 
		query.append(",      A.PST_RLY_PORT_CD" ).append("\n"); 
		query.append(",      A.RCV_TERM_CD BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",      A.DE_TERM_CD BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",      A.CMDT_CD" ).append("\n"); 
		query.append(",      A.REP_CMDT_CD" ).append("\n"); 
		query.append(",      A.BKG_STS_CD " ).append("\n"); 
		query.append(",      (SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD=A.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append(",      B.BDR_FLG " ).append("\n"); 
		query.append(",      NVL2(B.CORR_NO, 'Y', 'N') CORR_FLG" ).append("\n"); 
		query.append(",      'N' HTS_FLG" ).append("\n"); 
		query.append(",      B.PCK_QTY BKG_PCK_QTY" ).append("\n"); 
		query.append(",      B.PCK_TP_CD  BKG_PCK_UNIT" ).append("\n"); 
		query.append(",      B.ACT_WGT BKG_WGT_QTY" ).append("\n"); 
		query.append(",      B.WGT_UT_CD  BKG_WGT_UNIT" ).append("\n"); 
		query.append(",      B.MEAS_QTY BKG_MEAS_QTY" ).append("\n"); 
		query.append(",      B.MEAS_UT_CD BKG_MEAS_UNIT" ).append("\n"); 
		query.append(",      C.CUST_CNT_CD SHPR_CNT_CD" ).append("\n"); 
		query.append(",      C.CUST_SEQ SHPR_SEQ" ).append("\n"); 
		query.append(",      C.CUST_NM SHPR_NM" ).append("\n"); 
		query.append(",      D.CUST_CNT_CD CNEE_CNT_CD" ).append("\n"); 
		query.append(",      D.CUST_SEQ CNEE_SEQ" ).append("\n"); 
		query.append(",      D.CUST_NM CNEE_NM" ).append("\n"); 
		query.append(",      (SELECT MK_DESC FROM BKG_BL_MK_DESC_HIS WHERE BKG_NO = A.BKG_NO AND CORR_NO='TMP0000001' AND MK_SEQ=1) BKG_MK_DESC" ).append("\n"); 
		query.append(",      (SELECT CSTMS_DESC FROM BKG_BL_DOC_HIS WHERE BKG_NO = A.BKG_NO AND CORR_NO='TMP0000001') BKG_CSTMS_DESC" ).append("\n"); 
		query.append(",      (SELECT 'Y' FROM BKG_VVD_HIS VVD WHERE VVD.BKG_NO = A.BKG_NO AND CORR_NO='TMP0000001'  AND VSL_PRE_PST_CD||VSL_SEQ<>'S1' AND POL_CD='MYPKG') MYPKG_FLG" ).append("\n"); 
		query.append(",      (SELECT 'Y' FROM BKG_VVD_HIS VVD" ).append("\n"); 
		query.append("        WHERE BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("          AND POL_CD = 'MYPKG'" ).append("\n"); 
		query.append("          AND VVD.CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("          AND EXISTS (SELECT 'Y' FROM BKG_BKG_HIS BK WHERE BK.BKG_NO = VVD.BKG_NO AND BK.POL_CD <> 'MYPKG' AND BK.POD_CD <> 'MYPKG' AND BK.CORR_NO='TMP0000001')" ).append("\n"); 
		query.append("          AND ROWNUM = 1 ) MYPKG_FLG" ).append("\n"); 
		query.append(",      A.CRE_USR_ID" ).append("\n"); 
		query.append(",      A.UPD_USR_ID" ).append("\n"); 
		query.append(",	   DECODE((SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = A.POD_CD),'E','Y','N') EUR_FLG" ).append("\n"); 
		query.append(",	   (SELECT 'Y' " ).append("\n"); 
		query.append("          FROM BKG_VVD_HIS BK " ).append("\n"); 
		query.append("         WHERE BK.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND BK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("           AND BK.POD_CD LIKE 'DE%'" ).append("\n"); 
		query.append("           AND A.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) DE_FLG" ).append("\n"); 
		query.append(",	   (SELECT 'Y' " ).append("\n"); 
		query.append("          FROM BKG_HRD_CDG_CTNT HRD" ).append("\n"); 
		query.append("         WHERE A.POD_CD LIKE HRD.ATTR_CTNT1 || '%'" ).append("\n"); 
		query.append("           AND HRD.HRD_CDG_ID = 'HS_EU_CNT'" ).append("\n"); 
		query.append("           AND A.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("           AND ROWNUM = 1 " ).append("\n"); 
		query.append("       ) HS_EU_FLG" ).append("\n"); 
		query.append(",	  NVL((SELECT 'Y' " ).append("\n"); 
		query.append("          FROM BKG_VVD_HIS BK " ).append("\n"); 
		query.append("         WHERE BK.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND BK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("           AND BK.POD_CD LIKE 'TR%'" ).append("\n"); 
		query.append("           AND ROWNUM = 1 " ).append("\n"); 
		query.append("       ),'N') TR_FLG" ).append("\n"); 
		query.append(" ,  (SELECT CASE WHEN COUNT(1) > 0 THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N' END AS" ).append("\n"); 
		query.append("       FROM	BKG_VVD_HIS VVD" ).append("\n"); 
		query.append("      WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND VVD.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("        AND	POD_CD IN " ).append("\n"); 
		query.append("       (SELECT	vps_port_cd --POD에 들리기 이전이라면" ).append("\n"); 
		query.append("          FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("         WHERE	vsl_cd		= VVD.VSL_CD" ).append("\n"); 
		query.append("           AND	skd_voy_no	= VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND	skd_dir_cd	= VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND	clpt_ind_seq= '1'" ).append("\n"); 
		query.append("           AND	clpt_seq	>=" ).append("\n"); 
		query.append("            (SELECT	MIN(clpt_seq) --처음 CANADA를 들리는 port가" ).append("\n"); 
		query.append("               FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("              WHERE	vsl_cd		= VVD.VSL_CD" ).append("\n"); 
		query.append("                AND	skd_voy_no	= VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND	skd_dir_cd	= VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND	vps_port_cd	LIKE 'US%'" ).append("\n"); 
		query.append("                AND	nvl(skd_cng_sts_cd, ' ') <> 'S'" ).append("\n"); 
		query.append("                AND	clpt_seq	>= " ).append("\n"); 
		query.append("                (SELECT	MAX(clpt_seq) --출항 port 이후에" ).append("\n"); 
		query.append("                   FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("                  WHERE	vsl_cd		= VVD.VSL_CD" ).append("\n"); 
		query.append("                    AND	skd_voy_no	= VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND	skd_dir_cd	= VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND	vps_port_cd	LIKE VVD.POL_CD " ).append("\n"); 
		query.append("                    AND	nvl(skd_cng_sts_cd, ' ') <> 'S') ) )" ).append("\n"); 
		query.append("       AND SUBSTR(VVD.POL_CD, 1, 2) <> 'US'--POL이 CANADA일 때는 제외" ).append("\n"); 
		query.append("       AND SUBSTR(VVD.POD_CD, 1, 2) <> 'US'--POD가 CANADA일 때는 제외  " ).append("\n"); 
		query.append("      ) AS US_FROB_FLG  " ).append("\n"); 
		query.append("     ,NVL(( SELECT 'Y'" ).append("\n"); 
		query.append("              FROM DUAL" ).append("\n"); 
		query.append("             WHERE A.POD_CD like 'RU%'" ).append("\n"); 
		query.append("               AND (SUBSTR(A.POR_CD,1,2) IN ('US','CA', 'AU')" ).append("\n"); 
		query.append("               OR SUBSTR(A.POR_CD,1,2) IN (SELECT A.CNT_CD" ).append("\n"); 
		query.append("                                            FROM MDM_COUNTRY A" ).append("\n"); 
		query.append("                                               , MDM_SUBCONTINENT B" ).append("\n"); 
		query.append("                                               , MDM_CONTINENT C" ).append("\n"); 
		query.append("                                            WHERE 1 = 1 " ).append("\n"); 
		query.append("                                            AND A.SCONTI_CD=B.SCONTI_CD " ).append("\n"); 
		query.append("                                            AND B.CONTI_CD=C.CONTI_CD" ).append("\n"); 
		query.append("                                            AND NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                            AND NVL(B.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                            AND NVL(C.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                            AND UPPER(B.CONTI_CD) LIKE UPPER('E') || '%'))),'N') RU_FLG " ).append("\n"); 
		query.append("FROM   BKG_BKG_HIS A, BKG_BL_DOC_HIS B, BKG_CUST_HIS C, BKG_CUST_HIS D, BKG_BL_ISS_HIS E" ).append("\n"); 
		query.append("WHERE  B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND    B.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    C.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND    C.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    C.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND    D.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND    D.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    D.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND    E.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("AND    E.CORR_NO(+) = A.CORR_NO" ).append("\n"); 
		query.append("AND    A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    A.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      A.BL_NO || NVL(A.BL_TP_CD, DECODE(E.OBL_SRND_FLG, 'Y', 'S', NULL)) AS BL_NO" ).append("\n"); 
		query.append(",      A.BL_TP_CD" ).append("\n"); 
		query.append(",      A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD T_VVD" ).append("\n"); 
		query.append(",      A.VSL_CD" ).append("\n"); 
		query.append(",      A.SKD_VOY_NO" ).append("\n"); 
		query.append(",      A.SKD_DIR_CD" ).append("\n"); 
		query.append(",      A.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",      A.POR_CD" ).append("\n"); 
		query.append(",      A.POL_CD" ).append("\n"); 
		query.append(",      A.POD_CD" ).append("\n"); 
		query.append(",      A.DEL_CD" ).append("\n"); 
		query.append(",      A.PRE_RLY_PORT_CD" ).append("\n"); 
		query.append(",      A.PST_RLY_PORT_CD" ).append("\n"); 
		query.append(",      A.RCV_TERM_CD BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",      A.DE_TERM_CD BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",      A.CMDT_CD" ).append("\n"); 
		query.append(",      A.REP_CMDT_CD" ).append("\n"); 
		query.append(",      A.BKG_STS_CD " ).append("\n"); 
		query.append(",      (SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD=A.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append(",      B.BDR_FLG " ).append("\n"); 
		query.append(",      NVL2(B.CORR_NO, 'Y', 'N') CORR_FLG" ).append("\n"); 
		query.append(",      'N' HTS_FLG" ).append("\n"); 
		query.append(",      B.PCK_QTY BKG_PCK_QTY" ).append("\n"); 
		query.append(",      B.PCK_TP_CD  BKG_PCK_UNIT" ).append("\n"); 
		query.append(",      B.ACT_WGT BKG_WGT_QTY" ).append("\n"); 
		query.append(",      B.WGT_UT_CD  BKG_WGT_UNIT" ).append("\n"); 
		query.append(",      B.MEAS_QTY BKG_MEAS_QTY" ).append("\n"); 
		query.append(",      B.MEAS_UT_CD BKG_MEAS_UNIT" ).append("\n"); 
		query.append(",      C.CUST_CNT_CD SHPR_CNT_CD" ).append("\n"); 
		query.append(",      C.CUST_SEQ SHPR_SEQ" ).append("\n"); 
		query.append(",      C.CUST_NM SHPR_NM" ).append("\n"); 
		query.append(",      D.CUST_CNT_CD CNEE_CNT_CD" ).append("\n"); 
		query.append(",      D.CUST_SEQ CNEE_SEQ" ).append("\n"); 
		query.append(",      D.CUST_NM CNEE_NM" ).append("\n"); 
		query.append(",      (SELECT MK_DESC FROM BKG_BL_MK_DESC WHERE BKG_NO = A.BKG_NO AND MK_SEQ = 1) BKG_MK_DESC" ).append("\n"); 
		query.append(",      (SELECT CSTMS_DESC FROM BKG_BL_DOC WHERE BKG_NO = A.BKG_NO) BKG_CSTMS_DESC" ).append("\n"); 
		query.append(",      (SELECT 'Y' FROM BKG_VVD VVD" ).append("\n"); 
		query.append("        WHERE BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("          AND POL_CD = 'MYPKG'" ).append("\n"); 
		query.append("          AND EXISTS (SELECT 'Y' FROM BKG_BOOKING BK WHERE BK.BKG_NO = VVD.BKG_NO AND BK.POL_CD <> 'MYPKG' AND BK.POD_CD <> 'MYPKG')" ).append("\n"); 
		query.append("          AND ROWNUM = 1 ) MYPKG_FLG" ).append("\n"); 
		query.append(",      A.CRE_USR_ID" ).append("\n"); 
		query.append(",      A.UPD_USR_ID" ).append("\n"); 
		query.append(",	   DECODE((SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = A.POD_CD),'E','Y','N') EUR_FLG" ).append("\n"); 
		query.append(",	   (SELECT 'Y' " ).append("\n"); 
		query.append("          FROM BKG_VVD BK " ).append("\n"); 
		query.append("         WHERE BK.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND BK.POD_CD LIKE 'DE%'" ).append("\n"); 
		query.append("           AND A.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("           AND ROWNUM = 1 " ).append("\n"); 
		query.append("       ) DE_FLG" ).append("\n"); 
		query.append(",	   (SELECT 'Y' " ).append("\n"); 
		query.append("          FROM BKG_HRD_CDG_CTNT HRD" ).append("\n"); 
		query.append("         WHERE A.POD_CD LIKE HRD.ATTR_CTNT1 || '%'" ).append("\n"); 
		query.append("           AND HRD.HRD_CDG_ID = 'HS_EU_CNT'" ).append("\n"); 
		query.append("           AND A.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("           AND ROWNUM = 1 " ).append("\n"); 
		query.append("       ) HS_EU_FLG" ).append("\n"); 
		query.append(",	  NVL((SELECT 'Y' " ).append("\n"); 
		query.append("          FROM BKG_VVD BK " ).append("\n"); 
		query.append("         WHERE BK.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("           AND BK.POD_CD LIKE 'TR%'" ).append("\n"); 
		query.append("           AND ROWNUM = 1 " ).append("\n"); 
		query.append("       ),'N') TR_FLG" ).append("\n"); 
		query.append(" ,  (SELECT CASE WHEN COUNT(1) > 0 THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N' END AS" ).append("\n"); 
		query.append("       FROM	BKG_VVD VVD" ).append("\n"); 
		query.append("      WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("        AND	POD_CD IN " ).append("\n"); 
		query.append("       (SELECT	vps_port_cd --POD에 들리기 이전이라면" ).append("\n"); 
		query.append("          FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("         WHERE	vsl_cd		= VVD.VSL_CD" ).append("\n"); 
		query.append("           AND	skd_voy_no	= VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND	skd_dir_cd	= VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND	clpt_ind_seq= '1'" ).append("\n"); 
		query.append("           AND	clpt_seq	>=" ).append("\n"); 
		query.append("            (SELECT	MIN(clpt_seq) --처음 CANADA를 들리는 port가" ).append("\n"); 
		query.append("               FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("              WHERE	vsl_cd		= VVD.VSL_CD" ).append("\n"); 
		query.append("                AND	skd_voy_no	= VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND	skd_dir_cd	= VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND	vps_port_cd	LIKE 'US%'" ).append("\n"); 
		query.append("                AND	nvl(skd_cng_sts_cd, ' ') <> 'S'" ).append("\n"); 
		query.append("                AND	clpt_seq	>= " ).append("\n"); 
		query.append("                (SELECT	MAX(clpt_seq) --출항 port 이후에" ).append("\n"); 
		query.append("                   FROM	vsk_vsl_port_skd" ).append("\n"); 
		query.append("                  WHERE	vsl_cd		= VVD.VSL_CD" ).append("\n"); 
		query.append("                    AND	skd_voy_no	= VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND	skd_dir_cd	= VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND	vps_port_cd	LIKE VVD.POL_CD " ).append("\n"); 
		query.append("                    AND	nvl(skd_cng_sts_cd, ' ') <> 'S') ) )" ).append("\n"); 
		query.append("       AND SUBSTR(VVD.POL_CD, 1, 2) <> 'US'--POL이 CANADA일 때는 제외" ).append("\n"); 
		query.append("       AND SUBSTR(VVD.POD_CD, 1, 2) <> 'US'--POD가 CANADA일 때는 제외  " ).append("\n"); 
		query.append("      ) AS US_FROB_FLG    " ).append("\n"); 
		query.append("     ,NVL(( SELECT 'Y'" ).append("\n"); 
		query.append("              FROM DUAL" ).append("\n"); 
		query.append("             WHERE A.POD_CD like 'RU%'" ).append("\n"); 
		query.append("               AND (SUBSTR(A.POR_CD,1,2) IN ('US','CA', 'AU')" ).append("\n"); 
		query.append("               OR SUBSTR(A.POR_CD,1,2) IN (SELECT A.CNT_CD" ).append("\n"); 
		query.append("                                            FROM MDM_COUNTRY A" ).append("\n"); 
		query.append("                                               , MDM_SUBCONTINENT B" ).append("\n"); 
		query.append("                                               , MDM_CONTINENT C" ).append("\n"); 
		query.append("                                            WHERE 1 = 1 " ).append("\n"); 
		query.append("                                            AND A.SCONTI_CD=B.SCONTI_CD " ).append("\n"); 
		query.append("                                            AND B.CONTI_CD=C.CONTI_CD" ).append("\n"); 
		query.append("                                            AND NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                            AND NVL(B.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                            AND NVL(C.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                            AND UPPER(B.CONTI_CD) LIKE UPPER('E') || '%'))),'N') RU_FLG   " ).append("\n"); 
		query.append("FROM   BKG_BOOKING A, BKG_BL_DOC B, BKG_CUSTOMER C, BKG_CUSTOMER D, BKG_BL_ISS E" ).append("\n"); 
		query.append("WHERE  B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND    C.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND    C.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND    D.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND    D.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND    E.BKG_NO(+) = A.BKG_NO" ).append("\n"); 
		query.append("AND    A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}