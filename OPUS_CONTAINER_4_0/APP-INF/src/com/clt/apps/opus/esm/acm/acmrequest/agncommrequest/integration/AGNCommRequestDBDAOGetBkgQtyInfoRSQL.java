/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AGNCommRequestDBDAOGetBkgQtyInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOGetBkgQtyInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetBkgQtyInfo
	  * </pre>
	  */
	public AGNCommRequestDBDAOGetBkgQtyInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOGetBkgQtyInfoRSQL").append("\n"); 
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
		query.append("       NVL(SUM(QTY.OP_CNTR_QTY), 0) AS BOX ," ).append("\n"); 
		query.append("       NVL(SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 1, 1), 'R', 0, QTY.OP_CNTR_QTY), 0)), 0) AS TEU, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', 0, DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 1, 1), 'R', 0, QTY.OP_CNTR_QTY))), 0) AS FEU, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 1, 1), 'R', QTY.OP_CNTR_QTY, 0)), 0)                                                 AS RBOX, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', QTY.OP_CNTR_QTY, 0), 0)), 0) AS RTEU, " ).append("\n"); 
		query.append("       NVL(SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 1, 1), 'R', DECODE(SUBSTR(QTY.CNTR_TPSZ_CD, 2, 1), '2', 0, QTY.OP_CNTR_QTY), 0)), 0) AS RFEU" ).append("\n"); 
		query.append("  FROM BKG_QUANTITY QTY, BKG_BOOKING BKG " ).append("\n"); 
		query.append("-- WHERE QTY.BKG_NO = v_bkg_no --> only Master" ).append("\n"); 
		query.append(" WHERE QTY.BKG_NO IN (SELECT DISTINCT BKG_NO " ).append("\n"); 
		query.append("                      FROM  BKG_BL_DOC " ).append("\n"); 
		query.append("                      WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                        OR (BL_CVRD_TP_CD = 'C' AND MST_CVRD_BL_NO = @[bkg_no] )" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("   AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("   AND QTY.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND BKG.BL_NO_TP   <> '9'" ).append("\n"); 

	}
}