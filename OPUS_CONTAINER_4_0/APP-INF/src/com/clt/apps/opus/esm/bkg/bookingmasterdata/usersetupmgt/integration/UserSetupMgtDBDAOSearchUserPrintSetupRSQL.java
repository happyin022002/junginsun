/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UserSetupMgtDBDAOSearchUserPrintSetupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOSearchUserPrintSetupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UserSetupMgtDBDAOSearchUserPrintSetupRSQL
	  * </pre>
	  */
	public UserSetupMgtDBDAOSearchUserPrintSetupRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOSearchUserPrintSetupRSQL").append("\n"); 
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
		query.append("    USR_ID, " ).append("\n"); 
		query.append("	ORG_N3PTY_PPD_CD," ).append("\n"); 
		query.append("	ORG_PPD_RCV_CD," ).append("\n"); 
		query.append("   (SELECT CONTI_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("    WHERE LOC_CD = BKG_COM_USER_LOC_FNC(@[usr_id]) ) AS CONTI_CD," ).append("\n"); 
		query.append("    BL_FACE_PRN_DVC_NM, /*0743*/" ).append("\n"); 
		query.append("    BL_RIDR_PRN_DVC_NM, /*0743*/" ).append("\n"); 
		query.append("    BL_PRN_DVC_NM, /*0064*/" ).append("\n"); 
		query.append("    CRE_USR_ID, " ).append("\n"); 
		query.append("    CRE_DT, " ).append("\n"); 
		query.append("    UPD_USR_ID, " ).append("\n"); 
		query.append("    UPD_DT," ).append("\n"); 
		query.append("    BL_PRN_CHG_TP_CD," ).append("\n"); 
		query.append("	PRINT_RELEASE_YN," ).append("\n"); 
		query.append("    BKG_GET_TOKEN_FNC(ISS_PRN_FLG_N_ISS_CPY_KNT ,1) AS OBL_ISS_FLG ," ).append("\n"); 
		query.append("    BKG_GET_TOKEN_FNC(ISS_PRN_FLG_N_ISS_CPY_KNT ,2) AS OBL_PRN_FLG ," ).append("\n"); 
		query.append("    BKG_GET_TOKEN_FNC(ISS_PRN_FLG_N_ISS_CPY_KNT ,3) AS OBL_ISS_KNT ," ).append("\n"); 
		query.append("    BKG_GET_TOKEN_FNC(ISS_PRN_FLG_N_ISS_CPY_KNT ,4) AS BL_CPY_KNT ," ).append("\n"); 
		query.append("    BKG_GET_TOKEN_FNC(ISS_PRN_FLG_N_ISS_CPY_KNT ,5) AS BL_CPY_NO ," ).append("\n"); 
		query.append("    BKG_GET_TOKEN_FNC(BL_TP_CD_N_BB_CGO_FLG,1) AS BL_TP_CD ," ).append("\n"); 
		query.append("    BKG_GET_TOKEN_FNC(BL_TP_CD_N_BB_CGO_FLG,2) AS BB_CGO_FLG ," ).append("\n"); 
		query.append("    BKG_GET_TOKEN_FNC(ESIG_CPYESIG_KNT_FLG ,1) AS BL_ESIG_FLG ," ).append("\n"); 
		query.append("    BKG_GET_TOKEN_FNC(ESIG_CPYESIG_KNT_FLG ,2) AS BL_CPY_ESIG_FLG ," ).append("\n"); 
		query.append("    BKG_GET_TOKEN_FNC(ESIG_CPYESIG_KNT_FLG ,3) AS BL_KNT_FLG," ).append("\n"); 
		query.append("    BKG_JOIN_FNC(cursor( SELECT  BL_PRN_TP_CD||'>'||BL_PRN_CHG_TP_CD||'>'|| BL_PRN_CNTR_TP_CD||'>'||" ).append("\n"); 
		query.append("                                     BL_FACE_PRN_KNT||'>'||BL_RIDR_PRN_KNT||'>'||BL_FACE_PRN_DVC_NM||'>'||BL_RIDR_PRN_DVC_NM" ).append("\n"); 
		query.append("                                FROM BKG_USR_BL_PRN_DFLT" ).append("\n"); 
		query.append("                                WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("                                ORDER BY BL_PRN_TP_CD" ).append("\n"); 
		query.append("                            ),'@' ) AS BL_PRN_SETUP" ).append("\n"); 
		query.append("FROM ( SELECT " ).append("\n"); 
		query.append("            ROWNUM AS SEQ," ).append("\n"); 
		query.append("            USR_ID, " ).append("\n"); 
		query.append("            BL_FACE_PRN_DVC_NM, /*0743*/" ).append("\n"); 
		query.append("            BL_RIDR_PRN_DVC_NM, /*0743*/" ).append("\n"); 
		query.append("            BL_PRN_DVC_NM, /*0064*/" ).append("\n"); 
		query.append("            CRE_USR_ID, " ).append("\n"); 
		query.append("            CRE_DT, " ).append("\n"); 
		query.append("            UPD_USR_ID, " ).append("\n"); 
		query.append("            UPD_DT," ).append("\n"); 
		query.append("            BL_PRN_CHG_TP_CD" ).append("\n"); 
		query.append("        FROM BKG_USR_DFLT_SET " ).append("\n"); 
		query.append("        WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("    ) A," ).append("\n"); 
		query.append("    ( SELECT ROWNUM SEQ " ).append("\n"); 
		query.append("           , NVL(( SELECT OBL_ISS_FLG ||','|| OBL_PRN_FLG ||','|| OBL_ISS_KNT ||','|| BL_CPY_KNT ||','|| BL_CPY_NO " ).append("\n"); 
		query.append("                     FROM BKG_BL_ISS WHERE BKG_NO = @[bkg_no] ),'N,N,1,0,0') ISS_PRN_FLG_N_ISS_CPY_KNT " ).append("\n"); 
		query.append("		   , NVL((SELECT BL_TP_CD||','||BB_CGO_FLG /* NULL - Original Bill / W - Waybill*/" ).append("\n"); 
		query.append("                FROM   BKG_BOOKING WHERE  BKG_NO = @[bkg_no] ),',') AS BL_TP_CD_N_BB_CGO_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , NVL(ORG_RCV.ORG_PPD_RCV_CD,'N') ORG_PPD_RCV_CD" ).append("\n"); 
		query.append("        , NVL(ORG_RCV.ORG_N3PTY_PPD_CD,'N') ORG_N3PTY_PPD_CD" ).append("\n"); 
		query.append("        ,( SELECT DECODE(COUNT(*),0,'Y','N')" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("            SELECT 'X' as out_put" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("            BKG_DO_DTL DTL, BKG_BOOKING BKG, BKG_BL_ISS ISS" ).append("\n"); 
		query.append("            WHERE" ).append("\n"); 
		query.append("            DTL.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND BKG.BKG_NO = DTL.BKG_NO" ).append("\n"); 
		query.append("            AND BKG.BKG_NO = ISS.BKG_NO" ).append("\n"); 
		query.append("            AND DTL.RLSE_STS_CD = DECODE(SUBSTR(BKG.DEL_CD, 1, 2), 'JP','D', 'R')" ).append("\n"); 
		query.append("            AND NVL(ISS.OTR_DOC_CGOR_FLG, '*') <> 'Y'" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT 'X' as out_put" ).append("\n"); 
		query.append("            FROM BKG_BOOKING BKG, BKG_CGO_RLSE CGO, BKG_BL_ISS ISS" ).append("\n"); 
		query.append("            WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND BKG.BL_NO = CGO.BL_NO" ).append("\n"); 
		query.append("            AND BKG.BKG_NO = ISS.BKG_NO" ).append("\n"); 
		query.append("            AND CGO.FRT_CLT_FLG = 'Y'" ).append("\n"); 
		query.append("            AND CGO.OBL_RDEM_FLG = 'Y'" ).append("\n"); 
		query.append("            AND CGO.CSTMS_CLR_CD = 'Y'" ).append("\n"); 
		query.append("            AND NVL(ISS.OTR_DOC_CGOR_FLG, '*') <> 'Y'" ).append("\n"); 
		query.append("           )) AS PRINT_RELEASE_YN" ).append("\n"); 
		query.append("        ,NVL((" ).append("\n"); 
		query.append("            SELECT BL_ESIG_FLG ||','|| BL_CPY_ESIG_FLG ||','|| BL_KNT_FLG" ).append("\n"); 
		query.append("            FROM BKG_BL_ESIG_OFC_ASGN" ).append("\n"); 
		query.append("            WHERE BL_ISS_OFC_CD = DECODE((SELECT OBL_ISS_OFC_CD FROM BKG_BL_ISS WHERE BKG_NO = @[bkg_no] ), NULL, (SELECT BKG_OFC_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])," ).append("\n"); 
		query.append("                                         (SELECT OBL_ISS_OFC_CD FROM BKG_BL_ISS WHERE BKG_NO = @[bkg_no] ))" ).append("\n"); 
		query.append("			AND ROWNUM = 1" ).append("\n"); 
		query.append("        ),'N,N,N') AS ESIG_CPYESIG_KNT_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       FROM DUAL," ).append("\n"); 
		query.append("       		(SELECT  NVL(MAX(DECODE(IS_LAST, 'PPT1-1', DECODE(CR_FLG, 'Y', 'C')))                 " ).append("\n"); 
		query.append("                , MAX(DECODE(IS_LAST, 'PPT1-1', OTS_STL_FLG)))					ORG_PPD_RCV_CD" ).append("\n"); 
		query.append("                , NVL(MAX(DECODE(IS_LAST, 'PPT3-1', DECODE(CR_FLG, 'Y', 'C')))                 " ).append("\n"); 
		query.append("                , MAX(DECODE(IS_LAST, 'PPT3-1', OTS_STL_FLG)))					ORG_N3PTY_PPD_CD          " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("		        SELECT  P.CR_MK_FLG CR_FLG" ).append("\n"); 
		query.append("                        , Q.OTS_STL_FLG" ).append("\n"); 
		query.append("                        , Q.TP||'-1' IS_LAST" ).append("\n"); 
		query.append("                FROM SAR_OTS_HDR P, " ).append("\n"); 
		query.append("                    (SELECT DECODE(BKG_IO_BND_CD, 'O', DECODE(N3PTY_OFC_CD, NULL, 'PPT1', 'PPT3')) TP" ).append("\n"); 
		query.append("                            , MIN(STL_FLG) OTS_STL_FLG" ).append("\n"); 
		query.append("                        FROM SAR_OTS_HDR A,   " ).append("\n"); 
		query.append("                             (SELECT distinct A.BKG_NO BKG_NO," ).append("\n"); 
		query.append("                                    (SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = A.PPD_RCV_OFC_CD) PPD_OFC_CD,                                                                            " ).append("\n"); 
		query.append("                                    (SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = B.N3PTY_RCV_OFC_CD) N3PTY_OFC_CD" ).append("\n"); 
		query.append("                                FROM BKG_RATE A" ).append("\n"); 
		query.append("                                    ,BKG_CHG_RT B" ).append("\n"); 
		query.append("                                WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                    AND A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("                                    AND B.N3PTY_RCV_OFC_CD(+) is not null) B      " ).append("\n"); 
		query.append("                        WHERE A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                            AND (A.CLT_OFC_CD = B.PPD_OFC_CD OR A.CLT_OFC_CD = B.N3PTY_OFC_CD)" ).append("\n"); 
		query.append("                            AND A.BL_NO= B.BKG_NO  " ).append("\n"); 
		query.append("                        GROUP BY DECODE(BKG_IO_BND_CD, 'O', DECODE(N3PTY_OFC_CD, NULL, 'PPT1', 'PPT3'))" ).append("\n"); 
		query.append("                    ) Q     " ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                    AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                    AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                                 FROM SAR_OTS_DTL" ).append("\n"); 
		query.append("                                WHERE RHQ_CD = P.RHQ_CD" ).append("\n"); 
		query.append("                                 AND OTS_OFC_CD = P.OTS_OFC_CD" ).append("\n"); 
		query.append("                                 AND BL_NO = P.BL_NO" ).append("\n"); 
		query.append("                                 AND INV_NO = P.INV_NO" ).append("\n"); 
		query.append("                                 AND INV_AMT <> 0))" ).append("\n"); 
		query.append("            ) ORG_RCV" ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("WHERE A.SEQ(+) = B.SEQ" ).append("\n"); 

	}
}