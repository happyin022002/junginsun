/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationDBDAOSearchZeroSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOSearchZeroSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FACCommCalculationDBDAOSearchZeroSumRSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOSearchZeroSumRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOSearchZeroSumRSQL").append("\n"); 
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
		query.append("  CASE " ).append("\n"); 
		query.append("  WHEN EXISTS " ).append("\n"); 
		query.append("     ( " ).append("\n"); 
		query.append("           SELECT " ).append("\n"); 
		query.append("                  1 " ).append("\n"); 
		query.append("             FROM ACM_FF_CMPN FF " ).append("\n"); 
		query.append("            WHERE FF.BKG_NO      = BKG.BKG_NO " ).append("\n"); 
		query.append("              AND FF_CMPN_STS_CD " ).append("\n"); 
		query.append("               IN " ).append("\n"); 
		query.append("                ( " ).append("\n"); 
		query.append("                  'CS', 'CM', 'CE', 'CA', 'IC' " ).append("\n"); 
		query.append("                ) " ).append("\n"); 
		query.append("     ) " ).append("\n"); 
		query.append("  THEN 1 " ).append("\n"); 
		query.append("  ELSE 0 " ).append("\n"); 
		query.append("   END                                            AS FF_STEP_ROW, " ).append("\n"); 
		query.append("       NVL " ).append("\n"); 
		query.append("     ( " ).append("\n"); 
		query.append("     ( " ).append("\n"); 
		query.append("           SELECT " ).append("\n"); 
		query.append("                  SUM (FF.IF_AMT) " ).append("\n"); 
		query.append("             FROM ACM_FF_CMPN FF " ).append("\n"); 
		query.append("            WHERE FF.BKG_NO       = BKG.BKG_NO " ).append("\n"); 
		query.append("              AND FF_CMPN_STS_CD = 'IF' " ).append("\n"); 
		query.append("     ) " ).append("\n"); 
		query.append("     , 0 " ).append("\n"); 
		query.append("     )                                            AS FF_ZERO_SUM, " ).append("\n"); 
		query.append("  CASE " ).append("\n"); 
		query.append("  WHEN EXISTS " ).append("\n"); 
		query.append("     ( " ).append("\n"); 
		query.append("           SELECT " ).append("\n"); 
		query.append("                  1 " ).append("\n"); 
		query.append("             FROM ACM_AGN_COMM AGN " ).append("\n"); 
		query.append("            WHERE AGN.BKG_NO     = BKG.BKG_NO " ).append("\n"); 
		query.append("              AND AC_STS_CD " ).append("\n"); 
		query.append("               IN " ).append("\n"); 
		query.append("                ( " ).append("\n"); 
		query.append("                  'CS', 'CM', 'CE', 'CA', 'IC' " ).append("\n"); 
		query.append("                ) " ).append("\n"); 
		query.append("     ) " ).append("\n"); 
		query.append("  THEN 1 " ).append("\n"); 
		query.append("  ELSE 0 " ).append("\n"); 
		query.append("   END                                            AS AGN_STEP_ROW, " ).append("\n"); 
		query.append("       NVL " ).append("\n"); 
		query.append("     ( " ).append("\n"); 
		query.append("     ( " ).append("\n"); 
		query.append("           SELECT " ).append("\n"); 
		query.append("                  SUM (AGN.IF_AMT) " ).append("\n"); 
		query.append("             FROM ACM_AGN_COMM AGN " ).append("\n"); 
		query.append("            WHERE AGN.BKG_NO     = BKG.BKG_NO " ).append("\n"); 
		query.append("              AND AGN.AC_STS_CD " ).append("\n"); 
		query.append("               IN " ).append("\n"); 
		query.append("                ( " ).append("\n"); 
		query.append("                  'RS', 'RM', 'AS', 'IF' " ).append("\n"); 
		query.append("                ) " ).append("\n"); 
		query.append("     ) " ).append("\n"); 
		query.append("     , 0 " ).append("\n"); 
		query.append("     )                                            AS AGN_ZERO_SUM " ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG " ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}