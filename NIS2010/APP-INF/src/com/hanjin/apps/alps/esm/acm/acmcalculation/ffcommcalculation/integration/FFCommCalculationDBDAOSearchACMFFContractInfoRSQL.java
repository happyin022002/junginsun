/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCommCalculationDBDAOSearchACMFFContractInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.ffcommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCommCalculationDBDAOSearchACMFFContractInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FFCommCalculationDBDAOSearchACMFFContractInfoRSQL
	  * </pre>
	  */
	public FFCommCalculationDBDAOSearchACMFFContractInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.ffcommcalculation.integration").append("\n"); 
		query.append("FileName : FFCommCalculationDBDAOSearchACMFFContractInfoRSQL").append("\n"); 
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
		query.append("SELECT 					" ).append("\n"); 
		query.append("           NVL (PPD_RCV_OFC_CD, ' ')                                             AS PPD_OFC_CD, 					" ).append("\n"); 
		query.append("           NVL (CLT_OFC_CD, ' ')                                                 AS CLT_OFC_CD, 					" ).append("\n"); 
		query.append("           NVL (PPD_PAYR_CNT_CD || TO_CHAR (PPD_PAYR_CUST_SEQ, 'FM000000'), ' ') AS PPAYR_CNT_CD, 					" ).append("\n"); 
		query.append("      CASE 					" ).append("\n"); 
		query.append("      WHEN RAT.CGO_RCV_DT IS NOT NULL 					" ).append("\n"); 
		query.append("        OR RAT.CGO_RCV_DT = '' 					" ).append("\n"); 
		query.append("        OR RAT.CGO_RCV_DT = ' ' 					" ).append("\n"); 
		query.append("      THEN TO_CHAR (RAT.CGO_RCV_DT, 'YYYYMMDDHH24MISS') 					" ).append("\n"); 
		query.append("      WHEN SUBSTR (BKG.POR_CD, 1, 2) = 'US' 					" ).append("\n"); 
		query.append("        OR SUBSTR (BKG.POL_CD, 1, 2) = 'US' 					" ).append("\n"); 
		query.append("        OR SUBSTR (BKG.POD_CD, 1, 2) = 'US' 					" ).append("\n"); 
		query.append("        OR SUBSTR (BKG.DEL_CD, 1, 2) = 'US' 					" ).append("\n"); 
		query.append("      THEN 					" ).append("\n"); 
		query.append("         ( 					" ).append("\n"); 
		query.append("               SELECT 					" ).append("\n"); 
		query.append("                      TO_CHAR (NVL (RAT.RT_APLY_DT, SKD.VPS_ETD_DT), 'YYYYMMDDHH24MISS') 					" ).append("\n"); 
		query.append("                 FROM BKG_VVD          VVD, 					" ).append("\n"); 
		query.append("                      VSK_VSL_PORT_SKD SKD 					" ).append("\n"); 
		query.append("                WHERE VVD.BKG_NO     = BKG.BKG_NO 					" ).append("\n"); 
		query.append("                  AND VVD.POL_CD     = BKG.POL_CD 					" ).append("\n"); 
		query.append("                  AND VVD.VSL_CD     = SKD.VSL_CD 					" ).append("\n"); 
		query.append("                  AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO 					" ).append("\n"); 
		query.append("                  AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD 					" ).append("\n"); 
		query.append("                  AND VVD.POL_CD     = SKD.VPS_PORT_CD 					" ).append("\n"); 
		query.append("                  AND 'S'          <>  NVL (SKD.SKD_CNG_STS_CD, '*') 					" ).append("\n"); 
		query.append("                  AND ROWNUM         = 1 					" ).append("\n"); 
		query.append("         ) 					" ).append("\n"); 
		query.append("      ELSE 					" ).append("\n"); 
		query.append("         ( 					" ).append("\n"); 
		query.append("               SELECT 					" ).append("\n"); 
		query.append("                      TO_CHAR (NVL (SKD.VPS_ETD_DT, RAT.RT_APLY_DT), 'YYYYMMDDHH24MISS') 					" ).append("\n"); 
		query.append("                 FROM BKG_VVD          VVD, 					" ).append("\n"); 
		query.append("                      VSK_VSL_PORT_SKD SKD 					" ).append("\n"); 
		query.append("                WHERE VVD.BKG_NO     = BKG.BKG_NO 					" ).append("\n"); 
		query.append("                  AND VVD.POL_CD     = BKG.POL_CD 					" ).append("\n"); 
		query.append("                  AND VVD.VSL_CD     = SKD.VSL_CD 					" ).append("\n"); 
		query.append("                  AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO 					" ).append("\n"); 
		query.append("                  AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD 					" ).append("\n"); 
		query.append("                  AND VVD.POL_CD     = SKD.VPS_PORT_CD 					" ).append("\n"); 
		query.append("                  AND 'S'          <>  NVL (SKD.SKD_CNG_STS_CD, '*') 					" ).append("\n"); 
		query.append("                  AND ROWNUM         = 1 					" ).append("\n"); 
		query.append("         ) 					" ).append("\n"); 
		query.append("       END                                                                       AS CGO_RCV_DT, 					" ).append("\n"); 
		query.append("         ( 					" ).append("\n"); 
		query.append("               SELECT 					" ).append("\n"); 
		query.append("             DISTINCT BCR.N3PTY_RCV_OFC_CD 					" ).append("\n"); 
		query.append("                 FROM BKG_CHG_RT BCR 					" ).append("\n"); 
		query.append("                WHERE BCR.BKG_NO                = BKG.BKG_NO 					" ).append("\n"); 
		query.append("                  AND BCR.N3PTY_RCV_OFC_CD IS NOT NULL 					" ).append("\n"); 
		query.append("                  AND ROWNUM                    = 1 					" ).append("\n"); 
		query.append("         )                                                                       AS N3PTY_RCV_OFC_CD 					" ).append("\n"); 
		query.append("             FROM BKG_BOOKING  BKG, 					" ).append("\n"); 
		query.append("                  BKG_RATE     RAT 					" ).append("\n"); 
		query.append("            WHERE BKG.BKG_NO = RAT.BKG_NO 					" ).append("\n"); 
		query.append("              AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}