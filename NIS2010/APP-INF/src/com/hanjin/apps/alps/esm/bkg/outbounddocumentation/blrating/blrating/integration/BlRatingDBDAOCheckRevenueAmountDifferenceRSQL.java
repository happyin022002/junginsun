/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOCheckRevenueAmountDifferenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.02 
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

public class BlRatingDBDAOCheckRevenueAmountDifferenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이전에 산출한 Revenue와 현재 Revenue를 비교한다.
	  * </pre>
	  */
	public BlRatingDBDAOCheckRevenueAmountDifferenceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOCheckRevenueAmountDifferenceRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN 'N' = (SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("                        FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                        WHERE HRD_CDG_ID = 'CMPB_EXECUTE') THEN 'N'" ).append("\n"); 
		query.append("             ELSE DECODE(TO_NUMBER(@[rev_amt])  - " ).append("\n"); 
		query.append("               NVL((SELECT REV_AMT" ).append("\n"); 
		query.append("                    FROM BKG_REV_COST R" ).append("\n"); 
		query.append("                    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                    AND REV_COST_SEQ = (SELECT MAX(REV_COST_SEQ)" ).append("\n"); 
		query.append("                                        FROM BKG_REV_COST" ).append("\n"); 
		query.append("                                        WHERE BKG_NO = R.BKG_NO)),0)," ).append("\n"); 
		query.append("               0, 'N', 'Y') " ).append("\n"); 
		query.append("       END RESULT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}