/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UserSetupMgtDBDAOSearchUserPrintSetup3RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.21 
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

public class UserSetupMgtDBDAOSearchUserPrintSetup3RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UserSetupMgtDBDAOSearchUserPrintSetup3RSQL
	  * </pre>
	  */
	public UserSetupMgtDBDAOSearchUserPrintSetup3RSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOSearchUserPrintSetup3RSQL").append("\n"); 
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
		query.append("SELECT X.BKG_NO," ).append("\n"); 
		query.append("       X.BL_NO," ).append("\n"); 
		query.append("       BL_TP_CD ," ).append("\n"); 
		query.append("       (SELECT CONTI_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("        WHERE LOC_CD = BKG_COM_USER_LOC_FNC(@[usr_id]) ) AS CONTI_CD," ).append("\n"); 
		query.append("       NVL(BB_CGO_FLG,'N') AS BB_CGO_FLG,/* BL_TP_CD >> NULL - Original Bill/ W - Waybill*/" ).append("\n"); 
		query.append("       NVL(OBL_ISS_FLG,'N') AS OBL_ISS_FLG," ).append("\n"); 
		query.append("       NVL(OBL_PRN_FLG,'N') AS OBL_PRN_FLG," ).append("\n"); 
		query.append("       NVL(OBL_RLSE_FLG,'N') AS OBL_RLSE_FLG," ).append("\n"); 
		query.append("       NVL(BL_CPY_KNT,0) AS BL_CPY_KNT," ).append("\n"); 
		query.append("#if(${module} == 'BIS')" ).append("\n"); 
		query.append("	   BIS_RIDER_YN_FNC(X.BKG_NO, NULL, '1', '1', NULL) AS OBL_RIDER_FLG," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	   BKG_RIDER_YN_FNC(X.BKG_NO, NULL, '1', '1', NULL) AS OBL_RIDER_FLG," ).append("\n"); 
		query.append("       (SELECT DECODE(MAX(HBL_TP),'B','B',DECODE(MAX(HBL_TP2),'B','B','A')) AS HBL_TP" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT CASE WHEN GDS_DESC_LINE = 1 AND LENGTH(GDS_DESC) < 329 THEN 'A'" ).append("\n"); 
		query.append("                            WHEN GDS_DESC_LINE > 1 AND GDS_DESC_LINE < 9 THEN 'A'" ).append("\n"); 
		query.append("                            WHEN GDS_DESC_LINE = 0 THEN 'A'" ).append("\n"); 
		query.append("                            ELSE 'B'" ).append("\n"); 
		query.append("                            END AS HBL_TP," ).append("\n"); 
		query.append("                            CASE WHEN MK_DESC_LINE = 1 AND LENGTH(MK_DESC) < 329 THEN 'A'" ).append("\n"); 
		query.append("                            WHEN MK_DESC_LINE > 1 AND LENGTH(MK_DESC) < 9 THEN 'A'" ).append("\n"); 
		query.append("                            WHEN MK_DESC_LINE = 0 THEN 'A'" ).append("\n"); 
		query.append("                            ELSE 'B'" ).append("\n"); 
		query.append("                            END AS HBL_TP2" ).append("\n"); 
		query.append("                      ,BKG_NO" ).append("\n"); 
		query.append("                FROM (  " ).append("\n"); 
		query.append("                      SELECT MK_DESC  " ).append("\n"); 
		query.append("                            ,GDS_DESC" ).append("\n"); 
		query.append("                            ,BKG_NO" ).append("\n"); 
		query.append("                            ,DECODE(LENGTH(MK_DESC), NULL, 0, ((LENGTH(MK_DESC) - LENGTH(REPLACE(MK_DESC, CHR(13)||CHR(10)))) / LENGTH(CHR(13)||CHR(10)) + 1)) AS MK_DESC_LINE  " ).append("\n"); 
		query.append("                            ,DECODE(LENGTH(GDS_DESC), NULL, 0, ((LENGTH(GDS_DESC) - LENGTH(REPLACE(GDS_DESC, CHR(13)||CHR(10)))) / LENGTH(CHR(13)||CHR(10)) + 1)) AS GDS_DESC_LINE  " ).append("\n"); 
		query.append("                            ,LENGTH(GDS_DESC)" ).append("\n"); 
		query.append("                        FROM (  " ).append("\n"); 
		query.append("                              SELECT HBL.BKG_NO" ).append("\n"); 
		query.append("                            ,REGEXP_REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REGEXP_REPLACE(HBL.BL_MK_DESC,'[[:cntrl:]]{104,}',CHR(13)||CHR(10)),CHR(96),CHR(39)), CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10)), '[[:space:]]+$', '')  AS MK_DESC  " ).append("\n"); 
		query.append("                            ,REGEXP_REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REGEXP_REPLACE(HBL.BL_GDS_DESC,'[[:cntrl:]]{104,}',CHR(13)||CHR(10)),CHR(96),CHR(39)), CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(13)||CHR(10)), '[[:space:]]+$', '') AS GDS_DESC   " ).append("\n"); 
		query.append("                                FROM BKG_HBL hbl" ).append("\n"); 
		query.append("                             )  " ).append("\n"); 
		query.append("                    )  " ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("            WHERE BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("         ) AS HBL_TP," ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       (SELECT     DECODE(COUNT(B.BKG_NO), 0, 'Y', DECODE(NVL(C.ORG_PPD_RCV_CD, 'Y'), 'N', 'N', 'Y'))  " ).append("\n"); 
		query.append("         FROM" ).append("\n"); 
		query.append("#if(${module} == 'BIS')" ).append("\n"); 
		query.append("					BIS_BOOKING A,    " ).append("\n"); 
		query.append("                    BIS_CHG_RT B," ).append("\n"); 
		query.append("                    BIS_BL_ISS C   " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("					BKG_BOOKING A,    " ).append("\n"); 
		query.append("                    BKG_CHG_RT B," ).append("\n"); 
		query.append("                    BKG_BL_ISS C   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         WHERE      A.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("         AND        A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("         AND        A.BKG_NO = C.BKG_NO   " ).append("\n"); 
		query.append("         AND        B.FRT_TERM_CD (+) = 'P'   " ).append("\n"); 
		query.append("         AND        B.N3PTY_RCV_OFC_CD(+) IS NULL   " ).append("\n"); 
		query.append("         GROUP BY   A.BKG_NO, C.ORG_PPD_RCV_CD" ).append("\n"); 
		query.append("        ) AS ORG_PPD_RCV_CD ," ).append("\n"); 
		query.append("        (  SELECT     DECODE(COUNT(B.BKG_NO), 0, 'Y', DECODE(NVL(C.ORG_N3PTY_PPD_CD, 'Y'), 'N', 'N', 'Y'))    " ).append("\n"); 
		query.append("             FROM" ).append("\n"); 
		query.append("#if(${module} == 'BIS')" ).append("\n"); 
		query.append("						BIS_BOOKING A,    " ).append("\n"); 
		query.append("                        BIS_CHG_RT B," ).append("\n"); 
		query.append("                        BIS_BL_ISS C   " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("						BKG_BOOKING A,    " ).append("\n"); 
		query.append("                        BKG_CHG_RT B," ).append("\n"); 
		query.append("                        BKG_BL_ISS C   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("             WHERE      A.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("             AND        A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("             AND        A.BKG_NO = C.BKG_NO   " ).append("\n"); 
		query.append("             AND        B.FRT_TERM_CD (+) = 'P'   " ).append("\n"); 
		query.append("             AND        B.N3PTY_RCV_OFC_CD(+) IS NOT NULL   " ).append("\n"); 
		query.append("             GROUP BY   A.BKG_NO , C.ORG_N3PTY_PPD_CD" ).append("\n"); 
		query.append("        ) AS ORG_N3PTY_PPD_CD" ).append("\n"); 
		query.append("        ,CASE WHEN X.POD_CD = 'OMMCT' AND TO_NUMBER(TO_CHAR((SELECT BL_OBRD_DT  FROM BKG_BL_DOC WHERE BKG_NO = X.BKG_NO),'YYYYMMDD')) >= 20140531 THEN 'Y'" ).append("\n"); 
		query.append("              ELSE 'N'" ).append("\n"); 
		query.append("         END AS DATE_FLG /*2014/05/31이후 선적된 화물인지 확인*/" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("#if(${module} == 'BIS')" ).append("\n"); 
		query.append("	BIS_BOOKING X, BIS_BL_ISS Y," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	BKG_BOOKING X, BKG_BL_ISS Y," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     ( SELECT TRIM(COLUMN_VALUE) AS BKG_NO ,rownum as seq" ).append("\n"); 
		query.append("        FROM table(BKG_SPLIT_CLOB_FNC(${bkg_no}))" ).append("\n"); 
		query.append("       ) Z" ).append("\n"); 
		query.append("WHERE  X.BKG_NO = Y.BKG_NO(+)" ).append("\n"); 
		query.append("AND   Z.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("ORDER BY Z.SEQ" ).append("\n"); 

	}
}