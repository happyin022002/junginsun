/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSimulationDBDAOGetRtAplyDtInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.12
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.12.12 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOGetRtAplyDtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetRtAplyDtInfo
	  * 부킹의 RT_APLY_DT 를 구함
	  * </pre>
	  */
	public ACMSimulationDBDAOGetRtAplyDtInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration ").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOGetRtAplyDtInfoRSQL").append("\n"); 
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
		query.append("CASE " ).append("\n"); 
		query.append("    WHEN R.RT_APLY_DT IS NOT NULL " ).append("\n"); 
		query.append("    THEN TO_CHAR (LEAST (R.RT_APLY_DT, SYSDATE), 'YYYYMMDD') " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    WHEN R.RT_APLY_DT IS NULL " ).append("\n"); 
		query.append("        AND " ).append("\n"); 
		query.append("          ( " ).append("\n"); 
		query.append("            SELECT NVL (SUM (CNTR_VOL_QTY), 0) " ).append("\n"); 
		query.append("            FROM   BKG_CONTAINER BCN " ).append("\n"); 
		query.append("            WHERE  BCN.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("          ) " ).append("\n"); 
		query.append("          = " ).append("\n"); 
		query.append("          ( " ).append("\n"); 
		query.append("            SELECT NVL (SUM (QTY.OP_CNTR_QTY), 0) " ).append("\n"); 
		query.append("            FROM   BKG_QUANTITY QTY " ).append("\n"); 
		query.append("            WHERE  QTY.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("            AND    QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' " ).append("\n"); 
		query.append("          ) " ).append("\n"); 
		query.append("        AND(SUBSTR (B.POR_CD, 1, 2) = 'US' " ).append("\n"); 
		query.append("         OR SUBSTR (B.POR_CD, 1, 2) = 'MX' " ).append("\n"); 
		query.append("         OR SUBSTR (B.POR_CD, 1, 2) = 'CA' " ).append("\n"); 
		query.append("         OR SUBSTR (B.POR_CD, 1, 2) = 'BR' " ).append("\n"); 
		query.append("         OR SUBSTR (B.DEL_CD, 1, 2) = 'US' " ).append("\n"); 
		query.append("         OR SUBSTR (B.DEL_CD, 1, 2) = 'MX' " ).append("\n"); 
		query.append("         OR SUBSTR (B.DEL_CD, 1, 2) = 'CA' " ).append("\n"); 
		query.append("         OR SUBSTR (B.DEL_CD, 1, 2) = 'BR')" ).append("\n"); 
		query.append("    THEN " ).append("\n"); 
		query.append("      ( " ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("          CASE " ).append("\n"); 
		query.append("              WHEN MAX (BCN.CGO_RCV_DT) IS NULL " ).append("\n"); 
		query.append("              THEN TO_CHAR (SYSDATE, 'YYYYMMDD') " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              ELSE TO_CHAR (LEAST (MAX (BCN.CGO_RCV_DT), SYSDATE), 'YYYYMMDD') " ).append("\n"); 
		query.append("          END  RT_APLY_DT " ).append("\n"); 
		query.append("         FROM  BKG_CONTAINER BCN " ).append("\n"); 
		query.append("         WHERE BCN.BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("      ) " ).append("\n"); 
		query.append("    ELSE " ).append("\n"); 
		query.append("      ( " ).append("\n"); 
		query.append("        SELECT TO_CHAR (LEAST (MAX (S.INIT_ETD_DT), SYSDATE), 'YYYYMMDD') " ).append("\n"); 
		query.append("          FROM BKG_VVD          V, " ).append("\n"); 
		query.append("               VSK_VSL_PORT_SKD S " ).append("\n"); 
		query.append("         WHERE V.BKG_NO       = B.BKG_NO " ).append("\n"); 
		query.append("           AND V.POL_CD       = B.POL_CD " ).append("\n"); 
		query.append("           AND V.VSL_CD       = S.VSL_CD " ).append("\n"); 
		query.append("           AND V.SKD_VOY_NO   = S.SKD_VOY_NO " ).append("\n"); 
		query.append("           AND V.SKD_DIR_CD   = S.SKD_DIR_CD " ).append("\n"); 
		query.append("           AND V.POL_CD       = S.VPS_PORT_CD " ).append("\n"); 
		query.append("      ) " ).append("\n"); 
		query.append("    END AS RT_APLY_DT " ).append("\n"); 
		query.append("FROM BKG_BOOKING B, " ).append("\n"); 
		query.append("     BKG_RATE    R " ).append("\n"); 
		query.append("WHERE B.BKG_NO = R.BKG_NO " ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}