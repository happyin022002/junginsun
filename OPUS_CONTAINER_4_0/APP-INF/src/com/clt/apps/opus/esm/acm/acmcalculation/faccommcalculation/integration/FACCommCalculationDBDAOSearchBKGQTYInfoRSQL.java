/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationDBDAOSearchBKGQTYInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.13
*@LastModifier :
*@LastVersion : 1.0
* 2012.06.13
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOSearchBKGQTYInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * FACCommCalculationDBDAOSearchBKGQTYInfoRSQL
	  * </pre>
	  */
	public FACCommCalculationDBDAOSearchBKGQTYInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.integration").append("\n");
		query.append("FileName : FACCommCalculationDBDAOSearchBKGQTYInfoRSQL").append("\n");
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
		query.append("SELECT 	" ).append("\n");
		query.append("           NVL(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', DECODE(SUBSTR(CNTR_TPSZ_CD, 1, 1), 'D', OP_CNTR_QTY, 0), 0)), 0) BKG_DRY_TEU_QTY," ).append("\n");
		query.append("           NVL(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 0, DECODE(SUBSTR(CNTR_TPSZ_CD, 1, 1), 'D', OP_CNTR_QTY, 0))), 0) BKG_DRY_FEU_QTY," ).append("\n");
		query.append("           NVL(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', OP_CNTR_QTY, 0), 0)), 0) BKG_RF_TEU_QTY," ).append("\n");
		query.append("           NVL(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 0, OP_CNTR_QTY), 0)), 0) BKG_RF_FEU_QTY," ).append("\n");
		query.append("           NVL(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 1, 1), 'Q', 0, OP_CNTR_QTY)),0) BKG_BX_QTY," ).append("\n");
		query.append("           NVL(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', DECODE(SUBSTR(CNTR_TPSZ_CD, 1, 1), 'R', 0, 'D', 0, 'Q', 0, OP_CNTR_QTY),0)), 0) BKG_SPCL_TEU_QTY," ).append("\n");
		query.append("           NVL(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD, 2, 1), '2', 0, DECODE(SUBSTR(CNTR_TPSZ_CD, 1, 1), 'R', 0, 'D', 0, 'Q', 0, OP_CNTR_QTY))), 0) BKG_SPCL_FEU_QTY 	" ).append("\n");
		query.append("      FROM BKG_QUANTITY QTY 	" ).append("\n");
		query.append(" WHERE QTY.BKG_NO 	" ).append("\n");
		query.append("        IN 	" ).append("\n");
		query.append("         ( 	" ).append("\n");
		query.append("               SELECT 	" ).append("\n");
		query.append("                      DOC.BKG_NO 	" ).append("\n");
		query.append("                 FROM BKG_BL_DOC  DOC, 	" ).append("\n");
		query.append("                      BKG_BOOKING BKG, 	" ).append("\n");
		query.append("                      BKG_BOOKING BK2 	" ).append("\n");
		query.append("                WHERE 	" ).append("\n");
		query.append("                    ( 	" ).append("\n");
		query.append("                      BKG.BKG_NO                   = DOC.BKG_NO 	" ).append("\n");
		query.append("                   OR 	" ).append("\n");
		query.append("                      BKG.BL_NO                    = DOC.MST_CVRD_BL_NO 	" ).append("\n");
		query.append("                    ) 	" ).append("\n");
		query.append("                  AND BK2.BKG_NO                   = DOC.BKG_NO 	" ).append("\n");
		query.append("                  AND BK2.BL_NO_TP               <>  '9' 	" ).append("\n");
		query.append("                  AND BK2.BKG_STS_CD             <>  'X' 	" ).append("\n");
		query.append("                  AND BKG.BKG_NO                   = @[bkg_no]" ).append("\n");
		query.append("         ) 	" ).append("\n");
		query.append("       AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n");

	}
}