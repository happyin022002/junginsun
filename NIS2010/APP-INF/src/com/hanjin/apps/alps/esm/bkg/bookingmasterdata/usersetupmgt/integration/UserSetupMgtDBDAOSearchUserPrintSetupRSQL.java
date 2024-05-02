/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UserSetupMgtDBDAOSearchUserPrintSetupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
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
		query.append("	PRINT_RELEASE_YN," ).append("\n"); 
		query.append("    BKG_GET_TOKEN_FNC(ISS_PRN_FLG_N_ISS_CPY_KNT ,1) AS OBL_ISS_FLG ," ).append("\n"); 
		query.append("    BKG_GET_TOKEN_FNC(ISS_PRN_FLG_N_ISS_CPY_KNT ,2) AS OBL_PRN_FLG ," ).append("\n"); 
		query.append("    BKG_GET_TOKEN_FNC(ISS_PRN_FLG_N_ISS_CPY_KNT ,3) AS OBL_ISS_KNT ," ).append("\n"); 
		query.append("    BKG_GET_TOKEN_FNC(ISS_PRN_FLG_N_ISS_CPY_KNT ,4) AS BL_CPY_KNT ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    BKG_GET_TOKEN_FNC(BL_TP_CD_N_BB_CGO_FLG,1) AS BL_TP_CD ," ).append("\n"); 
		query.append("    BKG_GET_TOKEN_FNC(BL_TP_CD_N_BB_CGO_FLG,2) AS BB_CGO_FLG ," ).append("\n"); 
		query.append("    BKG_JOIN_FNC(cursor( SELECT  BL_PRN_TP_CD||'>'||BL_PRN_CHG_TP_CD||'>'|| BL_PRN_CNTR_TP_CD||'>'||" ).append("\n"); 
		query.append("                                 BL_FACE_PRN_KNT||'>'||BL_RIDR_PRN_KNT||'>'||BL_FACE_PRN_DVC_NM||'>'||BL_RIDR_PRN_DVC_NM||'>'||" ).append("\n"); 
		query.append("								 NVL(BL_PRN_MGN_VAL,'0')" ).append("\n"); 
		query.append("                                FROM BKG_USR_BL_PRN_DFLT" ).append("\n"); 
		query.append("                                WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("                                ORDER BY BL_PRN_TP_CD" ).append("\n"); 
		query.append("                            ),'@' ) AS BL_PRN_SETUP" ).append("\n"); 
		query.append("	,(SELECT POD_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]) POD_CD  " ).append("\n"); 
		query.append("    ,CASE WHEN TO_NUMBER(TO_CHAR((SELECT NVL(BL_OBRD_DT,ETD)  FROM BKG_BL_DOC WHERE BKG_NO = @[bkg_no]),'YYYYMMDD')) >= 20140531 THEN 'Y'" ).append("\n"); 
		query.append("          ELSE 'N'" ).append("\n"); 
		query.append("     END AS DATE_FLG /*2014/05/31이후 선적된 화물인지 확인*/" ).append("\n"); 
		query.append("FROM ( SELECT " ).append("\n"); 
		query.append("            ROWNUM AS SEQ," ).append("\n"); 
		query.append("            USR_ID, " ).append("\n"); 
		query.append("            BL_FACE_PRN_DVC_NM, /*0743*/" ).append("\n"); 
		query.append("            BL_RIDR_PRN_DVC_NM, /*0743*/" ).append("\n"); 
		query.append("            BL_PRN_DVC_NM, /*0064*/" ).append("\n"); 
		query.append("            CRE_USR_ID, " ).append("\n"); 
		query.append("            CRE_DT, " ).append("\n"); 
		query.append("            UPD_USR_ID, " ).append("\n"); 
		query.append("            UPD_DT" ).append("\n"); 
		query.append("        FROM BKG_USR_DFLT_SET " ).append("\n"); 
		query.append("        WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("    ) A," ).append("\n"); 
		query.append("    ( SELECT ROWNUM SEQ " ).append("\n"); 
		query.append("           , NVL(( SELECT OBL_ISS_FLG ||','|| OBL_PRN_FLG ||','|| OBL_ISS_KNT ||','|| BL_CPY_KNT " ).append("\n"); 
		query.append("                     FROM BKG_BL_ISS WHERE BKG_NO = @[bkg_no] ),'N,N,1,0') ISS_PRN_FLG_N_ISS_CPY_KNT " ).append("\n"); 
		query.append("		   , NVL((SELECT BL_TP_CD||','||BB_CGO_FLG /* NULL - Original Bill / W - Waybill*/" ).append("\n"); 
		query.append("                FROM   BKG_BOOKING WHERE  BKG_NO = @[bkg_no] ),',') AS BL_TP_CD_N_BB_CGO_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,(SELECT     DECODE(COUNT(B.BKG_NO), 0, 'Y', DECODE(NVL(C.ORG_PPD_RCV_CD, 'Y'), 'N', 'N', 'Y'))  " ).append("\n"); 
		query.append("         FROM       BKG_BOOKING A,    " ).append("\n"); 
		query.append("                    BKG_CHG_RT B," ).append("\n"); 
		query.append("                    BKG_BL_ISS C   " ).append("\n"); 
		query.append("         WHERE      A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         AND        A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("         AND        A.BKG_NO = C.BKG_NO   " ).append("\n"); 
		query.append("         AND        B.FRT_TERM_CD (+) = 'P'   " ).append("\n"); 
		query.append("         AND        B.N3PTY_RCV_OFC_CD(+) IS NULL   " ).append("\n"); 
		query.append("         GROUP BY   A.BKG_NO, C.ORG_PPD_RCV_CD" ).append("\n"); 
		query.append("        ) AS ORG_PPD_RCV_CD" ).append("\n"); 
		query.append("        ,(  SELECT     DECODE(COUNT(B.BKG_NO), 0, 'Y', DECODE(NVL(C.ORG_N3PTY_PPD_CD, 'Y'), 'N', 'N', 'Y'))    " ).append("\n"); 
		query.append("             FROM       BKG_BOOKING A,    " ).append("\n"); 
		query.append("                        BKG_CHG_RT B," ).append("\n"); 
		query.append("                        BKG_BL_ISS C   " ).append("\n"); 
		query.append("             WHERE      A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             AND        A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("             AND        A.BKG_NO = C.BKG_NO   " ).append("\n"); 
		query.append("             AND        B.FRT_TERM_CD (+) = 'P'   " ).append("\n"); 
		query.append("             AND        B.N3PTY_RCV_OFC_CD(+) IS NOT NULL   " ).append("\n"); 
		query.append("             GROUP BY   A.BKG_NO , C.ORG_N3PTY_PPD_CD" ).append("\n"); 
		query.append("        ) AS ORG_N3PTY_PPD_CD" ).append("\n"); 
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
		query.append("           ,(                " ).append("\n"); 
		query.append("              SELECT SKD.VPS_ETD_DT" ).append("\n"); 
		query.append("                FROM VSK_VSL_PORT_SKD SKD," ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                    SELECT VSL_CD," ).append("\n"); 
		query.append("                      SKD_VOY_NO," ).append("\n"); 
		query.append("                      SKD_DIR_CD," ).append("\n"); 
		query.append("                      POL_CD," ).append("\n"); 
		query.append("                      POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                    FROM BKG_VVD" ).append("\n"); 
		query.append("                    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                      AND VSL_PRE_PST_CD||VSL_SEQ = (" ).append("\n"); 
		query.append("                                                     SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ)" ).append("\n"); 
		query.append("                                                     FROM BKG_VVD" ).append("\n"); 
		query.append("                                                     WHERE BKG_NO = @[bkg_no])) VVD" ).append("\n"); 
		query.append("                WHERE SKD.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                  AND SKD.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND SKD.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND SKD.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                  AND SKD.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("              ) ETD" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("WHERE A.SEQ(+) = B.SEQ" ).append("\n"); 

	}
}