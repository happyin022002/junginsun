/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingUtilDBDAOsearchOfcComboRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchOfcComboRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingUtilDBDAOsearchOfcComboRSQL
	  * </pre>
	  */
	public BookingUtilDBDAOsearchOfcComboRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchOfcComboRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("     N4TH_PRNT_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("      SELECT Z.OFC_TP_CD," ).append("\n"); 
		query.append("      Z.OFC_CD," ).append("\n"); 
		query.append("      Z.OFC_ENG_NM," ).append("\n"); 
		query.append("      Z.OFC_KRN_NM," ).append("\n"); 
		query.append("      Z.PRNT_OFC_CD," ).append("\n"); 
		query.append("      Z.OFC_KND_CD," ).append("\n"); 
		query.append("      Z.DELT_FLG," ).append("\n"); 
		query.append("      Z.OFC_SLS_DELT_FLG," ).append("\n"); 
		query.append("      Z.LOC_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      DECODE(Z.OFC_TP_CD, 'QT', DECODE(Z.OFC_CD, 'NYCWP',  LENGTH(Z.OFC)/6 , 'NYCMS', LENGTH(Z.OFC)/6 , ''), LENGTH(Z.OFC)/6  ) LVL," ).append("\n"); 
		query.append("      DECODE(Z.OFC_TP_CD, 'QT', DECODE(Z.OFC_CD, 'NYCWP',  TRIM(SUBSTR(Z.OFC,  1, 6)), 'NYCMS', TRIM(SUBSTR(Z.OFC,  1, 6))), TRIM(SUBSTR(Z.OFC, 1, 6))  ) N1ST_PRNT_OFC_CD," ).append("\n"); 
		query.append("      DECODE(Z.OFC_TP_CD, 'QT', DECODE(Z.OFC_CD, 'NYCWP',  TRIM(SUBSTR(Z.OFC,  7, 6)), 'NYCMS', TRIM(SUBSTR(Z.OFC,  7, 6))), TRIM(SUBSTR(Z.OFC, 7, 6))  ) N2ND_PRNT_OFC_CD," ).append("\n"); 
		query.append("      DECODE(Z.OFC_TP_CD, 'QT', DECODE(Z.OFC_CD, 'NYCWP',  TRIM(SUBSTR(Z.OFC, 13, 6)), 'NYCMS', TRIM(SUBSTR(Z.OFC, 13, 6))), TRIM(SUBSTR(Z.OFC, 13, 6))  ) N3RD_PRNT_OFC_CD," ).append("\n"); 
		query.append("      DECODE(Z.OFC_TP_CD, 'QT', DECODE(Z.OFC_CD, 'NYCWP',  TRIM(SUBSTR(Z.OFC, 19, 6)), 'NYCMS', TRIM(SUBSTR(Z.OFC, 19, 6))), TRIM(SUBSTR(Z.OFC, 19, 6))  ) N4TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("      DECODE(Z.OFC_TP_CD, 'QT', DECODE(Z.OFC_CD, 'NYCWP',  TRIM(SUBSTR(Z.OFC, 25, 6)), 'NYCMS', TRIM(SUBSTR(Z.OFC, 25, 6))), TRIM(SUBSTR(Z.OFC, 25, 6))  ) N5TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("      DECODE(Z.OFC_TP_CD, 'QT', DECODE(Z.OFC_CD, 'NYCWP',  TRIM(SUBSTR(Z.OFC, 31, 6)), 'NYCMS', TRIM(SUBSTR(Z.OFC, 31, 6))), TRIM(SUBSTR(Z.OFC, 31, 6))  ) N6TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("      DECODE(Z.OFC_TP_CD, 'QT', DECODE(Z.OFC_CD, 'NYCWP',  TRIM(SUBSTR(Z.OFC, 37, 6)), 'NYCMS', TRIM(SUBSTR(Z.OFC, 37, 6))), TRIM(SUBSTR(Z.OFC, 37, 6))  ) N7TH_PRNT_OFC_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT M.OFC_TP_CD, M.OFC_CD, M.OFC_ENG_NM, M.OFC_KRN_NM, M.PRNT_OFC_CD, M.OFC_KND_CD, M.DELT_FLG, M.OFC_SLS_DELT_FLG, M.LOC_CD, (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                      CASE WHEN (COUNT(1) = 1 AND MAX(DECODE(O.OFC_TP_CD, 'HO', 'Y')) = 'Y') OR MAX(DECODE(O.OFC_TP_CD, 'HO', 'Y', 'N'))||MAX(DECODE(O.OFC_TP_CD, 'HQ', 'Y', 'N')) = 'YY'" ).append("\n"); 
		query.append("                                THEN DECODE(MAX(DECODE(O.OFC_TP_CD, 'AQ', 'Y', 'N')), 'Y', RPAD(MAX(DECODE(ROWNUM, 9, O.OFC_CD)), 6, ' ')|| RPAD(MAX(DECODE(ROWNUM, 8, O.OFC_CD)), 6, ' ')|| RPAD(MAX(DECODE(ROWNUM, 7, O.OFC_CD)), 6, ' ')|| RPAD(MAX(DECODE(ROWNUM, 6, O.OFC_CD)), 6, ' ')|| RPAD(MAX(DECODE(ROWNUM, 5, O.OFC_CD)), 6, ' ')|| RPAD(MAX(DECODE(ROWNUM, 4, O.OFC_CD)), 6, ' ')|| RPAD(MAX(DECODE(ROWNUM, 3, O.OFC_CD)), 6, ' ')|| RPAD(MAX(DECODE(ROWNUM, 2, O.OFC_CD)), 6, ' ')|| RPAD(MAX(DECODE(ROWNUM, 1, O.OFC_CD)), 6, ' '), RPAD(MAX(DECODE(ROWNUM, 9, O.OFC_CD)), 6, ' ')|| RPAD(MAX(DECODE(ROWNUM, 8, O.OFC_CD)), 6, ' ')||DECODE(COUNT(1), 9, '      ', '')|| RPAD(MAX(DECODE(ROWNUM, 7, O.OFC_CD)), 6, ' ')||DECODE(COUNT(1), 8, '      ', '')|| RPAD(MAX(DECODE(ROWNUM, 6, O.OFC_CD)), 6, ' ')||DECODE(COUNT(1), 7, '      ', '')|| RPAD(MAX(DECODE(ROWNUM, 5, O.OFC_CD)), 6, ' ')||DECODE(COUNT(1), 6, '      ', '')|| RPAD(MAX(DECODE(ROWNUM, 4, O.OFC_CD)), 6, ' ')||DECODE(COUNT(1), 5, '      ', '')|| RPAD(MAX(DECODE(ROWNUM, 3, O.OFC_CD)), 6, ' ')||DECODE(COUNT(1), 4, '      ', '')|| RPAD(MAX(DECODE(ROWNUM, 2, O.OFC_CD)), 6, ' ')||DECODE(COUNT(1), 3, '      ', '')|| RPAD(MAX(DECODE(ROWNUM, 1, O.OFC_CD)), 6, ' ') )" ).append("\n"); 
		query.append("                        ELSE ''" ).append("\n"); 
		query.append("                      END OFC_CD" ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append("            WHERE O.OFC_TP_CD IN ('HO', 'HQ', 'AQ', 'BB', 'BA', 'BS', 'PS', 'QT')" ).append("\n"); 
		query.append("            CONNECT BY NOCYCLE PRIOR O.PRNT_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("              START WITH O.OFC_CD = M.OFC_CD" ).append("\n"); 
		query.append("              AND O.OFC_TP_CD IN ('HO', 'HQ', 'AQ', 'BB', 'BA', 'BS', 'PS','QT') ) OFC" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION M ) Z" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE N4TH_PRNT_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("#if (${ofc_cd} != 'All') " ).append("\n"); 
		query.append(" AND N2ND_PRNT_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY OFC_CD" ).append("\n"); 

	}
}