/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CsScreenDBDAOsearchQtyForCntrByTpszRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.20
*@LastModifier : 윤한
*@LastVersion : 1.0
* 2010.05.20 윤한
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchQtyForCntrByTpszRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inbound C/S Screen 화면의 TP/SZ, BKG Q'TY, CNTR QTY를 List로 조회한다.
	  * </pre>
	  */
	public CsScreenDBDAOsearchQtyForCntrByTpszRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchQtyForCntrByTpszRSQL").append("\n"); 
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
		query.append("SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,ltrim(to_char(SUM(BKG_QTY), '99,999,90.99'))      AS BKG_QTY" ).append("\n"); 
		query.append("      ,ltrim(to_char(SUM(ACT_CNTR_QTY), '99,999,90.99')) AS CNTR_QTY" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT DISTINCT CNTR_TPSZ_CD               AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          ,0                                   AS BKG_QTY" ).append("\n"); 
		query.append("          ,to_number(SUM(NVL(CNTR_VOL_QTY,0))) AS ACT_CNTR_QTY " ).append("\n"); 
		query.append("    FROM BKG_CONTAINER" ).append("\n"); 
		query.append("    WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("    GROUP BY  BKG_NO,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    UNION " ).append("\n"); 
		query.append("    SELECT DISTINCT CNTR_TPSZ_CD               AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          ,to_number(NVL(OP_CNTR_QTY,0))       AS BKG_QTY" ).append("\n"); 
		query.append("          ,0                                   AS ACT_CNTR_QTY " ).append("\n"); 
		query.append("    FROM BKG_QUANTITY  " ).append("\n"); 
		query.append("    WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("    ORDER BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD  " ).append("\n"); 
		query.append("ORDER BY CNTR_TPSZ_CD " ).append("\n"); 

	}
}