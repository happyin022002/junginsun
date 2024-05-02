/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BlRatingDBDAOSearchPpdChgAmtFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchPpdChgAmtFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOSearchPpdChgAmtFlgRSQL
	  * </pre>
	  */
	public BlRatingDBDAOSearchPpdChgAmtFlgRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchPpdChgAmtFlgRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.USD_CHG_AMT_AFTER - B.USD_CHG_AMT_BEFORE, 0, 'N', 'Y') PPD_CHG_AMT_FLG" ).append("\n"); 
		query.append("FROM  " ).append("\n"); 
		query.append("(SELECT BKG_NO, MAX(USD_CHG_AMT) USD_CHG_AMT_AFTER" ).append("\n"); 
		query.append(" FROM   (" ).append("\n"); 
		query.append("            SELECT CHG1.BKG_NO, SUM(ROUND(CHG_AMT/USD_LOCL_XCH_RT,2)) USD_CHG_AMT" ).append("\n"); 
		query.append("            FROM   INV_BKG_IF_CHG CHG1," ).append("\n"); 
		query.append("                   GL_MON_XCH_RT GMR" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND    GMR.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("            AND    GMR.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("            AND    GMR.CURR_CD = CHG1.CURR_CD" ).append("\n"); 
		query.append("            AND    CHG1.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("            AND    CHG1.BKG_SEQ = (SELECT MAX(BKG_SEQ) " ).append("\n"); 
		query.append("                                   FROM   INV_BKG_IF_MN " ).append("\n"); 
		query.append("                                   WHERE  BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("            AND    CHG1.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("            AND    CHG1.OFC_CD = (SELECT NVL(PPD_RCV_OFC_CD,'')" ).append("\n"); 
		query.append("                                  FROM   BKG_RATE" ).append("\n"); 
		query.append("                                  WHERE  BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("            GROUP BY CHG1.BKG_NO" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT @[bkg_no], 0 FROM DUAL" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" GROUP BY BKG_NO" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(SELECT BKG_NO, MAX(USD_CHG_AMT) USD_CHG_AMT_BEFORE" ).append("\n"); 
		query.append(" FROM   (" ).append("\n"); 
		query.append("            SELECT CHG1.BKG_NO, SUM(ROUND(CHG_AMT/USD_LOCL_XCH_RT,2)) USD_CHG_AMT" ).append("\n"); 
		query.append("            FROM   INV_BKG_IF_CHG CHG1," ).append("\n"); 
		query.append("                   GL_MON_XCH_RT GMR" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND    GMR.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE, 'YYYYMM')" ).append("\n"); 
		query.append("            AND    GMR.ACCT_XCH_RT_LVL = 1" ).append("\n"); 
		query.append("            AND    GMR.CURR_CD = CHG1.CURR_CD" ).append("\n"); 
		query.append("            AND    CHG1.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("            AND    CHG1.BKG_SEQ = (SELECT MAX(BKG_SEQ)-1 " ).append("\n"); 
		query.append("                                   FROM   INV_BKG_IF_MN " ).append("\n"); 
		query.append("                                   WHERE  BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("            AND    CHG1.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("            AND    CHG1.OFC_CD = (SELECT NVL(PPD_RCV_OFC_CD,'')" ).append("\n"); 
		query.append("                                  FROM   BKG_RATE" ).append("\n"); 
		query.append("                                  WHERE  BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("            GROUP BY CHG1.BKG_NO" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT @[bkg_no], 0 FROM DUAL" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" GROUP BY BKG_NO" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 

	}
}