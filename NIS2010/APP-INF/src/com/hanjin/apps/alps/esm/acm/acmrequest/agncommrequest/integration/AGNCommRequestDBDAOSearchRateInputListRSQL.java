/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommRequestDBDAOSearchRateInputListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.09
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.10.09 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOSearchRateInputListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AGNCommRequestDBDAOSearchRateInputListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOSearchRateInputListRSQL").append("\n"); 
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
		query.append("       A.BKG_NO," ).append("\n"); 
		query.append("       A.AGN_CD," ).append("\n"); 
		query.append("       A.IO_BND_CD," ).append("\n"); 
		query.append("       A.AC_SEQ," ).append("\n"); 
		query.append("       CASE " ).append("\n"); 
		query.append("         WHEN A.CURR_CD = 'USD' THEN 1" ).append("\n"); 
		query.append("         WHEN A.XCH_RT_APLY_LVL = '1' THEN" ).append("\n"); 
		query.append("            NVL(" ).append("\n"); 
		query.append("             (NVL" ).append("\n"); 
		query.append("               (NVL((SELECT X.INV_XCH_RT" ).append("\n"); 
		query.append("                       FROM INV_VVD_XCH_RT X" ).append("\n"); 
		query.append("                      WHERE X.VSL_CD = A.AC_VSL_CD" ).append("\n"); 
		query.append("                        AND X.SKD_VOY_NO = A.AC_SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND X.SKD_DIR_CD = A.AC_SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND X.SVC_SCP_CD IN (NVL(B.SVC_SCP_CD, 'OTH'))" ).append("\n"); 
		query.append("                        AND X.IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                        AND X.PORT_CD = A.AC_OCCR_INFO_CD" ).append("\n"); 
		query.append("                        AND X.LOCL_CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("                        AND X.CHG_CURR_CD = 'USD')," ).append("\n"); 
		query.append("                    (SELECT X.INV_XCH_RT" ).append("\n"); 
		query.append("                       FROM INV_VVD_XCH_RT X" ).append("\n"); 
		query.append("                      WHERE X.VSL_CD = A.AC_VSL_CD" ).append("\n"); 
		query.append("                        AND X.SKD_VOY_NO = A.AC_SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND X.SKD_DIR_CD = A.AC_SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND X.SVC_SCP_CD IN ('OTH')" ).append("\n"); 
		query.append("                        AND X.IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                        AND X.PORT_CD = A.AC_OCCR_INFO_CD" ).append("\n"); 
		query.append("                        AND X.LOCL_CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("                        AND X.CHG_CURR_CD = 'USD'))," ).append("\n"); 
		query.append("                NVL((SELECT X.INV_XCH_RT" ).append("\n"); 
		query.append("                       FROM INV_VVD_XCH_RT X , BKG_VVD V" ).append("\n"); 
		query.append("                      WHERE X.VSL_CD = SUBSTR(B.REV_VVD_CD,1,4)" ).append("\n"); 
		query.append("                        AND X.SKD_VOY_NO = SUBSTR(B.REV_VVD_CD,5,4)" ).append("\n"); 
		query.append("                        AND X.SKD_DIR_CD = SUBSTR(B.REV_VVD_CD,9,1)" ).append("\n"); 
		query.append("                        AND X.SVC_SCP_CD IN (NVL(B.SVC_SCP_CD, 'OTH'))" ).append("\n"); 
		query.append("                        AND V.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                        AND X.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                        AND X.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND X.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND X.IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                        AND X.PORT_CD = CASE WHEN A.IO_BND_CD = 'O' THEN V.POL_CD" ).append("\n"); 
		query.append("                                             WHEN A.IO_BND_CD = 'I' THEN V.POD_CD" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                        AND X.LOCL_CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("                        AND X.CHG_CURR_CD  = 'USD')," ).append("\n"); 
		query.append("                    (SELECT X.INV_XCH_RT" ).append("\n"); 
		query.append("                       FROM INV_VVD_XCH_RT X , BKG_VVD V" ).append("\n"); 
		query.append("                      WHERE X.VSL_CD = SUBSTR(B.REV_VVD_CD,1,4)" ).append("\n"); 
		query.append("                        AND X.SKD_VOY_NO = SUBSTR(B.REV_VVD_CD,5,4)" ).append("\n"); 
		query.append("                        AND X.SKD_DIR_CD = SUBSTR(B.REV_VVD_CD,9,1)" ).append("\n"); 
		query.append("                        AND V.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                        AND X.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("                        AND X.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND X.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND X.SVC_SCP_CD IN ('OTH')" ).append("\n"); 
		query.append("                        AND X.IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                        AND X.PORT_CD = CASE WHEN A.IO_BND_CD = 'O' THEN V.POL_CD" ).append("\n"); 
		query.append("                                             WHEN A.IO_BND_CD = 'I' THEN V.POD_CD" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                        AND X.LOCL_CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("                        AND X.CHG_CURR_CD = 'USD')))" ).append("\n"); 
		query.append("            ),0)" ).append("\n"); 
		query.append("         WHEN A.XCH_RT_APLY_LVL = '2' THEN" ).append("\n"); 
		query.append("            NVL((SELECT USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("                   FROM GL_MON_XCH_RT B " ).append("\n"); 
		query.append("                  WHERE CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("                    AND ACCT_XCH_RT_LVL   = '1' " ).append("\n"); 
		query.append("                    AND ACCT_XCH_RT_YRMON = " ).append("\n"); 
		query.append("                       (CASE " ).append("\n"); 
		query.append("                           WHEN SUBSTR( A.SAIL_ARR_DT, 1, 6) > TO_CHAR (SYSDATE, 'YYYYMM') " ).append("\n"); 
		query.append("                           THEN TO_CHAR(ADD_MONTHS(TO_DATE(SUBSTR( A.SAIL_ARR_DT, 1, 6), 'YYYYMM'), -1),'YYYYMM') " ).append("\n"); 
		query.append("                           ELSE SUBSTR( A.SAIL_ARR_DT, 1, 6) " ).append("\n"); 
		query.append("                        END))," ).append("\n"); 
		query.append("                0) " ).append("\n"); 
		query.append("         WHEN A.XCH_RT_APLY_LVL = '3' THEN" ).append("\n"); 
		query.append("            NVL((SELECT INV_XCH_RT" ).append("\n"); 
		query.append("                   FROM INV_CUST_AND_DLY_XCH_RT" ).append("\n"); 
		query.append("                  WHERE CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("                    AND CUST_SEQ = 0" ).append("\n"); 
		query.append("                    AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                    AND FM_DT >= SUBSTR (A.SAIL_ARR_DT, 0, 8)" ).append("\n"); 
		query.append("                    AND TO_DT <= SUBSTR (A.SAIL_ARR_DT, 0, 8)" ).append("\n"); 
		query.append("                    AND CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("                    AND LOCL_CURR_CD = A.CURR_CD)," ).append("\n"); 
		query.append("                0) " ).append("\n"); 
		query.append("         WHEN A.XCH_RT_APLY_LVL = '4' THEN" ).append("\n"); 
		query.append("            NVL((SELECT FX_CURR_RT" ).append("\n"); 
		query.append("                   FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                  WHERE OFC_CD = @[agn_cd])," ).append("\n"); 
		query.append("                0) " ).append("\n"); 
		query.append("      END AS PAY_XCH_RT" ).append("\n"); 
		query.append("  FROM ACM_AGN_COMM A," ).append("\n"); 
		query.append("       ACM_AGN_BKG_INFO B" ).append("\n"); 
		query.append(" WHERE A.BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.AGN_CD    = @[agn_cd]" ).append("\n"); 
		query.append("   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND A.AC_SEQ    = @[ac_seq]" ).append("\n"); 
		query.append("   AND A.AC_STS_CD = 'CS'" ).append("\n"); 
		query.append("   AND A.BKG_NO    = B.BKG_NO" ).append("\n"); 

	}
}