/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCommCalculationDBDAOSearchCalcFFCommCSInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.22 
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

public class FFCommCalculationDBDAOSearchCalcFFCommCSInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FFCommCalculationDBDAOSearchCalcFFCommCSInfoRSQL
	  * </pre>
	  */
	public FFCommCalculationDBDAOSearchCalcFFCommCSInfoRSQL(){
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
		query.append("FileName : FFCommCalculationDBDAOSearchCalcFFCommCSInfoRSQL").append("\n"); 
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
		query.append("       NVL(SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', QTY.OP_CNTR_QTY, 0)), 0) FF_TEU_QTY, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', 0, QTY.OP_CNTR_QTY)), 0) FF_FEU_QTY " ).append("\n"); 
		query.append("  FROM BKG_QUANTITY QTY" ).append("\n"); 
		query.append(" WHERE QTY.BKG_NO " ).append("\n"); 
		query.append("        IN " ).append("\n"); 
		query.append("         ( " ).append("\n"); 
		query.append("               SELECT " ).append("\n"); 
		query.append("                      DOC.BKG_NO " ).append("\n"); 
		query.append("                 FROM BKG_BL_DOC  DOC, " ).append("\n"); 
		query.append("                      BKG_BOOKING BKG, " ).append("\n"); 
		query.append("                      BKG_BOOKING BK2 " ).append("\n"); 
		query.append("                WHERE " ).append("\n"); 
		query.append("                    ( " ).append("\n"); 
		query.append("                      BKG.BKG_NO                  = DOC.BKG_NO " ).append("\n"); 
		query.append("                   OR " ).append("\n"); 
		query.append("                      BKG.BL_NO                   = DOC.MST_CVRD_BL_NO " ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("                  AND BK2.BKG_NO                  = DOC.BKG_NO " ).append("\n"); 
		query.append("                  AND BK2.BL_NO_TP              <>  '9' " ).append("\n"); 
		query.append("                  AND BK2.BKG_STS_CD            <>  'X' " ).append("\n"); 
		query.append("                  AND BKG.BKG_NO                  =  @[bkg_no]" ).append("\n"); 
		query.append("         ) " ).append("\n"); 
		query.append("       AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' " ).append("\n"); 

	}
}