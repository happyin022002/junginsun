/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UserSetupMgtDBDAOSearchUserPrintSetup3RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.09 
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
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
		query.append("	   BKG_RIDER_YN_FNC(X.BKG_NO, NULL, '1', '1', NULL) AS OBL_RIDER_FLG," ).append("\n"); 
		query.append("       (SELECT     DECODE(COUNT(B.BKG_NO), 0, 'Y', DECODE(NVL(C.ORG_PPD_RCV_CD, 'Y'), 'N', 'N', 'Y'))  " ).append("\n"); 
		query.append("         FROM       BKG_BOOKING A,    " ).append("\n"); 
		query.append("                    BKG_CHG_RT B," ).append("\n"); 
		query.append("                    BKG_BL_ISS C   " ).append("\n"); 
		query.append("         WHERE      A.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("         AND        A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("         AND        A.BKG_NO = C.BKG_NO   " ).append("\n"); 
		query.append("         AND        B.FRT_TERM_CD (+) = 'P'   " ).append("\n"); 
		query.append("         AND        B.N3PTY_RCV_OFC_CD(+) IS NULL   " ).append("\n"); 
		query.append("         GROUP BY   A.BKG_NO, C.ORG_PPD_RCV_CD" ).append("\n"); 
		query.append("        ) AS ORG_PPD_RCV_CD ," ).append("\n"); 
		query.append("        (  SELECT     DECODE(COUNT(B.BKG_NO), 0, 'Y', DECODE(NVL(C.ORG_N3PTY_PPD_CD, 'Y'), 'N', 'N', 'Y'))    " ).append("\n"); 
		query.append("             FROM       BKG_BOOKING A,    " ).append("\n"); 
		query.append("                        BKG_CHG_RT B," ).append("\n"); 
		query.append("                        BKG_BL_ISS C   " ).append("\n"); 
		query.append("             WHERE      A.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("             AND        A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("             AND        A.BKG_NO = C.BKG_NO   " ).append("\n"); 
		query.append("             AND        B.FRT_TERM_CD (+) = 'P'   " ).append("\n"); 
		query.append("             AND        B.N3PTY_RCV_OFC_CD(+) IS NOT NULL   " ).append("\n"); 
		query.append("             GROUP BY   A.BKG_NO , C.ORG_N3PTY_PPD_CD" ).append("\n"); 
		query.append("        ) AS ORG_N3PTY_PPD_CD ," ).append("\n"); 
		query.append("       NVL(WBL_PRN_FLG,'N') AS WBL_PRN_FLG," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("           SELECT A.BL_KNT_FLG" ).append("\n"); 
		query.append("           FROM BKG_BL_ESIG_OFC_ASGN A" ).append("\n"); 
		query.append("                ,BKG_BL_ESIG B" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("           AND A.BL_ESIG_SEQ = B.BL_ESIG_SEQ" ).append("\n"); 
		query.append("           AND A.BL_ISS_OFC_CD = DECODE( Y.OBL_ISS_OFC_CD, NULL, X.BKG_OFC_CD, Y.OBL_ISS_OFC_CD )" ).append("\n"); 
		query.append("           AND ROWNUM = 1        " ).append("\n"); 
		query.append("       ) AS BL_KNT_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM   BKG_BOOKING X, BKG_BL_ISS Y," ).append("\n"); 
		query.append("     ( SELECT TRIM(COLUMN_VALUE) AS BKG_NO ,rownum as seq" ).append("\n"); 
		query.append("        FROM table(BKG_SPLIT_CLOB_FNC(${bkg_no}))" ).append("\n"); 
		query.append("       ) Z" ).append("\n"); 
		query.append("WHERE  X.BKG_NO = Y.BKG_NO(+)" ).append("\n"); 
		query.append("AND   Z.BKG_NO = X.BKG_NO" ).append("\n"); 
		query.append("ORDER BY Z.SEQ" ).append("\n"); 

	}
}