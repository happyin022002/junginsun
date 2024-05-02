/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DubaiManifestListDownloadDBDAOaddBkgCstmsDuCntrMfCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.26 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiManifestListDownloadDBDAOaddBkgCstmsDuCntrMfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * addBkgCstmsDuCntrMf
	  * </pre>
	  */
	public DubaiManifestListDownloadDBDAOaddBkgCstmsDuCntrMfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration").append("\n");
		query.append("FileName : DubaiManifestListDownloadDBDAOaddBkgCstmsDuCntrMfCSQL").append("\n");
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
		query.append("INSERT " ).append("\n");
		query.append("  INTO BKG_CSTMS_DU_CNTR_MF" ).append("\n");
		query.append("      (" ).append("\n");
		query.append("       BL_NO" ).append("\n");
		query.append("      ,POD_CD" ).append("\n");
		query.append("      ,CNTR_NO" ).append("\n");
		query.append("      ,CNTR_MF_SEQ" ).append("\n");
		query.append("      ,DU_CNTR_SER_NO" ).append("\n");
		query.append("      ,CNTR_MF_MK_DESC" ).append("\n");
		query.append("      ,CNTR_MF_GDS_DESC" ).append("\n");
		query.append("      ,CMDT_HS_CD" ).append("\n");
		query.append("      ,PCK_QTY" ).append("\n");
		query.append("      ,PCK_TP_DESC" ).append("\n");
		query.append("      ,DU_PCK_TP_CD" ).append("\n");
		query.append("      ,PLT_QTY" ).append("\n");
		query.append("      ,CNTR_MF_WGT" ).append("\n");
		query.append("      ,MEAS_QTY" ).append("\n");
		query.append("      ,DCGO_FLG" ).append("\n");
		query.append("      ,IMDG_UN_NO" ).append("\n");
		query.append("      ,IMDG_CLSS_CD" ).append("\n");
		query.append("      ,FLSH_PNT_CDO_TEMP" ).append("\n");
		query.append("      ,DCGO_TEMP_UT_CD" ).append("\n");
		query.append("      ,DG_STO_REQ_FLG" ).append("\n");
		query.append("      ,RFRT_REQ_FLG" ).append("\n");
		query.append("      ,MIN_TEMP" ).append("\n");
		query.append("      ,MAX_TEMP" ).append("\n");
		query.append("      ,CGO_TEMP_UT_CD" ).append("\n");
		query.append("      ,CRE_USR_ID" ).append("\n");
		query.append("      ,UPD_USR_ID" ).append("\n");
		query.append("      )" ).append("\n");
		query.append("      (" ).append("\n");
		query.append("       SELECT B.BL_NO" ).append("\n");
		query.append("             ,B.POD_CD" ).append("\n");
		query.append("             ,C.CNTR_NO" ).append("\n");
		query.append("             ,1 AS CNTR_MF_SEQ" ).append("\n");
		query.append("             ,ROW_NUMBER() OVER(PARTITION BY B.BL_NO||B.POD_CD ORDER BY B.BL_NO, B.POD_CD, C.CNTR_NO) AS DU_CNTR_SER_NO" ).append("\n");
		query.append("             ,B.CNTR_MF_MK_DESC" ).append("\n");
		query.append("             ,B.PCK_CMDT_DESC || B.CNTR_CMDT_DESC || B.CMDT_DESC || CHR(10)" ).append("\n");
		query.append("             ,B.CMDT_CD AS CMDT_HS_CD" ).append("\n");
		query.append("             ,C.PCK_QTY" ).append("\n");
		query.append("             ,P.ATTR_CTNT2" ).append("\n");
		query.append("             ,P.ATTR_CTNT1" ).append("\n");
		query.append("             ,''" ).append("\n");
		query.append("             ,C.CNTR_WGT" ).append("\n");
		query.append("             ,C.MEAS_QTY" ).append("\n");
		query.append("             ,C.DCGO_FLG" ).append("\n");
		query.append("             ,DECODE(C.DCGO_FLG, 'Y', DG.IMDG_UN_NO) AS IMDG_UN_NO" ).append("\n");
		query.append("             ,DECODE(C.DCGO_FLG, 'Y', DG.IMDG_CLSS_CD) AS IMDG_CLSS_CD" ).append("\n");
		query.append("             ,'' FLSH_PNT_CDO_TEMP" ).append("\n");
		query.append("             ,DECODE(C.DCGO_FLG, 'Y', 'C') AS DCGO_TEMP_UT_CD" ).append("\n");
		query.append("             ,DECODE(C.RC_FLG, 'Y', 'Y') AS DG_STO_REQ_FLG" ).append("\n");
		query.append("             ,C.RC_FLG" ).append("\n");
		query.append("             ,DECODE(C.RC_FLG, 'Y', NVL(RF.CDO_TEMP, RF.FDO_TEMP)) AS MIN_TEMP" ).append("\n");
		query.append("             ,DECODE(C.RC_FLG, 'Y', NVL(RF.CDO_TEMP, RF.FDO_TEMP)) AS MAX_TEMP" ).append("\n");
		query.append("             ,DECODE(C.RC_FLG, 'Y', DECODE(RF.CDO_TEMP, NULL, 'F', 'C')) AS CGO_TEMP_UT_CD" ).append("\n");
		query.append("             ,@[upd_usr_id]" ).append("\n");
		query.append("             ,@[upd_usr_id]" ).append("\n");
		query.append("         FROM " ).append("\n");
		query.append("              (" ).append("\n");
		query.append("                SELECT B.BKG_NO, B.BL_NO, V.POD_CD, B.CMDT_CD" ).append("\n");
		query.append("                      ,DECODE(D.PCK_CMDT_DESC, NULL, '', D.PCK_CMDT_DESC || CHR(10)) AS PCK_CMDT_DESC " ).append("\n");
		query.append("                      ,DECODE(D.CNTR_CMDT_DESC, NULL, '', D.CNTR_CMDT_DESC || CHR(10)) AS CNTR_CMDT_DESC" ).append("\n");
		query.append("                      ,DECODE(B.DE_TERM_CD, 'S', SUBSTR(M.MK_DESC, 1, 200), 'NIL') AS CNTR_MF_MK_DESC" ).append("\n");
		query.append("                      ,CASE WHEN NVL(INSTR(M.CMDT_DESC, CHR(10), 1, 1), 0) = 0 THEN M.CMDT_DESC" ).append("\n");
		query.append("                            ELSE SUBSTR(M.CMDT_DESC, 1, INSTR(M.CMDT_DESC, CHR(10), 1, 1)-1) " ).append("\n");
		query.append("                       END CMDT_DESC" ).append("\n");
		query.append("                  FROM BKG_BOOKING B" ).append("\n");
		query.append("                      ,BKG_BL_DOC D" ).append("\n");
		query.append("                      ,BKG_VVD V" ).append("\n");
		query.append("                      ,BKG_BL_MK_DESC M" ).append("\n");
		query.append("                 WHERE B.BKG_NO = V.BKG_NO" ).append("\n");
		query.append("                   AND B.BKG_NO = D.BKG_NO" ).append("\n");
		query.append("                   AND B.BKG_NO = M.BKG_NO(+)" ).append("\n");
		query.append("                   AND (M.MK_SEQ IS NULL OR M.MK_SEQ = (SELECT MIN(MK_SEQ) FROM BKG_BL_MK_DESC SM WHERE SM.BKG_NO = B.BKG_NO))" ).append("\n");
		query.append("                   AND B.BKG_STS_CD IN ('F','W')" ).append("\n");
		query.append("                   AND B.BL_NO IS NOT NULL" ).append("\n");
		query.append("               #if (${bl_no} != '') " ).append("\n");
		query.append("                   AND B.BL_NO = @[bl_no]" ).append("\n");
		query.append("                   AND V.POD_CD LIKE 'AE%'" ).append("\n");
		query.append("               #end" ).append("\n");
		query.append("               #if (${vvd} != '') " ).append("\n");
		query.append("                   AND V.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n");
		query.append("                   AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n");
		query.append("                   AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n");
		query.append("               #end" ).append("\n");
		query.append("               #if (${pol_cd} != '') " ).append("\n");
		query.append("                   AND V.POL_CD = @[pol_cd]" ).append("\n");
		query.append("               #end" ).append("\n");
		query.append("               #if (${pod_cd} != '') " ).append("\n");
		query.append("                   AND V.POD_CD = @[pod_cd]" ).append("\n");
		query.append("               #end" ).append("\n");
		query.append("               #if (${cgo_type} == 'F') " ).append("\n");
		query.append("                   AND B.BKG_CGO_TP_CD = @[cgo_type]" ).append("\n");
		query.append("               #elseif (${cgo_type} == 'M') " ).append("\n");
		query.append("                   AND B.BKG_CGO_TP_CD IN ('R', 'P')" ).append("\n");
		query.append("               #end" ).append("\n");
		query.append("              ) B" ).append("\n");
		query.append("             ,BKG_CONTAINER C" ).append("\n");
		query.append("             ,BKG_CSTMS_CD_CONV_CTNT P" ).append("\n");
		query.append("             ,BKG_DG_CGO DG" ).append("\n");
		query.append("             ,BKG_RF_CGO RF" ).append("\n");
		query.append("        WHERE B.BKG_NO = C.BKG_NO" ).append("\n");
		query.append("          AND P.CNT_CD(+) = 'AE'" ).append("\n");
		query.append("          AND P.CSTMS_DIV_ID(+) = 'DUBAI_PCK_CD'" ).append("\n");
		query.append("          AND P.ATTR_CTNT3(+) = C.PCK_TP_CD" ).append("\n");
		query.append("          AND (P.CSTMS_DIV_ID_SEQ IS NULL OR " ).append("\n");
		query.append("               P.CSTMS_DIV_ID_SEQ = (SELECT MAX(CSTMS_DIV_ID_SEQ) " ).append("\n");
		query.append("                                       FROM BKG_CSTMS_CD_CONV_CTNT " ).append("\n");
		query.append("                                      WHERE CNT_CD = 'AE' " ).append("\n");
		query.append("                                        AND CSTMS_DIV_ID = 'DUBAI_PCK_CD'" ).append("\n");
		query.append("                                        AND ATTR_CTNT3 = C.PCK_TP_CD" ).append("\n");
		query.append("                                     )" ).append("\n");
		query.append("              )" ).append("\n");
		query.append("          AND C.BKG_NO = DG.BKG_NO(+)" ).append("\n");
		query.append("          AND C.CNTR_NO = DG.CNTR_NO(+)" ).append("\n");
		query.append("          AND (DG.DCGO_SEQ IS NULL OR " ).append("\n");
		query.append("               DG.DCGO_SEQ = (SELECT MAX(DCGO_SEQ) " ).append("\n");
		query.append("                                FROM BKG_DG_CGO" ).append("\n");
		query.append("                               WHERE BKG_NO = C.BKG_NO" ).append("\n");
		query.append("                                 AND CNTR_NO = C.CNTR_NO" ).append("\n");
		query.append("                             )" ).append("\n");
		query.append("               )" ).append("\n");
		query.append("          AND C.BKG_NO = RF.BKG_NO(+)" ).append("\n");
		query.append("          AND C.CNTR_NO = RF.CNTR_NO(+)" ).append("\n");
		query.append("          AND (RF.RC_SEQ IS NULL OR " ).append("\n");
		query.append("               RF.RC_SEQ = (SELECT MAX(RC_SEQ) " ).append("\n");
		query.append("                              FROM BKG_RF_CGO" ).append("\n");
		query.append("                             WHERE BKG_NO = C.BKG_NO" ).append("\n");
		query.append("                               AND CNTR_NO = C.CNTR_NO" ).append("\n");
		query.append("                           )" ).append("\n");
		query.append("              )" ).append("\n");
		query.append("      )" ).append("\n");

	}
}